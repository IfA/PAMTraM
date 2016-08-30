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
 * A representation of the model object '<em><b>External Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getExternalModifiedAttributeElementType()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceAttributeMatchesContainerSection'"
 * @generated
 */
public interface ExternalModifiedAttributeElementType<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ModifiedAttributeElementType<S, C, R, A> {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv sourceAttributeMatchesContainerSection:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = if self.getMapping().oclType() = OclVoid\n *       then true\n *       else\n *         let\n *           sourceSection : metamodel::SourceSection[1] = self.getMapping().sourceSection\n *         in\n *           if\n *             self.source.oclType() = OclVoid or\n *             sourceSection.oclType() = OclVoid\n *           then true\n *           else\n *             self.source.oclAsType(metamodel::ActualSourceSectionAttribute)\n *             .getContainingSection()\n *             .oclAsType(metamodel::SourceSection)\n *             .isContainerFor(\n *               sourceSection.oclAsType(metamodel::SourceSection))\n *           endif\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The source attribute \\\'\' +\n *           self.source.oclAsType(metamodel::Attribute(S, C, R, A)).name + \'\\\' is not part of a container section of the source section of the parent mapping \\\'\' +\n *           self.getMapping().sourceSection.name + \'\\\'!\'\n *         else null\n *         endif\n *       in\n *         \'ExternalModifiedAttributeElementType::sourceAttributeMatchesContainerSection\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n    final /*@Thrown\052/ <%pamtram.mapping.Mapping%> getMapping = ((<%pamtram.mapping.ModifiedAttributeElementType%>)this).getMapping();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, getMapping);\n    final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n    /*@Thrown\052/ boolean status;\n    if (eq) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_sourceSection;\n        try {\n            final /*@Thrown\052/ <%pamtram.metamodel.SourceSection%> sourceSection = getMapping.getSourceSection();\n            CAUGHT_sourceSection = sourceSection;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_sourceSection = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n        }\n        /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq_0;\n        try {\n            final /*@Thrown\052/ <%java.lang.Object%> source = this.getSource();\n            final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType_0 = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, source);\n            final /*@Thrown\052/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_0.getTypeId();\n            CAUGHT_eq_0 = eq_0;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_eq_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n        }\n        /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq_1;\n        try {\n            if (CAUGHT_sourceSection instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n                throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_sourceSection;\n            }\n            final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType_1 = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, CAUGHT_sourceSection);\n            final /*@Thrown\052/ boolean eq_1 = oclType_1.getTypeId() == TYP_OclVoid_0.getTypeId();\n            CAUGHT_eq_1 = eq_1;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_eq_1 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n        }\n        final /*@Thrown\052/ <%java.lang.Boolean%> or = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_eq_0, CAUGHT_eq_1);\n        if (or == null) {\n            throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null if condition\");\n        }\n        /*@Thrown\052/ boolean symbol_0;\n        if (or) {\n            symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n        }\n        else {\n            final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_ActualSourceSectionAttribute = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_ActualSourceSectionAttribute, null);\n            final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_SourceSection_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_SourceSection, null);\n            final /*@Thrown\052/ <%java.lang.Object%> source_0 = this.getSource();\n            final /*@Thrown\052/ <%pamtram.metamodel.ActualSourceSectionAttribute%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.ActualSourceSectionAttribute%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, source_0, TYP_pamtram_c_c_metamodel_c_c_ActualSourceSectionAttribute));\n            final /*@Thrown\052/ <%java.lang.Object%> getContainingSection = ((<%pamtram.metamodel.MetaModelElement%>)oclAsType).getContainingSection();\n            final /*@Thrown\052/ <%pamtram.metamodel.SourceSection%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.SourceSection%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, getContainingSection, TYP_pamtram_c_c_metamodel_c_c_SourceSection_0));\n            if (CAUGHT_sourceSection instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n                throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_sourceSection;\n            }\n            final /*@Thrown\052/ <%pamtram.metamodel.SourceSection%> oclAsType_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.SourceSection%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, CAUGHT_sourceSection, TYP_pamtram_c_c_metamodel_c_c_SourceSection_0));\n            final /*@Thrown\052/ boolean isContainerFor = ((<%pamtram.metamodel.Class%>)oclAsType_0).isContainerFor(oclAsType_1);\n            symbol_0 = isContainerFor;\n        }\n        status = symbol_0;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Attribute_o_S_44_C_44_R_44_A_e = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Attribute, null);\n    final /*@Thrown\052/ <%java.lang.Object%> source_1 = this.getSource();\n    final /*@Thrown\052/ <%pamtram.metamodel.Attribute%> oclAsType_2 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Attribute%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, source_1, TYP_pamtram_c_c_metamodel_c_c_Attribute_o_S_44_C_44_R_44_A_e));\n    final /*@Thrown\052/ <%java.lang.String%> name = oclAsType_2.getName();\n    final /*@NonInvalid\052/ <%java.lang.String%> sum = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(<%pamtram.mapping.MappingTables%>.STR_The_32_source_32_attribute_32_39, name);\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_0 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum, <%pamtram.mapping.MappingTables%>.STR__39_32_is_32_not_32_part_32_of_32_a_32_container_32_section_32_of_32_the_32_source_32_section_32_of_32_th);\n    final /*@Thrown\052/ <%pamtram.mapping.Mapping%> getMapping_1 = ((<%pamtram.mapping.ModifiedAttributeElementType%>)this).getMapping();\n    final /*@Thrown\052/ <%pamtram.metamodel.SourceSection%> sourceSection_0 = getMapping_1.getSourceSection();\n    final /*@Thrown\052/ <%java.lang.String%> name_0 = sourceSection_0.getName();\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_1 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_0, name_0);\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_2 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_1, <%pamtram.mapping.MappingTables%>.STR__39_33);\n    message_0 = sum_2;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_ExternalModifiedAttributeElementType_c_c_sourceAttributeMatchesCont, this, null, diagnostics, context, message_0, <%pamtram.mapping.MappingTables%>.INT_4, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean sourceAttributeMatchesContainerSection(DiagnosticChain diagnostics, Map<Object, Object> context);
} // ExternalModifiedAttributeElementType
