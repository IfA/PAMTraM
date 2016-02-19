/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getLocalModifiedAttributeElementType()
 * @model abstract="true"
 * @generated
 */
public interface LocalModifiedAttributeElementType<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ModifiedAttributeElementType<S, C, R, A> {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv sourceAttributeMatchesSectionOrContainedSection:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[?] = let\n *         sourceMMSection : metamodel::SourceSection[1] = self.getMappingHintGroup()\n *         .oclContainer()\n *         .oclAsType(Mapping).sourceMMSection\n *       in\n *         if\n *           self.source.oclType() = OclVoid or\n *           sourceMMSection.oclType() = OclVoid\n *         then true\n *         else\n *           self.source.oclAsType(metamodel::MetaModelElement(S, C, R, A))\n *           .getContainingSection() = sourceMMSection or\n *           self.source.oclAsType(metamodel::SourceSectionAttribute)\n *           .getContainingSection()\n *           .oclAsType(metamodel::SourceSection)\n *           .isReferencedBy(sourceMMSection, null) or\n *           sourceMMSection.oclAsType(metamodel::Section(S, C, R, A))\n *           .extend->exists(e | e =\n *             self.source.oclAsType(metamodel::SourceSectionAttribute)\n *             .getContainingSection()\n *             .oclAsType(metamodel::Section(S, C, R, A))) or\n *           sourceMMSection.oclAsType(metamodel::Section(S, C, R, A))\n *           .extend->exists(e |\n *             self.source.oclAsType(metamodel::SourceSectionAttribute)\n *             .getContainingSection()\n *             .oclAsType(metamodel::Section(S, C, R, A))\n *             .isReferencedBy(\n *               e.oclAsType(metamodel::Section(S, C, R, A)), null))\n *         endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The source attribute \\\'\' +\n *           self.source.oclAsType(metamodel::Attribute(S, C, R, A)).name + \'\\\' is not referenced by the source section of the parent hint group \\\'\' +\n *           self.getMappingHintGroup()\n *           .oclContainer()\n *           .oclAsType(Mapping).sourceMMSection.name + \'\\\' or in one of its extended sections/sub-sections!\'\n *         else null\n *         endif\n *       in\n *         \'LocalModifiedAttributeElementType::sourceAttributeMatchesSectionOrContainedSection\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n/*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_symbol_0;\ntry {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_sourceMMSection;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_Mapping_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Mapping, null);\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.NamedElement%> getMappingHintGroup = ((<%pamtram.mapping.ModifiedAttributeElementType%>)this).getMappingHintGroup();\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, getMappingHintGroup);\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.Mapping%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.Mapping%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_Mapping_0));\n        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSection%> sourceMMSection = oclAsType.getSourceMMSection();\n        CAUGHT_sourceMMSection = sourceMMSection;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_sourceMMSection = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_eq;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> source = this.getSource();\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(evaluator, source));\n        final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n        CAUGHT_eq = eq;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_eq_0;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_1 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        if (CAUGHT_sourceMMSection instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n            throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_sourceMMSection;\n        }\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(evaluator, CAUGHT_sourceMMSection));\n        final /*@Thrown\052/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_1.getTypeId();\n        CAUGHT_eq_0 = eq_0;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> or = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);\n    if (or == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null if condition\");\n    }\n    /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> symbol_0;\n    if (or) {\n        symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        /*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_or_1;\n        try {\n            /*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_or_0;\n            try {\n                /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_eq_1;\n                try {\n                    final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_MetaModelElement_o_S_44_C_44_R_44_A_e = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MetaModelElement, null);\n                    final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> source_0 = this.getSource();\n                    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.MetaModelElement%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.MetaModelElement%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, source_0, TYP_pamtram_c_c_metamodel_c_c_MetaModelElement_o_S_44_C_44_R_44_A_e));\n                    final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> getContainingSection = oclAsType_0.getContainingSection();\n                    if (CAUGHT_sourceMMSection instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n                        throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_sourceMMSection;\n                    }\n                    final /*@Thrown\052/ boolean eq_1 = getContainingSection.equals(CAUGHT_sourceMMSection);\n                    CAUGHT_eq_1 = eq_1;\n                }\n                catch (<%java.lang.Exception%> e) {\n                    CAUGHT_eq_1 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n                }\n                /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_isReferencedBy;\n                try {\n                    final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_SourceSection = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_SourceSection, null);\n                    final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_SourceSectionAttribute, null);\n                    final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> source_1 = this.getSource();\n                    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSectionAttribute%> oclAsType_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.SourceSectionAttribute%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, source_1, TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute));\n                    final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> getContainingSection_0 = ((<%pamtram.metamodel.MetaModelElement%>)oclAsType_1).getContainingSection();\n                    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSection%> oclAsType_2 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.SourceSection%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, getContainingSection_0, TYP_pamtram_c_c_metamodel_c_c_SourceSection));\n                    if (CAUGHT_sourceMMSection instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n                        throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_sourceMMSection;\n                    }\n                    final /*@Thrown\052/ boolean isReferencedBy = ((<%pamtram.metamodel.Class%>)oclAsType_2).isReferencedBy((<%pamtram.metamodel.Class%>)CAUGHT_sourceMMSection, null);\n                    CAUGHT_isReferencedBy = isReferencedBy;\n                }\n                catch (<%java.lang.Exception%> e) {\n                    CAUGHT_isReferencedBy = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n                }\n                final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> or_0 = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_eq_1, CAUGHT_isReferencedBy);\n                CAUGHT_or_0 = or_0;\n            }\n            catch (<%java.lang.Exception%> e) {\n                CAUGHT_or_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n            }\n            /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_exists;\n            try {\n                final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_1 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Section, null);\n                if (CAUGHT_sourceMMSection instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n                    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_sourceMMSection;\n                }\n                final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.Section%> oclAsType_3 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Section%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, CAUGHT_sourceMMSection, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_1));\n                final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><? extends <%java.lang.Object%>> extend = oclAsType_3.getExtend();\n                final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_extend = idResolver.createOrderedSetOfAll(<%pamtram.mapping.MappingTables%>.ORD_TMPLid_, extend);\n                /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE;\n                /*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_e_0 = BOXED_extend.iterator();\n                /*@Thrown\052/ boolean exists;\n                while (true) {\n                    if (!ITERATOR_e_0.hasNext()) {\n                        if (accumulator == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE) {\n                            exists = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE;\n                        }\n                        else {\n                            throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)accumulator;\n                        }\n                        break;\n                    }\n                    /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> e_0 = (<%java.lang.Object%>)ITERATOR_e_0.next();\n                    /**\n                     * e =\n                     * self.source.oclAsType(metamodel::SourceSectionAttribute)\n                     * .getContainingSection()\n                     * .oclAsType(metamodel::Section(S, C, R, A))\n                     \052/\n                    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_eq_2;\n                    try {\n                        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_SourceSectionAttribute, null);\n                        final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> source_2 = this.getSource();\n                        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSectionAttribute%> oclAsType_4 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.SourceSectionAttribute%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, source_2, TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_0));\n                        final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> getContainingSection_1 = ((<%pamtram.metamodel.MetaModelElement%>)oclAsType_4).getContainingSection();\n                        final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.Section%> oclAsType_5 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Section%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, getContainingSection_1, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_1));\n                        final /*@Thrown\052/ boolean eq_2 = oclAsType_5.equals(e_0);\n                        CAUGHT_eq_2 = eq_2;\n                    }\n                    catch (<%java.lang.Exception%> e) {\n                        CAUGHT_eq_2 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n                    }\n                    //\n                    if (CAUGHT_eq_2 == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\t\t\t\t\t// Normal successful body evaluation result\n                        exists = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n                        break;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately \n                    }\n                    else if (CAUGHT_eq_2 == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE) {\t\t\t\t// Normal unsuccessful body evaluation result\n                        ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n                    }\n                    else if (CAUGHT_eq_2 instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\t\t// Abnormal exception evaluation result\n                        accumulator = CAUGHT_eq_2;\t\t\t\t\t\t\t\t\t// Cache an exception failure\n                    }\n                    else {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n                        accumulator = new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(<%org.eclipse.ocl.pivot.messages.PivotMessages%>.NonBooleanBody, \"exists\");\n                    }\n                }\n                CAUGHT_exists = exists;\n            }\n            catch (<%java.lang.Exception%> e) {\n                CAUGHT_exists = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n            }\n            final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> or_1 = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_or_0, CAUGHT_exists);\n            CAUGHT_or_1 = or_1;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_or_1 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n        }\n        /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_exists_0;\n        try {\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_4 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Section, null);\n            if (CAUGHT_sourceMMSection instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n                throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_sourceMMSection;\n            }\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.Section%> oclAsType_6 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Section%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, CAUGHT_sourceMMSection, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_4));\n            final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><? extends <%java.lang.Object%>> extend_0 = oclAsType_6.getExtend();\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_extend_0 = idResolver.createOrderedSetOfAll(<%pamtram.mapping.MappingTables%>.ORD_TMPLid_, extend_0);\n            /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> accumulator_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE;\n            /*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_e_1 = BOXED_extend_0.iterator();\n            /*@Thrown\052/ boolean exists_0;\n            while (true) {\n                if (!ITERATOR_e_1.hasNext()) {\n                    if (accumulator_0 == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE) {\n                        exists_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE;\n                    }\n                    else {\n                        throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)accumulator_0;\n                    }\n                    break;\n                }\n                /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> e_1 = (<%java.lang.Object%>)ITERATOR_e_1.next();\n                /**\n                 * \n                 * self.source.oclAsType(metamodel::SourceSectionAttribute)\n                 * .getContainingSection()\n                 * .oclAsType(metamodel::Section(S, C, R, A))\n                 * .isReferencedBy(\n                 *   e.oclAsType(metamodel::Section(S, C, R, A)), null)\n                 \052/\n                /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_isReferencedBy_0;\n                try {\n                    final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_1 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_SourceSectionAttribute, null);\n                    final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> source_3 = this.getSource();\n                    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSectionAttribute%> oclAsType_7 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.SourceSectionAttribute%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, source_3, TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_1));\n                    final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> getContainingSection_2 = ((<%pamtram.metamodel.MetaModelElement%>)oclAsType_7).getContainingSection();\n                    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.Section%> oclAsType_8 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Section%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, getContainingSection_2, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_4));\n                    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.Section%> oclAsType_9 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Section%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, e_1, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_4));\n                    final /*@Thrown\052/ boolean isReferencedBy_0 = ((<%pamtram.metamodel.Class%>)oclAsType_8).isReferencedBy((<%pamtram.metamodel.Class%>)oclAsType_9, null);\n                    CAUGHT_isReferencedBy_0 = isReferencedBy_0;\n                }\n                catch (<%java.lang.Exception%> e) {\n                    CAUGHT_isReferencedBy_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n                }\n                //\n                if (CAUGHT_isReferencedBy_0 == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\t\t\t\t\t// Normal successful body evaluation result\n                    exists_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n                    break;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately \n                }\n                else if (CAUGHT_isReferencedBy_0 == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE) {\t\t\t\t// Normal unsuccessful body evaluation result\n                    ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n                }\n                else if (CAUGHT_isReferencedBy_0 instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\t\t// Abnormal exception evaluation result\n                    accumulator_0 = CAUGHT_isReferencedBy_0;\t\t\t\t\t\t\t\t\t// Cache an exception failure\n                }\n                else {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n                    accumulator_0 = new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(<%org.eclipse.ocl.pivot.messages.PivotMessages%>.NonBooleanBody, \"exists\");\n                }\n            }\n            CAUGHT_exists_0 = exists_0;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_exists_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n        }\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> or_2 = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_or_1, CAUGHT_exists_0);\n        symbol_0 = or_2;\n    }\n    CAUGHT_symbol_0 = symbol_0;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_symbol_0 instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_symbol_0;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_symbol_0 == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_Mapping_1 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Mapping, null);\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Attribute_o_S_44_C_44_R_44_A_e = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Attribute, null);\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> source_4 = this.getSource();\n    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.Attribute%> oclAsType_10 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Attribute%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, source_4, TYP_pamtram_c_c_metamodel_c_c_Attribute_o_S_44_C_44_R_44_A_e));\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.String%> name = oclAsType_10.getName();\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%java.lang.String%> sum = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(<%pamtram.mapping.MappingTables%>.STR_The_32_source_32_attribute_32_39, name));\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%java.lang.String%> sum_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum, <%pamtram.mapping.MappingTables%>.STR__39_32_is_32_not_32_referenced_32_by_32_the_32_source_32_section_32_of_32_the_32_parent_32_hint_32_gro));\n    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.NamedElement%> getMappingHintGroup_0 = ((<%pamtram.mapping.ModifiedAttributeElementType%>)this).getMappingHintGroup();\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> oclContainer_0 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, getMappingHintGroup_0);\n    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.Mapping%> oclAsType_11 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.Mapping%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer_0, TYP_pamtram_c_c_mapping_c_c_Mapping_1));\n    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSection%> sourceMMSection_0 = oclAsType_11.getSourceMMSection();\n    final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.String%> name_0 = sourceMMSection_0.getName();\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%java.lang.String%> sum_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_0, name_0));\n    final /*@NonNull\052/ /*@NonInvalid\052/ <%java.lang.String%> sum_2 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_1, <%pamtram.mapping.MappingTables%>.STR__39_32_or_32_in_32_one_32_of_32_its_32_extended_32_sections_s_sub_m_sections_33));\n    message_0 = sum_2;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_LocalModifiedAttributeElementType_c_c_sourceAttributeMatchesSection, this, null, diagnostics, context, message_0, <%pamtram.mapping.MappingTables%>.INT_4, CAUGHT_symbol_0, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean sourceAttributeMatchesSectionOrContainedSection(DiagnosticChain diagnostics, Map<Object, Object> context);
} // LocalModifiedAttributeElementType
