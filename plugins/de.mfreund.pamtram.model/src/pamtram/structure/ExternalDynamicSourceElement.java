/**
 */
package pamtram.structure;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An ExternalDynamicSourceElement represents a certain value that can be used in various calculations.
 * <br /><br />
 * The dynamic value is thereby calculated based on the value of an attribute of a SourceSection (resp. the matched source model excerpt(s)) that is specified via the 'source' reference. As multiple source model excerpts can be matched against a single SourceSection (and thus against a single SourceSectionAttribute), a DynamicSourceElement may actually deliver many values that will be used by the calculation.
 * <br /><br />
 * For 'ExternalDynamicSourceElements', only instances of the specified 'source' attribute that are part of source model excerpts that are containers of the source model excerpt which is currently handled by the transformation are used.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.structure.StructurePackage#getExternalDynamicSourceElement()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceAttributeMatchesContainerSection'"
 * @generated
 */
public interface ExternalDynamicSourceElement<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends DynamicSourceElement<S, C, R, A> {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this.getMapping() == null || this.source == null || this.getMapping().getSourceSection() == null\r\n\t\t\t\t|| !(this.source.getContainingSection() instanceof &lt;%pamtram.structure.source.SourceSection%&gt;)) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\t&lt;%pamtram.structure.source.SourceSection%&gt; sourceSection = this.getMapping().getSourceSection();\r\n\t\t&lt;%pamtram.structure.source.SourceSection%&gt; containingSection = (&lt;%pamtram.structure.source.SourceSection%&gt;) this.getSource().getContainingSection();\r\n\r\tboolean result = containingSection.isContainerFor(sourceSection);\r\n\r\tif (!result &amp;&amp; diagnostics != null) {\r\n\r\t\tString errorMessage = \"The source attribute \'\" + this.getSource().getName()\r\n\t\t\t\t\t+ \"\' is not part of a container section of the source section of the parent mapping \'\"\r\n\t\t\t\t\t+ this.getMapping().getSourceSection().getName() + \"\'!\";\r\n\r\t\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.structure.util.StructureValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%pamtram.structure.util.StructureValidator%&gt;.EXTERNAL_DYNAMIC_SOURCE_ELEMENT__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION,\r\n\t\t\t\t\terrorMessage, new Object[] { this, &lt;%pamtram.structure.StructurePackage%&gt;.Literals.DYNAMIC_SOURCE_ELEMENT__SOURCE }));\r\n\r\t}\r\n\r\treturn result;'"
	 * @generated
	 */
	boolean validateSourceAttributeMatchesContainerSection(DiagnosticChain diagnostics, Map<?, ?> context);
} // ExternalDynamicSourceElement
