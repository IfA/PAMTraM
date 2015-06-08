/**
 *
 */
package de.mfreund.gentrans.transformation;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.ModelConnectionHintSourceInterface;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSectionClass;
import de.mfreund.gentrans.transformation.maps.AttributeMappingHintValueMap;
import de.mfreund.gentrans.transformation.maps.AttributeBasedHintValueMap;
import de.mfreund.gentrans.transformation.maps.MappingInstanceSelectorHintValueMap;
import de.mfreund.gentrans.transformation.maps.ModelConnectionHintValueMap;

/**
 * Class for storing HintValues and target section objects generated by applying
 * a Mapping.
 * <p>
 * Objects of this Class can be seen as Instances of a mapping.
 *
 * @author Sascha Steffen
 * @version 1.0
 */
class MappingInstanceStorage {
	
	/**
	 * The source model Objects, referenced by containment References, that were
	 * mapped by this mapping instance.
	 */
	private LinkedHashMap<SourceSectionClass, Set<EObject>> sourceModelObjetsMapped;

	/**
	 * The associated Mapping
	 */
	private Mapping mapping;

	/**
	 * The EObject associated to the root Class of the soureceMMSection of the
	 * mapping.
	 */
	private EObject associatedSourceModelElement;

	/**
	 * The SourceSectionClass associated to the root Class of the soureceMMSection
	 * of the mapping.
	 */
	private SourceSectionClass associatedSourceClass;

	/**
	 * Generated EObjects sorted by TargetSectionCLass
	 */
	private final LinkedHashMap<InstantiableMappingHintGroup, LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>>> instancesBySection;

	/**
	 * Hint values of {@link AttributeMapping AttributeMappings} to be used when instantiating the mapping's target section(s).
	 * <p/>
	 * Note: These are not associated with a {@link SourceSectionClass} in contrast to the {@link #unSyncedAttrMappings}.
	 */
	private final AttributeMappingHintValueMap attributeMappingHintValues;
	
	/**
	 * Hint values of {@link MappingInstanceSelector MappingInstanceSelectors} to be used when instantiating non-containment
	 * references from the mapping's target sections to other target sections.
	 * <p/>
	 * Note: These are not associated with a {@link SourceSectionClass} in contrast to the {@link #unSyncedAttrMatchers}.
	 */
	private final MappingInstanceSelectorHintValueMap mappingInstanceSelectorHintValues;

	/**
	 * Hint values of {@link ModelConnectionHint ModelConnectionHints} to be used when linking the generated 
	 * sections to the rest of the generated target model
	 * <p/>
	 * Note: These are not associated with a {@link SourceSectionClass} in contrast to the {@link #unSyncedConnectionHints}.
	 */
	private final ModelConnectionHintValueMap modelConnectionHintValues;

	/**
	 * Unsynced hints used by complexMappingHints
	 */
	private final AttributeMappingHintValueMap unSyncedAttrMappings;
	private final MappingInstanceSelectorHintValueMap unSyncedAttrMatchers;
	private final ModelConnectionHintValueMap unSyncedConnectionHints;

	/**
	 * This constructs an instance.
	 */
	MappingInstanceStorage() {
		sourceModelObjetsMapped = new LinkedHashMap<SourceSectionClass, Set<EObject>>();
		mapping = null;
		associatedSourceModelElement = null;
		associatedSourceClass = null;
		instancesBySection = new LinkedHashMap<InstantiableMappingHintGroup, LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>>>();
		attributeMappingHintValues = new AttributeMappingHintValueMap();
		mappingInstanceSelectorHintValues = new MappingInstanceSelectorHintValueMap();
		modelConnectionHintValues = new ModelConnectionHintValueMap();
		unSyncedAttrMappings = new AttributeMappingHintValueMap();
		unSyncedAttrMatchers = new MappingInstanceSelectorHintValueMap();
		unSyncedConnectionHints = new ModelConnectionHintValueMap();

	}

	/**
	 * Add mapped source model Objects and HintValues of another
	 * MappingInstanceStorage
	 *
	 * @param newRefsAndHints
	 */
	void add(final MappingInstanceStorage newRefsAndHints) {
		// combine refs
		addSourceModelObjectsMapped(newRefsAndHints
				.getSourceModelObjectsMapped());

		// combine hints
		attributeMappingHintValues.addHintValues(newRefsAndHints.getAttributeMappingHintValues());
		mappingInstanceSelectorHintValues.addHintValues(newRefsAndHints.getMappingInstanceSelectorHintValues());
		modelConnectionHintValues.addHintValues(newRefsAndHints.getModelConnectionHintValues());

		// combine unsynced hints
		addUnSyncedHintValues(newRefsAndHints.getUnSyncedComplexAttrMappings(),
				newRefsAndHints.getUnSyncedComplexAttrMatchers(),
				newRefsAndHints.getUnSyncedComplexConnectionHints());

	}

	/**
	 * Register several new target model instances
	 *
	 * @param grp
	 * @param section
	 * @param insts
	 */
	void addInstances(final InstantiableMappingHintGroup grp,
			final TargetSectionClass section,
			final Collection<EObjectTransformationHelper> insts) {
		generateInstancesCollectionsIfNeeded(grp, section);
		instancesBySection.get(grp).get(section).addAll(insts);
	}

	/**
	 * Add new value for a {@link ModelConnectionHint}.
	 *
	 * @param hint
	 * @param value
	 */
	void addModelConnectionHintValue(final ModelConnectionHint hint,
			final Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> value) {
		modelConnectionHintValues.addHintValue(hint, value);
	}

	/**
	 * Add values for several {@link ModelConnectionHints}.
	 *
	 * @param newHintValues
	 */
	void addModelConnectionHintValues(
			final AttributeBasedHintValueMap<ModelConnectionHint, ModelConnectionHintSourceInterface> newHintValues) {
	
		modelConnectionHintValues.addHintValues(newHintValues);
	}

	/**
	 * Register mapped source model object
	 *
	 * @param srcModelElement
	 * @param srcSectionClass
	 */
	void addSourceModelObjectMapped(final EObject srcModelElement,
			final SourceSectionClass srcSectionClass) {
		if (!sourceModelObjetsMapped.containsKey(srcModelElement)) {
			sourceModelObjetsMapped.put(srcSectionClass,
					new LinkedHashSet<EObject>());
		}
		sourceModelObjetsMapped.get(srcSectionClass).add(srcModelElement);

	}

	/**
	 * Register mapped source model objects
	 *
	 * @param refs
	 */
	void addSourceModelObjectsMapped(
			final LinkedHashMap<SourceSectionClass, Set<EObject>> refs) {
		for (final SourceSectionClass key : refs.keySet()) {
			if (!sourceModelObjetsMapped.containsKey(key)) {
				sourceModelObjetsMapped.put(key, new LinkedHashSet<EObject>());
			}
			sourceModelObjetsMapped.get(key).addAll(refs.get(key));
		}
	}

	/**
	 * This adds all hint values that are collected in the different {@link AttributeBasedHintValueMap HintValueMaps}
	 * that are passed as parameters to the corresponding maps of unsynced hint values.
	 * 
	 * @param unSyncedAttrMappings A map of hint values for {@link AttributeMapping AttributeMappings}.
	 * @param unSyncedAttrMatchers A map of hint values for {@link MappingInstanceSelector MappingInstanceSelectors}.
	 * @param unSyncedConnectionHints A map of hint values for {@link ModelConnectionHint ModelConnectionHints}.
	 */
	void addUnSyncedHintValues(
			final AttributeMappingHintValueMap unSyncedAttrMappings,
			final MappingInstanceSelectorHintValueMap unSyncedAttrMatchers,
			final ModelConnectionHintValueMap unSyncedConnectionHints) {

		this.unSyncedAttrMappings.addHintValues(unSyncedAttrMappings);
		this.unSyncedAttrMatchers.addHintValues(unSyncedAttrMatchers);
		this.unSyncedConnectionHints.addHintValues(unSyncedConnectionHints);
	}

	/**
	 * Check source model object registry wether object was mapped already
	 *
	 * @param object
	 * @return true - if EObject is registered
	 */
	boolean containsSourceModelObjectMapped(final EObject object) {
		return sourceModelObjetsMapped.values().contains(object);
	}

	/**
	 * Generate collections for grp and section in the instancesBySection Map in
	 * case they do not exist yet
	 *
	 * @param grp
	 * @param section
	 */
	private void generateInstancesCollectionsIfNeeded(
			final InstantiableMappingHintGroup grp,
			final TargetSectionClass section) {
		if (!instancesBySection.containsKey(grp)) {
			instancesBySection
			.put(grp,
					new LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>>());
		}

		if (!instancesBySection.get(grp).containsKey(section)) {
			instancesBySection.get(grp).put(section,
					new LinkedList<EObjectTransformationHelper>());
		}
	}

	/**
	 * @return associated SourceSectionClass
	 */
	SourceSectionClass getAssociatedSourceClass() {
		return associatedSourceClass;
	}

	/**
	 * @return associated source Model element
	 */
	EObject getAssociatedSourceModelElement() {
		return associatedSourceModelElement;
	}

	/**
	 * Getter for the {@link #attributeMappingHintValues}.
	 *
	 * @return The map of attribute mapping hint values that are currently collected
	 * with this {@link MappingInstanceStorage}. 
	 */
	AttributeMappingHintValueMap getAttributeMappingHintValues() {
		return attributeMappingHintValues;
	}
	
	/**
	 * Getter for the {@link #mappingInstanceSelectorHintValues}.
	 *
	 * @return The map of mapping instance selector hint values that are currently collected
	 * with this {@link MappingInstanceStorage}. 
	 */
	MappingInstanceSelectorHintValueMap getMappingInstanceSelectorHintValues() {
		return mappingInstanceSelectorHintValues;
	}

	/**
	 * Getter for the {@link #modelConnectionHintValues}.
	 *
	 * @return The map of model connection hint values that are currently collected
	 * with this {@link MappingInstanceStorage}. 
	 */
	final ModelConnectionHintValueMap getModelConnectionHintValues() {
		return modelConnectionHintValues;
	}

	/**
	 * generated target section instances associated with the MappingHintGroup
	 * and the specific section
	 *
	 * @param group
	 * @param section
	 * @return
	 */
	LinkedList<EObjectTransformationHelper> getInstances(
			final InstantiableMappingHintGroup group,
			final TargetSectionClass section) {
		if (instancesBySection.containsKey(group)) {
			return instancesBySection.get(group).get(section);

		} else
			return null;
	}

	/**
	 * Get generated target section instances associated with the
	 * MappingHintGroup
	 *
	 * @param group
	 * @return generated target section instances associated with the
	 *         MappingHintGroup
	 */
	LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>> getInstancesBySection(
			final InstantiableMappingHintGroup group) {
		return instancesBySection.get(group);
	}

	/**
	 * @return associated Mapping
	 */
	Mapping getMapping() {
		return mapping;
	}

	/**
	 * @param hint
	 * @return ModelConnectionHint values for the specified target section
	 */
	LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>> getModelConnectionHintValues(
			final ModelConnectionHint hint) {

		return modelConnectionHintValues.getHintValues(hint);
	}

	/**
	 * @return map of the source model Objects mapped
	 */
	final LinkedHashMap<SourceSectionClass, Set<EObject>> getSourceModelObjectsMapped() {
		return sourceModelObjetsMapped;
	}

	/**
	 * @return The unsynced hints used by {@link AttributeMapping AttributeMappings}.
	 */
	AttributeMappingHintValueMap getUnSyncedComplexAttrMappings() {
		return unSyncedAttrMappings;
	}

	/**
	 * @return
	 */
	MappingInstanceSelectorHintValueMap getUnSyncedComplexAttrMatchers() {
		return unSyncedAttrMatchers;
	}

	/**
	 * @return
	 */
	ModelConnectionHintValueMap getUnSyncedComplexConnectionHints() {
		return unSyncedConnectionHints;
	}

	/**
	 * @param associatedSourceClass
	 * @param associatedSourceModelElement
	 */
	void setAssociatedSourceElement(
			final SourceSectionClass associatedSourceClass,
			final EObject associatedSourceModelElement) {
		this.associatedSourceModelElement = associatedSourceModelElement;
		this.associatedSourceClass = associatedSourceClass;
	}

	/**
	 * Set the values for a {@link ModelConnectionHint}.
	 *
	 * @param hint
	 * @param newHintValues
	 */
	void setConnectionHintValueList(final ModelConnectionHint hint,
			final LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>> newHintValues) {
		modelConnectionHintValues.setHintValues(hint, newHintValues);

	}

	/**
	 * Set the values for an {@link AttributeMapping}.
	 *
	 * @param hint
	 * @param newHintValues
	 */
	void setAttributeMappingHintValueList(final AttributeMapping hint,
			final LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> newHintValues) {
		attributeMappingHintValues.setHintValues(hint, newHintValues);

	}
	
	/**
	 * Set the values for a {@link MappingInstanceSelector}.
	 *
	 * @param hint
	 * @param newHintValues
	 */
	void setMappingInstanceSelectorHintValueList(final MappingInstanceSelector hint,
			final LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>> newHintValues) {
		mappingInstanceSelectorHintValues.setHintValues(hint, newHintValues);

	}

	/**
	 * Set the associated mapping
	 *
	 * @param mapping
	 */
	void setMapping(final Mapping mapping) {
		this.mapping = mapping;
	}

	/**
	 * Set the map of source model objects mapped
	 *
	 * @param refs
	 */
	void setSourceModelObjectsMapped(
			final LinkedHashMap<SourceSectionClass, Set<EObject>> refs) {
		sourceModelObjetsMapped = refs;
	}

}
