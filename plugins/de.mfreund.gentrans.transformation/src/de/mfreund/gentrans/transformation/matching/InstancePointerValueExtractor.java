package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import de.mfreund.gentrans.transformation.calculation.AttributeValueCalculator;
import de.mfreund.gentrans.transformation.calculation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.InstancePointerSourceInterface;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionReference;

/**
 * This class can be used to extract values required by an {@link InstancePointer}
 * from source model elements for a given list of {@link MatchedSectionDescriptor matched sections}.
 * 
 * @author mfreund
 */
public class InstancePointerValueExtractor extends ValueExtractor {

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
	 */
	public InstancePointerValueExtractor(Map<GlobalAttribute, String> globalAttributeValues,
			AttributeValueCalculator attributeValueCalculator, 
			AttributeValueModifierExecutor attributeValueModifierExecutor, 
			Logger logger) {

		super(globalAttributeValues, attributeValueModifierExecutor, logger);

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
	 */
	public InstancePointerValueExtractor(
			AttributeValueCalculator attributeValueCalculator,
			AttributeValueModifierExecutor attributeValueModifierExecutor, 
			Logger logger) {

		super(attributeValueModifierExecutor, logger);

		this.attributeValueCalculator = attributeValueCalculator;
	}

	/**
	 * This extracts and returns the required target value for the given {@link InstancePointer} as specified by its 
	 * {@link InstancePointer#getSourceAttributes() source attributes}.
	 * 
	 * @param instancePointer The {@link InstancePointer} for that the target value shall be extracted.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the value shall be extracted.
	 * @return The extracted value (after applying a possible {@link InstancePointer#getResultModifier() result modifier} or 
	 * '<em><b>null</b></em>' if no value could be extracted.
	 */
	@SuppressWarnings("unchecked")
	public String extractRequiredTargetValue(InstancePointer instancePointer, 
			MatchedSectionDescriptor matchedSectionDescriptor) {

		// Collect the value parts
		//
		Map<InstancePointerSourceInterface, AttributeValueRepresentation> valueParts = new HashMap<>();

		// Extract the value part based on its type
		//
		for (InstancePointerSourceInterface instancePointerSourceInterface : instancePointer.getSourceAttributes()) {

			AttributeValueRepresentation attributeValueRepresentation = null;

			if(instancePointerSourceInterface instanceof ModifiedAttributeElementType<?, ?, ?, ?>) {
				attributeValueRepresentation = extractValue((ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) instancePointerSourceInterface, matchedSectionDescriptor);
			} else if(instancePointerSourceInterface instanceof FixedValue) {
				attributeValueRepresentation = extractValue((FixedValue) instancePointerSourceInterface, matchedSectionDescriptor); 
			} else if(instancePointerSourceInterface instanceof GlobalAttributeImporter) {
				attributeValueRepresentation = extractValue((GlobalAttributeImporter) instancePointerSourceInterface, matchedSectionDescriptor); 
			} else {
				logger.severe("Unsupported type of source element for an InstancePointer found: '" +
						instancePointerSourceInterface.eClass().getName() + "'!");
			}

			if(attributeValueRepresentation != null) {					

				if(attributeValueRepresentation.isMany()) {
					logger.warning("Multiple values found for the source element '"
							+ instancePointerSourceInterface.getName()
							+
							"' of an InstancePointer! This is currently not supported and only the first found value will be used!'");
				}

				valueParts.put(instancePointerSourceInterface, attributeValueRepresentation);
			}
		}

		// Assemble the target value based on the value parts and a potential expression
		//
		String expression = instancePointer.getExpression();
		if(expression == null || expression.isEmpty()) {
			return attributeValueCalculator.calculateValueWithoutExpression(new ArrayList<>(instancePointer.getSourceAttributes()), valueParts, instancePointer.getResultModifier());
		} else {
			return attributeValueCalculator.calculateValueWithExpression(valueParts, expression, instancePointer.getResultModifier());
		}

	}

}
