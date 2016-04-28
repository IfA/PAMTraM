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
 * @author Sascha Steffen
 * @version 1.0
 *
 *          Dialog for choosing a path and an instance during step 3 of the
 *          GenTrans.
 *
 */
public class PathAndInstanceSelectorDialog extends GenericSelectionDialog {

	private final List<List<String>> instances;
	private org.eclipse.swt.widgets.List instancesList;
	protected String path;
	protected Set<String> selectedInstances;
	private org.eclipse.swt.widgets.List pathList;

	/**
	 * Create the dialog.
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
	 * @param message 
	 * @param paths 
	 * @param instances 
	 * @param multiSelectionAllowed 
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

		final SashForm sashForm = new SashForm(shell, SWT.NONE);
		final GridData gd_sashForm = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1);
		gd_sashForm.minimumHeight = 200;
		gd_sashForm.minimumWidth = 200;
		sashForm.setLayoutData(gd_sashForm);

		final Group grpPossiblePaths = new Group(sashForm, SWT.NONE);
		grpPossiblePaths.setText("Possible Paths");
		grpPossiblePaths.setLayout(new FillLayout(SWT.HORIZONTAL));

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

		final Group grpPossibleInstances = new Group(sashForm, SWT.NONE);
		grpPossibleInstances.setText("Possible Instances");
		grpPossibleInstances.setLayout(new FillLayout(SWT.HORIZONTAL));

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
	 * Get selected Instance after dialog has finished, return first instance in
	 * List for first path if dialog aborted / not run / multi-selection allowed
	 * 
	 * @return selected instance
	 */
	public String getSingleInstance() {

		return (selectedInstances == null || selectedInstances.isEmpty() ? null : selectedInstances.iterator().next());

	}
	
	/**
	 * Get selected Instances after dialog has finished, return first instance in
	 * List for first path if dialog aborted / not run.
	 * 
	 * @return selected instance
	 */
	public Set<String> getInstances() {

		return selectedInstances;
	}

	protected org.eclipse.swt.widgets.List getInstancesList() {
		return instancesList;
	}

	/**
	 * Get selected Path after dialog has finished, return first path in List if
	 * dialog aborted / not run
	 * 
	 * @return the path
	 */
	public String getPath() {

		return path;
	}

	protected org.eclipse.swt.widgets.List getPathList() {
		return pathList;
	}

}
