package de.mfreund.gentrans.transformation.selectors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Sascha Steffen 
 * @version 1.0
 * Dialog for selecting elements by the .toString() they return.
 *
 * @param <AnyType> will be returned by getSelection()
 */
public class GenericItemSelectorDialogRunner<AnyType> implements Runnable {
	private List<AnyType> listItems;
	private String message;

	private AnyType selection;

	private int standardSelection;
	
	private boolean transformationStopRequested;
	/**
	 * @param message
	 * @param listItems
	 * @param standardSelection
	 */
	public GenericItemSelectorDialogRunner(String message,
									List<AnyType> listItems,
									int standardSelection) {
		transformationStopRequested=false;
		selection=listItems.get(0);
		this.message=message;
		this.listItems=listItems;
		this.standardSelection=standardSelection;
	}
	/**
	 * @return selected <AnyType>
	 */
	public AnyType getSelection() {
		return selection;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Display display= Display.getDefault();
		Shell shell=new Shell(display);
		ArrayList<String> newListItems=new ArrayList<String>(listItems.size());
		for(AnyType i : listItems){
			newListItems.add(i.toString());
		}
		ItemSelectorDialog d=new ItemSelectorDialog(shell,message, newListItems,standardSelection);
		d.open();
		selection=listItems.get(d.getSelection());		
		transformationStopRequested=d.isTransformationStopRequested();
	}

	/**
	 * @return true if Button "Abort Transformation" was clicked during run()
	 */
	public boolean wasTransformationStopRequested() {
		return transformationStopRequested;
	}

}
