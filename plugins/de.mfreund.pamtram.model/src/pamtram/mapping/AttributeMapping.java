/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import pamtram.metamodel.TargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.AttributeMapping#getTarget <em>Target</em>}</li>
 *   <li>{@link pamtram.mapping.AttributeMapping#getSourceAttributeMappings <em>Source Attribute Mappings</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getAttributeMapping()
 * @model
 * @generated
 */
public interface AttributeMapping extends MappingHint, ExpressionHint, ModifiableHint, ExpandableHint {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(TargetSectionAttribute)
	 * @see pamtram.mapping.MappingPackage#getAttributeMapping_Target()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!AttributeMapping!target'"
	 * @generated
	 */
	TargetSectionAttribute getTarget();

	/**
	 * Sets the value of the '{@link pamtram.mapping.AttributeMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TargetSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Source Attribute Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.AttributeMappingSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attribute Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Attribute Mappings</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getAttributeMapping_SourceAttributeMappings()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!AttributeMapping!sourceAttributeMappings'"
	 * @generated
	 */
	EList<AttributeMappingSourceInterface> getSourceAttributeMappings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tEList<AttributeMappingSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<AttributeMappingSourceElement>();\r\n\t\t\r\n\t\tfor(AttributeMappingSourceInterface i : this.getSourceAttributeMappings()){\r\n\t\t\tif(i instanceof AttributeMappingSourceElement){\r\n\t\t\t\telements.add((AttributeMappingSourceElement) i);\r\n\t\t\t}\r\n\t\t}\r\n\t\t\r\n\t\treturn elements;'"
	 * @generated
	 */
	EList<AttributeMappingSourceElement> getLocalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<AttributeMappingExternalSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<AttributeMappingExternalSourceElement>();\r\n\r\nfor(AttributeMappingSourceInterface i : this.getSourceAttributeMappings()){\r\n\tif(i instanceof AttributeMappingExternalSourceElement){\r\n\t\telements.add((AttributeMappingExternalSourceElement) i);\r\n\t}\r\n}\r\n\r\nreturn elements;'"
	 * @generated
	 */
	EList<AttributeMappingExternalSourceElement> getExternalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv targetAttributeMatchesSection:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[?] = if\n *         self.target.oclType() = OclVoid or\n *         self.oclContainer()\n *         .oclAsType(MappingHintGroupType)\n *         .targetMMSection.oclType() = OclVoid\n *       then true\n *       else\n *         self.target.getContainingSection() =\n *         self.oclContainer()\n *         .oclAsType(MappingHintGroupType).targetMMSection or\n *         self.oclContainer()\n *         .oclAsType(MappingHintGroupType)\n *         .targetMMSection.oclAsType(metamodel::Section(S, C, R, A))\n *         .extend->includes(self.target.getContainingSection())\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The target attribute \\\'\' + self.target.name + \'\\\' is not part of the target section referenced by parent hint group \' +\n *           self.oclContainer()\n *           .oclAsType(MappingHintGroupType).name + \'!\'\n *         else null\n *         endif\n *       in\n *         \'AttributeMapping::targetAttributeMatchesSection\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@Nullable\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq;\n    try {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@Thrown\052/ <%pamtram.metamodel.TargetSectionAttribute%> target = this.getTarget();\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, target);\n        final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid.getTypeId();\n        CAUGHT_eq = eq;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq_0;\n    try {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupType, null);\n        final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n        final /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupType%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupType%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType));\n        final /*@Thrown\052/ <%pamtram.metamodel.TargetSection%> targetMMSection = oclAsType.getTargetMMSection();\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType_0 = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, targetMMSection);\n        final /*@Thrown\052/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_0.getTypeId();\n        CAUGHT_eq_0 = eq_0;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@Thrown\052/ <%java.lang.Boolean%> or = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);\n    if (or == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null if condition\");\n    }\n    /*@Thrown\052/ <%java.lang.Boolean%> status;\n    if (or) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq_1;\n        try {\n            final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupType, null);\n            final /*@Thrown\052/ <%pamtram.metamodel.TargetSectionAttribute%> target_0 = this.getTarget();\n            final /*@Thrown\052/ <%java.lang.Object%> getContainingSection = ((<%pamtram.metamodel.MetaModelElement%>)target_0).getContainingSection();\n            final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer_0 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n            final /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupType%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupType%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer_0, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0));\n            final /*@Thrown\052/ <%pamtram.metamodel.TargetSection%> targetMMSection_0 = oclAsType_0.getTargetMMSection();\n            final /*@Thrown\052/ boolean eq_1 = getContainingSection.equals(targetMMSection_0);\n            CAUGHT_eq_1 = eq_1;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_eq_1 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n        }\n        /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_includes;\n        try {\n            final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_1 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupType, null);\n            final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Section, null);\n            final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer_1 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n            final /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupType%> oclAsType_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupType%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer_1, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_1));\n            final /*@Thrown\052/ <%pamtram.metamodel.TargetSection%> targetMMSection_1 = oclAsType_1.getTargetMMSection();\n            final /*@Thrown\052/ <%pamtram.metamodel.Section%> oclAsType_2 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Section%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, targetMMSection_1, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e));\n            final /*@Thrown\052/ <%java.util.List%><<%java.lang.Object%>> extend = oclAsType_2.getExtend();\n            final /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_extend = idResolver.createOrderedSetOfAll(<%pamtram.mapping.MappingTables%>.ORD_TMPLid_, extend);\n            final /*@Thrown\052/ <%pamtram.metamodel.TargetSectionAttribute%> target_1 = this.getTarget();\n            final /*@Thrown\052/ <%java.lang.Object%> getContainingSection_0 = ((<%pamtram.metamodel.MetaModelElement%>)target_1).getContainingSection();\n            final /*@Thrown\052/ boolean includes = <%org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation%>.INSTANCE.evaluate(BOXED_extend, getContainingSection_0).booleanValue();\n            CAUGHT_includes = includes;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_includes = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n        }\n        final /*@Thrown\052/ <%java.lang.Boolean%> or_0 = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_eq_1, CAUGHT_includes);\n        status = or_0;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_2 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupType, null);\n    final /*@Thrown\052/ <%pamtram.metamodel.TargetSectionAttribute%> target_2 = this.getTarget();\n    final /*@Thrown\052/ <%java.lang.String%> name = target_2.getName();\n    final /*@NonInvalid\052/ <%java.lang.String%> sum = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(<%pamtram.mapping.MappingTables%>.STR_The_32_target_32_attribute_32_39, name);\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_0 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum, <%pamtram.mapping.MappingTables%>.STR__39_32_is_32_not_32_part_32_of_32_the_32_target_32_section_32_referenced_32_by_32_parent_32_hint_32_gr);\n    final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer_2 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n    final /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupType%> oclAsType_3 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupType%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer_2, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_2));\n    final /*@Thrown\052/ <%java.lang.String%> name_0 = oclAsType_3.getName();\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_1 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_0, name_0);\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_2 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_1, <%pamtram.mapping.MappingTables%>.STR__33);\n    message_0 = sum_2;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_AttributeMapping_c_c_targetAttributeMatchesSection, this, null, diagnostics, context, message_0, <%pamtram.mapping.MappingTables%>.INT_4, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean targetAttributeMatchesSection(DiagnosticChain diagnostics, Map<Object, Object> context);

} // AttributeMapping
