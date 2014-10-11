package de.mfreund.gentrans.transformation.selectors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Sascha Steffen 
 * @version 0.9
 * Dialog for selecting elements by the .toString() they return
 *
 * @param <type> will be returned by getSelection()
 */
public class GenericItemSelectorDialogRunner<type> implements Runnable {
	private type selection;
	public type getSelection() {
		return selection;
	}

	public boolean wasTransformationStopRequested() {
		return transformationStopRequested;
	}

	private boolean transformationStopRequested;
	
	private String message;
	private int standardSelection;
	private List<type> listItems;
	public GenericItemSelectorDialogRunner(String message,
									List<type> listItems,
									int standardSelection) {
		transformationStopRequested=false;
		selection=listItems.get(0);
		this.message=message;
		this.listItems=listItems;
		this.standardSelection=standardSelection;
	}

	@Override
	public void run() {
		Display display= Display.getDefault();
		Shell shell=new Shell(display);
		ArrayList<String> newListItems=new ArrayList<String>(listItems.size());
		for(type i : listItems){
			newListItems.add(i.toString());
		}
		ItemSelectorDialog d=new ItemSelectorDialog(shell,message, newListItems,standardSelection);
		d.open();
		selection=listItems.get(d.getSelection());		
		transformationStopRequested=d.isTransformationStopRequested();
	}

}
