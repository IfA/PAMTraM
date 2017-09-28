package de.mfreund.gentrans.transformation.expanding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.mfreund.gentrans.transformation.CancelTransformationException;
import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.calculation.InstanceSelectorHandler;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.descriptors.ModelConnectionPath;
import de.mfreund.gentrans.transformation.registries.TargetModelRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvedAdapter;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.mfreund.gentrans.transformation.util.CancelableElement;
import pamtram.ConditionalElement;
import pamtram.mapping.ExportedMappingHintGroup;
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
public class TargetSectionConnector extends CancelableElement {

	private static final String RESOLVE_JOINING_AMBIGUITY_ENDED = "[Ambiguity] ...finished.\n";

	private static final String RESOLVE_JOINING_AMBIGUITY_STARTED = "[Ambiguity] Resolve joining ambiguity...";

	/**
	 * This list stores those {@link ModelConnectionPath ModelConnectionPaths} that have been previously selected by the
	 * user for a given {@link MappingHintGroupType}.
	 */
	private final LinkedHashMap<MappingHintGroupType, ModelConnectionPath> standardPaths;

	/**
	 * The {@link TargetSectionRegistry} that is used when finding instances to which sections can be connected.
	 */
	private final TargetSectionRegistry targetSectionRegistry;

	/**
	 * The {@link TargetModelRegistry} that is used to manage the various target models and their contents.
	 */
	private final TargetModelRegistry targetModelRegistry;

	/**
	 * The {@link Logger} that is used to print messages to inform the user.
	 */
	private final Logger logger;

	/**
	 * The {@link InstanceSelectorHandler} used to evaluate modeled {@link ContainerSelector ContainerSelectors}.
	 */
	private InstanceSelectorHandler instanceSelectorHandler;

	/**
	 * The maximum length for connection paths that shall be considered by this TargetSectionConnector. If
	 * 'maxPathLength' is set to '-1' or any other value below '0', connection paths of unbounded length are considered.
	 */
	private final int maxPathLength;

	/**
	 * This keeps track of {@link TargetSectionClass TargetSectionClasses} and corresponding {@link EObjectWrapper
	 * EObjects} for that no {@link ModelConnectionPath} could be determined. These elements are potential root elements
	 * respectively need to be connected to a - yet to be created - root element. The key of the Map thereby denotes the
	 * {@link EClass} that the TargetSectionClasses are associated with.
	 */
	private final Map<EClass, Map<TargetSectionClass, List<EObjectWrapper>>> unconnectableElements;

	/**
	 * This is the {@link IAmbiguityResolvingStrategy} that shall be used to resolve ambiguities that arise during the
	 * execution of the transformation.
	 */
	private IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

	/**
	 * This creates an instance.
	 *
	 * @param targetSectionRegistry
	 *            A {@link TargetSectionRegistry} that is necessary for finding instances to which sections can be
	 *            connected.
	 * @param instanceSelectorHandler
	 *            The {@link InstanceSelectorHandler} used to evaluate modeled {@link ContainerSelector
	 *            ContainerSelectors}.
	 * @param targetModelRegistry
	 *            The {@link TargetModelRegistry} that is used to manage the various target models and their contents.
	 * @param maxPathLength
	 *            The maximum length for connection paths that shall be considered by this TargetSectionConnector. If
	 *            'maxPathLength' is set to '-1' or any other value below '0', connection paths of unbounded length are
	 *            considered.
	 * @param ambiguityResolvingStrategy
	 *            The {@link IAmbiguityResolvingStrategy} that shall be used to resolve ambiguities that arise during
	 *            the execution of the transformation.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 */
	public TargetSectionConnector(final TargetSectionRegistry targetSectionRegistry,
			InstanceSelectorHandler instanceSelectorHandler, final TargetModelRegistry targetModelRegistry,
			final int maxPathLength, final IAmbiguityResolvingStrategy ambiguityResolvingStrategy,
			final Logger logger) {

		this.standardPaths = new LinkedHashMap<>();
		this.targetSectionRegistry = targetSectionRegistry;
		this.targetModelRegistry = targetModelRegistry;
		this.logger = logger;
		this.canceled = false;
		this.instanceSelectorHandler = instanceSelectorHandler;
		this.maxPathLength = maxPathLength;
		this.ambiguityResolvingStrategy = ambiguityResolvingStrategy;
		this.unconnectableElements = new LinkedHashMap<>();
	}

	/**
	 * Join the {@link TargetSection} instances created by the hint groups of the given {@link MappingHintGroupType}.
	 *
	 * @param mapping
	 *            The {@link Mapping} responsible for the creation of the {@link TargetSection TargetSections}
	 * @param mappingInstances
	 *            The list of {@link MappingInstanceStorage instances} created based on the given {@link Mapping}.
	 * @param targetSectionRegistry
	 *            The {@link TargetSectionRegistry} that keeps track of instantiated sections.
	 * @return '<em><b>true</b></em>' if all instances of the TargetSection were joined successfully;
	 *         '<em><b>false</b></em>' otherwise
	 */
	public boolean joinTargetSections(final Mapping mapping, final List<MappingInstanceStorage> mappingInstances,
			final TargetSectionRegistry targetSectionRegistry) {

		// Join 'local' hint groups
		//
		if (!mapping.getActiveMappingHintGroups().stream()
				.filter(g -> g.getTargetSection() != null && g instanceof MappingHintGroup)
				.allMatch(g -> this.joinTargetSection(g, mappingInstances, targetSectionRegistry))) {

			return false;
		}

		// Join 'imported' hint groups
		//
		if (!mapping.getActiveImportedMappingHintGroups().stream()
				.filter(i -> i.getHintGroup() != null && i.getHintGroup().getTargetSection() != null)
				.allMatch(i -> this.joinTargetSection(i, mappingInstances, targetSectionRegistry))) {

			return false;
		}

		return true;
	}

	/**
	 * Join the {@link TargetSection} instances created by the given {@link MappingHintGroupType}.
	 *
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} responsible for the creation of the {@link TargetSection
	 *            TargetSections} to join.
	 * @param mappingInstances
	 *            The list of {@link MappingInstanceStorage instances} created based on the given {@link Mapping}.
	 * @param targetSectionRegistry
	 *            The {@link TargetSectionRegistry} that keeps track of instantiated sections.
	 * @return '<em><b>true</b></em>' if all instances of the TargetSection were joined successfully;
	 *         '<em><b>false</b></em>' otherwise
	 */
	@SuppressWarnings("unlikely-arg-type")
	private boolean joinTargetSection(final MappingHintGroupType hintGroup,
			final List<MappingInstanceStorage> mappingInstances, final TargetSectionRegistry targetSectionRegistry) {

		this.checkCanceled();

		// The TargetSection of which we want to join created instances
		//
		final TargetSection section = hintGroup.getTargetSection();

		if (section.getFile() != null) {

			// do not join sections for that a 'file' is specified, those are
			// simply added as root elements to that file
			//
			this.addToTargetModelRoot(
					targetSectionRegistry.getPamtramClassInstances(hintGroup.getTargetSection()).get(hintGroup));
			return true;

		}

		if (targetSectionRegistry.getPamtramClassInstances(section).keySet().isEmpty()
				|| targetSectionRegistry.getPamtramClassInstances(section).get(hintGroup) == null) {

			// nothing to do
			//
			return true;
		}

		// Join the created instances using the specified 'ContainerSelector(s)'
		//
		if (!hintGroup.getContainerSelectors().isEmpty()) { // link using ContainerSelector(s)

			// The 'ContainerSelector(s)' need to be evaluated separately for each Mapping instance...
			//
			for (final MappingInstanceStorage mappingInstance : mappingInstances) {

				// The target model elements that need to connected to a
				// container element
				//
				List<EObjectWrapper> instancesToConnect = mappingInstance.getInstances((MappingHintGroup) hintGroup,
						section);

				if (instancesToConnect.isEmpty() || hintGroup instanceof ConditionalElement
						&& mappingInstance.isElementWithNegativeCondition((ConditionalElement) hintGroup)) {
					continue;
				}

				// Try to connect the instances with the given
				// ContainerSelectors and collect the unconnectable instances
				//
				instancesToConnect = this.joinWithContainerSelectors(mappingInstance, instancesToConnect, hintGroup,
						hintGroup.getContainerSelectors());

				// After evaluation of all ContainerSelectors, if there are
				// still unconnected instances, we add them as new root elements
				//
				this.addToTargetModelRoot(instancesToConnect);
			}

			// Join the created instances using the 'container' reference or no hint at all
			//

		} else {

			final List<EObjectWrapper> containerInstances = targetSectionRegistry
					.getFlattenedPamtramClassInstances(section.getContainer());

			/*
			 * fetch ALL instances created by the MH-Group in question => less user input and possibly shorter
			 * processing time
			 */
			final List<EObjectWrapper> rootInstances = targetSectionRegistry.getPamtramClassInstances(section)
					.get(hintGroup);

			// Prevent circular containments
			//
			containerInstances.removeAll(rootInstances);

			List<EObjectWrapper> unconnectedInstances = this.joinWithoutContainerSelector(rootInstances, section,
					hintGroup,
					section.getContainer() != null
							? Optional.of(new HashSet<>(Arrays.asList(section.getContainer().getEClass())))
							: Optional.empty(),
					containerInstances.isEmpty() ? Optional.empty() : Optional.of(containerInstances));

			// If there are still unconnected instances, we add them as new root elements
			//
			this.addToTargetModelRoot(unconnectedInstances);
		}

		return true;
	}

	/**
	 * Join the {@link TargetSection} instances created by the given {@link MappingHintGroupType}.
	 *
	 * @param hintGroupImporter
	 *            The {@link MappingHintGroupImporter} responsible for the creation of the {@link TargetSection
	 *            TargetSections} to join.
	 * @param mappingInstances
	 *            The list of {@link MappingInstanceStorage instances} created based on the given {@link Mapping}.
	 * @param targetSectionRegistry
	 *            The {@link TargetSectionRegistry} that keeps track of instantiated sections.
	 * @return '<em><b>true</b></em>' if all instances of the TargetSection were joined successfully;
	 *         '<em><b>false</b></em>' otherwise
	 */
	private boolean joinTargetSection(final MappingHintGroupImporter hintGroupImporter,
			final List<MappingInstanceStorage> mappingInstances, final TargetSectionRegistry targetSectionRegistry) {

		this.checkCanceled();

		final ExportedMappingHintGroup g = hintGroupImporter.getHintGroup();

		// The TargetSection of which we want to joing created instances
		//
		final TargetSection section = g.getTargetSection();

		if (section.getFile() != null) {

			// do not join sections for that a 'file' is specified, those are
			// simply added as root elements to that file
			//
			this.addToTargetModelRoot(targetSectionRegistry.getPamtramClassInstances(section).get(hintGroupImporter));
			return true;

		}

		if (targetSectionRegistry.getPamtramClassInstances(section).keySet().isEmpty()
				|| targetSectionRegistry.getPamtramClassInstances(section).get(hintGroupImporter) == null) {

			// nothing to do
			//
			return true;
		}

		/*
		 * ImportedMAppingHintGroups with containers specified will be linked to a section that was created by the same
		 * mapping Instance
		 */
		if (hintGroupImporter.getContainer() != null) {
			for (final MappingInstanceStorage selMap : mappingInstances) {

				if (g instanceof ConditionalElement && selMap.isElementWithNegativeCondition((ConditionalElement) g)) {
					continue;
				}

				final List<EObjectWrapper> rootInstances = selMap.getInstances(hintGroupImporter, g.getTargetSection());

				if (!rootInstances.isEmpty()) {
					final LinkedList<EObjectWrapper> containerInstances = new LinkedList<>();

					// get container instances created by this
					// mapping instance
					for (final MappingHintGroupType group : selMap.getMappingHintGroups()) {

						if (group instanceof MappingHintGroup) {
							final List<EObjectWrapper> insts = selMap.getInstances((MappingHintGroup) group,
									hintGroupImporter.getContainer());
							if (insts != null) {
								containerInstances.addAll(insts);
							}

						}
					}
					// link
					this.joinWithoutContainerSelector(rootInstances, g.getTargetSection(), g,
							Optional.of(new HashSet<>(Arrays.asList(hintGroupImporter.getContainer().getEClass()))),
							containerInstances.isEmpty() ? Optional.empty() : Optional.of(containerInstances));

				}
			}

			// use container attribute of targetSection if one is
			// specified
			// (target section container == global instance search)
		} else {
			final LinkedList<EObjectWrapper> containerInstances = new LinkedList<>();
			final List<EObjectWrapper> rootInstances = targetSectionRegistry
					.getPamtramClassInstances(g.getTargetSection()).get(hintGroupImporter);
			final Set<EClass> containerClasses = new HashSet<>();
			if (g.getTargetSection().getContainer() != null) {
				containerClasses.add(g.getTargetSection().getContainer().getEClass());
				containerInstances.addAll(
						targetSectionRegistry.getFlattenedPamtramClassInstances(g.getTargetSection().getContainer()));

			}

			if (rootInstances != null && !rootInstances.isEmpty()) {
				// link
				this.joinWithoutContainerSelector(rootInstances, g.getTargetSection(), g,
						containerClasses.isEmpty() ? Optional.empty() : Optional.of(containerClasses),
						containerInstances.isEmpty() ? Optional.empty() : Optional.of(containerInstances));
			}
		}

		return true;
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
			this.targetModelRegistry.addToTargetModel(element);
		} else {
			this.targetModelRegistry.addToTargetModel(element, path, fileType);
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

		this.checkCanceled();

		// Nothing to do
		//
		if (this.unconnectableElements.isEmpty()) {
			return;
		}

		// Only one element could not be connected -> we already have our root element
		//
		if (this.unconnectableElements.keySet().size() == 1
				&& this.unconnectableElements.values().iterator().next().keySet().size() == 1
				&& this.unconnectableElements.values().iterator().next().values().iterator().next().size() == 1) {

			this.addToTargetModelRoot(
					this.unconnectableElements.values().iterator().next().values().iterator().next().get(0));
			this.logger.info(() -> "Root element: The single instance of the target section '"
					+ this.unconnectableElements.values().iterator().next().keySet().iterator().next().getName()
					+ "'.");
			return;

		}

		// Collect all classes that could act as common root for each of the unconnected elements
		//
		// TODO Support multiple target models
		final Set<EClass> common = new HashSet<>();

		for (final EClass possibleRoot : this.targetSectionRegistry.getMetaModelClasses().stream()
				.filter(e -> !e.isAbstract()).collect(Collectors.toList())) {

			if (this.unconnectableElements.keySet().parallelStream().noneMatch(
					c -> this.targetSectionRegistry.getConnections(c, possibleRoot, this.maxPathLength).isEmpty())) {

				// There is at least one connection for between 'possibleRoot' and each of the elements (resp. the
				// corresponding 'eClasses' that have to be connected)
				//
				common.add(possibleRoot);
			}
		}

		this.checkCanceled();

		if (common.isEmpty()) {

			// No common root class found
			//
			for (final EClass c : this.unconnectableElements.keySet()) {

				this.logger.warning(() -> "No suitable path found for target class: " + c.getName());

				this.unconnectableElements.get(c).values().stream().forEach(this::addToTargetModelRoot);
			}

			return;
		}

		// The eClass that we will use for our new root element
		//
		EClass rootClass;

		if (common.size() == 1) {
			rootClass = common.iterator().next();

		} else {

			// Consult the specified resolving strategy to resolve the ambiguity.
			//
			try {
				this.logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_STARTED);
				List<EClass> resolved = this.ambiguityResolvingStrategy
						.joiningSelectRootElement(new ArrayList<>(common));
				if (this.ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
					((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy)
							.joiningRootElementSelected(new ArrayList<>(common), resolved.get(0));
				}
				this.logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_ENDED);
				rootClass = resolved.get(0);

			} catch (AmbiguityResolvingException e) {
				if (e.getCause() instanceof UserAbortException) {
					throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
				} else {
					this.logger.severe(
							() -> "The following exception occured during the resolving of an ambiguity concerning the selection of a common root class: "
									+ e.getMessage());
					this.logger.severe("Using default path instead...");
					rootClass = common.iterator().next();
				}
			}

		}

		// The new root element
		//
		final EObject containerInstance = rootClass.getEPackage().getEFactoryInstance().create(rootClass);

		this.addToTargetModelRoot(new EObjectWrapper(containerInstance, this.targetSectionRegistry));

		this.logger.info("Root element: '" + rootClass.getName() + "' (generated)");

		for (final Entry<EClass, Map<TargetSectionClass, List<EObjectWrapper>>> unlinkeableEntry : this.unconnectableElements
				.entrySet()) {

			for (final TargetSectionClass tSection : unlinkeableEntry.getValue().keySet()) {
				/*
				 * It gets a bit tricky here. If there is more than one common container, we have to choose one. Then we
				 * need to find all possible connections for each of the elements involved. Now we need to choose a
				 * connection for each element. This might lead to us asking a lot of questions to the user.
				 */
				final List<ModelConnectionPath> pathSet = this.targetSectionRegistry
						.getConnections(unlinkeableEntry.getKey(), rootClass, this.maxPathLength);

				if (pathSet.isEmpty()) {

					this.addToTargetModelRoot(unlinkeableEntry.getValue().get(tSection));// This
					// should
					// not
					// have
					// happened
					// =>
					// programming error
					this.logger.severe("Error. Check container instantiation");

				} else {

					// get paths with fitting capacity
					final int neededCapacity = unlinkeableEntry.getValue().get(tSection).size();
					final LinkedList<ModelConnectionPath> fittingPaths = new LinkedList<>();
					for (final ModelConnectionPath p : pathSet) {
						int capacity = p.getCapacity(containerInstance);
						if (capacity == -1 || capacity >= neededCapacity) {
							fittingPaths.add(p);
						}
					}

					if (!fittingPaths.isEmpty()) {

						ModelConnectionPath chosenPath = fittingPaths.get(0);

						if (fittingPaths.size() > 1) {
							/*
							 * Consult the specified resolving strategy to resolve the ambiguity.
							 */
							try {
								this.logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_STARTED);
								List<ModelConnectionPath> resolved = this.ambiguityResolvingStrategy
										.joiningSelectConnectionPath(fittingPaths, (TargetSection) tSection);
								if (this.ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
									((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy)
											.joiningConnectionPathSelected(new ArrayList<>(fittingPaths),
													resolved.get(0));
								}
								this.logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_ENDED);
								chosenPath = resolved.get(0);

							} catch (AmbiguityResolvingException e) {
								if (e.getCause() instanceof UserAbortException) {
									throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
								} else {
									this.logger.severe(
											() -> "The following exception occured during the resolving of an ambiguity concerning an connection path: "
													+ e.getMessage());
									this.logger.severe("Using default path instead...");
									chosenPath = fittingPaths.get(0);
								}
							}
						}

						// now instantiate path
						chosenPath.instantiate(containerInstance, unlinkeableEntry.getValue().get(tSection));
						this.logger.info("Connected to root: " + tSection.getName() + ": " + chosenPath.toString());
					} else {
						this.logger.warning("The chosen container '" + rootClass.getName()
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
			final TargetSection section, final MappingHintGroupType mappingGroup,
			final Optional<Set<EClass>> containerClasses, final Optional<List<EObjectWrapper>> containerInstances) {

		this.checkCanceled();

		// Nothing to connect
		//
		if (rootInstances == null || rootInstances.isEmpty()) {
			return new ArrayList<>();
		}

		final EClass classToConnect = section.getEClass();

		// A set of ModelConnectionPaths that are possible and thus have to be considered by the selection algorithms.
		//
		List<ModelConnectionPath> pathsToConsider = this.getModelConnectionPathsToConsider(rootInstances,
				containerClasses, classToConnect);

		// If no paths have been found, register the related elements as 'unconnectable' and return.
		//
		if (pathsToConsider.isEmpty()) {

			if (!this.unconnectableElements.containsKey(classToConnect)) {

				this.unconnectableElements.put(classToConnect,
						new LinkedHashMap<TargetSectionClass, List<EObjectWrapper>>());
			}

			if (!this.unconnectableElements.get(classToConnect).containsKey(section)) {

				this.unconnectableElements.get(classToConnect).put(section, new LinkedList<EObjectWrapper>());
			}

			this.unconnectableElements.get(classToConnect).get(section).addAll(rootInstances);

			// Although none of the 'rootInstances' have been connected, we do not return them as 'unconnected
			// instances'. The reason for this is that they will be connected later on when the 'unconnectableElements'
			// are handled
			//
			return new ArrayList<>();
		}

		// Map the possible container instances to the corresponding connection paths
		//
		Map<ModelConnectionPath, List<EObjectWrapper>> containerInstancesByConnectionPaths = new LinkedHashMap<>();
		for (ModelConnectionPath connectionPath : pathsToConsider) {
			List<EObjectWrapper> containerInstancesForConnectionPath = containerInstances.isPresent()
					? containerInstances.get().stream()
							.filter(c -> c.getEObject().eClass().equals(connectionPath.getPathRootClass()))
							.collect(Collectors.toList())
					: this.targetSectionRegistry.getTargetClassInstances(connectionPath.getPathRootClass());
			containerInstancesByConnectionPaths.put(connectionPath, containerInstancesForConnectionPath);
		}

		return this.selectAndInstantiateConnections(rootInstances, containerInstancesByConnectionPaths, mappingGroup);

	}

	/**
	 * This returns the list of potential {@link ModelConnectionPath ModelConnectionPaths} that can be used to connect
	 * the given list of <em>rootInstances</em> to an instance of one of the given <em>containerClasses</em>.
	 *
	 * @param rootInstances
	 *            A list of {@link EObjectWrapper elements} to connect.
	 * @param containerClasses
	 *            An optional set of {@link EClass EClasses} that are considered as target when searching for connection
	 *            paths for the given list of 'rootInstances'.<br />
	 *            <em>Note:</em> If the optional is not present, any EClass will be considered a valid target.
	 * @param classToConnect
	 *            The {@link EClass} of the <em>rootInstances</em> to be connected.
	 * @return The list of {@link ModelConnectionPath ModelConnectionPaths} that can be used to connect the given list
	 *         of <em>rootInstances</em> to instances of one of the given <em>containerClasses</em>.
	 */
	private List<ModelConnectionPath> getModelConnectionPathsToConsider(final List<EObjectWrapper> rootInstances,
			final Optional<Set<EClass>> containerClasses, final EClass classToConnect) {

		List<ModelConnectionPath> pathsToConsider = new LinkedList<>();

		if (containerClasses.isPresent()) {
			// A list of possible 'containerClasses' has been passed as parameter so we need to restrict the list of
			// EClass that are considered when searching for connection paths.
			//
			pathsToConsider.addAll(containerClasses.get().stream().flatMap(
					c -> this.targetSectionRegistry.getConnections(classToConnect, c, this.maxPathLength).stream())
					.collect(Collectors.toSet()));
		} else {

			pathsToConsider.addAll(this.targetSectionRegistry.getPaths(classToConnect, this.maxPathLength));
		}

		// Reduce the found paths to those that provide the necessary capacity.
		//
		pathsToConsider = ModelConnectionPath.findPathsWithMinimumCapacity(pathsToConsider, null, rootInstances.size());

		// Remove those paths that would lead to cyclic containments
		//
		for (final ModelConnectionPath p : new LinkedList<>(pathsToConsider)) {

			List<EObject> possibleContainerInstances = this.targetSectionRegistry
					.getTargetClassInstances(pathsToConsider.iterator().next().getPathRootClass()).parallelStream()
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

	/**
	 * Try to join the given list of 'rootInstances' (and therefore entire sections of the target model) with other
	 * objects of the target model.
	 * <p>
	 * This method is used for connecting sections using a given {@link ContainerSelector}.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage} representing the given <em>rootInstances</em>.
	 * @param rootInstances
	 *            A list of {@link EObjectWrapper elements} to connect (created based on the given
	 *            <em>mappingInstance</em>).
	 * @param mappingGroup
	 *            The {@link MappingHintGroupType} that is used.
	 * @param containerSelectors
	 *            The list of {@link ContainerSelector ContainerSelectors} to be used to connect the given instances.
	 * @return A list of {@link EObjectWrapper instances} that could not be connected (a sub-list of the given
	 *         <em>rootInstances</em> or an empty list).
	 */
	private List<EObjectWrapper> joinWithContainerSelectors(MappingInstanceStorage mappingInstance,
			final List<EObjectWrapper> rootInstances, final MappingHintGroupType mappingGroup,
			List<ContainerSelector> containerSelectors) {

		this.checkCanceled();

		// Nothing to connect
		//
		if (rootInstances == null || rootInstances.isEmpty()) {
			return new ArrayList<>();
		}

		// All potential connection paths
		//
		Map<ContainerSelector, List<ModelConnectionPath>> connectionPathsByContainerSelector = this
				.getConnectionPathsByContainerSelector(containerSelectors, mappingGroup.getTargetSection().getEClass());

		// All potential container instances
		//
		Map<ContainerSelector, List<EObjectWrapper>> containerInstancesByContainerSelector = this
				.getContainerInstancesByContainerSelector(new ArrayList<>(connectionPathsByContainerSelector.keySet()),
						mappingInstance);

		// None of the potential container instances matches one of the hint values
		//
		if (containerInstancesByContainerSelector.isEmpty()) {
			return rootInstances;
		}

		// Discard those ContainerSelector for which there are no potential container instances
		//
		connectionPathsByContainerSelector = connectionPathsByContainerSelector.entrySet().stream()
				.filter(e -> containerInstancesByContainerSelector.containsKey(e.getKey()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));

		// Map the possible container instances to the corresponding connection paths
		//
		Map<ModelConnectionPath, List<EObjectWrapper>> containerInstancesByConnectionPaths = new LinkedHashMap<>();
		for (ContainerSelector containerSelector : connectionPathsByContainerSelector.keySet()) {
			for (ModelConnectionPath connectionPath : connectionPathsByContainerSelector.get(containerSelector)) {
				Set<EObjectWrapper> containerInstances = new LinkedHashSet<>(
						containerInstancesByConnectionPaths.getOrDefault(connectionPath, new ArrayList<>()));
				containerInstances.addAll(containerInstancesByContainerSelector.get(containerSelector));
				containerInstancesByConnectionPaths.put(connectionPath, new ArrayList<>(containerInstances));
			}
		}

		return this.selectAndInstantiateConnections(rootInstances, containerInstancesByConnectionPaths, mappingGroup);
	}

	/**
	 * Based on the given <em>connectionChoices</em>, join the given list of <em>rootInstances</em> with other objects
	 * of the target model.
	 * <p />
	 * If there are multiple possible connection choices (either multiple {@link ModelConnectionPath connection paths}
	 * and/or multiple {@link EObjectWrapper container instances}, this will select one of the possibilities by using
	 * the appropriate {@link #ambiguityResolvingStrategy}.
	 *
	 * @param rootInstances
	 *            A list of {@link EObjectWrapper elements} to connect (created based on the given
	 *            <em>mappingInstance</em>).
	 * @param connectionChoices
	 *            A map representing the possible connection choices (each consisting of a {@link ModelConnectionPath
	 *            connection path} and a {@link EObjectWrapper container instance}).
	 * @param mappingGroup
	 *            The {@link MappingHintGroupType} that is used.
	 *
	 * @return A list of {@link EObjectWrapper instances} that could not be connected (a sub-list of the given
	 *         <em>rootInstances</em> or an empty list).
	 */
	private List<EObjectWrapper> selectAndInstantiateConnections(final List<EObjectWrapper> rootInstances,
			Map<ModelConnectionPath, List<EObjectWrapper>> connectionChoices, final MappingHintGroupType mappingGroup) {

		// The list of Connections that will get instantiated in the end
		//
		List<Connection> selectedConnections = new ArrayList<>();

		// The list of (distinct) container instances represented by the 'connectionChoices'
		//
		List<EObjectWrapper> containerInstances = new ArrayList<>(
				connectionChoices.values().stream().flatMap(List::stream).collect(Collectors.toSet()));

		if (containerInstances.size() == rootInstances.size()) {
			// This is the special case where there is exactly one container instance per root instance -> We connect
			// each root instance to its own container instance if there is a connection path that can be used for each
			// container instance
			//

			// The set of connection choices that provide exactly as many container elements as root elements
			//
			Map<ModelConnectionPath, List<EObjectWrapper>> limitedConnectionChoices = connectionChoices.entrySet()
					.stream().filter(e -> e.getValue().size() == containerInstances.size())
					.collect(Collectors.toMap(Entry::getKey, Entry::getValue));

			if (limitedConnectionChoices.isEmpty()) {
				// Fall back to the 'default' behavior (use the same container instance for each root instance)
				//
				selectedConnections
						.add(this.getConnectionToInstantiate(rootInstances, connectionChoices, mappingGroup));
			} else {
				// Create a distinct connection for each pair of container/root instances
				//
				Map<EObjectWrapper, EObjectWrapper> containerInstanceByRootInstance = IntStream
						.range(0, rootInstances.size()).boxed()
						.collect(Collectors.toMap(rootInstances::get, containerInstances::get));

				selectedConnections.addAll(containerInstanceByRootInstance.entrySet().stream()
						.map(e -> this.getConnectionToInstantiate(Arrays.asList(e.getKey()),
								new ArrayList<>(limitedConnectionChoices.keySet()), e.getValue(), mappingGroup))
						.collect(Collectors.toList()));
			}

		} else {
			// This is the default case where each root instance is connected to the same container instance
			//
			selectedConnections.add(this.getConnectionToInstantiate(rootInstances, connectionChoices, mappingGroup));
		}

		// Instantiate each selected connection and return the elements the could not be connected
		//
		return selectedConnections.stream().flatMap(connection -> connection.instantiate().stream())
				.collect(Collectors.toList());
	}

	/**
	 * This just merges the given <em>rootInstance</em>, <em>connectionPath</em> and <em>containerInstance</em> to a
	 * {@link Connection} that can be instantiated. Additionally, if this represents a <em>new</em> connection path for
	 * the given <em>mappingGroup</em>, the list of {@link #standardPaths} is updated and a log message is printed.
	 *
	 * @param rootInstances
	 *            The list of {@link EObjectWrapper elements} to join.
	 * @param connectionpath
	 *            The {@link ModelConnectionPath connection path} to use for the connection.
	 * @param containerInstance
	 *            The {@link EObjectWrapper container instance} to use.
	 * @param mappingGroup
	 *            The {@link MappingHintGroupType} that is used.
	 * @return The {@link Connection} that should be used to join the given list of <em>rootInstances</em>.
	 */
	private Connection getConnectionToInstantiate(final List<EObjectWrapper> rootInstances,
			final ModelConnectionPath connectionPath, final EObjectWrapper containerInstance,
			final MappingHintGroupType mappingGroup) {

		Connection connectionToInstantiate = new Connection(containerInstance, connectionPath, rootInstances);

		if (!this.standardPaths.containsKey(mappingGroup) || this.standardPaths.get(mappingGroup) != connectionPath) {

			this.standardPaths.put(mappingGroup, connectionPath);

			this.logger.info(() -> mappingGroup.getTargetSection().getName() + " ("
					+ ((Mapping) mappingGroup.eContainer()).getName() + "): "
					+ connectionToInstantiate.getConnectionPath().toString());
		}

		return connectionToInstantiate;
	}

	/**
	 * Based on the given list of <em>connectionPaths</em>, selects exactly one that should be used to join the given
	 * list of <em>rootInstances</em> to the given <em>containerInstance</em>.
	 * <p />
	 * Note: This simply redirects to {@link #getConnectionToInstantiate(List, Map, MappingHintGroupType)}.
	 *
	 * @param rootInstances
	 *            A list of {@link EObjectWrapper elements} to join.
	 * @param connectionPaths
	 *            The list of possible {@link ModelConnectionPath ModelConnectionPaths} to use for the connection.
	 * @param containerInstance
	 *            The {@link EObjectWrapper container instance} for the connection.
	 * @param mappingGroup
	 *            The {@link MappingHintGroupType} that is used.
	 * @return The {@link Connection} that should be used to join the given list of <em>rootInstances</em>.
	 */
	private Connection getConnectionToInstantiate(final List<EObjectWrapper> rootInstances,
			List<ModelConnectionPath> connectionPaths, EObjectWrapper containerInstance,
			final MappingHintGroupType mappingGroup) {

		// If there is already a 'standardPath' for the given 'mappingGroup', we reuse this standard path
		//
		ModelConnectionPath standardPath = this.standardPaths.getOrDefault(mappingGroup, null);
		if (standardPath != null && connectionPaths.contains(standardPath)) {

			return this.getConnectionToInstantiate(rootInstances, standardPath, containerInstance, mappingGroup);
		}

		Map<ModelConnectionPath, List<EObjectWrapper>> connectionChoices = connectionPaths.stream()
				.collect(Collectors.toMap(Function.identity(), c -> Arrays.asList(containerInstance)));

		return this.getConnectionToInstantiate(rootInstances, connectionChoices, mappingGroup);
	}

	/**
	 * Based on the given list of <em>containerInstances</em>, selects exactly one that should be used to join the given
	 * list of <em>rootInstances</em>.
	 * <p />
	 * Note: This simply redirects to {@link #getConnectionToInstantiate(List, Map, MappingHintGroupType)}.
	 *
	 * @param rootInstances
	 *            A list of {@link EObjectWrapper elements} to join.
	 * @param connectionPath
	 *            The {@link ModelConnectionPath} to use for the connection.
	 * @param containerInstances
	 *            The list of possible {@link EObjectWrapper container instances} for the connection.
	 * @param mappingGroup
	 *            The {@link MappingHintGroupType} that is used.
	 * @return The {@link Connection} that should be used to join the given list of <em>rootInstances</em>.
	 */
	private Connection getConnectionToInstantiate(final List<EObjectWrapper> rootInstances,
			ModelConnectionPath connectionPath, List<EObjectWrapper> containerInstances,
			final MappingHintGroupType mappingGroup) {

		EObjectWrapper selectedContainerInstance;

		if (containerInstances.size() == 1) {

			selectedContainerInstance = containerInstances.get(0);

		} else {

			// There are multiple possible container instances
			//
			try {
				this.logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_STARTED);

				selectedContainerInstance = this.ambiguityResolvingStrategy
						.joiningSelectContainerInstance(containerInstances, rootInstances, mappingGroup, null, null)
						.iterator().next();
				if (this.ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
					((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy)
							.joiningContainerInstanceSelected(containerInstances, selectedContainerInstance);
				}
				this.logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_ENDED);

			} catch (AmbiguityResolvingException e) {
				if (e.getCause() instanceof UserAbortException) {
					throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
				} else {
					this.logger.severe(
							() -> "The following exception occured during the resolving of an ambiguity concerning the selection of a container instance: "
									+ e.getMessage());
					this.logger.severe("Using default path and instance instead...");
					selectedContainerInstance = containerInstances.get(0);
				}
			}
		}

		return this.getConnectionToInstantiate(rootInstances, connectionPath, selectedContainerInstance, mappingGroup);
	}

	/**
	 * Based on the given map of <em>connectionChoices</em>, selects exactly one possible connection (consisting of a
	 * {@link ModelConnectionPath} and a {@link EObjectWrapper container instance} that should be used to join the given
	 * list of <em>rootInstances</em>.
	 *
	 * @param rootInstances
	 *            A list of {@link EObjectWrapper elements} to join.
	 * @param connectionChoices
	 *            A map representing the possible connection choices (each consisting of a {@link ModelConnectionPath
	 *            connection path} and a {@link EObjectWrapper container instance}).
	 * @param mappingGroup
	 *            The {@link MappingHintGroupType} that is used.
	 * @return The {@link Connection} that should be used to join the given list of <em>rootInstances</em>.
	 */
	private Connection getConnectionToInstantiate(final List<EObjectWrapper> rootInstances,
			Map<ModelConnectionPath, List<EObjectWrapper>> connectionChoices, final MappingHintGroupType mappingGroup) {

		// If there is already a 'standardPath' for the given 'mappingGroup', we reuse this standard path
		//
		ModelConnectionPath standardPath = this.standardPaths.getOrDefault(mappingGroup, null);
		if (standardPath != null && connectionChoices.containsKey(standardPath) && connectionChoices.size() > 1) {

			return this.getConnectionToInstantiate(rootInstances, standardPath, connectionChoices.get(standardPath),
					mappingGroup);
		}

		if (connectionChoices.keySet().size() == 1
				&& connectionChoices.values().stream().flatMap(List::stream).collect(Collectors.toSet()).size() == 1) {

			// There is only one possible connection path and container instance
			//
			ModelConnectionPath connectionPath = connectionChoices.keySet().iterator().next();
			return this.getConnectionToInstantiate(rootInstances, connectionPath,
					connectionChoices.get(connectionPath).iterator().next(), mappingGroup);

		} else if (connectionChoices.keySet().size() == 1) {

			// If there is only one possible connection path, we only need to let the user choose the
			// container instance
			//
			ModelConnectionPath connectionPath = connectionChoices.keySet().iterator().next();
			return this.getConnectionToInstantiate(rootInstances, connectionPath, connectionChoices.get(connectionPath),
					mappingGroup);

		} else {

			ModelConnectionPath selectedConnectionPath;
			EObjectWrapper selectedContainerInstance;

			// There are multiple possible connection paths and/or container instances
			//
			try {
				this.logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_STARTED);

				Map<ModelConnectionPath, List<EObjectWrapper>> resolved;
				if (connectionChoices.values().stream().flatMap(List::stream).collect(Collectors.toSet()).size() == 1) {
					// If there is only one possible container instance, we only need to let the user choose the
					// connection path
					//
					List<ModelConnectionPath> resolvedPaths = this.ambiguityResolvingStrategy
							.joiningSelectConnectionPath(new ArrayList<>(connectionChoices.keySet()),
									mappingGroup.getTargetSection());
					resolved = resolvedPaths.stream()
							.collect(Collectors.toMap(Function.identity(), connectionChoices::get));
					selectedConnectionPath = resolvedPaths.get(0);
				} else {
					// Otherwise, the user needs to select the connection path as well as the container instance
					//
					resolved = this.ambiguityResolvingStrategy.joiningSelectConnectionPathAndContainerInstance(
							connectionChoices, mappingGroup.getTargetSection(), rootInstances, mappingGroup);
					selectedConnectionPath = resolved.entrySet().iterator().next().getKey();
				}

				selectedContainerInstance = resolved.entrySet().iterator().next().getValue().get(0);
				if (this.ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
					((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy).joiningConnectionPathSelected(
							new ArrayList<>(connectionChoices.keySet()), selectedConnectionPath);
					((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy).joiningContainerInstanceSelected(
							new ArrayList<>(connectionChoices.get(selectedConnectionPath)), selectedContainerInstance);
				}
				this.logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_ENDED);

			} catch (AmbiguityResolvingException e) {
				if (e.getCause() instanceof UserAbortException) {
					throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
				} else {
					this.logger.severe(
							() -> "The following exception occured during the resolving of an ambiguity concerning the selection of a common root element: "
									+ e.getMessage());
					this.logger.severe("Using default path and instance instead...");
					selectedConnectionPath = connectionChoices.keySet().iterator().next();
					selectedContainerInstance = connectionChoices.get(selectedConnectionPath).get(0);
				}
			}

			return this.getConnectionToInstantiate(rootInstances, selectedConnectionPath, selectedContainerInstance,
					mappingGroup);
		}

	}

	/**
	 * For each of the given {@link ContainerSelector ContainerSelectors}, determines the list of
	 * {@link ModelConnectionPath ModelConnectionPaths} that can be used to connect instances of the given
	 * {@link EClass} to instances of the {@link ContainerSelector#getTargetClass() targetClass} of the
	 * ContainerSelector.
	 * <p />
	 * Note: Those ContainerSelectors for that there is no possible ModelConnectionPath are not represented in the
	 * returned Map. Put another way, each of the values of the returned map will contain at least one
	 * ModelConnectionPath.
	 * <p />
	 * Note: Only direct {@link ModelConnectionPath connection paths} (with a length of '0') are considered because the
	 * user specified a {@link ContainerSelector}.
	 *
	 * @param containerSelectors
	 *            The list of {@link ContainerSelector ContainerSelectors} to evaluate.
	 * @param eClass
	 *            The {@link EClass} for which connection shall be determined.
	 * @return The list of potential {@link ModelConnectionPath ModelConnectionPaths} for each of the given
	 *         {@link ContainerSelector ContainerSelectors}.
	 */
	private Map<ContainerSelector, List<ModelConnectionPath>> getConnectionPathsByContainerSelector(
			List<ContainerSelector> containerSelectors, EClass eClass) {

		Map<ContainerSelector, List<ModelConnectionPath>> connectionPathsByContainerSelector = new LinkedHashMap<>();
		for (ContainerSelector containerSelector : containerSelectors) {

			// Check if there are any possible connection paths based on the specified 'targetClass' of the given
			// container
			// selector
			//
			List<ModelConnectionPath> pathsToConsider = this.targetSectionRegistry.getConnections(eClass,
					containerSelector.getTargetClass().getEClass(), 0);
			if (pathsToConsider.isEmpty()) {

				this.logger.warning(() -> "Could not find a path that leads to the 'targetClass' specified for the "
						+ containerSelector.printInfo());

			} else {

				connectionPathsByContainerSelector.put(containerSelector, pathsToConsider);
			}
		}

		return connectionPathsByContainerSelector;
	}

	/**
	 * For each of the given {@link ContainerSelector ContainerSelectors}, determines the list of {@link EObjectWrapper
	 * container instances} satisfying at least one of the hint values for the given {@link MappingInstanceStorage} (a
	 * subset of all instantiated elements of the {@link ContainerSelector#getTargetClass() target class} specified by
	 * the respective ContainerSelector).
	 * <p />
	 * Note: Those ContainerSelectors for that there is no possible container instance are not represented in the
	 * returned Map. Put another way, each of the values of the returned map will contain at least one container
	 * instance.
	 *
	 * @param containerSelectors
	 *            The list of {@link ContainerSelector ContainerSelectors} to evaluate.
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage} providing the hint values for the given
	 *            <em>containerSelectors</em>.
	 * @return The list of potential {@link EObjectWrapper container instances} for each of the given
	 *         {@link ContainerSelector ContainerSelectors}.
	 */
	private Map<ContainerSelector, List<EObjectWrapper>> getContainerInstancesByContainerSelector(
			List<ContainerSelector> containerSelectors, MappingInstanceStorage mappingInstance) {

		Map<ContainerSelector, List<EObjectWrapper>> containerInstancesByContainerSelector = new LinkedHashMap<>();

		for (ContainerSelector containerSelector : containerSelectors) {

			// The instances of the specified 'targetClass' -> These are the potential containers
			//
			List<EObjectWrapper> possibleContainerInstances = this.targetSectionRegistry
					.getFlattenedPamtramClassInstances(containerSelector.getTargetClass());

			// Filter those that satisfy one of the calculated hint values
			//
			possibleContainerInstances = this.instanceSelectorHandler.filterTargetInstances(possibleContainerInstances,
					mappingInstance.getHintValues().getHintValues(containerSelector), containerSelector);

			if (!possibleContainerInstances.isEmpty()) {
				containerInstancesByContainerSelector.put(containerSelector, possibleContainerInstances);
			}
		}

		return containerInstancesByContainerSelector;
	}

	/**
	 * A class that represents a connection between model elements to be instantiated. Each connection is characterized
	 * by a {@link #containerInstance} (the starting point of the connection), a {@link #connectionPath}, and a set of
	 * {@link #rootInstances} (the end point of the connection).
	 *
	 * @author mfreund
	 */
	public class Connection {

		/**
		 * The {@link EObjectWrapper model element} representing the starting point of the connection to be
		 * instantiated.
		 */
		protected EObjectWrapper containerInstance;

		/**
		 * The {@link ModelConnectionPath connection path} to be instantiated.
		 */
		protected ModelConnectionPath connectionPath;

		/**
		 * The {@link EObjectWrapper model element(s)} to be connected to the {@link #containerInstance} via the
		 * {@link #connectionPath}.
		 */
		protected Set<EObjectWrapper> rootInstances;

		/**
		 * This creates an instance.
		 *
		 * @param containerInstance
		 * @param connectionPath
		 */
		public Connection(EObjectWrapper containerInstance, ModelConnectionPath connectionPath) {

			this(containerInstance, connectionPath, new ArrayList<>());
		}

		/**
		 * This creates an instance.
		 *
		 * @param containerInstance
		 * @param connectionPath
		 * @param rootInstances
		 */
		public Connection(EObjectWrapper containerInstance, ModelConnectionPath connectionPath,
				Collection<EObjectWrapper> rootInstances) {

			this.containerInstance = containerInstance;
			this.connectionPath = connectionPath;
			this.rootInstances = rootInstances != null ? new LinkedHashSet<>(rootInstances) : new LinkedHashSet<>();
		}

		/**
		 * @return the {@link #containerInstance}
		 */
		public EObjectWrapper getContainerInstance() {

			return this.containerInstance;
		}

		/**
		 * @return the {@link #connectionPath}
		 */
		public ModelConnectionPath getConnectionPath() {

			return this.connectionPath;
		}

		/**
		 * @return the {@link #rootInstances}
		 */
		public Set<EObjectWrapper> getRootInstances() {

			return this.rootInstances;
		}

		/**
		 * Adds a list of {@link EObjectWrapper model elements} to the existing list of {@link #rootInstances}.
		 *
		 * @param rootInstances
		 */
		public void addRootInstances(Collection<EObjectWrapper> rootInstances) {

			this.rootInstances.addAll(rootInstances);
		}

		/**
		 * Instantiates this connection by invoking {@link ModelConnectionPath#instantiate(EObject, Collection)}.
		 *
		 * @return A list of elements (a subset of the {@link #rootInstances}) that could not be connected (possibly
		 *         because the capacity of the path was not large enough).
		 */
		public List<EObjectWrapper> instantiate() {

			return this.connectionPath.instantiate(this.containerInstance.getEObject(), this.rootInstances);
		}
	}

}
