/**
 */
package pamtram.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.Attribute#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getAttribute()
 * @model abstract="true"
 * @generated
 */
public interface Attribute<C extends pamtram.metamodel.Class<C, R, A>, R extends Reference<C, R, A>, A extends Attribute<C, R, A>> extends MetaModelElement<C, R, A> {

	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.Class#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see pamtram.metamodel.MetamodelPackage#getAttribute_OwningClass()
	 * @see pamtram.metamodel.Class#getAttributes
	 * @model opposite="attributes" transient="false" changeable="false"
	 * @generated
	 */
	C getOwningClass();

} // Attribute
