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
package pamtram;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Hint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An ExpressionElement can be equipped with a mathematical expression describing how to calculate the (numeric) value of this element.
 * <br />
 * The specific meaning of the calculated 'value' is dependent on the concrete sub-type of this element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.ExpressionElement#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getExpressionElement()
 * @model abstract="true"
 * @generated
 */
public interface ExpressionElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A mathematical expression describing how to calculate the (numeric) value of this element.
	 * <br />
	 * The specific meaning of the calculated 'value' is dependent on the concrete type of this element.
	 * <br />
	 * Note: Variables (e.g. global FixedValues or specified source elements) can be referenced in the expression via their name, e.g. '2*x' if their is a (local) source element or a global FixedValue named 'x'.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see pamtram.PamtramPackage#getExpressionElement_Expression()
	 * @model default="" required="true"
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link pamtram.ExpressionElement#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

} // ExpressionElement
