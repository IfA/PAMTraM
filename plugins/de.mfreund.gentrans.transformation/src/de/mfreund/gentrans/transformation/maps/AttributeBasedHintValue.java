/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package de.mfreund.gentrans.transformation.maps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import de.mfreund.gentrans.transformation.calculation.ValueCalculator;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.MappingHintSourceInterface;

/**
 * Instances of this class represent a <em>hint value</em> (a value determined for a {@link MappingHint} during the
 * <em>extracting</em> phase of a transformation) that is made up of various parts. Thereby, each part of the hint value
 * is represented by an {@link AttributeValueRepresentation} represent a {@link MappingHintSourceInterface} that
 * resulted from evaluating the associated {@link MappingHintSourceInterface}.
 *
 * @author mfreund
 * @param <S>
 *            The concrete type of {@link MappingHintSourceInterface} that makes up the keys in this map.
 */
public class AttributeBasedHintValue<S extends MappingHintSourceInterface> extends HintValue {

	/**
	 * This creates an instance.
	 *
	 * @param hint
	 *            The {@link MappingHint} that this represents a value for.
	 * @param valueParts
	 *            The value parts making up this value.
	 * @param valueCalculator
	 *            The {@link ValueCalculator} that shall be used to calculate the {@link #getResultingValues()
	 *            resultingValues}.
	 * @throws IllegalArgumentException
	 *             if the <em>valueParts</em> are not consistent.
	 */
	protected AttributeBasedHintValue(MappingHint hint, LinkedHashMap<S, AttributeValueRepresentation> valueParts,
			ValueCalculator valueCalculator) throws IllegalArgumentException {

		super(hint, valueParts, valueCalculator);

		// As we deal with a 'complex' hint (one that is composed of multiple source elements) and one or more of the
		// source elements may have returned multiple values, we need to check if the cardinalities of the various value
		// parts are consistent so that multiple distinct hint values can be created later on.
		//
		int maxNumberOfValues = valueParts.values().parallelStream().mapToInt(v -> v.getValues().size()).max()
				.getAsInt();

		for (AttributeValueRepresentation valueRepresentation : valueParts.values()) {
			if (maxNumberOfValues % valueRepresentation.getValues().size() > 0) {
				throw new IllegalArgumentException("The source elements of the mapping hint '" + this.hint.getName()
						+ "' produced an " + "inconsistent number of hint values. They are thus skipped...");
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public LinkedHashMap<S, AttributeValueRepresentation> getInternalValue() {

		return (LinkedHashMap<S, AttributeValueRepresentation>) super.getInternalValue();
	}

	/**
	 * Whether the {@link #getInternalValue() internalValue} is empty.
	 *
	 * @return '<em>true</em> if the {@link #getInternalValue() internalValue} is empty, '<em>false</em>' otherwise.
	 */
	public boolean isEmpty() {

		return this.getInternalValue().isEmpty();
	}

	@Override
	public AttributeBasedHintValue<S> createCopy() {

		LinkedHashMap<S, AttributeValueRepresentation> clonedMap = new LinkedHashMap<>();

		for (Entry<S, AttributeValueRepresentation> entry : this.getInternalValue().entrySet()) {
			clonedMap.put(entry.getKey(), (AttributeValueRepresentation) entry.getValue().clone());
		}

		return new AttributeBasedHintValue<>(this.hint, clonedMap, this.valueCalculator);
	}

	// @Override
	// public String getStringValue() {
	//
	// StringBuilder valueBuilder = new StringBuilder();
	//
	// for (Entry<S, AttributeValueRepresentation> entry : this.getInternalValue().entrySet()) {
	// valueBuilder.append(entry.getValue().getNextValue());
	// }
	//
	// return valueBuilder.toString();
	// }
	//
	// @Override
	// public Map<String, Double> getDoubleValueMap() {
	//
	// final Map<String, Double> vars = new HashMap<>();
	//
	// for (Entry<?, AttributeValueRepresentation> entry : this.getInternalValue().entrySet()) {
	//
	// if (entry.getKey() instanceof NamedElement) {
	//
	// String value = entry.getValue().getNextValue();
	//
	// vars.put(((NamedElement) entry.getKey()).getName(), Double.valueOf(value));
	// }
	// }
	//
	// return vars;
	//
	// }

	@Override
	public void expandHintValue(String valueToAdd, boolean prepend) {

		S valuePartToExpand = new ArrayList<>(this.getInternalValue().keySet())
				.get(prepend ? 0 : this.getInternalValue().size() - 1);

		if (prepend) {
			this.getInternalValue().get(valuePartToExpand).addPrefix(valueToAdd);
		} else {
			this.getInternalValue().get(valuePartToExpand).addSuffix(valueToAdd);
		}

	}

	@Override
	public List<String> getResultingValues() {

		List<String> ret = new ArrayList<>();

		// As we deal with a 'complex' hint (one that is composed of multiple source elements) and one or more of the
		// source elements may have returned multiple values, we need to check if the cardinalities of the various value
		// parts are consistent so that multiple distinct hint values can be created later on.
		//
		int maxNumberOfValues = this.getInternalValue().values().parallelStream().mapToInt(v -> v.getValues().size())
				.max().getAsInt();

		for (int i = 0; i < maxNumberOfValues; i++) {

			LinkedHashMap<MappingHintSourceInterface, AttributeValueRepresentation> newHintValueMap = new LinkedHashMap<>();

			for (Entry<S, AttributeValueRepresentation> entry : this.getInternalValue().entrySet()) {
				newHintValueMap.put(entry.getKey(), new AttributeValueRepresentation(entry.getValue().getAttribute(),
						entry.getValue().getNextValue()));
			}

			ret.add(this.valueCalculator.calculateAttributeValue(null, this.hint, newHintValueMap));
		}

		return ret;
	}

}
