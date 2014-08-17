/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.CalculatorMappingSourceInterface;
import pamtram.mapping.ComplexMappingHintSourceInterface;
import pamtram.mapping.ExpressionVariable;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ExpressionVariableImpl extends AttributeMappingSourceElementWithModifiersImpl implements ExpressionVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.EXPRESSION_VARIABLE;
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
				case MappingPackage.COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE: return MappingPackage.EXPRESSION_VARIABLE___GET_SOURCE_ATTRIBUTE;
				case MappingPackage.COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_NAME: return MappingPackage.EXPRESSION_VARIABLE___GET_NAME;
				default: return -1;
			}
		}
		if (baseClass == CalculatorMappingSourceInterface.class) {
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
			case MappingPackage.EXPRESSION_VARIABLE___GET_SOURCE_ATTRIBUTE:
				return getSourceAttribute();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ExpressionVariableImpl
