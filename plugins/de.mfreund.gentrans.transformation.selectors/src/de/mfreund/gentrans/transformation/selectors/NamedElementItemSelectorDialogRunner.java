package de.mfreund.gentrans.transformation.selectors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import pamtram.NamedElement;

/**
 * @author Sascha Steffen 
 * @version 0.9
 * Dialog for selecting NamedElements by their name
 *
 * @param <type> will be returned by getSelection()
 */
public class NamedElementItemSelectorDialogRunner<type extends NamedElement> implements Runnable {
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
	public NamedElementItemSelectorDialogRunner(String message,
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
		for(NamedElement i : listItems){
			newListItems.add(i.getName());
		}
		ItemSelectorDialog d=new ItemSelectorDialog(shell,message, newListItems,standardSelection);
		d.open();
		selection=listItems.get(d.getSelection());		
		transformationStopRequested=d.isTransformationStopRequested();
	}

}
