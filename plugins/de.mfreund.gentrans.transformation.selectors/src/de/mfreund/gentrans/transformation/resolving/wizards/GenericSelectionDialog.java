package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

/**
 * A {@link Dialog} that allows a user to select one or multiple elements from a list of options.
 * 
 * @author mfreund
 */
public class GenericSelectionDialog extends AbstractDialog {

	/**
	 * The list of options that will be presented to the user.
	 */
	protected final List<String> options;
	
	/**
	 * The {@link org.eclipse.swt.widgets.List} that will present the {@link #options} to the user.
	 */
	protected org.eclipse.swt.widgets.List listWidget;

	/**
	 * The set of indexes representing those of the {@link #options} that have been selected by the user.
	 */
	protected Set<Integer> selectedItems;
	
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
	 * Note: This is equal to calling '<em>GenericSelectionDialog(message, options, <b>false</b>, standardSelectionIndex)</em>'.
	 *
	 * @param message The message that shall be displayed in the dialog.
	 * @param options The list of options from which the user may select.
	 * @param standardSelectionIndex The index of the option that shall be default selected in the dialog (pass '<em>-1</em/>' if
	 * no option shall be default selected.
	 */
	public GenericSelectionDialog(final String message, final List<String> options, final int standardSelectionIndex) {
		
		this(message, options, false, standardSelectionIndex);
		
	}
	
	/**
	 * Create the dialog.
	 *
	 * @param message The message that shall be displayed in the dialog.
	 * @param options The list of options from which the user may select.
	 * @param multiSelectionAllowed Whether multi-selection shall be allowed in the dialog.
	 * @param standardSelectionIndex The index of the option that shall be default selected in the dialog (pass '<em>-1</em/>' if
	 * no option shall be default selected.
	 */
	public GenericSelectionDialog(final String message,
			final List<String> options, boolean multiSelectionAllowed, final int standardSelectionIndex) {
		
		super(message);
		
		this.options = options;
		this.standardSelectionIndex = standardSelectionIndex;
		selectedItems = new HashSet<>();
		if(standardSelectionIndex >= 0) {
			selectedItems.add(this.standardSelectionIndex);
		}
		this.multiSelectionAllowed = multiSelectionAllowed;
	}

	@Override
	protected void createInnerContents(Shell parent) {

		// Create the group that will display the list of options to the user
		//
		final Group grpOptions = new Group(parent, SWT.NONE);
		final GridData gd_possiblePaths = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_possiblePaths.minimumHeight = 200;
		gd_possiblePaths.minimumWidth = 200;
		grpOptions.setText("Possible choices");
		grpOptions.setLayout(new FillLayout(SWT.HORIZONTAL));
		grpOptions.setLayoutData(gd_possiblePaths);

		// Create the list viewer for the list of options
		//
		final ListViewer listViewer = new ListViewer(grpOptions,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | (multiSelectionAllowed ? SWT.MULTI : 0));
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(final SelectionChangedEvent event) {
				selectedItems = new HashSet<Integer>();
				for (int index : listWidget.getSelectionIndices()) {
					selectedItems.add(index);
				}
				listWidget.showSelection();
			}
		});
		listViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(final DoubleClickEvent event) {
				shell.dispose();
			}
		});
		listWidget = listViewer.getList();
		listWidget.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.keyCode == SWT.KeyDown) {
					listWidget.select(listWidget.getSelectionIndex() + 1);
				} else if (e.keyCode == SWT.KeyUp) {
					listWidget.select(listWidget.getSelectionIndex() - 1);
				}
			}
		});

		listWidget.setItems(options.toArray(new String[options.size()]));
		listWidget.setSelection(standardSelectionIndex);
		listWidget.showSelection();
	}

	/**
	 * Get Selection after dialog has finished, returns standardSelection if
	 * dialog not run
	 * <p />
	 * Note: If multiple elements are selected by the user, this will return one (random!) element.
	 *
	 * @return the selection
	 */
	public int getSingleSelection() {

		return (selectedItems == null || selectedItems.isEmpty() ? null : selectedItems.iterator().next());
	}
	
	/**
	 * Get Selection after dialog has finished, returns standardSelection if
	 * dialog not run
	 *
	 * @return the selection
	 */
	public Set<Integer> getSelection() {

		return selectedItems;
	}

}
