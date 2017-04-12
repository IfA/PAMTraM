/**
 */
package pamtram.mapping.extended;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.mapping.extended.ExtendedPackage
 * @generated
 */
public interface ExtendedFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExtendedFactory eINSTANCE = pamtram.mapping.extended.impl.ExtendedFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Test</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test</em>'.
	 * @generated
	 */
	Test createTest();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExtendedPackage getExtendedPackage();

	/**
	 * Returns a new object of class '<em>Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Mapping</em>'.
	 * @generated
	 */
	AttributeMapping createAttributeMapping();

	/**
	 * Returns a new object of class '<em>Attribute Mapping</em>' that
	 * already contains a source element.
	 * @return a new object of class '<em>Attribute Mapping</em>'.
	 */
	AttributeMapping createAttributeMappingWithSource();

	/**
	 * Returns a new object of class '<em>Attribute Mapping Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Mapping Source Element</em>'.
	 * @generated
	 */
	AttributeMappingSourceElement createAttributeMappingSourceElement();

	/**
	 * Returns a new object of class '<em>Attribute Mapping External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Mapping External Source Element</em>'.
	 * @generated
	 */
	AttributeMappingExternalSourceElement createAttributeMappingExternalSourceElement();

	/**
	 * Returns a new object of class '<em>Attribute Mapping Global Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Mapping Global Source Element</em>'.
	 * @generated
	 */
	AttributeMappingGlobalSourceElement createAttributeMappingGlobalSourceElement();

} //ExtendedFactory
