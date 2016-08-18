/**
 */
package pamtram.condition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import pamtram.condition.ComparatorEnum;
import pamtram.condition.ComplexCondition;
import pamtram.condition.Condition;
import pamtram.condition.ConditionPackage;
import pamtram.metamodel.InstancePointer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.impl.ConditionImpl#getAdditionalConditionSpecification <em>Additional Condition Specification</em>}</li>
 *   <li>{@link pamtram.condition.impl.ConditionImpl#getValue <em>Value</em>}</li>
 *   <li>{@link pamtram.condition.impl.ConditionImpl#getComparator <em>Comparator</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConditionImpl extends ComplexConditionImpl implements Condition {
	/**
	 * The cached value of the '{@link #getAdditionalConditionSpecification() <em>Additional Condition Specification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalConditionSpecification()
	 * @generated
	 * @ordered
	 */
	protected EList<InstancePointer> additionalConditionSpecification;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final int VALUE_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected int value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getComparator() <em>Comparator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComparator()
	 * @generated
	 * @ordered
	 */
	protected static final ComparatorEnum COMPARATOR_EDEFAULT = ComparatorEnum.EQ;

	/**
	 * The cached value of the '{@link #getComparator() <em>Comparator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComparator()
	 * @generated
	 * @ordered
	 */
	protected ComparatorEnum comparator = COMPARATOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstancePointer> getAdditionalConditionSpecification() {
		if (additionalConditionSpecification == null) {
			additionalConditionSpecification = new EObjectContainmentEList<InstancePointer>(InstancePointer.class, this, ConditionPackage.CONDITION__ADDITIONAL_CONDITION_SPECIFICATION);
		}
		return additionalConditionSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComparatorEnum getComparator() {
		return comparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComparator(ComparatorEnum newComparator) {
		ComparatorEnum oldComparator = comparator;
		comparator = newComparator == null ? COMPARATOR_EDEFAULT : newComparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.CONDITION__COMPARATOR, oldComparator, comparator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkCondition(final ComplexCondition condition) {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!Condition!checkCondition(http://mfreund.de/pamtram/condition!ComplexCondition)
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConditionPackage.CONDITION__ADDITIONAL_CONDITION_SPECIFICATION:
				return ((InternalEList<?>)getAdditionalConditionSpecification()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(int newValue) {
		int oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.CONDITION__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConditionPackage.CONDITION__ADDITIONAL_CONDITION_SPECIFICATION:
				return getAdditionalConditionSpecification();
			case ConditionPackage.CONDITION__VALUE:
				return getValue();
			case ConditionPackage.CONDITION__COMPARATOR:
				return getComparator();
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
			case ConditionPackage.CONDITION__ADDITIONAL_CONDITION_SPECIFICATION:
				getAdditionalConditionSpecification().clear();
				getAdditionalConditionSpecification().addAll((Collection<? extends InstancePointer>)newValue);
				return;
			case ConditionPackage.CONDITION__VALUE:
				setValue((Integer)newValue);
				return;
			case ConditionPackage.CONDITION__COMPARATOR:
				setComparator((ComparatorEnum)newValue);
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
			case ConditionPackage.CONDITION__ADDITIONAL_CONDITION_SPECIFICATION:
				getAdditionalConditionSpecification().clear();
				return;
			case ConditionPackage.CONDITION__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ConditionPackage.CONDITION__COMPARATOR:
				setComparator(COMPARATOR_EDEFAULT);
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
			case ConditionPackage.CONDITION__ADDITIONAL_CONDITION_SPECIFICATION:
				return additionalConditionSpecification != null && !additionalConditionSpecification.isEmpty();
			case ConditionPackage.CONDITION__VALUE:
				return value != VALUE_EDEFAULT;
			case ConditionPackage.CONDITION__COMPARATOR:
				return comparator != COMPARATOR_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ConditionPackage.CONDITION___CHECK_CONDITION__COMPLEXCONDITION:
				return checkCondition((ComplexCondition)arguments.get(0));
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
		result.append(" (value: ");
		result.append(value);
		result.append(", comparator: ");
		result.append(comparator);
		result.append(')');
		return result.toString();
	}

} //ConditionImpl
