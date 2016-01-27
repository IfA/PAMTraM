/**
 */
package pamtram.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Pointer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.InstancePointerImpl#getAttributePointer <em>Attribute Pointer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstancePointerImpl extends MinimalEObjectImpl.Container implements InstancePointer {
	/**
	 * The cached value of the '{@link #getAttributePointer() <em>Attribute Pointer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributePointer()
	 * @generated
	 * @ordered
	 */
	protected SourceSectionAttribute attributePointer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstancePointerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.INSTANCE_POINTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionAttribute getAttributePointer() {
		if (attributePointer != null && attributePointer.eIsProxy()) {
			InternalEObject oldAttributePointer = (InternalEObject)attributePointer;
			attributePointer = (SourceSectionAttribute)eResolveProxy(oldAttributePointer);
			if (attributePointer != oldAttributePointer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.INSTANCE_POINTER__ATTRIBUTE_POINTER, oldAttributePointer, attributePointer));
			}
		}
		return attributePointer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionAttribute basicGetAttributePointer() {
		return attributePointer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributePointer(SourceSectionAttribute newAttributePointer) {
		SourceSectionAttribute oldAttributePointer = attributePointer;
		attributePointer = newAttributePointer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.INSTANCE_POINTER__ATTRIBUTE_POINTER, oldAttributePointer, attributePointer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.INSTANCE_POINTER__ATTRIBUTE_POINTER:
				if (resolve) return getAttributePointer();
				return basicGetAttributePointer();
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
			case MetamodelPackage.INSTANCE_POINTER__ATTRIBUTE_POINTER:
				setAttributePointer((SourceSectionAttribute)newValue);
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
			case MetamodelPackage.INSTANCE_POINTER__ATTRIBUTE_POINTER:
				setAttributePointer((SourceSectionAttribute)null);
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
			case MetamodelPackage.INSTANCE_POINTER__ATTRIBUTE_POINTER:
				return attributePointer != null;
		}
		return super.eIsSet(featureID);
	}

} //InstancePointerImpl
