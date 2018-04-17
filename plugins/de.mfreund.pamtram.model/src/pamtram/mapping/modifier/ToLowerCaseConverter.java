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
package pamtram.mapping.modifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Match To Lower Case Converter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This ValueModifier will modify the (String-based) 'value' by converting the sub-string identified by the given 'regex' to lower case.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.modifier.ToLowerCaseConverter#getRegex <em>Regex</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.modifier.ModifierPackage#getToLowerCaseConverter()
 * @model
 * @generated
 */
public interface ToLowerCaseConverter extends StringModifier {
	/**
	 * Returns the value of the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The regular expression identifying the string to be converted.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Regex</em>' attribute.
	 * @see #setRegex(String)
	 * @see pamtram.mapping.modifier.ModifierPackage#getToLowerCaseConverter_Regex()
	 * @model required="true"
	 * @generated
	 */
	String getRegex();

	/**
	 * Sets the value of the '{@link pamtram.mapping.modifier.ToLowerCaseConverter#getRegex <em>Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regex</em>' attribute.
	 * @see #getRegex()
	 * @generated
	 */
	void setRegex(String value);

} // ToLowerCaseConverter
