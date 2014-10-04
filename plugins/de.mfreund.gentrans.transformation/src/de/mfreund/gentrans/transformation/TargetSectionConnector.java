package de.mfreund.gentrans.transformation;

import java.util.Collection;
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
import de.mfreund.gentrans.transformation.selectors.ItemSelectorDialogRunner;
import de.mfreund.gentrans.transformation.selectors.PathAndInstanceSelectorRunner;

/**
 * Class for linking the sections of the target model. 
 * @author Sascha Steffen
 * @version 0.8
 */
class TargetSectionConnector implements CancellationListener{
	/**
	 * Paths previously selected by the user.
	 */
	private  LinkedHashMap<ModelConnectionHint, ModelConnectionPath> standardPaths;

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
	 * used for modifying attribute values
	 */
	private AttributeValueModifierExecutor attributeValuemodifier;

	
	/**
	 * true when the transformation was aborted by the user
	 */
	private boolean transformationAborted;
	/**
	 * Maximum length for connection paths maxPathlength<0 == unbounded
	 */
	private int maxPathlength;
	/**
	 * Unlinkeable elements
	 */
	private Map<EClass,List<EObjectTransformationHelper>> unlinkeableElements;
	
	/**
	 * @return true when the transformation was aborted by the user
	 */
	@Override
	public boolean isCancelled() {
		return transformationAborted;
	}
	
	/**
	 * @param attrValRegistry Attribute value registry, needed when applying model connection hints
	 * @param targetSectionRegistry target section registry, used when finding instances to which sections can be connected 
	 * @param targetModel
	 * @param consoleStream Output stream for messages
	 */
	TargetSectionConnector(AttributeValueRegistry attrValRegistry, TargetSectionRegistry targetSectionRegistry, AttributeValueModifierExecutor attributeValuemodifier,
			XMIResource targetModel, int maxPathLength, MessageConsoleStream consoleStream){
		standardPaths = new LinkedHashMap<ModelConnectionHint, ModelConnectionPath>();
		this.targetSectionRegistry=targetSectionRegistry;
		this.targetModel=targetModel;
		this.consoleStream=consoleStream;
		this.transformationAborted=false;
		this.attributeValuemodifier=attributeValuemodifier;
		this.maxPathlength=maxPathLength;
		unlinkeableElements=new LinkedHashMap<EClass,List<EObjectTransformationHelper>>();
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
			LinkedList<Object> connectionHintValues, int maxPathLength) {// connectionHint.targetAttribute.~owningClass
		if (rootInstances.size() < 1)
			return;// if we don't do this here an ArrayOutOfBoundsException
					// might occur later' TODO

		//check for connections
		int size=0;
		for(ConnectionHintTargetAttribute attr : connectionHint.getTargetAttributes()){
			size+=targetSectionRegistry.getConnections(classToConnect, attr.getTargetAttribute().getOwningClass().getEClass(), maxPathlength).size();
		}
		
		if (size > 0) {
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
									+ connectionHint.getName() + "(Mapping: " + mappingName + ", Group: " + mappingGroupName + ")." );
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
					
					String modifiedHintVal =  attributeValuemodifier.applyAttributeValueModifiers(hintValAsString,conAttr.getModifier());

					
					for (EObjectTransformationHelper contInst : containerInstancesByTargetAttribute.get(conAttr)) {// now find a
																	// fitting
																	// instance
						// get Attribute value
							// TODO check limited capacity
							// TODO check type of referenced object
						
						String targetValStr=contInst.getAttributeValue(conAttr.getTargetAttribute());
						
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
					if(transformationAborted) return;
					ItemSelectorDialogRunner dialog=new ItemSelectorDialogRunner("The ModelConnectionHint '"
									+ connectionHint.getName() + " (Mapping :" +mappingName +", Group: " + mappingGroupName + ")" 
									+ "' points to a non-unique Attribute."
									+ " Please choose under which elements " 
									+ (rootInstancesByHintVal.get(hintVal).size()>1 ?
											"theese " + rootInstancesByHintVal.get(hintVal).size() + "elements" 
											:  "this " + rootInstancesByHintVal.get(hintVal).size() + "element" )
									+ " should be inserted.\n\n"
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

					if (!standardPaths.containsKey(connectionHint)) {
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
					LinkedHashSet<ModelConnectionPath> pathsToConsider = new LinkedHashSet<ModelConnectionPath>();
					if (otherPathsNeeded) {
						pathsToConsider = ModelConnectionPath.findPathsWithMinimumCapacity(targetSectionRegistry.getConnections(classToConnect, container.getEObject().eClass(), maxPathLength),
								container.getEObject(),
								rootInstancesByContainer.get(container).size());

					} else {
						pathsToConsider = new LinkedHashSet<ModelConnectionPath>();
						pathsToConsider.add(standardPaths.get(connectionHint));

					}

					ModelConnectionPath modelConnectionPath;
					if (pathsToConsider.size() == 1) {// only one path to choose
														// from
						modelConnectionPath = pathsToConsider.iterator().next();
					} else if (pathsToConsider.size() > 0) {// user decides
						LinkedHashMap<String, ModelConnectionPath> pathNames = new LinkedHashMap<String, ModelConnectionPath>();
						ModelConnectionPath standardPath = pathsToConsider.iterator().next();// get
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
						if(transformationAborted) return ;
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
					/*
					 * Try to instantiate Paths and add failed elements to target model root
					 */
					addToTargetModelRoot(modelConnectionPath.instantiate(container.getEObject(), rootInstancesByContainer.get(container)));

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
	void linkToTargetModelNoConnectionHint(
			List<EObjectTransformationHelper> rootInstances, TargetSectionClass section, String mappingName,
			String mappingGroupName, boolean hasContainer, Set<EClass> containerClasses  ,LinkedList<EObjectTransformationHelper> containerInstances){
		ModelConnectionPath modelConnectionPath;
		EClass classToConnect=section.getEClass();
		
		LinkedHashSet<ModelConnectionPath> pathsToConsider=new LinkedHashSet<ModelConnectionPath>();
		if(hasContainer){
			for(EClass c : containerClasses){
				pathsToConsider.addAll(targetSectionRegistry.getConnections(classToConnect, c, maxPathlength));
			}
		} else {
			pathsToConsider.addAll(targetSectionRegistry.getPaths(classToConnect,maxPathlength));
		}

		if (pathsToConsider.size() > 0) {
			pathsToConsider = ModelConnectionPath.findPathsWithMinimumCapacity(
					pathsToConsider, null, rootInstances.size());//only go on with paths that could theoretically fit all of the elements

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
									pathsToConsider.iterator().next().getRootType())
									.size() == 1;
				}

				if (onlyOnePath) {// only one path to choose from
					modelConnectionPath = pathsToConsider.iterator().next();
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
							
					/*
					 * Try to instantiate Paths and add failed elements to target model root
					 */
					addToTargetModelRoot(modelConnectionPath.instantiate(inst.getEObject(), rootInstances));		

				} else if (pathsToConsider.size() > 0) {// user decides
					LinkedHashMap<String, ModelConnectionPath> pathNames = new LinkedHashMap<String, ModelConnectionPath>();
					LinkedHashMap<String, LinkedHashMap<String, EObjectTransformationHelper>> instancesByPath = new LinkedHashMap<String, LinkedHashMap<String, EObjectTransformationHelper>>();
					ModelConnectionPath standardPath = pathsToConsider.iterator().next();// get  shortest  path
					for (ModelConnectionPath p : pathsToConsider) {// prepare user selections
						LinkedHashMap<String, EObjectTransformationHelper> instances = new LinkedHashMap<String, EObjectTransformationHelper>();
						for (EObjectTransformationHelper inst : targetSectionRegistry.getTargetClassInstances(p
								.getRootType())) {
							if (!rootInstances.contains(inst) && (!hasContainer
									|| containerInstances.contains(inst))) {

								instances.put(inst.toString(), inst);
							}

						}
						
						if( instances.size() > 0) {
							instancesByPath.put(p.toString(), instances);
							pathNames.put(p.toString(), p);
							if (p.size() < standardPath.size()) {
								standardPath = p;// save standard path
							}
						}

					}
					
					if( instancesByPath.keySet().size() == 0) {
						consoleStream
						.println("Could not find a path that leads to the container specified for targetSection '"
								+ section.getName() + "'");
						addToTargetModelRoot(rootInstances);
						return;
					}
					
					LinkedList<String> namesAsList = new LinkedList<String>();
					namesAsList.addAll(pathNames.keySet());
					List<List<String>> instanceNames = new LinkedList<List<String>>();//TODO this was only needed in EOL, should probably easier in Java
					for (String k : namesAsList) {
						LinkedList<String> instNamesAsList = new LinkedList<String>();
						instNamesAsList.addAll(instancesByPath.get(k).keySet());

						instanceNames.add(instNamesAsList);
					}
					if(transformationAborted) return;
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

					/*
					 * Try to instantiate Paths and add failed elements to target model root
					 */
					addToTargetModelRoot(modelConnectionPath.instantiate(inst.getEObject(), rootInstances));

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
			if(!unlinkeableElements.containsKey(classToConnect)){
				unlinkeableElements.put(classToConnect, new LinkedList<EObjectTransformationHelper>());
			}
			unlinkeableElements.get(classToConnect).addAll(rootInstances);
		}
	}
	
	/**
	 * TODO
	 */
	void findContainerForUnlinkeables(){

		if(unlinkeableElements.keySet().size()==1){
			if(unlinkeableElements.values().iterator().next().size()==1){//only one element could not be connected => we already have our container
				addToTargetModelRoot(unlinkeableElements.values().iterator().next().get(0));
				return;
			}
		} else if(unlinkeableElements.keySet().size()<1){
			return;//nothing left to do
		}
		
		/*
		 * Now that the "special" case was handled we need to handle all the other cases.
		 */
		
		Map<EClass,List<ModelConnectionPath>> paths=new LinkedHashMap<EClass,List<ModelConnectionPath>>();
		
		for(EClass c : unlinkeableElements.keySet()){
			if(transformationAborted) return;
			paths.put(c, new LinkedList<ModelConnectionPath>());
			paths.get(c).addAll(targetSectionRegistry.getModelContainerPaths(c, maxPathlength));
			
		}
				
		Set<EClass> common =ModelConnectionPath.getCommonClasses(this,paths);
		if(transformationAborted) return;
		
		if(common.size() < 1){
			for(EClass c : unlinkeableElements.keySet()){
				consoleStream.println("No suitable path found for target class: "
						+ c.getName());
				addToTargetModelRoot(unlinkeableElements.get(c));
			}
		} else{
			EClass containerClass;
			if(common.size()== 1){
				containerClass=common.iterator().next();
			} else {
				Map<String,EClass> possibleContainers=new LinkedHashMap<String, EClass>();
				
				for(EClass c : common){
					possibleContainers.put(c.getName(), c);
				}
				
				
				ItemSelectorDialogRunner dialog=new ItemSelectorDialogRunner( 
						 "There was more than one target model element that could not be connected to a container element. Therefore "
						+ "a container needs to be created. Please select a fitting container class:",
						possibleContainers.keySet(), possibleContainers.keySet().iterator().next());
				Display.getDefault().syncExec(dialog);
				if(dialog.wasTransformationStopRequested()){
					this.cancel();
					return;
				}
				containerClass=possibleContainers.get(dialog.getSelection());
			}
			
			EObject containerInstance=containerClass.getEPackage().getEFactoryInstance().create(containerClass);
			addToTargetModelRoot(new EObjectTransformationHelper(containerInstance, targetSectionRegistry.getAttrValRegistry()));
			for(EClass c : unlinkeableElements.keySet()){
				/*
				 * It gets a bit tricky here.
				 * If there is more than one common container, we have to choose one.
				 * Then we need to find all possible connections for each of the elements involved.
				 * Now we need to choose a connection for each element.
				 * This would lead to us asking a lot of questions to the user.
				 * Therefore we will concentrate on using the shortest connection paths.
				 * All we need to ask the user is which container to use.
				 */
				Set<ModelConnectionPath> pathSet=targetSectionRegistry.getConnections(c, containerClass, maxPathlength);
				if(pathSet.size()<1){
					addToTargetModelRoot(unlinkeableElements.get(c));//This should not have happened => programming error
					consoleStream.println("Error. Check container instantiation");
				} else {
					
					//get paths with fitting capacity
					int neededCapacity=unlinkeableElements.get(c).size();
					LinkedList<ModelConnectionPath> fittingPaths=new LinkedList<ModelConnectionPath>();
					for(ModelConnectionPath p : pathSet){
						if(p.getCapacity(containerInstance)>=neededCapacity){
							fittingPaths.add(p);
						}
					}
					
					if(fittingPaths.size() > 0){
						//get shortest path
						ModelConnectionPath chosenPath=fittingPaths.getFirst();
						int chosenPathSize=chosenPath.size();
						for(ModelConnectionPath p : fittingPaths){//get one of the shortest paths
							int pSize=p.size();
							if(pSize<chosenPathSize){
								chosenPath=p;
								chosenPathSize=pSize;
							}
						}
						
						//now instantiate path
						chosenPath.instantiate(containerInstance, unlinkeableElements.get(c));						
					} else {
						consoleStream.println("The chosen container cannot fit the elements of the type '"
								+c.getName()
								+"' ,sorry.");
						addToTargetModelRoot(unlinkeableElements.get(c));
					}

				}
			}
			

		}
	}

	@Override
	public void cancel() {
		this.transformationAborted=true;
		
	}

}
