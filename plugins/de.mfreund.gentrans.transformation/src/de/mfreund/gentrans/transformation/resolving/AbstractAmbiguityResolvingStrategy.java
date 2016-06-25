package de.mfreund.gentrans.transformation.resolving;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.PAMTraM;

/**
 * This provides an abstract, extensible implementation of {@link IAmbiguityResolvingStrategy}.
 * 
 * @author mfreund
 */
public abstract class AbstractAmbiguityResolvingStrategy implements IAmbiguityResolvingStrategy {

	/**
	 * This keeps track of the {@link PAMTraM} instance that the current transformation operates on.
	 */
	protected PAMTraM pamtramModel;

	/**
	 * This keeps track of the list of {@link EObject sourceModels} that serve as input to the current transformation.
	 */
	protected List<EObject> sourceModels;

	/**
	 * This keeps track of the {@link MessageConsoleStream} that can be used to print messages. Messages can be written
	 * via {@link #printMessage(String)} or {@link #printMessage(String, String)}.
	 */
	private MessageConsoleStream messageStream;

	@Override
	public void init(PAMTraM pamtramModel, List<EObject> sourceModels, MessageConsoleStream messageStream)
			throws Exception {

		this.messageStream = messageStream;

		printMessage("Initializing strategy '" + this.getClass().getSimpleName() + "'...");

		this.pamtramModel = pamtramModel;
		this.sourceModels = sourceModels;
	}

	/**
	 * This prints a message to the {@link #messageStream}.
	 * <p/>
	 * Note: If '<em>messageStream</em>' is '<em>null</em>' a call of this method will do nothing.
	 * 
	 * @param message The message to print.
	 */
	protected void printMessage(String message) {
		if(messageStream != null) {
			messageStream.println(message);
		}
	}

	/**
	 * This prints a prefixed message to the {@link #messageStream}. The message will be formatted as follows: <br />
	 * "[prefix] message".
	 * <p/>
	 * Note: If '<em>messageStream</em>' is '<em>null</em>' a call of this method will do nothing.
	 * 
	 * @param message The message to print.
	 */
	protected void printMessage(String message, String prefix) {
		if(messageStream != null) {
			messageStream.println("[" + prefix + "]" + message);
		}
	}
}
