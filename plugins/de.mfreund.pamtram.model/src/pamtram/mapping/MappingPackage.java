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
	int MAPPING_TYPE = 1;

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
	int MAPPING = 0;

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
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = MAPPING_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_COUNT = MAPPING_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingHintImpl <em>Hint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingHintImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHint()
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
	int MAPPING_HINT__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeMappingImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMapping()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING = 3;

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
	 * The number of structural features of the '<em>Attribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_FEATURE_COUNT = MAPPING_HINT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_OPERATION_COUNT = MAPPING_HINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.CardinalityMappingImpl <em>Cardinality Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.CardinalityMappingImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getCardinalityMapping()
	 * @generated
	 */
	int CARDINALITY_MAPPING = 4;

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
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingInstanceSelectorImpl <em>Instance Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingInstanceSelectorImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingInstanceSelector()
	 * @generated
	 */
	int MAPPING_INSTANCE_SELECTOR = 5;

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
	 * The meta object id for the '{@link pamtram.mapping.impl.MatcherImpl <em>Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MatcherImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMatcher()
	 * @generated
	 */
	int MATCHER = 6;

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
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeMatcherImpl <em>Attribute Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeMatcherImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMatcher()
	 * @generated
	 */
	int ATTRIBUTE_MATCHER = 7;

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
	 * The meta object id for the '{@link pamtram.mapping.impl.ClassMatcherImpl <em>Class Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ClassMatcherImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getClassMatcher()
	 * @generated
	 */
	int CLASS_MATCHER = 8;

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
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeValueModifierImpl <em>Attribute Value Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeValueModifierImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeValueModifier()
	 * @generated
	 */
	int ATTRIBUTE_VALUE_MODIFIER = 9;

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
	 * The number of operations of the '<em>Attribute Value Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_MODIFIER_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.SubstringReplacerImpl <em>Substring Replacer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.SubstringReplacerImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getSubstringReplacer()
	 * @generated
	 */
	int SUBSTRING_REPLACER = 10;

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
	 * The number of operations of the '<em>Substring Replacer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_REPLACER_OPERATION_COUNT = ATTRIBUTE_VALUE_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.StringAppenderImpl <em>String Appender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.StringAppenderImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getStringAppender()
	 * @generated
	 */
	int STRING_APPENDER = 11;

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
	 * The number of operations of the '<em>String Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_APPENDER_OPERATION_COUNT = ATTRIBUTE_VALUE_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.UniqueNumberAppenderImpl <em>Unique Number Appender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.UniqueNumberAppenderImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getUniqueNumberAppender()
	 * @generated
	 */
	int UNIQUE_NUMBER_APPENDER = 12;

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
	 * The number of operations of the '<em>Unique Number Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_NUMBER_APPENDER_OPERATION_COUNT = ATTRIBUTE_VALUE_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.StringPrependerImpl <em>String Prepender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.StringPrependerImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getStringPrepender()
	 * @generated
	 */
	int STRING_PREPENDER = 13;

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
	 * The number of operations of the '<em>String Prepender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PREPENDER_OPERATION_COUNT = ATTRIBUTE_VALUE_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeValueModifierSetImpl <em>Attribute Value Modifier Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeValueModifierSetImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeValueModifierSet()
	 * @generated
	 */
	int ATTRIBUTE_VALUE_MODIFIER_SET = 14;

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
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingHintGroupTypeImpl <em>Hint Group Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingHintGroupTypeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintGroupType()
	 * @generated
	 */
	int MAPPING_HINT_GROUP_TYPE = 16;

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
	int MAPPING_HINT_GROUP = 15;

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
	 * The meta object id for the '{@link pamtram.mapping.impl.InstantiableMappingHintGroupImpl <em>Instantiable Mapping Hint Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.InstantiableMappingHintGroupImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getInstantiableMappingHintGroup()
	 * @generated
	 */
	int INSTANTIABLE_MAPPING_HINT_GROUP = 17;

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
	 * The meta object id for the '{@link pamtram.mapping.impl.MappingHintGroupImporterImpl <em>Hint Group Importer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.MappingHintGroupImporterImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getMappingHintGroupImporter()
	 * @generated
	 */
	int MAPPING_HINT_GROUP_IMPORTER = 18;

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
	 * The number of structural features of the '<em>Hint Group Importer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_HINT_GROUP_IMPORTER_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

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
	int EXPORTED_MAPPING_HINT_GROUP = 19;

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
	int MODEL_CONNECTION_HINT = 20;

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
	 * The number of structural features of the '<em>Model Connection Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Source Attributes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT___GET_SOURCE_ATTRIBUTES = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Model Connection Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONNECTION_HINT_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;


	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ConnectionHintTargetAttributeImpl <em>Connection Hint Target Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ConnectionHintTargetAttributeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getConnectionHintTargetAttribute()
	 * @generated
	 */
	int CONNECTION_HINT_TARGET_ATTRIBUTE = 21;

	/**
	 * The feature id for the '<em><b>Target Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_HINT_TARGET_ATTRIBUTE__TARGET_ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_HINT_TARGET_ATTRIBUTE__MODIFIER = 1;

	/**
	 * The number of structural features of the '<em>Connection Hint Target Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_HINT_TARGET_ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Connection Hint Target Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_HINT_TARGET_ATTRIBUTE_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.SimpleAttributeMappingImpl <em>Simple Attribute Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.SimpleAttributeMappingImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getSimpleAttributeMapping()
	 * @generated
	 */
	int SIMPLE_ATTRIBUTE_MAPPING = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ATTRIBUTE_MAPPING__NAME = ATTRIBUTE_MAPPING__NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ATTRIBUTE_MAPPING__TARGET = ATTRIBUTE_MAPPING__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ATTRIBUTE_MAPPING__SOURCE = ATTRIBUTE_MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ATTRIBUTE_MAPPING__MODIFIER = ATTRIBUTE_MAPPING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Attribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ATTRIBUTE_MAPPING_FEATURE_COUNT = ATTRIBUTE_MAPPING_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Simple Attribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ATTRIBUTE_MAPPING_OPERATION_COUNT = ATTRIBUTE_MAPPING_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ComplexAttributeMappingImpl <em>Complex Attribute Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ComplexAttributeMappingImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexAttributeMapping()
	 * @generated
	 */
	int COMPLEX_ATTRIBUTE_MAPPING = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MAPPING__NAME = ATTRIBUTE_MAPPING__NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MAPPING__TARGET = ATTRIBUTE_MAPPING__TARGET;

	/**
	 * The feature id for the '<em><b>Source Attribute Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS = ATTRIBUTE_MAPPING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Complex Attribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MAPPING_FEATURE_COUNT = ATTRIBUTE_MAPPING_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Complex Attribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MAPPING_OPERATION_COUNT = ATTRIBUTE_MAPPING_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeMappingSourceElementTypeImpl <em>Attribute Mapping Source Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeMappingSourceElementTypeImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMappingSourceElementType()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Mapping Source Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Mapping Source Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.AttributeMappingSourceElementWithModifiersImpl <em>Attribute Mapping Source Element With Modifiers</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.AttributeMappingSourceElementWithModifiersImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMappingSourceElementWithModifiers()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS = 34;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__NAME = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__SOURCE = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__MODIFIER = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Mapping Source Element With Modifiers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS_FEATURE_COUNT = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Mapping Source Element With Modifiers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS_OPERATION_COUNT = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ComplexAttribueMappingSourceElementImpl <em>Complex Attribue Mapping Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ComplexAttribueMappingSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexAttribueMappingSourceElement()
	 * @generated
	 */
	int COMPLEX_ATTRIBUE_MAPPING_SOURCE_ELEMENT = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUE_MAPPING_SOURCE_ELEMENT__NAME = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUE_MAPPING_SOURCE_ELEMENT__SOURCE = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUE_MAPPING_SOURCE_ELEMENT__MODIFIER = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__MODIFIER;

	/**
	 * The number of structural features of the '<em>Complex Attribue Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUE_MAPPING_SOURCE_ELEMENT_FEATURE_COUNT = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Complex Attribue Mapping Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUE_MAPPING_SOURCE_ELEMENT_OPERATION_COUNT = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.CalculatorMappingImpl <em>Calculator Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.CalculatorMappingImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getCalculatorMapping()
	 * @generated
	 */
	int CALCULATOR_MAPPING = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATOR_MAPPING__NAME = ATTRIBUTE_MAPPING__NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATOR_MAPPING__TARGET = ATTRIBUTE_MAPPING__TARGET;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATOR_MAPPING__EXPRESSION = ATTRIBUTE_MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATOR_MAPPING__VARIABLES = ATTRIBUTE_MAPPING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Calculator Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATOR_MAPPING_FEATURE_COUNT = ATTRIBUTE_MAPPING_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Calculator Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATOR_MAPPING_OPERATION_COUNT = ATTRIBUTE_MAPPING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ExpressionVariableImpl <em>Expression Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ExpressionVariableImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getExpressionVariable()
	 * @generated
	 */
	int EXPRESSION_VARIABLE = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_VARIABLE__NAME = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_VARIABLE__SOURCE = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_VARIABLE__MODIFIER = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__MODIFIER;

	/**
	 * The number of structural features of the '<em>Expression Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_VARIABLE_FEATURE_COUNT = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Expression Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_VARIABLE_OPERATION_COUNT = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ComplexAttributeMatcherImpl <em>Complex Attribute Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ComplexAttributeMatcherImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexAttributeMatcher()
	 * @generated
	 */
	int COMPLEX_ATTRIBUTE_MATCHER = 28;

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
	 * The number of operations of the '<em>Complex Attribute Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_OPERATION_COUNT = ATTRIBUTE_MATCHER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.SimpleAttributeMatcherImpl <em>Simple Attribute Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.SimpleAttributeMatcherImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getSimpleAttributeMatcher()
	 * @generated
	 */
	int SIMPLE_ATTRIBUTE_MATCHER = 29;

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
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT__NAME = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT__SOURCE = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT__MODIFIER = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__MODIFIER;

	/**
	 * The number of structural features of the '<em>Complex Attribute Matcher Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT_FEATURE_COUNT = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Complex Attribute Matcher Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT_OPERATION_COUNT = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.SimpleModelConnectionHintImpl <em>Simple Model Connection Hint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.SimpleModelConnectionHintImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getSimpleModelConnectionHint()
	 * @generated
	 */
	int SIMPLE_MODEL_CONNECTION_HINT = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MODEL_CONNECTION_HINT__NAME = MODEL_CONNECTION_HINT__NAME;

	/**
	 * The feature id for the '<em><b>Target Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES = MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MODEL_CONNECTION_HINT__SOURCE = MODEL_CONNECTION_HINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MODEL_CONNECTION_HINT__MODIFIER = MODEL_CONNECTION_HINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Model Connection Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MODEL_CONNECTION_HINT_FEATURE_COUNT = MODEL_CONNECTION_HINT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Source Attributes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MODEL_CONNECTION_HINT___GET_SOURCE_ATTRIBUTES = MODEL_CONNECTION_HINT___GET_SOURCE_ATTRIBUTES;

	/**
	 * The number of operations of the '<em>Simple Model Connection Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MODEL_CONNECTION_HINT_OPERATION_COUNT = MODEL_CONNECTION_HINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ComplexModelConnectionHintImpl <em>Complex Model Connection Hint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ComplexModelConnectionHintImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexModelConnectionHint()
	 * @generated
	 */
	int COMPLEX_MODEL_CONNECTION_HINT = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT__NAME = MODEL_CONNECTION_HINT__NAME;

	/**
	 * The feature id for the '<em><b>Target Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES = MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT__SOURCE_ELEMENTS = MODEL_CONNECTION_HINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Complex Model Connection Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_FEATURE_COUNT = MODEL_CONNECTION_HINT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Source Attributes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT___GET_SOURCE_ATTRIBUTES = MODEL_CONNECTION_HINT___GET_SOURCE_ATTRIBUTES;

	/**
	 * The number of operations of the '<em>Complex Model Connection Hint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_OPERATION_COUNT = MODEL_CONNECTION_HINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.impl.ComplexModelConnectionHintSourceElementImpl <em>Complex Model Connection Hint Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.impl.ComplexModelConnectionHintSourceElementImpl
	 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexModelConnectionHintSourceElement()
	 * @generated
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_SOURCE_ELEMENT = 33;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_SOURCE_ELEMENT__NAME = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_SOURCE_ELEMENT__SOURCE = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_SOURCE_ELEMENT__MODIFIER = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__MODIFIER;

	/**
	 * The number of structural features of the '<em>Complex Model Connection Hint Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_SOURCE_ELEMENT_FEATURE_COUNT = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Complex Model Connection Hint Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MODEL_CONNECTION_HINT_SOURCE_ELEMENT_OPERATION_COUNT = ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS_OPERATION_COUNT + 0;


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
	 * Returns the meta object for the '{@link pamtram.mapping.ModelConnectionHint#getSourceAttributes() <em>Get Source Attributes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Source Attributes</em>' operation.
	 * @see pamtram.mapping.ModelConnectionHint#getSourceAttributes()
	 * @generated
	 */
	EOperation getModelConnectionHint__GetSourceAttributes();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ConnectionHintTargetAttribute <em>Connection Hint Target Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Hint Target Attribute</em>'.
	 * @see pamtram.mapping.ConnectionHintTargetAttribute
	 * @generated
	 */
	EClass getConnectionHintTargetAttribute();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.ConnectionHintTargetAttribute#getTargetAttribute <em>Target Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Attribute</em>'.
	 * @see pamtram.mapping.ConnectionHintTargetAttribute#getTargetAttribute()
	 * @see #getConnectionHintTargetAttribute()
	 * @generated
	 */
	EReference getConnectionHintTargetAttribute_TargetAttribute();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.mapping.ConnectionHintTargetAttribute#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Modifier</em>'.
	 * @see pamtram.mapping.ConnectionHintTargetAttribute#getModifier()
	 * @see #getConnectionHintTargetAttribute()
	 * @generated
	 */
	EReference getConnectionHintTargetAttribute_Modifier();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.SimpleAttributeMapping <em>Simple Attribute Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Attribute Mapping</em>'.
	 * @see pamtram.mapping.SimpleAttributeMapping
	 * @generated
	 */
	EClass getSimpleAttributeMapping();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ComplexAttributeMapping <em>Complex Attribute Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Attribute Mapping</em>'.
	 * @see pamtram.mapping.ComplexAttributeMapping
	 * @generated
	 */
	EClass getComplexAttributeMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.ComplexAttributeMapping#getSourceAttributeMappings <em>Source Attribute Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Attribute Mappings</em>'.
	 * @see pamtram.mapping.ComplexAttributeMapping#getSourceAttributeMappings()
	 * @see #getComplexAttributeMapping()
	 * @generated
	 */
	EReference getComplexAttributeMapping_SourceAttributeMappings();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ComplexAttribueMappingSourceElement <em>Complex Attribue Mapping Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Attribue Mapping Source Element</em>'.
	 * @see pamtram.mapping.ComplexAttribueMappingSourceElement
	 * @generated
	 */
	EClass getComplexAttribueMappingSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.CalculatorMapping <em>Calculator Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Calculator Mapping</em>'.
	 * @see pamtram.mapping.CalculatorMapping
	 * @generated
	 */
	EClass getCalculatorMapping();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.CalculatorMapping#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see pamtram.mapping.CalculatorMapping#getExpression()
	 * @see #getCalculatorMapping()
	 * @generated
	 */
	EAttribute getCalculatorMapping_Expression();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.CalculatorMapping#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see pamtram.mapping.CalculatorMapping#getVariables()
	 * @see #getCalculatorMapping()
	 * @generated
	 */
	EReference getCalculatorMapping_Variables();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ExpressionVariable <em>Expression Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Variable</em>'.
	 * @see pamtram.mapping.ExpressionVariable
	 * @generated
	 */
	EClass getExpressionVariable();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.AttributeMappingSourceElementType <em>Attribute Mapping Source Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Mapping Source Element Type</em>'.
	 * @see pamtram.mapping.AttributeMappingSourceElementType
	 * @generated
	 */
	EClass getAttributeMappingSourceElementType();

	/**
	 * Returns the meta object for the reference '{@link pamtram.mapping.AttributeMappingSourceElementType#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see pamtram.mapping.AttributeMappingSourceElementType#getSource()
	 * @see #getAttributeMappingSourceElementType()
	 * @generated
	 */
	EReference getAttributeMappingSourceElementType_Source();

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
	 * Returns the meta object for class '{@link pamtram.mapping.SimpleModelConnectionHint <em>Simple Model Connection Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Model Connection Hint</em>'.
	 * @see pamtram.mapping.SimpleModelConnectionHint
	 * @generated
	 */
	EClass getSimpleModelConnectionHint();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ComplexModelConnectionHint <em>Complex Model Connection Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Model Connection Hint</em>'.
	 * @see pamtram.mapping.ComplexModelConnectionHint
	 * @generated
	 */
	EClass getComplexModelConnectionHint();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.ComplexModelConnectionHint#getSourceElements <em>Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Elements</em>'.
	 * @see pamtram.mapping.ComplexModelConnectionHint#getSourceElements()
	 * @see #getComplexModelConnectionHint()
	 * @generated
	 */
	EReference getComplexModelConnectionHint_SourceElements();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.ComplexModelConnectionHintSourceElement <em>Complex Model Connection Hint Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Model Connection Hint Source Element</em>'.
	 * @see pamtram.mapping.ComplexModelConnectionHintSourceElement
	 * @generated
	 */
	EClass getComplexModelConnectionHintSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.AttributeMappingSourceElementWithModifiers <em>Attribute Mapping Source Element With Modifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Mapping Source Element With Modifiers</em>'.
	 * @see pamtram.mapping.AttributeMappingSourceElementWithModifiers
	 * @generated
	 */
	EClass getAttributeMappingSourceElementWithModifiers();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.mapping.AttributeMappingSourceElementWithModifiers#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Modifier</em>'.
	 * @see pamtram.mapping.AttributeMappingSourceElementWithModifiers#getModifier()
	 * @see #getAttributeMappingSourceElementWithModifiers()
	 * @generated
	 */
	EReference getAttributeMappingSourceElementWithModifiers_Modifier();

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
		 * The meta object literal for the '<em><b>Get Source Attributes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_CONNECTION_HINT___GET_SOURCE_ATTRIBUTES = eINSTANCE.getModelConnectionHint__GetSourceAttributes();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ConnectionHintTargetAttributeImpl <em>Connection Hint Target Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ConnectionHintTargetAttributeImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getConnectionHintTargetAttribute()
		 * @generated
		 */
		EClass CONNECTION_HINT_TARGET_ATTRIBUTE = eINSTANCE.getConnectionHintTargetAttribute();

		/**
		 * The meta object literal for the '<em><b>Target Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_HINT_TARGET_ATTRIBUTE__TARGET_ATTRIBUTE = eINSTANCE.getConnectionHintTargetAttribute_TargetAttribute();

		/**
		 * The meta object literal for the '<em><b>Modifier</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_HINT_TARGET_ATTRIBUTE__MODIFIER = eINSTANCE.getConnectionHintTargetAttribute_Modifier();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.SimpleAttributeMappingImpl <em>Simple Attribute Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.SimpleAttributeMappingImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getSimpleAttributeMapping()
		 * @generated
		 */
		EClass SIMPLE_ATTRIBUTE_MAPPING = eINSTANCE.getSimpleAttributeMapping();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ComplexAttributeMappingImpl <em>Complex Attribute Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ComplexAttributeMappingImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexAttributeMapping()
		 * @generated
		 */
		EClass COMPLEX_ATTRIBUTE_MAPPING = eINSTANCE.getComplexAttributeMapping();

		/**
		 * The meta object literal for the '<em><b>Source Attribute Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS = eINSTANCE.getComplexAttributeMapping_SourceAttributeMappings();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ComplexAttribueMappingSourceElementImpl <em>Complex Attribue Mapping Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ComplexAttribueMappingSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexAttribueMappingSourceElement()
		 * @generated
		 */
		EClass COMPLEX_ATTRIBUE_MAPPING_SOURCE_ELEMENT = eINSTANCE.getComplexAttribueMappingSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.CalculatorMappingImpl <em>Calculator Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.CalculatorMappingImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getCalculatorMapping()
		 * @generated
		 */
		EClass CALCULATOR_MAPPING = eINSTANCE.getCalculatorMapping();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALCULATOR_MAPPING__EXPRESSION = eINSTANCE.getCalculatorMapping_Expression();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALCULATOR_MAPPING__VARIABLES = eINSTANCE.getCalculatorMapping_Variables();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ExpressionVariableImpl <em>Expression Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ExpressionVariableImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getExpressionVariable()
		 * @generated
		 */
		EClass EXPRESSION_VARIABLE = eINSTANCE.getExpressionVariable();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.AttributeMappingSourceElementTypeImpl <em>Attribute Mapping Source Element Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.AttributeMappingSourceElementTypeImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMappingSourceElementType()
		 * @generated
		 */
		EClass ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE = eINSTANCE.getAttributeMappingSourceElementType();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE = eINSTANCE.getAttributeMappingSourceElementType_Source();

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
		 * The meta object literal for the '{@link pamtram.mapping.impl.SimpleModelConnectionHintImpl <em>Simple Model Connection Hint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.SimpleModelConnectionHintImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getSimpleModelConnectionHint()
		 * @generated
		 */
		EClass SIMPLE_MODEL_CONNECTION_HINT = eINSTANCE.getSimpleModelConnectionHint();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ComplexModelConnectionHintImpl <em>Complex Model Connection Hint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ComplexModelConnectionHintImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexModelConnectionHint()
		 * @generated
		 */
		EClass COMPLEX_MODEL_CONNECTION_HINT = eINSTANCE.getComplexModelConnectionHint();

		/**
		 * The meta object literal for the '<em><b>Source Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_MODEL_CONNECTION_HINT__SOURCE_ELEMENTS = eINSTANCE.getComplexModelConnectionHint_SourceElements();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.ComplexModelConnectionHintSourceElementImpl <em>Complex Model Connection Hint Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.ComplexModelConnectionHintSourceElementImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getComplexModelConnectionHintSourceElement()
		 * @generated
		 */
		EClass COMPLEX_MODEL_CONNECTION_HINT_SOURCE_ELEMENT = eINSTANCE.getComplexModelConnectionHintSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.impl.AttributeMappingSourceElementWithModifiersImpl <em>Attribute Mapping Source Element With Modifiers</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.impl.AttributeMappingSourceElementWithModifiersImpl
		 * @see pamtram.mapping.impl.MappingPackageImpl#getAttributeMappingSourceElementWithModifiers()
		 * @generated
		 */
		EClass ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS = eINSTANCE.getAttributeMappingSourceElementWithModifiers();

		/**
		 * The meta object literal for the '<em><b>Modifier</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__MODIFIER = eINSTANCE.getAttributeMappingSourceElementWithModifiers_Modifier();

	}

} //MappingPackage
