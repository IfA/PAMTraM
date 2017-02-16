/**
 */
package pamtram.condition;

import pamtram.ConditionalElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A condition that allows to check whether another 'ConditionalElement' was applied/executed (at least once; exactly n times; for the concrete section instance specified via the given 'InstancePointer', ...).
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.ApplicationDependency#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getApplicationDependency()
 * @model
 * @generated
 */
public interface ApplicationDependency extends Condition {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditional Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ConditionalElement)
	 * @see pamtram.condition.ConditionPackage#getApplicationDependency_Target()
	 * @model required="true"
	 * @generated
	 */
	ConditionalElement getTarget();

	/**
	 * Sets the value of the '{@link pamtram.condition.ApplicationDependency#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ConditionalElement value);

} // ApplicationDependency
