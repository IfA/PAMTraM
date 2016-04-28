package de.mfreund.gentrans.transformation.resolving.wizards;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ValueSpecificationDialog extends AbstractDialog {
	
	private String retValue;
	private Composite valueComposite;
	private Label lblValue;
	private Text textValue;
	
	/**
	 * Create the dialog.
	 *
	 * @param parent The shell on which the dialog shall be displayed.
	 * @param message The message that shall be displayed in the dialog.
	 */
	public ValueSpecificationDialog(final Shell parent, final String message) {
		
		super(parent, message);
	}
	
	@Override
	protected void createInnerContents(Shell parent) {

		// Create the composite that allows to enter a value
		//
		valueComposite = new Composite(shell, SWT.NONE);
		valueComposite.setLayout(new GridLayout(2, false));
		valueComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		lblValue = new Label(valueComposite, SWT.NONE);
		lblValue.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblValue.setText("Value:");
		
		textValue = new Text(valueComposite, SWT.BORDER);
		textValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textValue.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				retValue = textValue.getText();
			}
		});
		
	}
	
	/**
	 * Get the value specified by the user after the dialog has finished.
	 *
	 * @return The specified value as String.
	 */
	public String getValue() {

		return retValue;
	}

}
