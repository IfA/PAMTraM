package de.mfreund.gentrans.transformation;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Extended MAp with some helper functions used when mapping the source model.
 * @author Sascha Steffen
 * @version 0.8
 */
class SrcSectionMappingResultsMap extends LinkedHashMap<pamtram.metamodel.Class, LinkedList<MappingInstanceStorage>>{

	private static final long serialVersionUID = 7525832913063032464L;

	/**
	 * Consttructor
	 */
	public SrcSectionMappingResultsMap(){
		super();
	}
	
	/**
	 * Finds the Smallest of the stored lists
	 * @return key for List value with smallest size
	 */
	public  pamtram.metamodel.Class getKeyForValueWithSmallestCollectionSize(){
		pamtram.metamodel.Class keyForSmallest=null;
		int smallestSize=-1;
		for(pamtram.metamodel.Class key : this.keySet()){
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
		for(pamtram.metamodel.Class key : this.keySet()) //remove srcModel element from possibility lists of MMSections
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
