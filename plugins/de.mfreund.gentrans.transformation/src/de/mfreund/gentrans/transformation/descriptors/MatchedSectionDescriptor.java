package de.mfreund.gentrans.transformation.descriptors;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;

/**
 * Class for storing matched a part of a source model that has been matched against a {@link SourceSection}.
 * <p>
 * Objects of this class can be seen as instances of a source sections.
 *
 * @author mfreund
 */
public class MatchedSectionDescriptor {

	/**
	 * The root {@link SourceSectionClass} that is associated with this descriptor.
	 */
	private SourceSectionClass associatedSourceSectionClass;

	/**
	 * The root {@link EObject} that is associated with this descriptor. This is an instance of the
	 * {@link #associatedSourceSectionClass}.
	 */
	private EObject associatedSourceModelElement;

	/**
	 * The {@link EObject elements} of the source model that are matched by this mapping instance associated with their
	 * {@link SourceSectionClass}.
	 * <p />
	 * Note: This contains only the elements that have been matched <em>directly</em> as part of the
	 * {@link #associatedSourceSectionClass}. This means that this contains neither elements that have been matched as
	 * part of a <em>container</em> nor elements that have been matched as part of the evaluation of a
	 * {@link SectionCrossReference}.
	 */
	private LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSourceModelObjets;

	/**
	 * This keeps track of the {@link ValueConstraint AttributeValueConstraints} that need to be checked for the
	 * elements represented by this descriptor.
	 */
	private List<ValueConstraint> attributeValueConstraints;

	/**
	 * This keeps track of the {@link MatchedSectionDescriptor} that represents the {@link EObject#eContainer()} of the
	 * {@link #associatedSourceModelElement}.
	 * <p />
	 * This can be used to determine 'external hint values'.
	 */
	private MatchedSectionDescriptor containerDescriptor;

	/**
	 * This keeps track of the {@link MappingInstanceStorage} that has been associated with this descriptor.
	 */
	private MappingInstanceStorage associatedMappingInstance;

	/**
	 * This constructs an instance.
	 */
	public MatchedSectionDescriptor() {

		this.matchedSourceModelObjets = new LinkedHashMap<>();
		this.associatedSourceModelElement = null;
		this.associatedSourceSectionClass = null;
		this.attributeValueConstraints = new ArrayList<>();
	}

	/**
	 * This sets the {@link #associatedSourceSectionClass}.
	 *
	 * @param associatedSourceSectionClass
	 *            The {@link SourceSectionClass} that is associated with this descriptor.
	 */
	public void setAssociatedSourceSectionClass(SourceSectionClass associatedSourceSectionClass) {

		this.associatedSourceSectionClass = associatedSourceSectionClass;
	}

	/**
	 * This returns the {@link #associatedSourceSectionClass}.
	 *
	 * @return The {@link SourceSectionClass} that is associated with this descriptor.
	 */
	public SourceSectionClass getAssociatedSourceSectionClass() {

		return this.associatedSourceSectionClass;
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
	 *
	 * @return map of the source model Objects mapped
	 */
	public Map<SourceSectionClass, Set<EObject>> getMatchedSourceModelObjects() {

		return new LinkedHashMap<>(this.matchedSourceModelObjets);
	}

	/**
	 * From the {@link #matchedSourceModelObjets}, return those elements that have been matched against the given
	 * {@link SourceSectionClass}.
	 * <p />
	 * Note: If the given {@link SourceSectionClass} is an abstract {@link SourceSection}, the elements that have been
	 * matched against the concrete sub-sections are returned instead.
	 *
	 * @param sourceSectionClass
	 *            The {@link SourceSectionClass} for that the matched elements shall be returned.
	 * @return The matched elements (an empty list is returned if no elements have been matched).
	 */
	public Set<EObject> getMatchedSourceModelElementsFor(SourceSectionClass sourceSectionClass) {

		return sourceSectionClass.getAllConcreteExtending().stream()
				.filter(s -> this.matchedSourceModelObjets.containsKey(s))
				.flatMap(s -> this.matchedSourceModelObjets.get(s).stream())
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	/**
	 * This returns the list of {@link EObject matched elements} represented by this descriptor.
	 * <p />
	 * In contrast to {@link #getMatchedSourceModelObjects()}, this does not sort the matched elements by the
	 * {@link SourceSectionClass} they represent.
	 *
	 * @return The list of {@link EObject matched elements} represented by this descriptor.
	 */
	public Set<EObject> getMatchedSourceModelObjectFlat() {

		return this.matchedSourceModelObjets.entrySet().stream().map(Entry::getValue).flatMap(Set::stream)
				.collect(Collectors.toCollection(LinkedHashSet::new));
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

		if (!this.matchedSourceModelObjets.containsKey(srcSectionClass)) {
			this.matchedSourceModelObjets.put(srcSectionClass, new LinkedHashSet<EObject>());
		}
		this.matchedSourceModelObjets.get(srcSectionClass).add(element);

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
			if (!this.matchedSourceModelObjets.containsKey(entry.getKey())) {
				this.matchedSourceModelObjets.put(entry.getKey(), new LinkedHashSet<EObject>());
			}
			this.matchedSourceModelObjets.get(entry.getKey()).addAll(entry.getValue());
		}
	}

	/**
	 * Check if the given '<em>element</em>' has been mapped as part of this descriptor.
	 *
	 * @param element
	 *            The {@link EObject element} that shall be checked.
	 * @return '<em><b>true</b></em>' if the <em>element</em> has been mapped, ' <em><b>false</b></em>' otherwise.
	 */
	public boolean containsSourceModelObjectMapped(final EObject element) {

		return this.matchedSourceModelObjets.values().parallelStream().anyMatch(s -> s.contains(element));
	}

	/**
	 * Add to the list of {@link #attributeValueConstraints}.
	 *
	 * @param attributeValueConstraints
	 *            The list of {@link ValueConstraint AttributeValueConstraints} to add to the
	 *            {@link #attributeValueConstraints}.
	 */
	public void addAttributeValueConstraints(List<ValueConstraint> attributeValueConstraints) {

		this.attributeValueConstraints.addAll(attributeValueConstraints);
	}

	/**
	 * Add matched source model elements from another {@link MatchedSectionDescriptor}.
	 *
	 * @param otherDescriptor
	 *            The {@link MatchedSectionDescriptor} from that matched elements shall be added.
	 */
	public void add(final MatchedSectionDescriptor otherDescriptor) {

		// combine matched elements
		this.addSourceModelObjectsMapped(otherDescriptor.getMatchedSourceModelObjects());

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
	 * This is the getter for the {@link #associatedMappingInstance}.
	 *
	 * @return The {@link MappingInstanceStorage} that has been associated with this descriptor.
	 */
	public MappingInstanceStorage getAssociatedMappingInstance() {

		return this.associatedMappingInstance;
	}

	/**
	 * This is the setter for the {@link #associatedMappingInstance}.
	 *
	 * @param associatedMappingInstance
	 *            The {@link MappingInstanceStorage} to be associated with this descriptor.
	 */
	public void setAssociatedMappingInstance(MappingInstanceStorage associatedMappingInstance) {

		this.associatedMappingInstance = associatedMappingInstance;
	}

	/**
	 * From the given list of {@link MatchedSectionDescriptor descriptors}, select the one that
	 * {@link MatchedSectionDescriptor#matchedSourceModelObjets represents} the given {@link EObject}.
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
				.filter(d -> d.getMatchedSourceModelObjectFlat().contains(element)).findAny();

		return descriptor.isPresent() ? descriptor.get() : null;
	}

	@Override
	public String toString() {

		return new StringBuilder("MatchedSectionDescriptor : (\n").append("\tassociatedSourceSectionClass: ")
				.append(this.associatedSourceSectionClass).append("\n\tassociatedSourceModelElement: ")
				.append(this.associatedSourceModelElement).append("\n)").toString();
	}
}
