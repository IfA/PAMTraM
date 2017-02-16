/**
 */
package pamtram.structure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.structure.StructurePackage
 * @generated
 */
public interface StructureFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StructureFactory eINSTANCE = pamtram.structure.impl.StructureFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Attribute Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Parameter</em>'.
	 * @generated
	 */
	AttributeParameter createAttributeParameter();

	/**
	 * Returns a new object of class '<em>Container Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container Parameter</em>'.
	 * @generated
	 */
	ContainerParameter createContainerParameter();

	/**
	 * Returns a new object of class '<em>External Reference Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Reference Parameter</em>'.
	 * @generated
	 */
	ExternalReferenceParameter createExternalReferenceParameter();

	/**
	 * Returns a new object of class '<em>Resource Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Parameter</em>'.
	 * @generated
	 */
	ResourceParameter createResourceParameter();

	/**
	 * Returns a new object of class '<em>Library Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Library Entry</em>'.
	 * @generated
	 */
	LibraryEntry createLibraryEntry();

	/**
	 * Returns a new object of class '<em>Instance Pointer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Pointer</em>'.
	 * @generated
	 */
	InstanceSelector createInstancePointer();

	/**
	 * Returns a new object of class '<em>Instance Pointer Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Pointer Source Element</em>'.
	 * @generated
	 */
	InstanceSelectorSourceElement createInstancePointerSourceElement();

	/**
	 * Returns a new object of class '<em>Instance Pointer External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Pointer External Source Element</em>'.
	 * @generated
	 */
	InstanceSelectorExternalSourceElement createInstancePointerExternalSourceElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StructurePackage getStructurePackage();



} //StructureFactory
