package de.mfreund.gentrans.transformation;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.mapping.ComplexModelConnectionHint;
import pamtram.mapping.ComplexModelConnectionHintSourceInterface;
import pamtram.mapping.ConnectionHintTargetAttribute;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.SimpleModelConnectionHint;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.TargetSectionClass;
import de.mfreund.gentrans.transformation.selectors.ItemSelectorDialogRunner;
import de.mfreund.gentrans.transformation.selectors.PathAndInstanceSelectorRunner;

/**
 * Class for linking the sections of the target model. 
 * @author Sascha Steffen
 * @version 0.8
 */
class TargetSectionConnector {
	/**
	 * Paths previously selected by the user.
	 */
	private  LinkedHashMap<ModelConnectionHint, ModelConnectionPath> standardPaths;
	/**
	 * Attribute value registry, needed when applying model connection hints
	 */
	private AttributeValueRegistry attrValRegistry;
	/**
	 * target section registry, used when finding instances to which sections can be connected 
	 */
	private TargetSectionRegistry targetSectionRegistry;
	/**
	 * target model
	 */
	private XMIResource targetModel;
	/**
	 * Output stream for messages
	 */
	private MessageConsoleStream consoleStream;
	/**
	 * true when the transformation was aborted by the user
	 */
	private boolean transformationAborted;
	
	/**
	 * @return true when the transformation was aborted by the user
	 */
	public boolean isTransformationAborted() {
		return transformationAborted;
	}
	
	/**
	 * @param attrValRegistry Attribute value registry, needed when applying model connection hints
	 * @param targetSectionRegistry target section registry, used when finding instances to which sections can be connected 
	 * @param targetModel
	 * @param consoleStream Output stream for messages
	 */
	TargetSectionConnector(AttributeValueRegistry attrValRegistry, TargetSectionRegistry targetSectionRegistry,
			XMIResource targetModel, MessageConsoleStream consoleStream){
		standardPaths = new LinkedHashMap<ModelConnectionHint, ModelConnectionPath>();
		this.attrValRegistry=attrValRegistry;
		this.targetSectionRegistry=targetSectionRegistry;
		this.targetModel=targetModel;
		this.consoleStream=consoleStream;
		this.transformationAborted=false;
	}

	/**
	 * Return possible paths that can connect a minimum number of elements
	 * @param classToConnect
	 * @param startInstance may be null
	 * @param minimumCapacity
	 * @return possible paths
	 */
	private  LinkedList<ModelConnectionPath> findPathsWithMinimumCapacity(
			EClass classToConnect, EObject startInstance, int minimumCapacity) {
		LinkedList<ModelConnectionPath> pathsToConsider = new LinkedList<ModelConnectionPath>();
		for (ModelConnectionPath p : targetSectionRegistry.getPaths(classToConnect)) {
			if (startInstance != null) {
				if (!p.leadsToRootType(startInstance.eClass())) {
					continue;// only consider paths with the right start
								// instance type
				}
			}

			int capacity = p.getCapacity(startInstance);
			if (capacity != 0) {
				if ((minimumCapacity != -1 && capacity >= minimumCapacity)
						|| capacity == -1) {
					pathsToConsider.add(p);
				}
			}
		}
		return pathsToConsider;
	}

	/**
	 * Try to link a List of instances ( and therefore entire sections of the target model)
	 * to other objects of the target model.
	 * <p>
	 * This method is used for connecting sections using model connection hints.
	 * @param classToConnect
	 * @param rootInstances
	 * @param section
	 * @param mappingName
	 * @param mappingGroupName
	 * @param connectionHint
	 * @param connectionHintValues
	 */
	void linkToTargetModelUsingModelConnectionHint(
			EClass classToConnect, List<EObjectTransformationHelper> rootInstances, TargetSectionClass section,
			String mappingName, String mappingGroupName,
			ModelConnectionHint connectionHint,
			LinkedList<Object> connectionHintValues) {// connectionHint.targetAttribute.~owningClass
		if (rootInstances.size() < 1)
			return;// if we don't do this here an ArrayOutOfBoundsException
					// might occur later' TODO

		if (targetSectionRegistry.getPaths(classToConnect).size() > 0) {
			// now search for target attributes

			LinkedHashMap<ConnectionHintTargetAttribute,LinkedList<EObjectTransformationHelper>> containerInstancesByTargetAttribute = new LinkedHashMap<ConnectionHintTargetAttribute,LinkedList<EObjectTransformationHelper>>();
			
			for(ConnectionHintTargetAttribute targetAttr : connectionHint.getTargetAttributes()){
				containerInstancesByTargetAttribute.put(targetAttr,targetSectionRegistry.getFlattenedPamtramClassInstances(
						targetAttr.getTargetAttribute().getOwningClass()
						));//owningClass
				
			}

			// find container Instance for each element

			LinkedHashMap<String, LinkedHashSet<EObjectTransformationHelper>> contInstsByHintVal = new LinkedHashMap<String, LinkedHashSet<EObjectTransformationHelper>>();
			LinkedHashMap<String, LinkedHashSet<EObjectTransformationHelper>> rootInstancesByHintVal = new LinkedHashMap<String, LinkedHashSet<EObjectTransformationHelper>>();
			LinkedList<Object> connectionHintValuesCopy;

			// again, we need to handle the special case, when there is only one
			// hintValue
			if (connectionHintValues.size() == 1) {
				connectionHintValuesCopy = new LinkedList<Object>();
				for (int i = 0; i < rootInstances.size(); i++) {
					connectionHintValuesCopy.add(connectionHintValues.getFirst());
				}
			} else {
				connectionHintValuesCopy = connectionHintValues;
			}

			for (Object hintVal : connectionHintValuesCopy) {
				String hintValAsString=null;
				if(connectionHint instanceof SimpleModelConnectionHint){
					hintValAsString=(String) hintVal;
				} else if(connectionHint instanceof ComplexModelConnectionHint) {
					hintValAsString="";
					@SuppressWarnings("unchecked")
					Map<ComplexModelConnectionHintSourceInterface,String> hVal=(Map<ComplexModelConnectionHintSourceInterface,String>) hintVal;
					for(ComplexModelConnectionHintSourceInterface srcElement : ((ComplexModelConnectionHint) connectionHint).getSourceElements()){
						if(hVal.containsKey(srcElement)){
								hintValAsString+=hVal.get(srcElement);
						} else {
							consoleStream.println("HintSourceValue not found " + srcElement.getName() + " in ComplexModelConnectionHint " 
									+ connectionHint.getName() + "." );
						}
					}
				}
				
				if (!contInstsByHintVal.containsKey(hintValAsString)) {
					contInstsByHintVal.put(hintValAsString, new LinkedHashSet<EObjectTransformationHelper>());
				}

				if (!rootInstancesByHintVal.containsKey(hintValAsString)) {
					rootInstancesByHintVal.put(hintValAsString,
							new LinkedHashSet<EObjectTransformationHelper>());
				}

				rootInstancesByHintVal.get(hintValAsString)
						.add(rootInstances.remove(0));// instances have same
														// order as hintValues

				for(ConnectionHintTargetAttribute conAttr : containerInstancesByTargetAttribute.keySet()){
					
					String modifiedHintVal =  AttributeValueRegistry.applyAttributeValueModifiers(hintValAsString,conAttr.getModifier());

					
					for (EObjectTransformationHelper contInst : containerInstancesByTargetAttribute.get(conAttr)) {// now find a
																	// fitting
																	// instance
						// get Attribute value
							// TODO check limited capacity
							// TODO check type of referenced object
						
						String targetValStr=contInst.getAttributeValue(((ActualAttribute) conAttr.getTargetAttribute()));
						
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
			LinkedHashMap<EObjectTransformationHelper, LinkedHashSet<EObjectTransformationHelper>> rootInstancesByContainer = new LinkedHashMap<EObjectTransformationHelper, LinkedHashSet<EObjectTransformationHelper>>();
			for (String hintVal : rootInstancesByHintVal.keySet()) {
				if (contInstsByHintVal.get(hintVal).size() == 1) {
					rootInstancesByContainer.put(contInstsByHintVal
							.get(hintVal).iterator().next(), rootInstancesByHintVal.get(hintVal));
				} else if (contInstsByHintVal.get(hintVal).size() > 1) {// let
																		// user
																		// decide
					LinkedHashMap<String, EObjectTransformationHelper> containerDescriptions = new LinkedHashMap<String, EObjectTransformationHelper>();
					for (EObjectTransformationHelper contInst : contInstsByHintVal.get(hintVal)) {
						containerDescriptions
								.put(contInst.toString(), contInst);
					}

					ItemSelectorDialogRunner dialog=new ItemSelectorDialogRunner("The ModelConnectionHint '"
									+ connectionHint.getName()
									+ "' points to a non-unique Attribute."
									+ "Please choose under which elements theese "
									+ rootInstancesByHintVal.get(hintVal)
											.size()
									+ " elements  should be inserted.\n\n"
									+ "Attribute value: " + hintVal,
									containerDescriptions.keySet(), "");
					Display.getDefault().syncExec(dialog);
					if(dialog.wasTransformationStopRequested()){
						transformationAborted=true;
						return;
					}
					rootInstancesByContainer.put(
							containerDescriptions.get(dialog.getSelection()),
							rootInstancesByHintVal.get(hintVal));

				} else {
					consoleStream.println("The ModelConnectionHint '"
							+ connectionHint.getName() + " of MappingHintGroup " + mappingGroupName 
							+ "(Mapping: " + mappingName + ") could not find an instance to connect the targetSections.\n" + contInstsByHintVal.keySet());
					addToTargetModelRoot(rootInstancesByHintVal.get(hintVal));
				}
			}

			if (rootInstancesByContainer.keySet().size() > 0) {// only go on if
																// any of the
																// instances
																// could be
																// matched
				for (EObjectTransformationHelper container : rootInstancesByContainer.keySet()) {
					boolean otherPathsNeeded = false;

					if (!standardPaths.containsKey(connectionHint)) {// we have
																		// te
																		// check
																		// this
																		// first,
																		// or
																		// otherwise
																		// we
																		// might
																		// risk
																		// a
																		// nullpointerexception
						otherPathsNeeded = true;
					} else {
						int capacity = standardPaths.get(connectionHint)
								.getCapacity(container.getEObject());
						if (!(capacity >= rootInstancesByContainer.get(
								container).size() || capacity == -1)) {
							standardPaths.remove(connectionHint);
							otherPathsNeeded = true;
						}
					}

					// sort possible paths by path capacity
					LinkedList<ModelConnectionPath> pathsToConsider = new LinkedList<ModelConnectionPath>();
					if (otherPathsNeeded) {
						pathsToConsider = findPathsWithMinimumCapacity(
								classToConnect, container.getEObject(),
								rootInstancesByContainer.get(container).size());

					} else {
						pathsToConsider = new LinkedList<ModelConnectionPath>();
						pathsToConsider.add(standardPaths.get(connectionHint));

					}

					ModelConnectionPath modelConnectionPath;
					if (pathsToConsider.size() == 1) {// only one path to choose
														// from
						modelConnectionPath = pathsToConsider.getFirst();
					} else if (pathsToConsider.size() > 0) {// user decides
						LinkedHashMap<String, ModelConnectionPath> pathNames = new LinkedHashMap<String, ModelConnectionPath>();
						ModelConnectionPath standardPath = pathsToConsider.getFirst();// get
																		// shortest
																		// path

						for (ModelConnectionPath p : pathsToConsider) {// prepare user
														// selections
							String name = p.toString();

							pathNames.put(name, p);
							if (p.size() < standardPath.size())
								standardPath = p;// save shortest path
						}
						int instSize=rootInstancesByContainer.get(container).size();
						ItemSelectorDialogRunner dialog=new ItemSelectorDialogRunner(instSize 
										+ " Instance" + (instSize > 1 ? "s" : "")  +" of the TargetSection '"
										+ section.getName()
										+ "', created by the mapping '"
										+ mappingName
										+ " (Group: "
										+ mappingGroupName
										+ ")"
										+ "', "+(instSize>1 ? "have" : "has a" )+" root element"+ (instSize>1 ? "s" : "")+ " of the type '"
										+ classToConnect.getName()
										+ "'. " + (instSize > 1 ? "Theese need" : "It needs") + " to be put at a sensible position in the target model. "										
										+ "Please choose one of the possible connections to other existing target model elements"
										+ " below. Your selection will be remembered for the ConnectionHint '"
										+ connectionHint.getName() + "'.",
										pathNames.keySet(), standardPath.toString());
						Display.getDefault().syncExec(dialog);
						if(dialog.wasTransformationStopRequested()){
							transformationAborted=true;
							return;
						}
						modelConnectionPath = pathNames.get(dialog.getSelection());
					} else {
						consoleStream.println("Could not find a path that leads to the container specified by the ModelConnectionHint of " 
								+ mappingName + "::" + mappingGroupName);
				addToTargetModelRoot(rootInstances);
						addToTargetModelRoot(rootInstancesByContainer.get(container));
						continue;
					}

					if (!standardPaths.containsKey(connectionHint)) {
						standardPaths.put(connectionHint, modelConnectionPath);
						consoleStream.println("Path found: " + section.getName() + "("
								+ mappingName + "::"+ mappingGroupName +"): " + modelConnectionPath.toString());
					}

					// now instantiate path(s))
					if(rootInstancesByContainer.get(container).contains(container)){//we will allow objects that reference themselves as container 
						addToTargetModelRoot(container);							//because this was explicitly specified by tho ModelConnectionHint
					}
					
					instantiateMissingPath(modelConnectionPath.getInvertedPathElementList(), container.getEObject(),
							new LinkedList<EObjectTransformationHelper>(rootInstancesByContainer.get(container)));

				}
			}
		} else {
			consoleStream
					.println("Could not find a path that leads to the modelConnectionTarget Class specified for '"
							+ mappingName + "' (" + mappingGroupName + ")");
			addToTargetModelRoot(rootInstances);
		}
	}
	
	
	/**
	 * List of instances to put at the root of the target model.
	 * @param i
	 */
	private void addToTargetModelRoot(Collection<EObjectTransformationHelper> i){
		for(EObjectTransformationHelper h : i){
			addToTargetModelRoot(h);
		}
	}
	
	/**
	 * If no model connection could be found, an object needs to be added to the root of the target model.
	 * @param helper
	 */
	private void addToTargetModelRoot(EObjectTransformationHelper helper){
		targetModel.getContents().add(helper.getEObject());
	}

	/**
	 * Try to link a List of instances ( and therefore entire sections of the target model)
	 * to other objects of the target model.
	 * <p>
	 * This method is used for connecting sections without model connection hints.
	 * <p>
	 * If hasContaienr is set true the rootInstances will be connected to one of the instances in 
	 * containerInstances.
	 * @param classToConnect
	 * @param rootInstances
	 * @param section
	 * @param mappingName
	 * @param mappingGroupName
	 * @param hasContainer
	 * @param containerInstances
	 */
	void linkToTargetModelNoConnectionHint(EClass classToConnect,
			List<EObjectTransformationHelper> rootInstances, TargetSectionClass section, String mappingName,
			String mappingGroupName, boolean hasContainer, Set<EClass> containerClasses  ,LinkedList<EObjectTransformationHelper> containerInstances){
		ModelConnectionPath modelConnectionPath;

		if (targetSectionRegistry.getPaths(classToConnect).size() > 0) {
			LinkedList<ModelConnectionPath> pathsToConsider = findPathsWithMinimumCapacity(
					classToConnect, null, rootInstances.size());//only go on with paths that could theoretically fit all of the elements

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
					
					for (ModelConnectionPath p : new LinkedList<ModelConnectionPath>(pathsToConsider)) {
						boolean found=false;
						for(EClass c : containerClasses){
							if(p.leadsToRootType(c)){
								found=true;
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
									pathsToConsider.getFirst().getRootType())
									.size() == 1;
				}

				if (onlyOnePath) {// only one path to choose from
					modelConnectionPath = pathsToConsider.getFirst();
					// select instance of path end to associate elements to
					EObjectTransformationHelper inst;
					if (hasContainer) {
						inst = containerInstances.getFirst();
					} else if(!rootInstances.contains(targetSectionRegistry.getTargetClassInstances(
								modelConnectionPath.getRootType()).getFirst())){
						inst = targetSectionRegistry.getTargetClassInstances(
								modelConnectionPath.getRootType()).getFirst();
					} else {
						consoleStream
						.println("Could not find a path that leads to the container specified for targetSection '"
								+ section.getName() + "'");
						addToTargetModelRoot(rootInstances);
						return;
					}

					consoleStream.println("Path found: " + section.getName() + "(" + mappingName 
							+ "::"+ mappingGroupName +"): " + modelConnectionPath.toString());
					instantiateMissingPath(modelConnectionPath.getInvertedPathElementList(), inst.getEObject(),
							rootInstances);

				} else if (pathsToConsider.size() > 0) {// user decides
					LinkedHashMap<String, ModelConnectionPath> pathNames = new LinkedHashMap<String, ModelConnectionPath>();
					LinkedHashMap<String, LinkedHashMap<String, EObjectTransformationHelper>> instancesByPath = new LinkedHashMap<String, LinkedHashMap<String, EObjectTransformationHelper>>();
					ModelConnectionPath standardPath = pathsToConsider.getFirst();// get
																	// shortest
																	// path
					for (ModelConnectionPath p : pathsToConsider) {// prepare user selections
						pathNames.put(p.toString(), p);
						LinkedHashMap<String, EObjectTransformationHelper> instances = new LinkedHashMap<String, EObjectTransformationHelper>();
						for (EObjectTransformationHelper inst : targetSectionRegistry.getTargetClassInstances(p
								.getRootType())) {
							if (!rootInstances.contains(inst) && (!hasContainer
									|| containerInstances.contains(inst))) {

								instances.put(inst.toString(), inst);
							}

						}
						
						if( instances.size() == 0) {
							consoleStream
							.println("Could not find a path that leads to the container specified for targetSection '"
									+ section.getName() + "'");
							addToTargetModelRoot(rootInstances);
							return;
						}
						instancesByPath.put(p.toString(), instances);
						if (p.size() < standardPath.size()) {
							standardPath = p;// save standard path
						}
					}

					LinkedList<String> namesAsList = new LinkedList<String>();
					namesAsList.addAll(pathNames.keySet());
					List<List<String>> instanceNames = new LinkedList<List<String>>();//TODO this was only needed in EOL, should probably easier in Java
					for (String k : namesAsList) {
						LinkedList<String> instNamesAsList = new LinkedList<String>();
						instNamesAsList.addAll(instancesByPath.get(k).keySet());

						instanceNames.add(instNamesAsList);
					}
					PathAndInstanceSelectorRunner dialog=new PathAndInstanceSelectorRunner(rootInstances.size()
									+ " Instance" + (rootInstances.size()>1 ? "s" : "")+ " of the TargetSection '"
									+ section.getName()
									+ "', created by the mapping '"
									+ mappingName
									+ " (Group: "
									+ mappingGroupName
									+ ")"
									+ "', "+(rootInstances.size()>1 ? "have" : "has a" )+" root element"+ (rootInstances.size()>1 ? "s" : "")+ " of the type '"
									+ classToConnect.getName()
									+ "'. " + (rootInstances.size() > 1 ? "Theese need" : "It needs") + " to be put at a sensible position in the target model. "
									+ "Please choose one of the possible connections to other existing target model elements"
									+ " below.", namesAsList, instanceNames);

					Display.getDefault().syncExec(dialog);					// TODO Maybe add option to not do anything
					if(dialog.wasTransformationStopRequested()){
						transformationAborted=true;
						return;
					}
					// now ask user
					modelConnectionPath = pathNames.get(dialog.getPath());
					// select instance of path end to associate elements to
					EObjectTransformationHelper inst = instancesByPath.get(
							dialog.getPath()).get(
							dialog.getInstance());
					consoleStream.println(section.getName() + "(" + mappingName
							+ "): " + modelConnectionPath.toString());
					instantiateMissingPath(modelConnectionPath.getInvertedPathElementList(), inst.getEObject(),
							rootInstances);

				} else {// no suitable container found
					consoleStream
							.println("Could not find a path that leads to the container specified for targetSection '"
									+ section.getName() + "'");
					addToTargetModelRoot(rootInstances);
				}

			} else {// TODO handle limited capacity
				addToTargetModelRoot(rootInstances);
			}

		} else {
			consoleStream.println("No suitable path found for target class: "
					+ classToConnect.getName());
			addToTargetModelRoot(rootInstances);
		}
	}

	// --TODO clean this up so we don't need to differentiate between middle and
	// end
	/**
	 * The actual method for linking Objects to another object.
	 * <p>
	 * Missing instances of objects along the path will be created.
	 * @param invertedPath
	 * @param refStartInstance
	 * @param instancesAtEnd
	 */
	private void instantiateMissingPath(
			LinkedList<EObject> invertedPath, EObject refStartInstance,
			List<EObjectTransformationHelper> instancesAtEnd) {
		invertedPath.remove(0);// EClass refStart=(EClass)
		EReference ref = (EReference) invertedPath.remove(0);
		Object targetInst = refStartInstance.eGet(ref);

		if (invertedPath.size() > 1) {
			if (ref.getUpperBound() == 1) {// only one target instance allowed,
											// check if it exists
				if (targetInst == null) {
					EClass classToCreate=(EClass) invertedPath.get(0);
					EObject inst =  classToCreate.getEPackage().getEFactoryInstance().create(classToCreate);

					targetSectionRegistry.addClassInstance(new EObjectTransformationHelper(inst,attrValRegistry));
					refStartInstance.eSet(ref, inst);
					
					targetInst=inst;
				}
				instantiateMissingPath(invertedPath, (EObject) targetInst,
						instancesAtEnd);

			} else if (ref.getUpperBound() < 0) {
				LinkedList<EObject> newTarget = new LinkedList<EObject>();// it
																			// is
																			// absolutely
																			// neccessary
																			// to
																			// copy
																			// targetInst,
																			// since
																			// targetInst
																			// will
																			// be
																			// cleared
																			// by
																			// eSet
																			// before
																			// new
																			// elements
																			// are
																			// added
				if (targetInst != null) {
					@SuppressWarnings("unchecked")
					EList<EObject> targetInstL=(EList<EObject>) targetInst;
					newTarget.addAll(targetInstL);
				}
				
				EClass classToCreate=(EClass) invertedPath.get(0);
				
				EObject instance = classToCreate.getEPackage().getEFactoryInstance().create(classToCreate);
				// instance.~description="Class '" + newSelf.first.name +
				// "' (created to link targetSection):"; TODO seee above
				newTarget.add(instance);
				targetSectionRegistry.addClassInstance(new EObjectTransformationHelper((EObject)newTarget.getLast(),attrValRegistry));
				refStartInstance.eSet(ref, newTarget);
				instantiateMissingPath(invertedPath, newTarget.getLast(),
						instancesAtEnd);

			} else {// cardinality less than infinity
				// TODO
				consoleStream.println("Owei, owei");
			}

		} else {// at End
			if (ref.getUpperBound() == 1) {
				if (targetInst != null)
					consoleStream.println("Big mistake"); // this shouldn't happen
				else {
					refStartInstance.eSet(ref, instancesAtEnd.get(0).getEObject());
				}
			} else if (ref.getUpperBound() < 0) {
				LinkedList<EObject> newTarget = new LinkedList<EObject>();// it is absolutely  neccessary  to  copy
																			// targetInst,  since  targetInst  will  be  cleared  
																			//by eSet before new elements are added
				if (targetInst != null) {
					@SuppressWarnings("unchecked")
					EList<EObject> targetInstL=(EList<EObject>) targetInst;
					newTarget.addAll(targetInstL);
				}
				for(EObjectTransformationHelper inst : instancesAtEnd){
					newTarget.add(inst.getEObject());
				}

				refStartInstance.eSet(ref, newTarget);

			} else {// cardinality less than infinity
					// TODO
				consoleStream.println("owei, owei");
			}
		}

	}

}
