/**
 */
package pamtram;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see pamtram.PamtramFactory
 * @model kind="package"
 * @generated
 */
public interface PamtramPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pamtram";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mfreund.de/pamtram";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pamtram";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PamtramPackage eINSTANCE = pamtram.impl.PamtramPackageImpl.init();

	/**
	 * The meta object id for the '{@link pamtram.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.NamedElementImpl
	 * @see pamtram.impl.PamtramPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link pamtram.impl.PAMTraMImpl <em>PAM Tra M</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.PAMTraMImpl
	 * @see pamtram.impl.PamtramPackageImpl#getPAMTraM()
	 * @generated
	 */
	int PAM_TRA_M = 1;

	/**
	 * The feature id for the '<em><b>Context Meta Model Package</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Source Section Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__SOURCE_SECTION_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Target Section Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__TARGET_SECTION_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Mapping Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__MAPPING_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Transformation Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__TRANSFORMATION_MODEL = 4;

	/**
	 * The number of structural features of the '<em>PAM Tra M</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>PAM Tra M</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link pamtram.impl.SectionModelImpl <em>Section Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.SectionModelImpl
	 * @see pamtram.impl.PamtramPackageImpl#getSectionModel()
	 * @generated
	 */
	int SECTION_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Meta Model Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_MODEL__META_MODEL_PACKAGE = 0;

	/**
	 * The number of structural features of the '<em>Section Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Section Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link pamtram.impl.SourceSectionModelImpl <em>Source Section Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.SourceSectionModelImpl
	 * @see pamtram.impl.PamtramPackageImpl#getSourceSectionModel()
	 * @generated
	 */
	int SOURCE_SECTION_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Meta Model Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_MODEL__META_MODEL_PACKAGE = SECTION_MODEL__META_MODEL_PACKAGE;

	/**
	 * The feature id for the '<em><b>Meta Model Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_MODEL__META_MODEL_SECTIONS = SECTION_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Source Section Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_MODEL_FEATURE_COUNT = SECTION_MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Source Section Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_MODEL_OPERATION_COUNT = SECTION_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.impl.TargetSectionModelImpl <em>Target Section Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.TargetSectionModelImpl
	 * @see pamtram.impl.PamtramPackageImpl#getTargetSectionModel()
	 * @generated
	 */
	int TARGET_SECTION_MODEL = 4;

	/**
	 * The feature id for the '<em><b>Meta Model Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_MODEL__META_MODEL_PACKAGE = SECTION_MODEL__META_MODEL_PACKAGE;

	/**
	 * The feature id for the '<em><b>Meta Model Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_MODEL__META_MODEL_SECTIONS = SECTION_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Target Section Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_MODEL_FEATURE_COUNT = SECTION_MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Target Section Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_MODEL_OPERATION_COUNT = SECTION_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.impl.MappingModelImpl <em>Mapping Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.MappingModelImpl
	 * @see pamtram.impl.PamtramPackageImpl#getMappingModel()
	 * @generated
	 */
	int MAPPING_MODEL = 5;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__MAPPING = 0;

	/**
	 * The feature id for the '<em><b>Modifier Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__MODIFIER_SETS = 1;

	/**
	 * The feature id for the '<em><b>Global Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__GLOBAL_VALUES = 2;

	/**
	 * The number of structural features of the '<em>Mapping Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Mapping Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link pamtram.impl.TransformationModelImpl <em>Transformation Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.TransformationModelImpl
	 * @see pamtram.impl.PamtramPackageImpl#getTransformationModel()
	 * @generated
	 */
	int TRANSFORMATION_MODEL = 6;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MODEL__TRANSFORMATION = 0;

	/**
	 * The number of structural features of the '<em>Transformation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Transformation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MODEL_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link pamtram.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see pamtram.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see pamtram.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link pamtram.PAMTraM <em>PAM Tra M</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PAM Tra M</em>'.
	 * @see pamtram.PAMTraM
	 * @generated
	 */
	EClass getPAMTraM();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.PAMTraM#getContextMetaModelPackage <em>Context Meta Model Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Context Meta Model Package</em>'.
	 * @see pamtram.PAMTraM#getContextMetaModelPackage()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_ContextMetaModelPackage();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.PAMTraM#getSourceSectionModel <em>Source Section Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source Section Model</em>'.
	 * @see pamtram.PAMTraM#getSourceSectionModel()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_SourceSectionModel();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.PAMTraM#getTargetSectionModel <em>Target Section Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Section Model</em>'.
	 * @see pamtram.PAMTraM#getTargetSectionModel()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_TargetSectionModel();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.PAMTraM#getMappingModel <em>Mapping Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Model</em>'.
	 * @see pamtram.PAMTraM#getMappingModel()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_MappingModel();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.PAMTraM#getTransformationModel <em>Transformation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transformation Model</em>'.
	 * @see pamtram.PAMTraM#getTransformationModel()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_TransformationModel();

	/**
	 * Returns the meta object for class '{@link pamtram.SectionModel <em>Section Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Model</em>'.
	 * @see pamtram.SectionModel
	 * @generated
	 */
	EClass getSectionModel();

	/**
	 * Returns the meta object for the reference '{@link pamtram.SectionModel#getMetaModelPackage <em>Meta Model Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Meta Model Package</em>'.
	 * @see pamtram.SectionModel#getMetaModelPackage()
	 * @see #getSectionModel()
	 * @generated
	 */
	EReference getSectionModel_MetaModelPackage();

	/**
	 * Returns the meta object for class '{@link pamtram.SourceSectionModel <em>Source Section Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Section Model</em>'.
	 * @see pamtram.SourceSectionModel
	 * @generated
	 */
	EClass getSourceSectionModel();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.SourceSectionModel#getMetaModelSections <em>Meta Model Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Meta Model Sections</em>'.
	 * @see pamtram.SourceSectionModel#getMetaModelSections()
	 * @see #getSourceSectionModel()
	 * @generated
	 */
	EReference getSourceSectionModel_MetaModelSections();

	/**
	 * Returns the meta object for class '{@link pamtram.TargetSectionModel <em>Target Section Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Section Model</em>'.
	 * @see pamtram.TargetSectionModel
	 * @generated
	 */
	EClass getTargetSectionModel();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.TargetSectionModel#getMetaModelSections <em>Meta Model Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Meta Model Sections</em>'.
	 * @see pamtram.TargetSectionModel#getMetaModelSections()
	 * @see #getTargetSectionModel()
	 * @generated
	 */
	EReference getTargetSectionModel_MetaModelSections();

	/**
	 * Returns the meta object for class '{@link pamtram.MappingModel <em>Mapping Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Model</em>'.
	 * @see pamtram.MappingModel
	 * @generated
	 */
	EClass getMappingModel();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.MappingModel#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping</em>'.
	 * @see pamtram.MappingModel#getMapping()
	 * @see #getMappingModel()
	 * @generated
	 */
	EReference getMappingModel_Mapping();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.MappingModel#getModifierSets <em>Modifier Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Modifier Sets</em>'.
	 * @see pamtram.MappingModel#getModifierSets()
	 * @see #getMappingModel()
	 * @generated
	 */
	EReference getMappingModel_ModifierSets();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.MappingModel#getGlobalValues <em>Global Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Global Values</em>'.
	 * @see pamtram.MappingModel#getGlobalValues()
	 * @see #getMappingModel()
	 * @generated
	 */
	EReference getMappingModel_GlobalValues();

	/**
	 * Returns the meta object for class '{@link pamtram.TransformationModel <em>Transformation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation Model</em>'.
	 * @see pamtram.TransformationModel
	 * @generated
	 */
	EClass getTransformationModel();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.TransformationModel#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transformation</em>'.
	 * @see pamtram.TransformationModel#getTransformation()
	 * @see #getTransformationModel()
	 * @generated
	 */
	EReference getTransformationModel_Transformation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PamtramFactory getPamtramFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link pamtram.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.NamedElementImpl
		 * @see pamtram.impl.PamtramPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link pamtram.impl.PAMTraMImpl <em>PAM Tra M</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.PAMTraMImpl
		 * @see pamtram.impl.PamtramPackageImpl#getPAMTraM()
		 * @generated
		 */
		EClass PAM_TRA_M = eINSTANCE.getPAMTraM();

		/**
		 * The meta object literal for the '<em><b>Context Meta Model Package</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE = eINSTANCE.getPAMTraM_ContextMetaModelPackage();

		/**
		 * The meta object literal for the '<em><b>Source Section Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__SOURCE_SECTION_MODEL = eINSTANCE.getPAMTraM_SourceSectionModel();

		/**
		 * The meta object literal for the '<em><b>Target Section Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__TARGET_SECTION_MODEL = eINSTANCE.getPAMTraM_TargetSectionModel();

		/**
		 * The meta object literal for the '<em><b>Mapping Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__MAPPING_MODEL = eINSTANCE.getPAMTraM_MappingModel();

		/**
		 * The meta object literal for the '<em><b>Transformation Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__TRANSFORMATION_MODEL = eINSTANCE.getPAMTraM_TransformationModel();

		/**
		 * The meta object literal for the '{@link pamtram.impl.SectionModelImpl <em>Section Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.SectionModelImpl
		 * @see pamtram.impl.PamtramPackageImpl#getSectionModel()
		 * @generated
		 */
		EClass SECTION_MODEL = eINSTANCE.getSectionModel();

		/**
		 * The meta object literal for the '<em><b>Meta Model Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION_MODEL__META_MODEL_PACKAGE = eINSTANCE.getSectionModel_MetaModelPackage();

		/**
		 * The meta object literal for the '{@link pamtram.impl.SourceSectionModelImpl <em>Source Section Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.SourceSectionModelImpl
		 * @see pamtram.impl.PamtramPackageImpl#getSourceSectionModel()
		 * @generated
		 */
		EClass SOURCE_SECTION_MODEL = eINSTANCE.getSourceSectionModel();

		/**
		 * The meta object literal for the '<em><b>Meta Model Sections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_SECTION_MODEL__META_MODEL_SECTIONS = eINSTANCE.getSourceSectionModel_MetaModelSections();

		/**
		 * The meta object literal for the '{@link pamtram.impl.TargetSectionModelImpl <em>Target Section Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.TargetSectionModelImpl
		 * @see pamtram.impl.PamtramPackageImpl#getTargetSectionModel()
		 * @generated
		 */
		EClass TARGET_SECTION_MODEL = eINSTANCE.getTargetSectionModel();

		/**
		 * The meta object literal for the '<em><b>Meta Model Sections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_SECTION_MODEL__META_MODEL_SECTIONS = eINSTANCE.getTargetSectionModel_MetaModelSections();

		/**
		 * The meta object literal for the '{@link pamtram.impl.MappingModelImpl <em>Mapping Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.MappingModelImpl
		 * @see pamtram.impl.PamtramPackageImpl#getMappingModel()
		 * @generated
		 */
		EClass MAPPING_MODEL = eINSTANCE.getMappingModel();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODEL__MAPPING = eINSTANCE.getMappingModel_Mapping();

		/**
		 * The meta object literal for the '<em><b>Modifier Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODEL__MODIFIER_SETS = eINSTANCE.getMappingModel_ModifierSets();

		/**
		 * The meta object literal for the '<em><b>Global Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODEL__GLOBAL_VALUES = eINSTANCE.getMappingModel_GlobalValues();

		/**
		 * The meta object literal for the '{@link pamtram.impl.TransformationModelImpl <em>Transformation Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.TransformationModelImpl
		 * @see pamtram.impl.PamtramPackageImpl#getTransformationModel()
		 * @generated
		 */
		EClass TRANSFORMATION_MODEL = eINSTANCE.getTransformationModel();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_MODEL__TRANSFORMATION = eINSTANCE.getTransformationModel_Transformation();

	}

} //PamtramPackage
