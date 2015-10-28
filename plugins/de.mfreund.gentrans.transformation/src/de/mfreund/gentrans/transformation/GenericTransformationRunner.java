package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.progress.UIJob;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.mfreund.gentrans.transformation.util.ICancellable;
import de.mfreund.gentrans.transformation.util.MonitorWrapper;
import de.tud.et.ifa.agtele.genlibrary.LibraryContextDescriptor;
import pamtram.PAMTraM;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.ExternalMappedAttributeValuePrepender;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.GlobalValue;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.MappedAttributeValuePrepender;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintBaseType;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.ModelConnectionHintSourceInterface;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionClass;
import pamtram.util.EPackageHelper;
import pamtram.util.EPackageHelper.EPackageCheck;

/**
 * Main Class for running the generic transformation for a PAMTraM model.
 *
 * @author Sascha Steffen, Matthias Freund
 * @version 1.0
 */
public class GenericTransformationRunner {

	/**
	 * This keeps track of objects that need to be canceled when the user requests an early termination of the transformation.
	 */
	private final List<ICancellable> objectsToCancel;

	/**
	 * File paths of the source models to be transformed
	 */
	private final ArrayList<String> sourceFilePaths;

	/**
	 * The source models to be transformed
	 */
	private ArrayList<EObject> sourceModels;

	/**
	 * File path to the transformation model
	 */
	private final String pamtramPath;

	/**
	 * The transformation model
	 */
	private PAMTraM pamtramModel;

	/**
	 * File path to the transformation target
	 */
	private final String targetFilePath;

	/**
	 * The target model resource where the result of the transformation shall be stored
	 */
	private XMIResource targetModel;

	/**
	 * A {@link MessageConsoleStream message output stream} (Console view) that can be used to print messages to the user
	 */
	private final MessageConsoleStream consoleStream;

	/**
	 * Maximum length for connection paths in the 'joining' step;
	 * If this is set to less than zero 0, it means that the maximum length is unbounded
	 */
	private int maxPathLength;

	/**
	 * This is the getter for the {@link #maxPathLength} setting.
	 * @return The maximum length for connection paths in the 'joining' step.
	 */
	public int getMaxPathLength() {
		return maxPathLength;
	}

	/**
	 * This is the setter for the {@link #maxPathLength} setting.
	 * @param maxPathLength The maximum length for connection paths in the 'joining' step (value must 
	 * be larger or equal to '-1').
	 */
	public void setMaxPathLength(final int maxPathLength) {
		this.maxPathLength = maxPathLength >= 0 ? maxPathLength : -1;
	}

	/**
	 * Determines whether the user should be asked every time an ambiguous
	 * mapping was detected, or if we should reuse user decisions
	 *
	 */
	//TODO this should probably be moved to the 'UserDecisionStrategy'
	private boolean onlyAskOnceOnAmbiguousMappings;

	/**
	 * This is the getter for the {@link #onlyAskOnceOnAmbiguousMappings} setting.
	 * @return '<em><b>true</b></em>' if the user should be asked every time an ambiguous mapping was detected,
	 * '<em><b>false</b></em>' otherwise.
	 */
	public boolean isOnlyAskOnceOnAmbiguousMappings() {
		return onlyAskOnceOnAmbiguousMappings;
	}

	/**
	 * This is the setter for the {@link #onlyAskOnceOnAmbiguousMappings} setting.
	 * @param onlyAskOnceOnAmbiguousMappings '<em><b>true</b></em>' if the user should be asked every time 
	 * an ambiguous mapping was detected, '<em><b>false</b></em>' otherwise.
	 */
	public void setOnlyAskOnceOnAmbiguousMappings(
			final boolean onlyAskOnceOnAmbiguousMappings) {
		this.onlyAskOnceOnAmbiguousMappings = onlyAskOnceOnAmbiguousMappings;
	}

	/**
	 * This keeps track of whether the user requested an early termination of the transformation
	 */
	private boolean isCancelled;

	/**
	 * This keeps track of the {@link LibraryContextDescriptor descriptor for the target library context} to 
	 * be used during the transformation.
	 */
	private LibraryContextDescriptor targetLibraryContextDescriptor;

	/**
	 * This is the {@link IAmbiguityResolvingStrategy} that shall be used to 
	 * resolve ambiguities that arise during the execution of the transformation.
	 */
	private IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

	/**
	 * This is the {@link TargetSectionInstantiator} that can be used to create new target sections.
	 */
	private TargetSectionInstantiator targetSectionInstantiator;

	/**
	 * This is the Getter for the {@link #targetSectionInstantiator}.
	 * @return The {@link #targetSectionInstantiator} used by the transformation runner.
	 */
	public TargetSectionInstantiator getTargetSectionInstantiator() {
		return targetSectionInstantiator;
	}

	/**
	 * This is the {@link TargetSectionConnector} that can be used to connect target sections that
	 * have been created with the help of the {@link #targetSectionInstantiator}.
	 */
	private TargetSectionConnector targetSectionConnector;

	/**
	 * This is the Getter for the {@link #targetSectionConnector}.
	 * @return The {@link #targetSectionConnector} used by the transformation runner.
	 */
	public TargetSectionConnector getTargetSectionConnector() {
		return targetSectionConnector;
	}

	/**
	 * Private constructor that is called from all other constructors.
	 * 
	 * @param sourceFilePaths
	 *            List of file paths of the source models
	 * @param pamtramPath
	 *            Path to the transformation model
	 * @param targetFilePath
	 *            File path to the transformation target
	 * @param maxPathLength
	 * 			  Maximum length of connection paths between target sections.
	 * @param onlyAskOnceOnAmbiguousMappings
	 * 			  Whether ambiguities shall only be resolved once or for every instance.
	 * @param targetLibraryContextDescriptor
	 * 			  The descriptor for the target library context to be used during the transformation.
	 * @param ambiguityResolvingStrategy The {@link IAmbiguityResolvingStrategy} that shall be used to 
	 * resolve ambiguities that arise during the execution of the transformation. If this is '<em>null</em>', the 
	 * {@link DefaultAmbiguityResolvingStrategy} will be used.
	 */
	private GenericTransformationRunner(
			final ArrayList<String> sourceFilePaths,
			final String pamtramPath, 
			final String targetFilePath, 
			int maxPathLength,
			boolean onlyAskOnceOnAmbiguousMappings, 
			LibraryContextDescriptor targetLibraryContextDescriptor,
			final IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {
		super();
		isCancelled = false;
		this.sourceModels = new ArrayList<>();
		this.sourceFilePaths = sourceFilePaths;
		this.pamtramPath = pamtramPath;
		this.targetFilePath = targetFilePath;
		this.maxPathLength = maxPathLength;
		this.onlyAskOnceOnAmbiguousMappings = onlyAskOnceOnAmbiguousMappings;
		this.targetLibraryContextDescriptor = targetLibraryContextDescriptor;

		/* 
		 * make sure that all ambiguities are resolved completely by requiring an instance of
		 * 'DefaultAmbiguityResolvingStrategy' to be participating in the resolving process
		 */
		if(ambiguityResolvingStrategy == null) {
			this.ambiguityResolvingStrategy = new DefaultAmbiguityResolvingStrategy();
		} else if(ambiguityResolvingStrategy instanceof DefaultAmbiguityResolvingStrategy) {
			this.ambiguityResolvingStrategy = ambiguityResolvingStrategy;
		} else {
			ArrayList<IAmbiguityResolvingStrategy> composed = new ArrayList<>();
			composed.add(ambiguityResolvingStrategy);
			composed.add(new DefaultAmbiguityResolvingStrategy());
			this.ambiguityResolvingStrategy = new ComposedAmbiguityResolvingStrategy(composed);
		}

		consoleStream = findConsole("de.mfreund.gentrans.transformation_" + hashCode()).newMessageStream();
		objectsToCancel = new LinkedList<>();
		// brings the console view to the front
		showConsole();
	}

	/**
	 * This constructs an instance. 
	 *
	 * @param sourceFilePaths
	 *            List of file paths of the source models
	 * @param pamtramPath
	 *            Path to the transformation model
	 * @param targetFilePath
	 *            File path to the transformation target
	 * @param targetLibraryContextDescriptor
	 * 			  The descriptor for the target library context to be used during the transformation.
	 * @param ambiguityResolvingStrategy The {@link IAmbiguityResolvingStrategy} that shall be used to 
	 * resolve ambiguities that arise during the execution of the transformation. If this is '<em>null</em>', the 
	 * {@link DefaultAmbiguityResolvingStrategy} will be used.
	 * @return An instance of {@link GenericTransformationRunner}.
	 */
	public static GenericTransformationRunner createInstanceFromSourcePaths(
			final ArrayList<String> sourceFilePaths,
			final String pamtramPath,
			final String targetFilePath, 
			LibraryContextDescriptor targetLibraryContextDescriptor,
			final IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {

		return new GenericTransformationRunner(sourceFilePaths, pamtramPath, targetFilePath, -1, true, targetLibraryContextDescriptor, ambiguityResolvingStrategy);
	}

	/**
	 * This constructs an instance.
	 *
	 * @param sourceFilePaths
	 *             List of file paths of the source models
	 * @param pamtramModel
	 *            The transformation model
	 * @param targetFilePath
	 *            File path to the transformation target
	 * @param targetLibraryContextDescriptor
	 * 			  The descriptor for the target library context to be used during the transformation.
	 * @param ambiguityResolvingStrategy The {@link IAmbiguityResolvingStrategy} that shall be used to 
	 * resolve ambiguities that arise during the execution of the transformation. If this is '<em>null</em>', the 
	 * {@link DefaultAmbiguityResolvingStrategy} will be used.
	 * @return An instance of {@link GenericTransformationRunner}.
	 */
	public static GenericTransformationRunner createInstanceFromSourcePaths(
			final ArrayList<String> sourceFilePaths,
			final PAMTraM pamtramModel, 
			final String targetFilePath, 
			LibraryContextDescriptor targetLibraryContextDescriptor,
			final IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {

		GenericTransformationRunner instance = 
				new GenericTransformationRunner(sourceFilePaths, null, targetFilePath, -1, true, targetLibraryContextDescriptor, ambiguityResolvingStrategy);
		instance.pamtramModel = pamtramModel;
		return instance;
	}

	/**
	 * This constructs an instance.
	 *
	 * @param sourceModels
	 *            The list of source models
	 * @param pamtramModel
	 *            The transformation model
	 * @param targetFilePath
	 *            File path to the transformation target
	 * @param targetLibraryContextDescriptor
	 * 			  The descriptor for the target library context to be used during the transformation.
	 * @param ambiguityResolvingStrategy The {@link IAmbiguityResolvingStrategy} that shall be used to 
	 * resolve ambiguities that arise during the execution of the transformation. If this is '<em>null</em>', the 
	 * {@link DefaultAmbiguityResolvingStrategy} will be used.
	 * @return An instance of {@link GenericTransformationRunner}.
	 */
	public static GenericTransformationRunner createInstanceFromSourceModels(
			final ArrayList<EObject> sourceModels,
			final PAMTraM pamtramModel, 
			final String targetFilePath, 
			LibraryContextDescriptor targetLibraryContextDescriptor,
			final IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {

		GenericTransformationRunner instance = 
				new GenericTransformationRunner(null, null, targetFilePath, -1, true, targetLibraryContextDescriptor, ambiguityResolvingStrategy);
		instance.pamtramModel = pamtramModel;
		instance.sourceModels = sourceModels;
		return instance;
	}

	/**
	 * This performs the actual generic transformation. It loads all necessary models, executes the mappings defined
	 * in the PAMTraM model and stores the generated target model. All progress is reported to the given '<em>monitor</em>'.
	 *
	 * @param monitor An {@link IProgressMonitor} that shall be used to display the progress of the transformation. If '<em>null</em>'
	 * is passed as argument, no monitor will be used.
	 */
	public void runTransformation(final IProgressMonitor monitor) {

		// create a wrapper for the monitor so that a 'null' argument does not lead to errors
		MonitorWrapper monitorWrapper = new MonitorWrapper(monitor);

		final long startTime = System.nanoTime();

		monitorWrapper.beginTask("GenTrans", 1000);

		// Create a resource set.
		ResourceSet resourceSet = new ResourceSetImpl();

		// load the mapping model
		if(pamtramModel == null && !loadPamtramModel(resourceSet)) {
			return;
		}

		// load the source model
		loadSourceModel(resourceSet);

		// create the target model
		if(!createTargetModel(resourceSet)) {
			return;
		}

		/* 
		 * before we can use the PAMTraM model, we need merge all extended HintGroups or Sections;
		 * that way, we get a 'clean' model (without any extensions) that we can handle in a normal way
		 */
		pamtramModel.mergeExtends();

		/*
		 * Save a copy of the merged pamtram model for debug purposes.
		 */
		//		
		//		// the URI of the pamtram resource
		//		final URI pamtramUri2 = URI.createPlatformResourceURI(pamtramPath + "_bak", true);
		//
		//		// load the pamtram model
		//		XMIResource pamtramResource = 
		//				(XMIResource) resourceSet.createResource(pamtramUri2);
		//		pamtramResource.getContents().add(pamtramModel);
		//		try {
		//			pamtramResource.save(null);
		//		} catch (IOException e1) {
		//			e1.printStackTrace();
		//		}


		// find active mappings and resolve ambiguities as far as possible without user
		// input
		final List<Mapping> suitableMappings = pamtramModel.getActiveMappings();
		// TODO apply contextModel

		boolean successful = false;
		try {
			/*
			 * try to execute all active mappings (this includes the 4 resp. 5 main steps of
			 * the transformation
			 */
			successful = executeMappings(targetModel, sourceModels, pamtramModel, suitableMappings,
					monitorWrapper); 			
		} catch (RuntimeException e) {
			consoleStream.println(e.getMessage());
			consoleStream.println("Aborting...");
			throw e;
		}

		if (successful && !isCancelled) {
			// save targetModel
			try {
				// try to save the xmi resource
				// xmiResource.save(Collections.EMPTY_MAP);
				final Map<Object, Object> options = new LinkedHashMap<>();
				options.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
				options.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
				targetModel.save(Collections.EMPTY_MAP);
				final long endTime = System.nanoTime();
				writePamtramMessage("Transformation done. Time: "
						+ Math.ceil((endTime - startTime) / 100000000L) / 10.0 + "s");
			} catch (final Exception e) {
				MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error",
						"The XMI resource could not be saved.");
				e.printStackTrace();
				return;
			}

		}

	}

	/**
	 * This cancels any running (or future) transformation.
	 */
	public void cancel() {
		isCancelled = true;
		for (final ICancellable l : objectsToCancel) {
			l.cancel();
		}
	}

	/**
	 * This performs the actual execution of the transformation. In the course of this method,
	 * the four main steps of the transformation get executed.
	 * 
	 * @param targetModel The {@link XMIResource target model resource} where the result of the transformation shall be stored
	 * @param sourceModels The list of {@link EObject source models} to be transformed.
	 * @param pamtramModel The {@link PAMTraM} instance that describes the transformation.
	 * @param suitableMappings A list of {@link Mapping Mappings} that may be used in the transformation. This needs to match
	 * those mappings defined in the given '<em>pamtramModel</em>' or be a subset of these mappings
	 * @param monitor The {@link IProgressMonitor monitor} that shall be used to visualize the progress of the transformation.
	 * @return '<em><b>true</b></em>' if the transformation was performed successfully, '<em><b>false</b></em>' otherwise
	 */
	private boolean executeMappings(final XMIResource targetModel, final ArrayList<EObject> sourceModels,
			final PAMTraM pamtramModel, final List<Mapping> suitableMappings,
			final IProgressMonitor monitor) {

		// generate storage objects and generators
		final AttributeValueModifierExecutor attributeValueModifier = new AttributeValueModifierExecutor(
				consoleStream);

		/*
		 * Perform the 'matching' step of the transformation
		 */
		MatchingResult matchingResult = performMatching(sourceModels, suitableMappings, attributeValueModifier, monitor);

		if(matchingResult.isCanceled()) {
			return false;
		}

		/*
		 * Perform the 'expanding' step of the transformation
		 */
		ExpandingResult expandingResult = performExpanding(
				matchingResult, pamtramModel.getGlobalValues(), monitor,
				attributeValueModifier);

		/*
		 * Perform the 'joining' step of the transformation
		 */
		boolean joiningResult = performJoining(targetModel, suitableMappings,
				expandingResult, attributeValueModifier, matchingResult, monitor); 

		if (!joiningResult) {
			return false;
		}

		/*
		 * Perform the 'linking' step of the transformation
		 */
		boolean linkingResult = performLinking(matchingResult,
				targetSectionInstantiator, monitor);

		if(!linkingResult) {
			return false;
		}

		/*
		 * Finally, instantiate the collected library entries in the target model. 
		 */
		if(targetModel.getContents().isEmpty()) {
			consoleStream.println("Something seems to be wrong! Target model is empty!");
			return false;
		} else {
			return performInstantiatingLibraryEntries(targetModel.getContents().get(0), monitor);
		}

	}

	/**
	 * This performs the '<em>matching</em>' step of the transformation. Therefore, it iterates through the
	 * given '<em>sourceModel</em>' and tries to apply the given '<em>suitableMappings</em>'. During this process,
	 * the hint values for the various {@link MappingHint MappingHints} are calculated as well. 
	 *  
	 * @param sourceModels The list of {@link EObject EObjects} representing/containing the source model to be matched. 
	 * @param suitableMappings A list of {@link Mapping Mappings} that shall be used for the matching process.
	 * @param attributeValueModifier An instance of {@link AttributeValueModifierExecutor} that shall be used to 
	 * apply {@link AttributeValueModifierSet AttributeValueModifierSets} in order to obtain hint values.
	 * @param monitor An {@link IProgressMonitor} that shall be used to report the progress of the transformation.
	 * @return A {@link MatchingResult} that contains the various results of the matching.
	 */
	private MatchingResult performMatching(
			ArrayList<EObject> sourceModels, 
			List<Mapping> suitableMappings, 
			AttributeValueModifierExecutor attributeValueModifier, 
			IProgressMonitor monitor) {

		LinkedList<MappingInstanceStorage> selectedMappings = new LinkedList<>();
		LinkedHashMap<Mapping, LinkedList<MappingInstanceStorage>> selectedMappingsByMapping = new LinkedHashMap<>();
		HintValueStorage exportedMappingHints;
		Map<GlobalAttribute, String> globalAttributeValues;

		/*
		 * Build the ContainmentTree representing the source model. This will keep track of all matched
		 * and unmatched elements.
		 */
		writePamtramMessage("Analyzing source model");
		monitor.subTask("Selecting Mappings for source model elements");
		final ContainmentTree containmentTree = ContainmentTree.build(sourceModels);

		/*
		 * Create the source section matcher that finds applicable mappings
		 */
		final SourceSectionMatcher sourceSectionMatcher = new SourceSectionMatcher(
				containmentTree, suitableMappings, onlyAskOnceOnAmbiguousMappings, attributeValueModifier, ambiguityResolvingStrategy, consoleStream);
		objectsToCancel.add(sourceSectionMatcher);

		/*
		 * Now start matching each of the elements in the containment tree. We automatically start
		 * at the root element.
		 */
		writePamtramMessage("Selecting Mappings for source model elements");

		final int numSrcModelElements = containmentTree.getNumberOfElements();
		final double workUnit = 250.0 / numSrcModelElements;
		double accumulatedWork = 0;

		/*
		 * When iterating through the containment tree, 'getNumberOfAvailableElements()' will decrease over the time
		 * until every element has either been matched or marked as 'unmatched'.
		 */
		while (containmentTree.getNumberOfAvailableElements() > 0 && !isCancelled) {

			final MappingInstanceStorage selectedMapping = 
					sourceSectionMatcher.findMappingForNextElement();

			if (sourceSectionMatcher.isCancelled()) {
				writePamtramMessage("Transformation aborted.");
				return MatchingResult.createMatchingCanceledResult();
			}

			// store the selected mapping
			if (selectedMapping != null) {
				selectedMappings.add(selectedMapping);
				if (!selectedMappingsByMapping.containsKey(selectedMapping.getMapping())) {
					selectedMappingsByMapping.put(selectedMapping.getMapping(),
							new LinkedList<MappingInstanceStorage>());
				}
				selectedMappingsByMapping.get(selectedMapping.getMapping()).add(selectedMapping);

			}

			// update the progress bar in the monitor
			accumulatedWork += workUnit
					* (containmentTree.getNumberOfAvailableElements());
			if (accumulatedWork >= 1) {
				monitor.worked((int) Math.floor(accumulatedWork));
				accumulatedWork -= Math.floor(accumulatedWork);
			}
		}

		if (isCancelled) {
			return MatchingResult.createMatchingCanceledResult();
		}

		consoleStream.println("Summary:\tAvailable Elements:\t" + containmentTree.getNumberOfElements());
		consoleStream.println("\t\tMatched Elements:\t" + containmentTree.getNumberOfMatchedElements());
		consoleStream.println("\t\tUnmatched Elements:\t" + containmentTree.getNumberOfUnmatchedElements());

		/*
		 * Now write MappingHint values of Hints of ExportedMappingHintGroups to
		 * a separate storage, and remove the values from the
		 * MappingInstanceStorages.
		 * 
		 * Also add values of GlobalVariables to ComplexAttributeMapping's Hints
		 */
		exportedMappingHints = handleGlobalVarsAndExportedMappings(
				sourceSectionMatcher, selectedMappings);
		globalAttributeValues =  sourceSectionMatcher.getGlobalAttributeValues();

		if (isCancelled) {
			return MatchingResult.createMatchingCanceledResult();
		}

		return MatchingResult.createMatchingCompletedResult(selectedMappings, selectedMappingsByMapping, exportedMappingHints, globalAttributeValues);

	}

	/**
	 * This performs the '<em>expanding</em>' step of the transformation:
	 * The target sections (excluding those that are defined by {@link LibraryEntry LibraryEntries})
	 * are instantiated (only containment references and attributes but no non-containment
	 * references).
	 *
	 * @param matchingResult A {@link MatchingResult} that contains the results from the 
	 * {@link #performMatching(EObject, List, AttributeValueModifierExecutor, IProgressMonitor) matching} step.
	 * @param globalValues The list of {@link GlobalValue GlobalValues} to use.
	 * @param monitor An {@link IProgressMonitor} that shall be used to report the progress of the transformation.
	 * @param attributeValuemodifier An instance of {@link AttributeValueModifierExecutor} to use for applying
	 * {@link AttributeValueModifierSet AttributeValueModifierSets}.
	 * @return An {@link ExpandingResult} that contains the various results of the expanding step.
	 */
	private ExpandingResult performExpanding(
			final MatchingResult matchingResult,
			final List<GlobalValue> globalValues,
			final IProgressMonitor monitor,
			final AttributeValueModifierExecutor attributeValuemodifier) {

		final AttributeValueRegistry attrValueRegistry = new AttributeValueRegistry();

		/*
		 * Instantiate TargetSectionRegistry, analyzes target-metamodel
		 */
		monitor.subTask("Instantiating targetModelSections for selected mappings. First pass");
		writePamtramMessage("Analyzing target metamodel");
		final TargetSectionRegistry targetSectionRegistry = new TargetSectionRegistry(
				consoleStream,
				attrValueRegistry, 
				/*TODO this only works if all target section models represent the same metamodel, 
				 * if we want to support different metamodels in the future, we need to change this
				 */
				pamtramModel.getTargetSectionModel().get(0).getMetaModelPackage());
		objectsToCancel.add(targetSectionRegistry);

		writePamtramMessage("Instantiating targetModelSections for selected mappings. First pass");

		/*
		 * Initialize the TargetSectionInstantiator
		 */
		targetSectionInstantiator = new TargetSectionInstantiator(
				targetSectionRegistry, attrValueRegistry,
				matchingResult.getGlobalAttributeValues(),
				attributeValuemodifier, globalValues, consoleStream, this, ambiguityResolvingStrategy);
		objectsToCancel.add(targetSectionInstantiator);

		/*
		 * Used to update the monitor.
		 */
		final double workUnit = 250.0 / matchingResult.getSelectedMappings().size();
		double accumulatedWork = 0;

		/*
		 * Iterate over all selected mappings
		 */
		for (final MappingInstanceStorage selMap : matchingResult.getSelectedMappings()) {

			/*
			 * Iterate over all mapping hint group (except inactive and empty ones)
			 */
			for (final MappingHintGroupType g : selMap.getMapping()
					.getActiveMappingHintGroups()) {
				if (g.getTargetMMSection() != null
						&& g instanceof MappingHintGroup) {

					/*
					 * Instantiate the target section.
					 */
					final LinkedHashMap<TargetSectionClass, LinkedList<EObjectWrapper>> instancesBySection = 
							targetSectionInstantiator.instantiateTargetSectionFirstPass(
									g.getTargetMMSection(),
									(MappingHintGroup) g, g.getMappingHints(),
									selMap.getHintValues(),
									selMap.getMapping().getName());

					if (instancesBySection == null) {
						if (g.getTargetMMSection().getCardinality() != CardinalityType.ZERO_INFINITY) {// Error
							consoleStream
							.println("Error instantiating target section '"
									+ g.getTargetMMSection().getName()
									+ "' using mapping rule '"
									+ selMap.getMapping().getName()
									+ "'");
						}
					} else {
						for (final TargetSectionClass section : instancesBySection
								.keySet()) {
							/*
							 * Store the created instance(s).
							 */
							selMap.addInstances((MappingHintGroup) g, section,
									instancesBySection.get(section));
						}
					}
				}

			}

			for (final MappingHintGroupImporter g : selMap.getMapping()
					.getActiveImportedMappingHintGroups()) {
				final ExportedMappingHintGroup expGrp = g.getHintGroup();
				if (expGrp != null) {

					// import Hints
					for (final MappingHint h : expGrp.getMappingHints()) {
						selMap.getHintValues().setHintValues(h, null);
						if (matchingResult.getExportedMappingHints().containsHint(h)) {
							selMap.getHintValues().addHintValues(h, matchingResult.getExportedMappingHints().getHintValues(h));
						}
					}

					// start instantiating
					if (expGrp.getTargetMMSection() != null) {

						final List<MappingHint> hints = new LinkedList<>();
						hints.addAll(expGrp.getMappingHints());
						for (final MappingHintType h : g.getMappingHints()) {
							if (h instanceof MappingHint) {
								hints.add((MappingHint) h);
							} else if (h instanceof MappedAttributeValueExpander) {
								if (selMap.getHintValues().getHintValues((MappedAttributeValueExpander) h).size() == 1) {
									final String hintVal = selMap.getHintValues().getHintValues((MappedAttributeValueExpander) h).getFirst();
									/*
									 * of course this works only because the
									 * only other option is the Appender
									 */
									final boolean prepend = h instanceof MappedAttributeValuePrepender
											|| h instanceof ExternalMappedAttributeValuePrepender;

									for (final MappingHint realHint : g
											.getHintGroup().getMappingHints()) {
										if (realHint instanceof AttributeMapping) {
											if (((MappedAttributeValueExpander) h)
													.getHintsToExpand()
													.contains(realHint)) {
												if (realHint instanceof AttributeMapping && 
														((AttributeMapping) realHint).getExpression() == null ||
														((AttributeMapping) realHint).getExpression().isEmpty()) {// ComplexAttributeMapping

													final LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> vals = new LinkedList<>();
													final List<AttributeMappingSourceInterface> sources = ((AttributeMapping) realHint)
															.getSourceAttributeMappings();

													if (sources.size() > 0) {
														// determine the one of possibly multiple source elements of the
														// attribute mapping to be expanded
														AttributeMappingSourceInterface element;
														if (prepend) {
															element = sources
																	.get(0);
														} else {
															element = sources
																	.get(sources
																			.size() - 1);
														}

														for (final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> m : selMap.getHintValues().getHintValues((AttributeMapping) realHint)) {

															/*
															 *  create a deep-cloned copy of the map holding the source elements and values 
															 *  of complex attribute mapping that we are expanding; this is necessary because the map will
															 *  change in the course of this function but the changes shall not be propagated to future
															 *  calls of this function
															 */

															final LinkedHashMap<AttributeMappingSourceInterface, AttributeValueRepresentation> clonedMap = 
																	new LinkedHashMap<>();
															for (AttributeMappingSourceInterface key : m.keySet()) {
																clonedMap.put(key, 
																		(AttributeValueRepresentation) m.get(key).clone());
															}

															// expand either the first or last value source element and let all other
															// values untouched
															if (clonedMap.containsKey(element)) {
																AttributeValueRepresentation rep = clonedMap.get(element);
																if (prepend) {
																	rep.addPrefix(hintVal);
																} else {
																	rep.addSuffix(hintVal);
																}
																clonedMap.put(element, rep);
															}

															// add the new map to the list holding all hint values
															vals.add(clonedMap);
														}

														// update the hint value list for the real hint
														selMap.getHintValues().setHintValues((AttributeMapping) realHint, vals);
													}
												} else if (realHint instanceof AttributeMapping) {// CalculatorMapping
													final List<AttributeMappingSourceInterface> sources = ((AttributeMapping) realHint)
															.getSourceAttributeMappings();
													if (sources.size() > 0) {
														try {
															final Calculable calc = new ExpressionBuilder(hintVal).build();
															final double variableVal = calc.calculate();
															/*
															 * parseDouble
															 * doesn't support
															 * Scientific
															 * notation, like:
															 * 0.42e2 == 4200e-2
															 * == 42,
															 */
															for (final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> m : selMap.getHintValues().getHintValues((AttributeMapping) realHint)) {
																//TODO check if this works
																m.put(sources.get(0), new AttributeValueRepresentation(((MappedAttributeValueExpander) h).getSourceAttribute(), Double.toString(variableVal)));
															}
														} catch (final Exception e) {
															consoleStream.println("Couldn't convert variable " + ((MappedAttributeValueExpander) h).getSourceAttribute().getName()
																	+ " of " + h.getClass().getName() + " " + h.getName()
																	+ " from String to double. The problematic source element's attribute value was: " + hintVal);
														}
													}
												}// TODO add any remaining
												// hintValue changes here

											}
										} else if (realHint instanceof MappingInstanceSelector) {
											if (((MappingInstanceSelector) realHint)
													.getMatcher() instanceof AttributeMatcher) {
												final AttributeMatcher matcher = (AttributeMatcher) ((MappingInstanceSelector) realHint)
														.getMatcher();

												if (((MappedAttributeValueExpander) h)
														.getHintsToExpand()
														.contains(matcher)) {
													if (matcher instanceof AttributeMatcher) {// ComplexAttributeMatcher
														final List<AttributeMatcherSourceInterface> sources = matcher
																.getSourceAttributes();
														if (sources.size() > 0) {
															AttributeMatcherSourceInterface element;
															if (prepend) {
																element = sources.get(0);
															} else {
																element = sources.get(sources.size() - 1);
															}

															for (final Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> m : selMap.getHintValues().getHintValues((MappingInstanceSelector) realHint)) {
																if (m.containsKey(element)) {
																	if (prepend) {
																		AttributeValueRepresentation preprended = m.get(element);
																		preprended.addPrefix(hintVal);
																		m.put(element, preprended);
																	} else {
																		AttributeValueRepresentation appended = m.get(element);
																		appended.addSuffix(hintVal);
																		m.put(element, appended);
																	}
																}
															}
														}
													}// TODO add any remaining
													// hitValue changes here

												}
											}
										}
									}
								} // else TODO maybe add something here when we
								// know how to handle/control cardinality of
								// ImportedMappingHints
							}
						}
						final LinkedHashMap<TargetSectionClass, LinkedList<EObjectWrapper>> instancesBySection = 
								targetSectionInstantiator.instantiateTargetSectionFirstPass(
										expGrp.getTargetMMSection(), g, hints,
										selMap.getHintValues(),
										selMap.getMapping().getName());
						if (instancesBySection == null) {
							if (expGrp.getTargetMMSection().getCardinality() != CardinalityType.ZERO_INFINITY) {// Error
								consoleStream.println("Error instantiating target section '" + expGrp.getTargetMMSection()
								.getName() + "' using mapping rule '" + selMap.getMapping().getName() + "'");
							}
						} else {
							for (final TargetSectionClass section : instancesBySection
									.keySet()) {
								selMap.addInstances(g, section,
										instancesBySection.get(section));
							}
						}
					}

				}
			}

			accumulatedWork += workUnit;
			if (accumulatedWork >= 1) {
				monitor.worked((int) Math.floor(accumulatedWork));
				accumulatedWork -= Math.floor(accumulatedWork);
			}
		}

		return ExpandingResult.createExpandingResult(attrValueRegistry, targetSectionRegistry);
	}

	/**
	 * This performs the '<em>joining</em>' step of the transformation:
	 * The target sections that have been instantiated during the 
	 * {@link #performExpanding(MatchingResult, List, IProgressMonitor, AttributeValueModifierExecutor) expanding step} are linked
	 * via containment references and added to the target model. If necessary, intermediary object are created as well.
	 * 
	 * @param targetModel The {@link XMIResource} where the coherent target model shall be stored.
	 * @param suitableMappings The active {@link Mapping mappings} from the PAMTraM model.
	 * @param expandingResult The {@link ExpandingResult} that contains the results of the 
	 * {@link #performExpanding(MatchingResult, List, IProgressMonitor, AttributeValueModifierExecutor) expanding step}.
	 * @param attributeValueModifier An instance of {@link AttributeValueModifierExecutor} to use for applying
	 * {@link AttributeValueModifierSet AttributeValueModifierSets}.
	 * @param matchingResult A {@link MatchingResult} that contains the results from the 
	 * {@link #performMatching(EObject, List, AttributeValueModifierExecutor, IProgressMonitor) matching} step.
	 * @param monitor An {@link IProgressMonitor} that shall be used to report the progress of the transformation.
	 * @return '<em><b>true</b></em>' if everything went well, '<em><b>false</b></em>' otherwise.
	 */
	private boolean performJoining(
			final XMIResource targetModel,
			final List<Mapping> suitableMappings,
			final ExpandingResult expandingResult,
			final AttributeValueModifierExecutor attributeValueModifier,
			final MatchingResult matchingResult,
			final IProgressMonitor monitor) {

		writePamtramMessage("Joining targetModelSections");
		monitor.subTask("Joining targetModelSections");

		/*
		 * Initialize the TargetSectionConnector
		 */
		targetSectionConnector = new TargetSectionConnector(
				expandingResult.getTargetSectionRegistry(),
				attributeValueModifier, targetModel, maxPathLength,
				ambiguityResolvingStrategy, consoleStream);
		objectsToCancel.add(targetSectionConnector);
		final double workUnit = 250.0 / suitableMappings.size();
		double accumulatedWork = 0;

		/*
		 * Connect all target sections
		 */
		for (final Mapping m : suitableMappings) {
			for (final MappingHintGroupType g : m.getActiveMappingHintGroups()) {

				if (g.getTargetMMSection() != null
						&& g instanceof MappingHintGroup) {// targetSection
					// exists?
					final TargetSection section = g.getTargetMMSection();
					if (expandingResult.getTargetSectionRegistry().getPamtramClassInstances(section)
							.keySet().size() > 0) {// instances of section
						// exist?
						if (expandingResult.getTargetSectionRegistry().getPamtramClassInstances(
								section).get(g) != null) {// ..also of specific group

							if (((MappingHintGroup) g).getModelConnectionMatcher() != null) {// link using matcher

								for (final MappingInstanceStorage selMap : matchingResult.getSelectedMappingsByMapping().get(m)) {

									if (selMap.getInstances((MappingHintGroup) g, section) != null) {
										if (isCancelled) {
											return false;
										}

										targetSectionConnector.linkToTargetModelUsingModelConnectionHint(
												new LinkedList<>(selMap.getInstances((MappingHintGroup) g, section)),
												section,
												m.getName(),
												g,
												((MappingHintGroup) g).getModelConnectionMatcher(),
												selMap.getHintValues().getHintValues(((MappingHintGroup) g).getModelConnectionMatcher()));
										if (targetSectionConnector.isCancelled()) {
											writePamtramMessage("Transformation aborted.");
											return false;
										}
									}
								}
							} else {// link using container attribute or nothing

								final LinkedList<EObjectWrapper> containerInstances = expandingResult.getTargetSectionRegistry()
										.getFlattenedPamtramClassInstances(section
												.getContainer());

								/*
								 * fetch ALL instances created by the MH-Group in question => less user input and possibly shorter
								 * processing time
								 */
								final LinkedList<EObjectWrapper> rootInstances = expandingResult.getTargetSectionRegistry()
										.getPamtramClassInstances(section).get(g);

								/*
								 * do not want the root instances to contain
								 * themselves
								 */
								containerInstances.removeAll(rootInstances);// we

								targetSectionConnector.linkToTargetModelNoConnectionHint(
										rootInstances, section,
										m.getName(), g,
										section.getContainer() != null ? new HashSet<>(Arrays.asList(section.getContainer().getEClass())) : null,
												containerInstances);
								if (targetSectionConnector.isCancelled()) {
									writePamtramMessage("Transformation aborted.");
									return false;
								}
							}
						}
					}
				}
			}

			for (final MappingHintGroupImporter i : m
					.getActiveImportedMappingHintGroups()) {
				final ExportedMappingHintGroup g = i.getHintGroup();
				if (g.getTargetMMSection() != null) {
					/*
					 * ImportedMAppingHintGroups with containers specified will
					 * be linked to a section that was created by the same
					 * mapping Instance
					 */
					if (i.getContainer() != null) {
						for (final MappingInstanceStorage selMap : matchingResult.getSelectedMappingsByMapping()
								.get(m)) {
							final LinkedList<EObjectWrapper> rootInstances = selMap
									.getInstances(i, g.getTargetMMSection());
							if (rootInstances.size() > 0) {
								final LinkedList<EObjectWrapper> containerInstances = new LinkedList<>();

								// get container instances created by this
								// mapping instance
								for (final MappingHintGroupType group : m
										.getActiveMappingHintGroups()) {
									if (isCancelled) {
										return false;
									}

									if (group instanceof MappingHintGroup) {
										final LinkedList<EObjectWrapper> insts = selMap
												.getInstances(
														(MappingHintGroup) group,
														i.getContainer());
										if (insts != null) {
											containerInstances.addAll(insts);
										}

									}
								}
								// link
								targetSectionConnector.linkToTargetModelNoConnectionHint(
										rootInstances,
										g.getTargetMMSection(),
										m.getName(), g,
										new HashSet<>(Arrays.asList(i.getContainer().getEClass())),
										containerInstances);
								if (targetSectionConnector.isCancelled()) {
									writePamtramMessage("Transformation aborted.");
									return false;
								}
							}
						}

						// use container attribute of targetSection if one is
						// specified
						// (target section container == global instance search)
					} else {
						final LinkedList<EObjectWrapper> containerInstances = new LinkedList<>();
						final LinkedList<EObjectWrapper> rootInstances = expandingResult.getTargetSectionRegistry()
								.getPamtramClassInstances(
										g.getTargetMMSection()).get(i);
						final Set<EClass> containerClasses = new HashSet<>();
						if (g.getTargetMMSection().getContainer() != null) {
							containerClasses.add(g.getTargetMMSection()
									.getContainer().getEClass());
							containerInstances.addAll(expandingResult.getTargetSectionRegistry()
									.getFlattenedPamtramClassInstances(g
											.getTargetMMSection()
											.getContainer()));

						}

						if (rootInstances != null) {
							if (rootInstances.size() > 0) {
								// link
								targetSectionConnector.linkToTargetModelNoConnectionHint(
										rootInstances,
										g.getTargetMMSection(),
										m.getName(), g,
										containerClasses,
										containerInstances);
								if (targetSectionConnector.isCancelled()) {
									writePamtramMessage("Transformation aborted.");
									return false;
								}
							}
						}
					}

				}
			}

			accumulatedWork += workUnit;
			if (accumulatedWork >= 1) {
				monitor.worked((int) Math.floor(accumulatedWork));
				accumulatedWork -= Math.floor(accumulatedWork);
			}
		}

		targetSectionConnector.combineUnlinkedSectionsWithTargetModelRoot();
		if (targetSectionConnector.isCancelled()) {
			writePamtramMessage("Transformation aborted.");
			return false;
		} else {
			return true;
		}

	}

	/**
	 * This performs the '<em>linking</em>' step of the transformation:
	 * Necessary cross references between the created target sections are instantiated.
	 *
	 * @param matchingResult A {@link MatchingResult} that contains the results from the 
	 * {@link #performMatching(EObject, List, AttributeValueModifierExecutor, IProgressMonitor) matching} step.
	 * @param targetSectionInstantiator The {@link TargetSectionInstantiator} that was used to expand the target sections.
	 * @param monitor An {@link IProgressMonitor} that shall be used to report the progress of the transformation.
	 * @return '<em><b>true</b></em>' if everything went well, '<em><b>false</b></em>' otherwise.
	 */
	private boolean performLinking(
			final MatchingResult matchingResult,
			final TargetSectionInstantiator targetSectionInstantiator,
			final IProgressMonitor monitor) {

		writePamtramMessage("Instantiating targetModelSections for selected mappings. Second pass");
		monitor.subTask("Instantiating targetModelSections for selected mappings. Second pass");

		final double workUnit = 250.0 / matchingResult.getSelectedMappings().size();
		double accumulatedWork = 0;
		for (final MappingInstanceStorage selMap : matchingResult.getSelectedMappings()) {
			for (final MappingHintGroupType g : selMap.getMapping()
					.getActiveMappingHintGroups()) {
				if (isCancelled) {
					return false;
				}

				if (g.getTargetMMSection() != null
						&& g instanceof MappingHintGroup) {
					if (selMap.getInstancesBySection((MappingHintGroup) g) != null) {
						targetSectionInstantiator.instantiateTargetSectionSecondPass(
								g.getTargetMMSection(),
								selMap.getMapping().getName(),
								(MappingHintGroup) g,
								g.getTargetMMSection(),
								g.getMappingHints(),
								selMap.getHintValues(),
								selMap.getInstancesBySection((MappingHintGroup) g));
						if (targetSectionInstantiator.isCancelled()) {
							writePamtramMessage("Transformation aborted.");
							return false;
						}
					}
				}
			}

			for (final MappingHintGroupImporter g : selMap.getMapping()
					.getActiveImportedMappingHintGroups()) {
				final ExportedMappingHintGroup expGrp = g.getHintGroup();
				if (expGrp.getTargetMMSection() != null) {
					if (selMap.getInstancesBySection(g) != null) {
						final List<MappingHint> hints = new LinkedList<>();
						hints.addAll(expGrp.getMappingHints());
						for (final MappingHintType h : g.getMappingHints()) {
							if (isCancelled) {
								return false;
							}

							if (h instanceof MappingHint) {
								hints.add((MappingHint) h);
							}// TODO else if ...??-> should have already been
							// done during 1st pass
						}

						targetSectionInstantiator.instantiateTargetSectionSecondPass(
								expGrp.getTargetMMSection(), 
								selMap.getMapping().getName(), 
								g, 
								expGrp.getTargetMMSection(), 
								hints, 
								selMap.getHintValues(), 
								selMap.getInstancesBySection(g));
						if (targetSectionInstantiator.isCancelled()) {
							writePamtramMessage("Transformation aborted.");
							return false;
						}
					}
				}
			}

			accumulatedWork += workUnit;
			if (accumulatedWork >= 1) {
				monitor.worked((int) Math.floor(accumulatedWork));
				accumulatedWork -= Math.floor(accumulatedWork);
			}
		}

		return true;
	}

	/**
	 * This performs the final step of the transformation:
	 * The stored library entries are finally instantiated in the target model.
	 * 
	 * @param targetModel The targetModel in which the library entries are to be instantiated.
	 * @param monitor 
	 * @return <em>true</em> if everything went well, <em>false</em> otherwise.
	 */
	private boolean performInstantiatingLibraryEntries(EObject targetModel, IProgressMonitor monitor) {

		writePamtramMessage("Instantiating libraryEntries for selected mappings.");
		monitor.subTask("Instantiating libraryEntries for selected mappings.");
		return targetSectionInstantiator.instantiateLibraryEntries(targetModel, targetLibraryContextDescriptor);
	}

	/**
	 * Write MappingHint values of Hints of ExportedMappingHintGroups to a
	 * separate storage, and remove the values from the MappingInstanceStorages.
	 *
	 * Also add values of GlobalVariables to ComplexAttributeMapping's Hints
	 *
	 * @param sourceSectionMapper
	 * @param selectedMappings
	 * @return
	 */
	private HintValueStorage handleGlobalVarsAndExportedMappings(
			final SourceSectionMatcher sourceSectionMapper,
			final LinkedList<MappingInstanceStorage> selectedMappings) {

		consoleStream.println("Getting hint values of exported HintHroups, checking MappingHintImporters, adding GlobalVariables and FixedValues to hints");
		//		final AttributeMappingHintValueMap exportedAttributeMappingHints = new AttributeMappingHintValueMap();
		//		final CardinalityMappingHintValueMap exportedCardinalityMappingHints = new CardinalityMappingHintValueMap();
		//		final MappingInstanceSelectorHintValueMap exportedMappingInstanceSelectors= new MappingInstanceSelectorHintValueMap();
		final HintValueStorage exportedHintValues = new HintValueStorage();

		for (final MappingInstanceStorage selMap : selectedMappings) {

			/*
			 * First, we collect the hints from all HintGroups. 
			 */
			ArrayList<MappingHintBaseType> mappingHints = new ArrayList<>();
			for (final MappingHintGroupType g : selMap.getMapping()
					.getActiveMappingHintGroups()) {

				if (g instanceof ExportedMappingHintGroup) {
					for (final MappingHint h : g.getMappingHints()) {
						/*
						 * this works because the SourceSectionMapper guarantees
						 * that a key exists for each MappingHint of the Mapping
						 */
						Object exportedHint = selMap.getHintValues().removeHint(h);
						exportedHintValues.addHintValues(h, exportedHint);
					}
				}

				mappingHints.addAll(g.getMappingHints());
				if (g instanceof MappingHintGroup) {
					mappingHints.add(((MappingHintGroup) g).getModelConnectionMatcher());

				}
			}
			for (final MappingHintGroupImporter ig : selMap.getMapping()
					.getActiveImportedMappingHintGroups()) {

				mappingHints.addAll(ig.getMappingHints());
			}


			/*
			 * Now, we add the hint values for GlobalVariables and FixedValues for all collected hints.
			 */
			for (final MappingHintBaseType h : mappingHints) {

				if (h instanceof AttributeMapping) {
					for (final AttributeMappingSourceInterface i : ((AttributeMapping) h)
							.getSourceAttributeMappings()) {

						SourceSectionAttribute att = null;
						String val = null;

						if (i instanceof GlobalAttributeImporter && sourceSectionMapper.getGlobalAttributeValues().containsKey(
								((GlobalAttributeImporter) i).getGlobalAttribute())) {									
							att = i.getSourceAttribute();
							val = sourceSectionMapper.getGlobalAttributeValues().get(
									((GlobalAttributeImporter) i).getGlobalAttribute());

						} else if (i instanceof FixedValue) {
							val = ((FixedValue) i).getValue();

						} else {
							continue;

						}

						/*
						 * If there does not yet exists any hint value for this AttributeMapping (e.g., if no 
						 * (External)AttributeMappingSourceElement exists for this hint), we need to initialize the
						 * map of hint values manually.
						 */
						if(selMap.getHintValues().getHintValues((AttributeMapping) h).isEmpty()) {
							selMap.getHintValues().getAttributeMappingHintValues().addHintValue(
									(AttributeMapping) h, new LinkedHashMap<AttributeMappingSourceInterface, AttributeValueRepresentation>());
						}

						for (final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> m : selMap.getHintValues().getHintValues((AttributeMapping) h)) {
							m.put(i, new AttributeValueRepresentation(att, val));
						}
					}
				} else if (h instanceof MappingInstanceSelector) {
					if (((MappingInstanceSelector) h).getMatcher() instanceof AttributeMatcher) {
						final AttributeMatcher m = (AttributeMatcher) ((MappingInstanceSelector) h)
								.getMatcher();
						for (final AttributeMatcherSourceInterface i : m.getSourceAttributes()) {

							SourceSectionAttribute att = null;
							String val = null;

							if (i instanceof GlobalAttributeImporter && sourceSectionMapper.getGlobalAttributeValues().containsKey(
									((GlobalAttributeImporter) i)
									.getGlobalAttribute())) {
								att = i.getSourceAttribute();
								val = sourceSectionMapper.getGlobalAttributeValues().get(
										((GlobalAttributeImporter) i).getGlobalAttribute());

							} else if (i instanceof FixedValue) {
								val = ((FixedValue) i).getValue();

							} else {
								continue;

							}

							/*
							 * If there does not yet exists any hint value for this MappingInstanceSelector (e.g., if no 
							 * (External)AttributeMatcherSourceElement exists for this hint), we need to initialize the
							 * map of hint values manually.
							 */
							if(selMap.getHintValues().getHintValues((MappingInstanceSelector) h).isEmpty()) {
								selMap.getHintValues().getMappingInstanceSelectorHintValues().addHintValue(
										(MappingInstanceSelector) h, new LinkedHashMap<AttributeMatcherSourceInterface, AttributeValueRepresentation>());
							}

							for (final Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> o : selMap.getHintValues().getHintValues((MappingInstanceSelector) h)) {
								o.put(i, new AttributeValueRepresentation(att, val));
							}
						}
					}
				} else if (h instanceof ModelConnectionHint) {
					for (final ModelConnectionHintSourceInterface i : ((ModelConnectionHint) h)
							.getSourceElements()) {

						SourceSectionAttribute att = null;
						String val = null;

						if (i instanceof GlobalAttributeImporter && sourceSectionMapper.getGlobalAttributeValues().containsKey(
								((GlobalAttributeImporter) i).getGlobalAttribute())) {

							att = i.getSourceAttribute();
							val = sourceSectionMapper.getGlobalAttributeValues().get(
									((GlobalAttributeImporter) i).getGlobalAttribute());

						} else if (i instanceof FixedValue) {
							val = ((FixedValue) i).getValue();

						} else {
							continue;

						}

						/*
						 * If there does not yet exists any hint value for this ModelConnectionHint (e.g., if no 
						 * (External)ModelConnectionHintSourceElement exists for this hint), we need to initialize the
						 * map of hint values manually.
						 */
						if(selMap.getHintValues().getHintValues((ModelConnectionHint) h).isEmpty()) {
							selMap.getHintValues().getModelConnectionHintValues().addHintValue(
									(ModelConnectionHint) h, new LinkedHashMap<ModelConnectionHintSourceInterface, AttributeValueRepresentation>());
						}

						for (final Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> o : selMap.getHintValues().getHintValues((ModelConnectionHint) h)) {
							o.put(i, new AttributeValueRepresentation(att, val));
						}
					}
				}
			}

			/*
			 * additional MappingHints for HintImporters are necessary but must
			 * be restricted to a cardinality of 0..1
			 */
			for (final MappingHintGroupImporter g : selMap.getMapping()
					.getActiveImportedMappingHintGroups()) {
				for (final MappingHintType h : g.getMappingHints()) {
					if (h instanceof AttributeMapping && selMap.getHintValues().getHintValues((AttributeMapping) h).size() > 1) {
						consoleStream.println("The MappingHint " + h.getName() + " of the HintImporter " + g.getName() + " in Mapping "
								+ selMap.getMapping().getName() + " picked up more than one HintValue. This is not allowed.");
						/*
						 * TODO OCL? (possible? => Even sections with card. type
						 * of ONE can have more than one hint value if they are
						 * part of a vc-section. However, we cannot restrict the
						 * parent sections to non-vc, argh...can we?)
						 */
						selMap.getHintValues().setHintValues((AttributeMapping) h, null);
					} else if (h instanceof MappingInstanceSelector && selMap.getHintValues().getHintValues((MappingInstanceSelector) h).size() > 1) {
						consoleStream.println("The MappingHint " + h.getName() + " of the HintImporter " + g.getName() + " in Mapping "
								+ selMap.getMapping().getName() + " picked up more than one HintValue. This is not allowed.");
						/*
						 * TODO OCL? (possible? => Even sections with card. type
						 * of ONE can have more than one hint value if they are
						 * part of a vc-section. However, we cannot restrict the
						 * parent sections to non-vc, argh...can we?)
						 */
						selMap.getHintValues().setHintValues((MappingInstanceSelector) h, null);
					} else if (h instanceof CardinalityMapping && selMap.getHintValues().getHintValues((CardinalityMapping) h).size() > 1) {
						consoleStream.println("The MappingHint " + h.getName() + " of the HintImporter " + g.getName() + " in Mapping "
								+ selMap.getMapping().getName() + " picked up more than one HintValue. This is not allowed.");
						/*
						 * TODO OCL? (possible? => Even sections with card. type
						 * of ONE can have more than one hint value if they are
						 * part of a vc-section. However, we cannot restrict the
						 * parent sections to non-vc, argh...can we?)
						 */
						selMap.getHintValues().setHintValues((CardinalityMapping) h, null);
					} else if (h instanceof MappedAttributeValueExpander && selMap.getHintValues().getHintValues((MappedAttributeValueExpander) h).size() > 1) {
						consoleStream.println("The MappingHint " + h.getName() + " of the HintImporter " + g.getName() + " in Mapping "
								+ selMap.getMapping().getName() + " picked up more than one HintValue. This is not allowed.");
						/*
						 * TODO OCL? (possible? => Even sections with card. type
						 * of ONE can have more than one hint value if they are
						 * part of a vc-section. However, we cannot restrict the
						 * parent sections to non-vc, argh...can we?)
						 */
						selMap.getHintValues().setHintValues((MappedAttributeValueExpander) h, null);
					}
				}
			}
		}

		return exportedHintValues;
	}

	/**
	 * This is a temporary method that is called by the 'source section matcher
	 * page' in order to get the matched sections for a sample source model.
	 * Therefore, it performs half a transformation and then returns the matched
	 * section. This should be changed in the future e.g. by using the
	 * 'transformation model'.
	 *
	 * @author mfreund
	 * @return A map containing the mapped sections.
	 */
	@Deprecated
	public LinkedHashMap<SourceSectionClass, Set<EObject>> mapSections() {

		if(pamtramModel == null || sourceModels == null || sourceModels.isEmpty()) {
			return null;
		}

		// find active mappings and resolve ambiguities as far as possible without user
		// input
		final List<Mapping> suitableMappings = pamtramModel.getActiveMappings();// TODO apply context Model

		// generate storage objects and generators
		final AttributeValueModifierExecutor attributeValueModifier = new AttributeValueModifierExecutor(
				consoleStream);


		/*
		 * create a list of all the containment references in the source model
		 */
		writePamtramMessage("Analysing srcModel containment references");

		/*
		 * Build the ContainmentTree representing the source model. This will keep track of all matched
		 * and unmatched elements.
		 */
		final ContainmentTree containmentTree = ContainmentTree.build(sourceModels);


		final SourceSectionMatcher sourceSectionMapper = new SourceSectionMatcher(
				containmentTree, suitableMappings, onlyAskOnceOnAmbiguousMappings, attributeValueModifier, ambiguityResolvingStrategy, consoleStream);

		/*
		 * now start mapping each one of the references. We automatically start
		 * at the sourceModel root node
		 */
		writePamtramMessage("Selecting Mappings for source model elements");

		final int numSrcModelElements = containmentTree.getNumberOfElements();
		int unmapped = 0;
		while (containmentTree.getNumberOfAvailableElements() > 0) {
			// find mapping
			// remove(0) automatically selects element highest in the hierarchy
			// we currently try to map

			final MappingInstanceStorage selectedMapping = sourceSectionMapper.findMappingForNextElement();
			if (sourceSectionMapper.isCancelled()) {
				writePamtramMessage("Transformation aborted.");
				return null;
			}
			if (selectedMapping == null) {
				unmapped++;
			}

		}
		consoleStream.println("Used srcModel elements: "
				+ (numSrcModelElements - unmapped));

		return sourceSectionMapper.getMatchedSections();

	}

	/**
	 * This loads the pamtram model from an XMI file. If necessary, additional {@link EPackage EPackages} that are
	 * referenced in the model are registered so that no errors occur during the transformation.
	 * 
	 * @param rs The resource set to be used to load the resource.
	 * @return '<em><b>true</b></em>' if the model was loaded successfully, '<em><b>false</b></em>' otherwise.
	 */
	private boolean loadPamtramModel(ResourceSet rs) {

		ResourceSet resourceSet = rs;

		// the URI of the pamtram resource
		final URI pamtramUri = URI.createPlatformResourceURI(pamtramPath, true);

		// load the pamtram model
		XMIResource pamtramResource = 
				(XMIResource) resourceSet.getResource(pamtramUri, true);
		if(!(pamtramResource.getContents().get(0) instanceof PAMTraM)) {
			writePamtramMessage("The pamtram file does not seem to contain a pamtram instance. Aborting...");
			return false;
		}
		pamtramModel = (PAMTraM) pamtramResource.getContents()
				.get(0);

		// try to register the ePackages involved in the pamtram model (if not already done)
		EPackageCheck result = EPackageHelper.checkInvolvedEPackages(
				pamtramModel,
				ResourcesPlugin.getWorkspace().getRoot().findMember(sourceFilePaths.get(0)).getProject(),
				EPackage.Registry.INSTANCE);
		switch (result) {
		case ERROR_PACKAGE_NOT_FOUND:
			writePamtramMessage("One or more EPackages are not loaded correctly. Aborting...");
			return false;
		case ERROR_METAMODEL_FOLDER_NOT_FOUND:
		case ERROR_PAMTRAM_NOT_FOUND:
			writePamtramMessage("Internal error during EPackage check. Aborting...");
			return false;
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

		return true;
	}

	/**
	 * This loads the source models from XMI or XML files.
	 * 
	 * @param rs The resource set to be used to load the resource.
	 */
	private void loadSourceModel(ResourceSet resourceSet) {

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
	}

	/**
	 * This creates the resource to hold the target model created by the
	 * transformation.
	 * 
	 * @param resourceSet The resource set used to create the resource.
	 * @return true if the resource has successfully been created, false otherwise.
	 */
	private boolean createTargetModel(ResourceSet resourceSet) {

		final XMIResourceFactoryImpl resFactory = new XMIResourceFactoryImpl();

		// the URI of the target resource
		final URI targetFileUri = URI.createPlatformResourceURI(targetFilePath, true);

		try {
			targetModel = (XMIResource) resFactory.createResource(targetFileUri);
			targetModel.setEncoding("UTF-8");

		} catch (final Exception e) {
			MessageDialog.openError(PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), "Error",
					"The XMI resource for the targetModel output could not be created.");
			e.printStackTrace();
			return false;
		}

		return true;
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

	/**
	 * Writes a message on the console that helps to divide the transformation
	 * output into different stages of the transformation
	 *
	 * @param msg The message to be printed to the console
	 */
	private void writePamtramMessage(final String msg) {
		consoleStream.println("\n################# " + msg + " #################\n");
	}

	/**
	 * This class encapsulates the various results of the <em>matching</em> process during a generic transformation:
	 * <br />
	 * <ul>
	 * 	<li>the status of the matching process,</li>
	 * 	<li>a list of selected {@link MappingInstanceStorage mappings},</li>
	 *  <li>a map of selected {@link MappingInstanceStorage mappings}, associated with the {@link Mapping} that they represent,</li>
	 *  <li>{@link HintValueStorage exported hint values},</li>
	 *  <li>a map describing values for {@link GlobalAttribute GlobalAttributes}</li>
	 * </ul>
	 * @author mfreund
	 *
	 */
	static class MatchingResult {

		/**
		 * This describes the status of the matching process, '<em><b>true</b></em>' meaning that the matching process has been
		 * canceled, '<em><b>false</b></em>' otherwise.
		 */
		private final boolean canceled;

		/**
		 * This is the getter for the {@link #canceled}.
		 * @return The status of the matching process, '<em><b>true</b></em>' meaning that the matching process has been
		 * canceled, '<em><b>false</b></em>' otherwise.
		 */
		boolean isCanceled() {
			return canceled; 
		}

		/**
		 * This is the list of {@link MappingInstanceStorage mappings} that have been selected during the <em>matching</em>
		 * process.
		 */
		private final LinkedList<MappingInstanceStorage> selectedMappings;

		/**
		 * This is the getter for the {@link #selectedMappings}.
		 * @return The list of {@link MappingInstanceStorage mappings} that have been selected during the <em>matching</em>
		 * process.
		 */
		LinkedList<MappingInstanceStorage> getSelectedMappings() {
			return this.selectedMappings;
		}

		/**
		 * This the map of {@link MappingInstanceStorage mappings} that have been selected during the <em>matching</em>
		 * process associated with the {@link Mapping} that they represent.
		 */
		private final LinkedHashMap<Mapping, LinkedList<MappingInstanceStorage>> selectedMappingsByMapping;

		/**
		 * This is the getter for the {@link #selectedMappingsByMapping}.
		 * @return The map of {@link MappingInstanceStorage mappings} that have been selected during the <em>matching</em>
		 * process associated with the {@link Mapping} that they represent. 
		 */
		LinkedHashMap<Mapping, LinkedList<MappingInstanceStorage>> getSelectedMappingsByMapping() {
			return selectedMappingsByMapping;
		}

		/**
		 * This is the {@link HintValueStorage} containing values for exported mapping hints.
		 */
		private final HintValueStorage exportedMappingHints;

		/**
		 * This is the getter for the {@link #exportedMappingHints}.
		 * @return The {@link HintValueStorage} containing values for exported mapping hints.
		 */
		HintValueStorage getExportedMappingHints() {
			return exportedMappingHints;
		}

		/**
		 * This is the map of values for global attributes associated with the {@link GlobalAttribute} that
		 * they represent.
		 */
		private final Map<GlobalAttribute, String> globalAttributeValues;

		/**
		 * This is the getter for the {@link #globalAttributeValues}.
		 * @return The map of values for global attributes associated with the {@link GlobalAttribute} that
		 * they represent.
		 */
		Map<GlobalAttribute, String> getGlobalAttributeValues() {
			return globalAttributeValues;
		}

		/**
		 * This constructs an instance.
		 * 
		 * @param canceled '<em><b>true</b></em>' indicates that the matching process was canceled, '<em><b>false</b></em>' indicates that
		 * the matching process completed successfully.
		 * @param selectedMappings The list of {@link MappingInstanceStorage mappings} that have been selected during the <em>matching</em>
		 * process.
		 * @param selectedMappingsByMapping The map of {@link MappingInstanceStorage mappings} that have been selected during the <em>matching</em>
		 * process associated with the {@link Mapping} that they represent. 
		 * @param exportedMappingHints The {@link HintValueStorage} containing values for exported mapping hints.
		 * @param globalAttributeValues The map of values for global attributes associated with the {@link GlobalAttribute} that
		 * they represent.
		 */
		private MatchingResult(
				boolean canceled,
				LinkedList<MappingInstanceStorage> selectedMappings, 
				LinkedHashMap<Mapping, LinkedList<MappingInstanceStorage>> selectedMappingsByMapping,
				HintValueStorage exportedMappingHints,
				Map<GlobalAttribute, String> globalAttributeValues) {
			this.canceled = canceled;
			this.selectedMappings = selectedMappings;
			this.selectedMappingsByMapping = selectedMappingsByMapping;
			this.exportedMappingHints = exportedMappingHints;
			this.globalAttributeValues = globalAttributeValues;
		}

		/**
		 * This constructs an instance for a matching process that has been canceled.
		 * @return An instance of {@link MatchingResult} indicating that the matching was canceled.
		 */
		public static MatchingResult createMatchingCanceledResult() {
			return new MatchingResult(true, null, null, null, null);
		}

		/**
		 * This constructs an instance for a matching process that has finished successfully.
		 * @param selectedMappings The list of {@link MappingInstanceStorage mappings} that have been selected during the <em>matching</em>
		 * process.
		 * @param selectedMappingsByMapping The map of {@link MappingInstanceStorage mappings} that have been selected during the <em>matching</em>
		 * process associated with the {@link Mapping} that they represent. 
		 * @param exportedMappingHints The {@link HintValueStorage} containing values for exported mapping hints.
		 * @param globalAttributeValues The map of values for global attributes associated with the {@link GlobalAttribute} that
		 * they represent.
		 * @return An instance of {@link MatchingResult} indicating that the matching has completed successfully.
		 */
		public static MatchingResult createMatchingCompletedResult(
				LinkedList<MappingInstanceStorage> selectedMappings, 
				LinkedHashMap<Mapping, LinkedList<MappingInstanceStorage>> selectedMappingsByMapping,
				HintValueStorage exportedMappingHints,
				Map<GlobalAttribute, String> globalAttributeValues) {
			return new MatchingResult(false, selectedMappings, selectedMappingsByMapping, exportedMappingHints, globalAttributeValues);
		}
	}

	/**
	 * This class encapsulates the various results of the <em>expanding</em> process during a generic transformation:
	 * <br />
	 * <ul>
	 * 	<li>an {@link AttributeValueRegistry} containing registered attribute values,</li>
	 *  <li>a {@link TargetSectionRegistry} containing/representing created target sections</li>
	 * </ul>
	 * @author mfreund
	 *
	 */
	static class ExpandingResult {

		/**
		 * An {@link AttributeValueRegistry} containing registered attribute values.
		 */
		private final AttributeValueRegistry attributeValueRegistry;

		/**
		 * This is the getter for the {@link #attributeValueRegistry}.
		 * @return An {@link AttributeValueRegistry} containing registered attribute values.
		 */
		AttributeValueRegistry getAttributeValueRegistry() {
			return attributeValueRegistry;
		}

		/**
		 * A {@link TargetSectionRegistry} containing/representing created target sections.
		 */
		private final TargetSectionRegistry targetSectionRegistry;

		/**
		 * This is the getter for the {@link #targetSectionRegistry}.
		 * return A {@link TargetSectionRegistry} containing/representing created target sections.
		 */
		TargetSectionRegistry getTargetSectionRegistry() {
			return targetSectionRegistry;
		}

		/**
		 * This constructs an instance for an expanding process.
		 * 
		 * @param attributeValueRegistry The {@link AttributeValueRegistry} containing registered attribute values.
		 * @param targetSectionRegistry The {@link TargetSectionRegistry} containing/representing created target sections.
		 */
		private ExpandingResult(
				AttributeValueRegistry attributeValueRegistry, 
				TargetSectionRegistry targetSectionRegistry) {

			this.attributeValueRegistry = attributeValueRegistry;
			this.targetSectionRegistry = targetSectionRegistry;
		}

		/**
		 * This constructs an instance for an expanding process.
		 * 
		 * @param attributeValueRegistry The {@link AttributeValueRegistry} containing registered attribute values.
		 * @param targetSectionRegistry The {@link TargetSectionRegistry} containing/representing created target sections.
		 * @return An instance of {@link ExpandingResult}.
		 */
		public static ExpandingResult createExpandingResult(
				AttributeValueRegistry attributeValueRegistry, 
				TargetSectionRegistry targetSectionRegistry) {

			return new ExpandingResult(attributeValueRegistry, targetSectionRegistry); 
		}
	}
}
