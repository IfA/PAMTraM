package de.mfreund.gentrans.transformation.resolving;

import java.util.ArrayList;

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
	protected ArrayList<EObject> sourceModels;

	/**
	 * This keeps track of the {@link MessageConsoleStream} that can be used to print messages.
	 */
	protected MessageConsoleStream messageStream;

	@Override
	public void init(PAMTraM pamtramModel, ArrayList<EObject> sourceModels, MessageConsoleStream messageStream) throws Exception {

		this.pamtramModel = pamtramModel;
		this.sourceModels = sourceModels;
		this.messageStream = messageStream;
	}

}
