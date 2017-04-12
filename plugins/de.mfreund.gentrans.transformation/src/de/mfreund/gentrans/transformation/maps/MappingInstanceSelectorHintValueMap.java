package de.mfreund.gentrans.transformation.maps;

import pamtram.mapping.extended.AttributeMatcher;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.source.SourceSectionClass;

/**
 * This class represents a map that allows to collect hint values for {@link ReferenceTargetSelector
 * MappingInstanceSelectors}.
 * <p />
 * Thereby, the stored hint values are associated with the <em>MappingInstanceSelector</em>, the
 * <em>{@link InstanceSelectorSourceInterface}</em> of an {@link AttributeMatcher} of the hint and the
 * <em>{@link SourceSectionClass}</em> that they belong to.
 *
 * @author mfreund
 */
public class MappingInstanceSelectorHintValueMap
		extends AttributeBasedHintValueMap<ReferenceTargetSelector, InstanceSelectorSourceInterface> {

	private static final long serialVersionUID = -57312964158841610L;

}
