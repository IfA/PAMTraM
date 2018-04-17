/*******************************************************************************
 * Copyright (C) 2015-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.ui.util;

import java.util.Optional;

import org.eclipse.core.runtime.IProgressMonitor;

/**
 * This is a simple wrapper for an {@link IProgressMonitor} that allows the wrapping of a 'null' monitor. It redirects
 * all method calls to the wrapped monitor if it is present - otherwise, all calls to the {@link IProgressMonitor}
 * interface are simply swallowed. This can be used to write code that reports progress to a monitor but that also works
 * if the monitor equals 'null'.
 *
 * @author mfreund
 *
 */
public class MonitorWrapper implements IProgressMonitor {

	/**
	 * This is the {@link IProgressMonitor} that this wrapper wraps. If present, all method calls of the
	 * {@link IProgressMonitor} interface are redirected to this wrapped monitor.
	 */
	private Optional<IProgressMonitor> wrappedMonitor;

	/**
	 * This constructs an instance.
	 * <p />
	 * Note: The <em>wrappedMonitor</em> can also be set/updated later on by using
	 * {@link #setWrappedMonitor(IProgressMonitor)}.
	 *
	 * @param wrappedMonitor
	 *            The {@link IProgressMonitor monitor} to be wrapped. If no wrappedMonitor is given, all calls to the
	 *            {@link IProgressMonitor} interface are swallowed.
	 */
	public MonitorWrapper(Optional<IProgressMonitor> wrappedMonitor) {

		this.wrappedMonitor = wrappedMonitor;
	}

	/**
	 * This updates the {@link #wrappedMonitor} wrapped by this.
	 *
	 * @param wrappedMonitor
	 *            The new {@link IProgressMonitor} that shall be wrapped by this.
	 */
	public void setWrappedMonitor(IProgressMonitor wrappedMonitor) {

		this.wrappedMonitor = Optional.ofNullable(wrappedMonitor);
	}

	@Override
	public void beginTask(String name, int totalWork) {

		this.wrappedMonitor.ifPresent(monitor -> monitor.beginTask(name, totalWork));
	}

	@Override
	public void done() {

		this.wrappedMonitor.ifPresent(IProgressMonitor::done);
	}

	@Override
	public void internalWorked(double work) {

		this.wrappedMonitor.ifPresent(monitor -> monitor.internalWorked(work));
	}

	@Override
	public boolean isCanceled() {

		return this.wrappedMonitor.isPresent() ? this.wrappedMonitor.get().isCanceled() : false;
	}

	@Override
	public void setCanceled(boolean value) {

		this.wrappedMonitor.ifPresent(monitor -> monitor.setCanceled(value));
	}

	@Override
	public void setTaskName(String name) {

		this.wrappedMonitor.ifPresent(monitor -> monitor.setTaskName(name));
	}

	@Override
	public void subTask(String name) {

		this.wrappedMonitor.ifPresent(monitor -> monitor.subTask(name));
	}

	@Override
	public void worked(int work) {

		this.wrappedMonitor.ifPresent(monitor -> monitor.worked(work));
	}

}
