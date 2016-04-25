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
 * This class will be used to get/extract specific model objects supported by model 'InstancePointers'
 * Note: There are two ways:
 * 1.) By 'matchedSection'-HashMap we get specific model objects (from global HashMap defined in the SourceSectionMatcher)
 * 2.) By List we extract specific model objects from a delivered list (so this method can be used everywhere inside generic transformation for minimize the number of specific /concretize model objects
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
	
	public EList<EObject> getPointedInstanceByMatchedSectionRepo(InstancePointer instPt, SourceSectionClass sourceClass){
		
		EList<EObject> correspondEclassInstances = new BasicEList<EObject>();
		
		if(matchedSections.get(sourceClass) != null){
			correspondEclassInstances.addAll(matchedSections.get(sourceClass));
		}
		if(tempMatchedSections.get(sourceClass) != null){
			correspondEclassInstances.addAll(tempMatchedSections.get(sourceClass));
		}
		
		String instancePointerRefValue = instPt.getValue();
		
		for(Iterator<EObject> element = correspondEclassInstances.iterator(); element.hasNext();){
			EObject eClass = element.next();
			
			SourceSectionAttribute sourceAttr = instPt.getAttributePointer();
			try{
				Object sourceRefAttr = eClass.eGet(instPt.getAttributePointer().getAttribute());
			
				// convert Attribute value to String
				final String sourceRefAttrAsString = sourceAttr.getAttribute().getEType().getEPackage().getEFactoryInstance()
						.convertToString(sourceAttr.getAttribute().getEAttributeType(), sourceRefAttr);
				
				if(!(sourceRefAttrAsString.equals(instancePointerRefValue))){
					element.remove();
				}
			} catch(final Exception e){
				consoleStream.println("Message:\n InstancePointerHander by Repositories failed because of:" + e.getMessage());
			}
		}
		return correspondEclassInstances;
	}
		
	public EList<EObject> getPointedInstanceByList(InstancePointer instPt, EList<EObject> ClassInstList){
		
		String instancePointerRefValue = instPt.getValue();
		
		for(Iterator<EObject> element = ClassInstList.iterator(); element.hasNext();){
			EObject eClass = element.next();
			
			SourceSectionAttribute sourceAttr = instPt.getAttributePointer();
			try{
				Object sourceRefAttr = eClass.eGet(instPt.getAttributePointer().getAttribute());
			
				// convert Attribute value to String
				final String sourceRefAttrAsString = sourceAttr.getAttribute().getEType().getEPackage().getEFactoryInstance()
						.convertToString(sourceAttr.getAttribute().getEAttributeType(), sourceRefAttr);
				
				if(!(sourceRefAttrAsString.equals(instancePointerRefValue))){
					element.remove();
				}
			} catch(final Exception e){
				consoleStream.println("Message:\n InstancePointerHander by Repositories failed because of:" + e.getMessage());
			}
		}
		return ClassInstList;
	}

	public void addTempSectionMap(LinkedHashMap<SourceSectionClass, Set<EObject>> tempMatchedSections) {
		this.tempMatchedSections = tempMatchedSections;
	}

	public void clearTempSectionMap() {
		this.tempMatchedSections.clear();
	}
}