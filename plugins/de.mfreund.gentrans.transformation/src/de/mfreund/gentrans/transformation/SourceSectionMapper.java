package de.mfreund.gentrans.transformation;

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

import pamtram.mapping.AttributeMappingSourceElementType;
import pamtram.mapping.CalculatorMapping;
import pamtram.mapping.ComplexAttribueMappingSourceElement;
import pamtram.mapping.ComplexAttributeMapping;
import pamtram.mapping.ComplexAttributeMatcher;
import pamtram.mapping.ComplexAttributeMatcherSourceElement;
import pamtram.mapping.ExpressionVariable;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.SimpleAttributeMapping;
import pamtram.mapping.SimpleAttributeMatcher;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
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
	private LinkedHashMap<Mapping,LinkedList<MappingHint>> mappingHints;
	/**
	 * Map Referencing the Class referenced by the ComplexAttributeMappingSourceElement that is buried deepest in the target Section,
	 * sorted by ComplexAttributeMapping.
	 */
	private LinkedHashMap<ComplexAttributeMapping,SourceSectionClass> deepestComplexAttrMappingSrcElementsByCmplxMapping;
	/**
	 * Map Referencing the Class referenced by the ExpressionVariable that is buried deepest in the target Section,
	 * sorted by CalculatorMapping.
	 */
	private LinkedHashMap<CalculatorMapping,SourceSectionClass> deepestCalcAttrMappingSrcElementsByCalcMapping;
	/**
	 * Map Referencing the Class referenced by the ComplexAttributeMatcherSourceElement that is buried deepest in the target Section,
	 * sorted by ComplexAttributeMatcher.
	 */
	private LinkedHashMap<ComplexAttributeMatcher, SourceSectionClass> deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher;
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
	 * @return true when user action was triggered to abort the transformation
	 */
	public boolean isTransformationAborted() {
		return transformationAborted;
	}

	/**
	 * @param mappingsToChooseFrom Mappings from the PAMTram model
	 * @param consoleStream Output stream for messages
	 */
	SourceSectionMapper(List<Mapping> mappingsToChooseFrom, MessageConsoleStream consoleStream) {
		mappedSections=new LinkedHashMap<SourceSectionClass,Set<EObject>> ();
		mappingHints=new  LinkedHashMap<Mapping,LinkedList<MappingHint>>();
		modelConnectionHints=new  LinkedHashMap<Mapping,LinkedList<ModelConnectionHint>>();
		deepestComplexAttrMappingSrcElementsByCmplxMapping= new LinkedHashMap<ComplexAttributeMapping,SourceSectionClass>();
		deepestCalcAttrMappingSrcElementsByCalcMapping = new LinkedHashMap<CalculatorMapping,SourceSectionClass>();
		deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher= new LinkedHashMap<ComplexAttributeMatcher, SourceSectionClass>();
		this.mappingsToChooseFrom=mappingsToChooseFrom;
		this.consoleStream=consoleStream;
		this.transformationAborted=false;
		
		//this will fill some maps...
		for(Mapping m : mappingsToChooseFrom){
			getModelConnectionHints(m);
			for(MappingHint h : getHints(m)){
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
		}
	}
	
	/**
	 * @param m Mapping
	 * @return MappingHints of all the Mappings MappingHintGroups.
	 */
	private List<MappingHint> getHints(Mapping m){
		if(!mappingHints.containsKey(m)){
			mappingHints.put(m, new LinkedList<MappingHint>());
			for(MappingHintGroup g : m.getMappingHintGroups()){
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
			srcElements.addAll(m.getSourceAttributeMappings());
			
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
			srcElements.addAll(m.getSourceAttributes());
			
			sortOutElements(srcElements, srcSection);
			if(srcElements.size() == 1){
				deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher.put(m,srcElements.iterator().next().getSource().getOwningClass());
				
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
			srcElements.addAll(m.getVariables());
			
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
			for(MappingHintGroup g : m.getMappingHintGroups()){
				if(g.getModelConnectionMatcher() != null){
					modelConnectionHints.get(m).add(g.getModelConnectionMatcher());					
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
	@SuppressWarnings("unchecked")
	private  MappingInstanceStorage findMappingIterate(
			EObject srcModelObject, boolean usedOkay,
			Iterable<MappingHint> hints,
			Iterable<ModelConnectionHint> connectionHints,
			SourceSectionClass srcSection,
			MappingInstanceStorage newRefsAndHints,
			LinkedHashMap<SourceSectionClass, EObject> srcInstanceMap) {

		boolean classFits= srcModelObject.eClass().equals(srcSection.getClass()) || srcSection.getEClass().isSuperTypeOf(srcModelObject.eClass());
		
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
		Map<ComplexAttribueMappingSourceElement,String> complexSourceElementHintValues=new LinkedHashMap<ComplexAttribueMappingSourceElement,String>();
		Map<ExpressionVariable,String> calcVariableHintValues=new LinkedHashMap<ExpressionVariable,String>();	
		Map<ComplexAttributeMatcherSourceElement,String> complexAttrMatcherSourceElementHintValues=new LinkedHashMap<ComplexAttributeMatcherSourceElement,String>();
		for (MappingHint hint : hints) {
			
			if( hint instanceof ComplexAttributeMapping 
					|| hint instanceof CalculatorMapping){//ComplexAttributeMappings are handled differently because we want to make them work across vc-sections 
				changedRefsAndHints.setHintValueList(hint, new LinkedList<Object>());	
				if(newRefsAndHints.getHintValues().containsKey(hint)){
					changedRefsAndHints.getHintValues().get(hint).addAll(newRefsAndHints.getHintValues().get(hint));//the cardinality of 
																												    //the existing hintval is either 0 or 1 at this point
				} else if(hint instanceof ComplexAttributeMapping){
					changedRefsAndHints.getHintValues().get(hint).add(new LinkedHashMap<ComplexAttributeMatcherSourceElement,String>());
				} else {
					changedRefsAndHints.getHintValues().get(hint).add(new LinkedHashMap<String,Double>());
				}
			} else if (hint instanceof MappingInstanceSelector) {
				if(((MappingInstanceSelector) hint).getMatcher() instanceof ComplexAttributeMatcher){
					changedRefsAndHints.setHintValueList(hint, new LinkedList<Object>());	
					if(newRefsAndHints.getHintValues().containsKey(hint)){
						changedRefsAndHints.getHintValues().get(hint).addAll(newRefsAndHints.getHintValues().get(hint));//the cardinality of 
																													    //the existing hintval is either 0 or 1 at this point
					} else {
						changedRefsAndHints.getHintValues().get(hint).add(new LinkedHashMap<ComplexAttributeMatcherSourceElement,String>());
					}					
				}
			}else {
				changedRefsAndHints.setHintValueList(hint, new LinkedList<Object>());				
			}

		}
		
		for (ModelConnectionHint hint : connectionHints) {

			changedRefsAndHints.setConnectionHintValueList(hint, new LinkedList<String>());
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
					if (!constraintVal && constraint.getType().equals(AttributeValueConstraintType.EXCLUSION)) {//TODO
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
				for (MappingHint hint : hints) {
					if (hint instanceof SimpleAttributeMapping) {
						if (((SimpleAttributeMapping) hint).getSource().equals(at)) {
							String valCopy = AttributeValueRegistry.applyAttributeValueModifiers(srcAttrAsString,((SimpleAttributeMapping) hint).getModifier());
							changedRefsAndHints.addHintValue(hint, valCopy);
						}
					} else if(hint instanceof ComplexAttributeMapping){
						for(ComplexAttribueMappingSourceElement m : ((ComplexAttributeMapping) hint).getSourceAttributeMappings()){
							if (m.getSource().equals(at)) {
								String valCopy = AttributeValueRegistry.applyAttributeValueModifiers(srcAttrAsString,m.getModifier());
								complexSourceElementHintValues.put(m,valCopy);
							}
						}
					} else if(hint instanceof CalculatorMapping){
						for(ExpressionVariable v : ((CalculatorMapping) hint).getVariables()){
							if(v.getSource().equals(at)){
								String valCopy = AttributeValueRegistry.applyAttributeValueModifiers(srcAttrAsString, v.getModifier());
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
								valCopy = AttributeValueRegistry.applyAttributeValueModifiers(valCopy,
										matcher.getModifier());
								changedRefsAndHints.addHintValue(hint, valCopy);
							} 
						} else if(((MappingInstanceSelector) hint).getMatcher() instanceof ComplexAttributeMatcher){
							
							ComplexAttributeMatcher matcher= (ComplexAttributeMatcher) ((MappingInstanceSelector) hint).getMatcher();
							for(ComplexAttributeMatcherSourceElement e : matcher.getSourceAttributes()){
								if(e.getSource().equals(at)){
									String valCopy = srcAttrAsString;
									valCopy = AttributeValueRegistry.applyAttributeValueModifiers(valCopy, e.getModifier());
									complexAttrMatcherSourceElementHintValues.put(e, valCopy);								
								}
							}
						}
					}
				}

				// ModelConnectionHint (is being handled in the same way as
				// MI-Selector with AttrMatcher)
				for (ModelConnectionHint hint : connectionHints) {
					if (hint.getSourceAttribute().equals(at)) {
						changedRefsAndHints.addModelConnectionHintValue(hint,
								srcAttrAsString);

					}

				}

			} else {// attribute not set / null
				consoleStream.println("Unset attribute");//TODO we probably don't want any output here
				return null;
			}
		}
		
		//now work on ComplexAttributeMappings and CalcMappings
		Set<ComplexAttributeMapping> complexAttributeMappingsFound=new HashSet<ComplexAttributeMapping>();
		Set<ComplexAttributeMatcher> complexAttributeMatchersFound=new HashSet<ComplexAttributeMatcher>();
		Set<CalculatorMapping> calculatorMappingsFound=new HashSet<CalculatorMapping>();		
		
		for(MappingHint h : hints){
			if(h instanceof ComplexAttributeMapping){
				Map<ComplexAttribueMappingSourceElement,String> foundValues=new LinkedHashMap<ComplexAttribueMappingSourceElement,String>();
				//append the complex hint value (cardinality either 0 or 1) with found values in right order
				for(ComplexAttribueMappingSourceElement s : ((ComplexAttributeMapping) h).getSourceAttributeMappings()){
					if(complexSourceElementHintValues.containsKey(s)){
						foundValues.put(s,complexSourceElementHintValues.get(s));
					}
				}
				
				if(foundValues.keySet().size() > 0){
					complexAttributeMappingsFound.add((ComplexAttributeMapping)h);
					
					foundValues.putAll((Map<ComplexAttribueMappingSourceElement,String>) changedRefsAndHints.getHintValues().get(h).remove());					
					changedRefsAndHints.getHintValues().get(h).add(foundValues);
				}				
			} else if(h instanceof MappingInstanceSelector){
				if (((MappingInstanceSelector) h).getMatcher() instanceof ComplexAttributeMatcher) {
					ComplexAttributeMatcher m =(ComplexAttributeMatcher)((MappingInstanceSelector) h).getMatcher();
					Map<ComplexAttributeMatcherSourceElement,String> foundValues=new LinkedHashMap<ComplexAttributeMatcherSourceElement,String>();
					//append the complex hint value (cardinality either 0 or 1) with found values in right order
					for(ComplexAttributeMatcherSourceElement s : m.getSourceAttributes()){
						if(complexAttrMatcherSourceElementHintValues.containsKey(s)){
							foundValues.put(s,complexAttrMatcherSourceElementHintValues.get(s));
						}
					}
					
					if(foundValues.keySet().size() > 0){
						complexAttributeMatchersFound.add(m);
						
						foundValues.putAll((Map<ComplexAttributeMatcherSourceElement,String>) changedRefsAndHints.getHintValues().get(h).remove());					
						changedRefsAndHints.getHintValues().get(h).add(foundValues);
					}	
				}
			} else if(h instanceof CalculatorMapping){
				Map<String,Double> foundValues=new LinkedHashMap<String,Double>();//we need this as an extra, since found values might be empty strings
				//append the complex hint value (cardinality either 0 or 1) with found values in right order
				for(ExpressionVariable v : ((CalculatorMapping) h).getVariables()){
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
					calcValues.putAll((Map<String,Double>) changedRefsAndHints.getHintValues().get(h).remove());					
					calcValues.putAll(foundValues);
					changedRefsAndHints.getHintValues().get(h).add(calcValues);
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
			if (reference.getEReference().getUpperBound() == 1
					&& reference.getValuesGeneric().size() == 1) {
				EObject refTargetObj = (EObject) refTarget;
				if (refTargetObj == null)
					return null;
				MappingInstanceStorage res = findMappingIterate(
						refTargetObj,
						(reference instanceof NonContainmentReference) || usedOkay
						, hints,
						connectionHints, reference.getValuesGeneric().get(0),
						changedRefsAndHints, srcInstanceMap);
				if(transformationAborted){
					return null;
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

			} else if (reference.getValuesGeneric().size() <= reference.getEReference()
					.getUpperBound()
					|| reference.getEReference().getUpperBound() == -1 // unbounded
					|| reference.getEReference().getUpperBound() == -2)// unspecified
			{
				// cast refTarget to EList
				LinkedList<EObject> refTargetL = new LinkedList<EObject>();
				refTargetL.addAll(((EList<EObject>) refTarget));
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
								(reference instanceof NonContainmentReference) || usedOkay,
								hints, connectionHints, val,
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
						consoleStream
								.println("we need to find a mapping for every srcModelElement (at: " + srcSection.getName() + " )" 
										+ EObjectTransformationHelper.asString(rt));
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

			} else {// cardinality doesn't match ==> rule not applicable
				return null;
			}
		}
		
		for(MappingHint h : hints){
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
					//("====== " + m.name + " ======").println;					
					
					res= findMappingIterate(element, false, getHints(m), getModelConnectionHints(m),
							m.getSourceMMSection(),
							new MappingInstanceStorage(),
							new LinkedHashMap<SourceSectionClass, EObject>());
					
					if(transformationAborted)
					{
						return null;
					}
					if(res != null){//if mapping possible add to list
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
	 * Check if the container section referenced by the sourceSection Classe's container ref. was mapped.
	 * @param element
	 * @param sourceSectionClass
	 * @return true if the container attribute of the sourceSection Class doesn't exist or a fitting container instance exists
	 */
	@SuppressWarnings("unchecked")
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
