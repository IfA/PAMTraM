package de.mfreund.gentrans.transformation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.util.CancellableElement;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionClass;

/**
 * Registry for instances of targetMetamodelSections and certain structural
 * features of the target MetaModel
 *
 * @author Sascha Steffen
 * @version 1.0
 *
 */
public class TargetSectionRegistry extends CancellableElement {

	/**
	 * Attribute value registry, needed when applying model connection hints
	 */
	private final AttributeValueRegistry attrValRegistry;

	/**
	 * Map of instantiated EObjects, sorted by TargetSectionClass
	 */
	private final Map<EClass, List<EObjectWrapper>> targetClassInstanceRegistry;

	/**
	 * Map of instantiated EObjects, sorted by TargetSectionClass and
	 * MappingHintGroup
	 */
	private final Map<TargetSectionClass, Map<InstantiableMappingHintGroup, List<EObjectWrapper>>> targetClassInstanceByHintGroupRegistry;
	
	/**
	 * Child classes for each class (if there are any)
	 */
	private final Map<EClass, Set<EClass>> childClassesRegistry;
	
	/**
	 * Possible Paths, sorted by target MetaModel class
	 */
	private final Map<EClass, Set<ModelConnectionPath>> possiblePathsRegistry;
	
	/**
	 * Possible connections from a start class to a specific target class
	 */
	private final Map<EClass, Map<EClass, Set<ModelConnectionPath>>> possibleConnectionsRegistry;

	/**
	 * List of references to a Class
	 */
	private final Map<EClass, Set<EReference>> targetClassReferencesRegistry;

	/**
	 * Source classes that are the starting point of a specific reference
	 */
	private final Map<EReference, Set<EClass>> containmentReferenceSourcesRegistry;
	
	/**
	 * Message output stream
	 */
	private final MessageConsoleStream consoleStream;
	
	/**
	 * This creates an instance.
	 * 
	 * @param consoleStream The {@link MessageConsoleStream} that shall be used to print messages.
	 * @param attrValRegistry The {@link AttributeValueRegistry} that keeps track of already used 
	 * values for target attributes.
	 */
	TargetSectionRegistry(final MessageConsoleStream consoleStream,
			final AttributeValueRegistry attrValRegistry,
			final EPackage targetMetaModel) {
		
		this.consoleStream = consoleStream;
		this.targetClassInstanceRegistry = new LinkedHashMap<>();
		this.targetClassInstanceByHintGroupRegistry = new LinkedHashMap<>();
		this.childClassesRegistry = new LinkedHashMap<>();
		this.possiblePathsRegistry = new LinkedHashMap<>();
		this.possibleConnectionsRegistry = new LinkedHashMap<>();
		this.targetClassReferencesRegistry = new LinkedHashMap<>(); // ==refsToThis
		this.containmentReferenceSourcesRegistry = new LinkedHashMap<>(); // ==sources
		this.attrValRegistry = attrValRegistry;
		this.canceled = false;

		analyseTargetMetaModel(targetMetaModel);
	}
	
	/**
	 * Register a new instance.
	 * <p />
	 * Note: Normally, {@link #addClassInstance(EObjectWrapper, InstantiableMappingHintGroup, TargetSectionClass)} should
	 * be used instead. This should only be used when elements have been created not based on a concrete hint group
	 * but, e.g. as missing element of a model connection path. 
	 *
	 * @param instance The {@link EObject} to register.
	 */
	public void addClassInstance(final EObject instance) {
		
		final EClass eClass = instance.eClass();

		if (!targetClassInstanceRegistry.containsKey(eClass)) {
			targetClassInstanceRegistry.put(eClass,
					new LinkedList<EObjectWrapper>());
		}
		targetClassInstanceRegistry.get(eClass).add(
				new EObjectWrapper(instance, attrValRegistry));

	}

	/**
	 * Register a new instance.
	 *
	 * @param instance The {@link EObjectWrapper} representing the new instance to add (this needs
	 * to be instance of the given {@link TargetSectionClass}).
	 * @param mappingHintGroup The {@link InstantiableMappingHintGroup} that was responsible for creating the new instance.
	 * @param targetSectionClass The {@link TargetSectionClass} representing the new instance (this needs to be one
	 * of the classes defined by the {@link TargetSection} referenced by the given {@link InstantiableMappingHintGroup}).
	 */
	public void addClassInstance(final EObjectWrapper instance,
			final InstantiableMappingHintGroup mappingHintGroup,
			final TargetSectionClass targetSectionClass) {
		
		final EClass eClass = instance.getEObject().eClass();

		if (!targetClassInstanceRegistry.containsKey(eClass)) {
			targetClassInstanceRegistry.put(eClass,
					new LinkedList<EObjectWrapper>());
		}
		targetClassInstanceRegistry.get(eClass).add(instance);

		if (!targetClassInstanceByHintGroupRegistry.containsKey(targetSectionClass)) {
			targetClassInstanceByHintGroupRegistry.put(targetSectionClass,
					new HashMap<InstantiableMappingHintGroup, List<EObjectWrapper>>());
		}

		if (!targetClassInstanceByHintGroupRegistry.get(targetSectionClass)
				.containsKey(mappingHintGroup)) {
			targetClassInstanceByHintGroupRegistry.get(targetSectionClass).put(
					mappingHintGroup, new LinkedList<EObjectWrapper>());
		}

		targetClassInstanceByHintGroupRegistry.get(targetSectionClass).get(mappingHintGroup).add(instance);

	}

	/**
	 * Register a new {@link ModelConnectionPath} in the {@link #possibleConnectionsRegistry}.
	 * 
	 * @param path The {@link ModelConnectionPath} to register.
	 */
	public void addConnection(final ModelConnectionPath path) {
		
		// The EClass at the beginning of the path (lower in the containment hierarchy).
		EClass elementClass = (EClass) path.getPathElements().getFirst();
		
		// The EClass at the end of the path (higher in the containment hierarchy).
		EClass containerClass = (EClass) path.getPathElements().getLast();
		
		if (!possibleConnectionsRegistry.containsKey(elementClass)) {
			possibleConnectionsRegistry.put(elementClass,
					new LinkedHashMap<EClass, Set<ModelConnectionPath>>());
		}
		
		if (!possibleConnectionsRegistry.get(elementClass).containsKey(
				containerClass)) {
			possibleConnectionsRegistry.get(elementClass).put(containerClass,
					new LinkedHashSet<ModelConnectionPath>());
		}
		
		possibleConnectionsRegistry.get(elementClass).get(containerClass).add(path);
	}

	/**
	 * Register a new {@link ModelConnectionPath} in the {@link #possiblePathsRegistry}.
	 *
	 * @param modelConnectionPath The {@link ModelConnectionPath} to register.
	 */
	public void addPath(final ModelConnectionPath modelConnectionPath) {

		// The EClass at the beginning of the path (lower in the containment hierarchy).
		EClass eClass = (EClass) modelConnectionPath.getPathElements().getFirst();
		
		if (!possiblePathsRegistry.containsKey(eClass)) {
			possiblePathsRegistry.put(eClass,
					new LinkedHashSet<ModelConnectionPath>());
		}
		possiblePathsRegistry.get(eClass).add(modelConnectionPath);

	}

	/**
	 * Build various maps that describe structural features of the given <em>targetMetaModel</em>.
	 * <p />
	 * This fills the {@link #childClassesRegistry}, the {@link #containmentReferenceSourcesRegistry}, and
	 * the {@link #targetClassReferencesRegistry}.
	 *
	 * @param targetMetaModel The {@link EPackage} representing the target meta-model to be analyzed.
	 */
	private void analyseTargetMetaModel(final EPackage targetMetaModel) {
		
		consoleStream.println();
		consoleStream.println("Analyzing target meta-model '" + targetMetaModel.getName() + "'.");

		// Map targetMetaModel classes
		consoleStream.println("\tMapping targetMetaModel classes");
		final LinkedList<EClass> classesToAnalyse = getClasses(targetMetaModel);

		// map supertypes
		consoleStream.println("\tMapping targetMetaModel inheritance and containment relationships");
		for (final EClass e : classesToAnalyse) {
			for (final EClass s : e.getEAllSuperTypes()) {
				childClassesRegistry.get(s).add(e);
			}
		}

		// register references that lead to a certain class for each class
		consoleStream.println("\tMapping targetMetaModel containment relationships");
		for (final EClass e : classesToAnalyse) {
			for (final EReference c : e.getEAllContainments()) {
				if (targetClassReferencesRegistry.containsKey(c
						.getEReferenceType())) {
					if (!containmentReferenceSourcesRegistry.containsKey(c)) {
						containmentReferenceSourcesRegistry.put(c,
								new LinkedHashSet<EClass>());
					}
					containmentReferenceSourcesRegistry.get(c).add(e);

					targetClassReferencesRegistry.get(c.getEReferenceType())
					.add(c);

				} else {
					consoleStream.println("Ignoring targetMetaModel reference "
							+ c.getName() + " of element " + e.getName() + " "
							+ c.getEReferenceType().getName() + " "
							+ c.getEType().getName());
				}
			}
		}

		// add inherited containment refs
		for (final EClass e : classesToAnalyse) {
			for (final EClass c : childClassesRegistry.get(e)) {// e.~childClasses){
				targetClassReferencesRegistry.get(c).addAll(
						targetClassReferencesRegistry.get(e));
			}
		}
	}

	/**
	 * This is used by {@link ModelConnectionPath}
	 *
	 * @return AttributeValueRegistry
	 */
	public AttributeValueRegistry getAttrValRegistry() {
		return attrValRegistry;
	}

	/**
	 * @param eClass
	 * @return CHilClasses of a SuperClass
	 */
	public Set<EClass> getChildClasses(final EClass eClass) {

		return childClassesRegistry.containsKey(eClass) ? childClassesRegistry
				.get(eClass) : new LinkedHashSet<EClass>();

	}

	/**
	 * @param pkg
	 * @return Classes, contained in a MetaModel Package
	 */
	private LinkedList<EClass> getClasses(final EPackage epackage) {
		final LinkedList<EClass> classes = new LinkedList<>();
		final List<EPackage> packagesToScan = new LinkedList<>();
		packagesToScan.add(epackage);

		while (!packagesToScan.isEmpty()) {
			final EPackage pkg = packagesToScan.remove(0);

			packagesToScan.addAll(pkg.getESubpackages());

			final EClass docroot = ExtendedMetaData.INSTANCE
					.getDocumentRoot(pkg);
			for (final EClassifier c : pkg.getEClassifiers()) {
				if (c instanceof EClass) {

					if (docroot != null) {// ignore DocumentRoot Classes created
						// when converting xsd to ecore
						if (docroot.equals(c)) {
							continue;
						}
					}
					classes.add((EClass) c);

					childClassesRegistry.put((EClass) c,
							new LinkedHashSet<EClass>());
					targetClassReferencesRegistry.put((EClass) c,
							new LinkedHashSet<EReference>());
				}
			}
		}

		return classes;
	}

	/**
	 * @param eClass
	 * @return Set of classes that contain references to eClass
	 */
	public Set<EReference> getClassReferences(final EClass eClass) {

		return targetClassReferencesRegistry.containsKey(eClass) ? targetClassReferencesRegistry
				.get(eClass) : new LinkedHashSet<EReference>();

	}

	/**
	 * Returns (and registers) connections between two classes
	 *
	 * @param eClass
	 *            Class of the root element of a target section that needs to be
	 *            connected
	 * @param containerClass
	 *            Class that is modeled to contain the target section to be
	 *            connected
	 * @param maxPathLength
	 * @return
	 */
	public LinkedList<ModelConnectionPath> getConnections(
			final EClass eClass, final EClass containerClass,
			final int maxPathLength) {

		if (!possibleConnectionsRegistry.containsKey(eClass)) {
			possibleConnectionsRegistry.put(eClass,
					new LinkedHashMap<EClass, Set<ModelConnectionPath>>());
		}
		if (!possibleConnectionsRegistry.get(eClass).containsKey(
				containerClass)) {
			possibleConnectionsRegistry.get(eClass).put(containerClass,
					new LinkedHashSet<ModelConnectionPath>());

			ModelConnectionPath.findPathsFromContainerToClassToConnect(this,
					eClass, containerClass, maxPathLength);
		}

		if (possibleConnectionsRegistry.get(eClass).containsKey(
				containerClass)) {
			LinkedList<ModelConnectionPath> result = new LinkedList<>();
			result.addAll(possibleConnectionsRegistry.get(eClass).get(
					containerClass));
			return result;
		} else {
			return null;
		}
	}

	/**
	 * @param c
	 * @return instances of a specific MappingHintgroup
	 */
	public List<EObjectWrapper> getFlattenedPamtramClassInstances(
			final TargetSectionClass c) {
		final LinkedList<EObjectWrapper> flat = new LinkedList<>();
		if (!targetClassInstanceByHintGroupRegistry.containsKey(c)) {
			return flat;
		}

		for (final List<EObjectWrapper> l : targetClassInstanceByHintGroupRegistry
				.get(c).values()) {
			flat.addAll(l);
		}

		return flat;

	}

	/**
	 * @return all the MetaModelClasse we don't ignore
	 */
	public Set<EClass> getMetaModelClasses() {
		
		return childClassesRegistry.keySet();
	}

	/**
	 * @param c
	 * @return instance map of all MappingHintGroups
	 */
	public Map<InstantiableMappingHintGroup, List<EObjectWrapper>> getPamtramClassInstances(
			final TargetSectionClass c) {
		if (!targetClassInstanceByHintGroupRegistry.containsKey(c)) {
			return new LinkedHashMap<>();
		}

		return targetClassInstanceByHintGroupRegistry.get(c);

	}

	/**
	 * Returns (and registers) paths between a class and any other class in the target meta-model.
	 * 
	 * @param eClass
	 *            Class of the root element of a target section that needs to be
	 *            connected
	 * @param maxPathLength
	 * @return Possible paths to connect target Model sections, for a specific
	 *         Class of the target model
	 */
	public Set<ModelConnectionPath> getPaths(final EClass eClass,
			final int maxPathLength) {

		if (!possiblePathsRegistry.containsKey(eClass)) {
			possiblePathsRegistry.put(eClass,
					new LinkedHashSet<ModelConnectionPath>());

			ModelConnectionPath.findPathsToInstances(this, eClass,
					maxPathLength);
		}

		return possiblePathsRegistry.get(eClass);

	}

	/**
	 * @param ref
	 * @return Set of classes that are the starting point of a specific
	 *         containment reference
	 */
	public Set<EClass> getReferenceSources(final EReference ref) {
		return containmentReferenceSourcesRegistry.containsKey(ref) ? containmentReferenceSourcesRegistry
				.get(ref) : new LinkedHashSet<>();

	}

	/**
	 * @param eClass
	 * @return All instances of the specified metamodel Class
	 */
	public List<EObjectWrapper> getTargetClassInstances(
			final EClass eClass) {

		return targetClassInstanceRegistry.containsKey(eClass) ? targetClassInstanceRegistry
				.get(eClass) : new LinkedList<>();
	}

}
