/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.descriptors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pamtram.mapping.extended.MappingHint;

/**
 * This class provides a storage for extracted values of {@link MappingHint MappingHints}.
 *
 * @author mfreund
 */
public class HintValueStorage {

	/**
	 * This keeps track of the hint values for all {@link MappingHint MappingHints}.
	 */
	private final Map<MappingHint, List<String>> hintValues;

	/**
	 * In order to be able to provide a stateful access to the {@link #hintValues} (e.g. from
	 * {@link #getNextHintValue(MappingHint)}), this map is used to remember the the last of the accessed values for
	 * each {@link MappingHint}.
	 */
	private final Map<MappingHint, Integer> hintValuePointer;

	/**
	 * This creates an instance.
	 *
	 */
	public HintValueStorage() {

		this.hintValues = Collections.synchronizedMap(new HashMap<>());
		this.hintValuePointer = Collections.synchronizedMap(new HashMap<>());
	}

	/**
	 * This returns a copy of the internal {@link #hintValues}.
	 * <p />
	 * Note: Changes to the returned map will not change the {@link #hintValues} managed by this storage.
	 *
	 * @return A copy of the {@link #hintValues}.
	 */
	public Map<MappingHint, List<String>> getHintValues() {

		return new HashMap<>(this.hintValues);
	}

	/**
	 * This returns the list of stored values for the given {@link MappingHint}.
	 *
	 * @param hint
	 *            The hint for which the stored values shall be returned.
	 * @return The stored values for the given {@link MappingHint} or an empty list if no values are stored for the
	 *         given hint.
	 */
	public List<String> getHintValues(MappingHint hint) {

		return this.hintValues.containsKey(hint) ? new ArrayList<>(this.hintValues.get(hint)) : new ArrayList<>();
	}

	/**
	 * Returns the <em>next</em> stored value for the given {@link MappingHint}.
	 * <p />
	 * Note: The internal {@link #hintValuePointer} is used to determine the <em>next</em> value. If this has reached
	 * the end of the stored values for the given hint, it will start again at the beginning. Consequently, this can
	 * safely be called more often than there are stored values for a certain hint.
	 *
	 * @param hint
	 *            The hint for which the next stored value shall be returned.
	 * @return The next stored value for the given {@link MappingHint} or '<em>null</em>' if no values are stored for
	 *         the given hint.
	 */
	public synchronized String getNextHintValue(MappingHint hint) {

		if (!this.hintValues.containsKey(hint)) {
			return null;
		}

		int newPointer = this.hintValuePointer.containsKey(hint) ? this.hintValuePointer.get(hint) + 1 : 0;

		if (newPointer == this.hintValues.get(hint).size()) {
			newPointer = 0;
		}

		String hintValue = this.hintValues.get(hint).get(newPointer);

		this.hintValuePointer.put(hint, newPointer);

		return hintValue;
	}

	/**
	 * This adds a single value to the storage.
	 *
	 * @param hint
	 *            The {@link MappingHint} for that the value shall be added.
	 * @param value
	 *            The value to be added.
	 */
	public synchronized void addHintValue(MappingHint hint, String value) {

		this.addHintValues(hint, Arrays.asList(value));
	}

	/**
	 * This adds a list of values to the storage.
	 *
	 * @param hint
	 *            The {@link MappingHint} for that the values shall be added.
	 * @param values
	 *            The values to be added.
	 */
	public synchronized void addHintValues(MappingHint hint, List<String> values) {

		if (!this.containsHint(hint)) {
			this.setHintValues(hint, new ArrayList<>());
		}

		this.hintValues.get(hint).addAll(values);
	}

	/**
	 * This adds the values stored in another {@link HintValueStorage} to this storage.
	 *
	 * @param hintValuesToAdd
	 *            The {@link HintValueStorage} that contains the hint values to add.
	 */
	public synchronized void addHintValues(HintValueStorage hintValuesToAdd) {

		this.hintValues.putAll(hintValuesToAdd.getHintValues());
	}

	/**
	 * This sets the list of stored values for the given {@link MappingHint}.
	 *
	 * @param hint
	 *            The {@link MappingHint} for that the value shall be set.
	 * @param values
	 *            The values to be set.
	 */
	public synchronized void setHintValues(MappingHint hint, List<String> values) {

		this.hintValues.put(hint, values);
	}

	/**
	 * This checks whether any values are stored for the given {@link MappingHint}.
	 *
	 * @param hint
	 *            The hint that shall be checked.
	 * @return '<em>True</em>' if the given <em>hint</em> is contained in the storage, '<em>false</em>' otherwise
	 * @throws ClassCastException
	 *             if the concrete type of the <em>value</em> is not in line with the type of the <em>hint</em>.
	 */
	public boolean containsHint(MappingHint hint) {

		return this.hintValues.containsKey(hint);
	}
}
