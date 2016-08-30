/**
 */
package pamtram.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
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
import pamtram.PamtramPackage;
import pamtram.PamtramTables;
import pamtram.condition.ComplexCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.impl.ConditionalElementImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link pamtram.impl.ConditionalElementImpl#getConditionRef <em>Condition Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConditionalElementImpl extends MinimalEObjectImpl.Container implements ConditionalElement {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionalElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PamtramPackage.Literals.CONDITIONAL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PamtramPackage.CONDITIONAL_ELEMENT__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(ComplexCondition newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.CONDITIONAL_ELEMENT__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.CONDITIONAL_ELEMENT__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.CONDITIONAL_ELEMENT__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexCondition getConditionRef() {
		if (conditionRef != null && conditionRef.eIsProxy()) {
			InternalEObject oldConditionRef = (InternalEObject)conditionRef;
			conditionRef = (ComplexCondition)eResolveProxy(oldConditionRef);
			if (conditionRef != oldConditionRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PamtramPackage.CONDITIONAL_ELEMENT__CONDITION_REF, oldConditionRef, conditionRef));
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
	public void setConditionRef(ComplexCondition newConditionRef) {
		ComplexCondition oldConditionRef = conditionRef;
		conditionRef = newConditionRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.CONDITIONAL_ELEMENT__CONDITION_REF, oldConditionRef, conditionRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			case PamtramPackage.CONDITIONAL_ELEMENT__CONDITION:
				return basicSetCondition(null, msgs);
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
			case PamtramPackage.CONDITIONAL_ELEMENT__CONDITION:
				return getCondition();
			case PamtramPackage.CONDITIONAL_ELEMENT__CONDITION_REF:
				if (resolve) return getConditionRef();
				return basicGetConditionRef();
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
			case PamtramPackage.CONDITIONAL_ELEMENT__CONDITION:
				setCondition((ComplexCondition)newValue);
				return;
			case PamtramPackage.CONDITIONAL_ELEMENT__CONDITION_REF:
				setConditionRef((ComplexCondition)newValue);
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
			case PamtramPackage.CONDITIONAL_ELEMENT__CONDITION:
				setCondition((ComplexCondition)null);
				return;
			case PamtramPackage.CONDITIONAL_ELEMENT__CONDITION_REF:
				setConditionRef((ComplexCondition)null);
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
			case PamtramPackage.CONDITIONAL_ELEMENT__CONDITION:
				return condition != null;
			case PamtramPackage.CONDITIONAL_ELEMENT__CONDITION_REF:
				return conditionRef != null;
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
			case PamtramPackage.CONDITIONAL_ELEMENT___EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP_4:
				return eitherModelOrReferCondition((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PamtramPackage.CONDITIONAL_ELEMENT___REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP_4:
				return referenceOnlyConditionsFromConditionModel((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ConditionalElementImpl
