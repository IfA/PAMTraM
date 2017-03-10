/**
 */
package pamtram.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.FixedValue;
import pamtram.PamtramPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Fixed Value</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.impl.FixedValueImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FixedValueImpl extends NamedElementImpl implements FixedValue {

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = FixedValueImpl.VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FixedValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return PamtramPackage.Literals.FIXED_VALUE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getValue() {

		return this.value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setValueGen(String newValue) {

		String oldValue = this.value;
		this.value = newValue;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.FIXED_VALUE__VALUE, oldValue,
					this.value));
		}
	}

	/**
	 * Before setting the {@link newValue}, update the name.
	 */
	@Override
	public void setValue(String newValue) {

		this.setNameDerived(this.value, newValue, null, null);
		this.setValueGen(newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case PamtramPackage.FIXED_VALUE__VALUE:
				return this.getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {

		switch (featureID) {
			case PamtramPackage.FIXED_VALUE__VALUE:
				this.setValue((String) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {

		switch (featureID) {
			case PamtramPackage.FIXED_VALUE__VALUE:
				this.setValue(FixedValueImpl.VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {

		switch (featureID) {
			case PamtramPackage.FIXED_VALUE__VALUE:
				return FixedValueImpl.VALUE_EDEFAULT == null ? this.value != null
						: !FixedValueImpl.VALUE_EDEFAULT.equals(this.value);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {

		if (this.eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (value: ");
		result.append(this.value);
		result.append(')');
		return result.toString();
	}

} // FixedValueImpl
