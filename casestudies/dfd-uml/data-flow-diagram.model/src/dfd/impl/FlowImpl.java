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
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import dfd.DFDElement;
import dfd.DfdPackage;
import dfd.Flow;
import dfd.util.DfdValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Flow</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dfd.impl.FlowImpl#getFrom <em>From</em>}</li>
 *   <li>{@link dfd.impl.FlowImpl#getTo <em>To</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FlowImpl extends NamedElementImpl implements Flow {

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected DFDElement from;

	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected DFDElement to;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DfdPackage.Literals.FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFDElement getFrom() {
		if (from != null && from.eIsProxy()) {
			InternalEObject oldFrom = (InternalEObject)from;
			from = (DFDElement)eResolveProxy(oldFrom);
			if (from != oldFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.FLOW__FROM, oldFrom, from));
			}
		}
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFDElement basicGetFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(DFDElement newFrom) {
		DFDElement oldFrom = from;
		from = newFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.FLOW__FROM, oldFrom, from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFDElement getTo() {
		if (to != null && to.eIsProxy()) {
			InternalEObject oldTo = (InternalEObject)to;
			to = (DFDElement)eResolveProxy(oldTo);
			if (to != oldTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.FLOW__TO, oldTo, to));
			}
		}
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFDElement basicGetTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo(DFDElement newTo) {
		DFDElement oldTo = to;
		to = newTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.FLOW__TO, oldTo, to));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateFromPointsToElementOfSameSystem(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		boolean result = this.from == null || this.from.eContainer().equals(this.eContainer);
				
				if (!result && diagnostics != null) {
					
					String errorMessage = "The 'from' element is not part of the same (Sub-)System!";
				
					diagnostics.add(new BasicDiagnostic
							(Diagnostic.ERROR,
							DfdValidator.DIAGNOSTIC_SOURCE,
							DfdValidator.FLOW__VALIDATE_FROM_POINTS_TO_ELEMENT_OF_SAME_SYSTEM,
									errorMessage,
							new Object[] { this, DfdPackage.Literals.FLOW__FROM}));
				
				}
		
			return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateToPointsToElementOfSameSystem(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		boolean result = this.to == null || this.to.eContainer().equals(this.eContainer);
		
			if (!result && diagnostics != null) {
		
				String errorMessage = "The 'to' element is not part of the same (Sub-)System!";
		
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DfdValidator.DIAGNOSTIC_SOURCE,
							DfdValidator.FLOW__VALIDATE_TO_POINTS_TO_ELEMENT_OF_SAME_SYSTEM, errorMessage,
							new Object[] { this, DfdPackage.Literals.FLOW__TO }));
		
			}
		
			return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DfdPackage.FLOW__FROM:
				if (resolve) return getFrom();
				return basicGetFrom();
			case DfdPackage.FLOW__TO:
				if (resolve) return getTo();
				return basicGetTo();
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
			case DfdPackage.FLOW__FROM:
				setFrom((DFDElement)newValue);
				return;
			case DfdPackage.FLOW__TO:
				setTo((DFDElement)newValue);
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
			case DfdPackage.FLOW__FROM:
				setFrom((DFDElement)null);
				return;
			case DfdPackage.FLOW__TO:
				setTo((DFDElement)null);
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
			case DfdPackage.FLOW__FROM:
				return from != null;
			case DfdPackage.FLOW__TO:
				return to != null;
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
			case DfdPackage.FLOW___VALIDATE_FROM_POINTS_TO_ELEMENT_OF_SAME_SYSTEM__DIAGNOSTICCHAIN_MAP:
				return validateFromPointsToElementOfSameSystem((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case DfdPackage.FLOW___VALIDATE_TO_POINTS_TO_ELEMENT_OF_SAME_SYSTEM__DIAGNOSTICCHAIN_MAP:
				return validateToPointsToElementOfSameSystem((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // FlowImpl
