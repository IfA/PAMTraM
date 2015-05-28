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
 *   <li>{@link pamtram.metamodel.TargetSectionClass#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getTargetSectionClass()
 * @model
 * @generated
 */
public interface TargetSectionClass extends pamtram.metamodel.Class<TargetSectionClass, TargetSectionReference> {

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.TargetSectionAttribute}.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.TargetSectionAttribute#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getTargetSectionClass_Attributes()
	 * @see pamtram.metamodel.TargetSectionAttribute#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 * @generated
	 */
	EList<TargetSectionAttribute> getAttributes();
} // TargetSectionClass
