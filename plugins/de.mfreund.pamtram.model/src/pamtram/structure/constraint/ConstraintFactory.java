/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
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
	 * Returns a new object of class '<em>Choice Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice Constraint</em>'.
	 * @generated
	 */
	ChoiceConstraint createChoiceConstraint();

	/**
	 * Returns a new object of class '<em>Numeric Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeric Constraint</em>'.
	 * @generated
	 */
	NumericConstraint createNumericConstraint();

	/**
	 * Returns a new object of class '<em>String Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Constraint</em>'.
	 * @generated
	 */
	StringConstraint createStringConstraint();

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
	 * Returns a new object of class '<em>Value Constraint Global Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Constraint Global Source Element</em>'.
	 * @generated
	 */
	ValueConstraintGlobalSourceElement createValueConstraintGlobalSourceElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConstraintPackage getConstraintPackage();

} //ConstraintFactory
