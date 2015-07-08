/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionReference;


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
public interface TargetSectionModel extends SectionModel<TargetSectionClass, TargetSectionReference, TargetSectionAttribute> {

	/**
	 * Returns the value of the '<em><b>Library Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.LibraryEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library Elements</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getTargetSectionModel_LibraryElements()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram!TargetSectionModel!libraryElements'"
	 * @generated
	 */
	EList<LibraryEntry> getLibraryElements();
} // TargetSectionModel
