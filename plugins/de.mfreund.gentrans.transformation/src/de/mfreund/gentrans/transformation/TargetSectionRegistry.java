package de.mfreund.gentrans.transformation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import pamtram.mapping.MappingHintGroup;
import pamtram.metamodel.Class;

public class TargetSectionRegistry {

	public HashMap<EClass, LinkedList<EObjectTransformationHelper>> getTargetClassInstanceRegistry() {
		return targetClassInstanceRegistry;
	}

	public HashMap<Class, HashMap<MappingHintGroup, LinkedList<EObjectTransformationHelper>>> getTargetClassInstanceByHintGroupRegistry() {
		return targetClassInstanceByHintGroupRegistry;
	}

	public HashMap<EClass, HashSet<EClass>> getChildClassesRegistry() {
		return childClassesRegistry;
	}

	public HashMap<EClass, HashSet<Path>> getPossiblePathsRegistry() {
		return possiblePathsRegistry;
	}

	public HashMap<EClass, HashSet<EReference>> getTargetClassReferencesRegistry() {
		return targetClassReferencesRegistry;
	}

	public HashMap<EReference, HashSet<EClass>> getReferenceSourcesRegistry() {
		return referenceSourcesRegistry;
	}

	private  HashMap<EClass, LinkedList<EObjectTransformationHelper>> targetClassInstanceRegistry;
	private  HashMap<Class, HashMap<MappingHintGroup, LinkedList<EObjectTransformationHelper>>> targetClassInstanceByHintGroupRegistry;
	private  HashMap<EClass, HashSet<EClass>> childClassesRegistry;
	private  HashMap<EClass, HashSet<Path>> possiblePathsRegistry;
	private  HashMap<EClass, HashSet<EReference>> targetClassReferencesRegistry; // ==refsToThis
	private  HashMap<EReference, HashSet<EClass>> referenceSourcesRegistry; // ==sources

	public TargetSectionRegistry() {
		targetClassInstanceRegistry= new HashMap<EClass, LinkedList<EObjectTransformationHelper>>();
		targetClassInstanceByHintGroupRegistry = new HashMap<Class, HashMap<MappingHintGroup, LinkedList<EObjectTransformationHelper>>>();
		childClassesRegistry= new HashMap<EClass, HashSet<EClass>>();
		possiblePathsRegistry= new HashMap<EClass, HashSet<Path>>();
		targetClassReferencesRegistry= new HashMap<EClass, HashSet<EReference>>(); // ==refsToThis
		referenceSourcesRegistry=new HashMap<EReference, HashSet<EClass>>(); // ==sources
	}
	
	
	public void addClassInstance(EObjectTransformationHelper instance, MappingHintGroup group,
			Class targetSection) {
		EClass eClass = instance.getEObject().eClass();

		if (!targetClassInstanceRegistry.containsKey(eClass)) {
			targetClassInstanceRegistry.put(eClass, new LinkedList<EObjectTransformationHelper>());
		}
		targetClassInstanceRegistry.get(eClass).add(instance);

		if (!targetClassInstanceByHintGroupRegistry.containsKey(targetSection)) {
			targetClassInstanceByHintGroupRegistry.put(targetSection,
					new HashMap<MappingHintGroup, LinkedList<EObjectTransformationHelper>>());
		}

		if (!targetClassInstanceByHintGroupRegistry.get(targetSection)
				.containsKey(group)) {
			targetClassInstanceByHintGroupRegistry.get(targetSection).put(
					group, new LinkedList<EObjectTransformationHelper>());
		}

		targetClassInstanceByHintGroupRegistry.get(targetSection).get(group)
				.add(instance);

	}

	public void addClassInstance(EObjectTransformationHelper instance) {
		EClass eClass = instance.getEObject().eClass();

		if (!targetClassInstanceRegistry.containsKey(eClass)) {
			targetClassInstanceRegistry.put(eClass, new LinkedList<EObjectTransformationHelper>());
		}
		targetClassInstanceRegistry.get(eClass).add(instance);

	}
	
	public  LinkedList<EObjectTransformationHelper> getTargetClassInstances(EClass eClass) {

		return targetClassInstanceRegistry.containsKey(eClass) ? targetClassInstanceRegistry
				.get(eClass) : new LinkedList<EObjectTransformationHelper>();
	}

	public  HashMap<MappingHintGroup, LinkedList<EObjectTransformationHelper>> getPamtramClassInstances(
			Class c) {
		if (!targetClassInstanceByHintGroupRegistry.containsKey(c)) {
			return new HashMap<MappingHintGroup, LinkedList<EObjectTransformationHelper>>();
		}

		return targetClassInstanceByHintGroupRegistry.get(c);

	}
	
	public  LinkedList<EObjectTransformationHelper> getFlattenedPamtramClassInstances(Class c) {
		LinkedList<EObjectTransformationHelper> flat = new LinkedList<EObjectTransformationHelper>();
		if (!targetClassInstanceByHintGroupRegistry.containsKey(c)) {
			return flat;
		}

		for (LinkedList<EObjectTransformationHelper> l : targetClassInstanceByHintGroupRegistry
				.get(c).values()) {
			flat.addAll(l);
		}

		return flat;

	}
	
	public  void addPath(Path path, EClass eClass) {

		if (!possiblePathsRegistry.containsKey(eClass)) {
			possiblePathsRegistry.put(eClass, new HashSet<Path>());
		}
		possiblePathsRegistry.get(eClass).add(path);

	}

	public  HashSet<EClass> getChildClasses(EClass eClass) {

		return childClassesRegistry.containsKey(eClass) ? childClassesRegistry
				.get(eClass) : new HashSet<EClass>();

	}

	public  HashSet<EReference> getClassReferences(EClass eClass) {

		return targetClassReferencesRegistry.containsKey(eClass) ? targetClassReferencesRegistry
				.get(eClass) : new HashSet<EReference>();

	}

	public  HashSet<EClass> getReferenceSources(EReference ref) {
		return referenceSourcesRegistry.containsKey(ref) ? referenceSourcesRegistry
				.get(ref) : new HashSet<EClass>();

	}
	
	private LinkedList<EClass> getClasses(EPackage pkg){
		LinkedList<EClass> classes=new LinkedList<EClass>();
		
		for(EClassifier c : pkg.getEClassifiers()){
			if(c instanceof EClass){
				classes.add((EClass) c);
				
				childClassesRegistry.put((EClass) c, new HashSet<EClass>());
				targetClassReferencesRegistry.put((EClass) c,
						new HashSet<EReference>());
			}
		}
		
		for(EPackage p : pkg.getESubpackages()){
			classes.addAll(getClasses(p));
		}
		
		
		return classes;
	}

	public  void analyseTargetMetaModel(EPackage targetMetaModel) {
		// Map targetMetaModel classes
		
		System.out.println("Mapping targetMetaModel classes");
		LinkedList<EClass> classesToAnalyse=getClasses(targetMetaModel);
		
		// map supertypes
		System.out
				.println("Mapping targetMetaModel inheritance and containment relationships");
		for (EClass e : classesToAnalyse) {
			for (EClass s : e.getEAllSuperTypes()) {
				childClassesRegistry.get(s).add(e);
			}
		}

		// register references that lead to a certain class for each class
		System.out.println("Mapping targetMetaModel containment relationships");
		for (EClass e : classesToAnalyse) {
			for (EReference c : e.getEAllContainments()) {
				if (targetClassReferencesRegistry.containsKey(c
						.getEReferenceType())) {
					if (!referenceSourcesRegistry.containsKey(c)) {
						referenceSourcesRegistry.put(c, new HashSet<EClass>());
					}
					referenceSourcesRegistry.get(c).add(e);
					targetClassReferencesRegistry.get(c.getEReferenceType())
							.add(c);
				} else {
					System.out.println("Ignoring targetMetaModel reference "
							+ c.getName() + " of element " + e.getName() + " "
							+ c.getEReferenceType().getName() + " "
							+ c.getEType().getName());
				}
			}
		}

		// add inherited containment refs
		for (EClass e : classesToAnalyse) {
			for (EClass c : childClassesRegistry.get(e)) {// e.~childClasses){
				targetClassReferencesRegistry.get(c).addAll(
						targetClassReferencesRegistry.get(e));
			}
		}

	}

	public  HashSet<Path> getPaths(EClass eClass) {
		if (!possiblePathsRegistry.containsKey(eClass)) {
			possiblePathsRegistry.put(eClass, new HashSet<Path>());

			new Path(this).findPathsToInstances(eClass);
		}

		return possiblePathsRegistry.get(eClass);

	}

}
