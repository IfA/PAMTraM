/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getLocalModifiedAttributeElementType()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceAttributeMatchesSectionOrContainedSection'"
 * @generated
 */
public interface LocalModifiedAttributeElementType<C extends pamtram.metamodel.Class<C, R, A>, R extends Reference<C, R, A>, A extends Attribute<C, R, A>> extends ModifiedAttributeElementType<C, R, A> {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv sourceAttributeMatchesSectionOrContainedSection:\n *   let\n *     severity : Integer[1] = \'LocalModifiedAttributeElementType::sourceAttributeMatchesSectionOrContainedSection\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let\n *         status : OclAny[?] = self.source.oclAsType(metamodel::MetaModelElement(C, R, A))\n *         .getContainingSection() =\n *         self.getMappingHintGroup()\n *         .oclContainer()\n *         .oclAsType(Mapping).sourceMMSection or\n *         self.source.oclAsType(metamodel::SourceSectionAttribute)\n *         .getContainingSection()\n *         .oclAsType(metamodel::SourceSectionClass)\n *         .isContainedIn(\n *           self.getMappingHintGroup()\n *           .oclContainer()\n *           .oclAsType(Mapping).sourceMMSection)\n *       in\n *         \'LocalModifiedAttributeElementType::sourceAttributeMatchesSectionOrContainedSection\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.mapping.MappingTables%>.STR_LocalModifiedAttributeElementType_c_c_sourceAttributeMatchesSection));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_eq;\n        try {\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_Mapping_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Mapping, null);\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_MetaModelElement_o_C_44_R_44_A_e = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MetaModelElement, null);\n            final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> source = this.getSource();\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.MetaModelElement%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.MetaModelElement%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, source, TYP_pamtram_c_c_metamodel_c_c_MetaModelElement_o_C_44_R_44_A_e));\n            final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> getContainingSection = oclAsType.getContainingSection();\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.NamedElement%> getMappingHintGroup = ((<%pamtram.mapping.ModifiedAttributeElementType%>)this).getMappingHintGroup();\n            final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, getMappingHintGroup);\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.Mapping%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.Mapping%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_Mapping_0));\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSectionClass%> sourceMMSection = oclAsType_0.getSourceMMSection();\n            final /*@Thrown\052/ boolean eq = getContainingSection.equals(sourceMMSection);\n            CAUGHT_eq = eq;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_eq = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n        }\n        /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_isContainedIn;\n        try {\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_Mapping_1 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Mapping, null);\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_SourceSectionAttribute, null);\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_SourceSectionClass = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_SourceSectionClass, null);\n            final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> source_0 = this.getSource();\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSectionAttribute%> oclAsType_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.SourceSectionAttribute%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, source_0, TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute));\n            final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> getContainingSection_0 = ((<%pamtram.metamodel.MetaModelElement%>)oclAsType_1).getContainingSection();\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSectionClass%> oclAsType_2 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.SourceSectionClass%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, getContainingSection_0, TYP_pamtram_c_c_metamodel_c_c_SourceSectionClass));\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.NamedElement%> getMappingHintGroup_0 = ((<%pamtram.mapping.ModifiedAttributeElementType%>)this).getMappingHintGroup();\n            final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> oclContainer_0 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, getMappingHintGroup_0);\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.mapping.Mapping%> oclAsType_3 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.Mapping%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer_0, TYP_pamtram_c_c_mapping_c_c_Mapping_1));\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSectionClass%> sourceMMSection_0 = oclAsType_3.getSourceMMSection();\n            final /*@Thrown\052/ boolean isContainedIn = ((<%pamtram.metamodel.Class%>)oclAsType_2).isContainedIn((<%pamtram.metamodel.Class%>)sourceMMSection_0);\n            CAUGHT_isContainedIn = isContainedIn;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_isContainedIn = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n        }\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> status = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_isContainedIn);\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_LocalModifiedAttributeElementType_c_c_sourceAttributeMatchesSection, this, null, diagnostics, context, null, severity_0, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean sourceAttributeMatchesSectionOrContainedSection(DiagnosticChain diagnostics, Map<Object, Object> context);
} // LocalModifiedAttributeElementType