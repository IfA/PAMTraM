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
package pamtram.structure.generic;

import java.util.List;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Reference</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents a reference of an element structure.
 * <br />
 * In order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the 'value' reference.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.generic.Reference#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.generic.GenericPackage#getReference()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eReferenceMatchesParentEClass'"
 * @generated
 */
public interface Reference<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends MetaModelElement<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link pamtram.structure.generic.Class#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Class containing this Reference.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see pamtram.structure.generic.GenericPackage#getReference_OwningClass()
	 * @see pamtram.structure.generic.Class#getReferences
	 * @model opposite="references" transient="false" changeable="false"
	 * @generated
	 */
	C getOwningClass();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<C> getValuesGeneric();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model valuesMany="true"
	 * @generated
	 */
	void addValuesGeneric(EList<C> values);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n// We consider a reference as \'extended\' if:\r\n// 1. the reference is directly contained in an abstract &lt;%pamtram.structure.generic.Section%&gt;,\r\n// 2. the reference is an &lt;%pamtram.structure.generic.ActualReference%&gt; (i.e. it represents a metamodel reference), and\r\n// 3. there is another reference further downward in the extension hierarchy that represents the same metamodel\r\n// reference\r\n//\r\nif (!(this instanceof ActualReference&lt;?, ?, ?, ?&gt; &amp;&amp; this.getOwningClass() instanceof Section&lt;?, ?, ?, ?&gt;\r\n\t\t&amp;&amp; ((Section&lt;?, ?, ?, ?&gt;) this.getOwningClass()).isAbstract())) {\r\n\treturn false;\r\n}\r\n\r\n&lt;%org.eclipse.emf.ecore.EReference%&gt; eReference = ((ActualReference&lt;?, ?, ?, ?&gt;) this).getEReference();\r\n\r\nif (eReference == null) {\r\n\treturn false;\r\n}\r\n\r\nreturn ((Section&lt;?, ?, ?, ?&gt;) this.getOwningClass()).getAllExtending().stream()\r\n\t\t.flatMap(s -&gt; s.getActualReferences().stream()).anyMatch(r -&gt; r.eClass().equals(this.eClass())\r\n\t\t\t\t&amp;&amp; eReference.equals(((ActualReference&lt;?, ?, ?, ?&gt;) r).getEReference()));'"
	 * @generated
	 */
	boolean isExtended();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;C&gt; values = new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&gt;(this.getValuesGeneric());\r\n\r\n// Only ActualReferences directly contained in Sections can extend other references\r\n//\r\nif (this.getOwningClass() instanceof &lt;%pamtram.structure.generic.Section%&gt;&lt;?, ?, ?, ?&gt; &amp;&amp; this instanceof &lt;%pamtram.structure.generic.ActualReference%&gt;&lt;?, ?, ?, ?&gt;\r\n\t\t&amp;&amp; ((ActualReference&lt;?, ?, ?, ?&gt;) this).getEReference() != null) {\r\n\r\n\t&lt;%org.eclipse.emf.ecore.EReference%&gt; eReference = ((ActualReference&lt;?, ?, ?, ?&gt;) this).getEReference();\r\n\r\n\t&lt;%java.util.List%&gt;&lt;&lt;%pamtram.structure.generic.Reference%&gt;&lt;?, ?, ?, ?&gt;&gt; extendedReferences = ((Section&lt;?, ?, ?, ?&gt;) this.getOwningClass())\r\n\t\t\t.getAllExtend().stream().flatMap(s -&gt; s.getActualReferences().stream())\r\n\t\t\t.filter(r -&gt; eReference.equals(((ActualReference&lt;?, ?, ?, ?&gt;) r).getEReference()))\r\n\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\r\n\tvalues.addAll((&lt;%java.util.Collection%&gt;&lt;? extends C&gt;) extendedReferences.stream()\r\n\t\t\t.flatMap(r -&gt; r.getValuesGeneric().stream()).collect(Collectors.toList()));\r\n}\r\n\r\nreturn values;'"
	 * @generated
	 */
	EList<C> getValuesIncludingExtended();

	void addValuesGeneric(List<C> values);

} // Reference
