/**
 */
package pamtram.structure.constraint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.structure.StructurePackage;
import pamtram.structure.constraint.EqualityMatcher;
import pamtram.structure.constraint.ValueConstraintType;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Equality Matcher</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.constraint.impl.EqualityMatcherImpl#isCaseSensitive <em>Case Sensitive</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EqualityMatcherImpl extends SingleReferenceValueConstraintImpl implements EqualityMatcher {

	/**
	 * The default value of the '{@link #isCaseSensitive() <em>Case Sensitive</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isCaseSensitive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CASE_SENSITIVE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isCaseSensitive() <em>Case Sensitive</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isCaseSensitive()
	 * @generated
	 * @ordered
	 */
	protected boolean caseSensitive = EqualityMatcherImpl.CASE_SENSITIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EqualityMatcherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return StructurePackage.Literals.EQUALITY_MATCHER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isCaseSensitive() {

		return this.caseSensitive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setCaseSensitive(boolean newCaseSensitive) {

		boolean oldCaseSensitive = this.caseSensitive;
		this.caseSensitive = newCaseSensitive;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET,
					StructurePackage.EQUALITY_MATCHER__CASE_SENSITIVE, oldCaseSensitive, this.caseSensitive));
		}
	}

	@Override
	public boolean checkConstraint(String attrValue, String refValue) {

		String newAttrValue;
		String newRefValue;
		if (this.caseSensitive) {
			newAttrValue = attrValue;
			newRefValue = refValue;
		} else {
			newAttrValue = attrValue.toLowerCase();
			newRefValue = refValue.toLowerCase();
		}
		// Update: EqualityMatcher useful for integer and doubles. The following example '1' versus. '1.0' represents a
		// problem!
		// Therefore, in case of integer and double, we try to convert twice (to Double and back to String)
		try {
			newAttrValue = String.valueOf(Double.valueOf(newAttrValue));
		} catch (NumberFormatException e) {
			// doesn't work
		}
		try {
			newRefValue = String.valueOf(Double.valueOf(newRefValue));
		} catch (NumberFormatException e) {
			// doesn't work
		}

		return newRefValue.equals(newAttrValue) && this.type.equals(ValueConstraintType.INCLUSION)
				|| !newRefValue.equals(newAttrValue) && this.type.equals(ValueConstraintType.EXCLUSION);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case StructurePackage.EQUALITY_MATCHER__CASE_SENSITIVE:
				return this.isCaseSensitive();
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
			case StructurePackage.EQUALITY_MATCHER__CASE_SENSITIVE:
				this.setCaseSensitive((Boolean) newValue);
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
			case StructurePackage.EQUALITY_MATCHER__CASE_SENSITIVE:
				this.setCaseSensitive(EqualityMatcherImpl.CASE_SENSITIVE_EDEFAULT);
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
			case StructurePackage.EQUALITY_MATCHER__CASE_SENSITIVE:
				return this.caseSensitive != EqualityMatcherImpl.CASE_SENSITIVE_EDEFAULT;
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
		result.append(" (caseSensitive: ");
		result.append(this.caseSensitive);
		result.append(')');
		return result.toString();
	}

} // EqualityMatcherImpl
