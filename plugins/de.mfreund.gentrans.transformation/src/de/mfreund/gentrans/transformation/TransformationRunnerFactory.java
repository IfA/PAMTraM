package de.mfreund.gentrans.transformation;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.mfreund.gentrans.transformation.core.TransformationTaskRunner;

/**
 * This class provides a factory that can be used to create instances of {@link ITransformationRunner} via the various
 * <em>create...</em> methods.
 * <p />
 * Access to these methods can be gained via the singleton {@link #INSTANCE}.
 *
 * @author mfreund
 */
public class TransformationRunnerFactory {

	/**
	 * The singleton instance of this factory.
	 */
	public static final TransformationRunnerFactory INSTANCE = new TransformationRunnerFactory();

	protected TransformationRunnerFactory() {

		// Just to prevent public instantiation
		//
	}

	/**
	 * This creates an instance of {@link GenericTransformationRunner} with the given
	 * {@link TransformationConfiguration}.
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} to be used to configure the transformation.
	 * @return The created {@link GenericTransformationRunner} that can be used to execute a transformation for the
	 *         given {@link TransformationConfiguration}.
	 */
	public ITransformationRunner createGenericTransformationRunner(TransformationConfiguration transformationConfig) {

		Logger logger = this.createLogger(transformationConfig.getLogLevel(), false);

		TransformationTaskRunner taskRunner = this.createTaskRunner(transformationConfig, logger);

		return new GenericTransformationRunner(taskRunner, logger);
	}

	/**
	 * This creates an instance of {@link SourceSectionMatcher} with the given {@link TransformationConfiguration}.
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} to be used to configure the transformation.
	 * @return The created {@link GenericTransformationRunner} that can be used to execute a transformation for the
	 *         given {@link TransformationConfiguration}.
	 */
	public ITransformationRunner createSourceSectionMatcher(TransformationConfiguration transformationConfig) {

		Logger logger = this.createLogger(transformationConfig.getLogLevel(), false);

		TransformationTaskRunner taskRunner = this.createTaskRunner(transformationConfig, logger);

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
	protected Logger createLogger(Level logLevel, boolean useParentHandlers) {

		Logger logger = Logger
				.getLogger("de.mfreund.gentrans.transformation " + DateFormat.getDateTimeInstance().format(new Date()));
		logger.setLevel(logLevel);

		// Do not log messages to the console of the development platform
		//
		logger.setUseParentHandlers(useParentHandlers);

		return logger;
	}

	/**
	 * This creates a {@link TransformationTaskRunner} that shall be used to execute the main tasks of a transformation.
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} to be used to configure the transformation.
	 * @return The created {@link TransformationTaskRunner} that can be used the main tasks of a transformation.
	 */
	protected TransformationTaskRunner createTaskRunner(TransformationConfiguration transformationConfig,
			Logger logger) {

		return new TransformationTaskRunner(transformationConfig, logger);
	}

}
