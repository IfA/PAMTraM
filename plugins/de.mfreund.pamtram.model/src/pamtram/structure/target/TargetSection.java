/**
 */
package pamtram.structure.target;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import pamtram.mapping.MappingHintGroupType;
import pamtram.structure.generic.Section;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A special TargetSectionClass that represents the root element (as an instance of an EClass) of an element structure to be created in a target model.
 * <br />
 * Note: Every specified target model structure must contain one and only one TargetSection element (its root element).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.target.TargetSection#getReferencingMappingHintGroups <em>Referencing Mapping Hint Groups</em>}</li>
 *   <li>{@link pamtram.structure.target.TargetSection#getFile <em>File</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.target.TargetPackage#getTargetSection()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='isReferencedByMappingHintGroup'"
 * @generated
 */
public interface TargetSection extends TargetSectionClass, Section<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute> {

	/**
	 * Returns the value of the '<em><b>Referencing Mapping Hint Groups</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHintGroupType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referencing Mapping Hint Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referencing Mapping Hint Groups</em>' reference list.
	 * @see pamtram.structure.target.TargetPackage#getTargetSection_ReferencingMappingHintGroups()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='\r\nList<<%pamtram.mapping.Mapping%>> mappings = new <%java.util.ArrayList%><>();\r\n\r\nif (this.eResource() != null) {\r\n\r\n\tmappings = this.eResource().getResourceSet().getResources().stream()\r\n\t\t\t.filter(r -> r.getContents().get(0) instanceof pamtram.PAMTraM)\r\n\t\t\t.flatMap(r -> ((pamtram.PAMTraM) r.getContents().get(0)).getMappings().stream())\r\n\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\n}\r\n\r\nList<MappingHintGroupType> referencingHintGroups = mappings.stream().flatMap(m -> m.getMappingHintGroups().stream()).filter(m -> this.equals(m.getTargetSection())).collect(Collectors.toList());\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList.UnmodifiableEList%><>(this, <%pamtram.structure.target.TargetPackage%>.Literals.TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS,\r\n\t\treferencingHintGroups.size(), referencingHintGroups.toArray());'"
	 * @generated
	 */
	EList<MappingHintGroupType> getReferencingMappingHintGroups();

	/**
	 * Returns the value of the '<em><b>File</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If present, this specifies the model resp. file to which the created target model structure will be persisted.
	 * <br /><br />
	 * This can be used to statically or dynamically specify the target models/model files to be created in the course of a transformation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>File</em>' reference.
	 * @see #setFile(FileAttribute)
	 * @see pamtram.structure.target.TargetPackage#getTargetSection_File()
	 * @model
	 * @generated
	 */
	FileAttribute getFile();

	/**
	 * Sets the value of the '{@link pamtram.structure.target.TargetSection#getFile <em>File</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' reference.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(FileAttribute value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = !this.getReferencingMappingHintGroups().isEmpty();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The section is not referenced by any hint group and will not be instantiated!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.WARNING,\r\n\t\t\t<%pamtram.structure.target.util.TargetValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tTargetValidator.TARGET_SECTION__VALIDATE_IS_REFERENCED_BY_MAPPING_HINT_GROUP,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.target.TargetPackage%>.Literals.TARGET_SECTION }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateIsReferencedByMappingHintGroup(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean result = this.getCardinality() != <%pamtram.structure.generic.CardinalityType%>.ONE;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The cardinality of this section is currently set to \'ONE\'. Consider changing the cardinality if you want to allow that multiple instances of this section are created based on a mapping!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.WARNING,\r\n\t\t\t<%pamtram.structure.target.util.TargetValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tTargetValidator.TARGET_SECTION__VALIDATE_CARDINALITY,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.target.TargetPackage%>.Literals.TARGET_SECTION }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateCardinality(DiagnosticChain diagnostics, Map<?, ?> context);
} // TargetSection
