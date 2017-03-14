/**
 */
package pamtram.structure.library;

import pamtram.NamedElement;
import pamtram.structure.target.VirtualTargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.library.ResourceParameter#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link pamtram.structure.library.ResourceParameter#getOriginalParameter <em>Original Parameter</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.library.LibraryPackage#getResourceParameter()
 * @model
 * @generated
 */
public interface ResourceParameter extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference.
	 * @see #setAttribute(VirtualTargetSectionAttribute)
	 * @see pamtram.structure.library.LibraryPackage#getResourceParameter_Attribute()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VirtualTargetSectionAttribute getAttribute();

	/**
	 * Sets the value of the '{@link pamtram.structure.library.ResourceParameter#getAttribute <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' containment reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(VirtualTargetSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Original Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Parameter</em>' reference.
	 * @see #setOriginalParameter(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter)
	 * @see pamtram.structure.library.LibraryPackage#getResourceParameter_OriginalParameter()
	 * @model required="true"
	 * @generated
	 */
	de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter getOriginalParameter();

	/**
	 * Sets the value of the '{@link pamtram.structure.library.ResourceParameter#getOriginalParameter <em>Original Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Parameter</em>' reference.
	 * @see #getOriginalParameter()
	 * @generated
	 */
	void setOriginalParameter(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter value);

} // ResourceParameter
