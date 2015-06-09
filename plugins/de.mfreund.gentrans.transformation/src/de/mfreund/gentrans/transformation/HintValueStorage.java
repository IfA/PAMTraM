package de.mfreund.gentrans.transformation;

import java.util.LinkedList;
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
import pamtram.metamodel.SourceSectionClass;
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
	 * This returns the list of stored values for the given hint.
	 * 
	 * @param hint The hint for which the stored values shall be returned. The concrete type of this needs to be one of 
	 * {@link AttributeMapping}, {@link CardinalityMapping}, {@link MappedAttributeValueExpander},
	 * {@link MappingInstanceSelector}, or {@link ModelConnectionHint}.
	 * @return The stored values for the given hint. The concrete return type is in line with the type of the <em>hint</em> according to
	 * the concrete implementation of the {@link HintValueMap} type.
	 */
	public Object getHintValues(EObject hint) {
		if(hint instanceof AttributeMapping) {
			return getHintValues((AttributeMapping) hint);
		} else if(hint instanceof CardinalityMapping) {
			return getHintValues((CardinalityMapping) hint);
		} else if(hint instanceof MappedAttributeValueExpander) {
			return getHintValues((MappedAttributeValueExpander) hint);
		} else if(hint instanceof MappingInstanceSelector) {
			return getHintValues((MappingInstanceSelector) hint);
		} else if(hint instanceof ModelConnectionHint) {
			return getHintValues((ModelConnectionHint) hint);
		} else {
			throw new RuntimeException("Unsupported MappingHint type: '" + hint.eClass().getName() + "'!");
		}
	}
	
	/**
	 * @return the {@link #attributeMappingHintValues}
	 */
	public AttributeMappingHintValueMap getAttributeMappingHintValues() {
		return attributeMappingHintValues;
	}
	
	/**
	 * This returns the list of stored values for the given hint.
	 * 
	 * @param hint The hint for which the stored values shall be returned.
	 * @return The stored values for the given hint.
	 */
	public LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> getHintValues(AttributeMapping hint) {
		return attributeMappingHintValues.getHintValues(hint);
	}

	/**
	 * @return the {@link #cardinalityMappingHintValues}
	 */
	public CardinalityMappingHintValueMap getCardinalityMappingHintValues() {
		return cardinalityMappingHintValues;
	}
	

	/**
	 * This returns the list of stored values for the given hint.
	 * 
	 * @param hint The hint for which the stored values shall be returned.
	 * @return The stored values for the given hint.
	 */
	public LinkedList<Integer> getHintValues(CardinalityMapping hint) {
		return cardinalityMappingHintValues.getHintValues(hint);
	}

	/**
	 * @return the {@link #mappedAttributeValueExpanderHintValues}
	 */
	public MappedAttributeValueExpanderHintValueMap getMappedAttributeValueExpanderHintValues() {
		return mappedAttributeValueExpanderHintValues;
	}

	/**
	 * This returns the list of stored values for the given hint.
	 * 
	 * @param hint The hint for which the stored values shall be returned.
	 * @return The stored values for the given hint.
	 */
	public LinkedList<String> getHintValues(MappedAttributeValueExpander hint) {
		return mappedAttributeValueExpanderHintValues.getHintValues(hint);
	}

	/**
	 * @return the {@link #mappingInstanceSelectorHintValues}
	 */
	public MappingInstanceSelectorHintValueMap getMappingInstanceSelectorHintValues() {
		return mappingInstanceSelectorHintValues;
	}

	/**
	 * This returns the list of stored values for the given hint.
	 * 
	 * @param hint The hint for which the stored values shall be returned.
	 * @return The stored values for the given hint.
	 */
	public LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>> getHintValues(MappingInstanceSelector hint) {
		return mappingInstanceSelectorHintValues.getHintValues(hint);
	}

	/**
	 * @return the {@link #modelConnectionHintValues}
	 */
	public ModelConnectionHintValueMap getModelConnectionHintValues() {
		return modelConnectionHintValues;
	}

	/**
	 * This returns the list of stored values for the given hint.
	 * 
	 * @param hint The hint for which the stored values shall be returned.
	 * @return The stored values for the given hint.
	 */
	public LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>> getHintValues(ModelConnectionHint hint) {
		return modelConnectionHintValues.getHintValues(hint);
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
	
	/**
	 * This adds a hint value to the storage.
	 * 
	 * @param hint The {@link AttributeMapping} for that the value shall be added.
	 * @param clazz The {@link SourceSectionClass} for that the value shall be added.
	 * @param value The value to be added.
	 */
	public void addHintValue(AttributeMapping hint, SourceSectionClass clazz, Map<AttributeMappingSourceInterface, AttributeValueRepresentation> value) {
		attributeMappingHintValues.addHintValue(hint, clazz, value);
	}
	
	/**
	 * This adds a hint value to the storage.
	 * 
	 * @param hint The {@link CardinalityMapping} for that the value shall be added.
	 * @param clazz The {@link SourceSectionClass} for that the value shall be added.
	 * @param value The value to be added.
	 */
	public void addHintValue(CardinalityMapping hint, SourceSectionClass clazz, Integer value) {
		cardinalityMappingHintValues.addHintValue(hint, clazz, value);
	}
	
	/**
	 * This adds a hint value to the storage.
	 * 
	 * @param hint The {@link MappedAttributeValueExpander} for that the value shall be added.
	 * @param clazz The {@link SourceSectionClass} for that the value shall be added.
	 * @param value The value to be added.
	 */
	public void addHintValue(MappedAttributeValueExpander hint, SourceSectionClass clazz, String value) {
		mappedAttributeValueExpanderHintValues.addHintValue(hint, clazz, value);
	}
	
	/**
	 * This adds a hint value to the storage.
	 * 
	 * @param hint The {@link MappingInstanceSelector} for that the value shall be added.
	 * @param clazz The {@link SourceSectionClass} for that the value shall be added.
	 * @param value The value to be added.
	 */
	public void addHintValue(MappingInstanceSelector hint, SourceSectionClass clazz, Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> value) {
		mappingInstanceSelectorHintValues.addHintValue(hint, clazz, value);
	}
	
	/**
	 * This adds a hint value to the storage.
	 * 
	 * @param hint The {@link ModelConnectionHint} for that the value shall be added.
	 * @param clazz The {@link SourceSectionClass} for that the value shall be added.
	 * @param value The value to be added.
	 */
	public void addHintValue(ModelConnectionHint hint, SourceSectionClass clazz, Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> value) {
		modelConnectionHintValues.addHintValue(hint, clazz, value);
	}
	
	/**
	 * This adds the hint values stored in another {@link HintValueStorage} to this storage.
	 * 
	 * @param hintValuesToAdd The {@link HintValueStorage} that contains the hint values to add.
	 */
	public void addHintValues(HintValueStorage hintValuesToAdd) {
		
		// copy the various maps
		this.getAttributeMappingHintValues().addHintValues(hintValuesToAdd.getAttributeMappingHintValues());
		this.getCardinalityMappingHintValues().addHintValues(hintValuesToAdd.getCardinalityMappingHintValues());
		this.getMappedAttributeValueExpanderHintValues().addHintValues(hintValuesToAdd.getMappedAttributeValueExpanderHintValues());
		this.getMappingInstanceSelectorHintValues().addHintValues(hintValuesToAdd.getMappingInstanceSelectorHintValues());
		this.getModelConnectionHintValues().addHintValues(hintValuesToAdd.getModelConnectionHintValues());
	}
	
	/**
	 * This adds a list of hint value to the storage.
	 * 
	 * @param hint The hint for that the value shall be added. The concrete type of this needs to be one of 
	 * {@link AttributeMapping}, {@link CardinalityMapping}, {@link MappedAttributeValueExpander},
	 * {@link MappingInstanceSelector}, or {@link ModelConnectionHint}.
	 * @param value The values to be added. The concrete type needs to be in line with the type of the <em>hint</em> according to
	 * the concrete implementation of the {@link HintValueMap} type.
	 * @throws ClassCastException if the concrete type of the <em>value</em> is not in line with the type of the <em>hint</em>.
	 */
	@SuppressWarnings("unchecked")
	public void addHintValues(EObject hint, Object values) throws ClassCastException {
		if(hint instanceof AttributeMapping) {
			addHintValues((AttributeMapping) hint, (LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>>) values);
		} else if(hint instanceof CardinalityMapping) {
			addHintValues((CardinalityMapping) hint, (LinkedList<Integer>) values);
		} else if(hint instanceof MappedAttributeValueExpander) {
			addHintValues((MappedAttributeValueExpander) hint, (LinkedList<String>) values);
		} else if(hint instanceof MappingInstanceSelector) {
			addHintValues((MappingInstanceSelector) hint, (LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>>) values);
		} else if(hint instanceof ModelConnectionHint) {
			addHintValues((ModelConnectionHint) hint, (LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>>) values);
		} else {
			throw new RuntimeException("Unsupported MappingHint type: '" + hint.eClass().getName() + "'!");
		}
	}
	
	/**
	 * This adds a list of hint value to the storage.
	 * 
	 * @param hint The {@link AttributeMapping} for that the value shall be added.
	 * @param values The values to be added.
	 */
	public void addHintValues(AttributeMapping hint, LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> values) {
		attributeMappingHintValues.addHintValues(hint, values);
	}
	
	/**
	 * This adds a list of hint value to the storage.
	 * 
	 * @param hint The {@link CardinalityMapping} for that the value shall be added.
	 * @param values The values to be added.
	 */
	public void addHintValues(CardinalityMapping hint, LinkedList<Integer> values) {
		cardinalityMappingHintValues.addHintValues(hint, values);
	}
	
	/**
	 * This adds a list of hint value to the storage.
	 * 
	 * @param hint The {@link MappedAttributeValueExpander} for that the value shall be added.
	 * @param values The values to be added.
	 */
	public void addHintValues(MappedAttributeValueExpander hint, LinkedList<String> values) {
		mappedAttributeValueExpanderHintValues.addHintValues(hint, values);
	}
	
	/**
	 * This adds a list of hint value to the storage.
	 * 
	 * @param hint The {@link MappingInstanceSelector} for that the value shall be added.
	 * @param values The values to be added.
	 */
	public void addHintValues(MappingInstanceSelector hint, LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>> values) {
		mappingInstanceSelectorHintValues.addHintValues(hint, values);
	}
	
	/**
	 * This adds a list of hint value to the storage.
	 * 
	 * @param hint The {@link ModelConnectionHint} for that the value shall be added.
	 * @param values The values to be added.
	 */
	public void addHintValues(ModelConnectionHint hint, LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>> values) {
		modelConnectionHintValues.addHintValues(hint, values);
	}
	
	/**
	 * This sets the list of stored hint values for the given hint.
	 * 
	 * @param hint The hint for that the value shall be set. The concrete type of this needs to be one of 
	 * {@link AttributeMapping}, {@link CardinalityMapping}, {@link MappedAttributeValueExpander},
	 * {@link MappingInstanceSelector}, or {@link ModelConnectionHint}.
	 * @param value The values to be set. The concrete type needs to be in line with the type of the <em>hint</em> according to
	 * the concrete implementation of the {@link HintValueMap} type.
	 * @throws ClassCastException if the concrete type of the <em>value</em> is not in line with the type of the <em>hint</em>.
	 */
	@SuppressWarnings("unchecked")
	public void setHintValues(EObject hint, Object values) throws ClassCastException {
		if(hint instanceof AttributeMapping) {
			setHintValues((AttributeMapping) hint, (LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>>) values);
		} else if(hint instanceof CardinalityMapping) {
			setHintValues((CardinalityMapping) hint, (LinkedList<Integer>) values);
		} else if(hint instanceof MappedAttributeValueExpander) {
			setHintValues((MappedAttributeValueExpander) hint, (LinkedList<String>) values);
		} else if(hint instanceof MappingInstanceSelector) {
			setHintValues((MappingInstanceSelector) hint, (LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>>) values);
		} else if(hint instanceof ModelConnectionHint) {
			setHintValues((ModelConnectionHint) hint, (LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>>) values);
		} else {
			throw new RuntimeException("Unsupported MappingHint type: '" + hint.eClass().getName() + "'!");
		}
	}
	
	/**
	 * This sets the list of stored hint values for the given hint.
	 * 
	 * @param hint The {@link AttributeMapping} for that the values shall be set.
	 * @param values The values to be set.
	 */
	public void setHintValues(AttributeMapping hint, LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> values) {
		attributeMappingHintValues.setHintValues(hint, values);
	}
	
	/**
	 * This sets the list of stored hint values for the given hint.
	 * 
	 * @param hint The {@link CardinalityMapping} for that the values shall be set.
	 * @param values The values to be set.
	 */
	public void setHintValues(CardinalityMapping hint, LinkedList<Integer> values) {
		cardinalityMappingHintValues.setHintValues(hint, values);
	}
	
	/**
	 * This sets the list of stored hint values for the given hint.
	 * 
	 * @param hint The {@link MappedAttributeValueExpander} for that the values shall be set.
	 * @param values The values to be set.
	 */
	public void setHintValues(MappedAttributeValueExpander hint, LinkedList<String> values) {
		mappedAttributeValueExpanderHintValues.setHintValues(hint, values);
	}
	
	/**
	 * This sets the list of stored hint values for the given hint.
	 * 
	 * @param hint The {@link MappingInstanceSelector} for that the values shall be set.
	 * @param values The values to be set.
	 */
	public void setHintValues(MappingInstanceSelector hint, LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>> values) {
		mappingInstanceSelectorHintValues.setHintValues(hint, values);
	}
	
	/**
	 * This sets the list of stored hint values for the given hint.
	 * 
	 * @param hint The {@link ModelConnectionHint} for that the values shall be set.
	 * @param values The values to be set.
	 */
	public void setHintValues(ModelConnectionHint hint, LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>> values) {
		modelConnectionHintValues.setHintValues(hint, values);
	}
	
	/**
	 * This sets the list of stored hint values for the given hint and a given {@link SourceSectionClass}.
	 * 
	 * @param hint The {@link AttributeMapping} for that the values shall be set.
	 * @param clazz The {@link SourceSectionClass} for that the values shall be set.
	 * @param values The values to be set.
	 */
	public void setHintValues(AttributeMapping hint, SourceSectionClass clazz, LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> values) {
		attributeMappingHintValues.setHintValues(hint, clazz, values);
	}
	
	/**
	 * This sets the list of stored hint values for the given hint and a given {@link SourceSectionClass}.
	 * 
	 * @param hint The {@link CardinalityMapping} for that the values shall be set.
	 * @param clazz The {@link SourceSectionClass} for that the values shall be set.
	 * @param values The values to be set.
	 */
	public void setHintValues(CardinalityMapping hint, SourceSectionClass clazz, LinkedList<Integer> values) {
		cardinalityMappingHintValues.setHintValues(hint, clazz, values);
	}
	
	/**
	 * This sets the list of stored hint values for the given hint and a given {@link SourceSectionClass}.
	 * 
	 * @param hint The {@link MappedAttributeValueExpander} for that the values shall be set.
	 * @param clazz The {@link SourceSectionClass} for that the values shall be set.
	 * @param values The values to be set.
	 */
	public void setHintValues(MappedAttributeValueExpander hint, SourceSectionClass clazz, LinkedList<String> values) {
		mappedAttributeValueExpanderHintValues.setHintValues(hint, clazz, values);
	}
	
	/**
	 * This sets the list of stored hint values for the given hint and a given {@link SourceSectionClass}.
	 * 
	 * @param hint The {@link MappingInstanceSelector} for that the values shall be set.
	 * @param clazz The {@link SourceSectionClass} for that the values shall be set.
	 * @param values The values to be set.
	 */
	public void setHintValues(MappingInstanceSelector hint, SourceSectionClass clazz, LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>> values) {
		mappingInstanceSelectorHintValues.setHintValues(hint, clazz, values);
	}
	
	/**
	 * This sets the list of stored hint values for the given hint and a given {@link SourceSectionClass}.
	 * 
	 * @param hint The {@link ModelConnectionHint} for that the values shall be set.
	 * @param clazz The {@link SourceSectionClass} for that the values shall be set.
	 * @param values The values to be set.
	 */
	public void setHintValues(ModelConnectionHint hint, SourceSectionClass clazz, LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>> values) {
		modelConnectionHintValues.setHintValues(hint, clazz, values);
	}
	
	/**
	 * This retrieves and removes the hint values stored for a given hint
	 * 
	 * @param hint The hint for which the hint values shall be retrieved and removed.  The concrete type of this needs to be one of 
	 * {@link AttributeMapping}, {@link CardinalityMapping}, {@link MappedAttributeValueExpander},
	 * {@link MappingInstanceSelector}, or {@link ModelConnectionHint}.
	 * @return The removed hint values. The concrete type is in line with the type of the <em>hint</em> according to
	 * the concrete implementation of the {@link HintValueMap} type.
	 */
	public Object removeHint(EObject hint) {
		
		if(hint instanceof AttributeMapping) {
			return getAttributeMappingHintValues().remove(hint).get(null);
		} else if(hint instanceof CardinalityMapping) {
			return getCardinalityMappingHintValues().remove(hint).get(null);
		} else if(hint instanceof MappedAttributeValueExpander) {
			return getMappedAttributeValueExpanderHintValues().remove(hint).get(null);
		} else if(hint instanceof MappingInstanceSelector) {
			return getMappingInstanceSelectorHintValues().remove(hint).get(null);
		} else if(hint instanceof ModelConnectionHint) {
			return getModelConnectionHintValues().remove(hint).get(null);
		} else {
			throw new RuntimeException("Unsupported MappingHint type: '" + hint.eClass().getName() + "'!");
		}
	}
	
	/**
	 *This retrieves and removes the first hint value stored for a given hint.
	 * 
	 * @param hint The hint for which the first hint value shall be retrieved and removed.
	 * @return The removed hint value.
	 */
	public Map<AttributeMappingSourceInterface, AttributeValueRepresentation> removeHintValue(AttributeMapping hint) {
		return attributeMappingHintValues.removeHintValue(hint);
	}
	
	/**
	 *This retrieves and removes the first hint value stored for a given hint.
	 * 
	 * @param hint The hint for which the first hint value shall be retrieved and removed.
	 * @return The removed hint value.
	 */
	public Integer removeHintValue(CardinalityMapping hint) {
		return cardinalityMappingHintValues.removeHintValue(hint);
	}
	
	/**
	 *This retrieves and removes the first hint value stored for a given hint.
	 * 
	 * @param hint The hint for which the first hint value shall be retrieved and removed.
	 * @return The removed hint value.
	 */
	public String removeHintValue(MappedAttributeValueExpander hint) {
		return mappedAttributeValueExpanderHintValues.removeHintValue(hint);
	}
	
	/**
	 *This retrieves and removes the first hint value stored for a given hint.
	 * 
	 * @param hint The hint for which the first hint value shall be retrieved and removed.
	 * @return The removed hint value.
	 */
	public Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> removeHintValue(MappingInstanceSelector hint) {
		return mappingInstanceSelectorHintValues.removeHintValue(hint);
	}
	
	/**
	 *This retrieves and removes the first hint value stored for a given hint.
	 * 
	 * @param hint The hint for which the first hint value shall be retrieved and removed.
	 * @return The removed hint value.
	 */
	public Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> removeHintValue(ModelConnectionHint hint) {
		return modelConnectionHintValues.removeHintValue(hint);
	}
	
	/**
	 * This checks whether hint values are stored for the given hint.
	 * 
	 * @param hint The hint that shall be checked. The concrete type of this needs to be one of 
	 * {@link AttributeMapping}, {@link CardinalityMapping}, {@link MappedAttributeValueExpander},
	 * {@link MappingInstanceSelector}, or {@link ModelConnectionHint}.
	 * @throws ClassCastException if the concrete type of the <em>value</em> is not in line with the type of the <em>hint</em>.
	 */
	public boolean containsHint(EObject hint) throws ClassCastException {
		if(hint instanceof AttributeMapping) {
			return getAttributeMappingHintValues().containsKey(hint);
		} else if(hint instanceof CardinalityMapping) {
			return getCardinalityMappingHintValues().containsKey(hint);
		} else if(hint instanceof MappedAttributeValueExpander) {
			return getMappedAttributeValueExpanderHintValues().containsKey(hint);
		} else if(hint instanceof MappingInstanceSelector) {
			return getMappingInstanceSelectorHintValues().containsKey(hint);
		} else if(hint instanceof ModelConnectionHint) {
			return getModelConnectionHintValues().containsKey(hint);
		} else {
			throw new RuntimeException("Unsupported MappingHint type: '" + hint.eClass().getName() + "'!");
		}
	}
}
