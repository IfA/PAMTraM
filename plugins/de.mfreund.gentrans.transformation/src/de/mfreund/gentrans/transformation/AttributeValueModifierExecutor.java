package de.mfreund.gentrans.transformation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.mapping.AttributeValueModifier;
import pamtram.mapping.AttributeValueModifierSet;

/**
 * Helper class to apply {@link AttributeValueModifier}s
 *
 * @author Sascha Steffen
 * @version 1.0
 *
 */
public class AttributeValueModifierExecutor {

	/**
	 * Output stream for messages
	 */
	private final MessageConsoleStream consoleStream;

	/**
	 * Set that contains all ValueModifiers with errors so we don't need to send
	 * a potential error message twice
	 */
	private final Set<AttributeValueModifier> modifiersWithErrors;

	/**
	 * @param consoleStream
	 */
	AttributeValueModifierExecutor(final MessageConsoleStream consoleStream) {
		this.consoleStream = consoleStream;
		modifiersWithErrors = new HashSet<AttributeValueModifier>();
	}

	/**
	 * Method for applying attribute value modifiers te a String
	 *
	 * @param value
	 * @param modifierSets
	 * @return modified String
	 */
	String applyAttributeValueModifiers(final String value,
			final EList<AttributeValueModifierSet> modifierSets) {
		String retVal = value;
		for (final AttributeValueModifierSet set : modifierSets) {
			for (final AttributeValueModifier m : set.getModifier()) {
				if (!modifiersWithErrors.contains(m)) {
					try {
						retVal = m.modify(retVal);
						/*
						 * Catch an exception thrown by RegExes that aren't
						 * formatted correctly
						 */
					} catch (final Exception e) {
						modifiersWithErrors.add(m);
						consoleStream
						.println("The AttributeValueModifier '"
								+ m.getName()
								+ "' of the "
								+ "AttributeValueModifierSet '"
								+ set.getName()
								+ "' could not be evaluated. The following error was supplied:\n"
								+ e.getLocalizedMessage());
					}
				}
			}
		}
		return retVal;
	}
}
