package de.mfreund.gentrans.transformation.instantiating;

import java.util.ArrayList;
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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.calculation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.ModelConnectionPath;
import de.mfreund.gentrans.transformation.registries.TargetModelRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.util.CancellableElement;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.ModelConnectionHintSourceInterface;
import pamtram.mapping.ModelConnectionHintTargetAttribute;
import pamtram.metamodel.FileTypeEnum;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionClass;

/**
 * This class is responsible for joining the unconnected target sections to form one coherent target model.
 *
 * @author mfreund
 */
public class TargetSectionConnector extends CancellableElement {

	private static final String RESOLVE_JOINING_AMBIGUITY_ENDED = "[Ambiguity] ...finished.\n";

	private static final String RESOLVE_JOINING_AMBIGUITY_STARTED = "[Ambiguity] Resolve joining ambiguity...";

	/**
	 * This list stores those {@link ModelConnectionPath ModelConnectionPaths} that have beepreviously selected 
	 * by the user for a given {@link ModelConnectionHint}.
	 */
	private final LinkedHashMap<ModelConnectionHint, ModelConnectionPath> standardPaths;

	/**
	 * The {@link TargetSectionRegistry} that is used when finding instances to which sections
	 * can be connected.
	 */
	private final TargetSectionRegistry targetSectionRegistry;

	/**
	 * The {@link TargetModelRegistry} that is used to manage the various target models and their contents.
	 */
	private final TargetModelRegistry targetModelRegistry;

	/**
	 * The {@link MessageConsoleStream} that is used to print messages to inform the user.
	 */
	private final MessageConsoleStream consoleStream;

	/**
	 * The {@link AttributeValueModifierExecutor} that is used to modify attribute values. This is necessary to
	 * calculate the values of {@link ModelConnectionHintTargetAttribute ModelConnectionHintTargetAttributes} that 
	 * are evaluated here.
	 */
	private final AttributeValueModifierExecutor attributeValuemodifier;

	/**
	 * The maximum length for connection paths that shall be considered by this TargetSectionConnector. If 'maxPathLength'
	 * is set to '-1' or any other value below '0', connection paths of unbounded length are considered.
	 */
	private final int maxPathLength;

	/**
	 * This keeps track of {@link TargetSectionClass TargetSectionClasses} and corresponding {@link EObjectWrapper 
	 * EObjects} for that no ModelConnectionPath could be determined. The key of the Map thereby denotes the {@link EClass} that
	 * the TargetSectionClasses are associated with.
	 */
	private final Map<EClass, Map<TargetSectionClass, List<EObjectWrapper>>> unlinkeableElements;

	/**
	 * This is the {@link IAmbiguityResolvingStrategy} that shall be used to 
	 * resolve ambiguities that arise during the execution of the transformation.
	 */
	private IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

	/**
	 * This creates an instance.
	 * 
	 * @param targetSectionRegistry
	 *            A {@link TargetSectionRegistry} that is necessary for finding instances to which
	 *            sections can be connected.
	 * @param attributeValuemodifier An {@link AttributeValueModifierExecutor} that is used to modify attribute values. This is necessary to
	 * calculate the values of {@link ModelConnectionHintTargetAttribute ModelConnectionHintTargetAttributes} that 
	 * are evaluated here.
	 * @param targetModelRegistry The {@link TargetModelRegistry} that is used to manage the various target models and their contents.
	 * @param maxPathLength The maximum length for connection paths that shall be considered by this TargetSectionConnector. If 'maxPathLength'
	 * is set to '-1' or any other value below '0', connection paths of unbounded length are considered.
	 * @param ambiguityResolvingStrategy The {@link IAmbiguityResolvingStrategy} that shall be used to 
	 * resolve ambiguities that arise during the execution of the transformation.
	 * @param consoleStream The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	public TargetSectionConnector(
			final TargetSectionRegistry targetSectionRegistry,
			final AttributeValueModifierExecutor attributeValuemodifier,
			final TargetModelRegistry targetModelRegistry, final int maxPathLength,
			final IAmbiguityResolvingStrategy ambiguityResolvingStrategy, 
			final MessageConsoleStream consoleStream) {
		
		this.standardPaths = new LinkedHashMap<>();
		this.targetSectionRegistry = targetSectionRegistry;
		this.targetModelRegistry = targetModelRegistry;
		this.consoleStream = consoleStream;
		this.canceled = false;
		this.attributeValuemodifier = attributeValuemodifier;
		this.maxPathLength = maxPathLength;
		this.ambiguityResolvingStrategy = ambiguityResolvingStrategy;
		this.unlinkeableElements = new LinkedHashMap<>();
	}

	/**
	 * This adds the given list of {@link EObjectWrapper elements} as root objects to the
	 * target model.
	 *
	 * @param elementsToAdd The list of {@link EObjectWrapper elements} to add.
	 */
	public void addToTargetModelRoot(
			final Collection<EObjectWrapper> elementsToAdd) {
		
		elementsToAdd.stream().forEach(this::addToTargetModelRoot);
	}

	/**
	 * This adds the given {@link EObjectWrapper element} as root object to the
	 * target model.
	 *
	 * @param helper The {@link EObjectWrapper element} to add.
	 */
	private void addToTargetModelRoot(final EObjectWrapper helper) {
		
		// the element to add
		EObject element = helper.getEObject();
		
		// the path of the target model
		String path = helper.getFile();
		
		// the file type of the target model
		FileTypeEnum fileType = helper.getFileType();
		
		if(path.isEmpty()) {
			targetModelRegistry.addToTargetModel(element);			
		} else {
			targetModelRegistry.addToTargetModel(element, path, fileType);
		}
	}

	/**
	 * This takes the list of {@link #unlinkeableElements} and adds them to the target model.
	 * <p />
	 * In the easiest case, the list of {@link #unlinkeableElements} contains only a single element which will 
	 * then be used as root element. If multiple elements exist, this tries to determine a common root element
	 * and joins the elements with it. If no common root element can be determined, multiple root elements
	 * are added to the target model.
	 */
	public void combineUnlinkedSectionsWithTargetModelRoot() {
		
		// nothing to do
		//
		if (unlinkeableElements.isEmpty()) {
			return;
		}
		
		/*
		 * only one element could not be connected = > we already have our
		 * container
		 */
		if (unlinkeableElements.keySet().size() == 1 && 
				unlinkeableElements.values().iterator().next().keySet().size() == 1 && 
					unlinkeableElements.values().iterator().next().values().iterator().next().size() == 1) {
				
			addToTargetModelRoot(unlinkeableElements.values()
					.iterator().next().values().iterator().next().get(0));
			consoleStream.println("Root element: The single instance of the target section '"
					+ unlinkeableElements.values().iterator().next().keySet().iterator().next().getName() + "'.");
			return;
		
		}

		/*
		 * Now that the "special" case was handled we need to handle all the
		 * other cases.
		 */
		final Set<EClass> common = new HashSet<>();
		for (final EClass possibleRoot : targetSectionRegistry.getMetaModelClasses()) {
			
			boolean failed = false;
			if (!possibleRoot.isAbstract()) {
				for (final EClass c : unlinkeableElements.keySet()) {
					if (canceled) {
						return;
					}
					if (targetSectionRegistry.getConnections(c, possibleRoot, maxPathLength).isEmpty()) {
						failed = true;
						break;
					}
				}
				if (!failed) {
					common.add(possibleRoot);
				}
			}
		}

		if (canceled) {
			return;
		}

		if (common.isEmpty()) {
			
			for (final EClass c : unlinkeableElements.keySet()) {
				
				consoleStream.println("No suitable path found for target class: " + c.getName());
				
				unlinkeableElements.get(c).values().stream().forEach(this::addToTargetModelRoot);
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
					consoleStream.println(RESOLVE_JOINING_AMBIGUITY_STARTED);
					List<EClass> resolved = ambiguityResolvingStrategy.joiningSelectRootElement(new ArrayList<>(common));
					consoleStream.println(RESOLVE_JOINING_AMBIGUITY_ENDED);
					rootClass = resolved.get(0);
					
				} catch (Exception e) {
					consoleStream.println(e.getMessage());
					cancel();
					return;
				}

			}

			final EObject containerInstance = rootClass.getEPackage().getEFactoryInstance().create(rootClass);
			
			addToTargetModelRoot(new EObjectWrapper(containerInstance,targetSectionRegistry.getAttrValRegistry()));
			
			consoleStream.println("Root element: '" + rootClass.getName()+ "' (generated)");

			for (final Entry<EClass, Map<TargetSectionClass, List<EObjectWrapper>>> unlinkeableEntry : unlinkeableElements.entrySet()) {
				
				for (final TargetSectionClass tSection : unlinkeableEntry.getValue().keySet()) {
					/*
					 * It gets a bit tricky here. If there is more than one
					 * common container, we have to choose one. Then we need to
					 * find all possible connections for each of the elements
					 * involved. Now we need to choose a connection for each
					 * element. This might lead to us asking a lot of questions
					 * to the user.
					 */
					final List<ModelConnectionPath> pathSet = targetSectionRegistry.getConnections(unlinkeableEntry.getKey(), rootClass, maxPathLength);
					
					if (pathSet.isEmpty()) {
						
						addToTargetModelRoot(unlinkeableEntry.getValue().get(tSection));// This should not have happened =>
						// programming error
						consoleStream.println("Error. Check container instantiation");
						
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
									consoleStream.println(RESOLVE_JOINING_AMBIGUITY_STARTED);
									List<ModelConnectionPath> resolved = ambiguityResolvingStrategy.joiningSelectConnectionPath(fittingPaths, (TargetSection) tSection);
									consoleStream.println(RESOLVE_JOINING_AMBIGUITY_ENDED);
									chosenPath = resolved.get(0);
									
								} catch (Exception e) {
									consoleStream.println(e.getMessage());
									cancel();
									return;
								}
							}

							// now instantiate path
							chosenPath.instantiate(containerInstance, unlinkeableEntry.getValue().get(tSection));
							consoleStream.println("Connected to root: " + tSection.getName() + ": " + chosenPath.toString());
						} else {
							consoleStream.println("The chosen container '" + rootClass.getName() + "' cannot fit the elements of the type '"
									+ unlinkeableEntry.getKey().getName() + "', sorry.");
							addToTargetModelRoot(unlinkeableEntry.getValue().get(tSection));
						}

					}
				}
			}

		}
	}

	/**
	 * Try to link the given list of 'rootInstances' (and therefore entire sections of the
	 * target model) to other objects of the target model.
	 * <p>
	 * This method is used for connecting sections without model connection
	 * hints.
	 *
	 * @param rootInstances A list of {@link EObjectWrapper elements} to connect.
	 * @param section The {@link TargetSection} that shall be connected.
	 * @param mappingName The name of the {@link Mapping} that is used.
	 * @param mappingGroup The {@link MappingHintGroupType} that is used.
	 * @param containerClasses A list of {@link EClass EClasses} that are considered as target when searching for connection paths for the given list
	 * of 'rootInstances'.<br /><em>Note:</em> If this is '<em>null</em>' or if the list is empty, any EClass will be considered a valid target.
	 * @param containerInstances A list of container elements that may be used as container (this needs to be all instances if '<em>hasContainer</em>' is <em>false</em>.
	 */
	public void linkToTargetModelNoConnectionHint(
			final List<EObjectWrapper> rootInstances,
			final TargetSection section, final String mappingName,
			final MappingHintGroupType mappingGroup, 
			final Set<EClass> containerClasses,
			final List<EObjectWrapper> containerInstances) {

		// nothing to connect
		if (rootInstances == null || rootInstances.isEmpty()) {
			return;
		}

		/*
		 * A list of possible 'containerClasses' has been passed as parameter so we need to restrict the list of
		 * EClass that are considered when searching for connection paths.
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
				pathsToConsider.addAll(targetSectionRegistry.getConnections(classToConnect, c, maxPathLength));
			}
		} else {
			pathsToConsider.addAll(
					targetSectionRegistry.getPaths(classToConnect, maxPathLength));
		}

		/*
		 * If no paths have been found, register the related elements as 'unlinkable' and return.
		 */
		if(pathsToConsider.isEmpty()) {
			
			if (!unlinkeableElements.containsKey(classToConnect)) {
				
				unlinkeableElements.put(classToConnect,new LinkedHashMap<TargetSectionClass, List<EObjectWrapper>>());
			}
			
			if (!unlinkeableElements.get(classToConnect).containsKey(section)) {
				
				unlinkeableElements.get(classToConnect).put(section,new LinkedList<EObjectWrapper>());
			}
			
			unlinkeableElements.get(classToConnect).get(section).addAll(rootInstances);
			return;
		}

		/*
		 * Reduce the found paths to those that provide the necessary capacity.
		 */
		pathsToConsider = ModelConnectionPath.findPathsWithMinimumCapacity(
				pathsToConsider, null, rootInstances.size());

		/*
		 * Only go on with paths that could theoretically fit all of the
		 * elements
		 */
		if(pathsToConsider.isEmpty()) {
			// TODO handle limited capacity
			addToTargetModelRoot(rootInstances);
			return;
		}


		// handle container
		boolean onlyOnePath;
		if (restrictContainer) {

			if (containerInstances.isEmpty()) {
				
				consoleStream.println("Instances of the targetSection '" + section.getName()
					+ "'specify a container section (either the target section itself or a MappingHintImporter)."
					+ " Unfortunately no instances of the specified container were created. Therefore the sections will not be linked to the target model.");
				addToTargetModelRoot(rootInstances);
				return;
			}

			for (final ModelConnectionPath p : new LinkedList<>(
					pathsToConsider)) {
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
			onlyOnePath = pathsToConsider.size() == 1
					&& targetSectionRegistry.getTargetClassInstances(pathsToConsider.iterator().next().getPathRootClass()).size() == 1;
		}

		if (onlyOnePath) {// only one path to choose from
			modelConnectionPath = pathsToConsider.iterator().next();
			// select instance of path end to associate elements to
			EObjectWrapper inst;
			
			if (restrictContainer) {
				inst = containerInstances.iterator().next();
				
			} else if (!rootInstances.contains(
					targetSectionRegistry.getTargetClassInstances(modelConnectionPath.getPathRootClass()).iterator().next())) {
				
				inst = targetSectionRegistry.getTargetClassInstances(
						modelConnectionPath.getPathRootClass()).iterator().next();
				
			} else {
				consoleStream.println("Could not find a path that leads to the container specified for targetSection '"
						+ section.getName() + "'");
				addToTargetModelRoot(rootInstances);
				return;
			}

			consoleStream.println("Path found: " + section.getName() + "(" + mappingName + "::" + mappingGroup.getName() + "): " + 
					modelConnectionPath.toString());

			/*
			 * Try to instantiate Paths and add failed elements to
			 * target model root
			 */
			addToTargetModelRoot(modelConnectionPath.instantiate(inst.getEObject(), rootInstances));

		} else if (!pathsToConsider.isEmpty()) {// user decides
			
			final LinkedHashMap<String, ModelConnectionPath> pathNames = new LinkedHashMap<>();
			final LinkedHashMap<String, LinkedHashMap<String, EObjectWrapper>> instancesByPath = new LinkedHashMap<>();
			
			ModelConnectionPath standardPath = pathsToConsider.iterator().next();
			
			// get shortest path
			//
			for (final ModelConnectionPath p : pathsToConsider) {
				
				// prepare user selections
				final LinkedHashMap<String, EObjectWrapper> instances = new LinkedHashMap<>();
				for (final EObjectWrapper inst : targetSectionRegistry.getTargetClassInstances(p.getPathRootClass())) {
					
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
				
				consoleStream.println("Could not find a path that leads to the container specified for targetSection '"
						+ section.getName() + "'");
				addToTargetModelRoot(rootInstances);
				return;
			}

			if (canceled) {
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
				consoleStream.println(RESOLVE_JOINING_AMBIGUITY_STARTED);
				HashMap<ModelConnectionPath, List<EObjectWrapper>> resolved = ambiguityResolvingStrategy.joiningSelectConnectionPathAndContainerInstance(choices, section, rootInstances, mappingGroup);
				consoleStream.println(RESOLVE_JOINING_AMBIGUITY_ENDED);
				modelConnectionPath = resolved.entrySet().iterator().next().getKey();
				inst = instancesByPath.get(modelConnectionPath.toString()).get(resolved.entrySet().iterator().next().getValue().get(0).toString());
				
			} catch (Exception e) {
				
				consoleStream.println(e.getMessage());
				cancel();
				return;
			}

			consoleStream.println(section.getName() + "(" + mappingName + "): " + modelConnectionPath.toString());

			/*
			 * Try to instantiate Paths and add failed elements to
			 * target model root
			 */
			addToTargetModelRoot(modelConnectionPath.instantiate(inst.getEObject(), rootInstances));

		} else {// no suitable container found
			consoleStream.println("Could not find a path that leads to the container specified for the target section '"
					+ section.getName() + "'");
			addToTargetModelRoot(rootInstances);
		}


	}

	/**
	 * Try to link the given list of 'rootInstances' (and therefore entire sections of the
	 * target model) to other objects of the target model.
	 * <p>
	 * This method is used for connecting sections using a given {@link ModelConnectionHint}.
	 *
	 * @param rootInstances A list of {@link EObjectWrapper elements} to connect.
	 * @param section The {@link TargetSection} that shall be connected.
	 * @param mappingName The name of the {@link Mapping} that is used.
	 * @param mappingGroup The {@link MappingHintGroupType} that is used.
	 * @param connectionHint The {@link ModelConnectionHint} to be used to connect the section.
	 * @param modelConnectionHintValues A list of values that are to be used by the given {@link ModelConnectionHint}.
	 */
	public void linkToTargetModelUsingModelConnectionHint(
			final List<EObjectWrapper> rootInstances,
			final TargetSection section, final String mappingName,
			final MappingHintGroupType mappingGroup,
			final ModelConnectionHint connectionHint,
			final LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>> modelConnectionHintValues) {// connectionHint.targetAttribute.~owningClass

		// nothing to connect
		if (rootInstances == null || rootInstances.isEmpty()) {
			return;
		}

		// check for connections
		int size = 0;
		for (final ModelConnectionHintTargetAttribute attr : connectionHint.getTargetAttributes()) {
			
			size += targetSectionRegistry.getConnections(section.getEClass(),
					attr.getSource().getOwningClass().getEClass(),
					maxPathLength).size();
		}

		if(size == 0) {
			
			consoleStream.println("Could not find a path that leads to the modelConnectionTarget Class specified for '"
					+ mappingName + "' (" + mappingGroup.getName() + ")");

			addToTargetModelRoot(rootInstances);
			return;
		}


		// now search for target attributes

		final Map<ModelConnectionHintTargetAttribute, List<EObjectWrapper>> containerInstancesByTargetAttribute = 
				new LinkedHashMap<>();

		for (final ModelConnectionHintTargetAttribute targetAttr : connectionHint.getTargetAttributes()) {
			
			containerInstancesByTargetAttribute.put(targetAttr, 
					targetSectionRegistry.getFlattenedPamtramClassInstances(targetAttr.getSource().getOwningClass()));// owningClass

		}

		// find container Instance for each element

		final LinkedHashMap<String, LinkedHashSet<EObjectWrapper>> contInstsByHintVal = 
				new LinkedHashMap<>();
		final LinkedHashMap<String, LinkedHashSet<EObjectWrapper>> rootInstancesByHintVal = 
				new LinkedHashMap<>();
		LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>> connectionHintValuesCopy;

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

		for (final Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> hintVal : connectionHintValuesCopy) {

			StringBuilder hintValBuilder = new StringBuilder();
			
			 connectionHint.getSourceElements().stream().forEach(srcElement -> {
				 
				 if (hintVal.containsKey(srcElement)) {
					 
					 hintValBuilder.append(hintVal.get(srcElement).getValue());
					 
				 } else {
					 consoleStream.println("HintSourceValue not found " + srcElement.getName() + " in ComplexModelConnectionHint "
							 + connectionHint.getName() + "(Mapping: " + mappingName + ", Group: " + mappingGroup.getName() + ").");
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

			for (final Entry<ModelConnectionHintTargetAttribute, List<EObjectWrapper>> entry : containerInstancesByTargetAttribute.entrySet()) {

				final String modifiedHintVal = attributeValuemodifier.
						applyAttributeValueModifiers(hintValAsString, entry.getKey().getModifier());

				/*
				 * now find a fitting instance get Attribute value
				 */
				for (final EObjectWrapper contInst : entry.getValue()) {
					
					// TODO check limited capacity
					// TODO check type of referenced object

					final String targetValStr = contInst.getAttributeValue(entry.getKey().getSource());

					if (targetValStr != null) {
						if (modifiedHintVal.equals(targetValStr)) {
							
							contInstsByHintVal.get(hintValAsString).add(contInst);
						}
					} else {
						consoleStream.println("Problemo?");
					}

				}
			}

		}

		// now select targetInst
		final LinkedHashMap<EObjectWrapper, LinkedHashSet<EObjectWrapper>> rootInstancesByContainer = new LinkedHashMap<>();
		for (final Entry<String, LinkedHashSet<EObjectWrapper>> hintValEntry : rootInstancesByHintVal.entrySet()) {

			if (isCancelled()) {
				return;
			}

			if (contInstsByHintVal.get(hintValEntry.getKey()).size() == 1) {

				rootInstancesByContainer.put(contInstsByHintVal.get(hintValEntry.getKey()).iterator().next(),
						hintValEntry.getValue());

			} else if (contInstsByHintVal.get(hintValEntry.getKey()).size() > 1) {

				/*
				 * Consult the specified resolving strategy to resolve the ambiguity.				
				 */
				try {
					consoleStream.println(RESOLVE_JOINING_AMBIGUITY_STARTED);
					List<EObjectWrapper> resolved = ambiguityResolvingStrategy.joiningSelectContainerInstance(
							new LinkedList<>(contInstsByHintVal.get(hintValEntry.getKey())), 
							new LinkedList<>(hintValEntry.getValue()), mappingGroup, connectionHint, hintValEntry.getKey());
					consoleStream.println(RESOLVE_JOINING_AMBIGUITY_ENDED);
					rootInstancesByContainer.put(resolved.get(0), hintValEntry.getValue());
					
				} catch (Exception e) {
					consoleStream.println(e.getMessage());
					cancel();
					return;
				}

			} else {
				consoleStream.println("The ModelConnectionHint '" + connectionHint.getName() + " of MappingHintGroup " + mappingGroup.getName()
				+ "(Mapping: " + mappingName + ") could not find an instance to connect the targetSections.\n" + contInstsByHintVal.keySet());
				addToTargetModelRoot(hintValEntry.getValue());
			}
		}

		// only go on if any of the instances could be matched
		if(rootInstancesByContainer.keySet().isEmpty())	 {
			return;
		}

		for (final Entry<EObjectWrapper, LinkedHashSet<EObjectWrapper>> containerEntry : rootInstancesByContainer.entrySet()) {

			/*
			 * Check if there already is a standard path for the given connection hint and the given target eClass that
			 * satisfies the minimum capacity.
			 */
			boolean otherPathsNeeded = false;
			
			if (!standardPaths.containsKey(connectionHint) || 
					!standardPaths.get(connectionHint).getPathRootClass().equals(containerEntry.getKey().getEObject().eClass())) {
				
				otherPathsNeeded = true;
			} else {
				
				final int capacity = standardPaths.get(connectionHint).getCapacity(containerEntry.getKey().getEObject());
				
				if (!(capacity >= containerEntry.getValue().size() || capacity == -1)) {
					
					standardPaths.remove(connectionHint);
					otherPathsNeeded = true;
				}
			}

			/*
			 * A set of ModelConnectionPaths that are possible and thus have to be considered by the selection algorithms.
			 */
			List<ModelConnectionPath> pathsToConsider = new LinkedList<>();
			if (otherPathsNeeded) {
				/*
				 * Find all possible paths to concider that satisfy the minimum capacity.
				 */
				pathsToConsider = ModelConnectionPath.findPathsWithMinimumCapacity(
						targetSectionRegistry.getConnections(section.getEClass(), 
								containerEntry.getKey().getEObject().eClass(),maxPathLength), 
						containerEntry.getKey().getEObject(),
						containerEntry.getValue().size()
						);

			} else {
				/*
				 * 
				 */
				pathsToConsider.add(standardPaths.get(connectionHint));
			}

			ModelConnectionPath modelConnectionPath = null;
			
			// only one path to choose from
			if (pathsToConsider.size() == 1) {
				
				modelConnectionPath = pathsToConsider.iterator().next();
				
			// multiple paths to choos from
			} else if (!pathsToConsider.isEmpty()) {

				if (canceled) {
					return;
				}

				/*
				 * Consult the specified resolving strategy to resolve the ambiguity.				
				 */
				try {
					consoleStream.println(RESOLVE_JOINING_AMBIGUITY_STARTED);
					List<ModelConnectionPath> resolved = ambiguityResolvingStrategy.joiningSelectConnectionPath(pathsToConsider, section);
					consoleStream.println(RESOLVE_JOINING_AMBIGUITY_ENDED);
					modelConnectionPath = resolved.get(0);
				} catch (Exception e) {
					consoleStream.println(e.getMessage());
					cancel();
					return;
				}

			} else {
				
				consoleStream.println("Could not find a path that leads to the container specified by the ModelConnectionHint of "
						+ mappingName + "::" + mappingGroup.getName());
				addToTargetModelRoot(rootInstances);
				addToTargetModelRoot(containerEntry.getValue());
			}
			if(modelConnectionPath == null) {
				continue;
			}

			if (!standardPaths.containsKey(connectionHint) || 
					!standardPaths.get(connectionHint).getPathRootClass().equals(containerEntry.getKey().getEObject().eClass())) {
				
				standardPaths.put(connectionHint, modelConnectionPath);
				consoleStream.println("Path found: " + section.getName() + "(" + mappingName + "::" + 
						mappingGroup.getName() + "): " + modelConnectionPath.toString());
			}

			// now instantiate path(s))
			//
			
			// we will allow objects that reference themselves as container because this was explicitly
			// specified by the ModelConnectionHint
			if (containerEntry.getValue().contains(containerEntry.getKey())) {// we will allow objects that reference
				
				addToTargetModelRoot(containerEntry.getKey()); 
			}
			
			/*
			 * Try to instantiate Paths and add failed elements to
			 * target model root
			 */
			addToTargetModelRoot(modelConnectionPath.instantiate(
					containerEntry.getKey().getEObject(),
					containerEntry.getValue()));

		}
	}

}
