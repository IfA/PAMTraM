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
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.condition.ConditionTables;
import pamtram.condition.UnaryCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Condition Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.impl.UnaryConditionImpl#getLocalCondPart <em>Local Cond Part</em>}</li>
 *   <li>{@link pamtram.condition.impl.UnaryConditionImpl#getSharedCondPart <em>Shared Cond Part</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class UnaryConditionImpl extends ComplexConditionImpl implements UnaryCondition {
	/**
	 * The cached value of the '{@link #getLocalCondPart() <em>Local Cond Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalCondPart()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition localCondPart;

	/**
	 * The cached value of the '{@link #getSharedCondPart() <em>Shared Cond Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedCondPart()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition sharedCondPart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnaryConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.UNARY_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexCondition getLocalCondPart() {
		return localCondPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocalCondPart(ComplexCondition newLocalCondPart, NotificationChain msgs) {
		ComplexCondition oldLocalCondPart = localCondPart;
		localCondPart = newLocalCondPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConditionPackage.UNARY_CONDITION__LOCAL_COND_PART, oldLocalCondPart, newLocalCondPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalCondPart(ComplexCondition newLocalCondPart) {
		if (newLocalCondPart != localCondPart) {
			NotificationChain msgs = null;
			if (localCondPart != null)
				msgs = ((InternalEObject)localCondPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConditionPackage.UNARY_CONDITION__LOCAL_COND_PART, null, msgs);
			if (newLocalCondPart != null)
				msgs = ((InternalEObject)newLocalCondPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConditionPackage.UNARY_CONDITION__LOCAL_COND_PART, null, msgs);
			msgs = basicSetLocalCondPart(newLocalCondPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.UNARY_CONDITION__LOCAL_COND_PART, newLocalCondPart, newLocalCondPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexCondition getSharedCondPart() {
		if (sharedCondPart != null && sharedCondPart.eIsProxy()) {
			InternalEObject oldSharedCondPart = (InternalEObject)sharedCondPart;
			sharedCondPart = (ComplexCondition)eResolveProxy(oldSharedCondPart);
			if (sharedCondPart != oldSharedCondPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConditionPackage.UNARY_CONDITION__SHARED_COND_PART, oldSharedCondPart, sharedCondPart));
			}
		}
		return sharedCondPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexCondition basicGetSharedCondPart() {
		return sharedCondPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSharedCondPart(ComplexCondition newSharedCondPart) {
		ComplexCondition oldSharedCondPart = sharedCondPart;
		sharedCondPart = newSharedCondPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.UNARY_CONDITION__SHARED_COND_PART, oldSharedCondPart, sharedCondPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean exactlyOneArg(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv exactlyOneArg:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = self.localCondPart->size() +
		 *       self.sharedCondPart->size() = 1
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'Please specify exactly one (local or shared) condition part!'
		 *         else null
		 *         endif
		 *       in
		 *         'UnaryCondition::exactlyOneArg'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		/*@Caught*/ /*@NonNull*/ Object CAUGHT_status;
		try {
		    final /*@Thrown*/ ComplexCondition localCondPart = this.getLocalCondPart();
		    final /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, ConditionTables.SET_CLSSid_ComplexCondition, localCondPart);
		    final /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(oclAsSet);
		    final /*@Thrown*/ ComplexCondition sharedCondPart = this.getSharedCondPart();
		    final /*@Thrown*/ SetValue oclAsSet_0 = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, ConditionTables.SET_CLSSid_ComplexCondition, sharedCondPart);
		    final /*@Thrown*/ IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(oclAsSet_0);
		    final /*@Thrown*/ IntegerValue sum = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(size, size_0);
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
		/*@NonInvalid*/ String message_0;
		if (ne) {
		    message_0 = ConditionTables.STR_Please_32_specify_32_exactly_32_one_32_o_local_32_or_32_shared_e_32_condition_32_part_33;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, ConditionTables.STR_UnaryCondition_c_c_exactlyOneArg, this, null, diagnostics, context, message_0, ConditionTables.INT_4, CAUGHT_status, ConditionTables.INT_0).booleanValue();
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
			case ConditionPackage.UNARY_CONDITION__LOCAL_COND_PART:
				return basicSetLocalCondPart(null, msgs);
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
			case ConditionPackage.UNARY_CONDITION__LOCAL_COND_PART:
				return getLocalCondPart();
			case ConditionPackage.UNARY_CONDITION__SHARED_COND_PART:
				if (resolve) return getSharedCondPart();
				return basicGetSharedCondPart();
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
			case ConditionPackage.UNARY_CONDITION__LOCAL_COND_PART:
				setLocalCondPart((ComplexCondition)newValue);
				return;
			case ConditionPackage.UNARY_CONDITION__SHARED_COND_PART:
				setSharedCondPart((ComplexCondition)newValue);
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
			case ConditionPackage.UNARY_CONDITION__LOCAL_COND_PART:
				setLocalCondPart((ComplexCondition)null);
				return;
			case ConditionPackage.UNARY_CONDITION__SHARED_COND_PART:
				setSharedCondPart((ComplexCondition)null);
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
			case ConditionPackage.UNARY_CONDITION__LOCAL_COND_PART:
				return localCondPart != null;
			case ConditionPackage.UNARY_CONDITION__SHARED_COND_PART:
				return sharedCondPart != null;
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
			case ConditionPackage.UNARY_CONDITION___EXACTLY_ONE_ARG__DIAGNOSTICCHAIN_MAP:
				return exactlyOneArg((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}
	
	@Override
	public boolean isLocalCondition() {
		
		ComplexCondition subCondition = getLocalCondPart();
		
		if(subCondition == null) {
			subCondition = getSharedCondPart();
		}
		
		return subCondition == null ? false : subCondition.isLocalCondition();
	}

} //SingleConditionOperatorImpl
