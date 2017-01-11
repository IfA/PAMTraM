/**
 */
package pamtram.structure.constraint.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.StringConstraint;
import pamtram.structure.constraint.StringConstraintOperatorType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.constraint.impl.StringConstraintImpl#isCaseSensitive <em>Case Sensitive</em>}</li>
 *   <li>{@link pamtram.structure.constraint.impl.StringConstraintImpl#getOperatorType <em>Operator Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StringConstraintImpl extends SingleReferenceValueConstraintImpl implements StringConstraint {
	/**
	 * The default value of the '{@link #isCaseSensitive() <em>Case Sensitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCaseSensitive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CASE_SENSITIVE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isCaseSensitive() <em>Case Sensitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCaseSensitive()
	 * @generated
	 * @ordered
	 */
	protected boolean caseSensitive = CASE_SENSITIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOperatorType() <em>Operator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorType()
	 * @generated
	 * @ordered
	 */
	protected static final StringConstraintOperatorType OPERATOR_TYPE_EDEFAULT = StringConstraintOperatorType.MATCH_EQUAL;

	/**
	 * The cached value of the '{@link #getOperatorType() <em>Operator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorType()
	 * @generated
	 * @ordered
	 */
	protected StringConstraintOperatorType operatorType = OPERATOR_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.STRING_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCaseSensitive(boolean newCaseSensitive) {
		boolean oldCaseSensitive = caseSensitive;
		caseSensitive = newCaseSensitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.STRING_CONSTRAINT__CASE_SENSITIVE, oldCaseSensitive, caseSensitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringConstraintOperatorType getOperatorType() {
		return operatorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperatorType(StringConstraintOperatorType newOperatorType) {
		StringConstraintOperatorType oldOperatorType = operatorType;
		operatorType = newOperatorType == null ? OPERATOR_TYPE_EDEFAULT : newOperatorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.STRING_CONSTRAINT__OPERATOR_TYPE, oldOperatorType, operatorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.STRING_CONSTRAINT__CASE_SENSITIVE:
				return isCaseSensitive();
			case ConstraintPackage.STRING_CONSTRAINT__OPERATOR_TYPE:
				return getOperatorType();
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
			case ConstraintPackage.STRING_CONSTRAINT__CASE_SENSITIVE:
				setCaseSensitive((Boolean)newValue);
				return;
			case ConstraintPackage.STRING_CONSTRAINT__OPERATOR_TYPE:
				setOperatorType((StringConstraintOperatorType)newValue);
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
			case ConstraintPackage.STRING_CONSTRAINT__CASE_SENSITIVE:
				setCaseSensitive(CASE_SENSITIVE_EDEFAULT);
				return;
			case ConstraintPackage.STRING_CONSTRAINT__OPERATOR_TYPE:
				setOperatorType(OPERATOR_TYPE_EDEFAULT);
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
			case ConstraintPackage.STRING_CONSTRAINT__CASE_SENSITIVE:
				return caseSensitive != CASE_SENSITIVE_EDEFAULT;
			case ConstraintPackage.STRING_CONSTRAINT__OPERATOR_TYPE:
				return operatorType != OPERATOR_TYPE_EDEFAULT;
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
		result.append(" (caseSensitive: ");
		result.append(caseSensitive);
		result.append(", operatorType: ");
		result.append(operatorType);
		result.append(')');
		return result.toString();
	}

} //StringConstraintImpl
