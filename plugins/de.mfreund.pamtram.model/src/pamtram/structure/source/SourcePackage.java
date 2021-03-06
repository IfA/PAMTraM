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
package pamtram.structure.source;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import pamtram.structure.generic.GenericPackage;

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
 * This package contains all elements related to the description of source element structures (aka SourceSections). These form the left-hand side (LHS) of a mapping.
 * <!-- end-model-doc -->
 * @see pamtram.structure.source.SourceFactory
 * @model kind="package"
 * @generated
 */
public interface SourcePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "source";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mfreund.de/pamtram/structure/source";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "source";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SourcePackage eINSTANCE = pamtram.structure.source.impl.SourcePackageImpl.init();

	/**
	 * The meta object id for the '{@link pamtram.structure.source.impl.SourceSectionClassImpl <em>Section Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.source.impl.SourceSectionClassImpl
	 * @see pamtram.structure.source.impl.SourcePackageImpl#getSourceSectionClass()
	 * @generated
	 */
	int SOURCE_SECTION_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__NAME = GenericPackage.CLASS__NAME;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__ECLASS = GenericPackage.CLASS__ECLASS;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__CARDINALITY = GenericPackage.CLASS__CARDINALITY;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__REFERENCES = GenericPackage.CLASS__REFERENCES;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__CONTAINER = GenericPackage.CLASS__CONTAINER;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__ATTRIBUTES = GenericPackage.CLASS__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>All Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__ALL_CONTAINER = GenericPackage.CLASS__ALL_CONTAINER;

	/**
	 * The feature id for the '<em><b>Actual Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__ACTUAL_ATTRIBUTES = GenericPackage.CLASS__ACTUAL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Virtual Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__VIRTUAL_ATTRIBUTES = GenericPackage.CLASS__VIRTUAL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Actual References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__ACTUAL_REFERENCES = GenericPackage.CLASS__ACTUAL_REFERENCES;

	/**
	 * The feature id for the '<em><b>Virtual References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__VIRTUAL_REFERENCES = GenericPackage.CLASS__VIRTUAL_REFERENCES;

	/**
	 * The feature id for the '<em><b>All Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__ALL_ATTRIBUTES = GenericPackage.CLASS__ALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>All References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__ALL_REFERENCES = GenericPackage.CLASS__ALL_REFERENCES;

	/**
	 * The feature id for the '<em><b>All Concrete Extending</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__ALL_CONCRETE_EXTENDING = GenericPackage.CLASS__ALL_CONCRETE_EXTENDING;

	/**
	 * The feature id for the '<em><b>All Composite References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__ALL_COMPOSITE_REFERENCES = GenericPackage.CLASS__ALL_COMPOSITE_REFERENCES;

	/**
	 * The feature id for the '<em><b>All Cross References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__ALL_CROSS_REFERENCES = GenericPackage.CLASS__ALL_CROSS_REFERENCES;

	/**
	 * The feature id for the '<em><b>Include Sub Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__INCLUDE_SUB_TYPES = GenericPackage.CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Section Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS_FEATURE_COUNT = GenericPackage.CLASS_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___GET_CONTAINING_SECTION = GenericPackage.CLASS___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___GET_CONTAINING_SECTION_MODEL = GenericPackage.CLASS___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___IS_LIBRARY_ENTRY = GenericPackage.CLASS___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Is Container For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___IS_CONTAINER_FOR__CLASS = GenericPackage.CLASS___IS_CONTAINER_FOR__CLASS;

	/**
	 * The operation id for the '<em>Is Contained In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___IS_CONTAINED_IN__CLASS = GenericPackage.CLASS___IS_CONTAINED_IN__CLASS;

	/**
	 * The operation id for the '<em>Get Owning Containment Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___GET_OWNING_CONTAINMENT_REFERENCE = GenericPackage.CLASS___GET_OWNING_CONTAINMENT_REFERENCE;

	/**
	 * The operation id for the '<em>Is Referenced By</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___IS_REFERENCED_BY__CLASS_ELIST = GenericPackage.CLASS___IS_REFERENCED_BY__CLASS_ELIST;

	/**
	 * The operation id for the '<em>Validate EClass Matches Parent EReference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP = GenericPackage.CLASS___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Cardinality Is Valid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP = GenericPackage.CLASS___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Container Is Valid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP = GenericPackage.CLASS___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Not Self Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___VALIDATE_NOT_SELF_CONTAINER__DIAGNOSTICCHAIN_MAP = GenericPackage.CLASS___VALIDATE_NOT_SELF_CONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Only Complementing Actual References</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___VALIDATE_ONLY_COMPLEMENTING_ACTUAL_REFERENCES__DIAGNOSTICCHAIN_MAP = GenericPackage.CLASS___VALIDATE_ONLY_COMPLEMENTING_ACTUAL_REFERENCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Section Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS_OPERATION_COUNT = GenericPackage.CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.source.impl.SourceSectionImpl <em>Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.source.impl.SourceSectionImpl
	 * @see pamtram.structure.source.impl.SourcePackageImpl#getSourceSection()
	 * @generated
	 */
	int SOURCE_SECTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__NAME = SOURCE_SECTION_CLASS__NAME;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__ECLASS = SOURCE_SECTION_CLASS__ECLASS;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__CARDINALITY = SOURCE_SECTION_CLASS__CARDINALITY;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__REFERENCES = SOURCE_SECTION_CLASS__REFERENCES;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__CONTAINER = SOURCE_SECTION_CLASS__CONTAINER;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__ATTRIBUTES = SOURCE_SECTION_CLASS__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>All Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__ALL_CONTAINER = SOURCE_SECTION_CLASS__ALL_CONTAINER;

	/**
	 * The feature id for the '<em><b>Actual Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__ACTUAL_ATTRIBUTES = SOURCE_SECTION_CLASS__ACTUAL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Virtual Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__VIRTUAL_ATTRIBUTES = SOURCE_SECTION_CLASS__VIRTUAL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Actual References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__ACTUAL_REFERENCES = SOURCE_SECTION_CLASS__ACTUAL_REFERENCES;

	/**
	 * The feature id for the '<em><b>Virtual References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__VIRTUAL_REFERENCES = SOURCE_SECTION_CLASS__VIRTUAL_REFERENCES;

	/**
	 * The feature id for the '<em><b>All Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__ALL_ATTRIBUTES = SOURCE_SECTION_CLASS__ALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>All References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__ALL_REFERENCES = SOURCE_SECTION_CLASS__ALL_REFERENCES;

	/**
	 * The feature id for the '<em><b>All Concrete Extending</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__ALL_CONCRETE_EXTENDING = SOURCE_SECTION_CLASS__ALL_CONCRETE_EXTENDING;

	/**
	 * The feature id for the '<em><b>All Composite References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__ALL_COMPOSITE_REFERENCES = SOURCE_SECTION_CLASS__ALL_COMPOSITE_REFERENCES;

	/**
	 * The feature id for the '<em><b>All Cross References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__ALL_CROSS_REFERENCES = SOURCE_SECTION_CLASS__ALL_CROSS_REFERENCES;

	/**
	 * The feature id for the '<em><b>Include Sub Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__INCLUDE_SUB_TYPES = SOURCE_SECTION_CLASS__INCLUDE_SUB_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__ABSTRACT = SOURCE_SECTION_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extend</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__EXTEND = SOURCE_SECTION_CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Extend</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__ALL_EXTEND = SOURCE_SECTION_CLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>All Extending</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__ALL_EXTENDING = SOURCE_SECTION_CLASS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Deactivated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__DEACTIVATED = SOURCE_SECTION_CLASS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Referencing Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION__REFERENCING_MAPPINGS = SOURCE_SECTION_CLASS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_FEATURE_COUNT = SOURCE_SECTION_CLASS_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___GET_CONTAINING_SECTION = SOURCE_SECTION_CLASS___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___GET_CONTAINING_SECTION_MODEL = SOURCE_SECTION_CLASS___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___IS_LIBRARY_ENTRY = SOURCE_SECTION_CLASS___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Is Container For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___IS_CONTAINER_FOR__CLASS = SOURCE_SECTION_CLASS___IS_CONTAINER_FOR__CLASS;

	/**
	 * The operation id for the '<em>Is Contained In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___IS_CONTAINED_IN__CLASS = SOURCE_SECTION_CLASS___IS_CONTAINED_IN__CLASS;

	/**
	 * The operation id for the '<em>Get Owning Containment Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___GET_OWNING_CONTAINMENT_REFERENCE = SOURCE_SECTION_CLASS___GET_OWNING_CONTAINMENT_REFERENCE;

	/**
	 * The operation id for the '<em>Is Referenced By</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___IS_REFERENCED_BY__CLASS_ELIST = SOURCE_SECTION_CLASS___IS_REFERENCED_BY__CLASS_ELIST;

	/**
	 * The operation id for the '<em>Validate EClass Matches Parent EReference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP = SOURCE_SECTION_CLASS___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Cardinality Is Valid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP = SOURCE_SECTION_CLASS___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Container Is Valid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP = SOURCE_SECTION_CLASS___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Not Self Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___VALIDATE_NOT_SELF_CONTAINER__DIAGNOSTICCHAIN_MAP = SOURCE_SECTION_CLASS___VALIDATE_NOT_SELF_CONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Only Complementing Actual References</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___VALIDATE_ONLY_COMPLEMENTING_ACTUAL_REFERENCES__DIAGNOSTICCHAIN_MAP = SOURCE_SECTION_CLASS___VALIDATE_ONLY_COMPLEMENTING_ACTUAL_REFERENCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Container Matches Extend Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP = SOURCE_SECTION_CLASS_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Extends Valid Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___VALIDATE_EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP = SOURCE_SECTION_CLASS_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Not Extend Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___VALIDATE_NOT_EXTEND_SELF__DIAGNOSTICCHAIN_MAP = SOURCE_SECTION_CLASS_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Is Referenced By Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION___VALIDATE_IS_REFERENCED_BY_MAPPING__DIAGNOSTICCHAIN_MAP = SOURCE_SECTION_CLASS_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_OPERATION_COUNT = SOURCE_SECTION_CLASS_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link pamtram.structure.source.impl.SourceSectionReferenceImpl <em>Section Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.source.impl.SourceSectionReferenceImpl
	 * @see pamtram.structure.source.impl.SourcePackageImpl#getSourceSectionReference()
	 * @generated
	 */
	int SOURCE_SECTION_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE__NAME = GenericPackage.REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE__OWNING_CLASS = GenericPackage.REFERENCE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Ignore Unmatched Elements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS = GenericPackage.REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Section Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE_FEATURE_COUNT = GenericPackage.REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE___GET_CONTAINING_SECTION = GenericPackage.REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE___GET_CONTAINING_SECTION_MODEL = GenericPackage.REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE___IS_LIBRARY_ENTRY = GenericPackage.REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE___GET_VALUES_GENERIC = GenericPackage.REFERENCE___GET_VALUES_GENERIC;

	/**
	 * The operation id for the '<em>Add Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE___ADD_VALUES_GENERIC__ELIST = GenericPackage.REFERENCE___ADD_VALUES_GENERIC__ELIST;

	/**
	 * The operation id for the '<em>Is Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE___IS_EXTENDED = GenericPackage.REFERENCE___IS_EXTENDED;

	/**
	 * The operation id for the '<em>Get Values Including Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE___GET_VALUES_INCLUDING_EXTENDED = GenericPackage.REFERENCE___GET_VALUES_INCLUDING_EXTENDED;

	/**
	 * The operation id for the '<em>Validate Is Ignore Unmatched If Is Complemented</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE___VALIDATE_IS_IGNORE_UNMATCHED_IF_IS_COMPLEMENTED__DIAGNOSTICCHAIN_MAP = GenericPackage.REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Section Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE_OPERATION_COUNT = GenericPackage.REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.source.impl.SourceSectionCompositeReferenceImpl <em>Section Composite Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.source.impl.SourceSectionCompositeReferenceImpl
	 * @see pamtram.structure.source.impl.SourcePackageImpl#getSourceSectionCompositeReference()
	 * @generated
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE__NAME = GenericPackage.COMPOSITE_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE__OWNING_CLASS = GenericPackage.COMPOSITE_REFERENCE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE__VALUE = GenericPackage.COMPOSITE_REFERENCE__VALUE;

	/**
	 * The feature id for the '<em><b>Ignore Unmatched Elements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE__IGNORE_UNMATCHED_ELEMENTS = GenericPackage.COMPOSITE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE__EREFERENCE = GenericPackage.COMPOSITE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Section Composite Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE_FEATURE_COUNT = GenericPackage.COMPOSITE_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE___GET_CONTAINING_SECTION = GenericPackage.COMPOSITE_REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE___GET_CONTAINING_SECTION_MODEL = GenericPackage.COMPOSITE_REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE___IS_LIBRARY_ENTRY = GenericPackage.COMPOSITE_REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE___GET_VALUES_GENERIC = GenericPackage.COMPOSITE_REFERENCE___GET_VALUES_GENERIC;

	/**
	 * The operation id for the '<em>Add Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE___ADD_VALUES_GENERIC__ELIST = GenericPackage.COMPOSITE_REFERENCE___ADD_VALUES_GENERIC__ELIST;

	/**
	 * The operation id for the '<em>Is Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE___IS_EXTENDED = GenericPackage.COMPOSITE_REFERENCE___IS_EXTENDED;

	/**
	 * The operation id for the '<em>Get Values Including Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE___GET_VALUES_INCLUDING_EXTENDED = GenericPackage.COMPOSITE_REFERENCE___GET_VALUES_INCLUDING_EXTENDED;

	/**
	 * The operation id for the '<em>Validate EReference Is Containment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_IS_CONTAINMENT__DIAGNOSTICCHAIN_MAP = GenericPackage.COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_IS_CONTAINMENT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Is Ignore Unmatched If Is Complemented</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE___VALIDATE_IS_IGNORE_UNMATCHED_IF_IS_COMPLEMENTED__DIAGNOSTICCHAIN_MAP = GenericPackage.COMPOSITE_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate EReference Matches Parent EClass</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP = GenericPackage.COMPOSITE_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Section Composite Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_COMPOSITE_REFERENCE_OPERATION_COUNT = GenericPackage.COMPOSITE_REFERENCE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.structure.source.impl.SourceSectionCrossReferenceImpl <em>Section Cross Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.source.impl.SourceSectionCrossReferenceImpl
	 * @see pamtram.structure.source.impl.SourcePackageImpl#getSourceSectionCrossReference()
	 * @generated
	 */
	int SOURCE_SECTION_CROSS_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE__NAME = GenericPackage.CROSS_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE__OWNING_CLASS = GenericPackage.CROSS_REFERENCE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE__VALUE = GenericPackage.CROSS_REFERENCE__VALUE;

	/**
	 * The feature id for the '<em><b>Ignore Unmatched Elements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS = GenericPackage.CROSS_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE = GenericPackage.CROSS_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Section Cross Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE_FEATURE_COUNT = GenericPackage.CROSS_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE___GET_CONTAINING_SECTION = GenericPackage.CROSS_REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE___GET_CONTAINING_SECTION_MODEL = GenericPackage.CROSS_REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE___IS_LIBRARY_ENTRY = GenericPackage.CROSS_REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE___GET_VALUES_GENERIC = GenericPackage.CROSS_REFERENCE___GET_VALUES_GENERIC;

	/**
	 * The operation id for the '<em>Add Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE___ADD_VALUES_GENERIC__ELIST = GenericPackage.CROSS_REFERENCE___ADD_VALUES_GENERIC__ELIST;

	/**
	 * The operation id for the '<em>Is Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE___IS_EXTENDED = GenericPackage.CROSS_REFERENCE___IS_EXTENDED;

	/**
	 * The operation id for the '<em>Get Values Including Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE___GET_VALUES_INCLUDING_EXTENDED = GenericPackage.CROSS_REFERENCE___GET_VALUES_INCLUDING_EXTENDED;

	/**
	 * The operation id for the '<em>Validate Values Match Reference Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE___VALIDATE_VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP = GenericPackage.CROSS_REFERENCE___VALIDATE_VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Is Ignore Unmatched If Is Complemented</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE___VALIDATE_IS_IGNORE_UNMATCHED_IF_IS_COMPLEMENTED__DIAGNOSTICCHAIN_MAP = GenericPackage.CROSS_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate EReference Matches Parent EClass</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP = GenericPackage.CROSS_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Section Cross Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CROSS_REFERENCE_OPERATION_COUNT = GenericPackage.CROSS_REFERENCE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.structure.source.impl.VirtualSourceSectionCrossReferenceImpl <em>Virtual Source Section Cross Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.source.impl.VirtualSourceSectionCrossReferenceImpl
	 * @see pamtram.structure.source.impl.SourcePackageImpl#getVirtualSourceSectionCrossReference()
	 * @generated
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__NAME = GenericPackage.CROSS_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__OWNING_CLASS = GenericPackage.CROSS_REFERENCE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__VALUE = GenericPackage.CROSS_REFERENCE__VALUE;

	/**
	 * The feature id for the '<em><b>Ignore Unmatched Elements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS = GenericPackage.CROSS_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Derivation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__DERIVATION = GenericPackage.CROSS_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Virtual Source Section Cross Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE_FEATURE_COUNT = GenericPackage.CROSS_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE___GET_CONTAINING_SECTION = GenericPackage.CROSS_REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE___GET_CONTAINING_SECTION_MODEL = GenericPackage.CROSS_REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE___IS_LIBRARY_ENTRY = GenericPackage.CROSS_REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE___GET_VALUES_GENERIC = GenericPackage.CROSS_REFERENCE___GET_VALUES_GENERIC;

	/**
	 * The operation id for the '<em>Add Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE___ADD_VALUES_GENERIC__ELIST = GenericPackage.CROSS_REFERENCE___ADD_VALUES_GENERIC__ELIST;

	/**
	 * The operation id for the '<em>Is Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE___IS_EXTENDED = GenericPackage.CROSS_REFERENCE___IS_EXTENDED;

	/**
	 * The operation id for the '<em>Get Values Including Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE___GET_VALUES_INCLUDING_EXTENDED = GenericPackage.CROSS_REFERENCE___GET_VALUES_INCLUDING_EXTENDED;

	/**
	 * The operation id for the '<em>Validate Values Match Reference Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE___VALIDATE_VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP = GenericPackage.CROSS_REFERENCE___VALIDATE_VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Is Ignore Unmatched If Is Complemented</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE___VALIDATE_IS_IGNORE_UNMATCHED_IF_IS_COMPLEMENTED__DIAGNOSTICCHAIN_MAP = GenericPackage.CROSS_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Derivation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE___VALIDATE_DERIVATION__DIAGNOSTICCHAIN_MAP = GenericPackage.CROSS_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Virtual Source Section Cross Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE_OPERATION_COUNT = GenericPackage.CROSS_REFERENCE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.structure.source.impl.SourceSectionAttributeImpl <em>Section Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.source.impl.SourceSectionAttributeImpl
	 * @see pamtram.structure.source.impl.SourcePackageImpl#getSourceSectionAttribute()
	 * @generated
	 */
	int SOURCE_SECTION_ATTRIBUTE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE__NAME = GenericPackage.ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS = GenericPackage.ATTRIBUTE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Value Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINTS = GenericPackage.ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE_FEATURE_COUNT = GenericPackage.ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION = GenericPackage.ATTRIBUTE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL = GenericPackage.ATTRIBUTE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE___IS_LIBRARY_ENTRY = GenericPackage.ATTRIBUTE___IS_LIBRARY_ENTRY;

	/**
	 * The number of operations of the '<em>Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE_OPERATION_COUNT = GenericPackage.ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.source.impl.ActualSourceSectionAttributeImpl <em>Actual Source Section Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.source.impl.ActualSourceSectionAttributeImpl
	 * @see pamtram.structure.source.impl.SourcePackageImpl#getActualSourceSectionAttribute()
	 * @generated
	 */
	int ACTUAL_SOURCE_SECTION_ATTRIBUTE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_SOURCE_SECTION_ATTRIBUTE__NAME = SOURCE_SECTION_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS = SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Value Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINTS = SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE = SOURCE_SECTION_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Actual Source Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_SOURCE_SECTION_ATTRIBUTE_FEATURE_COUNT = SOURCE_SECTION_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_SOURCE_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION = SOURCE_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_SOURCE_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL = SOURCE_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_SOURCE_SECTION_ATTRIBUTE___IS_LIBRARY_ENTRY = SOURCE_SECTION_ATTRIBUTE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Validate Attribute Matches Parent EClass</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_SOURCE_SECTION_ATTRIBUTE___VALIDATE_ATTRIBUTE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP = SOURCE_SECTION_ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Actual Source Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_SOURCE_SECTION_ATTRIBUTE_OPERATION_COUNT = SOURCE_SECTION_ATTRIBUTE_OPERATION_COUNT + 1;


	/**
	 * The meta object id for the '{@link pamtram.structure.source.impl.VirtualSourceSectionAttributeImpl <em>Virtual Source Section Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.source.impl.VirtualSourceSectionAttributeImpl
	 * @see pamtram.structure.source.impl.SourcePackageImpl#getVirtualSourceSectionAttribute()
	 * @generated
	 */
	int VIRTUAL_SOURCE_SECTION_ATTRIBUTE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_ATTRIBUTE__NAME = SOURCE_SECTION_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS = SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Value Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINTS = SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Derivation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_ATTRIBUTE__DERIVATION = SOURCE_SECTION_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Virtual Source Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_ATTRIBUTE_FEATURE_COUNT = SOURCE_SECTION_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION = SOURCE_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL = SOURCE_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_ATTRIBUTE___IS_LIBRARY_ENTRY = SOURCE_SECTION_ATTRIBUTE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Validate Derivation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_ATTRIBUTE___VALIDATE_DERIVATION__DIAGNOSTICCHAIN_MAP = SOURCE_SECTION_ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Virtual Source Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SOURCE_SECTION_ATTRIBUTE_OPERATION_COUNT = SOURCE_SECTION_ATTRIBUTE_OPERATION_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link pamtram.structure.source.SourceSection <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section</em>'.
	 * @see pamtram.structure.source.SourceSection
	 * @generated
	 */
	EClass getSourceSection();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.structure.source.SourceSection#getReferencingMappings <em>Referencing Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referencing Mappings</em>'.
	 * @see pamtram.structure.source.SourceSection#getReferencingMappings()
	 * @see #getSourceSection()
	 * @generated
	 */
	EReference getSourceSection_ReferencingMappings();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.source.SourceSection#validateIsReferencedByMapping(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Is Referenced By Mapping</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Is Referenced By Mapping</em>' operation.
	 * @see pamtram.structure.source.SourceSection#validateIsReferencedByMapping(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSourceSection__ValidateIsReferencedByMapping__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.source.SourceSectionClass <em>Section Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Class</em>'.
	 * @see pamtram.structure.source.SourceSectionClass
	 * @generated
	 */
	EClass getSourceSectionClass();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.source.SourceSectionClass#isIncludeSubTypes <em>Include Sub Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include Sub Types</em>'.
	 * @see pamtram.structure.source.SourceSectionClass#isIncludeSubTypes()
	 * @see #getSourceSectionClass()
	 * @generated
	 */
	EAttribute getSourceSectionClass_IncludeSubTypes();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.source.SourceSectionReference <em>Section Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Reference</em>'.
	 * @see pamtram.structure.source.SourceSectionReference
	 * @generated
	 */
	EClass getSourceSectionReference();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.source.SourceSectionReference#isIgnoreUnmatchedElements <em>Ignore Unmatched Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ignore Unmatched Elements</em>'.
	 * @see pamtram.structure.source.SourceSectionReference#isIgnoreUnmatchedElements()
	 * @see #getSourceSectionReference()
	 * @generated
	 */
	EAttribute getSourceSectionReference_IgnoreUnmatchedElements();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.source.SourceSectionReference#validateIsIgnoreUnmatchedIfIsComplemented(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Is Ignore Unmatched If Is Complemented</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Is Ignore Unmatched If Is Complemented</em>' operation.
	 * @see pamtram.structure.source.SourceSectionReference#validateIsIgnoreUnmatchedIfIsComplemented(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSourceSectionReference__ValidateIsIgnoreUnmatchedIfIsComplemented__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.source.SourceSectionCompositeReference <em>Section Composite Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Composite Reference</em>'.
	 * @see pamtram.structure.source.SourceSectionCompositeReference
	 * @generated
	 */
	EClass getSourceSectionCompositeReference();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.source.SourceSectionCrossReference <em>Section Cross Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Cross Reference</em>'.
	 * @see pamtram.structure.source.SourceSectionCrossReference
	 * @generated
	 */
	EClass getSourceSectionCrossReference();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.source.VirtualSourceSectionCrossReference <em>Virtual Source Section Cross Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Source Section Cross Reference</em>'.
	 * @see pamtram.structure.source.VirtualSourceSectionCrossReference
	 * @generated
	 */
	EClass getVirtualSourceSectionCrossReference();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.source.VirtualSourceSectionCrossReference#getDerivation <em>Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Derivation</em>'.
	 * @see pamtram.structure.source.VirtualSourceSectionCrossReference#getDerivation()
	 * @see #getVirtualSourceSectionCrossReference()
	 * @generated
	 */
	EAttribute getVirtualSourceSectionCrossReference_Derivation();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.source.VirtualSourceSectionCrossReference#validateDerivation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Derivation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Derivation</em>' operation.
	 * @see pamtram.structure.source.VirtualSourceSectionCrossReference#validateDerivation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getVirtualSourceSectionCrossReference__ValidateDerivation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.source.SourceSectionAttribute <em>Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Attribute</em>'.
	 * @see pamtram.structure.source.SourceSectionAttribute
	 * @generated
	 */
	EClass getSourceSectionAttribute();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.structure.source.SourceSectionAttribute#getValueConstraints <em>Value Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value Constraints</em>'.
	 * @see pamtram.structure.source.SourceSectionAttribute#getValueConstraints()
	 * @see #getSourceSectionAttribute()
	 * @generated
	 */
	EReference getSourceSectionAttribute_ValueConstraints();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.source.ActualSourceSectionAttribute <em>Actual Source Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actual Source Section Attribute</em>'.
	 * @see pamtram.structure.source.ActualSourceSectionAttribute
	 * @generated
	 */
	EClass getActualSourceSectionAttribute();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.source.VirtualSourceSectionAttribute <em>Virtual Source Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Source Section Attribute</em>'.
	 * @see pamtram.structure.source.VirtualSourceSectionAttribute
	 * @generated
	 */
	EClass getVirtualSourceSectionAttribute();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.source.VirtualSourceSectionAttribute#getDerivation <em>Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Derivation</em>'.
	 * @see pamtram.structure.source.VirtualSourceSectionAttribute#getDerivation()
	 * @see #getVirtualSourceSectionAttribute()
	 * @generated
	 */
	EAttribute getVirtualSourceSectionAttribute_Derivation();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.source.VirtualSourceSectionAttribute#validateDerivation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Derivation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Derivation</em>' operation.
	 * @see pamtram.structure.source.VirtualSourceSectionAttribute#validateDerivation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getVirtualSourceSectionAttribute__ValidateDerivation__DiagnosticChain_Map();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SourceFactory getSourceFactory();

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
		 * The meta object literal for the '{@link pamtram.structure.source.impl.SourceSectionImpl <em>Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.source.impl.SourceSectionImpl
		 * @see pamtram.structure.source.impl.SourcePackageImpl#getSourceSection()
		 * @generated
		 */
		EClass SOURCE_SECTION = eINSTANCE.getSourceSection();

		/**
		 * The meta object literal for the '<em><b>Referencing Mappings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_SECTION__REFERENCING_MAPPINGS = eINSTANCE.getSourceSection_ReferencingMappings();

		/**
		 * The meta object literal for the '<em><b>Validate Is Referenced By Mapping</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SOURCE_SECTION___VALIDATE_IS_REFERENCED_BY_MAPPING__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSourceSection__ValidateIsReferencedByMapping__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.source.impl.SourceSectionClassImpl <em>Section Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.source.impl.SourceSectionClassImpl
		 * @see pamtram.structure.source.impl.SourcePackageImpl#getSourceSectionClass()
		 * @generated
		 */
		EClass SOURCE_SECTION_CLASS = eINSTANCE.getSourceSectionClass();

		/**
		 * The meta object literal for the '<em><b>Include Sub Types</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_SECTION_CLASS__INCLUDE_SUB_TYPES = eINSTANCE.getSourceSectionClass_IncludeSubTypes();

		/**
		 * The meta object literal for the '{@link pamtram.structure.source.impl.SourceSectionReferenceImpl <em>Section Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.source.impl.SourceSectionReferenceImpl
		 * @see pamtram.structure.source.impl.SourcePackageImpl#getSourceSectionReference()
		 * @generated
		 */
		EClass SOURCE_SECTION_REFERENCE = eINSTANCE.getSourceSectionReference();

		/**
		 * The meta object literal for the '<em><b>Ignore Unmatched Elements</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS = eINSTANCE.getSourceSectionReference_IgnoreUnmatchedElements();

		/**
		 * The meta object literal for the '<em><b>Validate Is Ignore Unmatched If Is Complemented</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SOURCE_SECTION_REFERENCE___VALIDATE_IS_IGNORE_UNMATCHED_IF_IS_COMPLEMENTED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSourceSectionReference__ValidateIsIgnoreUnmatchedIfIsComplemented__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.source.impl.SourceSectionCompositeReferenceImpl <em>Section Composite Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.source.impl.SourceSectionCompositeReferenceImpl
		 * @see pamtram.structure.source.impl.SourcePackageImpl#getSourceSectionCompositeReference()
		 * @generated
		 */
		EClass SOURCE_SECTION_COMPOSITE_REFERENCE = eINSTANCE.getSourceSectionCompositeReference();

		/**
		 * The meta object literal for the '{@link pamtram.structure.source.impl.SourceSectionCrossReferenceImpl <em>Section Cross Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.source.impl.SourceSectionCrossReferenceImpl
		 * @see pamtram.structure.source.impl.SourcePackageImpl#getSourceSectionCrossReference()
		 * @generated
		 */
		EClass SOURCE_SECTION_CROSS_REFERENCE = eINSTANCE.getSourceSectionCrossReference();

		/**
		 * The meta object literal for the '{@link pamtram.structure.source.impl.VirtualSourceSectionCrossReferenceImpl <em>Virtual Source Section Cross Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.source.impl.VirtualSourceSectionCrossReferenceImpl
		 * @see pamtram.structure.source.impl.SourcePackageImpl#getVirtualSourceSectionCrossReference()
		 * @generated
		 */
		EClass VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE = eINSTANCE.getVirtualSourceSectionCrossReference();

		/**
		 * The meta object literal for the '<em><b>Derivation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__DERIVATION = eINSTANCE.getVirtualSourceSectionCrossReference_Derivation();

		/**
		 * The meta object literal for the '<em><b>Validate Derivation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE___VALIDATE_DERIVATION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getVirtualSourceSectionCrossReference__ValidateDerivation__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.source.impl.SourceSectionAttributeImpl <em>Section Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.source.impl.SourceSectionAttributeImpl
		 * @see pamtram.structure.source.impl.SourcePackageImpl#getSourceSectionAttribute()
		 * @generated
		 */
		EClass SOURCE_SECTION_ATTRIBUTE = eINSTANCE.getSourceSectionAttribute();

		/**
		 * The meta object literal for the '<em><b>Value Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINTS = eINSTANCE.getSourceSectionAttribute_ValueConstraints();

		/**
		 * The meta object literal for the '{@link pamtram.structure.source.impl.ActualSourceSectionAttributeImpl <em>Actual Source Section Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.source.impl.ActualSourceSectionAttributeImpl
		 * @see pamtram.structure.source.impl.SourcePackageImpl#getActualSourceSectionAttribute()
		 * @generated
		 */
		EClass ACTUAL_SOURCE_SECTION_ATTRIBUTE = eINSTANCE.getActualSourceSectionAttribute();

		/**
		 * The meta object literal for the '{@link pamtram.structure.source.impl.VirtualSourceSectionAttributeImpl <em>Virtual Source Section Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.source.impl.VirtualSourceSectionAttributeImpl
		 * @see pamtram.structure.source.impl.SourcePackageImpl#getVirtualSourceSectionAttribute()
		 * @generated
		 */
		EClass VIRTUAL_SOURCE_SECTION_ATTRIBUTE = eINSTANCE.getVirtualSourceSectionAttribute();

		/**
		 * The meta object literal for the '<em><b>Derivation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_SOURCE_SECTION_ATTRIBUTE__DERIVATION = eINSTANCE.getVirtualSourceSectionAttribute_Derivation();

		/**
		 * The meta object literal for the '<em><b>Validate Derivation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VIRTUAL_SOURCE_SECTION_ATTRIBUTE___VALIDATE_DERIVATION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getVirtualSourceSectionAttribute__ValidateDerivation__DiagnosticChain_Map();

	}

} //SourcePackage
