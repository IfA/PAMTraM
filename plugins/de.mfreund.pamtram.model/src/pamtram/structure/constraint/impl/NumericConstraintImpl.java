/**
 */
package pamtram.structure.constraint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.NumericConstraint;
import pamtram.structure.constraint.NumericConstraintOperatorType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Numeric Constraint</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.constraint.impl.NumericConstraintImpl#getOperatorType <em>Operator Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NumericConstraintImpl extends SingleReferenceValueConstraintImpl implements NumericConstraint {

	/**
	 * The default value of the '{@link #getOperatorType() <em>Operator Type</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOperatorType()
	 * @generated
	 * @ordered
	 */
	protected static final NumericConstraintOperatorType OPERATOR_TYPE_EDEFAULT = NumericConstraintOperatorType.EQUAL;

	/**
	 * The cached value of the '{@link #getOperatorType() <em>Operator Type</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOperatorType()
	 * @generated
	 * @ordered
	 */
	protected NumericConstraintOperatorType operatorType = NumericConstraintImpl.OPERATOR_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected NumericConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return ConstraintPackage.Literals.NUMERIC_CONSTRAINT;
	}

	@Override
	public boolean checkConstraint(String attrValue, String refValue) {

		double numericAttrValue;
		double numericRefValue;

		try {
			numericAttrValue = Double.valueOf(attrValue);
		} catch (NumberFormatException e) {
			// doesn't work
			System.out.println("Unable to parse double value of String '" + attrValue + "'");
			return false;
		}
		try {
			numericRefValue = Double.valueOf(refValue);
		} catch (NumberFormatException e) {
			// doesn't work
			System.out.println("Unable to parse double value of String '" + attrValue + "'");
			return false;
		}

		if (this.operatorType.equals(NumericConstraintOperatorType.EQUAL)) {
			return numericAttrValue == numericRefValue;
		} else if (this.operatorType.equals(NumericConstraintOperatorType.GREATER)) {
			return numericAttrValue > numericRefValue;
		} else if (this.operatorType.equals(NumericConstraintOperatorType.GREATER_OR_EQUAL)) {
			return numericAttrValue >= numericRefValue;
		} else if (this.operatorType.equals(NumericConstraintOperatorType.LESS)) {
			return numericAttrValue < numericRefValue;
		} else if (this.operatorType.equals(NumericConstraintOperatorType.LESS_OR_EQUAL)) {
			return numericAttrValue <= numericRefValue;
		} else {
			System.out.println("Internal Error: Unkown NumericConstraintOperatorType'" + this.operatorType + "'");
			return false;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NumericConstraintOperatorType getOperatorType() {

		return this.operatorType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setOperatorType(NumericConstraintOperatorType newOperatorType) {

		NumericConstraintOperatorType oldOperatorType = this.operatorType;
		this.operatorType = newOperatorType == null ? NumericConstraintImpl.OPERATOR_TYPE_EDEFAULT : newOperatorType;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET,
					ConstraintPackage.NUMERIC_CONSTRAINT__OPERATOR_TYPE, oldOperatorType, this.operatorType));
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
			case ConstraintPackage.NUMERIC_CONSTRAINT__OPERATOR_TYPE:
				return this.getOperatorType();
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
			case ConstraintPackage.NUMERIC_CONSTRAINT__OPERATOR_TYPE:
				this.setOperatorType((NumericConstraintOperatorType) newValue);
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
			case ConstraintPackage.NUMERIC_CONSTRAINT__OPERATOR_TYPE:
				this.setOperatorType(NumericConstraintImpl.OPERATOR_TYPE_EDEFAULT);
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
			case ConstraintPackage.NUMERIC_CONSTRAINT__OPERATOR_TYPE:
				return this.operatorType != NumericConstraintImpl.OPERATOR_TYPE_EDEFAULT;
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
		result.append(" (operatorType: ");
		result.append(this.operatorType);
		result.append(')');
		return result.toString();
	}

} // NumericConstraintImpl
