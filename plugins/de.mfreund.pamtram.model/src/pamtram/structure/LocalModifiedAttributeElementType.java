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
 * A representation of the model object '<em><b>Local Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.structure.StructurePackage#getLocalModifiedAttributeElementType()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceAttributeMatchesSectionOrContainedSection'"
 * @generated
 */
public interface LocalModifiedAttributeElementType<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ModifiedAttributeElementType<S, C, R, A> {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.getMapping() == null || this.source == null || this.getMapping().getSourceSection() == null\r\n\t\t\t\t|| !(this.source.getContainingSection() instanceof <%pamtram.structure.source.SourceSection%>)) {\r\n\treturn true;\r\n}\r\n\r\nSourceSection sourceSection = this.getMapping().getSourceSection();\r\nSourceSection containingSourceSection = (SourceSection) this.source.getContainingSection();\r\n\r\nboolean result = sourceSection == containingSourceSection \r\n\t\t|| containingSourceSection.isReferencedBy(sourceSection, null)\r\n\t\t|| sourceSection.getExtend().parallelStream().filter(e -> e.equals(containingSourceSection)).findAny().isPresent()\r\n\t\t|| sourceSection.getExtend().parallelStream().filter(e -> containingSourceSection.isReferencedBy(e, null)).findAny().isPresent();\r\n\r\nif (!result && diagnostics != null) {\r\n\t\r\n\tString errorMessage = \"The source attribute \'\" +\r\n\t\t\t this.source.getName() + \"\' is not referenced by the source section of the parent mapping \'\" +\r\n\t\t\t sourceSection.getName() + \"\' or in one of its extended sections/sub-sections!\'\";\r\n\t\r\n\tdiagnostics.add\r\n\t\t(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t <%pamtram.structure.util.StructureValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t StructureValidator.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION,\r\n\t\t\t errorMessage,\r\n\t\t\t new Object [] { this, <%pamtram.structure.StructurePackage%>.Literals.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE }));\r\n\t}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceAttributeMatchesSectionOrContainedSection(DiagnosticChain diagnostics, Map<?, ?> context);
} // LocalModifiedAttributeElementType
