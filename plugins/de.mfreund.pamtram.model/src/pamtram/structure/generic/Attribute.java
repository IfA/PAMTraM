/**
 */
package pamtram.structure.generic;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.generic.Attribute#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.generic.GenericPackage#getAttribute()
 * @model abstract="true"
 * @generated
 */
public interface Attribute<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends MetaModelElement<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link pamtram.structure.generic.Class#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see pamtram.structure.generic.GenericPackage#getAttribute_OwningClass()
	 * @see pamtram.structure.generic.Class#getAttributes
	 * @model opposite="attributes" transient="false" changeable="false"
	 * @generated
	 */
	C getOwningClass();

} // Attribute
