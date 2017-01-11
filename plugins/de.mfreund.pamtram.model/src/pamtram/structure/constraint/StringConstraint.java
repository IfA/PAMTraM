/**
 */
package pamtram.structure.constraint;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.constraint.StringConstraint#getOperatorType <em>Operator Type</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.constraint.ConstraintPackage#getStringConstraint()
 * @model
 * @generated
 */
public interface StringConstraint extends CaseSensitiveConstraint {
	/**
	 * Returns the value of the '<em><b>Operator Type</b></em>' attribute.
	 * The literals are from the enumeration {@link pamtram.structure.constraint.StringConstraintOperatorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator Type</em>' attribute.
	 * @see pamtram.structure.constraint.StringConstraintOperatorType
	 * @see #setOperatorType(StringConstraintOperatorType)
	 * @see pamtram.structure.constraint.ConstraintPackage#getStringConstraint_OperatorType()
	 * @model required="true"
	 * @generated
	 */
	StringConstraintOperatorType getOperatorType();

	/**
	 * Sets the value of the '{@link pamtram.structure.constraint.StringConstraint#getOperatorType <em>Operator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator Type</em>' attribute.
	 * @see pamtram.structure.constraint.StringConstraintOperatorType
	 * @see #getOperatorType()
	 * @generated
	 */
	void setOperatorType(StringConstraintOperatorType value);

} // StringConstraint
