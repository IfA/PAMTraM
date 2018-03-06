/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.Objects;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.mfreund.gentrans.transformation.connecting.Capacity;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;

/**
 * An {@link EClassConnectionPath} that represents a direct path between two {@link EClass EClasses} that consists of
 * just one {@link EReference}.
 *
 * @author mfreund
 */
public class DirectEClassConnectionPath implements EClassConnectionPath {

	private final EClass startingClass;

	private final EReference reference;

	private final EClass targetClass;

	/**
	 * Creates a new instance.
	 *
	 * @param startingClass
	 * @param reference
	 * @param targetClass
	 */
	public DirectEClassConnectionPath(EClass startingClass, EReference reference, EClass targetClass) {

		this.startingClass = startingClass;
		this.reference = reference;
		this.targetClass = targetClass;
	}

	/**
	 * @return the {@link #reference}
	 */
	public EReference getReference() {

		return this.reference;
	}

	@Override
	public EClass getTargetClass() {

		return this.targetClass;
	}

	@Override
	public EClass getStartingClass() {

		return this.startingClass;
	}

	@Override
	public int getLength() {

		return 1;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DirectEClassConnectionPath)) {
			return false;
		}

		DirectEClassConnectionPath other = (DirectEClassConnectionPath) obj;

		return Objects.equals(this.startingClass, other.startingClass)
				&& Objects.equals(this.reference, other.reference)
				&& Objects.equals(this.targetClass, other.targetClass);
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.startingClass, this.reference, this.targetClass);
	}

	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(this.getStartingClass().getName());

		stringBuilder.append("...").append(this.getReference().getName()).append("...");

		stringBuilder.append(this.getTargetClass().getName());

		return stringBuilder.toString();
	}

	@Override
	public Capacity getActualCapacity(EObject startingElement) {

		Capacity theoreticalCapacity = this.getTheoreticalCapacity();

		if (theoreticalCapacity.isUnbounded()) {
			return Capacity.UNBOUNDED;
		}

		int numberOfExistingTargetElementss = this.getNumberOfExistingTargetElements(startingElement);

		// should never be negative because actual cannot exceed theoretical capacity
		return new Capacity(theoreticalCapacity.getValue() - numberOfExistingTargetElementss);
	}

	private int getNumberOfExistingTargetElements(EObject startingElement) {

		return AgteleEcoreUtil.getStructuralFeatureValueAsList(startingElement, this.reference).size();
	}

	@Override
	public Capacity getTheoreticalCapacity() {

		return new Capacity(this.reference);
	}

	@Override
	public boolean describesConnectionBetween(EObject startingElement, EObject targetElement) {

		return AgteleEcoreUtil.getStructuralFeatureValueAsList(startingElement, this.reference).contains(targetElement);
	}

}