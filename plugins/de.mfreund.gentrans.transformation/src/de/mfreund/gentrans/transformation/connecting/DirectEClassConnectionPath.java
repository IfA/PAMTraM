/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import java.util.Objects;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class DirectEClassConnectionPath implements IEClassConnectionPathDescriptor {

	private final EClass sourceClass;

	private final EReference reference;

	private final EClass targetClass;

	public DirectEClassConnectionPath(EClass sourceClass, EReference reference, EClass targetClass) {

		this.sourceClass = sourceClass;
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

		return this.sourceClass;
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

		return Objects.equals(this.sourceClass, other.sourceClass) && Objects.equals(this.reference, other.reference)
				&& Objects.equals(this.targetClass, other.targetClass);
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.sourceClass, this.reference, this.targetClass);
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