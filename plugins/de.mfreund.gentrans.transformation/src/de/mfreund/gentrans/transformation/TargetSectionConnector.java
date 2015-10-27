package de.mfreund.gentrans.transformation;

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
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.util.CancellableElement;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.ModelConnectionHintSourceInterface;
import pamtram.mapping.ModelConnectionHintTargetAttribute;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionClass;

/**
 * This class is responsible for joining the unconnected target sections to form one coherent target model.
 *
 * @author mfreund
 */
public class TargetSectionConnector extends CancellableElement {

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
	 * The {@link XMIResource resource} that the coherent target model is added to.
	 */
	private final XMIResource targetModel;

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
	 * @param targetModel The {@link XMIResource resource} that the coherent target model shall be added to.
	 * @param maxPathLength The maximum length for connection paths that shall be considered by this TargetSectionConnector. If 'maxPathLength'
	 * is set to '-1' or any other value below '0', connection paths of unbounded length are considered.
	 * @param ambiguityResolvingStrategy The {@link IAmbiguityResolvingStrategy} that shall be used to 
	 * resolve ambiguities that arise during the execution of the transformation.
	 */
	TargetSectionConnector(
			final TargetSectionRegistry targetSectionRegistry,
			final AttributeValueModifierExecutor attributeValuemodifier,
			final XMIResource targetModel, final int maxPathLength,
			final IAmbiguityResolvingStrategy ambiguityResolvingStrategy, 
			final MessageConsoleStream consoleStream) {
		this.standardPaths = new LinkedHashMap<>();
		this.targetSectionRegistry = targetSectionRegistry;
		this.targetModel = targetModel;
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
	private void addToTargetModelRoot(
			final Collection<EObjectWrapper> elementsToAdd) {
		for (final EObjectWrapper h : elementsToAdd) {
			addToTargetModelRoot(h);
		}
	}

	/**
	 * This adds the given {@link EObjectWrapper element} as root object to the
	 * target model.
	 *
	 * @param helper The {@link EObjectWrapper element} to add.
	 */
	private void addToTargetModelRoot(final EObjectWrapper helper) {
		targetModel.getContents().add(helper.getEObject());
	}

	/**
	 * This takes the list of {@link #unlinkeableElements} and adds them to the target model.
	 * <p />
	 * In the easiest case, the list of {@link #unlinkeableElements} contains only a single element which will 
	 * then be used as root element. If multiple elements exist, this tries to determine a common root element
	 * and joins the elements with it. If no common root element can be determined, multiple root elements
	 * are added to the target model.
	 */
	void combineUnlinkedSectionsWithTargetModelRoot() {
		/*
		 * only one element could not be connected = > we already have our
		 * container
		 */
		if (unlinkeableElements.keySet().size() == 1) {
			if (unlinkeableElements.values().iterator().next().keySet().size() == 1) {
				if (unlinkeableElements.values().iterator().next().values()
						.iterator().next().size() == 1) {
					addToTargetModelRoot(unlinkeableElements.values()
							.iterator().next().values().iterator().next().get(0));
					consoleStream.println("Root element: The single instance of the target section '"
							+ unlinkeableElements.values().iterator().next().keySet().iterator().next().getName() + "'.");
					return;
				}
			}
		} else if (unlinkeableElements.keySet().size() < 1) {
			return;// nothing left to do
		}

		/*
		 * Now that the "special" case was handled we need to handle all the
		 * other cases.
		 */

		final Set<EClass> common = new HashSet<>();
		for (final EClass possibleRoot : targetSectionRegistry
				.getMetaModelClasses()) {
			boolean failed = false;
			if (!possibleRoot.isAbstract()) {
				for (final EClass c : unlinkeableElements.keySet()) {
					if (canceled) {
						return;
					}
					if (targetSectionRegistry.getConnections(c, possibleRoot,
							maxPathLength).size() < 1) {
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

		if (common.size() < 1) {
			for (final EClass c : unlinkeableElements.keySet()) {
				consoleStream
				.println("No suitable path found for target class: "
						+ c.getName());
				for (final List<EObjectWrapper> instances : unlinkeableElements
						.get(c).values()) {
					addToTargetModelRoot(instances);
				}
			}
		} else {
			EClass rootClass;
			if (common.size() == 1) {
				rootClass = common.iterator().next();
			} else {
				final Map<String, EClass> possibleContainers = new LinkedHashMap<>();

				for (final EClass c : common) {
					possibleContainers.put(c.getName(), c);
				}

				/*
				 * Consult the specified resolving strategy to resolve the ambiguity.				
				 */
				try {
					List<EClass> resolved = ambiguityResolvingStrategy.resolveRootElementAmbiguity(new ArrayList<>(possibleContainers.values()));
					rootClass = possibleContainers.get(resolved.get(0));
				} catch (Exception e) {
					consoleStream.println(e.getMessage());
					cancel();
					return;
				}

				//				final GenericItemSelectorDialogRunner<String> dialog = new GenericItemSelectorDialogRunner<>(
				//						"There was more than one target model element that could not be connected to a root element. Therefore "
				//								+ "a model root element needs to be created. Please select a fitting class:",
				//								new LinkedList<>(possibleContainers.keySet()), 0);
				//				Display.getDefault().syncExec(dialog);
				//				if (dialog.wasTransformationStopRequested()) {
				//					cancel();
				//					return;
				//				}
				//				rootClass = possibleContainers.get(dialog.getSelection());
			}

			final EObject containerInstance = rootClass.getEPackage()
					.getEFactoryInstance().create(rootClass);
			addToTargetModelRoot(new EObjectWrapper(
					containerInstance,
					targetSectionRegistry.getAttrValRegistry()));
			consoleStream.println("Root element: '" + rootClass.getName()+ "' (generated)");

			for (final EClass c : unlinkeableElements.keySet()) {
				for (final TargetSectionClass tSection : unlinkeableElements
						.get(c).keySet()) {
					/*
					 * It gets a bit tricky here. If there is more than one
					 * common container, we have to choose one. Then we need to
					 * find all possible connections for each of the elements
					 * involved. Now we need to choose a connection for each
					 * element. This might lead to us asking a lot of questions
					 * to the user.
					 */
					final LinkedList<ModelConnectionPath> pathSet = targetSectionRegistry
							.getConnections(c, rootClass, maxPathLength);
					if (pathSet.size() < 1) {
						addToTargetModelRoot(unlinkeableElements.get(c).get(
								tSection));// This should not have happened =>
						// programming error
						consoleStream.println("Error. Check container instantiation");
					} else {

						// get paths with fitting capacity
						final int neededCapacity = unlinkeableElements.get(c)
								.get(tSection).size();
						final LinkedList<ModelConnectionPath> fittingPaths = new LinkedList<>();
						for (final ModelConnectionPath p : pathSet) {
							int capacity = p.getCapacity(containerInstance);
							if (capacity == -1 || capacity >= neededCapacity) {
								fittingPaths.add(p);
							}
						}

						if (fittingPaths.size() > 0) {
							// get shortest path
							ModelConnectionPath chosenPath = fittingPaths
									.get(0);
							int chosenPathSize = chosenPath.size();
							for (final ModelConnectionPath p : fittingPaths) {// get
								/*
								 * one of the shortest paths
								 */
								final int pSize = p.size();
								if (pSize < chosenPathSize) {
									chosenPath = p;
									chosenPathSize = pSize;
								}
							}

							if (fittingPaths.size() > 1) {
								/*
								 * Consult the specified resolving strategy to resolve the ambiguity.				
								 */
								try {
									List<ModelConnectionPath> resolved = ambiguityResolvingStrategy.resolveConnectionPathAmbiguity(fittingPaths, (TargetSection) tSection);
									chosenPath = resolved.get(0);
								} catch (Exception e) {
									consoleStream.println(e.getMessage());
									cancel();
									return;
								}
								//								final GenericItemSelectorDialogRunner<ModelConnectionPath> dialog = new GenericItemSelectorDialogRunner<>(
								//										"Please choose one of the possible connections for connecting the "
								//												+ "instances of the target section '" + tSection.getName() + "' (EClass: '"
								//												+ c.getName() + "') to the model root element of the type '" + rootClass.getName() + "'.",
								//												fittingPaths,
								//												fittingPaths.indexOf(chosenPath));
								//								Display.getDefault().syncExec(dialog);
								//								if (dialog.wasTransformationStopRequested()) {
								//									canceled = true;
								//									return;
								//								}
								//								chosenPath = dialog.getSelection();
							}

							// now instantiate path
							chosenPath.instantiate(containerInstance, unlinkeableElements.get(c).get(tSection));
							consoleStream.println("Connected to root: " + tSection.getName() + ": " + chosenPath.toString());
						} else {
							consoleStream.println("The chosen container '" + rootClass.getName() + "' cannot fit the elements of the type '"
									+ c.getName() + "', sorry.");
							addToTargetModelRoot(unlinkeableElements.get(c).get(tSection));
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
			final LinkedList<EObjectWrapper> containerInstances) {

		// nothing to connect
		if (rootInstances == null || rootInstances.isEmpty()) {
			return;
		}

		/*
		 * A list of possible 'containerClasses' has been passed as parameter so we need to restrict the list of
		 * EClass that are considered when searching for connection paths.
		 */
		boolean restrictContainer = (containerClasses != null && !containerClasses.isEmpty());

		/*
		 * This represents the final ModelConnectionPath that will be instantiated at the end.
		 */
		ModelConnectionPath modelConnectionPath;

		final EClass classToConnect = section.getEClass();

		/*
		 * A set of ModelConnectionPaths that are possible and thus have to be considered by the selection algorithms.
		 */
		LinkedList<ModelConnectionPath> pathsToConsider = new LinkedList<>();
		if (restrictContainer) {
			for (final EClass c : containerClasses) {
				pathsToConsider.addAll(
						targetSectionRegistry.getConnections(classToConnect, c, maxPathLength));
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
				unlinkeableElements.put(classToConnect,
						new LinkedHashMap<TargetSectionClass, List<EObjectWrapper>>());
			}
			if (!unlinkeableElements.get(classToConnect).containsKey(section)) {
				unlinkeableElements.get(classToConnect).put(section,
						new LinkedList<EObjectWrapper>());
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

			if (containerInstances.size() == 0) {
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
				inst = containerInstances.getFirst();
			} else if (!rootInstances.contains(targetSectionRegistry
					.getTargetClassInstances(
							modelConnectionPath.getPathRootClass())
					.getFirst())) {
				inst = targetSectionRegistry.getTargetClassInstances(
						modelConnectionPath.getPathRootClass())
						.getFirst();
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

		} else if (pathsToConsider.size() > 0) {// user decides
			final LinkedHashMap<String, ModelConnectionPath> pathNames = new LinkedHashMap<>();
			final LinkedHashMap<String, LinkedHashMap<String, EObjectWrapper>> instancesByPath = new LinkedHashMap<>();
			ModelConnectionPath standardPath = pathsToConsider
					.iterator().next();// get shortest path
			for (final ModelConnectionPath p : pathsToConsider) {// prepare
				// user
				// selections
				final LinkedHashMap<String, EObjectWrapper> instances = new LinkedHashMap<>();
				for (final EObjectWrapper inst : targetSectionRegistry
						.getTargetClassInstances(p.getPathRootClass())) {
					if (!rootInstances.contains(inst)
							&& (!restrictContainer || containerInstances
									.contains(inst))) {

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

			if (instancesByPath.keySet().size() == 0) {
				consoleStream.println("Could not find a path that leads to the container specified for targetSection '"
						+ section.getName() + "'");
				addToTargetModelRoot(rootInstances);
				return;
			}

			final LinkedList<String> namesAsList = new LinkedList<>();
			namesAsList.addAll(pathNames.keySet());
			final List<List<String>> instanceNames = new LinkedList<>();

			for (final String k : namesAsList) {
				final LinkedList<String> instNamesAsList = new LinkedList<>();
				instNamesAsList.addAll(instancesByPath.get(k).keySet());

				instanceNames.add(instNamesAsList);
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
				HashMap<ModelConnectionPath, List<EObjectWrapper>> resolved = ambiguityResolvingStrategy.resolveConnectionPathAmbiguity(choices, section, rootInstances, mappingGroup);
				modelConnectionPath = resolved.entrySet().iterator().next().getKey();
				inst = instancesByPath.get(modelConnectionPath).get(resolved.entrySet().iterator().next().getValue().get(0));
			} catch (Exception e) {
				consoleStream.println(e.getMessage());
				cancel();
				return;
			}

			//			final PathAndInstanceSelectorRunner dialog = new PathAndInstanceSelectorRunner(
			//					rootInstances.size() + " Instance" + (rootInstances.size() > 1 ? "s" : "") + " of the TargetSection '"
			//							+ section.getName() + "', created by the mapping '" + mappingName + " (Group: " + mappingGroupName
			//							+ ")', " + (rootInstances.size() > 1 ? "have" : "has a") + " root element" + (rootInstances.size() > 1 ? "s" : "")
			//							+ " of the type '" + classToConnect.getName()+ "'. "
			//							+ (rootInstances.size() > 1 ? "Theese need" : "It needs") + " to be put at a sensible position in the target model. "
			//							+ "Please choose one of the possible connections to other existing target model elements"
			//							+ " below.", namesAsList, instanceNames);
			//
			//			Display.getDefault().syncExec(dialog); // TODO Maybe add
			//			// option to not do
			//			// anything
			//			if (dialog.wasTransformationStopRequested()) {
			//				canceled = true;
			//				return;
			//			}
			//			// now ask user
			//			modelConnectionPath = pathNames.get(dialog.getPath());

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

		final LinkedHashMap<ModelConnectionHintTargetAttribute, LinkedList<EObjectWrapper>> containerInstancesByTargetAttribute = 
				new LinkedHashMap<>();

		for (final ModelConnectionHintTargetAttribute targetAttr : connectionHint
				.getTargetAttributes()) {
			containerInstancesByTargetAttribute
			.put(targetAttr, targetSectionRegistry
					.getFlattenedPamtramClassInstances(targetAttr
							.getSource().getOwningClass()));// owningClass

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
				connectionHintValuesCopy.add(modelConnectionHintValues
						.getFirst());
			}
		} else {
			connectionHintValuesCopy = modelConnectionHintValues;
		}

		for (final Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> hintVal : connectionHintValuesCopy) {

			String hintValAsString = null;
			if (connectionHint instanceof ModelConnectionHint) {
				hintValAsString = "";

				for (final ModelConnectionHintSourceInterface srcElement : connectionHint.getSourceElements()) {
					if (hintVal.containsKey(srcElement)) {
						hintValAsString += hintVal.get(srcElement).getValue();
					} else {
						consoleStream.println("HintSourceValue not found " + srcElement.getName() + " in ComplexModelConnectionHint "
								+ connectionHint.getName() + "(Mapping: " + mappingName + ", Group: " + mappingGroup.getName() + ").");
					}
				}
			}

			if (!contInstsByHintVal.containsKey(hintValAsString)) {
				contInstsByHintVal.put(hintValAsString,
						new LinkedHashSet<EObjectWrapper>());
			}

			if (!rootInstancesByHintVal.containsKey(hintValAsString)) {
				rootInstancesByHintVal.put(hintValAsString,
						new LinkedHashSet<EObjectWrapper>());
			}

			rootInstancesByHintVal.get(hintValAsString).add(
					rootInstances.remove(0));// instances have same
			// order as hintValues

			for (final ModelConnectionHintTargetAttribute conAttr : containerInstancesByTargetAttribute
					.keySet()) {

				final String modifiedHintVal = attributeValuemodifier
						.applyAttributeValueModifiers(hintValAsString,
								conAttr.getModifier());

				/*
				 * now find a fitting instance get Attribute value
				 */
				for (final EObjectWrapper contInst : containerInstancesByTargetAttribute.get(conAttr)) {
					// TODO check limited capacity
					// TODO check type of referenced object

					final String targetValStr = contInst
							.getAttributeValue(conAttr.getSource());

					if (targetValStr != null) {
						if (modifiedHintVal.equals(targetValStr)) {
							contInstsByHintVal.get(hintValAsString).add(
									contInst);
						}
					} else {
						consoleStream.println("Problemo?");
					}

				}
			}

		}

		// now select targetInst
		final LinkedHashMap<EObjectWrapper, LinkedHashSet<EObjectWrapper>> rootInstancesByContainer = new LinkedHashMap<>();
		for (final String hintVal : rootInstancesByHintVal.keySet()) {
			if (contInstsByHintVal.get(hintVal).size() == 1) {
				rootInstancesByContainer.put(contInstsByHintVal
						.get(hintVal).iterator().next(),
						rootInstancesByHintVal.get(hintVal));
			} else if (contInstsByHintVal.get(hintVal).size() > 1) {// let
				// user
				// decide
				if (canceled) {
					return;
				}

				/*
				 * Consult the specified resolving strategy to resolve the ambiguity.				
				 */

				try {
					List<EObjectWrapper> resolved = ambiguityResolvingStrategy.resolveJoiningAmbiguity(
							new LinkedList<>(contInstsByHintVal.get(hintVal)), new LinkedList<>(rootInstancesByHintVal.get(hintVal)), null, connectionHint, hintVal);
					rootInstancesByContainer.put(resolved.get(0), rootInstancesByHintVal.get(hintVal));
				} catch (Exception e) {
					consoleStream.println(e.getMessage());
					cancel();
					return;
				}

				//				final GenericItemSelectorDialogRunner<EObjectWrapper> dialog = new GenericItemSelectorDialogRunner<>(
				//						"The ModelConnectionHint '" + connectionHint.getName() + " (Mapping :" + mappingName + ", Group: " + mappingGroupName
				//						+ ")' points to a non-unique Attribute. Please choose under which elements " + 
				//						(rootInstancesByHintVal.get(hintVal).size() > 1 ? 
				//								"theese " + rootInstancesByHintVal.get(hintVal).size()+ "elements" : 
				//									"this " + rootInstancesByHintVal.get(hintVal).size() + "element")
				//						+ " should be inserted.\n\n" + "Attribute value: " + hintVal,
				//						new LinkedList<>(contInstsByHintVal.get(hintVal)), 0);
				//				Display.getDefault().syncExec(dialog);
				//				if (dialog.wasTransformationStopRequested()) {
				//					canceled = true;
				//					return;
				//				}
				//				rootInstancesByContainer.put(dialog.getSelection(),
				//						rootInstancesByHintVal.get(hintVal));

			} else {
				consoleStream.println("The ModelConnectionHint '" + connectionHint.getName() + " of MappingHintGroup " + mappingGroup.getName()
				+ "(Mapping: " + mappingName + ") could not find an instance to connect the targetSections.\n" + contInstsByHintVal.keySet());
				addToTargetModelRoot(rootInstancesByHintVal.get(hintVal));
			}
		}

		// only go on if any of the instances could be matched
		if(rootInstancesByContainer.keySet().isEmpty())	 {
			return;
		}

		for (final EObjectWrapper container : rootInstancesByContainer
				.keySet()) {

			/*
			 * Check if there already is a standard path for the given connection hint and the given target eClass that
			 * satisfies the minimum capacity.
			 */
			boolean otherPathsNeeded = false;
			if (!standardPaths.containsKey(connectionHint) || !standardPaths.get(connectionHint).getPathRootClass().equals(container.getEObject().eClass())) {
				otherPathsNeeded = true;
			} else {
				final int capacity = standardPaths.get(connectionHint)
						.getCapacity(container.getEObject());
				if (!(capacity >= rootInstancesByContainer.get(
						container).size() || capacity == -1)) {
					standardPaths.remove(connectionHint);
					otherPathsNeeded = true;
				}
			}

			/*
			 * A set of ModelConnectionPaths that are possible and thus have to be considered by the selection algorithms.
			 */
			LinkedList<ModelConnectionPath> pathsToConsider = new LinkedList<>();
			if (otherPathsNeeded) {
				/*
				 * Find all possible paths to concider that satisfy the minimum capacity.
				 */
				pathsToConsider = ModelConnectionPath.findPathsWithMinimumCapacity(
						targetSectionRegistry.getConnections(
								section.getEClass(), 
								container.getEObject().eClass(),maxPathLength
								), 
						container.getEObject(),
						rootInstancesByContainer.get(container).size()
						);

			} else {
				/*
				 * 
				 */
				pathsToConsider.add(standardPaths.get(connectionHint));
			}

			ModelConnectionPath modelConnectionPath = null;
			if (pathsToConsider.size() == 1) {// only one path to choose
				// from
				modelConnectionPath = pathsToConsider.iterator().next();
			} else if (pathsToConsider.size() > 0) {// user decides
				ModelConnectionPath standardPath = pathsToConsider.get(0);// get shortest path

				for (final ModelConnectionPath p : pathsToConsider) {// prepare
					// user
					// selections

					if (p.size() < standardPath.size())
					{
						standardPath = p;// save shortest path
					}
				}
				final int instSize = rootInstancesByContainer.get(
						container).size();
				if (canceled) {
					return;
				}

				/*
				 * Consult the specified resolving strategy to resolve the ambiguity.				
				 */

				try {
					List<ModelConnectionPath> resolved = ambiguityResolvingStrategy.resolveConnectionPathAmbiguity(pathsToConsider, section);
					modelConnectionPath = resolved.get(0);
				} catch (Exception e) {
					consoleStream.println(e.getMessage());
					cancel();
					return;
				}
				//				final GenericItemSelectorDialogRunner<ModelConnectionPath> dialog = new GenericItemSelectorDialogRunner<>(
				//						instSize + " Instance" + (instSize > 1 ? "s" : "") + " of the TargetSection '" + section.getName() + "', created by the mapping '"
				//								+ mappingName + " (Group: " + mappingGroup.getName() + ")', " + (instSize > 1 ? "have" : "has a") + " root element" + (instSize > 1 ? "s" : "")
				//								+ " of the type '" + section.getEClass().getName() + "'. "
				//								+ (instSize > 1 ? "Theese need" : "It needs") + " to be put at a sensible position in the target model. "
				//								+ "Please choose one of the possible connections to other existing target model elements"
				//								+ " below. Your selection will be remembered for the ConnectionHint '" + connectionHint.getName() + "'.",
				//								pathsToConsider,
				//								pathsToConsider.indexOf(standardPath));
				//				Display.getDefault().syncExec(dialog);
				//				if (dialog.wasTransformationStopRequested()) {
				//					canceled = true;
				//					return;
				//				}
				//				modelConnectionPath = dialog.getSelection();
			} else {
				consoleStream.println("Could not find a path that leads to the container specified by the ModelConnectionHint of "
						+ mappingName + "::" + mappingGroup.getName());
				addToTargetModelRoot(rootInstances);
				addToTargetModelRoot(rootInstancesByContainer.get(container));
			}
			if(modelConnectionPath == null) {
				continue;
			}

			if (!standardPaths.containsKey(connectionHint) || !standardPaths.get(connectionHint).getPathRootClass().equals(container.getEObject().eClass())) {
				standardPaths.put(connectionHint, modelConnectionPath);
				consoleStream.println("Path found: " + section.getName() + "(" + mappingName + "::" + mappingGroup.getName() + "): " + modelConnectionPath.toString());
			}

			// now instantiate path(s))
			if (rootInstancesByContainer.get(container).contains(
					container)) {// we will allow objects that reference
				// themselves as container
				addToTargetModelRoot(container); // because this was
				// explicitly
				// specified by tho
				// ModelConnectionHint
			}
			/*
			 * Try to instantiate Paths and add failed elements to
			 * target model root
			 */
			addToTargetModelRoot(modelConnectionPath.instantiate(
					container.getEObject(),
					rootInstancesByContainer.get(container)));

		}
	}

}
