package de.mfreund.gentrans.transformation.selectors;

import java.util.List;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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

/**
 * @author Sascha Steffen
 * @version 1.0
 *
 *          Dialog for choosing a path and an instance during step 3 of the
 *          GenTrans.
 *
 */
public class PathAndInstanceSelectorDialog extends Dialog {

	private static Point lastLocation;
	private static Point lastSize;
	private Label dialogMessage;
	private GridData gd_dialogMessage;
	private GridLayout gridLayout;
	private final List<List<String>> instances;
	private org.eclipse.swt.widgets.List instancesList;
	private final String message;
	protected String path, instance;
	private org.eclipse.swt.widgets.List pathList;
	private final List<String> paths;
	protected Object result;
	protected Shell shlPleaseSelectA;

	private boolean transformationStopRequested;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public PathAndInstanceSelectorDialog(final Shell parent,
			final String message, final List<String> paths,
			final List<List<String>> instances) {
		super(parent, SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE);
		setText("SWT Dialog");
		this.paths = paths;
		this.instances = instances;
		this.message = message;
		transformationStopRequested = false;
		path = paths.get(0);
		instance = instances.get(0).get(0);
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlPleaseSelectA = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.RESIZE);

		shlPleaseSelectA.setMinimumSize(new Point(300, 350));
		shlPleaseSelectA.setSize(900, 600);
		shlPleaseSelectA.setText("Please Select a Path - Instance Pair");
		gridLayout = new GridLayout(1, false);
		shlPleaseSelectA.setLayout(gridLayout);
		// gridLayout.

		dialogMessage = new Label(shlPleaseSelectA, SWT.WRAP);
		gd_dialogMessage = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1,
				1);
		gd_dialogMessage.widthHint = shlPleaseSelectA.getSize().x - 10;
		dialogMessage.setLayoutData(gd_dialogMessage);
		dialogMessage.setText(message);

		shlPleaseSelectA.addControlListener(new ControlAdapter() {
			@Override
			public void controlMoved(final ControlEvent e) {
				lastLocation = shlPleaseSelectA.getLocation();
			}

			@Override
			public void controlResized(final ControlEvent e) {
				gd_dialogMessage.widthHint = shlPleaseSelectA.getClientArea().width
						- 2 * gridLayout.marginWidth;
				shlPleaseSelectA.layout(true);
				lastSize = shlPleaseSelectA.getSize();
			}
		});

		final SashForm sashForm = new SashForm(shlPleaseSelectA, SWT.NONE);
		final GridData gd_sashForm = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1);
		gd_sashForm.minimumHeight = 200;
		gd_sashForm.minimumWidth = 200;
		sashForm.setLayoutData(gd_sashForm);

		final Group grpPossiblePaths = new Group(sashForm, SWT.NONE);
		grpPossiblePaths.setText("Possible Paths");
		grpPossiblePaths.setLayout(new FillLayout(SWT.HORIZONTAL));

		final ListViewer pathListViewer = new ListViewer(grpPossiblePaths,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		pathList = pathListViewer.getList();
		pathList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.keyCode == SWT.KeyDown) {
					pathList.select(pathList.getSelectionIndex() + 1);
				} else if (e.keyCode == SWT.KeyUp) {
					pathList.select(pathList.getSelectionIndex() - 1);
				}
			}
		});
		pathList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(final MouseEvent e) {
				shlPleaseSelectA.dispose();
			}
		});
		pathList.setItems(paths.toArray(new String[1]));

		pathListViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					/**
					 * Path selection changed
					 */
					@Override
					public void selectionChanged(
							final SelectionChangedEvent event) {
						path = paths.get(pathList.getSelectionIndex());
						instancesList.setItems(instances.get(
								pathList.getSelectionIndex()).toArray(
								new String[1]));
						instancesList.setSelection(0);
						instance = instances.get(pathList.getSelectionIndex())
								.get(instancesList.getSelectionIndex());
					}
				});

		final Group grpPossibleInstances = new Group(sashForm, SWT.NONE);
		grpPossibleInstances.setText("Possible Instances");
		grpPossibleInstances.setLayout(new FillLayout(SWT.HORIZONTAL));

		final ListViewer instancesListViewer = new ListViewer(
				grpPossibleInstances, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		instancesList = instancesListViewer.getList();
		instancesList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.keyCode == SWT.KeyDown) {
					instancesList.select(instancesList.getSelectionIndex() + 1);
				} else if (e.keyCode == SWT.KeyUp) {
					instancesList.select(instancesList.getSelectionIndex() - 1);
				}
			}
		});
		instancesList.addMouseListener(new MouseAdapter() {
			/**
			 * close Dialog on double clicked
			 */
			@Override
			public void mouseDoubleClick(final MouseEvent e) {
				shlPleaseSelectA.dispose();
			}
		});
		instancesList.setItems(instances.get(0).toArray(new String[1]));
		instancesList.setSelection(0);
		pathList.setSelection(0);
		sashForm.setWeights(new int[] { 347, 228 });

		final Composite composite = new Composite(shlPleaseSelectA, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		final GridLayout gl_composite = new GridLayout(2, false);
		gl_composite.horizontalSpacing = 0;
		gl_composite.verticalSpacing = 0;
		gl_composite.marginWidth = 0;
		gl_composite.marginHeight = 0;
		composite.setLayout(gl_composite);

		final Button abortTransButton = new Button(composite, SWT.NONE);
		final GridData gd_abortTransButton = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_abortTransButton.heightHint = 35;
		gd_abortTransButton.minimumWidth = 80;
		gd_abortTransButton.minimumHeight = 35;
		abortTransButton.setLayoutData(gd_abortTransButton);
		abortTransButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				path = paths.get(0);
				instance = instances.get(0).get(0);
				transformationStopRequested = true;
				shlPleaseSelectA.dispose();
			}
		});
		abortTransButton.setText("Abort Transformation");

		final Composite composite_1 = new Composite(composite, SWT.NONE);
		final RowLayout rl_composite_1 = new RowLayout(SWT.HORIZONTAL);
		composite_1.setLayout(rl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true,
				true, 1, 1));

		final Button okButton = new Button(composite_1, SWT.NONE);
		okButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				shlPleaseSelectA.dispose();
			}
		});
		okButton.setLayoutData(new RowData(80, 35));
		okButton.setText("OK");
		okButton.setSelection(true);

		final Button abortButton = new Button(composite_1, SWT.NONE);
		abortButton.setLayoutData(new RowData(80, 35));
		abortButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				path = paths.get(0);
				instance = instances.get(0).get(0);
				shlPleaseSelectA.dispose();
			}
		});
		abortButton.setText("Abort");

		instancesListViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					/**
					 * Instance selection changed
					 */
					@Override
					public void selectionChanged(
							final SelectionChangedEvent event) {
						instance = instances.get(pathList.getSelectionIndex())
								.get(instancesList.getSelectionIndex());
					}
				});

		if (lastSize != null) {
			shlPleaseSelectA.setSize(lastSize);
		}

		if (lastLocation != null) {
			shlPleaseSelectA.setLocation(lastLocation);
		}

		okButton.setFocus();
	}

	/**
	 * Get selected Instance after dialog has finished, return first instance in
	 * List for first path if dialog aborted / not run
	 * 
	 * @return selected instance
	 */
	public String getInstance() {

		return instance;

	}

	protected org.eclipse.swt.widgets.List getInstancesList() {
		return instancesList;
	}

	/**
	 * Get selected Path after dialog has finished, return first path in List if
	 * dialog aborted / not run
	 * 
	 * @return the path
	 */
	public String getPath() {

		return path;
	}

	protected org.eclipse.swt.widgets.List getPathList() {
		return pathList;
	}

	/**
	 * @return true if corresponding button in dialog was pressed
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
		shlPleaseSelectA.open();
		shlPleaseSelectA.layout();
		final Display display = getParent().getDisplay();
		while (!shlPleaseSelectA.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}
}
