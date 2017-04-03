/**
 */
package pamtram.structure.source.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.VirtualSourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Source Section Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.impl.VirtualSourceSectionAttributeImpl#getDerivation <em>Derivation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VirtualSourceSectionAttributeImpl extends SourceSectionAttributeImpl implements VirtualSourceSectionAttribute {
	/**
	 * The default value of the '{@link #getDerivation() <em>Derivation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivation()
	 * @generated
	 * @ordered
	 */
	protected static final String DERIVATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDerivation() <em>Derivation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivation()
	 * @generated
	 * @ordered
	 */
	protected String derivation = DERIVATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualSourceSectionAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcePackage.Literals.VIRTUAL_SOURCE_SECTION_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDerivation() {
		return derivation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerivation(String newDerivation) {
		String oldDerivation = derivation;
		derivation = newDerivation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SourcePackage.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__DERIVATION, oldDerivation, derivation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SourcePackage.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__DERIVATION:
				return getDerivation();
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
			case SourcePackage.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__DERIVATION:
				setDerivation((String)newValue);
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
			case SourcePackage.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__DERIVATION:
				setDerivation(DERIVATION_EDEFAULT);
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
			case SourcePackage.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__DERIVATION:
				return DERIVATION_EDEFAULT == null ? derivation != null : !DERIVATION_EDEFAULT.equals(derivation);
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
		result.append(" (derivation: ");
		result.append(derivation);
		result.append(')');
		return result.toString();
	}

} //VirtualSourceSectionAttributeImpl
