/**
 */
package pamtram.condition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import pamtram.ConditionModel;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.Mapping;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Complex Condition</b></em>'. <!-- end-user-doc
 * -->
 *
 * @generated
 */
public abstract class ComplexConditionImpl extends NamedElementImpl implements ComplexCondition {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.COMPLEX_CONDITION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isLocalCondition() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isExternalCondition() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean isGlobalCondition() {

		return !this.isLocalCondition() && !this.isExternalCondition();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMappingCondition() {
		return getRootCondition().eContainer() instanceof Mapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isConditionModelCondition() {
		return getRootCondition().eContainer() instanceof ConditionModel;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public EList<ComplexCondition> getConditionPartsFlat() {

		return new BasicEList<>(Arrays.asList(this));
	}

	/**
	 * This iterates upward in the containment hierarchy and determines the <em>root condition</em> of this, i.e. the
	 * condition for that {@link #eContainer()} returns anything but a {@link ComplexCondition}.
	 *
	 * @return The <em>root condition</em>.
	 */
	@Override
	public ComplexCondition getRootCondition() {

		ComplexCondition parentCondition = this;

		while (parentCondition.eContainer() instanceof ComplexCondition) {
			parentCondition = (ComplexCondition) parentCondition.eContainer();
		}

		return parentCondition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ConditionPackage.COMPLEX_CONDITION___IS_LOCAL_CONDITION:
				return isLocalCondition();
			case ConditionPackage.COMPLEX_CONDITION___IS_EXTERNAL_CONDITION:
				return isExternalCondition();
			case ConditionPackage.COMPLEX_CONDITION___IS_GLOBAL_CONDITION:
				return isGlobalCondition();
			case ConditionPackage.COMPLEX_CONDITION___IS_MAPPING_CONDITION:
				return isMappingCondition();
			case ConditionPackage.COMPLEX_CONDITION___IS_CONDITION_MODEL_CONDITION:
				return isConditionModelCondition();
			case ConditionPackage.COMPLEX_CONDITION___GET_CONDITION_PARTS_FLAT:
				return getConditionPartsFlat();
		}
		return super.eInvoke(operationID, arguments);
	}

} // ComplexConditionImpl
