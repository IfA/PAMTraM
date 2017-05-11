package de.mfreund.gentrans.transformation;

import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import pamtram.PAMTraM;

/**
 * Instances of this class describe a concrete <em>Generic Transformation</em>
 * to be executed and describe all parameters necessary for these tasks.
 * <p />
 * They are used by the {@link GenericTransformationRunnerFactory} to
 * instantiate the {@link GenericTransformationRunner}.
 * <p />
 * If additional parameters become necessary, the can be added here without the
 * need to change the signature of the
 * {@link GenericTransformationRunner#GenericTransformationRunner(TransformationConfiguration)}
 * constructor.
 *
 * @author mfreund
 *
 */
public class TransformationConfiguration extends BaseTransformationConfiguration {

	/**
	 * The list of {@link EObject source models} to be transformed. Each element
	 * of this list should represent a root element of a model to be
	 * transformed.
	 */
	private List<EObject> sourceModels;

	/**
	 * The list of {@link PAMTraM} models to be executed.
	 */
	private List<PAMTraM> pamtramModels;

	/**
	 * The path relative to that all target models will be created. This needs
	 * to be in the form 'project-name/path'.
	 */
	private String targetBasePath;

	/**
	 * The {@link Logger} that shall be used to print messages.
	 */
	private Logger logger;

	/**
	 * This creates an instance and sets all necessary parameters.
	 * <p />
	 * Note: All optional parameters are initialized with default values but can
	 * be set/changed with the various <em>with...</em> methods.
	 *
	 * @param sourceModels
	 *            The list of {@link EObject EObjects} representing the source
	 *            models to be transformed.
	 * @param pamtramModels
	 *            The list of {@link PAMTraM} models containing the mappings to
	 *            execute in the transformation.
	 * @param targetBasePath
	 *            The path to the folder where the target models shall be
	 *            stored. This needs to be in the form 'project-name/path'.
	 * @param logger
	 *            The {@link Logger} that shall be used by the transformation to
	 *            print messages.
	 */
	public TransformationConfiguration(List<EObject> sourceModels, List<PAMTraM> pamtramModels, String targetBasePath,
			Logger logger) {

		// Initialize all optional parameters with default values
		//
		super();

		// Initialize the mandatory parameters
		//
		this.sourceModels = sourceModels;
		this.pamtramModels = pamtramModels;
		this.targetBasePath = targetBasePath;
		this.logger = logger;

	}

	/**
	 * This creates an instance and sets all necessary parameters.
	 * <p />
	 * Note: All optional parameters are initialized based on the value
	 * specified in the given {@link BaseTransformationConfiguration} but can be
	 * changed afterwards with the various <em>with...</em> methods.
	 *
	 * @param sourceModels
	 *            The list of {@link EObject EObjects} representing the source
	 *            models to be transformed.
	 * @param pamtramModels
	 *            The list of {@link PAMTraM} models containing the mappings to
	 *            execute in the transformation.
	 * @param targetBasePath
	 *            The path to the folder where the target models shall be
	 *            stored. This needs to be in the form '/project-name/path'.
	 * @param logger
	 *            The {@link Logger} that shall be used by the transformation to
	 *            print messages.
	 * @param baseConfig
	 *            The {@link BaseTransformationConfiguration} that shall be used
	 *            to set the optional parameters.
	 */
	public TransformationConfiguration(List<EObject> sourceModels, List<PAMTraM> pamtramModels, String targetBasePath,
			Logger logger, BaseTransformationConfiguration baseConfig) {

		// Initialize all optional parameters with the values specified in the
		// given
		// BaseTransformationConfiguraiton
		//
		this.defaultTargetModel = baseConfig.getDefaultTargetModel();
		this.transformationModelPath = baseConfig.getTransformationModelPath();
		this.maxPathLength = baseConfig.getMaxPathLength();
		this.onlyAskOnceOnAmbiguousMappings = baseConfig.isOnlyAskOnceOnAmbiguousMappings();
		this.libPaths = baseConfig.getLibPaths();
		this.ambiguityResolvingStrategy = baseConfig.getAmbiguityResolvingStrategy();
		this.useParallelization = baseConfig.isUseParallelization();

		// Initialize the mandatory parameters
		//
		this.sourceModels = sourceModels;
		this.pamtramModels = pamtramModels;
		this.targetBasePath = targetBasePath;
		this.logger = logger;
	}

	/**
	 * Check if all parameters have been initialized with meaningful values.
	 *
	 * @return '<em><b>true</b></em>' if all parameters have been initialized
	 *         with meaningful values; '<em><b>false</b></em>' otherwise.
	 */
	@Override
	public boolean validate() {

		if (!super.validate()) {
			return false;
		}

		if (this.logger == null) {
			return false;
		}

		if (this.sourceModels == null || this.sourceModels.isEmpty()) {
			this.logger.severe("No source models have been specified!");
			return false;
		}

		if (this.pamtramModels == null || this.pamtramModels.isEmpty()) {
			this.logger.severe("No PAMTraM model has been specified!");
			return false;
		}

		if (this.targetBasePath == null || this.targetBasePath.isEmpty()) {
			this.logger.severe("No target base path has been specified!");
			return false;
		}

		return true;
	}

	@Override
	public TransformationConfiguration withDefaultTargetModel(String defaultTargetModel) {

		super.withDefaultTargetModel(defaultTargetModel);
		return this;
	}

	@Override
	public TransformationConfiguration withTransformationModelPath(String transformationModelPath) {

		super.withTransformationModelPath(transformationModelPath);
		return this;
	}

	@Override
	public TransformationConfiguration withMaxPathLength(int maxPathLength) {

		super.withMaxPathLength(maxPathLength);
		return this;
	}

	@Override
	public TransformationConfiguration withOnlyAskOnceOnAmbiguousMappings(boolean onlyAskOnceOnAmbiguousMappings) {

		super.withOnlyAskOnceOnAmbiguousMappings(onlyAskOnceOnAmbiguousMappings);
		return this;
	}

	@Override
	public TransformationConfiguration withLibPaths(List<String> libPaths) {

		super.withLibPaths(libPaths);
		return this;
	}

	@Override
	public TransformationConfiguration withAmbiguityResolvingStrategy(
			IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {

		super.withAmbiguityResolvingStrategy(ambiguityResolvingStrategy);
		return this;
	}

	/**
	 * The getter for the {@link #sourceModels}.
	 *
	 * @return the sourceModels
	 */
	public List<EObject> getSourceModels() {

		return this.sourceModels;
	}

	/**
	 * The getter for the {@link #pamtramModels}.
	 *
	 * @return the pamtramModel
	 */
	public List<PAMTraM> getPamtramModels() {

		return this.pamtramModels;
	}

	/**
	 * The getter for the {@link #targetBasePath}.
	 *
	 * @return the targetBasePath
	 */
	public String getTargetBasePath() {

		return this.targetBasePath;
	}

	/**
	 * The getter for the {@link #logger}.
	 *
	 * @return the logger
	 */
	public Logger getLogger() {

		return this.logger;
	}
}
