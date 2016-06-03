package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.util.CancellableElement;
import pamtram.mapping.Mapping;
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
	 * The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	private final MessageConsoleStream consoleStream;

	/**
	 * This creates an instance.
	 * 
	 * @param matchedSections A map representing the {@link MatchedSectionDescriptor MatchedSectionDescriptors} found
	 * for every {@link SourceSection}.
	 * @param mappings The list of {@link Mapping Mappings} that shall be considered.
	 * @param onlyAskOnceOnAmbiguousMappings If ambiguous {@link Mapping Mappings} should be resolved only once or on a 
	 * per-element basis.
	 * @param ambiguityResolvingStrategy The {@link IAmbiguityResolvingStrategy} to be used.
	 * @param consoleStream
	 *           The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	public MappingSelector(Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections, List<Mapping> mappings, 
			boolean onlyAskOnceOnAmbiguousMappings, IAmbiguityResolvingStrategy ambiguityResolvingStrategy, MessageConsoleStream consoleStream) {
		
		this.matchedSections = matchedSections;
		this.mappings = mappings;
		this.onlyAskOnceOnAmbiguousMappings = onlyAskOnceOnAmbiguousMappings;
		this.ambiguityResolvingStrategy = ambiguityResolvingStrategy;
		this.consoleStream = consoleStream;
	}
	
	/**
	 * For each {@link MatchedSectionDescriptor} represented in the {@link #matchedSections}, this selects a
	 * suitable mapping.
	 * 
	 * @return The selected mappings in the form of a {@link MappingInstanceStorage} for each {@link MatchedSectionDescriptor}.
	 */
	public Map<Mapping, List<MappingInstanceStorage>> selectMappings() {
		
		//TODO check conditions
		
		// Select a mapping for each matched section and each descriptor instance
		//
//		List<MappingInstanceStorage> mappingInstances = matchedSections.entrySet().stream().map(e -> selectMapping(e.getKey(), e.getValue())).
//			flatMap(l -> l.stream()).collect(Collectors.toList());
		
		List<MappingInstanceStorage> mappingInstances = new ArrayList<>();
		for (Entry<SourceSection, List<MatchedSectionDescriptor>> entry : matchedSections.entrySet()) {
			List<MappingInstanceStorage> instances = selectMapping(entry.getKey(), entry.getValue());
			if(instances == null || instances.isEmpty()) {
				System.out.println("ohoh");
			}
			mappingInstances.addAll(instances);
		}
		
		// Sort determined mapping instances by mapping and return them
		//
		Map<Mapping, List<MappingInstanceStorage>> ret = new HashMap<>();
		for (MappingInstanceStorage mappingInstance : mappingInstances) {
			
			if(mappingInstance == null) {
				System.out.println("ohoh");
			}
			
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
		
		// The mappings with suitable 'sourceMMSections'
		Set<Mapping> applicableMappings = 
				this.mappings.parallelStream().filter(m -> matchedSection.equals(m.getSourceMMSection())).collect(Collectors.toSet());
		
		List<MappingInstanceStorage> ret = new ArrayList<>();

		switch (applicableMappings.size()) {
		case 0:
			// no applicable mapping was found
			return new ArrayList<>();
		case 1:
			// create a MappingInstanceStorage for each descriptor
			descriptors.parallelStream().forEach(d -> ret.add(createMappingInstanceStorage(d, applicableMappings.iterator().next())));
			break;
		default:
			
				/*
				 * Consult the specified resolving strategy to resolve the ambiguity.				
				 */
				//TODO maybe we need to allow to also select multiple mappings 
				try {
					if(onlyAskOnceOnAmbiguousMappings) {
						MatchedSectionDescriptor descriptor = descriptors.iterator().next();
						List<Mapping> resolved = selectMappingForDescriptor(descriptor, applicableMappings);
					
						// create a MappingInstanceStorage for each descriptor
						descriptors.parallelStream().forEach(d -> ret.add(createMappingInstanceStorage(d, resolved.iterator().next())));
					} else {
						
						for (MatchedSectionDescriptor descriptor : descriptors) {
							List<Mapping> resolved = selectMappingForDescriptor(descriptor, applicableMappings);
						
							// create a MappingInstanceStorage for each descriptor
							descriptors.parallelStream().forEach(d -> ret.add(createMappingInstanceStorage(d, resolved.iterator().next())));
						}
					}			
				} catch (Exception e) {
					consoleStream.println(e.getMessage());
					canceled = true;
					return new ArrayList<>();
				}
				
		}
		
		return ret;
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
		
		MappingInstanceStorage ret = new MappingInstanceStorage();
		ret.setMapping(mapping);
		ret.setAssociatedSourceElement(descriptor.getAssociatedSourceSectionClass(), descriptor.getAssociatedSourceModelElement());
		ret.setSourceModelObjectsMapped(descriptor.getSourceModelObjectsMapped());
		ret.setContainerDescriptor(descriptor.getContainerDescriptor());
		return ret;
	}
}
