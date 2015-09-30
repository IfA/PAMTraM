package de.mfreund.gentrans.transformation.maps;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.AttributeValueRepresentation;
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
	protected Map<S, AttributeValueRepresentation> createEmptyValue() {
		return new LinkedHashMap<>();
	}

}
