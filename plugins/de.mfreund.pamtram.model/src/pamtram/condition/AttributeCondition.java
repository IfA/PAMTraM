/**
 */
package pamtram.condition;

import org.eclipse.emf.common.util.EList;

import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.source.ActualSourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.AttributeCondition#getValueConstraints <em>Value Constraints</em>}</li>
 *   <li>{@link pamtram.condition.AttributeCondition#getConditionAttributeRef <em>Condition Attribute Ref</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getAttributeCondition()
 * @model
 * @generated
 */
public interface AttributeCondition extends Condition {
	/**
	 * Returns the value of the '<em><b>Value Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.constraint.ValueConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Constraint</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Constraints</em>' containment reference list.
	 * @see pamtram.condition.ConditionPackage#getAttributeCondition_ValueConstraints()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ValueConstraint> getValueConstraints();

	/**
	 * Returns the value of the '<em><b>Condition Attribute Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Attribute Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Attribute Ref</em>' reference.
	 * @see #setTarget(ActualSourceSectionAttribute)
	 * @see pamtram.condition.ConditionPackage#getAttributeCondition_Target()
	 * @model required="true"
	 * @generated
	 */
	ActualSourceSectionAttribute getTarget();

	/**
	 * Sets the value of the '{@link pamtram.condition.AttributeCondition#getConditionAttributeRef <em>Condition Attribute Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Attribute Ref</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ActualSourceSectionAttribute value);

} // AttributeCondition
