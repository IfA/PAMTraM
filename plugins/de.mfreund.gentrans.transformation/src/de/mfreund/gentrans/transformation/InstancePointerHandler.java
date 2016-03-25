package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.SourceSectionAttribute;
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
	
	/**
	 * The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	private final MessageConsoleStream consoleStream;
	 
	// Constructor
	public InstancePointerHandler(LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSections, MessageConsoleStream consoleStream){
		this.matchedSections = matchedSections;
		this.consoleStream =consoleStream;
	}
	
	public EObject getPointedInstanceByMatchedSectionRepo(InstancePointer instancePointerObt, SourceSectionAttribute sourceAttribute){
		
		Set<EObject> possiblePointedClasses = matchedSections.get(sourceAttribute.eContainer());
		// alternatively we get the container-Class by the InstancePointer pointed EAttribute
		//Set<EObject> possiblePointedClasses = matchedSections.get(instancePointerObt.getAttributePointer().eContainer());
		
		for(Iterator<EObject> element = possiblePointedClasses.iterator(); element.hasNext();){
			EObject eClass = element.next();
			
			if(!(eClass.eGet((EStructuralFeature) instancePointerObt.getAttributePointer()).equals(instancePointerObt.getValue()))){
				element.remove();
			}
		}
		
		if(possiblePointedClasses.size()==1){
			return possiblePointedClasses.iterator().next();
		} else {
			consoleStream.println("InstancePointer result is not clear! The correspond set is of size:" + possiblePointedClasses.size()
			+ "\n");
			return null;
		}
	}
		
	public EObject getPointedInstanceByList(InstancePointer instancePointerObt, SourceSectionAttribute sourceAttribute, ArrayList<EObject> attrList){
		
		for(Iterator<EObject> element = attrList.iterator(); element.hasNext();){
			EObject eAttr = element.next();
			EObject eClass = eAttr.eContainer();
			
			if(!(eClass.eGet((EStructuralFeature) instancePointerObt.getAttributePointer()).equals(instancePointerObt.getValue()))){
				element.remove();
			}
		}
		
		if(attrList.size()==1){
			return attrList.iterator().next();
		} else {
			consoleStream.println("InstancePointer result is not clear! The correspond set is of size:" + attrList.size()
			+ "\n");
			return null;
		}
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