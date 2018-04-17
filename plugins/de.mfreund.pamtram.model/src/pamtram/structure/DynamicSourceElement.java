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
package pamtram.structure;

import pamtram.ModifiableElement;
import pamtram.NamedElement;
import pamtram.mapping.Mapping;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A DynamicSourceElement represents a certain value that can be used in various calculations.
 * <br /><br />
 * The dynamic value is thereby calculated based on the value of an attribute of a SourceSection (resp. the matched source model excerpt(s)). As multiple source model excerpts can be matched against a single SourceSection (and thus against a single SourceSectionAttribute), a DynamicSourceElement may actually deliver many values that will be used by the calculation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.DynamicSourceElement#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.structure.DynamicSourceElement#isUseElementID <em>Use Element ID</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.StructurePackage#getDynamicSourceElement()
 * @model abstract="true"
 * @generated
 */
public interface DynamicSourceElement<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends NamedElement, ModifiableElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attribute of a SourceSection based on which the dynamic value(s) is/are calculated.
	 * <br /><br />
	 * The concrete sub-type of DynamicSourceElement poses additional constraints on the fact which SourceSectionAttributes may be used as 'source'.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Attribute)
	 * @see pamtram.structure.StructurePackage#getDynamicSourceElement_Source()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescriptor='this.itemPropertyDescriptors.add(\r\n\t\t\t\tnew ItemPropertyDescriptor(((&lt;%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%&gt;) this.adapterFactory).getRootAdapterFactory(),\r\n\t\t\t\t\t\tthis.getResourceLocator(), this.getString(\"_UI_DynamicSourceElement_source_feature\"),\r\n\t\t\t\t\t\tthis.getString(\"_UI_DynamicSourceElement_source_description\"),\r\n\t\t\t\t\t\t&lt;%pamtram.structure.StructurePackage%&gt;.Literals.DYNAMIC_SOURCE_ELEMENT__SOURCE, true, false, true, null,\r\n\t\t\t\t\t\tthis.getString(\"_UI_BasicPropertyCategory\"), null) {\r\n\r\t\t\t\t@Override\r\n\t\t\t\t\tpublic &lt;%java.util.Collection%&gt;&lt;?&gt; getChoiceOfValues(Object object) {\r\n\r\t\t\t\t\t// the parent &lt;%pamtram.mapping.Mapping%&gt;\r\n\t\t\t\t\t\t//\r\n\t\t\t\t\t\t&lt;%pamtram.mapping.Mapping%&gt; mapping = ((&lt;%pamtram.structure.DynamicSourceElement%&gt;&lt;?, ?, ?, ?&gt;) object).getMapping();\r\n\r\t\t\t\t\tif (mapping == null || mapping.getSourceSection() == null) {\r\n\t\t\t\t\t\t\treturn new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\n\t\t\t\t\t\t}\r\n\r\t\t\t\t\t&lt;%pamtram.structure.generic.Class%&gt;&lt;?, ?, ?, ?&gt; relevantClass = mapping.getSourceSection();\r\n\r\t\t\t\t\t&lt;%java.util.List%&gt;&lt;Object&gt; choiceOfValues = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\n\r\t\t\t\t\t// iterate over all elements and return the attributes as possible options\r\n\t\t\t\t\t\t//\r\n\t\t\t\t\t\t&lt;%java.util.Set%&gt;&lt;&lt;%pamtram.structure.generic.Class%&gt;&lt;?, ?, ?, ?&gt;&gt; scanned = new &lt;%java.util.HashSet%&gt;&lt;&gt;();\r\n\t\t\t\t\t\t&lt;%java.util.List%&gt;&lt;&lt;%pamtram.structure.generic.Class%&gt;&lt;?, ?, ?, ?&gt;&gt; sectionsToScan = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\n\t\t\t\t\t\tsectionsToScan.add(relevantClass);\r\n\r\t\t\t\t\t// also regard abstract sections that this extends\r\n\t\t\t\t\t\tif (relevantClass instanceof &lt;%pamtram.structure.generic.Section%&gt;) {\r\n\t\t\t\t\t\t\tsectionsToScan.addAll(((&lt;%pamtram.structure.generic.Section%&gt;&lt;?, ?, ?, ?&gt;) relevantClass).getAllExtend());\r\n\t\t\t\t\t\t}\r\n\r\t\t\t\t\twhile (!sectionsToScan.isEmpty()) {\r\n\t\t\t\t\t\t\t&lt;%pamtram.structure.generic.Class%&gt;&lt;?, ?, ?, ?&gt; classToScan = sectionsToScan.remove(0);\r\n\t\t\t\t\t\t\tscanned.add(classToScan);\r\n\r\t\t\t\t\t\t&lt;%java.util.Iterator%&gt;&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; it = classToScan.eAllContents();\r\n\t\t\t\t\t\t\twhile (it.hasNext()) {\r\n\t\t\t\t\t\t\t\t&lt;%org.eclipse.emf.ecore.EObject%&gt; next = it.next();\r\n\t\t\t\t\t\t\t\tif (next instanceof pamtram.structure.generic.Attribute) {\r\n\t\t\t\t\t\t\t\t\tchoiceOfValues.add(next);\r\n\t\t\t\t\t\t\t\t} else if (next instanceof &lt;%pamtram.structure.generic.CrossReference%&gt;) {\r\n\t\t\t\t\t\t\t\t\t&lt;%java.util.List%&gt;&lt;&lt;%pamtram.structure.source.SourceSectionClass%&gt;&gt; vals = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\n\t\t\t\t\t\t\t\t\tvals.addAll(((&lt;%pamtram.structure.generic.CrossReference%&gt;) next).getValue());\r\n\t\t\t\t\t\t\t\t\tvals.removeAll(scanned);\r\n\t\t\t\t\t\t\t\t\tsectionsToScan.addAll(vals);\r\n\t\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t}\r\n\r\t\t\t\t\treturn choiceOfValues;\r\n\t\t\t\t\t}\r\n\t\t\t\t});'"
	 * @generated
	 */
	A getSource();

	/**
	 * Sets the value of the '{@link pamtram.structure.DynamicSourceElement#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(A value);

	/**
	 * Returns the value of the '<em><b>Use Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this is set to '<em>true</em>' a (model-unique) numeric identifier instead of the actual value of the source attribute will be used.
	 * <p />
	 * This can be used to insert identifiers into the target model.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Use Element ID</em>' attribute.
	 * @see #setUseElementID(boolean)
	 * @see pamtram.structure.StructurePackage#getDynamicSourceElement_UseElementID()
	 * @model
	 * @generated
	 */
	boolean isUseElementID();

	/**
	 * Sets the value of the '{@link pamtram.structure.DynamicSourceElement#isUseElementID <em>Use Element ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Element ID</em>' attribute.
	 * @see #isUseElementID()
	 * @generated
	 */
	void setUseElementID(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EObject ret = this.eContainer;\r\nwhile(!(ret instanceof MappingHintGroupType || ret instanceof InstantiableMappingHintGroup)) {\r\n\tret = ret.eContainer();\r\n\tif(ret instanceof PAMTraM) {\r\n\t\t// something went wrong\r\n\t\treturn null;\r\n\t}\r\n}\r\nreturn (NamedElement) ret;'"
	 * @generated
	 */
	NamedElement getMappingHintGroup();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EObject ret = this.eContainer;\r\nwhile(!(ret instanceof Mapping)) {\r\n\tret = ret.eContainer();\r\n\tif(ret instanceof PAMTraM) {\r\n\t\t// something went wrong\r\n\t\treturn null;\r\n\t}\r\n}\r\nreturn (Mapping) ret;'"
	 * @generated
	 */
	Mapping getMapping();

} // DynamicSourceElement
