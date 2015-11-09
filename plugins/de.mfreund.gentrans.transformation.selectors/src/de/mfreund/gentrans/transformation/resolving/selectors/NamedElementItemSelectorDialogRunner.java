package de.mfreund.gentrans.transformation.resolving.selectors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import pamtram.NamedElement;

/**
 * @author Sascha Steffen
 * @version 1.0
 *
 *          Dialog for selecting NamedElements by their name.
 *
 * @param <NamedElementSubClass>
 *            will be returned by getSelection()
 */
public class NamedElementItemSelectorDialogRunner<NamedElementSubClass extends NamedElement>
		implements Runnable {
	private final List<NamedElementSubClass> listItems;
	private final String message;

	private NamedElementSubClass selection;

	private final int standardSelection;

	private boolean transformationStopRequested;

	/**
	 * @param message
	 * @param listItems
	 * @param standardSelection
	 */
	public NamedElementItemSelectorDialogRunner(final String message,
			final List<NamedElementSubClass> listItems,
			final int standardSelection) {
		transformationStopRequested = false;
		selection = listItems.get(0);
		this.message = message;
		this.listItems = listItems;
		this.standardSelection = standardSelection;
	}

	/**
	 * @return selected <NamedElementSubClass>
	 */
	public NamedElementSubClass getSelection() {
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
		for (final NamedElement i : listItems) {
			newListItems.add(i.getName());
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
