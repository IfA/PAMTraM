/**
 */
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import pamtram.NamedElement;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.target.TargetSection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hint Group Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getTargetSection <em>Target Section</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getMappingHints <em>Mapping Hints</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getExtend <em>Extend</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getAttributeMappings <em>Attribute Mappings</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getCardinalityMappings <em>Cardinality Mappings</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getReferenceTargetSelectors <em>Reference Target Selectors</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getContainerSelectors <em>Container Selectors</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType()
 * @model abstract="true"
 * @generated
 */
public interface MappingHintGroupType extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Target Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target MM Section</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Section</em>' reference.
	 * @see #setTargetSection(TargetSection)
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_TargetSection()
	 * @model required="true"
	 * @generated
	 */
	TargetSection getTargetSection();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingHintGroupType#getTargetSection <em>Target Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Section</em>' reference.
	 * @see #getTargetSection()
	 * @generated
	 */
	void setTargetSection(TargetSection value);

	/**
	 * Returns the value of the '<em><b>Mapping Hints</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.extended.MappingHint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Hints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Hints</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_MappingHints()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingHint> getMappingHints();

	/**
	 * Returns the value of the '<em><b>Extend</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHintGroupType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extend</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extend</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_Extend()
	 * @model
	 * @generated
	 */
	EList<MappingHintGroupType> getExtend();

	/**
	 * Returns the value of the '<em><b>Attribute Mappings</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.extended.AttributeMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Mappings</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_AttributeMappings()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><<%pamtram.mapping.extended.AttributeMapping%>> attributeMappings = this.getMappingHints().stream()\r\n\t\t\t\t.filter(hint -> hint instanceof AttributeMapping).map(hint -> (AttributeMapping) hint)\r\n\t\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__ATTRIBUTE_MAPPINGS,\r\n\t\tattributeMappings.size(),attributeMappings.toArray());\r\n'"
	 * @generated
	 */
	EList<AttributeMapping> getAttributeMappings();

	/**
	 * Returns the value of the '<em><b>Cardinality Mappings</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.extended.CardinalityMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality Mappings</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_CardinalityMappings()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><<%pamtram.mapping.extended.CardinalityMapping%>> cardinalityMappings = this.getMappingHints().stream()\r\n\t\t\t\t.filter(hint -> hint instanceof CardinalityMapping).map(hint -> (CardinalityMapping) hint)\r\n\t\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__CARDINALITY_MAPPINGS,\r\n\t\tcardinalityMappings.size(),cardinalityMappings.toArray());\r\n'"
	 * @generated
	 */
	EList<CardinalityMapping> getCardinalityMappings();

	/**
	 * Returns the value of the '<em><b>Reference Target Selectors</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.extended.ReferenceTargetSelector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Target Selectors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Target Selectors</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_ReferenceTargetSelectors()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><<%pamtram.mapping.extended.ReferenceTargetSelector%>> referenceTargetSelectors = this.getMappingHints().stream()\r\n\t\t\t\t.filter(hint -> hint instanceof ReferenceTargetSelector).map(hint -> (ReferenceTargetSelector) hint)\r\n\t\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__REFERENCE_TARGET_SELECTORS,\r\n\t\treferenceTargetSelectors.size(),referenceTargetSelectors.toArray());\r\n'"
	 * @generated
	 */
	EList<ReferenceTargetSelector> getReferenceTargetSelectors();

	/**
	 * Returns the value of the '<em><b>Container Selectors</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.extended.ContainerSelector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Selectors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Selectors</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_ContainerSelectors()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><<%pamtram.mapping.extended.ContainerSelector%>> containerSelectors = this.getMappingHints().stream()\r\n\t\t\t\t.filter(hint -> hint instanceof ContainerSelector).map(hint -> (ContainerSelector) hint)\r\n\t\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__CONTAINER_SELECTORS,\r\n\t\tcontainerSelectors.size(),containerSelectors.toArray());\r\n'"
	 * @generated
	 */
	EList<ContainerSelector> getContainerSelectors();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n<%pamtram.structure.source.SourceSection%> sourceSection = ((<%pamtram.mapping.Mapping%>) this.eContainer()).getSourceSection();\r\n\r\nif (sourceSection == null) {\r\n\treturn true;\r\n}\r\n\r\n<%java.util.List%><SourceSection> validExtends = new <%java.util.ArrayList%><>();\r\nvalidExtends.add(sourceSection);\r\nvalidExtends.addAll(sourceSection.getAllExtend());\r\n\r\n<%java.util.Optional%><MappingHintGroupType> result = this.getExtend().stream()\r\n\t\t.filter(hg -> !validExtends.contains(((Mapping) hg.eContainer()).getSourceSection())).findFirst();\r\n\r\nif (result.isPresent() && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The MappingHintGroup \'\" + result.get().getName() + \"\' may not be extended by this MappingHintGroup because the referenced SourceSections are not compatible!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.MAPPING_HINT_GROUP_TYPE__VALIDATE_EXTENDS_ONLY_VALID_HINT_GROUPS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__EXTEND }));\r\n\r\n}\r\n\r\nreturn !result.isPresent();'"
	 * @generated
	 */
	boolean validateExtendsOnlyValidHintGroups(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Object[] hints = getMappingHints().stream().filter(h -> !h.isDeactivated()).toArray();\r\nreturn new <%org.eclipse.emf.common.util.BasicEList%>.UnmodifiableEList<>(hints.length, hints);'"
	 * @generated
	 */
	EList<MappingHint> getActiveMappingHints();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (!this.getTargetSection().isLibraryEntry()) {\r\n\treturn true;\r\n}\r\n\r\n// Check if the \'PAMTraM Library Nature\' is set for the project\r\n//\r\n<%org.eclipse.core.resources.IFile%> file = <%de.tud.et.ifa.agtele.resources.ResourceHelper%>.getFileForResource(this.eResource());\r\nif (file == null || file.getProject() == null) {\r\n\treturn true;\r\n}\r\n\r\nString errorMessage = \"The \'PAMTraM Library Nature\' is not activated for this project. Thus, LibraryEntries may not be used as TargetSections! You can activate the nature in the project properties...\";\r\n\r\ntry {\r\n\tif (!Boolean.parseBoolean(<%de.mfreund.pamtram.properties.PropertySupplier%>.getResourceProperty(<%de.mfreund.pamtram.properties.PropertySupplier%>.PROP_HAS_LIBRARY_NATURE,\r\n\t\t\tfile.getProject()))) {\r\n\t\tif (diagnostics != null) {\r\n\t\t\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.mapping.util.MappingValidator%>.MAPPING_HINT_GROUP_TYPE__VALIDATE_DO_NOT_USE_LIBRARY_ELEMENTS_WITHOUT_LIBRARY_NATURE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION }));\r\n\t\t}\r\n\t\treturn false;\r\n\t}\r\n} catch (<%org.eclipse.core.runtime.CoreException%> e) {\r\n\te.printStackTrace();\r\n}\r\nreturn true;'"
	 * @generated
	 */
	boolean validateDoNotUseLibraryElementsWithoutLibraryNature(DiagnosticChain diagnostics, Map<?, ?> context);

} // MappingHintGroupType
