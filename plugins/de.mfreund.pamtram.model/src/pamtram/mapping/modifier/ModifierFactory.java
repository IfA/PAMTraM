/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.mapping.modifier;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.mapping.modifier.ModifierPackage
 * @generated
 */
public interface ModifierFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModifierFactory eINSTANCE = pamtram.mapping.modifier.impl.ModifierFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Value Modifier Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Modifier Set</em>'.
	 * @generated
	 */
	ValueModifierSet createValueModifierSet();

	/**
	 * Returns a new object of class '<em>Substring Replacer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Substring Replacer</em>'.
	 * @generated
	 */
	SubstringReplacer createSubstringReplacer();

	/**
	 * Returns a new object of class '<em>String Appender</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Appender</em>'.
	 * @generated
	 */
	StringAppender createStringAppender();

	/**
	 * Returns a new object of class '<em>Unique Number Appender</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unique Number Appender</em>'.
	 * @generated
	 */
	UniqueNumberAppender createUniqueNumberAppender();

	/**
	 * Returns a new object of class '<em>Expression Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Modifier</em>'.
	 * @generated
	 */
	ExpressionModifier createExpressionModifier();

	/**
	 * Returns a new object of class '<em>String Prepender</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Prepender</em>'.
	 * @generated
	 */
	StringPrepender createStringPrepender();

	/**
	 * Returns a new object of class '<em>To Lower Case Converter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>To Lower Case Converter</em>'.
	 * @generated
	 */
	ToLowerCaseConverter createToLowerCaseConverter();

	/**
	 * Returns a new object of class '<em>To Upper Case Converter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>To Upper Case Converter</em>'.
	 * @generated
	 */
	ToUpperCaseConverter createToUpperCaseConverter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModifierPackage getModifierPackage();

} //ModifierFactory
