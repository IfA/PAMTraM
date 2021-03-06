/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.calculation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import pamtram.ExpressionElement;
import pamtram.ModifiableElement;
import pamtram.NamedElement;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.AttributeMatcher;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.util.ExpressionCalculator;

/**
 * This class can be used to calculate values (e.g. of {@link TargetSectionAttribute TargetSectionAttributes}) based on
 * a list of value parts and an optional {@link ExpressionElement#getExpression() expression}.
 *
 * @author mfreund
 */
public class ValueCalculator {

	/**
	 * used for modifying attribute values
	 */
	private final ValueModifierExecutor valuemodifierExecutor;

	/**
	 * Registry for global values that can be used in expressions.
	 */
	private final GlobalValueMap globalValues;

	/**
	 * The {@link Logger} to be used to print messages.
	 */
	private Logger logger;

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public ValueCalculator(TransformationAssetManager assetManager) {

		this.valuemodifierExecutor = assetManager.getValueModifierExecutor();
		this.globalValues = assetManager.getGlobalValues();
		this.logger = assetManager.getLogger();
	}

	/**
	 * This calculates the value of a {@link TargetSectionAttribute} for a given {@link MappingHint} and a list of hint
	 * values.
	 *
	 * @param attr
	 *            The {@link TargetSectionAttribute} for which the target value is calculated or <em>null</em> if the
	 *            given hint is a {@link ReferenceTargetSelector}.
	 * @param hint
	 *            A {@link MappingHint} to be used for the calculation (typically, this should be either an
	 *            {@link AttributeMapping}, a {@link ReferenceTargetSelector} with {@link AttributeMatcher}, or
	 *            <em>null</em> if no hint has been found.
	 * @param attrHintValueList
	 *            A list of hint values to be used in the calculation. Each entry of the list represents the hint values
	 *            for one instance that is created.
	 * @return The calculated attribute value or <em>null</em> if no value could be calculated.
	 */
	public String calculateAttributeValue(final TargetSectionAttribute attr, MappingHint hint,
			LinkedList<Map<?, AttributeValueRepresentation>> attrHintValueList) {

		if (attrHintValueList == null) {
			return this.calculateAttributeValue(attr, hint, (Map<?, AttributeValueRepresentation>) null);
		} else {

			// this is the map of hint values that we will use for this
			// calculation
			Map<?, AttributeValueRepresentation> attrHintValues = attrHintValueList.removeFirst();
			return this.calculateAttributeValue(attr, hint, attrHintValues);
		}
	}

	/**
	 * This calculates the value of a {@link TargetSectionAttribute} for a given {@link MappingHint} and one hint
	 * values.
	 *
	 * @param attr
	 *            The {@link TargetSectionAttribute} for which the target value is calculated or <em>null</em> if the
	 *            given hint is a {@link ReferenceTargetSelector}.
	 * @param hint
	 *            A {@link MappingHint} to be used for the calculation (typically, this should be either an
	 *            {@link AttributeMapping}, a {@link ReferenceTargetSelector} with {@link AttributeMatcher}, or
	 *            <em>null</em> if no hint has been found.
	 * @param attrHintValue
	 *            The hint value to be used in the calculation.
	 *
	 * @return The calculated attribute value or <em>null</em> if no value could be calculated.
	 */
	public String calculateAttributeValue(final TargetSectionAttribute attr, MappingHint hint,
			Map<?, AttributeValueRepresentation> attrHintValue) {

		String attrValue = null;
		if (attrHintValue != null) {

			// determine the value of the 'expression' attribute
			String expression = "";
			if (hint instanceof ExpressionElement) {
				expression = ((ExpressionElement) hint).getExpression();
			}

			List<ValueModifierSet> resultModifiers = new ArrayList<>();
			if (hint instanceof ModifiableElement) {
				resultModifiers.addAll(((ModifiableElement) hint).getModifiers());
			}

			// calculate the value based on the hint values and a possible
			// expression
			if (expression.isEmpty()) {
				attrValue = this.calculateAttributeValueWithoutExpression(hint, attrHintValue, resultModifiers);
			} else {
				attrValue = this.calculateAttributeValueWithExpression(hint, attrHintValue, expression,
						resultModifiers);
			}

		}
		// only use value of target section if no hint value
		// present
		if (attr != null && attr.getValue() != null && attrValue == null && !attr.getValue().isEmpty()) {
			attrValue = attr.getValue();
		}
		return attrValue;

	}

	/**
	 * This calculates an attribute value based on a list of given hint values.
	 **
	 * @param hint
	 *            A {@link MappingHint} to be used for the calculation (typically, this should be either an
	 *            {@link AttributeMapping}, a {@link ReferenceTargetSelector} with {@link AttributeMatcher}, or
	 *            <em>null</em> if no hint has been found.
	 * @param hintValues
	 *            A list of hint values to be used in the calculation.
	 * @param resultModifiers
	 *            The list of {@link ValueModifierSet} to apply to the resulting value.
	 * @return The calculated attribute value or <em>null</em> if no value could be calculated.
	 */
	private String calculateAttributeValueWithoutExpression(MappingHint hint,
			Map<?, AttributeValueRepresentation> hintValues, List<ValueModifierSet> resultModifiers) {

		return this.calculateValueWithoutExpression(hintValues, resultModifiers);
	}

	/**
	 * This calculates an attribute value based on a list of given hint values and an expression.
	 **
	 * @param hint
	 *            A {@link MappingHint} to be used for the calculation (typically, this should be either an
	 *            {@link AttributeMapping}, a {@link ReferenceTargetSelector} with {@link AttributeMatcher}, or
	 *            <em>null</em> if no hint has been found.
	 * @param attrHintValues
	 *            A list of hint values to be used in the calculation.
	 * @param expression
	 *            An expression to be used to calculate the hint values.
	 * @param resultModifiers
	 *            The list of {@link ValueModifierSet} to apply to the resulting value.
	 * @return The calculated attribute value or <em>null</em> if no value could be calculated.
	 */
	private String calculateAttributeValueWithExpression(MappingHint hint,
			Map<?, AttributeValueRepresentation> attrHintValues, String expression,
			List<ValueModifierSet> resultModifiers) {

		if (hint instanceof AttributeMapping && !((AttributeMapping) hint).getSourceElements().isEmpty()
				&& attrHintValues.isEmpty()) {
			this.logger.severe(() -> "Error calculating the expression for hint '" + hint.getName() + "'."
					+ "No hint values have been passed.");
			return null;
		}

		return this.calculateValueWithExpression(attrHintValues, expression, resultModifiers);
	}

	/**
	 * Based on the given map of <em>valueParts</em> and an optional <em>expression</em>, this assembles a single String
	 * value. If no expression is given, the order, in which the value parts are assembled is determined by the (order
	 * of the) list of <em>sourceElements</em>.
	 * <p />
	 * Note: Normally, one {@link AttributeValueRepresentation value} for each of the given <em>sourceElements</em>
	 * should exist in the given map of <em>valueParts</em>.
	 * <p />
	 * Note: This simply redirects to {@link #calculateValueWithExpression(Map, String, List)} or
	 * {@link #calculateAttributeValueWithoutExpression(MappingHint, Map, List)}.
	 *
	 * @param expression
	 *            An optional mathematical expression based on which the resulting value is calculated (if this is
	 *            '<em>null</em>' or an empty string, the <em>valueParts</em> are simply stringed together).
	 * @param valueParts
	 *            The value parts (the keys of the map should match the list of <em>sourceElements</em>).
	 * @param resultModifiers
	 *            A list of {@link ValueModifierSet AttributeValueModifierSets} to apply to the resulting value before
	 *            returning it.
	 * @return The assembled value after applying the <em>resultModifiers</em>.
	 */
	public String calculateValue(String expression, Map<?, AttributeValueRepresentation> valueParts,
			List<ValueModifierSet> resultModifiers) {

		return expression != null && !expression.isEmpty()
				? this.calculateValueWithExpression(valueParts, expression, resultModifiers)
				: this.calculateValueWithoutExpression(valueParts, resultModifiers);
	}

	/**
	 * From the given map of <em>valueParts</em>, this assembles a single String value. The order, in which the value
	 * parts are assembled is thereby determined by the (order of the) list of <em>sourceElements</em>.
	 * <p />
	 * Note: Normally, one {@link AttributeValueRepresentation value} for each of the given <em>sourceElements</em>
	 * should exist in the given map of <em>valueParts</em>. Additionally, potential
	 * {@link ModifiableElement#getModifiers() modifiers} for each <em>sourceElement</em> (resp. the corresponding
	 * value) have to be applied before calling this.
	 *
	 * @param valueParts
	 *            The value parts (the keys of the map should match the list of <em>sourceElements</em>).
	 * @param resultModifiers
	 *            A list of {@link ValueModifierSet AttributeValueModifierSets} to apply to the resulting value before
	 *            returning it.
	 * @return The assembled value after applying the <em>resultModifiers</em>.
	 */
	public String calculateValueWithoutExpression(Map<?, AttributeValueRepresentation> valueParts,
			List<ValueModifierSet> resultModifiers) {

		StringBuilder attrValueBuilder = new StringBuilder();

		valueParts.entrySet().stream().forEach(e -> attrValueBuilder.append(e.getValue().getNextValue()));

		return this.valuemodifierExecutor.applyAttributeValueModifiers(attrValueBuilder.toString(), resultModifiers);
	}

	/**
	 * From the given map of <em>valueParts</em>, this calculates a single String value using the given expression.
	 * <p />
	 * Note: potential {@link ModifiableElement#getModifiers() modifiers} for each <em>sourceElement</em> (resp. the
	 * corresponding value) have to be applied before calling this.
	 * <p />
	 * If no value parts are passed (i.e. <em>valueParts</em> is <em>null</em> or <em>empty</em>) the value of the
	 * expression is returned.
	 *
	 * @param valueParts
	 *            The value parts to use for the evaluation of the expression.
	 * @param expression
	 *            The expression to calculate.
	 * @param resultModifiers
	 *            A list of {@link ValueModifierSet AttributeValueModifierSets} to apply to the resulting value before
	 *            returning it.
	 * @return The calculated value after applying the <em>resultModifiers</em>.
	 */
	public String calculateValueWithExpression(Map<?, AttributeValueRepresentation> valueParts, String expression,
			List<ValueModifierSet> resultModifiers) {

		final Map<String, Double> vars = new HashMap<>();

		// Add global variables
		//
		vars.putAll(this.globalValues.getAsDoubleByString());

		// Add local variables (as double)
		//
		for (Entry<?, AttributeValueRepresentation> entry : valueParts.entrySet()) {

			Object key = entry.getKey();
			String value = entry.getValue().getNextValue();

			try {
				if (key instanceof NamedElement) {
					vars.put(((NamedElement) key).getName(), Double.valueOf(value));
				} else if (key instanceof String) {
					vars.put((String) key, Double.valueOf(value));
				}
			} catch (NumberFormatException e) {
				this.logger.warning(() -> "Error parsing double of value '" + value + "'.");
			}
		}

		// Calculate the value
		//
		ExpressionCalculator expCalc = new ExpressionCalculator(this.logger);
		String attrValue = expCalc.calculateExpression(expression, vars);

		// Apply the result modifiers
		return attrValue == null ? expression
				: this.valuemodifierExecutor.applyAttributeValueModifiers(attrValue, resultModifiers);
	}
}
