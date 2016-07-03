package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import de.mfreund.gentrans.transformation.calculation.AttributeValueCalculator;
import de.mfreund.gentrans.transformation.condition.ConditionHandler;
import de.mfreund.gentrans.transformation.condition.ConditionHandler.CondResult;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.util.CancelableElement;
import pamtram.ConditionalElement;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.metamodel.SourceSection;

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
	 * A map representing the {@link MatchedSectionDescriptor MatchedSectionDescriptors} found
	 * for every {@link SourceSection}.
	 */
	private final Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections;

	/**
	 * The list of {@link Mapping Mappings} that shall be considered.
	 */
	private final List<Mapping> mappings;

	/**
	 * If ambiguous {@link Mapping Mappings} should be resolved only once or on a per-element basis.
	 */
	private boolean onlyAskOnceOnAmbiguousMappings;

	/**
	 * This is the {@link IAmbiguityResolvingStrategy} that shall be used to 
	 * resolve ambiguities that arise during the execution of the transformation.
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
	 *            A map representing the {@link MatchedSectionDescriptor
	 *            MatchedSectionDescriptors} found for every
	 *            {@link SourceSection}.
	 * @param mappings
	 *            The list of {@link Mapping Mappings} that shall be considered.
	 * @param globalValues
	 *            The <em>global values</em> (values of {@link FixedValue
	 *            FixedValues} and {@link GlobalAttribute GlobalAttribute})
	 *            defined in the PAMTraM model.
	 * @param onlyAskOnceOnAmbiguousMappings
	 *            If ambiguous {@link Mapping Mappings} should be resolved only
	 *            once or on a per-element basis.
	 * @param ambiguityResolvingStrategy
	 *            The {@link IAmbiguityResolvingStrategy} to be used.
	 * @param attributeValueCalculator
	 *            The {@link AttributeValueCalculator} to use in order to
	 *            calculate resulting values.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 */
	public MappingSelector(Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections, List<Mapping> mappings, 
			GlobalValueMap globalValues, boolean onlyAskOnceOnAmbiguousMappings, IAmbiguityResolvingStrategy ambiguityResolvingStrategy,
			AttributeValueCalculator attributeValueCalculator, Logger logger) {

		this.matchedSections = matchedSections;
		this.mappings = mappings;
		this.onlyAskOnceOnAmbiguousMappings = onlyAskOnceOnAmbiguousMappings;
		this.ambiguityResolvingStrategy = ambiguityResolvingStrategy;
		this.conditionHandler = new ConditionHandler(matchedSections, globalValues, attributeValueCalculator);
		this.logger = logger;
	}

	/**
	 * For each {@link MatchedSectionDescriptor} represented in the {@link #matchedSections}, this selects a
	 * suitable mapping.
	 * 
	 * @return The selected mappings in the form of a {@link MappingInstanceStorage} for each {@link MatchedSectionDescriptor}.
	 */
	public Map<Mapping, List<MappingInstanceStorage>> selectMappings() {

		// Select a mapping for each matched section and each descriptor instance
		//
		List<MappingInstanceStorage> mappingInstances = matchedSections.entrySet().parallelStream().map(e -> selectMapping(e.getKey(), e.getValue())).
				flatMap(l -> l.stream()).collect(Collectors.toList());

		// Sort determined mapping instances by mapping and return them
		//
		Map<Mapping, List<MappingInstanceStorage>> ret = new HashMap<>();
		for (MappingInstanceStorage mappingInstance : mappingInstances) {

			Mapping mapping = mappingInstance.getMapping();

			if(!ret.containsKey(mapping)) {
				ret.put(mapping, new ArrayList<>());
			}
			ret.get(mapping).add(mappingInstance);
		}
		return ret;
	}

	/**
	 * For the given {@link SourceSection} and the list of associated {@link MatchedSectionDescriptor MatchedSectionDescriptor}
	 * select a mapping.
	 * <p />
	 * Note: The {@link #onlyAskOnceOnAmbiguousMappings} setting is taken into account during this step.
	 * 
	 * @param matchedSection The {@link SourceSection} for that a mapping shall be selected.
	 * @param descriptors The list of {@link MatchedSectionDescriptor MatchedSectionDescriptors} that are associated with the
	 * <em>matchedSection</em>.
	 * @return A list of {@link MappingInstanceStorage MappingInstanceStorages} (one for each of the given <em>descriptors</em>).
	 * Note: The {@link MappingInstanceStorage MappingInstanceStorages} do not yet contain any calculated hint values.
	 */
	private List<MappingInstanceStorage> selectMapping(SourceSection matchedSection, List<MatchedSectionDescriptor> descriptors) {

		// This will be returned in the end
		//
		List<MappingInstanceStorage> ret = new ArrayList<>();

		// The mappings with suitable 'sourceMMSections'
		//
		Set<Mapping> applicableMappings = 
				this.mappings.parallelStream().filter(m -> matchedSection.equals(m.getSourceMMSection())).collect(Collectors.toSet());

		// Filter mappings and descriptors by the applicability of conditions
		//
		Map<Set<Mapping>, Set<MatchedSectionDescriptor>> applicableMappingsToDescriptors = checkConditions(applicableMappings,
				descriptors);

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
				ret.addAll(entry.getValue().parallelStream().map(d -> createMappingInstanceStorage(d, mapping)).collect(Collectors.toList()));
				break;
			default:

				/*
				 * Consult the specified resolving strategy to resolve the ambiguity.				
				 */
				//TODO maybe we need to allow to also select multiple mappings 
				try {
					if(onlyAskOnceOnAmbiguousMappings) {
						MatchedSectionDescriptor descriptor = entry.getValue().iterator().next();
						List<Mapping> resolved = selectMappingForDescriptor(descriptor, entry.getKey());

						// create a MappingInstanceStorage for each descriptor
						Mapping resolvedMapping = resolved.iterator().next();
						ret.addAll(entry.getValue().parallelStream().map(d -> createMappingInstanceStorage(d, resolvedMapping)).collect(Collectors.toList()));
					} else {

						for (MatchedSectionDescriptor descriptor :  entry.getValue()) {
							List<Mapping> resolved = selectMappingForDescriptor(descriptor, entry.getKey());

							// create a MappingInstanceStorage for each descriptor
							ret.add(createMappingInstanceStorage(descriptor, resolved.iterator().next()));
						}
					}			
				} catch (Exception e) {
					logger.severe(e.getMessage());
					canceled = true;
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
	 * As the applicability of a mapping may be dependent on the concrete {@link MatchedSectionDescriptor},
	 * a list of <em>descriptors</em> needs to be passed as well. The result of this will be a 
	 * map relating sets of applicable mappings to sets of descriptors. 
	 * 
	 * @param applicableMappings The list of {@link Mapping Mappings} for that the conditions shall be checked.
	 * @param descriptors The list of {@link MatchedSectionDescriptor MatchedSectionDescriptor} to be used during the check.
	 * 
	 * @return A map relating sets of applicable mappings to sets of descriptors for that the applicable mappings are valid.
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
			Set<Mapping> localApplicableMappings = applicableMappings.parallelStream().filter(
					m -> checkConditions(m, descriptor)).collect(Collectors.toSet());

			// Check if there are already descriptors for that the same set of mappings are applicable
			//
			Optional<Entry<Set<Mapping>, Set<MatchedSectionDescriptor>>> existing = applicableMappingsToDescriptors.entrySet().stream().filter(
					entry -> entry.getKey().size() == localApplicableMappings.size() && entry.getKey().containsAll(localApplicableMappings)).findFirst();

			if(existing.isPresent()) {
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
	 * @param mapping The {@link Mapping} to be checked for applicability.
	 * @param descriptor The {@link MatchedSectionDescriptor} for that the applicability shall be checked.
	 * @return '<em><b>true</b></em>' if the mapping is applicable; '<em><b>false</b></em>' otherwise.
	 */
	private boolean checkConditions(Mapping mapping, MatchedSectionDescriptor descriptor) {

		// check Conditions of the Mapping (Note: no condition modeled = true)
		if(conditionHandler.checkCondition(mapping.getCondition(), descriptor) == CondResult.TRUE && 
				conditionHandler.checkCondition(mapping.getConditionRef(), descriptor) == CondResult.TRUE) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * This evaluates the conditions of the {@link ConditionalElement ConditionalElements} contained in
	 * the mapping represented by the given {@link MappingInstanceStorage}. Elements with conditions that
	 * have been evaluated as <em>negative</em> are {@link MappingInstanceStorage#addElementWithNegativeCondition(ConditionalElement) 
	 * stored} in the <em>mappingInstance</em>.
	 * 
	 * @param mappingInstance The {@link MappingInstanceStorage} representing the ConditionalElements to be checked.
	 */
	private void determineElementsWithNegativeConditions(MappingInstanceStorage mappingInstance) {

		// check conditions of all corresponding MappingHintGroups...
		mappingInstance.getMapping().getActiveMappingHintGroups().parallelStream().filter(hg -> hg instanceof ConditionalElement).forEach(hg -> {

			boolean result = checkCondition((ConditionalElement) hg, mappingInstance);

			if(result) {

				// Iterate now over all corresponding MappingHints
				hg.getMappingHints().parallelStream().forEach(
						m -> checkCondition(m, mappingInstance));
			}
		});

		// check Condition of corresponding IMPORTED MappingHintGroups
		mappingInstance.getMapping().getActiveImportedMappingHintGroups().parallelStream().forEach(
				hg -> checkCondition(hg, mappingInstance));

	}

	/**
	 * Checks the condition of the given {@link ConditionalElement}. If the condition evaluates to {@link CondResult#FALSE},
	 * the element is {@link MappingInstanceStorage#addElementWithNegativeCondition(ConditionalElement) marked as negative}
	 * in the given {@link MappingInstanceStorage}.
	 * 
	 * @param conditionalElement The {@link ConditionalElement} to check.
	 * @param mappingInstance The {@link MappingInstanceStorage} associated with the given <em>conditionalElement</em>.
	 * @return '<em><b>true</b></em>' if the condition was evaluated to {@link CondResult#TRUE}; '<em><b>false</b></em>' otherwise.
	 */
	private boolean checkCondition(ConditionalElement conditionalElement, MappingInstanceStorage mappingInstance) {

		boolean result = checkCondition(conditionalElement, mappingInstance.getMatchedSectionDescriptor());

		if(!result) {

			mappingInstance.addElementWithNegativeCondition(conditionalElement);
		}

		return result;
	}

	/**
	 * Checks the condition of the given {@link ConditionalElement}.
	 * 
	 * @param conditionalElement The {@link ConditionalElement} to check.
	 * @return '<em><b>true</b></em>' if the condition was evaluated to {@link CondResult#TRUE}; '<em><b>false</b></em>' otherwise.
	 */
	private boolean checkCondition(ConditionalElement conditionalElement, MatchedSectionDescriptor descriptor) {
		if(conditionHandler.checkCondition(conditionalElement.getCondition(), descriptor) == CondResult.FALSE || 
				conditionHandler.checkCondition(conditionalElement.getConditionRef(), descriptor) == CondResult.FALSE){

			return false;
		} else {

			return true;
		}

	}

	/**
	 * Determine one or multiple mappings to be applied for the given {@link MatchedSectionDescriptor} based
	 * on the specified {@link #ambiguityResolvingStrategy}.
	 * 
	 * @param descriptor The {@link MatchedSectionDescriptor} for that the mappings to be applied are determined.
	 * @param applicableMappings The list of applicable {@link Mapping Mappings} that shall be taken into account.
	 * @return
	 * @throws Exception
	 */
	private List<Mapping> selectMappingForDescriptor(MatchedSectionDescriptor descriptor,
			Set<Mapping> applicableMappings) throws Exception {
		logger.fine("[Ambiguity] Resolve matching ambiguity...");
		List<Mapping> resolved = ambiguityResolvingStrategy.matchingSelectMapping(
				new ArrayList<>(applicableMappings), descriptor.getAssociatedSourceModelElement());
		logger.fine("[Ambiguity] ...finished.\n");
		return resolved;
	}

	/**
	 * This creates a {@link MappingInstanceStorage} for the given {@link MatchedSectionDescriptor descriptor}.
	 * 
	 * @param descriptor The {@link MatchedSectionDescriptor} for that the {@link MappingInstanceStorage} shall be created.
	 * @param mapping The {@link Mapping} that the MappingInstanceStorage shall represent.
	 * @return The created {@link MappingInstanceStorage}.
	 */
	private MappingInstanceStorage createMappingInstanceStorage(MatchedSectionDescriptor descriptor, Mapping mapping) {

		MappingInstanceStorage ret = new MappingInstanceStorage(descriptor);
		ret.setMapping(mapping);
		return ret;
	}
}
