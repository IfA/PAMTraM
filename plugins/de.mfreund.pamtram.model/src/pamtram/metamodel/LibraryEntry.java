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
 *   <li>{@link pamtram.metamodel.LibraryEntry#getMetaData <em>Meta Data</em>}</li>
 *   <li>{@link pamtram.metamodel.LibraryEntry#getLibraryFile <em>Library File</em>}</li>
 *   <li>{@link pamtram.metamodel.LibraryEntry#getPath <em>Path</em>}</li>
 *   <li>{@link pamtram.metamodel.LibraryEntry#getVersion <em>Version</em>}</li>
 *   <li>{@link pamtram.metamodel.LibraryEntry#getLibraryItem <em>Library Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getLibraryEntry()
 * @model
 * @generated
 */
public interface LibraryEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Meta Data</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.TargetSectionClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Data</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getLibraryEntry_MetaData()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TargetSectionClass> getMetaData();

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
	 * Returns the value of the '<em><b>Library Item</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.TargetSectionClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library Item</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library Item</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getLibraryEntry_LibraryItem()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TargetSectionClass> getLibraryItem();

} // LibraryEntry
