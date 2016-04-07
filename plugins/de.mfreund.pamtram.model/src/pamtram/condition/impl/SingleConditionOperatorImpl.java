/**
 */
package pamtram.condition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsTypeOfOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.condition.ConditionTables;
import pamtram.condition.SingleConditionOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Condition Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.impl.SingleConditionOperatorImpl#getCondPart <em>Cond Part</em>}</li>
 *   <li>{@link pamtram.condition.impl.SingleConditionOperatorImpl#getCondPartRef <em>Cond Part Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SingleConditionOperatorImpl extends ComplexConditionImpl implements SingleConditionOperator {
	/**
	 * The cached value of the '{@link #getCondPart() <em>Cond Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondPart()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition condPart;

	/**
	 * The cached value of the '{@link #getCondPartRef() <em>Cond Part Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondPartRef()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition condPartRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleConditionOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.SINGLE_CONDITION_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexCondition getCondPart() {
		return condPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondPart(ComplexCondition newCondPart, NotificationChain msgs) {
		ComplexCondition oldCondPart = condPart;
		condPart = newCondPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConditionPackage.SINGLE_CONDITION_OPERATOR__COND_PART, oldCondPart, newCondPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondPart(ComplexCondition newCondPart) {
		if (newCondPart != condPart) {
			NotificationChain msgs = null;
			if (condPart != null)
				msgs = ((InternalEObject)condPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConditionPackage.SINGLE_CONDITION_OPERATOR__COND_PART, null, msgs);
			if (newCondPart != null)
				msgs = ((InternalEObject)newCondPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConditionPackage.SINGLE_CONDITION_OPERATOR__COND_PART, null, msgs);
			msgs = basicSetCondPart(newCondPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.SINGLE_CONDITION_OPERATOR__COND_PART, newCondPart, newCondPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexCondition getCondPartRef() {
		if (condPartRef != null && condPartRef.eIsProxy()) {
			InternalEObject oldCondPartRef = (InternalEObject)condPartRef;
			condPartRef = (ComplexCondition)eResolveProxy(oldCondPartRef);
			if (condPartRef != oldCondPartRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConditionPackage.SINGLE_CONDITION_OPERATOR__COND_PART_REF, oldCondPartRef, condPartRef));
			}
		}
		return condPartRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexCondition basicGetCondPartRef() {
		return condPartRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondPartRef(ComplexCondition newCondPartRef) {
		ComplexCondition oldCondPartRef = condPartRef;
		condPartRef = newCondPartRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.SINGLE_CONDITION_OPERATOR__COND_PART_REF, oldCondPartRef, condPartRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean minimalNumberOfArgs(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv minimalNumberOfArgs:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = self.condPart->size() +
		 *       self.condPartRef->size() = 1
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The required subparts of this condition are not modeled or not referenced !'
		 *         else null
		 *         endif
		 *       in
		 *         'SingleConditionOperator::minimalNumberOfArgs'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@Nullable*/ /*@Thrown*/ ComplexCondition condPart = this.getCondPart();
		    final /*@NonNull*/ /*@Thrown*/ SetValue oclAsSet = ClassUtil.nonNullState(OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, ConditionTables.SET_CLSSid_ComplexCondition, condPart));
		    final /*@NonNull*/ /*@Thrown*/ IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(oclAsSet));
		    final /*@Nullable*/ /*@Thrown*/ ComplexCondition condPartRef = this.getCondPartRef();
		    final /*@NonNull*/ /*@Thrown*/ SetValue oclAsSet_0 = ClassUtil.nonNullState(OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, ConditionTables.SET_CLSSid_ComplexCondition, condPartRef));
		    final /*@NonNull*/ /*@Thrown*/ IntegerValue size_0 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(oclAsSet_0));
		    final /*@NonNull*/ /*@Thrown*/ IntegerValue sum = ClassUtil.nonNullState((IntegerValue)NumericPlusOperation.INSTANCE.evaluate(size, size_0));
		    final /*@Thrown*/ boolean status = sum.equals(ConditionTables.INT_1);
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
		    message_0 = ConditionTables.STR_The_32_required_32_subparts_32_of_32_this_32_condition_32_are_32_not_32_modeled_32_or_32_not_32_r;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, ConditionTables.STR_SingleConditionOperator_c_c_minimalNumberOfArgs, this, null, diagnostics, context, message_0, ConditionTables.INT_4, CAUGHT_status, ConditionTables.INT_0).booleanValue());
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
		 *       status : OclAny[?] = self.condPartRef.oclContainer()
		 *       .oclIsTypeOf(ConditionModel) or
		 *       self.condPartRef.oclContainer()
		 *       .oclIsKindOf(ConditionalElement)
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'It only allowed to reference Condition-Instances that are model inside the ConditionModel!'
		 *         else null
		 *         endif
		 *       in
		 *         'SingleConditionOperator::referenceOnlyConditionsFromConditionModel'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@Nullable*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_oclIsTypeOf;
		    try {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_ConditionModel_0 = idResolver.getClass(ConditionTables.CLSSid_ConditionModel, null);
		        final /*@Nullable*/ /*@Thrown*/ ComplexCondition condPartRef = this.getCondPartRef();
		        final /*@Nullable*/ /*@Thrown*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, condPartRef);
		        final /*@Thrown*/ boolean oclIsTypeOf = ClassUtil.nonNullState(OclAnyOclIsTypeOfOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_ConditionModel_0).booleanValue());
		        CAUGHT_oclIsTypeOf = oclIsTypeOf;
		    }
		    catch (Exception e) {
		        CAUGHT_oclIsTypeOf = ValueUtil.createInvalidValue(e);
		    }
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_oclIsKindOf;
		    try {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_ConditionalElement = idResolver.getClass(ConditionTables.CLSSid_ConditionalElement, null);
		        final /*@Nullable*/ /*@Thrown*/ ComplexCondition condPartRef_0 = this.getCondPartRef();
		        final /*@Nullable*/ /*@Thrown*/ Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, condPartRef_0);
		        final /*@Thrown*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, oclContainer_0, TYP_pamtram_c_c_ConditionalElement).booleanValue());
		        CAUGHT_oclIsKindOf = oclIsKindOf;
		    }
		    catch (Exception e) {
		        CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
		    }
		    final /*@Nullable*/ /*@Thrown*/ Boolean status = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_oclIsTypeOf, CAUGHT_oclIsKindOf);
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
		    message_0 = ConditionTables.STR_It_32_only_32_allowed_32_to_32_reference_32_Condition_m_Instances_32_that_32_are_32_model_32;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, ConditionTables.STR_SingleConditionOperator_c_c_referenceOnlyConditionsFromConditionMod, this, null, diagnostics, context, message_0, ConditionTables.INT_4, CAUGHT_status, ConditionTables.INT_0).booleanValue());
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
			case ConditionPackage.SINGLE_CONDITION_OPERATOR__COND_PART:
				return basicSetCondPart(null, msgs);
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
			case ConditionPackage.SINGLE_CONDITION_OPERATOR__COND_PART:
				return getCondPart();
			case ConditionPackage.SINGLE_CONDITION_OPERATOR__COND_PART_REF:
				if (resolve) return getCondPartRef();
				return basicGetCondPartRef();
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
			case ConditionPackage.SINGLE_CONDITION_OPERATOR__COND_PART:
				setCondPart((ComplexCondition)newValue);
				return;
			case ConditionPackage.SINGLE_CONDITION_OPERATOR__COND_PART_REF:
				setCondPartRef((ComplexCondition)newValue);
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
			case ConditionPackage.SINGLE_CONDITION_OPERATOR__COND_PART:
				setCondPart((ComplexCondition)null);
				return;
			case ConditionPackage.SINGLE_CONDITION_OPERATOR__COND_PART_REF:
				setCondPartRef((ComplexCondition)null);
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
			case ConditionPackage.SINGLE_CONDITION_OPERATOR__COND_PART:
				return condPart != null;
			case ConditionPackage.SINGLE_CONDITION_OPERATOR__COND_PART_REF:
				return condPartRef != null;
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
			case ConditionPackage.SINGLE_CONDITION_OPERATOR___MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP:
				return minimalNumberOfArgs((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ConditionPackage.SINGLE_CONDITION_OPERATOR___REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP:
				return referenceOnlyConditionsFromConditionModel((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //SingleConditionOperatorImpl
