/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import pamtram.mapping.modifier.ValueModifierSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modifiable Hint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.ModifiableHint#getResultModifier <em>Result Modifier</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getModifiableHint()
 * @model abstract="true"
 * @generated
 */
public interface ModifiableHint extends EObject {
	/**
	 * Returns the value of the '<em><b>Result Modifier</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.modifier.ValueModifierSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Modifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Modifier</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getModifiableHint_ResultModifier()
	 * @model
	 * @generated
	 */
	EList<ValueModifierSet> getResultModifier();

} // ModifiableHint
