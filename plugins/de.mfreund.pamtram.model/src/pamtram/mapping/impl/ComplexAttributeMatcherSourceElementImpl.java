/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import pamtram.mapping.ComplexAttributeMatcherSourceElement;
import pamtram.mapping.ComplexAttributeMatcherSourceInterface;
import pamtram.mapping.ComplexMappingHintSourceInterface;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Attribute Matcher Source Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ComplexAttributeMatcherSourceElementImpl extends ModifiedAttributeElementTypeImpl<SourceSectionAttribute> implements ComplexAttributeMatcherSourceElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexAttributeMatcherSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setSource(SourceSectionAttribute newSource) {
		super.setSource(newSource);
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
				case MappingPackage.COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE: return MappingPackage.COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE;
				case MappingPackage.COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_NAME: return MappingPackage.COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT___GET_NAME;
				default: return -1;
			}
		}
		if (baseClass == ComplexAttributeMatcherSourceInterface.class) {
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
			case MappingPackage.COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT___GET_SOURCE_ATTRIBUTE:
				return getSourceAttribute();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ComplexAttributeMatcherSourceElementImpl
