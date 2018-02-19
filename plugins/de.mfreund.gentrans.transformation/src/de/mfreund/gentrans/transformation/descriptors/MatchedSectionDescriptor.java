package de.mfreund.gentrans.transformation.descriptors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.matching.dependencies.MatchingDependency;
import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * Instances of this class represent a part of a source model that has been matched against a {@link SourceSection}.
 * Thus, each instance represents an application point for/instance of a mapping (in later stages of a transformation,
 * this is reflected by a specified {@link #associatedMappingInstance}.
 *
 * @author mfreund
 */
public class MatchedSectionDescriptor {

	/**
	 * The {@link SourceSection} that is associated with this descriptor.
	 */
	protected SourceSection associatedSourceSection;

	/**
	 * The root {@link EObject} that is associated with this descriptor. This is an instance of the
	 * {@link #associatedSourceSection}.
	 */
	protected EObject associatedSourceModelElement;

	/**
	 * The {@link EObject elements} of the source model that are matched by this mapping instance associated with their
	 * {@link SourceSectionClass}.
	 * <p />
	 * Note: This contains only the elements that have been matched <em>directly</em> as part of the
	 * {@link #associatedSourceSection}. This means that this contains neither elements that have been matched as part
	 * of a {@link SourceSection#getContainer() container} nor elements that have been matched as part of the evaluation
	 * of a {@link SectionCrossReference}.
	 */
	protected LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSourceModelObjects;

	/**
	 * This keeps track of the {@link MatchedSectionDescriptor} that represents the {@link EObject#eContainer()} of the
	 * {@link #associatedSourceModelElement}.
	 * <p />
	 * This can be used to determine 'external hint values'.
	 */
	protected MatchedSectionDescriptor containerDescriptor;

	/**
	 * This keeps track of the {@link MatchedSectionDescriptor descriptors} that represent the elements referenced via
	 * {@link CrossReference CrossReferences}.
	 * <p />
	 * This can be used to determine 'external hint values'.
	 */
	protected Map<CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, List<MatchedSectionDescriptor>> referencedDescriptors;

	/**
	 * This keeps track of the {@link MappingInstanceDescriptor} that has been associated with this descriptor.
	 */
	protected MappingInstanceDescriptor associatedMappingInstance;

	/**
	 * The list of {@link MatchingDependency MatchingDependencies} that need to be resolved for this descriptor to be
	 * applicable.
	 */
	protected List<MatchingDependency> matchingDependencies;

	/**
	 * This creates an instance.
	 */
	public MatchedSectionDescriptor() {

		this.matchedSourceModelObjects = new LinkedHashMap<>();
		this.associatedSourceModelElement = null;
		this.associatedSourceSection = null;
		this.referencedDescriptors = new LinkedHashMap<>();
		this.matchingDependencies = new ArrayList<>();
	}

	/**
	 * This sets the {@link #associatedSourceSection}.
	 *
	 * @param associatedSourceSection
	 *            The {@link SourceSectionClass} that is associated with this descriptor.
	 */
	public void setAssociatedSourceSectionClass(SourceSection associatedSourceSection) {

		this.associatedSourceSection = associatedSourceSection;
	}

	/**
	 * This returns the {@link #associatedSourceSection}.
	 *
	 * @return The {@link SourceSectionClass} that is associated with this descriptor.
	 */
	public SourceSection getAssociatedSourceSection() {

		return this.associatedSourceSection;
	}

	/**
	 * This sets the {@link #associatedSourceModelElement}.
	 *
	 * @param associatedSourceModelElement
	 *            The {@link EObject} that is associated with this descriptor.
	 */
	public void setAssociatedSourceModelElement(EObject associatedSourceModelElement) {

		this.associatedSourceModelElement = associatedSourceModelElement;
	}

	/**
	 * This returns the {@link #associatedSourceModelElement}.
	 *
	 * @return The {@link EObject} that is associated with this descriptor.
	 */
	public EObject getAssociatedSourceModelElement() {

		return this.associatedSourceModelElement;
	}

	/**
	 * This returns the {@link #matchedSourceModelObjects}.
	 * <p />
	 * Note: The returned map is a clone of the {@link #matchedSourceModelObjects} so that changes to this map will not
	 * affect the {@link #matchedSourceModelObjects}.
	 *
	 * @param includeReferenced
	 *            If this is set to '<em>true</em>', the returned map will also contain the matched elements of all
	 *            {@link #getReferencedDescriptorsRecursive() directly or indirectly referenced} descriptors.
	 * @return map of the source model Objects mapped
	 */
	public Map<SourceSectionClass, Set<EObject>> getMatchedSourceModelObjects(boolean includeReferenced) {

		List<MatchedSectionDescriptor> descriptorsToConsider = new ArrayList<>(Arrays.asList(this));

		if (includeReferenced) {
			descriptorsToConsider.addAll(this.getReferencedDescriptorsRecursive());
		}

		// Merge and return the maps returned by calling 'getMatchedSourceModelObjects' for each of the descriptors
		//
		return descriptorsToConsider.stream().flatMap(d -> d.matchedSourceModelObjects.entrySet().stream())
				.collect(Collectors.toMap(Entry::getKey, e -> new LinkedHashSet<>(e.getValue()), (v1, v2) -> {
					v1.addAll(v2);
					return v1;
				}, LinkedHashMap::new));
	}

	/**
	 * From the {@link #matchedSourceModelObjects}, return those elements that have been matched against the given
	 * {@link SourceSectionClass}.
	 * <p />
	 * Note: If the given {@link SourceSectionClass} is an abstract {@link SourceSection}, the elements that have been
	 * matched against the concrete sub-sections are returned instead.
	 *
	 * @param sourceSectionClass
	 *            The {@link SourceSectionClass} for that the matched elements shall be returned.
	 * @param includeReferenced
	 *            If this is set to '<em>true</em>', the returned list will also contain the matched elements of all
	 *            {@link #getReferencedDescriptorsRecursive() directly or indirectly referenced} descriptors.
	 * @return The matched elements (an empty list is returned if no elements have been matched).
	 */
	public Set<EObject> getMatchedSourceModelElementsFor(SourceSectionClass sourceSectionClass,
			boolean includeReferenced) {

		Map<SourceSectionClass, Set<EObject>> matchesToConsider = this.getMatchedSourceModelObjects(includeReferenced);

		return sourceSectionClass.getAllConcreteExtending().stream()
				.flatMap(s -> matchesToConsider.getOrDefault(s, new HashSet<>()).stream())
				.collect(Collectors.toCollection(LinkedHashSet::new));

	}

	/**
	 * This returns the list of {@link EObject matched elements} represented by this descriptor.
	 * <p />
	 * In contrast to {@link #getMatchedSourceModelObjects(boolean)}, this does not sort the matched elements by the
	 * {@link SourceSectionClass} they represent.
	 *
	 * @param includeReferenced
	 *            If this is set to '<em>true</em>', the returned list will also contain the matched elements of all
	 *            {@link #getReferencedDescriptorsRecursive() directly or indirectly referenced} descriptors.
	 *
	 * @return The list of {@link EObject matched elements} represented by this descriptor.
	 */
	public Set<EObject> getMatchedSourceModelObjectFlat(boolean includeReferenced) {

		return this.getMatchedSourceModelObjects(includeReferenced).entrySet().stream().map(Entry::getValue)
				.flatMap(Set::stream).collect(Collectors.toCollection(LinkedHashSet::new));
	}

	/**
	 * Register one mapped source model object.
	 *
	 * @param element
	 *            The {@link EObject element} to be marked as mapped.
	 * @param srcSectionClass
	 *            The {@link SourceSectionClass} that the <em>element</em> is associated with.
	 */
	public void addSourceModelObjectMapped(final EObject element, final SourceSectionClass srcSectionClass) {

		if (!this.matchedSourceModelObjects.containsKey(srcSectionClass)) {
			this.matchedSourceModelObjects.put(srcSectionClass, new LinkedHashSet<EObject>());
		}
		this.matchedSourceModelObjects.get(srcSectionClass).add(element);

	}

	/**
	 * Register mapped source model elements.
	 *
	 * @param refs
	 *            A map containing {@link SourceSectionClass SourceSectionClasses} and associated {@link EObject
	 *            elements} to be marked as 'mapped' for this descriptor
	 */
	public void addSourceModelObjectsMapped(final Map<SourceSectionClass, Set<EObject>> refs) {

		for (final Entry<SourceSectionClass, Set<EObject>> entry : refs.entrySet()) {

			if (!this.matchedSourceModelObjects.containsKey(entry.getKey())) {
				this.matchedSourceModelObjects.put(entry.getKey(), new LinkedHashSet<EObject>());
			}
			this.matchedSourceModelObjects.get(entry.getKey()).addAll(entry.getValue());
		}
	}

	/**
	 * Check if the given '<em>element</em>' has been matched as part of this descriptor.
	 *
	 * @param element
	 *            The {@link EObject element} that shall be checked.
	 * @param includeReferenced
	 *            If this is set to '<em>true</em>', the check will also consider the matched elements of all
	 *            {@link #getReferencedDescriptorsRecursive() directly or indirectly referenced} descriptors.
	 * @return '<em><b>true</b></em>' if the <em>element</em> has been matched, '<em><b>false</b></em>' otherwise.
	 */
	public boolean containsSourceModelObject(final EObject element, boolean includeReferenced) {

		return this.getMatchedSourceModelObjectFlat(includeReferenced).contains(element);
	}

	/**
	 * Check if the given '<em>element</em>' has been matched as part of this descriptor against any of the given
	 * {@link SourceSectionClass SourceSectionClasses}.
	 *
	 * @param element
	 *            The {@link EObject element} that shall be checked.
	 * @param sourceSectionClasses
	 *            The list of {@link SourceSectionClass SourceSectionClasses} to check. The {@link EObject element} that
	 *            shall be checked.
	 * @param includeReferenced
	 *            If this is set to '<em>true</em>', the check will also consider the matched elements of all
	 *            {@link #getReferencedDescriptorsRecursive() directly or indirectly referenced} descriptors.
	 * @return '<em><b>true</b></em>' if the <em>element</em> has been matched, '<em><b>false</b></em>' otherwise.
	 */
	public boolean containsSourceModelObject(final EObject element, List<SourceSectionClass> sourceSectionClasses,
			boolean includeReferenced) {

		return sourceSectionClasses.parallelStream()
				.anyMatch(c -> this.getMatchedSourceModelElementsFor(c, includeReferenced).contains(element));
	}

	/**
	 * This returns the {@link #containerDescriptor}.
	 *
	 * @return The {@link MatchedSectionDescriptor} that represents the {@link EObject#eContainer()} of the
	 *         {@link #associatedSourceModelElement}.
	 */
	public MatchedSectionDescriptor getContainerDescriptor() {

		return this.containerDescriptor;
	}

	/**
	 * Set the {@link #containerDescriptor}.
	 *
	 * @param containerDescriptor
	 *            tThe {@link MatchedSectionDescriptor} that represents the {@link EObject#eContainer()} of the
	 *            {@link #associatedSourceModelElement}.
	 */
	public void setContainerDescriptor(MatchedSectionDescriptor containerDescriptor) {

		this.containerDescriptor = containerDescriptor;
	}

	/**
	 * @return the {@link #referencedDescriptors}
	 */
	public Map<CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, List<MatchedSectionDescriptor>> getReferencedDescriptors() {

		return this.referencedDescriptors;
	}

	/**
	 * Recursively collect the {@link MatchedSectionDescriptor descriptors} directly and indirectly referenced by this.
	 *
	 * @return the {@link #referencedDescriptors}
	 */
	public List<MatchedSectionDescriptor> getReferencedDescriptorsRecursive() {

		List<MatchedSectionDescriptor> descriptors = new ArrayList<>();

		this.getReferencedDescriptorsRecursive(descriptors);

		return descriptors;
	}

	/**
	 * Recursively collect the {@link MatchedSectionDescriptor descriptors} directly and indirectly referenced by this
	 * and add them to the given list.
	 *
	 * @param descriptors
	 *            the list where collected descriptors are stored
	 */
	protected void getReferencedDescriptorsRecursive(List<MatchedSectionDescriptor> descriptors) {

		List<MatchedSectionDescriptor> descriptorsToAdd = this.getReferencedDescriptors().values().stream()
				.flatMap(Collection::stream).filter(d -> !descriptors.contains(d)).collect(Collectors.toList());

		descriptors.addAll(descriptorsToAdd);

		descriptorsToAdd.stream().forEach(d -> d.getReferencedDescriptorsRecursive(descriptors));

	}

	/**
	 * Add the given <em>descriptorToAdd</em> to the list of {@link #referencedDescriptors}.
	 *
	 * @param reference
	 *            The {@link CrossReference} via that the given <em>descriptorToAdd<em> is referenced.
	 * @param descriptorToAdd
	 *            The {@link MatchedSectionDescriptor} to add.
	 */
	public void addReferencedDescriptor(
			CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> reference,
			MatchedSectionDescriptor descriptorToAdd) {

		List<MatchedSectionDescriptor> descriptors = this.referencedDescriptors.getOrDefault(reference,
				new ArrayList<>());
		descriptors.add(descriptorToAdd);
		this.referencedDescriptors.put(reference, descriptors);
	}

	/**
	 * This is the getter for the {@link #associatedMappingInstance}.
	 *
	 * @return The {@link MappingInstanceDescriptor} that has been associated with this descriptor.
	 */
	public MappingInstanceDescriptor getAssociatedMappingInstance() {

		return this.associatedMappingInstance;
	}

	/**
	 * This is the setter for the {@link #associatedMappingInstance}.
	 *
	 * @param associatedMappingInstance
	 *            The {@link MappingInstanceDescriptor} to be associated with this descriptor.
	 */
	public void setAssociatedMappingInstance(MappingInstanceDescriptor associatedMappingInstance) {

		this.associatedMappingInstance = associatedMappingInstance;
	}

	/**
	 * Add matched source model elements from another {@link MatchedSectionDescriptor}.
	 *
	 * @param otherDescriptor
	 *            The {@link MatchedSectionDescriptor} from that matched elements shall be added.
	 */
	public void add(final MatchedSectionDescriptor otherDescriptor) {

		// combine matched elements
		this.addSourceModelObjectsMapped(otherDescriptor.getMatchedSourceModelObjects(false));

	}

	/**
	 * From the given list of {@link MatchedSectionDescriptor descriptors}, select the one that
	 * {@link MatchedSectionDescriptor#matchedSourceModelObjects represents} the given {@link EObject}.
	 *
	 * @param element
	 *            The {@link EObject} for that the corresponding {@link MatchedSectionDescriptor} shall be returned.
	 * @param descriptorsToConsider
	 *            The list of {@link MatchedSectionDescriptor MatchedSectionDescriptors} in that shall be considered.
	 * @return The {@link MatchedSectionDescriptor} representing the given <em>element</em> (one of the list of
	 *         <em>descriptorsToConsider</em> or '<em>null</em>' if the element is not represented by any of the given
	 *         descriptors.
	 */
	public static MatchedSectionDescriptor getDescriptorForElement(EObject element,
			List<MatchedSectionDescriptor> descriptorsToConsider) {

		Optional<MatchedSectionDescriptor> descriptor = descriptorsToConsider.parallelStream()
				.filter(d -> d.getMatchedSourceModelObjectFlat(false).contains(element)).findAny();

		return descriptor.isPresent() ? descriptor.get() : null;
	}

	@Override
	public String toString() {

		return new StringBuilder("MatchedSectionDescriptor : (\n").append("\tassociatedSourceSectionClass: ")
				.append(this.associatedSourceSection).append("\n\tassociatedSourceModelElement: ")
				.append(this.associatedSourceModelElement).append("\n)").toString();
	}

	/**
	 * Returns the list of {@link #matchingDependencies}.
	 * <p />
	 * Note: This will return a view of the {@link #matchingDependencies} so modifying the returned list will not affect
	 * this.
	 *
	 * @return the {@link #matchingDependencies}.
	 */
	public List<MatchingDependency> getMatchingDependencies() {

		return new ArrayList<>(this.matchingDependencies);
	}

	/**
	 * This adds another {@link MatchingDependency} to the list of {@link #matchingDependencies} that need to be
	 * resolved for this descriptor to be applicable.
	 *
	 * @param dependencyToAdd
	 *            The {@link MatchingDependency} to add.
	 */
	public void addMatchingDependency(MatchingDependency dependencyToAdd) {

		this.matchingDependencies.add(dependencyToAdd);
	}

	/**
	 * This resolves a {@link MatchingDependency} by - depending on the concrete type of dependency - either setting the
	 * {@link #setContainerDescriptor(MatchedSectionDescriptor) ContainerDescriptor} or adding a
	 * {@link #addReferencedDescriptor(CrossReference, MatchedSectionDescriptor) ReferencedDescriptor} and removing it
	 * from the list of {@link #matchingDependencies}.
	 *
	 * @param dependencyToResolve
	 *            The {@link MatchingDependency} to resolve.
	 * @param registryToUseForDependencyResolution
	 *            The {@link MatchedSectionRegistry} that shall be used to retrieve the descriptors that resolve the
	 *            {@link MatchedSectionDescriptor#getMatchingDependencies() dependencies} of this preliminary
	 *            descriptor.
	 * @return '<em>true</em>' if the dependency was successfully resolved; '<em>false</em>' if the dependency could not
	 *         be resolved or was not part of the {@link #matchingDependencies} defined by this descriptor.
	 */
	public boolean resolveMatchingDependency(MatchingDependency dependencyToResolve,
			MatchedSectionRegistry registryToUseForDependencyResolution) {

		if (!this.matchingDependencies.contains(dependencyToResolve)) {
			return false;
		}

		List<MatchedSectionDescriptor> resolvingDescriptors = new ArrayList<>();

		for (EObject dependencyElement : dependencyToResolve.getSourceModelElements()) {

			Optional<MatchedSectionDescriptor> descriptor = registryToUseForDependencyResolution
					.getRegisteredDescriptorFor(dependencyElement);

			if (descriptor.isPresent() && dependencyToResolve.getSourceSectionClasses().stream().anyMatch(
					c -> descriptor.get().getMatchedSourceModelElementsFor(c, false).contains(dependencyElement))) {

				resolvingDescriptors.add(descriptor.get());

			} else if (dependencyToResolve.isOptional()) {

				continue;

			} else {

				return false;
			}
		}

		if (!dependencyToResolve.resolve(resolvingDescriptors)) {
			return false;
		}

		return this.matchingDependencies.remove(dependencyToResolve);
	}

	/**
	 * Resolve all {@link MatchedSectionDescriptor#getMatchingDependencies() dependencies} that this is based on.
	 *
	 * @param registryToUseForDependencyResolution
	 *            The {@link MatchedSectionRegistry} that shall be used to retrieve the descriptors that resolve the
	 *            {@link MatchedSectionDescriptor#getMatchingDependencies() dependencies} of this preliminary
	 *            descriptor.
	 * @return The list of dependencies that could not be
	 *         {@link #resolveMatchingDependency(MatchingDependency, MatchedSectionRegistry) resolved}.
	 */
	public List<MatchingDependency> resolveMatchingDependencies(
			MatchedSectionRegistry registryToUseForDependencyResolution) {

		return this.getMatchingDependencies().stream()
				.filter(d -> !this.resolveMatchingDependency(d, registryToUseForDependencyResolution))
				.collect(Collectors.toList());
	}
}
