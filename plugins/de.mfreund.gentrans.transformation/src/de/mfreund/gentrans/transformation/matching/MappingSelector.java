package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.mfreund.gentrans.transformation.calculation.AttributeValueCalculator;
import de.mfreund.gentrans.transformation.condition.ConditionHandler;
import de.mfreund.gentrans.transformation.condition.ConditionHandler.CondResult;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvedAdapter;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.mfreund.gentrans.transformation.util.CancelableElement;
import pamtram.ConditionalElement;
import pamtram.MappingModel;
import pamtram.condition.ApplicationDependency;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.structure.source.SourceSection;

/**
 * This class can be used to {@link #selectMappings() select suitable mappings} for a list of
 * {@link MatchedSectionDescriptor matched sections}.
 * <p />
 * Conditions will be evaluated and occurring ambiguities will be resolved during the process of
 * {@link #selectMappings()}.
 *
 * @author mfreund
 */
public class MappingSelector extends CancelableElement {

	/**
	 * A map representing the {@link MatchedSectionDescriptor MatchedSectionDescriptors} found for every
	 * {@link SourceSection}.
	 */
	private final Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections;

	/**
	 * The list of {@link Mapping Mappings} that shall be considered.
	 */
	private final List<Mapping> mappings;

	/**
	 * The subset of {@link #mappings} that is equipped with one or more {@link ApplicationDependency
	 * ApplicationDependencies}.
	 */
	private final List<Mapping> dependentMappings;

	/**
	 * This keeps track of the mappings that have been selected (the result of the {@link #selectMappings()} step.
	 */
	private Map<Mapping, List<MappingInstanceStorage>> selectedMappings;

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
	 * The {@link ConditionHandler} that is used to evaluate conditions.
	 */
	private ConditionHandler conditionHandler;

	/**
	 * The {@link Logger} that shall be used to print messages.
	 */
	private final Logger logger;

	/**
	 * This creates an instance.
	 *
	 * @param matchedSections
	 *            A map representing the {@link MatchedSectionDescriptor MatchedSectionDescriptors} found for every
	 *            {@link SourceSection}.
	 * @param mappings
	 *            The list of {@link Mapping Mappings} that shall be considered.
	 * @param globalValues
	 *            The <em>global values</em> (values of {@link FixedValue FixedValues} and {@link GlobalAttribute
	 *            GlobalAttribute}) defined in the PAMTraM model.
	 * @param onlyAskOnceOnAmbiguousMappings
	 *            If ambiguous {@link Mapping Mappings} should be resolved only once or on a per-element basis.
	 * @param ambiguityResolvingStrategy
	 *            The {@link IAmbiguityResolvingStrategy} to be used.
	 * @param attributeValueCalculator
	 *            The {@link AttributeValueCalculator} to use in order to calculate resulting values.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 */
	public MappingSelector(Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections, List<Mapping> mappings,
			GlobalValueMap globalValues, boolean onlyAskOnceOnAmbiguousMappings,
			IAmbiguityResolvingStrategy ambiguityResolvingStrategy, AttributeValueCalculator attributeValueCalculator,
			Logger logger) {

		this.matchedSections = matchedSections;
		this.mappings = new ArrayList<>(mappings);
		this.dependentMappings = Collections.synchronizedList(new ArrayList<>());
		this.selectedMappings = Collections.synchronizedMap(new HashMap<>());
		this.deferredSections = Collections.synchronizedList(new ArrayList<>());
		this.onlyAskOnceOnAmbiguousMappings = onlyAskOnceOnAmbiguousMappings;
		this.ambiguityResolvingStrategy = ambiguityResolvingStrategy;
		this.conditionHandler = new ConditionHandler(matchedSections, globalValues, attributeValueCalculator);
		this.logger = logger;

	}

	/**
	 * For each {@link MatchedSectionDescriptor} represented in the {@link #matchedSections}, this selects a suitable
	 * mapping.
	 *
	 * @return The selected mappings in the form of a {@link MappingInstanceStorage} for each
	 *         {@link MatchedSectionDescriptor}.
	 */
	public Map<Mapping, List<MappingInstanceStorage>> selectMappings() {

		// First, we need to filter mapping models with conditions that evaluate to 'false'
		//
		Set<MappingModel> mappingModels = this.mappings.parallelStream().map(m -> (MappingModel) m.eContainer())
				.collect(Collectors.toSet());

		Set<MappingModel> mappingModelsWithNegativeCondition = mappingModels.stream()
				.filter(m -> !this.checkCondition(m)).collect(Collectors.toSet());
		this.mappings.removeAll(mappingModelsWithNegativeCondition.stream().flatMap(m -> m.getMapping().stream())
				.collect(Collectors.toList()));

		// TODO also filter if sub-conditions of type ApplicationDependency
		this.dependentMappings.addAll(this.mappings.parallelStream()
				.filter(m -> m.getLocalCondition() instanceof ApplicationDependency).collect(Collectors.toList()));

		// Select a mapping for each matched section and each descriptor instance.
		// In the first run, we 'defer' those sections that are associated with a Mapping that contains a
		// 'MappingDependency'.
		//
		List<MappingInstanceStorage> mappingInstances = this.matchedSections.entrySet().parallelStream()
				.map(e -> this.selectMapping(e.getKey(), e.getValue(), true)).flatMap(l -> l.stream())
				.collect(Collectors.toList());

		this.selectedMappings.putAll(mappingInstances.parallelStream()
				.collect(Collectors.toConcurrentMap(m -> m.getMapping(), Arrays::asList,
						(m1, m2) -> Stream.concat(m1.stream(), m2.stream()).collect(Collectors.toList()))));

		// Now, do the same stuff for the 'deferred' sections as we are now able to evaluate the
		// 'ApplicationDependencies'.
		//
		List<MappingInstanceStorage> deferredInstances = this.deferredSections.parallelStream()
				.map(s -> this.selectMapping(s, this.matchedSections.get(s), false)).flatMap(l -> l.stream())
				.collect(Collectors.toList());

		this.selectedMappings.putAll(deferredInstances.parallelStream()
				.collect(Collectors.toConcurrentMap(m -> m.getMapping(), Arrays::asList,
						(m1, m2) -> Stream.concat(m1.stream(), m2.stream()).collect(Collectors.toList()))));

		return this.selectedMappings;
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
	 * @param deferApplicationDependencies
	 *            This can be used to control whether those sections, for that at least one of the applicable mappings
	 *            has an {@link ApplicationDependency} shall be 'deferred'. Typically, this should be set to 'true'
	 *            during the first run (to collect the {@link #deferredSections} and to 'false' during the second run.
	 * @return A list of {@link MappingInstanceStorage MappingInstanceStorages} (one for each of the given
	 *         <em>descriptors</em>). Note: The {@link MappingInstanceStorage MappingInstanceStorages} do not yet
	 *         contain any calculated hint values.
	 */
	private List<MappingInstanceStorage> selectMapping(SourceSection matchedSection,
			List<MatchedSectionDescriptor> descriptors, boolean deferApplicationDependencies) {

		// This will be returned in the end
		//
		List<MappingInstanceStorage> ret = new ArrayList<>();

		// The mappings with suitable 'sourceMMSections'
		//
		Set<Mapping> applicableMappings = this.mappings.parallelStream()
				.filter(m -> matchedSection.equals(m.getSourceSection())).collect(Collectors.toSet());

		// Check if we need to 'defer' the selection of mappings for the given set of 'descriptors' as at least one of
		// the possible mappings has an 'ApplicationDependency'
		if (deferApplicationDependencies
				&& applicableMappings.parallelStream().anyMatch(this.dependentMappings::contains)) {
			this.deferredSections.add(matchedSection);
			return ret;
		}

		// Filter mappings and descriptors by the applicability of conditions
		//
		Map<Set<Mapping>, Set<MatchedSectionDescriptor>> applicableMappingsToDescriptors = this
				.checkConditions(applicableMappings, descriptors);

		// Select mappings to be instantiated and create 'MappingInstanceStorages'
		//
		for (Entry<Set<Mapping>, Set<MatchedSectionDescriptor>> entry : applicableMappingsToDescriptors.entrySet()) {

			switch (entry.getKey().size()) {
				case 0:
					// no applicable mapping was found
					break;
				case 1:
					// create a MappingInstanceStorage for each descriptor
					Mapping mapping = entry.getKey().iterator().next();
					ret.addAll(entry.getValue().parallelStream().map(d -> this.createMappingInstanceStorage(d, mapping))
							.collect(Collectors.toList()));
					break;
				default:

					/*
					 * Consult the specified resolving strategy to resolve the ambiguity.
					 */
					try {
						if (this.onlyAskOnceOnAmbiguousMappings) {
							MatchedSectionDescriptor descriptor = entry.getValue().iterator().next();
							List<Mapping> resolved = this.selectMappingForDescriptor(descriptor, entry.getKey());

							// create a MappingInstanceStorage for each descriptor and each selected mapping
							//
							Iterator<Mapping> it = resolved.iterator();
							while (it.hasNext()) {

								Mapping resolvedMapping = it.next();
								ret.addAll(entry.getValue().parallelStream()
										.map(d -> this.createMappingInstanceStorage(d, resolvedMapping))
										.collect(Collectors.toList()));
							}
						} else {

							for (MatchedSectionDescriptor descriptor : entry.getValue()) {
								List<Mapping> resolved = this.selectMappingForDescriptor(descriptor, entry.getKey());

								// create a MappingInstanceStorage for each descriptor and each selected mapping
								//
								Iterator<Mapping> it = resolved.iterator();
								while (it.hasNext()) {

									Mapping resolvedMapping = it.next();
									ret.add(this.createMappingInstanceStorage(descriptor, resolvedMapping));
								}
							}
						}
					} catch (Exception e) {
						this.logger.severe(e.getMessage());
						this.canceled = true;
						return new ArrayList<>();
					}

			}
		}

		// Check conditions of hint groups and hints for the selected MappingInstanceStorages
		//
		ret.parallelStream().forEach(this::determineElementsWithNegativeConditions);

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
	 * @return A map relating sets of applicable mappings to sets of descriptors for that the applicable mappings are
	 *         valid.
	 */
	private Map<Set<Mapping>, Set<MatchedSectionDescriptor>> checkConditions(Set<Mapping> applicableMappings,
			List<MatchedSectionDescriptor> descriptors) {

		// The map that will be returned in the end
		//
		Map<Set<Mapping>, Set<MatchedSectionDescriptor>> applicableMappingsToDescriptors = new HashMap<>();

		// Check conditions
		//
		for (MatchedSectionDescriptor descriptor : descriptors) {

			// The subset of the given 'applicableMappings' that is applicable for the current 'descriptor'
			//
			Set<Mapping> localApplicableMappings = applicableMappings.parallelStream()
					.filter(m -> this.checkConditions(m, descriptor)).collect(Collectors.toSet());

			// Check if there are already descriptors for that the same set of mappings are applicable
			//
			Optional<Entry<Set<Mapping>, Set<MatchedSectionDescriptor>>> existing = applicableMappingsToDescriptors
					.entrySet().stream().filter(entry -> entry.getKey().size() == localApplicableMappings.size()
							&& entry.getKey().containsAll(localApplicableMappings))
					.findFirst();

			if (existing.isPresent()) {
				existing.get().getValue().add(descriptor);
			} else {
				applicableMappingsToDescriptors.put(localApplicableMappings, new HashSet<>(Arrays.asList(descriptor)));
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
		return this.conditionHandler.checkCondition(mapping.getLocalCondition(), descriptor,
				this.selectedMappings) == CondResult.TRUE
				&& this.conditionHandler.checkCondition(mapping.getSharedCondition(), descriptor,
						this.selectedMappings) == CondResult.TRUE;

	}

	/**
	 * This evaluates the conditions of the {@link ConditionalElement ConditionalElements} contained in the mapping
	 * represented by the given {@link MappingInstanceStorage}. Elements with conditions that have been evaluated as
	 * <em>negative</em> are {@link MappingInstanceStorage#addElementWithNegativeCondition(ConditionalElement) stored}
	 * in the <em>mappingInstance</em>.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage} representing the ConditionalElements to be checked.
	 */
	private void determineElementsWithNegativeConditions(MappingInstanceStorage mappingInstance) {

		// check conditions of all corresponding MappingHintGroups
		//
		mappingInstance.getMapping().getActiveMappingHintGroups().parallelStream()
				.filter(hg -> hg instanceof ConditionalElement).forEach(hg -> {

					boolean result = this.checkCondition((ConditionalElement) hg, mappingInstance);

					if (result) {

						// Iterate now over all corresponding MappingHints
						//
						hg.getMappingHints().parallelStream().forEach(m -> this.checkCondition(m, mappingInstance));
					}
				});

		// check Condition of corresponding IMPORTED MappingHintGroups
		//
		mappingInstance.getMapping().getActiveImportedMappingHintGroups().parallelStream()
				.forEach(hg -> this.checkCondition(hg, mappingInstance));

	}

	/**
	 * Checks the condition of the given {@link ConditionalElement}. If the condition evaluates to
	 * {@link CondResult#FALSE}, the element is
	 * {@link MappingInstanceStorage#addElementWithNegativeCondition(ConditionalElement) marked as negative} in the
	 * given {@link MappingInstanceStorage}.
	 *
	 * @param conditionalElement
	 *            The {@link ConditionalElement} to check.
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage} associated with the given <em>conditionalElement</em>.
	 * @return '<em><b>true</b></em>' if the condition was evaluated to {@link CondResult#TRUE}; '<em><b>false</b></em>'
	 *         otherwise.
	 */
	private boolean checkCondition(ConditionalElement conditionalElement, MappingInstanceStorage mappingInstance) {

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

		return !(this.conditionHandler.checkCondition(conditionalElement.getLocalCondition(), descriptor,
				this.selectedMappings) == CondResult.FALSE
				|| this.conditionHandler.checkCondition(conditionalElement.getSharedCondition(), descriptor,
						this.selectedMappings) == CondResult.FALSE);

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

		return !(this.conditionHandler.checkCondition(mappingModel.getLocalCondition(), null,
				this.selectedMappings) == CondResult.FALSE
				|| this.conditionHandler.checkCondition(mappingModel.getSharedCondition(), null,
						this.selectedMappings) == CondResult.FALSE);

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
			Set<Mapping> applicableMappings) throws AmbiguityResolvingException {

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
	 * This creates a {@link MappingInstanceStorage} for the given {@link MatchedSectionDescriptor descriptor}.
	 *
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} for that the {@link MappingInstanceStorage} shall be created.
	 * @param mapping
	 *            The {@link Mapping} that the MappingInstanceStorage shall represent.
	 * @return The created {@link MappingInstanceStorage}.
	 */
	private MappingInstanceStorage createMappingInstanceStorage(MatchedSectionDescriptor descriptor, Mapping mapping) {

		MappingInstanceStorage ret = new MappingInstanceStorage(descriptor);
		ret.setMapping(mapping);
		return ret;
	}
}
