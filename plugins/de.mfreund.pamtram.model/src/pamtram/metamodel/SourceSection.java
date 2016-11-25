/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import pamtram.mapping.MappingType;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.SourceSection#getReferencingMappings <em>Referencing Mappings</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSourceSection()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='isReferencedByMapping'"
 * @generated
 */
public interface SourceSection extends SourceSectionClass, Section<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {

	/**
	 * Returns the value of the '<em><b>Referencing Mappings</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referencing Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referencing Mappings</em>' reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSection_ReferencingMappings()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='\r\nList<<%pamtram.mapping.Mapping%>> mappings = new <%java.util.ArrayList%><>();\r\n\r\nif (this.eResource() != null) {\r\n\r\n\tmappings = this.eResource().getResourceSet().getResources().stream()\r\n\t\t\t.filter(r -> r.getContents().get(0) instanceof pamtram.PAMTraM)\r\n\t\t\t.flatMap(r -> ((pamtram.PAMTraM) r.getContents().get(0)).getMappings().parallelStream())\r\n\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\n}\r\n\r\nList<Mapping> referencingMappings = mappings.parallelStream().filter(m -> this.equals(m.getSourceSection())).collect(Collectors.toList());\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList.UnmodifiableEList%><>(this, <%pamtram.metamodel.MetamodelPackage%>.Literals.SOURCE_SECTION__REFERENCING_MAPPINGS,\r\n\t\treferencingMappings.size(), referencingMappings.toArray());'"
	 * @generated
	 */
	EList<MappingType> getReferencingMappings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = !this.getReferencingMappings().isEmpty();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The section is not referenced by any mapping!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.WARNING,\r\n\t\t\t<%pamtram.metamodel.util.MetamodelValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMetamodelValidator.SOURCE_SECTION__VALIDATE_IS_REFERENCED_BY_MAPPING,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.metamodel.MetamodelPackage%>.Literals.SOURCE_SECTION }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateIsReferencedByMapping(DiagnosticChain diagnostics, Map<?, ?> context);
} // SourceSection
