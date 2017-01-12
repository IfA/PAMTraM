/**
 */
package pamtram.mapping.modifier;

import org.eclipse.emf.common.util.EList;

import pamtram.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value Modifier Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.modifier.ValueModifierSet#getModifier <em>Modifier</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.modifier.ModifierPackage#getValueModifierSet()
 * @model
 * @generated
 */
public interface ValueModifierSet extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Modifier</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.modifier.ValueModifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier</em>' containment reference list.
	 * @see pamtram.mapping.modifier.ModifierPackage#getValueModifierSet_Modifier()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValueModifier> getModifier();

} // AttributeValueModifierSet
