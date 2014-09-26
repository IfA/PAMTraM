package de.mfreund.gentrans.transformation;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.SourceSectionModel;
import pamtram.mapping.AttributeMappingSourceElementType;
import pamtram.mapping.CalculatorMapping;
import pamtram.mapping.CalculatorMappingSourceInterface;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ComplexAttributeMapping;
import pamtram.mapping.ComplexAttributeMappingSourceElement;
import pamtram.mapping.ComplexAttributeMappingSourceInterface;
import pamtram.mapping.ComplexAttributeMatcher;
import pamtram.mapping.ComplexAttributeMatcherSourceElement;
import pamtram.mapping.ComplexAttributeMatcherSourceInterface;
import pamtram.mapping.ComplexMappingHintSourceInterface;
import pamtram.mapping.ComplexModelConnectionHint;
import pamtram.mapping.ComplexModelConnectionHintSourceElement;
import pamtram.mapping.ComplexModelConnectionHintSourceInterface;
import pamtram.mapping.ExpressionVariable;
import pamtram.mapping.ExternalAttributeMappingSourceElement;
import pamtram.mapping.ExternalMappedAttributeValueExpander;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.SimpleAttributeMapping;
import pamtram.mapping.SimpleAttributeMatcher;
import pamtram.mapping.SimpleModelConnectionHint;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.Class;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SourceSectionReference;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.mfreund.gentrans.transformation.selectors.ItemSelectorDialogRunner;

/**
 * Class to map source model Objects to source sections and find values for mapping hints.
 * @author Sascha Steffen
 * @version 0.8
 */
class SourceSectionMapper {
	
	/**
	 * Registry for source model objects already mapped
	 */
	private LinkedHashMap<SourceSectionClass, Set<EObject>> mappedSections;
	/**
	 * Registry for src model objects that were "not officially" mapped but 
	 * included through a container mapping
	 */
	private LinkedHashMap<SourceSectionClass, Set<EObject>> mappedContainers;

	/**
	 * Registry for ModelConnectionHints. Used When linking target model sections.
	 */
	private Map<Mapping, LinkedList<ModelConnectionHint>> modelConnectionHints;
	/**
	 * Registry for MappingHints. Used When instantiating target model sections.
	 */
	private Map<Mapping,LinkedList<MappingHintType>> mappingHints;
	/**
	 * Map Referencing the Classes referenced by the ComplexAttributeMappingSourceElement that are buried deepest in the source Section,
	 * sorted by ComplexAttributeMapping.
	 */
	private Map<ComplexAttributeMapping,Set<SourceSectionClass>> deepestComplexAttrMappingSrcElementsByCmplxMapping;
	
	/**
	 * We save any user selection for a particular set of possible Mappings so we don't have to ask twice
	 * for the same combination of Mappings.
	 */
	private Map<Set<Mapping>,Mapping> ambiguousMappingSelections;
	
	
	/**
	 * Map to determine at which point ComplexHints need to be joined
	 */
	private Map<Object,SourceSectionClass>   commonContainerClassOfComplexMappings;//TODO Name?
	/**
	 * Map Referencing the Classes referenced by the ExpressionVariable that is buried deepest in the source Section,
	 * sorted by CalculatorMapping.
	 */
	private Map<CalculatorMapping,Set<SourceSectionClass>> deepestCalcAttrMappingSrcElementsByCalcMapping;
	/**
	 * Map Referencing the Classes referenced by the ComplexAttributeMatcherSourceElement that are buried deepest in the source Section,
	 * sorted by ComplexAttributeMatcher.
	 */
	private Map<ComplexAttributeMatcher, Set<SourceSectionClass>> deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher;
	
	/**
	 * Map Referencing the Classes referenced by the ComplexModelConnectionHintSourceElement that are buried deepest in the source Section,
	 * sorted by ComplexAttributeMatcher.
	 */
	private Map<ComplexModelConnectionHint, Set<SourceSectionClass>> deepestComplexConnectionHintSrcElementsByComplexConnectionHint;
	/**
	 * Mappings from the PAMTram model
	 */
	private List<Mapping> mappingsToChooseFrom;
	/**
	 * Output stream for messages
	 */
	private MessageConsoleStream consoleStream;
	/**
	 * true when user action was triggered to abort the transformation
	 */
	private boolean transformationAborted;
	
	/**
	 * Registry for values of global Variables
	 * Only the newest value found is saved (GlobalVariables really only make sense for elements that appear only once)
	 */
	private Map<GlobalAttribute,String> globalVarValues;
	
	/**
	 * Getter for Registry for values of global Variables
	 * @return Registry for values of global Variables
	 */
	public Map<GlobalAttribute, String> getGlobalVarValues() {
		return globalVarValues;
	}
	
	/**
	 * Getter for Registry for mapped sections
	 * @return Registry for mapped sections
	 */
	public LinkedHashMap<SourceSectionClass, Set<EObject>> getMappedSections() {
		return mappedSections;
	}

	/**
	 * @return true when user action was triggered to abort the transformation
	 */
	public boolean isTransformationAborted() {
		return transformationAborted;
	}
	
	/**
	 * used for modifying attribute values
	 */
	private AttributeValueModifierExecutor attributeValuemodifier;
	
	/**
	 * Set that contains all ValueModifiers with errors so we don't need to send a potential error message twice
	 */
	private Set<AttributeValueConstraint> constraintsWithErrors;

	/**
	 * @param mappingsToChooseFrom Mappings from the PAMTram model
	 * @param consoleStream Output stream for messages
	 */
	SourceSectionMapper(List<Mapping> mappingsToChooseFrom, AttributeValueModifierExecutor attributeValuemodifier, MessageConsoleStream consoleStream) {
		mappedSections=new LinkedHashMap<SourceSectionClass,Set<EObject>> ();
		mappedContainers=new LinkedHashMap<SourceSectionClass,Set<EObject>> ();
		mappingHints=new  LinkedHashMap<Mapping,LinkedList<MappingHintType>>();
		modelConnectionHints=new  LinkedHashMap<Mapping,LinkedList<ModelConnectionHint>>();
		deepestComplexAttrMappingSrcElementsByCmplxMapping= new LinkedHashMap<ComplexAttributeMapping,Set<SourceSectionClass>>();
		deepestCalcAttrMappingSrcElementsByCalcMapping = new LinkedHashMap<CalculatorMapping,Set<SourceSectionClass>>();
		deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher= new LinkedHashMap<ComplexAttributeMatcher, Set<SourceSectionClass>>();
		deepestComplexConnectionHintSrcElementsByComplexConnectionHint= new LinkedHashMap<ComplexModelConnectionHint, Set<SourceSectionClass>>();
		globalVarValues=new HashMap<GlobalAttribute,String>();
		this.mappingsToChooseFrom=mappingsToChooseFrom;
		this.consoleStream=consoleStream;
		this.transformationAborted=false;
		this.attributeValuemodifier=attributeValuemodifier;
		constraintsWithErrors=new HashSet<AttributeValueConstraint>();
		commonContainerClassOfComplexMappings=new HashMap<Object,SourceSectionClass>();
		ambiguousMappingSelections=new HashMap<Set<Mapping>,Mapping>();
		
		//this will fill some maps...
		for(Mapping m : mappingsToChooseFrom){
			getModelConnectionHints(m);
			for(MappingHintType h : getHints(m)){
				if(h instanceof ComplexAttributeMapping){
					buildDeepestCmplxAttrMappingElementsMap((ComplexAttributeMapping) h, m.getSourceMMSection());
				} else if(h instanceof CalculatorMapping){
					buildCalcAttrMappingsMaps((CalculatorMapping) h, m.getSourceMMSection());
				} else if (h instanceof MappingInstanceSelector){
					if(((MappingInstanceSelector) h).getMatcher() instanceof ComplexAttributeMatcher){
						buildDeepestComplexAttrMatcherSrcElements((ComplexAttributeMatcher)((MappingInstanceSelector)h).getMatcher(), m.getSourceMMSection());
					}
				} 
			}
			
			for(ModelConnectionHint h : getModelConnectionHints(m)){
				if(h instanceof ComplexModelConnectionHint){
					buildDeepestCmplxConnectionHintElementsMap((ComplexModelConnectionHint) h, m.getSourceMMSection());
				}
			}
		}
	}
	
	/**
	 * @param m Mapping
	 * @return MappingHints of all the Mappings MappingHintGroups.
	 */
	private List<MappingHintType> getHints(Mapping m){
		if(!mappingHints.containsKey(m)){
			mappingHints.put(m, new LinkedList<MappingHintType>());
			for(MappingHintGroupType g : m.getMappingHintGroups()){
				if(g.getMappingHints() != null){
					mappingHints.get(m).addAll(g.getMappingHints());					
				}
			}
			
			for(MappingHintGroupImporter g : m.getImportedMappingHintGroups()){
				if(g.getMappingHints() != null){
					mappingHints.get(m).addAll(g.getMappingHints());
				}
			}
		}
		
		return mappingHints.get(m);
		
	}
	
	/**
	 * Extend the deepestComplexAttrMappingSrcElementsByCmplxMapping Map for the MappingHint
	 * @param m MApping
	 * @param srcSection
	 */
	private void buildDeepestCmplxAttrMappingElementsMap(ComplexAttributeMapping m, SourceSectionClass srcSection){
		if(!deepestComplexAttrMappingSrcElementsByCmplxMapping.containsKey(m)){
			Set<AttributeMappingSourceElementType> srcElements=new HashSet<AttributeMappingSourceElementType>();
			srcElements.addAll(m.getLocalSourceElements());
			deepestComplexAttrMappingSrcElementsByCmplxMapping.put(m,new HashSet<SourceSectionClass>());
			
			deepestComplexAttrMappingSrcElementsByCmplxMapping.get(m).addAll(findDeepestClassesAndCommonContainer(srcElements, srcSection,m));		
			
		}
	}
	
	/**
	 * Extend the deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher MappingHint
	 * @param m 
	 * @param srcSection
	 */
	private void buildDeepestComplexAttrMatcherSrcElements(ComplexAttributeMatcher m, SourceSectionClass srcSection){
		if(!deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher.containsKey(m)){
			Set<AttributeMappingSourceElementType> srcElements=new HashSet<AttributeMappingSourceElementType>();
			srcElements.addAll(m.getLocalSourceElements());
			deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher.put(m,new HashSet<SourceSectionClass>());
			
			MappingInstanceSelector s=(MappingInstanceSelector) m.eContainer();
			deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher.get(m).addAll(findDeepestClassesAndCommonContainer(srcElements, srcSection,s));				

		}		
	}
	
	/**
	 * Extend the deepestComplexConnectionHintSrcElementsByComplexConnectionHint ModelConnectionHint
	 * @param m 
	 * @param srcSection
	 */
	private void buildDeepestCmplxConnectionHintElementsMap(ComplexModelConnectionHint m, SourceSectionClass srcSection){
		if(!deepestComplexConnectionHintSrcElementsByComplexConnectionHint.containsKey(m)){
			Set<AttributeMappingSourceElementType> srcElements=new HashSet<AttributeMappingSourceElementType>();
			srcElements.addAll(m.getLocalSourceElements());
			deepestComplexConnectionHintSrcElementsByComplexConnectionHint.put(m,new HashSet<SourceSectionClass>());

			deepestComplexConnectionHintSrcElementsByComplexConnectionHint.get(m).addAll(findDeepestClassesAndCommonContainer(srcElements, srcSection,m));				

		}		
	}	
	
	/**
	 * Extend the deepestCalcAttrMappingSrcElementsByCalcMapping Map for the MappingHint
	 * @param m 
	 * @param srcSection
	 */
	private void buildCalcAttrMappingsMaps(CalculatorMapping m, SourceSectionClass srcSection){
		if(!deepestCalcAttrMappingSrcElementsByCalcMapping.containsKey(m)){
			Set<AttributeMappingSourceElementType> srcElements=new HashSet<AttributeMappingSourceElementType>();
			srcElements.addAll(m.getLocalSourceElements());
			deepestCalcAttrMappingSrcElementsByCalcMapping.put(m,new HashSet<SourceSectionClass>());

			deepestCalcAttrMappingSrcElementsByCalcMapping.get(m).addAll(findDeepestClassesAndCommonContainer(srcElements, srcSection,m));				
		}
	}
	

	/**
	 * Helper Method used when building  the deepestElements Maps
	 * @param s
	 * @param srcSection
	 * @param hint
	 * @return Classes that contain the deepest SourceSectionAttributes
	 */
	private Set<SourceSectionClass> findDeepestClassesAndCommonContainer(Set<AttributeMappingSourceElementType> s, 
			SourceSectionClass srcSection,
			Object hint){
		Set<SourceSectionClass> resultSet=new HashSet<SourceSectionClass>();
		
		/*
		 * fill resultSet with all *potential* candidates
		 */
		for(AttributeMappingSourceElementType t : s){
			resultSet.add(t.getSource().getOwningClass());
		}
		
		
		
		/*
		 * Find deeppest Elements
		 */
		Map<SourceSectionClass,Set<SourceSectionClass>> resultSets=new HashMap<SourceSectionClass,Set<SourceSectionClass>>();
		boolean commonContainerFound=false;
		/*
		 * init classesToCheck
		 */
		if(resultSet.size()==1){
			return resultSet;
		} else{
			if(resultSet.contains(srcSection)){
				resultSet.remove(srcSection);
				commonContainerClassOfComplexMappings.put(hint, srcSection);
				commonContainerFound=true;
			}
			resultSets.put(srcSection, new HashSet<SourceSectionClass>(resultSet));
		}
		
		/*
		 * Find deepest elements
		 */
		while(resultSets.size()>0){
			Map<SourceSectionClass,Set<SourceSectionClass>> nextResultSets=new HashMap<SourceSectionClass,Set<SourceSectionClass>>();
			for(SourceSectionClass cl : resultSets.keySet()){
				
				
				for(SourceSectionReference ref : cl.getReferences()){
					boolean breakLoop=false;
					for(SourceSectionClass childClass : ref.getValuesGeneric()){
						nextResultSets.put(childClass, new HashSet<SourceSectionClass>());

						/*
						 * get all child classes and add them to set
						 */
						Set<SourceSectionClass> childrenChecked=new HashSet<SourceSectionClass>();//to prevent endless loops
						List<SourceSectionClass> classesToCheck=new LinkedList<SourceSectionClass>();
						classesToCheck.add(childClass);
						while(classesToCheck.size()>0){
							SourceSectionClass chkClass=classesToCheck.remove(0);
							
							childrenChecked.add(chkClass);
							nextResultSets.get(childClass).add(chkClass);
							
							/*
							 * next checks
							 */
							for(SourceSectionReference chRef : chkClass.getReferences()){
								for(SourceSectionClass refVal : chRef.getValuesGeneric()){
									if(!childrenChecked.contains(refVal)){
										classesToCheck.add(refVal);
									}
								}
							}
						}
						
						/*
						 * is the resultSet still a subset of the childClasses set? 
						 */
						
						if(nextResultSets.get(childClass).containsAll(resultSets.get(cl))){
							breakLoop=true;
							nextResultSets.put(childClass, resultSets.get(cl));
							break;
						} else {
							if(!commonContainerFound){
								commonContainerClassOfComplexMappings.put(hint,cl);
								commonContainerFound=true;
							}
							nextResultSets.get(childClass).retainAll(resultSets.get(cl));//remove all non-result classes (intersection)
							if(nextResultSets.get(childClass).size()<1){
								resultSet.add(childClass);
								nextResultSets.remove(childClass);
							}
						}
					}
					if(breakLoop){
						break;
					}
				}
				
			}
			
			//next iteration
			resultSets=nextResultSets;
		}
		return resultSet;
		
	}	
	
	/**
	 * @param m
	 * @return ModelConnectionHints of all the Mappings MappingHintGroups.
	 */
	private List<ModelConnectionHint> getModelConnectionHints(Mapping m){
		if(!modelConnectionHints.containsKey(m)){
			modelConnectionHints.put(m, new LinkedList<ModelConnectionHint>());
			for(MappingHintGroupType g : m.getMappingHintGroups()){
				if(g instanceof MappingHintGroup){
					if(((MappingHintGroup) g).getModelConnectionMatcher() != null){
						modelConnectionHints.get(m).add(((MappingHintGroup) g).getModelConnectionMatcher());					
					}	
				}
			}
		}
		
		return modelConnectionHints.get(m);
		
	}	

	/**
	 * @param EObject
	 *            from srcModel
	 * @return list of the srcModels elements in hierarchical order
	 */
	static List<EObject> buildContainmentTree(EObject object) {

		List<EObject> list = new LinkedList<EObject>();
		return buildContainmentTree(object, list);
	}

	/**
	 * @param EObject
	 *            from srcModel
	 * @param list
	 *            to expand
	 * @return list of the srcModels elements in hierarchical order
	 */
	@SuppressWarnings("unchecked")
	private static List<EObject> buildContainmentTree(EObject object,
			List<EObject> list) {

		list.add(object);

		for (EReference feature : object.eClass().getEAllContainments()) {
			Object childElements = object.eGet(feature);
			if (childElements != null) {
				if (childElements instanceof Iterable) {
					for (EObject child : (Iterable<EObject>) childElements) {
						buildContainmentTree(child, list);
					}

				} else {
					buildContainmentTree((EObject) childElements, list);
				}
			}
		}

		return list;
	}

	/**
	 * Method for finding a suitable Mapping for a srcModelObject
	 * 
	 * @param srcModelObject
	 *            Element of the srcModel to be transformed
	 * @param usedOkay
	 *            specify whether elements already contained in newRefsAndHints can be mapped (needed for non-cont refs)
	 * @param hints
	 * @param connectionHints
	 * @param srcSection
	 * @param newRefsAndHints
	 * @param srcInstanceMap
	 */
	private  MappingInstanceStorage findMapping(
			EObject srcModelObject, boolean usedOkay,
			Iterable<MappingHintType> hints,
			Iterable<ModelConnectionHint> connectionHints,
			Iterable<GlobalAttribute> globalVars,
			SourceSectionClass srcSection,
			MappingInstanceStorage newRefsAndHints	
			) {

		boolean classFits= srcSection.getEClass().isSuperTypeOf(srcModelObject.eClass());
		
		// first of all: check if usedRefs contains this item and if type fits
		// (we do not check any of the used elements of other mappings, since
		// WILL be in a different section of the containment tree )
		if ((!usedOkay && newRefsAndHints.containsSourceModelObjectMapped(srcModelObject))
				||  !classFits) {
			return null;
		}
		// we will return this in Case we find the mapping to be applicable
		// else we return null
		MappingInstanceStorage changedRefsAndHints = new MappingInstanceStorage();
		changedRefsAndHints.setAssociatedSourceElement(srcSection, srcModelObject);

		// init hintValues --TODO this is absolutely neccessary as of now, maybe
		// find out why?-> naccessary f.i. in targetSectionMApper for determination of cardinality
		Map<ComplexAttributeMappingSourceElement,String> complexSourceElementHintValues=new LinkedHashMap<ComplexAttributeMappingSourceElement,String>();
		Map<ExpressionVariable,String> calcVariableHintValues=new LinkedHashMap<ExpressionVariable,String>();	
		Map<ComplexAttributeMatcherSourceElement,String> complexAttrMatcherSourceElementHintValues=new LinkedHashMap<ComplexAttributeMatcherSourceElement,String>();
		Map<ComplexModelConnectionHintSourceElement,String> complexConnectionHintSourceElementHintValues=new LinkedHashMap<ComplexModelConnectionHintSourceElement,String>();
		
		for (MappingHintType hint : hints) {
			changedRefsAndHints.setHintValueList(hint, new LinkedList<Object>());				
			if( hint instanceof ComplexAttributeMapping 
					|| hint instanceof CalculatorMapping){//ComplexAttributeMappings are handled differently because we want to make them work across vc-sections 
				if(newRefsAndHints.getHintValues().containsKey(hint)){
					changedRefsAndHints.getHintValues().get(hint).addAll(newRefsAndHints.getHintValues().get(hint));//the cardinality of 
																												    //the existing hintval is either 0 or 1 at this point
				} else if(hint instanceof ComplexAttributeMapping){
					changedRefsAndHints.getHintValues().get(hint).add(new LinkedHashMap<ComplexAttributeMappingSourceInterface,String>());
				} else {
					changedRefsAndHints.getHintValues().get(hint).add(new LinkedHashMap<String,Double>());
				}
			} else if (hint instanceof MappingInstanceSelector) {
				if(((MappingInstanceSelector) hint).getMatcher() instanceof ComplexAttributeMatcher){
					if(newRefsAndHints.getHintValues().containsKey(hint)){
						changedRefsAndHints.getHintValues().get(hint).addAll(newRefsAndHints.getHintValues().get(hint));//the cardinality of 
																													    //the existing hintval is either 0 or 1 at this point
					} else {
						changedRefsAndHints.getHintValues().get(hint).add(new LinkedHashMap<ComplexAttributeMatcherSourceInterface,String>());
					}					
				} 
			}

		}
		
		
		for (ModelConnectionHint hint : connectionHints) {
			changedRefsAndHints.setConnectionHintValueList(hint, new LinkedList<Object>());				
			if(hint instanceof ComplexModelConnectionHint){
				if(newRefsAndHints.getModelConnectionHintValues().containsKey(hint)){
					changedRefsAndHints.getModelConnectionHintValues().get(hint).addAll(newRefsAndHints.getModelConnectionHintValues().get(hint));
				} else {
					changedRefsAndHints.getModelConnectionHintValues().get(hint).add(new LinkedHashMap<ComplexModelConnectionHintSourceInterface,String>());
				}
			}
		}

		// set refs
		changedRefsAndHints.addSourceModelObjectsMapped(newRefsAndHints.getSourceModelObjectsMapped());

		// add self to new Refs
		changedRefsAndHints.addSourceModelObjectMapped(srcModelObject, srcSection);

		// check attributes
		for (SourceSectionAttribute at : srcSection.getAttributes()) {// look
																			// for
																			// attributes
																			// in
																			// srcSection
			
			// does it exist in src model?

			Object srcAttr = srcModelObject.eGet(at.getAttribute());
			if (srcAttr != null) {
				// convert Attribute value to String
				String srcAttrAsString = at
						.getAttribute()
						.getEType()
						.getEPackage()
						.getEFactoryInstance()
						.convertToString(at.getAttribute().getEAttributeType(),
								srcAttr);
				/* check AttributeValueSpecifications
				 * 
				 * Inclusions are OR connected
				 * 
				 * Exclusions are NOR connected
				 */
				boolean inclusionMatched=false;
				boolean containsInclusions=false;
				for (AttributeValueConstraint constraint : at.getValueConstraint()) {
					if(constraintsWithErrors.contains(constraint)) continue;
					
					boolean constraintVal;
					try{
						constraintVal=constraint.checkConstraint(srcAttrAsString);
					} catch(Exception e){
						constraintsWithErrors.add(constraint);
						consoleStream.println("The AttributeValueConstraint '" + constraint.getName() + "' of the "
								+ "Attribute '" + at.getName() + " (Class: " + at.getOwningClass().getName() 
								+ ", Section: " + at.getContainingSection().getName() + ")"
								+ "' could not be evaluated and will be ignored. The following error was supplied:\n"
								+ e.getLocalizedMessage());
						continue;
					}
					if (!constraintVal && constraint.getType().equals(AttributeValueConstraintType.EXCLUSION)) {
						return null;
					} else if(constraint.getType().equals(AttributeValueConstraintType.INCLUSION)){
						containsInclusions=true;
						if(constraintVal){
							inclusionMatched=true;
						}
					}
				}
				
				if(!inclusionMatched && containsInclusions){
					return null;
				}
				
				// handle possible attribute mappings
				for (MappingHintType hint : hints) {
					if (hint instanceof SimpleAttributeMapping) {
						if (((SimpleAttributeMapping) hint).getSource().equals(at)) {
							String valCopy = attributeValuemodifier.applyAttributeValueModifiers(srcAttrAsString,((SimpleAttributeMapping) hint).getModifier());
							changedRefsAndHints.addHintValue(hint, valCopy);
						}
					} else if(hint instanceof MappedAttributeValueExpander){
						if(((MappedAttributeValueExpander) hint).getSourceAttribute().equals(at)){
							String valCopy = attributeValuemodifier.applyAttributeValueModifiers(srcAttrAsString,((MappedAttributeValueExpander) hint).getModifiers());
							changedRefsAndHints.addHintValue(hint, valCopy);
						}
						
					}else if(hint instanceof ComplexAttributeMapping){
						for(ComplexAttributeMappingSourceElement m : ((ComplexAttributeMapping) hint).getLocalSourceElements()){
							if (m.getSource().equals(at)) {
								String valCopy = attributeValuemodifier.applyAttributeValueModifiers(srcAttrAsString,m.getModifier());
								complexSourceElementHintValues.put(m,valCopy);
							}
						}
					} else if(hint instanceof CalculatorMapping){
						for(ExpressionVariable v : ((CalculatorMapping) hint).getLocalSourceElements()){
							if(v.getSource().equals(at)){
								String valCopy = attributeValuemodifier.applyAttributeValueModifiers(srcAttrAsString, v.getModifier());
								calcVariableHintValues.put(v, valCopy);
								
							}
						}
					} else if (hint instanceof MappingInstanceSelector) {// handle
																			// MappingInstanceSelector
																			// with
																			// AttributeMatcher
						if (((MappingInstanceSelector) hint).getMatcher() instanceof SimpleAttributeMatcher) {
							// handle attribute modifiers
							SimpleAttributeMatcher matcher = (SimpleAttributeMatcher) ((MappingInstanceSelector) hint)
									.getMatcher();
							if (matcher.getSource().equals(at)) {
								String valCopy = srcAttrAsString;
								valCopy = attributeValuemodifier.applyAttributeValueModifiers(valCopy,
										matcher.getModifier());
								changedRefsAndHints.addHintValue(hint, valCopy);
							} 
						} else if(((MappingInstanceSelector) hint).getMatcher() instanceof ComplexAttributeMatcher){
							
							ComplexAttributeMatcher matcher= (ComplexAttributeMatcher) ((MappingInstanceSelector) hint).getMatcher();
							for(ComplexAttributeMatcherSourceElement e : matcher.getLocalSourceElements()){
								if(e.getSource().equals(at)){
									String valCopy = srcAttrAsString;
									valCopy = attributeValuemodifier.applyAttributeValueModifiers(valCopy, e.getModifier());
									complexAttrMatcherSourceElementHintValues.put(e, valCopy);								
								}
							}
						}
					}
				}

				// ModelConnectionHint (is being handled in the same way as
				// MI-Selector with AttrMatcher)
				for (ModelConnectionHint hint : connectionHints) {
					if(hint instanceof SimpleModelConnectionHint){
						if (((SimpleModelConnectionHint) hint).getSource().equals(at)) {
							String modifiedVal=attributeValuemodifier.applyAttributeValueModifiers(srcAttrAsString, ((SimpleModelConnectionHint) hint).getModifier());
							changedRefsAndHints.addModelConnectionHintValue(hint,modifiedVal);

						}						
					} else if(hint instanceof ComplexModelConnectionHint){
						for(ComplexModelConnectionHintSourceElement m : ((ComplexModelConnectionHint) hint).getLocalSourceElements()){
							if (m.getSource().equals(at)) {
								String modifiedVal=attributeValuemodifier.applyAttributeValueModifiers(srcAttrAsString, m.getModifier());
								complexConnectionHintSourceElementHintValues.put(m,modifiedVal);
							}
						}
					}
				}
				
				for(GlobalAttribute gVar : globalVars){
					if(gVar.getSource().equals(at)){
						String modifiedVal=attributeValuemodifier.applyAttributeValueModifiers(srcAttrAsString, gVar.getModifier());
						globalVarValues.put(gVar, modifiedVal);
					}
				}

			} else {// attribute not set / null
				//return null;
				//Not a problem unless any mappings point here or Constraints were modelled.
				//Unset mapping hint values are handled elsewhere.
				//Here we only need to check for matchers
				if(at.getValueConstraint().size() > 0){
					return null;
				}
			}
		}
		
		//now work on ComplexAttributeMappings and CalcMappings
		Set<ComplexAttributeMapping> complexAttributeMappingsFound=new HashSet<ComplexAttributeMapping>();
		Set<ComplexAttributeMatcher> complexAttributeMatchersFound=new HashSet<ComplexAttributeMatcher>();
		Set<CalculatorMapping> calculatorMappingsFound=new HashSet<CalculatorMapping>();		
		Set<ComplexModelConnectionHint> complexConnectionHintsFound=new HashSet<ComplexModelConnectionHint>();
		
		for(MappingHintType h : hints){
			if(h instanceof ComplexAttributeMapping){
				Map<ComplexAttributeMappingSourceInterface,String> foundValues=new LinkedHashMap<ComplexAttributeMappingSourceInterface,String>();
				//append the complex hint value (cardinality either 0 or 1) with found values in right order
				for(ComplexAttributeMappingSourceElement s : ((ComplexAttributeMapping) h).getLocalSourceElements()){
					if(complexSourceElementHintValues.containsKey(s)){
						foundValues.put(s,complexSourceElementHintValues.get(s));
					}
				}
				
				if(foundValues.keySet().size() > 0){
					complexAttributeMappingsFound.add((ComplexAttributeMapping)h);
					@SuppressWarnings("unchecked")
					Map<ComplexAttributeMappingSourceInterface,String>oldValues=(Map<ComplexAttributeMappingSourceInterface,String>) changedRefsAndHints.getHintValues().get(h).remove();
					foundValues.putAll(oldValues);					
					changedRefsAndHints.getHintValues().get(h).add(foundValues);
				}				
			} else if(h instanceof MappingInstanceSelector){
				if (((MappingInstanceSelector) h).getMatcher() instanceof ComplexAttributeMatcher) {
					ComplexAttributeMatcher m =(ComplexAttributeMatcher)((MappingInstanceSelector) h).getMatcher();
					Map<ComplexAttributeMatcherSourceInterface,String> foundValues=new LinkedHashMap<ComplexAttributeMatcherSourceInterface,String>();
					//append the complex hint value (cardinality either 0 or 1) with found values in right order
					for(ComplexAttributeMatcherSourceElement s : m.getLocalSourceElements()){
						if(complexAttrMatcherSourceElementHintValues.containsKey(s)){
							foundValues.put(s,complexAttrMatcherSourceElementHintValues.get(s));
						}
					}
					
					if(foundValues.keySet().size() > 0){
						complexAttributeMatchersFound.add(m);
						@SuppressWarnings("unchecked")
						Map<ComplexAttributeMatcherSourceInterface,String> oldValues=(Map<ComplexAttributeMatcherSourceInterface,String>) changedRefsAndHints.getHintValues().get(h).remove();
						foundValues.putAll(oldValues);					
						changedRefsAndHints.getHintValues().get(h).add(foundValues);
					}	
				}
			} else if(h instanceof CalculatorMapping){
				Map<String,Double> foundValues=new LinkedHashMap<String,Double>();//we need this as an extra, since found values might be empty strings
				//append the complex hint value (cardinality either 0 or 1) with found values in right order
				for(ExpressionVariable v : ((CalculatorMapping) h).getLocalSourceElements()){
					if(calcVariableHintValues.containsKey(v)){
						try{
							Calculable calc=new ExpressionBuilder(calcVariableHintValues.get(v)).build();
							double variableVal= calc.calculate();//parseDouble doesn't support Scientific notation, like: 0.42e2 == 4200e-2 == 42, 
							foundValues.put(v.getName(), new Double(variableVal));
						} catch(Exception e){
							consoleStream.println("Couldn't convert variable " 
									+ v.getName() + " of CalculatorMapping " + h.getName()
									+ " from String to double. The problematic source element's attribute value was: " 
									+ calcVariableHintValues.get(v));
						}
					}
				}
				
				if(foundValues.keySet().size() > 0){
					calculatorMappingsFound.add((CalculatorMapping)h);
					
					Map<String,Double> calcValues=new LinkedHashMap<String,Double>();
					@SuppressWarnings("unchecked")
					Map<String,Double> oldValues=(Map<String,Double>) changedRefsAndHints.getHintValues().get(h).remove();
					calcValues.putAll(oldValues);					
					calcValues.putAll(foundValues);
					changedRefsAndHints.getHintValues().get(h).add(calcValues);
				}				
			}
		}
		
		//handle ComplexModelConnectionHints in the same way as ComplexAttributeMappings
		for(ModelConnectionHint hint : connectionHints){
			if(hint instanceof ComplexModelConnectionHint){
				Map<ComplexModelConnectionHintSourceInterface,String> foundValues=new LinkedHashMap<ComplexModelConnectionHintSourceInterface,String>();
				//append the complex hint value (cardinality either 0 or 1) with found values in right order
				for(ComplexModelConnectionHintSourceElement s : ((ComplexModelConnectionHint) hint).getLocalSourceElements()){
					if(complexConnectionHintSourceElementHintValues.containsKey(s)){
						foundValues.put(s,complexConnectionHintSourceElementHintValues.get(s));
					}
				}
				
				if(foundValues.keySet().size() > 0){
					complexConnectionHintsFound.add((ComplexModelConnectionHint)hint);
					@SuppressWarnings("unchecked")
					Map<ComplexModelConnectionHintSourceInterface,String>oldValues=(Map<ComplexModelConnectionHintSourceInterface,String>) changedRefsAndHints.getModelConnectionHintValues().get(hint).remove();
					foundValues.putAll(oldValues);					
					changedRefsAndHints.getModelConnectionHintValues().get(hint).add(foundValues);
				}					
			}
		}
		
		/*
		 * Combine values of references of same type
		 */
		Map<EReference,List<SourceSectionClass>> classByRefMap=new LinkedHashMap<EReference,List<SourceSectionClass>>();
		Map<SourceSectionClass,SourceSectionReference> refByClassMap=new HashMap<SourceSectionClass,SourceSectionReference>();//TODO if this gets to slow, maybe add a map (refBySectionByClass) to this class
		
		Map<SourceSectionClass,Integer> mappingCounts=new HashMap<SourceSectionClass,Integer>();
		
		for(SourceSectionReference ref : srcSection.getReferences()){
			if(!classByRefMap.containsKey(ref.getEReference())){
				classByRefMap.put(ref.getEReference(), new LinkedList<SourceSectionClass>());
			}
			
			classByRefMap.get(ref.getEReference()).addAll(ref.getValuesGeneric());
			
			for(SourceSectionClass c : ref.getValuesGeneric()){
				refByClassMap.put(c, ref);
				mappingCounts.put(c, new Integer(0));
			}
		}

		// now go through all the srcMmSection refs
		for (EReference ref : classByRefMap.keySet()) {
			// reference.name.println;
			// check if reference is allowed by src metamodel
			// check if reference in srcMMSection points anywhere
			if (classByRefMap.get(ref).size() < 1)
				break;
			Object refTarget = srcModelObject.eGet(ref);// getrefTarget(s) in srcModel
			// behave, depending on cardinality
			/*
			 * There are cases in which modeling more than target values for a section than it can actually hold
			 * might make sense depending on how the target's CardinalityType value was set.
			 * Therefore we do not check the modeled references values at this point. 
			 */
			if (ref.getUpperBound() == 1) {
				EObject refTargetObj = (EObject) refTarget;
				if (refTargetObj == null)
					return null;
				MappingInstanceStorage res = null;
				boolean nonZeroCardSectionFound=false;

				for(SourceSectionClass c : classByRefMap.get(ref)){
					//check non-zero sections first (it doesn't make sense in this case to model ZERO_INFINITY sections, if there is one 
					//section with a minimum cardinality of 1, but it can be handled
					if(!c.getCardinality().equals(CardinalityType.ZERO_INFINITY)){
						if(nonZeroCardSectionFound){//modeling error
							consoleStream.println("Modeling error in source section: '" + srcSection.getContainer().getName() + "'"
									+", subsection: '" + srcSection.getName() + "'. The Reference '" + refByClassMap.get(c) + "'"
									+ " points to a metamodel reference, that can only hold one value but in the source section it references more than one Class with"
									+ "a CardinalityType that is not ZERO_INFINITY." );
							return null;
						}
						nonZeroCardSectionFound=true;
						 res = findMapping(
									refTargetObj,
									(refByClassMap.get(c) instanceof MetaModelSectionReference) || usedOkay
									, hints,
									connectionHints,globalVars ,c,
									changedRefsAndHints);
						 if(transformationAborted) return null;
					}
				}
				
				if(!nonZeroCardSectionFound){
					for(SourceSectionClass c : classByRefMap.get(ref)){
							 res = findMapping(
										refTargetObj,
										(refByClassMap.get(c) instanceof MetaModelSectionReference) || usedOkay
										, hints,
										connectionHints,globalVars ,c,
										changedRefsAndHints);
								 if(transformationAborted) return null;
						 if(res != null){
							 break;
						 }
					}					
				}

				if (res != null) {
					// success: combine refs and hints
					if (refByClassMap.get(res.getAssociatedSourceClass()) instanceof ContainmentReference) {
						changedRefsAndHints.add(res);
					} else {
						changedRefsAndHints.addHintValues(res.getHintValues());
						changedRefsAndHints.addModelConnectionHintValues(res.getModelConnectionHintValues());
						changedRefsAndHints.addUnSyncedHintValues(
								res.getUnSyncedComplexAttrMappings(),
								res.getUnSyncedCalcMappings(), 
								res.getUnSyncedComplexAttrMatchers(), 
								res.getUnSyncedComplexConnectionHints());
					}
					// check for a cardinality hint (it doesn't really make
					// sense to model this for a class connected to a reference
					// with cardinality == 1 but it can be tolerated )
					mappingCounts.put(res.getAssociatedSourceClass(),
							new Integer(mappingCounts.get(res.getAssociatedSourceClass()).intValue() +1));

				} else {
					return null;
				}

			} else {//unbounded or unspecified
				// cast refTarget to EList
				@SuppressWarnings("unchecked")
				LinkedList<EObject> refTargetL = new LinkedList<EObject>((EList<EObject>) refTarget);

				/*
				 * this is a little more complicated: now we need to find ONE
				 * possible way to map our referenceTargets to the source
				 * sections
				 * 
				 * To do this we need to find out first which MMSections are
				 * applicable to which srcModel sections.
				 * 
				 * Then we try to find a way to map one srcModelSection to each
				 * MMSection
				 */

				// Map to store possible srcModelSections to MMSections
				// (non-vc))
				SrcSectionMappingResultsMap possibleSrcModelElementsNoVC = new SrcSectionMappingResultsMap();
				for (SourceSectionClass val : classByRefMap.get(ref)) {
					if (val.getCardinality().equals(CardinalityType.ONE)) {
						possibleSrcModelElementsNoVC
								.put(val,
										new LinkedList<MappingInstanceStorage>());
					}
				}

				// Map to store possible srcModelSections to MMSections (vc))
				SrcSectionMappingResultsMap possibleSrcModelElementsVC = new SrcSectionMappingResultsMap();
				for (SourceSectionClass val : classByRefMap.get(ref)) {
					if (!val.getCardinality().equals(CardinalityType.ONE)) {
						possibleSrcModelElementsVC
								.put(val,
										new LinkedList<MappingInstanceStorage>());
					}
				}

				LinkedHashSet<EObject> elementsUsableForVC = new LinkedHashSet<EObject>();
				// find possible srcElements for mmsections
				for (EObject rt : refTargetL) {
					boolean foundMapping = false;
					for (SourceSectionClass val : classByRefMap.get(ref)) {
						MappingInstanceStorage res = findMapping(
								rt,
								(refByClassMap.get(val) instanceof MetaModelSectionReference) || usedOkay,
								hints, connectionHints, globalVars, val,
								changedRefsAndHints);
						 if(transformationAborted) return null;
						 
						if (res != null) {// mapping possible
							foundMapping = true;
							res.setAssociatedSourceElement(val,rt);
							if (!val.getCardinality().equals(
									CardinalityType.ONE)) {
								possibleSrcModelElementsVC.get(val).add(res);
								elementsUsableForVC.add(rt);

							} else {
								possibleSrcModelElementsNoVC.get(val).add(res);
							}
						}
					}
					if (!foundMapping) {
						return null; // we need to find a mapping for every
										// srcModelElement if the reference Type
										// was modeled in the srcMMSection
					}
				}
				
				LinkedList<EObject> allElementsMapped = new LinkedList<EObject>();

				while (possibleSrcModelElementsNoVC.keySet().size() > 0) {
					pamtram.metamodel.Class smallestKey = possibleSrcModelElementsNoVC
							.getKeyForValueWithSmallestCollectionSize();
					if (possibleSrcModelElementsNoVC.get(smallestKey).size() > 0) {
						MappingInstanceStorage srcSectionResult;
						// we need to filter a little more
						if (possibleSrcModelElementsNoVC.get(smallestKey)
								.size() > 1) {
							LinkedList<MappingInstanceStorage> possibleElements = new LinkedList<MappingInstanceStorage>();
							possibleElements
									.addAll(possibleSrcModelElementsNoVC
											.get(smallestKey));

							// filter elements that can be used for a vc-section
							LinkedList<MappingInstanceStorage> allVCIncompatible = new LinkedList<MappingInstanceStorage>();
							for (MappingInstanceStorage s : possibleElements) {
								if (!elementsUsableForVC.contains(s
										.getAssociatedSourceModelElement())) {
									allVCIncompatible.add(s);
								}
							}
							if (allVCIncompatible.size() >= 1) {
								possibleElements = allVCIncompatible;
							}

							srcSectionResult = getResultForLeastUsedSrcModelElement(possibleElements);

						} else {
							srcSectionResult = possibleSrcModelElementsNoVC
									.get(smallestKey).getFirst();
						}

						// remember mapping
						if (refByClassMap.get(srcSectionResult.getAssociatedSourceClass()) instanceof ContainmentReference) {
							changedRefsAndHints.add(srcSectionResult);

						} else {
							changedRefsAndHints.addHintValues(srcSectionResult
									.getHintValues());
							changedRefsAndHints.addModelConnectionHintValues(srcSectionResult.getModelConnectionHintValues());
							changedRefsAndHints.addUnSyncedHintValues(
									srcSectionResult.getUnSyncedComplexAttrMappings(),
									srcSectionResult.getUnSyncedCalcMappings(), 
									srcSectionResult.getUnSyncedComplexAttrMatchers(), 
									srcSectionResult.getUnSyncedComplexConnectionHints());
							
						}
						allElementsMapped.add(srcSectionResult
								.getAssociatedSourceModelElement());
						// remove srcModel element from possibility lists of
						// MMSections
						possibleSrcModelElementsNoVC
								.removeResultsForElement(srcSectionResult);
						possibleSrcModelElementsVC
								.removeResultsForElement(srcSectionResult);
						possibleSrcModelElementsNoVC.remove(smallestKey);// remove successfully mapped
																			// mmSection  from  list
						
						//update cardinality
						mappingCounts.put(srcSectionResult.getAssociatedSourceClass(),
								new Integer(mappingCounts.get(srcSectionResult.getAssociatedSourceClass()).intValue() +1));
					} else {
						// consoleStream.println("no-vc mapping failed");
						return null;// all non-vc-elements need to be mapped
									// exactly once
					}
				}

				// try to map all vc-elements
				LinkedHashSet<pamtram.metamodel.Class> usedKeys = new LinkedHashSet<pamtram.metamodel.Class>(); // for
																														// counting
																														// cardinality

				while (possibleSrcModelElementsVC.keySet().size() != 0) {

					Class smallestKey = possibleSrcModelElementsVC
							.getKeyForValueWithSmallestCollectionSize();
					if (possibleSrcModelElementsVC.get(smallestKey).size() > 0) {

						usedKeys.add(smallestKey);
						MappingInstanceStorage srcSectionResult;
						// we need to filter a little more
						if (possibleSrcModelElementsVC.get(smallestKey).size() > 1) {

							srcSectionResult = getResultForLeastUsedSrcModelElement(possibleSrcModelElementsVC
									.get(smallestKey));

						} else {
							srcSectionResult = possibleSrcModelElementsVC.get(
									smallestKey).getFirst();
						}
						// remember mapping
						if (refByClassMap.get(srcSectionResult.getAssociatedSourceClass()) instanceof ContainmentReference) {
							changedRefsAndHints.add(srcSectionResult);

						} else {

							changedRefsAndHints.addHintValues(srcSectionResult
									.getHintValues());
							changedRefsAndHints.addModelConnectionHintValues(srcSectionResult.getModelConnectionHintValues());
							changedRefsAndHints.addUnSyncedHintValues(
									srcSectionResult.getUnSyncedComplexAttrMappings(),
									srcSectionResult.getUnSyncedCalcMappings(), 
									srcSectionResult.getUnSyncedComplexAttrMatchers(), 
									srcSectionResult.getUnSyncedComplexConnectionHints());
							
						}
						allElementsMapped.add(srcSectionResult
								.getAssociatedSourceModelElement());

						// remove srcModel element from possibility lists of
						// MMSections
						possibleSrcModelElementsVC
								.removeResultsForElement(srcSectionResult);
						
						//update cardinality
						mappingCounts.put(srcSectionResult.getAssociatedSourceClass(),
								new Integer(mappingCounts.get(srcSectionResult.getAssociatedSourceClass()).intValue() +1));
					
						
						
					} else if (usedKeys.contains(smallestKey)
							|| smallestKey.getCardinality().equals(
									CardinalityType.ZERO_INFINITY)) {
						possibleSrcModelElementsVC.remove(smallestKey);// remove  mmSection  from  list
					} else {
						// consoleStream.println("vc mapping failed");
						return null; // the fact that samllestKey is not in the
										// collection means that no mapping was
										// found at all
					}
				}

				// check if all refTargets where mapped
				refTargetL.removeAll(allElementsMapped);
				if (refTargetL.size() > 0) {
					consoleStream.println("Not everything could be mapped");
					return null;
				}
			}
		}
		
		/*
		 * Handle cardinality Hints
		 */
		for(MappingHintType h : hints){
			if(h instanceof CardinalityMapping){
				if(mappingCounts.keySet().contains(((CardinalityMapping) h).getSource())){
					changedRefsAndHints.addHintValue(h, mappingCounts.get(((CardinalityMapping) h).getSource()));
				}
			}
		}
		
		/*
		 * sync complex hints
		 */
		syncComplexAttrMappings(srcSection, changedRefsAndHints);
		syncCalcMappings(srcSection, changedRefsAndHints);
		syncComplexAttrMatchers(srcSection, changedRefsAndHints);
		syncModelConnectionHints(srcSection, changedRefsAndHints);
		
		
		/*
		 * if we are at one of the deepest SourceElements of a complex Mapping, we create a new unsynced list, and remove it
		 * from the changedRefsAndHints List until we sync it again (see above)
		 */
		for(MappingHintType h : hints){
				if(h instanceof ComplexAttributeMapping){
					if(!(complexAttributeMappingsFound.contains(h) && 
							deepestComplexAttrMappingSrcElementsByCmplxMapping.get(h).contains(srcSection))){
						changedRefsAndHints.getHintValues().get(h).remove();//remove incomplete hint value	
					} else if(deepestComplexAttrMappingSrcElementsByCmplxMapping.get(h).size()>1){
						if(!changedRefsAndHints.getUnSyncedComplexAttrMappings().containsKey(h)){
							changedRefsAndHints.getUnSyncedComplexAttrMappings().put(h,new  HashMap<SourceSectionClass,LinkedList<Map<ComplexAttributeMappingSourceElement,String>>>());							
						}
						changedRefsAndHints.getUnSyncedComplexAttrMappings().get(h).put(srcSection,new LinkedList<Map<ComplexAttributeMappingSourceElement,String>>());
						@SuppressWarnings("unchecked")
						Map<ComplexAttributeMappingSourceElement, String> val=(Map<ComplexAttributeMappingSourceElement, String>) changedRefsAndHints.getHintValues().get(h).remove();
						changedRefsAndHints.getUnSyncedComplexAttrMappings().get(h).get(srcSection).add(val);
					}
				} else if(h instanceof MappingInstanceSelector){
					if(((MappingInstanceSelector) h).getMatcher()  instanceof ComplexAttributeMatcher){
						if(!(complexAttributeMatchersFound.contains(((MappingInstanceSelector) h).getMatcher()) 
								&& deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher
									.get(((MappingInstanceSelector) h).getMatcher()).contains(srcSection)
						)){
							changedRefsAndHints.getHintValues().get(h).remove();//remove incomplete hint value	
						} else if(deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher
								.get(((MappingInstanceSelector) h).getMatcher()).size()>1){
							if(!changedRefsAndHints.getUnSyncedComplexAttrMatchers().containsKey(h)){
								changedRefsAndHints.getUnSyncedComplexAttrMatchers().put(h,new  HashMap<SourceSectionClass,LinkedList<Map<ComplexAttributeMatcherSourceElement,String>>>());							
							}
							changedRefsAndHints.getUnSyncedComplexAttrMatchers().get(h).put(srcSection,new LinkedList<Map<ComplexAttributeMatcherSourceElement,String>>());
							@SuppressWarnings("unchecked")
							Map<ComplexAttributeMatcherSourceElement, String> val=(Map<ComplexAttributeMatcherSourceElement, String>) changedRefsAndHints.getHintValues().get(h).remove();
							changedRefsAndHints.getUnSyncedComplexAttrMatchers().get(h).get(srcSection).add(val);
						}
					}
				} else if (h instanceof CalculatorMapping){
					if(!(calculatorMappingsFound.contains(h) &&  deepestCalcAttrMappingSrcElementsByCalcMapping.get(h).contains(srcSection))){
						changedRefsAndHints.getHintValues().get(h).remove();//remove incomplete hint value						
					} else if(deepestCalcAttrMappingSrcElementsByCalcMapping.get(h).size()>1){
						if(!changedRefsAndHints.getUnSyncedCalcMappings().containsKey(h)){
							changedRefsAndHints.getUnSyncedCalcMappings().put(h,new  HashMap<SourceSectionClass,LinkedList<Map<ExpressionVariable,String>>>());							
						}
						changedRefsAndHints.getUnSyncedCalcMappings().get(h).put(srcSection,new LinkedList<Map<ExpressionVariable,String>>());
						@SuppressWarnings("unchecked")
						Map<ExpressionVariable, String> val=(Map<ExpressionVariable, String>) changedRefsAndHints.getHintValues().get(h).remove();
						changedRefsAndHints.getUnSyncedCalcMappings().get(h).get(srcSection).add(val);
					}
				}				
		}
		
		for(ModelConnectionHint h :  connectionHints){
			if(h instanceof ComplexModelConnectionHint){
				if(!(complexConnectionHintsFound.contains(h) &&
						deepestComplexConnectionHintSrcElementsByComplexConnectionHint.get(h).contains(srcSection))){
					changedRefsAndHints.getModelConnectionHintValues().get(h).remove();//remove incomplete hint value
				} else if(deepestComplexConnectionHintSrcElementsByComplexConnectionHint.get(h).size() > 1){
					if(!changedRefsAndHints.getUnSyncedComplexConnectionHints().containsKey(h)){
						changedRefsAndHints.getUnSyncedComplexConnectionHints().put((ComplexModelConnectionHint) h,new  HashMap<SourceSectionClass,LinkedList<Map<ComplexModelConnectionHintSourceElement,String>>>());							
					}
					changedRefsAndHints.getUnSyncedComplexConnectionHints().get(h).put(srcSection,new LinkedList<Map<ComplexModelConnectionHintSourceElement,String>>());
					@SuppressWarnings("unchecked")
					Map<ComplexModelConnectionHintSourceElement, String> val=(Map<ComplexModelConnectionHintSourceElement, String>) changedRefsAndHints.getModelConnectionHintValues().get(h).remove();
					changedRefsAndHints.getUnSyncedComplexConnectionHints().get(h).get(srcSection).add(val);
				}
			}
		}
		
		return changedRefsAndHints;

	}

	/**
	 * @param srcSection
	 * @param changedRefsAndHints
	 */
	private void syncComplexAttrMappings(SourceSectionClass srcSection,
			MappingInstanceStorage changedRefsAndHints) {
		for(MappingHintType h : changedRefsAndHints.getUnSyncedComplexAttrMappings().keySet()){
			boolean isCommonParent=commonContainerClassOfComplexMappings.get(h).equals(srcSection);
			
			if(changedRefsAndHints.getUnSyncedComplexAttrMappings().containsKey(h)){
				if(changedRefsAndHints.getUnSyncedComplexAttrMappings().get(h).size()>1 || isCommonParent){
					Map<SourceSectionClass, LinkedList<Map<ComplexAttributeMappingSourceElement, String>>> m=
							changedRefsAndHints.getUnSyncedComplexAttrMappings().get(h);
					//list of "synced" hints
					LinkedList<Map<ComplexAttributeMappingSourceElement,String>> syncedComplexMappings=null;
					//find longest list (ideally they are either of the same length, or there is only one value)
					SourceSectionClass cl=null;
					for(SourceSectionClass c :  m.keySet()){
						if(syncedComplexMappings == null){
							syncedComplexMappings=m.get(c);
							cl=c;
						} else if(m.get(c).size() > syncedComplexMappings.size()){
							syncedComplexMappings=m.get(c);
							cl=c;
						}
					}
					//remove selected List from m
					m.remove(cl);
					
					//combine values
					for(SourceSectionClass c :  m.keySet()){
							LinkedList<Map<ComplexAttributeMappingSourceElement,String>> vals=m.get(c);
								if(vals.size() == 1){
									for(Map<ComplexAttributeMappingSourceElement,String> valMap : syncedComplexMappings){
										valMap.putAll(vals.getFirst());
									}
								} else if(vals.size() > 1){
									for(int i=0; i<vals.size(); i++){//remember: the size of vals will be lower or equel the size of syncedComplexAttrMappings
										syncedComplexMappings.get(i).putAll(vals.get(i));
									}
								}	
					}
					m.clear();
					
					if(isCommonParent){//sync
						//add to changedRefsAndHints
						//TODO if(syncedComplexMappings != null){
							changedRefsAndHints.getHintValues()
							.get(h)
							.addAll(syncedComplexMappings);
						//}
					} else {
						changedRefsAndHints.getUnSyncedComplexAttrMappings().get(h).clear();//remove old hints
						changedRefsAndHints.getUnSyncedComplexAttrMappings().get(h).put(srcSection, syncedComplexMappings);//add new hints
					}
				}
			}
		}
	}
	
	/**
	 * @param srcSection
	 * @param changedRefsAndHints
	 */
	private void syncComplexAttrMatchers(SourceSectionClass srcSection,
			MappingInstanceStorage changedRefsAndHints) {
		for(MappingHintType h : changedRefsAndHints.getUnSyncedComplexAttrMatchers().keySet()){
			boolean isCommonParent=commonContainerClassOfComplexMappings.get(h).equals(srcSection);
			
			if(changedRefsAndHints.getUnSyncedComplexAttrMatchers().containsKey(h)){
				if(changedRefsAndHints.getUnSyncedComplexAttrMatchers().get(h).size()>1 || isCommonParent){
					Map<SourceSectionClass, LinkedList<Map<ComplexAttributeMatcherSourceElement, String>>> m=
							changedRefsAndHints.getUnSyncedComplexAttrMatchers().get(h);
					//list of "synced" hints
					LinkedList<Map<ComplexAttributeMatcherSourceElement,String>> syncedComplexMappings=null;
					//find longest list (ideally they are either of the same length, or there is only one value)
					SourceSectionClass cl=null;
					for(SourceSectionClass c :  m.keySet()){
						if(syncedComplexMappings == null){
							syncedComplexMappings=m.get(c);
							cl=c;
						} else if(m.get(c).size() > syncedComplexMappings.size()){
							syncedComplexMappings=m.get(c);
							cl=c;
						}
					}
					//remove selected List from m
					m.remove(cl);
					
					//combine values
					for(SourceSectionClass c :  m.keySet()){
							LinkedList<Map<ComplexAttributeMatcherSourceElement,String>> vals=m.get(c);
								if(vals.size() == 1){
									for(Map<ComplexAttributeMatcherSourceElement,String> valMap : syncedComplexMappings){
										valMap.putAll(vals.getFirst());
									}
								} else if(vals.size() > 1){
									for(int i=0; i<vals.size(); i++){//remember: the size of vals will be lower or equal the size of syncedComplexAttrMappings
										syncedComplexMappings.get(i).putAll(vals.get(i));
									}
								}	
					}
					m.clear();
					
					if(isCommonParent){//sync
						//add to changedRefsAndHints
						//TODO if(syncedComplexMappings != null){
							changedRefsAndHints.getHintValues()
							.get(h)
							.addAll(syncedComplexMappings);
						//}
					} else {
						changedRefsAndHints.getUnSyncedComplexAttrMatchers().get(h).clear();//remove old hints
						changedRefsAndHints.getUnSyncedComplexAttrMatchers().get(h).put(srcSection, syncedComplexMappings);//add new hints
					}
				}
			}
		}
	}	
	
	/**
	 * @param srcSection
	 * @param changedRefsAndHints
	 */
	private void syncCalcMappings(SourceSectionClass srcSection,
			MappingInstanceStorage changedRefsAndHints) {
		for(MappingHintType h : changedRefsAndHints.getUnSyncedCalcMappings().keySet()){
			boolean isCommonParent=commonContainerClassOfComplexMappings.get(h).equals(srcSection);
			
			if(changedRefsAndHints.getUnSyncedCalcMappings().containsKey(h)){
				if(changedRefsAndHints.getUnSyncedCalcMappings().get(h).size()>1 || isCommonParent){
					Map<SourceSectionClass, LinkedList<Map<ExpressionVariable, String>>> m=
							changedRefsAndHints.getUnSyncedCalcMappings().get(h);
					//list of "synced" hints
					LinkedList<Map<ExpressionVariable,String>> syncedComplexMappings=null;
					//find longest list (ideally they are either of the same length, or there is only one value)
					SourceSectionClass cl=null;
					for(SourceSectionClass c :  m.keySet()){
						if(syncedComplexMappings == null){
							syncedComplexMappings=m.get(c);
							cl=c;
						} else if(m.get(c).size() > syncedComplexMappings.size()){
							syncedComplexMappings=m.get(c);
							cl=c;
						}
					}
					//remove selected List from m
					m.remove(cl);
					
					//combine values
					for(SourceSectionClass c :  m.keySet()){
							LinkedList<Map<ExpressionVariable,String>> vals=m.get(c);
								if(vals.size() == 1){
									for(Map<ExpressionVariable,String> valMap : syncedComplexMappings){
										valMap.putAll(vals.getFirst());
									}
								} else if(vals.size() > 1){
									for(int i=0; i<vals.size(); i++){//remember: the size of vals will be lower or equal the size of syncedComplexAttrMappings
										syncedComplexMappings.get(i).putAll(vals.get(i));
									}
								}	
					}
					m.clear();
					
					if(isCommonParent){//sync
						//add to changedRefsAndHints
						//TODO if(syncedComplexMappings != null){
							changedRefsAndHints.getHintValues()
							.get(h)
							.addAll(syncedComplexMappings);
						//}
					} else {
						changedRefsAndHints.getUnSyncedCalcMappings().get(h).clear();//remove old hints
						changedRefsAndHints.getUnSyncedCalcMappings().get(h).put(srcSection, syncedComplexMappings);//add new hints
					}
				}
			}
		}
	}
	
	/**
	 * @param srcSection
	 * @param changedRefsAndHints
	 */
	private void syncModelConnectionHints(SourceSectionClass srcSection,
			MappingInstanceStorage changedRefsAndHints) {
		for(ModelConnectionHint h : changedRefsAndHints.getUnSyncedComplexConnectionHints().keySet()){
			boolean isCommonParent=commonContainerClassOfComplexMappings.get(h).equals(srcSection);
			
			if(changedRefsAndHints.getUnSyncedComplexConnectionHints().containsKey(h)){
				if(changedRefsAndHints.getUnSyncedComplexConnectionHints().get(h).size()>1 || isCommonParent){
					Map<SourceSectionClass, LinkedList<Map<ComplexModelConnectionHintSourceElement, String>>> m=
							changedRefsAndHints.getUnSyncedComplexConnectionHints().get(h);
					//list of "synced" hints
					LinkedList<Map<ComplexModelConnectionHintSourceElement,String>> syncedComplexMappings=null;
					//find longest list (ideally they are either of the same length, or there is only one value)
					SourceSectionClass cl=null;
					for(SourceSectionClass c :  m.keySet()){
						if(syncedComplexMappings == null){
							syncedComplexMappings=m.get(c);
							cl=c;
						} else if(m.get(c).size() > syncedComplexMappings.size()){
							syncedComplexMappings=m.get(c);
							cl=c;
						}
					}
					//remove selected List from m
					m.remove(cl);
					
					//combine values
					for(SourceSectionClass c :  m.keySet()){
							LinkedList<Map<ComplexModelConnectionHintSourceElement,String>> vals=m.get(c);
								if(vals.size() == 1){
									for(Map<ComplexModelConnectionHintSourceElement,String> valMap : syncedComplexMappings){
										valMap.putAll(vals.getFirst());
									}
								} else if(vals.size() > 1){
									for(int i=0; i<vals.size(); i++){//remember: the size of vals will be lower or equal the size of syncedComplexAttrMappings
										syncedComplexMappings.get(i).putAll(vals.get(i));
									}
								}	
					}
					m.clear();
					
					if(isCommonParent){//sync
						//add to changedRefsAndHints
						//TODO if(syncedComplexMappings != null){
							changedRefsAndHints.getHintValues()
							.get(h)
							.addAll(syncedComplexMappings);
						//}
					} else {
						changedRefsAndHints.getUnSyncedComplexConnectionHints().get(h).clear();//remove old hints
						changedRefsAndHints.getUnSyncedComplexConnectionHints().get(h).put(srcSection, syncedComplexMappings);//add new hints
					}
				}
			}
		}
	}		

	/**
	 * Counts how often each associated source model element is referenced by each MappingInstdanceStorage
	 * as associated source model object and returns  one mapping result for the Object with the lowest count.
	 * @param possibleElements
	 * @return Mapping results 
	 */
	private static MappingInstanceStorage getResultForLeastUsedSrcModelElement(
			final LinkedList<MappingInstanceStorage> possibleElements) {
		MappingInstanceStorage srcSectionResult;
		// count how often a sourceModel Element is mapped
		LinkedHashMap<EObject, Integer> usages = new LinkedHashMap<EObject, Integer>();
		for (MappingInstanceStorage e : possibleElements) {
			EObject element = e.getAssociatedSourceModelElement();
			if (!usages.containsKey(element)) {
				usages.put(element, 0);
			}
			usages.put(element, usages.get(element) + 1);
		}
		// use one of the mappings for one of the elements with the least
		// possible mappings
		EObject leastUsed = possibleElements.getFirst()
				.getAssociatedSourceModelElement();
		int numberUsed = usages.get(leastUsed);
		for (EObject o : usages.keySet()) {// find the first element least used
											// and return the first possible
											// result
			if (usages.get(o) < numberUsed) {
				leastUsed = o;
				numberUsed = usages.get(o);
			}
		}

		srcSectionResult = possibleElements.getFirst();// initialize this
														// variable so we dont
														// get compile errors
		for (MappingInstanceStorage e : possibleElements) {
			if (e.getAssociatedSourceModelElement().equals(leastUsed)) {
				srcSectionResult = e;
				break;
			}
		}
		return srcSectionResult;
	}
	
	/**
	 * Finds the value for an ExternalAttributeMappingSourceElement
	 * @param attr attribute to find
	 * @param extClass container class to start looking
	 * @param extObj  eObject corresponding to the container class
	 * @return
	 */
	private String getContainerAttributeValue(SourceSectionAttribute attr, SourceSectionClass extClass, EObject extObj){
		SourceSectionClass attrClass=attr.getOwningClass();
		
		while(true){
			//found container section?
			if(attrClass.equals(extClass)){
				Object attrVal=extObj.eGet(attr.getAttribute());
				if(attrVal == null){
					consoleStream.println("Unset external Attrbute " + attr.getName());
					return null;
				} else { // convert Attribute value to String
					return attr
							.getAttribute()
							.getEType()
							.getEPackage()
							.getEFactoryInstance()
							.convertToString(attr.getAttribute().getEAttributeType(),
									attrVal);
				}
			} else if(extClass.eContainer() instanceof SourceSectionContainmentReference){
				extClass=(SourceSectionClass) extClass.eContainer().eContainer();
				extObj=extObj.eContainer();
				//Check if the parent object exists, and if it was mapped for the section.
				if(!checkObjectWasMapped(extClass, extObj)) return null;
			} else if(extClass.eContainer() instanceof SourceSectionModel && extClass.getContainer() != null){
				extClass=extClass.getContainer();
				extObj=extObj.eContainer();
				if(!checkObjectWasMapped(extClass, extObj)) return null;
			}else {//modeling error, object not found
				consoleStream.println("Modeling error. External Source Element " + attr.getName() + "is not part of the the container"
						+ "section or the section that the container section is part of.");
				return null;
			}
															
		}
	}

	/**
	 * @param extClass
	 * @param extObj
	 */
	private boolean checkObjectWasMapped(SourceSectionClass extClass,
			EObject extObj) {
		if(extObj != null){
			if(mappedSections.containsKey(extClass)){
				if(mappedSections.get(extClass).contains(extObj)){
					return true;
				}
			} else if(mappedContainers.containsKey(extClass)){
					if(mappedContainers.get(extClass).contains(extObj)){
						return true;
					}
			}
		}
		return false;
	}
	
	/**
	 * Try to apply a mapping that has the first Element of the supplied List as its root object.
	 * <p>
	 * It is assumed that the List was created by the buildContainmentTree method
	 * @param contRefObjectsToMap
	 * @return Hints and used source model elements for the , null if no mapping could be found
	 */
	MappingInstanceStorage findMapping(List<EObject> contRefObjectsToMap){		
		long start;//for statistics
		long time;
		
		EObject element=contRefObjectsToMap.remove(0);//source model element which we will now try to map
		start = System.nanoTime();
		Map<Mapping, MappingInstanceStorage> mappingData=new LinkedHashMap<Mapping, MappingInstanceStorage>();
			//find mapping rules that are applicable to a srcMM element 
			for(Mapping m : mappingsToChooseFrom){
				//create  result map
				MappingInstanceStorage res ;
				
				if(m.getSourceMMSection().getEClass().isSuperTypeOf(element.eClass())){//This check is also done by findMapping, but 
																					   //since it will most likely fail at the top level,
																						//for most mappings we do it here 
																					    //before we construct any collections and so on.
																					   //This might save us a little time, but of course that depends on the number mappings
																						//and the source metamodel.
																										
					if(doContainerCheck(element,m.getSourceMMSection()) ){					
						res= findMapping(element, false, getHints(m), getModelConnectionHints(m), m.getGlobalVariables(),
								m.getSourceMMSection(),
								new MappingInstanceStorage());
						if(transformationAborted) return null;
						
						boolean mappingFailed=res == null;
						if(!mappingFailed){
							//if mapping possible check ExternalAttributeMappings
							// check external attributes here; container element MUST be present (check was done earlier)
							mappingFailed = handleExternalAttributeMappings(m, res, mappingFailed);
						}
						if(!mappingFailed){//if mapping possible add to list
								res.setMapping(m);
								mappingData.put(m, res);
						}		
					}
				}
			}
			time=System.nanoTime()-start;
			
			//last step: let user decide	
			MappingInstanceStorage returnVal=null;
			switch(mappingData.keySet().size()){
				case 0:
					//consoleStream.println("No suitable mappping found for element\n'" + element.eClass().getName() + "'.");
					break;
				case 1:
					returnVal= mappingData.values().iterator().next();
					break;
				default:
					if(ambiguousMappingSelections.containsKey(mappingData.keySet())){
						returnVal=mappingData.get(ambiguousMappingSelections.get(mappingData.keySet()));
					} else {
						Map<String,Mapping> names=new LinkedHashMap<String,Mapping>();
						for(Mapping m: mappingData.keySet()){
							names.put( m.getName()+  " (" + m.hashCode()+ ")", m);
						}
						ItemSelectorDialogRunner dialog= new ItemSelectorDialogRunner("Please select a Mapping for the source element\n'" 
								+  EObjectTransformationHelper.asString(element) + "'" , 
											names.keySet(), names.keySet().iterator().next());
								Display.getDefault().syncExec(dialog);
								if(dialog.wasTransformationStopRequested()){
									transformationAborted=true;
									return null;
								}
								returnVal= mappingData.get(names.get(dialog.getSelection()));
								ambiguousMappingSelections.put(mappingData.keySet(), names.get(dialog.getSelection()));
					}
			}	
			
			if(returnVal != null){
				int used=0;
				for(SourceSectionClass c : returnVal.getSourceModelObjectsMapped().keySet()){
					if(!mappedSections.containsKey(c)){
						mappedSections.put(c,new LinkedHashSet<EObject>());
					}
					used+=returnVal.getSourceModelObjectsMapped().get(c).size();
					mappedSections.get(c).addAll(returnVal.getSourceModelObjectsMapped().get(c));
					
					contRefObjectsToMap.removeAll(returnVal.getSourceModelObjectsMapped().get(c));//remove mapped elements from list of elements to be mapped
				}
				consoleStream.println(','  + returnVal.getMapping().getName() + ", " + used  + " ,  "+ time );

				/*
				 * Handle cardinality Hints for section root (doesn't make sense to model this but we will tolerate it)
				 */
				for(MappingHintType h : getHints(returnVal.getMapping())){
					if(h instanceof CardinalityMapping){
						returnVal.addHintValue(h, new Integer(1));
					}
				}
			}
			
			return returnVal;
	}

	/**
	 * Tries to determine the hintValues for the ExternalAttributeMappingSourceElements, if present
	 * @param m
	 * @param res
	 * @param mappingFailed
	 * @return
	 */
	private boolean handleExternalAttributeMappings(Mapping m,
			MappingInstanceStorage res, boolean mappingFailed) {
		if(m.getSourceMMSection().getContainer() != null){
				Map<ExternalAttributeMappingSourceElement,String> attrVals=new HashMap<ExternalAttributeMappingSourceElement,String>();
				for(MappingHintType h : getHints(m)){
					if(h instanceof ComplexAttributeMapping){
						for(ComplexAttributeMappingSourceInterface i : ((ComplexAttributeMapping) h).getSourceAttributeMappings()){
							mappingFailed = checkExternalAttributeMapping(m, res, mappingFailed,attrVals, i);
							if(mappingFailed){
								break;
							}
						}
						//add to hintVals
						if(mappingFailed){
							break;
						} else if(attrVals.keySet().size() > 0){
								//if the external element was the only one in the hint we need to add a hint value
							if(res.getHintValues().get(h).size() == 0){
								res.getHintValues().get(h).add(new LinkedHashMap<ComplexAttributeMappingSourceInterface,String>());
							}
								for(Object hVal: res.getHintValues().get(h)){
									@SuppressWarnings("unchecked")
									Map<ComplexAttributeMappingSourceInterface,String> map=(Map<ComplexAttributeMappingSourceInterface,String>) hVal;
									for(ExternalAttributeMappingSourceElement e : attrVals.keySet()){
										map.put((ComplexAttributeMappingSourceInterface) e, attrVals.get(e));
									}
								}
								//last action: reset attrval list
								attrVals.clear();
						}
					}else if(h instanceof ExternalMappedAttributeValueExpander){
							String attrVal=getContainerAttributeValue(((ExternalMappedAttributeValueExpander) h).getSourceAttribute(),
									m.getSourceMMSection().getContainer(),
									res.getAssociatedSourceModelElement().eContainer()
									);
							if(attrVal == null){
								mappingFailed=true;
								break;
							} else {
								attrVal=attributeValuemodifier.applyAttributeValueModifiers(attrVal, ((ExternalMappedAttributeValueExpander) h).getModifiers());
								res.getHintValues().get(h).add(attrVal);
							}
											
					}else if(h instanceof CalculatorMapping){
						for(CalculatorMappingSourceInterface i : ((CalculatorMapping) h).getVariables()){
							mappingFailed = checkExternalAttributeMapping(m, res, mappingFailed,attrVals, i);
							if(mappingFailed){
								break;
							}											
						}
						//add to hintVals
						if(mappingFailed){
							break;
						} else if(attrVals.keySet().size() > 0){
							if(res.getHintValues().get(h).size() == 0){
								res.getHintValues().get(h).add(new LinkedHashMap<String,Double>());
							}
								Map<String,Double> newVals=new HashMap<String,Double>();
								for(ExternalAttributeMappingSourceElement e : attrVals.keySet()){
									try{
										Calculable calc=new ExpressionBuilder(attrVals.get(e)).build();
										double variableVal= calc.calculate();//parseDouble doesn't support Scientific notation, like: 0.42e2 == 4200e-2 == 42, 
										newVals.put(e.getName(), new Double(variableVal));
									} catch(Exception execption){
										consoleStream.println("Couldn't convert variable " 
												+ e.getName() + " of CalculatorMapping " + h.getName()
												+ " from String to double. The problematic source element's attribute value was: " 
												+ attrVals.get(e));
									}
								}
								for(Object hVal: res.getHintValues().get(h)){
									@SuppressWarnings("unchecked")
									Map<String,Double> map=(Map<String,Double>) hVal;
									map.putAll(newVals);
								}
								//last action: reset attrval list
								attrVals.clear();
						}										
					}else if(h instanceof MappingInstanceSelector){
						if(((MappingInstanceSelector) h).getMatcher()!= null){
							if(((MappingInstanceSelector) h).getMatcher() instanceof ComplexAttributeMatcher){
								ComplexAttributeMatcher matcher=(ComplexAttributeMatcher) ((MappingInstanceSelector) h).getMatcher();
								for(ComplexAttributeMatcherSourceInterface i : matcher.getSourceAttributes()){
									mappingFailed = checkExternalAttributeMapping(m, res, mappingFailed,attrVals, i);
									if(mappingFailed){
										break;
									}													
								}
								//add to hintVals
								if(mappingFailed){
									break;
								} else if(attrVals.keySet().size() > 0){
									if(res.getHintValues().get(h).size() == 0){
										res.getHintValues().get(h).add(new LinkedHashMap<ComplexAttributeMatcherSourceInterface,String>());
									}
										for(Object hVal: res.getHintValues().get(h)){
											@SuppressWarnings("unchecked")
											Map<ComplexAttributeMatcherSourceInterface,String> map=(Map<ComplexAttributeMatcherSourceInterface,String>) hVal;
											for(ExternalAttributeMappingSourceElement e : attrVals.keySet()){
												map.put((ComplexAttributeMatcherSourceInterface) e, attrVals.get(e));
											}
										}
										//last action: reset attrval list
										attrVals.clear();
								}
							}
						}
					}
				}
				
				for(ModelConnectionHint h : getModelConnectionHints(m)){
					if(h instanceof ComplexModelConnectionHint){
						for(ComplexModelConnectionHintSourceInterface i : ((ComplexModelConnectionHint) h).getSourceElements()){
							mappingFailed = checkExternalAttributeMapping(m, res, mappingFailed,attrVals, i);
							if(mappingFailed){
								break;
							}
						}
						//add to hintVals
						if(mappingFailed){
							break;
						} else if(attrVals.keySet().size() > 0){
							if(res.getModelConnectionHintValues().get(h).size() == 0){
								res.getModelConnectionHintValues().get(h).add(new LinkedHashMap<ComplexModelConnectionHintSourceInterface,String>());
							}
								for(Object hVal: res.getModelConnectionHintValues().get(h)){
									@SuppressWarnings("unchecked")
									Map<ComplexModelConnectionHintSourceInterface,String> map=(Map<ComplexModelConnectionHintSourceInterface,String>) hVal;
									for(ExternalAttributeMappingSourceElement e : attrVals.keySet()){
										map.put((ComplexModelConnectionHintSourceInterface) e, attrVals.get(e));
									}
								}
								//last action: reset attrval list
								attrVals.clear();
						}										
					}
				}
				
			
		}
		return mappingFailed;
	}

	/**
	 * Helper method to handle an ExternalAttributeMapping
	 * @param m
	 * @param res
	 * @param mappingFailed
	 * @param attrVals
	 * @param i
	 * @return
	 */
	private boolean checkExternalAttributeMapping(Mapping m,
			MappingInstanceStorage res, boolean mappingFailed,
			Map<ExternalAttributeMappingSourceElement, String> attrVals,
			ComplexMappingHintSourceInterface i) {
		if(i instanceof ExternalAttributeMappingSourceElement){
			String attrVal=getContainerAttributeValue(i.getSourceAttribute(),
					m.getSourceMMSection().getContainer(),
					res.getAssociatedSourceModelElement().eContainer()
					);
			if(attrVal == null){
				mappingFailed=true;
			} else {
				attrVal=attributeValuemodifier.applyAttributeValueModifiers(attrVal, ((ExternalAttributeMappingSourceElement) i).getModifier());
				attrVals.put((ExternalAttributeMappingSourceElement) i, attrVal);
			}
		}
		return mappingFailed;
	}

	
	/**
	 * Check if the container section referenced by the sourceSection Classe's container ref. can be mapped.
	 * @param element
	 * @param sourceSectionClass
	 * @return true if the container attribute of the sourceSection Class doesn't exist or a fitting container instance exists
	 */
	private boolean doContainerCheck(EObject element, SourceSectionClass sourceSectionClass){
		if(sourceSectionClass.getContainer() == null){
			//this part is easy
			return true;
		} else {
			/*
			 * Step 1: identify all containers the corresponding elements
			 */
			List<SourceSectionClass> containerClasses=new LinkedList<SourceSectionClass>();			
			List<EObject> containerElements=new LinkedList<EObject>();
			
			SourceSectionClass currentClass=sourceSectionClass;
			EObject currentElement=element;
			
			while(currentClass.getContainer() !=null){
				/*
				 * "jump" SourceMMSection boundary
				 */
				if(currentElement.eContainer() != null){
					currentElement=currentElement.eContainer();
					currentClass=currentClass.getContainer();

					/*
					 * scan all levels of source section until we are at a top level again
					 * 
					 * we do not concern ourselves with mapping of the elements at this point, all we need are
					 * the container sections
					 */
					while(!currentClass.getContainingSection().equals(currentClass)){
						if(currentElement.eContainer() != null){
							currentElement=currentElement.eContainer();
							currentClass= currentClass.getOwningContainmentReference().getOwningClass();
						}  else {
							return false;
						}
					}
					containerElements.add(currentElement);
					containerClasses.add(currentClass);
					
				} else {
					return false;
				}
			}

			/*
			 * Step 2: try to map each container section, starting from the highest
			 */
			int index=containerClasses.size()-1;
			while(index>=0){
				/*
				 * map container if it wasn't mapped before
				 */
				if(!checkObjectWasMapped(containerClasses.get(index), containerElements.get(index))){
					MappingInstanceStorage res= findMapping(containerElements.get(index), false, 
							Collections.<MappingHintType>emptyList(), 
							Collections.<ModelConnectionHint>emptyList(), 
							Collections.<GlobalAttribute>emptyList(),
							containerClasses.get(index),
							new MappingInstanceStorage());
					if(res == null){
						return false;
					} else {
						for(SourceSectionClass c : res.getSourceModelObjectsMapped().keySet()){
							if(!mappedContainers.containsKey(c)){
								mappedContainers.put(c,new LinkedHashSet<EObject>());
							}
							mappedContainers.get(c).addAll(res.getSourceModelObjectsMapped().get(c));							
						}						
					}
				}
				
				/*
				 * make sure that next container's container was mapped at the appropriate position
				 */
				index--;
				if(index>=0){
					if(!checkObjectWasMapped(containerClasses.get(index).getContainer(),containerElements.get(index).eContainer() )){
						return false;
					}
				} else {//we cannot put this element in the list because we do not want to map it already
					if(!checkObjectWasMapped(sourceSectionClass.getContainer(), element.eContainer())){
						return false;
					}
				}
			}
			//if we reached this point all went well
			return true;
		}
	}
	
}


