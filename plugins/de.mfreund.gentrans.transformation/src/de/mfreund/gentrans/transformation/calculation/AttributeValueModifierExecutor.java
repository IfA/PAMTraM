package de.mfreund.gentrans.transformation.calculation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	 * This keeps track of the single instance.
	 */
	private static AttributeValueModifierExecutor instance;

	/**
	 * An output stream for messages. This is used to print error messages when the application
	 * of an AttributeValueModifier fails.
	 */
	private MessageConsoleStream consoleStream;

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
	private AttributeValueModifierExecutor(final MessageConsoleStream consoleStream) {
		this.consoleStream = consoleStream;
		modifiersWithErrors = new HashSet<>();
		instance = this;
	}
	
	/**
	 * This returns the single {@link #instance}.
	 * <p />
	 * Note: This will {@link #init(MessageConsoleStream) initialize} the instance if necessary
	 * but without any {@link MessageConsoleStream}. Thus, {@link #init(MessageConsoleStream)}
	 * should be called once before using this in order to allow for printing messages.
	 * 
	 * @return The single {@link #instance}.
	 */
	public static AttributeValueModifierExecutor getInstance() {
		
		if(instance == null) {
			init(null);
		}
		
		return instance;
	}
	
	/**
	 * This initializes and returns the {@link #instance} based on the given {@link MessageConsoleStream}.
	 * This should be called once before {@link #getInstance()} in order to set the 
	 * correct {@link MessageConsoleStream} to use.
	 * 
	 * @param consoleStream The {@link MessageConsoleStream} that shall be used to print messages.
	 * @return The {@link #instance}.
	 */
	public static AttributeValueModifierExecutor init(final MessageConsoleStream consoleStream) {
		
		// Either create the single instance or only set the consoleStream
		//
		if(instance == null) {
			new AttributeValueModifierExecutor(consoleStream);			
		} else {
			instance.consoleStream = consoleStream;
		}
		
		return instance;
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
			final List<AttributeValueModifierSet> modifierSets) {
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

						if(consoleStream != null) {
							
							consoleStream.println("The AttributeValueModifier '" + m.getName() + "' of the AttributeValueModifierSet '"
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
