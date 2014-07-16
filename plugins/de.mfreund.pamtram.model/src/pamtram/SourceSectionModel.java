/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;
import pamtram.metamodel.SourceSectionClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.SourceSectionModel#getMetaModelSections <em>Meta Model Sections</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.PamtramPackage#getSourceSectionModel()
 * @model
 * @generated
 */
public interface SourceSectionModel extends SectionModel {

	/**
	 * Returns the value of the '<em><b>Meta Model Sections</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.SourceSectionClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model Sections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Model Sections</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getSourceSectionModel_MetaModelSections()
	 * @model containment="true"
	 * @generated
	 */
	EList<SourceSectionClass> getMetaModelSections();
} // SourceSectionModel
