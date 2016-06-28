package de.mfreund.gentrans.transformation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.resolving.DefaultAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.tud.et.ifa.agtele.genlibrary.LibraryContextDescriptor;
import pamtram.PAMTraM;

/**
 * Instances of this class describe a concrete <em>Generic Transformation</em>
 * to be executed and describe all parameters necessary for these tasks.
 * <p />
 * They are used by the {@link GenericTransformationRunnerFactory} to instantiate
 * the {@link GenericTransformationRunner}.
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
	 * The list of {@link EObject source models} to be transformed. Each element of this list
	 * should represent a root element of a model to be transformed.
	 */
	private List<EObject> sourceModels;
	
	/**
	 * The {@link PAMTraM} model to be executed.
	 */
	private PAMTraM pamtramModel;
	
	/**
	 *  The path relative to that all target models will be created. This needs to be in the 
	 *  form 'project-name/path'.
	 */
	private String targetBasePath; 
	
	/**
	 * The {@link MessageConsoleStream message output stream} that shall be used to print messages to the user.
	 */
	private MessageConsoleStream consoleStream;
	
	/**
	 * This creates an instance and sets all necessary parameters.
	 * <p />
	 * Note: All optional parameters are initialized with default values but can be set/changed
	 * with the various <em>with...</em> methods.
	 * 
	 * @param sourceModels The list of {@link EObject EObjects} representing the source models to be transformed.
	 * @param pamtramModel The {@link PAMTraM} model containing the mappings to execute in the transformation.
	 * @param targetBasePath The path to the folder where the target models shall be stored. This needs to be
	 * in the form 'project-name/path'.
	 * @param consoleStream The {@link MessageConsoleStream} that shall be used by the transformation to 
	 * print messages.
	 */
	public TransformationConfiguration(List<EObject> sourceModels, PAMTraM pamtramModel, 
			String targetBasePath, MessageConsoleStream consoleStream){
		
		// Initialize the mandatory parameters
		//
		this.sourceModels = sourceModels;
		this.pamtramModel = pamtramModel;
		this.targetBasePath = targetBasePath;
		this.consoleStream = consoleStream;
		
		// Initialize all optional parameters with default values
		//
		this.defaultTargetModel = "out.xmi";
		this.transformationModelPath = null;
		this.maxPathLength = 0;
		this.onlyAskOnceOnAmbiguousMappings = true;
		this.targetLibraryContextDescriptor = null;
		this.ambiguityResolvingStrategy = new DefaultAmbiguityResolvingStrategy();
	}
	
	/**
	 * This creates an instance and sets all necessary parameters.
	 * <p />
	 * Note: All optional parameters are initialized based on the value specified in the given
	 * {@link BaseTransformationConfiguration} but can be changed afterwards
	 * with the various <em>with...</em> methods.
	 * 
	 * @param sourceModels The list of {@link EObject EObjects} representing the source models to be transformed.
	 * @param pamtramModel The {@link PAMTraM} model containing the mappings to execute in the transformation.
	 * @param targetBasePath The path to the folder where the target models shall be stored. This needs to be
	 * in the form '/project-name/path'.
	 * @param consoleStream The {@link MessageConsoleStream} that shall be used by the transformation to 
	 * print messages.
	 * @param baseConfig The {@link BaseTransformationConfiguration} that shall be used to set the
	 * optional parameters.
	 */
	public TransformationConfiguration(List<EObject> sourceModels, PAMTraM pamtramModel, 
			String targetBasePath, MessageConsoleStream consoleStream, BaseTransformationConfiguration baseConfig){
		
		// Initialize the mandatory parameters
		//
		this.sourceModels = sourceModels;
		this.pamtramModel = pamtramModel;
		this.targetBasePath = targetBasePath;
		this.consoleStream = consoleStream;
		
		// Initialize all optional parameters with default values
		//
		this.defaultTargetModel = baseConfig.getDefaultTargetModel();
		this.transformationModelPath = baseConfig.getTransformationModelPath();
		this.maxPathLength = baseConfig.getMaxPathLength();
		this.onlyAskOnceOnAmbiguousMappings = baseConfig.isOnlyAskOnceOnAmbiguousMappings();
		this.targetLibraryContextDescriptor = baseConfig.getTargetLibraryContextDescriptor();
		this.ambiguityResolvingStrategy = baseConfig.getAmbiguityResolvingStrategy();
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
	public TransformationConfiguration withTargetLibraryContextDescriptor(LibraryContextDescriptor targetLibraryContextDescriptor) {
		super.withTargetLibraryContextDescriptor(targetLibraryContextDescriptor);
		return this;
	}

	@Override
	public TransformationConfiguration withAmbiguityResolvingStrategy(IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {
		super.withAmbiguityResolvingStrategy(ambiguityResolvingStrategy);
		return this;
	}
	
	/**
	 * The getter for the {@link #sourceModels}.
	 * 
	 * @return the sourceModels
	 */
	public List<EObject> getSourceModels() {
		return sourceModels;
	}

	/**
	 * The getter for the {@link #pamtramModel}.
	 * 
	 * @return the pamtramModel
	 */
	public PAMTraM getPamtramModel() {
		return pamtramModel;
	}

	/**
	 * The getter for the {@link #targetBasePath}.
	 * 
	 * @return the targetBasePath
	 */
	public String getTargetBasePath() {
		return targetBasePath;
	}
	
	/**
	 * The getter for the {@link #consoleStream}.
	 * 
	 * @return the consoleStream
	 */
	public MessageConsoleStream getConsoleStream() {
		return consoleStream;
	}
}
