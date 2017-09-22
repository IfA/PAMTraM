/**
 *
 */
package de.mfreund.gentrans.transformation;

import java.util.List;
import java.util.Map;

import de.mfreund.gentrans.transformation.calculation.InstanceSelectorHandler;
import de.mfreund.gentrans.transformation.calculation.ValueCalculator;
import de.mfreund.gentrans.transformation.calculation.ValueConstraintReferenceValueCalculator;
import de.mfreund.gentrans.transformation.calculation.ValueModifierExecutor;
import de.mfreund.gentrans.transformation.condition.ConditionHandler;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import pamtram.condition.Condition;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.InstanceSelector;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.source.SourceSection;
import pamtram.structure.target.TargetSectionAttribute;

/**
 * A control class that encapsulates the various handlers and calculators that are used at multiple points during a
 * transformation and handles their instantiation.
 * <p />
 * Note: After the {@link #TransformationUtilManager(TransformationConfiguration) instantiation} of a manager,
 * {@link #init(Map, GlobalValueMap)} needs to be called at least once before any of the handles objects can be used.
 *
 * @author mfreund
 */
class TransformationUtilManager {

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
	 *
	 * @param matchedSections
	 *            The map of {@link MatchedSectionDescriptor MatchedSectionDescriptors} that will be filled during the
	 *            matching phase.
	 * @param globalValues
	 *            The {@link GlobalValueMap} that will be filled during the matching phase.
	 */
	public void init(Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections, GlobalValueMap globalValues) {

		this.initValueModifierExecutor();
		this.initValueCalculator(globalValues);
		this.initInstanceSelectorHandler(matchedSections, globalValues);
		this.initValueConstraintReferenceValueCalculator(matchedSections, globalValues);
		this.initConditionHandler(matchedSections, globalValues);
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
	 * <b>Note:</b> Before calling this, {@link #init(Map, GlobalValueMap)} has to be called at least once.
	 *
	 * @return the {@link #valueModifierExecutor}
	 */
	public ValueModifierExecutor getValueModifierExecutor() {

		return this.valueModifierExecutor;
	}

	/**
	 * This initializes the {@link #valueCalculator}.
	 *
	 * @param globalValues
	 *            the {@link GlobalValueMap} to use
	 */
	protected void initValueCalculator(GlobalValueMap globalValues) {

		this.valueCalculator = new ValueCalculator(globalValues, this.valueModifierExecutor,
				this.transformationConfig.getLogger());
	}

	/**
	 * Returns the {@link #valueCalculator}.
	 * <p />
	 * <b>Note:</b> Before calling this, {@link #init(Map, GlobalValueMap)} has to be called at least once.
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
	 * @param globalValues
	 *            the {@link GlobalValueMap} to use
	 */
	protected void initInstanceSelectorHandler(Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections,
			GlobalValueMap globalValues) {

		if (this.valueCalculator == null) {
			this.initValueCalculator(globalValues);
		}

		this.instanceSelectorHandler = new InstanceSelectorHandler(matchedSections, globalValues, this.valueCalculator,
				this.transformationConfig.getLogger(), this.transformationConfig.isUseParallelization());
	}

	/**
	 * Returns the {@link #instanceSelectorHandler}.
	 * <p />
	 * <b>Note:</b> Before calling this, {@link #init(Map, GlobalValueMap)} has to be called at least once.
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
	 * @param matchedSections
	 *            The map of {@link MatchedSectionDescriptor MatchedSectionDescriptors} that represents the result of
	 *            the matching process.
	 * @param globalValues
	 *            the {@link GlobalValueMap} to use
	 */
	protected void initValueConstraintReferenceValueCalculator(
			Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections, GlobalValueMap globalValues) {

		if (this.valueCalculator == null) {
			this.initValueCalculator(globalValues);
		}

		if (this.instanceSelectorHandler == null) {
			this.initInstanceSelectorHandler(matchedSections, globalValues);
		}

		this.valueConstraintReferenceValueCalculator = new ValueConstraintReferenceValueCalculator(matchedSections,
				globalValues, this.instanceSelectorHandler, this.valueCalculator, this.transformationConfig.getLogger(),
				this.transformationConfig.isUseParallelization());
	}

	/**
	 * Returns the {@link #valueConstraintReferenceValueCalculator}.
	 * <p />
	 * <b>Note:</b> Before calling this, {@link #init(Map, GlobalValueMap)} has to be called at least once.
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
	 *
	 * @param matchedSections
	 *            The map of {@link MatchedSectionDescriptor MatchedSectionDescriptors} that represents the result of
	 *            the matching process.
	 * @param globalValues
	 *            the {@link GlobalValueMap} to use
	 */
	protected void initConditionHandler(Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections,
			GlobalValueMap globalValues) {

		if (this.instanceSelectorHandler == null) {
			this.initInstanceSelectorHandler(matchedSections, globalValues);
		}

		if (this.valueConstraintReferenceValueCalculator == null) {
			this.initValueConstraintReferenceValueCalculator(matchedSections, globalValues);
		}

		this.conditionHandler = new ConditionHandler(matchedSections, this.instanceSelectorHandler,
				this.valueConstraintReferenceValueCalculator, this.transformationConfig.getLogger(),
				this.transformationConfig.isUseParallelization());
	}

	/**
	 * Returns the {@link #conditionHandler}.
	 * <p />
	 * <b>Note:</b> Before calling this, {@link #init(Map, GlobalValueMap)} has to be called at least once.
	 *
	 * @return the {@link #instanceSelectorHandler}
	 */
	public ConditionHandler getConditionHandler() {

		return this.conditionHandler;
	}

}
