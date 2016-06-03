package de.mfreund.gentrans.transformation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.mapping.AttributeValueModifier;
import pamtram.mapping.AttributeValueModifierSet;

/**
 * This is a helper class to apply {@link AttributeValueModifier AttributeValueModifiers}.
 *
 * @author Sascha Steffen
 * @version 1.0
 *
 */
public class AttributeValueModifierExecutor {

	/**
	 * An output stream for messages. This is used to print error messages when the application
	 * of an AttributeValueModifier fails.
	 */
	private final MessageConsoleStream consoleStream;

	/**
	 * A set that contains all AttributeValueModifiers with errors so we don't need to send
	 * a potential error message twice
	 */
	private final Set<AttributeValueModifier> modifiersWithErrors;

	/**
	 * This constructs an instance.
	 * @param consoleStream A {@link MessageConsoleStream} that will be used to print error messages when
	 * the application of an AttributeValueModifier fails.
	 */
	public AttributeValueModifierExecutor(final MessageConsoleStream consoleStream) {
		this.consoleStream = consoleStream;
		modifiersWithErrors = new HashSet<>();
	}

	/**
	 * This applies the given list of {@link AttributeValueModifier AttributeValueModifiers} to the given
	 * '<em>value</em>'.
	 *
	 * @param value The value on which the given list of {@link AttributeValueModifier AttributeValueModifiers} shall
	 * be applied.
	 * @param modifierSets The modifiers that shall be applied to the given '<em>value</em>'.
	 * @return The modified string (after application of the {@link AttributeValueModifier AttributeValueModifiers}.
	 */
	public String applyAttributeValueModifiers(final String value,
			final EList<AttributeValueModifierSet> modifierSets) {
		String retVal = value;
		for (final AttributeValueModifierSet set : modifierSets) {
			for (final AttributeValueModifier m : set.getModifier()) {
				if (!modifiersWithErrors.contains(m)) {
					try {
						retVal = m.modifyValue(retVal);
						/*
						 * Catch an exception thrown by RegExes that aren't
						 * formatted correctly
						 */
					} catch (final Exception e) {
						modifiersWithErrors.add(m);
						consoleStream.println("The AttributeValueModifier '" + m.getName() + "' of the AttributeValueModifierSet '"
								+ set.getName() + "' could not be evaluated. The following error was supplied:\n"
								+ e.getLocalizedMessage());
					}
				}
			}
		}
		return retVal;
	}
}
