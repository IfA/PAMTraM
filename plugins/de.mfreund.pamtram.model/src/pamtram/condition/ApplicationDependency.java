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
 * A condition that allows to check whether another 'ConditionalElement' was applied/executed (at least once; exactly n times; for the concrete section instance specified via the given 'InstanceSelector', ...).
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.ApplicationDependency#getConditionalElement <em>Conditional Element</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getApplicationDependency()
 * @model
 * @generated
 */
public interface ApplicationDependency extends Condition {
	/**
	 * Returns the value of the '<em><b>Conditional Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditional Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditional Element</em>' reference.
	 * @see #setConditionalElement(ConditionalElement)
	 * @see pamtram.condition.ConditionPackage#getApplicationDependency_ConditionalElement()
	 * @model required="true"
	 * @generated
	 */
	ConditionalElement getConditionalElement();

	/**
	 * Sets the value of the '{@link pamtram.condition.ApplicationDependency#getConditionalElement <em>Conditional Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conditional Element</em>' reference.
	 * @see #getConditionalElement()
	 * @generated
	 */
	void setConditionalElement(ConditionalElement value);

} // ApplicationDependency
