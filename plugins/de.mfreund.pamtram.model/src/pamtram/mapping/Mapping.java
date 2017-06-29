/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import pamtram.ConditionalElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Mapping between a SourceSection and one or multiple TargetSections.
 * <br /><br />
 * This Mapping will be executed/applied if the specified SourceSection is matched in the source model. If the SourceSection is matched multiple times, this Mapping will also be executed multiple times.
 * Each execution of the Mapping will result in the instantiation of each specified TargetSection.
 * <br /><br />
 * Note: Each TargetSection to be instantiated is specified via its own MappingHintGroup that can be created as child of the Mapping.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.Mapping#getMappingHintGroups <em>Mapping Hint Groups</em>}</li>
 *   <li>{@link pamtram.mapping.Mapping#getImportedMappingHintGroups <em>Imported Mapping Hint Groups</em>}</li>
 *   <li>{@link pamtram.mapping.Mapping#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getMapping()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='containsHintGroups containsDeactivatedHintGroups'"
 * @generated
 */
public interface Mapping extends MappingType, ConditionalElement {
	/**
	 * Returns the value of the '<em><b>Mapping Hint Groups</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHintGroupType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Hint Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of MappingHintGroups specifying the TargetSections to be instantiated when the Mapping is executed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mapping Hint Groups</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getMapping_MappingHintGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingHintGroupType> getMappingHintGroups();

	/**
	 * Returns the value of the '<em><b>Imported Mapping Hint Groups</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHintGroupImporter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Mapping Hint Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of MappingHintGroupImporters specifying imported MappingHintGroups whose TargetSections shall be instantiated when the Mapping is executed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Imported Mapping Hint Groups</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getMapping_ImportedMappingHintGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingHintGroupImporter> getImportedMappingHintGroups();

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a Mapping is marked as 'abstract', it will not be executed directly. However, the MappingHintGroups contained in other Mappings may extend the MappingHintGroups defined in an abstract Mapping.
	 * <br />
	 * Consequently, abstract Mappings can be used to define some kind of template mappings that can be reqused by other (non-abstract) Mappings.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see pamtram.mapping.MappingPackage#getMapping_Abstract()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link pamtram.mapping.Mapping#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Object[] hintGroups = getMappingHintGroups().stream().filter(h -> !(h instanceof InstantiableMappingHintGroup) ||  !((InstantiableMappingHintGroup) h).isDeactivated()).toArray();\r\nreturn new <%org.eclipse.emf.common.util.BasicEList%>.UnmodifiableEList<>(hintGroups.length, hintGroups);'"
	 * @generated
	 */
	EList<MappingHintGroupType> getActiveMappingHintGroups();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Object[] importedHintGroups = getImportedMappingHintGroups().stream().filter(h -> !h.isDeactivated()).toArray();\r\nreturn new <%org.eclipse.emf.common.util.BasicEList%>.UnmodifiableEList<>(importedHintGroups.length, importedHintGroups);'"
	 * @generated
	 */
	EList<MappingHintGroupImporter> getActiveImportedMappingHintGroups();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = !this.getMappingHintGroups().isEmpty();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The mapping does not contain any hint groups!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.WARNING,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.MAPPING__VALIDATE_CONTAINS_HINT_GROUPS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateContainsHintGroups(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.isDeactivated() ? this.getMappingHintGroups().size() == this.getActiveMappingHintGroups().size() && this.getImportedMappingHintGroups().size() == this.getActiveImportedMappingHintGroups().size() : true;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The mapping contains deactivated hint groups that will not be used in a transformation!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.WARNING,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.MAPPING__VALIDATE_CONTAINS_DEACTIVATED_HINT_GROUPS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateContainsDeactivatedHintGroups(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getSourceSection() == null || !this.getSourceSection().isDeactivated();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The mapping is based on a deactivated SourceSection and will not be used in a transformation!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.WARNING,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.MAPPING__VALIDATE_SOURCE_SECTION_IS_ACTIVE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceSectionIsActive(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean result = !this.isAbstract() || this.getLocalCondition() == null && this.getSharedCondition() == null;\r\n\r\tif (!result && diagnostics != null) {\r\n\r\t\tString errorMessage = \"Conditions are not supported for abstract Mappings! Consider moving the condition to the contained MappingHintGroup(s).\";\r\n\r\t\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.mapping.util.MappingValidator%>.MAPPING__VALIDATE_NO_CONDITION_FOR_ABSTRACT_MAPPING, errorMessage,\r\n\t\t\t\t\tnew Object[] { this,\r\n\t\t\t\t\t\t\tthis.getLocalCondition() != null\r\n\t\t\t\t\t\t\t\t\t? <%pamtram.PamtramPackage%>.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION\r\n\t\t\t\t\t\t\t\t\t: <%pamtram.PamtramPackage%>.Literals.CONDITIONAL_ELEMENT__SHARED_CONDITION }));\r\n\t\t}\r\n\r\treturn result;'"
	 * @generated
	 */
	boolean validateNoConditionForAbstractMapping(DiagnosticChain diagnostics, Map<?, ?> context);

} // Mapping
