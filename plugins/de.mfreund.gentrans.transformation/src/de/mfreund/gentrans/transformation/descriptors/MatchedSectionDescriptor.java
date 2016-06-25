package de.mfreund.gentrans.transformation.descriptors;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.SourceSectionClass;

public class MatchedSectionDescriptor {

	/**
	 * The root {@link SourceSectionClass} that is associated with this
	 * descriptor.
	 */
	private SourceSectionClass associatedSourceSectionClass;

	/**
	 * The root {@link EObject} that is associated with this descriptor. This is
	 * an instance of the {@link #associatedSourceSectionClass}.
	 */
	private EObject associatedSourceModelElement;

	/**
	 * The {@link EObject elements} of the source model that are matched by this
	 * mapping instance associated with their {@link SourceSectionClass}.
	 * <p />
	 * Note: This contains only the elements that have been matched
	 * <em>directly</em> as part of the {@link #associatedSourceSectionClass}.
	 * This means that this contains neither elements that have been matched as
	 * part of a <em>container</em> nor elements that have been matched as part
	 * of the evaluation of a {@link MetaModelSectionReference}.
	 */
	private LinkedHashMap<SourceSectionClass, Set<EObject>> sourceModelObjetsMapped;

	/**
	 * This keeps track of the {@link AttributeValueConstraint
	 * AttributeValueConstraints} that need to be checked for the elements
	 * represented by this descriptor.
	 */
	private List<AttributeValueConstraint> attributeValueConstraints;

	/**
	 * This keeps track of the {@link MatchedSectionDescriptor} that represents the 
	 * {@link EObject#eContainer()} of the {@link #associatedSourceModelElement}.
	 * <p />
	 * This can be used to determine 'external hint values'.
	 */
	private MatchedSectionDescriptor containerDescriptor;

	/**
	 * This keeps track of the {@link MappingInstanceStorage} that has been associated with this
	 * descriptor.
	 */
	private MappingInstanceStorage associatedMappingInstance;

	/**
	 * This constructs an instance.
	 */
	public MatchedSectionDescriptor() {

		this.sourceModelObjetsMapped = new LinkedHashMap<>();
		this.associatedSourceModelElement = null;
		this.associatedSourceSectionClass = null;
		this.attributeValueConstraints = new ArrayList<>();
	}

	/**
	 * This sets the {@link #associatedSourceSectionClass}.
	 * 
	 * @param associatedSourceSectionClass
	 *            The {@link SourceSectionClass} that is associated with this
	 *            descriptor.
	 */
	public void setAssociatedSourceSectionClass(SourceSectionClass associatedSourceSectionClass) {
		this.associatedSourceSectionClass = associatedSourceSectionClass;
	}

	/**
	 * This returns the {@link #associatedSourceSectionClass}.
	 * 
	 * @return The {@link SourceSectionClass} that is associated with this
	 *         descriptor.
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
	public LinkedHashMap<SourceSectionClass, Set<EObject>> getSourceModelObjectsMapped() {
		return this.sourceModelObjetsMapped;
	}

	/**
	 * This returns the list of {@link EObject matched elements} represented by this descriptor.
	 * <p />
	 * In contrast to {@link #getSourceModelObjectsMapped()}, this does not sort the matched elements by 
	 * the {@link SourceSectionClass} they represent.
	 * 
	 * @return The list of {@link EObject matched elements} represented by this descriptor. 
	 */
	public Set<EObject> getSourceModelObjectFlat() {
		return this.sourceModelObjetsMapped.entrySet().parallelStream().map(e -> e.getValue()).
				flatMap(l -> l.stream()).collect(Collectors.toSet());
	}

	/**
	 * Register one mapped source model object.
	 *
	 * @param element
	 *            The {@link EObject element} to be marked as mapped.
	 * @param srcSectionClass
	 *            The {@link SourceSectionClass} that the <em>element</em> is
	 *            associated with.
	 */
	public void addSourceModelObjectMapped(final EObject element, final SourceSectionClass srcSectionClass) {
		if (!sourceModelObjetsMapped.containsKey(srcSectionClass)) {
			sourceModelObjetsMapped.put(srcSectionClass, new LinkedHashSet<EObject>());
		}
		sourceModelObjetsMapped.get(srcSectionClass).add(element);

	}

	/**
	 * Register mapped source model elements.
	 *
	 * @param refs
	 *            A map containing {@link SourceSectionClass
	 *            SourceSectionClasses} and associated {@link EObject elements}
	 *            to be marked as 'mapped' for this descriptor
	 */
	public void addSourceModelObjectsMapped(final LinkedHashMap<SourceSectionClass, Set<EObject>> refs) {
		for (final Entry<SourceSectionClass, Set<EObject>> entry : refs.entrySet()) {
			if (!sourceModelObjetsMapped.containsKey(entry.getKey())) {
				sourceModelObjetsMapped.put(entry.getKey(), new LinkedHashSet<EObject>());
			}
			sourceModelObjetsMapped.get(entry.getKey()).addAll(entry.getValue());
		}
	}

	/**
	 * Check if the given '<em>element</em>' has been mapped as part of this
	 * descriptor.
	 *
	 * @param element
	 *            The {@link EObject element} that shall be checked.
	 * @return '<em><b>true</b></em>' if the <em>element</em> has been mapped, '
	 *         <em><b>false</b></em>' otherwise.
	 */
	public boolean containsSourceModelObjectMapped(final EObject element) {
		return sourceModelObjetsMapped.values().parallelStream().anyMatch(s -> s.contains(element));
	}

	/**
	 * Add to the list of {@link #attributeValueConstraints}.
	 * 
	 * @param attributeValueConstraints
	 *            The list of {@link AttributeValueConstraint
	 *            AttributeValueConstraints} to add to the
	 *            {@link #attributeValueConstraints}.
	 */
	public void addAttributeValueConstraints(List<AttributeValueConstraint> attributeValueConstraints) {
		this.attributeValueConstraints.addAll(attributeValueConstraints);
	}

	/**
	 * Add matched source model elements from another
	 * {@link MatchedSectionDescriptor}.
	 *
	 * @param otherDescriptor
	 *            The {@link MatchedSectionDescriptor} from that matched
	 *            elements shall be added.
	 */
	public void add(final MatchedSectionDescriptor otherDescriptor) {

		// combine matched elements
		this.addSourceModelObjectsMapped(otherDescriptor.getSourceModelObjectsMapped());

	}

	/**
	 * This returns the {@link #containerDescriptor}.
	 * 
	 * @return The {@link MatchedSectionDescriptor} that represents the 
	 * {@link EObject#eContainer()} of the {@link #associatedSourceModelElement}.
	 */
	public MatchedSectionDescriptor getContainerDescriptor() {
		return containerDescriptor;
	}

	/**
	 * Set the {@link #containerDescriptor}.
	 * @param containerDescriptor tThe {@link MatchedSectionDescriptor} that represents the 
	 * {@link EObject#eContainer()} of the {@link #associatedSourceModelElement}.
	 */
	public void setContainerDescriptor(MatchedSectionDescriptor containerDescriptor) {
		this.containerDescriptor = containerDescriptor;
	}

	/**
	 * This is the getter for the {@link #associatedMappingInstance}.
	 * 
	 * @return The {@link MappingInstanceStorage} that has been associated with this
	 * descriptor.
	 */
	public MappingInstanceStorage getAssociatedMappingInstance() {
		return associatedMappingInstance;
	}

	/**
	 * This is the setter for the {@link #associatedMappingInstance}.
	 * 
	 * @param associatedMappingInstance The {@link MappingInstanceStorage} to be associated with this
	 * descriptor.
	 */
	public void setAssociatedMappingInstance(MappingInstanceStorage associatedMappingInstance) {
		this.associatedMappingInstance = associatedMappingInstance;
	}

}
