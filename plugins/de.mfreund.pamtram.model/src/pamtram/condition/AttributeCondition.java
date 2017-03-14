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
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getAttributeCondition()
 * @model
 * @generated
 */
public interface AttributeCondition extends Condition<ActualSourceSectionAttribute> {
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

} // AttributeCondition
