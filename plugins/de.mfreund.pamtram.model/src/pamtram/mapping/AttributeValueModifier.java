/**
 */
package pamtram.mapping;

import pamtram.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value Modifier</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getAttributeValueModifier()
 * @model abstract="true"
 * @generated
 */
public interface AttributeValueModifier extends NamedElement {
	/**
	 * @param value
	 * @return
	 */
	public String modify(String value);
	
} // AttributeValueModifier
