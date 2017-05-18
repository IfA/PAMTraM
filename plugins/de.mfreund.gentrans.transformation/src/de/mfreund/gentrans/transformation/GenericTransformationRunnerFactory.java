package de.mfreund.gentrans.transformation;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;

import de.mfreund.gentrans.transformation.logging.GenTransConsole;
import de.mfreund.gentrans.transformation.resolving.ComposedAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.DefaultAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import pamtram.PAMTraM;
import pamtram.util.PamtramModelUtil;
import pamtram.util.PamtramModelUtil.ModelLoadException;

/**
 * This class provides a factory that can be used to create instances of
 * {@link GenericTransformationRunner} via the static
 * <em>createInstanceFrom...</em> methods.
 * <p />
 * The singleton instance of this factory can be accessed via the
 * {@link #eINSTANCE} field.
 *
 * @author mfreund
 */
public class GenericTransformationRunnerFactory {

	/**
	 * The singleton instance of the factory.
	 */
	public static final GenericTransformationRunnerFactory eINSTANCE = GenericTransformationRunnerFactory.init();

	/**
	 * This constructs an instance.
	 *
	 * @see #createInstanceFromSourcePaths(Set, List, String,
	 *      BaseTransformationConfiguration)
	 * @see #createInstanceFromSourceModels(List, List, String,
	 *      BaseTransformationConfiguration)
	 *
	 * @param sourceFilePaths
	 *            List of file paths of the source models. They need to be in
	 *            the form 'project-name/path'.
	 * @param pamtramPaths
	 *            Paths to the {@link PAMTraM} models to be executed in the form
	 *            'project-name/path'.
	 * @param targetBasePath
	 *            File path relative to that all target models will be created
	 *            in the form 'project-name/path'.
	 * @param baseConfiguration
	 *            The {@link BaseTransformationConfiguration} specifying the
	 *            optional parameters to be used for the transformation.
	 * @return An instance of {@link GenericTransformationRunner}.
	 */
	public GenericTransformationRunner createInstanceFromSourcePaths(Set<String> sourceFilePaths,
			Set<String> pamtramPaths, String targetBasePath, BaseTransformationConfiguration baseConfiguration) {

		Logger logger = this.initializeLogger(baseConfiguration.getLogLevel());

		// Create a resource set to load the models.
		//
		ResourceSet resourceSet = new ResourceSetImpl();

		// Load the PAMTraM model
		//
		List<PAMTraM> pamtramModels = null;
		try {
			pamtramModels = PamtramModelUtil.loadPamtramModels(resourceSet, pamtramPaths, true);
		} catch (ModelLoadException e) {
			logger.severe(e::getMessage);
			pamtramModels = null;
		}

		if (pamtramModels == null || pamtramModels.isEmpty()) {
			return null;
		}

		// Load the source models
		//
		List<EObject> sourceModels = this.loadSourceModels(resourceSet, sourceFilePaths);

		// Create the TransformationConfiguration
		//
		TransformationConfiguration config = new TransformationConfiguration(sourceModels, pamtramModels,
				targetBasePath, logger, baseConfiguration).withAmbiguityResolvingStrategy(
						this.initializeAmbiguityResolvingStrategy(baseConfiguration.getAmbiguityResolvingStrategy()));

		// Create and return the Runner
		//
		return new GenericTransformationRunner(config);

	}

	/**
	 * This constructs an instance based on a PAMTraM model that is already
	 * loaded.
	 *
	 * @see #createInstanceFromSourcePaths(Set, Set, String,
	 *      BaseTransformationConfiguration)
	 * @see #createInstanceFromSourceModels(List, List, String,
	 *      BaseTransformationConfiguration)
	 *
	 * @param sourceFilePaths
	 *            List of file paths of the source models. They need to be in
	 *            the form 'project-name/path'.
	 * @param pamtramModels
	 *            The pamtram models
	 * @param targetBasePath
	 *            File path relative to that all target models will be created
	 *            in the form 'project-name/path'.
	 * @param baseConfiguration
	 *            The {@link BaseTransformationConfiguration} specifying the
	 *            optional parameters to be used for the transformation.
	 * @return An instance of {@link GenericTransformationRunner}.
	 */
	public GenericTransformationRunner createInstanceFromSourcePaths(Set<String> sourceFilePaths,
			List<PAMTraM> pamtramModels, String targetBasePath, BaseTransformationConfiguration baseConfiguration) {

		Logger logger = this.initializeLogger(baseConfiguration.getLogLevel());

		// Create a resource set to load the models.
		//
		ResourceSet resourceSet = new ResourceSetImpl();

		// Load the source models
		//
		List<EObject> sourceModels = this.loadSourceModels(resourceSet, sourceFilePaths);

		// Create the TransformationConfiguration
		//
		TransformationConfiguration config = new TransformationConfiguration(sourceModels, pamtramModels,
				targetBasePath, logger, baseConfiguration).withAmbiguityResolvingStrategy(
						this.initializeAmbiguityResolvingStrategy(baseConfiguration.getAmbiguityResolvingStrategy()));

		// Create and return the Runner
		//
		return new GenericTransformationRunner(config);
	}

	/**
	 * This constructs an instance based on source and PAMTraM models that are
	 * already loaded.
	 *
	 * @see #createInstanceFromSourcePaths(Set, Set, String,
	 *      BaseTransformationConfiguration)
	 * @see #createInstanceFromSourcePaths(Set, List, String,
	 *      BaseTransformationConfiguration)
	 *
	 * @param sourceModels
	 *            The list of source models
	 * @param pamtramModels
	 *            The transformation model
	 * @param targetBasePath
	 *            File path relative to that all target models will be created
	 *            in the form 'project-name/path'.
	 * @param baseConfiguration
	 *            The {@link BaseTransformationConfiguration} specifying the
	 *            optional parameters to be used for the transformation.
	 * @return An instance of {@link GenericTransformationRunner}.
	 */
	public GenericTransformationRunner createInstanceFromSourceModels(List<EObject> sourceModels,
			List<PAMTraM> pamtramModels, String targetBasePath, BaseTransformationConfiguration baseConfiguration) {

		Logger logger = this.initializeLogger(baseConfiguration.getLogLevel());

		// Create the TransformationConfiguration
		//
		TransformationConfiguration config = new TransformationConfiguration(sourceModels, pamtramModels,
				targetBasePath, logger, baseConfiguration).withAmbiguityResolvingStrategy(
						this.initializeAmbiguityResolvingStrategy(baseConfiguration.getAmbiguityResolvingStrategy()));

		// Create and return the Runner
		//
		return new GenericTransformationRunner(config);
	}

	/**
	 * Used to initialize the single {@link #eINSTANCE} of this factory.
	 *
	 * @return A created instance of this factory.
	 */
	private static GenericTransformationRunnerFactory init() {

		return new GenericTransformationRunnerFactory();
	}

	/**
	 * This creates the {@link Logger} that will be used across the
	 * transformation to print messages to the user as well as the
	 * {@link GenTransConsole} that will display these messages in the console
	 * view.
	 *
	 * @param level
	 *            The minimum Level a logged messages must represent to be
	 *            printed to the user.
	 * @return The created {@link Logger} that shall be used to print messages
	 *         to the user.
	 */
	private Logger initializeLogger(Level level) {

		// Create the logger
		//
		Logger logger = Logger
				.getLogger("de.mfreund.gentrans.transformation " + DateFormat.getDateTimeInstance().format(new Date()));
		logger.setLevel(Level.ALL);

		// Do not log messages to the console of the development platform
		//
		logger.setUseParentHandlers(false);

		// Create the Console that will display the messages printed to the
		// logger
		//
		new GenTransConsole(logger, level);

		return logger;
	}

	/**
	 * This initializes the {@link IAmbiguityResolvingStrategy} to be used for
	 * the transformation.
	 * <p />
	 * Based on the given <em>ambiguityResolvingStrategy</em>, the resulting
	 * strategy is created so that an instance of the
	 * {@link DefaultAmbiguityResolvingStrategy} is included in the strategy --
	 * if necessary, a {@link ComposedAmbiguityResolvingStrategy} is created for
	 * this.
	 *
	 * @param ambiguityResolvingStrategy
	 *            The {@link IAmbiguityResolvingStrategy} based on that the
	 *            {@link #ambiguityResolvingStrategy} shall be initialized. If
	 *            this is '<em>null</em>', the strategy will be initialized with
	 *            an instance of {@link DefaultAmbiguityResolvingStrategy}.
	 * @return The resulting {@link IAmbiguityResolvingStrategy}.
	 */
	private IAmbiguityResolvingStrategy initializeAmbiguityResolvingStrategy(
			final IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {

		IAmbiguityResolvingStrategy ret;

		if (ambiguityResolvingStrategy == null) {

			ret = new DefaultAmbiguityResolvingStrategy();

		} else if (ambiguityResolvingStrategy instanceof DefaultAmbiguityResolvingStrategy) {

			ret = ambiguityResolvingStrategy;

		} else if (ambiguityResolvingStrategy instanceof ComposedAmbiguityResolvingStrategy) {

			boolean containsDefaultStrategy = false;
			for (IAmbiguityResolvingStrategy strategy : ((ComposedAmbiguityResolvingStrategy) ambiguityResolvingStrategy)
					.getComposedStrategies()) {
				if (strategy instanceof DefaultAmbiguityResolvingStrategy) {
					containsDefaultStrategy = true;
					break;
				}
			}

			if (!containsDefaultStrategy) {
				((ComposedAmbiguityResolvingStrategy) ambiguityResolvingStrategy)
						.addStrategy(new DefaultAmbiguityResolvingStrategy());
			}

			ret = ambiguityResolvingStrategy;

		} else {

			ArrayList<IAmbiguityResolvingStrategy> composed = new ArrayList<>();
			composed.add(ambiguityResolvingStrategy);
			composed.add(new DefaultAmbiguityResolvingStrategy());
			ret = new ComposedAmbiguityResolvingStrategy(composed);

		}

		return ret;
	}

	/**
	 * This loads the source models from XMI or XML files.
	 *
	 * @param resourceSet
	 *            The resource set to be used to load the resource.
	 * @param sourceFilePaths
	 *            The list of paths pointing to the source models to load (in
	 *            the form 'project-name/path').
	 * @return The loaded {@link EObject source models}.
	 */
	private List<EObject> loadSourceModels(ResourceSet resourceSet, Set<String> sourceFilePaths) {

		List<EObject> sourceModels = new ArrayList<>();

		for (String sourceFilePath : sourceFilePaths) {

			// the URI of the source resource
			final URI sourceUri = URI.createPlatformResourceURI(sourceFilePath, true);

			if (sourceFilePath.endsWith(".xml")) {
				// add file extension to registry
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml",
						new GenericXMLResourceFactoryImpl());
			}

			// try to load source model
			Resource sourceResource = resourceSet.getResource(sourceUri, true);

			sourceModels.add(sourceResource.getContents().get(0));

		}

		return sourceModels;
	}

}
