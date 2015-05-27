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
 *   <li>{@link pamtram.metamodel.TargetSectionClass#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getTargetSectionClass()
 * @model
 * @generated
 */
public interface TargetSectionClass extends pamtram.metamodel.Class<TargetSectionReference> {

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

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(TargetSectionClass)
	 * @see pamtram.metamodel.MetamodelPackage#getTargetSectionClass_Container()
	 * @model
	 * @generated
	 */
	TargetSectionClass getContainer();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.TargetSectionClass#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(TargetSectionClass value);
} // TargetSectionClass
