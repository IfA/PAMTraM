/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;

import pamtram.structure.Attribute;
import pamtram.structure.Reference;
import pamtram.structure.Section;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getExternalModifiedAttributeElementType()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceAttributeMatchesContainerSection'"
 * @generated
 */
public interface ExternalModifiedAttributeElementType<S extends Section<S, C, R, A>, C extends pamtram.structure.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ModifiedAttributeElementType<S, C, R, A> {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.getMapping() == null || this.getSource() == null) {\r\n\treturn true;\r\n}\r\n\r\n<%pamtram.structure.SourceSection%> sourceSection = this.getMapping().getSourceSection();\r\n\r\nboolean result = sourceSection == null || !(this.getSource().getContainingSection() instanceof SourceSection) ? true : ((SourceSection) this.getSource().getContainingSection()).isContainerFor(sourceSection);\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The source attribute \'\" + this.getSource().getName() + \"\' is not part of a container section of the source section of the parent mapping \'\" + this.getMapping().getSourceSection().getName() + \"\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceAttributeMatchesContainerSection(DiagnosticChain diagnostics, Map<?, ?> context);
} // ExternalModifiedAttributeElementType
