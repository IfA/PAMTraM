/**
 */
package pamtram.structure.generic;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAttribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actual Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents an attribute (as an instance of an EAttribute) of an element structure.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.generic.ActualAttribute#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.generic.GenericPackage#getActualAttribute()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='attributeMatchesParentEClass'"
 * @generated
 */
public interface ActualAttribute<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends Attribute<S, C, R, A> {

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The metamodel element (EAttribute) that this Attribute represents.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(EAttribute)
	 * @see pamtram.structure.generic.GenericPackage#getActualAttribute_Attribute()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescriptor='\r\nthis.itemPropertyDescriptors.add(\r\n\t\tnew ItemPropertyDescriptor(((&lt;%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%&gt;) this.adapterFactory).getRootAdapterFactory(),\r\n\t\t\t\tthis.getResourceLocator(), this.getString(\"_UI_ActualAttribute_attribute_feature\"),\r\n\t\t\t\tthis.getString(\"_UI_ActualAttribute_attribute_description\"),\r\n\t\t\t\t&lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.ACTUAL_ATTRIBUTE__ATTRIBUTE, true, false, true, null,\r\n\t\t\t\tthis.getString(\"_UI_BasicPropertyCategory\"), null) {\r\n\r\n\t\t\t@Override\r\n\t\t\tpublic &lt;%java.util.Collection%&gt;&lt;?&gt; getChoiceOfValues(Object object) {\r\n\r\n\t\t\t\t&lt;%pamtram.structure.generic.ActualAttribute%&gt;&lt;?, ?, ?, ?&gt; att = (ActualAttribute&lt;?, ?, ?, ?&gt;) object;\r\n\r\n\t\t\t\t&lt;%java.util.List%&gt;&lt;&lt;%org.eclipse.emf.ecore.EAttribute%&gt;&gt; attributes = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\n\r\n\t\t\t\t// in case of a \'normal\' TargetSectionClass, the\r\n\t\t\t\t// attribute of this class can be chosen\r\n\t\t\t\tif (att.getOwningClass() != null) {\r\n\t\t\t\t\tattributes.addAll(att.getOwningClass().getEClass().getEAllAttributes());\r\n\t\t\t\t\t// in case of an &lt;%pamtram.structure.library.AttributeParameter%&gt;, the attribute\r\n\t\t\t\t\t// of its source can be chosen\r\n\t\t\t\t} else if (att.eContainer() instanceof AttributeParameter\r\n\t\t\t\t\t\t&amp;&amp; ((AttributeParameter) att.eContainer()).getSource() != null) {\r\n\t\t\t\t\tattributes.addAll(\r\n\t\t\t\t\t\t\t((AttributeParameter) att.eContainer()).getSource().eClass().getEAllAttributes());\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Do not allow \'xs:any\'-content attributes\r\n\t\t\t\t//\r\n\t\t\t\treturn attributes.stream()\r\n\t\t\t\t\t\t.filter(a -&gt; !pamtram.util.ExtendedMetaDataUtil.isAnyContentAttribute(a))\r\n\t\t\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\t\t\t}\r\n\t\t});'"
	 * @generated
	 */
	EAttribute getAttribute();

	/**
	 * Sets the value of the '{@link pamtram.structure.generic.ActualAttribute#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(EAttribute value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.isLibraryEntry() || this.getAttribute() == null || !(this.eContainer() instanceof &lt;%pamtram.structure.generic.Class%&gt;&lt;?, ?, ?, ?&gt;)) {\r\n\treturn true;\r\n}\r\n\r\nEClass parentEClass = ((&lt;%pamtram.structure.generic.Class%&gt;&lt;?, ?, ?, ?&gt;) this.eContainer()).getEClass();\r\n\r\nboolean result = parentEClass == null ? true : parentEClass.getEAllAttributes().contains(this.getAttribute());\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The eAttribute \'\" + this.getAttribute().getName() + \"\' is not allowed by the containing Class!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.structure.generic.util.GenericValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tGenericValidator.ACTUAL_ATTRIBUTE__VALIDATE_ATTRIBUTE_MATCHES_PARENT_ECLASS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.ACTUAL_ATTRIBUTE__ATTRIBUTE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateAttributeMatchesParentEClass(DiagnosticChain diagnostics, Map<?, ?> context);
} // ActualAttribute
