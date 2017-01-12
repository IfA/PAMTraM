/**
 */
package pamtram.mapping.modifier;

import pamtram.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value Modifier</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.modifier.ModifierPackage#getValueModifier()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ValueModifier extends NamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" valueRequired="true"
	 * @generated
	 */
	String modifyValue(String value);

	
	
} // AttributeValueModifier
