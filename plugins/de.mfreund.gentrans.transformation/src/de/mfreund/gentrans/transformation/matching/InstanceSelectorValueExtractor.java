package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import de.mfreund.gentrans.transformation.calculation.AttributeValueCalculator;
import de.mfreund.gentrans.transformation.calculation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import pamtram.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.extended.GlobalAttributeImporter;
import pamtram.structure.DynamicSourceElement;
import pamtram.structure.InstanceSelector;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * This class can be used to extract values required by an
 * {@link InstanceSelector} from source model elements for a given list of
 * {@link MatchedSectionDescriptor matched sections}.
 *
 * @author mfreund
 */
public class InstanceSelectorValueExtractor extends ValueExtractor {

	/**
	 * The {@link AttributeValueCalculator} to be used calculate target values.
	 */
	private AttributeValueCalculator attributeValueCalculator;

	/**
	 * This creates an instance for a given list of
	 * {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 *
	 * @param globalAttributeValues
	 *            The values of {@link GlobalAttribute GlobalAttributes} that
	 *            shall be used by
	 *            {@link #extractValue(GlobalAttributeImporter, MatchedSectionDescriptor)}.
	 * @param attributeValueCalculator
	 *            The {@link AttributeValueCalculator} to use in order to
	 *            calculate resulting values.
	 * @param attributeValueModifierExecutor
	 *            The {@link AttributeValueModifierExecutor} that shall be used
	 *            for modifying attribute values.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the
	 *            transformation that might lead to the fact that the
	 *            transformation result (especially the order of lists) varies
	 *            between executions.
	 */
	public InstanceSelectorValueExtractor(Map<GlobalAttribute, String> globalAttributeValues,
			AttributeValueCalculator attributeValueCalculator,
			AttributeValueModifierExecutor attributeValueModifierExecutor, Logger logger, boolean useParallelization) {

		super(globalAttributeValues, attributeValueModifierExecutor, logger, useParallelization);

		this.attributeValueCalculator = attributeValueCalculator;
	}

	/**
	 * This creates an instance for a given list of
	 * {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 *
	 * @param attributeValueCalculator
	 *            The {@link AttributeValueCalculator} to use in order to
	 *            calculate resulting values.
	 * @param attributeValueModifierExecutor
	 *            The {@link AttributeValueModifierExecutor} that shall be used
	 *            for modifying attribute values.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the
	 *            transformation that might lead to the fact that the
	 *            transformation result (especially the order of lists) varies
	 *            between executions.
	 */
	public InstanceSelectorValueExtractor(AttributeValueCalculator attributeValueCalculator,
			AttributeValueModifierExecutor attributeValueModifierExecutor, Logger logger, boolean useParallelization) {

		super(attributeValueModifierExecutor, logger, useParallelization);

		this.attributeValueCalculator = attributeValueCalculator;
	}

	/**
	 * This extracts and returns the required target value for the given
	 * {@link InstanceSelector} as specified by its
	 * {@link InstanceSelector#getSourceElements() source attributes}.
	 *
	 * @param instancePointer
	 *            The {@link InstanceSelector} for that the target value shall
	 *            be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the value shall
	 *            be extracted.
	 * @return The extracted value (after applying a possible
	 *         {@link InstanceSelector#getModifiers() result modifier} or
	 *         '<em><b>null</b></em>' if no value could be extracted.
	 */
	@SuppressWarnings("unchecked")
	public String extractRequiredTargetValue(SourceInstanceSelector instancePointer,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		// Collect the value parts
		//
		Map<InstanceSelectorSourceInterface, AttributeValueRepresentation> valueParts = new HashMap<>();

		// Extract the value part based on its type
		//
		for (InstanceSelectorSourceInterface instancePointerSourceInterface : instancePointer.getSourceElements()) {

			AttributeValueRepresentation attributeValueRepresentation = null;

			if (instancePointerSourceInterface instanceof DynamicSourceElement<?, ?, ?, ?>) {
				attributeValueRepresentation = this.extractValue(
						(DynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) instancePointerSourceInterface,
						matchedSectionDescriptor);
			} else if (instancePointerSourceInterface instanceof FixedValue) {
				attributeValueRepresentation = this.extractValue((FixedValue) instancePointerSourceInterface,
						matchedSectionDescriptor);
			} else if (instancePointerSourceInterface instanceof GlobalAttributeImporter) {
				attributeValueRepresentation = this.extractValue(
						(GlobalAttributeImporter) instancePointerSourceInterface, matchedSectionDescriptor);
			} else {
				this.logger.severe(() -> "Unsupported type of source element for an InstanceSelector found: '"
						+ instancePointerSourceInterface.eClass().getName() + "'!");
			}

			if (attributeValueRepresentation != null) {

				if (attributeValueRepresentation.isMany()) {
					this.logger.warning(() -> "Multiple values found for the source element '"
							+ instancePointerSourceInterface.getName()
							+ "' of an InstanceSelector! This is currently not supported and only the first found value will be used!'");
				}

				valueParts.put(instancePointerSourceInterface, attributeValueRepresentation);
			}
		}

		// Assemble the target value based on the value parts and a potential
		// expression
		//
		String expression = instancePointer.getExpression();
		if (expression == null || expression.isEmpty()) {
			return this.attributeValueCalculator.calculateValueWithoutExpression(
					new ArrayList<>(instancePointer.getSourceElements()), valueParts, instancePointer.getModifiers());
		} else {
			return this.attributeValueCalculator.calculateValueWithExpression(valueParts, expression,
					instancePointer.getModifiers());
		}

	}

}
