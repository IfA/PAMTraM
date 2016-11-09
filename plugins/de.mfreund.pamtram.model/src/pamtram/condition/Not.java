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
 *
 * @see pamtram.condition.ConditionPackage#getNot()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='referenceOnlyConditionsFromConditionModelOrFromConditionalElements'"
 * @generated
 */
public interface Not extends UnaryCondition {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.sharedCondPart == null) {\r\n\treturn true;\r\n}\r\n\r\nEObject sharedCondPartContainer = this.sharedCondPart.eContainer();\r\nreturn sharedCondPartContainer instanceof ConditionModel || sharedCondPartContainer instanceof ConditionalElement;'"
	 * @generated
	 */
	boolean referencesOnlyValidConditions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv referenceOnlyConditionsFromConditionModelOrFromConditionalElements:\n *   let severity : Integer[1] = 4\n *   in\n *     let status : OclAny[?] = self.referencesOnlyValidConditions()\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'Reference only Conditions that placed inside ConditionModel or where the Container is Kind of ConditionalElement!\'\n *         else null\n *         endif\n *       in\n *         \'Not::referenceOnlyConditionsFromConditionModelOrFromConditionalElements\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@Thrown\052/ boolean status = this.referencesOnlyValidConditions();\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.condition.ConditionTables%>.STR_Reference_32_only_32_Conditions_32_that_32_placed_32_inside_32_ConditionModel_32_or_32_w;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.condition.ConditionTables%>.STR_Not_c_c_referenceOnlyConditionsFromConditionModelOrFromConditionalE, this, null, diagnostics, context, message_0, <%pamtram.condition.ConditionTables%>.INT_4, CAUGHT_status, <%pamtram.condition.ConditionTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean referenceOnlyConditionsFromConditionModelOrFromConditionalElements(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Not
