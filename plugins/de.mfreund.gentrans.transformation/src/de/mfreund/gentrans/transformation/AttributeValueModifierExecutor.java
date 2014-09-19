package de.mfreund.gentrans.transformation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.mapping.AttributeValueModifier;
import pamtram.mapping.AttributeValueModifierSet;

public class AttributeValueModifierExecutor {

	public AttributeValueModifierExecutor(MessageConsoleStream consoleStream) {
		this.consoleStream=consoleStream;
		this.modifiersWithErrors=new HashSet<AttributeValueModifier>();
	}
	
	/**
	 * Output stream for messages
	 */
	private MessageConsoleStream consoleStream;

	
	/**
	 * Set that contains all ValueModifiers with errors so we don't need to send a potential error message twice
	 */
	private Set<AttributeValueModifier> modifiersWithErrors;
	
	/**
	 * Method for applying attribute value modifiers to 
	 * @param value 
	 * @param modifierSets
	 * @return modified String
	 */
	 String applyAttributeValueModifiers(final String value,
			EList<AttributeValueModifierSet> modifierSets) {
		String retVal = value;
		for (AttributeValueModifierSet set : modifierSets) {
			for (AttributeValueModifier m : set.getModifier()) {
				if(!modifiersWithErrors.contains(m)){
					try{
						retVal = m.modify(retVal);
					/*
					 * Catch an exception thrown by RegExes that aren't formatted correctly
					 */
					} catch(Exception e){
						modifiersWithErrors.add(m);
						consoleStream.println("The AttributeValueModifier '" + m.getName() + "' of the "
								+ "AttributeValueModifierSet '" + set.getName() 
								+ "' could not be evaluated. The following error was supplied:\n"
								+ e.getLocalizedMessage());
					} 
				}
			}
		}
		return retVal;
	}
}
