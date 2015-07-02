/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.DeactivatableElement;
import pamtram.PamtramPackage;
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingType;
import pamtram.metamodel.SourceSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.MappingTypeImpl#isDeactivated <em>Deactivated</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingTypeImpl#getSourceMMSection <em>Source MM Section</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MappingTypeImpl extends NamedElementImpl implements MappingType {
	/**
	 * The default value of the '{@link #isDeactivated() <em>Deactivated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeactivated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEACTIVATED_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isDeactivated() <em>Deactivated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeactivated()
	 * @generated
	 * @ordered
	 */
	protected boolean deactivated = DEACTIVATED_EDEFAULT;
	/**
	 * The cached value of the '{@link #getSourceMMSection() <em>Source MM Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceMMSection()
	 * @generated
	 * @ordered
	 */
	protected SourceSectionClass sourceMMSection;

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
	public boolean isDeactivated() {
		return deactivated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeactivated(boolean newDeactivated) {
		boolean oldDeactivated = deactivated;
		deactivated = newDeactivated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_TYPE__DEACTIVATED, oldDeactivated, deactivated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceSectionClass getSourceMMSection() {
		if (sourceMMSection != null && sourceMMSection.eIsProxy()) {
			InternalEObject oldSourceMMSection = (InternalEObject)sourceMMSection;
			sourceMMSection = (SourceSectionClass)eResolveProxy(oldSourceMMSection);
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
	public SourceSectionClass basicGetSourceMMSection() {
		return sourceMMSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceMMSectionGen(SourceSectionClass newSourceMMSection) {
		SourceSectionClass oldSourceMMSection = sourceMMSection;
		sourceMMSection = newSourceMMSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_TYPE__SOURCE_MM_SECTION, oldSourceMMSection, sourceMMSection));
	}
	
	/**
	 * Before setting the {@link newSourceMMSection}, update the name.
	 */
	@Override
	public void setSourceMMSection(SourceSectionClass newSourceMMSection) {
		setNameDerived(sourceMMSection, newSourceMMSection, null, "Mapping");
		setSourceMMSectionGen(newSourceMMSection);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.MAPPING_TYPE__DEACTIVATED:
				return isDeactivated();
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
			case MappingPackage.MAPPING_TYPE__DEACTIVATED:
				setDeactivated((Boolean)newValue);
				return;
			case MappingPackage.MAPPING_TYPE__SOURCE_MM_SECTION:
				setSourceMMSection((SourceSectionClass)newValue);
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
			case MappingPackage.MAPPING_TYPE__DEACTIVATED:
				setDeactivated(DEACTIVATED_EDEFAULT);
				return;
			case MappingPackage.MAPPING_TYPE__SOURCE_MM_SECTION:
				setSourceMMSection((SourceSectionClass)null);
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
			case MappingPackage.MAPPING_TYPE__DEACTIVATED:
				return deactivated != DEACTIVATED_EDEFAULT;
			case MappingPackage.MAPPING_TYPE__SOURCE_MM_SECTION:
				return sourceMMSection != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DeactivatableElement.class) {
			switch (derivedFeatureID) {
				case MappingPackage.MAPPING_TYPE__DEACTIVATED: return PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DeactivatableElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED: return MappingPackage.MAPPING_TYPE__DEACTIVATED;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (deactivated: ");
		result.append(deactivated);
		result.append(')');
		return result.toString();
	}

} //MappingTypeImpl
