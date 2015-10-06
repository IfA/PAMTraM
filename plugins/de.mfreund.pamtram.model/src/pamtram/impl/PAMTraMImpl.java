/**
 */
package pamtram.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.PamtramTables;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.TransformationModel;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.GlobalValue;
import pamtram.mapping.Mapping;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSectionClass;

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
 *   <li>{@link pamtram.impl.PAMTraMImpl#getTransformationModel <em>Transformation Model</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSourceSections <em>Source Sections</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getTargetSections <em>Target Sections</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getActiveMappings <em>Active Mappings</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getGlobalValues <em>Global Values</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getModifierSets <em>Modifier Sets</em>}</li>
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
	 * The cached value of the '{@link #getTransformationModel() <em>Transformation Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformationModel()
	 * @generated
	 * @ordered
	 */
	protected TransformationModel transformationModel;

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
	public TransformationModel getTransformationModel() {
		return transformationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformationModel(TransformationModel newTransformationModel, NotificationChain msgs) {
		TransformationModel oldTransformationModel = transformationModel;
		transformationModel = newTransformationModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL, oldTransformationModel, newTransformationModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransformationModel(TransformationModel newTransformationModel) {
		if (newTransformationModel != transformationModel) {
			NotificationChain msgs = null;
			if (transformationModel != null)
				msgs = ((InternalEObject)transformationModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL, null, msgs);
			if (newTransformationModel != null)
				msgs = ((InternalEObject)newTransformationModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL, null, msgs);
			msgs = basicSetTransformationModel(newTransformationModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL, newTransformationModel, newTransformationModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<SourceSectionClass> getSourceSections() {
		/**
		 * self.sourceSectionModel->collect(s | s.metaModelSections)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@Thrown*/ List<SourceSectionModel> sourceSectionModel = this.getSourceSectionModel();
		final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_sourceSectionModel = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_SourceSectionModel, sourceSectionModel);
		/*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(PamtramTables.SEQ_TMPLid_);
		/*@Nullable*/ Iterator<?> ITERATOR_s = BOXED_sourceSectionModel.iterator();
		/*@NonNull*/ /*@Thrown*/ SequenceValue collect;
		while (true) {
			if (!ITERATOR_s.hasNext()) {
				collect = accumulator;
				break;
			}
			/*@Nullable*/ /*@NonInvalid*/ SourceSectionModel s = (SourceSectionModel)ITERATOR_s.next();
			/**
			 * s.metaModelSections
			 */
			if (s == null) {
				throw new InvalidValueException("Null source for \'\'http://mfreund.de/pamtram\'::SectionModel::metaModelSections\'");
			}
			final /*@NonNull*/ /*@Thrown*/ List<? extends Object> metaModelSections = s.getMetaModelSections();
			final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_metaModelSections = idResolver.createOrderedSetOfAll(PamtramTables.ORD_TMPLid_, metaModelSections);
			//
			for (Object value : BOXED_metaModelSections.flatten().getElements()) {
				accumulator.add(value);
			}
		}
		final List<? extends Object> UNBOXED_collect = collect.asEcoreObjects(idResolver, Object.class);
		assert UNBOXED_collect != null;
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=474307
		return new EcoreEList.UnmodifiableEList.FastCompare<> 
		(this, PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTIONS, UNBOXED_collect.size(), UNBOXED_collect.toArray()); 
		//		return (EList<SourceSectionClass>)UNBOXED_collect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<TargetSectionClass> getTargetSections() {
		/**
		 * self.targetSectionModel->collect(s | s.metaModelSections)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@Thrown*/ List<TargetSectionModel> targetSectionModel = this.getTargetSectionModel();
		final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_targetSectionModel = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_TargetSectionModel, targetSectionModel);
		/*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(PamtramTables.SEQ_TMPLid_);
		/*@Nullable*/ Iterator<?> ITERATOR_s = BOXED_targetSectionModel.iterator();
		/*@NonNull*/ /*@Thrown*/ SequenceValue collect;
		while (true) {
			if (!ITERATOR_s.hasNext()) {
				collect = accumulator;
				break;
			}
			/*@Nullable*/ /*@NonInvalid*/ TargetSectionModel s = (TargetSectionModel)ITERATOR_s.next();
			/**
			 * s.metaModelSections
			 */
			if (s == null) {
				throw new InvalidValueException("Null source for \'\'http://mfreund.de/pamtram\'::SectionModel::metaModelSections\'");
			}
			final /*@NonNull*/ /*@Thrown*/ List<? extends Object> metaModelSections = s.getMetaModelSections();
			final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_metaModelSections = idResolver.createOrderedSetOfAll(PamtramTables.ORD_TMPLid_, metaModelSections);
			//
			for (Object value : BOXED_metaModelSections.flatten().getElements()) {
				accumulator.add(value);
			}
		}
		final List<? extends Object> UNBOXED_collect = collect.asEcoreObjects(idResolver, Object.class);
		assert UNBOXED_collect != null;
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=474307
		return new EcoreEList.UnmodifiableEList.FastCompare<> 
		(this, PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTIONS, UNBOXED_collect.size(), UNBOXED_collect.toArray()); 
		//		return (EList<TargetSectionClass>)UNBOXED_collect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<Mapping> getMappings() {
		/**
		 * self.mappingModel->collect(s | s.mapping)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@Thrown*/ List<MappingModel> mappingModel = this.getMappingModel();
		final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_mappingModel = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_MappingModel, mappingModel);
		/*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(PamtramTables.SEQ_CLSSid_Mapping);
		/*@Nullable*/ Iterator<?> ITERATOR_s = BOXED_mappingModel.iterator();
		/*@NonNull*/ /*@Thrown*/ SequenceValue collect;
		while (true) {
			if (!ITERATOR_s.hasNext()) {
				collect = accumulator;
				break;
			}
			/*@Nullable*/ /*@NonInvalid*/ MappingModel s = (MappingModel)ITERATOR_s.next();
			/**
			 * s.mapping
			 */
			if (s == null) {
				throw new InvalidValueException("Null source for \'\'http://mfreund.de/pamtram\'::MappingModel::mapping\'");
			}
			final /*@NonNull*/ /*@Thrown*/ List<Mapping> mapping = s.getMapping();
			final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_mapping = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_Mapping, mapping);
			//
			for (Object value : BOXED_mapping.flatten().getElements()) {
				accumulator.add(value);
			}
		}
		final List<Mapping> UNBOXED_collect = collect.asEcoreObjects(idResolver, pamtram.mapping.Mapping.class);
		assert UNBOXED_collect != null;
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=474307
		return new EcoreEList.UnmodifiableEList.FastCompare<> 
		(this, PamtramPackage.Literals.PAM_TRA_M__MAPPINGS, UNBOXED_collect.size(), UNBOXED_collect.toArray()); 
		//		return (EList<Mapping>)UNBOXED_collect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<Mapping> getActiveMappings() {
		/**
		 * 
		 * self.mappingModel->collect(s | s.mapping)
		 * ->select(m | m.deactivated = false)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@Thrown*/ List<MappingModel> mappingModel = this.getMappingModel();
		final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_mappingModel = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_MappingModel, mappingModel);
		/*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(PamtramTables.SEQ_CLSSid_Mapping);
		/*@Nullable*/ Iterator<?> ITERATOR_s = BOXED_mappingModel.iterator();
		/*@NonNull*/ /*@Thrown*/ SequenceValue collect;
		while (true) {
			if (!ITERATOR_s.hasNext()) {
				collect = accumulator;
				break;
			}
			/*@Nullable*/ /*@NonInvalid*/ MappingModel s = (MappingModel)ITERATOR_s.next();
			/**
			 * s.mapping
			 */
			if (s == null) {
				throw new InvalidValueException("Null source for \'\'http://mfreund.de/pamtram\'::MappingModel::mapping\'");
			}
			final /*@NonNull*/ /*@Thrown*/ List<Mapping> mapping = s.getMapping();
			final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_mapping = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_Mapping, mapping);
			//
			for (Object value : BOXED_mapping.flatten().getElements()) {
				accumulator.add(value);
			}
		}
		/*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(PamtramTables.SEQ_CLSSid_Mapping);
		/*@Nullable*/ Iterator<?> ITERATOR_m = collect.iterator();
		/*@NonNull*/ /*@Thrown*/ SequenceValue select;
		while (true) {
			if (!ITERATOR_m.hasNext()) {
				select = accumulator_0;
				break;
			}
			/*@Nullable*/ /*@NonInvalid*/ Mapping m = (Mapping)ITERATOR_m.next();
			/**
			 * m.deactivated = false
			 */
			if (m == null) {
				throw new InvalidValueException("Null source for \'\'http://mfreund.de/pamtram\'::DeactivatableElement::deactivated\'");
			}
			final /*@Thrown*/ boolean deactivated = m.isDeactivated();
			final /*@Thrown*/ boolean eq = !deactivated;
			//
			if (eq == ValueUtil.TRUE_VALUE) {
				accumulator_0.add(m);
			}
		}
		final List<Mapping> UNBOXED_select = select.asEcoreObjects(idResolver, pamtram.mapping.Mapping.class);
		assert UNBOXED_select != null;
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=474307
		return new EcoreEList.UnmodifiableEList.FastCompare<> 
		(this, PamtramPackage.Literals.PAM_TRA_M__ACTIVE_MAPPINGS, UNBOXED_select.size(), UNBOXED_select.toArray()); 
		//		return (EList<Mapping>)UNBOXED_select;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<GlobalValue> getGlobalValues() {
		/**
		 * self.mappingModel->collect(s | s.globalValues)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@Thrown*/ List<MappingModel> mappingModel = this.getMappingModel();
		final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_mappingModel = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_MappingModel, mappingModel);
		/*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(PamtramTables.SEQ_CLSSid_GlobalValue);
		/*@Nullable*/ Iterator<?> ITERATOR_s = BOXED_mappingModel.iterator();
		/*@NonNull*/ /*@Thrown*/ SequenceValue collect;
		while (true) {
		    if (!ITERATOR_s.hasNext()) {
		        collect = accumulator;
		        break;
		    }
		    /*@Nullable*/ /*@NonInvalid*/ MappingModel s = (MappingModel)ITERATOR_s.next();
		    /**
		     * s.globalValues
		     */
		    if (s == null) {
		        throw new InvalidValueException("Null source for \'\'http://mfreund.de/pamtram\'::MappingModel::globalValues\'");
		    }
		    final /*@NonNull*/ /*@Thrown*/ List<GlobalValue> globalValues = s.getGlobalValues();
		    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_globalValues = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_GlobalValue, globalValues);
		    //
		    for (Object value : BOXED_globalValues.flatten().getElements()) {
		        accumulator.add(value);
		    }
		}
		final List<GlobalValue> UNBOXED_collect = collect.asEcoreObjects(idResolver, pamtram.mapping.GlobalValue.class);
		assert UNBOXED_collect != null;
		return (EList<GlobalValue>)UNBOXED_collect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<AttributeValueModifierSet> getModifierSets() {
		/**
		 * self.mappingModel->collect(s | s.modifierSets)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@Thrown*/ List<MappingModel> mappingModel = this.getMappingModel();
		final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_mappingModel = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_MappingModel, mappingModel);
		/*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(PamtramTables.SEQ_CLSSid_AttributeValueModifierSet);
		/*@Nullable*/ Iterator<?> ITERATOR_s = BOXED_mappingModel.iterator();
		/*@NonNull*/ /*@Thrown*/ SequenceValue collect;
		while (true) {
		    if (!ITERATOR_s.hasNext()) {
		        collect = accumulator;
		        break;
		    }
		    /*@Nullable*/ /*@NonInvalid*/ MappingModel s = (MappingModel)ITERATOR_s.next();
		    /**
		     * s.modifierSets
		     */
		    if (s == null) {
		        throw new InvalidValueException("Null source for \'\'http://mfreund.de/pamtram\'::MappingModel::modifierSets\'");
		    }
		    final /*@NonNull*/ /*@Thrown*/ List<AttributeValueModifierSet> modifierSets = s.getModifierSets();
		    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_modifierSets = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_AttributeValueModifierSet, modifierSets);
		    //
		    for (Object value : BOXED_modifierSets.flatten().getElements()) {
		        accumulator.add(value);
		    }
		}
		final List<AttributeValueModifierSet> UNBOXED_collect = collect.asEcoreObjects(idResolver, pamtram.mapping.AttributeValueModifierSet.class);
		assert UNBOXED_collect != null;
		return (EList<AttributeValueModifierSet>)UNBOXED_collect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean sourceSectionModelsHaveSameEPackage(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv sourceSectionModelsHaveSameEPackage:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = self.sourceSectionModel->collect(s | s.metaModelPackage)
		 *       ->asSet()
		 *       ->size() <= 1
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'Not all SourceSectionModels specify the same EPackage. This is currently not supported!'
		 *         else null
		 *         endif
		 *       in
		 *         'PAMTraM::sourceSectionModelsHaveSameEPackage'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@NonNull*/ /*@Thrown*/ List<SourceSectionModel> sourceSectionModel = this.getSourceSectionModel();
		    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_sourceSectionModel = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_SourceSectionModel, sourceSectionModel);
		    /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(PamtramTables.SEQ_CLSSid_EPackage);
		    /*@Nullable*/ Iterator<?> ITERATOR_s = BOXED_sourceSectionModel.iterator();
		    /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
		    while (true) {
		        if (!ITERATOR_s.hasNext()) {
		            collect = accumulator;
		            break;
		        }
		        /*@Nullable*/ /*@NonInvalid*/ SourceSectionModel s = (SourceSectionModel)ITERATOR_s.next();
		        /**
		         * s.metaModelPackage
		         */
		        if (s == null) {
		            throw new InvalidValueException("Null source for \'\'http://mfreund.de/pamtram\'::SectionModel::metaModelPackage\'");
		        }
		        final /*@NonNull*/ /*@Thrown*/ EPackage metaModelPackage = s.getMetaModelPackage();
		        //
		        accumulator.add(metaModelPackage);
		    }
		    final /*@NonNull*/ /*@Thrown*/ SetValue asSet = ClassUtil.nonNullState(CollectionAsSetOperation.INSTANCE.evaluate(collect));
		    final /*@NonNull*/ /*@Thrown*/ IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(asSet));
		    final /*@Thrown*/ boolean status = ClassUtil.nonNullState(OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, size, PamtramTables.INT_1).booleanValue());
		    CAUGHT_status = status;
		}
		catch (Exception e) {
		    CAUGHT_status = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_status instanceof InvalidValueException) {
		    throw (InvalidValueException)CAUGHT_status;
		}
		final /*@Thrown*/ boolean ne = CAUGHT_status == Boolean.FALSE;
		/*@Nullable*/ /*@NonInvalid*/ String message_0;
		if (ne) {
		    message_0 = PamtramTables.STR_Not_32_all_32_SourceSectionModels_32_specify_32_the_32_same_32_EPackage_32_This_32_is_32_c;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PamtramTables.STR_PAMTraM_c_c_sourceSectionModelsHaveSameEPackage, this, null, diagnostics, context, message_0, PamtramTables.INT_4, CAUGHT_status, PamtramTables.INT_0).booleanValue());
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean targetSectionModelsHaveSameEPackage(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv targetSectionModelsHaveSameEPackage:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = self.targetSectionModel->collect(s | s.metaModelPackage)
		 *       ->asSet()
		 *       ->size() <= 1
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'Not all TargetSectionModels specify the same EPackage. This is currently not supported!'
		 *         else null
		 *         endif
		 *       in
		 *         'PAMTraM::targetSectionModelsHaveSameEPackage'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@NonNull*/ /*@Thrown*/ List<TargetSectionModel> targetSectionModel = this.getTargetSectionModel();
		    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_targetSectionModel = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_TargetSectionModel, targetSectionModel);
		    /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(PamtramTables.SEQ_CLSSid_EPackage);
		    /*@Nullable*/ Iterator<?> ITERATOR_s = BOXED_targetSectionModel.iterator();
		    /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
		    while (true) {
		        if (!ITERATOR_s.hasNext()) {
		            collect = accumulator;
		            break;
		        }
		        /*@Nullable*/ /*@NonInvalid*/ TargetSectionModel s = (TargetSectionModel)ITERATOR_s.next();
		        /**
		         * s.metaModelPackage
		         */
		        if (s == null) {
		            throw new InvalidValueException("Null source for \'\'http://mfreund.de/pamtram\'::SectionModel::metaModelPackage\'");
		        }
		        final /*@NonNull*/ /*@Thrown*/ EPackage metaModelPackage = s.getMetaModelPackage();
		        //
		        accumulator.add(metaModelPackage);
		    }
		    final /*@NonNull*/ /*@Thrown*/ SetValue asSet = ClassUtil.nonNullState(CollectionAsSetOperation.INSTANCE.evaluate(collect));
		    final /*@NonNull*/ /*@Thrown*/ IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(asSet));
		    final /*@Thrown*/ boolean status = ClassUtil.nonNullState(OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, size, PamtramTables.INT_1).booleanValue());
		    CAUGHT_status = status;
		}
		catch (Exception e) {
		    CAUGHT_status = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_status instanceof InvalidValueException) {
		    throw (InvalidValueException)CAUGHT_status;
		}
		final /*@Thrown*/ boolean ne = CAUGHT_status == Boolean.FALSE;
		/*@Nullable*/ /*@NonInvalid*/ String message_0;
		if (ne) {
		    message_0 = PamtramTables.STR_Not_32_all_32_TargetSectionModels_32_specify_32_the_32_same_32_EPackage_32_This_32_is_32_c;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PamtramTables.STR_PAMTraM_c_c_targetSectionModelsHaveSameEPackage, this, null, diagnostics, context, message_0, PamtramTables.INT_4, CAUGHT_status, PamtramTables.INT_0).booleanValue());
		return Boolean.TRUE == logDiagnostic;
	}

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
			case PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL:
				return basicSetTransformationModel(null, msgs);
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
			case PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL:
				return getTransformationModel();
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
			case PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL:
				setTransformationModel((TransformationModel)newValue);
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
			case PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL:
				setTransformationModel((TransformationModel)null);
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
			case PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL:
				return transformationModel != null;
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
			case PamtramPackage.PAM_TRA_M___SOURCE_SECTION_MODELS_HAVE_SAME_EPACKAGE__DIAGNOSTICCHAIN_MAP_10:
				return sourceSectionModelsHaveSameEPackage((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PamtramPackage.PAM_TRA_M___TARGET_SECTION_MODELS_HAVE_SAME_EPACKAGE__DIAGNOSTICCHAIN_MAP_10:
				return targetSectionModelsHaveSameEPackage((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //PAMTraMImpl
