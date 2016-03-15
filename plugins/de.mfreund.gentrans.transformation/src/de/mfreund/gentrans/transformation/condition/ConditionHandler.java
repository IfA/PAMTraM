package de.mfreund.gentrans.transformation.condition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.ReferenceableValueCalculator;
import pamtram.condition.And;
import pamtram.condition.AttributeCondition;
import pamtram.condition.ComplexCondition;
import pamtram.condition.CondSettingEnum;
import pamtram.condition.Condition;
import pamtram.condition.MultipleConditionOperator;
import pamtram.condition.Not;
import pamtram.condition.Or;
import pamtram.condition.SectionCondition;
import pamtram.condition.SingleConditionOperator;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.MultipleReferencesAttributeValueConstraint;
import pamtram.metamodel.RangeConstraint;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.SingleReferenceAttributeValueConstraint;
import pamtram.metamodel.SourceSectionClass;


/**
 * This class will be used to calculate conditions and store the result.
 * 
 * @author gkoltun
 */

public class ConditionHandler {

	/**
	 * Enum for possible results of a condition
	 */
	public enum condResult{
		true_condition, false_condition, irrelevant_condition
	}
	
	/**
	 * Registry for values of checked conditions
	 */
	private final Map<ComplexCondition, condResult> conditionRepository;
	
	/**
	 * The console stream to be used to print messages.
	 */
	private MessageConsoleStream consoleStream;
	
	/**
	 * Registry for <em>source model objects</em> that have already been matched. The matched objects are stored in a map
	 * where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSections;
	
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

	
	public ConditionHandler(LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSections, ReferenceableValueCalculator refValueCalculator){
		this.matchedSections =  matchedSections;
		this.conditionRepository = new HashMap<>();
		this.attributeConditionConstraintsWithErrors = new HashSet<>();
		this.refValueCalculator = refValueCalculator;
		
	}
	
	/**
	 * This is the checkCondition-Method for SingleConditionOperators (e.g. And, Or). 
	 * It is only for collecting the arguments and calling the right Operator-Method.
	 * Note: Enum instead of boolean as returned type is needed as some models or model sections that are not matched
	 * but the condition should not influence the mapping
	 * 
	 * @param complexCondition
	 * @return The calculated Enum result (true, false, irrelevant)
	 */
	public condResult checkCondition(ComplexCondition complexCondition){
		
		condResult result = condResult.true_condition;
		// Note: No modeled condition always returns true
		if(complexCondition == null){ 
			return condResult.true_condition;
		} else {
			// First, we prove if that condition already have been checked
			if (conditionRepository.get(complexCondition) != null){
				result = conditionRepository.get(complexCondition);
				
			// Otherwise, we have to calculate the value
			} else {
			
				if(complexCondition instanceof MultipleConditionOperator){
					result = checkConditionMultipleConditionOperator((MultipleConditionOperator) complexCondition);
				} else if(complexCondition instanceof SingleConditionOperator){
					result = checkConditionSingleConditionOperator((SingleConditionOperator) complexCondition);
				// It's only a single condition
				} else if (complexCondition instanceof Condition){
					if(((Condition) complexCondition).getDefaultSetting() == CondSettingEnum.NO_MATCHING_ACCEPTED){
						return condResult.irrelevant_condition;
					}
					if(complexCondition instanceof AttributeCondition){
						result = checkAttributeCondition((AttributeCondition) complexCondition);
					} else if (complexCondition instanceof SectionCondition){
						result = checkSectionCondition((SectionCondition) complexCondition);
					}
				}
			}
		}
		return result;
	}

	private condResult checkSectionCondition(SectionCondition condition) {
		if(this.matchedSections.containsKey(condition) == true){
			return condResult.true_condition;
		} else if(this.matchedSections.containsKey(condition) == false){
			return condResult.false_condition;
		} else{
			return condResult.irrelevant_condition;
		}
	}

	private condResult checkAttributeCondition(AttributeCondition condition) {
		
		/*
		 * check AttributeValueConstraints
		 *
		 * Inclusions are OR connected
		 *
		 * Exclusions are NOR connected
		 */
		boolean inclusionMatched = false;
		boolean containsInclusions = false;
		for (final AttributeValueConstraint constraint : condition.getValueConstraint()) {

			if (attributeConditionConstraintsWithErrors.contains(constraint)) {
				continue;
			}

			boolean constraintVal=false; // TODO have to be initialized?!!
			try {
				// Note: 'checkConstraint' already takes the type (INCLUSION/EXCLUSION) into consideration
				// Starting from now we have to differentiate between Single- and MultipleReferenceAttributeValueConstraints
				// and we need to extract the right reference Value(s) for each constraint
				
				if (constraint instanceof SingleReferenceAttributeValueConstraint){
					String srcAttrRefValAsString = refValueCalculator.calculateReferenceValue(srcAttrValue); //TODO actually reference Values will be calculated for each loop 
					constraintVal = ((SingleReferenceAttributeValueConstraint) constraint).checkConstraint(srcAttrAsString,srcAttrRefValAsString);
				} else if (constraint instanceof MultipleReferencesAttributeValueConstraint){
					
					if(constraint instanceof RangeConstraint){
						List<String> srcAttrRefValuesAsList = new ArrayList<String>();
						srcAttrRefValuesAsList.add(refValueCalculator.calculateReferenceValue(((RangeConstraint) srcAttrValue).getLowerBound()));
						srcAttrRefValuesAsList.add(refValueCalculator.calculateReferenceValue(((RangeConstraint) srcAttrValue).getUpperBound()));
						
						BasicEList<String> RefValuesAsEList = new BasicEList<String>(srcAttrRefValuesAsList); // TODO Convert List to EList // Check it 
						constraintVal = ((MultipleReferencesAttributeValueConstraint) constraint).checkConstraint(srcAttrAsString,RefValuesAsEList);
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
				return condResult.false_condition;
			} else if (constraint.getType().equals(AttributeValueConstraintType.INCLUSION)) {
				containsInclusions = true;
				if (constraintVal) {
					inclusionMatched = true;
				}
			}
		}

		if (!inclusionMatched && containsInclusions) {
			return condResult.false_condition;
		}
		return condResult.irrelevant_condition;
	}

	/**
	 * This is the checkCondition-Method for SingleConditionOperators (e.g. And, Or). 
	 * It is only for collecting the arguments and calling the right Operator-Method.
	 * 
	 * @param args A list which contain all arguments of that operator
	 * @return The calculated boolean result
	 */
	private condResult checkConditionSingleConditionOperator(SingleConditionOperator condition) {

		if(condition instanceof Not){
			return checkConditionNot((Not) condition);
		}  else {
			// If we are here, some mistake is happened
			// more types could be supported in the future
			consoleStream.println("SingleConditionOperator type " + condition.getClass().getName() + " is not yet supported!");
			return condResult.irrelevant_condition;
		}		
	}

	private condResult checkConditionNot(Not condition) {
		
		condResult condTemp = condResult.irrelevant_condition;
		// Not Implementation
		if(condition.getCondPartRef()!=null){
			condTemp = checkCondition(condition.getCondPartRef());
		} else if(condition.getCondPart()!=null){
			condTemp = checkCondition(condition.getCondPart());
		}   else {
			// If we are here, some mistake is happened
			// more types could be supported in the future
			consoleStream.println("Condition Not type " + condition.getClass().getName() + " is not yet supported!");
			return condResult.irrelevant_condition;
		}
		// Invert the result and return
		if(condTemp == condResult.true_condition){
			condTemp = condResult.false_condition;
		} else if(condTemp == condResult.false_condition){
			condTemp = condResult.true_condition;
		} else if(condTemp == condResult.irrelevant_condition){ // In this case the condition is optional. So it does not influence the ComplexCondition
			condTemp = condResult.true_condition;
		}
		conditionRepository.put(condition, condTemp);
		return condTemp;
	}

	/**
	 * This is the checkCondition-Method for MultipleConditionOperators (e.g. And, Or). 
	 * It is only for collecting the arguments and calling the right Operator-Method.
	 * 
	 * @param args A list which contain all arguments of that operator
	 * @return The calculated boolean result
	 */
	private condResult checkConditionMultipleConditionOperator(MultipleConditionOperator  multipleCondition) {
		
		if (multipleCondition instanceof And){
			return checkConditionAnd((And) multipleCondition);
		} else if(multipleCondition instanceof Or){
			return checkConditionOr((Or) multipleCondition);
		} else {
			// If we are here, some mistake is happened
			// more types could be supported in the future
			consoleStream.println("MultipleCondition type " + multipleCondition.getClass().getName() + " is not yet supported!");
			return condResult.irrelevant_condition;
		}	
	}

	/**
	 * This is the checkCondition-Method for the AND-Operator.
	 * 
	 * @param args A list which contain all arguments of that operator
	 * @return The calculated boolean result
	 */
	private condResult checkConditionAnd(And condition) {
		
		//Get and put all arguments in a new list
		EList<ComplexCondition> args = new BasicEList<ComplexCondition>(); 
		args.addAll(condition.getCondParts());
		args.addAll(condition.getCondPartsRef());
		
		condResult condTemp = condResult.true_condition; //Note that is an And
		
		for(ComplexCondition arg: args){ // Iterate over all arguments
			condTemp = checkCondition(arg);
			if(condTemp == condResult.false_condition){// In order to save some time we break the loop after one argument returned false (And-Operator)
				break;
			}
		}
		conditionRepository.put(condition, condTemp);
		return condTemp;
	}

	/**
	 * This is the checkCondition-Method for the OR-Operator.
	 * 
	 * @param args A list which contain all arguments of that operator
	 * @return The calculated boolean result
	 */
	private condResult checkConditionOr(Or condition) {
		
		//Get and put all arguments in a new list
		EList<ComplexCondition> args = new BasicEList<ComplexCondition>(); 
		args.addAll(condition.getCondParts());
		args.addAll(condition.getCondPartsRef());
		
		condResult condTemp = condResult.false_condition; // Note that is an Or
		
		for(ComplexCondition arg: args){ // Iterate over all arguments
			condTemp = checkCondition(arg);
			if(condTemp == condResult.true_condition){// In order to save some time we break the loop after one argument returned false (And-Operator)
				break;
			}
		}
		conditionRepository.put(condition, condTemp);
		return condTemp;
	}
	
	/**
	 * This method does an update of class variable matched sections.
	 * 
	 * @param matchedSections A list of a all matched sections
	 */
	public void updateMatchedSections(LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSections){
		this.matchedSections = matchedSections;
	}
}
