/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import java.util.Objects;

import org.eclipse.emf.ecore.EClass;

/**
 * Instances of this class represent a requirement/request for a {@link EClassConnectionPath connection path}
 * that consists of an optional {@link #requiredStartingClass}, a {@link #requiredTargetClass}, and a
 * {@link #requiredMaximumPathLength}.
 * <p />
 * If no {@link #getRequiredStartingClass()} is specified, this means that all potential target classes may be used as
 * starting class.
 *
 * @author mfreund
 */
public class EClassConnectionPathRequirement {

	private final EClass requiredStartingClass;

	private final EClass requiredTargetClass;

	private final int requiredMaximumPathLength;

	/**
	 * Creates an instance.
	 *
	 * @param requiredStartingClass
	 * @param requiredTargetClass
	 * @param requiredMaximumPathLength
	 */
	public EClassConnectionPathRequirement(EClass requiredStartingClass, EClass requiredTargetClass,
			int requiredMaximumPathLength) {

		this.requiredStartingClass = requiredStartingClass;
		this.requiredTargetClass = requiredTargetClass;
		this.requiredMaximumPathLength = requiredMaximumPathLength;
	}

	/**
	 * Creates an instance with an arbitrary {@link #requiredStartingClass}.
	 *
	 * @param requiredTargetClass
	 * @param requiredMaximumPathLength
	 */
	public EClassConnectionPathRequirement(EClass requiredTargetClass, int requiredMaximumPathLength) {

		this(null, requiredTargetClass, requiredMaximumPathLength);
	}

	/**
	 * @return the {@link #requiredStartingClass}
	 */
	public EClass getRequiredStartingClass() {

		return this.requiredStartingClass;
	}

	/**
	 * @return the {@link #requiredTargetClass}
	 */
	public EClass getRequiredTargetClass() {

		return this.requiredTargetClass;
	}

	/**
	 * @return the {@link #requiredMaximumPathLength}
	 */
	public int getRequiredMaximumPathLength() {

		return this.requiredMaximumPathLength;
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
