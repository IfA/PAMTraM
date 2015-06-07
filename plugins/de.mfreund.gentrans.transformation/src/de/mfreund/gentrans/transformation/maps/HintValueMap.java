package de.mfreund.gentrans.transformation.maps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import pamtram.metamodel.SourceSectionClass;

/**
 * This abstract base class provides illustrates a map that allows to collect hint values for 
 * mapping hints.
 * <p />
 * Thereby, the stored hint values are associated with the <em>mapping hint</em>, the 
 * source element of the mapping hint and the <em>{@link SourceSectionClass}</em> that they belong to.
 * 
 * @author mfreund
 */
public abstract class HintValueMap<K extends EObject, S extends EObject> extends HashMap<K, HashMap<SourceSectionClass, LinkedList<Map<S, String>>>> {

	private static final long serialVersionUID = 7863859419011070324L;

}
