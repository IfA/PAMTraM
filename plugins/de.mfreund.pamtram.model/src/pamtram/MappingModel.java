/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.GlobalValue;
import pamtram.mapping.Mapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.MappingModel#getMapping <em>Mapping</em>}</li>
 *   <li>{@link pamtram.MappingModel#getModifierSets <em>Modifier Sets</em>}</li>
 *   <li>{@link pamtram.MappingModel#getGlobalValues <em>Global Values</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getMappingModel()
 * @model
 * @generated
 */
public interface MappingModel extends NamedElement {
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram!MappingModel!mapping'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram!MappingModel!modifierSets'"
	 * @generated
	 */
	EList<AttributeValueModifierSet> getModifierSets();

	/**
	 * Returns the value of the '<em><b>Global Values</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.GlobalValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Values</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getMappingModel_GlobalValues()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram!MappingModel!globalValues'"
	 * @generated
	 */
	EList<GlobalValue> getGlobalValues();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<Mapping> mappings = getMapping();\r\nEList<Mapping> activeMappings = new BasicEList<>();\r\nfor (Mapping mapping : mappings) {\r\n\tif(!mapping.isDeactivated()) {\r\n\t\tactiveMappings.add(mapping);\r\n\t}\r\n}\r\nreturn activeMappings;'"
	 * @generated
	 */
	EList<Mapping> getActiveMappings();

} // MappingModel
