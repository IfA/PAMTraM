/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.SourceSectionClass#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionClass()
 * @model
 * @generated
 */
public interface SourceSectionClass extends pamtram.metamodel.Class {

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.SourceSectionReference}.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.SourceSectionReference#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionClass_References()
	 * @see pamtram.metamodel.SourceSectionReference#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 * @generated
	 */
	EList<SourceSectionReference> getReferences();
	
	
} // SourceSectionClass
