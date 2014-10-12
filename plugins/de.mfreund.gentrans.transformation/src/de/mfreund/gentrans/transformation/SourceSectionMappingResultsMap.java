package de.mfreund.gentrans.transformation;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import pamtram.metamodel.SourceSectionClass;

/**
 * Extended Map with some helper functions used when mapping the source model.
 * 
 * @author Sascha Steffen
 * @version 1.0
 */
class SourceSectionMappingResultsMap extends
		LinkedHashMap<SourceSectionClass, LinkedList<MappingInstanceStorage>> {

	private static final long serialVersionUID = 7525832913063032464L;

	/**
	 * Constructor
	 */
	public SourceSectionMappingResultsMap() {
		super();
	}

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
	 * Remove the specified MAppingInstancestorage from the lists
	 * 
	 * @param srcSectionResult
	 */
	void removeResultsForElement(final MappingInstanceStorage srcSectionResult) {
		for (final SourceSectionClass key : keySet()) // remove srcModel element
														// from possibility
														// lists of MMSections
		{
			for (final MappingInstanceStorage s : get(key)) {
				if (s.getAssociatedSourceModelElement().equals(
						srcSectionResult.getAssociatedSourceModelElement())) {
					get(key).remove(s);
					break;
				}
			}
		}

	}

}
