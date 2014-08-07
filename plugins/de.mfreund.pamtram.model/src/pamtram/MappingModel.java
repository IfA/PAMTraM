/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.Mapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.MappingModel#getMapping <em>Mapping</em>}</li>
 *   <li>{@link pamtram.MappingModel#getModifierSets <em>Modifier Sets</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.PamtramPackage#getMappingModel()
 * @model
 * @generated
 */
public interface MappingModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getMappingModel_Mapping()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Mapping> getMapping();

	/**
	 * Returns the value of the '<em><b>Modifier Sets</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.AttributeValueModifierSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier Sets</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getMappingModel_ModifierSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttributeValueModifierSet> getModifierSets();

} // MappingModel
