/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import pamtram.structure.source.SourceSection;
import pamtram.structure.target.TargetSection;
import pamtram.mapping.Mapping;
import pamtram.mapping.modifier.ValueModifierSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PAM Tra M</b></em>'.
 * <!-- end-user-doc -->
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='List<SourceSection> sourceSections = Stream\r\n\t\t.concat(this.getSourceSectionModels().parallelStream(),\r\n\t\t\t\tthis.getSharedSourceSectionModels().parallelStream())\r\n\t\t.flatMap(s -> s.getSections().parallelStream()).collect(Collectors.toList());\r\nreturn new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTIONS,\r\n\t\tsourceSections.size(), sourceSections.toArray());'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='List<TargetSection> targetSections = Stream\r\n\t\t.concat(this.getTargetSectionModels().parallelStream(),\r\n\t\t\t\tthis.getSharedTargetSectionModels().parallelStream())\r\n\t\t.flatMap(s -> s.getSections().parallelStream()).collect(Collectors.toList());\r\nreturn new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTIONS,\r\n\t\ttargetSections.size(), targetSections.toArray());'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><<%pamtram.mapping.Mapping%>> mappings = <%java.util.stream.Stream%>.concat(this.getMappingModels().parallelStream(), this.getSharedMappingModels().parallelStream())\r\n\t\t.flatMap(s -> s.getMappings().parallelStream()).collect(Collectors.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.PamtramPackage%>.Literals.PAM_TRA_M__MAPPINGS,\r\n\t\tmappings.size(), mappings.toArray());'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='List<Mapping> mappings = <%java.util.stream.Stream%>.concat(this.getMappingModels().parallelStream(), this.getSharedMappingModels().parallelStream()).filter(m -> !m.isDeactivated())\r\n\t\t.flatMap(s -> s.getActiveMappings().parallelStream()).collect(Collectors.toList());\r\nreturn new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__ACTIVE_MAPPINGS,\r\n\t\tmappings.size(), mappings.toArray());'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><FixedValue> globalValues = <%java.util.stream.Stream%>.concat(this.getMappingModels().parallelStream(), this.getSharedMappingModels().parallelStream())\r\n\t\t.flatMap(s -> s.getGlobalValues().parallelStream()).collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.PamtramPackage%>.Literals.PAM_TRA_M__GLOBAL_VALUES,\r\n\t\tglobalValues.size(), globalValues.toArray());'"
	 * @generated
	 */
	EList<FixedValue> getGlobalValues();

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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><<%pamtram.mapping.modifier.ValueModifierSet%>> modifierSets = <%java.util.stream.Stream%>.concat(this.getMappingModels().parallelStream(), this.getSharedMappingModels().parallelStream())\r\n\t\t.flatMap(s -> s.getModifierSets().parallelStream()).collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.PamtramPackage%>.Literals.PAM_TRA_M__MODIFIER_SETS,\r\n\t\tmodifierSets.size(), modifierSets.toArray());'"
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
	 * @return the value of the '<em>Shared Condition Models</em>' reference list.
	 * @see pamtram.PamtramPackage#getPAMTraM_SharedConditionModels()
	 * @model
	 * @generated
	 */
	EList<ConditionModel> getSharedConditionModels();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='//TODO handle hierarchical extensions (an extended section extends other sections\r\n//TODO implement a more sophisticated merging strategy that takes into account overwriting of hints?\r\n\r\n/*\r\n * First, we collect each abstract source and target section as well as the concrete sections that\r\n * reference them\r\n \052/\r\nHashMap<Section, LinkedList<Section>> abstractToConcreteSectionMap = new HashMap<>();\r\nMap<EObject, Collection<Setting>> sourceSettings = EcoreUtil.CrossReferencer.find(getSourceSections());\r\nfor (Section section : getSourceSections()) {\r\n\tif(section.isAbstract() && sourceSettings.containsKey(section)) {\r\n\t\tLinkedList<Section> concreteSections = new LinkedList<>();\r\n\t\tfor (Setting setting : sourceSettings.get(section)) {\r\n\t\t\tif(setting.getEStructuralFeature().equals(<%pamtram.structure.generic.impl.GenericPackageImpl%>.eINSTANCE.getSection_Extend())) {\r\n\t\t\t\tconcreteSections.add((Section) setting.getEObject());\r\n\t\t\t}\r\n\t\t}\r\n\t\tabstractToConcreteSectionMap.put(section, concreteSections);\r\n\t}\r\n}\r\nMap<EObject, Collection<Setting>> targetSettings = EcoreUtil.CrossReferencer.find(getTargetSections());\r\nfor (Section section : getTargetSections()) {\r\n\tif(section.isAbstract() && targetSettings.containsKey(section)) {\r\n\t\tLinkedList<Section> concreteSections = new LinkedList<>();\r\n\t\tfor (Setting setting : targetSettings.get(section)) {\r\n\t\t\tif(setting.getEStructuralFeature().equals(GenericPackageImpl.eINSTANCE.getSection_Extend())) {\r\n\t\t\t\tconcreteSections.add((Section) setting.getEObject());\r\n\t\t\t}\r\n\t\t}\r\n\t\tabstractToConcreteSectionMap.put(section, concreteSections);\r\n\t}\r\n}\r\n\r\nArrayList<Mapping> concreteMappings = new ArrayList<>();\r\nfor (Mapping mapping : getActiveMappings()) {\r\n\tif(!mapping.isAbstract()) {\r\n\t\tconcreteMappings.add(mapping);\r\n\t}\r\n}\r\n\r\n/*\r\n * Now, we copy all elements from the abstract sections to the concrete sections\r\n * that extend them. In this process, we store the associations between the elements from\r\n * the abstract sections and the copied elements in a map.\r\n \052/\r\nHashMap<EObject, LinkedList<EObject>> abstractToConcreteElementMap = new HashMap<>();\r\nfor (Section abstractSection : abstractToConcreteSectionMap.keySet()) {\r\n\tfor (Section concreteSection : abstractToConcreteSectionMap.get(abstractSection)) {\r\n\r\n\t\tSection copiedSection = EcoreUtil.copy(abstractSection);\r\n\r\n\t\tTreeIterator<EObject> originalIterator = EcoreUtil.getAllContents(Collections.singleton(abstractSection));\r\n\t\tTreeIterator<EObject> copyIterator = EcoreUtil.getAllContents(Collections.singleton(copiedSection));\r\n\r\n\t\t// these lists will store the elements that we will add to the concrete section\r\n\t\tArrayList<Attribute> attributesToAdd = new ArrayList<>();\r\n\t\tArrayList<Reference> referencesToAdd = new ArrayList<>();\r\n\r\n\t\twhile(originalIterator.hasNext()) {\r\n\t\t\tassert copyIterator.hasNext();\r\n\r\n\t\t\tEObject originalNext = originalIterator.next();\r\n\t\t\tEObject copyNext = copyIterator.next();\r\n\r\n\t\t\t// if the element is the section itself, we skip it\r\n\t\t\tif(originalNext instanceof Section) {\r\n\t\t\t\tcontinue;\r\n\t\t\t}\r\n\r\n\t\t\t// if the element is a top-level element below the section, we add it to the concrete section\r\n\t\t\tif(originalNext.eContainer().equals(abstractSection)) {\r\n\t\t\t\tif(copyNext instanceof Attribute) {\r\n\t\t\t\t\tattributesToAdd.add((Attribute) copyNext);\r\n\t\t\t\t} else if(copyNext instanceof Reference) {\r\n\t\t\t\t\treferencesToAdd.add((Reference) copyNext);\r\n\t\t\t\t} else {\r\n\t\t\t\t\tthrow new RuntimeException(\"Unsupported element type \'\" + copyNext.eClass().getName() + \"\' encountered when merging extends!\");\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t\t\t// in any case, we fill the abstractToConcreteElementMap\r\n\t\t\tLinkedList<EObject> vals = abstractToConcreteElementMap.get(originalNext);\r\n\t\t\tif(vals == null) {\r\n\t\t\t\tvals = new LinkedList<>();\r\n\t\t\t}\r\n\t\t\tvals.add(copyNext);\r\n\t\t\tabstractToConcreteElementMap.put(originalNext, vals);\r\n\r\n\t\t\t//TODO do we need to redirect references to these elements???\r\n\t\t}\r\n\r\n\t\t/*\r\n\t\t * now, we add the collected elements to the concrete section; we have to do this\r\n\t\t * after the process of iterating over the contents - otherwise, the TreeIterator will throw\r\n\t\t * IndexOutOfBoundsExceptions\r\n\t\t \052/\r\n\t\tconcreteSection.getAttributes().addAll(attributesToAdd);\r\n\t\tconcreteSection.getReferences().addAll(referencesToAdd);\r\n\r\n\r\n\t\t/*\r\n\t\t * Now, we redirect references from MappingHints to elements from the abstract section to the elements from the concrete sections. \r\n\t\t * Here, we only handle references from concrete mappings as the references from abstract mappings (and thus from extended hint\r\n\t\t * groups) are handled afterwards when these hint groups are copied.\r\n\t\t \052/\r\n\t\tMap<EObject, Collection<Setting>> refsToAbstractSection = EcoreUtil.UsageCrossReferencer.findAll(abstractToConcreteElementMap.keySet(), concreteMappings);\r\n\t\tfor (EObject referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\r\n\t\t\tfor (Setting setting : refsToAbstractSection.get(referencedObject)) {\r\n\r\n\t\t\t\t// this is the element referencing the abstract section (it should be an element of a mapping hint)\r\n\t\t\t\tEObject hintElement = setting.getEObject().eContainer();\r\n\t\t\t\tMappingHintGroupType hintGroup = null;\r\n\t\t\t\tif(hintElement instanceof MappingHintGroupType) {\r\n\t\t\t\t\thintGroup = (MappingHintGroupType) hintElement;\r\n\t\t\t\t} else if(hintElement.eContainer() instanceof MappingHintGroupType) {\r\n\t\t\t\t\thintGroup = (MappingHintGroupType) hintElement.eContainer();\r\n\t\t\t\t} else {\r\n\t\t\t\t\thintGroup = (MappingHintGroupType) hintElement.eContainer().eContainer();\r\n\t\t\t\t}\r\n\t\t\t\t\r\n\t\t\t\t// We do not need to handle deactivated Mappings/MappingHintGroups\r\n\t\t\t\t//\r\n\t\t\t\tif(hintGroup instanceof DeactivatableElement && ((DeactivatableElement) hintGroup).isDeactivated() ||\r\n\t\t\t\t\t\thintGroup.eContainer() instanceof DeactivatableElement && ((DeactivatableElement) hintGroup.eContainer()).isDeactivated()) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\r\n\t\t\t\t/* \r\n\t\t\t\t * check if the hint group or its parent mapping equals the section that we just added the concrete elements to\r\n\t\t\t\t \052/\r\n\t\t\t\tif(concreteSection.equals(hintGroup.getTargetSection()) || \r\n\t\t\t\t\t\tconcreteSection.isContainerFor(hintGroup.getTargetSection()) ||\r\n\t\t\t\t\t\tconcreteSection.equals(((Mapping) hintGroup.eContainer()).getSourceSection()) || \r\n\t\t\t\t\t\tconcreteSection.isContainerFor(((Mapping) hintGroup.eContainer()).getSourceSection())) {\r\n\r\n\t\t\t\t\tif(setting.getEStructuralFeature().equals(<%pamtram.structure.impl.StructurePackageImpl%>.eINSTANCE.getModifiedAttributeElementType_Source()) && \r\n\t\t\t\t\t\t\tsetting.getEObject() instanceof ContainerSelectorTargetAttribute) {\r\n\t\t\t\t\t\t// do nothing as ContainerSelectors are handled below separately\r\n\t\t\t\t\t} else {\r\n\t\t\t\t\t\t// redirect the reference (we can always use the \'last\' of the concrete objects as we just added it above\r\n\t\t\t\t\t\tsetting.set(abstractToConcreteElementMap.get(referencedObject).getLast());\r\n\t\t\t\t\t}\r\n\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t\t}\r\n\r\n\t}\r\n}\r\n\r\n/*\r\n * Now, we handle the ContainerSelectors that we skipped above. We can do this now as we now know all concrete TargetSections that\r\n * are a possible match for each ContainerSelector that points to an abstract TargetSection.\r\n \052/\r\nfor (Section abstractSection : abstractToConcreteSectionMap.keySet()) {\r\n\tfor (Section concreteSection : abstractToConcreteSectionMap.get(abstractSection)) {\r\n\t\t/*\r\n\t\t * as ContainerSelectors will get treated differently (see below), we store the ContainerSelectorTargetAttributes\r\n\t\t * holding the referneces to the Attributes in the abstract section and will delete these later\r\n\t\t \052/\r\n\t\tArrayList<ContainerSelectorTargetAttribute> mchTargetAttributesToDelete = new ArrayList<>();\r\n\r\n\t\tMap<EObject, Collection<Setting>> refsToAbstractSection = EcoreUtil.UsageCrossReferencer.findAll(abstractToConcreteElementMap.keySet(), concreteMappings);\r\n\t\tfor (EObject referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\r\n\t\t\tfor (Setting setting : refsToAbstractSection.get(referencedObject)) {\r\n\r\n\t\t\t\t// this is the element referencing the abstract section (it should be an element of a mapping hint)\r\n\t\t\t\tEObject hintElement = setting.getEObject().eContainer();\r\n\t\t\t\tMappingHintGroupType hintGroup = null;\r\n\t\t\t\tif(hintElement instanceof MappingHintGroupType) {\r\n\t\t\t\t\thintGroup = (MappingHintGroupType) hintElement;\r\n\t\t\t\t} else if(hintElement.eContainer() instanceof MappingHintGroupType) {\r\n\t\t\t\t\thintGroup = (MappingHintGroupType) hintElement.eContainer();\r\n\t\t\t\t} else {\r\n\t\t\t\t\thintGroup = (MappingHintGroupType) hintElement.eContainer().eContainer();\r\n\t\t\t\t}\r\n\t\t\t\t\r\n\t\t\t\t// We do not need to handle deactivated Mappings/MappingHintGroups\r\n\t\t\t\t//\r\n\t\t\t\tif(hintGroup instanceof DeactivatableElement && ((DeactivatableElement) hintGroup).isDeactivated() ||\r\n\t\t\t\t\t\thintGroup.eContainer() instanceof DeactivatableElement && ((DeactivatableElement) hintGroup.eContainer()).isDeactivated()) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\r\n\t\t\t\t/* \r\n\t\t\t\t * check if the hint group or its parent mapping equals the section that we just added the concrete elements to or\r\n\t\t\t\t * if we are dealing with a model ContainerSelectorTargetAttribute\r\n\t\t\t\t \052/\r\n\t\t\t\tif(setting.getEStructuralFeature().equals(StructurePackageImpl.eINSTANCE.getModifiedAttributeElementType_Source()) && \r\n\t\t\t\t\t\tsetting.getEObject() instanceof ContainerSelectorTargetAttribute) {\r\n\r\n\t\t\t\t\t// in this case, we must not simply redirect but we create a new ContainerSelectorTargetAttribute\r\n\t\t\t\t\tContainerSelectorTargetAttribute original = (ContainerSelectorTargetAttribute) setting.getEObject();\r\n\r\n\t\t\t\t\tfor (EObject concreteTargetSectionAttribute : abstractToConcreteElementMap.get(referencedObject)) {\r\n\t\t\t\t\t\tContainerSelectorTargetAttribute copy = <%pamtram.mapping.impl.MappingFactoryImpl%>.eINSTANCE.createContainerSelectorTargetAttribute();\r\n\t\t\t\t\t\tcopy.setName(original.getName());\r\n\t\t\t\t\t\tcopy.getModifier().addAll(original.getModifier());\r\n\t\t\t\t\t\tcopy.setSource((TargetSectionAttribute) concreteTargetSectionAttribute);\r\n\r\n\t\t\t\t\t\t((ContainerSelector) (setting.getEObject().eContainer())).getTargetAttributes().add(copy);\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t}\r\n\r\n\r\n\t\t\t\t\tmchTargetAttributesToDelete.add((ContainerSelectorTargetAttribute) setting.getEObject());\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t\t}\r\n\r\n\t\tfor (ContainerSelectorTargetAttribute mchTargetAttribute : mchTargetAttributesToDelete) {\r\n\t\t\tEcoreUtil.delete(mchTargetAttribute);\r\n\t\t}\r\n\t}\r\n}\r\n\r\n/*\r\n * Finally, we can copy the abstract hint groups\r\n \052/\r\n\r\n// collect each abstract hint group as well as the concrete hint groups that reference them\r\nHashMap<MappingHintGroupType, LinkedList<MappingHintGroupType>> abstractToConcreteHintGroupMap = new HashMap<>();\r\nMap<EObject, Collection<Setting>> mappingSettings = EcoreUtil.CrossReferencer.find(getActiveMappings());\r\nfor (EObject element : mappingSettings.keySet()) {\r\n\tif(element instanceof MappingHintGroupType && ((Mapping)(element.eContainer())).isAbstract()) {\r\n\t\t\r\n\t\t// We do not need to handle deactivated MappingHintGroups\r\n\t\t//\r\n\t\tif(element instanceof DeactivatableElement && ((DeactivatableElement) element).isDeactivated() ||\r\n\t\t\t\telement.eContainer() instanceof DeactivatableElement && ((DeactivatableElement) element.eContainer()).isDeactivated()) {\r\n\t\t\tcontinue;\r\n\t\t}\r\n\t\t\r\n\t\tLinkedList<MappingHintGroupType> concreteHintGroups = new LinkedList<>();\r\n\t\tfor (Setting setting : mappingSettings.get(element)) {\r\n\t\t\tif(setting.getEStructuralFeature().equals(<%pamtram.mapping.impl.MappingPackageImpl%>.eINSTANCE.getMappingHintGroupType_Extend())) {\r\n\t\t\t\t\r\n\t\t\t\t// only copy hints to activated hint groups\r\n\t\t\t\tif((setting.getEObject() instanceof DeactivatableElement && ((DeactivatableElement) setting.getEObject()).isDeactivated()) ||\r\n\t\t\t\t\t\t(setting.getEObject().eContainer() instanceof DeactivatableElement && ((DeactivatableElement) setting.getEObject().eContainer()).isDeactivated())) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t} else {\t\t\t\t\t\t\t\r\n\t\t\t\t\tconcreteHintGroups.add((MappingHintGroupType) setting.getEObject());\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\t\tabstractToConcreteHintGroupMap.put((MappingHintGroupType) element, concreteHintGroups);\r\n\t}\r\n}\r\n\r\n// copy the hints to the concrete hint groups\r\nfor (MappingHintGroupType abstractHintGroup : abstractToConcreteHintGroupMap.keySet()) {\r\n\tfor (MappingHintGroupType concreteHintGroup : abstractToConcreteHintGroupMap.get(abstractHintGroup)) {\r\n\r\n\t\tCollection<MappingHintBaseType> hintsToCopy = new BasicEList<>();\r\n\t\t/*\r\n\t\t * Collect all hints that will get copied. Those are all mapping hints (including ContainerSelectors) that are not\r\n\t\t * \'overwritten\' by hints of the concrete HintGroup.\r\n\t\t \052/\r\n\t\tfor (MappingHint abstractHint : abstractHintGroup.getMappingHints()) {\r\n\t\t\tEObject hintTarget = null;\r\n\t\t\tif(abstractHint instanceof AttributeMapping) {\r\n\t\t\t\thintTarget = ((AttributeMapping) abstractHint).getTarget();\r\n\t\t\t} else if(abstractHint instanceof ReferenceTargetSelector) {\r\n\t\t\t\thintTarget = ((ReferenceTargetSelector) abstractHint).getAffectedReference();\r\n\t\t\t} else if(abstractHint instanceof CardinalityMapping) {\r\n\t\t\t\thintTarget = ((CardinalityMapping) abstractHint).getTarget();\r\n\t\t\t} else {\r\n\t\t\t\tthrow new RuntimeException(\"Unsupported hint type \'\" + abstractHint.eClass().getName() + \"\' in HintGroup \'\" + \r\n\t\t\t\t\t\tabstractHintGroup.getName() + \"\': These kind of hints are not supported yet in abstract HintGroups!\");\r\n\t\t\t}\r\n\r\n\t\t\tif(abstractToConcreteElementMap.get(hintTarget) == null || abstractToConcreteElementMap.get(hintTarget).isEmpty() || concreteHintGroup.getMappingHints().isEmpty() || \r\n\t\t\t\t\tEcoreUtil.UsageCrossReferencer.findAll(abstractToConcreteElementMap.get(hintTarget), concreteHintGroup.getMappingHints()).isEmpty()) {\r\n\t\t\t\thintsToCopy.add(abstractHint);\r\n\t\t\t}\r\n\r\n\t\t}\r\n\t\t// model connection hints need to be handled separately\r\n\t\tif(abstractHintGroup instanceof MappingHintGroup && concreteHintGroup instanceof MappingHintGroup && \r\n\t\t\t\t((MappingHintGroup) concreteHintGroup).getContainerSelector() == null) {\r\n\t\t\thintsToCopy.add(((MappingHintGroup) abstractHintGroup).getContainerSelector());\r\n\t\t}\r\n\r\n\t\tCollection<MappingHintBaseType> copiedHints = EcoreUtil.copyAll(hintsToCopy);\r\n\r\n\t\t/* \r\n\t\t * make sure that all references to elements from the abstract sections are redirected to the concrete sections\r\n\t\t * that we created earlier\r\n\t\t \052/\r\n\t\tfor (MappingHintBaseType copiedHint : copiedHints) {\r\n\r\n\t\t\t/* \r\n\t\t\t * these are the references from the copied hint (that will get added to the concrete hint group) to elements from\r\n\t\t\t * abstract sections\r\n\t\t\t \052/\r\n\t\t\tMap<EObject, Collection<Setting>> refsToAbstractSection = EcoreUtil.UsageCrossReferencer.findAll(abstractToConcreteElementMap.keySet(), copiedHint);\r\n\t\t\tfor (EObject referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\t\t\t\t/*\r\n\t\t\t\t * based on the type of hint element that we are handling (local or external), source and target \r\n\t\t\t\t * sections or their containers are checked\r\n\t\t\t\t \052/\r\n\t\t\t\tboolean local = true;\r\n\t\t\t\tif(refsToAbstractSection.get(referencedObject).size() > 1) {\r\n\t\t\t\t\tthrow new RuntimeException(\"Internal Error! The hint \'\" + copiedHint.getName() + \"\' in the hint group \'\" + abstractHintGroup.getName() + \r\n\t\t\t\t\t\t\t\"\' holds multiple references to the same object of an abstract section (\'\" + referencedObject + \"\'.\");\r\n\t\t\t\t}\r\n\t\t\t\tif(refsToAbstractSection.get(referencedObject).iterator().next().getEObject() instanceof ExternalModifiedAttributeElementType) {\r\n\t\t\t\t\tlocal = false;\r\n\t\t\t\t}\r\n\t\t\t\tArrayList<Section> sourceAndTargetSections = new ArrayList<>();\r\n\t\t\t\tSourceSection sourceSection = ((Mapping) concreteHintGroup.eContainer()).getSourceSection();\r\n\t\t\t\tif(local) {\r\n\t\t\t\t\tsourceAndTargetSections.add(sourceSection);\r\n\t\t\t\t} else {\r\n\t\t\t\t\twhile (sourceSection.getContainer() != null) {\r\n\t\t\t\t\t\tsourceSection = sourceSection.getContainer().getContainingSection();\r\n\t\t\t\t\t\tsourceAndTargetSections.add(sourceSection);\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t\tTargetSection targetSection = concreteHintGroup.getTargetSection();\r\n\t\t\t\tif(local) {\r\n\t\t\t\t\tsourceAndTargetSections.add(targetSection);\r\n\t\t\t\t} else {\r\n\t\t\t\t\twhile (targetSection.getContainer() != null) {\r\n\t\t\t\t\t\ttargetSection = targetSection.getContainer().getContainingSection();\r\n\t\t\t\t\t\tsourceAndTargetSections.add(targetSection);\r\n\t\t\t\t\t} \r\n\t\t\t\t}\r\n\r\n\t\t\t\t/* \r\n\t\t\t\t * these are possible targets for the redirection of references to the referenced object\r\n\t\t\t\t \052/\r\n\t\t\t\tLinkedList<EObject> possibleTargets = abstractToConcreteElementMap.get(referencedObject);\r\n\r\n\t\t\t\tboolean found = false;\r\n\t\t\t\tEObject target = null; // this will contain the new value for the reference\r\n\t\t\t\tfor (EObject possibleTarget : possibleTargets) {\r\n\t\t\t\t\tSection containingSection = ((MetaModelElement) possibleTarget).getContainingSection();\r\n\t\t\t\t\tif(sourceAndTargetSections.contains(containingSection)) {\r\n\t\t\t\t\t\tif(found == false ) {\r\n\t\t\t\t\t\t\tfound = true;\r\n\t\t\t\t\t\t\ttarget = possibleTarget;\r\n\t\t\t\t\t\t} else {\r\n\t\t\t\t\t\t\t// this should not happen, should it?\r\n\t\t\t\t\t\t\tthrow new RuntimeException(\"Internal error! Multiple targets found for redirection of element \'\" + referencedObject + \"\' in.\");\r\n\t\t\t\t\t\t}\r\n\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t\tif(found == false) {\r\n\t\t\t\t\tthrow new RuntimeException(\"Internal error! No target found for redirection of element \'\" + referencedObject + \"\'.\");\r\n\t\t\t\t}\r\n\r\n\t\t\t\tfor (Setting setting : refsToAbstractSection.get(referencedObject)) {\r\n\t\t\t\t\tsetting.set(target);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t\t}\r\n\r\n\t\t// Finally, we add the copied hints to the concrete hint group\r\n\t\tfor (MappingHintBaseType copiedHint : copiedHints) {\r\n\t\t\tif(copiedHint instanceof ContainerSelector) {\r\n\t\t\t\t((MappingHintGroup) concreteHintGroup).setContainerSelector((ContainerSelector) copiedHint);\t\r\n\t\t\t} else {\r\n\t\t\t\tconcreteHintGroup.getMappingHints().add((MappingHint) copiedHint);\t\t\t\t\t\r\n\t\t\t}\r\n\r\n\t\t}\r\n\t}\r\n}\r\n\r\n/*\r\n * At the end, we clear the values of the \'extend\' references of the concrete elements as these\r\n * are no longer needed.\r\n \052/\r\nfor (Entry<Section, LinkedList<Section>> entry : abstractToConcreteSectionMap.entrySet()) {\r\n\tfor (Section concreteSection : entry.getValue()) {\r\n\t\tconcreteSection.getExtend().remove(entry.getKey());\r\n\t}\r\n}\r\nfor (Entry<MappingHintGroupType, LinkedList<MappingHintGroupType>> entry : abstractToConcreteHintGroupMap.entrySet()) {\r\n\tfor (MappingHintGroupType concreteHintGroup : entry.getValue()) {\r\n\t\tconcreteHintGroup.getExtend().remove(entry.getKey());\r\n\t}\r\n}'"
	 * @generated
	 */
	void mergeExtends();

} // PAMTraM
