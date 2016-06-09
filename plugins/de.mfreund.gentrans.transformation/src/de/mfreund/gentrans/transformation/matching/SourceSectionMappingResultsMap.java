package de.mfreund.gentrans.transformation.matching;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import pamtram.metamodel.SourceSectionClass;

/**
 * Extended Map with some helper functions used when matching the source model.
 *
 * @author mfreund
 */
class SourceSectionMatchingResultsMap extends LinkedHashMap<SourceSectionClass, LinkedList<MatchedSectionDescriptor>> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5790045415437517507L;

	/**
	 * Finds the Smallest of the stored lists
	 *
	 * @return key for List value with smallest size
	 */
	public SourceSectionClass getKeyForValueWithSmallestCollectionSize() {
		SourceSectionClass keyForSmallest = null;
		int smallestSize = -1;
		for (final SourceSectionClass key : keySet()) {
			if (get(key).size() < smallestSize || keyForSmallest == null) {
				keyForSmallest = key;
				smallestSize = get(key).size();
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
		for (final SourceSectionClass key : keySet()) // remove srcModel element
			// from possibility
			// lists of MMSections
		{
			for (final MatchedSectionDescriptor s : get(key)) {
				if (s.getAssociatedSourceModelElement().equals(
						descriptor.getAssociatedSourceModelElement())) {
					get(key).remove(s);
					break;
				}
			}
		}

	}

}
