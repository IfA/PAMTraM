/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import java.util.Objects;

import org.eclipse.emf.ecore.EClass;

/**
 *
 * @author mfreund
 */
public class EClassConnectionPathRequirement implements IEClassConnectionPathDescriptor {

	private final EClass startingClass;

	private final EClass targetClass;

	private final int maxPathLength;

	/**
	 *
	 *
	 * ${tags}
	 */
	public EClassConnectionPathRequirement(EClass startingClass, EClass targetClass, int maxPathLength) {

		this.startingClass = startingClass;
		this.targetClass = targetClass;
		this.maxPathLength = maxPathLength;
	}

	public EClassConnectionPathRequirement(EClass targetClass, int maxPathLength) {

		this.startingClass = null;
		this.targetClass = targetClass;
		this.maxPathLength = maxPathLength;
	}

	@Override
	public EClass getStartingClass() {

		return this.startingClass;
	}

	@Override
	public EClass getTargetClass() {

		return this.targetClass;
	}

	@Override
	public int getLength() {

		return this.maxPathLength;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EClassConnectionPathRequirement)) {
			return false;
		}

		EClassConnectionPathRequirement requirement = (EClassConnectionPathRequirement) obj;

		return this.maxPathLength == requirement.maxPathLength
				&& Objects.equals(this.getStartingClass(), requirement.getStartingClass())
				&& Objects.equals(this.getTargetClass(), requirement.getTargetClass());
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.startingClass, this.targetClass, this.maxPathLength);
	}

}
