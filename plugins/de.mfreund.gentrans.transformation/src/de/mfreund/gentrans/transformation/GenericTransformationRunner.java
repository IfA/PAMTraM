package de.mfreund.gentrans.transformation;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.mfreund.gentrans.transformation.GenericTransformationRunner.TransformationResult.ExpandingResult;
import de.mfreund.gentrans.transformation.GenericTransformationRunner.TransformationResult.JoiningResult;
import de.mfreund.gentrans.transformation.GenericTransformationRunner.TransformationResult.MatchingResult;
import de.mfreund.gentrans.transformation.calculation.AttributeValueCalculator;
import de.mfreund.gentrans.transformation.calculation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.ContainmentTree;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.instantiating.TargetSectionConnector;
import de.mfreund.gentrans.transformation.instantiating.TargetSectionInstantiator;
import de.mfreund.gentrans.transformation.instantiating.TargetSectionLinker;
import de.mfreund.gentrans.transformation.library.LibraryEntryInstantiator;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.matching.GlobalAttributeValueExtractor;
import de.mfreund.gentrans.transformation.matching.HintValueExtractor;
import de.mfreund.gentrans.transformation.matching.MappingSelector;
import de.mfreund.gentrans.transformation.matching.SourceSectionMatcher;
import de.mfreund.gentrans.transformation.registries.AttributeValueRegistry;
import de.mfreund.gentrans.transformation.registries.HintValueStorage;
import de.mfreund.gentrans.transformation.registries.TargetModelRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.DefaultAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.util.CancelableElement;
import de.mfreund.gentrans.transformation.util.ICancelable;
import de.mfreund.gentrans.transformation.util.MonitorWrapper;
import de.mfreund.pamtram.transformation.Transformation;
import de.mfreund.pamtram.transformation.TransformationFactory;
import de.mfreund.pamtram.transformation.TransformationMapping;
import de.mfreund.pamtram.transformation.TransformationMappingHintGroup;
import pamtram.PAMTraM;
import pamtram.TargetSectionModel;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionClass;
import pamtram.util.GenLibraryManager;

/**
 * Main Class for running the generic transformation for a PAMTraM model.
 *
 * @author Sascha Steffen, Matthias Freund
 * @version 1.0
 */
public class GenericTransformationRunner extends CancelableElement {

	private static final String TRANSFORMATION_ABORTED_MESSAGE = "Transformation aborted.";

	/**
	 * This keeps track of objects that need to be canceled when the user requests an early termination of the transformation.
	 */
	private final List<ICancelable> objectsToCancel;
	
	/**
	 * The {@link TransformationConfiguration} providing the parameters for the transformation.
	 */
	private TransformationConfiguration transformationConfig;

	/**
	 * The {@link Transformation} where the context of this generic transformation including
	 * the associated source, target and pamtram model(s) as well as all {@link TransformationMapping TransformationMappings}
	 * are stored. This will be returned at the end of the generic transformation and could e.g. be used to reason
	 * about the performed transformation by means of additional algorithms.
	 */
	private Transformation transformationModel;

	/**
	 * This is the {@link TargetSectionInstantiator} that can be used to create new target sections.
	 */
	private TargetSectionInstantiator targetSectionInstantiator;

	/**
	 * This is the {@link TargetSectionConnector} that can be used to connect target sections that
	 * have been created with the help of the {@link #targetSectionInstantiator}.
	 */
	private TargetSectionConnector targetSectionConnector;
	
	/**
	 * This is the {@link TargetSectionLinker} that can be used to link target sections.
	 */
	private TargetSectionLinker targetSectionLinker;

	/**
	 * This describes the result of the transformation (after calling {@link #runTransformation(IProgressMonitor)}). 
	 */
	private TransformationResult transformationResult;

	/**
	 * This creates an instance based on the given {@link TransformationConfiguration}.
	 * 
	 * @param config The {@link TransformationConfiguration} specifying all parameters
	 * necessary for the execution of the transformation.
	 */
	GenericTransformationRunner(TransformationConfiguration config) {
		
		super();
		this.transformationConfig = config;
		this.transformationResult = null;

		/*
		 * create the TransformationModel where the context of the transformation is stored
		 */
		this.transformationModel = TransformationFactory.eINSTANCE.createTransformation();
		this.transformationModel.setId(Integer.toString(hashCode()));

		objectsToCancel = new LinkedList<>();
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

		// validate the pamtram model
		Diagnostic diag = Diagnostician.INSTANCE.validate(transformationConfig.getPamtramModel());
		if(diag.getSeverity() == Diagnostic.ERROR) {
			final AtomicBoolean result = new AtomicBoolean();

			Display.getDefault().syncExec(() -> {

				result.set(ErrorDialog.open(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
						"Errors exist in the specified PAMTraM model. Continue anyway?"));
			});

			if(!result.get()) {
				return;
			}
		}

		// set the start date (after loading all models)
		this.transformationModel.setStartDate(new Date());

		/* 
		 * before we can use the PAMTraM model, we need merge all extended HintGroups or Sections;
		 * that way, we get a 'clean' model (without any extensions) that we can handle in a normal way
		 */
		transformationConfig.getPamtramModel().mergeExtends();

		/*
		 * initialize the ambiguity resolving strategy
		 */
		writePamtramMessage("Initializing ambiguity resolving strategy");
		try {
			transformationConfig.getAmbiguityResolvingStrategy().init(transformationConfig.getPamtramModel(), 
					transformationConfig.getSourceModels(), transformationConfig.getConsoleStream());
			transformationConfig.getConsoleStream().println("\nInitialization Successful!");
		} catch (Exception e1) {
			e1.printStackTrace();
			transformationConfig.getConsoleStream().println("Internal error. Switching to DefaultAmbiguityResolvingStrategy...");
			transformationConfig.withAmbiguityResolvingStrategy(new DefaultAmbiguityResolvingStrategy());
		}

		// find active mappings and resolve ambiguities as far as possible without user
		// input
		final List<Mapping> suitableMappings = transformationConfig.getPamtramModel().getActiveMappings();
		// TODO apply contextModel

		try {
			/*
			 * try to execute all active mappings (this includes the 4 resp. 5 main steps of
			 * the transformation
			 */
			transformationResult = executeMappings(transformationConfig.getSourceModels(), transformationConfig.getPamtramModel(), suitableMappings,
					monitorWrapper); 			
		} catch (RuntimeException e) {
			transformationConfig.getConsoleStream().println(e.getMessage());
			transformationConfig.getConsoleStream().println("Aborting...");
			throw e;
		}

		// set the end date (before storing)
		this.transformationModel.setEndDate(new Date());

		if (transformationResult != null && transformationResult.getOverallResult() && !isCanceled()) {

			/*
			 * create the target models
			 */
			boolean result = transformationResult.getJoiningResult().getTargetModelRegistry().saveTargetModels();

			final long endTime = System.nanoTime();
			writePamtramMessage("Transformation done. Time: "
					+ Math.ceil((endTime - startTime) / 100000000L) / 10.0 + "s");

			if(!result) {
				return;
			}

			/*
			 * populate and store the transformation model if necessary
			 */
			generateTransformationModel();
		}


	}

	/**
	 * This cancels any running (or future) transformation.
	 */
	@Override
	public void cancel() {
		super.cancel();
		objectsToCancel.parallelStream().forEach(ICancelable::cancel);
	}

	/**
	 * This performs the actual execution of the transformation. In the course of this method,
	 * the four main steps of the transformation get executed.
	 * 
	 * @param sourceModels The list of {@link EObject source models} to be transformed.
	 * @param pamtramModel The {@link PAMTraM} instance that describes the transformation.
	 * @param suitableMappings A list of {@link Mapping Mappings} that may be used in the transformation. This needs to match
	 * those mappings defined in the given '<em>pamtramModel</em>' or be a subset of these mappings
	 * @param monitor The {@link IProgressMonitor monitor} that shall be used to visualize the progress of the transformation.
	 * @return '<em><b>true</b></em>' if the transformation was performed successfully, '<em><b>false</b></em>' otherwise
	 */
	private TransformationResult executeMappings(final List<EObject> sourceModels,
			final PAMTraM pamtramModel, final List<Mapping> suitableMappings,
			final IProgressMonitor monitor) {

		/*
		 * The TransformationResult that we will return in the end.
		 */
		TransformationResult transformationResult = new TransformationResult();

		// generate storage objects and generators
		final AttributeValueModifierExecutor attributeValueModifier =
				AttributeValueModifierExecutor.init(transformationConfig.getConsoleStream());

		/*
		 * Perform the 'matching' step of the transformation
		 */
		MatchingResult matchingResult = performMatching(sourceModels, suitableMappings, attributeValueModifier, monitor);
		transformationResult.setMatchingResult(matchingResult);

		if(matchingResult.isCanceled()) {
			return transformationResult;
		}

		/*
		 * Perform the 'expanding' step of the transformation
		 */
		ExpandingResult expandingResult = performExpanding(
				matchingResult, pamtramModel.getGlobalValues(), monitor,
				attributeValueModifier);
		transformationResult.setExpandingResult(expandingResult);

		/*
		 * Perform the 'joining' step of the transformation
		 */
		JoiningResult joiningResult = performJoining(transformationConfig.getDefaultTargetModel(), suitableMappings,
				expandingResult, attributeValueModifier, matchingResult, monitor); 
		transformationResult.setJoiningResult(joiningResult);

		if (joiningResult.isCanceled()) {
			return transformationResult;
		}

		/*
		 * Perform the 'linking' step of the transformation
		 */
		boolean linkingResult = performLinking(matchingResult, expandingResult, attributeValueModifier, monitor);
		transformationResult.setLinkingResult(linkingResult);

		if(!linkingResult) {
			return transformationResult;
		}

		/*
		 * Finally, instantiate the collected library entries in the target model. 
		 */
		if(joiningResult.getTargetModelRegistry().isEmpty()) {
			transformationConfig.getConsoleStream().println("Something seems to be wrong! Target model is empty!");
		} else {
			boolean libEntryExpandingResult = performInstantiatingLibraryEntries(
					matchingResult,
					expandingResult,
					attributeValueModifier, monitor);
			transformationResult.setLibEntryExpandingResult(libEntryExpandingResult);
		}
		return transformationResult;

	}

	/**
	 * This performs the '<em>matching</em>' step of the transformation. Therefore, it iterates through the
	 * given list of '<em>sourceModels</em>', {@link SourceSectionMatcher#matchSections() matches SourceSections},
	 * {@link MappingSelector#selectMappings() selects mappings} and {@link HintValueExtractor#extractHintValues()
	 * extracts hint values}. 
	 *  
	 * @param sourceModels The list of {@link EObject EObjects} representing/containing the source model to be matched. 
	 * @param suitableMappings A list of {@link Mapping Mappings} that shall be used for the matching process.
	 * @param attributeValueModifier An instance of {@link AttributeValueModifierExecutor} that shall be used to 
	 * apply {@link AttributeValueModifierSet AttributeValueModifierSets} in order to obtain hint values.
	 * @param monitor An {@link IProgressMonitor} that shall be used to report the progress of the transformation.
	 * @return A {@link MatchingResult} that contains the various results of the matching.
	 */
	private MatchingResult performMatching(
			List<EObject> sourceModels, 
			List<Mapping> suitableMappings, 
			AttributeValueModifierExecutor attributeValueModifier, 
			IProgressMonitor monitor) {

		LinkedList<MappingInstanceStorage> selectedMappings;
		Map<Mapping, List<MappingInstanceStorage>> selectedMappingsByMapping;

		/*
		 * Build the ContainmentTree representing the source model. This will keep track of all matched
		 * and unmatched elements.
		 */
		writePamtramMessage("Matching SourceSections");
		monitor.subTask("Selecting Mappings for source model elements");
		final ContainmentTree containmentTree = ContainmentTree.build(sourceModels);

		// Select the SourceSections that we want to match.
		// contained in active hint groups?
		List<SourceSection> activeSourceSections = transformationConfig.getPamtramModel().getSourceSections().parallelStream().
				filter(s -> !s.isAbstract()).collect(Collectors.toList());

		/*
		 * Create the SourceSectionMatcher that matches SourceSections
		 */
		final SourceSectionMatcher sourceSectionMatcher = new SourceSectionMatcher(
				containmentTree, new BasicEList<>(activeSourceSections), transformationConfig.getConsoleStream());

		Map<SourceSection, List<MatchedSectionDescriptor>> matchingResult = sourceSectionMatcher.matchSections();

		writePamtramMessage("Extract Values of Global Attributes");

		/*
		 * Create the GlobalAttributeValueExtractor that extracts values of GlobalAttributes
		 */
		GlobalAttributeValueExtractor globalAttributeValueExtractor = new GlobalAttributeValueExtractor(
				attributeValueModifier, transformationConfig.getConsoleStream());
		Map<GlobalAttribute, String> globalAttributeValues = 
				globalAttributeValueExtractor.extractGlobalAttributeValues(matchingResult, suitableMappings);

		// Collect the values of FixedValues and GlobalAttributes in a common map that will be passed to consumers
		//
		GlobalValueMap globalValues = new GlobalValueMap(
				transformationConfig.getPamtramModel().getGlobalValues().parallelStream().collect(
						Collectors.toMap(Function.identity(), FixedValue::getValue)), 
				globalAttributeValues);

		writePamtramMessage("Select Mappings for Matched Sections");

		/*
		 * Create the MappingSelector that finds applicable mappings
		 */
		final MappingSelector mappingSelector = new MappingSelector(matchingResult, suitableMappings, globalValues, 
				transformationConfig.isOnlyAskOnceOnAmbiguousMappings(), transformationConfig.getAmbiguityResolvingStrategy(), 
				transformationConfig.getConsoleStream());

		selectedMappingsByMapping = mappingSelector.selectMappings();
		List<MappingInstanceStorage> mappingInstances = 
				selectedMappingsByMapping.values().stream().flatMap(l -> l.stream()).collect(Collectors.toList());

		writePamtramMessage("Extract Hint Values");

		/*
		 * Calculate mapping hints 
		 */
		final HintValueExtractor hintValueExtractor = new HintValueExtractor(
				mappingInstances,
				globalValues.getGlobalAttributes(), 
				attributeValueModifier, transformationConfig.getConsoleStream());
		hintValueExtractor.extractHintValues();

		transformationConfig.getConsoleStream().println("Summary:\tAvailable Elements:\t" +
				containmentTree.getNumberOfElements());
		transformationConfig.getConsoleStream().println("\t\tMatched Elements:\t" +
				containmentTree.getNumberOfMatchedElements());
		transformationConfig.getConsoleStream().println("\t\tUnmatched Elements:\t" +
				containmentTree.getNumberOfUnmatchedElements());

		selectedMappings = new LinkedList<>(
				selectedMappingsByMapping.entrySet().parallelStream().flatMap(e -> e.getValue().stream()).collect(Collectors.toList()));

		return MatchingResult.createMatchingCompletedResult(selectedMappings,
				selectedMappingsByMapping, new HintValueStorage(),
				globalValues);

	}

	/**
	 * This performs the '<em>expanding</em>' step of the transformation:
	 * The target sections (excluding those that are defined by {@link LibraryEntry LibraryEntries})
	 * are instantiated (only containment references and attributes but no non-containment
	 * references).
	 *
	 * @param matchingResult A {@link MatchingResult} that contains the results from the 
	 * {@link #performMatching(EObject, List, AttributeValueModifierExecutor, IProgressMonitor) matching} step.
	 * @param globalValues The list of {@link FixedValue GlobalValues} to use.
	 * @param monitor An {@link IProgressMonitor} that shall be used to report the progress of the transformation.
	 * @param attributeValuemodifier An instance of {@link AttributeValueModifierExecutor} to use for applying
	 * {@link AttributeValueModifierSet AttributeValueModifierSets}.
	 * @return An {@link ExpandingResult} that contains the various results of the expanding step.
	 */
	private ExpandingResult performExpanding(
			final MatchingResult matchingResult,
			final List<FixedValue> globalValues,
			final IProgressMonitor monitor,
			final AttributeValueModifierExecutor attributeValuemodifier) {

		final AttributeValueRegistry attrValueRegistry = new AttributeValueRegistry();

		/*
		 * Instantiate TargetSectionRegistry, analyzes target-metamodel
		 */
		monitor.subTask("Instantiating targetModelSections for selected mappings. First pass");
		writePamtramMessage("Analyzing target metamodel");
		final TargetSectionRegistry targetSectionRegistry = new TargetSectionRegistry(
				transformationConfig.getConsoleStream(),
				attrValueRegistry, 
				transformationConfig.getPamtramModel().getTargetSectionModel().parallelStream().map(
						m -> m.getMetaModelPackage()).collect(Collectors.toSet()));
		objectsToCancel.add(targetSectionRegistry);

		writePamtramMessage("Instantiating targetModelSections for selected mappings. First pass");

		/*
		 * Initialize the TargetSectionInstantiator
		 */
		targetSectionInstantiator = new TargetSectionInstantiator(
				targetSectionRegistry, attrValueRegistry,
				matchingResult.getGlobalValues().getGlobalValuesAsDouble(),
				attributeValuemodifier, transformationConfig.getConsoleStream(), transformationConfig.getAmbiguityResolvingStrategy());
		objectsToCancel.add(targetSectionInstantiator);


		// Iterate over all selected mapping instances and expand them
		//
		matchingResult.getSelectedMappings().stream().forEach(
				targetSectionInstantiator::expandTargetSectionInstance);
		
		// Used to update the monitor.
		//
		monitor.worked(250);

		return ExpandingResult.createExpandingResult(attrValueRegistry, targetSectionRegistry, targetSectionInstantiator.getLibEntryInstantiatorMap());
	}

	/**
	 * This performs the '<em>joining</em>' step of the transformation:
	 * The target sections that have been instantiated during the 
	 * {@link #performExpanding(MatchingResult, List, IProgressMonitor, AttributeValueModifierExecutor) expanding step} are linked
	 * via containment references and added to the target model. If necessary, intermediary object are created as well.
	 * 
	 * @param defaultTargetModel File path of the <em>default</em> target model (relative to the {@link #targetBasePath}).
	 * @param suitableMappings The active {@link Mapping mappings} from the PAMTraM model.
	 * @param expandingResult The {@link ExpandingResult} that contains the results of the 
	 * {@link #performExpanding(MatchingResult, List, IProgressMonitor, AttributeValueModifierExecutor) expanding step}.
	 * @param attributeValueModifier An instance of {@link AttributeValueModifierExecutor} to use for applying
	 * {@link AttributeValueModifierSet AttributeValueModifierSets}.
	 * @param matchingResult A {@link MatchingResult} that contains the results from the 
	 * {@link #performMatching(EObject, List, AttributeValueModifierExecutor, IProgressMonitor) matching} step.
	 * @param monitor An {@link IProgressMonitor} that shall be used to report the progress of the transformation.
	 * @return A {@link JoiningResult} representing the result of the joining step.
	 */
	private JoiningResult performJoining(
			final String defaultTargetModel,
			final List<Mapping> suitableMappings,
			final ExpandingResult expandingResult,
			final AttributeValueModifierExecutor attributeValueModifier,
			final MatchingResult matchingResult,
			final IProgressMonitor monitor) {

		writePamtramMessage("Joining targetModelSections");
		monitor.subTask("Joining targetModelSections");

		/*
		 * The TargetModelRegistry that will be returned at the end as part of the 'JoiningResult'.
		 */
		TargetModelRegistry targetModelRegistry = new TargetModelRegistry(
				transformationConfig.getTargetBasePath(), defaultTargetModel, new ResourceSetImpl(), transformationConfig.getConsoleStream());

		/*
		 * Initialize the TargetSectionConnector
		 */
		targetSectionConnector = new TargetSectionConnector(
				expandingResult.getTargetSectionRegistry(),
				attributeValueModifier, targetModelRegistry, transformationConfig.getMaxPathLength(),
				transformationConfig.getAmbiguityResolvingStrategy(), transformationConfig.getConsoleStream());
		objectsToCancel.add(targetSectionConnector);

		/*
		 * Connect all target sections
		 */
		boolean joiningResult = suitableMappings.stream().allMatch(
				m -> targetSectionConnector.joinTargetSections(m, matchingResult.getSelectedMappingsByMapping().get(m), expandingResult.getTargetSectionRegistry()));
		
		if(!joiningResult) {
			writePamtramMessage(TRANSFORMATION_ABORTED_MESSAGE);
			return JoiningResult.createJoiningCanceledResult();
		}

		// Finally, combine the Sections that are still unlinked with the 
		// Root element of a TargetModel
		//
		targetSectionConnector.combineUnlinkedSectionsWithTargetModelRoot();
		
		// Used to update the monitor.
		//
		monitor.worked(250);
		
		
		if (targetSectionConnector.isCanceled()) {
			writePamtramMessage(TRANSFORMATION_ABORTED_MESSAGE);
			return JoiningResult.createJoiningCanceledResult();
		} else {
			return JoiningResult.createJoiningCompletedResult(targetModelRegistry);
		}

	}

	/**
	 * This performs the '<em>linking</em>' step of the transformation:
	 * Necessary cross references between the created target sections are instantiated.
	 *
	 * @param matchingResult A {@link MatchingResult} that contains the results from the 
	 * {@link #performMatching(EObject, List, AttributeValueModifierExecutor, IProgressMonitor) matching} step.
	 * @param expandingResult The {@link TargetSectionInstantiator} that was used to expand the target sections.
	 * @param attributeValueModifier 
	 * @param monitor An {@link IProgressMonitor} that shall be used to report the progress of the transformation.
	 * @return '<em><b>true</b></em>' if everything went well, '<em><b>false</b></em>' otherwise.
	 */
	private boolean performLinking(
			final MatchingResult matchingResult,
			final ExpandingResult expandingResult,
			AttributeValueModifierExecutor attributeValueModifier, final IProgressMonitor monitor) {

		writePamtramMessage("Instantiating targetModelSections for selected mappings. Second pass");
		monitor.subTask("Instantiating targetModelSections for selected mappings. Second pass");

		/*
		 * Initialize the TargetSectionLinker
		 */
		targetSectionLinker = new TargetSectionLinker(
				expandingResult.getTargetSectionRegistry(),
				matchingResult.getGlobalValues().getGlobalValuesAsDouble(), 
				expandingResult.getLibEntryInstantiatorMap(),
				attributeValueModifier, transformationConfig.getConsoleStream(), transformationConfig.getAmbiguityResolvingStrategy());
		objectsToCancel.add(targetSectionLinker);
		
		/*
		 * Link all target sections
		 */
		boolean linkingResult = matchingResult.getSelectedMappings().stream().allMatch(
				targetSectionLinker::linkTargetSectionInstance);
		
		if(!linkingResult) {
			writePamtramMessage(TRANSFORMATION_ABORTED_MESSAGE);
			return false;
		}
		
		// Used to update the monitor.
		//
		monitor.worked(250);

		return true;
	}

	/**
	 * This performs the final step of the transformation:
	 * The stored library entries are finally instantiated in the target model.
	 * 
	 * @param targetModelRegistry The {@link TargetModelRegistry} representing the target models in which the 
	 * library entries are to be instantiated.
	 * @param monitor 
	 * @return <em>true</em> if everything went well, <em>false</em> otherwise.
	 */
	private boolean performInstantiatingLibraryEntries(MatchingResult matchingResult, ExpandingResult expandingResult, AttributeValueModifierExecutor attributeValueModifier, IProgressMonitor monitor) {

		writePamtramMessage("Instantiating libraryEntries for selected mappings.");
		monitor.subTask("Instantiating libraryEntries for selected mappings.");
		
		if(expandingResult.getLibEntryInstantiatorMap().isEmpty()) { // nothing to be done
			return true;
		}

		if(transformationConfig.getTargetLibraryContextDescriptor().getLibraryContextClass() == null) {
			transformationConfig.getConsoleStream().println("Could not instantiate library entries as no target"
					+ " library context class has been specified!");
			return false;
		}

		/*
		 * Create a GenLibraryManager that proxies calls to the LibraryPlugin. 
		 */
		GenLibraryManager manager;
		try {
			manager = new GenLibraryManager(transformationConfig.getTargetLibraryContextDescriptor());
			
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			transformationConfig.getConsoleStream().println("Error while instantiatiating library context/parser!");
			return false;
		}

		List<LibraryEntryInstantiator> libEntryInstantiators = expandingResult.getLibEntryInstantiatorMap().entrySet().parallelStream()
				.map(e -> e.getValue()).collect(Collectors.toList());
		Map<String, Double> globalDoubleValues = matchingResult.getGlobalValues().getGlobalValuesAsDouble().entrySet().parallelStream().collect(
				Collectors.toMap(e -> e.getKey().getName(), e -> e.getValue()));

		AttributeValueCalculator calculator = new AttributeValueCalculator(globalDoubleValues, attributeValueModifier, transformationConfig.getConsoleStream());
		
		/*
		 * Iterate over all stored instantiators and instantiate the associated library entry
		 * in the given target model.
		 */
		return libEntryInstantiators.stream().allMatch(libraryEntryInstantiator ->{
			
			boolean successful = libraryEntryInstantiator.instantiate(
					manager, calculator, 
					expandingResult.getTargetSectionRegistry());
			if(!successful) {
				transformationConfig.getConsoleStream().println("Failed to instantiate library entry '" + 
						libraryEntryInstantiator.getLibraryEntry().getPath().getValue() + "'!");
			}
			return successful;
		});
		
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
	public Map<SourceSectionClass, Set<EObject>> matchSourceSections() {

		if(transformationConfig.getPamtramModel() == null || transformationConfig.getSourceModels() == null 
				|| transformationConfig.getSourceModels().isEmpty()) {
			return null;
		}

		writePamtramMessage("Matching SourceSections");

		/* 
		 * Before we can use the PAMTraM model, we need merge all extended HintGroups or Sections;
		 * that way, we get a 'clean' model (without any extensions) that we can handle in a normal way
		 */
		transformationConfig.getPamtramModel().mergeExtends();

		/*
		 * Build the ContainmentTree representing the source model. This will keep track of all matched
		 * and unmatched elements.
		 */
		final ContainmentTree containmentTree = ContainmentTree.build(transformationConfig.getSourceModels());

		// Select the SourceSections that we want to match.
		// contained in active hint groups?
		List<SourceSection> activeSourceSections = transformationConfig.getPamtramModel().getSourceSections().parallelStream().
				filter(s -> !s.isAbstract()).collect(Collectors.toList());

		/*
		 * Create the SourceSectionMatcher that matches SourceSections
		 */
		final SourceSectionMatcher sourceSectionMatcher = new SourceSectionMatcher(
				containmentTree, new BasicEList<>(activeSourceSections), transformationConfig.getConsoleStream());

		Map<SourceSection, List<MatchedSectionDescriptor>> matchingResult = sourceSectionMatcher.matchSections();

		// Retrieve the list of all created MatchedSectionDescriptors
		//
		List<MatchedSectionDescriptor> descriptors = 
				matchingResult.values().parallelStream().flatMap(e -> e.parallelStream()).collect(Collectors.toList());

		Map<SourceSectionClass, Set<EObject>> matchedClasses = new HashMap<>();

		descriptors.stream().forEach(d -> {
			d.getSourceModelObjectsMapped().entrySet().stream().forEach(e -> {

				if(matchedClasses.containsKey(e.getKey())) {
					matchedClasses.get(e.getKey()).addAll(e.getValue());
				} else {
					matchedClasses.put(e.getKey(), e.getValue());
				}
			});
		});

		writePamtramMessage("Complete");

		return matchedClasses;

	}

	/**
	 * This populates the contents of the {@link #transformationModel} and stores it to the path denoted by 
	 * {@link #transformationModelPath}.
	 * <p/>
	 * <b>Note:</b> If {@link #transformationModelPath} is set to '<em>null</em>', this does nothing.
	 * 
	 * @return '<em><b>true</b></em>' if the resource has successfully been created, '<em><b>false</b></em>' otherwise.
	 */
	private boolean generateTransformationModel() {

		/*
		 * nothing to be done
		 */
		if(transformationConfig.getTransformationModelPath() == null) {
			return false;
		}

		/*
		 * populate the transformation model
		 */
		this.transformationModel.setPamtramInstance(transformationConfig.getPamtramModel()); // add pamtram model
		for (TargetSectionModel targetSectionModel : transformationConfig.getPamtramModel().getTargetSectionModel()) { // add (external) library entries
			for (LibraryEntry libEntry : targetSectionModel.getLibraryElements()) {
				this.transformationModel.getLibraryEntries().add(libEntry.getOriginalLibraryEntry());
			}
		}
		this.transformationModel.getSourceModels().addAll(transformationConfig.getSourceModels()); // add source models
		for (List<EObject> targetModelElements : // add target models
			transformationResult.getJoiningResult().getTargetModelRegistry().getTargetModels().values()) {
			this.transformationModel.getTargetModels().addAll(targetModelElements);
		}
		if(this.transformationResult.getMatchingResult() == null) {
			return false;
		}

		/*
		 * Iterate over all selected mappings
		 */
		for (final MappingInstanceStorage selMap : this.transformationResult.getMatchingResult().getSelectedMappings()) {

			/*
			 * Create a TransformationMapping for the mapping
			 */
			TransformationMapping transformationMapping = TransformationFactory.eINSTANCE.createTransformationMapping();
			transformationMapping.setAssociatedMapping(selMap.getMapping());
			transformationMapping.setSourceElement(selMap.getAssociatedSourceModelElement());
			this.transformationModel.getTransformationMappings().add(transformationMapping);

			/*
			 * Create a TransformationMappingHintGroup for each mapping hint group
			 */
			{
				/*
				 * Iterate over all mapping hint group (except inactive and empty ones)
				 */
				for (final MappingHintGroupType g : selMap.getMapping().getActiveMappingHintGroups()) {
					if (g.getTargetMMSection() != null && g instanceof InstantiableMappingHintGroup) {

						/*
						 * Create a TransformationMappingHintGroup for the mapping hint group
						 */
						TransformationMappingHintGroup transformationMappingHintGroup = TransformationFactory.eINSTANCE.createTransformationMappingHintGroup();
						transformationMappingHintGroup.setAssociatedMappingHintGroup((InstantiableMappingHintGroup) g);
						for (EObjectWrapper instance : selMap.getInstancesBySection((InstantiableMappingHintGroup) g).get(g.getTargetMMSection())) {
							transformationMappingHintGroup.getTargetElements().add(instance.getEObject());
						}					
						transformationMapping.getTransformationHintGroups().add(transformationMappingHintGroup);
					}
				}
				for (final MappingHintGroupImporter g : selMap.getMapping().getActiveImportedMappingHintGroups()) {
					if (g.getHintGroup() != null && g.getHintGroup().getTargetMMSection() != null) {

						/*
						 * Create a TransformationMappingHintGroup for the mapping hint group
						 */
						TransformationMappingHintGroup transformationMappingHintGroup = TransformationFactory.eINSTANCE.createTransformationMappingHintGroup();
						transformationMappingHintGroup.setAssociatedMappingHintGroup(g);
						for (EObjectWrapper instance : selMap.getInstancesBySection(g).get(g.getHintGroup().getTargetMMSection())) {
							transformationMappingHintGroup.getTargetElements().add(instance.getEObject());
						}					
						transformationMapping.getTransformationHintGroups().add(transformationMappingHintGroup);
					}
				}
			}
		}

		/*
		 * save the transformation model and create copies of all referenced resources
		 */
		final XMIResourceFactoryImpl resFactory = new XMIResourceFactoryImpl();
		final URI transformationModelUri = URI.createPlatformResourceURI(transformationConfig.getTransformationModelPath(), true);
		final URI transformationFolderUri = transformationModelUri.trimSegments(1);
		final Map<Object, Object> options = new LinkedHashMap<>();
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE); // suppress 'document root' element in case of xml models

		try {

			/*
			 * copy the library entries
			 */
			for (de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry libraryEntry : this.transformationModel.getLibraryEntries()) {
				URI libEntryUri = transformationFolderUri.
						appendSegment(libraryEntry.eResource().getURI().trimSegments(1).lastSegment()).
						appendSegment(libraryEntry.eResource().getURI().lastSegment());
				XMIResource libEntryResource = (XMIResource) resFactory.createResource(libEntryUri);
				libEntryResource.getContents().add(libraryEntry);
				libEntryResource.save(options);
			}

			/*
			 * copy the pamtram instance
			 */
			XMIResource pamtramModelResource = (XMIResource) resFactory.createResource(transformationFolderUri.appendSegment(this.transformationModel.getPamtramInstance().eResource().getURI().lastSegment()));
			pamtramModelResource.getContents().add(this.transformationModel.getPamtramInstance());
			pamtramModelResource.save(options);

			/*
			 * copy the source models
			 */
			for (EObject sourceModel : this.transformationModel.getSourceModels()) {
				XMLResource sourceModelResource = (XMLResource) resFactory.createResource(transformationFolderUri.appendSegment(sourceModel.eResource().getURI().lastSegment()));
				sourceModelResource.getContents().add(sourceModel);
				sourceModelResource.save(options);
			}

			/*
			 * copy the target models
			 */
			final ResourceSetImpl targetResourceSet = new ResourceSetImpl();
			for (EObject targetModel : this.transformationModel.getTargetModels()) {

				/*
				 * As multiple target models can be contained in the same resource, we first check if there already exists
				 * a resource for the target model. Only if no resource exists, we create a new one.
				 */
				URI targetModelUri = transformationFolderUri.appendSegment(targetModel.eResource().getURI().lastSegment());
				XMLResource targetModelResource = null;
				try {
					targetModelResource = (XMIResource) targetResourceSet.getResource(targetModelUri, false);
					targetModelResource.load(Collections.EMPTY_MAP);
				} catch (Exception e) {
					targetModelResource = (XMIResource) targetResourceSet.createResource(targetModelUri);
				}
				targetModelResource.getContents().add(targetModel);
			}
			// save all target model resources
			for (Resource targetModelResource : targetResourceSet.getResources()) {
				targetModelResource.save(options);				
			}

			/*
			 * save the transformation model
			 */
			XMIResource transformationModelResource = (XMIResource) resFactory.createResource(transformationModelUri);
			transformationModelResource.getContents().add(this.transformationModel);
			transformationModelResource.setEncoding("UTF-8");
			transformationModelResource.save(options);

		} catch (final Exception e) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error",
					"The XMI resource for the TransformationModel could not be created.");
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Writes a message on the console that helps to divide the transformation
	 * output into different stages of the transformation
	 *
	 * @param msg The message to be printed to the console
	 */
	private void writePamtramMessage(final String msg) {
		transformationConfig.getConsoleStream().println("\n################# " + msg + " #################\n");
	}

	/**
	 * This class encapsulates the results of the various steps performed during a generic transformation:
	 * <br />
	 * <ul>
	 * 	<li> a {@link MatchingResult} containing the results of the <em>matching</em> process,</li>
	 * 	<li> an {@link ExpandingResult} containing the results of the <em>expanding</em> process,</li>
	 *  <li> a boolean indicating the result of the <em>joining</em> process,</li>
	 *  <li> a boolean indicating the result of the <em>linking</em> process, and</li>
	 *  <li> a boolean indicating the result of the <em>library entry expanding</em> process.</li>
	 * </ul>
	 * 
	 * @author mfreund
	 */
	public static class TransformationResult {

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
			private final List<MappingInstanceStorage> selectedMappings;

			/**
			 * This is the getter for the {@link #selectedMappings}.
			 * @return The list of {@link MappingInstanceStorage mappings} that have been selected during the <em>matching</em>
			 * process.
			 */
			List<MappingInstanceStorage> getSelectedMappings() {
				return this.selectedMappings;
			}

			/**
			 * This the map of {@link MappingInstanceStorage mappings} that have been selected during the <em>matching</em>
			 * process associated with the {@link Mapping} that they represent.
			 */
			private final Map<Mapping, List<MappingInstanceStorage>> selectedMappingsByMapping;

			/**
			 * This is the getter for the {@link #selectedMappingsByMapping}.
			 * @return The map of {@link MappingInstanceStorage mappings} that have been selected during the <em>matching</em>
			 * process associated with the {@link Mapping} that they represent. 
			 */
			Map<Mapping, List<MappingInstanceStorage>> getSelectedMappingsByMapping() {
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
			private final GlobalValueMap globalValues;

			/**
			 * This is the getter for the {@link #globalAttributeValues}.
			 * @return The map of values for global attributes associated with the {@link GlobalAttribute} that
			 * they represent.
			 */
			GlobalValueMap getGlobalValues() {
				return globalValues;
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
			 * @param libEntryInstantiatorMap2 
			 * @param globalAttributeValues The map of values for global attributes associated with the {@link GlobalAttribute} that
			 * they represent.
			 */
			private MatchingResult(
					boolean canceled,
					List<MappingInstanceStorage> selectedMappings, 
					Map<Mapping, List<MappingInstanceStorage>> selectedMappingsByMapping,
					HintValueStorage exportedMappingHints,
					GlobalValueMap globalValues) {
				this.canceled = canceled;
				this.selectedMappings = selectedMappings;
				this.selectedMappingsByMapping = selectedMappingsByMapping;
				this.exportedMappingHints = exportedMappingHints;
				this.globalValues = globalValues;
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
			 * @param globalValues The values of {@link GlobalAttribute GlobalAttributes} and {@link FixedValue FixedValues}.
			 * @return An instance of {@link MatchingResult} indicating that the matching has completed successfully.
			 */
			public static MatchingResult createMatchingCompletedResult(
					List<MappingInstanceStorage> selectedMappings, 
					Map<Mapping, List<MappingInstanceStorage>> selectedMappingsByMapping,
					HintValueStorage exportedMappingHints,
					GlobalValueMap globalValues) {
				
				return new MatchingResult(false, selectedMappings, selectedMappingsByMapping, exportedMappingHints, globalValues);
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
			private final Map<EObjectWrapper, LibraryEntryInstantiator> libEntryInstantiatorMap;

			/**
			 * This is the getter for the {@link #targetSectionRegistry}.
			 * return A {@link TargetSectionRegistry} containing/representing created target sections.
			 */
			TargetSectionRegistry getTargetSectionRegistry() {
				return targetSectionRegistry;
			}

			/**
			 * This is the getter for the {@link #libEntryInstantiatorMap}.
			 * 
			 * @return
			 */
			Map<EObjectWrapper, LibraryEntryInstantiator> getLibEntryInstantiatorMap() {
				return libEntryInstantiatorMap;
			}

			/**
			 * This constructs an instance for an expanding process.
			 * 
			 * @param attributeValueRegistry The {@link AttributeValueRegistry} containing registered attribute values.
			 * @param targetSectionRegistry The {@link TargetSectionRegistry} containing/representing created target sections.
			 */
			private ExpandingResult(
					AttributeValueRegistry attributeValueRegistry, 
					TargetSectionRegistry targetSectionRegistry,
					Map<EObjectWrapper, LibraryEntryInstantiator> libEntryInstantiatorMap) {

				this.attributeValueRegistry = attributeValueRegistry;
				this.targetSectionRegistry = targetSectionRegistry;
				this.libEntryInstantiatorMap = libEntryInstantiatorMap;
			}

			/**
			 * This constructs an instance for an expanding process.
			 * 
			 * @param attributeValueRegistry The {@link AttributeValueRegistry} containing registered attribute values.
			 * @param targetSectionRegistry The {@link TargetSectionRegistry} containing/representing created target sections.
			 * @param libEntryInstantiatorMap The temporarily created elements for LibraryEntries (represented by an {@link EObjectWrapper}) and
			 * their corresponding {@link LibraryEntryInstantiator}
			 * @return An instance of {@link ExpandingResult}.
			 */
			public static ExpandingResult createExpandingResult(
					AttributeValueRegistry attributeValueRegistry, 
					TargetSectionRegistry targetSectionRegistry,
					Map<EObjectWrapper, LibraryEntryInstantiator> libEntryInstantiatorMap) {

				return new ExpandingResult(attributeValueRegistry, targetSectionRegistry, libEntryInstantiatorMap); 
			}
		}

		/**
		 * This class encapsulates the various results of the <em>joining</em> process during a generic transformation:
		 * <br />
		 * <ul>
		 *  <li>the status of the matching process,</li>
		 *  <li>a {@link TargetModelRegistry} representing the target models to be created</li>
		 * </ul>
		 * @author mfreund
		 * 
		 */
		static class JoiningResult {

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
			 * The {@link TargetModelRegistry} representing the target models to be created.
			 */
			private TargetModelRegistry targetModelRegistry;

			/**
			 * This is the getter for the {@link #targetModelRegistry}.
			 * @return The {@link TargetModelRegistry} representing the target models to be created.
			 */
			TargetModelRegistry getTargetModelRegistry() {
				return targetModelRegistry;
			}

			/**
			 * This constructs an instance.
			 * 
			 * @param canceled '<em><b>true</b></em>' indicates that the joining process was canceled, '<em><b>false</b></em>' indicates that
			 * the joining process completed successfully.
			 * @param targetModelRegistry 
			 */
			private JoiningResult(
					boolean canceled,
					TargetModelRegistry targetModelRegistry) {
				this.canceled = canceled;
				this.targetModelRegistry = targetModelRegistry;
			}

			/**
			 * This constructs an instance for a joining process that has been canceled.
			 * @return An instance of {@link JoiningResult} indicating that the joining was canceled.
			 */
			public static JoiningResult createJoiningCanceledResult() {
				return new JoiningResult(true, null);
			}

			/**
			 * This constructs an instance for a joining process that has finished successfully.
			 * @param targetModelRegistry The {@link TargetModelRegistry} instance representing the target models
			 * to be created.
			 * @return An instance of {@link JoiningResult} indicating that the joining has completed successfully.
			 */
			public static JoiningResult createJoiningCompletedResult(
					TargetModelRegistry targetModelRegistry) {
				return new JoiningResult(false, targetModelRegistry);
			}
		}

		/**
		 * An instance of {@link MatchingResult} containing the results of the <em>matching</em> process.
		 */
		private MatchingResult matchingResult;

		/**
		 * An instance of {@link ExpandingResult} containing the results of the <em>expanding</em> process.
		 */
		private ExpandingResult expandingResult;

		/**
		 * An instance of {@link JoiningResult} indicating the result of the <em>joining</em> process.
		 */
		private JoiningResult joiningResult;

		/**
		 * A boolean indicating the result of the <em>linking</em> process.
		 */
		private boolean linkingResult;

		/**
		 * A boolean indicating the result of the <em>library entry expanding</em> process.
		 */
		private boolean libEntryExpandingResult;

		/**
		 * @return the matchingResult
		 */
		public MatchingResult getMatchingResult() {
			return matchingResult;
		}

		/**
		 * @param matchingResult the matchingResult to set
		 */
		public void setMatchingResult(MatchingResult matchingResult) {
			this.matchingResult = matchingResult;
		}

		/**
		 * @return the expandingResult
		 */
		public ExpandingResult getExpandingResult() {
			return expandingResult;
		}

		/**
		 * @param expandingResult the expandingResult to set
		 */
		public void setExpandingResult(ExpandingResult expandingResult) {
			this.expandingResult = expandingResult;
		}

		/**
		 * @return the joiningResult
		 */
		public JoiningResult getJoiningResult() {
			return joiningResult;
		}

		/**
		 * @param joiningResult the joiningResult to set
		 */
		public void setJoiningResult(JoiningResult joiningResult) {
			this.joiningResult = joiningResult;
		}

		/**
		 * @return the linkingResult
		 */
		public boolean isLinkingResult() {
			return linkingResult;
		}

		/**
		 * @param linkingResult the linkingResult to set
		 */
		public void setLinkingResult(boolean linkingResult) {
			this.linkingResult = linkingResult;
		}

		/**
		 * @return the libEntryExpandingResult
		 */
		public boolean isLibEntryExpandingResult() {
			return libEntryExpandingResult;
		}

		/**
		 * @param libEntryExpandingResult the libEntryExpandingResult to set
		 */
		public void setLibEntryExpandingResult(boolean libEntryExpandingResult) {
			this.libEntryExpandingResult = libEntryExpandingResult;
		}

		/**
		 * Returns the overall status of the transformation.
		 * 
		 * @return '<em><b>true</b></em>' if and only if every phase of the transformation completed successfully; '<em><b>false</b></em>' otherwise.
		 */
		public boolean getOverallResult() {
			if(getMatchingResult() == null || getMatchingResult().isCanceled()) {
				return false;
			} else if(getExpandingResult() == null) {
				return false;
			} else if(getJoiningResult() == null || getJoiningResult().isCanceled()) {
				return false;
			} else if(!isLinkingResult()) {
				return false;
			} else if(!isLibEntryExpandingResult()) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * A {@link MessageDialog} that informs about an error and asks the user whether he wants to 
	 * continue or to abort.
	 * 
	 * @author mfreund
	 */
	private static class ErrorDialog extends MessageDialog {

		private ErrorDialog(Shell parentShell, String dialogMessage) {
			super(parentShell, "Error", null, dialogMessage, MessageDialog.ERROR , new String[]{"Continue", "Abort"}, 0);
		}

		/**
		 * This creates and opens a dialog.
		 * 
		 * @param parentShell The parent shell of the dialog, or <code>null</code> if none.
		 * @param dialogMessage The message to display to the user.
		 * @return '<em><b>true</b></em>' if the user selected <em>Continue</em>, '<em><b>false</b></em>'
		 * if he selected <em>Abort</em>.
		 */
		public static boolean open(Shell parentShell, String dialogMessage) {
			ErrorDialog dialog = new ErrorDialog(parentShell, dialogMessage);
			return dialog.open() == 0;
		}
	}
}
