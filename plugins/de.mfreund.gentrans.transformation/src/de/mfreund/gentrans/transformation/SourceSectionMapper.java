package de.mfreund.gentrans.transformation;

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
import pamtram.mapping.GlobalVariable;
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
	private LinkedHashMap<SourceSectionClass,Set<EObject>> mappedSections;
	/**
	 * Registry for ModelConnectionHints. Used When linking target model sections.
	 */
	private LinkedHashMap<Mapping, LinkedList<ModelConnectionHint>> modelConnectionHints;
	/**
	 * Registry for MappingHints. Used When instantiating target model sections.
	 */
	private LinkedHashMap<Mapping,LinkedList<MappingHintType>> mappingHints;
	/**
	 * Map Referencing the Class referenced by the ComplexAttributeMappingSourceElement that is buried deepest in the source Section,
	 * sorted by ComplexAttributeMapping.
	 */
	private LinkedHashMap<ComplexAttributeMapping,SourceSectionClass> deepestComplexAttrMappingSrcElementsByCmplxMapping;
	/**
	 * Map Referencing the Class referenced by the ExpressionVariable that is buried deepest in the source Section,
	 * sorted by CalculatorMapping.
	 */
	private LinkedHashMap<CalculatorMapping,SourceSectionClass> deepestCalcAttrMappingSrcElementsByCalcMapping;
	/**
	 * Map Referencing the Class referenced by the ComplexAttributeMatcherSourceElement that is buried deepest in the source Section,
	 * sorted by ComplexAttributeMatcher.
	 */
	private LinkedHashMap<ComplexAttributeMatcher, SourceSectionClass> deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher;
	
	/**
	 * Map Referencing the Class referenced by the ComplexModelConnectionHintSourceElement that is buried deepest in the source Section,
	 * sorted by ComplexAttributeMatcher.
	 */
	private LinkedHashMap<ComplexModelConnectionHint, SourceSectionClass> deepestComplexConnectionHintSrcElementsByComplexConnectionHint;
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
	private Map<GlobalVariable,String> globalVarValues;
	
	/**
	 * Getter for Registry for values of global Variables
	 * @return Registry for values of global Variables
	 */
	public Map<GlobalVariable, String> getGlobalVarValues() {
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
	 * @param mappingsToChooseFrom Mappings from the PAMTram model
	 * @param consoleStream Output stream for messages
	 */
	SourceSectionMapper(List<Mapping> mappingsToChooseFrom, AttributeValueModifierExecutor attributeValuemodifier, MessageConsoleStream consoleStream) {
		mappedSections=new LinkedHashMap<SourceSectionClass,Set<EObject>> ();
		mappingHints=new  LinkedHashMap<Mapping,LinkedList<MappingHintType>>();
		modelConnectionHints=new  LinkedHashMap<Mapping,LinkedList<ModelConnectionHint>>();
		deepestComplexAttrMappingSrcElementsByCmplxMapping= new LinkedHashMap<ComplexAttributeMapping,SourceSectionClass>();
		deepestCalcAttrMappingSrcElementsByCalcMapping = new LinkedHashMap<CalculatorMapping,SourceSectionClass>();
		deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher= new LinkedHashMap<ComplexAttributeMatcher, SourceSectionClass>();
		deepestComplexConnectionHintSrcElementsByComplexConnectionHint= new LinkedHashMap<ComplexModelConnectionHint, SourceSectionClass>();
		globalVarValues=new HashMap<GlobalVariable,String>();
		this.mappingsToChooseFrom=mappingsToChooseFrom;
		this.consoleStream=consoleStream;
		this.transformationAborted=false;
		this.attributeValuemodifier=attributeValuemodifier;
		
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
			
			sortOutElements(srcElements, srcSection);
			if(srcElements.size() == 1){
				deepestComplexAttrMappingSrcElementsByCmplxMapping.put(m,srcElements.iterator().next().getSource().getOwningClass());
			}
			
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
			
			sortOutElements(srcElements, srcSection);
			if(srcElements.size() == 1){
				deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher.put(m,srcElements.iterator().next().getSource().getOwningClass());
				
			}
			
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
			
			sortOutElements(srcElements, srcSection);
			if(srcElements.size() == 1){
				deepestComplexConnectionHintSrcElementsByComplexConnectionHint.put(m,srcElements.iterator().next().getSource().getOwningClass());
				
			}
			
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
			
			sortOutElements(srcElements, srcSection);
			if(srcElements.size() == 1){
				deepestCalcAttrMappingSrcElementsByCalcMapping.put(m,srcElements.iterator().next().getSource().getOwningClass());
			}
			
		}
	}
	
	/**
	 * Helper Method used when building  the deepestElements Maps
	 * @param s
	 * @param srcSection
	 */
	private void sortOutElements(Set<AttributeMappingSourceElementType> s, SourceSectionClass srcSection){
		if(s.size() <= 1) return;//found
		//sort out elements
		for(SourceSectionAttribute a : srcSection.getAttributes()){
			for(AttributeMappingSourceElementType e : new HashSet<AttributeMappingSourceElementType>(s)){
				if(e.getSource().equals(a)){
					s.remove(e);
					if(s.size() <= 1){
						return;
					}
				}
			}
		}
		
		//go deeper
		for(SourceSectionReference r : srcSection.getReferences()){
			for(SourceSectionClass c : r.getValuesGeneric()){
				sortOutElements(s, c);
				if(s.size() <= 1){
					return;
				}
			}
		}
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
	private  MappingInstanceStorage findMappingIterate(
			EObject srcModelObject, boolean usedOkay,
			Iterable<MappingHintType> hints,
			Iterable<ModelConnectionHint> connectionHints,
			Iterable<GlobalVariable> globalVars,
			SourceSectionClass srcSection,
			MappingInstanceStorage newRefsAndHints,
			LinkedHashMap<SourceSectionClass, EObject> srcInstanceMap) {

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

		// set self in sourceInstanceMAp
		srcInstanceMap.put(srcSection, srcModelObject);

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
				 * Eclusions are AND connected
				 */
				boolean inclusionMatched=false;
				boolean containsInclusions=false;
				for (AttributeValueConstraint constraint : at.getValueConstraint()) {
					boolean constraintVal=constraint.checkConstraint(srcAttrAsString);
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
				
				for(GlobalVariable gVar : globalVars){
					if(gVar.getSource().equals(at)){
						String modifiedVal=attributeValuemodifier.applyAttributeValueModifiers(srcAttrAsString, gVar.getModifier());
						globalVarValues.put(gVar, modifiedVal);
					}
				}

			} else {// attribute not set / null
//				consoleStream.println("Unset attribute " + at.getName() + "(Class: "
//						+ at.getOwningClass().getName()
//						+ ", Section: " + at.getContainingSection().getName());// we probably don't want any output here
//				
				return null;
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

		// now go through all the srcMmSection refs
		for (SourceSectionReference reference : srcSection.getReferences()) {
			// reference.name.println;
			// check if reference is allowed by src metamodel
			// check if reference in srcMMSection points anywhere
			if (reference.getValuesGeneric().size() < 1)
				break;
			Object refTarget = srcModelObject.eGet(reference.getEReference());// get
																				// refTarget(s)
																				// in
																				// srcModel
			// behave, depending on cardinality
			/*
			 * There are cases in which modeling more than target values for a section than it can actually hold
			 * might make sense depending on how the target's CardinalityType value was set.
			 * Therefore we do not check the modeled references values at this point. 
			 */
			if (reference.getEReference().getUpperBound() == 1) {
				EObject refTargetObj = (EObject) refTarget;
				if (refTargetObj == null)
					return null;
				MappingInstanceStorage res = null;
				boolean nonZeroCardSectionFound=false;

				for(SourceSectionClass c : reference.getValuesGeneric()){
					//check non-zero sections first (it doesn't make sense in this case to model ZERO_INFINITY sections, if there is one 
					//section with a minimum cardinality of 1, but it can be handled
					if(!c.getCardinality().equals(CardinalityType.ZERO_INFINITY)){
						if(nonZeroCardSectionFound){//modeling error
							consoleStream.println("Modeling error in source section: '" + srcSection.getContainer().getName() + "'"
									+", subsection: '" + srcSection.getName() + "'. The Reference '" + reference.getName() + "'"
									+ " points to a metamodel refernce, that can only hold one value but in the source section it references more than one Class with"
									+ "a CardinalityType that is not ZERO_INFINITY." );
						}
						nonZeroCardSectionFound=true;
						 res = findMappingIterate(
									refTargetObj,
									(reference instanceof MetaModelSectionReference) || usedOkay
									, hints,
									connectionHints,globalVars ,c,
									changedRefsAndHints, srcInstanceMap);
						 if(transformationAborted){
								return null;
						 }
					}
				}
				
				if(!nonZeroCardSectionFound){
					for(SourceSectionClass c : reference.getValuesGeneric()){
							 res = findMappingIterate(
										refTargetObj,
										(reference instanceof MetaModelSectionReference) || usedOkay
										, hints,
										connectionHints,globalVars ,c,
										changedRefsAndHints, srcInstanceMap);
								if(transformationAborted){
									return null;
								}
						 if(res != null){
							 break;
						 }
					}					
				}

				if (res != null) {
					// success: combine refs and hints
					if (reference instanceof ContainmentReference) {
						changedRefsAndHints.add(res);
					} else {
						changedRefsAndHints.addHintValues(res.getHintValues());
						changedRefsAndHints.addModelConnectionHintValues(res.getModelConnectionHintValues());
					}
					// check for a cardinality hint (it doesn't really make
					// sense to model this for a class connected to a reference
					// with cardinality == 1 but it can be tolerated ) TODO

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
				for (SourceSectionClass val : reference.getValuesGeneric()) {
					if (val.getCardinality().equals(CardinalityType.ONE)) {
						possibleSrcModelElementsNoVC
								.put(val,
										new LinkedList<MappingInstanceStorage>());
					}
				}

				// Map to store possible srcModelSections to MMSections (vc))
				SrcSectionMappingResultsMap possibleSrcModelElementsVC = new SrcSectionMappingResultsMap();
				for (SourceSectionClass val : reference.getValuesGeneric()) {
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
					for (SourceSectionClass val : reference.getValuesGeneric()) {
						MappingInstanceStorage res = findMappingIterate(
								rt,
								(reference instanceof MetaModelSectionReference) || usedOkay,
								hints, connectionHints, globalVars, val,
								changedRefsAndHints, srcInstanceMap);
						if(transformationAborted){
							return null;
						}
						if (res != null) {// mapping possible
							foundMapping = true;
							res.setAssociatedSourceModelElement(rt);
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
						//TODO consoleStream.println("we need to find a mapping for every srcModelElement (at: " + srcSection.getName() + " )" + EObjectTransformationHelper.asString(rt));
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
						if (reference instanceof ContainmentReference) {
							changedRefsAndHints.add(srcSectionResult);

						} else {
							changedRefsAndHints.addHintValues(srcSectionResult
									.getHintValues());
							changedRefsAndHints.addModelConnectionHintValues(srcSectionResult.getModelConnectionHintValues());
						}
						allElementsMapped.add(srcSectionResult
								.getAssociatedSourceModelElement());
						// remove srcModel element from possibility lists of
						// MMSections
						possibleSrcModelElementsNoVC
								.removeResultsForElement(srcSectionResult);
						possibleSrcModelElementsVC
								.removeResultsForElement(srcSectionResult);
						possibleSrcModelElementsNoVC.remove(smallestKey);// remove
																			// successfully
																			// mapped
																			// mmSection
																			// from
																			// list
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

					pamtram.metamodel.Class smallestKey = possibleSrcModelElementsVC
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
						if (reference instanceof ContainmentReference) {
							changedRefsAndHints.add(srcSectionResult);

						} else {

							changedRefsAndHints.addHintValues(srcSectionResult
									.getHintValues());
							changedRefsAndHints.addModelConnectionHintValues(srcSectionResult.getModelConnectionHintValues());
						}
						allElementsMapped.add(srcSectionResult
								.getAssociatedSourceModelElement());

						// remove srcModel element from possibility lists of
						// MMSections
						possibleSrcModelElementsVC
								.removeResultsForElement(srcSectionResult);
					} else if (usedKeys.contains(smallestKey)
							|| smallestKey.getCardinality().equals(
									CardinalityType.ZERO_INFINITY)) {
						possibleSrcModelElementsVC.remove(smallestKey);// remove
																		// mmSection
																		// from
																		// list
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

				//TODO (?) cardinality mapping

			}
		}
		
		for(MappingHintType h : hints){
				if(h instanceof ComplexAttributeMapping){
					if(!(complexAttributeMappingsFound.contains(h) && 
							deepestComplexAttrMappingSrcElementsByCmplxMapping.get(h).equals(srcSection))){
						changedRefsAndHints.getHintValues().get(h).remove();					
					}
				} else if(h instanceof MappingInstanceSelector){
					if(((MappingInstanceSelector) h).getMatcher()  instanceof ComplexAttributeMatcher){
						if(!(complexAttributeMatchersFound.contains(((MappingInstanceSelector) h).getMatcher()) 
								&& deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher
									.get(((MappingInstanceSelector) h).getMatcher()).equals(srcSection)
						)){
								
							changedRefsAndHints.getHintValues().get(h).remove();
						}
					}
				} else if (h instanceof CalculatorMapping){
					if(!(calculatorMappingsFound.contains(h) &&  deepestCalcAttrMappingSrcElementsByCalcMapping.get(h).equals(srcSection))){
						changedRefsAndHints.getHintValues().get(h).remove();
					}
				}				
		}
		
		for(ModelConnectionHint h :  connectionHints){
			if(h instanceof ComplexModelConnectionHint){
				if(!(complexConnectionHintsFound.contains(h) &&
						deepestComplexConnectionHintSrcElementsByComplexConnectionHint.get(h).equals(srcSection))){
					changedRefsAndHints.getModelConnectionHintValues().get(h).remove();
				}
			}
		}
		
		return changedRefsAndHints;

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
					consoleStream.println("Unset external Attriubte " + attr.getName());
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
				if(extObj == null){
					return null;
				} else{
					if(mappedSections.containsKey(extClass)){
						if(!mappedSections.get(extClass).contains(extObj)){
							return null;
						}
					} else {
						return null;
					}
				}
			} else if(extClass.eContainer() instanceof SourceSectionModel && extClass.getContainer() != null){
				extClass=extClass.getContainer();
				extObj=extObj.eContainer();
				if(extObj == null){
					return null;
				} else {
					if(mappedSections.containsKey(extClass)){
						if(!mappedSections.get(extClass).contains(extObj)){
							return null;
						}
					} else {
						return null;
					}					
				}
			}else {//modeling error, object not found
				consoleStream.println("Modeling error. External Source Element " + attr.getName() + "is not part of the the container"
						+ "section or the section that the container section is part of.");
				return null;
			}
															
		}
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
		LinkedHashMap<MappingInstanceStorage,String> usedInMapping=new LinkedHashMap<MappingInstanceStorage,String>();
		LinkedHashMap<String, MappingInstanceStorage> mappingData=new LinkedHashMap<String, MappingInstanceStorage>();
			//find mapping rules that are applicable to a srcMM element 
			for(Mapping m : mappingsToChooseFrom){
				//create  result map
				MappingInstanceStorage res ;
				
				if(doContainerCheck(element,m.getSourceMMSection()) ){					
					res= findMappingIterate(element, false, getHints(m), getModelConnectionHints(m), m.getGlobalVariables(),
							m.getSourceMMSection(),
							new MappingInstanceStorage(),
							new LinkedHashMap<SourceSectionClass, EObject>());
					if(transformationAborted)
					{
						return null;
					}
					boolean mappingFailed=res == null;
					if(!mappingFailed){
						res.setAssociatedSourceModelElement(element);
						//if mapping possible check ExternalAttributeMappings
						// check external attributes here; container element MUST be present (check was done earlier)
						mappingFailed = handleExternalAttributeMappings(m, res, mappingFailed);
					}
					if(!mappingFailed){//if mapping possible add to list
							res.setMapping(m);
							mappingData.put(m.getName()+  (m.hashCode()), res);
						int used=0;
						for(SourceSectionClass c : res.getSourceModelObjectsMapped().keySet()){
							if(!mappedSections.containsKey(c)){
								mappedSections.put(c,new LinkedHashSet<EObject>());
							}
							used+=res.getSourceModelObjectsMapped().get(c).size();
							mappedSections.get(c).addAll(res.getSourceModelObjectsMapped().get(c));
							
							contRefObjectsToMap.removeAll(res.getSourceModelObjectsMapped().get(c));//remove mapped elements from list of elements to be mapped
						}
						usedInMapping.put(res, String.valueOf(used));
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
					ItemSelectorDialogRunner dialog= new ItemSelectorDialogRunner("Please select a Mapping for the source element\n'" 
					+  EObjectTransformationHelper.asString(element) + "'" , 
								mappingData.keySet(), mappingData.keySet().iterator().next());
					Display.getDefault().syncExec(dialog);
					if(dialog.wasTransformationStopRequested()){
						transformationAborted=true;
						return null;
					}
					returnVal= mappingData.get(dialog.getSelection());
			}	
			
			if(returnVal != null){
				consoleStream.println(','  + returnVal.getMapping().getName() + ", " + usedInMapping.get(returnVal) + " ,  "+ time );

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
	 * Check if the container section referenced by the sourceSection Classe's container ref. was mapped.
	 * @param element
	 * @param sourceSectionClass
	 * @return true if the container attribute of the sourceSection Class doesn't exist or a fitting container instance exists
	 */
	private boolean doContainerCheck(EObject element, SourceSectionClass sourceSectionClass){
		if(sourceSectionClass.getContainer() != null){
			if(mappedSections.containsKey(sourceSectionClass.getContainer())){//was the container section instantiated
				for(EReference ref : sourceSectionClass.getContainer().getEClass().getEAllContainments()){
					
					//exclude references that are modeled in the srcSection, since they cannot, by definition, reference the element
					boolean refExistsInContainerSection=false;
					for(SourceSectionReference containerRef : sourceSectionClass.getContainer().getReferences()){
						if(ref.equals(containerRef.getEReference())){
							refExistsInContainerSection=true;
							break;
						}	
					}
					
					if(!refExistsInContainerSection){
						for(EObject instance : mappedSections.get(sourceSectionClass.getContainer())){//check for each instance
							Object refTargets=instance.eGet(ref);
							if(ref != null){
								if(ref.getUpperBound() == 1){
									if(refTargets.equals(element)){
										return true;
									}
								} else {
									@SuppressWarnings("unchecked")
									EList<EObject> refTargetsList=(EList<EObject>) refTargets;
									for(EObject t : refTargetsList){
										if(t.equals(element)){
											return true;
										}
									}
								}
							}
						}						
						
					}
				}
				return false; //if we reach this point, then no fitting container instance could be found   
			} else {
				return false;//no instances of the container exist => mapping must fail
			}
		} else {
			return true; //no container == srcModelSection will not be excluded
		}
	}

}
