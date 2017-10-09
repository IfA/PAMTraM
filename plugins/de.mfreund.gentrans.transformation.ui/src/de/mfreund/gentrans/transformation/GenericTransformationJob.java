/**
 *
 */
package de.mfreund.gentrans.transformation;

import java.util.Optional;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

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
	 * The {@link BasicGenericTransformationRunner} used to executed the transformation.
	 */
	protected BasicGenericTransformationRunner genTransRunner;

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

		this.setPriority(Job.BUILD);
	}

	@Override
	protected void canceling() {

		if (this.genTransRunner != null) {
			this.genTransRunner.cancel();
		}

		super.canceling();
	}

	@Override
	protected IStatus run(final IProgressMonitor monitor) {

		try {
			this.genTransRunner = GenericTransformationRunnerWithUIFactory
					.createInstanceWithUI(this.transformationConfig, Optional.ofNullable(monitor));
			this.genTransRunner.runTransformation();

			return org.eclipse.core.runtime.Status.OK_STATUS;

		} catch (final Exception e) {
			Activator.getDefault().getLog().log(new Status(Status.CANCEL, "de.mfreund.gentrans.transformation.ui",
					e.getMessage() != null ? e.getMessage() : e.toString(), e));
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
	}

}
