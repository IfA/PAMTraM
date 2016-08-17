/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.impl.LocalModifiedAttributeElementTypeImpl;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionReference;
import pamtram.metamodel.ValueConstraintSourceElement;
import pamtram.metamodel.ValueConstraintSourceInterface;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Value Constraint Source Element</b></em>'. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class ValueConstraintSourceElementImpl extends LocalModifiedAttributeElementTypeImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> implements ValueConstraintSourceElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueConstraintSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT_SOURCE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceSectionAttribute getSourceAttribute() {
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
				case MappingPackage.MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE: return MetamodelPackage.ATTRIBUTE_VALUE_CONSTRAINT_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE;
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
			case MetamodelPackage.ATTRIBUTE_VALUE_CONSTRAINT_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE:
				return this.getSourceAttribute();
		}
		return super.eInvoke(operationID, arguments);
	}

} //AttributeValueConstraintSourceElementImpl
