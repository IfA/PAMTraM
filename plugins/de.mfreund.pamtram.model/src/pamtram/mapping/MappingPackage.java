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
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__ABSTRACT = MAPPING_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = MAPPING_TYPE_FEATURE_COUNT + 5;

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
	 * The feature id for the '<em><b>Attribute Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE__ATTRIBUTE_MAPPINGS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Cardinality Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE__CARDINALITY_MAPPINGS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Reference Target Selectors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE__REFERENCE_TARGET_SELECTORS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Container Selectors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE__CONTAINER_SELECTORS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Hint Group Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Validate Extends Only Valid Hint Groups</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE___VALIDATE_EXTENDS_ONLY_VALID_HINT_GROUPS__DIAGNOSTICCHAIN_MAP = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Active Mapping Hints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE___GET_ACTIVE_MAPPING_HINTS = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Hint Group Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 2;

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
	 * The feature id for the '<em><b>Attribute Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__ATTRIBUTE_MAPPINGS = MAPPING_HINT_GROUP_TYPE__ATTRIBUTE_MAPPINGS;

	/**
	 * The feature id for the '<em><b>Cardinality Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__CARDINALITY_MAPPINGS = MAPPING_HINT_GROUP_TYPE__CARDINALITY_MAPPINGS;

	/**
	 * The feature id for the '<em><b>Reference Target Selectors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__REFERENCE_TARGET_SELECTORS = MAPPING_HINT_GROUP_TYPE__REFERENCE_TARGET_SELECTORS;

	/**
	 * The feature id for the '<em><b>Container Selectors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__CONTAINER_SELECTORS = MAPPING_HINT_GROUP_TYPE__CONTAINER_SELECTORS;

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
	 * The number of structural features of the '<em>Hint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_FEATURE_COUNT = MAPPING_HINT_GROUP_TYPE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate Extends Only Valid Hint Groups</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP___VALIDATE_EXTENDS_ONLY_VALID_HINT_GROUPS__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_GROUP_TYPE___VALIDATE_EXTENDS_ONLY_VALID_HINT_GROUPS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Active Mapping Hints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP___GET_ACTIVE_MAPPING_HINTS = MAPPING_HINT_GROUP_TYPE___GET_ACTIVE_MAPPING_HINTS;

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
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingHintGroupImporterImpl <em>Hint Group Importer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingHintGroupImporterImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintGroupImporter()
	 * @generated
	 */
	int MAPPING_HINT_GROUP_IMPORTER = 5;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ExportedMappingHintGroupImpl <em>Exported Mapping Hint Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ExportedMappingHintGroupImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getExportedMappingHintGroup()
	 * @generated
	 */
	int EXPORTED_MAPPING_HINT_GROUP = 6;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.GlobalAttributeImpl <em>Global Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.GlobalAttributeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getGlobalAttribute()
	 * @generated
	 */
	int GLOBAL_ATTRIBUTE = 7;

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
	 * The operation id for the '<em>Get Active Mapping Hints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER___GET_ACTIVE_MAPPING_HINTS = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Hint Group Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 3;

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
	 * The feature id for the '<em><b>Attribute Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP__ATTRIBUTE_MAPPINGS = MAPPING_HINT_GROUP_TYPE__ATTRIBUTE_MAPPINGS;

	/**
	 * The feature id for the '<em><b>Cardinality Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP__CARDINALITY_MAPPINGS = MAPPING_HINT_GROUP_TYPE__CARDINALITY_MAPPINGS;

	/**
	 * The feature id for the '<em><b>Reference Target Selectors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP__REFERENCE_TARGET_SELECTORS = MAPPING_HINT_GROUP_TYPE__REFERENCE_TARGET_SELECTORS;

	/**
	 * The feature id for the '<em><b>Container Selectors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP__CONTAINER_SELECTORS = MAPPING_HINT_GROUP_TYPE__CONTAINER_SELECTORS;

	/**
	 * The number of structural features of the '<em>Exported Mapping Hint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP_FEATURE_COUNT = MAPPING_HINT_GROUP_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Extends Only Valid Hint Groups</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP___VALIDATE_EXTENDS_ONLY_VALID_HINT_GROUPS__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_GROUP_TYPE___VALIDATE_EXTENDS_ONLY_VALID_HINT_GROUPS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Active Mapping Hints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP___GET_ACTIVE_MAPPING_HINTS = MAPPING_HINT_GROUP_TYPE___GET_ACTIVE_MAPPING_HINTS;

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
	int GLOBAL_ATTRIBUTE__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE__MODIFIERS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE__SOURCE = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

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
	 * Returns the meta object for class '{@link pamtram.mapping.MappingHintGroup <em>Hint Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hint Group</em>'.
	 * @see pamtram.mapping.MappingHintGroup
	 * @generated
	 */
	EClass getMappingHintGroup();

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
	 * Returns the meta object for the reference list '{@link pamtram.mapping.MappingHintGroupType#getAttributeMappings <em>Attribute Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attribute Mappings</em>'.
	 * @see pamtram.mapping.MappingHintGroupType#getAttributeMappings()
	 * @see #getMappingHintGroupType()
	 * @generated
	 */
	EReference getMappingHintGroupType_AttributeMappings();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.mapping.MappingHintGroupType#getCardinalityMappings <em>Cardinality Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Cardinality Mappings</em>'.
	 * @see pamtram.mapping.MappingHintGroupType#getCardinalityMappings()
	 * @see #getMappingHintGroupType()
	 * @generated
	 */
	EReference getMappingHintGroupType_CardinalityMappings();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.mapping.MappingHintGroupType#getReferenceTargetSelectors <em>Reference Target Selectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reference Target Selectors</em>'.
	 * @see pamtram.mapping.MappingHintGroupType#getReferenceTargetSelectors()
	 * @see #getMappingHintGroupType()
	 * @generated
	 */
	EReference getMappingHintGroupType_ReferenceTargetSelectors();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.mapping.MappingHintGroupType#getContainerSelectors <em>Container Selectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Container Selectors</em>'.
	 * @see pamtram.mapping.MappingHintGroupType#getContainerSelectors()
	 * @see #getMappingHintGroupType()
	 * @generated
	 */
	EReference getMappingHintGroupType_ContainerSelectors();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.MappingHintGroupType#validateExtendsOnlyValidHintGroups(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Extends Only Valid Hint Groups</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Extends Only Valid Hint Groups</em>' operation.
	 * @see pamtram.mapping.MappingHintGroupType#validateExtendsOnlyValidHintGroups(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMappingHintGroupType__ValidateExtendsOnlyValidHintGroups__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.MappingHintGroupType#getActiveMappingHints() <em>Get Active Mapping Hints</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Active Mapping Hints</em>' operation.
	 * @see pamtram.mapping.MappingHintGroupType#getActiveMappingHints()
	 * @generated
	 */
	EOperation getMappingHintGroupType__GetActiveMappingHints();

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
	 * Returns the meta object for the '{@link pamtram.mapping.MappingHintGroupImporter#getActiveMappingHints() <em>Get Active Mapping Hints</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Active Mapping Hints</em>' operation.
	 * @see pamtram.mapping.MappingHintGroupImporter#getActiveMappingHints()
	 * @generated
	 */
	EOperation getMappingHintGroupImporter__GetActiveMappingHints();

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
	 * Returns the meta object for the '{@link pamtram.mapping.GlobalAttribute#validateSourceAttributeHasUpperBoundOne(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Attribute Has Upper Bound One</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Attribute Has Upper Bound One</em>' operation.
	 * @see pamtram.mapping.GlobalAttribute#validateSourceAttributeHasUpperBoundOne(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getGlobalAttribute__ValidateSourceAttributeHasUpperBoundOne__DiagnosticChain_Map();

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
		 * The meta object literal for the '{@link pamtram.mapping.impl.MappingHintGroupImpl <em>Hint Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MappingHintGroupImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintGroup()
		 * @generated
		 */
		EClass MAPPING_HINT_GROUP = eINSTANCE.getMappingHintGroup();

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
		 * The meta object literal for the '<em><b>Attribute Mappings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_HINT_GROUP_TYPE__ATTRIBUTE_MAPPINGS = eINSTANCE.getMappingHintGroupType_AttributeMappings();

		/**
		 * The meta object literal for the '<em><b>Cardinality Mappings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_HINT_GROUP_TYPE__CARDINALITY_MAPPINGS = eINSTANCE.getMappingHintGroupType_CardinalityMappings();

		/**
		 * The meta object literal for the '<em><b>Reference Target Selectors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_HINT_GROUP_TYPE__REFERENCE_TARGET_SELECTORS = eINSTANCE.getMappingHintGroupType_ReferenceTargetSelectors();

		/**
		 * The meta object literal for the '<em><b>Container Selectors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_HINT_GROUP_TYPE__CONTAINER_SELECTORS = eINSTANCE.getMappingHintGroupType_ContainerSelectors();

		/**
		 * The meta object literal for the '<em><b>Validate Extends Only Valid Hint Groups</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_HINT_GROUP_TYPE___VALIDATE_EXTENDS_ONLY_VALID_HINT_GROUPS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMappingHintGroupType__ValidateExtendsOnlyValidHintGroups__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Get Active Mapping Hints</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_HINT_GROUP_TYPE___GET_ACTIVE_MAPPING_HINTS = eINSTANCE.getMappingHintGroupType__GetActiveMappingHints();

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
		 * The meta object literal for the '<em><b>Get Active Mapping Hints</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_HINT_GROUP_IMPORTER___GET_ACTIVE_MAPPING_HINTS = eINSTANCE.getMappingHintGroupImporter__GetActiveMappingHints();

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
		 * The meta object literal for the '<em><b>Validate Source Attribute Has Upper Bound One</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GLOBAL_ATTRIBUTE___VALIDATE_SOURCE_ATTRIBUTE_HAS_UPPER_BOUND_ONE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getGlobalAttribute__ValidateSourceAttributeHasUpperBoundOne__DiagnosticChain_Map();

	}

} //MappingPackage
