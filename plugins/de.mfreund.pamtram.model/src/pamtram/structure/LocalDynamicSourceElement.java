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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (this.getMapping() == null || this.source == null || this.getMapping().getSourceSection() == null\r\n\t\t|| !(this.source.getContainingSection() instanceof &lt;%pamtram.structure.source.SourceSection%&gt;)) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%pamtram.mapping.Mapping%&gt; mapping = this.getMapping();\r\nSourceSection sourceSection = this.getMapping().getSourceSection();\r\n\r\nboolean result = false;\r\n\r\npamtram.structure.generic.Class&lt;?, ?, ?, ?&gt; relevantClass = mapping.getSourceSection();\r\n\r\n// iterate over all elements and return the attributes as possible options\r\n//\r\n&lt;%java.util.Set%&gt;&lt;pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;&gt; scanned = new &lt;%java.util.HashSet%&gt;&lt;&gt;();\r\n&lt;%java.util.List%&gt;&lt;pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;&gt; sectionsToScan = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\nsectionsToScan.add(relevantClass);\r\n\r\n// also regard abstract sections that this extends\r\nif (relevantClass instanceof &lt;%pamtram.structure.generic.Section%&gt;) {\r\n\tsectionsToScan.addAll(((Section&lt;?, ?, ?, ?&gt;) relevantClass).getAllExtend());\r\n}\r\n\r\nwhile (!sectionsToScan.isEmpty()) {\r\n\tpamtram.structure.generic.Class&lt;?, ?, ?, ?&gt; classToScan = sectionsToScan.remove(0);\r\n\tscanned.add(classToScan);\r\n\r\n\t&lt;%java.util.Iterator%&gt;&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; it = classToScan.eAllContents();\r\n\twhile (it.hasNext()) {\r\n\t\tEObject next = it.next();\r\n\t\tif (next instanceof pamtram.structure.generic.Attribute &amp;&amp; next.equals(this.source)) {\r\n\t\t\tresult = true;\r\n\t\t\tbreak;\r\n\t\t} else if (next instanceof &lt;%pamtram.structure.generic.CrossReference%&gt;) {\r\n\t\t\tList&lt;&lt;%pamtram.structure.source.SourceSectionClass%&gt;&gt; vals = new ArrayList&lt;&gt;();\r\n\t\t\tvals.addAll(((CrossReference) next).getValue());\r\n\t\t\tvals.removeAll(scanned);\r\n\t\t\tsectionsToScan.addAll(vals);\r\n\t\t}\r\n\t}\r\n}\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The source attribute \'\" + this.source.getName()\r\n\t\t\t+ \"\' is not referenced by the source section of the parent mapping \'\" + sourceSection.getName()\r\n\t\t\t+ \"\' or in one of its extended sections/sub-sections!\'\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.structure.util.StructureValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tStructureValidator.LOCAL_DYNAMIC_SOURCE_ELEMENT__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION,\r\n\t\t\terrorMessage, new Object[] { this, &lt;%pamtram.structure.StructurePackage%&gt;.Literals.DYNAMIC_SOURCE_ELEMENT__SOURCE }));\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceAttributeMatchesSectionOrContainedSection(DiagnosticChain diagnostics, Map<?, ?> context);
} // LocalDynamicSourceElement
