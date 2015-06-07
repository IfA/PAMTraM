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
 * source element of the mapping hint and (not optionally) the <em>{@link SourceSectionClass}</em> that they belong to.
 * 
 * @author mfreund
 */
public abstract class HintValueMap<K extends EObject, S extends EObject> extends HashMap<K, HashMap<SourceSectionClass, LinkedList<Map<S, String>>>> {

	private static final long serialVersionUID = 7863859419011070324L;

	/**
	 * This initializes this map.
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
	
	/**
	 * This adds a hint value that is associated with a {@link SourceSectionClass} to this map.
	 * 
	 * @param hint The hint for which this value shall be added.
	 * @param clazz The source section class that the hint value is associated to.
	 * @param hintValue The value to be added to this map of hint values.
	 */
	public void addHintValue(K hint, SourceSectionClass clazz, Map<S, String> hintValue) {
		
		/*
		 * Before we add anything, we make sure that every sub-map and -list is
		 * initialized so that we do not get any Exceptions.
		 */
		if (!this.containsKey(hint)) {
			this.init(hint);
		}

		if(!this.get(hint).containsKey(clazz)) {
			this.get(hint).put(clazz, new LinkedList<Map<S, String>>());
		}
	
		/*
		 * Finally, add the hint value...
		 */
		this.get(hint).get(clazz).add(hintValue);
	}
	
	/**
	 * This adds a list of hint values that are associated with a {@link SourceSectionClass} to this map.
	 * 
	 * @param hint The hint for which this value shall be added.
	 * @param clazz The source section class that the hint values are associated to.
	 * @param hintValues The values to be added to this map of hint values.
	 */
	public void addHintValues(K hint, SourceSectionClass clazz, LinkedList<Map<S, String>> hintValues) {
		
		/*
		 * Before we add anything, we make sure that every sub-map and -list is
		 * initialized so that we do not get any Exceptions.
		 */
		if (!this.containsKey(hint)) {
			this.init(hint);
		}

		if(!this.get(hint).containsKey(clazz)) {
			this.get(hint).put(clazz, new LinkedList<Map<S, String>>());
		}
	
		/*
		 * Finally, add the hint values...
		 */
		this.get(hint).get(clazz).addAll(hintValues);
	}
	
	/**
	 * This adds a hint value that is not associated with a {@link SourceSectionClass} to this map.
	 * 
	 * @param hint The hint for which this value shall be added.
	 * @param hintValue The value to be added to this map of hint values.
	 */
	public void addHintValue(K hint, Map<S, String> hintValue) {
		
		addHintValue(hint, null, hintValue);
	}
	
	/**
	 * This adds a list of hint values that are not associated with a {@link SourceSectionClass} to this map.
	 * 
	 * @param hint The hint for which this values shall be added.
	 * @param hintValues The values to be added to this map of hint values.
	 */
	public void addHintValues(K hint, LinkedList<Map<S, String>> hintValues) {
		
		addHintValues(hint, null, hintValues);
	}
	
	/**
	 * This sets the list of hint values that are not associated with a {@link SourceSectionClass} to this map.
	 * 
	 * @param hint The hint for which this values shall be set.
	 * @param hintValues The values to be set.
	 */
	public void setHintValues(K hint, LinkedList<Map<S, String>> hintValues) {
		
		/*
		 * Before we add anything, we make sure that every sub-map and -list is
		 * initialized so that we do not get any Exceptions.
		 */
		if (!this.containsKey(hint)) {
			this.init(hint);
		}

		this.get(hint).put(null, hintValues);
	}
	
	
	/**
	 * This returns the list of hint values that are associated with the given hint.
	 * 
	 * @param hint The hint for which the associated hint values shall be returned. 
	 * @return The list of hint values that are associated with the given hint (an empty list is
	 * returned if no hint value is associated).
	 */
	public LinkedList<Map<S, String>> getHintValues(K hint) {
		
		if(!this.containsKey(hint) || !this.get(hint).containsKey(null)) {
			return new LinkedList<>();
		} else {
			return this.get(hint).get(null);
		}
		
	}
}
