/**
 */
package pamtram.condition;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiple Condition Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Condition that is composed of multiple sub-conditions.
 * <br />
 * The sub-conditions can be specified locally (via the 'localCondParts' reference) and/or globally (specified via the 'sharedCondParts' reference).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.VariadicCondition#getLocalCondParts <em>Local Cond Parts</em>}</li>
 *   <li>{@link pamtram.condition.VariadicCondition#getSharedCondParts <em>Shared Cond Parts</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getVariadicCondition()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='minimalNumberOfArgs'"
 * @generated
 */
public interface VariadicCondition extends ComplexCondition {
	/**
	 * Returns the value of the '<em><b>Local Cond Parts</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.condition.ComplexCondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of locally defined sub-conditions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Local Cond Parts</em>' containment reference list.
	 * @see pamtram.condition.ConditionPackage#getVariadicCondition_LocalCondParts()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComplexCondition> getLocalCondParts();

	/**
	 * Returns the value of the '<em><b>Shared Cond Parts</b></em>' reference list.
	 * The list contents are of type {@link pamtram.condition.ComplexCondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond Parts Ref</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of globally specified sub-conditions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shared Cond Parts</em>' reference list.
	 * @see pamtram.condition.ConditionPackage#getVariadicCondition_SharedCondParts()
	 * @model
	 * @generated
	 */
	EList<ComplexCondition> getSharedCondParts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.sharedCondParts == null || this.sharedCondParts.size() == 0) {\r\n\treturn true;\r\n}\r\nEList<ComplexCondition> conditionRefs = new BasicEList<ComplexCondition>();\r\nconditionRefs.add((ComplexCondition) this.sharedCondParts);\r\nfor(ComplexCondition condition : conditionRefs){\r\n\tif(!(condition instanceof ConditionModel)){\r\n\t\treturn false;\r\n\t}\r\n}\r\nreturn true;'"
	 * @generated
	 */
	boolean referencesOnlyValidConditions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getLocalCondParts().size() + this.getSharedCondParts().size() > 1;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"At least two (local or shared) condition parts need to be specified!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.condition.util.ConditionValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tConditionValidator.VARIADIC_CONDITION__VALIDATE_MINIMAL_NUMBER_OF_ARGS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.condition.ConditionPackage%>.Literals.VARIADIC_CONDITION }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateMinimalNumberOfArgs(DiagnosticChain diagnostics, Map<?, ?> context);

} // MultipleConditionOperator
