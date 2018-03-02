package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.mfreund.gentrans.transformation.connecting.EClassConnectionPath;

/**
 * An {@link EClassConnectionPath} that represents a complex path that is made up of (one or) multiple
 * segments each represented by a {@link DirectEClassConnectionPath}.
 *
 * @author mfreund
 */
public class ComplexEClassConnectionPath implements EClassConnectionPath {

	private LinkedList<DirectEClassConnectionPath> pathSegments;

	/**
	 * Create a new path based on a list of {@link DirectEClassConnectionPath segments}.
	 *
	 * @param pathSegments
	 */
	public ComplexEClassConnectionPath(List<DirectEClassConnectionPath> pathSegments) {

		this.pathSegments = new LinkedList<>(pathSegments);
	}

	/**
	 * @return the {@link #pathSegments}
	 */
	public List<DirectEClassConnectionPath> getPathSegments() {

		return Collections.unmodifiableList(this.pathSegments);
	}

	/**
	 * Calculates the paths <em>actual capacity</em> for the given {@link EObject rootElement} (how many elements can be
	 * connected to the rootElement via this path).
	 *
	 * @param rootElement
	 * @return The capacity of this path ('<em>-1</em>' is returned for paths with unbounded capacity).
	 */
	public int getCapacity(EObject rootElement) {

		EObject instance = rootElement;
		int max = 1;

		// iterate downward in the containment hierarchy starting from the root element of this path

		final ListIterator<DirectEClassConnectionPath> it = this.pathSegments.listIterator();
		while (it.hasNext()) {

			// the current parent element to connect 'targetInstance'
			final DirectEClassConnectionPath e = it.next();

			if (max < 1) {
				break;
			}

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
	public EClass getStartingClass() {

		return this.pathSegments.getFirst().getStartingClass();
	}

	@Override
	public EClass getTargetClass() {

		return this.pathSegments.getLast().getTargetClass();
	}

	@Override
	public int getLength() {

		return this.pathSegments.size() - 1;
	}

	/**
	 * Compares two instances of {@link ComplexEClassConnectionPath}.
	 *
	 * @param obj
	 *            An instance of {@link ComplexEClassConnectionPath} to be compared to this path.
	 * @return '<em><b>true</b></em>' if the elements of the two paths to be compared are equal and exist in the same
	 *         order; '<em><b>false</b></em>' otherwise or if 'obj' is no instance of
	 *         {@link ComplexEClassConnectionPath}.
	 */
	@Override
	public boolean equals(final Object obj) {

		if (this == obj) {
			return true;
		} else if (!(obj instanceof ComplexEClassConnectionPath)) {
			return false;
		} else {
			return this.pathSegments.equals(((ComplexEClassConnectionPath) obj).pathSegments);
		}

	}

	@Override
	public int hashCode() {

		return Objects.hash(this.pathSegments.toArray());
	}

	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		final ListIterator<DirectEClassConnectionPath> it = this.pathSegments.listIterator();

		stringBuilder.append(this.getStartingClass().getName());

		while (it.hasNext()) {

			final DirectEClassConnectionPath next = it.next();

			stringBuilder.append("...").append(next.getReference().getName()).append("...");

			stringBuilder.append(next.getTargetClass().getName());
		}

		return stringBuilder.toString();
	}

}
