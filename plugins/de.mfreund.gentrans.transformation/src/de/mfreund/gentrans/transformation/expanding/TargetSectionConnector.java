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
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import de.mfreund.gentrans.transformation.CancelTransformationException;
import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.core.CancelableTransformationAsset;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.mfreund.gentrans.transformation.registries.SelectedMappingRegistry;
import de.mfreund.gentrans.transformation.registries.TargetModelRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvedAdapter;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.tud.et.ifa.agtele.emf.connecting.AllowedReferenceType;
import de.tud.et.ifa.agtele.emf.connecting.Capacity;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathInstantiator;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathProvider;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathRequirement;
import de.tud.et.ifa.agtele.emf.connecting.Length;
import pamtram.TargetSectionModel;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
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
public class TargetSectionConnector extends CancelableTransformationAsset {

	static final String RESOLVE_JOINING_AMBIGUITY_ENDED = "[Ambiguity] ...finished.\n";

	static final String RESOLVE_JOINING_AMBIGUITY_STARTED = "[Ambiguity] Resolve joining ambiguity...";

	/**
	 * This list stores those {@link ComplexEClassConnectionPath ModelConnectionPaths} that have been previously
	 * selected by the user for a given {@link MappingHintGroupType}.
	 */
	private final LinkedHashMap<InstantiableMappingHintGroup, EClassConnectionPath> standardPaths;

	/**
	 * The {@link TargetSectionRegistry} that is used when finding instances to which sections can be connected.
	 */
	private final TargetSectionRegistry targetSectionRegistry;

	private final EClassConnectionPathProvider connectionPathProvider;

	/**
	 * The {@link TargetModelRegistry} that is used to manage the various target models and their contents.
	 */
	private final TargetModelRegistry targetModelRegistry;

	/**
	 * The maximum length for connection paths that shall be considered by this TargetSectionConnector. If
	 * 'maxPathLength' is set to '-1' or any other value below '0', connection paths of unbounded length are considered.
	 */
	private final Length maxPathLength;

	/**
	 * This keeps track of {@link TargetSectionClass TargetSectionClasses} and corresponding {@link EObjectWrapper
	 * EObjects} for that no {@link ComplexEClassConnectionPath} could be determined. These elements are potential root
	 * elements respectively need to be connected to a - yet to be created - root element. The key of the Map thereby
	 * denotes the {@link EClass} that the TargetSectionClasses are associated with.
	 */
	private final Map<EClass, Map<TargetSectionClass, List<EObjectWrapper>>> unconnectableElements;

	/**
	 * This is the {@link IAmbiguityResolvingStrategy} that shall be used to resolve ambiguities that arise during the
	 * execution of the transformation.
	 */
	private IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

	private MappingInstanceDescriptor currentMappingInstance;

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public TargetSectionConnector(TransformationAssetManager assetManager) {

		super(assetManager);

		standardPaths = new LinkedHashMap<>();
		targetSectionRegistry = assetManager.getTargetSectionRegistry();

		targetModelRegistry = assetManager.getTargetModelRegistry();

		Set<EPackage> targetMetaModels = new LinkedHashSet<>(assetManager.getTransformationConfig().getPamtramModels()
				.stream().flatMap(p -> p.getTargetSectionModels().stream()).map(TargetSectionModel::getMetaModelPackage)
				.collect(Collectors.toList()));
		connectionPathProvider = EClassConnectionPathProvider.getInstance(targetMetaModels, logger);
		// FIXME in the config, 0 means direct connection; in Length, 0 means no connection
		int rawMaxPathLength = assetManager.getTransformationConfig().getMaxPathLength();
		maxPathLength = Length.valueOf(rawMaxPathLength == -1 ? rawMaxPathLength : rawMaxPathLength + 1);
		ambiguityResolvingStrategy = assetManager.getTransformationConfig().getAmbiguityResolvingStrategy();
		unconnectableElements = new LinkedHashMap<>();
	}

	/**
	 * Join the instantiated {@link TargetSection TargetSections}.
	 *
	 * @param selectedMappingRegistry
	 *            The {@link SelectedMappingRegistry} providing all the {@link MappingInstanceDescriptor Mapping
	 *            instances} whose {@link TargetSection TargetSections} shall be joined.
	 */
	public void joinTargetSections(SelectedMappingRegistry selectedMappingRegistry) {

		List<MappingInstanceDescriptor> mappingInstaces = selectedMappingRegistry.getMappingInstaces();

		joinTargetSectionsCreatedByMappingInstances(mappingInstaces);
	}

	private void joinTargetSectionsCreatedByMappingInstances(List<MappingInstanceDescriptor> mappingInstances) {

		mappingInstances.stream().forEach(this::joinTargetSectionsCreatedByMappingInstance);
	}

	private void joinTargetSectionsCreatedByMappingInstance(MappingInstanceDescriptor mappingInstance) {

		currentMappingInstance = mappingInstance;

		joinTargetSectionsCreatedByMappingHintGroups();

		joinTargetSectionsCreatedByMappingHintGroupImporters();

	}

	private void joinTargetSectionsCreatedByMappingHintGroups() {

		Stream<MappingHintGroup> activeMappingHintGroupsOfCurrentMappingInstance = currentMappingInstance
				.getMappingHintGroups().stream()
				.filter(g -> g.getTargetSection() != null && g instanceof MappingHintGroup)
				.map(g -> (MappingHintGroup) g);

		activeMappingHintGroupsOfCurrentMappingInstance
				.forEach(this::joinInstancesCreatedByInstantiableMappingHintGroup);
	}

	private void joinTargetSectionsCreatedByMappingHintGroupImporters() {

		Stream<MappingHintGroupImporter> activeMappingHintGroupImportersOfCurrentMappingInstance = currentMappingInstance
				.getMappingHintGroupImporters().stream()
				.filter(i -> i.getHintGroup() != null && i.getHintGroup().getTargetSection() != null);

		activeMappingHintGroupImportersOfCurrentMappingInstance
				.forEach(this::joinInstancesCreatedByInstantiableMappingHintGroup);
	}

	/**
	 * Join the {@link TargetSection} instances created by the given {@link MappingHintGroupType}.
	 *
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} responsible for the creation of the {@link TargetSection
	 *            TargetSections} to join.
	 * @param mappingInstances
	 *            The list of {@link MappingInstanceDescriptor instances} created based on the given {@link Mapping}.
	 */
	private void joinInstancesCreatedByInstantiableMappingHintGroup(InstantiableMappingHintGroup hintGroup) {

		joinInstanceCreatedByInstantiableHintGroup(hintGroup, currentMappingInstance);

	}

	private void joinInstanceCreatedByInstantiableHintGroup(InstantiableMappingHintGroup hintGroup,
			final MappingInstanceDescriptor mappingInstance) {

		checkCanceled();

		// The TargetSection of which we want to join created instances
		//
		final TargetSection section = hintGroup.getTargetMMSectionGeneric();

		if (section.getFile() != null) {

			// do not join sections for that a 'file' is specified, those are
			// simply added as root elements to that file
			//
			this.addToTargetModelRoot(mappingInstance.getInstances(hintGroup, section));
			return;

		}

		// The active ContainerSelectors for this MappingHintGroups
		//
		// FIXME should be evaluated only by the provider
		List<ContainerSelector> containerSelectors = mappingInstance.getMappingHints(hintGroup, true).stream()
				.filter(ContainerSelector.class::isInstance).map(ContainerSelector.class::cast)
				.collect(Collectors.toList());

		List<EObjectWrapper> instancesToConnect = getTargetElementsToConnect(hintGroup, mappingInstance);

		if (instancesToConnect.isEmpty() || mappingInstance.isElementWithNegativeCondition(hintGroup)) {
			return;
		}

		List<EObjectWrapper> unconnectedInstances;
		if (!containerSelectors.isEmpty()) { // link using ContainerSelector(s)

			// Try to connect the instances with the given
			// ContainerSelectors and collect the unconnectable instances
			//
			unconnectedInstances = joinWithContainerSelectors(mappingInstance, instancesToConnect, hintGroup);

		} else {

			unconnectedInstances = joinWithoutContainerSelector(instancesToConnect, section, hintGroup,
					section.getContainer() != null
							? Optional.of(Collections.singleton(section.getContainer().getEClass()))
							: Optional.empty(),
					Optional.empty());

		}

		// If there are still unconnected instances, we add them as new root elements
		//
		this.addToTargetModelRoot(unconnectedInstances);
	}

	private List<EObjectWrapper> getTargetElementsToConnect(InstantiableMappingHintGroup hintGroup,
			MappingInstanceDescriptor mappingInstance) {

		return mappingInstance.getInstances(hintGroup, hintGroup.getTargetMMSectionGeneric());
	}

	// /**
	// * Join the {@link TargetSection} instances created by the given {@link MappingHintGroupType}.
	// *
	// * @param hintGroupImporter
	// * The {@link MappingHintGroupImporter} responsible for the creation of the {@link TargetSection
	// * TargetSections} to join.
	// * @param mappingInstances
	// * The list of {@link MappingInstanceDescriptor instances} created based on the given {@link Mapping}.
	// * @return '<em><b>true</b></em>' if all instances of the TargetSection were joined successfully;
	// * '<em><b>false</b></em>' otherwise
	// */
	// private boolean joinInstancesCreatedByMappingHintGroupImporter(final MappingHintGroupImporter hintGroupImporter)
	// {
	//
	// checkCanceled();
	//
	// List<MappingInstanceDescriptor> mappingInstances = selectedMappingRegistry
	// .get(hintGroupImporter.getParentMapping());
	//
	// final ExportedMappingHintGroup g = hintGroupImporter.getHintGroup();
	//
	// // The TargetSection of which we want to joing created instances
	// //
	// final TargetSection section = hintGroupImporter.getTargetMMSectionGeneric();
	//
	// if (section.getFile() != null) {
	//
	// // do not join sections for that a 'file' is specified, those are
	// // simply added as root elements to that file
	// //
	// this.addToTargetModelRoot(targetSectionRegistry.getPamtramClassInstances(section).get(hintGroupImporter));
	// return true;
	//
	// }
	//
	// if (targetSectionRegistry.getPamtramClassInstances(section).keySet().isEmpty()
	// || targetSectionRegistry.getPamtramClassInstances(section).get(hintGroupImporter) == null) {
	//
	// // nothing to do
	// //
	// return true;
	// }
	//
	// /*
	// * ImportedMAppingHintGroups with containers specified will be linked to a section that was created by the same
	// * mapping Instance
	// */
	// if (hintGroupImporter.getContainer() != null) {
	// for (final MappingInstanceDescriptor selMap : mappingInstances) {
	//
	// final List<EObjectWrapper> rootInstances = getTargetElementsToConnect(hintGroupImporter, selMap);
	//
	// if (!rootInstances.isEmpty()) {
	// final LinkedList<EObjectWrapper> containerInstances = new LinkedList<>();
	//
	// // get container instances created by this
	// // mapping instance
	// for (final MappingHintGroupType group : selMap.getMappingHintGroups()) {
	//
	// if (group instanceof MappingHintGroup) {
	// final List<EObjectWrapper> insts = selMap.getInstances((MappingHintGroup) group,
	// hintGroupImporter.getContainer());
	// if (insts != null) {
	// containerInstances.addAll(insts);
	// }
	//
	// }
	// }
	// // link
	// joinWithoutContainerSelector(rootInstances, hintGroupImporter.getTargetMMSectionGeneric(),
	// hintGroupImporter,
	// Optional.of(new HashSet<>(Arrays.asList(hintGroupImporter.getContainer().getEClass()))),
	// containerInstances.isEmpty() ? Optional.empty() : Optional.of(containerInstances));
	//
	// }
	// }
	//
	// // use container attribute of targetSection if one is
	// // specified
	// // (target section container == global instance search)
	// } else {
	// final LinkedList<EObjectWrapper> containerInstances = new LinkedList<>();
	// final List<EObjectWrapper> rootInstances = targetSectionRegistry.getPamtramClassInstances(section)
	// .get(hintGroupImporter);
	// final Set<EClass> containerClasses = new LinkedHashSet<>();
	// if (hintGroupImporter.getTargetMMSectionGeneric().getContainer() != null) {
	// containerClasses.add(section.getContainer().getEClass());
	// containerInstances
	// .addAll(targetSectionRegistry.getFlattenedPamtramClassInstances(section.getContainer()));
	//
	// }
	//
	// if (rootInstances != null && !rootInstances.isEmpty()) {
	// // link
	// joinWithoutContainerSelector(rootInstances, hintGroupImporter.getTargetMMSectionGeneric(),
	// hintGroupImporter,
	// containerClasses.isEmpty() ? Optional.empty() : Optional.of(containerClasses),
	// containerInstances.isEmpty() ? Optional.empty() : Optional.of(containerInstances));
	// }
	// }
	//
	// return true;
	// }

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

		List<EClass> rootClassesFulfillingAllrequirements = new ArrayList<>(connectionPathProvider
				.getConnections(requirementIterator.next()).stream().map(EClassConnectionPath::getStartingClass)
				.collect(Collectors.toCollection(LinkedHashSet::new)));

		while (requirementIterator.hasNext()) {
			EClassConnectionPathRequirement requirement = requirementIterator.next();
			rootClassesFulfillingAllrequirements.retainAll(connectionPathProvider.getConnections(requirement).stream()
					.map(EClassConnectionPath::getStartingClass).collect(Collectors.toCollection(LinkedHashSet::new)));

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
				logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_STARTED);
				List<EClass> resolved = ambiguityResolvingStrategy
						.joiningSelectRootElement(new ArrayList<>(rootClassesFulfillingAllrequirements));
				if (ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
					((IAmbiguityResolvedAdapter) ambiguityResolvingStrategy).joiningRootElementSelected(
							new ArrayList<>(rootClassesFulfillingAllrequirements), resolved.get(0));
				}
				logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_ENDED);
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

				final List<EClassConnectionPath> pathSet = connectionPathProvider.getConnections(connectionRequirement);

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
								logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_STARTED);
								List<EClassConnectionPath> resolved = ambiguityResolvingStrategy
										.joiningSelectConnectionPath(pathSet, (TargetSection) tSection);
								if (ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
									((IAmbiguityResolvedAdapter) ambiguityResolvingStrategy)
											.joiningConnectionPathSelected(new ArrayList<>(pathSet), resolved.get(0));
								}
								logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_ENDED);
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
	 * @param section
	 *            The {@link TargetSection} that shall be connected.
	 * @param mappingGroup
	 *            The {@link MappingHintGroupType} that is used.
	 * @param containerClasses
	 *            An optional set of {@link EClass EClasses} that are considered as target when searching for connection
	 *            paths for the given list of 'rootInstances'.<br />
	 *            <em>Note:</em> If the optional is not present, any EClass will be considered a valid target.
	 * @param containerInstances
	 *            An optional list of container elements that may be used as container. <em>Note:</em> If the optional
	 *            is not present, any instance will be considered a valid container.
	 * @return A list of {@link EObjectWrapper instances} that could not be connected (a sub-list of the given
	 *         <em>rootInstances</em> or an empty list). <br />
	 *         Note: This will not contain those instances that have been determined as {@link #unconnectableElements
	 *         <em>unconnectable</em>} as those are treated differently during
	 *         {@link #combineUnlinkedSectionsWithTargetModelRoot()}.
	 */
	private List<EObjectWrapper> joinWithoutContainerSelector(final List<EObjectWrapper> rootInstances,
			final TargetSection section, InstantiableMappingHintGroup mappingGroup,
			final Optional<Set<EClass>> containerClasses, final Optional<List<EObjectWrapper>> containerInstances) {

		checkCanceled();

		JoiningConnectionProvider joiningConnectionProvider = new JoiningConnectionProvider(assetManager, standardPaths,
				connectionPathProvider);
		List<Connection> selectedConnections = joiningConnectionProvider
				.selectConnectionsWithoutContainerSelector(rootInstances, mappingGroup, containerClasses);

		if (selectedConnections.isEmpty()) {

			// Although none of the 'rootInstances' have been connected, we do not return them as 'unconnected
			// instances'. The reason for this is that they will be connected later on when the 'unconnectableElements'
			// are handled
			//
			registerAsUnconnectable(rootInstances, section);
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
	 * @param mappingInstance
	 *            The {@link MappingInstanceDescriptor} representing the given <em>rootInstances</em>.
	 * @param rootInstances
	 *            A list of {@link EObjectWrapper elements} to connect (created based on the given
	 *            <em>mappingInstance</em>).
	 * @param mappingGroup
	 *            The {@link MappingHintGroupType} that is used.
	 * @return A list of {@link EObjectWrapper instances} that could not be connected (a sub-list of the given
	 *         <em>rootInstances</em> or an empty list).
	 */
	private List<EObjectWrapper> joinWithContainerSelectors(MappingInstanceDescriptor mappingInstance,
			final List<EObjectWrapper> rootInstances, InstantiableMappingHintGroup mappingGroup) {

		checkCanceled();

		JoiningConnectionProvider joiningConnectionProvider = new JoiningConnectionProvider(assetManager, standardPaths,
				connectionPathProvider);
		List<Connection> selectedConnections = joiningConnectionProvider
				.selectConnectionsWithContainerSelector(mappingInstance, rootInstances, mappingGroup);

		if (selectedConnections.isEmpty()) {
			return Collections.unmodifiableList(rootInstances);
		}

		return instantiateConnectionsAndReturnUnconnectedElements(selectedConnections);
	}

	private List<EObjectWrapper> instantiateConnectionsAndReturnUnconnectedElements(List<Connection> connections) {

		return connections.stream()
				.flatMap(connection -> connection.instantiate(targetSectionRegistry, logger).stream())
				.collect(Collectors.toList());
	}

}
