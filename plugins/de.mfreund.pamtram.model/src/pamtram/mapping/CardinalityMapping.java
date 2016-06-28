/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSectionClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cardinality Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.CardinalityMapping#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.CardinalityMapping#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getCardinalityMapping()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceClassMatchesSection sourceClassIsVariableCardinality targetClassMatchesSection targetClassIsVariableCardinality noCardinalityMappingForSourceSectionRoot'"
 * @generated
 */
public interface CardinalityMapping extends MappingHint {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(SourceSectionClass)
	 * @see pamtram.mapping.MappingPackage#getCardinalityMapping_Source()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!CardinalityMapping!source'"
	 * @generated
	 */
	SourceSectionClass getSource();

	/**
	 * Sets the value of the '{@link pamtram.mapping.CardinalityMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SourceSectionClass value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(TargetSectionClass)
	 * @see pamtram.mapping.MappingPackage#getCardinalityMapping_Target()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!CardinalityMapping!target'"
	 * @generated
	 */
	TargetSectionClass getTarget();

	/**
	 * Sets the value of the '{@link pamtram.mapping.CardinalityMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TargetSectionClass value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv noCardinalityMappingForSourceSectionRoot:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = if self.source.oclType() = OclVoid\n *       then true\n *       else self.source <> self.source.getContainingSection()\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'Cardinality mappings must not be defined for SourceSection root classes!\'\n *         else null\n *         endif\n *       in\n *         \'CardinalityMapping::noCardinalityMappingForSourceSectionRoot\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n    final /*@Thrown\052/ <%pamtram.metamodel.SourceSectionClass%> source_0 = this.getSource();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, source_0);\n    final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n    /*@Thrown\052/ boolean status;\n    if (eq) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@Thrown\052/ <%java.lang.Object%> getContainingSection = ((<%pamtram.metamodel.MetaModelElement%>)source_0).getContainingSection();\n        final /*@Thrown\052/ boolean ne = !source_0.equals(getContainingSection);\n        status = ne;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne_0 = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne_0) {\n    message_0 = <%pamtram.mapping.MappingTables%>.STR_Cardinality_32_mappings_32_must_32_not_32_be_32_defined_32_for_32_SourceSection_32_root_32;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_CardinalityMapping_c_c_noCardinalityMappingForSourceSectionRoot, this, null, diagnostics, context, message_0, <%pamtram.mapping.MappingTables%>.INT_4, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean noCardinalityMappingForSourceSectionRoot(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv sourceClassMatchesSection:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = if\n *         self.source.oclType() = OclVoid or\n *         self.oclContainer()\n *         .oclContainer()\n *         .oclAsType(Mapping)\n *         .sourceMMSection.oclType() = OclVoid\n *       then true\n *       else\n *         self.source.getContainingSection() =\n *         self.oclContainer()\n *         .oclContainer()\n *         .oclAsType(Mapping).sourceMMSection\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The source class \\\'\' + self.source.name + \'\\\' is not part of the source section referenced by parent mapping \\\'\' +\n *           self.oclContainer()\n *           .oclContainer()\n *           .oclAsType(Mapping).name + \'\\\'!\'\n *         else null\n *         endif\n *       in\n *         \'CardinalityMapping::sourceClassMatchesSection\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq;\n    try {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@Thrown\052/ <%pamtram.metamodel.SourceSectionClass%> source = this.getSource();\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, source);\n        final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n        CAUGHT_eq = eq;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq_0;\n    try {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_1 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_Mapping = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Mapping, null);\n        final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n        final /*@Thrown\052/ <%java.lang.Object%> oclContainer_0 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, oclContainer);\n        final /*@Thrown\052/ <%pamtram.mapping.Mapping%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.Mapping%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer_0, TYP_pamtram_c_c_mapping_c_c_Mapping));\n        final /*@Thrown\052/ <%pamtram.metamodel.SourceSection%> sourceMMSection = oclAsType.getSourceMMSection();\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType_0 = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, sourceMMSection);\n        final /*@Thrown\052/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_1.getTypeId();\n        CAUGHT_eq_0 = eq_0;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@Thrown\052/ <%java.lang.Boolean%> or = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);\n    if (or == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null if condition\");\n    }\n    /*@Thrown\052/ boolean status;\n    if (or) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_Mapping_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Mapping, null);\n        final /*@Thrown\052/ <%pamtram.metamodel.SourceSectionClass%> source_0 = this.getSource();\n        final /*@Thrown\052/ <%java.lang.Object%> getContainingSection = ((<%pamtram.metamodel.MetaModelElement%>)source_0).getContainingSection();\n        final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer_1 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n        final /*@Thrown\052/ <%java.lang.Object%> oclContainer_2 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, oclContainer_1);\n        final /*@Thrown\052/ <%pamtram.mapping.Mapping%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.Mapping%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer_2, TYP_pamtram_c_c_mapping_c_c_Mapping_0));\n        final /*@Thrown\052/ <%pamtram.metamodel.SourceSection%> sourceMMSection_0 = oclAsType_0.getSourceMMSection();\n        final /*@Thrown\052/ boolean eq_1 = getContainingSection.equals(sourceMMSection_0);\n        status = eq_1;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_Mapping_1 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_Mapping, null);\n    final /*@Thrown\052/ <%pamtram.metamodel.SourceSectionClass%> source_1 = this.getSource();\n    final /*@Thrown\052/ <%java.lang.String%> name = source_1.getName();\n    final /*@NonInvalid\052/ <%java.lang.String%> sum = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(<%pamtram.mapping.MappingTables%>.STR_The_32_source_32_class_32_39, name);\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_0 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum, <%pamtram.mapping.MappingTables%>.STR__39_32_is_32_not_32_part_32_of_32_the_32_source_32_section_32_referenced_32_by_32_parent_32_mapping);\n    final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer_3 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n    final /*@Thrown\052/ <%java.lang.Object%> oclContainer_4 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, oclContainer_3);\n    final /*@Thrown\052/ <%pamtram.mapping.Mapping%> oclAsType_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.Mapping%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer_4, TYP_pamtram_c_c_mapping_c_c_Mapping_1));\n    final /*@Thrown\052/ <%java.lang.String%> name_0 = oclAsType_1.getName();\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_1 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_0, name_0);\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_2 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_1, <%pamtram.mapping.MappingTables%>.STR__39_33);\n    message_0 = sum_2;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_CardinalityMapping_c_c_sourceClassMatchesSection, this, null, diagnostics, context, message_0, <%pamtram.mapping.MappingTables%>.INT_4, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean sourceClassMatchesSection(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv targetClassMatchesSection:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = if\n *         self.target.oclType() = OclVoid or\n *         self.oclContainer()\n *         .oclAsType(MappingHintGroupType)\n *         .targetMMSection.oclType() = OclVoid\n *       then true\n *       else\n *         self.target.getContainingSection() =\n *         self.oclContainer()\n *         .oclAsType(MappingHintGroupType).targetMMSection\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The target class \\\'\' + self.target.name + \'\\\' is not part of the target section referenced by parent hint group \\\'\' +\n *           self.oclContainer()\n *           .oclAsType(MappingHintGroupType).name + \'\\\'!\'\n *         else null\n *         endif\n *       in\n *         \'CardinalityMapping::targetClassMatchesSection\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq;\n    try {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@Thrown\052/ <%pamtram.metamodel.TargetSectionClass%> target = this.getTarget();\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, target);\n        final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n        CAUGHT_eq = eq;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    /*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_eq_0;\n    try {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_1 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupType, null);\n        final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n        final /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupType%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupType%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0));\n        final /*@Thrown\052/ <%pamtram.metamodel.TargetSection%> targetMMSection = oclAsType.getTargetMMSection();\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType_0 = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, targetMMSection);\n        final /*@Thrown\052/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_1.getTypeId();\n        CAUGHT_eq_0 = eq_0;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_eq_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@Thrown\052/ <%java.lang.Boolean%> or = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);\n    if (or == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null if condition\");\n    }\n    /*@Thrown\052/ boolean status;\n    if (or) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_1 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupType, null);\n        final /*@Thrown\052/ <%pamtram.metamodel.TargetSectionClass%> target_0 = this.getTarget();\n        final /*@Thrown\052/ <%java.lang.Object%> getContainingSection = ((<%pamtram.metamodel.MetaModelElement%>)target_0).getContainingSection();\n        final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer_0 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n        final /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupType%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupType%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer_0, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_1));\n        final /*@Thrown\052/ <%pamtram.metamodel.TargetSection%> targetMMSection_0 = oclAsType_0.getTargetMMSection();\n        final /*@Thrown\052/ boolean eq_1 = getContainingSection.equals(targetMMSection_0);\n        status = eq_1;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_2 = idResolver.getClass(<%pamtram.mapping.MappingTables%>.CLSSid_MappingHintGroupType, null);\n    final /*@Thrown\052/ <%pamtram.metamodel.TargetSectionClass%> target_1 = this.getTarget();\n    final /*@Thrown\052/ <%java.lang.String%> name = target_1.getName();\n    final /*@NonInvalid\052/ <%java.lang.String%> sum = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(<%pamtram.mapping.MappingTables%>.STR_The_32_target_32_class_32_39, name);\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_0 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum, <%pamtram.mapping.MappingTables%>.STR__39_32_is_32_not_32_part_32_of_32_the_32_target_32_section_32_referenced_32_by_32_parent_32_hint_32_gr_0);\n    final /*@NonInvalid\052/ <%java.lang.Object%> oclContainer_1 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(executor, this);\n    final /*@Thrown\052/ <%pamtram.mapping.MappingHintGroupType%> oclAsType_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.mapping.MappingHintGroupType%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(executor, oclContainer_1, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_2));\n    final /*@Thrown\052/ <%java.lang.String%> name_0 = oclAsType_1.getName();\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_1 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_0, name_0);\n    final /*@NonInvalid\052/ <%java.lang.String%> sum_2 = <%org.eclipse.ocl.pivot.library.string.StringConcatOperation%>.INSTANCE.evaluate(sum_1, <%pamtram.mapping.MappingTables%>.STR__39_33);\n    message_0 = sum_2;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_CardinalityMapping_c_c_targetClassMatchesSection, this, null, diagnostics, context, message_0, <%pamtram.mapping.MappingTables%>.INT_4, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean targetClassMatchesSection(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv targetClassIsVariableCardinality:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = if self.target.oclType() = OclVoid\n *       then true\n *       else self.target.cardinality <> metamodel::CardinalityType::ONE\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'Cardinality mappings may only be defined for target classes with a specified cardinality distinct from \\\'CardinalityType::ONE\\\'!\'\n *         else null\n *         endif\n *       in\n *         \'CardinalityMapping::targetClassIsVariableCardinality\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n    final /*@Thrown\052/ <%pamtram.metamodel.TargetSectionClass%> target = this.getTarget();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, target);\n    final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n    /*@Thrown\052/ boolean status;\n    if (eq) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@Thrown\052/ <%pamtram.metamodel.CardinalityType%> cardinality = target.getCardinality();\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.ids.EnumerationLiteralId%> BOXED_cardinality = <%pamtram.mapping.MappingTables%>.ENUMid_CardinalityType.getEnumerationLiteralId(<%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(cardinality.getName()));\n        final /*@Thrown\052/ boolean ne = BOXED_cardinality != <%pamtram.mapping.MappingTables%>.ELITid_ONE;\n        status = ne;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne_0 = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne_0) {\n    message_0 = <%pamtram.mapping.MappingTables%>.STR_Cardinality_32_mappings_32_may_32_only_32_be_32_defined_32_for_32_target_32_classes_32_with;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_CardinalityMapping_c_c_targetClassIsVariableCardinality, this, null, diagnostics, context, message_0, <%pamtram.mapping.MappingTables%>.INT_4, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean targetClassIsVariableCardinality(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv sourceClassIsVariableCardinality:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = if self.source.oclType() = OclVoid\n *       then true\n *       else self.source.cardinality <> metamodel::CardinalityType::ONE\n *       endif\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'Cardinality mappings may only be defined for source classes with a specified cardinality distinct from \\\'CardinalityType::ONE\\\'!\'\n *         else null\n *         endif\n *       in\n *         \'CardinalityMapping::sourceClassIsVariableCardinality\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Executor%> executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = executor.getIdResolver();\n/*@Caught\052/ /*@NonNull\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_OclVoid_0 = idResolver.getClass(<%org.eclipse.ocl.pivot.ids.TypeId%>.OCL_VOID, null);\n    final /*@Thrown\052/ <%pamtram.metamodel.SourceSectionClass%> source = this.getSource();\n    final /*@Thrown\052/ <%org.eclipse.ocl.pivot.Class%> oclType = (<%org.eclipse.ocl.pivot.Class%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation%>.INSTANCE.evaluate(executor, source);\n    final /*@Thrown\052/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();\n    /*@Thrown\052/ boolean status;\n    if (eq) {\n        status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@Thrown\052/ <%pamtram.metamodel.CardinalityType%> cardinality = source.getCardinality();\n        final /*@Thrown\052/ <%org.eclipse.ocl.pivot.ids.EnumerationLiteralId%> BOXED_cardinality = <%pamtram.mapping.MappingTables%>.ENUMid_CardinalityType.getEnumerationLiteralId(<%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(cardinality.getName()));\n        final /*@Thrown\052/ boolean ne = BOXED_cardinality != <%pamtram.mapping.MappingTables%>.ELITid_ONE;\n        status = ne;\n    }\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne_0 = CAUGHT_status == Boolean.FALSE;\n/*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne_0) {\n    message_0 = <%pamtram.mapping.MappingTables%>.STR_Cardinality_32_mappings_32_may_32_only_32_be_32_defined_32_for_32_source_32_classes_32_with;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(executor, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.mapping.MappingTables%>.STR_CardinalityMapping_c_c_sourceClassIsVariableCardinality, this, null, diagnostics, context, message_0, <%pamtram.mapping.MappingTables%>.INT_4, CAUGHT_status, <%pamtram.mapping.MappingTables%>.INT_0).booleanValue();\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean sourceClassIsVariableCardinality(DiagnosticChain diagnostics, Map<Object, Object> context);

} // CardinalityMapping
