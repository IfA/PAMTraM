/**
 */
package pamtram;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.PamtramPackage
 * @generated
 */
public interface PamtramFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PamtramFactory eINSTANCE = pamtram.impl.PamtramFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>PAM Tra M</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PAM Tra M</em>'.
	 * @generated
	 */
	PAMTraM createPAMTraM();

	/**
	 * Returns a new object of class '<em>Source Section Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Section Model</em>'.
	 * @generated
	 */
	SourceSectionModel createSourceSectionModel();

	/**
	 * Returns a new object of class '<em>Target Section Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Section Model</em>'.
	 * @generated
	 */
	TargetSectionModel createTargetSectionModel();

	/**
	 * Returns a new object of class '<em>Mapping Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Model</em>'.
	 * @generated
	 */
	MappingModel createMappingModel();

	/**
	 * Returns a new object of class '<em>Condition Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition Model</em>'.
	 * @generated
	 */
	ConditionModel createConditionModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PamtramPackage getPamtramPackage();

} //PamtramFactory
