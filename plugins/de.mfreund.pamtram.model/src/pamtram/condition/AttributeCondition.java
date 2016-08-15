/**
 */
package pamtram.condition;

import org.eclipse.emf.common.util.EList;

import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.ActualSourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.AttributeCondition#getValueConstraint <em>Value Constraint</em>}</li>
 *   <li>{@link pamtram.condition.AttributeCondition#getConditionAttributeRef <em>Condition Attribute Ref</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getAttributeCondition()
 * @model
 * @generated
 */
public interface AttributeCondition extends Condition {
	/**
	 * Returns the value of the '<em><b>Value Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.AttributeValueConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Constraint</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Constraint</em>' containment reference list.
	 * @see pamtram.condition.ConditionPackage#getAttributeCondition_ValueConstraint()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!AttributeCondition!valueConstraint'"
	 * @generated
	 */
	EList<AttributeValueConstraint> getValueConstraint();

	/**
	 * Returns the value of the '<em><b>Condition Attribute Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Attribute Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Attribute Ref</em>' reference.
	 * @see #setConditionAttributeRef(ActualSourceSectionAttribute)
	 * @see pamtram.condition.ConditionPackage#getAttributeCondition_ConditionAttributeRef()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!AttributeCondition!conditionAttributeRef'"
	 * @generated
	 */
	ActualSourceSectionAttribute getConditionAttributeRef();

	/**
	 * Sets the value of the '{@link pamtram.condition.AttributeCondition#getConditionAttributeRef <em>Condition Attribute Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Attribute Ref</em>' reference.
	 * @see #getConditionAttributeRef()
	 * @generated
	 */
	void setConditionAttributeRef(ActualSourceSectionAttribute value);

} // AttributeCondition
