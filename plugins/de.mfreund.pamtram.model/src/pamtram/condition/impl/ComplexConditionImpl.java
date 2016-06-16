/**
 */
package pamtram.condition.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import pamtram.ConditionModel;
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
		return getRootCondition().eContainer() instanceof Mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConditionModelCondition() {
		return getRootCondition().eContainer() instanceof ConditionModel;
	}
	
	/**
	 * This iterates upward in the containment hierarchy and determines the <em>root condition</em> of this,
	 * i.e. the condition for that {@link #eContainer()} returns anything but a {@link ComplexCondition}.
	 * 
	 * @return The <em>root condition</em>.
	 */
	@Override
	public ComplexCondition getRootCondition() {
		
		ComplexCondition parentCondition = this;
		
		while(parentCondition.eContainer() instanceof ComplexCondition) {
			parentCondition = (ComplexCondition) parentCondition.eContainer();
		}
		
		return parentCondition;
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
			case ConditionPackage.COMPLEX_CONDITION___IS_CONDITION_MODEL_CONDITION:
				return isConditionModelCondition();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ComplexConditionImpl
