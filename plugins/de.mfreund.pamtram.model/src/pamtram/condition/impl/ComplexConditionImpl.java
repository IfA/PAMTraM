/**
 */
package pamtram.condition.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.Mapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ComplexConditionImpl extends NamedElementImpl implements ComplexCondition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.COMPLEX_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLocalCondition() {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!ComplexCondition!isLocalCondition()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMappingCondition() {
		return this.eContainer() instanceof Mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ConditionPackage.COMPLEX_CONDITION___IS_LOCAL_CONDITION:
				return isLocalCondition();
			case ConditionPackage.COMPLEX_CONDITION___IS_MAPPING_CONDITION:
				return isMappingCondition();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ComplexConditionImpl
