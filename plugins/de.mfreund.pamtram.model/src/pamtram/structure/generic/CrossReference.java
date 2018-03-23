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
package pamtram.structure.generic;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Non
 * Containment Reference</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents a reference of an element structure. CrossReferences can be used to describe references to other element structures or to other elements of this structure.
 * <br />
 * In order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the 'value' reference.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.generic.CrossReference#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.generic.GenericPackage#getCrossReference()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eReferenceIsNonContainment'"
 * @generated
 */
public interface CrossReference<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends Reference<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference list. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getNonContainmentReference_Value()
	 * @model
	 * @generated
	 */
	EList<C> getValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n&lt;%org.eclipse.emf.ecore.EReference%&gt; reference = this instanceof &lt;%pamtram.structure.generic.ActualReference%&gt; ? ((ActualReference&lt;?, ?, ?, ?&gt;) this).getEReference() : null;\r\n\r\nboolean result = reference == null ? true : this.getValue().parallelStream().allMatch(c -&gt; reference.getEReferenceType().isSuperTypeOf(c.getEClass()));\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = this.getValue().parallelStream()\r\n\t\t.filter(c -&gt; !reference.getEReferenceType().isSuperTypeOf(c.getEClass())).count()\r\n\t\t+ \" of the selected target Classes (Value) are not allowed by the selected eReference \'\"\r\n\t\t+ reference.getName() + \"\'!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.structure.generic.util.GenericValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tGenericValidator.CROSS_REFERENCE__VALIDATE_VALUES_MATCH_REFERENCE_TYPE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CROSS_REFERENCE__VALUE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateValuesMatchReferenceType(DiagnosticChain diagnostics, Map<?, ?> context);

} // NonContainmentReference
