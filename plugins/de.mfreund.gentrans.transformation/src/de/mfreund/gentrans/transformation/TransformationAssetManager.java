/**
 *
 */
package de.mfreund.gentrans.transformation;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import de.mfreund.gentrans.transformation.calculation.InstanceSelectorHandler;
import de.mfreund.gentrans.transformation.calculation.ValueCalculator;
import de.mfreund.gentrans.transformation.calculation.ValueConstraintReferenceValueCalculator;
import de.mfreund.gentrans.transformation.calculation.ValueModifierExecutor;
import de.mfreund.gentrans.transformation.condition.ConditionHandler;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.matching.GlobalAttributeValueExtractor;
import de.mfreund.gentrans.transformation.matching.HintValueExtractor;
import de.mfreund.gentrans.transformation.matching.MappingSelector;
import de.mfreund.gentrans.transformation.matching.SourceSectionMatcher;
import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import pamtram.FixedValue;
import pamtram.TargetSectionModel;
import pamtram.condition.Condition;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.InstanceSelector;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.source.SourceSection;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;

/**
 * A control class that encapsulates the various assets (handlers, registries and calculators) that are used at multiple
 * points during a transformation and handles their instantiation.
 * <p />
 * Note: The various getters all handle the prior instantiation of the respective asset automatically.
 *
 * @author mfreund
 */
class TransformationAssetManager {

	/**
	 * The {@link GlobalValueMap} where extracted global {@link FixedValue FixedValues} and values of
	 * {@link GlobalAttribute GlobalAttributes} are stored.
	 */
	private GlobalValueMap globalValues;

	/**
	 * The {@link MatchedSectionRegistry} where the various source model snippets that are matched against
	 * {@link SourceSection SourceSections} during a transformation are stored.
	 */
	private MatchedSectionRegistry matchedSectionRegistry;

	/**
	 * The {@link TargetSectionRegistry} where instantiated {@link TargetSection TargetSections} are stored.
	 */
	private TargetSectionRegistry targetSectionRegistry;

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
	 * This creates an instance.
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} that this operates on.
	 */
	public TransformationAssetManager(TransformationConfiguration transformationConfig) {

		this.transformationConfig = transformationConfig;
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
	 * This initializes the {@link #matchedSectionRegistry}.
	 */
	protected void initMatchedSectionRegistry() {

		this.matchedSectionRegistry = new MatchedSectionRegistry();
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
	 * This initializes the {@link #targetSectionRegistry}.
	 */
	protected void initTargetSectionRegistry() {

		this.targetSectionRegistry = new TargetSectionRegistry(this.transformationConfig.getLogger(),
				new LinkedHashSet<>(this.transformationConfig.getPamtramModels().stream()
						.flatMap(p -> p.getTargetSectionModels().stream()).map(TargetSectionModel::getMetaModelPackage)
						.collect(Collectors.toList())));
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
	 * This initializes the {@link #valueModifierExecutor}.
	 */
	protected void initValueModifierExecutor() {

		this.valueModifierExecutor = ValueModifierExecutor.init(this.transformationConfig.getLogger());
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

		this.valueCalculator = new ValueCalculator(this.getGlobalValues(), this.getValueModifierExecutor(),
				this.transformationConfig.getLogger());
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

		this.instanceSelectorHandler = new InstanceSelectorHandler(this.getMatchedSectionRegistry(),
				this.getTargetSectionRegistry(), this.getGlobalValues(), this.getValueCalculator(),
				this.transformationConfig.getLogger(), this.transformationConfig.isUseParallelization());
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

		this.valueConstraintReferenceValueCalculator = new ValueConstraintReferenceValueCalculator(
				this.getMatchedSectionRegistry(), this.getGlobalValues(), this.getInstanceSelectorHandler(),
				this.getValueCalculator(), this.transformationConfig.getLogger(),
				this.transformationConfig.isUseParallelization());
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

		this.conditionHandler = new ConditionHandler(this.matchedSectionRegistry, this.getInstanceSelectorHandler(),
				this.getValueConstraintReferenceValueCalculator(), this.transformationConfig.getLogger(),
				this.transformationConfig.isUseParallelization());
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

		this.mappingSelector = new MappingSelector(this.transformationConfig.isOnlyAskOnceOnAmbiguousMappings(),
				this.transformationConfig.getAmbiguityResolvingStrategy(), this.getConditionHandler(),
				this.transformationConfig.getLogger(), this.transformationConfig.isUseParallelization());
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

		this.hintValueExtractor = new HintValueExtractor(this.getMatchedSectionRegistry(), this.getGlobalValues(),
				this.getInstanceSelectorHandler(), this.getValueModifierExecutor(),
				this.transformationConfig.getLogger(), this.transformationConfig.isUseParallelization());
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

		this.globalAttributeValueExtractor = new GlobalAttributeValueExtractor(this.getGlobalValues(),
				this.getInstanceSelectorHandler(), this.getValueModifierExecutor(),
				this.transformationConfig.getLogger(), this.transformationConfig.isUseParallelization());
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

		this.sourceSectionMatcher = new SourceSectionMatcher(this.getMatchedSectionRegistry(),
				this.getValueConstraintReferenceValueCalculator(),
				this.transformationConfig.getAmbiguityResolvingStrategy(), this.transformationConfig.getLogger(),
				this.transformationConfig.isUseParallelization());
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

}
