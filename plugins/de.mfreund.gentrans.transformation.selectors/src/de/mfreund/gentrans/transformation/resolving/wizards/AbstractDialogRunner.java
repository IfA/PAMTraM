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
	 * The {@link AbstractDialog} that will be presented to the user.
	 */
	protected AbstractDialog dialog;

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
	
	@Override
	public void run() {

		// Create the dialog
		//
		if(dialog == null) {
			initializeDialog();
		}

		// Open the dialog
		//
		dialog.open();

		// Evaluate the result
		//
		evaluateResults();
		
		transformationStopRequested = dialog.isTransformationStopRequested();
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
	
	/**
	 * Creates and initializes the {@link #dialog} that will be presented to the user.
	 * <p />
	 * Note: This is called exactly once as part of the {@link #run()} method before the dialog is opened. 
	 * Implementations must not {@link AbstractDialog#open() open} the dialog as this is done as part of {@link #run()}.
	 */
	protected abstract void initializeDialog();
	
	/**
	 * Evaluate the results after the dialog has been closed.
	 * <p />
	 * Note: This is called exactly once as part of the {@link #run()} method after the dialog is closed.
	 */
	protected abstract void evaluateResults();

}