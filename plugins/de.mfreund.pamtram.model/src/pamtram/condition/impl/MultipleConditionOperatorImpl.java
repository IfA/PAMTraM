/**
 */
package pamtram.condition.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.condition.MultipleConditionOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiple Condition Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.impl.MultipleConditionOperatorImpl#getCondParts <em>Cond Parts</em>}</li>
 *   <li>{@link pamtram.condition.impl.MultipleConditionOperatorImpl#getCondPartsRef <em>Cond Parts Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MultipleConditionOperatorImpl extends ComplexConditionImpl implements MultipleConditionOperator {
	/**
	 * The cached value of the '{@link #getCondParts() <em>Cond Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondParts()
	 * @generated
	 * @ordered
	 */
	protected EList<ComplexCondition> condParts;

	/**
	 * The cached value of the '{@link #getCondPartsRef() <em>Cond Parts Ref</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondPartsRef()
	 * @generated
	 * @ordered
	 */
	protected EList<ComplexCondition> condPartsRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultipleConditionOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.MULTIPLE_CONDITION_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComplexCondition> getCondParts() {
		if (condParts == null) {
			condParts = new EObjectContainmentEList<ComplexCondition>(ComplexCondition.class, this, ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS);
		}
		return condParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComplexCondition> getCondPartsRef() {
		if (condPartsRef == null) {
			condPartsRef = new EObjectResolvingEList<ComplexCondition>(ComplexCondition.class, this, ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS_REF);
		}
		return condPartsRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS:
				return ((InternalEList<?>)getCondParts()).basicRemove(otherEnd, msgs);
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
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS:
				return getCondParts();
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS_REF:
				return getCondPartsRef();
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
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS:
				getCondParts().clear();
				getCondParts().addAll((Collection<? extends ComplexCondition>)newValue);
				return;
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS_REF:
				getCondPartsRef().clear();
				getCondPartsRef().addAll((Collection<? extends ComplexCondition>)newValue);
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
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS:
				getCondParts().clear();
				return;
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS_REF:
				getCondPartsRef().clear();
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
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS:
				return condParts != null && !condParts.isEmpty();
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS_REF:
				return condPartsRef != null && !condPartsRef.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MultipleConditionOperatorImpl
