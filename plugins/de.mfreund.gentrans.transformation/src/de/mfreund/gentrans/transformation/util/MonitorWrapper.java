package de.mfreund.gentrans.transformation.util;

import org.eclipse.core.runtime.IProgressMonitor;

/**
 * This is a simple wrapper for an {@link IProgressMonitor} that allows the wrapping of a 'null' monitor. 
 * It redirects all method calls to the wrapped monitor if it does not equal 'null'. This can be used to 
 * write code that reports progress to a monitor but that also works if the monitor equals 'null'.
 * 
 * @author mfreund
 *
 */
public class MonitorWrapper implements IProgressMonitor {

	/**
	 * This is the {@link IProgressMonitor} that this wrapper wraps. All method calls of the {@link IProgressMonitor}
	 * interface are redirected to this (if it does not equal 'null').
	 */
	private IProgressMonitor wrappedMonitor;

	/**
	 * This constructs an instance.
	 * 
	 * @param wrappedMonitor The {@link IProgressMonitor monitor} to be wrapped. This may be 'null' if no monitor shall
	 * be used. In this case all calls to the {@link IProgressMonitor} interface are redirected nowhere.
	 */
	public MonitorWrapper(IProgressMonitor wrappedMonitor) {
		this.wrappedMonitor = wrappedMonitor;
	}

	@Override
	public void beginTask(String name, int totalWork) {
		if(wrappedMonitor != null) {
			wrappedMonitor.beginTask(name, totalWork);
		}
	}

	@Override
	public void done() {
		if(wrappedMonitor != null) {
			wrappedMonitor.done();
		}
	}

	@Override
	public void internalWorked(double work) {
		if(wrappedMonitor != null) {
			wrappedMonitor.internalWorked(work);
		}
	}

	@Override
	public boolean isCanceled() {
		if(wrappedMonitor != null) {
			return wrappedMonitor.isCanceled();
		} else {
			return false;
		}
	}

	@Override
	public void setCanceled(boolean value) {
		if(wrappedMonitor != null) {
			wrappedMonitor.setCanceled(value);
		}
	}

	@Override
	public void setTaskName(String name) {
		if(wrappedMonitor != null) {
			wrappedMonitor.setTaskName(name);
		}
	}

	@Override
	public void subTask(String name) {
		if(wrappedMonitor != null) {
			wrappedMonitor.subTask(name);
		}
	}

	@Override
	public void worked(int work) {
		if(wrappedMonitor != null) {
			wrappedMonitor.worked(work);
		}
	}

}
