package de.mfreund.gentrans.transformation.resolving.wizards;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
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
	private static Point lastLocation;

	/**
	 * This keeps track of the last size of a dialog (possibly after being resized by the user). We use this to open
	 * each new dialog with the same exact size.
	 */
	private static Point lastSize;

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
	 * The setter for the {@link #lastLocation}.
	 *
	 * @param lastLocation
	 */
	protected static synchronized void setLastLocation(Point lastLocation) {

		AbstractDialog.lastLocation = lastLocation;
	}

	/**
	 * The getter for the {@link #lastLocation}.
	 *
	 * @param lastLocation
	 */
	protected static synchronized Point getLastLocation() {

		return AbstractDialog.lastLocation;
	}

	/**
	 * The setter for the {@link #lastSize}.
	 *
	 * @param lastSize
	 */
	protected static synchronized void setLastSize(Point lastSize) {

		AbstractDialog.lastSize = lastSize;
	}

	/**
	 * The getter for the {@link #lastSize}.
	 *
	 * @param lastSize
	 */
	protected static synchronized Point getLastSize() {

		return AbstractDialog.lastSize;
	}

	/**
	 * Create the contents of the dialog.
	 */
	protected void createContents() {

		this.shell = new Shell(this.getParent(), SWT.DIALOG_TRIM | SWT.RESIZE);

		this.shell.setMinimumSize(new Point(300, 350));
		this.shell.setSize(900, 600);
		this.shell.setText("Please select..");
		GridLayoutFactory.swtDefaults().margins(5, 0).applyTo(this.shell);

		// Create the message at the top of the dialog
		//
		this.dialogMessage = new Label(this.shell, SWT.WRAP);
		GridDataFactory.swtDefaults().hint(this.shell.getSize().x - 10, SWT.DEFAULT).applyTo(this.dialogMessage);
		this.dialogMessage.setText(this.message);
		this.shell.redraw();

		this.shell.addControlListener(new ControlAdapter() {

			@Override
			public void controlMoved(final ControlEvent e) {

				AbstractDialog.setLastLocation(AbstractDialog.this.shell.getLocation());
			}

			@Override
			public void controlResized(final ControlEvent e) {

				((GridData) AbstractDialog.this.dialogMessage.getLayoutData()).widthHint = AbstractDialog.this.shell
						.getClientArea().width - 2 * ((GridLayout) AbstractDialog.this.shell.getLayout()).marginWidth;
				AbstractDialog.this.shell.layout(true);
				AbstractDialog.setLastSize(AbstractDialog.this.shell.getSize());
			}
		});

		// Allow clients to create custom inner contents
		//
		this.createInnerContents(this.shell);

		// Create the buttons at the bottom of the dialog
		//
		this.buttonComposite = new Composite(this.shell, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(3).equalWidth(true).spacing(5, 0).applyTo(this.buttonComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).hint(564, SWT.DEFAULT)
				.applyTo(this.buttonComposite);

		this.abortTransFormationButton = new Button(this.buttonComposite, SWT.NONE);
		this.abortTransFormationButton.addSelectionListener((SelectionListener2) e -> {
			AbstractDialog.this.transformationStopRequested = true;
			AbstractDialog.this.shell.dispose();
		});

		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.CENTER).grab(true, false).minSize(80, 35)
				.applyTo(this.abortTransFormationButton);
		this.abortTransFormationButton.setAlignment(SWT.LEFT);
		this.abortTransFormationButton.setText("Abort transformation");

		this.enhanceMappingModelButton = new Button(this.buttonComposite, SWT.NONE);
		GridDataFactory.swtDefaults().align(SWT.CENTER, SWT.CENTER).grab(true, false).minSize(80, 35)
				.applyTo(this.enhanceMappingModelButton);

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
		GridDataFactory.swtDefaults().align(SWT.RIGHT, SWT.CENTER).grab(true, false).minSize(80, 35)
				.applyTo(this.okButton);

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
