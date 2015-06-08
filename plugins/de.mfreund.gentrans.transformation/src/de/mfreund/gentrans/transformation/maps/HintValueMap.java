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
public abstract class HintValueMap<H extends EObject, V extends Object> extends HashMap<H, HashMap<SourceSectionClass, LinkedList<V>>> {

	private static final long serialVersionUID = 7863859419011070324L;

	/**
	 * This initializes this map.
	 * <p />
	 * Note: This is called automatically when hint values for a hint are to be stored that has
	 * not been initialized. However, this may be called manually to reset the list of hint values.
	 * 
	 * @param hint The mapping hint for which the collection of hint values shall be initialized.
	 */
	protected void init(H hint) {
		this.put(hint, new HashMap<SourceSectionClass, LinkedList<V>>());
	}
	
	/**
	 * This returns the list of hint values that are stored for the given hint.
	 * 
	 * @param hint The hint for which the stored hint values shall be returned.
	 * @return The list of hint values that are associated with the given hint (an empty list is
	 * returned if no hint value is associated).
	 */
	public LinkedList<V> getHintValues(H hint) {
		
		if(!this.containsKey(hint) || !this.get(hint).containsKey(null)) {
			return new LinkedList<>();
		} else {
			return this.get(hint).get(null);
		}
	}
	
	/**
	 * This adds a hint value that is associated with a {@link SourceSectionClass} to this map.
	 * 
	 * @param hint The hint for which this value shall be added.
	 * @param clazz The source section class that the hint value is associated to.
	 * @param hintValue The value to be added to this map of hint values.
	 */
	public void addHintValue(H hint, SourceSectionClass clazz, V value) {
		
		/*
		 * Before we add anything, we make sure that every sub-map and -list is
		 * initialized so that we do not get any Exceptions.
		 */
		if (!this.containsKey(hint)) {
			this.init(hint);
		}

		if(!this.get(hint).containsKey(clazz)) {
			this.get(hint).put(clazz, new LinkedList<V>());
		}
	
		/*
		 * Finally, add the hint value...
		 */
		this.get(hint).get(clazz).add(value);
	}
	
	/**
	 * This adds a list of hint values that are associated with a {@link SourceSectionClass} to this map.
	 * 
	 * @param hint The hint for which this value shall be added.
	 * @param clazz The source section class that the hint values are associated to.
	 * @param hintValues The values to be added to this map of hint values.
	 */
	public void addHintValues(H hint, SourceSectionClass clazz, LinkedList<V> values) {
		
		/*
		 * Before we add anything, we make sure that every sub-map and -list is
		 * initialized so that we do not get any Exceptions.
		 */
		if (!this.containsKey(hint)) {
			this.init(hint);
		}

		if(!this.get(hint).containsKey(clazz)) {
			this.get(hint).put(clazz, new LinkedList<V>());
		}
	
		/*
		 * Finally, add the hint values...
		 */
		this.get(hint).get(clazz).addAll(values);
	}
	
	/**
	 * This adds a hint value that is not associated with a {@link SourceSectionClass} to this map.
	 * 
	 * @param hint The hint for which this value shall be added.
	 * @param value The value to be added to this map of hint values.
	 */
	public void addHintValue(H hint, V value) {
		
		addHintValue(hint, null, value);
	}
	
	/**
	 * This adds a list of hint values that are not associated with a {@link SourceSectionClass} to this map.
	 * 
	 * @param hint The hint for which these values shall be added.
	 * @param values The values to be added to this map of hint values.
	 */
	public void addHintValues(H hint, LinkedList<V> values) {
		
		addHintValues(hint, null, values);
	}

	/**
	 * This adds all values that are stored in the given <em>hintValueMap</em> to this HintValueMap.
	 * 
	 * @param valueMap The map of hint values that shall be added to this HintValueMap.
	 */
	public void addHintValues(HintValueMap<H, V> valueMap) {
		
		/*
		 * Before we add anything, we make sure that every sub-map and -list is
		 * initialized so that we do not get any Exceptions.
		 */
		for (final H h : valueMap.keySet()) {
			if (!this.containsKey(h)) {
				this.init(h);
			}

			for (final SourceSectionClass c : valueMap.get(h).keySet()) {
				if (!this.get(h).containsKey(c)) {
					this.get(h).put(c, new LinkedList<V>());
				}
				
				/*
				 * Finally, add the hint values...
				 */
				this.get(h).get(c).addAll(valueMap.get(h).get(c));
			}
		}
	}

	/**
	 * This set the list of hint values in this map that are not associated with a {@link SourceSectionClass}.
	 * 
	 * @param hint The hint for which these values shall be set.
	 * @param values The values to be set.
	 */
	public void setHintValues(H hint, LinkedList<V> values) {
		
		/*
		 * Before we add anything, we make sure that every sub-map and -list is
		 * initialized so that we do not get any Exceptions.
		 */
		if (!this.containsKey(hint)) {
			this.init(hint);
		}

		this.get(hint).put(null, values);
	}
}
