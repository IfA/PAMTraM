/**
 */
package pamtram.transformation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.mapping.impl.MappingTypeImpl;
import pamtram.transformation.TransformationMapping;
import pamtram.transformation.TransformationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.transformation.impl.TransformationMappingImpl#getSourceMElement <em>Source MElement</em>}</li>
 *   <li>{@link pamtram.transformation.impl.TransformationMappingImpl#getTargetMElement <em>Target MElement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationMappingImpl extends MappingTypeImpl implements TransformationMapping {
	/**
	 * The cached value of the '{@link #getSourceMElement() <em>Source MElement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceMElement()
	 * @generated
	 * @ordered
	 */
	protected EObject sourceMElement;

	/**
	 * The cached value of the '{@link #getTargetMElement() <em>Target MElement</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetMElement()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> targetMElement;

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
	public EObject getSourceMElement() {
		if (sourceMElement != null && sourceMElement.eIsProxy()) {
			InternalEObject oldSourceMElement = (InternalEObject)sourceMElement;
			sourceMElement = eResolveProxy(oldSourceMElement);
			if (sourceMElement != oldSourceMElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformationPackage.TRANSFORMATION_MAPPING__SOURCE_MELEMENT, oldSourceMElement, sourceMElement));
			}
		}
		return sourceMElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSourceMElement() {
		return sourceMElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceMElement(EObject newSourceMElement) {
		EObject oldSourceMElement = sourceMElement;
		sourceMElement = newSourceMElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.TRANSFORMATION_MAPPING__SOURCE_MELEMENT, oldSourceMElement, sourceMElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getTargetMElement() {
		if (targetMElement == null) {
			targetMElement = new EObjectResolvingEList<EObject>(EObject.class, this, TransformationPackage.TRANSFORMATION_MAPPING__TARGET_MELEMENT);
		}
		return targetMElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TransformationPackage.TRANSFORMATION_MAPPING__SOURCE_MELEMENT:
				if (resolve) return getSourceMElement();
				return basicGetSourceMElement();
			case TransformationPackage.TRANSFORMATION_MAPPING__TARGET_MELEMENT:
				return getTargetMElement();
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
			case TransformationPackage.TRANSFORMATION_MAPPING__SOURCE_MELEMENT:
				setSourceMElement((EObject)newValue);
				return;
			case TransformationPackage.TRANSFORMATION_MAPPING__TARGET_MELEMENT:
				getTargetMElement().clear();
				getTargetMElement().addAll((Collection<? extends EObject>)newValue);
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
			case TransformationPackage.TRANSFORMATION_MAPPING__SOURCE_MELEMENT:
				setSourceMElement((EObject)null);
				return;
			case TransformationPackage.TRANSFORMATION_MAPPING__TARGET_MELEMENT:
				getTargetMElement().clear();
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
			case TransformationPackage.TRANSFORMATION_MAPPING__SOURCE_MELEMENT:
				return sourceMElement != null;
			case TransformationPackage.TRANSFORMATION_MAPPING__TARGET_MELEMENT:
				return targetMElement != null && !targetMElement.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TransformationMappingImpl
