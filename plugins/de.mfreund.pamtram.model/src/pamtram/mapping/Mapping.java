/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import pamtram.condition.ComplexCondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.Mapping#getCondition <em>Condition</em>}</li>
 *   <li>{@link pamtram.mapping.Mapping#getMappingHintGroups <em>Mapping Hint Groups</em>}</li>
 *   <li>{@link pamtram.mapping.Mapping#getImportedMappingHintGroups <em>Imported Mapping Hint Groups</em>}</li>
 *   <li>{@link pamtram.mapping.Mapping#getGlobalVariables <em>Global Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends MappingType {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(ComplexCondition)
	 * @see pamtram.mapping.MappingPackage#getMapping_Condition()
	 * @model containment="true"
	 * @generated
	 */
	ComplexCondition getCondition();

	/**
	 * Sets the value of the '{@link pamtram.mapping.Mapping#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(ComplexCondition value);

	/**
	 * Returns the value of the '<em><b>Mapping Hint Groups</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHintGroupType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Hint Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Hint Groups</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getMapping_MappingHintGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingHintGroupType> getMappingHintGroups();

	/**
	 * Returns the value of the '<em><b>Imported Mapping Hint Groups</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHintGroupImporter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Mapping Hint Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Mapping Hint Groups</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getMapping_ImportedMappingHintGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingHintGroupImporter> getImportedMappingHintGroups();

	/**
	 * Returns the value of the '<em><b>Global Variables</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.GlobalVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Variables</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getMapping_GlobalVariables()
	 * @model containment="true"
	 * @generated
	 */
	EList<GlobalVariable> getGlobalVariables();

} // Mapping
