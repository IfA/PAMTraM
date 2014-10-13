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
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.metamodel.TargetSectionClass;

/**
 * Registry for instances of targetMetamodelSections and certain structural
 * features of the target MetaModel
 *
 * @author Sascha Steffen
 * @version 1.0
 *
 */
class TargetSectionRegistry implements CancellationListener {

	/**
	 * Attribute value registry, needed when applying model connection hints
	 */
	private final AttributeValueRegistry attrValRegistry;

	/**
	 * Map of instantiated EObjects, sorted by TargetSectionClass
	 */
	private final LinkedHashMap<EClass, LinkedList<EObjectTransformationHelper>> targetClassInstanceRegistry;

	/**
	 * Map of instantiated EObjects, sorted by TargetSectionClass and
	 * MappingHintGroup
	 */
	private final LinkedHashMap<TargetSectionClass, LinkedHashMap<InstantiableMappingHintGroup, LinkedList<EObjectTransformationHelper>>> targetClassInstanceByHintGroupRegistry;
	/**
	 * Child classes for each class (if there are any)
	 */
	private final LinkedHashMap<EClass, LinkedHashSet<EClass>> childClassesRegistry;
	/**
	 * Possible Paths, sorted by target MetaModel class
	 */
	private final LinkedHashMap<EClass, LinkedHashSet<ModelConnectionPath>> possiblePathsRegistry;
	/**
	 * Possible connections from a start class to a specific target class
	 */
	private final LinkedHashMap<EClass, LinkedHashMap<EClass, LinkedHashSet<ModelConnectionPath>>> possibleConnectionsRegistry;

	/**
	 * List of references to a Class
	 */
	private final LinkedHashMap<EClass, LinkedHashSet<EReference>> targetClassReferencesRegistry;

	/**
	 * Source classes that are the starting point of a specific reference
	 */
	private final LinkedHashMap<EReference, LinkedHashSet<EClass>> containmentReferenceSourcesRegistry;
	/**
	 * Message output stream
	 */
	private final MessageConsoleStream consoleStream;

	/**
	 * Transformation was cancelled?
	 */
	private boolean transFormationCancelled;

	/**
	 * Constructor
	 *
	 * @param consoleStream
	 * @param attrValRegistry
	 */
	TargetSectionRegistry(final MessageConsoleStream consoleStream,
			final AttributeValueRegistry attrValRegistry,
			final EPackage targetMetaModel) {
		this.consoleStream = consoleStream;
		targetClassInstanceRegistry = new LinkedHashMap<EClass, LinkedList<EObjectTransformationHelper>>();
		targetClassInstanceByHintGroupRegistry = new LinkedHashMap<TargetSectionClass, LinkedHashMap<InstantiableMappingHintGroup, LinkedList<EObjectTransformationHelper>>>();
		childClassesRegistry = new LinkedHashMap<EClass, LinkedHashSet<EClass>>();
		possiblePathsRegistry = new LinkedHashMap<EClass, LinkedHashSet<ModelConnectionPath>>();
		possibleConnectionsRegistry = new LinkedHashMap<EClass, LinkedHashMap<EClass, LinkedHashSet<ModelConnectionPath>>>();
		targetClassReferencesRegistry = new LinkedHashMap<EClass, LinkedHashSet<EReference>>(); // ==refsToThis
		containmentReferenceSourcesRegistry = new LinkedHashMap<EReference, LinkedHashSet<EClass>>(); // ==sources
		this.attrValRegistry = attrValRegistry;
		transFormationCancelled = false;
		analyseTargetMetaModel(targetMetaModel);
	}

	/**
	 * Register the instance of a Class
	 * <p>
	 * Used when linking target model sections
	 *
	 * @param instance
	 */
	void addClassInstance(final EObject instance) {
		final EClass eClass = instance.eClass();

		if (!targetClassInstanceRegistry.containsKey(eClass)) {
			targetClassInstanceRegistry.put(eClass,
					new LinkedList<EObjectTransformationHelper>());
		}
		targetClassInstanceRegistry.get(eClass).add(
				new EObjectTransformationHelper(instance, attrValRegistry));

	}

	/**
	 * Register the instance of a Class
	 *
	 * @param instance
	 * @param group
	 * @param targetSection
	 */
	void addClassInstance(final EObjectTransformationHelper instance,
			final InstantiableMappingHintGroup group,
			final TargetSectionClass targetSection) {
		final EClass eClass = instance.getEObject().eClass();

		if (!targetClassInstanceRegistry.containsKey(eClass)) {
			targetClassInstanceRegistry.put(eClass,
					new LinkedList<EObjectTransformationHelper>());
		}
		targetClassInstanceRegistry.get(eClass).add(instance);

		if (!targetClassInstanceByHintGroupRegistry.containsKey(targetSection)) {
			targetClassInstanceByHintGroupRegistry
					.put(targetSection,
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
	 * @param path
	 * @param elementClass
	 * @param containerClass
	 */
	void addConnection(final ModelConnectionPath path,
			final EClass elementClass, final EClass containerClass) {
		if (!possibleConnectionsRegistry.containsKey(elementClass)) {
			possibleConnectionsRegistry
					.put(elementClass,
							new LinkedHashMap<EClass, LinkedHashSet<ModelConnectionPath>>());
		}
		if (!possibleConnectionsRegistry.get(elementClass).containsKey(
				containerClass)) {
			possibleConnectionsRegistry.get(elementClass).put(containerClass,
					new LinkedHashSet<ModelConnectionPath>());
		}
		possibleConnectionsRegistry.get(elementClass).get(containerClass)
				.add(path);
	}

	/**
	 * Add new Path to registry
	 *
	 * @param modelConnectionPath
	 * @param eClass
	 */
	void addPath(final ModelConnectionPath modelConnectionPath,
			final EClass eClass) {

		if (!possiblePathsRegistry.containsKey(eClass)) {
			possiblePathsRegistry.put(eClass,
					new LinkedHashSet<ModelConnectionPath>());
		}
		possiblePathsRegistry.get(eClass).add(modelConnectionPath);

	}

	/**
	 * Build various lists that describe structural features of the target
	 * MetaModel
	 *
	 * @param targetMetaModel
	 */
	private void analyseTargetMetaModel(final EPackage targetMetaModel) {
		// Map targetMetaModel classes

		consoleStream.println("Mapping targetMetaModel classes");
		final LinkedList<EClass> classesToAnalyse = getClasses(targetMetaModel);

		// map supertypes
		consoleStream
				.println("Mapping targetMetaModel inheritance and containment relationships");
		for (final EClass e : classesToAnalyse) {
			for (final EClass s : e.getEAllSuperTypes()) {
				childClassesRegistry.get(s).add(e);
			}
		}

		// register references that lead to a certain class for each class
		consoleStream
				.println("Mapping targetMetaModel containment relationships");
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

	/*
	 * (non-Javadoc)
	 *
	 * @see de.mfreund.gentrans.transformation.CancellationListener#cancel()
	 */
	@Override
	public void cancel() {
		transFormationCancelled = true;
	}

	/**
	 * This is used by {@link ModelConnectionPath}
	 *
	 * @return AttributeValueRegistry
	 */
	AttributeValueRegistry getAttrValRegistry() {
		return attrValRegistry;
	}

	/**
	 * @param eClass
	 * @return CHilClasses of a SuperClass
	 */
	LinkedHashSet<EClass> getChildClasses(final EClass eClass) {

		return childClassesRegistry.containsKey(eClass) ? childClassesRegistry
				.get(eClass) : new LinkedHashSet<EClass>();

	}

	/**
	 * @param pkg
	 * @return Classes, contained in a MetaModel Package
	 */
	private LinkedList<EClass> getClasses(final EPackage epackage) {
		final LinkedList<EClass> classes = new LinkedList<EClass>();
		final List<EPackage> packagesToScan = new LinkedList<EPackage>();
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
						if (docroot.equals(c))
							continue;
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
	LinkedHashSet<EReference> getClassReferences(final EClass eClass) {

		return targetClassReferencesRegistry.containsKey(eClass) ? targetClassReferencesRegistry
				.get(eClass) : new LinkedHashSet<EReference>();

	}

	LinkedHashSet<ModelConnectionPath> getConnections(
			final EClass elementClass, final EClass containerClass,
			final int maxPathLength) {
		if (!possibleConnectionsRegistry.containsKey(elementClass)) {
			possibleConnectionsRegistry
					.put(elementClass,
							new LinkedHashMap<EClass, LinkedHashSet<ModelConnectionPath>>());
		}
		if (!possibleConnectionsRegistry.get(elementClass).containsKey(
				containerClass)) {
			possibleConnectionsRegistry.get(elementClass).put(containerClass,
					new LinkedHashSet<ModelConnectionPath>());

			ModelConnectionPath.findPathsFromContainerToClassToConnect(this,
					elementClass, containerClass, maxPathLength);
		}

		if (possibleConnectionsRegistry.get(elementClass).containsKey(
				containerClass)) {
			return possibleConnectionsRegistry.get(elementClass).get(
					containerClass);
		} else {
			return null;
		}
	}

	/**
	 * @param c
	 * @return instances of a specific MappingHintgroup
	 */
	LinkedList<EObjectTransformationHelper> getFlattenedPamtramClassInstances(
			final TargetSectionClass c) {
		final LinkedList<EObjectTransformationHelper> flat = new LinkedList<EObjectTransformationHelper>();
		if (!targetClassInstanceByHintGroupRegistry.containsKey(c)) {
			return flat;
		}

		for (final LinkedList<EObjectTransformationHelper> l : targetClassInstanceByHintGroupRegistry
				.get(c).values()) {
			flat.addAll(l);
		}

		return flat;

	}

	/**
	 * @return all the MetaModelClasse we don't ignore
	 */
	Set<EClass> getMetaModelClasses() {
		return childClassesRegistry.keySet();
	}

	/**
	 * @param c
	 * @return instance map of all MappingHintGroups
	 */
	LinkedHashMap<InstantiableMappingHintGroup, LinkedList<EObjectTransformationHelper>> getPamtramClassInstances(
			final TargetSectionClass c) {
		if (!targetClassInstanceByHintGroupRegistry.containsKey(c)) {
			return new LinkedHashMap<InstantiableMappingHintGroup, LinkedList<EObjectTransformationHelper>>();
		}

		return targetClassInstanceByHintGroupRegistry.get(c);

	}

	/**
	 * @param eClass
	 * @return Possible paths to connect target Model sections, for a specific
	 *         Class of the target model
	 */
	LinkedHashSet<ModelConnectionPath> getPaths(final EClass eClass,
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
	LinkedHashSet<EClass> getReferenceSources(final EReference ref) {
		return containmentReferenceSourcesRegistry.containsKey(ref) ? containmentReferenceSourcesRegistry
				.get(ref) : new LinkedHashSet<EClass>();

	}

	/**
	 * @param eClass
	 * @return All instances of the specified metamodel Class
	 */
	LinkedList<EObjectTransformationHelper> getTargetClassInstances(
			final EClass eClass) {

		return targetClassInstanceRegistry.containsKey(eClass) ? targetClassInstanceRegistry
				.get(eClass) : new LinkedList<EObjectTransformationHelper>();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.mfreund.gentrans.transformation.CancellationListener#isCancelled()
	 */
	@Override
	public boolean isCancelled() {
		return transFormationCancelled;
	}
}
