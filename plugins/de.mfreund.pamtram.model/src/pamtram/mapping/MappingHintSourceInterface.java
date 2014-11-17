/**
 */
package pamtram.mapping;

import org.eclipse.emf.ecore.EObject;

import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hint Source Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getMappingHintSourceInterface()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface MappingHintSourceInterface extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	SourceSectionAttribute getSourceAttribute();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getName();

} // MappingHintSourceInterface
