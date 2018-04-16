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

import java.util.logging.Logger;

import de.mfreund.gentrans.transformation.core.TransformationTaskRunner;

/**
 * A basic {@link AbstractTransformationRunner} that can be used to perform and return the results of the
 * <em>searching_matchSections</em> phase of the transformation based on a given {@link TransformationTaskRunner} and
 * that is not dependent on any (UI-related) Eclipse features like Monitors or MessageDialogs.
 * <p />
 * Note: Instances need to be created via a {@link TransformationRunnerFactory}.
 *
 * @author mfreund
 */
public class SourceSectionMatcher extends AbstractTransformationRunner {

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
	public SourceSectionMatcher(TransformationTaskRunner taskRunner, Logger logger) {

		super(taskRunner, logger);

	}

	/**
	 * This performs the actual <em>searching_matchSections</em> phase of the transformation. Therefore, all necessary
	 * models are loaded first.
	 *
	 * @return A {@link ITransformationRunner.TransformationResult} indicating the result of the run.
	 */
	@Override
	public TransformationResult doRun() {

		// Prepare the transformation (validate pamtram model, merge extends, etc.)
		//
		if (!this.taskRunner.prepare()) {
			this.logger.severe(GenericTransformationRunner.TRANSFORMATION_ABORTED_MESSAGE);
			return new TransformationResult().withAborted(true);
		}

		/*
		 * Perform the first step of the 'searching' step of the transformation
		 */
		this.taskRunner.performSearching_MatchSections();

		this.logger.info(() -> "\n################# " + "Done" + " #################\n");

		return this.taskRunner.compileTransformationResult();
	}

}
