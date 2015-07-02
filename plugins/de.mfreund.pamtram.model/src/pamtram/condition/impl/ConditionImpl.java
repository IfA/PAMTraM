/**
 */
package pamtram.condition.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.condition.ComparatorEnum;
import pamtram.condition.Condition;
import pamtram.condition.ConditionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.impl.ConditionImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link pamtram.condition.impl.ConditionImpl#getComparator <em>Comparator</em>}</li>
 *   <li>{@link pamtram.condition.impl.ConditionImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionImpl extends ComplexConditionImpl implements Condition {
	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EObject attribute;

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
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

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
	public EObject getAttribute() {
		if (attribute != null && attribute.eIsProxy()) {
			InternalEObject oldAttribute = (InternalEObject)attribute;
			attribute = eResolveProxy(oldAttribute);
			if (attribute != oldAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConditionPackage.CONDITION__ATTRIBUTE, oldAttribute, attribute));
			}
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(EObject newAttribute) {
		EObject oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.CONDITION__ATTRIBUTE, oldAttribute, attribute));
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
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
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
			case ConditionPackage.CONDITION__ATTRIBUTE:
				if (resolve) return getAttribute();
				return basicGetAttribute();
			case ConditionPackage.CONDITION__COMPARATOR:
				return getComparator();
			case ConditionPackage.CONDITION__VALUE:
				return getValue();
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
			case ConditionPackage.CONDITION__ATTRIBUTE:
				setAttribute((EObject)newValue);
				return;
			case ConditionPackage.CONDITION__COMPARATOR:
				setComparator((ComparatorEnum)newValue);
				return;
			case ConditionPackage.CONDITION__VALUE:
				setValue((String)newValue);
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
			case ConditionPackage.CONDITION__ATTRIBUTE:
				setAttribute((EObject)null);
				return;
			case ConditionPackage.CONDITION__COMPARATOR:
				setComparator(COMPARATOR_EDEFAULT);
				return;
			case ConditionPackage.CONDITION__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case ConditionPackage.CONDITION__ATTRIBUTE:
				return attribute != null;
			case ConditionPackage.CONDITION__COMPARATOR:
				return comparator != COMPARATOR_EDEFAULT;
			case ConditionPackage.CONDITION__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
		}
		return super.eIsSet(featureID);
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
		result.append(" (comparator: ");
		result.append(comparator);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ConditionImpl
