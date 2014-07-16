package de.mfreund.gentrans.transformation;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import pamtram.mapping.MappingHintGroup;
import pamtram.metamodel.TargetSectionClass;

public class TargetSectionRegistry {

	public LinkedHashMap<EClass, LinkedList<EObjectTransformationHelper>> getTargetClassInstanceRegistry() {
		return targetClassInstanceRegistry;
	}

	public LinkedHashMap<TargetSectionClass, LinkedHashMap<MappingHintGroup, LinkedList<EObjectTransformationHelper>>> getTargetClassInstanceByHintGroupRegistry() {
		return targetClassInstanceByHintGroupRegistry;
	}

	public LinkedHashMap<EClass, LinkedHashSet<EClass>> getChildClassesRegistry() {
		return childClassesRegistry;
	}

	public LinkedHashMap<EClass, LinkedHashSet<ModelConnectionPath>> getPossiblePathsRegistry() {
		return possiblePathsRegistry;
	}

	public LinkedHashMap<EClass, LinkedHashSet<EReference>> getTargetClassReferencesRegistry() {
		return targetClassReferencesRegistry;
	}

	public LinkedHashMap<EReference, LinkedHashSet<EClass>> getReferenceSourcesRegistry() {
		return referenceSourcesRegistry;
	}

	private  LinkedHashMap<EClass, LinkedList<EObjectTransformationHelper>> targetClassInstanceRegistry;
	private  LinkedHashMap<TargetSectionClass, LinkedHashMap<MappingHintGroup, LinkedList<EObjectTransformationHelper>>> targetClassInstanceByHintGroupRegistry;
	private  LinkedHashMap<EClass, LinkedHashSet<EClass>> childClassesRegistry;
	private  LinkedHashMap<EClass, LinkedHashSet<ModelConnectionPath>> possiblePathsRegistry;
	private  LinkedHashMap<EClass, LinkedHashSet<EReference>> targetClassReferencesRegistry; // ==refsToThis
	private  LinkedHashMap<EReference, LinkedHashSet<EClass>> referenceSourcesRegistry; // ==sources

	public TargetSectionRegistry() {
		targetClassInstanceRegistry= new LinkedHashMap<EClass, LinkedList<EObjectTransformationHelper>>();
		targetClassInstanceByHintGroupRegistry = new LinkedHashMap<TargetSectionClass, LinkedHashMap<MappingHintGroup, LinkedList<EObjectTransformationHelper>>>();
		childClassesRegistry= new LinkedHashMap<EClass, LinkedHashSet<EClass>>();
		possiblePathsRegistry= new LinkedHashMap<EClass, LinkedHashSet<ModelConnectionPath>>();
		targetClassReferencesRegistry= new LinkedHashMap<EClass, LinkedHashSet<EReference>>(); // ==refsToThis
		referenceSourcesRegistry=new LinkedHashMap<EReference, LinkedHashSet<EClass>>(); // ==sources
	}
	
	
	public void addClassInstance(EObjectTransformationHelper instance, MappingHintGroup group,
			TargetSectionClass targetSection) {
		EClass eClass = instance.getEObject().eClass();

		if (!targetClassInstanceRegistry.containsKey(eClass)) {
			targetClassInstanceRegistry.put(eClass, new LinkedList<EObjectTransformationHelper>());
		}
		targetClassInstanceRegistry.get(eClass).add(instance);

		if (!targetClassInstanceByHintGroupRegistry.containsKey(targetSection)) {
			targetClassInstanceByHintGroupRegistry.put(targetSection,
					new LinkedHashMap<MappingHintGroup, LinkedList<EObjectTransformationHelper>>());
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

	public  LinkedHashMap<MappingHintGroup, LinkedList<EObjectTransformationHelper>> getPamtramClassInstances(
			TargetSectionClass c) {
		if (!targetClassInstanceByHintGroupRegistry.containsKey(c)) {
			return new LinkedHashMap<MappingHintGroup, LinkedList<EObjectTransformationHelper>>();
		}

		return targetClassInstanceByHintGroupRegistry.get(c);

	}
	
	public  LinkedList<EObjectTransformationHelper> getFlattenedPamtramClassInstances(TargetSectionClass c) {
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
	
	public  void addPath(ModelConnectionPath modelConnectionPath, EClass eClass) {

		if (!possiblePathsRegistry.containsKey(eClass)) {
			possiblePathsRegistry.put(eClass, new LinkedHashSet<ModelConnectionPath>());
		}
		possiblePathsRegistry.get(eClass).add(modelConnectionPath);

	}

	public  LinkedHashSet<EClass> getChildClasses(EClass eClass) {

		return childClassesRegistry.containsKey(eClass) ? childClassesRegistry
				.get(eClass) : new LinkedHashSet<EClass>();

	}

	public  LinkedHashSet<EReference> getClassReferences(EClass eClass) {

		return targetClassReferencesRegistry.containsKey(eClass) ? targetClassReferencesRegistry
				.get(eClass) : new LinkedHashSet<EReference>();

	}

	public  LinkedHashSet<EClass> getReferenceSources(EReference ref) {
		return referenceSourcesRegistry.containsKey(ref) ? referenceSourcesRegistry
				.get(ref) : new LinkedHashSet<EClass>();

	}
	
	private LinkedList<EClass> getClasses(EPackage pkg){
		LinkedList<EClass> classes=new LinkedList<EClass>();
		
		for(EClassifier c : pkg.getEClassifiers()){
			if(c instanceof EClass){
				classes.add((EClass) c);
				
				childClassesRegistry.put((EClass) c, new LinkedHashSet<EClass>());
				targetClassReferencesRegistry.put((EClass) c,
						new LinkedHashSet<EReference>());
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
						referenceSourcesRegistry.put(c, new LinkedHashSet<EClass>());
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

	public  LinkedHashSet<ModelConnectionPath> getPaths(EClass eClass) {
		if (!possiblePathsRegistry.containsKey(eClass)) {
			possiblePathsRegistry.put(eClass, new LinkedHashSet<ModelConnectionPath>());

			new ModelConnectionPath(this).findPathsToInstances(eClass);
		}

		return possiblePathsRegistry.get(eClass);

	}

}
