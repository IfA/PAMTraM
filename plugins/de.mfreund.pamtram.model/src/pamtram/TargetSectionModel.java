/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;

import pamtram.metamodel.LibraryElement;
import pamtram.metamodel.TargetSectionClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Section Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.TargetSectionModel#getMetaModelSections <em>Meta Model Sections</em>}</li>
 *   <li>{@link pamtram.TargetSectionModel#getLibraryElements <em>Library Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.PamtramPackage#getTargetSectionModel()
 * @model
 * @generated
 */
public interface TargetSectionModel extends SectionModel {

	/**
	 * Returns the value of the '<em><b>Meta Model Sections</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.TargetSectionClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model Sections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Model Sections</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getTargetSectionModel_MetaModelSections()
	 * @model containment="true"
	 * @generated
	 */
	EList<TargetSectionClass> getMetaModelSections();

	/**
	 * Returns the value of the '<em><b>Library Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.LibraryElement}.
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
	EList<LibraryElement> getLibraryElements();
} // TargetSectionModel
