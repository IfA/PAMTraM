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

import pamtram.mapping.ComplexAttributeMappingSourceInterface;
import pamtram.mapping.GlobalVariabeImporter;
import pamtram.mapping.GlobalVariable;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Variabe Importer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.mapping.impl.GlobalVariabeImporterImpl#getGlobalVariable <em>Global Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GlobalVariabeImporterImpl extends NamedElementImpl implements GlobalVariabeImporter {
	/**
	 * The cached value of the '{@link #getGlobalVariable() <em>Global Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalVariable()
	 * @generated
	 * @ordered
	 */
	protected GlobalVariable globalVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalVariabeImporterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.GLOBAL_VARIABE_IMPORTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalVariable getGlobalVariable() {
		if (globalVariable != null && globalVariable.eIsProxy()) {
			InternalEObject oldGlobalVariable = (InternalEObject)globalVariable;
			globalVariable = (GlobalVariable)eResolveProxy(oldGlobalVariable);
			if (globalVariable != oldGlobalVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.GLOBAL_VARIABE_IMPORTER__GLOBAL_VARIABLE, oldGlobalVariable, globalVariable));
			}
		}
		return globalVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalVariable basicGetGlobalVariable() {
		return globalVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalVariable(GlobalVariable newGlobalVariable) {
		GlobalVariable oldGlobalVariable = globalVariable;
		globalVariable = newGlobalVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.GLOBAL_VARIABE_IMPORTER__GLOBAL_VARIABLE, oldGlobalVariable, globalVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SourceSectionAttribute getSourceAttribute() {
		if(this.getGlobalVariable() == null){
			return null;
		} else {
			return this.getGlobalVariable().getSource();
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
			case MappingPackage.GLOBAL_VARIABE_IMPORTER__GLOBAL_VARIABLE:
				if (resolve) return getGlobalVariable();
				return basicGetGlobalVariable();
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
			case MappingPackage.GLOBAL_VARIABE_IMPORTER__GLOBAL_VARIABLE:
				setGlobalVariable((GlobalVariable)newValue);
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
			case MappingPackage.GLOBAL_VARIABE_IMPORTER__GLOBAL_VARIABLE:
				setGlobalVariable((GlobalVariable)null);
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
			case MappingPackage.GLOBAL_VARIABE_IMPORTER__GLOBAL_VARIABLE:
				return globalVariable != null;
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
		if (baseClass == ComplexAttributeMappingSourceInterface.class) {
			switch (baseOperationID) {
				case MappingPackage.COMPLEX_ATTRIBUTE_MAPPING_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE: return MappingPackage.GLOBAL_VARIABE_IMPORTER___GET_SOURCE_ATTRIBUTE;
				case MappingPackage.COMPLEX_ATTRIBUTE_MAPPING_SOURCE_INTERFACE___GET_NAME: return MappingPackage.GLOBAL_VARIABE_IMPORTER___GET_NAME;
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
			case MappingPackage.GLOBAL_VARIABE_IMPORTER___GET_SOURCE_ATTRIBUTE:
				return getSourceAttribute();
		}
		return super.eInvoke(operationID, arguments);
	}

} //GlobalVariabeImporterImpl
