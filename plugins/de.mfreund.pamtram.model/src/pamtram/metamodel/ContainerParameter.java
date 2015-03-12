/**
 */
package pamtram.metamodel;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.ContainerParameter#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getContainerParameter()
 * @model
 * @generated
 */
public interface ContainerParameter extends LibraryParameter<AbstractContainerParameter<?, ?>> {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' containment reference.
	 * @see #setClass(TargetSectionClass)
	 * @see pamtram.metamodel.MetamodelPackage#getContainerParameter_Class()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TargetSectionClass getClass_();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.ContainerParameter#getClass_ <em>Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' containment reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(TargetSectionClass value);

} // ContainerParameter
