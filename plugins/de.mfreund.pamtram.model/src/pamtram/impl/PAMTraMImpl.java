/**
 */
package pamtram.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.ConditionModel;
import pamtram.DeactivatableElement;
import pamtram.FixedValue;
import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.ContainerSelectorTargetAttribute;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.MappingHintBaseType;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.mapping.extended.impl.ExtendedFactoryImpl;
import pamtram.mapping.impl.MappingPackageImpl;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.ExternalDynamicSourceElement;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.generic.impl.GenericPackageImpl;
import pamtram.structure.impl.StructurePackageImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>PAM Tra
 * M</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSourceSectionModels <em>Source Section Models</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSharedSourceSectionModels <em>Shared Source Section Models</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getTargetSectionModels <em>Target Section Models</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSharedTargetSectionModels <em>Shared Target Section Models</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getMappingModels <em>Mapping Models</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSharedMappingModels <em>Shared Mapping Models</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSourceSections <em>Source Sections</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getTargetSections <em>Target Sections</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getActiveMappings <em>Active Mappings</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getGlobalValues <em>Global Values</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getGlobalAttributes <em>Global Attributes</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getModifierSets <em>Modifier Sets</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getConditionModels <em>Condition Models</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSharedConditionModels <em>Shared Condition Models</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PAMTraMImpl extends MinimalEObjectImpl.Container implements PAMTraM {

	/**
	 * The cached value of the '{@link #getSourceSectionModels() <em>Source Section Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceSectionModels()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceSectionModel> sourceSectionModels;

	/**
	 * The cached value of the '{@link #getSharedSourceSectionModels()
	 * <em>Shared Source Section Models</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSharedSourceSectionModels()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceSectionModel> sharedSourceSectionModels;

	/**
	 * The cached value of the '{@link #getTargetSectionModels() <em>Target Section Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetSectionModels()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetSectionModel> targetSectionModels;

	/**
	 * The cached value of the '{@link #getSharedTargetSectionModels()
	 * <em>Shared Target Section Models</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSharedTargetSectionModels()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetSectionModel> sharedTargetSectionModels;

	/**
	 * The cached value of the '{@link #getMappingModels() <em>Mapping Models</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMappingModels()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingModel> mappingModels;

	/**
	 * The cached value of the '{@link #getSharedMappingModels() <em>Shared Mapping Models</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSharedMappingModels()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingModel> sharedMappingModels;

	/**
	 * The cached value of the '{@link #getConditionModels() <em>Condition Models</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getConditionModels()
	 * @generated
	 * @ordered
	 */
	protected EList<ConditionModel> conditionModels;

	/**
	 * The cached value of the '{@link #getSharedConditionModels() <em>Shared Condition Models</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSharedConditionModels()
	 * @generated
	 * @ordered
	 */
	protected EList<ConditionModel> sharedConditionModels;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PAMTraMImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PamtramPackage.Literals.PAM_TRA_M;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSectionModel> getSourceSectionModels() {
		if (sourceSectionModels == null) {
			sourceSectionModels = new EObjectContainmentEList<SourceSectionModel>(SourceSectionModel.class, this, PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODELS);
		}
		return sourceSectionModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSectionModel> getSharedSourceSectionModels() {
		if (sharedSourceSectionModels == null) {
			sharedSourceSectionModels = new EObjectResolvingEList<SourceSectionModel>(SourceSectionModel.class, this, PamtramPackage.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS);
		}
		return sharedSourceSectionModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TargetSectionModel> getTargetSectionModels() {
		if (targetSectionModels == null) {
			targetSectionModels = new EObjectContainmentEList<TargetSectionModel>(TargetSectionModel.class, this, PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODELS);
		}
		return targetSectionModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TargetSectionModel> getSharedTargetSectionModels() {
		if (sharedTargetSectionModels == null) {
			sharedTargetSectionModels = new EObjectResolvingEList<TargetSectionModel>(TargetSectionModel.class, this, PamtramPackage.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS);
		}
		return sharedTargetSectionModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingModel> getMappingModels() {
		if (mappingModels == null) {
			mappingModels = new EObjectContainmentEList<MappingModel>(MappingModel.class, this, PamtramPackage.PAM_TRA_M__MAPPING_MODELS);
		}
		return mappingModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingModel> getSharedMappingModels() {
		if (sharedMappingModels == null) {
			sharedMappingModels = new EObjectResolvingEList<MappingModel>(MappingModel.class, this, PamtramPackage.PAM_TRA_M__SHARED_MAPPING_MODELS);
		}
		return sharedMappingModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSection> getSourceSections() {
		List<SourceSection> sourceSections = Stream
				.concat(this.getSourceSectionModels().stream(),
						this.getSharedSourceSectionModels().stream())
				.flatMap(s -> s.getSections().stream()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTIONS,
				sourceSections.size(), sourceSections.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TargetSection> getTargetSections() {
		List<TargetSection> targetSections = Stream
				.concat(this.getTargetSectionModels().stream(),
						this.getSharedTargetSectionModels().stream())
				.flatMap(s -> s.getSections().stream()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTIONS,
				targetSections.size(), targetSections.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Mapping> getMappings() {
		List<Mapping> mappings = Stream.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())
				.flatMap(s -> s.getMappings().stream()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__MAPPINGS,
				mappings.size(), mappings.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Mapping> getActiveMappings() {
		List<Mapping> mappings = Stream.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream()).filter(m -> !m.isDeactivated())
				.flatMap(s -> s.getActiveMappings().stream()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__ACTIVE_MAPPINGS,
				mappings.size(), mappings.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<FixedValue> getGlobalValues() {
		List<FixedValue> globalValues = Stream.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())
				.flatMap(s -> s.getGlobalValues().stream()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__GLOBAL_VALUES,
				globalValues.size(), globalValues.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GlobalAttribute> getGlobalAttributes() {
		List<GlobalAttribute> globalAttributes = Stream.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())
				.flatMap(s -> s.getGlobalAttributes().stream()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__GLOBAL_ATTRIBUTES,
				globalAttributes.size(), globalAttributes.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<ValueModifierSet> getModifierSets() {
		List<ValueModifierSet> modifierSets = Stream.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())
				.flatMap(s -> s.getModifierSets().stream()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__MODIFIER_SETS,
				modifierSets.size(), modifierSets.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConditionModel> getConditionModels() {
		if (conditionModels == null) {
			conditionModels = new EObjectContainmentEList<ConditionModel>(ConditionModel.class, this, PamtramPackage.PAM_TRA_M__CONDITION_MODELS);
		}
		return conditionModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConditionModel> getSharedConditionModels() {
		if (sharedConditionModels == null) {
			sharedConditionModels = new EObjectResolvingEList<ConditionModel>(ConditionModel.class, this, PamtramPackage.PAM_TRA_M__SHARED_CONDITION_MODELS);
		}
		return sharedConditionModels;
	}

	/**
	 * <!-- begin-user-doc --> This merges all HintGroups and Sections that are
	 * extended by other {@link MappingHintGroupType#getExtend() HintGroups} or
	 * {@link Section#getExtend() Sections} into these elements. This means that
	 * all children of the extended elements are copied/duplicated into every
	 * extending element. Additionally, all cross-references to the extended
	 * elements (or sub-elements) are redirected to the duplicated elements as
	 * well. <br />
	 * Consequently, the result of this process is a 'simple' PAMTraM model
	 * without any extensions that can be used e.g. in a transformation without
	 * any further hassle. <br />
	 * <br />
	 * <b><em>Note:</em></b> This algorithm changes the contents of the
	 * {@link PAMTraM} instance so that it might in some cases be necessary to
	 * create a {@link EcoreUtil#copy(EObject) copy} that gets changed instead.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void mergeExtends() {
		//TODO handle hierarchical extensions (an extended section extends other sections
		//TODO implement a more sophisticated merging strategy that takes into account overwriting of hints?
		
		/*
		 * First, we collect each abstract source and target section as well as the concrete sections that
		 * reference them
		 */
		HashMap<Section, LinkedList<Section>> abstractToConcreteSectionMap = new HashMap<>();
		Map<EObject, Collection<Setting>> sourceSettings = EcoreUtil.CrossReferencer.find(getSourceSections());
		for (Section section : getSourceSections()) {
			if(section.isAbstract() && sourceSettings.containsKey(section)) {
				LinkedList<Section> concreteSections = new LinkedList<>();
				for (Setting setting : sourceSettings.get(section)) {
					if(setting.getEStructuralFeature().equals(GenericPackageImpl.eINSTANCE.getSection_Extend())) {
						concreteSections.add((Section) setting.getEObject());
					}
				}
				abstractToConcreteSectionMap.put(section, concreteSections);
			}
		}
		Map<EObject, Collection<Setting>> targetSettings = EcoreUtil.CrossReferencer.find(getTargetSections());
		for (Section section : getTargetSections()) {
			if(section.isAbstract() && targetSettings.containsKey(section)) {
				LinkedList<Section> concreteSections = new LinkedList<>();
				for (Setting setting : targetSettings.get(section)) {
					if(setting.getEStructuralFeature().equals(GenericPackageImpl.eINSTANCE.getSection_Extend())) {
						concreteSections.add((Section) setting.getEObject());
					}
				}
				abstractToConcreteSectionMap.put(section, concreteSections);
			}
		}
		
		ArrayList<Mapping> concreteMappings = new ArrayList<>();
		for (Mapping mapping : getActiveMappings()) {
			if(!mapping.isAbstract()) {
				concreteMappings.add(mapping);
			}
		}
		
		/*
		 * Now, we copy all elements from the abstract sections to the concrete sections
		 * that extend them. In this process, we store the associations between the elements from
		 * the abstract sections and the copied elements in a map.
		 */
		HashMap<EObject, LinkedList<EObject>> abstractToConcreteElementMap = new HashMap<>();
		for (Section abstractSection : abstractToConcreteSectionMap.keySet()) {
			for (Section concreteSection : abstractToConcreteSectionMap.get(abstractSection)) {
		
				Section copiedSection = EcoreUtil.copy(abstractSection);
		
				TreeIterator<EObject> originalIterator = EcoreUtil.getAllContents(Collections.singleton(abstractSection));
				TreeIterator<EObject> copyIterator = EcoreUtil.getAllContents(Collections.singleton(copiedSection));
		
				// these lists will store the elements that we will add to the concrete section
				ArrayList<Attribute> attributesToAdd = new ArrayList<>();
				ArrayList<Reference> referencesToAdd = new ArrayList<>();
		
				while(originalIterator.hasNext()) {
					assert copyIterator.hasNext();
		
					EObject originalNext = originalIterator.next();
					EObject copyNext = copyIterator.next();
		
					// if the element is the section itself, we skip it
					if(originalNext instanceof Section) {
						continue;
					}
		
					// if the element is a top-level element below the section, we add it to the concrete section
					if(originalNext.eContainer().equals(abstractSection)) {
						if(copyNext instanceof Attribute) {
							attributesToAdd.add((Attribute) copyNext);
						} else if(copyNext instanceof Reference) {
							referencesToAdd.add((Reference) copyNext);
						} else {
							throw new RuntimeException("Unsupported element type '" + copyNext.eClass().getName() + "' encountered when merging extends!");
						}
					}
		
					// in any case, we fill the abstractToConcreteElementMap
					LinkedList<EObject> vals = abstractToConcreteElementMap.get(originalNext);
					if(vals == null) {
						vals = new LinkedList<>();
					}
					vals.add(copyNext);
					abstractToConcreteElementMap.put(originalNext, vals);
				}
		
				/*
				 * now, we add the collected elements to the concrete section; we have to do this
				 * after the process of iterating over the contents - otherwise, the TreeIterator will throw
				 * IndexOutOfBoundsExceptions
				 */
				concreteSection.getAttributes().addAll(attributesToAdd);
				concreteSection.getReferences().addAll(referencesToAdd);
		
				/*
				 * Now, we redirect references from concrete sections to
				 * elements from the abstract section to the (new) elements from
				 * the concrete sections.
				 */
				Map<EObject, Collection<Setting>> refsToAbstractSection = EcoreUtil.UsageCrossReferencer.findAll(
						abstractToConcreteElementMap.keySet(),
						this.getSourceSections().stream().filter(s -> !s.isAbstract()).collect(Collectors.toList()));
				for (EObject referencedObject : refsToAbstractSection.keySet()) {
		
					for (Setting setting : refsToAbstractSection.get(referencedObject).stream()
									.filter(s -> !s.getEStructuralFeature().isDerived()).collect(Collectors.toList())) {
		
						if (setting.getEStructuralFeature().equals(GenericPackage.eINSTANCE.getSection_Extend())) {
							// the 'extend' feature has already been handled
							// above
							continue;
						}
		
						// this is the element referencing the abstract section
						// (it should be an element of a section)
						EObject hintElement = setting.getEObject();
		
						if (setting.getEStructuralFeature().equals(GenericPackage.eINSTANCE.getClass_Container())) {
							if (abstractSection.equals(hintElement)
									|| abstractSection.isContainerFor((pamtram.structure.generic.Class<?, ?, ?, ?>) hintElement)) {
		
								// redirect the reference (we can always use the
								// 'last' of the concrete objects as we just
								// added it above
								setting.set(abstractToConcreteElementMap.get(referencedObject).getLast());
							}
		
						} else {
							System.out.println("Unhandled reference to element of an abstract section. Maybe consider redirecting this?");
						}
		
					}
		
				}
		
				/*
				 * Now, we redirect references from MappingHints to elements from the abstract section to the elements from the concrete sections. 
				 * Here, we only handle references from concrete mappings as the references from abstract mappings (and thus from extended hint
				 * groups) are handled afterwards when these hint groups are copied.
				 */
				refsToAbstractSection = EcoreUtil.UsageCrossReferencer.findAll(abstractToConcreteElementMap.keySet(), concreteMappings);
				for (EObject referencedObject : refsToAbstractSection.keySet()) {
		
		
					for (Setting setting : refsToAbstractSection.get(referencedObject)) {
		
						// this is the element referencing the abstract section (it should be an element of a mapping hint)
						EObject hintElement = setting.getEObject().eContainer();
						MappingHintGroupType hintGroup = null;
						if(hintElement instanceof MappingHintGroupType) {
							hintGroup = (MappingHintGroupType) hintElement;
						} else if(hintElement.eContainer() instanceof MappingHintGroupType) {
							hintGroup = (MappingHintGroupType) hintElement.eContainer();
						} else {
							hintGroup = (MappingHintGroupType) hintElement.eContainer().eContainer();
						}
						
						// We do not need to handle deactivated Mappings/MappingHintGroups
						//
						if(hintGroup instanceof DeactivatableElement && ((DeactivatableElement) hintGroup).isDeactivated() ||
								hintGroup.eContainer() instanceof DeactivatableElement && ((DeactivatableElement) hintGroup.eContainer()).isDeactivated()) {
							continue;
						}
		
						/* 
						 * check if the hint group or its parent mapping equals the section that we just added the concrete elements to
						 */
						if(concreteSection.equals(hintGroup.getTargetSection()) || 
								concreteSection.isContainerFor(hintGroup.getTargetSection()) ||
								concreteSection.equals(((Mapping) hintGroup.eContainer()).getSourceSection()) || 
								concreteSection.isContainerFor(((Mapping) hintGroup.eContainer()).getSourceSection())) {
		
							if(setting.getEStructuralFeature().equals(StructurePackageImpl.eINSTANCE.getDynamicSourceElement_Source()) && 
									setting.getEObject() instanceof ContainerSelectorTargetAttribute) {
								// do nothing as ContainerSelectors are handled below separately
							} else {
								// redirect the reference (we can always use the 'last' of the concrete objects as we just added it above
								setting.set(abstractToConcreteElementMap.get(referencedObject).getLast());
							}
		
						}
					}
		
				}
		
			}
		}
		
		/*
		 * Now, we handle the ContainerSelectors that we skipped above. We can do this now as we now know all concrete TargetSections that
		 * are a possible match for each ContainerSelector that points to an abstract TargetSection.
		 */
		for (Section abstractSection : abstractToConcreteSectionMap.keySet()) {
			for (Section concreteSection : abstractToConcreteSectionMap.get(abstractSection)) {
				/*
				 * as ContainerSelectors will get treated differently (see below), we store the ContainerSelectorTargetAttributes
				 * holding the referneces to the Attributes in the abstract section and will delete these later
				 */
				ArrayList<ContainerSelectorTargetAttribute> mchTargetAttributesToDelete = new ArrayList<>();
		
				Map<EObject, Collection<Setting>> refsToAbstractSection = EcoreUtil.UsageCrossReferencer.findAll(abstractToConcreteElementMap.keySet(), concreteMappings);
				for (EObject referencedObject : refsToAbstractSection.keySet()) {
		
		
					for (Setting setting : refsToAbstractSection.get(referencedObject)) {
		
						// this is the element referencing the abstract section (it should be an element of a mapping hint)
						EObject hintElement = setting.getEObject().eContainer();
						MappingHintGroupType hintGroup = null;
						if(hintElement instanceof MappingHintGroupType) {
							hintGroup = (MappingHintGroupType) hintElement;
						} else if(hintElement.eContainer() instanceof MappingHintGroupType) {
							hintGroup = (MappingHintGroupType) hintElement.eContainer();
						} else {
							hintGroup = (MappingHintGroupType) hintElement.eContainer().eContainer();
						}
						
						// We do not need to handle deactivated Mappings/MappingHintGroups
						//
						if(hintGroup instanceof DeactivatableElement && ((DeactivatableElement) hintGroup).isDeactivated() ||
								hintGroup.eContainer() instanceof DeactivatableElement && ((DeactivatableElement) hintGroup.eContainer()).isDeactivated()) {
							continue;
						}
		
						/* 
						 * check if the hint group or its parent mapping equals the section that we just added the concrete elements to or
						 * if we are dealing with a model ContainerSelectorTargetAttribute
						 */
						if(setting.getEStructuralFeature().equals(StructurePackageImpl.eINSTANCE.getDynamicSourceElement_Source()) && 
								setting.getEObject() instanceof ContainerSelectorTargetAttribute) {
		
							// in this case, we must not simply redirect but we create a new ContainerSelectorTargetAttribute
							ContainerSelectorTargetAttribute original = (ContainerSelectorTargetAttribute) setting.getEObject();
		
							for (EObject concreteTargetSectionAttribute : abstractToConcreteElementMap.get(referencedObject)) {
								ContainerSelectorTargetAttribute copy = ExtendedFactoryImpl.eINSTANCE.createContainerSelectorTargetAttribute();
								copy.setName(original.getName());
								copy.getModifiers().addAll(original.getModifiers());
								copy.setSource((TargetSectionAttribute) concreteTargetSectionAttribute);
		
								((ContainerSelector) (setting.getEObject().eContainer())).getTargetAttributes().add(copy);								
							}
		
		
							mchTargetAttributesToDelete.add((ContainerSelectorTargetAttribute) setting.getEObject());
						}
					}
		
				}
		
				for (ContainerSelectorTargetAttribute mchTargetAttribute : mchTargetAttributesToDelete) {
					EcoreUtil.delete(mchTargetAttribute);
				}
			}
		}
		
		/*
		 * Finally, we can copy the abstract hint groups
		 */
		
		// collect each abstract hint group as well as the concrete hint groups that reference them
		HashMap<MappingHintGroupType, LinkedList<MappingHintGroupType>> abstractToConcreteHintGroupMap = new HashMap<>();
		Map<EObject, Collection<Setting>> mappingSettings = EcoreUtil.CrossReferencer.find(getActiveMappings());
		for (EObject element : mappingSettings.keySet()) {
			if(element instanceof MappingHintGroupType && ((Mapping)(element.eContainer())).isAbstract()) {
				
				// We do not need to handle deactivated MappingHintGroups
				//
				if(element instanceof DeactivatableElement && ((DeactivatableElement) element).isDeactivated() ||
						element.eContainer() instanceof DeactivatableElement && ((DeactivatableElement) element.eContainer()).isDeactivated()) {
					continue;
				}
				
				LinkedList<MappingHintGroupType> concreteHintGroups = new LinkedList<>();
				for (Setting setting : mappingSettings.get(element)) {
					if(setting.getEStructuralFeature().equals(MappingPackageImpl.eINSTANCE.getMappingHintGroupType_Extend())) {
						
						// only copy hints to activated hint groups
						if((setting.getEObject() instanceof DeactivatableElement && ((DeactivatableElement) setting.getEObject()).isDeactivated()) ||
								(setting.getEObject().eContainer() instanceof DeactivatableElement && ((DeactivatableElement) setting.getEObject().eContainer()).isDeactivated())) {
							continue;
						} else {							
							concreteHintGroups.add((MappingHintGroupType) setting.getEObject());
						}
					}
				}
				abstractToConcreteHintGroupMap.put((MappingHintGroupType) element, concreteHintGroups);
			}
		}
		
		// copy the hints to the concrete hint groups
		for (MappingHintGroupType abstractHintGroup : abstractToConcreteHintGroupMap.keySet()) {
			for (MappingHintGroupType concreteHintGroup : abstractToConcreteHintGroupMap.get(abstractHintGroup)) {
		
				Collection<MappingHintBaseType> hintsToCopy = new BasicEList<>();
				/*
				 * Collect all hints that will get copied. Those are all mapping hints (including ContainerSelectors) that are not
				 * 'overwritten' by hints of the concrete HintGroup.
				 */
				for (MappingHint abstractHint : abstractHintGroup.getActiveMappingHints()) {
					EObject hintTarget = null;
					if(abstractHint instanceof AttributeMapping) {
						hintTarget = ((AttributeMapping) abstractHint).getTarget();
					} else if(abstractHint instanceof ReferenceTargetSelector) {
						hintTarget = ((ReferenceTargetSelector) abstractHint).getAffectedReference();
					} else if(abstractHint instanceof CardinalityMapping) {
						hintTarget = ((CardinalityMapping) abstractHint).getTarget();
					} else if(abstractHint instanceof ContainerSelector) {
						// nothing to do as ContainerSelectorTargetAttributes are handled separately
					} else {
						throw new RuntimeException("Unsupported hint type '" + abstractHint.eClass().getName() + "' in HintGroup '" + 
								abstractHintGroup.getName() + "': These kind of hints are not supported yet in abstract HintGroups!");
					}
		
					// An abstract hint is not overwritten (and may thus get
					// copied) if...
					//
					// ... there are either no concrete hints at all...
					if (concreteHintGroup.getMappingHints().isEmpty()
							// ... or if there are are no hints with the same
							// target element ...
							|| EcoreUtil.UsageCrossReferencer.find(hintTarget, concreteHintGroup.getActiveMappingHints())
									.isEmpty()
									// ... and no hints with a target elements
									// that extends the target element of the
									// abstract hint
									&& (abstractToConcreteElementMap.get(hintTarget) == null
											|| abstractToConcreteElementMap.get(hintTarget).isEmpty()
											|| EcoreUtil.UsageCrossReferencer
													.findAll(abstractToConcreteElementMap.get(hintTarget),
															concreteHintGroup.getActiveMappingHints())
													.isEmpty())) {
		
						hintsToCopy.add(abstractHint);
					}
		
				}
		
				Collection<MappingHintBaseType> copiedHints = EcoreUtil.copyAll(hintsToCopy);
		
				/* 
				 * make sure that all references to elements from the abstract sections are redirected to the concrete sections
				 * that we created earlier
				 */
				for (MappingHintBaseType copiedHint : copiedHints) {
		
					/* 
					 * these are the references from the copied hint (that will get added to the concrete hint group) to elements from
					 * abstract sections
					 */
					Map<EObject, Collection<Setting>> refsToAbstractSection = EcoreUtil.UsageCrossReferencer.findAll(abstractToConcreteElementMap.keySet(), copiedHint);
					for (EObject referencedObject : refsToAbstractSection.keySet()) {
		
						/*
						 * based on the type of hint element that we are handling (local or external), source and target 
						 * sections or their containers are checked
						 */
						boolean local = true;
						if(refsToAbstractSection.get(referencedObject).size() > 1) {
							throw new RuntimeException("Internal Error! The hint '" + copiedHint.getName() + "' in the hint group '" + abstractHintGroup.getName() + 
									"' holds multiple references to the same object of an abstract section ('" + referencedObject + "'.");
						}
						if(refsToAbstractSection.get(referencedObject).iterator().next().getEObject() instanceof ExternalDynamicSourceElement) {
							local = false;
						}
						ArrayList<Section> sourceAndTargetSections = new ArrayList<>();
						SourceSection sourceSection = ((Mapping) concreteHintGroup.eContainer()).getSourceSection();
						if(local) {
							sourceAndTargetSections.add(sourceSection);
						} else {
							while (sourceSection.getContainer() != null) {
								sourceSection = sourceSection.getContainer().getContainingSection();
								sourceAndTargetSections.add(sourceSection);
							}
						}
						TargetSection targetSection = concreteHintGroup.getTargetSection();
						if(local) {
							sourceAndTargetSections.add(targetSection);
						} else {
							while (targetSection.getContainer() != null) {
								targetSection = targetSection.getContainer().getContainingSection();
								sourceAndTargetSections.add(targetSection);
							} 
						}
		
						/* 
						 * these are possible targets for the redirection of references to the referenced object
						 */
						LinkedList<EObject> possibleTargets = abstractToConcreteElementMap.get(referencedObject);
		
						boolean found = false;
						EObject target = null; // this will contain the new value for the reference
						for (EObject possibleTarget : possibleTargets) {
							Section containingSection = ((MetaModelElement) possibleTarget).getContainingSection();
							if(sourceAndTargetSections.contains(containingSection)) {
								if(found == false ) {
									found = true;
									target = possibleTarget;
								} else {
									// this should not happen, should it?
									throw new RuntimeException("Internal error! Multiple targets found for redirection of element '" + referencedObject + "' in.");
								}
		
							}
						}
		
						if(found == false) {
							throw new RuntimeException("Internal error! No target found for redirection of element '" + referencedObject + "'.");
						}
		
						for (Setting setting : refsToAbstractSection.get(referencedObject)) {
							setting.set(target);
						}
					}
		
				}
		
				// Finally, we add the copied hints to the concrete hint group
				for (MappingHintBaseType copiedHint : copiedHints) {
					concreteHintGroup.getMappingHints().add((MappingHint) copiedHint);
				}
			}
		}
		
		/*
		 * At the end, we clear the values of the 'extend' references of the concrete elements as these
		 * are no longer needed.
		 */
		for (Entry<Section, LinkedList<Section>> entry : abstractToConcreteSectionMap.entrySet()) {
			for (Section concreteSection : entry.getValue()) {
				concreteSection.getExtend().remove(entry.getKey());
			}
		}
		for (Entry<MappingHintGroupType, LinkedList<MappingHintGroupType>> entry : abstractToConcreteHintGroupMap.entrySet()) {
			for (MappingHintGroupType concreteHintGroup : entry.getValue()) {
				concreteHintGroup.getExtend().remove(entry.getKey());
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceSectionModel> getActiveSourceSectionModels() {
		Object[] sourceSectionModels = getSourceSectionModels().stream().filter(s -> !s.isDeactivated()).toArray();
		return new BasicEList.UnmodifiableEList<>(sourceSectionModels.length, sourceSectionModels);
	}

	/**
	 * This merges the given {@link TargetSectionAttribute} 'copy' into the the
	 * given {@link TargetSection} 'targetSection'. Merging in this case means
	 * that before adding the attribute, the algorithm checks whether the 'same'
	 * attribute is already present. If this is the case, the attribute is not
	 * added but all references to it are redirected to the attribute already
	 * present in the target section.
	 *
	 * @param targetSection
	 * @param att
	 */
	// private void merge(TargetSection targetSection, TargetSectionAttribute
	// att) {
	// for (TargetSectionAttribute targetSectionAttribute :
	// targetSection.getAttributes()) {
	// if(checkEquality(targetSectionAttribute, att)) {
	// Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.find(this,
	// att);
	// for (Setting setting : refs) {
	// setting.set(targetSectionAttribute);
	// }
	// return;
	// }
	// }
	// }

	/**
	 * This merges the given {@link TargetSectionReference} 'copy' into the the
	 * given {@link TargetSection} 'targetSection'. Merging in this case means
	 * that before adding the reference, the algorithm checks whether the 'same'
	 * reference is already present. If this is the case, the reference is not
	 * added but all references to it are redirected to the attribute already
	 * present in the target section.
	 *
	 * @param targetSection
	 * @param att
	 */
	// private void merge(TargetSection targetSection, TargetSectionReference
	// ref) {
	// for (TargetSectionReference targetSectionReference :
	// targetSection.getReferences()) {
	// if(checkEquality(targetSectionReference, ref)) {
	// Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.findAll(ref.,
	// this);
	// for (Setting setting : refs) {
	// setting.set(targetSectionReference);
	// }
	// return;
	// }
	// }
	// }

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODELS:
				return ((InternalEList<?>)getSourceSectionModels()).basicRemove(otherEnd, msgs);
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODELS:
				return ((InternalEList<?>)getTargetSectionModels()).basicRemove(otherEnd, msgs);
			case PamtramPackage.PAM_TRA_M__MAPPING_MODELS:
				return ((InternalEList<?>)getMappingModels()).basicRemove(otherEnd, msgs);
			case PamtramPackage.PAM_TRA_M__CONDITION_MODELS:
				return ((InternalEList<?>)getConditionModels()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODELS:
				return getSourceSectionModels();
			case PamtramPackage.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS:
				return getSharedSourceSectionModels();
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODELS:
				return getTargetSectionModels();
			case PamtramPackage.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS:
				return getSharedTargetSectionModels();
			case PamtramPackage.PAM_TRA_M__MAPPING_MODELS:
				return getMappingModels();
			case PamtramPackage.PAM_TRA_M__SHARED_MAPPING_MODELS:
				return getSharedMappingModels();
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTIONS:
				return getSourceSections();
			case PamtramPackage.PAM_TRA_M__TARGET_SECTIONS:
				return getTargetSections();
			case PamtramPackage.PAM_TRA_M__MAPPINGS:
				return getMappings();
			case PamtramPackage.PAM_TRA_M__ACTIVE_MAPPINGS:
				return getActiveMappings();
			case PamtramPackage.PAM_TRA_M__GLOBAL_VALUES:
				return getGlobalValues();
			case PamtramPackage.PAM_TRA_M__GLOBAL_ATTRIBUTES:
				return getGlobalAttributes();
			case PamtramPackage.PAM_TRA_M__MODIFIER_SETS:
				return getModifierSets();
			case PamtramPackage.PAM_TRA_M__CONDITION_MODELS:
				return getConditionModels();
			case PamtramPackage.PAM_TRA_M__SHARED_CONDITION_MODELS:
				return getSharedConditionModels();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODELS:
				getSourceSectionModels().clear();
				getSourceSectionModels().addAll((Collection<? extends SourceSectionModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS:
				getSharedSourceSectionModels().clear();
				getSharedSourceSectionModels().addAll((Collection<? extends SourceSectionModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODELS:
				getTargetSectionModels().clear();
				getTargetSectionModels().addAll((Collection<? extends TargetSectionModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS:
				getSharedTargetSectionModels().clear();
				getSharedTargetSectionModels().addAll((Collection<? extends TargetSectionModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__MAPPING_MODELS:
				getMappingModels().clear();
				getMappingModels().addAll((Collection<? extends MappingModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_MAPPING_MODELS:
				getSharedMappingModels().clear();
				getSharedMappingModels().addAll((Collection<? extends MappingModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__CONDITION_MODELS:
				getConditionModels().clear();
				getConditionModels().addAll((Collection<? extends ConditionModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_CONDITION_MODELS:
				getSharedConditionModels().clear();
				getSharedConditionModels().addAll((Collection<? extends ConditionModel>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODELS:
				getSourceSectionModels().clear();
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS:
				getSharedSourceSectionModels().clear();
				return;
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODELS:
				getTargetSectionModels().clear();
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS:
				getSharedTargetSectionModels().clear();
				return;
			case PamtramPackage.PAM_TRA_M__MAPPING_MODELS:
				getMappingModels().clear();
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_MAPPING_MODELS:
				getSharedMappingModels().clear();
				return;
			case PamtramPackage.PAM_TRA_M__CONDITION_MODELS:
				getConditionModels().clear();
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_CONDITION_MODELS:
				getSharedConditionModels().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODELS:
				return sourceSectionModels != null && !sourceSectionModels.isEmpty();
			case PamtramPackage.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS:
				return sharedSourceSectionModels != null && !sharedSourceSectionModels.isEmpty();
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODELS:
				return targetSectionModels != null && !targetSectionModels.isEmpty();
			case PamtramPackage.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS:
				return sharedTargetSectionModels != null && !sharedTargetSectionModels.isEmpty();
			case PamtramPackage.PAM_TRA_M__MAPPING_MODELS:
				return mappingModels != null && !mappingModels.isEmpty();
			case PamtramPackage.PAM_TRA_M__SHARED_MAPPING_MODELS:
				return sharedMappingModels != null && !sharedMappingModels.isEmpty();
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTIONS:
				return !getSourceSections().isEmpty();
			case PamtramPackage.PAM_TRA_M__TARGET_SECTIONS:
				return !getTargetSections().isEmpty();
			case PamtramPackage.PAM_TRA_M__MAPPINGS:
				return !getMappings().isEmpty();
			case PamtramPackage.PAM_TRA_M__ACTIVE_MAPPINGS:
				return !getActiveMappings().isEmpty();
			case PamtramPackage.PAM_TRA_M__GLOBAL_VALUES:
				return !getGlobalValues().isEmpty();
			case PamtramPackage.PAM_TRA_M__GLOBAL_ATTRIBUTES:
				return !getGlobalAttributes().isEmpty();
			case PamtramPackage.PAM_TRA_M__MODIFIER_SETS:
				return !getModifierSets().isEmpty();
			case PamtramPackage.PAM_TRA_M__CONDITION_MODELS:
				return conditionModels != null && !conditionModels.isEmpty();
			case PamtramPackage.PAM_TRA_M__SHARED_CONDITION_MODELS:
				return sharedConditionModels != null && !sharedConditionModels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PamtramPackage.PAM_TRA_M___MERGE_EXTENDS:
				mergeExtends();
				return null;
			case PamtramPackage.PAM_TRA_M___GET_ACTIVE_SOURCE_SECTION_MODELS:
				return getActiveSourceSectionModels();
		}
		return super.eInvoke(operationID, arguments);
	}

} // PAMTraMImpl
