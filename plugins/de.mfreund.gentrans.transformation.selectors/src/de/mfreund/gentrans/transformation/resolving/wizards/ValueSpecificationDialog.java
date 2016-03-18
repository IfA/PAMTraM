package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.List;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ValueSpecificationDialog extends Dialog {
	
	private static Point lastLocation;
	protected Shell shell;
	private String message;
	private boolean transformationStopRequested;
	private Composite composite;
	private Button abortTransFormationButton;
	private Composite composite_1;
	
	private String retValue;
	private Button okButton;
	private Button btnAbort;
	private Point lastSize;
	private Object result;
	private Composite valueComposite;
	private Label lblValue;
	private Text textValue;
	
	/**
	 * Create the dialog.
	 *
	 * @param parent
	 * @param style
	 */
	ValueSpecificationDialog(final Shell parent, final String message) {
		super(parent, SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE);
		setText("SWT Dialog");
		this.message = message;
		transformationStopRequested = false;
	}
	
	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.RESIZE);

		shell.setMinimumSize(new Point(300, 350));
		shell.setSize(900, 600);
		shell.setText("Please select..");
		{
			GridLayout gridLayout = new GridLayout(1, false);
			gridLayout.marginHeight = 0;
			shell.setLayout(gridLayout);
			
		}

		Label label = new Label(shell, SWT.WRAP);
		{
			GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1,
					1);
			gridData.widthHint = shell.getSize().x - 10;
			label.setLayoutData(gridData);
			label.setText(message);
			
		}
		shell.redraw();
		
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
				retValue = null;
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

		btnAbort = new Button(composite_1, SWT.NONE);
		btnAbort.setLayoutData(new RowData(80, 35));
		btnAbort.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				retValue = null;
				shell.dispose();
			}
		});
		btnAbort.setText("Abort");

		if (lastSize != null) {
			shell.setSize(lastSize);
		}

		if (lastLocation != null) {
			shell.setLocation(lastLocation);
		}

		okButton.setFocus();
	}

	/**
	 * Get the specified value after dialog has finished, returns standardSelection if
	 * dialog not run
	 *
	 * @return the specified value
	 */
	public String getValue() {

		return retValue;
	}

	/**
	 * @return true if Button "Abort Transformation" was clicked during run()
	 */
	public boolean isTransformationStopRequested() {
		return transformationStopRequested;
	}

	/**
	 * Open the dialog.
	 *
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		final Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

}
