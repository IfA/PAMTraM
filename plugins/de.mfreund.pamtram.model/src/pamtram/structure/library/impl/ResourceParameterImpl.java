/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.structure.library.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.impl.NamedElementImpl;
import pamtram.structure.library.LibraryPackage;
import pamtram.structure.library.ResourceParameter;
import pamtram.structure.target.VirtualTargetSectionAttribute;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Resource Parameter</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.library.impl.ResourceParameterImpl#getAttribute <em>Attribute</em>}</li>
 * <li>{@link pamtram.structure.library.impl.ResourceParameterImpl#getOriginalParameter <em>Original
 * Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceParameterImpl extends NamedElementImpl implements ResourceParameter {

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected VirtualTargetSectionAttribute attribute;

	/**
	 * The cached value of the '{@link #getOriginalParameter() <em>Original Parameter</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOriginalParameter()
	 * @generated
	 * @ordered
	 */
	protected de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter originalParameter;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.RESOURCE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VirtualTargetSectionAttribute getAttribute() {
	
		return attribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttribute(VirtualTargetSectionAttribute newAttribute, NotificationChain msgs) {
		VirtualTargetSectionAttribute oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LibraryPackage.RESOURCE_PARAMETER__ATTRIBUTE, oldAttribute, newAttribute);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAttribute(VirtualTargetSectionAttribute newAttribute) {
	
		if (newAttribute != attribute) {
			NotificationChain msgs = null;
			if (attribute != null)
				msgs = ((InternalEObject)attribute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.RESOURCE_PARAMETER__ATTRIBUTE, null, msgs);
			if (newAttribute != null)
				msgs = ((InternalEObject)newAttribute).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.RESOURCE_PARAMETER__ATTRIBUTE, null, msgs);
			msgs = basicSetAttribute(newAttribute, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.RESOURCE_PARAMETER__ATTRIBUTE, newAttribute, newAttribute));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter getOriginalParameter() {
	
		  if (originalParameter != null && originalParameter.eIsProxy()) {
			InternalEObject oldOriginalParameter = (InternalEObject)originalParameter;
			originalParameter = (de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter)eResolveProxy(oldOriginalParameter);
			if (originalParameter != oldOriginalParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.RESOURCE_PARAMETER__ORIGINAL_PARAMETER, oldOriginalParameter, originalParameter));
			}
		}
		return originalParameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter basicGetOriginalParameter() {
		return originalParameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOriginalParameter(
			de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter newOriginalParameter) {
	
		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter oldOriginalParameter = originalParameter;
		originalParameter = newOriginalParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.RESOURCE_PARAMETER__ORIGINAL_PARAMETER, oldOriginalParameter, originalParameter));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryPackage.RESOURCE_PARAMETER__ATTRIBUTE:
				return basicSetAttribute(null, msgs);
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
			case LibraryPackage.RESOURCE_PARAMETER__ATTRIBUTE:
				return getAttribute();
			case LibraryPackage.RESOURCE_PARAMETER__ORIGINAL_PARAMETER:
				if (resolve) return getOriginalParameter();
				return basicGetOriginalParameter();
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
			case LibraryPackage.RESOURCE_PARAMETER__ATTRIBUTE:
				setAttribute((VirtualTargetSectionAttribute)newValue);
				return;
			case LibraryPackage.RESOURCE_PARAMETER__ORIGINAL_PARAMETER:
				setOriginalParameter((de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter)newValue);
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
			case LibraryPackage.RESOURCE_PARAMETER__ATTRIBUTE:
				setAttribute((VirtualTargetSectionAttribute)null);
				return;
			case LibraryPackage.RESOURCE_PARAMETER__ORIGINAL_PARAMETER:
				setOriginalParameter((de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter)null);
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
			case LibraryPackage.RESOURCE_PARAMETER__ATTRIBUTE:
				return attribute != null;
			case LibraryPackage.RESOURCE_PARAMETER__ORIGINAL_PARAMETER:
				return originalParameter != null;
		}
		return super.eIsSet(featureID);
	}

} // ResourceParameterImpl
