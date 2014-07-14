/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.Attribute#getValueSpecification <em>Value Specification</em>}</li>
 *   <li>{@link pamtram.metamodel.Attribute#isUnique <em>Unique</em>}</li>
 *   <li>{@link pamtram.metamodel.Attribute#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getAttribute()
 * @model abstract="true"
 * @generated
 */
public interface Attribute extends MetaModelElement {
	/**
	 * Returns the value of the '<em><b>Value Specification</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.AttributeValueSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Specification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Specification</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getAttribute_ValueSpecification()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttributeValueSpecification> getValueSpecification();

	/**
	 * Returns the value of the '<em><b>Unique</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique</em>' attribute.
	 * @see #setUnique(boolean)
	 * @see pamtram.metamodel.MetamodelPackage#getAttribute_Unique()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isUnique();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.Attribute#isUnique <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique</em>' attribute.
	 * @see #isUnique()
	 * @generated
	 */
	void setUnique(boolean value);

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
	 * @model opposite="attributes" required="true" transient="false" changeable="false"
	 * @generated
	 */
	pamtram.metamodel.Class getOwningClass();

} // Attribute
