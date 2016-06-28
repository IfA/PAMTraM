package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.progress.UIJob;

import de.mfreund.gentrans.transformation.resolving.ComposedAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.DefaultAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import pamtram.PAMTraM;
import pamtram.util.PamtramEPackageHelper;
import pamtram.util.PamtramEPackageHelper.EPackageCheck;

/**
 * This class provides a factory that can be used to create instances
 * of {@link GenericTransformationRunner} via the static <em>createInstanceFrom...</em>
 * methods.
 * <p />
 * The singleton instance of this factory can be accessed via the {@link #eINSTANCE} field.
 * 
 * @author mfreund
 */
public class GenericTransformationRunnerFactory {
	
	/**
	 * The singleton instance of the factory.
	 */
	public static final GenericTransformationRunnerFactory eINSTANCE = init();
	
	/**
	 * This constructs an instance. 
	 * 
	 * @see #createInstanceFromSourcePaths(List, PAMTraM, String, BaseTransformationConfiguration)
	 * @see #createInstanceFromSourceModels(List, PAMTraM, String, BaseTransformationConfiguration)
	 *
	 * @param sourceFilePaths
	 *            List of file paths of the source models. They need to be in the form
	 *            'project-name/path'.
	 * @param pamtramPath
	 *            Path to the {@link PAMTraM} model to be executed in the form 'project-name/path'.
	 * @param targetBasePath
	 *            File path relative to that all target models will be created in the form 'project-name/path'.
	 * @param baseConfiguration The {@link BaseTransformationConfiguration} specifying
	 * the optional parameters to be used for the transformation.
	 * @return An instance of {@link GenericTransformationRunner}.
	 */
	public GenericTransformationRunner createInstanceFromSourcePaths(
			List<String> sourceFilePaths,
			String pamtramPath,
			String targetBasePath, 
			BaseTransformationConfiguration baseConfiguration) {
		
		MessageConsoleStream consoleStream = initializeLogger();
		
		// Create a resource set to load the models.
		//
		ResourceSet resourceSet = new ResourceSetImpl();

		// Load the PAMTraM model
		//
		PAMTraM pamtramModel = loadPamtramModel(resourceSet, pamtramPath, consoleStream);
		
		if(pamtramModel == null) {
			return null;
		}
		
		// Load the source models
		//
		List<EObject> sourceModels = loadSourceModel(resourceSet, sourceFilePaths);
		
		// Create the TransformationConfiguration
		//
		TransformationConfiguration config = new TransformationConfiguration(
				sourceModels, pamtramModel, targetBasePath, consoleStream, baseConfiguration)
				.withAmbiguityResolvingStrategy(initializeAmbiguityResolvingStrategy(baseConfiguration.getAmbiguityResolvingStrategy()));
		
		// Create and return the Runner
		//
		return new GenericTransformationRunner(config);
		
	}

	/**
	 * This constructs an instance based on a PAMTraM model that is already loaded.
	 * 
	 * @see #createInstanceFromSourcePaths(List, String, String, BaseTransformationConfiguration)
	 * @see #createInstanceFromSourceModels(List, PAMTraM, String, BaseTransformationConfiguration)
	 *
	 * @param sourceFilePaths
	 *            List of file paths of the source models. They need to be in the form
	 *            'project-name/path'.
	 * @param pamtramModel
	 *            The transformation model
	 * @param targetBasePath
	 *            File path relative to that all target models will be created in the form 'project-name/path'.
	 * @param baseConfiguration The {@link BaseTransformationConfiguration} specifying
	 * the optional parameters to be used for the transformation.
	 * @return An instance of {@link GenericTransformationRunner}.
	 */
	public GenericTransformationRunner createInstanceFromSourcePaths(
			List<String> sourceFilePaths,
			PAMTraM pamtramModel, 
			String targetBasePath, 
			BaseTransformationConfiguration baseConfiguration) {
		
		MessageConsoleStream consoleStream = initializeLogger();
		
		// Create a resource set to load the models.
		//
		ResourceSet resourceSet = new ResourceSetImpl();

		// Load the source models
		//
		List<EObject> sourceModels = loadSourceModel(resourceSet, sourceFilePaths);
		
		// Create the TransformationConfiguration
		//
		TransformationConfiguration config = new TransformationConfiguration(
				sourceModels, pamtramModel, targetBasePath, consoleStream, baseConfiguration)
				.withAmbiguityResolvingStrategy(initializeAmbiguityResolvingStrategy(baseConfiguration.getAmbiguityResolvingStrategy()));
	
		// Create and return the Runner
		//
		return new GenericTransformationRunner(config);
	}

	/**
	 * This constructs an instance based on source and PAMTraM models
	 * that are already loaded.
	 * 
	 * @see #createInstanceFromSourcePaths(List, String, String, BaseTransformationConfiguration)
	 * @see #createInstanceFromSourcePaths(List, PAMTraM, String, BaseTransformationConfiguration)
	 *
	 * @param sourceModels
	 *            The list of source models
	 * @param pamtramModel
	 *            The transformation model
	 * @param targetBasePath
	 *            File path relative to that all target models will be created in the form 'project-name/path'.
	 * @param baseConfiguration The {@link BaseTransformationConfiguration} specifying
	 * the optional parameters to be used for the transformation.
	 * @return An instance of {@link GenericTransformationRunner}.
	 */
	public GenericTransformationRunner createInstanceFromSourceModels(
			List<EObject> sourceModels,
			PAMTraM pamtramModel, 
			String targetBasePath, 
			BaseTransformationConfiguration baseConfiguration) {
		
		MessageConsoleStream consoleStream = initializeLogger();
		
		// Create the TransformationConfiguration
		//
		TransformationConfiguration config = new TransformationConfiguration(
				sourceModels, pamtramModel, targetBasePath, consoleStream, baseConfiguration)
				.withAmbiguityResolvingStrategy(initializeAmbiguityResolvingStrategy(baseConfiguration.getAmbiguityResolvingStrategy()));
	
		// Create and return the Runner
		//
		return new GenericTransformationRunner(config);
	}
	
	private static GenericTransformationRunnerFactory init() {
		return new GenericTransformationRunnerFactory();
	}

	private MessageConsoleStream initializeLogger() {

		MessageConsoleStream consoleStream = findConsole("de.mfreund.gentrans.transformation_" + hashCode()).newMessageStream();
		// brings the console view to the front
		showConsole();
		
		return consoleStream;
	}
	
	/**
	 * This initializes the {@link IAmbiguityResolvingStrategy} to be used for the transformation.
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
	private IAmbiguityResolvingStrategy initializeAmbiguityResolvingStrategy(final IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {
		
		IAmbiguityResolvingStrategy ret;

		if(ambiguityResolvingStrategy == null) {

			ret = new DefaultAmbiguityResolvingStrategy();

		} else if(ambiguityResolvingStrategy instanceof DefaultAmbiguityResolvingStrategy) {

			ret = ambiguityResolvingStrategy;

		} else if(ambiguityResolvingStrategy instanceof ComposedAmbiguityResolvingStrategy) {

			boolean containsDefaultStrategy = false;
			for (IAmbiguityResolvingStrategy strategy : ((ComposedAmbiguityResolvingStrategy) ambiguityResolvingStrategy).getComposedStrategies()) {
				if(strategy instanceof DefaultAmbiguityResolvingStrategy) {
					containsDefaultStrategy = true;
					break;
				}
			}
			
			if(!containsDefaultStrategy) {
				((ComposedAmbiguityResolvingStrategy) ambiguityResolvingStrategy).addStrategy(new DefaultAmbiguityResolvingStrategy());
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
	 * This loads the {@link PAMTraM} model from an XMI file. If necessary, additional {@link EPackage EPackages} that are
	 * referenced in the model are registered so that no errors occur during the transformation.
	 * 
	 * @param rs The resource set to be used to load the resource.
	 * @param pamtramPath The path of the {@link PAMTraM} model to load in the form 'project-name/path'.
	 * @param consoleStream The {@link MessageConsoleStream} that shall be used to print message during loading.
	 * @return The loaded {@link PAMTraM} model; '<em><b>null</b></em>' if the model could not be loaded.
	 */
	private PAMTraM loadPamtramModel(ResourceSet rs, String pamtramPath, MessageConsoleStream consoleStream) {
	
		ResourceSet resourceSet = rs;
		PAMTraM pamtramModel;
	
		// the URI of the pamtram resource
		final URI pamtramUri = URI.createPlatformResourceURI(pamtramPath, true);
	
		// load the pamtram model
		XMIResource pamtramResource = 
				(XMIResource) resourceSet.getResource(pamtramUri, true);
		if(!(pamtramResource.getContents().get(0) instanceof PAMTraM)) {
			consoleStream.println("The pamtram file does not seem to contain a pamtram instance. Aborting...");
			return null;
		}
		pamtramModel = (PAMTraM) pamtramResource.getContents()
				.get(0);
	
		// try to register the ePackages involved in the pamtram model (if not already done)
		EPackageCheck result = PamtramEPackageHelper.checkInvolvedEPackages(
				pamtramModel,
				ResourcesPlugin.getWorkspace().getRoot().findMember(pamtramPath).getProject(),
				EPackage.Registry.INSTANCE);
		switch (result) {
		case ERROR_PACKAGE_NOT_FOUND:
			consoleStream.println("One or more EPackages are not loaded correctly. Aborting...");
			return null;
		case ERROR_METAMODEL_FOLDER_NOT_FOUND:
		case ERROR_PAMTRAM_NOT_FOUND:
			consoleStream.println("Internal error during EPackage check. Aborting...");
			return null;
		case OK_PACKAGES_REGISTERED:
			// if packages have been registered, a new resource set has to be created; otherwise,
			// proxy resolving does not seem to work correctly
			resourceSet = new ResourceSetImpl();
			pamtramResource = (XMIResource) resourceSet.getResource(pamtramUri,
					true);
			pamtramModel = (PAMTraM) pamtramResource.getContents().get(0);
			break;
		case OK_NOTHING_REGISTERED:
		default:
			break;
		}
	
		return pamtramModel;
	}

	/**
	 * This loads the source models from XMI or XML files.
	 * 
	 * @param resourceSet The resource set to be used to load the resource.
	 * @param sourceFilePaths The list of paths pointing to the source models to load (in
	 * the form 'project-name/path').
	 * @return The loaded {@link EObject source models}. 
	 */
	private List<EObject> loadSourceModel(ResourceSet resourceSet, List<String> sourceFilePaths) {
	
		List<EObject> sourceModels = new ArrayList<>();
		
		for (String sourceFilePath : sourceFilePaths) {
	
			// the URI of the source resource
			final URI sourceUri = URI.createPlatformResourceURI(sourceFilePath, true);
	
			if(sourceFilePath.endsWith(".xml")) {
				// add file extension to registry
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
						"xml", new GenericXMLResourceFactoryImpl());
			}
	
			// try to load source model
			Resource sourceResource = 
					resourceSet.getResource(sourceUri, true);
	
			sourceModels.add(sourceResource.getContents().get(0));
	
		}
		
		return sourceModels;
	}

	/**
	 * Find an existing output console for the transformation or create a new one. 
	 * Copied from: @see <a href="http://wiki.eclipse.org/FAQ_How_do_I_write_to_the_console_from_a_plug-in%3F"
	 * >Eclipse FAQ</a>
	 *
	 * @param consoleName The name of the console to be returned.
	 * @return A {@link MessageConsole} object with the given '<em>consoleName</em>'. 
	 */
	private MessageConsole findConsole(final String consoleName) {
		
		final ConsolePlugin plugin = ConsolePlugin.getDefault();
		final IConsoleManager conMan = plugin.getConsoleManager();
		final IConsole[] existing = conMan.getConsoles();
		for (final IConsole element : existing) {
			if (consoleName.equals(element.getName())) {
				return (MessageConsole) element;
			}
		}
		// no console found, so create a new one
		final MessageConsole myConsole = new MessageConsole(consoleName, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}

	/**
	 * Brings the console view to the foreground. If the view is closed, it will
	 * be opened.
	 */
	private void showConsole() {
		// as the transformation runs in a non-UI thread, we have to use
		// a UIJob to find the console viw
		final UIJob job = new UIJob("Show Console View") {
			@Override
			public IStatus runInUIThread(final IProgressMonitor monitor) {
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage()
					.showView("org.eclipse.ui.console.ConsoleView");
				} catch (final PartInitException e) {
					e.printStackTrace();
					return Status.CANCEL_STATUS;
				}
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}
	
}
