/**
 */
package pamtram.structure.constraint;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ValueConstraint type that can be used for numeric attribute values. It (numerically) compares the determined attribute value to the calculated reference value.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.constraint.NumericConstraint#getOperatorType <em>Operator Type</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.constraint.ConstraintPackage#getNumericConstraint()
 * @model
 * @generated
 */
public interface NumericConstraint extends SingleReferenceValueConstraint {
	/**
	 * Returns the value of the '<em><b>Operator Type</b></em>' attribute.
	 * The literals are from the enumeration {@link pamtram.structure.constraint.NumericConstraintOperatorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The comparison type used to (numerically) compare the actual attribute value to the determined reference value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operator Type</em>' attribute.
	 * @see pamtram.structure.constraint.NumericConstraintOperatorType
	 * @see #setOperatorType(NumericConstraintOperatorType)
	 * @see pamtram.structure.constraint.ConstraintPackage#getNumericConstraint_OperatorType()
	 * @model required="true"
	 * @generated
	 */
	NumericConstraintOperatorType getOperatorType();

	/**
	 * Sets the value of the '{@link pamtram.structure.constraint.NumericConstraint#getOperatorType <em>Operator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator Type</em>' attribute.
	 * @see pamtram.structure.constraint.NumericConstraintOperatorType
	 * @see #getOperatorType()
	 * @generated
	 */
	void setOperatorType(NumericConstraintOperatorType value);

} // NumericConstraint
