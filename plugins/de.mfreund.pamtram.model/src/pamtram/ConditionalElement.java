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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram!ConditionalElement!localCondition'"
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram!ConditionalElement!sharedCondition'"
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv eitherModelOrReferCondition:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = self.sharedCondition->size() +\n *       self.localCondition->size() <= 1\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'Please specify at most one (local or shared) condition!\'\n *         else null\n *         endif\n *       in\n *         \'ConditionalElement::eitherModelOrReferCondition\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@Thrown\052/ <%pamtram.condition.ComplexCondition%> sharedCondition = this.getSharedCondition();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> oclAsSet = <%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation%>.INSTANCE.evaluate(executor, <%pamtram.PamtramTables%>.SET_CLSSid_ComplexCondition, sharedCondition);\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(oclAsSet);\n    final /*@Thrown\052/ <%pamtram.condition.ComplexCondition%> localCondition = this.getLocalCondition();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> oclAsSet_0 = <%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation%>.INSTANCE.evaluate(executor, <%pamtram.PamtramTables%>.SET_CLSSid_ComplexCondition, localCondition);\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size_0 = <%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(oclAsSet_0);\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> sum = (<%org.eclipse.ocl.pivot.values.IntegerValue%>)<%org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation%>.INSTANCE.evaluate(size, size_0);\n    final /*@Thrown\052/ boolean status = <%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(executor, sum, <%pamtram.PamtramTables%>.INT_1).booleanValue();\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.PamtramTables%>.STR_Please_32_specify_32_at_32_most_32_one_32_o_local_32_or_32_shared_e_32_condition_33;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.PamtramTables%>.STR_ConditionalElement_c_c_eitherModelOrReferCondition, this, null, diagnostics, context, message_0, <%pamtram.PamtramTables%>.INT_4, CAUGHT_status, <%pamtram.PamtramTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean eitherModelOrReferCondition(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv referenceOnlyConditionsFromConditionModel:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = if self.sharedCondition->size() = 1\n *       then\n *         self.sharedCondition.oclContainer()\n *         .oclIsTypeOf(ConditionModel)\n *       else true\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'It only allowed to reference shared conditions that are model inside the ConditionModel!\'\n *         else null\n *         endif\n *       in\n *         \'ConditionalElement::referenceOnlyConditionsFromConditionModel\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@Thrown\052/ <%pamtram.condition.ComplexCondition%> sharedCondition_0 = this.getSharedCondition();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> oclAsSet = <%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation%>.INSTANCE.evaluate(executor, <%pamtram.PamtramTables%>.SET_CLSSid_ComplexCondition, sharedCondition_0);\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(oclAsSet);\n    final /*@Thrown\052/ boolean eq = size.equals(<%pamtram.PamtramTables%>.INT_1);\n    /*@Thrown\052/ boolean status;\n    if (eq) {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_ConditionModel = idResolver.getClass(<%pamtram.PamtramTables%>.CLSSid_ConditionModel, null);\n        final /*@Thrown\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, sharedCondition_0);\n        final /*@Thrown\052/ boolean oclIsTypeOf = <%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsTypeOfOperation%>.INSTANCE.evaluate(executor, oclContainer, TYP_pamtram_c_c_ConditionModel).booleanValue();\n        status = oclIsTypeOf;\n    }\n    else {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.PamtramTables%>.STR_It_32_only_32_allowed_32_to_32_reference_32_shared_32_conditions_32_that_32_are_32_model_32_in;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.PamtramTables%>.STR_ConditionalElement_c_c_referenceOnlyConditionsFromConditionModel, this, null, diagnostics, context, message_0, <%pamtram.PamtramTables%>.INT_4, CAUGHT_status, <%pamtram.PamtramTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean referenceOnlyConditionsFromConditionModel(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ConditionalElement
