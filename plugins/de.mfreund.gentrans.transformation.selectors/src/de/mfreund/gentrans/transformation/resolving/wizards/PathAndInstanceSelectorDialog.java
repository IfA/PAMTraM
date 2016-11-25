package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

import de.tud.et.ifa.agtele.ui.listeners.KeyPressedListener;
import de.tud.et.ifa.agtele.ui.listeners.MouseDoubleClickListener;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;

/**
 * A {@link GenericSelectionDialog} that enables the user to select between a 'path' as well as an 'instance' to be
 * used.
 * <p />
 * This is used during step 3 and 4 of the generic transformation when multiple possible connection paths/ target
 * sections and corresponding instances exist.
 *
 */
public class PathAndInstanceSelectorDialog extends GenericSelectionDialog {

	/**
	 * For each path in {@link GenericSelectionDialogRunner#options} this list keeps a list of instances represent by an
	 * identifier.
	 */
	protected final List<List<String>> instances;

	/**
	 * The {@link org.eclipse.swt.widgets.List} that will present the {@link #instances} to the user.
	 */
	protected org.eclipse.swt.widgets.List instancesList;

	/**
	 * The path that has been selected by the user.
	 */
	protected String path;

	/**
	 * The set of instances that have been selected by the user.
	 */
	protected Set<String> selectedInstances;

	/**
	 * The {@link org.eclipse.swt.widgets.List} that will present the {@link GenericSelectionDialog#options paths} to
	 * the user.
	 */
	protected org.eclipse.swt.widgets.List pathList;

	/**
	 * Create the dialog without allowing for multi-selection.
	 * <p />
	 * Note: This is equal to calling '<em>PathAndInstanceSelectorDialog(message, paths, instances, <b>false</b>,
	 * standardSelectionIndex)</em>'.
	 *
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param paths
	 *            The paths to be presented to the user in the dialog.
	 * @param instances
	 *            The instances to be presented to the user (one list of instances for each path).
	 * @param enhanceMappingModelListener
	 *            A {@link SelectionListener2} that will be called when the
	 *            {@link AbstractDialog#enhanceMappingModelButton} is clicked.
	 */
	public PathAndInstanceSelectorDialog(final String message, final List<String> paths,
			final List<List<String>> instances, final SelectionListener2 enhanceMappingModelListener) {

		this(message, paths, instances, false, enhanceMappingModelListener);

	}

	/**
	 * Create the dialog.
	 *
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param paths
	 *            The paths to be presented to the user in the dialog.
	 * @param instances
	 *            The instances to be presented to the user (one list of instances for each path).
	 * @param multiSelectionAllowed
	 *            Whether multi-selection shall be allowed in the dialog.
	 * @param enhanceMappingModelListener
	 *            A {@link SelectionListener2} that will be called when the
	 *            {@link AbstractDialog#enhanceMappingModelButton} is clicked.
	 */
	public PathAndInstanceSelectorDialog(final String message, final List<String> paths,
			final List<List<String>> instances, boolean multiSelectionAllowed,
			final SelectionListener2 enhanceMappingModelListener) {

		super(message, paths, multiSelectionAllowed, 0, enhanceMappingModelListener);

		this.instances = instances;

		this.path = this.options.get(0);
		this.selectedInstances = new HashSet<>(Arrays.asList(instances.get(0).get(0)));
	}

	@Override
	protected void createInnerContents(Shell parent) {

		// Create the sash form that will contain the two lists for paths and instances
		//
		SashForm sashForm = new SashForm(this.shell, SWT.NONE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).minSize(200, 200).applyTo(sashForm);

		// Create the group that will display the list of paths to the user
		//
		Group grpPossiblePaths = new Group(sashForm, SWT.NONE);
		grpPossiblePaths.setText("Possible Paths");
		grpPossiblePaths.setLayout(new FillLayout(SWT.HORIZONTAL));

		// Create the list viewer for the list of paths
		//
		ListViewer pathListViewer = new ListViewer(grpPossiblePaths, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		this.pathList = pathListViewer.getList();
		this.pathList.addKeyListener((KeyPressedListener) e -> {
			if (e.keyCode == SWT.KeyDown) {
				PathAndInstanceSelectorDialog.this.pathList
				.select(PathAndInstanceSelectorDialog.this.pathList.getSelectionIndex() + 1);
			} else if (e.keyCode == SWT.KeyUp) {
				PathAndInstanceSelectorDialog.this.pathList
				.select(PathAndInstanceSelectorDialog.this.pathList.getSelectionIndex() - 1);
			}

		});
		this.pathList
		.addMouseListener((MouseDoubleClickListener) e -> PathAndInstanceSelectorDialog.this.shell.dispose());
		this.pathList.setItems(this.options.toArray(new String[1]));

		pathListViewer.addSelectionChangedListener(event -> {
			PathAndInstanceSelectorDialog.this.path = PathAndInstanceSelectorDialog.this.options
					.get(PathAndInstanceSelectorDialog.this.pathList.getSelectionIndex());
			PathAndInstanceSelectorDialog.this.instancesList.setItems(PathAndInstanceSelectorDialog.this.instances
					.get(PathAndInstanceSelectorDialog.this.pathList.getSelectionIndex()).toArray(new String[1]));
			PathAndInstanceSelectorDialog.this.instancesList.setSelection(0);
			PathAndInstanceSelectorDialog.this.selectedInstances = new HashSet<>(
					Arrays.asList(PathAndInstanceSelectorDialog.this.instances
							.get(PathAndInstanceSelectorDialog.this.pathList.getSelectionIndex())
							.get(PathAndInstanceSelectorDialog.this.instancesList.getSelectionIndex())));
		});

		// Create the group that will display the list of instances to the user
		//
		final Group grpPossibleInstances = new Group(sashForm, SWT.NONE);
		grpPossibleInstances.setText("Possible Instances");
		grpPossibleInstances.setLayout(new FillLayout(SWT.HORIZONTAL));

		// Create the list viewer for the list of instances
		//
		final ListViewer instancesListViewer = new ListViewer(grpPossibleInstances,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | (this.multiSelectionAllowed ? SWT.MULTI : 0));
		this.instancesList = instancesListViewer.getList();
		this.instancesList.addKeyListener((KeyPressedListener) e -> {

			if (e.keyCode == SWT.KeyDown) {
				PathAndInstanceSelectorDialog.this.instancesList
				.select(PathAndInstanceSelectorDialog.this.instancesList.getSelectionIndex() + 1);
			} else if (e.keyCode == SWT.KeyUp) {
				PathAndInstanceSelectorDialog.this.instancesList
				.select(PathAndInstanceSelectorDialog.this.instancesList.getSelectionIndex() - 1);
			}
		});
		this.instancesList
				.addMouseListener((MouseDoubleClickListener) e -> PathAndInstanceSelectorDialog.this.shell.dispose());
		this.instancesList.setItems(this.instances.get(0).toArray(new String[1]));
		this.instancesList.setSelection(0);
		this.pathList.setSelection(0);
		sashForm.setWeights(new int[] { 347, 228 });

		instancesListViewer.addSelectionChangedListener(event -> {
			PathAndInstanceSelectorDialog.this.selectedInstances = new HashSet<>();
			for (int index : PathAndInstanceSelectorDialog.this.instancesList.getSelectionIndices()) {
				PathAndInstanceSelectorDialog.this.selectedInstances.add(PathAndInstanceSelectorDialog.this.instances
						.get(PathAndInstanceSelectorDialog.this.pathList.getSelectionIndex()).get(index));
			}
		});
	}

	/**
	 * Get the single selected instance after the dialog has been closed.
	 * <p />
	 * Note: This will return the first selected instance in case {@link GenericSelectionDialog#multiSelectionAllowed
	 * multi-selection} was allowed and the user selected multiple instances.
	 *
	 * @return selected instance
	 */
	public String getSingleInstance() {

		return this.selectedInstances == null || this.selectedInstances.isEmpty() ? null
				: this.selectedInstances.iterator().next();

	}

	/**
	 * Get the selected instances after the dialog has been closed.
	 *
	 * @return The instances that have been selected by the user.
	 */
	public Set<String> getInstances() {

		return this.selectedInstances;
	}

	/**
	 * Get the selected path after the dialog has been closed.
	 *
	 * @return The path that has been selected by the user.
	 */
	public String getPath() {

		return this.path;
	}

}
