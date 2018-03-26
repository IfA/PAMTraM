/*******************************************************************************
 * Copyright (C) 2017-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package dfd;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dfd.Flow#getFrom <em>From</em>}</li>
 *   <li>{@link dfd.Flow#getTo <em>To</em>}</li>
 * </ul>
 *
 * @see dfd.DfdPackage#getFlow()
 * @model abstract="true"
 * @generated
 */
public interface Flow extends NamedElement {
	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(DFDElement)
	 * @see dfd.DfdPackage#getFlow_From()
	 * @model
	 * @generated
	 */
	DFDElement getFrom();

	/**
	 * Sets the value of the '{@link dfd.Flow#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(DFDElement value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(DFDElement)
	 * @see dfd.DfdPackage#getFlow_To()
	 * @model
	 * @generated
	 */
	DFDElement getTo();

	/**
	 * Sets the value of the '{@link dfd.Flow#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(DFDElement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean result = this.from == null || this.from.eContainer().equals(this.eContainer);\r\n\t\t\r\n\t\tif (!result &amp;&amp; diagnostics != null) {\r\n\t\t\t\r\n\t\t\tString errorMessage = \"The \'from\' element is not part of the same (Sub-)System!\";\r\n\t\t\r\n\t\t\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t\t\t&lt;%dfd.util.DfdValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%dfd.util.DfdValidator%&gt;.FLOW__VALIDATE_FROM_POINTS_TO_ELEMENT_OF_SAME_SYSTEM,\r\n\t\t\t\t\t\t\terrorMessage,\r\n\t\t\t\t\tnew Object[] { this, &lt;%dfd.DfdPackage%&gt;.Literals.FLOW__FROM}));\r\n\t\t\r\n\t\t}\r\n\r\treturn result;'"
	 * @generated
	 */
	boolean validateFromPointsToElementOfSameSystem(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean result = this.to == null || this.to.eContainer().equals(this.eContainer);\r\n\r\tif (!result &amp;&amp; diagnostics != null) {\r\n\r\t\tString errorMessage = \"The \'to\' element is not part of the same (Sub-)System!\";\r\n\r\t\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%dfd.util.DfdValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%dfd.util.DfdValidator%&gt;.FLOW__VALIDATE_TO_POINTS_TO_ELEMENT_OF_SAME_SYSTEM, errorMessage,\r\n\t\t\t\t\tnew Object[] { this, &lt;%dfd.DfdPackage%&gt;.Literals.FLOW__TO }));\r\n\r\t}\r\n\r\treturn result;'"
	 * @generated
	 */
	boolean validateToPointsToElementOfSameSystem(DiagnosticChain diagnostics, Map<?, ?> context);

} // Flow
