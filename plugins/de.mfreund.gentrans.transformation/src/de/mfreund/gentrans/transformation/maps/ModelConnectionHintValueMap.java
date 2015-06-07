package de.mfreund.gentrans.transformation.maps;

import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.ModelConnectionHintSourceElement;
import pamtram.metamodel.SourceSectionClass;

/**
 * This class provides represents a map that allows to collect hint values for 
 * {@link ModelConnectionHint ModelConnectionHints}
 * <p />
 * Thereby, the stored hint values are associated with the <em>ModelConnectionHint</em>, the 
 * <em>{@link ModelConnectionHintSourceElement}</em> of the hint and the 
 * <em>{@link SourceSectionClass}</em> that they belong to.
 * 
 * @author mfreund
 */
public class ModelConnectionHintValueMap extends HintValueMap<ModelConnectionHint, ModelConnectionHintSourceElement> {

	private static final long serialVersionUID = -3933991238187309467L;

}
