package de.mfreund.gentrans.transformation;

import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;

public class SrcSectionMappingResultsMap extends HashMap<pamtram.metamodel.Class, LinkedList<MappingInstanceStorage>>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7525832913063032464L;

	public SrcSectionMappingResultsMap(){
		super();
	}
	
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

	public void removeResultsForElement(
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
	
	 public int getNumberOfPossibleUses(EObject possibleSrcModelElement ) {
			int uses = 0;
			for(LinkedList<MappingInstanceStorage> storeList : this.values()){
				for(MappingInstanceStorage store : storeList){
					if(store.getAssociatedSourceModelElement().equals(possibleSrcModelElement)){
						uses++;
					}
				}
			}
			return uses;
	}

}
