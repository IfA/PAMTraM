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
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import pamtram.FixedValue;
import pamtram.TargetSectionModel;
import pamtram.condition.Condition;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.InstanceSelector;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.source.SourceSection;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;

/**
 * A control class that encapsulates the various handlers, registries and calculators that are used at multiple points
 * during a transformation and handles their instantiation.
 * <p />
 * Note: After the {@link #TransformationUtilManager(TransformationConfiguration) instantiation} of a manager,
 * {@link #init()} needs to be called at least once before any of the handles objects can be used.
 *
 * @author mfreund
 */
class TransformationUtilManager {

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
	 * This creates an instance.
	 *
	 * @param transformationConfig
	 *            The {@link TransformationConfiguration} that this operates on.
	 */
	public TransformationUtilManager(TransformationConfiguration transformationConfig) {

		this.transformationConfig = transformationConfig;
	}

	/**
	 * Initialize everything at the start of the transformation.
	 */
	public void init() {

		this.globalValues = new GlobalValueMap();
		this.matchedSectionRegistry = new MatchedSectionRegistry();
		this.targetSectionRegistry = new TargetSectionRegistry(this.transformationConfig.getLogger(),
				new LinkedHashSet<>(this.transformationConfig.getPamtramModels().stream()
						.flatMap(p -> p.getTargetSectionModels().stream()).map(TargetSectionModel::getMetaModelPackage)
						.collect(Collectors.toList())));

		this.initValueModifierExecutor();
		this.initValueCalculator();
		this.initInstanceSelectorHandler();
		this.initValueConstraintReferenceValueCalculator();
		this.initConditionHandler();
	}

	/**
	 * @return the {@link #globalValues}}
	 */
	public GlobalValueMap getGlobalValues() {

		return this.globalValues;
	}

	/**
	 * @return the {@link #matchedSectionRegistry}
	 */
	public MatchedSectionRegistry getMatchedSectionRegistry() {

		return this.matchedSectionRegistry;
	}

	/**
	 * @return the {@link #targetSectionRegistry}
	 */
	public TargetSectionRegistry getTargetSectionRegistry() {

		return this.targetSectionRegistry;
	}

	/**
	 * This initializes the {@link #valueModifierExecutor}.
	 *
	 */
	protected void initValueModifierExecutor() {

		this.valueModifierExecutor = ValueModifierExecutor.init(this.transformationConfig.getLogger());
	}

	/**
	 * Returns the {@link #valueModifierExecutor}.
	 * <p />
	 * <b>Note:</b> Before calling this, {@link #init()} has to be called at least once.
	 *
	 * @return the {@link #valueModifierExecutor}
	 */
	public ValueModifierExecutor getValueModifierExecutor() {

		return this.valueModifierExecutor;
	}

	/**
	 * This initializes the {@link #valueCalculator}.
	 */
	protected void initValueCalculator() {

		this.valueCalculator = new ValueCalculator(this.globalValues, this.valueModifierExecutor,
				this.transformationConfig.getLogger());
	}

	/**
	 * Returns the {@link #valueCalculator}.
	 * <p />
	 * <b>Note:</b> Before calling this, {@link #init()} has to be called at least once.
	 *
	 * @return the {@link #valueCalculator}
	 */
	public ValueCalculator getValueCalculator() {

		return this.valueCalculator;
	}

	/**
	 * This initializes the {@link #instanceSelectorHandler}.
	 * <p />
	 * Note: If not already done, also initializes the {@link #valueCalculator}.
	 *
	 * @param matchedSections
	 *            The map of {@link MatchedSectionDescriptor MatchedSectionDescriptors} that represents the result of
	 *            the matching process.
	 * @param targetSectionRegistry
	 *            The {@link TargetSectionRegistry} where instantiated {@link TargetSection TargetSections} are stored.
	 * @param globalValues
	 *            the {@link GlobalValueMap} to use
	 */
	protected void initInstanceSelectorHandler() {

		if (this.valueCalculator == null) {
			this.initValueCalculator();
		}

		this.instanceSelectorHandler = new InstanceSelectorHandler(this.matchedSectionRegistry,
				this.targetSectionRegistry, this.globalValues, this.valueCalculator,
				this.transformationConfig.getLogger(), this.transformationConfig.isUseParallelization());
	}

	/**
	 * Returns the {@link #instanceSelectorHandler}.
	 * <p />
	 * <b>Note:</b> Before calling this, {@link #init()} has to be called at least once.
	 *
	 * @return the {@link #instanceSelectorHandler}
	 */
	public InstanceSelectorHandler getInstanceSelectorHandler() {

		return this.instanceSelectorHandler;
	}

	/**
	 * This initializes the {@link #valueConstraintReferenceValueCalculator}.
	 * <p />
	 * Note: If not already done, also initializes the {@link #valueCalculator} and the
	 * {@link #instanceSelectorHandler}.
	 *
	 */
	protected void initValueConstraintReferenceValueCalculator() {

		if (this.valueCalculator == null) {
			this.initValueCalculator();
		}

		if (this.instanceSelectorHandler == null) {
			this.initInstanceSelectorHandler();
		}

		this.valueConstraintReferenceValueCalculator = new ValueConstraintReferenceValueCalculator(
				this.matchedSectionRegistry, this.globalValues, this.instanceSelectorHandler, this.valueCalculator,
				this.transformationConfig.getLogger(), this.transformationConfig.isUseParallelization());
	}

	/**
	 * Returns the {@link #valueConstraintReferenceValueCalculator}.
	 * <p />
	 * <b>Note:</b> Before calling this, {@link #init()} has to be called at least once.
	 *
	 * @return the {@link #valueConstraintReferenceValueCalculator}
	 */
	public ValueConstraintReferenceValueCalculator getValueConstraintReferenceValueCalculator() {

		return this.valueConstraintReferenceValueCalculator;
	}

	/**
	 * This initializes the {@link #conditionHandler}.
	 * <p />
	 * Note: If not already done, also initializes the {@link #instanceSelectorHandler} and
	 * {@link #valueConstraintReferenceValueCalculator}.
	 */
	protected void initConditionHandler() {

		if (this.instanceSelectorHandler == null) {
			this.initInstanceSelectorHandler();
		}

		if (this.valueConstraintReferenceValueCalculator == null) {
			this.initValueConstraintReferenceValueCalculator();
		}

		this.conditionHandler = new ConditionHandler(this.matchedSectionRegistry, this.instanceSelectorHandler,
				this.valueConstraintReferenceValueCalculator, this.transformationConfig.getLogger(),
				this.transformationConfig.isUseParallelization());
	}

	/**
	 * Returns the {@link #conditionHandler}.
	 * <p />
	 * <b>Note:</b> Before calling this, {@link #init()} has to be called at least once.
	 *
	 * @return the {@link #instanceSelectorHandler}
	 */
	public ConditionHandler getConditionHandler() {

		return this.conditionHandler;
	}

}
