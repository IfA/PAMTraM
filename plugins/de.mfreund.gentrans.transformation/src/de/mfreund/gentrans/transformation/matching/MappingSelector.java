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
package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import de.mfreund.gentrans.transformation.CancelTransformationException;
import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.condition.ConditionHandler;
import de.mfreund.gentrans.transformation.condition.ConditionHandler.CondResult;
import de.mfreund.gentrans.transformation.core.CancelableTransformationAsset;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
import de.mfreund.gentrans.transformation.registries.SelectedMappingRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvedAdapter;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;
import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.condition.ApplicationDependency;
import pamtram.condition.Condition;
import pamtram.mapping.Mapping;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.MappingHintSourceInterface;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.source.SourceSection;

/**
 * This class can be used to {@link #selectMappings(MatchedSectionRegistry, List) select suitable mappings} for a list
 * of {@link MatchedSectionDescriptor matched sections}.
 * <p />
 * Conditions will be evaluated and occurring ambiguities will be resolved during the process of
 * {@link #selectMappings(MatchedSectionRegistry, List)}.
 *
 * @author mfreund
 */
public class MappingSelector extends CancelableTransformationAsset {

	/**
	 * The subset of {@link #mappings} that is equipped with one or more {@link ApplicationDependency
	 * ApplicationDependencies}.
	 */
	private final List<Mapping> dependentMappings;

	/**
	 * This keeps track of the mappings that have been selected (the result of the {@link #selectMappings()} step.
	 */
	private SelectedMappingRegistry selectedMappings;

	/**
	 * The list of {@link SourceSection} for that no mapping could yet be selected because at least one of the available
	 * mappings is a {@link #dependentMappings dependentMapping}.
	 */
	private final List<SourceSection> deferredSections;

	/**
	 * If ambiguous {@link Mapping Mappings} should be resolved only once or on a per-element basis.
	 */
	private boolean onlyAskOnceOnAmbiguousMappings;

	/**
	 * This is the {@link IAmbiguityResolvingStrategy} that shall be used to resolve ambiguities that arise during the
	 * execution of the transformation.
	 */
	private IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

	/**
	 * Whether extended parallelization shall be used during the transformation that might lead to the fact that the
	 * transformation result (especially the order of lists) varies between executions.
	 */
	private boolean useParallelization;

	/**
	 * The {@link ConditionHandler} that is used to evaluate {@link Condition Conditions}.
	 */
	private ConditionHandler conditionHandler;

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public MappingSelector(TransformationAssetManager assetManager) {

		super(assetManager);

		this.dependentMappings = Collections.synchronizedList(new ArrayList<>());
		this.selectedMappings = assetManager.getSelectedMappingRegistry();
		this.deferredSections = Collections.synchronizedList(new ArrayList<>());
		this.onlyAskOnceOnAmbiguousMappings = assetManager.getTransformationConfig().isOnlyAskOnceOnAmbiguousMappings();
		this.ambiguityResolvingStrategy = assetManager.getTransformationConfig().getAmbiguityResolvingStrategy();
		this.useParallelization = assetManager.getTransformationConfig().isUseParallelization();
		this.conditionHandler = assetManager.getConditionHandler();
	}

	/**
	 * For each {@link MatchedSectionDescriptor} represented in the given <em>matchedSections</em>, this selects a
	 * suitable mapping (one of the <em>mappings</em> defined by the list given list of {@link PAMTraM PAMTraM models}).
	 * The result of the selection process is returned by means of a {@link SelectedMappingRegistry}. Additionally, all
	 * the selected mappings are also registered in the (global) {@link #selectedMappings}.
	 * <p />
	 * Note: {@link DeactivatableElement#isDeactivated() Deactivated} Mappings and Mappings in deactivated MappingModels
	 * are not considered in the matching process.
	 *
	 * @param matchedSections
	 *            A map representing the {@link MatchedSectionDescriptor MatchedSectionDescriptors} found for every
	 *            {@link SourceSection}.
	 * @param pamtramModels
	 *            The list of {@link PAMTraM PAMTraM models} providing the {@link Mapping Mappings} that shall be
	 *            considered.
	 * @return The {@link SelectedMappingRegistry} containing (only!) those Mapping instances registered during the
	 *         execution of this method.
	 */
	public SelectedMappingRegistry selectMappings(MatchedSectionRegistry matchedSections, List<PAMTraM> pamtramModels) {

		// The Mappings defined by the active MappingModels that will be used
		//
		Set<Mapping> activeMappings = pamtramModels.stream().flatMap(p -> p.getActiveMappings().stream())
				.collect(LinkedHashSet<Mapping>::new, LinkedHashSet::add, LinkedHashSet::addAll);

		return this.selectMappings(matchedSections, activeMappings);
	}

	/**
	 * For each {@link MatchedSectionDescriptor} represented in the given <em>matchedSections</em>, this selects a
	 * suitable mapping (one of the given <em>mappings</em>). The result of the selection process is returned by means
	 * of a {@link SelectedMappingRegistry}. Additionally, all the selected mappings are also registered in the (global)
	 * {@link #selectedMappings}.
	 * <p />
	 * Note: {@link DeactivatableElement#isDeactivated() Deactivated} Mappings are not considered in the matching
	 * process.
	 *
	 * @param matchedSections
	 *            The {@link MatchedSectionRegistry} representing the {@link MatchedSectionDescriptor
	 *            MatchedSectionDescriptors} found for every {@link SourceSection}.
	 * @param mappings
	 *            The set of {@link Mapping Mappings} that shall be considered.
	 * @return The {@link SelectedMappingRegistry} containing (only!) those Mapping instances registered during the
	 *         execution of this method.
	 */
	public SelectedMappingRegistry selectMappings(MatchedSectionRegistry matchedSections, Set<Mapping> mappings) {

		SelectedMappingRegistry localRegistry = new SelectedMappingRegistry();

		// The active Mappings that will be matched against the source models
		//
		List<Mapping> activeMappings = mappings.stream().filter(m -> !m.isAbstract() && !m.isDeactivated())
				.collect(Collectors.toList());

		activeMappings.stream().forEach(m -> localRegistry.put(m, new ArrayList<>()));
		activeMappings.stream().forEach(m -> this.selectedMappings.put(m, new ArrayList<>()));

		// First, we need to filter mapping models with conditions that evaluate
		// to 'false'
		//
		Set<MappingModel> mappingModels = new LinkedHashSet<>(
				(this.useParallelization ? activeMappings.parallelStream() : activeMappings.stream())
						.map(m -> (MappingModel) m.eContainer()).collect(Collectors.toList()));

		List<MappingModel> mappingModelsWithNegativeCondition = mappingModels.stream()
				.filter(m -> !this.checkCondition(m)).collect(Collectors.toList());
		activeMappings.removeAll(mappingModelsWithNegativeCondition.stream().flatMap(m -> m.getMappings().stream())
				.collect(Collectors.toList()));

		// We consider all Mappings as 'dependent' (on the application of other elements) if they contain any
		// 'ApplicationDependency'
		//
		this.dependentMappings
				.addAll((this.useParallelization ? activeMappings.parallelStream() : activeMappings.stream()).filter(
						m -> m.getAllConditions().parallelStream().flatMap(c -> c.getConditionPartsFlat().stream())
								.anyMatch(c -> c instanceof ApplicationDependency))
						.collect(Collectors.toList()));

		// Select a mapping for each matched section and each descriptor instance. In the first run, we 'defer' those
		// sections that are associated with a Mapping that contains a 'MappingDependency'.
		//
		List<MappingInstanceDescriptor> mappingInstances = (this.useParallelization
				? matchedSections.keySet().parallelStream()
				: matchedSections.keySet().stream())
						.map(k -> this.selectMapping(k, matchedSections.get(k), activeMappings, true))
						.flatMap(Collection::stream).collect(Collectors.toList());

		localRegistry.add(mappingInstances);
		this.selectedMappings.add(mappingInstances);

		// Now, do the same stuff for the 'deferred' sections as we are now able to evaluate the
		// 'ApplicationDependencies'.
		//
		List<MappingInstanceDescriptor> deferredInstances = (this.useParallelization
				? this.deferredSections.parallelStream()
				: this.deferredSections.stream())
						.map(s -> this.selectMapping(s, matchedSections.get(s), activeMappings, false))
						.flatMap(Collection::stream).collect(Collectors.toList());

		localRegistry.add(deferredInstances);
		this.selectedMappings.add(deferredInstances);

		return localRegistry;
	}

	/**
	 * For the given {@link SourceSection} and the list of associated {@link MatchedSectionDescriptor
	 * MatchedSectionDescriptor} select a mapping.
	 * <p />
	 * Note: The {@link #onlyAskOnceOnAmbiguousMappings} setting is taken into account during this step.
	 *
	 * @param matchedSection
	 *            The {@link SourceSection} for that a mapping shall be selected.
	 * @param descriptors
	 *            The list of {@link MatchedSectionDescriptor MatchedSectionDescriptors} that are associated with the
	 *            <em>matchedSection</em>.
	 * @param mappings
	 *            The list of {@link Mapping Mappings} that shall be considered.
	 * @param deferApplicationDependencies
	 *            This can be used to control whether those sections, for that at least one of the applicable mappings
	 *            has an {@link ApplicationDependency} shall be 'deferred'. Typically, this should be set to 'true'
	 *            during the first run (to collect the {@link #deferredSections} and to 'false' during the second run.
	 * @return A list of {@link MappingInstanceDescriptor MappingInstanceStorages} (one for each of the given
	 *         <em>descriptors</em>). Note: The {@link MappingInstanceDescriptor MappingInstanceStorages} do not yet
	 *         contain any calculated hint values.
	 */
	private List<MappingInstanceDescriptor> selectMapping(SourceSection matchedSection,
			List<MatchedSectionDescriptor> descriptors, List<Mapping> mappings, boolean deferApplicationDependencies) {

		this.checkCanceled();

		// This will be returned in the end
		//
		List<MappingInstanceDescriptor> ret = new ArrayList<>();

		// The mappings with suitable 'sourceMMSections'
		//
		List<Mapping> applicableMappings = (this.useParallelization ? mappings.parallelStream() : mappings.stream())
				.filter(m -> matchedSection.equals(m.getSourceSection())).collect(Collectors.toList());

		// Check if we need to 'defer' the selection of mappings for the given
		// set of 'descriptors' as at least one of
		// the possible mappings has an 'ApplicationDependency'
		if (deferApplicationDependencies
				&& applicableMappings.parallelStream().anyMatch(this.dependentMappings::contains)) {
			this.deferredSections.add(matchedSection);
			return ret;
		}

		// Filter mappings and descriptors by the applicability of conditions
		//
		Map<List<Mapping>, List<MatchedSectionDescriptor>> applicableMappingsToDescriptors = this
				.checkConditions(applicableMappings, descriptors);

		// Select mappings to be instantiated and create
		// 'MappingInstanceStorages'
		//
		for (Entry<List<Mapping>, List<MatchedSectionDescriptor>> entry : applicableMappingsToDescriptors.entrySet()) {

			switch (entry.getKey().size()) {
				case 0:
					// no applicable mapping was found
					break;
				case 1:
					// create a MappingInstanceStorage for each descriptor
					Mapping mapping = entry.getKey().iterator().next();
					ret.addAll((this.useParallelization ? entry.getValue().parallelStream() : entry.getValue().stream())
							.map(d -> this.createMappingInstanceStorage(d, mapping)).collect(Collectors.toList()));
					break;
				default:

					/*
					 * Consult the specified resolving strategy to resolve the ambiguity.
					 */
					try {
						if (this.onlyAskOnceOnAmbiguousMappings) {
							MatchedSectionDescriptor descriptor = entry.getValue().iterator().next();
							List<Mapping> resolved = this.selectMappingForDescriptor(descriptor, entry.getKey());

							// create a MappingInstanceStorage for each descriptor
							// and each selected mapping
							//
							Iterator<Mapping> it = resolved.iterator();
							while (it.hasNext()) {

								Mapping resolvedMapping = it.next();
								ret.addAll((this.useParallelization ? entry.getValue().parallelStream()
										: entry.getValue().stream())
												.map(d -> this.createMappingInstanceStorage(d, resolvedMapping))
												.collect(Collectors.toList()));
							}
						} else {

							for (MatchedSectionDescriptor descriptor : entry.getValue()) {
								List<Mapping> resolved = this.selectMappingForDescriptor(descriptor, entry.getKey());

								// create a MappingInstanceStorage for each
								// descriptor and each selected mapping
								//
								Iterator<Mapping> it = resolved.iterator();
								while (it.hasNext()) {

									Mapping resolvedMapping = it.next();
									ret.add(this.createMappingInstanceStorage(descriptor, resolvedMapping));
								}
							}
						}
					} catch (AmbiguityResolvingException e) {
						if (e.getCause() instanceof UserAbortException) {
							throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
						} else {
							this.logger.severe(
									() -> "The following exception occured during the resolving of an ambiguity concerning the selection of a mapping: "
											+ e.getMessage());
							this.logger.severe("Using default mapping instead...");
							mapping = entry.getKey().iterator().next();
							ret.addAll((this.useParallelization ? entry.getValue().parallelStream()
									: entry.getValue().stream()).map(d -> this.createMappingInstanceStorage(d, mapping))
											.collect(Collectors.toList()));
						}
					}

			}
		}

		// Check conditions of hint groups and hints for the selected
		// MappingInstanceStorages
		//
		ret.stream().forEach(this::determineElementsWithNegativeConditions);

		return ret;
	}

	/**
	 * This filters mappings and descriptors by the applicability of conditions.
	 * <p />
	 * As the applicability of a mapping may be dependent on the concrete {@link MatchedSectionDescriptor}, a list of
	 * <em>descriptors</em> needs to be passed as well. The result of this will be a map relating sets of applicable
	 * mappings to sets of descriptors.
	 *
	 * @param applicableMappings
	 *            The list of {@link Mapping Mappings} for that the conditions shall be checked.
	 * @param descriptors
	 *            The list of {@link MatchedSectionDescriptor MatchedSectionDescriptor} to be used during the check.
	 *
	 * @return A map relating lists of applicable mappings to lists of descriptors for that the applicable mappings are
	 *         valid.
	 */
	private Map<List<Mapping>, List<MatchedSectionDescriptor>> checkConditions(List<Mapping> applicableMappings,
			List<MatchedSectionDescriptor> descriptors) {

		// The map that will be returned in the end
		//
		Map<List<Mapping>, List<MatchedSectionDescriptor>> applicableMappingsToDescriptors = new LinkedHashMap<>();

		// Check conditions
		//
		for (MatchedSectionDescriptor descriptor : descriptors) {

			// The subset of the given 'applicableMappings' that is applicable
			// for the current 'descriptor'
			//
			List<Mapping> localApplicableMappings = (this.useParallelization ? applicableMappings.parallelStream()
					: applicableMappings.stream()).filter(m -> this.checkConditions(m, descriptor))
							.collect(Collectors.toList());

			// Check if there are already descriptors for that the same set of
			// mappings are applicable
			//
			Optional<Entry<List<Mapping>, List<MatchedSectionDescriptor>>> existing = applicableMappingsToDescriptors
					.entrySet().stream().filter(entry -> entry.getKey().size() == localApplicableMappings.size()
							&& entry.getKey().containsAll(localApplicableMappings))
					.findFirst();

			if (existing.isPresent()) {
				existing.get().getValue().add(descriptor);
			} else {
				applicableMappingsToDescriptors.put(localApplicableMappings,
						new ArrayList<>(Arrays.asList(descriptor)));
			}
		}

		return applicableMappingsToDescriptors;
	}

	/**
	 * This checks if a conditional {@link Mapping} is applicable for the given {@link MatchedSectionDescriptor}.
	 *
	 * @param mapping
	 *            The {@link Mapping} to be checked for applicability.
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} for that the applicability shall be checked.
	 * @return '<em><b>true</b></em>' if the mapping is applicable; '<em><b>false</b></em>' otherwise.
	 */
	private boolean checkConditions(Mapping mapping, MatchedSectionDescriptor descriptor) {

		// check Conditions of the Mapping (Note: no condition modeled = true)
		//
		return mapping.getAllConditions().stream()
				.allMatch(c -> this.conditionHandler.checkCondition(c, descriptor) == CondResult.TRUE);

	}

	/**
	 * This evaluates the conditions of the {@link ConditionalElement ConditionalElements} contained in the mapping
	 * represented by the given {@link MappingInstanceDescriptor}. Elements with conditions that have been evaluated as
	 * <em>negative</em> are {@link MappingInstanceDescriptor#addElementWithNegativeCondition(ConditionalElement)
	 * stored} in the <em>mappingInstance</em>.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceDescriptor} representing the ConditionalElements to be checked.
	 */
	private void determineElementsWithNegativeConditions(MappingInstanceDescriptor mappingInstance) {

		// check conditions of all corresponding MappingHintGroups
		//
		mappingInstance.getMapping().getActiveMappingHintGroups().stream()
				.filter(hg -> hg instanceof ConditionalElement).forEach(hg -> {

					boolean hintGroupResult = this.checkCondition((ConditionalElement) hg, mappingInstance);

					if (hintGroupResult) {

						// Now, iterate over all corresponding MappingHints
						//
						hg.getActiveMappingHints().stream().forEach(h -> {
							boolean hintResult = this.checkCondition(h, mappingInstance);

							if (hintResult) {

								// Now, iterate over all corresponding
								// MappingHintSourceElements
								//
								List<MappingHintSourceInterface> sourceElements = new ArrayList<>();
								if (h instanceof AttributeMapping) {
									sourceElements.addAll(((AttributeMapping) h).getSourceElements());
								} else if (h instanceof CardinalityMapping) {
									sourceElements.addAll(((CardinalityMapping) h).getSourceElements());
								} else if (h instanceof ContainerSelector) {
									sourceElements.addAll(((ContainerSelector) h).getSourceElements());
								} else if (h instanceof ReferenceTargetSelector) {
									sourceElements.addAll(((ReferenceTargetSelector) h).getSourceElements());
								} else {
									this.logger.warning(
											() -> "Internal Error: Unsupported type of MappingHint encountered ('"
													+ h.getName() + "')!");
								}

								sourceElements.stream().forEach(s -> this.checkCondition(s, mappingInstance));
							}
						});
					}
				});

		// check Condition of corresponding IMPORTED MappingHintGroups
		//
		mappingInstance.getMapping().getActiveImportedMappingHintGroups().stream()
				.forEach(hg -> this.checkCondition(hg, mappingInstance));

	}

	/**
	 * Checks the condition of the given {@link ConditionalElement}. If the condition evaluates to
	 * {@link CondResult#FALSE}, the element is
	 * {@link MappingInstanceDescriptor#addElementWithNegativeCondition(ConditionalElement) marked as negative} in the
	 * given {@link MappingInstanceDescriptor}.
	 *
	 * @param conditionalElement
	 *            The {@link ConditionalElement} to check.
	 * @param mappingInstance
	 *            The {@link MappingInstanceDescriptor} associated with the given <em>conditionalElement</em>.
	 * @return '<em><b>true</b></em>' if the condition was evaluated to {@link CondResult#TRUE}; '<em><b>false</b></em>'
	 *         otherwise.
	 */
	private boolean checkCondition(ConditionalElement conditionalElement, MappingInstanceDescriptor mappingInstance) {

		boolean result = this.checkCondition(conditionalElement, mappingInstance.getMatchedSectionDescriptor());

		if (!result) {

			mappingInstance.addElementWithNegativeCondition(conditionalElement);
		}

		return result;
	}

	/**
	 * Checks the condition of the given {@link ConditionalElement}.
	 *
	 * @param conditionalElement
	 *            The {@link ConditionalElement} to check.
	 * @return '<em><b>true</b></em>' if the condition was evaluated to {@link CondResult#TRUE}; '<em><b>false</b></em>'
	 *         otherwise.
	 */
	private boolean checkCondition(ConditionalElement conditionalElement, MatchedSectionDescriptor descriptor) {

		// check Conditions of the ConditionalElement (Note: no condition modeled = true)
		//
		return conditionalElement.getAllConditions().stream()
				.allMatch(c -> this.conditionHandler.checkCondition(c, descriptor) == CondResult.TRUE);

	}

	/**
	 * Checks the condition of the given {@link MappingModel}.
	 *
	 * @param mappingModel
	 *            The {@link MappingModel} to check.
	 * @return '<em><b>true</b></em>' if the condition was evaluated to {@link CondResult#TRUE}; '<em><b>false</b></em>'
	 *         otherwise.
	 */
	private boolean checkCondition(MappingModel mappingModel) {

		// check Conditions of the MappingModel (Note: no condition modeled = true)
		//
		return mappingModel.getAllConditions().stream()
				.allMatch(c -> this.conditionHandler.checkCondition(c, null) == CondResult.TRUE);

	}

	/**
	 * Determine one or multiple mappings to be applied for the given {@link MatchedSectionDescriptor} based on the
	 * specified {@link #ambiguityResolvingStrategy}.
	 *
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} for that the mappings to be applied are determined.
	 * @param applicableMappings
	 *            The list of applicable {@link Mapping Mappings} that shall be taken into account.
	 * @return The determined mappings to apply.
	 * @throws AmbiguityResolvingException
	 *             If an error occurred while applying the resolving strategy.
	 */
	private List<Mapping> selectMappingForDescriptor(MatchedSectionDescriptor descriptor,
			List<Mapping> applicableMappings) throws AmbiguityResolvingException {

		this.logger.fine("[Ambiguity] Resolve searching ambiguity...");
		List<Mapping> resolved = this.ambiguityResolvingStrategy.searchingSelectMapping(
				new ArrayList<>(applicableMappings), descriptor.getAssociatedSourceModelElement());
		if (this.ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
			((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy)
					.searchingMappingSelected(new ArrayList<>(applicableMappings), resolved);
		}
		this.logger.fine("[Ambiguity] ...finished.\n");
		return resolved;
	}

	/**
	 * This creates a {@link MappingInstanceDescriptor} for the given {@link MatchedSectionDescriptor descriptor}.
	 *
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} for that the {@link MappingInstanceDescriptor} shall be created.
	 * @param mapping
	 *            The {@link Mapping} that the MappingInstanceStorage shall represent.
	 * @return The created {@link MappingInstanceDescriptor}.
	 */
	private MappingInstanceDescriptor createMappingInstanceStorage(MatchedSectionDescriptor descriptor,
			Mapping mapping) {

		MappingInstanceDescriptor ret = new MappingInstanceDescriptor(descriptor, this.useParallelization);
		ret.setMapping(mapping);
		return ret;
	}
}
