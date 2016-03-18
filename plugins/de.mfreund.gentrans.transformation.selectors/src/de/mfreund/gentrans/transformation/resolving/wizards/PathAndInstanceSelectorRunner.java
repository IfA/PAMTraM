package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Sascha Steffen
 * @version 1.0
 *
 *          Runner for the PathAndInstanceSelectorDialog
 *
 */
public class PathAndInstanceSelectorRunner implements Runnable {
	private final List<List<String>> instances;
	private String path;
	private Set<String> selectedInstances;
	private final String message;
	private final List<String> paths;
	
	private boolean multiSelectionAllowed;

	private boolean transformationStopRequested;

	/**
	 * @param message
	 * @param paths
	 * @param instances
	 */
	public PathAndInstanceSelectorRunner(final String message,
			final List<String> paths, final List<List<String>> instances) {
		path = "";
		selectedInstances = new HashSet<>();
		transformationStopRequested = false;
		this.paths = paths;
		this.instances = instances;
		this.message = message;
		this.multiSelectionAllowed = false;
	}
	
	/**
	 * @param message
	 * @param paths
	 * @param instances
	 * @param multiSelectionAllowed
	 */
	public PathAndInstanceSelectorRunner(final String message,
			final List<String> paths, final List<List<String>> instances, boolean multiSelectionAllowed) {
		path = "";
		selectedInstances = new HashSet<>();
		transformationStopRequested = false;
		this.paths = paths;
		this.instances = instances;
		this.message = message;
		this.multiSelectionAllowed = multiSelectionAllowed;
	}

	/**
	 * Get selected instance after run() was called.
	 * <p />
	 * Note: If multiple elements are selected by the user, this will return one (random!) element.
	 * 
	 * @return selected Instance after run() was called
	 */
	public String getSingleInstance() {
		return (selectedInstances == null || selectedInstances.isEmpty() ? null : selectedInstances.iterator().next());
	}
	
	/**
	 * Get selected instances after run() was called.
	 * 
	 * @return selected Instances after run() was called
	 */
	public Set<String> getInstances() {
		return selectedInstances;
	}

	/**
	 * @return selected Path after run() was called
	 */
	public String getPath() {
		return path;
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
		final PathAndInstanceSelectorDialog d = new PathAndInstanceSelectorDialog(
				shell, message, paths, instances, multiSelectionAllowed);

		d.open();
		path = d.getPath();
		if(!multiSelectionAllowed) {
			selectedInstances = new HashSet<>(Arrays.asList(d.getSingleInstance()));
		} else {
			selectedInstances = new HashSet<>();
			for (String instance : d.getInstances()) {
				selectedInstances.add(instance);
			}
		}
		transformationStopRequested = d.isTransformationStopRequested();
	};

	/**
	 * @return true if Button "Abort Transformation" was clicked during run()
	 */
	public boolean wasTransformationStopRequested() {
		return transformationStopRequested;
	};

}
