package de.mfreund.gentrans.transformation;

import java.util.logging.Level;

import de.mfreund.gentrans.transformation.resolving.DefaultAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.tud.et.ifa.agtele.genlibrary.LibraryContextDescriptor;
import pamtram.metamodel.FileAttribute;
import pamtram.metamodel.LibraryEntry;

/**
 * This class captures the optional parameters that can be specified for an 
 * instance of the generic transformation.
 * They are used by the {@link GenericTransformationRunnerFactory} to instantiate
 * the {@link GenericTransformationRunner}.
 * <p />
 * The various <em>with...</em> methods provide a floating API to configure
 * the parameters.
 * 
 * @author mfreund
 *
 */
public class BaseTransformationConfiguration {

	/**
	 * File path of the <em>default</em> target model (relative to the given '<em>targetBasePath</em>'). The default 
	 * target model is that target model to which all contents will be added that are not associated with a special model
	 * via the {@link FileAttribute}.
	 */
	protected String defaultTargetModel;

	/**
	 * This is the file path where the {@link #transformationModel} will be stored after the transformation.
	 * It needs to be in the form 'project-name/path'.
	 * If this is set to '<em>null</em>', the transformation model will not be stored.
	 */
	protected String transformationModelPath;

	/**
	 * Maximum length for connection paths in the 'joining' step. '<em>0</em>' means that only direct
	 * connections are allowed; '<em>-1</em>' means that the maximum length is unbounded.
	 */
	protected int maxPathLength;

	/**
	 * Determines whether the user should be asked every time an ambiguous
	 * mapping was detected, or if the first user decision shall be stored and reused.
	 */
	protected boolean onlyAskOnceOnAmbiguousMappings;

	/**
	 * The {@link LibraryContextDescriptor descriptor for the target library context} to 
	 * be used for the instantiation of {@link LibraryEntry LibraryEntries}.
	 */
	protected LibraryContextDescriptor targetLibraryContextDescriptor;

	/**
	 * The {@link IAmbiguityResolvingStrategy} that shall be used to 
	 * resolve ambiguities that arise during the execution of the transformation.
	 */
	protected IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

	/**
	 * The minimum {@link Level} a logged messages must represent to be printed
	 * to the user. Use {@link Level#ALL} to ensure logging of all messages and
	 * {@link Level#OFF} to prevent any logging.
	 */
	protected Level logLevel;

	/**
	 * This creates an instance and initializes all parameters with default
	 * values.
	 * <p />
	 * Note: These can be changed by means of the various <em>with...</em>
	 * methods.
	 */
	public BaseTransformationConfiguration() {

		// Initialize all parameters with default values.
		//
		withDefaultTargetModel(null);
		withTransformationModelPath(null);
		withMaxPathLength(-1);
		withOnlyAskOnceOnAmbiguousMappings(true);
		withTargetLibraryContextDescriptor(null);
		withAmbiguityResolvingStrategy(null);
		withLogLevel(null);
	}

	/**
	 * Check if all parameters have been initialized with meaningful values.
	 * 
	 * @return '<em><b>true</b></em>' if all parameters have been initialized with 
	 * meaningful values; '<em><b>false</b></em>' otherwise.
	 */
	public boolean validate() {

		return defaultTargetModel != null && ambiguityResolvingStrategy != null;
	}

	/**
	 * Set the {@link #defaultTargetModel}.
	 * <p />
	 * Note: If this is '<em>null</em>', '<em>out.xmi</em>' will be used as default value.
	 * 
	 * @param defaultTargetModel The name of the {@link #defaultTargetModel} to set.
	 * @return The {@link BaseTransformationConfiguration} after setting the {@link #defaultTargetModel}.
	 */
	public BaseTransformationConfiguration withDefaultTargetModel(String defaultTargetModel) {
		this.defaultTargetModel = defaultTargetModel == null ? "out.xmi" : defaultTargetModel;
		return this;
	}

	/**
	 * Set the {@link #transformationModelPath} in the form 'project-name/path'.
	 * <p />
	 * Note: If this is set to '<em>null</em>', the transformation model will not be stored.
	 * 
	 * @param transformationModelPath The {@link #transformationModelPath} to set.
	 * @return The {@link BaseTransformationConfiguration} after setting the {@link #transformationModelPath}.
	 */
	public BaseTransformationConfiguration withTransformationModelPath(String transformationModelPath) {
		this.transformationModelPath = transformationModelPath;
		return this;
	}

	/**
	 * Set the {@link #maxPathLength}.
	 * <p />
	 * Note: If this is set to anything than '<em>0</em>', it means that the maximum length is unbounded.
	 * 
	 * @param maxPathLength The {@link #maxPathLength} to set.
	 * @return The {@link BaseTransformationConfiguration} after setting the {@link #maxPathLength}.
	 */
	public BaseTransformationConfiguration withMaxPathLength(int maxPathLength) {
		this.maxPathLength = maxPathLength < 0 ? -1 : maxPathLength;
		return this;
	}

	/**
	 * Set the {@link #onlyAskOnceOnAmbiguousMappings}.
	 * <p />
	 * Note: If this is set to '<em>true</em>', it means that the user will be asked every time
	 * an ambiguity occurs.
	 * 
	 * @param onlyAskOnceOnAmbiguousMappings The {@link #onlyAskOnceOnAmbiguousMappings} to set.
	 * @return The {@link BaseTransformationConfiguration} after setting the {@link #onlyAskOnceOnAmbiguousMappings}.
	 *
	 */
	public BaseTransformationConfiguration withOnlyAskOnceOnAmbiguousMappings(boolean onlyAskOnceOnAmbiguousMappings) {
		this.onlyAskOnceOnAmbiguousMappings = onlyAskOnceOnAmbiguousMappings;
		return this;
	}

	/**
	 * Set the {@link #targetLibraryContextDescriptor}.
	 * <p />
	 * Note: This may be set to '<em>null</em>' if no library entries shall be instantiated
	 * during the transformation.
	 * 
	 * @param targetLibraryContextDescriptor The {@link #targetLibraryContextDescriptor}.
	 * @return The {@link BaseTransformationConfiguration} after setting the {@link #targetLibraryContextDescriptor}.
	 */
	public BaseTransformationConfiguration withTargetLibraryContextDescriptor(LibraryContextDescriptor targetLibraryContextDescriptor) {
		this.targetLibraryContextDescriptor = targetLibraryContextDescriptor;
		return this;
	}

	/**
	 * Set the {@link #ambiguityResolvingStrategy}.
	 * <p />
	 * Note: If this is '<em>null</em>', the {@link DefaultAmbiguityResolvingStrategy} will be used.
	 * 
	 * @param ambiguityResolvingStrategy The {@link #ambiguityResolvingStrategy} to set.
	 * @return The {@link BaseTransformationConfiguration} after setting the {@link #ambiguityResolvingStrategy}.
	 */
	public BaseTransformationConfiguration withAmbiguityResolvingStrategy(IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {
		this.ambiguityResolvingStrategy = ambiguityResolvingStrategy == null 
				? new DefaultAmbiguityResolvingStrategy() : ambiguityResolvingStrategy;
				return this;
	}

	/**
	 * Set the {@link #logLevel}.
	 * <p />
	 * Note: If this is '<em>null</em>', {@link Level#ALL} will be used.
	 * 
	 * @param logLevel
	 *            The {@link #logLevel} to set.
	 * @return The {@link BaseTransformationConfiguration} after setting the
	 *         {@link #logLevel}.
	 */
	public BaseTransformationConfiguration withLogLevel(Level logLevel) {
		this.logLevel = logLevel == null ? Level.ALL : logLevel;
		return this;
	}

	/**
	 * The getter for the {@link #defaultTargetModel}.
	 * 
	 * @return the defaultTargetModel
	 */
	public String getDefaultTargetModel() {
		return defaultTargetModel;
	}

	/**
	 * The getter for the {@link #transformationModelPath}.
	 * 
	 * @return the transformationModelPath
	 */
	public String getTransformationModelPath() {
		return transformationModelPath;
	}

	/**
	 * The getter for the {@link #maxPathLength}.
	 * 
	 * @return the maxPathLength
	 */
	public int getMaxPathLength() {
		return maxPathLength;
	}

	/**
	 * The getter for the {@link #onlyAskOnceOnAmbiguousMappings}.
	 * 
	 * @return the onlyAskOnceOnAmbiguousMappings
	 */
	public boolean isOnlyAskOnceOnAmbiguousMappings() {
		return onlyAskOnceOnAmbiguousMappings;
	}

	/**
	 * The getter for the {@link #targetLibraryContextDescriptor}.
	 * 
	 * @return the targetLibraryContextDescriptor
	 */
	public LibraryContextDescriptor getTargetLibraryContextDescriptor() {
		return targetLibraryContextDescriptor;
	}

	/**
	 * The getter for the {@link #ambiguityResolvingStrategy}.
	 * 
	 * @return the ambiguityResolvingStrategy
	 */
	public IAmbiguityResolvingStrategy getAmbiguityResolvingStrategy() {
		return ambiguityResolvingStrategy;
	}

	/**
	 * The getter for the {@link #logLevel}.
	 * 
	 * @return the logLevel
	 */
	public Level getLogLevel() {
		return logLevel;
	}

}