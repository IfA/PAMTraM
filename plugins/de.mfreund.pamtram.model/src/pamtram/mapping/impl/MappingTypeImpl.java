/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.mapping.impl.MappingTypeImpl#getSourceMMSection <em>Source MM Section</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MappingTypeImpl extends NamedElementImpl implements MappingType {
	/**
	 * The cached value of the '{@link #getSourceMMSection() <em>Source MM Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceMMSection()
	 * @generated
	 * @ordered
	 */
	protected pamtram.metamodel.Class sourceMMSection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPING_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public pamtram.metamodel.Class getSourceMMSection() {
		if (sourceMMSection != null && sourceMMSection.eIsProxy()) {
			InternalEObject oldSourceMMSection = (InternalEObject)sourceMMSection;
			sourceMMSection = (pamtram.metamodel.Class)eResolveProxy(oldSourceMMSection);
			if (sourceMMSection != oldSourceMMSection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING_TYPE__SOURCE_MM_SECTION, oldSourceMMSection, sourceMMSection));
			}
		}
		return sourceMMSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public pamtram.metamodel.Class basicGetSourceMMSection() {
		return sourceMMSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceMMSection(pamtram.metamodel.Class newSourceMMSection) {
		pamtram.metamodel.Class oldSourceMMSection = sourceMMSection;
		sourceMMSection = newSourceMMSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_TYPE__SOURCE_MM_SECTION, oldSourceMMSection, sourceMMSection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.MAPPING_TYPE__SOURCE_MM_SECTION:
				if (resolve) return getSourceMMSection();
				return basicGetSourceMMSection();
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
			case MappingPackage.MAPPING_TYPE__SOURCE_MM_SECTION:
				setSourceMMSection((pamtram.metamodel.Class)newValue);
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
			case MappingPackage.MAPPING_TYPE__SOURCE_MM_SECTION:
				setSourceMMSection((pamtram.metamodel.Class)null);
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
			case MappingPackage.MAPPING_TYPE__SOURCE_MM_SECTION:
				return sourceMMSection != null;
		}
		return super.eIsSet(featureID);
	}

} //MappingTypeImpl
