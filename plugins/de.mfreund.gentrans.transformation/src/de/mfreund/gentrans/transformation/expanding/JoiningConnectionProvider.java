/**
 *
 */
package de.mfreund.gentrans.transformation.expanding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.tud.et.ifa.agtele.emf.connecting.AllowedReferenceType;
import de.tud.et.ifa.agtele.emf.connecting.Capacity;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathProvider;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathRequirement;
import de.tud.et.ifa.agtele.emf.connecting.Length;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionClass;

/**
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class JoiningConnectionProvider extends AbstractConnectionProvider implements ConnectionProvider {

	public JoiningConnectionProvider(TransformationAssetManager assetManager,
			EClassConnectionPathProvider eClassConnectionPathProvider) {

		super(assetManager, new LinkedHashMap<>(), eClassConnectionPathProvider);

	}

	@Override
	public AbstractConnection getConnectionFor() {

		// TODO Auto-generated method stub
		return null;
	}

	public List<EClassConnectionPathBasedConnection> selectConnectionsWithoutContainerSelector(
			final List<EObjectWrapper> rootInstances, InstantiableMappingHintGroup mappingGroup) {

		// Nothing to connect
		//
		if (rootInstances == null || rootInstances.isEmpty()) {
			return new ArrayList<>();
		}

		TargetSection section = mappingGroup.getTargetMMSectionGeneric();

		List<EObjectWrapper> containerInstances = targetSectionRegistry
				.getFlattenedPamtramClassInstances(section.getContainer());

		EClass classToConnect = section.getEClass();

		if (containerInstances.isEmpty() && section.getContainer() != null) {
			logger.warning(() -> "The TargetSection '" + section.getName() + "' specifies the "
					+ section.getContainer().eClass().getName() + " '" + section.getContainer().getName()
					+ "' as container. However, no instances of this " + section.getContainer().eClass().getName()
					+ " have been created.");
		}

		// Prevent circular containments
		//
		containerInstances.removeAll(rootInstances);

		// A set of ModelConnectionPaths that are possible and thus have to be considered by the selection algorithms.
		//
		Optional<Set<EClass>> containerClasses = section.getContainer() != null
				? Optional.of(Collections.singleton(section.getContainer().getEClass()))
				: Optional.empty();
		List<EClassConnectionPath> pathsToConsider = getModelConnectionPathsToConsider(rootInstances, containerClasses,
				classToConnect);

		// If no paths have been found, register the related elements as 'unconnectable' and return.
		//
		if (pathsToConsider.isEmpty()) {

			return new ArrayList<>();
		}

		// Map the possible container instances to the corresponding connection paths
		//
		Map<EClassConnectionPath, List<EObjectWrapper>> containerInstancesByConnectionPaths = new LinkedHashMap<>();
		for (EClassConnectionPath connectionPath : pathsToConsider) {
			List<EObjectWrapper> containerInstancesForConnectionPath = !containerInstances.isEmpty()
					? containerInstances.stream()
							.filter(c -> c.getEObject().eClass().equals(connectionPath.getStartingClass()))
							.collect(Collectors.toList())
					: targetSectionRegistry.getTargetClassInstances(connectionPath.getStartingClass());
			containerInstancesByConnectionPaths.put(connectionPath, containerInstancesForConnectionPath);
		}

		List<EClassConnectionPathBasedConnection> selectedConnections = selectConnections(rootInstances,
				containerInstancesByConnectionPaths, mappingGroup);

		return selectedConnections;
	}

	/**
	 * This returns the list of potential {@link ComplexEClassConnectionPath ModelConnectionPaths} that can be used to
	 * connect the given list of <em>rootInstances</em> to an instance of one of the given <em>containerClasses</em>.
	 *
	 * @param rootInstances
	 *            A list of {@link EObjectWrapper elements} to connect.
	 * @param containerClasses
	 *            An optional set of {@link EClass EClasses} that are considered as target when searching for connection
	 *            paths for the given list of 'rootInstances'.<br />
	 *            <em>Note:</em> If the optional is not present, any EClass will be considered a valid target.
	 * @param classToConnect
	 *            The {@link EClass} of the <em>rootInstances</em> to be connected.
	 * @return The list of {@link ComplexEClassConnectionPath ModelConnectionPaths} that can be used to connect the
	 *         given list of <em>rootInstances</em> to instances of one of the given <em>containerClasses</em>.
	 */
	private List<EClassConnectionPath> getModelConnectionPathsToConsider(final List<EObjectWrapper> rootInstances,
			final Optional<Set<EClass>> containerClasses, final EClass classToConnect) {

		List<EClassConnectionPath> pathsToConsider = new LinkedList<>();

		// FIXME in the config, 0 means direct connection; in Length, 0 means no connection
		int rawMaxPathLength = assetManager.getTransformationConfig().getMaxPathLength();
		Length maxPathLength = Length.valueOf(rawMaxPathLength == -1 ? rawMaxPathLength : rawMaxPathLength + 1);

		if (containerClasses.isPresent()) {
			// A list of possible 'containerClasses' has been passed as parameter so we need to restrict the list of
			// EClass that are considered when searching for connection paths.
			//
			pathsToConsider.addAll(containerClasses.get().stream().flatMap(
					c -> eClassConnectionPathProvider.getConnections(new EClassConnectionPathRequirement(classToConnect)
							.withRequiredStartingClass(c).withRequiredMaximumPathLength(maxPathLength)
							.withRequiredMinimumCapacity(Capacity.valueOf(rootInstances))
							.withAllowedReferenceType(AllowedReferenceType.CONTAINMENT)).stream())
					.collect(Collectors.toCollection(LinkedHashSet::new)));
		} else {

			pathsToConsider.addAll(eClassConnectionPathProvider.getConnections(
					new EClassConnectionPathRequirement(classToConnect).withRequiredMaximumPathLength(maxPathLength)
							.withRequiredMinimumCapacity(Capacity.valueOf(rootInstances))
							.withAllowedReferenceType(AllowedReferenceType.CONTAINMENT)));
		}

		// Remove those paths that would lead to cyclic containments
		//
		for (final EClassConnectionPath p : new LinkedList<>(pathsToConsider)) {

			List<EObject> possibleContainerInstances = targetSectionRegistry
					.getTargetClassInstances(pathsToConsider.iterator().next().getStartingClass()).parallelStream()
					.map(EObjectWrapper::getEObject).collect(Collectors.toList());

			List<EObject> rootInstancesToConnect = rootInstances.parallelStream().map(EObjectWrapper::getEObject)
					.collect(Collectors.toList());

			possibleContainerInstances.removeAll(rootInstancesToConnect);

			if (possibleContainerInstances.isEmpty() || possibleContainerInstances.stream()
					.anyMatch(c -> EcoreUtil.isAncestor(rootInstancesToConnect, c))) {
				pathsToConsider.remove(p);
			}
		}

		return pathsToConsider;
	}

	public List<EClassConnectionPathBasedConnection> selectConnectionsWithContainerSelector(
			MappingInstanceDescriptor mappingInstance, final List<EObjectWrapper> rootInstances,
			InstantiableMappingHintGroup mappingGroup) {

		List<ContainerSelector> containerSelectors = getActiveContainerSelectors(mappingInstance, mappingGroup);

		// Nothing to connect
		//
		if (rootInstances == null || rootInstances.isEmpty()) {
			return new ArrayList<>();
		}

		// All potential connection paths
		//
		Map<ContainerSelector, List<EClassConnectionPath>> connectionPathsByContainerSelector = getConnectionPathsByContainerSelector(
				containerSelectors, mappingGroup.getTargetMMSectionGeneric().getEClass());

		// All potential container instances
		//
		Map<ContainerSelector, List<EObjectWrapper>> containerInstancesByContainerSelector = getContainerInstancesByContainerSelector(
				new ArrayList<>(connectionPathsByContainerSelector.keySet()), mappingInstance);

		// None of the potential container instances matches one of the hint values
		//
		if (containerInstancesByContainerSelector.isEmpty()) {
			return new ArrayList<>();
		}

		// Discard those ContainerSelector for which there are no potential container instances
		//
		connectionPathsByContainerSelector = connectionPathsByContainerSelector.entrySet().stream()
				.filter(e -> containerInstancesByContainerSelector.containsKey(e.getKey()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));

		// Map the possible container instances to the corresponding connection paths
		//
		Map<EClassConnectionPath, List<EObjectWrapper>> containerInstancesByConnectionPaths = new LinkedHashMap<>();
		for (ContainerSelector containerSelector : connectionPathsByContainerSelector.keySet()) {
			for (EClassConnectionPath connectionPath : connectionPathsByContainerSelector.get(containerSelector)) {

				Set<EObjectWrapper> containerInstances = new LinkedHashSet<>(
						containerInstancesByConnectionPaths.getOrDefault(connectionPath, new ArrayList<>()));

				// As connection paths starting from different root EClasses may exist in case of ContainerSelectors
				// based on abstract TargetSections, we need to filter the fitting instances for each path separately
				//
				containerInstances.addAll(containerInstancesByContainerSelector.get(containerSelector).stream()
						.filter(i -> connectionPath.getStartingClass().equals(i.getEObject().eClass()))
						.collect(Collectors.toList()));
				if (!containerInstances.isEmpty()) {
					containerInstancesByConnectionPaths.put(connectionPath, new ArrayList<>(containerInstances));
				}
			}
		}

		if (containerInstancesByConnectionPaths.isEmpty()) {
			// No suitable container instances could be determined for any of the potential connection paths
			//
			return new ArrayList<>();
		}

		return selectConnections(rootInstances, containerInstancesByConnectionPaths, mappingGroup);
	}

	/**
	 * For each of the given {@link ContainerSelector ContainerSelectors}, determines the list of
	 * {@link ComplexEClassConnectionPath ModelConnectionPaths} that can be used to connect instances of the given
	 * {@link EClass} to instances of the {@link ContainerSelector#getTargetClass() targetClass} of the
	 * ContainerSelector.
	 * <p />
	 * Note: Those ContainerSelectors for that there is no possible ModelConnectionPath are not represented in the
	 * returned Map. Put another way, each of the values of the returned map will contain at least one
	 * ModelConnectionPath.
	 * <p />
	 * Note: Only direct {@link ComplexEClassConnectionPath connection paths} (with a length of '0') are considered
	 * because the user specified a {@link ContainerSelector}.
	 *
	 * @param containerSelectors
	 *            The list of {@link ContainerSelector ContainerSelectors} to evaluate.
	 * @param eClass
	 *            The {@link EClass} for which connection shall be determined.
	 * @return The list of potential {@link ComplexEClassConnectionPath ModelConnectionPaths} for each of the given
	 *         {@link ContainerSelector ContainerSelectors}.
	 */
	private Map<ContainerSelector, List<EClassConnectionPath>> getConnectionPathsByContainerSelector(
			List<ContainerSelector> containerSelectors, EClass eClass) {

		Map<ContainerSelector, List<EClassConnectionPath>> connectionPathsByContainerSelector = new LinkedHashMap<>();
		for (ContainerSelector containerSelector : containerSelectors) {

			List<TargetSectionClass> potentialTargetSectionClasses = containerSelector.getTargetClass()
					.getAllConcreteExtending();

			// Check if there are any possible connection paths based on the specified 'targetClass' of the given
			// container selector (or any of the concrete extending TargetSections)
			//
			List<EClassConnectionPath> pathsToConsider = potentialTargetSectionClasses.stream()
					.flatMap(t -> eClassConnectionPathProvider.getConnections(
							new EClassConnectionPathRequirement(eClass).withRequiredStartingClass(t.getEClass())
									.withRequiredMaximumPathLength(Length.DIRECT_CONNECTION)
									.withAllowedReferenceType(AllowedReferenceType.CONTAINMENT))
							.stream())
					.collect(Collectors.toList());

			if (pathsToConsider.isEmpty()) {

				logger.warning(() -> "Could not find a path that leads to the 'targetClass' specified for the "
						+ containerSelector.printInfo());

			} else {

				connectionPathsByContainerSelector.put(containerSelector, pathsToConsider);
			}
		}

		return connectionPathsByContainerSelector;
	}

	/**
	 * For each of the given {@link ContainerSelector ContainerSelectors}, determines the list of {@link EObjectWrapper
	 * container instances} satisfying at least one of the hint values for the given {@link MappingInstanceDescriptor}
	 * (a subset of all instantiated elements of the {@link ContainerSelector#getTargetClass() target class} specified
	 * by the respective ContainerSelector).
	 * <p />
	 * Note: Those ContainerSelectors for that there is no possible container instance are not represented in the
	 * returned Map. Put another way, each of the values of the returned map will contain at least one container
	 * instance.
	 *
	 * @param containerSelectors
	 *            The list of {@link ContainerSelector ContainerSelectors} to evaluate.
	 * @param mappingInstance
	 *            The {@link MappingInstanceDescriptor} providing the hint values for the given
	 *            <em>containerSelectors</em>.
	 * @return The list of potential {@link EObjectWrapper container instances} for each of the given
	 *         {@link ContainerSelector ContainerSelectors}.
	 */
	private Map<ContainerSelector, List<EObjectWrapper>> getContainerInstancesByContainerSelector(
			List<ContainerSelector> containerSelectors, MappingInstanceDescriptor mappingInstance) {

		Map<ContainerSelector, List<EObjectWrapper>> containerInstancesByContainerSelector = new LinkedHashMap<>();

		for (ContainerSelector containerSelector : containerSelectors) {

			// The instances of the specified 'targetClass' -> These are the potential containers
			//
			List<EObjectWrapper> possibleContainerInstances = targetSectionRegistry
					.getFlattenedPamtramClassInstances(containerSelector.getTargetClass());

			// Filter those that satisfy one of the calculated hint values
			//
			possibleContainerInstances = instanceSelectorHandler.filterTargetInstances(possibleContainerInstances,
					containerSelector, mappingInstance.getHintValues().getHintValues(containerSelector));

			if (!possibleContainerInstances.isEmpty()) {
				containerInstancesByContainerSelector.put(containerSelector, possibleContainerInstances);
			}
		}

		return containerInstancesByContainerSelector;
	}

	private List<ContainerSelector> getActiveContainerSelectors(MappingInstanceDescriptor mappingInstance,
			InstantiableMappingHintGroup hintGroup) {

		return mappingInstance.getMappingHints(hintGroup, true).stream().filter(ContainerSelector.class::isInstance)
				.map(ContainerSelector.class::cast).collect(Collectors.toList());
	}
}
