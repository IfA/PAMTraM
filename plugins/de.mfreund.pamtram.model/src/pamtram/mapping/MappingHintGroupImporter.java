/**
 */
package pamtram.mapping;

import pamtram.NamedElement;

import pamtram.metamodel.TargetSectionClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hint Group Importer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.MappingHintGroupImporter#getHintGroup <em>Hint Group</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupImporter#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getMappingHintGroupImporter()
 * @model
 * @generated
 */
public interface MappingHintGroupImporter extends NamedElement, InstantiableMappingHintGroup {
	/**
	 * Returns the value of the '<em><b>Hint Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hint Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hint Group</em>' reference.
	 * @see #setHintGroup(ExportedMappingHintGroup)
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupImporter_HintGroup()
	 * @model required="true"
	 * @generated
	 */
	ExportedMappingHintGroup getHintGroup();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getHintGroup <em>Hint Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hint Group</em>' reference.
	 * @see #getHintGroup()
	 * @generated
	 */
	void setHintGroup(ExportedMappingHintGroup value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #isSetContainer()
	 * @see #unsetContainer()
	 * @see #setContainer(TargetSectionClass)
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupImporter_Container()
	 * @model unsettable="true"
	 * @generated
	 */
	TargetSectionClass getContainer();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #isSetContainer()
	 * @see #unsetContainer()
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(TargetSectionClass value);

	/**
	 * Unsets the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetContainer()
	 * @see #getContainer()
	 * @see #setContainer(TargetSectionClass)
	 * @generated
	 */
	void unsetContainer();

	/**
	 * Returns whether the value of the '{@link pamtram.mapping.MappingHintGroupImporter#getContainer <em>Container</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Container</em>' reference is set.
	 * @see #unsetContainer()
	 * @see #getContainer()
	 * @see #setContainer(TargetSectionClass)
	 * @generated
	 */
	boolean isSetContainer();

} // MappingHintGroupImporter
