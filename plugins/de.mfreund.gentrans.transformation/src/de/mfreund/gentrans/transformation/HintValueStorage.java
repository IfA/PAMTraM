package de.mfreund.gentrans.transformation;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.ModelConnectionHintSourceInterface;
import de.mfreund.gentrans.transformation.maps.AttributeMappingHintValueMap;
import de.mfreund.gentrans.transformation.maps.CardinalityMappingHintValueMap;
import de.mfreund.gentrans.transformation.maps.HintValueMap;
import de.mfreund.gentrans.transformation.maps.MappedAttributeValueExpanderHintValueMap;
import de.mfreund.gentrans.transformation.maps.MappingInstanceSelectorHintValueMap;
import de.mfreund.gentrans.transformation.maps.ModelConnectionHintValueMap;

/**
 * This class is used to store mapping hint values. It stores the hint values separated by their type
 * in various {@link HintValueMap HintValueMaps} and provides a common interface to them.
 * 
 * @author mfreund
 */
public class HintValueStorage {

	/**
	 * This keeps track of hint values for {@link AttributeMapping AttributeMappings}.
	 */
	private final AttributeMappingHintValueMap attributeMappingHintValues;
	
	/**
	 * This keeps track of hint values for {@link CardinalityMapping CardinalityMappings}.
	 */
	private final CardinalityMappingHintValueMap cardinalityMappingHintValues;
	
	/**
	 * This keeps track of hint values for {@link MappedAttributeValueExpander MappedAttributeValueExpanders}.
	 */
	private final MappedAttributeValueExpanderHintValueMap mappedAttributeValueExpanderHintValues;
	
	/**
	 * This keeps track of hint values for {@link MappingInstanceSelector MappingInstanceSelectors}.
	 */
	private final MappingInstanceSelectorHintValueMap mappingInstanceSelectorHintValues;
	
	/**
	 * This keeps track of hint values for {@link ModelConnectionHint ModelConnectionHints}.
	 */
	private final ModelConnectionHintValueMap modelConnectionHintValues;
	
	/**
	 * This constructs an instance and initializes the various maps to store hint values.
	 */
	public HintValueStorage() {
		
		attributeMappingHintValues = new AttributeMappingHintValueMap();
		cardinalityMappingHintValues = new CardinalityMappingHintValueMap();
		mappedAttributeValueExpanderHintValues = new MappedAttributeValueExpanderHintValueMap();
		mappingInstanceSelectorHintValues = new MappingInstanceSelectorHintValueMap();
		modelConnectionHintValues = new ModelConnectionHintValueMap();
	}
	
	/**
	 * This adds a hint value to the storage.
	 * 
	 * @param hint The hint for that the value shall be added. The concrete type of this needs to be one of 
	 * {@link AttributeMapping}, {@link CardinalityMapping}, {@link MappedAttributeValueExpander},
	 * {@link MappingInstanceSelector}, or {@link ModelConnectionHint}.
	 * @param value The value to be added. The concrete type needs to be in line with the type of the <em>hint</em> according to
	 * the concrete implementation of the {@link HintValueMap} type.
	 * @throws ClassCastException if the concrete type of the <em>value</em> is not in line with the type of the <em>hint</em>.
	 */
	@SuppressWarnings("unchecked")
	public void addHintValue(EObject hint, Object value) throws ClassCastException {
		if(hint instanceof AttributeMapping) {
			addHintValue((AttributeMapping) hint, (Map<AttributeMappingSourceInterface, AttributeValueRepresentation>) value);
		} else if(hint instanceof CardinalityMapping) {
			addHintValue((CardinalityMapping) hint, (Integer) value);
		} else if(hint instanceof MappedAttributeValueExpander) {
			addHintValue((MappedAttributeValueExpander) hint, (String) value);
		} else if(hint instanceof MappingInstanceSelector) {
			addHintValue((MappingInstanceSelector) hint, (Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>) value);
		} else if(hint instanceof ModelConnectionHint) {
			addHintValue((ModelConnectionHint) hint, (Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>) value);
		} else {
			throw new RuntimeException("Unsupported MappingHint type: '" + hint.eClass().getName() + "'!");
		}
	}
	
	/**
	 * This adds a hint value to the storage.
	 * 
	 * @param hint The {@link AttributeMapping} for that the value shall be added.
	 * @param value The value to be added.
	 */
	public void addHintValue(AttributeMapping hint, Map<AttributeMappingSourceInterface, AttributeValueRepresentation> value) {
		attributeMappingHintValues.addHintValue(hint, value);
	}
	
	/**
	 * This adds a hint value to the storage.
	 * 
	 * @param hint The {@link CardinalityMapping} for that the value shall be added.
	 * @param value The value to be added.
	 */
	public void addHintValue(CardinalityMapping hint, Integer value) {
		cardinalityMappingHintValues.addHintValue(hint, value);
	}
	
	/**
	 * This adds a hint value to the storage.
	 * 
	 * @param hint The {@link MappedAttributeValueExpander} for that the value shall be added.
	 * @param value The value to be added.
	 */
	public void addHintValue(MappedAttributeValueExpander hint, String value) {
		mappedAttributeValueExpanderHintValues.addHintValue(hint, value);
	}
	
	/**
	 * This adds a hint value to the storage.
	 * 
	 * @param hint The {@link MappingInstanceSelector} for that the value shall be added.
	 * @param value The value to be added.
	 */
	public void addHintValue(MappingInstanceSelector hint, Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> value) {
		mappingInstanceSelectorHintValues.addHintValue(hint, value);
	}
	
	/**
	 * This adds a hint value to the storage.
	 * 
	 * @param hint The {@link ModelConnectionHint} for that the value shall be added.
	 * @param value The value to be added.
	 */
	public void addHintValue(ModelConnectionHint hint, Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> value) {
		modelConnectionHintValues.addHintValue(hint, value);
	}
	
}
