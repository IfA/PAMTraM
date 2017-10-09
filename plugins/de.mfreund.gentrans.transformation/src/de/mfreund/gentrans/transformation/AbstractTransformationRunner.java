/**
 *
 */
package de.mfreund.gentrans.transformation;

import java.util.logging.Logger;

import de.mfreund.gentrans.transformation.core.TransformationTaskRunner;

/**
 * An abstract base implementation of {@link ITransformationRunner} that operates based on a
 * {@link TransformationTaskRunner}.
 * <p />
 * Clients can subclass this by implementing the {@link #run()} method to perform the actual transformation.
 *
 * @author mfreund
 */
public abstract class AbstractTransformationRunner implements ITransformationRunner {

	/**
	 * The {@link TransformationTaskRunner} that is used to executed the main tasks of the transformation.
	 */
	protected TransformationTaskRunner taskRunner;

	/**
	 * The {@link Logger} that is used to print messages.
	 */
	protected Logger logger;

	/**
	 * This creates an instance based on the given {@link TransformationTaskRunner}.
	 * <p />
	 * Note: This will use the given {@link Logger} implementation to print log messages.
	 *
	 * @param taskRunner
	 *            The {@link TransformationTaskRunner} that shall be used to executed the main tasks of the
	 *            transformation.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 */
	protected AbstractTransformationRunner(TransformationTaskRunner taskRunner, Logger logger) {

		this.taskRunner = taskRunner;
		this.logger = logger;

	}

	@Override
	public void cancel() {

		this.taskRunner.cancel();
	}

}