package de.mfreund.gentrans.transformation.selectors;

import java.util.List;

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
	private String path, instance;
	private final String message;
	private final List<String> paths;

	private boolean transformationStopRequested;

	/**
	 * @param message
	 * @param paths
	 * @param instances
	 */
	public PathAndInstanceSelectorRunner(final String message,
			final List<String> paths, final List<List<String>> instances) {
		path = "";
		instance = "";
		transformationStopRequested = false;
		this.paths = paths;
		this.instances = instances;
		this.message = message;
	}

	/**
	 * @return selected Instance after run() was called
	 */
	public String getInstance() {
		return instance;
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
				shell, message, paths, instances);

		d.open();
		path = d.getPath();
		instance = d.getInstance();
		transformationStopRequested = d.isTransformationStopRequested();
	};

	/**
	 * @return true if Button "Abort Transformation" was clicked during run()
	 */
	public boolean wasTransformationStopRequested() {
		return transformationStopRequested;
	};

}
