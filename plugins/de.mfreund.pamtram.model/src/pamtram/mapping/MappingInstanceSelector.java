/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.metamodel.TargetSectionNonContainmentReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.MappingInstanceSelector#getAffectedReference <em>Affected Reference</em>}</li>
 *   <li>{@link pamtram.mapping.MappingInstanceSelector#getMatcher <em>Matcher</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getMappingInstanceSelector()
 * @model
 * @generated
 */
public interface MappingInstanceSelector extends MappingHint {
	/**
	 * Returns the value of the '<em><b>Affected Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Affected Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affected Reference</em>' reference.
	 * @see #setAffectedReference(TargetSectionNonContainmentReference)
	 * @see pamtram.mapping.MappingPackage#getMappingInstanceSelector_AffectedReference()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!MappingInstanceSelector!affectedReference'"
	 * @generated
	 */
	TargetSectionNonContainmentReference getAffectedReference();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingInstanceSelector#getAffectedReference <em>Affected Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Affected Reference</em>' reference.
	 * @see #getAffectedReference()
	 * @generated
	 */
	void setAffectedReference(TargetSectionNonContainmentReference value);

	/**
	 * Returns the value of the '<em><b>Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matcher</em>' containment reference.
	 * @see #setMatcher(Matcher)
	 * @see pamtram.mapping.MappingPackage#getMappingInstanceSelector_Matcher()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!MappingInstanceSelector!matcher'"
	 * @generated
	 */
	Matcher getMatcher();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingInstanceSelector#getMatcher <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matcher</em>' containment reference.
	 * @see #getMatcher()
	 * @generated
	 */
	void setMatcher(Matcher value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv affectedReferenceMatchesSection:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = if self.affectedReference.oclType() = OclVoid\n *       then true\n *       else\n *         let\n *           targetMMSection : metamodel::TargetSection[1] = if\n *             self.oclContainer()\n *             .oclIsKindOf(MappingHintGroupType)\n *           then\n *             self.oclContainer()\n *             .oclAsType(MappingHintGroupType).targetMMSection\n *           else\n *             self.oclContainer()\n *             .oclAsType(MappingHintGroupImporter).hintGroup.targetMMSection\n *           endif\n *         in\n *           if targetMMSection.oclType() = OclVoid\n *           then true\n *           else\n *             self.affectedReference.getContainingSection() = targetMMSection\n *           endif\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then\n *           let\n *             hintGroupName : String[?] = if\n *               self.oclContainer()\n *               .oclIsKindOf(MappingHintGroupType)\n *             then\n *               self.oclContainer()\n *               .oclAsType(MappingHintGroupType).name\n *             else\n *               self.oclContainer()\n *               .oclAsType(MappingHintGroupImporter).hintGroup.name\n *             endif\n *           in \'The affected reference \\\'\' + self.affectedReference.name + \'\\\' is not part of the target section referenced by parent hint group \\\'\' + hintGroupName + \'\\\'!\'\n *         else null\n *         endif\n *       in\n *         \'MappingInstanceSelector::affectedReferenceMatchesSection\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n/*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSectionNonContainmentReference%> affectedReference = this.getAffectedReference();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(evaluator, affectedReference));\n    final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n    /*@Thrown\052/ boolean status;\n    if (eq) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupType, null);\n        final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n        final /*@Thrown\052/ boolean oclIsKindOf = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0).booleanValue());\n        /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSection%> targetMMSection_1;\n        if (oclIsKindOf) {\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupType%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupType%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0));\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSection%> targetMMSection = oclAsType.getTargetMMSection();\n            targetMMSection_1 = targetMMSection;\n        }\n        else {\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupImporter = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupImporter, null);\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupImporter%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupImporter%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupImporter));\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.ExportedMappingHintGroup%> hintGroup = oclAsType_0.getHintGroup();\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSection%> targetMMSection_0 = hintGroup.getTargetMMSection();\n            targetMMSection_1 = targetMMSection_0;\n        }\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(evaluator, targetMMSection_1));\n        final /*@Thrown\052/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_0.getTypeId();\n        /*@Thrown\052/ boolean symbol_0;\n        if (eq_0) {\n            symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n        }\n        else {\n            final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> getContainingSection = ((<%pamtram.metamodel.MetaModelElement%>)affectedReference).getContainingSection();\n            final /*@Thrown\052/ boolean eq_1 = getContainingSection.equals(targetMMSection_1);\n            symbol_0 = eq_1;\n        }\n        status = symbol_0;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_2 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupType, null);\n    final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer_2 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n    final /*@Thrown\052/ boolean oclIsKindOf_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%>.INSTANCE.evaluate(evaluator, oclContainer_2, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_2).booleanValue());\n    /*@Nullable\052/ /*@Thrown\052/ <%java.lang.String%> hintGroupName;\n    if (oclIsKindOf_0) {\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupType%> oclAsType_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupType%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer_2, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_2));\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.String%> name = oclAsType_1.getName();\n        hintGroupName = name;\n    }\n    else {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupImporter_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupImporter, null);\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupImporter%> oclAsType_2 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupImporter%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer_2, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupImporter_0));\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.ExportedMappingHintGroup%> hintGroup_0 = oclAsType_2.getHintGroup();\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.String%> name_0 = hintGroup_0.getName();\n        hintGroupName = name_0;\n    }\n    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSectionNonContainmentReference%> affectedReference_1 = this.getAffectedReference();\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.String%> name_1 = affectedReference_1.getName();\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%java.lang.String%> sum = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(<%pamtram.mapping.MappingTables%>.STR_The_32_affected_32_reference_32_39, name_1));\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%java.lang.String%> sum_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum, <%pamtram.mapping.MappingTables%>.STR__39_32_is_32_not_32_part_32_of_32_the_32_target_32_section_32_referenced_32_by_32_parent_32_hint_32_gr_0));\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%java.lang.String%> sum_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_0, hintGroupName));\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%java.lang.String%> sum_2 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_1, <%pamtram.mapping.MappingTables%>.STR__39_33));\n    message_0 = sum_2;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_MappingInstanceSelector_c_c_affectedReferenceMatchesSection, this, null, diagnostics, context, message_0, <%pamtram.mapping.MappingTables%>.INT_4, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean affectedReferenceMatchesSection(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv affectedReferenceIsNonContainment:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[?] = if self.affectedReference.oclType() = OclVoid\n *       then true\n *       else\n *         not self.affectedReference.eReference.oclAsType(ecore::EReference).containment\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The affected reference \\\' + self.affectedReference.name + \\\' is no non-containment reference!\'\n *         else null\n *         endif\n *       in\n *         \'MappingInstanceSelector::affectedReferenceIsNonContainment\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n/*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSectionNonContainmentReference%> affectedReference = this.getAffectedReference();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(evaluator, affectedReference));\n    final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n    /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> status;\n    if (eq) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_ecore_c_c_EReference = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_EReference, null);\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> eReference = affectedReference.getEReference();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.emf.ecore.EReference%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, eReference, TYP_ecore_c_c_EReference));\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> containment = oclAsType.isContainment();\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> not = <%org.eclipse.ocl.pivot.library.logical.BooleanNotOperation%>.INSTANCE.evaluate(containment);\n        status = not;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.mapping.MappingTables%>.STR_The_32_affected_32_reference_32_39_32_p_32_self_affectedReference_name_32_p_32_39_32_is_32_no;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_MappingInstanceSelector_c_c_affectedReferenceIsNonContainment, this, null, diagnostics, context, message_0, <%pamtram.mapping.MappingTables%>.INT_4, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean affectedReferenceIsNonContainment(DiagnosticChain diagnostics, Map<Object, Object> context);

} // MappingInstanceSelector
