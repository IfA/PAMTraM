/**
 */
package pamtram.structure.constraint;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ValueConstraint type that can be used for literal attribute values. It compares the determined attribute value to the calculated reference value based on a String comparison.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.constraint.StringConstraint#getOperatorType <em>Operator Type</em>}</li>
 *   <li>{@link pamtram.structure.constraint.StringConstraint#isCaseSensitive <em>Case Sensitive</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.constraint.ConstraintPackage#getStringConstraint()
 * @model
 * @generated
 */
public interface StringConstraint extends SingleReferenceValueConstraint {
	/**
	 * Returns the value of the '<em><b>Operator Type</b></em>' attribute.
	 * The literals are from the enumeration {@link pamtram.structure.constraint.StringConstraintOperatorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The comparison type used to compare the actual attribute value to the determined reference value.
	 * <!-- end-model-doc -->
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

	/**
	 * Returns the value of the '<em><b>Case Sensitive</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case Sensitive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the String comparison shall be performed case-sensitive (true) or case-insensitive (false).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Case Sensitive</em>' attribute.
	 * @see #setCaseSensitive(boolean)
	 * @see pamtram.structure.constraint.ConstraintPackage#getStringConstraint_CaseSensitive()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isCaseSensitive();

	/**
	 * Sets the value of the '{@link pamtram.structure.constraint.StringConstraint#isCaseSensitive <em>Case Sensitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Case Sensitive</em>' attribute.
	 * @see #isCaseSensitive()
	 * @generated
	 */
	void setCaseSensitive(boolean value);

} // StringConstraint
