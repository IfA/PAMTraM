/*******************************************************************************
 * Copyright (C) 2015-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package de.mfreund.pamtram.transformation.impl;

import de.mfreund.pamtram.transformation.TransformationMappingHintGroup;
import de.mfreund.pamtram.transformation.TransformationPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.mapping.InstantiableMappingHintGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Hint Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.mfreund.pamtram.transformation.impl.TransformationMappingHintGroupImpl#getTargetElements <em>Target Elements</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.impl.TransformationMappingHintGroupImpl#getAssociatedMappingHintGroup <em>Associated Mapping Hint Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformationMappingHintGroupImpl extends MinimalEObjectImpl.Container implements TransformationMappingHintGroup {
	/**
	 * The cached value of the '{@link #getTargetElements() <em>Target Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> targetElements;

	/**
	 * The cached value of the '{@link #getAssociatedMappingHintGroup() <em>Associated Mapping Hint Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedMappingHintGroup()
	 * @generated
	 * @ordered
	 */
	protected InstantiableMappingHintGroup associatedMappingHintGroup;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationMappingHintGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransformationPackage.Literals.TRANSFORMATION_MAPPING_HINT_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getTargetElements() {
		if (targetElements == null) {
			targetElements = new EObjectResolvingEList<EObject>(EObject.class, this, TransformationPackage.TRANSFORMATION_MAPPING_HINT_GROUP__TARGET_ELEMENTS);
		}
		return targetElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstantiableMappingHintGroup getAssociatedMappingHintGroup() {
		if (associatedMappingHintGroup != null && associatedMappingHintGroup.eIsProxy()) {
			InternalEObject oldAssociatedMappingHintGroup = (InternalEObject)associatedMappingHintGroup;
			associatedMappingHintGroup = (InstantiableMappingHintGroup)eResolveProxy(oldAssociatedMappingHintGroup);
			if (associatedMappingHintGroup != oldAssociatedMappingHintGroup) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformationPackage.TRANSFORMATION_MAPPING_HINT_GROUP__ASSOCIATED_MAPPING_HINT_GROUP, oldAssociatedMappingHintGroup, associatedMappingHintGroup));
			}
		}
		return associatedMappingHintGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstantiableMappingHintGroup basicGetAssociatedMappingHintGroup() {
		return associatedMappingHintGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociatedMappingHintGroup(InstantiableMappingHintGroup newAssociatedMappingHintGroup) {
		InstantiableMappingHintGroup oldAssociatedMappingHintGroup = associatedMappingHintGroup;
		associatedMappingHintGroup = newAssociatedMappingHintGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.TRANSFORMATION_MAPPING_HINT_GROUP__ASSOCIATED_MAPPING_HINT_GROUP, oldAssociatedMappingHintGroup, associatedMappingHintGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TransformationPackage.TRANSFORMATION_MAPPING_HINT_GROUP__TARGET_ELEMENTS:
				return getTargetElements();
			case TransformationPackage.TRANSFORMATION_MAPPING_HINT_GROUP__ASSOCIATED_MAPPING_HINT_GROUP:
				if (resolve) return getAssociatedMappingHintGroup();
				return basicGetAssociatedMappingHintGroup();
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
			case TransformationPackage.TRANSFORMATION_MAPPING_HINT_GROUP__TARGET_ELEMENTS:
				getTargetElements().clear();
				getTargetElements().addAll((Collection<? extends EObject>)newValue);
				return;
			case TransformationPackage.TRANSFORMATION_MAPPING_HINT_GROUP__ASSOCIATED_MAPPING_HINT_GROUP:
				setAssociatedMappingHintGroup((InstantiableMappingHintGroup)newValue);
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
			case TransformationPackage.TRANSFORMATION_MAPPING_HINT_GROUP__TARGET_ELEMENTS:
				getTargetElements().clear();
				return;
			case TransformationPackage.TRANSFORMATION_MAPPING_HINT_GROUP__ASSOCIATED_MAPPING_HINT_GROUP:
				setAssociatedMappingHintGroup((InstantiableMappingHintGroup)null);
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
			case TransformationPackage.TRANSFORMATION_MAPPING_HINT_GROUP__TARGET_ELEMENTS:
				return targetElements != null && !targetElements.isEmpty();
			case TransformationPackage.TRANSFORMATION_MAPPING_HINT_GROUP__ASSOCIATED_MAPPING_HINT_GROUP:
				return associatedMappingHintGroup != null;
		}
		return super.eIsSet(featureID);
	}

} //TransformationMappingHintGroupImpl
