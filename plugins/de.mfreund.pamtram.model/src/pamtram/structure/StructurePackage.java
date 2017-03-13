/**
 */
package pamtram.structure;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import pamtram.PamtramPackage;
import pamtram.mapping.MappingPackage;

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
 * @see pamtram.structure.StructureFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore' genlib='http://www.et.tu-dresden.de/ifa/agtele/genlib'"
 * @generated
 */
public interface StructurePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "structure";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mfreund.de/pamtram/structure";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "structure";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StructurePackage eINSTANCE = pamtram.structure.impl.StructurePackageImpl.init();

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.InstanceSelectorImpl <em>Instance Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.InstanceSelectorImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getInstanceSelector()
	 * @generated
	 */
	int INSTANCE_SELECTOR = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR__EXPRESSION = PamtramPackage.EXPRESSION_ELEMENT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR__MODIFIERS = PamtramPackage.EXPRESSION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR__TARGET = PamtramPackage.EXPRESSION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR__SOURCE_ELEMENTS = PamtramPackage.EXPRESSION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Instance Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_FEATURE_COUNT = PamtramPackage.EXPRESSION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate No Modified Attribute Element Types In Condition Model Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP = PamtramPackage.EXPRESSION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Instance Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_OPERATION_COUNT = PamtramPackage.EXPRESSION_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.SourceInstanceSelectorImpl <em>Source Instance Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.SourceInstanceSelectorImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getSourceInstanceSelector()
	 * @generated
	 */
	int SOURCE_INSTANCE_SELECTOR = 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_INSTANCE_SELECTOR__EXPRESSION = INSTANCE_SELECTOR__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_INSTANCE_SELECTOR__MODIFIERS = INSTANCE_SELECTOR__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_INSTANCE_SELECTOR__TARGET = INSTANCE_SELECTOR__TARGET;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_INSTANCE_SELECTOR__SOURCE_ELEMENTS = INSTANCE_SELECTOR__SOURCE_ELEMENTS;

	/**
	 * The number of structural features of the '<em>Source Instance Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_INSTANCE_SELECTOR_FEATURE_COUNT = INSTANCE_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate No Modified Attribute Element Types In Condition Model Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_INSTANCE_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP = INSTANCE_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Source Instance Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_INSTANCE_SELECTOR_OPERATION_COUNT = INSTANCE_SELECTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.TargetInstanceSelectorImpl <em>Target Instance Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.TargetInstanceSelectorImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getTargetInstanceSelector()
	 * @generated
	 */
	int TARGET_INSTANCE_SELECTOR = 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR__EXPRESSION = INSTANCE_SELECTOR__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR__MODIFIERS = INSTANCE_SELECTOR__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR__TARGET = INSTANCE_SELECTOR__TARGET;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR__SOURCE_ELEMENTS = INSTANCE_SELECTOR__SOURCE_ELEMENTS;

	/**
	 * The number of structural features of the '<em>Target Instance Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR_FEATURE_COUNT = INSTANCE_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate No Modified Attribute Element Types In Condition Model Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP = INSTANCE_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Target Instance Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR_OPERATION_COUNT = INSTANCE_SELECTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.InstanceSelectorSourceInterface <em>Instance Selector Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.InstanceSelectorSourceInterface
	 * @see pamtram.structure.impl.StructurePackageImpl#getInstanceSelectorSourceInterface()
	 * @generated
	 */
	int INSTANCE_SELECTOR_SOURCE_INTERFACE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_INTERFACE__NAME = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE__NAME;

	/**
	 * The number of structural features of the '<em>Instance Selector Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_INTERFACE_FEATURE_COUNT = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Instance Selector Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_INTERFACE_OPERATION_COUNT = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.ModifiedAttributeElementTypeImpl <em>Modified Attribute Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.ModifiedAttributeElementTypeImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getModifiedAttributeElementType()
	 * @generated
	 */
	int MODIFIED_ATTRIBUTE_ELEMENT_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIERS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link pamtram.structure.impl.LocalModifiedAttributeElementTypeImpl <em>Local Modified Attribute Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.LocalModifiedAttributeElementTypeImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getLocalModifiedAttributeElementType()
	 * @generated
	 */
	int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIERS = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

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
	 * The meta object id for the '{@link pamtram.structure.impl.InstanceSelectorSourceElementImpl <em>Instance Selector Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.InstanceSelectorSourceElementImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getInstanceSelectorSourceElement()
	 * @generated
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT__NAME = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT__MODIFIERS = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT__SOURCE = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The number of structural features of the '<em>Instance Selector Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT_FEATURE_COUNT = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT___GET_MAPPING = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Instance Selector Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT_OPERATION_COUNT = LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.ExternalModifiedAttributeElementTypeImpl <em>External Modified Attribute Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.ExternalModifiedAttributeElementTypeImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getExternalModifiedAttributeElementType()
	 * @generated
	 */
	int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIERS = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

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
	 * The meta object id for the '{@link pamtram.structure.impl.InstanceSelectorExternalSourceElementImpl <em>Instance Selector External Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.InstanceSelectorExternalSourceElementImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getInstanceSelectorExternalSourceElement()
	 * @generated
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT__NAME = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT__MODIFIERS = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT__SOURCE = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The number of structural features of the '<em>Instance Selector External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT_FEATURE_COUNT = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Instance Selector External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT_OPERATION_COUNT = EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.GlobalModifiedAttributeElementTypeImpl <em>Global Modified Attribute Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.GlobalModifiedAttributeElementTypeImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getGlobalModifiedAttributeElementType()
	 * @generated
	 */
	int GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIERS = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__INSTANCE_SELECTORS = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

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
	 * Returns the meta object for class '{@link pamtram.structure.InstanceSelector <em>Instance Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Selector</em>'.
	 * @see pamtram.structure.InstanceSelector
	 * @generated
	 */
	EClass getInstanceSelector();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.InstanceSelector#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see pamtram.structure.InstanceSelector#getTarget()
	 * @see #getInstanceSelector()
	 * @generated
	 */
	EReference getInstanceSelector_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.structure.InstanceSelector#getSourceElements <em>Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Elements</em>'.
	 * @see pamtram.structure.InstanceSelector#getSourceElements()
	 * @see #getInstanceSelector()
	 * @generated
	 */
	EReference getInstanceSelector_SourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.InstanceSelector#validateNoModifiedAttributeElementTypesInConditionModelConditions(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Modified Attribute Element Types In Condition Model Conditions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate No Modified Attribute Element Types In Condition Model Conditions</em>' operation.
	 * @see pamtram.structure.InstanceSelector#validateNoModifiedAttributeElementTypesInConditionModelConditions(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getInstanceSelector__ValidateNoModifiedAttributeElementTypesInConditionModelConditions__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.SourceInstanceSelector <em>Source Instance Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Instance Selector</em>'.
	 * @see pamtram.structure.SourceInstanceSelector
	 * @generated
	 */
	EClass getSourceInstanceSelector();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.TargetInstanceSelector <em>Target Instance Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Instance Selector</em>'.
	 * @see pamtram.structure.TargetInstanceSelector
	 * @generated
	 */
	EClass getTargetInstanceSelector();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.InstanceSelectorSourceInterface <em>Instance Selector Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Selector Source Interface</em>'.
	 * @see pamtram.structure.InstanceSelectorSourceInterface
	 * @generated
	 */
	EClass getInstanceSelectorSourceInterface();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.InstanceSelectorSourceElement <em>Instance Selector Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Selector Source Element</em>'.
	 * @see pamtram.structure.InstanceSelectorSourceElement
	 * @generated
	 */
	EClass getInstanceSelectorSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.InstanceSelectorExternalSourceElement <em>Instance Selector External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Selector External Source Element</em>'.
	 * @see pamtram.structure.InstanceSelectorExternalSourceElement
	 * @generated
	 */
	EClass getInstanceSelectorExternalSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.ModifiedAttributeElementType <em>Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modified Attribute Element Type</em>'.
	 * @see pamtram.structure.ModifiedAttributeElementType
	 * @generated
	 */
	EClass getModifiedAttributeElementType();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.ModifiedAttributeElementType#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see pamtram.structure.ModifiedAttributeElementType#getSource()
	 * @see #getModifiedAttributeElementType()
	 * @generated
	 */
	EReference getModifiedAttributeElementType_Source();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.ModifiedAttributeElementType#getMappingHintGroup() <em>Get Mapping Hint Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Mapping Hint Group</em>' operation.
	 * @see pamtram.structure.ModifiedAttributeElementType#getMappingHintGroup()
	 * @generated
	 */
	EOperation getModifiedAttributeElementType__GetMappingHintGroup();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.ModifiedAttributeElementType#getMapping() <em>Get Mapping</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Mapping</em>' operation.
	 * @see pamtram.structure.ModifiedAttributeElementType#getMapping()
	 * @generated
	 */
	EOperation getModifiedAttributeElementType__GetMapping();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.LocalModifiedAttributeElementType <em>Local Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Modified Attribute Element Type</em>'.
	 * @see pamtram.structure.LocalModifiedAttributeElementType
	 * @generated
	 */
	EClass getLocalModifiedAttributeElementType();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.LocalModifiedAttributeElementType#validateSourceAttributeMatchesSectionOrContainedSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Attribute Matches Section Or Contained Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * @see pamtram.structure.LocalModifiedAttributeElementType#validateSourceAttributeMatchesSectionOrContainedSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLocalModifiedAttributeElementType__ValidateSourceAttributeMatchesSectionOrContainedSection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.ExternalModifiedAttributeElementType <em>External Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Modified Attribute Element Type</em>'.
	 * @see pamtram.structure.ExternalModifiedAttributeElementType
	 * @generated
	 */
	EClass getExternalModifiedAttributeElementType();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.ExternalModifiedAttributeElementType#validateSourceAttributeMatchesContainerSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Attribute Matches Container Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * @see pamtram.structure.ExternalModifiedAttributeElementType#validateSourceAttributeMatchesContainerSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getExternalModifiedAttributeElementType__ValidateSourceAttributeMatchesContainerSection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.GlobalModifiedAttributeElementType <em>Global Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Modified Attribute Element Type</em>'.
	 * @see pamtram.structure.GlobalModifiedAttributeElementType
	 * @generated
	 */
	EClass getGlobalModifiedAttributeElementType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StructureFactory getStructureFactory();

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
		 * The meta object literal for the '{@link pamtram.structure.impl.InstanceSelectorImpl <em>Instance Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.InstanceSelectorImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getInstanceSelector()
		 * @generated
		 */
		EClass INSTANCE_SELECTOR = eINSTANCE.getInstanceSelector();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_SELECTOR__TARGET = eINSTANCE.getInstanceSelector_Target();

		/**
		 * The meta object literal for the '<em><b>Source Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_SELECTOR__SOURCE_ELEMENTS = eINSTANCE.getInstanceSelector_SourceElements();

		/**
		 * The meta object literal for the '<em><b>Validate No Modified Attribute Element Types In Condition Model Conditions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INSTANCE_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getInstanceSelector__ValidateNoModifiedAttributeElementTypesInConditionModelConditions__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.SourceInstanceSelectorImpl <em>Source Instance Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.SourceInstanceSelectorImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getSourceInstanceSelector()
		 * @generated
		 */
		EClass SOURCE_INSTANCE_SELECTOR = eINSTANCE.getSourceInstanceSelector();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.TargetInstanceSelectorImpl <em>Target Instance Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.TargetInstanceSelectorImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getTargetInstanceSelector()
		 * @generated
		 */
		EClass TARGET_INSTANCE_SELECTOR = eINSTANCE.getTargetInstanceSelector();

		/**
		 * The meta object literal for the '{@link pamtram.structure.InstanceSelectorSourceInterface <em>Instance Selector Source Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.InstanceSelectorSourceInterface
		 * @see pamtram.structure.impl.StructurePackageImpl#getInstanceSelectorSourceInterface()
		 * @generated
		 */
		EClass INSTANCE_SELECTOR_SOURCE_INTERFACE = eINSTANCE.getInstanceSelectorSourceInterface();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.InstanceSelectorSourceElementImpl <em>Instance Selector Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.InstanceSelectorSourceElementImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getInstanceSelectorSourceElement()
		 * @generated
		 */
		EClass INSTANCE_SELECTOR_SOURCE_ELEMENT = eINSTANCE.getInstanceSelectorSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.InstanceSelectorExternalSourceElementImpl <em>Instance Selector External Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.InstanceSelectorExternalSourceElementImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getInstanceSelectorExternalSourceElement()
		 * @generated
		 */
		EClass INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT = eINSTANCE.getInstanceSelectorExternalSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.ModifiedAttributeElementTypeImpl <em>Modified Attribute Element Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.ModifiedAttributeElementTypeImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getModifiedAttributeElementType()
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
		 * The meta object literal for the '{@link pamtram.structure.impl.LocalModifiedAttributeElementTypeImpl <em>Local Modified Attribute Element Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.LocalModifiedAttributeElementTypeImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getLocalModifiedAttributeElementType()
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
		 * The meta object literal for the '{@link pamtram.structure.impl.ExternalModifiedAttributeElementTypeImpl <em>External Modified Attribute Element Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.ExternalModifiedAttributeElementTypeImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getExternalModifiedAttributeElementType()
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
		 * The meta object literal for the '{@link pamtram.structure.impl.GlobalModifiedAttributeElementTypeImpl <em>Global Modified Attribute Element Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.GlobalModifiedAttributeElementTypeImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getGlobalModifiedAttributeElementType()
		 * @generated
		 */
		EClass GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE = eINSTANCE.getGlobalModifiedAttributeElementType();

	}

} //StructurePackage
