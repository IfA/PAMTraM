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
package pamtram.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.MatchSpecElement;
import pamtram.PamtramPackage;

import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Match Spec Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.impl.MatchSpecElementImpl#getReferenceMatchSpec <em>Reference Match Spec</em>}</li>
 *   <li>{@link pamtram.impl.MatchSpecElementImpl#isFollowExternalReferences <em>Follow External References</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MatchSpecElementImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends MinimalEObjectImpl.Container implements MatchSpecElement<S, C, R, A> {
	/**
	 * The cached value of the '{@link #getReferenceMatchSpec() <em>Reference Match Spec</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceMatchSpec()
	 * @generated
	 * @ordered
	 */
	protected EList<R> referenceMatchSpec;

	/**
	 * The default value of the '{@link #isFollowExternalReferences() <em>Follow External References</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFollowExternalReferences()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FOLLOW_EXTERNAL_REFERENCES_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isFollowExternalReferences() <em>Follow External References</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFollowExternalReferences()
	 * @generated
	 * @ordered
	 */
    protected boolean followExternalReferences = FOLLOW_EXTERNAL_REFERENCES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MatchSpecElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PamtramPackage.Literals.MATCH_SPEC_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<R> getReferenceMatchSpec() {
	
		if (referenceMatchSpec == null) {
			referenceMatchSpec = new EObjectResolvingEList<R>(Reference.class, this, PamtramPackage.MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC);
		}
		return referenceMatchSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFollowExternalReferences() {
	
		return followExternalReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFollowExternalReferences(boolean newFollowExternalReferences) {
	
		boolean oldFollowExternalReferences = followExternalReferences;
		followExternalReferences = newFollowExternalReferences;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.MATCH_SPEC_ELEMENT__FOLLOW_EXTERNAL_REFERENCES, oldFollowExternalReferences, followExternalReferences));
	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PamtramPackage.MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC:
				return getReferenceMatchSpec();
			case PamtramPackage.MATCH_SPEC_ELEMENT__FOLLOW_EXTERNAL_REFERENCES:
				return isFollowExternalReferences();
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
			case PamtramPackage.MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC:
				getReferenceMatchSpec().clear();
				getReferenceMatchSpec().addAll((Collection<? extends R>)newValue);
				return;
			case PamtramPackage.MATCH_SPEC_ELEMENT__FOLLOW_EXTERNAL_REFERENCES:
				setFollowExternalReferences((Boolean)newValue);
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
			case PamtramPackage.MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC:
				getReferenceMatchSpec().clear();
				return;
			case PamtramPackage.MATCH_SPEC_ELEMENT__FOLLOW_EXTERNAL_REFERENCES:
				setFollowExternalReferences(FOLLOW_EXTERNAL_REFERENCES_EDEFAULT);
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
			case PamtramPackage.MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC:
				return referenceMatchSpec != null && !referenceMatchSpec.isEmpty();
			case PamtramPackage.MATCH_SPEC_ELEMENT__FOLLOW_EXTERNAL_REFERENCES:
				return followExternalReferences != FOLLOW_EXTERNAL_REFERENCES_EDEFAULT;
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
		result.append(" (followExternalReferences: ");
		result.append(followExternalReferences);
		result.append(')');
		return result.toString();
	}

} //MatchSpecElementImpl
