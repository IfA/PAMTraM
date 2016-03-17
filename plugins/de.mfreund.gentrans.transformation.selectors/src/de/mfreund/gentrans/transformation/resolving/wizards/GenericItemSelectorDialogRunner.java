package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	private Set<AnyType> selection;

	private final int standardSelection;

	private boolean multiSelectionAllowed;

	private boolean transformationStopRequested;
	

	/**
	 * @param message
	 * @param listItems
	 * @param standardSelection
	 */
	public GenericItemSelectorDialogRunner(final String message,
			final List<AnyType> listItems, final int standardSelection) {
		transformationStopRequested = false;
		selection = new HashSet<>(Arrays.asList(listItems.get(0)));
		this.message = message;
		this.listItems = listItems;
		this.multiSelectionAllowed = false;
		this.standardSelection = standardSelection;
	}
	
	/**
	 * @param message
	 * @param listItems
	 * @param standardSelection
	 */
	public GenericItemSelectorDialogRunner(final String message,
			final List<AnyType> listItems, final boolean multiSelectionAllowed, final int standardSelection) {
		transformationStopRequested = false;
		selection = new HashSet<>(Arrays.asList(listItems.get(0)));
		this.message = message;
		this.listItems = listItems;
		this.multiSelectionAllowed = multiSelectionAllowed;
		this.standardSelection = standardSelection;
	}

	/**
	 * Get Selection after dialog has finished, returns standardSelection if
	 * dialog not run
	 * <p />
	 * Note: If multiple elements are selected by the user, this will return one (random!) element.
	 *
	 * @return selected <AnyType>
	 */
	public AnyType getSingleSelection() {
		return (selection == null || selection.isEmpty() ? null : selection.iterator().next());
	}
	
	/**
	 * Get Selection after dialog has finished, returns standardSelection if
	 * dialog not run
	 *
	 * @return the selection
	 */
	public Set<AnyType> getSelection() {

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
				newListItems, multiSelectionAllowed, standardSelection);
		d.open();
		if(!multiSelectionAllowed) {
			selection = new HashSet<>(Arrays.asList(listItems.get(d.getSingleSelection())));
		} else {
			selection = new HashSet<>();
			for (int index : d.getSelection()) {
				selection.add(listItems.get(index));
			}
		}
		transformationStopRequested = d.isTransformationStopRequested();
	}

	/**
	 * @return true if Button "Abort Transformation" was clicked during run()
	 */
	public boolean wasTransformationStopRequested() {
		return transformationStopRequested;
	}

}
