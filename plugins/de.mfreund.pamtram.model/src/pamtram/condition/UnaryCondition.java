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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!UnaryCondition!localCondPart'"
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!UnaryCondition!sharedCondPart'"
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv exactlyOneArg:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = self.localCondPart->size() +\n *       self.sharedCondPart->size() = 1\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'Please specify exactly one (local or shared) condition part!\'\n *         else null\n *         endif\n *       in\n *         \'UnaryCondition::exactlyOneArg\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@Thrown\052/ <%pamtram.condition.ComplexCondition%> localCondPart = this.getLocalCondPart();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> oclAsSet = <%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation%>.INSTANCE.evaluate(executor, <%pamtram.condition.ConditionTables%>.SET_CLSSid_ComplexCondition, localCondPart);\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(oclAsSet);\n    final /*@Thrown\052/ <%pamtram.condition.ComplexCondition%> sharedCondPart = this.getSharedCondPart();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> oclAsSet_0 = <%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation%>.INSTANCE.evaluate(executor, <%pamtram.condition.ConditionTables%>.SET_CLSSid_ComplexCondition, sharedCondPart);\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size_0 = <%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(oclAsSet_0);\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> sum = (<%org.eclipse.ocl.pivot.values.IntegerValue%>)<%org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation%>.INSTANCE.evaluate(size, size_0);\n    final /*@Thrown\052/ boolean status = sum.equals(<%pamtram.condition.ConditionTables%>.INT_1);\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.condition.ConditionTables%>.STR_Please_32_specify_32_exactly_32_one_32_o_local_32_or_32_shared_e_32_condition_32_part_33;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.condition.ConditionTables%>.STR_UnaryCondition_c_c_exactlyOneArg, this, null, diagnostics, context, message_0, <%pamtram.condition.ConditionTables%>.INT_4, CAUGHT_status, <%pamtram.condition.ConditionTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean exactlyOneArg(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SingleConditionOperator
