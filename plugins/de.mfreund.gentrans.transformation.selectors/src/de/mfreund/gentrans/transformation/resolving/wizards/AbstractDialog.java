package de.mfreund.gentrans.transformation.resolving.wizards;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * A customizable {@link Dialog} with a message and two buttons ('<em>OK</em>' and '<em>Abort Transformation</em>'). The
 * dialog will return a result of the type '<em>ResultType</em>'.
 * 
 * @author mfreund
 */
public abstract class AbstractDialog extends Dialog {

	protected static Point lastLocation;
	protected static Point lastSize;
	protected Button okButton, abortTransFormationButton;
	protected Composite composite;
	protected Composite composite_1;
	protected Label dialogMessage;
	protected GridData gd_dialogMessage;
	protected GridLayout gridLayout;
	
	/**
	 * The message that shall be displayed in the {@link Dialog} that this runner will instantiate.
	 */
	protected final String message;
	
	/**
	 * Whether the user requested the termination of the generic transformation.
	 */
	protected boolean transformationStopRequested;
	
	/**
	 * The {@link Shell} on that this dialog will be created.
	 */
	protected Shell shell;
	
	/**
	 * Create the dialog.
	 * 
	 * @param parent The shell on which the dialog shall be displayed.
	 * @param message The message that shall be displayed in the dialog.
	 */
	public AbstractDialog(final Shell parent, final String message) {
		
		super(parent, SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE);
		
		setText("SWT Dialog");
		this.message = message;
		transformationStopRequested = false;
	}
	
	/**
	 * Create the contents of the dialog.
	 */
	protected void createContents() {
		
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.RESIZE);

		shell.setMinimumSize(new Point(300, 350));
		shell.setSize(900, 600);
		shell.setText("Please select..");
		
		// Create the message at the top of the dialog
		//
		gridLayout = new GridLayout(1, false);
		gridLayout.marginHeight = 0;
		shell.setLayout(gridLayout);

		dialogMessage = new Label(shell, SWT.WRAP);
		gd_dialogMessage = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1,
				1);
		gd_dialogMessage.widthHint = shell.getSize().x - 10;
		dialogMessage.setLayoutData(gd_dialogMessage);
		dialogMessage.setText(message);
		shell.redraw();

		shell.addControlListener(new ControlAdapter() {
			@Override
			public void controlMoved(final ControlEvent e) {
				lastLocation = shell.getLocation();
			}

			@Override
			public void controlResized(final ControlEvent e) {
				gd_dialogMessage.widthHint = shell.getClientArea().width
						- 2 * gridLayout.marginWidth;
				shell.layout(true);
				lastSize = shell.getSize();
			}
		});
		
		// Allow clients to create custom inner contents
		//
		createInnerContents(shell);

		// Create the buttons at the bottom of the dialog
		//
		composite = new Composite(shell, SWT.NONE);
		final GridLayout gl_composite = new GridLayout(2, true);
		gl_composite.verticalSpacing = 0;
		gl_composite.marginWidth = 0;
		gl_composite.marginHeight = 0;
		composite.setLayout(gl_composite);
		final GridData gd_composite = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_composite.widthHint = 564;
		composite.setLayoutData(gd_composite);

		abortTransFormationButton = new Button(composite, SWT.NONE);
		abortTransFormationButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				transformationStopRequested = true;
				shell.dispose();
			}
		});
		final GridData gd_abortTransFormationButton = new GridData(SWT.LEFT,
				SWT.FILL, false, false, 1, 1);
		gd_abortTransFormationButton.minimumWidth = 80;
		gd_abortTransFormationButton.minimumHeight = 35;
		abortTransFormationButton.setLayoutData(gd_abortTransFormationButton);
		abortTransFormationButton.setAlignment(SWT.LEFT);
		abortTransFormationButton.setText("Abort transformation");

		composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true,
				false, 1, 1));
		final RowLayout rl_composite_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_1.marginBottom = 0;
		rl_composite_1.marginLeft = 0;
		rl_composite_1.marginRight = 0;
		rl_composite_1.marginTop = 0;
		rl_composite_1.spacing = 0;
		rl_composite_1.fill = true;
		composite_1.setLayout(rl_composite_1);

		okButton = new Button(composite_1, SWT.NONE);
		okButton.setLayoutData(new RowData(80, 35));
		okButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				shell.dispose();
			}
		});
		okButton.setText("OK");
		okButton.setSelection(true);

		if (lastSize != null) {
			shell.setSize(lastSize);
		}

		if (lastLocation != null) {
			shell.setLocation(lastLocation);
		}

		okButton.setFocus();
	}

	/**
	 * This is called as part of {@link #createContents()} to create the contents between the displayed message
	 * (top) and the ok/abort buttons (bottom).
	 * <p />
	 * Clients must overwrite this to insert specific contents. 
	 * @param parent
	 */
	protected abstract void createInnerContents(Shell parent);
	
	/**
	 * Whether the user has requested the termination of the transformation.
	 * 
	 * @return '<em><b>true</b></em>' if the button "Abort Transformation" was clicked during run(); 
	 * '<em><b>false</b></em>' otherwise
	 */
	public boolean isTransformationStopRequested() {
		return transformationStopRequested;
	}
	
	/**
	 * Open the dialog.
	 */
	public void open() {
		
		createContents();
		
		shell.open();
		shell.layout();
		
		final Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
