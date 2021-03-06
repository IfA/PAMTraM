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

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.MatchSpecElement;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A LocalDynamicSourceElement represents a certain value that can be used in various calculations.
 * <br /><br />
 * The dynamic value is thereby calculated based on the value of an attribute of a SourceSection (resp. the matched source model excerpt(s)) that is specified via the 'source' reference. As multiple source model excerpts can be matched against a single SourceSection (and thus against a single SourceSectionAttribute), a DynamicSourceElement may actually deliver many values that will be used by the calculation.
 * <br /><br />
 * For 'LocalDynamicSourceElements', only instances of the specified 'source' attribute that are part of the source model excerpt which is currently handled by the transformation are used.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.structure.StructurePackage#getLocalDynamicSourceElement()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceAttributeMatchesSectionOrContainedSection'"
 * @generated
 */
public interface LocalDynamicSourceElement<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends DynamicSourceElement<S, C, R, A>, MatchSpecElement<S, C, R, A> {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (this.getMapping() == null || this.source == null || this.getMapping().getSourceSection() == null\r\n\t\t|| !(this.source.getContainingSection() instanceof &lt;%pamtram.structure.source.SourceSection%&gt;)) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%pamtram.mapping.Mapping%&gt; mapping = this.getMapping();\r\nSourceSection sourceSection = this.getMapping().getSourceSection();\r\n\r\nboolean result = false;\r\n\r\npamtram.structure.generic.Class&lt;?, ?, ?, ?&gt; relevantClass = mapping.getSourceSection();\r\n\r\n// iterate over all elements and return the attributes as possible options\r\n//\r\n&lt;%java.util.Set%&gt;&lt;pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;&gt; scanned = new &lt;%java.util.HashSet%&gt;&lt;&gt;();\r\n&lt;%java.util.List%&gt;&lt;pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;&gt; sectionsToScan = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\nsectionsToScan.add(relevantClass);\r\n\r\n// also regard abstract sections that this extends\r\nif (relevantClass instanceof &lt;%pamtram.structure.generic.Section%&gt;) {\r\n\tsectionsToScan.addAll(((Section&lt;?, ?, ?, ?&gt;) relevantClass).getAllExtend());\r\n}\r\n\r\nwhile (!sectionsToScan.isEmpty()) {\r\n\tpamtram.structure.generic.Class&lt;?, ?, ?, ?&gt; classToScan = sectionsToScan.remove(0);\r\n\tscanned.add(classToScan);\r\n\r\n\t&lt;%java.util.Iterator%&gt;&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; it = classToScan.eAllContents();\r\n\twhile (it.hasNext()) {\r\n\t\tEObject next = it.next();\r\n\t\tif (next instanceof pamtram.structure.generic.Attribute &amp;&amp; next.equals(this.source)) {\r\n\t\t\tresult = true;\r\n\t\t\tbreak;\r\n\t\t} else if (next instanceof pamtram.structure.generic.CrossReference&lt;?, ?, ?, ?&gt;) {\r\n\t\t\tList&lt;&lt;%pamtram.structure.source.SourceSectionClass%&gt;&gt; vals = new ArrayList&lt;&gt;();\r\n\t\t\tList&lt;pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;&gt; values = new ArrayList&lt;&gt;(\r\n\t\t\t\t\t((pamtram.structure.generic.CrossReference&lt;?, ?, ?, ?&gt;) next).getValue());\r\n\t\t\tvals.addAll((&lt;%java.util.Collection%&gt;&lt;? extends SourceSectionClass&gt;) values);\r\n\t\t\tvals.addAll(values.stream().filter(c -&gt; c instanceof SourceSection)\r\n\t\t\t\t\t.flatMap(c -&gt; ((SourceSection) c).getAllExtend().stream()).collect(&lt;%java.util.stream.Collectors%&gt;.toList()));\r\n\t\t\tvals.removeAll(scanned);\r\n\t\t\tsectionsToScan.addAll(vals);\r\n\t\t}\r\n\t}\r\n}\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The source attribute \'\" + this.source.getName()\r\n\t\t\t+ \"\' is not referenced by the source section of the parent mapping \'\" + sourceSection.getName()\r\n\t\t\t+ \"\' or in one of its extended sections/sub-sections!\'\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.structure.util.StructureValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tStructureValidator.LOCAL_DYNAMIC_SOURCE_ELEMENT__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION,\r\n\t\t\terrorMessage, new Object[] { this, &lt;%pamtram.structure.StructurePackage%&gt;.Literals.DYNAMIC_SOURCE_ELEMENT__SOURCE }));\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceAttributeMatchesSectionOrContainedSection(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (this.source == null || this.getMapping().getSourceSection() == null || this.followExternalReferences) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%pamtram.structure.source.SourceSection%&gt; sourceSection = this.getMapping().getSourceSection();\r\n\r\nboolean isExternalSourceElement = !sourceSection.equals(this.source.getContainingSection())\r\n\t\t&amp;&amp; !sourceSection.getAllExtend().contains(this.source.getContainingSection());\r\n\r\nboolean result = true;\r\nString errorMessage = \"\";\r\nint severity = &lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.OK;\r\n\r\nif (isExternalSourceElement) {\r\n\r\n\tresult = false;\r\n\tseverity = Diagnostic.ERROR;\r\n\terrorMessage = \"The source &lt;%pamtram.structure.generic.Attribute%&gt; is not part of the SourceSection specified by this &lt;%pamtram.mapping.Mapping%&gt;. This is not allowed unless \'followExternalReferences\' is set to \'true\'.\";\r\n\r\n} else if (this.getReferenceMatchSpec().parallelStream()\r\n\t\t.anyMatch(r -&gt; r instanceof pamtram.structure.generic.CrossReference&lt;?, ?, ?, ?&gt;)) {\r\n\r\n\tresult = false;\r\n\tseverity = Diagnostic.ERROR;\r\n\terrorMessage = \"The specified &lt;%pamtram.structure.generic.Reference%&gt; Match Spec contains Cross References. This is not allowed unless \'followExternalReferences\' is set to \'true\'.\";\r\n\r\n}\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(severity, &lt;%pamtram.structure.util.StructureValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tStructureValidator.LOCAL_DYNAMIC_SOURCE_ELEMENT__VALIDATE_FOLLOW_EXTERNAL_REFERENCES_TRUE_IF_REQUIRED,\r\n\t\t\terrorMessage, new Object[] { this, &lt;%pamtram.structure.StructurePackage%&gt;.Literals.DYNAMIC_SOURCE_ELEMENT__SOURCE }));\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateFollowExternalReferencesTrueIfRequired(DiagnosticChain diagnostics, Map<?, ?> context);
} // LocalDynamicSourceElement
