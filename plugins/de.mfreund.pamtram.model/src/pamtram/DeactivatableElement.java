/**
 */
package pamtram;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deactivatable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.DeactivatableElement#isDeactivated <em>Deactivated</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.PamtramPackage#getDeactivatableElement()
 * @model abstract="true"
 * @generated
 */
public interface DeactivatableElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Deactivated</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deactivated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deactivated</em>' attribute.
	 * @see #setDeactivated(boolean)
	 * @see pamtram.PamtramPackage#getDeactivatableElement_Deactivated()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isDeactivated();

	/**
	 * Sets the value of the '{@link pamtram.DeactivatableElement#isDeactivated <em>Deactivated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deactivated</em>' attribute.
	 * @see #isDeactivated()
	 * @generated
	 */
	void setDeactivated(boolean value);

} // DeactivatableElement
