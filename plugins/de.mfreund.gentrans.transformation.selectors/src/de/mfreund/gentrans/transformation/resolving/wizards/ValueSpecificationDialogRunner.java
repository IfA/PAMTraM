package de.mfreund.gentrans.transformation.resolving.wizards;

import org.eclipse.swt.widgets.Dialog;

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

	@Override
	protected void initializeDialog() {
		
		dialog = new ValueSpecificationDialog(message);
	}

	@Override
	protected void evaluateResults() {
		
		specifiedValue = ((ValueSpecificationDialog) dialog).getValue();
	}

}
