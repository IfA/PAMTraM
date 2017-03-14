package de.mfreund.gentrans.transformation.maps;

import pamtram.mapping.ContainerSelector;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.source.SourceSectionClass;

/**
 * This class represents a map that allows to collect hint values for {@link ContainerSelector ContainerSelectors}.
 * <p />
 * Thereby, the stored hint values are associated with the <em>ContainerSelector</em>, the
 * <em>{@link InstanceSelectorSourceInterface}</em> of the hint and the <em>{@link SourceSectionClass}</em> that they
 * belong to.
 *
 * @author mfreund
 */
public class ContainerSelectorHintValueMap
		extends AttributeBasedHintValueMap<ContainerSelector, InstanceSelectorSourceInterface> {

	private static final long serialVersionUID = -3933991238187309467L;

}
