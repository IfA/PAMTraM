/**
 */
package pamtram.condition.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.condition.ConditionPackage;
import pamtram.condition.SectionCondition;

import pamtram.metamodel.SourceSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Section Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.impl.SectionConditionImpl#getConditionSectionRef <em>Condition Section Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SectionConditionImpl extends ConditionImpl implements SectionCondition {
	/**
	 * The cached value of the '{@link #getConditionSectionRef() <em>Condition Section Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionSectionRef()
	 * @generated
	 * @ordered
	 */
	protected SourceSectionClass conditionSectionRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SectionConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.SECTION_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass getConditionSectionRef() {
		if (conditionSectionRef != null && conditionSectionRef.eIsProxy()) {
			InternalEObject oldConditionSectionRef = (InternalEObject)conditionSectionRef;
			conditionSectionRef = (SourceSectionClass)eResolveProxy(oldConditionSectionRef);
			if (conditionSectionRef != oldConditionSectionRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConditionPackage.SECTION_CONDITION__CONDITION_SECTION_REF, oldConditionSectionRef, conditionSectionRef));
			}
		}
		return conditionSectionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass basicGetConditionSectionRef() {
		return conditionSectionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionSectionRef(SourceSectionClass newConditionSectionRef) {
		SourceSectionClass oldConditionSectionRef = conditionSectionRef;
		conditionSectionRef = newConditionSectionRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.SECTION_CONDITION__CONDITION_SECTION_REF, oldConditionSectionRef, conditionSectionRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConditionPackage.SECTION_CONDITION__CONDITION_SECTION_REF:
				if (resolve) return getConditionSectionRef();
				return basicGetConditionSectionRef();
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
			case ConditionPackage.SECTION_CONDITION__CONDITION_SECTION_REF:
				setConditionSectionRef((SourceSectionClass)newValue);
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
			case ConditionPackage.SECTION_CONDITION__CONDITION_SECTION_REF:
				setConditionSectionRef((SourceSectionClass)null);
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
			case ConditionPackage.SECTION_CONDITION__CONDITION_SECTION_REF:
				return conditionSectionRef != null;
		}
		return super.eIsSet(featureID);
	}

} //SectionConditionImpl
