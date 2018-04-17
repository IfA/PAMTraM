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
package pamtram.structure.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import pamtram.structure.GlobalDynamicSourceElement;
import pamtram.structure.InstanceSelector;
import pamtram.structure.StructurePackage;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.impl.GlobalDynamicSourceElementImpl#getInstanceSelectors <em>Instance Selectors</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GlobalDynamicSourceElementImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>, InstanceSelectorType extends InstanceSelector> extends DynamicSourceElementImpl<S, C, R, A> implements GlobalDynamicSourceElement<S, C, R, A, InstanceSelectorType> {
	/**
	 * The cached value of the '{@link #getInstanceSelectors() <em>Instance Selectors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceSelectors()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceSelectorType> instanceSelectors;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalDynamicSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.GLOBAL_DYNAMIC_SOURCE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstanceSelectorType> getInstanceSelectors() {
	
		if (instanceSelectors == null) {
			instanceSelectors = new EObjectContainmentEList<InstanceSelectorType>(InstanceSelector.class, this, StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__INSTANCE_SELECTORS);
		}
		return instanceSelectors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__INSTANCE_SELECTORS:
				return ((InternalEList<?>)getInstanceSelectors()).basicRemove(otherEnd, msgs);
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
			case StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__INSTANCE_SELECTORS:
				return getInstanceSelectors();
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
			case StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__INSTANCE_SELECTORS:
				getInstanceSelectors().clear();
				getInstanceSelectors().addAll((Collection<? extends InstanceSelectorType>)newValue);
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
			case StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__INSTANCE_SELECTORS:
				getInstanceSelectors().clear();
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
			case StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT__INSTANCE_SELECTORS:
				return instanceSelectors != null && !instanceSelectors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GlobalDynamicSourceElementImpl
