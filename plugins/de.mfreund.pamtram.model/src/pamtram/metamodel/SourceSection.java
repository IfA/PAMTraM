/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import pamtram.mapping.MappingType;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.SourceSection#getReferencingMappings <em>Referencing Mappings</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSourceSection()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='isReferencedByMapping'"
 * @generated
 */
public interface SourceSection extends SourceSectionClass, Section<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {

	/**
	 * Returns the value of the '<em><b>Referencing Mappings</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referencing Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referencing Mappings</em>' reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSection_ReferencingMappings()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * mapping::MappingType.allInstances()->select(m | self = m.sourceMMSection)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingType_0 = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_MappingType, null);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.SetValue%> allInstances = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.metamodel.MetamodelTables%>.SET_CLSSid_MappingType, TYP_pamtram_c_c_mapping_c_c_MappingType_0));\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSetAccumulatorValue(<%pamtram.metamodel.MetamodelTables%>.SET_CLSSid_MappingType);\n/*@NonNull\052/ <%java.util.Iterator%><?> ITERATOR_m = allInstances.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> select;\nwhile (true) {\n    if (!ITERATOR_m.hasNext()) {\n        select = accumulator;\n        break;\n    }\n    /*@NonNull\052/ /*@NonInvalid\052/ <%pamtram.mapping.MappingType%> m = (<%pamtram.mapping.MappingType%>)ITERATOR_m.next();\n    /**\n     * self = m.sourceMMSection\n     \052/\n    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSection%> sourceMMSection = m.getSourceMMSection();\n    final /*@Thrown\052/ boolean eq = this.equals(sourceMMSection);\n    //\n    if (eq == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\n        accumulator.add(m);\n    }\n}\nfinal <%java.util.List%><<%pamtram.mapping.MappingType%>> UNBOXED_select = select.asEcoreObjects(idResolver, pamtram.mapping.MappingType.class);\nassert UNBOXED_select != null;\nreturn (<%org.eclipse.emf.common.util.EList<pamtram.mapping.MappingType>%>)UNBOXED_select;'"
	 * @generated
	 */
	EList<MappingType> getReferencingMappings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv isReferencedByMapping:\n *   let severity : Integer[1] = 2\n *   in\n *     let status : OclAny[1] = self.referencingMappings->size() > 0\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'The section is not referenced by any mapping!\'\n *         else null\n *         endif\n *       in\n *         \'SourceSection::isReferencedByMapping\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n/*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.mapping.MappingType%>> referencingMappings = this.getReferencingMappings();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_referencingMappings = idResolver.createOrderedSetOfAll(<%pamtram.metamodel.MetamodelTables%>.ORD_CLSSid_MappingType, referencingMappings);\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_referencingMappings));\n    final /*@Thrown\052/ boolean status = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation%>.INSTANCE.evaluate(evaluator, size, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.metamodel.MetamodelTables%>.STR_The_32_section_32_is_32_not_32_referenced_32_by_32_any_32_mapping_33;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_SourceSection_c_c_isReferencedByMapping, this, null, diagnostics, context, message_0, <%pamtram.metamodel.MetamodelTables%>.INT_2, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean isReferencedByMapping(DiagnosticChain diagnostics, Map<Object, Object> context);
} // SourceSection