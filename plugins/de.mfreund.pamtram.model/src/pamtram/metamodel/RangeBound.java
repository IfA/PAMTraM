/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import pamtram.ReferenceableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range Bound</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.RangeBound#getBoundReferenceValue <em>Bound Reference Value</em>}</li>
 *   <li>{@link pamtram.metamodel.RangeBound#getBoundType <em>Bound Type</em>}</li>
 *   <li>{@link pamtram.metamodel.RangeBound#getExpression <em>Expression</em>}</li>
 *   <li>{@link pamtram.metamodel.RangeBound#getBoundReferenceValueAdditionalSpecification <em>Bound Reference Value Additional Specification</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getRangeBound()
 * @model
 * @generated
 */
public interface RangeBound extends EObject {
	/**
	 * Returns the value of the '<em><b>Bound Reference Value</b></em>' reference list.
	 * The list contents are of type {@link pamtram.ReferenceableElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Reference Value</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Reference Value</em>' reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getRangeBound_BoundReferenceValue()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!RangeBound!boundReferenceValue'"
	 * @generated
	 */
	EList<ReferenceableElement> getBoundReferenceValue();

	/**
	 * Returns the value of the '<em><b>Bound Type</b></em>' attribute.
	 * The literals are from the enumeration {@link pamtram.metamodel.AttributeValueConstraintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Type</em>' attribute.
	 * @see pamtram.metamodel.AttributeValueConstraintType
	 * @see #setBoundType(AttributeValueConstraintType)
	 * @see pamtram.metamodel.MetamodelPackage#getRangeBound_BoundType()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!RangeBound!boundType'"
	 * @generated
	 */
	AttributeValueConstraintType getBoundType();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.RangeBound#getBoundType <em>Bound Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound Type</em>' attribute.
	 * @see pamtram.metamodel.AttributeValueConstraintType
	 * @see #getBoundType()
	 * @generated
	 */
	void setBoundType(AttributeValueConstraintType value);

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
	 * @see pamtram.metamodel.MetamodelPackage#getRangeBound_Expression()
	 * @model default="" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!RangeBound!expression'"
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.RangeBound#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

	/**
	 * Returns the value of the '<em><b>Bound Reference Value Additional Specification</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.InstancePointer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Reference Value Additional Specification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Reference Value Additional Specification</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getRangeBound_BoundReferenceValueAdditionalSpecification()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!RangeBound!boundReferenceValueAdditionalSpecification'"
	 * @generated
	 */
	EList<InstancePointer> getBoundReferenceValueAdditionalSpecification();

} // RangeBound
