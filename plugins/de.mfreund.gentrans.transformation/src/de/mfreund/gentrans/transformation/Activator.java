package de.mfreund.gentrans.transformation;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "de.mfreund.gentrans.transformation"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {

		super.start(context);
		Activator.plugin = this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {

		Activator.plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {

		return Activator.plugin;
	}

	/**
	 * {@link ILog#log(IStatus) Logs} the given message to the Eclipse error log and to the workspace log file.
	 *
	 * @param severity
	 *            the severity of the message to log; one of <code>OK</code>, <code>ERROR</code>, <code>INFO</code>,
	 *            <code>WARNING</code>, or <code>CANCEL</code>
	 * @param msg
	 *            the message to log
	 */
	public static void log(int severity, String msg) {

		Activator.log(severity, msg, null);
	}

	/**
	 * {@link ILog#log(IStatus) Logs} the given exception to the Eclipse error log and to the workspace log file.
	 * <p />
	 * This is equivalent to {@link #log(int, Exception) log(IStatus.ERROR, Exception)}
	 *
	 * @param e
	 *            the exception to log
	 */
	public static void log(Exception e) {

		Activator.log(IStatus.ERROR, e.getMessage() != null ? e.getMessage() : e.toString(), e);
	}

	/**
	 * {@link ILog#log(IStatus) Logs} the given exception to the Eclipse error log and to the workspace log file.
	 *
	 * @param severity
	 *            the severity of the exception to log; one of <code>OK</code>, <code>ERROR</code>, <code>INFO</code>,
	 *            <code>WARNING</code>, or <code>CANCEL</code>
	 * @param e
	 *            the exception to log
	 */
	public static void log(int severity, Exception e) {

		Activator.log(severity, e.getMessage() != null ? e.getMessage() : e.toString(), e);
	}

	/**
	 * {@link ILog#log(IStatus) Logs} the given message and exception to the Eclipse error log and to the workspace log
	 * file.
	 * <p />
	 * This is equivalent to {@link #log(int, String, Exception) log(IStatus.ERROR, String, Exception)}
	 *
	 * @param msg
	 *            the message to log
	 * @param e
	 *            the exception to log
	 */
	public static void log(String msg, Exception e) {

		Activator.log(IStatus.ERROR, msg, e);
	}

	/**
	 * {@link ILog#log(IStatus) Logs} the given message and exception to the Eclipse error log and to the workspace log
	 * file.
	 *
	 * @param severity
	 *            the severity of the exception to log; one of <code>OK</code>, <code>ERROR</code>, <code>INFO</code>,
	 *            <code>WARNING</code>, or <code>CANCEL</code>
	 * @param msg
	 *            the message to log
	 * @param e
	 *            the exception to log
	 */
	public static void log(int severity, String msg, Exception e) {

		Activator.getDefault().getLog().log(new Status(severity, Activator.PLUGIN_ID, Status.OK, msg, e));
	}

}
