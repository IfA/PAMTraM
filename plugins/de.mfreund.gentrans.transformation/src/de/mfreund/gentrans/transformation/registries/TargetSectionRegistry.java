package de.mfreund.gentrans.transformation.registries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import de.mfreund.gentrans.transformation.connecting.MetaModelPath;
import de.mfreund.gentrans.transformation.core.CancelableTransformationAsset;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.library.LibraryEntryInstantiator;
import de.tud.et.ifa.agtele.emf.EPackageHelper;
import pamtram.TargetSectionModel;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.structure.generic.Section;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionClass;

/**
 * Registry for instances of targetMetamodelSections and certain structural features of the target MetaModel
 *
 * @author Sascha Steffen
 * @version 1.0
 *
 */
public class TargetSectionRegistry extends CancelableTransformationAsset {

	/**
	 * Attribute value registry, needed when applying model connection hints
	 */
	private final AttributeValueRegistry attrValRegistry;

	/**
	 * The {@link LibraryEntryRegistry} that keeps track of temporarily created {@link EObjectWrapper elements}
	 * representing {@link LibraryEntry LibraryEntries} that need to be instantiated by means of the associated
	 * {@link LibraryEntryInstantiator}.
	 */
	private final LibraryEntryRegistry libraryEntryRegistry;

	/**
	 * Map of instantiated EObjects, sorted by TargetSectionClass
	 */
	private final Map<EClass, List<EObjectWrapper>> targetClassInstanceRegistry;

	/**
	 * A map relating an {@link EObject} to the {@link EObjectWrapper} that represents it.
	 */
	private final Map<EObject, EObjectWrapper> eObjectToEObjectWrapperMap;

	/**
	 * Map of instantiated EObjects, sorted by TargetSectionClass and MappingHintGroup
	 */
	private final Map<TargetSectionClass, Map<InstantiableMappingHintGroup, List<EObjectWrapper>>> targetClassInstanceByHintGroupRegistry;

	/**
	 * Child classes for each class (if there are any)
	 */
	private final Map<EClass, Set<EClass>> childClassesRegistry;

	/**
	 * Possible Paths, sorted by target MetaModel class
	 */
	private final Map<EClass, Set<MetaModelPath>> possiblePathsRegistry;

	/**
	 * Possible connections from a start class to a specific target class
	 */
	private final Map<EClass, Map<EClass, Set<MetaModelPath>>> possibleConnectionsRegistry;

	/**
	 * List of references to a Class
	 */
	private final Map<EClass, Set<EReference>> targetClassReferencesRegistry;

	/**
	 * Source classes that are the starting point of a specific reference
	 */
	private final Map<EReference, Set<EClass>> containmentReferenceSourcesRegistry;

	/**
	 * This creates an instance for multiple target meta-models.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public TargetSectionRegistry(TransformationAssetManager assetManager) {

		super(assetManager);

		this.targetClassInstanceRegistry = new LinkedHashMap<>();
		this.eObjectToEObjectWrapperMap = new HashMap<>();
		this.targetClassInstanceByHintGroupRegistry = new LinkedHashMap<>();
		this.childClassesRegistry = new LinkedHashMap<>();
		this.possiblePathsRegistry = new LinkedHashMap<>();
		this.possibleConnectionsRegistry = new LinkedHashMap<>();
		this.targetClassReferencesRegistry = new LinkedHashMap<>(); // ==refsToThis
		this.containmentReferenceSourcesRegistry = new LinkedHashMap<>(); // ==sources
		this.attrValRegistry = new AttributeValueRegistry();
		this.libraryEntryRegistry = new LibraryEntryRegistry();

		Set<EPackage> targetMetaModels = new LinkedHashSet<>(assetManager.getTransformationConfig().getPamtramModels()
				.stream().flatMap(p -> p.getTargetSectionModels().stream()).map(TargetSectionModel::getMetaModelPackage)
				.collect(Collectors.toList()));

		this.analyseTargetMetaModels(targetMetaModels);
	}

	/**
	 * Register a new instance.
	 * <p />
	 * Note: Normally, {@link #addClassInstance(EObjectWrapper, InstantiableMappingHintGroup, TargetSectionClass)}
	 * should be used instead. This should only be used when elements have been created not based on a concrete hint
	 * group but, e.g. as missing element of a model connection path.
	 *
	 * @param instance
	 *            The {@link EObject} to register.
	 */
	public void addClassInstance(final EObject instance) {

		final EClass eClass = instance.eClass();

		if (!this.targetClassInstanceRegistry.containsKey(eClass)) {
			this.targetClassInstanceRegistry.put(eClass, new LinkedList<EObjectWrapper>());
		}
		this.targetClassInstanceRegistry.get(eClass).add(new EObjectWrapper(instance, this));

	}

	/**
	 * Register a new instance.
	 *
	 * @param instance
	 *            The {@link EObjectWrapper} representing the new instance to add (this needs to be instance of the
	 *            given {@link TargetSectionClass}).
	 * @param mappingHintGroup
	 *            The {@link InstantiableMappingHintGroup} that was responsible for creating the new instance.
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} representing the new instance (this needs to be one of the classes
	 *            defined by the {@link TargetSection} referenced by the given {@link InstantiableMappingHintGroup}).
	 */
	public void addClassInstance(final EObjectWrapper instance, final InstantiableMappingHintGroup mappingHintGroup,
			final TargetSectionClass targetSectionClass) {

		final EClass eClass = instance.getEObject().eClass();

		if (!this.targetClassInstanceRegistry.containsKey(eClass)) {
			this.targetClassInstanceRegistry.put(eClass, new LinkedList<EObjectWrapper>());
		}
		this.targetClassInstanceRegistry.get(eClass).add(instance);

		this.eObjectToEObjectWrapperMap.put(instance.getEObject(), instance);

		if (!this.targetClassInstanceByHintGroupRegistry.containsKey(targetSectionClass)) {
			this.targetClassInstanceByHintGroupRegistry.put(targetSectionClass,
					new LinkedHashMap<InstantiableMappingHintGroup, List<EObjectWrapper>>());
		}

		if (!this.targetClassInstanceByHintGroupRegistry.get(targetSectionClass).containsKey(mappingHintGroup)) {
			this.targetClassInstanceByHintGroupRegistry.get(targetSectionClass).put(mappingHintGroup,
					new LinkedList<EObjectWrapper>());
		}

		this.targetClassInstanceByHintGroupRegistry.get(targetSectionClass).get(mappingHintGroup).add(instance);

	}

	/**
	 * Register a new {@link MetaModelPath} in the {@link #possibleConnectionsRegistry}.
	 *
	 * @param path
	 *            The {@link MetaModelPath} to register.
	 */
	public void addConnection(final MetaModelPath path) {

		// The EClass at the beginning of the path (lower in the containment
		// hierarchy).
		EClass elementClass = (EClass) path.getPathElements().getFirst();

		// The EClass at the end of the path (higher in the containment
		// hierarchy).
		EClass containerClass = (EClass) path.getPathElements().getLast();

		if (!this.possibleConnectionsRegistry.containsKey(elementClass)) {
			this.possibleConnectionsRegistry.put(elementClass, new LinkedHashMap<EClass, Set<MetaModelPath>>());
		}

		if (!this.possibleConnectionsRegistry.get(elementClass).containsKey(containerClass)) {
			this.possibleConnectionsRegistry.get(elementClass).put(containerClass, new LinkedHashSet<MetaModelPath>());
		}

		this.possibleConnectionsRegistry.get(elementClass).get(containerClass).add(path);
	}

	/**
	 * Register a new {@link MetaModelPath} in the {@link #possiblePathsRegistry}.
	 *
	 * @param modelConnectionPath
	 *            The {@link MetaModelPath} to register.
	 */
	public void addPath(final MetaModelPath modelConnectionPath) {

		// The EClass at the beginning of the path (lower in the containment
		// hierarchy).
		EClass eClass = (EClass) modelConnectionPath.getPathElements().getFirst();

		if (!this.possiblePathsRegistry.containsKey(eClass)) {
			this.possiblePathsRegistry.put(eClass, new LinkedHashSet<MetaModelPath>());
		}
		this.possiblePathsRegistry.get(eClass).add(modelConnectionPath);

	}

	/**
	 * Build various maps that describe structural features of the given <em>targetMetaModels</em>. Also, check if there
	 * are any 'xs:any'-based elements and prepare the metamodel if necessary.
	 *
	 * @param targetMetaModel
	 *            The {@link EPackage} representing the target meta-model to be analyzed.
	 */
	private void analyseTargetMetaModels(Set<EPackage> targetMetaModels) {

		targetMetaModels.stream().forEach(this::analyseTargetMetaModel);

	}

	/**
	 * Build various maps that describe structural features of the given <em>targetMetaModel</em>.
	 * <p />
	 * This fills the {@link #childClassesRegistry}, the {@link #containmentReferenceSourcesRegistry}, and the
	 * {@link #targetClassReferencesRegistry}.
	 *
	 * @param targetMetaModel
	 *            The {@link EPackage} representing the target meta-model to be analyzed.
	 */
	private void analyseTargetMetaModel(final EPackage targetMetaModel) {

		// Retrieve all EClass defined in the targetMetaModel
		//
		final List<EClass> classesToAnalyse = this.getClasses(targetMetaModel);

		// Determine the child EClasses for each EClass
		//
		classesToAnalyse.stream().forEach(eClass -> eClass.getEAllSuperTypes().stream()
				.forEach(superEClass -> this.childClassesRegistry.get(superEClass).add(eClass)));

		// For each containment EReference defined in the target meta-model,
		// 1. register the EClasses that hold the ERefrence and
		// 2. register to which EClasses this EReference points
		//
		classesToAnalyse.stream().forEach(e -> e.getEAllContainments().stream().forEach(c -> {

			if (this.targetClassReferencesRegistry.containsKey(c.getEReferenceType())) {

				if (!this.containmentReferenceSourcesRegistry.containsKey(c)) {
					this.containmentReferenceSourcesRegistry.put(c, new LinkedHashSet<EClass>());
				}
				this.containmentReferenceSourcesRegistry.get(c).add(e);

				this.targetClassReferencesRegistry.get(c.getEReferenceType()).add(c);

			} else {
				this.logger.warning(() -> "Ignoring targetMetaModel reference " + c.getName() + " of element "
						+ e.getName() + " " + c.getEReferenceType().getName() + " " + c.getEType().getName());
			}

		}));

		// Add inherited containment references
		classesToAnalyse.stream().forEach(e -> this.childClassesRegistry.get(e).stream().forEach(c -> {
			this.targetClassReferencesRegistry.get(c).addAll(this.targetClassReferencesRegistry.get(e));
		}));
	}

	/**
	 * This is the getter for the {@link #attrValRegistry}.
	 *
	 * @return The {@link AttributeValueRegistry} where created values for target attributes are registered.
	 */
	public AttributeValueRegistry getAttrValRegistry() {

		return this.attrValRegistry;
	}

	/**
	 * This is the getter for the {@link #libraryEntryRegistry}.
	 *
	 * @return The {@link LibraryEntryRegistry} keeping track of temporarily created {@link EObjectWrapper elements}
	 *         representing {@link LibraryEntry LibraryEntries} that need to be instantiated by means of the associated
	 *         {@link LibraryEntryInstantiator}..
	 */
	public LibraryEntryRegistry getLibraryEntryRegistry() {

		return this.libraryEntryRegistry;
	}

	/**
	 * For a given {@link EClass}, returns the set of <em>child classes</em> (i.e., all classes for that
	 * {@link EClass#getEAllSuperTypes()} contains the given <em>eClass</em>) registered in the
	 * {@link #childClassesRegistry}.
	 *
	 * @param superClass
	 *            The {@link EClass} for that the child classes shall be returned.
	 * @return The set of {@link EClass EClasses} that have the given class as super-type.
	 */
	public Set<EClass> getChildClasses(final EClass superClass) {

		return this.childClassesRegistry.containsKey(superClass) ? this.childClassesRegistry.get(superClass)
				: new LinkedHashSet<>();

	}

	/**
	 * This determines and returns all {@link EClass EClasses} that are defined in the given {@link EPackage} and all
	 * sub-packages.
	 *
	 * @param rootEPackage
	 *            The {@link EPackage} to scan.
	 * @return The set of {@link EClass EClasses} contained in the given <em>rootEPackage</em>.
	 */
	private List<EClass> getClasses(final EPackage rootEPackage) {

		Set<EClass> classes = new LinkedHashSet<>();

		// collect all sub-packages
		//
		Set<EPackage> packagesToScan = EPackageHelper.collectEPackages(rootEPackage, true, true, true,
				Optional.empty());

		// scan all packages
		//
		for (EPackage ePackage : packagesToScan) {

			final EClass docroot = ExtendedMetaData.INSTANCE.getDocumentRoot(ePackage);

			ePackage.getEClassifiers().stream().filter(c -> c instanceof EClass).forEach(c -> {

				// ignore DocumentRoot classes created when converting xsd to
				// ecore
				if (docroot != null && docroot.equals(c)) {
					return;
				}

				classes.add((EClass) c);
			});
		}

		// register all found classes
		//
		for (EClass c : classes) {
			this.childClassesRegistry.put(c, new LinkedHashSet<EClass>());
			this.targetClassReferencesRegistry.put(c, new LinkedHashSet<EReference>());
		}

		return new ArrayList<>(classes);
	}

	/**
	 * Returns the set of {@link EReference EReferences} from the {@link #targetClassReferencesRegistry} with a
	 * {@link EReference#getEReferenceType()} that is compatible with the a given {@link EClass}.
	 *
	 * @param targetEClass
	 *            The {@link EClass} for that the set of {@link EReference EReferences} shall be determined.
	 * @return The set of {@link EReference EReferences} that ponit to the given <em>targetEClass</em> or to a
	 *         super-class.
	 */
	public Set<EReference> getClassReferences(final EClass targetEClass) {

		return this.targetClassReferencesRegistry.containsKey(targetEClass)
				? this.targetClassReferencesRegistry.get(targetEClass)
				: new LinkedHashSet<>();

	}

	/**
	 * Determines and returns the list of possible {@link MetaModelPath connections} between two {@link EClass
	 * EClasses}.
	 * <p />
	 * Additionally, determined paths are registered in the {@link #possibleConnectionsRegistry} for future uses.
	 *
	 * @param eClass
	 *            The {@link EClass} of the root element of a target section that needs to be connected
	 * @param containerClass
	 *            The {@link EClass} that is modeled to contain the target section to be connected.
	 * @param maxPathLength
	 *            The maximum length of the path (maximum number of intermediary elements); <em>0</em> for only direct
	 *            connections; <em>-1</em> for an unbounded length.
	 * @return The list of possible {@link MetaModelPath ModelConnectionPaths} to connect the given classes.
	 */
	public List<MetaModelPath> getConnections(EClass eClass, EClass containerClass, final int maxPathLength) {

		if (!this.possibleConnectionsRegistry.containsKey(eClass)) {
			this.possibleConnectionsRegistry.put(eClass, new LinkedHashMap<EClass, Set<MetaModelPath>>());
		}
		if (!this.possibleConnectionsRegistry.get(eClass).containsKey(containerClass)) {
			this.possibleConnectionsRegistry.get(eClass).put(containerClass, new LinkedHashSet<MetaModelPath>());

			MetaModelPath.findPathsFromContainerToClassToConnect(this, eClass, containerClass, maxPathLength);
		}

		if (this.possibleConnectionsRegistry.get(eClass).containsKey(containerClass)) {

			return new ArrayList<>(this.possibleConnectionsRegistry.get(eClass).get(containerClass));
		} else {
			return new ArrayList<>();
		}
	}

	/**
	 * For a given {@link TargetSectionClass}, this returns all created {@link EObjectWrapper instances} that have been
	 * registered to this registry.
	 * <p />
	 * Note: If the given {@link TargetSectionClass} is an {@link Section#isAbstract() abstract} {@link TargetSection},
	 * this returns the instances created for all concrete extending {@link TargetSection TargetSections} instead.
	 *
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} for that all instances shall be returned.
	 * @return The list of {@link EObjectWrapper EObjectWrappers} created for the given TargetSectionClass.
	 */
	public List<EObjectWrapper> getFlattenedPamtramClassInstances(TargetSectionClass targetSectionClass) {

		List<TargetSectionClass> classesToConsider = targetSectionClass != null
				? targetSectionClass.getAllConcreteExtending()
				: Collections.emptyList();

		return classesToConsider.stream().filter(this.targetClassInstanceByHintGroupRegistry::containsKey).flatMap(
				c -> this.targetClassInstanceByHintGroupRegistry.get(c).values().stream().flatMap(Collection::stream))
				.collect(Collectors.toList());

	}

	/**
	 * This returns the set of {@link EClass EClasses} represented in the {@link #childClassesRegistry}.
	 *
	 * @return The key set represented in the {@link #childClassesRegistry}.
	 */
	public Set<EClass> getMetaModelClasses() {

		return this.childClassesRegistry.keySet();
	}

	/**
	 * For the given {@link TargetSectionClass}, this returns the list of created {@link EObjectWrapper instances}
	 * sorted by the {@link InstantiableMappingHintGroup} they were created by.
	 *
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} for that the created instances shall be returned.
	 * @return The list of created {@link EObjectWrapper instances} for the given <em>targetSectionClass</em> sorted by
	 *         the {@link InstantiableMappingHintGroup} they were created by.
	 */
	public Map<InstantiableMappingHintGroup, List<EObjectWrapper>> getPamtramClassInstances(
			TargetSectionClass targetSectionClass) {

		if (!this.targetClassInstanceByHintGroupRegistry.containsKey(targetSectionClass)) {
			return new LinkedHashMap<>();
		}

		return this.targetClassInstanceByHintGroupRegistry.get(targetSectionClass);

	}

	/**
	 * Determines and returns the list of possible {@link MetaModelPath connections} to connect the given
	 * {@link EClass}.
	 * <p />
	 * Additionally, determined paths are registered in the {@link #possibleConnectionsRegistry} for future uses.
	 *
	 * @param eClass
	 *            The {@link EClass}of the root element of a target section that needs to be connected.
	 * @param maxPathLength
	 *            The maximum length of the path (maximum number of intermediary elements); <em>0</em> for only direct
	 *            connections; <em>-1</em> for an unbounded length.
	 * @return The list of possible {@link MetaModelPath ModelConnectionPaths} to connect the given class.
	 */
	public Set<MetaModelPath> getPaths(final EClass eClass, final int maxPathLength) {

		if (!this.possiblePathsRegistry.containsKey(eClass)) {
			this.possiblePathsRegistry.put(eClass, new LinkedHashSet<MetaModelPath>());

			MetaModelPath.findPathsToInstances(this, eClass, maxPathLength);
		}

		return this.possiblePathsRegistry.get(eClass);

	}

	/**
	 * Retrieve all {@link EClass EClasses} that hold the given {@link EReference} from the
	 * {@link #containmentReferenceSourcesRegistry}.
	 * <p />
	 * Note: This will return the EClass defining the given EReference as well as all EClasses inheriting from this
	 * EClass.
	 *
	 * @param ref
	 *            The {@link EReference} for that the holding {@link EClass EClasses} shall be retrieved.
	 * @return The set of {@link EClass EClasses} that are the starting point for the given {@link EReference}.
	 */
	public Set<EClass> getReferenceSources(final EReference ref) {

		return this.containmentReferenceSourcesRegistry.containsKey(ref)
				? this.containmentReferenceSourcesRegistry.get(ref)
				: new LinkedHashSet<>();

	}

	/**
	 * For the given {@link EClass}, this returns the list of created {@link EObjectWrapper instances}.
	 *
	 * @param eClass
	 *            The {@link EClass} for that created instances shall be returned.
	 * @return The list of {@link EObjectWrapper EObjectWrappers} that have been created for the given EClass.
	 */
	public List<EObjectWrapper> getTargetClassInstances(EClass eClass) {

		return this.targetClassInstanceRegistry.containsKey(eClass) ? this.targetClassInstanceRegistry.get(eClass)
				: new LinkedList<>();
	}

	/**
	 * For the given {@link EObject}, this returns the created {@link EObjectWrapper}.
	 *
	 * @param instance
	 *            The {@link EObject} that is part of a target model.
	 * @return The {@link EObjectWrapper} that wraps the <em>instance</em>.
	 */
	public EObjectWrapper getInstanceWrapper(EObject instance) {

		return this.eObjectToEObjectWrapperMap.get(instance);
	}

}
