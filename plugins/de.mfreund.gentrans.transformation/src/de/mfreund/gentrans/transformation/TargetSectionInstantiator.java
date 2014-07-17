package de.mfreund.gentrans.transformation;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.CalculatorMapping;
import pamtram.mapping.ClassMatcher;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.TargetSectionReference;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.InvalidCustomFunctionException;
import de.mfreund.gentrans.transformation.selectors.ItemSelectorDialogRunner;

public class TargetSectionInstantiator {
	private RoundFunction round;
	private TargetSectionRegistry targetSectionRegistry;
	private AttributeValueRegistry attributeValueRegistry;
	private MessageConsoleStream consoleStream;
	private boolean transformationAborted;
	
	public boolean isTransformationAborted() {
		return transformationAborted;
	}	

	public TargetSectionInstantiator(TargetSectionRegistry targetSectionRegistry , AttributeValueRegistry attributeValueRegistry, MessageConsoleStream consoleStream) {
		this.targetSectionRegistry=targetSectionRegistry;
		this.attributeValueRegistry=attributeValueRegistry;
		this.consoleStream=consoleStream;
		this.transformationAborted=false;
		
		try{
			round=new RoundFunction();
		}catch(InvalidCustomFunctionException e){
			consoleStream.println("This will never happen.");
		}
	}
	
	
	/*
	Iterates over targetMMSection to find AttributeMApping
	Will only look until next vc-reference
	Will always return Hint with largest number of values
	*/
	private static MappingHint searchAttributeMapping(TargetSectionClass metaModelSection, Collection<MappingHint> hints,  Map<MappingHint, LinkedList<Object>> hintValues, MappingHint  oldSelectedHint){
		MappingHint selectedHint=oldSelectedHint;
		for(TargetSectionAttribute attr :  metaModelSection.getAttributes()){//check attributes		
			for(MappingHint hint : hints){
				if(hint instanceof AttributeMapping){
					if(((AttributeMapping) hint).getTarget().equals(attr)){
	
						if(selectedHint == null || hintValues.get(hint).size() == 0){
							if(hintValues.get(hint).size() == 0){
								return null;//there needs to be at least one value for each attributeHint
							}else {
								selectedHint=hint;
							}
						}else if(hintValues.get(hint).size() > hintValues.get(selectedHint).size() ){
							selectedHint=hint;
						}
					}
				}
			}			 		
		}
		
			
		for(TargetSectionReference ref : metaModelSection.getReferences()){//check references
			for(TargetSectionClass val : ref.getValuesGeneric()){
				if(val.getCardinality().equals(CardinalityType.ONE)){
					MappingHint hint=searchAttributeMapping(val,hints, hintValues,selectedHint);
					if(hint == null && selectedHint != null){
						return null;
					} else {
						selectedHint=hint;
					}
				}
			}	
		}
		
		return selectedHint;
	}


	/*
		instantiate targetModelSection
	*/
	public LinkedHashMap<TargetSectionClass,LinkedList<EObjectTransformationHelper>> instantiateTargetSectionFirstPass(TargetSectionClass metamodelSection,
																					MappingHintGroup mappingGroup,
																					Map<MappingHint, LinkedList<Object>> hintValues,
																					Map<ModelConnectionHint, LinkedList<String>> conHintValues,																					
																					Mapping mapping){
		LinkedHashMap<TargetSectionClass,LinkedList<EObjectTransformationHelper>> instBySection=new LinkedHashMap<TargetSectionClass,LinkedList<EObjectTransformationHelper>> ();
		
		if( instantiateTargetSectionFirstPass(metamodelSection, mappingGroup, hintValues, conHintValues,
				instBySection,mapping) != null){
			return instBySection;
		} else return null;
			
		
		
	}
	
	
	/*
	instantiate targetModelSection
*/
@SuppressWarnings("unchecked")
private LinkedList<EObjectTransformationHelper> instantiateTargetSectionFirstPass(TargetSectionClass metamodelSection,
																				MappingHintGroup mappingGroup,
																				Map<MappingHint, LinkedList<Object>> hintValues,
																				Map<ModelConnectionHint, LinkedList<String>> conHintValues,
																				Map<TargetSectionClass,LinkedList<EObjectTransformationHelper>> instBySection,
																				Mapping mapping) {
	
		
		int cardinality= 1;
//		heck for variable cardinality
//		search for first matching mapping hint (since there should only be one
			

		if(!metamodelSection.getCardinality().equals(CardinalityType.ONE)){//ignore attribute hint and cardinality hint, if variableCardinality == false
			 
			 //check for attribute hint
			 boolean hintFound=false;
			 if(mappingGroup.getModelConnectionMatcher() != null){ 
			 	if(mappingGroup.getTargetMMSection().equals(metamodelSection)){
						hintFound=true;
						cardinality=conHintValues.get(mappingGroup.getModelConnectionMatcher()).size();	 	
			 	}
			 } 
			 
			 
				MappingHint hint=searchAttributeMapping(metamodelSection,mappingGroup.getMappingHints(), hintValues,null);
				if(hint != null){//there was an AttributeHint....
					int hintCardinality=hintValues.get(hint).size();
					if(hintCardinality > cardinality){
				 		cardinality=hintCardinality;				
					}
				 } else {
				 	if(! hintFound){
				 		cardinality=0;
				 		
				 	}
			 		for(MappingHint h : mappingGroup.getMappingHints()){
			 			if(h instanceof AttributeMapping){
			 				cardinality=0;
			 				break;
			 			}
			 		}
				}
		}

		if(cardinality > 0){	
			//instantiate self(s)
			LinkedList<EObjectTransformationHelper> instances= new LinkedList<EObjectTransformationHelper>();
			for(int i=0 ; i< cardinality; i++){
				EObject inst =  metamodelSection.getEClass().getEPackage().getEFactoryInstance().create(metamodelSection.getEClass());
				instances.add(new EObjectTransformationHelper(inst, attributeValueRegistry));

			}
			
			//create attributes
			LinkedList<EObjectTransformationHelper> markedForDelete = new LinkedList<EObjectTransformationHelper>();
			for(TargetSectionAttribute attr : metamodelSection.getAttributes()){		
					MappingHint hintFound=null;
					//look for an attribute mapping
					LinkedList<Object> attrHintValues=null;
					for(MappingHint hint : mappingGroup.getMappingHints()){
						if(hint instanceof AttributeMapping){
							if(((AttributeMapping) hint).getTarget().equals(attr)){
								hintFound=hint;
								if(hintValues.get(hint).size() == 1) {
									attrHintValues=new LinkedList<Object>();
									for(int i=0 ; i< cardinality; i++){										
										attrHintValues.add(hintValues.get(hint).getFirst());
									}
									break;
								} else if(hintValues.get(hint).size() >= cardinality){//hint value set?
									attrHintValues=hintValues.get(hint);
									break;
								} else{
									consoleStream.println("Cardinality mismatch (expected: "+ cardinality + ", got :" +  hintValues.get(hint).size() +"): " + hint.getName() + " for Mapping "+ mapping.getName() 
										+ " (Group: " + mappingGroup.getName() +") Maybe check Cardinality of Metamodel section?");
									return null;
								}
							}
						}
					}
					
					
					//set attribute values in instances
					for(EObjectTransformationHelper instance  : instances){
						String attrValue=null;
						if(attrHintValues != null) {
							if(hintFound instanceof CalculatorMapping){
								try{
									attrValue = String.valueOf(new ExpressionBuilder(((CalculatorMapping) hintFound).getExpression()).withCustomFunction(round)
											.withVariables((Map<String,Double>)attrHintValues.remove(0)).build().calculate());									
								} catch(Exception e){//TODO this will lead to a lot of error output if it fails
									consoleStream.println("Error parsing the expression of CalculatorMapping" + hintFound.getName() + ". Message:\n"
											+ e.getMessage());
								}								
							} else {
								attrValue=(String)attrHintValues.remove(0);
							}
						}
						//overwrite hint value with value of targetMMSection if present
						if(attr.getValueSpecification().size() > 0){
							if(attr.getValueSpecification().get(0).getValue() != null){//we assume that proper OCL constraints are i place (only one Specification, not a Subclass) 
								attrValue=attr.getValueSpecification().get(0).getValue();
							}
						}
						//Check if value is unique and was already used, delete instance if neccessary
						if(attr.isUnique() && instance.attributeValueExists(attr,attrValue)){					
							markedForDelete.add(instance);//we can only delete this at the end, or else the attributeHint values won't fit anymore

						}
						//Set value
						instance.setAttributeValue(attr,attrValue);

					}
			}
			

			//recursively create containment references
			for(TargetSectionReference ref : metamodelSection.getReferences()){
				if(ref instanceof TargetSectionContainmentReference){
					//now instantiate section
					for(EObjectTransformationHelper instance : instances){
						 LinkedList<EObjectTransformationHelper> childInstances = new LinkedList<EObjectTransformationHelper>();
						 for(TargetSectionClass val : ((TargetSectionContainmentReference) ref).getValue()){//instantiate targets
							 LinkedList<EObjectTransformationHelper> children = instantiateTargetSectionFirstPass(val,
									 											mappingGroup,
									 											hintValues,
									 											conHintValues,
									 											instBySection,
									 											mapping);
						 	if(children != null) { //error? //TODO also delete here?
						 		childInstances.addAll(children);
						 	} else{ 
								consoleStream.println("NoChildren");
						 		return null;
						 	}
						 }
						// we needed to create the targetSection
						// even though we already knew we didn't want it to be part of the targetModel or else we
						//would have gotten  problems with hintValues
						if (!markedForDelete.contains(instance)) {

							if (ref.getEReference().getUpperBound() == 1) {
								instance.getEObject().eSet(ref.getEReference(),
										childInstances.getFirst().getEObject());
							} else {
								LinkedList<EObject> childEObjects = new LinkedList<EObject>();
								for (EObjectTransformationHelper o : childInstances) {
									childEObjects.add(o.getEObject());
								}
								instance.getEObject().eSet(ref.getEReference(),
										childEObjects);
							}
						}
					} 
				}
			
			}	
			
			//Remove instances marked for delete
			instances.removeAll(markedForDelete);
			
			//All went well...
			for(EObjectTransformationHelper instance : instances){
				 //Add instance to map of targetMetaModel
				targetSectionRegistry.addClassInstance(instance,mappingGroup, metamodelSection);
			}
			if(instBySection.containsKey(metamodelSection)){
				instBySection.get(metamodelSection).addAll(instances);//TODO find out why this case is even possible
			} else {
				LinkedList<EObjectTransformationHelper> instClone=new LinkedList<EObjectTransformationHelper>();
				instClone.addAll(instances);
				instBySection.put(metamodelSection,  instClone);
			}
			return instances;
		} else if(!metamodelSection.getCardinality().equals(CardinalityType.ZERO_INFINITY)){// <> pamtram!CardinalityType#ZERO__INFINITY){
			consoleStream.println("TargetMMSection class '" + metamodelSection.getName() + 
			"' has a cardinality of at least 1 specified, but no suitable mappingHint was found.");		
			return null;		
		} else {
			//("empty " + self.name).errln;
			return new LinkedList<EObjectTransformationHelper>();//return empty Sequence or else this will fail
		}
}
	
	// add missing non-containment references to targetModelSections
	public  void instantiateTargetSectionSecondPass(
			TargetSectionClass targetMMSection,
			Mapping mapping,
			MappingHintGroup group,
			List<MappingHint> hints,
			LinkedHashMap<MappingHint, LinkedList<Object>> hintValues,
			LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>> instancesBySection) {

		if (instancesBySection.get(targetMMSection) != null) {// only go on if
																// any instances
																// of this
																// section were
																// created
			for (TargetSectionReference ref : targetMMSection.getReferences()) {
				if (ref instanceof TargetSectionNonContainmentReference) {
					LinkedList<TargetSectionClass> refValueClone = new LinkedList<TargetSectionClass>();
					refValueClone.addAll(((TargetSectionNonContainmentReference) ref).getValue());
					boolean hintFound = false;
					// search for mapping instance selector
					for (MappingHint h : hints) {
						if (h instanceof MappingInstanceSelector) {
							MappingInstanceSelector hSel = (MappingInstanceSelector) h;
							if (hSel.getAffectedReference().equals(ref)) {// hint
																			// for
																			// current
																			// ref
																			// found
								if (hSel.getMatcher() instanceof AttributeMatcher) {// handle
																					// hint
																					// according
																					// to
																					// matcher
									AttributeMatcher matcher = (AttributeMatcher) hSel
											.getMatcher();
									hintFound = true;
									// now search for target attributes
									LinkedList<EObjectTransformationHelper> targetInstances = targetSectionRegistry
											.getFlattenedPamtramClassInstances(matcher
													.getTargetAttribute()
													.getOwningClass());

									// instances are sorted in the same order as
									// hintValues
									LinkedList<EObjectTransformationHelper> instancesToConsider = new LinkedList<EObjectTransformationHelper>();
									instancesToConsider
											.addAll(instancesBySection
													.get(targetMMSection));
									/*
									 * Sizes of instances and attributeHints
									 * must either match, or, in case there was
									 * a cardinality mapping, the size of the
									 * hintValues must be 1
									 */
									LinkedList<Object> newHintValues = new LinkedList<Object>();
									if (hintValues.get(h).size() == 1) {
										String hintVal = (String) hintValues.get(h)
												.getFirst();
										for (int i = 0; i < instancesToConsider
												.size(); i++) {
											newHintValues.add(hintVal);
										}
									} else if (instancesToConsider.size() == hintValues
											.get(h).size()) {
										newHintValues = hintValues.get(h);
										// newHintValues.addAll(hintValues.get(h));
									} else {
										// TODO find a sensible way to throw
										// this error
										consoleStream.println("Tschaka "
												+ h.getName()
												+ instancesToConsider.size()
												+ " "
												+ hintValues.get(h).size() +"\n"+ hintValues.get(h)+ "\n" + instancesToConsider);
									}
									for (Object attrVal : newHintValues) {
										EObjectTransformationHelper srcInst = instancesToConsider
												.remove(0);
										LinkedHashMap<String, EObjectTransformationHelper> fittingVals = new LinkedHashMap<String, EObjectTransformationHelper>();// TODO
																												// select
																												// between
																												// fittingVals,
										for (EObjectTransformationHelper targetInst : targetInstances) {
											// get Attribute value
												// TODO check limited capacity
												// TODO check type of referenced
												// object
												String targetValStr=targetInst.getAttributeValue(matcher.getTargetAttribute());
												if (targetValStr != null) {
													if (targetValStr
															.equals(attrVal)) {
														// consoleStream.println("found "
														// + targetVal + " "
														// + attrVal);
														fittingVals.put(targetInst.toString(),targetInst);
	
													}
												} else {
													consoleStream.println("Problemo?");
												}
										}
										// select targetInst
										if (fittingVals.keySet().size() == 1) {
											setReference(ref,
													fittingVals.values()
															.iterator().next().getEObject(),
													srcInst.getEObject());
										} else if (fittingVals.keySet().size() > 1) {// let
																						// user
																						// decide
											// TODO
											
											  ItemSelectorDialogRunner dialog=new  ItemSelectorDialogRunner(
											  "The MappingInstanceSelector '" +
											  h.getName() +
											  "' has an AttributeMatcher that points to a non-unique Attribute. "
											  +
											  "Please choose to which element the Reference '"
											  + ref.getName() +
											  "' of the following element should point to:\n\n"
											 //TODO  + srcInst.~description ,
											 + srcInst.toString(),
											  fittingVals.keySet(),
											 fittingVals.keySet().iterator().next());
												Display.getDefault().syncExec(dialog);
											  if(dialog.wasTransformationStopRequested()){
												  this.transformationAborted=true;
												  return;
											  }
											  setReference(ref,fittingVals.get(dialog.getSelection()).getEObject(),srcInst.getEObject());
											 
											// throw "";--TODO
											//setReference(ref,fittingVals.values().iterator().next(),srcInst);
										} else {

											consoleStream
													.println("Nich gefunden: "
															+  attrVal);
										}
									}
									
								} else if (hSel.getMatcher() instanceof ClassMatcher) {
									hintFound=true;
									if (((ClassMatcher) hSel.getMatcher())
											.getTargetClass() != null) {// was
																		// the
																		// matcher
																		// modeled
																		// correctly?
										if (refValueClone.contains(((ClassMatcher) hSel.getMatcher()).getTargetClass())) {
											// select any of the targetInstances available for the reference target
											LinkedList<EObjectTransformationHelper> instancesToConsider = instancesBySection
													.get(targetMMSection);// this will be applied to
																			// all instances of this
																			// mapping TODO
				
											LinkedHashMap<String, TargetSectionClass> targetSectionsToConsider = new LinkedHashMap<String, TargetSectionClass>();
											LinkedHashMap<String, EObjectTransformationHelper> targetInstancesToConsider = new LinkedHashMap<String, EObjectTransformationHelper>();
											LinkedList<String> targetSectionChoices = new LinkedList<String>();
											LinkedList<LinkedList<String>> instanceChoices = new LinkedList<LinkedList<String>>();
				
											TargetSectionClass v =((ClassMatcher) hSel.getMatcher()).getTargetClass();
				
												LinkedList<EObjectTransformationHelper> insts = targetSectionRegistry.getFlattenedPamtramClassInstances(v);//select potential instances globally
				
												if (insts.size() > 0) {
													targetSectionsToConsider.put(v.toString(), v);
													targetSectionChoices.add(v.toString());
													LinkedList<String> choices = new LinkedList<String>();
													for (EObjectTransformationHelper i : insts) {
														targetInstancesToConsider.put(i.toString(),i);
														choices.add(i.toString());
													}
													instanceChoices.add(choices);
												}
				

				
												EObjectTransformationHelper targetInstance = null;
											if (targetInstancesToConsider.values().size() == 1) {
												targetInstance = targetInstancesToConsider.values()
														.iterator().next();
											} else if (targetInstancesToConsider.values().size() > 1) {
												// Dialog
												consoleStream.println("Dialog? " + ref.getName());
											} else {
												consoleStream
														.println("Schade schade " + ref.getName()); // TODO sinnvoller Fehlertext  wäre hierangebracht
											}
				
											if (targetInstance != null) {
												for (EObjectTransformationHelper inst : instancesToConsider) {// same action for every instance of specific mapping
													setReference(ref, targetInstance.getEObject(), inst.getEObject());
												}
											}
											// TODO
										}
									}
								} else {
									consoleStream.println("Matcher of type "
											+ hSel.getMatcher().eClass()
													.getName()
											+ " in MappingHint "
											+ hSel.getName()
											+ " is not supported.");
								}
								if (hintFound)
									break;
							}
						}
					}

					/*
					 * In case no suitable hint could be found we will try the following:
					 * 
					 * 1.only non-cont ref targets to other subsections of this targetMMSection are considered,
					 * 	 we can resolve the reference if only one Instance of the ref Target was created
					 * 	 in the same mapping instance
					 * 
					 * if that isn't the case:
					 * 
					 * 2. consider all available instances of the ref target 
					 */
					if (!hintFound) { // last chance
						LinkedHashSet<TargetSectionClass> foundSections=new LinkedHashSet<TargetSectionClass>();
						LinkedList<TargetSectionClass> refValue=new LinkedList<TargetSectionClass>();
						refValue.addAll(((TargetSectionNonContainmentReference) ref).getValue());
												
						//first check root targetMMSection itself
						if(refValue.contains(group.getTargetMMSection())){
							foundSections.add(group.getTargetMMSection());
							refValue.remove(group.getTargetMMSection());
						}
						
						//then check all its children
						TreeIterator<EObject> it=group.getTargetMMSection().eAllContents();
						while(it.hasNext() && refValue.size() > 0){
							EObject next=it.next();
							if(refValue.contains(next)){//at least one of the values the pamtram-reference points to,
															  //is part of the same MappingHintGroup's targetMMSection
								foundSections.add((TargetSectionClass)next);
								refValue.remove(next);
							}

							
						}
						if(foundSections.size() > 0){							
							//get source instances for the reference
							LinkedList<EObjectTransformationHelper> sourceInstances=new LinkedList<EObjectTransformationHelper>();
							sourceInstances.addAll(instancesBySection.get(targetMMSection));
							
							//get root instances of groups targetMMSection
							LinkedList<EObjectTransformationHelper> rootInstances=instancesBySection.get(group.getTargetMMSection());
							
							//get target instances for the reference
							LinkedList<EObjectTransformationHelper> targetInstances=new LinkedList<EObjectTransformationHelper>();
							for(TargetSectionClass section: foundSections){
								targetInstances.addAll(instancesBySection.get(section));
							}
							
							//now sort instances by root
							LinkedHashMap<EObjectTransformationHelper,EObjectTransformationHelper> rootBySourceInstance=new LinkedHashMap<EObjectTransformationHelper,EObjectTransformationHelper>();
							LinkedHashMap<EObjectTransformationHelper,LinkedList<EObjectTransformationHelper>> targetInstancesByRoot=new LinkedHashMap<EObjectTransformationHelper,LinkedList<EObjectTransformationHelper>>();
							
							for(EObjectTransformationHelper root : rootInstances){
								targetInstancesByRoot.put(root, new LinkedList<EObjectTransformationHelper>());
								
								//check if root node itself is a target
								for(EObjectTransformationHelper t : targetInstances){
									if(t.getEObject().equals(root.getEObject())){
										targetInstancesByRoot.get(root).add(root);
										targetInstances.remove(t);
										break;
									}
								}
								
								//check root node's contents
								TreeIterator<EObject> it1=root.getEObject().eAllContents();
								while(it1.hasNext() && !(sourceInstances.size() == 0 && targetInstances.size() == 0)){
									EObject next=it1.next();
									
									boolean found=false;
									
									for(EObjectTransformationHelper h : sourceInstances){
										if(h.getEObject().equals(next)){
											rootBySourceInstance.put(h, root);
											sourceInstances.remove(h);	
											found=true;
											break;
										}
									}
									
									if(!found){
										for(EObjectTransformationHelper t : targetInstances){
											if(t.getEObject().equals(next)){
												targetInstancesByRoot.get(root).add(t);
												targetInstances.remove(t);
												break;
											}
										}
										
									}
								}
							}							
							//now select targetInstance for each source instance
							for(EObjectTransformationHelper source : rootBySourceInstance.keySet()){
								int numRefTargets=targetInstancesByRoot.get(rootBySourceInstance.get(source)).size();
								if(numRefTargets == 1){
									setReference(ref, targetInstancesByRoot.get(rootBySourceInstance.get(source)).getFirst().getEObject(), source.getEObject());
								} else if(numRefTargets > 1){
									//TODO let user decide
									consoleStream.println("Userdecision " + ref.getName());
								} else {
									consoleStream.println("No suitable refernce target found for non-cont. reference '" + ref.getName()
											+ "' of the following instance of targetMMSection '" + targetMMSection.getName() + "'\n" + source.toString());//TODO description
								}
								
							}
						} else {
							LinkedHashMap<String, TargetSectionClass> targetSectionsToConsider = new LinkedHashMap<String, TargetSectionClass>();
							LinkedHashMap<String, EObjectTransformationHelper> targetInstancesToConsider = new LinkedHashMap<String, EObjectTransformationHelper>();
							LinkedList<String> targetSectionChoices = new LinkedList<String>();//TODO there seems to be some EOL legacy in here
							LinkedList<LinkedList<String>> instanceChoices = new LinkedList<LinkedList<String>>();

							for (TargetSectionClass v : refValueClone) {
								String classString=v.getName() + " (" + v.hashCode() + ")";
								LinkedList<EObjectTransformationHelper> insts = targetSectionRegistry.getFlattenedPamtramClassInstances(v);

								if (insts.size() > 0) {
									targetSectionsToConsider.put(classString, v);
									targetSectionChoices.add(classString);
									LinkedList<String> choices = new LinkedList<String>();
									for (EObjectTransformationHelper i : insts) {
										String description=i.toString();
										targetInstancesToConsider.put(description,i);
										choices.add(description);
									}
									instanceChoices.add(choices);
								}
							}
							
							
							EObjectTransformationHelper targetInstance = null;
							if (targetInstancesToConsider.values().size() == 1) {
								targetInstance = targetInstancesToConsider.values().iterator().next();
							} else if (targetInstancesToConsider.values().size() > 1) {
								//TODO Dialog
								consoleStream.println("Dialog? " + ref.getName());
							} else {
								consoleStream.println("No suitable hint targets found for non-cont reference '"
										+ ref.getName() + "' of TargetMMSection "
										+ group.getTargetMMSection().getName() + "(Section: "	+ targetMMSection.getName() 
										+ ") in Mapping " + mapping.getName() + "(Group: " + group.getName() +").");
							}
							
							if(targetInstance != null){
								for(EObjectTransformationHelper inst : instancesBySection.get(targetMMSection)){
									setReference(ref, targetInstance.getEObject(), inst.getEObject());
								}
							}
							

						}
						
					}
				}
			}
			instantiateTargetSectionSecondPassGoDeeper(targetMMSection,
					mapping, group, hints, hintValues, instancesBySection);			
		}
	}

	/**
	 * @param targetMMSection
	 * @param mapping
	 * @param hints
	 * @param hintValues
	 * @param instancesBySection
	 */
	private void instantiateTargetSectionSecondPassGoDeeper(
			TargetSectionClass targetMMSection,
			Mapping mapping,
			MappingHintGroup group,
			List<MappingHint> hints,
			LinkedHashMap<MappingHint, LinkedList<Object>> hintValues,
			LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>> instancesBySection) {
		for (TargetSectionReference ref : targetMMSection.getReferences()) {
			if (ref instanceof TargetSectionContainmentReference) {
				for (TargetSectionClass val : ((TargetSectionContainmentReference) ref).getValue()) {// instantiate targets
					instantiateTargetSectionSecondPass(val, mapping, group,hints,
							hintValues, instancesBySection);
					if(transformationAborted){
						return;
					}
				}
			}

		}
	}

	private void setReference(TargetSectionReference ref, EObject target,
			EObject source) {
		if (ref.getEReference().getUpperBound() == 1) {
			// self.~description.println;//TODO

			if (source.eIsSet(ref.getEReference())) {
				consoleStream.println("Non-Cont Ref. " + ref.getName()
						+ " already set:\n" + source.toString()); // TODO
																	// description
																	// for
																	// source
			} else {
				source.eSet(ref.getEReference(), target);
			}
		} else {
			@SuppressWarnings("unchecked")
			EList<EObject> oldRefs = (EList<EObject>) source.eGet(ref
					.getEReference());
			LinkedList<EObject> newRefs = new LinkedList<EObject>();
			if (oldRefs != null) {
				newRefs.addAll(oldRefs);
			}
			newRefs.add(target);
			source.eSet(ref.getEReference(), newRefs);

		}
	}

}
