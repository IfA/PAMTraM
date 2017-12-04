/**
 */
package pamtram.condition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.condition.UnaryCondition;
import pamtram.condition.util.ConditionValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Single Condition Operator</b></em>'. <!--
 * end-user-doc -->
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
	 * The cached value of the '{@link #getLocalCondPart() <em>Local Cond Part</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getLocalCondPart()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition localCondPart;

	/**
	 * The cached value of the '{@link #getSharedCondPart() <em>Shared Cond Part</em>}' reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getSharedCondPart()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition sharedCondPart;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UnaryConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.UNARY_CONDITION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComplexCondition getLocalCondPart() {
	
		return localCondPart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexCondition basicGetSharedCondPart() {
		return sharedCondPart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSharedCondPart(ComplexCondition newSharedCondPart) {
	
		ComplexCondition oldSharedCondPart = sharedCondPart;
		sharedCondPart = newSharedCondPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.UNARY_CONDITION__SHARED_COND_PART, oldSharedCondPart, sharedCondPart));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateExactlyOneArg(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = this.getLocalCondPart() != null ^ this.getSharedCondPart() != null;
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "Please specify exactly one (local or shared) condition part!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					ConditionValidator.DIAGNOSTIC_SOURCE,
							ConditionValidator.UNARY_CONDITION__VALIDATE_EXACTLY_ONE_ARG,
							errorMessage,
					new Object[] { this, ConditionPackage.Literals.UNARY_CONDITION }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ConditionPackage.UNARY_CONDITION___VALIDATE_EXACTLY_ONE_ARG__DIAGNOSTICCHAIN_MAP:
				return validateExactlyOneArg((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public boolean isLocalCondition() {

		ComplexCondition subCondition = Optional.ofNullable(this.getLocalCondPart()).orElse(this.getSharedCondPart());

		return subCondition == null ? false : subCondition.isLocalCondition();
	}

	@Override
	public boolean isExternalCondition() {

		ComplexCondition subCondition = Optional.ofNullable(this.getLocalCondPart()).orElse(this.getSharedCondPart());

		return subCondition == null ? false : !this.isLocalCondition() && subCondition.isExternalCondition();
	}

	@Override
	public boolean isGlobalCondition() {

		ComplexCondition subCondition = Optional.ofNullable(this.getLocalCondPart()).orElse(this.getSharedCondPart());

		return subCondition == null ? false
				: !this.isLocalCondition() && !this.isExternalCondition() && subCondition.isGlobalCondition();
	}

} // SingleConditionOperatorImpl
