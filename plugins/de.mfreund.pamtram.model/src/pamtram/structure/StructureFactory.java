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
	 * Returns a new object of class '<em>Source Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Instance Selector</em>'.
	 * @generated
	 */
	SourceInstanceSelector createSourceInstanceSelector();

	/**
	 * Returns a new object of class '<em>Instance Selector Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Selector Source Element</em>'.
	 * @generated
	 */
	InstanceSelectorSourceElement createInstanceSelectorSourceElement();

	/**
	 * Returns a new object of class '<em>Instance Selector External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Selector External Source Element</em>'.
	 * @generated
	 */
	InstanceSelectorExternalSourceElement createInstanceSelectorExternalSourceElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StructurePackage getStructurePackage();



} //StructureFactory
