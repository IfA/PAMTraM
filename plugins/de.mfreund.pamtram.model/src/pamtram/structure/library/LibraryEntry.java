/**
 */
package pamtram.structure.library;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import pamtram.structure.target.VirtualTargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents an element structure to be created in a target model based on a GenLibrary LibraryEntry.
 * <br />
 * Instances of this class act as wrapper for GenLibrary entries. This wrapper-based approach allows us to (1) instantiate LibraryEntries during the course of a transformation while (2) relying on the existing mechanisms for MappingHints.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.library.LibraryEntry#getParameters <em>Parameters</em>}</li>
 *   <li>{@link pamtram.structure.library.LibraryEntry#getLibraryFile <em>Library File</em>}</li>
 *   <li>{@link pamtram.structure.library.LibraryEntry#getOriginalLibraryEntry <em>Original Library Entry</em>}</li>
 *   <li>{@link pamtram.structure.library.LibraryEntry#getClasspath <em>Classpath</em>}</li>
 *   <li>{@link pamtram.structure.library.LibraryEntry#getId <em>Id</em>}</li>
 *   <li>{@link pamtram.structure.library.LibraryEntry#getResourceParameters <em>Resource Parameters</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.library.LibraryPackage#getLibraryEntry()
 * @model
 * @generated
 */
public interface LibraryEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.library.LibraryParameter}<code>&lt;?&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of LibraryParameters that need to be specified by the user for a successful instantiation of the LibraryEntry.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see pamtram.structure.library.LibraryPackage#getLibraryEntry_Parameters()
	 * @model containment="true" required="true"
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
	 * <!-- begin-model-doc -->
	 * The file containing the GenLibrary LibraryEntry that this wraps.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Library File</em>' attribute.
	 * @see #setLibraryFile(String)
	 * @see pamtram.structure.library.LibraryPackage#getLibraryEntry_LibraryFile()
	 * @model required="true"
	 * @generated
	 */
	String getLibraryFile();

	/**
	 * Sets the value of the '{@link pamtram.structure.library.LibraryEntry#getLibraryFile <em>Library File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Library File</em>' attribute.
	 * @see #getLibraryFile()
	 * @generated
	 */
	void setLibraryFile(String value);

	/**
	 * Returns the value of the '<em><b>Classpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The classpath identifying the GenLibrary LibraryEntry that this wraps.
	 * <br /><br />
	 * Note: This can be overridden by an AttributeMapping during a transformation. That way, more specific LibraryEntries may be instantiated without having to create an own wrapper for each specific GenLibrary LibraryEntry.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Classpath</em>' containment reference.
	 * @see #setClasspath(VirtualTargetSectionAttribute)
	 * @see pamtram.structure.library.LibraryPackage#getLibraryEntry_Classpath()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VirtualTargetSectionAttribute getClasspath();

	/**
	 * Sets the value of the '{@link pamtram.structure.library.LibraryEntry#getClasspath <em>Classpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classpath</em>' containment reference.
	 * @see #getClasspath()
	 * @generated
	 */
	void setClasspath(VirtualTargetSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This can be used to specify an optional unique id for the entry to be instantiated. The id will be passed to the GenLibrary instantiation mechanism.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' containment reference.
	 * @see #setId(VirtualTargetSectionAttribute)
	 * @see pamtram.structure.library.LibraryPackage#getLibraryEntry_Id()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VirtualTargetSectionAttribute getId();

	/**
	 * Sets the value of the '{@link pamtram.structure.library.LibraryEntry#getId <em>Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' containment reference.
	 * @see #getId()
	 * @generated
	 */
	void setId(VirtualTargetSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Resource Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.library.ResourceParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of ResourceParameters that need to be specified by the user for a successful instantiation of the LibraryEntry.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource Parameters</em>' containment reference list.
	 * @see pamtram.structure.library.LibraryPackage#getLibraryEntry_ResourceParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ResourceParameter> getResourceParameters();

	/**
	 * Returns the value of the '<em><b>Original Library Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Library Entry</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The GenLibrary LibraryEntry that this wraps.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Original Library Entry</em>' reference.
	 * @see #setOriginalLibraryEntry(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry)
	 * @see pamtram.structure.library.LibraryPackage#getLibraryEntry_OriginalLibraryEntry()
	 * @model required="true"
	 * @generated
	 */
	de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry getOriginalLibraryEntry();

	/**
	 * Sets the value of the '{@link pamtram.structure.library.LibraryEntry#getOriginalLibraryEntry <em>Original Library Entry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Library Entry</em>' reference.
	 * @see #getOriginalLibraryEntry()
	 * @generated
	 */
	void setOriginalLibraryEntry(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry value);

} // LibraryEntry
