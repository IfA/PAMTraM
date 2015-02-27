/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.LibraryEntry#getParameters <em>Parameters</em>}</li>
 *   <li>{@link pamtram.metamodel.LibraryEntry#getLibraryFile <em>Library File</em>}</li>
 *   <li>{@link pamtram.metamodel.LibraryEntry#getPath <em>Path</em>}</li>
 *   <li>{@link pamtram.metamodel.LibraryEntry#getVersion <em>Version</em>}</li>
 *   <li>{@link pamtram.metamodel.LibraryEntry#getOriginalLibraryEntry <em>Original Library Entry</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getLibraryEntry()
 * @model
 * @generated
 */
public interface LibraryEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.LibraryParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getLibraryEntry_Parameters()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<LibraryParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Library File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library File</em>' attribute.
	 * @see #setLibraryFile(String)
	 * @see pamtram.metamodel.MetamodelPackage#getLibraryEntry_LibraryFile()
	 * @model required="true"
	 * @generated
	 */
	String getLibraryFile();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.LibraryEntry#getLibraryFile <em>Library File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Library File</em>' attribute.
	 * @see #getLibraryFile()
	 * @generated
	 */
	void setLibraryFile(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see pamtram.metamodel.MetamodelPackage#getLibraryEntry_Path()
	 * @model required="true"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.LibraryEntry#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see pamtram.metamodel.MetamodelPackage#getLibraryEntry_Version()
	 * @model required="true"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.LibraryEntry#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Original Library Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Library Entry</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Library Entry</em>' reference.
	 * @see #setOriginalLibraryEntry(EObject)
	 * @see pamtram.metamodel.MetamodelPackage#getLibraryEntry_OriginalLibraryEntry()
	 * @model required="true"
	 * @generated
	 */
	EObject getOriginalLibraryEntry();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.LibraryEntry#getOriginalLibraryEntry <em>Original Library Entry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Library Entry</em>' reference.
	 * @see #getOriginalLibraryEntry()
	 * @generated
	 */
	void setOriginalLibraryEntry(EObject value);

} // LibraryEntry
