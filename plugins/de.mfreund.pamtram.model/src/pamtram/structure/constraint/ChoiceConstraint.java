/**
 */
package pamtram.structure.constraint;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.constraint.ChoiceConstraint#getChoices <em>Choices</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.constraint.ConstraintPackage#getChoiceConstraint()
 * @model
 * @generated
 */
public interface ChoiceConstraint extends ValueConstraint {
	/**
	 * Returns the value of the '<em><b>Choices</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.constraint.EqualityConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Choices</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choices</em>' containment reference list.
	 * @see pamtram.structure.constraint.ConstraintPackage#getChoiceConstraint_Choices()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<EqualityConstraint> getChoices();

} // ChoiceConstraint
