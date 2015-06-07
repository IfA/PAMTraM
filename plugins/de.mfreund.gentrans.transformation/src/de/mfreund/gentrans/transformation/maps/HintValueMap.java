package de.mfreund.gentrans.transformation.maps;

import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;

import pamtram.metamodel.SourceSectionClass;

/**
 * This abstract base class provides illustrates a map that allows to collect hint values for 
 * mapping hints.
 * <p />
 * Thereby, the stored hint values are associated with the <em>mapping hint</em> and (optionally) 
 * the <em>{@link SourceSectionClass}</em> that they belong to.
 * 
 * @author mfreund
 */
public abstract class HintValueMap<K extends EObject, S extends Object> extends HashMap<K, HashMap<SourceSectionClass, LinkedList<S>>> {

	private static final long serialVersionUID = 7863859419011070324L;

	/**
	 * This initializes this map.
	 * <p />
	 * Note: This is called automatically when hint values for a hint are to be stored that has
	 * not been initialized. However, this may be called manually to reset the list of hint values.
	 * 
	 * @param hint The mapping hint for which the collection of hint values shall be initialized.
	 */
	protected void init(K hint) {
		this.put(hint, new HashMap<SourceSectionClass, LinkedList<S>>());
	}
}
