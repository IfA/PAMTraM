/**
 */
package pamtram.structure.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.StructurePackage;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Instance Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.impl.SourceInstanceSelectorImpl#getReferenceAttribute <em>Reference Attribute</em>}</li>
 *   <li>{@link pamtram.structure.impl.SourceInstanceSelectorImpl#getTargetClass <em>Target Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SourceInstanceSelectorImpl extends InstanceSelectorImpl implements SourceInstanceSelector {
	/**
	 * The cached value of the '{@link #getReferenceAttribute() <em>Reference Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceAttribute()
	 * @generated
	 * @ordered
	 */
	protected SourceSectionAttribute referenceAttribute;

	/**
	 * The cached value of the '{@link #getTargetClass() <em>Target Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetClass()
	 * @generated
	 * @ordered
	 */
	protected SourceSectionClass targetClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceInstanceSelectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.SOURCE_INSTANCE_SELECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionAttribute getReferenceAttribute() {
	
		  if (referenceAttribute != null && referenceAttribute.eIsProxy()) {
			InternalEObject oldReferenceAttribute = (InternalEObject)referenceAttribute;
			referenceAttribute = (SourceSectionAttribute)eResolveProxy(oldReferenceAttribute);
			if (referenceAttribute != oldReferenceAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StructurePackage.SOURCE_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE, oldReferenceAttribute, referenceAttribute));
			}
		}
		return referenceAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionAttribute basicGetReferenceAttribute() {
		return referenceAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferenceAttribute(SourceSectionAttribute newReferenceAttribute) {
	
		SourceSectionAttribute oldReferenceAttribute = referenceAttribute;
		referenceAttribute = newReferenceAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructurePackage.SOURCE_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE, oldReferenceAttribute, referenceAttribute));
	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass getTargetClass() {
	
		  if (targetClass != null && targetClass.eIsProxy()) {
			InternalEObject oldTargetClass = (InternalEObject)targetClass;
			targetClass = (SourceSectionClass)eResolveProxy(oldTargetClass);
			if (targetClass != oldTargetClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StructurePackage.SOURCE_INSTANCE_SELECTOR__TARGET_CLASS, oldTargetClass, targetClass));
			}
		}
		return targetClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass basicGetTargetClass() {
		return targetClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetClass(SourceSectionClass newTargetClass) {
	
		SourceSectionClass oldTargetClass = targetClass;
		targetClass = newTargetClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructurePackage.SOURCE_INSTANCE_SELECTOR__TARGET_CLASS, oldTargetClass, targetClass));
	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructurePackage.SOURCE_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE:
				if (resolve) return getReferenceAttribute();
				return basicGetReferenceAttribute();
			case StructurePackage.SOURCE_INSTANCE_SELECTOR__TARGET_CLASS:
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
			case StructurePackage.SOURCE_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE:
				setReferenceAttribute((SourceSectionAttribute)newValue);
				return;
			case StructurePackage.SOURCE_INSTANCE_SELECTOR__TARGET_CLASS:
				setTargetClass((SourceSectionClass)newValue);
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
			case StructurePackage.SOURCE_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE:
				setReferenceAttribute((SourceSectionAttribute)null);
				return;
			case StructurePackage.SOURCE_INSTANCE_SELECTOR__TARGET_CLASS:
				setTargetClass((SourceSectionClass)null);
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
			case StructurePackage.SOURCE_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE:
				return referenceAttribute != null;
			case StructurePackage.SOURCE_INSTANCE_SELECTOR__TARGET_CLASS:
				return targetClass != null;
		}
		return super.eIsSet(featureID);
	}

} //SourceInstanceSelectorImpl
