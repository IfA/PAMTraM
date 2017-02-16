/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.AttributeMatcherExternalSourceElement;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.MappingPackage;
import pamtram.structure.impl.ExternalModifiedAttributeElementTypeImpl;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Matcher External Source Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AttributeMatcherExternalSourceElementImpl extends ExternalModifiedAttributeElementTypeImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> implements AttributeMatcherExternalSourceElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMatcherExternalSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
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
				case MappingPackage.MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE: return MappingPackage.ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE;
				default: return -1;
			}
		}
		if (baseClass == AttributeMatcherSourceInterface.class) {
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
			case MappingPackage.ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE:
				return getSourceAttribute();
		}
		return super.eInvoke(operationID, arguments);
	}

} //AttributeMatcherExternalSourceElementImpl
