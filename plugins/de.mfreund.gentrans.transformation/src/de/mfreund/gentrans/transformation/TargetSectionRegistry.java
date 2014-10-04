package de.mfreund.gentrans.transformation;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.metamodel.TargetSectionClass;

/**
 * Registry for instances of targetMetamodelSections and certain structural features of the target MetaModel
 * @author Sascha Steffen
 * @version 0.8
 *
 */
class TargetSectionRegistry implements CancellationListener{
	
	/**
	 * Attribute value registry, needed when applying model connection hints
	 */
	private AttributeValueRegistry attrValRegistry;


	public AttributeValueRegistry getAttrValRegistry() {
		return attrValRegistry;
	}

	/**
	 * Map of instantiated EObjects, sorted by TargetSectionClass
	 */
	private  LinkedHashMap<EClass, LinkedList<EObjectTransformationHelper>> targetClassInstanceRegistry;
	/**
	 * Map of instantiated EObjects, sorted by TargetSectionClass and MappingHintGroup
	 */
	private  LinkedHashMap<TargetSectionClass, LinkedHashMap<InstantiableMappingHintGroup, LinkedList<EObjectTransformationHelper>>> targetClassInstanceByHintGroupRegistry;
	/**
	 * Child classes for each class (if there are any)
	 */
	private  LinkedHashMap<EClass, LinkedHashSet<EClass>> childClassesRegistry;
	/**
	 * Possible Paths, sorted by target MetaModel class
	 */
	private  LinkedHashMap<EClass, LinkedHashSet<ModelConnectionPath>> possiblePathsRegistry;
	
	/**
	 * Possible connections from a start class to a specific target class
	 */
	private  LinkedHashMap<EClass, LinkedHashMap<EClass,LinkedHashSet<ModelConnectionPath>>> possibleConnectionsRegistry;	
	
	/**
	 * List of references to a Class
	 */
	private  LinkedHashMap<EClass, LinkedHashSet<EReference>> targetClassReferencesRegistry;
	/**
	 * Source classes that are the starting point of a specific reference
	 */
	private  LinkedHashMap<EReference, LinkedHashSet<EClass>> containmentReferenceSourcesRegistry;
	/**
	 * Message output stream
	 */
	private MessageConsoleStream consoleStream;
	/** 
	 * Possible model containers
	 */
	private Set<EClass> modelContainers;


	/**
	 * Constructor
	 * @param consoleStream
	 * @param attrValRegistry 
	 */
	TargetSectionRegistry(MessageConsoleStream consoleStream, AttributeValueRegistry attrValRegistry, EPackage targetMetaModel) {
		this.consoleStream=consoleStream;
		targetClassInstanceRegistry= new LinkedHashMap<EClass, LinkedList<EObjectTransformationHelper>>();
		targetClassInstanceByHintGroupRegistry = new LinkedHashMap<TargetSectionClass, LinkedHashMap<InstantiableMappingHintGroup, LinkedList<EObjectTransformationHelper>>>();
		childClassesRegistry= new LinkedHashMap<EClass, LinkedHashSet<EClass>>();
		possiblePathsRegistry= new LinkedHashMap<EClass, LinkedHashSet<ModelConnectionPath>>();
		possibleConnectionsRegistry=new LinkedHashMap<EClass,LinkedHashMap<EClass, LinkedHashSet<ModelConnectionPath>>>();
		targetClassReferencesRegistry= new LinkedHashMap<EClass, LinkedHashSet<EReference>>(); // ==refsToThis
		containmentReferenceSourcesRegistry=new LinkedHashMap<EReference, LinkedHashSet<EClass>>(); // ==sources
		this.attrValRegistry=attrValRegistry;
		this.setTransFormationCancelled(false);
		modelContainers=new LinkedHashSet<EClass>();
		analyseTargetMetaModel(targetMetaModel);
	}
	
	private boolean transFormationCancelled;
	
	
	/**
	 * Register the instance of a Class
	 * @param instance
	 * @param group
	 * @param targetSection
	 */
	void addClassInstance(EObjectTransformationHelper instance, InstantiableMappingHintGroup group,
			TargetSectionClass targetSection) {
		EClass eClass = instance.getEObject().eClass();

		if (!targetClassInstanceRegistry.containsKey(eClass)) {
			targetClassInstanceRegistry.put(eClass, new LinkedList<EObjectTransformationHelper>());
		}
		targetClassInstanceRegistry.get(eClass).add(instance);

		if (!targetClassInstanceByHintGroupRegistry.containsKey(targetSection)) {
			targetClassInstanceByHintGroupRegistry.put(targetSection,
					new LinkedHashMap<InstantiableMappingHintGroup, LinkedList<EObjectTransformationHelper>>());
		}

		if (!targetClassInstanceByHintGroupRegistry.get(targetSection)
				.containsKey(group)) {
			targetClassInstanceByHintGroupRegistry.get(targetSection).put(
					group, new LinkedList<EObjectTransformationHelper>());
		}

		targetClassInstanceByHintGroupRegistry.get(targetSection).get(group)
				.add(instance);

	}

	/**
	 * Register the instance of a Class
	 * <p>
	 * Used when linking target model sections
	 * @param instance
	 */
	 void addClassInstance(EObject instance) {
		EClass eClass = instance.eClass();

		if (!targetClassInstanceRegistry.containsKey(eClass)) {
			targetClassInstanceRegistry.put(eClass, new LinkedList<EObjectTransformationHelper>());
		}
		targetClassInstanceRegistry.get(eClass).add(new EObjectTransformationHelper(instance, attrValRegistry));

	}
	
	/**
	 * @param eClass
	 * @return All instances of the specified metamodel Class
	 */
	LinkedList<EObjectTransformationHelper> getTargetClassInstances(EClass eClass) {

		return targetClassInstanceRegistry.containsKey(eClass) ? targetClassInstanceRegistry
				.get(eClass) : new LinkedList<EObjectTransformationHelper>();
	}

	/**
	 * @param c
	 * @return instance map of all MappingHintGroups
	 */
	LinkedHashMap<InstantiableMappingHintGroup, LinkedList<EObjectTransformationHelper>> getPamtramClassInstances(
			TargetSectionClass c) {
		if (!targetClassInstanceByHintGroupRegistry.containsKey(c)) {
			return new LinkedHashMap<InstantiableMappingHintGroup, LinkedList<EObjectTransformationHelper>>();
		}

		return targetClassInstanceByHintGroupRegistry.get(c);

	}
	
	/**
	 * @param c
	 * @return instances of a specific MappingHintgroup
	 */
	LinkedList<EObjectTransformationHelper> getFlattenedPamtramClassInstances(TargetSectionClass c) {
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
	
	/**
	 * Add new Path to registry
	 * @param modelConnectionPath
	 * @param eClass
	 */
	void addPath(ModelConnectionPath modelConnectionPath, EClass eClass) {

		if (!possiblePathsRegistry.containsKey(eClass)) {
			possiblePathsRegistry.put(eClass, new LinkedHashSet<ModelConnectionPath>());
		}
		possiblePathsRegistry.get(eClass).add(modelConnectionPath);

	}
	
	/**
	 * @param path
	 * @param elementClass
	 * @param containerClass
	 */
	void addConnection(ModelConnectionPath path, EClass elementClass, EClass containerClass){
		if(!possibleConnectionsRegistry.containsKey(elementClass)){
			possibleConnectionsRegistry.put(elementClass, new LinkedHashMap<EClass,LinkedHashSet<ModelConnectionPath>>());
		}
		if(!possibleConnectionsRegistry.get(elementClass).containsKey(containerClass)){
			possibleConnectionsRegistry.get(elementClass).put(containerClass, new LinkedHashSet<ModelConnectionPath>());
		}
		possibleConnectionsRegistry.get(elementClass).get(containerClass).add(path);
	}

	/**
	 * @param eClass
	 * @return CHilClasses of a SuperClass
	 */
	LinkedHashSet<EClass> getChildClasses(EClass eClass) {

		return childClassesRegistry.containsKey(eClass) ? childClassesRegistry
				.get(eClass) : new LinkedHashSet<EClass>();

	}

	/**
	 * @param eClass
	 * @return Set of classes that contain references to eClass
	 */
	LinkedHashSet<EReference> getClassReferences(EClass eClass) {

		return targetClassReferencesRegistry.containsKey(eClass) ? targetClassReferencesRegistry
				.get(eClass) : new LinkedHashSet<EReference>();

	}

	/**
	 * @param ref
	 * @return Set of classes that are the starting point of a specific containment reference
	 */
	LinkedHashSet<EClass> getReferenceSources(EReference ref) {
		return containmentReferenceSourcesRegistry.containsKey(ref) ? containmentReferenceSourcesRegistry
				.get(ref) : new LinkedHashSet<EClass>();

	}
	
	/**
	 * @param pkg
	 * @return Classes, contained in a MetaModel Package
	 */
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

	/**
	 * Build various lists that describe structural features of the  target MetaModel
	 * @param targetMetaModel
	 */
	private void analyseTargetMetaModel(EPackage targetMetaModel) {
		// Map targetMetaModel classes
		
		consoleStream.println("Mapping targetMetaModel classes");
		LinkedList<EClass> classesToAnalyse=getClasses(targetMetaModel);
		
		// map supertypes
		consoleStream.println("Mapping targetMetaModel inheritance and containment relationships");
		for (EClass e : classesToAnalyse) {
			for (EClass s : e.getEAllSuperTypes()) {
				childClassesRegistry.get(s).add(e);
			}
		}

		// register references that lead to a certain class for each class
		consoleStream.println("Mapping targetMetaModel containment relationships");
		for (EClass e : classesToAnalyse) {
			for (EReference c : e.getEAllContainments()) {
				if (targetClassReferencesRegistry.containsKey(c.getEReferenceType())) {
					if (!containmentReferenceSourcesRegistry.containsKey(c)) {
						containmentReferenceSourcesRegistry.put(c, new LinkedHashSet<EClass>());
					}
					containmentReferenceSourcesRegistry.get(c).add(e);
					
					targetClassReferencesRegistry.get(c.getEReferenceType()).add(c);
					
				} else {
					consoleStream.println("Ignoring targetMetaModel reference "
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

		//get possible model containers
		for(EClass possibleContainer : targetClassReferencesRegistry.keySet()){
			if(targetClassReferencesRegistry.get(possibleContainer).size() < 1 && !possibleContainer.isAbstract()){
				modelContainers.add(possibleContainer);
			}
		}
	}

	/**
	 * @param eClass
	 * @return Possible paths to connect target Model sections, for a specific Class of the target model
	 */
	LinkedHashSet<ModelConnectionPath> getPaths(EClass eClass,int maxPathLength) {
		if (!possiblePathsRegistry.containsKey(eClass)) {
			possiblePathsRegistry.put(eClass, new LinkedHashSet<ModelConnectionPath>());

			 ModelConnectionPath.findPathsToInstances(this,eClass,maxPathLength);
		}

		return possiblePathsRegistry.get(eClass);

	}
	
	LinkedHashSet<ModelConnectionPath> getConnections(EClass elementClass, EClass containerClass, int maxPathLength){
		if(!possibleConnectionsRegistry.containsKey(elementClass)){
			possibleConnectionsRegistry.put(elementClass, new LinkedHashMap<EClass,LinkedHashSet<ModelConnectionPath>>());
		}
		if(!possibleConnectionsRegistry.get(elementClass).containsKey(containerClass)){
			possibleConnectionsRegistry.get(elementClass).put(containerClass, new LinkedHashSet<ModelConnectionPath>());
			
			ModelConnectionPath.findPathsFromContainerToClassToConnect(this,elementClass, containerClass, maxPathLength);
		}
		
		if( possibleConnectionsRegistry.get(elementClass).containsKey(containerClass)){
			return possibleConnectionsRegistry.get(elementClass).get(containerClass);
		} else {
			return null;
		}
	}

	@Override
	public void cancel() {
		this.setTransFormationCancelled(true);
		
	}

	@Override
	public boolean isCancelled() {
		return transFormationCancelled;
	}

	public void setTransFormationCancelled(boolean transFormationCancelled) {
		this.transFormationCancelled = transFormationCancelled;
	}

	
	 List<ModelConnectionPath> getModelContainerPaths( EClass elementClass,
				int maxPathLength) {
			//new ModelConnectionPath(registry).findPathsFromContainerToClassToConnect(elementClass, containerClass, maxPathLength);
			List<ModelConnectionPath> paths=new LinkedList<ModelConnectionPath>();
			
			for(EClass possibleContainer : modelContainers){
				if(transFormationCancelled) return paths;
				paths.addAll(getConnections(elementClass, possibleContainer, maxPathLength));
			}
			
			return paths;
		}	
}
