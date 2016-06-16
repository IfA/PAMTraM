package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.maps.HintValueMap;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintBaseType;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.ModelConnectionHintSourceInterface;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionReference;

/**
 * This class can be used to extract hint values and values of {@link GlobalAttribute GlobalAttributes}
 * from source model elements for a given list of {@link MappingInstanceStorage mapping instances}.
 * 
 * @author mfreund
 */
public class HintValueExtractor extends ValueExtractor {

	/**
	 * The list of {@link MappingInstanceStorage MappingInstanceStorages}
	 * for that the hint values shall be extracted.
	 */
	private List<MappingInstanceStorage> mappingInstances;
	
	/**
	 * This keeps track of the {@link MappingInstanceStorage MappingInstanceStorages} representing
	 * {@link ExportedMappingHintGroup ExportedMappingHintGroups}.
	 * <p/>
	 * This is used during {@link #extractImportedHintValues(MappingInstanceStorage)} to import hint values
	 * for {@link MappingHintGroupImporter MappingHintGroupImporters}.
	 */
	private Map<ExportedMappingHintGroup, MappingInstanceStorage> exportedHintGroups;
	
	/**
	 * This creates an instance for a given list of {@link MappingInstanceStorage mappingInstances}.
	 * <p />
	 * Note: The extracted hint values are stored in the given <em>mappingInstances</em>. 
	 * 
	 * @param mappingInstances The list of {@link MappingInstanceStorage MappingInstanceStorages}
	 * for that the hint values shall be extracted.
	 * @param globalAttributes The values of {@link GlobalAttribute GlobalAttributes} that shall be used by
	 * {@link #extractValue(GlobalAttributeImporter, MatchedSectionDescriptor)}.
	 * @param attributeValueModifierExecutor The {@link AttributeValueModifierExecutor} that shall be used for modifying attribute values.
	 * @param consoleStream The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	public HintValueExtractor(List<MappingInstanceStorage> mappingInstances, Map<GlobalAttribute, String> globalAttributes,
			AttributeValueModifierExecutor attributeValueModifierExecutor, MessageConsoleStream consoleStream) {

		super(globalAttributes, attributeValueModifierExecutor, consoleStream);
		
		this.mappingInstances = mappingInstances;
		this.exportedHintGroups = new HashMap<>();
	}

	/**
	 * This extracts the hint values and stores them in the {@link #mappingInstances}.
	 */
	public void extractHintValues() {
		
		// In a first step, we extract the hints of 'normal' and exported hint groups.
		//
		mappingInstances.parallelStream().forEach(this::extractHintValues);
		
		// Now, we collect exported hint groups and associated mapping instances
		//
		mappingInstances.parallelStream().forEach(
				m -> m.getMappingHintGroups().parallelStream().filter(hg -> hg instanceof ExportedMappingHintGroup).forEach(
						hg -> {
							if(exportedHintGroups.containsKey((ExportedMappingHintGroup) hg)) {
								consoleStream.println("Multiple occurences found for exported hint group '" + hg.getName() + 
										"'! This is currently not supported!");
							}
							exportedHintGroups.put((ExportedMappingHintGroup) hg, m);	
						}));
		
		// Now, we extract the hints for hint group importers (as we can now used the
		// hint values of exported hint groups that have been calculated before)
		//
		mappingInstances.parallelStream().forEach(this::extractImportedHintValues);
	}
	
	/**
	 * This extracts the hint values for the given {@link MappingInstanceStorage}.
	 * <p />
	 * Note: The extracted hint values are stored in the <em>mappingInstance</em>.
	 * 
	 * @param mappingInstance The {@link MappingInstanceStorage} for that the hint values shall be extracted.
	 */
	private void extractHintValues(MappingInstanceStorage mappingInstance) {
		
		// First, we collect all hints (including a possible ModelConnectionHint)
		//
		List<MappingHintBaseType> mappingHints = new ArrayList<>();
		for (MappingHintGroupType hintGroup : mappingInstance.getMappingHintGroups()) {
			if(hintGroup instanceof MappingHintGroup && 
					((MappingHintGroup) hintGroup).getModelConnectionMatcher() != null) {
				mappingHints.add(((MappingHintGroup) hintGroup).getModelConnectionMatcher());
			}
			mappingHints.addAll(hintGroup.getMappingHints());
		}
		
		// Now, we need to initialize the corresponding maps to store hint values
		// (Note: Using a parallel stream would for whatever reason result in exceptions, so we make use of a sequential stream).
		//
		mappingHints.stream().forEach(hint -> initializeHintValueMap(hint, mappingInstance));
		
		// Now, we can extract the hint values for each hint
		//
		mappingHints.parallelStream().forEach(h -> extractHintValue(h, mappingInstance));
	}

	/**
	 * This extracts the hint values of {@link MappingHintGroupImporter MappingHintGroupImporters} for 
	 * the given {@link MappingInstanceStorage}.
	 * <p />
	 * Note: The extracted hint values are stored in the <em>mappingInstance</em>.
	 * 
	 * @param mappingInstance The {@link MappingInstanceStorage} for that the hint values shall be extracted.
	 */
	private void extractImportedHintValues(MappingInstanceStorage mappingInstance) {
		
		for (MappingHintGroupImporter hintGroupImporter : mappingInstance.getMappingHintGroupImporters()) {
			
			// First, we copy all imported hint values
			//
			ExportedMappingHintGroup exportedHintGroup = hintGroupImporter.getHintGroup();
			MappingInstanceStorage exported = exportedHintGroups.get(exportedHintGroup);
			
			for (MappingHint hint : exportedHintGroup.getMappingHints()) {
				initializeHintValueMap(hint, mappingInstance);
				mappingInstance.getHintValues().addHintValues(hint, exported.getHintValues().getHintValues(hint));
			}
			
			// Now, we need to initialize the corresponding maps to store values for own hints
			// (Note: Using a parallel stream would for whatever reason result in exceptions, so we make use of a sequential stream).
			//
			hintGroupImporter.getMappingHints().stream().forEach(hint -> initializeHintValueMap(hint, mappingInstance));
			
			// Now, we can extract the hint values for each own hint
			//
			hintGroupImporter.getMappingHints().parallelStream().forEach(h -> extractHintValue(h, mappingInstance));
		}
		
	}

	/**
	 * This extracts the hint value for the given {@link MappingHintBaseType mapping hint}.
	 * <p />
	 * Note: The extracted hint value is stored in the <em>mappingInstance</em>.
	 * 
	 * @param hint The {@link MappingHintBaseType} for that the hint values shall be extracted.
	 * @param mappingInstance The {@link MappingInstanceStorage} for that the hint values shall be extracted.
	 */
	private void extractHintValue(MappingHintBaseType hint, MappingInstanceStorage mappingInstance) {
		
		// The MatchedSectionDescriptor for the SourceSection from that we want to extract hint values
		//
		MatchedSectionDescriptor matchedSectionDescriptor = mappingInstance.getMatchedSectionDescriptor();
		
		Object hintValue = null;
		
		if(hint instanceof AttributeMapping) {
			
			hintValue = extractHintValue((AttributeMapping) hint, matchedSectionDescriptor);
			
		} else if(hint instanceof MappingInstanceSelector) {
			
			if(((MappingInstanceSelector) hint).getMatcher() instanceof AttributeMatcher) {
			
				hintValue = extractHintValue((AttributeMatcher) ((MappingInstanceSelector) hint).getMatcher(), matchedSectionDescriptor);
			}
		
		} else if(hint instanceof ModelConnectionHint) {
			
			hintValue = extractHintValue((ModelConnectionHint) hint, matchedSectionDescriptor);
			
		} else if(hint instanceof CardinalityMapping) {
			
			hintValue = extractHintValue((CardinalityMapping) hint, matchedSectionDescriptor);
			
		} else if(hint instanceof MappedAttributeValueExpander) {
			
			hintValue = extractHintValue((MappedAttributeValueExpander) hint, matchedSectionDescriptor);
			
		} else {
			
			consoleStream.println("Unsupported type of MappingHint found: '" + hint.eClass().getName() + "'!");
		}
		
		storeHintValueConsolidated(hintValue, hint, mappingInstance);		
		
	}

	/**
	 * This extracts and returns the hint value for the given {@link AttributeMapping}.
	 * 
	 * @param attributeMapping The {@link AttributeMapping} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted hint value or '<em>null</em>' if nothing could be extracted.
	 */
	@SuppressWarnings("unchecked")
	private Map<AttributeMappingSourceInterface, AttributeValueRepresentation> extractHintValue(AttributeMapping attributeMapping, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		// This keeps track of the extracted hint value parts
		//
		Map<AttributeMappingSourceInterface, AttributeValueRepresentation> hintValue = new HashMap<>();
		
		// Extract the hint value part based on its type
		//
		for (AttributeMappingSourceInterface attributeMappingSourceInterface : attributeMapping.getSourceAttributeMappings()) {
			
			AttributeValueRepresentation attributeValueRepresentation = null;
			
			if(attributeMappingSourceInterface instanceof ModifiedAttributeElementType<?, ?, ?, ?>) {
				attributeValueRepresentation = extractValue((ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) attributeMappingSourceInterface, matchedSectionDescriptor);
			} else if(attributeMappingSourceInterface instanceof FixedValue) {
				attributeValueRepresentation = extractValue((FixedValue) attributeMappingSourceInterface, matchedSectionDescriptor); 
			} else if(attributeMappingSourceInterface instanceof GlobalAttributeImporter) {
				attributeValueRepresentation = extractValue((GlobalAttributeImporter) attributeMappingSourceInterface, matchedSectionDescriptor); 
			} else {
				consoleStream.println("Unsupported type of source element for an AttributeMapping found: '" + 
						attributeMappingSourceInterface.eClass().getName() + "'!");
			}
			
			if(attributeValueRepresentation != null) {					
				hintValue.put(attributeMappingSourceInterface, attributeValueRepresentation);
			}
		}
		
		return hintValue.isEmpty() ? null : hintValue;
	}
	
	/**
	 * This extracts and returns the hint value for the given {@link MappingHintBaseType mapping hint}.
	 * 
	 * @param attributeMatcher The {@link AttributeMatcher} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted hint value or '<em>null</em>' if nothing could be extracted.
	 */
	@SuppressWarnings("unchecked")
	private Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> extractHintValue(AttributeMatcher attributeMatcher, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		// This keeps track of the extracted hint value parts
		//
		Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> hintValue = new HashMap<>();
		
		// Extract the hint value part based on its type
		//
		for (AttributeMatcherSourceInterface attributeMatcherSourceInterface : attributeMatcher.getSourceAttributes()) {
			
			AttributeValueRepresentation attributeValueRepresentation = null;
			
			if(attributeMatcherSourceInterface instanceof ModifiedAttributeElementType<?, ?, ?, ?>) {
				attributeValueRepresentation = extractValue((ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) attributeMatcherSourceInterface, matchedSectionDescriptor);
			} else if(attributeMatcherSourceInterface instanceof FixedValue) {
				attributeValueRepresentation = extractValue((FixedValue) attributeMatcherSourceInterface, matchedSectionDescriptor); 
			} else if(attributeMatcherSourceInterface instanceof GlobalAttributeImporter) {
				attributeValueRepresentation = extractValue((GlobalAttributeImporter) attributeMatcherSourceInterface, matchedSectionDescriptor); 
			} else {
				consoleStream.println("Unsupported type of source element for an AttributeMatcher found: '" + 
						attributeMatcherSourceInterface.eClass().getName() + "'!");
			}
			
			if(attributeValueRepresentation != null) {					
				hintValue.put(attributeMatcherSourceInterface, attributeValueRepresentation);
			}
			
		}
		
		return hintValue.isEmpty() ? null : hintValue;
	}
	
	/**
	 * This extracts and returns the hint value for the given {@link ModelConnectionHint}.
	 * 
	 * @param modelConnectionHint The {@link ModelConnectionHint} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted hint value or '<em>null</em>' if nothing could be extracted.
	 */
	@SuppressWarnings("unchecked")
	private Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> extractHintValue(ModelConnectionHint modelConnectionHint, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		// This keeps track of the extracted hint value parts
		//
		Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> hintValue = new HashMap<>();
		
		// Extract the hint value part based on its type
		//
		for (ModelConnectionHintSourceInterface modelConnectionHintSourceInterface : modelConnectionHint.getSourceElements()) {
			
			AttributeValueRepresentation attributeValueRepresentation = null;
			
			if(modelConnectionHintSourceInterface instanceof ModifiedAttributeElementType<?, ?, ?, ?>) {
				attributeValueRepresentation = extractValue((ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) modelConnectionHintSourceInterface, matchedSectionDescriptor);
			} else if(modelConnectionHintSourceInterface instanceof FixedValue) {
				attributeValueRepresentation = extractValue((FixedValue) modelConnectionHintSourceInterface, matchedSectionDescriptor); 
			} else if(modelConnectionHintSourceInterface instanceof GlobalAttributeImporter) {
				attributeValueRepresentation = extractValue((GlobalAttributeImporter) modelConnectionHintSourceInterface, matchedSectionDescriptor); 
			} else {
				consoleStream.println("Unsupported type of source element for a ModelConnectionHint found: '" + 
						modelConnectionHintSourceInterface.eClass().getName() + "'!");
			}
			
			if(attributeValueRepresentation != null) {					
				hintValue.put(modelConnectionHintSourceInterface, attributeValueRepresentation);
			}
		}
		
		return hintValue.isEmpty() ? null : hintValue;
	}
	
	/**
	 * This extracts and returns the hint value for the given {@link CardinalityMapping}.
	 * 
	 * @param cardinalityMapping The {@link CardinalityMapping} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted hint value or '<em>null</em>' if nothing could be extracted.
	 */
	private Integer extractHintValue(CardinalityMapping cardinalityMapping, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		Set<EObject> sourceElements = matchedSectionDescriptor.getSourceModelObjectsMapped().get(cardinalityMapping.getSource());
		
		return sourceElements == null ? null : sourceElements.size();
		
	}
	
	/**
	 * This extracts and returns the hint value for the given {@link MappedAttributeValueExpander}.
	 * 
	 * @param mappedAttributeValueExpander The {@link MappedAttributeValueExpander} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted hint value or '<em>null</em>' if nothing could be extracted.
	 */
	@SuppressWarnings("unchecked")
	private String extractHintValue(MappedAttributeValueExpander mappedAttributeValueExpander, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		if(mappedAttributeValueExpander.getSourceAttribute().getAttribute().isMany()) {
			//FIXME Currently, we do not support many-valued attributes
			consoleStream.println("MappedAttributeValueExpanders based on multi-valued attributes are not yet supported!");
			return null;
		}
		
		// Extract the hint value
		//
		AttributeValueRepresentation attributeValueRepresentation = 
				extractValue((ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) mappedAttributeValueExpander, matchedSectionDescriptor);
		
		return attributeValueRepresentation == null ? null : attributeValueRepresentation.getNextValue();
	}

	/**
	 * For a given {@link MappingHintBaseType hint}, this {@link HintValueMap#init(EObject, boolean) initializes} the 
	 * {@link HintValueMap} in the given {@link MappingInstanceStorage}.
	 * 
	 * @param hint The {@link MappingHintBaseType} for that the map shall be initialized.
	 * @param mappingInstance The {@link MappingInstanceStorage} in that the hint value map shall be initialized.
	 */
	private void initializeHintValueMap(MappingHintBaseType hint, MappingInstanceStorage mappingInstance) {
		if (hint instanceof AttributeMapping) {
			mappingInstance.getHintValues().getAttributeMappingHintValues().init((AttributeMapping) hint, false);
		} else if (hint instanceof MappingInstanceSelector) {
			if (((MappingInstanceSelector) hint).getMatcher() instanceof AttributeMatcher) {
				mappingInstance.getHintValues().getMappingInstanceSelectorHintValues().init((MappingInstanceSelector) hint, false);
			}
		} else if (hint instanceof ModelConnectionHint) {
			mappingInstance.getHintValues().getModelConnectionHintValues().init((ModelConnectionHint) hint, false);
		}
	}

	/**
	 * This stores the given '<em>hintValue</em>' produced by the given {@link MappingHintBaseType} in the given {@link MappingInstanceStorage}.
	 * <p />
	 * Note: If the '<em>hintValue</em>' represents a 'complex', attribute-based hint (i.e. one that is composed of multiple source elements like
	 * e.g. an 'AttributeMapping), it is consolidated first. By 'consolidated', we mean that, if one or more of the
	 * source elements returned {@link AttributeValueRepresentation#isMany() multiple values}, multiple distinct hint values are created.  
	 * 
	 * @param hintValue The object representing the hint value. The type of this is dependent on the concrete {@link MappingHintBaseType}
	 * represented by the given '<em>hint</em>'.
	 * @param hint The {@link MappingHintBaseType hint} that produced the value. 
	 * @param mappingInstance The {@link MappingInstanceStorage} where the hint value shall be stored.
	 */
	@SuppressWarnings("unchecked")
	private void storeHintValueConsolidated(Object hintValue, MappingHintBaseType hint, MappingInstanceStorage mappingInstance) {
		
		/*
		 * If we deal with a 'complex' hint (one that is composed of multiple source elements) and one or more of the
		 * source elements returned multiple values, we need to 'consolidate' the hint values, i.e. create multiple
		 * distinct hint values.  
		 */
		if(hintValue instanceof Map<?, ?>) {
			HashMap<EObject, AttributeValueRepresentation> hintValueMap = (HashMap<EObject, AttributeValueRepresentation>) hintValue;
			
			int maxNumberOfValues = hintValueMap.values().parallelStream().mapToInt(v -> v.getValues().size()).max().getAsInt();
			
			for (AttributeValueRepresentation valueRepresentation : hintValueMap.values()) {
				if(maxNumberOfValues % valueRepresentation.getValues().size() > 0) {
					consoleStream.println("The source elements of the mapping hint '" + hint.getName() + "' produced an "
							+ "inconsistent number of hint values. They are thus skipped...");
					return;
				}
			}
	
			for (int i = 0; i < maxNumberOfValues; i++) {
				HashMap<EObject, AttributeValueRepresentation> newHintValueMap = (HashMap<EObject, AttributeValueRepresentation>) hintValueMap.clone();
				for (Entry<EObject, AttributeValueRepresentation> entry : hintValueMap.entrySet()) {
					newHintValueMap.put(entry.getKey(), new AttributeValueRepresentation(entry.getValue().getAttribute(), entry.getValue().getNextValue()));
				}
				mappingInstance.getHintValues().addHintValue(hint, newHintValueMap);
			}
			
		/*
		 * Otherwise, we can simply store the single hint value in the mapping instance.
		 */
		} else if(hintValue != null) {			
				mappingInstance.getHintValues().addHintValue(hint, hintValue);
		}
	}

}
