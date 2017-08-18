/**
 */
package pamtram.structure.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.structure.StructurePackage;
import pamtram.structure.TargetInstanceSelector;

import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Instance Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.impl.TargetInstanceSelectorImpl#getReferenceAttribute <em>Reference Attribute</em>}</li>
 *   <li>{@link pamtram.structure.impl.TargetInstanceSelectorImpl#getTargetClass <em>Target Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TargetInstanceSelectorImpl extends InstanceSelectorImpl implements TargetInstanceSelector {
	/**
	 * The cached value of the '{@link #getReferenceAttribute() <em>Reference Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceAttribute()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionAttribute referenceAttribute;

	/**
	 * The cached value of the '{@link #getTargetClass() <em>Target Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetClass()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionClass targetClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetInstanceSelectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.TARGET_INSTANCE_SELECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionAttribute getReferenceAttribute() {
		if (referenceAttribute != null && referenceAttribute.eIsProxy()) {
			InternalEObject oldReferenceAttribute = (InternalEObject)referenceAttribute;
			referenceAttribute = (TargetSectionAttribute)eResolveProxy(oldReferenceAttribute);
			if (referenceAttribute != oldReferenceAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StructurePackage.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE, oldReferenceAttribute, referenceAttribute));
			}
		}
		return referenceAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionAttribute basicGetReferenceAttribute() {
		return referenceAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceAttribute(TargetSectionAttribute newReferenceAttribute) {
		TargetSectionAttribute oldReferenceAttribute = referenceAttribute;
		referenceAttribute = newReferenceAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructurePackage.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE, oldReferenceAttribute, referenceAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass getTargetClass() {
		if (targetClass != null && targetClass.eIsProxy()) {
			InternalEObject oldTargetClass = (InternalEObject)targetClass;
			targetClass = (TargetSectionClass)eResolveProxy(oldTargetClass);
			if (targetClass != oldTargetClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StructurePackage.TARGET_INSTANCE_SELECTOR__TARGET_CLASS, oldTargetClass, targetClass));
			}
		}
		return targetClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass basicGetTargetClass() {
		return targetClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetClass(TargetSectionClass newTargetClass) {
		TargetSectionClass oldTargetClass = targetClass;
		targetClass = newTargetClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructurePackage.TARGET_INSTANCE_SELECTOR__TARGET_CLASS, oldTargetClass, targetClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructurePackage.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE:
				if (resolve) return getReferenceAttribute();
				return basicGetReferenceAttribute();
			case StructurePackage.TARGET_INSTANCE_SELECTOR__TARGET_CLASS:
				if (resolve) return getTargetClass();
				return basicGetTargetClass();
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
			case StructurePackage.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE:
				setReferenceAttribute((TargetSectionAttribute)newValue);
				return;
			case StructurePackage.TARGET_INSTANCE_SELECTOR__TARGET_CLASS:
				setTargetClass((TargetSectionClass)newValue);
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
			case StructurePackage.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE:
				setReferenceAttribute((TargetSectionAttribute)null);
				return;
			case StructurePackage.TARGET_INSTANCE_SELECTOR__TARGET_CLASS:
				setTargetClass((TargetSectionClass)null);
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
			case StructurePackage.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE:
				return referenceAttribute != null;
			case StructurePackage.TARGET_INSTANCE_SELECTOR__TARGET_CLASS:
				return targetClass != null;
		}
		return super.eIsSet(featureID);
	}

} //TargetInstanceSelectorImpl
