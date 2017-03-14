/**
 */
package pamtram.mapping.modifier.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import pamtram.mapping.modifier.ModifierPackage;
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
public class SubstringReplacerImpl extends StringModifierImpl implements SubstringReplacer {

	/**
	 * The default value of the '{@link #getRegex() <em>Regex</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
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
	protected String regex = REGEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getReplacement() <em>Replacement</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getReplacement()
	 * @generated
	 * @ordered
	 */
	protected static final String REPLACEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReplacement() <em>Replacement</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getReplacement()
	 * @generated
	 * @ordered
	 */
	protected String replacement = REPLACEMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SubstringReplacerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.SUBSTRING_REPLACER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRegex() {
		return regex;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegexGen(String newRegex) {
		String oldRegex = regex;
		regex = newRegex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.SUBSTRING_REPLACER__REGEX, oldRegex, regex));
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
	 * @generated
	 */
	@Override
	public String getReplacement() {
		return replacement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplacementGen(String newReplacement) {
		String oldReplacement = replacement;
		replacement = newReplacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.SUBSTRING_REPLACER__REPLACEMENT, oldReplacement, replacement));
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
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifierPackage.SUBSTRING_REPLACER__REGEX:
				return getRegex();
			case ModifierPackage.SUBSTRING_REPLACER__REPLACEMENT:
				return getReplacement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModifierPackage.SUBSTRING_REPLACER__REGEX:
				setRegex((String)newValue);
				return;
			case ModifierPackage.SUBSTRING_REPLACER__REPLACEMENT:
				setReplacement((String)newValue);
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
			case ModifierPackage.SUBSTRING_REPLACER__REGEX:
				setRegex(REGEX_EDEFAULT);
				return;
			case ModifierPackage.SUBSTRING_REPLACER__REPLACEMENT:
				setReplacement(REPLACEMENT_EDEFAULT);
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
			case ModifierPackage.SUBSTRING_REPLACER__REGEX:
				return REGEX_EDEFAULT == null ? regex != null : !REGEX_EDEFAULT.equals(regex);
			case ModifierPackage.SUBSTRING_REPLACER__REPLACEMENT:
				return REPLACEMENT_EDEFAULT == null ? replacement != null : !REPLACEMENT_EDEFAULT.equals(replacement);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (regex: ");
		result.append(regex);
		result.append(", replacement: ");
		result.append(replacement);
		result.append(')');
		return result.toString();
	}

	@Override
	public String modifyValue(String value) {

		return value.replaceAll(this.regex == null ? "" : this.regex, this.replacement == null ? "" : this.replacement);
	}

} // SubstringReplacerImpl
