/**
 */
package pamtram.condition;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.Not#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getNot()
 * @model
 * @generated
 */
public interface Not extends ComplexCondition {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(ComplexCondition)
	 * @see pamtram.condition.ConditionPackage#getNot_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ComplexCondition getCondition();

	/**
	 * Sets the value of the '{@link pamtram.condition.Not#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(ComplexCondition value);

} // Not
