package de.mfreund.gentrans.transformation;

import java.text.DateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IProgressMonitor;

import de.mfreund.gentrans.transformation.logging.GenTransConsole;
import de.mfreund.gentrans.transformation.logging.GenTransPluginStreamHandler;

/**
 * This class provides a factory that can be used to create instances of {@link GenericTransformationRunnerWithUI}
 * via the static {@link #createInstance(TransformationConfiguration, Optional, boolean) createInstance(...)} method.
 *
 * @author mfreund
 */
public class GenericTransformationRunnerFactory {

	/**
	 * The singleton instance of the factory.
	 */
	public static final GenericTransformationRunnerFactory eINSTANCE = GenericTransformationRunnerFactory.init();

	/**
	 * This creates an instance with the given {@link TransformationConfiguration}.
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} to be used to configure the transformation.
	 * @param monitor
	 *            An optional {@link IProgressMonitor} that shall be used to display the progress of the transformation.
	 * @param associateMessageConsole
	 *            If set to '<em>true</em>', a {@link GenTransConsole} will be associated with the Logger so that log
	 *            messages are printed to the MessageConsole inside the runtime platform.
	 * @return The created {@link GenericTransformationRunnerWithUI} that can be used to execute a transformation
	 *         for the given {@link TransformationConfiguration}.
	 */
	public static GenericTransformationRunnerWithUI createInstance(
			TransformationConfiguration transformationConfig, Optional<IProgressMonitor> monitor,
			boolean associateMessageConsole) {

		// Create a logger that does not log messages to the console of the development platform and that will display
		// messages on a MessageConsole inside the runtime platform
		//
		Logger logger = GenericTransformationRunnerFactory.eINSTANCE.createLogger(transformationConfig.getLogLevel(),
				false, associateMessageConsole, true);

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
	 * @param associateMessageConsole
	 *            If set to '<em>true</em>', a {@link GenTransConsole} will be associated with the Logger so that log
	 *            messages are printed to the MessageConsole inside the runtime platform.
	 * @param associateEclipseLog
	 *            Whether messages that are based on a thrown {@link Exception} shall be also logged to the internal
	 *            {@link Activator#log(Exception) logging facilities} of the {@link Activator gentrans.transformation}
	 *            plugin.
	 * @return The created {@link Logger}.
	 */
	private Logger createLogger(Level logLevel, boolean useParentHandlers, boolean associateMessageConsole,
			boolean associateEclipseLog) {

		Logger logger = Logger
				.getLogger("de.mfreund.gentrans.transformation " + DateFormat.getDateTimeInstance().format(new Date()));
		logger.setLevel(logLevel);

		// Do not log messages to the console of the development platform
		//
		logger.setUseParentHandlers(useParentHandlers);

		// Create the Console that will display the messages printed to the
		// logger
		//
		if (associateMessageConsole) {

			new GenTransConsole(logger, logLevel);
		}

		// Associate the internal eclipse logging facilities with the logger
		//
		if (associateEclipseLog) {

			logger.addHandler(new GenTransPluginStreamHandler());
		}

		return logger;
	}

	/**
	 * Used to initialize the single {@link #eINSTANCE} of this factory.
	 *
	 * @return A created instance of this factory.
	 */
	private static GenericTransformationRunnerFactory init() {

		return new GenericTransformationRunnerFactory();
	}

}
