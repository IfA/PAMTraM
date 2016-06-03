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
import pamtram.mapping.AttributeMappingSourceElement;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.MappingHintBaseType;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.ModelConnectionHint;

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
	}

	/**
	 * This extracts the hint values and stores them in the {@link #mappingInstances}.
	 */
	public void extractHintValues() {

		mappingInstances.parallelStream().forEach(this::extractHintValues);
	}

	/**
	 * This extracts the hint values for the given {@link MappingInstanceStorage}.
	 * <p />
	 * Note: The extracted hint values are stored in the <em>mappingInstance</em>.
	 * 
	 * @param mappingInstance The {@link MappingInstanceStorage} for that the hint values shall be extracted.
	 */
	private void extractHintValues(MappingInstanceStorage mappingInstance) {
		
		// First, we need to calculate exported hint values
		//
		//TODO how do we do that; resp. how do we connect them to the importers???
//		for (MappingHintGroupImporter mappingInstanceStorage : mappingInstance.getMappingHintGroupImporters()) {
//			
//		}
		
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
	 * This extracts the hint values for the given {@link MappingHintBaseType mapping hint}.
	 * <p />
	 * Note: The extracted hint values are stored in the <em>mappingInstance</em>.
	 * 
	 * @param hint The {@link MappingHintBaseType} for that the hint values shall be extracted.
	 * @param mappingInstance The {@link MappingInstanceStorage} for that the hint values shall be extracted.
	 */
	private void extractHintValue(MappingHintBaseType hint, MappingInstanceStorage mappingInstance) {
		
		if(hint instanceof AttributeMapping) {
			
			AttributeMapping attributeMapping = (AttributeMapping) hint;
			
			// This is where we will store all extracted hint values
			//
			Map<AttributeMappingSourceElement, AttributeValueRepresentation> hintValues = new HashMap<>();
			
			for (AttributeMappingSourceElement localSourceElement : attributeMapping.getLocalSourceElements()) {
				Set<EObject> sourceElements = mappingInstance.getSourceModelObjectsMapped().get(localSourceElement.getSourceAttribute().eContainer());
				
				for (EObject sourceElement : sourceElements) {
					
					EAttribute sourceAttribute = localSourceElement.getSourceAttribute().getAttribute();
					
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
								.applyAttributeValueModifiers(srcAttrAsString, localSourceElement.getModifier());
						
						// create a new AttributeValueRepresentation or update the existing one
						if(hintValues.get(localSourceElement) == null) {
							hintValues.put(localSourceElement, new AttributeValueRepresentation(localSourceElement.getSource(), valCopy));
						} else {
							hintValues.get(localSourceElement).addValue(valCopy);
						}
					}
				}
			}
			for (AttributeMappingExternalSourceElement externalSourceElement : attributeMapping.getExternalSourceElements()) {
				System.out.println(externalSourceElement);
			}
		}
	}

}
