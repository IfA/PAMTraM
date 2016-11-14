package de.mfreund.gentrans.transformation.resolving.wizards;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import de.tud.et.ifa.agtele.ui.util.UIHelper;

/**
 * A customizable {@link Dialog} with a message and two buttons ('<em>OK</em>' and '<em>Abort Transformation</em>'). The
 * dialog will return a result of the type '<em>ResultType</em>'.
 * <p />
 * An additional {@link SelectionListener2} may be passed in the constructor. This will result in the creation of an
 * additional button entitled '<em>Enhance PAMTraM Model</em>', triggering the given listener when clicked.
 *
 * @author mfreund
 */
public abstract class AbstractDialog extends Dialog {

	/**
	 * This keeps track of the last location where a dialog was situated (possibly after being moved by the user). We
	 * use this to open each new dialog at the same exact position.
	 */
	protected static Point lastLocation;

	/**
	 * This keeps track of the last size of a dialog (possibly after being resized by the user). We use this to open
	 * each new dialog with the same exact size.
	 */
	protected static Point lastSize;

	/**
	 * This is the {@link Button} that allows the user to confirm his selection.
	 */
	protected Button okButton;

	/**
	 * This is the {@link Button} that allows the user to trigger the enhancement of the mapping model.
	 */
	protected Button enhanceMappingModelButton;

	/**
	 * A {@link SelectionListener2} that is triggered when the {@link #enhanceMappingModelButton} is selected.
	 */
	protected final SelectionListener2 enhanceMappingModelListener;

	/**
	 * This is the {@link Button} that allows the user to abort the transformation.
	 */
	protected Button abortTransFormationButton;

	/**
	 * This is the {@link Label} that dispalys the {@link #message} to the user and that is placed at the top of the
	 * dialog.
	 */
	protected Label dialogMessage;

	/**
	 * This is the {@link Composite} that holds the {@link #okButton} and the {@link #abortTransFormationButton} and
	 * that is placed at the bottom of the dialog.
	 */
	protected Composite buttonComposite;

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
	 * <p />
	 * Note: this is equivalent to calling {@link #AbstractDialog(String, SelectionListener2) AbstractDialog(String,
	 * null)}.
	 *
	 * @see #AbstractDialog(String, SelectionListener2)
	 *
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 */
	public AbstractDialog(final String message) {

		this(message, null);
	}

	/**
	 * Create the dialog.
	 * <p />
	 * If <em>enhanceMappingModelListener</em> is <em>null</em>, the {@link #enhanceMappingModelButton} will be grayed
	 * out.
	 *
	 * @see #AbstractDialog(String)
	 *
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param enhanceMappingModelListener
	 *            A {@link SelectionListener2} that will be called when the {@link #enhanceMappingModelButton} is
	 *            clicked.
	 */
	public AbstractDialog(final String message, final SelectionListener2 enhanceMappingModelListener) {

		super(UIHelper.getShell(), SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE);

		this.setText("SWT Dialog");
		this.message = message;
		this.transformationStopRequested = false;
		this.enhanceMappingModelListener = enhanceMappingModelListener;
	}

	/**
	 * Create the contents of the dialog.
	 */
	protected void createContents() {

		this.shell = new Shell(this.getParent(), SWT.DIALOG_TRIM | SWT.RESIZE);

		this.shell.setMinimumSize(new Point(300, 350));
		this.shell.setSize(900, 600);
		this.shell.setText("Please select..");

		// Create the message at the top of the dialog
		//
		final GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginHeight = 0;
		this.shell.setLayout(gridLayout);

		this.dialogMessage = new Label(this.shell, SWT.WRAP);
		final GridData gd_dialogMessage = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dialogMessage.widthHint = this.shell.getSize().x - 10;
		this.dialogMessage.setLayoutData(gd_dialogMessage);
		this.dialogMessage.setText(this.message);
		this.shell.redraw();

		this.shell.addControlListener(new ControlAdapter() {

			@Override
			public void controlMoved(final ControlEvent e) {

				AbstractDialog.lastLocation = AbstractDialog.this.shell.getLocation();
			}

			@Override
			public void controlResized(final ControlEvent e) {

				gd_dialogMessage.widthHint = AbstractDialog.this.shell.getClientArea().width
						- 2 * gridLayout.marginWidth;
				AbstractDialog.this.shell.layout(true);
				AbstractDialog.lastSize = AbstractDialog.this.shell.getSize();
			}
		});

		// Allow clients to create custom inner contents
		//
		this.createInnerContents(this.shell);

		// Create the buttons at the bottom of the dialog
		//
		this.buttonComposite = new Composite(this.shell, SWT.NONE);
		final GridLayout gl_composite = new GridLayout(3, true);
		gl_composite.verticalSpacing = 0;
		this.buttonComposite.setLayout(gl_composite);
		final GridData gd_composite = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_composite.widthHint = 564;
		this.buttonComposite.setLayoutData(gd_composite);

		this.abortTransFormationButton = new Button(this.buttonComposite, SWT.NONE);
		this.abortTransFormationButton.addSelectionListener((SelectionListener2) e -> {
			AbstractDialog.this.transformationStopRequested = true;
			AbstractDialog.this.shell.dispose();
		});
		final GridData gd_abortTransFormationButton = new GridData(SWT.LEFT, SWT.FILL, true, false, 1, 1);
		gd_abortTransFormationButton.minimumWidth = 80;
		gd_abortTransFormationButton.minimumHeight = 35;
		this.abortTransFormationButton.setLayoutData(gd_abortTransFormationButton);
		this.abortTransFormationButton.setAlignment(SWT.LEFT);
		this.abortTransFormationButton.setText("Abort transformation");

		this.enhanceMappingModelButton = new Button(this.buttonComposite, SWT.NONE);
		GridData gd_enhanceMappingModelButton = new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1);
		gd_enhanceMappingModelButton.minimumHeight = 35;
		gd_enhanceMappingModelButton.minimumWidth = 80;
		this.enhanceMappingModelButton.setLayoutData(gd_enhanceMappingModelButton);
		if (this.enhanceMappingModelListener != null) {
			this.enhanceMappingModelButton.addSelectionListener(this.enhanceMappingModelListener);
			this.enhanceMappingModelButton.addSelectionListener((SelectionListener2) e -> {
				AbstractDialog.this.transformationStopRequested = true;
				AbstractDialog.this.shell.dispose();
			});
		} else {
			this.enhanceMappingModelButton.setEnabled(false);
		}
		this.enhanceMappingModelButton.setText("Enhance PAMTraM Model");
		this.enhanceMappingModelButton
				.setToolTipText("Enhance the PAMTraM model (e.g. by creating additional mapping hints) to prevent this "
						+ "user interaction in future executions of the transformation...");

		this.okButton = new Button(this.buttonComposite, SWT.NONE);
		GridData gd_okButton = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_okButton.minimumHeight = 35;
		gd_okButton.minimumWidth = 80;
		this.okButton.setLayoutData(gd_okButton);
		this.okButton.addSelectionListener((SelectionListener2) e -> AbstractDialog.this.shell.dispose());
		this.okButton.setText("OK");
		this.okButton.setSelection(true);

		this.okButton.setFocus();

		if (AbstractDialog.lastSize != null) {
			this.shell.setSize(AbstractDialog.lastSize);
		}

		if (AbstractDialog.lastLocation != null) {
			this.shell.setLocation(AbstractDialog.lastLocation);
		}
	}

	/**
	 * This is called as part of {@link #createContents()} to create the contents between the displayed message (top)
	 * and the ok/abort buttons (bottom).
	 * <p />
	 * Clients must overwrite this to insert specific contents.
	 *
	 * @param parent
	 */
	protected abstract void createInnerContents(Shell parent);

	/**
	 * Whether the user has requested the termination of the transformation.
	 *
	 * @return '<em><b>true</b></em>' if the button "Abort Transformation" was clicked during run();
	 *         '<em><b>false</b></em>' otherwise
	 */
	public boolean isTransformationStopRequested() {

		return this.transformationStopRequested;
	}

	/**
	 * Open the dialog.
	 */
	public void open() {

		this.createContents();

		this.shell.open();
		this.shell.layout();

		final Display display = this.getParent().getDisplay();
		while (!this.shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
