package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

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
	final LinkedHashMap<SourceSectionClass, Set<EObject>> getSourceModelObjectsMapped() {
		return this.sourceModelObjetsMapped;
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
	void addSourceModelObjectMapped(final EObject element, final SourceSectionClass srcSectionClass) {
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
	void addSourceModelObjectsMapped(final LinkedHashMap<SourceSectionClass, Set<EObject>> refs) {
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
	boolean containsSourceModelObjectMapped(final EObject element) {
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

}
