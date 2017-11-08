/**
 */
package pamtram.condition.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.condition.AttributeCondition;
import pamtram.condition.ConditionPackage;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.source.ActualSourceSectionAttribute;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Condition</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.impl.AttributeConditionImpl#getValueConstraints <em>Value Constraints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeConditionImpl extends ConditionImpl<ActualSourceSectionAttribute> implements AttributeCondition {

	/**
	 * The cached value of the '{@link #getValueConstraints() <em>Value Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getValueConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueConstraint> valueConstraints;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.ATTRIBUTE_CONDITION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValueConstraint> getValueConstraints() {
		if (valueConstraints == null) {
			valueConstraints = new EObjectContainmentEList<ValueConstraint>(ValueConstraint.class, this, ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS);
		}
		return valueConstraints;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific type known in this
	 * context.
	 *
	 * @generated
	 */
	@Override
	public void setTarget(ActualSourceSectionAttribute newTarget) {
		super.setTarget(newTarget);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS:
				return ((InternalEList<?>)getValueConstraints()).basicRemove(otherEnd, msgs);
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
			case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS:
				return getValueConstraints();
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
			case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS:
				getValueConstraints().clear();
				getValueConstraints().addAll((Collection<? extends ValueConstraint>)newValue);
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
			case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS:
				getValueConstraints().clear();
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
			case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS:
				return valueConstraints != null && !valueConstraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // AttributeConditionImpl
