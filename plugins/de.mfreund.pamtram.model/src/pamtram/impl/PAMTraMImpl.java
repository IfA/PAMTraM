/**
 */
package pamtram.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;

import pamtram.ConditionModel;
import pamtram.DeactivatableElement;
import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.PamtramTables;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ExternalModifiedAttributeElementType;
import pamtram.mapping.FixedValue;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintBaseType;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.ReferenceTargetSelector;
import pamtram.mapping.ContainerSelector;
import pamtram.mapping.ContainerSelectorTargetAttribute;
import pamtram.mapping.ValueModifierSet;
import pamtram.mapping.impl.MappingFactoryImpl;
import pamtram.mapping.impl.MappingPackageImpl;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.impl.MetamodelPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PAM Tra M</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getContextMetaModelPackage <em>Context Meta Model Package</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSourceSectionModel <em>Source Section Model</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getTargetSectionModel <em>Target Section Model</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getMappingModel <em>Mapping Model</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSourceSections <em>Source Sections</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getTargetSections <em>Target Sections</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getActiveMappings <em>Active Mappings</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getGlobalValues <em>Global Values</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getModifierSets <em>Modifier Sets</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getConditionModel <em>Condition Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PAMTraMImpl extends MinimalEObjectImpl.Container implements PAMTraM {
	/**
	 * The cached value of the '{@link #getContextMetaModelPackage() <em>Context Meta Model Package</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextMetaModelPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackage> contextMetaModelPackage;

	/**
	 * The cached value of the '{@link #getSourceSectionModel() <em>Source Section Model</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceSectionModel()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceSectionModel> sourceSectionModel;

	/**
	 * The cached value of the '{@link #getTargetSectionModel() <em>Target Section Model</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetSectionModel()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetSectionModel> targetSectionModel;

	/**
	 * The cached value of the '{@link #getMappingModel() <em>Mapping Model</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingModel()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingModel> mappingModel;

	/**
	 * The cached value of the '{@link #getConditionModel() <em>Condition Model</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionModel()
	 * @generated
	 * @ordered
	 */
	protected EList<ConditionModel> conditionModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PAMTraMImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PamtramPackage.Literals.PAM_TRA_M;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EPackage> getContextMetaModelPackage() {
		if (contextMetaModelPackage == null) {
			contextMetaModelPackage = new EObjectResolvingEList<EPackage>(EPackage.class, this, PamtramPackage.PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE);
		}
		return contextMetaModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSectionModel> getSourceSectionModel() {
		if (sourceSectionModel == null) {
			sourceSectionModel = new EObjectContainmentEList<SourceSectionModel>(SourceSectionModel.class, this, PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL);
		}
		return sourceSectionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TargetSectionModel> getTargetSectionModel() {
		if (targetSectionModel == null) {
			targetSectionModel = new EObjectContainmentEList<TargetSectionModel>(TargetSectionModel.class, this, PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL);
		}
		return targetSectionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingModel> getMappingModel() {
		if (mappingModel == null) {
			mappingModel = new EObjectContainmentEList<MappingModel>(MappingModel.class, this, PamtramPackage.PAM_TRA_M__MAPPING_MODEL);
		}
		return mappingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSection> getSourceSections() {
		List<SourceSection> sourceSections = this.getSourceSectionModel().parallelStream()
				.flatMap(s -> s.getMetaModelSections().parallelStream()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTIONS,
				sourceSections.size(), sourceSections.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TargetSection> getTargetSections() {
		List<TargetSection> targetSections = this.getTargetSectionModel().parallelStream()
				.flatMap(s -> s.getMetaModelSections().parallelStream()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTIONS,
				targetSections.size(), targetSections.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Mapping> getMappings() {
		/**
		 * self.mappingModel->collect(s | s.mapping)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final /*@Thrown*/ List<MappingModel> mappingModel = this.getMappingModel();
		final /*@Thrown*/ OrderedSetValue BOXED_mappingModel = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_MappingModel, mappingModel);
		/*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(PamtramTables.SEQ_CLSSid_Mapping);
		/*@NonNull*/ Iterator<Object> ITERATOR_s = BOXED_mappingModel.iterator();
		/*@Thrown*/ SequenceValue collect;
		while (true) {
		    if (!ITERATOR_s.hasNext()) {
		        collect = accumulator;
		        break;
		    }
		    /*@NonInvalid*/ MappingModel s = (MappingModel)ITERATOR_s.next();
		    /**
		     * s.mapping
		     */
		    final /*@Thrown*/ List<Mapping> mapping = s.getMapping();
		    final /*@Thrown*/ OrderedSetValue BOXED_mapping = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_Mapping, mapping);
		    //
		    for (Object value : BOXED_mapping.flatten().getElements()) {
		        accumulator.add(value);
		    }
		}
		final /*@Thrown*/ List<Mapping> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Mapping.class, collect);
		return (EList<Mapping>)ECORE_collect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Mapping> getActiveMappings() {
		/**
		 * 
		 * self.mappingModel->select(m | m.deactivated = false)
		 * ->collect(m | m.getActiveMappings())
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final /*@Thrown*/ List<MappingModel> mappingModel = this.getMappingModel();
		final /*@Thrown*/ OrderedSetValue BOXED_mappingModel = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_MappingModel, mappingModel);
		/*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(PamtramTables.ORD_CLSSid_MappingModel);
		/*@NonNull*/ Iterator<Object> ITERATOR_m = BOXED_mappingModel.iterator();
		/*@Thrown*/ OrderedSetValue select;
		while (true) {
		    if (!ITERATOR_m.hasNext()) {
		        select = accumulator;
		        break;
		    }
		    /*@NonInvalid*/ MappingModel m = (MappingModel)ITERATOR_m.next();
		    /**
		     * m.deactivated = false
		     */
		    final /*@Thrown*/ boolean deactivated = m.isDeactivated();
		    final /*@Thrown*/ boolean eq = !deactivated;
		    //
		    if (eq == ValueUtil.TRUE_VALUE) {
		        accumulator.add(m);
		    }
		}
		/*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(PamtramTables.SEQ_CLSSid_Mapping);
		/*@NonNull*/ Iterator<Object> ITERATOR_m_0 = select.iterator();
		/*@Thrown*/ SequenceValue collect;
		while (true) {
		    if (!ITERATOR_m_0.hasNext()) {
		        collect = accumulator_0;
		        break;
		    }
		    /*@NonInvalid*/ MappingModel m_0 = (MappingModel)ITERATOR_m_0.next();
		    /**
		     * m.getActiveMappings()
		     */
		    final /*@Thrown*/ List<Mapping> getActiveMappings = m_0.getActiveMappings();
		    final /*@Thrown*/ OrderedSetValue BOXED_getActiveMappings = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_Mapping, getActiveMappings);
		    //
		    for (Object value : BOXED_getActiveMappings.flatten().getElements()) {
		        accumulator_0.add(value);
		    }
		}
		final /*@Thrown*/ List<Mapping> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Mapping.class, collect);
		return (EList<Mapping>)ECORE_collect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<FixedValue> getGlobalValues() {
		/**
		 * self.mappingModel->collect(s | s.globalValues)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final /*@Thrown*/ List<MappingModel> mappingModel = this.getMappingModel();
		final /*@Thrown*/ OrderedSetValue BOXED_mappingModel = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_MappingModel, mappingModel);
		/*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(PamtramTables.SEQ_CLSSid_FixedValue);
		/*@NonNull*/ Iterator<Object> ITERATOR_s = BOXED_mappingModel.iterator();
		/*@Thrown*/ SequenceValue collect;
		while (true) {
		    if (!ITERATOR_s.hasNext()) {
		        collect = accumulator;
		        break;
		    }
		    /*@NonInvalid*/ MappingModel s = (MappingModel)ITERATOR_s.next();
		    /**
		     * s.globalValues
		     */
		    final /*@Thrown*/ List<FixedValue> globalValues = s.getGlobalValues();
		    final /*@Thrown*/ OrderedSetValue BOXED_globalValues = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_FixedValue, globalValues);
		    //
		    for (Object value : BOXED_globalValues.flatten().getElements()) {
		        accumulator.add(value);
		    }
		}
		final /*@Thrown*/ List<FixedValue> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(FixedValue.class, collect);
		return (EList<FixedValue>)ECORE_collect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<ValueModifierSet> getModifierSets() {
		/**
		 * self.mappingModel->collect(s | s.modifierSets)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final /*@Thrown*/ List<MappingModel> mappingModel = this.getMappingModel();
		final /*@Thrown*/ OrderedSetValue BOXED_mappingModel = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_MappingModel, mappingModel);
		/*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(PamtramTables.SEQ_CLSSid_ValueModifierSet);
		/*@NonNull*/ Iterator<Object> ITERATOR_s = BOXED_mappingModel.iterator();
		/*@Thrown*/ SequenceValue collect;
		while (true) {
		    if (!ITERATOR_s.hasNext()) {
		        collect = accumulator;
		        break;
		    }
		    /*@NonInvalid*/ MappingModel s = (MappingModel)ITERATOR_s.next();
		    /**
		     * s.modifierSets
		     */
		    final /*@Thrown*/ List<ValueModifierSet> modifierSets = s.getModifierSets();
		    final /*@Thrown*/ OrderedSetValue BOXED_modifierSets = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_ValueModifierSet, modifierSets);
		    //
		    for (Object value : BOXED_modifierSets.flatten().getElements()) {
		        accumulator.add(value);
		    }
		}
		final /*@Thrown*/ List<ValueModifierSet> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(ValueModifierSet.class, collect);
		return (EList<ValueModifierSet>)ECORE_collect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConditionModel> getConditionModel() {
		if (conditionModel == null) {
			conditionModel = new EObjectContainmentEList<ConditionModel>(ConditionModel.class, this, PamtramPackage.PAM_TRA_M__CONDITION_MODEL);
		}
		return conditionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * This merges all HintGroups and Sections that are extended by other {@link MappingHintGroupType#getExtend() HintGroups} or
	 * {@link Section#getExtend() Sections} into these elements. This means that all children of the extended elements are
	 * copied/duplicated into every extending element. Additionally, all cross-references to the extended elements (or sub-elements)
	 * are redirected to the duplicated elements as well. <br />
	 * Consequently, the result of this process is a 'simple' PAMTraM model without any extensions that can be used e.g. in a
	 * transformation without any further hassle.
	 * <br /><br />
	 * <b><em>Note:</em></b> This algorithm changes the contents of the {@link PAMTraM} instance so that it might in some cases be
	 * necessary to create a {@link EcoreUtil#copy(EObject) copy} that gets changed instead.
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
					if(setting.getEStructuralFeature().equals(MetamodelPackageImpl.eINSTANCE.getSection_Extend())) {
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
					if(setting.getEStructuralFeature().equals(MetamodelPackageImpl.eINSTANCE.getSection_Extend())) {
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
		
					//TODO do we need to redirect references to these elements???
				}
		
				/*
				 * now, we add the collected elements to the concrete section; we have to do this
				 * after the process of iterating over the contents - otherwise, the TreeIterator will throw
				 * IndexOutOfBoundsExceptions
				 */
				concreteSection.getAttributes().addAll(attributesToAdd);
				concreteSection.getReferences().addAll(referencesToAdd);
		
		
				/*
				 * Now, we redirect references from MappingHints to elements from the abstract section to the elements from the concrete sections. 
				 * Here, we only handle references from concrete mappings as the references from abstract mappings (and thus from extended hint
				 * groups) are handled afterwards when these hint groups are copied.
				 */
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
						 * check if the hint group or its parent mapping equals the section that we just added the concrete elements to
						 */
						if(concreteSection.equals(hintGroup.getTargetSection()) || 
								concreteSection.isContainerFor(hintGroup.getTargetSection()) ||
								concreteSection.equals(((Mapping) hintGroup.eContainer()).getSourceSection()) || 
								concreteSection.isContainerFor(((Mapping) hintGroup.eContainer()).getSourceSection())) {
		
							if(setting.getEStructuralFeature().equals(MappingPackageImpl.eINSTANCE.getModifiedAttributeElementType_Source()) && 
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
						if(setting.getEStructuralFeature().equals(MappingPackageImpl.eINSTANCE.getModifiedAttributeElementType_Source()) && 
								setting.getEObject() instanceof ContainerSelectorTargetAttribute) {
		
							// in this case, we must not simply redirect but we create a new ContainerSelectorTargetAttribute
							ContainerSelectorTargetAttribute original = (ContainerSelectorTargetAttribute) setting.getEObject();
		
							for (EObject concreteTargetSectionAttribute : abstractToConcreteElementMap.get(referencedObject)) {
								ContainerSelectorTargetAttribute copy = MappingFactoryImpl.eINSTANCE.createContainerSelectorTargetAttribute();
								copy.setName(original.getName());
								copy.getModifier().addAll(original.getModifier());
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
				for (MappingHint abstractHint : abstractHintGroup.getMappingHints()) {
					EObject hintTarget = null;
					if(abstractHint instanceof AttributeMapping) {
						hintTarget = ((AttributeMapping) abstractHint).getTarget();
					} else if(abstractHint instanceof ReferenceTargetSelector) {
						hintTarget = ((ReferenceTargetSelector) abstractHint).getAffectedReference();
					} else if(abstractHint instanceof CardinalityMapping) {
						hintTarget = ((CardinalityMapping) abstractHint).getTarget();
					} else {
						throw new RuntimeException("Unsupported hint type '" + abstractHint.eClass().getName() + "' in HintGroup '" + 
								abstractHintGroup.getName() + "': These kind of hints are not supported yet in abstract HintGroups!");
					}
		
					if(abstractToConcreteElementMap.get(hintTarget) == null || abstractToConcreteElementMap.get(hintTarget).isEmpty() || concreteHintGroup.getMappingHints().isEmpty() || 
							EcoreUtil.UsageCrossReferencer.findAll(abstractToConcreteElementMap.get(hintTarget), concreteHintGroup.getMappingHints()).isEmpty()) {
						hintsToCopy.add(abstractHint);
					}
		
				}
				// model connection hints need to be handled separately
				if(abstractHintGroup instanceof MappingHintGroup && concreteHintGroup instanceof MappingHintGroup && 
						((MappingHintGroup) concreteHintGroup).getContainerSelector() == null) {
					hintsToCopy.add(((MappingHintGroup) abstractHintGroup).getContainerSelector());
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
						if(refsToAbstractSection.get(referencedObject).iterator().next().getEObject() instanceof ExternalModifiedAttributeElementType) {
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
					if(copiedHint instanceof ContainerSelector) {
						((MappingHintGroup) concreteHintGroup).setContainerSelector((ContainerSelector) copiedHint);	
					} else {
						concreteHintGroup.getMappingHints().add((MappingHint) copiedHint);					
					}
		
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
	 * This merges the given {@link TargetSectionAttribute} 'copy' into the the given {@link TargetSection}
	 * 'targetSection'. Merging in this case means that before adding the attribute, the algorithm checks whether
	 * the 'same' attribute is already present. If this is the case, the attribute is not added but all references
	 * to it are redirected to the attribute already present in the target section.
	 *
	 * @param targetSection
	 * @param att
	 */
	//	private void merge(TargetSection targetSection, TargetSectionAttribute att) {
	//		for (TargetSectionAttribute targetSectionAttribute : targetSection.getAttributes()) {
	//			if(checkEquality(targetSectionAttribute, att)) {
	//				Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.find(this, att);
	//				for (Setting setting : refs) {
	//					setting.set(targetSectionAttribute);
	//				}
	//				return;
	//			}
	//		}
	//	}

	/**
	 * This merges the given {@link TargetSectionReference} 'copy' into the the given {@link TargetSection}
	 * 'targetSection'.  Merging in this case means that before adding the reference, the algorithm checks whether
	 * the 'same' reference is already present. If this is the case, the reference is not added but all references
	 * to it are redirected to the attribute already present in the target section.
	 *
	 * @param targetSection
	 * @param att
	 */
	//	private void merge(TargetSection targetSection, TargetSectionReference ref) {
	//		for (TargetSectionReference targetSectionReference : targetSection.getReferences()) {
	//			if(checkEquality(targetSectionReference, ref)) {
	//				Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.findAll(ref., this);
	//				for (Setting setting : refs) {
	//					setting.set(targetSectionReference);
	//				}
	//				return;
	//			}
	//		}
	//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL:
				return ((InternalEList<?>)getSourceSectionModel()).basicRemove(otherEnd, msgs);
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL:
				return ((InternalEList<?>)getTargetSectionModel()).basicRemove(otherEnd, msgs);
			case PamtramPackage.PAM_TRA_M__MAPPING_MODEL:
				return ((InternalEList<?>)getMappingModel()).basicRemove(otherEnd, msgs);
			case PamtramPackage.PAM_TRA_M__CONDITION_MODEL:
				return ((InternalEList<?>)getConditionModel()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE:
				return getContextMetaModelPackage();
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL:
				return getSourceSectionModel();
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL:
				return getTargetSectionModel();
			case PamtramPackage.PAM_TRA_M__MAPPING_MODEL:
				return getMappingModel();
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
			case PamtramPackage.PAM_TRA_M__MODIFIER_SETS:
				return getModifierSets();
			case PamtramPackage.PAM_TRA_M__CONDITION_MODEL:
				return getConditionModel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE:
				getContextMetaModelPackage().clear();
				getContextMetaModelPackage().addAll((Collection<? extends EPackage>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL:
				getSourceSectionModel().clear();
				getSourceSectionModel().addAll((Collection<? extends SourceSectionModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL:
				getTargetSectionModel().clear();
				getTargetSectionModel().addAll((Collection<? extends TargetSectionModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__MAPPING_MODEL:
				getMappingModel().clear();
				getMappingModel().addAll((Collection<? extends MappingModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__CONDITION_MODEL:
				getConditionModel().clear();
				getConditionModel().addAll((Collection<? extends ConditionModel>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE:
				getContextMetaModelPackage().clear();
				return;
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL:
				getSourceSectionModel().clear();
				return;
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL:
				getTargetSectionModel().clear();
				return;
			case PamtramPackage.PAM_TRA_M__MAPPING_MODEL:
				getMappingModel().clear();
				return;
			case PamtramPackage.PAM_TRA_M__CONDITION_MODEL:
				getConditionModel().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE:
				return contextMetaModelPackage != null && !contextMetaModelPackage.isEmpty();
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL:
				return sourceSectionModel != null && !sourceSectionModel.isEmpty();
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL:
				return targetSectionModel != null && !targetSectionModel.isEmpty();
			case PamtramPackage.PAM_TRA_M__MAPPING_MODEL:
				return mappingModel != null && !mappingModel.isEmpty();
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
			case PamtramPackage.PAM_TRA_M__MODIFIER_SETS:
				return !getModifierSets().isEmpty();
			case PamtramPackage.PAM_TRA_M__CONDITION_MODEL:
				return conditionModel != null && !conditionModel.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PamtramPackage.PAM_TRA_M___MERGE_EXTENDS:
				mergeExtends();
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //PAMTraMImpl
