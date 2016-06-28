package de.mfreund.gentrans.transformation.condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.calculation.InstancePointerHandler;
import de.mfreund.gentrans.transformation.calculation.ReferenceableValueCalculator;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import pamtram.condition.And;
import pamtram.condition.AttributeCondition;
import pamtram.condition.ComparatorEnum;
import pamtram.condition.ComplexCondition;
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
import pamtram.metamodel.SourceSectionClass;


/**
 * This class will be used to evaluate conditions and store their result.
 * 
 * @author gkoltun
 */

public class ConditionHandler {

	/**
	 * A String that is reused whenever something goes wrong.
	 */
	private static final String RETURNING_TRUE_AS_DEFAULT = "Returning 'TRUE' as default.";

	/**
	 * Enum for possible results of a condition
	 */
	public enum CondResult{
		TRUE, FALSE
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
	 * This is the general checkCondition method. Based on the type of condition to be evaluated, it will forward to the
	 * specific checking methods (e.g. {@link #checkConditionAnd(And, MatchedSectionDescriptor)}).
	 * 
	 * @param complexCondition The {@link ComplexCondition} to check.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the condition shall be checked.
	 * @return The calculated {@link CondResult} (true, false).
	 */
	public CondResult checkCondition(ComplexCondition complexCondition, MatchedSectionDescriptor matchedSectionDescriptor){
		
		
		// Note: No modeled condition always returns true
		if(complexCondition == null){ 
			return CondResult.TRUE;
		}
			
		// First, we check if that condition already has been checked. In case we are dealing with a 'global'
		// condition, we may reuse this result.
		//
		if (conditionRepository.get(complexCondition) != null && !complexCondition.isLocalCondition()){
			return conditionRepository.get(complexCondition);
		}
			
		// Otherwise, we have to calculate the value
		CondResult result;
		
		if(complexCondition instanceof MultipleConditionOperator){
			
			result = checkConditionMultipleConditionOperator((MultipleConditionOperator) complexCondition, matchedSectionDescriptor);
			
		} else if(complexCondition instanceof SingleConditionOperator){
			
			result = checkConditionSingleConditionOperator((SingleConditionOperator) complexCondition, matchedSectionDescriptor);
			
		} else if(complexCondition instanceof AttributeCondition){
				
			result = checkAttributeCondition((AttributeCondition) complexCondition, matchedSectionDescriptor);
				
		} else if (complexCondition instanceof SectionCondition){
			
			result = checkSectionCondition((SectionCondition) complexCondition, matchedSectionDescriptor);
			
		} else {
			
			consoleStream.println("Condition '" + complexCondition.getName() + "' is of an unsupported type: '" + 
					complexCondition.eClass().getName() + "'. Return 'FALSE' by default!");
			result = CondResult.FALSE;
			
		}
		
		return result;
	}

	/**
	 * Check the given {@link SectionCondition} for the given {@link MatchedSectionDescriptor}.
	 * 
	 * @param sectionCondition The {@link SectionCondition} to check.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the given condition shall be checked.
	 * @return The {@link CondResult result} of the check.
	 */
	private CondResult checkSectionCondition(SectionCondition sectionCondition, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		// The Section referenced by the SectionCondition was not matched in the source model
		//
		if(!this.matchedSections.containsKey(sectionCondition.getConditionSectionRef().getContainingSection())){
			
			// For conditions where the referred Section shouldn't be part of a model
			if(sectionCondition.getValue() == 0 && sectionCondition.getComparator() == ComparatorEnum.EQ){
				
				return CondResult.TRUE;
				
			} else{
				
				return CondResult.FALSE;
			}
		}
			
		// Collect all instances for the selected MatchedSectionDescriptors
		//
		List<EObject> correspondEClassInstances = getInstancesToConsider(sectionCondition,
				matchedSectionDescriptor);
		
		// check Cardinality of the condition (e.g. the condition have to be at least 5 times true)
		boolean cardinalityRes = checkCardinality(sectionCondition.getValue(), correspondEClassInstances.size(), sectionCondition.getComparator());
		
		// store and return the result 
		CondResult result = cardinalityRes ? CondResult.TRUE : CondResult.FALSE;
		storeConditionResult(sectionCondition, result);
		return result;
			
	}

	/**
	 * Check the given {@link AttributeCondition} for the given {@link MatchedSectionDescriptor}.
	 * 
	 * @param attrCondition The {@link AttributeCondition} to check.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the given condition shall be checked.
	 * @return The {@link CondResult result} of the check.
	 */
	private CondResult checkAttributeCondition(AttributeCondition attrCondition, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		
		// Collect all instances for the selected MatchedSectionDescriptors
		//
		List<EObject> correspondEClassInstances = getInstancesToConsider(attrCondition, matchedSectionDescriptor);
		
		if(attrCondition.getConditionAttributeRef() == null) {
			consoleStream.println("No attribute modeled for AttributeCondition '" + attrCondition.getName() + "'."
					+ "Evaluating to 'TRUE' by default.");
			return CondResult.TRUE;
		}
		
		EAttribute attribute = attrCondition.getConditionAttributeRef().getAttribute();
		
		// Collect the values of the referenced EAttribute for each instance
		//
		List<Object> srcAttrValues = correspondEClassInstances.parallelStream().map(
				instance -> instance.eGet(attribute)).collect(Collectors.toList());
		
		/*
		 * First, we check if all the constraints are satisfied for every attribute value of an AttributeConditon
		 */
		ArrayList<Boolean> attrBoolResults = new ArrayList<>();
		
		for (Object srcAttrValue : srcAttrValues) {
		
			// convert Attribute value to String
			final String srcAttrAsString = attribute.getEType().getEPackage().getEFactoryInstance()
					.convertToString(attribute.getEAttributeType(), srcAttrValue);
			
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
							
							List<String> srcAttrRefValuesAsList = new ArrayList<>();
							RangeBound lowerBound = ((RangeConstraint) constraint).getLowerBound();
							RangeBound upperBound = ((RangeConstraint) constraint).getUpperBound();
							
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
							
							BasicEList<String> refValuesAsEList = new BasicEList<>(srcAttrRefValuesAsList); 
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
		if(cardinalityRes){
			
			storeConditionResult(attrCondition, CondResult.TRUE);
			return CondResult.TRUE;
			
		} else {
			
			storeConditionResult(attrCondition, CondResult.FALSE);
			return CondResult.FALSE;
			
		}
		
	}
	
	/**
	 * This collects and returns the list of {@link EObject EObjects} that
	 * need to be considered during the evaluation of the given {@link Condition} for the given
	 * {@link MatchedSectionDescriptor}.
	 * <p />
	 * Depending on whether the condition is a {@link Condition#isLocalCondition() local} condition
	 * and on the presence of {@link InstancePointer InstancePointers}, 
	 * only the elements represented by the given <em>matchedSectionDescriptor</em> or the elements
	 * represented by all suitable descriptors stored in the {@link #matchedSections} need to be considered.
	 * 
	 * @param condition The {@link Condition} to be checked.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} that the condition
	 * shall be checked for.
	 * @return The list of {@link EObject elements of the source model} that need to be 
	 * considered when checking the condition.
	 */
	private List<EObject> getInstancesToConsider(Condition condition,
			MatchedSectionDescriptor matchedSectionDescriptor) {
		
		// The SourceSection holding the attribute that the AttributeCondition is based on
		//
		SourceSection affectedSection;
		
		if(condition instanceof SectionCondition) {
			affectedSection = ((SectionCondition) condition).getConditionSectionRef().getContainingSection();
		} else if(condition instanceof AttributeCondition) {
			affectedSection = ((AttributeCondition) condition).getConditionAttributeRef().getContainingSection();
		} else {
			consoleStream.println("Unknown condition type '" + condition.eClass().getName() + "' found!");
			return new ArrayList<>();
		}
		
		List<MatchedSectionDescriptor> descriptorsToConsider;
		
		if(condition.isLocalCondition() && condition.getAdditionalConditionSpecification().isEmpty()) {
			
			// In case of a 'local' condition without any InstancePointers specified, 
			// we only consider the given 'matchedSectionDescriptor'.
			//
			descriptorsToConsider = Arrays.asList(matchedSectionDescriptor);
			
		} else {
			
			// In case of a 'global' condition or if an InstancePointer has been specified, we 
			// have to consider all 'descriptors' for the SourceSection  under consideration
			//
			descriptorsToConsider = this.matchedSections.get(affectedSection);
		}
		
		// Collect all instances for the selected MatchedSectionDescriptors
		//
		List<EObject> correspondEClassInstances = descriptorsToConsider.parallelStream()
				.flatMap(descriptor -> descriptor.getSourceModelObjectsMapped().get(affectedSection).stream())
				.collect(Collectors.toList());
		
		// Reduce the list of instances based on modeled InstancePointers
		//
		if(!correspondEClassInstances.isEmpty() && !condition.getAdditionalConditionSpecification().isEmpty()){
			
			for (InstancePointer instancePointer : condition.getAdditionalConditionSpecification()) {
				
				correspondEClassInstances = this.instancePointerHandler.getPointedInstanceByInstanceList(
						instancePointer, correspondEClassInstances, matchedSectionDescriptor);
			}
			
		}
		
		return correspondEClassInstances;
	}

	/**
	 * Store the given {@link CondResult} for the given {@link ComplexCondition} in the {@link #conditionRepository}.
	 * <p />
	 * Note: Result will only be stored in case of {@link ComplexCondition#isLocalCondition() global} conditions.
	 * 
	 * @param condition The {@link ComplexCondition} for that the result shall be stored.
	 * @param result The {@link CondResult} to be stored in the {@link #conditionRepository}.
	 */
	private void storeConditionResult(ComplexCondition condition, CondResult result) {
		
		// only store results for 'global' conditions
		if(!condition.isLocalCondition()) {
			this.conditionRepository.put(condition, result);
		}
	}
	
	/**
	 * Check the determined <em>isValue</em> cardinality against the required <em>refValue</em>
	 * cardinality while taking the given {@link ComparatorEnum} into account.
	 * 
	 * @param refValue The required cardinality.
	 * @param isValue The determined (actual) cardinality.
	 * @param comparator The {@link ComparatorEnum} describing how to compare the two cardinalities.
	 * @return '<em><b>true</b></em>' if the check succeeded, '<em><b>false</b></em>' otherwise.
	 */
	private boolean checkCardinality(int refValue, int isValue, ComparatorEnum comparator) {
		
		switch(comparator.getValue()){
		case ComparatorEnum.EQ_VALUE:
			
			return isValue == refValue;
			
		case ComparatorEnum.GE_VALUE:
			
			return isValue >= refValue;
			
		case ComparatorEnum.GT_VALUE:

			return isValue > refValue;
			
		case ComparatorEnum.LE_VALUE:

			return isValue <= refValue;
			
		case ComparatorEnum.LT_VALUE:

			return isValue < refValue;
			
		default:
			consoleStream.println("Message:\n ComparatorEnum" + comparator.getLiteral() + "not implemented yet!"
					+ RETURNING_TRUE_AS_DEFAULT);
			return true;
		}
	}

	/**
	 * This is the general checkCondition method for {@link SingleConditionOperator SingleConditionOperators}. 
	 * Based on the type of condition to be evaluated, it will forward to the
	 * specific checking methods.
	 * 
	 * @param condition The {@link SingleConditionOperator} to check.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the condition shall be checked.
	 * @return The calculated {@link CondResult} (true, false).
	 */
	private CondResult checkConditionSingleConditionOperator(SingleConditionOperator condition, MatchedSectionDescriptor matchedSectionDescriptor) {

		if(condition instanceof Not){
			return checkConditionNot((Not) condition, matchedSectionDescriptor);
		} else {
			// If we are here, some mistake is happened, more types could be supported in the future
			consoleStream.println("SingleConditionOperator type " + condition.getClass().getName() + " is not yet supported!"
					+ RETURNING_TRUE_AS_DEFAULT);
			return CondResult.TRUE;
		}		
	}

	/**
	 * This checks the given {@link Not} condition for the given {@link MatchedSectionDescriptor}.
	 * 
	 * @param condition The {@link Not} condition to check.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the condition shall be checked.
	 * @return The calculated {@link CondResult} (true, false).
	 */
	private CondResult checkConditionNot(Not condition, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		CondResult condTemp = CondResult.TRUE;
		
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
			
		} else {
			
			// If we are here, some mistake is happened
			// more types could be supported in the future
			consoleStream.println("Condition Enum type " + condTemp + " is not yet supported!"
					+ RETURNING_TRUE_AS_DEFAULT);
			return CondResult.TRUE;
		}
		
		return condTemp;
	}

	/**
	 * This is the general checkCondition method for {@link MultipleConditionOperator MultipleConditionOperators}. 
	 * Based on the type of condition to be evaluated, it will forward to the
	 * specific checking methods.
	 * 
	 * @param condition The {@link MultipleConditionOperator} to check.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the condition shall be checked.
	 * @return The calculated {@link CondResult} (true, false).
	 */
	private CondResult checkConditionMultipleConditionOperator(MultipleConditionOperator condition, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		if (condition instanceof And){
			return checkConditionAnd((And) condition, matchedSectionDescriptor);
			
		} else if(condition instanceof Or){
			return checkConditionOr((Or) condition, matchedSectionDescriptor);
			
		} else {
			// If we are here, some mistake is happened
			// more types could be supported in the future
			consoleStream.println("MultipleCondition type " + condition.getClass().getName() + " is not yet supported!"
					+ RETURNING_TRUE_AS_DEFAULT);
			return CondResult.TRUE;
		}	
	}

	/**
	 * This checks the given {@link And} condition for the given {@link MatchedSectionDescriptor}.
	 * 
	 * @param condition The {@link And} condition to check.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the condition shall be checked.
	 * @return The calculated {@link CondResult} (true, false).
	 */
	private CondResult checkConditionAnd(And condition, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		//Get and put all arguments in a new list
		EList<ComplexCondition> args = new BasicEList<>(); 
		args.addAll(condition.getCondParts());
		args.addAll(condition.getCondPartsRef());
		
		for(ComplexCondition arg: args){
			
			// In order to save some time we break the loop after one argument returned false (And-Operator)
			//
			if(checkCondition(arg, matchedSectionDescriptor) == CondResult.FALSE){
				return CondResult.FALSE;
			}
		}
		
		return CondResult.TRUE;
	}

	/**
	 * This checks the given {@link Or} condition for the given {@link MatchedSectionDescriptor}.
	 * 
	 * @param condition The {@link Or} condition to check.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the condition shall be checked.
	 * @return The calculated {@link CondResult} (true, false).
	 */
	private CondResult checkConditionOr(Or condition, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		//Get and put all arguments in a new list
		EList<ComplexCondition> args = new BasicEList<>(); 
		args.addAll(condition.getCondParts());
		args.addAll(condition.getCondPartsRef());
		
		for(ComplexCondition arg: args){
			
			// In order to save some time we break the loop after one argument returned false (And-Operator)
			//
			if(checkCondition(arg, matchedSectionDescriptor) == CondResult.TRUE){
				return CondResult.TRUE;
			}
		}
		
		return CondResult.FALSE;
	}

}
