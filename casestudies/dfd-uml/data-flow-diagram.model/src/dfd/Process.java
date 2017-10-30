/**
 */
package dfd;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dfd.Process#getNumber <em>Number</em>}</li>
 * </ul>
 *
 * @see dfd.DfdPackage#getProcess()
 * @model
 * @generated
 */
public interface Process extends DFDElement, DFD {
	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(String)
	 * @see dfd.DfdPackage#getProcess_Number()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getNumber();

	/**
	 * Sets the value of the '{@link dfd.Process#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(String value);

} // Process
