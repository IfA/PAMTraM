/**
 */
package pamtram.mapping.modifier;

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
 * @see pamtram.mapping.modifier.ModifierFactory
 * @model kind="package"
 * @generated
 */
public interface ModifierPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modifier";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mfreund.de/pamtram/mapping/modifier";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "modifier";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModifierPackage eINSTANCE = pamtram.mapping.modifier.impl.ModifierPackageImpl.init();

	/**
	 * The meta object id for the '{@link pamtram.mapping.modifier.impl.ValueModifierSetImpl <em>Value Modifier Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.modifier.impl.ValueModifierSetImpl
	 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getValueModifierSet()
	 * @generated
	 */
	int VALUE_MODIFIER_SET = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_MODIFIER_SET__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_MODIFIER_SET__MODIFIER = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value Modifier Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_MODIFIER_SET_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Value Modifier Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_MODIFIER_SET_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.modifier.ValueModifier <em>Value Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.modifier.ValueModifier
	 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getValueModifier()
	 * @generated
	 */
	int VALUE_MODIFIER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_MODIFIER__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Value Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_MODIFIER_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_MODIFIER___MODIFY_VALUE__STRING = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Value Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_MODIFIER_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.mapping.modifier.impl.SubstringReplacerImpl <em>Substring Replacer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.modifier.impl.SubstringReplacerImpl
	 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getSubstringReplacer()
	 * @generated
	 */
	int SUBSTRING_REPLACER = 6;

	/**
	 * The meta object id for the '{@link pamtram.mapping.modifier.impl.StringAppenderImpl <em>String Appender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.modifier.impl.StringAppenderImpl
	 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getStringAppender()
	 * @generated
	 */
	int STRING_APPENDER = 7;

	/**
	 * The meta object id for the '{@link pamtram.mapping.modifier.impl.UniqueNumberAppenderImpl <em>Unique Number Appender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.modifier.impl.UniqueNumberAppenderImpl
	 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getUniqueNumberAppender()
	 * @generated
	 */
	int UNIQUE_NUMBER_APPENDER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_NUMBER_APPENDER__NAME = VALUE_MODIFIER__NAME;

	/**
	 * The number of structural features of the '<em>Unique Number Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_NUMBER_APPENDER_FEATURE_COUNT = VALUE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_NUMBER_APPENDER___MODIFY_VALUE__STRING = VALUE_MODIFIER___MODIFY_VALUE__STRING;

	/**
	 * The number of operations of the '<em>Unique Number Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_NUMBER_APPENDER_OPERATION_COUNT = VALUE_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.modifier.impl.NumericModifierImpl <em>Numeric Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.modifier.impl.NumericModifierImpl
	 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getNumericModifier()
	 * @generated
	 */
	int NUMERIC_MODIFIER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_MODIFIER__NAME = VALUE_MODIFIER__NAME;

	/**
	 * The number of structural features of the '<em>Numeric Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_MODIFIER_FEATURE_COUNT = VALUE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_MODIFIER___MODIFY_VALUE__STRING = VALUE_MODIFIER___MODIFY_VALUE__STRING;

	/**
	 * The number of operations of the '<em>Numeric Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_MODIFIER_OPERATION_COUNT = VALUE_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.modifier.impl.ExpressionModifierImpl <em>Expression Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.modifier.impl.ExpressionModifierImpl
	 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getExpressionModifier()
	 * @generated
	 */
	int EXPRESSION_MODIFIER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_MODIFIER__NAME = NUMERIC_MODIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_MODIFIER__EXPRESSION = NUMERIC_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_MODIFIER_FEATURE_COUNT = NUMERIC_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_MODIFIER___MODIFY_VALUE__STRING = NUMERIC_MODIFIER___MODIFY_VALUE__STRING;

	/**
	 * The number of operations of the '<em>Expression Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_MODIFIER_OPERATION_COUNT = NUMERIC_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.modifier.impl.StringModifierImpl <em>String Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.modifier.impl.StringModifierImpl
	 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getStringModifier()
	 * @generated
	 */
	int STRING_MODIFIER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MODIFIER__NAME = VALUE_MODIFIER__NAME;

	/**
	 * The number of structural features of the '<em>String Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MODIFIER_FEATURE_COUNT = VALUE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MODIFIER___MODIFY_VALUE__STRING = VALUE_MODIFIER___MODIFY_VALUE__STRING;

	/**
	 * The number of operations of the '<em>String Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MODIFIER_OPERATION_COUNT = VALUE_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_REPLACER__NAME = STRING_MODIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_REPLACER__REGEX = STRING_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replacement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_REPLACER__REPLACEMENT = STRING_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Substring Replacer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_REPLACER_FEATURE_COUNT = STRING_MODIFIER_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_REPLACER___MODIFY_VALUE__STRING = STRING_MODIFIER___MODIFY_VALUE__STRING;

	/**
	 * The number of operations of the '<em>Substring Replacer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_REPLACER_OPERATION_COUNT = STRING_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_APPENDER__NAME = STRING_MODIFIER__NAME;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_APPENDER__STRING = STRING_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_APPENDER_FEATURE_COUNT = STRING_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_APPENDER___MODIFY_VALUE__STRING = STRING_MODIFIER___MODIFY_VALUE__STRING;

	/**
	 * The number of operations of the '<em>String Appender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_APPENDER_OPERATION_COUNT = STRING_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.modifier.impl.StringPrependerImpl <em>String Prepender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.modifier.impl.StringPrependerImpl
	 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getStringPrepender()
	 * @generated
	 */
	int STRING_PREPENDER = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PREPENDER__NAME = STRING_MODIFIER__NAME;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PREPENDER__STRING = STRING_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Prepender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PREPENDER_FEATURE_COUNT = STRING_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PREPENDER___MODIFY_VALUE__STRING = STRING_MODIFIER___MODIFY_VALUE__STRING;

	/**
	 * The number of operations of the '<em>String Prepender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PREPENDER_OPERATION_COUNT = STRING_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.modifier.impl.ToLowerCaseConverterImpl <em>To Lower Case Converter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.modifier.impl.ToLowerCaseConverterImpl
	 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getToLowerCaseConverter()
	 * @generated
	 */
	int TO_LOWER_CASE_CONVERTER = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_LOWER_CASE_CONVERTER__NAME = STRING_MODIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_LOWER_CASE_CONVERTER__REGEX = STRING_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>To Lower Case Converter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_LOWER_CASE_CONVERTER_FEATURE_COUNT = STRING_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_LOWER_CASE_CONVERTER___MODIFY_VALUE__STRING = STRING_MODIFIER___MODIFY_VALUE__STRING;

	/**
	 * The number of operations of the '<em>To Lower Case Converter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_LOWER_CASE_CONVERTER_OPERATION_COUNT = STRING_MODIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.mapping.modifier.impl.ToUpperCaseConverterImpl <em>To Upper Case Converter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.mapping.modifier.impl.ToUpperCaseConverterImpl
	 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getToUpperCaseConverter()
	 * @generated
	 */
	int TO_UPPER_CASE_CONVERTER = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_UPPER_CASE_CONVERTER__NAME = STRING_MODIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_UPPER_CASE_CONVERTER__REGEX = STRING_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>To Upper Case Converter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_UPPER_CASE_CONVERTER_FEATURE_COUNT = STRING_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Modify Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_UPPER_CASE_CONVERTER___MODIFY_VALUE__STRING = STRING_MODIFIER___MODIFY_VALUE__STRING;

	/**
	 * The number of operations of the '<em>To Upper Case Converter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_UPPER_CASE_CONVERTER_OPERATION_COUNT = STRING_MODIFIER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link pamtram.mapping.modifier.ValueModifierSet <em>Value Modifier Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Modifier Set</em>'.
	 * @see pamtram.mapping.modifier.ValueModifierSet
	 * @generated
	 */
	EClass getValueModifierSet();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.mapping.modifier.ValueModifierSet#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Modifier</em>'.
	 * @see pamtram.mapping.modifier.ValueModifierSet#getModifier()
	 * @see #getValueModifierSet()
	 * @generated
	 */
	EReference getValueModifierSet_Modifier();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.modifier.ValueModifier <em>Value Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Modifier</em>'.
	 * @see pamtram.mapping.modifier.ValueModifier
	 * @generated
	 */
	EClass getValueModifier();

	/**
	 * Returns the meta object for the '{@link pamtram.mapping.modifier.ValueModifier#modifyValue(java.lang.String) <em>Modify Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Modify Value</em>' operation.
	 * @see pamtram.mapping.modifier.ValueModifier#modifyValue(java.lang.String)
	 * @generated
	 */
	EOperation getValueModifier__ModifyValue__String();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.modifier.SubstringReplacer <em>Substring Replacer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Substring Replacer</em>'.
	 * @see pamtram.mapping.modifier.SubstringReplacer
	 * @generated
	 */
	EClass getSubstringReplacer();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.modifier.SubstringReplacer#getRegex <em>Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Regex</em>'.
	 * @see pamtram.mapping.modifier.SubstringReplacer#getRegex()
	 * @see #getSubstringReplacer()
	 * @generated
	 */
	EAttribute getSubstringReplacer_Regex();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.modifier.SubstringReplacer#getReplacement <em>Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Replacement</em>'.
	 * @see pamtram.mapping.modifier.SubstringReplacer#getReplacement()
	 * @see #getSubstringReplacer()
	 * @generated
	 */
	EAttribute getSubstringReplacer_Replacement();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.modifier.StringAppender <em>String Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Appender</em>'.
	 * @see pamtram.mapping.modifier.StringAppender
	 * @generated
	 */
	EClass getStringAppender();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.modifier.StringAppender#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see pamtram.mapping.modifier.StringAppender#getString()
	 * @see #getStringAppender()
	 * @generated
	 */
	EAttribute getStringAppender_String();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.modifier.UniqueNumberAppender <em>Unique Number Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unique Number Appender</em>'.
	 * @see pamtram.mapping.modifier.UniqueNumberAppender
	 * @generated
	 */
	EClass getUniqueNumberAppender();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.modifier.NumericModifier <em>Numeric Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Modifier</em>'.
	 * @see pamtram.mapping.modifier.NumericModifier
	 * @generated
	 */
	EClass getNumericModifier();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.modifier.ExpressionModifier <em>Expression Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Modifier</em>'.
	 * @see pamtram.mapping.modifier.ExpressionModifier
	 * @generated
	 */
	EClass getExpressionModifier();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.modifier.ExpressionModifier#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see pamtram.mapping.modifier.ExpressionModifier#getExpression()
	 * @see #getExpressionModifier()
	 * @generated
	 */
	EAttribute getExpressionModifier_Expression();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.modifier.StringModifier <em>String Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Modifier</em>'.
	 * @see pamtram.mapping.modifier.StringModifier
	 * @generated
	 */
	EClass getStringModifier();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.modifier.StringPrepender <em>String Prepender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Prepender</em>'.
	 * @see pamtram.mapping.modifier.StringPrepender
	 * @generated
	 */
	EClass getStringPrepender();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.modifier.StringPrepender#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see pamtram.mapping.modifier.StringPrepender#getString()
	 * @see #getStringPrepender()
	 * @generated
	 */
	EAttribute getStringPrepender_String();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.modifier.ToLowerCaseConverter <em>To Lower Case Converter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Lower Case Converter</em>'.
	 * @see pamtram.mapping.modifier.ToLowerCaseConverter
	 * @generated
	 */
	EClass getToLowerCaseConverter();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.modifier.ToLowerCaseConverter#getRegex <em>Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Regex</em>'.
	 * @see pamtram.mapping.modifier.ToLowerCaseConverter#getRegex()
	 * @see #getToLowerCaseConverter()
	 * @generated
	 */
	EAttribute getToLowerCaseConverter_Regex();

	/**
	 * Returns the meta object for class '{@link pamtram.mapping.modifier.ToUpperCaseConverter <em>To Upper Case Converter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Upper Case Converter</em>'.
	 * @see pamtram.mapping.modifier.ToUpperCaseConverter
	 * @generated
	 */
	EClass getToUpperCaseConverter();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.mapping.modifier.ToUpperCaseConverter#getRegex <em>Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Regex</em>'.
	 * @see pamtram.mapping.modifier.ToUpperCaseConverter#getRegex()
	 * @see #getToUpperCaseConverter()
	 * @generated
	 */
	EAttribute getToUpperCaseConverter_Regex();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModifierFactory getModifierFactory();

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
		 * The meta object literal for the '{@link pamtram.mapping.modifier.impl.ValueModifierSetImpl <em>Value Modifier Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.modifier.impl.ValueModifierSetImpl
		 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getValueModifierSet()
		 * @generated
		 */
		EClass VALUE_MODIFIER_SET = eINSTANCE.getValueModifierSet();

		/**
		 * The meta object literal for the '<em><b>Modifier</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_MODIFIER_SET__MODIFIER = eINSTANCE.getValueModifierSet_Modifier();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.modifier.ValueModifier <em>Value Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.modifier.ValueModifier
		 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getValueModifier()
		 * @generated
		 */
		EClass VALUE_MODIFIER = eINSTANCE.getValueModifier();

		/**
		 * The meta object literal for the '<em><b>Modify Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_MODIFIER___MODIFY_VALUE__STRING = eINSTANCE.getValueModifier__ModifyValue__String();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.modifier.impl.SubstringReplacerImpl <em>Substring Replacer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.modifier.impl.SubstringReplacerImpl
		 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getSubstringReplacer()
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
		 * The meta object literal for the '{@link pamtram.mapping.modifier.impl.StringAppenderImpl <em>String Appender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.modifier.impl.StringAppenderImpl
		 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getStringAppender()
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
		 * The meta object literal for the '{@link pamtram.mapping.modifier.impl.UniqueNumberAppenderImpl <em>Unique Number Appender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.modifier.impl.UniqueNumberAppenderImpl
		 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getUniqueNumberAppender()
		 * @generated
		 */
		EClass UNIQUE_NUMBER_APPENDER = eINSTANCE.getUniqueNumberAppender();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.modifier.impl.NumericModifierImpl <em>Numeric Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.modifier.impl.NumericModifierImpl
		 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getNumericModifier()
		 * @generated
		 */
		EClass NUMERIC_MODIFIER = eINSTANCE.getNumericModifier();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.modifier.impl.ExpressionModifierImpl <em>Expression Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.modifier.impl.ExpressionModifierImpl
		 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getExpressionModifier()
		 * @generated
		 */
		EClass EXPRESSION_MODIFIER = eINSTANCE.getExpressionModifier();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_MODIFIER__EXPRESSION = eINSTANCE.getExpressionModifier_Expression();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.modifier.impl.StringModifierImpl <em>String Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.modifier.impl.StringModifierImpl
		 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getStringModifier()
		 * @generated
		 */
		EClass STRING_MODIFIER = eINSTANCE.getStringModifier();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.modifier.impl.StringPrependerImpl <em>String Prepender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.modifier.impl.StringPrependerImpl
		 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getStringPrepender()
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
		 * The meta object literal for the '{@link pamtram.mapping.modifier.impl.ToLowerCaseConverterImpl <em>To Lower Case Converter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.modifier.impl.ToLowerCaseConverterImpl
		 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getToLowerCaseConverter()
		 * @generated
		 */
		EClass TO_LOWER_CASE_CONVERTER = eINSTANCE.getToLowerCaseConverter();

		/**
		 * The meta object literal for the '<em><b>Regex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TO_LOWER_CASE_CONVERTER__REGEX = eINSTANCE.getToLowerCaseConverter_Regex();

		/**
		 * The meta object literal for the '{@link pamtram.mapping.modifier.impl.ToUpperCaseConverterImpl <em>To Upper Case Converter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.mapping.modifier.impl.ToUpperCaseConverterImpl
		 * @see pamtram.mapping.modifier.impl.ModifierPackageImpl#getToUpperCaseConverter()
		 * @generated
		 */
		EClass TO_UPPER_CASE_CONVERTER = eINSTANCE.getToUpperCaseConverter();

		/**
		 * The meta object literal for the '<em><b>Regex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TO_UPPER_CASE_CONVERTER__REGEX = eINSTANCE.getToUpperCaseConverter_Regex();

	}

} //ModifierPackage
