/*******************************************************************************
 * Copyright (C) 2017-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package dfd.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import dfd.DFD;
import dfd.DfdPackage;
import dfd.util.DfdValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Process</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dfd.impl.ProcessImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link dfd.impl.ProcessImpl#getDfd <em>Dfd</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessImpl extends DFDElementImpl implements dfd.Process {

	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected String number = NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDfd() <em>Dfd</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDfd()
	 * @generated
	 * @ordered
	 */
	protected DFD dfd;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DfdPackage.Literals.PROCESS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumber(String newNumber) {
		String oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.PROCESS__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFD getDfd() {
		return dfd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDfd(DFD newDfd, NotificationChain msgs) {
		DFD oldDfd = dfd;
		dfd = newDfd;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DfdPackage.PROCESS__DFD, oldDfd, newDfd);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDfd(DFD newDfd) {
		if (newDfd != dfd) {
			NotificationChain msgs = null;
			if (dfd != null)
				msgs = ((InternalEObject)dfd).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DfdPackage.PROCESS__DFD, null, msgs);
			if (newDfd != null)
				msgs = ((InternalEObject)newDfd).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DfdPackage.PROCESS__DFD, null, msgs);
			msgs = basicSetDfd(newDfd, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.PROCESS__DFD, newDfd, newDfd));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNumberFormatIsCorrect(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		boolean result = this.number == null || this.number.matches("[0-9]+(\\.[0-9]+)*");
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The number is not formatted correctly! Valid numbers are e.g. '1', '1.10', or '1.10.8'...";
		
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DfdValidator.DIAGNOSTIC_SOURCE,
					DfdValidator.PROCESS__VALIDATE_NUMBER_FORMAT_IS_CORRECT, errorMessage,
					new Object[] { this, DfdPackage.Literals.PROCESS__NUMBER }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DfdPackage.PROCESS__DFD:
				return basicSetDfd(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DfdPackage.PROCESS__NUMBER:
				return getNumber();
			case DfdPackage.PROCESS__DFD:
				return getDfd();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DfdPackage.PROCESS__NUMBER:
				setNumber((String)newValue);
				return;
			case DfdPackage.PROCESS__DFD:
				setDfd((DFD)newValue);
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
			case DfdPackage.PROCESS__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
			case DfdPackage.PROCESS__DFD:
				setDfd((DFD)null);
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
			case DfdPackage.PROCESS__NUMBER:
				return NUMBER_EDEFAULT == null ? number != null : !NUMBER_EDEFAULT.equals(number);
			case DfdPackage.PROCESS__DFD:
				return dfd != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case DfdPackage.PROCESS___VALIDATE_NUMBER_FORMAT_IS_CORRECT__DIAGNOSTICCHAIN_MAP:
				return validateNumberFormatIsCorrect((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (number: ");
		result.append(number);
		result.append(')');
		return result.toString();
	}

} // ProcessImpl
