/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.ComplexAttributeMappingExternalSourceElement;
import pamtram.mapping.ComplexMappingHintSourceInterface;
import pamtram.mapping.MappingPackage;

import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Attribute Mapping External Source Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ComplexAttributeMappingExternalSourceElementImpl extends ExternalAttributeMappingSourceElementImpl implements ComplexAttributeMappingExternalSourceElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexAttributeMappingExternalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT;
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
				case MappingPackage.COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE: return MappingPackage.COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE;
				case MappingPackage.COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_NAME: return MappingPackage.COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT___GET_NAME;
				default: return -1;
			}
		}
		if (baseClass == AttributeMappingSourceInterface.class) {
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
			case MappingPackage.COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE:
				return getSourceAttribute();
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public SourceSectionAttribute getSourceAttribute() {
		// TODO Auto-generated method stub
		return null;
	}

} //ComplexAttributeMappingExternalSourceElementImpl
