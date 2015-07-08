/**
 */
package pamtram.condition;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>And</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.And#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getAnd()
 * @model
 * @generated
 */
public interface And extends ComplexCondition {
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
	 * @see pamtram.condition.ConditionPackage#getAnd_Condition()
	 * @model containment="true" lower="2"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!And!condition'"
	 * @generated
	 */
	EList<ComplexCondition> getCondition();

} // And
