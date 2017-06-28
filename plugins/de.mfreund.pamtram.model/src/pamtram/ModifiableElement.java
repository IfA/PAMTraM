/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import pamtram.mapping.modifier.ValueModifierSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modifiable Hint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ModifiableElement can be equipped with a list of 'ValueModifierSets' that will be applied on the value of this element.
 * <br />
 * The specific meaning of the modified 'value' is dependent on the concrete sub-type of this element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.ModifiableElement#getModifiers <em>Modifiers</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getModifiableElement()
 * @model abstract="true"
 * @generated
 */
public interface ModifiableElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Modifiers</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.modifier.ValueModifierSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Modifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of 'ValueModifierSets' that will be applied on the value of this element.
	 * <br />
	 * The specific meaning of the modified 'value' is dependent on the concrete sub-type of this element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Modifiers</em>' reference list.
	 * @see pamtram.PamtramPackage#getModifiableElement_Modifiers()
	 * @model
	 * @generated
	 */
	EList<ValueModifierSet> getModifiers();

} // ModifiableElement
