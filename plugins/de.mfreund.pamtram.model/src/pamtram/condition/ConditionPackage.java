/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
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
 * <!-- begin-model-doc -->
 * This package contains all elements related to the description of Conditions. These can e.g. be used to restrict the applicability of a Mapping.
 * <!-- end-model-doc -->
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
	 * The operation id for the '<em>Is External Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CONDITION___IS_EXTERNAL_CONDITION = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Global Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CONDITION___IS_GLOBAL_CONDITION = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Mapping Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CONDITION___IS_MAPPING_CONDITION = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Condition Model Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CONDITION___IS_CONDITION_MODEL_CONDITION = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Condition Parts Flat</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CONDITION___GET_CONDITION_PARTS_FLAT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>Complex Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CONDITION_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link pamtram.condition.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.impl.ConditionImpl
	 * @see pamtram.condition.impl.ConditionPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 6;

	/**
	 * The meta object id for the '{@link pamtram.condition.impl.VariadicConditionImpl <em>Variadic Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.impl.VariadicConditionImpl
	 * @see pamtram.condition.impl.ConditionPackageImpl#getVariadicCondition()
	 * @generated
	 */
	int VARIADIC_CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION__NAME = COMPLEX_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Local Cond Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION__LOCAL_COND_PARTS = COMPLEX_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Cond Parts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION__SHARED_COND_PARTS = COMPLEX_CONDITION_FEATURE_COUNT + 1;

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
	 * The operation id for the '<em>Is External Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION___IS_EXTERNAL_CONDITION = COMPLEX_CONDITION___IS_EXTERNAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Global Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION___IS_GLOBAL_CONDITION = COMPLEX_CONDITION___IS_GLOBAL_CONDITION;

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
	 * The operation id for the '<em>Get Condition Parts Flat</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION___GET_CONDITION_PARTS_FLAT = COMPLEX_CONDITION___GET_CONDITION_PARTS_FLAT;

	/**
	 * The operation id for the '<em>References Only Valid Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION___REFERENCES_ONLY_VALID_CONDITIONS = COMPLEX_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Minimal Number Of Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION___VALIDATE_MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP = COMPLEX_CONDITION_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = COMPLEX_CONDITION_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Variadic Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIADIC_CONDITION_OPERATION_COUNT = COMPLEX_CONDITION_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link pamtram.condition.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.impl.AndImpl
	 * @see pamtram.condition.impl.ConditionPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__NAME = VARIADIC_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Local Cond Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__LOCAL_COND_PARTS = VARIADIC_CONDITION__LOCAL_COND_PARTS;

	/**
	 * The feature id for the '<em><b>Shared Cond Parts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__SHARED_COND_PARTS = VARIADIC_CONDITION__SHARED_COND_PARTS;

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
	 * The operation id for the '<em>Is External Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___IS_EXTERNAL_CONDITION = VARIADIC_CONDITION___IS_EXTERNAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Global Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___IS_GLOBAL_CONDITION = VARIADIC_CONDITION___IS_GLOBAL_CONDITION;

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
	 * The operation id for the '<em>Get Condition Parts Flat</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___GET_CONDITION_PARTS_FLAT = VARIADIC_CONDITION___GET_CONDITION_PARTS_FLAT;

	/**
	 * The operation id for the '<em>References Only Valid Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___REFERENCES_ONLY_VALID_CONDITIONS = VARIADIC_CONDITION___REFERENCES_ONLY_VALID_CONDITIONS;

	/**
	 * The operation id for the '<em>Validate Minimal Number Of Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___VALIDATE_MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP = VARIADIC_CONDITION___VALIDATE_MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = VARIADIC_CONDITION___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

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
	int OR = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__NAME = VARIADIC_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Local Cond Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__LOCAL_COND_PARTS = VARIADIC_CONDITION__LOCAL_COND_PARTS;

	/**
	 * The feature id for the '<em><b>Shared Cond Parts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__SHARED_COND_PARTS = VARIADIC_CONDITION__SHARED_COND_PARTS;

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
	 * The operation id for the '<em>Is External Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___IS_EXTERNAL_CONDITION = VARIADIC_CONDITION___IS_EXTERNAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Global Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___IS_GLOBAL_CONDITION = VARIADIC_CONDITION___IS_GLOBAL_CONDITION;

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
	 * The operation id for the '<em>Get Condition Parts Flat</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___GET_CONDITION_PARTS_FLAT = VARIADIC_CONDITION___GET_CONDITION_PARTS_FLAT;

	/**
	 * The operation id for the '<em>References Only Valid Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___REFERENCES_ONLY_VALID_CONDITIONS = VARIADIC_CONDITION___REFERENCES_ONLY_VALID_CONDITIONS;

	/**
	 * The operation id for the '<em>Validate Minimal Number Of Args</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___VALIDATE_MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP = VARIADIC_CONDITION___VALIDATE_MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = VARIADIC_CONDITION___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

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
	int UNARY_CONDITION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION__NAME = COMPLEX_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Local Cond Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION__LOCAL_COND_PART = COMPLEX_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Cond Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION__SHARED_COND_PART = COMPLEX_CONDITION_FEATURE_COUNT + 1;

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
	 * The operation id for the '<em>Is External Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION___IS_EXTERNAL_CONDITION = COMPLEX_CONDITION___IS_EXTERNAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Global Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION___IS_GLOBAL_CONDITION = COMPLEX_CONDITION___IS_GLOBAL_CONDITION;

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
	 * The operation id for the '<em>Get Condition Parts Flat</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION___GET_CONDITION_PARTS_FLAT = COMPLEX_CONDITION___GET_CONDITION_PARTS_FLAT;

	/**
	 * The operation id for the '<em>Validate Exactly One Arg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION___VALIDATE_EXACTLY_ONE_ARG__DIAGNOSTICCHAIN_MAP = COMPLEX_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = COMPLEX_CONDITION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unary Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION_OPERATION_COUNT = COMPLEX_CONDITION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.condition.impl.NotImpl <em>Not</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.condition.impl.NotImpl
	 * @see pamtram.condition.impl.ConditionPackageImpl#getNot()
	 * @generated
	 */
	int NOT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__NAME = UNARY_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Local Cond Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__LOCAL_COND_PART = UNARY_CONDITION__LOCAL_COND_PART;

	/**
	 * The feature id for the '<em><b>Shared Cond Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__SHARED_COND_PART = UNARY_CONDITION__SHARED_COND_PART;

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
	 * The operation id for the '<em>Is External Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___IS_EXTERNAL_CONDITION = UNARY_CONDITION___IS_EXTERNAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Global Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___IS_GLOBAL_CONDITION = UNARY_CONDITION___IS_GLOBAL_CONDITION;

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
	 * The operation id for the '<em>Get Condition Parts Flat</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___GET_CONDITION_PARTS_FLAT = UNARY_CONDITION___GET_CONDITION_PARTS_FLAT;

	/**
	 * The operation id for the '<em>Validate Exactly One Arg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___VALIDATE_EXACTLY_ONE_ARG__DIAGNOSTICCHAIN_MAP = UNARY_CONDITION___VALIDATE_EXACTLY_ONE_ARG__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = UNARY_CONDITION___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATION_COUNT = UNARY_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__NAME = COMPLEX_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__VALUE = COMPLEX_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comparator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__COMPARATOR = COMPLEX_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__TARGET = COMPLEX_CONDITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__INSTANCE_SELECTORS = COMPLEX_CONDITION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = COMPLEX_CONDITION_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Local Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION___IS_LOCAL_CONDITION = COMPLEX_CONDITION___IS_LOCAL_CONDITION;

	/**
	 * The operation id for the '<em>Is External Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION___IS_EXTERNAL_CONDITION = COMPLEX_CONDITION___IS_EXTERNAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Global Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION___IS_GLOBAL_CONDITION = COMPLEX_CONDITION___IS_GLOBAL_CONDITION;

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
	 * The operation id for the '<em>Get Condition Parts Flat</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION___GET_CONDITION_PARTS_FLAT = COMPLEX_CONDITION___GET_CONDITION_PARTS_FLAT;

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
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION__TARGET = CONDITION__TARGET;

	/**
	 * The feature id for the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION__INSTANCE_SELECTORS = CONDITION__INSTANCE_SELECTORS;

	/**
	 * The feature id for the '<em><b>Reference Match Spec</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION__REFERENCE_MATCH_SPEC = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Follow External References</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION__FOLLOW_EXTERNAL_REFERENCES = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS = CONDITION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Attribute Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Local Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION___IS_LOCAL_CONDITION = CONDITION___IS_LOCAL_CONDITION;

	/**
	 * The operation id for the '<em>Is External Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION___IS_EXTERNAL_CONDITION = CONDITION___IS_EXTERNAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Global Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION___IS_GLOBAL_CONDITION = CONDITION___IS_GLOBAL_CONDITION;

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
	 * The operation id for the '<em>Get Condition Parts Flat</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION___GET_CONDITION_PARTS_FLAT = CONDITION___GET_CONDITION_PARTS_FLAT;

	/**
	 * The operation id for the '<em>Check Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION___CHECK_CONDITION__COMPLEXCONDITION = CONDITION___CHECK_CONDITION__COMPLEXCONDITION;

	/**
	 * The operation id for the '<em>Validate Follow External References True If Required</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION___VALIDATE_FOLLOW_EXTERNAL_REFERENCES_TRUE_IF_REQUIRED__DIAGNOSTICCHAIN_MAP = CONDITION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CONDITION_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.condition.impl.CardinalityConditionImpl <em>Cardinality Condition</em>}' class.
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
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION__TARGET = CONDITION__TARGET;

	/**
	 * The feature id for the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION__INSTANCE_SELECTORS = CONDITION__INSTANCE_SELECTORS;

	/**
	 * The feature id for the '<em><b>Reference Match Spec</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION__REFERENCE_MATCH_SPEC = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Follow External References</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION__FOLLOW_EXTERNAL_REFERENCES = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cardinality Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Local Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION___IS_LOCAL_CONDITION = CONDITION___IS_LOCAL_CONDITION;

	/**
	 * The operation id for the '<em>Is External Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION___IS_EXTERNAL_CONDITION = CONDITION___IS_EXTERNAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Global Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION___IS_GLOBAL_CONDITION = CONDITION___IS_GLOBAL_CONDITION;

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
	 * The operation id for the '<em>Get Condition Parts Flat</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION___GET_CONDITION_PARTS_FLAT = CONDITION___GET_CONDITION_PARTS_FLAT;

	/**
	 * The operation id for the '<em>Check Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION___CHECK_CONDITION__COMPLEXCONDITION = CONDITION___CHECK_CONDITION__COMPLEXCONDITION;

	/**
	 * The operation id for the '<em>Validate Reference Match Spec Present In Case Of Ambiguous Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION___VALIDATE_REFERENCE_MATCH_SPEC_PRESENT_IN_CASE_OF_AMBIGUOUS_SOURCE__DIAGNOSTICCHAIN_MAP = CONDITION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cardinality Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_CONDITION_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 1;

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
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY__TARGET = CONDITION__TARGET;

	/**
	 * The feature id for the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY__INSTANCE_SELECTORS = CONDITION__INSTANCE_SELECTORS;

	/**
	 * The number of structural features of the '<em>Application Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Local Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY___IS_LOCAL_CONDITION = CONDITION___IS_LOCAL_CONDITION;

	/**
	 * The operation id for the '<em>Is External Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY___IS_EXTERNAL_CONDITION = CONDITION___IS_EXTERNAL_CONDITION;

	/**
	 * The operation id for the '<em>Is Global Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY___IS_GLOBAL_CONDITION = CONDITION___IS_GLOBAL_CONDITION;

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
	 * The operation id for the '<em>Get Condition Parts Flat</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDENCY___GET_CONDITION_PARTS_FLAT = CONDITION___GET_CONDITION_PARTS_FLAT;

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
	 * Returns the meta object for the '{@link pamtram.condition.ComplexCondition#isExternalCondition() <em>Is External Condition</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is External Condition</em>' operation.
	 * @see pamtram.condition.ComplexCondition#isExternalCondition()
	 * @generated
	 */
	EOperation getComplexCondition__IsExternalCondition();

	/**
	 * Returns the meta object for the '{@link pamtram.condition.ComplexCondition#isGlobalCondition() <em>Is Global Condition</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Global Condition</em>' operation.
	 * @see pamtram.condition.ComplexCondition#isGlobalCondition()
	 * @generated
	 */
	EOperation getComplexCondition__IsGlobalCondition();

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
	 * Returns the meta object for the '{@link pamtram.condition.ComplexCondition#getConditionPartsFlat() <em>Get Condition Parts Flat</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Condition Parts Flat</em>' operation.
	 * @see pamtram.condition.ComplexCondition#getConditionPartsFlat()
	 * @generated
	 */
	EOperation getComplexCondition__GetConditionPartsFlat();

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
	 * Returns the meta object for the reference '{@link pamtram.condition.Condition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see pamtram.condition.Condition#getTarget()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.condition.Condition#getInstanceSelectors <em>Instance Selectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instance Selectors</em>'.
	 * @see pamtram.condition.Condition#getInstanceSelectors()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_InstanceSelectors();

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
	 * Returns the meta object for the containment reference list '{@link pamtram.condition.VariadicCondition#getLocalCondParts <em>Local Cond Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local Cond Parts</em>'.
	 * @see pamtram.condition.VariadicCondition#getLocalCondParts()
	 * @see #getVariadicCondition()
	 * @generated
	 */
	EReference getVariadicCondition_LocalCondParts();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.condition.VariadicCondition#getSharedCondParts <em>Shared Cond Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Shared Cond Parts</em>'.
	 * @see pamtram.condition.VariadicCondition#getSharedCondParts()
	 * @see #getVariadicCondition()
	 * @generated
	 */
	EReference getVariadicCondition_SharedCondParts();

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
	 * Returns the meta object for the '{@link pamtram.condition.VariadicCondition#validateMinimalNumberOfArgs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Minimal Number Of Args</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Minimal Number Of Args</em>' operation.
	 * @see pamtram.condition.VariadicCondition#validateMinimalNumberOfArgs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getVariadicCondition__ValidateMinimalNumberOfArgs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.condition.VariadicCondition#validateReferenceOnlyConditionsFromConditionModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Reference Only Conditions From Condition Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * @see pamtram.condition.VariadicCondition#validateReferenceOnlyConditionsFromConditionModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getVariadicCondition__ValidateReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map();

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
	 * Returns the meta object for the containment reference '{@link pamtram.condition.UnaryCondition#getLocalCondPart <em>Local Cond Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Local Cond Part</em>'.
	 * @see pamtram.condition.UnaryCondition#getLocalCondPart()
	 * @see #getUnaryCondition()
	 * @generated
	 */
	EReference getUnaryCondition_LocalCondPart();

	/**
	 * Returns the meta object for the reference '{@link pamtram.condition.UnaryCondition#getSharedCondPart <em>Shared Cond Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Shared Cond Part</em>'.
	 * @see pamtram.condition.UnaryCondition#getSharedCondPart()
	 * @see #getUnaryCondition()
	 * @generated
	 */
	EReference getUnaryCondition_SharedCondPart();

	/**
	 * Returns the meta object for the '{@link pamtram.condition.UnaryCondition#validateExactlyOneArg(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Exactly One Arg</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Exactly One Arg</em>' operation.
	 * @see pamtram.condition.UnaryCondition#validateExactlyOneArg(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getUnaryCondition__ValidateExactlyOneArg__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.condition.UnaryCondition#validateReferenceOnlyConditionsFromConditionModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Reference Only Conditions From Condition Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * @see pamtram.condition.UnaryCondition#validateReferenceOnlyConditionsFromConditionModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getUnaryCondition__ValidateReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map();

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
	 * Returns the meta object for class '{@link pamtram.condition.AttributeCondition <em>Attribute Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Condition</em>'.
	 * @see pamtram.condition.AttributeCondition
	 * @generated
	 */
	EClass getAttributeCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.condition.AttributeCondition#getValueConstraints <em>Value Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value Constraints</em>'.
	 * @see pamtram.condition.AttributeCondition#getValueConstraints()
	 * @see #getAttributeCondition()
	 * @generated
	 */
	EReference getAttributeCondition_ValueConstraints();

	/**
	 * Returns the meta object for the '{@link pamtram.condition.AttributeCondition#validateFollowExternalReferencesTrueIfRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Follow External References True If Required</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Follow External References True If Required</em>' operation.
	 * @see pamtram.condition.AttributeCondition#validateFollowExternalReferencesTrueIfRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getAttributeCondition__ValidateFollowExternalReferencesTrueIfRequired__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.condition.CardinalityCondition <em>Cardinality Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cardinality Condition</em>'.
	 * @see pamtram.condition.CardinalityCondition
	 * @generated
	 */
	EClass getCardinalityCondition();

	/**
	 * Returns the meta object for the '{@link pamtram.condition.CardinalityCondition#validateReferenceMatchSpecPresentInCaseOfAmbiguousSource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Reference Match Spec Present In Case Of Ambiguous Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Reference Match Spec Present In Case Of Ambiguous Source</em>' operation.
	 * @see pamtram.condition.CardinalityCondition#validateReferenceMatchSpecPresentInCaseOfAmbiguousSource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCardinalityCondition__ValidateReferenceMatchSpecPresentInCaseOfAmbiguousSource__DiagnosticChain_Map();

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
	 * Returns the meta object for enum '{@link pamtram.condition.ComparatorEnum <em>Comparator Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Comparator Enum</em>'.
	 * @see pamtram.condition.ComparatorEnum
	 * @generated
	 */
	EEnum getComparatorEnum();

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
		 * The meta object literal for the '<em><b>Is External Condition</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLEX_CONDITION___IS_EXTERNAL_CONDITION = eINSTANCE.getComplexCondition__IsExternalCondition();

		/**
		 * The meta object literal for the '<em><b>Is Global Condition</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLEX_CONDITION___IS_GLOBAL_CONDITION = eINSTANCE.getComplexCondition__IsGlobalCondition();

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
		 * The meta object literal for the '<em><b>Get Condition Parts Flat</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLEX_CONDITION___GET_CONDITION_PARTS_FLAT = eINSTANCE.getComplexCondition__GetConditionPartsFlat();

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
		 * The meta object literal for the '<em><b>Comparator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION__COMPARATOR = eINSTANCE.getCondition_Comparator();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__TARGET = eINSTANCE.getCondition_Target();

		/**
		 * The meta object literal for the '<em><b>Instance Selectors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__INSTANCE_SELECTORS = eINSTANCE.getCondition_InstanceSelectors();

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
		 * The meta object literal for the '<em><b>Local Cond Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIADIC_CONDITION__LOCAL_COND_PARTS = eINSTANCE.getVariadicCondition_LocalCondParts();

		/**
		 * The meta object literal for the '<em><b>Shared Cond Parts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIADIC_CONDITION__SHARED_COND_PARTS = eINSTANCE.getVariadicCondition_SharedCondParts();

		/**
		 * The meta object literal for the '<em><b>References Only Valid Conditions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIADIC_CONDITION___REFERENCES_ONLY_VALID_CONDITIONS = eINSTANCE.getVariadicCondition__ReferencesOnlyValidConditions();

		/**
		 * The meta object literal for the '<em><b>Validate Minimal Number Of Args</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIADIC_CONDITION___VALIDATE_MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getVariadicCondition__ValidateMinimalNumberOfArgs__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Reference Only Conditions From Condition Model</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIADIC_CONDITION___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getVariadicCondition__ValidateReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map();

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
		 * The meta object literal for the '<em><b>Local Cond Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_CONDITION__LOCAL_COND_PART = eINSTANCE.getUnaryCondition_LocalCondPart();

		/**
		 * The meta object literal for the '<em><b>Shared Cond Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_CONDITION__SHARED_COND_PART = eINSTANCE.getUnaryCondition_SharedCondPart();

		/**
		 * The meta object literal for the '<em><b>Validate Exactly One Arg</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNARY_CONDITION___VALIDATE_EXACTLY_ONE_ARG__DIAGNOSTICCHAIN_MAP = eINSTANCE.getUnaryCondition__ValidateExactlyOneArg__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Reference Only Conditions From Condition Model</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNARY_CONDITION___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getUnaryCondition__ValidateReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map();

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
		 * The meta object literal for the '{@link pamtram.condition.impl.AttributeConditionImpl <em>Attribute Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.condition.impl.AttributeConditionImpl
		 * @see pamtram.condition.impl.ConditionPackageImpl#getAttributeCondition()
		 * @generated
		 */
		EClass ATTRIBUTE_CONDITION = eINSTANCE.getAttributeCondition();

		/**
		 * The meta object literal for the '<em><b>Value Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS = eINSTANCE.getAttributeCondition_ValueConstraints();

		/**
		 * The meta object literal for the '<em><b>Validate Follow External References True If Required</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CONDITION___VALIDATE_FOLLOW_EXTERNAL_REFERENCES_TRUE_IF_REQUIRED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getAttributeCondition__ValidateFollowExternalReferencesTrueIfRequired__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.condition.impl.CardinalityConditionImpl <em>Cardinality Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.condition.impl.CardinalityConditionImpl
		 * @see pamtram.condition.impl.ConditionPackageImpl#getCardinalityCondition()
		 * @generated
		 */
		EClass CARDINALITY_CONDITION = eINSTANCE.getCardinalityCondition();

		/**
		 * The meta object literal for the '<em><b>Validate Reference Match Spec Present In Case Of Ambiguous Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CARDINALITY_CONDITION___VALIDATE_REFERENCE_MATCH_SPEC_PRESENT_IN_CASE_OF_AMBIGUOUS_SOURCE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCardinalityCondition__ValidateReferenceMatchSpecPresentInCaseOfAmbiguousSource__DiagnosticChain_Map();

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
		 * The meta object literal for the '{@link pamtram.condition.ComparatorEnum <em>Comparator Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.condition.ComparatorEnum
		 * @see pamtram.condition.impl.ConditionPackageImpl#getComparatorEnum()
		 * @generated
		 */
		EEnum COMPARATOR_ENUM = eINSTANCE.getComparatorEnum();

	}

} //ConditionPackage
