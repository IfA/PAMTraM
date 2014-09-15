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
import pamtram.mapping.ComplexAttributeMatcherSourceInterface;
import pamtram.mapping.ComplexMappingHintSourceInterface;
import pamtram.mapping.ComplexModelConnectionHintSourceInterface;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalVariableImporter;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Variable Importer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.mapping.impl.GlobalVariableImporterImpl#getGlobalVariable <em>Global Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GlobalVariableImporterImpl extends NamedElementImpl implements GlobalVariableImporter {
	/**
	 * The cached value of the '{@link #getGlobalVariable() <em>Global Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalVariable()
	 * @generated
	 * @ordered
	 */
	protected GlobalAttribute globalVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalVariableImporterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.GLOBAL_VARIABLE_IMPORTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalAttribute getGlobalVariable() {
		if (globalVariable != null && globalVariable.eIsProxy()) {
			InternalEObject oldGlobalVariable = (InternalEObject)globalVariable;
			globalVariable = (GlobalAttribute)eResolveProxy(oldGlobalVariable);
			if (globalVariable != oldGlobalVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.GLOBAL_VARIABLE_IMPORTER__GLOBAL_VARIABLE, oldGlobalVariable, globalVariable));
			}
		}
		return globalVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalAttribute basicGetGlobalVariable() {
		return globalVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalVariable(GlobalAttribute newGlobalVariable) {
		GlobalAttribute oldGlobalVariable = globalVariable;
		globalVariable = newGlobalVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.GLOBAL_VARIABLE_IMPORTER__GLOBAL_VARIABLE, oldGlobalVariable, globalVariable));
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
			case MappingPackage.GLOBAL_VARIABLE_IMPORTER__GLOBAL_VARIABLE:
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
			case MappingPackage.GLOBAL_VARIABLE_IMPORTER__GLOBAL_VARIABLE:
				setGlobalVariable((GlobalAttribute)newValue);
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
			case MappingPackage.GLOBAL_VARIABLE_IMPORTER__GLOBAL_VARIABLE:
				setGlobalVariable((GlobalAttribute)null);
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
			case MappingPackage.GLOBAL_VARIABLE_IMPORTER__GLOBAL_VARIABLE:
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
		if (baseClass == ComplexMappingHintSourceInterface.class) {
			switch (baseOperationID) {
				case MappingPackage.COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE: return MappingPackage.GLOBAL_VARIABLE_IMPORTER___GET_SOURCE_ATTRIBUTE;
				case MappingPackage.COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_NAME: return MappingPackage.GLOBAL_VARIABLE_IMPORTER___GET_NAME;
				default: return -1;
			}
		}
		if (baseClass == ComplexAttributeMappingSourceInterface.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == ComplexAttributeMatcherSourceInterface.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == ComplexModelConnectionHintSourceInterface.class) {
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
			case MappingPackage.GLOBAL_VARIABLE_IMPORTER___GET_SOURCE_ATTRIBUTE:
				return getSourceAttribute();
		}
		return super.eInvoke(operationID, arguments);
	}

} //GlobalVariableImporterImpl