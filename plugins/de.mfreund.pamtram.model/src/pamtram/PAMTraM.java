/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import pamtram.mapping.GlobalAttribute;
import pamtram.structure.source.SourceSection;
import pamtram.structure.target.TargetSection;
import pamtram.mapping.Mapping;
import pamtram.mapping.modifier.ValueModifierSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PAM Tra M</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The root element of a PAMTraM model. It mainly acts as container for the various sub-models that are used to define Source- and TargetSections, Mappings, and Conditions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.PAMTraM#getSourceSectionModels <em>Source Section Models</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getSharedSourceSectionModels <em>Shared Source Section Models</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getTargetSectionModels <em>Target Section Models</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getSharedTargetSectionModels <em>Shared Target Section Models</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getMappingModels <em>Mapping Models</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getSharedMappingModels <em>Shared Mapping Models</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getSourceSections <em>Source Sections</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getTargetSections <em>Target Sections</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getMappings <em>Mappings</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getActiveMappings <em>Active Mappings</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getGlobalValues <em>Global Values</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getGlobalAttributes <em>Global Attributes</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getModifierSets <em>Modifier Sets</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getConditionModels <em>Condition Models</em>}</li>
 *   <li>{@link pamtram.PAMTraM#getSharedConditionModels <em>Shared Condition Models</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getPAMTraM()
 * @model
 * @generated
 */
public interface PAMTraM extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Section Models</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.SourceSectionModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Section Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of SourceSectionModels contained in this PAMTraM instance.
	 * <br />
	 * Together with the list of 'sharedSourceSectionModels', these make up the list of SourceSectionModels providing the SourceSections (LHS) that will be used during a transformation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Section Models</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_SourceSectionModels()
	 * @model containment="true"
	 * @generated
	 */
	EList<SourceSectionModel> getSourceSectionModels();

	/**
	 * Returns the value of the '<em><b>Shared Source Section Models</b></em>' reference list.
	 * The list contents are of type {@link pamtram.SourceSectionModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Source Section Model</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of external SourceSectionModels (stored in their own files with the file-ending '*.pamtram.source') referenced by this PAMTraM instance.
	 * <br />
	 * Together with the list of (local) 'sourceSectionModels', these make up the list of SourceSectionModels providing the SourceSections (LHS) that will be used during a transformation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shared Source Section Models</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_SharedSourceSectionModels()
	 * @model
	 * @generated
	 */
	EList<SourceSectionModel> getSharedSourceSectionModels();

	/**
	 * Returns the value of the '<em><b>Target Section Models</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.TargetSectionModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Section Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of TargetSectionModels contained in this PAMTraM instance.
	 * <br />
	 * Together with the list of 'sharedTargetSectionModels', these make up the list of TargetSectionModels providing the TargetSections (RHS) that will be used during a transformation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Section Models</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_TargetSectionModels()
	 * @model containment="true"
	 * @generated
	 */
	EList<TargetSectionModel> getTargetSectionModels();

	/**
	 * Returns the value of the '<em><b>Shared Target Section Models</b></em>' reference list.
	 * The list contents are of type {@link pamtram.TargetSectionModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Target Section Model</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of external TargetSectionModels (stored in their own files with the file-ending '*.pamtram.target') referenced by this PAMTraM instance.
	 * <br />
	 * Together with the list of (local) 'targetSectionModels', these make up the list of TargetSectionModels providing the TargetSections (RHS) that will be used during a transformation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shared Target Section Models</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_SharedTargetSectionModels()
	 * @model
	 * @generated
	 */
	EList<TargetSectionModel> getSharedTargetSectionModels();

	/**
	 * Returns the value of the '<em><b>Mapping Models</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.MappingModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of MappingModels contained in this PAMTraM instance.
	 * <br />
	 * Together with the list of 'sharedMappingModels', these make up the list of MappingModels defining the Mappings that will be executed during a transformation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mapping Models</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_MappingModels()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingModel> getMappingModels();

	/**
	 * Returns the value of the '<em><b>Shared Mapping Models</b></em>' reference list.
	 * The list contents are of type {@link pamtram.MappingModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Mapping Model</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of external MappingSectionModels (stored in their own files with the file-ending '*.pamtram.mapping') referenced by this PAMTraM instance.
	 * <br />
	 * Together with the list of (local) 'mappingSectionModels', these make up the list of MappingModels defining the Mappings that will be executed during a transformation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shared Mapping Models</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_SharedMappingModels()
	 * @model
	 * @generated
	 */
	EList<MappingModel> getSharedMappingModels();

	/**
	 * Returns the value of the '<em><b>Source Sections</b></em>' reference list.
	 * The list contents are of type {@link pamtram.structure.source.SourceSection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Sections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Sections</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_SourceSections()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='List&lt;SourceSection&gt; sourceSections = Stream\r\n\t\t.concat(this.getSourceSectionModels().stream(),\r\n\t\t\t\tthis.getSharedSourceSectionModels().stream())\r\n\t\t.flatMap(s -&gt; s.getSections().stream()).collect(Collectors.toList());\r\nreturn new EcoreEList.UnmodifiableEList&lt;&gt;(this, PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTIONS,\r\n\t\tsourceSections.size(), sourceSections.toArray());'"
	 * @generated
	 */
	EList<SourceSection> getSourceSections();

	/**
	 * Returns the value of the '<em><b>Target Sections</b></em>' reference list.
	 * The list contents are of type {@link pamtram.structure.target.TargetSection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Sections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Sections</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_TargetSections()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='List&lt;TargetSection&gt; targetSections = Stream\r\n\t\t.concat(this.getTargetSectionModels().stream(),\r\n\t\t\t\tthis.getSharedTargetSectionModels().stream())\r\n\t\t.flatMap(s -&gt; s.getSections().stream()).collect(Collectors.toList());\r\nreturn new EcoreEList.UnmodifiableEList&lt;&gt;(this, PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTIONS,\r\n\t\ttargetSections.size(), targetSections.toArray());'"
	 * @generated
	 */
	EList<TargetSection> getTargetSections();

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_Mappings()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.util.List%&gt;&lt;&lt;%pamtram.mapping.Mapping%&gt;&gt; mappings = &lt;%java.util.stream.Stream%&gt;.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())\r\n\t\t.flatMap(s -&gt; s.getMappings().stream()).collect(Collectors.toList());\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.PamtramPackage%&gt;.Literals.PAM_TRA_M__MAPPINGS,\r\n\t\tmappings.size(), mappings.toArray());'"
	 * @generated
	 */
	EList<Mapping> getMappings();

	/**
	 * Returns the value of the '<em><b>Active Mappings</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Mappings</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_ActiveMappings()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='List&lt;&lt;%pamtram.mapping.Mapping%&gt;&gt; mappings = &lt;%java.util.stream.Stream%&gt;.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())\r\n\t\t.filter(m -&gt; !m.isDeactivated()).flatMap(s -&gt; s.getActiveMappings().stream())\r\n\t\t.filter(m -&gt; m.getSourceSection() == null || !m.getSourceSection().isDeactivated())\r\n\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.PamtramPackage%&gt;.Literals.PAM_TRA_M__ACTIVE_MAPPINGS,\r\n\t\tmappings.size(), mappings.toArray());'"
	 * @generated
	 */
	EList<Mapping> getActiveMappings();

	/**
	 * Returns the value of the '<em><b>Global Values</b></em>' reference list.
	 * The list contents are of type {@link pamtram.FixedValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Values</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_GlobalValues()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.util.List%&gt;&lt;FixedValue&gt; globalValues = &lt;%java.util.stream.Stream%&gt;.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())\r\n\t\t.flatMap(s -&gt; s.getGlobalValues().stream()).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.PamtramPackage%&gt;.Literals.PAM_TRA_M__GLOBAL_VALUES,\r\n\t\tglobalValues.size(), globalValues.toArray());'"
	 * @generated
	 */
	EList<FixedValue> getGlobalValues();

	/**
	 * Returns the value of the '<em><b>Global Attributes</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.GlobalAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Attributes</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_GlobalAttributes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.util.List%&gt;&lt;GlobalAttribute&gt; globalAttributes = &lt;%java.util.stream.Stream%&gt;.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())\r\n\t\t.flatMap(s -&gt; s.getGlobalAttributes().stream()).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.PamtramPackage%&gt;.Literals.PAM_TRA_M__GLOBAL_ATTRIBUTES,\r\n\t\tglobalAttributes.size(), globalAttributes.toArray());'"
	 * @generated
	 */
	EList<GlobalAttribute> getGlobalAttributes();

	/**
	 * Returns the value of the '<em><b>Modifier Sets</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.modifier.ValueModifierSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier Sets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier Sets</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_ModifierSets()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.util.List%&gt;&lt;&lt;%pamtram.mapping.modifier.ValueModifierSet%&gt;&gt; modifierSets = &lt;%java.util.stream.Stream%&gt;.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())\r\n\t\t.flatMap(s -&gt; s.getModifierSets().stream()).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.PamtramPackage%&gt;.Literals.PAM_TRA_M__MODIFIER_SETS,\r\n\t\tmodifierSets.size(), modifierSets.toArray());'"
	 * @generated
	 */
	EList<ValueModifierSet> getModifierSets();

	/**
	 * Returns the value of the '<em><b>Condition Models</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.ConditionModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Model</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of ConditionModels contained in this PAMTraM instance.
	 * <br />
	 * Together with the list of 'sharedConditionModels', these make up the list of ConditionModels defining the global Conditions that can be referenced by other elements in the PAMTraM model.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Condition Models</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_ConditionModels()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConditionModel> getConditionModels();

	/**
	 * Returns the value of the '<em><b>Shared Condition Models</b></em>' reference list.
	 * The list contents are of type {@link pamtram.ConditionModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Condition Model</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of external ConditionModels (stored in their own files with the file-ending '*.pamtram.condition') referenced by this PAMTraM instance.
	 * <br />
	 * Together with the list of (local) 'conditionModels', these make up the list of ConditionModels defining the global Conditions that can be referenced by other elements in the PAMTraM model.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shared Condition Models</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_SharedConditionModels()
	 * @model
	 * @generated
	 */
	EList<ConditionModel> getSharedConditionModels();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Object[] sourceSectionModels = Stream.concat(this.getSourceSectionModels().stream(), this.getSharedSourceSectionModels().stream()).filter(s -&gt; !s.isDeactivated()).toArray();\r\nreturn new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;.UnmodifiableEList&lt;&gt;(sourceSectionModels.length, sourceSectionModels);'"
	 * @generated
	 */
	EList<SourceSectionModel> getActiveSourceSectionModels();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Object[] sourceSections = getActiveSourceSectionModels().stream().flatMap(s -&gt; s.getSections().stream()).filter(s -&gt; !s.isDeactivated()).toArray();\r\nreturn new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;.UnmodifiableEList&lt;&gt;(sourceSections.length, sourceSections);'"
	 * @generated
	 */
	EList<SourceSection> getActiveSourceSections();

} // PAMTraM
