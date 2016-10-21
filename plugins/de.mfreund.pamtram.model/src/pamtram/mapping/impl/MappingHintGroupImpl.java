/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
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
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.ContainerSelector;
import pamtram.metamodel.TargetSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hint Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImpl#isDeactivated <em>Deactivated</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImpl#getLocalCondition <em>Local Condition</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImpl#getSharedCondition <em>Shared Condition</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImpl#getModelConnectionMatcher <em>Model Connection Matcher</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingHintGroupImpl extends MappingHintGroupTypeImpl implements MappingHintGroup {
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
	 * The cached value of the '{@link #getLocalCondition() <em>Local Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalCondition()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition localCondition;
	/**
	 * The cached value of the '{@link #getSharedCondition() <em>Shared Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedCondition()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition sharedCondition;
	/**
	 * The cached value of the '{@link #getContainerSelector() <em>Model Connection Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerSelector()
	 * @generated
	 * @ordered
	 */
	protected ContainerSelector containerSelector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingHintGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPING_HINT_GROUP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED, oldDeactivated, deactivated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComplexCondition getLocalCondition() {
		return localCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocalCondition(ComplexCondition newLocalCondition, NotificationChain msgs) {
		ComplexCondition oldLocalCondition = localCondition;
		localCondition = newLocalCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP__LOCAL_CONDITION, oldLocalCondition, newLocalCondition);
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
	public void setLocalCondition(ComplexCondition newLocalCondition) {
		if (newLocalCondition != localCondition) {
			NotificationChain msgs = null;
			if (localCondition != null)
				msgs = ((InternalEObject)localCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING_HINT_GROUP__LOCAL_CONDITION, null, msgs);
			if (newLocalCondition != null)
				msgs = ((InternalEObject)newLocalCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING_HINT_GROUP__LOCAL_CONDITION, null, msgs);
			msgs = basicSetLocalCondition(newLocalCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP__LOCAL_CONDITION, newLocalCondition, newLocalCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComplexCondition getSharedCondition() {
		if (sharedCondition != null && sharedCondition.eIsProxy()) {
			InternalEObject oldSharedCondition = (InternalEObject)sharedCondition;
			sharedCondition = (ComplexCondition)eResolveProxy(oldSharedCondition);
			if (sharedCondition != oldSharedCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING_HINT_GROUP__SHARED_CONDITION, oldSharedCondition, sharedCondition));
			}
		}
		return sharedCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexCondition basicGetSharedCondition() {
		return sharedCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSharedCondition(ComplexCondition newSharedCondition) {
		ComplexCondition oldSharedCondition = sharedCondition;
		sharedCondition = newSharedCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP__SHARED_CONDITION, oldSharedCondition, sharedCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContainerSelector getContainerSelector() {
		return containerSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainerSelector(ContainerSelector newModelConnectionMatcher, NotificationChain msgs) {
		ContainerSelector oldModelConnectionMatcher = containerSelector;
		containerSelector = newModelConnectionMatcher;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER, oldModelConnectionMatcher, newModelConnectionMatcher);
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
	public void setContainerSelector(ContainerSelector newModelConnectionMatcher) {
		if (newModelConnectionMatcher != containerSelector) {
			NotificationChain msgs = null;
			if (containerSelector != null)
				msgs = ((InternalEObject)containerSelector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER, null, msgs);
			if (newModelConnectionMatcher != null)
				msgs = ((InternalEObject)newModelConnectionMatcher).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER, null, msgs);
			msgs = basicSetContainerSelector(newModelConnectionMatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER, newModelConnectionMatcher, newModelConnectionMatcher));
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
		 *       status : OclAny[1] = self.sharedCondition->size() +
		 *       self.localCondition->size() <= 1
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'Please specify at most one (local or shared) condition!'
		 *         else null
		 *         endif
		 *       in
		 *         'ConditionalElement::eitherModelOrReferCondition'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		/*@Caught*/ /*@NonNull*/ Object CAUGHT_status;
		try {
		    final /*@Thrown*/ ComplexCondition sharedCondition = this.getSharedCondition();
		    final /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, PamtramTables.SET_CLSSid_ComplexCondition, sharedCondition);
		    final /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(oclAsSet);
		    final /*@Thrown*/ ComplexCondition localCondition = this.getLocalCondition();
		    final /*@Thrown*/ SetValue oclAsSet_0 = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, PamtramTables.SET_CLSSid_ComplexCondition, localCondition);
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
		    message_0 = PamtramTables.STR_Please_32_specify_32_at_32_most_32_one_32_o_local_32_or_32_shared_e_32_condition_33;
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
		 *       status : OclAny[1] = if self.sharedCondition->size() = 1
		 *       then
		 *         self.sharedCondition.oclContainer()
		 *         .oclIsTypeOf(ConditionModel)
		 *       else true
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'It only allowed to reference shared conditions that are model inside the ConditionModel!'
		 *         else null
		 *         endif
		 *       in
		 *         'ConditionalElement::referenceOnlyConditionsFromConditionModel'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ /*@NonNull*/ Object CAUGHT_status;
		try {
		    final /*@Thrown*/ ComplexCondition sharedCondition_0 = this.getSharedCondition();
		    final /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, PamtramTables.SET_CLSSid_ComplexCondition, sharedCondition_0);
		    final /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(oclAsSet);
		    final /*@Thrown*/ boolean eq = size.equals(PamtramTables.INT_1);
		    /*@Thrown*/ boolean status;
		    if (eq) {
		        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_ConditionModel = idResolver.getClass(PamtramTables.CLSSid_ConditionModel, null);
		        final /*@Thrown*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, sharedCondition_0);
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
		    message_0 = PamtramTables.STR_It_32_only_32_allowed_32_to_32_reference_32_shared_32_conditions_32_that_32_are_32_model_32_in;
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
			case MappingPackage.MAPPING_HINT_GROUP__LOCAL_CONDITION:
				return basicSetLocalCondition(null, msgs);
			case MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER:
				return basicSetContainerSelector(null, msgs);
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
			case MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED:
				return isDeactivated();
			case MappingPackage.MAPPING_HINT_GROUP__LOCAL_CONDITION:
				return getLocalCondition();
			case MappingPackage.MAPPING_HINT_GROUP__SHARED_CONDITION:
				if (resolve) return getSharedCondition();
				return basicGetSharedCondition();
			case MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER:
				return getContainerSelector();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED:
				setDeactivated((Boolean)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP__LOCAL_CONDITION:
				setLocalCondition((ComplexCondition)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP__SHARED_CONDITION:
				setSharedCondition((ComplexCondition)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER:
				setContainerSelector((ContainerSelector)newValue);
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
			case MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED:
				setDeactivated(DEACTIVATED_EDEFAULT);
				return;
			case MappingPackage.MAPPING_HINT_GROUP__LOCAL_CONDITION:
				setLocalCondition((ComplexCondition)null);
				return;
			case MappingPackage.MAPPING_HINT_GROUP__SHARED_CONDITION:
				setSharedCondition((ComplexCondition)null);
				return;
			case MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER:
				setContainerSelector((ContainerSelector)null);
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
			case MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED:
				return deactivated != DEACTIVATED_EDEFAULT;
			case MappingPackage.MAPPING_HINT_GROUP__LOCAL_CONDITION:
				return localCondition != null;
			case MappingPackage.MAPPING_HINT_GROUP__SHARED_CONDITION:
				return sharedCondition != null;
			case MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER:
				return containerSelector != null;
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
				case MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED: return PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED;
				default: return -1;
			}
		}
		if (baseClass == ConditionalElement.class) {
			switch (derivedFeatureID) {
				case MappingPackage.MAPPING_HINT_GROUP__LOCAL_CONDITION: return PamtramPackage.CONDITIONAL_ELEMENT__LOCAL_CONDITION;
				case MappingPackage.MAPPING_HINT_GROUP__SHARED_CONDITION: return PamtramPackage.CONDITIONAL_ELEMENT__SHARED_CONDITION;
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
				case PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED: return MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED;
				default: return -1;
			}
		}
		if (baseClass == ConditionalElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.CONDITIONAL_ELEMENT__LOCAL_CONDITION: return MappingPackage.MAPPING_HINT_GROUP__LOCAL_CONDITION;
				case PamtramPackage.CONDITIONAL_ELEMENT__SHARED_CONDITION: return MappingPackage.MAPPING_HINT_GROUP__SHARED_CONDITION;
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
				case PamtramPackage.CONDITIONAL_ELEMENT___EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP_1: return MappingPackage.MAPPING_HINT_GROUP___EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP_1;
				case PamtramPackage.CONDITIONAL_ELEMENT___REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP_1: return MappingPackage.MAPPING_HINT_GROUP___REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP_1;
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
			case MappingPackage.MAPPING_HINT_GROUP___EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP_1:
				return eitherModelOrReferCondition((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MappingPackage.MAPPING_HINT_GROUP___REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP_1:
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
		return this.getTargetSection();
	}

} //MappingHintGroupImpl
