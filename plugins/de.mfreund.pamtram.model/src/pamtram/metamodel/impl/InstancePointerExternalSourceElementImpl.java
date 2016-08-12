/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.MappingPackage;

import pamtram.mapping.impl.ExternalModifiedAttributeElementTypeImpl;

import pamtram.metamodel.InstancePointerExternalSourceElement;
import pamtram.metamodel.InstancePointerSourceInterface;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.ActualSourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Pointer External Source Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class InstancePointerExternalSourceElementImpl extends ExternalModifiedAttributeElementTypeImpl<SourceSection, SourceSectionClass, SourceSectionReference, ActualSourceSectionAttribute> implements InstancePointerExternalSourceElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstancePointerExternalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualSourceSectionAttribute getSourceAttribute() {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!MappingHintSourceInterface!getSourceAttribute()
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
				case MappingPackage.MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE: return MetamodelPackage.INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE;
				default: return -1;
			}
		}
		if (baseClass == InstancePointerSourceInterface.class) {
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
			case MetamodelPackage.INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE:
				return getSourceAttribute();
		}
		return super.eInvoke(operationID, arguments);
	}

} //InstancePointerExternalSourceElementImpl
