package de.mfreund.gentrans.transformation.matching;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;

import de.mfreund.gentrans.transformation.calculation.InstanceSelectorHandler;
import de.mfreund.gentrans.transformation.calculation.ValueCalculator;
import de.mfreund.gentrans.transformation.calculation.ValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import pamtram.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.extended.GlobalAttributeImporter;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.DynamicSourceElement;
import pamtram.structure.constraint.SingleReferenceValueConstraint;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.constraint.ValueConstraintSourceInterface;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * This class can be used to extract values required by an {@link ValueConstraint} from source model elements for a
 * given list of {@link MatchedSectionDescriptor matched sections}.
 *
 * @author mfreund
 */
public class AttributeValueConstraintValueExtractor extends ValueExtractor {

	/**
	 * The {@link ValueCalculator} to be used calculate target values.
	 */
	private ValueCalculator attributeValueCalculator;

	/**
	 * This creates an instance for a given list of {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 *
	 * @param globalValues
	 *            The {@link GlobalValueMap} that contains the relevant values of {@link GlobalAttribute
	 *            GlobalAttributes}.
	 * @param instanceSelectorHandler
	 *            The {@link InstanceSelectorHandler} used for selecting specific instances when extracting values.
	 * @param attributeValueCalculator
	 *            The {@link ValueCalculator} to use in order to calculate resulting values.
	 * @param attributeValueModifierExecutor
	 *            The {@link ValueModifierExecutor} that shall be used for modifying attribute values.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the transformation that might lead to the fact
	 *            that the transformation result (especially the order of lists) varies between executions.
	 */
	public AttributeValueConstraintValueExtractor(GlobalValueMap globalValues,
			InstanceSelectorHandler instanceSelectorHandler, ValueCalculator attributeValueCalculator,
			ValueModifierExecutor attributeValueModifierExecutor, Logger logger, boolean useParallelization) {

		super(globalValues, instanceSelectorHandler, attributeValueModifierExecutor, logger, useParallelization);

		this.attributeValueCalculator = attributeValueCalculator;
	}

	/**
	 * This creates an instance for a given list of {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 *
	 * @param instanceSelectorHandler
	 *            The {@link InstanceSelectorHandler} used for selecting specific instances when extracting values.
	 * @param attributeValueModifierExecutor
	 *            The {@link ValueModifierExecutor} that shall be used for modifying attribute values.
	 * @param attributeValueCalculator
	 *            The {@link ValueCalculator} to use in order to calculate resulting values.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the transformation that might lead to the fact
	 *            that the transformation result (especially the order of lists) varies between executions.
	 * @deprecated use
	 *             {@link #AttributeValueConstraintValueExtractor(GlobalValueMap, InstanceSelectorHandler, ValueCalculator, ValueModifierExecutor, Logger, boolean)}
	 *             instead
	 */
	@Deprecated
	public AttributeValueConstraintValueExtractor(InstanceSelectorHandler instanceSelectorHandler,
			ValueModifierExecutor attributeValueModifierExecutor, ValueCalculator attributeValueCalculator,
			Logger logger, boolean useParallelization) {

		super(new GlobalValueMap(), instanceSelectorHandler, attributeValueModifierExecutor, logger,
				useParallelization);

		this.attributeValueCalculator = attributeValueCalculator;
	}

	/**
	 * This extracts and returns the required target value for the given {@link SingleReferenceValueConstraint} as
	 * specified by its {@link SingleReferenceValueConstraint#getSourceElements() source elements}.
	 *
	 * @param valueConstraint
	 *            The {@link SingleReferenceValueConstraint} for that the target value shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the value shall be extracted.
	 * @return The extracted value (after applying a possible {@link SingleReferenceValueConstraint#getModifiers()
	 *         result modifier} or '<em><b>null</b></em>' if no value could be extracted.
	 */
	public String extractRequiredTargetValue(SingleReferenceValueConstraint valueConstraint,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		List<ValueConstraintSourceInterface> sourceElements = valueConstraint.getSourceElements();
		List<ValueModifierSet> resultModifiers = valueConstraint.getModifiers();
		String expression = valueConstraint.getExpression();

		return this.extractRequiredTargetValue(matchedSectionDescriptor, sourceElements, expression, resultModifiers);

	}

	/**
	 * This extracts and returns the required target value for the given list of {@link ValueConstraintSourceInterface
	 * source elements} for the given {@link MatchedSectionDescriptor}.
	 *
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the value shall be extracted.
	 * @param sourceElements
	 *            The list of {@link ValueConstraintSourceInterface source elements} to take into account.
	 * @param expression
	 *            The expression to use or '<em>null</em>' if no expression shall be used.
	 * @param resultModifiers
	 *            The list of {@link ValueModifierSet AttributeValueModifierSets} to apply before the resulting target
	 *            value is returned.
	 * @return The extracted target value.
	 */
	@SuppressWarnings("unchecked")
	private String extractRequiredTargetValue(MatchedSectionDescriptor matchedSectionDescriptor,
			List<ValueConstraintSourceInterface> sourceElements, String expression,
			List<ValueModifierSet> resultModifiers) {

		// Collect the value parts
		//
		LinkedHashMap<ValueConstraintSourceInterface, AttributeValueRepresentation> valueParts = new LinkedHashMap<>();

		// Extract the value part based on its type
		//
		for (ValueConstraintSourceInterface sourceElement : sourceElements) {

			AttributeValueRepresentation attributeValueRepresentation = null;

			if (sourceElement instanceof DynamicSourceElement<?, ?, ?, ?>) {
				attributeValueRepresentation = this.extractValue(
						(DynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) sourceElement,
						matchedSectionDescriptor);
			} else if (sourceElement instanceof FixedValue) {
				attributeValueRepresentation = this.extractValue((FixedValue) sourceElement, matchedSectionDescriptor);
			} else if (sourceElement instanceof GlobalAttributeImporter) {
				attributeValueRepresentation = this.extractValue((GlobalAttributeImporter) sourceElement,
						matchedSectionDescriptor);
			} else {
				this.logger.severe(() -> "Unsupported type of source element for an AttributeValueConstraint found: '"
						+ sourceElement.eClass().getName() + "'!");
			}

			if (attributeValueRepresentation != null) {

				if (attributeValueRepresentation.isMany()) {
					this.logger.warning(() -> "Multiple values found for the source element '" + sourceElement.getName()
							+ "' of an AttributeValueConstraint! This is currently not supported and only the first found value will be used!'");
				}

				valueParts.put(sourceElement, attributeValueRepresentation);
			}
		}

		// Assemble the target value based on the value parts and a potential
		// expression
		//
		if (expression == null || expression.isEmpty()) {
			return this.attributeValueCalculator.calculateValueWithoutExpression(valueParts, resultModifiers);
		} else {
			return this.attributeValueCalculator.calculateValueWithExpression(valueParts, expression, resultModifiers);
		}
	}
}
