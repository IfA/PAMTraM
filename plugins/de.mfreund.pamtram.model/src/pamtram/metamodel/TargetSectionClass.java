/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;
import pamtram.mapping.MappingHintGroupType;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Section Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.TargetSectionClass#getReferencingMappingHintGroups <em>Referencing Mapping Hint Groups</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getTargetSectionClass()
 * @model
 * @generated
 */
public interface TargetSectionClass extends pamtram.metamodel.Class<TargetSectionClass, TargetSectionReference, TargetSectionAttribute> {

	/**
	 * Returns the value of the '<em><b>Referencing Mapping Hint Groups</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHintGroupType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referencing Mapping Hint Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referencing Mapping Hint Groups</em>' reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getTargetSectionClass_ReferencingMappingHintGroups()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * \n * mapping::MappingHintGroupType.allInstances()\n * ->select(mhg | mhg.targetMMSection = self)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0 = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_MappingHintGroupType, null);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.SetValue%> allInstances = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.metamodel.MetamodelTables%>.SET_CLSSid_MappingHintGroupType, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0));\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSetAccumulatorValue(<%pamtram.metamodel.MetamodelTables%>.SET_CLSSid_MappingHintGroupType);\n/*@NonNull\052/ <%java.util.Iterator%><?> ITERATOR_mhg = allInstances.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> select;\nwhile (true) {\n    if (!ITERATOR_mhg.hasNext()) {\n        select = accumulator;\n        break;\n    }\n    /*@NonNull\052/ /*@NonInvalid\052/ <%pamtram.mapping.MappingHintGroupType%> mhg = (<%pamtram.mapping.MappingHintGroupType%>)ITERATOR_mhg.next();\n    /**\n     * mhg.targetMMSection = self\n     \052/\n    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.TargetSectionClass%> targetMMSection = mhg.getTargetMMSection();\n    final /*@Thrown\052/ boolean eq = targetMMSection.equals(this);\n    //\n    if (eq == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\n        accumulator.add(mhg);\n    }\n}\nfinal <%java.util.List%><<%pamtram.mapping.MappingHintGroupType%>> UNBOXED_select = select.asEcoreObjects(idResolver, pamtram.mapping.MappingHintGroupType.class);\nassert UNBOXED_select != null;\nreturn (<%org.eclipse.emf.common.util.EList<pamtram.mapping.MappingHintGroupType>%>)UNBOXED_select;'"
	 * @generated
	 */
	EList<MappingHintGroupType> getReferencingMappingHintGroups();
} // TargetSectionClass
