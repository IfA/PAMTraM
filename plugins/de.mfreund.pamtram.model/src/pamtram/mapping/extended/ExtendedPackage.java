/**
 */
package pamtram.mapping.extended;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import pamtram.PamtramPackage;
import pamtram.structure.StructurePackage;

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
 * This package contains all elements related to the description of MappingHints (i.e. related to the description of 'extended' mappings).
 * <!-- end-model-doc -->
 * @see pamtram.mapping.extended.ExtendedFactory
 * @model kind="package"
 * @generated
 */
public interface ExtendedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "extended";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mfreund.de/pamtram/mapping/extended";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "extended";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExtendedPackage eINSTANCE = pamtram.mapping.extended.impl.ExtendedPackageImpl.init();

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.MappingHintBaseTypeImpl <em>Mapping Hint Base Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.MappingHintBaseTypeImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getMappingHintBaseType()
	 * @generated
	 */
	int MAPPING_HINT_BASE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_BASE_TYPE__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Mapping Hint Base Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_BASE_TYPE_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mapping Hint Base Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_BASE_TYPE_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.MappingHintTypeImpl <em>Mapping Hint Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.MappingHintTypeImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getMappingHintType()
	 * @generated
	 */
	int MAPPING_HINT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_TYPE__NAME = MAPPING_HINT_BASE_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Mapping Hint Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_TYPE_FEATURE_COUNT = MAPPING_HINT_BASE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mapping Hint Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_TYPE_OPERATION_COUNT = MAPPING_HINT_BASE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.MappingHintImpl <em>Mapping Hint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.MappingHintImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getMappingHint()
	 * @generated
	 */
	int MAPPING_HINT = 2;

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
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT__ALL_CONDITIONS = MAPPING_HINT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Deactivated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT__DEACTIVATED = MAPPING_HINT_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Overwrite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT__OVERWRITE = MAPPING_HINT_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Mapping Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_FEATURE_COUNT = MAPPING_HINT_TYPE_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Overwrites Valid Mapping Hint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT___VALIDATE_OVERWRITES_VALID_MAPPING_HINT__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Consider Overwriting Hint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT___VALIDATE_CONSIDER_OVERWRITING_HINT__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_TYPE_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Mapping Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_OPERATION_COUNT = MAPPING_HINT_TYPE_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.ExpandableHint <em>Expandable Hint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.ExpandableHint
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getExpandableHint()
	 * @generated
	 */
	int EXPANDABLE_HINT = 3;

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
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.HintImporterMappingHintImpl <em>Hint Importer Mapping Hint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.HintImporterMappingHintImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getHintImporterMappingHint()
	 * @generated
	 */
	int HINT_IMPORTER_MAPPING_HINT = 4;

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
	 * The meta object id for the '{@link pamtram.mapping.extended.MappingHintSourceInterface <em>Mapping Hint Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.MappingHintSourceInterface
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getMappingHintSourceInterface()
	 * @generated
	 */
	int MAPPING_HINT_SOURCE_INTERFACE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_SOURCE_INTERFACE__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_SOURCE_INTERFACE__LOCAL_CONDITION = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_SOURCE_INTERFACE__SHARED_CONDITION = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_SOURCE_INTERFACE__ALL_CONDITIONS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mapping Hint Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_SOURCE_INTERFACE___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mapping Hint Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.GlobalAttributeImporterImpl <em>Global Attribute Importer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.GlobalAttributeImporterImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getGlobalAttributeImporter()
	 * @generated
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER__LOCAL_CONDITION = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER__SHARED_CONDITION = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER__ALL_CONDITIONS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Global Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Global Attribute Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Global Attribute Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.AttributeMappingImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getAttributeMapping()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING = 7;

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
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__ALL_CONDITIONS = MAPPING_HINT__ALL_CONDITIONS;

	/**
	 * The feature id for the '<em><b>Deactivated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__DEACTIVATED = MAPPING_HINT__DEACTIVATED;

	/**
	 * The feature id for the '<em><b>Overwrite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__OVERWRITE = MAPPING_HINT__OVERWRITE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__EXPRESSION = MAPPING_HINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__MODIFIERS = MAPPING_HINT_FEATURE_COUNT + 1;

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
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Overwrites Valid Mapping Hint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING___VALIDATE_OVERWRITES_VALID_MAPPING_HINT__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_OVERWRITES_VALID_MAPPING_HINT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Consider Overwriting Hint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING___VALIDATE_CONSIDER_OVERWRITING_HINT__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_CONSIDER_OVERWRITING_HINT__DIAGNOSTICCHAIN_MAP;

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
	 * The meta object id for the '{@link pamtram.mapping.extended.AttributeMappingSourceInterface <em>Attribute Mapping Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.AttributeMappingSourceInterface
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getAttributeMappingSourceInterface()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE__NAME = MAPPING_HINT_SOURCE_INTERFACE__NAME;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE__LOCAL_CONDITION = MAPPING_HINT_SOURCE_INTERFACE__LOCAL_CONDITION;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE__SHARED_CONDITION = MAPPING_HINT_SOURCE_INTERFACE__SHARED_CONDITION;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE__ALL_CONDITIONS = MAPPING_HINT_SOURCE_INTERFACE__ALL_CONDITIONS;

	/**
	 * The number of structural features of the '<em>Attribute Mapping Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE_FEATURE_COUNT = MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_SOURCE_INTERFACE___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Attribute Mapping Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE_OPERATION_COUNT = MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.AttributeMappingSourceElementImpl <em>Attribute Mapping Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.AttributeMappingSourceElementImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getAttributeMappingSourceElement()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT__NAME = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT__MODIFIERS = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT__SOURCE = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT__USE_ELEMENT_ID = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Reference Match Spec</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT__LOCAL_CONDITION = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT__SHARED_CONDITION = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT__ALL_CONDITIONS = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Attribute Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_FEATURE_COUNT = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT___GET_MAPPING = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.AttributeMappingExternalSourceElementImpl <em>Attribute Mapping External Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.AttributeMappingExternalSourceElementImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getAttributeMappingExternalSourceElement()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__NAME = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__MODIFIERS = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__SOURCE = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__USE_ELEMENT_ID = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__LOCAL_CONDITION = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__SHARED_CONDITION = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__ALL_CONDITIONS = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Attribute Mapping External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT_FEATURE_COUNT = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Mapping External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT_OPERATION_COUNT = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.AttributeMappingGlobalSourceElementImpl <em>Attribute Mapping Global Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.AttributeMappingGlobalSourceElementImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getAttributeMappingGlobalSourceElement()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT__NAME = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT__MODIFIERS = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT__SOURCE = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT__USE_ELEMENT_ID = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT__INSTANCE_SELECTORS = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__INSTANCE_SELECTORS;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT__LOCAL_CONDITION = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT__SHARED_CONDITION = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT__ALL_CONDITIONS = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Attribute Mapping Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT_FEATURE_COUNT = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT___GET_MAPPING = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Mapping Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT_OPERATION_COUNT = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 1;


	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.CardinalityMappingImpl <em>Cardinality Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.CardinalityMappingImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getCardinalityMapping()
	 * @generated
	 */
	int CARDINALITY_MAPPING = 12;

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
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__ALL_CONDITIONS = MAPPING_HINT__ALL_CONDITIONS;

	/**
	 * The feature id for the '<em><b>Deactivated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__DEACTIVATED = MAPPING_HINT__DEACTIVATED;

	/**
	 * The feature id for the '<em><b>Overwrite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__OVERWRITE = MAPPING_HINT__OVERWRITE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__EXPRESSION = MAPPING_HINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__MODIFIERS = MAPPING_HINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__SOURCE = MAPPING_HINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__TARGET = MAPPING_HINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__SOURCE_ELEMENTS = MAPPING_HINT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Cardinality Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_FEATURE_COUNT = MAPPING_HINT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Overwrites Valid Mapping Hint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_OVERWRITES_VALID_MAPPING_HINT__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_OVERWRITES_VALID_MAPPING_HINT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Consider Overwriting Hint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_CONSIDER_OVERWRITING_HINT__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_CONSIDER_OVERWRITING_HINT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Source Element Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_SOURCE_ELEMENT_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 0;

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
	 * The operation id for the '<em>Validate Only Source Or Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_ONLY_SOURCE_OR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Validate Expression Only For Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_EXPRESSION_ONLY_FOR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Validate Modifiers Only For Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_MODIFIERS_ONLY_FOR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Local Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___GET_LOCAL_SOURCE_ELEMENTS = MAPPING_HINT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Get External Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___GET_EXTERNAL_SOURCE_ELEMENTS = MAPPING_HINT_OPERATION_COUNT + 9;

	/**
	 * The number of operations of the '<em>Cardinality Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_OPERATION_COUNT = MAPPING_HINT_OPERATION_COUNT + 10;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.CardinalityMappingSourceInterface <em>Cardinality Mapping Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.CardinalityMappingSourceInterface
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getCardinalityMappingSourceInterface()
	 * @generated
	 */
	int CARDINALITY_MAPPING_SOURCE_INTERFACE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_INTERFACE__NAME = MAPPING_HINT_SOURCE_INTERFACE__NAME;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_INTERFACE__LOCAL_CONDITION = MAPPING_HINT_SOURCE_INTERFACE__LOCAL_CONDITION;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_INTERFACE__SHARED_CONDITION = MAPPING_HINT_SOURCE_INTERFACE__SHARED_CONDITION;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_INTERFACE__ALL_CONDITIONS = MAPPING_HINT_SOURCE_INTERFACE__ALL_CONDITIONS;

	/**
	 * The number of structural features of the '<em>Cardinality Mapping Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_INTERFACE_FEATURE_COUNT = MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_INTERFACE___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_SOURCE_INTERFACE___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Cardinality Mapping Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_INTERFACE_OPERATION_COUNT = MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.CardinalityMappingSourceElementImpl <em>Cardinality Mapping Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.CardinalityMappingSourceElementImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getCardinalityMappingSourceElement()
	 * @generated
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT__NAME = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT__MODIFIERS = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT__SOURCE = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT__USE_ELEMENT_ID = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Reference Match Spec</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT__LOCAL_CONDITION = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT__SHARED_CONDITION = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT__ALL_CONDITIONS = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Cardinality Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT_FEATURE_COUNT = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT___GET_MAPPING = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cardinality Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.CardinalityMappingExternalSourceElementImpl <em>Cardinality Mapping External Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.CardinalityMappingExternalSourceElementImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getCardinalityMappingExternalSourceElement()
	 * @generated
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT__NAME = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT__MODIFIERS = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT__SOURCE = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT__USE_ELEMENT_ID = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT__LOCAL_CONDITION = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT__SHARED_CONDITION = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT__ALL_CONDITIONS = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Cardinality Mapping External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT_FEATURE_COUNT = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cardinality Mapping External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT_OPERATION_COUNT = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.CardinalityMappingGlobalSourceElementImpl <em>Cardinality Mapping Global Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.CardinalityMappingGlobalSourceElementImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getCardinalityMappingGlobalSourceElement()
	 * @generated
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT__NAME = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT__MODIFIERS = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT__SOURCE = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT__USE_ELEMENT_ID = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT__INSTANCE_SELECTORS = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__INSTANCE_SELECTORS;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT__LOCAL_CONDITION = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT__SHARED_CONDITION = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT__ALL_CONDITIONS = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Cardinality Mapping Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT_FEATURE_COUNT = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT___GET_MAPPING = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cardinality Mapping Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT_OPERATION_COUNT = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 1;


	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.ReferenceTargetSelectorImpl <em>Reference Target Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.ReferenceTargetSelectorImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getReferenceTargetSelector()
	 * @generated
	 */
	int REFERENCE_TARGET_SELECTOR = 17;

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
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR__ALL_CONDITIONS = MAPPING_HINT__ALL_CONDITIONS;

	/**
	 * The feature id for the '<em><b>Deactivated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR__DEACTIVATED = MAPPING_HINT__DEACTIVATED;

	/**
	 * The feature id for the '<em><b>Overwrite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR__OVERWRITE = MAPPING_HINT__OVERWRITE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR__EXPRESSION = MAPPING_HINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR__MODIFIERS = MAPPING_HINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR__SOURCE_ELEMENTS = MAPPING_HINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reference Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR__REFERENCE_ATTRIBUTE = MAPPING_HINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR__TARGET_CLASS = MAPPING_HINT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Affected Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE = MAPPING_HINT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Reference Target Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR_FEATURE_COUNT = MAPPING_HINT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Overwrites Valid Mapping Hint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR___VALIDATE_OVERWRITES_VALID_MAPPING_HINT__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_OVERWRITES_VALID_MAPPING_HINT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Consider Overwriting Hint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR___VALIDATE_CONSIDER_OVERWRITING_HINT__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_CONSIDER_OVERWRITING_HINT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate No Modified Attribute Element Types In Condition Model Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Local Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS = MAPPING_HINT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get External Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS = MAPPING_HINT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Reference Attribute Is Valid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR___VALIDATE_REFERENCE_ATTRIBUTE_IS_VALID__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate Affected Reference Is Non Containment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR___VALIDATE_AFFECTED_REFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate Affected Reference Matches Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR___VALIDATE_AFFECTED_REFERENCE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Validate Target Class</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR___VALIDATE_TARGET_CLASS__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Reference Target Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TARGET_SELECTOR_OPERATION_COUNT = MAPPING_HINT_OPERATION_COUNT + 7;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.ContainerSelectorImpl <em>Container Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.ContainerSelectorImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getContainerSelector()
	 * @generated
	 */
	int CONTAINER_SELECTOR = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR__NAME = MAPPING_HINT__NAME;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR__LOCAL_CONDITION = MAPPING_HINT__LOCAL_CONDITION;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR__SHARED_CONDITION = MAPPING_HINT__SHARED_CONDITION;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR__ALL_CONDITIONS = MAPPING_HINT__ALL_CONDITIONS;

	/**
	 * The feature id for the '<em><b>Deactivated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR__DEACTIVATED = MAPPING_HINT__DEACTIVATED;

	/**
	 * The feature id for the '<em><b>Overwrite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR__OVERWRITE = MAPPING_HINT__OVERWRITE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR__EXPRESSION = MAPPING_HINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR__MODIFIERS = MAPPING_HINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR__SOURCE_ELEMENTS = MAPPING_HINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reference Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR__REFERENCE_ATTRIBUTE = MAPPING_HINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR__TARGET_CLASS = MAPPING_HINT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Container Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_FEATURE_COUNT = MAPPING_HINT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Overwrites Valid Mapping Hint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR___VALIDATE_OVERWRITES_VALID_MAPPING_HINT__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_OVERWRITES_VALID_MAPPING_HINT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Consider Overwriting Hint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR___VALIDATE_CONSIDER_OVERWRITING_HINT__DIAGNOSTICCHAIN_MAP = MAPPING_HINT___VALIDATE_CONSIDER_OVERWRITING_HINT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate No Modified Attribute Element Types In Condition Model Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Local Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS = MAPPING_HINT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get External Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS = MAPPING_HINT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Reference Attribute Is Valid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR___VALIDATE_REFERENCE_ATTRIBUTE_IS_VALID__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate Target Class Matches Possible Container Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR___VALIDATE_TARGET_CLASS_MATCHES_POSSIBLE_CONTAINER_TYPE__DIAGNOSTICCHAIN_MAP = MAPPING_HINT_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Container Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_SELECTOR_OPERATION_COUNT = MAPPING_HINT_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.MappedAttributeValueExpanderImpl <em>Mapped Attribute Value Expander</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.MappedAttributeValueExpanderImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getMappedAttributeValueExpander()
	 * @generated
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER = 19;

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
	 * The number of operations of the '<em>Mapped Attribute Value Expander</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT = HINT_IMPORTER_MAPPING_HINT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.LocalMappedAttributeValueExpanderImpl <em>Local Mapped Attribute Value Expander</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.LocalMappedAttributeValueExpanderImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getLocalMappedAttributeValueExpander()
	 * @generated
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIERS = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__USE_ELEMENT_ID = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Reference Match Spec</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__REFERENCE_MATCH_SPEC = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC;

	/**
	 * The feature id for the '<em><b>Hints To Expand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Local Mapped Attribute Value Expander</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_FEATURE_COUNT = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING_HINT_GROUP = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Local Mapped Attribute Value Expander</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.MappedAttributeValuePrependerImpl <em>Mapped Attribute Value Prepender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.MappedAttributeValuePrependerImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getMappedAttributeValuePrepender()
	 * @generated
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER__NAME = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER__MODIFIERS = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER__SOURCE = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER__USE_ELEMENT_ID = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__USE_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Reference Match Spec</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER__REFERENCE_MATCH_SPEC = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__REFERENCE_MATCH_SPEC;

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
	 * The number of operations of the '<em>Mapped Attribute Value Prepender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER_OPERATION_COUNT = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.MappedAttributeValueAppenderImpl <em>Mapped Attribute Value Appender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.MappedAttributeValueAppenderImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getMappedAttributeValueAppender()
	 * @generated
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER__NAME = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER__MODIFIERS = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER__SOURCE = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER__USE_ELEMENT_ID = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__USE_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Reference Match Spec</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER__REFERENCE_MATCH_SPEC = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__REFERENCE_MATCH_SPEC;

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
	 * The number of operations of the '<em>Mapped Attribute Value Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER_OPERATION_COUNT = LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.ExternalMappedAttributeValueExpanderImpl <em>External Mapped Attribute Value Expander</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.ExternalMappedAttributeValueExpanderImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getExternalMappedAttributeValueExpander()
	 * @generated
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIERS = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__USE_ELEMENT_ID = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Hints To Expand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Mapped Attribute Value Expander</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_FEATURE_COUNT = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING_HINT_GROUP = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MAPPING = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>External Mapped Attribute Value Expander</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.ExternalMappedAttributeValuePrependerImpl <em>External Mapped Attribute Value Prepender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.ExternalMappedAttributeValuePrependerImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getExternalMappedAttributeValuePrepender()
	 * @generated
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER__NAME = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER__MODIFIERS = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER__SOURCE = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER__USE_ELEMENT_ID = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__USE_ELEMENT_ID;

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
	 * The number of operations of the '<em>External Mapped Attribute Value Prepender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER_OPERATION_COUNT = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.ExternalMappedAttributeValueAppenderImpl <em>External Mapped Attribute Value Appender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.ExternalMappedAttributeValueAppenderImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getExternalMappedAttributeValueAppender()
	 * @generated
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER__NAME = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER__MODIFIERS = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER__SOURCE = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER__USE_ELEMENT_ID = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__USE_ELEMENT_ID;

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
	 * The number of operations of the '<em>External Mapped Attribute Value Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER_OPERATION_COUNT = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.MappingHintBaseType <em>Mapping Hint Base Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Hint Base Type</em>'.
	 * @see pamtram.mapping.extended.MappingHintBaseType
	 * @generated
	 */
	EClass getMappingHintBaseType();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.MappingHintType <em>Mapping Hint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Hint Type</em>'.
	 * @see pamtram.mapping.extended.MappingHintType
	 * @generated
	 */
	EClass getMappingHintType();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.MappingHint <em>Mapping Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Hint</em>'.
	 * @see pamtram.mapping.extended.MappingHint
	 * @generated
	 */
	EClass getMappingHint();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.extended.MappingHint#getOverwrite <em>Overwrite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Overwrite</em>'.
	 * @see pamtram.mapping.extended.MappingHint#getOverwrite()
	 * @see #getMappingHint()
	 * @generated
	 */
	EReference getMappingHint_Overwrite();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.MappingHint#validateOverwritesValidMappingHint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Overwrites Valid Mapping Hint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Overwrites Valid Mapping Hint</em>' operation.
	 * @see pamtram.mapping.extended.MappingHint#validateOverwritesValidMappingHint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMappingHint__ValidateOverwritesValidMappingHint__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.MappingHint#validateConsiderOverwritingHint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Consider Overwriting Hint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Consider Overwriting Hint</em>' operation.
	 * @see pamtram.mapping.extended.MappingHint#validateConsiderOverwritingHint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMappingHint__ValidateConsiderOverwritingHint__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.ExpandableHint <em>Expandable Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expandable Hint</em>'.
	 * @see pamtram.mapping.extended.ExpandableHint
	 * @generated
	 */
	EClass getExpandableHint();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.HintImporterMappingHint <em>Hint Importer Mapping Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hint Importer Mapping Hint</em>'.
	 * @see pamtram.mapping.extended.HintImporterMappingHint
	 * @generated
	 */
	EClass getHintImporterMappingHint();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.MappingHintSourceInterface <em>Mapping Hint Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Hint Source Interface</em>'.
	 * @see pamtram.mapping.extended.MappingHintSourceInterface
	 * @generated
	 */
	EClass getMappingHintSourceInterface();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.GlobalAttributeImporter <em>Global Attribute Importer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Attribute Importer</em>'.
	 * @see pamtram.mapping.extended.GlobalAttributeImporter
	 * @generated
	 */
	EClass getGlobalAttributeImporter();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.extended.GlobalAttributeImporter#getGlobalAttribute <em>Global Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Global Attribute</em>'.
	 * @see pamtram.mapping.extended.GlobalAttributeImporter#getGlobalAttribute()
	 * @see #getGlobalAttributeImporter()
	 * @generated
	 */
	EReference getGlobalAttributeImporter_GlobalAttribute();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.AttributeMapping <em>Attribute Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Mapping</em>'.
	 * @see pamtram.mapping.extended.AttributeMapping
	 * @generated
	 */
	EClass getAttributeMapping();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.extended.AttributeMapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see pamtram.mapping.extended.AttributeMapping#getTarget()
	 * @see #getAttributeMapping()
	 * @generated
	 */
	EReference getAttributeMapping_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.extended.AttributeMapping#getSourceElements <em>Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Elements</em>'.
	 * @see pamtram.mapping.extended.AttributeMapping#getSourceElements()
	 * @see #getAttributeMapping()
	 * @generated
	 */
	EReference getAttributeMapping_SourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.AttributeMapping#getLocalSourceElements() <em>Get Local Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Local Source Elements</em>' operation.
	 * @see pamtram.mapping.extended.AttributeMapping#getLocalSourceElements()
	 * @generated
	 */
	EOperation getAttributeMapping__GetLocalSourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.AttributeMapping#getExternalSourceElements() <em>Get External Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get External Source Elements</em>' operation.
	 * @see pamtram.mapping.extended.AttributeMapping#getExternalSourceElements()
	 * @generated
	 */
	EOperation getAttributeMapping__GetExternalSourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.AttributeMapping#validateTargetAttributeMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Attribute Matches Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Attribute Matches Section</em>' operation.
	 * @see pamtram.mapping.extended.AttributeMapping#validateTargetAttributeMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getAttributeMapping__ValidateTargetAttributeMatchesSection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.AttributeMappingSourceInterface <em>Attribute Mapping Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Mapping Source Interface</em>'.
	 * @see pamtram.mapping.extended.AttributeMappingSourceInterface
	 * @generated
	 */
	EClass getAttributeMappingSourceInterface();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.AttributeMappingSourceElement <em>Attribute Mapping Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Mapping Source Element</em>'.
	 * @see pamtram.mapping.extended.AttributeMappingSourceElement
	 * @generated
	 */
	EClass getAttributeMappingSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.AttributeMappingExternalSourceElement <em>Attribute Mapping External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Mapping External Source Element</em>'.
	 * @see pamtram.mapping.extended.AttributeMappingExternalSourceElement
	 * @generated
	 */
	EClass getAttributeMappingExternalSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.AttributeMappingGlobalSourceElement <em>Attribute Mapping Global Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Mapping Global Source Element</em>'.
	 * @see pamtram.mapping.extended.AttributeMappingGlobalSourceElement
	 * @generated
	 */
	EClass getAttributeMappingGlobalSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.CardinalityMapping <em>Cardinality Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cardinality Mapping</em>'.
	 * @see pamtram.mapping.extended.CardinalityMapping
	 * @generated
	 */
	EClass getCardinalityMapping();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.extended.CardinalityMapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see pamtram.mapping.extended.CardinalityMapping#getSource()
	 * @see #getCardinalityMapping()
	 * @generated
	 */
	EReference getCardinalityMapping_Source();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.extended.CardinalityMapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see pamtram.mapping.extended.CardinalityMapping#getTarget()
	 * @see #getCardinalityMapping()
	 * @generated
	 */
	EReference getCardinalityMapping_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.extended.CardinalityMapping#getSourceElements <em>Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Elements</em>'.
	 * @see pamtram.mapping.extended.CardinalityMapping#getSourceElements()
	 * @see #getCardinalityMapping()
	 * @generated
	 */
	EReference getCardinalityMapping_SourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.CardinalityMapping#validateSourceElementMatchesSectionOrContainedSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Element Matches Section Or Contained Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Element Matches Section Or Contained Section</em>' operation.
	 * @see pamtram.mapping.extended.CardinalityMapping#validateSourceElementMatchesSectionOrContainedSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCardinalityMapping__ValidateSourceElementMatchesSectionOrContainedSection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.CardinalityMapping#validateTargetClassMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Class Matches Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Class Matches Section</em>' operation.
	 * @see pamtram.mapping.extended.CardinalityMapping#validateTargetClassMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCardinalityMapping__ValidateTargetClassMatchesSection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.CardinalityMapping#validateSourceClassIsVariableCardinality(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Class Is Variable Cardinality</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Class Is Variable Cardinality</em>' operation.
	 * @see pamtram.mapping.extended.CardinalityMapping#validateSourceClassIsVariableCardinality(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCardinalityMapping__ValidateSourceClassIsVariableCardinality__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.CardinalityMapping#validateTargetClassIsVariableCardinality(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Class Is Variable Cardinality</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Class Is Variable Cardinality</em>' operation.
	 * @see pamtram.mapping.extended.CardinalityMapping#validateTargetClassIsVariableCardinality(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCardinalityMapping__ValidateTargetClassIsVariableCardinality__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.CardinalityMapping#validateNoCardinalityMappingForSourceSectionRoot(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Cardinality Mapping For Source Section Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate No Cardinality Mapping For Source Section Root</em>' operation.
	 * @see pamtram.mapping.extended.CardinalityMapping#validateNoCardinalityMappingForSourceSectionRoot(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCardinalityMapping__ValidateNoCardinalityMappingForSourceSectionRoot__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.CardinalityMapping#validateOnlySourceOrSourceElements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Only Source Or Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Only Source Or Source Elements</em>' operation.
	 * @see pamtram.mapping.extended.CardinalityMapping#validateOnlySourceOrSourceElements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCardinalityMapping__ValidateOnlySourceOrSourceElements__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.CardinalityMapping#validateExpressionOnlyForSourceElements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Expression Only For Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Expression Only For Source Elements</em>' operation.
	 * @see pamtram.mapping.extended.CardinalityMapping#validateExpressionOnlyForSourceElements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCardinalityMapping__ValidateExpressionOnlyForSourceElements__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.CardinalityMapping#validateModifiersOnlyForSourceElements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Modifiers Only For Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Modifiers Only For Source Elements</em>' operation.
	 * @see pamtram.mapping.extended.CardinalityMapping#validateModifiersOnlyForSourceElements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCardinalityMapping__ValidateModifiersOnlyForSourceElements__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.CardinalityMapping#getLocalSourceElements() <em>Get Local Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Local Source Elements</em>' operation.
	 * @see pamtram.mapping.extended.CardinalityMapping#getLocalSourceElements()
	 * @generated
	 */
	EOperation getCardinalityMapping__GetLocalSourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.CardinalityMapping#getExternalSourceElements() <em>Get External Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get External Source Elements</em>' operation.
	 * @see pamtram.mapping.extended.CardinalityMapping#getExternalSourceElements()
	 * @generated
	 */
	EOperation getCardinalityMapping__GetExternalSourceElements();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.CardinalityMappingSourceInterface <em>Cardinality Mapping Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cardinality Mapping Source Interface</em>'.
	 * @see pamtram.mapping.extended.CardinalityMappingSourceInterface
	 * @generated
	 */
	EClass getCardinalityMappingSourceInterface();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.CardinalityMappingSourceElement <em>Cardinality Mapping Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cardinality Mapping Source Element</em>'.
	 * @see pamtram.mapping.extended.CardinalityMappingSourceElement
	 * @generated
	 */
	EClass getCardinalityMappingSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.CardinalityMappingExternalSourceElement <em>Cardinality Mapping External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cardinality Mapping External Source Element</em>'.
	 * @see pamtram.mapping.extended.CardinalityMappingExternalSourceElement
	 * @generated
	 */
	EClass getCardinalityMappingExternalSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.CardinalityMappingGlobalSourceElement <em>Cardinality Mapping Global Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cardinality Mapping Global Source Element</em>'.
	 * @see pamtram.mapping.extended.CardinalityMappingGlobalSourceElement
	 * @generated
	 */
	EClass getCardinalityMappingGlobalSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.ReferenceTargetSelector <em>Reference Target Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Target Selector</em>'.
	 * @see pamtram.mapping.extended.ReferenceTargetSelector
	 * @generated
	 */
	EClass getReferenceTargetSelector();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.extended.ReferenceTargetSelector#getAffectedReference <em>Affected Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Affected Reference</em>'.
	 * @see pamtram.mapping.extended.ReferenceTargetSelector#getAffectedReference()
	 * @see #getReferenceTargetSelector()
	 * @generated
	 */
	EReference getReferenceTargetSelector_AffectedReference();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.ReferenceTargetSelector#validateAffectedReferenceIsNonContainment(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Affected Reference Is Non Containment</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Affected Reference Is Non Containment</em>' operation.
	 * @see pamtram.mapping.extended.ReferenceTargetSelector#validateAffectedReferenceIsNonContainment(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getReferenceTargetSelector__ValidateAffectedReferenceIsNonContainment__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.ReferenceTargetSelector#validateAffectedReferenceMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Affected Reference Matches Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Affected Reference Matches Section</em>' operation.
	 * @see pamtram.mapping.extended.ReferenceTargetSelector#validateAffectedReferenceMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getReferenceTargetSelector__ValidateAffectedReferenceMatchesSection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.ReferenceTargetSelector#validateTargetClass(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Class</em>' operation.
	 * @see pamtram.mapping.extended.ReferenceTargetSelector#validateTargetClass(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getReferenceTargetSelector__ValidateTargetClass__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.ContainerSelector <em>Container Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Selector</em>'.
	 * @see pamtram.mapping.extended.ContainerSelector
	 * @generated
	 */
	EClass getContainerSelector();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.ContainerSelector#validateTargetClassMatchesPossibleContainerType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Class Matches Possible Container Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Class Matches Possible Container Type</em>' operation.
	 * @see pamtram.mapping.extended.ContainerSelector#validateTargetClassMatchesPossibleContainerType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getContainerSelector__ValidateTargetClassMatchesPossibleContainerType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.MappedAttributeValueExpander <em>Mapped Attribute Value Expander</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Attribute Value Expander</em>'.
	 * @see pamtram.mapping.extended.MappedAttributeValueExpander
	 * @generated
	 */
	EClass getMappedAttributeValueExpander();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.mapping.extended.MappedAttributeValueExpander#getHintsToExpand <em>Hints To Expand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Hints To Expand</em>'.
	 * @see pamtram.mapping.extended.MappedAttributeValueExpander#getHintsToExpand()
	 * @see #getMappedAttributeValueExpander()
	 * @generated
	 */
	EReference getMappedAttributeValueExpander_HintsToExpand();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.extended.MappedAttributeValueExpander#getSourceAttribute() <em>Get Source Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Source Attribute</em>' operation.
	 * @see pamtram.mapping.extended.MappedAttributeValueExpander#getSourceAttribute()
	 * @generated
	 */
	EOperation getMappedAttributeValueExpander__GetSourceAttribute();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.LocalMappedAttributeValueExpander <em>Local Mapped Attribute Value Expander</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Mapped Attribute Value Expander</em>'.
	 * @see pamtram.mapping.extended.LocalMappedAttributeValueExpander
	 * @generated
	 */
	EClass getLocalMappedAttributeValueExpander();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.MappedAttributeValuePrepender <em>Mapped Attribute Value Prepender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Attribute Value Prepender</em>'.
	 * @see pamtram.mapping.extended.MappedAttributeValuePrepender
	 * @generated
	 */
	EClass getMappedAttributeValuePrepender();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.MappedAttributeValueAppender <em>Mapped Attribute Value Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Attribute Value Appender</em>'.
	 * @see pamtram.mapping.extended.MappedAttributeValueAppender
	 * @generated
	 */
	EClass getMappedAttributeValueAppender();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.ExternalMappedAttributeValueExpander <em>External Mapped Attribute Value Expander</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Mapped Attribute Value Expander</em>'.
	 * @see pamtram.mapping.extended.ExternalMappedAttributeValueExpander
	 * @generated
	 */
	EClass getExternalMappedAttributeValueExpander();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.ExternalMappedAttributeValuePrepender <em>External Mapped Attribute Value Prepender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Mapped Attribute Value Prepender</em>'.
	 * @see pamtram.mapping.extended.ExternalMappedAttributeValuePrepender
	 * @generated
	 */
	EClass getExternalMappedAttributeValuePrepender();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.extended.ExternalMappedAttributeValueAppender <em>External Mapped Attribute Value Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Mapped Attribute Value Appender</em>'.
	 * @see pamtram.mapping.extended.ExternalMappedAttributeValueAppender
	 * @generated
	 */
	EClass getExternalMappedAttributeValueAppender();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExtendedFactory getExtendedFactory();

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
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.MappingHintBaseTypeImpl <em>Mapping Hint Base Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.MappingHintBaseTypeImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getMappingHintBaseType()
		 * @generated
		 */
		EClass MAPPING_HINT_BASE_TYPE = eINSTANCE.getMappingHintBaseType();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.MappingHintTypeImpl <em>Mapping Hint Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.MappingHintTypeImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getMappingHintType()
		 * @generated
		 */
		EClass MAPPING_HINT_TYPE = eINSTANCE.getMappingHintType();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.MappingHintImpl <em>Mapping Hint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.MappingHintImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getMappingHint()
		 * @generated
		 */
		EClass MAPPING_HINT = eINSTANCE.getMappingHint();
		/**
		 * The meta object literal for the '<em><b>Overwrite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_HINT__OVERWRITE = eINSTANCE.getMappingHint_Overwrite();
		/**
		 * The meta object literal for the '<em><b>Validate Overwrites Valid Mapping Hint</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_HINT___VALIDATE_OVERWRITES_VALID_MAPPING_HINT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMappingHint__ValidateOverwritesValidMappingHint__DiagnosticChain_Map();
		/**
		 * The meta object literal for the '<em><b>Validate Consider Overwriting Hint</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_HINT___VALIDATE_CONSIDER_OVERWRITING_HINT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMappingHint__ValidateConsiderOverwritingHint__DiagnosticChain_Map();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.ExpandableHint <em>Expandable Hint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.ExpandableHint
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getExpandableHint()
		 * @generated
		 */
		EClass EXPANDABLE_HINT = eINSTANCE.getExpandableHint();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.HintImporterMappingHintImpl <em>Hint Importer Mapping Hint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.HintImporterMappingHintImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getHintImporterMappingHint()
		 * @generated
		 */
		EClass HINT_IMPORTER_MAPPING_HINT = eINSTANCE.getHintImporterMappingHint();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.MappingHintSourceInterface <em>Mapping Hint Source Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.MappingHintSourceInterface
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getMappingHintSourceInterface()
		 * @generated
		 */
		EClass MAPPING_HINT_SOURCE_INTERFACE = eINSTANCE.getMappingHintSourceInterface();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.GlobalAttributeImporterImpl <em>Global Attribute Importer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.GlobalAttributeImporterImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getGlobalAttributeImporter()
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
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.AttributeMappingImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getAttributeMapping()
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
		 * The meta object literal for the '{@link pamtram.mapping.extended.AttributeMappingSourceInterface <em>Attribute Mapping Source Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.AttributeMappingSourceInterface
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getAttributeMappingSourceInterface()
		 * @generated
		 */
		EClass ATTRIBUTE_MAPPING_SOURCE_INTERFACE = eINSTANCE.getAttributeMappingSourceInterface();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.AttributeMappingSourceElementImpl <em>Attribute Mapping Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.AttributeMappingSourceElementImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getAttributeMappingSourceElement()
		 * @generated
		 */
		EClass ATTRIBUTE_MAPPING_SOURCE_ELEMENT = eINSTANCE.getAttributeMappingSourceElement();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.AttributeMappingExternalSourceElementImpl <em>Attribute Mapping External Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.AttributeMappingExternalSourceElementImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getAttributeMappingExternalSourceElement()
		 * @generated
		 */
		EClass ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT = eINSTANCE.getAttributeMappingExternalSourceElement();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.AttributeMappingGlobalSourceElementImpl <em>Attribute Mapping Global Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.AttributeMappingGlobalSourceElementImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getAttributeMappingGlobalSourceElement()
		 * @generated
		 */
		EClass ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT = eINSTANCE.getAttributeMappingGlobalSourceElement();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.CardinalityMappingImpl <em>Cardinality Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.CardinalityMappingImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getCardinalityMapping()
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
		 * The meta object literal for the '<em><b>Source Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CARDINALITY_MAPPING__SOURCE_ELEMENTS = eINSTANCE.getCardinalityMapping_SourceElements();
		/**
		 * The meta object literal for the '<em><b>Validate Source Element Matches Section Or Contained Section</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CARDINALITY_MAPPING___VALIDATE_SOURCE_ELEMENT_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCardinalityMapping__ValidateSourceElementMatchesSectionOrContainedSection__DiagnosticChain_Map();
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
		 * The meta object literal for the '<em><b>Validate Only Source Or Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CARDINALITY_MAPPING___VALIDATE_ONLY_SOURCE_OR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCardinalityMapping__ValidateOnlySourceOrSourceElements__DiagnosticChain_Map();
		/**
		 * The meta object literal for the '<em><b>Validate Expression Only For Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CARDINALITY_MAPPING___VALIDATE_EXPRESSION_ONLY_FOR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCardinalityMapping__ValidateExpressionOnlyForSourceElements__DiagnosticChain_Map();
		/**
		 * The meta object literal for the '<em><b>Validate Modifiers Only For Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CARDINALITY_MAPPING___VALIDATE_MODIFIERS_ONLY_FOR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCardinalityMapping__ValidateModifiersOnlyForSourceElements__DiagnosticChain_Map();
		/**
		 * The meta object literal for the '<em><b>Get Local Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CARDINALITY_MAPPING___GET_LOCAL_SOURCE_ELEMENTS = eINSTANCE.getCardinalityMapping__GetLocalSourceElements();
		/**
		 * The meta object literal for the '<em><b>Get External Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CARDINALITY_MAPPING___GET_EXTERNAL_SOURCE_ELEMENTS = eINSTANCE.getCardinalityMapping__GetExternalSourceElements();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.CardinalityMappingSourceInterface <em>Cardinality Mapping Source Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.CardinalityMappingSourceInterface
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getCardinalityMappingSourceInterface()
		 * @generated
		 */
		EClass CARDINALITY_MAPPING_SOURCE_INTERFACE = eINSTANCE.getCardinalityMappingSourceInterface();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.CardinalityMappingSourceElementImpl <em>Cardinality Mapping Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.CardinalityMappingSourceElementImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getCardinalityMappingSourceElement()
		 * @generated
		 */
		EClass CARDINALITY_MAPPING_SOURCE_ELEMENT = eINSTANCE.getCardinalityMappingSourceElement();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.CardinalityMappingExternalSourceElementImpl <em>Cardinality Mapping External Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.CardinalityMappingExternalSourceElementImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getCardinalityMappingExternalSourceElement()
		 * @generated
		 */
		EClass CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT = eINSTANCE.getCardinalityMappingExternalSourceElement();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.CardinalityMappingGlobalSourceElementImpl <em>Cardinality Mapping Global Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.CardinalityMappingGlobalSourceElementImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getCardinalityMappingGlobalSourceElement()
		 * @generated
		 */
		EClass CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT = eINSTANCE.getCardinalityMappingGlobalSourceElement();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.ReferenceTargetSelectorImpl <em>Reference Target Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.ReferenceTargetSelectorImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getReferenceTargetSelector()
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
		 * The meta object literal for the '<em><b>Validate Target Class</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REFERENCE_TARGET_SELECTOR___VALIDATE_TARGET_CLASS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getReferenceTargetSelector__ValidateTargetClass__DiagnosticChain_Map();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.ContainerSelectorImpl <em>Container Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.ContainerSelectorImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getContainerSelector()
		 * @generated
		 */
		EClass CONTAINER_SELECTOR = eINSTANCE.getContainerSelector();
		/**
		 * The meta object literal for the '<em><b>Validate Target Class Matches Possible Container Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER_SELECTOR___VALIDATE_TARGET_CLASS_MATCHES_POSSIBLE_CONTAINER_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getContainerSelector__ValidateTargetClassMatchesPossibleContainerType__DiagnosticChain_Map();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.MappedAttributeValueExpanderImpl <em>Mapped Attribute Value Expander</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.MappedAttributeValueExpanderImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getMappedAttributeValueExpander()
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
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.LocalMappedAttributeValueExpanderImpl <em>Local Mapped Attribute Value Expander</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.LocalMappedAttributeValueExpanderImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getLocalMappedAttributeValueExpander()
		 * @generated
		 */
		EClass LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER = eINSTANCE.getLocalMappedAttributeValueExpander();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.MappedAttributeValuePrependerImpl <em>Mapped Attribute Value Prepender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.MappedAttributeValuePrependerImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getMappedAttributeValuePrepender()
		 * @generated
		 */
		EClass MAPPED_ATTRIBUTE_VALUE_PREPENDER = eINSTANCE.getMappedAttributeValuePrepender();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.MappedAttributeValueAppenderImpl <em>Mapped Attribute Value Appender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.MappedAttributeValueAppenderImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getMappedAttributeValueAppender()
		 * @generated
		 */
		EClass MAPPED_ATTRIBUTE_VALUE_APPENDER = eINSTANCE.getMappedAttributeValueAppender();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.ExternalMappedAttributeValueExpanderImpl <em>External Mapped Attribute Value Expander</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.ExternalMappedAttributeValueExpanderImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getExternalMappedAttributeValueExpander()
		 * @generated
		 */
		EClass EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER = eINSTANCE.getExternalMappedAttributeValueExpander();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.ExternalMappedAttributeValuePrependerImpl <em>External Mapped Attribute Value Prepender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.ExternalMappedAttributeValuePrependerImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getExternalMappedAttributeValuePrepender()
		 * @generated
		 */
		EClass EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER = eINSTANCE.getExternalMappedAttributeValuePrepender();
		/**
		 * The meta object literal for the '{@link pamtram.mapping.extended.impl.ExternalMappedAttributeValueAppenderImpl <em>External Mapped Attribute Value Appender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.extended.impl.ExternalMappedAttributeValueAppenderImpl
		 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getExternalMappedAttributeValueAppender()
		 * @generated
		 */
		EClass EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER = eINSTANCE.getExternalMappedAttributeValueAppender();

	}

} //ExtendedPackage
