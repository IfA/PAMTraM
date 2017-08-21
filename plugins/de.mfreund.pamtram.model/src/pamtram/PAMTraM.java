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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='// TODO handle hierarchical extensions (an extended section extends\r\n// other sections\r\n// TODO implement a more sophisticated merging strategy that takes into\r\n// account overwriting of hints?\r\n\r\n/*\r\n * First, we collect each abstract source and target section as well as the concrete sections that reference\r\n * them\r\n \052/\r\nHashMap&lt;Section, LinkedList&lt;&lt;%pamtram.structure.generic.Section%&gt;&gt;&gt; abstractToConcreteSectionMap = new HashMap&lt;&gt;();\r\nMap&lt;EObject, Collection&lt;&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt;&gt;&gt; sourceSettings = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.CrossReferencer\r\n\t\t.find(this.getActiveSourceSections());\r\nfor (&lt;%pamtram.structure.generic.Section%&gt; section : this.getActiveSourceSections()) {\r\n\tif (section.isAbstract() &amp;&amp; sourceSettings.containsKey(section)) {\r\n\t\tLinkedList&lt;&lt;%pamtram.structure.generic.Section%&gt;&gt; concreteSections = new LinkedList&lt;&gt;();\r\n\t\tfor (&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt; setting : sourceSettings.get(section)) {\r\n\t\t\tif (setting.getEStructuralFeature().equals(&lt;%pamtram.structure.generic.impl.GenericPackageImpl%&gt;.eINSTANCE.getSection_Extend())) {\r\n\t\t\t\tconcreteSections.add((&lt;%pamtram.structure.generic.Section%&gt;) setting.getEObject());\r\n\t\t\t}\r\n\t\t}\r\n\t\tabstractToConcreteSectionMap.put(section, concreteSections);\r\n\t}\r\n}\r\nMap&lt;EObject, Collection&lt;&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt;&gt;&gt; targetSettings = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.CrossReferencer.find(this.getTargetSections());\r\nfor (&lt;%pamtram.structure.generic.Section%&gt; section : this.getTargetSections()) {\r\n\tif (section.isAbstract() &amp;&amp; targetSettings.containsKey(section)) {\r\n\t\tLinkedList&lt;&lt;%pamtram.structure.generic.Section%&gt;&gt; concreteSections = new LinkedList&lt;&gt;();\r\n\t\tfor (&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt; setting : targetSettings.get(section)) {\r\n\t\t\tif (setting.getEStructuralFeature().equals(&lt;%pamtram.structure.generic.impl.GenericPackageImpl%&gt;.eINSTANCE.getSection_Extend())) {\r\n\t\t\t\tconcreteSections.add((&lt;%pamtram.structure.generic.Section%&gt;) setting.getEObject());\r\n\t\t\t}\r\n\t\t}\r\n\t\tabstractToConcreteSectionMap.put(section, concreteSections);\r\n\t}\r\n}\r\n\r\nArrayList&lt;&lt;%pamtram.mapping.Mapping%&gt;&gt; concreteMappings = new ArrayList&lt;&gt;();\r\nfor (&lt;%pamtram.mapping.Mapping%&gt; mapping : this.getActiveMappings()) {\r\n\tif (!mapping.isAbstract()) {\r\n\t\tconcreteMappings.add(mapping);\r\n\t}\r\n}\r\n\r\n/*\r\n * Now, we copy all elements from the abstract sections to the concrete sections that extend them. In this\r\n * process, we store the associations between the elements from the abstract sections and the copied elements in\r\n * a map.\r\n \052/\r\nHashMap&lt;EObject, LinkedList&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt;&gt; abstractToConcreteElementMap = new HashMap&lt;&gt;();\r\nfor (&lt;%pamtram.structure.generic.Section%&gt; abstractSection : abstractToConcreteSectionMap.keySet()) {\r\n\tfor (&lt;%pamtram.structure.generic.Section%&gt; concreteSection : abstractToConcreteSectionMap.get(abstractSection)) {\r\n\r\n\t&lt;%pamtram.structure.generic.Section%&gt; copiedSection = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.copy(abstractSection);\r\n\r\n\tTreeIterator&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; originalIterator = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;\r\n\t\t\t\t.getAllContents(&lt;%java.util.Collections%&gt;.singleton(abstractSection));\r\n\t\tTreeIterator&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; copyIterator = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.getAllContents(&lt;%java.util.Collections%&gt;.singleton(copiedSection));\r\n\r\n\t// these lists will store the elements that we will add to the\r\n\t\t// concrete section\r\n\t\tArrayList&lt;&lt;%pamtram.structure.generic.Attribute%&gt;&gt; attributesToAdd = new ArrayList&lt;&gt;();\r\n\t\tArrayList&lt;&lt;%pamtram.structure.generic.Reference%&gt;&gt; referencesToAdd = new ArrayList&lt;&gt;();\r\n\r\n\twhile (originalIterator.hasNext()) {\r\n\t\t\tassert copyIterator.hasNext();\r\n\r\n\t\t&lt;%org.eclipse.emf.ecore.EObject%&gt; originalNext = originalIterator.next();\r\n\t\t\t&lt;%org.eclipse.emf.ecore.EObject%&gt; copyNext = copyIterator.next();\r\n\r\n\t\t// if the element is the section itself, we skip it\r\n\t\t\tif (originalNext instanceof &lt;%pamtram.structure.generic.Section%&gt;) {\r\n\t\t\t\tcontinue;\r\n\t\t\t}\r\n\r\n\t\t// if the element is a top-level element below the section,\r\n\t\t\t// we add it to the concrete section\r\n\t\t\tif (originalNext.eContainer().equals(abstractSection)) {\r\n\t\t\t\tif (copyNext instanceof &lt;%pamtram.structure.generic.Attribute%&gt;) {\r\n\t\t\t\t\tattributesToAdd.add((&lt;%pamtram.structure.generic.Attribute%&gt;) copyNext);\r\n\t\t\t\t} else if (copyNext instanceof &lt;%pamtram.structure.generic.Reference%&gt;) {\r\n\t\t\t\t\treferencesToAdd.add((&lt;%pamtram.structure.generic.Reference%&gt;) copyNext);\r\n\t\t\t\t} else {\r\n\t\t\t\t\tthrow new RuntimeException(\"Unsupported element type \'\" + copyNext.eClass().getName()\r\n\t\t\t\t\t\t\t+ \"\' encountered when merging extends!\");\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t\t// in any case, we fill the abstractToConcreteElementMap\r\n\t\t\tLinkedList&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; vals = abstractToConcreteElementMap.get(originalNext);\r\n\t\t\tif (vals == null) {\r\n\t\t\t\tvals = new LinkedList&lt;&gt;();\r\n\t\t\t}\r\n\t\t\tvals.add(copyNext);\r\n\t\t\tabstractToConcreteElementMap.put(originalNext, vals);\r\n\t\t}\r\n\r\n\t/*\r\n\t\t * now, we add the collected elements to the concrete section; we have to do this after the process of\r\n\t\t * iterating over the contents - otherwise, the &lt;%org.eclipse.emf.common.util.TreeIterator%&gt; will throw IndexOutOfBoundsExceptions\r\n\t\t \052/\r\n\t\tconcreteSection.getAttributes().addAll(attributesToAdd);\r\n\t\tconcreteSection.getReferences().addAll(referencesToAdd);\r\n\r\n\t/*\r\n\t\t * Now, we redirect references from concrete sections to elements from the abstract section to the (new)\r\n\t\t * elements from the concrete sections.\r\n\t\t \052/\r\n\t\tMap&lt;EObject, Collection&lt;&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt;&gt;&gt; refsToAbstractSection = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.UsageCrossReferencer\r\n\t\t\t\t.findAll(abstractToConcreteElementMap.keySet(), this.getActiveSourceSections().stream()\r\n\t\t\t\t\t\t.filter(s -&gt; !s.isAbstract()).collect(&lt;%java.util.stream.Collectors%&gt;.toList()));\r\n\t\tfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\t\tfor (&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt; setting : refsToAbstractSection.get(referencedObject).stream()\r\n\t\t\t\t\t.filter(s -&gt; !s.getEStructuralFeature().isDerived()).collect(&lt;%java.util.stream.Collectors%&gt;.toList())) {\r\n\r\n\t\t\tif (setting.getEStructuralFeature().equals(&lt;%pamtram.structure.generic.GenericPackage%&gt;.eINSTANCE.getSection_Extend())) {\r\n\t\t\t\t\t// the \'extend\' feature has already been handled\r\n\t\t\t\t\t// above\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\r\n\t\t\t// this is the element referencing the abstract section\r\n\t\t\t\t// (it should be an element of a section)\r\n\t\t\t\t&lt;%org.eclipse.emf.ecore.EObject%&gt; hintElement = setting.getEObject();\r\n\r\n\t\t\tif (setting.getEStructuralFeature().equals(&lt;%pamtram.structure.generic.GenericPackage%&gt;.eINSTANCE.getClass_Container())) {\r\n\t\t\t\t\tif (abstractSection.equals(hintElement) || abstractSection\r\n\t\t\t\t\t\t\t.isContainerFor((pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;) hintElement)) {\r\n\r\n\t\t\t\t\t// redirect the reference (we can always use the\r\n\t\t\t\t\t\t// \'last\' of the concrete objects as we just\r\n\t\t\t\t\t\t// added it above\r\n\t\t\t\t\t\tsetting.set(abstractToConcreteElementMap.get(referencedObject).getLast());\r\n\t\t\t\t\t}\r\n\r\n\t\t\t} else {\r\n\t\t\t\t\tSystem.out.println(\r\n\t\t\t\t\t\t\t\"Unhandled reference to element of an abstract section. Maybe consider redirecting this?\");\r\n\t\t\t\t}\r\n\r\n\t\t}\r\n\r\n\t}\r\n\r\n\t/*\r\n\t\t * Now, we redirect references from MappingHints to elements from the abstract section to the elements\r\n\t\t * from the concrete sections. Here, we only handle references from concrete mappings as the references\r\n\t\t * from abstract mappings (and thus from extended hint groups) are handled afterwards when these hint\r\n\t\t * groups are copied.\r\n\t\t \052/\r\n\t\trefsToAbstractSection = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.UsageCrossReferencer.findAll(abstractToConcreteElementMap.keySet(),\r\n\t\t\t\tconcreteMappings);\r\n\t\tfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\t\tfor (&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt; setting : refsToAbstractSection.get(referencedObject)) {\r\n\r\n\t\t\t// this is the element referencing the abstract section\r\n\t\t\t\t// (it should be contained in a &lt;%pamtram.mapping.Mapping%&gt; and be either\r\n\t\t\t\t// part of a MappingHintGroup or of a Condition)\r\n\t\t\t\t//\r\n\t\t\t\t&lt;%pamtram.mapping.MappingHintGroupType%&gt; hintGroup = (&lt;%pamtram.mapping.MappingHintGroupType%&gt;) &lt;%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%&gt;.getAncestorOfKind(\r\n\t\t\t\t\t\tsetting.getEObject(), &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING_HINT_GROUP_TYPE);\r\n\t\t\t\t&lt;%pamtram.mapping.Mapping%&gt; mapping = (&lt;%pamtram.mapping.Mapping%&gt;) &lt;%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%&gt;.getAncestorOfKind(setting.getEObject(),\r\n\t\t\t\t\t\t&lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING);\r\n\r\n\t\t\tif (mapping == null) {\r\n\t\t\t\t\tthrow new RuntimeException(\r\n\t\t\t\t\t\t\t\"Internal error during merging of extends. No containing element of type \'Mapping\' found for element \'\"\r\n\t\t\t\t\t\t\t\t\t+ setting.getEObject() + \"\'!\");\r\n\t\t\t\t}\r\n\r\n\t\t\t// We do not need to handle deactivated\r\n\t\t\t\t// Mappings/MappingHintGroups\r\n\t\t\t\t//\r\n\t\t\t\tif (hintGroup instanceof &lt;%pamtram.DeactivatableElement%&gt;\r\n\t\t\t\t\t\t&amp;&amp; ((&lt;%pamtram.DeactivatableElement%&gt;) hintGroup).isDeactivated() || mapping.isDeactivated()) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\r\n\t\t\t/*\r\n\t\t\t\t * check if the hint group or its parent mapping equals the section that we just added the\r\n\t\t\t\t * concrete elements to\r\n\t\t\t\t \052/\r\n\t\t\t\tif (hintGroup != null\r\n\t\t\t\t\t\t&amp;&amp; (concreteSection.equals(hintGroup.getTargetSection())\r\n\t\t\t\t\t\t\t\t|| concreteSection.isContainerFor(hintGroup.getTargetSection()))\r\n\t\t\t\t\t\t|| concreteSection.equals(mapping.getSourceSection())\r\n\t\t\t\t\t\t|| concreteSection.isContainerFor(mapping.getSourceSection())) {\r\n\r\n\t\t\t\tif (setting.getEStructuralFeature()\r\n\t\t\t\t\t\t\t.equals(&lt;%pamtram.structure.impl.StructurePackageImpl%&gt;.eINSTANCE.getDynamicSourceElement_Source())\r\n\t\t\t\t\t\t\t&amp;&amp; setting.getEObject() instanceof &lt;%pamtram.mapping.extended.ContainerSelectorTargetAttribute%&gt;\r\n\t\t\t\t\t\t\t|| setting.getEStructuralFeature()\r\n\t\t\t\t\t\t\t\t\t.equals(&lt;%pamtram.mapping.extended.impl.ExtendedPackageImpl%&gt;.eINSTANCE.getAttributeMatcher_Target())\r\n\t\t\t\t\t\t\t\t\t&amp;&amp; setting.getEObject() instanceof &lt;%pamtram.mapping.extended.AttributeMatcher%&gt;) {\r\n\t\t\t\t\t\t// do nothing as ContainerSelectors and\r\n\t\t\t\t\t\t// AttributeMatchers are handled\r\n\t\t\t\t\t\t// below separately\r\n\t\t\t\t\t} else {\r\n\r\n\t\t\t\t\t// redirect the reference (we can always use the\r\n\t\t\t\t\t\t// \'last\' of the concrete objects as we just\r\n\t\t\t\t\t\t// added it above\r\n\t\t\t\t\t\tsetting.set(abstractToConcreteElementMap.get(referencedObject).getLast());\r\n\t\t\t\t\t}\r\n\r\n\t\t\t}\r\n\t\t\t}\r\n\r\n\t}\r\n\r\n}\r\n}\r\n\r\n/*\r\n * Now, we handle the ContainerSelectors and AttributeMatchers that we skipped above. We can do this now as we\r\n * now know all concrete TargetSections that are a possible match for each &lt;%pamtram.mapping.extended.ContainerSelector%&gt; that points to an\r\n * abstract &lt;%pamtram.structure.target.TargetSection%&gt;.\r\n \052/\r\nfor (&lt;%pamtram.structure.generic.Section%&gt; abstractSection : abstractToConcreteSectionMap.keySet()) {\r\n\tfor (&lt;%pamtram.structure.generic.Section%&gt; concreteSection : abstractToConcreteSectionMap.get(abstractSection)) {\r\n\t\t/*\r\n\t\t * as ContainerSelectors will get treated differently (see below), we store the\r\n\t\t * ContainerSelectorTargetAttributes holding the references to the Attributes in the abstract section\r\n\t\t * and will delete these later\r\n\t\t \052/\r\n\t\tArrayList&lt;&lt;%pamtram.mapping.extended.ContainerSelectorTargetAttribute%&gt;&gt; mchTargetAttributesToDelete = new ArrayList&lt;&gt;();\r\n\r\n\tMap&lt;EObject, Collection&lt;&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt;&gt;&gt; refsToAbstractSection = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.UsageCrossReferencer\r\n\t\t\t\t.findAll(abstractToConcreteElementMap.keySet(), concreteMappings);\r\n\t\tfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\t\tfor (&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt; setting : refsToAbstractSection.get(referencedObject)) {\r\n\r\n\t\t\t// this is the element referencing the abstract section\r\n\t\t\t\t// (it should be contained in a &lt;%pamtram.mapping.Mapping%&gt; and be either\r\n\t\t\t\t// part of a MappingHintGroup or of a Condition)\r\n\t\t\t\t//\r\n\t\t\t\t&lt;%pamtram.mapping.MappingHintGroupType%&gt; hintGroup = (&lt;%pamtram.mapping.MappingHintGroupType%&gt;) &lt;%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%&gt;.getAncestorOfKind(\r\n\t\t\t\t\t\tsetting.getEObject(), &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING_HINT_GROUP_TYPE);\r\n\t\t\t\t&lt;%pamtram.mapping.Mapping%&gt; mapping = (&lt;%pamtram.mapping.Mapping%&gt;) &lt;%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%&gt;.getAncestorOfKind(setting.getEObject(),\r\n\t\t\t\t\t\t&lt;%pamtram.mapping.MappingPackage%&gt;.Literals.MAPPING);\r\n\r\n\t\t\tif (mapping == null) {\r\n\t\t\t\t\tthrow new RuntimeException(\r\n\t\t\t\t\t\t\t\"Internal error during merging of extends. No containing element of type \'Mapping\' found for element \'\"\r\n\t\t\t\t\t\t\t\t\t+ setting.getEObject() + \"\'!\");\r\n\t\t\t\t}\r\n\r\n\t\t\t// We do not need to handle deactivated\r\n\t\t\t\t// Mappings/MappingHintGroups\r\n\t\t\t\t//\r\n\t\t\t\tif (hintGroup instanceof &lt;%pamtram.DeactivatableElement%&gt;\r\n\t\t\t\t\t\t&amp;&amp; ((&lt;%pamtram.DeactivatableElement%&gt;) hintGroup).isDeactivated() || mapping.isDeactivated()) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\r\n\t\t\tif (setting.getEStructuralFeature()\r\n\t\t\t\t\t\t.equals(&lt;%pamtram.mapping.extended.impl.ExtendedPackageImpl%&gt;.eINSTANCE.getAttributeMatcher_Target())\r\n\t\t\t\t\t\t&amp;&amp; setting.getEObject() instanceof &lt;%pamtram.mapping.extended.AttributeMatcher%&gt;) {\r\n\r\n\t\t\t\t// For AttributeMatchers, we redirect to\r\n\t\t\t\t\t// (the) one concrete attribute which is contained\r\n\t\t\t\t\t// in a &lt;%pamtram.structure.target.TargetSectionClass%&gt; which is a possible\r\n\t\t\t\t\t// target for the &lt;%pamtram.structure.target.TargetSectionCrossReference%&gt;\r\n\t\t\t\t\t// affected by ReferenceTargetSelectors containing\r\n\t\t\t\t\t// this matcher\r\n\t\t\t\t\t//\r\n\t\t\t\t\t&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt; parentSelector = (&lt;%pamtram.mapping.extended.ReferenceTargetSelector%&gt;) setting.getEObject()\r\n\t\t\t\t\t\t\t.eContainer();\r\n\t\t\t\t\t&lt;%pamtram.structure.target.TargetSectionCrossReference%&gt; affectedReference = parentSelector.getAffectedReference();\r\n\r\n\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; concreteTargetSectionAttribute : abstractToConcreteElementMap\r\n\t\t\t\t\t\t\t.get(referencedObject)) {\r\n\t\t\t\t\t\tif (!affectedReference.getValue().isEmpty()) {\r\n\t\t\t\t\t\t\tfor (&lt;%pamtram.structure.target.TargetSectionClass%&gt; targetClass : affectedReference.getValue()) {\r\n\t\t\t\t\t\t\t\tif (targetClass.getAttributes().contains(concreteTargetSectionAttribute)) {\r\n\t\t\t\t\t\t\t\t\tsetting.getEObject().eSet(setting.getEStructuralFeature(),\r\n\t\t\t\t\t\t\t\t\t\t\tconcreteTargetSectionAttribute);\r\n\t\t\t\t\t\t\t\t\tbreak;\r\n\t\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t} else {\r\n\t\t\t\t\t\t\tif (affectedReference.getEReference().getEReferenceType().isSuperTypeOf(\r\n\t\t\t\t\t\t\t\t\t((&lt;%pamtram.structure.target.TargetSectionClass%&gt;) concreteTargetSectionAttribute.eContainer())\r\n\t\t\t\t\t\t\t\t\t\t\t.getEClass())) {\r\n\t\t\t\t\t\t\t\tsetting.getEObject().eSet(setting.getEStructuralFeature(),\r\n\t\t\t\t\t\t\t\t\t\tconcreteTargetSectionAttribute);\r\n\t\t\t\t\t\t\t\tbreak;\r\n\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t}\r\n\r\n\tfor (&lt;%pamtram.mapping.extended.ContainerSelectorTargetAttribute%&gt; mchTargetAttribute : mchTargetAttributesToDelete) {\r\n\t\t\t&lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.delete(mchTargetAttribute);\r\n\t\t}\r\n\t}\r\n}\r\n\r\n/*\r\n * Finally, we can copy the abstract hint groups\r\n \052/\r\n\r\n// collect each abstract hint group as well as the concrete hint groups\r\n// that reference them\r\nHashMap&lt;MappingHintGroupType, LinkedList&lt;&lt;%pamtram.mapping.MappingHintGroupType%&gt;&gt;&gt; abstractToConcreteHintGroupMap = new HashMap&lt;&gt;();\r\nMap&lt;EObject, Collection&lt;&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt;&gt;&gt; mappingSettings = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.CrossReferencer.find(this.getActiveMappings());\r\nfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; element : mappingSettings.keySet()) {\r\n\tif (element instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt; &amp;&amp; ((&lt;%pamtram.mapping.Mapping%&gt;) element.eContainer()).isAbstract()) {\r\n\r\n\t// We do not need to handle deactivated MappingHintGroups\r\n\t\t//\r\n\t\tif (element instanceof &lt;%pamtram.DeactivatableElement%&gt; &amp;&amp; ((&lt;%pamtram.DeactivatableElement%&gt;) element).isDeactivated()\r\n\t\t\t\t|| element.eContainer() instanceof &lt;%pamtram.DeactivatableElement%&gt;\r\n\t\t\t\t\t\t&amp;&amp; ((&lt;%pamtram.DeactivatableElement%&gt;) element.eContainer()).isDeactivated()) {\r\n\t\t\tcontinue;\r\n\t\t}\r\n\r\n\tLinkedList&lt;&lt;%pamtram.mapping.MappingHintGroupType%&gt;&gt; concreteHintGroups = new LinkedList&lt;&gt;();\r\n\t\tfor (&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt; setting : mappingSettings.get(element)) {\r\n\t\t\tif (setting.getEStructuralFeature()\r\n\t\t\t\t\t.equals(&lt;%pamtram.mapping.impl.MappingPackageImpl%&gt;.eINSTANCE.getMappingHintGroupType_Extend())) {\r\n\r\n\t\t\t// only copy hints to activated hint groups\r\n\t\t\t\tif (setting.getEObject() instanceof &lt;%pamtram.DeactivatableElement%&gt;\r\n\t\t\t\t\t\t&amp;&amp; ((&lt;%pamtram.DeactivatableElement%&gt;) setting.getEObject()).isDeactivated()\r\n\t\t\t\t\t\t|| setting.getEObject().eContainer() instanceof &lt;%pamtram.DeactivatableElement%&gt;\r\n\t\t\t\t\t\t\t\t&amp;&amp; ((&lt;%pamtram.DeactivatableElement%&gt;) setting.getEObject().eContainer()).isDeactivated()) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t} else {\r\n\t\t\t\t\tconcreteHintGroups.add((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) setting.getEObject());\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\t\tabstractToConcreteHintGroupMap.put((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) element, concreteHintGroups);\r\n\t}\r\n}\r\n\r\n// copy the contained elements (hints and condition) to the concrete\r\n// hint groups\r\nfor (&lt;%pamtram.mapping.MappingHintGroupType%&gt; abstractHintGroup : abstractToConcreteHintGroupMap.keySet()) {\r\n\tfor (&lt;%pamtram.mapping.MappingHintGroupType%&gt; concreteHintGroup : abstractToConcreteHintGroupMap.get(abstractHintGroup)) {\r\n\r\n\tCollection&lt;&lt;%pamtram.mapping.extended.MappingHintBaseType%&gt;&gt; hintsToCopy = new BasicEList&lt;&gt;();\r\n\t\t/*\r\n\t\t * Collect all hints that will get copied. Those are all mapping hints (including ContainerSelectors)\r\n\t\t * that are not \'overwritten\' by hints of the concrete HintGroup.\r\n\t\t \052/\r\n\t\tfor (&lt;%pamtram.mapping.extended.MappingHint%&gt; abstractHint : abstractHintGroup.getActiveMappingHints()) {\r\n\r\n\t\t// An abstract hint is copied if it is not overwritten\r\n\t\t\t//\r\n\r\n\t\tif (concreteHintGroup.getMappingHints().stream()\r\n\t\t\t\t\t.noneMatch(h -&gt; h.getOverwrite() != null &amp;&amp; h.getOverwrite().equals(abstractHint))) {\r\n\r\n\t\t\thintsToCopy.add(abstractHint);\r\n\t\t\t}\r\n\r\n\t}\r\n\r\n\t// Retrieve a possible condition to be copied\r\n\t\t//\r\n\t\t&lt;%pamtram.condition.ComplexCondition%&gt; condition = null;\r\n\t\tif (abstractHintGroup instanceof &lt;%pamtram.ConditionalElement%&gt;) {\r\n\t\t\tcondition = ((&lt;%pamtram.ConditionalElement%&gt;) abstractHintGroup).getLocalCondition() != null\r\n\t\t\t\t\t? ((&lt;%pamtram.ConditionalElement%&gt;) abstractHintGroup).getLocalCondition()\r\n\t\t\t\t\t: ((&lt;%pamtram.ConditionalElement%&gt;) abstractHintGroup).getSharedCondition();\r\n\t\t}\r\n\t\t&lt;%pamtram.condition.ComplexCondition%&gt; copiedCondition = condition != null ? &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.copy(condition) : null;\r\n\r\n\tCollection&lt;&lt;%pamtram.mapping.extended.MappingHintBaseType%&gt;&gt; copiedHints = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.copyAll(hintsToCopy);\r\n\r\n\t/*\r\n\t\t * make sure that all references to elements from the abstract sections are redirected to the concrete\r\n\t\t * sections that we created earlier\r\n\t\t \052/\r\n\t\tCollection&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; copiedElements = new ArrayList&lt;&gt;(copiedHints);\r\n\t\tif (copiedCondition != null) {\r\n\t\t\tcopiedElements.add(copiedCondition);\r\n\t\t}\r\n\t\tfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; copiedElement : copiedElements) {\r\n\r\n\t\t/*\r\n\t\t\t * these are the references from the copied hint (that will get added to the concrete hint group) to\r\n\t\t\t * elements from abstract sections\r\n\t\t\t \052/\r\n\t\t\tMap&lt;EObject, Collection&lt;&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt;&gt;&gt; refsToAbstractSection = &lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.UsageCrossReferencer\r\n\t\t\t\t\t.findAll(abstractToConcreteElementMap.keySet(), copiedElement);\r\n\t\t\tfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\t\t\t/*\r\n\t\t\t\t * based on the type of hint element that we are handling (local or external), source and target\r\n\t\t\t\t * sections or their containers are checked\r\n\t\t\t\t \052/\r\n\t\t\t\tboolean local = true;\r\n\t\t\t\tif (refsToAbstractSection.get(referencedObject).size() &gt; 1) {\r\n\t\t\t\t\tthrow new RuntimeException(\"Internal Error! The element \'\"\r\n\t\t\t\t\t\t\t+ (copiedElement instanceof &lt;%pamtram.NamedElement%&gt; ? ((&lt;%pamtram.NamedElement%&gt;) copiedElement).getName()\r\n\t\t\t\t\t\t\t\t\t: copiedElement.toString())\r\n\t\t\t\t\t\t\t+ \"\' in the hint group \'\" + abstractHintGroup.getName()\r\n\t\t\t\t\t\t\t+ \"\' holds multiple references to the same object of an abstract section (\'\"\r\n\t\t\t\t\t\t\t+ referencedObject + \"\'.\");\r\n\t\t\t\t}\r\n\t\t\t\tif (refsToAbstractSection.get(referencedObject).iterator().next()\r\n\t\t\t\t\t\t.getEObject() instanceof &lt;%pamtram.structure.ExternalDynamicSourceElement%&gt;) {\r\n\t\t\t\t\tlocal = false;\r\n\t\t\t\t}\r\n\t\t\t\tArrayList&lt;&lt;%pamtram.structure.generic.Section%&gt;&gt; sourceAndTargetSections = new ArrayList&lt;&gt;();\r\n\t\t\t\t&lt;%pamtram.structure.source.SourceSection%&gt; sourceSection = ((&lt;%pamtram.mapping.Mapping%&gt;) concreteHintGroup.eContainer()).getSourceSection();\r\n\t\t\t\tif (local) {\r\n\t\t\t\t\tsourceAndTargetSections.add(sourceSection);\r\n\t\t\t\t} else {\r\n\t\t\t\t\twhile (sourceSection.getContainer() != null) {\r\n\t\t\t\t\t\tsourceSection = sourceSection.getContainer().getContainingSection();\r\n\t\t\t\t\t\tsourceAndTargetSections.add(sourceSection);\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t\t&lt;%pamtram.structure.target.TargetSection%&gt; targetSection = concreteHintGroup.getTargetSection();\r\n\t\t\t\tif (local) {\r\n\t\t\t\t\tsourceAndTargetSections.add(targetSection);\r\n\t\t\t\t} else {\r\n\t\t\t\t\twhile (targetSection.getContainer() != null) {\r\n\t\t\t\t\t\ttargetSection = targetSection.getContainer().getContainingSection();\r\n\t\t\t\t\t\tsourceAndTargetSections.add(targetSection);\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t/*\r\n\t\t\t\t * these are possible targets for the redirection of references to the referenced object\r\n\t\t\t\t \052/\r\n\t\t\t\tLinkedList&lt;&lt;%org.eclipse.emf.ecore.EObject%&gt;&gt; possibleTargets = abstractToConcreteElementMap.get(referencedObject);\r\n\r\n\t\t\tboolean found = false;\r\n\t\t\t\t&lt;%org.eclipse.emf.ecore.EObject%&gt; target = null; // this will contain the new\r\n\t\t\t\t\t\t\t\t\t\t// value for the reference\r\n\t\t\t\tfor (&lt;%org.eclipse.emf.ecore.EObject%&gt; possibleTarget : possibleTargets) {\r\n\t\t\t\t\t&lt;%pamtram.structure.generic.Section%&gt; containingSection = ((&lt;%pamtram.structure.generic.MetaModelElement%&gt;) possibleTarget).getContainingSection();\r\n\t\t\t\t\tif (sourceAndTargetSections.contains(containingSection)) {\r\n\t\t\t\t\t\tif (found == false) {\r\n\t\t\t\t\t\t\tfound = true;\r\n\t\t\t\t\t\t\ttarget = possibleTarget;\r\n\t\t\t\t\t\t} else {\r\n\t\t\t\t\t\t\t// this should not happen, should it?\r\n\t\t\t\t\t\t\tthrow new RuntimeException(\r\n\t\t\t\t\t\t\t\t\t\"Internal error! Multiple targets found for redirection of element \'\"\r\n\t\t\t\t\t\t\t\t\t\t\t+ referencedObject + \"\' in.\");\r\n\t\t\t\t\t\t}\r\n\r\n\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\tif (found == false) {\r\n\t\t\t\t\tthrow new RuntimeException(\"Internal error! No target found for redirection of element \'\"\r\n\t\t\t\t\t\t\t+ referencedObject + \"\'.\");\r\n\t\t\t\t}\r\n\r\n\t\t\tfor (&lt;%org.eclipse.emf.ecore.EStructuralFeature.Setting%&gt; setting : refsToAbstractSection.get(referencedObject)) {\r\n\t\t\t\t\tsetting.set(target);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t}\r\n\r\n\t// Finally, we add the copied hints and condition to the\r\n\t\t// concrete hint group\r\n\t\tconcreteHintGroup.getMappingHints().addAll(0, (Collection&lt;? extends &lt;%pamtram.mapping.extended.MappingHint%&gt;&gt;) copiedHints);\r\n\r\n\tif (copiedCondition != null &amp;&amp; concreteHintGroup instanceof &lt;%pamtram.ConditionalElement%&gt;) {\r\n\t\t\t&lt;%pamtram.ConditionalElement%&gt; concreteHintGroupCast = (&lt;%pamtram.ConditionalElement%&gt;) concreteHintGroup;\r\n\t\t\t// If there is already a condition present in the concrete\r\n\t\t\t// HintGroup, we have to create a new condition that will\r\n\t\t\t// conjunct both conditions\r\n\t\t\t//\r\n\t\t\tif (concreteHintGroupCast.getLocalCondition() != null) {\r\n\t\t\t\t&lt;%pamtram.condition.And%&gt; and = &lt;%pamtram.condition.ConditionFactory%&gt;.eINSTANCE.createAnd();\r\n\t\t\t\tand.getLocalCondParts().add(concreteHintGroupCast.getLocalCondition());\r\n\t\t\t\tand.getLocalCondParts().add(copiedCondition);\r\n\t\t\t\tconcreteHintGroupCast.setLocalCondition(and);\r\n\t\t\t} else if (concreteHintGroupCast.getSharedCondition() != null) {\r\n\t\t\t\t&lt;%pamtram.condition.And%&gt; and = &lt;%pamtram.condition.ConditionFactory%&gt;.eINSTANCE.createAnd();\r\n\t\t\t\tand.getLocalCondParts().add(&lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.copy(concreteHintGroupCast.getSharedCondition()));\r\n\t\t\t\tand.getLocalCondParts().add(copiedCondition);\r\n\t\t\t\tconcreteHintGroupCast.setSharedCondition(null);\r\n\t\t\t\tconcreteHintGroupCast.setLocalCondition(and);\r\n\t\t\t} else {\r\n\t\t\t\tconcreteHintGroupCast.setLocalCondition(copiedCondition);\r\n\t\t\t}\r\n\t\t}\r\n\t}\r\n}\r\n\r\n/*\r\n * At the end, we clear the values of the \'extend\' references of the concrete elements as these are no longer\r\n * needed.\r\n \052/\r\nfor (Entry&lt;Section, LinkedList&lt;&lt;%pamtram.structure.generic.Section%&gt;&gt;&gt; entry : abstractToConcreteSectionMap.entrySet()) {\r\n\tfor (&lt;%pamtram.structure.generic.Section%&gt; concreteSection : entry.getValue()) {\r\n\t\tconcreteSection.getExtend().remove(entry.getKey());\r\n\t}\r\n}\r\nfor (Entry&lt;MappingHintGroupType, LinkedList&lt;&lt;%pamtram.mapping.MappingHintGroupType%&gt;&gt;&gt; entry : abstractToConcreteHintGroupMap\r\n\t\t.entrySet()) {\r\n\tfor (&lt;%pamtram.mapping.MappingHintGroupType%&gt; concreteHintGroup : entry.getValue()) {\r\n\t\tconcreteHintGroup.getExtend().remove(entry.getKey());\r\n\t}\r\n}'"
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
