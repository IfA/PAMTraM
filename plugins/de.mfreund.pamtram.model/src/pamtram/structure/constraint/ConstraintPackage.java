/**
 */
package pamtram.structure.constraint;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see pamtram.structure.constraint.ConstraintFactory
 * @model kind="package"
 * @generated
 */
public interface ConstraintPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "constraint";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mfreund.de/pamtram/structure/constraint";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "constraint";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConstraintPackage eINSTANCE = pamtram.structure.constraint.impl.ConstraintPackageImpl.init();

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.ValueConstraint <em>Value Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.ValueConstraint
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getValueConstraint()
	 * @generated
	 */
	int VALUE_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT__TYPE = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Local Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Value Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.impl.SingleReferenceValueConstraintImpl <em>Single Reference Value Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.impl.SingleReferenceValueConstraintImpl
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getSingleReferenceValueConstraint()
	 * @generated
	 */
	int SINGLE_REFERENCE_VALUE_CONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_VALUE_CONSTRAINT__NAME = VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE = VALUE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION = VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_VALUE_CONSTRAINT__RESULT_MODIFIER = VALUE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraint Reference Value Additional Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION = VALUE_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS = VALUE_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Single Reference Value Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_VALUE_CONSTRAINT_FEATURE_COUNT = VALUE_CONSTRAINT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Local Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT = VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING = VALUE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = VALUE_CONSTRAINT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values Or Global Attributes In Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = VALUE_CONSTRAINT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate No Result Modifier In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = VALUE_CONSTRAINT_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Single Reference Value Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_VALUE_CONSTRAINT_OPERATION_COUNT = VALUE_CONSTRAINT_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.CaseSensitiveConstraint <em>Case Sensitive Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.CaseSensitiveConstraint
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getCaseSensitiveConstraint()
	 * @generated
	 */
	int CASE_SENSITIVE_CONSTRAINT = 5;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.impl.EqualityConstraintImpl <em>Equality Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.impl.EqualityConstraintImpl
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getEqualityConstraint()
	 * @generated
	 */
	int EQUALITY_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_CONSTRAINT__NAME = SINGLE_REFERENCE_VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_CONSTRAINT__TYPE = SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_CONSTRAINT__EXPRESSION = SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Result Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_CONSTRAINT__RESULT_MODIFIER = SINGLE_REFERENCE_VALUE_CONSTRAINT__RESULT_MODIFIER;

	/**
	 * The feature id for the '<em><b>Constraint Reference Value Additional Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION = SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_CONSTRAINT__SOURCE_ELEMENTS = SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS;

	/**
	 * The number of structural features of the '<em>Equality Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_CONSTRAINT_FEATURE_COUNT = SINGLE_REFERENCE_VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Local Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_CONSTRAINT___IS_LOCAL_CONSTRAINT = SINGLE_REFERENCE_VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING = SINGLE_REFERENCE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values Or Global Attributes In Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate No Result Modifier In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Equality Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_CONSTRAINT_OPERATION_COUNT = SINGLE_REFERENCE_VALUE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.impl.ChoiceConstraintImpl <em>Choice Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.impl.ChoiceConstraintImpl
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getChoiceConstraint()
	 * @generated
	 */
	int CHOICE_CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_CONSTRAINT__NAME = VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_CONSTRAINT__TYPE = VALUE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Choices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_CONSTRAINT__CHOICES = VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Choice Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_CONSTRAINT_FEATURE_COUNT = VALUE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Local Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_CONSTRAINT___IS_LOCAL_CONSTRAINT = VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT;

	/**
	 * The number of operations of the '<em>Choice Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_CONSTRAINT_OPERATION_COUNT = VALUE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.impl.NumericConstraintImpl <em>Numeric Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.impl.NumericConstraintImpl
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getNumericConstraint()
	 * @generated
	 */
	int NUMERIC_CONSTRAINT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CONSTRAINT__NAME = SINGLE_REFERENCE_VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CONSTRAINT__TYPE = SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CONSTRAINT__EXPRESSION = SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Result Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CONSTRAINT__RESULT_MODIFIER = SINGLE_REFERENCE_VALUE_CONSTRAINT__RESULT_MODIFIER;

	/**
	 * The feature id for the '<em><b>Constraint Reference Value Additional Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION = SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CONSTRAINT__SOURCE_ELEMENTS = SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CONSTRAINT__OPERATOR_TYPE = SINGLE_REFERENCE_VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numeric Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CONSTRAINT_FEATURE_COUNT = SINGLE_REFERENCE_VALUE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Local Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CONSTRAINT___IS_LOCAL_CONSTRAINT = SINGLE_REFERENCE_VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING = SINGLE_REFERENCE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values Or Global Attributes In Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate No Result Modifier In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Numeric Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CONSTRAINT_OPERATION_COUNT = SINGLE_REFERENCE_VALUE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT__NAME = SINGLE_REFERENCE_VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT__TYPE = SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT__EXPRESSION = SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Result Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT__RESULT_MODIFIER = SINGLE_REFERENCE_VALUE_CONSTRAINT__RESULT_MODIFIER;

	/**
	 * The feature id for the '<em><b>Constraint Reference Value Additional Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION = SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT__SOURCE_ELEMENTS = SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Case Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE = SINGLE_REFERENCE_VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Case Sensitive Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT_FEATURE_COUNT = SINGLE_REFERENCE_VALUE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Local Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT___IS_LOCAL_CONSTRAINT = SINGLE_REFERENCE_VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING = SINGLE_REFERENCE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values Or Global Attributes In Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate No Result Modifier In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Case Sensitive Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT_OPERATION_COUNT = SINGLE_REFERENCE_VALUE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.impl.StringConstraintImpl <em>String Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.impl.StringConstraintImpl
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getStringConstraint()
	 * @generated
	 */
	int STRING_CONSTRAINT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONSTRAINT__NAME = CASE_SENSITIVE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONSTRAINT__TYPE = CASE_SENSITIVE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONSTRAINT__EXPRESSION = CASE_SENSITIVE_CONSTRAINT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Result Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONSTRAINT__RESULT_MODIFIER = CASE_SENSITIVE_CONSTRAINT__RESULT_MODIFIER;

	/**
	 * The feature id for the '<em><b>Constraint Reference Value Additional Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION = CASE_SENSITIVE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONSTRAINT__SOURCE_ELEMENTS = CASE_SENSITIVE_CONSTRAINT__SOURCE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Case Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONSTRAINT__CASE_SENSITIVE = CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONSTRAINT__OPERATOR_TYPE = CASE_SENSITIVE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONSTRAINT_FEATURE_COUNT = CASE_SENSITIVE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Local Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONSTRAINT___IS_LOCAL_CONSTRAINT = CASE_SENSITIVE_CONSTRAINT___IS_LOCAL_CONSTRAINT;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING = CASE_SENSITIVE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = CASE_SENSITIVE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values Or Global Attributes In Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = CASE_SENSITIVE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate No Result Modifier In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = CASE_SENSITIVE_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>String Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONSTRAINT_OPERATION_COUNT = CASE_SENSITIVE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.impl.SubstringConstraintImpl <em>Substring Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.impl.SubstringConstraintImpl
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getSubstringConstraint()
	 * @generated
	 */
	int SUBSTRING_CONSTRAINT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_CONSTRAINT__NAME = CASE_SENSITIVE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_CONSTRAINT__TYPE = CASE_SENSITIVE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_CONSTRAINT__EXPRESSION = CASE_SENSITIVE_CONSTRAINT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Result Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_CONSTRAINT__RESULT_MODIFIER = CASE_SENSITIVE_CONSTRAINT__RESULT_MODIFIER;

	/**
	 * The feature id for the '<em><b>Constraint Reference Value Additional Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION = CASE_SENSITIVE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_CONSTRAINT__SOURCE_ELEMENTS = CASE_SENSITIVE_CONSTRAINT__SOURCE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Case Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_CONSTRAINT__CASE_SENSITIVE = CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE;

	/**
	 * The number of structural features of the '<em>Substring Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_CONSTRAINT_FEATURE_COUNT = CASE_SENSITIVE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Local Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_CONSTRAINT___IS_LOCAL_CONSTRAINT = CASE_SENSITIVE_CONSTRAINT___IS_LOCAL_CONSTRAINT;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING = CASE_SENSITIVE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = CASE_SENSITIVE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values Or Global Attributes In Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = CASE_SENSITIVE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate No Result Modifier In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = CASE_SENSITIVE_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Substring Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_CONSTRAINT_OPERATION_COUNT = CASE_SENSITIVE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.impl.BeginningConstraintImpl <em>Beginning Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.impl.BeginningConstraintImpl
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getBeginningConstraint()
	 * @generated
	 */
	int BEGINNING_CONSTRAINT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_CONSTRAINT__NAME = CASE_SENSITIVE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_CONSTRAINT__TYPE = CASE_SENSITIVE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_CONSTRAINT__EXPRESSION = CASE_SENSITIVE_CONSTRAINT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Result Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_CONSTRAINT__RESULT_MODIFIER = CASE_SENSITIVE_CONSTRAINT__RESULT_MODIFIER;

	/**
	 * The feature id for the '<em><b>Constraint Reference Value Additional Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION = CASE_SENSITIVE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_CONSTRAINT__SOURCE_ELEMENTS = CASE_SENSITIVE_CONSTRAINT__SOURCE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Case Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_CONSTRAINT__CASE_SENSITIVE = CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE;

	/**
	 * The number of structural features of the '<em>Beginning Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_CONSTRAINT_FEATURE_COUNT = CASE_SENSITIVE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Local Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_CONSTRAINT___IS_LOCAL_CONSTRAINT = CASE_SENSITIVE_CONSTRAINT___IS_LOCAL_CONSTRAINT;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING = CASE_SENSITIVE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = CASE_SENSITIVE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values Or Global Attributes In Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = CASE_SENSITIVE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate No Result Modifier In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = CASE_SENSITIVE_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Beginning Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_CONSTRAINT_OPERATION_COUNT = CASE_SENSITIVE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.impl.EndingConstraintImpl <em>Ending Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.impl.EndingConstraintImpl
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getEndingConstraint()
	 * @generated
	 */
	int ENDING_CONSTRAINT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_CONSTRAINT__NAME = CASE_SENSITIVE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_CONSTRAINT__TYPE = CASE_SENSITIVE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_CONSTRAINT__EXPRESSION = CASE_SENSITIVE_CONSTRAINT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Result Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_CONSTRAINT__RESULT_MODIFIER = CASE_SENSITIVE_CONSTRAINT__RESULT_MODIFIER;

	/**
	 * The feature id for the '<em><b>Constraint Reference Value Additional Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION = CASE_SENSITIVE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_CONSTRAINT__SOURCE_ELEMENTS = CASE_SENSITIVE_CONSTRAINT__SOURCE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Case Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_CONSTRAINT__CASE_SENSITIVE = CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE;

	/**
	 * The number of structural features of the '<em>Ending Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_CONSTRAINT_FEATURE_COUNT = CASE_SENSITIVE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Local Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_CONSTRAINT___IS_LOCAL_CONSTRAINT = CASE_SENSITIVE_CONSTRAINT___IS_LOCAL_CONSTRAINT;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING = CASE_SENSITIVE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = CASE_SENSITIVE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values Or Global Attributes In Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = CASE_SENSITIVE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate No Result Modifier In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = CASE_SENSITIVE_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Ending Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_CONSTRAINT_OPERATION_COUNT = CASE_SENSITIVE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.impl.RegExConstraintImpl <em>Reg Ex Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.impl.RegExConstraintImpl
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getRegExConstraint()
	 * @generated
	 */
	int REG_EX_CONSTRAINT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT__NAME = SINGLE_REFERENCE_VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT__TYPE = SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT__EXPRESSION = SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Result Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT__RESULT_MODIFIER = SINGLE_REFERENCE_VALUE_CONSTRAINT__RESULT_MODIFIER;

	/**
	 * The feature id for the '<em><b>Constraint Reference Value Additional Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION = SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT__SOURCE_ELEMENTS = SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS;

	/**
	 * The number of structural features of the '<em>Reg Ex Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT_FEATURE_COUNT = SINGLE_REFERENCE_VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Local Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT___IS_LOCAL_CONSTRAINT = SINGLE_REFERENCE_VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING = SINGLE_REFERENCE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values Or Global Attributes In Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate No Result Modifier In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Reg Ex Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_CONSTRAINT_OPERATION_COUNT = SINGLE_REFERENCE_VALUE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.impl.MultipleReferencesValueConstraintImpl <em>Multiple References Value Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.impl.MultipleReferencesValueConstraintImpl
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getMultipleReferencesValueConstraint()
	 * @generated
	 */
	int MULTIPLE_REFERENCES_VALUE_CONSTRAINT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_REFERENCES_VALUE_CONSTRAINT__NAME = VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_REFERENCES_VALUE_CONSTRAINT__TYPE = VALUE_CONSTRAINT__TYPE;

	/**
	 * The number of structural features of the '<em>Multiple References Value Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_REFERENCES_VALUE_CONSTRAINT_FEATURE_COUNT = VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Local Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_REFERENCES_VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT = VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_REFERENCES_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_ELIST = VALUE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Multiple References Value Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_REFERENCES_VALUE_CONSTRAINT_OPERATION_COUNT = VALUE_CONSTRAINT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.impl.RangeConstraintImpl <em>Range Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.impl.RangeConstraintImpl
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getRangeConstraint()
	 * @generated
	 */
	int RANGE_CONSTRAINT = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__NAME = MULTIPLE_REFERENCES_VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__TYPE = MULTIPLE_REFERENCES_VALUE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__UPPER_BOUND = MULTIPLE_REFERENCES_VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__LOWER_BOUND = MULTIPLE_REFERENCES_VALUE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Range Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT_FEATURE_COUNT = MULTIPLE_REFERENCES_VALUE_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Local Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT___IS_LOCAL_CONSTRAINT = MULTIPLE_REFERENCES_VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT___CHECK_CONSTRAINT__STRING_ELIST = MULTIPLE_REFERENCES_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_ELIST;

	/**
	 * The number of operations of the '<em>Range Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT_OPERATION_COUNT = MULTIPLE_REFERENCES_VALUE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.ValueConstraintSourceInterface <em>Value Constraint Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.ValueConstraintSourceInterface
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getValueConstraintSourceInterface()
	 * @generated
	 */
	int VALUE_CONSTRAINT_SOURCE_INTERFACE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_SOURCE_INTERFACE__NAME = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE__NAME;

	/**
	 * The number of structural features of the '<em>Value Constraint Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_SOURCE_INTERFACE_FEATURE_COUNT = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE;

	/**
	 * The number of operations of the '<em>Value Constraint Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_SOURCE_INTERFACE_OPERATION_COUNT = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.impl.ValueConstraintSourceElementImpl <em>Value Constraint Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.impl.ValueConstraintSourceElementImpl
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getValueConstraintSourceElement()
	 * @generated
	 */
	int VALUE_CONSTRAINT_SOURCE_ELEMENT = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_SOURCE_ELEMENT__NAME = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_SOURCE_ELEMENT__SOURCE = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_SOURCE_ELEMENT__MODIFIER = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>Value Constraint Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_SOURCE_ELEMENT_FEATURE_COUNT = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_SOURCE_ELEMENT___GET_MAPPING = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Value Constraint Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_SOURCE_ELEMENT_OPERATION_COUNT = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.impl.ValueConstraintExternalSourceElementImpl <em>Value Constraint External Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.impl.ValueConstraintExternalSourceElementImpl
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getValueConstraintExternalSourceElement()
	 * @generated
	 */
	int VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT__NAME = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT__SOURCE = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT__MODIFIER = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>Value Constraint External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT_FEATURE_COUNT = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Value Constraint External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT_OPERATION_COUNT = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.impl.RangeBoundImpl <em>Range Bound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.impl.RangeBoundImpl
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getRangeBound()
	 * @generated
	 */
	int RANGE_BOUND = 16;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_BOUND__EXPRESSION = MappingPackage.EXPRESSION_HINT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Result Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_BOUND__RESULT_MODIFIER = MappingPackage.EXPRESSION_HINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bound Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_BOUND__BOUND_TYPE = MappingPackage.EXPRESSION_HINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bound Reference Value Additional Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION = MappingPackage.EXPRESSION_HINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_BOUND__SOURCE_ELEMENTS = MappingPackage.EXPRESSION_HINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Range Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_BOUND_FEATURE_COUNT = MappingPackage.EXPRESSION_HINT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values In Source Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_BOUND___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = MappingPackage.EXPRESSION_HINT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Only Fixed Values Or Global Attributes In Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_BOUND___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = MappingPackage.EXPRESSION_HINT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Local Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_BOUND___IS_LOCAL_CONSTRAINT = MappingPackage.EXPRESSION_HINT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Range Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_BOUND_OPERATION_COUNT = MappingPackage.EXPRESSION_HINT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.ValueConstraintType <em>Value Constraint Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.ValueConstraintType
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getValueConstraintType()
	 * @generated
	 */
	int VALUE_CONSTRAINT_TYPE = 17;


	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.NumericConstraintOperatorType <em>Numeric Constraint Operator Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.NumericConstraintOperatorType
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getNumericConstraintOperatorType()
	 * @generated
	 */
	int NUMERIC_CONSTRAINT_OPERATOR_TYPE = 18;


	/**
	 * The meta object id for the '{@link pamtram.structure.constraint.StringConstraintOperatorType <em>String Constraint Operator Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.constraint.StringConstraintOperatorType
	 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getStringConstraintOperatorType()
	 * @generated
	 */
	int STRING_CONSTRAINT_OPERATOR_TYPE = 19;


	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.ValueConstraint <em>Value Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Constraint</em>'.
	 * @see pamtram.structure.constraint.ValueConstraint
	 * @generated
	 */
	EClass getValueConstraint();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.constraint.ValueConstraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see pamtram.structure.constraint.ValueConstraint#getType()
	 * @see #getValueConstraint()
	 * @generated
	 */
	EAttribute getValueConstraint_Type();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.constraint.ValueConstraint#isLocalConstraint() <em>Is Local Constraint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Local Constraint</em>' operation.
	 * @see pamtram.structure.constraint.ValueConstraint#isLocalConstraint()
	 * @generated
	 */
	EOperation getValueConstraint__IsLocalConstraint();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.CaseSensitiveConstraint <em>Case Sensitive Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Sensitive Constraint</em>'.
	 * @see pamtram.structure.constraint.CaseSensitiveConstraint
	 * @generated
	 */
	EClass getCaseSensitiveConstraint();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.constraint.CaseSensitiveConstraint#isCaseSensitive <em>Case Sensitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Case Sensitive</em>'.
	 * @see pamtram.structure.constraint.CaseSensitiveConstraint#isCaseSensitive()
	 * @see #getCaseSensitiveConstraint()
	 * @generated
	 */
	EAttribute getCaseSensitiveConstraint_CaseSensitive();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.StringConstraint <em>String Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Constraint</em>'.
	 * @see pamtram.structure.constraint.StringConstraint
	 * @generated
	 */
	EClass getStringConstraint();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.constraint.StringConstraint#getOperatorType <em>Operator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator Type</em>'.
	 * @see pamtram.structure.constraint.StringConstraint#getOperatorType()
	 * @see #getStringConstraint()
	 * @generated
	 */
	EAttribute getStringConstraint_OperatorType();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.EqualityConstraint <em>Equality Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equality Constraint</em>'.
	 * @see pamtram.structure.constraint.EqualityConstraint
	 * @generated
	 */
	EClass getEqualityConstraint();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.ChoiceConstraint <em>Choice Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice Constraint</em>'.
	 * @see pamtram.structure.constraint.ChoiceConstraint
	 * @generated
	 */
	EClass getChoiceConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.structure.constraint.ChoiceConstraint#getChoices <em>Choices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Choices</em>'.
	 * @see pamtram.structure.constraint.ChoiceConstraint#getChoices()
	 * @see #getChoiceConstraint()
	 * @generated
	 */
	EReference getChoiceConstraint_Choices();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.NumericConstraint <em>Numeric Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Constraint</em>'.
	 * @see pamtram.structure.constraint.NumericConstraint
	 * @generated
	 */
	EClass getNumericConstraint();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.constraint.NumericConstraint#getOperatorType <em>Operator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator Type</em>'.
	 * @see pamtram.structure.constraint.NumericConstraint#getOperatorType()
	 * @see #getNumericConstraint()
	 * @generated
	 */
	EAttribute getNumericConstraint_OperatorType();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.SubstringConstraint <em>Substring Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Substring Constraint</em>'.
	 * @see pamtram.structure.constraint.SubstringConstraint
	 * @generated
	 */
	EClass getSubstringConstraint();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.BeginningConstraint <em>Beginning Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Beginning Constraint</em>'.
	 * @see pamtram.structure.constraint.BeginningConstraint
	 * @generated
	 */
	EClass getBeginningConstraint();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.EndingConstraint <em>Ending Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ending Constraint</em>'.
	 * @see pamtram.structure.constraint.EndingConstraint
	 * @generated
	 */
	EClass getEndingConstraint();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.RegExConstraint <em>Reg Ex Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reg Ex Constraint</em>'.
	 * @see pamtram.structure.constraint.RegExConstraint
	 * @generated
	 */
	EClass getRegExConstraint();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.RangeConstraint <em>Range Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Range Constraint</em>'.
	 * @see pamtram.structure.constraint.RangeConstraint
	 * @generated
	 */
	EClass getRangeConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.structure.constraint.RangeConstraint#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Upper Bound</em>'.
	 * @see pamtram.structure.constraint.RangeConstraint#getUpperBound()
	 * @see #getRangeConstraint()
	 * @generated
	 */
	EReference getRangeConstraint_UpperBound();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.structure.constraint.RangeConstraint#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lower Bound</em>'.
	 * @see pamtram.structure.constraint.RangeConstraint#getLowerBound()
	 * @see #getRangeConstraint()
	 * @generated
	 */
	EReference getRangeConstraint_LowerBound();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.MultipleReferencesValueConstraint <em>Multiple References Value Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiple References Value Constraint</em>'.
	 * @see pamtram.structure.constraint.MultipleReferencesValueConstraint
	 * @generated
	 */
	EClass getMultipleReferencesValueConstraint();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.constraint.MultipleReferencesValueConstraint#checkConstraint(java.lang.String, org.eclipse.emf.common.util.EList) <em>Check Constraint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Check Constraint</em>' operation.
	 * @see pamtram.structure.constraint.MultipleReferencesValueConstraint#checkConstraint(java.lang.String, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getMultipleReferencesValueConstraint__CheckConstraint__String_EList();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.SingleReferenceValueConstraint <em>Single Reference Value Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Reference Value Constraint</em>'.
	 * @see pamtram.structure.constraint.SingleReferenceValueConstraint
	 * @generated
	 */
	EClass getSingleReferenceValueConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.structure.constraint.SingleReferenceValueConstraint#getConstraintReferenceValueAdditionalSpecification <em>Constraint Reference Value Additional Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint Reference Value Additional Specification</em>'.
	 * @see pamtram.structure.constraint.SingleReferenceValueConstraint#getConstraintReferenceValueAdditionalSpecification()
	 * @see #getSingleReferenceValueConstraint()
	 * @generated
	 */
	EReference getSingleReferenceValueConstraint_ConstraintReferenceValueAdditionalSpecification();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.structure.constraint.SingleReferenceValueConstraint#getSourceElements <em>Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Elements</em>'.
	 * @see pamtram.structure.constraint.SingleReferenceValueConstraint#getSourceElements()
	 * @see #getSingleReferenceValueConstraint()
	 * @generated
	 */
	EReference getSingleReferenceValueConstraint_SourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.constraint.SingleReferenceValueConstraint#checkConstraint(java.lang.String, java.lang.String) <em>Check Constraint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Check Constraint</em>' operation.
	 * @see pamtram.structure.constraint.SingleReferenceValueConstraint#checkConstraint(java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getSingleReferenceValueConstraint__CheckConstraint__String_String();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.constraint.SingleReferenceValueConstraint#validateOnlyFixedValuesInSourceSections(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Only Fixed Values In Source Sections</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Only Fixed Values In Source Sections</em>' operation.
	 * @see pamtram.structure.constraint.SingleReferenceValueConstraint#validateOnlyFixedValuesInSourceSections(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSingleReferenceValueConstraint__ValidateOnlyFixedValuesInSourceSections__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.constraint.SingleReferenceValueConstraint#validateOnlyFixedValuesOrGlobalAttributesInConditionModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Only Fixed Values Or Global Attributes In Condition Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Only Fixed Values Or Global Attributes In Condition Model</em>' operation.
	 * @see pamtram.structure.constraint.SingleReferenceValueConstraint#validateOnlyFixedValuesOrGlobalAttributesInConditionModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSingleReferenceValueConstraint__ValidateOnlyFixedValuesOrGlobalAttributesInConditionModel__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.constraint.SingleReferenceValueConstraint#validateNoResultModifierInSourceSections(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Result Modifier In Source Sections</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate No Result Modifier In Source Sections</em>' operation.
	 * @see pamtram.structure.constraint.SingleReferenceValueConstraint#validateNoResultModifierInSourceSections(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSingleReferenceValueConstraint__ValidateNoResultModifierInSourceSections__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.ValueConstraintSourceInterface <em>Value Constraint Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Constraint Source Interface</em>'.
	 * @see pamtram.structure.constraint.ValueConstraintSourceInterface
	 * @generated
	 */
	EClass getValueConstraintSourceInterface();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.ValueConstraintSourceElement <em>Value Constraint Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Constraint Source Element</em>'.
	 * @see pamtram.structure.constraint.ValueConstraintSourceElement
	 * @generated
	 */
	EClass getValueConstraintSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.ValueConstraintExternalSourceElement <em>Value Constraint External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Constraint External Source Element</em>'.
	 * @see pamtram.structure.constraint.ValueConstraintExternalSourceElement
	 * @generated
	 */
	EClass getValueConstraintExternalSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.constraint.RangeBound <em>Range Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Range Bound</em>'.
	 * @see pamtram.structure.constraint.RangeBound
	 * @generated
	 */
	EClass getRangeBound();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.constraint.RangeBound#getBoundType <em>Bound Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bound Type</em>'.
	 * @see pamtram.structure.constraint.RangeBound#getBoundType()
	 * @see #getRangeBound()
	 * @generated
	 */
	EAttribute getRangeBound_BoundType();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.structure.constraint.RangeBound#getBoundReferenceValueAdditionalSpecification <em>Bound Reference Value Additional Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bound Reference Value Additional Specification</em>'.
	 * @see pamtram.structure.constraint.RangeBound#getBoundReferenceValueAdditionalSpecification()
	 * @see #getRangeBound()
	 * @generated
	 */
	EReference getRangeBound_BoundReferenceValueAdditionalSpecification();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.structure.constraint.RangeBound#getSourceElements <em>Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Elements</em>'.
	 * @see pamtram.structure.constraint.RangeBound#getSourceElements()
	 * @see #getRangeBound()
	 * @generated
	 */
	EReference getRangeBound_SourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.constraint.RangeBound#validateOnlyFixedValuesInSourceSections(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Only Fixed Values In Source Sections</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Only Fixed Values In Source Sections</em>' operation.
	 * @see pamtram.structure.constraint.RangeBound#validateOnlyFixedValuesInSourceSections(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRangeBound__ValidateOnlyFixedValuesInSourceSections__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.constraint.RangeBound#validateOnlyFixedValuesOrGlobalAttributesInConditionModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Only Fixed Values Or Global Attributes In Condition Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Only Fixed Values Or Global Attributes In Condition Model</em>' operation.
	 * @see pamtram.structure.constraint.RangeBound#validateOnlyFixedValuesOrGlobalAttributesInConditionModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRangeBound__ValidateOnlyFixedValuesOrGlobalAttributesInConditionModel__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.constraint.RangeBound#isLocalConstraint() <em>Is Local Constraint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Local Constraint</em>' operation.
	 * @see pamtram.structure.constraint.RangeBound#isLocalConstraint()
	 * @generated
	 */
	EOperation getRangeBound__IsLocalConstraint();

	/**
	 * Returns the meta object for enum '{@link pamtram.structure.constraint.ValueConstraintType <em>Value Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Value Constraint Type</em>'.
	 * @see pamtram.structure.constraint.ValueConstraintType
	 * @generated
	 */
	EEnum getValueConstraintType();

	/**
	 * Returns the meta object for enum '{@link pamtram.structure.constraint.NumericConstraintOperatorType <em>Numeric Constraint Operator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Numeric Constraint Operator Type</em>'.
	 * @see pamtram.structure.constraint.NumericConstraintOperatorType
	 * @generated
	 */
	EEnum getNumericConstraintOperatorType();

	/**
	 * Returns the meta object for enum '{@link pamtram.structure.constraint.StringConstraintOperatorType <em>String Constraint Operator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>String Constraint Operator Type</em>'.
	 * @see pamtram.structure.constraint.StringConstraintOperatorType
	 * @generated
	 */
	EEnum getStringConstraintOperatorType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConstraintFactory getConstraintFactory();

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
		 * The meta object literal for the '{@link pamtram.structure.constraint.ValueConstraint <em>Value Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.ValueConstraint
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getValueConstraint()
		 * @generated
		 */
		EClass VALUE_CONSTRAINT = eINSTANCE.getValueConstraint();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_CONSTRAINT__TYPE = eINSTANCE.getValueConstraint_Type();

		/**
		 * The meta object literal for the '<em><b>Is Local Constraint</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT = eINSTANCE.getValueConstraint__IsLocalConstraint();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.CaseSensitiveConstraint <em>Case Sensitive Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.CaseSensitiveConstraint
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getCaseSensitiveConstraint()
		 * @generated
		 */
		EClass CASE_SENSITIVE_CONSTRAINT = eINSTANCE.getCaseSensitiveConstraint();

		/**
		 * The meta object literal for the '<em><b>Case Sensitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE = eINSTANCE.getCaseSensitiveConstraint_CaseSensitive();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.impl.StringConstraintImpl <em>String Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.impl.StringConstraintImpl
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getStringConstraint()
		 * @generated
		 */
		EClass STRING_CONSTRAINT = eINSTANCE.getStringConstraint();

		/**
		 * The meta object literal for the '<em><b>Operator Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_CONSTRAINT__OPERATOR_TYPE = eINSTANCE.getStringConstraint_OperatorType();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.impl.EqualityConstraintImpl <em>Equality Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.impl.EqualityConstraintImpl
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getEqualityConstraint()
		 * @generated
		 */
		EClass EQUALITY_CONSTRAINT = eINSTANCE.getEqualityConstraint();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.impl.ChoiceConstraintImpl <em>Choice Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.impl.ChoiceConstraintImpl
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getChoiceConstraint()
		 * @generated
		 */
		EClass CHOICE_CONSTRAINT = eINSTANCE.getChoiceConstraint();

		/**
		 * The meta object literal for the '<em><b>Choices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_CONSTRAINT__CHOICES = eINSTANCE.getChoiceConstraint_Choices();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.impl.NumericConstraintImpl <em>Numeric Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.impl.NumericConstraintImpl
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getNumericConstraint()
		 * @generated
		 */
		EClass NUMERIC_CONSTRAINT = eINSTANCE.getNumericConstraint();

		/**
		 * The meta object literal for the '<em><b>Operator Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_CONSTRAINT__OPERATOR_TYPE = eINSTANCE.getNumericConstraint_OperatorType();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.impl.SubstringConstraintImpl <em>Substring Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.impl.SubstringConstraintImpl
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getSubstringConstraint()
		 * @generated
		 */
		EClass SUBSTRING_CONSTRAINT = eINSTANCE.getSubstringConstraint();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.impl.BeginningConstraintImpl <em>Beginning Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.impl.BeginningConstraintImpl
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getBeginningConstraint()
		 * @generated
		 */
		EClass BEGINNING_CONSTRAINT = eINSTANCE.getBeginningConstraint();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.impl.EndingConstraintImpl <em>Ending Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.impl.EndingConstraintImpl
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getEndingConstraint()
		 * @generated
		 */
		EClass ENDING_CONSTRAINT = eINSTANCE.getEndingConstraint();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.impl.RegExConstraintImpl <em>Reg Ex Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.impl.RegExConstraintImpl
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getRegExConstraint()
		 * @generated
		 */
		EClass REG_EX_CONSTRAINT = eINSTANCE.getRegExConstraint();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.impl.RangeConstraintImpl <em>Range Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.impl.RangeConstraintImpl
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getRangeConstraint()
		 * @generated
		 */
		EClass RANGE_CONSTRAINT = eINSTANCE.getRangeConstraint();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANGE_CONSTRAINT__UPPER_BOUND = eINSTANCE.getRangeConstraint_UpperBound();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANGE_CONSTRAINT__LOWER_BOUND = eINSTANCE.getRangeConstraint_LowerBound();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.impl.MultipleReferencesValueConstraintImpl <em>Multiple References Value Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.impl.MultipleReferencesValueConstraintImpl
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getMultipleReferencesValueConstraint()
		 * @generated
		 */
		EClass MULTIPLE_REFERENCES_VALUE_CONSTRAINT = eINSTANCE.getMultipleReferencesValueConstraint();

		/**
		 * The meta object literal for the '<em><b>Check Constraint</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MULTIPLE_REFERENCES_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_ELIST = eINSTANCE.getMultipleReferencesValueConstraint__CheckConstraint__String_EList();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.impl.SingleReferenceValueConstraintImpl <em>Single Reference Value Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.impl.SingleReferenceValueConstraintImpl
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getSingleReferenceValueConstraint()
		 * @generated
		 */
		EClass SINGLE_REFERENCE_VALUE_CONSTRAINT = eINSTANCE.getSingleReferenceValueConstraint();

		/**
		 * The meta object literal for the '<em><b>Constraint Reference Value Additional Specification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION = eINSTANCE.getSingleReferenceValueConstraint_ConstraintReferenceValueAdditionalSpecification();

		/**
		 * The meta object literal for the '<em><b>Source Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS = eINSTANCE.getSingleReferenceValueConstraint_SourceElements();

		/**
		 * The meta object literal for the '<em><b>Check Constraint</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SINGLE_REFERENCE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING = eINSTANCE.getSingleReferenceValueConstraint__CheckConstraint__String_String();

		/**
		 * The meta object literal for the '<em><b>Validate Only Fixed Values In Source Sections</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSingleReferenceValueConstraint__ValidateOnlyFixedValuesInSourceSections__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Only Fixed Values Or Global Attributes In Condition Model</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSingleReferenceValueConstraint__ValidateOnlyFixedValuesOrGlobalAttributesInConditionModel__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate No Result Modifier In Source Sections</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSingleReferenceValueConstraint__ValidateNoResultModifierInSourceSections__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.ValueConstraintSourceInterface <em>Value Constraint Source Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.ValueConstraintSourceInterface
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getValueConstraintSourceInterface()
		 * @generated
		 */
		EClass VALUE_CONSTRAINT_SOURCE_INTERFACE = eINSTANCE.getValueConstraintSourceInterface();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.impl.ValueConstraintSourceElementImpl <em>Value Constraint Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.impl.ValueConstraintSourceElementImpl
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getValueConstraintSourceElement()
		 * @generated
		 */
		EClass VALUE_CONSTRAINT_SOURCE_ELEMENT = eINSTANCE.getValueConstraintSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.impl.ValueConstraintExternalSourceElementImpl <em>Value Constraint External Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.impl.ValueConstraintExternalSourceElementImpl
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getValueConstraintExternalSourceElement()
		 * @generated
		 */
		EClass VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT = eINSTANCE.getValueConstraintExternalSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.impl.RangeBoundImpl <em>Range Bound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.impl.RangeBoundImpl
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getRangeBound()
		 * @generated
		 */
		EClass RANGE_BOUND = eINSTANCE.getRangeBound();

		/**
		 * The meta object literal for the '<em><b>Bound Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANGE_BOUND__BOUND_TYPE = eINSTANCE.getRangeBound_BoundType();

		/**
		 * The meta object literal for the '<em><b>Bound Reference Value Additional Specification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION = eINSTANCE.getRangeBound_BoundReferenceValueAdditionalSpecification();

		/**
		 * The meta object literal for the '<em><b>Source Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANGE_BOUND__SOURCE_ELEMENTS = eINSTANCE.getRangeBound_SourceElements();

		/**
		 * The meta object literal for the '<em><b>Validate Only Fixed Values In Source Sections</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RANGE_BOUND___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRangeBound__ValidateOnlyFixedValuesInSourceSections__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Only Fixed Values Or Global Attributes In Condition Model</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RANGE_BOUND___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRangeBound__ValidateOnlyFixedValuesOrGlobalAttributesInConditionModel__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Is Local Constraint</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RANGE_BOUND___IS_LOCAL_CONSTRAINT = eINSTANCE.getRangeBound__IsLocalConstraint();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.ValueConstraintType <em>Value Constraint Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.ValueConstraintType
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getValueConstraintType()
		 * @generated
		 */
		EEnum VALUE_CONSTRAINT_TYPE = eINSTANCE.getValueConstraintType();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.NumericConstraintOperatorType <em>Numeric Constraint Operator Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.NumericConstraintOperatorType
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getNumericConstraintOperatorType()
		 * @generated
		 */
		EEnum NUMERIC_CONSTRAINT_OPERATOR_TYPE = eINSTANCE.getNumericConstraintOperatorType();

		/**
		 * The meta object literal for the '{@link pamtram.structure.constraint.StringConstraintOperatorType <em>String Constraint Operator Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.constraint.StringConstraintOperatorType
		 * @see pamtram.structure.constraint.impl.ConstraintPackageImpl#getStringConstraintOperatorType()
		 * @generated
		 */
		EEnum STRING_CONSTRAINT_OPERATOR_TYPE = eINSTANCE.getStringConstraintOperatorType();

	}

} //ConstraintPackage
