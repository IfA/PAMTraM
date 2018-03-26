/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.structure.constraint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.StringConstraint;
import pamtram.structure.constraint.StringConstraintOperatorType;
import pamtram.structure.constraint.ValueConstraintType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>String Constraint</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.constraint.impl.StringConstraintImpl#isCaseSensitive <em>Case Sensitive</em>}</li>
 * <li>{@link pamtram.structure.constraint.impl.StringConstraintImpl#getOperatorType <em>Operator Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StringConstraintImpl extends SingleReferenceValueConstraintImpl implements StringConstraint {

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected StringConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.STRING_CONSTRAINT;
	}

	@Override
	public boolean checkConstraint(String attrValue, String refValue) {

		String caseSensitiveAttrValue = this.caseSensitive ? attrValue : attrValue.toLowerCase();
		String caseSensitiveRefValue = this.caseSensitive ? refValue : refValue.toLowerCase();

		boolean condition;

		if (this.operatorType.equals(StringConstraintOperatorType.MATCH_EQUAL)) {
			condition = caseSensitiveAttrValue.equals(caseSensitiveRefValue);
		} else if (this.operatorType.equals(StringConstraintOperatorType.MATCH_BEGINNING)) {
			condition = caseSensitiveAttrValue.startsWith(caseSensitiveRefValue);
		} else if (this.operatorType.equals(StringConstraintOperatorType.MATCH_ENDING)) {
			condition = caseSensitiveAttrValue.endsWith(caseSensitiveRefValue);
		} else if (this.operatorType.equals(StringConstraintOperatorType.MATCH_SUBSTRING)) {
			condition = caseSensitiveAttrValue.contains(caseSensitiveRefValue);
		} else if (this.operatorType.equals(StringConstraintOperatorType.MATCH_REGEX)) {
			condition = caseSensitiveAttrValue.matches(caseSensitiveRefValue);
		} else {
			System.out.println("Internal Error: Unkown StringConstraintOperatorType'" + this.operatorType + "'");
			return false;
		}

		return condition && this.type.equals(ValueConstraintType.REQUIRED)
				|| !condition && this.type.equals(ValueConstraintType.FORBIDDEN);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCaseSensitive() {
	
		return caseSensitive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCaseSensitive(boolean newCaseSensitive) {
	
		boolean oldCaseSensitive = caseSensitive;
		caseSensitive = newCaseSensitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.STRING_CONSTRAINT__CASE_SENSITIVE, oldCaseSensitive, caseSensitive));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StringConstraintOperatorType getOperatorType() {
	
		return operatorType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperatorType(StringConstraintOperatorType newOperatorType) {
	
		StringConstraintOperatorType oldOperatorType = operatorType;
		operatorType = newOperatorType == null ? OPERATOR_TYPE_EDEFAULT : newOperatorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.STRING_CONSTRAINT__OPERATOR_TYPE, oldOperatorType, operatorType));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.STRING_CONSTRAINT__OPERATOR_TYPE:
				return getOperatorType();
			case ConstraintPackage.STRING_CONSTRAINT__CASE_SENSITIVE:
				return isCaseSensitive();
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
			case ConstraintPackage.STRING_CONSTRAINT__OPERATOR_TYPE:
				setOperatorType((StringConstraintOperatorType)newValue);
				return;
			case ConstraintPackage.STRING_CONSTRAINT__CASE_SENSITIVE:
				setCaseSensitive((Boolean)newValue);
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
			case ConstraintPackage.STRING_CONSTRAINT__OPERATOR_TYPE:
				setOperatorType(OPERATOR_TYPE_EDEFAULT);
				return;
			case ConstraintPackage.STRING_CONSTRAINT__CASE_SENSITIVE:
				setCaseSensitive(CASE_SENSITIVE_EDEFAULT);
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
			case ConstraintPackage.STRING_CONSTRAINT__OPERATOR_TYPE:
				return operatorType != OPERATOR_TYPE_EDEFAULT;
			case ConstraintPackage.STRING_CONSTRAINT__CASE_SENSITIVE:
				return caseSensitive != CASE_SENSITIVE_EDEFAULT;
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
		result.append(" (operatorType: ");
		result.append(operatorType);
		result.append(", caseSensitive: ");
		result.append(caseSensitive);
		result.append(')');
		return result.toString();
	}

} // StringConstraintImpl
