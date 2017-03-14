/**
 */
package pamtram.condition;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Condition Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.UnaryCondition#getLocalCondPart <em>Local Cond Part</em>}</li>
 *   <li>{@link pamtram.condition.UnaryCondition#getSharedCondPart <em>Shared Cond Part</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getUnaryCondition()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='exactlyOneArg'"
 * @generated
 */
public interface UnaryCondition extends ComplexCondition {
	/**
	 * Returns the value of the '<em><b>Local Cond Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Cond Part</em>' containment reference.
	 * @see #setLocalCondPart(ComplexCondition)
	 * @see pamtram.condition.ConditionPackage#getUnaryCondition_LocalCondPart()
	 * @model containment="true"
	 * @generated
	 */
	ComplexCondition getLocalCondPart();

	/**
	 * Sets the value of the '{@link pamtram.condition.UnaryCondition#getLocalCondPart <em>Local Cond Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Cond Part</em>' containment reference.
	 * @see #getLocalCondPart()
	 * @generated
	 */
	void setLocalCondPart(ComplexCondition value);

	/**
	 * Returns the value of the '<em><b>Shared Cond Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond Part Ref</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Cond Part</em>' reference.
	 * @see #setSharedCondPart(ComplexCondition)
	 * @see pamtram.condition.ConditionPackage#getUnaryCondition_SharedCondPart()
	 * @model
	 * @generated
	 */
	ComplexCondition getSharedCondPart();

	/**
	 * Sets the value of the '{@link pamtram.condition.UnaryCondition#getSharedCondPart <em>Shared Cond Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shared Cond Part</em>' reference.
	 * @see #getSharedCondPart()
	 * @generated
	 */
	void setSharedCondPart(ComplexCondition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getLocalCondPart() != null ^ this.getSharedCondPart() != null;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Please specify exactly one (local or shared) condition part!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.condition.util.ConditionValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tConditionValidator.UNARY_CONDITION__VALIDATE_EXACTLY_ONE_ARG,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.condition.ConditionPackage%>.Literals.UNARY_CONDITION }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateExactlyOneArg(DiagnosticChain diagnostics, Map<?, ?> context);

} // SingleConditionOperator
