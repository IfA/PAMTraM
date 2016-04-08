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
 *   <li>{@link pamtram.condition.SectionCondition#getConditionSectionRef <em>Condition Section Ref</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getSectionCondition()
 * @model
 * @generated
 */
public interface SectionCondition extends Condition {
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
	 * @see pamtram.condition.ConditionPackage#getSectionCondition_ConditionSectionRef()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!SectionCondition!conditionSectionRef'"
	 * @generated
	 */
	SourceSectionClass getConditionSectionRef();

	/**
	 * Sets the value of the '{@link pamtram.condition.SectionCondition#getConditionSectionRef <em>Condition Section Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Section Ref</em>' reference.
	 * @see #getConditionSectionRef()
	 * @generated
	 */
	void setConditionSectionRef(SourceSectionClass value);

} // SectionCondition
