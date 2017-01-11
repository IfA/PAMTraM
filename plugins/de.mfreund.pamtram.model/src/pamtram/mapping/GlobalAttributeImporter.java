/**
 */
package pamtram.mapping;

import pamtram.NamedElement;
import pamtram.structure.InstancePointerSourceInterface;
import pamtram.structure.constraint.ValueConstraintSourceInterface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Variable Importer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.GlobalAttributeImporter#getGlobalAttribute <em>Global Attribute</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getGlobalAttributeImporter()
 * @model
 * @generated
 */
public interface GlobalAttributeImporter extends NamedElement, AttributeMappingSourceInterface, AttributeMatcherSourceInterface, ContainerSelectorSourceInterface, InstancePointerSourceInterface, ValueConstraintSourceInterface {
	/**
	 * Returns the value of the '<em><b>Global Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Attribute</em>' reference.
	 * @see #setGlobalAttribute(GlobalAttribute)
	 * @see pamtram.mapping.MappingPackage#getGlobalAttributeImporter_GlobalAttribute()
	 * @model required="true"
	 * @generated
	 */
	GlobalAttribute getGlobalAttribute();

	/**
	 * Sets the value of the '{@link pamtram.mapping.GlobalAttributeImporter#getGlobalAttribute <em>Global Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Attribute</em>' reference.
	 * @see #getGlobalAttribute()
	 * @generated
	 */
	void setGlobalAttribute(GlobalAttribute value);

} // GlobalAttributeImporter
