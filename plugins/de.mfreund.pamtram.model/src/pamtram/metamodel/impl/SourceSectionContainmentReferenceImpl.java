/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Section Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.SourceSectionContainmentReferenceImpl#getOwningClass <em>Owning Class</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SourceSectionContainmentReferenceImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceSectionContainmentReferenceImpl extends ContainmentReferenceImpl implements SourceSectionContainmentReference {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceSectionClass> value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionContainmentReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.SOURCE_SECTION_CONTAINMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass getOwningClass() {
		if (eContainerFeatureID() != MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS) return null;
		return (SourceSectionClass)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceSectionClass> getValue() {
		if (value == null) {
			value = new EObjectContainmentEList<SourceSectionClass>(SourceSectionClass.class, this, MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceSectionClass> getValuesGeneric() {
						EList<SourceSectionClass> secs= new org.eclipse.emf.common.util.BasicEList<SourceSectionClass>();
						if(this instanceof SourceSectionContainmentReference){
						 secs.addAll(((SourceSectionContainmentReference) this).getValue());
						
						} else if(this instanceof MetaModelSectionReference){
						 secs.addAll(((MetaModelSectionReference) this).getValue());
						}
						return secs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS, msgs);
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
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS:
				return eBasicSetContainer(null, MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS, msgs);
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE:
				return ((InternalEList<?>)getValue()).basicRemove(otherEnd, msgs);
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
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS:
				return eInternalContainer().eInverseRemove(this, MetamodelPackage.SOURCE_SECTION_CLASS__REFERENCES, SourceSectionClass.class, msgs);
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
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS:
				return getOwningClass();
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE:
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
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends SourceSectionClass>)newValue);
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
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE:
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
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS:
				return getOwningClass() != null;
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE:
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
		if (baseClass == SourceSectionReference.class) {
			switch (derivedFeatureID) {
				case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS: return MetamodelPackage.SOURCE_SECTION_REFERENCE__OWNING_CLASS;
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
		if (baseClass == SourceSectionReference.class) {
			switch (baseFeatureID) {
				case MetamodelPackage.SOURCE_SECTION_REFERENCE__OWNING_CLASS: return MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS;
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
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == SourceSectionReference.class) {
			switch (baseOperationID) {
				case MetamodelPackage.SOURCE_SECTION_REFERENCE___GET_VALUES_GENERIC: return MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE___GET_VALUES_GENERIC;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE___GET_VALUES_GENERIC:
				return getValuesGeneric();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SourceSectionContainmentReferenceImpl
