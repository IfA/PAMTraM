package de.mfreund.gentrans.transformation.maps;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import pamtram.metamodel.SourceSectionClass;

/**
 * This abstract base class represents a map that allows to collect hint values for 
 * mapping hints that are based on attribute values.
 * <p />
 * Thereby, the stored hint values are associated with the <em>mapping hint</em>, the 
 * source element of the mapping hint and (optionally) the <em>{@link SourceSectionClass}</em> that they belong to.
 * 
 * @author mfreund
 * 
 * @param <K> The concrete type of hints to be stored in the map.
 * @param <S> The concrete type of values to be stored in the map. 
 */
public abstract class AttributeBasedHintValueMap<K extends EObject, S extends EObject> extends HintValueMap<K, Map<S, AttributeValueRepresentation>> {

	private static final long serialVersionUID = 7863859419011070324L;

	@Override
	public void addHintValues(HintValueMap<K, Map<S, AttributeValueRepresentation>> valueMap) {

		/*
		 * Before we add anything, we make sure that every sub-map and -list is
		 * initialized so that we do not get any Exceptions.
		 */
		for (final K h : valueMap.keySet()) {
			if (!this.containsKey(h)) {
				this.init(h, false);
			}

			for (final SourceSectionClass c : valueMap.get(h).keySet()) {
				if (!this.get(h).containsKey(c)) {
					this.get(h).put(c, new LinkedList<Map<S, AttributeValueRepresentation>>());
				}

				if(valueMap.get(h).get(c).isEmpty() || 
						valueMap.get(h).get(c).getFirst().isEmpty()) {
					continue;
				}

				/*
				 * Finally, add the hint values. However, if the partial values stored in the 'valueMap'
				 * represent different 'S' than those already present in 'this', we combine the values instead. 
				 * Thus, we ensure that complex hint values can be created from source attributes at different layers of the
				 * containment tree.
				 */
				if(this.get(h).get(c).isEmpty() ||  valueMap.get(h).get(c).size() > 1) {
					//TODO maybe also consider merging when 'valueMap.get(h).get(c).size()' is greater than 1?
					this.get(h).get(c).addAll(valueMap.get(h).get(c));					
				} else {
					// check if the we need to combine values (if the 'K' represented in both 'this' and 'valueMap' are
					// disjunct) or add new ones (otherwise)
					Set<S> duplicates = new HashSet<>();
					duplicates.addAll(this.get(h).get(c).getFirst().keySet());
					duplicates.retainAll(valueMap.get(h).get(c).getFirst().keySet());
					boolean combine = duplicates.isEmpty();
					
					if(!combine) {
						if(this.get(h).get(c).isEmpty()) {
							// add the values
							this.get(h).get(c).addAll(valueMap.get(h).get(c));							
						} else {
							// add the values but keep all existing (partial) hint values
							LinkedList<Map<S, AttributeValueRepresentation>> newValues = valueMap.get(h).get(c);
							Map<S, AttributeValueRepresentation> oldValue = this.get(h).get(c).getLast();	
							for (Map<S, AttributeValueRepresentation> newValue : newValues) {
								for (java.util.Map.Entry<S, AttributeValueRepresentation> oldValueEntry : oldValue.entrySet()) {
									if(!newValue.containsKey(oldValueEntry.getKey())) {
										newValue.put(oldValueEntry.getKey(), oldValueEntry.getValue());
									}
								}
								// add the 'enriched' new value
								this.get(h).get(c).add(newValue);
							}
						}
					} else {
						// combine the values
						for (Map<S, AttributeValueRepresentation> element : this.get(h).get(c)) {
							for (java.util.Map.Entry<S, AttributeValueRepresentation> entry : valueMap.get(h).get(c).getFirst().entrySet()) {
								element.put(entry.getKey(), entry.getValue());								
							}
						}
					}
				}
			}
		}
	}

	@Override
	protected Map<S, AttributeValueRepresentation> createEmptyValue() {
		return new LinkedHashMap<>();
	}

}
