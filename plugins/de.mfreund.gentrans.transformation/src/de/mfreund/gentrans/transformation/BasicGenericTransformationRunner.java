/**
 *
 */
package de.mfreund.gentrans.transformation;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.HintValueStorage;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
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
import de.mfreund.gentrans.transformation.util.CancelableElement;
import de.mfreund.pamtram.transformation.Transformation;
import de.mfreund.pamtram.transformation.TransformationFactory;
import de.mfreund.pamtram.transformation.TransformationMapping;
import de.mfreund.pamtram.transformation.TransformationMappingHintGroup;
import pamtram.FixedValue;
import pamtram.PAMTraM;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.extended.MappingHint;
import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.source.SourceSection;

/**
 * A basic runner that can be used to execute a <em>generic transformation</em> based on a given
 * {@link TransformationConfiguration} and that is not dependent on any (UI-related) Eclipse features like Monitors or
 * MessageDialogs.
 * <p />
 * Note: Instances need to be created via the {@link GenericTransformationRunnerFactory}.
 *
 * @author mfreund
 */
public class BasicGenericTransformationRunner extends CancelableElement {

	protected static final String TRANSFORMATION_ABORTED_MESSAGE = "Transformation aborted.";

	/**
	 * The {@link TransformationConfiguration} providing the parameters for the transformation.
	 */
	protected TransformationConfiguration transformationConfig;

	/**
	 * The {@link TransformationAssetManager} encapsulating the various helper objects that will be used during the
	 * transformation.
	 */
	protected TransformationAssetManager assetManager;

	/**
	 * This creates an instance based on the given {@link TransformationConfiguration}.
	 * <p />
	 * Note: This will use a default {@link Logger} implementation to print log messages.
	 *
	 * @see #AbstractGenericTransformationRunner(TransformationConfiguration, Logger)
	 *
	 * @param config
	 *            The {@link TransformationConfiguration} specifying all parameters necessary for the execution of the
	 *            transformation.
	 */
	protected BasicGenericTransformationRunner(TransformationConfiguration config) {

		super();
		this.transformationConfig = config;
		this.assetManager = new TransformationAssetManager(config);
	}

	/**
	 * This creates an instance based on the given {@link TransformationConfiguration}.
	 * <p />
	 * Note: This will use the given {@link Logger} implementation to print log messages.
	 *
	 * @see #AbstractGenericTransformationRunner(TransformationConfiguration)
	 *
	 * @param config
	 *            The {@link TransformationConfiguration} specifying all parameters necessary for the execution of the
	 *            transformation.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 */
	protected BasicGenericTransformationRunner(TransformationConfiguration config, Logger logger) {

		super();
		this.transformationConfig = config;
		this.assetManager = new TransformationAssetManager(config, logger);

	}

	/**
	 * This performs the actual generic transformation. It loads all necessary models, executes the mappings defined in
	 * the PAMTraM model and stores the generated target model. All progress is reported to the given
	 * '<em>monitor</em>'.
	 *
	 * @return '<em>true</em>' if the transformation completed successfully; '<em>false</em>' otherwise
	 */
	public boolean runTransformation() {

		try {

			final Date startTime = new Date();

			// Prepare the transformation (validate pamtram model, merge extends, etc.)
			//
			if (!this.prepare()) {
				this.assetManager.getLogger().severe(BasicGenericTransformationRunner.TRANSFORMATION_ABORTED_MESSAGE);
				return false;
			}

			// Perform the various phases of the transformation
			//
			this.executeMappings();

			// Persist the create target model(s)
			//
			if (this.isCanceled() || !this.storeTargetModels()) {
				return false;
			}

			final Date endTime = new Date();

			// Populate and store the transformation model (if necessary)
			//
			this.generateTransformationModel(startTime, endTime);

			this.writePamtramMessage(
					"Transformation done. Time: " + (endTime.getTime() - startTime.getTime()) / 1000d + "s");

		} catch (CancelTransformationException e1) {

			this.assetManager.getLogger().log(Level.SEVERE, e1, e1::printInfo);
			this.assetManager.getLogger().severe("See the ErrorLog for more information!");
			this.assetManager.getLogger().severe("Aborting...");
			return false;
		} catch (RuntimeException e) {

			this.assetManager.getLogger().log(Level.SEVERE, e,
					() -> e.getMessage() != null ? e.getMessage() : e.toString());
			this.assetManager.getLogger().severe("See the ErrorLog for more information!");
			this.assetManager.getLogger().severe("Aborting...");

			return false;
		}

		return true;

	}

	/**
	 * Prepare the transformation by {@link TransformationConfiguration#validate() validating} the
	 * TransformationConfiguration, {@link #validatePamtramModels() validating} the {@link PAMTraM} model, and
	 * {@link PAMTraM#mergeExtends() merging extends}.
	 * <p />
	 * This should be called at least once before starting the actual transformation.
	 *
	 */
	protected boolean prepare() {

		this.writePamtramMessage("Preparing Transformation");

		this.assetManager.getLogger().fine("Validating transformation configuration...");

		// validate the TransformationConfiguration
		//
		if (!this.transformationConfig.validate()) {
			return false;
		}

		this.assetManager.getLogger().info(this.transformationConfig::toString);

		this.assetManager.getLogger().fine("Validation successful!");

		// validate the PAMTraM model
		//
		if (!this.validatePamtramModels()) {
			return false;
		}

		this.assetManager.getLogger().fine("\nPreparing PAMTraM Models");

		// Before we can use the PAMTraM model, we need merge all extended
		// HintGroups or Sections.
		// That way, we get a 'clean' model (without any extensions) that we can
		// handle in a normal way
		//
		try {
			this.transformationConfig.getPamtramModels().stream().forEach(PAMTraM::mergeExtends);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CancelTransformationException("Internal error during prepration of the PAMTraM model!", e);
		}

		this.assetManager.getLogger().fine("Preparation successful!");

		// Initialize the ambiguity resolving strategy
		//
		this.assetManager.getLogger().fine("\nInitializing ambiguity resolving strategy...");
		try {

			this.transformationConfig.getAmbiguityResolvingStrategy().init(this.transformationConfig.getPamtramModels(),
					this.transformationConfig.getSourceModels(), this.assetManager.getLogger());
			this.assetManager.getLogger().fine("Initialization successful!");

		} catch (Exception e1) {
			this.assetManager.getLogger().log(Level.SEVERE, e1,
					() -> e1.getMessage() != null ? e1.getMessage() : e1.toString());
			this.assetManager.getLogger().warning("Internal error. Switching to DefaultAmbiguityResolvingStrategy...");
			this.transformationConfig.withAmbiguityResolvingStrategy(new DefaultAmbiguityResolvingStrategy());
		}

		return true;
	}

	/**
	 * This validates the given {@link PAMTraM} models using a {@link Diagnostician}. If errors occur, the user is asked
	 * whether to proceed anyway.
	 *
	 * @return '<em><b>true</b></em>' if the validation succeeded or if the user chose to ignore errors;
	 *         '<em><b>false/b></em>' otherwise.
	 */
	protected boolean validatePamtramModels() {

		this.assetManager.getLogger().fine("\nValidating PAMTraM models...");

		Set<Integer> diags = this.transformationConfig.getPamtramModels().stream()
				.map(pamtramModel -> Diagnostician.INSTANCE.validate(pamtramModel).getSeverity())
				.collect(Collectors.toSet());

		if (diags.contains(Diagnostic.ERROR)) {

			this.assetManager.getLogger().fine("Validation completed with errors!");
			return false;

		} else {
			this.assetManager.getLogger().fine("Validation successful!");
			return true;
		}

	}

	/**
	 * This performs the actual execution of the transformation. In the course of this method, the various phases of the
	 * transformation get executed.
	 *
	 */
	protected void executeMappings() {

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
	protected void performSearching_MatchSections() {

		List<PAMTraM> pamtramModels = this.transformationConfig.getPamtramModels();

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

	}

	/**
	 * This performs the second step of the '<em>searching</em>' phase of the transformation (the selection of the
	 * {@link Mapping Mappings}. Therefore, it iterates through the list of '<em>sourceModels</em>' defined in the
	 * {@link #transformationConfig} and {@link SourceSectionMatcher#matchSections() matches SourceSections},
	 * {@link MappingSelector#selectMappings() selects mappings} and {@link HintValueExtractor#extractHintValues()
	 * extracts hint values}.
	 */
	protected void performSearching_SelectMappings() {

		List<PAMTraM> pamtramModels = this.transformationConfig.getPamtramModels();

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

	}

	/**
	 * This performs the '<em>extracting</em>' phase of the transformation (the extraction of values for the selected
	 * {@link Mapping Mappings} resp. the contained {@link MappingHint MappingHints}.
	 */
	protected void performExtracting() {

		/*
		 * Calculate values of mapping hints
		 */
		this.writePamtramMessage("Extracting Hint Values");

		HintValueExtractor hintValueExtractor = this.assetManager.getHintValueExtractor();

		hintValueExtractor.extractHintValues(this.assetManager.getSelectedMappingRegistry().getMappingInstaces());

	}

	/**
	 * This performs the '<em>instantiating</em>' step of the transformation: The target sections (excluding those that
	 * are defined by {@link LibraryEntry LibraryEntries}) are instantiated (only containment references and attributes
	 * but no non-containment references).
	 */
	protected void performInstantiating() {

		/*
		 * Instantiate the TargetSections
		 */
		this.writePamtramMessage("Instantiating TargetSections for Selected Mappings");

		TargetSectionInstantiator targetSectionInstantiator = this.assetManager.getTargetSectionInstantiator();

		targetSectionInstantiator
				.expandTargetSectionInstances(this.assetManager.getSelectedMappingRegistry().getMappingInstaces());

	}

	/**
	 * This performs the '<em>joining</em>' step of the transformation: The target sections that have been instantiated
	 * during the {@link #performInstantiating() expanding step} are linked via containment references and added to the
	 * target model. If necessary, intermediary object are created as well.
	 */
	protected void performJoining() {

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

	}

	/**
	 * This performs the '<em>linking</em>' step of the transformation: Necessary cross references between the created
	 * target sections are instantiated.
	 */
	protected void performLinking() {

		/*
		 * Link the instantiated TargetSections
		 */
		this.writePamtramMessage("Linking Instantiated TargetSections");

		TargetSectionLinker targetSectionLinker = this.assetManager.getTargetSectionLinker();

		targetSectionLinker.linkTargetSections(this.assetManager.getSelectedMappingRegistry().getMappingInstaces());

	}

	/**
	 * This performs the final step of the transformation: The stored library entries are finally instantiated in the
	 * target model.
	 */
	protected void performInstantiatingLibraryEntries() {

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

	}

	/**
	 * This persists all target models created during the transformation in the corresponding {@link Resource
	 * Resources}.
	 *
	 * @return '<em><b>true</b></em>' if all resources have successfully been saved; '<em><b>false</b></em>' otherwise.
	 */
	protected boolean storeTargetModels() {

		/*
		 * create the target models
		 */
		this.writePamtramMessage("Storing Target Model(s).");

		return this.assetManager.getTargetModelRegistry().saveTargetModels();
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
	protected boolean generateTransformationModel(Date startTime, Date endTime) {

		// Check if we need to create a transformation model
		//
		if (this.transformationConfig.getTransformationModelPath() == null) {
			return false;
		}

		Optional<String> transformationModelName = this.getTransformationModelName();
		if (!transformationModelName.isPresent()) {
			return false;
		}

		// Create the TransformationModel for the performed transformation
		//
		Transformation transformationModel = this.internalGenerateTransformationModel(startTime, endTime,
				transformationModelName.get());

		/*
		 * save the transformation model and create copies of all referenced resources
		 */
		try {
			this.internalPersistTransformationModel(transformationModel);
		} catch (final IOException e) {
			this.assetManager.getLogger().log(Level.SEVERE, e,
					() -> "The XMI resource for the TransformationModel could not be created.");
			return false;
		}

		return true;
	}

	/**
	 * Get the {@link Transformation#getName() name} of the TransformationModel to store.
	 * <p />
	 * This default implementation simply returns the current date as name.
	 *
	 * @return The name that shall be used or an empty optional if no TransformationModel shall be created.
	 */
	protected Optional<String> getTransformationModelName() {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return Optional.of(df.format(Calendar.getInstance().getTime()));

	}

	/**
	 * Create the {@link Transformation Transformation model} instance for the current transformation.
	 *
	 * @param startTime
	 *            The {@link Date} to set as {@link Transformation#setStartDate(Date) startDate} for the transformation.
	 * @param endTime
	 *            The {@link Date} to set as {@link Transformation#setEndDate(Date) endDate} for the transformation.
	 * @return The {@link Transformation Transformation model} instance.
	 */
	protected Transformation internalGenerateTransformationModel(Date startTime, Date endTime,
			String transformationModelName) {

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

		return transformationModel;
	}

	/**
	 * Persist the given {@link Transformation Transformation model} instance as well as all associated files (PAMTraM,
	 * source, and target models as well as library files, etc.) to the file system.
	 *
	 * @param transformationModel
	 *            The {@link Transformation Transformation model} instance to persist.
	 *
	 * @throws IOException
	 *             If an errors occurs while saving one of the files.
	 */
	protected void internalPersistTransformationModel(Transformation transformationModel) throws IOException {

		final XMIResourceFactoryImpl resFactory = new XMIResourceFactoryImpl();

		String fileExtension = PamtramEditPlugin.INSTANCE.getString("TRANSFORMATION_MODEL_FILE_ENDING");
		URI transformationFolderUri = URI
				.createPlatformResourceURI(this.transformationConfig.getTransformationModelPath(), true)
				.appendSegment(transformationModel.getName());
		URI transformationModelUri = transformationFolderUri
				.appendSegment(transformationModel.getName() + fileExtension);

		final Map<Object, Object> options = new LinkedHashMap<>();
		// suppress 'document root' element in case of XML models
		//
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);

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
			 * As multiple target models can be contained in the same resource, we first check if there already exists a
			 * resource for the target model. Only if no resource exists, we create a new one.
			 */
			URI targetModelUri = transformationFolderUri.appendSegment(targetModel.eResource().getURI().lastSegment());
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

	}

	/**
	 * Writes a message on the console that helps to divide the transformation output into different stages of the
	 * transformation
	 *
	 * @param msg
	 *            The message to be printed to the console
	 */
	protected void writePamtramMessage(final String msg) {

		this.assetManager.getLogger().info(() -> "\n################# " + msg + " #################\n");
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
		public static class MatchingResult {

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
		public static class ExpandingResult {

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
		public static class JoiningResult {

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

}