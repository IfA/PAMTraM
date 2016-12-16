package de.mfreund.gentrans.transformation.maps;

import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.structure.SourceSectionClass;

/**
 * This class represents a map that allows to collect hint values for 
 * {@link AttributeMapping AttributeMappings}.
 * <p />
 * Thereby, the stored hint values are associated with the <em>AttributeMapping</em>, the 
 * <em>{@link AttributeMappingSourceInterface}</em> of the hint and the 
 * <em>{@link SourceSectionClass}</em> that they belong to.
 * 
 * @author mfreund
 */
public class AttributeMappingHintValueMap extends AttributeBasedHintValueMap<AttributeMapping, AttributeMappingSourceInterface> {

	private static final long serialVersionUID = 8668242329602708053L;
	
}
