/**
 */
package pamtram.condition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Condition Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.SingleConditionOperator#getCondPart <em>Cond Part</em>}</li>
 *   <li>{@link pamtram.condition.SingleConditionOperator#getCondPartRef <em>Cond Part Ref</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getSingleConditionOperator()
 * @model abstract="true"
 * @generated
 */
public interface SingleConditionOperator extends ComplexCondition {
	/**
	 * Returns the value of the '<em><b>Cond Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cond Part</em>' containment reference.
	 * @see #setCondPart(ComplexCondition)
	 * @see pamtram.condition.ConditionPackage#getSingleConditionOperator_CondPart()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!SingleConditionOperator!condPart'"
	 * @generated
	 */
	ComplexCondition getCondPart();

	/**
	 * Sets the value of the '{@link pamtram.condition.SingleConditionOperator#getCondPart <em>Cond Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cond Part</em>' containment reference.
	 * @see #getCondPart()
	 * @generated
	 */
	void setCondPart(ComplexCondition value);

	/**
	 * Returns the value of the '<em><b>Cond Part Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond Part Ref</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cond Part Ref</em>' reference.
	 * @see #setCondPartRef(ComplexCondition)
	 * @see pamtram.condition.ConditionPackage#getSingleConditionOperator_CondPartRef()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!SingleConditionOperator!condPartRef'"
	 * @generated
	 */
	ComplexCondition getCondPartRef();

	/**
	 * Sets the value of the '{@link pamtram.condition.SingleConditionOperator#getCondPartRef <em>Cond Part Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cond Part Ref</em>' reference.
	 * @see #getCondPartRef()
	 * @generated
	 */
	void setCondPartRef(ComplexCondition value);

} // SingleConditionOperator
