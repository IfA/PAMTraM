/**
 */
package pamtram.mapping.modifier.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.impl.NamedElementImpl;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.modifier.MatchToLowerCaseConverter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Match To Lower Case Converter</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.mapping.modifier.impl.MatchToLowerCaseConverterImpl#getRegex <em>Regex</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MatchToLowerCaseConverterImpl extends NamedElementImpl implements MatchToLowerCaseConverter {

	/**
	 * The default value of the '{@link #getRegex() <em>Regex</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getRegex()
	 * @generated
	 * @ordered
	 */
	protected static final String REGEX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRegex() <em>Regex</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getRegex()
	 * @generated
	 * @ordered
	 */
	protected String regex = MatchToLowerCaseConverterImpl.REGEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MatchToLowerCaseConverterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return MappingPackage.Literals.MATCH_TO_LOWER_CASE_CONVERTER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getRegex() {

		return this.regex;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setRegex(String newRegex) {

		String oldRegex = this.regex;
		this.regex = newRegex;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET,
					MappingPackage.MATCH_TO_LOWER_CASE_CONVERTER__REGEX, oldRegex, this.regex));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case MappingPackage.MATCH_TO_LOWER_CASE_CONVERTER__REGEX:
				return this.getRegex();
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
			case MappingPackage.MATCH_TO_LOWER_CASE_CONVERTER__REGEX:
				this.setRegex((String) newValue);
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
			case MappingPackage.MATCH_TO_LOWER_CASE_CONVERTER__REGEX:
				this.setRegex(MatchToLowerCaseConverterImpl.REGEX_EDEFAULT);
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
			case MappingPackage.MATCH_TO_LOWER_CASE_CONVERTER__REGEX:
				return MatchToLowerCaseConverterImpl.REGEX_EDEFAULT == null ? this.regex != null
						: !MatchToLowerCaseConverterImpl.REGEX_EDEFAULT.equals(this.regex);
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
			case MappingPackage.MATCH_TO_LOWER_CASE_CONVERTER___MODIFY_VALUE__STRING:
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
		result.append(" (regex: ");
		result.append(this.regex);
		result.append(')');
		return result.toString();
	}

	@Override
	public String modifyValue(String value) {

		/*
		 * copied from: https://stackoverflow.com/questions/2770967/use-java-and-regex-to-convert-casing-in-a-string
		 */
		Matcher m = Pattern.compile(this.regex != null ? this.regex : "").matcher(value);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, m.group().toLowerCase());
		}
		m.appendTail(sb);

		return sb.toString();
	}

} // MatchToLowerCaseConverterImpl
