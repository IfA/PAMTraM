/**
 */
package de.mfreund.pamtram.transformation.impl;

import de.mfreund.pamtram.transformation.TransformationMapping;
import de.mfreund.pamtram.transformation.TransformationPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import pamtram.mapping.Mapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.mfreund.pamtram.transformation.impl.TransformationMappingImpl#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.impl.TransformationMappingImpl#getAssociatedMapping <em>Associated Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformationMappingImpl extends MinimalEObjectImpl.Container implements TransformationMapping {
	/**
	 * The cached value of the '{@link #getSourceElement() <em>Source Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceElement()
	 * @generated
	 * @ordered
	 */
	protected EObject sourceElement;

	/**
	 * The cached value of the '{@link #getAssociatedMapping() <em>Associated Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedMapping()
	 * @generated
	 * @ordered
	 */
	protected Mapping associatedMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransformationPackage.Literals.TRANSFORMATION_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSourceElement() {
		if (sourceElement != null && sourceElement.eIsProxy()) {
			InternalEObject oldSourceElement = (InternalEObject)sourceElement;
			sourceElement = eResolveProxy(oldSourceElement);
			if (sourceElement != oldSourceElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformationPackage.TRANSFORMATION_MAPPING__SOURCE_ELEMENT, oldSourceElement, sourceElement));
			}
		}
		return sourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSourceElement() {
		return sourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceElement(EObject newSourceElement) {
		EObject oldSourceElement = sourceElement;
		sourceElement = newSourceElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.TRANSFORMATION_MAPPING__SOURCE_ELEMENT, oldSourceElement, sourceElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping getAssociatedMapping() {
		if (associatedMapping != null && associatedMapping.eIsProxy()) {
			InternalEObject oldAssociatedMapping = (InternalEObject)associatedMapping;
			associatedMapping = (Mapping)eResolveProxy(oldAssociatedMapping);
			if (associatedMapping != oldAssociatedMapping) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformationPackage.TRANSFORMATION_MAPPING__ASSOCIATED_MAPPING, oldAssociatedMapping, associatedMapping));
			}
		}
		return associatedMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping basicGetAssociatedMapping() {
		return associatedMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociatedMapping(Mapping newAssociatedMapping) {
		Mapping oldAssociatedMapping = associatedMapping;
		associatedMapping = newAssociatedMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.TRANSFORMATION_MAPPING__ASSOCIATED_MAPPING, oldAssociatedMapping, associatedMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TransformationPackage.TRANSFORMATION_MAPPING__SOURCE_ELEMENT:
				if (resolve) return getSourceElement();
				return basicGetSourceElement();
			case TransformationPackage.TRANSFORMATION_MAPPING__ASSOCIATED_MAPPING:
				if (resolve) return getAssociatedMapping();
				return basicGetAssociatedMapping();
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
			case TransformationPackage.TRANSFORMATION_MAPPING__SOURCE_ELEMENT:
				setSourceElement((EObject)newValue);
				return;
			case TransformationPackage.TRANSFORMATION_MAPPING__ASSOCIATED_MAPPING:
				setAssociatedMapping((Mapping)newValue);
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
			case TransformationPackage.TRANSFORMATION_MAPPING__SOURCE_ELEMENT:
				setSourceElement((EObject)null);
				return;
			case TransformationPackage.TRANSFORMATION_MAPPING__ASSOCIATED_MAPPING:
				setAssociatedMapping((Mapping)null);
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
			case TransformationPackage.TRANSFORMATION_MAPPING__SOURCE_ELEMENT:
				return sourceElement != null;
			case TransformationPackage.TRANSFORMATION_MAPPING__ASSOCIATED_MAPPING:
				return associatedMapping != null;
		}
		return super.eIsSet(featureID);
	}

} //TransformationMappingImpl
