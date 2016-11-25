/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.impl.ExternalModifiedAttributeElementTypeImpl;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionReference;
import pamtram.metamodel.ValueConstraintExternalSourceElement;
import pamtram.metamodel.ValueConstraintSourceInterface;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Value Constraint External Source
 * Element</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class ValueConstraintExternalSourceElementImpl extends ExternalModifiedAttributeElementTypeImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> implements ValueConstraintExternalSourceElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueConstraintExternalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceSectionAttribute getSourceAttribute() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
				case MappingPackage.MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE: return MetamodelPackage.VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE;
				default: return -1;
			}
		}
		if (baseClass == ValueConstraintSourceInterface.class) {
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
			case MetamodelPackage.VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE:
				return getSourceAttribute();
		}
		return super.eInvoke(operationID, arguments);
	}

} //AttributeValueConstraintExternalSourceElementImpl
