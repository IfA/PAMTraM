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
 * @see pamtram.mapping.MappingPackage#getValueModifier()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ValueModifier extends NamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" valueRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!ValueModifier!modifyValue(String)'"
	 * @generated
	 */
	String modifyValue(String value);

	
	
} // AttributeValueModifier
