/**
 */
package pamtram.structure;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Instance Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TargetInstanceSelectors can be used to select a certain subset of a list of target model excerpts that have been created based on a certain TargetSection in the course of a transformation.
 * The specific use case for this selection depends on the concrete sub-type of this class.
 * <br />
 * <br />
 * The selection process is based on the comparison of the value of a certain attribute of the created TargetSections with a reference value. The reference value is thereby calculated based on the list of specified 'sourceElements'.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.TargetInstanceSelector#getReferenceAttribute <em>Reference Attribute</em>}</li>
 *   <li>{@link pamtram.structure.TargetInstanceSelector#getTargetClass <em>Target Class</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.StructurePackage#getTargetInstanceSelector()
 * @model
 * @generated
 */
public interface TargetInstanceSelector extends InstanceSelector {
	/**
	 * Returns the value of the '<em><b>Reference Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TargetSectionClass one of whose created instances shall be selected.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reference Attribute</em>' reference.
	 * @see #setReferenceAttribute(TargetSectionAttribute)
	 * @see pamtram.structure.StructurePackage#getTargetInstanceSelector_ReferenceAttribute()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescriptor='itemPropertyDescriptors.add\n\t(new &lt;%org.eclipse.emf.edit.provider.ItemPropertyDescriptor%&gt;\n\t\t(((&lt;%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%&gt;)adapterFactory).getRootAdapterFactory(),\n\t\t getResourceLocator(),\n\t\t getString(\"_UI_TargetInstanceSelector_referenceAttribute_feature\"),\n\t\t getString(\"_UI_TargetInstanceSelector_referenceAttribute_description\"),\n\t\t &lt;%pamtram.structure.StructurePackage%&gt;.Literals.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE,\n\t\t true,\n\t\t false,\n\t\t true,\n\t\t null,\n\t\t getString(\"_UI_BasicPropertyCategory\"),\n\t\t null) {\n\t\t\n\t\t@Override\n\t\tpublic &lt;%java.util.Collection%&gt;&lt;?&gt; getChoiceOfValues(Object object) {\n\t\t\n\t\t\t&lt;%java.util.Collection%&gt;&lt;?&gt; choices = super.getChoiceOfValues(object);\n\t\t\t\n\t\t\t// If a \'targetClass\' has already been set for this \'TargetInstanceSelector\', allow only those choices\n\t\t\t\t// that are part of the same &lt;%pamtram.structure.target.TargetSection%&gt; as the specified \'targetClass\' (or of one of the extended\n\t\t\t\t// sections).\n\t\t\t\t//\n\t\t\t\tif (object instanceof &lt;%pamtram.structure.TargetInstanceSelector%&gt;\n\t\t\t\t\t\t&amp;&amp; ((&lt;%pamtram.structure.TargetInstanceSelector%&gt;) object).getTargetClass() != null) {\n\t\t\t\n\t\t\t\t&lt;%pamtram.structure.target.TargetSection%&gt; section = ((&lt;%pamtram.structure.TargetInstanceSelector%&gt;) object).getTargetClass().getContainingSection();\n\t\t\t\t\tif (section != null) {\n\t\t\t\n\t\t\t\t\t&lt;%java.util.List%&gt;&lt;&lt;%pamtram.structure.target.TargetSection%&gt;&gt; allowedSections = new &lt;%java.util.ArrayList%&gt;&lt;&gt;(&lt;%java.util.Arrays%&gt;.asList(section));\n\t\t\t\t\t\tallowedSections.addAll(section.getAllExtend());\n\t\t\t\n\t\t\t\t\treturn choices.stream()\n\t\t\t\t\t\t\t\t.filter(c -&gt; c instanceof pamtram.structure.target.TargetSectionAttribute &amp;&amp; allowedSections\n\t\t\t\t\t\t\t\t\t\t.contains(((pamtram.structure.target.TargetSectionAttribute) c).getContainingSection()))\n\t\t\t\t\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\n\t\t\t\t\t}\n\t\t\t\n\t\t\t}\n\t\t\t\n\t\t\treturn choices;\n\t\t}\n\t});'"
	 * @generated
	 */
	TargetSectionAttribute getReferenceAttribute();

	/**
	 * Sets the value of the '{@link pamtram.structure.TargetInstanceSelector#getReferenceAttribute <em>Reference Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Attribute</em>' reference.
	 * @see #getReferenceAttribute()
	 * @generated
	 */
	void setReferenceAttribute(TargetSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TargetSectionClass one of whose created instances shall be selected.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Class</em>' reference.
	 * @see #setTargetClass(TargetSectionClass)
	 * @see pamtram.structure.StructurePackage#getTargetInstanceSelector_TargetClass()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescriptor='this.itemPropertyDescriptors.add(\n\t\tnew ItemPropertyDescriptor(((&lt;%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%&gt;) this.adapterFactory).getRootAdapterFactory(),\n\t\t\t\tthis.getResourceLocator(), this.getString(\"_UI_TargetInstanceSelector_targetClass_feature\"),\n\t\t\t\tthis.getString(\"_UI_TargetInstanceSelector_targetClass_description\"),\n\t\t\t\t&lt;%pamtram.structure.StructurePackage%&gt;.Literals.TARGET_INSTANCE_SELECTOR__TARGET_CLASS, true, false, true, null,\n\t\t\t\tthis.getString(\"_UI_BasicPropertyCategory\"), null) {\n\n\t\t\t@Override\n\t\t\tpublic &lt;%java.util.Collection%&gt;&lt;?&gt; getChoiceOfValues(Object object) {\n\n\t\t\t\t&lt;%java.util.Collection%&gt;&lt;?&gt; choices = super.getChoiceOfValues(object);\n\n\t\t\t\t// If an \'affectedReference\' has already been set for this \'TargetInstanceSelector\', allow only\n\t\t\t\t// those choices\n\t\t\t\t// that are compatible with the selected reference.\n\t\t\t\t//\n\t\t\t\tif (object instanceof &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;\n\t\t\t\t\t\t&amp;&amp; ((&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) object).getAffectedReference() != null\n\t\t\t\t\t\t&amp;&amp; ((&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) object).getAffectedReference().getEReference() != null) {\n\n\t\t\t\t\t&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt; referenceTargetSelector = (&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) object;\n\n\t\t\t\t\treturn choices.stream().filter(c -&gt; c instanceof pamtram.structure.target.TargetSectionClass)\n\t\t\t\t\t\t\t.map(c -&gt; (pamtram.structure.target.TargetSectionClass) c)\n\t\t\t\t\t\t\t.filter(targetClass -&gt; targetClass.getEClass() != null\n\t\t\t\t\t\t\t\t\t&amp;&amp; referenceTargetSelector.getAffectedReference().getEReference()\n\t\t\t\t\t\t\t\t\t\t\t.getEReferenceType().isSuperTypeOf(targetClass.getEClass()))\n\t\t\t\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\n\n\t\t\t\t}\n\n\t\t\t\treturn super.getChoiceOfValues(object);\n\t\t\t}\n\t\t});'"
	 * @generated
	 */
	TargetSectionClass getTargetClass();

	/**
	 * Sets the value of the '{@link pamtram.structure.TargetInstanceSelector#getTargetClass <em>Target Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Class</em>' reference.
	 * @see #getTargetClass()
	 * @generated
	 */
	void setTargetClass(TargetSectionClass value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this.referenceAttribute == null || this.targetClass == null\r\n\t\t\t\t|| this.targetClass.getContainingSection() == null) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\t// If a \'targetClass\' has already been set for this \'TargetInstanceSelector\', allow only \'referenceAttributes\'\r\n\t\t// that are part of the same &lt;%pamtram.structure.target.TargetSection%&gt; as the specified \'targetClass\' (or of one of the extended\r\n\t\t// sections).\r\n\t\t//\r\n\r\t&lt;%pamtram.structure.target.TargetSection%&gt; section = this.targetClass.getContainingSection();\r\n\r\tList&lt;&lt;%pamtram.structure.target.TargetSection%&gt;&gt; allowedSections = new ArrayList&lt;&gt;(&lt;%java.util.Arrays%&gt;.asList(section));\r\n\t\tallowedSections.addAll(section.getAllExtend());\r\n\r\tboolean result = allowedSections.contains(this.referenceAttribute.getContainingSection());\r\n\r\tif (!result &amp;&amp; diagnostics != null) {\r\n\r\t\tString errorMessage = \"The \'referenceAttribute\' must be contained in the same &lt;%pamtram.structure.target.TargetSection%&gt; (or an extended section) as the \'targetClass\'!\";\r\n\r\t\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.structure.util.StructureValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%pamtram.structure.util.StructureValidator%&gt;.TARGET_INSTANCE_SELECTOR__VALIDATE_REFERENCE_ATTRIBUTE_IS_VALID, errorMessage,\r\n\t\t\t\t\tnew Object[] { this, &lt;%pamtram.structure.StructurePackage%&gt;.Literals.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE }));\r\n\r\t}\r\n\r\treturn result;'"
	 * @generated
	 */
	boolean validateReferenceAttributeIsValid(DiagnosticChain diagnostics, Map<?, ?> context);

} // TargetInstanceSelector
