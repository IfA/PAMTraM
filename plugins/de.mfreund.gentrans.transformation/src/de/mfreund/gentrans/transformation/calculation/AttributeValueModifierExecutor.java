package de.mfreund.gentrans.transformation.calculation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.mapping.modifier.ValueModifier;
import pamtram.mapping.modifier.ValueModifierSet;

/**
 * This is a helper class to apply {@link ValueModifier AttributeValueModifiers}.
 *
 * @author Sascha Steffen
 * @version 1.0
 *
 */
public class AttributeValueModifierExecutor {

	/**
	 * This keeps track of the single instance.
	 */
	private static AttributeValueModifierExecutor instance;

	/**
	 * An {@link Logger} for messages. This is used to print error messages when
	 * the application of an AttributeValueModifier fails.
	 */
	private Logger logger;

	/**
	 * A set that contains all AttributeValueModifiers with errors so we don't need to send
	 * a potential error message twice
	 */
	private final Set<ValueModifier> modifiersWithErrors;

	/**
	 * This constructs an instance.
	 *
	 * @param logger
	 *            A {@link Logger} that will be used to print error messages
	 *            when the application of an AttributeValueModifier fails.
	 */
	private AttributeValueModifierExecutor(final Logger logger) {
		this.logger = logger;
		this.modifiersWithErrors = new HashSet<>();
		AttributeValueModifierExecutor.instance = this;
	}

	/**
	 * This returns the single {@link #instance}.
	 * <p />
	 * Note: This will {@link #init(Logger) initialize} the instance if necessary but without any
	 * {@link MessageConsoleStream}. Thus, {@link #init(Logger)} should be called once before using this in order to
	 * allow for printing messages.
	 *
	 * @return The single {@link #instance}.
	 */
	public static AttributeValueModifierExecutor getInstance() {

		if(AttributeValueModifierExecutor.instance == null) {
			AttributeValueModifierExecutor.init(null);
		}

		return AttributeValueModifierExecutor.instance;
	}

	/**
	 * This initializes and returns the {@link #instance} based on the given
	 * {@link MessageConsoleStream}. This should be called once before
	 * {@link #getInstance()} in order to set the correct
	 * {@link MessageConsoleStream} to use.
	 *
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 * @return The {@link #instance}.
	 */
	public static AttributeValueModifierExecutor init(final Logger logger) {

		// Either create the single instance or only set the consoleStream
		//
		if(AttributeValueModifierExecutor.instance == null) {
			new AttributeValueModifierExecutor(logger);
		} else {
			AttributeValueModifierExecutor.instance.logger = logger;
		}

		return AttributeValueModifierExecutor.instance;
	}

	/**
	 * This applies the given list of {@link ValueModifier AttributeValueModifiers} to the given
	 * '<em>value</em>'.
	 *
	 * @param value The value on which the given list of {@link ValueModifier AttributeValueModifiers} shall
	 * be applied.
	 * @param modifierSets The modifiers that shall be applied to the given '<em>value</em>'.
	 * @return The modified string (after application of the {@link ValueModifier AttributeValueModifiers}.
	 */
	public String applyAttributeValueModifiers(final String value,
			final List<ValueModifierSet> modifierSets) {
		String retVal = value;
		for (final ValueModifierSet set : modifierSets) {
			for (final ValueModifier m : set.getModifier()) {
				if (!this.modifiersWithErrors.contains(m)) {
					try {
						retVal = m.modifyValue(retVal);
						/*
						 * Catch an exception thrown by RegExes that aren't
						 * formatted correctly
						 */
					} catch (final Exception e) {
						this.modifiersWithErrors.add(m);

						if(this.logger != null) {

							this.logger.warning("The AttributeValueModifier '" + m.getName()
							+ "' of the AttributeValueModifierSet '"
							+ set.getName() + "' could not be evaluated. The following error was supplied:\n"
							+ e.getLocalizedMessage());
						}
					}
				}
			}
		}
		return retVal;
	}
}
