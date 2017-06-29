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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='List<SourceSection> sourceSections = Stream\r\n\t\t.concat(this.getSourceSectionModels().stream(),\r\n\t\t\t\tthis.getSharedSourceSectionModels().stream())\r\n\t\t.flatMap(s -> s.getSections().stream()).collect(Collectors.toList());\r\nreturn new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTIONS,\r\n\t\tsourceSections.size(), sourceSections.toArray());'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='List<TargetSection> targetSections = Stream\r\n\t\t.concat(this.getTargetSectionModels().stream(),\r\n\t\t\t\tthis.getSharedTargetSectionModels().stream())\r\n\t\t.flatMap(s -> s.getSections().stream()).collect(Collectors.toList());\r\nreturn new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTIONS,\r\n\t\ttargetSections.size(), targetSections.toArray());'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><<%pamtram.mapping.Mapping%>> mappings = <%java.util.stream.Stream%>.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())\r\n\t\t.flatMap(s -> s.getMappings().stream()).collect(Collectors.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.PamtramPackage%>.Literals.PAM_TRA_M__MAPPINGS,\r\n\t\tmappings.size(), mappings.toArray());'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='List<<%pamtram.mapping.Mapping%>> mappings = <%java.util.stream.Stream%>.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())\r\n\t\t.filter(m -> !m.isDeactivated()).flatMap(s -> s.getActiveMappings().stream())\r\n\t\t.filter(m -> m.getSourceSection() == null || !m.getSourceSection().isDeactivated())\r\n\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.PamtramPackage%>.Literals.PAM_TRA_M__ACTIVE_MAPPINGS,\r\n\t\tmappings.size(), mappings.toArray());'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><FixedValue> globalValues = <%java.util.stream.Stream%>.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())\r\n\t\t.flatMap(s -> s.getGlobalValues().stream()).collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.PamtramPackage%>.Literals.PAM_TRA_M__GLOBAL_VALUES,\r\n\t\tglobalValues.size(), globalValues.toArray());'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><GlobalAttribute> globalAttributes = <%java.util.stream.Stream%>.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())\r\n\t\t.flatMap(s -> s.getGlobalAttributes().stream()).collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.PamtramPackage%>.Literals.PAM_TRA_M__GLOBAL_ATTRIBUTES,\r\n\t\tglobalAttributes.size(), globalAttributes.toArray());'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><<%pamtram.mapping.modifier.ValueModifierSet%>> modifierSets = <%java.util.stream.Stream%>.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())\r\n\t\t.flatMap(s -> s.getModifierSets().stream()).collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.PamtramPackage%>.Literals.PAM_TRA_M__MODIFIER_SETS,\r\n\t\tmodifierSets.size(), modifierSets.toArray());'"
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='// TODO handle hierarchical extensions (an extended section extends\r\n// other sections\r\n// TODO implement a more sophisticated merging strategy that takes into\r\n// account overwriting of hints?\r\n\r\n/*\r\n * First, we collect each abstract source and target section as well as\r\n * the concrete sections that reference them\r\n \052/\r\nHashMap<Section, LinkedList<<%pamtram.structure.generic.Section%>>> abstractToConcreteSectionMap = new HashMap<>();\r\nMap<EObject, Collection<<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>>> sourceSettings = <%org.eclipse.emf.ecore.util.EcoreUtil%>.CrossReferencer\r\n\t\t.find(this.getActiveSourceSections());\r\nfor (<%pamtram.structure.generic.Section%> section : this.getActiveSourceSections()) {\r\n\tif (section.isAbstract() && sourceSettings.containsKey(section)) {\r\n\t\tLinkedList<<%pamtram.structure.generic.Section%>> concreteSections = new LinkedList<>();\r\n\t\tfor (<%org.eclipse.emf.ecore.EStructuralFeature.Setting%> setting : sourceSettings.get(section)) {\r\n\t\t\tif (setting.getEStructuralFeature().equals(<%pamtram.structure.generic.impl.GenericPackageImpl%>.eINSTANCE.getSection_Extend())) {\r\n\t\t\t\tconcreteSections.add((<%pamtram.structure.generic.Section%>) setting.getEObject());\r\n\t\t\t}\r\n\t\t}\r\n\t\tabstractToConcreteSectionMap.put(section, concreteSections);\r\n\t}\r\n}\r\nMap<EObject, Collection<<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>>> targetSettings = <%org.eclipse.emf.ecore.util.EcoreUtil%>.CrossReferencer.find(this.getTargetSections());\r\nfor (<%pamtram.structure.generic.Section%> section : this.getTargetSections()) {\r\n\tif (section.isAbstract() && targetSettings.containsKey(section)) {\r\n\t\tLinkedList<<%pamtram.structure.generic.Section%>> concreteSections = new LinkedList<>();\r\n\t\tfor (<%org.eclipse.emf.ecore.EStructuralFeature.Setting%> setting : targetSettings.get(section)) {\r\n\t\t\tif (setting.getEStructuralFeature().equals(<%pamtram.structure.generic.impl.GenericPackageImpl%>.eINSTANCE.getSection_Extend())) {\r\n\t\t\t\tconcreteSections.add((<%pamtram.structure.generic.Section%>) setting.getEObject());\r\n\t\t\t}\r\n\t\t}\r\n\t\tabstractToConcreteSectionMap.put(section, concreteSections);\r\n\t}\r\n}\r\n\r\nArrayList<<%pamtram.mapping.Mapping%>> concreteMappings = new ArrayList<>();\r\nfor (<%pamtram.mapping.Mapping%> mapping : this.getActiveMappings()) {\r\n\tif (!mapping.isAbstract()) {\r\n\t\tconcreteMappings.add(mapping);\r\n\t}\r\n}\r\n\r\n/*\r\n * Now, we copy all elements from the abstract sections to the concrete\r\n * sections that extend them. In this process, we store the associations\r\n * between the elements from the abstract sections and the copied\r\n * elements in a map.\r\n \052/\r\nHashMap<EObject, LinkedList<<%org.eclipse.emf.ecore.EObject%>>> abstractToConcreteElementMap = new HashMap<>();\r\nfor (<%pamtram.structure.generic.Section%> abstractSection : abstractToConcreteSectionMap.keySet()) {\r\n\tfor (<%pamtram.structure.generic.Section%> concreteSection : abstractToConcreteSectionMap.get(abstractSection)) {\r\n\r\n\t<%pamtram.structure.generic.Section%> copiedSection = <%org.eclipse.emf.ecore.util.EcoreUtil%>.copy(abstractSection);\r\n\r\n\tTreeIterator<<%org.eclipse.emf.ecore.EObject%>> originalIterator = <%org.eclipse.emf.ecore.util.EcoreUtil%>\r\n\t\t\t\t.getAllContents(<%java.util.Collections%>.singleton(abstractSection));\r\n\t\tTreeIterator<<%org.eclipse.emf.ecore.EObject%>> copyIterator = <%org.eclipse.emf.ecore.util.EcoreUtil%>.getAllContents(<%java.util.Collections%>.singleton(copiedSection));\r\n\r\n\t// these lists will store the elements that we will add to the\r\n\t\t// concrete section\r\n\t\tArrayList<<%pamtram.structure.generic.Attribute%>> attributesToAdd = new ArrayList<>();\r\n\t\tArrayList<<%pamtram.structure.generic.Reference%>> referencesToAdd = new ArrayList<>();\r\n\r\n\twhile (originalIterator.hasNext()) {\r\n\t\t\tassert copyIterator.hasNext();\r\n\r\n\t\t<%org.eclipse.emf.ecore.EObject%> originalNext = originalIterator.next();\r\n\t\t\t<%org.eclipse.emf.ecore.EObject%> copyNext = copyIterator.next();\r\n\r\n\t\t// if the element is the section itself, we skip it\r\n\t\t\tif (originalNext instanceof <%pamtram.structure.generic.Section%>) {\r\n\t\t\t\tcontinue;\r\n\t\t\t}\r\n\r\n\t\t// if the element is a top-level element below the section,\r\n\t\t\t// we add it to the concrete section\r\n\t\t\tif (originalNext.eContainer().equals(abstractSection)) {\r\n\t\t\t\tif (copyNext instanceof <%pamtram.structure.generic.Attribute%>) {\r\n\t\t\t\t\tattributesToAdd.add((<%pamtram.structure.generic.Attribute%>) copyNext);\r\n\t\t\t\t} else if (copyNext instanceof <%pamtram.structure.generic.Reference%>) {\r\n\t\t\t\t\treferencesToAdd.add((<%pamtram.structure.generic.Reference%>) copyNext);\r\n\t\t\t\t} else {\r\n\t\t\t\t\tthrow new RuntimeException(\"Unsupported element type \'\" + copyNext.eClass().getName()\r\n\t\t\t\t\t\t\t+ \"\' encountered when merging extends!\");\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t\t// in any case, we fill the abstractToConcreteElementMap\r\n\t\t\tLinkedList<<%org.eclipse.emf.ecore.EObject%>> vals = abstractToConcreteElementMap.get(originalNext);\r\n\t\t\tif (vals == null) {\r\n\t\t\t\tvals = new LinkedList<>();\r\n\t\t\t}\r\n\t\t\tvals.add(copyNext);\r\n\t\t\tabstractToConcreteElementMap.put(originalNext, vals);\r\n\t\t}\r\n\r\n\t/*\r\n\t\t * now, we add the collected elements to the concrete section;\r\n\t\t * we have to do this after the process of iterating over the\r\n\t\t * contents - otherwise, the <%org.eclipse.emf.common.util.TreeIterator%> will throw\r\n\t\t * IndexOutOfBoundsExceptions\r\n\t\t \052/\r\n\t\tconcreteSection.getAttributes().addAll(attributesToAdd);\r\n\t\tconcreteSection.getReferences().addAll(referencesToAdd);\r\n\r\n\t/*\r\n\t\t * Now, we redirect references from concrete sections to\r\n\t\t * elements from the abstract section to the (new) elements from\r\n\t\t * the concrete sections.\r\n\t\t \052/\r\n\t\tMap<EObject, Collection<<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>>> refsToAbstractSection = <%org.eclipse.emf.ecore.util.EcoreUtil%>.UsageCrossReferencer\r\n\t\t\t\t.findAll(abstractToConcreteElementMap.keySet(), this.getActiveSourceSections().stream()\r\n\t\t\t\t\t\t.filter(s -> !s.isAbstract()).collect(<%java.util.stream.Collectors%>.toList()));\r\n\t\tfor (<%org.eclipse.emf.ecore.EObject%> referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\t\tfor (<%org.eclipse.emf.ecore.EStructuralFeature.Setting%> setting : refsToAbstractSection.get(referencedObject).stream()\r\n\t\t\t\t\t.filter(s -> !s.getEStructuralFeature().isDerived()).collect(<%java.util.stream.Collectors%>.toList())) {\r\n\r\n\t\t\tif (setting.getEStructuralFeature().equals(<%pamtram.structure.generic.GenericPackage%>.eINSTANCE.getSection_Extend())) {\r\n\t\t\t\t\t// the \'extend\' feature has already been handled\r\n\t\t\t\t\t// above\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\r\n\t\t\t// this is the element referencing the abstract section\r\n\t\t\t\t// (it should be an element of a section)\r\n\t\t\t\t<%org.eclipse.emf.ecore.EObject%> hintElement = setting.getEObject();\r\n\r\n\t\t\tif (setting.getEStructuralFeature().equals(<%pamtram.structure.generic.GenericPackage%>.eINSTANCE.getClass_Container())) {\r\n\t\t\t\t\tif (abstractSection.equals(hintElement) || abstractSection\r\n\t\t\t\t\t\t\t.isContainerFor((pamtram.structure.generic.Class<?, ?, ?, ?>) hintElement)) {\r\n\r\n\t\t\t\t\t// redirect the reference (we can always use the\r\n\t\t\t\t\t\t// \'last\' of the concrete objects as we just\r\n\t\t\t\t\t\t// added it above\r\n\t\t\t\t\t\tsetting.set(abstractToConcreteElementMap.get(referencedObject).getLast());\r\n\t\t\t\t\t}\r\n\r\n\t\t\t} else {\r\n\t\t\t\t\tSystem.out.println(\r\n\t\t\t\t\t\t\t\"Unhandled reference to element of an abstract section. Maybe consider redirecting this?\");\r\n\t\t\t\t}\r\n\r\n\t\t}\r\n\r\n\t}\r\n\r\n\t/*\r\n\t\t * Now, we redirect references from MappingHints to elements\r\n\t\t * from the abstract section to the elements from the concrete\r\n\t\t * sections. Here, we only handle references from concrete\r\n\t\t * mappings as the references from abstract mappings (and thus\r\n\t\t * from extended hint groups) are handled afterwards when these\r\n\t\t * hint groups are copied.\r\n\t\t \052/\r\n\t\trefsToAbstractSection = <%org.eclipse.emf.ecore.util.EcoreUtil%>.UsageCrossReferencer.findAll(abstractToConcreteElementMap.keySet(),\r\n\t\t\t\tconcreteMappings);\r\n\t\tfor (<%org.eclipse.emf.ecore.EObject%> referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\t\tfor (<%org.eclipse.emf.ecore.EStructuralFeature.Setting%> setting : refsToAbstractSection.get(referencedObject)) {\r\n\r\n\t\t\t// this is the element referencing the abstract section\r\n\t\t\t\t// (it should be contained in a <%pamtram.mapping.Mapping%> and be either\r\n\t\t\t\t// part of a MappingHintGroup or of a Condition)\r\n\t\t\t\t//\r\n\t\t\t\t<%pamtram.mapping.MappingHintGroupType%> hintGroup = (<%pamtram.mapping.MappingHintGroupType%>) <%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.getAncestorOfKind(\r\n\t\t\t\t\t\tsetting.getEObject(), <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE);\r\n\t\t\t\t<%pamtram.mapping.Mapping%> mapping = (<%pamtram.mapping.Mapping%>) <%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.getAncestorOfKind(setting.getEObject(),\r\n\t\t\t\t\t\t<%pamtram.mapping.MappingPackage%>.Literals.MAPPING);\r\n\r\n\t\t\tif (mapping == null) {\r\n\t\t\t\t\tthrow new RuntimeException(\r\n\t\t\t\t\t\t\t\"Internal error during merging of extends. No containing element of type \'Mapping\' found for element \'\"\r\n\t\t\t\t\t\t\t\t\t+ setting.getEObject() + \"\'!\");\r\n\t\t\t\t}\r\n\r\n\t\t\t// We do not need to handle deactivated\r\n\t\t\t\t// Mappings/MappingHintGroups\r\n\t\t\t\t//\r\n\t\t\t\tif (hintGroup instanceof <%pamtram.DeactivatableElement%>\r\n\t\t\t\t\t\t&& ((<%pamtram.DeactivatableElement%>) hintGroup).isDeactivated() || mapping.isDeactivated()) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\r\n\t\t\t/*\r\n\t\t\t\t * check if the hint group or its parent mapping equals\r\n\t\t\t\t * the section that we just added the concrete elements\r\n\t\t\t\t * to\r\n\t\t\t\t \052/\r\n\t\t\t\tif (hintGroup != null\r\n\t\t\t\t\t\t&& (concreteSection.equals(hintGroup.getTargetSection())\r\n\t\t\t\t\t\t\t\t|| concreteSection.isContainerFor(hintGroup.getTargetSection()))\r\n\t\t\t\t\t\t|| concreteSection.equals(mapping.getSourceSection())\r\n\t\t\t\t\t\t|| concreteSection.isContainerFor(mapping.getSourceSection())) {\r\n\r\n\t\t\t\tif (setting.getEStructuralFeature()\r\n\t\t\t\t\t\t\t.equals(<%pamtram.structure.impl.StructurePackageImpl%>.eINSTANCE.getDynamicSourceElement_Source())\r\n\t\t\t\t\t\t\t&& setting.getEObject() instanceof <%pamtram.mapping.extended.ContainerSelectorTargetAttribute%>) {\r\n\t\t\t\t\t\t// do nothing as ContainerSelectors are handled\r\n\t\t\t\t\t\t// below separately\r\n\t\t\t\t\t} else {\r\n\t\t\t\t\t\t// redirect the reference (we can always use the\r\n\t\t\t\t\t\t// \'last\' of the concrete objects as we just\r\n\t\t\t\t\t\t// added it above\r\n\t\t\t\t\t\tsetting.set(abstractToConcreteElementMap.get(referencedObject).getLast());\r\n\t\t\t\t\t}\r\n\r\n\t\t\t}\r\n\t\t\t}\r\n\r\n\t}\r\n\r\n}\r\n}\r\n\r\n/*\r\n * Now, we handle the ContainerSelectors that we skipped above. We can\r\n * do this now as we now know all concrete TargetSections that are a\r\n * possible match for each <%pamtram.mapping.extended.ContainerSelector%> that points to an abstract\r\n * <%pamtram.structure.target.TargetSection%>.\r\n \052/\r\nfor (<%pamtram.structure.generic.Section%> abstractSection : abstractToConcreteSectionMap.keySet()) {\r\n\tfor (<%pamtram.structure.generic.Section%> concreteSection : abstractToConcreteSectionMap.get(abstractSection)) {\r\n\t\t/*\r\n\t\t * as ContainerSelectors will get treated differently (see\r\n\t\t * below), we store the ContainerSelectorTargetAttributes\r\n\t\t * holding the references to the Attributes in the abstract\r\n\t\t * section and will delete these later\r\n\t\t \052/\r\n\t\tArrayList<<%pamtram.mapping.extended.ContainerSelectorTargetAttribute%>> mchTargetAttributesToDelete = new ArrayList<>();\r\n\r\n\tMap<EObject, Collection<<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>>> refsToAbstractSection = <%org.eclipse.emf.ecore.util.EcoreUtil%>.UsageCrossReferencer\r\n\t\t\t\t.findAll(abstractToConcreteElementMap.keySet(), concreteMappings);\r\n\t\tfor (<%org.eclipse.emf.ecore.EObject%> referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\t\tfor (<%org.eclipse.emf.ecore.EStructuralFeature.Setting%> setting : refsToAbstractSection.get(referencedObject)) {\r\n\r\n\t\t\t// this is the element referencing the abstract section\r\n\t\t\t\t// (it should be contained in a <%pamtram.mapping.Mapping%> and be either\r\n\t\t\t\t// part of a MappingHintGroup or of a Condition)\r\n\t\t\t\t//\r\n\t\t\t\t<%pamtram.mapping.MappingHintGroupType%> hintGroup = (<%pamtram.mapping.MappingHintGroupType%>) <%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.getAncestorOfKind(\r\n\t\t\t\t\t\tsetting.getEObject(), <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE);\r\n\t\t\t\t<%pamtram.mapping.Mapping%> mapping = (<%pamtram.mapping.Mapping%>) <%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.getAncestorOfKind(setting.getEObject(),\r\n\t\t\t\t\t\t<%pamtram.mapping.MappingPackage%>.Literals.MAPPING);\r\n\r\n\t\t\tif (mapping == null) {\r\n\t\t\t\t\tthrow new RuntimeException(\r\n\t\t\t\t\t\t\t\"Internal error during merging of extends. No containing element of type \'Mapping\' found for element \'\"\r\n\t\t\t\t\t\t\t\t\t+ setting.getEObject() + \"\'!\");\r\n\t\t\t\t}\r\n\r\n\t\t\t// We do not need to handle deactivated\r\n\t\t\t\t// Mappings/MappingHintGroups\r\n\t\t\t\t//\r\n\t\t\t\tif (hintGroup instanceof <%pamtram.DeactivatableElement%>\r\n\t\t\t\t\t\t&& ((<%pamtram.DeactivatableElement%>) hintGroup).isDeactivated() || mapping.isDeactivated()) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\r\n\t\t\t/*\r\n\t\t\t\t * check if the hint group or its parent mapping equals\r\n\t\t\t\t * the section that we just added the concrete elements\r\n\t\t\t\t * to or if we are dealing with a model\r\n\t\t\t\t * <%pamtram.mapping.extended.ContainerSelectorTargetAttribute%>\r\n\t\t\t\t \052/\r\n\t\t\t\tif (setting.getEStructuralFeature()\r\n\t\t\t\t\t\t.equals(<%pamtram.structure.impl.StructurePackageImpl%>.eINSTANCE.getDynamicSourceElement_Source())\r\n\t\t\t\t\t\t&& setting.getEObject() instanceof <%pamtram.mapping.extended.ContainerSelectorTargetAttribute%>) {\r\n\r\n\t\t\t\t// in this case, we must not simply redirect but we\r\n\t\t\t\t\t// create a new <%pamtram.mapping.extended.ContainerSelectorTargetAttribute%>\r\n\t\t\t\t\t<%pamtram.mapping.extended.ContainerSelectorTargetAttribute%> original = (<%pamtram.mapping.extended.ContainerSelectorTargetAttribute%>) setting\r\n\t\t\t\t\t\t\t.getEObject();\r\n\r\n\t\t\t\tfor (<%org.eclipse.emf.ecore.EObject%> concreteTargetSectionAttribute : abstractToConcreteElementMap\r\n\t\t\t\t\t\t\t.get(referencedObject)) {\r\n\t\t\t\t\t\t<%pamtram.mapping.extended.ContainerSelectorTargetAttribute%> copy = <%pamtram.mapping.extended.impl.ExtendedFactoryImpl%>.eINSTANCE\r\n\t\t\t\t\t\t\t\t.createContainerSelectorTargetAttribute();\r\n\t\t\t\t\t\tcopy.setName(original.getName());\r\n\t\t\t\t\t\tcopy.getModifiers().addAll(original.getModifiers());\r\n\t\t\t\t\t\tcopy.setSource((<%pamtram.structure.target.TargetSectionAttribute%>) concreteTargetSectionAttribute);\r\n\r\n\t\t\t\t\t((<%pamtram.mapping.extended.ContainerSelector%>) setting.getEObject().eContainer()).getTargetAttributes().add(copy);\r\n\t\t\t\t\t}\r\n\r\n\t\t\t\tmchTargetAttributesToDelete.add((<%pamtram.mapping.extended.ContainerSelectorTargetAttribute%>) setting.getEObject());\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t}\r\n\r\n\tfor (<%pamtram.mapping.extended.ContainerSelectorTargetAttribute%> mchTargetAttribute : mchTargetAttributesToDelete) {\r\n\t\t\t<%org.eclipse.emf.ecore.util.EcoreUtil%>.delete(mchTargetAttribute);\r\n\t\t}\r\n\t}\r\n}\r\n\r\n/*\r\n * Finally, we can copy the abstract hint groups\r\n \052/\r\n\r\n// collect each abstract hint group as well as the concrete hint groups\r\n// that reference them\r\nHashMap<MappingHintGroupType, LinkedList<<%pamtram.mapping.MappingHintGroupType%>>> abstractToConcreteHintGroupMap = new HashMap<>();\r\nMap<EObject, Collection<<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>>> mappingSettings = <%org.eclipse.emf.ecore.util.EcoreUtil%>.CrossReferencer.find(this.getActiveMappings());\r\nfor (<%org.eclipse.emf.ecore.EObject%> element : mappingSettings.keySet()) {\r\n\tif (element instanceof <%pamtram.mapping.MappingHintGroupType%> && ((<%pamtram.mapping.Mapping%>) element.eContainer()).isAbstract()) {\r\n\r\n\t// We do not need to handle deactivated MappingHintGroups\r\n\t\t//\r\n\t\tif (element instanceof <%pamtram.DeactivatableElement%> && ((<%pamtram.DeactivatableElement%>) element).isDeactivated()\r\n\t\t\t\t|| element.eContainer() instanceof <%pamtram.DeactivatableElement%>\r\n\t\t\t\t\t\t&& ((<%pamtram.DeactivatableElement%>) element.eContainer()).isDeactivated()) {\r\n\t\t\tcontinue;\r\n\t\t}\r\n\r\n\tLinkedList<<%pamtram.mapping.MappingHintGroupType%>> concreteHintGroups = new LinkedList<>();\r\n\t\tfor (<%org.eclipse.emf.ecore.EStructuralFeature.Setting%> setting : mappingSettings.get(element)) {\r\n\t\t\tif (setting.getEStructuralFeature()\r\n\t\t\t\t\t.equals(<%pamtram.mapping.impl.MappingPackageImpl%>.eINSTANCE.getMappingHintGroupType_Extend())) {\r\n\r\n\t\t\t// only copy hints to activated hint groups\r\n\t\t\t\tif (setting.getEObject() instanceof <%pamtram.DeactivatableElement%>\r\n\t\t\t\t\t\t&& ((<%pamtram.DeactivatableElement%>) setting.getEObject()).isDeactivated()\r\n\t\t\t\t\t\t|| setting.getEObject().eContainer() instanceof <%pamtram.DeactivatableElement%>\r\n\t\t\t\t\t\t\t\t&& ((<%pamtram.DeactivatableElement%>) setting.getEObject().eContainer()).isDeactivated()) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t} else {\r\n\t\t\t\t\tconcreteHintGroups.add((<%pamtram.mapping.MappingHintGroupType%>) setting.getEObject());\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\t\tabstractToConcreteHintGroupMap.put((<%pamtram.mapping.MappingHintGroupType%>) element, concreteHintGroups);\r\n\t}\r\n}\r\n\r\n// copy the contained elements (hints and condition) to the concrete\r\n// hint groups\r\nfor (<%pamtram.mapping.MappingHintGroupType%> abstractHintGroup : abstractToConcreteHintGroupMap.keySet()) {\r\n\tfor (<%pamtram.mapping.MappingHintGroupType%> concreteHintGroup : abstractToConcreteHintGroupMap.get(abstractHintGroup)) {\r\n\r\n\tCollection<<%pamtram.mapping.extended.MappingHintBaseType%>> hintsToCopy = new BasicEList<>();\r\n\t\t/*\r\n\t\t * Collect all hints that will get copied. Those are all mapping\r\n\t\t * hints (including ContainerSelectors) that are not\r\n\t\t * \'overwritten\' by hints of the concrete HintGroup.\r\n\t\t \052/\r\n\t\tfor (<%pamtram.mapping.extended.MappingHint%> abstractHint : abstractHintGroup.getActiveMappingHints()) {\r\n\t\t\t<%org.eclipse.emf.ecore.EObject%> hintTarget = null;\r\n\t\t\tif (abstractHint instanceof <%pamtram.mapping.extended.AttributeMapping%>) {\r\n\t\t\t\thintTarget = ((<%pamtram.mapping.extended.AttributeMapping%>) abstractHint).getTarget();\r\n\t\t\t} else if (abstractHint instanceof <%pamtram.mapping.extended.ReferenceTargetSelector%>) {\r\n\t\t\t\thintTarget = ((<%pamtram.mapping.extended.ReferenceTargetSelector%>) abstractHint).getAffectedReference();\r\n\t\t\t} else if (abstractHint instanceof <%pamtram.mapping.extended.CardinalityMapping%>) {\r\n\t\t\t\thintTarget = ((<%pamtram.mapping.extended.CardinalityMapping%>) abstractHint).getTarget();\r\n\t\t\t} else if (abstractHint instanceof <%pamtram.mapping.extended.ContainerSelector%>) {\r\n\t\t\t\t// nothing to do as ContainerSelectorTargetAttributes\r\n\t\t\t\t// are handled separately\r\n\t\t\t} else {\r\n\t\t\t\tthrow new RuntimeException(\"Unsupported hint type \'\" + abstractHint.eClass().getName()\r\n\t\t\t\t\t\t+ \"\' in HintGroup \'\" + abstractHintGroup.getName()\r\n\t\t\t\t\t\t+ \"\': These kind of hints are not supported yet in abstract HintGroups!\");\r\n\t\t\t}\r\n\r\n\t\t// An abstract hint is not overwritten (and may thus get\r\n\t\t\t// copied) if...\r\n\t\t\t//\r\n\t\t\t// ... there are either no concrete hints at all...\r\n\t\t\tif (concreteHintGroup.getMappingHints().isEmpty()\r\n\t\t\t\t\t// ... or if there are are no hints with the same\r\n\t\t\t\t\t// target element ...\r\n\t\t\t\t\t|| <%org.eclipse.emf.ecore.util.EcoreUtil%>.UsageCrossReferencer\r\n\t\t\t\t\t\t\t.find(hintTarget, concreteHintGroup.getActiveMappingHints()).isEmpty()\r\n\t\t\t\t\t\t\t// ... and no hints with a target elements\r\n\t\t\t\t\t\t\t// that extends the target element of the\r\n\t\t\t\t\t\t\t// abstract hint\r\n\t\t\t\t\t\t\t&& (abstractToConcreteElementMap.get(hintTarget) == null\r\n\t\t\t\t\t\t\t\t\t|| abstractToConcreteElementMap.get(hintTarget).isEmpty()\r\n\t\t\t\t\t\t\t\t\t|| <%org.eclipse.emf.ecore.util.EcoreUtil%>.UsageCrossReferencer\r\n\t\t\t\t\t\t\t\t\t\t\t.findAll(abstractToConcreteElementMap.get(hintTarget),\r\n\t\t\t\t\t\t\t\t\t\t\t\t\tconcreteHintGroup.getActiveMappingHints())\r\n\t\t\t\t\t\t\t\t\t\t\t.isEmpty())) {\r\n\r\n\t\t\thintsToCopy.add(abstractHint);\r\n\t\t\t}\r\n\r\n\t}\r\n\r\n\t// Retrieve a possible condition to be copied\r\n\t\t//\r\n\t\t<%pamtram.condition.ComplexCondition%> condition = null;\r\n\t\tif (abstractHintGroup instanceof <%pamtram.ConditionalElement%>) {\r\n\t\t\tcondition = ((<%pamtram.ConditionalElement%>) abstractHintGroup).getLocalCondition() != null\r\n\t\t\t\t\t? ((<%pamtram.ConditionalElement%>) abstractHintGroup).getLocalCondition()\r\n\t\t\t\t\t: ((<%pamtram.ConditionalElement%>) abstractHintGroup).getSharedCondition();\r\n\t\t}\r\n\t\t<%pamtram.condition.ComplexCondition%> copiedCondition = condition != null ? <%org.eclipse.emf.ecore.util.EcoreUtil%>.copy(condition) : null;\r\n\r\n\tCollection<<%pamtram.mapping.extended.MappingHintBaseType%>> copiedHints = <%org.eclipse.emf.ecore.util.EcoreUtil%>.copyAll(hintsToCopy);\r\n\r\n\t/*\r\n\t\t * make sure that all references to elements from the abstract\r\n\t\t * sections are redirected to the concrete sections that we\r\n\t\t * created earlier\r\n\t\t \052/\r\n\t\tCollection<<%org.eclipse.emf.ecore.EObject%>> copiedElements = new ArrayList<>(copiedHints);\r\n\t\tif (copiedCondition != null) {\r\n\t\t\tcopiedElements.add(copiedCondition);\r\n\t\t}\r\n\t\tfor (<%org.eclipse.emf.ecore.EObject%> copiedElement : copiedElements) {\r\n\r\n\t\t/*\r\n\t\t\t * these are the references from the copied hint (that will\r\n\t\t\t * get added to the concrete hint group) to elements from\r\n\t\t\t * abstract sections\r\n\t\t\t \052/\r\n\t\t\tMap<EObject, Collection<<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>>> refsToAbstractSection = <%org.eclipse.emf.ecore.util.EcoreUtil%>.UsageCrossReferencer\r\n\t\t\t\t\t.findAll(abstractToConcreteElementMap.keySet(), copiedElement);\r\n\t\t\tfor (<%org.eclipse.emf.ecore.EObject%> referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\t\t\t/*\r\n\t\t\t\t * based on the type of hint element that we are\r\n\t\t\t\t * handling (local or external), source and target\r\n\t\t\t\t * sections or their containers are checked\r\n\t\t\t\t \052/\r\n\t\t\t\tboolean local = true;\r\n\t\t\t\tif (refsToAbstractSection.get(referencedObject).size() > 1) {\r\n\t\t\t\t\tthrow new RuntimeException(\"Internal Error! The element \'\"\r\n\t\t\t\t\t\t\t+ (copiedElement instanceof <%pamtram.NamedElement%> ? ((<%pamtram.NamedElement%>) copiedElement).getName()\r\n\t\t\t\t\t\t\t\t\t: copiedElement.toString())\r\n\t\t\t\t\t\t\t+ \"\' in the hint group \'\" + abstractHintGroup.getName()\r\n\t\t\t\t\t\t\t+ \"\' holds multiple references to the same object of an abstract section (\'\"\r\n\t\t\t\t\t\t\t+ referencedObject + \"\'.\");\r\n\t\t\t\t}\r\n\t\t\t\tif (refsToAbstractSection.get(referencedObject).iterator().next()\r\n\t\t\t\t\t\t.getEObject() instanceof <%pamtram.structure.ExternalDynamicSourceElement%>) {\r\n\t\t\t\t\tlocal = false;\r\n\t\t\t\t}\r\n\t\t\t\tArrayList<<%pamtram.structure.generic.Section%>> sourceAndTargetSections = new ArrayList<>();\r\n\t\t\t\t<%pamtram.structure.source.SourceSection%> sourceSection = ((<%pamtram.mapping.Mapping%>) concreteHintGroup.eContainer()).getSourceSection();\r\n\t\t\t\tif (local) {\r\n\t\t\t\t\tsourceAndTargetSections.add(sourceSection);\r\n\t\t\t\t} else {\r\n\t\t\t\t\twhile (sourceSection.getContainer() != null) {\r\n\t\t\t\t\t\tsourceSection = sourceSection.getContainer().getContainingSection();\r\n\t\t\t\t\t\tsourceAndTargetSections.add(sourceSection);\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t\t<%pamtram.structure.target.TargetSection%> targetSection = concreteHintGroup.getTargetSection();\r\n\t\t\t\tif (local) {\r\n\t\t\t\t\tsourceAndTargetSections.add(targetSection);\r\n\t\t\t\t} else {\r\n\t\t\t\t\twhile (targetSection.getContainer() != null) {\r\n\t\t\t\t\t\ttargetSection = targetSection.getContainer().getContainingSection();\r\n\t\t\t\t\t\tsourceAndTargetSections.add(targetSection);\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t/*\r\n\t\t\t\t * these are possible targets for the redirection of\r\n\t\t\t\t * references to the referenced object\r\n\t\t\t\t \052/\r\n\t\t\t\tLinkedList<<%org.eclipse.emf.ecore.EObject%>> possibleTargets = abstractToConcreteElementMap.get(referencedObject);\r\n\r\n\t\t\tboolean found = false;\r\n\t\t\t\t<%org.eclipse.emf.ecore.EObject%> target = null; // this will contain the new\r\n\t\t\t\t\t\t\t\t\t\t// value for the reference\r\n\t\t\t\tfor (<%org.eclipse.emf.ecore.EObject%> possibleTarget : possibleTargets) {\r\n\t\t\t\t\t<%pamtram.structure.generic.Section%> containingSection = ((<%pamtram.structure.generic.MetaModelElement%>) possibleTarget).getContainingSection();\r\n\t\t\t\t\tif (sourceAndTargetSections.contains(containingSection)) {\r\n\t\t\t\t\t\tif (found == false) {\r\n\t\t\t\t\t\t\tfound = true;\r\n\t\t\t\t\t\t\ttarget = possibleTarget;\r\n\t\t\t\t\t\t} else {\r\n\t\t\t\t\t\t\t// this should not happen, should it?\r\n\t\t\t\t\t\t\tthrow new RuntimeException(\r\n\t\t\t\t\t\t\t\t\t\"Internal error! Multiple targets found for redirection of element \'\"\r\n\t\t\t\t\t\t\t\t\t\t\t+ referencedObject + \"\' in.\");\r\n\t\t\t\t\t\t}\r\n\r\n\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\tif (found == false) {\r\n\t\t\t\t\tthrow new RuntimeException(\"Internal error! No target found for redirection of element \'\"\r\n\t\t\t\t\t\t\t+ referencedObject + \"\'.\");\r\n\t\t\t\t}\r\n\r\n\t\t\tfor (<%org.eclipse.emf.ecore.EStructuralFeature.Setting%> setting : refsToAbstractSection.get(referencedObject)) {\r\n\t\t\t\t\tsetting.set(target);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t}\r\n\r\n\t// Finally, we add the copied hints and condition to the\r\n\t\t// concrete hint group\r\n\t\tfor (<%pamtram.mapping.extended.MappingHintBaseType%> copiedHint : copiedHints) {\r\n\t\t\tconcreteHintGroup.getMappingHints().add((<%pamtram.mapping.extended.MappingHint%>) copiedHint);\r\n\t\t}\r\n\t\tif (copiedCondition != null && concreteHintGroup instanceof <%pamtram.ConditionalElement%>) {\r\n\t\t\t<%pamtram.ConditionalElement%> concreteHintGroupCast = (<%pamtram.ConditionalElement%>) concreteHintGroup;\r\n\t\t\t// If there is already a condition present in the concrete\r\n\t\t\t// HintGroup, we have to create a new condition that will\r\n\t\t\t// conjunct both conditions\r\n\t\t\t//\r\n\t\t\tif (concreteHintGroupCast.getLocalCondition() != null) {\r\n\t\t\t\t<%pamtram.condition.And%> and = <%pamtram.condition.ConditionFactory%>.eINSTANCE.createAnd();\r\n\t\t\t\tand.getLocalCondParts().add(concreteHintGroupCast.getLocalCondition());\r\n\t\t\t\tand.getLocalCondParts().add(copiedCondition);\r\n\t\t\t\tconcreteHintGroupCast.setLocalCondition(and);\r\n\t\t\t} else if (concreteHintGroupCast.getSharedCondition() != null) {\r\n\t\t\t\t<%pamtram.condition.And%> and = <%pamtram.condition.ConditionFactory%>.eINSTANCE.createAnd();\r\n\t\t\t\tand.getLocalCondParts().add(<%org.eclipse.emf.ecore.util.EcoreUtil%>.copy(concreteHintGroupCast.getSharedCondition()));\r\n\t\t\t\tand.getLocalCondParts().add(copiedCondition);\r\n\t\t\t\tconcreteHintGroupCast.setSharedCondition(null);\r\n\t\t\t\tconcreteHintGroupCast.setLocalCondition(and);\r\n\t\t\t} else {\r\n\t\t\t\tconcreteHintGroupCast.setLocalCondition(copiedCondition);\r\n\t\t\t}\r\n\t\t}\r\n\t}\r\n}\r\n\r\n/*\r\n * At the end, we clear the values of the \'extend\' references of the\r\n * concrete elements as these are no longer needed.\r\n \052/\r\nfor (Entry<Section, LinkedList<<%pamtram.structure.generic.Section%>>> entry : abstractToConcreteSectionMap.entrySet()) {\r\n\tfor (<%pamtram.structure.generic.Section%> concreteSection : entry.getValue()) {\r\n\t\tconcreteSection.getExtend().remove(entry.getKey());\r\n\t}\r\n}\r\nfor (Entry<MappingHintGroupType, LinkedList<<%pamtram.mapping.MappingHintGroupType%>>> entry : abstractToConcreteHintGroupMap\r\n\t\t.entrySet()) {\r\n\tfor (<%pamtram.mapping.MappingHintGroupType%> concreteHintGroup : entry.getValue()) {\r\n\t\tconcreteHintGroup.getExtend().remove(entry.getKey());\r\n\t}\r\n}'"
	 * @generated
	 */
	void mergeExtends();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Object[] sourceSectionModels = Stream.concat(this.getSourceSectionModels().stream(), this.getSharedSourceSectionModels().stream()).filter(s -> !s.isDeactivated()).toArray();\r\nreturn new <%org.eclipse.emf.common.util.BasicEList%>.UnmodifiableEList<>(sourceSectionModels.length, sourceSectionModels);'"
	 * @generated
	 */
	EList<SourceSectionModel> getActiveSourceSectionModels();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Object[] sourceSections = getActiveSourceSectionModels().stream().flatMap(s -> s.getSections().stream()).filter(s -> !s.isDeactivated()).toArray();\r\nreturn new <%org.eclipse.emf.common.util.BasicEList%>.UnmodifiableEList<>(sourceSections.length, sourceSections);'"
	 * @generated
	 */
	EList<SourceSection> getActiveSourceSections();

} // PAMTraM
