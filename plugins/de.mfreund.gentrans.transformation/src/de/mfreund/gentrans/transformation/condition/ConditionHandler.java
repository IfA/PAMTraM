package de.mfreund.gentrans.transformation.condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.calculation.InstanceSelectorHandler;
import de.mfreund.gentrans.transformation.calculation.ValueConstraintReferenceValueCalculator;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.matching.ValueExtractor;
import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
import de.mfreund.gentrans.transformation.registries.SelectedMappingRegistry;
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
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.extended.MappingHint;
import pamtram.structure.InstanceSelector;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.constraint.ChoiceConstraint;
import pamtram.structure.constraint.EqualityConstraint;
import pamtram.structure.constraint.SingleReferenceValueConstraint;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.constraint.ValueConstraintType;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;

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
	public enum CondResult {

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
	 * Registry for <em>source model objects</em> that have already been matched. The matched objects are stored in a
	 * map where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private MatchedSectionRegistry matchedSections;

	/**
	 * The {@link SelectedMappingRegistry} where selected {@link Mapping Mappings} as well as associated
	 * {@link MappingInstanceStorage Mapping instances} are stored. This registry is consulted when checking
	 * {@link ApplicationDependency ApplicationDependencies}.
	 */
	private SelectedMappingRegistry selectedMappingRegistry;

	/**
	 * This keeps track of all {@link ValueConstraint AttributeValueConstraints} that could not be evaluated so we don't
	 * need to send a potential error message twice. This might e.g. happen for a malformed regular expression in a
	 * {@link RegExConstraint}.
	 */
	private final Set<ValueConstraint> attributeConditionConstraintsWithErrors;

	/**
	 * It will be used for calculating referenceValues that are needed for {@link AttributeCondition}s
	 */
	private ValueConstraintReferenceValueCalculator refValueCalculator;

	/**
	 * It will be used for extract a more in detail specified Element which was more than one times matched
	 */
	private InstanceSelectorHandler instanceSelectorHandler;

	/**
	 * Whether extended parallelization shall be used during the transformation that might lead to the fact that the
	 * transformation result (especially the order of lists) varies between executions.
	 */
	private boolean useParallelization;

	/**
	 * This creates an instance.
	 *
	 * @param matchedSections
	 *            The map of {@link SourceSection SourceSections} and associated {@link MatchedSectionDescriptor
	 *            MatchedSectionDescriptors} that result from the matching process.
	 * @param selectedMappings
	 *            The {@link SelectedMappingRegistry} where selected {@link Mapping Mappings} as well as associated
	 *            {@link MappingInstanceStorage Mapping instances} are stored. This registry is consulted when checking
	 *            {@link ApplicationDependency ApplicationDependencies}.
	 * @param instanceSelectorHandler
	 *            The {@link InstanceSelectorHandler} used to filter instances by means of {@link InstanceSelector
	 *            InstanceSelectors}.
	 * @param valueConstraintReferenceValueCalculator
	 *            The {@link ValueConstraintReferenceValueCalculator} used to calculate reference values for
	 *            {@link ValueConstraint ValueConstraints}.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the transformation that might lead to the fact
	 *            that the transformation result (especially the order of lists) varies between executions.
	 */
	public ConditionHandler(MatchedSectionRegistry matchedSections, SelectedMappingRegistry selectedMappings,
			InstanceSelectorHandler instanceSelectorHandler,
			ValueConstraintReferenceValueCalculator valueConstraintReferenceValueCalculator, Logger logger,
			boolean useParallelization) {

		this.matchedSections = matchedSections;
		this.selectedMappingRegistry = selectedMappings;
		this.conditionRepository = new HashMap<>();
		this.attributeConditionConstraintsWithErrors = new HashSet<>();
		this.logger = logger;
		this.useParallelization = useParallelization;
		this.instanceSelectorHandler = instanceSelectorHandler;
		this.refValueCalculator = valueConstraintReferenceValueCalculator;
	}

	/**
	 * This is the general checkCondition method. Based on the type of condition to be evaluated, it will forward to the
	 * specific checking methods (e.g. {@link #checkConditionAnd(And, MatchedSectionDescriptor)}).
	 *
	 * @param complexCondition
	 *            The {@link ComplexCondition} to check.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the condition shall be checked.
	 * @return The calculated {@link CondResult} (true, false).
	 */
	public CondResult checkCondition(ComplexCondition complexCondition,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		// Note: No modeled condition always returns true
		if (complexCondition == null) {
			return CondResult.TRUE;
		}

		// First, we check if that condition already has been checked. In case
		// we are dealing with a 'global'
		// condition, we may reuse this result.
		//
		if (this.conditionRepository.get(complexCondition) != null && !complexCondition.isLocalCondition()) {
			return this.conditionRepository.get(complexCondition);
		}

		// Otherwise, we have to calculate the value
		CondResult result;

		if (complexCondition instanceof VariadicCondition) {

			result = this.checkVariadicCondition((VariadicCondition) complexCondition, matchedSectionDescriptor);

		} else if (complexCondition instanceof UnaryCondition) {

			result = this.checkUnaryCondition((UnaryCondition) complexCondition, matchedSectionDescriptor);

		} else if (complexCondition instanceof AttributeCondition) {

			result = this.checkAttributeCondition((AttributeCondition) complexCondition, matchedSectionDescriptor);

		} else if (complexCondition instanceof CardinalityCondition) {

			result = this.checkCardinalityCondition((CardinalityCondition) complexCondition, matchedSectionDescriptor);

		} else if (complexCondition instanceof ApplicationDependency) {

			result = this.checkApplicationDependency((ApplicationDependency) complexCondition,
					matchedSectionDescriptor);

		} else {

			this.logger.severe(() -> "Condition '" + complexCondition.getName() + "' is of an unsupported type: '"
					+ complexCondition.eClass().getName() + "'. Return 'FALSE' by default!");
			result = CondResult.FALSE;

		}

		return result;
	}

	/**
	 * Check the given {@link CardinalityCondition} for the given {@link MatchedSectionDescriptor}.
	 *
	 * @param sectionCondition
	 *            The {@link CardinalityCondition} to check.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the given condition shall be checked.
	 * @return The {@link CondResult result} of the check.
	 */
	private CondResult checkCardinalityCondition(CardinalityCondition sectionCondition,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		// The Section referenced by the CardinalityCondition was not matched in
		// the source model
		//
		if (!this.matchedSections.containsKey(sectionCondition.getTarget().getContainingSection())) {

			// For conditions where the referred Section shouldn't be part of a
			// model
			if (sectionCondition.getValue() == 0 && sectionCondition.getComparator() == ComparatorEnum.EQ) {

				return CondResult.TRUE;

			} else {

				return CondResult.FALSE;
			}
		}

		// Collect all instances for the selected MatchedSectionDescriptors
		//
		List<EObject> correspondEClassInstances = this.getInstancesToConsider(sectionCondition,
				matchedSectionDescriptor);

		// check Cardinality of the condition (e.g. the condition have to be at
		// least 5 times true)
		boolean cardinalityRes = this.checkCardinality(sectionCondition.getValue(), correspondEClassInstances.size(),
				sectionCondition.getComparator());

		// store and return the result
		CondResult result = cardinalityRes ? CondResult.TRUE : CondResult.FALSE;
		this.storeConditionResult(sectionCondition, result);
		return result;

	}

	/**
	 * Check the given {@link AttributeCondition} for the given {@link MatchedSectionDescriptor}.
	 *
	 * @param attrCondition
	 *            The {@link AttributeCondition} to check.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the given condition shall be checked.
	 * @return The {@link CondResult result} of the check.
	 */
	private CondResult checkAttributeCondition(AttributeCondition attrCondition,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		// Collect all instances for the selected MatchedSectionDescriptors
		//
		List<EObject> correspondEClassInstances = this.getInstancesToConsider(attrCondition, matchedSectionDescriptor);

		if (attrCondition.getTarget() == null) {
			this.logger.warning(() -> "No attribute modeled for AttributeCondition '" + attrCondition.getName() + "'."
					+ "Evaluating to 'TRUE' by default.");
			return CondResult.TRUE;
		}

		// Collect the values of the referenced EAttribute for each instance
		//
		List<Object> srcAttrValues = ValueExtractor.getAttributeValueAsList(correspondEClassInstances,
				attrCondition.getTarget(), this.logger);

		/*
		 * First, we check if all the constraints are satisfied for every attribute value of an AttributeConditon
		 */
		ArrayList<Boolean> attrBoolResults = new ArrayList<>();

		EAttribute attribute = attrCondition.getTarget().getAttribute();

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
			for (final ValueConstraint constraint : attrCondition.getValueConstraints()) {

				if (this.attributeConditionConstraintsWithErrors.contains(constraint)) {
					continue;
				}

				boolean constraintVal = false;
				try {
					// Note: 'checkConstraint' already takes the type
					// (REQUIRED/FORBIDDEN) into consideration
					// Starting from now we have to differentiate between
					// Single- and
					// MultipleReferenceAttributeValueConstraints
					// and we need to extract the right reference Value(s) for
					// each constraint

					if (constraint instanceof SingleReferenceValueConstraint) {
						String srcAttrRefValAsString = this.refValueCalculator.calculateReferenceValue(constraint,
								matchedSectionDescriptor);
						constraintVal = ((SingleReferenceValueConstraint) constraint).checkConstraint(srcAttrAsString,
								srcAttrRefValAsString);
					} else if (constraint instanceof ChoiceConstraint) {

						List<String> srcAttrRefValuesAsList = new ArrayList<>();

						for (EqualityConstraint equalityConstraint : ((ChoiceConstraint) constraint).getChoices()) {
							srcAttrRefValuesAsList.add(this.refValueCalculator
									.calculateReferenceValue(equalityConstraint, matchedSectionDescriptor));
						}

						constraintVal = ((ChoiceConstraint) constraint).checkConstraint(srcAttrAsString,
								new BasicEList<>(srcAttrRefValuesAsList));

					} else {
						// If we are here, some mistake is happened
						// more types could be supported in the future
						// placeholder for other
						// MultipleReferenceAttributeValueConstraints
						this.logger.severe(() -> "ReferenceableElement type " + constraint.getClass().getName()
								+ " is not yet supported!");
					}
				} catch (final Exception e) {

					this.attributeConditionConstraintsWithErrors.add(constraint);
					this.logger.warning(() -> "The AttributeCondition'" + constraint.getName()
							+ " could not be evaluated and will be ignored. The following error was supplied:\n"
							+ e.getLocalizedMessage());
					continue;

				}

				if (!constraintVal && constraint.getType().equals(ValueConstraintType.FORBIDDEN)) {

					exclusionFailed = true;
					break;

				} else if (constraint.getType().equals(ValueConstraintType.REQUIRED)) {

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

		// check Cardinality of the condition (e.g. the condition have to be at
		// least 5 times true)
		boolean cardinalityRes = this.checkCardinality(attrCondition.getValue(),
				Collections.frequency(attrBoolResults, true), attrCondition.getComparator());

		// return Result of this condition (and store result if its referred
		// model objects already were marked as
		// 'matched'
		if (cardinalityRes) {

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
	 * @return The {@link CondResult result} of the check.
	 */
	private CondResult checkApplicationDependency(ApplicationDependency applicationDependency,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		// The Section referenced by the SectionCondition was not matched in the
		// source model
		//
		if (applicationDependency.getTarget() instanceof Mapping) {

			// mapping has not been applied
			//
			if (!this.selectedMappingRegistry.containsMapping((Mapping) applicationDependency.getTarget())) {

				// check Cardinality of the condition (e.g. the condition have
				// to be at least 5 times true)
				boolean cardinalityRes = this.checkCardinality(applicationDependency.getValue(), 0,
						applicationDependency.getComparator());

				// return Result of this condition (and store result if its
				// referred model objects already were marked
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
			List<MappingInstanceStorage> storageInstances = this.selectedMappingRegistry
					.get((Mapping) applicationDependency.getTarget());

			// no instance pointers
			if (applicationDependency.getInstanceSelectors().isEmpty()) {

				// check Cardinality of the condition (e.g. the condition have
				// to be at least 5 times true)
				boolean cardinalityRes = this.checkCardinality(applicationDependency.getValue(),
						storageInstances.size(), applicationDependency.getComparator());

				// return Result of this condition (and store result if its
				// referred model objects already were marked
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

			// check Cardinality of the condition (e.g. the condition have to be
			// at least 5 times true)
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
	 * of {@link InstanceSelector InstancePointers}, only the elements represented by the given
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
	private List<EObject> getInstancesToConsider(Condition<?> condition,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		// The SourceSectionClass holding the attribute that the
		// AttributeCondition is based on
		//
		SourceSectionClass affectedClass;

		if (condition instanceof CardinalityCondition) {
			affectedClass = ((CardinalityCondition) condition).getTarget();
		} else if (condition instanceof AttributeCondition) {
			affectedClass = (SourceSectionClass) ((AttributeCondition) condition).getTarget().eContainer();
		} else if (condition instanceof ApplicationDependency) {
			ConditionalElement conditionalElement = ((ApplicationDependency) condition).getTarget();
			if (conditionalElement instanceof Mapping) {
				affectedClass = ((Mapping) conditionalElement).getSourceSection();
			} else if (conditionalElement instanceof InstantiableMappingHintGroup) {
				affectedClass = ((Mapping) conditionalElement.eContainer()).getSourceSection();
			} else if (conditionalElement instanceof MappingHint) {
				affectedClass = ((Mapping) conditionalElement.eContainer().eContainer()).getSourceSection();
			} else {
				this.logger.severe(() -> "Unknown type of ConditionalElement '" + conditionalElement.eClass().getName()
						+ "' found!");
				return new ArrayList<>();
			}
		} else {
			this.logger.severe(() -> "Unknown condition type '" + condition.eClass().getName() + "' found!");
			return new ArrayList<>();
		}

		List<MatchedSectionDescriptor> descriptorsToConsider;

		if (condition.isLocalCondition() && condition.getInstanceSelectors().isEmpty()) {

			// In case of a 'local' condition without any InstancePointers
			// specified,
			// we only consider the given 'matchedSectionDescriptor'.
			//
			MatchedSectionDescriptor descriptorToConsider = matchedSectionDescriptor;

			// If we are dealing with an 'external' condition (a local condition
			// that is based on elements from a container section), we need to
			// use the corresponding 'container descriptors' instead of the
			// determined 'descriptors' themselves
			//
			if (descriptorToConsider.getAssociatedSourceSectionClass().getAllContainer()
					.contains(affectedClass.getContainingSection())) {

				while (!descriptorToConsider.getAssociatedSourceSectionClass().getContainingSection()
						.equals(affectedClass.getContainingSection())) {

					if (descriptorToConsider.getContainerDescriptor() == null) {
						this.logger.severe(() -> "Internal error while evaluating condition '" + condition.getName()
								+ "'! Unable to determine correct MatchedSectionDescriptor.");
						break;
					}
					descriptorToConsider = matchedSectionDescriptor.getContainerDescriptor();
				}
			}

			descriptorsToConsider = Arrays.asList(descriptorToConsider);

		} else {

			// In case of a 'global' condition or if an InstanceSelector has
			// been specified, we
			// have to consider all 'descriptors' for the SourceSection under
			// consideration
			//
			descriptorsToConsider = this.matchedSections.containsKey(affectedClass.getContainingSection())
					? this.matchedSections.get(affectedClass.getContainingSection())
					: new ArrayList<>();
		}

		// Collect all instances for the selected MatchedSectionDescriptors
		//
		List<EObject> correspondEClassInstances = (this.useParallelization ? descriptorsToConsider.parallelStream()
				: descriptorsToConsider.stream()).flatMap(
						descriptor -> Optional.ofNullable(descriptor.getSourceModelObjectsMapped().get(affectedClass))
								.orElse(new HashSet<>()).stream())
						.collect(Collectors.toList());

		// Reduce the list of instances based on modeled InstancePointers
		//
		if (!correspondEClassInstances.isEmpty() && !condition.getInstanceSelectors().isEmpty()) {

			for (SourceInstanceSelector instancePointer : condition.getInstanceSelectors()) {

				correspondEClassInstances = this.instanceSelectorHandler.getSelectedInstancesByInstanceList(
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
	 * @param condition
	 *            The {@link ComplexCondition} for that the result shall be stored.
	 * @param result
	 *            The {@link CondResult} to be stored in the {@link #conditionRepository}.
	 */
	private void storeConditionResult(ComplexCondition condition, CondResult result) {

		// only store results for 'global' conditions
		if (!condition.isLocalCondition()) {
			this.conditionRepository.put(condition, result);
		}
	}

	/**
	 * Check the determined <em>isValue</em> cardinality against the required <em>refValue</em> cardinality while taking
	 * the given {@link ComparatorEnum} into account.
	 *
	 * @param refValue
	 *            The required cardinality.
	 * @param isValue
	 *            The determined (actual) cardinality.
	 * @param comparator
	 *            The {@link ComparatorEnum} describing how to compare the two cardinalities.
	 * @return '<em><b>true</b></em>' if the check succeeded, '<em><b>false</b></em>' otherwise.
	 */
	private boolean checkCardinality(int refValue, int isValue, ComparatorEnum comparator) {

		switch (comparator.getValue()) {
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
				this.logger.severe(() -> "Message:\n ComparatorEnum" + comparator.getLiteral() + "not implemented yet!"
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
	 * @return The calculated {@link CondResult} (true, false).
	 */
	private CondResult checkUnaryCondition(UnaryCondition condition,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		if (condition instanceof Not) {
			return this.checkConditionNot((Not) condition, matchedSectionDescriptor);
		} else {
			// If we are here, some mistake is happened, more types could be
			// supported in the future
			this.logger.severe(() -> "SingleConditionOperator type " + condition.getClass().getName()
					+ " is not yet supported!" + ConditionHandler.RETURNING_TRUE_AS_DEFAULT);
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
	 * @return The calculated {@link CondResult} (true, false).
	 */
	private CondResult checkConditionNot(Not condition, MatchedSectionDescriptor matchedSectionDescriptor) {

		CondResult condTemp = CondResult.TRUE;

		// Not Implementation
		if (condition.getSharedCondPart() != null) {
			condTemp = this.checkCondition(condition.getSharedCondPart(), matchedSectionDescriptor);
		} else if (condition.getLocalCondPart() != null) {
			condTemp = this.checkCondition(condition.getLocalCondPart(), matchedSectionDescriptor);
		}

		// Invert the result and return
		if (condTemp == CondResult.TRUE) {
			condTemp = CondResult.FALSE;

		} else if (condTemp == CondResult.FALSE) {
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
	 * @return The calculated {@link CondResult} (true, false).
	 */
	private CondResult checkVariadicCondition(VariadicCondition condition,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		if (condition instanceof And) {
			return this.checkConditionAnd((And) condition, matchedSectionDescriptor);

		} else if (condition instanceof Or) {
			return this.checkConditionOr((Or) condition, matchedSectionDescriptor);

		} else {
			// If we are here, some mistake is happened
			// more types could be supported in the future
			this.logger.severe(() -> "MultipleCondition type " + condition.getClass().getName()
					+ " is not yet supported!" + ConditionHandler.RETURNING_TRUE_AS_DEFAULT);
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
	 * @return The calculated {@link CondResult} (true, false).
	 */
	private CondResult checkConditionAnd(And condition, MatchedSectionDescriptor matchedSectionDescriptor) {

		// Get and put all arguments in a new list
		EList<ComplexCondition> args = new BasicEList<>();
		args.addAll(condition.getLocalCondParts());
		args.addAll(condition.getSharedCondParts());

		for (ComplexCondition arg : args) {

			// In order to save some time we break the loop after one argument
			// returned false (And-Operator)
			//
			if (this.checkCondition(arg, matchedSectionDescriptor) == CondResult.FALSE) {
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
	 * @return The calculated {@link CondResult} (true, false).
	 */
	private CondResult checkConditionOr(Or condition, MatchedSectionDescriptor matchedSectionDescriptor) {

		// Get and put all arguments in a new list
		EList<ComplexCondition> args = new BasicEList<>();
		args.addAll(condition.getLocalCondParts());
		args.addAll(condition.getSharedCondParts());

		for (ComplexCondition arg : args) {

			// In order to save some time we break the loop after one argument
			// returned false (And-Operator)
			//
			if (this.checkCondition(arg, matchedSectionDescriptor) == CondResult.TRUE) {
				return CondResult.TRUE;
			}
		}

		return CondResult.FALSE;
	}

}
