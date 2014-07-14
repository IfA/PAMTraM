/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import pamtram.metamodel.Attribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.SimpleAttributeMapping#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.SimpleAttributeMapping#getModifier <em>Modifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getSimpleAttributeMapping()
 * @model
 * @generated
 */
public interface SimpleAttributeMapping extends AttributeMapping {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Attribute)
	 * @see pamtram.mapping.MappingPackage#getSimpleAttributeMapping_Source()
	 * @model required="true"
	 * @generated
	 */
	Attribute getSource();

	/**
	 * Sets the value of the '{@link pamtram.mapping.SimpleAttributeMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Attribute value);

	/**
	 * Returns the value of the '<em><b>Modifier</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.AttributeValueModifierSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getSimpleAttributeMapping_Modifier()
	 * @model
	 * @generated
	 */
	EList<AttributeValueModifierSet> getModifier();

} // SimpleAttributeMapping
