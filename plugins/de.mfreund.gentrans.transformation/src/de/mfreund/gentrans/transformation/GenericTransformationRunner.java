/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
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

import java.util.Date;
import java.util.logging.Logger;

import de.mfreund.gentrans.transformation.core.TransformationTaskRunner;

/**
 * A basic {@link AbstractTransformationRunner} that can be used to execute a <em>generic transformation</em> based on a
 * given {@link TransformationTaskRunner} and that is not dependent on any (UI-related) Eclipse features like Monitors
 * or MessageDialogs.
 * <p />
 * Note: Instances need to be created via a {@link TransformationRunnerFactory}.
 *
 * @author mfreund
 */
public class GenericTransformationRunner extends AbstractTransformationRunner {

	protected static final String TRANSFORMATION_ABORTED_MESSAGE = "Transformation aborted.";

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
	public GenericTransformationRunner(TransformationTaskRunner taskRunner, Logger logger) {

		super(taskRunner, logger);
	}

	/**
	 * This performs the actual generic transformation. It loads all necessary models, executes the mappings defined in
	 * the PAMTraM model and stores the generated target model.
	 *
	 * @return A {@link ITransformationRunner.TransformationResult} indicating the result of the run.
	 */
	@Override
	public TransformationResult doRun() {

		final Date startTime = new Date();

		// Prepare the transformation (validate pamtram model, merge extends, etc.)
		//
		if (!taskRunner.prepare()) {
			logger.severe(GenericTransformationRunner.TRANSFORMATION_ABORTED_MESSAGE);
			return new TransformationResult().withAborted(true);
		}

		// Perform the various phases of the transformation
		//
		taskRunner.executeMappings();

		// Persist the create target model(s)
		//
		if (taskRunner.isCanceled() || !taskRunner.storeTargetModels()) {
			return new TransformationResult().withAborted(true);
		}

		final Date endTime = new Date();

		// Populate and store the transformation model (if necessary)
		//
		taskRunner.generateTransformationModel(startTime, endTime);

		logger.info(() -> "\n################# " + "Transformation done. Time: "
				+ (endTime.getTime() - startTime.getTime()) / 1000d + "s" + " #################\n");

		return taskRunner.compileTransformationResult();

	}

}
