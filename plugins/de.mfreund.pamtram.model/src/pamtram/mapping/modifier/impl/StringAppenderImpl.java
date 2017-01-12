/**
 */
package pamtram.mapping.modifier.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.impl.NamedElementImpl;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.modifier.StringAppender;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>String Appender</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.mapping.modifier.impl.StringAppenderImpl#getString <em>String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StringAppenderImpl extends NamedElementImpl implements StringAppender {

	/**
	 * The default value of the '{@link #getString() <em>String</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getString()
	 * @generated
	 * @ordered
	 */
	protected static final String STRING_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getString() <em>String</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getString()
	 * @generated
	 * @ordered
	 */
	protected String string = StringAppenderImpl.STRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StringAppenderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return MappingPackage.Literals.STRING_APPENDER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getString() {

		return this.string;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStringGen(String newString) {

		String oldString = this.string;
		this.string = newString;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.STRING_APPENDER__STRING,
					oldString, this.string));
		}
	}

	/**
	 * Before setting the {@link newString}, update the name
	 */
	@Override
	public void setString(String newString) {

		this.setNameDerived(this.string, newString, "", "");
		this.setStringGen(newString);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case MappingPackage.STRING_APPENDER__STRING:
				return this.getString();
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
			case MappingPackage.STRING_APPENDER__STRING:
				this.setString((String) newValue);
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
			case MappingPackage.STRING_APPENDER__STRING:
				this.setString(StringAppenderImpl.STRING_EDEFAULT);
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
			case MappingPackage.STRING_APPENDER__STRING:
				return StringAppenderImpl.STRING_EDEFAULT == null ? this.string != null
						: !StringAppenderImpl.STRING_EDEFAULT.equals(this.string);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {

		switch (operationID) {
			case MappingPackage.STRING_APPENDER___MODIFY_VALUE__STRING:
				return this.modifyValue((String) arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (string: ");
		result.append(this.string);
		result.append(')');
		return result.toString();
	}

	@Override
	public String modifyValue(String value) {

		return value + (this.string == null ? "" : this.string);
	}

} // StringAppenderImpl
