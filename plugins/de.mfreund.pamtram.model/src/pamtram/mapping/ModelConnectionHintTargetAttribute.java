/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
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
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceMatchesPossibleContainerType'"
 * @generated
 */
public interface ModelConnectionHintTargetAttribute extends ModifiedAttributeElementType<TargetSectionClass, TargetSectionReference, TargetSectionAttribute> {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv sourceMatchesPossibleContainerType:\n *   let\n *     severity : Integer[1] = \'ModelConnectionHintTargetAttribute::sourceMatchesPossibleContainerType\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let\n *         status : OclAny[?] = self.source.oclAsType(metamodel::TargetSectionAttribute)\n *         .oclContainer()\n *         .oclAsType(metamodel::Class(C, R, A))\n *         .eClass.eAllContainments->exists(r |\n *           r.eReferenceType.isSuperTypeOf(\n *             self.oclContainer()\n *             .oclContainer()\n *             .oclAsType(MappingHintGroupType).targetMMSection.eClass))\n *       in\n *         \'ModelConnectionHintTargetAttribute::sourceMatchesPossibleContainerType\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.mapping.MappingTables%>.STR_ModelConnectionHintTargetAttribute_c_c_sourceMatchesPossibleContain));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Class_o_C_44_R_44_A_e_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Class_0, null);\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_TargetSectionAttribute = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_TargetSectionAttribute, null);\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> source = this.getSource();\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSectionAttribute%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.TargetSectionAttribute%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, source, TYP_pamtram_c_c_metamodel_c_c_TargetSectionAttribute));\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, oclAsType);\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.Class%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_metamodel_c_c_Class_o_C_44_R_44_A_e_0));\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eClass = oclAsType_0.getEClass();\n        @SuppressWarnings(\"null\")\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%org.eclipse.emf.ecore.EReference%>> eAllContainments = eClass.getEAllContainments();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_eAllContainments = idResolver.createOrderedSetOfAll(<%pamtram.mapping.MappingTables%>.ORD_CLSSid_EReference, eAllContainments);\n        /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE;\n        /*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_r = BOXED_eAllContainments.iterator();\n        /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> status;\n        while (true) {\n            if (!ITERATOR_r.hasNext()) {\n                if (accumulator == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE) {\n                    status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE;\n                }\n                else {\n                    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)accumulator;\n                }\n                break;\n            }\n            /*@Nullable\052/ /*@NonInvalid\052/ <%org.eclipse.emf.ecore.EReference%> r = (<%org.eclipse.emf.ecore.EReference%>)ITERATOR_r.next();\n            /**\n             * \n             * r.eReferenceType.isSuperTypeOf(\n             *   self.oclContainer()\n             *   .oclContainer()\n             *   .oclAsType(MappingHintGroupType).targetMMSection.eClass)\n             \052/\n            /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_isSuperTypeOf;\n            try {\n                final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupType, null);\n                if (r == null) {\n                    throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://www.eclipse.org/emf/2002/Ecore\\\'::EReference::eReferenceType\\\'\");\n                }\n                @SuppressWarnings(\"null\")\n                final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eReferenceType = r.getEReferenceType();\n                final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer_0 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n                final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> oclContainer_1 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, oclContainer_0);\n                final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupType%> oclAsType_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupType%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer_1, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0));\n                final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSectionClass%> targetMMSection = oclAsType_1.getTargetMMSection();\n                final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eClass_0 = targetMMSection.getEClass();\n                final /*@Thrown\052/ boolean isSuperTypeOf = eReferenceType.isSuperTypeOf(eClass_0);\n                CAUGHT_isSuperTypeOf = isSuperTypeOf;\n            }\n            catch (<%java.lang.Exception%> e) {\n                CAUGHT_isSuperTypeOf = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n            }\n            //\n            if (CAUGHT_isSuperTypeOf == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\t\t\t\t\t// Normal successful body evaluation result\n                status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n                break;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately \n            }\n            else if (CAUGHT_isSuperTypeOf == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE) {\t\t\t\t// Normal unsuccessful body evaluation result\n                ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n            }\n            else if (CAUGHT_isSuperTypeOf instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\t\t// Abnormal exception evaluation result\n                accumulator = CAUGHT_isSuperTypeOf;\t\t\t\t\t\t\t\t\t// Cache an exception failure\n            }\n            else {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n                accumulator = new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(<%org.eclipse.ocl.pivot.messages.PivotMessages%>.NonBooleanBody, \"exists\");\n            }\n        }\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_ModelConnectionHintTargetAttribute_c_c_sourceMatchesPossibleContain, this, null, diagnostics, context, null, severity_0, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean sourceMatchesPossibleContainerType(DiagnosticChain diagnostics, Map<Object, Object> context);
} // ModelConnectionHintTargetAttribute