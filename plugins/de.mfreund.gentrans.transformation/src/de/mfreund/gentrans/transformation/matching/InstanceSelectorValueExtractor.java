package de.mfreund.gentrans.transformation.matching;

import java.util.LinkedHashMap;
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
import pamtram.structure.DynamicSourceElement;
import pamtram.structure.InstanceSelector;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * This class can be used to extract values required by an {@link InstanceSelector} from source model elements for a
 * given list of {@link MatchedSectionDescriptor matched sections}.
 *
 * @author mfreund
 */
public class InstanceSelectorValueExtractor extends ValueExtractor {

	/**
	 * The {@link ValueCalculator} to be used calculate target values.
	 */
	private ValueCalculator attributeValueCalculator;

	/**
	 * This creates an instance for a given list of {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 *
	 * @param globalValues
	 *            The <em>global values</em> (values of {@link FixedValue FixedValues} and {@link GlobalAttribute
	 *            GlobalAttribute}) defined in the PAMTraM model.
	 * @param instanceSelectorHandler
	 *            The {@link InstanceSelectorHandler} that is used to evaluate {@link InstanceSelector InstancePointers}
	 *            that have been modeled.
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
	public InstanceSelectorValueExtractor(GlobalValueMap globalValues, InstanceSelectorHandler instanceSelectorHandler,
			ValueCalculator attributeValueCalculator, ValueModifierExecutor attributeValueModifierExecutor,
			Logger logger, boolean useParallelization) {

		super(globalValues, instanceSelectorHandler, attributeValueModifierExecutor, logger, useParallelization);

		this.attributeValueCalculator = attributeValueCalculator;
	}

	/**
	 * This extracts and returns the required target value for the given {@link InstanceSelector} as specified by its
	 * {@link InstanceSelector#getSourceElements() source attributes}.
	 *
	 * @param instancePointer
	 *            The {@link InstanceSelector} for that the target value shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the value shall be extracted.
	 * @return The extracted value (after applying a possible {@link InstanceSelector#getModifiers() result modifier} or
	 *         '<em><b>null</b></em>' if no value could be extracted.
	 */
	@SuppressWarnings("unchecked")
	public String extractRequiredTargetValue(InstanceSelector instancePointer,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		// Collect the value parts
		//
		LinkedHashMap<InstanceSelectorSourceInterface, AttributeValueRepresentation> valueParts = new LinkedHashMap<>();

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
		return this.attributeValueCalculator.calculateValue(instancePointer.getExpression(), valueParts,
				instancePointer.getModifiers());

	}

}
