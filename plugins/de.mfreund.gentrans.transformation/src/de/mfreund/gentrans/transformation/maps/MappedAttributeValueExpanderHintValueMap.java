package de.mfreund.gentrans.transformation.maps;

import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.metamodel.SourceSectionClass;

/**
 * This class represents a map that allows to collect hint values for 
 * {@link MappedAttributeValueExpander MappedAttributeValueExpanders}.
 * <p />
 * Thereby, the stored hint values are associated with the <em>MappedAttributeValueExpander</em> and the 
 * <em>{@link SourceSectionClass}</em> that they belong to.
 * 
 * @author mfreund
 */
public class MappedAttributeValueExpanderHintValueMap extends HintValueMap<MappedAttributeValueExpander, String> {

	private static final long serialVersionUID = 6961758164755027695L;

}
