/**
 */
package pamtram.condition.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
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

} //SingleConditionOperatorImpl
