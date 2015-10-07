/**
 */
package pamtram;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.GlobalValue;
import pamtram.mapping.Mapping;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.TargetSection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PAM Tra M</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.PAMTraM#getContextMetaModelPackage <em>Context Meta Model Package</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getSourceSectionModel <em>Source Section Model</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getTargetSectionModel <em>Target Section Model</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getMappingModel <em>Mapping Model</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getTransformationModel <em>Transformation Model</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getSourceSections <em>Source Sections</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getTargetSections <em>Target Sections</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getMappings <em>Mappings</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getActiveMappings <em>Active Mappings</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getGlobalValues <em>Global Values</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getModifierSets <em>Modifier Sets</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getPAMTraM()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceSectionModelsHaveSameEPackage targetSectionModelsHaveSameEPackage'"
 * @generated
 */
public interface PAMTraM extends EObject {
	/**
	 * Returns the value of the '<em><b>Context Meta Model Package</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Meta Model Package</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Meta Model Package</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_ContextMetaModelPackage()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram!PAMTraM!contextMetaModelPackage'"
	 * @generated
	 */
	EList<EPackage> getContextMetaModelPackage();

	/**
	 * Returns the value of the '<em><b>Source Section Model</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.SourceSectionModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Section Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Section Model</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_SourceSectionModel()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram!PAMTraM!sourceSectionModel'"
	 * @generated
	 */
	EList<SourceSectionModel> getSourceSectionModel();

	/**
	 * Returns the value of the '<em><b>Target Section Model</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.TargetSectionModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Section Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Section Model</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_TargetSectionModel()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram!PAMTraM!targetSectionModel'"
	 * @generated
	 */
	EList<TargetSectionModel> getTargetSectionModel();

	/**
	 * Returns the value of the '<em><b>Mapping Model</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.MappingModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Model</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_MappingModel()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram!PAMTraM!mappingModel'"
	 * @generated
	 */
	EList<MappingModel> getMappingModel();

	/**
	 * Returns the value of the '<em><b>Transformation Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation Model</em>' containment reference.
	 * @see #setTransformationModel(TransformationModel)
	 * @see pamtram.PamtramPackage#getPAMTraM_TransformationModel()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram!PAMTraM!transformationModel'"
	 * @generated
	 */
	TransformationModel getTransformationModel();

	/**
	 * Sets the value of the '{@link pamtram.PAMTraM#getTransformationModel <em>Transformation Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation Model</em>' containment reference.
	 * @see #getTransformationModel()
	 * @generated
	 */
	void setTransformationModel(TransformationModel value);

	/**
	 * Returns the value of the '<em><b>Source Sections</b></em>' reference list.
	 * The list contents are of type {@link pamtram.metamodel.SourceSection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Sections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Sections</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_SourceSections()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * self.sourceSectionModel->collect(s | s.metaModelSections)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.SourceSectionModel%>> sourceSectionModel = this.getSourceSectionModel();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_sourceSectionModel = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_SourceSectionModel, sourceSectionModel);\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%pamtram.PamtramTables%>.SEQ_TMPLid_);\n/*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_s = BOXED_sourceSectionModel.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> collect;\nwhile (true) {\n    if (!ITERATOR_s.hasNext()) {\n        collect = accumulator;\n        break;\n    }\n    /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.SourceSectionModel%> s = (<%pamtram.SourceSectionModel%>)ITERATOR_s.next();\n    /**\n     * s.metaModelSections\n     \052/\n    if (s == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://mfreund.de/pamtram\\\'::SectionModel::metaModelSections\\\'\");\n    }\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><? extends <%java.lang.Object%>> metaModelSections = s.getMetaModelSections();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_metaModelSections = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_TMPLid_, metaModelSections);\n    //\n    for (Object value : BOXED_metaModelSections.flatten().getElements()) {\n        accumulator.add(value);\n    }\n}\nfinal <%java.util.List%><? extends <%java.lang.Object%>> UNBOXED_collect = collect.asEcoreObjects(idResolver, <%java.lang.Object%>.class);\nassert UNBOXED_collect != null;\nreturn (<%org.eclipse.emf.common.util.EList<pamtram.metamodel.SourceSection>%>)UNBOXED_collect;'"
	 * @generated
	 */
	EList<SourceSection> getSourceSections();

	/**
	 * Returns the value of the '<em><b>Target Sections</b></em>' reference list.
	 * The list contents are of type {@link pamtram.metamodel.TargetSection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Sections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Sections</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_TargetSections()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * self.targetSectionModel->collect(s | s.metaModelSections)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.TargetSectionModel%>> targetSectionModel = this.getTargetSectionModel();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_targetSectionModel = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_TargetSectionModel, targetSectionModel);\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%pamtram.PamtramTables%>.SEQ_TMPLid_);\n/*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_s = BOXED_targetSectionModel.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> collect;\nwhile (true) {\n    if (!ITERATOR_s.hasNext()) {\n        collect = accumulator;\n        break;\n    }\n    /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.TargetSectionModel%> s = (<%pamtram.TargetSectionModel%>)ITERATOR_s.next();\n    /**\n     * s.metaModelSections\n     \052/\n    if (s == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://mfreund.de/pamtram\\\'::SectionModel::metaModelSections\\\'\");\n    }\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><? extends <%java.lang.Object%>> metaModelSections = s.getMetaModelSections();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_metaModelSections = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_TMPLid_, metaModelSections);\n    //\n    for (Object value : BOXED_metaModelSections.flatten().getElements()) {\n        accumulator.add(value);\n    }\n}\nfinal <%java.util.List%><? extends <%java.lang.Object%>> UNBOXED_collect = collect.asEcoreObjects(idResolver, <%java.lang.Object%>.class);\nassert UNBOXED_collect != null;\nreturn (<%org.eclipse.emf.common.util.EList<pamtram.metamodel.TargetSection>%>)UNBOXED_collect;'"
	 * @generated
	 */
	EList<TargetSection> getTargetSections();

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_Mappings()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * self.mappingModel->collect(s | s.mapping)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.MappingModel%>> mappingModel = this.getMappingModel();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_mappingModel = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_MappingModel, mappingModel);\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%pamtram.PamtramTables%>.SEQ_CLSSid_Mapping);\n/*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_s = BOXED_mappingModel.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> collect;\nwhile (true) {\n    if (!ITERATOR_s.hasNext()) {\n        collect = accumulator;\n        break;\n    }\n    /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.MappingModel%> s = (<%pamtram.MappingModel%>)ITERATOR_s.next();\n    /**\n     * s.mapping\n     \052/\n    if (s == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://mfreund.de/pamtram\\\'::MappingModel::mapping\\\'\");\n    }\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.mapping.Mapping%>> mapping = s.getMapping();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_mapping = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_Mapping, mapping);\n    //\n    for (Object value : BOXED_mapping.flatten().getElements()) {\n        accumulator.add(value);\n    }\n}\nfinal <%java.util.List%><<%pamtram.mapping.Mapping%>> UNBOXED_collect = collect.asEcoreObjects(idResolver, pamtram.mapping.Mapping.class);\nassert UNBOXED_collect != null;\nreturn (<%org.eclipse.emf.common.util.EList<pamtram.mapping.Mapping>%>)UNBOXED_collect;'"
	 * @generated
	 */
	EList<Mapping> getMappings();

	/**
	 * Returns the value of the '<em><b>Active Mappings</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Mappings</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_ActiveMappings()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * self.mappingModel->collect(m | m.getActiveMappings())\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.MappingModel%>> mappingModel = this.getMappingModel();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_mappingModel = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_MappingModel, mappingModel);\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%pamtram.PamtramTables%>.SEQ_CLSSid_Mapping);\n/*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_m = BOXED_mappingModel.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> collect;\nwhile (true) {\n    if (!ITERATOR_m.hasNext()) {\n        collect = accumulator;\n        break;\n    }\n    /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.MappingModel%> m = (<%pamtram.MappingModel%>)ITERATOR_m.next();\n    /**\n     * m.getActiveMappings()\n     \052/\n    if (m == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'pamtram::MappingModel::getActiveMappings() : OrderedSet(pamtram::mapping::Mapping)\\\'\");\n    }\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.mapping.Mapping%>> getActiveMappings = m.getActiveMappings();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_getActiveMappings = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_Mapping, getActiveMappings);\n    //\n    for (Object value : BOXED_getActiveMappings.flatten().getElements()) {\n        accumulator.add(value);\n    }\n}\nfinal <%java.util.List%><<%pamtram.mapping.Mapping%>> UNBOXED_collect = collect.asEcoreObjects(idResolver, pamtram.mapping.Mapping.class);\nassert UNBOXED_collect != null;\nreturn (<%org.eclipse.emf.common.util.EList<pamtram.mapping.Mapping>%>)UNBOXED_collect;'"
	 * @generated
	 */
	EList<Mapping> getActiveMappings();

	/**
	 * Returns the value of the '<em><b>Global Values</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.GlobalValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Values</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_GlobalValues()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * self.mappingModel->collect(s | s.globalValues)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.MappingModel%>> mappingModel = this.getMappingModel();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_mappingModel = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_MappingModel, mappingModel);\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%pamtram.PamtramTables%>.SEQ_CLSSid_GlobalValue);\n/*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_s = BOXED_mappingModel.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> collect;\nwhile (true) {\n    if (!ITERATOR_s.hasNext()) {\n        collect = accumulator;\n        break;\n    }\n    /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.MappingModel%> s = (<%pamtram.MappingModel%>)ITERATOR_s.next();\n    /**\n     * s.globalValues\n     \052/\n    if (s == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://mfreund.de/pamtram\\\'::MappingModel::globalValues\\\'\");\n    }\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.mapping.GlobalValue%>> globalValues = s.getGlobalValues();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_globalValues = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_GlobalValue, globalValues);\n    //\n    for (Object value : BOXED_globalValues.flatten().getElements()) {\n        accumulator.add(value);\n    }\n}\nfinal <%java.util.List%><<%pamtram.mapping.GlobalValue%>> UNBOXED_collect = collect.asEcoreObjects(idResolver, pamtram.mapping.GlobalValue.class);\nassert UNBOXED_collect != null;\nreturn (<%org.eclipse.emf.common.util.EList<pamtram.mapping.GlobalValue>%>)UNBOXED_collect;'"
	 * @generated
	 */
	EList<GlobalValue> getGlobalValues();

	/**
	 * Returns the value of the '<em><b>Modifier Sets</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.AttributeValueModifierSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier Sets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier Sets</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_ModifierSets()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * self.mappingModel->collect(s | s.modifierSets)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.MappingModel%>> mappingModel = this.getMappingModel();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_mappingModel = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_MappingModel, mappingModel);\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%pamtram.PamtramTables%>.SEQ_CLSSid_AttributeValueModifierSet);\n/*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_s = BOXED_mappingModel.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> collect;\nwhile (true) {\n    if (!ITERATOR_s.hasNext()) {\n        collect = accumulator;\n        break;\n    }\n    /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.MappingModel%> s = (<%pamtram.MappingModel%>)ITERATOR_s.next();\n    /**\n     * s.modifierSets\n     \052/\n    if (s == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://mfreund.de/pamtram\\\'::MappingModel::modifierSets\\\'\");\n    }\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.mapping.AttributeValueModifierSet%>> modifierSets = s.getModifierSets();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_modifierSets = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_AttributeValueModifierSet, modifierSets);\n    //\n    for (Object value : BOXED_modifierSets.flatten().getElements()) {\n        accumulator.add(value);\n    }\n}\nfinal <%java.util.List%><<%pamtram.mapping.AttributeValueModifierSet%>> UNBOXED_collect = collect.asEcoreObjects(idResolver, pamtram.mapping.AttributeValueModifierSet.class);\nassert UNBOXED_collect != null;\nreturn (<%org.eclipse.emf.common.util.EList<pamtram.mapping.AttributeValueModifierSet>%>)UNBOXED_collect;'"
	 * @generated
	 */
	EList<AttributeValueModifierSet> getModifierSets();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n//TODO handle hierarchical extensions (an extended section extends other sections\r\n//TODO implement a more sophisticated merging strategy that takes into account overwriting of hints?\r\n\r\nfor (Mapping mapping : getMappings()) {\r\n\r\n\t/*\r\n\t * First, we created a self-contaied copy of every extended mapping hint gruop, source section and \r\n\t * target section so that we do not mess up with other mappings that extend those elements.\r\n\t \052/\r\n\tBasicEList<MappingHintGroupType> extendedMappingHintGroups = new BasicEList<>();\r\n\tUniqueEList<SourceSection> sourceSectionOfExtendedMappings = new UniqueEList<>();\r\n\tUniqueEList<TargetSection> targetSectionOfExtendedMappings = new UniqueEList<>();\r\n\r\n\tfor (MappingHintGroupType hintGroup : mapping.getMappingHintGroups()) {\r\n\t\tfor (MappingHintGroupType extend : hintGroup.getExtend()) {\r\n\t\t\textendedMappingHintGroups.add(extend);\r\n\t\t\tsourceSectionOfExtendedMappings.add(((Mapping) extend.eContainer()).getSourceMMSection());\r\n\t\t\ttargetSectionOfExtendedMappings.add(extend.getTargetMMSection());\r\n\t\t}\r\n\t}\r\n\r\n\tEList<EObject> objectsToCopy = new BasicEList<>();\r\n\tobjectsToCopy.addAll(extendedMappingHintGroups);\r\n\tobjectsToCopy.addAll(sourceSectionOfExtendedMappings);\r\n\tobjectsToCopy.addAll(targetSectionOfExtendedMappings);\r\n\r\n\tCollection<EObject> copiedObject = EcoreUtil.copyAll(objectsToCopy);\r\n\r\n\tBasicEList<MappingHintGroupType> extendedMappingHintGroupsCopy = new BasicEList<>();\r\n\tUniqueEList<SourceSection> sourceSectionOfExtendedMappingsCopy = new UniqueEList<>();\r\n\tUniqueEList<TargetSection> targetSectionOfExtendedMappingsCopy = new UniqueEList<>();\r\n\r\n\tIterator<EObject> it = copiedObject.iterator();\r\n\tfor (int i = 0; i < extendedMappingHintGroups.size(); i++) {\r\n\t\textendedMappingHintGroupsCopy.add((MappingHintGroupType) it.next());\r\n\t}\r\n\tfor (int i = 0; i < sourceSectionOfExtendedMappings.size(); i++) {\r\n\t\tsourceSectionOfExtendedMappingsCopy.add((SourceSection) it.next());\r\n\t}\r\n\tfor (int i = 0; i < targetSectionOfExtendedMappings.size(); i++) {\r\n\t\ttargetSectionOfExtendedMappingsCopy.add((TargetSection) it.next());\r\n\t}\r\n\r\n\t/*\r\n\t * First, we need to merge each HintGroup with those HintGroups that it extends\r\n\t \052/\r\n\tfor (MappingHintGroupType hintGroup : mapping.getMappingHintGroups()) {\r\n\t\tfor (MappingHintGroupType extend : hintGroup.getExtend()) {\r\n\t\t\t/*\r\n\t\t\t *  we can always take the first hint group without any further checking because we iterate in the same\r\n\t\t\t *  order as above\r\n\t\t\t \052/\r\n\t\t\thintGroup.getMappingHints().addAll(extendedMappingHintGroupsCopy.remove(0).getMappingHints());\r\n\t\t\t/*\r\n\t\t\t * The same is for the target sections of the hint groups\r\n\t\t\t \052/\r\n\t\t\tTargetSection copy = targetSectionOfExtendedMappingsCopy.remove(0);\r\n\t\t\thintGroup.getTargetMMSection().getAttributes().addAll(copy.getAttributes());\r\n\t\t\thintGroup.getTargetMMSection().getReferences().addAll(copy.getReferences());\r\n\t\t}\r\n\t}\r\n\tassert extendedMappingHintGroups.isEmpty();\r\n\r\n\t/*\r\n\t * Now, we merge all SourceSections.\r\n\t \052/\r\n\tfor (SourceSection sourceSection : sourceSectionOfExtendedMappingsCopy) {\r\n\t\t//Therefore, we first merge all attributes...\r\n\t\tmapping.getSourceMMSection().getAttributes().addAll(sourceSection.getAttributes());\r\n\t\t// ...and then all references.\r\n\t\tmapping.getSourceMMSection().getReferences().addAll(sourceSection.getReferences());\r\n\t}\r\n}'"
	 * @generated
	 */
	void mergeExtends();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv sourceSectionModelsHaveSameEPackage:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = self.sourceSectionModel->collect(s | s.metaModelPackage)\n *       ->asSet()\n *       ->size() <= 1\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'Not all SourceSectionModels specify the same EPackage. This is currently not supported!\'\n *         else null\n *         endif\n *       in\n *         \'PAMTraM::sourceSectionModelsHaveSameEPackage\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n/*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.SourceSectionModel%>> sourceSectionModel = this.getSourceSectionModel();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_sourceSectionModel = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_SourceSectionModel, sourceSectionModel);\n    /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%pamtram.PamtramTables%>.SEQ_CLSSid_EPackage);\n    /*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_s = BOXED_sourceSectionModel.iterator();\n    /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> collect;\n    while (true) {\n        if (!ITERATOR_s.hasNext()) {\n            collect = accumulator;\n            break;\n        }\n        /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.SourceSectionModel%> s = (<%pamtram.SourceSectionModel%>)ITERATOR_s.next();\n        /**\n         * s.metaModelPackage\n         \052/\n        if (s == null) {\n            throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://mfreund.de/pamtram\\\'::SectionModel::metaModelPackage\\\'\");\n        }\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EPackage%> metaModelPackage = s.getMetaModelPackage();\n        //\n        accumulator.add(metaModelPackage);\n    }\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> asSet = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation%>.INSTANCE.evaluate(collect));\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(asSet));\n    final /*@Thrown\052/ boolean status = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, size, <%pamtram.PamtramTables%>.INT_1).booleanValue());\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.PamtramTables%>.STR_Not_32_all_32_SourceSectionModels_32_specify_32_the_32_same_32_EPackage_32_This_32_is_32_c;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.PamtramTables%>.STR_PAMTraM_c_c_sourceSectionModelsHaveSameEPackage, this, null, diagnostics, context, message_0, <%pamtram.PamtramTables%>.INT_4, CAUGHT_status, <%pamtram.PamtramTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean sourceSectionModelsHaveSameEPackage(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv targetSectionModelsHaveSameEPackage:\n *   let severity : Integer[1] = 4\n *   in\n *     let\n *       status : OclAny[1] = self.targetSectionModel->collect(s | s.metaModelPackage)\n *       ->asSet()\n *       ->size() <= 1\n *     in\n *       let\n *         message : String[?] = if status <> true\n *         then \'Not all TargetSectionModels specify the same EPackage. This is currently not supported!\'\n *         else null\n *         endif\n *       in\n *         \'PAMTraM::targetSectionModelsHaveSameEPackage\'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n/*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\ntry {\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.TargetSectionModel%>> targetSectionModel = this.getTargetSectionModel();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_targetSectionModel = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_TargetSectionModel, targetSectionModel);\n    /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%pamtram.PamtramTables%>.SEQ_CLSSid_EPackage);\n    /*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_s = BOXED_targetSectionModel.iterator();\n    /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> collect;\n    while (true) {\n        if (!ITERATOR_s.hasNext()) {\n            collect = accumulator;\n            break;\n        }\n        /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.TargetSectionModel%> s = (<%pamtram.TargetSectionModel%>)ITERATOR_s.next();\n        /**\n         * s.metaModelPackage\n         \052/\n        if (s == null) {\n            throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://mfreund.de/pamtram\\\'::SectionModel::metaModelPackage\\\'\");\n        }\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EPackage%> metaModelPackage = s.getMetaModelPackage();\n        //\n        accumulator.add(metaModelPackage);\n    }\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> asSet = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation%>.INSTANCE.evaluate(collect));\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(asSet));\n    final /*@Thrown\052/ boolean status = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, size, <%pamtram.PamtramTables%>.INT_1).booleanValue());\n    CAUGHT_status = status;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_status instanceof <%org.eclipse.ocl.pivot.values.InvalidValueException%>) {\n    throw (<%org.eclipse.ocl.pivot.values.InvalidValueException%>)CAUGHT_status;\n}\nfinal /*@Thrown\052/ boolean ne = CAUGHT_status == Boolean.FALSE;\n/*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.String%> message_0;\nif (ne) {\n    message_0 = <%pamtram.PamtramTables%>.STR_Not_32_all_32_TargetSectionModels_32_specify_32_the_32_same_32_EPackage_32_This_32_is_32_c;\n}\nelse {\n    message_0 = null;\n}\nfinal /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.PamtramTables%>.STR_PAMTraM_c_c_targetSectionModelsHaveSameEPackage, this, null, diagnostics, context, message_0, <%pamtram.PamtramTables%>.INT_4, CAUGHT_status, <%pamtram.PamtramTables%>.INT_0).booleanValue());\nreturn Boolean.TRUE == logDiagnostic;'"
	 * @generated
	 */
	boolean targetSectionModelsHaveSameEPackage(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PAMTraM
