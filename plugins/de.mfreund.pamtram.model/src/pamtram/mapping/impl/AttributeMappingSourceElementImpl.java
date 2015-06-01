/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import pamtram.mapping.AttributeMappingSourceElement;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Mapping Source Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AttributeMappingSourceElementImpl extends LocalModifiedAttributeElementTypeImpl<SourceSectionClass, SourceSectionReference, SourceSectionAttribute> implements AttributeMappingSourceElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMappingSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.ATTRIBUTE_MAPPING_SOURCE_ELEMENT;
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
		if (baseClass == MappingHintSourceInterface.class) {
			switch (baseOperationID) {
				case MappingPackage.MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE: return MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE;
				case MappingPackage.MAPPING_HINT_SOURCE_INTERFACE___GET_NAME: return MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT___GET_NAME;
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
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE:
				return getSourceAttribute();
		}
		return super.eInvoke(operationID, arguments);
	}

} //AttributeMappingSourceElementImpl
