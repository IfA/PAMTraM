/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import pamtram.mapping.ExpressionHint;
import pamtram.mapping.ModifiableHint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Pointer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.InstancePointer#getAttributePointer <em>Attribute Pointer</em>}</li>
 *   <li>{@link pamtram.metamodel.InstancePointer#getValue <em>Value</em>}</li>
 *   <li>{@link pamtram.metamodel.InstancePointer#getSourceAttributes <em>Source Attributes</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getInstancePointer()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='noGlobalAttributeImporterInMappingConditions noModifiedAttributeElementTypesInConditionModelConditions'"
 * @generated
 */
public interface InstancePointer extends ExpressionHint, ModifiableHint {
	/**
	 * Returns the value of the '<em><b>Attribute Pointer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Pointer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Pointer</em>' reference.
	 * @see #setAttributePointer(SourceSectionAttribute)
	 * @see pamtram.metamodel.MetamodelPackage#getInstancePointer_AttributePointer()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!InstancePointer!attributePointer'"
	 * @generated
	 */
	SourceSectionAttribute getAttributePointer();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.InstancePointer#getAttributePointer <em>Attribute Pointer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Pointer</em>' reference.
	 * @see #getAttributePointer()
	 * @generated
	 */
	void setAttributePointer(SourceSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see pamtram.metamodel.MetamodelPackage#getInstancePointer_Value()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!InstancePointer!value'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.InstancePointer#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Source Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.InstancePointerSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Attributes</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getInstancePointer_SourceAttributes()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!InstancePointer!sourceAttributes'"
	 * @generated
	 */
	EList<InstancePointerSourceInterface> getSourceAttributes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv noModifiedAttributeElementTypesInConditionModelConditions:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[?] = if\n *         self.oclContainer()\n *         .oclIsKindOf(condition::ComplexCondition) and\n *         self.oclContainer()\n *         .oclAsType(condition::ComplexCondition)\n *         .isConditionModelCondition()\n *       then\n *         not self.sourceAttributes->exists(\n *           self.oclIsTypeOf(mapping::ModifiedAttributeElementType(S, C, R, A)))\n *       else true\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'ModifiedAttributeElementTypes are not allowed as part of ConditionModelConditions!\'\n *         else null\n *         endif\n *       in\n *         \'InstancePointer::noModifiedAttributeElementTypesInConditionModelConditions\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n/*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_oclIsKindOf;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_condition_c_c_ComplexCondition_0 = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_ComplexCondition, null);\n        final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n        final /*@Thrown\052/ boolean oclIsKindOf = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_condition_c_c_ComplexCondition_0).booleanValue());\n        CAUGHT_oclIsKindOf = oclIsKindOf;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_oclIsKindOf = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_isConditionModelCondition;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_condition_c_c_ComplexCondition_1 = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_ComplexCondition, null);\n        final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer_0 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.condition.ComplexCondition%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.condition.ComplexCondition%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer_0, TYP_pamtram_c_c_condition_c_c_ComplexCondition_1));\n        final /*@Thrown\052/ boolean isConditionModelCondition = oclAsType.isConditionModelCondition();\n        CAUGHT_isConditionModelCondition = isConditionModelCondition;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_isConditionModelCondition = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> and = <%org.eclipse.ocl.pivot.library.logical.BooleanAndOperation%>.INSTANCE.evaluate(CAUGHT_oclIsKindOf, CAUGHT_isConditionModelCondition);\n    if (and == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null if condition\");\n    }\n    /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> status;\n    if (and) {\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.metamodel.InstancePointerSourceInterface%>> sourceAttributes = this.getSourceAttributes();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_sourceAttributes = idResolver.createOrderedSetOfAll(<%pamtram.metamodel.MetamodelTables%>.ORD_CLSSid_InstancePointerSourceInterface, sourceAttributes);\n        /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE;\n        /*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR__1 = BOXED_sourceAttributes.iterator();\n        /*@Thrown\052/ boolean exists;\n        while (true) {\n            if (!ITERATOR__1.hasNext()) {\n                if (accumulator == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE) {\n                    exists = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE;\n                }\n                else {\n                    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)accumulator;\n                }\n                break;\n            }\n            /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.metamodel.InstancePointerSourceInterface%> _1 = (<%pamtram.metamodel.InstancePointerSourceInterface%>)ITERATOR__1.next();\n            /**\n             * \n             * self.oclIsTypeOf(mapping::ModifiedAttributeElementType(S, C, R, A))\n             \052/\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_ModifiedAttributeElementType_o_S_44_C_44_R_44_A_e = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_ModifiedAttributeElementType, null);\n            final /*@NonInvalid\052/ boolean oclIsTypeOf = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsTypeOfOperation%>.INSTANCE.evaluate(evaluator, this, TYP_pamtram_c_c_mapping_c_c_ModifiedAttributeElementType_o_S_44_C_44_R_44_A_e).booleanValue());\n            //\n            if (oclIsTypeOf == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\t\t\t\t\t// Normal successful body evaluation result\n                exists = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n                break;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately \n            }\n            else if (oclIsTypeOf == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE) {\t\t\t\t// Normal unsuccessful body evaluation result\n                ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n            }\n            else {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n                accumulator = new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(<%org.eclipse.ocl.pivot.messages.PivotMessages%>.NonBooleanBody, \"exists\");\n            }\n        }\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> not = <%org.eclipse.ocl.pivot.library.logical.BooleanNotOperation%>.INSTANCE.evaluate(exists);\n        status = not;\n    }\n    else {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.metamodel.MetamodelTables%>.STR_ModifiedAttributeElementTypes_32_are_32_not_32_allowed_32_as_32_part_32_of_32_Conditi;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_InstancePointer_c_c_noModifiedAttributeElementTypesInConditionModel, this, null, diagnostics, context, message_0, <%pamtram.metamodel.MetamodelTables%>.INT_4, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean noModifiedAttributeElementTypesInConditionModelConditions(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv noGlobalAttributeImporterInMappingConditions:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[?] = if\n *         self.oclContainer()\n *         .oclIsKindOf(condition::ComplexCondition) and\n *         self.oclContainer()\n *         .oclAsType(condition::ComplexCondition)\n *         .isMappingCondition()\n *       then\n *         self.sourceAttributes->exists(\n *           self.oclIsTypeOf(mapping::GlobalAttributeImporter))\n *       else true\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'GlobalAttributeImporters are not allowed as part of MappingConditions!\'\n *         else null\n *         endif\n *       in\n *         \'InstancePointer::noGlobalAttributeImporterInMappingConditions\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n/*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_oclIsKindOf;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_condition_c_c_ComplexCondition = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_ComplexCondition, null);\n        final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n        final /*@Thrown\052/ boolean oclIsKindOf = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_condition_c_c_ComplexCondition).booleanValue());\n        CAUGHT_oclIsKindOf = oclIsKindOf;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_oclIsKindOf = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_isMappingCondition;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_condition_c_c_ComplexCondition_0 = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_ComplexCondition, null);\n        final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer_0 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.condition.ComplexCondition%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.condition.ComplexCondition%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer_0, TYP_pamtram_c_c_condition_c_c_ComplexCondition_0));\n        final /*@Thrown\052/ boolean isMappingCondition = oclAsType.isMappingCondition();\n        CAUGHT_isMappingCondition = isMappingCondition;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_isMappingCondition = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> and = <%org.eclipse.ocl.pivot.library.logical.BooleanAndOperation%>.INSTANCE.evaluate(CAUGHT_oclIsKindOf, CAUGHT_isMappingCondition);\n    if (and == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null if condition\");\n    }\n    /*@Thrown\052/ boolean status;\n    if (and) {\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.metamodel.InstancePointerSourceInterface%>> sourceAttributes = this.getSourceAttributes();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_sourceAttributes = idResolver.createOrderedSetOfAll(<%pamtram.metamodel.MetamodelTables%>.ORD_CLSSid_InstancePointerSourceInterface, sourceAttributes);\n        /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE;\n        /*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR__1 = BOXED_sourceAttributes.iterator();\n        /*@Thrown\052/ boolean exists;\n        while (true) {\n            if (!ITERATOR__1.hasNext()) {\n                if (accumulator == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE) {\n                    exists = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE;\n                }\n                else {\n                    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)accumulator;\n                }\n                break;\n            }\n            /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.metamodel.InstancePointerSourceInterface%> _1 = (<%pamtram.metamodel.InstancePointerSourceInterface%>)ITERATOR__1.next();\n            /**\n             * \n             * self.oclIsTypeOf(mapping::GlobalAttributeImporter)\n             \052/\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_GlobalAttributeImporter = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_GlobalAttributeImporter, null);\n            final /*@NonInvalid\052/ boolean oclIsTypeOf = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsTypeOfOperation%>.INSTANCE.evaluate(evaluator, this, TYP_pamtram_c_c_mapping_c_c_GlobalAttributeImporter).booleanValue());\n            //\n            if (oclIsTypeOf == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\t\t\t\t\t// Normal successful body evaluation result\n                exists = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n                break;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately \n            }\n            else if (oclIsTypeOf == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE) {\t\t\t\t// Normal unsuccessful body evaluation result\n                ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n            }\n            else {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n                accumulator = new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(<%org.eclipse.ocl.pivot.messages.PivotMessages%>.NonBooleanBody, \"exists\");\n            }\n        }\n        status = exists;\n    }\n    else {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.metamodel.MetamodelTables%>.STR_GlobalAttributeImporters_32_are_32_not_32_allowed_32_as_32_part_32_of_32_MappingCondi;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_InstancePointer_c_c_noGlobalAttributeImporterInMappingConditions, this, null, diagnostics, context, message_0, <%pamtram.metamodel.MetamodelTables%>.INT_4, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean noGlobalAttributeImporterInMappingConditions(DiagnosticChain diagnostics, Map<Object, Object> context);

} // InstancePointer
