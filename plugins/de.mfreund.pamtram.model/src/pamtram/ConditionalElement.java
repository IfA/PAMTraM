/**
 */
package pamtram;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;

import pamtram.condition.ComplexCondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.ConditionalElement#getLocalCondition <em>Local Condition</em>}</li>
 *   <li>{@link pamtram.ConditionalElement#getSharedCondition <em>Shared Condition</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getConditionalElement()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eitherModelOrReferCondition referenceOnlyConditionsFromConditionModel'"
 * @generated
 */
public interface ConditionalElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Condition</em>' containment reference.
	 * @see #setLocalCondition(ComplexCondition)
	 * @see pamtram.PamtramPackage#getConditionalElement_LocalCondition()
	 * @model containment="true"
	 * @generated
	 */
	ComplexCondition getLocalCondition();

	/**
	 * Sets the value of the '{@link pamtram.ConditionalElement#getLocalCondition <em>Local Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Condition</em>' containment reference.
	 * @see #getLocalCondition()
	 * @generated
	 */
	void setLocalCondition(ComplexCondition value);

	/**
	 * Returns the value of the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Condition</em>' reference.
	 * @see #setSharedCondition(ComplexCondition)
	 * @see pamtram.PamtramPackage#getConditionalElement_SharedCondition()
	 * @model
	 * @generated
	 */
	ComplexCondition getSharedCondition();

	/**
	 * Sets the value of the '{@link pamtram.ConditionalElement#getSharedCondition <em>Shared Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shared Condition</em>' reference.
	 * @see #getSharedCondition()
	 * @generated
	 */
	void setSharedCondition(ComplexCondition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = !(this.getLocalCondition() != null && this.getSharedCondition() != null);\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Please specify at most one (local or shared) condition!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\tPamtramValidator.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.util.PamtramValidator%>.CONDITIONAL_ELEMENT__VALIDATE_EITHER_MODEL_OR_REFER_CONDITION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, PamtramPackage.Literals.CONDITIONAL_ELEMENT }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateEitherModelOrReferCondition(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getSharedCondition() == null || this.eContainer() instanceof <%pamtram.ConditionModel%>;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"It is only allowed to reference shared conditions that are model inside the ConditionModel!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\tPamtramValidator.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.util.PamtramValidator%>.CONDITIONAL_ELEMENT__VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, PamtramPackage.Literals.CONDITIONAL_ELEMENT__SHARED_CONDITION }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateReferenceOnlyConditionsFromConditionModel(DiagnosticChain diagnostics, Map<?, ?> context);

} // ConditionalElement
