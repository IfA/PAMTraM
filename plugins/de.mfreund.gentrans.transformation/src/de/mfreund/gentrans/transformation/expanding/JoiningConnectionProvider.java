/**
 *
 */
package de.mfreund.gentrans.transformation.expanding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.mfreund.gentrans.transformation.CancelTransformationException;
import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.mfreund.gentrans.transformation.registries.TargetModelRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvedAdapter;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.tud.et.ifa.agtele.emf.connecting.AllowedReferenceType;
import de.tud.et.ifa.agtele.emf.connecting.Capacity;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathProvider;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathRequirement;
import de.tud.et.ifa.agtele.emf.connecting.Length;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionClass;

/**
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class JoiningConnectionProvider extends AbstractConnectionProvider {

	private List<ContainerSelector> currentContainerSelectors;

	private TargetModelRegistry targetModelRegistry;

	public JoiningConnectionProvider(TransformationAssetManager assetManager,
			EClassConnectionPathProvider eClassConnectionPathProvider) {

		super(assetManager, new LinkedHashMap<>(), eClassConnectionPathProvider);

		targetModelRegistry = assetManager.getTargetModelRegistry();

	}

	public List<JoiningConnection> determineConnectionsToJoinInstances(MappingInstanceDescriptor mappingInstance,
			List<EObjectWrapper> instancesToJoin, InstantiableMappingHintGroup mappingGroup) {

		if (instancesToJoin.isEmpty()) {
			return Collections.emptyList();
		}

		currentMappingInstanceDescriptor = mappingInstance;
		currentHintGroup = mappingGroup;
		currentInstancesToConnect = instancesToJoin;
		currentContainerSelectors = getActiveContainerSelectorsInCurrentHintGroup();

		if (shallInstancesBeAddedToTargetModelRoot()) {
			return determineConnectionsToJoinInstancesWithTargetModelRoot(instancesToJoin);

		} else if (currentContainerSelectors.isEmpty()) {
			return determineConnectionsWithoutContainerSelector();

		} else {
			return determineConnectionsWithContainerSelector();
		}

	}

	public List<JoiningConnection> determineConnectionsToJoinInstancesWithTargetModelRoot(
			List<EObjectWrapper> instancesToJoin) {

		return Arrays.asList(createConnectionToAddToTargetModelRoot(instancesToJoin));
	}

	private boolean shallInstancesBeAddedToTargetModelRoot() {

		return currentHintGroup.getTargetMMSectionGeneric().getFile() != null;
	}

	private JoiningConnection createConnectionToAddToTargetModelRoot(List<EObjectWrapper> instancesToJoin) {

		return new JoiningConnection(instancesToJoin, targetSectionRegistry, targetModelRegistry, logger);
	}

	private List<ContainerSelector> getActiveContainerSelectorsInCurrentHintGroup() {

		return currentMappingInstanceDescriptor.getMappingHints(currentHintGroup, true).stream()
				.filter(ContainerSelector.class::isInstance).map(ContainerSelector.class::cast)
				.collect(Collectors.toList());
	}

	private List<JoiningConnection> determineConnectionsWithoutContainerSelector() {

		TargetSection section = currentHintGroup.getTargetMMSectionGeneric();

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
		containerInstances.removeAll(currentInstancesToConnect);

		// A set of ModelConnectionPaths that are possible and thus have to be considered by the selection algorithms.
		//
		Optional<Set<EClass>> containerClasses = section.getContainer() != null
				? Optional.of(Collections.singleton(section.getContainer().getEClass()))
				: Optional.empty();
		List<EClassConnectionPath> pathsToConsider = getModelConnectionPathsToConsider(currentInstancesToConnect,
				containerClasses, classToConnect);

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

		return selectConnections(currentInstancesToConnect, containerInstancesByConnectionPaths, currentHintGroup);
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

	private List<JoiningConnection> determineConnectionsWithContainerSelector() {

		// All potential connection paths
		//
		Map<ContainerSelector, List<EClassConnectionPath>> connectionPathsByContainerSelector = getConnectionPathsByContainerSelector(
				currentContainerSelectors, currentHintGroup.getTargetMMSectionGeneric().getEClass());

		// All potential container instances
		//
		Map<ContainerSelector, List<EObjectWrapper>> containerInstancesByContainerSelector = getContainerInstancesByContainerSelector(
				new ArrayList<>(connectionPathsByContainerSelector.keySet()), currentMappingInstanceDescriptor);

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

		return selectConnections(currentInstancesToConnect, containerInstancesByConnectionPaths, currentHintGroup);
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

	private List<JoiningConnection> selectConnections(List<EObjectWrapper> targetElements,
			Map<EClassConnectionPath, List<EObjectWrapper>> connectionChoices,
			InstantiableMappingHintGroup mappingGroup) {

		// The list of Connections that will get instantiated in the end
		//
		List<JoiningConnection> selectedConnections = new ArrayList<>();

		// The list of (distinct) container instances represented by the 'connectionChoices'
		//
		List<EObjectWrapper> containerInstances = new ArrayList<>(connectionChoices.values().stream()
				.flatMap(List::stream).collect(Collectors.toCollection(LinkedHashSet::new)));

		if (containerInstances.size() == targetElements.size()) {
			// This is the special case where there is exactly one container instance per root instance -> We connect
			// each root instance to its own container instance if there is a connection path that can be used for each
			// container instance
			//

			// The set of connection choices that provide exactly as many container elements as root elements
			//
			Map<EClassConnectionPath, List<EObjectWrapper>> limitedConnectionChoices = connectionChoices.entrySet()
					.stream().filter(e -> e.getValue().size() == containerInstances.size())
					.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v2, LinkedHashMap::new));

			if (limitedConnectionChoices.isEmpty()) {
				// Fall back to the 'default' behavior (use the same container instance for each root instance)
				//
				selectedConnections.add(getConnectionToInstantiateBasedOnMultipleStartingElementPossibilities(
						targetElements, connectionChoices, mappingGroup));
			} else {
				// Create a distinct connection for each pair of container/root instances
				//
				Map<EObjectWrapper, EObjectWrapper> containerInstanceByRootInstance = IntStream
						.range(0, targetElements.size()).boxed().collect(Collectors.toMap(targetElements::get,
								containerInstances::get, (v1, v2) -> v2, LinkedHashMap::new));

				selectedConnections.addAll(containerInstanceByRootInstance.entrySet().stream()
						.map(e -> getConnectionToInstantiateBasedOnSingleStartingElementPossiblity(
								Arrays.asList(e.getKey()), new ArrayList<>(limitedConnectionChoices.keySet()),
								e.getValue(), mappingGroup))
						.collect(Collectors.toList()));
			}

		} else {
			// This is the default case where each root instance is connected to the same container instance
			//
			selectedConnections.add(getConnectionToInstantiateBasedOnMultipleStartingElementPossibilities(
					targetElements, connectionChoices, mappingGroup));
		}
		return selectedConnections;
	}

	private JoiningConnection getConnectionToInstantiateBasedOnMultipleStartingElementPossibilities(
			final List<EObjectWrapper> targetElements,
			Map<EClassConnectionPath, List<EObjectWrapper>> connectionChoices,
			InstantiableMappingHintGroup mappingGroup) {

		// If there is already a 'standardPath' for the given 'mappingGroup', we reuse this standard path
		//
		EClassConnectionPath standardPath = standardConnectionsForHintGroups.getOrDefault(mappingGroup, null);
		if (standardPath != null && connectionChoices.containsKey(standardPath) && connectionChoices.size() > 1) {

			return getConnectionToInstantiate(targetElements, standardPath, connectionChoices.get(standardPath),
					mappingGroup);
		}

		List<EClassConnectionPath> pathsWithoutInstances = connectionChoices.keySet().stream()
				.filter(p -> connectionChoices.get(p).isEmpty()).collect(Collectors.toList());
		if (pathsWithoutInstances.size() < connectionChoices.size()) {
			pathsWithoutInstances.stream().forEach(connectionChoices::remove);
		}

		if (connectionChoices.keySet().size() == 1
				&& connectionChoices.values().stream().flatMap(List::stream).collect(Collectors.toSet()).size() == 1) {

			// There is only one possible connection path and container instance
			//
			EClassConnectionPath connectionPath = connectionChoices.keySet().iterator().next();
			return getConnectionFor(connectionChoices.get(connectionPath).iterator().next(), targetElements,
					connectionPath, mappingGroup);

		} else if (connectionChoices.keySet().size() == 1) {

			// If there is only one possible connection path, we only need to let the user choose the
			// container instance
			//
			EClassConnectionPath connectionPath = connectionChoices.keySet().iterator().next();
			return getConnectionToInstantiate(targetElements, connectionPath, connectionChoices.get(connectionPath),
					mappingGroup);

		} else {

			EClassConnectionPath selectedConnectionPath;
			EObjectWrapper selectedContainerInstance;

			// There are multiple possible connection paths and/or container instances
			//
			try {
				logger.fine(TargetSectionJoiner.RESOLVE_JOINING_AMBIGUITY_STARTED);

				Map<EClassConnectionPath, List<EObjectWrapper>> resolved;
				if (connectionChoices.values().stream().flatMap(List::stream).collect(Collectors.toSet()).size() == 1) {
					// If there is only one possible container instance, we only need to let the user choose the
					// connection path
					//
					List<EClassConnectionPath> resolvedPaths = ambiguityResolvingStrategy.joiningSelectConnectionPath(
							new ArrayList<>(connectionChoices.keySet()), mappingGroup.getTargetMMSectionGeneric());
					resolved = resolvedPaths.stream()
							.collect(Collectors.toMap(Function.identity(), connectionChoices::get));
					selectedConnectionPath = resolvedPaths.get(0);
				} else {
					// Otherwise, the user needs to select the connection path as well as the container instance
					//
					resolved = ambiguityResolvingStrategy.joiningSelectConnectionPathAndContainerInstance(
							connectionChoices, mappingGroup.getTargetMMSectionGeneric(), targetElements,
							mappingGroup instanceof MappingHintGroupImporter
									? ((MappingHintGroupImporter) mappingGroup).getHintGroup()
									: (MappingHintGroupType) mappingGroup);
					selectedConnectionPath = resolved.entrySet().iterator().next().getKey();
				}

				selectedContainerInstance = resolved.entrySet().iterator().next().getValue().get(0);
				if (ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
					((IAmbiguityResolvedAdapter) ambiguityResolvingStrategy).joiningConnectionPathSelected(
							new ArrayList<>(connectionChoices.keySet()), selectedConnectionPath);
					((IAmbiguityResolvedAdapter) ambiguityResolvingStrategy).joiningContainerInstanceSelected(
							new ArrayList<>(connectionChoices.get(selectedConnectionPath)), selectedContainerInstance);
				}
				logger.fine(TargetSectionJoiner.RESOLVE_JOINING_AMBIGUITY_ENDED);

			} catch (AmbiguityResolvingException e) {
				if (e.getCause() instanceof UserAbortException) {
					throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
				} else {
					logger.severe(
							() -> "The following exception occured during the resolving of an ambiguity concerning the selection of a common root element: "
									+ e.getMessage());
					logger.severe("Using default path and instance instead...");
					selectedConnectionPath = connectionChoices.keySet().iterator().next();
					selectedContainerInstance = connectionChoices.get(selectedConnectionPath).get(0);
				}
			}

			return getConnectionFor(selectedContainerInstance, targetElements, selectedConnectionPath, mappingGroup);
		}

	}

	private JoiningConnection getConnectionToInstantiateBasedOnSingleStartingElementPossiblity(
			List<EObjectWrapper> targetElements, List<EClassConnectionPath> connectionPaths,
			EObjectWrapper startingElement, InstantiableMappingHintGroup mappingGroup) {

		// If there is already a 'standardPath' for the given 'mappingGroup', we reuse this standard path
		//
		EClassConnectionPath standardPath = standardConnectionsForHintGroups.getOrDefault(mappingGroup, null);
		if (standardPath != null && connectionPaths.contains(standardPath)) {

			return getConnectionFor(startingElement, targetElements, standardPath, mappingGroup);
		}

		Map<EClassConnectionPath, List<EObjectWrapper>> connectionChoices = connectionPaths.stream().collect(Collectors
				.toMap(Function.identity(), c -> Arrays.asList(startingElement), (v1, v2) -> v2, LinkedHashMap::new));

		return getConnectionToInstantiateBasedOnMultipleStartingElementPossibilities(targetElements, connectionChoices,
				mappingGroup);
	}

	private JoiningConnection getConnectionFor(EObjectWrapper startingElement,
			final List<EObjectWrapper> targetElements, EClassConnectionPath connectionPath,
			InstantiableMappingHintGroup mappingGroup) {

		JoiningConnection connectionToInstantiate = new JoiningConnection(startingElement, targetElements,
				connectionPath, targetSectionRegistry, targetModelRegistry, logger);

		if (!standardConnectionsForHintGroups.containsKey(mappingGroup)
				|| standardConnectionsForHintGroups.get(mappingGroup) != connectionPath) {

			standardConnectionsForHintGroups.put(mappingGroup, connectionPath);

			logger.info(() -> mappingGroup.getTargetMMSectionGeneric().getName() + " ("
					+ ((Mapping) mappingGroup.eContainer()).getName() + "): " + connectionPath.toString());
		}

		return connectionToInstantiate;
	}

	private JoiningConnection getConnectionToInstantiate(final List<EObjectWrapper> rootInstances,
			EClassConnectionPath connectionPath, List<EObjectWrapper> containerInstances,
			InstantiableMappingHintGroup mappingGroup) {

		EObjectWrapper selectedContainerInstance;

		if (containerInstances.size() == 1) {

			selectedContainerInstance = containerInstances.get(0);

		} else {

			// There are multiple possible container instances
			//
			try {
				logger.fine(TargetSectionJoiner.RESOLVE_JOINING_AMBIGUITY_STARTED);

				selectedContainerInstance = ambiguityResolvingStrategy
						.joiningSelectContainerInstance(containerInstances, rootInstances,
								mappingGroup instanceof MappingHintGroupImporter
										? ((MappingHintGroupImporter) mappingGroup).getHintGroup()
										: (MappingHintGroupType) mappingGroup,
								null, null)
						.iterator().next();
				if (ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
					((IAmbiguityResolvedAdapter) ambiguityResolvingStrategy)
							.joiningContainerInstanceSelected(containerInstances, selectedContainerInstance);
				}
				logger.fine(TargetSectionJoiner.RESOLVE_JOINING_AMBIGUITY_ENDED);

			} catch (AmbiguityResolvingException e) {
				if (e.getCause() instanceof UserAbortException) {
					throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
				} else {
					logger.severe(
							() -> "The following exception occured during the resolving of an ambiguity concerning the selection of a container instance: "
									+ e.getMessage());
					logger.severe("Using default path and instance instead...");
					selectedContainerInstance = containerInstances.get(0);
				}
			}
		}

		return getConnectionFor(selectedContainerInstance, rootInstances, connectionPath, mappingGroup);
	}

}
