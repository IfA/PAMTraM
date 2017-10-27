package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import de.tud.et.ifa.agtele.ui.util.UIHelper;

/**
 * A customizable {@link TitleAreaDialog} with a message and three buttons ('<em>OK</em>', '<em>Abort
 * Transformation</em>', and <em>Enhance PAMTraM Model</em>).
 * <p />
 * An additional {@link SelectionListener2} may be passed in the constructor. This will result in the creation of an
 * additional button entitled '<em>Enhance PAMTraM Model</em>', triggering the given listener when clicked.
 *
 * @author mfreund
 */
public abstract class AbstractDialog extends TitleAreaDialog {

	/**
	 * The title for the dialog.
	 */
	private static final String DIALOG_TITLE = "Please resolve the following ambiguity...";

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
	 * A {@link SelectionListener2} that is triggered when the {@link #enhanceMappingModelButton} is selected.
	 */
	protected final SelectionListener2 enhanceMappingModelListener;

	/**
	 * The message for the dialog.
	 */
	protected String message;

	/**
	 * Create the dialog.
	 *
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param enhanceMappingModelListener2
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 */
	public AbstractDialog(String message, final Optional<SelectionListener2> enhanceMappingModelListener2) {

		super(UIHelper.getShell());

		this.setShellStyle(SWT.CLOSE | SWT.BORDER | SWT.TITLE | SWT.RESIZE);

		this.message = message;

		this.enhanceMappingModelListener = enhanceMappingModelListener2.orElse(null);
	}

	@Override
	protected Point getInitialSize() {

		return AbstractDialog.lastSize == null ? super.getInitialSize() : AbstractDialog.lastSize;
	}

	@Override
	protected Point getInitialLocation(Point initialSize) {

		return AbstractDialog.lastLocation == null ? super.getInitialLocation(initialSize)
				: AbstractDialog.lastLocation;
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

	@Override
	protected void configureShell(Shell newShell) {

		super.configureShell(newShell);

		// update the 'lastLocation' and 'lastSize' on shell movement/resizing
		//
		newShell.addControlListener(new ControlAdapter() {

			@Override
			public void controlMoved(final ControlEvent e) {

				AbstractDialog.setLastLocation(AbstractDialog.this.getShell().getLocation());
			}

			@Override
			public void controlResized(final ControlEvent e) {

				AbstractDialog.setLastSize(AbstractDialog.this.getShell().getSize());
			}
		});
	}

	@Override
	public void create() {

		super.create();

		this.setTitle(AbstractDialog.DIALOG_TITLE);
		this.setMessage(this.message);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {

		Button enhanceMappingModelButton = this.createButton(parent, IDialogConstants.OPEN_ID, "Enhance PAMTraM Model",
				false);
		enhanceMappingModelButton
				.setToolTipText("Enhance the PAMTraM model (e.g. by creating additional mapping hints) to prevent this "
						+ "user interaction in future executions of the transformation...");
		enhanceMappingModelButton.addSelectionListener((SelectionListener2) e -> {
			this.setReturnCode(IDialogConstants.OPEN_ID);
			this.close();

		});
		if (this.enhanceMappingModelListener == null) {
			enhanceMappingModelButton.setEnabled(false);
		} else {
			enhanceMappingModelButton.addSelectionListener(this.enhanceMappingModelListener);
		}
		this.createButton(parent, IDialogConstants.OK_ID, "OK", true);
		this.createButton(parent, IDialogConstants.CANCEL_ID, "Abort transformation", false);
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		Composite area = (Composite) super.createDialogArea(parent);

		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 5;
		layout.marginRight = 5;
		layout.marginLeft = 5;
		container.setLayout(layout);

		this.createInnerContents(container);

		return container;
	}

	/**
	 * This is called as part of {@link #createDialogArea(Composite)} to create the contents between the displayed
	 * message (top) and the buttons (bottom).
	 * <p />
	 * Clients must overwrite this to insert specific contents.
	 *
	 * @param container
	 */
	protected abstract void createInnerContents(Composite container);

	/**
	 * Creates and executes an {@link AbstractDialog}.
	 * <p />
	 * Note: This can be called from outside the UI thread as the dialog is executed via its own {@link Runnable}.
	 *
	 * @param <D>
	 *            The type of the {@link AbstractDialog} to be created.
	 *
	 * @param dialogSupplier
	 *            A supplier that will create the {@link AbstractDialog} to be executed.
	 * @return The created {@link AbstractDialog} after its execution.
	 * @throws AmbiguityResolvingException
	 *             If the user pressed the <em>Abort Transformation</em> button in the dialog.
	 */
	protected static <D extends AbstractDialog> D createAndExecuteDialog(Supplier<D> dialogSupplier)
			throws AmbiguityResolvingException {

		AtomicReference<D> dialogReference = new AtomicReference<>(null);

		// As we are not in the UI thread, we have to use a runnable to show the dialog in order to prevent
		// 'InvalidThreadAccess' exceptions
		//
		Display.getDefault().syncExec(() -> {

			D dialog = dialogSupplier.get();
			dialogReference.set(dialog);
			dialogReference.get().create();
			dialogReference.get().open();

		});

		if (dialogReference.get().getReturnCode() == IDialogConstants.CANCEL_ID) {
			throw new AmbiguityResolvingException(new UserAbortException());
		}

		return dialogReference.get();
	}

}
