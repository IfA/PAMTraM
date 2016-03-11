package de.mfreund.gentrans.transformation.condition;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.console.MessageConsoleStream;

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
	
	public ConditionHandler(){
		conditionRepository = new HashMap<>();
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

	private condResult checkSectionCondition(SectionCondition complexCondition) {
		// TODO Auto-generated method stub
		return condResult.irrelevant_condition;
	}

	private condResult checkAttributeCondition(AttributeCondition complexCondition) {
		// TODO Auto-generated method stub
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
}
