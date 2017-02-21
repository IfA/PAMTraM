/**
 */
package pamtram.structure.library;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.structure.library.LibraryPackage
 * @generated
 */
public interface LibraryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LibraryFactory eINSTANCE = pamtram.structure.library.impl.LibraryFactoryImpl.init();

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
	 * Returns a new object of class '<em>Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entry</em>'.
	 * @generated
	 */
	LibraryEntry createLibraryEntry();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LibraryPackage getLibraryPackage();

} //LibraryFactory
