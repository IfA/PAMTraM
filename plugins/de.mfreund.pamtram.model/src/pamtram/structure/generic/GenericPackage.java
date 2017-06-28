/**
 */
package pamtram.structure.generic;

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
 * This package contains all elements related to the generic description of element structures.
 * <br />
 * Element structures are always based on a specific metamodel but may impose further restrictions. For example, one may describe a structure containing of an element (Class) which holds exactly one element (Class) via a certain reference (Reference), although the metamodel allows for an unlimited number of elements referenced via this reference. Another example is the description of certain constraints for values of attributes (Attribute).
 * <!-- end-model-doc -->
 * @see pamtram.structure.generic.GenericFactory
 * @model kind="package"
 * @generated
 */
public interface GenericPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "generic";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mfreund.de/pamtram/structure/generic";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "generic";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GenericPackage eINSTANCE = pamtram.structure.generic.impl.GenericPackageImpl.init();

	/**
	 * The meta object id for the '{@link pamtram.structure.generic.impl.MetaModelElementImpl <em>Meta Model Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.generic.impl.MetaModelElementImpl
	 * @see pamtram.structure.generic.impl.GenericPackageImpl#getMetaModelElement()
	 * @generated
	 */
	int META_MODEL_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_ELEMENT__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Meta Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_ELEMENT_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_ELEMENT___GET_CONTAINING_SECTION = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_ELEMENT___GET_CONTAINING_SECTION_MODEL = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_ELEMENT___IS_LIBRARY_ENTRY = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Meta Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_ELEMENT_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link pamtram.structure.generic.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.generic.impl.ClassImpl
	 * @see pamtram.structure.generic.impl.GenericPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = META_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ECLASS = META_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CARDINALITY = META_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__REFERENCES = META_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CONTAINER = META_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ATTRIBUTES = META_MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>All Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ALL_CONTAINER = META_MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = META_MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___GET_CONTAINING_SECTION = META_MODEL_ELEMENT___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___GET_CONTAINING_SECTION_MODEL = META_MODEL_ELEMENT___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_LIBRARY_ENTRY = META_MODEL_ELEMENT___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Is Container For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_CONTAINER_FOR__CLASS = META_MODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Contained In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_CONTAINED_IN__CLASS = META_MODEL_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Owning Containment Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___GET_OWNING_CONTAINMENT_REFERENCE = META_MODEL_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Referenced By</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_REFERENCED_BY__CLASS_ELIST = META_MODEL_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate EClass Matches Parent EReference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP = META_MODEL_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate Cardinality Is Valid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP = META_MODEL_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Validate Container Is Valid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP = META_MODEL_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = META_MODEL_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The meta object id for the '{@link pamtram.structure.generic.impl.SectionImpl <em>Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.generic.impl.SectionImpl
	 * @see pamtram.structure.generic.impl.GenericPackageImpl#getSection()
	 * @generated
	 */
	int SECTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__ECLASS = CLASS__ECLASS;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__CARDINALITY = CLASS__CARDINALITY;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__REFERENCES = CLASS__REFERENCES;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__CONTAINER = CLASS__CONTAINER;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__ATTRIBUTES = CLASS__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>All Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__ALL_CONTAINER = CLASS__ALL_CONTAINER;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__ABSTRACT = CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extend</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__EXTEND = CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Extend</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__ALL_EXTEND = CLASS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_FEATURE_COUNT = CLASS_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION___GET_CONTAINING_SECTION = CLASS___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION___GET_CONTAINING_SECTION_MODEL = CLASS___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION___IS_LIBRARY_ENTRY = CLASS___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Is Container For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION___IS_CONTAINER_FOR__CLASS = CLASS___IS_CONTAINER_FOR__CLASS;

	/**
	 * The operation id for the '<em>Is Contained In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION___IS_CONTAINED_IN__CLASS = CLASS___IS_CONTAINED_IN__CLASS;

	/**
	 * The operation id for the '<em>Get Owning Containment Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION___GET_OWNING_CONTAINMENT_REFERENCE = CLASS___GET_OWNING_CONTAINMENT_REFERENCE;

	/**
	 * The operation id for the '<em>Is Referenced By</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION___IS_REFERENCED_BY__CLASS_ELIST = CLASS___IS_REFERENCED_BY__CLASS_ELIST;

	/**
	 * The operation id for the '<em>Validate EClass Matches Parent EReference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP = CLASS___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Cardinality Is Valid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP = CLASS___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Container Is Valid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP = CLASS___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Container Matches Extend Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION___VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP = CLASS_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Extends Valid Sections</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION___VALIDATE_EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP = CLASS_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_OPERATION_COUNT = CLASS_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.structure.generic.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.generic.impl.ReferenceImpl
	 * @see pamtram.structure.generic.impl.GenericPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__NAME = META_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__OWNING_CLASS = META_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = META_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE___GET_CONTAINING_SECTION = META_MODEL_ELEMENT___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE___GET_CONTAINING_SECTION_MODEL = META_MODEL_ELEMENT___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE___IS_LIBRARY_ENTRY = META_MODEL_ELEMENT___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE___GET_VALUES_GENERIC = META_MODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Add Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE___ADD_VALUES_GENERIC__ELIST = META_MODEL_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION_COUNT = META_MODEL_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link pamtram.structure.generic.impl.ActualReferenceImpl <em>Actual Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.generic.impl.ActualReferenceImpl
	 * @see pamtram.structure.generic.impl.GenericPackageImpl#getActualReference()
	 * @generated
	 */
	int ACTUAL_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_REFERENCE__NAME = REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_REFERENCE__OWNING_CLASS = REFERENCE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_REFERENCE__EREFERENCE = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Actual Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_REFERENCE___GET_CONTAINING_SECTION = REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_REFERENCE___GET_CONTAINING_SECTION_MODEL = REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_REFERENCE___IS_LIBRARY_ENTRY = REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_REFERENCE___GET_VALUES_GENERIC = REFERENCE___GET_VALUES_GENERIC;

	/**
	 * The operation id for the '<em>Add Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_REFERENCE___ADD_VALUES_GENERIC__ELIST = REFERENCE___ADD_VALUES_GENERIC__ELIST;

	/**
	 * The operation id for the '<em>Validate EReference Matches Parent EClass</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP = REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Actual Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_REFERENCE_OPERATION_COUNT = REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.generic.impl.VirtualReferenceImpl <em>Virtual Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.generic.impl.VirtualReferenceImpl
	 * @see pamtram.structure.generic.impl.GenericPackageImpl#getVirtualReference()
	 * @generated
	 */
	int VIRTUAL_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_REFERENCE__NAME = REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_REFERENCE__OWNING_CLASS = REFERENCE__OWNING_CLASS;

	/**
	 * The number of structural features of the '<em>Virtual Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_REFERENCE___GET_CONTAINING_SECTION = REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_REFERENCE___GET_CONTAINING_SECTION_MODEL = REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_REFERENCE___IS_LIBRARY_ENTRY = REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_REFERENCE___GET_VALUES_GENERIC = REFERENCE___GET_VALUES_GENERIC;

	/**
	 * The operation id for the '<em>Add Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_REFERENCE___ADD_VALUES_GENERIC__ELIST = REFERENCE___ADD_VALUES_GENERIC__ELIST;

	/**
	 * The number of operations of the '<em>Virtual Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_REFERENCE_OPERATION_COUNT = REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.generic.impl.CompositeReferenceImpl <em>Composite Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.generic.impl.CompositeReferenceImpl
	 * @see pamtram.structure.generic.impl.GenericPackageImpl#getCompositeReference()
	 * @generated
	 */
	int COMPOSITE_REFERENCE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE__NAME = REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE__OWNING_CLASS = REFERENCE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE__VALUE = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE___GET_CONTAINING_SECTION = REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE___GET_CONTAINING_SECTION_MODEL = REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE___IS_LIBRARY_ENTRY = REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE___GET_VALUES_GENERIC = REFERENCE___GET_VALUES_GENERIC;

	/**
	 * The operation id for the '<em>Add Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE___ADD_VALUES_GENERIC__ELIST = REFERENCE___ADD_VALUES_GENERIC__ELIST;

	/**
	 * The operation id for the '<em>Validate EReference Is Containment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_IS_CONTAINMENT__DIAGNOSTICCHAIN_MAP = REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Composite Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE_OPERATION_COUNT = REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.generic.impl.CrossReferenceImpl <em>Cross Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.generic.impl.CrossReferenceImpl
	 * @see pamtram.structure.generic.impl.GenericPackageImpl#getCrossReference()
	 * @generated
	 */
	int CROSS_REFERENCE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCE__NAME = REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCE__OWNING_CLASS = REFERENCE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCE__VALUE = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cross Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCE___GET_CONTAINING_SECTION = REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCE___GET_CONTAINING_SECTION_MODEL = REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCE___IS_LIBRARY_ENTRY = REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCE___GET_VALUES_GENERIC = REFERENCE___GET_VALUES_GENERIC;

	/**
	 * The operation id for the '<em>Add Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCE___ADD_VALUES_GENERIC__ELIST = REFERENCE___ADD_VALUES_GENERIC__ELIST;

	/**
	 * The operation id for the '<em>Validate Values Match Reference Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCE___VALIDATE_VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP = REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cross Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCE_OPERATION_COUNT = REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.generic.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.generic.impl.AttributeImpl
	 * @see pamtram.structure.generic.impl.GenericPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = META_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__OWNING_CLASS = META_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = META_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE___GET_CONTAINING_SECTION = META_MODEL_ELEMENT___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE___GET_CONTAINING_SECTION_MODEL = META_MODEL_ELEMENT___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE___IS_LIBRARY_ENTRY = META_MODEL_ELEMENT___IS_LIBRARY_ENTRY;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = META_MODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.generic.impl.ActualAttributeImpl <em>Actual Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.generic.impl.ActualAttributeImpl
	 * @see pamtram.structure.generic.impl.GenericPackageImpl#getActualAttribute()
	 * @generated
	 */
	int ACTUAL_ATTRIBUTE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE__OWNING_CLASS = ATTRIBUTE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE__ATTRIBUTE = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Actual Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE___GET_CONTAINING_SECTION = ATTRIBUTE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL = ATTRIBUTE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE___IS_LIBRARY_ENTRY = ATTRIBUTE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Validate Attribute Matches Parent EClass</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE___VALIDATE_ATTRIBUTE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP = ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Actual Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE_OPERATION_COUNT = ATTRIBUTE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.generic.impl.VirtualAttributeImpl <em>Virtual Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.generic.impl.VirtualAttributeImpl
	 * @see pamtram.structure.generic.impl.GenericPackageImpl#getVirtualAttribute()
	 * @generated
	 */
	int VIRTUAL_ATTRIBUTE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE__OWNING_CLASS = ATTRIBUTE__OWNING_CLASS;

	/**
	 * The number of structural features of the '<em>Virtual Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE___GET_CONTAINING_SECTION = ATTRIBUTE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL = ATTRIBUTE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE___IS_LIBRARY_ENTRY = ATTRIBUTE___IS_LIBRARY_ENTRY;

	/**
	 * The number of operations of the '<em>Virtual Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE_OPERATION_COUNT = ATTRIBUTE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link pamtram.structure.generic.CardinalityType <em>Cardinality Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.generic.CardinalityType
	 * @see pamtram.structure.generic.impl.GenericPackageImpl#getCardinalityType()
	 * @generated
	 */
	int CARDINALITY_TYPE = 11;


	/**
	 * Returns the meta object for class '{@link pamtram.structure.generic.MetaModelElement <em>Meta Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Model Element</em>'.
	 * @see pamtram.structure.generic.MetaModelElement
	 * @generated
	 */
	EClass getMetaModelElement();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.MetaModelElement#getContainingSection() <em>Get Containing Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Containing Section</em>' operation.
	 * @see pamtram.structure.generic.MetaModelElement#getContainingSection()
	 * @generated
	 */
	EOperation getMetaModelElement__GetContainingSection();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.MetaModelElement#getContainingSectionModel() <em>Get Containing Section Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Containing Section Model</em>' operation.
	 * @see pamtram.structure.generic.MetaModelElement#getContainingSectionModel()
	 * @generated
	 */
	EOperation getMetaModelElement__GetContainingSectionModel();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.MetaModelElement#isLibraryEntry() <em>Is Library Entry</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Library Entry</em>' operation.
	 * @see pamtram.structure.generic.MetaModelElement#isLibraryEntry()
	 * @generated
	 */
	EOperation getMetaModelElement__IsLibraryEntry();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.generic.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see pamtram.structure.generic.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.generic.Class#getEClass <em>EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EClass</em>'.
	 * @see pamtram.structure.generic.Class#getEClass()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_EClass();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.generic.Class#getCardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cardinality</em>'.
	 * @see pamtram.structure.generic.Class#getCardinality()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_Cardinality();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.structure.generic.Class#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see pamtram.structure.generic.Class#getReferences()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_References();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.generic.Class#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see pamtram.structure.generic.Class#getContainer()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Container();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.structure.generic.Class#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see pamtram.structure.generic.Class#getAttributes()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Attributes();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.structure.generic.Class#getAllContainer <em>All Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Container</em>'.
	 * @see pamtram.structure.generic.Class#getAllContainer()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_AllContainer();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.Class#isContainerFor(pamtram.structure.generic.Class) <em>Is Container For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Container For</em>' operation.
	 * @see pamtram.structure.generic.Class#isContainerFor(pamtram.structure.generic.Class)
	 * @generated
	 */
	EOperation getClass__IsContainerFor__Class();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.Class#isContainedIn(pamtram.structure.generic.Class) <em>Is Contained In</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Contained In</em>' operation.
	 * @see pamtram.structure.generic.Class#isContainedIn(pamtram.structure.generic.Class)
	 * @generated
	 */
	EOperation getClass__IsContainedIn__Class();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.Class#getOwningContainmentReference() <em>Get Owning Containment Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Owning Containment Reference</em>' operation.
	 * @see pamtram.structure.generic.Class#getOwningContainmentReference()
	 * @generated
	 */
	EOperation getClass__GetOwningContainmentReference();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.Class#isReferencedBy(pamtram.structure.generic.Class, org.eclipse.emf.common.util.EList) <em>Is Referenced By</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Referenced By</em>' operation.
	 * @see pamtram.structure.generic.Class#isReferencedBy(pamtram.structure.generic.Class, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getClass__IsReferencedBy__Class_EList();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.Class#validateEClassMatchesParentEReference(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate EClass Matches Parent EReference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate EClass Matches Parent EReference</em>' operation.
	 * @see pamtram.structure.generic.Class#validateEClassMatchesParentEReference(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getClass__ValidateEClassMatchesParentEReference__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.Class#validateCardinalityIsValid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Cardinality Is Valid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Cardinality Is Valid</em>' operation.
	 * @see pamtram.structure.generic.Class#validateCardinalityIsValid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getClass__ValidateCardinalityIsValid__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.Class#validateContainerIsValid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Container Is Valid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Container Is Valid</em>' operation.
	 * @see pamtram.structure.generic.Class#validateContainerIsValid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getClass__ValidateContainerIsValid__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.generic.Section <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section</em>'.
	 * @see pamtram.structure.generic.Section
	 * @generated
	 */
	EClass getSection();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.generic.Section#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see pamtram.structure.generic.Section#isAbstract()
	 * @see #getSection()
	 * @generated
	 */
	EAttribute getSection_Abstract();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.structure.generic.Section#getExtend <em>Extend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extend</em>'.
	 * @see pamtram.structure.generic.Section#getExtend()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Extend();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.structure.generic.Section#getAllExtend <em>All Extend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Extend</em>'.
	 * @see pamtram.structure.generic.Section#getAllExtend()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_AllExtend();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.Section#validateContainerMatchesExtendContainer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Container Matches Extend Container</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Container Matches Extend Container</em>' operation.
	 * @see pamtram.structure.generic.Section#validateContainerMatchesExtendContainer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSection__ValidateContainerMatchesExtendContainer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.Section#validateExtendsValidSections(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Extends Valid Sections</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Extends Valid Sections</em>' operation.
	 * @see pamtram.structure.generic.Section#validateExtendsValidSections(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSection__ValidateExtendsValidSections__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.generic.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see pamtram.structure.generic.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for the container reference '{@link pamtram.structure.generic.Reference#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see pamtram.structure.generic.Reference#getOwningClass()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_OwningClass();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.Reference#getValuesGeneric() <em>Get Values Generic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Values Generic</em>' operation.
	 * @see pamtram.structure.generic.Reference#getValuesGeneric()
	 * @generated
	 */
	EOperation getReference__GetValuesGeneric();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.Reference#addValuesGeneric(org.eclipse.emf.common.util.EList) <em>Add Values Generic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Values Generic</em>' operation.
	 * @see pamtram.structure.generic.Reference#addValuesGeneric(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getReference__AddValuesGeneric__EList();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.generic.ActualReference <em>Actual Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actual Reference</em>'.
	 * @see pamtram.structure.generic.ActualReference
	 * @generated
	 */
	EClass getActualReference();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.generic.ActualReference#getEReference <em>EReference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EReference</em>'.
	 * @see pamtram.structure.generic.ActualReference#getEReference()
	 * @see #getActualReference()
	 * @generated
	 */
	EReference getActualReference_EReference();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.ActualReference#validateEReferenceMatchesParentEClass(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate EReference Matches Parent EClass</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate EReference Matches Parent EClass</em>' operation.
	 * @see pamtram.structure.generic.ActualReference#validateEReferenceMatchesParentEClass(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getActualReference__ValidateEReferenceMatchesParentEClass__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.generic.VirtualReference <em>Virtual Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Reference</em>'.
	 * @see pamtram.structure.generic.VirtualReference
	 * @generated
	 */
	EClass getVirtualReference();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.generic.CompositeReference <em>Composite Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Reference</em>'.
	 * @see pamtram.structure.generic.CompositeReference
	 * @generated
	 */
	EClass getCompositeReference();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.structure.generic.CompositeReference#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see pamtram.structure.generic.CompositeReference#getValue()
	 * @see #getCompositeReference()
	 * @generated
	 */
	EReference getCompositeReference_Value();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.CompositeReference#validateEReferenceIsContainment(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate EReference Is Containment</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate EReference Is Containment</em>' operation.
	 * @see pamtram.structure.generic.CompositeReference#validateEReferenceIsContainment(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCompositeReference__ValidateEReferenceIsContainment__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.generic.CrossReference <em>Cross Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cross Reference</em>'.
	 * @see pamtram.structure.generic.CrossReference
	 * @generated
	 */
	EClass getCrossReference();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.structure.generic.CrossReference#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Value</em>'.
	 * @see pamtram.structure.generic.CrossReference#getValue()
	 * @see #getCrossReference()
	 * @generated
	 */
	EReference getCrossReference_Value();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.CrossReference#validateValuesMatchReferenceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Values Match Reference Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Values Match Reference Type</em>' operation.
	 * @see pamtram.structure.generic.CrossReference#validateValuesMatchReferenceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCrossReference__ValidateValuesMatchReferenceType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.generic.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see pamtram.structure.generic.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the container reference '{@link pamtram.structure.generic.Attribute#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see pamtram.structure.generic.Attribute#getOwningClass()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_OwningClass();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.generic.ActualAttribute <em>Actual Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actual Attribute</em>'.
	 * @see pamtram.structure.generic.ActualAttribute
	 * @generated
	 */
	EClass getActualAttribute();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.generic.ActualAttribute#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see pamtram.structure.generic.ActualAttribute#getAttribute()
	 * @see #getActualAttribute()
	 * @generated
	 */
	EReference getActualAttribute_Attribute();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.generic.ActualAttribute#validateAttributeMatchesParentEClass(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Attribute Matches Parent EClass</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Attribute Matches Parent EClass</em>' operation.
	 * @see pamtram.structure.generic.ActualAttribute#validateAttributeMatchesParentEClass(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getActualAttribute__ValidateAttributeMatchesParentEClass__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.generic.VirtualAttribute <em>Virtual Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Attribute</em>'.
	 * @see pamtram.structure.generic.VirtualAttribute
	 * @generated
	 */
	EClass getVirtualAttribute();

	/**
	 * Returns the meta object for enum '{@link pamtram.structure.generic.CardinalityType <em>Cardinality Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cardinality Type</em>'.
	 * @see pamtram.structure.generic.CardinalityType
	 * @generated
	 */
	EEnum getCardinalityType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GenericFactory getGenericFactory();

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
		 * The meta object literal for the '{@link pamtram.structure.generic.impl.MetaModelElementImpl <em>Meta Model Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.generic.impl.MetaModelElementImpl
		 * @see pamtram.structure.generic.impl.GenericPackageImpl#getMetaModelElement()
		 * @generated
		 */
		EClass META_MODEL_ELEMENT = eINSTANCE.getMetaModelElement();

		/**
		 * The meta object literal for the '<em><b>Get Containing Section</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation META_MODEL_ELEMENT___GET_CONTAINING_SECTION = eINSTANCE.getMetaModelElement__GetContainingSection();

		/**
		 * The meta object literal for the '<em><b>Get Containing Section Model</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation META_MODEL_ELEMENT___GET_CONTAINING_SECTION_MODEL = eINSTANCE.getMetaModelElement__GetContainingSectionModel();

		/**
		 * The meta object literal for the '<em><b>Is Library Entry</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation META_MODEL_ELEMENT___IS_LIBRARY_ENTRY = eINSTANCE.getMetaModelElement__IsLibraryEntry();

		/**
		 * The meta object literal for the '{@link pamtram.structure.generic.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.generic.impl.ClassImpl
		 * @see pamtram.structure.generic.impl.GenericPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>EClass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ECLASS = eINSTANCE.getClass_EClass();

		/**
		 * The meta object literal for the '<em><b>Cardinality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__CARDINALITY = eINSTANCE.getClass_Cardinality();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__REFERENCES = eINSTANCE.getClass_References();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__CONTAINER = eINSTANCE.getClass_Container();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ATTRIBUTES = eINSTANCE.getClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>All Container</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ALL_CONTAINER = eINSTANCE.getClass_AllContainer();

		/**
		 * The meta object literal for the '<em><b>Is Container For</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_CONTAINER_FOR__CLASS = eINSTANCE.getClass__IsContainerFor__Class();

		/**
		 * The meta object literal for the '<em><b>Is Contained In</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_CONTAINED_IN__CLASS = eINSTANCE.getClass__IsContainedIn__Class();

		/**
		 * The meta object literal for the '<em><b>Get Owning Containment Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___GET_OWNING_CONTAINMENT_REFERENCE = eINSTANCE.getClass__GetOwningContainmentReference();

		/**
		 * The meta object literal for the '<em><b>Is Referenced By</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_REFERENCED_BY__CLASS_ELIST = eINSTANCE.getClass__IsReferencedBy__Class_EList();

		/**
		 * The meta object literal for the '<em><b>Validate EClass Matches Parent EReference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getClass__ValidateEClassMatchesParentEReference__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Cardinality Is Valid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP = eINSTANCE.getClass__ValidateCardinalityIsValid__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Container Is Valid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP = eINSTANCE.getClass__ValidateContainerIsValid__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.generic.impl.SectionImpl <em>Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.generic.impl.SectionImpl
		 * @see pamtram.structure.generic.impl.GenericPackageImpl#getSection()
		 * @generated
		 */
		EClass SECTION = eINSTANCE.getSection();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECTION__ABSTRACT = eINSTANCE.getSection_Abstract();

		/**
		 * The meta object literal for the '<em><b>Extend</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__EXTEND = eINSTANCE.getSection_Extend();

		/**
		 * The meta object literal for the '<em><b>All Extend</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__ALL_EXTEND = eINSTANCE.getSection_AllExtend();

		/**
		 * The meta object literal for the '<em><b>Validate Container Matches Extend Container</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SECTION___VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSection__ValidateContainerMatchesExtendContainer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Extends Valid Sections</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SECTION___VALIDATE_EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSection__ValidateExtendsValidSections__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.generic.impl.ReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.generic.impl.ReferenceImpl
		 * @see pamtram.structure.generic.impl.GenericPackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE__OWNING_CLASS = eINSTANCE.getReference_OwningClass();

		/**
		 * The meta object literal for the '<em><b>Get Values Generic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REFERENCE___GET_VALUES_GENERIC = eINSTANCE.getReference__GetValuesGeneric();

		/**
		 * The meta object literal for the '<em><b>Add Values Generic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REFERENCE___ADD_VALUES_GENERIC__ELIST = eINSTANCE.getReference__AddValuesGeneric__EList();

		/**
		 * The meta object literal for the '{@link pamtram.structure.generic.impl.ActualReferenceImpl <em>Actual Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.generic.impl.ActualReferenceImpl
		 * @see pamtram.structure.generic.impl.GenericPackageImpl#getActualReference()
		 * @generated
		 */
		EClass ACTUAL_REFERENCE = eINSTANCE.getActualReference();

		/**
		 * The meta object literal for the '<em><b>EReference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTUAL_REFERENCE__EREFERENCE = eINSTANCE.getActualReference_EReference();

		/**
		 * The meta object literal for the '<em><b>Validate EReference Matches Parent EClass</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTUAL_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getActualReference__ValidateEReferenceMatchesParentEClass__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.generic.impl.VirtualReferenceImpl <em>Virtual Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.generic.impl.VirtualReferenceImpl
		 * @see pamtram.structure.generic.impl.GenericPackageImpl#getVirtualReference()
		 * @generated
		 */
		EClass VIRTUAL_REFERENCE = eINSTANCE.getVirtualReference();

		/**
		 * The meta object literal for the '{@link pamtram.structure.generic.impl.CompositeReferenceImpl <em>Composite Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.generic.impl.CompositeReferenceImpl
		 * @see pamtram.structure.generic.impl.GenericPackageImpl#getCompositeReference()
		 * @generated
		 */
		EClass COMPOSITE_REFERENCE = eINSTANCE.getCompositeReference();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_REFERENCE__VALUE = eINSTANCE.getCompositeReference_Value();

		/**
		 * The meta object literal for the '<em><b>Validate EReference Is Containment</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_IS_CONTAINMENT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCompositeReference__ValidateEReferenceIsContainment__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.generic.impl.CrossReferenceImpl <em>Cross Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.generic.impl.CrossReferenceImpl
		 * @see pamtram.structure.generic.impl.GenericPackageImpl#getCrossReference()
		 * @generated
		 */
		EClass CROSS_REFERENCE = eINSTANCE.getCrossReference();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSS_REFERENCE__VALUE = eINSTANCE.getCrossReference_Value();

		/**
		 * The meta object literal for the '<em><b>Validate Values Match Reference Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CROSS_REFERENCE___VALIDATE_VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCrossReference__ValidateValuesMatchReferenceType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.generic.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.generic.impl.AttributeImpl
		 * @see pamtram.structure.generic.impl.GenericPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__OWNING_CLASS = eINSTANCE.getAttribute_OwningClass();

		/**
		 * The meta object literal for the '{@link pamtram.structure.generic.impl.ActualAttributeImpl <em>Actual Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.generic.impl.ActualAttributeImpl
		 * @see pamtram.structure.generic.impl.GenericPackageImpl#getActualAttribute()
		 * @generated
		 */
		EClass ACTUAL_ATTRIBUTE = eINSTANCE.getActualAttribute();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTUAL_ATTRIBUTE__ATTRIBUTE = eINSTANCE.getActualAttribute_Attribute();

		/**
		 * The meta object literal for the '<em><b>Validate Attribute Matches Parent EClass</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTUAL_ATTRIBUTE___VALIDATE_ATTRIBUTE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getActualAttribute__ValidateAttributeMatchesParentEClass__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.generic.impl.VirtualAttributeImpl <em>Virtual Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.generic.impl.VirtualAttributeImpl
		 * @see pamtram.structure.generic.impl.GenericPackageImpl#getVirtualAttribute()
		 * @generated
		 */
		EClass VIRTUAL_ATTRIBUTE = eINSTANCE.getVirtualAttribute();

		/**
		 * The meta object literal for the '{@link pamtram.structure.generic.CardinalityType <em>Cardinality Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.generic.CardinalityType
		 * @see pamtram.structure.generic.impl.GenericPackageImpl#getCardinalityType()
		 * @generated
		 */
		EEnum CARDINALITY_TYPE = eINSTANCE.getCardinalityType();

	}

} //GenericPackage
