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
package pamtram.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import pamtram.PamtramPackage;
import pamtram.SectionModel;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Section Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.impl.SectionModelImpl#getMetaModelPackage <em>Meta Model Package</em>}</li>
 *   <li>{@link pamtram.impl.SectionModelImpl#getSections <em>Sections</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SectionModelImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends NamedElementImpl implements SectionModel<S, C, R, A> {
	/**
	 * The cached value of the '{@link #getMetaModelPackage() <em>Meta Model Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelPackage()
	 * @generated
	 * @ordered
	 */
	protected EPackage metaModelPackage;

	/**
	 * The cached value of the '{@link #getSections() <em>Sections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSections()
	 * @generated
	 * @ordered
	 */
	protected EList<S> sections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SectionModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PamtramPackage.Literals.SECTION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EPackage getMetaModelPackage() {
		if (metaModelPackage != null && metaModelPackage.eIsProxy()) {
			InternalEObject oldMetaModelPackage = (InternalEObject)metaModelPackage;
			EObject resolved = eResolveProxy(oldMetaModelPackage);
			if(!(resolved instanceof EPackage)) {
				return metaModelPackage;
			}
			metaModelPackage = (EPackage) resolved;
			if (metaModelPackage != oldMetaModelPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PamtramPackage.SECTION_MODEL__META_MODEL_PACKAGE, oldMetaModelPackage, metaModelPackage));
			}
		}
		return metaModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetMetaModelPackage() {
		return metaModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaModelPackage(EPackage newMetaModelPackage) {
	
		EPackage oldMetaModelPackage = metaModelPackage;
		metaModelPackage = newMetaModelPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.SECTION_MODEL__META_MODEL_PACKAGE, oldMetaModelPackage, metaModelPackage));
	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<S> getSections() {
	
		if (sections == null) {
			sections = new EObjectContainmentEList<S>(Section.class, this, PamtramPackage.SECTION_MODEL__SECTIONS);
		}
		return sections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PamtramPackage.SECTION_MODEL__SECTIONS:
				return ((InternalEList<?>)getSections()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PamtramPackage.SECTION_MODEL__META_MODEL_PACKAGE:
				if (resolve) return getMetaModelPackage();
				return basicGetMetaModelPackage();
			case PamtramPackage.SECTION_MODEL__SECTIONS:
				return getSections();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PamtramPackage.SECTION_MODEL__META_MODEL_PACKAGE:
				setMetaModelPackage((EPackage)newValue);
				return;
			case PamtramPackage.SECTION_MODEL__SECTIONS:
				getSections().clear();
				getSections().addAll((Collection<? extends S>)newValue);
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
			case PamtramPackage.SECTION_MODEL__META_MODEL_PACKAGE:
				setMetaModelPackage((EPackage)null);
				return;
			case PamtramPackage.SECTION_MODEL__SECTIONS:
				getSections().clear();
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
			case PamtramPackage.SECTION_MODEL__META_MODEL_PACKAGE:
				return metaModelPackage != null;
			case PamtramPackage.SECTION_MODEL__SECTIONS:
				return sections != null && !sections.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SectionModelImpl
