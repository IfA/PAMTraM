/**
 */
package pamtram.structure.constraint;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.structure.constraint.ConstraintPackage
 * @generated
 */
public interface ConstraintFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConstraintFactory eINSTANCE = pamtram.structure.constraint.impl.ConstraintFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Equality Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equality Constraint</em>'.
	 * @generated
	 */
	EqualityConstraint createEqualityConstraint();

	/**
	 * Returns a new object of class '<em>Numeric Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeric Constraint</em>'.
	 * @generated
	 */
	NumericConstraint createNumericConstraint();

	/**
	 * Returns a new object of class '<em>Substring Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Substring Constraint</em>'.
	 * @generated
	 */
	SubstringConstraint createSubstringConstraint();

	/**
	 * Returns a new object of class '<em>Beginning Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Beginning Constraint</em>'.
	 * @generated
	 */
	BeginningConstraint createBeginningConstraint();

	/**
	 * Returns a new object of class '<em>Ending Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ending Constraint</em>'.
	 * @generated
	 */
	EndingConstraint createEndingConstraint();

	/**
	 * Returns a new object of class '<em>Reg Ex Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reg Ex Constraint</em>'.
	 * @generated
	 */
	RegExConstraint createRegExConstraint();

	/**
	 * Returns a new object of class '<em>Range Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Range Constraint</em>'.
	 * @generated
	 */
	RangeConstraint createRangeConstraint();

	/**
	 * Returns a new object of class '<em>Value Constraint Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Constraint Source Element</em>'.
	 * @generated
	 */
	ValueConstraintSourceElement createValueConstraintSourceElement();

	/**
	 * Returns a new object of class '<em>Value Constraint External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Constraint External Source Element</em>'.
	 * @generated
	 */
	ValueConstraintExternalSourceElement createValueConstraintExternalSourceElement();

	/**
	 * Returns a new object of class '<em>Range Bound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Range Bound</em>'.
	 * @generated
	 */
	RangeBound createRangeBound();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConstraintPackage getConstraintPackage();

} //ConstraintFactory
