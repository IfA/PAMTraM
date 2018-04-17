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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Object[] hintGroups = getMappingHintGroups().stream().filter(h -&gt; !(h instanceof InstantiableMappingHintGroup) ||  !((InstantiableMappingHintGroup) h).isDeactivated()).toArray();\r\nreturn new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;.UnmodifiableEList&lt;&gt;(hintGroups.length, hintGroups);'"
	 * @generated
	 */
	EList<MappingHintGroupType> getActiveMappingHintGroups();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Object[] importedHintGroups = getImportedMappingHintGroups().stream().filter(h -&gt; !h.isDeactivated()).toArray();\r\nreturn new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;.UnmodifiableEList&lt;&gt;(importedHintGroups.length, importedHintGroups);'"
	 * @generated
	 */
	EList<MappingHintGroupImporter> getActiveImportedMappingHintGroups();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = !this.getMappingHintGroups().isEmpty();\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The mapping does not contain any hint groups!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.WARNING,\r\n\t\t\t&lt;%pamtram.mapping.util.MappingValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.MAPPING__VALIDATE_CONTAINS_HINT_GROUPS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateContainsHintGroups(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.isDeactivated() ? this.getMappingHintGroups().size() == this.getActiveMappingHintGroups().size() &amp;&amp; this.getImportedMappingHintGroups().size() == this.getActiveImportedMappingHintGroups().size() : true;\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The mapping contains deactivated hint groups that will not be used in a transformation!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.WARNING,\r\n\t\t\t&lt;%pamtram.mapping.util.MappingValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.MAPPING__VALIDATE_CONTAINS_DEACTIVATED_HINT_GROUPS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateContainsDeactivatedHintGroups(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getSourceSection() == null || !this.getSourceSection().isDeactivated();\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The mapping is based on a deactivated SourceSection and will not be used in a transformation!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.WARNING,\r\n\t\t\t&lt;%pamtram.mapping.util.MappingValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.MAPPING__VALIDATE_SOURCE_SECTION_IS_ACTIVE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceSectionIsActive(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean result = this.getSourceSection() == null || this.isAbstract() || !this.getSourceSection().isAbstract();\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"Only abstract Mappings may reference abstract SourceSections!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.mapping.util.MappingValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%pamtram.mapping.util.MappingValidator%&gt;.MAPPING__VALIDATE_SOURCE_SECTION_IS_NOT_ABSTRACT,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING_TYPE__SOURCE_SECTION }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceSectionIsNotAbstract(DiagnosticChain diagnostics, Map<?, ?> context);

} // Mapping
