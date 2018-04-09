/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.maps;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.ecore.EObject;

import pamtram.structure.DynamicSourceElement;
import pamtram.structure.source.SourceSectionAttribute;

/**
 * This is used to manage the model-unique IDs of element-attribute combinations used in case
 * {@link DynamicSourceElement#isUseElementID()} is set to '<em>true/<em>'.
 * <p />
 * Note: A unique ID is assigned for each combination of {@link EObject} and {@link SourceSectionAttribute}.
 *
 * @author mfreund
 */
public class ElementIDMap {

	/**
	 * The internal map storing assigned IDs.
	 */
	protected Map<EObject, Map<SourceSectionAttribute, Integer>> internalMap;

	/**
	 * The last id that was assigned.
	 */
	protected int currentElementID;

	/**
	 * This creates an instance and initializes the {@link #currentElementID} with 0.
	 */
	public ElementIDMap() {

		this.internalMap = new ConcurrentHashMap<>();
		this.currentElementID = 0;
	}

	/**
	 * Whether the given combination of {@link EObject} and {@link SourceSectionAttribute} is already present in this
	 * map.
	 *
	 * @param element
	 * @param attribute
	 * @return '<em>true</em>' if the combination is present; '<em>false</em>' otherwise.
	 */
	public boolean containsID(EObject element, SourceSectionAttribute attribute) {

		return this.internalMap.getOrDefault(element, new ConcurrentHashMap<>()).containsKey(attribute);
	}

	/**
	 * Returns the ID associated with the given combination of {@link EObject} and {@link SourceSectionAttribute}. If no
	 * ID has been associated yet, associates a new one.
	 *
	 * @param element
	 * @param attribute
	 * @return The (existing or newly assigned) associated ID.
	 */
	public int getID(EObject element, SourceSectionAttribute attribute) {

		if (!this.containsID(element, attribute)) {
			synchronized (this) {
				this.currentElementID++;
				Map<SourceSectionAttribute, Integer> elementMap = this.internalMap.getOrDefault(element, new ConcurrentHashMap<>());
				elementMap.put(attribute, this.currentElementID);
				this.internalMap.put(element, elementMap);
			}
		}

		return this.internalMap.get(element).get(attribute);
	}

}
