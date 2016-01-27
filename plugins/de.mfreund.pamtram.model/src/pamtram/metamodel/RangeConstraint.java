/**
 */
package pamtram.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.RangeConstraint#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link pamtram.metamodel.RangeConstraint#getLowerBound <em>Lower Bound</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getRangeConstraint()
 * @model
 * @generated
 */
public interface RangeConstraint extends MultipleReferencesAttributeValueConstraint {
	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' reference.
	 * @see #setUpperBound(RangeBound)
	 * @see pamtram.metamodel.MetamodelPackage#getRangeConstraint_UpperBound()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!RangeConstraint!upperBound'"
	 * @generated
	 */
	RangeBound getUpperBound();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.RangeConstraint#getUpperBound <em>Upper Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' reference.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(RangeBound value);

	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' reference.
	 * @see #setLowerBound(RangeBound)
	 * @see pamtram.metamodel.MetamodelPackage#getRangeConstraint_LowerBound()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!RangeConstraint!lowerBound'"
	 * @generated
	 */
	RangeBound getLowerBound();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.RangeConstraint#getLowerBound <em>Lower Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' reference.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(RangeBound value);

} // RangeConstraint
