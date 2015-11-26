/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionReference;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Connection Hint Target Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getModelConnectionHintTargetAttribute()
 * @model
 * @generated
 */
public interface ModelConnectionHintTargetAttribute extends ModifiedAttributeElementType<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute> {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv sourceMatchesPossibleContainerType:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[?] = let\n *         targetMMSection : metamodel::TargetSection[1] = self.oclContainer()\n *         .oclContainer()\n *         .oclAsType(MappingHintGroupType).targetMMSection\n *       in\n *         if\n *           self.source.oclType() = OclVoid or\n *           targetMMSection.oclType() = OclVoid\n *         then true\n *         else\n *           self.source.oclAsType(metamodel::TargetSectionAttribute)\n *           .oclContainer()\n *           .oclAsType(metamodel::Class(S, C, R, A))\n *           .eClass.eAllContainments->exists(r |\n *             r.eReferenceType.isSuperTypeOf(targetMMSection.eClass))\n *         endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The type of the parent hint group\\\'s target section (\\\'\' +\n *           self.oclContainer()\n *           .oclContainer()\n *           .oclAsType(MappingHintGroupType).targetMMSection.eClass.name + \'\\\') cannot be connected to (contained in) the type of the class containing the target attribute (\\\'\' +\n *           self.source.oclAsType(metamodel::TargetSectionAttribute)\n *           .oclContainer()\n *           .oclAsType(metamodel::Class(S, C, R, A)).name + \'\\\')!\'\n *         else null\n *         endif\n *       in\n *         \'ModelConnectionHintTargetAttribute::sourceMatchesPossibleContainerType\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n/*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_symbol_0;\ntry {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_targetMMSection;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupType, null);\n        final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> oclContainer_0 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, oclContainer);\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupType%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupType%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer_0, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0));\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSection%> targetMMSection = oclAsType.getTargetMMSection();\n        CAUGHT_targetMMSection = targetMMSection;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_targetMMSection = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_eq;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> source = this.getSource();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(evaluator, source));\n        final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n        CAUGHT_eq = eq;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_eq_0;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_1 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        if (CAUGHT_targetMMSection instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n            throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_targetMMSection;\n        }\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(evaluator, CAUGHT_targetMMSection));\n        final /*@Thrown\052/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_1.getTypeId();\n        CAUGHT_eq_0 = eq_0;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> or = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);\n    if (or == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null if condition\");\n    }\n    /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> symbol_0;\n    if (or) {\n        symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Class_0, null);\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_TargetSectionAttribute = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_TargetSectionAttribute, null);\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> source_0 = this.getSource();\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSectionAttribute%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.TargetSectionAttribute%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, source_0, TYP_pamtram_c_c_metamodel_c_c_TargetSectionAttribute));\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> oclContainer_1 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, oclAsType_0);\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.Class%> oclAsType_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer_1, TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e_0));\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eClass = oclAsType_1.getEClass();\n        @SuppressWarnings(\"null\")\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%org.eclipse.emf.ecore.EReference%>> eAllContainments = eClass.getEAllContainments();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_eAllContainments = idResolver.createOrderedSetOfAll(<%pamtram.mapping.MappingTables%>.ORD_CLSSid_EReference, eAllContainments);\n        /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE;\n        /*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_r = BOXED_eAllContainments.iterator();\n        /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> exists;\n        while (true) {\n            if (!ITERATOR_r.hasNext()) {\n                if (accumulator == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE) {\n                    exists = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE;\n                }\n                else {\n                    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)accumulator;\n                }\n                break;\n            }\n            /*@Nullable\052/ /*@NonInvalid\052/ <%org.eclipse.emf.ecore.EReference%> r = (<%org.eclipse.emf.ecore.EReference%>)ITERATOR_r.next();\n            /**\n             * r.eReferenceType.isSuperTypeOf(targetMMSection.eClass)\n             \052/\n            /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_isSuperTypeOf;\n            try {\n                if (r == null) {\n                    throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://www.eclipse.org/emf/2002/Ecore\\\'::EReference::eReferenceType\\\'\");\n                }\n                @SuppressWarnings(\"null\")\n                final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eReferenceType = r.getEReferenceType();\n                if (CAUGHT_targetMMSection instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n                    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_targetMMSection;\n                }\n                final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eClass_0 = ((<%pamtram.metamodel.TargetSection%>)CAUGHT_targetMMSection).getEClass();\n                final /*@Thrown\052/ boolean isSuperTypeOf = eReferenceType.isSuperTypeOf(eClass_0);\n                CAUGHT_isSuperTypeOf = isSuperTypeOf;\n            }\n            catch (<%java.lang.Exception%> e) {\n                CAUGHT_isSuperTypeOf = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n            }\n            //\n            if (CAUGHT_isSuperTypeOf == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\t\t\t\t\t// Normal successful body evaluation result\n                exists = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n                break;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately \n            }\n            else if (CAUGHT_isSuperTypeOf == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE) {\t\t\t\t// Normal unsuccessful body evaluation result\n                ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n            }\n            else if (CAUGHT_isSuperTypeOf instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\t\t// Abnormal exception evaluation result\n                accumulator = CAUGHT_isSuperTypeOf;\t\t\t\t\t\t\t\t\t// Cache an exception failure\n            }\n            else {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n                accumulator = new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(<%org.eclipse.ocl.pivot.messages.PivotMessages%>.NonBooleanBody, \"exists\");\n            }\n        }\n        symbol_0 = exists;\n    }\n    CAUGHT_symbol_0 = symbol_0;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_symbol_0 instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_symbol_0;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_symbol_0 == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_1 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupType, null);\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e_1 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Class_0, null);\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_TargetSectionAttribute_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_TargetSectionAttribute, null);\n    final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer_2 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> oclContainer_3 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, oclContainer_2);\n    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupType%> oclAsType_2 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupType%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer_3, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_1));\n    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSection%> targetMMSection_0 = oclAsType_2.getTargetMMSection();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eClass_1 = targetMMSection_0.getEClass();\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.String%> name = eClass_1.getName();\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%java.lang.String%> sum = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(<%pamtram.mapping.MappingTables%>.STR_The_32_type_32_of_32_the_32_parent_32_hint_32_group_39_s_32_target_32_section_32_o_39, name));\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%java.lang.String%> sum_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum, <%pamtram.mapping.MappingTables%>.STR__39_e_32_cannot_32_be_32_connected_32_to_32_o_contained_32_in_e_32_the_32_type_32_of_32_the_32_class_32_c));\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> source_1 = this.getSource();\n    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSectionAttribute%> oclAsType_3 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.TargetSectionAttribute%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, source_1, TYP_pamtram_c_c_metamodel_c_c_TargetSectionAttribute_0));\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> oclContainer_4 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, oclAsType_3);\n    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.Class%> oclAsType_4 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer_4, TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e_1));\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.String%> name_0 = oclAsType_4.getName();\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%java.lang.String%> sum_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_0, name_0));\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%java.lang.String%> sum_2 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_1, <%pamtram.mapping.MappingTables%>.STR__39_e_33));\n    message_0 = sum_2;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_ModelConnectionHintTargetAttribute_c_c_sourceMatchesPossibleContain, this, null, diagnostics, context, message_0, <%pamtram.mapping.MappingTables%>.INT_4, CAUGHT_symbol_0, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean sourceMatchesPossibleContainerType(DiagnosticChain diagnostics, Map<Object, Object> context);
} // ModelConnectionHintTargetAttribute
