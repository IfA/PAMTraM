/**
 *
 */
package de.mfreund.gentrans.transformation;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.console.MessageConsole;

import de.mfreund.gentrans.transformation.logging.GenTransConsole;
import de.mfreund.gentrans.transformation.logging.GenTransPluginStreamHandler;

/**
 * This class provides a factory that can be used to create instances of {@link BasicGenericTransformationRunner} via
 * the static {@link #createInstance(TransformationConfiguration) createInstance(...)} and
 * {@link #createInstanceWithUI(TransformationConfiguration, Optional) createInstanceWithUI(...)} methods.
 *
 * @author mfreund
 */
public class GenericTransformationRunnerWithUIFactory extends GenericTransformationRunnerFactory {

	/**
	 * This creates an instance with the given {@link TransformationConfiguration}. In contrast to
	 * {@link #createInstance(TransformationConfiguration)}, the created instance makes use of the Eclipse-specific UI
	 * facilities like logging to a {@link MessageConsole} and to the Error log.
	 * <p />
	 * Additionally, an optional {@link IProgressMonitor ProgressMonitor} can be specified that will display the
	 * progress of a transformation.
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} to be used to configure the transformation.
	 * @param monitor
	 *            An optional {@link IProgressMonitor} that shall be used to display the progress of the transformation.
	 * @return The created {@link BasicGenericTransformationRunner} that can be used to execute a transformation for the
	 *         given {@link TransformationConfiguration}.
	 */
	public static BasicGenericTransformationRunner createInstanceWithUI(
			TransformationConfiguration transformationConfig, Optional<IProgressMonitor> monitor) {

		Logger logger = GenericTransformationRunnerWithUIFactory.createLogger(transformationConfig.getLogLevel(),
				false);

		return new GenericTransformationRunnerWithUI(transformationConfig, monitor, logger);
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
	protected static Logger createLogger(Level logLevel, boolean useParentHandlers) {

		Logger logger = GenericTransformationRunnerFactory.createLogger(logLevel, useParentHandlers);

		// Create the Console that will display the messages printed to the
		// logger
		//
		new GenTransConsole(logger, logLevel);

		// Associate the internal eclipse logging facilities with the logger
		//
		logger.addHandler(new GenTransPluginStreamHandler());

		return logger;
	}
}
