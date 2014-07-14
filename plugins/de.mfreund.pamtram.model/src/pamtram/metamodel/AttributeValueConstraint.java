/**
 */
package pamtram.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.AttributeValueConstraint#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getAttributeValueConstraint()
 * @model abstract="true"
 * @generated
 */
public interface AttributeValueConstraint extends AttributeValueSpecification {
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

} // AttributeValueConstraint
