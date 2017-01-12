/**
 */
package pamtram.structure.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import pamtram.structure.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StructureFactoryImpl extends EFactoryImpl implements StructureFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StructureFactory init() {
		try {
			StructureFactory theStructureFactory = (StructureFactory)EPackage.Registry.INSTANCE.getEFactory(StructurePackage.eNS_URI);
			if (theStructureFactory != null) {
				return theStructureFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StructureFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StructurePackage.SOURCE_SECTION: return createSourceSection();
			case StructurePackage.TARGET_SECTION: return createTargetSection();
			case StructurePackage.FILE_ATTRIBUTE: return createFileAttribute();
			case StructurePackage.SOURCE_SECTION_CLASS: return createSourceSectionClass();
			case StructurePackage.TARGET_SECTION_CLASS: return createTargetSectionClass();
			case StructurePackage.ATTRIBUTE_PARAMETER: return createAttributeParameter();
			case StructurePackage.CONTAINER_PARAMETER: return createContainerParameter();
			case StructurePackage.EXTERNAL_REFERENCE_PARAMETER: return createExternalReferenceParameter();
			case StructurePackage.RESOURCE_PARAMETER: return createResourceParameter();
			case StructurePackage.LIBRARY_ENTRY: return createLibraryEntry();
			case StructurePackage.TARGET_SECTION_COMPOSITE_REFERENCE: return createTargetSectionCompositeReference();
			case StructurePackage.TARGET_SECTION_CROSS_REFERENCE: return createTargetSectionCrossReference();
			case StructurePackage.SOURCE_SECTION_COMPOSITE_REFERENCE: return createSourceSectionCompositeReference();
			case StructurePackage.SOURCE_SECTION_CROSS_REFERENCE: return createSourceSectionCrossReference();
			case StructurePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE: return createActualSourceSectionAttribute();
			case StructurePackage.ACTUAL_TARGET_SECTION_ATTRIBUTE: return createActualTargetSectionAttribute();
			case StructurePackage.VIRTUAL_TARGET_SECTION_ATTRIBUTE: return createVirtualTargetSectionAttribute();
			case StructurePackage.INSTANCE_POINTER: return createInstancePointer();
			case StructurePackage.INSTANCE_POINTER_SOURCE_ELEMENT: return createInstancePointerSourceElement();
			case StructurePackage.INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT: return createInstancePointerExternalSourceElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case StructurePackage.FILE_TYPE_ENUM:
				return createFileTypeEnumFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case StructurePackage.FILE_TYPE_ENUM:
				return convertFileTypeEnumToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSection createSourceSection() {
		SourceSectionImpl sourceSection = new SourceSectionImpl();
		return sourceSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSection createTargetSection() {
		TargetSectionImpl targetSection = new TargetSectionImpl();
		return targetSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileAttribute createFileAttribute() {
		FileAttributeImpl fileAttribute = new FileAttributeImpl();
		return fileAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass createSourceSectionClass() {
		SourceSectionClassImpl sourceSectionClass = new SourceSectionClassImpl();
		return sourceSectionClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass createTargetSectionClass() {
		TargetSectionClassImpl targetSectionClass = new TargetSectionClassImpl();
		return targetSectionClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeParameter createAttributeParameter() {
		AttributeParameterImpl attributeParameter = new AttributeParameterImpl();
		return attributeParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerParameter createContainerParameter() {
		ContainerParameterImpl containerParameter = new ContainerParameterImpl();
		return containerParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalReferenceParameter createExternalReferenceParameter() {
		ExternalReferenceParameterImpl externalReferenceParameter = new ExternalReferenceParameterImpl();
		return externalReferenceParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceParameter createResourceParameter() {
		ResourceParameterImpl resourceParameter = new ResourceParameterImpl();
		return resourceParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryEntry createLibraryEntry() {
		LibraryEntryImpl libraryEntry = new LibraryEntryImpl();
		return libraryEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionCompositeReference createTargetSectionCompositeReference() {
		TargetSectionCompositeReferenceImpl targetSectionCompositeReference = new TargetSectionCompositeReferenceImpl();
		return targetSectionCompositeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionCrossReference createTargetSectionCrossReference() {
		TargetSectionCrossReferenceImpl targetSectionCrossReference = new TargetSectionCrossReferenceImpl();
		return targetSectionCrossReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionCompositeReference createSourceSectionCompositeReference() {
		SourceSectionCompositeReferenceImpl sourceSectionCompositeReference = new SourceSectionCompositeReferenceImpl();
		return sourceSectionCompositeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionCrossReference createSourceSectionCrossReference() {
		SourceSectionCrossReferenceImpl sourceSectionCrossReference = new SourceSectionCrossReferenceImpl();
		return sourceSectionCrossReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualSourceSectionAttribute createActualSourceSectionAttribute() {
		ActualSourceSectionAttributeImpl actualSourceSectionAttribute = new ActualSourceSectionAttributeImpl();
		return actualSourceSectionAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualTargetSectionAttribute createActualTargetSectionAttribute() {
		ActualTargetSectionAttributeImpl actualTargetSectionAttribute = new ActualTargetSectionAttributeImpl();
		return actualTargetSectionAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualTargetSectionAttribute createVirtualTargetSectionAttribute() {
		VirtualTargetSectionAttributeImpl virtualTargetSectionAttribute = new VirtualTargetSectionAttributeImpl();
		return virtualTargetSectionAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstancePointer createInstancePointer() {
		InstancePointerImpl instancePointer = new InstancePointerImpl();
		return instancePointer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstancePointerSourceElement createInstancePointerSourceElement() {
		InstancePointerSourceElementImpl instancePointerSourceElement = new InstancePointerSourceElementImpl();
		return instancePointerSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstancePointerExternalSourceElement createInstancePointerExternalSourceElement() {
		InstancePointerExternalSourceElementImpl instancePointerExternalSourceElement = new InstancePointerExternalSourceElementImpl();
		return instancePointerExternalSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileTypeEnum createFileTypeEnumFromString(EDataType eDataType, String initialValue) {
		FileTypeEnum result = FileTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFileTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructurePackage getStructurePackage() {
		return (StructurePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StructurePackage getPackage() {
		return StructurePackage.eINSTANCE;
	}

} //StructureFactoryImpl
