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
		shlPleaseSelectA = new Shell(getParent(), SWT.CLOSE | SWT.MODELESS| SWT.BORDER | SWT.TITLE);


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
		
		listViewer_1.addSelectionChangedListener(new ISelectionChangedListener() {
			/**
			 * Instance selection changed
			 */
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				instance=instances.get(pathList.getSelectionIndex()).get(instancesList.getSelectionIndex());				
			}
		});
		
		Button btnNewButton = new Button(shlPleaseSelectA, SWT.NONE);
		btnNewButton.setSelection(true);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlPleaseSelectA.dispose();
			}
		});
		GridData gd_btnNewButton = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.heightHint = 30;
		gd_btnNewButton.widthHint = 75;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setText("OK");

	}
	protected org.eclipse.swt.widgets.List getPathList() {
		return pathList;
	}
	protected org.eclipse.swt.widgets.List getInstancesList() {
		return instancesList;
	}
	
}
