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
 * <!-- begin-model-doc -->
 * Main package of the PAMTraM (Persistent Ambiguous Mapping and Transformation Model) meta-model containing various structuring and general elements.
 * <!-- end-model-doc -->
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
	 * The feature id for the '<em><b>Source Section Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__SOURCE_SECTION_MODELS = 0;

	/**
	 * The feature id for the '<em><b>Shared Source Section Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS = 1;

	/**
	 * The feature id for the '<em><b>Target Section Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__TARGET_SECTION_MODELS = 2;

	/**
	 * The feature id for the '<em><b>Shared Target Section Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__SHARED_TARGET_SECTION_MODELS = 3;

	/**
	 * The feature id for the '<em><b>Mapping Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__MAPPING_MODELS = 4;

	/**
	 * The feature id for the '<em><b>Shared Mapping Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__SHARED_MAPPING_MODELS = 5;

	/**
	 * The feature id for the '<em><b>Source Sections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__SOURCE_SECTIONS = 6;

	/**
	 * The feature id for the '<em><b>Target Sections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__TARGET_SECTIONS = 7;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__MAPPINGS = 8;

	/**
	 * The feature id for the '<em><b>Active Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__ACTIVE_MAPPINGS = 9;

	/**
	 * The feature id for the '<em><b>Global Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__GLOBAL_VALUES = 10;

	/**
	 * The feature id for the '<em><b>Global Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__GLOBAL_ATTRIBUTES = 11;

	/**
	 * The feature id for the '<em><b>Modifier Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__MODIFIER_SETS = 12;

	/**
	 * The feature id for the '<em><b>Condition Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__CONDITION_MODELS = 13;

	/**
	 * The feature id for the '<em><b>Shared Condition Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M__SHARED_CONDITION_MODELS = 14;

	/**
	 * The number of structural features of the '<em>PAM Tra M</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M_FEATURE_COUNT = 15;

	/**
	 * The operation id for the '<em>Get Active Source Section Models</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M___GET_ACTIVE_SOURCE_SECTION_MODELS = 0;

	/**
	 * The operation id for the '<em>Get Active Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M___GET_ACTIVE_SOURCE_SECTIONS = 1;

	/**
	 * The number of operations of the '<em>PAM Tra M</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAM_TRA_M_OPERATION_COUNT = 2;

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
	 * The feature id for the '<em><b>Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_MODEL__SECTIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_MODEL__SECTIONS = SECTION_MODEL__SECTIONS;

	/**
	 * The feature id for the '<em><b>Deactivated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_MODEL__DEACTIVATED = SECTION_MODEL_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_MODEL__SECTIONS = SECTION_MODEL__SECTIONS;

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
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__ALL_CONDITIONS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__MAPPINGS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Modifier Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__MODIFIER_SETS = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Global Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__GLOBAL_VALUES = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Active Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__ACTIVE_MAPPINGS = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Global Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__GLOBAL_ATTRIBUTES = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Mapping Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mapping Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 1;

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
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ELEMENT__ALL_CONDITIONS = 2;

	/**
	 * The number of structural features of the '<em>Conditional Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The number of operations of the '<em>Conditional Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ELEMENT_OPERATION_COUNT = 1;

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
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_MODEL__CONDITIONS = NAMED_ELEMENT_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link pamtram.impl.ExpressionElementImpl <em>Expression Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.ExpressionElementImpl
	 * @see pamtram.impl.PamtramPackageImpl#getExpressionElement()
	 * @generated
	 */
	int EXPRESSION_ELEMENT = 9;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_ELEMENT__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Expression Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Expression Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link pamtram.impl.ModifiableElementImpl <em>Modifiable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.ModifiableElementImpl
	 * @see pamtram.impl.PamtramPackageImpl#getModifiableElement()
	 * @generated
	 */
	int MODIFIABLE_ELEMENT = 10;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIABLE_ELEMENT__MODIFIERS = 0;

	/**
	 * The number of structural features of the '<em>Modifiable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Modifiable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIABLE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link pamtram.impl.MatchSpecElementImpl <em>Match Spec Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.MatchSpecElementImpl
	 * @see pamtram.impl.PamtramPackageImpl#getMatchSpecElement()
	 * @generated
	 */
	int MATCH_SPEC_ELEMENT = 11;

	/**
	 * The feature id for the '<em><b>Reference Match Spec</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC = 0;

	/**
	 * The number of structural features of the '<em>Match Spec Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_SPEC_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Match Spec Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_SPEC_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link pamtram.impl.FixedValueImpl <em>Fixed Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.FixedValueImpl
	 * @see pamtram.impl.PamtramPackageImpl#getFixedValue()
	 * @generated
	 */
	int FIXED_VALUE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_VALUE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_VALUE__LOCAL_CONDITION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_VALUE__SHARED_CONDITION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_VALUE__ALL_CONDITIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_VALUE__VALUE = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Fixed Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_VALUE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_VALUE___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fixed Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_VALUE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 1;

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
	 * Returns the meta object for the containment reference list '{@link pamtram.PAMTraM#getSourceSectionModels <em>Source Section Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Section Models</em>'.
	 * @see pamtram.PAMTraM#getSourceSectionModels()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_SourceSectionModels();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.PAMTraM#getSharedSourceSectionModels <em>Shared Source Section Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Shared Source Section Models</em>'.
	 * @see pamtram.PAMTraM#getSharedSourceSectionModels()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_SharedSourceSectionModels();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.PAMTraM#getTargetSectionModels <em>Target Section Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Section Models</em>'.
	 * @see pamtram.PAMTraM#getTargetSectionModels()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_TargetSectionModels();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.PAMTraM#getSharedTargetSectionModels <em>Shared Target Section Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Shared Target Section Models</em>'.
	 * @see pamtram.PAMTraM#getSharedTargetSectionModels()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_SharedTargetSectionModels();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.PAMTraM#getMappingModels <em>Mapping Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Models</em>'.
	 * @see pamtram.PAMTraM#getMappingModels()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_MappingModels();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.PAMTraM#getSharedMappingModels <em>Shared Mapping Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Shared Mapping Models</em>'.
	 * @see pamtram.PAMTraM#getSharedMappingModels()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_SharedMappingModels();

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
	 * Returns the meta object for the reference list '{@link pamtram.PAMTraM#getGlobalAttributes <em>Global Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Global Attributes</em>'.
	 * @see pamtram.PAMTraM#getGlobalAttributes()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_GlobalAttributes();

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
	 * Returns the meta object for the containment reference list '{@link pamtram.PAMTraM#getConditionModels <em>Condition Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Condition Models</em>'.
	 * @see pamtram.PAMTraM#getConditionModels()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_ConditionModels();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.PAMTraM#getSharedConditionModels <em>Shared Condition Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Shared Condition Models</em>'.
	 * @see pamtram.PAMTraM#getSharedConditionModels()
	 * @see #getPAMTraM()
	 * @generated
	 */
	EReference getPAMTraM_SharedConditionModels();

	/**
	 * Returns the meta object for the '{@link pamtram.PAMTraM#getActiveSourceSectionModels() <em>Get Active Source Section Models</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Active Source Section Models</em>' operation.
	 * @see pamtram.PAMTraM#getActiveSourceSectionModels()
	 * @generated
	 */
	EOperation getPAMTraM__GetActiveSourceSectionModels();

	/**
	 * Returns the meta object for the '{@link pamtram.PAMTraM#getActiveSourceSections() <em>Get Active Source Sections</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Active Source Sections</em>' operation.
	 * @see pamtram.PAMTraM#getActiveSourceSections()
	 * @generated
	 */
	EOperation getPAMTraM__GetActiveSourceSections();

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
	 * Returns the meta object for the containment reference list '{@link pamtram.SectionModel#getSections <em>Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sections</em>'.
	 * @see pamtram.SectionModel#getSections()
	 * @see #getSectionModel()
	 * @generated
	 */
	EReference getSectionModel_Sections();

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
	 * Returns the meta object for the containment reference list '{@link pamtram.MappingModel#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see pamtram.MappingModel#getMappings()
	 * @see #getMappingModel()
	 * @generated
	 */
	EReference getMappingModel_Mappings();

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
	 * Returns the meta object for the reference list '{@link pamtram.MappingModel#getActiveMappings <em>Active Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Active Mappings</em>'.
	 * @see pamtram.MappingModel#getActiveMappings()
	 * @see #getMappingModel()
	 * @generated
	 */
	EReference getMappingModel_ActiveMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.MappingModel#getGlobalAttributes <em>Global Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Global Attributes</em>'.
	 * @see pamtram.MappingModel#getGlobalAttributes()
	 * @see #getMappingModel()
	 * @generated
	 */
	EReference getMappingModel_GlobalAttributes();

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
	 * Returns the meta object for the reference list '{@link pamtram.ConditionalElement#getAllConditions <em>All Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Conditions</em>'.
	 * @see pamtram.ConditionalElement#getAllConditions()
	 * @see #getConditionalElement()
	 * @generated
	 */
	EReference getConditionalElement_AllConditions();

	/**
	 * Returns the meta object for the '{@link pamtram.ConditionalElement#validateReferenceOnlyConditionsFromConditionModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Reference Only Conditions From Condition Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * @see pamtram.ConditionalElement#validateReferenceOnlyConditionsFromConditionModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getConditionalElement__ValidateReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map();

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
	 * Returns the meta object for the containment reference list '{@link pamtram.ConditionModel#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see pamtram.ConditionModel#getConditions()
	 * @see #getConditionModel()
	 * @generated
	 */
	EReference getConditionModel_Conditions();

	/**
	 * Returns the meta object for class '{@link pamtram.ExpressionElement <em>Expression Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Element</em>'.
	 * @see pamtram.ExpressionElement
	 * @generated
	 */
	EClass getExpressionElement();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.ExpressionElement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see pamtram.ExpressionElement#getExpression()
	 * @see #getExpressionElement()
	 * @generated
	 */
	EAttribute getExpressionElement_Expression();

	/**
	 * Returns the meta object for class '{@link pamtram.ModifiableElement <em>Modifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modifiable Element</em>'.
	 * @see pamtram.ModifiableElement
	 * @generated
	 */
	EClass getModifiableElement();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.ModifiableElement#getModifiers <em>Modifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Modifiers</em>'.
	 * @see pamtram.ModifiableElement#getModifiers()
	 * @see #getModifiableElement()
	 * @generated
	 */
	EReference getModifiableElement_Modifiers();

	/**
	 * Returns the meta object for class '{@link pamtram.MatchSpecElement <em>Match Spec Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match Spec Element</em>'.
	 * @see pamtram.MatchSpecElement
	 * @generated
	 */
	EClass getMatchSpecElement();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.MatchSpecElement#getReferenceMatchSpec <em>Reference Match Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reference Match Spec</em>'.
	 * @see pamtram.MatchSpecElement#getReferenceMatchSpec()
	 * @see #getMatchSpecElement()
	 * @generated
	 */
	EReference getMatchSpecElement_ReferenceMatchSpec();

	/**
	 * Returns the meta object for class '{@link pamtram.FixedValue <em>Fixed Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Value</em>'.
	 * @see pamtram.FixedValue
	 * @generated
	 */
	EClass getFixedValue();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.FixedValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see pamtram.FixedValue#getValue()
	 * @see #getFixedValue()
	 * @generated
	 */
	EAttribute getFixedValue_Value();

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
		 * The meta object literal for the '<em><b>Source Section Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__SOURCE_SECTION_MODELS = eINSTANCE.getPAMTraM_SourceSectionModels();

		/**
		 * The meta object literal for the '<em><b>Shared Source Section Models</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS = eINSTANCE.getPAMTraM_SharedSourceSectionModels();

		/**
		 * The meta object literal for the '<em><b>Target Section Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__TARGET_SECTION_MODELS = eINSTANCE.getPAMTraM_TargetSectionModels();

		/**
		 * The meta object literal for the '<em><b>Shared Target Section Models</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__SHARED_TARGET_SECTION_MODELS = eINSTANCE.getPAMTraM_SharedTargetSectionModels();

		/**
		 * The meta object literal for the '<em><b>Mapping Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__MAPPING_MODELS = eINSTANCE.getPAMTraM_MappingModels();

		/**
		 * The meta object literal for the '<em><b>Shared Mapping Models</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__SHARED_MAPPING_MODELS = eINSTANCE.getPAMTraM_SharedMappingModels();

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
		 * The meta object literal for the '<em><b>Global Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__GLOBAL_ATTRIBUTES = eINSTANCE.getPAMTraM_GlobalAttributes();

		/**
		 * The meta object literal for the '<em><b>Modifier Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__MODIFIER_SETS = eINSTANCE.getPAMTraM_ModifierSets();

		/**
		 * The meta object literal for the '<em><b>Condition Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__CONDITION_MODELS = eINSTANCE.getPAMTraM_ConditionModels();

		/**
		 * The meta object literal for the '<em><b>Shared Condition Models</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAM_TRA_M__SHARED_CONDITION_MODELS = eINSTANCE.getPAMTraM_SharedConditionModels();

		/**
		 * The meta object literal for the '<em><b>Get Active Source Section Models</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PAM_TRA_M___GET_ACTIVE_SOURCE_SECTION_MODELS = eINSTANCE.getPAMTraM__GetActiveSourceSectionModels();

		/**
		 * The meta object literal for the '<em><b>Get Active Source Sections</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PAM_TRA_M___GET_ACTIVE_SOURCE_SECTIONS = eINSTANCE.getPAMTraM__GetActiveSourceSections();

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
		 * The meta object literal for the '<em><b>Sections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION_MODEL__SECTIONS = eINSTANCE.getSectionModel_Sections();

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
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODEL__MAPPINGS = eINSTANCE.getMappingModel_Mappings();

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
		 * The meta object literal for the '<em><b>Active Mappings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODEL__ACTIVE_MAPPINGS = eINSTANCE.getMappingModel_ActiveMappings();

		/**
		 * The meta object literal for the '<em><b>Global Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODEL__GLOBAL_ATTRIBUTES = eINSTANCE.getMappingModel_GlobalAttributes();

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
		 * The meta object literal for the '<em><b>All Conditions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_ELEMENT__ALL_CONDITIONS = eINSTANCE.getConditionalElement_AllConditions();

		/**
		 * The meta object literal for the '<em><b>Validate Reference Only Conditions From Condition Model</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONDITIONAL_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getConditionalElement__ValidateReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map();

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
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_MODEL__CONDITIONS = eINSTANCE.getConditionModel_Conditions();

		/**
		 * The meta object literal for the '{@link pamtram.impl.ExpressionElementImpl <em>Expression Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.ExpressionElementImpl
		 * @see pamtram.impl.PamtramPackageImpl#getExpressionElement()
		 * @generated
		 */
		EClass EXPRESSION_ELEMENT = eINSTANCE.getExpressionElement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_ELEMENT__EXPRESSION = eINSTANCE.getExpressionElement_Expression();

		/**
		 * The meta object literal for the '{@link pamtram.impl.ModifiableElementImpl <em>Modifiable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.ModifiableElementImpl
		 * @see pamtram.impl.PamtramPackageImpl#getModifiableElement()
		 * @generated
		 */
		EClass MODIFIABLE_ELEMENT = eINSTANCE.getModifiableElement();

		/**
		 * The meta object literal for the '<em><b>Modifiers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFIABLE_ELEMENT__MODIFIERS = eINSTANCE.getModifiableElement_Modifiers();

		/**
		 * The meta object literal for the '{@link pamtram.impl.MatchSpecElementImpl <em>Match Spec Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.MatchSpecElementImpl
		 * @see pamtram.impl.PamtramPackageImpl#getMatchSpecElement()
		 * @generated
		 */
		EClass MATCH_SPEC_ELEMENT = eINSTANCE.getMatchSpecElement();

		/**
		 * The meta object literal for the '<em><b>Reference Match Spec</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC = eINSTANCE.getMatchSpecElement_ReferenceMatchSpec();

		/**
		 * The meta object literal for the '{@link pamtram.impl.FixedValueImpl <em>Fixed Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.FixedValueImpl
		 * @see pamtram.impl.PamtramPackageImpl#getFixedValue()
		 * @generated
		 */
		EClass FIXED_VALUE = eINSTANCE.getFixedValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_VALUE__VALUE = eINSTANCE.getFixedValue_Value();

	}

} //PamtramPackage
