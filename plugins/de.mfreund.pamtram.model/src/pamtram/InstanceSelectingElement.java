/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import pamtram.structure.InstanceSelector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Selecting Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.InstanceSelectingElement#getInstanceSelectors <em>Instance Selectors</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getInstanceSelectingElement()
 * @model abstract="true"
 * @generated
 */
public interface InstanceSelectingElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.InstanceSelector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Selectors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Selectors</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getInstanceSelectingElement_InstanceSelectors()
	 * @model containment="true"
	 * @generated
	 */
	EList<InstanceSelector> getInstanceSelectors();

} // InstanceSelectingElement
