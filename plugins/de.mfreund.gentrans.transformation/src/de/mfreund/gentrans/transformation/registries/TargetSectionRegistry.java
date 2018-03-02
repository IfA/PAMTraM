package de.mfreund.gentrans.transformation.registries;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import de.mfreund.gentrans.transformation.connecting.EClassConnectionPathFactory;
import de.mfreund.gentrans.transformation.core.CancelableTransformationAsset;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.library.LibraryEntryInstantiator;
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

	private final EClassConnectionPathFactory eClassConnectionPathFactory;

	/**
	 * @return the {@link #${bare_field_name}}
	 */
	// FIXME should not be publicly available
	public EClassConnectionPathFactory getEClassConnectionPathFactory() {

		return this.eClassConnectionPathFactory;
	}

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

		this.attrValRegistry = new AttributeValueRegistry();
		this.libraryEntryRegistry = new LibraryEntryRegistry();

		Set<EPackage> targetMetaModels = new LinkedHashSet<>(assetManager.getTransformationConfig().getPamtramModels()
				.stream().flatMap(p -> p.getTargetSectionModels().stream()).map(TargetSectionModel::getMetaModelPackage)
				.collect(Collectors.toList()));

		this.eClassConnectionPathFactory = new EClassConnectionPathFactory(targetMetaModels, this.logger);
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
