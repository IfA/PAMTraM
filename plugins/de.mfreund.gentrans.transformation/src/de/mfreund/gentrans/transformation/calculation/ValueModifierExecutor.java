/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.calculation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import pamtram.mapping.modifier.ValueModifier;
import pamtram.mapping.modifier.ValueModifierSet;

/**
 * This is a helper class to apply {@link ValueModifierSet ValueModifierSet}.
 *
 * @author mfreund
 */
public class ValueModifierExecutor {

	/**
	 * An {@link Logger} for messages. This is used to print error messages when the application of an
	 * AttributeValueModifier fails.
	 */
	private Logger logger;

	/**
	 * A set that contains all {@link ValueModifier ValueModifiers} with errors so we don't need to send a potential
	 * error message twice
	 */
	private final Set<ValueModifier> modifiersWithErrors;

	/**
	 * This constructs an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public ValueModifierExecutor(TransformationAssetManager assetManager) {

		this.logger = assetManager.getLogger();
		this.modifiersWithErrors = new HashSet<>();
	}

	/**
	 * This applies the given list of {@link ValueModifierSet modifierSets} to the given '<em>value</em>'.
	 *
	 * @param value
	 *            The value on which the given list of {@link ValueModifierSet modifierSets} shall be applied.
	 * @param modifierSets
	 *            The {@link ValueModifierSet modifierSets} that shall be applied to the given '<em>value</em>'.
	 * @return The modified string (after application of the {@link ValueModifierSet modifierSets}.
	 */
	public String applyAttributeValueModifiers(final String value, final List<ValueModifierSet> modifierSets) {

		String retVal = value;
		for (final ValueModifierSet set : modifierSets) {
			for (final ValueModifier m : set.getModifiers()) {
				if (!this.modifiersWithErrors.contains(m)) {
					try {
						retVal = m.modifyValue(retVal);
						/*
						 * Catch an exception thrown by RegExes that aren't formatted correctly
						 */
					} catch (final Exception e) {
						this.modifiersWithErrors.add(m);

						if (this.logger != null) {

							this.logger.warning(() -> "The ValueModifier '" + m.getName()
									+ "' of the ValueModifierSet '" + set.getName()
									+ "' could not be evaluated. The following error was supplied:\n"
									+ e.getLocalizedMessage());
						}
					}
				}
			}
		}
		return retVal;
	}
}
