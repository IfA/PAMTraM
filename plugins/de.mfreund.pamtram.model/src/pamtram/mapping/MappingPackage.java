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
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
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
	 * The feature id for the '<em><b>Source MM Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TYPE__SOURCE_MM_SECTION = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TYPE_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Source MM Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SOURCE_MM_SECTION = MAPPING_TYPE__SOURCE_MM_SECTION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__CONDITION = MAPPING_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Hint Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__MAPPING_HINT_GROUPS = MAPPING_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Imported Mapping Hint Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__IMPORTED_MAPPING_HINT_GROUPS = MAPPING_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Global Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__GLOBAL_VARIABLES = MAPPING_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = MAPPING_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_COUNT = MAPPING_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingHintTypeImpl <em>Hint Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingHintTypeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintType()
	 * @generated
	 */
	int MAPPING_HINT_TYPE = 28;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingHintImpl <em>Hint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingHintImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHint()
	 * @generated
	 */
	int MAPPING_HINT = 5;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeMappingImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMapping()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING = 6;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.CardinalityMappingImpl <em>Cardinality Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.CardinalityMappingImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getCardinalityMapping()
	 * @generated
	 */
	int CARDINALITY_MAPPING = 7;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingInstanceSelectorImpl <em>Instance Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingInstanceSelectorImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingInstanceSelector()
	 * @generated
	 */
	int MAPPING_INSTANCE_SELECTOR = 8;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MatcherImpl <em>Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MatcherImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMatcher()
	 * @generated
	 */
	int MATCHER = 9;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeMatcherImpl <em>Attribute Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeMatcherImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMatcher()
	 * @generated
	 */
	int ATTRIBUTE_MATCHER = 10;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ClassMatcherImpl <em>Class Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ClassMatcherImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getClassMatcher()
	 * @generated
	 */
	int CLASS_MATCHER = 11;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeValueModifierImpl <em>Attribute Value Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeValueModifierImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeValueModifier()
	 * @generated
	 */
	int ATTRIBUTE_VALUE_MODIFIER = 13;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.SubstringReplacerImpl <em>Substring Replacer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.SubstringReplacerImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getSubstringReplacer()
	 * @generated
	 */
	int SUBSTRING_REPLACER = 14;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.StringAppenderImpl <em>String Appender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.StringAppenderImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getStringAppender()
	 * @generated
	 */
	int STRING_APPENDER = 15;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.UniqueNumberAppenderImpl <em>Unique Number Appender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.UniqueNumberAppenderImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getUniqueNumberAppender()
	 * @generated
	 */
	int UNIQUE_NUMBER_APPENDER = 16;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.StringPrependerImpl <em>String Prepender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.StringPrependerImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getStringPrepender()
	 * @generated
	 */
	int STRING_PREPENDER = 17;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ModifiedAttributeElementTypeImpl <em>Modified Attribute Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ModifiedAttributeElementTypeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getModifiedAttributeElementType()
	 * @generated
	 */
	int MODIFIED_ATTRIBUTE_ELEMENT_TYPE = 18;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeValueModifierSetImpl <em>Attribute Value Modifier Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeValueModifierSetImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeValueModifierSet()
	 * @generated
	 */
	int ATTRIBUTE_VALUE_MODIFIER_SET = 12;

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
	 * The feature id for the '<em><b>Target MM Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Hints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Hint Group Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_TYPE_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

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
	 * The number of structural features of the '<em>Instantiable Mapping Hint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIABLE_MAPPING_HINT_GROUP_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Instantiable Mapping Hint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIABLE_MAPPING_HINT_GROUP_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__NAME = MAPPING_HINT_GROUP_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Target MM Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__TARGET_MM_SECTION = MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION;

	/**
	 * The feature id for the '<em><b>Mapping Hints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__MAPPING_HINTS = MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS;

	/**
	 * The feature id for the '<em><b>Model Connection Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER = MAPPING_HINT_GROUP_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Hint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_FEATURE_COUNT = MAPPING_HINT_GROUP_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Hint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_OPERATION_COUNT = MAPPING_HINT_GROUP_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_TYPE__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Hint Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_TYPE_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Hint Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_TYPE_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT__NAME = MAPPING_HINT_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_FEATURE_COUNT = MAPPING_HINT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_OPERATION_COUNT = MAPPING_HINT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__NAME = MAPPING_HINT__NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__TARGET = MAPPING_HINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Attribute Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS = MAPPING_HINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__EXPRESSION = MAPPING_HINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Result Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__RESULT_MODIFIER = MAPPING_HINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Attribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_FEATURE_COUNT = MAPPING_HINT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Local Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING___GET_LOCAL_SOURCE_ELEMENTS = MAPPING_HINT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_OPERATION_COUNT = MAPPING_HINT_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING__NAME = MAPPING_HINT__NAME;

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
	 * The number of operations of the '<em>Cardinality Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_MAPPING_OPERATION_COUNT = MAPPING_HINT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INSTANCE_SELECTOR__NAME = MAPPING_HINT__NAME;

	/**
	 * The feature id for the '<em><b>Affected Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE = MAPPING_HINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INSTANCE_SELECTOR__MATCHER = MAPPING_HINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Instance Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INSTANCE_SELECTOR_FEATURE_COUNT = MAPPING_HINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Instance Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INSTANCE_SELECTOR_OPERATION_COUNT = MAPPING_HINT_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Target Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER__TARGET_ATTRIBUTE = MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_FEATURE_COUNT = MATCHER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MATCHER_OPERATION_COUNT = MATCHER_OPERATION_COUNT + 0;

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
	int ATTRIBUTE_VALUE_MODIFIER_SET__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_MODIFIER_SET__MODIFIER = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Value Modifier Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_MODIFIER_SET_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Value Modifier Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_MODIFIER_SET_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_MODIFIER__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Attribute Value Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_MODIFIER_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_MODIFIER___MODIFY_VALUE__STRING = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Value Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_MODIFIER_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_REPLACER__NAME = ATTRIBUTE_VALUE_MODIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_REPLACER__REGEX = ATTRIBUTE_VALUE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replacement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_REPLACER__REPLACEMENT = ATTRIBUTE_VALUE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Substring Replacer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_REPLACER_FEATURE_COUNT = ATTRIBUTE_VALUE_MODIFIER_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_REPLACER___MODIFY_VALUE__STRING = ATTRIBUTE_VALUE_MODIFIER___MODIFY_VALUE__STRING;

	/**
	 * The number of operations of the '<em>Substring Replacer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_REPLACER_OPERATION_COUNT = ATTRIBUTE_VALUE_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_APPENDER__NAME = ATTRIBUTE_VALUE_MODIFIER__NAME;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_APPENDER__STRING = ATTRIBUTE_VALUE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_APPENDER_FEATURE_COUNT = ATTRIBUTE_VALUE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_APPENDER___MODIFY_VALUE__STRING = ATTRIBUTE_VALUE_MODIFIER___MODIFY_VALUE__STRING;

	/**
	 * The number of operations of the '<em>String Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_APPENDER_OPERATION_COUNT = ATTRIBUTE_VALUE_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_NUMBER_APPENDER__NAME = ATTRIBUTE_VALUE_MODIFIER__NAME;

	/**
	 * The number of structural features of the '<em>Unique Number Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_NUMBER_APPENDER_FEATURE_COUNT = ATTRIBUTE_VALUE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_NUMBER_APPENDER___MODIFY_VALUE__STRING = ATTRIBUTE_VALUE_MODIFIER___MODIFY_VALUE__STRING;

	/**
	 * The number of operations of the '<em>Unique Number Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_NUMBER_APPENDER_OPERATION_COUNT = ATTRIBUTE_VALUE_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PREPENDER__NAME = ATTRIBUTE_VALUE_MODIFIER__NAME;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PREPENDER__STRING = ATTRIBUTE_VALUE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Prepender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PREPENDER_FEATURE_COUNT = ATTRIBUTE_VALUE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PREPENDER___MODIFY_VALUE__STRING = ATTRIBUTE_VALUE_MODIFIER___MODIFY_VALUE__STRING;

	/**
	 * The number of operations of the '<em>String Prepender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PREPENDER_OPERATION_COUNT = ATTRIBUTE_VALUE_MODIFIER_OPERATION_COUNT + 0;

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
	 * The number of operations of the '<em>Modified Attribute Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Hint Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER__CONTAINER = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mapping Hints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Hint Group Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Hint Group Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP__NAME = MAPPING_HINT_GROUP_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Target MM Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP__TARGET_MM_SECTION = MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION;

	/**
	 * The feature id for the '<em><b>Mapping Hints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_MAPPING_HINT_GROUP__MAPPING_HINTS = MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS;

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
	 * The meta object id for the '{@link pamtram.mapping.impl.ModelConnectionHintImpl <em>Model Connection Hint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ModelConnectionHintImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getModelConnectionHint()
	 * @generated
	 */
	int MODEL_CONNECTION_HINT = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Target Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT__SOURCE_ELEMENTS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Connection Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Source Attributes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT___GET_SOURCE_ATTRIBUTES = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Local Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT___GET_LOCAL_SOURCE_ELEMENTS = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Model Connection Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 2;


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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT__NAME = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT__SOURCE = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT__MODIFIER = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>Attribute Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_FEATURE_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT___GET_NAME = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ComplexAttributeMatcherImpl <em>Complex Attribute Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ComplexAttributeMatcherImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexAttributeMatcher()
	 * @generated
	 */
	int COMPLEX_ATTRIBUTE_MATCHER = 23;

	/**
	 * The feature id for the '<em><b>Target Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER__TARGET_ATTRIBUTE = ATTRIBUTE_MATCHER__TARGET_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Source Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES = ATTRIBUTE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Complex Attribute Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_FEATURE_COUNT = ATTRIBUTE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Local Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER___GET_LOCAL_SOURCE_ELEMENTS = ATTRIBUTE_MATCHER_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Complex Attribute Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_OPERATION_COUNT = ATTRIBUTE_MATCHER_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.SimpleAttributeMatcherImpl <em>Simple Attribute Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.SimpleAttributeMatcherImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getSimpleAttributeMatcher()
	 * @generated
	 */
	int SIMPLE_ATTRIBUTE_MATCHER = 24;

	/**
	 * The feature id for the '<em><b>Target Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ATTRIBUTE_MATCHER__TARGET_ATTRIBUTE = ATTRIBUTE_MATCHER__TARGET_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ATTRIBUTE_MATCHER__NAME = ATTRIBUTE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ATTRIBUTE_MATCHER__SOURCE = ATTRIBUTE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ATTRIBUTE_MATCHER__MODIFIER = ATTRIBUTE_MATCHER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Simple Attribute Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ATTRIBUTE_MATCHER_FEATURE_COUNT = ATTRIBUTE_MATCHER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Simple Attribute Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ATTRIBUTE_MATCHER_OPERATION_COUNT = ATTRIBUTE_MATCHER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ComplexAttributeMatcherSourceElementImpl <em>Complex Attribute Matcher Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ComplexAttributeMatcherSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexAttributeMatcherSourceElement()
	 * @generated
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT__NAME = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT__SOURCE = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT__MODIFIER = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.HintImporterMappingHintImpl <em>Hint Importer Mapping Hint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.HintImporterMappingHintImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getHintImporterMappingHint()
	 * @generated
	 */
	int HINT_IMPORTER_MAPPING_HINT = 29;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappedAttributeValueExpanderTypeImpl <em>Mapped Attribute Value Expander Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappedAttributeValueExpanderTypeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappedAttributeValueExpanderType()
	 * @generated
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE = 31;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappedAttributeValueExpanderImpl <em>Mapped Attribute Value Expander</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappedAttributeValueExpanderImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappedAttributeValueExpander()
	 * @generated
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER = 30;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappedAttributeValuePrependerImpl <em>Mapped Attribute Value Prepender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappedAttributeValuePrependerImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappedAttributeValuePrepender()
	 * @generated
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER = 32;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappedAttributeValueAppenderImpl <em>Mapped Attribute Value Appender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappedAttributeValueAppenderImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappedAttributeValueAppender()
	 * @generated
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER = 33;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.GlobalAttributeImpl <em>Global Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.GlobalAttributeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getGlobalAttribute()
	 * @generated
	 */
	int GLOBAL_ATTRIBUTE = 34;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.GlobalAttributeImporterImpl <em>Global Attribute Importer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.GlobalAttributeImporterImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getGlobalAttributeImporter()
	 * @generated
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER = 35;

	/**
	 * The meta object id for the '{@link pamtram.mapping.AttributeMappingSourceInterface <em>Attribute Mapping Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.AttributeMappingSourceInterface
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMappingSourceInterface()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE = 36;

	/**
	 * The meta object id for the '{@link pamtram.mapping.ComplexMappingHintSourceInterface <em>Complex Mapping Hint Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.ComplexMappingHintSourceInterface
	 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexMappingHintSourceInterface()
	 * @generated
	 */
	int COMPLEX_MAPPING_HINT_SOURCE_INTERFACE = 37;

	/**
	 * The meta object id for the '{@link pamtram.mapping.ComplexAttributeMatcherSourceInterface <em>Complex Attribute Matcher Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.ComplexAttributeMatcherSourceInterface
	 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexAttributeMatcherSourceInterface()
	 * @generated
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_INTERFACE = 38;

	/**
	 * The number of structural features of the '<em>Complex Attribute Matcher Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT_FEATURE_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT___GET_NAME = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Complex Attribute Matcher Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT_OPERATION_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ModelConnectionHintSourceElementImpl <em>Model Connection Hint Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ModelConnectionHintSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getModelConnectionHintSourceElement()
	 * @generated
	 */
	int MODEL_CONNECTION_HINT_SOURCE_ELEMENT = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_SOURCE_ELEMENT__NAME = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_SOURCE_ELEMENT__SOURCE = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_SOURCE_ELEMENT__MODIFIER = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>Model Connection Hint Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_SOURCE_ELEMENT_FEATURE_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_SOURCE_ELEMENT___GET_NAME = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Model Connection Hint Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_SOURCE_ELEMENT_OPERATION_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ModelConnectionHintTargetAttributeImpl <em>Model Connection Hint Target Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ModelConnectionHintTargetAttributeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getModelConnectionHintTargetAttribute()
	 * @generated
	 */
	int MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE__NAME = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE__SOURCE = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE__MODIFIER = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>Model Connection Hint Target Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE_FEATURE_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Model Connection Hint Target Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE_OPERATION_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

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
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__NAME = HINT_IMPORTER_MAPPING_HINT__NAME;

	/**
	 * The feature id for the '<em><b>Source Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__SOURCE_ATTRIBUTE = HINT_IMPORTER_MAPPING_HINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__MODIFIERS = HINT_IMPORTER_MAPPING_HINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapped Attribute Value Expander Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE_FEATURE_COUNT = HINT_IMPORTER_MAPPING_HINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Mapped Attribute Value Expander Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE_OPERATION_COUNT = HINT_IMPORTER_MAPPING_HINT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME = MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE_ATTRIBUTE = MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__SOURCE_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIERS = MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Hints To Expand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND = MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapped Attribute Value Expander</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER_FEATURE_COUNT = MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mapped Attribute Value Expander</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT = MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER__NAME = MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME;

	/**
	 * The feature id for the '<em><b>Source Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER__SOURCE_ATTRIBUTE = MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER__MODIFIERS = MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Hints To Expand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER__HINTS_TO_EXPAND = MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND;

	/**
	 * The number of structural features of the '<em>Mapped Attribute Value Prepender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER_FEATURE_COUNT = MAPPED_ATTRIBUTE_VALUE_EXPANDER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mapped Attribute Value Prepender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_PREPENDER_OPERATION_COUNT = MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER__NAME = MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME;

	/**
	 * The feature id for the '<em><b>Source Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER__SOURCE_ATTRIBUTE = MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER__MODIFIERS = MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Hints To Expand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER__HINTS_TO_EXPAND = MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND;

	/**
	 * The number of structural features of the '<em>Mapped Attribute Value Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER_FEATURE_COUNT = MAPPED_ATTRIBUTE_VALUE_EXPANDER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mapped Attribute Value Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ATTRIBUTE_VALUE_APPENDER_OPERATION_COUNT = MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT + 0;

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
	 * The number of operations of the '<em>Global Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

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
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER___GET_NAME = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Global Attribute Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_ATTRIBUTE_IMPORTER_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Complex Mapping Hint Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE = 0;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_NAME = 1;

	/**
	 * The number of operations of the '<em>Complex Mapping Hint Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT = 2;

	/**
	 * The number of structural features of the '<em>Attribute Mapping Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE_FEATURE_COUNT = COMPLEX_MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE = COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE___GET_NAME = COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_NAME;

	/**
	 * The number of operations of the '<em>Attribute Mapping Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_INTERFACE_OPERATION_COUNT = COMPLEX_MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Complex Attribute Matcher Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_INTERFACE_FEATURE_COUNT = COMPLEX_MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE = COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_INTERFACE___GET_NAME = COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_NAME;

	/**
	 * The number of operations of the '<em>Complex Attribute Matcher Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_INTERFACE_OPERATION_COUNT = COMPLEX_MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.ModelConnectionHintSourceInterface <em>Model Connection Hint Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.ModelConnectionHintSourceInterface
	 * @see pamtram.mapping.impl.MappingPackageImpl#getModelConnectionHintSourceInterface()
	 * @generated
	 */
	int MODEL_CONNECTION_HINT_SOURCE_INTERFACE = 39;

	/**
	 * The number of structural features of the '<em>Model Connection Hint Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_SOURCE_INTERFACE_FEATURE_COUNT = COMPLEX_MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE = COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_SOURCE_INTERFACE___GET_NAME = COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_NAME;

	/**
	 * The number of operations of the '<em>Model Connection Hint Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_SOURCE_INTERFACE_OPERATION_COUNT = COMPLEX_MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ComplexAttributeMappingExternalSourceElementImpl <em>Complex Attribute Mapping External Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ComplexAttributeMappingExternalSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexAttributeMappingExternalSourceElement()
	 * @generated
	 */
	int COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT = 40;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ExternalAttributeMappingSourceElementImpl <em>External Attribute Mapping Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ExternalAttributeMappingSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getExternalAttributeMappingSourceElement()
	 * @generated
	 */
	int EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT = 41;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT__NAME = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT__SOURCE = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT__MODIFIER = MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>External Attribute Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT_FEATURE_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>External Attribute Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT = MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__NAME = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__SOURCE = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT__MODIFIER = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT__MODIFIER;

	/**
	 * The number of structural features of the '<em>Complex Attribute Mapping External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT_FEATURE_COUNT = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT___GET_NAME = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Complex Attribute Mapping External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT_OPERATION_COUNT = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ComplexModelConnectionHintExternalSourceElementImpl <em>Complex Model Connection Hint External Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ComplexModelConnectionHintExternalSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexModelConnectionHintExternalSourceElement()
	 * @generated
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_EXTERNAL_SOURCE_ELEMENT = 42;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_EXTERNAL_SOURCE_ELEMENT__NAME = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_EXTERNAL_SOURCE_ELEMENT__SOURCE = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_EXTERNAL_SOURCE_ELEMENT__MODIFIER = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT__MODIFIER;

	/**
	 * The number of structural features of the '<em>Complex Model Connection Hint External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_EXTERNAL_SOURCE_ELEMENT_FEATURE_COUNT = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_EXTERNAL_SOURCE_ELEMENT___GET_NAME = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Complex Model Connection Hint External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_EXTERNAL_SOURCE_ELEMENT_OPERATION_COUNT = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ComplexAttributeMatcherExternalSourceElementImpl <em>Complex Attribute Matcher External Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ComplexAttributeMatcherExternalSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexAttributeMatcherExternalSourceElement()
	 * @generated
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT = 43;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT__NAME = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT__SOURCE = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT__MODIFIER = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT__MODIFIER;

	/**
	 * The number of structural features of the '<em>Complex Attribute Matcher External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT_FEATURE_COUNT = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT___GET_NAME = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Complex Attribute Matcher External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT_OPERATION_COUNT = EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ExternalMappedAttributeValueExpanderImpl <em>External Mapped Attribute Value Expander</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ExternalMappedAttributeValueExpanderImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getExternalMappedAttributeValueExpander()
	 * @generated
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER = 44;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME = MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME;

	/**
	 * The feature id for the '<em><b>Source Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE_ATTRIBUTE = MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIERS = MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Hints To Expand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND = MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND;

	/**
	 * The number of structural features of the '<em>External Mapped Attribute Value Expander</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_FEATURE_COUNT = MAPPED_ATTRIBUTE_VALUE_EXPANDER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>External Mapped Attribute Value Expander</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT = MAPPED_ATTRIBUTE_VALUE_EXPANDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ExternalMappedAttributeValuePrependerImpl <em>External Mapped Attribute Value Prepender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ExternalMappedAttributeValuePrependerImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getExternalMappedAttributeValuePrepender()
	 * @generated
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER = 45;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER__NAME = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME;

	/**
	 * The feature id for the '<em><b>Source Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER__SOURCE_ATTRIBUTE = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER__MODIFIERS = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIERS;

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
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER = 46;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER__NAME = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__NAME;

	/**
	 * The feature id for the '<em><b>Source Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER__SOURCE_ATTRIBUTE = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER__MODIFIERS = EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIERS;

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
	int EXPANDABLE_HINT = 47;

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
	 * The meta object id for the '{@link pamtram.mapping.impl.MatchToLowerCaseConverterImpl <em>Match To Lower Case Converter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MatchToLowerCaseConverterImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMatchToLowerCaseConverter()
	 * @generated
	 */
	int MATCH_TO_LOWER_CASE_CONVERTER = 48;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_TO_LOWER_CASE_CONVERTER__NAME = ATTRIBUTE_VALUE_MODIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_TO_LOWER_CASE_CONVERTER__REGEX = ATTRIBUTE_VALUE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Match To Lower Case Converter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_TO_LOWER_CASE_CONVERTER_FEATURE_COUNT = ATTRIBUTE_VALUE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_TO_LOWER_CASE_CONVERTER___MODIFY_VALUE__STRING = ATTRIBUTE_VALUE_MODIFIER___MODIFY_VALUE__STRING;

	/**
	 * The number of operations of the '<em>Match To Lower Case Converter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_TO_LOWER_CASE_CONVERTER_OPERATION_COUNT = ATTRIBUTE_VALUE_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MatchToUpperCaseConverterImpl <em>Match To Upper Case Converter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MatchToUpperCaseConverterImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMatchToUpperCaseConverter()
	 * @generated
	 */
	int MATCH_TO_UPPER_CASE_CONVERTER = 49;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_TO_UPPER_CASE_CONVERTER__NAME = ATTRIBUTE_VALUE_MODIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_TO_UPPER_CASE_CONVERTER__REGEX = ATTRIBUTE_VALUE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Match To Upper Case Converter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_TO_UPPER_CASE_CONVERTER_FEATURE_COUNT = ATTRIBUTE_VALUE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_TO_UPPER_CASE_CONVERTER___MODIFY_VALUE__STRING = ATTRIBUTE_VALUE_MODIFIER___MODIFY_VALUE__STRING;

	/**
	 * The number of operations of the '<em>Match To Upper Case Converter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_TO_UPPER_CASE_CONVERTER_OPERATION_COUNT = ATTRIBUTE_VALUE_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.GlobalValueImpl <em>Global Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.GlobalValueImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getGlobalValue()
	 * @generated
	 */
	int GLOBAL_VALUE = 50;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_VALUE__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_VALUE__VALUE = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Global Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_VALUE_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Global Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_VALUE_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

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
	 * Returns the meta object for the containment reference '{@link pamtram.mapping.Mapping#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see pamtram.mapping.Mapping#getCondition()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Condition();

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
	 * Returns the meta object for class '{@link pamtram.mapping.MappingType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see pamtram.mapping.MappingType
	 * @generated
	 */
	EClass getMappingType();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.MappingType#getSourceMMSection <em>Source MM Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source MM Section</em>'.
	 * @see pamtram.mapping.MappingType#getSourceMMSection()
	 * @see #getMappingType()
	 * @generated
	 */
	EReference getMappingType_SourceMMSection();

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
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.AttributeMapping#getSourceAttributeMappings <em>Source Attribute Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Attribute Mappings</em>'.
	 * @see pamtram.mapping.AttributeMapping#getSourceAttributeMappings()
	 * @see #getAttributeMapping()
	 * @generated
	 */
	EReference getAttributeMapping_SourceAttributeMappings();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.AttributeMapping#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see pamtram.mapping.AttributeMapping#getExpression()
	 * @see #getAttributeMapping()
	 * @generated
	 */
	EAttribute getAttributeMapping_Expression();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.mapping.AttributeMapping#getResultModifier <em>Result Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Result Modifier</em>'.
	 * @see pamtram.mapping.AttributeMapping#getResultModifier()
	 * @see #getAttributeMapping()
	 * @generated
	 */
	EReference getAttributeMapping_ResultModifier();

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
	 * Returns the meta object for class '{@link pamtram.mapping.MappingInstanceSelector <em>Instance Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Selector</em>'.
	 * @see pamtram.mapping.MappingInstanceSelector
	 * @generated
	 */
	EClass getMappingInstanceSelector();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.MappingInstanceSelector#getAffectedReference <em>Affected Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Affected Reference</em>'.
	 * @see pamtram.mapping.MappingInstanceSelector#getAffectedReference()
	 * @see #getMappingInstanceSelector()
	 * @generated
	 */
	EReference getMappingInstanceSelector_AffectedReference();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.mapping.MappingInstanceSelector#getMatcher <em>Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Matcher</em>'.
	 * @see pamtram.mapping.MappingInstanceSelector#getMatcher()
	 * @see #getMappingInstanceSelector()
	 * @generated
	 */
	EReference getMappingInstanceSelector_Matcher();

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
	 * Returns the meta object for the reference '{@link pamtram.mapping.AttributeMatcher#getTargetAttribute <em>Target Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Attribute</em>'.
	 * @see pamtram.mapping.AttributeMatcher#getTargetAttribute()
	 * @see #getAttributeMatcher()
	 * @generated
	 */
	EReference getAttributeMatcher_TargetAttribute();

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
	 * Returns the meta object for class '{@link pamtram.mapping.AttributeValueModifier <em>Attribute Value Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Value Modifier</em>'.
	 * @see pamtram.mapping.AttributeValueModifier
	 * @generated
	 */
	EClass getAttributeValueModifier();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.AttributeValueModifier#modifyValue(java.lang.String) <em>Modify Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Modify Value</em>' operation.
	 * @see pamtram.mapping.AttributeValueModifier#modifyValue(java.lang.String)
	 * @generated
	 */
	EOperation getAttributeValueModifier__ModifyValue__String();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.SubstringReplacer <em>Substring Replacer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Substring Replacer</em>'.
	 * @see pamtram.mapping.SubstringReplacer
	 * @generated
	 */
	EClass getSubstringReplacer();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.SubstringReplacer#getRegex <em>Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Regex</em>'.
	 * @see pamtram.mapping.SubstringReplacer#getRegex()
	 * @see #getSubstringReplacer()
	 * @generated
	 */
	EAttribute getSubstringReplacer_Regex();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.SubstringReplacer#getReplacement <em>Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Replacement</em>'.
	 * @see pamtram.mapping.SubstringReplacer#getReplacement()
	 * @see #getSubstringReplacer()
	 * @generated
	 */
	EAttribute getSubstringReplacer_Replacement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.StringAppender <em>String Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Appender</em>'.
	 * @see pamtram.mapping.StringAppender
	 * @generated
	 */
	EClass getStringAppender();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.StringAppender#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see pamtram.mapping.StringAppender#getString()
	 * @see #getStringAppender()
	 * @generated
	 */
	EAttribute getStringAppender_String();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.UniqueNumberAppender <em>Unique Number Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unique Number Appender</em>'.
	 * @see pamtram.mapping.UniqueNumberAppender
	 * @generated
	 */
	EClass getUniqueNumberAppender();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.StringPrepender <em>String Prepender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Prepender</em>'.
	 * @see pamtram.mapping.StringPrepender
	 * @generated
	 */
	EClass getStringPrepender();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.StringPrepender#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see pamtram.mapping.StringPrepender#getString()
	 * @see #getStringPrepender()
	 * @generated
	 */
	EAttribute getStringPrepender_String();

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
	 * Returns the meta object for class '{@link pamtram.mapping.AttributeValueModifierSet <em>Attribute Value Modifier Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Value Modifier Set</em>'.
	 * @see pamtram.mapping.AttributeValueModifierSet
	 * @generated
	 */
	EClass getAttributeValueModifierSet();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.AttributeValueModifierSet#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Modifier</em>'.
	 * @see pamtram.mapping.AttributeValueModifierSet#getModifier()
	 * @see #getAttributeValueModifierSet()
	 * @generated
	 */
	EReference getAttributeValueModifierSet_Modifier();

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
	 * Returns the meta object for the containment reference '{@link pamtram.mapping.MappingHintGroup#getModelConnectionMatcher <em>Model Connection Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Connection Matcher</em>'.
	 * @see pamtram.mapping.MappingHintGroup#getModelConnectionMatcher()
	 * @see #getMappingHintGroup()
	 * @generated
	 */
	EReference getMappingHintGroup_ModelConnectionMatcher();

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
	 * Returns the meta object for the reference '{@link pamtram.mapping.MappingHintGroupType#getTargetMMSection <em>Target MM Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target MM Section</em>'.
	 * @see pamtram.mapping.MappingHintGroupType#getTargetMMSection()
	 * @see #getMappingHintGroupType()
	 * @generated
	 */
	EReference getMappingHintGroupType_TargetMMSection();

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
	 * Returns the meta object for class '{@link pamtram.mapping.ModelConnectionHint <em>Model Connection Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Connection Hint</em>'.
	 * @see pamtram.mapping.ModelConnectionHint
	 * @generated
	 */
	EClass getModelConnectionHint();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.ModelConnectionHint#getTargetAttributes <em>Target Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Attributes</em>'.
	 * @see pamtram.mapping.ModelConnectionHint#getTargetAttributes()
	 * @see #getModelConnectionHint()
	 * @generated
	 */
	EReference getModelConnectionHint_TargetAttributes();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.ModelConnectionHint#getSourceElements <em>Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Elements</em>'.
	 * @see pamtram.mapping.ModelConnectionHint#getSourceElements()
	 * @see #getModelConnectionHint()
	 * @generated
	 */
	EReference getModelConnectionHint_SourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.ModelConnectionHint#getSourceAttributes() <em>Get Source Attributes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Source Attributes</em>' operation.
	 * @see pamtram.mapping.ModelConnectionHint#getSourceAttributes()
	 * @generated
	 */
	EOperation getModelConnectionHint__GetSourceAttributes();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.ModelConnectionHint#getLocalSourceElements() <em>Get Local Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Local Source Elements</em>' operation.
	 * @see pamtram.mapping.ModelConnectionHint#getLocalSourceElements()
	 * @generated
	 */
	EOperation getModelConnectionHint__GetLocalSourceElements();

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
	 * Returns the meta object for class '{@link pamtram.mapping.ComplexAttributeMatcher <em>Complex Attribute Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Attribute Matcher</em>'.
	 * @see pamtram.mapping.ComplexAttributeMatcher
	 * @generated
	 */
	EClass getComplexAttributeMatcher();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.ComplexAttributeMatcher#getSourceAttributes <em>Source Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Attributes</em>'.
	 * @see pamtram.mapping.ComplexAttributeMatcher#getSourceAttributes()
	 * @see #getComplexAttributeMatcher()
	 * @generated
	 */
	EReference getComplexAttributeMatcher_SourceAttributes();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.ComplexAttributeMatcher#getLocalSourceElements() <em>Get Local Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Local Source Elements</em>' operation.
	 * @see pamtram.mapping.ComplexAttributeMatcher#getLocalSourceElements()
	 * @generated
	 */
	EOperation getComplexAttributeMatcher__GetLocalSourceElements();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.SimpleAttributeMatcher <em>Simple Attribute Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Attribute Matcher</em>'.
	 * @see pamtram.mapping.SimpleAttributeMatcher
	 * @generated
	 */
	EClass getSimpleAttributeMatcher();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ComplexAttributeMatcherSourceElement <em>Complex Attribute Matcher Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Attribute Matcher Source Element</em>'.
	 * @see pamtram.mapping.ComplexAttributeMatcherSourceElement
	 * @generated
	 */
	EClass getComplexAttributeMatcherSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ModelConnectionHintSourceElement <em>Model Connection Hint Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Connection Hint Source Element</em>'.
	 * @see pamtram.mapping.ModelConnectionHintSourceElement
	 * @generated
	 */
	EClass getModelConnectionHintSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ModelConnectionHintTargetAttribute <em>Model Connection Hint Target Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Connection Hint Target Attribute</em>'.
	 * @see pamtram.mapping.ModelConnectionHintTargetAttribute
	 * @generated
	 */
	EClass getModelConnectionHintTargetAttribute();

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
	 * Returns the meta object for class '{@link pamtram.mapping.MappedAttributeValueExpanderType <em>Mapped Attribute Value Expander Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Attribute Value Expander Type</em>'.
	 * @see pamtram.mapping.MappedAttributeValueExpanderType
	 * @generated
	 */
	EClass getMappedAttributeValueExpanderType();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.MappedAttributeValueExpanderType#getSourceAttribute <em>Source Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Attribute</em>'.
	 * @see pamtram.mapping.MappedAttributeValueExpanderType#getSourceAttribute()
	 * @see #getMappedAttributeValueExpanderType()
	 * @generated
	 */
	EReference getMappedAttributeValueExpanderType_SourceAttribute();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.mapping.MappedAttributeValueExpanderType#getModifiers <em>Modifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Modifiers</em>'.
	 * @see pamtram.mapping.MappedAttributeValueExpanderType#getModifiers()
	 * @see #getMappedAttributeValueExpanderType()
	 * @generated
	 */
	EReference getMappedAttributeValueExpanderType_Modifiers();

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
	 * Returns the meta object for class '{@link pamtram.mapping.ComplexMappingHintSourceInterface <em>Complex Mapping Hint Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Mapping Hint Source Interface</em>'.
	 * @see pamtram.mapping.ComplexMappingHintSourceInterface
	 * @generated
	 */
	EClass getComplexMappingHintSourceInterface();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.ComplexMappingHintSourceInterface#getSourceAttribute() <em>Get Source Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Source Attribute</em>' operation.
	 * @see pamtram.mapping.ComplexMappingHintSourceInterface#getSourceAttribute()
	 * @generated
	 */
	EOperation getComplexMappingHintSourceInterface__GetSourceAttribute();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.ComplexMappingHintSourceInterface#getName() <em>Get Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Name</em>' operation.
	 * @see pamtram.mapping.ComplexMappingHintSourceInterface#getName()
	 * @generated
	 */
	EOperation getComplexMappingHintSourceInterface__GetName();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ComplexAttributeMatcherSourceInterface <em>Complex Attribute Matcher Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Attribute Matcher Source Interface</em>'.
	 * @see pamtram.mapping.ComplexAttributeMatcherSourceInterface
	 * @generated
	 */
	EClass getComplexAttributeMatcherSourceInterface();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ModelConnectionHintSourceInterface <em>Model Connection Hint Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Connection Hint Source Interface</em>'.
	 * @see pamtram.mapping.ModelConnectionHintSourceInterface
	 * @generated
	 */
	EClass getModelConnectionHintSourceInterface();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ComplexAttributeMappingExternalSourceElement <em>Complex Attribute Mapping External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Attribute Mapping External Source Element</em>'.
	 * @see pamtram.mapping.ComplexAttributeMappingExternalSourceElement
	 * @generated
	 */
	EClass getComplexAttributeMappingExternalSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ExternalAttributeMappingSourceElement <em>External Attribute Mapping Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Attribute Mapping Source Element</em>'.
	 * @see pamtram.mapping.ExternalAttributeMappingSourceElement
	 * @generated
	 */
	EClass getExternalAttributeMappingSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ComplexModelConnectionHintExternalSourceElement <em>Complex Model Connection Hint External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Model Connection Hint External Source Element</em>'.
	 * @see pamtram.mapping.ComplexModelConnectionHintExternalSourceElement
	 * @generated
	 */
	EClass getComplexModelConnectionHintExternalSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ComplexAttributeMatcherExternalSourceElement <em>Complex Attribute Matcher External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Attribute Matcher External Source Element</em>'.
	 * @see pamtram.mapping.ComplexAttributeMatcherExternalSourceElement
	 * @generated
	 */
	EClass getComplexAttributeMatcherExternalSourceElement();

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
	 * Returns the meta object for class '{@link pamtram.mapping.MatchToLowerCaseConverter <em>Match To Lower Case Converter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match To Lower Case Converter</em>'.
	 * @see pamtram.mapping.MatchToLowerCaseConverter
	 * @generated
	 */
	EClass getMatchToLowerCaseConverter();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.MatchToLowerCaseConverter#getRegex <em>Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Regex</em>'.
	 * @see pamtram.mapping.MatchToLowerCaseConverter#getRegex()
	 * @see #getMatchToLowerCaseConverter()
	 * @generated
	 */
	EAttribute getMatchToLowerCaseConverter_Regex();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.MatchToUpperCaseConverter <em>Match To Upper Case Converter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match To Upper Case Converter</em>'.
	 * @see pamtram.mapping.MatchToUpperCaseConverter
	 * @generated
	 */
	EClass getMatchToUpperCaseConverter();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.MatchToUpperCaseConverter#getRegex <em>Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Regex</em>'.
	 * @see pamtram.mapping.MatchToUpperCaseConverter#getRegex()
	 * @see #getMatchToUpperCaseConverter()
	 * @generated
	 */
	EAttribute getMatchToUpperCaseConverter_Regex();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.GlobalValue <em>Global Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Value</em>'.
	 * @see pamtram.mapping.GlobalValue
	 * @generated
	 */
	EClass getGlobalValue();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.GlobalValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see pamtram.mapping.GlobalValue#getValue()
	 * @see #getGlobalValue()
	 * @generated
	 */
	EAttribute getGlobalValue_Value();

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
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__CONDITION = eINSTANCE.getMapping_Condition();

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
		 * The meta object literal for the '{@link pamtram.mapping.impl.MappingTypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MappingTypeImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingType()
		 * @generated
		 */
		EClass MAPPING_TYPE = eINSTANCE.getMappingType();

		/**
		 * The meta object literal for the '<em><b>Source MM Section</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_TYPE__SOURCE_MM_SECTION = eINSTANCE.getMappingType_SourceMMSection();

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
		 * The meta object literal for the '<em><b>Source Attribute Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS = eINSTANCE.getAttributeMapping_SourceAttributeMappings();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_MAPPING__EXPRESSION = eINSTANCE.getAttributeMapping_Expression();

		/**
		 * The meta object literal for the '<em><b>Result Modifier</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MAPPING__RESULT_MODIFIER = eINSTANCE.getAttributeMapping_ResultModifier();

		/**
		 * The meta object literal for the '<em><b>Get Local Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_MAPPING___GET_LOCAL_SOURCE_ELEMENTS = eINSTANCE.getAttributeMapping__GetLocalSourceElements();

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
		 * The meta object literal for the '{@link pamtram.mapping.impl.MappingInstanceSelectorImpl <em>Instance Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MappingInstanceSelectorImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingInstanceSelector()
		 * @generated
		 */
		EClass MAPPING_INSTANCE_SELECTOR = eINSTANCE.getMappingInstanceSelector();

		/**
		 * The meta object literal for the '<em><b>Affected Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE = eINSTANCE.getMappingInstanceSelector_AffectedReference();

		/**
		 * The meta object literal for the '<em><b>Matcher</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_INSTANCE_SELECTOR__MATCHER = eINSTANCE.getMappingInstanceSelector_Matcher();

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
		 * The meta object literal for the '<em><b>Target Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MATCHER__TARGET_ATTRIBUTE = eINSTANCE.getAttributeMatcher_TargetAttribute();

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
		 * The meta object literal for the '{@link pamtram.mapping.impl.AttributeValueModifierImpl <em>Attribute Value Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.AttributeValueModifierImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeValueModifier()
		 * @generated
		 */
		EClass ATTRIBUTE_VALUE_MODIFIER = eINSTANCE.getAttributeValueModifier();

		/**
		 * The meta object literal for the '<em><b>Modify Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_VALUE_MODIFIER___MODIFY_VALUE__STRING = eINSTANCE.getAttributeValueModifier__ModifyValue__String();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.SubstringReplacerImpl <em>Substring Replacer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.SubstringReplacerImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getSubstringReplacer()
		 * @generated
		 */
		EClass SUBSTRING_REPLACER = eINSTANCE.getSubstringReplacer();

		/**
		 * The meta object literal for the '<em><b>Regex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBSTRING_REPLACER__REGEX = eINSTANCE.getSubstringReplacer_Regex();

		/**
		 * The meta object literal for the '<em><b>Replacement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBSTRING_REPLACER__REPLACEMENT = eINSTANCE.getSubstringReplacer_Replacement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.StringAppenderImpl <em>String Appender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.StringAppenderImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getStringAppender()
		 * @generated
		 */
		EClass STRING_APPENDER = eINSTANCE.getStringAppender();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_APPENDER__STRING = eINSTANCE.getStringAppender_String();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.UniqueNumberAppenderImpl <em>Unique Number Appender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.UniqueNumberAppenderImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getUniqueNumberAppender()
		 * @generated
		 */
		EClass UNIQUE_NUMBER_APPENDER = eINSTANCE.getUniqueNumberAppender();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.StringPrependerImpl <em>String Prepender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.StringPrependerImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getStringPrepender()
		 * @generated
		 */
		EClass STRING_PREPENDER = eINSTANCE.getStringPrepender();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_PREPENDER__STRING = eINSTANCE.getStringPrepender_String();

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
		 * The meta object literal for the '{@link pamtram.mapping.impl.AttributeValueModifierSetImpl <em>Attribute Value Modifier Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.AttributeValueModifierSetImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeValueModifierSet()
		 * @generated
		 */
		EClass ATTRIBUTE_VALUE_MODIFIER_SET = eINSTANCE.getAttributeValueModifierSet();

		/**
		 * The meta object literal for the '<em><b>Modifier</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_VALUE_MODIFIER_SET__MODIFIER = eINSTANCE.getAttributeValueModifierSet_Modifier();

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
		 * The meta object literal for the '<em><b>Model Connection Matcher</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER = eINSTANCE.getMappingHintGroup_ModelConnectionMatcher();

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
		 * The meta object literal for the '<em><b>Target MM Section</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION = eINSTANCE.getMappingHintGroupType_TargetMMSection();

		/**
		 * The meta object literal for the '<em><b>Mapping Hints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS = eINSTANCE.getMappingHintGroupType_MappingHints();

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
		 * The meta object literal for the '{@link pamtram.mapping.impl.ModelConnectionHintImpl <em>Model Connection Hint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ModelConnectionHintImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getModelConnectionHint()
		 * @generated
		 */
		EClass MODEL_CONNECTION_HINT = eINSTANCE.getModelConnectionHint();

		/**
		 * The meta object literal for the '<em><b>Target Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES = eINSTANCE.getModelConnectionHint_TargetAttributes();

		/**
		 * The meta object literal for the '<em><b>Source Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CONNECTION_HINT__SOURCE_ELEMENTS = eINSTANCE.getModelConnectionHint_SourceElements();

		/**
		 * The meta object literal for the '<em><b>Get Source Attributes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_CONNECTION_HINT___GET_SOURCE_ATTRIBUTES = eINSTANCE.getModelConnectionHint__GetSourceAttributes();

		/**
		 * The meta object literal for the '<em><b>Get Local Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_CONNECTION_HINT___GET_LOCAL_SOURCE_ELEMENTS = eINSTANCE.getModelConnectionHint__GetLocalSourceElements();

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
		 * The meta object literal for the '{@link pamtram.mapping.impl.ComplexAttributeMatcherImpl <em>Complex Attribute Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ComplexAttributeMatcherImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexAttributeMatcher()
		 * @generated
		 */
		EClass COMPLEX_ATTRIBUTE_MATCHER = eINSTANCE.getComplexAttributeMatcher();

		/**
		 * The meta object literal for the '<em><b>Source Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES = eINSTANCE.getComplexAttributeMatcher_SourceAttributes();

		/**
		 * The meta object literal for the '<em><b>Get Local Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLEX_ATTRIBUTE_MATCHER___GET_LOCAL_SOURCE_ELEMENTS = eINSTANCE.getComplexAttributeMatcher__GetLocalSourceElements();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.SimpleAttributeMatcherImpl <em>Simple Attribute Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.SimpleAttributeMatcherImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getSimpleAttributeMatcher()
		 * @generated
		 */
		EClass SIMPLE_ATTRIBUTE_MATCHER = eINSTANCE.getSimpleAttributeMatcher();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ComplexAttributeMatcherSourceElementImpl <em>Complex Attribute Matcher Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ComplexAttributeMatcherSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexAttributeMatcherSourceElement()
		 * @generated
		 */
		EClass COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT = eINSTANCE.getComplexAttributeMatcherSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ModelConnectionHintSourceElementImpl <em>Model Connection Hint Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ModelConnectionHintSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getModelConnectionHintSourceElement()
		 * @generated
		 */
		EClass MODEL_CONNECTION_HINT_SOURCE_ELEMENT = eINSTANCE.getModelConnectionHintSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ModelConnectionHintTargetAttributeImpl <em>Model Connection Hint Target Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ModelConnectionHintTargetAttributeImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getModelConnectionHintTargetAttribute()
		 * @generated
		 */
		EClass MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE = eINSTANCE.getModelConnectionHintTargetAttribute();

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
		 * The meta object literal for the '{@link pamtram.mapping.impl.MappedAttributeValueExpanderTypeImpl <em>Mapped Attribute Value Expander Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MappedAttributeValueExpanderTypeImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMappedAttributeValueExpanderType()
		 * @generated
		 */
		EClass MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE = eINSTANCE.getMappedAttributeValueExpanderType();

		/**
		 * The meta object literal for the '<em><b>Source Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__SOURCE_ATTRIBUTE = eINSTANCE.getMappedAttributeValueExpanderType_SourceAttribute();

		/**
		 * The meta object literal for the '<em><b>Modifiers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__MODIFIERS = eINSTANCE.getMappedAttributeValueExpanderType_Modifiers();

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
		 * The meta object literal for the '{@link pamtram.mapping.ComplexMappingHintSourceInterface <em>Complex Mapping Hint Source Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.ComplexMappingHintSourceInterface
		 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexMappingHintSourceInterface()
		 * @generated
		 */
		EClass COMPLEX_MAPPING_HINT_SOURCE_INTERFACE = eINSTANCE.getComplexMappingHintSourceInterface();

		/**
		 * The meta object literal for the '<em><b>Get Source Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE = eINSTANCE.getComplexMappingHintSourceInterface__GetSourceAttribute();

		/**
		 * The meta object literal for the '<em><b>Get Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_NAME = eINSTANCE.getComplexMappingHintSourceInterface__GetName();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.ComplexAttributeMatcherSourceInterface <em>Complex Attribute Matcher Source Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.ComplexAttributeMatcherSourceInterface
		 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexAttributeMatcherSourceInterface()
		 * @generated
		 */
		EClass COMPLEX_ATTRIBUTE_MATCHER_SOURCE_INTERFACE = eINSTANCE.getComplexAttributeMatcherSourceInterface();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.ModelConnectionHintSourceInterface <em>Model Connection Hint Source Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.ModelConnectionHintSourceInterface
		 * @see pamtram.mapping.impl.MappingPackageImpl#getModelConnectionHintSourceInterface()
		 * @generated
		 */
		EClass MODEL_CONNECTION_HINT_SOURCE_INTERFACE = eINSTANCE.getModelConnectionHintSourceInterface();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ComplexAttributeMappingExternalSourceElementImpl <em>Complex Attribute Mapping External Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ComplexAttributeMappingExternalSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexAttributeMappingExternalSourceElement()
		 * @generated
		 */
		EClass COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT = eINSTANCE.getComplexAttributeMappingExternalSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ExternalAttributeMappingSourceElementImpl <em>External Attribute Mapping Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ExternalAttributeMappingSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getExternalAttributeMappingSourceElement()
		 * @generated
		 */
		EClass EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT = eINSTANCE.getExternalAttributeMappingSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ComplexModelConnectionHintExternalSourceElementImpl <em>Complex Model Connection Hint External Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ComplexModelConnectionHintExternalSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexModelConnectionHintExternalSourceElement()
		 * @generated
		 */
		EClass COMPLEX_MODEL_CONNECTION_HINT_EXTERNAL_SOURCE_ELEMENT = eINSTANCE.getComplexModelConnectionHintExternalSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ComplexAttributeMatcherExternalSourceElementImpl <em>Complex Attribute Matcher External Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ComplexAttributeMatcherExternalSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexAttributeMatcherExternalSourceElement()
		 * @generated
		 */
		EClass COMPLEX_ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT = eINSTANCE.getComplexAttributeMatcherExternalSourceElement();

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
		 * The meta object literal for the '{@link pamtram.mapping.impl.MatchToLowerCaseConverterImpl <em>Match To Lower Case Converter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MatchToLowerCaseConverterImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMatchToLowerCaseConverter()
		 * @generated
		 */
		EClass MATCH_TO_LOWER_CASE_CONVERTER = eINSTANCE.getMatchToLowerCaseConverter();

		/**
		 * The meta object literal for the '<em><b>Regex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_TO_LOWER_CASE_CONVERTER__REGEX = eINSTANCE.getMatchToLowerCaseConverter_Regex();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.MatchToUpperCaseConverterImpl <em>Match To Upper Case Converter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.MatchToUpperCaseConverterImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getMatchToUpperCaseConverter()
		 * @generated
		 */
		EClass MATCH_TO_UPPER_CASE_CONVERTER = eINSTANCE.getMatchToUpperCaseConverter();

		/**
		 * The meta object literal for the '<em><b>Regex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_TO_UPPER_CASE_CONVERTER__REGEX = eINSTANCE.getMatchToUpperCaseConverter_Regex();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.GlobalValueImpl <em>Global Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.GlobalValueImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getGlobalValue()
		 * @generated
		 */
		EClass GLOBAL_VALUE = eINSTANCE.getGlobalValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GLOBAL_VALUE__VALUE = eINSTANCE.getGlobalValue_Value();

	}

} //MappingPackage
