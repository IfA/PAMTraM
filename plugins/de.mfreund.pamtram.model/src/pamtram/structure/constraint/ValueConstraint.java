/**
 */
package pamtram.structure.constraint;

import pamtram.NamedElement;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Value Constraint</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.constraint.ValueConstraint#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.StructurePackage#getAttributeValueConstraint()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ValueConstraint extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"REQUIRED"</code>.
	 * The literals are from the enumeration {@link pamtram.structure.constraint.ValueConstraintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see pamtram.structure.constraint.ValueConstraintType
	 * @see #setType(ValueConstraintType)
	 * @see pamtram.structure.constraint.ConstraintPackage#getValueConstraint_Type()
	 * @model default="REQUIRED" required="true"
	 * @generated
	 */
	ValueConstraintType getType();

	/**
	 * Sets the value of the '{@link pamtram.structure.constraint.ValueConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see pamtram.structure.constraint.ValueConstraintType
	 * @see #getType()
	 * @generated
	 */
	void setType(ValueConstraintType value);

} // AttributeValueConstraint
