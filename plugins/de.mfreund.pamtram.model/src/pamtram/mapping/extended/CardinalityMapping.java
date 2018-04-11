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

import org.eclipse.emf.common.util.EList;
import pamtram.ExpressionElement;
import pamtram.MatchSpecElement;
import pamtram.ModifiableElement;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;
import pamtram.structure.target.TargetSectionClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cardinality Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappingHint that tells the transformation algorithm how determine the cardinality of a TargetSectionClass (how often the Class shall be instantiated) in the course of a transformation.
 * <br /><br />
 * The value is thereby determined based on one of two possibilities:
 * <br />
 * (1) Based on the list of specified 'sourceElements' and an optional (mathematical) 'expression'.
 * <br />
 * If the expression is not present, the values of all specified source elements are treated as Strings and simply concatenated.
 * <br />
 * If an expression is present, this will be used to calculate the value. The expression may thereby reference the (numeric) values of the specified source elements via their name. For example, if a source element named 'x' is specified, a valid expression to double the value of this element would be "2*x".
 * <br />
 * (1) Base on the cardinality of the specified 'source'.
 * <br /><br />
 * Note: Only one of 'sourceElements' or 'source' may be specified!
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.CardinalityMapping#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.extended.CardinalityMapping#getTarget <em>Target</em>}</li>
 *   <li>{@link pamtram.mapping.extended.CardinalityMapping#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.extended.ExtendedPackage#getCardinalityMapping()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceClassMatchesSection sourceClassIsVariableCardinality targetClassMatchesSection targetClassIsVariableCardinality noCardinalityMappingForSourceSectionRoot'"
 * @generated
 */
public interface CardinalityMapping extends MappingHint, ExpressionElement, ModifiableElement, MatchSpecElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The (optional) 'source' element whose cardinality is used to determine the cardinality of the 'target' Class.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(MetaModelElement)
	 * @see pamtram.mapping.extended.ExtendedPackage#getCardinalityMapping_Source()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescriptor='\r\nitemPropertyDescriptors\r\n\t\t.add(new ItemPropertyDescriptor(((&lt;%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%&gt;) adapterFactory).getRootAdapterFactory(),\r\n\t\t\t\tthis.getResourceLocator(), this.getString(\"_UI_CardinalityMapping_source_feature\"),\r\n\t\t\t\tthis.getString(\"_UI_CardinalityMapping_source_description\"),\r\n\t\t\t\t&lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.CARDINALITY_MAPPING__SOURCE, true, false, true, null,\r\n\t\t\t\tthis.getString(\"_UI_BasicPropertyCategory\"), null) {\r\n\r\n\t\t\t@SuppressWarnings(\"unchecked\")\r\n\t\t\t@Override\r\n\t\t\tpublic &lt;%java.util.Collection%&gt;&lt;?&gt; getChoiceOfValues(Object object) {\r\n\r\n\t\t\t\t// the parent mapping\r\n\t\t\t\t&lt;%pamtram.mapping.Mapping%&gt; mapping = null;\r\n\t\t\t\tif (((&lt;%pamtram.mapping.extended.CardinalityMapping%&gt;) object).eContainer() instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt;) {\r\n\t\t\t\t\tmapping = (Mapping) ((MappingHintGroupType) ((CardinalityMapping) object).eContainer())\r\n\t\t\t\t\t\t\t.eContainer();\r\n\t\t\t\t} else if (((CardinalityMapping) object).eContainer() instanceof &lt;%pamtram.mapping.MappingHintGroupImporter%&gt;) {\r\n\t\t\t\t\tmapping = (Mapping) ((MappingHintGroupImporter) ((CardinalityMapping) object).eContainer())\r\n\t\t\t\t\t\t\t.eContainer();\r\n\t\t\t\t}\r\n\r\n\t\t\t\tif (mapping == null) {\r\n\t\t\t\t\treturn &lt;%java.util.Collections%&gt;.emptyList();\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// the source section\r\n\t\t\t\t&lt;%pamtram.structure.source.SourceSectionClass%&gt; source = mapping.getSourceSection();\r\n\r\n\t\t\t\t&lt;%java.util.List%&gt;&lt;Object&gt; choiceOfValues = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\n\r\n\t\t\t\t// iterate over all elements and return the classes and\r\n\t\t\t\t// attributes\r\n\t\t\t\t// as possible options\r\n\t\t\t\t&lt;%java.util.Set%&gt;&lt;SourceSectionClass&gt; scanned = new &lt;%java.util.HashSet%&gt;&lt;&gt;();\r\n\t\t\t\tList&lt;SourceSectionClass&gt; sectionsToScan = new ArrayList&lt;&gt;();\r\n\t\t\t\tsectionsToScan.add(source);\r\n\r\n\t\t\t\twhile (!sectionsToScan.isEmpty()) {\r\n\t\t\t\t\tSourceSectionClass classToScan = sectionsToScan.remove(0);\r\n\t\t\t\t\tscanned.add(classToScan);\r\n\r\n\t\t\t\t\tif (!classToScan.getCardinality().equals(&lt;%pamtram.structure.generic.CardinalityType%&gt;.ONE)) {\r\n\t\t\t\t\t\tchoiceOfValues.add(classToScan);\r\n\t\t\t\t\t}\r\n\t\t\t\t\tchoiceOfValues.addAll(classToScan.getAttributes());\r\n\t\t\t\t\tchoiceOfValues.addAll(classToScan.getReferences());\r\n\r\n\t\t\t\t\t&lt;%java.util.Iterator%&gt;&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; it = classToScan.eAllContents();\r\n\t\t\t\t\twhile (it.hasNext()) {\r\n\t\t\t\t\t\tEObject next = it.next();\r\n\t\t\t\t\t\tif (next instanceof SourceSectionClass) {\r\n\t\t\t\t\t\t\tif (!((SourceSectionClass) next).getCardinality().equals(CardinalityType.ONE)) {\r\n\t\t\t\t\t\t\t\tchoiceOfValues.add(next);\r\n\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t\tchoiceOfValues.addAll(((SourceSectionClass) next).getAttributes());\r\n\t\t\t\t\t\t\tchoiceOfValues.addAll(((SourceSectionClass) next).getReferences());\r\n\t\t\t\t\t\t} else if (next instanceof &lt;%pamtram.structure.generic.CrossReference%&gt; &amp;&amp; next instanceof &lt;%pamtram.structure.source.SourceSectionReference%&gt;) {\r\n\t\t\t\t\t\t\tList&lt;SourceSectionClass&gt; vals = new ArrayList&lt;&gt;();\r\n\t\t\t\t\t\t\tvals.addAll(\r\n\t\t\t\t\t\t\t\t\t(Collection&lt;? extends SourceSectionClass&gt;) ((CrossReference&lt;?, ?, ?, ?&gt;) next)\r\n\t\t\t\t\t\t\t\t\t\t\t.getValue());\r\n\t\t\t\t\t\t\tvals.removeAll(scanned);\r\n\t\t\t\t\t\t\tsectionsToScan.addAll(vals);\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t\treturn choiceOfValues;\r\n\t\t\t}\r\n\t\t});'"
	 * @generated
	 */
	MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> getSource();

	/**
	 * Sets the value of the '{@link pamtram.mapping.extended.CardinalityMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TargetSectionClass whose cardinality is determined by this CardinalityMapping.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(TargetSectionClass)
	 * @see pamtram.mapping.extended.ExtendedPackage#getCardinalityMapping_Target()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescriptor='\r\nitemPropertyDescriptors\r\n\t\t.add(new ItemPropertyDescriptor(((&lt;%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%&gt;) adapterFactory).getRootAdapterFactory(),\r\n\t\t\t\tthis.getResourceLocator(), this.getString(\"_UI_CardinalityMapping_target_feature\"),\r\n\t\t\t\tthis.getString(\"_UI_CardinalityMapping_target_description\"),\r\n\t\t\t\t&lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.CARDINALITY_MAPPING__TARGET, true, false, true, null,\r\n\t\t\t\tthis.getString(\"_UI_BasicPropertyCategory\"), null) {\r\n\r\n\t\t\t@Override\r\n\t\t\tpublic &lt;%java.util.Collection%&gt;&lt;?&gt; getChoiceOfValues(Object object) {\r\n\r\n\t\t\t\t// the target section\r\n\t\t\t\t&lt;%pamtram.structure.target.TargetSection%&gt; target = null;\r\n\t\t\t\tif (((&lt;%pamtram.mapping.extended.CardinalityMapping%&gt;) object).eContainer() instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt;) {\r\n\t\t\t\t\ttarget = ((MappingHintGroupType) ((CardinalityMapping) object).eContainer())\r\n\t\t\t\t\t\t\t.getTargetSection();\r\n\t\t\t\t} else if (((CardinalityMapping) object).eContainer() instanceof &lt;%pamtram.mapping.MappingHintGroupImporter%&gt;) {\r\n\t\t\t\t\ttarget = ((MappingHintGroupImporter) ((CardinalityMapping) object).eContainer())\r\n\t\t\t\t\t\t\t.getHintGroup().getTargetSection();\r\n\t\t\t\t}\r\n\r\n\t\t\t\tif (target == null) {\r\n\t\t\t\t\treturn &lt;%java.util.Collections%&gt;.emptyList();\r\n\t\t\t\t}\r\n\r\n\t\t\t\t&lt;%java.util.List%&gt;&lt;Object&gt; choiceOfValues = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\n\r\n\t\t\t\t// is the target itself a possible option?\r\n\t\t\t\tif (target.getCardinality().getValue() != &lt;%pamtram.structure.generic.CardinalityType%&gt;.ONE_VALUE) {\r\n\t\t\t\t\tchoiceOfValues.add(target);\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// iterate over all elements and return the attributes\r\n\t\t\t\t// as\r\n\t\t\t\t// possible options\r\n\t\t\t\t&lt;%java.util.Iterator%&gt;&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; it = target.eAllContents();\r\n\t\t\t\twhile (it.hasNext()) {\r\n\t\t\t\t\tEObject next = it.next();\r\n\t\t\t\t\tif (next instanceof pamtram.structure.generic.Class\r\n\t\t\t\t\t\t\t&amp;&amp; ((pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;) next).getCardinality()\r\n\t\t\t\t\t\t\t\t\t.getValue() != CardinalityType.ONE_VALUE) {\r\n\t\t\t\t\t\tchoiceOfValues.add(next);\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t\treturn choiceOfValues;\r\n\t\t\t}\r\n\t\t});'"
	 * @generated
	 */
	TargetSectionClass getTarget();

	/**
	 * Sets the value of the '{@link pamtram.mapping.extended.CardinalityMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TargetSectionClass value);

	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.extended.CardinalityMappingSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The (optional) list of 'sourceElements' based on which the cardinality of the 'target' Class is determined.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Elements</em>' containment reference list.
	 * @see pamtram.mapping.extended.ExtendedPackage#getCardinalityMapping_SourceElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<CardinalityMappingSourceInterface> getSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (getSource() == null || !(eContainer().eContainer() instanceof &lt;%pamtram.mapping.Mapping%&gt;)\r\n\t\t|| ((Mapping) eContainer().eContainer()).getSourceSection() == null) {\r\n\treturn true;\r\n}\r\n\r\nMapping mapping = (Mapping) eContainer().eContainer();\r\n\r\nboolean result = false;\r\n\r\n&lt;%pamtram.structure.source.SourceSection%&gt; relevantClass = mapping.getSourceSection();\r\n\r\n// iterate over all elements and return the attributes as possible options\r\n//\r\n&lt;%java.util.Set%&gt;&lt;&lt;%pamtram.structure.source.SourceSectionClass%&gt;&gt; scanned = new &lt;%java.util.HashSet%&gt;&lt;&gt;();\r\n&lt;%java.util.List%&gt;&lt;SourceSectionClass&gt; sectionsToScan = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\nsectionsToScan.add(relevantClass);\r\n\r\n// also regard abstract sections that this extends\r\nif (relevantClass instanceof &lt;%pamtram.structure.generic.Section%&gt;) {\r\n\tsectionsToScan.addAll(relevantClass.getAllExtend());\r\n}\r\n\r\nwhile (!sectionsToScan.isEmpty()) {\r\n\tSourceSectionClass classToScan = sectionsToScan.remove(0);\r\n\tscanned.add(classToScan);\r\n\r\n\t&lt;%java.util.Iterator%&gt;&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; it = classToScan.eAllContents();\r\n\twhile (it.hasNext()) {\r\n\t\tEObject next = it.next();\r\n\t\tif (getSource().equals(next)) {\r\n\t\t\tresult = true;\r\n\t\t\tbreak;\r\n\t\t} else if (next instanceof &lt;%pamtram.structure.generic.CrossReference%&gt; &amp;&amp; next instanceof &lt;%pamtram.structure.source.SourceSectionReference%&gt;) {\r\n\t\t\tList&lt;SourceSectionClass&gt; vals = new ArrayList&lt;&gt;();\r\n\t\t\tvals.addAll(\r\n\t\t\t\t\t(&lt;%java.util.Collection%&gt;&lt;? extends SourceSectionClass&gt;) ((CrossReference&lt;?, ?, ?, ?&gt;) next).getValue());\r\n\t\t\tvals.removeAll(scanned);\r\n\t\t\tsectionsToScan.addAll(vals);\r\n\t\t}\r\n\t}\r\n}\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The source element \'\" + getSource().getName()\r\n\t\t\t+ \"\' is not part of the source section referenced by parent mapping \'\" + mapping.getName() + \"\'!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_SOURCE_ELEMENT_MATCHES_SECTION_OR_CONTAINED_SECTION,\r\n\t\t\terrorMessage, new Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.CARDINALITY_MAPPING__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceElementMatchesSectionOrContainedSection(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (getTarget() == null || !(eContainer() instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt;)\r\n\t\t|| ((MappingHintGroupType) eContainer()).getTargetSection() == null) {\r\n\treturn true;\r\n}\r\n\r\nMappingHintGroupType mappingHintGroup = (MappingHintGroupType) eContainer();\r\n\r\nboolean result = getTarget().getContainingSection() == mappingHintGroup.getTargetSection()\r\n\t\t|| mappingHintGroup.getAllExtend().stream().map(MappingHintGroupType::getTargetSection)\r\n\t\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toSet()).contains(getTarget().getContainingSection());\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The target class \'\" + getTarget().getName()\r\n\t\t\t+ \"\' is not part of the target section referenced by parent hint group \'\"\r\n\t\t\t+ mappingHintGroup.getName() + \"\'!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_TARGET_CLASS_MATCHES_SECTION, errorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.CARDINALITY_MAPPING__TARGET }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateTargetClassMatchesSection(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getSource() == null || !(this.getSource() instanceof SourceSectionClass) ? true : ((SourceSectionClass) this.getSource()).getCardinality() != CardinalityType.ONE;\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"Cardinality mappings may only be defined for source classes with a specified cardinality distinct from \'CardinalityType::ONE\'!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_SOURCE_CLASS_IS_VARIABLE_CARDINALITY,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.CARDINALITY_MAPPING__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceClassIsVariableCardinality(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getTarget() == null ? true : this.getTarget().getCardinality() != &lt;%pamtram.structure.generic.CardinalityType%&gt;.ONE;\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"Cardinality mappings may only be defined for target classes with a specified cardinality distinct from \'CardinalityType::ONE\'!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_TARGET_CLASS_IS_VARIABLE_CARDINALITY,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.CARDINALITY_MAPPING__TARGET }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateTargetClassIsVariableCardinality(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getSource() == null ? true : this.getSource() != this.getSource().getContainingSection();\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"Cardinality mappings must not be defined for SourceSection root classes!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.CARDINALITY_MAPPING__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateNoCardinalityMappingForSourceSectionRoot(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getSource() == null || this.getSourceElements() == null || this.getSourceElements().isEmpty();\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"A CardinalityMapping must not specify both a \'source\' and a set of \'sourceElements\'!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_ONLY_SOURCE_OR_SOURCE_ELEMENTS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.CARDINALITY_MAPPING }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateOnlySourceOrSourceElements(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = !this.getSourceElements().isEmpty() || this.expression.isEmpty();\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"A CardinalityMapping must only specify an \'expression\' if it also specifies a set of \'sourceElements\'!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_EXPRESSION_ONLY_FOR_SOURCE_ELEMENTS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.CARDINALITY_MAPPING }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateExpressionOnlyForSourceElements(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&gt;(this.getSourceElements().stream().filter(s -&gt; s instanceof CardinalityMappingSourceElement).map(s -&gt; (CardinalityMappingSourceElement) s).collect(&lt;%java.util.stream.Collectors%&gt;.toList()));'"
	 * @generated
	 */
	EList<CardinalityMappingSourceElement> getLocalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&gt;(this.getSourceElements().stream().filter(s -&gt; s instanceof CardinalityMappingExternalSourceElement).map(s -&gt; (CardinalityMappingExternalSourceElement) s).collect(&lt;%java.util.stream.Collectors%&gt;.toList()));'"
	 * @generated
	 */
	EList<CardinalityMappingExternalSourceElement> getExternalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n&lt;%pamtram.mapping.Mapping%&gt; mapping = (Mapping) &lt;%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%&gt;.getAncestorOfKind(this, &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING);\r\n\r\nif (this.source == null || mapping.getSourceSection() == null || !this.getReferenceMatchSpec().isEmpty()) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%pamtram.structure.source.SourceSection%&gt; sourceSection = mapping.getSourceSection();\r\n\r\nboolean result = true;\r\nString errorMessage = \"\";\r\n\r\nif (!this.isFollowExternalReferences() &amp;&amp; (!sourceSection.equals(this.source.getContainingSection())\r\n\t\t|| !sourceSection.getAllExtend().contains(this.source.getContainingSection()))) {\r\n\r\n\tresult = false;\r\n\terrorMessage = \"The source Attribute is not part of the SourceSection specified by this Mapping. This is not allowed unless \'followExternalReferences\' is set to \'true\'.\";\r\n\r\n}\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.WARNING, &lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_FOLLOW_EXTERNAL_REFERENCES_TRUE_IF_REQUIRED,\r\n\t\t\terrorMessage, new Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.CARDINALITY_MAPPING__SOURCE }));\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateFollowExternalReferencesTrueIfRequired(DiagnosticChain diagnostics, Map<?, ?> context);

} // CardinalityMapping
