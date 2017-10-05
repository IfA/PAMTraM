/**
 *
 */
package de.mfreund.gentrans.transformation.handler;

import java.util.Optional;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;

import de.mfreund.gentrans.transformation.GenericTransformationRunner;
import de.mfreund.gentrans.transformation.GenericTransformationRunnerFactory;
import de.mfreund.gentrans.transformation.TransformationConfiguration;

/**
 * @author Sascha Steffen
 * @version 1.0
 *
 *          Job for running the GenTrans outside of the Eclipse UI Thread. The GenericTransformationRunner object is
 *          exposed so it can be configured.
 */
public class GenericTransformationJob extends Job {

	final GenericTransformationRunner genTransRunner;

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

		this.genTransRunner = GenericTransformationRunnerFactory.createInstance(transformationConfig, true);

		this.setPriority(Job.BUILD);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.runtime.jobs.Job#canceling()
	 */
	@Override
	protected void canceling() {

		this.genTransRunner.cancel();
		super.canceling();
	}

	/**
	 * @return the genTransRunner
	 */
	public GenericTransformationRunner getGenTransRunner() {

		return this.genTransRunner;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime. IProgressMonitor)
	 */
	@Override
	protected IStatus run(final IProgressMonitor monitor) {

		try {
			// perform the transformation
			this.genTransRunner.runTransformation(Optional.ofNullable(monitor));
			return org.eclipse.core.runtime.Status.OK_STATUS;

		} catch (final Exception e) {
			e.printStackTrace(System.out);
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
	}

}
