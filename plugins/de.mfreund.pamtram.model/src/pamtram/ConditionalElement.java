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
 *   <li>{@link pamtram.ConditionalElement#getCondition <em>Condition</em>}</li>
 *   <li>{@link pamtram.ConditionalElement#getConditionRef <em>Condition Ref</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getConditionalElement()
 * @model abstract="true"
 * @generated
 */
public interface ConditionalElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(ComplexCondition)
	 * @see pamtram.PamtramPackage#getConditionalElement_Condition()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram!ConditionalElement!condition'"
	 * @generated
	 */
	ComplexCondition getCondition();

	/**
	 * Sets the value of the '{@link pamtram.ConditionalElement#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(ComplexCondition value);

	/**
	 * Returns the value of the '<em><b>Condition Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Ref</em>' reference.
	 * @see #setConditionRef(ComplexCondition)
	 * @see pamtram.PamtramPackage#getConditionalElement_ConditionRef()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram!ConditionalElement!conditionRef'"
	 * @generated
	 */
	ComplexCondition getConditionRef();

	/**
	 * Sets the value of the '{@link pamtram.ConditionalElement#getConditionRef <em>Condition Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Ref</em>' reference.
	 * @see #getConditionRef()
	 * @generated
	 */
	void setConditionRef(ComplexCondition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv eitherModelOrReferCondition:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = self.conditionRef->size() +\n *       self.condition->size() = 1\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'As this Instance is a ConditionElement and you want to add a condition, you either have to model a condition or reference an already existing one!\'\n *         else null\n *         endif\n *       in\n *         \'ConditionalElement::eitherModelOrReferCondition\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@Thrown\052/ <%pamtram.condition.ComplexCondition%> conditionRef = this.getConditionRef();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> oclAsSet = <%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation%>.INSTANCE.evaluate(executor, <%pamtram.PamtramTables%>.SET_CLSSid_ComplexCondition, conditionRef);\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(oclAsSet);\n    final /*@Thrown\052/ <%pamtram.condition.ComplexCondition%> condition = this.getCondition();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> oclAsSet_0 = <%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation%>.INSTANCE.evaluate(executor, <%pamtram.PamtramTables%>.SET_CLSSid_ComplexCondition, condition);\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size_0 = <%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(oclAsSet_0);\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> sum = (<%org.eclipse.ocl.pivot.values.IntegerValue%>)<%org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation%>.INSTANCE.evaluate(size, size_0);\n    final /*@Thrown\052/ boolean status = sum.equals(<%pamtram.PamtramTables%>.INT_1);\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.PamtramTables%>.STR_As_32_this_32_Instance_32_is_32_a_32_ConditionElement_32_and_32_you_32_want_32_to_32_add_32_a_32_con;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.PamtramTables%>.STR_ConditionalElement_c_c_eitherModelOrReferCondition, this, null, diagnostics, context, message_0, <%pamtram.PamtramTables%>.INT_4, CAUGHT_status, <%pamtram.PamtramTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean eitherModelOrReferCondition(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv referenceOnlyConditionsFromConditionModel:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = if self.conditionRef->size() = 1\n *       then\n *         self.conditionRef.oclContainer()\n *         .oclIsTypeOf(ConditionModel)\n *       else true\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'It only allowed to reference Condition-Instances that are model inside the ConditionModel!\'\n *         else null\n *         endif\n *       in\n *         \'ConditionalElement::referenceOnlyConditionsFromConditionModel\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@Thrown\052/ <%pamtram.condition.ComplexCondition%> conditionRef_0 = this.getConditionRef();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> oclAsSet = <%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation%>.INSTANCE.evaluate(executor, <%pamtram.PamtramTables%>.SET_CLSSid_ComplexCondition, conditionRef_0);\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(oclAsSet);\n    final /*@Thrown\052/ boolean eq = size.equals(<%pamtram.PamtramTables%>.INT_1);\n    /*@Thrown\052/ boolean status;\n    if (eq) {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_ConditionModel = idResolver.getClass(<%pamtram.PamtramTables%>.CLSSid_ConditionModel, null);\n        final /*@Thrown\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, conditionRef_0);\n        final /*@Thrown\052/ boolean oclIsTypeOf = <%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsTypeOfOperation%>.INSTANCE.evaluate(executor, oclContainer, TYP_pamtram_c_c_ConditionModel).booleanValue();\n        status = oclIsTypeOf;\n    }\n    else {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.PamtramTables%>.STR_It_32_only_32_allowed_32_to_32_reference_32_Condition_m_Instances_32_that_32_are_32_model_32;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.PamtramTables%>.STR_ConditionalElement_c_c_referenceOnlyConditionsFromConditionModel, this, null, diagnostics, context, message_0, <%pamtram.PamtramTables%>.INT_4, CAUGHT_status, <%pamtram.PamtramTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean referenceOnlyConditionsFromConditionModel(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ConditionalElement
