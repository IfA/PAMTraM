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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.impl.MappingPackageImpl;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.TargetSection;
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
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
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
			if (transformationModel != null) {
				msgs = ((InternalEObject)transformationModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL, null, msgs);
			}
			if (newTransformationModel != null) {
				msgs = ((InternalEObject)newTransformationModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL, null, msgs);
			}
			msgs = basicSetTransformationModel(newTransformationModel, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL, newTransformationModel, newTransformationModel));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<SourceSection> getSourceSections() {
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
	public EList<TargetSection> getTargetSections() {
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
	public EList<Mapping> getActiveMappings() {
		/**
		 * self.mappingModel->collect(m | m.getActiveMappings())
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@Thrown*/ List<MappingModel> mappingModel = this.getMappingModel();
		final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_mappingModel = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_MappingModel, mappingModel);
		/*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(PamtramTables.SEQ_CLSSid_Mapping);
		/*@Nullable*/ Iterator<?> ITERATOR_m = BOXED_mappingModel.iterator();
		/*@NonNull*/ /*@Thrown*/ SequenceValue collect;
		while (true) {
			if (!ITERATOR_m.hasNext()) {
				collect = accumulator;
				break;
			}
			/*@Nullable*/ /*@NonInvalid*/ MappingModel m = (MappingModel)ITERATOR_m.next();
			/**
			 * m.getActiveMappings()
			 */
			if (m == null) {
				throw new InvalidValueException("Null source for \'pamtram::MappingModel::getActiveMappings() : OrderedSet(pamtram::mapping::Mapping)\'");
			}
			final /*@NonNull*/ /*@Thrown*/ List<Mapping> getActiveMappings = m.getActiveMappings();
			final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_getActiveMappings = idResolver.createOrderedSetOfAll(PamtramTables.ORD_CLSSid_Mapping, getActiveMappings);
			//
			for (Object value : BOXED_getActiveMappings.flatten().getElements()) {
				accumulator.add(value);
			}
		}
		final List<Mapping> UNBOXED_collect = collect.asEcoreObjects(idResolver, pamtram.mapping.Mapping.class);
		assert UNBOXED_collect != null;
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=474307
		return new EcoreEList.UnmodifiableEList.FastCompare<> 
		(this, PamtramPackage.Literals.PAM_TRA_M__ACTIVE_MAPPINGS, UNBOXED_collect.size(), UNBOXED_collect.toArray()); 
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
			if(section.isAbstract()) {
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
			if(section.isAbstract()) {
				LinkedList<Section> concreteSections = new LinkedList<>();
				for (Setting setting : targetSettings.get(section)) {
					if(setting.getEStructuralFeature().equals(MetamodelPackageImpl.eINSTANCE.getSection_Extend())) {
						concreteSections.add((Section) setting.getEObject());
					}
				}
				abstractToConcreteSectionMap.put(section, concreteSections);
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

			}
		}

		/*
		 * Finally, we can copy the abstract hint groups
		 */

		// collect all abstract mappings
		ArrayList<Mapping> abstractMappings = new ArrayList<>();
		for (Mapping mapping : this.getMappings()) {
			if(mapping.isAbstract()) {
				abstractMappings.add(mapping);
			}
		}

		// collect each abstract hint group as well as the concrete hint groups that
		HashMap<MappingHintGroupType, LinkedList<MappingHintGroupType>> abstractToConcreteHintGroupMap = new HashMap<>();
		Map<EObject, Collection<Setting>> mappingSettings = EcoreUtil.CrossReferencer.find(getMappings());
		for (EObject element : mappingSettings.keySet()) {
			if(element instanceof MappingHintGroupType && ((Mapping)(element.eContainer())).isAbstract()) {
				LinkedList<MappingHintGroupType> concreteHintGroups = new LinkedList<>();
				for (Setting setting : mappingSettings.get(element)) {
					if(setting.getEStructuralFeature().equals(MappingPackageImpl.eINSTANCE.getMappingHintGroupType_Extend())) {
						concreteHintGroups.add((MappingHintGroupType) setting.getEObject());
					}
				}
				abstractToConcreteHintGroupMap.put((MappingHintGroupType) element, concreteHintGroups);
			}
		}

		// copy the hints to the concrete hint groups
		for (MappingHintGroupType abstractHintGroup : abstractToConcreteHintGroupMap.keySet()) {
			for (MappingHintGroupType concreteHintGroup : abstractToConcreteHintGroupMap.get(abstractHintGroup)) {
				Collection<MappingHint> copiedHints = EcoreUtil.copyAll(abstractHintGroup.getMappingHints());

				/* 
				 * make sure that all references to elements from the abstract sections are redirected to the concrete sections
				 * that we created earlier
				 */
				for (MappingHint copiedHint : copiedHints) {

					/* 
					 * these are the references from the copied hint (that will get added to the concrete hint group) to elements from
					 * abstract sections
					 */
					Map<EObject, Collection<Setting>> refsToAbstractSection = EcoreUtil.UsageCrossReferencer.findAll(abstractToConcreteElementMap.keySet(), copiedHint);
					for (EObject referencedObject : refsToAbstractSection.keySet()) {

						// these are possible targets for the redirection of references to the referenced object
						LinkedList<EObject> possibleTargets = abstractToConcreteElementMap.get(referencedObject);

						ArrayList<Section> sourceAndTargetSections = new ArrayList<>();
						//TODO do we need to take other sections (e.g. container sections) into account???
						sourceAndTargetSections.add(((Mapping) concreteHintGroup.eContainer()).getSourceMMSection());
						sourceAndTargetSections.add(concreteHintGroup.getTargetMMSection());

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
							throw new RuntimeException("Internal error! Now target found for redirection of element '" + referencedObject + "'.");
						}

						for (Setting setting : refsToAbstractSection.get(referencedObject)) {
							setting.set(target);
						}
					}

				}

				concreteHintGroup.getMappingHints().addAll(copiedHints);
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
		case PamtramPackage.PAM_TRA_M___MERGE_EXTENDS:
			mergeExtends();
			return null;
		case PamtramPackage.PAM_TRA_M___SOURCE_SECTION_MODELS_HAVE_SAME_EPACKAGE__DIAGNOSTICCHAIN_MAP:
			return sourceSectionModelsHaveSameEPackage((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		case PamtramPackage.PAM_TRA_M___TARGET_SECTION_MODELS_HAVE_SAME_EPACKAGE__DIAGNOSTICCHAIN_MAP:
			return targetSectionModelsHaveSameEPackage((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //PAMTraMImpl
