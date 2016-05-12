package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

/**
 * A {@link GenericSelectionDialog} that enables the user to select between a 'path' as well as 
 * an 'instance' to be used.
 * <p />
 * This is used during step 3 and 4 of the generic transformation when multiple possible connection paths/
 * target sections and corresponding instances exist.
 *
 */
public class PathAndInstanceSelectorDialog extends GenericSelectionDialog {

	/**
	 * For each path in {@link GenericSelectionDialogRunner#options} this list keeps a list of
	 * instances represent by an identifier.
	 */
	protected final List<List<String>> instances;
	
	/**
	 * The {@link org.eclipse.swt.widgets.List} that will present the {@link #instances} to the user.
	 */
	protected  org.eclipse.swt.widgets.List instancesList;
	
	/**
	 * The path that has been selected by the user.
	 */
	protected String path;
	
	/**
	 * The set of instances that have been selected by the user.
	 */
	protected Set<String> selectedInstances;
	
	/**
	 * The {@link org.eclipse.swt.widgets.List} that will present the {@link GenericSelectionDialog#options paths} 
	 * to the user.
	 */
	protected org.eclipse.swt.widgets.List pathList;

	/**
	 * Create the dialog without allowing for multi-selection.
	 * <p />
	 * Note: This is equal to calling '<em>PathAndInstanceSelectorDialog(message, paths, instances, 
	 * <b>false</b>, standardSelectionIndex)</em>'.
	 * 
	 * @param message The message that shall be displayed in the dialog.
	 * @param paths The paths to be presented to the user in the dialog.
	 * @param instances The instances to be presented to the user (one list of instances for each path).
	 */
	public PathAndInstanceSelectorDialog(final String message, final List<String> paths,
			final List<List<String>> instances) {
		
		this(message, paths, instances, false);
		
		
	}
	
	/**
	 * Create the dialog.
	 * 
	 * @param message The message that shall be displayed in the dialog.
	 * @param paths The paths to be presented to the user in the dialog.
	 * @param instances The instances to be presented to the user (one list of instances for each path).
	 * @param multiSelectionAllowed Whether multi-selection shall be allowed in the dialog.
	 */
	public PathAndInstanceSelectorDialog(final String message, final List<String> paths,
			final List<List<String>> instances, boolean multiSelectionAllowed) {
		
		super(message, paths, multiSelectionAllowed, 0);
		
		this.instances = instances;
		
		path = options.get(0);
		selectedInstances = new HashSet<>(Arrays.asList(instances.get(0).get(0)));
	}

	@Override
	protected void createInnerContents(Shell parent) {

		// Create the sash form that will contain the two lists for paths and instances
		//
		final SashForm sashForm = new SashForm(shell, SWT.NONE);
		final GridData gd_sashForm = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1);
		gd_sashForm.minimumHeight = 200;
		gd_sashForm.minimumWidth = 200;
		sashForm.setLayoutData(gd_sashForm);

		// Create the group that will display the list of paths to the user
		//
		final Group grpPossiblePaths = new Group(sashForm, SWT.NONE);
		grpPossiblePaths.setText("Possible Paths");
		grpPossiblePaths.setLayout(new FillLayout(SWT.HORIZONTAL));

		// Create the list viewer for the list of paths
		//
		final ListViewer pathListViewer = new ListViewer(grpPossiblePaths,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		pathList = pathListViewer.getList();
		pathList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.keyCode == SWT.KeyDown) {
					pathList.select(pathList.getSelectionIndex() + 1);
				} else if (e.keyCode == SWT.KeyUp) {
					pathList.select(pathList.getSelectionIndex() - 1);
				}
			}
		});
		pathList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(final MouseEvent e) {
				shell.dispose();
			}
		});
		pathList.setItems(options.toArray(new String[1]));

		pathListViewer.addSelectionChangedListener(new ISelectionChangedListener() {
					/**
					 * Path selection changed
					 */
					@Override
					public void selectionChanged(
							final SelectionChangedEvent event) {
						path = options.get(pathList.getSelectionIndex());
						instancesList.setItems(instances.get(
								pathList.getSelectionIndex()).toArray(
								new String[1]));
						instancesList.setSelection(0);
						selectedInstances = new HashSet<>(Arrays.asList(instances.get(
								pathList.getSelectionIndex()).get(instancesList.getSelectionIndex())));
					}
				});

		// Create the group that will display the list of instances to the user
		//
		final Group grpPossibleInstances = new Group(sashForm, SWT.NONE);
		grpPossibleInstances.setText("Possible Instances");
		grpPossibleInstances.setLayout(new FillLayout(SWT.HORIZONTAL));

		// Create the list viewer for the list of instances
		//
		final ListViewer instancesListViewer = new ListViewer(
				grpPossibleInstances, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | (multiSelectionAllowed ? SWT.MULTI : 0));
		instancesList = instancesListViewer.getList();
		instancesList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.keyCode == SWT.KeyDown) {
					instancesList.select(instancesList.getSelectionIndex() + 1);
				} else if (e.keyCode == SWT.KeyUp) {
					instancesList.select(instancesList.getSelectionIndex() - 1);
				}
			}
		});
		instancesList.addMouseListener(new MouseAdapter() {
			/**
			 * close Dialog on double clicked
			 */
			@Override
			public void mouseDoubleClick(final MouseEvent e) {
				shell.dispose();
			}
		});
		instancesList.setItems(instances.get(0).toArray(new String[1]));
		instancesList.setSelection(0);
		pathList.setSelection(0);
		sashForm.setWeights(new int[] { 347, 228 });
		
		instancesListViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			/**
			 * Instance selection changed
			 */
			@Override
			public void selectionChanged(
					final SelectionChangedEvent event) {
				selectedInstances = new HashSet<>();
				for (int index : instancesList.getSelectionIndices()) {
					selectedInstances.add(instances.get(pathList.getSelectionIndex()).get(index));
				}
			}
		});
	}

	/**
	 * Get the single selected instance after the dialog has been closed.
	 * <p />
	 * Note: This will return the first selected instance in case {@link GenericSelectionDialog#multiSelectionAllowed multi-selection} 
	 * was allowed and the user selected multiple instances.
	 * 
	 * @return selected instance
	 */
	public String getSingleInstance() {

		return (selectedInstances == null || selectedInstances.isEmpty() ? null : selectedInstances.iterator().next());

	}
	
	/**
	 * Get the selected instances after the dialog has been closed.
	 * 
	 * @return The instances that have been selected by the user.
	 */
	public Set<String> getInstances() {

		return selectedInstances;
	}

	/**
	 * Get the selected path after the dialog has been closed.
	 * 
	 * @return The path that has been selected by the user.
	 */
	public String getPath() {

		return path;
	}

}
