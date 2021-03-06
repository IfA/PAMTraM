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
package de.mfreund.gentrans.transformation.maps;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import pamtram.structure.source.SourceSectionClass;

/**
 * Extended Map with some helper functions used when matching the source model.
 *
 * @author mfreund
 */
public class SourceSectionMatchingResultsMap
extends LinkedHashMap<SourceSectionClass, LinkedList<MatchedSectionDescriptor>> {


	/**
	 *
	 */
	private static final long serialVersionUID = -5790045415437517507L;

	/**
	 * Initialize the map entry for the given <em>key</em>.
	 *
	 * @param key
	 *            The {@link SourceSectionClass} representing the key to init.
	 */
	public void init(SourceSectionClass key) {

		this.put(key, new LinkedList<>());
	}

	/**
	 * Finds the Smallest of the stored lists
	 *
	 * @return key for List value with smallest size
	 */
	public SourceSectionClass getKeyForValueWithSmallestCollectionSize() {
		SourceSectionClass keyForSmallest = null;
		int smallestSize = -1;
		for (final SourceSectionClass key : this.keySet()) {
			if (this.get(key).size() < smallestSize || keyForSmallest == null) {
				keyForSmallest = key;
				smallestSize = this.get(key).size();
			}
		}
		return keyForSmallest;
	}

	/**
	 * Remove the specified {@link MatchedSectionDescriptor} from the lists
	 *
	 * @param descriptor
	 */
	public void removeResultsForElement(final MatchedSectionDescriptor descriptor) {
		for (final SourceSectionClass key : this.keySet()) // remove srcModel element
			// from possibility
			// lists of MMSections
		{
			for (final MatchedSectionDescriptor s : this.get(key)) {
				if (s.getAssociatedSourceModelElement().equals(
						descriptor.getAssociatedSourceModelElement())) {
					this.get(key).remove(s);
					break;
				}
			}
		}

	}

}
