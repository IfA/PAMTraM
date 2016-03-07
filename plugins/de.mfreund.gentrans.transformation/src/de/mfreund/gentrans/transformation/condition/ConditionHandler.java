package de.mfreund.gentrans.transformation.condition;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import pamtram.condition.And;
import pamtram.condition.ComplexCondition;
import pamtram.condition.Condition;
import pamtram.condition.MultipleConditionOperator;
import pamtram.condition.Not;
import pamtram.condition.Or;
import pamtram.condition.SingleConditionOperator;


/**
 * This class will be used to calculate conditions and store the result.
 * 
 * @author gkoltun
 */

public class ConditionHandler {

	/**
	 * Registry for values of checked conditions
	 */
	private final Map<ComplexCondition, Boolean> conditionRepository;
	
	public ConditionHandler(){
		conditionRepository = new HashMap<>();
	}
	
	/**
	 * This is the checkCondition-Method for SingleConditionOperators (e.g. And, Or). 
	 * It is only for collecting the arguments and calling the right Operator-Method.
	 * 
	 * @param complexCondition
	 * @return The calculated boolean result
	 */
	public boolean checkCondition(ComplexCondition complexCondition){
		
		boolean result = true;
		// Note: No modeled condition always returns true
		if(complexCondition == null){ 
			return true;
		} else {
			
			// First, we prove if that condition already have been checked
			if (conditionRepository.get(complexCondition) != null){
				result = conditionRepository.get(complexCondition);
				
			// Second, we have to calculate the value
			} else {
			
				if(complexCondition instanceof MultipleConditionOperator){
					result = checkConditionMultipleConditionOperator((MultipleConditionOperator) complexCondition);
				} else if(complexCondition instanceof SingleConditionOperator){
					result = checkConditionSingleConditionOperator((SingleConditionOperator) complexCondition);
				// It's only a single condition
				} else if (complexCondition instanceof Condition){
					result = true;//FIXME
				}
			}
			
		}
		return result;
	}

	/**
	 * This is the checkCondition-Method for SingleConditionOperators (e.g. And, Or). 
	 * It is only for collecting the arguments and calling the right Operator-Method.
	 * 
	 * @param args A list which contain all arguments of that operator
	 * @return The calculated boolean result
	 */
	private boolean checkConditionSingleConditionOperator(SingleConditionOperator condition) {

		if(condition instanceof Not){
			return checkConditionNot((Not) condition);
		}
		return false;
	}

	private boolean checkConditionNot(Not condition) {
		// Not Implementation
		if(condition.getCondPartRef()!=null){
			return !checkCondition(condition.getCondPartRef());
		} else if(condition.getCondPart()!=null){
			return !checkCondition(condition.getCondPart());
		}
		
		return false;
	}

	/**
	 * This is the checkCondition-Method for MultipleConditionOperators (e.g. And, Or). 
	 * It is only for collecting the arguments and calling the right Operator-Method.
	 * 
	 * @param args A list which contain all arguments of that operator
	 * @return The calculated boolean result
	 */
	private boolean checkConditionMultipleConditionOperator(MultipleConditionOperator  multipleCondition) {
		
		//Get and put all arguments in a new list
		EList<ComplexCondition> args = new BasicEList<ComplexCondition>(); 
		args.addAll(multipleCondition.getCondParts());
		args.addAll(multipleCondition.getCondPartsRef());
		
		if (multipleCondition instanceof And){
			return checkConditionAnd(args);
		} else if(multipleCondition instanceof Or){
			return checkConditionOr(args);
		}
		
		return false;
	}

	/**
	 * This is the checkCondition-Method for the AND-Operator.
	 * 
	 * @param args A list which contain all arguments of that operator
	 * @return The calculated boolean result
	 */
	private boolean checkConditionAnd(EList<ComplexCondition> args) {
		
		boolean result = true; // Note that is an And
		
		for(ComplexCondition arg: args){ // Iterate over all arguments
			
			result = result && this.checkCondition(arg);
			if (result==false){ // In order to save some time we break the loop after one argument returned false (And-Operator)
				break;
			}
		}
		
		return result;
	}

	/**
	 * This is the checkCondition-Method for the OR-Operator.
	 * 
	 * @param args A list which contain all arguments of that operator
	 * @return The calculated boolean result
	 */
	private boolean checkConditionOr(EList<ComplexCondition> args) {
		
		boolean result = false; // Note that is an Or
		
		for(ComplexCondition arg: args){ // Iterate over all arguments
			
			result = result || this.checkCondition(arg);
			if (result==true){ // In order to save some time we break the loop after one argument returned true (Or-Operator
				break;
			}
		}
		
		return result;
	}

}
