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
	 * Returns a new object of class '<em>Equality Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equality Matcher</em>'.
	 * @generated
	 */
	EqualityConstraint createEqualityMatcher();

	/**
	 * Returns a new object of class '<em>Substring Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Substring Matcher</em>'.
	 * @generated
	 */
	SubstringConstraint createSubstringMatcher();

	/**
	 * Returns a new object of class '<em>Beginning Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Beginning Matcher</em>'.
	 * @generated
	 */
	BeginningConstraint createBeginningMatcher();

	/**
	 * Returns a new object of class '<em>Ending Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ending Matcher</em>'.
	 * @generated
	 */
	EndingConstraint createEndingMatcher();

	/**
	 * Returns a new object of class '<em>Reg Ex Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reg Ex Matcher</em>'.
	 * @generated
	 */
	RegExConstraint createRegExMatcher();

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
