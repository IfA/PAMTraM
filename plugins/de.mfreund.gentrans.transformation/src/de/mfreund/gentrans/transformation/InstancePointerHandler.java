package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import pamtram.metamodel.SourceSectionClass;

/**
 * This class will be used to extract special described model objects
 * 
 * @author gkoltun
 */
 
 public class InstancePointerHandler{
	 
	 /**
	 * Registry for <em>source model objects</em> that have already been matched. The matched objects are stored in a map
	 * where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSections;
	 
	// Constructor
	public InstancePointerHandler(LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSections){
		this.matchedSections = matchedSections;
	}
	
	public ArrayList<EObject> getPointedInstance(EObject instancePointerObt, ArrayList<EObject> listObts){
		return listObts;
	}
	
	/**
	 * This method does an update of class variable matched sections.
	 * 
	 * @param matchedSections A list of a all matched sections
	 */
	public void updateMatchedSections(LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSections){
		this.matchedSections = matchedSections;
	}
}