package de.mfreund.gentrans.transformation.condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.calculation.AttributeValueCalculator;
import de.mfreund.gentrans.transformation.calculation.AttributeValueConstraintReferenceValueCalculator;
import de.mfreund.gentrans.transformation.calculation.InstancePointerHandler;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import pamtram.ConditionalElement;
import pamtram.condition.And;
import pamtram.condition.ApplicationDependency;
import pamtram.condition.AttributeCondition;
import pamtram.condition.CardinalityCondition;
import pamtram.condition.ComparatorEnum;
import pamtram.condition.ComplexCondition;
import pamtram.condition.Condition;
import pamtram.condition.Not;
import pamtram.condition.Or;
import pamtram.condition.UnaryCondition;
import pamtram.condition.VariadicCondition;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.MultipleReferencesValueConstraint;
import pamtram.metamodel.RangeBound;
import pamtram.metamodel.RangeConstraint;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.SingleReferenceValueConstraint;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.ValueConstraint;
import pamtram.metamodel.ValueConstraintType;


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

		/**
		 * Represents a positive evaluation of the condition.
		 */
		TRUE,

		/**
		 * Represents a negative evaluation of the condition.
		 */
		FALSE
	}

	/**
	 * Registry for values of checked conditions
	 */
	private final Map<ComplexCondition, CondResult> conditionRepository;

	/**
	 * The {@link Logger} be used to print messages.
	 */
	private Logger logger;

	/**
	 * Registry for <em>source model objects</em> that have already been matched. The matched objects are stored in a map
	 * where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections;

	/**
	 * This keeps track of all {@link ValueConstraint AttributeValueConstraints} that could not be evaluated
	 * so we don't need to send a potential error message twice. This might e.g. happen for a malformed regular expression
	 * in a {@link RegExMatcher}.
	 */
	private final Set<ValueConstraint> attributeConditionConstraintsWithErrors;

	/**
	 * It will be used for calculating referenceValues that are needed for {@link AttributeCondition}s
	 */
	private AttributeValueConstraintReferenceValueCalculator refValueCalculator;

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
	 * @param attributeValueCalculator The {@link AttributeValueCalculator} to use in order to calculate
	 * resulting values.
	 */
	public ConditionHandler(Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections,
			GlobalValueMap globalValues, AttributeValueCalculator attributeValueCalculator){

		this.matchedSections =  matchedSections;
		this.conditionRepository = new HashMap<>();
		this.attributeConditionConstraintsWithErrors = new HashSet<>();
		this.instancePointerHandler = new InstancePointerHandler(matchedSections, globalValues,
				attributeValueCalculator, this.logger);
		this.refValueCalculator = new AttributeValueConstraintReferenceValueCalculator(
				matchedSections, globalValues, this.instancePointerHandler, attributeValueCalculator, this.logger);
	}

	/**
	 * This is the general checkCondition method. Based on the type of condition to be evaluated, it will forward to the
	 * specific checking methods (e.g. {@link #checkConditionAnd(And, MatchedSectionDescriptor, Map)}).
	 *
	 * @param complexCondition
	 *            The {@link ComplexCondition} to check.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the condition shall be checked.
	 * @param mappingInstances
	 *            A map relating the already created {@link MappingInstanceStorage mapping instances} to their mappings.
	 *            This is required for checking {@link ApplicationDependency ApplicationDependencies}.
	 * @return The calculated {@link CondResult} (true, false).
	 */
	public CondResult checkCondition(ComplexCondition complexCondition,
			MatchedSectionDescriptor matchedSectionDescriptor,
			Map<Mapping, List<MappingInstanceStorage>> mappingInstances) {


		// Note: No modeled condition always returns true
		if(complexCondition == null){
			return CondResult.TRUE;
		}

		// First, we check if that condition already has been checked. In case we are dealing with a 'global'
		// condition, we may reuse this result.
		//
		if (this.conditionRepository.get(complexCondition) != null && !complexCondition.isLocalCondition()){
			return this.conditionRepository.get(complexCondition);
		}

		// Otherwise, we have to calculate the value
		CondResult result;

		if(complexCondition instanceof VariadicCondition){

			result = this.checkVariadicCondition((VariadicCondition) complexCondition,
					matchedSectionDescriptor, mappingInstances);

		} else if(complexCondition instanceof UnaryCondition){

			result = this.checkUnaryCondition((UnaryCondition) complexCondition,
					matchedSectionDescriptor, mappingInstances);

		} else if(complexCondition instanceof AttributeCondition){

			result = this.checkAttributeCondition((AttributeCondition) complexCondition, matchedSectionDescriptor);

		} else if (complexCondition instanceof CardinalityCondition){

			result = this.checkCardinalityCondition((CardinalityCondition) complexCondition, matchedSectionDescriptor);

		} else if (complexCondition instanceof ApplicationDependency) {

			result = this.checkApplicationDependency((ApplicationDependency) complexCondition, matchedSectionDescriptor,
					mappingInstances);

		} else {

			this.logger.severe("Condition '" + complexCondition.getName() + "' is of an unsupported type: '"
					+
					complexCondition.eClass().getName() + "'. Return 'FALSE' by default!");
			result = CondResult.FALSE;

		}

		return result;
	}

	/**
	 * Check the given {@link CardinalityCondition} for the given {@link MatchedSectionDescriptor}.
	 *
	 * @param sectionCondition The {@link CardinalityCondition} to check.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the given condition shall be checked.
	 * @return The {@link CondResult result} of the check.
	 */
	private CondResult checkCardinalityCondition(CardinalityCondition sectionCondition, MatchedSectionDescriptor matchedSectionDescriptor) {

		// The Section referenced by the CardinalityCondition was not matched in the source model
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
		List<EObject> correspondEClassInstances = this.getInstancesToConsider(sectionCondition,
				matchedSectionDescriptor);

		// check Cardinality of the condition (e.g. the condition have to be at least 5 times true)
		boolean cardinalityRes = this.checkCardinality(sectionCondition.getValue(), correspondEClassInstances.size(), sectionCondition.getComparator());

		// store and return the result
		CondResult result = cardinalityRes ? CondResult.TRUE : CondResult.FALSE;
		this.storeConditionResult(sectionCondition, result);
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
		List<EObject> correspondEClassInstances = this.getInstancesToConsider(attrCondition, matchedSectionDescriptor);

		if(attrCondition.getConditionAttributeRef() == null) {
			this.logger.warning("No attribute modeled for AttributeCondition '" + attrCondition.getName() + "'."
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
			for (final ValueConstraint constraint : attrCondition.getValueConstraint()) {

				if (this.attributeConditionConstraintsWithErrors.contains(constraint)) {
					continue;
				}

				boolean constraintVal=false;
				try {
					// Note: 'checkConstraint' already takes the type (INCLUSION/EXCLUSION) into consideration
					// Starting from now we have to differentiate between Single- and MultipleReferenceAttributeValueConstraints
					// and we need to extract the right reference Value(s) for each constraint

					if (constraint instanceof SingleReferenceValueConstraint){
						String srcAttrRefValAsString = this.refValueCalculator.calculateReferenceValue(constraint, matchedSectionDescriptor);
						constraintVal = ((SingleReferenceValueConstraint) constraint).checkConstraint(srcAttrAsString,srcAttrRefValAsString);
					} else if (constraint instanceof MultipleReferencesValueConstraint){

						if(constraint instanceof RangeConstraint){

							List<String> srcAttrRefValuesAsList = new ArrayList<>();
							RangeBound lowerBound = ((RangeConstraint) constraint).getLowerBound();
							RangeBound upperBound = ((RangeConstraint) constraint).getUpperBound();

							if(lowerBound != null){
								srcAttrRefValuesAsList.add(this.refValueCalculator.calculateReferenceValue(lowerBound, matchedSectionDescriptor));
							} else {
								srcAttrRefValuesAsList.add("null");
							}

							if(upperBound != null){
								srcAttrRefValuesAsList.add(this.refValueCalculator.calculateReferenceValue(upperBound, matchedSectionDescriptor));
							} else {
								srcAttrRefValuesAsList.add("null");
							}

							BasicEList<String> refValuesAsEList = new BasicEList<>(srcAttrRefValuesAsList);
							constraintVal = ((MultipleReferencesValueConstraint) constraint).checkConstraint(srcAttrAsString, refValuesAsEList);

						}  else {

							// If we are here, some mistake is happened
							// more types could be supported in the future
							// placeholder for other MultipleReferenceAttributeValueConstraints
							this.logger.severe("ReferenceableElement type " + constraint.getClass().getName()
									+ " is not yet supported!");

						}

					}  else {
						// If we are here, some mistake is happened
						// more types could be supported in the future
						// placeholder for other MultipleReferenceAttributeValueConstraints
						this.logger.severe("ReferenceableElement type " + constraint.getClass().getName()
								+ " is not yet supported!");
					}
				} catch (final Exception e) {

					this.attributeConditionConstraintsWithErrors.add(constraint);
					this.logger.warning("The AttributeCondition'" + constraint.getName()
					+ " could not be evaluated and will be ignored. The following error was supplied:\n"
					+ e.getLocalizedMessage());
					continue;

				}

				if (!constraintVal && constraint.getType().equals(ValueConstraintType.EXCLUSION)) {

					exclusionFailed = true;
					break;

				} else if (constraint.getType().equals(ValueConstraintType.INCLUSION)) {

					containsInclusions = true;
					if (constraintVal) {
						inclusionMatched = true;
					}
				}
			}

			if (!inclusionMatched && containsInclusions || exclusionFailed) {
				attrBoolResults.add(false);

			} else {
				attrBoolResults.add(true);

			}
		}

		// check Cardinality of the condition (e.g. the condition have to be at least 5 times true)
		boolean cardinalityRes = this.checkCardinality(attrCondition.getValue(), Collections.frequency(attrBoolResults, true), attrCondition.getComparator());

		// return Result of this condition (and store result if its referred model objects already were marked as 'matched'
		if(cardinalityRes){

			this.storeConditionResult(attrCondition, CondResult.TRUE);
			return CondResult.TRUE;

		} else {

			this.storeConditionResult(attrCondition, CondResult.FALSE);
			return CondResult.FALSE;

		}

	}

	/**
	 * Check the given {@link ApplicationDependency} for the given {@link MatchedSectionDescriptor}.
	 *
	 * @param applicationDependency
	 *            The {@link ApplicationDependency} to check.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the given condition shall be checked.
	 * @param mappingInstances
	 *            A map relating the already created {@link MappingInstanceStorage mapping instances} to their mappings.
	 * @return The {@link CondResult result} of the check.
	 */
	private CondResult checkApplicationDependency(ApplicationDependency applicationDependency,
			MatchedSectionDescriptor matchedSectionDescriptor,
			Map<Mapping, List<MappingInstanceStorage>> mappingInstances) {


		// The Section referenced by the SectionCondition was not matched in the source model
		//
		if (applicationDependency.getConditionalElement() instanceof Mapping) {

			// mapping has not been applied
			//
			if (!mappingInstances.containsKey(applicationDependency.getConditionalElement())) {

				// check Cardinality of the condition (e.g. the condition have to be at least 5 times true)
				boolean cardinalityRes = this.checkCardinality(applicationDependency.getValue(), 0,
						applicationDependency.getComparator());

				// return Result of this condition (and store result if its referred model objects already were marked
				// as 'matched'
				if (cardinalityRes) {

					this.storeConditionResult(applicationDependency, CondResult.TRUE);
					return CondResult.TRUE;

				} else {

					this.storeConditionResult(applicationDependency, CondResult.FALSE);
					return CondResult.FALSE;

				}
			}

			// mapping has been applied
			//
			List<MappingInstanceStorage> storageInstances = mappingInstances
					.get(applicationDependency.getConditionalElement());

			// no instance pointers
			if (applicationDependency.getAdditionalConditionSpecification().isEmpty()) {

				// check Cardinality of the condition (e.g. the condition have to be at least 5 times true)
				boolean cardinalityRes = this.checkCardinality(applicationDependency.getValue(),
						storageInstances.size(), applicationDependency.getComparator());

				// return Result of this condition (and store result if its referred model objects already were marked
				// as 'matched'
				if (cardinalityRes) {

					this.storeConditionResult(applicationDependency, CondResult.TRUE);
					return CondResult.TRUE;

				} else {

					this.storeConditionResult(applicationDependency, CondResult.FALSE);
					return CondResult.FALSE;

				}
			}

			// instance pointers

			List<EObject> instancesToConsider = this.getInstancesToConsider(applicationDependency,
					matchedSectionDescriptor);

			// check Cardinality of the condition (e.g. the condition have to be at least 5 times true)
			boolean cardinalityRes = this.checkCardinality(applicationDependency.getValue(), instancesToConsider.size(),
					applicationDependency.getComparator());

			if (!cardinalityRes) {

				this.storeConditionResult(applicationDependency, CondResult.FALSE);
				return CondResult.FALSE;

			}

			for (EObject instanceToConsider : instancesToConsider) {
				if (!storageInstances.parallelStream().map(m -> m.getMatchedSectionDescriptor())
						.anyMatch(m -> m.getAssociatedSourceModelElement().equals(instanceToConsider))) {
					this.storeConditionResult(applicationDependency, CondResult.FALSE);
					return CondResult.FALSE;
				}
			}

			CondResult result = CondResult.TRUE;
			this.storeConditionResult(applicationDependency, result);
			return result;

		}

		CondResult result = CondResult.FALSE;
		this.storeConditionResult(applicationDependency, result);
		return result;
	}

	/**
	 * This collects and returns the list of {@link EObject EObjects} that need to be considered during the evaluation
	 * of the given {@link Condition} for the given {@link MatchedSectionDescriptor}.
	 * <p />
	 * Depending on whether the condition is a {@link Condition#isLocalCondition() local} condition and on the presence
	 * of {@link InstancePointer InstancePointers}, only the elements represented by the given
	 * <em>matchedSectionDescriptor</em> or the elements represented by all suitable descriptors stored in the
	 * {@link #matchedSections} need to be considered.
	 *
	 * @param condition
	 *            The {@link Condition} to be checked.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} that the condition shall be checked for.
	 * @return The list of {@link EObject elements of the source model} that need to be considered when checking the
	 *         condition.
	 */
	private List<EObject> getInstancesToConsider(Condition condition,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		// The SourceSection holding the attribute that the AttributeCondition is based on
		//
		SourceSection affectedSection;

		if(condition instanceof CardinalityCondition) {
			affectedSection = ((CardinalityCondition) condition).getConditionSectionRef().getContainingSection();
		} else if(condition instanceof AttributeCondition) {
			affectedSection = ((AttributeCondition) condition).getConditionAttributeRef().getContainingSection();
		} else if (condition instanceof ApplicationDependency) {
			ConditionalElement conditionalElement = ((ApplicationDependency) condition).getConditionalElement();
			if (conditionalElement instanceof Mapping) {
				affectedSection = ((Mapping) conditionalElement).getSourceSection();
			} else if (conditionalElement instanceof InstantiableMappingHintGroup) {
				affectedSection = ((Mapping) conditionalElement.eContainer()).getSourceSection();
			} else if (conditionalElement instanceof MappingHint) {
				affectedSection = ((Mapping) conditionalElement.eContainer().eContainer()).getSourceSection();
			} else {
				this.logger.severe(
						"Unknown type of ConditionalElement '" + conditionalElement.eClass().getName() + "' found!");
				return new ArrayList<>();
			}
		} else {
			this.logger.severe("Unknown condition type '" + condition.eClass().getName() + "' found!");
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
				this.logger.severe("Message:\n ComparatorEnum" + comparator.getLiteral() + "not implemented yet!"
						+ ConditionHandler.RETURNING_TRUE_AS_DEFAULT);
				return true;
		}
	}

	/**
	 * This is the general checkCondition method for {@link UnaryCondition UnaryConditions}. Based on the type of
	 * condition to be evaluated, it will forward to the specific checking methods.
	 *
	 * @param condition
	 *            The {@link UnaryCondition} to check.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the condition shall be checked.
	 * @param mappingInstances
	 *            A map relating the already created {@link MappingInstanceStorage mapping instances} to their mappings.
	 *            This is required for checking {@link ApplicationDependency ApplicationDependencies}.
	 * @return The calculated {@link CondResult} (true, false).
	 */
	private CondResult checkUnaryCondition(UnaryCondition condition,
			MatchedSectionDescriptor matchedSectionDescriptor,
			Map<Mapping, List<MappingInstanceStorage>> mappingInstances) {

		if(condition instanceof Not){
			return this.checkConditionNot((Not) condition, matchedSectionDescriptor, mappingInstances);
		} else {
			// If we are here, some mistake is happened, more types could be supported in the future
			this.logger.severe("SingleConditionOperator type " + condition.getClass().getName() + " is not yet supported!"
					+ ConditionHandler.RETURNING_TRUE_AS_DEFAULT);
			return CondResult.TRUE;
		}
	}

	/**
	 * This checks the given {@link Not} condition for the given {@link MatchedSectionDescriptor}.
	 *
	 * @param condition
	 *            The {@link Not} condition to check.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the condition shall be checked.
	 * @param mappingInstances
	 *            A map relating the already created {@link MappingInstanceStorage mapping instances} to their mappings.
	 *            This is required for checking {@link ApplicationDependency ApplicationDependencies}.
	 * @return The calculated {@link CondResult} (true, false).
	 */
	private CondResult checkConditionNot(Not condition, MatchedSectionDescriptor matchedSectionDescriptor,
			Map<Mapping, List<MappingInstanceStorage>> mappingInstances) {

		CondResult condTemp = CondResult.TRUE;

		// Not Implementation
		if (condition.getSharedCondPart() != null) {
			condTemp = this.checkCondition(condition.getSharedCondPart(), matchedSectionDescriptor, mappingInstances);
		} else if(condition.getLocalCondPart() != null){
			condTemp = this.checkCondition(condition.getLocalCondPart(), matchedSectionDescriptor, mappingInstances);
		}

		// Invert the result and return
		if(condTemp == CondResult.TRUE){
			condTemp = CondResult.FALSE;

		} else if(condTemp == CondResult.FALSE){
			condTemp = CondResult.TRUE;

		} else {

			// If we are here, some mistake is happened
			// more types could be supported in the future
			this.logger.severe("Condition Enum type " + condTemp + " is not yet supported!"
					+ ConditionHandler.RETURNING_TRUE_AS_DEFAULT);
			return CondResult.TRUE;
		}

		return condTemp;
	}

	/**
	 * This is the general checkCondition method for {@link VariadicCondition VariadicConditions}. Based on the type of
	 * condition to be evaluated, it will forward to the specific checking methods.
	 *
	 * @param condition
	 *            The {@link VariadicCondition} to check.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the condition shall be checked.
	 * @param mappingInstances
	 *            A map relating the already created {@link MappingInstanceStorage mapping instances} to their mappings.
	 *            This is required for checking {@link ApplicationDependency ApplicationDependencies}.
	 * @return The calculated {@link CondResult} (true, false).
	 */
	private CondResult checkVariadicCondition(VariadicCondition condition,
			MatchedSectionDescriptor matchedSectionDescriptor,
			Map<Mapping, List<MappingInstanceStorage>> mappingInstances) {

		if (condition instanceof And){
			return this.checkConditionAnd((And) condition, matchedSectionDescriptor, mappingInstances);

		} else if(condition instanceof Or){
			return this.checkConditionOr((Or) condition, matchedSectionDescriptor, mappingInstances);

		} else {
			// If we are here, some mistake is happened
			// more types could be supported in the future
			this.logger.severe("MultipleCondition type " + condition.getClass().getName() + " is not yet supported!"
					+ ConditionHandler.RETURNING_TRUE_AS_DEFAULT);
			return CondResult.TRUE;
		}
	}

	/**
	 * This checks the given {@link And} condition for the given {@link MatchedSectionDescriptor}.
	 *
	 * @param condition
	 *            The {@link And} condition to check.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the condition shall be checked.
	 * @param mappingInstances
	 *            A map relating the already created {@link MappingInstanceStorage mapping instances} to their mappings.
	 *            This is required for checking {@link ApplicationDependency ApplicationDependencies}.
	 * @return The calculated {@link CondResult} (true, false).
	 */
	private CondResult checkConditionAnd(And condition, MatchedSectionDescriptor matchedSectionDescriptor,
			Map<Mapping, List<MappingInstanceStorage>> mappingInstances) {

		//Get and put all arguments in a new list
		EList<ComplexCondition> args = new BasicEList<>();
		args.addAll(condition.getLocalCondParts());
		args.addAll(condition.getSharedCondParts());

		for(ComplexCondition arg: args){

			// In order to save some time we break the loop after one argument returned false (And-Operator)
			//
			if (this.checkCondition(arg, matchedSectionDescriptor, mappingInstances) == CondResult.FALSE) {
				return CondResult.FALSE;
			}
		}

		return CondResult.TRUE;
	}

	/**
	 * This checks the given {@link Or} condition for the given {@link MatchedSectionDescriptor}.
	 *
	 * @param condition
	 *            The {@link Or} condition to check.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the condition shall be checked.
	 * @param mappingInstances
	 *            A map relating the already created {@link MappingInstanceStorage mapping instances} to their mappings.
	 *            This is required for checking {@link ApplicationDependency ApplicationDependencies}.
	 * @return The calculated {@link CondResult} (true, false).
	 */
	private CondResult checkConditionOr(Or condition, MatchedSectionDescriptor matchedSectionDescriptor,
			Map<Mapping, List<MappingInstanceStorage>> mappingInstances) {

		//Get and put all arguments in a new list
		EList<ComplexCondition> args = new BasicEList<>();
		args.addAll(condition.getLocalCondParts());
		args.addAll(condition.getSharedCondParts());

		for(ComplexCondition arg: args){

			// In order to save some time we break the loop after one argument returned false (And-Operator)
			//
			if (this.checkCondition(arg, matchedSectionDescriptor, mappingInstances) == CondResult.TRUE) {
				return CondResult.TRUE;
			}
		}

		return CondResult.FALSE;
	}

}
