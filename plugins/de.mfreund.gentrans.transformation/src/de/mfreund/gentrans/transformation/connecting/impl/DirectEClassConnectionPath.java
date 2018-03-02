/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.Objects;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import de.mfreund.gentrans.transformation.connecting.EClassConnectionPath;

/**
 * An {@link EClassConnectionPath} that represents a direct path between two {@link EClass EClasses} that
 * consists of just one {@link EReference}.
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

		return 0;
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
}