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
import pamtram.mapping.modifier.SubstringReplacer;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Substring Replacer</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.mapping.modifier.impl.SubstringReplacerImpl#getRegex <em>Regex</em>}</li>
 * <li>{@link pamtram.mapping.modifier.impl.SubstringReplacerImpl#getReplacement <em>Replacement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubstringReplacerImpl extends NamedElementImpl implements SubstringReplacer {

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
	protected String regex = SubstringReplacerImpl.REGEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getReplacement() <em>Replacement</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getReplacement()
	 * @generated
	 * @ordered
	 */
	protected static final String REPLACEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReplacement() <em>Replacement</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getReplacement()
	 * @generated
	 * @ordered
	 */
	protected String replacement = SubstringReplacerImpl.REPLACEMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SubstringReplacerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return MappingPackage.Literals.SUBSTRING_REPLACER;
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
	public void setRegexGen(String newRegex) {

		String oldRegex = this.regex;
		this.regex = newRegex;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.SUBSTRING_REPLACER__REGEX,
					oldRegex, this.regex));
		}
	}

	/**
	 * Before setting the {@link newRegex}, update the name
	 */
	@Override
	public void setRegex(String newRegex) {

		String appendString = "_to_" + (this.replacement != null ? this.replacement : "");
		this.setNameDerived(this.regex == null ? "" : this.regex, newRegex == null ? "" : newRegex, null, appendString);
		this.setRegexGen(newRegex);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getReplacement() {

		return this.replacement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setReplacementGen(String newReplacement) {

		String oldReplacement = this.replacement;
		this.replacement = newReplacement;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.SUBSTRING_REPLACER__REPLACEMENT,
					oldReplacement, this.replacement));
		}
	}

	/**
	 * Before setting the {@link newReplacement}, update the name
	 */
	@Override
	public void setReplacement(String newReplacement) {

		String preprendString = (this.getRegex() != null ? this.getRegex() : "") + "_to_";
		this.setNameDerived(this.replacement == null ? "" : this.replacement,
				newReplacement == null ? "" : newReplacement, preprendString, null);
		this.setReplacementGen(newReplacement);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case MappingPackage.SUBSTRING_REPLACER__REGEX:
				return this.getRegex();
			case MappingPackage.SUBSTRING_REPLACER__REPLACEMENT:
				return this.getReplacement();
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
			case MappingPackage.SUBSTRING_REPLACER__REGEX:
				this.setRegex((String) newValue);
				return;
			case MappingPackage.SUBSTRING_REPLACER__REPLACEMENT:
				this.setReplacement((String) newValue);
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
			case MappingPackage.SUBSTRING_REPLACER__REGEX:
				this.setRegex(SubstringReplacerImpl.REGEX_EDEFAULT);
				return;
			case MappingPackage.SUBSTRING_REPLACER__REPLACEMENT:
				this.setReplacement(SubstringReplacerImpl.REPLACEMENT_EDEFAULT);
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
			case MappingPackage.SUBSTRING_REPLACER__REGEX:
				return SubstringReplacerImpl.REGEX_EDEFAULT == null ? this.regex != null
						: !SubstringReplacerImpl.REGEX_EDEFAULT.equals(this.regex);
			case MappingPackage.SUBSTRING_REPLACER__REPLACEMENT:
				return SubstringReplacerImpl.REPLACEMENT_EDEFAULT == null ? this.replacement != null
						: !SubstringReplacerImpl.REPLACEMENT_EDEFAULT.equals(this.replacement);
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
			case MappingPackage.SUBSTRING_REPLACER___MODIFY_VALUE__STRING:
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
		result.append(", replacement: ");
		result.append(this.replacement);
		result.append(')');
		return result.toString();
	}

	@Override
	public String modifyValue(String value) {

		return value.replaceAll(this.regex == null ? "" : this.regex, this.replacement == null ? "" : this.replacement);
	}

} // SubstringReplacerImpl
