/**
 */
package pamtram.structure;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import pamtram.PamtramPackage;
import pamtram.mapping.MappingPackage;
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
	 * The meta object id for the '{@link pamtram.structure.impl.TargetSectionClassImpl <em>Target Section Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.TargetSectionClassImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getTargetSectionClass()
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
	 * The number of structural features of the '<em>Target Section Class</em>' class.
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
	 * The number of operations of the '<em>Target Section Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS_OPERATION_COUNT = GenericPackage.CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.TargetSectionImpl <em>Target Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.TargetSectionImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getTargetSection()
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
	 * The feature id for the '<em><b>Referencing Mapping Hint Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS = TARGET_SECTION_CLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>File</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION__FILE = TARGET_SECTION_CLASS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Target Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_FEATURE_COUNT = TARGET_SECTION_CLASS_FEATURE_COUNT + 4;

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
	 * The operation id for the '<em>Validate Is Referenced By Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION___VALIDATE_IS_REFERENCED_BY_MAPPING_HINT_GROUP__DIAGNOSTICCHAIN_MAP = TARGET_SECTION_CLASS_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Target Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_OPERATION_COUNT = TARGET_SECTION_CLASS_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.LibraryParameterImpl <em>Library Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.LibraryParameterImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getLibraryParameter()
	 * @generated
	 */
	int LIBRARY_PARAMETER = 3;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.AttributeParameterImpl <em>Attribute Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.AttributeParameterImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getAttributeParameter()
	 * @generated
	 */
	int ATTRIBUTE_PARAMETER = 4;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.ContainerParameterImpl <em>Container Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.ContainerParameterImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getContainerParameter()
	 * @generated
	 */
	int CONTAINER_PARAMETER = 5;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.ExternalReferenceParameterImpl <em>External Reference Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.ExternalReferenceParameterImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getExternalReferenceParameter()
	 * @generated
	 */
	int EXTERNAL_REFERENCE_PARAMETER = 6;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.LibraryEntryImpl <em>Library Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.LibraryEntryImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getLibraryEntry()
	 * @generated
	 */
	int LIBRARY_ENTRY = 8;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.TargetSectionReferenceImpl <em>Target Section Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.TargetSectionReferenceImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getTargetSectionReference()
	 * @generated
	 */
	int TARGET_SECTION_REFERENCE = 9;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.TargetSectionAttributeImpl <em>Target Section Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.TargetSectionAttributeImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getTargetSectionAttribute()
	 * @generated
	 */
	int TARGET_SECTION_ATTRIBUTE = 12;

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
	 * The number of structural features of the '<em>Target Section Attribute</em>' class.
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
	 * The number of operations of the '<em>Target Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE_OPERATION_COUNT = GenericPackage.ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.ActualTargetSectionAttributeImpl <em>Actual Target Section Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.ActualTargetSectionAttributeImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getActualTargetSectionAttribute()
	 * @generated
	 */
	int ACTUAL_TARGET_SECTION_ATTRIBUTE = 13;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.VirtualTargetSectionAttributeImpl <em>Virtual Target Section Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.VirtualTargetSectionAttributeImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getVirtualTargetSectionAttribute()
	 * @generated
	 */
	int VIRTUAL_TARGET_SECTION_ATTRIBUTE = 14;

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
	 * The meta object id for the '{@link pamtram.structure.impl.FileAttributeImpl <em>File Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.FileAttributeImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getFileAttribute()
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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_PARAMETER__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_PARAMETER__SOURCE = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_PARAMETER__ORIGINAL_PARAMETER = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Library Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_PARAMETER_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Library Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_PARAMETER_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PARAMETER__NAME = LIBRARY_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PARAMETER__SOURCE = LIBRARY_PARAMETER__SOURCE;

	/**
	 * The feature id for the '<em><b>Original Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PARAMETER__ORIGINAL_PARAMETER = LIBRARY_PARAMETER__ORIGINAL_PARAMETER;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PARAMETER__ATTRIBUTE = LIBRARY_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PARAMETER_FEATURE_COUNT = LIBRARY_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PARAMETER_OPERATION_COUNT = LIBRARY_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_PARAMETER__NAME = LIBRARY_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_PARAMETER__SOURCE = LIBRARY_PARAMETER__SOURCE;

	/**
	 * The feature id for the '<em><b>Original Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_PARAMETER__ORIGINAL_PARAMETER = LIBRARY_PARAMETER__ORIGINAL_PARAMETER;

	/**
	 * The feature id for the '<em><b>Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_PARAMETER__CLASS = LIBRARY_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Container Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_PARAMETER_FEATURE_COUNT = LIBRARY_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Container Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_PARAMETER_OPERATION_COUNT = LIBRARY_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_REFERENCE_PARAMETER__NAME = LIBRARY_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_REFERENCE_PARAMETER__SOURCE = LIBRARY_PARAMETER__SOURCE;

	/**
	 * The feature id for the '<em><b>Original Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_REFERENCE_PARAMETER__ORIGINAL_PARAMETER = LIBRARY_PARAMETER__ORIGINAL_PARAMETER;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_REFERENCE_PARAMETER__REFERENCE = LIBRARY_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Reference Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_REFERENCE_PARAMETER_FEATURE_COUNT = LIBRARY_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>External Reference Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_REFERENCE_PARAMETER_OPERATION_COUNT = LIBRARY_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.ResourceParameterImpl <em>Resource Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.ResourceParameterImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getResourceParameter()
	 * @generated
	 */
	int RESOURCE_PARAMETER = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER__ATTRIBUTE = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER__ORIGINAL_PARAMETER = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Resource Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY__PARAMETERS = 0;

	/**
	 * The feature id for the '<em><b>Library File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY__LIBRARY_FILE = 1;

	/**
	 * The feature id for the '<em><b>Original Library Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY = 2;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY__PATH = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY__ID = 4;

	/**
	 * The feature id for the '<em><b>Resource Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY__RESOURCE_PARAMETERS = 5;

	/**
	 * The number of structural features of the '<em>Library Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Library Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE__NAME = GenericPackage.REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE__EREFERENCE = GenericPackage.REFERENCE__EREFERENCE;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE__OWNING_CLASS = GenericPackage.REFERENCE__OWNING_CLASS;

	/**
	 * The number of structural features of the '<em>Target Section Reference</em>' class.
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
	 * The operation id for the '<em>Validate EReference Matches Parent EClass</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP = GenericPackage.REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP;

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
	 * The number of operations of the '<em>Target Section Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE_OPERATION_COUNT = GenericPackage.REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.TargetSectionCompositeReferenceImpl <em>Target Section Composite Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.TargetSectionCompositeReferenceImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getTargetSectionCompositeReference()
	 * @generated
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE__NAME = GenericPackage.COMPOSITE_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE__EREFERENCE = GenericPackage.COMPOSITE_REFERENCE__EREFERENCE;

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
	 * The number of structural features of the '<em>Target Section Composite Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE_FEATURE_COUNT = GenericPackage.COMPOSITE_REFERENCE_FEATURE_COUNT + 0;

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
	 * The operation id for the '<em>Validate EReference Matches Parent EClass</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP = GenericPackage.COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP;

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
	 * The operation id for the '<em>Validate EReference Is Containment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_IS_CONTAINMENT__DIAGNOSTICCHAIN_MAP = GenericPackage.COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_IS_CONTAINMENT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Target Section Composite Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_COMPOSITE_REFERENCE_OPERATION_COUNT = GenericPackage.COMPOSITE_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.TargetSectionCrossReferenceImpl <em>Target Section Cross Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.TargetSectionCrossReferenceImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getTargetSectionCrossReference()
	 * @generated
	 */
	int TARGET_SECTION_CROSS_REFERENCE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE__NAME = GenericPackage.CROSS_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE__EREFERENCE = GenericPackage.CROSS_REFERENCE__EREFERENCE;

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
	 * The number of structural features of the '<em>Target Section Cross Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE_FEATURE_COUNT = GenericPackage.CROSS_REFERENCE_FEATURE_COUNT + 0;

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
	 * The operation id for the '<em>Validate EReference Matches Parent EClass</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP = GenericPackage.CROSS_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP;

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
	 * The operation id for the '<em>Validate Values Match Reference Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE___VALIDATE_VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP = GenericPackage.CROSS_REFERENCE___VALIDATE_VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate EReference Is Non Containment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE___VALIDATE_EREFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP = GenericPackage.CROSS_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Target Section Cross Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CROSS_REFERENCE_OPERATION_COUNT = GenericPackage.CROSS_REFERENCE_OPERATION_COUNT + 1;

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
	 * The meta object id for the '{@link pamtram.structure.impl.InstancePointerImpl <em>Instance Pointer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.InstancePointerImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getInstancePointer()
	 * @generated
	 */
	int INSTANCE_POINTER = 15;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER__EXPRESSION = MappingPackage.EXPRESSION_HINT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Result Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER__RESULT_MODIFIER = MappingPackage.EXPRESSION_HINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER__TARGET = MappingPackage.EXPRESSION_HINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER__SOURCE_ELEMENTS = MappingPackage.EXPRESSION_HINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Instance Pointer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_FEATURE_COUNT = MappingPackage.EXPRESSION_HINT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate No Modified Attribute Element Types In Condition Model Conditions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP = MappingPackage.EXPRESSION_HINT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Instance Pointer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_OPERATION_COUNT = MappingPackage.EXPRESSION_HINT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.InstancePointerSourceInterface <em>Instance Pointer Source Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.InstancePointerSourceInterface
	 * @see pamtram.structure.impl.StructurePackageImpl#getInstancePointerSourceInterface()
	 * @generated
	 */
	int INSTANCE_POINTER_SOURCE_INTERFACE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_SOURCE_INTERFACE__NAME = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE__NAME;

	/**
	 * The number of structural features of the '<em>Instance Pointer Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_SOURCE_INTERFACE_FEATURE_COUNT = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE;

	/**
	 * The number of operations of the '<em>Instance Pointer Source Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_SOURCE_INTERFACE_OPERATION_COUNT = MappingPackage.MAPPING_HINT_SOURCE_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.InstancePointerSourceElementImpl <em>Instance Pointer Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.InstancePointerSourceElementImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getInstancePointerSourceElement()
	 * @generated
	 */
	int INSTANCE_POINTER_SOURCE_ELEMENT = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_SOURCE_ELEMENT__NAME = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_SOURCE_ELEMENT__SOURCE = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_SOURCE_ELEMENT__MODIFIER = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>Instance Pointer Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_SOURCE_ELEMENT_FEATURE_COUNT = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_SOURCE_ELEMENT___GET_MAPPING = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Section Or Contained Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Instance Pointer Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_SOURCE_ELEMENT_OPERATION_COUNT = MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.impl.InstancePointerExternalSourceElementImpl <em>Instance Pointer External Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.impl.InstancePointerExternalSourceElementImpl
	 * @see pamtram.structure.impl.StructurePackageImpl#getInstancePointerExternalSourceElement()
	 * @generated
	 */
	int INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT__NAME = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT__SOURCE = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT__MODIFIER = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER;

	/**
	 * The number of structural features of the '<em>Instance Pointer External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT_FEATURE_COUNT = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Mapping Hint Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP;

	/**
	 * The operation id for the '<em>Get Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT___GET_MAPPING = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING;

	/**
	 * The operation id for the '<em>Validate Source Attribute Matches Container Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Source Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Instance Pointer External Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT_OPERATION_COUNT = MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.structure.FileTypeEnum <em>File Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.structure.FileTypeEnum
	 * @see pamtram.structure.impl.StructurePackageImpl#getFileTypeEnum()
	 * @generated
	 */
	int FILE_TYPE_ENUM = 19;

	/**
	 * Returns the meta object for class '{@link pamtram.structure.TargetSection <em>Target Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Section</em>'.
	 * @see pamtram.structure.TargetSection
	 * @generated
	 */
	EClass getTargetSection();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.structure.TargetSection#getReferencingMappingHintGroups <em>Referencing Mapping Hint Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referencing Mapping Hint Groups</em>'.
	 * @see pamtram.structure.TargetSection#getReferencingMappingHintGroups()
	 * @see #getTargetSection()
	 * @generated
	 */
	EReference getTargetSection_ReferencingMappingHintGroups();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.TargetSection#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>File</em>'.
	 * @see pamtram.structure.TargetSection#getFile()
	 * @see #getTargetSection()
	 * @generated
	 */
	EReference getTargetSection_File();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.TargetSection#validateIsReferencedByMappingHintGroup(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Is Referenced By Mapping Hint Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Is Referenced By Mapping Hint Group</em>' operation.
	 * @see pamtram.structure.TargetSection#validateIsReferencedByMappingHintGroup(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTargetSection__ValidateIsReferencedByMappingHintGroup__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.FileAttribute <em>File Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Attribute</em>'.
	 * @see pamtram.structure.FileAttribute
	 * @generated
	 */
	EClass getFileAttribute();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.FileAttribute#getFileType <em>File Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Type</em>'.
	 * @see pamtram.structure.FileAttribute#getFileType()
	 * @see #getFileAttribute()
	 * @generated
	 */
	EAttribute getFileAttribute_FileType();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.TargetSectionClass <em>Target Section Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Section Class</em>'.
	 * @see pamtram.structure.TargetSectionClass
	 * @generated
	 */
	EClass getTargetSectionClass();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.LibraryParameter <em>Library Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library Parameter</em>'.
	 * @see pamtram.structure.LibraryParameter
	 * @generated
	 */
	EClass getLibraryParameter();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.LibraryParameter#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see pamtram.structure.LibraryParameter#getSource()
	 * @see #getLibraryParameter()
	 * @generated
	 */
	EReference getLibraryParameter_Source();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.LibraryParameter#getOriginalParameter <em>Original Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Parameter</em>'.
	 * @see pamtram.structure.LibraryParameter#getOriginalParameter()
	 * @see #getLibraryParameter()
	 * @generated
	 */
	EReference getLibraryParameter_OriginalParameter();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.AttributeParameter <em>Attribute Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Parameter</em>'.
	 * @see pamtram.structure.AttributeParameter
	 * @generated
	 */
	EClass getAttributeParameter();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.structure.AttributeParameter#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attribute</em>'.
	 * @see pamtram.structure.AttributeParameter#getAttribute()
	 * @see #getAttributeParameter()
	 * @generated
	 */
	EReference getAttributeParameter_Attribute();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.ContainerParameter <em>Container Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Parameter</em>'.
	 * @see pamtram.structure.ContainerParameter
	 * @generated
	 */
	EClass getContainerParameter();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.structure.ContainerParameter#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Class</em>'.
	 * @see pamtram.structure.ContainerParameter#getClass_()
	 * @see #getContainerParameter()
	 * @generated
	 */
	EReference getContainerParameter_Class();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.ExternalReferenceParameter <em>External Reference Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Reference Parameter</em>'.
	 * @see pamtram.structure.ExternalReferenceParameter
	 * @generated
	 */
	EClass getExternalReferenceParameter();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.structure.ExternalReferenceParameter#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reference</em>'.
	 * @see pamtram.structure.ExternalReferenceParameter#getReference()
	 * @see #getExternalReferenceParameter()
	 * @generated
	 */
	EReference getExternalReferenceParameter_Reference();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.ResourceParameter <em>Resource Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Parameter</em>'.
	 * @see pamtram.structure.ResourceParameter
	 * @generated
	 */
	EClass getResourceParameter();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.structure.ResourceParameter#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attribute</em>'.
	 * @see pamtram.structure.ResourceParameter#getAttribute()
	 * @see #getResourceParameter()
	 * @generated
	 */
	EReference getResourceParameter_Attribute();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.ResourceParameter#getOriginalParameter <em>Original Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Parameter</em>'.
	 * @see pamtram.structure.ResourceParameter#getOriginalParameter()
	 * @see #getResourceParameter()
	 * @generated
	 */
	EReference getResourceParameter_OriginalParameter();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.LibraryEntry <em>Library Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library Entry</em>'.
	 * @see pamtram.structure.LibraryEntry
	 * @generated
	 */
	EClass getLibraryEntry();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.structure.LibraryEntry#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see pamtram.structure.LibraryEntry#getParameters()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EReference getLibraryEntry_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.LibraryEntry#getLibraryFile <em>Library File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Library File</em>'.
	 * @see pamtram.structure.LibraryEntry#getLibraryFile()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EAttribute getLibraryEntry_LibraryFile();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.structure.LibraryEntry#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path</em>'.
	 * @see pamtram.structure.LibraryEntry#getPath()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EReference getLibraryEntry_Path();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.structure.LibraryEntry#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see pamtram.structure.LibraryEntry#getId()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EReference getLibraryEntry_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.structure.LibraryEntry#getResourceParameters <em>Resource Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Parameters</em>'.
	 * @see pamtram.structure.LibraryEntry#getResourceParameters()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EReference getLibraryEntry_ResourceParameters();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.LibraryEntry#getOriginalLibraryEntry <em>Original Library Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Library Entry</em>'.
	 * @see pamtram.structure.LibraryEntry#getOriginalLibraryEntry()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EReference getLibraryEntry_OriginalLibraryEntry();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.TargetSectionReference <em>Target Section Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Section Reference</em>'.
	 * @see pamtram.structure.TargetSectionReference
	 * @generated
	 */
	EClass getTargetSectionReference();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.TargetSectionCompositeReference <em>Target Section Composite Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Section Composite Reference</em>'.
	 * @see pamtram.structure.TargetSectionCompositeReference
	 * @generated
	 */
	EClass getTargetSectionCompositeReference();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.TargetSectionCrossReference <em>Target Section Cross Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Section Cross Reference</em>'.
	 * @see pamtram.structure.TargetSectionCrossReference
	 * @generated
	 */
	EClass getTargetSectionCrossReference();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.TargetSectionCrossReference#validateEReferenceIsNonContainment(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate EReference Is Non Containment</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate EReference Is Non Containment</em>' operation.
	 * @see pamtram.structure.TargetSectionCrossReference#validateEReferenceIsNonContainment(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTargetSectionCrossReference__ValidateEReferenceIsNonContainment__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.TargetSectionAttribute <em>Target Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Section Attribute</em>'.
	 * @see pamtram.structure.TargetSectionAttribute
	 * @generated
	 */
	EClass getTargetSectionAttribute();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.TargetSectionAttribute#isUnique <em>Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unique</em>'.
	 * @see pamtram.structure.TargetSectionAttribute#isUnique()
	 * @see #getTargetSectionAttribute()
	 * @generated
	 */
	EAttribute getTargetSectionAttribute_Unique();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.structure.TargetSectionAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see pamtram.structure.TargetSectionAttribute#getValue()
	 * @see #getTargetSectionAttribute()
	 * @generated
	 */
	EAttribute getTargetSectionAttribute_Value();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.ActualTargetSectionAttribute <em>Actual Target Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actual Target Section Attribute</em>'.
	 * @see pamtram.structure.ActualTargetSectionAttribute
	 * @generated
	 */
	EClass getActualTargetSectionAttribute();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.VirtualTargetSectionAttribute <em>Virtual Target Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Target Section Attribute</em>'.
	 * @see pamtram.structure.VirtualTargetSectionAttribute
	 * @generated
	 */
	EClass getVirtualTargetSectionAttribute();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.InstancePointer <em>Instance Pointer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Pointer</em>'.
	 * @see pamtram.structure.InstancePointer
	 * @generated
	 */
	EClass getInstancePointer();

	/**
	 * Returns the meta object for the reference '{@link pamtram.structure.InstancePointer#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see pamtram.structure.InstancePointer#getTarget()
	 * @see #getInstancePointer()
	 * @generated
	 */
	EReference getInstancePointer_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.structure.InstancePointer#getSourceElements <em>Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Elements</em>'.
	 * @see pamtram.structure.InstancePointer#getSourceElements()
	 * @see #getInstancePointer()
	 * @generated
	 */
	EReference getInstancePointer_SourceElements();

	/**
	 * Returns the meta object for the '{@link pamtram.structure.InstancePointer#validateNoModifiedAttributeElementTypesInConditionModelConditions(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Modified Attribute Element Types In Condition Model Conditions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate No Modified Attribute Element Types In Condition Model Conditions</em>' operation.
	 * @see pamtram.structure.InstancePointer#validateNoModifiedAttributeElementTypesInConditionModelConditions(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getInstancePointer__ValidateNoModifiedAttributeElementTypesInConditionModelConditions__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.InstancePointerSourceInterface <em>Instance Pointer Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Pointer Source Interface</em>'.
	 * @see pamtram.structure.InstancePointerSourceInterface
	 * @generated
	 */
	EClass getInstancePointerSourceInterface();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.InstancePointerSourceElement <em>Instance Pointer Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Pointer Source Element</em>'.
	 * @see pamtram.structure.InstancePointerSourceElement
	 * @generated
	 */
	EClass getInstancePointerSourceElement();

	/**
	 * Returns the meta object for class '{@link pamtram.structure.InstancePointerExternalSourceElement <em>Instance Pointer External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Pointer External Source Element</em>'.
	 * @see pamtram.structure.InstancePointerExternalSourceElement
	 * @generated
	 */
	EClass getInstancePointerExternalSourceElement();

	/**
	 * Returns the meta object for enum '{@link pamtram.structure.FileTypeEnum <em>File Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>File Type Enum</em>'.
	 * @see pamtram.structure.FileTypeEnum
	 * @generated
	 */
	EEnum getFileTypeEnum();

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
		 * The meta object literal for the '{@link pamtram.structure.impl.TargetSectionImpl <em>Target Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.TargetSectionImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getTargetSection()
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
		 * The meta object literal for the '{@link pamtram.structure.impl.FileAttributeImpl <em>File Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.FileAttributeImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getFileAttribute()
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
		 * The meta object literal for the '{@link pamtram.structure.impl.TargetSectionClassImpl <em>Target Section Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.TargetSectionClassImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getTargetSectionClass()
		 * @generated
		 */
		EClass TARGET_SECTION_CLASS = eINSTANCE.getTargetSectionClass();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.LibraryParameterImpl <em>Library Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.LibraryParameterImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getLibraryParameter()
		 * @generated
		 */
		EClass LIBRARY_PARAMETER = eINSTANCE.getLibraryParameter();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY_PARAMETER__SOURCE = eINSTANCE.getLibraryParameter_Source();

		/**
		 * The meta object literal for the '<em><b>Original Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY_PARAMETER__ORIGINAL_PARAMETER = eINSTANCE.getLibraryParameter_OriginalParameter();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.AttributeParameterImpl <em>Attribute Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.AttributeParameterImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getAttributeParameter()
		 * @generated
		 */
		EClass ATTRIBUTE_PARAMETER = eINSTANCE.getAttributeParameter();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_PARAMETER__ATTRIBUTE = eINSTANCE.getAttributeParameter_Attribute();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.ContainerParameterImpl <em>Container Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.ContainerParameterImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getContainerParameter()
		 * @generated
		 */
		EClass CONTAINER_PARAMETER = eINSTANCE.getContainerParameter();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER_PARAMETER__CLASS = eINSTANCE.getContainerParameter_Class();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.ExternalReferenceParameterImpl <em>External Reference Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.ExternalReferenceParameterImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getExternalReferenceParameter()
		 * @generated
		 */
		EClass EXTERNAL_REFERENCE_PARAMETER = eINSTANCE.getExternalReferenceParameter();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_REFERENCE_PARAMETER__REFERENCE = eINSTANCE.getExternalReferenceParameter_Reference();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.ResourceParameterImpl <em>Resource Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.ResourceParameterImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getResourceParameter()
		 * @generated
		 */
		EClass RESOURCE_PARAMETER = eINSTANCE.getResourceParameter();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_PARAMETER__ATTRIBUTE = eINSTANCE.getResourceParameter_Attribute();

		/**
		 * The meta object literal for the '<em><b>Original Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_PARAMETER__ORIGINAL_PARAMETER = eINSTANCE.getResourceParameter_OriginalParameter();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.LibraryEntryImpl <em>Library Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.LibraryEntryImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getLibraryEntry()
		 * @generated
		 */
		EClass LIBRARY_ENTRY = eINSTANCE.getLibraryEntry();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY_ENTRY__PARAMETERS = eINSTANCE.getLibraryEntry_Parameters();

		/**
		 * The meta object literal for the '<em><b>Library File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY_ENTRY__LIBRARY_FILE = eINSTANCE.getLibraryEntry_LibraryFile();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY_ENTRY__PATH = eINSTANCE.getLibraryEntry_Path();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY_ENTRY__ID = eINSTANCE.getLibraryEntry_Id();

		/**
		 * The meta object literal for the '<em><b>Resource Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY_ENTRY__RESOURCE_PARAMETERS = eINSTANCE.getLibraryEntry_ResourceParameters();

		/**
		 * The meta object literal for the '<em><b>Original Library Entry</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY = eINSTANCE.getLibraryEntry_OriginalLibraryEntry();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.TargetSectionReferenceImpl <em>Target Section Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.TargetSectionReferenceImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getTargetSectionReference()
		 * @generated
		 */
		EClass TARGET_SECTION_REFERENCE = eINSTANCE.getTargetSectionReference();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.TargetSectionCompositeReferenceImpl <em>Target Section Composite Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.TargetSectionCompositeReferenceImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getTargetSectionCompositeReference()
		 * @generated
		 */
		EClass TARGET_SECTION_COMPOSITE_REFERENCE = eINSTANCE.getTargetSectionCompositeReference();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.TargetSectionCrossReferenceImpl <em>Target Section Cross Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.TargetSectionCrossReferenceImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getTargetSectionCrossReference()
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
		 * The meta object literal for the '{@link pamtram.structure.impl.TargetSectionAttributeImpl <em>Target Section Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.TargetSectionAttributeImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getTargetSectionAttribute()
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
		 * The meta object literal for the '{@link pamtram.structure.impl.ActualTargetSectionAttributeImpl <em>Actual Target Section Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.ActualTargetSectionAttributeImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getActualTargetSectionAttribute()
		 * @generated
		 */
		EClass ACTUAL_TARGET_SECTION_ATTRIBUTE = eINSTANCE.getActualTargetSectionAttribute();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.VirtualTargetSectionAttributeImpl <em>Virtual Target Section Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.VirtualTargetSectionAttributeImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getVirtualTargetSectionAttribute()
		 * @generated
		 */
		EClass VIRTUAL_TARGET_SECTION_ATTRIBUTE = eINSTANCE.getVirtualTargetSectionAttribute();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.InstancePointerImpl <em>Instance Pointer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.InstancePointerImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getInstancePointer()
		 * @generated
		 */
		EClass INSTANCE_POINTER = eINSTANCE.getInstancePointer();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_POINTER__TARGET = eINSTANCE.getInstancePointer_Target();

		/**
		 * The meta object literal for the '<em><b>Source Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_POINTER__SOURCE_ELEMENTS = eINSTANCE.getInstancePointer_SourceElements();

		/**
		 * The meta object literal for the '<em><b>Validate No Modified Attribute Element Types In Condition Model Conditions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INSTANCE_POINTER___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getInstancePointer__ValidateNoModifiedAttributeElementTypesInConditionModelConditions__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link pamtram.structure.InstancePointerSourceInterface <em>Instance Pointer Source Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.InstancePointerSourceInterface
		 * @see pamtram.structure.impl.StructurePackageImpl#getInstancePointerSourceInterface()
		 * @generated
		 */
		EClass INSTANCE_POINTER_SOURCE_INTERFACE = eINSTANCE.getInstancePointerSourceInterface();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.InstancePointerSourceElementImpl <em>Instance Pointer Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.InstancePointerSourceElementImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getInstancePointerSourceElement()
		 * @generated
		 */
		EClass INSTANCE_POINTER_SOURCE_ELEMENT = eINSTANCE.getInstancePointerSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.structure.impl.InstancePointerExternalSourceElementImpl <em>Instance Pointer External Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.impl.InstancePointerExternalSourceElementImpl
		 * @see pamtram.structure.impl.StructurePackageImpl#getInstancePointerExternalSourceElement()
		 * @generated
		 */
		EClass INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT = eINSTANCE.getInstancePointerExternalSourceElement();

		/**
		 * The meta object literal for the '{@link pamtram.structure.FileTypeEnum <em>File Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.structure.FileTypeEnum
		 * @see pamtram.structure.impl.StructurePackageImpl#getFileTypeEnum()
		 * @generated
		 */
		EEnum FILE_TYPE_ENUM = eINSTANCE.getFileTypeEnum();

	}

} //StructurePackage
