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
import org.eclipse.emf.ecore.EReference;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actual Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents a reference (as an instance of an EReference) of an element structure.
 * <br />
 * In order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the 'value' reference.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.generic.ActualReference#getEReference <em>EReference</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.generic.GenericPackage#getActualReference()
 * @model abstract="true"
 * @generated
 */
public interface ActualReference<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends Reference<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The metamodel element (EReference) that this Reference represents.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EReference</em>' reference.
	 * @see #setEReference(EReference)
	 * @see pamtram.structure.generic.GenericPackage#getActualReference_EReference()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescriptor='\r\nitemPropertyDescriptors\r\n\t\t.add(new ItemPropertyDescriptor(((&lt;%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%&gt;) adapterFactory).getRootAdapterFactory(),\r\n\t\t\t\tthis.getResourceLocator(), this.getString(\"_UI_Reference_eReference_feature\"),\r\n\t\t\t\tthis.getString(\"_UI_ActualReference_eReference_description\"),\r\n\t\t\t\t&lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.ACTUAL_REFERENCE__EREFERENCE, true, false, true, null,\r\n\t\t\t\tthis.getString(\"_UI_BasicPropertyCategory\"), null) {\r\n\r\n\t\t\t@Override\r\n\t\t\tpublic &lt;%java.util.Collection%&gt;&lt;?&gt; getChoiceOfValues(Object object) {\r\n\r\n\t\t\t\t// make sure that only those references can be selected\r\n\t\t\t\t// that belong to the parent eClass\r\n\t\t\t\tpamtram.structure.generic.Class&lt;?, ?, ?, ?&gt; parent = ((&lt;%pamtram.structure.generic.impl.ReferenceImpl%&gt;&lt;?, ?, ?, ?&gt;) object)\r\n\t\t\t\t\t\t.getOwningClass();\r\n\r\n\t\t\t\t// do not filter the choices further so that containment\r\n\t\t\t\t// as well as non-containment references are displayed\r\n\t\t\t\treturn pamtram.util.XSDAnyContentUtil\r\n\t\t\t\t\t\t.getEAllReferencesIncludingVirtualAnyContentReference(parent.getEClass()).stream()\r\n\t\t\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\r\n\t\t\t}\r\n\t\t});'"
	 * @generated
	 */
	EReference getEReference();

	/**
	 * Sets the value of the '{@link pamtram.structure.generic.ActualReference#getEReference <em>EReference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference</em>' reference.
	 * @see #getEReference()
	 * @generated
	 */
	void setEReference(EReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (isLibraryEntry() || this.getEReference() == null\r\n\t\t|| !(eContainer() instanceof pamtram.structure.generic.Class)) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%org.eclipse.emf.ecore.EClass%&gt; parentEClass = ((pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;) eContainer()).getEClass();\r\n\r\nboolean result = parentEClass == null ? true\r\n\t\t: pamtram.util.XSDAnyContentUtil.getEAllReferencesIncludingVirtualAnyContentReference(parentEClass)\r\n\t\t\t\t.contains(this.getEReference());\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The eReference \'\" + this.getEReference().getName()\r\n\t\t\t+ \"\' is not allowed by the containing Class!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.structure.generic.util.GenericValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tGenericValidator.ACTUAL_REFERENCE__VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS, errorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.ACTUAL_REFERENCE__EREFERENCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateEReferenceMatchesParentEClass(DiagnosticChain diagnostics, Map<?, ?> context);
} // ActualReference
