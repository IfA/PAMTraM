/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.TargetSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Section Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.TargetSectionContainmentReferenceImpl#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetSectionContainmentReferenceImpl extends ContainmentReferenceImpl<TargetSectionClass> implements TargetSectionContainmentReference {
	/**
	 * The cached value of the '{@link #getOwningClass() <em>Owning Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwningClass()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionClass owningClass;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionContainmentReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.TARGET_SECTION_CONTAINMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass getOwningClass() {
		if (owningClass != null && owningClass.eIsProxy()) {
			InternalEObject oldOwningClass = (InternalEObject)owningClass;
			owningClass = (TargetSectionClass)eResolveProxy(oldOwningClass);
			if (owningClass != oldOwningClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.TARGET_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS, oldOwningClass, owningClass));
			}
		}
		return owningClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass basicGetOwningClass() {
		return owningClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<TargetSectionClass> getValue() {
		if (value == null) {
			value = new EObjectContainmentEList<TargetSectionClass>(TargetSectionClass.class, this, MetamodelPackage.TARGET_SECTION_CONTAINMENT_REFERENCE__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetSectionClass> getValuesGeneric() {
		EList<TargetSectionClass> secs= new org.eclipse.emf.common.util.BasicEList<TargetSectionClass>();
		if(this instanceof TargetSectionContainmentReference){
		 secs.addAll(((TargetSectionContainmentReference) this).getValue());
		
		} else if(this instanceof TargetSectionNonContainmentReference){
		 secs.addAll(((TargetSectionNonContainmentReference) this).getValue());
		}
		return secs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.TARGET_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS:
				if (resolve) return getOwningClass();
				return basicGetOwningClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetamodelPackage.TARGET_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS:
				return owningClass != null;
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
				case MetamodelPackage.TARGET_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS: return MetamodelPackage.TARGET_SECTION_REFERENCE__OWNING_CLASS;
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
				case MetamodelPackage.TARGET_SECTION_REFERENCE__OWNING_CLASS: return MetamodelPackage.TARGET_SECTION_CONTAINMENT_REFERENCE__OWNING_CLASS;
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
		if (baseClass == TargetSectionReference.class) {
			switch (baseOperationID) {
				case MetamodelPackage.TARGET_SECTION_REFERENCE___GET_VALUES_GENERIC: return MetamodelPackage.TARGET_SECTION_CONTAINMENT_REFERENCE___GET_VALUES_GENERIC;
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
			case MetamodelPackage.TARGET_SECTION_CONTAINMENT_REFERENCE___GET_VALUES_GENERIC:
				return getValuesGeneric();
		}
		return super.eInvoke(operationID, arguments);
	}

} //TargetSectionContainmentReferenceImpl
