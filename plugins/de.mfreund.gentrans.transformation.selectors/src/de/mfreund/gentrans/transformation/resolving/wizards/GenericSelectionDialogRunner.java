package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.swt.widgets.Dialog;

import de.mfreund.gentrans.transformation.handler.GenericTransformationJob;
import de.mfreund.gentrans.transformation.resolving.enhancing.MappingModelEnhancer;

/**
 * This represents a {@link Runnable} that will spawn an {@link GenericSelectionDialog} that allows a user to select
 * between multiple options during an execution of a {@link GenericTransformationJob generic transformation}.
 * <p />
 * Clients can overwrite the {@link #initializeDialog()} method if a sub-class of {@link GenericSelectionDialog} shall
 * be used as dialog.
 *
 * @author mfreund
 * @param <SelectionType>
 *            The type of the elements that will be returned by the dialog after the user's selection.
 */
public class GenericSelectionDialogRunner<SelectionType> extends AbstractDialogRunner {

	/**
	 * The index of the option that shall be default selected in the dialog or '<em>null</em>' if no option shall be
	 * default selected.
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
	 * This creates an instance.
	 *
	 * @param message
	 *            The message that shall be displayed in the {@link Dialog} that this runner will instantiate.
	 * @param standardSelection
	 *            The index of the option that shall be default selected in the dialog (pass '<em>-1</em/>' if no option
	 *            shall be default selected.
	 * @param multiSelectionAllowed
	 *            Whether multi-selection shall be allowed in the dialog.
	 * @param options
	 *            The options to be presented to the user in the dialog.
	 * @param enhanceMappingModelListener
	 *            A {@link MappingModelEnhancer} that will be called when the
	 *            {@link AbstractDialog#enhanceMappingModelButton} is clicked.
	 */
	public GenericSelectionDialogRunner(final String message, final int standardSelection,
			final boolean multiSelectionAllowed, final List<SelectionType> options,
			final MappingModelEnhancer<GenericSelectionDialogRunner<SelectionType>> enhanceMappingModelListener) {

		super(message, enhanceMappingModelListener);

		this.standardSelection = standardSelection;
		this.multiSelectionAllowed = multiSelectionAllowed;
		this.options = options;

		this.selection = Arrays.asList(options.get(standardSelection));
	}

	/**
	 * This is the getter for the {@link #options}.
	 *
	 * @return the {@link #options}.
	 */
	public List<SelectionType> getOptions() {

		return this.options;
	}

	/**
	 * Get the options that have been selected by the user after the dialog has finished.
	 *
	 * @return The {@link #selection}.
	 */
	public List<SelectionType> getSelection() {

		this.evaluateResults();
		return this.selection == null ? new ArrayList<>() : this.selection;
	}

	/**
	 * Get the single selected element after the dialog has finished.
	 * <p />
	 * Note: If multiple elements are selected by the user, this will return one (random!) element.
	 *
	 * @return The single element selected by the user.
	 */
	public SelectionType getSingleSelection() {

		this.evaluateResults();
		return this.selection == null || this.selection.isEmpty() ? null : this.selection.iterator().next();
	}

	/**
	 * Returns a String representation for the given '<em>option</em>' that will be displayed to the user in the dialog.
	 * <p />
	 * Note: The default implementation simply returns 'option.toString()'.
	 *
	 * @param option
	 *            The option for that the String representation shall be returned.
	 * @return The String representation for the given '<em>option</em>' that will be displayed to the user in the
	 *         dialog.
	 */
	protected String getStringRepresentation(SelectionType option) {

		return option.toString();
	}

	/**
	 * Returns a list of {@link #getStringRepresentation(Object) String representations} for the {@link #options}.
	 *
	 * @return A list of String representations for the list of {@link #options}.
	 */
	protected List<String> getStringRepresentations() {

		return this.options.stream().map(this::getStringRepresentation).collect(Collectors.toList());
	}

	@Override
	protected void initializeDialog() {

		this.dialog = new GenericSelectionDialog(this.message, this.getStringRepresentations(),
				this.multiSelectionAllowed, this.standardSelection, this.enhanceMappingModelListener);
	}

	@Override
	protected void evaluateResults() {

		this.selection = new ArrayList<>();
		if (this.multiSelectionAllowed) {
			((GenericSelectionDialog) this.dialog).getSelection().stream()
					.forEach(i -> this.selection.add(this.options.get(i)));
		} else {
			this.selection.add(this.options.get(((GenericSelectionDialog) this.dialog).getSingleSelection()));
		}
	}

}