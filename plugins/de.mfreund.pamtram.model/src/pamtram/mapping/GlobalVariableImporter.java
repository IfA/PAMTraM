/**
 */
package pamtram.mapping;

import pamtram.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Variable Importer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.GlobalVariableImporter#getGlobalVariable <em>Global Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getGlobalVariableImporter()
 * @model
 * @generated
 */
public interface GlobalVariableImporter extends NamedElement, ComplexAttributeMappingSourceInterface {
	/**
	 * Returns the value of the '<em><b>Global Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Variable</em>' reference.
	 * @see #setGlobalVariable(GlobalVariable)
	 * @see pamtram.mapping.MappingPackage#getGlobalVariableImporter_GlobalVariable()
	 * @model required="true"
	 * @generated
	 */
	GlobalVariable getGlobalVariable();

	/**
	 * Sets the value of the '{@link pamtram.mapping.GlobalVariableImporter#getGlobalVariable <em>Global Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Variable</em>' reference.
	 * @see #getGlobalVariable()
	 * @generated
	 */
	void setGlobalVariable(GlobalVariable value);

} // GlobalVariableImporter
