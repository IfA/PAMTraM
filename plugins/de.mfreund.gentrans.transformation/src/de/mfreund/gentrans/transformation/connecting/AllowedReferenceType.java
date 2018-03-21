/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import org.eclipse.emf.ecore.EReference;

/**
 * An enum indicating the type (containment/non-containment) of references allowed in an {@link EClassConnectionPath}.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public enum AllowedReferenceType {

	CONTAINMENT, NONCONTAINMENT, BOTH, UNKNOWN;

	public static AllowedReferenceType createFromReference(EReference reference) {

		if (reference == null) {
			return AllowedReferenceType.UNKNOWN;
		} else {
			return reference.isContainment() ? AllowedReferenceType.CONTAINMENT : NONCONTAINMENT;
		}
	}

	public boolean allows(EReference reference) {

		if (reference == null) {
			return false;
		} else if (this == AllowedReferenceType.BOTH) {
			return true;
		} else if (this == AllowedReferenceType.CONTAINMENT) {
			return reference.isContainment();
		} else if (this == AllowedReferenceType.NONCONTAINMENT) {
			return !reference.isContainment();
		} else {
			return false;
		}
	}
}
