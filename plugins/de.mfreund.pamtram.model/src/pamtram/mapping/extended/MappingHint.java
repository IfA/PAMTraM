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
package pamtram.mapping.extended;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Hint</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An abstract super-type for all MappingHints that can be used in MappingHintGroups.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.MappingHint#getOverwrite <em>Overwrite</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.extended.ExtendedPackage#getMappingHint()
 * @model abstract="true"
 * @generated
 */
public interface MappingHint extends MappingHintType, ConditionalElement, DeactivatableElement {

	/**
	 * Returns the value of the '<em><b>Overwrite</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A MappingHint from an extended MappingHintGroup that shall not be added to this MappingHintGroup but be overwritten instead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Overwrite</em>' reference.
	 * @see #setOverwrite(MappingHint)
	 * @see pamtram.mapping.extended.ExtendedPackage#getMappingHint_Overwrite()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescriptor='// ContainerSelectors will always overwrite extended Selectors so they do not need this descriptor\n//\nif (!(object instanceof &lt;%pamtram.mapping.extended.ContainerSelector%&gt;)) {\n\n\tthis.itemPropertyDescriptors.add(new ItemPropertyDescriptor(\n\t\t\t((&lt;%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%&gt;) this.adapterFactory).getRootAdapterFactory(),\n\t\t\tthis.getResourceLocator(), this.getString(\"_UI_MappingHint_overwrite_feature\"),\n\t\t\tthis.getString(\"_UI_MappingHint_overwrite_description\"),\n\t\t\t&lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.MAPPING_HINT__OVERWRITE, true, false, true, null,\n\t\t\tthis.getString(\"_UI_ExtendedPropertyCategory\"), null) {\n\n\t\t@Override\n\t\tpublic &lt;%java.util.Collection%&gt;&lt;?&gt; getChoiceOfValues(Object object) {\n\n\t\t\t&lt;%pamtram.mapping.extended.MappingHint%&gt; hint = (&lt;%pamtram.mapping.extended.MappingHint%&gt;) object;\n\t\t\tif (!(hint.eContainer() instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt;)) {\n\t\t\t\treturn new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\n\t\t\t}\n\n\t\t\t&lt;%java.util.Set%&gt;&lt;&lt;%pamtram.mapping.extended.MappingHint%&gt;&gt; possibleOverwrites = ((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) hint.eContainer()).getExtend()\n\t\t\t\t\t.stream().flatMap(h -&gt; h.getAllMappingHints().stream())\n\t\t\t\t\t.filter(h -&gt; hint.eClass().equals(h.eClass()))\n\t\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toCollection(java.util.LinkedHashSet::new));\n\n\t\t\tif (hint instanceof &lt;%pamtram.mapping.extended.AttributeMapping%&gt;) {\n\t\t\t\t&lt;%pamtram.mapping.extended.AttributeMapping%&gt; attributeMapping = (&lt;%pamtram.mapping.extended.AttributeMapping%&gt;) hint;\n\t\t\t\tif (attributeMapping.getTarget() == null) {\n\t\t\t\t\treturn new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\n\t\t\t\t} else {\n\t\t\t\t\treturn possibleOverwrites.stream().map(h -&gt; (&lt;%pamtram.mapping.extended.AttributeMapping%&gt;) h)\n\t\t\t\t\t\t\t.filter(am -&gt; attributeMapping.getTarget().equals(am.getTarget()))\n\t\t\t\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\n\t\t\t\t}\n\t\t\t} else if (hint instanceof &lt;%pamtram.mapping.extended.CardinalityMapping%&gt;) {\n\t\t\t\t&lt;%pamtram.mapping.extended.CardinalityMapping%&gt; cardinalityMapping = (&lt;%pamtram.mapping.extended.CardinalityMapping%&gt;) hint;\n\t\t\t\tif (cardinalityMapping.getTarget() == null) {\n\t\t\t\t\treturn new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\n\t\t\t\t} else {\n\t\t\t\t\treturn possibleOverwrites.stream().map(h -&gt; (&lt;%pamtram.mapping.extended.CardinalityMapping%&gt;) h)\n\t\t\t\t\t\t\t.filter(cm -&gt; cardinalityMapping.getTarget().equals(cm.getTarget()))\n\t\t\t\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\n\t\t\t\t}\n\t\t\t} else if (hint instanceof &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) {\n\t\t\t\t&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt; referenceTargetSelector = (&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) hint;\n\t\t\t\tif (referenceTargetSelector.getAffectedReference() == null) {\n\t\t\t\t\treturn new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\n\t\t\t\t} else {\n\t\t\t\t\treturn possibleOverwrites.stream().map(h -&gt; (&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) h)\n\t\t\t\t\t\t\t.filter(rts -&gt; referenceTargetSelector.getAffectedReference()\n\t\t\t\t\t\t\t\t\t.equals(rts.getAffectedReference()))\n\t\t\t\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\n\t\t\t\t}\n\t\t\t} else if (hint instanceof &lt;%pamtram.mapping.extended.ContainerSelector%&gt;) {\n\t\t\t\treturn new &lt;%java.util.ArrayList%&gt;&lt;&gt;(possibleOverwrites);\n\t\t\t} else {\n\t\t\t\treturn new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\n\t\t\t}\n\t\t}\n\t});\n}'"
	 * @generated
	 */
	MappingHint getOverwrite();

	/**
	 * Sets the value of the '{@link pamtram.mapping.extended.MappingHint#getOverwrite <em>Overwrite</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overwrite</em>' reference.
	 * @see #getOverwrite()
	 * @generated
	 */
	void setOverwrite(MappingHint value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (this.overwrite == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean ret = true;\r\nString message = \"\";\r\n\r\nif (this.eClass() != this.overwrite.eClass()) {\r\n\tret = false;\r\n\tmessage = \"MappingHints must only overwrite MappingHints of the same type!\";\r\n}\r\n\r\nif (((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) this.eContainer()).getAllExtend().isEmpty()\r\n\t\t|| ((MappingHintGroupType) this.eContainer()).getAllExtend().stream()\r\n\t\t\t\t.noneMatch(hg -&gt; hg.getAllMappingHints().contains(this.overwrite))) {\r\n\tret = false;\r\n\tmessage = \"The overwritten &lt;%pamtram.mapping.extended.MappingHint%&gt; is not part of a &lt;%pamtram.mapping.MappingHintGroup%&gt; that is extended by the HintGroup containing this MappingHint!\";\r\n}\r\n\r\nif (this instanceof &lt;%pamtram.mapping.extended.AttributeMapping%&gt;\r\n\t\t&amp;&amp; ((AttributeMapping) this).getTarget() != ((AttributeMapping) this.overwrite).getTarget()) {\r\n\tret = false;\r\n\tmessage = \"An AttributeMapping must only overwrite another AttributeMapping pointing to the same TargetSectionAttribute!\";\r\n} else if (this instanceof &lt;%pamtram.mapping.extended.CardinalityMapping%&gt;\r\n\t\t&amp;&amp; ((CardinalityMapping) this).getTarget() != ((CardinalityMapping) this.overwrite).getTarget()) {\r\n\tret = false;\r\n\tmessage = \"A CardinalityMapping must only overwrite another CardinalityMapping pointing to the same TargetSectionClass!\";\r\n} else if (this instanceof &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt; &amp;&amp; ((ReferenceTargetSelector) this)\r\n\t\t.getAffectedReference() != ((ReferenceTargetSelector) this.overwrite).getAffectedReference()) {\r\n\tret = false;\r\n\tmessage = \"A ReferenceTargetSelector must only overwrite another ReferenceTargetSelector pointing to the same TargetSectionReference!\";\r\n}\r\n\r\nif (!ret &amp;&amp; diagnostics != null) {\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tExtendedValidator.MAPPING_HINT__VALIDATE_OVERWRITES_VALID_MAPPING_HINT, message,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.MAPPING_HINT__OVERWRITE }));\r\n}\r\n\r\nreturn ret;'"
	 * @generated
	 */
	boolean validateOverwritesValidMappingHint(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (!(this.eContainer instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt;) || this.overwrite != null) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%java.util.List%&gt;&lt;&lt;%pamtram.mapping.extended.MappingHint%&gt;&gt; hintsOfExtendedHintGroups = ((MappingHintGroupType) this.eContainer()).getAllExtend().stream()\r\n\t\t.flatMap(hg -&gt; hg.getMappingHints().stream()).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\r\nif (hintsOfExtendedHintGroups.isEmpty()) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%java.util.Optional%&gt;&lt;MappingHint&gt; hintToConsider = Optional.empty();\r\n\r\nif (this instanceof &lt;%pamtram.mapping.extended.AttributeMapping%&gt; &amp;&amp; ((AttributeMapping) this).getTarget() != null) {\r\n\r\n\thintToConsider = hintsOfExtendedHintGroups.stream().filter(h -&gt; h instanceof AttributeMapping)\r\n\t\t\t.filter(h -&gt; ((AttributeMapping) this).getTarget().equals(((AttributeMapping) h).getTarget()))\r\n\t\t\t.findAny();\r\n\r\n} else if (this instanceof &lt;%pamtram.mapping.extended.CardinalityMapping%&gt; &amp;&amp; ((CardinalityMapping) this).getTarget() != null) {\r\n\r\n\thintToConsider = hintsOfExtendedHintGroups.stream().filter(h -&gt; h instanceof CardinalityMapping)\r\n\t\t\t.filter(h -&gt; ((CardinalityMapping) this).getTarget().equals(((CardinalityMapping) h).getTarget()))\r\n\t\t\t.findAny();\r\n\r\n} else if (this instanceof &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;\r\n\t\t&amp;&amp; ((ReferenceTargetSelector) this).getAffectedReference() != null) {\r\n\r\n\thintToConsider = hintsOfExtendedHintGroups.stream().filter(h -&gt; h instanceof ReferenceTargetSelector)\r\n\t\t\t.filter(h -&gt; ((ReferenceTargetSelector) this).getAffectedReference()\r\n\t\t\t\t\t.equals(((ReferenceTargetSelector) h).getAffectedReference()))\r\n\t\t\t.findAny();\r\n}\r\n\r\nif (!hintToConsider.isPresent()) {\r\n\treturn true;\r\n}\r\n\r\nString message = \"The hint \'\" + hintToConsider.get().getName() + \"\' of the extended &lt;%pamtram.mapping.MappingHintGroup%&gt; \"\r\n\t\t+ (hintToConsider.get().eContainer() instanceof MappingHintGroupType\r\n\t\t\t\t? \"\'\" + ((MappingHintGroupType) hintToConsider.get().eContainer()).getName() + \"\' \"\r\n\t\t\t\t: \"\")\r\n\t\t+ \"affects the same target element. Consider overwriting this hint instead of providing additional hint values...\";\r\n\r\nif (diagnostics != null) {\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.WARNING, &lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tExtendedValidator.MAPPING_HINT__VALIDATE_CONSIDER_OVERWRITING_HINT, message,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.MAPPING_HINT__OVERWRITE }));\r\n}\r\n\r\nreturn false;'"
	 * @generated
	 */
	boolean validateConsiderOverwritingHint(DiagnosticChain diagnostics, Map<?, ?> context);

} // MappingHint
