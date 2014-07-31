package de.mfreund.gentrans.transformation.selectors;


import java.util.Collection;


import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;

public class ItemSelectorDialog extends Dialog{

	protected Object result;
	protected String selectedItem;
	protected Shell shlPleaseSelectA;
	private Collection<String> listItems;
	private String message;
	private GridData gd_dialogMessage;
	private Label dialogMessage;
	private GridLayout gridLayout;
	private org.eclipse.swt.widgets.List listWidget;
	private int standardSelectionIndex;
	private boolean transformationStopRequested;
	private static Point lastSize;
	private static Point lastLocation;
	
	public boolean isTransformationStopRequested() {
		return transformationStopRequested;
	}

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	ItemSelectorDialog(Shell parent, String message, Collection<String> listItems, String standardSelection) {
		super(parent, SWT.CLOSE | SWT.MODELESS| SWT.BORDER | SWT.TITLE);
		setText("SWT Dialog");
		this.listItems=listItems;
		this.message=message;
		this.transformationStopRequested=false;
		//we need to check if the value standardSelection is part of the selections list 
		selectedItem=listItems.iterator().next();
		standardSelectionIndex=0;
		int ctr=0;
		for(String item : listItems){
			if(item.equals(standardSelection)){
				selectedItem=standardSelection;
				this.standardSelectionIndex=ctr;
				break;
			}
			ctr++;
		}
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
	 * Get Selection after dialog has finished, returns standardSelection if dialog not run
	 * @return the selection
	 */
	public String getSelection(){
		
		return selectedItem;
	}
	


	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlPleaseSelectA = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.RESIZE);


		shlPleaseSelectA.setMinimumSize(new Point(300, 350));
		shlPleaseSelectA.setSize(900, 600);
		shlPleaseSelectA.setText("Please select..");
		gridLayout=new GridLayout(1, false);
		gridLayout.marginHeight = 0;
		shlPleaseSelectA.setLayout(gridLayout);
		
		dialogMessage = new Label(shlPleaseSelectA, SWT.WRAP);
		gd_dialogMessage = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dialogMessage.widthHint = shlPleaseSelectA.getSize().x-10;
		dialogMessage.setLayoutData(gd_dialogMessage);
		dialogMessage.setText(message);
		shlPleaseSelectA.redraw();
		
		shlPleaseSelectA.addControlListener(new ControlAdapter(){
			public void controlResized(ControlEvent e){
				gd_dialogMessage.widthHint = shlPleaseSelectA.getClientArea().width -2*gridLayout.marginWidth;
				shlPleaseSelectA.layout(true);
				listWidget.showSelection();
				lastSize=shlPleaseSelectA.getSize();
			}
			@Override
			public void controlMoved(ControlEvent e) {
				lastLocation=shlPleaseSelectA.getLocation();
			}
		});
		

		
		Group grpPossiblePaths = new Group(shlPleaseSelectA, SWT.NONE);
		GridData gd_possiblePaths = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);	
		gd_possiblePaths.minimumHeight = 200;
		gd_possiblePaths.minimumWidth = 200;
		grpPossiblePaths.setText("Possible choices");
		grpPossiblePaths.setLayout(new FillLayout(SWT.HORIZONTAL));
		grpPossiblePaths.setLayoutData(gd_possiblePaths);
		
		ListViewer listViewer = new ListViewer(grpPossiblePaths, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				selectedItem=listWidget.getSelection()[0];
				listWidget.showSelection();
			}
		});
		listViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				shlPleaseSelectA.dispose();
			}
		});
		listWidget = listViewer.getList();
		listWidget.setItems(this.listItems.toArray(new String[1]));
		listWidget.setSelection(standardSelectionIndex);
		listWidget.showSelection();

		
		composite = new Composite(shlPleaseSelectA, SWT.NONE);
		GridLayout gl_composite = new GridLayout(2, true);
		gl_composite.verticalSpacing = 0;
		gl_composite.marginWidth = 0;
		gl_composite.marginHeight = 0;
		composite.setLayout(gl_composite);
		GridData gd_composite = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_composite.widthHint = 564;
		composite.setLayoutData(gd_composite);
		
		abortTransFormationButton = new Button(composite, SWT.NONE);
		abortTransFormationButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectedItem=listWidget.getItem(standardSelectionIndex);
				transformationStopRequested=true;
				shlPleaseSelectA.dispose();
			}
		});
		GridData gd_abortTransFormationButton = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		gd_abortTransFormationButton.minimumWidth = 80;
		gd_abortTransFormationButton.minimumHeight = 35;
		abortTransFormationButton.setLayoutData(gd_abortTransFormationButton);
		abortTransFormationButton.setAlignment(SWT.LEFT);
		abortTransFormationButton.setText("Abort transformation");
		
		composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		RowLayout rl_composite_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_1.marginBottom = 0;
		rl_composite_1.marginLeft = 0;
		rl_composite_1.marginRight = 0;
		rl_composite_1.marginTop = 0;
		rl_composite_1.spacing = 0;
		rl_composite_1.fill = true;
		composite_1.setLayout(rl_composite_1);
		
		button = new Button(composite_1, SWT.NONE);
		button.setLayoutData(new RowData(80, 35));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlPleaseSelectA.dispose();
			}
		});
		button.setText("OK");
		button.setSelection(true);
		
		btnAbort = new Button(composite_1, SWT.NONE);
		btnAbort.setLayoutData(new RowData(80, 35));
		btnAbort.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectedItem=listWidget.getItem(standardSelectionIndex);
				shlPleaseSelectA.dispose();
			}
		});
		btnAbort.setText("Abort");

		if(lastSize != null){
			shlPleaseSelectA.setSize(lastSize);
		} 
		
		if(lastLocation != null){
			shlPleaseSelectA.setLocation(lastLocation);
		}
	}
	
	private Composite composite;
	private Button button;
	private Button btnAbort;
	private Button abortTransFormationButton;
	private Composite composite_1;

}
