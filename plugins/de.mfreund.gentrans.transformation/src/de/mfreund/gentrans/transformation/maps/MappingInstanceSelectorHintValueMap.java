package de.mfreund.gentrans.transformation.maps;

import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherSourceElement;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.metamodel.SourceSectionClass;

/**
 * This class provides represents a map that allows to collect hint values for 
 * {@link MappingInstanceSelector MappingInstanceSelectors}
 * <p />
 * Thereby, the stored hint values are associated with the <em>MappingInstanceSelector</em>, the 
 * <em>{@link AttributeMatcherSourceElement}</em> of an {@link AttributeMatcher} of the hint and the 
 * <em>{@link SourceSectionClass}</em> that they belong to.
 * 
 * @author mfreund
 */
public class MappingInstanceSelectorHintValueMap extends HintValueMap<MappingInstanceSelector, AttributeMatcherSourceElement> {

	private static final long serialVersionUID = -57312964158841610L;

}
