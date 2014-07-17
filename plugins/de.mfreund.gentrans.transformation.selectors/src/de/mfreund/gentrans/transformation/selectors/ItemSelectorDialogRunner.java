package de.mfreund.gentrans.transformation.selectors;

import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ItemSelectorDialogRunner implements Runnable {
	private String selection;
	public String getSelection() {
		return selection;
	}

	public boolean wasTransformationStopRequested() {
		return transformationStopRequested;
	}

	private boolean transformationStopRequested;
	
	private String message,standardSelection;
	private Collection<String> listItems;
	public ItemSelectorDialogRunner(String message,
									Collection<String> listItems,
									String standardSelection) {
		transformationStopRequested=false;
		selection="";
		this.message=message;
		this.listItems=listItems;
		this.standardSelection=standardSelection;
	}

	@Override
	public void run() {
		Display display= Display.getDefault();
		Shell shell=new Shell(display);
		ItemSelectorDialog d=new ItemSelectorDialog(shell, SWT.APPLICATION_MODAL,message, listItems,standardSelection);

		d.open();
		selection=d.getSelection();		
		transformationStopRequested=d.isTransformationStopRequested();
	}

}
