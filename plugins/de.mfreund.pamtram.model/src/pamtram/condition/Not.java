/**
 */
package pamtram.condition;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Condition that evaluates to 'true' if the specified sub-condition evaluates to 'false'.
 * <br />
 * The sub-condition can be specified locally (via the 'localCondPart' reference) or globally (specified via the 'sharedCondPart' reference).
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.condition.ConditionPackage#getNot()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='referenceOnlyConditionsFromConditionModelOrFromConditionalElements'"
 * @generated
 */
public interface Not extends UnaryCondition {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.sharedCondPart == null) {\r\n\treturn true;\r\n}\r\n\r\n<%org.eclipse.emf.ecore.EObject%> sharedCondPartContainer = this.sharedCondPart.eContainer();\r\n\r\nboolean result = sharedCondPartContainer instanceof <%pamtram.ConditionModel%> || sharedCondPartContainer instanceof ConditionalElement;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Reference only Conditions that are placed inside ConditionModel or where the Container is a ConditionalElement!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.condition.util.ConditionValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tConditionValidator.NOT__VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL_OR_FROM_CONDITIONAL_ELEMENTS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.condition.ConditionPackage%>.Literals.UNARY_CONDITION__SHARED_COND_PART }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateReferenceOnlyConditionsFromConditionModelOrFromConditionalElements(DiagnosticChain diagnostics, Map<?, ?> context);

} // Not
