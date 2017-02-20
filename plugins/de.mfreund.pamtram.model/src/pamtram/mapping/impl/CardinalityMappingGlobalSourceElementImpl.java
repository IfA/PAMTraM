/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.CardinalityMappingGlobalSourceElement;
import pamtram.mapping.CardinalityMappingSourceInterface;
import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.MappingPackage;
import pamtram.structure.impl.GlobalModifiedAttributeElementTypeImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Cardinality Mapping Global Source
 * Element</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class CardinalityMappingGlobalSourceElementImpl extends
		GlobalModifiedAttributeElementTypeImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements CardinalityMappingGlobalSourceElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CardinalityMappingGlobalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return MappingPackage.Literals.CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public SourceSectionAttribute getSourceAttribute() {

		return this.getSource();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {

		if (baseClass == MappingHintSourceInterface.class) {
			switch (baseOperationID) {
				case MappingPackage.MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE:
					return MappingPackage.CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE;
				default:
					return -1;
			}
		}
		if (baseClass == CardinalityMappingSourceInterface.class) {
			switch (baseOperationID) {
				default:
					return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {

		switch (operationID) {
			case MappingPackage.CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE:
				return this.getSourceAttribute();
		}
		return super.eInvoke(operationID, arguments);
	}

} // CardinalityMappingGlobalSourceElementImpl
