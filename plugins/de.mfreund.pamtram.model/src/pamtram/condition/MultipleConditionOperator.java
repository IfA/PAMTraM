/**
 */
package pamtram.condition;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiple Condition Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.MultipleConditionOperator#getCondParts <em>Cond Parts</em>}</li>
 *   <li>{@link pamtram.condition.MultipleConditionOperator#getCondPartsRef <em>Cond Parts Ref</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getMultipleConditionOperator()
 * @model abstract="true"
 * @generated
 */
public interface MultipleConditionOperator extends ComplexCondition {
	/**
	 * Returns the value of the '<em><b>Cond Parts</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.condition.ComplexCondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cond Parts</em>' containment reference list.
	 * @see pamtram.condition.ConditionPackage#getMultipleConditionOperator_CondParts()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!MultipleConditionOperator!condParts'"
	 * @generated
	 */
	EList<ComplexCondition> getCondParts();

	/**
	 * Returns the value of the '<em><b>Cond Parts Ref</b></em>' reference list.
	 * The list contents are of type {@link pamtram.condition.ComplexCondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond Parts Ref</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cond Parts Ref</em>' reference list.
	 * @see pamtram.condition.ConditionPackage#getMultipleConditionOperator_CondPartsRef()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!MultipleConditionOperator!condPartsRef'"
	 * @generated
	 */
	EList<ComplexCondition> getCondPartsRef();

} // MultipleConditionOperator
