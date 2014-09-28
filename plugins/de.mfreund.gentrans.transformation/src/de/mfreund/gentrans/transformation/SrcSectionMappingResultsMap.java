package de.mfreund.gentrans.transformation;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import pamtram.metamodel.SourceSectionClass;

/**
 * Extended MAp with some helper functions used when mapping the source model.
 * @author Sascha Steffen
 * @version 0.9
 */
class SrcSectionMappingResultsMap extends LinkedHashMap<SourceSectionClass, LinkedList<MappingInstanceStorage>>{

	private static final long serialVersionUID = 7525832913063032464L;

	/**
	 * Constructor
	 */
	public SrcSectionMappingResultsMap(){
		super();
	}
	
	/**
	 * Finds the Smallest of the stored lists
	 * @return key for List value with smallest size
	 */
	public  SourceSectionClass getKeyForValueWithSmallestCollectionSize(){
		SourceSectionClass keyForSmallest=null;
		int smallestSize=-1;
		for(SourceSectionClass key : this.keySet()){
			if(this.get(key).size() < smallestSize || keyForSmallest == null){
				keyForSmallest=key;
				smallestSize=this.get(key).size();
			}
		}
		return keyForSmallest;
	}

	/**
	 * Remove the specified MAppingInstancestorage from the lists
	 * @param srcSectionResult
	 */
	void removeResultsForElement(
			MappingInstanceStorage srcSectionResult) {
		for(SourceSectionClass key : this.keySet()) //remove srcModel element from possibility lists of MMSections
		{
			for(MappingInstanceStorage s : this.get(key)){
				if(s.getAssociatedSourceModelElement().equals(srcSectionResult.getAssociatedSourceModelElement())){
					this.get(key).remove(s);
					break;
				}
			}	
		}
		
	}

}
