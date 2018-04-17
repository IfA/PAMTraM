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
/**
 *
 */
package de.mfreund.gentrans.transformation;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.ui.console.MessageConsole;

import de.mfreund.gentrans.transformation.core.TransformationTaskRunner;
import de.mfreund.gentrans.transformation.core.TransformationTaskRunnerWithUI;
import de.mfreund.gentrans.transformation.logging.GenTransConsole;
import de.mfreund.gentrans.transformation.logging.GenTransPluginStreamHandler;

/**
 * This class provides a factory that can be used to create instances of {@link ITransformationRunner} via the various
 * <em>create...</em> methods. In contrast to those instances created via the {@link TransformationRunnerFactory}, these
 * instances make use of Eclipse-specific utilities like {@link IProgressMonitor monitors}, {@link MessageConsole
 * MessageConsoles} and {@link Dialog Dialogs}.
 * <p />
 * Access to the creation methods can be gained via the singleton {@link #INSTANCE}.
 *
 * @see TransformationRunnerFactory
 *
 * @author mfreund
 */
public class TransformationRunnerWithUIFactory extends TransformationRunnerFactory {

	/**
	 * The singleton instance of this factory.
	 */
	public static final TransformationRunnerWithUIFactory INSTANCE = new TransformationRunnerWithUIFactory();

	protected TransformationRunnerWithUIFactory() {

		// Just to prevent public instantiation
		//
	}

	/**
	 * This creates an instance of {@link GenericTransformationRunner} with the given
	 * {@link TransformationConfiguration}.
	 *
	 * @see #createGenericTransformationRunner(TransformationConfiguration, IProgressMonitor)
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} to be used to configure the transformation.
	 * @return The created {@link GenericTransformationRunner} that can be used to execute a transformation for the
	 *         given {@link TransformationConfiguration}.
	 */
	@Override
	public ITransformationRunner createGenericTransformationRunner(TransformationConfiguration transformationConfig) {

		return this.createGenericTransformationRunner(transformationConfig, null);
	}

	/**
	 * This creates an instance of {@link GenericTransformationRunner} with the given
	 * {@link TransformationConfiguration}.
	 *
	 * @see #createGenericTransformationRunner(TransformationConfiguration)
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} to be used to configure the transformation.
	 * @param monitor
	 *            An {@link IProgressMonitor} that shall be used to inform the user about the progress of the
	 *            transformation.
	 * @return The created {@link GenericTransformationRunner} that can be used to execute a transformation for the
	 *         given {@link TransformationConfiguration}.
	 */
	public ITransformationRunner createGenericTransformationRunner(TransformationConfiguration transformationConfig,
			IProgressMonitor monitor) {

		Logger logger = this.createLogger(transformationConfig.getLogLevel(), false);

		TransformationTaskRunnerWithUI taskRunner = (TransformationTaskRunnerWithUI) this
				.createTaskRunner(transformationConfig, logger);
		taskRunner.setMonitor(monitor);

		return new GenericTransformationRunnerWithUI(taskRunner, logger, Optional.ofNullable(monitor));
	}

	/**
	 * This creates an instance of {@link SourceSectionMatcher} with the given {@link TransformationConfiguration}.
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} to be used to configure the transformation.
	 * @return The created {@link GenericTransformationRunner} that can be used to execute a transformation for the
	 *         given {@link TransformationConfiguration}.
	 */
	@Override
	public ITransformationRunner createSourceSectionMatcher(TransformationConfiguration transformationConfig) {

		return this.createSourceSectionMatcher(transformationConfig, null);
	}

	/**
	 * This creates an instance of {@link SourceSectionMatcher} with the given {@link TransformationConfiguration}.
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} to be used to configure the transformation.
	 * @param monitor
	 *            An {@link IProgressMonitor} that shall be used to inform the user about the progress of the
	 *            transformation.
	 * @return The created {@link GenericTransformationRunner} that can be used to execute a transformation for the
	 *         given {@link TransformationConfiguration}.
	 */
	public ITransformationRunner createSourceSectionMatcher(TransformationConfiguration transformationConfig,
			IProgressMonitor monitor) {

		Logger logger = this.createLogger(transformationConfig.getLogLevel(), false);

		TransformationTaskRunnerWithUI taskRunner = (TransformationTaskRunnerWithUI) this
				.createTaskRunner(transformationConfig, logger);
		taskRunner.setMonitor(monitor);

		return new SourceSectionMatcher(taskRunner, logger);
	}

	/**
	 * This creates a {@link Logger} based on the given configuration settings.
	 *
	 * @param logLevel
	 *            The {@link Level logLevel} for the Logger.
	 * @param useParentHandlers
	 *            Whether or not the Logger shall send messages to its {@link Logger#setUseParentHandlers(boolean)
	 *            parent handlers}.
	 * @return The created {@link Logger}.
	 */
	@Override
	protected Logger createLogger(Level logLevel, boolean useParentHandlers) {

		Logger logger = this.createBasicLogger(logLevel, useParentHandlers);

		// Create the Console that will display the messages printed to the
		// logger
		//
		new GenTransConsole(logger, logLevel);

		// Associate the internal eclipse logging facilities with the logger
		//
		logger.addHandler(new GenTransPluginStreamHandler());

		return logger;
	}

	/**
	 * This creates a {@link TransformationTaskRunner} that shall be used to execute the main tasks of a transformation.
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} to be used to configure the transformation.
	 * @return The created {@link TransformationTaskRunner} that can be used the main tasks of a transformation.
	 */
	@Override
	protected TransformationTaskRunner createTaskRunner(TransformationConfiguration transformationConfig,
			Logger logger) {

		return new TransformationTaskRunnerWithUI(transformationConfig, Optional.empty(), logger);
	}

}
