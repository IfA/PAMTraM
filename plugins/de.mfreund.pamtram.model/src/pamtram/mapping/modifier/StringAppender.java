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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Appender</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This ValueModifier will modify the (String-based) 'value' by appending the given 'string'.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.modifier.StringAppender#getString <em>String</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.modifier.ModifierPackage#getStringAppender()
 * @model
 * @generated
 */
public interface StringAppender extends StringModifier {
	/**
	 * Returns the value of the '<em><b>String</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The String to be appended.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>String</em>' attribute.
	 * @see #setString(String)
	 * @see pamtram.mapping.modifier.ModifierPackage#getStringAppender_String()
	 * @model default="" required="true"
	 * @generated
	 */
	String getString();

	/**
	 * Sets the value of the '{@link pamtram.mapping.modifier.StringAppender#getString <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String</em>' attribute.
	 * @see #getString()
	 * @generated
	 */
	void setString(String value);

} // StringAppender
