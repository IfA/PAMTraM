/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.core;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import de.mfreund.gentrans.transformation.TransformationConfiguration;
import de.mfreund.gentrans.transformation.calculation.InstanceSelectorHandler;
import de.mfreund.gentrans.transformation.calculation.MatchSpecHandler;
import de.mfreund.gentrans.transformation.calculation.ValueCalculator;
import de.mfreund.gentrans.transformation.calculation.ValueConstraintReferenceValueCalculator;
import de.mfreund.gentrans.transformation.calculation.ValueModifierExecutor;
import de.mfreund.gentrans.transformation.condition.ConditionHandler;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.mfreund.gentrans.transformation.expanding.TargetSectionJoiner;
import de.mfreund.gentrans.transformation.expanding.TargetSectionConnector;
import de.mfreund.gentrans.transformation.expanding.TargetSectionInstantiator;
import de.mfreund.gentrans.transformation.expanding.TargetSectionLinker;
import de.mfreund.gentrans.transformation.maps.ElementIDMap;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.matching.GlobalAttributeValueExtractor;
import de.mfreund.gentrans.transformation.matching.HintValueExtractor;
import de.mfreund.gentrans.transformation.matching.MappingSelector;
import de.mfreund.gentrans.transformation.matching.ModelAccessUtil;
import de.mfreund.gentrans.transformation.matching.SourceSectionMatcher;
import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
import de.mfreund.gentrans.transformation.registries.SelectedMappingRegistry;
import de.mfreund.gentrans.transformation.registries.TargetModelRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.util.CancelableElement;
import de.mfreund.gentrans.transformation.util.ICancelable;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathProvider;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPlugin;
import pamtram.FixedValue;
import pamtram.MatchSpecElement;
import pamtram.TargetSectionModel;
import pamtram.condition.Condition;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.InstanceSelector;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
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
	 * The {@link ModelAccessUtil} used to evaluate {@link Reference References} and {@link Attribute Attributes}.
	 */
	private ModelAccessUtil modelAccessUtil;

	/**
	 * The {@link MatchSpecHandler} used to evaluate {@link MatchSpecElement#getReferenceMatchSpec()
	 * <em>referenceMatchSpecs</em>} of {@link MatchSpecElement MatchSpecElements}.
	 */
	private MatchSpecHandler matchSpecHandler;

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
	 * The {@link TargetSectionJoiner} that is used to perform the <em>joining</em> phase of the transformation.
	 */
	private TargetSectionConnector targetSectionJoiner;

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
	 * The {@link EClassConnectionPathProvider} used to determine connection paths between classes/instances in the
	 * expanding phase of the transformation.
	 */
	private EClassConnectionPathProvider eClassConnectionPathProvider;

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
		objectsToCancel = new ArrayList<>();
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
		objectsToCancel = new ArrayList<>();
	}

	/**
	 * Returns the {@link #transformationConfig}.
	 *
	 * @return the {@link #transformationConfig}}
	 */
	public TransformationConfiguration getTransformationConfig() {

		return transformationConfig;
	}

	/**
	 * This initializes the {@link #logger}.
	 */
	protected void initLogger() {

		logger = Logger
				.getLogger("de.mfreund.gentrans.transformation " + DateFormat.getDateTimeInstance().format(new Date()));
		logger.setLevel(transformationConfig.getLogLevel());

	}

	/**
	 * Returns the {@link #logger}.
	 *
	 * @return the {@link #logger}}
	 */
	public Logger getLogger() {

		if (logger == null) {
			initLogger();
		}

		return logger;
	}

	/**
	 * This initializes the {@link #globalValues}.
	 */
	protected void initGlobalValues() {

		globalValues = new GlobalValueMap();
	}

	/**
	 * Returns the {@link #globalValues}.
	 *
	 * @return the {@link #globalValues}}
	 */
	public GlobalValueMap getGlobalValues() {

		if (globalValues == null) {
			initGlobalValues();
		}

		return globalValues;
	}

	/**
	 * This initializes the {@link #elementIDs}.
	 */
	protected void initElementIDs() {

		elementIDs = new ElementIDMap();
	}

	/**
	 * Returns the {@link #elementIDs}.
	 *
	 * @return the {@link #elementIDs}
	 */
	public ElementIDMap getElementIDs() {

		if (elementIDs == null) {
			initElementIDs();
		}

		return elementIDs;
	}

	/**
	 * This initializes the {@link #modelAccessUtil}.
	 */
	protected void initModelAccessUtil() {

		modelAccessUtil = new ModelAccessUtil(this);
	}

	/**
	 * Returns the {@link #modelAccessUtil}.
	 *
	 * @return the {@link #modelAccessUtil}
	 */
	public ModelAccessUtil getModelAccessUtil() {

		if (modelAccessUtil == null) {
			initModelAccessUtil();
		}

		return modelAccessUtil;
	}

	/**
	 * This initializes the {@link #matchSpecHandler}.
	 */
	protected void initMatchSpecHandler() {

		matchSpecHandler = new MatchSpecHandler(this);
	}

	/**
	 * Returns the {@link #matchSpecHandler}.
	 *
	 * @return the {@link #matchSpecHandler}
	 */
	public MatchSpecHandler getMatchSpecHandler() {

		if (matchSpecHandler == null) {
			initMatchSpecHandler();
		}

		return matchSpecHandler;
	}

	/**
	 * This initializes the {@link #matchedSectionRegistry}.
	 */
	protected void initMatchedSectionRegistry() {

		matchedSectionRegistry = new MatchedSectionRegistry(this);
	}

	/**
	 * Returns the {@link #matchedSectionRegistry}.
	 *
	 * @return the {@link #matchedSectionRegistry}
	 */
	public MatchedSectionRegistry getMatchedSectionRegistry() {

		if (matchedSectionRegistry == null) {
			initMatchedSectionRegistry();
		}

		return matchedSectionRegistry;
	}

	/**
	 * This initializes the {@link #selectedMappingRegistry}.
	 */
	protected void initSelectedMappingRegistry() {

		selectedMappingRegistry = new SelectedMappingRegistry();
	}

	/**
	 * Returns the {@link #selectedMappingRegistry}.
	 *
	 * @return the {@link #selectedMappingRegistry}
	 */
	public SelectedMappingRegistry getSelectedMappingRegistry() {

		if (selectedMappingRegistry == null) {
			initSelectedMappingRegistry();
		}

		return selectedMappingRegistry;
	}

	/**
	 * This initializes the {@link #targetSectionRegistry}.
	 */
	protected void initTargetSectionRegistry() {

		targetSectionRegistry = new TargetSectionRegistry(this);

		objectsToCancel.add(targetSectionRegistry);
	}

	/**
	 * Returns the {@link #targetSectionRegistry}.
	 *
	 * @return the {@link #targetSectionRegistry}
	 */
	public TargetSectionRegistry getTargetSectionRegistry() {

		if (targetSectionRegistry == null) {
			initTargetSectionRegistry();
		}

		return targetSectionRegistry;
	}

	/**
	 * This initializes the {@link #targetModelRegistry}.
	 */
	protected void initTargetModelRegistry() {

		targetModelRegistry = new TargetModelRegistry(this, Optional.empty());
	}

	/**
	 * Returns the {@link #targetModelRegistry}.
	 *
	 * @return the {@link #targetModelRegistry}
	 */
	public TargetModelRegistry getTargetModelRegistry() {

		if (targetModelRegistry == null) {
			initTargetModelRegistry();
		}

		return targetModelRegistry;
	}

	/**
	 * This initializes the {@link #valueModifierExecutor}.
	 */
	protected void initValueModifierExecutor() {

		valueModifierExecutor = new ValueModifierExecutor(this);
	}

	/**
	 * Returns the {@link #valueModifierExecutor}.
	 *
	 * @return the {@link #valueModifierExecutor}
	 */
	public ValueModifierExecutor getValueModifierExecutor() {

		if (valueModifierExecutor == null) {
			initValueModifierExecutor();
		}

		return valueModifierExecutor;
	}

	/**
	 * This initializes the {@link #valueCalculator}.
	 */
	protected void initValueCalculator() {

		valueCalculator = new ValueCalculator(this);
	}

	/**
	 * Returns the {@link #valueCalculator}.
	 *
	 * @return the {@link #valueCalculator}
	 */
	public ValueCalculator getValueCalculator() {

		if (valueCalculator == null) {
			initValueCalculator();
		}

		return valueCalculator;
	}

	/**
	 * This initializes the {@link #instanceSelectorHandler}.
	 */
	protected void initInstanceSelectorHandler() {

		instanceSelectorHandler = new InstanceSelectorHandler(this);
	}

	/**
	 * Returns the {@link #instanceSelectorHandler}.
	 *
	 * @return the {@link #instanceSelectorHandler}
	 */
	public InstanceSelectorHandler getInstanceSelectorHandler() {

		if (instanceSelectorHandler == null) {
			initInstanceSelectorHandler();
		}

		return instanceSelectorHandler;
	}

	/**
	 * This initializes the {@link #valueConstraintReferenceValueCalculator}.
	 */
	protected void initValueConstraintReferenceValueCalculator() {

		valueConstraintReferenceValueCalculator = new ValueConstraintReferenceValueCalculator(this);
	}

	/**
	 * Returns the {@link #valueConstraintReferenceValueCalculator}.
	 *
	 * @return the {@link #valueConstraintReferenceValueCalculator}
	 */
	public ValueConstraintReferenceValueCalculator getValueConstraintReferenceValueCalculator() {

		if (valueConstraintReferenceValueCalculator == null) {
			initValueConstraintReferenceValueCalculator();
		}

		return valueConstraintReferenceValueCalculator;
	}

	/**
	 * This initializes the {@link #conditionHandler}.
	 */
	protected void initConditionHandler() {

		conditionHandler = new ConditionHandler(this);
	}

	/**
	 * Returns the {@link #conditionHandler}.
	 *
	 * @return the {@link #instanceSelectorHandler}
	 */
	public ConditionHandler getConditionHandler() {

		if (conditionHandler == null) {
			initConditionHandler();
		}

		return conditionHandler;
	}

	/**
	 * This initializes the {@link #mappingSelector}.
	 */
	protected void initMappingSelector() {

		mappingSelector = new MappingSelector(this);
		objectsToCancel.add(mappingSelector);
	}

	/**
	 * Returns the {@link #mappingSelector}.
	 *
	 * @return the {@link #mappingSelector}
	 */
	public MappingSelector getMappingSelector() {

		if (mappingSelector == null) {
			initMappingSelector();
		}

		return mappingSelector;
	}

	/**
	 * This initializes the {@link #hintValueExtractor}.
	 */
	protected void initHintValueExtractor() {

		hintValueExtractor = new HintValueExtractor(this);
		objectsToCancel.add(hintValueExtractor);
	}

	/**
	 * Returns the {@link #hintValueExtractor}.
	 *
	 * @return the {@link #hintValueExtractor}
	 */
	public HintValueExtractor getHintValueExtractor() {

		if (hintValueExtractor == null) {
			initHintValueExtractor();
		}

		return hintValueExtractor;
	}

	/**
	 * This initializes the {@link #globalAttributeValueExtractor}.
	 */
	protected void initGlobalAttributeValueExtractor() {

		globalAttributeValueExtractor = new GlobalAttributeValueExtractor(this);
		objectsToCancel.add(globalAttributeValueExtractor);
	}

	/**
	 * Returns the {@link #globalAttributeValueExtractor}.
	 *
	 * @return the {@link #globalAttributeValueExtractor}
	 */
	public GlobalAttributeValueExtractor getGlobalAttributeValueExtractor() {

		if (globalAttributeValueExtractor == null) {
			initGlobalAttributeValueExtractor();
		}

		return globalAttributeValueExtractor;
	}

	/**
	 * This initializes the {@link #sourceSectionMatcher}.
	 */
	protected void initSourceSectionMatcher() {

		sourceSectionMatcher = new SourceSectionMatcher(this);
		objectsToCancel.add(sourceSectionMatcher);
	}

	/**
	 * Returns the {@link #sourceSectionMatcher}.
	 *
	 * @return the {@link #sourceSectionMatcher}
	 */
	public SourceSectionMatcher getSourceSectionMatcher() {

		if (sourceSectionMatcher == null) {
			initSourceSectionMatcher();
		}

		return sourceSectionMatcher;
	}

	/**
	 * This initializes the {@link #targetSectionInstantiator}.
	 */
	protected void initTargetSectionInstantiator() {

		targetSectionInstantiator = new TargetSectionInstantiator(this);
		objectsToCancel.add(targetSectionInstantiator);
	}

	/**
	 * Returns the {@link #targetSectionInstantiator}.
	 *
	 * @return the {@link #targetSectionInstantiator}
	 */
	public TargetSectionInstantiator getTargetSectionInstantiator() {

		if (targetSectionInstantiator == null) {
			initTargetSectionInstantiator();
		}

		return targetSectionInstantiator;
	}

	/**
	 * This initializes the {@link #targetSectionJoiner}.
	 */
	protected void initTargetSectionJoiner() {

		targetSectionJoiner = new TargetSectionJoiner(this);
		objectsToCancel.add(targetSectionJoiner);
	}

	/**
	 * Returns the {@link #targetSectionJoiner}.
	 *
	 * @return the {@link #targetSectionJoiner}
	 */
	public TargetSectionConnector getTargetSectionJoiner() {

		if (targetSectionJoiner == null) {
			initTargetSectionJoiner();
		}

		return targetSectionJoiner;
	}

	/**
	 * This initializes the {@link #targetSectionLinker}.
	 */
	protected void initTargetSectionLinker() {

		targetSectionLinker = new TargetSectionLinker(this);
		objectsToCancel.add(targetSectionLinker);
	}

	/**
	 * Returns the {@link #targetSectionLinker}.
	 *
	 * @return the {@link #targetSectionLinker}
	 */
	public TargetSectionLinker getTargetSectionLinker() {

		if (targetSectionLinker == null) {
			initTargetSectionLinker();
		}

		return targetSectionLinker;
	}

	/**
	 * This initializes the {@link #genLibraryManager}.
	 */
	protected void initGenLibraryManager() {

		genLibraryManager = new GenLibraryManager(transformationConfig.getLibPaths(), getLogger());
	}

	/**
	 * Returns the {@link #targetSectionLinker}.
	 *
	 * @return the {@link #targetSectionLinker}
	 */
	public GenLibraryManager getGenLibraryManager() {

		if (genLibraryManager == null) {
			initGenLibraryManager();
		}

		return genLibraryManager;
	}

	/**
	 * This initializes the {@link #eClassConnectionPathProvider}.
	 */
	protected void initEClassConnectionPathProvider() {

		Set<EPackage> targetMetaModels = new LinkedHashSet<>(
				getTransformationConfig().getPamtramModels().stream().flatMap(p -> p.getTargetSectionModels().stream())
						.map(TargetSectionModel::getMetaModelPackage).collect(Collectors.toList()));
		eClassConnectionPathProvider = EClassConnectionPathProvider.getInstance(targetMetaModels, logger);
	}

	/**
	 * Returns the {@link #eClassConnectionPathProvider}.
	 *
	 * @return the {@link #eClassConnectionPathProvider}
	 */
	public EClassConnectionPathProvider getEClassConnectionPathProvider() {

		if (eClassConnectionPathProvider == null) {
			initEClassConnectionPathProvider();
		}

		return eClassConnectionPathProvider;
	}

	/**
	 * This cancels any running asset managed by this.
	 */
	@Override
	public void cancel() {

		super.cancel();
		objectsToCancel.parallelStream().forEach(ICancelable::cancel);
	}
}
