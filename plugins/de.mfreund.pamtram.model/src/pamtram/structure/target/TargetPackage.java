/**
 */
package pamtram.structure.target;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * This package contains all elements related to the description of target element structures (aka TargetSections). These form the right-hand side (RHS) of a mapping.
 * <!-- end-model-doc -->
 * @see pamtram.structure.target.TargetFactory
 * @model kind="package"
 * @generated
 */
public interface TargetPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "target";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mfreund.de/pamtram/structure/target";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "target";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TargetPackage eINSTANCE = pamtram.structure.target.impl.TargetPackageImpl.init();

	/**
	 * The meta object id for the '{@link pamtram.structure.target.impl.TargetSectionClassImpl <em>Section Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.target.impl.TargetSectionClassImpl
	 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSectionClass()
	 * @generated
	 */
	int TARGET_SECTION_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__NAME = GenericPackage.CLASS__NAME;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__ECLASS = GenericPackage.CLASS__ECLASS;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__CARDINALITY = GenericPackage.CLASS__CARDINALITY;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__REFERENCES = GenericPackage.CLASS__REFERENCES;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__CONTAINER = GenericPackage.CLASS__CONTAINER;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__ATTRIBUTES = GenericPackage.CLASS__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>All Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__ALL_CONTAINER = GenericPackage.CLASS__ALL_CONTAINER;

	/**
	 * The feature id for the '<em><b>Actual Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__ACTUAL_ATTRIBUTES = GenericPackage.CLASS__ACTUAL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Virtual Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__VIRTUAL_ATTRIBUTES = GenericPackage.CLASS__VIRTUAL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Actual References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__ACTUAL_REFERENCES = GenericPackage.CLASS__ACTUAL_REFERENCES;

	/**
	 * The feature id for the '<em><b>Virtual References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__VIRTUAL_REFERENCES = GenericPackage.CLASS__VIRTUAL_REFERENCES;

	/**
	 * The feature id for the '<em><b>All Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__ALL_ATTRIBUTES = GenericPackage.CLASS__ALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>All References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__ALL_REFERENCES = GenericPackage.CLASS__ALL_REFERENCES;

	/**
	 * The feature id for the '<em><b>All Concrete Extending</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__ALL_CONCRETE_EXTENDING = GenericPackage.CLASS__ALL_CONCRETE_EXTENDING;

	/**
	 * The feature id for the '<em><b>All Composite References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__ALL_COMPOSITE_REFERENCES = GenericPackage.CLASS__ALL_COMPOSITE_REFERENCES;

	/**
	 * The feature id for the '<em><b>All Cross References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__ALL_CROSS_REFERENCES = GenericPackage.CLASS__ALL_CROSS_REFERENCES;

	/**
	 * The number of structural features of the '<em>Section Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS_FEATURE_COUNT = GenericPackage.CLASS_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___GET_CONTAINING_SECTION = GenericPackage.CLASS___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___GET_CONTAINING_SECTION_MODEL = GenericPackage.CLASS___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___IS_LIBRARY_ENTRY = GenericPackage.CLASS___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Is Container For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___IS_CONTAINER_FOR__CLASS = GenericPackage.CLASS___IS_CONTAINER_FOR__CLASS;

	/**
	 * The operation id for the '<em>Is Contained In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___IS_CONTAINED_IN__CLASS = GenericPackage.CLASS___IS_CONTAINED_IN__CLASS;

	/**
	 * The operation id for the '<em>Get Owning Containment Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___GET_OWNING_CONTAINMENT_REFERENCE = GenericPackage.CLASS___GET_OWNING_CONTAINMENT_REFERENCE;

	/**
	 * The operation id for the '<em>Is Referenced By</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___IS_REFERENCED_BY__CLASS_ELIST = GenericPackage.CLASS___IS_REFERENCED_BY__CLASS_ELIST;

	/**
	 * The operation id for the '<em>Validate EClass Matches Parent EReference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP = GenericPackage.CLASS___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Cardinality Is Valid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP = GenericPackage.CLASS___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Container Is Valid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP = GenericPackage.CLASS___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Not Self Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___VALIDATE_NOT_SELF_CONTAINER__DIAGNOSTICCHAIN_MAP = GenericPackage.CLASS___VALIDATE_NOT_SELF_CONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Only Complementing Actual References</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___VALIDATE_ONLY_COMPLEMENTING_ACTUAL_REFERENCES__DIAGNOSTICCHAIN_MAP = GenericPackage.CLASS___VALIDATE_ONLY_COMPLEMENTING_ACTUAL_REFERENCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Section Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS_OPERATION_COUNT = GenericPackage.CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.target.impl.TargetSectionImpl <em>Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.target.impl.TargetSectionImpl
	 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSection()
	 * @generated
	 */
	int TARGET_SECTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__NAME = TARGET_SECTION_CLASS__NAME;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__ECLASS = TARGET_SECTION_CLASS__ECLASS;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__CARDINALITY = TARGET_SECTION_CLASS__CARDINALITY;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__REFERENCES = TARGET_SECTION_CLASS__REFERENCES;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__CONTAINER = TARGET_SECTION_CLASS__CONTAINER;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__ATTRIBUTES = TARGET_SECTION_CLASS__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>All Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__ALL_CONTAINER = TARGET_SECTION_CLASS__ALL_CONTAINER;

	/**
	 * The feature id for the '<em><b>Actual Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__ACTUAL_ATTRIBUTES = TARGET_SECTION_CLASS__ACTUAL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Virtual Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__VIRTUAL_ATTRIBUTES = TARGET_SECTION_CLASS__VIRTUAL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Actual References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__ACTUAL_REFERENCES = TARGET_SECTION_CLASS__ACTUAL_REFERENCES;

	/**
	 * The feature id for the '<em><b>Virtual References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__VIRTUAL_REFERENCES = TARGET_SECTION_CLASS__VIRTUAL_REFERENCES;

	/**
	 * The feature id for the '<em><b>All Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__ALL_ATTRIBUTES = TARGET_SECTION_CLASS__ALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>All References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__ALL_REFERENCES = TARGET_SECTION_CLASS__ALL_REFERENCES;

	/**
	 * The feature id for the '<em><b>All Concrete Extending</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__ALL_CONCRETE_EXTENDING = TARGET_SECTION_CLASS__ALL_CONCRETE_EXTENDING;

	/**
	 * The feature id for the '<em><b>All Composite References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__ALL_COMPOSITE_REFERENCES = TARGET_SECTION_CLASS__ALL_COMPOSITE_REFERENCES;

	/**
	 * The feature id for the '<em><b>All Cross References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__ALL_CROSS_REFERENCES = TARGET_SECTION_CLASS__ALL_CROSS_REFERENCES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__ABSTRACT = TARGET_SECTION_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extend</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__EXTEND = TARGET_SECTION_CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Extend</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__ALL_EXTEND = TARGET_SECTION_CLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>All Extending</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__ALL_EXTENDING = TARGET_SECTION_CLASS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Referencing Mapping Hint Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS = TARGET_SECTION_CLASS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>File</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__FILE = TARGET_SECTION_CLASS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_FEATURE_COUNT = TARGET_SECTION_CLASS_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___GET_CONTAINING_SECTION = TARGET_SECTION_CLASS___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___GET_CONTAINING_SECTION_MODEL = TARGET_SECTION_CLASS___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___IS_LIBRARY_ENTRY = TARGET_SECTION_CLASS___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Is Container For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___IS_CONTAINER_FOR__CLASS = TARGET_SECTION_CLASS___IS_CONTAINER_FOR__CLASS;

	/**
	 * The operation id for the '<em>Is Contained In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___IS_CONTAINED_IN__CLASS = TARGET_SECTION_CLASS___IS_CONTAINED_IN__CLASS;

	/**
	 * The operation id for the '<em>Get Owning Containment Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___GET_OWNING_CONTAINMENT_REFERENCE = TARGET_SECTION_CLASS___GET_OWNING_CONTAINMENT_REFERENCE;

	/**
	 * The operation id for the '<em>Is Referenced By</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___IS_REFERENCED_BY__CLASS_ELIST = TARGET_SECTION_CLASS___IS_REFERENCED_BY__CLASS_ELIST;

	/**
	 * The operation id for the '<em>Validate EClass Matches Parent EReference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP = TARGET_SECTION_CLASS___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Cardinality Is Valid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP = TARGET_SECTION_CLASS___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Container Is Valid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP = TARGET_SECTION_CLASS___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Not Self Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___VALIDATE_NOT_SELF_CONTAINER__DIAGNOSTICCHAIN_MAP = TARGET_SECTION_CLASS___VALIDATE_NOT_SELF_CONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Only Complementing Actual References</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___VALIDATE_ONLY_COMPLEMENTING_ACTUAL_REFERENCES__DIAGNOSTICCHAIN_MAP = TARGET_SECTION_CLASS___VALIDATE_ONLY_COMPLEMENTING_ACTUAL_REFERENCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Container Matches Extend Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP = TARGET_SECTION_CLASS_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Extends Valid Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___VALIDATE_EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP = TARGET_SECTION_CLASS_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Not Extend Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___VALIDATE_NOT_EXTEND_SELF__DIAGNOSTICCHAIN_MAP = TARGET_SECTION_CLASS_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Is Referenced By Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___VALIDATE_IS_REFERENCED_BY_MAPPING_HINT_GROUP__DIAGNOSTICCHAIN_MAP = TARGET_SECTION_CLASS_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate Cardinality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___VALIDATE_CARDINALITY__DIAGNOSTICCHAIN_MAP = TARGET_SECTION_CLASS_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_OPERATION_COUNT = TARGET_SECTION_CLASS_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link pamtram.structure.target.impl.TargetSectionAttributeImpl <em>Section Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.target.impl.TargetSectionAttributeImpl
	 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSectionAttribute()
	 * @generated
	 */
	int TARGET_SECTION_ATTRIBUTE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE__NAME = GenericPackage.ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE__OWNING_CLASS = GenericPackage.ATTRIBUTE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE__UNIQUE = GenericPackage.ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE__VALUE = GenericPackage.ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE_FEATURE_COUNT = GenericPackage.ATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION = GenericPackage.ATTRIBUTE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL = GenericPackage.ATTRIBUTE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE___IS_LIBRARY_ENTRY = GenericPackage.ATTRIBUTE___IS_LIBRARY_ENTRY;

	/**
	 * The number of operations of the '<em>Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE_OPERATION_COUNT = GenericPackage.ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.target.impl.VirtualTargetSectionAttributeImpl <em>Virtual Target Section Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.target.impl.VirtualTargetSectionAttributeImpl
	 * @see pamtram.structure.target.impl.TargetPackageImpl#getVirtualTargetSectionAttribute()
	 * @generated
	 */
	int VIRTUAL_TARGET_SECTION_ATTRIBUTE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_TARGET_SECTION_ATTRIBUTE__NAME = TARGET_SECTION_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_TARGET_SECTION_ATTRIBUTE__OWNING_CLASS = TARGET_SECTION_ATTRIBUTE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_TARGET_SECTION_ATTRIBUTE__UNIQUE = TARGET_SECTION_ATTRIBUTE__UNIQUE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_TARGET_SECTION_ATTRIBUTE__VALUE = TARGET_SECTION_ATTRIBUTE__VALUE;

	/**
	 * The number of structural features of the '<em>Virtual Target Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_TARGET_SECTION_ATTRIBUTE_FEATURE_COUNT = TARGET_SECTION_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION = TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL = TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_TARGET_SECTION_ATTRIBUTE___IS_LIBRARY_ENTRY = TARGET_SECTION_ATTRIBUTE___IS_LIBRARY_ENTRY;

	/**
	 * The number of operations of the '<em>Virtual Target Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_TARGET_SECTION_ATTRIBUTE_OPERATION_COUNT = TARGET_SECTION_ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.target.impl.FileAttributeImpl <em>File Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.target.impl.FileAttributeImpl
	 * @see pamtram.structure.target.impl.TargetPackageImpl#getFileAttribute()
	 * @generated
	 */
	int FILE_ATTRIBUTE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTRIBUTE__NAME = VIRTUAL_TARGET_SECTION_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTRIBUTE__OWNING_CLASS = VIRTUAL_TARGET_SECTION_ATTRIBUTE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTRIBUTE__UNIQUE = VIRTUAL_TARGET_SECTION_ATTRIBUTE__UNIQUE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTRIBUTE__VALUE = VIRTUAL_TARGET_SECTION_ATTRIBUTE__VALUE;

	/**
	 * The feature id for the '<em><b>File Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTRIBUTE__FILE_TYPE = VIRTUAL_TARGET_SECTION_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTRIBUTE_FEATURE_COUNT = VIRTUAL_TARGET_SECTION_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTRIBUTE___GET_CONTAINING_SECTION = VIRTUAL_TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL = VIRTUAL_TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTRIBUTE___IS_LIBRARY_ENTRY = VIRTUAL_TARGET_SECTION_ATTRIBUTE___IS_LIBRARY_ENTRY;

	/**
	 * The number of operations of the '<em>File Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTRIBUTE_OPERATION_COUNT = VIRTUAL_TARGET_SECTION_ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.target.impl.TargetSectionReferenceImpl <em>Section Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.target.impl.TargetSectionReferenceImpl
	 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSectionReference()
	 * @generated
	 */
	int TARGET_SECTION_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE__NAME = GenericPackage.REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE__OWNING_CLASS = GenericPackage.REFERENCE__OWNING_CLASS;

	/**
	 * The number of structural features of the '<em>Section Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE_FEATURE_COUNT = GenericPackage.REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE___GET_CONTAINING_SECTION = GenericPackage.REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE___GET_CONTAINING_SECTION_MODEL = GenericPackage.REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE___IS_LIBRARY_ENTRY = GenericPackage.REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE___GET_VALUES_GENERIC = GenericPackage.REFERENCE___GET_VALUES_GENERIC;

	/**
	 * The operation id for the '<em>Add Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE___ADD_VALUES_GENERIC__ELIST = GenericPackage.REFERENCE___ADD_VALUES_GENERIC__ELIST;

	/**
	 * The operation id for the '<em>Is Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE___IS_EXTENDED = GenericPackage.REFERENCE___IS_EXTENDED;

	/**
	 * The operation id for the '<em>Get Values Including Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE___GET_VALUES_INCLUDING_EXTENDED = GenericPackage.REFERENCE___GET_VALUES_INCLUDING_EXTENDED;

	/**
	 * The number of operations of the '<em>Section Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE_OPERATION_COUNT = GenericPackage.REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.target.impl.TargetSectionCompositeReferenceImpl <em>Section Composite Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.target.impl.TargetSectionCompositeReferenceImpl
	 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSectionCompositeReference()
	 * @generated
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE__NAME = GenericPackage.COMPOSITE_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE__OWNING_CLASS = GenericPackage.COMPOSITE_REFERENCE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE__VALUE = GenericPackage.COMPOSITE_REFERENCE__VALUE;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE__EREFERENCE = GenericPackage.COMPOSITE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Section Composite Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE_FEATURE_COUNT = GenericPackage.COMPOSITE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE___GET_CONTAINING_SECTION = GenericPackage.COMPOSITE_REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE___GET_CONTAINING_SECTION_MODEL = GenericPackage.COMPOSITE_REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE___IS_LIBRARY_ENTRY = GenericPackage.COMPOSITE_REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE___GET_VALUES_GENERIC = GenericPackage.COMPOSITE_REFERENCE___GET_VALUES_GENERIC;

	/**
	 * The operation id for the '<em>Add Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE___ADD_VALUES_GENERIC__ELIST = GenericPackage.COMPOSITE_REFERENCE___ADD_VALUES_GENERIC__ELIST;

	/**
	 * The operation id for the '<em>Is Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE___IS_EXTENDED = GenericPackage.COMPOSITE_REFERENCE___IS_EXTENDED;

	/**
	 * The operation id for the '<em>Get Values Including Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE___GET_VALUES_INCLUDING_EXTENDED = GenericPackage.COMPOSITE_REFERENCE___GET_VALUES_INCLUDING_EXTENDED;

	/**
	 * The operation id for the '<em>Validate EReference Is Containment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_IS_CONTAINMENT__DIAGNOSTICCHAIN_MAP = GenericPackage.COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_IS_CONTAINMENT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate EReference Matches Parent EClass</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP = GenericPackage.COMPOSITE_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Section Composite Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE_OPERATION_COUNT = GenericPackage.COMPOSITE_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.target.impl.TargetSectionAnyContentCompositeReferenceImpl <em>Section Any Content Composite Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.target.impl.TargetSectionAnyContentCompositeReferenceImpl
	 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSectionAnyContentCompositeReference()
	 * @generated
	 */
	int TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE__NAME = GenericPackage.COMPOSITE_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE__OWNING_CLASS = GenericPackage.COMPOSITE_REFERENCE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE__VALUE = GenericPackage.COMPOSITE_REFERENCE__VALUE;

	/**
	 * The number of structural features of the '<em>Section Any Content Composite Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE_FEATURE_COUNT = GenericPackage.COMPOSITE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE___GET_CONTAINING_SECTION = GenericPackage.COMPOSITE_REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE___GET_CONTAINING_SECTION_MODEL = GenericPackage.COMPOSITE_REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE___IS_LIBRARY_ENTRY = GenericPackage.COMPOSITE_REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE___GET_VALUES_GENERIC = GenericPackage.COMPOSITE_REFERENCE___GET_VALUES_GENERIC;

	/**
	 * The operation id for the '<em>Add Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE___ADD_VALUES_GENERIC__ELIST = GenericPackage.COMPOSITE_REFERENCE___ADD_VALUES_GENERIC__ELIST;

	/**
	 * The operation id for the '<em>Is Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE___IS_EXTENDED = GenericPackage.COMPOSITE_REFERENCE___IS_EXTENDED;

	/**
	 * The operation id for the '<em>Get Values Including Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE___GET_VALUES_INCLUDING_EXTENDED = GenericPackage.COMPOSITE_REFERENCE___GET_VALUES_INCLUDING_EXTENDED;

	/**
	 * The operation id for the '<em>Validate EReference Is Containment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_IS_CONTAINMENT__DIAGNOSTICCHAIN_MAP = GenericPackage.COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_IS_CONTAINMENT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Is Allowed</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE___VALIDATE_IS_ALLOWED__DIAGNOSTICCHAIN_MAP = GenericPackage.COMPOSITE_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Section Any Content Composite Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE_OPERATION_COUNT = GenericPackage.COMPOSITE_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.target.impl.TargetSectionCrossReferenceImpl <em>Section Cross Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.target.impl.TargetSectionCrossReferenceImpl
	 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSectionCrossReference()
	 * @generated
	 */
	int TARGET_SECTION_CROSS_REFERENCE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE__NAME = GenericPackage.CROSS_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE__OWNING_CLASS = GenericPackage.CROSS_REFERENCE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE__VALUE = GenericPackage.CROSS_REFERENCE__VALUE;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE__EREFERENCE = GenericPackage.CROSS_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Section Cross Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE_FEATURE_COUNT = GenericPackage.CROSS_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE___GET_CONTAINING_SECTION = GenericPackage.CROSS_REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE___GET_CONTAINING_SECTION_MODEL = GenericPackage.CROSS_REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE___IS_LIBRARY_ENTRY = GenericPackage.CROSS_REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE___GET_VALUES_GENERIC = GenericPackage.CROSS_REFERENCE___GET_VALUES_GENERIC;

	/**
	 * The operation id for the '<em>Add Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE___ADD_VALUES_GENERIC__ELIST = GenericPackage.CROSS_REFERENCE___ADD_VALUES_GENERIC__ELIST;

	/**
	 * The operation id for the '<em>Is Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE___IS_EXTENDED = GenericPackage.CROSS_REFERENCE___IS_EXTENDED;

	/**
	 * The operation id for the '<em>Get Values Including Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE___GET_VALUES_INCLUDING_EXTENDED = GenericPackage.CROSS_REFERENCE___GET_VALUES_INCLUDING_EXTENDED;

	/**
	 * The operation id for the '<em>Validate Values Match Reference Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE___VALIDATE_VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP = GenericPackage.CROSS_REFERENCE___VALIDATE_VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate EReference Matches Parent EClass</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP = GenericPackage.CROSS_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate EReference Is Non Containment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE___VALIDATE_EREFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP = GenericPackage.CROSS_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Section Cross Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE_OPERATION_COUNT = GenericPackage.CROSS_REFERENCE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.structure.target.impl.TargetSectionAnyContentCrossReferenceImpl <em>Section Any Content Cross Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.target.impl.TargetSectionAnyContentCrossReferenceImpl
	 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSectionAnyContentCrossReference()
	 * @generated
	 */
	int TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE__NAME = GenericPackage.CROSS_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE__OWNING_CLASS = GenericPackage.CROSS_REFERENCE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE__VALUE = GenericPackage.CROSS_REFERENCE__VALUE;

	/**
	 * The number of structural features of the '<em>Section Any Content Cross Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE_FEATURE_COUNT = GenericPackage.CROSS_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE___GET_CONTAINING_SECTION = GenericPackage.CROSS_REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE___GET_CONTAINING_SECTION_MODEL = GenericPackage.CROSS_REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE___IS_LIBRARY_ENTRY = GenericPackage.CROSS_REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE___GET_VALUES_GENERIC = GenericPackage.CROSS_REFERENCE___GET_VALUES_GENERIC;

	/**
	 * The operation id for the '<em>Add Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE___ADD_VALUES_GENERIC__ELIST = GenericPackage.CROSS_REFERENCE___ADD_VALUES_GENERIC__ELIST;

	/**
	 * The operation id for the '<em>Is Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE___IS_EXTENDED = GenericPackage.CROSS_REFERENCE___IS_EXTENDED;

	/**
	 * The operation id for the '<em>Get Values Including Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE___GET_VALUES_INCLUDING_EXTENDED = GenericPackage.CROSS_REFERENCE___GET_VALUES_INCLUDING_EXTENDED;

	/**
	 * The operation id for the '<em>Validate Values Match Reference Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE___VALIDATE_VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP = GenericPackage.CROSS_REFERENCE___VALIDATE_VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Is Allowed</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE___VALIDATE_IS_ALLOWED__DIAGNOSTICCHAIN_MAP = GenericPackage.CROSS_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Section Any Content Cross Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE_OPERATION_COUNT = GenericPackage.CROSS_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.target.impl.ActualTargetSectionAttributeImpl <em>Actual Target Section Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.target.impl.ActualTargetSectionAttributeImpl
	 * @see pamtram.structure.target.impl.TargetPackageImpl#getActualTargetSectionAttribute()
	 * @generated
	 */
	int ACTUAL_TARGET_SECTION_ATTRIBUTE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_TARGET_SECTION_ATTRIBUTE__NAME = TARGET_SECTION_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_TARGET_SECTION_ATTRIBUTE__OWNING_CLASS = TARGET_SECTION_ATTRIBUTE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_TARGET_SECTION_ATTRIBUTE__UNIQUE = TARGET_SECTION_ATTRIBUTE__UNIQUE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_TARGET_SECTION_ATTRIBUTE__VALUE = TARGET_SECTION_ATTRIBUTE__VALUE;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_TARGET_SECTION_ATTRIBUTE__ATTRIBUTE = TARGET_SECTION_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Actual Target Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_TARGET_SECTION_ATTRIBUTE_FEATURE_COUNT = TARGET_SECTION_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION = TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL = TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_TARGET_SECTION_ATTRIBUTE___IS_LIBRARY_ENTRY = TARGET_SECTION_ATTRIBUTE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Validate Attribute Matches Parent EClass</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_TARGET_SECTION_ATTRIBUTE___VALIDATE_ATTRIBUTE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP = TARGET_SECTION_ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Actual Target Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_TARGET_SECTION_ATTRIBUTE_OPERATION_COUNT = TARGET_SECTION_ATTRIBUTE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.target.FileType <em>File Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.target.FileType
	 * @see pamtram.structure.target.impl.TargetPackageImpl#getFileType()
	 * @generated
	 */
	int FILE_TYPE = 11;


	/**
	 * Returns the meta object for class '{@link pamtram.structure.target.TargetSection <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section</em>'.
	 * @see pamtram.structure.target.TargetSection
	 * @generated
	 */
	EClass getTargetSection();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.structure.target.TargetSection#getReferencingMappingHintGroups <em>Referencing Mapping Hint Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referencing Mapping Hint Groups</em>'.
	 * @see pamtram.structure.target.TargetSection#getReferencingMappingHintGroups()
	 * @see #getTargetSection()
	 * @generated
	 */
	EReference getTargetSection_ReferencingMappingHintGroups();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.target.TargetSection#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>File</em>'.
	 * @see pamtram.structure.target.TargetSection#getFile()
	 * @see #getTargetSection()
	 * @generated
	 */
	EReference getTargetSection_File();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.target.TargetSection#validateIsReferencedByMappingHintGroup(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Is Referenced By Mapping Hint Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Is Referenced By Mapping Hint Group</em>' operation.
	 * @see pamtram.structure.target.TargetSection#validateIsReferencedByMappingHintGroup(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTargetSection__ValidateIsReferencedByMappingHintGroup__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.target.TargetSection#validateCardinality(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Cardinality</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Cardinality</em>' operation.
	 * @see pamtram.structure.target.TargetSection#validateCardinality(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTargetSection__ValidateCardinality__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.target.FileAttribute <em>File Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Attribute</em>'.
	 * @see pamtram.structure.target.FileAttribute
	 * @generated
	 */
	EClass getFileAttribute();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.target.FileAttribute#getFileType <em>File Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Type</em>'.
	 * @see pamtram.structure.target.FileAttribute#getFileType()
	 * @see #getFileAttribute()
	 * @generated
	 */
	EAttribute getFileAttribute_FileType();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.target.TargetSectionClass <em>Section Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Class</em>'.
	 * @see pamtram.structure.target.TargetSectionClass
	 * @generated
	 */
	EClass getTargetSectionClass();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.target.TargetSectionReference <em>Section Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Reference</em>'.
	 * @see pamtram.structure.target.TargetSectionReference
	 * @generated
	 */
	EClass getTargetSectionReference();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.target.TargetSectionCompositeReference <em>Section Composite Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Composite Reference</em>'.
	 * @see pamtram.structure.target.TargetSectionCompositeReference
	 * @generated
	 */
	EClass getTargetSectionCompositeReference();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.target.TargetSectionAnyContentCompositeReference <em>Section Any Content Composite Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Any Content Composite Reference</em>'.
	 * @see pamtram.structure.target.TargetSectionAnyContentCompositeReference
	 * @generated
	 */
	EClass getTargetSectionAnyContentCompositeReference();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.target.TargetSectionAnyContentCompositeReference#validateIsAllowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Is Allowed</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Is Allowed</em>' operation.
	 * @see pamtram.structure.target.TargetSectionAnyContentCompositeReference#validateIsAllowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTargetSectionAnyContentCompositeReference__ValidateIsAllowed__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.target.TargetSectionCrossReference <em>Section Cross Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Cross Reference</em>'.
	 * @see pamtram.structure.target.TargetSectionCrossReference
	 * @generated
	 */
	EClass getTargetSectionCrossReference();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.target.TargetSectionCrossReference#validateEReferenceIsNonContainment(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate EReference Is Non Containment</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate EReference Is Non Containment</em>' operation.
	 * @see pamtram.structure.target.TargetSectionCrossReference#validateEReferenceIsNonContainment(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTargetSectionCrossReference__ValidateEReferenceIsNonContainment__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.target.TargetSectionAnyContentCrossReference <em>Section Any Content Cross Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Any Content Cross Reference</em>'.
	 * @see pamtram.structure.target.TargetSectionAnyContentCrossReference
	 * @generated
	 */
	EClass getTargetSectionAnyContentCrossReference();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.target.TargetSectionAnyContentCrossReference#validateIsAllowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Is Allowed</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Is Allowed</em>' operation.
	 * @see pamtram.structure.target.TargetSectionAnyContentCrossReference#validateIsAllowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTargetSectionAnyContentCrossReference__ValidateIsAllowed__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.target.TargetSectionAttribute <em>Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Attribute</em>'.
	 * @see pamtram.structure.target.TargetSectionAttribute
	 * @generated
	 */
	EClass getTargetSectionAttribute();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.target.TargetSectionAttribute#isUnique <em>Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unique</em>'.
	 * @see pamtram.structure.target.TargetSectionAttribute#isUnique()
	 * @see #getTargetSectionAttribute()
	 * @generated
	 */
	EAttribute getTargetSectionAttribute_Unique();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.target.TargetSectionAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see pamtram.structure.target.TargetSectionAttribute#getValue()
	 * @see #getTargetSectionAttribute()
	 * @generated
	 */
	EAttribute getTargetSectionAttribute_Value();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.target.ActualTargetSectionAttribute <em>Actual Target Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actual Target Section Attribute</em>'.
	 * @see pamtram.structure.target.ActualTargetSectionAttribute
	 * @generated
	 */
	EClass getActualTargetSectionAttribute();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.target.VirtualTargetSectionAttribute <em>Virtual Target Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Target Section Attribute</em>'.
	 * @see pamtram.structure.target.VirtualTargetSectionAttribute
	 * @generated
	 */
	EClass getVirtualTargetSectionAttribute();

	/**
	 * Returns the meta object for enum '{@link pamtram.structure.target.FileType <em>File Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>File Type</em>'.
	 * @see pamtram.structure.target.FileType
	 * @generated
	 */
	EEnum getFileType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TargetFactory getTargetFactory();

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
		 * The meta object literal for the '{@link pamtram.structure.target.impl.TargetSectionImpl <em>Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.target.impl.TargetSectionImpl
		 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSection()
		 * @generated
		 */
		EClass TARGET_SECTION = eINSTANCE.getTargetSection();

		/**
		 * The meta object literal for the '<em><b>Referencing Mapping Hint Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS = eINSTANCE.getTargetSection_ReferencingMappingHintGroups();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_SECTION__FILE = eINSTANCE.getTargetSection_File();

		/**
		 * The meta object literal for the '<em><b>Validate Is Referenced By Mapping Hint Group</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TARGET_SECTION___VALIDATE_IS_REFERENCED_BY_MAPPING_HINT_GROUP__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTargetSection__ValidateIsReferencedByMappingHintGroup__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Cardinality</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TARGET_SECTION___VALIDATE_CARDINALITY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTargetSection__ValidateCardinality__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.target.impl.FileAttributeImpl <em>File Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.target.impl.FileAttributeImpl
		 * @see pamtram.structure.target.impl.TargetPackageImpl#getFileAttribute()
		 * @generated
		 */
		EClass FILE_ATTRIBUTE = eINSTANCE.getFileAttribute();

		/**
		 * The meta object literal for the '<em><b>File Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_ATTRIBUTE__FILE_TYPE = eINSTANCE.getFileAttribute_FileType();

		/**
		 * The meta object literal for the '{@link pamtram.structure.target.impl.TargetSectionClassImpl <em>Section Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.target.impl.TargetSectionClassImpl
		 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSectionClass()
		 * @generated
		 */
		EClass TARGET_SECTION_CLASS = eINSTANCE.getTargetSectionClass();

		/**
		 * The meta object literal for the '{@link pamtram.structure.target.impl.TargetSectionReferenceImpl <em>Section Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.target.impl.TargetSectionReferenceImpl
		 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSectionReference()
		 * @generated
		 */
		EClass TARGET_SECTION_REFERENCE = eINSTANCE.getTargetSectionReference();

		/**
		 * The meta object literal for the '{@link pamtram.structure.target.impl.TargetSectionCompositeReferenceImpl <em>Section Composite Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.target.impl.TargetSectionCompositeReferenceImpl
		 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSectionCompositeReference()
		 * @generated
		 */
		EClass TARGET_SECTION_COMPOSITE_REFERENCE = eINSTANCE.getTargetSectionCompositeReference();

		/**
		 * The meta object literal for the '{@link pamtram.structure.target.impl.TargetSectionAnyContentCompositeReferenceImpl <em>Section Any Content Composite Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.target.impl.TargetSectionAnyContentCompositeReferenceImpl
		 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSectionAnyContentCompositeReference()
		 * @generated
		 */
		EClass TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE = eINSTANCE.getTargetSectionAnyContentCompositeReference();

		/**
		 * The meta object literal for the '<em><b>Validate Is Allowed</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE___VALIDATE_IS_ALLOWED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTargetSectionAnyContentCompositeReference__ValidateIsAllowed__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.target.impl.TargetSectionCrossReferenceImpl <em>Section Cross Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.target.impl.TargetSectionCrossReferenceImpl
		 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSectionCrossReference()
		 * @generated
		 */
		EClass TARGET_SECTION_CROSS_REFERENCE = eINSTANCE.getTargetSectionCrossReference();

		/**
		 * The meta object literal for the '<em><b>Validate EReference Is Non Containment</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TARGET_SECTION_CROSS_REFERENCE___VALIDATE_EREFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTargetSectionCrossReference__ValidateEReferenceIsNonContainment__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.target.impl.TargetSectionAnyContentCrossReferenceImpl <em>Section Any Content Cross Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.target.impl.TargetSectionAnyContentCrossReferenceImpl
		 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSectionAnyContentCrossReference()
		 * @generated
		 */
		EClass TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE = eINSTANCE.getTargetSectionAnyContentCrossReference();

		/**
		 * The meta object literal for the '<em><b>Validate Is Allowed</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE___VALIDATE_IS_ALLOWED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTargetSectionAnyContentCrossReference__ValidateIsAllowed__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.target.impl.TargetSectionAttributeImpl <em>Section Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.target.impl.TargetSectionAttributeImpl
		 * @see pamtram.structure.target.impl.TargetPackageImpl#getTargetSectionAttribute()
		 * @generated
		 */
		EClass TARGET_SECTION_ATTRIBUTE = eINSTANCE.getTargetSectionAttribute();

		/**
		 * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_SECTION_ATTRIBUTE__UNIQUE = eINSTANCE.getTargetSectionAttribute_Unique();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_SECTION_ATTRIBUTE__VALUE = eINSTANCE.getTargetSectionAttribute_Value();

		/**
		 * The meta object literal for the '{@link pamtram.structure.target.impl.ActualTargetSectionAttributeImpl <em>Actual Target Section Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.target.impl.ActualTargetSectionAttributeImpl
		 * @see pamtram.structure.target.impl.TargetPackageImpl#getActualTargetSectionAttribute()
		 * @generated
		 */
		EClass ACTUAL_TARGET_SECTION_ATTRIBUTE = eINSTANCE.getActualTargetSectionAttribute();

		/**
		 * The meta object literal for the '{@link pamtram.structure.target.impl.VirtualTargetSectionAttributeImpl <em>Virtual Target Section Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.target.impl.VirtualTargetSectionAttributeImpl
		 * @see pamtram.structure.target.impl.TargetPackageImpl#getVirtualTargetSectionAttribute()
		 * @generated
		 */
		EClass VIRTUAL_TARGET_SECTION_ATTRIBUTE = eINSTANCE.getVirtualTargetSectionAttribute();

		/**
		 * The meta object literal for the '{@link pamtram.structure.target.FileType <em>File Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.target.FileType
		 * @see pamtram.structure.target.impl.TargetPackageImpl#getFileType()
		 * @generated
		 */
		EEnum FILE_TYPE = eINSTANCE.getFileType();

	}

} //TargetPackage
