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
package pamtram.structure;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import pamtram.PamtramPackage;
import pamtram.mapping.extended.ExtendedPackage;

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
 * Main package of the PAMTraM (Persistent Ambiguous Mapping and Transformation Model) meta-model containing various structuring and general elements.
 * <!-- end-model-doc -->
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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR__EXPRESSION = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR__MODIFIERS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR__SOURCE_ELEMENTS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Instance Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate No Modified Attribute Element Types In Condition Model Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Local Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get External Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Instance Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 3;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_INSTANCE_SELECTOR__NAME = INSTANCE_SELECTOR__NAME;

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
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_INSTANCE_SELECTOR__SOURCE_ELEMENTS = INSTANCE_SELECTOR__SOURCE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Reference Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE = INSTANCE_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_INSTANCE_SELECTOR__TARGET_CLASS = INSTANCE_SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Source Instance Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_INSTANCE_SELECTOR_FEATURE_COUNT = INSTANCE_SELECTOR_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate No Modified Attribute Element Types In Condition Model Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_INSTANCE_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP = INSTANCE_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Local Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_INSTANCE_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS = INSTANCE_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS;

	/**
	 * The operation id for the '<em>Get External Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_INSTANCE_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS = INSTANCE_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR__NAME = INSTANCE_SELECTOR__NAME;

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
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR__SOURCE_ELEMENTS = INSTANCE_SELECTOR__SOURCE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Reference Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE = INSTANCE_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR__TARGET_CLASS = INSTANCE_SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Target Instance Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR_FEATURE_COUNT = INSTANCE_SELECTOR_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate No Modified Attribute Element Types In Condition Model Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP = INSTANCE_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Local Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS = INSTANCE_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS;

	/**
	 * The operation id for the '<em>Get External Source Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS = INSTANCE_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS;

	/**
	 * The operation id for the '<em>Validate Reference Attribute Is Valid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR___VALIDATE_REFERENCE_ATTRIBUTE_IS_VALID__DIAGNOSTICCHAIN_MAP = INSTANCE_SELECTOR_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Target Instance Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_INSTANCE_SELECTOR_OPERATION_COUNT = INSTANCE_SELECTOR_OPERATION_COUNT + 1;

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
	int INSTANCE_SELECTOR_SOURCE_INTERFACE__NAME = ExtendedPackage.MAPPING_HINT_SOURCE_INTERFACE__NAME;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_INTERFACE__LOCAL_CONDITION = ExtendedPackage.MAPPING_HINT_SOURCE_INTERFACE__LOCAL_CONDITION;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_INTERFACE__SHARED_CONDITION = ExtendedPackage.MAPPING_HINT_SOURCE_INTERFACE__SHARED_CONDITION;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_INTERFACE__ALL_CONDITIONS = ExtendedPackage.MAPPING_HINT_SOURCE_INTERFACE__ALL_CONDITIONS;

	/**
	 * The number of structural features of the '<em>Instance Selector Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_INTERFACE_FEATURE_COUNT = ExtendedPackage.MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_INTERFACE___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = ExtendedPackage.MAPPING_HINT_SOURCE_INTERFACE___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Instance Selector Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_INTERFACE_OPERATION_COUNT = ExtendedPackage.MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.DynamicSourceElementImpl <em>Dynamic Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.DynamicSourceElementImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getDynamicSourceElement()
	 * @generated
	 */
	int DYNAMIC_SOURCE_ELEMENT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_SOURCE_ELEMENT__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_SOURCE_ELEMENT__MODIFIERS = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_SOURCE_ELEMENT__SOURCE = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Dynamic Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_SOURCE_ELEMENT___GET_MAPPING = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dynamic Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.LocalDynamicSourceElementImpl <em>Local Dynamic Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.LocalDynamicSourceElementImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getLocalDynamicSourceElement()
	 * @generated
	 */
	int LOCAL_DYNAMIC_SOURCE_ELEMENT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_DYNAMIC_SOURCE_ELEMENT__NAME = DYNAMIC_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_DYNAMIC_SOURCE_ELEMENT__MODIFIERS = DYNAMIC_SOURCE_ELEMENT__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_DYNAMIC_SOURCE_ELEMENT__SOURCE = DYNAMIC_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID = DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Reference Match Spec</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC = DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Follow External References</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_DYNAMIC_SOURCE_ELEMENT__FOLLOW_EXTERNAL_REFERENCES = DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Local Dynamic Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT = DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING = DYNAMIC_SOURCE_ELEMENT___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Follow External References True If Required</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_FOLLOW_EXTERNAL_REFERENCES_TRUE_IF_REQUIRED__DIAGNOSTICCHAIN_MAP = DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Local Dynamic Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT = DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 2;

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
	int INSTANCE_SELECTOR_SOURCE_ELEMENT__NAME = LOCAL_DYNAMIC_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT__MODIFIERS = LOCAL_DYNAMIC_SOURCE_ELEMENT__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT__SOURCE = LOCAL_DYNAMIC_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT__USE_ELEMENT_ID = LOCAL_DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Reference Match Spec</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC = LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC;

	/**
	 * The feature id for the '<em><b>Follow External References</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT__FOLLOW_EXTERNAL_REFERENCES = LOCAL_DYNAMIC_SOURCE_ELEMENT__FOLLOW_EXTERNAL_REFERENCES;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT__LOCAL_CONDITION = LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT__SHARED_CONDITION = LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT__ALL_CONDITIONS = LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Instance Selector Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT_FEATURE_COUNT = LOCAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = LOCAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT___GET_MAPPING = LOCAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = LOCAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Follow External References True If Required</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT___VALIDATE_FOLLOW_EXTERNAL_REFERENCES_TRUE_IF_REQUIRED__DIAGNOSTICCHAIN_MAP = LOCAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_FOLLOW_EXTERNAL_REFERENCES_TRUE_IF_REQUIRED__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = LOCAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Instance Selector Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_SOURCE_ELEMENT_OPERATION_COUNT = LOCAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.ExternalDynamicSourceElementImpl <em>External Dynamic Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.ExternalDynamicSourceElementImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getExternalDynamicSourceElement()
	 * @generated
	 */
	int EXTERNAL_DYNAMIC_SOURCE_ELEMENT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DYNAMIC_SOURCE_ELEMENT__NAME = DYNAMIC_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DYNAMIC_SOURCE_ELEMENT__MODIFIERS = DYNAMIC_SOURCE_ELEMENT__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DYNAMIC_SOURCE_ELEMENT__SOURCE = DYNAMIC_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID = DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID;

	/**
	 * The number of structural features of the '<em>External Dynamic Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT = DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING = DYNAMIC_SOURCE_ELEMENT___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>External Dynamic Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT = DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 1;

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
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT__NAME = EXTERNAL_DYNAMIC_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT__MODIFIERS = EXTERNAL_DYNAMIC_SOURCE_ELEMENT__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT__SOURCE = EXTERNAL_DYNAMIC_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT__USE_ELEMENT_ID = EXTERNAL_DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT__LOCAL_CONDITION = EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT__SHARED_CONDITION = EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT__ALL_CONDITIONS = EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Instance Selector External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT_FEATURE_COUNT = EXTERNAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = EXTERNAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING = EXTERNAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = EXTERNAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = EXTERNAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Instance Selector External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT_OPERATION_COUNT = EXTERNAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.GlobalDynamicSourceElementImpl <em>Global Dynamic Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.GlobalDynamicSourceElementImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getGlobalDynamicSourceElement()
	 * @generated
	 */
	int GLOBAL_DYNAMIC_SOURCE_ELEMENT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_DYNAMIC_SOURCE_ELEMENT__NAME = DYNAMIC_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_DYNAMIC_SOURCE_ELEMENT__MODIFIERS = DYNAMIC_SOURCE_ELEMENT__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_DYNAMIC_SOURCE_ELEMENT__SOURCE = DYNAMIC_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID = DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_DYNAMIC_SOURCE_ELEMENT__INSTANCE_SELECTORS = DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Global Dynamic Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT = DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING = DYNAMIC_SOURCE_ELEMENT___GET_MAPPING;

	/**
	 * The number of operations of the '<em>Global Dynamic Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT = DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.InstanceSelectorGlobalSourceElementImpl <em>Instance Selector Global Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.InstanceSelectorGlobalSourceElementImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getInstanceSelectorGlobalSourceElement()
	 * @generated
	 */
	int INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT__NAME = GLOBAL_DYNAMIC_SOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT__MODIFIERS = GLOBAL_DYNAMIC_SOURCE_ELEMENT__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT__SOURCE = GLOBAL_DYNAMIC_SOURCE_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT__USE_ELEMENT_ID = GLOBAL_DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT__INSTANCE_SELECTORS = GLOBAL_DYNAMIC_SOURCE_ELEMENT__INSTANCE_SELECTORS;

	/**
	 * The feature id for the '<em><b>Local Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT__LOCAL_CONDITION = GLOBAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT__SHARED_CONDITION = GLOBAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT__ALL_CONDITIONS = GLOBAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Instance Selector Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT_FEATURE_COUNT = GLOBAL_DYNAMIC_SOURCE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = GLOBAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT___GET_MAPPING = GLOBAL_DYNAMIC_SOURCE_ELEMENT___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Reference Only Conditions From Condition Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP = GLOBAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Instance Selector Global Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT_OPERATION_COUNT = GLOBAL_DYNAMIC_SOURCE_ELEMENT_OPERATION_COUNT + 1;

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
	 * Returns the meta object for the '{@link pamtram.structure.InstanceSelector#getLocalSourceElements() <em>Get Local Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Local Source Elements</em>' operation.
	 * @see pamtram.structure.InstanceSelector#getLocalSourceElements()
	 * @generated
	 */
	EOperation getInstanceSelector__GetLocalSourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.InstanceSelector#getExternalSourceElements() <em>Get External Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get External Source Elements</em>' operation.
	 * @see pamtram.structure.InstanceSelector#getExternalSourceElements()
	 * @generated
	 */
	EOperation getInstanceSelector__GetExternalSourceElements();

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
	 * Returns the meta object for the reference '{@link pamtram.structure.SourceInstanceSelector#getReferenceAttribute <em>Reference Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference Attribute</em>'.
	 * @see pamtram.structure.SourceInstanceSelector#getReferenceAttribute()
	 * @see #getSourceInstanceSelector()
	 * @generated
	 */
	EReference getSourceInstanceSelector_ReferenceAttribute();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.SourceInstanceSelector#getTargetClass <em>Target Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Class</em>'.
	 * @see pamtram.structure.SourceInstanceSelector#getTargetClass()
	 * @see #getSourceInstanceSelector()
	 * @generated
	 */
	EReference getSourceInstanceSelector_TargetClass();

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
	 * Returns the meta object for the reference '{@link pamtram.structure.TargetInstanceSelector#getReferenceAttribute <em>Reference Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference Attribute</em>'.
	 * @see pamtram.structure.TargetInstanceSelector#getReferenceAttribute()
	 * @see #getTargetInstanceSelector()
	 * @generated
	 */
	EReference getTargetInstanceSelector_ReferenceAttribute();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.TargetInstanceSelector#getTargetClass <em>Target Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Class</em>'.
	 * @see pamtram.structure.TargetInstanceSelector#getTargetClass()
	 * @see #getTargetInstanceSelector()
	 * @generated
	 */
	EReference getTargetInstanceSelector_TargetClass();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.TargetInstanceSelector#validateReferenceAttributeIsValid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Reference Attribute Is Valid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Reference Attribute Is Valid</em>' operation.
	 * @see pamtram.structure.TargetInstanceSelector#validateReferenceAttributeIsValid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTargetInstanceSelector__ValidateReferenceAttributeIsValid__DiagnosticChain_Map();

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
	 * Returns the meta object for class '{@link pamtram.structure.InstanceSelectorGlobalSourceElement <em>Instance Selector Global Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Selector Global Source Element</em>'.
	 * @see pamtram.structure.InstanceSelectorGlobalSourceElement
	 * @generated
	 */
	EClass getInstanceSelectorGlobalSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.DynamicSourceElement <em>Dynamic Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Source Element</em>'.
	 * @see pamtram.structure.DynamicSourceElement
	 * @generated
	 */
	EClass getDynamicSourceElement();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.DynamicSourceElement#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see pamtram.structure.DynamicSourceElement#getSource()
	 * @see #getDynamicSourceElement()
	 * @generated
	 */
	EReference getDynamicSourceElement_Source();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.DynamicSourceElement#isUseElementID <em>Use Element ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Element ID</em>'.
	 * @see pamtram.structure.DynamicSourceElement#isUseElementID()
	 * @see #getDynamicSourceElement()
	 * @generated
	 */
	EAttribute getDynamicSourceElement_UseElementID();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.DynamicSourceElement#getMappingHintGroup() <em>Get Mapping Hint Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Mapping Hint Group</em>' operation.
	 * @see pamtram.structure.DynamicSourceElement#getMappingHintGroup()
	 * @generated
	 */
	EOperation getDynamicSourceElement__GetMappingHintGroup();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.DynamicSourceElement#getMapping() <em>Get Mapping</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Mapping</em>' operation.
	 * @see pamtram.structure.DynamicSourceElement#getMapping()
	 * @generated
	 */
	EOperation getDynamicSourceElement__GetMapping();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.LocalDynamicSourceElement <em>Local Dynamic Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Dynamic Source Element</em>'.
	 * @see pamtram.structure.LocalDynamicSourceElement
	 * @generated
	 */
	EClass getLocalDynamicSourceElement();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.LocalDynamicSourceElement#validateSourceAttributeMatchesSectionOrContainedSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Attribute Matches Section Or Contained Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * @see pamtram.structure.LocalDynamicSourceElement#validateSourceAttributeMatchesSectionOrContainedSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLocalDynamicSourceElement__ValidateSourceAttributeMatchesSectionOrContainedSection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.LocalDynamicSourceElement#validateFollowExternalReferencesTrueIfRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Follow External References True If Required</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Follow External References True If Required</em>' operation.
	 * @see pamtram.structure.LocalDynamicSourceElement#validateFollowExternalReferencesTrueIfRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLocalDynamicSourceElement__ValidateFollowExternalReferencesTrueIfRequired__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.ExternalDynamicSourceElement <em>External Dynamic Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Dynamic Source Element</em>'.
	 * @see pamtram.structure.ExternalDynamicSourceElement
	 * @generated
	 */
	EClass getExternalDynamicSourceElement();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.ExternalDynamicSourceElement#validateSourceAttributeMatchesContainerSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Attribute Matches Container Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * @see pamtram.structure.ExternalDynamicSourceElement#validateSourceAttributeMatchesContainerSection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getExternalDynamicSourceElement__ValidateSourceAttributeMatchesContainerSection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.GlobalDynamicSourceElement <em>Global Dynamic Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Dynamic Source Element</em>'.
	 * @see pamtram.structure.GlobalDynamicSourceElement
	 * @generated
	 */
	EClass getGlobalDynamicSourceElement();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.structure.GlobalDynamicSourceElement#getInstanceSelectors <em>Instance Selectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instance Selectors</em>'.
	 * @see pamtram.structure.GlobalDynamicSourceElement#getInstanceSelectors()
	 * @see #getGlobalDynamicSourceElement()
	 * @generated
	 */
	EReference getGlobalDynamicSourceElement_InstanceSelectors();

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
		 * The meta object literal for the '<em><b>Get Local Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INSTANCE_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS = eINSTANCE.getInstanceSelector__GetLocalSourceElements();

		/**
		 * The meta object literal for the '<em><b>Get External Source Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INSTANCE_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS = eINSTANCE.getInstanceSelector__GetExternalSourceElements();

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
		 * The meta object literal for the '<em><b>Reference Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE = eINSTANCE.getSourceInstanceSelector_ReferenceAttribute();

		/**
		 * The meta object literal for the '<em><b>Target Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_INSTANCE_SELECTOR__TARGET_CLASS = eINSTANCE.getSourceInstanceSelector_TargetClass();

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
		 * The meta object literal for the '<em><b>Reference Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE = eINSTANCE.getTargetInstanceSelector_ReferenceAttribute();

		/**
		 * The meta object literal for the '<em><b>Target Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_INSTANCE_SELECTOR__TARGET_CLASS = eINSTANCE.getTargetInstanceSelector_TargetClass();

		/**
		 * The meta object literal for the '<em><b>Validate Reference Attribute Is Valid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TARGET_INSTANCE_SELECTOR___VALIDATE_REFERENCE_ATTRIBUTE_IS_VALID__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTargetInstanceSelector__ValidateReferenceAttributeIsValid__DiagnosticChain_Map();

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
		 * The meta object literal for the '{@link pamtram.structure.impl.InstanceSelectorGlobalSourceElementImpl <em>Instance Selector Global Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.InstanceSelectorGlobalSourceElementImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getInstanceSelectorGlobalSourceElement()
		 * @generated
		 */
		EClass INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT = eINSTANCE.getInstanceSelectorGlobalSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.DynamicSourceElementImpl <em>Dynamic Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.DynamicSourceElementImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getDynamicSourceElement()
		 * @generated
		 */
		EClass DYNAMIC_SOURCE_ELEMENT = eINSTANCE.getDynamicSourceElement();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_SOURCE_ELEMENT__SOURCE = eINSTANCE.getDynamicSourceElement_Source();

		/**
		 * The meta object literal for the '<em><b>Use Element ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_SOURCE_ELEMENT__USE_ELEMENT_ID = eINSTANCE.getDynamicSourceElement_UseElementID();

		/**
		 * The meta object literal for the '<em><b>Get Mapping Hint Group</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = eINSTANCE.getDynamicSourceElement__GetMappingHintGroup();

		/**
		 * The meta object literal for the '<em><b>Get Mapping</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DYNAMIC_SOURCE_ELEMENT___GET_MAPPING = eINSTANCE.getDynamicSourceElement__GetMapping();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.LocalDynamicSourceElementImpl <em>Local Dynamic Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.LocalDynamicSourceElementImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getLocalDynamicSourceElement()
		 * @generated
		 */
		EClass LOCAL_DYNAMIC_SOURCE_ELEMENT = eINSTANCE.getLocalDynamicSourceElement();

		/**
		 * The meta object literal for the '<em><b>Validate Source Attribute Matches Section Or Contained Section</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOCAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLocalDynamicSourceElement__ValidateSourceAttributeMatchesSectionOrContainedSection__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Follow External References True If Required</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOCAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_FOLLOW_EXTERNAL_REFERENCES_TRUE_IF_REQUIRED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLocalDynamicSourceElement__ValidateFollowExternalReferencesTrueIfRequired__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.ExternalDynamicSourceElementImpl <em>External Dynamic Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.ExternalDynamicSourceElementImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getExternalDynamicSourceElement()
		 * @generated
		 */
		EClass EXTERNAL_DYNAMIC_SOURCE_ELEMENT = eINSTANCE.getExternalDynamicSourceElement();

		/**
		 * The meta object literal for the '<em><b>Validate Source Attribute Matches Container Section</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTERNAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getExternalDynamicSourceElement__ValidateSourceAttributeMatchesContainerSection__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.GlobalDynamicSourceElementImpl <em>Global Dynamic Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.GlobalDynamicSourceElementImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getGlobalDynamicSourceElement()
		 * @generated
		 */
		EClass GLOBAL_DYNAMIC_SOURCE_ELEMENT = eINSTANCE.getGlobalDynamicSourceElement();

		/**
		 * The meta object literal for the '<em><b>Instance Selectors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOBAL_DYNAMIC_SOURCE_ELEMENT__INSTANCE_SELECTORS = eINSTANCE.getGlobalDynamicSourceElement_InstanceSelectors();

	}

} //StructurePackage
