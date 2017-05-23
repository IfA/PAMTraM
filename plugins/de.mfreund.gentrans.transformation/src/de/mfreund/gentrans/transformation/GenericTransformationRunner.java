package de.mfreund.gentrans.transformation;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
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
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import de.mfreund.gentrans.transformation.GenericTransformationRunner.TransformationResult.ExpandingResult;
import de.mfreund.gentrans.transformation.GenericTransformationRunner.TransformationResult.JoiningResult;
import de.mfreund.gentrans.transformation.GenericTransformationRunner.TransformationResult.MatchingResult;
import de.mfreund.gentrans.transformation.calculation.AttributeValueCalculator;
import de.mfreund.gentrans.transformation.calculation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.ContainmentTree;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.HintValueStorage;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.expanding.TargetSectionConnector;
import de.mfreund.gentrans.transformation.expanding.TargetSectionInstantiator;
import de.mfreund.gentrans.transformation.expanding.TargetSectionLinker;
import de.mfreund.gentrans.transformation.library.LibraryEntryInstantiator;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.matching.GlobalAttributeValueExtractor;
import de.mfreund.gentrans.transformation.matching.HintValueExtractor;
import de.mfreund.gentrans.transformation.matching.MappingSelector;
import de.mfreund.gentrans.transformation.matching.SourceSectionMatcher;
import de.mfreund.gentrans.transformation.registries.AttributeValueRegistry;
import de.mfreund.gentrans.transformation.registries.TargetModelRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.DefaultAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.util.CancelableElement;
import de.mfreund.gentrans.transformation.util.ICancelable;
import de.mfreund.gentrans.transformation.util.MonitorWrapper;
import de.mfreund.pamtram.transformation.Transformation;
import de.mfreund.pamtram.transformation.TransformationFactory;
import de.mfreund.pamtram.transformation.TransformationMapping;
import de.mfreund.pamtram.transformation.TransformationMappingHintGroup;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.FixedValue;
import pamtram.PAMTraM;
import pamtram.TargetSectionModel;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;
import pamtram.util.GenLibraryManager;

/**
 * This class can be used to execute a generic transformation. It performs the
 * different phases of the transformation after calling
 * {@link #runTransformation(IProgressMonitor)}.
 * <p />
 * Instances need to be created via the
 * {@link GenericTransformationRunnerFactory}.
 *
 * @author mfreund
 */
public class GenericTransformationRunner extends CancelableElement {

	private static final String TRANSFORMATION_ABORTED_MESSAGE = "Transformation aborted.";

	/**
	 * This keeps track of objects that need to be canceled when the user
	 * requests an early termination of the transformation.
	 */
	private final List<ICancelable> objectsToCancel;

	/**
	 * The {@link TransformationConfiguration} providing the parameters for the
	 * transformation.
	 */
	private TransformationConfiguration transformationConfig;

	/**
	 * This is the {@link TargetSectionInstantiator} that can be used to create
	 * new target sections.
	 */
	private TargetSectionInstantiator targetSectionInstantiator;

	/**
	 * This is the {@link TargetSectionConnector} that can be used to connect
	 * target sections that have been created with the help of the
	 * {@link #targetSectionInstantiator}.
	 */
	private TargetSectionConnector targetSectionConnector;

	/**
	 * This is the {@link TargetSectionLinker} that can be used to link target
	 * sections.
	 */
	private TargetSectionLinker targetSectionLinker;

	/**
	 * This creates an instance based on the given
	 * {@link TransformationConfiguration}.
	 *
	 * @param config
	 *            The {@link TransformationConfiguration} specifying all
	 *            parameters necessary for the execution of the transformation.
	 */
	GenericTransformationRunner(TransformationConfiguration config) {

		super();
		this.transformationConfig = config;

		this.objectsToCancel = new LinkedList<>();
	}

	/**
	 * This performs the actual generic transformation. It loads all necessary
	 * models, executes the mappings defined in the PAMTraM model and stores the
	 * generated target model. All progress is reported to the given
	 * '<em>monitor</em>'.
	 *
	 * @param monitor
	 *            An {@link IProgressMonitor} that shall be used to display the
	 *            progress of the transformation. If '<em>null</em>' is passed
	 *            as argument, no monitor will be used.
	 */
	public void runTransformation(final IProgressMonitor monitor) {

		// create a wrapper for the monitor so that a 'null' argument does not
		// lead to errors
		//
		MonitorWrapper monitorWrapper = new MonitorWrapper(monitor);

		final Date startTime = new Date();

		monitorWrapper.beginTask("GenTrans", 1000);

		// prepare the transformation (validate pamtram model, merge extends,
		// etc.)
		//
		if (!this.prepare(this.transformationConfig)) {
			this.transformationConfig.getLogger().severe(GenericTransformationRunner.TRANSFORMATION_ABORTED_MESSAGE);
			return;
		}

		TransformationResult transformationResult;
		try {
			/*
			 * try to execute all active mappings (this includes the 4 resp. 5
			 * main steps of the transformation
			 */
			transformationResult = this.executeMappings(monitorWrapper);
		} catch (CancelTransformationException e1) {
			if (e1.getMessage() != null && !e1.getMessage().isEmpty()) {
				this.transformationConfig.getLogger().severe(() -> e1.getMessage());
			}
			this.transformationConfig.getLogger().severe("Aborting...");
			return;
		} catch (RuntimeException e) {
			if (e.getMessage() != null) {
				this.transformationConfig.getLogger().severe(() -> e.getMessage());
			} else {
				this.transformationConfig.getLogger().severe(() -> e.toString());
			}
			this.transformationConfig.getLogger().severe("Aborting...");
			throw e;
		}

		if (transformationResult != null && transformationResult.getOverallResult() && !this.isCanceled()) {

			this.writePamtramMessage("Storing target model(s).");
			monitor.subTask("Storing target model(s).");

			/*
			 * create the target models
			 */
			boolean result = transformationResult.getJoiningResult().getTargetModelRegistry().saveTargetModels();

			final Date endTime = new Date();
			this.writePamtramMessage(
					"Transformation done. Time: " + (endTime.getTime() - startTime.getTime()) / 1000d + "s");

			if (!result) {
				return;
			}

			/*
			 * populate and store the transformation model if necessary
			 */
			this.generateTransformationModel(this.transformationConfig, transformationResult, startTime, endTime);
		}

	}

	/**
	 * This is a temporary method that is called by the 'source section matcher
	 * page' in order to get the matched sections for a sample source model.
	 * Therefore, it performs half a transformation and then returns the matched
	 * section. This should be changed in the future e.g. by using the
	 * 'transformation model'.
	 *
	 * @return A map relating the matched SourceSectionClasses to the
	 *         {@link EObject elements} they have been matched against.
	 */
	@Deprecated
	public Map<SourceSectionClass, Set<EObject>> matchSourceSections() {

		// prepare the transformation (validate pamtram model, merge extends,
		// etc.)
		//
		if (!this.prepare(this.transformationConfig)) {
			this.transformationConfig.getLogger().severe(GenericTransformationRunner.TRANSFORMATION_ABORTED_MESSAGE);
			return null;
		}

		this.writePamtramMessage("Matching SourceSections");

		/*
		 * Build the ContainmentTree representing the source model. This will
		 * keep track of all matched and unmatched elements.
		 */
		final ContainmentTree containmentTree = ContainmentTree.build(this.transformationConfig.getSourceModels());

		// Select the SourceSections that we want to match.
		// contained in active hint groups?
		List<SourceSection> activeSourceSections = this.transformationConfig.getPamtramModels().stream()
				.flatMap(p -> p.getActiveSourceSections().stream()).filter(s -> !s.isAbstract())
				.collect(Collectors.toList());

		// Collect the global values modeled in the PAMTraM instance
		//
		Map<FixedValue, String> globalFixedValues = this.transformationConfig.getPamtramModels().stream()
				.flatMap(p -> p.getGlobalValues().stream())
				.collect(Collectors.toMap(Function.identity(), FixedValue::getValue));

		/*
		 * Create the SourceSectionMatcher that matches SourceSections
		 */
		final SourceSectionMatcher sourceSectionMatcher = new SourceSectionMatcher(containmentTree,
				new BasicEList<>(activeSourceSections), globalFixedValues,
				this.transformationConfig.getAmbiguityResolvingStrategy(), this.transformationConfig.getLogger(),
				this.transformationConfig.isUseParallelization());

		Map<SourceSection, List<MatchedSectionDescriptor>> matchingResult = sourceSectionMatcher.matchSections();

		// Retrieve the list of all created MatchedSectionDescriptors
		//
		List<MatchedSectionDescriptor> descriptors = matchingResult.values().parallelStream()
				.flatMap(e -> e.parallelStream()).collect(Collectors.toList());

		// Collect the matched class from all returned descriptors
		// (see
		// http://stackoverflow.com/questions/23038673/merging-two-mapstring-integer-with-java-8-stream-api)
		//
		Map<SourceSectionClass, Set<EObject>> matchedClasses = descriptors.parallelStream()
				.map(d -> d.getSourceModelObjectsMapped()).map(m -> m.entrySet()).flatMap(Collection::stream)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (i, j) -> {
					i.addAll(j);
					return i;
				}));

		this.writePamtramMessage("Complete");

		return matchedClasses;

	}

	/**
	 * This cancels any running (or future) transformation.
	 */
	@Override
	public void cancel() {

		super.cancel();
		this.objectsToCancel.parallelStream().forEach(ICancelable::cancel);
		throw new CancelTransformationException();
	}

	/**
	 * Prepare the transformation by {@link #validatePamtramModel(PAMTraM)
	 * validating} the {@link PAMTraM} model, {@link PAMTraM#mergeExtends()
	 * merging extends}, and initializing the {@link IAmbiguityResolvingStrategy
	 * ambiguityResolvingStrategy} to be used.
	 * <p />
	 * This should be called at least once before starting the actual
	 * transformation.
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} containing all
	 *            parameters necessary for the validation.
	 */
	private boolean prepare(TransformationConfiguration transformationConfig) {

		this.writePamtramMessage("Preparing transformation");

		// validate the TransformationConfiguration
		//
		if (!transformationConfig.validate()) {
			return false;
		}

		// validate the PAMTraM model
		//
		if (!this.validatePamtramModels(transformationConfig)) {
			return false;
		}

		// Before we can use the PAMTraM model, we need merge all extended
		// HintGroups or Sections.
		// That way, we get a 'clean' model (without any extensions) that we can
		// handle in a normal way
		//
		transformationConfig.getPamtramModels().stream().forEach(PAMTraM::mergeExtends);

		// Initialize the ambiguity resolving strategy
		//
		transformationConfig.getLogger().fine("\nInitializing ambiguity resolving strategy...");
		try {

			transformationConfig.getAmbiguityResolvingStrategy().init(transformationConfig.getPamtramModels(),
					transformationConfig.getSourceModels(), transformationConfig.getLogger());
			transformationConfig.getLogger().fine("Initialization successful!");

		} catch (Exception e1) {
			e1.printStackTrace();
			transformationConfig.getLogger()
					.warning("Internal error. Switching to DefaultAmbiguityResolvingStrategy...");
			transformationConfig.withAmbiguityResolvingStrategy(new DefaultAmbiguityResolvingStrategy());
		}

		return true;
	}

	/**
	 * This validates the given {@link PAMTraM} models using the
	 * {@link Diagnostician}. If errors occur, the user is asked whether to
	 * proceed anyway.
	 *
	 * @param transformationConfiguration
	 *            The {@link TransformationConfiguration} specifying the
	 *            {@link PAMTraM} models to validate.
	 * @return '<em><b>true</b></em>' if the validation succeeded or if the user
	 *         chose to ignore errors; '<em><b>false/b></em>' otherwise.
	 */
	private boolean validatePamtramModels(TransformationConfiguration transformationConfiguration) {

		transformationConfiguration.getLogger().fine("\nValiding PAMTraM models...");

		Set<Integer> diags = transformationConfiguration.getPamtramModels().stream()
				.map(pamtramModel -> Diagnostician.INSTANCE.validate(pamtramModel).getSeverity())
				.collect(Collectors.toSet());

		if (diags.contains(Diagnostic.ERROR)) {
			final AtomicBoolean result = new AtomicBoolean();

			transformationConfiguration.getLogger().fine("Validation completed with errors!");

			Display.getDefault().syncExec(
					() -> result.set(ErrorDialog.open(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
							"Errors exist in the specified PAMTraM model. Continue anyway?")));

			if (!result.get()) {
				return false;
			}
		} else {
			transformationConfiguration.getLogger().fine("Validation successful!");
		}

		return true;
	}

	/**
	 * This performs the actual execution of the transformation. In the course
	 * of this method, the four main steps of the transformation get executed.
	 *
	 * @param monitor
	 *            The {@link IProgressMonitor monitor} that shall be used to
	 *            visualize the progress of the transformation.
	 * @return '<em><b>true</b></em>' if the transformation was performed
	 *         successfully, '<em><b>false</b></em>' otherwise
	 */
	private TransformationResult executeMappings(final IProgressMonitor monitor) {

		// The TransformationResult that we will return in the end.
		//
		TransformationResult transformationResult = new TransformationResult();

		// The list of active mappings defined in the PAMTraM model
		//
		final List<Mapping> suitableMappings = this.transformationConfig.getPamtramModels().stream()
				.flatMap(p -> p.getActiveMappings().stream()).collect(Collectors.toList());

		// generate storage objects and generators
		final AttributeValueModifierExecutor attributeValueModifier = AttributeValueModifierExecutor
				.init(this.transformationConfig.getLogger());

		/*
		 * Perform the 'matching' step of the transformation
		 */
		MatchingResult matchingResult = this.performMatching(this.transformationConfig.getSourceModels(),
				suitableMappings, attributeValueModifier, monitor);
		transformationResult.setMatchingResult(matchingResult);

		if (matchingResult.isCanceled()) {
			return transformationResult;
		}

		/*
		 * Perform the 'expanding' step of the transformation
		 */
		ExpandingResult expandingResult = this.performInstantiating(matchingResult, monitor, attributeValueModifier);
		transformationResult.setExpandingResult(expandingResult);

		/*
		 * Perform the 'joining' step of the transformation
		 */
		JoiningResult joiningResult = this.performJoining(this.transformationConfig.getDefaultTargetModel(),
				suitableMappings, expandingResult, attributeValueModifier, matchingResult, monitor);
		transformationResult.setJoiningResult(joiningResult);

		if (joiningResult.isCanceled()) {
			return transformationResult;
		}

		/*
		 * Perform the 'linking' step of the transformation
		 */
		boolean linkingResult = this.performLinking(matchingResult, expandingResult, attributeValueModifier, monitor);
		transformationResult.setLinkingResult(linkingResult);

		if (!linkingResult) {
			return transformationResult;
		}

		/*
		 * Finally, instantiate the collected library entries in the target
		 * model.
		 */
		if (joiningResult.getTargetModelRegistry().isEmpty()) {
			this.transformationConfig.getLogger().warning("Something seems to be wrong! Target model is empty!");
		} else {
			boolean libEntryExpandingResult = this.performInstantiatingLibraryEntries(matchingResult, expandingResult,
					attributeValueModifier, monitor);
			transformationResult.setLibEntryExpandingResult(libEntryExpandingResult);
		}
		return transformationResult;

	}

	/**
	 * This performs the '<em>matching</em>' step of the transformation.
	 * Therefore, it iterates through the given list of '<em>sourceModels</em>',
	 * {@link SourceSectionMatcher#matchSections() matches SourceSections},
	 * {@link MappingSelector#selectMappings() selects mappings} and
	 * {@link HintValueExtractor#extractHintValues() extracts hint values}.
	 *
	 * @param sourceModels
	 *            The list of {@link EObject EObjects} representing/containing
	 *            the source model to be matched.
	 * @param suitableMappings
	 *            A list of {@link Mapping Mappings} that shall be used for the
	 *            matching process.
	 * @param attributeValueModifier
	 *            An instance of {@link AttributeValueModifierExecutor} that
	 *            shall be used to apply {@link ValueModifierSet
	 *            AttributeValueModifierSets} in order to obtain hint values.
	 * @param monitor
	 *            An {@link IProgressMonitor} that shall be used to report the
	 *            progress of the transformation.
	 * @return A {@link MatchingResult} that contains the various results of the
	 *         matching.
	 */
	private MatchingResult performMatching(List<EObject> sourceModels, List<Mapping> suitableMappings,
			AttributeValueModifierExecutor attributeValueModifier, IProgressMonitor monitor) {

		LinkedList<MappingInstanceStorage> selectedMappings;
		Map<Mapping, List<MappingInstanceStorage>> selectedMappingsByMapping;

		/*
		 * Build the ContainmentTree representing the source model. This will
		 * keep track of all matched and unmatched elements.
		 */
		this.writePamtramMessage("Matching SourceSections");
		monitor.subTask("Matching SourceSections");
		final ContainmentTree containmentTree = ContainmentTree.build(sourceModels);

		// Select the SourceSections that we want to match.
		// contained in active hint groups?
		List<SourceSection> activeSourceSections = this.transformationConfig.getPamtramModels().stream()
				.flatMap(p -> p.getActiveSourceSections().stream()).filter(s -> !s.isAbstract())
				.collect(Collectors.toList());

		// Collect the global values modeled in the PAMTraM instance
		//
		Map<FixedValue, String> globalFixedValues = this.transformationConfig.getPamtramModels().stream()
				.flatMap(p -> p.getGlobalValues().stream())
				.collect(Collectors.toMap(Function.identity(), FixedValue::getValue));

		/*
		 * Create the SourceSectionMatcher that matches SourceSections
		 */
		final SourceSectionMatcher sourceSectionMatcher = new SourceSectionMatcher(containmentTree,
				new BasicEList<>(activeSourceSections), globalFixedValues,
				this.transformationConfig.getAmbiguityResolvingStrategy(), this.transformationConfig.getLogger(),
				this.transformationConfig.isUseParallelization());

		this.objectsToCancel.add(sourceSectionMatcher);

		Map<SourceSection, List<MatchedSectionDescriptor>> matchingResult = sourceSectionMatcher.matchSections();

		this.transformationConfig.getLogger()
				.info(() -> "Summary:\tAvailable Elements:\t" + containmentTree.getNumberOfElements());
		this.transformationConfig.getLogger()
				.info(() -> "\t\tMatched Elements:\t" + containmentTree.getNumberOfMatchedElements());
		this.transformationConfig.getLogger()
				.info(() -> "\t\tUnmatched Elements:\t" + containmentTree.getNumberOfUnmatchedElements());

		this.writePamtramMessage("Extracting Values of Global Attributes");

		/*
		 * Create the GlobalAttributeValueExtractor that extracts values of
		 * GlobalAttributes
		 */
		GlobalAttributeValueExtractor globalAttributeValueExtractor = new GlobalAttributeValueExtractor(
				attributeValueModifier, this.transformationConfig.getLogger(),
				this.transformationConfig.isUseParallelization());
		Map<GlobalAttribute, String> globalAttributeValues = globalAttributeValueExtractor
				.extractGlobalAttributeValues(matchingResult, this.transformationConfig.getPamtramModels().stream()
						.flatMap(p -> p.getMappingModels().stream()).collect(Collectors.toList()));

		// Collect the values of FixedValues and GlobalAttributes in a common
		// map that will be passed to consumers
		//
		GlobalValueMap globalValues = new GlobalValueMap(globalFixedValues, globalAttributeValues);

		this.writePamtramMessage("Selecting Mappings for Matched Sections");

		AttributeValueCalculator calculator = new AttributeValueCalculator(globalValues, attributeValueModifier,
				this.transformationConfig.getLogger());

		/*
		 * Create the MappingSelector that finds applicable mappings
		 */
		final MappingSelector mappingSelector = new MappingSelector(matchingResult, suitableMappings, globalValues,
				this.transformationConfig.isOnlyAskOnceOnAmbiguousMappings(),
				this.transformationConfig.getAmbiguityResolvingStrategy(), calculator,
				this.transformationConfig.getLogger(), this.transformationConfig.isUseParallelization());

		selectedMappingsByMapping = mappingSelector.selectMappings();
		List<MappingInstanceStorage> mappingInstances = selectedMappingsByMapping.values().stream()
				.flatMap(l -> l.stream()).collect(Collectors.toList());

		this.writePamtramMessage("Extracting Hint Values");

		/*
		 * Calculate mapping hints
		 */
		final HintValueExtractor hintValueExtractor = new HintValueExtractor(matchingResult, mappingInstances,
				globalValues.getGlobalAttributes(), attributeValueModifier, this.transformationConfig.getLogger(),
				this.transformationConfig.isUseParallelization());

		this.objectsToCancel.add(hintValueExtractor);

		hintValueExtractor.extractHintValues();

		selectedMappings = new LinkedList<>((this.transformationConfig.isUseParallelization()
				? selectedMappingsByMapping.entrySet().parallelStream() : selectedMappingsByMapping.entrySet().stream())
						.flatMap(e -> e.getValue().stream()).collect(Collectors.toList()));

		return MatchingResult.createMatchingCompletedResult(selectedMappings, selectedMappingsByMapping,
				new HintValueStorage(this.transformationConfig.isUseParallelization()), globalValues);

	}

	/**
	 * This performs the '<em>instantiating</em>' step of the transformation:
	 * The target sections (excluding those that are defined by
	 * {@link LibraryEntry LibraryEntries}) are instantiated (only containment
	 * references and attributes but no non-containment references).
	 *
	 * @param matchingResult
	 *            A {@link MatchingResult} that contains the results from the
	 *            {@link #performMatching(EObject, List, AttributeValueModifierExecutor, IProgressMonitor)
	 *            matching} step.
	 * @param monitor
	 *            An {@link IProgressMonitor} that shall be used to report the
	 *            progress of the transformation.
	 * @param attributeValuemodifier
	 *            An instance of {@link AttributeValueModifierExecutor} to use
	 *            for applying {@link ValueModifierSet
	 *            AttributeValueModifierSets}.
	 * @return An {@link ExpandingResult} that contains the various results of
	 *         the expanding step.
	 */
	private ExpandingResult performInstantiating(final MatchingResult matchingResult, final IProgressMonitor monitor,
			final AttributeValueModifierExecutor attributeValuemodifier) {

		final AttributeValueRegistry attrValueRegistry = new AttributeValueRegistry();

		/*
		 * Instantiate TargetSectionRegistry, analyzes target-metamodel
		 */
		monitor.subTask("Instantiating targetModelSections for selected mappings. First pass");
		this.writePamtramMessage("Analyzing target metamodel(s)");
		final TargetSectionRegistry targetSectionRegistry = new TargetSectionRegistry(
				this.transformationConfig.getLogger(), attrValueRegistry,
				new LinkedHashSet<>(this.transformationConfig.getPamtramModels().stream()
						.flatMap(p -> p.getTargetSectionModels().stream()).map(TargetSectionModel::getMetaModelPackage)
						.collect(Collectors.toList())));
		this.objectsToCancel.add(targetSectionRegistry);

		this.writePamtramMessage("Instantiating TargetSections for Selected Mappings");

		/*
		 * Initialize the TargetSectionInstantiator
		 */
		this.targetSectionInstantiator = new TargetSectionInstantiator(targetSectionRegistry, attrValueRegistry,
				matchingResult.getGlobalValues(), attributeValuemodifier, this.transformationConfig.getLogger(),
				this.transformationConfig.getAmbiguityResolvingStrategy(),
				this.transformationConfig.isUseParallelization());
		this.objectsToCancel.add(this.targetSectionInstantiator);

		this.transformationConfig.getLogger().info(
				() -> "Instantiating " + matchingResult.getSelectedMappings().size() + " TargetSection instances...");

		// Iterate over all selected mapping instances and expand them
		//
		matchingResult.getSelectedMappings().stream()
				.forEach(this.targetSectionInstantiator::expandTargetSectionInstance);

		// Used to update the monitor.
		//
		monitor.worked(250);

		return ExpandingResult.createExpandingResult(attrValueRegistry, targetSectionRegistry,
				this.targetSectionInstantiator.getLibEntryInstantiatorMap());
	}

	/**
	 * This performs the '<em>joining</em>' step of the transformation: The
	 * target sections that have been instantiated during the
	 * {@link #performInstantiating(MatchingResult, IProgressMonitor, AttributeValueModifierExecutor)
	 * expanding step} are linked via containment references and added to the
	 * target model. If necessary, intermediary object are created as well.
	 *
	 * @param defaultTargetModel
	 *            File path of the <em>default</em> target model (relative to
	 *            the {@link #targetBasePath}).
	 * @param suitableMappings
	 *            The active {@link Mapping mappings} from the PAMTraM model.
	 * @param expandingResult
	 *            The {@link ExpandingResult} that contains the results of the
	 *            {@link #performInstantiating(MatchingResult, IProgressMonitor, AttributeValueModifierExecutor)
	 *            expanding step}.
	 * @param attributeValueModifier
	 *            An instance of {@link AttributeValueModifierExecutor} to use
	 *            for applying {@link ValueModifierSet
	 *            AttributeValueModifierSets}.
	 * @param matchingResult
	 *            A {@link MatchingResult} that contains the results from the
	 *            {@link #performMatching(EObject, List, AttributeValueModifierExecutor, IProgressMonitor)
	 *            matching} step.
	 * @param monitor
	 *            An {@link IProgressMonitor} that shall be used to report the
	 *            progress of the transformation.
	 * @return A {@link JoiningResult} representing the result of the joining
	 *         step.
	 */
	private JoiningResult performJoining(final String defaultTargetModel, final List<Mapping> suitableMappings,
			final ExpandingResult expandingResult, final AttributeValueModifierExecutor attributeValueModifier,
			final MatchingResult matchingResult, final IProgressMonitor monitor) {

		this.writePamtramMessage("Joining Instantiated TargetSections");
		monitor.subTask("Joining Instantiated TargetSections");

		/*
		 * The TargetModelRegistry that will be returned at the end as part of
		 * the 'JoiningResult'.
		 */
		TargetModelRegistry targetModelRegistry = new TargetModelRegistry(this.transformationConfig.getTargetBasePath(),
				defaultTargetModel, new ResourceSetImpl(), this.transformationConfig.getLogger());

		/*
		 * Initialize the TargetSectionConnector
		 */
		this.targetSectionConnector = new TargetSectionConnector(expandingResult.getTargetSectionRegistry(),
				attributeValueModifier, targetModelRegistry, this.transformationConfig.getMaxPathLength(),
				this.transformationConfig.getAmbiguityResolvingStrategy(), this.transformationConfig.getLogger());
		this.objectsToCancel.add(this.targetSectionConnector);

		/*
		 * Connect all target sections
		 */
		boolean joiningResult = suitableMappings.stream()
				.filter(m -> matchingResult.getSelectedMappingsByMapping().get(m) != null)
				.allMatch(m -> this.targetSectionConnector.joinTargetSections(m,
						matchingResult.getSelectedMappingsByMapping().get(m),
						expandingResult.getTargetSectionRegistry()));

		if (!joiningResult) {
			this.writePamtramMessage(GenericTransformationRunner.TRANSFORMATION_ABORTED_MESSAGE);
			return JoiningResult.createJoiningCanceledResult();
		}

		// Finally, combine the Sections that are still unlinked with the
		// Root element of a TargetModel
		//
		this.targetSectionConnector.combineUnlinkedSectionsWithTargetModelRoot();

		// Used to update the monitor.
		//
		monitor.worked(250);

		if (this.targetSectionConnector.isCanceled()) {
			this.writePamtramMessage(GenericTransformationRunner.TRANSFORMATION_ABORTED_MESSAGE);
			return JoiningResult.createJoiningCanceledResult();
		} else {
			return JoiningResult.createJoiningCompletedResult(targetModelRegistry);
		}

	}

	/**
	 * This performs the '<em>linking</em>' step of the transformation:
	 * Necessary cross references between the created target sections are
	 * instantiated.
	 *
	 * @param matchingResult
	 *            A {@link MatchingResult} that contains the results from the
	 *            {@link #performMatching(EObject, List, AttributeValueModifierExecutor, IProgressMonitor)
	 *            matching} step.
	 * @param expandingResult
	 *            The {@link TargetSectionInstantiator} that was used to expand
	 *            the target sections.
	 * @param attributeValueModifier
	 * @param monitor
	 *            An {@link IProgressMonitor} that shall be used to report the
	 *            progress of the transformation.
	 * @return '<em><b>true</b></em>' if everything went well,
	 *         '<em><b>false</b></em>' otherwise.
	 */
	private boolean performLinking(final MatchingResult matchingResult, final ExpandingResult expandingResult,
			AttributeValueModifierExecutor attributeValueModifier, final IProgressMonitor monitor) {

		this.writePamtramMessage("Linking Instantiated TargetSections");
		monitor.subTask("Linking Instantiated TargetSections");

		/*
		 * Initialize the TargetSectionLinker
		 */
		this.targetSectionLinker = new TargetSectionLinker(expandingResult.getTargetSectionRegistry(),
				matchingResult.getGlobalValues(), expandingResult.getLibEntryInstantiatorMap(), attributeValueModifier,
				this.transformationConfig.getLogger(), this.transformationConfig.getAmbiguityResolvingStrategy());
		this.objectsToCancel.add(this.targetSectionLinker);

		/*
		 * Link all target sections
		 */
		boolean linkingResult = matchingResult.getSelectedMappings().stream()
				.allMatch(this.targetSectionLinker::linkTargetSectionInstance);

		if (!linkingResult) {
			this.writePamtramMessage(GenericTransformationRunner.TRANSFORMATION_ABORTED_MESSAGE);
			return false;
		}

		// Used to update the monitor.
		//
		monitor.worked(250);

		return true;
	}

	/**
	 * This performs the final step of the transformation: The stored library
	 * entries are finally instantiated in the target model.
	 *
	 * @param targetModelRegistry
	 *            The {@link TargetModelRegistry} representing the target models
	 *            in which the library entries are to be instantiated.
	 * @param monitor
	 * @return <em>true</em> if everything went well, <em>false</em> otherwise.
	 */
	private boolean performInstantiatingLibraryEntries(MatchingResult matchingResult, ExpandingResult expandingResult,
			AttributeValueModifierExecutor attributeValueModifier, IProgressMonitor monitor) {

		this.writePamtramMessage("Instantiating LibraryEntries");
		monitor.subTask("Instantiating LibraryEntries");

		if (expandingResult.getLibEntryInstantiatorMap().isEmpty()) {
			return true;
		}

		this.transformationConfig.getLogger().fine(
				() -> "Instantiating " + expandingResult.getLibEntryInstantiatorMap().size() + " LibraryEntries...");

		/*
		 * Create a GenLibraryManager that proxies calls to the LibraryPlugin
		 * and register all libraries that are to be used in during the
		 * transformation.
		 */
		GenLibraryManager manager = new GenLibraryManager(this.transformationConfig.getLogger());
		this.transformationConfig.getLibPaths().stream().forEach(libPath -> {
			this.transformationConfig.getLogger().info(() -> "Registering library location '" + libPath + "'...");
			manager.addLibPath(libPath);
		});

		List<LibraryEntryInstantiator> libEntryInstantiators = (this.transformationConfig.isUseParallelization()
				? expandingResult.getLibEntryInstantiatorMap().entrySet().parallelStream()
				: expandingResult.getLibEntryInstantiatorMap().entrySet().stream()).map(Entry::getValue)
						.collect(Collectors.toList());
		AttributeValueCalculator calculator = new AttributeValueCalculator(matchingResult.getGlobalValues(),
				attributeValueModifier, this.transformationConfig.getLogger());

		/*
		 * Iterate over all stored instantiators and instantiate the associated
		 * library entry in the given target model.
		 */
		return libEntryInstantiators.stream().allMatch(libraryEntryInstantiator -> {

			boolean successful = libraryEntryInstantiator.instantiate(manager, calculator,
					expandingResult.getTargetSectionRegistry());
			if (!successful) {
				this.transformationConfig.getLogger().severe(() -> "Failed to instantiate library entry '"
						+ libraryEntryInstantiator.getLibraryEntry().getClasspath().getValue() + "'!");
			}
			return successful;
		});

	}

	/**
	 * This populates the contents of the {@link #transformationModel} and
	 * stores it to the path denoted by {@link #transformationModelPath}.
	 * <p/>
	 * <b>Note:</b> If
	 * {@link TransformationConfiguration#transformationModelPath} is set to
	 * '<em>null</em>', this does nothing.
	 *
	 * @param transformationConfiguration
	 *            The {@link TransformationConfiguration} providing all
	 *            parameters of the transformation.
	 * @param transformationResult
	 *            The {@link TransformationResult result} of the transformation.
	 * @param startTime
	 *            The {@link Date time} when the transformation started.
	 * @param endTime
	 *            The {@link Date time} when the transformation was finished.
	 *
	 * @return '<em><b>true</b></em>' if the resource has successfully been
	 *         created, '<em><b>false</b></em>' otherwise.
	 */
	private boolean generateTransformationModel(TransformationConfiguration transformationConfiguration,
			TransformationResult transformationResult, Date startTime, Date endTime) {

		// Check if we need to create a transformation model
		//
		if (this.transformationConfig.getTransformationModelPath() == null) {
			return false;
		}

		// Let the user specify a name for the transformation model
		//
		final AtomicReference<String> result = new AtomicReference<>();
		Display.getDefault().syncExec(() -> result.set(TransformationModelNameDialog.open(UIHelper.getShell())));

		String transformationModelName = result.get();
		if (transformationModelName == null) {
			return false;
		}

		// Create the TransformationModel
		//
		Transformation transformationModel = TransformationFactory.eINSTANCE.createTransformation();
		transformationModel.setId(Integer.toString(this.hashCode()));
		transformationModel.setStartDate(startTime);
		transformationModel.setEndDate(endTime);
		transformationModel.setName(transformationModelName);

		// Populate the transformation model with the participating models
		//
		transformationModel.getPamtramInstances().addAll( // add pamtram models
				this.transformationConfig.getPamtramModels());
		transformationModel.getLibraryEntries().addAll( // add library entries
				this.transformationConfig.getPamtramModels().stream()
						.flatMap(p -> p.getTargetSectionModels().stream().flatMap(t -> t.getLibraryElements().stream()))
						.map(LibraryEntry::getOriginalLibraryEntry).collect(Collectors.toList()));
		transformationModel.getSourceModels().addAll( // add source models
				this.transformationConfig.getSourceModels());
		transformationModel.getTargetModels().addAll( // add target models
				transformationResult.getJoiningResult().getTargetModelRegistry().getTargetModels().values().stream()
						.flatMap(Collection::stream).collect(Collectors.toList()));

		if (transformationResult.getMatchingResult() == null) {
			return false;
		}

		// Create the various TransformationMappings and
		// TransformationMappingHintGroups
		//
		for (final MappingInstanceStorage selMap : transformationResult.getMatchingResult().getSelectedMappings()) {

			/*
			 * Create a TransformationMapping for the mapping
			 */
			TransformationMapping transformationMapping = TransformationFactory.eINSTANCE.createTransformationMapping();
			transformationMapping.setAssociatedMapping(selMap.getMapping());
			transformationMapping.setSourceElement(selMap.getAssociatedSourceModelElement());
			transformationModel.getTransformationMappings().add(transformationMapping);

			/*
			 * Create a TransformationMappingHintGroup for each mapping hint
			 * group
			 */
			selMap.getMapping().getActiveMappingHintGroups().stream()
					.filter(g -> g.getTargetSection() != null && g instanceof InstantiableMappingHintGroup)
					.forEach(g -> {
						if (g.getTargetSection() != null && g instanceof InstantiableMappingHintGroup) {

							/*
							 * Create a TransformationMappingHintGroup for the
							 * mapping hint group
							 */
							TransformationMappingHintGroup transformationMappingHintGroup = TransformationFactory.eINSTANCE
									.createTransformationMappingHintGroup();
							transformationMappingHintGroup
									.setAssociatedMappingHintGroup((InstantiableMappingHintGroup) g);
							for (EObjectWrapper instance : selMap
									.getInstancesBySection((InstantiableMappingHintGroup) g)
									.get(g.getTargetSection())) {
								transformationMappingHintGroup.getTargetElements().add(instance.getEObject());
							}
							transformationMapping.getTransformationHintGroups().add(transformationMappingHintGroup);
						}
					});

			selMap.getMapping().getActiveImportedMappingHintGroups().stream()
					.filter(g -> g.getHintGroup() != null && g.getHintGroup().getTargetSection() != null).forEach(g -> {
						if (g.getHintGroup() != null && g.getHintGroup().getTargetSection() != null) {

							/*
							 * Create a TransformationMappingHintGroup for the
							 * mapping hint group
							 */
							TransformationMappingHintGroup transformationMappingHintGroup = TransformationFactory.eINSTANCE
									.createTransformationMappingHintGroup();
							transformationMappingHintGroup.setAssociatedMappingHintGroup(g);
							for (EObjectWrapper instance : selMap.getInstancesBySection(g)
									.get(g.getHintGroup().getTargetSection())) {
								transformationMappingHintGroup.getTargetElements().add(instance.getEObject());
							}
							transformationMapping.getTransformationHintGroups().add(transformationMappingHintGroup);
						}
					});
		}

		/*
		 * save the transformation model and create copies of all referenced
		 * resources
		 */
		final XMIResourceFactoryImpl resFactory = new XMIResourceFactoryImpl();
		URI transformationModelUri = URI
				.createPlatformResourceURI(this.transformationConfig.getTransformationModelPath(), true);
		URI transformationFolderUri = transformationModelUri.trimSegments(1);
		transformationFolderUri = URI.createURI(transformationFolderUri.toString() + " - " + transformationModelName);
		transformationModelUri = transformationFolderUri.appendSegment(transformationModelUri.lastSegment());
		final Map<Object, Object> options = new LinkedHashMap<>();
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE); // suppress
																			// 'document
																			// root'
																			// element
																			// in
																			// case
																			// of
																			// xml
																			// models

		try {

			/*
			 * copy the library entries
			 */
			for (de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry libraryEntry : transformationModel
					.getLibraryEntries()) {
				URI libEntryUri = transformationFolderUri
						.appendSegment(libraryEntry.eResource().getURI().trimSegments(1).lastSegment())
						.appendSegment(libraryEntry.eResource().getURI().lastSegment());
				XMIResource libEntryResource = (XMIResource) resFactory.createResource(libEntryUri);
				libEntryResource.getContents().add(libraryEntry);
				libEntryResource.save(options);
			}

			/*
			 * copy the pamtram instances
			 */
			for (PAMTraM pamtramModel : transformationModel.getPamtramInstances()) {
				XMIResource pamtramModelResource = (XMIResource) resFactory.createResource(
						transformationFolderUri.appendSegment(pamtramModel.eResource().getURI().lastSegment()));
				pamtramModelResource.getContents().add(pamtramModel);
				pamtramModelResource.save(options);
			}

			/*
			 * copy the source models
			 */
			for (EObject sourceModel : transformationModel.getSourceModels()) {
				XMLResource sourceModelResource = (XMLResource) resFactory.createResource(
						transformationFolderUri.appendSegment(sourceModel.eResource().getURI().lastSegment()));
				sourceModelResource.getContents().add(sourceModel);
				sourceModelResource.save(options);
			}

			/*
			 * copy the target models
			 */
			final ResourceSetImpl targetResourceSet = new ResourceSetImpl();
			for (EObject targetModel : transformationModel.getTargetModels()) {

				/*
				 * As multiple target models can be contained in the same
				 * resource, we first check if there already exists a resource
				 * for the target model. Only if no resource exists, we create a
				 * new one.
				 */
				URI targetModelUri = transformationFolderUri
						.appendSegment(targetModel.eResource().getURI().lastSegment());
				XMLResource targetModelResource = null;
				try {
					targetModelResource = (XMIResource) targetResourceSet.getResource(targetModelUri, false);
					targetModelResource.load(Collections.emptyMap());
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
			transformationModelResource.getContents().add(transformationModel);
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
	 * @param msg
	 *            The message to be printed to the console
	 */
	private void writePamtramMessage(final String msg) {

		this.transformationConfig.getLogger().info(() -> "\n################# " + msg + " #################\n");
	}

	/**
	 * This class encapsulates the results of the various steps performed during
	 * a generic transformation: <br />
	 * <ul>
	 * <li>a {@link MatchingResult} containing the results of the
	 * <em>matching</em> process,</li>
	 * <li>an {@link ExpandingResult} containing the results of the
	 * <em>expanding</em> process,</li>
	 * <li>a boolean indicating the result of the <em>joining</em> process,</li>
	 * <li>a boolean indicating the result of the <em>linking</em> process,
	 * and</li>
	 * <li>a boolean indicating the result of the <em>library entry
	 * expanding</em> process.</li>
	 * </ul>
	 *
	 * @author mfreund
	 */
	public static class TransformationResult {

		/**
		 * This class encapsulates the various results of the <em>matching</em>
		 * process during a generic transformation: <br />
		 * <ul>
		 * <li>the status of the matching process,</li>
		 * <li>a list of selected {@link MappingInstanceStorage mappings},</li>
		 * <li>a map of selected {@link MappingInstanceStorage mappings},
		 * associated with the {@link Mapping} that they represent,</li>
		 * <li>{@link HintValueStorage exported hint values},</li>
		 * <li>a map describing values for {@link GlobalAttribute
		 * GlobalAttributes}</li>
		 * </ul>
		 *
		 * @author mfreund
		 *
		 */
		static class MatchingResult {

			/**
			 * This describes the status of the matching process,
			 * '<em><b>true</b></em>' meaning that the matching process has been
			 * canceled, '<em><b>false</b></em>' otherwise.
			 */
			private final boolean canceled;

			/**
			 * This is the list of {@link MappingInstanceStorage mappings} that
			 * have been selected during the <em>matching</em> process.
			 */
			private final List<MappingInstanceStorage> selectedMappings;

			/**
			 * This the map of {@link MappingInstanceStorage mappings} that have
			 * been selected during the <em>matching</em> process associated
			 * with the {@link Mapping} that they represent.
			 */
			private final Map<Mapping, List<MappingInstanceStorage>> selectedMappingsByMapping;

			/**
			 * This is the {@link HintValueStorage} containing values for
			 * exported mapping hints.
			 */
			private final HintValueStorage exportedMappingHints;

			/**
			 * This is the map of values for global attributes associated with
			 * the {@link GlobalAttribute} that they represent.
			 */
			private final GlobalValueMap globalValues;

			/**
			 * This constructs an instance.
			 *
			 * @param canceled
			 *            '<em><b>true</b></em>' indicates that the matching
			 *            process was canceled, '<em><b>false</b></em>'
			 *            indicates that the matching process completed
			 *            successfully.
			 * @param selectedMappings
			 *            The list of {@link MappingInstanceStorage mappings}
			 *            that have been selected during the <em>matching</em>
			 *            process.
			 * @param selectedMappingsByMapping
			 *            The map of {@link MappingInstanceStorage mappings}
			 *            that have been selected during the <em>matching</em>
			 *            process associated with the {@link Mapping} that they
			 *            represent.
			 * @param exportedMappingHints
			 *            The {@link HintValueStorage} containing values for
			 *            exported mapping hints.
			 * @param libEntryInstantiatorMap2
			 * @param globalAttributeValues
			 *            The map of values for global attributes associated
			 *            with the {@link GlobalAttribute} that they represent.
			 */
			private MatchingResult(boolean canceled, List<MappingInstanceStorage> selectedMappings,
					Map<Mapping, List<MappingInstanceStorage>> selectedMappingsByMapping,
					HintValueStorage exportedMappingHints, GlobalValueMap globalValues) {
				this.canceled = canceled;
				this.selectedMappings = selectedMappings;
				this.selectedMappingsByMapping = selectedMappingsByMapping;
				this.exportedMappingHints = exportedMappingHints;
				this.globalValues = globalValues;
			}

			/**
			 * This constructs an instance for a matching process that has been
			 * canceled.
			 *
			 * @return An instance of {@link MatchingResult} indicating that the
			 *         matching was canceled.
			 */
			public static MatchingResult createMatchingCanceledResult() {

				return new MatchingResult(true, null, null, null, null);
			}

			/**
			 * This constructs an instance for a matching process that has
			 * finished successfully.
			 *
			 * @param selectedMappings
			 *            The list of {@link MappingInstanceStorage mappings}
			 *            that have been selected during the <em>matching</em>
			 *            process.
			 * @param selectedMappingsByMapping
			 *            The map of {@link MappingInstanceStorage mappings}
			 *            that have been selected during the <em>matching</em>
			 *            process associated with the {@link Mapping} that they
			 *            represent.
			 * @param exportedMappingHints
			 *            The {@link HintValueStorage} containing values for
			 *            exported mapping hints.
			 * @param globalValues
			 *            The values of {@link GlobalAttribute GlobalAttributes}
			 *            and {@link FixedValue FixedValues}.
			 * @return An instance of {@link MatchingResult} indicating that the
			 *         matching has completed successfully.
			 */
			public static MatchingResult createMatchingCompletedResult(List<MappingInstanceStorage> selectedMappings,
					Map<Mapping, List<MappingInstanceStorage>> selectedMappingsByMapping,
					HintValueStorage exportedMappingHints, GlobalValueMap globalValues) {

				return new MatchingResult(false, selectedMappings, selectedMappingsByMapping, exportedMappingHints,
						globalValues);
			}

			/**
			 * This is the getter for the {@link #canceled}.
			 *
			 * @return The status of the matching process,
			 *         '<em><b>true</b></em>' meaning that the matching process
			 *         has been canceled, '<em><b>false</b></em>' otherwise.
			 */
			boolean isCanceled() {

				return this.canceled;
			}

			/**
			 * This is the getter for the {@link #selectedMappings}.
			 *
			 * @return The list of {@link MappingInstanceStorage mappings} that
			 *         have been selected during the <em>matching</em> process.
			 */
			List<MappingInstanceStorage> getSelectedMappings() {

				return this.selectedMappings;
			}

			/**
			 * This is the getter for the {@link #selectedMappingsByMapping}.
			 *
			 * @return The map of {@link MappingInstanceStorage mappings} that
			 *         have been selected during the <em>matching</em> process
			 *         associated with the {@link Mapping} that they represent.
			 */
			Map<Mapping, List<MappingInstanceStorage>> getSelectedMappingsByMapping() {

				return this.selectedMappingsByMapping;
			}

			/**
			 * This is the getter for the {@link #exportedMappingHints}.
			 *
			 * @return The {@link HintValueStorage} containing values for
			 *         exported mapping hints.
			 */
			HintValueStorage getExportedMappingHints() {

				return this.exportedMappingHints;
			}

			/**
			 * This is the getter for the {@link #globalAttributeValues}.
			 *
			 * @return The map of values for global attributes associated with
			 *         the {@link GlobalAttribute} that they represent.
			 */
			GlobalValueMap getGlobalValues() {

				return this.globalValues;
			}
		}

		/**
		 * This class encapsulates the various results of the <em>expanding</em>
		 * process during a generic transformation: <br />
		 * <ul>
		 * <li>an {@link AttributeValueRegistry} containing registered attribute
		 * values,</li>
		 * <li>a {@link TargetSectionRegistry} containing/representing created
		 * target sections</li>
		 * </ul>
		 *
		 * @author mfreund
		 *
		 */
		static class ExpandingResult {

			/**
			 * An {@link AttributeValueRegistry} containing registered attribute
			 * values.
			 */
			private final AttributeValueRegistry attributeValueRegistry;

			/**
			 * A {@link TargetSectionRegistry} containing/representing created
			 * target sections.
			 */
			private final TargetSectionRegistry targetSectionRegistry;

			private final Map<EObjectWrapper, LibraryEntryInstantiator> libEntryInstantiatorMap;

			/**
			 * This constructs an instance for an expanding process.
			 *
			 * @param attributeValueRegistry
			 *            The {@link AttributeValueRegistry} containing
			 *            registered attribute values.
			 * @param targetSectionRegistry
			 *            The {@link TargetSectionRegistry}
			 *            containing/representing created target sections.
			 */
			private ExpandingResult(AttributeValueRegistry attributeValueRegistry,
					TargetSectionRegistry targetSectionRegistry,
					Map<EObjectWrapper, LibraryEntryInstantiator> libEntryInstantiatorMap) {

				this.attributeValueRegistry = attributeValueRegistry;
				this.targetSectionRegistry = targetSectionRegistry;
				this.libEntryInstantiatorMap = libEntryInstantiatorMap;
			}

			/**
			 * This constructs an instance for an expanding process.
			 *
			 * @param attributeValueRegistry
			 *            The {@link AttributeValueRegistry} containing
			 *            registered attribute values.
			 * @param targetSectionRegistry
			 *            The {@link TargetSectionRegistry}
			 *            containing/representing created target sections.
			 * @param libEntryInstantiatorMap
			 *            The temporarily created elements for LibraryEntries
			 *            (represented by an {@link EObjectWrapper}) and their
			 *            corresponding {@link LibraryEntryInstantiator}
			 * @return An instance of {@link ExpandingResult}.
			 */
			public static ExpandingResult createExpandingResult(AttributeValueRegistry attributeValueRegistry,
					TargetSectionRegistry targetSectionRegistry,
					Map<EObjectWrapper, LibraryEntryInstantiator> libEntryInstantiatorMap) {

				return new ExpandingResult(attributeValueRegistry, targetSectionRegistry, libEntryInstantiatorMap);
			}

			/**
			 * This is the getter for the {@link #attributeValueRegistry}.
			 *
			 * @return An {@link AttributeValueRegistry} containing registered
			 *         attribute values.
			 */
			AttributeValueRegistry getAttributeValueRegistry() {

				return this.attributeValueRegistry;
			}

			/**
			 * This is the getter for the {@link #targetSectionRegistry}. return
			 * A {@link TargetSectionRegistry} containing/representing created
			 * target sections.
			 */
			TargetSectionRegistry getTargetSectionRegistry() {

				return this.targetSectionRegistry;
			}

			/**
			 * This is the getter for the {@link #libEntryInstantiatorMap}.
			 *
			 * @return
			 */
			Map<EObjectWrapper, LibraryEntryInstantiator> getLibEntryInstantiatorMap() {

				return this.libEntryInstantiatorMap;
			}
		}

		/**
		 * This class encapsulates the various results of the <em>joining</em>
		 * process during a generic transformation: <br />
		 * <ul>
		 * <li>the status of the matching process,</li>
		 * <li>a {@link TargetModelRegistry} representing the target models to
		 * be created</li>
		 * </ul>
		 *
		 * @author mfreund
		 *
		 */
		static class JoiningResult {

			/**
			 * This describes the status of the matching process,
			 * '<em><b>true</b></em>' meaning that the matching process has been
			 * canceled, '<em><b>false</b></em>' otherwise.
			 */
			private final boolean canceled;

			/**
			 * The {@link TargetModelRegistry} representing the target models to
			 * be created.
			 */
			private TargetModelRegistry targetModelRegistry;

			/**
			 * This constructs an instance.
			 *
			 * @param canceled
			 *            '<em><b>true</b></em>' indicates that the joining
			 *            process was canceled, '<em><b>false</b></em>'
			 *            indicates that the joining process completed
			 *            successfully.
			 * @param targetModelRegistry
			 */
			private JoiningResult(boolean canceled, TargetModelRegistry targetModelRegistry) {
				this.canceled = canceled;
				this.targetModelRegistry = targetModelRegistry;
			}

			/**
			 * This constructs an instance for a joining process that has been
			 * canceled.
			 *
			 * @return An instance of {@link JoiningResult} indicating that the
			 *         joining was canceled.
			 */
			public static JoiningResult createJoiningCanceledResult() {

				return new JoiningResult(true, null);
			}

			/**
			 * This constructs an instance for a joining process that has
			 * finished successfully.
			 *
			 * @param targetModelRegistry
			 *            The {@link TargetModelRegistry} instance representing
			 *            the target models to be created.
			 * @return An instance of {@link JoiningResult} indicating that the
			 *         joining has completed successfully.
			 */
			public static JoiningResult createJoiningCompletedResult(TargetModelRegistry targetModelRegistry) {

				return new JoiningResult(false, targetModelRegistry);
			}

			/**
			 * This is the getter for the {@link #canceled}.
			 *
			 * @return The status of the matching process,
			 *         '<em><b>true</b></em>' meaning that the matching process
			 *         has been canceled, '<em><b>false</b></em>' otherwise.
			 */
			boolean isCanceled() {

				return this.canceled;
			}

			/**
			 * This is the getter for the {@link #targetModelRegistry}.
			 *
			 * @return The {@link TargetModelRegistry} representing the target
			 *         models to be created.
			 */
			TargetModelRegistry getTargetModelRegistry() {

				return this.targetModelRegistry;
			}
		}

		/**
		 * An instance of {@link MatchingResult} containing the results of the
		 * <em>matching</em> process.
		 */
		private MatchingResult matchingResult;

		/**
		 * An instance of {@link ExpandingResult} containing the results of the
		 * <em>expanding</em> process.
		 */
		private ExpandingResult expandingResult;

		/**
		 * An instance of {@link JoiningResult} indicating the result of the
		 * <em>joining</em> process.
		 */
		private JoiningResult joiningResult;

		/**
		 * A boolean indicating the result of the <em>linking</em> process.
		 */
		private boolean linkingResult;

		/**
		 * A boolean indicating the result of the <em>library entry
		 * expanding</em> process.
		 */
		private boolean libEntryExpandingResult;

		/**
		 * @return the matchingResult
		 */
		public MatchingResult getMatchingResult() {

			return this.matchingResult;
		}

		/**
		 * @param matchingResult
		 *            the matchingResult to set
		 */
		public void setMatchingResult(MatchingResult matchingResult) {

			this.matchingResult = matchingResult;
		}

		/**
		 * @return the expandingResult
		 */
		public ExpandingResult getExpandingResult() {

			return this.expandingResult;
		}

		/**
		 * @param expandingResult
		 *            the expandingResult to set
		 */
		public void setExpandingResult(ExpandingResult expandingResult) {

			this.expandingResult = expandingResult;
		}

		/**
		 * @return the joiningResult
		 */
		public JoiningResult getJoiningResult() {

			return this.joiningResult;
		}

		/**
		 * @param joiningResult
		 *            the joiningResult to set
		 */
		public void setJoiningResult(JoiningResult joiningResult) {

			this.joiningResult = joiningResult;
		}

		/**
		 * @return the linkingResult
		 */
		public boolean isLinkingResult() {

			return this.linkingResult;
		}

		/**
		 * @param linkingResult
		 *            the linkingResult to set
		 */
		public void setLinkingResult(boolean linkingResult) {

			this.linkingResult = linkingResult;
		}

		/**
		 * @return the libEntryExpandingResult
		 */
		public boolean isLibEntryExpandingResult() {

			return this.libEntryExpandingResult;
		}

		/**
		 * @param libEntryExpandingResult
		 *            the libEntryExpandingResult to set
		 */
		public void setLibEntryExpandingResult(boolean libEntryExpandingResult) {

			this.libEntryExpandingResult = libEntryExpandingResult;
		}

		/**
		 * Returns the overall status of the transformation.
		 *
		 * @return '<em><b>true</b></em>' if and only if every phase of the
		 *         transformation completed successfully;
		 *         '<em><b>false</b></em>' otherwise.
		 */
		public boolean getOverallResult() {

			if (this.getMatchingResult() == null || this.getMatchingResult().isCanceled()) {
				return false;
			} else if (this.getExpandingResult() == null) {
				return false;
			} else if (this.getJoiningResult() == null || this.getJoiningResult().isCanceled()) {
				return false;
			} else if (!this.isLinkingResult()) {
				return false;
			} else if (!this.isLibEntryExpandingResult()) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * A {@link MessageDialog} that informs about an error and asks the user
	 * whether he wants to continue or to abort.
	 *
	 * @author mfreund
	 */
	private static class ErrorDialog extends MessageDialog {

		private ErrorDialog(Shell parentShell, String dialogMessage) {
			super(parentShell, "Error", null, dialogMessage, MessageDialog.ERROR, new String[] { "Continue", "Abort" },
					0);
		}

		/**
		 * This creates and opens a dialog.
		 *
		 * @param parentShell
		 *            The parent shell of the dialog, or <code>null</code> if
		 *            none.
		 * @param dialogMessage
		 *            The message to display to the user.
		 * @return '<em><b>true</b></em>' if the user selected
		 *         <em>Continue</em>, '<em><b>false</b></em>' if he selected
		 *         <em>Abort</em>.
		 */
		public static boolean open(Shell parentShell, String dialogMessage) {

			ErrorDialog dialog = new ErrorDialog(parentShell, dialogMessage);
			return dialog.open() == 0;
		}
	}

	/**
	 * A {@link MessageDialog} that asks for a name for the name of the
	 * TransformationModel to be created..
	 *
	 * @author mfreund
	 */
	private static class TransformationModelNameDialog extends MessageDialog {

		/**
		 * The {@link Text} where the user enters the name for the
		 * TransformationModel.
		 */
		private Text transformationModelNameTextField;

		/**
		 * The name for the TransformationModel that was specified by the user.
		 */
		private String transformationModelName = "";

		private TransformationModelNameDialog(Shell parentShell) {
			super(parentShell, "TransformationModel", null,
					"Please specify a name for the TransformationModel to be created for this transformation...",
					MessageDialog.QUESTION, new String[] { "OK", "Abort" }, 0);
		}

		@Override
		protected Control createCustomArea(Composite parent) {

			this.transformationModelNameTextField = new Text(parent, SWT.BORDER);
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false)
					.applyTo(this.transformationModelNameTextField);
			this.transformationModelNameTextField.addModifyListener(
					e -> TransformationModelNameDialog.this.transformationModelName = TransformationModelNameDialog.this.transformationModelNameTextField
							.getText());
			return this.transformationModelNameTextField;
		}

		/**
		 * Return the name that was specified by the user.
		 *
		 * @return The name that was specified by the user or an empty String if
		 *         the user did not specify anything.
		 */
		private String getResult() {

			return this.transformationModelName;
		}

		/**
		 * This creates and opens a dialog.
		 *
		 * @param parentShell
		 *            The parent shell of the dialog, or <code>null</code> if
		 *            none.
		 * @return If the user selected 'OK', this returns the name that was
		 *         specified by the user or an empty String if the user did not
		 *         specify anything; if the user selected 'Abort', this returns
		 *         '<em>null</em>'.
		 */
		public static String open(Shell parentShell) {

			TransformationModelNameDialog dialog = new TransformationModelNameDialog(parentShell);
			return dialog.open() == 0 ? dialog.getResult() : null;
		}
	}
}
