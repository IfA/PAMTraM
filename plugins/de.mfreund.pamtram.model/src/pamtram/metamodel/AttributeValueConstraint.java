/**
 */
package pamtram.metamodel;

import pamtram.NamedElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.AttributeValueConstraint#getType <em>Type</em>}</li>
 *   <li>{@link pamtram.metamodel.AttributeValueConstraint#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getAttributeValueConstraint()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AttributeValueConstraint extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"INCLUSION"</code>.
	 * The literals are from the enumeration {@link pamtram.metamodel.AttributeValueConstraintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see pamtram.metamodel.AttributeValueConstraintType
	 * @see #setType(AttributeValueConstraintType)
	 * @see pamtram.metamodel.MetamodelPackage#getAttributeValueConstraint_Type()
	 * @model default="INCLUSION" required="true"
	 * @generated
	 */
	AttributeValueConstraintType getType();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.AttributeValueConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see pamtram.metamodel.AttributeValueConstraintType
	 * @see #getType()
	 * @generated
	 */
	void setType(AttributeValueConstraintType value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see pamtram.metamodel.MetamodelPackage#getAttributeValueConstraint_Value()
	 * @model required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.AttributeValueConstraint#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" attrValueRequired="true"
	 * @generated
	 */
	boolean checkConstraint(String attrValue);

} // AttributeValueConstraint
