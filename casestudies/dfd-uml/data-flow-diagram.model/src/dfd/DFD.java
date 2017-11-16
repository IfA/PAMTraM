/**
 */
package dfd;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DFD</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dfd.DFD#getElements <em>Elements</em>}</li>
 *   <li>{@link dfd.DFD#getFlows <em>Flows</em>}</li>
 * </ul>
 *
 * @see dfd.DfdPackage#getDFD()
 * @model
 * @generated
 */
public interface DFD extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link dfd.DFDElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see dfd.DfdPackage#getDFD_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<DFDElement> getElements();

	/**
	 * Returns the value of the '<em><b>Flows</b></em>' containment reference list.
	 * The list contents are of type {@link dfd.Flow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flows</em>' containment reference list.
	 * @see dfd.DfdPackage#getDFD_Flows()
	 * @model containment="true"
	 * @generated
	 */
	EList<Flow> getFlows();

} // DFD
