/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;
import pamtram.mapping.MappingType;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.SourceSectionClass#getReferencingMappings <em>Referencing Mappings</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionClass()
 * @model
 * @generated
 */
public interface SourceSectionClass extends pamtram.metamodel.Class<SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {

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
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionClass_ReferencingMappings()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * \n * mapping::MappingType.allInstances()\n * ->select(m | m.sourceMMSection = self)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_mapping_c_c_MappingType_0 = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_MappingType, null);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.SetValue%> allInstances = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.metamodel.MetamodelTables%>.SET_CLSSid_MappingType, TYP_pamtram_c_c_mapping_c_c_MappingType_0));\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSetAccumulatorValue(<%pamtram.metamodel.MetamodelTables%>.SET_CLSSid_MappingType);\n/*@NonNull\052/ <%java.util.Iterator%><?> ITERATOR_m = allInstances.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> select;\nwhile (true) {\n    if (!ITERATOR_m.hasNext()) {\n        select = accumulator;\n        break;\n    }\n    /*@NonNull\052/ /*@NonInvalid\052/ <%pamtram.mapping.MappingType%> m = (<%pamtram.mapping.MappingType%>)ITERATOR_m.next();\n    /**\n     * m.sourceMMSection = self\n     \052/\n    final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.SourceSectionClass%> sourceMMSection = m.getSourceMMSection();\n    final /*@Thrown\052/ boolean eq = sourceMMSection.equals(this);\n    //\n    if (eq == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\n        accumulator.add(m);\n    }\n}\nfinal <%java.util.List%><<%pamtram.mapping.MappingType%>> UNBOXED_select = select.asEcoreObjects(idResolver, pamtram.mapping.MappingType.class);\nassert UNBOXED_select != null;\nreturn (<%org.eclipse.emf.common.util.EList<pamtram.mapping.MappingType>%>)UNBOXED_select;'"
	 * @generated
	 */
	EList<MappingType> getReferencingMappings();
	
	
} // SourceSectionClass
