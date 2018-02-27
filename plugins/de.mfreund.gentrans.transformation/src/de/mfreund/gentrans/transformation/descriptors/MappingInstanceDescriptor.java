/**
 *
 */
package de.mfreund.gentrans.transformation.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.matching.MappingSelector;
import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.MappingHintSourceInterface;
import pamtram.mapping.extended.MappingHintType;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionClass;

/**
 * Objects of this class can be seen as instances of a {@link Mapping} (executed for one
 * {@link #matchedSectionDescriptor}).
 * <p />
 * Therefore, each instance stores the {@link #hintValues} used for the instantiation and the instantiated
 * {@link #instancesBySection elements}.
 *
 * @author mfreund
 */
public class MappingInstanceDescriptor {

	/**
	 * The associated Mapping
	 */
	private Mapping mapping;

	/**
	 * Generated EObjects sorted by TargetSectionCLass
	 */
	private final Map<InstantiableMappingHintGroup, Map<TargetSectionClass, List<EObjectWrapper>>> instancesBySection;

	/**
	 * This contains the hint values that shall be used when instantiating, linking, and expanding the target
	 * section(s).
	 */
	private final HintValueStorage hintValues;

	/**
	 * This keeps track of those {@link ConditionalElement ConditionalElements} contained in the {@link #mapping}
	 * (currently {@link MappingHintGroup MappingHintGroups} or {@link MappingHint MappingHints}) for that the checking
	 * of the conditions in the {@link MappingSelector} returned '<em>false</em>' for the current
	 * {@link #associatedSourceModelElement}. These shall not be taken into account during the instantiation.
	 */
	private final Set<ConditionalElement> elementsWithNegativeConditions;

	/**
	 * This keeps track of the {@link MatchedSectionDescriptor} that this mapping instance is associated with.
	 */
	private MatchedSectionDescriptor matchedSectionDescriptor;

	/**
	 * Whether extended parallelization shall be used during the transformation that might lead to the fact that the
	 * transformation result (especially the order of lists) varies between executions.
	 */
	private boolean useParallelization;

	/**
	 * This constructs an instance based on a given {@link MatchedSectionDescriptor}.
	 *
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} that this is associated with.
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the transformation that might lead to the fact
	 *            that the transformation result (especially the order of lists) varies between executions.
	 */
	public MappingInstanceDescriptor(MatchedSectionDescriptor matchedSectionDescriptor, boolean useParallelization) {

		this.matchedSectionDescriptor = matchedSectionDescriptor;
		this.matchedSectionDescriptor.setAssociatedMappingInstance(this);
		this.mapping = null;
		this.instancesBySection = Collections.synchronizedMap(new LinkedHashMap<>());
		this.hintValues = new HintValueStorage();
		this.elementsWithNegativeConditions = new HashSet<>();
		this.useParallelization = useParallelization;

	}

	/**
	 * This is the getter for the {@link #hintValues}.
	 *
	 * @return The hint values that shall be used when instantiating, linking, and expanding the target section(s).
	 */
	public HintValueStorage getHintValues() {

		return this.hintValues;
	}

	/**
	 * This adds a new {@link ConditionalElement} to the set of {@link #elementsWithNegativeConditions}. This will
	 * result in the element to be ignored during the steps of the transformation.
	 *
	 * @param element
	 *            The {@link ConditionalElement} to be added.
	 */
	public void addElementWithNegativeCondition(ConditionalElement element) {

		this.elementsWithNegativeConditions.add(element);
	}

	/**
	 * Whether the given {@link ConditionalElement} is part of the {@link #elementsWithNegativeConditions}.
	 *
	 * @param element
	 *            The {@link ConditionalElement} to be checked.
	 * @return '<em><b>true</b></em>' if the element is part of the {@link #elementsWithNegativeConditions};
	 *         '<em><b>false</b></em>' otherwise
	 */
	public boolean isElementWithNegativeCondition(ConditionalElement element) {

		return this.elementsWithNegativeConditions.contains(element);
	}

	// /**
	// * This adds matched source model elements and determined hint values of another MappingInstanceStorage.
	// *
	// * @param mappingInstanceStorage
	// * The {@link MappingInstanceDescriptor} describing the matched elements and determined hint values to
	// * add.
	// */
	// public void add(final MappingInstanceDescriptor mappingInstanceStorage) {
	//
	// // add matched source model elements
	// this.matchedSectionDescriptor.add(mappingInstanceStorage.getMatchedSectionDescriptor());
	//
	// // add hint values
	// this.hintValues.addHintValues(mappingInstanceStorage.getHintValues());
	//
	// }

	/**
	 * Register several new target model instances.
	 *
	 * @param mappingHintGroup
	 *            The {@link InstantiableMappingHintGroup} that was responsible for creating the new instances.
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} representing the new instances (this needs to be one of the classes
	 *            defined by the {@link TargetSection} referenced by the given {@link InstantiableMappingHintGroup}).
	 * @param instances
	 *            The list of {@link EObjectWrapper EObjectWrappers} representing the new instances to add (these need
	 *            to be instance of the given {@link TargetSectionClass}).
	 */
	public void addInstances(final InstantiableMappingHintGroup mappingHintGroup,
			final TargetSectionClass targetSectionClass, final Collection<EObjectWrapper> instances) {

		if (!this.instancesBySection.containsKey(mappingHintGroup)) {
			this.instancesBySection.put(mappingHintGroup, Collections.synchronizedMap(new LinkedHashMap<>()));
		}

		if (!this.instancesBySection.get(mappingHintGroup).containsKey(targetSectionClass)) {
			this.instancesBySection.get(mappingHintGroup).put(targetSectionClass,
					Collections.synchronizedList(new ArrayList<EObjectWrapper>()));
		}

		this.instancesBySection.get(mappingHintGroup).get(targetSectionClass).addAll(instances);
	}

	/**
	 * This returns the {@link SourceSectionClass} that is associated with this mapping instance (resp. the associated
	 * {@link #matchedSectionDescriptor}).
	 *
	 * @return The {@link SourceSectionClass} that is associated with this mapping instance.
	 */
	public SourceSectionClass getAssociatedSourceClass() {

		return this.matchedSectionDescriptor.getAssociatedSourceSection();
	}

	/**
	 * This returns the {@link EObject element} of the source model that is associated with this mapping instance (resp.
	 * the associated {@link #matchedSectionDescriptor}).
	 *
	 * @return The {@link EObject element} of the source model that is associated with this mapping instance.
	 */
	public EObject getAssociatedSourceModelElement() {

		return this.matchedSectionDescriptor.getAssociatedSourceModelElement();
	}

	/**
	 * This returns the target instances generated by this MappingInstanceStorage for the given
	 * {@link InstantiableMappingHintGroup} and {@link TargetSectionClass}.
	 *
	 * @param instantiableMappingHintGroup
	 *            The {@link InstantiableMappingHintGroup} for that generated instances shall be returned.
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} for that generated instances shall be returned.
	 * @return The list of {@link EObjectWrapper instance} generated by this MappingInstanceStorage or an empty list if
	 *         no instances have been created for the given combination of InstantiableMappingHintGroup and
	 *         TargetSectionClass.
	 */
	public List<EObjectWrapper> getInstances(final InstantiableMappingHintGroup instantiableMappingHintGroup,
			final TargetSectionClass targetSectionClass) {

		Map<TargetSectionClass, List<EObjectWrapper>> instanceMap = this.instancesBySection
				.containsKey(instantiableMappingHintGroup) ? this.instancesBySection.get(instantiableMappingHintGroup)
						: new HashMap<>();

		if (instanceMap.isEmpty()) {
			return new ArrayList<>();
		}

		// In case of abstract Sections, we do not consider the given TargetSectionClass but all (concrete) extending
		// Sections
		//
		List<TargetSectionClass> classesToConsider = targetSectionClass.getAllConcreteExtending();

		return classesToConsider.stream().filter(instanceMap::containsKey).flatMap(c -> instanceMap.get(c).stream())
				.collect(Collectors.toList());
	}

	/**
	 * This returns the target instances generated by this MappingInstanceStorage for the given
	 * {@link InstantiableMappingHintGroup}.
	 *
	 * @param instantiableMappingHintGroup
	 *            The {@link InstantiableMappingHintGroup} for that generated instances shall be returned.
	 * @return The generated target instances for the given InstantiableMappingHintGroup, sorted by their associated
	 *         {@link TargetSectionClass}.
	 */
	public Map<TargetSectionClass, List<EObjectWrapper>> getInstancesBySection(
			final InstantiableMappingHintGroup instantiableMappingHintGroup) {

		return this.instancesBySection.get(instantiableMappingHintGroup);
	}

	/**
	 * This is the getter for the {@link #mapping}.
	 *
	 * @return The {@link Mapping} associated with this MappingInstanceStorage.
	 */
	public Mapping getMapping() {

		return this.mapping;
	}

	/**
	 * This is the setter for the {@link #mapping}.
	 *
	 * @param mapping
	 *            The {@link Mapping} to be associated with this MappingInstanceStorage.
	 */
	public void setMapping(final Mapping mapping) {

		this.mapping = mapping;
	}

	/**
	 * This returns the {@link DeactivatableElement#isDeactivated() active} {@link MappingHintGroupType hint groups} of
	 * the {@link #mapping} associated with this. If the hint group is a {@link ConditionalElement} this also checks
	 * that the condition of the hint groups has not been determined as
	 * {@link #isElementWithNegativeCondition(ConditionalElement) false}.
	 *
	 * @return The list of active and valid {@link MappingHintGroupType hint groups} for this
	 *         {@link MappingInstanceDescriptor}.
	 */
	public List<MappingHintGroupType> getMappingHintGroups() {

		return (this.useParallelization ? this.getMapping().getActiveMappingHintGroups().parallelStream()
				: this.getMapping().getActiveMappingHintGroups().stream())
						.filter(hg -> !(hg instanceof ConditionalElement)
								|| !this.isElementWithNegativeCondition((ConditionalElement) hg))
						.collect(Collectors.toList());
	}

	/**
	 * This returns the {@link DeactivatableElement#isDeactivated() active} {@link MappingHintGroupImporter hint group
	 * importers} of the {@link #mapping} associated with this. This also checks that the condition of the hint group
	 * importers has not been determined as {@link #isElementWithNegativeCondition(ConditionalElement) false}.
	 *
	 * @return The list of active and valid {@link MappingHintGroupImporter hint group importers} for this
	 *         {@link MappingInstanceDescriptor}.
	 */
	public List<MappingHintGroupImporter> getMappingHintGroupImporters() {

		return (this.useParallelization ? this.getMapping().getActiveImportedMappingHintGroups().parallelStream()
				: this.getMapping().getActiveImportedMappingHintGroups().stream())
						.filter(hg -> !this.isElementWithNegativeCondition(hg)).collect(Collectors.toList());
	}

	/**
	 * This returns the {@link DeactivatableElement#isDeactivated() active} hints for all {@link #getMappingHintGroups()
	 * normal} and {@link #getMappingHintGroupImporters() imported} {@link InstantiableMappingHintGroup hintGroups} for
	 * that the condition has not been determined as {@link #isElementWithNegativeCondition(ConditionalElement) false}.
	 *
	 * @param includeImported
	 *            Whether the {@link MappingHint MappingHints} that are {@link MappingHintGroupImporter#getHintGroup()
	 *            imported} by {@link MappingHintGroupImporter MappingHintGroupImporters} shall be returned as well.
	 * @return The set of valid {@link MappingHint hints}.
	 */
	public Set<MappingHint> getMappingHints(boolean includeImported) {

		return Stream
				.concat(this.getMappingHintGroups().stream().flatMap(hg -> this.getMappingHints(hg).stream()),
						this.getMappingHintGroupImporters().stream()
								.flatMap(hg -> this.getMappingHints(hg, includeImported).stream()))
				.collect(Collectors.toCollection(LinkedHashSet::new));

	}

	/**
	 * This returns the {@link DeactivatableElement#isDeactivated() active} {@link ExportedMappingHintGroup
	 * ExportedMappingHintGroups} of the {@link #mapping} associated with this.
	 *
	 * @return The list of active and valid {@link ExportedMappingHintGroup ExportedMappingHintGroups} for this
	 *         {@link MappingInstanceDescriptor}.
	 */
	public List<ExportedMappingHintGroup> getExportedMappingHintGroups() {

		return (this.useParallelization ? this.getMapping().getActiveMappingHintGroups().parallelStream()
				: this.getMapping().getActiveMappingHintGroups().stream())
						.filter(hg -> hg instanceof ExportedMappingHintGroup).map(hg -> (ExportedMappingHintGroup) hg)
						.collect(Collectors.toList());
	}

	/**
	 * This returns the {@link DeactivatableElement#isDeactivated() active} hints for all
	 * {@link ExportedMappingHintGroup ExportedMappingHintGroups} for that the condition has not been determined as
	 * {@link #isElementWithNegativeCondition(ConditionalElement) false}.
	 *
	 * @return The set of valid exported {@link MappingHint hints}.
	 */
	public Set<MappingHint> getExportedMappingHints() {

		return this.getMappingHintGroups().stream().filter(hg -> hg instanceof ExportedMappingHintGroup)
				.flatMap(hg -> this.getMappingHints(hg).stream()).collect(Collectors.toCollection(LinkedHashSet::new));
	}

	/**
	 * This returns the {@link DeactivatableElement#isDeactivated() active} hints for the given
	 * {@link InstantiableMappingHintGroup hintGroup} for that the condition has not been determined as
	 * {@link #isElementWithNegativeCondition(ConditionalElement) false}.
	 * <p />
	 * Note: Depending on the concrete type of {@link InstantiableMappingHintGroup}, this just redirects to either
	 * {@link #getMappingHints(MappingHintGroupType)} or {@link #getMappingHints(MappingHintGroupImporter, boolean)}.
	 *
	 * @param hintGroup
	 *            The {@link InstantiableMappingHintGroup} for that the list of {@link MappingHint MappingHints} shall
	 *            be returned.
	 * @param includeImported
	 *            Whether the {@link MappingHint MappingHints} that are {@link MappingHintGroupImporter#getHintGroup()
	 *            imported} by {@link MappingHintGroupImporter MappingHintGroupImporters} shall be returned as well.
	 * @return The list of valid {@link MappingHint hints} for the given {@link InstantiableMappingHintGroup}.
	 */
	public List<MappingHint> getMappingHints(InstantiableMappingHintGroup hintGroup, boolean includeImported) {

		return hintGroup instanceof MappingHintGroupType ? this.getMappingHints((MappingHintGroupType) hintGroup)
				: this.getMappingHints((MappingHintGroupImporter) hintGroup, includeImported);
	}

	/**
	 * This returns the {@link DeactivatableElement#isDeactivated() active} hints for the given
	 * {@link MappingHintGroupType hintGroup} for that the condition has not been determined as
	 * {@link #isElementWithNegativeCondition(ConditionalElement) false}.
	 *
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} for that the list of {@link MappingHint MappingHints} shall be
	 *            returned.
	 * @return The list of valid {@link MappingHint hints} for the given {@link MappingHintGroupType}.
	 */
	public List<MappingHint> getMappingHints(MappingHintGroupType hintGroup) {

		if (hintGroup instanceof ConditionalElement
				&& this.isElementWithNegativeCondition((ConditionalElement) hintGroup)) {
			return new BasicEList<>();
		}

		return (this.useParallelization ? hintGroup.getActiveMappingHints().parallelStream()
				: hintGroup.getActiveMappingHints().stream()).filter(h -> !this.isElementWithNegativeCondition(h))
						.collect(Collectors.toList());
	}

	/**
	 * This returns the {@link MappingHintSourceInterface source elements} for the given {@link MappingHint} for that
	 * the condition has not been determined as {@link #isElementWithNegativeCondition(ConditionalElement) false}.
	 *
	 * @param hint
	 *            The {@link MappingHint} for that the {@link MappingHintSourceInterface source elements} shall be
	 *            returned.
	 * @return The list of {@link MappingHintSourceInterface source elements} excluding those with negative conditions.
	 */
	public List<MappingHintSourceInterface> getMappingHintSourceElements(MappingHint hint) {

		List<MappingHintSourceInterface> sourceElements = new ArrayList<>();

		if (hint instanceof AttributeMapping) {
			sourceElements.addAll(((AttributeMapping) hint).getSourceElements());
		} else if (hint instanceof ReferenceTargetSelector) {
			sourceElements.addAll(((ReferenceTargetSelector) hint).getSourceElements());
		} else if (hint instanceof ContainerSelector) {
			sourceElements.addAll(((ContainerSelector) hint).getSourceElements());
		} else if (hint instanceof CardinalityMapping) {
			sourceElements.addAll(((CardinalityMapping) hint).getSourceElements());
		}

		return sourceElements.stream().filter(s -> !this.isElementWithNegativeCondition(s))
				.collect(Collectors.toList());
	}

	/**
	 * This returns the {@link DeactivatableElement#isDeactivated() active} hints for the given
	 * {@link MappingHintGroupImporter hint group importer} for that the condition has not been determined as
	 * {@link #isElementWithNegativeCondition(ConditionalElement) false}.
	 * <p />
	 * Note: This not only returns those hint defined directly by the given {@link MappingHintGroupImporter} but also
	 * those defined by the {@link MappingHintGroupImporter#getHintGroup() imported} {@link ExportedMappingHintGroup}.
	 *
	 * @param hintGroupImporter
	 *            The {@link MappingHintGroupImporter} for that the list of {@link MappingHint MappingHints} shall be
	 *            returned.
	 * @param includeImported
	 *            Whether the {@link MappingHint MappingHints} that are {@link MappingHintGroupImporter#getHintGroup()
	 *            imported} by {@link MappingHintGroupImporter MappingHintGroupImporters} shall be returned as well.
	 * @return The list of valid {@link MappingHint hints} for the given {@link MappingHintGroupImporter}.
	 */
	public List<MappingHint> getMappingHints(MappingHintGroupImporter hintGroupImporter, boolean includeImported) {

		if (this.isElementWithNegativeCondition(hintGroupImporter)) {
			return new ArrayList<>();
		}

		Stream<MappingHintType> hints = hintGroupImporter.getActiveMappingHints().stream();

		if (includeImported) {
			hints = Stream.concat(hints, hintGroupImporter.getHintGroup().getActiveMappingHints().stream());
		}

		return hints
				.filter(h -> !(h instanceof ConditionalElement)
						|| !this.isElementWithNegativeCondition((ConditionalElement) h))
				.filter(hint -> hint instanceof MappingHint).map(hint -> (MappingHint) hint)
				.collect(Collectors.toList());
	}

	/**
	 * This returns the {@link EObject elements} of the source model - sorted by their {@link SourceSectionClass} - that
	 * are associated with this mapping instance (resp. the associated {@link #matchedSectionDescriptor}).
	 * <p />
	 * Note: This just redirects to {@link MatchedSectionDescriptor#getMatchedSourceModelObjects(boolean)} of the
	 * {@link #matchedSectionDescriptor}.
	 *
	 * @return The {@link EObject elements} of the source model - sorted by their {@link SourceSectionClass} - that are
	 *         associated with this mapping instance.
	 */
	public Map<SourceSectionClass, Set<EObject>> getMatchedSourceModelObjects() {

		return this.matchedSectionDescriptor.getMatchedSourceModelObjects(false);
	}

	/**
	 * This returns the {@link #matchedSectionDescriptor}.
	 *
	 * @return The {@link MatchedSectionDescriptor} that this is associated with.
	 */
	public MatchedSectionDescriptor getMatchedSectionDescriptor() {

		return this.matchedSectionDescriptor;
	}

	/**
	 * This returns the '<em>containerInstance</em>', i.e. the {@link MappingInstanceDescriptor} that represents the
	 * {@link EObject#eContainer()} of the {@link #getAssociatedSourceModelElement()}.
	 * <p />
	 * This can be used to determine 'external hint values'.
	 *
	 * @return The {@link MappingInstanceDescriptor} that represents the {@link EObject#eContainer()} of the
	 *         {@link #getAssociatedSourceModelElement()} or '<em><b>null</b></em>' if the associated
	 *         {@link #matchedSectionDescriptor} has no associated
	 *         {@link MatchedSectionDescriptor#getContainerDescriptor() containerDescriptor}.
	 */
	public MappingInstanceDescriptor getContainerInstance() {

		if (this.matchedSectionDescriptor.getContainerDescriptor() != null) {
			return this.matchedSectionDescriptor.getContainerDescriptor().getAssociatedMappingInstance();
		}

		return null;
	}

	@Override
	public String toString() {

		return new StringBuilder("MappingInstanceStorage : (\n").append("\tmapping: ").append(this.mapping)
				.append("\n\tassociatedSourceSectionClass: ")
				.append(this.matchedSectionDescriptor.getAssociatedSourceSection())
				.append("\n\tassociatedSourceModelElement: ")
				.append(this.matchedSectionDescriptor.getAssociatedSourceModelElement()).append("\n)").toString();
	}

}
