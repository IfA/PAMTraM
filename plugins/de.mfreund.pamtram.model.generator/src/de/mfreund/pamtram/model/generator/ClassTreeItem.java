package de.mfreund.pamtram.model.generator;

import java.util.HashMap;

import org.eclipse.emf.common.util.EList;

import pamtram.metamodel.Class;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Attribute;

public class ClassTreeItem {

	private pamtram.metamodel.Class classObject;
	private Reference referenceObject;
	
	// private constructor to force using the factory methods
	private ClassTreeItem(){}
	
	public static ClassTreeItem createClassTreeItem(pamtram.metamodel.Class classObject, Reference referenceObject) {
		
		ClassTreeItem ret = createClassTreeItem(classObject);
		ret.setReferenceObject(referenceObject);

		return ret;
	}
	
	public static ClassTreeItem createClassTreeItem(pamtram.metamodel.Class classObject) {
		
		ClassTreeItem ret = new ClassTreeItem();
		ret.setClassObject(classObject);

		return ret;
		
	}
	
	public static ClassTreeItem[] createClassTreeItems(pamtram.metamodel.Class[] classObjects) {
		
		ClassTreeItem[] ret = new ClassTreeItem[classObjects.length];
		
		for (int i=0; i<classObjects.length; i++) {
			ret[i] = createClassTreeItem(classObjects[i]);
		}
		return ret;
	}
	
	public static ClassTreeItem[] createClassTreeItems(HashMap<pamtram.metamodel.Class, Reference> classObjectMap) {
		
		ClassTreeItem[] ret = new ClassTreeItem[classObjectMap.keySet().size()];
		
		for (int i=0; i<classObjectMap.keySet().size(); i++) {
			pamtram.metamodel.Class obj = (Class) classObjectMap.keySet().toArray()[i];
			ret[i] = createClassTreeItem(obj, classObjectMap.get(obj));
		}
		return ret;
	}
	
	public pamtram.metamodel.Class getClassObject() {
		return classObject;
	}
	public void setClassObject(pamtram.metamodel.Class classObject) {
		this.classObject = classObject;
	}
	public Reference getReferenceObject() {
		return referenceObject;
	}
	public void setReferenceObject(Reference referenceObject) {
		this.referenceObject = referenceObject;
	}
	public EList<Reference> getReferences() {
		return classObject.getReferences();
	}
	public EList<Attribute> getAttributes() {
		return classObject.getAttributes();
	}
}
