package de.mfreund.gentrans.transformation;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.mapping.ComplexModelConnectionHint;
import pamtram.mapping.ComplexModelConnectionHintSourceInterface;
import pamtram.mapping.ConnectionHintTargetAttribute;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.SimpleModelConnectionHint;
import pamtram.metamodel.TargetSectionClass;
import de.mfreund.gentrans.transformation.selectors.GenericItemSelectorDialogRunner;
import de.mfreund.gentrans.transformation.selectors.PathAndInstanceSelectorRunner;

/**
 * Class for linking the sections of the target model.
 *
 * @author Sascha Steffen
 * @version 1.0
 */
class TargetSectionConnector implements CancellationListener {
	/**
	 * Paths previously selected by the user.
	 */
	private final LinkedHashMap<ModelConnectionHint, ModelConnectionPath> standardPaths;

	/**
	 * target section registry, used when finding instances to which sections
	 * can be connected
	 */
	private final TargetSectionRegistry targetSectionRegistry;
	/**
	 * target model
	 */
	private final XMIResource targetModel;
	/**
	 * Output stream for messages
	 */
	private final MessageConsoleStream consoleStream;

	/**
	 * used for modifying attribute values
	 */
	private final AttributeValueModifierExecutor attributeValuemodifier;

	/**
	 * true when the transformation was aborted by the user
	 */
	private boolean transformationAborted;
	/**
	 * Maximum length for connection paths maxPathlength<0 == unbounded
	 */
	private final int maxPathlength;
	/**
	 * Unlinkeable elements
	 */
	private final Map<EClass, Map<TargetSectionClass, List<EObjectTransformationHelper>>> unlinkeableElements;

	/**
	 * @param attrValRegistry
	 *            Attribute value registry, needed when applying model
	 *            connection hints
	 * @param targetSectionRegistry
	 *            target section registry, used when finding instances to which
	 *            sections can be connected
	 * @param targetModel
	 * @param consoleStream
	 *            Output stream for messages
	 */
	TargetSectionConnector(final AttributeValueRegistry attrValRegistry,
			final TargetSectionRegistry targetSectionRegistry,
			final AttributeValueModifierExecutor attributeValuemodifier,
			final XMIResource targetModel, final int maxPathLength,
			final MessageConsoleStream consoleStream) {
		standardPaths = new LinkedHashMap<ModelConnectionHint, ModelConnectionPath>();
		this.targetSectionRegistry = targetSectionRegistry;
		this.targetModel = targetModel;
		this.consoleStream = consoleStream;
		transformationAborted = false;
		this.attributeValuemodifier = attributeValuemodifier;
		maxPathlength = maxPathLength;
		unlinkeableElements = new LinkedHashMap<EClass, Map<TargetSectionClass, List<EObjectTransformationHelper>>>();
	}

	/**
	 * List of instances to put at the root of the target model.
	 *
	 * @param i
	 */
	private void addToTargetModelRoot(
			final Collection<EObjectTransformationHelper> i) {
		for (final EObjectTransformationHelper h : i) {
			addToTargetModelRoot(h);
		}
	}

	/**
	 * If no model connection could be found, an object needs to be added to the
	 * root of the target model.
	 *
	 * @param helper
	 */
	private void addToTargetModelRoot(final EObjectTransformationHelper helper) {
		targetModel.getContents().add(helper.getEObject());
	}

	@Override
	public void cancel() {
		transformationAborted = true;

	}

	/**
	 * Finds or tries to create a common target model root and tries to connect
	 * the unlinked sections with it.
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
							.iterator().next().values().iterator().next()
							.get(0));
					consoleStream
					.println("Root element: The single instance of the target section '"
							+ unlinkeableElements.values().iterator()
							.next().keySet().iterator().next()
							.getName() + "'.");
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

		final Set<EClass> common = new HashSet<EClass>();
		for (final EClass possibleRoot : targetSectionRegistry
				.getMetaModelClasses()) {
			boolean failed = false;
			if (!possibleRoot.isAbstract()) {
				for (final EClass c : unlinkeableElements.keySet()) {
					if (transformationAborted)
						return;
					if (targetSectionRegistry.getConnections(c, possibleRoot,
							maxPathlength).size() < 1) {
						failed = true;
						break;
					}
				}
				if (!failed) {
					common.add(possibleRoot);
				}
			}
		}

		if (transformationAborted)
			return;

		if (common.size() < 1) {
			for (final EClass c : unlinkeableElements.keySet()) {
				consoleStream
				.println("No suitable path found for target class: "
						+ c.getName());
				for (final List<EObjectTransformationHelper> instances : unlinkeableElements
						.get(c).values()) {
					addToTargetModelRoot(instances);
				}
			}
		} else {
			EClass rootClass;
			if (common.size() == 1) {
				rootClass = common.iterator().next();
			} else {
				final Map<String, EClass> possibleContainers = new LinkedHashMap<String, EClass>();

				for (final EClass c : common) {
					possibleContainers.put(c.getName(), c);
				}

				final GenericItemSelectorDialogRunner<String> dialog = new GenericItemSelectorDialogRunner<String>(
						"There was more than one target model element that could not be connected to a root element. Therefore "
								+ "a model root element needs to be created. Please select a fitting class:",
						new LinkedList<String>(possibleContainers.keySet()), 0);
				Display.getDefault().syncExec(dialog);
				if (dialog.wasTransformationStopRequested()) {
					cancel();
					return;
				}
				rootClass = possibleContainers.get(dialog.getSelection());
			}

			final EObject containerInstance = rootClass.getEPackage()
					.getEFactoryInstance().create(rootClass);
			addToTargetModelRoot(new EObjectTransformationHelper(
					containerInstance,
					targetSectionRegistry.getAttrValRegistry()));
			consoleStream.println("Root element: '" + rootClass.getName()
					+ "' (generated)");

			for (final EClass c : unlinkeableElements.keySet()) {
				for (final TargetSectionClass tSection : unlinkeableElements
						.get(c).keySet()) {
					/*
					 * It gets a bit tricky here. If there is more than one
					 * common container, we have to choose one. Then we need to
					 * find all possible connections for each of the elements
					 * involved. Now we need to choose a connection for each
					 * element. This would lead to us asking a lot of questions
					 * to the user. Therefore we will concentrate on using the
					 * shortest connection paths. All we need to ask the user is
					 * which container to use.
					 */
					final Set<ModelConnectionPath> pathSet = targetSectionRegistry
							.getConnections(c, rootClass, maxPathlength);
					if (pathSet.size() < 1) {
						addToTargetModelRoot(unlinkeableElements.get(c).get(
								tSection));// This should not have happened =>
						// programming error
						consoleStream
						.println("Error. Check container instantiation");
					} else {

						// get paths with fitting capacity
						final int neededCapacity = unlinkeableElements.get(c)
								.get(tSection).size();
						final LinkedList<ModelConnectionPath> fittingPaths = new LinkedList<ModelConnectionPath>();
						for (final ModelConnectionPath p : pathSet) {
							if (p.getCapacity(containerInstance) >= neededCapacity) {
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
								final GenericItemSelectorDialogRunner<ModelConnectionPath> dialog = new GenericItemSelectorDialogRunner<ModelConnectionPath>(
										"Please choose one of the possible connections for connecting the "
												+ "instances of the target section '"
												+ tSection.getName()
												+ "' (EClass: '"
												+ c.getName()
												+ "') "
												+ " to the model root element of the type '"
												+ rootClass.getName() + "'.",
												fittingPaths,
												fittingPaths.indexOf(chosenPath));
								Display.getDefault().syncExec(dialog);
								if (dialog.wasTransformationStopRequested()) {
									transformationAborted = true;
									return;
								}
								chosenPath = dialog.getSelection();
							}

							// now instantiate path
							chosenPath.instantiate(containerInstance,
									unlinkeableElements.get(c).get(tSection));
							consoleStream.println("Connected to root: "
									+ tSection.getName() + ": "
									+ chosenPath.toString());
						} else {
							consoleStream.println("The chosen container '"
									+ rootClass.getName()
									+ "' cannot fit the elements of the type '"
									+ c.getName() + "', sorry.");
							addToTargetModelRoot(unlinkeableElements.get(c)
									.get(tSection));
						}

					}
				}
			}

		}
	}

	/**
	 * @return true when the transformation was aborted by the user
	 */
	@Override
	public boolean isCancelled() {
		return transformationAborted;
	}

	/**
	 * Try to link a List of instances ( and therefore entire sections of the
	 * target model) to other objects of the target model.
	 * <p>
	 * This method is used for connecting sections without model connection
	 * hints.
	 * <p>
	 * If hasContaienr is set true the rootInstances will be connected to one of
	 * the instances in containerInstances.
	 *
	 * @param classToConnect
	 * @param rootInstances
	 * @param section
	 * @param mappingName
	 * @param mappingGroupName
	 * @param hasContainer
	 * @param containerInstances
	 */
	void linkToTargetModelNoConnectionHint(
			final List<EObjectTransformationHelper> rootInstances,
			final TargetSectionClass section, final String mappingName,
			final String mappingGroupName, final boolean hasContainer,
			final Set<EClass> containerClasses,
			final LinkedList<EObjectTransformationHelper> containerInstances) {
		ModelConnectionPath modelConnectionPath;
		final EClass classToConnect = section.getEClass();

		LinkedHashSet<ModelConnectionPath> pathsToConsider = new LinkedHashSet<ModelConnectionPath>();
		if (hasContainer) {
			for (final EClass c : containerClasses) {
				pathsToConsider.addAll(targetSectionRegistry.getConnections(
						classToConnect, c, maxPathlength));
			}
		} else {
			pathsToConsider.addAll(targetSectionRegistry.getPaths(
					classToConnect, maxPathlength));
		}

		if (pathsToConsider.size() > 0) {
			pathsToConsider = ModelConnectionPath.findPathsWithMinimumCapacity(
					pathsToConsider, null, rootInstances.size());
			/*
			 * only go on with paths that could theoretically fit all of the
			 * elements
			 */

			if (pathsToConsider.size() > 0) {
				// handle container
				boolean onlyOnePath;
				if (hasContainer) {

					if (containerInstances.size() == 0) {
						consoleStream
								.println("Instances of the targetSection '"
										+ section.getName()
										+ "'specify a container section (either the target section itself or a MappingHintImporter)."
										+ " Unfortunately no instances of the specified container were created. Therefore the sections will not be linked to the target model.");
						addToTargetModelRoot(rootInstances);
						return;
					}

					for (final ModelConnectionPath p : new LinkedList<ModelConnectionPath>(
							pathsToConsider)) {
						boolean found = false;
						for (final EClass c : containerClasses) {
							if (p.leadsToRootType(c)) {
								found = true;
								break;
							}
						}

						if (!found) {
							pathsToConsider.remove(p);// narrow down possible
							// paths
						}
					}

					onlyOnePath = pathsToConsider.size() == 1
							&& containerInstances.size() == 1;
				} else {
					onlyOnePath = pathsToConsider.size() == 1
							&& targetSectionRegistry.getTargetClassInstances(
									pathsToConsider.iterator().next()
									.getPathRootClass()).size() == 1;
				}

				if (onlyOnePath) {// only one path to choose from
					modelConnectionPath = pathsToConsider.iterator().next();
					// select instance of path end to associate elements to
					EObjectTransformationHelper inst;
					if (hasContainer) {
						inst = containerInstances.getFirst();
					} else if (!rootInstances.contains(targetSectionRegistry
							.getTargetClassInstances(
									modelConnectionPath.getPathRootClass())
									.getFirst())) {
						inst = targetSectionRegistry.getTargetClassInstances(
								modelConnectionPath.getPathRootClass())
								.getFirst();
					} else {
						consoleStream
						.println("Could not find a path that leads to the container specified for targetSection '"
								+ section.getName() + "'");
						addToTargetModelRoot(rootInstances);
						return;
					}

					consoleStream.println("Path found: " + section.getName()
							+ "(" + mappingName + "::" + mappingGroupName
							+ "): " + modelConnectionPath.toString());

					/*
					 * Try to instantiate Paths and add failed elements to
					 * target model root
					 */
					addToTargetModelRoot(modelConnectionPath.instantiate(
							inst.getEObject(), rootInstances));

				} else if (pathsToConsider.size() > 0) {// user decides
					final LinkedHashMap<String, ModelConnectionPath> pathNames = new LinkedHashMap<String, ModelConnectionPath>();
					final LinkedHashMap<String, LinkedHashMap<String, EObjectTransformationHelper>> instancesByPath = new LinkedHashMap<String, LinkedHashMap<String, EObjectTransformationHelper>>();
					ModelConnectionPath standardPath = pathsToConsider
							.iterator().next();// get shortest path
					for (final ModelConnectionPath p : pathsToConsider) {// prepare
						// user
						// selections
						final LinkedHashMap<String, EObjectTransformationHelper> instances = new LinkedHashMap<String, EObjectTransformationHelper>();
						for (final EObjectTransformationHelper inst : targetSectionRegistry
								.getTargetClassInstances(p.getPathRootClass())) {
							if (!rootInstances.contains(inst)
									&& (!hasContainer || containerInstances
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
						consoleStream
						.println("Could not find a path that leads to the container specified for targetSection '"
								+ section.getName() + "'");
						addToTargetModelRoot(rootInstances);
						return;
					}

					final LinkedList<String> namesAsList = new LinkedList<String>();
					namesAsList.addAll(pathNames.keySet());
					final List<List<String>> instanceNames = new LinkedList<List<String>>();

					for (final String k : namesAsList) {
						final LinkedList<String> instNamesAsList = new LinkedList<String>();
						instNamesAsList.addAll(instancesByPath.get(k).keySet());

						instanceNames.add(instNamesAsList);
					}
					if (transformationAborted)
						return;
					final PathAndInstanceSelectorRunner dialog = new PathAndInstanceSelectorRunner(
							rootInstances.size()
									+ " Instance"
							+ (rootInstances.size() > 1 ? "s" : "")
							+ " of the TargetSection '"
									+ section.getName()
									+ "', created by the mapping '"
									+ mappingName
									+ " (Group: "
									+ mappingGroupName
									+ ")"
									+ "', "
							+ (rootInstances.size() > 1 ? "have"
									: "has a")
									+ " root element"
									+ (rootInstances.size() > 1 ? "s" : "")
									+ " of the type '"
									+ classToConnect.getName()
									+ "'. "
									+ (rootInstances.size() > 1 ? "Theese need"
											: "It needs")
											+ " to be put at a sensible position in the target model. "
									+ "Please choose one of the possible connections to other existing target model elements"
									+ " below.", namesAsList, instanceNames);

					Display.getDefault().syncExec(dialog); // TODO Maybe add
															// option to not do
															// anything
					if (dialog.wasTransformationStopRequested()) {
						transformationAborted = true;
						return;
					}
					// now ask user
					modelConnectionPath = pathNames.get(dialog.getPath());
					// select instance of path end to associate elements to
					final EObjectTransformationHelper inst = instancesByPath
							.get(dialog.getPath()).get(dialog.getInstance());
					consoleStream.println(section.getName() + "(" + mappingName
							+ "): " + modelConnectionPath.toString());

					/*
					 * Try to instantiate Paths and add failed elements to
					 * target model root
					 */
					addToTargetModelRoot(modelConnectionPath.instantiate(
							inst.getEObject(), rootInstances));

				} else {// no suitable container found
					consoleStream
							.println("Could not find a path that leads to the container specified for the target section '"
									+ section.getName() + "'");
					addToTargetModelRoot(rootInstances);
				}

			} else {// TODO handle limited capacity
				addToTargetModelRoot(rootInstances);
			}

		} else {
			if (!unlinkeableElements.containsKey(classToConnect)) {
				unlinkeableElements
				.put(classToConnect,
						new LinkedHashMap<TargetSectionClass, List<EObjectTransformationHelper>>());
			}
			if (!unlinkeableElements.get(classToConnect).containsKey(section)) {
				unlinkeableElements.get(classToConnect).put(section,
						new LinkedList<EObjectTransformationHelper>());
			}
			unlinkeableElements.get(classToConnect).get(section)
			.addAll(rootInstances);
		}
	}

	/**
	 * Try to link a List of instances ( and therefore entire sections of the
	 * target model) to other objects of the target model.
	 * <p>
	 * This method is used for connecting sections using model connection hints.
	 *
	 * @param classToConnect
	 * @param rootInstances
	 * @param section
	 * @param mappingName
	 * @param mappingGroupName
	 * @param connectionHint
	 * @param connectionHintValues
	 */
	void linkToTargetModelUsingModelConnectionHint(final EClass classToConnect,
			final List<EObjectTransformationHelper> rootInstances,
			final TargetSectionClass section, final String mappingName,
			final String mappingGroupName,
			final ModelConnectionHint connectionHint,
			final LinkedList<Object> connectionHintValues,
			final int maxPathLength) {// connectionHint.targetAttribute.~owningClass
		if (rootInstances.size() < 1)
			return;// if we don't do this here an ArrayOutOfBoundsException
					// might occur later

		// check for connections
		int size = 0;
		for (final ConnectionHintTargetAttribute attr : connectionHint
				.getTargetAttributes()) {
			size += targetSectionRegistry.getConnections(classToConnect,
					attr.getTargetAttribute().getOwningClass().getEClass(),
					maxPathlength).size();
		}

		if (size > 0) {
			// now search for target attributes

			final LinkedHashMap<ConnectionHintTargetAttribute, LinkedList<EObjectTransformationHelper>> containerInstancesByTargetAttribute = new LinkedHashMap<ConnectionHintTargetAttribute, LinkedList<EObjectTransformationHelper>>();

			for (final ConnectionHintTargetAttribute targetAttr : connectionHint
					.getTargetAttributes()) {
				containerInstancesByTargetAttribute
				.put(targetAttr, targetSectionRegistry
						.getFlattenedPamtramClassInstances(targetAttr
								.getTargetAttribute().getOwningClass()));// owningClass

			}

			// find container Instance for each element

			final LinkedHashMap<String, LinkedHashSet<EObjectTransformationHelper>> contInstsByHintVal = new LinkedHashMap<String, LinkedHashSet<EObjectTransformationHelper>>();
			final LinkedHashMap<String, LinkedHashSet<EObjectTransformationHelper>> rootInstancesByHintVal = new LinkedHashMap<String, LinkedHashSet<EObjectTransformationHelper>>();
			LinkedList<Object> connectionHintValuesCopy;

			// again, we need to handle the special case, when there is only one
			// hintValue
			if (connectionHintValues.size() == 1) {
				connectionHintValuesCopy = new LinkedList<Object>();
				for (int i = 0; i < rootInstances.size(); i++) {
					connectionHintValuesCopy.add(connectionHintValues
							.getFirst());
				}
			} else {
				connectionHintValuesCopy = connectionHintValues;
			}

			for (final Object hintVal : connectionHintValuesCopy) {
				String hintValAsString = null;
				if (connectionHint instanceof SimpleModelConnectionHint) {
					hintValAsString = (String) hintVal;
				} else if (connectionHint instanceof ComplexModelConnectionHint) {
					hintValAsString = "";
					@SuppressWarnings("unchecked")
					final Map<ComplexModelConnectionHintSourceInterface, String> hVal = (Map<ComplexModelConnectionHintSourceInterface, String>) hintVal;
					for (final ComplexModelConnectionHintSourceInterface srcElement : ((ComplexModelConnectionHint) connectionHint)
							.getSourceElements()) {
						if (hVal.containsKey(srcElement)) {
							hintValAsString += hVal.get(srcElement);
						} else {
							consoleStream.println("HintSourceValue not found "
									+ srcElement.getName()
									+ " in ComplexModelConnectionHint "
									+ connectionHint.getName() + "(Mapping: "
									+ mappingName + ", Group: "
									+ mappingGroupName + ").");
						}
					}
				}

				if (!contInstsByHintVal.containsKey(hintValAsString)) {
					contInstsByHintVal.put(hintValAsString,
							new LinkedHashSet<EObjectTransformationHelper>());
				}

				if (!rootInstancesByHintVal.containsKey(hintValAsString)) {
					rootInstancesByHintVal.put(hintValAsString,
							new LinkedHashSet<EObjectTransformationHelper>());
				}

				rootInstancesByHintVal.get(hintValAsString).add(
						rootInstances.remove(0));// instances have same
				// order as hintValues

				for (final ConnectionHintTargetAttribute conAttr : containerInstancesByTargetAttribute
						.keySet()) {

					final String modifiedHintVal = attributeValuemodifier
							.applyAttributeValueModifiers(hintValAsString,
									conAttr.getModifier());

					for (final EObjectTransformationHelper contInst : containerInstancesByTargetAttribute
							.get(conAttr)) {// now find a
						// fitting
						// instance
						// get Attribute value
						// TODO check limited capacity
						// TODO check type of referenced object

						final String targetValStr = contInst
								.getAttributeValue(conAttr.getTargetAttribute());

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
			final LinkedHashMap<EObjectTransformationHelper, LinkedHashSet<EObjectTransformationHelper>> rootInstancesByContainer = new LinkedHashMap<EObjectTransformationHelper, LinkedHashSet<EObjectTransformationHelper>>();
			for (final String hintVal : rootInstancesByHintVal.keySet()) {
				if (contInstsByHintVal.get(hintVal).size() == 1) {
					rootInstancesByContainer.put(contInstsByHintVal
							.get(hintVal).iterator().next(),
							rootInstancesByHintVal.get(hintVal));
				} else if (contInstsByHintVal.get(hintVal).size() > 1) {// let
					// user
					// decide
					if (transformationAborted)
						return;
					final GenericItemSelectorDialogRunner<EObjectTransformationHelper> dialog = new GenericItemSelectorDialogRunner<EObjectTransformationHelper>(
							"The ModelConnectionHint '"
									+ connectionHint.getName()
									+ " (Mapping :"
									+ mappingName
									+ ", Group: "
									+ mappingGroupName
									+ ")"
									+ "' points to a non-unique Attribute."
									+ " Please choose under which elements "
									+ (rootInstancesByHintVal.get(hintVal)
											.size() > 1 ? "theese "
											+ rootInstancesByHintVal.get(
													hintVal).size()
													+ "elements" : "this "
													+ rootInstancesByHintVal.get(
															hintVal).size() + "element")
															+ " should be inserted.\n\n"
															+ "Attribute value: " + hintVal,
															new LinkedList<EObjectTransformationHelper>(
																	contInstsByHintVal.get(hintVal)), 0);
					Display.getDefault().syncExec(dialog);
					if (dialog.wasTransformationStopRequested()) {
						transformationAborted = true;
						return;
					}
					rootInstancesByContainer.put(dialog.getSelection(),
							rootInstancesByHintVal.get(hintVal));

				} else {
					consoleStream
					.println("The ModelConnectionHint '"
							+ connectionHint.getName()
							+ " of MappingHintGroup "
							+ mappingGroupName
							+ "(Mapping: "
							+ mappingName
							+ ") could not find an instance to connect the targetSections.\n"
							+ contInstsByHintVal.keySet());
					addToTargetModelRoot(rootInstancesByHintVal.get(hintVal));
				}
			}

			if (rootInstancesByContainer.keySet().size() > 0) {// only go on if
				// any of the
				// instances
				// could be
				// matched
				for (final EObjectTransformationHelper container : rootInstancesByContainer
						.keySet()) {
					boolean otherPathsNeeded = false;

					if (!standardPaths.containsKey(connectionHint)) {
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

					// sort possible paths by path capacity
					final LinkedList<ModelConnectionPath> pathsToConsider = new LinkedList<ModelConnectionPath>();
					if (otherPathsNeeded) {
						pathsToConsider.addAll(ModelConnectionPath
								.findPathsWithMinimumCapacity(
										targetSectionRegistry.getConnections(
												classToConnect, container
												.getEObject().eClass(),
												maxPathLength), container
												.getEObject(),
												rootInstancesByContainer.get(container)
												.size()));

					} else {
						pathsToConsider.add(standardPaths.get(connectionHint));

					}

					ModelConnectionPath modelConnectionPath;
					if (pathsToConsider.size() == 1) {// only one path to choose
						// from
						modelConnectionPath = pathsToConsider.iterator().next();
					} else if (pathsToConsider.size() > 0) {// user decides
						ModelConnectionPath standardPath = pathsToConsider
								.get(0);// get
						// shortest
						// path

						for (final ModelConnectionPath p : pathsToConsider) {// prepare
							// user
							// selections

							if (p.size() < standardPath.size())
								standardPath = p;// save shortest path
						}
						final int instSize = rootInstancesByContainer.get(
								container).size();
						if (transformationAborted)
							return;
						final GenericItemSelectorDialogRunner<ModelConnectionPath> dialog = new GenericItemSelectorDialogRunner<ModelConnectionPath>(
								instSize
								+ " Instance"
								+ (instSize > 1 ? "s" : "")
								+ " of the TargetSection '"
										+ section.getName()
										+ "', created by the mapping '"
										+ mappingName
										+ " (Group: "
										+ mappingGroupName
										+ ")"
										+ "', "
								+ (instSize > 1 ? "have" : "has a")
								+ " root element"
								+ (instSize > 1 ? "s" : "")
								+ " of the type '"
										+ classToConnect.getName()
										+ "'. "
								+ (instSize > 1 ? "Theese need"
										: "It needs")
										+ " to be put at a sensible position in the target model. "
										+ "Please choose one of the possible connections to other existing target model elements"
										+ " below. Your selection will be remembered for the ConnectionHint '"
										+ connectionHint.getName() + "'.",
										pathsToConsider,
										pathsToConsider.indexOf(standardPath));
						Display.getDefault().syncExec(dialog);
						if (dialog.wasTransformationStopRequested()) {
							transformationAborted = true;
							return;
						}
						modelConnectionPath = dialog.getSelection();
					} else {
						consoleStream
						.println("Could not find a path that leads to the container specified by the ModelConnectionHint of "
								+ mappingName + "::" + mappingGroupName);
						addToTargetModelRoot(rootInstances);
						addToTargetModelRoot(rootInstancesByContainer
								.get(container));
						continue;
					}

					if (!standardPaths.containsKey(connectionHint)) {
						standardPaths.put(connectionHint, modelConnectionPath);
						consoleStream.println("Path found: "
								+ section.getName() + "(" + mappingName + "::"
								+ mappingGroupName + "): "
								+ modelConnectionPath.toString());
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
		} else {
			consoleStream
					.println("Could not find a path that leads to the modelConnectionTarget Class specified for '"
							+ mappingName + "' (" + mappingGroupName + ")");

			addToTargetModelRoot(rootInstances);
		}
	}

}
