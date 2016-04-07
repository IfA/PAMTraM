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
 *   <li>{@link pamtram.condition.SingleConditionOperator#getCondPart <em>Cond Part</em>}</li>
 *   <li>{@link pamtram.condition.SingleConditionOperator#getCondPartRef <em>Cond Part Ref</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getSingleConditionOperator()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='minimalNumberOfArgs referenceOnlyConditionsFromConditionModel'"
 * @generated
 */
public interface SingleConditionOperator extends ComplexCondition {
	/**
	 * Returns the value of the '<em><b>Cond Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cond Part</em>' containment reference.
	 * @see #setCondPart(ComplexCondition)
	 * @see pamtram.condition.ConditionPackage#getSingleConditionOperator_CondPart()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!SingleConditionOperator!condPart'"
	 * @generated
	 */
	ComplexCondition getCondPart();

	/**
	 * Sets the value of the '{@link pamtram.condition.SingleConditionOperator#getCondPart <em>Cond Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cond Part</em>' containment reference.
	 * @see #getCondPart()
	 * @generated
	 */
	void setCondPart(ComplexCondition value);

	/**
	 * Returns the value of the '<em><b>Cond Part Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond Part Ref</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cond Part Ref</em>' reference.
	 * @see #setCondPartRef(ComplexCondition)
	 * @see pamtram.condition.ConditionPackage#getSingleConditionOperator_CondPartRef()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!SingleConditionOperator!condPartRef'"
	 * @generated
	 */
	ComplexCondition getCondPartRef();

	/**
	 * Sets the value of the '{@link pamtram.condition.SingleConditionOperator#getCondPartRef <em>Cond Part Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cond Part Ref</em>' reference.
	 * @see #getCondPartRef()
	 * @generated
	 */
	void setCondPartRef(ComplexCondition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv minimalNumberOfArgs:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = self.condPart->size() +\n *       self.condPartRef->size() = 1\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The required subparts of this condition are not modeled or not referenced !\'\n *         else null\n *         endif\n *       in\n *         \'SingleConditionOperator::minimalNumberOfArgs\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\n/*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@Nullable\052/ /*@Thrown\052/ <%pamtram.condition.ComplexCondition%> condPart = this.getCondPart();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> oclAsSet = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.condition.ConditionTables%>.SET_CLSSid_ComplexCondition, condPart));\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(oclAsSet));\n    final /*@Nullable\052/ /*@Thrown\052/ <%pamtram.condition.ComplexCondition%> condPartRef = this.getCondPartRef();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> oclAsSet_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.condition.ConditionTables%>.SET_CLSSid_ComplexCondition, condPartRef));\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(oclAsSet_0));\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> sum = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.ocl.pivot.values.IntegerValue%>)<%org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation%>.INSTANCE.evaluate(size, size_0));\n    final /*@Thrown\052/ boolean status = sum.equals(<%pamtram.condition.ConditionTables%>.INT_1);\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.condition.ConditionTables%>.STR_The_32_required_32_subparts_32_of_32_this_32_condition_32_are_32_not_32_modeled_32_or_32_not_32_r;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.condition.ConditionTables%>.STR_SingleConditionOperator_c_c_minimalNumberOfArgs, this, null, diagnostics, context, message_0, <%pamtram.condition.ConditionTables%>.INT_4, CAUGHT_status, <%pamtram.condition.ConditionTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean minimalNumberOfArgs(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv referenceOnlyConditionsFromConditionModel:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[?] = self.condPartRef.oclContainer()\n *       .oclIsTypeOf(ConditionModel) or\n *       self.condPartRef.oclContainer()\n *       .oclIsKindOf(ConditionalElement)\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'It only allowed to reference Condition-Instances that are model inside the ConditionModel!\'\n *         else null\n *         endif\n *       in\n *         \'SingleConditionOperator::referenceOnlyConditionsFromConditionModel\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n/*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_oclIsTypeOf;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_ConditionModel_0 = idResolver.getClass(<%pamtram.condition.ConditionTables%>.CLSSid_ConditionModel, null);\n        final /*@Nullable\052/ /*@Thrown\052/ <%pamtram.condition.ComplexCondition%> condPartRef = this.getCondPartRef();\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, condPartRef);\n        final /*@Thrown\052/ boolean oclIsTypeOf = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsTypeOfOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_ConditionModel_0).booleanValue());\n        CAUGHT_oclIsTypeOf = oclIsTypeOf;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_oclIsTypeOf = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_oclIsKindOf;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_ConditionalElement = idResolver.getClass(<%pamtram.condition.ConditionTables%>.CLSSid_ConditionalElement, null);\n        final /*@Nullable\052/ /*@Thrown\052/ <%pamtram.condition.ComplexCondition%> condPartRef_0 = this.getCondPartRef();\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> oclContainer_0 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, condPartRef_0);\n        final /*@Thrown\052/ boolean oclIsKindOf = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%>.INSTANCE.evaluate(evaluator, oclContainer_0, TYP_pamtram_c_c_ConditionalElement).booleanValue());\n        CAUGHT_oclIsKindOf = oclIsKindOf;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_oclIsKindOf = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> status = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_oclIsTypeOf, CAUGHT_oclIsKindOf);\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.condition.ConditionTables%>.STR_It_32_only_32_allowed_32_to_32_reference_32_Condition_m_Instances_32_that_32_are_32_model_32;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.condition.ConditionTables%>.STR_SingleConditionOperator_c_c_referenceOnlyConditionsFromConditionMod, this, null, diagnostics, context, message_0, <%pamtram.condition.ConditionTables%>.INT_4, CAUGHT_status, <%pamtram.condition.ConditionTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean referenceOnlyConditionsFromConditionModel(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SingleConditionOperator
