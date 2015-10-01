/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.GlobalValue;
import pamtram.mapping.Mapping;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSectionClass;

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
 * @model
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
	 * The list contents are of type {@link pamtram.metamodel.SourceSectionClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Sections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Sections</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_SourceSections()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * self.sourceSectionModel->collect(s | s.metaModelSections)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.SourceSectionModel%>> sourceSectionModel = this.getSourceSectionModel();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_sourceSectionModel = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_SourceSectionModel, sourceSectionModel);\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%pamtram.PamtramTables%>.SEQ_TMPLid_);\n/*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_s = BOXED_sourceSectionModel.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> collect;\nwhile (true) {\n    if (!ITERATOR_s.hasNext()) {\n        collect = accumulator;\n        break;\n    }\n    /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.SourceSectionModel%> s = (<%pamtram.SourceSectionModel%>)ITERATOR_s.next();\n    /**\n     * s.metaModelSections\n     \052/\n    if (s == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://mfreund.de/pamtram\\\'::SectionModel::metaModelSections\\\'\");\n    }\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><? extends <%java.lang.Object%>> metaModelSections = s.getMetaModelSections();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_metaModelSections = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_TMPLid_, metaModelSections);\n    //\n    for (Object value : BOXED_metaModelSections.flatten().getElements()) {\n        accumulator.add(value);\n    }\n}\nfinal <%java.util.List%><? extends <%java.lang.Object%>> UNBOXED_collect = collect.asEcoreObjects(idResolver, <%java.lang.Object%>.class);\nassert UNBOXED_collect != null;\nreturn (<%org.eclipse.emf.common.util.EList<pamtram.metamodel.SourceSectionClass>%>)UNBOXED_collect;'"
	 * @generated
	 */
	EList<SourceSectionClass> getSourceSections();

	/**
	 * Returns the value of the '<em><b>Target Sections</b></em>' reference list.
	 * The list contents are of type {@link pamtram.metamodel.TargetSectionClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Sections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Sections</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_TargetSections()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * self.targetSectionModel->collect(s | s.metaModelSections)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.TargetSectionModel%>> targetSectionModel = this.getTargetSectionModel();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_targetSectionModel = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_TargetSectionModel, targetSectionModel);\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%pamtram.PamtramTables%>.SEQ_TMPLid_);\n/*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_s = BOXED_targetSectionModel.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> collect;\nwhile (true) {\n    if (!ITERATOR_s.hasNext()) {\n        collect = accumulator;\n        break;\n    }\n    /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.TargetSectionModel%> s = (<%pamtram.TargetSectionModel%>)ITERATOR_s.next();\n    /**\n     * s.metaModelSections\n     \052/\n    if (s == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://mfreund.de/pamtram\\\'::SectionModel::metaModelSections\\\'\");\n    }\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><? extends <%java.lang.Object%>> metaModelSections = s.getMetaModelSections();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_metaModelSections = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_TMPLid_, metaModelSections);\n    //\n    for (Object value : BOXED_metaModelSections.flatten().getElements()) {\n        accumulator.add(value);\n    }\n}\nfinal <%java.util.List%><? extends <%java.lang.Object%>> UNBOXED_collect = collect.asEcoreObjects(idResolver, <%java.lang.Object%>.class);\nassert UNBOXED_collect != null;\nreturn (<%org.eclipse.emf.common.util.EList<pamtram.metamodel.TargetSectionClass>%>)UNBOXED_collect;'"
	 * @generated
	 */
	EList<TargetSectionClass> getTargetSections();

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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * \n * self.mappingModel->collect(s | s.mapping)\n * ->select(m | m.deactivated = false)\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.MappingModel%>> mappingModel = this.getMappingModel();\nfinal /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_mappingModel = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_MappingModel, mappingModel);\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%pamtram.PamtramTables%>.SEQ_CLSSid_Mapping);\n/*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_s = BOXED_mappingModel.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> collect;\nwhile (true) {\n    if (!ITERATOR_s.hasNext()) {\n        collect = accumulator;\n        break;\n    }\n    /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.MappingModel%> s = (<%pamtram.MappingModel%>)ITERATOR_s.next();\n    /**\n     * s.mapping\n     \052/\n    if (s == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://mfreund.de/pamtram\\\'::MappingModel::mapping\\\'\");\n    }\n    final /*@NonNull\052/ /*@Thrown\052/ <%java.util.List%><<%pamtram.mapping.Mapping%>> mapping = s.getMapping();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_mapping = idResolver.createOrderedSetOfAll(<%pamtram.PamtramTables%>.ORD_CLSSid_Mapping, mapping);\n    //\n    for (Object value : BOXED_mapping.flatten().getElements()) {\n        accumulator.add(value);\n    }\n}\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.Accumulator accumulator_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%pamtram.PamtramTables%>.SEQ_CLSSid_Mapping);\n/*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_m = collect.iterator();\n/*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> select;\nwhile (true) {\n    if (!ITERATOR_m.hasNext()) {\n        select = accumulator_0;\n        break;\n    }\n    /*@Nullable\052/ /*@NonInvalid\052/ <%pamtram.mapping.Mapping%> m = (<%pamtram.mapping.Mapping%>)ITERATOR_m.next();\n    /**\n     * m.deactivated = false\n     \052/\n    if (m == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://mfreund.de/pamtram\\\'::DeactivatableElement::deactivated\\\'\");\n    }\n    final /*@Thrown\052/ boolean deactivated = m.isDeactivated();\n    final /*@Thrown\052/ boolean eq = !deactivated;\n    //\n    if (eq == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\n        accumulator_0.add(m);\n    }\n}\nfinal <%java.util.List%><<%pamtram.mapping.Mapping%>> UNBOXED_select = select.asEcoreObjects(idResolver, pamtram.mapping.Mapping.class);\nassert UNBOXED_select != null;\nreturn (<%org.eclipse.emf.common.util.EList<pamtram.mapping.Mapping>%>)UNBOXED_select;'"
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

} // PAMTraM
