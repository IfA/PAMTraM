/**
 *
 */
package de.mfreund.gentrans.transformation.maps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import de.mfreund.gentrans.transformation.calculation.ValueCalculator;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import pamtram.mapping.extended.MappingHint;

/**
 *
 * @author mfreund
 */
public class SimpleHintValue extends HintValue {

	/**
	 * This creates an instance based on an {@link Integer} value.
	 *
	 * @param hint
	 *            The {@link MappingHint} that this represents a value for.
	 * @param value
	 *            The value to use.
	 * @param valueCalculator
	 *            The {@link ValueCalculator} that shall be used to calculate the {@link #getResultingValues()
	 *            resultingValues}.
	 */
	protected SimpleHintValue(MappingHint hint, String value, ValueCalculator valueCalculator) {

		super(hint, value, valueCalculator);
	}

	// @SuppressWarnings("unchecked")
	// @Override
	// public String getStringValue() {
	//
	// if (this.internalValue instanceof Integer) {
	//
	// return this.internalValue.toString();
	//
	// } else if (this.internalValue instanceof Map<?, ?>) {
	//
	// StringBuilder valueBuilder = new StringBuilder();
	//
	// for (Entry<CardinalityMappingSourceInterface, AttributeValueRepresentation> entry :
	// ((Map<CardinalityMappingSourceInterface, AttributeValueRepresentation>) this.internalValue)
	// .entrySet()) {
	// valueBuilder.append(entry.getValue().getNextValue());
	// }
	//
	// return valueBuilder.toString();
	//
	// } else {
	//
	// return null;
	// }
	// }
	//
	// @SuppressWarnings("unchecked")
	// @Override
	// public Map<String, Double> getDoubleValueMap() {
	//
	// final Map<String, Double> vars = new HashMap<>();
	//
	// if (this.internalValue instanceof Integer) {
	//
	// vars.put("x", Double.valueOf(this.getStringValue()));
	//
	// } else if (this.internalValue instanceof Map<?, ?>) {
	//
	// for (Entry<?, AttributeValueRepresentation> entry : ((Map<CardinalityMappingSourceInterface,
	// AttributeValueRepresentation>) this.internalValue)
	// .entrySet()) {
	//
	// if (entry.getKey() instanceof NamedElement) {
	//
	// String value = entry.getValue().getNextValue();
	//
	// vars.put(((NamedElement) entry.getKey()).getName(), Double.valueOf(value));
	// }
	// }
	//
	// } else {
	//
	// return null;
	// }
	//
	// return vars;
	// }

	@Override
	public void expandHintValue(String valueToAdd, boolean prepend) {

		this.internalValue = prepend ? valueToAdd + this.internalValue : this.internalValue + valueToAdd;

	}

	@Override
	public List<String> getResultingValues() {

		Map<String, AttributeValueRepresentation> internalValueAsMap = new LinkedHashMap<>();
		internalValueAsMap.put("x", new AttributeValueRepresentation(null, (String) this.internalValue));

		return Arrays.asList(this.valueCalculator.calculateAttributeValue(null, this.hint, internalValueAsMap));
	}

}
