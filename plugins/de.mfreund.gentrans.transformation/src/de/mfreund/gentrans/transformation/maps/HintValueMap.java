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

	/**
	 * This initializes this map and all .
	 * <p />
	 * Note: This is called automatically when hint values for a hint are to be stored that has
	 * not been initialized. However, this may be called manually to reset the list of hint values.
	 * 
	 * @param hint The mapping hint for which the collection of hint values shall be initialized.
	 */
	private void init(K hint) {
		this.put(hint, new HashMap<SourceSectionClass, LinkedList<Map<S, String>>>());
	}
	
	/**
	 * This adds all values that are stored in the given hintValueMap to this map.
	 * 
	 * @param hintValueMap The map of hint values that shall be added to this map.
	 */
	public void addHintValues(HintValueMap<K, S> hintValueMap) {
		
		/*
		 * Before we add anything, we make sure that every sub-map and -list is
		 * initialized so that we do not get any Exceptions.
		 */
		for (final K h : hintValueMap.keySet()) {
			if (!this.containsKey(h)) {
				this.init(h);
			}

			for (final SourceSectionClass c : hintValueMap.get(h).keySet()) {
				if (!this.get(h).containsKey(c)) {
					this.get(h).put(c, new LinkedList<Map<S, String>>());
				}
				
				/*
				 * Finally, add the hint values...
				 */
				this.get(h).get(c).addAll(hintValueMap.get(h).get(c));
			}
		}
	}
	
}
