/**
 */
package pamtram.condition;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see pamtram.condition.ConditionFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore' genlib='http://www.et.tu-dresden.de/ifa/agtele/genlib'"
 * @generated
 */
public interface ConditionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "condition";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mfreund.de/pamtram/condition";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "condition";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConditionPackage eINSTANCE = pamtram.condition.impl.ConditionPackageImpl.init();

	/**
	 * The meta object id for the '{@link pamtram.condition.impl.ComplexConditionImpl <em>Complex Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.impl.ComplexConditionImpl
	 * @see pamtram.condition.impl.ConditionPackageImpl#getComplexCondition()
	 * @generated
	 */
	int COMPLEX_CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CONDITION__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Complex Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CONDITION_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Local Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CONDITION___IS_LOCAL_CONDITION = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Mapping Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CONDITION___IS_MAPPING_CONDITION = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Condition Model Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CONDITION___IS_CONDITION_MODEL_CONDITION = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Complex Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CONDITION_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link pamtram.condition.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.impl.ConditionImpl
	 * @see pamtram.condition.impl.ConditionPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__NAME = COMPLEX_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Additional Condition Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__ADDITIONAL_CONDITION_SPECIFICATION = COMPLEX_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__VALUE = COMPLEX_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Comparator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__COMPARATOR = COMPLEX_CONDITION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = COMPLEX_CONDITION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Local Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION___IS_LOCAL_CONDITION = COMPLEX_CONDITION___IS_LOCAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Mapping Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION___IS_MAPPING_CONDITION = COMPLEX_CONDITION___IS_MAPPING_CONDITION;

	/**
	 * The operation id for the '<em>Is Condition Model Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION___IS_CONDITION_MODEL_CONDITION = COMPLEX_CONDITION___IS_CONDITION_MODEL_CONDITION;

	/**
	 * The operation id for the '<em>Check Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION___CHECK_CONDITION__COMPLEXCONDITION = COMPLEX_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_OPERATION_COUNT = COMPLEX_CONDITION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.condition.impl.VariadicConditionImpl <em>Variadic Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.impl.VariadicConditionImpl
	 * @see pamtram.condition.impl.ConditionPackageImpl#getVariadicCondition()
	 * @generated
	 */
	int VARIADIC_CONDITION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION__NAME = COMPLEX_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Cond Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION__COND_PARTS = COMPLEX_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cond Parts Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION__COND_PARTS_REF = COMPLEX_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variadic Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION_FEATURE_COUNT = COMPLEX_CONDITION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Local Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION___IS_LOCAL_CONDITION = COMPLEX_CONDITION___IS_LOCAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Mapping Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION___IS_MAPPING_CONDITION = COMPLEX_CONDITION___IS_MAPPING_CONDITION;

	/**
	 * The operation id for the '<em>Is Condition Model Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION___IS_CONDITION_MODEL_CONDITION = COMPLEX_CONDITION___IS_CONDITION_MODEL_CONDITION;

	/**
	 * The operation id for the '<em>References Only Valid Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION___REFERENCES_ONLY_VALID_CONDITIONS = COMPLEX_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Minimal Number Of Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION___MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP = COMPLEX_CONDITION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Variadic Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION_OPERATION_COUNT = COMPLEX_CONDITION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.condition.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.impl.AndImpl
	 * @see pamtram.condition.impl.ConditionPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__NAME = VARIADIC_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Cond Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__COND_PARTS = VARIADIC_CONDITION__COND_PARTS;

	/**
	 * The feature id for the '<em><b>Cond Parts Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__COND_PARTS_REF = VARIADIC_CONDITION__COND_PARTS_REF;

	/**
	 * The number of structural features of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = VARIADIC_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Local Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___IS_LOCAL_CONDITION = VARIADIC_CONDITION___IS_LOCAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Mapping Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___IS_MAPPING_CONDITION = VARIADIC_CONDITION___IS_MAPPING_CONDITION;

	/**
	 * The operation id for the '<em>Is Condition Model Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___IS_CONDITION_MODEL_CONDITION = VARIADIC_CONDITION___IS_CONDITION_MODEL_CONDITION;

	/**
	 * The operation id for the '<em>References Only Valid Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___REFERENCES_ONLY_VALID_CONDITIONS = VARIADIC_CONDITION___REFERENCES_ONLY_VALID_CONDITIONS;

	/**
	 * The operation id for the '<em>Minimal Number Of Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP = VARIADIC_CONDITION___MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATION_COUNT = VARIADIC_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.condition.impl.OrImpl <em>Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.impl.OrImpl
	 * @see pamtram.condition.impl.ConditionPackageImpl#getOr()
	 * @generated
	 */
	int OR = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__NAME = VARIADIC_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Cond Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__COND_PARTS = VARIADIC_CONDITION__COND_PARTS;

	/**
	 * The feature id for the '<em><b>Cond Parts Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__COND_PARTS_REF = VARIADIC_CONDITION__COND_PARTS_REF;

	/**
	 * The number of structural features of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = VARIADIC_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Local Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___IS_LOCAL_CONDITION = VARIADIC_CONDITION___IS_LOCAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Mapping Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___IS_MAPPING_CONDITION = VARIADIC_CONDITION___IS_MAPPING_CONDITION;

	/**
	 * The operation id for the '<em>Is Condition Model Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___IS_CONDITION_MODEL_CONDITION = VARIADIC_CONDITION___IS_CONDITION_MODEL_CONDITION;

	/**
	 * The operation id for the '<em>References Only Valid Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___REFERENCES_ONLY_VALID_CONDITIONS = VARIADIC_CONDITION___REFERENCES_ONLY_VALID_CONDITIONS;

	/**
	 * The operation id for the '<em>Minimal Number Of Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP = VARIADIC_CONDITION___MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATION_COUNT = VARIADIC_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.condition.impl.UnaryConditionImpl <em>Unary Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.impl.UnaryConditionImpl
	 * @see pamtram.condition.impl.ConditionPackageImpl#getUnaryCondition()
	 * @generated
	 */
	int UNARY_CONDITION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION__NAME = COMPLEX_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Cond Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION__COND_PART = COMPLEX_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cond Part Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION__COND_PART_REF = COMPLEX_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unary Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION_FEATURE_COUNT = COMPLEX_CONDITION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Local Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION___IS_LOCAL_CONDITION = COMPLEX_CONDITION___IS_LOCAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Mapping Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION___IS_MAPPING_CONDITION = COMPLEX_CONDITION___IS_MAPPING_CONDITION;

	/**
	 * The operation id for the '<em>Is Condition Model Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION___IS_CONDITION_MODEL_CONDITION = COMPLEX_CONDITION___IS_CONDITION_MODEL_CONDITION;

	/**
	 * The operation id for the '<em>Exactly One Arg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION___EXACTLY_ONE_ARG__DIAGNOSTICCHAIN_MAP = COMPLEX_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Unary Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION_OPERATION_COUNT = COMPLEX_CONDITION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.condition.impl.NotImpl <em>Not</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.impl.NotImpl
	 * @see pamtram.condition.impl.ConditionPackageImpl#getNot()
	 * @generated
	 */
	int NOT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__NAME = UNARY_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Cond Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__COND_PART = UNARY_CONDITION__COND_PART;

	/**
	 * The feature id for the '<em><b>Cond Part Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__COND_PART_REF = UNARY_CONDITION__COND_PART_REF;

	/**
	 * The number of structural features of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = UNARY_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Local Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___IS_LOCAL_CONDITION = UNARY_CONDITION___IS_LOCAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Mapping Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___IS_MAPPING_CONDITION = UNARY_CONDITION___IS_MAPPING_CONDITION;

	/**
	 * The operation id for the '<em>Is Condition Model Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___IS_CONDITION_MODEL_CONDITION = UNARY_CONDITION___IS_CONDITION_MODEL_CONDITION;

	/**
	 * The operation id for the '<em>Exactly One Arg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___EXACTLY_ONE_ARG__DIAGNOSTICCHAIN_MAP = UNARY_CONDITION___EXACTLY_ONE_ARG__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>References Only Valid Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___REFERENCES_ONLY_VALID_CONDITIONS = UNARY_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Reference Only Conditions From Condition Model Or From Conditional Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL_OR_FROM_CONDITIONAL_ELEMENTS__DIAGNOSTICCHAIN_MAP = UNARY_CONDITION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATION_COUNT = UNARY_CONDITION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.condition.impl.AttributeConditionImpl <em>Attribute Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.impl.AttributeConditionImpl
	 * @see pamtram.condition.impl.ConditionPackageImpl#getAttributeCondition()
	 * @generated
	 */
	int ATTRIBUTE_CONDITION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION__NAME = CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Additional Condition Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION__ADDITIONAL_CONDITION_SPECIFICATION = CONDITION__ADDITIONAL_CONDITION_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION__VALUE = CONDITION__VALUE;

	/**
	 * The feature id for the '<em><b>Comparator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION__COMPARATOR = CONDITION__COMPARATOR;

	/**
	 * The feature id for the '<em><b>Value Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION__VALUE_CONSTRAINT = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition Attribute Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION__CONDITION_ATTRIBUTE_REF = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Local Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION___IS_LOCAL_CONDITION = CONDITION___IS_LOCAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Mapping Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION___IS_MAPPING_CONDITION = CONDITION___IS_MAPPING_CONDITION;

	/**
	 * The operation id for the '<em>Is Condition Model Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION___IS_CONDITION_MODEL_CONDITION = CONDITION___IS_CONDITION_MODEL_CONDITION;

	/**
	 * The operation id for the '<em>Check Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION___CHECK_CONDITION__COMPLEXCONDITION = CONDITION___CHECK_CONDITION__COMPLEXCONDITION;

	/**
	 * The number of operations of the '<em>Attribute Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.condition.impl.CardinalityConditionImpl <em>Section Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.impl.CardinalityConditionImpl
	 * @see pamtram.condition.impl.ConditionPackageImpl#getCardinalityCondition()
	 * @generated
	 */
	int CARDINALITY_CONDITION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION__NAME = CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Additional Condition Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION__ADDITIONAL_CONDITION_SPECIFICATION = CONDITION__ADDITIONAL_CONDITION_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION__VALUE = CONDITION__VALUE;

	/**
	 * The feature id for the '<em><b>Comparator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION__COMPARATOR = CONDITION__COMPARATOR;

	/**
	 * The feature id for the '<em><b>Condition Section Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION__CONDITION_SECTION_REF = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Section Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Local Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION___IS_LOCAL_CONDITION = CONDITION___IS_LOCAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Mapping Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION___IS_MAPPING_CONDITION = CONDITION___IS_MAPPING_CONDITION;

	/**
	 * The operation id for the '<em>Is Condition Model Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION___IS_CONDITION_MODEL_CONDITION = CONDITION___IS_CONDITION_MODEL_CONDITION;

	/**
	 * The operation id for the '<em>Check Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION___CHECK_CONDITION__COMPLEXCONDITION = CONDITION___CHECK_CONDITION__COMPLEXCONDITION;

	/**
	 * The number of operations of the '<em>Section Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.condition.impl.ApplicationDependencyImpl <em>Application Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.impl.ApplicationDependencyImpl
	 * @see pamtram.condition.impl.ConditionPackageImpl#getApplicationDependency()
	 * @generated
	 */
	int APPLICATION_DEPENDENCY = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY__NAME = CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Additional Condition Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY__ADDITIONAL_CONDITION_SPECIFICATION = CONDITION__ADDITIONAL_CONDITION_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY__VALUE = CONDITION__VALUE;

	/**
	 * The feature id for the '<em><b>Comparator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY__COMPARATOR = CONDITION__COMPARATOR;

	/**
	 * The feature id for the '<em><b>Conditional Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY__CONDITIONAL_ELEMENT = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Application Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Local Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY___IS_LOCAL_CONDITION = CONDITION___IS_LOCAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Mapping Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY___IS_MAPPING_CONDITION = CONDITION___IS_MAPPING_CONDITION;

	/**
	 * The operation id for the '<em>Is Condition Model Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY___IS_CONDITION_MODEL_CONDITION = CONDITION___IS_CONDITION_MODEL_CONDITION;

	/**
	 * The operation id for the '<em>Check Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY___CHECK_CONDITION__COMPLEXCONDITION = CONDITION___CHECK_CONDITION__COMPLEXCONDITION;

	/**
	 * The number of operations of the '<em>Application Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.condition.ComparatorEnum <em>Comparator Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.ComparatorEnum
	 * @see pamtram.condition.impl.ConditionPackageImpl#getComparatorEnum()
	 * @generated
	 */
	int COMPARATOR_ENUM = 10;


	/**
	 * The meta object id for the '{@link pamtram.condition.CondSettingEnum <em>Cond Setting Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.CondSettingEnum
	 * @see pamtram.condition.impl.ConditionPackageImpl#getCondSettingEnum()
	 * @generated
	 */
	int COND_SETTING_ENUM = 11;


	/**
	 * Returns the meta object for class '{@link pamtram.condition.ComplexCondition <em>Complex Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Condition</em>'.
	 * @see pamtram.condition.ComplexCondition
	 * @generated
	 */
	EClass getComplexCondition();

	/**
	 * Returns the meta object for the '{@link pamtram.condition.ComplexCondition#isLocalCondition() <em>Is Local Condition</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Local Condition</em>' operation.
	 * @see pamtram.condition.ComplexCondition#isLocalCondition()
	 * @generated
	 */
	EOperation getComplexCondition__IsLocalCondition();

	/**
	 * Returns the meta object for the '{@link pamtram.condition.ComplexCondition#isMappingCondition() <em>Is Mapping Condition</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Mapping Condition</em>' operation.
	 * @see pamtram.condition.ComplexCondition#isMappingCondition()
	 * @generated
	 */
	EOperation getComplexCondition__IsMappingCondition();

	/**
	 * Returns the meta object for the '{@link pamtram.condition.ComplexCondition#isConditionModelCondition() <em>Is Condition Model Condition</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Condition Model Condition</em>' operation.
	 * @see pamtram.condition.ComplexCondition#isConditionModelCondition()
	 * @generated
	 */
	EOperation getComplexCondition__IsConditionModelCondition();

	/**
	 * Returns the meta object for class '{@link pamtram.condition.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see pamtram.condition.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.condition.Condition#getAdditionalConditionSpecification <em>Additional Condition Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Additional Condition Specification</em>'.
	 * @see pamtram.condition.Condition#getAdditionalConditionSpecification()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_AdditionalConditionSpecification();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.condition.Condition#getComparator <em>Comparator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comparator</em>'.
	 * @see pamtram.condition.Condition#getComparator()
	 * @see #getCondition()
	 * @generated
	 */
	EAttribute getCondition_Comparator();

	/**
	 * Returns the meta object for the '{@link pamtram.condition.Condition#checkCondition(pamtram.condition.ComplexCondition) <em>Check Condition</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Check Condition</em>' operation.
	 * @see pamtram.condition.Condition#checkCondition(pamtram.condition.ComplexCondition)
	 * @generated
	 */
	EOperation getCondition__CheckCondition__ComplexCondition();

	/**
	 * Returns the meta object for class '{@link pamtram.condition.VariadicCondition <em>Variadic Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variadic Condition</em>'.
	 * @see pamtram.condition.VariadicCondition
	 * @generated
	 */
	EClass getVariadicCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.condition.VariadicCondition#getCondParts <em>Cond Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cond Parts</em>'.
	 * @see pamtram.condition.VariadicCondition#getCondParts()
	 * @see #getVariadicCondition()
	 * @generated
	 */
	EReference getVariadicCondition_CondParts();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.condition.VariadicCondition#getCondPartsRef <em>Cond Parts Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Cond Parts Ref</em>'.
	 * @see pamtram.condition.VariadicCondition#getCondPartsRef()
	 * @see #getVariadicCondition()
	 * @generated
	 */
	EReference getVariadicCondition_CondPartsRef();

	/**
	 * Returns the meta object for the '{@link pamtram.condition.VariadicCondition#referencesOnlyValidConditions() <em>References Only Valid Conditions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>References Only Valid Conditions</em>' operation.
	 * @see pamtram.condition.VariadicCondition#referencesOnlyValidConditions()
	 * @generated
	 */
	EOperation getVariadicCondition__ReferencesOnlyValidConditions();

	/**
	 * Returns the meta object for the '{@link pamtram.condition.VariadicCondition#minimalNumberOfArgs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Minimal Number Of Args</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Minimal Number Of Args</em>' operation.
	 * @see pamtram.condition.VariadicCondition#minimalNumberOfArgs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getVariadicCondition__MinimalNumberOfArgs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.condition.Condition#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see pamtram.condition.Condition#getValue()
	 * @see #getCondition()
	 * @generated
	 */
	EAttribute getCondition_Value();

	/**
	 * Returns the meta object for class '{@link pamtram.condition.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And</em>'.
	 * @see pamtram.condition.And
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for class '{@link pamtram.condition.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or</em>'.
	 * @see pamtram.condition.Or
	 * @generated
	 */
	EClass getOr();

	/**
	 * Returns the meta object for class '{@link pamtram.condition.UnaryCondition <em>Unary Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Condition</em>'.
	 * @see pamtram.condition.UnaryCondition
	 * @generated
	 */
	EClass getUnaryCondition();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.condition.UnaryCondition#getCondPart <em>Cond Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cond Part</em>'.
	 * @see pamtram.condition.UnaryCondition#getCondPart()
	 * @see #getUnaryCondition()
	 * @generated
	 */
	EReference getUnaryCondition_CondPart();

	/**
	 * Returns the meta object for the reference '{@link pamtram.condition.UnaryCondition#getCondPartRef <em>Cond Part Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Cond Part Ref</em>'.
	 * @see pamtram.condition.UnaryCondition#getCondPartRef()
	 * @see #getUnaryCondition()
	 * @generated
	 */
	EReference getUnaryCondition_CondPartRef();

	/**
	 * Returns the meta object for the '{@link pamtram.condition.UnaryCondition#exactlyOneArg(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exactly One Arg</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Exactly One Arg</em>' operation.
	 * @see pamtram.condition.UnaryCondition#exactlyOneArg(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getUnaryCondition__ExactlyOneArg__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.condition.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not</em>'.
	 * @see pamtram.condition.Not
	 * @generated
	 */
	EClass getNot();

	/**
	 * Returns the meta object for the '{@link pamtram.condition.Not#referencesOnlyValidConditions() <em>References Only Valid Conditions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>References Only Valid Conditions</em>' operation.
	 * @see pamtram.condition.Not#referencesOnlyValidConditions()
	 * @generated
	 */
	EOperation getNot__ReferencesOnlyValidConditions();

	/**
	 * Returns the meta object for the '{@link pamtram.condition.Not#referenceOnlyConditionsFromConditionModelOrFromConditionalElements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Reference Only Conditions From Condition Model Or From Conditional Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Reference Only Conditions From Condition Model Or From Conditional Elements</em>' operation.
	 * @see pamtram.condition.Not#referenceOnlyConditionsFromConditionModelOrFromConditionalElements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getNot__ReferenceOnlyConditionsFromConditionModelOrFromConditionalElements__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.condition.AttributeCondition <em>Attribute Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Condition</em>'.
	 * @see pamtram.condition.AttributeCondition
	 * @generated
	 */
	EClass getAttributeCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.condition.AttributeCondition#getValueConstraint <em>Value Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value Constraint</em>'.
	 * @see pamtram.condition.AttributeCondition#getValueConstraint()
	 * @see #getAttributeCondition()
	 * @generated
	 */
	EReference getAttributeCondition_ValueConstraint();

	/**
	 * Returns the meta object for the reference '{@link pamtram.condition.AttributeCondition#getConditionAttributeRef <em>Condition Attribute Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition Attribute Ref</em>'.
	 * @see pamtram.condition.AttributeCondition#getConditionAttributeRef()
	 * @see #getAttributeCondition()
	 * @generated
	 */
	EReference getAttributeCondition_ConditionAttributeRef();

	/**
	 * Returns the meta object for class '{@link pamtram.condition.CardinalityCondition <em>Section Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Condition</em>'.
	 * @see pamtram.condition.CardinalityCondition
	 * @generated
	 */
	EClass getCardinalityCondition();

	/**
	 * Returns the meta object for the reference '{@link pamtram.condition.CardinalityCondition#getConditionSectionRef <em>Condition Section Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition Section Ref</em>'.
	 * @see pamtram.condition.CardinalityCondition#getConditionSectionRef()
	 * @see #getCardinalityCondition()
	 * @generated
	 */
	EReference getCardinalityCondition_ConditionSectionRef();

	/**
	 * Returns the meta object for class '{@link pamtram.condition.ApplicationDependency <em>Application Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Dependency</em>'.
	 * @see pamtram.condition.ApplicationDependency
	 * @generated
	 */
	EClass getApplicationDependency();

	/**
	 * Returns the meta object for the reference '{@link pamtram.condition.ApplicationDependency#getConditionalElement <em>Conditional Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Conditional Element</em>'.
	 * @see pamtram.condition.ApplicationDependency#getConditionalElement()
	 * @see #getApplicationDependency()
	 * @generated
	 */
	EReference getApplicationDependency_ConditionalElement();

	/**
	 * Returns the meta object for enum '{@link pamtram.condition.ComparatorEnum <em>Comparator Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Comparator Enum</em>'.
	 * @see pamtram.condition.ComparatorEnum
	 * @generated
	 */
	EEnum getComparatorEnum();

	/**
	 * Returns the meta object for enum '{@link pamtram.condition.CondSettingEnum <em>Cond Setting Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cond Setting Enum</em>'.
	 * @see pamtram.condition.CondSettingEnum
	 * @generated
	 */
	EEnum getCondSettingEnum();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConditionFactory getConditionFactory();

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
		 * The meta object literal for the '{@link pamtram.condition.impl.ComplexConditionImpl <em>Complex Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.condition.impl.ComplexConditionImpl
		 * @see pamtram.condition.impl.ConditionPackageImpl#getComplexCondition()
		 * @generated
		 */
		EClass COMPLEX_CONDITION = eINSTANCE.getComplexCondition();

		/**
		 * The meta object literal for the '<em><b>Is Local Condition</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLEX_CONDITION___IS_LOCAL_CONDITION = eINSTANCE.getComplexCondition__IsLocalCondition();

		/**
		 * The meta object literal for the '<em><b>Is Mapping Condition</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLEX_CONDITION___IS_MAPPING_CONDITION = eINSTANCE.getComplexCondition__IsMappingCondition();

		/**
		 * The meta object literal for the '<em><b>Is Condition Model Condition</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLEX_CONDITION___IS_CONDITION_MODEL_CONDITION = eINSTANCE.getComplexCondition__IsConditionModelCondition();

		/**
		 * The meta object literal for the '{@link pamtram.condition.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.condition.impl.ConditionImpl
		 * @see pamtram.condition.impl.ConditionPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '<em><b>Additional Condition Specification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__ADDITIONAL_CONDITION_SPECIFICATION = eINSTANCE.getCondition_AdditionalConditionSpecification();

		/**
		 * The meta object literal for the '<em><b>Comparator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION__COMPARATOR = eINSTANCE.getCondition_Comparator();

		/**
		 * The meta object literal for the '<em><b>Check Condition</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONDITION___CHECK_CONDITION__COMPLEXCONDITION = eINSTANCE.getCondition__CheckCondition__ComplexCondition();

		/**
		 * The meta object literal for the '{@link pamtram.condition.impl.VariadicConditionImpl <em>Variadic Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.condition.impl.VariadicConditionImpl
		 * @see pamtram.condition.impl.ConditionPackageImpl#getVariadicCondition()
		 * @generated
		 */
		EClass VARIADIC_CONDITION = eINSTANCE.getVariadicCondition();

		/**
		 * The meta object literal for the '<em><b>Cond Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIADIC_CONDITION__COND_PARTS = eINSTANCE.getVariadicCondition_CondParts();

		/**
		 * The meta object literal for the '<em><b>Cond Parts Ref</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIADIC_CONDITION__COND_PARTS_REF = eINSTANCE.getVariadicCondition_CondPartsRef();

		/**
		 * The meta object literal for the '<em><b>References Only Valid Conditions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIADIC_CONDITION___REFERENCES_ONLY_VALID_CONDITIONS = eINSTANCE.getVariadicCondition__ReferencesOnlyValidConditions();

		/**
		 * The meta object literal for the '<em><b>Minimal Number Of Args</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIADIC_CONDITION___MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getVariadicCondition__MinimalNumberOfArgs__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION__VALUE = eINSTANCE.getCondition_Value();

		/**
		 * The meta object literal for the '{@link pamtram.condition.impl.AndImpl <em>And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.condition.impl.AndImpl
		 * @see pamtram.condition.impl.ConditionPackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '{@link pamtram.condition.impl.OrImpl <em>Or</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.condition.impl.OrImpl
		 * @see pamtram.condition.impl.ConditionPackageImpl#getOr()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOr();

		/**
		 * The meta object literal for the '{@link pamtram.condition.impl.UnaryConditionImpl <em>Unary Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.condition.impl.UnaryConditionImpl
		 * @see pamtram.condition.impl.ConditionPackageImpl#getUnaryCondition()
		 * @generated
		 */
		EClass UNARY_CONDITION = eINSTANCE.getUnaryCondition();

		/**
		 * The meta object literal for the '<em><b>Cond Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_CONDITION__COND_PART = eINSTANCE.getUnaryCondition_CondPart();

		/**
		 * The meta object literal for the '<em><b>Cond Part Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_CONDITION__COND_PART_REF = eINSTANCE.getUnaryCondition_CondPartRef();

		/**
		 * The meta object literal for the '<em><b>Exactly One Arg</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNARY_CONDITION___EXACTLY_ONE_ARG__DIAGNOSTICCHAIN_MAP = eINSTANCE.getUnaryCondition__ExactlyOneArg__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.condition.impl.NotImpl <em>Not</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.condition.impl.NotImpl
		 * @see pamtram.condition.impl.ConditionPackageImpl#getNot()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNot();

		/**
		 * The meta object literal for the '<em><b>References Only Valid Conditions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NOT___REFERENCES_ONLY_VALID_CONDITIONS = eINSTANCE.getNot__ReferencesOnlyValidConditions();

		/**
		 * The meta object literal for the '<em><b>Reference Only Conditions From Condition Model Or From Conditional Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NOT___REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL_OR_FROM_CONDITIONAL_ELEMENTS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getNot__ReferenceOnlyConditionsFromConditionModelOrFromConditionalElements__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.condition.impl.AttributeConditionImpl <em>Attribute Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.condition.impl.AttributeConditionImpl
		 * @see pamtram.condition.impl.ConditionPackageImpl#getAttributeCondition()
		 * @generated
		 */
		EClass ATTRIBUTE_CONDITION = eINSTANCE.getAttributeCondition();

		/**
		 * The meta object literal for the '<em><b>Value Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_CONDITION__VALUE_CONSTRAINT = eINSTANCE.getAttributeCondition_ValueConstraint();

		/**
		 * The meta object literal for the '<em><b>Condition Attribute Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_CONDITION__CONDITION_ATTRIBUTE_REF = eINSTANCE.getAttributeCondition_ConditionAttributeRef();

		/**
		 * The meta object literal for the '{@link pamtram.condition.impl.CardinalityConditionImpl <em>Section Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.condition.impl.CardinalityConditionImpl
		 * @see pamtram.condition.impl.ConditionPackageImpl#getCardinalityCondition()
		 * @generated
		 */
		EClass CARDINALITY_CONDITION = eINSTANCE.getCardinalityCondition();

		/**
		 * The meta object literal for the '<em><b>Condition Section Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CARDINALITY_CONDITION__CONDITION_SECTION_REF = eINSTANCE.getCardinalityCondition_ConditionSectionRef();

		/**
		 * The meta object literal for the '{@link pamtram.condition.impl.ApplicationDependencyImpl <em>Application Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.condition.impl.ApplicationDependencyImpl
		 * @see pamtram.condition.impl.ConditionPackageImpl#getApplicationDependency()
		 * @generated
		 */
		EClass APPLICATION_DEPENDENCY = eINSTANCE.getApplicationDependency();

		/**
		 * The meta object literal for the '<em><b>Conditional Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_DEPENDENCY__CONDITIONAL_ELEMENT = eINSTANCE.getApplicationDependency_ConditionalElement();

		/**
		 * The meta object literal for the '{@link pamtram.condition.ComparatorEnum <em>Comparator Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.condition.ComparatorEnum
		 * @see pamtram.condition.impl.ConditionPackageImpl#getComparatorEnum()
		 * @generated
		 */
		EEnum COMPARATOR_ENUM = eINSTANCE.getComparatorEnum();

		/**
		 * The meta object literal for the '{@link pamtram.condition.CondSettingEnum <em>Cond Setting Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.condition.CondSettingEnum
		 * @see pamtram.condition.impl.ConditionPackageImpl#getCondSettingEnum()
		 * @generated
		 */
		EEnum COND_SETTING_ENUM = eINSTANCE.getCondSettingEnum();

	}

} //ConditionPackage
