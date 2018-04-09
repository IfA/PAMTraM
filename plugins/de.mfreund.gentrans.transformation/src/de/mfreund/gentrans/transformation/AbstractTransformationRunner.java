/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation;

import java.util.logging.Level;
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

	/**
	 * This executes the runner (resp. the generic transformation that it represents).
	 * <p />
	 * This default implementation just redirects to {@link #doRun()}. However, it properly handles and logs any
	 * exception thrown by {@link #doRun()}.
	 * <p />
	 * Note: Clients should overwrite {@link #doRun()} instead.
	 *
	 * @return A {@link ITransformationRunner.TransformationResult} indicating the result of the run.
	 */
	@Override
	public TransformationResult run() {

		try {

			return doRun();

		} catch (CancelTransformationException e1) {

			logger.log(Level.SEVERE, e1, e1::printInfo);
			logger.severe("See the ErrorLog for more information!");
			logger.severe("Aborting...");
			return new TransformationResult().withAborted(true);
		} catch (Exception e) {

			logger.log(Level.SEVERE, e, () -> e.getMessage() != null ? e.getMessage() : e.toString());
			logger.severe("See the ErrorLog for more information!");
			logger.severe("Aborting...");

			return new TransformationResult().withAborted(true);
		}

	}

	/**
	 * The internal worker method that is called by {@link #run()} and that executes the runner (resp. the generic
	 * transformation that it represents).
	 * <p />
	 * Note: Clients should usually overwrite this instead of directly overwriting {@link #run()} in order to not need
	 * to concern themselves with handling of potential exceptions thrown during the execution of the transformation.
	 *
	 * @return A {@link ITransformationRunner.TransformationResult} indicating the result of the run.
	 */
	protected abstract TransformationResult doRun();

	@Override
	public void cancel() {

		taskRunner.cancel();
	}

}
