/**
 *
 */
package de.mfreund.gentrans.transformation.core;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.TransformationConfiguration;
import de.mfreund.gentrans.transformation.calculation.InstanceSelectorHandler;
import de.mfreund.gentrans.transformation.calculation.ValueCalculator;
import de.mfreund.gentrans.transformation.calculation.ValueConstraintReferenceValueCalculator;
import de.mfreund.gentrans.transformation.calculation.ValueModifierExecutor;
import de.mfreund.gentrans.transformation.condition.ConditionHandler;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.mfreund.gentrans.transformation.expanding.TargetSectionConnector;
import de.mfreund.gentrans.transformation.expanding.TargetSectionInstantiator;
import de.mfreund.gentrans.transformation.expanding.TargetSectionLinker;
import de.mfreund.gentrans.transformation.maps.ElementIDMap;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.matching.GlobalAttributeValueExtractor;
import de.mfreund.gentrans.transformation.matching.HintValueExtractor;
import de.mfreund.gentrans.transformation.matching.MappingSelector;
import de.mfreund.gentrans.transformation.matching.SourceSectionMatcher;
import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
import de.mfreund.gentrans.transformation.registries.SelectedMappingRegistry;
import de.mfreund.gentrans.transformation.registries.TargetModelRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.util.CancelableElement;
import de.mfreund.gentrans.transformation.util.ICancelable;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPlugin;
import pamtram.FixedValue;
import pamtram.condition.Condition;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.InstanceSelector;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.source.SourceSection;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.util.GenLibraryManager;

/**
 * A control class that encapsulates the various assets (handlers, registries and calculators) that are used at multiple
 * points during a transformation and handles their instantiation.
 * <p />
 * Note: The various getters all handle the prior instantiation of the respective asset automatically.
 *
 * @author mfreund
 */
public class TransformationAssetManager extends CancelableElement {

	/**
	 * The {@link Logger} that shall be used to print messages.
	 */
	private Logger logger;

	/**
	 * This keeps track of {@link ICancelable cancelable} assets that need to be canceled when the user requests an
	 * early termination of the transformation.
	 */
	private List<ICancelable> objectsToCancel;

	/**
	 * The {@link GlobalValueMap} where extracted global {@link FixedValue FixedValues} and values of
	 * {@link GlobalAttribute GlobalAttributes} are stored.
	 */
	private GlobalValueMap globalValues;

	/**
	 * The {@link ElementIDMap} managing model-unique ids of {@link EObject elements}.
	 */
	private ElementIDMap elementIDs;

	/**
	 * The {@link MatchedSectionRegistry} where the various source model snippets that are matched against
	 * {@link SourceSection SourceSections} during a transformation are stored.
	 */
	private MatchedSectionRegistry matchedSectionRegistry;

	/**
	 * The {@link SelectedMappingRegistry} where the various selected {@link Mapping Mappings} as well as the associated
	 * {@link MappingInstanceDescriptor Mapping instances} are stored.
	 */
	private SelectedMappingRegistry selectedMappingRegistry;

	/**
	 * The {@link TargetSectionRegistry} where instantiated {@link TargetSection TargetSections} are stored.
	 */
	private TargetSectionRegistry targetSectionRegistry;

	/**
	 * The {@link TargetModelRegistry} that keeps track of the various target models to be created.
	 */
	private TargetModelRegistry targetModelRegistry;

	/**
	 * The {@link TransformationConfiguration} that this operates on.
	 */
	private TransformationConfiguration transformationConfig;

	/**
	 * The {@link ValueModifierExecutor} used to apply {@link ValueModifierSet ValueModifierSets}.
	 */
	private ValueModifierExecutor valueModifierExecutor;

	/**
	 * The {@link ValueCalculator} used e.g. to calculate values of {@link TargetSectionAttribute
	 * TargetSectionAttributes}.
	 */
	private ValueCalculator valueCalculator;

	/**
	 * This {@link ValueConstraintReferenceValueCalculator} will be used for calculating referenceValues that are needed
	 * for {@link ValueConstraint}.
	 */
	private ValueConstraintReferenceValueCalculator valueConstraintReferenceValueCalculator;

	/**
	 * The {@link InstanceSelectorHandler} used to extract specific model elements via modeled {@link InstanceSelector
	 * InstanceSelectors}.
	 */
	private InstanceSelectorHandler instanceSelectorHandler;

	/**
	 * The {@link ConditionHandler} that is used to evaluate {@link Condition Conditions}.
	 */
	private ConditionHandler conditionHandler;

	/**
	 * The {@link MappingSelector} that is use to select the {@link Mapping Mapping(s)} to be applied for the
	 * {@link #matchedSectionRegistry matched sections}.
	 */
	private MappingSelector mappingSelector;

	/**
	 * The {@link HintValueExtractor} that is used to extract values for the various types of {@link MappingHint
	 * MappingHints}.
	 */
	private HintValueExtractor hintValueExtractor;

	/**
	 * The {@link GlobalAttributeValueExtractor} that is used to extract values of {@link GlobalAttribute
	 * GlobalAttributes}.
	 */
	private GlobalAttributeValueExtractor globalAttributeValueExtractor;

	/**
	 * The {@link SourceSectionMatcher} that is used to perform the <em>matching</em> phase of the transformation.
	 */
	private SourceSectionMatcher sourceSectionMatcher;

	/**
	 * The {@link TargetSectionInstantiator} that is used to perform the <em>instantiating</em> phase of the
	 * transformation.
	 */
	private TargetSectionInstantiator targetSectionInstantiator;

	/**
	 * The {@link TargetSectionConnector} that is used to perform the <em>joining</em> phase of the transformation.
	 */
	private TargetSectionConnector targetSectionConnector;

	/**
	 * The {@link TargetSectionLinker} that is used to perform the <em>linking</em> phase of the transformation.
	 */
	private TargetSectionLinker targetSectionLinker;

	/**
	 * The {@link GenLibraryManager} that provides access to the {@link LibraryPlugin LibraryPlugins} required for
	 * instantiation of {@link LibraryEntry LibraryEntries} during the <em>library entry instantiation</em> phase of the
	 * transformation.
	 */
	private GenLibraryManager genLibraryManager;

	/**
	 * This creates an instance using a default {@link Logger}.
	 *
	 * @see #TransformationAssetManager(TransformationConfiguration, Logger)
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} that this operates on.
	 */
	public TransformationAssetManager(TransformationConfiguration transformationConfig) {

		this.transformationConfig = transformationConfig;
		this.objectsToCancel = new ArrayList<>();
	}

	/**
	 * This creates an instance using the specified {@link Logger}.
	 *
	 * @see #TransformationAssetManager(TransformationConfiguration)
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} that this operates on.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 */
	public TransformationAssetManager(TransformationConfiguration transformationConfig, Logger logger) {

		this.transformationConfig = transformationConfig;
		this.logger = logger;
		this.objectsToCancel = new ArrayList<>();
	}

	/**
	 * Returns the {@link #transformationConfig}.
	 *
	 * @return the {@link #transformationConfig}}
	 */
	public TransformationConfiguration getTransformationConfig() {

		return this.transformationConfig;
	}

	/**
	 * This initializes the {@link #logger}.
	 */
	protected void initLogger() {

		this.logger = Logger
				.getLogger("de.mfreund.gentrans.transformation " + DateFormat.getDateTimeInstance().format(new Date()));
		this.logger.setLevel(this.transformationConfig.getLogLevel());

	}

	/**
	 * Returns the {@link #logger}.
	 *
	 * @return the {@link #logger}}
	 */
	public Logger getLogger() {

		if (this.logger == null) {
			this.initLogger();
		}

		return this.logger;
	}

	/**
	 * This initializes the {@link #globalValues}.
	 */
	protected void initGlobalValues() {

		this.globalValues = new GlobalValueMap();
	}

	/**
	 * Returns the {@link #globalValues}.
	 *
	 * @return the {@link #globalValues}}
	 */
	public GlobalValueMap getGlobalValues() {

		if (this.globalValues == null) {
			this.initGlobalValues();
		}

		return this.globalValues;
	}

	/**
	 * This initializes the {@link #elementIDs}.
	 */
	protected void initElementIDs() {

		this.elementIDs = new ElementIDMap();
	}

	/**
	 * Returns the {@link #elementIDs}.
	 *
	 * @return the {@link #elementIDs}}
	 */
	public ElementIDMap getElementIDs() {

		if (this.elementIDs == null) {
			this.initElementIDs();
		}

		return this.elementIDs;
	}

	/**
	 * This initializes the {@link #matchedSectionRegistry}.
	 */
	protected void initMatchedSectionRegistry() {

		this.matchedSectionRegistry = new MatchedSectionRegistry(this);
	}

	/**
	 * Returns the {@link #matchedSectionRegistry}.
	 *
	 * @return the {@link #matchedSectionRegistry}
	 */
	public MatchedSectionRegistry getMatchedSectionRegistry() {

		if (this.matchedSectionRegistry == null) {
			this.initMatchedSectionRegistry();
		}

		return this.matchedSectionRegistry;
	}

	/**
	 * This initializes the {@link #selectedMappingRegistry}.
	 */
	protected void initSelectedMappingRegistry() {

		this.selectedMappingRegistry = new SelectedMappingRegistry();
	}

	/**
	 * Returns the {@link #selectedMappingRegistry}.
	 *
	 * @return the {@link #selectedMappingRegistry}
	 */
	public SelectedMappingRegistry getSelectedMappingRegistry() {

		if (this.selectedMappingRegistry == null) {
			this.initSelectedMappingRegistry();
		}

		return this.selectedMappingRegistry;
	}

	/**
	 * This initializes the {@link #targetSectionRegistry}.
	 */
	protected void initTargetSectionRegistry() {

		this.targetSectionRegistry = new TargetSectionRegistry(this);

		this.objectsToCancel.add(this.targetSectionRegistry);
	}

	/**
	 * Returns the {@link #targetSectionRegistry}.
	 *
	 * @return the {@link #targetSectionRegistry}
	 */
	public TargetSectionRegistry getTargetSectionRegistry() {

		if (this.targetSectionRegistry == null) {
			this.initTargetSectionRegistry();
		}

		return this.targetSectionRegistry;
	}

	/**
	 * This initializes the {@link #targetModelRegistry}.
	 */
	protected void initTargetModelRegistry() {

		this.targetModelRegistry = new TargetModelRegistry(this, Optional.empty());
	}

	/**
	 * Returns the {@link #targetModelRegistry}.
	 *
	 * @return the {@link #targetModelRegistry}
	 */
	public TargetModelRegistry getTargetModelRegistry() {

		if (this.targetModelRegistry == null) {
			this.initTargetModelRegistry();
		}

		return this.targetModelRegistry;
	}

	/**
	 * This initializes the {@link #valueModifierExecutor}.
	 */
	protected void initValueModifierExecutor() {

		this.valueModifierExecutor = new ValueModifierExecutor(this);
	}

	/**
	 * Returns the {@link #valueModifierExecutor}.
	 *
	 * @return the {@link #valueModifierExecutor}
	 */
	public ValueModifierExecutor getValueModifierExecutor() {

		if (this.valueModifierExecutor == null) {
			this.initValueModifierExecutor();
		}

		return this.valueModifierExecutor;
	}

	/**
	 * This initializes the {@link #valueCalculator}.
	 */
	protected void initValueCalculator() {

		this.valueCalculator = new ValueCalculator(this);
	}

	/**
	 * Returns the {@link #valueCalculator}.
	 *
	 * @return the {@link #valueCalculator}
	 */
	public ValueCalculator getValueCalculator() {

		if (this.valueCalculator == null) {
			this.initValueCalculator();
		}

		return this.valueCalculator;
	}

	/**
	 * This initializes the {@link #instanceSelectorHandler}.
	 */
	protected void initInstanceSelectorHandler() {

		this.instanceSelectorHandler = new InstanceSelectorHandler(this);
	}

	/**
	 * Returns the {@link #instanceSelectorHandler}.
	 *
	 * @return the {@link #instanceSelectorHandler}
	 */
	public InstanceSelectorHandler getInstanceSelectorHandler() {

		if (this.instanceSelectorHandler == null) {
			this.initInstanceSelectorHandler();
		}

		return this.instanceSelectorHandler;
	}

	/**
	 * This initializes the {@link #valueConstraintReferenceValueCalculator}.
	 */
	protected void initValueConstraintReferenceValueCalculator() {

		this.valueConstraintReferenceValueCalculator = new ValueConstraintReferenceValueCalculator(this);
	}

	/**
	 * Returns the {@link #valueConstraintReferenceValueCalculator}.
	 *
	 * @return the {@link #valueConstraintReferenceValueCalculator}
	 */
	public ValueConstraintReferenceValueCalculator getValueConstraintReferenceValueCalculator() {

		if (this.valueConstraintReferenceValueCalculator == null) {
			this.initValueConstraintReferenceValueCalculator();
		}

		return this.valueConstraintReferenceValueCalculator;
	}

	/**
	 * This initializes the {@link #conditionHandler}.
	 */
	protected void initConditionHandler() {

		this.conditionHandler = new ConditionHandler(this);
	}

	/**
	 * Returns the {@link #conditionHandler}.
	 *
	 * @return the {@link #instanceSelectorHandler}
	 */
	public ConditionHandler getConditionHandler() {

		if (this.conditionHandler == null) {
			this.initConditionHandler();
		}

		return this.conditionHandler;
	}

	/**
	 * This initializes the {@link #mappingSelector}.
	 */
	protected void initMappingSelector() {

		this.mappingSelector = new MappingSelector(this);
		this.objectsToCancel.add(this.mappingSelector);
	}

	/**
	 * Returns the {@link #mappingSelector}.
	 *
	 * @return the {@link #mappingSelector}
	 */
	public MappingSelector getMappingSelector() {

		if (this.mappingSelector == null) {
			this.initMappingSelector();
		}

		return this.mappingSelector;
	}

	/**
	 * This initializes the {@link #hintValueExtractor}.
	 */
	protected void initHintValueExtractor() {

		this.hintValueExtractor = new HintValueExtractor(this);
		this.objectsToCancel.add(this.hintValueExtractor);
	}

	/**
	 * Returns the {@link #hintValueExtractor}.
	 *
	 * @return the {@link #hintValueExtractor}
	 */
	public HintValueExtractor getHintValueExtractor() {

		if (this.hintValueExtractor == null) {
			this.initHintValueExtractor();
		}

		return this.hintValueExtractor;
	}

	/**
	 * This initializes the {@link #globalAttributeValueExtractor}.
	 */
	protected void initGlobalAttributeValueExtractor() {

		this.globalAttributeValueExtractor = new GlobalAttributeValueExtractor(this);
		this.objectsToCancel.add(this.globalAttributeValueExtractor);
	}

	/**
	 * Returns the {@link #globalAttributeValueExtractor}.
	 *
	 * @return the {@link #globalAttributeValueExtractor}
	 */
	public GlobalAttributeValueExtractor getGlobalAttributeValueExtractor() {

		if (this.globalAttributeValueExtractor == null) {
			this.initGlobalAttributeValueExtractor();
		}

		return this.globalAttributeValueExtractor;
	}

	/**
	 * This initializes the {@link #sourceSectionMatcher}.
	 */
	protected void initSourceSectionMatcher() {

		this.sourceSectionMatcher = new SourceSectionMatcher(this);
		this.objectsToCancel.add(this.sourceSectionMatcher);
	}

	/**
	 * Returns the {@link #sourceSectionMatcher}.
	 *
	 * @return the {@link #sourceSectionMatcher}
	 */
	public SourceSectionMatcher getSourceSectionMatcher() {

		if (this.sourceSectionMatcher == null) {
			this.initSourceSectionMatcher();
		}

		return this.sourceSectionMatcher;
	}

	/**
	 * This initializes the {@link #targetSectionInstantiator}.
	 */
	protected void initTargetSectionInstantiator() {

		this.targetSectionInstantiator = new TargetSectionInstantiator(this);
		this.objectsToCancel.add(this.targetSectionInstantiator);
	}

	/**
	 * Returns the {@link #targetSectionInstantiator}.
	 *
	 * @return the {@link #targetSectionInstantiator}
	 */
	public TargetSectionInstantiator getTargetSectionInstantiator() {

		if (this.targetSectionInstantiator == null) {
			this.initTargetSectionInstantiator();
		}

		return this.targetSectionInstantiator;
	}

	/**
	 * This initializes the {@link #targetSectionConnector}.
	 */
	protected void initTargetSectionConnector() {

		this.targetSectionConnector = new TargetSectionConnector(this);
		this.objectsToCancel.add(this.targetSectionConnector);
	}

	/**
	 * Returns the {@link #targetSectionConnector}.
	 *
	 * @return the {@link #targetSectionConnector}
	 */
	public TargetSectionConnector getTargetSectionConnector() {

		if (this.targetSectionConnector == null) {
			this.initTargetSectionConnector();
		}

		return this.targetSectionConnector;
	}

	/**
	 * This initializes the {@link #targetSectionLinker}.
	 */
	protected void initTargetSectionLinker() {

		this.targetSectionLinker = new TargetSectionLinker(this);
		this.objectsToCancel.add(this.targetSectionLinker);
	}

	/**
	 * Returns the {@link #targetSectionLinker}.
	 *
	 * @return the {@link #targetSectionLinker}
	 */
	public TargetSectionLinker getTargetSectionLinker() {

		if (this.targetSectionLinker == null) {
			this.initTargetSectionLinker();
		}

		return this.targetSectionLinker;
	}

	/**
	 * This initializes the {@link #genLibraryManager}.
	 */
	protected void initGenLibraryManager() {

		this.genLibraryManager = new GenLibraryManager(this.transformationConfig.getLibPaths(), this.getLogger());
	}

	/**
	 * Returns the {@link #targetSectionLinker}.
	 *
	 * @return the {@link #targetSectionLinker}
	 */
	public GenLibraryManager getGenLibraryManager() {

		if (this.genLibraryManager == null) {
			this.initGenLibraryManager();
		}

		return this.genLibraryManager;
	}

	/**
	 * This cancels any running asset managed by this.
	 */
	@Override
	public void cancel() {

		super.cancel();
		this.objectsToCancel.parallelStream().forEach(ICancelable::cancel);
	}
}
