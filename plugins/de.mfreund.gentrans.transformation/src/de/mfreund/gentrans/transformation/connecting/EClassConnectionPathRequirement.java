/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import java.util.Objects;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * Instances of this class represent a requirement/request for a {@link EClassConnectionPath connection path} that
 * consists of an optional {@link #requiredStartingClass}, a {@link #requiredTargetClass}, and a
 * {@link #requiredMaximumPathLength}.
 * <p />
 * If no {@link #getRequiredStartingClass()} is specified, this means that all potential target classes may be used as
 * starting class.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class EClassConnectionPathRequirement {

	private final EClass requiredTargetClass;

	private EClass requiredStartingClass;

	private EObject requiredStartingElement;

	private Length requiredMaximumPathLength;

	private Capacity requiredMinimumCapacity;

	/**
	 * Creates an instance.
	 *
	 * @param requiredTargetClass
	 */
	public EClassConnectionPathRequirement(EClass requiredTargetClass) {

		this.requiredTargetClass = requiredTargetClass;
		this.requiredStartingClass = null;
		this.requiredStartingElement = null;
		this.requiredMaximumPathLength = Length.UNBOUNDED;
		this.requiredMinimumCapacity = Capacity.ZERO;
	}

	public EClassConnectionPathRequirement withRequiredStartingClass(EClass requiredStartingClass) {

		this.requiredStartingClass = requiredStartingClass;
		return this;
	}

	public EClassConnectionPathRequirement withRequiredStartingElement(EObject requiredStartingElement) {

		this.requiredStartingElement = requiredStartingElement;
		this.withRequiredStartingClass(requiredStartingElement.eClass());
		return this;
	}

	public EClassConnectionPathRequirement withRequiredMaximumPathLength(Length requiredMaximumPathLength) {

		this.requiredMaximumPathLength = requiredMaximumPathLength;
		return this;
	}

	public EClassConnectionPathRequirement withRequiredMinimumCapacity(Capacity requiredMinimumCapacity) {

		this.requiredMinimumCapacity = requiredMinimumCapacity;
		return this;
	}

	public EClass getRequiredStartingClass() {

		return this.requiredStartingClass;
	}

	public EObject getRequiredStartingElement() {

		return this.requiredStartingElement;
	}

	public EClass getRequiredTargetClass() {

		return this.requiredTargetClass;
	}

	public Length getRequiredMaximumPathLength() {

		return this.requiredMaximumPathLength;
	}

	public Capacity getRequiredMinimumCapacity() {

		return this.requiredMinimumCapacity;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		} else if (!(obj instanceof EClassConnectionPathRequirement)) {
			return false;
		}

		EClassConnectionPathRequirement requirement = (EClassConnectionPathRequirement) obj;

		return this.requiredMaximumPathLength == requirement.requiredMaximumPathLength
				&& Objects.equals(this.requiredStartingClass, requirement.requiredStartingClass)
				&& Objects.equals(this.requiredTargetClass, requirement.requiredTargetClass);
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.requiredStartingClass, this.requiredTargetClass, this.requiredMaximumPathLength);
	}

}
