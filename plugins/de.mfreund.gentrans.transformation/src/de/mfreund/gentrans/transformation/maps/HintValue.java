/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.maps;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import de.mfreund.gentrans.transformation.calculation.ValueCalculator;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.MappingHintSourceInterface;

/**
 * Instances of this represent a complex <em>hint value</em> (one or multiple values determined for a
 * {@link MappingHint} during the <em>extracting</em> phase of a transformation that may be made up of several
 * components).
 *
 * @author mfreund
 *
 */
public abstract class HintValue {

	/**
	 * The {@link MappingHint} that this represents a value for.
	 */
	protected MappingHint hint;

	/**
	 * The Object representing the actual value of this.
	 */
	protected Object internalValue;

	/**
	 * The {@link ValueCalculator} that shall be used to calculate the {@link #getResultingValues() resultingValues}.
	 */
	protected ValueCalculator valueCalculator;

	/**
	 * This creates an instance.
	 *
	 * @param hint
	 *            The {@link MappingHint} that this represents a value for.
	 * @param internalValue
	 *            The Object representing the actual value of this.
	 * @param valueCalculator
	 *            The {@link ValueCalculator} that shall be used to calculate the {@link #getResultingValues()
	 *            resultingValues}.
	 */
	protected HintValue(MappingHint hint, Object internalValue, ValueCalculator valueCalculator) {

		this.hint = hint;
		this.internalValue = internalValue;
		this.valueCalculator = valueCalculator;
	}

	/**
	 * Create and return an instance of a suitable subclass of this. The concrete subclass is determined based on the
	 * type of <em>internalValue</em> passed to this method.
	 *
	 * @param hint
	 *            The {@link MappingHint} that this represents a value for.
	 * @param internalValue
	 *            The Object representing the actual value of this.
	 * @param valueCalculator
	 *            The {@link ValueCalculator} that shall be used to calculate the {@link #getResultingValues()
	 *            resultingValues}.
	 * @return The created {@link HintValue}.
	 */
	@SuppressWarnings("unchecked")
	public static HintValue create(MappingHint hint, Object internalValue, ValueCalculator valueCalculator) {

		if (internalValue instanceof Map<?, ?>) {

			return new AttributeBasedHintValue<>(hint,
					(LinkedHashMap<MappingHintSourceInterface, AttributeValueRepresentation>) internalValue,
					valueCalculator);
		} else if (internalValue != null) {

			return new SimpleHintValue(hint, internalValue.toString(), valueCalculator);
		} else {

			return new EmptyHintValue(hint);
		}
	}

	/**
	 * @return the {@link #hint}
	 */
	public MappingHint getHint() {

		return this.hint;
	}

	/**
	 * @return the {@link #internalValue}
	 */
	public Object getInternalValue() {

		return this.internalValue;
	}

	/**
	 * Creates a duplicate of this hint value and returns it.
	 *
	 * @return The cloned {@link HintValue}.
	 */
	public HintValue createCopy() {

		return HintValue.create(this.hint, this.internalValue, this.valueCalculator);

	}

	/**
	 * Based on the {@link #hint} and the {@link #internalValue}, calculate the resulting String-based value or values.
	 *
	 * @return The resulting value(s).
	 */
	public abstract List<String> getResultingValues();

	// /**
	// * Returns a String representation of the {@link #internalValue}.
	// *
	// * @return The String representation.
	// */
	// public abstract String getStringValue();
	//
	// /**
	// * Returns a map-based representation of the {@link #internalValue} as one or multiple {@link Double} values, each
	// * associated with a String-based identifier.
	// *
	// * @return The map representation.
	// * @throws NumberFormatException
	// * If one or multiple parts of the {@link #internalValue} could not be parsed to a Double value.
	// */
	// public abstract Map<String, Double> getDoubleValueMap() throws NumberFormatException;

	/**
	 * Expand the value with the value represented by the given <em>valueToAdd</em>.
	 *
	 * @param valueToAdd
	 *            The value to add.
	 * @param prepend
	 *            If this is '<em>true</em>', the hintValue is prepended; otherwise, it is appended.
	 */
	public abstract void expandHintValue(String valueToAdd, boolean prepend);

}
