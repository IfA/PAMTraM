package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.Optional;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;

/**
 * A simple {@link AbstractDialog} that allows the user to enter a single value.
 *
 * @author mfreund
 */
public class ValueSpecificationDialog extends AbstractDialog {

	/**
	 * The value entered by the user.
	 */
	protected String retValue;

	/**
	 * Create the dialog.
	 *
	 * @param title
	 *            The title for the dialog.
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 */
	public ValueSpecificationDialog(String title, String message,
			Optional<SelectionListener2> enhanceMappingModelListener) {

		super(title, message, enhanceMappingModelListener);
	}

	@Override
	protected void createInnerContents(Composite container) {

		// Create the composite that allows to enter a value
		//
		Composite valueComposite = new Composite(container, SWT.NONE);
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
