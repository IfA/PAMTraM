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
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.LibraryEntry#getParameters <em>Parameters</em>}</li>
 *   <li>{@link pamtram.metamodel.LibraryEntry#getLibraryFile <em>Library File</em>}</li>
 *   <li>{@link pamtram.metamodel.LibraryEntry#getPath <em>Path</em>}</li>
 *   <li>{@link pamtram.metamodel.LibraryEntry#getOriginalLibraryEntry <em>Original Library Entry</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getLibraryEntry()
 * @model
 * @generated
 */
public interface LibraryEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.LibraryParameter}&lt;?>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getLibraryEntry_Parameters()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!LibraryEntry!parameters'"
	 * @generated
	 */
	EList<LibraryParameter<?>> getParameters();

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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!LibraryEntry!libraryFile'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!LibraryEntry!path'"
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
	 * Returns the value of the '<em><b>Original Library Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Library Entry</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Library Entry</em>' reference.
	 * @see #setOriginalLibraryEntry(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry)
	 * @see pamtram.metamodel.MetamodelPackage#getLibraryEntry_OriginalLibraryEntry()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!LibraryEntry!originalLibraryEntry'"
	 * @generated
	 */
	de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry getOriginalLibraryEntry();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.LibraryEntry#getOriginalLibraryEntry <em>Original Library Entry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Library Entry</em>' reference.
	 * @see #getOriginalLibraryEntry()
	 * @generated
	 */
	void setOriginalLibraryEntry(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry value);

} // LibraryEntry
