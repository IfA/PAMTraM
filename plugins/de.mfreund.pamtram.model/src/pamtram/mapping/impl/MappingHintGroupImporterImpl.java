/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsTypeOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;
import pamtram.PamtramPackage;
import pamtram.PamtramTables;
import pamtram.condition.ComplexCondition;
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hint Group Importer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImporterImpl#isDeactivated <em>Deactivated</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImporterImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImporterImpl#getConditionRef <em>Condition Ref</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImporterImpl#getHintGroup <em>Hint Group</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImporterImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImporterImpl#getMappingHints <em>Mapping Hints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingHintGroupImporterImpl extends NamedElementImpl implements MappingHintGroupImporter {
	/**
	 * The default value of the '{@link #isDeactivated() <em>Deactivated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeactivated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEACTIVATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeactivated() <em>Deactivated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeactivated()
	 * @generated
	 * @ordered
	 */
	protected boolean deactivated = DEACTIVATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition condition;

	/**
	 * The cached value of the '{@link #getConditionRef() <em>Condition Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionRef()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition conditionRef;

	/**
	 * The cached value of the '{@link #getHintGroup() <em>Hint Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHintGroup()
	 * @generated
	 * @ordered
	 */
	protected ExportedMappingHintGroup hintGroup;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionClass container;

	/**
	 * This is true if the Container reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean containerESet;

	/**
	 * The cached value of the '{@link #getMappingHints() <em>Mapping Hints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingHints()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingHintType> mappingHints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingHintGroupImporterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDeactivated() {
		return deactivated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeactivated(boolean newDeactivated) {
		boolean oldDeactivated = deactivated;
		deactivated = newDeactivated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED, oldDeactivated, deactivated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComplexCondition getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(ComplexCondition newCondition, NotificationChain msgs) {
		ComplexCondition oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION, oldCondition, newCondition);
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
	public void setCondition(ComplexCondition newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComplexCondition getConditionRef() {
		if (conditionRef != null && conditionRef.eIsProxy()) {
			InternalEObject oldConditionRef = (InternalEObject)conditionRef;
			conditionRef = (ComplexCondition)eResolveProxy(oldConditionRef);
			if (conditionRef != oldConditionRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION_REF, oldConditionRef, conditionRef));
			}
		}
		return conditionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexCondition basicGetConditionRef() {
		return conditionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConditionRef(ComplexCondition newConditionRef) {
		ComplexCondition oldConditionRef = conditionRef;
		conditionRef = newConditionRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION_REF, oldConditionRef, conditionRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExportedMappingHintGroup getHintGroup() {
		if (hintGroup != null && hintGroup.eIsProxy()) {
			InternalEObject oldHintGroup = (InternalEObject)hintGroup;
			hintGroup = (ExportedMappingHintGroup)eResolveProxy(oldHintGroup);
			if (hintGroup != oldHintGroup) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP, oldHintGroup, hintGroup));
			}
		}
		return hintGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportedMappingHintGroup basicGetHintGroup() {
		return hintGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHintGroup(ExportedMappingHintGroup newHintGroup) {
		ExportedMappingHintGroup oldHintGroup = hintGroup;
		hintGroup = newHintGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP, oldHintGroup, hintGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSectionClass getContainer() {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject)container;
			container = (TargetSectionClass)eResolveProxy(oldContainer);
			if (container != oldContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass basicGetContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContainer(TargetSectionClass newContainer) {
		TargetSectionClass oldContainer = container;
		container = newContainer;
		boolean oldContainerESet = containerESet;
		containerESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONTAINER, oldContainer, container, !oldContainerESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetContainer() {
		TargetSectionClass oldContainer = container;
		boolean oldContainerESet = containerESet;
		container = null;
		containerESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONTAINER, oldContainer, null, oldContainerESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetContainer() {
		return containerESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingHintType> getMappingHints() {
		if (mappingHints == null) {
			mappingHints = new EObjectContainmentEList.Unsettable<MappingHintType>(MappingHintType.class, this, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS);
		}
		return mappingHints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMappingHints() {
		if (mappingHints != null) ((InternalEList.Unsettable<?>)mappingHints).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMappingHints() {
		return mappingHints != null && ((InternalEList.Unsettable<?>)mappingHints).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eitherModelOrReferCondition(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv eitherModelOrReferCondition:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = self.conditionRef->size() +
		 *       self.condition->size() <= 1
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'As this Instance is a ConditionElement and you want to add a condition, you either have to model a condition or reference an already existing one!'
		 *         else null
		 *         endif
		 *       in
		 *         'ConditionalElement::eitherModelOrReferCondition'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		/*@Caught*/ /*@NonNull*/ Object CAUGHT_status;
		try {
		    final /*@Thrown*/ ComplexCondition conditionRef = this.getConditionRef();
		    final /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, PamtramTables.SET_CLSSid_ComplexCondition, conditionRef);
		    final /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(oclAsSet);
		    final /*@Thrown*/ ComplexCondition condition = this.getCondition();
		    final /*@Thrown*/ SetValue oclAsSet_0 = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, PamtramTables.SET_CLSSid_ComplexCondition, condition);
		    final /*@Thrown*/ IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(oclAsSet_0);
		    final /*@Thrown*/ IntegerValue sum = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(size, size_0);
		    final /*@Thrown*/ boolean status = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, sum, PamtramTables.INT_1).booleanValue();
		    CAUGHT_status = status;
		}
		catch (Exception e) {
		    CAUGHT_status = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_status instanceof InvalidValueException) {
		    throw (InvalidValueException)CAUGHT_status;
		}
		final /*@Thrown*/ boolean ne = CAUGHT_status == Boolean.FALSE;
		/*@NonInvalid*/ String message_0;
		if (ne) {
		    message_0 = PamtramTables.STR_As_32_this_32_Instance_32_is_32_a_32_ConditionElement_32_and_32_you_32_want_32_to_32_add_32_a_32_con;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PamtramTables.STR_ConditionalElement_c_c_eitherModelOrReferCondition, this, null, diagnostics, context, message_0, PamtramTables.INT_4, CAUGHT_status, PamtramTables.INT_0).booleanValue();
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean referenceOnlyConditionsFromConditionModel(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv referenceOnlyConditionsFromConditionModel:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = if self.conditionRef->size() = 1
		 *       then
		 *         self.conditionRef.oclContainer()
		 *         .oclIsTypeOf(ConditionModel)
		 *       else true
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'It only allowed to reference Condition-Instances that are model inside the ConditionModel!'
		 *         else null
		 *         endif
		 *       in
		 *         'ConditionalElement::referenceOnlyConditionsFromConditionModel'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ /*@NonNull*/ Object CAUGHT_status;
		try {
		    final /*@Thrown*/ ComplexCondition conditionRef_0 = this.getConditionRef();
		    final /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, PamtramTables.SET_CLSSid_ComplexCondition, conditionRef_0);
		    final /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(oclAsSet);
		    final /*@Thrown*/ boolean eq = size.equals(PamtramTables.INT_1);
		    /*@Thrown*/ boolean status;
		    if (eq) {
		        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_ConditionModel = idResolver.getClass(PamtramTables.CLSSid_ConditionModel, null);
		        final /*@Thrown*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, conditionRef_0);
		        final /*@Thrown*/ boolean oclIsTypeOf = OclAnyOclIsTypeOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_pamtram_c_c_ConditionModel).booleanValue();
		        status = oclIsTypeOf;
		    }
		    else {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    CAUGHT_status = status;
		}
		catch (Exception e) {
		    CAUGHT_status = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_status instanceof InvalidValueException) {
		    throw (InvalidValueException)CAUGHT_status;
		}
		final /*@Thrown*/ boolean ne = CAUGHT_status == Boolean.FALSE;
		/*@NonInvalid*/ String message_0;
		if (ne) {
		    message_0 = PamtramTables.STR_It_32_only_32_allowed_32_to_32_reference_32_Condition_m_Instances_32_that_32_are_32_model_32;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PamtramTables.STR_ConditionalElement_c_c_referenceOnlyConditionsFromConditionModel, this, null, diagnostics, context, message_0, PamtramTables.INT_4, CAUGHT_status, PamtramTables.INT_0).booleanValue();
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
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION:
				return basicSetCondition(null, msgs);
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS:
				return ((InternalEList<?>)getMappingHints()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED:
				return isDeactivated();
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION:
				return getCondition();
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION_REF:
				if (resolve) return getConditionRef();
				return basicGetConditionRef();
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP:
				if (resolve) return getHintGroup();
				return basicGetHintGroup();
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS:
				return getMappingHints();
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
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED:
				setDeactivated((Boolean)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION:
				setCondition((ComplexCondition)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION_REF:
				setConditionRef((ComplexCondition)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP:
				setHintGroup((ExportedMappingHintGroup)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONTAINER:
				setContainer((TargetSectionClass)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS:
				getMappingHints().clear();
				getMappingHints().addAll((Collection<? extends MappingHintType>)newValue);
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
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED:
				setDeactivated(DEACTIVATED_EDEFAULT);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION:
				setCondition((ComplexCondition)null);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION_REF:
				setConditionRef((ComplexCondition)null);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP:
				setHintGroup((ExportedMappingHintGroup)null);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONTAINER:
				unsetContainer();
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS:
				unsetMappingHints();
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
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED:
				return deactivated != DEACTIVATED_EDEFAULT;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION:
				return condition != null;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION_REF:
				return conditionRef != null;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP:
				return hintGroup != null;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONTAINER:
				return isSetContainer();
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS:
				return isSetMappingHints();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DeactivatableElement.class) {
			switch (derivedFeatureID) {
				case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED: return PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED;
				default: return -1;
			}
		}
		if (baseClass == ConditionalElement.class) {
			switch (derivedFeatureID) {
				case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION: return PamtramPackage.CONDITIONAL_ELEMENT__CONDITION;
				case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION_REF: return PamtramPackage.CONDITIONAL_ELEMENT__CONDITION_REF;
				default: return -1;
			}
		}
		if (baseClass == InstantiableMappingHintGroup.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DeactivatableElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED: return MappingPackage.MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED;
				default: return -1;
			}
		}
		if (baseClass == ConditionalElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.CONDITIONAL_ELEMENT__CONDITION: return MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION;
				case PamtramPackage.CONDITIONAL_ELEMENT__CONDITION_REF: return MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONDITION_REF;
				default: return -1;
			}
		}
		if (baseClass == InstantiableMappingHintGroup.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == DeactivatableElement.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == ConditionalElement.class) {
			switch (baseOperationID) {
				case PamtramPackage.CONDITIONAL_ELEMENT___EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP_4: return MappingPackage.MAPPING_HINT_GROUP_IMPORTER___EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP_4;
				case PamtramPackage.CONDITIONAL_ELEMENT___REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP_4: return MappingPackage.MAPPING_HINT_GROUP_IMPORTER___REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP_4;
				default: return -1;
			}
		}
		if (baseClass == InstantiableMappingHintGroup.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER___EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP_4:
				return eitherModelOrReferCondition((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER___REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP_4:
				return referenceOnlyConditionsFromConditionModel((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (deactivated: ");
		result.append(deactivated);
		result.append(')');
		return result.toString();
	}

	@Override
	public TargetSection getTargetMMSectionGeneric() {
		return this.getHintGroup() == null ? null : this.getHintGroup().getTargetSection();
	}

} //MappingHintGroupImporterImpl
