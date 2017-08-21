package de.mfreund.gentrans.transformation.expanding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.mfreund.gentrans.transformation.CancelTransformationException;
import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.calculation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
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
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.target.FileType;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
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
	 * This list stores those {@link ModelConnectionPath ModelConnectionPaths} that have beepreviously selected by the
	 * user for a given {@link ContainerSelector}.
	 */
	private final LinkedHashMap<ContainerSelector, ModelConnectionPath> standardPaths;

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
	 * The {@link AttributeValueModifierExecutor} that is used to modify attribute values. This is necessary to
	 * calculate the values of {@link ContainerSelectorTargetAttribute ModelConnectionHintTargetAttributes} that are
	 * evaluated here.
	 */
	private final AttributeValueModifierExecutor attributeValuemodifier;

	/**
	 * The maximum length for connection paths that shall be considered by this TargetSectionConnector. If
	 * 'maxPathLength' is set to '-1' or any other value below '0', connection paths of unbounded length are considered.
	 */
	private final int maxPathLength;

	/**
	 * This keeps track of {@link TargetSectionClass TargetSectionClasses} and corresponding {@link EObjectWrapper
	 * EObjects} for that no ModelConnectionPath could be determined. The key of the Map thereby denotes the
	 * {@link EClass} that the TargetSectionClasses are associated with.
	 */
	private final Map<EClass, Map<TargetSectionClass, List<EObjectWrapper>>> unlinkeableElements;

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
	 * @param attributeValuemodifier
	 *            An {@link AttributeValueModifierExecutor} that is used to modify attribute values. This is necessary
	 *            to calculate the values of {@link ContainerSelectorTargetAttribute
	 *            ModelConnectionHintTargetAttributes} that are evaluated here.
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
			final AttributeValueModifierExecutor attributeValuemodifier, final TargetModelRegistry targetModelRegistry,
			final int maxPathLength, final IAmbiguityResolvingStrategy ambiguityResolvingStrategy,
			final Logger logger) {

		this.standardPaths = new LinkedHashMap<>();
		this.targetSectionRegistry = targetSectionRegistry;
		this.targetModelRegistry = targetModelRegistry;
		this.logger = logger;
		this.canceled = false;
		this.attributeValuemodifier = attributeValuemodifier;
		this.maxPathLength = maxPathLength;
		this.ambiguityResolvingStrategy = ambiguityResolvingStrategy;
		this.unlinkeableElements = new LinkedHashMap<>();
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
				.allMatch(g -> this.joinTargetSection(g, mapping, mappingInstances, targetSectionRegistry))) {

			return false;
		}

		// Join 'imported' hint groups
		//
		if (!mapping.getActiveImportedMappingHintGroups().stream()
				.filter(i -> i.getHintGroup() != null && i.getHintGroup().getTargetSection() != null)
				.allMatch(i -> this.joinTargetSection(i, mapping, mappingInstances, targetSectionRegistry))) {

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
	 * @param mapping
	 *            The {@link Mapping} responsible for the creation of the {@link TargetSection TargetSections} to join.
	 * @param mappingInstances
	 *            The list of {@link MappingInstanceStorage instances} created based on the given {@link Mapping}.
	 * @param targetSectionRegistry
	 *            The {@link TargetSectionRegistry} that keeps track of instantiated sections.
	 *
	 * @return '<em><b>true</b></em>' if all instances of the TargetSection were joined successfully;
	 *         '<em><b>false</b></em>' otherwise
	 */
	private boolean joinTargetSection(final MappingHintGroupType hintGroup, final Mapping mapping,
			final List<MappingInstanceStorage> mappingInstances, final TargetSectionRegistry targetSectionRegistry) {

		this.checkCanceled();

		// The TargetSection of which we want to joing created instances
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

		List<ContainerSelector> containerSelectors = hintGroup.getContainerSelectors();

		if (!containerSelectors.isEmpty()) { // link using ContainerSelector(s)

			for (final MappingInstanceStorage selMap : mappingInstances) {

				// The target model elements that need to connected to a
				// container element
				//
				List<EObjectWrapper> instancesToConnect = selMap.getInstances((MappingHintGroup) hintGroup, section);

				if (instancesToConnect == null || instancesToConnect.isEmpty()) {
					continue;
				}

				for (ContainerSelector containerSelector : containerSelectors) {

					if (hintGroup instanceof ConditionalElement
							&& selMap.isElementWithNegativeCondition((ConditionalElement) hintGroup)) {
						continue;
					}

					if (this.isCanceled()) {
						return false;
					}

					// Try to connect the remaining instances with the current
					// ContainerSelector and collect the unconnectable instances
					// for further ContainerSelectors
					//
					instancesToConnect = this.linkToTargetModelUsingModelConnectionHint(instancesToConnect, section,
							mapping.getName(), hintGroup, containerSelector,
							selMap.getHintValues().getHintValues(containerSelector));

					if (this.isCanceled()) {

						return false;
					}
				}

				// After evaluation of all ContainerSelectors, if there are
				// still unconnected instances, we add them as new root elements
				//
				this.addToTargetModelRoot(instancesToConnect);
			}
		} else {// link using container attribute or nothing

			final List<EObjectWrapper> containerInstances = targetSectionRegistry
					.getFlattenedPamtramClassInstances(section.getContainer());

			/*
			 * fetch ALL instances created by the MH-Group in question => less user input and possibly shorter
			 * processing time
			 */
			final List<EObjectWrapper> rootInstances = targetSectionRegistry.getPamtramClassInstances(section)
					.get(hintGroup);

			/*
			 * do not want the root instances to contain themselves
			 */
			containerInstances.removeAll(rootInstances);// we

			this.linkToTargetModelNoConnectionHint(rootInstances, section, mapping.getName(), hintGroup,
					section.getContainer() != null ? new HashSet<>(Arrays.asList(section.getContainer().getEClass()))
							: null,
					containerInstances);

		}

		return true;
	}

	/**
	 * Join the {@link TargetSection} instances created by the given {@link MappingHintGroupType}.
	 *
	 * @param hintGroupImporter
	 *            The {@link MappingHintGroupImporter} responsible for the creation of the {@link TargetSection
	 *            TargetSections} to join.
	 * @param mapping
	 *            The {@link Mapping} responsible for the creation of the {@link TargetSection TargetSections} to join.
	 * @param mappingInstances
	 *            The list of {@link MappingInstanceStorage instances} created based on the given {@link Mapping}.
	 * @param targetSectionRegistry
	 *            The {@link TargetSectionRegistry} that keeps track of instantiated sections.
	 *
	 * @return '<em><b>true</b></em>' if all instances of the TargetSection were joined successfully;
	 *         '<em><b>false</b></em>' otherwise
	 */
	private boolean joinTargetSection(final MappingHintGroupImporter hintGroupImporter, final Mapping mapping,
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
					this.linkToTargetModelNoConnectionHint(rootInstances, g.getTargetSection(), mapping.getName(), g,
							new HashSet<>(Arrays.asList(hintGroupImporter.getContainer().getEClass())),
							containerInstances);

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
				this.linkToTargetModelNoConnectionHint(rootInstances, g.getTargetSection(), mapping.getName(), g,
						containerClasses, containerInstances);
			}
		}

		return true;
	}

	/**
	 * This adds the given list of {@link EObjectWrapper elements} as root objects to the target model.
	 *
	 * @param elementsToAdd
	 *            The list of {@link EObjectWrapper elements} to add.
	 */
	public void addToTargetModelRoot(final Collection<EObjectWrapper> elementsToAdd) {

		elementsToAdd.stream().forEach(this::addToTargetModelRoot);
	}

	/**
	 * This adds the given {@link EObjectWrapper element} as root object to the target model.
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
	 * This takes the list of {@link #unlinkeableElements} and adds them to the target model.
	 * <p />
	 * In the easiest case, the list of {@link #unlinkeableElements} contains only a single element which will then be
	 * used as root element. If multiple elements exist, this tries to determine a common root element and joins the
	 * elements with it. If no common root element can be determined, multiple root elements are added to the target
	 * model.
	 */
	public void combineUnlinkedSectionsWithTargetModelRoot() {

		// nothing to do
		//
		if (this.unlinkeableElements.isEmpty()) {
			return;
		}

		/*
		 * only one element could not be connected = > we already have our container
		 */
		if (this.unlinkeableElements.keySet().size() == 1
				&& this.unlinkeableElements.values().iterator().next().keySet().size() == 1
				&& this.unlinkeableElements.values().iterator().next().values().iterator().next().size() == 1) {

			this.addToTargetModelRoot(
					this.unlinkeableElements.values().iterator().next().values().iterator().next().get(0));
			this.logger.info(() -> "Root element: The single instance of the target section '"
					+ this.unlinkeableElements.values().iterator().next().keySet().iterator().next().getName() + "'.");
			return;

		}

		/*
		 * Now that the "special" case was handled we need to handle all the other cases.
		 */
		final Set<EClass> common = new HashSet<>();
		for (final EClass possibleRoot : this.targetSectionRegistry.getMetaModelClasses()) {

			boolean failed = false;
			if (!possibleRoot.isAbstract()) {
				for (final EClass c : this.unlinkeableElements.keySet()) {
					if (this.canceled) {
						return;
					}
					if (this.targetSectionRegistry.getConnections(c, possibleRoot, this.maxPathLength).isEmpty()) {
						failed = true;
						break;
					}
				}
				if (!failed) {
					common.add(possibleRoot);
				}
			}
		}

		if (this.canceled) {
			return;
		}

		if (common.isEmpty()) {

			for (final EClass c : this.unlinkeableElements.keySet()) {

				this.logger.warning(() -> "No suitable path found for target class: " + c.getName());

				this.unlinkeableElements.get(c).values().stream().forEach(this::addToTargetModelRoot);
			}
		} else {

			EClass rootClass;
			if (common.size() == 1) {
				rootClass = common.iterator().next();
			} else {

				/*
				 * Consult the specified resolving strategy to resolve the ambiguity.
				 */
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

			final EObject containerInstance = rootClass.getEPackage().getEFactoryInstance().create(rootClass);

			this.addToTargetModelRoot(
					new EObjectWrapper(containerInstance, this.targetSectionRegistry.getAttrValRegistry()));

			this.logger.info("Root element: '" + rootClass.getName() + "' (generated)");

			for (final Entry<EClass, Map<TargetSectionClass, List<EObjectWrapper>>> unlinkeableEntry : this.unlinkeableElements
					.entrySet()) {

				for (final TargetSectionClass tSection : unlinkeableEntry.getValue().keySet()) {
					/*
					 * It gets a bit tricky here. If there is more than one common container, we have to choose one.
					 * Then we need to find all possible connections for each of the elements involved. Now we need to
					 * choose a connection for each element. This might lead to us asking a lot of questions to the
					 * user.
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
										throw new CancelTransformationException(e.getCause().getMessage(),
												e.getCause());
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
	 * @param mappingName
	 *            The name of the {@link Mapping} that is used.
	 * @param mappingGroup
	 *            The {@link MappingHintGroupType} that is used.
	 * @param containerClasses
	 *            A list of {@link EClass EClasses} that are considered as target when searching for connection paths
	 *            for the given list of 'rootInstances'.<br />
	 *            <em>Note:</em> If this is '<em>null</em>' or if the list is empty, any EClass will be considered a
	 *            valid target.
	 * @param containerInstances
	 *            A list of container elements that may be used as container (this needs to be all instances if
	 *            '<em>hasContainer</em>' is <em>false</em>.
	 */
	public void linkToTargetModelNoConnectionHint(final List<EObjectWrapper> rootInstances, final TargetSection section,
			final String mappingName, final MappingHintGroupType mappingGroup, final Set<EClass> containerClasses,
			final List<EObjectWrapper> containerInstances) {

		this.checkCanceled();

		// nothing to connect
		if (rootInstances == null || rootInstances.isEmpty()) {
			return;
		}

		/*
		 * A list of possible 'containerClasses' has been passed as parameter so we need to restrict the list of EClass
		 * that are considered when searching for connection paths.
		 */
		boolean restrictContainer = containerClasses != null && !containerClasses.isEmpty();

		/*
		 * This represents the final ModelConnectionPath that will be instantiated at the end.
		 */
		ModelConnectionPath modelConnectionPath;

		final EClass classToConnect = section.getEClass();

		/*
		 * A set of ModelConnectionPaths that are possible and thus have to be considered by the selection algorithms.
		 */
		List<ModelConnectionPath> pathsToConsider = new LinkedList<>();
		if (restrictContainer) {
			for (final EClass c : containerClasses) {
				pathsToConsider
						.addAll(this.targetSectionRegistry.getConnections(classToConnect, c, this.maxPathLength));
			}
		} else {
			pathsToConsider.addAll(this.targetSectionRegistry.getPaths(classToConnect, this.maxPathLength));
		}

		/*
		 * Reduce the found paths to those that provide the necessary capacity.
		 */
		pathsToConsider = ModelConnectionPath.findPathsWithMinimumCapacity(pathsToConsider, null, rootInstances.size());

		/*
		 * Remove those paths that would lead to cyclic containments
		 */
		for (final ModelConnectionPath p : new LinkedList<>(pathsToConsider)) {

			List<EObject> possibleContainerInstances = this.targetSectionRegistry
					.getTargetClassInstances(pathsToConsider.iterator().next().getPathRootClass()).parallelStream()
					.map(i -> i.getEObject()).collect(Collectors.toList());

			List<EObject> rootInstancesToConnect = rootInstances.parallelStream().map(i -> i.getEObject())
					.collect(Collectors.toList());

			possibleContainerInstances.removeAll(rootInstancesToConnect);

			if (possibleContainerInstances.isEmpty() || possibleContainerInstances.stream()
					.anyMatch(c -> EcoreUtil.isAncestor(rootInstancesToConnect, c))) {

				pathsToConsider.remove(p);

			}

		}

		/*
		 * If no paths have been found, register the related elements as 'unlinkable' and return.
		 */
		if (pathsToConsider.isEmpty()) {

			if (!this.unlinkeableElements.containsKey(classToConnect)) {

				this.unlinkeableElements.put(classToConnect,
						new LinkedHashMap<TargetSectionClass, List<EObjectWrapper>>());
			}

			if (!this.unlinkeableElements.get(classToConnect).containsKey(section)) {

				this.unlinkeableElements.get(classToConnect).put(section, new LinkedList<EObjectWrapper>());
			}

			this.unlinkeableElements.get(classToConnect).get(section).addAll(rootInstances);
			return;
		}

		/*
		 * Only go on with paths that could theoretically fit all of the elements
		 */
		if (pathsToConsider.isEmpty()) {
			// TODO handle limited capacity
			this.addToTargetModelRoot(rootInstances);
			return;
		}

		// handle container
		boolean onlyOnePath;
		if (restrictContainer) {

			if (containerInstances.isEmpty()) {

				this.logger.warning(() -> "Instances of the targetSection '" + section.getName()
						+ "'specify a container section (either the target section itself or a MappingHintImporter)."
						+ " Unfortunately no instances of the specified container were created. Therefore the sections will not be linked to the target model.");
				this.addToTargetModelRoot(rootInstances);
				return;
			}

			for (final ModelConnectionPath p : new LinkedList<>(pathsToConsider)) {
				boolean found = false;
				for (final EClass c : containerClasses) {
					if (p.leadsToRootType(c)) {
						found = true;
						break;
					}
				}

				if (!found) {
					pathsToConsider.remove(p);// narrow down possible paths
				}
			}

			onlyOnePath = pathsToConsider.size() == 1 && containerInstances.size() == 1;
		} else {
			onlyOnePath = pathsToConsider.size() == 1 && this.targetSectionRegistry
					.getTargetClassInstances(pathsToConsider.iterator().next().getPathRootClass()).size() == 1;
		}

		if (onlyOnePath) {// only one path to choose from
			modelConnectionPath = pathsToConsider.iterator().next();
			// select instance of path end to associate elements to
			EObjectWrapper inst;

			if (restrictContainer) {
				inst = containerInstances.iterator().next();

			} else if (!rootInstances.contains(this.targetSectionRegistry
					.getTargetClassInstances(modelConnectionPath.getPathRootClass()).iterator().next())) {

				inst = this.targetSectionRegistry.getTargetClassInstances(modelConnectionPath.getPathRootClass())
						.iterator().next();

			} else {
				this.logger
						.warning(() -> "Could not find a path that leads to the container specified for targetSection '"
								+ section.getName() + "'");
				this.addToTargetModelRoot(rootInstances);
				return;
			}

			this.logger.fine("Path found: " + section.getName() + "(" + mappingName + "::" + mappingGroup.getName()
					+ "): " + modelConnectionPath.toString());

			/*
			 * Try to instantiate Paths and add failed elements to target model root
			 */
			this.addToTargetModelRoot(modelConnectionPath.instantiate(inst.getEObject(), rootInstances));

		} else if (!pathsToConsider.isEmpty()) {// user decides

			final LinkedHashMap<String, ModelConnectionPath> pathNames = new LinkedHashMap<>();
			final LinkedHashMap<String, LinkedHashMap<String, EObjectWrapper>> instancesByPath = new LinkedHashMap<>();

			ModelConnectionPath standardPath = pathsToConsider.iterator().next();

			// get shortest path
			//
			for (final ModelConnectionPath p : pathsToConsider) {

				// prepare user selections
				final LinkedHashMap<String, EObjectWrapper> instances = new LinkedHashMap<>();
				for (final EObjectWrapper inst : this.targetSectionRegistry
						.getTargetClassInstances(p.getPathRootClass())) {

					if (!rootInstances.contains(inst) && (!restrictContainer || containerInstances.contains(inst))) {

						instances.put(inst.toString(), inst);
					}

				}

				if (instances.size() > 0) {

					instancesByPath.put(p.toString(), instances);
					pathNames.put(p.toString(), p);

					if (p.size() < standardPath.size()) {

						standardPath = p;// save standard path
					}
				}

			}

			if (instancesByPath.isEmpty()) {

				this.logger
						.warning(() -> "Could not find a path that leads to the container specified for targetSection '"
								+ section.getName() + "'");
				this.addToTargetModelRoot(rootInstances);
				return;
			}

			if (this.canceled) {
				return;
			}

			/*
			 * Consult the specified resolving strategy to resolve the ambiguity.
			 */
			HashMap<ModelConnectionPath, List<EObjectWrapper>> choices = new HashMap<>();
			EObjectWrapper inst; // the instance that will be the container

			for (Entry<String, ModelConnectionPath> entry : pathNames.entrySet()) {
				choices.put(entry.getValue(), new ArrayList<>(instancesByPath.get(entry.getKey()).values()));
			}

			try {
				this.logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_STARTED);

				Map<ModelConnectionPath, List<EObjectWrapper>> resolved;
				if (choices.keySet().size() == 1) {
					modelConnectionPath = choices.keySet().iterator().next();
					resolved = new HashMap<>();
					resolved.put(modelConnectionPath, this.ambiguityResolvingStrategy.joiningSelectContainerInstance(
							choices.get(modelConnectionPath), rootInstances, mappingGroup, null, null));
				} else if (choices.values().stream().flatMap(v -> v.stream()).collect(Collectors.toSet()).size() == 1) {
					// If there is only one possible container instance, we only
					// need to let the user choose the
					// connection path...
					//
					List<ModelConnectionPath> resolvedPaths = this.ambiguityResolvingStrategy
							.joiningSelectConnectionPath(new ArrayList<>(choices.keySet()), section);
					resolved = resolvedPaths.stream().collect(Collectors.toMap(Function.identity(), choices::get));
					modelConnectionPath = resolvedPaths.get(0);
				} else {
					// ... otherwise, the user also needs to select the
					// container instance.
					//
					resolved = this.ambiguityResolvingStrategy.joiningSelectConnectionPathAndContainerInstance(choices,
							section, rootInstances, mappingGroup);
					modelConnectionPath = resolved.entrySet().iterator().next().getKey();
				}

				inst = instancesByPath.get(modelConnectionPath.toString())
						.get(resolved.entrySet().iterator().next().getValue().get(0).toString());
				if (this.ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
					((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy)
							.joiningConnectionPathSelected(new ArrayList<>(choices.keySet()), modelConnectionPath);
					((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy)
							.joiningContainerInstanceSelected(new ArrayList<>(choices.get(modelConnectionPath)), inst);
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
					modelConnectionPath = choices.keySet().iterator().next();
					inst = instancesByPath.get(modelConnectionPath.toString())
							.get(choices.entrySet().iterator().next().getValue().get(0).toString());
				}
			}

			this.logger.info(section.getName() + "(" + mappingName + "): " + modelConnectionPath.toString());

			/*
			 * Try to instantiate Paths and add failed elements to target model root
			 */
			this.addToTargetModelRoot(modelConnectionPath.instantiate(inst.getEObject(), rootInstances));

		} else {// no suitable container found
			this.logger.warning(
					() -> "Could not find a path that leads to the container specified for the target section '"
							+ section.getName() + "'");
			this.addToTargetModelRoot(rootInstances);
		}

	}

	/**
	 * Try to link the given list of 'rootInstances' (and therefore entire sections of the target model) to other
	 * objects of the target model.
	 * <p>
	 * This method is used for connecting sections using a given {@link ContainerSelector}.
	 *
	 * @param rootInstances
	 *            A list of {@link EObjectWrapper elements} to connect.
	 * @param section
	 *            The {@link TargetSection} that shall be connected.
	 * @param mappingName
	 *            The name of the {@link Mapping} that is used.
	 * @param mappingGroup
	 *            The {@link MappingHintGroupType} that is used.
	 * @param connectionHint
	 *            The {@link ContainerSelector} to be used to connect the section.
	 * @param modelConnectionHintValues
	 *            A list of values that are to be used by the given {@link ContainerSelector}.
	 * @return A list of {@link EObjectWrapper instances} that could not be connected (a sub-list of the given
	 *         <em>rootInstances</em> or an empty list).
	 */
	public List<EObjectWrapper> linkToTargetModelUsingModelConnectionHint(final List<EObjectWrapper> rootInstances,
			final TargetSection section, final String mappingName, final MappingHintGroupType mappingGroup,
			final ContainerSelector connectionHint,
			final LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>> modelConnectionHintValues) {// connectionHint.targetAttribute.~owningClass

		this.checkCanceled();

		ArrayList<EObjectWrapper> unconnectedInstances = new ArrayList<>();

		// nothing to connect
		if (rootInstances == null || rootInstances.isEmpty()) {
			return unconnectedInstances;
		}

		// check for connections

		if (this.targetSectionRegistry
				.getConnections(section.getEClass(), connectionHint.getTargetClass().getEClass(), this.maxPathLength)
				.isEmpty()) {

			this.logger
					.warning(() -> "Could not find a path that leads to the modelConnectionTarget Class specified for '"
							+ mappingName + "' (" + mappingGroup.getName() + ")");

			unconnectedInstances.addAll(rootInstances);
			return unconnectedInstances;
		}

		List<EObjectWrapper> possibleContainerInstances = this.targetSectionRegistry
				.getFlattenedPamtramClassInstances(connectionHint.getTargetClass());

		// find container Instance for each element

		final LinkedHashMap<String, LinkedHashSet<EObjectWrapper>> contInstsByHintVal = new LinkedHashMap<>();

		final LinkedHashMap<String, LinkedHashSet<EObjectWrapper>> rootInstancesByHintVal = new LinkedHashMap<>();

		LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>> connectionHintValuesCopy;

		// again, we need to handle the special case, when there is only one
		// hintValue
		if (modelConnectionHintValues.size() == 1) {
			connectionHintValuesCopy = new LinkedList<>();
			for (int i = 0; i < rootInstances.size(); i++) {
				connectionHintValuesCopy.add(modelConnectionHintValues.getFirst());
			}
		} else {
			connectionHintValuesCopy = modelConnectionHintValues;
		}

		if (connectionHint.getReferenceAttribute() == null
				|| connectionHint.getReferenceAttribute().getOwningClass() != connectionHint.getTargetClass()) {
			throw new RuntimeException(
					"ContainerSelects without a specified 'referenceAttribute' that is directly contained in the specified 'targetClass' are not yet supported! (ContainerSelector: '"
							+ connectionHint.getName() + "' in MappingHintGroup '" + mappingGroup.getName() + "')");
		}

		for (final Map<InstanceSelectorSourceInterface, AttributeValueRepresentation> hintVal : connectionHintValuesCopy) {

			StringBuilder hintValBuilder = new StringBuilder();

			connectionHint.getSourceElements().stream().forEach(srcElement -> {

				if (hintVal.containsKey(srcElement)) {

					hintValBuilder.append(hintVal.get(srcElement).getValue());

				} else {
					this.logger.warning(() -> "HintSourceValue not found " + srcElement.getName()
							+ " in ComplexModelConnectionHint " + connectionHint.getName() + "(Mapping: " + mappingName
							+ ", Group: " + mappingGroup.getName() + ").");
				}
			});

			String hintValAsString = hintValBuilder.toString();

			if (!contInstsByHintVal.containsKey(hintValAsString)) {

				contInstsByHintVal.put(hintValAsString, new LinkedHashSet<EObjectWrapper>());
			}

			if (!rootInstancesByHintVal.containsKey(hintValAsString)) {

				rootInstancesByHintVal.put(hintValAsString, new LinkedHashSet<EObjectWrapper>());
			}

			// instances have same order as hintValues
			rootInstancesByHintVal.get(hintValAsString).add(rootInstances.remove(0));

			TargetSectionAttribute referenceAttribute = connectionHint.getReferenceAttribute();

			final String modifiedHintVal = this.attributeValuemodifier.applyAttributeValueModifiers(hintValAsString,
					connectionHint.getModifiers());

			/*
			 * now find a fitting instance get Attribute value
			 */
			for (final EObjectWrapper contInst : possibleContainerInstances) {

				// TODO check limited capacity
				// TODO check type of referenced object

				final String targetValStr = contInst.getAttributeValue(referenceAttribute);

				if (targetValStr != null) {
					if (modifiedHintVal.equals(targetValStr)) {

						contInstsByHintVal.get(hintValAsString).add(contInst);
					}
				} else {
					this.logger.warning("Problemo?");
				}

			}

		}

		// now select targetInst
		final LinkedHashMap<EObjectWrapper, LinkedHashSet<EObjectWrapper>> rootInstancesByContainer = new LinkedHashMap<>();

		for (final Entry<String, LinkedHashSet<EObjectWrapper>> hintValEntry : rootInstancesByHintVal.entrySet()) {

			if (contInstsByHintVal.get(hintValEntry.getKey()).size() == 1) {

				rootInstancesByContainer.put(contInstsByHintVal.get(hintValEntry.getKey()).iterator().next(),
						hintValEntry.getValue());

			} else if (contInstsByHintVal.get(hintValEntry.getKey()).size() > 1) {

				/*
				 * Consult the specified resolving strategy to resolve the ambiguity.
				 */
				try {
					this.logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_STARTED);
					List<EObjectWrapper> resolved = this.ambiguityResolvingStrategy.joiningSelectContainerInstance(
							new LinkedList<>(contInstsByHintVal.get(hintValEntry.getKey())),
							new LinkedList<>(hintValEntry.getValue()), mappingGroup, connectionHint,
							hintValEntry.getKey());
					if (this.ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
						((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy).joiningContainerInstanceSelected(
								new ArrayList<>(contInstsByHintVal.get(hintValEntry.getKey())), resolved.get(0));
					}
					this.logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_ENDED);
					rootInstancesByContainer.put(resolved.get(0), hintValEntry.getValue());

				} catch (AmbiguityResolvingException e) {
					if (e.getCause() instanceof UserAbortException) {
						throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
					} else {
						this.logger.severe(
								() -> "The following exception occured during the resolving of an ambiguity concerning the selection of a common root element: "
										+ e.getMessage());
						this.logger.severe("Using default element instead...");
						rootInstancesByContainer.put(contInstsByHintVal.get(hintValEntry.getKey()).iterator().next(),
								hintValEntry.getValue());
					}
				}

			} else {
				this.logger.warning(() -> "The ModelConnectionHint '" + connectionHint.getName()
						+ " of MappingHintGroup " + mappingGroup.getName() + "(Mapping: " + mappingName
						+ ") could not find an instance to connect the targetSections.\n"
						+ contInstsByHintVal.keySet());
				unconnectedInstances.addAll(hintValEntry.getValue());
				return unconnectedInstances;
			}
		}

		// only go on if any of the instances could be matched
		if (rootInstancesByContainer.keySet().isEmpty()) {
			return unconnectedInstances;
		}

		for (

		final Entry<EObjectWrapper, LinkedHashSet<EObjectWrapper>> containerEntry : rootInstancesByContainer
				.entrySet()) {

			/*
			 * Check if there already is a standard path for the given connection hint and the given target eClass that
			 * satisfies the minimum capacity.
			 */
			boolean otherPathsNeeded = false;

			if (!this.standardPaths.containsKey(connectionHint) || !this.standardPaths.get(connectionHint)
					.getPathRootClass().equals(containerEntry.getKey().getEObject().eClass())) {

				otherPathsNeeded = true;
			} else {

				final int capacity = this.standardPaths.get(connectionHint)
						.getCapacity(containerEntry.getKey().getEObject());

				if (!(capacity >= containerEntry.getValue().size() || capacity == -1)) {

					this.standardPaths.remove(connectionHint);
					otherPathsNeeded = true;
				}
			}

			/*
			 * A set of ModelConnectionPaths that are possible and thus have to be considered by the selection
			 * algorithms.
			 */
			List<ModelConnectionPath> pathsToConsider = new LinkedList<>();
			if (otherPathsNeeded) {
				/*
				 * Find all possible paths to concider that satisfy the minimum capacity.
				 */
				pathsToConsider = ModelConnectionPath.findPathsWithMinimumCapacity(
						this.targetSectionRegistry.getConnections(section.getEClass(),
								containerEntry.getKey().getEObject().eClass(), this.maxPathLength),
						containerEntry.getKey().getEObject(), containerEntry.getValue().size());

			} else {
				/*
				 *
				 */
				pathsToConsider.add(this.standardPaths.get(connectionHint));
			}

			ModelConnectionPath modelConnectionPath = null;

			// only one path to choose from
			if (pathsToConsider.size() == 1) {

				modelConnectionPath = pathsToConsider.iterator().next();

				// multiple paths to choos from
			} else if (!pathsToConsider.isEmpty()) {

				if (this.canceled) {
					return unconnectedInstances;
				}

				/*
				 * Consult the specified resolving strategy to resolve the ambiguity.
				 */
				try {
					this.logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_STARTED);
					List<ModelConnectionPath> resolved = this.ambiguityResolvingStrategy
							.joiningSelectConnectionPath(pathsToConsider, section);
					if (this.ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
						((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy)
								.joiningConnectionPathSelected(new ArrayList<>(pathsToConsider), resolved.get(0));
					}
					this.logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_ENDED);
					modelConnectionPath = resolved.get(0);
				} catch (AmbiguityResolvingException e) {
					if (e.getCause() instanceof UserAbortException) {
						throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
					} else {
						this.logger.severe(
								() -> "The following exception occured during the resolving of an ambiguity concerning an connection path: "
										+ e.getMessage());
						this.logger.severe("Using default path instead...");
						modelConnectionPath = pathsToConsider.get(0);
					}
				}

			} else {

				this.logger.warning(
						() -> "Could not find a path that leads to the container specified by the ModelConnectionHint of "
								+ mappingName + "::" + mappingGroup.getName());
				unconnectedInstances.addAll(rootInstances);
				this.addToTargetModelRoot(containerEntry.getValue());
				return unconnectedInstances;
			}
			if (modelConnectionPath == null) {
				continue;
			}

			if (!this.standardPaths.containsKey(connectionHint) || !this.standardPaths.get(connectionHint)
					.getPathRootClass().equals(containerEntry.getKey().getEObject().eClass())) {

				this.standardPaths.put(connectionHint, modelConnectionPath);
				this.logger.fine("Path found: " + section.getName() + "(" + mappingName + "::" + mappingGroup.getName()
						+ "): " + modelConnectionPath.toString());
			}

			// now instantiate path(s))
			//

			// we will allow objects that reference themselves as container
			// because this was explicitly
			// specified by the ModelConnectionHint
			if (containerEntry.getValue().contains(containerEntry.getKey())) {// we
				// will
				// allow
				// objects
				// that
				// reference

				this.addToTargetModelRoot(containerEntry.getKey());
			}

			/*
			 * Try to instantiate Paths and add failed elements to target model root
			 */
			unconnectedInstances.addAll(
					modelConnectionPath.instantiate(containerEntry.getKey().getEObject(), containerEntry.getValue()));
		}

		return unconnectedInstances;
	}

}
