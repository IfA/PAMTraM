/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import pamtram.metamodel.TargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.AttributeMatcher#getTargetAttribute <em>Target Attribute</em>}</li>
 *   <li>{@link pamtram.mapping.AttributeMatcher#getSourceAttributes <em>Source Attributes</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getAttributeMatcher()
 * @model
 * @generated
 */
public interface AttributeMatcher extends Matcher, ExpressionHint, ModifiableHint, ExpandableHint {
	/**
	 * Returns the value of the '<em><b>Target Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Attribute</em>' reference.
	 * @see #setTargetAttribute(TargetSectionAttribute)
	 * @see pamtram.mapping.MappingPackage#getAttributeMatcher_TargetAttribute()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!AttributeMatcher!targetAttribute'"
	 * @generated
	 */
	TargetSectionAttribute getTargetAttribute();

	/**
	 * Sets the value of the '{@link pamtram.mapping.AttributeMatcher#getTargetAttribute <em>Target Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Attribute</em>' reference.
	 * @see #getTargetAttribute()
	 * @generated
	 */
	void setTargetAttribute(TargetSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Source Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.AttributeMatcherSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Attributes</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getAttributeMatcher_SourceAttributes()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!AttributeMatcher!sourceAttributes'"
	 * @generated
	 */
	EList<AttributeMatcherSourceInterface> getSourceAttributes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<AttributeMatcherSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<AttributeMatcherSourceElement>();\r\n\t\t\t\t\r\n\t\t\t\tfor(AttributeMatcherSourceInterface i : this.getSourceAttributes()){\r\n\t\t\t\t\tif(i instanceof AttributeMatcherSourceElement){\r\n\t\t\t\t\t\telements.add((AttributeMatcherSourceElement) i);\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t\t\r\n\t\t\t\treturn elements;'"
	 * @generated
	 */
	EList<AttributeMatcherSourceElement> getLocalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<AttributeMatcherExternalSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<>();\r\n\r\nfor(AttributeMatcherSourceInterface i : this.getSourceAttributes()){\r\n\tif(i instanceof AttributeMatcherExternalSourceElement){\r\n\t\telements.add((AttributeMatcherExternalSourceElement) i);\r\n\t}\r\n}\r\n\r\nreturn elements;'"
	 * @generated
	 */
	EList<AttributeMatcherExternalSourceElement> getExternalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv targetMatchesAffectedReferenceType:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[?] = if\n *         self.oclContainer()\n *         .oclAsType(MappingInstanceSelector)\n *         .affectedReference.oclType() = OclVoid or\n *         self.targetAttribute.oclType() = OclVoid\n *       then true\n *       else\n *         self.oclContainer()\n *         .oclAsType(MappingInstanceSelector)\n *         .affectedReference.eReference.oclAsType(ecore::EReference)\n *         .eReferenceType.oclAsType(ecore::EClass)\n *         .isSuperTypeOf(\n *           self.targetAttribute.oclContainer()\n *           .oclAsType(metamodel::Class(S, C, R, A)).eClass)\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The type of the class containing the target attribute (\\\'\' +\n *           self.targetAttribute.oclContainer()\n *           .oclAsType(metamodel::Class(S, C, R, A)).eClass.name + \'\\\') is not allowed by the affected reference of the parent mapping instance selector that \' + \'requires a (sub-)type of \\\'\' +\n *           self.oclContainer()\n *           .oclAsType(MappingInstanceSelector)\n *           .affectedReference.eReference.oclAsType(ecore::EReference)\n *           .eReferenceType.oclAsType(ecore::EClass).name + \'\\\'!\'\n *         else null\n *         endif\n *       in\n *         \'AttributeMatcher::targetMatchesAffectedReferenceType\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq;\n    try {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingInstanceSelector = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingInstanceSelector, null);\n        final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n        final /*@Thrown\052/ <%pamtram.mapping.MappingInstanceSelector%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingInstanceSelector%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingInstanceSelector));\n        final /*@Thrown\052/ <%pamtram.metamodel.TargetSectionNonContainmentReference%> affectedReference = oclAsType.getAffectedReference();\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, affectedReference);\n        final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n        CAUGHT_eq = eq;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq_0;\n    try {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_1 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@Thrown\052/ <%pamtram.metamodel.TargetSectionAttribute%> targetAttribute = this.getTargetAttribute();\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType_0 = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, targetAttribute);\n        final /*@Thrown\052/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_1.getTypeId();\n        CAUGHT_eq_0 = eq_0;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@Thrown\052/ <%java.lang.Boolean%> or = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);\n    if (or == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null if condition\");\n    }\n    /*@Thrown\052/ boolean status;\n    if (or) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_ecore_c_c_EClass = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_EClass, null);\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_ecore_c_c_EReference_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_EReference, null);\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingInstanceSelector_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingInstanceSelector, null);\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Class_0, null);\n        final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer_0 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n        final /*@Thrown\052/ <%pamtram.mapping.MappingInstanceSelector%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingInstanceSelector%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer_0, TYP_pamtram_c_c_mapping_c_c_MappingInstanceSelector_0));\n        final /*@Thrown\052/ <%pamtram.metamodel.TargetSectionNonContainmentReference%> affectedReference_0 = oclAsType_0.getAffectedReference();\n        final /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> eReference = affectedReference_0.getEReference();\n        final /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> oclAsType_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.emf.ecore.EReference%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, eReference, TYP_ecore_c_c_EReference_0));\n        final /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eReferenceType = oclAsType_1.getEReferenceType();\n        final /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> oclAsType_2 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.emf.ecore.EClass%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, eReferenceType, TYP_ecore_c_c_EClass));\n        final /*@Thrown\052/ <%pamtram.metamodel.TargetSectionAttribute%> targetAttribute_0 = this.getTargetAttribute();\n        final /*@Thrown\052/ <%java.lang.Object%> oclContainer_1 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, targetAttribute_0);\n        final /*@Thrown\052/ <%pamtram.metamodel.Class%> oclAsType_3 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer_1, TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e));\n        final /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eClass = oclAsType_3.getEClass();\n        final /*@Thrown\052/ boolean isSuperTypeOf = oclAsType_2.isSuperTypeOf(eClass);\n        status = isSuperTypeOf;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_ecore_c_c_EClass_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_EClass, null);\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_ecore_c_c_EReference_1 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_EReference, null);\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingInstanceSelector_1 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingInstanceSelector, null);\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Class_0, null);\n    final /*@Thrown\052/ <%pamtram.metamodel.TargetSectionAttribute%> targetAttribute_1 = this.getTargetAttribute();\n    final /*@Thrown\052/ <%java.lang.Object%> oclContainer_2 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, targetAttribute_1);\n    final /*@Thrown\052/ <%pamtram.metamodel.Class%> oclAsType_4 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer_2, TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e_0));\n    final /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eClass_0 = oclAsType_4.getEClass();\n    final /*@Thrown\052/ <%java.lang.String%> name = eClass_0.getName();\n    final /*@NonInvalid\052/ <%java.lang.String%> sum = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(<%pamtram.mapping.MappingTables%>.STR_The_32_type_32_of_32_the_32_class_32_containing_32_the_32_target_32_attribute_32_o_39, name);\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_0 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum, <%pamtram.mapping.MappingTables%>.STR__39_e_32_is_32_not_32_allowed_32_by_32_the_32_affected_32_reference_32_of_32_the_32_parent_32_mappin);\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_1 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_0, <%pamtram.mapping.MappingTables%>.STR_requires_32_a_32_o_sub_m_e_type_32_of_32_39);\n    final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer_3 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n    final /*@Thrown\052/ <%pamtram.mapping.MappingInstanceSelector%> oclAsType_5 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingInstanceSelector%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer_3, TYP_pamtram_c_c_mapping_c_c_MappingInstanceSelector_1));\n    final /*@Thrown\052/ <%pamtram.metamodel.TargetSectionNonContainmentReference%> affectedReference_1 = oclAsType_5.getAffectedReference();\n    final /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> eReference_0 = affectedReference_1.getEReference();\n    final /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> oclAsType_6 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.emf.ecore.EReference%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, eReference_0, TYP_ecore_c_c_EReference_1));\n    final /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eReferenceType_0 = oclAsType_6.getEReferenceType();\n    final /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> oclAsType_7 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.emf.ecore.EClass%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, eReferenceType_0, TYP_ecore_c_c_EClass_0));\n    final /*@Thrown\052/ <%java.lang.String%> name_0 = oclAsType_7.getName();\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_2 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_1, name_0);\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_3 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_2, <%pamtram.mapping.MappingTables%>.STR__39_33);\n    message_0 = sum_3;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_AttributeMatcher_c_c_targetMatchesAffectedReferenceType, this, null, diagnostics, context, message_0, <%pamtram.mapping.MappingTables%>.INT_4, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean targetMatchesAffectedReferenceType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // AttributeMatcher
