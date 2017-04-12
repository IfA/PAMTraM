/**
 */
package pamtram.mapping.extended;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import pamtram.mapping.MappingPackage;
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
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.AttributeMappingImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getAttributeMapping()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__NAME = MappingPackage.MAPPING_HINT__NAME;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__LOCAL_CONDITION = MappingPackage.MAPPING_HINT__LOCAL_CONDITION;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__SHARED_CONDITION = MappingPackage.MAPPING_HINT__SHARED_CONDITION;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__EXPRESSION = MappingPackage.MAPPING_HINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__MODIFIERS = MappingPackage.MAPPING_HINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__TARGET = MappingPackage.MAPPING_HINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__SOURCE_ELEMENTS = MappingPackage.MAPPING_HINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Attribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_FEATURE_COUNT = MappingPackage.MAPPING_HINT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate Either Model Or Refer Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP = MappingPackage.MAPPING_HINT___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MappingPackage.MAPPING_HINT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Local Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING___GET_LOCAL_SOURCE_ELEMENTS = MappingPackage.MAPPING_HINT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get External Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING___GET_EXTERNAL_SOURCE_ELEMENTS = MappingPackage.MAPPING_HINT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Target Attribute Matches Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING___VALIDATE_TARGET_ATTRIBUTE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP = MappingPackage.MAPPING_HINT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_OPERATION_COUNT = MappingPackage.MAPPING_HINT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.AttributeMappingSourceInterface <em>Attribute Mapping Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.AttributeMappingSourceInterface
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getAttributeMappingSourceInterface()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE__NAME = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE__NAME;

	/**
	 * The number of structural features of the '<em>Attribute Mapping Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE_FEATURE_COUNT = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Mapping Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE_OPERATION_COUNT = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.AttributeMappingSourceElementImpl <em>Attribute Mapping Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.AttributeMappingSourceElementImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getAttributeMappingSourceElement()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT = 2;

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
	 * The number of structural features of the '<em>Attribute Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_FEATURE_COUNT = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

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
	 * The number of operations of the '<em>Attribute Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.AttributeMappingExternalSourceElementImpl <em>Attribute Mapping External Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.AttributeMappingExternalSourceElementImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getAttributeMappingExternalSourceElement()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT = 3;

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
	 * The number of structural features of the '<em>Attribute Mapping External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT_FEATURE_COUNT = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

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
	 * The number of operations of the '<em>Attribute Mapping External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT_OPERATION_COUNT = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.AttributeMappingGlobalSourceElementImpl <em>Attribute Mapping Global Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.AttributeMappingGlobalSourceElementImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getAttributeMappingGlobalSourceElement()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT = 4;

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
	 * The feature id for the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT__INSTANCE_SELECTORS = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__INSTANCE_SELECTORS;

	/**
	 * The number of structural features of the '<em>Attribute Mapping Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT_FEATURE_COUNT = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

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
	 * The number of operations of the '<em>Attribute Mapping Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT_OPERATION_COUNT = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.CardinalityMappingImpl <em>Cardinality Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.CardinalityMappingImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getCardinalityMapping()
	 * @generated
	 */
	int CARDINALITY_MAPPING = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__NAME = MappingPackage.MAPPING_HINT__NAME;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__LOCAL_CONDITION = MappingPackage.MAPPING_HINT__LOCAL_CONDITION;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__SHARED_CONDITION = MappingPackage.MAPPING_HINT__SHARED_CONDITION;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__EXPRESSION = MappingPackage.MAPPING_HINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__MODIFIERS = MappingPackage.MAPPING_HINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__SOURCE = MappingPackage.MAPPING_HINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__TARGET = MappingPackage.MAPPING_HINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__SOURCE_ELEMENTS = MappingPackage.MAPPING_HINT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Cardinality Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_FEATURE_COUNT = MappingPackage.MAPPING_HINT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Validate Either Model Or Refer Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP = MappingPackage.MAPPING_HINT___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MappingPackage.MAPPING_HINT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Source Element Matches Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_SOURCE_ELEMENT_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP = MappingPackage.MAPPING_HINT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Target Class Matches Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_TARGET_CLASS_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP = MappingPackage.MAPPING_HINT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Source Class Is Variable Cardinality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_SOURCE_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP = MappingPackage.MAPPING_HINT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Target Class Is Variable Cardinality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_TARGET_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP = MappingPackage.MAPPING_HINT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate No Cardinality Mapping For Source Section Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT__DIAGNOSTICCHAIN_MAP = MappingPackage.MAPPING_HINT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate Only Source Or Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_ONLY_SOURCE_OR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP = MappingPackage.MAPPING_HINT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Validate Expression Only For Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_EXPRESSION_ONLY_FOR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP = MappingPackage.MAPPING_HINT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Validate Modifiers Only For Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___VALIDATE_MODIFIERS_ONLY_FOR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP = MappingPackage.MAPPING_HINT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Local Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___GET_LOCAL_SOURCE_ELEMENTS = MappingPackage.MAPPING_HINT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Get External Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING___GET_EXTERNAL_SOURCE_ELEMENTS = MappingPackage.MAPPING_HINT_OPERATION_COUNT + 9;

	/**
	 * The number of operations of the '<em>Cardinality Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_OPERATION_COUNT = MappingPackage.MAPPING_HINT_OPERATION_COUNT + 10;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.CardinalityMappingSourceInterface <em>Cardinality Mapping Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.CardinalityMappingSourceInterface
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getCardinalityMappingSourceInterface()
	 * @generated
	 */
	int CARDINALITY_MAPPING_SOURCE_INTERFACE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_INTERFACE__NAME = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE__NAME;

	/**
	 * The number of structural features of the '<em>Cardinality Mapping Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_INTERFACE_FEATURE_COUNT = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cardinality Mapping Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_INTERFACE_OPERATION_COUNT = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.CardinalityMappingSourceElementImpl <em>Cardinality Mapping Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.CardinalityMappingSourceElementImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getCardinalityMappingSourceElement()
	 * @generated
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT = 7;

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
	 * The number of structural features of the '<em>Cardinality Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT_FEATURE_COUNT = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

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
	 * The number of operations of the '<em>Cardinality Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT = StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.CardinalityMappingExternalSourceElementImpl <em>Cardinality Mapping External Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.CardinalityMappingExternalSourceElementImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getCardinalityMappingExternalSourceElement()
	 * @generated
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT = 8;

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
	 * The number of structural features of the '<em>Cardinality Mapping External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT_FEATURE_COUNT = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

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
	 * The number of operations of the '<em>Cardinality Mapping External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT_OPERATION_COUNT = StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.extended.impl.CardinalityMappingGlobalSourceElementImpl <em>Cardinality Mapping Global Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.extended.impl.CardinalityMappingGlobalSourceElementImpl
	 * @see pamtram.mapping.extended.impl.ExtendedPackageImpl#getCardinalityMappingGlobalSourceElement()
	 * @generated
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT = 9;

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
	 * The feature id for the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT__INSTANCE_SELECTORS = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__INSTANCE_SELECTORS;

	/**
	 * The number of structural features of the '<em>Cardinality Mapping Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT_FEATURE_COUNT = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

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
	 * The number of operations of the '<em>Cardinality Mapping Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT_OPERATION_COUNT = StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;


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
	 * Returns the meta object for the '{@link pamtram.mapping.extended.CardinalityMapping#validateSourceElementMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Element Matches Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Element Matches Section</em>' operation.
	 * @see pamtram.mapping.extended.CardinalityMapping#validateSourceElementMatchesSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCardinalityMapping__ValidateSourceElementMatchesSection__DiagnosticChain_Map();

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
		 * The meta object literal for the '<em><b>Validate Source Element Matches Section</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CARDINALITY_MAPPING___VALIDATE_SOURCE_ELEMENT_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCardinalityMapping__ValidateSourceElementMatchesSection__DiagnosticChain_Map();
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

	}

} //ExtendedPackage
