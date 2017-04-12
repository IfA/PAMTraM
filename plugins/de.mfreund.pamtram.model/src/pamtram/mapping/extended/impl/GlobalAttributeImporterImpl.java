/**
 */
package pamtram.mapping.extended.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.extended.GlobalAttributeImporter;
import pamtram.structure.source.ActualSourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Variable Importer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.impl.GlobalAttributeImporterImpl#getGlobalAttribute <em>Global Attribute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GlobalAttributeImporterImpl extends NamedElementImpl implements GlobalAttributeImporter {
	/**
	 * The cached value of the '{@link #getGlobalAttribute() <em>Global Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalAttribute()
	 * @generated
	 * @ordered
	 */
	protected GlobalAttribute globalAttribute;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalAttributeImporterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.GLOBAL_ATTRIBUTE_IMPORTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalAttribute getGlobalAttribute() {
		if (globalAttribute != null && globalAttribute.eIsProxy()) {
			InternalEObject oldGlobalAttribute = (InternalEObject)globalAttribute;
			globalAttribute = (GlobalAttribute)eResolveProxy(oldGlobalAttribute);
			if (globalAttribute != oldGlobalAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE, oldGlobalAttribute, globalAttribute));
			}
		}
		return globalAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalAttribute basicGetGlobalAttribute() {
		return globalAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalAttributeGen(GlobalAttribute newGlobalAttribute) {
		GlobalAttribute oldGlobalAttribute = globalAttribute;
		globalAttribute = newGlobalAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE, oldGlobalAttribute, globalAttribute));
	}
	
	
	/**
	 * Before setting the {@link newGlobalAttribute}, update the name.
	 */
	@Override
	public void setGlobalAttribute(GlobalAttribute newGlobalAttribute) {
		setNameDerived(globalAttribute, newGlobalAttribute, null, null);
		setGlobalAttributeGen(newGlobalAttribute);
	}
	
	public void setValue(String newValue) {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public ActualSourceSectionAttribute getSourceAttribute() {
		if(this.getGlobalAttribute() == null){
			return null;
		} else {
			return this.getGlobalAttribute().getSource();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE:
				if (resolve) return getGlobalAttribute();
				return basicGetGlobalAttribute();
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
			case MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE:
				setGlobalAttribute((GlobalAttribute)newValue);
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
			case MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE:
				setGlobalAttribute((GlobalAttribute)null);
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
			case MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE:
				return globalAttribute != null;
		}
		return super.eIsSet(featureID);
	}

} //GlobalAttributeImporterImpl
