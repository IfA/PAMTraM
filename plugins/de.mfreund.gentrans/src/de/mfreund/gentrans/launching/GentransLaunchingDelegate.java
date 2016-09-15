package de.mfreund.gentrans.launching;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.osgi.framework.Bundle;

import de.mfreund.gentrans.transformation.handler.GenericTransformationJob;
import de.mfreund.gentrans.transformation.resolving.ComposedAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.DefaultAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.history.HistoryResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.statistics.StatisticsResolvingStrategy;
import de.tud.et.ifa.agtele.genlibrary.LibraryContextDescriptor;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPathParser;
import de.tud.et.ifa.agtele.ui.listeners.ProjectRefreshingJobDoneListener;

public class GentransLaunchingDelegate implements ILaunchConfigurationDelegate {

	/**
	 * The file extension for stored transformations includint the '.' before the actual extension.
	 */
	private static final String TRANSFORMATION_FILE_EXTENSION = ".transformation";

	/**
	 * The name of the folder where the executed transformations are stored.
	 */
	private static final String TRANSFORMATION_FOLDER_NAME = "transformation";

	/**
	 * The name of the folder where the target models are stored.
	 */
	private static final String TARGET_FOLDER_NAME = "Target";

	/**
	 * The name of the folder where the source models are stored.
	 */
	private static final String SOURCE_FOLDER_NAME = "Source";

	/**
	 * The name of the folder where the pamtram models are stored.
	 */
	private static final String PAMTRAM_FOLDER_NAME = "Pamtram";

	/**
	 * This keeps track of the class that is to be used as target library context.
	 */
	private Class<?> targetLibContextClass;

	/**
	 * This keeps track of the class that is to be used as target library parser.
	 */
	private Class<?> targetLibParserClass;

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {

		// Validate the launch configuration. If this fails, a CoreException will be thrown
		// and the launch is canceled.
		//
		this.validateLaunchConfig(configuration);

		// get the associated files from the launch configuration
		//
		final String project = configuration.getAttribute("project", "");
		ArrayList<String> sourceFiles = new ArrayList<>();
		for (String sourceFile : configuration.getAttribute("srcFiles", new ArrayList<>())) {
			sourceFiles.add(project + IPath.SEPARATOR +
					GentransLaunchingDelegate.SOURCE_FOLDER_NAME + IPath.SEPARATOR + sourceFile);
		}
		String pamtramFile = project + IPath.SEPARATOR +
				GentransLaunchingDelegate.PAMTRAM_FOLDER_NAME + IPath.SEPARATOR + configuration.getAttribute("pamtramFile", "");
		String targetBasePath = project + IPath.SEPARATOR + GentransLaunchingDelegate.TARGET_FOLDER_NAME;
		String defaultTargetModel = configuration.getAttribute("targetFile", "out.xmi");

		// determine the name of the transformation file from the current date
		//
		String transformationFile = null;
		if(configuration.getAttribute("storeTransformation", false)) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String currentDate = df.format(Calendar.getInstance().getTime());
			transformationFile = project + IPath.SEPARATOR + GentransLaunchingDelegate.PAMTRAM_FOLDER_NAME + IPath.SEPARATOR + GentransLaunchingDelegate.TRANSFORMATION_FOLDER_NAME + IPath.SEPARATOR +
					currentDate + IPath.SEPARATOR + currentDate + GentransLaunchingDelegate.TRANSFORMATION_FILE_EXTENSION ;
		}

		//get the settings
		//
		int maxPathLength=configuration.getAttribute("maxPathLength", -1);
		boolean rememberAmbiguousMappingChoice=configuration.getAttribute("rememberAmbiguousMappingChoice", true);
		Level logLevel = Level.ALL;
		try {
			String level = configuration.getAttribute("logLevel", "SEVERE");
			logLevel = Level.parse(level);
		} catch (Exception e) {
			Logger.getLogger(GentransLaunchingDelegate.class.getName()).log(Level.SEVERE, e.getMessage(), e);
		}

		// if at least one xml source file shall be transformed,
		// add the file extension to registry
		//
		for (String sourceFile : sourceFiles) {
			if(sourceFile.endsWith(".xml")) {
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
				.put("xml", new GenericXMLResourceFactoryImpl());
				break;
			}

		}

		@SuppressWarnings("unchecked") // should not fail due to validation in 'validateLaunchConfig(...)'
		LibraryContextDescriptor targetLibraryContextDescriptor =
		new LibraryContextDescriptor(configuration.getAttribute("targetLibPath", ""), (Class<LibraryContext>) this.targetLibContextClass, (Class<LibraryPathParser>) this.targetLibParserClass);

		// Initialize the strategy that shall be used to resolve ambiguities base on the given launch configuration.
		//
		IAmbiguityResolvingStrategy resolvingStrategy = this.initializeAmbiguityResolvingStrategy(configuration, project);

		// Create and run the transformation job
		//
		GenericTransformationJob job = new GenericTransformationJob(
				"GenTrans",
				sourceFiles,
				pamtramFile,
				targetBasePath,
				defaultTargetModel,
				transformationFile,
				targetLibraryContextDescriptor,
				resolvingStrategy,
				maxPathLength,
				rememberAmbiguousMappingChoice, logLevel);

		job.setUser(true);
		job.schedule();

		job.addJobChangeListener(new ProjectRefreshingJobDoneListener(project));

	}

	/**
	 * This creates and returns a custom {@link IAmbiguityResolvingStrategy} based on the given '<em>configuration</em>'.
	 *
	 * @param configuration The {@link ILaunchConfiguration} that shall be used to initialize the launch configuration.
	 * @param project The name of the current pamtram project that shall be launched.
	 * @return The {@link IAmbiguityResolvingStrategy} that shall be used for this launch.
	 * @throws CoreException If required attributes can not be determined from the given launch configuration.
	 */
	private IAmbiguityResolvingStrategy initializeAmbiguityResolvingStrategy(ILaunchConfiguration configuration,
			final String project) throws CoreException {

		IAmbiguityResolvingStrategy resolvingStrategy;

		String transformationModelPath = null;
		if(configuration.getAttribute("enableHistory", false)) {

			IFolder transformationFolder =
					ResourcesPlugin.getWorkspace().getRoot().getProject(project).getFolder(GentransLaunchingDelegate.PAMTRAM_FOLDER_NAME).getFolder(GentransLaunchingDelegate.TRANSFORMATION_FOLDER_NAME);
			// try to determine the location of the last stored transformation model
			if(transformationFolder.exists() && transformationFolder.members().length > 0) {
				String transformationName = configuration.getAttribute("transformationModel", "");
				if(transformationName.isEmpty()) {
					transformationName = transformationFolder.members()[transformationFolder.members().length-1].getName();
				}
				if(transformationFolder.getFolder(transformationName).getFile(transformationName + GentransLaunchingDelegate.TRANSFORMATION_FILE_EXTENSION).exists()) {
					transformationModelPath = project + IPath.SEPARATOR + GentransLaunchingDelegate.PAMTRAM_FOLDER_NAME + IPath.SEPARATOR + GentransLaunchingDelegate.TRANSFORMATION_FOLDER_NAME +
							IPath.SEPARATOR + transformationName + IPath.SEPARATOR + transformationName + GentransLaunchingDelegate.TRANSFORMATION_FILE_EXTENSION ;
				}
			}

		}

		ArrayList<IAmbiguityResolvingStrategy> strategies = new ArrayList<>();

		if(configuration.getAttribute("enableStatistics", false)) {
			StatisticsResolvingStrategy statisticsStrategy = new StatisticsResolvingStrategy();
			statisticsStrategy.setWeightingFactor(configuration.getAttribute("weightingFactor", 50) / 100d);
			strategies.add(statisticsStrategy);
		}


		if(configuration.getAttribute("enableUser", false)) {

			UserDecisionResolvingStrategy userStrategy = new UserDecisionResolvingStrategy();
			if(configuration.getAttribute("handleExpanding", false)) {
				userStrategy.setSkipExpandingAmbiguities(false);
			}
			strategies.add(userStrategy);
		}

		if(strategies.isEmpty()) {

			resolvingStrategy = transformationModelPath == null ?
					new DefaultAmbiguityResolvingStrategy()
					: new HistoryResolvingStrategy(
							new ArrayList<>(Arrays.asList(new DefaultAmbiguityResolvingStrategy())),
							transformationModelPath);
		} else if (strategies.size() == 1) {
			resolvingStrategy = transformationModelPath == null ? strategies.get(0)
					: new HistoryResolvingStrategy(new ArrayList<>(Arrays.asList(strategies.get(0))),
							transformationModelPath);
		} else {
			resolvingStrategy = transformationModelPath == null ?
					new ComposedAmbiguityResolvingStrategy(strategies)
					: new HistoryResolvingStrategy(strategies, transformationModelPath);
		}

		return resolvingStrategy;
	}

	/**
	 * Validates a launch configuration by checking if all attributes
	 * have meaningful values.
	 *
	 * @param configuration the launch configuration to validate
	 * @throws CoreException If the validation fails.
	 */
	private void validateLaunchConfig(ILaunchConfiguration configuration) throws CoreException {

		// Validate the settings in the 'Main' tab
		//
		this.validateMainTab(configuration);

		// Validate the settings in the 'Library' tab
		//
		this.validateLibraryTab(configuration);

	}

	/**
	 * Validate the settings of the given {@link ILaunchConfiguration launch configuration} that
	 * are represented on the '<em>Main Tab</em>'.
	 *
	 * @param configuration The {@link ILaunchConfiguration} to be validated.
	 * @throws CoreException If the validation fails.
	 */
	private void validateMainTab(ILaunchConfiguration configuration) throws CoreException {
		if(configuration.getAttribute("project", "").isEmpty()) {
			throw new GentransLaunchingDelegateValidationException("No project has been specified!");
		}

		if(configuration.getAttribute("srcFiles", new ArrayList<String>()).isEmpty()){
			throw new GentransLaunchingDelegateValidationException("No source file has been specified!");
		}

		if(configuration.getAttribute("pamtramFile", "").isEmpty()) {
			throw new GentransLaunchingDelegateValidationException("No pamtram file has been specified!");
		}

		if(configuration.getAttribute("targetFile", "").isEmpty()) {
			throw new GentransLaunchingDelegateValidationException("No target file has been specified!");
		}
	}

	/**
	 * Validate the settings of the given {@link ILaunchConfiguration launch configuration} that
	 * are represented on the '<em>Library Tab</em>'.
	 *
	 * @param configuration The {@link ILaunchConfiguration} to be validated.
	 * @throws CoreException If the validation fails.
	 */
	private void validateLibraryTab(ILaunchConfiguration configuration)
			throws CoreException {
		String targetLibPath = configuration.getAttribute("targetLibPath", "");
		if(targetLibPath.isEmpty()) {
			// do nothing as this is not necessary if no library entries are used
		} else if(!new File(targetLibPath).exists()) {
			throw new GentransLaunchingDelegateValidationException("Target library path does not exist!");
		} else if(!new File(targetLibPath).isDirectory()) {
			throw new GentransLaunchingDelegateValidationException("Target library path does not represent a folder!");
		}

		String targetLibBundle = configuration.getAttribute("targetLibBundle", "");
		Bundle bundle;
		this.targetLibContextClass = null;
		this.targetLibParserClass = null;
		if(!targetLibBundle.isEmpty()) {
			if((bundle = Platform.getBundle(targetLibBundle)) == null) {
				throw new GentransLaunchingDelegateValidationException("Bundle '" + targetLibBundle + "' cannot be resolved!" );
			}
			String targetLibContext = configuration.getAttribute("targetLibContext", "");
			if(targetLibContext.isEmpty()) {
				throw new GentransLaunchingDelegateValidationException("No target library context has been specified!");
			} else {
				try {
					this.targetLibContextClass = bundle.loadClass(targetLibContext);
				} catch (Exception e) {
					throw new GentransLaunchingDelegateValidationException("The target library context could not be resolved!", e);
				}
				try {
					this.targetLibContextClass.asSubclass(LibraryContext.class);
				} catch (ClassCastException e) {
					throw new GentransLaunchingDelegateValidationException("The target library context class is no sub-class of 'LibraryContext'!", e);
				}
			}
			String targetLibParser = configuration.getAttribute("targetLibParser", "");
			if(!targetLibParser.isEmpty()) {
				try {
					this.targetLibParserClass = bundle.loadClass(targetLibParser);
				} catch (Exception e) {
					throw new GentransLaunchingDelegateValidationException("The target library parser could not be resolved!", e);
				}
				try {
					this.targetLibParserClass.asSubclass(LibraryPathParser.class);
				} catch (ClassCastException e) {
					throw new GentransLaunchingDelegateValidationException("The target library parser class is no sub-class of 'LibraryPathParser'!", e);
				}
			}
		}
	}

	/**
	 * A {@link CoreException} of this type will be thrown to indicate problems during the validation of a
	 * gentrans {@link ILaunchConfiguration}.
	 *
	 * @author mfreund
	 */
	private class GentransLaunchingDelegateValidationException extends CoreException {

		/**
		 *
		 */
		private static final long serialVersionUID = -7164144847724395702L;

		/**
		 * The id of the gentrans plug-in that will be used in the creation of the
		 * {@link Status} object describing the status of the validation.
		 */
		private static final String ID = "de.mfreund.gentrans";

		/**
		 * This creates an instances.
		 *
		 * @param message The message that shall be displayed to the user.
		 */
		private GentransLaunchingDelegateValidationException(String message) {
			super(new Status(IStatus.ERROR, GentransLaunchingDelegateValidationException.ID, message));
		}

		/**
		 * This creates an instances that wraps another {@link Throwable}.
		 *
		 * @param message The message that shall be displayed to the user.
		 * @param cause The {@link Throwable} that caused this exception to be thrown.
		 */
		private GentransLaunchingDelegateValidationException(String message, Throwable cause) {
			super(new Status(IStatus.ERROR, GentransLaunchingDelegateValidationException.ID, message, cause));
		}

	}

}
