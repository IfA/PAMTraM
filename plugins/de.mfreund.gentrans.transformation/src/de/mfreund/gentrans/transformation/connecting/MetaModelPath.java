package de.mfreund.gentrans.transformation.connecting;

import java.util.LinkedList;
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
public class MetaModelPath {

	/**
	 * This holds the list of path elements.
	 *
	 * A path starts and ends with an instance of an {@link EClass} - the first element of the path is the target
	 * element (lower in the containment hierarchy) and the last element is the parent element (higher in the
	 * containment hierarchy). These are connected either by one {@link EReference} (containment) or pairs of
	 * EReferences and EClasses.
	 */
	private LinkedList<EObject> pathElements;

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
	public MetaModelPath(final LinkedList<EObject> pathElements, final EObject newElement,
			final boolean reverse) {

		this.pathElements = new LinkedList<>();
		this.pathElements.addAll(pathElements);
		this.pathElements.add(newElement);
		if (reverse) {
			this.pathElements = this.getInvertedPathElementList();
		}
	}

	/**
	 * This is the getter for the list of {@link #pathElements}.
	 *
	 * @return The elements forming this path.
	 */
	public LinkedList<EObject> getPathElements() {

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

		// gets toggled every loop, to help us separate refs from types
		boolean use = false;

		EObject instance = parentInstance;
		int max = 1;

		// iterate downward in the containment hierarchy starting from the root element of this path

		final ListIterator<EObject> it = this.pathElements.listIterator(this.pathElements.size());
		while (it.hasPrevious()) {

			// the current parent element to connect 'targetInstance'
			final EObject e = it.previous();

			if (max < 1) {
				break;
			}

			if (use) {

				// every second element in a path sequence is a reference, we only need those
				final EReference ref = (EReference) e;
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
			use = !use;// toggle use bit
		}

		return max;

	}

	/**
	 * This returns the inverted list of path elements (top-down instead of bottom-up).
	 *
	 * @return The inverted list of path elements.
	 */
	private LinkedList<EObject> getInvertedPathElementList() {

		final LinkedList<EObject> inverted = new LinkedList<>();
		final ListIterator<EObject> it = this.pathElements.listIterator(this.pathElements.size());

		while (it.hasPrevious()) {
			inverted.add(it.previous());

		}

		return inverted;
	}

	/**
	 * Returns the {@link EClass} that is the root of the path (the upper-most class in the containment hierarchy.
	 *
	 * @return The EClass of the end of the path.
	 */
	public EClass getPathRootClass() {

		return (EClass) this.pathElements.getLast();

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
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

		return !this.pathElements.isEmpty() && ((EClass) this.pathElements.getLast()).equals(root);
	}

	/**
	 * This return the number of elements in the path, i.e. length of the path.
	 *
	 * @return The number of elements in the path.
	 */
	public int size() {

		return this.pathElements.size();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		final ListIterator<EObject> it = this.pathElements.listIterator(this.pathElements.size());

		while (it.hasPrevious()) {

			final EObject prev = it.previous();
			if (prev instanceof EClass) {

				stringBuilder.append(((EClass) prev).getName());

			} else if (prev instanceof EReference) {

				// RegEx copied from:
				// https://stackoverflow.com/questions/1097901/regular-expression-split-string-by-capital-letter-but-ignore-tla
				stringBuilder.append("...")
						.append(((EReference) prev).getName()
								.replaceAll("((?<=\\p{Ll})\\p{Lu}|\\p{Lu}(?=\\p{Ll}))", " $1").toLowerCase().trim())
						.append("...");
			}
		}

		return stringBuilder.toString();
	}

}
