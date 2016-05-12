/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link pamtram.metamodel.SingleReferenceAttributeValueConstraint#getConstraintReferenceValue <em>Constraint Reference Value</em>}</li>
 *   <li>{@link pamtram.metamodel.SingleReferenceAttributeValueConstraint#getExpression <em>Expression</em>}</li>
 *   <li>{@link pamtram.metamodel.SingleReferenceAttributeValueConstraint#getConstraintReferenceValueAdditionalSpecification <em>Constraint Reference Value Additional Specification</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSingleReferenceAttributeValueConstraint()
 * @model abstract="true"
 * @generated
 */
public interface SingleReferenceAttributeValueConstraint extends AttributeValueConstraint {
	/**
	 * Returns the value of the '<em><b>Constraint Reference Value</b></em>' reference list.
	 * The list contents are of type {@link pamtram.ReferenceableElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Reference Value</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Reference Value</em>' reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSingleReferenceAttributeValueConstraint_ConstraintReferenceValue()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SingleReferenceAttributeValueConstraint!constraintReferenceValue'"
	 * @generated
	 */
	EList<ReferenceableElement> getConstraintReferenceValue();

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

	/**
	 * Returns the value of the '<em><b>Constraint Reference Value Additional Specification</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.InstancePointer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Reference Value Additional Specification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Reference Value Additional Specification</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSingleReferenceAttributeValueConstraint_ConstraintReferenceValueAdditionalSpecification()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SingleReferenceAttributeValueConstraint!constraintReferenceValueAdditionalSpecification'"
	 * @generated
	 */
	EList<InstancePointer> getConstraintReferenceValueAdditionalSpecification();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" attrValueRequired="true" refValueRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SingleReferenceAttributeValueConstraint!checkConstraint(String,String)'"
	 * @generated
	 */
	boolean checkConstraint(String attrValue, String refValue);

} // SingleReferenceAttributeValueConstraint
