/**
 */
package pamtram.structure.library;

import org.eclipse.emf.ecore.EObject;
import pamtram.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The common super type for all wrapper elements for GenLibrary parameters.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.library.LibraryParameter#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.structure.library.LibraryParameter#getOriginalParameter <em>Original Parameter</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.library.LibraryPackage#getLibraryParameter()
 * @model abstract="true"
 * @generated
 */
public interface LibraryParameter<ParameterType> extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The model element inside the GenLibrary entry that this parameter influences.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EObject)
	 * @see pamtram.structure.library.LibraryPackage#getLibraryParameter_Source()
	 * @model required="true"
	 * @generated
	 */
	EObject getSource();

	/**
	 * Sets the value of the '{@link pamtram.structure.library.LibraryParameter#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EObject value);

	/**
	 * Returns the value of the '<em><b>Original Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The GenLibrary parameter that this wraps.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Original Parameter</em>' reference.
	 * @see #setOriginalParameter(Object)
	 * @see pamtram.structure.library.LibraryPackage#getLibraryParameter_OriginalParameter()
	 * @model kind="reference" required="true"
	 * @generated
	 */
	ParameterType getOriginalParameter();

	/**
	 * Sets the value of the '{@link pamtram.structure.library.LibraryParameter#getOriginalParameter <em>Original Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Parameter</em>' reference.
	 * @see #getOriginalParameter()
	 * @generated
	 */
	void setOriginalParameter(ParameterType value);

} // LibraryParameter
