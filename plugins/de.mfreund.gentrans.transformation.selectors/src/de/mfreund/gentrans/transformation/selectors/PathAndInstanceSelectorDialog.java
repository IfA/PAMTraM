package de.mfreund.gentrans.transformation.selectors;


import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;

public class PathAndInstanceSelectorDialog extends Dialog {

	protected Object result;
	protected String path, instance;
	protected Shell shlPleaseSelectA;
	private List<String> paths;
	private List<List<String>>  instances;
	private org.eclipse.swt.widgets.List pathList;
	private org.eclipse.swt.widgets.List instancesList;
	private String message;
	private GridData gd_dialogMessage;
	private Label dialogMessage;
	private GridLayout gridLayout;
	private static Point lastSize;
	private static Point lastLocation;
	
	private boolean transformationStopRequested;
	
	public boolean isTransformationStopRequested() {
		return transformationStopRequested;
	}
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public PathAndInstanceSelectorDialog(Shell parent, String message, List<String> paths, List<List<String>>  instances) {
		super(parent,SWT.CLOSE | SWT.MODELESS| SWT.BORDER | SWT.TITLE);
		setText("SWT Dialog");
		this.paths=paths;
		this.instances=instances;
		this.message=message;
		this.transformationStopRequested=false;
		path=paths.get(0);
		instance=instances.get(0).get(0);
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlPleaseSelectA.open();
		shlPleaseSelectA.layout();
		Display display = getParent().getDisplay();
		while (!shlPleaseSelectA.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}
	
	/**
	 * Get selected Path after dialog has finished, return first path in List
	 *  if dialog aborted / not run
	 * @return the path
	 */
	public String getPath(){
		
		return path;
	}
	
	/**
	 * Get selected Instance after dialog has finished, return first instance in List
	 * for first path
	 *  if dialog aborted / not run
	 * @return selected instance
	 */
	public String getInstance(){
		
		return instance;
		
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlPleaseSelectA = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.RESIZE);


		shlPleaseSelectA.setMinimumSize(new Point(300, 350));
		shlPleaseSelectA.setSize(900, 600);
		shlPleaseSelectA.setText("Please Select a Path - Instance Pair");
		gridLayout=new GridLayout(1, false);
		shlPleaseSelectA.setLayout(gridLayout);
		//gridLayout.
		
		dialogMessage = new Label(shlPleaseSelectA, SWT.WRAP);
		gd_dialogMessage = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dialogMessage.widthHint = shlPleaseSelectA.getSize().x-10;
		dialogMessage.setLayoutData(gd_dialogMessage);
		dialogMessage.setText(message);
		
		shlPleaseSelectA.addControlListener(new ControlAdapter(){
			public void controlResized(ControlEvent e){
				gd_dialogMessage.widthHint = shlPleaseSelectA.getClientArea().width -2*gridLayout.marginWidth;
				shlPleaseSelectA.layout(true);
				lastSize=shlPleaseSelectA.getSize();
			}
			@Override
			public void controlMoved(ControlEvent e) {
				lastLocation=shlPleaseSelectA.getLocation();
			}
		});
		
		SashForm sashForm = new SashForm(shlPleaseSelectA, SWT.NONE);
		GridData gd_sashForm = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_sashForm.minimumHeight = 200;
		gd_sashForm.minimumWidth = 200;
		sashForm.setLayoutData(gd_sashForm);
		
		Group grpPossiblePaths = new Group(sashForm, SWT.NONE);
		grpPossiblePaths.setText("Possible Paths");
		grpPossiblePaths.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ListViewer listViewer = new ListViewer(grpPossiblePaths, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		pathList = listViewer.getList();
		pathList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shlPleaseSelectA.dispose();
			}
		});
		pathList.setItems(paths.toArray(new String[1]));
		
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			/**
			 * Path selection changed
			 */
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				path=paths.get(pathList.getSelectionIndex());
				instancesList.setItems(instances.get(pathList.getSelectionIndex()).toArray(new String[1]));
				instancesList.setSelection(0);
				instance=instances.get(pathList.getSelectionIndex()).get(instancesList.getSelectionIndex());	
			}
		});
		
		Group grpPossibleInstances = new Group(sashForm, SWT.NONE);
		grpPossibleInstances.setText("Possible Instances");
		grpPossibleInstances.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ListViewer listViewer_1 = new ListViewer(grpPossibleInstances, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		instancesList = listViewer_1.getList();
		instancesList.addMouseListener(new MouseAdapter() {
			/**
			 * close Dialog on double clicked
			 */
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shlPleaseSelectA.dispose();
			}
		});
		instancesList.setItems(instances.get(0).toArray(new String[1]));
		instancesList.setSelection(0);
		sashForm.setWeights(new int[] {347, 228});
		
		Composite composite = new Composite(shlPleaseSelectA, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		GridLayout gl_composite = new GridLayout(2, false);
		gl_composite.horizontalSpacing = 0;
		gl_composite.verticalSpacing = 0;
		gl_composite.marginWidth = 0;
		gl_composite.marginHeight = 0;
		composite.setLayout(gl_composite);
		
		Button abortTransButton = new Button(composite, SWT.NONE);
		GridData gd_abortTransButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_abortTransButton.heightHint = 35;
		gd_abortTransButton.minimumWidth = 80;
		gd_abortTransButton.minimumHeight = 35;
		abortTransButton.setLayoutData(gd_abortTransButton);
		abortTransButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				path=paths.get(0);
				instance=instances.get(0).get(0);	
				transformationStopRequested=true;
				shlPleaseSelectA.dispose();
			}
		});
		abortTransButton.setText("Abort Transformation");
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		RowLayout rl_composite_1 = new RowLayout(SWT.HORIZONTAL);
		composite_1.setLayout(rl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true, 1, 1));
		
		Button okButton = new Button(composite_1, SWT.NONE);
		okButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					shlPleaseSelectA.dispose();
				}
		});		
		okButton.setLayoutData(new RowData(80, 35));
		okButton.setText("OK");
		okButton.setSelection(true);
		
		Button abortButton = new Button(composite_1, SWT.NONE);
		abortButton.setLayoutData(new RowData(80, 35));
		abortButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				path=paths.get(0);
				instance=instances.get(0).get(0);				
				shlPleaseSelectA.dispose();
			}
		});
		abortButton.setText("Abort");
		
		listViewer_1.addSelectionChangedListener(new ISelectionChangedListener() {
			/**
			 * Instance selection changed
			 */
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				instance=instances.get(pathList.getSelectionIndex()).get(instancesList.getSelectionIndex());				
			}
		});
		
		if(lastSize != null){
			shlPleaseSelectA.setSize(lastSize);
		} 
		
		if(lastLocation != null){
			shlPleaseSelectA.setLocation(lastLocation);
		}		

		okButton.setFocus();
	}
	protected org.eclipse.swt.widgets.List getPathList() {
		return pathList;
	}
	protected org.eclipse.swt.widgets.List getInstancesList() {
		return instancesList;
	}
}
