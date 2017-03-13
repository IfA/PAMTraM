package de.mfreund.gentrans.transformation.descriptors;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.maps.AttributeMappingHintValueMap;
import de.mfreund.gentrans.transformation.maps.CardinalityMappingHintValueMap;
import de.mfreund.gentrans.transformation.maps.ContainerSelectorHintValueMap;
import de.mfreund.gentrans.transformation.maps.HintValueMap;
import de.mfreund.gentrans.transformation.maps.MappingInstanceSelectorHintValueMap;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.CardinalityMappingSourceInterface;
import pamtram.mapping.ContainerSelector;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.ReferenceTargetSelector;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.source.SourceSectionClass;

/**
 * This class is used to store mapping hint values. It stores the hint values separated by their type in various
 * {@link HintValueMap HintValueMaps} and provides a common interface to them.
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
	 * This keeps track of hint values for {@link ReferenceTargetSelector MappingInstanceSelectors}.
	 */
	private final MappingInstanceSelectorHintValueMap mappingInstanceSelectorHintValues;

	/**
	 * This keeps track of hint values for {@link ContainerSelector ModelConnectionHints}.
	 */
	private final ContainerSelectorHintValueMap containerSelectorHintValues;

	/**
	 * This constructs an instance and initializes the various maps to store hint values.
	 */
	public HintValueStorage() {

		this.attributeMappingHintValues = new AttributeMappingHintValueMap();
		this.cardinalityMappingHintValues = new CardinalityMappingHintValueMap();
		this.mappingInstanceSelectorHintValues = new MappingInstanceSelectorHintValueMap();
		this.containerSelectorHintValues = new ContainerSelectorHintValueMap();
	}

	/**
	 * This returns the list of stored values for the given hint.
	 *
	 * @param hint
	 *            The hint for which the stored values shall be returned. The concrete type of this needs to be one of
	 *            {@link AttributeMapping}, {@link CardinalityMapping}, {@link MappedAttributeValueExpander},
	 *            {@link ReferenceTargetSelector}, or {@link ContainerSelector}.
	 * @return The stored values for the given hint. The concrete return type is in line with the type of the
	 *         <em>hint</em> according to the concrete implementation of the {@link HintValueMap} type.
	 */
	public Object getHintValues(EObject hint) {

		if (hint instanceof AttributeMapping) {
			return this.getHintValues((AttributeMapping) hint);
		} else if (hint instanceof CardinalityMapping) {
			return this.getHintValues((CardinalityMapping) hint);
		} else if (hint instanceof ReferenceTargetSelector) {
			return this.getHintValues((ReferenceTargetSelector) hint);
		} else if (hint instanceof ContainerSelector) {
			return this.getHintValues((ContainerSelector) hint);
		} else {
			throw new RuntimeException("Unsupported MappingHint type: '" + hint.eClass().getName() + "'!");
		}
	}

	/**
	 * This returns a cloned copy of the list of stored values for the given hint.
	 * <p />
	 * This should be used over {@link #getHintValues(EObject)} when the returned values will, e.g., be added to another
	 * HintValueStorage in order to prevent concurrent usages of the same value.
	 *
	 * @param hint
	 *            The hint for which the stored values shall be returned. The concrete type of this needs to be one of
	 *            {@link AttributeMapping}, {@link CardinalityMapping}, {@link MappedAttributeValueExpander},
	 *            {@link ReferenceTargetSelector}, or {@link ContainerSelector}.
	 * @return A cloned copy of the stored values for the given hint. The concrete return type is in line with the type
	 *         of the <em>hint</em> according to the concrete implementation of the {@link HintValueMap} type.
	 */
	public Object getHintValuesCloned(EObject hint) {

		if (hint instanceof AttributeMapping) {
			return this.getHintValuesCloned((AttributeMapping) hint);
		} else if (hint instanceof CardinalityMapping) {
			return this.getHintValuesCloned((CardinalityMapping) hint);
		} else if (hint instanceof ReferenceTargetSelector) {
			return this.getHintValuesCloned((ReferenceTargetSelector) hint);
		} else if (hint instanceof ContainerSelector) {
			return this.getHintValuesCloned((ContainerSelector) hint);
		} else {
			throw new RuntimeException("Unsupported MappingHint type: '" + hint.eClass().getName() + "'!");
		}
	}

	/**
	 * @return the {@link #attributeMappingHintValues}
	 */
	public AttributeMappingHintValueMap getAttributeMappingHintValues() {

		return this.attributeMappingHintValues;
	}

	/**
	 * This returns the list of stored values for the given hint.
	 *
	 * @param hint
	 *            The hint for which the stored values shall be returned.
	 * @return The stored values for the given hint.
	 */
	public LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> getHintValues(
			AttributeMapping hint) {

		return this.attributeMappingHintValues.getHintValues(hint);
	}

	/**
	 * This returns a cloned copy of the list of stored values for the given hint.
	 * <p />
	 * This should be used over {@link #getHintValues(EObject)} when the returned values will, e.g., be added to another
	 * HintValueStorage in order to prevent concurrent usages of the same value.
	 *
	 * @param hint
	 *            The hint for which the stored values shall be returned.
	 * @return A cloned copy of the stored values for the given hint.
	 */
	public LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> getHintValuesCloned(
			AttributeMapping hint) {

		return new LinkedList<>(
				this.attributeMappingHintValues.getHintValues(hint).parallelStream().map(oldHintValue -> {
					Map<AttributeMappingSourceInterface, AttributeValueRepresentation> newHintValue = new HashMap<>();
					for (AttributeMappingSourceInterface key : oldHintValue.keySet()) {
						newHintValue.put(key, (AttributeValueRepresentation) oldHintValue.get(key).clone());
					}
					return newHintValue;
				}).collect(Collectors.toList()));
	}

	/**
	 * @return the {@link #cardinalityMappingHintValues}
	 */
	public CardinalityMappingHintValueMap getCardinalityMappingHintValues() {

		return this.cardinalityMappingHintValues;
	}

	/**
	 * This returns the list of stored values for the given hint.
	 *
	 * @param hint
	 *            The hint for which the stored values shall be returned.
	 * @return The stored values for the given hint.
	 */
	public LinkedList<Object> getHintValues(CardinalityMapping hint) {

		return this.cardinalityMappingHintValues.getHintValues(hint);
	}

	/**
	 * This returns a cloned copy of the list of stored values for the given hint.
	 *
	 * @param hint
	 *            The hint for which the stored values shall be returned.
	 * @return A cloned copy of the stored values for the given hint.
	 */
	@SuppressWarnings("unchecked")
	public LinkedList<Object> getHintValuesCloned(CardinalityMapping hint) {

		if (hint.getSource() != null) {
			return new LinkedList<>(this.cardinalityMappingHintValues.getHintValues(hint).parallelStream()
					.map(oldHintValue -> new Integer((Integer) oldHintValue)).collect(Collectors.toList()));
		} else {
			return new LinkedList<>(
					this.cardinalityMappingHintValues.getHintValues(hint).parallelStream().map(oldHintValue -> {
						Map<CardinalityMappingSourceInterface, AttributeValueRepresentation> newHintValue = new HashMap<>();
						for (CardinalityMappingSourceInterface key : ((Map<CardinalityMappingSourceInterface, AttributeValueRepresentation>) oldHintValue)
								.keySet()) {
							newHintValue.put(key,
									(AttributeValueRepresentation) ((Map<CardinalityMappingSourceInterface, AttributeValueRepresentation>) oldHintValue)
											.get(key).clone());
						}
						return newHintValue;
					}).collect(Collectors.toList()));
		}
	}

	/**
	 * @return the {@link #mappingInstanceSelectorHintValues}
	 */
	public MappingInstanceSelectorHintValueMap getMappingInstanceSelectorHintValues() {

		return this.mappingInstanceSelectorHintValues;
	}

	/**
	 * This returns the list of stored values for the given hint.
	 *
	 * @param hint
	 *            The hint for which the stored values shall be returned.
	 * @return The stored values for the given hint.
	 */
	public LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>> getHintValues(
			ReferenceTargetSelector hint) {

		return this.mappingInstanceSelectorHintValues.getHintValues(hint);
	}

	/**
	 * This returns a cloned copy of the list of stored values for the given hint.
	 *
	 * @param hint
	 *            The hint for which the stored values shall be returned.
	 * @return A cloned copy of the list of stored values for the given hint.
	 */
	public LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>> getHintValuesCloned(
			ReferenceTargetSelector hint) {

		return new LinkedList<>(
				this.mappingInstanceSelectorHintValues.getHintValues(hint).parallelStream().map(oldHintValue -> {
					Map<InstanceSelectorSourceInterface, AttributeValueRepresentation> newHintValue = new HashMap<>();
					for (InstanceSelectorSourceInterface key : oldHintValue.keySet()) {
						newHintValue.put(key, (AttributeValueRepresentation) oldHintValue.get(key).clone());
					}
					return newHintValue;
				}).collect(Collectors.toList()));
	}

	/**
	 * @return the {@link #containerSelectorHintValues}
	 */
	public ContainerSelectorHintValueMap getModelConnectionHintValues() {

		return this.containerSelectorHintValues;
	}

	/**
	 * This returns the list of stored values for the given hint.
	 *
	 * @param hint
	 *            The hint for which the stored values shall be returned.
	 * @return The stored values for the given hint.
	 */
	public LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>> getHintValues(
			ContainerSelector hint) {

		return this.containerSelectorHintValues.getHintValues(hint);
	}

	/**
	 * This returns a cloned copy of the list of stored values for the given hint.
	 *
	 * @param hint
	 *            The hint for which the stored values shall be returned.
	 * @return A cloned copy of the list of stored values for the given hint.
	 */
	public LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>> getHintValuesCloned(
			ContainerSelector hint) {

		return new LinkedList<>(
				this.containerSelectorHintValues.getHintValues(hint).parallelStream().map(oldHintValue -> {
					Map<InstanceSelectorSourceInterface, AttributeValueRepresentation> newHintValue = new HashMap<>();
					for (InstanceSelectorSourceInterface key : oldHintValue.keySet()) {
						newHintValue.put(key, (AttributeValueRepresentation) oldHintValue.get(key).clone());
					}
					return newHintValue;
				}).collect(Collectors.toList()));
	}

	/**
	 * This adds a hint value to the storage.
	 *
	 * @param hint
	 *            The hint for that the value shall be added. The concrete type of this needs to be one of
	 *            {@link AttributeMapping}, {@link CardinalityMapping}, {@link MappedAttributeValueExpander},
	 *            {@link ReferenceTargetSelector}, or {@link ContainerSelector}.
	 * @param value
	 *            The value to be added. The concrete type needs to be in line with the type of the <em>hint</em>
	 *            according to the concrete implementation of the {@link HintValueMap} type.
	 * @throws ClassCastException
	 *             if the concrete type of the <em>value</em> is not in line with the type of the <em>hint</em>.
	 */
	@SuppressWarnings("unchecked")
	public void addHintValue(EObject hint, Object value) throws ClassCastException {

		if (hint instanceof AttributeMapping) {
			this.addAttributeMappingHintValue((AttributeMapping) hint,
					(Map<AttributeMappingSourceInterface, AttributeValueRepresentation>) value);
		} else if (hint instanceof CardinalityMapping) {
			this.addCardinalityMappingHintValue((CardinalityMapping) hint, value);
		} else if (hint instanceof MappedAttributeValueExpander) {
			this.addHintValue(hint, value);
		} else if (hint instanceof ReferenceTargetSelector) {
			this.addReferenceTargetSelectorHintValue((ReferenceTargetSelector) hint,
					(Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>) value);
		} else if (hint instanceof ContainerSelector) {
			this.addContainerSelectorHintValue((ContainerSelector) hint,
					(Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>) value);
		} else {
			throw new RuntimeException("Unsupported MappingHint type: '" + hint.eClass().getName() + "'!");
		}
	}

	/**
	 * This adds a hint value to the storage.
	 *
	 * @param hint
	 *            The {@link AttributeMapping} for that the value shall be added.
	 * @param value
	 *            The value to be added.
	 */
	public void addAttributeMappingHintValue(AttributeMapping hint,
			Map<AttributeMappingSourceInterface, AttributeValueRepresentation> value) {

		this.attributeMappingHintValues.addHintValue(hint, value);
	}

	/**
	 * This adds a hint value to the storage.
	 *
	 * @param hint
	 *            The {@link CardinalityMapping} for that the value shall be added.
	 * @param value
	 *            The value to be added.
	 */
	public void addCardinalityMappingHintValue(CardinalityMapping hint, Object value) {

		this.cardinalityMappingHintValues.addHintValue(hint, value);
	}

	/**
	 * This adds a hint value to the storage.
	 *
	 * @param hint
	 *            The {@link ReferenceTargetSelector} for that the value shall be added.
	 * @param value
	 *            The value to be added.
	 */
	public void addReferenceTargetSelectorHintValue(ReferenceTargetSelector hint,
			Map<InstanceSelectorSourceInterface, AttributeValueRepresentation> value) {

		this.mappingInstanceSelectorHintValues.addHintValue(hint, value);
	}

	/**
	 * This adds a hint value to the storage.
	 *
	 * @param hint
	 *            The {@link ContainerSelector} for that the value shall be added.
	 * @param value
	 *            The value to be added.
	 */
	public void addContainerSelectorHintValue(ContainerSelector hint,
			Map<InstanceSelectorSourceInterface, AttributeValueRepresentation> value) {

		this.containerSelectorHintValues.addHintValue(hint, value);
	}

	/**
	 * This adds a hint value to the storage.
	 *
	 * @param hint
	 *            The {@link AttributeMapping} for that the value shall be added.
	 * @param clazz
	 *            The {@link SourceSectionClass} for that the value shall be added.
	 * @param value
	 *            The value to be added.
	 */
	public void addAttributeMappingHintValue(AttributeMapping hint, SourceSectionClass clazz,
			Map<AttributeMappingSourceInterface, AttributeValueRepresentation> value) {

		this.attributeMappingHintValues.addHintValue(hint, clazz, value);
	}

	/**
	 * This adds a hint value to the storage.
	 *
	 * @param hint
	 *            The {@link CardinalityMapping} for that the value shall be added.
	 * @param clazz
	 *            The {@link SourceSectionClass} for that the value shall be added.
	 * @param value
	 *            The value to be added.
	 */
	public void addCardinalityMappingHintValue(CardinalityMapping hint, SourceSectionClass clazz, Object value) {

		this.cardinalityMappingHintValues.addHintValue(hint, clazz, value);
	}

	/**
	 * This adds a hint value to the storage.
	 *
	 * @param hint
	 *            The {@link ReferenceTargetSelector} for that the value shall be added.
	 * @param clazz
	 *            The {@link SourceSectionClass} for that the value shall be added.
	 * @param value
	 *            The value to be added.
	 */
	public void addReferenceTargetSelectorHintValue(ReferenceTargetSelector hint, SourceSectionClass clazz,
			Map<InstanceSelectorSourceInterface, AttributeValueRepresentation> value) {

		this.mappingInstanceSelectorHintValues.addHintValue(hint, clazz, value);
	}

	/**
	 * This adds a hint value to the storage.
	 *
	 * @param hint
	 *            The {@link ContainerSelector} for that the value shall be added.
	 * @param clazz
	 *            The {@link SourceSectionClass} for that the value shall be added.
	 * @param value
	 *            The value to be added.
	 */
	public void addContainerSelectorHintValue(ContainerSelector hint, SourceSectionClass clazz,
			Map<InstanceSelectorSourceInterface, AttributeValueRepresentation> value) {

		this.containerSelectorHintValues.addHintValue(hint, clazz, value);
	}

	/**
	 * This adds the hint values stored in another {@link HintValueStorage} to this storage.
	 *
	 * @param hintValuesToAdd
	 *            The {@link HintValueStorage} that contains the hint values to add.
	 */
	public void addHintValues(HintValueStorage hintValuesToAdd) {

		// copy the various maps
		this.getAttributeMappingHintValues().addHintValues(hintValuesToAdd.getAttributeMappingHintValues());
		this.getCardinalityMappingHintValues().addHintValues(hintValuesToAdd.getCardinalityMappingHintValues());
		this.getMappingInstanceSelectorHintValues()
				.addHintValues(hintValuesToAdd.getMappingInstanceSelectorHintValues());
		this.getModelConnectionHintValues().addHintValues(hintValuesToAdd.getModelConnectionHintValues());
	}

	/**
	 * This adds a list of hint value to the storage.
	 *
	 * @param hint
	 *            The hint for that the value shall be added. The concrete type of this needs to be one of
	 *            {@link AttributeMapping}, {@link CardinalityMapping}, {@link MappedAttributeValueExpander},
	 *            {@link ReferenceTargetSelector}, or {@link ContainerSelector}.
	 * @param values
	 *            The values to be added. The concrete type needs to be in line with the type of the <em>hint</em>
	 *            according to the concrete implementation of the {@link HintValueMap} type.
	 * @throws ClassCastException
	 *             if the concrete type of the <em>value</em> is not in line with the type of the <em>hint</em>.
	 */
	@SuppressWarnings("unchecked")
	public void addHintValues(EObject hint, Object values) throws ClassCastException {

		if (hint instanceof AttributeMapping) {
			this.addAttributeMappingHintValues((AttributeMapping) hint,
					(LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>>) values);
		} else if (hint instanceof CardinalityMapping) {
			this.addCardinalityMappingHintValues((CardinalityMapping) hint, (LinkedList<Object>) values);
		} else if (hint instanceof MappedAttributeValueExpander) {
			this.addHintValues(hint, values);
		} else if (hint instanceof ReferenceTargetSelector) {
			this.addReferenceTargetSelectorHintValues((ReferenceTargetSelector) hint,
					(LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>>) values);
		} else if (hint instanceof ContainerSelector) {
			this.addContainerSelectorHintValues((ContainerSelector) hint,
					(LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>>) values);
		} else {
			throw new RuntimeException("Unsupported MappingHint type: '" + hint.eClass().getName() + "'!");
		}
	}

	/**
	 * This adds a list of hint value to the storage.
	 *
	 * @param hint
	 *            The {@link AttributeMapping} for that the value shall be added.
	 * @param values
	 *            The values to be added.
	 */
	public void addAttributeMappingHintValues(AttributeMapping hint,
			LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> values) {

		this.attributeMappingHintValues.addHintValues(hint, values);
	}

	/**
	 * This adds a list of hint value to the storage.
	 *
	 * @param hint
	 *            The {@link CardinalityMapping} for that the value shall be added.
	 * @param values
	 *            The values to be added.
	 */
	public void addCardinalityMappingHintValues(CardinalityMapping hint, LinkedList<Object> values) {

		this.cardinalityMappingHintValues.addHintValues(hint, values);
	}

	/**
	 * This adds a list of hint value to the storage.
	 *
	 * @param hint
	 *            The {@link ReferenceTargetSelector} for that the value shall be added.
	 * @param values
	 *            The values to be added.
	 */
	public void addReferenceTargetSelectorHintValues(ReferenceTargetSelector hint,
			LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>> values) {

		this.mappingInstanceSelectorHintValues.addHintValues(hint, values);
	}

	/**
	 * This adds a list of hint value to the storage.
	 *
	 * @param hint
	 *            The {@link ContainerSelector} for that the value shall be added.
	 * @param values
	 *            The values to be added.
	 */
	public void addContainerSelectorHintValues(ContainerSelector hint,
			LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>> values) {

		this.containerSelectorHintValues.addHintValues(hint, values);
	}

	/**
	 * This sets the list of stored hint values for the given hint.
	 *
	 * @param hint
	 *            The hint for that the value shall be set. The concrete type of this needs to be one of
	 *            {@link AttributeMapping}, {@link CardinalityMapping}, {@link MappedAttributeValueExpander},
	 *            {@link ReferenceTargetSelector}, or {@link ContainerSelector}.
	 * @param values
	 *            The values to be set. The concrete type needs to be in line with the type of the <em>hint</em>
	 *            according to the concrete implementation of the {@link HintValueMap} type.
	 * @throws ClassCastException
	 *             if the concrete type of the <em>value</em> is not in line with the type of the <em>hint</em>.
	 */
	@SuppressWarnings("unchecked")
	public void setHintValues(EObject hint, Object values) throws ClassCastException {

		if (hint instanceof AttributeMapping) {
			this.setAttributeMappingHintValues((AttributeMapping) hint,
					(LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>>) values);
		} else if (hint instanceof CardinalityMapping) {
			this.setCardinalityMappingHintValues((CardinalityMapping) hint, (LinkedList<Object>) values);
		} else if (hint instanceof MappedAttributeValueExpander) {
			this.setHintValues(hint, values);
		} else if (hint instanceof ReferenceTargetSelector) {
			this.setReferenceTargetSelectorHintValues((ReferenceTargetSelector) hint,
					(LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>>) values);
		} else if (hint instanceof ContainerSelector) {
			this.setContainerSelectorHintValues((ContainerSelector) hint,
					(LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>>) values);
		} else {
			throw new RuntimeException("Unsupported MappingHint type: '" + hint.eClass().getName() + "'!");
		}
	}

	/**
	 * This sets the list of stored hint values for the given hint.
	 *
	 * @param hint
	 *            The {@link AttributeMapping} for that the values shall be set.
	 * @param values
	 *            The values to be set.
	 */
	public void setAttributeMappingHintValues(AttributeMapping hint,
			LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> values) {

		this.attributeMappingHintValues.setHintValues(hint, values);
	}

	/**
	 * This sets the list of stored hint values for the given hint.
	 *
	 * @param hint
	 *            The {@link CardinalityMapping} for that the values shall be set.
	 * @param values
	 *            The values to be set.
	 */
	public void setCardinalityMappingHintValues(CardinalityMapping hint, LinkedList<Object> values) {

		this.cardinalityMappingHintValues.setHintValues(hint, values);
	}

	/**
	 * This sets the list of stored hint values for the given hint.
	 *
	 * @param hint
	 *            The {@link ReferenceTargetSelector} for that the values shall be set.
	 * @param values
	 *            The values to be set.
	 */
	public void setReferenceTargetSelectorHintValues(ReferenceTargetSelector hint,
			LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>> values) {

		this.mappingInstanceSelectorHintValues.setHintValues(hint, values);
	}

	/**
	 * This sets the list of stored hint values for the given hint.
	 *
	 * @param hint
	 *            The {@link ContainerSelector} for that the values shall be set.
	 * @param values
	 *            The values to be set.
	 */
	public void setContainerSelectorHintValues(ContainerSelector hint,
			LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>> values) {

		this.containerSelectorHintValues.setHintValues(hint, values);
	}

	/**
	 * This sets the list of stored hint values for the given hint and a given {@link SourceSectionClass}.
	 *
	 * @param hint
	 *            The {@link AttributeMapping} for that the values shall be set.
	 * @param clazz
	 *            The {@link SourceSectionClass} for that the values shall be set.
	 * @param values
	 *            The values to be set.
	 */
	public void setAttributeMappingHintValues(AttributeMapping hint, SourceSectionClass clazz,
			LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> values) {

		this.attributeMappingHintValues.setHintValues(hint, clazz, values);
	}

	/**
	 * This sets the list of stored hint values for the given hint and a given {@link SourceSectionClass}.
	 *
	 * @param hint
	 *            The {@link CardinalityMapping} for that the values shall be set.
	 * @param clazz
	 *            The {@link SourceSectionClass} for that the values shall be set.
	 * @param values
	 *            The values to be set.
	 */
	public void setCardinalityMappingHintValues(CardinalityMapping hint, SourceSectionClass clazz, LinkedList<Object> values) {

		this.cardinalityMappingHintValues.setHintValues(hint, clazz, values);
	}

	/**
	 * This sets the list of stored hint values for the given hint and a given {@link SourceSectionClass}.
	 *
	 * @param hint
	 *            The {@link ReferenceTargetSelector} for that the values shall be set.
	 * @param clazz
	 *            The {@link SourceSectionClass} for that the values shall be set.
	 * @param values
	 *            The values to be set.
	 */
	public void setReferenceTargetSelectorHintValues(ReferenceTargetSelector hint, SourceSectionClass clazz,
			LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>> values) {

		this.mappingInstanceSelectorHintValues.setHintValues(hint, clazz, values);
	}

	/**
	 * This sets the list of stored hint values for the given hint and a given {@link SourceSectionClass}.
	 *
	 * @param hint
	 *            The {@link ContainerSelector} for that the values shall be set.
	 * @param clazz
	 *            The {@link SourceSectionClass} for that the values shall be set.
	 * @param values
	 *            The values to be set.
	 */
	public void setContainerSelectorHintValues(ContainerSelector hint, SourceSectionClass clazz,
			LinkedList<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>> values) {

		this.containerSelectorHintValues.setHintValues(hint, clazz, values);
	}

	/**
	 * This retrieves and removes the hint values stored for a given hint
	 *
	 * @param hint
	 *            The hint for which the hint values shall be retrieved and removed. The concrete type of this needs to
	 *            be one of {@link AttributeMapping}, {@link CardinalityMapping}, {@link MappedAttributeValueExpander},
	 *            {@link ReferenceTargetSelector}, or {@link ContainerSelector}.
	 * @return The removed hint values. The concrete type is in line with the type of the <em>hint</em> according to the
	 *         concrete implementation of the {@link HintValueMap} type.
	 */
	public Object removeHint(EObject hint) {

		if (hint instanceof AttributeMapping) {
			return this.getAttributeMappingHintValues().remove(hint).get(null);
		} else if (hint instanceof CardinalityMapping) {
			return this.getCardinalityMappingHintValues().remove(hint).get(null);
		} else if (hint instanceof ReferenceTargetSelector) {
			return this.getMappingInstanceSelectorHintValues().remove(hint).get(null);
		} else if (hint instanceof ContainerSelector) {
			return this.getModelConnectionHintValues().remove(hint).get(null);
		} else {
			throw new RuntimeException("Unsupported MappingHint type: '" + hint.eClass().getName() + "'!");
		}
	}

	/**
	 * This retrieves and removes the first hint value stored for a given hint.
	 *
	 * @param hint
	 *            The hint for which the first hint value shall be retrieved and removed.. The concrete type of this
	 *            needs to be one of {@link AttributeMapping}, {@link CardinalityMapping},
	 *            {@link MappedAttributeValueExpander}, {@link ReferenceTargetSelector}, or {@link ContainerSelector}.
	 * @return The removed hint value. The concrete type is in line with the type of the <em>hint</em> according to the
	 *         concrete implementation of the {@link HintValueMap} type.
	 */
	public Object removeHintValue(EObject hint) {

		if (hint instanceof AttributeMapping) {
			return this.removeHintValue((AttributeMapping) hint);
		} else if (hint instanceof CardinalityMapping) {
			return this.removeHintValue((CardinalityMapping) hint);
		} else if (hint instanceof MappedAttributeValueExpander) {
			return this.removeHintValue(hint);
		} else if (hint instanceof ReferenceTargetSelector) {
			return this.removeHintValue((ReferenceTargetSelector) hint);
		} else if (hint instanceof ContainerSelector) {
			return this.removeHintValue((ContainerSelector) hint);
		} else {
			throw new RuntimeException("Unsupported MappingHint type: '" + hint.eClass().getName() + "'!");
		}
	}

	/**
	 * This retrieves and removes the first hint value stored for a given hint.
	 *
	 * @param hint
	 *            The hint for which the first hint value shall be retrieved and removed.
	 * @return The removed hint value.
	 */
	public Map<AttributeMappingSourceInterface, AttributeValueRepresentation> removeHintValue(AttributeMapping hint) {

		return this.attributeMappingHintValues.removeHintValue(hint);
	}

	/**
	 * This retrieves and removes the first hint value stored for a given hint.
	 *
	 * @param hint
	 *            The hint for which the first hint value shall be retrieved and removed.
	 * @return The removed hint value.
	 */
	public Object removeHintValue(CardinalityMapping hint) {

		return this.cardinalityMappingHintValues.removeHintValue(hint);
	}

	/**
	 * This retrieves and removes the first hint value stored for a given hint.
	 *
	 * @param hint
	 *            The hint for which the first hint value shall be retrieved and removed.
	 * @return The removed hint value.
	 */
	public Map<InstanceSelectorSourceInterface, AttributeValueRepresentation> removeHintValue(
			ReferenceTargetSelector hint) {

		return this.mappingInstanceSelectorHintValues.removeHintValue(hint);
	}

	/**
	 * This retrieves and removes the first hint value stored for a given hint.
	 *
	 * @param hint
	 *            The hint for which the first hint value shall be retrieved and removed.
	 * @return The removed hint value.
	 */
	public Map<InstanceSelectorSourceInterface, AttributeValueRepresentation> removeHintValue(ContainerSelector hint) {

		return this.containerSelectorHintValues.removeHintValue(hint);
	}

	/**
	 * This checks whether hint values are stored for the given hint.
	 *
	 * @param hint
	 *            The hint that shall be checked. The concrete type of this needs to be one of {@link AttributeMapping},
	 *            {@link CardinalityMapping}, {@link MappedAttributeValueExpander}, {@link ReferenceTargetSelector}, or
	 *            {@link ContainerSelector}.
	 * @return '<em><b>true</b></em>' if the given <em>hint</em> is contained in the storage, '<em><b>false</b></em>'
	 *         otherwise
	 * @throws ClassCastException
	 *             if the concrete type of the <em>value</em> is not in line with the type of the <em>hint</em>.
	 */
	public boolean containsHint(EObject hint) throws ClassCastException {

		if (hint instanceof AttributeMapping) {
			return this.getAttributeMappingHintValues().containsKey(hint);
		} else if (hint instanceof CardinalityMapping) {
			return this.getCardinalityMappingHintValues().containsKey(hint);
		} else if (hint instanceof ReferenceTargetSelector) {
			return this.getMappingInstanceSelectorHintValues().containsKey(hint);
		} else if (hint instanceof ContainerSelector) {
			return this.getModelConnectionHintValues().containsKey(hint);
		} else {
			throw new RuntimeException("Unsupported MappingHint type: '" + hint.eClass().getName() + "'!");
		}
	}
}
