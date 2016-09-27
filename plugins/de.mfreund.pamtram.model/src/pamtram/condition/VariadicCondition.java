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
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.VariadicCondition#getCondParts <em>Cond Parts</em>}</li>
 *   <li>{@link pamtram.condition.VariadicCondition#getCondPartsRef <em>Cond Parts Ref</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getVariadicCondition()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='minimalNumberOfArgs'"
 * @generated
 */
public interface VariadicCondition extends ComplexCondition {
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
	 * @see pamtram.condition.ConditionPackage#getVariadicCondition_CondParts()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!VariadicCondition!condParts'"
	 * @generated
	 */
	EList<ComplexCondition> getLocalCondParts();

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
	 * @see pamtram.condition.ConditionPackage#getVariadicCondition_CondPartsRef()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!VariadicCondition!condPartsRef'"
	 * @generated
	 */
	EList<ComplexCondition> getSharedCondParts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.condPartsRef == null || this.condPartsRef.size() == 0) {\r\n\treturn true;\r\n}\r\nEList<ComplexCondition> conditionRefs = new BasicEList<ComplexCondition>();\r\nconditionRefs.add((ComplexCondition) this.condPartsRef);\r\nfor(ComplexCondition condition : conditionRefs){\r\n\tif(!(condition instanceof ConditionModel)){\r\n\t\treturn false;\r\n\t}\r\n}\r\nreturn true;'"
	 * @generated
	 */
	boolean referencesOnlyValidConditions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv minimalNumberOfArgs:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = self.condParts->size() +\n *       self.condPartsRef->size() > 1\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The required subparts of this condition are not modeled or not referenced !\'\n *         else null\n *         endif\n *       in\n *         \'VariadicCondition::minimalNumberOfArgs\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@Thrown\052/ <%java.util.List%><<%pamtram.condition.ComplexCondition%>> condParts = this.getCondParts();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_condParts = idResolver.createOrderedSetOfAll(<%pamtram.condition.ConditionTables%>.ORD_CLSSid_ComplexCondition, condParts);\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_condParts);\n    final /*@Thrown\052/ <%java.util.List%><<%pamtram.condition.ComplexCondition%>> condPartsRef = this.getCondPartsRef();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_condPartsRef = idResolver.createOrderedSetOfAll(<%pamtram.condition.ConditionTables%>.ORD_CLSSid_ComplexCondition, condPartsRef);\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size_0 = <%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_condPartsRef);\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> sum = (<%org.eclipse.ocl.pivot.values.IntegerValue%>)<%org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation%>.INSTANCE.evaluate(size, size_0);\n    final /*@Thrown\052/ boolean status = <%org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation%>.INSTANCE.evaluate(executor, sum, <%pamtram.condition.ConditionTables%>.INT_1).booleanValue();\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.condition.ConditionTables%>.STR_The_32_required_32_subparts_32_of_32_this_32_condition_32_are_32_not_32_modeled_32_or_32_not_32_r;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.condition.ConditionTables%>.STR_VariadicCondition_c_c_minimalNumberOfArgs, this, null, diagnostics, context, message_0, <%pamtram.condition.ConditionTables%>.INT_4, CAUGHT_status, <%pamtram.condition.ConditionTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean minimalNumberOfArgs(DiagnosticChain diagnostics, Map<Object, Object> context);

} // MultipleConditionOperator
