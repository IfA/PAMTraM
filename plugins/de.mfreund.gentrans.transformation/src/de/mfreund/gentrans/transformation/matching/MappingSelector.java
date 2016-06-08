package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.condition.ConditionHandler;
import de.mfreund.gentrans.transformation.condition.ConditionHandler.condResult;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.util.CancellableElement;
import pamtram.ConditionalElement;
import pamtram.mapping.FixedValue;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.metamodel.SourceSection;

/**
 * This class can be used to select suitable mappings for a list of {@link MatchedSectionDescriptor matched sections}.
 * <p />
 * Occurring ambiguities will be resolved.
 * 
 * @author mfreund
 */
public class MappingSelector extends CancellableElement {
	
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
	 * The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	private final MessageConsoleStream consoleStream;

	/**
	 * This creates an instance.
	 * 
	 * @param matchedSections A map representing the {@link MatchedSectionDescriptor MatchedSectionDescriptors} found
	 * for every {@link SourceSection}.
	 * @param mappings The list of {@link Mapping Mappings} that shall be considered.
	 * @param globalValues The list of {@link FixedValue global values} defined in the pamtram model.
	 * @param onlyAskOnceOnAmbiguousMappings If ambiguous {@link Mapping Mappings} should be resolved only once or on a 
	 * per-element basis.
	 * @param ambiguityResolvingStrategy The {@link IAmbiguityResolvingStrategy} to be used.
	 * @param consoleStream
	 *           The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	public MappingSelector(Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections, List<Mapping> mappings, 
			EList<FixedValue> globalValues, boolean onlyAskOnceOnAmbiguousMappings, IAmbiguityResolvingStrategy ambiguityResolvingStrategy, MessageConsoleStream consoleStream) {
		
		this.matchedSections = matchedSections;
		this.mappings = mappings;
		this.onlyAskOnceOnAmbiguousMappings = onlyAskOnceOnAmbiguousMappings;
		this.ambiguityResolvingStrategy = ambiguityResolvingStrategy;
		this.conditionHandler = new ConditionHandler(matchedSections, globalValues);
		this.consoleStream = consoleStream;
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
						ret.addAll( entry.getValue().parallelStream().map(d -> createMappingInstanceStorage(d, resolvedMapping)).collect(Collectors.toList()));
					} else {
						
						for (MatchedSectionDescriptor descriptor :  entry.getValue()) {
							List<Mapping> resolved = selectMappingForDescriptor(descriptor, entry.getKey());
							
							// create a MappingInstanceStorage for each descriptor
							ret.add(createMappingInstanceStorage(descriptor, resolved.iterator().next()));
						}
					}			
				} catch (Exception e) {
					consoleStream.println(e.getMessage());
					canceled = true;
					return new ArrayList<>();
				}
				
			}
		}

		// Check conditions of hint groups and hints for the selected MappingInstanceStorages
		//
		ret.parallelStream().forEach(this::checkConditions);
		
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
		//TODO the descriptor should be involved in the checking of the condition
		if(conditionHandler.checkCondition(mapping.getCondition()) == condResult.true_condition && 
				conditionHandler.checkCondition(mapping.getConditionRef()) == condResult.true_condition) {
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
	 * @param mappingInstace The {@link MappingInstanceStorage} representing the ConditionalElements to be checked.
	 */
	private void checkConditions(MappingInstanceStorage mappingInstace) {
		
		// Iterate now over all corresponding MappingHintGroups...
		for (Iterator<MappingHintGroupType> mHintGroupList = mappingInstace.getMapping().getActiveMappingHintGroups().iterator(); mHintGroupList.hasNext();){
			
			MappingHintGroupType mHintGroup = mHintGroupList.next();
			if(mHintGroup instanceof ConditionalElement){
				
				if(conditionHandler.checkCondition(((ConditionalElement) mHintGroup).getCondition()) == condResult.false_condition || 
						conditionHandler.checkCondition(((ConditionalElement) mHintGroup).getConditionRef()) == condResult.false_condition){
					
					//returned false, so remove this Element and break the loop
					mappingInstace.addElementWithNegativeCondition((ConditionalElement) mHintGroup);
					continue;
				} else {
					
					// Iterate now over all corresponding MappingHints
					for(Iterator<MappingHint> mHintList = mHintGroup.getMappingHints().iterator(); mHintList.hasNext();){
						
						MappingHint mHint = mHintList.next();
						if(conditionHandler.checkCondition((mHint).getCondition()) == condResult.false_condition || 
								conditionHandler.checkCondition((mHint).getConditionRef()) == condResult.false_condition){
							
							//returned false, so remove this Element and break the loop
							mappingInstace.addElementWithNegativeCondition((ConditionalElement) mHint);
						}
					}
				}
			}
		}
		
		// check Condition of corresponding IMPORTED MappingHintGroups
		for (Iterator<MappingHintGroupImporter> mImportHintGroupList = mappingInstace.getMapping().getActiveImportedMappingHintGroups().iterator(); mImportHintGroupList.hasNext();){
			
			MappingHintGroupImporter mImportHintGroup = mImportHintGroupList.next();
				
			//Condition of imported MappingHintGroup false, than remove it
			if(conditionHandler.checkCondition(mImportHintGroup.getCondition()) == condResult.false_condition ||
					conditionHandler.checkCondition(mImportHintGroup.getConditionRef()) == condResult.false_condition){
				
				mappingInstace.addElementWithNegativeCondition((ConditionalElement) mImportHintGroup);
			}
			
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
		consoleStream.println("[Ambiguity] Resolve matching ambiguity...");
		List<Mapping> resolved = ambiguityResolvingStrategy.matchingSelectMapping(
				new ArrayList<>(applicableMappings), descriptor.getAssociatedSourceModelElement());
		consoleStream.println("[Ambiguity] ...finished.\n");
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
