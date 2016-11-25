package de.mfreund.gentrans.transformation.resolving.wizards;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * A simple {@link AbstractDialog} that allows the user to enter a single value.
 *
 * @author mfreund
 */
public class ValueSpecificationDialog extends AbstractDialog {

	/**
	 * The value entered by the user.
	 */
	private String retValue;

	/**
	 * Create the dialog.
	 *
	 * @param message The message that shall be displayed in the dialog.
	 */
	public ValueSpecificationDialog(final String message) {

		super(message);
	}

	@Override
	protected void createInnerContents(Shell parent) {

		// Create the composite that allows to enter a value
		//
		Composite valueComposite = new Composite(this.shell, SWT.NONE);
		valueComposite.setLayout(new GridLayout(2, false));
		valueComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Label lblValue = new Label(valueComposite, SWT.NONE);
		lblValue.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblValue.setText("Value:");

		Text textValue = new Text(valueComposite, SWT.BORDER);
		textValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textValue.addModifyListener((ModifyEvent e) -> this.retValue = textValue.getText());

	}

	/**
	 * Get the value specified by the user after the dialog has finished.
	 *
	 * @return The specified value as String.
	 */
	public String getValue() {

		return this.retValue;
	}

}
