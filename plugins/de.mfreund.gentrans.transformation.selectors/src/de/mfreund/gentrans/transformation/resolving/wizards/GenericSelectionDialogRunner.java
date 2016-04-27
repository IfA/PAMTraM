package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Shell;

import de.mfreund.gentrans.transformation.handler.GenericTransformationJob;

/**
 * This represents a {@link Runnable} that will spawn an {@link ItemSelectorDialog} that allows a 
 * user to select between multiple options during an execution of a {@link GenericTransformationJob generic transformation}.
 * <p />
 * Clients can overwrite the {@link #initializeDialog()} method if a sub-class of {@link ItemSelectorDialog} shall be used
 * as dialog.
 * 
 * @author mfreund
 * @param <SelectionType> The type of the elements that will be returned by the dialog after the user's selection.
 */
public class GenericSelectionDialogRunner<SelectionType> extends AbstractDialogRunner {

	/**
	 * The index of the option that shall be default selected in the dialog or '<em>null</em>' if no option shall
	 * be default selected.
	 */
	protected final int standardSelection;
	
	/**
	 * Whether multi-selection shall be allowed in the dialog.
	 */
	protected final boolean multiSelectionAllowed;
	
	/**
	 * The options to be presented to the user in the dialog.
	 */
	protected final List<SelectionType> options;
	
	/**
	 * The options that have been selected by the user (this will be a subset of {@link #options}).
	 */
	protected List<SelectionType> selection;
	
	/**
	 * The {@link ItemSelectorDialog} that will present the options to the user.
	 */
	protected ItemSelectorDialog dialog;
	
	/**
	 * This creates an instance.
	 * 
	 * @param message The message that shall be displayed in the {@link Dialog} that this runner will instantiate.
	 * @param standardSelection The index of the option that shall be default selected in the dialog or '<em>null</em>' if no option shall
	 * be default selected.
	 * @param multiSelectionAllowed Whether multi-selection shall be allowed in the dialog.
	 * @param options The options to be presented to the user in the dialog.
	 */
	public GenericSelectionDialogRunner(final String message, final int standardSelection, 
			final boolean multiSelectionAllowed, final List<SelectionType> options) {
		
		super(message);
		
		this.standardSelection = standardSelection;
		this.multiSelectionAllowed = multiSelectionAllowed;
		this.options = options;
		
		this.selection = Arrays.asList(options.get(standardSelection));
	}
	
	@Override
	public void run() {

		// Create the dialog
		//
		if(dialog == null) {
			initializeDialog();
		}

		// Open the dialog
		//
		dialog.open();

		// Evaluate the result
		//
		selection = new ArrayList<>();
		if(multiSelectionAllowed) {
			for (Integer index : dialog.getSelection()) {
				selection.add(options.get(index));
			}
		} else {
			selection.add(options.get(dialog.getSingleSelection()));
		}
		transformationStopRequested = dialog.isTransformationStopRequested();
	}

	/**
	 * Get the options that have been selected by the user after the dialog has finished.
	 *
	 * @return The {@link #selection}.
	 */
	public List<SelectionType> getSelection() {
		return (selection == null ? new ArrayList<SelectionType>() : selection);
	}
	
	/**
	 * Get the single selected element after the dialog has finished.
	 * <p />
	 * Note: If multiple elements are selected by the user, this will return one (random!) element.
	 *
	 * @return selected <AnyType>
	 */
	public SelectionType getSingleSelection() {
		return (selection == null || selection.isEmpty() ? null : selection.iterator().next());
	}
	
	/**
	 * Returns a String representation for the given '<em>option</em>' that will be displayed to the user
	 * in the dialog. 
	 * <p />
	 * Note: The default implementation simply returns 'option.toString()'.
	 * 
	 * @param option The option for that the String representation shall be returned.
	 * @return The String representation for the given '<em>option</em>' that will be displayed to the user
	 * in the dialog. 
	 */
	protected String getStringRepresentation(SelectionType option) {
		return option.toString();
	}
	
	/**
	 * Returns a list of {@link #getStringRepresentation(Object) String representations} for the {@link #options}.
	 * 
	 * @return A list of String representations for the list of {@link #options}. 
	 */
	protected ArrayList<String> getStringRepresentations() {
		
		final ArrayList<String> optionsAsString = new ArrayList<String>(options.size());
		
		for (SelectionType option : options) {
			optionsAsString.add(getStringRepresentation(option));
		}
		
		return optionsAsString;
	}
	
	/**
	 * Creates and initializes the {@link #dialog} that will be presented to the user.
	 */
	protected void initializeDialog() {
		
		dialog = new ItemSelectorDialog(new Shell(), message,
				getStringRepresentations(), multiSelectionAllowed, standardSelection);
	}

}