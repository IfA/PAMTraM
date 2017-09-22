package de.mfreund.gentrans.transformation.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import pamtram.FixedValue;
import pamtram.NamedElement;
import pamtram.mapping.GlobalAttribute;

/**
 * This is used to store values of {@link FixedValue FixedValues} and {@link GlobalAttribute GlobalAttributes} that can
 * be used throughout the transformation.
 *
 * @author mfreund
 *
 */
public class GlobalValueMap {

	/**
	 * This keeps track of the values of {@link FixedValue FixedValues}.
	 */
	private Map<FixedValue, String> fixedValues;

	/**
	 * This keeps track of the values of {@link GlobalAttribute GlobalAttributes}.
	 */
	private Map<GlobalAttribute, String> globalAttributes;

	/**
	 * This keeps track of both {@link FixedValue FixedValues} and {@link GlobalAttribute GlobalAttributes}.
	 */
	private Map<NamedElement, String> globalValues;

	/**
	 * This keeps track of a those of the {@link #globalValues} that can be parsed as double.
	 */
	private Map<NamedElement, Double> globalValuesAsDouble;

	/**
	 * This creates an empty instance.
	 *
	 */
	public GlobalValueMap() {

		this.fixedValues = new HashMap<>();
		this.globalAttributes = new HashMap<>();

		this.globalValues = new HashMap<>();
	}

	/**
	 * This creates an instance.
	 *
	 * @param fixedValues
	 *            The values of {@link FixedValue FixedValues}.
	 * @param globalAttributes
	 *            The values of {@link GlobalAttribute GlobalAttributes}.
	 */
	public GlobalValueMap(Map<FixedValue, String> fixedValues, Map<GlobalAttribute, String> globalAttributes) {

		this.fixedValues = fixedValues;
		this.globalAttributes = globalAttributes;

		this.globalValues = new HashMap<>();
		this.globalValues.putAll(globalAttributes);
		this.globalValues.putAll(fixedValues);
	}

	/**
	 * Add a list of {@link FixedValue FixedValues} to this map.
	 *
	 * @param fixedValues
	 *            the {@link FixedValue FixedValues} to add
	 */
	public void addFixedValues(Map<FixedValue, String> fixedValues) {

		this.fixedValues.putAll(fixedValues);
		this.globalValues.putAll(fixedValues);
		this.globalValuesAsDouble = null;
	}

	/**
	 * Add a list of values for {@link GlobalAttribute GlobalAttributes} to this map.
	 *
	 * @param globalAttributeValues
	 *            the values of {@link GlobalAttribute GlobalAttributes} to add
	 */
	public void addGlobalAttributeValues(Map<GlobalAttribute, String> globalAttributeValues) {

		this.globalAttributes.putAll(globalAttributeValues);
		this.globalValues.putAll(globalAttributeValues);
		this.globalValuesAsDouble = null;
	}

	/**
	 * Returns the value of the given {@link FixedValue}.
	 *
	 * @param fixedValue
	 *            The {@link FixedValue} for that the value shall be returned.
	 * @return The value or '<em><b>null</b></em> if no value for the given <em>fixedValue</em> exists.
	 */
	public String get(FixedValue fixedValue) {

		return this.fixedValues.get(fixedValue);
	}

	/**
	 * Returns the value of the given {@link GlobalAttribute}.
	 *
	 * @param globalAttribute
	 *            The {@link GlobalAttribute} for that the value shall be returned.
	 * @return The value or '<em><b>null</b></em> if no value for the given <em>globalAttribute</em> exists.
	 */
	public String get(GlobalAttribute globalAttribute) {

		return this.globalAttributes.get(globalAttribute);
	}

	/**
	 * This is the getter for the {@link #fixedValues}.
	 *
	 * @return The values of the {@link FixedValue FixedValues} modeled in the PAMTraM model.
	 */
	public Map<FixedValue, String> getFixedValues() {

		return this.fixedValues;
	}

	/**
	 * This is the getter for the {@link #globalAttributes}.
	 *
	 * @return The extracted values of the {@link GlobalAttribute GlobalAttributes} modeled in the PAMTraM model.
	 */
	public Map<GlobalAttribute, String> getGlobalAttributes() {

		return this.globalAttributes;
	}

	/**
	 * This is the getter for the {@link #globalValues}.
	 *
	 * @return The values of both {@link FixedValue FixedValues} and {@link GlobalAttribute GlobalAttributes}.
	 */
	public Map<NamedElement, String> getGlobalValues() {

		return this.globalValues;
	}

	/**
	 * This returns the values of the {@link #globalValues} as {@link Double} values that can be used in calculations.
	 * <p />
	 * Therefore, it tries to parse a <em>double</em> value for each of the {@link #globalValues}. Values that cannot be
	 * parsed as <em>double</em> are ignored.
	 *
	 * @return The values of both {@link FixedValue FixedValues} and {@link GlobalAttribute GlobalAttributes}
	 *         represented as <em>double</em>.
	 */
	public Map<NamedElement, Double> getAsDouble() {

		if (this.globalValuesAsDouble == null) {

			// If this is called the first time, we need to parse the double
			// values first
			//
			this.globalValuesAsDouble = new HashMap<>();
			this.globalValues.entrySet().stream().forEach(globalValue -> {

				try {

					/*
					 * We make use of the ExpressionBuilder as 'String.valueOf(double)' doesn't support scientific
					 * notation, like: 0.42e2 == 4200e-2 == 42
					 */
					final Calculable calc = new ExpressionBuilder(globalValue.getValue()).build();
					this.globalValuesAsDouble.put(globalValue.getKey(), calc.calculate());

				} catch (final Exception e) {
				}

			});
		}

		return this.globalValuesAsDouble;
	}

	/**
	 * This returns the values of the {@link #globalValues} as {@link Double} values that can be used in calculations.
	 * Thereby, the {@link NamedElement#getName() names} of the respective elements are used as key in the returned map.
	 *
	 * @see #getAsDouble()
	 *
	 * @return The values of both {@link FixedValue FixedValues} and {@link GlobalAttribute GlobalAttributes}
	 *         represented as <em>double</em>.
	 */
	public Map<String, Double> getAsDoubleByString() {

		return this.getAsDouble().entrySet().stream()
				.collect(Collectors.toMap(e -> e.getKey().getName(), e -> e.getValue()));
	}

}
