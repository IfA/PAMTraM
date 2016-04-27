package de.mfreund.gentrans.transformation.resolving.wizards;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Shell;

/**
 * An {@link AbstractDialogRunner} that spawns a {@link ValueSpecificationDialog}.
 * 
 * @author mfreund
 */
public class ValueSpecificationDialogRunner extends AbstractDialogRunner {
	
	private String specifiedValue;

	/**
	 * This creates an instance.
	 * 
	 * @param message The message that shall be displayed in the {@link Dialog} that this runner will instantiate.
	 */
	public ValueSpecificationDialogRunner(final String message) {
		
		super(message);
	}

	/**
	 * Get the value after the dialog has finished.
	 *
	 * @return The value specified by the user.
	 */
	public String getSingleValue() {
		return specifiedValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		final ValueSpecificationDialog d = new ValueSpecificationDialog(new Shell(), message);
		d.open();
		specifiedValue = d.getValue();
		transformationStopRequested = d.isTransformationStopRequested();
	}

}
