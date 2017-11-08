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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.getMapping() == null || this.source == null || this.getMapping().getSourceSection() == null\r\n\t\t\t\t|| !(this.source.getContainingSection() instanceof &lt;%pamtram.structure.source.SourceSection%&gt;)) {\r\n\treturn true;\r\n}\r\n\r\nSourceSection sourceSection = this.getMapping().getSourceSection();\r\nSourceSection containingSourceSection = (SourceSection) this.source.getContainingSection();\r\n\r\nboolean result = sourceSection == containingSourceSection \r\n\t\t|| sourceSection.getExtend().parallelStream().filter(e -&gt; e.equals(containingSourceSection)).findAny().isPresent()\r\n\t\t|| sourceSection.getExtend().parallelStream().filter(e -&gt; containingSourceSection.isReferencedBy(e, null)).findAny().isPresent()\r\n\t\t|| containingSourceSection.isReferencedBy(sourceSection, null);\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\t\r\n\tString errorMessage = \"The source attribute \'\" +\r\n\t\t\t this.source.getName() + \"\' is not referenced by the source section of the parent mapping \'\" +\r\n\t\t\t sourceSection.getName() + \"\' or in one of its extended sections/sub-sections!\'\";\r\n\t\r\n\tdiagnostics.add\r\n\t\t(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t &lt;%pamtram.structure.util.StructureValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t StructureValidator.LOCAL_DYNAMIC_SOURCE_ELEMENT__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION,\r\n\t\t\t errorMessage,\r\n\t\t\t new Object [] { this, &lt;%pamtram.structure.StructurePackage%&gt;.Literals.DYNAMIC_SOURCE_ELEMENT__SOURCE }));\r\n\t}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceAttributeMatchesSectionOrContainedSection(DiagnosticChain diagnostics, Map<?, ?> context);
} // LocalDynamicSourceElement
