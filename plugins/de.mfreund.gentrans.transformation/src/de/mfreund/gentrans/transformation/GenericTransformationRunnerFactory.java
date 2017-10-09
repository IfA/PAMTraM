package de.mfreund.gentrans.transformation;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class provides a factory that can be used to create instances of {@link BasicGenericTransformationRunner} via
 * the static {@link #createInstance(TransformationConfiguration) createInstance(...)} method.
 *
 * @author mfreund
 */
public class GenericTransformationRunnerFactory {

	protected GenericTransformationRunnerFactory() {

		// Just to prevent public instantiation
		//
	}

	/**
	 * This creates an instance with the given {@link TransformationConfiguration}.
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} to be used to configure the transformation.
	 * @return The created {@link BasicGenericTransformationRunner} that can be used to execute a transformation for the
	 *         given {@link TransformationConfiguration}.
	 */
	public static BasicGenericTransformationRunner createInstance(TransformationConfiguration transformationConfig) {

		Logger logger = GenericTransformationRunnerFactory.createLogger(transformationConfig.getLogLevel(), false);

		return new BasicGenericTransformationRunner(transformationConfig, logger);
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

		Logger logger = Logger
				.getLogger("de.mfreund.gentrans.transformation " + DateFormat.getDateTimeInstance().format(new Date()));
		logger.setLevel(logLevel);

		// Do not log messages to the console of the development platform
		//
		logger.setUseParentHandlers(useParentHandlers);

		return logger;
	}

}
