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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescriptor='this.itemPropertyDescriptors.add(\n\t\tnew ItemPropertyDescriptor(((&lt;%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%&gt;) this.adapterFactory).getRootAdapterFactory(),\n\t\t\t\tthis.getResourceLocator(), this.getString(\"_UI_DynamicSourceElement_source_feature\"),\n\t\t\t\tthis.getString(\"_UI_DynamicSourceElement_source_description\"),\n\t\t\t\t&lt;%pamtram.structure.StructurePackage%&gt;.Literals.DYNAMIC_SOURCE_ELEMENT__SOURCE, true, false, true, null,\n\t\t\t\tthis.getString(\"_UI_BasicPropertyCategory\"), null) {\n\n\t\t\t@Override\n\t\t\tpublic Collection&lt;?&gt; getChoiceOfValues(Object object) {\n\n\t\t\t\t// the parent &lt;%pamtram.mapping.Mapping%&gt;\n\t\t\t\t//\n\t\t\t\t&lt;%pamtram.mapping.Mapping%&gt; mapping = ((DynamicSourceElement&lt;?, ?, ?, ?&gt;) object).getMapping();\n\n\t\t\t\tif (mapping == null || mapping.getSourceSection() == null) {\n\t\t\t\t\treturn new ArrayList&lt;&gt;();\n\t\t\t\t}\n\n\t\t\t\tClass&lt;?, ?, ?, ?&gt; relevantClass = mapping.getSourceSection();\n\n\t\t\t\tList&lt;Object&gt; choiceOfValues = new ArrayList&lt;&gt;();\n\n\t\t\t\t// iterate over all elements and return the attributes as possible options\n\t\t\t\t//\n\t\t\t\tSet&lt;Class&lt;?, ?, ?, ?&gt;&gt; scanned = new HashSet&lt;&gt;();\n\t\t\t\tList&lt;Class&lt;?, ?, ?, ?&gt;&gt; sectionsToScan = new ArrayList&lt;&gt;();\n\t\t\t\tsectionsToScan.add(relevantClass);\n\n\t\t\t\t// also regard abstract sections that this extends\n\t\t\t\tif (relevantClass instanceof &lt;%pamtram.structure.generic.Section%&gt;) {\n\t\t\t\t\tsectionsToScan.addAll(((Section&lt;?, ?, ?, ?&gt;) relevantClass).getAllExtend());\n\t\t\t\t}\n\n\t\t\t\twhile (!sectionsToScan.isEmpty()) {\n\t\t\t\t\tClass&lt;?, ?, ?, ?&gt; classToScan = sectionsToScan.remove(0);\n\t\t\t\t\tscanned.add(classToScan);\n\n\t\t\t\t\tIterator&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; it = classToScan.eAllContents();\n\t\t\t\t\twhile (it.hasNext()) {\n\t\t\t\t\t\t&lt;%org.eclipse.emf.ecore.EObject%&gt; next = it.next();\n\t\t\t\t\t\tif (next instanceof pamtram.structure.generic.Attribute) {\n\t\t\t\t\t\t\tchoiceOfValues.add(next);\n\t\t\t\t\t\t} else if (next instanceof &lt;%pamtram.structure.generic.CrossReference%&gt;) {\n\t\t\t\t\t\t\tList&lt;&lt;%pamtram.structure.source.SourceSectionClass%&gt;&gt; vals = new ArrayList&lt;&gt;();\n\t\t\t\t\t\t\tvals.addAll(((&lt;%pamtram.structure.generic.CrossReference%&gt;) next).getValue());\n\t\t\t\t\t\t\tvals.removeAll(scanned);\n\t\t\t\t\t\t\tsectionsToScan.addAll(vals);\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t\treturn choiceOfValues;\n\t\t\t}\n\t\t});'"
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
