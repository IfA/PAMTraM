/**
 */
package pamtram.condition;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.condition.Or#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.condition.ConditionPackage#getOr()
 * @model
 * @generated
 */
public interface Or extends ComplexCondition {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.condition.ComplexCondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference list.
	 * @see pamtram.condition.ConditionPackage#getOr_Condition()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<ComplexCondition> getCondition();

} // Or
