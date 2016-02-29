/**
 */
package pamtram.condition.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import pamtram.condition.And;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.condition.MultipleConditionOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AndImpl extends MultipleConditionOperatorImpl implements And {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.AND;
	}
	
	@Override
	public boolean checkCondition(ComplexCondition condition) {
		
		boolean result = true; // Note that is an And
		EList<ComplexCondition> args = new BasicEList<ComplexCondition>(); 
		args.addAll(((MultipleConditionOperator) condition).getCondParts());
		args.addAll(((MultipleConditionOperator) condition).getCondPartsRef());
		
		for(ComplexCondition arg: args){ // Iterate over all arguments
			
			result = result && arg.checkCondition(arg);
			if (result==false){ // In order to save some time we break the loop after one argument returned false (And-Operator)
				break;
			}
		}
		
		return result;
	}

} //AndImpl
