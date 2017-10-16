package de.mfreund.gentrans.transformation.maps;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EObject;

import pamtram.structure.source.SourceSectionClass;

/**
 * This base class represents a map that allows to collect hint values for
 * mapping hints.
 * <p />
 * Thereby, the stored hint values are associated with the <em>mapping hint</em>
 * and (optionally) the <em>{@link SourceSectionClass}</em> that they belong to.
 *
 * @author mfreund
 *
 * @param <H>
 *            The concrete type of hints to be stored in the map.
 * @param <V>
 *            The concrete type of values to be stored in the map.
 */
public class HintValueMap<H extends EObject, V extends Object>
		extends LinkedHashMap<H, LinkedHashMap<SourceSectionClass, LinkedList<V>>> {

	private static final long serialVersionUID = 7863859419011070324L;

	/**
	 * This initializes this map. Optionally, an {@link #createEmptyValue()
	 * empty value} is added to the list of hint values.
	 * <p />
	 * Note: This is called automatically when hint values for a hint are to be
	 * stored that has not been initialized. However, this may be called
	 * manually to reset the list of hint values.
	 *
	 * @param hint
	 *            The mapping hint for which the collection of hint values shall
	 *            be initialized.
	 * @param addEmptyValue
	 *            Whether an {@link #createEmptyValue() empty value} shall be
	 *            added to the list.
	 */
	public void init(H hint, boolean addEmptyValue) {

		this.put(hint, new LinkedHashMap<SourceSectionClass, LinkedList<V>>());
		LinkedList<V> values = new LinkedList<>();
		if (addEmptyValue) {
			values.add(this.createEmptyValue());
		}
		this.get(hint).put(null, values);
	}

	/**
	 * This creates an {@link #createEmptyValue() empty value}. The default
	 * implementation of 'empty value' returns <em>null</em> but special
	 * definitions may be provided by implementing sub-classes. In most cases.
	 *
	 * @return An 'empty value'.
	 */
	protected V createEmptyValue() {

		return null;
	}

	/**
	 * This returns the list of hint values that are stored for the given hint.
	 *
	 * @param hint
	 *            The hint for which the stored hint values shall be returned.
	 * @return The list of hint values that are associated with the given hint
	 *         (an empty list is returned if no hint value is associated).
	 */
	public LinkedList<V> getHintValues(H hint) {

		if (!this.containsKey(hint)) {
			this.init(hint, false);
		}

		return this.get(hint).get(null);
	}

	/**
	 * This returns the list of hint values that are stored for the given hint
	 * and a certain {@link SourceSectionClass}.
	 *
	 * @param hint
	 *            The <em>hint</em> for which the stored hint values shall be
	 *            returned.
	 * @param clazz
	 *            The {@link SourceSectionClass} for which the stored hint
	 *            values shall be returned.
	 * @return The list of hint values that are associated with the given hint
	 *         and clazz (an empty list is returned if no hint value is
	 *         associated).
	 */
	public LinkedList<V> getHintValues(H hint, SourceSectionClass clazz) {

		if (!this.containsKey(hint)) {
			this.init(hint, false);
		}

		return this.get(hint).get(clazz);
	}

	/**
	 * This adds a hint value that is associated with a
	 * {@link SourceSectionClass} to this map.
	 *
	 * @param hint
	 *            The <em>hint</em> for which this value shall be added.
	 * @param clazz
	 *            The {@link SourceSectionClass} that the hint value is
	 *            associated to.
	 * @param value
	 *            The <em>value</em> to be added to this map of hint values.
	 */
	public void addHintValue(H hint, SourceSectionClass clazz, V value) {

		/*
		 * Before we add anything, we make sure that every sub-map and -list is
		 * initialized so that we do not get any Exceptions.
		 */
		if (!this.containsKey(hint)) {
			this.init(hint, false);
		}

		if (!this.get(hint).containsKey(clazz)) {
			this.get(hint).put(clazz, new LinkedList<V>());
		}

		/*
		 * Finally, add the hint value...
		 */
		this.get(hint).get(clazz).add(value);
	}

	/**
	 * This adds a list of hint values that are associated with a
	 * {@link SourceSectionClass} to this map.
	 *
	 * @param hint
	 *            The <em>hint</em> for which this value shall be added.
	 * @param clazz
	 *            The {@link SourceSectionClass} that the hint values are
	 *            associated to.
	 * @param values
	 *            The <em>values</em> to be added to this map of hint values.
	 */
	public void addHintValues(H hint, SourceSectionClass clazz, LinkedList<V> values) {

		/*
		 * Before we add anything, we make sure that every sub-map and -list is
		 * initialized so that we do not get any Exceptions.
		 */
		if (!this.containsKey(hint)) {
			this.init(hint, false);
		}

		if (!this.get(hint).containsKey(clazz)) {
			this.get(hint).put(clazz, new LinkedList<V>());
		}

		/*
		 * Finally, add the hint values...
		 */
		this.get(hint).get(clazz).addAll(values);
	}

	/**
	 * This adds a hint value that is not associated with a
	 * {@link SourceSectionClass} to this map.
	 *
	 * @param hint
	 *            The <em>hint</em> for which this value shall be added.
	 * @param value
	 *            The <em>value</em> to be added to this map of hint values.
	 */
	public void addHintValue(H hint, V value) {

		this.addHintValue(hint, null, value);
	}

	/**
	 * This adds a list of hint values that are not associated with a
	 * {@link SourceSectionClass} to this map.
	 *
	 * @param hint
	 *            The <em>hint</em> for which these values shall be added.
	 * @param values
	 *            The <em>values</em> to be added to this map of hint values.
	 */
	public void addHintValues(H hint, LinkedList<V> values) {

		this.addHintValues(hint, null, values);
	}

	/**
	 * This adds all values that are stored in the given {@link HintValueMap} to
	 * this map.
	 *
	 * @param valueMap
	 *            The map of hint values that shall be added to this
	 *            HintValueMap.
	 */
	public void addHintValues(HintValueMap<H, V> valueMap) {

		/*
		 * Before we add anything, we make sure that every sub-map and -list is
		 * initialized so that we do not get any Exceptions.
		 */
		for (final H h : valueMap.keySet()) {
			if (!this.containsKey(h)) {
				this.init(h, false);
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
	 * This set the list of hint values in this map that are associated with a
	 * {@link SourceSectionClass}.
	 *
	 * @param hint
	 *            The <em>hint</em> for which these values shall be set.
	 * @param clazz
	 *            The {@link SourceSectionClass} that the hint values are
	 *            associated to.
	 * @param values
	 *            The <em>values</em> to be set. If <em>null</em> is passed, an
	 *            empty list is set as values.
	 */
	public void setHintValues(H hint, SourceSectionClass clazz, LinkedList<V> values) {

		/*
		 * Before we add anything, we make sure that every sub-map and -list is
		 * initialized so that we do not get any Exceptions.
		 */
		if (!this.containsKey(hint)) {
			this.init(hint, false);
		}

		this.get(hint).put(clazz, values == null ? new LinkedList<V>() : values);
	}

	/**
	 * This set the list of hint values in this map that are <b>not</b>
	 * associated with a {@link SourceSectionClass}.
	 *
	 * @param hint
	 *            The <em>hint</em> for which these values shall be set.
	 * @param values
	 *            The <em>values</em> to be set. If <em>null</em> is passed, an
	 *            empty list is set as values.
	 */
	public void setHintValues(H hint, LinkedList<V> values) {

		this.setHintValues(hint, null, values);
	}

	/**
	 * This retrieves and removes the first hint value stored for a given
	 * <em>hint</em>.
	 *
	 * @param hint
	 *            The <em>hint</em> for which the first hint value shall be
	 *            retrieved and removed.
	 * @return The removed hint value.
	 * @throws NoSuchElementException
	 *             If no hint value is stored for the given <em>hint</em>.
	 */
	public V removeHintValue(H hint) {

		return this.getHintValues(hint).remove();
	}
}
