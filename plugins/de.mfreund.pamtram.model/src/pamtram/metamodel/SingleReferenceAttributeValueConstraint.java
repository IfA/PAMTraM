/**
 */
package pamtram.metamodel;

import pamtram.ReferenceableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Reference Attribute Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.SingleReferenceAttributeValueConstraint#getType <em>Type</em>}</li>
 *   <li>{@link pamtram.metamodel.SingleReferenceAttributeValueConstraint#getConstraintReferenceValue <em>Constraint Reference Value</em>}</li>
 *   <li>{@link pamtram.metamodel.SingleReferenceAttributeValueConstraint#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSingleReferenceAttributeValueConstraint()
 * @model abstract="true"
 * @generated
 */
public interface SingleReferenceAttributeValueConstraint extends AttributeValueConstraint {
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
	 * @see pamtram.metamodel.MetamodelPackage#getSingleReferenceAttributeValueConstraint_Type()
	 * @model default="INCLUSION" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SingleReferenceAttributeValueConstraint!type'"
	 * @generated
	 */
	AttributeValueConstraintType getType();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.SingleReferenceAttributeValueConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see pamtram.metamodel.AttributeValueConstraintType
	 * @see #getType()
	 * @generated
	 */
	void setType(AttributeValueConstraintType value);

	/**
	 * Returns the value of the '<em><b>Constraint Reference Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Reference Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Reference Value</em>' reference.
	 * @see #setConstraintReferenceValue(ReferenceableElement)
	 * @see pamtram.metamodel.MetamodelPackage#getSingleReferenceAttributeValueConstraint_ConstraintReferenceValue()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SingleReferenceAttributeValueConstraint!constraintReferenceValue'"
	 * @generated
	 */
	ReferenceableElement getConstraintReferenceValue();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.SingleReferenceAttributeValueConstraint#getConstraintReferenceValue <em>Constraint Reference Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Reference Value</em>' reference.
	 * @see #getConstraintReferenceValue()
	 * @generated
	 */
	void setConstraintReferenceValue(ReferenceableElement value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see pamtram.metamodel.MetamodelPackage#getSingleReferenceAttributeValueConstraint_Expression()
	 * @model default="" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SingleReferenceAttributeValueConstraint!expression'"
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.SingleReferenceAttributeValueConstraint#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

} // SingleReferenceAttributeValueConstraint
