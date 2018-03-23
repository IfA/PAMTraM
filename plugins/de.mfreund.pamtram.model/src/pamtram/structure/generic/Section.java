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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A special Class that represents the root element (as an instance of an EClass) of an element structure.
 * <br />
 * Note: Every specified structure must contain one and only one Section element (its root element).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.generic.Section#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link pamtram.structure.generic.Section#getExtend <em>Extend</em>}</li>
 *   <li>{@link pamtram.structure.generic.Section#getAllExtend <em>All Extend</em>}</li>
 *   <li>{@link pamtram.structure.generic.Section#getAllExtending <em>All Extending</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.generic.GenericPackage#getSection()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='extendsValidSections containerMatchesExtendContainer'"
 * @generated
 */
public interface Section<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends pamtram.structure.generic.Class<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to 'true', this Section can be extended by other specified Sections (via the 'extend' reference) which will then recursively inherit the structure specified by this Section (all contained Attributes, References and Classes).
	 * <br /><br />
	 * Note: Abstract Sections will not be (directly) matched against a source model. Consequently, Mappings based on abstract Sections will never be executed. Such mappings can however be used to specifiy abstract MappingHintGroups which can be extended by concrete MappingHintGroups that are based on a concrete Sub-Section of this abstract Section.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see pamtram.structure.generic.GenericPackage#getSection_Abstract()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link pamtram.structure.generic.Section#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Extend</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extend</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of (abstract) Sections that this Section extends.
	 * <br /><br />
	 * This Section will recursively inherit the structure specified by all extended Sections (all contained Attributes, References and Classes).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extend</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getSection_Extend()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescriptor='itemPropertyDescriptors.add\r\n\t(new &lt;%org.eclipse.emf.edit.provider.ItemPropertyDescriptor%&gt;\r\n\t\t(((&lt;%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%&gt;)adapterFactory).getRootAdapterFactory(),\r\n\t\t getResourceLocator(),\r\n\t\t getString(\"_UI_Section_extend_feature\"),\r\n\t\t getString(\"_UI_Section_extend_description\"),\r\n\t\t &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.SECTION__EXTEND,\r\n\t\t true,\r\n\t\t false,\r\n\t\t true,\r\n\t\t null,\r\n\t\t getString(\"_UI_ExtendedPropertyCategory\"),\r\n\t\t null) {\r\n\t\t\r\n\t\t@Override\r\n\t\tpublic &lt;%java.util.Collection%&gt;&lt;?&gt; getChoiceOfValues(Object object) {\r\n\t\t\r\n\t\t\treturn super.getChoiceOfValues(object).stream().filter(e -&gt; !e.equals(object) &amp;&amp; !((&lt;%pamtram.structure.generic.Section%&gt;&lt;?, ?, ?, ?&gt;) e).getAllExtend().contains(object)).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\t\t}\r\n\t});'"
	 * @generated
	 */
	EList<S> getExtend();

	/**
	 * Returns the value of the '<em><b>All Extend</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Extend</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Extend</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getSection_AllExtend()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.util.Set%&gt;&lt;Object&gt; ret = new &lt;%java.util.LinkedHashSet%&gt;&lt;&gt;();\r\n\r\n&lt;%java.util.List%&gt;&lt;Section&lt;?, ?, ?, ?&gt;&gt; toCheck = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\ntoCheck.add(this);\r\n\r\nwhile (!toCheck.isEmpty()) {\r\n\tSection&lt;?, ?, ?, ?&gt; next = toCheck.remove(0);\r\n\r\n\tList&lt;Section&lt;?, ?, ?, ?&gt;&gt; localToCheck = next.getExtend().stream().filter(e -&gt; !ret.contains(e))\r\n\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\tret.addAll(localToCheck);\r\n\ttoCheck.addAll(localToCheck);\r\n}\r\n\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.SECTION__ALL_EXTEND, ret.size(),\r\n\t\tret.toArray());'"
	 * @generated
	 */
	EList<S> getAllExtend();

	/**
	 * Returns the value of the '<em><b>All Extending</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Extending</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Extending</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getSection_AllExtending()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='\r\n&lt;%java.util.Set%&gt;&lt;Object&gt; extendingSections = new &lt;%java.util.LinkedHashSet%&gt;&lt;&gt;();\r\n&lt;%java.util.Iterator%&gt;&lt;&lt;%org.eclipse.emf.common.notify.Notifier%&gt;&gt; it = this.eResource().getResourceSet().getAllContents();\r\nwhile (it.hasNext()) {\r\n\tNotifier next = it.next();\r\n\tif (next instanceof &lt;%pamtram.structure.generic.Section%&gt;&lt;?, ?, ?, ?&gt; &amp;&amp; ((Section&lt;?, ?, ?, ?&gt;) next).getAllExtend().contains(this)) {\r\n\t\textendingSections.add(next);\r\n\t}\r\n}\r\n\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.SECTION__ALL_EXTENDING,\r\n\t\textendingSections.size(), extendingSections.toArray());'"
	 * @generated
	 */
	EList<S> getAllExtending();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.getContainer() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getExtend().parallelStream().allMatch(\r\n\t\te -&gt; e.getContainer() == null || e.getContainer() == this.getContainer());\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\t\r\n\tString errorMessage = \"The section extends a section that specifies a different container!\";\r\n\t\r\n\tdiagnostics.add\r\n\t\t(new BasicDiagnostic\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t &lt;%pamtram.structure.generic.util.GenericValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tGenericValidator.SECTION__VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER,\r\n\t\t\t errorMessage,\r\n\t\t\t new Object [] { this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.SECTION__EXTEND }));\r\n\t}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateContainerMatchesExtendContainer(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.getEClass() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getExtend().parallelStream().noneMatch(e -&gt; !e.isAbstract() || e.getEClass() != null\r\n\t\t&amp;&amp; this.getEClass() != e.getEClass() &amp;&amp; !this.getEClass().getEAllSuperTypes().contains(e.getEClass()));\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The Section extends a Section that is either not abstract or that references an EClass of a different (super-)type!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.structure.generic.util.GenericValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tGenericValidator.SECTION__VALIDATE_EXTENDS_VALID_SECTIONS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.SECTION__EXTEND }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateExtendsValidSections(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean result = !this.getAllExtend().contains(this);\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"A Section must not extend itself (neither directly nor indirectly)!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, \r\n\t\t\t&lt;%pamtram.structure.generic.util.GenericValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\tGenericValidator.SECTION__VALIDATE_NOT_EXTEND_SELF, \r\n\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.SECTION__EXTEND }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateNotExtendSelf(DiagnosticChain diagnostics, Map<?, ?> context);
} // Section
