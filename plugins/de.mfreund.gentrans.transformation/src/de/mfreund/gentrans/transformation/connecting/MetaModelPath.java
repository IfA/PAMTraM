package de.mfreund.gentrans.transformation.connecting;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Instances of this class represent a connection path (via containment references) between two {@link EObject
 * EObjects}. Therefore, this holds a list that of EObjects that alternately represent an {@link EClass} and an
 * {@link EReference} and that form the path <b>upward</b> in the containment hierarchy. Additionally, a bunch of
 * methods that are provided that allow handling this List.
 *
 * @author mfreund
 *
 */
public class MetaModelPath implements IEClassConnectionPathDescriptor {

	/**
	 * This holds the list of path elements.
	 *
	 * A path starts and ends with an instance of an {@link EClass} - the first element of the path is the target
	 * element (lower in the containment hierarchy) and the last element is the parent element (higher in the
	 * containment hierarchy). These are connected either by one {@link EReference} (containment) or pairs of
	 * EReferences and EClasses.
	 */
	private LinkedList<EClassConnectionPathSegment> pathElements;

	/**
	 * Private Constructor to be used when spawning new Paths during path search. Clones the path and appends new
	 * element.
	 *
	 * @param pathElements
	 *            The existing elements of the connection path (EObjects representing {@link EClass EClasses} and
	 *            {@link EReference EReferences} in alternating order.
	 * @param newElement
	 *            The new element for the connection path (an EObject that represents either an {@link EClass} or an
	 *            {@link EReference} depending on the last element of '<em>pathElements</em>'.
	 * @param reverse
	 *            '<em>true</em>' means that the path specified by '<em>pathElements</em>' + '<em>newElement</em>'
	 *            denotes a path in inverse order (bottom-up instead of top-down). In this case, the order of the
	 *            elements will be inverted to create a regular (top-down) path.
	 */
	public MetaModelPath(final List<EClassConnectionPathSegment> pathElements) {

		this.pathElements = new LinkedList<>(pathElements);
	}

	/**
	 * This is the getter for the list of {@link #pathElements}.
	 *
	 * @return The elements forming this path.
	 */
	public LinkedList<EClassConnectionPathSegment> getPathElements() {

		return this.pathElements;
	}

	/**
	 * Compares two instances of {@link MetaModelPath}.
	 *
	 * @param obj
	 *            An instance of {@link MetaModelPath} to be compared to this path.
	 * @return '<em><b>true</b></em>' if the elements of the two paths to be compared are equal and exist in the same
	 *         order; '<em><b>false</b></em>' otherwise or if 'obj' is no instance of {@link MetaModelPath}.
	 */
	@Override
	public boolean equals(final Object obj) {

		if (obj instanceof MetaModelPath) {
			return ((MetaModelPath) obj).pathElements.equals(this.pathElements);
		} else {
			return false;
		}
	}

	/**
	 * Calculates the paths '<em>capacity</em>' for the given '<em>parentInstance</em>' (how many elements can be
	 * connected to the parent instance via this path).
	 * <p />
	 * <b>Note:</b> If '<em>parentInstance</em>' is <em>null</em> the theoretical capacity of this path is calculated.
	 * <em>Theoretical</em> in this case means that the maximum cardinality for each reference that is part of the path
	 * is used instead of the actual cardinality based on the given parentInstance.
	 *
	 * @param parentInstance
	 *            The {@link EObject} for that the capacity of this path shall be calculated.
	 * @return The capacity of this path for the given 'parentInstance' ('<em>-1</em>' is returned for paths with
	 *         unbounded capacity).
	 */
	public int getCapacity(final EObject parentInstance) {

		EObject instance = parentInstance;
		int max = 1;

		// iterate downward in the containment hierarchy starting from the root element of this path

		final ListIterator<EClassConnectionPathSegment> it = this.pathElements.listIterator();
		while (it.hasNext()) {

			// the current parent element to connect 'targetInstance'
			final EClassConnectionPathSegment e = it.next();

			if (max < 1) {
				break;
			}

			// every second element in a path sequence is a reference, we only need those
			final EReference ref = e.getReference();
			if (instance != null) {

				final Object targets = instance.eGet(ref);

				if (targets != null) {
					if (ref.getUpperBound() == 1) {
						instance = (EObject) targets;
					} else if (ref.getUpperBound() > 1) {
						@SuppressWarnings("unchecked")
						final EList<EObject> targetsL = (EList<EObject>) targets;
						instance = null;
						max = max * (ref.getUpperBound() - targetsL.size());
					} else if (ref.getUpperBound() < 0) {
						return -1;
					} else { // can only be 0
						return 0;
					}
				} else {
					instance = null;
					max = max * ref.getUpperBound();
				}
			} else {
				max = max * ref.getUpperBound();
			}
		}

		return max;

	}

	@Override
	public int hashCode() {

		return this.pathElements.hashCode();
	}

	/**
	 * This can be used to check if this path leads to the given {@link EClass} 'root' (if 'root' denotes the container
	 * class of this path).
	 *
	 * @param root
	 *            The {@link EClass} that shall be checked as root of this path.
	 * @return '<em><b>true</b></em>' if this path leads to the specified EClass.
	 */
	public boolean leadsToRootType(final EClass root) {

		return this.getStartingClass().equals(root);
	}

	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		final ListIterator<EClassConnectionPathSegment> it = this.pathElements.listIterator();

		stringBuilder.append(this.getStartingClass().getName());

		while (it.hasNext()) {

			final EClassConnectionPathSegment next = it.next();

			stringBuilder.append("...").append(next.getReference().getName()).append("...");

			stringBuilder.append(next.getTargetClass().getName());
		}

		return stringBuilder.toString();
	}

	@Override
	public EClass getStartingClass() {

		return this.pathElements.getFirst().getStartingClass();
	}

	@Override
	public EClass getTargetClass() {

		return this.pathElements.getLast().getTargetClass();
	}

	@Override
	public int getLength() {

		return this.getPathElements().size();
	}

}
