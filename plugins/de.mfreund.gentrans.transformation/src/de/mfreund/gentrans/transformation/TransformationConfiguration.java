/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.tud.et.ifa.agtele.emf.connecting.Length;
import de.tud.et.ifa.agtele.resources.ResourceHelper;
import pamtram.PAMTraM;
import pamtram.util.PamtramModelUtil;
import pamtram.util.PamtramModelUtil.ModelLoadException;

/**
 * Instances of this class describe a concrete <em>Generic Transformation</em> to be executed and describe all
 * parameters necessary for these tasks.
 * <p />
 * They are used by the {@link TransformationRunnerFactory} to create concrete {@link GenericTransformationRunner
 * GenericTransformationRunners}.
 * <p />
 * If additional parameters become necessary, the can be added here without the need to change the
 * {@link TransformationRunnerFactory}.
 *
 * @author mfreund
 *
 */
public class TransformationConfiguration extends BaseTransformationConfiguration {

	/**
	 * The list of {@link EObject source models} to be transformed. Each element of this list should represent a root
	 * element of a model to be transformed.
	 */
	private List<EObject> sourceModels;

	/**
	 * The list of {@link PAMTraM} models to be executed.
	 */
	private List<PAMTraM> pamtramModels;

	/**
	 * The path relative to that all target models will be created. This needs to be in the form 'project-name/path'.
	 */
	private String targetBasePath;

	/**
	 * This creates an (empty) instance.
	 * <p />
	 * Note: All optional parameters are initialized with default values but can be set/changed with the various
	 * <em>with...</em> methods.
	 *
	 */
	private TransformationConfiguration() {

		// Initialize all optional parameters with default values
		//
		super();

	}

	/**
	 * This creates an instance and sets all necessary parameters.
	 * <p />
	 * Note: All optional parameters are initialized with default values but can be set/changed with the various
	 * <em>with...</em> methods.
	 *
	 * @param sourceModels
	 *            The list of {@link EObject EObjects} representing the source models to be transformed.
	 * @param pamtramModels
	 *            The list of {@link PAMTraM} models containing the mappings to execute in the transformation.
	 * @param targetBasePath
	 *            The path to the folder where the target models shall be stored. This needs to be in the form
	 *            'project-name/path'.
	 */
	private TransformationConfiguration(List<EObject> sourceModels, List<PAMTraM> pamtramModels,
			String targetBasePath) {

		// Initialize all optional parameters with default values
		//
		super();

		// Initialize the mandatory parameters
		//
		this.sourceModels = sourceModels;
		this.pamtramModels = pamtramModels;
		this.targetBasePath = targetBasePath;

	}

	/**
	 * This creates an instance and sets all necessary parameters.
	 * <p />
	 * Note: All optional parameters are initialized based on the value specified in the given
	 * {@link BaseTransformationConfiguration} but can be changed afterwards with the various <em>with...</em> methods.
	 *
	 * @param sourceModels
	 *            The list of {@link EObject EObjects} representing the source models to be transformed.
	 * @param pamtramModels
	 *            The list of {@link PAMTraM} models containing the mappings to execute in the transformation.
	 * @param targetBasePath
	 *            The path to the folder where the target models shall be stored. This needs to be in the form
	 *            '/project-name/path'.
	 * @param baseConfig
	 *            The {@link BaseTransformationConfiguration} that shall be used to set the optional parameters.
	 */
	private TransformationConfiguration(List<EObject> sourceModels, List<PAMTraM> pamtramModels, String targetBasePath,
			BaseTransformationConfiguration baseConfig) {

		// Initialize all optional parameters with the values specified in the
		// given
		// BaseTransformationConfiguraiton
		//
		openTargetModelOnCompletion = baseConfig.isOpenTargetModelOnCompletion();
		defaultTargetModel = baseConfig.getDefaultTargetModel();
		transformationModelPath = baseConfig.getTransformationModelPath();
		maxPathLength = baseConfig.getMaxPathLength();
		onlyAskOnceOnAmbiguousMappings = baseConfig.isOnlyAskOnceOnAmbiguousMappings();
		libPaths = baseConfig.getLibPaths();
		ambiguityResolvingStrategy = baseConfig.getAmbiguityResolvingStrategy();
		useParallelization = baseConfig.isUseParallelization();

		// Initialize the mandatory parameters
		//
		this.sourceModels = sourceModels;
		this.pamtramModels = pamtramModels;
		this.targetBasePath = targetBasePath;
	}

	/**
	 * This constructs an instance.
	 * <p />
	 * Note: The instance is initialized with a default {@link BaseTransformationConfiguration}.
	 *
	 * @see #createInstanceFromSourceModels(List, List, String)
	 * @see #createInstanceFromSourcePaths(Set, List, String)
	 *
	 * @param sourceFilePaths
	 *            List of file paths of the source models. Each path must either be absolute or relative to the
	 *            workspace root (of the form '<em>/project-name/path</em>').
	 * @param pamtramPaths
	 *            Paths to the {@link PAMTraM} models to be executed in the form 'project-name/path'.
	 * @param targetBasePath
	 *            File path relative to that all target models will be created in the form 'project-name/path'.
	 * @return The created {@link TransformationConfiguration}.
	 * @throws InitializationException
	 *             If the initialization failed for some reason, e.g. because one of the models could not be loaded.
	 */
	public static TransformationConfiguration createInstanceFromSourcePaths(Set<String> sourceFilePaths,
			Set<String> pamtramPaths, String targetBasePath) throws InitializationException {

		// Create a resource set to load the models.
		//
		ResourceSet resourceSet = new ResourceSetImpl();

		// Load the PAMTraM models
		//
		List<PAMTraM> pamtramModels = null;
		try {
			pamtramModels = PamtramModelUtil.loadPamtramModels(resourceSet, pamtramPaths, true);
		} catch (ModelLoadException e) {
			throw new TransformationConfiguration().new InitializationException(e);
		}

		if (pamtramModels == null || pamtramModels.isEmpty()) {
			throw new TransformationConfiguration().new InitializationException("No PAMTraM model was loaded!");
		}

		return TransformationConfiguration.createInstanceFromSourcePaths(sourceFilePaths, pamtramModels,
				targetBasePath);
	}

	/**
	 * This constructs an instance based on a PAMTraM model that is already loaded.
	 * <p />
	 * Note: The instance is initialized with a default {@link BaseTransformationConfiguration}.
	 *
	 * @see #createInstanceFromSourceModels(List, List, String)
	 * @see #createInstanceFromSourcePaths(Set, List, String)
	 *
	 * @param sourceFilePaths
	 *            List of file paths of the source models. Each path must either be absolute or relative to the
	 *            workspace root (of the form '<em>/project-name/path</em>').
	 * @param pamtramModels
	 *            The transformation model
	 * @param targetBasePath
	 *            File path relative to that all target models will be created in the form 'project-name/path'.
	 * @return The created {@link TransformationConfiguration}.
	 * @throws InitializationException
	 *             If the initialization failed for some reason, e.g. because one of the models could not be loaded.
	 */
	public static TransformationConfiguration createInstanceFromSourcePaths(Set<String> sourceFilePaths,
			List<PAMTraM> pamtramModels, String targetBasePath) throws InitializationException {

		// Create a resource set to load the models.
		//
		ResourceSet resourceSet = new ResourceSetImpl();

		// Load the source models
		//
		List<EObject> sourceModels = null;

		try {
			sourceModels = TransformationConfiguration.loadSourceModels(resourceSet, sourceFilePaths);
		} catch (Exception e) {

			throw new TransformationConfiguration().new InitializationException(e);
		}

		if (sourceModels == null || sourceModels.isEmpty()) {
			throw new TransformationConfiguration().new InitializationException(
					"The loaded source model(s) was/were empty!");
		}

		return TransformationConfiguration.createInstanceFromSourceModels(sourceModels, pamtramModels, targetBasePath);
	}

	/**
	 * This constructs an instance based on source and PAMTraM models that are already loaded.
	 * <p />
	 * Note: The instance is initialized with a default {@link BaseTransformationConfiguration}.
	 *
	 * @see #createInstanceFromSourcePaths(Set, Set, String)
	 * @see #createInstanceFromSourcePaths(Set, List, String)
	 *
	 * @param sourceModels
	 *            The list of source models
	 * @param pamtramModels
	 *            The transformation model
	 * @param targetBasePath
	 *            File path relative to that all target models will be created in the form 'project-name/path'.
	 * @return The created {@link TransformationConfiguration}.
	 */
	public static TransformationConfiguration createInstanceFromSourceModels(List<EObject> sourceModels,
			List<PAMTraM> pamtramModels, String targetBasePath) {

		return new TransformationConfiguration(sourceModels, pamtramModels, targetBasePath,
				new BaseTransformationConfiguration());

	}

	/**
	 * Check if all parameters have been initialized with meaningful values.
	 *
	 * @return '<em><b>true</b></em>' if all parameters have been initialized with meaningful values;
	 *         '<em><b>false</b></em>' otherwise.
	 */
	@Override
	public boolean validate() {

		if (!super.validate()) {
			return false;
		}

		if (sourceModels == null || sourceModels.isEmpty()) {
			return false;
		}

		if (pamtramModels == null || pamtramModels.isEmpty()) {
			return false;
		}

		if (targetBasePath == null || targetBasePath.isEmpty()) {
			return false;
		}

		return true;
	}

	@Override
	public TransformationConfiguration withOpenTargetModelOnCompletion(boolean openTargetModelOnCompletion) {

		super.withOpenTargetModelOnCompletion(openTargetModelOnCompletion);
		return this;
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
	public TransformationConfiguration withMaxPathLength(Length maxPathLength) {

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

		return sourceModels;
	}

	/**
	 * The getter for the {@link #pamtramModels}.
	 *
	 * @return the pamtramModel
	 */
	public List<PAMTraM> getPamtramModels() {

		return pamtramModels;
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
	 * Print a summary of the used configuration.
	 */
	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("- Source Model(s): ");
		builder.append("\n\t" + sourceModels.stream().map(m -> m.eResource().getURI().toString())
				.collect(Collectors.joining("\n\t")));
		builder.append("\n- PAMTraM Model(s): ");
		builder.append("\n\t" + pamtramModels.stream().map(m -> m.eResource().getURI().toString())
				.collect(Collectors.joining("\n\t")));

		builder.append("\n" + super.toString());

		return builder.toString();
	}

	/**
	 * This loads the source models from XMI or XML files.
	 *
	 * @param resourceSet
	 *            The resource set to be used to load the resource.
	 * @param sourceFilePaths
	 *            The list of paths pointing to the source models to load (absolute or relative in the form
	 *            'project-name/path').
	 * @return The loaded {@link EObject source models}.
	 */
	private static List<EObject> loadSourceModels(ResourceSet resourceSet, Set<String> sourceFilePaths) {

		List<EObject> sourceModels = new ArrayList<>();

		for (String sourceFilePath : sourceFilePaths) {

			// the URI of the source resource
			final URI sourceUri = ResourceHelper.getURIForPathString(sourceFilePath);
			final IFile sourceFile = ResourceHelper.getFileForURI(sourceUri);

			if (sourceFile == null) {
				throw new RuntimeException("Unable to load source model '" + sourceFilePath + "!");
			}

			// Manually register the (unkown) file extension
			//
			if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
					.containsKey(sourceFile.getFileExtension())) {

				if (sourceFile.getFileExtension().equals("xml")) {
					// the file should be an XML file
					//
					Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml",
							new GenericXMLResourceFactoryImpl());

				} else {
					// by default, we assume an XMI file
					//
					Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(sourceFile.getFileExtension(),
							new XMIResourceFactoryImpl());
				}
			}

			// try to load source model
			Resource sourceResource = resourceSet.getResource(sourceUri, true);

			if (!sourceResource.getContents().isEmpty()) {
				sourceModels.add(sourceResource.getContents().get(0));
			}

		}

		return sourceModels;
	}

	/**
	 * An {@link Exception} indicating that something went wrong while creating a new
	 * {@link TransformationConfiguration}.
	 *
	 * @author mfreund
	 */
	public class InitializationException extends Exception {

		/**
		 *
		 */
		private static final long serialVersionUID = 6490592189785361220L;

		/**
		 *
		 * @param cause
		 *
		 */
		public InitializationException(String cause) {

			super(cause);
		}

		/**
		 *
		 * @param throwable
		 */
		public InitializationException(Throwable throwable) {

			super(throwable);
		}

		/**
		 *
		 * @param cause
		 * @param throwable
		 */
		public InitializationException(String cause, Throwable throwable) {

			super(cause, throwable);
		}
	}
}
