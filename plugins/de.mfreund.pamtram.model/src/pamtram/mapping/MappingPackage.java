/**
 */
package pamtram.mapping;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import pamtram.PamtramPackage;

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
 * @see pamtram.mapping.MappingFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore' genlib='http://www.et.tu-dresden.de/ifa/agtele/genlib'"
 * @generated
 */
public interface MappingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mapping";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mfreund.de/pamtram/mapping";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mapping";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MappingPackage eINSTANCE = pamtram.mapping.impl.MappingPackageImpl.init();

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingTypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingTypeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingType()
	 * @generated
	 */
	int MAPPING_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TYPE__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Deactivated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TYPE__DEACTIVATED = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TYPE__SOURCE_SECTION = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TYPE_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TYPE_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__NAME = MAPPING_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Deactivated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__DEACTIVATED = MAPPING_TYPE__DEACTIVATED;

	/**
	 * The feature id for the '<em><b>Source Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SOURCE_SECTION = MAPPING_TYPE__SOURCE_SECTION;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__LOCAL_CONDITION = MAPPING_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SHARED_CONDITION = MAPPING_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mapping Hint Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__MAPPING_HINT_GROUPS = MAPPING_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Imported Mapping Hint Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__IMPORTED_MAPPING_HINT_GROUPS = MAPPING_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Global Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__GLOBAL_VARIABLES = MAPPING_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__ABSTRACT = MAPPING_TYPE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = MAPPING_TYPE_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Validate Either Model Or Refer Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP = MAPPING_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MAPPING_TYPE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Active Mapping Hint Groups</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___GET_ACTIVE_MAPPING_HINT_GROUPS = MAPPING_TYPE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Active Imported Mapping Hint Groups</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___GET_ACTIVE_IMPORTED_MAPPING_HINT_GROUPS = MAPPING_TYPE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate Contains Hint Groups</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___VALIDATE_CONTAINS_HINT_GROUPS__DIAGNOSTICCHAIN_MAP = MAPPING_TYPE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate Contains Deactivated Hint Groups</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___VALIDATE_CONTAINS_DEACTIVATED_HINT_GROUPS__DIAGNOSTICCHAIN_MAP = MAPPING_TYPE_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_COUNT = MAPPING_TYPE_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingHintTypeImpl <em>Hint Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingHintTypeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintType()
	 * @generated
	 */
	int MAPPING_HINT_TYPE = 25;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingHintImpl <em>Hint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingHintImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHint()
	 * @generated
	 */
	int MAPPING_HINT = 6;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeMappingImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMapping()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING = 9;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.CardinalityMappingImpl <em>Cardinality Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.CardinalityMappingImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getCardinalityMapping()
	 * @generated
	 */
	int CARDINALITY_MAPPING = 10;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ReferenceTargetSelectorImpl <em>Reference Target Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ReferenceTargetSelectorImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getReferenceTargetSelector()
	 * @generated
	 */
	int REFERENCE_TARGET_SELECTOR = 11;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MatcherImpl <em>Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MatcherImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMatcher()
	 * @generated
	 */
	int MATCHER = 12;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeMatcherImpl <em>Attribute Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeMatcherImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMatcher()
	 * @generated
	 */
	int ATTRIBUTE_MATCHER = 13;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ClassMatcherImpl <em>Class Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ClassMatcherImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getClassMatcher()
	 * @generated
	 */
	int CLASS_MATCHER = 16;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ModifiedAttributeElementTypeImpl <em>Modified Attribute Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ModifiedAttributeElementTypeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getModifiedAttributeElementType()
	 * @generated
	 */
	int MODIFIED_ATTRIBUTE_ELEMENT_TYPE = 17;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingHintGroupTypeImpl <em>Hint Group Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingHintGroupTypeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintGroupType()
	 * @generated
	 */
	int MAPPING_HINT_GROUP_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Target Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE__TARGET_SECTION = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Hints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extend</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE__EXTEND = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Hint Group Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Hint Group Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingHintGroupImpl <em>Hint Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingHintGroupImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintGroup()
	 * @generated
	 */
	int MAPPING_HINT_GROUP = 4;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.InstantiableMappingHintGroupImpl <em>Instantiable Mapping Hint Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.InstantiableMappingHintGroupImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getInstantiableMappingHintGroup()
	 * @generated
	 */
	int INSTANTIABLE_MAPPING_HINT_GROUP = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIABLE_MAPPING_HINT_GROUP__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Deactivated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIABLE_MAPPING_HINT_GROUP__DEACTIVATED = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIABLE_MAPPING_HINT_GROUP__LOCAL_CONDITION = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIABLE_MAPPING_HINT_GROUP__SHARED_CONDITION = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Instantiable Mapping Hint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIABLE_MAPPING_HINT_GROUP_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate Either Model Or Refer Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIABLE_MAPPING_HINT_GROUP___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIABLE_MAPPING_HINT_GROUP___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Instantiable Mapping Hint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIABLE_MAPPING_HINT_GROUP_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__NAME = MAPPING_HINT_GROUP_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Target Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__TARGET_SECTION = MAPPING_HINT_GROUP_TYPE__TARGET_SECTION;

	/**
	 * The feature id for the '<em><b>Mapping Hints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__MAPPING_HINTS = MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS;

	/**
	 * The feature id for the '<em><b>Extend</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__EXTEND = MAPPING_HINT_GROUP_TYPE__EXTEND;

	/**
	 * The feature id for the '<em><b>Deactivated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__DEACTIVATED = MAPPING_HINT_GROUP_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__LOCAL_CONDITION = MAPPING_HINT_GROUP_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__SHARED_CONDITION = MAPPING_HINT_GROUP_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Container Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__CONTAINER_SELECTOR = MAPPING_HINT_GROUP_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Hint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_FEATURE_COUNT = MAPPING_HINT_GROUP_TYPE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate Either Model Or Refer Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_GROUP_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_GROUP_TYPE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Hint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_OPERATION_COUNT = MAPPING_HINT_GROUP_TYPE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingHintBaseTypeImpl <em>Hint Base Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingHintBaseTypeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintBaseType()
	 * @generated
	 */
	int MAPPING_HINT_BASE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_BASE_TYPE__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Hint Base Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_BASE_TYPE_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Hint Base Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_BASE_TYPE_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_TYPE__NAME = MAPPING_HINT_BASE_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Hint Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_TYPE_FEATURE_COUNT = MAPPING_HINT_BASE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Hint Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_TYPE_OPERATION_COUNT = MAPPING_HINT_BASE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT__NAME = MAPPING_HINT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT__LOCAL_CONDITION = MAPPING_HINT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT__SHARED_CONDITION = MAPPING_HINT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_FEATURE_COUNT = MAPPING_HINT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Either Model Or Refer Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_OPERATION_COUNT = MAPPING_HINT_TYPE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.impl.ExpressionElementImpl <em>Expression Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.impl.ExpressionElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getExpressionElement()
	 * @generated
	 */
	int EXPRESSION_ELEMENT = 7;

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
	 * @see pamtram.mapping.impl.MappingPackageImpl#getModifiableElement()
	 * @generated
	 */
	int MODIFIABLE_ELEMENT = 8;

	/**
	 * The feature id for the '<em><b>Result Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIABLE_ELEMENT__RESULT_MODIFIER = 0;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__NAME = MAPPING_HINT__NAME;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__LOCAL_CONDITION = MAPPING_HINT__LOCAL_CONDITION;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__SHARED_CONDITION = MAPPING_HINT__SHARED_CONDITION;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__EXPRESSION = MAPPING_HINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__RESULT_MODIFIER = MAPPING_HINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__TARGET = MAPPING_HINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__SOURCE_ELEMENTS = MAPPING_HINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Attribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_FEATURE_COUNT = MAPPING_HINT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate Either Model Or Refer Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Local Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING___GET_LOCAL_SOURCE_ELEMENTS = MAPPING_HINT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get External Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING___GET_EXTERNAL_SOURCE_ELEMENTS = MAPPING_HINT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Target Attribute Matches Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING___VALIDATE_TARGET_ATTRIBUTE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_OPERATION_COUNT = MAPPING_HINT_OPERATION_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__NAME = MAPPING_HINT__NAME;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__LOCAL_CONDITION = MAPPING_HINT__LOCAL_CONDITION;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__SHARED_CONDITION = MAPPING_HINT__SHARED_CONDITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__SOURCE = MAPPING_HINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__TARGET = MAPPING_HINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cardinality Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_FEATURE_COUNT = MAPPING_HINT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Either Model Or Refer Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Source Class Matches Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_SOURCE_CLASS_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Target Class Matches Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_TARGET_CLASS_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Source Class Is Variable Cardinality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_SOURCE_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Target Class Is Variable Cardinality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_TARGET_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate No Cardinality Mapping For Source Section Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Cardinality Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_OPERATION_COUNT = MAPPING_HINT_OPERATION_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR__NAME = MAPPING_HINT__NAME;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR__LOCAL_CONDITION = MAPPING_HINT__LOCAL_CONDITION;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR__SHARED_CONDITION = MAPPING_HINT__SHARED_CONDITION;

	/**
	 * The feature id for the '<em><b>Affected Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE = MAPPING_HINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR__MATCHER = MAPPING_HINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference Target Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR_FEATURE_COUNT = MAPPING_HINT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Either Model Or Refer Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Affected Reference Is Non Containment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR___VALIDATE_AFFECTED_REFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Affected Reference Matches Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR___VALIDATE_AFFECTED_REFERENCE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Reference Target Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR_OPERATION_COUNT = MAPPING_HINT_OPERATION_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHER_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER__EXPRESSION = MATCHER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER__RESULT_MODIFIER = MATCHER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER__TARGET = MATCHER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER__SOURCE_ELEMENTS = MATCHER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Attribute Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_FEATURE_COUNT = MATCHER_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Local Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER___GET_LOCAL_SOURCE_ELEMENTS = MATCHER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get External Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER___GET_EXTERNAL_SOURCE_ELEMENTS = MATCHER_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Target Matches Affected Reference Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER___VALIDATE_TARGET_MATCHES_AFFECTED_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP = MATCHER_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_OPERATION_COUNT = MATCHER_OPERATION_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Modified Attribute Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Modified Attribute Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.LocalModifiedAttributeElementTypeImpl <em>Local Modified Attribute Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.LocalModifiedAttributeElementTypeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getLocalModifiedAttributeElementType()
	 * @generated
	 */
	int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>Local Modified Attribute Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP = MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING = MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Local Modified Attribute Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeMatcherSourceElementImpl <em>Attribute Matcher Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeMatcherSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMatcherSourceElement()
	 * @generated
	 */
	int ATTRIBUTE_MATCHER_SOURCE_ELEMENT = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_SOURCE_ELEMENT__NAME = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_SOURCE_ELEMENT__SOURCE = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_SOURCE_ELEMENT__MODIFIER = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>Attribute Matcher Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_SOURCE_ELEMENT_FEATURE_COUNT = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_SOURCE_ELEMENT___GET_MAPPING = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Matcher Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_SOURCE_ELEMENT_OPERATION_COUNT = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.MappingHintSourceInterface <em>Hint Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.MappingHintSourceInterface
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintSourceInterface()
	 * @generated
	 */
	int MAPPING_HINT_SOURCE_INTERFACE = 35;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_SOURCE_INTERFACE__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Hint Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Hint Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingHintGroupImporterImpl <em>Hint Group Importer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingHintGroupImporterImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintGroupImporter()
	 * @generated
	 */
	int MAPPING_HINT_GROUP_IMPORTER = 19;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ExportedMappingHintGroupImpl <em>Exported Mapping Hint Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ExportedMappingHintGroupImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getExportedMappingHintGroup()
	 * @generated
	 */
	int EXPORTED_MAPPING_HINT_GROUP = 20;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ContainerSelectorImpl <em>Container Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ContainerSelectorImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getContainerSelector()
	 * @generated
	 */
	int CONTAINER_SELECTOR = 21;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeMappingSourceElementImpl <em>Attribute Mapping Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeMappingSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMappingSourceElement()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT = 22;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.HintImporterMappingHintImpl <em>Hint Importer Mapping Hint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.HintImporterMappingHintImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getHintImporterMappingHint()
	 * @generated
	 */
	int HINT_IMPORTER_MAPPING_HINT = 26;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappedAttributeValueExpanderImpl <em>Mapped Attribute Value Expander</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappedAttributeValueExpanderImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappedAttributeValueExpander()
	 * @generated
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER = 27;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappedAttributeValuePrependerImpl <em>Mapped Attribute Value Prepender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappedAttributeValuePrependerImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappedAttributeValuePrepender()
	 * @generated
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER = 29;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappedAttributeValueAppenderImpl <em>Mapped Attribute Value Appender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappedAttributeValueAppenderImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappedAttributeValueAppender()
	 * @generated
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER = 30;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.GlobalAttributeImpl <em>Global Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.GlobalAttributeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getGlobalAttribute()
	 * @generated
	 */
	int GLOBAL_ATTRIBUTE = 32;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.GlobalAttributeImporterImpl <em>Global Attribute Importer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.GlobalAttributeImporterImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getGlobalAttributeImporter()
	 * @generated
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER = 33;

	/**
	 * The meta object id for the '{@link pamtram.mapping.AttributeMappingSourceInterface <em>Attribute Mapping Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.AttributeMappingSourceInterface
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMappingSourceInterface()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE = 34;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ContainerSelectorSourceElementImpl <em>Container Selector Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ContainerSelectorSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getContainerSelectorSourceElement()
	 * @generated
	 */
	int CONTAINER_SELECTOR_SOURCE_ELEMENT = 23;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ContainerSelectorTargetAttributeImpl <em>Container Selector Target Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ContainerSelectorTargetAttributeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getContainerSelectorTargetAttribute()
	 * @generated
	 */
	int CONTAINER_SELECTOR_TARGET_ATTRIBUTE = 24;

	/**
	 * The meta object id for the '{@link pamtram.mapping.AttributeMatcherSourceInterface <em>Attribute Matcher Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.AttributeMatcherSourceInterface
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMatcherSourceInterface()
	 * @generated
	 */
	int ATTRIBUTE_MATCHER_SOURCE_INTERFACE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_SOURCE_INTERFACE__NAME = MAPPING_HINT_SOURCE_INTERFACE__NAME;

	/**
	 * The number of structural features of the '<em>Attribute Matcher Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_SOURCE_INTERFACE_FEATURE_COUNT = MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE = MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE;

	/**
	 * The number of operations of the '<em>Attribute Matcher Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_SOURCE_INTERFACE_OPERATION_COUNT = MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MATCHER__TARGET_CLASS = MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MATCHER_FEATURE_COUNT = MATCHER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Class Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MATCHER_OPERATION_COUNT = MATCHER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Deactivated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER__LOCAL_CONDITION = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER__SHARED_CONDITION = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Hint Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER__CONTAINER = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Mapping Hints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Hint Group Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Validate Either Model Or Refer Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Hint Group Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP__NAME = MAPPING_HINT_GROUP_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Target Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP__TARGET_SECTION = MAPPING_HINT_GROUP_TYPE__TARGET_SECTION;

	/**
	 * The feature id for the '<em><b>Mapping Hints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP__MAPPING_HINTS = MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS;

	/**
	 * The feature id for the '<em><b>Extend</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP__EXTEND = MAPPING_HINT_GROUP_TYPE__EXTEND;

	/**
	 * The number of structural features of the '<em>Exported Mapping Hint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP_FEATURE_COUNT = MAPPING_HINT_GROUP_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Exported Mapping Hint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP_OPERATION_COUNT = MAPPING_HINT_GROUP_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR__NAME = MAPPING_HINT_BASE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Target Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR__TARGET_ATTRIBUTES = MAPPING_HINT_BASE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR__SOURCE_ELEMENTS = MAPPING_HINT_BASE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Container Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_FEATURE_COUNT = MAPPING_HINT_BASE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Source Attributes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR___GET_SOURCE_ATTRIBUTES = MAPPING_HINT_BASE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Local Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS = MAPPING_HINT_BASE_TYPE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get External Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS = MAPPING_HINT_BASE_TYPE_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Container Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_OPERATION_COUNT = MAPPING_HINT_BASE_TYPE_OPERATION_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT__NAME = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT__SOURCE = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT__MODIFIER = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>Attribute Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_FEATURE_COUNT = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT___GET_MAPPING = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_SOURCE_ELEMENT__NAME = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_SOURCE_ELEMENT__SOURCE = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_SOURCE_ELEMENT__MODIFIER = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>Container Selector Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_SOURCE_ELEMENT_FEATURE_COUNT = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_SOURCE_ELEMENT___GET_MAPPING = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Container Selector Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_SOURCE_ELEMENT_OPERATION_COUNT = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_TARGET_ATTRIBUTE__NAME = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_TARGET_ATTRIBUTE__SOURCE = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_TARGET_ATTRIBUTE__MODIFIER = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>Container Selector Target Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_TARGET_ATTRIBUTE_FEATURE_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_TARGET_ATTRIBUTE___GET_MAPPING_HINT_GROUP = MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_TARGET_ATTRIBUTE___GET_MAPPING = MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Matches Possible Container Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_TARGET_ATTRIBUTE___VALIDATE_SOURCE_MATCHES_POSSIBLE_CONTAINER_TYPE__DIAGNOSTICCHAIN_MAP = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Container Selector Target Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_TARGET_ATTRIBUTE_OPERATION_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HINT_IMPORTER_MAPPING_HINT__NAME = MAPPING_HINT_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Hint Importer Mapping Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HINT_IMPORTER_MAPPING_HINT_FEATURE_COUNT = MAPPING_HINT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Hint Importer Mapping Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HINT_IMPORTER_MAPPING_HINT_OPERATION_COUNT = MAPPING_HINT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME = HINT_IMPORTER_MAPPING_HINT__NAME;

	/**
	 * The feature id for the '<em><b>Hints To Expand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND = HINT_IMPORTER_MAPPING_HINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapped Attribute Value Expander</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER_FEATURE_COUNT = HINT_IMPORTER_MAPPING_HINT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE = HINT_IMPORTER_MAPPING_HINT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Modifiers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MODIFIERS = HINT_IMPORTER_MAPPING_HINT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mapped Attribute Value Expander</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT = HINT_IMPORTER_MAPPING_HINT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.LocalMappedAttributeValueExpanderImpl <em>Local Mapped Attribute Value Expander</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.LocalMappedAttributeValueExpanderImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getLocalMappedAttributeValueExpander()
	 * @generated
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIER = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The feature id for the '<em><b>Hints To Expand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Local Mapped Attribute Value Expander</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_FEATURE_COUNT = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING_HINT_GROUP = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Modifiers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MODIFIERS = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Local Mapped Attribute Value Expander</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER__NAME = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER__SOURCE = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER__MODIFIER = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIER;

	/**
	 * The feature id for the '<em><b>Hints To Expand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER__HINTS_TO_EXPAND = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND;

	/**
	 * The number of structural features of the '<em>Mapped Attribute Value Prepender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER_FEATURE_COUNT = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER___GET_MAPPING_HINT_GROUP = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER___GET_MAPPING = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER___GET_SOURCE_ATTRIBUTE = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE;

	/**
	 * The operation id for the '<em>Get Modifiers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER___GET_MODIFIERS = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MODIFIERS;

	/**
	 * The number of operations of the '<em>Mapped Attribute Value Prepender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER_OPERATION_COUNT = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER__NAME = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER__SOURCE = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER__MODIFIER = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIER;

	/**
	 * The feature id for the '<em><b>Hints To Expand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER__HINTS_TO_EXPAND = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND;

	/**
	 * The number of structural features of the '<em>Mapped Attribute Value Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER_FEATURE_COUNT = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER___GET_MAPPING_HINT_GROUP = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER___GET_MAPPING = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER___GET_SOURCE_ATTRIBUTE = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE;

	/**
	 * The operation id for the '<em>Get Modifiers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER___GET_MODIFIERS = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MODIFIERS;

	/**
	 * The number of operations of the '<em>Mapped Attribute Value Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER_OPERATION_COUNT = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.FixedValueImpl <em>Fixed Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.FixedValueImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getFixedValue()
	 * @generated
	 */
	int FIXED_VALUE = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_VALUE__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_VALUE__VALUE = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fixed Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_VALUE_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_VALUE___GET_SOURCE_ATTRIBUTE = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fixed Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_VALUE_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE__SOURCE = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE__MODIFIER = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Global Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Source Attribute Has Upper Bound One</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE___VALIDATE_SOURCE_ATTRIBUTE_HAS_UPPER_BOUND_ONE__DIAGNOSTICCHAIN_MAP = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Global Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Global Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Global Attribute Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER___GET_SOURCE_ATTRIBUTE = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Global Attribute Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE__NAME = MAPPING_HINT_SOURCE_INTERFACE__NAME;

	/**
	 * The number of structural features of the '<em>Attribute Mapping Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE_FEATURE_COUNT = MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE = MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE;

	/**
	 * The number of operations of the '<em>Attribute Mapping Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE_OPERATION_COUNT = MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.ContainerSelectorSourceInterface <em>Container Selector Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.ContainerSelectorSourceInterface
	 * @see pamtram.mapping.impl.MappingPackageImpl#getContainerSelectorSourceInterface()
	 * @generated
	 */
	int CONTAINER_SELECTOR_SOURCE_INTERFACE = 36;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_SOURCE_INTERFACE__NAME = MAPPING_HINT_SOURCE_INTERFACE__NAME;

	/**
	 * The number of structural features of the '<em>Container Selector Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_SOURCE_INTERFACE_FEATURE_COUNT = MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE = MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE;

	/**
	 * The number of operations of the '<em>Container Selector Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_SOURCE_INTERFACE_OPERATION_COUNT = MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ExternalModifiedAttributeElementTypeImpl <em>External Modified Attribute Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ExternalModifiedAttributeElementTypeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getExternalModifiedAttributeElementType()
	 * @generated
	 */
	int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE = 38;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>External Modified Attribute Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP = MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING = MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>External Modified Attribute Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeMappingExternalSourceElementImpl <em>Attribute Mapping External Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeMappingExternalSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMappingExternalSourceElement()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT = 37;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__NAME = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__SOURCE = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__MODIFIER = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>Attribute Mapping External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT_FEATURE_COUNT = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Mapping External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT_OPERATION_COUNT = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ContainerSelectorExternalSourceElementImpl <em>Container Selector External Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ContainerSelectorExternalSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getContainerSelectorExternalSourceElement()
	 * @generated
	 */
	int CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT = 39;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT__NAME = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT__SOURCE = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT__MODIFIER = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>Container Selector External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT_FEATURE_COUNT = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Container Selector External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT_OPERATION_COUNT = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeMatcherExternalSourceElementImpl <em>Attribute Matcher External Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeMatcherExternalSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMatcherExternalSourceElement()
	 * @generated
	 */
	int ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT = 40;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT__NAME = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT__SOURCE = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT__MODIFIER = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>Attribute Matcher External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT_FEATURE_COUNT = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Matcher External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT_OPERATION_COUNT = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ExternalMappedAttributeValueExpanderImpl <em>External Mapped Attribute Value Expander</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ExternalMappedAttributeValueExpanderImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getExternalMappedAttributeValueExpander()
	 * @generated
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER = 41;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIER = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The feature id for the '<em><b>Hints To Expand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Mapped Attribute Value Expander</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_FEATURE_COUNT = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING_HINT_GROUP = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Modifiers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MODIFIERS = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>External Mapped Attribute Value Expander</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ExternalMappedAttributeValuePrependerImpl <em>External Mapped Attribute Value Prepender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ExternalMappedAttributeValuePrependerImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getExternalMappedAttributeValuePrepender()
	 * @generated
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER = 42;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER__NAME = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER__SOURCE = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER__MODIFIER = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIER;

	/**
	 * The feature id for the '<em><b>Hints To Expand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER__HINTS_TO_EXPAND = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND;

	/**
	 * The number of structural features of the '<em>External Mapped Attribute Value Prepender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER_FEATURE_COUNT = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER___GET_MAPPING_HINT_GROUP = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER___GET_MAPPING = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER___GET_SOURCE_ATTRIBUTE = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE;

	/**
	 * The operation id for the '<em>Get Modifiers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER___GET_MODIFIERS = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MODIFIERS;

	/**
	 * The number of operations of the '<em>External Mapped Attribute Value Prepender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER_OPERATION_COUNT = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ExternalMappedAttributeValueAppenderImpl <em>External Mapped Attribute Value Appender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ExternalMappedAttributeValueAppenderImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getExternalMappedAttributeValueAppender()
	 * @generated
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER = 43;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER__NAME = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER__SOURCE = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER__MODIFIER = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIER;

	/**
	 * The feature id for the '<em><b>Hints To Expand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER__HINTS_TO_EXPAND = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND;

	/**
	 * The number of structural features of the '<em>External Mapped Attribute Value Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER_FEATURE_COUNT = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER___GET_MAPPING_HINT_GROUP = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER___GET_MAPPING = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER___GET_SOURCE_ATTRIBUTE = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE;

	/**
	 * The operation id for the '<em>Get Modifiers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER___GET_MODIFIERS = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MODIFIERS;

	/**
	 * The number of operations of the '<em>External Mapped Attribute Value Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER_OPERATION_COUNT = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.ExpandableHint <em>Expandable Hint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.ExpandableHint
	 * @see pamtram.mapping.impl.MappingPackageImpl#getExpandableHint()
	 * @generated
	 */
	int EXPANDABLE_HINT = 44;

	/**
	 * The number of structural features of the '<em>Expandable Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDABLE_HINT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Expandable Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDABLE_HINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.GlobalModifiedAttributeElementTypeImpl <em>Global Modified Attribute Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.GlobalModifiedAttributeElementTypeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getGlobalModifiedAttributeElementType()
	 * @generated
	 */
	int GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE = 45;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The feature id for the '<em><b>Instance Selector</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__INSTANCE_SELECTOR = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Global Modified Attribute Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP = MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING = MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The number of operations of the '<em>Global Modified Attribute Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeMatcherGlobalSourceElementImpl <em>Attribute Matcher Global Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeMatcherGlobalSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMatcherGlobalSourceElement()
	 * @generated
	 */
	int ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT = 46;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT__NAME = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT__SOURCE = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT__MODIFIER = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The feature id for the '<em><b>Instance Selector</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT__INSTANCE_SELECTOR = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__INSTANCE_SELECTOR;

	/**
	 * The number of structural features of the '<em>Attribute Matcher Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT_FEATURE_COUNT = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT___GET_MAPPING = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Matcher Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT_OPERATION_COUNT = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeMappingGlobalSourceElementImpl <em>Attribute Mapping Global Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeMappingGlobalSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMappingGlobalSourceElement()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT = 47;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT__NAME = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT__SOURCE = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT__MODIFIER = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The feature id for the '<em><b>Instance Selector</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT__INSTANCE_SELECTOR = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__INSTANCE_SELECTOR;

	/**
	 * The number of structural features of the '<em>Attribute Mapping Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT_FEATURE_COUNT = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT___GET_MAPPING = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Mapping Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT_OPERATION_COUNT = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ContainerSelectorGlobalSourceElementImpl <em>Container Selector Global Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ContainerSelectorGlobalSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getContainerSelectorGlobalSourceElement()
	 * @generated
	 */
	int CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT = 48;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT__NAME = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT__SOURCE = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT__MODIFIER = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The feature id for the '<em><b>Instance Selector</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT__INSTANCE_SELECTOR = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__INSTANCE_SELECTOR;

	/**
	 * The number of structural features of the '<em>Container Selector Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT_FEATURE_COUNT = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT___GET_MAPPING = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Container Selector Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT_OPERATION_COUNT = GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see pamtram.mapping.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.Mapping#getMappingHintGroups <em>Mapping Hint Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Hint Groups</em>'.
	 * @see pamtram.mapping.Mapping#getMappingHintGroups()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_MappingHintGroups();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.Mapping#getImportedMappingHintGroups <em>Imported Mapping Hint Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imported Mapping Hint Groups</em>'.
	 * @see pamtram.mapping.Mapping#getImportedMappingHintGroups()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_ImportedMappingHintGroups();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.Mapping#getGlobalVariables <em>Global Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Global Variables</em>'.
	 * @see pamtram.mapping.Mapping#getGlobalVariables()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_GlobalVariables();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.Mapping#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see pamtram.mapping.Mapping#isAbstract()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_Abstract();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.Mapping#getActiveMappingHintGroups() <em>Get Active Mapping Hint Groups</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Active Mapping Hint Groups</em>' operation.
	 * @see pamtram.mapping.Mapping#getActiveMappingHintGroups()
	 * @generated
	 */
	EOperation getMapping__GetActiveMappingHintGroups();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.Mapping#getActiveImportedMappingHintGroups() <em>Get Active Imported Mapping Hint Groups</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Active Imported Mapping Hint Groups</em>' operation.
	 * @see pamtram.mapping.Mapping#getActiveImportedMappingHintGroups()
	 * @generated
	 */
	EOperation getMapping__GetActiveImportedMappingHintGroups();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.Mapping#validateContainsHintGroups(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Contains Hint Groups</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Contains Hint Groups</em>' operation.
	 * @see pamtram.mapping.Mapping#validateContainsHintGroups(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMapping__ValidateContainsHintGroups__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.Mapping#validateContainsDeactivatedHintGroups(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Contains Deactivated Hint Groups</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Contains Deactivated Hint Groups</em>' operation.
	 * @see pamtram.mapping.Mapping#validateContainsDeactivatedHintGroups(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMapping__ValidateContainsDeactivatedHintGroups__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.MappingType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see pamtram.mapping.MappingType
	 * @generated
	 */
	EClass getMappingType();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.MappingType#getSourceSection <em>Source Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Section</em>'.
	 * @see pamtram.mapping.MappingType#getSourceSection()
	 * @see #getMappingType()
	 * @generated
	 */
	EReference getMappingType_SourceSection();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.MappingHint <em>Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hint</em>'.
	 * @see pamtram.mapping.MappingHint
	 * @generated
	 */
	EClass getMappingHint();

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
	 * Returns the meta object for the reference list '{@link pamtram.ModifiableElement#getResultModifier <em>Result Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Result Modifier</em>'.
	 * @see pamtram.ModifiableElement#getResultModifier()
	 * @see #getModifiableElement()
	 * @generated
	 */
	EReference getModifiableElement_ResultModifier();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.AttributeMapping <em>Attribute Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Mapping</em>'.
	 * @see pamtram.mapping.AttributeMapping
	 * @generated
	 */
	EClass getAttributeMapping();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.AttributeMapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see pamtram.mapping.AttributeMapping#getTarget()
	 * @see #getAttributeMapping()
	 * @generated
	 */
	EReference getAttributeMapping_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.AttributeMapping#getSourceElements <em>Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Elements</em>'.
	 * @see pamtram.mapping.AttributeMapping#getSourceElements()
	 * @see #getAttributeMapping()
	 * @generated
	 */
	EReference getAttributeMapping_SourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.AttributeMapping#getLocalSourceElements() <em>Get Local Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Local Source Elements</em>' operation.
	 * @see pamtram.mapping.AttributeMapping#getLocalSourceElements()
	 * @generated
	 */
	EOperation getAttributeMapping__GetLocalSourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.AttributeMapping#getExternalSourceElements() <em>Get External Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get External Source Elements</em>' operation.
	 * @see pamtram.mapping.AttributeMapping#getExternalSourceElements()
	 * @generated
	 */
	EOperation getAttributeMapping__GetExternalSourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.AttributeMapping#validateTargetAttributeMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Attribute Matches Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Attribute Matches Section</em>' operation.
	 * @see pamtram.mapping.AttributeMapping#validateTargetAttributeMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getAttributeMapping__ValidateTargetAttributeMatchesSection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.CardinalityMapping <em>Cardinality Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cardinality Mapping</em>'.
	 * @see pamtram.mapping.CardinalityMapping
	 * @generated
	 */
	EClass getCardinalityMapping();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.CardinalityMapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see pamtram.mapping.CardinalityMapping#getSource()
	 * @see #getCardinalityMapping()
	 * @generated
	 */
	EReference getCardinalityMapping_Source();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.CardinalityMapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see pamtram.mapping.CardinalityMapping#getTarget()
	 * @see #getCardinalityMapping()
	 * @generated
	 */
	EReference getCardinalityMapping_Target();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.CardinalityMapping#validateSourceClassMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Class Matches Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Class Matches Section</em>' operation.
	 * @see pamtram.mapping.CardinalityMapping#validateSourceClassMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCardinalityMapping__ValidateSourceClassMatchesSection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.CardinalityMapping#validateTargetClassMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Class Matches Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Class Matches Section</em>' operation.
	 * @see pamtram.mapping.CardinalityMapping#validateTargetClassMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCardinalityMapping__ValidateTargetClassMatchesSection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.CardinalityMapping#validateSourceClassIsVariableCardinality(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Class Is Variable Cardinality</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Class Is Variable Cardinality</em>' operation.
	 * @see pamtram.mapping.CardinalityMapping#validateSourceClassIsVariableCardinality(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCardinalityMapping__ValidateSourceClassIsVariableCardinality__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.CardinalityMapping#validateTargetClassIsVariableCardinality(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Class Is Variable Cardinality</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Class Is Variable Cardinality</em>' operation.
	 * @see pamtram.mapping.CardinalityMapping#validateTargetClassIsVariableCardinality(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCardinalityMapping__ValidateTargetClassIsVariableCardinality__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.CardinalityMapping#validateNoCardinalityMappingForSourceSectionRoot(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Cardinality Mapping For Source Section Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate No Cardinality Mapping For Source Section Root</em>' operation.
	 * @see pamtram.mapping.CardinalityMapping#validateNoCardinalityMappingForSourceSectionRoot(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCardinalityMapping__ValidateNoCardinalityMappingForSourceSectionRoot__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ReferenceTargetSelector <em>Reference Target Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Target Selector</em>'.
	 * @see pamtram.mapping.ReferenceTargetSelector
	 * @generated
	 */
	EClass getReferenceTargetSelector();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.ReferenceTargetSelector#getAffectedReference <em>Affected Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Affected Reference</em>'.
	 * @see pamtram.mapping.ReferenceTargetSelector#getAffectedReference()
	 * @see #getReferenceTargetSelector()
	 * @generated
	 */
	EReference getReferenceTargetSelector_AffectedReference();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.mapping.ReferenceTargetSelector#getMatcher <em>Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Matcher</em>'.
	 * @see pamtram.mapping.ReferenceTargetSelector#getMatcher()
	 * @see #getReferenceTargetSelector()
	 * @generated
	 */
	EReference getReferenceTargetSelector_Matcher();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.ReferenceTargetSelector#validateAffectedReferenceIsNonContainment(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Affected Reference Is Non Containment</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Affected Reference Is Non Containment</em>' operation.
	 * @see pamtram.mapping.ReferenceTargetSelector#validateAffectedReferenceIsNonContainment(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getReferenceTargetSelector__ValidateAffectedReferenceIsNonContainment__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.ReferenceTargetSelector#validateAffectedReferenceMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Affected Reference Matches Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Affected Reference Matches Section</em>' operation.
	 * @see pamtram.mapping.ReferenceTargetSelector#validateAffectedReferenceMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getReferenceTargetSelector__ValidateAffectedReferenceMatchesSection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.Matcher <em>Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Matcher</em>'.
	 * @see pamtram.mapping.Matcher
	 * @generated
	 */
	EClass getMatcher();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.AttributeMatcher <em>Attribute Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Matcher</em>'.
	 * @see pamtram.mapping.AttributeMatcher
	 * @generated
	 */
	EClass getAttributeMatcher();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.AttributeMatcher#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see pamtram.mapping.AttributeMatcher#getTarget()
	 * @see #getAttributeMatcher()
	 * @generated
	 */
	EReference getAttributeMatcher_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.AttributeMatcher#getSourceElements <em>Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Elements</em>'.
	 * @see pamtram.mapping.AttributeMatcher#getSourceElements()
	 * @see #getAttributeMatcher()
	 * @generated
	 */
	EReference getAttributeMatcher_SourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.AttributeMatcher#getLocalSourceElements() <em>Get Local Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Local Source Elements</em>' operation.
	 * @see pamtram.mapping.AttributeMatcher#getLocalSourceElements()
	 * @generated
	 */
	EOperation getAttributeMatcher__GetLocalSourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.AttributeMatcher#getExternalSourceElements() <em>Get External Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get External Source Elements</em>' operation.
	 * @see pamtram.mapping.AttributeMatcher#getExternalSourceElements()
	 * @generated
	 */
	EOperation getAttributeMatcher__GetExternalSourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.AttributeMatcher#validateTargetMatchesAffectedReferenceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Matches Affected Reference Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Matches Affected Reference Type</em>' operation.
	 * @see pamtram.mapping.AttributeMatcher#validateTargetMatchesAffectedReferenceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getAttributeMatcher__ValidateTargetMatchesAffectedReferenceType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.AttributeMatcherSourceElement <em>Attribute Matcher Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Matcher Source Element</em>'.
	 * @see pamtram.mapping.AttributeMatcherSourceElement
	 * @generated
	 */
	EClass getAttributeMatcherSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.AttributeMatcherSourceInterface <em>Attribute Matcher Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Matcher Source Interface</em>'.
	 * @see pamtram.mapping.AttributeMatcherSourceInterface
	 * @generated
	 */
	EClass getAttributeMatcherSourceInterface();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ClassMatcher <em>Class Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Matcher</em>'.
	 * @see pamtram.mapping.ClassMatcher
	 * @generated
	 */
	EClass getClassMatcher();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.ClassMatcher#getTargetClass <em>Target Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Class</em>'.
	 * @see pamtram.mapping.ClassMatcher#getTargetClass()
	 * @see #getClassMatcher()
	 * @generated
	 */
	EReference getClassMatcher_TargetClass();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ModifiedAttributeElementType <em>Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modified Attribute Element Type</em>'.
	 * @see pamtram.mapping.ModifiedAttributeElementType
	 * @generated
	 */
	EClass getModifiedAttributeElementType();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.ModifiedAttributeElementType#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see pamtram.mapping.ModifiedAttributeElementType#getSource()
	 * @see #getModifiedAttributeElementType()
	 * @generated
	 */
	EReference getModifiedAttributeElementType_Source();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.mapping.ModifiedAttributeElementType#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Modifier</em>'.
	 * @see pamtram.mapping.ModifiedAttributeElementType#getModifier()
	 * @see #getModifiedAttributeElementType()
	 * @generated
	 */
	EReference getModifiedAttributeElementType_Modifier();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.ModifiedAttributeElementType#getMappingHintGroup() <em>Get Mapping Hint Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Mapping Hint Group</em>' operation.
	 * @see pamtram.mapping.ModifiedAttributeElementType#getMappingHintGroup()
	 * @generated
	 */
	EOperation getModifiedAttributeElementType__GetMappingHintGroup();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.ModifiedAttributeElementType#getMapping() <em>Get Mapping</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Mapping</em>' operation.
	 * @see pamtram.mapping.ModifiedAttributeElementType#getMapping()
	 * @generated
	 */
	EOperation getModifiedAttributeElementType__GetMapping();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.LocalModifiedAttributeElementType <em>Local Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Modified Attribute Element Type</em>'.
	 * @see pamtram.mapping.LocalModifiedAttributeElementType
	 * @generated
	 */
	EClass getLocalModifiedAttributeElementType();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.LocalModifiedAttributeElementType#validateSourceAttributeMatchesSectionOrContainedSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Attribute Matches Section Or Contained Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * @see pamtram.mapping.LocalModifiedAttributeElementType#validateSourceAttributeMatchesSectionOrContainedSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLocalModifiedAttributeElementType__ValidateSourceAttributeMatchesSectionOrContainedSection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.MappingHintGroup <em>Hint Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hint Group</em>'.
	 * @see pamtram.mapping.MappingHintGroup
	 * @generated
	 */
	EClass getMappingHintGroup();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.mapping.MappingHintGroup#getContainerSelector <em>Container Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Container Selector</em>'.
	 * @see pamtram.mapping.MappingHintGroup#getContainerSelector()
	 * @see #getMappingHintGroup()
	 * @generated
	 */
	EReference getMappingHintGroup_ContainerSelector();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.MappingHintBaseType <em>Hint Base Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hint Base Type</em>'.
	 * @see pamtram.mapping.MappingHintBaseType
	 * @generated
	 */
	EClass getMappingHintBaseType();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.MappingHintGroupType <em>Hint Group Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hint Group Type</em>'.
	 * @see pamtram.mapping.MappingHintGroupType
	 * @generated
	 */
	EClass getMappingHintGroupType();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.MappingHintGroupType#getTargetSection <em>Target Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Section</em>'.
	 * @see pamtram.mapping.MappingHintGroupType#getTargetSection()
	 * @see #getMappingHintGroupType()
	 * @generated
	 */
	EReference getMappingHintGroupType_TargetSection();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.MappingHintGroupType#getMappingHints <em>Mapping Hints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Hints</em>'.
	 * @see pamtram.mapping.MappingHintGroupType#getMappingHints()
	 * @see #getMappingHintGroupType()
	 * @generated
	 */
	EReference getMappingHintGroupType_MappingHints();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.mapping.MappingHintGroupType#getExtend <em>Extend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extend</em>'.
	 * @see pamtram.mapping.MappingHintGroupType#getExtend()
	 * @see #getMappingHintGroupType()
	 * @generated
	 */
	EReference getMappingHintGroupType_Extend();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.InstantiableMappingHintGroup <em>Instantiable Mapping Hint Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instantiable Mapping Hint Group</em>'.
	 * @see pamtram.mapping.InstantiableMappingHintGroup
	 * @generated
	 */
	EClass getInstantiableMappingHintGroup();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.MappingHintGroupImporter <em>Hint Group Importer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hint Group Importer</em>'.
	 * @see pamtram.mapping.MappingHintGroupImporter
	 * @generated
	 */
	EClass getMappingHintGroupImporter();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.MappingHintGroupImporter#getHintGroup <em>Hint Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Hint Group</em>'.
	 * @see pamtram.mapping.MappingHintGroupImporter#getHintGroup()
	 * @see #getMappingHintGroupImporter()
	 * @generated
	 */
	EReference getMappingHintGroupImporter_HintGroup();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.MappingHintGroupImporter#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see pamtram.mapping.MappingHintGroupImporter#getContainer()
	 * @see #getMappingHintGroupImporter()
	 * @generated
	 */
	EReference getMappingHintGroupImporter_Container();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.MappingHintGroupImporter#getMappingHints <em>Mapping Hints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Hints</em>'.
	 * @see pamtram.mapping.MappingHintGroupImporter#getMappingHints()
	 * @see #getMappingHintGroupImporter()
	 * @generated
	 */
	EReference getMappingHintGroupImporter_MappingHints();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ExportedMappingHintGroup <em>Exported Mapping Hint Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exported Mapping Hint Group</em>'.
	 * @see pamtram.mapping.ExportedMappingHintGroup
	 * @generated
	 */
	EClass getExportedMappingHintGroup();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ContainerSelector <em>Container Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Selector</em>'.
	 * @see pamtram.mapping.ContainerSelector
	 * @generated
	 */
	EClass getContainerSelector();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.ContainerSelector#getTargetAttributes <em>Target Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Attributes</em>'.
	 * @see pamtram.mapping.ContainerSelector#getTargetAttributes()
	 * @see #getContainerSelector()
	 * @generated
	 */
	EReference getContainerSelector_TargetAttributes();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.ContainerSelector#getSourceElements <em>Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Elements</em>'.
	 * @see pamtram.mapping.ContainerSelector#getSourceElements()
	 * @see #getContainerSelector()
	 * @generated
	 */
	EReference getContainerSelector_SourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.ContainerSelector#getSourceAttributes() <em>Get Source Attributes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Source Attributes</em>' operation.
	 * @see pamtram.mapping.ContainerSelector#getSourceAttributes()
	 * @generated
	 */
	EOperation getContainerSelector__GetSourceAttributes();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.ContainerSelector#getLocalSourceElements() <em>Get Local Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Local Source Elements</em>' operation.
	 * @see pamtram.mapping.ContainerSelector#getLocalSourceElements()
	 * @generated
	 */
	EOperation getContainerSelector__GetLocalSourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.ContainerSelector#getExternalSourceElements() <em>Get External Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get External Source Elements</em>' operation.
	 * @see pamtram.mapping.ContainerSelector#getExternalSourceElements()
	 * @generated
	 */
	EOperation getContainerSelector__GetExternalSourceElements();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.AttributeMappingSourceElement <em>Attribute Mapping Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Mapping Source Element</em>'.
	 * @see pamtram.mapping.AttributeMappingSourceElement
	 * @generated
	 */
	EClass getAttributeMappingSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ContainerSelectorSourceElement <em>Container Selector Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Selector Source Element</em>'.
	 * @see pamtram.mapping.ContainerSelectorSourceElement
	 * @generated
	 */
	EClass getContainerSelectorSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ContainerSelectorTargetAttribute <em>Container Selector Target Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Selector Target Attribute</em>'.
	 * @see pamtram.mapping.ContainerSelectorTargetAttribute
	 * @generated
	 */
	EClass getContainerSelectorTargetAttribute();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.ContainerSelectorTargetAttribute#validateSourceMatchesPossibleContainerType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Matches Possible Container Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Matches Possible Container Type</em>' operation.
	 * @see pamtram.mapping.ContainerSelectorTargetAttribute#validateSourceMatchesPossibleContainerType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getContainerSelectorTargetAttribute__ValidateSourceMatchesPossibleContainerType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.MappingHintType <em>Hint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hint Type</em>'.
	 * @see pamtram.mapping.MappingHintType
	 * @generated
	 */
	EClass getMappingHintType();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.HintImporterMappingHint <em>Hint Importer Mapping Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hint Importer Mapping Hint</em>'.
	 * @see pamtram.mapping.HintImporterMappingHint
	 * @generated
	 */
	EClass getHintImporterMappingHint();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.MappedAttributeValueExpander <em>Mapped Attribute Value Expander</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Attribute Value Expander</em>'.
	 * @see pamtram.mapping.MappedAttributeValueExpander
	 * @generated
	 */
	EClass getMappedAttributeValueExpander();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.mapping.MappedAttributeValueExpander#getHintsToExpand <em>Hints To Expand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Hints To Expand</em>'.
	 * @see pamtram.mapping.MappedAttributeValueExpander#getHintsToExpand()
	 * @see #getMappedAttributeValueExpander()
	 * @generated
	 */
	EReference getMappedAttributeValueExpander_HintsToExpand();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.MappedAttributeValueExpander#getSourceAttribute() <em>Get Source Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Source Attribute</em>' operation.
	 * @see pamtram.mapping.MappedAttributeValueExpander#getSourceAttribute()
	 * @generated
	 */
	EOperation getMappedAttributeValueExpander__GetSourceAttribute();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.MappedAttributeValueExpander#getModifiers() <em>Get Modifiers</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Modifiers</em>' operation.
	 * @see pamtram.mapping.MappedAttributeValueExpander#getModifiers()
	 * @generated
	 */
	EOperation getMappedAttributeValueExpander__GetModifiers();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.LocalMappedAttributeValueExpander <em>Local Mapped Attribute Value Expander</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Mapped Attribute Value Expander</em>'.
	 * @see pamtram.mapping.LocalMappedAttributeValueExpander
	 * @generated
	 */
	EClass getLocalMappedAttributeValueExpander();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.MappedAttributeValuePrepender <em>Mapped Attribute Value Prepender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Attribute Value Prepender</em>'.
	 * @see pamtram.mapping.MappedAttributeValuePrepender
	 * @generated
	 */
	EClass getMappedAttributeValuePrepender();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.MappedAttributeValueAppender <em>Mapped Attribute Value Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Attribute Value Appender</em>'.
	 * @see pamtram.mapping.MappedAttributeValueAppender
	 * @generated
	 */
	EClass getMappedAttributeValueAppender();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.FixedValue <em>Fixed Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Value</em>'.
	 * @see pamtram.mapping.FixedValue
	 * @generated
	 */
	EClass getFixedValue();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.FixedValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see pamtram.mapping.FixedValue#getValue()
	 * @see #getFixedValue()
	 * @generated
	 */
	EAttribute getFixedValue_Value();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.GlobalAttribute <em>Global Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Attribute</em>'.
	 * @see pamtram.mapping.GlobalAttribute
	 * @generated
	 */
	EClass getGlobalAttribute();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.GlobalAttribute#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see pamtram.mapping.GlobalAttribute#getSource()
	 * @see #getGlobalAttribute()
	 * @generated
	 */
	EReference getGlobalAttribute_Source();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.mapping.GlobalAttribute#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Modifier</em>'.
	 * @see pamtram.mapping.GlobalAttribute#getModifier()
	 * @see #getGlobalAttribute()
	 * @generated
	 */
	EReference getGlobalAttribute_Modifier();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.GlobalAttribute#validateSourceAttributeHasUpperBoundOne(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Attribute Has Upper Bound One</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Attribute Has Upper Bound One</em>' operation.
	 * @see pamtram.mapping.GlobalAttribute#validateSourceAttributeHasUpperBoundOne(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getGlobalAttribute__ValidateSourceAttributeHasUpperBoundOne__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.GlobalAttributeImporter <em>Global Attribute Importer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Attribute Importer</em>'.
	 * @see pamtram.mapping.GlobalAttributeImporter
	 * @generated
	 */
	EClass getGlobalAttributeImporter();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.GlobalAttributeImporter#getGlobalAttribute <em>Global Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Global Attribute</em>'.
	 * @see pamtram.mapping.GlobalAttributeImporter#getGlobalAttribute()
	 * @see #getGlobalAttributeImporter()
	 * @generated
	 */
	EReference getGlobalAttributeImporter_GlobalAttribute();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.AttributeMappingSourceInterface <em>Attribute Mapping Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Mapping Source Interface</em>'.
	 * @see pamtram.mapping.AttributeMappingSourceInterface
	 * @generated
	 */
	EClass getAttributeMappingSourceInterface();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.MappingHintSourceInterface <em>Hint Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hint Source Interface</em>'.
	 * @see pamtram.mapping.MappingHintSourceInterface
	 * @generated
	 */
	EClass getMappingHintSourceInterface();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.MappingHintSourceInterface#getSourceAttribute() <em>Get Source Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Source Attribute</em>' operation.
	 * @see pamtram.mapping.MappingHintSourceInterface#getSourceAttribute()
	 * @generated
	 */
	EOperation getMappingHintSourceInterface__GetSourceAttribute();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ContainerSelectorSourceInterface <em>Container Selector Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Selector Source Interface</em>'.
	 * @see pamtram.mapping.ContainerSelectorSourceInterface
	 * @generated
	 */
	EClass getContainerSelectorSourceInterface();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.AttributeMappingExternalSourceElement <em>Attribute Mapping External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Mapping External Source Element</em>'.
	 * @see pamtram.mapping.AttributeMappingExternalSourceElement
	 * @generated
	 */
	EClass getAttributeMappingExternalSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ExternalModifiedAttributeElementType <em>External Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Modified Attribute Element Type</em>'.
	 * @see pamtram.mapping.ExternalModifiedAttributeElementType
	 * @generated
	 */
	EClass getExternalModifiedAttributeElementType();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.ExternalModifiedAttributeElementType#validateSourceAttributeMatchesContainerSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Attribute Matches Container Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * @see pamtram.mapping.ExternalModifiedAttributeElementType#validateSourceAttributeMatchesContainerSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getExternalModifiedAttributeElementType__ValidateSourceAttributeMatchesContainerSection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ContainerSelectorExternalSourceElement <em>Container Selector External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Selector External Source Element</em>'.
	 * @see pamtram.mapping.ContainerSelectorExternalSourceElement
	 * @generated
	 */
	EClass getContainerSelectorExternalSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.AttributeMatcherExternalSourceElement <em>Attribute Matcher External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Matcher External Source Element</em>'.
	 * @see pamtram.mapping.AttributeMatcherExternalSourceElement
	 * @generated
	 */
	EClass getAttributeMatcherExternalSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ExternalMappedAttributeValueExpander <em>External Mapped Attribute Value Expander</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Mapped Attribute Value Expander</em>'.
	 * @see pamtram.mapping.ExternalMappedAttributeValueExpander
	 * @generated
	 */
	EClass getExternalMappedAttributeValueExpander();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ExternalMappedAttributeValuePrepender <em>External Mapped Attribute Value Prepender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Mapped Attribute Value Prepender</em>'.
	 * @see pamtram.mapping.ExternalMappedAttributeValuePrepender
	 * @generated
	 */
	EClass getExternalMappedAttributeValuePrepender();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ExternalMappedAttributeValueAppender <em>External Mapped Attribute Value Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Mapped Attribute Value Appender</em>'.
	 * @see pamtram.mapping.ExternalMappedAttributeValueAppender
	 * @generated
	 */
	EClass getExternalMappedAttributeValueAppender();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ExpandableHint <em>Expandable Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expandable Hint</em>'.
	 * @see pamtram.mapping.ExpandableHint
	 * @generated
	 */
	EClass getExpandableHint();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.GlobalModifiedAttributeElementType <em>Global Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Modified Attribute Element Type</em>'.
	 * @see pamtram.mapping.GlobalModifiedAttributeElementType
	 * @generated
	 */
	EClass getGlobalModifiedAttributeElementType();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.GlobalModifiedAttributeElementType#getInstanceSelector <em>Instance Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instance Selector</em>'.
	 * @see pamtram.mapping.GlobalModifiedAttributeElementType#getInstanceSelector()
	 * @see #getGlobalModifiedAttributeElementType()
	 * @generated
	 */
	EReference getGlobalModifiedAttributeElementType_InstanceSelector();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.AttributeMatcherGlobalSourceElement <em>Attribute Matcher Global Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Matcher Global Source Element</em>'.
	 * @see pamtram.mapping.AttributeMatcherGlobalSourceElement
	 * @generated
	 */
	EClass getAttributeMatcherGlobalSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.AttributeMappingGlobalSourceElement <em>Attribute Mapping Global Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Mapping Global Source Element</em>'.
	 * @see pamtram.mapping.AttributeMappingGlobalSourceElement
	 * @generated
	 */
	EClass getAttributeMappingGlobalSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ContainerSelectorGlobalSourceElement <em>Container Selector Global Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Selector Global Source Element</em>'.
	 * @see pamtram.mapping.ContainerSelectorGlobalSourceElement
	 * @generated
	 */
	EClass getContainerSelectorGlobalSourceElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MappingFactory getMappingFactory();

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
		 * The meta object literal for the '{@link pamtram.mapping.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MappingImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Mapping Hint Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__MAPPING_HINT_GROUPS = eINSTANCE.getMapping_MappingHintGroups();

		/**
		 * The meta object literal for the '<em><b>Imported Mapping Hint Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__IMPORTED_MAPPING_HINT_GROUPS = eINSTANCE.getMapping_ImportedMappingHintGroups();

		/**
		 * The meta object literal for the '<em><b>Global Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__GLOBAL_VARIABLES = eINSTANCE.getMapping_GlobalVariables();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING__ABSTRACT = eINSTANCE.getMapping_Abstract();

		/**
		 * The meta object literal for the '<em><b>Get Active Mapping Hint Groups</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___GET_ACTIVE_MAPPING_HINT_GROUPS = eINSTANCE.getMapping__GetActiveMappingHintGroups();

		/**
		 * The meta object literal for the '<em><b>Get Active Imported Mapping Hint Groups</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___GET_ACTIVE_IMPORTED_MAPPING_HINT_GROUPS = eINSTANCE.getMapping__GetActiveImportedMappingHintGroups();

		/**
		 * The meta object literal for the '<em><b>Validate Contains Hint Groups</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___VALIDATE_CONTAINS_HINT_GROUPS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMapping__ValidateContainsHintGroups__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Contains Deactivated Hint Groups</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___VALIDATE_CONTAINS_DEACTIVATED_HINT_GROUPS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMapping__ValidateContainsDeactivatedHintGroups__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.MappingTypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MappingTypeImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingType()
		 * @generated
		 */
		EClass MAPPING_TYPE = eINSTANCE.getMappingType();

		/**
		 * The meta object literal for the '<em><b>Source Section</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_TYPE__SOURCE_SECTION = eINSTANCE.getMappingType_SourceSection();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.MappingHintImpl <em>Hint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MappingHintImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHint()
		 * @generated
		 */
		EClass MAPPING_HINT = eINSTANCE.getMappingHint();

		/**
		 * The meta object literal for the '{@link pamtram.impl.ExpressionElementImpl <em>Expression Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.impl.ExpressionElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getExpressionElement()
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
		 * @see pamtram.mapping.impl.MappingPackageImpl#getModifiableElement()
		 * @generated
		 */
		EClass MODIFIABLE_ELEMENT = eINSTANCE.getModifiableElement();

		/**
		 * The meta object literal for the '<em><b>Result Modifier</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFIABLE_ELEMENT__RESULT_MODIFIER = eINSTANCE.getModifiableElement_ResultModifier();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.AttributeMappingImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMapping()
		 * @generated
		 */
		EClass ATTRIBUTE_MAPPING = eINSTANCE.getAttributeMapping();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MAPPING__TARGET = eINSTANCE.getAttributeMapping_Target();

		/**
		 * The meta object literal for the '<em><b>Source Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MAPPING__SOURCE_ELEMENTS = eINSTANCE.getAttributeMapping_SourceElements();

		/**
		 * The meta object literal for the '<em><b>Get Local Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_MAPPING___GET_LOCAL_SOURCE_ELEMENTS = eINSTANCE.getAttributeMapping__GetLocalSourceElements();

		/**
		 * The meta object literal for the '<em><b>Get External Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_MAPPING___GET_EXTERNAL_SOURCE_ELEMENTS = eINSTANCE.getAttributeMapping__GetExternalSourceElements();

		/**
		 * The meta object literal for the '<em><b>Validate Target Attribute Matches Section</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_MAPPING___VALIDATE_TARGET_ATTRIBUTE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getAttributeMapping__ValidateTargetAttributeMatchesSection__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.CardinalityMappingImpl <em>Cardinality Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.CardinalityMappingImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getCardinalityMapping()
		 * @generated
		 */
		EClass CARDINALITY_MAPPING = eINSTANCE.getCardinalityMapping();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CARDINALITY_MAPPING__SOURCE = eINSTANCE.getCardinalityMapping_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CARDINALITY_MAPPING__TARGET = eINSTANCE.getCardinalityMapping_Target();

		/**
		 * The meta object literal for the '<em><b>Validate Source Class Matches Section</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CARDINALITY_MAPPING___VALIDATE_SOURCE_CLASS_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCardinalityMapping__ValidateSourceClassMatchesSection__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Target Class Matches Section</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CARDINALITY_MAPPING___VALIDATE_TARGET_CLASS_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCardinalityMapping__ValidateTargetClassMatchesSection__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Source Class Is Variable Cardinality</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CARDINALITY_MAPPING___VALIDATE_SOURCE_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCardinalityMapping__ValidateSourceClassIsVariableCardinality__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Target Class Is Variable Cardinality</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CARDINALITY_MAPPING___VALIDATE_TARGET_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCardinalityMapping__ValidateTargetClassIsVariableCardinality__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate No Cardinality Mapping For Source Section Root</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CARDINALITY_MAPPING___VALIDATE_NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCardinalityMapping__ValidateNoCardinalityMappingForSourceSectionRoot__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ReferenceTargetSelectorImpl <em>Reference Target Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ReferenceTargetSelectorImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getReferenceTargetSelector()
		 * @generated
		 */
		EClass REFERENCE_TARGET_SELECTOR = eINSTANCE.getReferenceTargetSelector();

		/**
		 * The meta object literal for the '<em><b>Affected Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE = eINSTANCE.getReferenceTargetSelector_AffectedReference();

		/**
		 * The meta object literal for the '<em><b>Matcher</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_TARGET_SELECTOR__MATCHER = eINSTANCE.getReferenceTargetSelector_Matcher();

		/**
		 * The meta object literal for the '<em><b>Validate Affected Reference Is Non Containment</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REFERENCE_TARGET_SELECTOR___VALIDATE_AFFECTED_REFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getReferenceTargetSelector__ValidateAffectedReferenceIsNonContainment__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Affected Reference Matches Section</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REFERENCE_TARGET_SELECTOR___VALIDATE_AFFECTED_REFERENCE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getReferenceTargetSelector__ValidateAffectedReferenceMatchesSection__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.MatcherImpl <em>Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MatcherImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMatcher()
		 * @generated
		 */
		EClass MATCHER = eINSTANCE.getMatcher();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.AttributeMatcherImpl <em>Attribute Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.AttributeMatcherImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMatcher()
		 * @generated
		 */
		EClass ATTRIBUTE_MATCHER = eINSTANCE.getAttributeMatcher();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MATCHER__TARGET = eINSTANCE.getAttributeMatcher_Target();

		/**
		 * The meta object literal for the '<em><b>Source Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MATCHER__SOURCE_ELEMENTS = eINSTANCE.getAttributeMatcher_SourceElements();

		/**
		 * The meta object literal for the '<em><b>Get Local Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_MATCHER___GET_LOCAL_SOURCE_ELEMENTS = eINSTANCE.getAttributeMatcher__GetLocalSourceElements();

		/**
		 * The meta object literal for the '<em><b>Get External Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_MATCHER___GET_EXTERNAL_SOURCE_ELEMENTS = eINSTANCE.getAttributeMatcher__GetExternalSourceElements();

		/**
		 * The meta object literal for the '<em><b>Validate Target Matches Affected Reference Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_MATCHER___VALIDATE_TARGET_MATCHES_AFFECTED_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getAttributeMatcher__ValidateTargetMatchesAffectedReferenceType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.AttributeMatcherSourceElementImpl <em>Attribute Matcher Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.AttributeMatcherSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMatcherSourceElement()
		 * @generated
		 */
		EClass ATTRIBUTE_MATCHER_SOURCE_ELEMENT = eINSTANCE.getAttributeMatcherSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.AttributeMatcherSourceInterface <em>Attribute Matcher Source Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.AttributeMatcherSourceInterface
		 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMatcherSourceInterface()
		 * @generated
		 */
		EClass ATTRIBUTE_MATCHER_SOURCE_INTERFACE = eINSTANCE.getAttributeMatcherSourceInterface();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ClassMatcherImpl <em>Class Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ClassMatcherImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getClassMatcher()
		 * @generated
		 */
		EClass CLASS_MATCHER = eINSTANCE.getClassMatcher();

		/**
		 * The meta object literal for the '<em><b>Target Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_MATCHER__TARGET_CLASS = eINSTANCE.getClassMatcher_TargetClass();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ModifiedAttributeElementTypeImpl <em>Modified Attribute Element Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ModifiedAttributeElementTypeImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getModifiedAttributeElementType()
		 * @generated
		 */
		EClass MODIFIED_ATTRIBUTE_ELEMENT_TYPE = eINSTANCE.getModifiedAttributeElementType();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE = eINSTANCE.getModifiedAttributeElementType_Source();

		/**
		 * The meta object literal for the '<em><b>Modifier</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER = eINSTANCE.getModifiedAttributeElementType_Modifier();

		/**
		 * The meta object literal for the '<em><b>Get Mapping Hint Group</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP = eINSTANCE.getModifiedAttributeElementType__GetMappingHintGroup();

		/**
		 * The meta object literal for the '<em><b>Get Mapping</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING = eINSTANCE.getModifiedAttributeElementType__GetMapping();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.LocalModifiedAttributeElementTypeImpl <em>Local Modified Attribute Element Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.LocalModifiedAttributeElementTypeImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getLocalModifiedAttributeElementType()
		 * @generated
		 */
		EClass LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE = eINSTANCE.getLocalModifiedAttributeElementType();

		/**
		 * The meta object literal for the '<em><b>Validate Source Attribute Matches Section Or Contained Section</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLocalModifiedAttributeElementType__ValidateSourceAttributeMatchesSectionOrContainedSection__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.MappingHintGroupImpl <em>Hint Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MappingHintGroupImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintGroup()
		 * @generated
		 */
		EClass MAPPING_HINT_GROUP = eINSTANCE.getMappingHintGroup();

		/**
		 * The meta object literal for the '<em><b>Container Selector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_HINT_GROUP__CONTAINER_SELECTOR = eINSTANCE.getMappingHintGroup_ContainerSelector();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.MappingHintBaseTypeImpl <em>Hint Base Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MappingHintBaseTypeImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintBaseType()
		 * @generated
		 */
		EClass MAPPING_HINT_BASE_TYPE = eINSTANCE.getMappingHintBaseType();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.MappingHintGroupTypeImpl <em>Hint Group Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MappingHintGroupTypeImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintGroupType()
		 * @generated
		 */
		EClass MAPPING_HINT_GROUP_TYPE = eINSTANCE.getMappingHintGroupType();

		/**
		 * The meta object literal for the '<em><b>Target Section</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_HINT_GROUP_TYPE__TARGET_SECTION = eINSTANCE.getMappingHintGroupType_TargetSection();

		/**
		 * The meta object literal for the '<em><b>Mapping Hints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS = eINSTANCE.getMappingHintGroupType_MappingHints();

		/**
		 * The meta object literal for the '<em><b>Extend</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_HINT_GROUP_TYPE__EXTEND = eINSTANCE.getMappingHintGroupType_Extend();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.InstantiableMappingHintGroupImpl <em>Instantiable Mapping Hint Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.InstantiableMappingHintGroupImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getInstantiableMappingHintGroup()
		 * @generated
		 */
		EClass INSTANTIABLE_MAPPING_HINT_GROUP = eINSTANCE.getInstantiableMappingHintGroup();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.MappingHintGroupImporterImpl <em>Hint Group Importer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MappingHintGroupImporterImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintGroupImporter()
		 * @generated
		 */
		EClass MAPPING_HINT_GROUP_IMPORTER = eINSTANCE.getMappingHintGroupImporter();

		/**
		 * The meta object literal for the '<em><b>Hint Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP = eINSTANCE.getMappingHintGroupImporter_HintGroup();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_HINT_GROUP_IMPORTER__CONTAINER = eINSTANCE.getMappingHintGroupImporter_Container();

		/**
		 * The meta object literal for the '<em><b>Mapping Hints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS = eINSTANCE.getMappingHintGroupImporter_MappingHints();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ExportedMappingHintGroupImpl <em>Exported Mapping Hint Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ExportedMappingHintGroupImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getExportedMappingHintGroup()
		 * @generated
		 */
		EClass EXPORTED_MAPPING_HINT_GROUP = eINSTANCE.getExportedMappingHintGroup();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ContainerSelectorImpl <em>Container Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ContainerSelectorImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getContainerSelector()
		 * @generated
		 */
		EClass CONTAINER_SELECTOR = eINSTANCE.getContainerSelector();

		/**
		 * The meta object literal for the '<em><b>Target Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER_SELECTOR__TARGET_ATTRIBUTES = eINSTANCE.getContainerSelector_TargetAttributes();

		/**
		 * The meta object literal for the '<em><b>Source Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER_SELECTOR__SOURCE_ELEMENTS = eINSTANCE.getContainerSelector_SourceElements();

		/**
		 * The meta object literal for the '<em><b>Get Source Attributes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER_SELECTOR___GET_SOURCE_ATTRIBUTES = eINSTANCE.getContainerSelector__GetSourceAttributes();

		/**
		 * The meta object literal for the '<em><b>Get Local Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS = eINSTANCE.getContainerSelector__GetLocalSourceElements();

		/**
		 * The meta object literal for the '<em><b>Get External Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS = eINSTANCE.getContainerSelector__GetExternalSourceElements();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.AttributeMappingSourceElementImpl <em>Attribute Mapping Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.AttributeMappingSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMappingSourceElement()
		 * @generated
		 */
		EClass ATTRIBUTE_MAPPING_SOURCE_ELEMENT = eINSTANCE.getAttributeMappingSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ContainerSelectorSourceElementImpl <em>Container Selector Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ContainerSelectorSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getContainerSelectorSourceElement()
		 * @generated
		 */
		EClass CONTAINER_SELECTOR_SOURCE_ELEMENT = eINSTANCE.getContainerSelectorSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ContainerSelectorTargetAttributeImpl <em>Container Selector Target Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ContainerSelectorTargetAttributeImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getContainerSelectorTargetAttribute()
		 * @generated
		 */
		EClass CONTAINER_SELECTOR_TARGET_ATTRIBUTE = eINSTANCE.getContainerSelectorTargetAttribute();

		/**
		 * The meta object literal for the '<em><b>Validate Source Matches Possible Container Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER_SELECTOR_TARGET_ATTRIBUTE___VALIDATE_SOURCE_MATCHES_POSSIBLE_CONTAINER_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getContainerSelectorTargetAttribute__ValidateSourceMatchesPossibleContainerType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.MappingHintTypeImpl <em>Hint Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MappingHintTypeImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintType()
		 * @generated
		 */
		EClass MAPPING_HINT_TYPE = eINSTANCE.getMappingHintType();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.HintImporterMappingHintImpl <em>Hint Importer Mapping Hint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.HintImporterMappingHintImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getHintImporterMappingHint()
		 * @generated
		 */
		EClass HINT_IMPORTER_MAPPING_HINT = eINSTANCE.getHintImporterMappingHint();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.MappedAttributeValueExpanderImpl <em>Mapped Attribute Value Expander</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MappedAttributeValueExpanderImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMappedAttributeValueExpander()
		 * @generated
		 */
		EClass MAPPED_ATTRIBUTE_VALUE_EXPANDER = eINSTANCE.getMappedAttributeValueExpander();

		/**
		 * The meta object literal for the '<em><b>Hints To Expand</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND = eINSTANCE.getMappedAttributeValueExpander_HintsToExpand();

		/**
		 * The meta object literal for the '<em><b>Get Source Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE = eINSTANCE.getMappedAttributeValueExpander__GetSourceAttribute();

		/**
		 * The meta object literal for the '<em><b>Get Modifiers</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MODIFIERS = eINSTANCE.getMappedAttributeValueExpander__GetModifiers();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.LocalMappedAttributeValueExpanderImpl <em>Local Mapped Attribute Value Expander</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.LocalMappedAttributeValueExpanderImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getLocalMappedAttributeValueExpander()
		 * @generated
		 */
		EClass LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER = eINSTANCE.getLocalMappedAttributeValueExpander();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.MappedAttributeValuePrependerImpl <em>Mapped Attribute Value Prepender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MappedAttributeValuePrependerImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMappedAttributeValuePrepender()
		 * @generated
		 */
		EClass MAPPED_ATTRIBUTE_VALUE_PREPENDER = eINSTANCE.getMappedAttributeValuePrepender();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.MappedAttributeValueAppenderImpl <em>Mapped Attribute Value Appender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MappedAttributeValueAppenderImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMappedAttributeValueAppender()
		 * @generated
		 */
		EClass MAPPED_ATTRIBUTE_VALUE_APPENDER = eINSTANCE.getMappedAttributeValueAppender();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.FixedValueImpl <em>Fixed Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.FixedValueImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getFixedValue()
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

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.GlobalAttributeImpl <em>Global Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.GlobalAttributeImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getGlobalAttribute()
		 * @generated
		 */
		EClass GLOBAL_ATTRIBUTE = eINSTANCE.getGlobalAttribute();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOBAL_ATTRIBUTE__SOURCE = eINSTANCE.getGlobalAttribute_Source();

		/**
		 * The meta object literal for the '<em><b>Modifier</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOBAL_ATTRIBUTE__MODIFIER = eINSTANCE.getGlobalAttribute_Modifier();

		/**
		 * The meta object literal for the '<em><b>Validate Source Attribute Has Upper Bound One</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GLOBAL_ATTRIBUTE___VALIDATE_SOURCE_ATTRIBUTE_HAS_UPPER_BOUND_ONE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getGlobalAttribute__ValidateSourceAttributeHasUpperBoundOne__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.GlobalAttributeImporterImpl <em>Global Attribute Importer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.GlobalAttributeImporterImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getGlobalAttributeImporter()
		 * @generated
		 */
		EClass GLOBAL_ATTRIBUTE_IMPORTER = eINSTANCE.getGlobalAttributeImporter();

		/**
		 * The meta object literal for the '<em><b>Global Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE = eINSTANCE.getGlobalAttributeImporter_GlobalAttribute();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.AttributeMappingSourceInterface <em>Attribute Mapping Source Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.AttributeMappingSourceInterface
		 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMappingSourceInterface()
		 * @generated
		 */
		EClass ATTRIBUTE_MAPPING_SOURCE_INTERFACE = eINSTANCE.getAttributeMappingSourceInterface();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.MappingHintSourceInterface <em>Hint Source Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.MappingHintSourceInterface
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintSourceInterface()
		 * @generated
		 */
		EClass MAPPING_HINT_SOURCE_INTERFACE = eINSTANCE.getMappingHintSourceInterface();

		/**
		 * The meta object literal for the '<em><b>Get Source Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE = eINSTANCE.getMappingHintSourceInterface__GetSourceAttribute();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.ContainerSelectorSourceInterface <em>Container Selector Source Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.ContainerSelectorSourceInterface
		 * @see pamtram.mapping.impl.MappingPackageImpl#getContainerSelectorSourceInterface()
		 * @generated
		 */
		EClass CONTAINER_SELECTOR_SOURCE_INTERFACE = eINSTANCE.getContainerSelectorSourceInterface();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.AttributeMappingExternalSourceElementImpl <em>Attribute Mapping External Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.AttributeMappingExternalSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMappingExternalSourceElement()
		 * @generated
		 */
		EClass ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT = eINSTANCE.getAttributeMappingExternalSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ExternalModifiedAttributeElementTypeImpl <em>External Modified Attribute Element Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ExternalModifiedAttributeElementTypeImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getExternalModifiedAttributeElementType()
		 * @generated
		 */
		EClass EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE = eINSTANCE.getExternalModifiedAttributeElementType();

		/**
		 * The meta object literal for the '<em><b>Validate Source Attribute Matches Container Section</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getExternalModifiedAttributeElementType__ValidateSourceAttributeMatchesContainerSection__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ContainerSelectorExternalSourceElementImpl <em>Container Selector External Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ContainerSelectorExternalSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getContainerSelectorExternalSourceElement()
		 * @generated
		 */
		EClass CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT = eINSTANCE.getContainerSelectorExternalSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.AttributeMatcherExternalSourceElementImpl <em>Attribute Matcher External Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.AttributeMatcherExternalSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMatcherExternalSourceElement()
		 * @generated
		 */
		EClass ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT = eINSTANCE.getAttributeMatcherExternalSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ExternalMappedAttributeValueExpanderImpl <em>External Mapped Attribute Value Expander</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ExternalMappedAttributeValueExpanderImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getExternalMappedAttributeValueExpander()
		 * @generated
		 */
		EClass EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER = eINSTANCE.getExternalMappedAttributeValueExpander();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ExternalMappedAttributeValuePrependerImpl <em>External Mapped Attribute Value Prepender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ExternalMappedAttributeValuePrependerImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getExternalMappedAttributeValuePrepender()
		 * @generated
		 */
		EClass EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER = eINSTANCE.getExternalMappedAttributeValuePrepender();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ExternalMappedAttributeValueAppenderImpl <em>External Mapped Attribute Value Appender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ExternalMappedAttributeValueAppenderImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getExternalMappedAttributeValueAppender()
		 * @generated
		 */
		EClass EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER = eINSTANCE.getExternalMappedAttributeValueAppender();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.ExpandableHint <em>Expandable Hint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.ExpandableHint
		 * @see pamtram.mapping.impl.MappingPackageImpl#getExpandableHint()
		 * @generated
		 */
		EClass EXPANDABLE_HINT = eINSTANCE.getExpandableHint();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.GlobalModifiedAttributeElementTypeImpl <em>Global Modified Attribute Element Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.GlobalModifiedAttributeElementTypeImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getGlobalModifiedAttributeElementType()
		 * @generated
		 */
		EClass GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE = eINSTANCE.getGlobalModifiedAttributeElementType();

		/**
		 * The meta object literal for the '<em><b>Instance Selector</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__INSTANCE_SELECTOR = eINSTANCE.getGlobalModifiedAttributeElementType_InstanceSelector();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.AttributeMatcherGlobalSourceElementImpl <em>Attribute Matcher Global Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.AttributeMatcherGlobalSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMatcherGlobalSourceElement()
		 * @generated
		 */
		EClass ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT = eINSTANCE.getAttributeMatcherGlobalSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.AttributeMappingGlobalSourceElementImpl <em>Attribute Mapping Global Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.AttributeMappingGlobalSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMappingGlobalSourceElement()
		 * @generated
		 */
		EClass ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT = eINSTANCE.getAttributeMappingGlobalSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ContainerSelectorGlobalSourceElementImpl <em>Container Selector Global Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ContainerSelectorGlobalSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getContainerSelectorGlobalSourceElement()
		 * @generated
		 */
		EClass CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT = eINSTANCE.getContainerSelectorGlobalSourceElement();

	}

} //MappingPackage
