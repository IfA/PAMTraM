/**
 */
package pamtram.structure.constraint;

import pamtram.structure.StructurePackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.constraint.RangeConstraint#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link pamtram.structure.constraint.RangeConstraint#getLowerBound <em>Lower Bound</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.StructurePackage#getRangeConstraint()
 * @model
 * @generated
 */
public interface RangeConstraint extends MultipleReferencesValueConstraint {
	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' containment reference.
	 * @see #setUpperBound(RangeBound)
	 * @see pamtram.structure.StructurePackage#getRangeConstraint_UpperBound()
	 * @model containment="true"
	 * @generated
	 */
	RangeBound getUpperBound();

	/**
	 * Sets the value of the '{@link pamtram.structure.constraint.RangeConstraint#getUpperBound <em>Upper Bound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' containment reference.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(RangeBound value);

	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' containment reference.
	 * @see #setLowerBound(RangeBound)
	 * @see pamtram.structure.StructurePackage#getRangeConstraint_LowerBound()
	 * @model containment="true"
	 * @generated
	 */
	RangeBound getLowerBound();

	/**
	 * Sets the value of the '{@link pamtram.structure.constraint.RangeConstraint#getLowerBound <em>Lower Bound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' containment reference.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(RangeBound value);

} // RangeConstraint
