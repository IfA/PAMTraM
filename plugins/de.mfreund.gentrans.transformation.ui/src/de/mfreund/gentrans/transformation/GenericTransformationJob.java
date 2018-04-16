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
package de.mfreund.gentrans.transformation;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import de.mfreund.gentrans.transformation.ui.Activator;

/**
 * A {@link Job} for running transformations outside of the Eclipse UI Thread.
 *
 * @author mfreund
 */
public class GenericTransformationJob extends Job {

	/**
	 * The {@link TransformationConfiguration} describing the transformation to be executed by this Job.
	 */
	protected final TransformationConfiguration transformationConfig;

	/**
	 * The {@link ITransformationRunner} used to executed the transformation.
	 */
	protected ITransformationRunner genTransRunner;

	/**
	 * Create a new GenericTransformationJob with the given 'jobName'.
	 *
	 * @param jobName
	 *            The name of the transformation job to be created.
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} to be used for the transformation execution.
	 */
	public GenericTransformationJob(final String jobName, TransformationConfiguration transformationConfig) {

		super(jobName);

		this.transformationConfig = transformationConfig;

		setPriority(Job.BUILD);
	}

	@Override
	protected void canceling() {

		if (genTransRunner != null) {
			genTransRunner.cancel();
		}

		super.canceling();
	}

	@Override
	protected IStatus run(final IProgressMonitor monitor) {

		try {
			genTransRunner = TransformationRunnerWithUIFactory.INSTANCE
					.createGenericTransformationRunner(transformationConfig, monitor);
			genTransRunner.run();

			return org.eclipse.core.runtime.Status.OK_STATUS;

		} catch (final Exception e) {
			Activator.getDefault().getLog().log(new Status(IStatus.CANCEL, "de.mfreund.gentrans.transformation.ui",
					e.getMessage() != null ? e.getMessage() : e.toString(), e));
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		} finally {
			genTransRunner = null;
		}
	}

}
