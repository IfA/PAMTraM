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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='//TODO handle hierarchical extensions (an extended section extends other sections\r\n//TODO implement a more sophisticated merging strategy that takes into account overwriting of hints?\r\n\r\n/*\r\n * First, we collect each abstract source and target section as well as the concrete sections that\r\n * reference them\r\n \052/\r\nHashMap<Section, LinkedList<Section>> abstractToConcreteSectionMap = new HashMap<>();\r\nMap<EObject, Collection<Setting>> sourceSettings = EcoreUtil.CrossReferencer.find(getSourceSections());\r\nfor (Section section : getSourceSections()) {\r\n\tif(section.isAbstract()) {\r\n\t\tLinkedList<Section> concreteSections = new LinkedList<>();\r\n\t\tfor (Setting setting : sourceSettings.get(section)) {\r\n\t\t\tif(setting.getEStructuralFeature().equals(MetamodelPackageImpl.eINSTANCE.getSection_Extend())) {\r\n\t\t\t\tconcreteSections.add((Section) setting.getEObject());\r\n\t\t\t}\r\n\t\t}\r\n\t\tabstractToConcreteSectionMap.put(section, concreteSections);\r\n\t}\r\n}\r\nMap<EObject, Collection<Setting>> targetSettings = EcoreUtil.CrossReferencer.find(getTargetSections());\r\nfor (Section section : getTargetSections()) {\r\n\tif(section.isAbstract()) {\r\n\t\tLinkedList<Section> concreteSections = new LinkedList<>();\r\n\t\tfor (Setting setting : targetSettings.get(section)) {\r\n\t\t\tif(setting.getEStructuralFeature().equals(MetamodelPackageImpl.eINSTANCE.getSection_Extend())) {\r\n\t\t\t\tconcreteSections.add((Section) setting.getEObject());\r\n\t\t\t}\r\n\t\t}\r\n\t\tabstractToConcreteSectionMap.put(section, concreteSections);\r\n\t}\r\n}\r\n\r\n/*\r\n * Now, we copy all elements from the abstract sections to the concrete sections\r\n * that extend them. In this process, we store the associations between the elements from\r\n * the abstract sections and the copied elements in a map.\r\n \052/\r\nHashMap<EObject, LinkedList<EObject>> abstractToConcreteElementMap = new HashMap<>();\r\nfor (Section abstractSection : abstractToConcreteSectionMap.keySet()) {\r\n\tfor (Section concreteSection : abstractToConcreteSectionMap.get(abstractSection)) {\r\n\r\n\t\tSection copiedSection = EcoreUtil.copy(abstractSection);\r\n\r\n\t\tTreeIterator<EObject> originalIterator = EcoreUtil.getAllContents(Collections.singleton(abstractSection));\r\n\t\tTreeIterator<EObject> copyIterator = EcoreUtil.getAllContents(Collections.singleton(copiedSection));\r\n\r\n\t\t// these lists will store the elements that we will add to the concrete section\r\n\t\tArrayList<Attribute> attributesToAdd = new ArrayList<>();\r\n\t\tArrayList<Reference> referencesToAdd = new ArrayList<>();\r\n\r\n\t\twhile(originalIterator.hasNext()) {\r\n\t\t\tassert copyIterator.hasNext();\r\n\r\n\t\t\tEObject originalNext = originalIterator.next();\r\n\t\t\tEObject copyNext = copyIterator.next();\r\n\r\n\t\t\t// if the element is the section itself, we skip it\r\n\t\t\tif(originalNext instanceof Section) {\r\n\t\t\t\tcontinue;\r\n\t\t\t}\r\n\r\n\t\t\t// if the element is a top-level element below the section, we add it to the concrete section\r\n\t\t\tif(originalNext.eContainer().equals(abstractSection)) {\r\n\t\t\t\tif(copyNext instanceof Attribute) {\r\n\t\t\t\t\tattributesToAdd.add((Attribute) copyNext);\r\n\t\t\t\t} else if(copyNext instanceof Reference) {\r\n\t\t\t\t\treferencesToAdd.add((Reference) copyNext);\r\n\t\t\t\t} else {\r\n\t\t\t\t\tthrow new RuntimeException(\"Unsupported element type \'\" + copyNext.eClass().getName() + \"\' encountered when merging extends!\");\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t\t\t// in any case, we fill the abstractToConcreteElementMap\r\n\t\t\tLinkedList<EObject> vals = abstractToConcreteElementMap.get(originalNext);\r\n\t\t\tif(vals == null) {\r\n\t\t\t\tvals = new LinkedList<>();\r\n\t\t\t}\r\n\t\t\tvals.add(copyNext);\r\n\t\t\tabstractToConcreteElementMap.put(originalNext, vals);\r\n\r\n\t\t\t//TODO do we need to redirect references to these elements???\r\n\t\t}\r\n\r\n\t\t/*\r\n\t\t * now, we add the collected elements to the concrete section; we have to do this\r\n\t\t * after the process of iterating over the contents - otherwise, the TreeIterator will throw\r\n\t\t * IndexOutOfBoundsExceptions\r\n\t\t \052/\r\n\t\tconcreteSection.getAttributes().addAll(attributesToAdd);\r\n\t\tconcreteSection.getReferences().addAll(referencesToAdd);\r\n\r\n\r\n\t\t/*\r\n\t\t * Now, we redirect references from MappingHints to elements from the abstract section to the elements from the concrete sections. \r\n\t\t * Here, we only handle references from concrete mappings as the references from abstract mappings (and thus from extended hint\r\n\t\t * groups) are handled afterwards when these hint groups are copied.\r\n\t\t \052/\r\n\t\tArrayList<Mapping> concreteMappings = new ArrayList<>();\r\n\t\tfor (Mapping mapping : getMappings()) {\r\n\t\t\tif(!mapping.isAbstract()) {\r\n\t\t\t\tconcreteMappings.add(mapping);\r\n\t\t\t}\r\n\t\t}\r\n\t\tMap<EObject, Collection<Setting>> refsToAbstractSection = EcoreUtil.UsageCrossReferencer.findAll(abstractToConcreteElementMap.keySet(), concreteMappings);\r\n\t\tfor (EObject referencedObject : refsToAbstractSection.keySet()) {\r\n\t\t\tfor (Setting setting : refsToAbstractSection.get(referencedObject)) {\r\n\r\n\t\t\t\t// this is the element referencing the abstract section (it should be an element of a mapping hint)\r\n\t\t\t\tEObject hintElement = setting.getEObject().eContainer();\r\n\t\t\t\tMappingHintGroupType hintGroup = null;\r\n\t\t\t\tif(hintElement instanceof MappingHintGroupType) {\r\n\t\t\t\t\thintGroup = (MappingHintGroupType) hintElement;\r\n\t\t\t\t} else if(hintElement.eContainer() instanceof MappingHintGroupType) {\r\n\t\t\t\t\thintGroup = (MappingHintGroupType) hintElement.eContainer();\r\n\t\t\t\t} else {\r\n\t\t\t\t\thintGroup = (MappingHintGroupType) hintElement.eContainer().eContainer();\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// check if the hint group or its parent mapping equals the section that we just added the concrete elements to\r\n\t\t\t\tif(concreteSection.equals(hintGroup.getTargetMMSection()) || \r\n\t\t\t\t\t\tconcreteSection.isContainerFor(hintGroup.getTargetMMSection()) ||\r\n\t\t\t\t\t\tconcreteSection.equals(((Mapping) hintGroup.eContainer()).getSourceMMSection()) || \r\n\t\t\t\t\t\tconcreteSection.isContainerFor(((Mapping) hintGroup.eContainer()).getSourceMMSection())) {\r\n\r\n\t\t\t\t\t// redirect the reference (we can always use the \'last\' of the concrete objects as we just added it above\r\n\t\t\t\t\tsetting.set(abstractToConcreteElementMap.get(referencedObject).getLast());\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t}\r\n}\r\n\r\n/*\r\n * Finally, we can copy the abstract hint groups\r\n \052/\r\n\r\n// collect all abstract mappings\r\nArrayList<Mapping> abstractMappings = new ArrayList<>();\r\nfor (Mapping mapping : this.getMappings()) {\r\n\tif(mapping.isAbstract()) {\r\n\t\tabstractMappings.add(mapping);\r\n\t}\r\n}\r\n\r\n// collect each abstract hint group as well as the concrete hint groups that reference them\r\nHashMap<MappingHintGroupType, LinkedList<MappingHintGroupType>> abstractToConcreteHintGroupMap = new HashMap<>();\r\nMap<EObject, Collection<Setting>> mappingSettings = EcoreUtil.CrossReferencer.find(getMappings());\r\nfor (EObject element : mappingSettings.keySet()) {\r\n\tif(element instanceof MappingHintGroupType && ((Mapping)(element.eContainer())).isAbstract()) {\r\n\t\tLinkedList<MappingHintGroupType> concreteHintGroups = new LinkedList<>();\r\n\t\tfor (Setting setting : mappingSettings.get(element)) {\r\n\t\t\tif(setting.getEStructuralFeature().equals(MappingPackageImpl.eINSTANCE.getMappingHintGroupType_Extend())) {\r\n\t\t\t\tconcreteHintGroups.add((MappingHintGroupType) setting.getEObject());\r\n\t\t\t}\r\n\t\t}\r\n\t\tabstractToConcreteHintGroupMap.put((MappingHintGroupType) element, concreteHintGroups);\r\n\t}\r\n}\r\n\r\n// copy the hints to the concrete hint groups\r\nfor (MappingHintGroupType abstractHintGroup : abstractToConcreteHintGroupMap.keySet()) {\r\n\tfor (MappingHintGroupType concreteHintGroup : abstractToConcreteHintGroupMap.get(abstractHintGroup)) {\r\n\t\tCollection<MappingHintBaseType> hintsToCopy = new BasicEList<>();\r\n\t\thintsToCopy.addAll(abstractHintGroup.getMappingHints());\r\n\t\tif(abstractHintGroup instanceof MappingHintGroup) {\r\n\t\t\t// model connection hints need to be handled separately\r\n\t\t\thintsToCopy.add(((MappingHintGroup) abstractHintGroup).getModelConnectionMatcher());\r\n\t\t}\r\n\t\tCollection<MappingHintBaseType> copiedHints = EcoreUtil.copyAll(hintsToCopy);\r\n\r\n\t\t/* \r\n\t\t * make sure that all references to elements from the abstract sections are redirected to the concrete sections\r\n\t\t * that we created earlier\r\n\t\t \052/\r\n\t\tfor (MappingHintBaseType copiedHint : copiedHints) {\r\n\r\n\t\t\t/* \r\n\t\t\t * these are the references from the copied hint (that will get added to the concrete hint group) to elements from\r\n\t\t\t * abstract sections\r\n\t\t\t \052/\r\n\t\t\tMap<EObject, Collection<Setting>> refsToAbstractSection = EcoreUtil.UsageCrossReferencer.findAll(abstractToConcreteElementMap.keySet(), copiedHint);\r\n\t\t\tfor (EObject referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\t\t\t\t// these are possible targets for the redirection of references to the referenced object\r\n\t\t\t\tLinkedList<EObject> possibleTargets = abstractToConcreteElementMap.get(referencedObject);\r\n\r\n\t\t\t\tArrayList<Section> sourceAndTargetSections = new ArrayList<>();\r\n\t\t\t\t//TODO do we need to take other sections (e.g. container sections) into account???\r\n\t\t\t\tsourceAndTargetSections.add(((Mapping) concreteHintGroup.eContainer()).getSourceMMSection());\r\n\t\t\t\tsourceAndTargetSections.add(concreteHintGroup.getTargetMMSection());\r\n\r\n\t\t\t\tboolean found = false;\r\n\t\t\t\tEObject target = null; // this will contain the new value for the reference\r\n\t\t\t\tfor (EObject possibleTarget : possibleTargets) {\r\n\t\t\t\t\tSection containingSection = ((MetaModelElement) possibleTarget).getContainingSection();\r\n\t\t\t\t\tif(sourceAndTargetSections.contains(containingSection)) {\r\n\t\t\t\t\t\tif(found == false ) {\r\n\t\t\t\t\t\t\tfound = true;\r\n\t\t\t\t\t\t\ttarget = possibleTarget;\r\n\t\t\t\t\t\t} else {\r\n\t\t\t\t\t\t\t// this should not happen, should it?\r\n\t\t\t\t\t\t\tthrow new RuntimeException(\"Internal error! Multiple targets found for redirection of element \'\" + referencedObject + \"\' in.\");\r\n\t\t\t\t\t\t}\r\n\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t\tif(found == false) {\r\n\t\t\t\t\tthrow new RuntimeException(\"Internal error! Now target found for redirection of element \'\" + referencedObject + \"\'.\");\r\n\t\t\t\t}\r\n\r\n\t\t\t\tfor (Setting setting : refsToAbstractSection.get(referencedObject)) {\r\n\t\t\t\t\tsetting.set(target);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t\t}\r\n\r\n\t\t// Finally, we add the copied hints to the concrete hint group\r\n\t\tfor (MappingHintBaseType copiedHint : copiedHints) {\r\n\t\t\tif(copiedHint instanceof ModelConnectionHint) {\r\n\t\t\t\t((MappingHintGroup) concreteHintGroup).setModelConnectionMatcher((ModelConnectionHint) copiedHint);\t\r\n\t\t\t} else {\r\n\t\t\t\tconcreteHintGroup.getMappingHints().add((MappingHint) copiedHint);\t\t\t\t\t\r\n\t\t\t}\r\n\r\n\t\t}\r\n\t}\r\n}\r\n\r\n/*\r\n * At the end, we clear the values of the \'extend\' references of the concrete elements as these\r\n * are no longer needed.\r\n \052/\r\nfor (Entry<Section, LinkedList<Section>> entry : abstractToConcreteSectionMap.entrySet()) {\r\n\tfor (Section concreteSection : entry.getValue()) {\r\n\t\tconcreteSection.getExtend().remove(entry.getKey());\r\n\t}\r\n}\r\nfor (Entry<MappingHintGroupType, LinkedList<MappingHintGroupType>> entry : abstractToConcreteHintGroupMap.entrySet()) {\r\n\tfor (MappingHintGroupType concreteHintGroup : entry.getValue()) {\r\n\t\tconcreteHintGroup.getExtend().remove(entry.getKey());\r\n\t}\r\n}'"
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
