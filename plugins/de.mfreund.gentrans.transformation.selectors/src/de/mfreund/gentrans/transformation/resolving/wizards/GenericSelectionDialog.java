package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
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
	 * The options that are be presented to the user.
	 */
	protected final List<T> options;

	/**
	 * The options that have been selected by the user (a subset of the {@link #options}).
	 */
	protected List<T> selectedItems;

	/**
	 * Whether multi-selection shall be allowed in the dialog.
	 */
	protected boolean multiSelectionAllowed;

	/**
	 * Create the dialog.
	 * 
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param options
	 *            The list of options from which the user may select.
	 * @param multiSelectionAllowed
	 *            Whether multi-selection shall be allowed in the dialog.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 */
	public GenericSelectionDialog(String message, List<T> options, boolean multiSelectionAllowed,
			Optional<SelectionListener2> enhanceMappingModelListener) {

		super(message, enhanceMappingModelListener);

		this.options = options;

		this.selectedItems = new ArrayList<>();
		this.multiSelectionAllowed = multiSelectionAllowed;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void createInnerContents(Composite container) {

		// Create the list viewer for the list of options
		//
		ListViewer listViewer = this.createListViewer(container, Optional.of("Possible choices"),
				this.multiSelectionAllowed);

		listViewer.addSelectionChangedListener(
				event -> this.selectedItems = listViewer.getStructuredSelection().toList());

		listViewer.addDoubleClickListener(event -> {
			this.setReturnCode(IDialogConstants.OK_ID);
			this.close();
		});

		listViewer.setInput(this.options);
	}

	/**
	 * Creates a {@link ListViewer} that can be used to display options to the user.
	 *
	 * @param container
	 *            The {@link Composite} in which the viewer shall be displayed.
	 * @param groupText
	 *            If this optional String is present, the created {@link ListViewer} will be wrapped in a {@link Group}
	 *            with the given text.
	 * @param multiSelectionAllowed
	 *            Whether the user shall be able to select more than one of the options.
	 * @return The created {@link ListViewer} (potentially wrapped in a {@link Group}).
	 */
	protected ListViewer createListViewer(Composite container, Optional<String> groupText,
			boolean multiSelectionAllowed) {

		Composite parent = container;

		if (groupText.isPresent()) {

			Group group = new Group(container, SWT.NONE);
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).minSize(200, 200).applyTo(group);
			group.setText(groupText.get());
			group.setLayout(new FillLayout(SWT.HORIZONTAL));

			parent = group;
		}

		ListViewer listViewer = new ListViewer(parent,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | (multiSelectionAllowed ? SWT.MULTI : 0)) {

			@SuppressWarnings("unchecked")
			@Override
			protected void inputChanged(Object input, Object oldInput) {

				super.inputChanged(input, oldInput);

				// Automatically select the first element when the input changes
				//
				if (input instanceof Collection<?>) {
					this.setSelection(new StructuredSelection(((Collection<Object>) input).iterator().next()));
				}
			}
		};

		listViewer.getList().addKeyListener((KeyPressedListener) e -> {
			if (e.keyCode == SWT.KeyDown || e.keyCode == SWT.KeyUp) {
				listViewer.setSelection(new StructuredSelection(listViewer
						.getElementAt(listViewer.getList().getSelectionIndex() + (e.keyCode == SWT.KeyDown ? 1 : -1))));
			}
		});
		listViewer.setContentProvider(new ArrayContentProvider());
		listViewer.setLabelProvider(new UserDecisionStrategyLabelProvider());

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

		return this.options;
	}
}
