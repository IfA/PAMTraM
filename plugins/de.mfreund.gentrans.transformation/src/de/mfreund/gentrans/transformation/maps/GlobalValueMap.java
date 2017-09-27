package de.mfreund.gentrans.transformation.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import pamtram.ExpressionElement;
import pamtram.FixedValue;
import pamtram.NamedElement;
import pamtram.mapping.GlobalAttribute;

/**
 * This is used to store all extracted values of {@link FixedValue FixedValues} and {@link GlobalAttribute
 * GlobalAttributes} that can be used throughout the transformation, e.g. when calculating
 * {@link ExpressionElement#getExpression() expressions}.
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

	}

	/**
	 * Add a single {@link FixedValue} to this map.
	 *
	 * @param fixedValue
	 *            the {@link FixedValue} for which the value shall be added
	 * @param value
	 *            the value to add
	 */
	public void addFixedValue(FixedValue fixedValue, String value) {

		this.fixedValues.put(fixedValue, value);
		this.globalValuesAsDouble = null;
	}

	/**
	 * Add a list of {@link FixedValue FixedValues} to this map.
	 *
	 * @param fixedValues
	 *            the {@link FixedValue FixedValues} to add
	 */
	public void addFixedValues(Map<FixedValue, String> fixedValues) {

		this.fixedValues.putAll(fixedValues);
		this.globalValuesAsDouble = null;
	}

	/**
	 * Add a single value for a {@link GlobalAttribute} to this map.
	 *
	 * @param globalAttribute
	 *            the {@link GlobalAttribute} for which the value shall be added
	 * @param value
	 *            the value to add
	 */
	public void addGlobalAttributeValue(GlobalAttribute globalAttribute, String value) {

		this.globalAttributes.put(globalAttribute, value);
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
	 * This returns all the {@link #fixedValues} stored in this map.
	 * <p />
	 * Note: This returns a clone of the internal map storing the values so removing/adding values from/to the returned
	 * map does not have any effect on the {@link #fixedValues}.
	 *
	 * @return A copy of all {@link #fixedValues}.
	 */
	public Map<FixedValue, String> getFixedValues() {

		return new HashMap<>(this.fixedValues);
	}

	/**
	 * This returns the values of all the {@link #globalAttributes} stored in this map.
	 * <p />
	 * Note: This returns a clone of the internal map storing the values so removing/adding values from/to the returned
	 * map does not have any effect on the {@link #globalAttributes}.
	 *
	 * @return A copy of all {@link #globalAttributes}.
	 */
	public Map<GlobalAttribute, String> getGlobalAttributes() {

		return new HashMap<>(this.globalAttributes);
	}

	/**
	 * This returns all the {@link #fixedValues} as well as the {@link #globalAttributes} stored in this map.
	 * <p />
	 * Note: This returns a clone of the internal maps storing the values so removing/adding values from/to the returned
	 * map does not have any effect on the {@link #fixedValues} and {@link #globalAttributes}.
	 *
	 * @return The values of both the {@link #fixedValues} and the {@link #globalAttributes}.
	 */
	public Map<NamedElement, String> getGlobalValues() {

		return Stream.of(this.fixedValues, this.globalAttributes).collect(HashMap::new, Map::putAll, Map::putAll);
	}

	/**
	 * This returns all the {@link #fixedValues} as well as the {@link #globalAttributes} stored in this map as
	 * {@link Double} values that can be used in calculations.
	 * <p />
	 * Therefore, it tries to parse a <em>double</em> value for each of the {@link #getGlobalValues()}. Values that
	 * cannot be parsed as <em>double</em> are ignored.
	 *
	 * @see #getAsDoubleByString()
	 *
	 * @return The values of both {@link #fixedValues} and {@link #globalAttributes} represented as <em>double</em>.
	 */
	public Map<NamedElement, Double> getAsDouble() {

		if (this.globalValuesAsDouble == null) {

			// If this is called the first time, we need to parse the double
			// values first
			//
			this.globalValuesAsDouble = new HashMap<>();
			this.getGlobalValues().entrySet().stream().forEach(globalValue -> {

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
	 * This returns all the {@link #fixedValues} as well as the {@link #globalAttributes} stored in this map as
	 * {@link Double} values that can be used in calculations. Thereby, the {@link NamedElement#getName() names} of the
	 * respective elements are used as key in the returned map.
	 *
	 * @see #getAsDouble()
	 *
	 * @return The values of both {@link #fixedValues} and {@link #globalAttributes} represented as <em>double</em>.
	 */
	public Map<String, Double> getAsDoubleByString() {

		return this.getAsDouble().entrySet().stream()
				.collect(Collectors.toMap(e -> e.getKey().getName(), e -> e.getValue()));
	}

}
