/**
 */
package pamtram.condition.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.condition.Not;
import pamtram.condition.SingleConditionOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NotImpl extends SingleConditionOperatorImpl implements Not {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.NOT;
	}
	
	@Override
	public boolean checkCondition(ComplexCondition condition) {
		
		// Not Implementation
		if(((SingleConditionOperator) condition).getCondPartRef()!=null){
			return !condition.checkCondition(((SingleConditionOperator) condition).getCondPartRef());
		} else if(((SingleConditionOperator) condition).getCondPart()!=null){
			return !condition.checkCondition(((SingleConditionOperator) condition).getCondPart());
		} else{ 
			return false; //FIXME we don't need it
		}
	}

} //NotImpl
