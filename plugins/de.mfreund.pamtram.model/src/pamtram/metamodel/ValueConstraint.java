/**
 */
package pamtram.metamodel;

import pamtram.NamedElement;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Value Constraint</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pamtram.metamodel.ValueConstraint#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getAttributeValueConstraint()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ValueConstraint extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"INCLUSION"</code>.
	 * The literals are from the enumeration {@link pamtram.metamodel.ValueConstraintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see pamtram.metamodel.ValueConstraintType
	 * @see #setType(ValueConstraintType)
	 * @see pamtram.metamodel.MetamodelPackage#getValueConstraint_Type()
	 * @model default="INCLUSION" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!ValueConstraint!type'"
	 * @generated
	 */
	ValueConstraintType getType();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.ValueConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see pamtram.metamodel.ValueConstraintType
	 * @see #getType()
	 * @generated
	 */
	void setType(ValueConstraintType value);

} // AttributeValueConstraint
