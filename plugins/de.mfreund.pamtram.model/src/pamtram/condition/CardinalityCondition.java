/**
 */
package pamtram.condition;

import pamtram.metamodel.SourceSectionClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.CardinalityCondition#getConditionSectionRef <em>Condition Section Ref</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getCardinalityCondition()
 * @model
 * @generated
 */
public interface CardinalityCondition extends Condition {
	/**
	 * Returns the value of the '<em><b>Condition Section Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Section Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Section Ref</em>' reference.
	 * @see #setConditionSectionRef(SourceSectionClass)
	 * @see pamtram.condition.ConditionPackage#getCardinalityCondition_ConditionSectionRef()
	 * @model required="true"
	 * @generated
	 */
	SourceSectionClass getConditionSectionRef();

	/**
	 * Sets the value of the '{@link pamtram.condition.CardinalityCondition#getConditionSectionRef <em>Condition Section Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Section Ref</em>' reference.
	 * @see #getConditionSectionRef()
	 * @generated
	 */
	void setConditionSectionRef(SourceSectionClass value);

} // SectionCondition
