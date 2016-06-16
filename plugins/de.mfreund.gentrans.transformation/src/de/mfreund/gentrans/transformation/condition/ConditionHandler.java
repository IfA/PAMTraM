package de.mfreund.gentrans.transformation.condition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.InstancePointerHandler;
import de.mfreund.gentrans.transformation.ReferenceableValueCalculator;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.matching.MatchedSectionDescriptor;
import pamtram.condition.And;
import pamtram.condition.AttributeCondition;
import pamtram.condition.ComparatorEnum;
import pamtram.condition.ComplexCondition;
import pamtram.condition.CondSettingEnum;
import pamtram.condition.Condition;
import pamtram.condition.MultipleConditionOperator;
import pamtram.condition.Not;
import pamtram.condition.Or;
import pamtram.condition.SectionCondition;
import pamtram.condition.SingleConditionOperator;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.MultipleReferencesAttributeValueConstraint;
import pamtram.metamodel.RangeBound;
import pamtram.metamodel.RangeConstraint;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.SingleReferenceAttributeValueConstraint;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;


/**
 * This class will be used to evaluate conditions and store their result.
 * 
 * @author gkoltun
 */

public class ConditionHandler {

	/**
	 * Enum for possible results of a condition
	 */
	public enum CondResult{
		TRUE, FALSE, IRRELEVANT
	}
	
	/**
	 * Registry for values of checked conditions
	 */
	private final Map<ComplexCondition, CondResult> conditionRepository;
	
	/**
	 * The console stream to be used to print messages.
	 */
	private MessageConsoleStream consoleStream;
	
	/**
	 * Registry for <em>source model objects</em> that have already been matched. The matched objects are stored in a map
	 * where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections; 
	
	/**
	 * This keeps track of all {@link AttributeValueConstraint AttributeValueConstraints} that could not be evaluated 
	 * so we don't need to send a potential error message twice. This might e.g. happen for a malformed regular expression
	 * in a {@link RegExMatcher}.
	 */
	private final Set<AttributeValueConstraint> attributeConditionConstraintsWithErrors;
	
	/**
	 * It will be used for calculating referenceValues that are needed for {@link AttributeCondition}s
	 */
	private ReferenceableValueCalculator refValueCalculator;
	
	/**
	 * It will be used for extract a more in detail specified Element which was more than one times matched
	 */
	private InstancePointerHandler instancePointerHandler;

	/**
	 * This creates an instance.
	 * 
	 * @param matchedSections The map of {@link SourceSection SourceSections} and associated {@link MatchedSectionDescriptor 
	 * MatchedSectionDescriptors} that result from the matching process.
	 * @param globalValues The <em>global values</em> (values of {@link FixedValue FixedValues} and {@link GlobalAttribute GlobalAttribute}) 
	 * defined in the PAMTraM model.
	 */
	public ConditionHandler(Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections, GlobalValueMap globalValues){
		
		this.matchedSections =  matchedSections;
		this.conditionRepository = new HashMap<>();
		this.attributeConditionConstraintsWithErrors = new HashSet<>();
		this.instancePointerHandler = new InstancePointerHandler(matchedSections, globalValues, consoleStream);
		this.refValueCalculator = new ReferenceableValueCalculator(globalValues, this.instancePointerHandler, consoleStream);
	}
	
	/**
	 * This is the general checkCondition-Method. It is only for collecting the arguments and calling the right Operator-Method.
	 * Note: Enum instead of boolean as return type is needed as 'CondSettingEnum' has the option 'NO_MATCHING_ACCEPTED', so
	 * the condition shouldn't influence.
	 * 
	 * @param complexCondition The {@link ComplexCondition} to check.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the condition shall be checked.
	 * @return The calculated Enum result (true, false, irrelevant)
	 */
	public CondResult checkCondition(ComplexCondition complexCondition, MatchedSectionDescriptor matchedSectionDescriptor){
		
		CondResult result = CondResult.TRUE;
		
		// Note: No modeled condition always returns true
		if(complexCondition == null){ 
			return CondResult.TRUE;
		} else {
			
			// First, we check if that condition already has been checked. In case we are dealing with a 'global'
			// condition, we may reuse this result.
			//
			if (conditionRepository.get(complexCondition) != null && !complexCondition.isLocalCondition()){
				result = conditionRepository.get(complexCondition);
				
			// Otherwise, we have to calculate the value
			} else {
			
				if(complexCondition instanceof MultipleConditionOperator){
					result = checkConditionMultipleConditionOperator((MultipleConditionOperator) complexCondition, matchedSectionDescriptor);
				} else if(complexCondition instanceof SingleConditionOperator){
					result = checkConditionSingleConditionOperator((SingleConditionOperator) complexCondition, matchedSectionDescriptor);
				} else if (complexCondition instanceof Condition){
					
					// Before evaluating, check 'DefaultSetting' (may we can break evaluating and save time)
					if(((Condition) complexCondition).getDefaultSetting() == CondSettingEnum.NO_MATCHING_ACCEPTED){
						if(complexCondition.eContainer() instanceof ComplexCondition){
							return CondResult.IRRELEVANT;
						} else{
							return CondResult.TRUE;
						}
					}
					
					if(complexCondition instanceof AttributeCondition){
						result = checkAttributeCondition((AttributeCondition) complexCondition, matchedSectionDescriptor);
					} else if (complexCondition instanceof SectionCondition){
						result = checkSectionCondition((SectionCondition) complexCondition, matchedSectionDescriptor);
					}
				}
			}
		}
		
		return result;
	}

	private CondResult checkSectionCondition(SectionCondition sectionCondition, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		boolean tempConditionRes = false;
		
		if(this.matchedSections.containsKey(sectionCondition.getConditionSectionRef().getContainingSection())){
			
			List<EObject> correspondEClassInstances = new BasicEList<>();
			
			for (MatchedSectionDescriptor descriptor : this.matchedSections.get(sectionCondition.getConditionSectionRef().getContainingSection())) {
				correspondEClassInstances.addAll(descriptor.getSourceModelObjectsMapped().get(sectionCondition.getConditionSectionRef()));
			}
			
			if(!sectionCondition.getAdditionalConditionSpecification().isEmpty()){
				correspondEClassInstances = this.instancePointerHandler.getPointedInstanceByInstanceList(sectionCondition.getAdditionalConditionSpecification().get(0), correspondEClassInstances, matchedSectionDescriptor);
			}
			
			// check Cardinality of the condition (e.g. the condition have to be at least 5 times true)
			boolean cardinalityRes = checkCardinality(sectionCondition.getValue(), correspondEClassInstances.size(), sectionCondition.getComparator());
			
			// return Result of this condition (and store result if its referred model objects already were marked as 'matched'
			if(cardinalityRes == true){
				if(tempConditionRes == false){
					storeConditionResult(sectionCondition, CondResult.TRUE);}
				return CondResult.TRUE;
			} else if(cardinalityRes == false){
				if(tempConditionRes == false){
					storeConditionResult(sectionCondition, CondResult.FALSE);}
				return CondResult.FALSE;
			} else{
				if(tempConditionRes == false){
					storeConditionResult(sectionCondition, CondResult.IRRELEVANT);}
				return CondResult.IRRELEVANT;
			}
		
		// return Result of this condition but does NOT!!! store result because it's not matched (may it will be matched later)
		} else {
			// For conditions where the referred Section shouldn't be part of a model
			if(sectionCondition.getValue() == 0 && sectionCondition.getComparator() == ComparatorEnum.EQ){
				return CondResult.TRUE;
			} else{
				return CondResult.FALSE;
			}
		}
	}

	private CondResult checkAttributeCondition(AttributeCondition attrCondition, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		boolean tempConditionRes = false;
		List<EObject> correspondEClassInstances = new BasicEList<>();
		List<InstancePointer> instPointersAsList;
		
		// As in 'checkSectionCondtion'-method we store the SourceSectionClass correspond to the given SourceSectionAttribute
		
		for (MatchedSectionDescriptor descriptor : this.matchedSections.get(attrCondition.getConditionAttributeRef().getContainingSection())) {
			correspondEClassInstances.addAll(descriptor.getSourceModelObjectsMapped().get(attrCondition.getConditionAttributeRef().eContainer()));
		}
		
		SourceSectionAttribute ssAttr = attrCondition.getConditionAttributeRef();
		
		if(correspondEClassInstances!= null && correspondEClassInstances.size() > 1){
			// Try to handle InstancePointer if modeled and to specify the needed EClassInstances
			instPointersAsList = attrCondition.getAdditionalConditionSpecification();					
			InstancePointer instPt = null;
			
			if(!instPointersAsList.isEmpty()){
				instPt = instPointersAsList.get(0); //actual we handle only one InstancePointer, so model a clear one!
			}
			
			if(instPt != null){
				// Note: Here we use getPointedInstanceByLIST - List-Method
				correspondEClassInstances = this.instancePointerHandler.getPointedInstanceByInstanceList(instPt, correspondEClassInstances, matchedSectionDescriptor);
			}
		}
		
		ArrayList<Object> srcAttrValues = new ArrayList<>();
		
		for(EObject PointedClass : correspondEClassInstances){
			/*
			 * As attributes may have a cardinality greater than 1, too, we have to handle
			 * every attribute value separately.
			 */
			srcAttrValues.add(PointedClass.eGet(ssAttr.getAttribute()));
		}
		
		/*
		 * First, we check if all the constraints are satisfied for every attribute value of an AttributeConditon
		 */
		ArrayList<Boolean> attrBoolResults = new ArrayList<>();
		
		for (Object srcAttrValue : srcAttrValues) {
		
			// convert Attribute value to String
			final String srcAttrAsString = ssAttr.getAttribute().getEType().getEPackage().getEFactoryInstance()
					.convertToString(ssAttr.getAttribute().getEAttributeType(), srcAttrValue);
			
			/*
			 * check AttributeValueConstraints
			 *
			 * Inclusions are OR connected
			 *
			 * Exclusions are NOR connected
			 */
			boolean inclusionMatched = false;
			boolean containsInclusions = false;
			boolean exclusionFailed = false;
			for (final AttributeValueConstraint constraint : attrCondition.getValueConstraint()) {
	
				if (attributeConditionConstraintsWithErrors.contains(constraint)) {
					continue;
				}
	
				boolean constraintVal=false;
				try {
					// Note: 'checkConstraint' already takes the type (INCLUSION/EXCLUSION) into consideration
					// Starting from now we have to differentiate between Single- and MultipleReferenceAttributeValueConstraints
					// and we need to extract the right reference Value(s) for each constraint
					
					if (constraint instanceof SingleReferenceAttributeValueConstraint){
						String srcAttrRefValAsString = refValueCalculator.calculateReferenceValue(constraint);
						constraintVal = ((SingleReferenceAttributeValueConstraint) constraint).checkConstraint(srcAttrAsString,srcAttrRefValAsString);
					} else if (constraint instanceof MultipleReferencesAttributeValueConstraint){
						
						if(constraint instanceof RangeConstraint){
							List<String> srcAttrRefValuesAsList = new ArrayList<String>();
							RangeBound lowerBound=((RangeConstraint) constraint).getLowerBound(), upperBound = ((RangeConstraint) constraint).getUpperBound();
							
							if(lowerBound != null){
								srcAttrRefValuesAsList.add(refValueCalculator.calculateReferenceValue(lowerBound));
							} else {
								srcAttrRefValuesAsList.add("null");
							}
							
							if(upperBound != null){
								srcAttrRefValuesAsList.add(refValueCalculator.calculateReferenceValue(upperBound));
							} else {
								srcAttrRefValuesAsList.add("null");
							}
							
							BasicEList<String> refValuesAsEList = new BasicEList<String>(srcAttrRefValuesAsList); 
							constraintVal = ((MultipleReferencesAttributeValueConstraint) constraint).checkConstraint(srcAttrAsString, refValuesAsEList);
							
						}  else {
							// If we are here, some mistake is happened
							// more types could be supported in the future
							// placeholder for other MultipleReferenceAttributeValueConstraints
							consoleStream.println("ReferenceableElement type " + constraint.getClass().getName() + " is not yet supported!");
						}
					}  else {
						// If we are here, some mistake is happened
						// more types could be supported in the future
						// placeholder for other MultipleReferenceAttributeValueConstraints
						consoleStream.println("ReferenceableElement type " + constraint.getClass().getName() + " is not yet supported!");
					}
				} catch (final Exception e) {
					attributeConditionConstraintsWithErrors.add(constraint);
					consoleStream.println("The AttributeCondition'" + constraint.getName() + " could not be evaluated and will be ignored. The following error was supplied:\n"
							+ e.getLocalizedMessage());
					continue;
				}
	
				if (!constraintVal && constraint.getType().equals(AttributeValueConstraintType.EXCLUSION)) {
					exclusionFailed = true;
					break;
				} else if (constraint.getType().equals(AttributeValueConstraintType.INCLUSION)) {
					containsInclusions = true;
					if (constraintVal) {
						inclusionMatched = true;
					}
				}
			}

			if ((!inclusionMatched && containsInclusions) || exclusionFailed) {
				attrBoolResults.add(false);
			} else {
				attrBoolResults.add(true);
			}
		}
		
		// check Cardinality of the condition (e.g. the condition have to be at least 5 times true)
		boolean cardinalityRes = checkCardinality(attrCondition.getValue(), Collections.frequency(attrBoolResults, true), attrCondition.getComparator());
		
		// return Result of this condition (and store result if its referred model objects already were marked as 'matched'
		if(cardinalityRes == true){
			if(tempConditionRes == false){
				storeConditionResult(attrCondition, CondResult.TRUE);}
			return CondResult.TRUE;
		} else if(cardinalityRes == false){
			if(tempConditionRes == false){
				storeConditionResult(attrCondition, CondResult.FALSE);}
			return CondResult.FALSE;
		} else{
			if(tempConditionRes == false){
				storeConditionResult(attrCondition, CondResult.IRRELEVANT);}
			return CondResult.IRRELEVANT;
		}
	}
	
	/**
	 * Store the given {@link CondResult} for the given {@link ComplexCondition} in the {@link #conditionRepository}.
	 * <p />
	 * Note: Result will only be stored in case of {@link ComplexCondition#isLocalCondition() global} conditions.
	 * @param condition
	 * @param result
	 */
	private void storeConditionResult(ComplexCondition condition, CondResult result) {
		
		// only store results for 'global' conditions
		if(!condition.isLocalCondition()) {
			this.conditionRepository.put(condition, result);
		}
	}
	
	private boolean checkCardinality(int refValue, int isValue, ComparatorEnum comparator) {
		boolean result = true;
		switch(comparator.getValue()){
		case ComparatorEnum.EQ_VALUE:
			if(isValue == refValue){
				result = true;
			}else{
				result = false;
			}
			break;
		case ComparatorEnum.GE_VALUE:
			if(isValue >= refValue){
				result = true;
			}else{
				result = false;
			}
			break;
		case ComparatorEnum.GT_VALUE:
			if(isValue > refValue){
				result = true;
			}else{
				result = false;
			}
			break;
		case ComparatorEnum.LE_VALUE:
			if(isValue <= refValue){
				result = true;
			}else{
				result = false;
			}
			break;
		case ComparatorEnum.LT_VALUE:
			if(isValue < refValue){
				result = true;
			}else{
				result = false;
			}
			break;
		default:
			consoleStream.println("Message:\n ComparatorEnum" + comparator.getLiteral() + "not implemented yet!");
		}
		return result;
	}

	private CondResult checkConditionSingleConditionOperator(SingleConditionOperator condition, MatchedSectionDescriptor matchedSectionDescriptor) {

		if(condition instanceof Not){
			return checkConditionNot((Not) condition, matchedSectionDescriptor);
		} else {
			// If we are here, some mistake is happened, more types could be supported in the future
			consoleStream.println("SingleConditionOperator type " + condition.getClass().getName() + " is not yet supported!");
			return CondResult.IRRELEVANT;
		}		
	}

	private CondResult checkConditionNot(Not condition, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		CondResult condTemp = CondResult.IRRELEVANT;
		// Not Implementation
		if(condition.getCondPartRef() != null){
			condTemp = checkCondition(condition.getCondPartRef(), matchedSectionDescriptor);
		} else if(condition.getCondPart() != null){
			condTemp = checkCondition(condition.getCondPart(), matchedSectionDescriptor);
		}   
		
		// Invert the result and return
		if(condTemp == CondResult.TRUE){
			condTemp = CondResult.FALSE;
		} else if(condTemp == CondResult.FALSE){
			condTemp = CondResult.TRUE;
		} else if(condTemp == CondResult.IRRELEVANT){ // In this case the condition is optional. So it does not influence the ComplexCondition. Therefore, we return true!
			condTemp = CondResult.TRUE;
		} else {
			// If we are here, some mistake is happened
			// more types could be supported in the future
			consoleStream.println("Condition Enum type " + condTemp + " is not yet supported!");
			return CondResult.IRRELEVANT;
		}
		
		// The following code also saves conditions. Since the result of a condition depends on a current mapping and their referred SourceSection,
		// this SourceSection may be not matched but considered!
		//this.conditionRepository.put(condition, condTemp);
		
		return condTemp;
	}

	private CondResult checkConditionMultipleConditionOperator(MultipleConditionOperator  multipleCondition, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		if (multipleCondition instanceof And){
			return checkConditionAnd((And) multipleCondition, matchedSectionDescriptor);
		} else if(multipleCondition instanceof Or){
			return checkConditionOr((Or) multipleCondition, matchedSectionDescriptor);
		} else {
			// If we are here, some mistake is happened
			// more types could be supported in the future
			consoleStream.println("MultipleCondition type " + multipleCondition.getClass().getName() + " is not yet supported!");
			return CondResult.IRRELEVANT;
		}	
	}


	private CondResult checkConditionAnd(And condition, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		//Get and put all arguments in a new list
		EList<ComplexCondition> args = new BasicEList<ComplexCondition>(); 
		args.addAll(condition.getCondParts());
		args.addAll(condition.getCondPartsRef());
		
		// And Implementation
		CondResult condTemp = CondResult.TRUE;
		
		for(ComplexCondition arg: args){
			condTemp = checkCondition(arg, matchedSectionDescriptor);
			if(condTemp == CondResult.FALSE){// In order to save some time we break the loop after one argument returned false (And-Operator)
				break;
			} else if(condTemp == CondResult.IRRELEVANT){
				condTemp = CondResult.TRUE;
			}
		}
		
		// The following code also saves conditions. Since the result of a condition depends on a current mapping and their referred SourceSection,
		// this SourceSection may be not matched but considered!
		//this.conditionRepository.put(condition, condTemp);
		
		return condTemp;
	}

	private CondResult checkConditionOr(Or condition, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		//Get and put all arguments in a new list
		EList<ComplexCondition> args = new BasicEList<ComplexCondition>(); 
		args.addAll(condition.getCondParts());
		args.addAll(condition.getCondPartsRef());
		
		//Or Implementation
		CondResult condTemp = CondResult.FALSE; // Note that is an Or
		
		for(ComplexCondition arg: args){
			condTemp = checkCondition(arg, matchedSectionDescriptor);
			if(condTemp == CondResult.TRUE){// In order to save some time we break the loop after one argument returned false (And-Operator)
				break;
			} else if(condTemp == CondResult.IRRELEVANT){
				condTemp =CondResult.FALSE;
			}
		}
		
		// The following code also saves conditions. Since the result of a condition depends on a current mapping and their referred SourceSection,
		// this SourceSection may be not matched but considered!
		// this.conditionRepository.put(condition, condTemp);
		
		return condTemp;
	}

}
