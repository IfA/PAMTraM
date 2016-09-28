package de.mfreund.gentrans.transformation.resolving.wizards;

import org.eclipse.swt.widgets.Dialog;

import de.mfreund.gentrans.transformation.handler.GenericTransformationJob;
import de.mfreund.gentrans.transformation.resolving.enhancing.MappingModelEnhancer;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;

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
	 * A {@link MappingModelEnhancer} that is triggered when the {@link AbstractDialog#enhanceMappingModelButton} is
	 * selected.
	 */
	protected final MappingModelEnhancer<? extends AbstractDialogRunner> enhanceMappingModelListener;

	/**
	 * This creates an instance.
	 * <p />
	 * Note: this is equivalent to calling {@link #AbstractDialogRunner(String, MappingModelEnhancer)
	 * AbstractDialog(String, null)}.
	 *
	 * @see #AbstractDialogRunner(String, MappingModelEnhancer)
	 *
	 * @param message
	 *            The message that shall be displayed in the {@link Dialog} that this runner will instantiate.
	 */
	public AbstractDialogRunner(final String message) {
		this(message, null);
	}

	/**
	 * This creates an instance.
	 * <p />
	 * If <em>enhanceMappingModelListener</em> is <em>null</em>, the {@link AbstractDialog#enhanceMappingModelButton}
	 * will be grayed out.
	 *
	 * @see #AbstractDialogRunner(String)
	 *
	 * @param message
	 *            The message that shall be displayed in the {@link Dialog} that this runner will instantiate.
	 * @param enhanceMappingModelListener
	 *            A {@link SelectionListener2} that will be called when the
	 *            {@link AbstractDialog#enhanceMappingModelButton} is clicked.
	 */
	public AbstractDialogRunner(final String message,
			final MappingModelEnhancer<? extends AbstractDialogRunner> enhanceMappingModelListener) {
		super();
		this.transformationStopRequested = false;
		this.message = message;
		this.enhanceMappingModelListener = enhanceMappingModelListener;

		if (enhanceMappingModelListener != null) {
			this.enhanceMappingModelListener.setDialogRunner(this);
		}
	}

	@Override
	public void run() {

		// Create the dialog
		//
		if(this.dialog == null) {
			this.initializeDialog();
		}

		// Open the dialog
		//
		this.dialog.open();

		// Evaluate the result
		//
		this.evaluateResults();

		this.transformationStopRequested = this.dialog.isTransformationStopRequested();
	}

	/**
	 * Whether the user has requested the termination of the transformation.
	 *
	 * @return '<em><b>true</b></em>' if the button "Abort Transformation" was clicked during run();
	 * '<em><b>false</b></em>' otherwise
	 */
	public boolean wasTransformationStopRequested() {
		return this.transformationStopRequested;
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