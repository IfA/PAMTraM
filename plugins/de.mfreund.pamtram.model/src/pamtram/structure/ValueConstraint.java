/**
 */
package pamtram.structure;

import pamtram.NamedElement;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Value Constraint</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.ValueConstraint#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.MetamodelPackage#getAttributeValueConstraint()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ValueConstraint extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"INCLUSION"</code>.
	 * The literals are from the enumeration {@link pamtram.structure.ValueConstraintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see pamtram.structure.ValueConstraintType
	 * @see #setType(ValueConstraintType)
	 * @see pamtram.structure.MetamodelPackage#getValueConstraint_Type()
	 * @model default="INCLUSION" required="true"
	 * @generated
	 */
	ValueConstraintType getType();

	/**
	 * Sets the value of the '{@link pamtram.structure.ValueConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see pamtram.structure.ValueConstraintType
	 * @see #getType()
	 * @generated
	 */
	void setType(ValueConstraintType value);

} // AttributeValueConstraint
