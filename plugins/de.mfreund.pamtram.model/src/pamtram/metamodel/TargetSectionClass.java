/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Section Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.TargetSectionClass#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getTargetSectionClass()
 * @model
 * @generated
 */
public interface TargetSectionClass extends pamtram.metamodel.Class {

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.TargetSectionReference}.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.TargetSectionReference#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getTargetSectionClass_References()
	 * @see pamtram.metamodel.TargetSectionReference#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 * @generated
	 */
	EList<TargetSectionReference> getReferences();
} // TargetSectionClass
