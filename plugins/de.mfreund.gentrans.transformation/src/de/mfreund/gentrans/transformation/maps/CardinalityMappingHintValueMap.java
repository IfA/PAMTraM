package de.mfreund.gentrans.transformation.maps;

import pamtram.mapping.CardinalityMapping;
import pamtram.metamodel.SourceSectionClass;

/**
 * This class represents a map that allows to collect hint values for 
 * {@link CardinalityMapping CardinalityMappings}.
 * <p />
 * Thereby, the stored hint values are associated with the <em>CardinalityMapping</em> and the 
 * <em>{@link SourceSectionClass}</em> that they belong to.
 * 
 * @author mfreund
 */
public class CardinalityMappingHintValueMap extends HintValueMap<CardinalityMapping, Integer> {

	private static final long serialVersionUID = 8438717886501675768L;

}
