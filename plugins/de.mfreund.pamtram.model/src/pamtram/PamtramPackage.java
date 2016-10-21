/**
 */
package pamtram;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore' genlib='http://www.et.tu-dresden.de/ifa/agtele/genlib'"
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
	 * The meta object id for the '{@link pamtram.impl.DeactivatableElementImpl <em>Deactivatable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.DeactivatableElementImpl
	 * @see pamtram.impl.PamtramPackageImpl#getDeactivatableElement()
	 * @generated
	 */
	int DEACTIVATABLE_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Deactivated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEACTIVATABLE_ELEMENT__DEACTIVATED = 0;

	/**
	 * The number of structural features of the '<em>Deactivatable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEACTIVATABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Deactivatable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEACTIVATABLE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link pamtram.impl.PAMTraMImpl <em>PAM Tra M</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.PAMTraMImpl
	 * @see pamtram.impl.PamtramPackageImpl#getPAMTraM()
	 * @generated
	 */
	int PAM_TRA_M = 2;

	/**
	 * The feature id for the '<em><b>Context Meta Model Package</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Source Section Model</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__SOURCE_SECTION_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Target Section Model</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__TARGET_SECTION_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Mapping Model</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__MAPPING_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Source Sections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__SOURCE_SECTIONS = 4;

	/**
	 * The feature id for the '<em><b>Target Sections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__TARGET_SECTIONS = 5;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__MAPPINGS = 6;

	/**
	 * The feature id for the '<em><b>Active Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__ACTIVE_MAPPINGS = 7;

	/**
	 * The feature id for the '<em><b>Global Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__GLOBAL_VALUES = 8;

	/**
	 * The feature id for the '<em><b>Modifier Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__MODIFIER_SETS = 9;

	/**
	 * The feature id for the '<em><b>Condition Model</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__CONDITION_MODEL = 10;

	/**
	 * The number of structural features of the '<em>PAM Tra M</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M_FEATURE_COUNT = 11;

	/**
	 * The operation id for the '<em>Merge Extends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M___MERGE_EXTENDS = 0;

	/**
	 * The number of operations of the '<em>PAM Tra M</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link pamtram.impl.SectionModelImpl <em>Section Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.SectionModelImpl
	 * @see pamtram.impl.PamtramPackageImpl#getSectionModel()
	 * @generated
	 */
	int SECTION_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_MODEL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Meta Model Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_MODEL__META_MODEL_PACKAGE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Meta Model Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_MODEL__META_MODEL_SECTIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Section Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_MODEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Section Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_MODEL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.impl.SourceSectionModelImpl <em>Source Section Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.SourceSectionModelImpl
	 * @see pamtram.impl.PamtramPackageImpl#getSourceSectionModel()
	 * @generated
	 */
	int SOURCE_SECTION_MODEL = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_MODEL__NAME = SECTION_MODEL__NAME;

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
	int SOURCE_SECTION_MODEL__META_MODEL_SECTIONS = SECTION_MODEL__META_MODEL_SECTIONS;

	/**
	 * The number of structural features of the '<em>Source Section Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_MODEL_FEATURE_COUNT = SECTION_MODEL_FEATURE_COUNT + 0;

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
	int TARGET_SECTION_MODEL = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_MODEL__NAME = SECTION_MODEL__NAME;

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
	int TARGET_SECTION_MODEL__META_MODEL_SECTIONS = SECTION_MODEL__META_MODEL_SECTIONS;

	/**
	 * The feature id for the '<em><b>Library Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_MODEL__LIBRARY_ELEMENTS = SECTION_MODEL_FEATURE_COUNT + 0;

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
	int MAPPING_MODEL = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Deactivated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__DEACTIVATED = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__LOCAL_CONDITION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__SHARED_CONDITION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__MAPPING = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Modifier Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__MODIFIER_SETS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Global Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__GLOBAL_VALUES = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Mapping Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Either Model Or Refer Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL___EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP_2 = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL___REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP_2 = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Active Mappings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL___GET_ACTIVE_MAPPINGS = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Mapping Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link pamtram.impl.ConditionalElementImpl <em>Conditional Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.ConditionalElementImpl
	 * @see pamtram.impl.PamtramPackageImpl#getConditionalElement()
	 * @generated
	 */
	int CONDITIONAL_ELEMENT = 7;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ELEMENT__LOCAL_CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ELEMENT__SHARED_CONDITION = 1;

	/**
	 * The number of structural features of the '<em>Conditional Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Either Model Or Refer Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ELEMENT___EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP_2 = 0;

	/**
	 * The operation id for the '<em>Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ELEMENT___REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP_2 = 1;

	/**
	 * The number of operations of the '<em>Conditional Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ELEMENT_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link pamtram.impl.ConditionModelImpl <em>Condition Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.ConditionModelImpl
	 * @see pamtram.impl.PamtramPackageImpl#getConditionModel()
	 * @generated
	 */
	int CONDITION_MODEL = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_MODEL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_MODEL__CONDITION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Condition Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_MODEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Condition Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_MODEL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

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
	 * Returns the meta object for class '{@link pamtram.DeactivatableElement <em>Deactivatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deactivatable Element</em>'.
	 * @see pamtram.DeactivatableElement
	 * @generated
	 */
	EClass getDeactivatableElement();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.DeactivatableElement#isDeactivated <em>Deactivated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deactivated</em>'.
	 * @see pamtram.DeactivatableElement#isDeactivated()
	 * @see #getDeactivatableElement()
	 * @generated
	 */
	EAttribute getDeactivatableElement_Deactivated();

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
	 * Returns the meta object for the containment reference list '{@link pamtram.PAMTraM#getSourceSectionModel <em>Source Section Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Section Model</em>'.
	 * @see pamtram.PAMTraM#getSourceSectionModel()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_SourceSectionModel();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.PAMTraM#getTargetSectionModel <em>Target Section Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Section Model</em>'.
	 * @see pamtram.PAMTraM#getTargetSectionModel()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_TargetSectionModel();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.PAMTraM#getMappingModel <em>Mapping Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Model</em>'.
	 * @see pamtram.PAMTraM#getMappingModel()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_MappingModel();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.PAMTraM#getSourceSections <em>Source Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source Sections</em>'.
	 * @see pamtram.PAMTraM#getSourceSections()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_SourceSections();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.PAMTraM#getTargetSections <em>Target Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Sections</em>'.
	 * @see pamtram.PAMTraM#getTargetSections()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_TargetSections();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.PAMTraM#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mappings</em>'.
	 * @see pamtram.PAMTraM#getMappings()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_Mappings();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.PAMTraM#getActiveMappings <em>Active Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Active Mappings</em>'.
	 * @see pamtram.PAMTraM#getActiveMappings()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_ActiveMappings();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.PAMTraM#getGlobalValues <em>Global Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Global Values</em>'.
	 * @see pamtram.PAMTraM#getGlobalValues()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_GlobalValues();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.PAMTraM#getModifierSets <em>Modifier Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Modifier Sets</em>'.
	 * @see pamtram.PAMTraM#getModifierSets()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_ModifierSets();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.PAMTraM#getConditionModel <em>Condition Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Condition Model</em>'.
	 * @see pamtram.PAMTraM#getConditionModel()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_ConditionModel();

	/**
	 * Returns the meta object for the '{@link pamtram.PAMTraM#mergeExtends() <em>Merge Extends</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Merge Extends</em>' operation.
	 * @see pamtram.PAMTraM#mergeExtends()
	 * @generated
	 */
	EOperation getPAMTraM__MergeExtends();

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
	 * Returns the meta object for the containment reference list '{@link pamtram.SectionModel#getMetaModelSections <em>Meta Model Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Meta Model Sections</em>'.
	 * @see pamtram.SectionModel#getMetaModelSections()
	 * @see #getSectionModel()
	 * @generated
	 */
	EReference getSectionModel_MetaModelSections();

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
	 * Returns the meta object for class '{@link pamtram.TargetSectionModel <em>Target Section Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Section Model</em>'.
	 * @see pamtram.TargetSectionModel
	 * @generated
	 */
	EClass getTargetSectionModel();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.TargetSectionModel#getLibraryElements <em>Library Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Library Elements</em>'.
	 * @see pamtram.TargetSectionModel#getLibraryElements()
	 * @see #getTargetSectionModel()
	 * @generated
	 */
	EReference getTargetSectionModel_LibraryElements();

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
	 * Returns the meta object for the '{@link pamtram.MappingModel#getActiveMappings() <em>Get Active Mappings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Active Mappings</em>' operation.
	 * @see pamtram.MappingModel#getActiveMappings()
	 * @generated
	 */
	EOperation getMappingModel__GetActiveMappings();

	/**
	 * Returns the meta object for class '{@link pamtram.ConditionalElement <em>Conditional Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Element</em>'.
	 * @see pamtram.ConditionalElement
	 * @generated
	 */
	EClass getConditionalElement();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.ConditionalElement#getLocalCondition <em>Local Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Local Condition</em>'.
	 * @see pamtram.ConditionalElement#getLocalCondition()
	 * @see #getConditionalElement()
	 * @generated
	 */
	EReference getConditionalElement_LocalCondition();

	/**
	 * Returns the meta object for the reference '{@link pamtram.ConditionalElement#getSharedCondition <em>Shared Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Shared Condition</em>'.
	 * @see pamtram.ConditionalElement#getSharedCondition()
	 * @see #getConditionalElement()
	 * @generated
	 */
	EReference getConditionalElement_SharedCondition();

	/**
	 * Returns the meta object for the '{@link pamtram.ConditionalElement#eitherModelOrReferCondition(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Either Model Or Refer Condition</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Either Model Or Refer Condition</em>' operation.
	 * @see pamtram.ConditionalElement#eitherModelOrReferCondition(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getConditionalElement__EitherModelOrReferCondition__DiagnosticChain_Map_2();

	/**
	 * Returns the meta object for the '{@link pamtram.ConditionalElement#referenceOnlyConditionsFromConditionModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Reference Only Conditions From Condition Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Reference Only Conditions From Condition Model</em>' operation.
	 * @see pamtram.ConditionalElement#referenceOnlyConditionsFromConditionModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getConditionalElement__ReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map_2();

	/**
	 * Returns the meta object for class '{@link pamtram.ConditionModel <em>Condition Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Model</em>'.
	 * @see pamtram.ConditionModel
	 * @generated
	 */
	EClass getConditionModel();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.ConditionModel#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Condition</em>'.
	 * @see pamtram.ConditionModel#getCondition()
	 * @see #getConditionModel()
	 * @generated
	 */
	EReference getConditionModel_Condition();

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
		 * The meta object literal for the '{@link pamtram.impl.DeactivatableElementImpl <em>Deactivatable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.DeactivatableElementImpl
		 * @see pamtram.impl.PamtramPackageImpl#getDeactivatableElement()
		 * @generated
		 */
		EClass DEACTIVATABLE_ELEMENT = eINSTANCE.getDeactivatableElement();

		/**
		 * The meta object literal for the '<em><b>Deactivated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEACTIVATABLE_ELEMENT__DEACTIVATED = eINSTANCE.getDeactivatableElement_Deactivated();

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
		 * The meta object literal for the '<em><b>Source Section Model</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__SOURCE_SECTION_MODEL = eINSTANCE.getPAMTraM_SourceSectionModel();

		/**
		 * The meta object literal for the '<em><b>Target Section Model</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__TARGET_SECTION_MODEL = eINSTANCE.getPAMTraM_TargetSectionModel();

		/**
		 * The meta object literal for the '<em><b>Mapping Model</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__MAPPING_MODEL = eINSTANCE.getPAMTraM_MappingModel();

		/**
		 * The meta object literal for the '<em><b>Source Sections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__SOURCE_SECTIONS = eINSTANCE.getPAMTraM_SourceSections();

		/**
		 * The meta object literal for the '<em><b>Target Sections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__TARGET_SECTIONS = eINSTANCE.getPAMTraM_TargetSections();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__MAPPINGS = eINSTANCE.getPAMTraM_Mappings();

		/**
		 * The meta object literal for the '<em><b>Active Mappings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__ACTIVE_MAPPINGS = eINSTANCE.getPAMTraM_ActiveMappings();

		/**
		 * The meta object literal for the '<em><b>Global Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__GLOBAL_VALUES = eINSTANCE.getPAMTraM_GlobalValues();

		/**
		 * The meta object literal for the '<em><b>Modifier Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__MODIFIER_SETS = eINSTANCE.getPAMTraM_ModifierSets();

		/**
		 * The meta object literal for the '<em><b>Condition Model</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__CONDITION_MODEL = eINSTANCE.getPAMTraM_ConditionModel();

		/**
		 * The meta object literal for the '<em><b>Merge Extends</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PAM_TRA_M___MERGE_EXTENDS = eINSTANCE.getPAMTraM__MergeExtends();

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
		 * The meta object literal for the '<em><b>Meta Model Sections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION_MODEL__META_MODEL_SECTIONS = eINSTANCE.getSectionModel_MetaModelSections();

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
		 * The meta object literal for the '{@link pamtram.impl.TargetSectionModelImpl <em>Target Section Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.TargetSectionModelImpl
		 * @see pamtram.impl.PamtramPackageImpl#getTargetSectionModel()
		 * @generated
		 */
		EClass TARGET_SECTION_MODEL = eINSTANCE.getTargetSectionModel();

		/**
		 * The meta object literal for the '<em><b>Library Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_SECTION_MODEL__LIBRARY_ELEMENTS = eINSTANCE.getTargetSectionModel_LibraryElements();

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
		 * The meta object literal for the '<em><b>Get Active Mappings</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_MODEL___GET_ACTIVE_MAPPINGS = eINSTANCE.getMappingModel__GetActiveMappings();

		/**
		 * The meta object literal for the '{@link pamtram.impl.ConditionalElementImpl <em>Conditional Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.ConditionalElementImpl
		 * @see pamtram.impl.PamtramPackageImpl#getConditionalElement()
		 * @generated
		 */
		EClass CONDITIONAL_ELEMENT = eINSTANCE.getConditionalElement();

		/**
		 * The meta object literal for the '<em><b>Local Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_ELEMENT__LOCAL_CONDITION = eINSTANCE.getConditionalElement_LocalCondition();

		/**
		 * The meta object literal for the '<em><b>Shared Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_ELEMENT__SHARED_CONDITION = eINSTANCE.getConditionalElement_SharedCondition();

		/**
		 * The meta object literal for the '<em><b>Either Model Or Refer Condition</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONDITIONAL_ELEMENT___EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP_2 = eINSTANCE.getConditionalElement__EitherModelOrReferCondition__DiagnosticChain_Map_2();

		/**
		 * The meta object literal for the '<em><b>Reference Only Conditions From Condition Model</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONDITIONAL_ELEMENT___REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP_2 = eINSTANCE.getConditionalElement__ReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map_2();

		/**
		 * The meta object literal for the '{@link pamtram.impl.ConditionModelImpl <em>Condition Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.ConditionModelImpl
		 * @see pamtram.impl.PamtramPackageImpl#getConditionModel()
		 * @generated
		 */
		EClass CONDITION_MODEL = eINSTANCE.getConditionModel();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_MODEL__CONDITION = eINSTANCE.getConditionModel_Condition();

	}

} //PamtramPackage
