/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;

import pamtram.structure.LibraryEntry;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionReference;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Section Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.TargetSectionModel#getLibraryElements <em>Library Elements</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getTargetSectionModel()
 * @model
 * @generated
 */
public interface TargetSectionModel extends SectionModel<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute> {

	/**
	 * Returns the value of the '<em><b>Library Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.LibraryEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library Elements</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getTargetSectionModel_LibraryElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<LibraryEntry> getLibraryElements();
} // TargetSectionModel
