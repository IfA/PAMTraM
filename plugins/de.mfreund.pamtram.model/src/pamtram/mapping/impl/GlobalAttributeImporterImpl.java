/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.ModelConnectionHintSourceInterface;
import pamtram.metamodel.AttributeValueConstraintSourceInterface;
import pamtram.metamodel.InstancePointerSourceInterface;
import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Variable Importer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.GlobalAttributeImporterImpl#getGlobalAttribute <em>Global Attribute</em>}</li>
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
	public SourceSectionAttribute getSourceAttribute() {
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == MappingHintSourceInterface.class) {
			switch (baseOperationID) {
				case MappingPackage.MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE: return MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER___GET_SOURCE_ATTRIBUTE;
				default: return -1;
			}
		}
		if (baseClass == AttributeMappingSourceInterface.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == AttributeMatcherSourceInterface.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == ModelConnectionHintSourceInterface.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == InstancePointerSourceInterface.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == AttributeValueConstraintSourceInterface.class) {
			switch (baseOperationID) {
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
			case MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER___GET_SOURCE_ATTRIBUTE:
				return getSourceAttribute();
		}
		return super.eInvoke(operationID, arguments);
	}

} //GlobalAttributeImporterImpl
