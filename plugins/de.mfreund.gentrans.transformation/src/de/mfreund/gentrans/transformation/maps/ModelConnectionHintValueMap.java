package de.mfreund.gentrans.transformation.maps;

import pamtram.mapping.ContainerSelector;
import pamtram.mapping.ContainerSelectorSourceInterface;
import pamtram.structure.SourceSectionClass;

/**
 * This class represents a map that allows to collect hint values for 
 * {@link ContainerSelector ModelConnectionHints}.
 * <p />
 * Thereby, the stored hint values are associated with the <em>ModelConnectionHint</em>, the 
 * <em>{@link ContainerSelectorSourceInterface}</em> of the hint and the 
 * <em>{@link SourceSectionClass}</em> that they belong to.
 * 
 * @author mfreund
 */
public class ModelConnectionHintValueMap extends AttributeBasedHintValueMap<ContainerSelector, ContainerSelectorSourceInterface> {

	private static final long serialVersionUID = -3933991238187309467L;

}
