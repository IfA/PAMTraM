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
 *   <li>{@link pamtram.condition.MultipleConditionOperator#getCondParts <em>Cond Parts</em>}</li>
 *   <li>{@link pamtram.condition.MultipleConditionOperator#getCondPartsRef <em>Cond Parts Ref</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getMultipleConditionOperator()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='minimalNumberOfArgs referenceOnlyConditionsFromConditionModel'"
 * @generated
 */
public interface MultipleConditionOperator extends ComplexCondition {
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
	 * @see pamtram.condition.ConditionPackage#getMultipleConditionOperator_CondParts()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!MultipleConditionOperator!condParts'"
	 * @generated
	 */
	EList<ComplexCondition> getCondParts();

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
	 * @see pamtram.condition.ConditionPackage#getMultipleConditionOperator_CondPartsRef()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!MultipleConditionOperator!condPartsRef'"
	 * @generated
	 */
	EList<ComplexCondition> getCondPartsRef();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv minimalNumberOfArgs:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = self.condParts->size() +\n *       self.condPartsRef->size() > 1\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The required subparts of this condition are not modeled or not referenced !\'\n *         else null\n *         endif\n *       in\n *         \'MultipleConditionOperator::minimalNumberOfArgs\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n/*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.condition.ComplexCondition%>> condParts = this.getCondParts();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_condParts = idResolver.createOrderedSetOfAll(<%pamtram.condition.ConditionTables%>.ORD_CLSSid_ComplexCondition, condParts);\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_condParts));\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.condition.ComplexCondition%>> condPartsRef = this.getCondPartsRef();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_condPartsRef = idResolver.createOrderedSetOfAll(<%pamtram.condition.ConditionTables%>.ORD_CLSSid_ComplexCondition, condPartsRef);\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_condPartsRef));\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> sum = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.ocl.pivot.values.IntegerValue%>)<%org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation%>.INSTANCE.evaluate(size, size_0));\n    final /*@Thrown\052/ boolean status = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation%>.INSTANCE.evaluate(evaluator, sum, <%pamtram.condition.ConditionTables%>.INT_1).booleanValue());\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.condition.ConditionTables%>.STR_The_32_required_32_subparts_32_of_32_this_32_condition_32_are_32_not_32_modeled_32_or_32_not_32_r;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.condition.ConditionTables%>.STR_MultipleConditionOperator_c_c_minimalNumberOfArgs, this, null, diagnostics, context, message_0, <%pamtram.condition.ConditionTables%>.INT_4, CAUGHT_status, <%pamtram.condition.ConditionTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean minimalNumberOfArgs(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv referenceOnlyConditionsFromConditionModel:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = if self.condPartsRef->size() > 0\n *       then\n *         self.condPartsRef.oclContainer()\n *         .oclIsTypeOf(ConditionModel)\n *       else true\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'It only allowed to reference Condition-Instances that are model inside the ConditionModel!\'\n *         else null\n *         endif\n *       in\n *         \'MultipleConditionOperator::referenceOnlyConditionsFromConditionModel\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n/*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.condition.ComplexCondition%>> condPartsRef_0 = this.getCondPartsRef();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_condPartsRef_0 = idResolver.createOrderedSetOfAll(<%pamtram.condition.ConditionTables%>.ORD_CLSSid_ComplexCondition, condPartsRef_0);\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_condPartsRef_0));\n    final /*@Thrown\052/ boolean gt = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation%>.INSTANCE.evaluate(evaluator, size, <%pamtram.condition.ConditionTables%>.INT_0).booleanValue());\n    /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> status;\n    if (gt) {\n        /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%pamtram.condition.ConditionTables%>.SEQ_CLSSid_OclElement);\n        /*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR__1 = BOXED_condPartsRef_0.iterator();\n        /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> collect_0;\n        while (true) {\n            if (!ITERATOR__1.hasNext()) {\n                collect_0 = accumulator;\n                break;\n            }\n            /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.condition.ComplexCondition%> _1 = (<%pamtram.condition.ComplexCondition%>)ITERATOR__1.next();\n            /**\n             * oclContainer()\n             \052/\n            final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, _1);\n            //\n            if (oclContainer instanceof <%org.eclipse.ocl.pivot.values.CollectionValue%>) {\n                for (Object value : ((<%org.eclipse.ocl.pivot.values.CollectionValue%>)oclContainer).flatten().getElements()) {\n                    accumulator.add(value);\n                }\n            }\n            else {\n                accumulator.add(oclContainer);\n            }\n        }\n        /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.Accumulator accumulator_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%pamtram.condition.ConditionTables%>.SEQ_PRIMid_Boolean);\n        /*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR__1_0 = collect_0.iterator();\n        /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> collect;\n        while (true) {\n            if (!ITERATOR__1_0.hasNext()) {\n                collect = accumulator_0;\n                break;\n            }\n            /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> _1_0 = (<%java.lang.Object%>)ITERATOR__1_0.next();\n            /**\n             * oclIsTypeOf(ConditionModel)\n             \052/\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_ConditionModel = idResolver.getClass(<%pamtram.condition.ConditionTables%>.CLSSid_ConditionModel, null);\n            final /*@Thrown\052/ boolean oclIsTypeOf = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsTypeOfOperation%>.INSTANCE.evaluate(evaluator, _1_0, TYP_pamtram_c_c_ConditionModel).booleanValue());\n            //\n            accumulator_0.add(oclIsTypeOf);\n        }\n        status = collect;\n    }\n    else {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.condition.ConditionTables%>.STR_It_32_only_32_allowed_32_to_32_reference_32_Condition_m_Instances_32_that_32_are_32_model_32;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.condition.ConditionTables%>.STR_MultipleConditionOperator_c_c_referenceOnlyConditionsFromConditionM, this, null, diagnostics, context, message_0, <%pamtram.condition.ConditionTables%>.INT_4, CAUGHT_status, <%pamtram.condition.ConditionTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean referenceOnlyConditionsFromConditionModel(DiagnosticChain diagnostics, Map<Object, Object> context);

} // MultipleConditionOperator
