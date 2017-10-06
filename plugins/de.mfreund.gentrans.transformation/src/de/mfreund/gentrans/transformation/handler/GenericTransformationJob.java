/**
 *
 */
package de.mfreund.gentrans.transformation.handler;

import java.util.Optional;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;

import de.mfreund.gentrans.transformation.GenericTransformationRunnerFactory;
import de.mfreund.gentrans.transformation.GenericTransformationRunnerWithUI;
import de.mfreund.gentrans.transformation.TransformationConfiguration;

/**
 * @author Sascha Steffen
 * @version 1.0
 *
 *          Job for running the GenTrans outside of the Eclipse UI Thread. The GenericTransformationRunner object is
 *          exposed so it can be configured.
 */
public class GenericTransformationJob extends Job {

	/**
	 * The {@link TransformationConfiguration} describing the transformation to be executed by this Job.
	 */
	protected final TransformationConfiguration transformationConfig;

	/**
	 * The {@link GenericTransformationRunner} used to executed the transformation.
	 */
	protected GenericTransformationRunnerWithUI genTransRunner;

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
			this.genTransRunner = GenericTransformationRunnerFactory.createInstance(this.transformationConfig,
					Optional.ofNullable(monitor), true);
			this.genTransRunner.runTransformation();

			return org.eclipse.core.runtime.Status.OK_STATUS;

		} catch (final Exception e) {
			e.printStackTrace(System.out);
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
	}

}
