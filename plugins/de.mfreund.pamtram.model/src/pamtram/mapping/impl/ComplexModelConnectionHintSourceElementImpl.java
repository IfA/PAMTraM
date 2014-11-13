/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import pamtram.mapping.ComplexMappingHintSourceInterface;
import pamtram.mapping.ComplexModelConnectionHintSourceElement;
import pamtram.mapping.ComplexModelConnectionHintSourceInterface;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Model Connection Hint Source Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ComplexModelConnectionHintSourceElementImpl extends AttributeMappingSourceElementTypeImpl implements ComplexModelConnectionHintSourceElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexModelConnectionHintSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.COMPLEX_MODEL_CONNECTION_HINT_SOURCE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SourceSectionAttribute getSourceAttribute() {
		return this.getSource();
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
				case MappingPackage.COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE: return MappingPackage.COMPLEX_MODEL_CONNECTION_HINT_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE;
				case MappingPackage.COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_NAME: return MappingPackage.COMPLEX_MODEL_CONNECTION_HINT_SOURCE_ELEMENT___GET_NAME;
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
			case MappingPackage.COMPLEX_MODEL_CONNECTION_HINT_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE:
				return getSourceAttribute();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ComplexModelConnectionHintSourceElementImpl
