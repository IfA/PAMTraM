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

public class ItemSelectorDialog extends Dialog {

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
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	private ItemSelectorDialog(Shell parent, int style, String message, Collection<String> listItems, String standardSelection) {
		super(parent, SWT.DIALOG_TRIM | SWT.RESIZE | SWT.APPLICATION_MODAL);
		setText("SWT Dialog");
		this.listItems=listItems;
		this.message=message;
		
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
	private Object open() {
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
	private String getSelection(){
		
		return selectedItem;
	}
	


	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlPleaseSelectA = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.MIN | SWT.RESIZE | SWT.APPLICATION_MODAL);


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
		
		shlPleaseSelectA.addControlListener(new ControlAdapter(){
			public void controlResized(ControlEvent e){
				gd_dialogMessage.widthHint = shlPleaseSelectA.getClientArea().width -2*gridLayout.marginWidth;
				shlPleaseSelectA.layout(true);
				listWidget.showSelection();
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
		RowLayout rl_composite = new RowLayout(SWT.HORIZONTAL);
		rl_composite.marginTop = 0;
		rl_composite.fill = true;
		composite.setLayout(rl_composite);
		composite.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		
		button = new Button(composite, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlPleaseSelectA.dispose();
			}
		});
		button.setLayoutData(new RowData(75, 30));
		button.setText("OK");
		button.setSelection(true);
		
		btnAbort = new Button(composite, SWT.NONE);
		btnAbort.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectedItem=listWidget.getItem(standardSelectionIndex);
				shlPleaseSelectA.dispose();
			}
		});
		btnAbort.setLayoutData(new RowData(75, 30));
		btnAbort.setText("Abort");

	}
	
	private static String selection;	
	private Composite composite;
	private Button button;
	private Button btnAbort;
	public static String run(final String message, final Collection<String> listItems, final String standardItem){
		Display.getDefault().syncExec(new Runnable(){
			public void run(){
				Display display= Display.getDefault();
				Shell shell=new Shell(display);
				ItemSelectorDialog d=new ItemSelectorDialog(shell, SWT.APPLICATION_MODAL,message, listItems,standardItem);

				d.open();
				selection=d.getSelection();
			};
		});
		
		return selection;
	};	
}
