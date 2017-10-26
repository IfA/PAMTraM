package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import de.tud.et.ifa.agtele.ui.listeners.KeyPressedListener;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;

/**
 * An {@link TitleAreaDialog} that allows a user to select one or multiple elements from a list of options.
 *
 * @author mfreund
 * @param <T>
 *            The type of the elements that will be returned by the dialog after the user's selection.
 */
public class GenericSelectionDialog<T> extends AbstractDialog {

	/**
	 * A map describing the options that will be presented to the user. The key thereby represents a String
	 * representation of the option, whereas the value represents the actual option.
	 */
	protected final Map<String, T> options;

	/**
	 * The options that have been selected by the user (a subset of the options passed in the
	 * {@link #GenericSelectionDialog(String, String, List, boolean, int, SelectionListener2) constructor}.
	 */
	protected List<T> selectedItems;

	/**
	 * Whether multi-selection shall be allowed in the dialog.
	 */
	protected boolean multiSelectionAllowed;

	/**
	 * The options that have been selected by the user (this will be a subset of {@link #options}).
	 */
	protected final int standardSelectionIndex;

	/**
	 * Create the dialog without allowing for multi-selection.
	 * <p />
	 * Note: This is equal to calling '<em>GenericSelectionDialog(message, options, <b>false</b>,
	 * standardSelectionIndex)</em>'.
	 *
	 * @param title
	 *            The title for the dialog.
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param options
	 *            The list of options from which the user may select.
	 * @param standardSelectionIndex
	 *            The index of the option that shall be default selected in the dialog (pass '<em>-1</em/>' if no option
	 *            shall be default selected.
	 * @param enhanceMappingModelListener
	 *            A {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em> is
	 *            clicked.
	 */
	public GenericSelectionDialog(String title, String message, final List<T> options, final int standardSelectionIndex,
			final SelectionListener2 enhanceMappingModelListener) {

		this(title, message, options, false, standardSelectionIndex, enhanceMappingModelListener);

	}

	/**
	 * Create the dialog.
	 *
	 * @param title
	 *            The title for the dialog.
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param options
	 *            The list of options from which the user may select.
	 * @param multiSelectionAllowed
	 *            Whether multi-selection shall be allowed in the dialog.
	 * @param standardSelectionIndex
	 *            The index of the option that shall be default selected in the dialog (pass '<em>-1</em/>' if no option
	 *            shall be default selected.
	 * @param enhanceMappingModelListener
	 *            A {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em> is
	 *            clicked.
	 */
	public GenericSelectionDialog(String title, String message, final List<T> options, boolean multiSelectionAllowed,
			final int standardSelectionIndex, final SelectionListener2 enhanceMappingModelListener) {

		super(title, message, enhanceMappingModelListener);

		this.options = options.stream().collect(LinkedHashMap::new,
				(map, option) -> map.put(this.getStringRepresentation(option), option),
				(map1, map2) -> map1.putAll(map2));

		this.standardSelectionIndex = standardSelectionIndex;
		this.selectedItems = new ArrayList<>();
		if (standardSelectionIndex >= 0) {
			this.selectedItems.add(options.get(0));
		}
		this.multiSelectionAllowed = multiSelectionAllowed;
	}

	@Override
	protected void createInnerContents(Composite container) {

		// Create the group that will display the list of options to the user
		//
		Group grpOptions = new Group(container, SWT.NONE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).minSize(200, 200).applyTo(grpOptions);
		grpOptions.setText("Possible choices");
		grpOptions.setLayout(new FillLayout(SWT.HORIZONTAL));

		// Create the list viewer for the list of options
		//
		ListViewer listViewer = this.createListViewer(grpOptions, this.multiSelectionAllowed,
				new ArrayList<>(this.options.keySet()), this.standardSelectionIndex);

		listViewer.addSelectionChangedListener(
				event -> this.selectedItems = Arrays.asList(listViewer.getList().getSelection()).stream()
						.map(this.options::get).collect(Collectors.toList()));

		listViewer.addDoubleClickListener(event -> {
			this.setReturnCode(IDialogConstants.OPEN_ID);
			GenericSelectionDialog.this.close();
		});
	}

	/**
	 * Creates a {@link org.eclipse.swt.widgets.List} to display options to the user and allow for selection.
	 *
	 * ${tags}
	 *
	 * @return
	 */
	protected ListViewer createListViewer(Composite container, boolean multiSelectionAllowed,
			Collection<String> options, int standardSelectionIndex) {

		ListViewer listViewer = new ListViewer(container,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | (multiSelectionAllowed ? SWT.MULTI : 0));
		org.eclipse.swt.widgets.List listWidget = listViewer.getList();

		listWidget.addKeyListener((KeyPressedListener) e -> {
			if (e.keyCode == SWT.KeyDown) {
				listWidget.select(listWidget.getSelectionIndex() + 1);
			} else if (e.keyCode == SWT.KeyUp) {
				listWidget.select(listWidget.getSelectionIndex() - 1);
			}
		});
		// TODO set the input for the list viewer an use a content/label provider
		listWidget.setItems(options.toArray(new String[] {}));
		listWidget.setSelection(standardSelectionIndex);
		listWidget.showSelection();

		return listViewer;
	}

	/**
	 * Get Selection after dialog has finished, returns standardSelection if dialog not run
	 * <p />
	 * Note: If multiple elements are selected by the user, this will return one (random!) element.
	 *
	 * @return the selection
	 */
	public T getSingleSelection() {

		return this.selectedItems == null || this.selectedItems.isEmpty() ? null : this.selectedItems.iterator().next();
	}

	/**
	 * Get Selection after dialog has finished.
	 *
	 * @return the selection
	 */
	public List<T> getSelection() {

		return this.selectedItems;
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
	protected String getStringRepresentation(T option) {

		return option.toString();
	}

	/**
	 * This is the getter for the {@link #options}.
	 *
	 * @return the {@link #options}.
	 */
	public List<T> getOptions() {

		return new ArrayList<>(this.options.values());
	}
}
