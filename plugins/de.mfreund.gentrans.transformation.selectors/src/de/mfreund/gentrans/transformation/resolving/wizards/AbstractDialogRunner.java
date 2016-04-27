package de.mfreund.gentrans.transformation.resolving.wizards;

import org.eclipse.swt.widgets.Dialog;

import de.mfreund.gentrans.transformation.handler.GenericTransformationJob;

/**
 * This represents a {@link Runnable} that will spawn some sort of {@link Dialog} during an execution 
 * of a {@link GenericTransformationJob generic transformation}.
 * 
 * @author mfreund
 */
public abstract class AbstractDialogRunner implements Runnable {

	/**
	 * The message that shall be displayed in the {@link Dialog} that this runner will instantiate.
	 */
	protected final String message;
	
	/**
	 * Whether the user requested the termination of the generic transformation.
	 */
	protected boolean transformationStopRequested;
	
	/**
	 * This creates an instance.
	 * 
	 * @param message The message that shall be displayed in the {@link Dialog} that this runner will instantiate.
	 */
	public AbstractDialogRunner(final String message) {
		super();
		this.transformationStopRequested = false;
		this.message = message;
	}

	/**
	 * Whether the user has requested the termination of the transformation.
	 * 
	 * @return '<em><b>true</b></em>' if the button "Abort Transformation" was clicked during run(); 
	 * '<em><b>false</b></em>' otherwise
	 */
	public boolean wasTransformationStopRequested() {
		return transformationStopRequested;
	}

}