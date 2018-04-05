/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.expanding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.CancelTransformationException;
import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.mfreund.gentrans.transformation.registries.SelectedMappingRegistry;
import de.mfreund.gentrans.transformation.registries.TargetModelRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvedAdapter;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.tud.et.ifa.agtele.emf.connecting.AllowedReferenceType;
import de.tud.et.ifa.agtele.emf.connecting.Capacity;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathInstantiator;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathRequirement;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.structure.target.FileType;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionClass;

/**
 * This class is responsible for joining the unconnected target sections to form one coherent target model.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class TargetSectionJoiner extends TargetSectionConnector {

	static final String RESOLVE_JOINING_AMBIGUITY_ENDED = "[Ambiguity] ...finished.\n";

	static final String RESOLVE_JOINING_AMBIGUITY_STARTED = "[Ambiguity] Resolve joining ambiguity...";

	/**
	 * The {@link TargetModelRegistry} that is used to manage the various target models and their contents.
	 */
	private final TargetModelRegistry targetModelRegistry;

	/**
	 * This keeps track of {@link TargetSectionClass TargetSectionClasses} and corresponding {@link EObjectWrapper
	 * EObjects} for that no {@link ComplexEClassConnectionPath} could be determined. These elements are potential root
	 * elements respectively need to be connected to a - yet to be created - root element. The key of the Map thereby
	 * denotes the {@link EClass} that the TargetSectionClasses are associated with.
	 */
	private final Map<EClass, Map<TargetSectionClass, List<EObjectWrapper>>> unconnectableElements;

	public TargetSectionJoiner(TransformationAssetManager assetManager) {

		super(assetManager);

		targetModelRegistry = assetManager.getTargetModelRegistry();
		unconnectableElements = new LinkedHashMap<>();
		connectionProvider = new JoiningConnectionProvider(assetManager, eClassConnectionPathProvider);
	}

	@Override
	public void expandMappingInstances(SelectedMappingRegistry selectedMappingRegistry) {

		super.expandMappingInstances(selectedMappingRegistry);

		combineUnlinkedSectionsWithTargetModelRoot();
	}

	@Override
	protected void doConnectCurrentHintGroup() {

		joinCurrentHintGroup();
	}

	private void joinCurrentHintGroup() {

		TargetSection section = currentHintGroup.getTargetMMSectionGeneric();

		List<EObjectWrapper> instancesToConnect = getTargetElementsToConnect(currentHintGroup,
				currentMappingInstanceDescriptor);

		if (instancesToConnect.isEmpty()) {
			return;
		}

		if (section.getFile() != null) {

			// do not join sections for that a 'file' is specified, those are
			// simply added as root elements to that file
			//
			this.addToTargetModelRoot(instancesToConnect);
			return;

		}

		List<ContainerSelector> containerSelectors = getContainerSelectorsInCurrentHintGroup();

		List<EObjectWrapper> unconnectedInstances;
		if (!containerSelectors.isEmpty()) { // link using ContainerSelector(s)

			// Try to connect the instances with the given
			// ContainerSelectors and collect the unconnectable instances
			//
			unconnectedInstances = joinWithContainerSelectors(instancesToConnect, currentHintGroup);

		} else {

			unconnectedInstances = joinWithoutContainerSelector(instancesToConnect, currentHintGroup);

		}

		// If there are still unconnected instances, we add them as new root elements
		//
		this.addToTargetModelRoot(unconnectedInstances);
	}

	private List<ContainerSelector> getContainerSelectorsInCurrentHintGroup() {

		return currentMappingInstanceDescriptor.getMappingHints(currentHintGroup, true).stream()
				.filter(ContainerSelector.class::isInstance).map(ContainerSelector.class::cast)
				.collect(Collectors.toList());
	}

	private List<EObjectWrapper> getTargetElementsToConnect(InstantiableMappingHintGroup hintGroup,
			MappingInstanceDescriptor mappingInstance) {

		return mappingInstance.getRootInstances(hintGroup);
	}

	/**
	 * This adds the given list of {@link EObjectWrapper elements} as root objects to a target model.
	 * <p />
	 * Note: The target model to use is determined by via the corresponding {@link EObjectWrapper#getFile() file}
	 * attribute.
	 *
	 * @param elementsToAdd
	 *            The list of {@link EObjectWrapper elements} to add.
	 */
	private void addToTargetModelRoot(final Collection<EObjectWrapper> elementsToAdd) {

		if (elementsToAdd == null) {
			return;
		}

		elementsToAdd.stream().forEach(this::addToTargetModelRoot);
	}

	/**
	 * This adds the given {@link EObjectWrapper element} as root object to the target model.
	 * <p />
	 * Note: The target model to use is determined by via the corresponding {@link EObjectWrapper#getFile() file}
	 * attribute.
	 *
	 * @param helper
	 *            The {@link EObjectWrapper element} to add.
	 */
	private void addToTargetModelRoot(final EObjectWrapper helper) {

		// the element to add
		EObject element = helper.getEObject();

		// the path of the target model
		String path = helper.getFile();

		// the file type of the target model
		FileType fileType = helper.getFileType();

		if (path.isEmpty()) {
			targetModelRegistry.addToTargetModel(element);
		} else {
			targetModelRegistry.addToTargetModel(element, path, fileType);
		}
	}

	/**
	 * This takes the list of {@link #unconnectableElements} and adds them to the target model.
	 * <p />
	 * In the easiest case, the list of {@link #unconnectableElements} contains only a single element which will then be
	 * used as root element. If multiple elements exist, this tries to determine a common root element and joins the
	 * elements with it. If no common root element can be determined, multiple root elements are added to the target
	 * model.
	 */
	public void combineUnlinkedSectionsWithTargetModelRoot() {

		checkCanceled();

		// Nothing to do
		//
		if (unconnectableElements.isEmpty()) {
			return;
		}

		logger.info(() -> "Joining "
				+ unconnectableElements.values().parallelStream().flatMap(v -> v.values().stream())
						.flatMap(v2 -> v2.stream()).collect(Collectors.toList()).size()
				+ " unconnected instances with a target model root element...");

		// Only one element could not be connected -> we already have our root element
		//
		if (unconnectableElements.keySet().size() == 1
				&& unconnectableElements.values().iterator().next().keySet().size() == 1
				&& unconnectableElements.values().iterator().next().values().iterator().next().size() == 1) {

			this.addToTargetModelRoot(
					unconnectableElements.values().iterator().next().values().iterator().next().get(0));
			logger.info(() -> "Root element: The single instance of the target section '"
					+ unconnectableElements.values().iterator().next().keySet().iterator().next().getName() + "'.");
			return;

		}

		// Collect all classes that could act as common root for each of the unconnected elements
		//
		List<EClassConnectionPathRequirement> requirements = unconnectableElements.keySet().stream()
				.map(e -> new EClassConnectionPathRequirement(e).withRequiredMaximumPathLength(maxPathLength)
						.withAllowedReferenceType(AllowedReferenceType.CONTAINMENT))
				.collect(Collectors.toList());

		Iterator<EClassConnectionPathRequirement> requirementIterator = requirements.iterator();

		List<EClass> rootClassesFulfillingAllrequirements = new ArrayList<>(eClassConnectionPathProvider
				.getConnections(requirementIterator.next()).stream().map(EClassConnectionPath::getStartingClass)
				.collect(Collectors.toCollection(LinkedHashSet::new)));

		while (requirementIterator.hasNext()) {
			EClassConnectionPathRequirement requirement = requirementIterator.next();
			rootClassesFulfillingAllrequirements.retainAll(eClassConnectionPathProvider.getConnections(requirement)
					.stream().map(EClassConnectionPath::getStartingClass)
					.collect(Collectors.toCollection(LinkedHashSet::new)));

		}

		checkCanceled();

		if (rootClassesFulfillingAllrequirements.isEmpty()) {

			// No common root class found
			//
			for (final EClass c : unconnectableElements.keySet()) {

				logger.warning(() -> "No suitable path found for target class: " + c.getName());

				unconnectableElements.get(c).values().stream().forEach(this::addToTargetModelRoot);
			}

			return;
		}

		// The eClass that we will use for our new root element
		//
		EClass rootClass;

		if (rootClassesFulfillingAllrequirements.size() == 1) {
			rootClass = rootClassesFulfillingAllrequirements.iterator().next();

		} else {

			// Consult the specified resolving strategy to resolve the ambiguity.
			//
			try {
				logger.fine(TargetSectionJoiner.RESOLVE_JOINING_AMBIGUITY_STARTED);
				List<EClass> resolved = ambiguityResolvingStrategy
						.joiningSelectRootElement(new ArrayList<>(rootClassesFulfillingAllrequirements));
				if (ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
					((IAmbiguityResolvedAdapter) ambiguityResolvingStrategy).joiningRootElementSelected(
							new ArrayList<>(rootClassesFulfillingAllrequirements), resolved.get(0));
				}
				logger.fine(TargetSectionJoiner.RESOLVE_JOINING_AMBIGUITY_ENDED);
				rootClass = resolved.get(0);

			} catch (AmbiguityResolvingException e) {
				if (e.getCause() instanceof UserAbortException) {
					throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
				} else {
					logger.severe(
							() -> "The following exception occured during the resolving of an ambiguity concerning the selection of a common root class: "
									+ e.getMessage());
					logger.severe("Using default path instead...");
					rootClass = rootClassesFulfillingAllrequirements.iterator().next();
				}
			}

		}

		// The new root element
		//
		final EObject containerInstance = rootClass.getEPackage().getEFactoryInstance().create(rootClass);

		this.addToTargetModelRoot(new EObjectWrapper(containerInstance, targetSectionRegistry));

		logger.info("Root element: '" + rootClass.getName() + "' (generated)");

		for (final Entry<EClass, Map<TargetSectionClass, List<EObjectWrapper>>> unlinkeableEntry : unconnectableElements
				.entrySet()) {

			for (final TargetSectionClass tSection : unlinkeableEntry.getValue().keySet()) {
				/*
				 * It gets a bit tricky here. If there is more than one common container, we have to choose one. Then we
				 * need to find all possible connections for each of the elements involved. Now we need to choose a
				 * connection for each element. This might lead to us asking a lot of questions to the user.
				 */
				final int neededCapacity = unlinkeableEntry.getValue().get(tSection).size();
				EClassConnectionPathRequirement connectionRequirement = new EClassConnectionPathRequirement(
						unlinkeableEntry.getKey()).withRequiredStartingElement(containerInstance)
								.withRequiredMaximumPathLength(maxPathLength)
								.withRequiredMinimumCapacity(Capacity.valueOf(neededCapacity))
								.withAllowedReferenceType(AllowedReferenceType.CONTAINMENT);

				final List<EClassConnectionPath> pathSet = eClassConnectionPathProvider
						.getConnections(connectionRequirement);

				if (pathSet.isEmpty()) {

					this.addToTargetModelRoot(unlinkeableEntry.getValue().get(tSection));// This
					// should
					// not
					// have
					// happened
					// =>
					// programming error
					logger.severe("Error. Check container instantiation");

				} else {

					if (!pathSet.isEmpty()) {

						EClassConnectionPath chosenPath = pathSet.get(0);

						if (pathSet.size() > 1) {
							/*
							 * Consult the specified resolving strategy to resolve the ambiguity.
							 */
							try {
								logger.fine(TargetSectionJoiner.RESOLVE_JOINING_AMBIGUITY_STARTED);
								List<EClassConnectionPath> resolved = ambiguityResolvingStrategy
										.joiningSelectConnectionPath(pathSet, (TargetSection) tSection);
								if (ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
									((IAmbiguityResolvedAdapter) ambiguityResolvingStrategy)
											.joiningConnectionPathSelected(new ArrayList<>(pathSet), resolved.get(0));
								}
								logger.fine(TargetSectionJoiner.RESOLVE_JOINING_AMBIGUITY_ENDED);
								chosenPath = resolved.get(0);

							} catch (AmbiguityResolvingException e) {
								if (e.getCause() instanceof UserAbortException) {
									throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
								} else {
									logger.severe(
											() -> "The following exception occured during the resolving of an ambiguity concerning an connection path: "
													+ e.getMessage());
									logger.severe("Using default path instead...");
									chosenPath = pathSet.get(0);
								}
							}
						}

						// now instantiate path
						List<EObject> elementsToConnect = unlinkeableEntry.getValue().get(tSection).stream()
								.map(EObjectWrapper::getEObject).collect(Collectors.toList());
						EClassConnectionPathInstantiator i = chosenPath.createInstantiator(containerInstance,
								elementsToConnect);
						i.instantiate();
						i.getCreatedIntermediaryElements().stream().forEach(targetSectionRegistry::addClassInstance);

						logger.info("Connected to root: " + tSection.getName() + ": " + chosenPath.toString());
					} else {
						logger.warning("The chosen container '" + rootClass.getName()
								+ "' cannot fit the elements of the type '" + unlinkeableEntry.getKey().getName()
								+ "', sorry.");
						this.addToTargetModelRoot(unlinkeableEntry.getValue().get(tSection));
					}

				}
			}
		}

	}

	/**
	 * Try to link the given list of 'rootInstances' (and therefore entire sections of the target model) to other
	 * objects of the target model.
	 * <p>
	 * This method is used for connecting sections without model connection hints.
	 *
	 * @param rootInstances
	 *            A list of {@link EObjectWrapper elements} to connect.
	 * @param mappingGroup
	 *            The {@link MappingHintGroupType} that is used.
	 * @return A list of {@link EObjectWrapper instances} that could not be connected (a sub-list of the given
	 *         <em>rootInstances</em> or an empty list). <br />
	 *         Note: This will not contain those instances that have been determined as {@link #unconnectableElements
	 *         <em>unconnectable</em>} as those are treated differently during
	 *         {@link #combineUnlinkedSectionsWithTargetModelRoot()}.
	 */
	private List<EObjectWrapper> joinWithoutContainerSelector(final List<EObjectWrapper> rootInstances,
			InstantiableMappingHintGroup mappingGroup) {

		checkCanceled();

		List<EClassConnectionPathBasedConnection> selectedConnections = connectionProvider
				.selectConnectionsWithoutContainerSelector(rootInstances, mappingGroup);

		if (selectedConnections.isEmpty()) {

			// Although none of the 'rootInstances' have been connected, we do not return them as 'unconnected
			// instances'. The reason for this is that they will be connected later on when the 'unconnectableElements'
			// are handled
			//
			registerAsUnconnectable(rootInstances, mappingGroup.getTargetMMSectionGeneric());
			return new ArrayList<>();

		}

		return instantiateConnectionsAndReturnUnconnectedElements(selectedConnections);

	}

	/**
	 * Registers the given list of elements as {@link #unconnectableElements unconnectable} so that they will be
	 * regarded by {@link #combineUnlinkedSectionsWithTargetModelRoot()}.
	 *
	 * @param unconnectableInstances
	 *            The list of {@link EObjectWrapper elements} to register.
	 * @param section
	 *            The {@link TargetSection} that was responsible for creating the instances.
	 */
	private void registerAsUnconnectable(List<EObjectWrapper> unconnectableInstances, TargetSection section) {

		if (!unconnectableElements.containsKey(section.getEClass())) {

			unconnectableElements.put(section.getEClass(),
					new LinkedHashMap<TargetSectionClass, List<EObjectWrapper>>());
		}

		if (!unconnectableElements.get(section.getEClass()).containsKey(section)) {

			unconnectableElements.get(section.getEClass()).put(section, new LinkedList<EObjectWrapper>());
		}

		unconnectableElements.get(section.getEClass()).get(section).addAll(unconnectableInstances);
	}

	/**
	 * Try to join the given list of 'rootInstances' (and therefore entire sections of the target model) with other
	 * objects of the target model.
	 * <p>
	 * This method is used for connecting sections using a given {@link ContainerSelector}.
	 *
	 * @param rootInstances
	 *            A list of {@link EObjectWrapper elements} to connect (created based on the given
	 *            <em>mappingInstance</em>).
	 * @param mappingGroup
	 *            The {@link MappingHintGroupType} that is used.
	 *
	 * @return A list of {@link EObjectWrapper instances} that could not be connected (a sub-list of the given
	 *         <em>rootInstances</em> or an empty list).
	 */
	private List<EObjectWrapper> joinWithContainerSelectors(final List<EObjectWrapper> rootInstances,
			InstantiableMappingHintGroup mappingGroup) {

		checkCanceled();

		List<EClassConnectionPathBasedConnection> selectedConnections = connectionProvider
				.selectConnectionsWithContainerSelector(currentMappingInstanceDescriptor, rootInstances, mappingGroup);

		if (selectedConnections.isEmpty()) {
			return Collections.unmodifiableList(rootInstances);
		}

		return instantiateConnectionsAndReturnUnconnectedElements(selectedConnections);
	}

	private List<EObjectWrapper> instantiateConnectionsAndReturnUnconnectedElements(
			List<EClassConnectionPathBasedConnection> connections) {

		return connections.stream()
				.flatMap(connection -> connection.instantiate(targetSectionRegistry, logger).stream())
				.collect(Collectors.toList());
	}

}
