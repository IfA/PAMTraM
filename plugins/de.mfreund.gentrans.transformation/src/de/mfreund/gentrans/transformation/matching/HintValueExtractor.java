package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.util.CancellableElement;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingExternalSourceElement;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.ExternalModifiedAttributeElementType;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.MappedAttributeValueExpander;
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
 * This class can be used to extract hint values from the source elements.
 * 
 * @author mfreund
 */
public class HintValueExtractor extends CancellableElement {

	/**
	 * The list of {@link MappingInstanceStorage MappingInstanceStorages}
	 * for that the hint values shall be extracted.
	 */
	private List<MappingInstanceStorage> mappingInstances;
	
	/**
	 * The {@link AttributeValueModifierExecutor} that shall be used for modifying attribute values.
	 */
	private final AttributeValueModifierExecutor attributeValueModifierExecutor;
	
	/**
	 * The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	private final MessageConsoleStream consoleStream;
	
	private Map<ExportedMappingHintGroup, MappingInstanceStorage> exportedHintGroups;
	
	/**
	 * This creates an instance for a given list of {@link MappingInstanceStorage mappingInstances}.
	 * <p />
	 * Note: The extracted hint values are stored in the given <em>mappingInstances</em>. 
	 * 
	 * @param mappingInstances The list of {@link MappingInstanceStorage MappingInstanceStorages}
	 * for that the hint values shall be extracted.
	 * @param attributeValueModifierExecutor The {@link AttributeValueModifierExecutor} that shall be used for modifying attribute values.
	 * @param consoleStream The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	public HintValueExtractor(List<MappingInstanceStorage> mappingInstances, 
			AttributeValueModifierExecutor attributeValueModifierExecutor, MessageConsoleStream consoleStream) {
		this.mappingInstances = mappingInstances;
		this.attributeValueModifierExecutor = attributeValueModifierExecutor;
		this.consoleStream = consoleStream;
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
		
		// Now, can we extract the hint values for each hint
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
		
		// TODO
		for (MappingHintGroupImporter hintGroupImporter : mappingInstance.getMappingHintGroupImporters()) {
			
			MappingInstanceStorage exported = exportedHintGroups.get(hintGroupImporter.getHintGroup());
			System.out.println(exported);
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
		
		Object hintValue = null;
		
		if(hint instanceof AttributeMapping) {
			
			hintValue = extractHintValue((AttributeMapping) hint, mappingInstance);
			
		} else if(hint instanceof MappingInstanceSelector) {
			
			if(((MappingInstanceSelector) hint).getMatcher() instanceof AttributeMatcher) {
			
				hintValue = extractHintValue((AttributeMatcher) ((MappingInstanceSelector) hint).getMatcher(), mappingInstance);
			}
		
		} else if(hint instanceof ModelConnectionHint) {
			
			hintValue = extractHintValue((ModelConnectionHint) hint, mappingInstance);
			
		} else if(hint instanceof CardinalityMapping) {
			
			hintValue = extractHintValue((CardinalityMapping) hint, mappingInstance);
			
		} else if(hint instanceof MappedAttributeValueExpander) {
			
			//TODO
			hintValue = null;
			
		} else {
			
			consoleStream.println("Unsupported type of MappingHint found: '" + hint.eClass().getName() + "'!");
		}
		
		// Store the hint value in the mappingInstance
		//
		mappingInstance.getHintValues().addHintValue(hint, hintValue);
	}

	/**
	 * This extracts and returns the hint value for the given {@link AttributeMapping}.
	 * 
	 * @param attributeMapping The {@link AttributeMapping} for that the hint values shall be extracted.
	 * @param mappingInstance The {@link MappingInstanceStorage} for that the hint values shall be extracted.
	 * @return The extracted hint value.
	 */
	@SuppressWarnings("unchecked")
	private Map<AttributeMappingSourceInterface, AttributeValueRepresentation> extractHintValue(AttributeMapping attributeMapping, MappingInstanceStorage mappingInstance) {
		
		// This keeps track of the extracted hint value parts
		//
		Map<AttributeMappingSourceInterface, AttributeValueRepresentation> hintValue = new HashMap<>();
		
		// Extract the hint value part based on its type
		//
		for (AttributeMappingSourceInterface attributeMappingSourceInterface : attributeMapping.getSourceAttributeMappings()) {
			
			AttributeValueRepresentation attributeValueRepresentation = null;
			
			if(attributeMappingSourceInterface instanceof ModifiedAttributeElementType<?, ?, ?, ?>) {
				attributeValueRepresentation = extractHintValue((ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) attributeMappingSourceInterface, mappingInstance);
			} else if(attributeMappingSourceInterface instanceof FixedValue) {
				attributeValueRepresentation = extractHintValue((FixedValue) attributeMappingSourceInterface, mappingInstance); 
			} else if(attributeMappingSourceInterface instanceof GlobalAttributeImporter) {
				attributeValueRepresentation = extractHintValue((GlobalAttributeImporter) attributeMappingSourceInterface, mappingInstance); 
			} else {
				consoleStream.println("Unsupported type of source element for an AttributeMapping found: '" + attributeMappingSourceInterface.eClass().getName() + "'!");
			}
			
			if(attributeValueRepresentation != null) {					
				hintValue.put(attributeMappingSourceInterface, attributeValueRepresentation);
			}
		}
		
		return hintValue;
	}
	
	/**
	 * This extracts and returns the hint value for the given {@link MappingHintBaseType mapping hint}.
	 * 
	 * @param attributeMatcher The {@link AttributeMatcher} for that the hint values shall be extracted.
	 * @param mappingInstance The {@link MappingInstanceStorage} for that the hint values shall be extracted.
	 * @return The extracted hint value.
	 */
	@SuppressWarnings("unchecked")
	private Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> extractHintValue(AttributeMatcher attributeMatcher, MappingInstanceStorage mappingInstance) {
		
		// This keeps track of the extracted hint value parts
		//
		Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> hintValue = new HashMap<>();
		
		// Extract the hint value part based on its type
		//
		for (AttributeMatcherSourceInterface attributeMatcherSourceInterface : attributeMatcher.getSourceAttributes()) {
			
			AttributeValueRepresentation attributeValueRepresentation = null;
			
			if(attributeMatcherSourceInterface instanceof ModifiedAttributeElementType<?, ?, ?, ?>) {
				attributeValueRepresentation = extractHintValue((ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) attributeMatcherSourceInterface, mappingInstance);
			} else if(attributeMatcherSourceInterface instanceof FixedValue) {
				attributeValueRepresentation = extractHintValue((FixedValue) attributeMatcherSourceInterface, mappingInstance); 
			} else if(attributeMatcherSourceInterface instanceof GlobalAttributeImporter) {
				attributeValueRepresentation = extractHintValue((GlobalAttributeImporter) attributeMatcherSourceInterface, mappingInstance); 
			} else {
				consoleStream.println("Unsupported type of source element for an AttributeMapping found: '" + attributeMatcherSourceInterface.eClass().getName() + "'!");
			}
			
			if(attributeValueRepresentation != null) {					
				hintValue.put(attributeMatcherSourceInterface, attributeValueRepresentation);
			}
			
		}
		
		return hintValue;
	}
	
	/**
	 * This extracts and returns the hint value for the given {@link ModelConnectionHint}.
	 * 
	 * @param modelConnectionHint The {@link ModelConnectionHint} for that the hint values shall be extracted.
	 * @param mappingInstance The {@link MappingInstanceStorage} for that the hint values shall be extracted.
	 * @return The extracted hint value.
	 */
	@SuppressWarnings("unchecked")
	private Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> extractHintValue(ModelConnectionHint modelConnectionHint, MappingInstanceStorage mappingInstance) {
		
		// This keeps track of the extracted hint value parts
		//
		Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> hintValue = new HashMap<>();
		
		// Extract the hint value part based on its type
		//
		for (ModelConnectionHintSourceInterface modelConnectionHintSourceInterface : modelConnectionHint.getSourceElements()) {
			
			AttributeValueRepresentation attributeValueRepresentation = null;
			
			if(modelConnectionHintSourceInterface instanceof ModifiedAttributeElementType<?, ?, ?, ?>) {
				attributeValueRepresentation = extractHintValue((ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) modelConnectionHintSourceInterface, mappingInstance);
			} else if(modelConnectionHintSourceInterface instanceof FixedValue) {
				attributeValueRepresentation = extractHintValue((FixedValue) modelConnectionHintSourceInterface, mappingInstance); 
			} else if(modelConnectionHintSourceInterface instanceof GlobalAttributeImporter) {
				attributeValueRepresentation = extractHintValue((GlobalAttributeImporter) modelConnectionHintSourceInterface, mappingInstance); 
			} else {
				consoleStream.println("Unsupported type of source element for an AttributeMapping found: '" + modelConnectionHintSourceInterface.eClass().getName() + "'!");
			}
			
			if(attributeValueRepresentation != null) {					
				hintValue.put(modelConnectionHintSourceInterface, attributeValueRepresentation);
			}
		}
		
		return hintValue;
	}
	
	/**
	 * This extracts and returns the hint value for the given {@link CardinalityMapping}.
	 * 
	 * @param cardinalityMapping The {@link CardinalityMapping} for that the hint values shall be extracted.
	 * @param mappingInstance The {@link MappingInstanceStorage} for that the hint values shall be extracted.
	 * @return The extracted hint value.
	 */
	private Integer extractHintValue(CardinalityMapping cardinalityMapping, MappingInstanceStorage mappingInstance) {
		
		Set<EObject> sourceElements = mappingInstance.getSourceModelObjectsMapped().get(cardinalityMapping.getSource());
		
		return sourceElements == null ? null : sourceElements.size();
		
	}
	
	/**
	 * This extracts and returns the hint value for the given {@link FixedValue} from the source elements represented
	 * by the given <em>mappingInstance</em>.
	 * 
	 * @param fixedValue The {@link FixedValue} for that the hint values shall be extracted.
	 * @param mappingInstance The {@link MappingInstanceStorage} representing the source model elements from that values shall be extracted.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could be extracted.
	 */
	private AttributeValueRepresentation extractHintValue(FixedValue fixedValue,
			MappingInstanceStorage mappingInstance) {
		
		//TODO two different FixedValues are currently not supported (both get added to the 'null' attribute
		return new AttributeValueRepresentation(null, fixedValue.getValue()); 
	}
	
	/**
	 * This extracts and returns the hint value for the given {@link GlobalAttributeImporter} from the source elements represented
	 * by the given <em>mappingInstance</em>.
	 * 
	 * @param globaleAttributeImporter The {@link GlobalAttributeImporter} for that the hint values shall be extracted.
	 * @param mappingInstance The {@link MappingInstanceStorage} representing the source model elements from that values shall be extracted.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could be extracted.
	 */
	private AttributeValueRepresentation extractHintValue(GlobalAttributeImporter globaleAttributeImporter,
			MappingInstanceStorage mappingInstance) {
		
		//TODO 
		return null;
	}

	/**
	 * This extracts and returns the hint value for the given {@link ModifiedAttributeElementType} from the source elements represented
	 * by the given <em>mappingInstance</em>.
	 * 
	 * @param mappingHintSourceElement The {@link ModifiedAttributeElementType} for that the hint values shall be extracted.
	 * @param mappingInstance The {@link MappingInstanceStorage} representing the source model elements from that values shall be extracted.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could be extracted.
	 */
	private AttributeValueRepresentation extractHintValue(
			ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> mappingHintSourceElement,
			MappingInstanceStorage mappingInstance) {
		
		AttributeValueRepresentation hintValue = null;
		
		MatchedSectionDescriptor sourceDescriptor = mappingInstance.getMatchedSectionDescriptor();
		
		// In case we are dealing with an external source element, we first need to determine the correct
		// 'container descriptor' that represents the source element
		//
		if(mappingHintSourceElement instanceof ExternalModifiedAttributeElementType<?,?,?,?>) {
			do {
				sourceDescriptor = sourceDescriptor.getContainerDescriptor();
				if(sourceDescriptor == null) {
					// Error: could not determine hint value
					return null;
				}
			} while (!sourceDescriptor.getSourceModelObjectsMapped().containsKey(mappingHintSourceElement.getSource().eContainer()));
		}
		
		Set<EObject> sourceElements = sourceDescriptor.getSourceModelObjectsMapped().get(mappingHintSourceElement.getSource().eContainer());
		
		for (EObject sourceElement : sourceElements) {
			
			EAttribute sourceAttribute = mappingHintSourceElement.getSource().getAttribute();
			
			/*
			 * As attributes may have a cardinality greater than 1, too, we have to handle
			 * every attribute value separately.
			 */
			ArrayList<Object> srcAttrValues = new ArrayList<>();
			if(sourceAttribute.isMany()) {
				srcAttrValues.addAll((Collection<?>) sourceElement.eGet(sourceAttribute));
			} else {
				srcAttrValues.add(sourceElement.eGet(sourceAttribute));
			}
			
			for (Object srcAttrValue : srcAttrValues) {
				
				// convert Attribute value to String
				final String srcAttrAsString = sourceAttribute.getEType().getEPackage().getEFactoryInstance()
						.convertToString(sourceAttribute.getEAttributeType(), srcAttrValue);
				
				final String valCopy = attributeValueModifierExecutor
						.applyAttributeValueModifiers(srcAttrAsString, mappingHintSourceElement.getModifier());
				
				// create a new AttributeValueRepresentation or update the existing one
				if(hintValue == null) {
					hintValue = new AttributeValueRepresentation(mappingHintSourceElement.getSource(), valCopy);
				} else {
					hintValue.addValue(valCopy);
				}
			}
		}
		
		return hintValue;
	}

}
