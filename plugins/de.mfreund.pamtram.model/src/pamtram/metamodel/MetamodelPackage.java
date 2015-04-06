/**
 */
package pamtram.metamodel;

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
 * @see pamtram.metamodel.MetamodelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface MetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mfreund.de/pamtram/metamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "metamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetamodelPackage eINSTANCE = pamtram.metamodel.impl.MetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.MetaModelElementImpl <em>Meta Model Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.MetaModelElementImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getMetaModelElement()
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
	 * The meta object id for the '{@link pamtram.metamodel.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.ClassImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getClass_()
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
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = META_MODEL_ELEMENT_FEATURE_COUNT + 2;

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
	 * The operation id for the '<em>Get References Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___GET_REFERENCES_GENERIC = META_MODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Attributes Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___GET_ATTRIBUTES_GENERIC = META_MODEL_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Container Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___GET_CONTAINER_GENERIC = META_MODEL_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Container For Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_CONTAINER_FOR_GENERIC__CLASS = META_MODEL_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_SECTION = META_MODEL_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = META_MODEL_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.SourceSectionClassImpl <em>Source Section Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.SourceSectionClassImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getSourceSectionClass()
	 * @generated
	 */
	int SOURCE_SECTION_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__ECLASS = CLASS__ECLASS;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__CARDINALITY = CLASS__CARDINALITY;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__REFERENCES = CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__ATTRIBUTES = CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__CONTAINER = CLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning Containment Reference</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE = CLASS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Source Section Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS_FEATURE_COUNT = CLASS_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___GET_CONTAINING_SECTION = CLASS___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___GET_CONTAINING_SECTION_MODEL = CLASS___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___IS_LIBRARY_ENTRY = CLASS___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get References Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___GET_REFERENCES_GENERIC = CLASS___GET_REFERENCES_GENERIC;

	/**
	 * The operation id for the '<em>Get Attributes Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___GET_ATTRIBUTES_GENERIC = CLASS___GET_ATTRIBUTES_GENERIC;

	/**
	 * The operation id for the '<em>Get Container Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___GET_CONTAINER_GENERIC = CLASS___GET_CONTAINER_GENERIC;

	/**
	 * The operation id for the '<em>Is Container For Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___IS_CONTAINER_FOR_GENERIC__CLASS = CLASS___IS_CONTAINER_FOR_GENERIC__CLASS;

	/**
	 * The operation id for the '<em>Is Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS___IS_SECTION = CLASS___IS_SECTION;

	/**
	 * The number of operations of the '<em>Source Section Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CLASS_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.TargetSectionClassImpl <em>Target Section Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.TargetSectionClassImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getTargetSectionClass()
	 * @generated
	 */
	int TARGET_SECTION_CLASS = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__ECLASS = CLASS__ECLASS;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__CARDINALITY = CLASS__CARDINALITY;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__REFERENCES = CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__ATTRIBUTES = CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS__CONTAINER = CLASS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Target Section Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS_FEATURE_COUNT = CLASS_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___GET_CONTAINING_SECTION = CLASS___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___GET_CONTAINING_SECTION_MODEL = CLASS___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___IS_LIBRARY_ENTRY = CLASS___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get References Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___GET_REFERENCES_GENERIC = CLASS___GET_REFERENCES_GENERIC;

	/**
	 * The operation id for the '<em>Get Attributes Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___GET_ATTRIBUTES_GENERIC = CLASS___GET_ATTRIBUTES_GENERIC;

	/**
	 * The operation id for the '<em>Get Container Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___GET_CONTAINER_GENERIC = CLASS___GET_CONTAINER_GENERIC;

	/**
	 * The operation id for the '<em>Is Container For Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___IS_CONTAINER_FOR_GENERIC__CLASS = CLASS___IS_CONTAINER_FOR_GENERIC__CLASS;

	/**
	 * The operation id for the '<em>Is Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS___IS_SECTION = CLASS___IS_SECTION;

	/**
	 * The number of operations of the '<em>Target Section Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CLASS_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.LibraryParameterImpl <em>Library Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.LibraryParameterImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getLibraryParameter()
	 * @generated
	 */
	int LIBRARY_PARAMETER = 4;

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
	 * The meta object id for the '{@link pamtram.metamodel.impl.AttributeParameterImpl <em>Attribute Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.AttributeParameterImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getAttributeParameter()
	 * @generated
	 */
	int ATTRIBUTE_PARAMETER = 5;

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
	 * The meta object id for the '{@link pamtram.metamodel.impl.ContainerParameterImpl <em>Container Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.ContainerParameterImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getContainerParameter()
	 * @generated
	 */
	int CONTAINER_PARAMETER = 6;

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
	 * The meta object id for the '{@link pamtram.metamodel.impl.ExternalReferenceParameterImpl <em>External Reference Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.ExternalReferenceParameterImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getExternalReferenceParameter()
	 * @generated
	 */
	int EXTERNAL_REFERENCE_PARAMETER = 7;

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
	 * The meta object id for the '{@link pamtram.metamodel.impl.LibraryEntryImpl <em>Library Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.LibraryEntryImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getLibraryEntry()
	 * @generated
	 */
	int LIBRARY_ENTRY = 8;

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
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY__PATH = 2;

	/**
	 * The feature id for the '<em><b>Original Library Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY = 3;

	/**
	 * The number of structural features of the '<em>Library Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Library Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.ReferenceImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__NAME = META_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__EREFERENCE = META_MODEL_ELEMENT_FEATURE_COUNT + 0;

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
	 * The number of operations of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION_COUNT = META_MODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.ContainmentReferenceImpl <em>Containment Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.ContainmentReferenceImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getContainmentReference()
	 * @generated
	 */
	int CONTAINMENT_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT_REFERENCE__NAME = REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT_REFERENCE__EREFERENCE = REFERENCE__EREFERENCE;

	/**
	 * The number of structural features of the '<em>Containment Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION = REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION_MODEL = REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT_REFERENCE___IS_LIBRARY_ENTRY = REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The number of operations of the '<em>Containment Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT_REFERENCE_OPERATION_COUNT = REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.NonContainmentReferenceImpl <em>Non Containment Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.NonContainmentReferenceImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getNonContainmentReference()
	 * @generated
	 */
	int NON_CONTAINMENT_REFERENCE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONTAINMENT_REFERENCE__NAME = REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONTAINMENT_REFERENCE__EREFERENCE = REFERENCE__EREFERENCE;

	/**
	 * The number of structural features of the '<em>Non Containment Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONTAINMENT_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION = REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION_MODEL = REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONTAINMENT_REFERENCE___IS_LIBRARY_ENTRY = REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The number of operations of the '<em>Non Containment Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CONTAINMENT_REFERENCE_OPERATION_COUNT = REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.SourceSectionReferenceImpl <em>Source Section Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.SourceSectionReferenceImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getSourceSectionReference()
	 * @generated
	 */
	int SOURCE_SECTION_REFERENCE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE__NAME = REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE__EREFERENCE = REFERENCE__EREFERENCE;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE__OWNING_CLASS = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Source Section Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE___GET_CONTAINING_SECTION = REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE___GET_CONTAINING_SECTION_MODEL = REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE___IS_LIBRARY_ENTRY = REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE___GET_VALUES_GENERIC = REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Source Section Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_REFERENCE_OPERATION_COUNT = REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.TargetSectionReferenceImpl <em>Target Section Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.TargetSectionReferenceImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getTargetSectionReference()
	 * @generated
	 */
	int TARGET_SECTION_REFERENCE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE__NAME = REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE__EREFERENCE = REFERENCE__EREFERENCE;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE__OWNING_CLASS = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Target Section Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE___GET_CONTAINING_SECTION = REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE___GET_CONTAINING_SECTION_MODEL = REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE___IS_LIBRARY_ENTRY = REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE___GET_VALUES_GENERIC = REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Target Section Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_REFERENCE_OPERATION_COUNT = REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.TargetSectionContainmentReferenceImpl <em>Target Section Containment Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.TargetSectionContainmentReferenceImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getTargetSectionContainmentReference()
	 * @generated
	 */
	int TARGET_SECTION_CONTAINMENT_REFERENCE = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CONTAINMENT_REFERENCE__NAME = CONTAINMENT_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CONTAINMENT_REFERENCE__EREFERENCE = CONTAINMENT_REFERENCE__EREFERENCE;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS = CONTAINMENT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CONTAINMENT_REFERENCE__VALUE = CONTAINMENT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Target Section Containment Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CONTAINMENT_REFERENCE_FEATURE_COUNT = CONTAINMENT_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION = CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION_MODEL = CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CONTAINMENT_REFERENCE___IS_LIBRARY_ENTRY = CONTAINMENT_REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CONTAINMENT_REFERENCE___GET_VALUES_GENERIC = CONTAINMENT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Target Section Containment Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_CONTAINMENT_REFERENCE_OPERATION_COUNT = CONTAINMENT_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.TargetSectionNonContainmentReferenceImpl <em>Target Section Non Containment Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.TargetSectionNonContainmentReferenceImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getTargetSectionNonContainmentReference()
	 * @generated
	 */
	int TARGET_SECTION_NON_CONTAINMENT_REFERENCE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_NON_CONTAINMENT_REFERENCE__NAME = NON_CONTAINMENT_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_NON_CONTAINMENT_REFERENCE__EREFERENCE = NON_CONTAINMENT_REFERENCE__EREFERENCE;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_NON_CONTAINMENT_REFERENCE__OWNING_CLASS = NON_CONTAINMENT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_NON_CONTAINMENT_REFERENCE__VALUE = NON_CONTAINMENT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Target Section Non Containment Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_NON_CONTAINMENT_REFERENCE_FEATURE_COUNT = NON_CONTAINMENT_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_NON_CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION = NON_CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_NON_CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION_MODEL = NON_CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_NON_CONTAINMENT_REFERENCE___IS_LIBRARY_ENTRY = NON_CONTAINMENT_REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_NON_CONTAINMENT_REFERENCE___GET_VALUES_GENERIC = NON_CONTAINMENT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Target Section Non Containment Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_NON_CONTAINMENT_REFERENCE_OPERATION_COUNT = NON_CONTAINMENT_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.SourceSectionContainmentReferenceImpl <em>Source Section Containment Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.SourceSectionContainmentReferenceImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getSourceSectionContainmentReference()
	 * @generated
	 */
	int SOURCE_SECTION_CONTAINMENT_REFERENCE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CONTAINMENT_REFERENCE__NAME = CONTAINMENT_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CONTAINMENT_REFERENCE__EREFERENCE = CONTAINMENT_REFERENCE__EREFERENCE;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS = CONTAINMENT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE = CONTAINMENT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Source Section Containment Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CONTAINMENT_REFERENCE_FEATURE_COUNT = CONTAINMENT_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION = CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION_MODEL = CONTAINMENT_REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CONTAINMENT_REFERENCE___IS_LIBRARY_ENTRY = CONTAINMENT_REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CONTAINMENT_REFERENCE___GET_VALUES_GENERIC = CONTAINMENT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Source Section Containment Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_CONTAINMENT_REFERENCE_OPERATION_COUNT = CONTAINMENT_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.MetaModelSectionReferenceImpl <em>Meta Model Section Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.MetaModelSectionReferenceImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getMetaModelSectionReference()
	 * @generated
	 */
	int META_MODEL_SECTION_REFERENCE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_SECTION_REFERENCE__NAME = SOURCE_SECTION_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_SECTION_REFERENCE__EREFERENCE = SOURCE_SECTION_REFERENCE__EREFERENCE;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_SECTION_REFERENCE__OWNING_CLASS = SOURCE_SECTION_REFERENCE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_SECTION_REFERENCE__VALUE = SOURCE_SECTION_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Meta Model Section Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_SECTION_REFERENCE_FEATURE_COUNT = SOURCE_SECTION_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_SECTION_REFERENCE___GET_CONTAINING_SECTION = SOURCE_SECTION_REFERENCE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_SECTION_REFERENCE___GET_CONTAINING_SECTION_MODEL = SOURCE_SECTION_REFERENCE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_SECTION_REFERENCE___IS_LIBRARY_ENTRY = SOURCE_SECTION_REFERENCE___IS_LIBRARY_ENTRY;

	/**
	 * The operation id for the '<em>Get Values Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_SECTION_REFERENCE___GET_VALUES_GENERIC = SOURCE_SECTION_REFERENCE___GET_VALUES_GENERIC;

	/**
	 * The number of operations of the '<em>Meta Model Section Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_SECTION_REFERENCE_OPERATION_COUNT = SOURCE_SECTION_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.AttributeImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = META_MODEL_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = META_MODEL_ELEMENT_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link pamtram.metamodel.impl.SourceSectionAttributeImpl <em>Source Section Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.SourceSectionAttributeImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getSourceSectionAttribute()
	 * @generated
	 */
	int SOURCE_SECTION_ATTRIBUTE = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE = ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT = ATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Source Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION = ATTRIBUTE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL = ATTRIBUTE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE___IS_LIBRARY_ENTRY = ATTRIBUTE___IS_LIBRARY_ENTRY;

	/**
	 * The number of operations of the '<em>Source Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_SECTION_ATTRIBUTE_OPERATION_COUNT = ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.TargetSectionAttributeImpl <em>Target Section Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.TargetSectionAttributeImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getTargetSectionAttribute()
	 * @generated
	 */
	int TARGET_SECTION_ATTRIBUTE = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE__OWNING_CLASS = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE__UNIQUE = ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE__VALUE = ATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Target Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION = ATTRIBUTE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL = ATTRIBUTE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE___IS_LIBRARY_ENTRY = ATTRIBUTE___IS_LIBRARY_ENTRY;

	/**
	 * The number of operations of the '<em>Target Section Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_SECTION_ATTRIBUTE_OPERATION_COUNT = ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.ActualAttributeImpl <em>Actual Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.ActualAttributeImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getActualAttribute()
	 * @generated
	 */
	int ACTUAL_ATTRIBUTE = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE__NAME = TARGET_SECTION_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE__OWNING_CLASS = TARGET_SECTION_ATTRIBUTE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE__UNIQUE = TARGET_SECTION_ATTRIBUTE__UNIQUE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE__VALUE = TARGET_SECTION_ATTRIBUTE__VALUE;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE__ATTRIBUTE = TARGET_SECTION_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Actual Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE_FEATURE_COUNT = TARGET_SECTION_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE___GET_CONTAINING_SECTION = TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL = TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE___IS_LIBRARY_ENTRY = TARGET_SECTION_ATTRIBUTE___IS_LIBRARY_ENTRY;

	/**
	 * The number of operations of the '<em>Actual Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ATTRIBUTE_OPERATION_COUNT = TARGET_SECTION_ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.VirtualAttributeImpl <em>Virtual Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.VirtualAttributeImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getVirtualAttribute()
	 * @generated
	 */
	int VIRTUAL_ATTRIBUTE = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE__NAME = TARGET_SECTION_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE__OWNING_CLASS = TARGET_SECTION_ATTRIBUTE__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE__UNIQUE = TARGET_SECTION_ATTRIBUTE__UNIQUE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE__VALUE = TARGET_SECTION_ATTRIBUTE__VALUE;

	/**
	 * The number of structural features of the '<em>Virtual Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE_FEATURE_COUNT = TARGET_SECTION_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Containing Section</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE___GET_CONTAINING_SECTION = TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION;

	/**
	 * The operation id for the '<em>Get Containing Section Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL = TARGET_SECTION_ATTRIBUTE___GET_CONTAINING_SECTION_MODEL;

	/**
	 * The operation id for the '<em>Is Library Entry</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE___IS_LIBRARY_ENTRY = TARGET_SECTION_ATTRIBUTE___IS_LIBRARY_ENTRY;

	/**
	 * The number of operations of the '<em>Virtual Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ATTRIBUTE_OPERATION_COUNT = TARGET_SECTION_ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.AttributeValueConstraintImpl <em>Attribute Value Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.AttributeValueConstraintImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getAttributeValueConstraint()
	 * @generated
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT__NAME = PamtramPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT__TYPE = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT__VALUE = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Value Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT = PamtramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Value Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT_OPERATION_COUNT = PamtramPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.CaseSensitiveConstraintImpl <em>Case Sensitive Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.CaseSensitiveConstraintImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getCaseSensitiveConstraint()
	 * @generated
	 */
	int CASE_SENSITIVE_CONSTRAINT = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT__NAME = ATTRIBUTE_VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT__TYPE = ATTRIBUTE_VALUE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT__VALUE = ATTRIBUTE_VALUE_CONSTRAINT__VALUE;

	/**
	 * The feature id for the '<em><b>Case Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Case Sensitive Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT_FEATURE_COUNT = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT___CHECK_CONSTRAINT__STRING = ATTRIBUTE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING;

	/**
	 * The number of operations of the '<em>Case Sensitive Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SENSITIVE_CONSTRAINT_OPERATION_COUNT = ATTRIBUTE_VALUE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.EqualityMatcherImpl <em>Equality Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.EqualityMatcherImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getEqualityMatcher()
	 * @generated
	 */
	int EQUALITY_MATCHER = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_MATCHER__NAME = CASE_SENSITIVE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_MATCHER__TYPE = CASE_SENSITIVE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_MATCHER__VALUE = CASE_SENSITIVE_CONSTRAINT__VALUE;

	/**
	 * The feature id for the '<em><b>Case Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_MATCHER__CASE_SENSITIVE = CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE;

	/**
	 * The number of structural features of the '<em>Equality Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_MATCHER_FEATURE_COUNT = CASE_SENSITIVE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_MATCHER___CHECK_CONSTRAINT__STRING = CASE_SENSITIVE_CONSTRAINT___CHECK_CONSTRAINT__STRING;

	/**
	 * The number of operations of the '<em>Equality Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_MATCHER_OPERATION_COUNT = CASE_SENSITIVE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.SubstringMatcherImpl <em>Substring Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.SubstringMatcherImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getSubstringMatcher()
	 * @generated
	 */
	int SUBSTRING_MATCHER = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_MATCHER__NAME = CASE_SENSITIVE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_MATCHER__TYPE = CASE_SENSITIVE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_MATCHER__VALUE = CASE_SENSITIVE_CONSTRAINT__VALUE;

	/**
	 * The feature id for the '<em><b>Case Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_MATCHER__CASE_SENSITIVE = CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE;

	/**
	 * The number of structural features of the '<em>Substring Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_MATCHER_FEATURE_COUNT = CASE_SENSITIVE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_MATCHER___CHECK_CONSTRAINT__STRING = CASE_SENSITIVE_CONSTRAINT___CHECK_CONSTRAINT__STRING;

	/**
	 * The number of operations of the '<em>Substring Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_MATCHER_OPERATION_COUNT = CASE_SENSITIVE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.BeginningMatcherImpl <em>Beginning Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.BeginningMatcherImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getBeginningMatcher()
	 * @generated
	 */
	int BEGINNING_MATCHER = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_MATCHER__NAME = CASE_SENSITIVE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_MATCHER__TYPE = CASE_SENSITIVE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_MATCHER__VALUE = CASE_SENSITIVE_CONSTRAINT__VALUE;

	/**
	 * The feature id for the '<em><b>Case Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_MATCHER__CASE_SENSITIVE = CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE;

	/**
	 * The number of structural features of the '<em>Beginning Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_MATCHER_FEATURE_COUNT = CASE_SENSITIVE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_MATCHER___CHECK_CONSTRAINT__STRING = CASE_SENSITIVE_CONSTRAINT___CHECK_CONSTRAINT__STRING;

	/**
	 * The number of operations of the '<em>Beginning Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGINNING_MATCHER_OPERATION_COUNT = CASE_SENSITIVE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.EndingMatcherImpl <em>Ending Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.EndingMatcherImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getEndingMatcher()
	 * @generated
	 */
	int ENDING_MATCHER = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_MATCHER__NAME = CASE_SENSITIVE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_MATCHER__TYPE = CASE_SENSITIVE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_MATCHER__VALUE = CASE_SENSITIVE_CONSTRAINT__VALUE;

	/**
	 * The feature id for the '<em><b>Case Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_MATCHER__CASE_SENSITIVE = CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE;

	/**
	 * The number of structural features of the '<em>Ending Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_MATCHER_FEATURE_COUNT = CASE_SENSITIVE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_MATCHER___CHECK_CONSTRAINT__STRING = CASE_SENSITIVE_CONSTRAINT___CHECK_CONSTRAINT__STRING;

	/**
	 * The number of operations of the '<em>Ending Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDING_MATCHER_OPERATION_COUNT = CASE_SENSITIVE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.impl.RegExMatcherImpl <em>Reg Ex Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.impl.RegExMatcherImpl
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getRegExMatcher()
	 * @generated
	 */
	int REG_EX_MATCHER = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_MATCHER__NAME = ATTRIBUTE_VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_MATCHER__TYPE = ATTRIBUTE_VALUE_CONSTRAINT__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_MATCHER__VALUE = ATTRIBUTE_VALUE_CONSTRAINT__VALUE;

	/**
	 * The number of structural features of the '<em>Reg Ex Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_MATCHER_FEATURE_COUNT = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Check Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_MATCHER___CHECK_CONSTRAINT__STRING = ATTRIBUTE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING;

	/**
	 * The number of operations of the '<em>Reg Ex Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EX_MATCHER_OPERATION_COUNT = ATTRIBUTE_VALUE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.AttributeValueConstraintType <em>Attribute Value Constraint Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.AttributeValueConstraintType
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getAttributeValueConstraintType()
	 * @generated
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT_TYPE = 30;

	/**
	 * The meta object id for the '{@link pamtram.metamodel.CardinalityType <em>Cardinality Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pamtram.metamodel.CardinalityType
	 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getCardinalityType()
	 * @generated
	 */
	int CARDINALITY_TYPE = 31;


	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.MetaModelElement <em>Meta Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Model Element</em>'.
	 * @see pamtram.metamodel.MetaModelElement
	 * @generated
	 */
	EClass getMetaModelElement();

	/**
	 * Returns the meta object for the '{@link pamtram.metamodel.MetaModelElement#getContainingSection() <em>Get Containing Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Containing Section</em>' operation.
	 * @see pamtram.metamodel.MetaModelElement#getContainingSection()
	 * @generated
	 */
	EOperation getMetaModelElement__GetContainingSection();

	/**
	 * Returns the meta object for the '{@link pamtram.metamodel.MetaModelElement#getContainingSectionModel() <em>Get Containing Section Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Containing Section Model</em>' operation.
	 * @see pamtram.metamodel.MetaModelElement#getContainingSectionModel()
	 * @generated
	 */
	EOperation getMetaModelElement__GetContainingSectionModel();

	/**
	 * Returns the meta object for the '{@link pamtram.metamodel.MetaModelElement#isLibraryEntry() <em>Is Library Entry</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Library Entry</em>' operation.
	 * @see pamtram.metamodel.MetaModelElement#isLibraryEntry()
	 * @generated
	 */
	EOperation getMetaModelElement__IsLibraryEntry();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see pamtram.metamodel.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the reference '{@link pamtram.metamodel.Class#getEClass <em>EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EClass</em>'.
	 * @see pamtram.metamodel.Class#getEClass()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_EClass();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.metamodel.Class#getCardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cardinality</em>'.
	 * @see pamtram.metamodel.Class#getCardinality()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_Cardinality();

	/**
	 * Returns the meta object for the '{@link pamtram.metamodel.Class#getReferencesGeneric() <em>Get References Generic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get References Generic</em>' operation.
	 * @see pamtram.metamodel.Class#getReferencesGeneric()
	 * @generated
	 */
	EOperation getClass__GetReferencesGeneric();

	/**
	 * Returns the meta object for the '{@link pamtram.metamodel.Class#getAttributesGeneric() <em>Get Attributes Generic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Attributes Generic</em>' operation.
	 * @see pamtram.metamodel.Class#getAttributesGeneric()
	 * @generated
	 */
	EOperation getClass__GetAttributesGeneric();

	/**
	 * Returns the meta object for the '{@link pamtram.metamodel.Class#getContainerGeneric() <em>Get Container Generic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Container Generic</em>' operation.
	 * @see pamtram.metamodel.Class#getContainerGeneric()
	 * @generated
	 */
	EOperation getClass__GetContainerGeneric();

	/**
	 * Returns the meta object for the '{@link pamtram.metamodel.Class#isContainerForGeneric(pamtram.metamodel.Class) <em>Is Container For Generic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Container For Generic</em>' operation.
	 * @see pamtram.metamodel.Class#isContainerForGeneric(pamtram.metamodel.Class)
	 * @generated
	 */
	EOperation getClass__IsContainerForGeneric__Class();

	/**
	 * Returns the meta object for the '{@link pamtram.metamodel.Class#isSection() <em>Is Section</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Section</em>' operation.
	 * @see pamtram.metamodel.Class#isSection()
	 * @generated
	 */
	EOperation getClass__IsSection();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.SourceSectionClass <em>Source Section Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Section Class</em>'.
	 * @see pamtram.metamodel.SourceSectionClass
	 * @generated
	 */
	EClass getSourceSectionClass();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.metamodel.SourceSectionClass#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see pamtram.metamodel.SourceSectionClass#getReferences()
	 * @see #getSourceSectionClass()
	 * @generated
	 */
	EReference getSourceSectionClass_References();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.metamodel.SourceSectionClass#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see pamtram.metamodel.SourceSectionClass#getAttributes()
	 * @see #getSourceSectionClass()
	 * @generated
	 */
	EReference getSourceSectionClass_Attributes();

	/**
	 * Returns the meta object for the reference '{@link pamtram.metamodel.SourceSectionClass#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see pamtram.metamodel.SourceSectionClass#getContainer()
	 * @see #getSourceSectionClass()
	 * @generated
	 */
	EReference getSourceSectionClass_Container();

	/**
	 * Returns the meta object for the container reference '{@link pamtram.metamodel.SourceSectionClass#getOwningContainmentReference <em>Owning Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Containment Reference</em>'.
	 * @see pamtram.metamodel.SourceSectionClass#getOwningContainmentReference()
	 * @see #getSourceSectionClass()
	 * @generated
	 */
	EReference getSourceSectionClass_OwningContainmentReference();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.TargetSectionClass <em>Target Section Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Section Class</em>'.
	 * @see pamtram.metamodel.TargetSectionClass
	 * @generated
	 */
	EClass getTargetSectionClass();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.metamodel.TargetSectionClass#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see pamtram.metamodel.TargetSectionClass#getReferences()
	 * @see #getTargetSectionClass()
	 * @generated
	 */
	EReference getTargetSectionClass_References();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.metamodel.TargetSectionClass#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see pamtram.metamodel.TargetSectionClass#getAttributes()
	 * @see #getTargetSectionClass()
	 * @generated
	 */
	EReference getTargetSectionClass_Attributes();

	/**
	 * Returns the meta object for the reference '{@link pamtram.metamodel.TargetSectionClass#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see pamtram.metamodel.TargetSectionClass#getContainer()
	 * @see #getTargetSectionClass()
	 * @generated
	 */
	EReference getTargetSectionClass_Container();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.LibraryParameter <em>Library Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library Parameter</em>'.
	 * @see pamtram.metamodel.LibraryParameter
	 * @generated
	 */
	EClass getLibraryParameter();

	/**
	 * Returns the meta object for the reference '{@link pamtram.metamodel.LibraryParameter#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see pamtram.metamodel.LibraryParameter#getSource()
	 * @see #getLibraryParameter()
	 * @generated
	 */
	EReference getLibraryParameter_Source();

	/**
	 * Returns the meta object for the reference '{@link pamtram.metamodel.LibraryParameter#getOriginalParameter <em>Original Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Parameter</em>'.
	 * @see pamtram.metamodel.LibraryParameter#getOriginalParameter()
	 * @see #getLibraryParameter()
	 * @generated
	 */
	EReference getLibraryParameter_OriginalParameter();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.AttributeParameter <em>Attribute Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Parameter</em>'.
	 * @see pamtram.metamodel.AttributeParameter
	 * @generated
	 */
	EClass getAttributeParameter();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.metamodel.AttributeParameter#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attribute</em>'.
	 * @see pamtram.metamodel.AttributeParameter#getAttribute()
	 * @see #getAttributeParameter()
	 * @generated
	 */
	EReference getAttributeParameter_Attribute();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.ContainerParameter <em>Container Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Parameter</em>'.
	 * @see pamtram.metamodel.ContainerParameter
	 * @generated
	 */
	EClass getContainerParameter();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.metamodel.ContainerParameter#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Class</em>'.
	 * @see pamtram.metamodel.ContainerParameter#getClass_()
	 * @see #getContainerParameter()
	 * @generated
	 */
	EReference getContainerParameter_Class();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.ExternalReferenceParameter <em>External Reference Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Reference Parameter</em>'.
	 * @see pamtram.metamodel.ExternalReferenceParameter
	 * @generated
	 */
	EClass getExternalReferenceParameter();

	/**
	 * Returns the meta object for the containment reference '{@link pamtram.metamodel.ExternalReferenceParameter#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reference</em>'.
	 * @see pamtram.metamodel.ExternalReferenceParameter#getReference()
	 * @see #getExternalReferenceParameter()
	 * @generated
	 */
	EReference getExternalReferenceParameter_Reference();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.LibraryEntry <em>Library Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library Entry</em>'.
	 * @see pamtram.metamodel.LibraryEntry
	 * @generated
	 */
	EClass getLibraryEntry();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.metamodel.LibraryEntry#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see pamtram.metamodel.LibraryEntry#getParameters()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EReference getLibraryEntry_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.metamodel.LibraryEntry#getLibraryFile <em>Library File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Library File</em>'.
	 * @see pamtram.metamodel.LibraryEntry#getLibraryFile()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EAttribute getLibraryEntry_LibraryFile();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.metamodel.LibraryEntry#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see pamtram.metamodel.LibraryEntry#getPath()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EAttribute getLibraryEntry_Path();

	/**
	 * Returns the meta object for the reference '{@link pamtram.metamodel.LibraryEntry#getOriginalLibraryEntry <em>Original Library Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Library Entry</em>'.
	 * @see pamtram.metamodel.LibraryEntry#getOriginalLibraryEntry()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EReference getLibraryEntry_OriginalLibraryEntry();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see pamtram.metamodel.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for the reference '{@link pamtram.metamodel.Reference#getEReference <em>EReference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EReference</em>'.
	 * @see pamtram.metamodel.Reference#getEReference()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_EReference();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.ContainmentReference <em>Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Containment Reference</em>'.
	 * @see pamtram.metamodel.ContainmentReference
	 * @generated
	 */
	EClass getContainmentReference();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.NonContainmentReference <em>Non Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Containment Reference</em>'.
	 * @see pamtram.metamodel.NonContainmentReference
	 * @generated
	 */
	EClass getNonContainmentReference();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.SourceSectionReference <em>Source Section Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Section Reference</em>'.
	 * @see pamtram.metamodel.SourceSectionReference
	 * @generated
	 */
	EClass getSourceSectionReference();

	/**
	 * Returns the meta object for the container reference '{@link pamtram.metamodel.SourceSectionReference#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see pamtram.metamodel.SourceSectionReference#getOwningClass()
	 * @see #getSourceSectionReference()
	 * @generated
	 */
	EReference getSourceSectionReference_OwningClass();

	/**
	 * Returns the meta object for the '{@link pamtram.metamodel.SourceSectionReference#getValuesGeneric() <em>Get Values Generic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Values Generic</em>' operation.
	 * @see pamtram.metamodel.SourceSectionReference#getValuesGeneric()
	 * @generated
	 */
	EOperation getSourceSectionReference__GetValuesGeneric();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.TargetSectionReference <em>Target Section Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Section Reference</em>'.
	 * @see pamtram.metamodel.TargetSectionReference
	 * @generated
	 */
	EClass getTargetSectionReference();

	/**
	 * Returns the meta object for the container reference '{@link pamtram.metamodel.TargetSectionReference#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see pamtram.metamodel.TargetSectionReference#getOwningClass()
	 * @see #getTargetSectionReference()
	 * @generated
	 */
	EReference getTargetSectionReference_OwningClass();

	/**
	 * Returns the meta object for the '{@link pamtram.metamodel.TargetSectionReference#getValuesGeneric() <em>Get Values Generic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Values Generic</em>' operation.
	 * @see pamtram.metamodel.TargetSectionReference#getValuesGeneric()
	 * @generated
	 */
	EOperation getTargetSectionReference__GetValuesGeneric();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.TargetSectionContainmentReference <em>Target Section Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Section Containment Reference</em>'.
	 * @see pamtram.metamodel.TargetSectionContainmentReference
	 * @generated
	 */
	EClass getTargetSectionContainmentReference();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.metamodel.TargetSectionContainmentReference#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see pamtram.metamodel.TargetSectionContainmentReference#getValue()
	 * @see #getTargetSectionContainmentReference()
	 * @generated
	 */
	EReference getTargetSectionContainmentReference_Value();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.TargetSectionNonContainmentReference <em>Target Section Non Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Section Non Containment Reference</em>'.
	 * @see pamtram.metamodel.TargetSectionNonContainmentReference
	 * @generated
	 */
	EClass getTargetSectionNonContainmentReference();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.metamodel.TargetSectionNonContainmentReference#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Value</em>'.
	 * @see pamtram.metamodel.TargetSectionNonContainmentReference#getValue()
	 * @see #getTargetSectionNonContainmentReference()
	 * @generated
	 */
	EReference getTargetSectionNonContainmentReference_Value();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.SourceSectionContainmentReference <em>Source Section Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Section Containment Reference</em>'.
	 * @see pamtram.metamodel.SourceSectionContainmentReference
	 * @generated
	 */
	EClass getSourceSectionContainmentReference();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.metamodel.SourceSectionContainmentReference#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see pamtram.metamodel.SourceSectionContainmentReference#getValue()
	 * @see #getSourceSectionContainmentReference()
	 * @generated
	 */
	EReference getSourceSectionContainmentReference_Value();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.MetaModelSectionReference <em>Meta Model Section Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Model Section Reference</em>'.
	 * @see pamtram.metamodel.MetaModelSectionReference
	 * @generated
	 */
	EClass getMetaModelSectionReference();

	/**
	 * Returns the meta object for the reference list '{@link pamtram.metamodel.MetaModelSectionReference#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Value</em>'.
	 * @see pamtram.metamodel.MetaModelSectionReference#getValue()
	 * @see #getMetaModelSectionReference()
	 * @generated
	 */
	EReference getMetaModelSectionReference_Value();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see pamtram.metamodel.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.SourceSectionAttribute <em>Source Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Section Attribute</em>'.
	 * @see pamtram.metamodel.SourceSectionAttribute
	 * @generated
	 */
	EClass getSourceSectionAttribute();

	/**
	 * Returns the meta object for the container reference '{@link pamtram.metamodel.SourceSectionAttribute#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see pamtram.metamodel.SourceSectionAttribute#getOwningClass()
	 * @see #getSourceSectionAttribute()
	 * @generated
	 */
	EReference getSourceSectionAttribute_OwningClass();

	/**
	 * Returns the meta object for the reference '{@link pamtram.metamodel.SourceSectionAttribute#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see pamtram.metamodel.SourceSectionAttribute#getAttribute()
	 * @see #getSourceSectionAttribute()
	 * @generated
	 */
	EReference getSourceSectionAttribute_Attribute();

	/**
	 * Returns the meta object for the containment reference list '{@link pamtram.metamodel.SourceSectionAttribute#getValueConstraint <em>Value Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value Constraint</em>'.
	 * @see pamtram.metamodel.SourceSectionAttribute#getValueConstraint()
	 * @see #getSourceSectionAttribute()
	 * @generated
	 */
	EReference getSourceSectionAttribute_ValueConstraint();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.TargetSectionAttribute <em>Target Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Section Attribute</em>'.
	 * @see pamtram.metamodel.TargetSectionAttribute
	 * @generated
	 */
	EClass getTargetSectionAttribute();

	/**
	 * Returns the meta object for the container reference '{@link pamtram.metamodel.TargetSectionAttribute#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see pamtram.metamodel.TargetSectionAttribute#getOwningClass()
	 * @see #getTargetSectionAttribute()
	 * @generated
	 */
	EReference getTargetSectionAttribute_OwningClass();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.metamodel.TargetSectionAttribute#isUnique <em>Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unique</em>'.
	 * @see pamtram.metamodel.TargetSectionAttribute#isUnique()
	 * @see #getTargetSectionAttribute()
	 * @generated
	 */
	EAttribute getTargetSectionAttribute_Unique();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.metamodel.TargetSectionAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see pamtram.metamodel.TargetSectionAttribute#getValue()
	 * @see #getTargetSectionAttribute()
	 * @generated
	 */
	EAttribute getTargetSectionAttribute_Value();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.ActualAttribute <em>Actual Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actual Attribute</em>'.
	 * @see pamtram.metamodel.ActualAttribute
	 * @generated
	 */
	EClass getActualAttribute();

	/**
	 * Returns the meta object for the reference '{@link pamtram.metamodel.ActualAttribute#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see pamtram.metamodel.ActualAttribute#getAttribute()
	 * @see #getActualAttribute()
	 * @generated
	 */
	EReference getActualAttribute_Attribute();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.VirtualAttribute <em>Virtual Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Attribute</em>'.
	 * @see pamtram.metamodel.VirtualAttribute
	 * @generated
	 */
	EClass getVirtualAttribute();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.EqualityMatcher <em>Equality Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equality Matcher</em>'.
	 * @see pamtram.metamodel.EqualityMatcher
	 * @generated
	 */
	EClass getEqualityMatcher();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.AttributeValueConstraint <em>Attribute Value Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Value Constraint</em>'.
	 * @see pamtram.metamodel.AttributeValueConstraint
	 * @generated
	 */
	EClass getAttributeValueConstraint();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.metamodel.AttributeValueConstraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see pamtram.metamodel.AttributeValueConstraint#getType()
	 * @see #getAttributeValueConstraint()
	 * @generated
	 */
	EAttribute getAttributeValueConstraint_Type();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.metamodel.AttributeValueConstraint#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see pamtram.metamodel.AttributeValueConstraint#getValue()
	 * @see #getAttributeValueConstraint()
	 * @generated
	 */
	EAttribute getAttributeValueConstraint_Value();

	/**
	 * Returns the meta object for the '{@link pamtram.metamodel.AttributeValueConstraint#checkConstraint(java.lang.String) <em>Check Constraint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Check Constraint</em>' operation.
	 * @see pamtram.metamodel.AttributeValueConstraint#checkConstraint(java.lang.String)
	 * @generated
	 */
	EOperation getAttributeValueConstraint__CheckConstraint__String();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.SubstringMatcher <em>Substring Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Substring Matcher</em>'.
	 * @see pamtram.metamodel.SubstringMatcher
	 * @generated
	 */
	EClass getSubstringMatcher();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.BeginningMatcher <em>Beginning Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Beginning Matcher</em>'.
	 * @see pamtram.metamodel.BeginningMatcher
	 * @generated
	 */
	EClass getBeginningMatcher();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.EndingMatcher <em>Ending Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ending Matcher</em>'.
	 * @see pamtram.metamodel.EndingMatcher
	 * @generated
	 */
	EClass getEndingMatcher();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.RegExMatcher <em>Reg Ex Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reg Ex Matcher</em>'.
	 * @see pamtram.metamodel.RegExMatcher
	 * @generated
	 */
	EClass getRegExMatcher();

	/**
	 * Returns the meta object for class '{@link pamtram.metamodel.CaseSensitiveConstraint <em>Case Sensitive Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Sensitive Constraint</em>'.
	 * @see pamtram.metamodel.CaseSensitiveConstraint
	 * @generated
	 */
	EClass getCaseSensitiveConstraint();

	/**
	 * Returns the meta object for the attribute '{@link pamtram.metamodel.CaseSensitiveConstraint#isCaseSensitive <em>Case Sensitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Case Sensitive</em>'.
	 * @see pamtram.metamodel.CaseSensitiveConstraint#isCaseSensitive()
	 * @see #getCaseSensitiveConstraint()
	 * @generated
	 */
	EAttribute getCaseSensitiveConstraint_CaseSensitive();

	/**
	 * Returns the meta object for enum '{@link pamtram.metamodel.AttributeValueConstraintType <em>Attribute Value Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Attribute Value Constraint Type</em>'.
	 * @see pamtram.metamodel.AttributeValueConstraintType
	 * @generated
	 */
	EEnum getAttributeValueConstraintType();

	/**
	 * Returns the meta object for enum '{@link pamtram.metamodel.CardinalityType <em>Cardinality Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cardinality Type</em>'.
	 * @see pamtram.metamodel.CardinalityType
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
	MetamodelFactory getMetamodelFactory();

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
		 * The meta object literal for the '{@link pamtram.metamodel.impl.MetaModelElementImpl <em>Meta Model Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.MetaModelElementImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getMetaModelElement()
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
		 * The meta object literal for the '{@link pamtram.metamodel.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.ClassImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getClass_()
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
		 * The meta object literal for the '<em><b>Get References Generic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___GET_REFERENCES_GENERIC = eINSTANCE.getClass__GetReferencesGeneric();

		/**
		 * The meta object literal for the '<em><b>Get Attributes Generic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___GET_ATTRIBUTES_GENERIC = eINSTANCE.getClass__GetAttributesGeneric();

		/**
		 * The meta object literal for the '<em><b>Get Container Generic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___GET_CONTAINER_GENERIC = eINSTANCE.getClass__GetContainerGeneric();

		/**
		 * The meta object literal for the '<em><b>Is Container For Generic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_CONTAINER_FOR_GENERIC__CLASS = eINSTANCE.getClass__IsContainerForGeneric__Class();

		/**
		 * The meta object literal for the '<em><b>Is Section</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_SECTION = eINSTANCE.getClass__IsSection();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.SourceSectionClassImpl <em>Source Section Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.SourceSectionClassImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getSourceSectionClass()
		 * @generated
		 */
		EClass SOURCE_SECTION_CLASS = eINSTANCE.getSourceSectionClass();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_SECTION_CLASS__REFERENCES = eINSTANCE.getSourceSectionClass_References();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_SECTION_CLASS__ATTRIBUTES = eINSTANCE.getSourceSectionClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_SECTION_CLASS__CONTAINER = eINSTANCE.getSourceSectionClass_Container();

		/**
		 * The meta object literal for the '<em><b>Owning Containment Reference</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE = eINSTANCE.getSourceSectionClass_OwningContainmentReference();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.TargetSectionClassImpl <em>Target Section Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.TargetSectionClassImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getTargetSectionClass()
		 * @generated
		 */
		EClass TARGET_SECTION_CLASS = eINSTANCE.getTargetSectionClass();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_SECTION_CLASS__REFERENCES = eINSTANCE.getTargetSectionClass_References();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_SECTION_CLASS__ATTRIBUTES = eINSTANCE.getTargetSectionClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_SECTION_CLASS__CONTAINER = eINSTANCE.getTargetSectionClass_Container();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.LibraryParameterImpl <em>Library Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.LibraryParameterImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getLibraryParameter()
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
		 * The meta object literal for the '{@link pamtram.metamodel.impl.AttributeParameterImpl <em>Attribute Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.AttributeParameterImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getAttributeParameter()
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
		 * The meta object literal for the '{@link pamtram.metamodel.impl.ContainerParameterImpl <em>Container Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.ContainerParameterImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getContainerParameter()
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
		 * The meta object literal for the '{@link pamtram.metamodel.impl.ExternalReferenceParameterImpl <em>External Reference Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.ExternalReferenceParameterImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getExternalReferenceParameter()
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
		 * The meta object literal for the '{@link pamtram.metamodel.impl.LibraryEntryImpl <em>Library Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.LibraryEntryImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getLibraryEntry()
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
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY_ENTRY__PATH = eINSTANCE.getLibraryEntry_Path();

		/**
		 * The meta object literal for the '<em><b>Original Library Entry</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY = eINSTANCE.getLibraryEntry_OriginalLibraryEntry();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.ReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.ReferenceImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>EReference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE__EREFERENCE = eINSTANCE.getReference_EReference();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.ContainmentReferenceImpl <em>Containment Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.ContainmentReferenceImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getContainmentReference()
		 * @generated
		 */
		EClass CONTAINMENT_REFERENCE = eINSTANCE.getContainmentReference();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.NonContainmentReferenceImpl <em>Non Containment Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.NonContainmentReferenceImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getNonContainmentReference()
		 * @generated
		 */
		EClass NON_CONTAINMENT_REFERENCE = eINSTANCE.getNonContainmentReference();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.SourceSectionReferenceImpl <em>Source Section Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.SourceSectionReferenceImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getSourceSectionReference()
		 * @generated
		 */
		EClass SOURCE_SECTION_REFERENCE = eINSTANCE.getSourceSectionReference();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_SECTION_REFERENCE__OWNING_CLASS = eINSTANCE.getSourceSectionReference_OwningClass();

		/**
		 * The meta object literal for the '<em><b>Get Values Generic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SOURCE_SECTION_REFERENCE___GET_VALUES_GENERIC = eINSTANCE.getSourceSectionReference__GetValuesGeneric();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.TargetSectionReferenceImpl <em>Target Section Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.TargetSectionReferenceImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getTargetSectionReference()
		 * @generated
		 */
		EClass TARGET_SECTION_REFERENCE = eINSTANCE.getTargetSectionReference();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_SECTION_REFERENCE__OWNING_CLASS = eINSTANCE.getTargetSectionReference_OwningClass();

		/**
		 * The meta object literal for the '<em><b>Get Values Generic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TARGET_SECTION_REFERENCE___GET_VALUES_GENERIC = eINSTANCE.getTargetSectionReference__GetValuesGeneric();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.TargetSectionContainmentReferenceImpl <em>Target Section Containment Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.TargetSectionContainmentReferenceImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getTargetSectionContainmentReference()
		 * @generated
		 */
		EClass TARGET_SECTION_CONTAINMENT_REFERENCE = eINSTANCE.getTargetSectionContainmentReference();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_SECTION_CONTAINMENT_REFERENCE__VALUE = eINSTANCE.getTargetSectionContainmentReference_Value();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.TargetSectionNonContainmentReferenceImpl <em>Target Section Non Containment Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.TargetSectionNonContainmentReferenceImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getTargetSectionNonContainmentReference()
		 * @generated
		 */
		EClass TARGET_SECTION_NON_CONTAINMENT_REFERENCE = eINSTANCE.getTargetSectionNonContainmentReference();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_SECTION_NON_CONTAINMENT_REFERENCE__VALUE = eINSTANCE.getTargetSectionNonContainmentReference_Value();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.SourceSectionContainmentReferenceImpl <em>Source Section Containment Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.SourceSectionContainmentReferenceImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getSourceSectionContainmentReference()
		 * @generated
		 */
		EClass SOURCE_SECTION_CONTAINMENT_REFERENCE = eINSTANCE.getSourceSectionContainmentReference();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE = eINSTANCE.getSourceSectionContainmentReference_Value();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.MetaModelSectionReferenceImpl <em>Meta Model Section Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.MetaModelSectionReferenceImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getMetaModelSectionReference()
		 * @generated
		 */
		EClass META_MODEL_SECTION_REFERENCE = eINSTANCE.getMetaModelSectionReference();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_MODEL_SECTION_REFERENCE__VALUE = eINSTANCE.getMetaModelSectionReference_Value();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.AttributeImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.SourceSectionAttributeImpl <em>Source Section Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.SourceSectionAttributeImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getSourceSectionAttribute()
		 * @generated
		 */
		EClass SOURCE_SECTION_ATTRIBUTE = eINSTANCE.getSourceSectionAttribute();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS = eINSTANCE.getSourceSectionAttribute_OwningClass();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE = eINSTANCE.getSourceSectionAttribute_Attribute();

		/**
		 * The meta object literal for the '<em><b>Value Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT = eINSTANCE.getSourceSectionAttribute_ValueConstraint();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.TargetSectionAttributeImpl <em>Target Section Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.TargetSectionAttributeImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getTargetSectionAttribute()
		 * @generated
		 */
		EClass TARGET_SECTION_ATTRIBUTE = eINSTANCE.getTargetSectionAttribute();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_SECTION_ATTRIBUTE__OWNING_CLASS = eINSTANCE.getTargetSectionAttribute_OwningClass();

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
		 * The meta object literal for the '{@link pamtram.metamodel.impl.ActualAttributeImpl <em>Actual Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.ActualAttributeImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getActualAttribute()
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
		 * The meta object literal for the '{@link pamtram.metamodel.impl.VirtualAttributeImpl <em>Virtual Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.VirtualAttributeImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getVirtualAttribute()
		 * @generated
		 */
		EClass VIRTUAL_ATTRIBUTE = eINSTANCE.getVirtualAttribute();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.EqualityMatcherImpl <em>Equality Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.EqualityMatcherImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getEqualityMatcher()
		 * @generated
		 */
		EClass EQUALITY_MATCHER = eINSTANCE.getEqualityMatcher();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.AttributeValueConstraintImpl <em>Attribute Value Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.AttributeValueConstraintImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getAttributeValueConstraint()
		 * @generated
		 */
		EClass ATTRIBUTE_VALUE_CONSTRAINT = eINSTANCE.getAttributeValueConstraint();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_VALUE_CONSTRAINT__TYPE = eINSTANCE.getAttributeValueConstraint_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_VALUE_CONSTRAINT__VALUE = eINSTANCE.getAttributeValueConstraint_Value();

		/**
		 * The meta object literal for the '<em><b>Check Constraint</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING = eINSTANCE.getAttributeValueConstraint__CheckConstraint__String();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.SubstringMatcherImpl <em>Substring Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.SubstringMatcherImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getSubstringMatcher()
		 * @generated
		 */
		EClass SUBSTRING_MATCHER = eINSTANCE.getSubstringMatcher();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.BeginningMatcherImpl <em>Beginning Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.BeginningMatcherImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getBeginningMatcher()
		 * @generated
		 */
		EClass BEGINNING_MATCHER = eINSTANCE.getBeginningMatcher();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.EndingMatcherImpl <em>Ending Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.EndingMatcherImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getEndingMatcher()
		 * @generated
		 */
		EClass ENDING_MATCHER = eINSTANCE.getEndingMatcher();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.RegExMatcherImpl <em>Reg Ex Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.RegExMatcherImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getRegExMatcher()
		 * @generated
		 */
		EClass REG_EX_MATCHER = eINSTANCE.getRegExMatcher();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.impl.CaseSensitiveConstraintImpl <em>Case Sensitive Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.impl.CaseSensitiveConstraintImpl
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getCaseSensitiveConstraint()
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
		 * The meta object literal for the '{@link pamtram.metamodel.AttributeValueConstraintType <em>Attribute Value Constraint Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.AttributeValueConstraintType
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getAttributeValueConstraintType()
		 * @generated
		 */
		EEnum ATTRIBUTE_VALUE_CONSTRAINT_TYPE = eINSTANCE.getAttributeValueConstraintType();

		/**
		 * The meta object literal for the '{@link pamtram.metamodel.CardinalityType <em>Cardinality Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pamtram.metamodel.CardinalityType
		 * @see pamtram.metamodel.impl.MetamodelPackageImpl#getCardinalityType()
		 * @generated
		 */
		EEnum CARDINALITY_TYPE = eINSTANCE.getCardinalityType();

	}

} //MetamodelPackage