package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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
	 * Registry for <em>source model objects</em> that have TEMPORARILY been matched. The matched objects are stored in a map
	 * where the key is the corresponding {@link SourceSectionClass} that they have been matched to.		 */
	private LinkedHashMap<SourceSectionClass, Set<EObject>> tempMatchedSections;
	
	/**
	 * The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	@SuppressWarnings("unused")
	private final MessageConsoleStream consoleStream;
	 
	// Constructor
	public InstancePointerHandler(LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSections, MessageConsoleStream consoleStream){
		this.matchedSections = matchedSections;
		this.consoleStream = consoleStream;
		this.tempMatchedSections = new LinkedHashMap<>();
	}
	
	public EList<EObject> getPointedInstanceByMatchedSectionRepo(InstancePointer instancePointerObt, SourceSectionClass sourceClass){
		
		EList<EObject> possiblePointedClasses = new BasicEList<EObject>();
		if(matchedSections.get(sourceClass) != null){
			possiblePointedClasses.addAll(matchedSections.get(sourceClass));
		}
		if(tempMatchedSections.get(sourceClass) != null){
			possiblePointedClasses.addAll(tempMatchedSections.get(sourceClass));
		}
		
		String instancePointerRefValue = instancePointerObt.getValue();
		
		for(Iterator<EObject> element = possiblePointedClasses.iterator(); element.hasNext();){
			
			EObject eClass = element.next();
			
			SourceSectionAttribute sourceAttr = instancePointerObt.getAttributePointer();
			Object sourceRefAttr = eClass.eGet(instancePointerObt.getAttributePointer().getAttribute());
			
			// convert Attribute value to String
			final String sourceRefAttrAsString = sourceAttr.getAttribute().getEType().getEPackage().getEFactoryInstance()
					.convertToString(sourceAttr.getAttribute().getEAttributeType(), sourceRefAttr);
			
			if(sourceRefAttrAsString.equals(instancePointerRefValue)){
				element.remove();
			}
		}
		return possiblePointedClasses;
	}
		
	public EList<EObject> getPointedInstanceByList(InstancePointer instancePointerObt, SourceSectionClass sourceClass, EList<EObject> ClassInstList){
		
		EList<EObject> possiblePointedClassesAsList = new BasicEList<EObject>();
		
		String instancePointerRefValue = instancePointerObt.getValue();
		
		for(Iterator<EObject> element = ClassInstList.iterator(); element.hasNext();){
			
			EObject eClass = element.next();
			
			SourceSectionAttribute sourceAttr = instancePointerObt.getAttributePointer();
			Object sourceRefAttr = eClass.eGet(instancePointerObt.getAttributePointer().getAttribute());
			
			// convert Attribute value to String
			final String sourceRefAttrAsString = sourceAttr.getAttribute().getEType().getEPackage().getEFactoryInstance()
					.convertToString(sourceAttr.getAttribute().getEAttributeType(), sourceRefAttr);
			
			if(sourceRefAttrAsString.equals(instancePointerRefValue)){
				element.remove();
			}
		}
		return possiblePointedClassesAsList;
	}

	public void addTempSectionMap(LinkedHashMap<SourceSectionClass, Set<EObject>> tempMatchedSections) {
		this.tempMatchedSections = tempMatchedSections;
	}

	public void clearTempSectionMap() {
		this.tempMatchedSections.clear();
	}
}