package de.mfreund.gentrans.transformation.maps;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.CardinalityMappingSourceInterface;
import pamtram.structure.source.SourceSectionClass;

/**
 * This class represents a map that allows to collect hint values for {@link CardinalityMapping CardinalityMappings}.
 * <p />
 * Thereby, the stored hint values are associated with the <em>CardinalityMapping</em> and the
 * <em>{@link SourceSectionClass}</em> that they belong to.
 * <p />
 * Note: As {@link CardinalityMapping CardinalityMappings} may specify two different types of sources for hint values
 * (either a {@link CardinalityMapping#getSource() source} or a list of {@link CardinalityMapping#getSourceElements()
 * sourceElements}), this basically just wraps to different {@link HintValueMap HintValueMaps}. Thus, the methods of
 * this map only operate on <em>Objects</em>. However, the concrete parameter/return types need to be/are always either
 * <em>Integer</em> (for CardinalityMappings that specify a <em>source</em>) or <em> Map<CardinalityMapping,
 * AttributeValueRepresentation> (for CardinalityMappings that specify a list of <em>sourceElements</em>).
 *
 * @author mfreund
 */
public class CardinalityMappingHintValueMap extends HintValueMap<CardinalityMapping, Object> {

	private static final long serialVersionUID = 8438717886501675768L;

	/**
	 * The internal {@link HintValueMap} for CardinalityMappings that are based on the
	 * {@link CardinalityMapping#getSource()} reference.
	 */
	private HintValueMap<CardinalityMapping, Integer> sourceHintValueMap;

	/**
	 * The internal {@link HintValueMap} for CardinalityMappings that are based on the
	 * {@link CardinalityMapping#getSourceElements()} reference.
	 */
	private AttributeBasedHintValueMap<CardinalityMapping, CardinalityMappingSourceInterface> sourceElementsHintValueMap;

	/**
	 * This creates an instance.
	 *
	 */
	public CardinalityMappingHintValueMap() {

		this.sourceHintValueMap = new HintValueMap<>();
		this.sourceElementsHintValueMap = new AttributeBasedHintValueMap<>();
	}

	/**
	 * @return the {@link #sourceHintValueMap}
	 */
	protected HintValueMap<CardinalityMapping, Integer> getSourceHintValueMap() {

		return this.sourceHintValueMap;
	}

	/**
	 * @return the {@link #sourceElementsHintValueMap}
	 */
	protected AttributeBasedHintValueMap<CardinalityMapping, CardinalityMappingSourceInterface> getSourceElementsHintValueMap() {

		return this.sourceElementsHintValueMap;
	}

	@Override
	public void init(CardinalityMapping hint) {

		if (hint.getSource() != null) {
			this.sourceHintValueMap.init(hint);
		} else {
			this.sourceElementsHintValueMap.init(hint);
		}
	}

	@Override
	public LinkedList<Object> getHintValues(CardinalityMapping hint) {

		if (hint.getSource() != null) {
			return new LinkedList<>(this.sourceHintValueMap.getHintValues(hint));
		} else {
			return new LinkedList<>(this.sourceElementsHintValueMap.getHintValues(hint));
		}
	}

	@Override
	public LinkedList<Object> getHintValues(CardinalityMapping hint, SourceSectionClass clazz) {

		if (hint.getSource() != null) {
			return new LinkedList<>(this.sourceHintValueMap.getHintValues(hint, clazz));
		} else {
			return new LinkedList<>(this.sourceElementsHintValueMap.getHintValues(hint, clazz));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addHintValue(CardinalityMapping hint, SourceSectionClass clazz, Object value) {

		if (hint.getSource() != null) {
			this.sourceHintValueMap.addHintValue(hint, clazz, (Integer) value);
		} else {
			this.sourceElementsHintValueMap.addHintValue(hint, clazz,
					(Map<CardinalityMappingSourceInterface, AttributeValueRepresentation>) value);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addHintValues(CardinalityMapping hint, SourceSectionClass clazz, LinkedList<Object> values) {

		if (hint.getSource() != null) {
			this.sourceHintValueMap.addHintValues(hint, clazz, (LinkedList<Integer>) (LinkedList<?>) values);
		} else {
			this.sourceElementsHintValueMap.addHintValues(hint, clazz,
					(LinkedList<Map<CardinalityMappingSourceInterface, AttributeValueRepresentation>>) (LinkedList<?>) values);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addHintValue(CardinalityMapping hint, Object value) {

		if (hint.getSource() != null) {
			this.sourceHintValueMap.addHintValue(hint, (Integer) value);
		} else {
			this.sourceElementsHintValueMap.addHintValue(hint,
					(Map<CardinalityMappingSourceInterface, AttributeValueRepresentation>) value);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addHintValues(CardinalityMapping hint, LinkedList<Object> values) {

		if (hint.getSource() != null) {
			this.sourceHintValueMap.addHintValues(hint, (LinkedList<Integer>) (LinkedList<?>) values);
		} else {
			this.sourceElementsHintValueMap.addHintValues(hint,
					(LinkedList<Map<CardinalityMappingSourceInterface, AttributeValueRepresentation>>) (LinkedList<?>) values);
		}
	}

	@Override
	public void addHintValues(HintValueMap<CardinalityMapping, Object> valueMap) {

		if (valueMap instanceof CardinalityMappingHintValueMap) {
			this.sourceHintValueMap.addHintValues(((CardinalityMappingHintValueMap) valueMap).getSourceHintValueMap());
			this.sourceElementsHintValueMap
					.addHintValues(((CardinalityMappingHintValueMap) valueMap).getSourceElementsHintValueMap());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setHintValues(CardinalityMapping hint, LinkedList<Object> values) {

		if (hint.getSource() != null) {
			this.sourceHintValueMap.setHintValues(hint, (LinkedList<Integer>) (LinkedList<?>) values);
		} else {
			this.sourceElementsHintValueMap.setHintValues(hint,
					(LinkedList<Map<CardinalityMappingSourceInterface, AttributeValueRepresentation>>) (LinkedList<?>) values);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setHintValues(CardinalityMapping hint, SourceSectionClass clazz, LinkedList<Object> values) {

		if (hint.getSource() != null) {
			this.sourceHintValueMap.setHintValues(hint, clazz, (LinkedList<Integer>) (LinkedList<?>) values);
		} else {
			this.sourceElementsHintValueMap.setHintValues(hint, clazz,
					(LinkedList<Map<CardinalityMappingSourceInterface, AttributeValueRepresentation>>) (LinkedList<?>) values);
		}
	}

	@Override
	public boolean containsKey(Object key) {

		return this.sourceHintValueMap.containsKey(key) || this.sourceElementsHintValueMap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {

		return this.sourceHintValueMap.containsValue(value) || this.sourceElementsHintValueMap.containsValue(value);
	}

	@Override
	public Set<java.util.Map.Entry<CardinalityMapping, LinkedHashMap<SourceSectionClass, LinkedList<Object>>>> entrySet() {

		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<LinkedHashMap<SourceSectionClass, LinkedList<Object>>> values() {

		throw new UnsupportedOperationException();
	}
}
