package de.mfreund.gentrans.transformation.selectors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Sascha Steffen
 * @version 1.0 Dialog for selecting elements by the .toString() they return.
 *
 * @param <AnyType>
 *            will be returned by getSelection()
 */
public class GenericItemSelectorDialogRunner<AnyType> implements Runnable {
	private final List<AnyType> listItems;
	private final String message;

	private AnyType selection;

	private final int standardSelection;

	private boolean transformationStopRequested;

	/**
	 * @param message
	 * @param listItems
	 * @param standardSelection
	 */
	public GenericItemSelectorDialogRunner(final String message,
			final List<AnyType> listItems, final int standardSelection) {
		transformationStopRequested = false;
		selection = listItems.get(0);
		this.message = message;
		this.listItems = listItems;
		this.standardSelection = standardSelection;
	}

	/**
	 * @return selected <AnyType>
	 */
	public AnyType getSelection() {
		return selection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell(display);
		final ArrayList<String> newListItems = new ArrayList<String>(
				listItems.size());
		for (final AnyType i : listItems) {
			newListItems.add(i.toString());
		}
		final ItemSelectorDialog d = new ItemSelectorDialog(shell, message,
				newListItems, standardSelection);
		d.open();
		selection = listItems.get(d.getSelection());
		transformationStopRequested = d.isTransformationStopRequested();
	}

	/**
	 * @return true if Button "Abort Transformation" was clicked during run()
	 */
	public boolean wasTransformationStopRequested() {
		return transformationStopRequested;
	}

}
