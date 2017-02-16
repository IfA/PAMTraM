/**
 */
package pamtram.structure.impl;

import org.eclipse.emf.ecore.EClass;
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
			case StructurePackage.ATTRIBUTE_PARAMETER: return createAttributeParameter();
			case StructurePackage.CONTAINER_PARAMETER: return createContainerParameter();
			case StructurePackage.EXTERNAL_REFERENCE_PARAMETER: return createExternalReferenceParameter();
			case StructurePackage.RESOURCE_PARAMETER: return createResourceParameter();
			case StructurePackage.LIBRARY_ENTRY: return createLibraryEntry();
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
	public InstanceSelector createInstancePointer() {
		InstanceSelectorImpl instancePointer = new InstanceSelectorImpl();
		return instancePointer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSelectorSourceElement createInstancePointerSourceElement() {
		InstanceSelectorSourceElementImpl instancePointerSourceElement = new InstanceSelectorSourceElementImpl();
		return instancePointerSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSelectorExternalSourceElement createInstancePointerExternalSourceElement() {
		InstanceSelectorExternalSourceElementImpl instancePointerExternalSourceElement = new InstanceSelectorExternalSourceElementImpl();
		return instancePointerExternalSourceElement;
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
