/**
 */
package pamtram.metamodel.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.TargetSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Section Non Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.TargetSectionNonContainmentReferenceImpl#getOwningClass <em>Owning Class</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.TargetSectionNonContainmentReferenceImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetSectionNonContainmentReferenceImpl extends NonContainmentReferenceImpl implements TargetSectionNonContainmentReference {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetSectionClass> value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionNonContainmentReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.TARGET_SECTION_NON_CONTAINMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass getOwningClass() {
		if (eContainerFeatureID() != MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__OWNING_CLASS) return null;
		return (TargetSectionClass)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetSectionClass> getValue() {
		if (value == null) {
			value = new EObjectResolvingEList<TargetSectionClass>(TargetSectionClass.class, this, MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__OWNING_CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__OWNING_CLASS, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__OWNING_CLASS:
				return eBasicSetContainer(null, MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__OWNING_CLASS, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__OWNING_CLASS:
				return eInternalContainer().eInverseRemove(this, MetamodelPackage.TARGET_SECTION_CLASS__REFERENCES, TargetSectionClass.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__OWNING_CLASS:
				return getOwningClass();
			case MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__VALUE:
				return getValue();
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
			case MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends TargetSectionClass>)newValue);
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
			case MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__VALUE:
				getValue().clear();
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
			case MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__OWNING_CLASS:
				return getOwningClass() != null;
			case MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__VALUE:
				return value != null && !value.isEmpty();
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
		if (baseClass == TargetSectionReference.class) {
			switch (derivedFeatureID) {
				case MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__OWNING_CLASS: return MetamodelPackage.TARGET_SECTION_REFERENCE__OWNING_CLASS;
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
		if (baseClass == TargetSectionReference.class) {
			switch (baseFeatureID) {
				case MetamodelPackage.TARGET_SECTION_REFERENCE__OWNING_CLASS: return MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE__OWNING_CLASS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //TargetSectionNonContainmentReferenceImpl