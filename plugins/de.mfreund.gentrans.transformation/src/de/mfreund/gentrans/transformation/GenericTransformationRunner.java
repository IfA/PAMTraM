package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
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
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;

import de.mfreund.gentrans.transformation.GenericTransformationRunner.TransformationResult.MatchingResult;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.HintValueStorage;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.expanding.TargetSectionConnector;
import de.mfreund.gentrans.transformation.expanding.TargetSectionInstantiator;
import de.mfreund.gentrans.transformation.expanding.TargetSectionLinker;
import de.mfreund.gentrans.transformation.matching.GlobalAttributeValueExtractor;
import de.mfreund.gentrans.transformation.matching.HintValueExtractor;
import de.mfreund.gentrans.transformation.matching.MappingSelector;
import de.mfreund.gentrans.transformation.matching.SourceSectionMatcher;
import de.mfreund.gentrans.transformation.registries.AttributeValueRegistry;
import de.mfreund.gentrans.transformation.registries.LibraryEntryRegistry;
import de.mfreund.gentrans.transformation.registries.TargetModelRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.DefaultAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.util.CancelableElement;
import de.mfreund.gentrans.transformation.util.MonitorWrapper;
import de.mfreund.pamtram.transformation.Transformation;
import de.mfreund.pamtram.transformation.TransformationFactory;
import de.mfreund.pamtram.transformation.TransformationMapping;
import de.mfreund.pamtram.transformation.TransformationMappingHintGroup;
import de.tud.et.ifa.agtele.resources.ResourceHelper;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.FixedValue;
import pamtram.PAMTraM;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.extended.MappingHint;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;

/**
 * This class can be used to execute a generic transformation. It performs the different phases of the transformation
 * after calling {@link #runTransformation(Optional)}.
 * <p />
 * Note: Instances need to be created via the {@link GenericTransformationRunnerFactory}.
 *
 * @author mfreund
 */
public class GenericTransformationRunner extends CancelableElement {

	private static final String TRANSFORMATION_ABORTED_MESSAGE = "Transformation aborted.";

	/**
	 * The {@link TransformationConfiguration} providing the parameters for the transformation.
	 */
	private TransformationConfiguration transformationConfig;

	/**
	 * The {@link TransformationAssetManager} encapsulating the various helper objects that will be used during the
	 * transformation.
	 */
	private TransformationAssetManager assetManager;

	/**
	 * The {@link IProgressMonitor} that shall be used to visualize the progress of the transformation.
	 * <p />
	 * Instead of directly storing an {@link IProgressMonitor}, we make use of a {@link MonitorWrapper} so that we are
	 * not dependent on an actual monitor to be present.
	 */
	private MonitorWrapper monitor;

	/**
	 * This creates an instance based on the given {@link TransformationConfiguration}.
	 * <p />
	 * Note: This will use a default {@link Logger} implementation to print log messages.
	 *
	 * @see #GenericTransformationRunner(TransformationConfiguration, Logger)
	 *
	 * @param config
	 *            The {@link TransformationConfiguration} specifying all parameters necessary for the execution of the
	 *            transformation.
	 */
	GenericTransformationRunner(TransformationConfiguration config) {

		super();
		this.transformationConfig = config;
		this.assetManager = new TransformationAssetManager(config);
		this.monitor = new MonitorWrapper(Optional.empty());

	}

	/**
	 * This creates an instance based on the given {@link TransformationConfiguration}.
	 * <p />
	 * Note: This will use the given {@link Logger} implementation to print log messages.
	 *
	 * @see #GenericTransformationRunner(TransformationConfiguration)
	 *
	 * @param config
	 *            The {@link TransformationConfiguration} specifying all parameters necessary for the execution of the
	 *            transformation.
	 */
	GenericTransformationRunner(TransformationConfiguration config, Logger logger) {

		super();
		this.transformationConfig = config;
		this.assetManager = new TransformationAssetManager(config, logger);
		this.monitor = new MonitorWrapper(Optional.empty());

	}

	/**
	 * This performs the actual generic transformation. It loads all necessary models, executes the mappings defined in
	 * the PAMTraM model and stores the generated target model. All progress is reported to the given
	 * '<em>monitor</em>'.
	 *
	 * @param monitor
	 *            An optional {@link IProgressMonitor} that shall be used to display the progress of the transformation.
	 */
	public void runTransformation(Optional<IProgressMonitor> monitor) {

		// If the user passed a monitor, we update the MonitorWrapper
		//
		monitor.ifPresent(this.monitor::setWrappedMonitor);

		final Date startTime = new Date();

		this.monitor.beginTask("GenTrans", 700);

		try {

			// prepare the transformation (validate pamtram model, merge
			// extends,
			// etc.)
			//
			if (!this.prepare(this.transformationConfig)) {
				this.assetManager.getLogger().severe(GenericTransformationRunner.TRANSFORMATION_ABORTED_MESSAGE);
				return;
			}

			/*
			 * try to execute all active mappings (this includes the 4 resp. 5 main steps of the transformation
			 */
			this.executeMappings();

		} catch (CancelTransformationException e1) {

			String externalMessage = e1.getMessage() != null ? e1.getMessage() : "";
			String internalMessage = e1.getCause() != null && e1.getCause().getMessage() != null
					? e1.getCause().getMessage()
					: "";

			StringBuilder builder = new StringBuilder();
			if (!externalMessage.isEmpty()) {
				builder.append(externalMessage);
				if (!internalMessage.isEmpty()) {
					builder.append("\n\t-> ");
				}
			}
			builder.append(internalMessage);

			Activator.log(builder.toString(), e1);

			this.assetManager.getLogger().severe(() -> builder.toString());
			this.assetManager.getLogger().severe("See the ErrorLog for more information!");
			this.assetManager.getLogger().severe("Aborting...");
			return;
		} catch (RuntimeException e) {
			if (e.getMessage() != null) {
				this.assetManager.getLogger().severe(() -> e.getMessage());
			} else {
				this.assetManager.getLogger().severe(() -> e.toString());
			}
			this.assetManager.getLogger().severe("See the ErrorLog for more information!");
			this.assetManager.getLogger().severe("Aborting...");

			Activator.log(e);

			throw e;
		}

		if (!this.isCanceled()) {

			this.writePamtramMessage("Storing target model(s).");
			this.monitor.subTask("Storing target model(s).");

			/*
			 * create the target models
			 */
			boolean result = this.assetManager.getTargetModelRegistry().saveTargetModels();

			final Date endTime = new Date();

			if (result) {

				/*
				 * populate and store the transformation model if necessary
				 */
				this.generateTransformationModel(startTime, endTime);

				/*
				 * Finally, open the (first of the) generated target model(s) if necessary
				 */
				if (!this.assetManager.getTargetModelRegistry().isEmpty()
						&& this.transformationConfig.isOpenTargetModelOnCompletion()) {

					new UIJob("Open Generated Target Model") {

						@Override
						public IStatus runInUIThread(IProgressMonitor monitor) {

							String targetModelToOpen = GenericTransformationRunner.this.assetManager
									.getTargetModelRegistry().getTargetModels().keySet().iterator().next();
							final URI targetModelToOpenUri = URI.createPlatformResourceURI(
									GenericTransformationRunner.this.transformationConfig.getTargetBasePath()
											+ Path.SEPARATOR + targetModelToOpen,
									true);

							try {
								UIHelper.openEditor(ResourceHelper.getFileForURI(targetModelToOpenUri));
							} catch (PartInitException e) {
								GenericTransformationRunner.this.assetManager.getLogger().severe(() -> e.toString());
								e.printStackTrace();
							}

							return Status.OK_STATUS;
						}
					}.schedule();

				}
			}

			this.writePamtramMessage(
					"Transformation done. Time: " + (endTime.getTime() - startTime.getTime()) / 1000d + "s");
		}

	}

	/**
	 * This is a temporary method that is called by the 'source section matcher page' in order to get the matched
	 * sections for a sample source model. Therefore, it performs half a transformation and then returns the matched
	 * section. This should be changed in the future e.g. by using the 'transformation model'.
	 *
	 * @return A map relating the matched SourceSectionClasses to the {@link EObject elements} they have been matched
	 *         against.
	 */
	@Deprecated
	public Map<SourceSectionClass, Set<EObject>> matchSourceSections() {

		// prepare the transformation (validate pamtram model, merge extends,
		// etc.)
		//
		if (!this.prepare(this.transformationConfig)) {
			this.assetManager.getLogger().severe(GenericTransformationRunner.TRANSFORMATION_ABORTED_MESSAGE);
			return null;
		}

		this.writePamtramMessage("Matching SourceSections");

		// Collect the global values modeled in the PAMTraM instance
		//
		Map<FixedValue, String> globalFixedValues = this.transformationConfig.getPamtramModels().stream()
				.flatMap(p -> p.getGlobalValues().stream())
				.collect(Collectors.toMap(Function.identity(), FixedValue::getValue));

		this.assetManager.getGlobalValues().addFixedValues(globalFixedValues);

		/*
		 * Match the SourceSections
		 */
		SourceSectionMatcher sourceSectionMatcher = this.assetManager.getSourceSectionMatcher();

		sourceSectionMatcher.matchSections(this.transformationConfig.getSourceModels(),
				this.transformationConfig.getPamtramModels());

		// Retrieve the list of all created MatchedSectionDescriptors
		//
		List<MatchedSectionDescriptor> descriptors = this.assetManager.getMatchedSectionRegistry().values()
				.parallelStream().flatMap(e -> e.parallelStream()).collect(Collectors.toList());

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
	 * This cancels the transformation and throws a {@link CancelTransformationException}.
	 */
	@Override
	public void cancel() {

		super.cancel();
		this.assetManager.cancel();
		throw new CancelTransformationException();
	}

	/**
	 * Prepare the transformation by {@link #validatePamtramModel(PAMTraM) validating} the {@link PAMTraM} model,
	 * {@link PAMTraM#mergeExtends() merging extends}, and initializing the {@link IAmbiguityResolvingStrategy
	 * ambiguityResolvingStrategy} to be used.
	 * <p />
	 * This should be called at least once before starting the actual transformation.
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} containing all parameters necessary for the validation.
	 */
	private boolean prepare(TransformationConfiguration transformationConfig) {

		this.writePamtramMessage("Preparing transformation");

		this.assetManager.getLogger().fine("Validating transformation configuration...");

		// validate the TransformationConfiguration
		//
		if (!transformationConfig.validate()) {
			return false;
		}

		this.assetManager.getLogger().info(transformationConfig::toString);

		this.assetManager.getLogger().fine("Validation successful!");

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
		try {
			transformationConfig.getPamtramModels().stream().forEach(PAMTraM::mergeExtends);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CancelTransformationException("Internal error during prepration of the PAMTraM model!", e);
		}

		// Initialize the ambiguity resolving strategy
		//
		this.assetManager.getLogger().fine("\nInitializing ambiguity resolving strategy...");
		try {

			transformationConfig.getAmbiguityResolvingStrategy().init(transformationConfig.getPamtramModels(),
					transformationConfig.getSourceModels(), this.assetManager.getLogger());
			this.assetManager.getLogger().fine("Initialization successful!");

		} catch (Exception e1) {
			e1.printStackTrace();
			this.assetManager.getLogger().warning("Internal error. Switching to DefaultAmbiguityResolvingStrategy...");
			transformationConfig.withAmbiguityResolvingStrategy(new DefaultAmbiguityResolvingStrategy());
		}

		return true;
	}

	/**
	 * This validates the given {@link PAMTraM} models using a {@link Diagnostician}. If errors occur, the user is asked
	 * whether to proceed anyway.
	 *
	 * @param transformationConfiguration
	 *            The {@link TransformationConfiguration} specifying the {@link PAMTraM} models to validate.
	 * @return '<em><b>true</b></em>' if the validation succeeded or if the user chose to ignore errors;
	 *         '<em><b>false/b></em>' otherwise.
	 */
	private boolean validatePamtramModels(TransformationConfiguration transformationConfiguration) {

		this.assetManager.getLogger().fine("\nValiding PAMTraM models...");

		Set<Integer> diags = transformationConfiguration.getPamtramModels().stream()
				.map(pamtramModel -> Diagnostician.INSTANCE.validate(pamtramModel).getSeverity())
				.collect(Collectors.toSet());

		if (diags.contains(Diagnostic.ERROR)) {
			final AtomicBoolean result = new AtomicBoolean();

			this.assetManager.getLogger().fine("Validation completed with errors!");

			Display.getDefault().syncExec(
					() -> result.set(ErrorDialog.open(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
							"Errors exist in the specified PAMTraM model. Continue anyway?")));

			if (!result.get()) {
				return false;
			}
		} else {
			this.assetManager.getLogger().fine("Validation successful!");
		}

		return true;
	}

	/**
	 * This performs the actual execution of the transformation. In the course of this method, the various phases of the
	 * transformation get executed.
	 *
	 * @param monitor
	 *            The {@link IProgressMonitor monitor} that shall be used to visualize the progress of the
	 *            transformation.
	 */
	private void executeMappings() {

		/*
		 * Perform the first step of the 'searching' step of the transformation
		 */
		this.performSearching_MatchSections();

		/*
		 * Perform the second step of the 'searching' step of the transformation
		 */
		this.performSearching_SelectMappings();

		/*
		 * Perform the second step of the 'searching' step of the transformation
		 */
		this.performExtracting();

		/*
		 * Perform the 'expanding' step of the transformation
		 */
		this.performInstantiating();

		/*
		 * Perform the 'joining' step of the transformation
		 */
		this.performJoining();

		/*
		 * Perform the 'linking' step of the transformation
		 */
		this.performLinking();

		/*
		 * Finally, instantiate the collected library entries
		 */
		this.performInstantiatingLibraryEntries();

	}

	/**
	 * This performs the first step of the '<em>searching</em>' phase of the transformation (the matching of the
	 * {@link SourceSection SourceSections}. Therefore, it iterates through the list of '<em>sourceModels</em>' defined
	 * in the {@link #transformationConfig} and {@link SourceSectionMatcher#matchSections() matches SourceSections},
	 * {@link MappingSelector#selectMappings() selects mappings} and {@link HintValueExtractor#extractHintValues()
	 * extracts hint values}.
	 */
	private void performSearching_MatchSections() {

		List<PAMTraM> pamtramModels = this.transformationConfig.getPamtramModels();

		this.monitor.subTask("Searching - Matching SourceSections");

		/*
		 * Collect the global FixedValues
		 */
		this.writePamtramMessage("Extracting global FixedValues");

		Map<FixedValue, String> globalFixedValues = pamtramModels.stream().flatMap(p -> p.getGlobalValues().stream())
				.collect(Collectors.toMap(Function.identity(), FixedValue::getValue));

		this.assetManager.getGlobalValues().addFixedValues(globalFixedValues);

		/*
		 * Match the SourceSections
		 */
		this.writePamtramMessage("Matching SourceSections");

		SourceSectionMatcher sourceSectionMatcher = this.assetManager.getSourceSectionMatcher();

		sourceSectionMatcher.matchSections(this.transformationConfig.getSourceModels(), pamtramModels);

		this.monitor.worked(100);

	}

	/**
	 * This performs the second step of the '<em>searching</em>' phase of the transformation (the selection of the
	 * {@link Mapping Mappings}. Therefore, it iterates through the list of '<em>sourceModels</em>' defined in the
	 * {@link #transformationConfig} and {@link SourceSectionMatcher#matchSections() matches SourceSections},
	 * {@link MappingSelector#selectMappings() selects mappings} and {@link HintValueExtractor#extractHintValues()
	 * extracts hint values}.
	 */
	private void performSearching_SelectMappings() {

		List<PAMTraM> pamtramModels = this.transformationConfig.getPamtramModels();

		this.monitor.subTask("Searching - Selecting Mappings");

		/*
		 * Extract the values of GlobalAttributes
		 */
		this.writePamtramMessage("Extracting Values of Global Attributes");

		GlobalAttributeValueExtractor globalAttributeValueExtractor = this.assetManager
				.getGlobalAttributeValueExtractor();

		globalAttributeValueExtractor.extractGlobalAttributeValues(this.assetManager.getMatchedSectionRegistry(),
				pamtramModels);

		/*
		 * Select the mapping to be applied for each of the matched SourceSections
		 */
		this.writePamtramMessage("Selecting Mappings for Matched Sections");

		MappingSelector mappingSelector = this.assetManager.getMappingSelector();

		mappingSelector.selectMappings(this.assetManager.getMatchedSectionRegistry(), pamtramModels);

		this.monitor.worked(100);

	}

	/**
	 * This performs the '<em>extracting</em>' phase of the transformation (the extraction of values for the selected
	 * {@link Mapping Mappings} resp. the contained {@link MappingHint MappingHints}.
	 */
	private void performExtracting() {

		this.monitor.subTask("Extractring");

		/*
		 * Calculate values of mapping hints
		 */
		this.writePamtramMessage("Extracting Hint Values");

		HintValueExtractor hintValueExtractor = this.assetManager.getHintValueExtractor();

		hintValueExtractor.extractHintValues(this.assetManager.getSelectedMappingRegistry().getMappingInstaces());

		this.monitor.worked(100);

	}

	/**
	 * This performs the '<em>instantiating</em>' step of the transformation: The target sections (excluding those that
	 * are defined by {@link LibraryEntry LibraryEntries}) are instantiated (only containment references and attributes
	 * but no non-containment references).
	 */
	private void performInstantiating() {

		this.monitor.subTask("Instantiating targetModelSections for selected mappings. First pass");

		/*
		 * Instantiate the TargetSections
		 */
		this.writePamtramMessage("Instantiating TargetSections for Selected Mappings");

		TargetSectionInstantiator targetSectionInstantiator = this.assetManager.getTargetSectionInstantiator();

		targetSectionInstantiator
				.expandTargetSectionInstances(this.assetManager.getSelectedMappingRegistry().getMappingInstaces());

		this.monitor.worked(100);

	}

	/**
	 * This performs the '<em>joining</em>' step of the transformation: The target sections that have been instantiated
	 * during the {@link #performInstantiating(MatchingResult, IProgressMonitor) expanding step} are linked via
	 * containment references and added to the target model. If necessary, intermediary object are created as well.
	 */
	private void performJoining() {

		this.monitor.subTask("Joining Instantiated TargetSections");

		/*
		 * Join the instantiated TargetSections
		 */
		this.writePamtramMessage("Joining Instantiated TargetSections");

		TargetSectionConnector targetSectionConnector = this.assetManager.getTargetSectionConnector();

		targetSectionConnector.joinTargetSections(this.assetManager.getSelectedMappingRegistry());

		// Finally, combine the Sections that are still unlinked with the
		// Root element of a TargetModel
		//
		targetSectionConnector.combineUnlinkedSectionsWithTargetModelRoot();

		this.monitor.worked(100);

	}

	/**
	 * This performs the '<em>linking</em>' step of the transformation: Necessary cross references between the created
	 * target sections are instantiated.
	 */
	private void performLinking() {

		this.monitor.subTask("Linking Instantiated TargetSections");

		/*
		 * Link the instantiated TargetSections
		 */
		this.writePamtramMessage("Linking Instantiated TargetSections");

		TargetSectionLinker targetSectionLinker = this.assetManager.getTargetSectionLinker();

		targetSectionLinker.linkTargetSections(this.assetManager.getSelectedMappingRegistry().getMappingInstaces());

		this.monitor.worked(100);

	}

	/**
	 * This performs the final step of the transformation: The stored library entries are finally instantiated in the
	 * target model.
	 */
	private void performInstantiatingLibraryEntries() {

		this.monitor.subTask("Instantiating LibraryEntries");

		/*
		 * Instantiate the LibraryEntries
		 */
		this.writePamtramMessage("Instantiating LibraryEntries");

		LibraryEntryRegistry libraryEntryRegistry = this.assetManager.getTargetSectionRegistry()
				.getLibraryEntryRegistry();

		if (libraryEntryRegistry.isEmpty()) {
			return;
		}

		this.assetManager.getLogger().fine(() -> "Instantiating " + libraryEntryRegistry.size() + " LibraryEntries...");

		/*
		 * Iterate over all stored instantiators and instantiate the associated library entry in the given target model.
		 */
		libraryEntryRegistry.values().stream()
				.forEach(libraryEntryInstantiator -> libraryEntryInstantiator.instantiate(
						this.assetManager.getGenLibraryManager(), this.assetManager.getValueCalculator(),
						this.assetManager.getTargetSectionRegistry())

		);

		this.monitor.worked(100);

	}

	/**
	 * This populates the contents of the {@link #transformationModel} and stores it to the path denoted by
	 * {@link #transformationModelPath}.
	 * <p/>
	 * <b>Note:</b> If {@link TransformationConfiguration#transformationModelPath} is set to '<em>null</em>', this does
	 * nothing.
	 *
	 * @param startTime
	 *            The {@link Date time} when the transformation started.
	 * @param endTime
	 *            The {@link Date time} when the transformation was finished.
	 *
	 * @return '<em><b>true</b></em>' if the resource has successfully been created, '<em><b>false</b></em>' otherwise.
	 */
	private boolean generateTransformationModel(Date startTime, Date endTime) {

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
				this.assetManager.getTargetModelRegistry().getTargetModels().values().stream()
						.flatMap(Collection::stream).collect(Collectors.toList()));

		// Create the various TransformationMappings and
		// TransformationMappingHintGroups
		//
		for (final MappingInstanceStorage selMap : this.assetManager.getSelectedMappingRegistry()
				.getMappingInstaces()) {

			/*
			 * Create a TransformationMapping for the mapping
			 */
			TransformationMapping transformationMapping = TransformationFactory.eINSTANCE.createTransformationMapping();
			transformationMapping.setAssociatedMapping(selMap.getMapping());
			transformationMapping.setSourceElement(selMap.getAssociatedSourceModelElement());
			transformationModel.getTransformationMappings().add(transformationMapping);

			/*
			 * Create a TransformationMappingHintGroup for each mapping hint group
			 */
			selMap.getMapping().getActiveMappingHintGroups().stream()
					.filter(g -> g.getTargetSection() != null && g instanceof InstantiableMappingHintGroup)
					.forEach(g -> {
						if (g.getTargetSection() != null && g instanceof InstantiableMappingHintGroup
								&& selMap.getInstancesBySection((InstantiableMappingHintGroup) g) != null) {

							/*
							 * Create a TransformationMappingHintGroup for the mapping hint group
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
						if (g.getHintGroup() != null && g.getHintGroup().getTargetSection() != null
								&& selMap.getInstancesBySection(g) != null) {

							/*
							 * Create a TransformationMappingHintGroup for the mapping hint group
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
		 * save the transformation model and create copies of all referenced resources
		 */
		final XMIResourceFactoryImpl resFactory = new XMIResourceFactoryImpl();
		URI transformationModelUri = URI
				.createPlatformResourceURI(this.transformationConfig.getTransformationModelPath(), true);
		URI transformationFolderUri = transformationModelUri.trimSegments(1);
		transformationFolderUri = URI.createURI(transformationFolderUri.toString() + " - " + transformationModelName);
		String fileExtension = transformationModelUri.fileExtension();
		transformationModelUri = transformationFolderUri.appendSegment(transformationModelUri.lastSegment()
				.replaceAll("\\." + fileExtension, " - " + transformationModelName + "." + fileExtension));
		final Map<Object, Object> options = new LinkedHashMap<>();
		// suppress 'document root' element in case of XML models
		//
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);

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
			 * copy the shared sub-models
			 */
			List<EObject> sharedSubModels = new ArrayList<>();
			sharedSubModels.addAll(transformationModel.getPamtramInstances().stream()
					.flatMap(p -> p.getSharedSourceSectionModels().stream()).collect(Collectors.toList()));
			sharedSubModels.addAll(transformationModel.getPamtramInstances().stream()
					.flatMap(p -> p.getSharedTargetSectionModels().stream()).collect(Collectors.toList()));
			sharedSubModels.addAll(transformationModel.getPamtramInstances().stream()
					.flatMap(p -> p.getSharedMappingModels().stream()).collect(Collectors.toList()));
			sharedSubModels.addAll(transformationModel.getPamtramInstances().stream()
					.flatMap(p -> p.getSharedConditionModels().stream()).collect(Collectors.toList()));
			for (EObject sharedSubModel : sharedSubModels) {
				XMIResource sharedSubModelResource = (XMIResource) resFactory.createResource(
						transformationFolderUri.appendSegment(sharedSubModel.eResource().getURI().lastSegment()));
				sharedSubModelResource.getContents().add(sharedSubModel);
				sharedSubModelResource.save(options);
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
				 * As multiple target models can be contained in the same resource, we first check if there already
				 * exists a resource for the target model. Only if no resource exists, we create a new one.
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
	 * Writes a message on the console that helps to divide the transformation output into different stages of the
	 * transformation
	 *
	 * @param msg
	 *            The message to be printed to the console
	 */
	private void writePamtramMessage(final String msg) {

		this.assetManager.getLogger().info(() -> "\n################# " + msg + " #################\n");
	}

	/**
	 * This class encapsulates the results of the various steps performed during a generic transformation: <br />
	 * <ul>
	 * <li>a {@link MatchingResult} containing the results of the <em>matching</em> process,</li>
	 * <li>an {@link ExpandingResult} containing the results of the <em>expanding</em> process,</li>
	 * <li>a boolean indicating the result of the <em>joining</em> process,</li>
	 * <li>a boolean indicating the result of the <em>linking</em> process, and</li>
	 * <li>a boolean indicating the result of the <em>library entry expanding</em> process.</li>
	 * </ul>
	 *
	 * @author mfreund
	 */
	public static class TransformationResult {

		/**
		 * This class encapsulates the various results of the <em>matching</em> process during a generic transformation:
		 * <br />
		 * <ul>
		 * <li>the status of the matching process,</li>
		 * <li>a list of selected {@link MappingInstanceStorage mappings},</li>
		 * <li>a map of selected {@link MappingInstanceStorage mappings}, associated with the {@link Mapping} that they
		 * represent,</li>
		 * <li>{@link HintValueStorage exported hint values},</li>
		 * <li>a map describing values for {@link GlobalAttribute GlobalAttributes}</li>
		 * </ul>
		 *
		 * @author mfreund
		 *
		 */
		static class MatchingResult {

			/**
			 * This describes the status of the matching process, '<em><b>true</b></em>' meaning that the matching
			 * process has been canceled, '<em><b>false</b></em>' otherwise.
			 */
			private final boolean canceled;

			/**
			 * This is the list of {@link MappingInstanceStorage mappings} that have been selected during the
			 * <em>matching</em> process.
			 */
			private final List<MappingInstanceStorage> selectedMappings;

			/**
			 * This the map of {@link MappingInstanceStorage mappings} that have been selected during the
			 * <em>matching</em> process associated with the {@link Mapping} that they represent.
			 */
			private final Map<Mapping, List<MappingInstanceStorage>> selectedMappingsByMapping;

			/**
			 * This constructs an instance.
			 *
			 * @param canceled
			 *            '<em><b>true</b></em>' indicates that the matching process was canceled,
			 *            '<em><b>false</b></em>' indicates that the matching process completed successfully.
			 * @param selectedMappings
			 *            The list of {@link MappingInstanceStorage mappings} that have been selected during the
			 *            <em>matching</em> process.
			 * @param selectedMappingsByMapping
			 *            The map of {@link MappingInstanceStorage mappings} that have been selected during the
			 *            <em>matching</em> process associated with the {@link Mapping} that they represent.
			 * @param exportedMappingHints
			 *            The {@link HintValueStorage} containing values for exported mapping hints.
			 * @param libEntryInstantiatorMap2
			 */
			private MatchingResult(boolean canceled, List<MappingInstanceStorage> selectedMappings,
					Map<Mapping, List<MappingInstanceStorage>> selectedMappingsByMapping) {

				this.canceled = canceled;
				this.selectedMappings = selectedMappings;
				this.selectedMappingsByMapping = selectedMappingsByMapping;
			}

			/**
			 * This constructs an instance for a matching process that has been canceled.
			 *
			 * @return An instance of {@link MatchingResult} indicating that the matching was canceled.
			 */
			public static MatchingResult createMatchingCanceledResult() {

				return new MatchingResult(true, null, null);
			}

			/**
			 * This constructs an instance for a matching process that has finished successfully.
			 *
			 * @param selectedMappings
			 *            The list of {@link MappingInstanceStorage mappings} that have been selected during the
			 *            <em>matching</em> process.
			 * @param selectedMappingsByMapping
			 *            The map of {@link MappingInstanceStorage mappings} that have been selected during the
			 *            <em>matching</em> process associated with the {@link Mapping} that they represent.
			 * @return An instance of {@link MatchingResult} indicating that the matching has completed successfully.
			 */
			public static MatchingResult createMatchingCompletedResult(List<MappingInstanceStorage> selectedMappings,
					Map<Mapping, List<MappingInstanceStorage>> selectedMappingsByMapping) {

				return new MatchingResult(false, selectedMappings, selectedMappingsByMapping);
			}

			/**
			 * This is the getter for the {@link #canceled}.
			 *
			 * @return The status of the matching process, '<em><b>true</b></em>' meaning that the matching process has
			 *         been canceled, '<em><b>false</b></em>' otherwise.
			 */
			boolean isCanceled() {

				return this.canceled;
			}

			/**
			 * This is the getter for the {@link #selectedMappings}.
			 *
			 * @return The list of {@link MappingInstanceStorage mappings} that have been selected during the
			 *         <em>matching</em> process.
			 */
			List<MappingInstanceStorage> getSelectedMappings() {

				return this.selectedMappings;
			}

			/**
			 * This is the getter for the {@link #selectedMappingsByMapping}.
			 *
			 * @return The map of {@link MappingInstanceStorage mappings} that have been selected during the
			 *         <em>matching</em> process associated with the {@link Mapping} that they represent.
			 */
			Map<Mapping, List<MappingInstanceStorage>> getSelectedMappingsByMapping() {

				return this.selectedMappingsByMapping;
			}

		}

		/**
		 * This class encapsulates the various results of the <em>expanding</em> process during a generic
		 * transformation: <br />
		 * <ul>
		 * <li>an {@link AttributeValueRegistry} containing registered attribute values,</li>
		 * <li>a {@link TargetSectionRegistry} containing/representing created target sections</li>
		 * </ul>
		 *
		 * @author mfreund
		 *
		 */
		static class ExpandingResult {

			/**
			 * A {@link TargetSectionRegistry} containing/representing created target sections.
			 */
			private final TargetSectionRegistry targetSectionRegistry;

			/**
			 * This constructs an instance for an expanding process.
			 *
			 * @param targetSectionRegistry
			 *            The {@link TargetSectionRegistry} containing/representing created target sections.
			 */
			private ExpandingResult(TargetSectionRegistry targetSectionRegistry) {

				this.targetSectionRegistry = targetSectionRegistry;
			}

			/**
			 * This constructs an instance for an expanding process.
			 *
			 * @param targetSectionRegistry
			 *            The {@link TargetSectionRegistry} containing/representing created target sections.
			 *
			 * @return An instance of {@link ExpandingResult}.
			 */
			public static ExpandingResult createExpandingResult(TargetSectionRegistry targetSectionRegistry) {

				return new ExpandingResult(targetSectionRegistry);
			}

			/**
			 * This is the getter for the {@link #targetSectionRegistry}. return A {@link TargetSectionRegistry}
			 * containing/representing created target sections.
			 */
			TargetSectionRegistry getTargetSectionRegistry() {

				return this.targetSectionRegistry;
			}

		}

		/**
		 * This class encapsulates the various results of the <em>joining</em> process during a generic transformation:
		 * <br />
		 * <ul>
		 * <li>the status of the matching process,</li>
		 * <li>a {@link TargetModelRegistry} representing the target models to be created</li>
		 * </ul>
		 *
		 * @author mfreund
		 *
		 */
		static class JoiningResult {

			/**
			 * This describes the status of the matching process, '<em><b>true</b></em>' meaning that the matching
			 * process has been canceled, '<em><b>false</b></em>' otherwise.
			 */
			private final boolean canceled;

			/**
			 * The {@link TargetModelRegistry} representing the target models to be created.
			 */
			private TargetModelRegistry targetModelRegistry;

			/**
			 * This constructs an instance.
			 *
			 * @param canceled
			 *            '<em><b>true</b></em>' indicates that the joining process was canceled,
			 *            '<em><b>false</b></em>' indicates that the joining process completed successfully.
			 * @param targetModelRegistry
			 */
			private JoiningResult(boolean canceled, TargetModelRegistry targetModelRegistry) {

				this.canceled = canceled;
				this.targetModelRegistry = targetModelRegistry;
			}

			/**
			 * This constructs an instance for a joining process that has been canceled.
			 *
			 * @return An instance of {@link JoiningResult} indicating that the joining was canceled.
			 */
			public static JoiningResult createJoiningCanceledResult() {

				return new JoiningResult(true, null);
			}

			/**
			 * This constructs an instance for a joining process that has finished successfully.
			 *
			 * @param targetModelRegistry
			 *            The {@link TargetModelRegistry} instance representing the target models to be created.
			 * @return An instance of {@link JoiningResult} indicating that the joining has completed successfully.
			 */
			public static JoiningResult createJoiningCompletedResult(TargetModelRegistry targetModelRegistry) {

				return new JoiningResult(false, targetModelRegistry);
			}

			/**
			 * This is the getter for the {@link #canceled}.
			 *
			 * @return The status of the matching process, '<em><b>true</b></em>' meaning that the matching process has
			 *         been canceled, '<em><b>false</b></em>' otherwise.
			 */
			boolean isCanceled() {

				return this.canceled;
			}

			/**
			 * This is the getter for the {@link #targetModelRegistry}.
			 *
			 * @return The {@link TargetModelRegistry} representing the target models to be created.
			 */
			TargetModelRegistry getTargetModelRegistry() {

				return this.targetModelRegistry;
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
		 * @return '<em><b>true</b></em>' if and only if every phase of the transformation completed successfully;
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
	 * A {@link MessageDialog} that informs about an error and asks the user whether he wants to continue or to abort.
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
		 *            The parent shell of the dialog, or <code>null</code> if none.
		 * @param dialogMessage
		 *            The message to display to the user.
		 * @return '<em><b>true</b></em>' if the user selected <em>Continue</em>, '<em><b>false</b></em>' if he selected
		 *         <em>Abort</em>.
		 */
		public static boolean open(Shell parentShell, String dialogMessage) {

			ErrorDialog dialog = new ErrorDialog(parentShell, dialogMessage);
			return dialog.open() == 0;
		}
	}

	/**
	 * A {@link MessageDialog} that asks for a name for the name of the TransformationModel to be created..
	 *
	 * @author mfreund
	 */
	private static class TransformationModelNameDialog extends MessageDialog {

		/**
		 * The {@link Text} where the user enters the name for the TransformationModel.
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
		 * @return The name that was specified by the user or an empty String if the user did not specify anything.
		 */
		private String getResult() {

			return this.transformationModelName;
		}

		/**
		 * This creates and opens a dialog.
		 *
		 * @param parentShell
		 *            The parent shell of the dialog, or <code>null</code> if none.
		 * @return If the user selected 'OK', this returns the name that was specified by the user or an empty String if
		 *         the user did not specify anything; if the user selected 'Abort', this returns '<em>null</em>'.
		 */
		public static String open(Shell parentShell) {

			TransformationModelNameDialog dialog = new TransformationModelNameDialog(parentShell);
			return dialog.open() == 0 ? dialog.getResult() : null;
		}
	}
}
