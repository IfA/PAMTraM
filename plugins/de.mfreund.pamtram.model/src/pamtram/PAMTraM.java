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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='// TODO handle hierarchical extensions (an extended section extends\n\t\t// other sections\n\t\t// TODO implement a more sophisticated merging strategy that takes into\n\t\t// account overwriting of hints?\n\n\t/*\n\t\t * First, we collect each abstract source and target section as well as the concrete sections that reference\n\t\t * them\n\t\t \052/\n\t\tHashMap&lt;Section, LinkedList&lt;&lt;%pamtram.structure.generic.Section%&gt;&gt;&gt; abstractToConcreteSectionMap = new HashMap&lt;&gt;();\n\t\tMap&lt;EObject, Collection&lt;&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt;&gt;&gt; sourceSettings = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.CrossReferencer\n\t\t\t\t.find(this.getActiveSourceSections());\n\t\tfor (&lt;%pamtram.structure.generic.Section%&gt; section : this.getActiveSourceSections()) {\n\t\t\tif (section.isAbstract() &amp;&amp; sourceSettings.containsKey(section)) {\n\t\t\t\tLinkedList&lt;&lt;%pamtram.structure.generic.Section%&gt;&gt; concreteSections = new LinkedList&lt;&gt;();\n\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt; setting : sourceSettings.get(section)) {\n\t\t\t\t\tif (setting.getEStructuralFeature().equals(&lt;%pamtram.structure.generic.impl.GenericPackageImpl%&gt;.eINSTANCE.getSection_Extend())) {\n\t\t\t\t\t\tconcreteSections.add((&lt;%pamtram.structure.generic.Section%&gt;) setting.getEObject());\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tabstractToConcreteSectionMap.put(section, concreteSections);\n\t\t\t}\n\t\t}\n\t\tMap&lt;EObject, Collection&lt;&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt;&gt;&gt; targetSettings = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.CrossReferencer.find(this.getTargetSections());\n\t\tfor (&lt;%pamtram.structure.generic.Section%&gt; section : this.getTargetSections()) {\n\t\t\tif (section.isAbstract() &amp;&amp; targetSettings.containsKey(section)) {\n\t\t\t\tLinkedList&lt;&lt;%pamtram.structure.generic.Section%&gt;&gt; concreteSections = new LinkedList&lt;&gt;();\n\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt; setting : targetSettings.get(section)) {\n\t\t\t\t\tif (setting.getEStructuralFeature().equals(&lt;%pamtram.structure.generic.impl.GenericPackageImpl%&gt;.eINSTANCE.getSection_Extend())) {\n\t\t\t\t\t\tconcreteSections.add((&lt;%pamtram.structure.generic.Section%&gt;) setting.getEObject());\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tabstractToConcreteSectionMap.put(section, concreteSections);\n\t\t\t}\n\t\t}\n\n\tArrayList&lt;&lt;%pamtram.mapping.Mapping%&gt;&gt; concreteMappings = new ArrayList&lt;&gt;();\n\t\tfor (&lt;%pamtram.mapping.Mapping%&gt; mapping : this.getActiveMappings()) {\n\t\t\tif (!mapping.isAbstract()) {\n\t\t\t\tconcreteMappings.add(mapping);\n\t\t\t}\n\t\t}\n\n\t/*\n\t\t * Now, we copy all elements from the abstract sections to the concrete sections that extend them. In this\n\t\t * process, we store the associations between the elements from the abstract sections and the copied elements in\n\t\t * a map.\n\t\t \052/\n\t\tHashMap&lt;EObject, LinkedList&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt;&gt; abstractToConcreteElementMap = new HashMap&lt;&gt;();\n\t\tfor (&lt;%pamtram.structure.generic.Section%&gt; abstractSection : abstractToConcreteSectionMap.keySet()) {\n\t\t\tfor (&lt;%pamtram.structure.generic.Section%&gt; concreteSection : abstractToConcreteSectionMap.get(abstractSection)) {\n\n\t\t\t&lt;%pamtram.structure.generic.Section%&gt; copiedSection = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.copy(abstractSection);\n\n\t\t\tTreeIterator&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; originalIterator = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;\n\t\t\t\t\t\t.getAllContents(&lt;%java.util.Collections%&gt;.singleton(abstractSection));\n\t\t\t\tTreeIterator&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; copyIterator = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.getAllContents(&lt;%java.util.Collections%&gt;.singleton(copiedSection));\n\n\t\t\t// these lists will store the elements that we will add to the\n\t\t\t\t// concrete section\n\t\t\t\tArrayList&lt;&lt;%pamtram.structure.generic.Attribute%&gt;&gt; attributesToAdd = new ArrayList&lt;&gt;();\n\t\t\t\tArrayList&lt;&lt;%pamtram.structure.generic.Reference%&gt;&gt; referencesToAdd = new ArrayList&lt;&gt;();\n\n\t\t\twhile (originalIterator.hasNext()) {\n\t\t\t\t\tassert copyIterator.hasNext();\n\n\t\t\t\t&lt;%org.eclipse.emf.ecore.EObject%&gt; originalNext = originalIterator.next();\n\t\t\t\t\t&lt;%org.eclipse.emf.ecore.EObject%&gt; copyNext = copyIterator.next();\n\n\t\t\t\t// if the element is the section itself, we skip it\n\t\t\t\t\tif (originalNext instanceof &lt;%pamtram.structure.generic.Section%&gt;) {\n\t\t\t\t\t\tcontinue;\n\t\t\t\t\t}\n\n\t\t\t\t// if the element is a top-level element below the section,\n\t\t\t\t\t// we add it to the concrete section\n\t\t\t\t\tif (originalNext.eContainer().equals(abstractSection)) {\n\t\t\t\t\t\tif (copyNext instanceof &lt;%pamtram.structure.generic.Attribute%&gt;) {\n\t\t\t\t\t\t\tattributesToAdd.add((&lt;%pamtram.structure.generic.Attribute%&gt;) copyNext);\n\t\t\t\t\t\t} else if (copyNext instanceof &lt;%pamtram.structure.generic.Reference%&gt;) {\n\t\t\t\t\t\t\treferencesToAdd.add((&lt;%pamtram.structure.generic.Reference%&gt;) copyNext);\n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\tthrow new RuntimeException(\"Unsupported element type \'\" + copyNext.eClass().getName()\n\t\t\t\t\t\t\t\t\t+ \"\' encountered when merging extends!\");\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\n\t\t\t\t// in any case, we fill the abstractToConcreteElementMap\n\t\t\t\t\tLinkedList&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; vals = abstractToConcreteElementMap.get(originalNext);\n\t\t\t\t\tif (vals == null) {\n\t\t\t\t\t\tvals = new LinkedList&lt;&gt;();\n\t\t\t\t\t}\n\t\t\t\t\tvals.add(copyNext);\n\t\t\t\t\tabstractToConcreteElementMap.put(originalNext, vals);\n\t\t\t\t}\n\n\t\t\t/*\n\t\t\t\t * now, we add the collected elements to the concrete section; we have to do this after the process of\n\t\t\t\t * iterating over the contents - otherwise, the &lt;%org.eclipse.emf.common.util.TreeIterator%&gt; will throw IndexOutOfBoundsExceptions\n\t\t\t\t \052/\n\t\t\t\tconcreteSection.getAttributes().addAll(attributesToAdd);\n\t\t\t\tconcreteSection.getReferences().addAll(referencesToAdd);\n\n\t\t\t/*\n\t\t\t\t * Now, we redirect references from concrete sections to elements from the abstract section to the (new)\n\t\t\t\t * elements from the concrete sections.\n\t\t\t\t \052/\n\t\t\t\tMap&lt;EObject, Collection&lt;&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt;&gt;&gt; refsToAbstractSection = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.UsageCrossReferencer\n\t\t\t\t\t\t.findAll(abstractToConcreteElementMap.keySet(), this.getActiveSourceSections().stream()\n\t\t\t\t\t\t\t\t.filter(s -&gt; !s.isAbstract()).collect(&lt;%java.util.stream.Collectors%&gt;.toList()));\n\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; referencedObject : refsToAbstractSection.keySet()) {\n\n\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt; setting : refsToAbstractSection.get(referencedObject).stream()\n\t\t\t\t\t\t\t.filter(s -&gt; !s.getEStructuralFeature().isDerived()).collect(&lt;%java.util.stream.Collectors%&gt;.toList())) {\n\n\t\t\t\t\tif (setting.getEStructuralFeature().equals(&lt;%pamtram.structure.generic.GenericPackage%&gt;.eINSTANCE.getSection_Extend())) {\n\t\t\t\t\t\t\t// the \'extend\' feature has already been handled\n\t\t\t\t\t\t\t// above\n\t\t\t\t\t\t\tcontinue;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t// this is the element referencing the abstract section\n\t\t\t\t\t\t// (it should be an element of a section)\n\t\t\t\t\t\t&lt;%org.eclipse.emf.ecore.EObject%&gt; hintElement = setting.getEObject();\n\n\t\t\t\t\tif (setting.getEStructuralFeature().equals(&lt;%pamtram.structure.generic.GenericPackage%&gt;.eINSTANCE.getClass_Container())) {\n\t\t\t\t\t\t\tif (abstractSection.equals(hintElement) || abstractSection\n\t\t\t\t\t\t\t\t\t.isContainerFor((pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;) hintElement)) {\n\n\t\t\t\t\t\t\t// redirect the reference (we can always use the\n\t\t\t\t\t\t\t\t// \'last\' of the concrete objects as we just\n\t\t\t\t\t\t\t\t// added it above\n\t\t\t\t\t\t\t\tsetting.set(abstractToConcreteElementMap.get(referencedObject).getLast());\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t} else {\n\t\t\t\t\t\t\tSystem.out.println(\n\t\t\t\t\t\t\t\t\t\"Unhandled reference to element of an abstract section. Maybe consider redirecting this?\");\n\t\t\t\t\t\t}\n\n\t\t\t\t}\n\n\t\t\t}\n\n\t\t\t/*\n\t\t\t\t * Now, we redirect references from MappingHints to elements from the abstract section to the elements\n\t\t\t\t * from the concrete sections. Here, we only handle references from concrete mappings as the references\n\t\t\t\t * from abstract mappings (and thus from extended hint groups) are handled afterwards when these hint\n\t\t\t\t * groups are copied.\n\t\t\t\t \052/\n\t\t\t\trefsToAbstractSection = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.UsageCrossReferencer.findAll(abstractToConcreteElementMap.keySet(),\n\t\t\t\t\t\tconcreteMappings);\n\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; referencedObject : refsToAbstractSection.keySet()) {\n\n\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt; setting : refsToAbstractSection.get(referencedObject)) {\n\n\t\t\t\t\t// this is the element referencing the abstract section\n\t\t\t\t\t\t// (it should be contained in a &lt;%pamtram.mapping.Mapping%&gt; and be either\n\t\t\t\t\t\t// part of a MappingHintGroup or of a Condition)\n\t\t\t\t\t\t//\n\t\t\t\t\t\t&lt;%pamtram.mapping.MappingHintGroupType%&gt; hintGroup = (&lt;%pamtram.mapping.MappingHintGroupType%&gt;) &lt;%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%&gt;.getAncestorOfKind(\n\t\t\t\t\t\t\t\tsetting.getEObject(), &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING_HINT_GROUP_TYPE);\n\t\t\t\t\t\t&lt;%pamtram.mapping.Mapping%&gt; mapping = (&lt;%pamtram.mapping.Mapping%&gt;) &lt;%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%&gt;.getAncestorOfKind(setting.getEObject(),\n\t\t\t\t\t\t\t\t&lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING);\n\n\t\t\t\t\tif (mapping == null) {\n\t\t\t\t\t\t\tthrow new RuntimeException(\n\t\t\t\t\t\t\t\t\t\"Internal error during merging of extends. No containing element of type \'Mapping\' found for element \'\"\n\t\t\t\t\t\t\t\t\t\t\t+ setting.getEObject() + \"\'!\");\n\t\t\t\t\t\t}\n\n\t\t\t\t\t// We do not need to handle deactivated\n\t\t\t\t\t\t// Mappings/MappingHintGroups\n\t\t\t\t\t\t//\n\t\t\t\t\t\tif (hintGroup instanceof &lt;%pamtram.DeactivatableElement%&gt;\n\t\t\t\t\t\t\t\t&amp;&amp; ((&lt;%pamtram.DeactivatableElement%&gt;) hintGroup).isDeactivated() || mapping.isDeactivated()) {\n\t\t\t\t\t\t\tcontinue;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t/*\n\t\t\t\t\t\t * check if the hint group or its parent mapping equals the section that we just added the\n\t\t\t\t\t\t * concrete elements to\n\t\t\t\t\t\t \052/\n\t\t\t\t\t\tif (hintGroup != null\n\t\t\t\t\t\t\t\t&amp;&amp; (concreteSection.equals(hintGroup.getTargetSection())\n\t\t\t\t\t\t\t\t\t\t|| concreteSection.isContainerFor(hintGroup.getTargetSection()))\n\t\t\t\t\t\t\t\t|| concreteSection.equals(mapping.getSourceSection())\n\t\t\t\t\t\t\t\t|| concreteSection.isContainerFor(mapping.getSourceSection())) {\n\n\t\t\t\t\t\tif (setting.getEStructuralFeature().equals(\n\t\t\t\t\t\t\t\t\t&lt;%pamtram.structure.impl.StructurePackageImpl%&gt;.eINSTANCE.getTargetInstanceSelector_ReferenceAttribute())\n\t\t\t\t\t\t\t\t\t&amp;&amp; (setting.getEObject() instanceof &lt;%pamtram.mapping.extended.ContainerSelector%&gt; || setting.getEObject() instanceof &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;)\n\t\t\t\t\t\t\t\t\t|| setting.getEStructuralFeature().equals(\n\t\t\t\t\t\t\t\t\t\t\t&lt;%pamtram.structure.impl.StructurePackageImpl%&gt;.eINSTANCE.getTargetInstanceSelector_TargetClass())\n\t\t\t\t\t\t\t\t\t\t\t&amp;&amp; (setting.getEObject() instanceof &lt;%pamtram.mapping.extended.ContainerSelector%&gt;  || setting.getEObject() instanceof &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;)) {\n\t\t\t\t\t\t\t\t// do nothing as\n\t\t\t\t\t\t\t\t// ReferenceTargetSelectors and ContainerSelectors are handled\n\t\t\t\t\t\t\t\t// below separately\n\t\t\t\t\t\t\t} else {\n\n\t\t\t\t\t\t\t// redirect the reference (we can always use the\n\t\t\t\t\t\t\t\t// \'last\' of the concrete objects as we just\n\t\t\t\t\t\t\t\t// added it above\n\t\t\t\t\t\t\t\tsetting.set(abstractToConcreteElementMap.get(referencedObject).getLast());\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t}\n\t\t\t\t\t}\n\n\t\t\t}\n\n\t\t}\n\t\t}\n\n\t/*\n\t\t * Now, we handle the ContainerSelectors and ReferenceTargetSelectors that we skipped above. We can do this now as we\n\t\t * now know all concrete TargetSections that are a possible match for each ContainerSelector/ReferenceTargetSelector that points to an\n\t\t * abstract &lt;%pamtram.structure.target.TargetSection%&gt;.\n\t\t \052/\n\t\tfor (&lt;%pamtram.structure.generic.Section%&gt; abstractSection : abstractToConcreteSectionMap.keySet()) {\n\t\t\tfor (&lt;%pamtram.structure.generic.Section%&gt; concreteSection : abstractToConcreteSectionMap.get(abstractSection)) {\n\n\t\t\tMap&lt;EObject, Collection&lt;&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt;&gt;&gt; refsToAbstractSection = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.UsageCrossReferencer\n\t\t\t\t\t\t.findAll(abstractToConcreteElementMap.keySet(), concreteMappings);\n\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; referencedObject : refsToAbstractSection.keySet()) {\n\n\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt; setting : refsToAbstractSection.get(referencedObject)) {\n\n\t\t\t\t\t// this is the element referencing the abstract section\n\t\t\t\t\t\t// (it should be contained in a &lt;%pamtram.mapping.Mapping%&gt; and be either\n\t\t\t\t\t\t// part of a MappingHintGroup or of a Condition)\n\t\t\t\t\t\t//\n\t\t\t\t\t\t&lt;%pamtram.mapping.MappingHintGroupType%&gt; hintGroup = (&lt;%pamtram.mapping.MappingHintGroupType%&gt;) &lt;%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%&gt;.getAncestorOfKind(\n\t\t\t\t\t\t\t\tsetting.getEObject(), &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING_HINT_GROUP_TYPE);\n\t\t\t\t\t\t&lt;%pamtram.mapping.Mapping%&gt; mapping = (&lt;%pamtram.mapping.Mapping%&gt;) &lt;%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%&gt;.getAncestorOfKind(setting.getEObject(),\n\t\t\t\t\t\t\t\t&lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING);\n\n\t\t\t\t\tif (mapping == null) {\n\t\t\t\t\t\t\tthrow new RuntimeException(\n\t\t\t\t\t\t\t\t\t\"Internal error during merging of extends. No containing element of type \'Mapping\' found for element \'\"\n\t\t\t\t\t\t\t\t\t\t\t+ setting.getEObject() + \"\'!\");\n\t\t\t\t\t\t}\n\n\t\t\t\t\t// We do not need to handle deactivated\n\t\t\t\t\t\t// Mappings/MappingHintGroups\n\t\t\t\t\t\t//\n\t\t\t\t\t\tif (hintGroup instanceof &lt;%pamtram.DeactivatableElement%&gt;\n\t\t\t\t\t\t\t\t&amp;&amp; ((&lt;%pamtram.DeactivatableElement%&gt;) hintGroup).isDeactivated() || mapping.isDeactivated()) {\n\t\t\t\t\t\t\tcontinue;\n\t\t\t\t\t\t}\n\n\t\t\t\t\tif (setting.getEObject() instanceof &lt;%pamtram.mapping.extended.ContainerSelector%&gt; || setting.getEObject() instanceof &lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) {\n\n\t\t\t\t\t\tif (setting.getEStructuralFeature()\n\t\t\t\t\t\t\t\t\t.equals(&lt;%pamtram.structure.impl.StructurePackageImpl%&gt;.eINSTANCE.getTargetInstanceSelector_TargetClass())) {\n\t\t\t\t\t\t\t\tcontinue;\n\t\t\t\t\t\t\t} else if (!setting.getEStructuralFeature().equals(\n\t\t\t\t\t\t\t\t\t&lt;%pamtram.structure.impl.StructurePackageImpl%&gt;.eINSTANCE.getTargetInstanceSelector_ReferenceAttribute())) {\n\t\t\t\t\t\t\t\tthrow new RuntimeException(\n\t\t\t\t\t\t\t\t\t\t\"Internal error during redirection of \" + setting.getEObject().eClass().getName() + \"s in \'mergeExtends\'...!\");\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t// For Selectors, we must not simply redirect but we create a new Selector\n\t\t\t\t\t\t\t&lt;%pamtram.structure.TargetInstanceSelector%&gt; original = (&lt;%pamtram.structure.TargetInstanceSelector%&gt;) setting.getEObject();\n\n\t\t\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; concreteTargetSectionAttribute : abstractToConcreteElementMap\n\t\t\t\t\t\t\t\t\t.get(referencedObject)) {\n\n\t\t\t\t\t\t\tif (!(concreteTargetSectionAttribute instanceof &lt;%pamtram.structure.target.TargetSectionAttribute%&gt;)) {\n\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\n\t\t\t\t\t\t\t\t\t\t\t\"Internal error during merging of extends! Object of type \'TargetSectionClass\' expected.\");\n\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t&lt;%pamtram.structure.TargetInstanceSelector%&gt; copy = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.copy(original);\n\t\t\t\t\t\t\t\tcopy.setReferenceAttribute((&lt;%pamtram.structure.target.TargetSectionAttribute%&gt;) concreteTargetSectionAttribute);\n\n\t\t\t\t\t\t\tCollection&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; possibleTargetClasses = new ArrayList&lt;&gt;();\n\t\t\t\t\t\t\t\tif (original.getTargetClass() instanceof &lt;%pamtram.structure.target.TargetSection%&gt;) {\n\t\t\t\t\t\t\t\t\tpossibleTargetClasses\n\t\t\t\t\t\t\t\t\t\t\t.addAll(abstractToConcreteSectionMap.get(original.getTargetClass()));\n\t\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\t\tpossibleTargetClasses\n\t\t\t\t\t\t\t\t\t\t\t.addAll(abstractToConcreteElementMap.get(original.getTargetClass()));\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tOptional&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; targetClass = possibleTargetClasses.stream()\n\t\t\t\t\t\t\t\t\t\t.filter(s -&gt; s instanceof &lt;%pamtram.structure.target.TargetSectionClass%&gt;\n\t\t\t\t\t\t\t\t\t\t\t\t&amp;&amp; ((&lt;%pamtram.structure.target.TargetSectionClass%&gt;) s).getContainingSection().equals(\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t((&lt;%pamtram.structure.target.TargetSectionAttribute%&gt;) concreteTargetSectionAttribute)\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.getContainingSection()))\n\t\t\t\t\t\t\t\t\t\t.findAny();\n\t\t\t\t\t\t\t\tif (targetClass.isPresent()) {\n\t\t\t\t\t\t\t\t\tcopy.setTargetClass((&lt;%pamtram.structure.target.TargetSectionClass%&gt;) targetClass.get());\n\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\thintGroup.getMappingHints().add((&lt;%pamtram.mapping.extended.MappingHint%&gt;)copy);\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t}\n\t\t\t\t\t}\n\n\t\t\t}\n\n\t\t}\n\t\t}\n\n\t/*\n\t\t * Finally, we can copy the abstract hint groups\n\t\t \052/\n\n\t// collect each abstract hint group as well as the concrete hint groups\n\t\t// that reference them\n\t\tHashMap&lt;MappingHintGroupType, LinkedList&lt;&lt;%pamtram.mapping.MappingHintGroupType%&gt;&gt;&gt; abstractToConcreteHintGroupMap = new HashMap&lt;&gt;();\n\t\tMap&lt;EObject, Collection&lt;&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt;&gt;&gt; mappingSettings = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.CrossReferencer.find(this.getActiveMappings());\n\t\tfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; element : mappingSettings.keySet()) {\n\t\t\tif (element instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt; &amp;&amp; ((&lt;%pamtram.mapping.Mapping%&gt;) element.eContainer()).isAbstract()) {\n\n\t\t\t// We do not need to handle deactivated MappingHintGroups\n\t\t\t\t//\n\t\t\t\tif (element instanceof &lt;%pamtram.DeactivatableElement%&gt; &amp;&amp; ((&lt;%pamtram.DeactivatableElement%&gt;) element).isDeactivated()\n\t\t\t\t\t\t|| element.eContainer() instanceof &lt;%pamtram.DeactivatableElement%&gt;\n\t\t\t\t\t\t\t\t&amp;&amp; ((&lt;%pamtram.DeactivatableElement%&gt;) element.eContainer()).isDeactivated()) {\n\t\t\t\t\tcontinue;\n\t\t\t\t}\n\n\t\t\tLinkedList&lt;&lt;%pamtram.mapping.MappingHintGroupType%&gt;&gt; concreteHintGroups = new LinkedList&lt;&gt;();\n\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt; setting : mappingSettings.get(element)) {\n\t\t\t\t\tif (setting.getEStructuralFeature()\n\t\t\t\t\t\t\t.equals(&lt;%pamtram.mapping.impl.MappingPackageImpl%&gt;.eINSTANCE.getMappingHintGroupType_Extend())) {\n\n\t\t\t\t\t// only copy hints to activated hint groups\n\t\t\t\t\t\tif (setting.getEObject() instanceof &lt;%pamtram.DeactivatableElement%&gt;\n\t\t\t\t\t\t\t\t&amp;&amp; ((&lt;%pamtram.DeactivatableElement%&gt;) setting.getEObject()).isDeactivated()\n\t\t\t\t\t\t\t\t|| setting.getEObject().eContainer() instanceof &lt;%pamtram.DeactivatableElement%&gt;\n\t\t\t\t\t\t\t\t\t\t&amp;&amp; ((&lt;%pamtram.DeactivatableElement%&gt;) setting.getEObject().eContainer()).isDeactivated()) {\n\t\t\t\t\t\t\tcontinue;\n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\tconcreteHintGroups.add((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) setting.getEObject());\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tabstractToConcreteHintGroupMap.put((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) element, concreteHintGroups);\n\t\t\t}\n\t\t}\n\n\t// copy the contained elements (hints and condition) to the concrete\n\t\t// hint groups\n\t\tfor (&lt;%pamtram.mapping.MappingHintGroupType%&gt; abstractHintGroup : abstractToConcreteHintGroupMap.keySet()) {\n\t\t\tfor (&lt;%pamtram.mapping.MappingHintGroupType%&gt; concreteHintGroup : abstractToConcreteHintGroupMap.get(abstractHintGroup)) {\n\n\t\t\tCollection&lt;&lt;%pamtram.mapping.extended.MappingHintBaseType%&gt;&gt; hintsToCopy = new BasicEList&lt;&gt;();\n\t\t\t\t/*\n\t\t\t\t * Collect all hints that will get copied. Those are all mapping hints (including ContainerSelectors)\n\t\t\t\t * that are not \'overwritten\' by hints of the concrete HintGroup.\n\t\t\t\t \052/\n\t\t\t\tfor (&lt;%pamtram.mapping.extended.MappingHint%&gt; abstractHint : abstractHintGroup.getActiveMappingHints()) {\n\n\t\t\t\t// An abstract hint is copied if it is not overwritten\n\t\t\t\t\t//\n\n\t\t\t\tif (concreteHintGroup.getMappingHints().stream()\n\t\t\t\t\t\t\t.noneMatch(h -&gt; h.getOverwrite() != null &amp;&amp; h.getOverwrite().equals(abstractHint))) {\n\n\t\t\t\t\thintsToCopy.add(abstractHint);\n\t\t\t\t\t}\n\n\t\t\t}\n\n\t\t\t// Retrieve a possible condition to be copied\n\t\t\t\t//\n\t\t\t\t&lt;%pamtram.condition.ComplexCondition%&gt; condition = null;\n\t\t\t\tif (abstractHintGroup instanceof &lt;%pamtram.ConditionalElement%&gt;) {\n\t\t\t\t\tcondition = ((&lt;%pamtram.ConditionalElement%&gt;) abstractHintGroup).getLocalCondition() != null\n\t\t\t\t\t\t\t? ((&lt;%pamtram.ConditionalElement%&gt;) abstractHintGroup).getLocalCondition()\n\t\t\t\t\t\t\t: ((&lt;%pamtram.ConditionalElement%&gt;) abstractHintGroup).getSharedCondition();\n\t\t\t\t}\n\t\t\t\t&lt;%pamtram.condition.ComplexCondition%&gt; copiedCondition = condition != null ? &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.copy(condition) : null;\n\n\t\t\tCollection&lt;&lt;%pamtram.mapping.extended.MappingHintBaseType%&gt;&gt; copiedHints = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.copyAll(hintsToCopy);\n\n\t\t\t/*\n\t\t\t\t * make sure that all references to elements from the abstract sections are redirected to the concrete\n\t\t\t\t * sections that we created earlier\n\t\t\t\t \052/\n\t\t\t\tCollection&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; copiedElements = new ArrayList&lt;&gt;(copiedHints);\n\t\t\t\tif (copiedCondition != null) {\n\t\t\t\t\tcopiedElements.add(copiedCondition);\n\t\t\t\t}\n\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; copiedElement : copiedElements) {\n\n\t\t\t\t/*\n\t\t\t\t\t * these are the references from the copied hint (that will get added to the concrete hint group) to\n\t\t\t\t\t * elements from abstract sections\n\t\t\t\t\t \052/\n\t\t\t\t\tMap&lt;EObject, Collection&lt;&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt;&gt;&gt; refsToAbstractSection = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.UsageCrossReferencer\n\t\t\t\t\t\t\t.findAll(abstractToConcreteElementMap.keySet(), copiedElement);\n\t\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; referencedObject : refsToAbstractSection.keySet()) {\n\n\t\t\t\t\t/*\n\t\t\t\t\t\t * based on the type of hint element that we are handling (local or external), source and target\n\t\t\t\t\t\t * sections or their containers are checked\n\t\t\t\t\t\t \052/\n\t\t\t\t\t\tboolean local = true;\n\t\t\t\t\t\tif (refsToAbstractSection.get(referencedObject).size() &gt; 1) {\n\t\t\t\t\t\t\tthrow new RuntimeException(\"Internal Error! The element \'\"\n\t\t\t\t\t\t\t\t\t+ (copiedElement instanceof &lt;%pamtram.NamedElement%&gt; ? ((&lt;%pamtram.NamedElement%&gt;) copiedElement).getName()\n\t\t\t\t\t\t\t\t\t\t\t: copiedElement.toString())\n\t\t\t\t\t\t\t\t\t+ \"\' in the hint group \'\" + abstractHintGroup.getName()\n\t\t\t\t\t\t\t\t\t+ \"\' holds multiple references to the same object of an abstract section (\'\"\n\t\t\t\t\t\t\t\t\t+ referencedObject + \"\'.\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif (refsToAbstractSection.get(referencedObject).iterator().next()\n\t\t\t\t\t\t\t\t.getEObject() instanceof &lt;%pamtram.structure.ExternalDynamicSourceElement%&gt;) {\n\t\t\t\t\t\t\tlocal = false;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tArrayList&lt;&lt;%pamtram.structure.generic.Section%&gt;&gt; sourceAndTargetSections = new ArrayList&lt;&gt;();\n\t\t\t\t\t\t&lt;%pamtram.structure.source.SourceSection%&gt; sourceSection = ((&lt;%pamtram.mapping.Mapping%&gt;) concreteHintGroup.eContainer()).getSourceSection();\n\t\t\t\t\t\tif (local) {\n\t\t\t\t\t\t\tsourceAndTargetSections.add(sourceSection);\n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\twhile (sourceSection.getContainer() != null) {\n\t\t\t\t\t\t\t\tsourceSection = sourceSection.getContainer().getContainingSection();\n\t\t\t\t\t\t\t\tsourceAndTargetSections.add(sourceSection);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t&lt;%pamtram.structure.target.TargetSection%&gt; targetSection = concreteHintGroup.getTargetSection();\n\t\t\t\t\t\tif (local) {\n\t\t\t\t\t\t\tsourceAndTargetSections.add(targetSection);\n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\twhile (targetSection.getContainer() != null) {\n\t\t\t\t\t\t\t\ttargetSection = targetSection.getContainer().getContainingSection();\n\t\t\t\t\t\t\t\tsourceAndTargetSections.add(targetSection);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\n\t\t\t\t\t/*\n\t\t\t\t\t\t * these are possible targets for the redirection of references to the referenced object\n\t\t\t\t\t\t \052/\n\t\t\t\t\t\tLinkedList&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; possibleTargets = abstractToConcreteElementMap.get(referencedObject);\n\n\t\t\t\t\tboolean found = false;\n\t\t\t\t\t\t&lt;%org.eclipse.emf.ecore.EObject%&gt; target = null; // this will contain the new\n\t\t\t\t\t\t\t\t\t\t\t\t// value for the reference\n\t\t\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; possibleTarget : possibleTargets) {\n\t\t\t\t\t\t\t&lt;%pamtram.structure.generic.Section%&gt; containingSection = ((&lt;%pamtram.structure.generic.MetaModelElement%&gt;) possibleTarget).getContainingSection();\n\t\t\t\t\t\t\tif (sourceAndTargetSections.contains(containingSection)) {\n\t\t\t\t\t\t\t\tif (found == false) {\n\t\t\t\t\t\t\t\t\tfound = true;\n\t\t\t\t\t\t\t\t\ttarget = possibleTarget;\n\t\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\t\t// this should not happen, should it?\n\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\n\t\t\t\t\t\t\t\t\t\t\t\"Internal error! Multiple targets found for redirection of element \'\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t+ referencedObject + \"\' in.\");\n\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\n\t\t\t\t\tif (found == false) {\n\t\t\t\t\t\t\tthrow new RuntimeException(\"Internal error! No target found for redirection of element \'\"\n\t\t\t\t\t\t\t\t\t+ referencedObject + \"\'.\");\n\t\t\t\t\t\t}\n\n\t\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt; setting : refsToAbstractSection.get(referencedObject)) {\n\t\t\t\t\t\t\tsetting.set(target);\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\n\t\t\t}\n\n\t\t\t// Finally, we add the copied hints and condition to the\n\t\t\t\t// concrete hint group\n\t\t\t\tconcreteHintGroup.getMappingHints().addAll(0, (Collection&lt;? extends &lt;%pamtram.mapping.extended.MappingHint%&gt;&gt;) copiedHints);\n\n\t\t\tif (copiedCondition != null &amp;&amp; concreteHintGroup instanceof &lt;%pamtram.ConditionalElement%&gt;) {\n\t\t\t\t\t&lt;%pamtram.ConditionalElement%&gt; concreteHintGroupCast = (&lt;%pamtram.ConditionalElement%&gt;) concreteHintGroup;\n\t\t\t\t\t// If there is already a condition present in the concrete\n\t\t\t\t\t// HintGroup, we have to create a new condition that will\n\t\t\t\t\t// conjunct both conditions\n\t\t\t\t\t//\n\t\t\t\t\tif (concreteHintGroupCast.getLocalCondition() != null) {\n\t\t\t\t\t\t&lt;%pamtram.condition.And%&gt; and = &lt;%pamtram.condition.ConditionFactory%&gt;.eINSTANCE.createAnd();\n\t\t\t\t\t\tand.getLocalCondParts().add(concreteHintGroupCast.getLocalCondition());\n\t\t\t\t\t\tand.getLocalCondParts().add(copiedCondition);\n\t\t\t\t\t\tconcreteHintGroupCast.setLocalCondition(and);\n\t\t\t\t\t} else if (concreteHintGroupCast.getSharedCondition() != null) {\n\t\t\t\t\t\t&lt;%pamtram.condition.And%&gt; and = &lt;%pamtram.condition.ConditionFactory%&gt;.eINSTANCE.createAnd();\n\t\t\t\t\t\tand.getLocalCondParts().add(&lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.copy(concreteHintGroupCast.getSharedCondition()));\n\t\t\t\t\t\tand.getLocalCondParts().add(copiedCondition);\n\t\t\t\t\t\tconcreteHintGroupCast.setSharedCondition(null);\n\t\t\t\t\t\tconcreteHintGroupCast.setLocalCondition(and);\n\t\t\t\t\t} else {\n\t\t\t\t\t\tconcreteHintGroupCast.setLocalCondition(copiedCondition);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t/*\n\t\t * At the end, we clear the values of the \'extend\' references of the concrete elements as these are no longer\n\t\t * needed.\n\t\t \052/\n\t\tfor (Entry&lt;Section, LinkedList&lt;&lt;%pamtram.structure.generic.Section%&gt;&gt;&gt; entry : abstractToConcreteSectionMap.entrySet()) {\n\t\t\tfor (&lt;%pamtram.structure.generic.Section%&gt; concreteSection : entry.getValue()) {\n\t\t\t\tconcreteSection.getExtend().remove(entry.getKey());\n\t\t\t}\n\t\t}\n\t\tfor (Entry&lt;MappingHintGroupType, LinkedList&lt;&lt;%pamtram.mapping.MappingHintGroupType%&gt;&gt;&gt; entry : abstractToConcreteHintGroupMap\n\t\t\t\t.entrySet()) {\n\t\t\tfor (&lt;%pamtram.mapping.MappingHintGroupType%&gt; concreteHintGroup : entry.getValue()) {\n\t\t\t\tconcreteHintGroup.getExtend().remove(entry.getKey());\n\t\t\t}\n\t\t}'"
	 * @generated
	 */
	void mergeExtends();

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
