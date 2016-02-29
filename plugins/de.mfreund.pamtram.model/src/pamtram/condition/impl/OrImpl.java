/**
 */
package pamtram.condition.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.condition.MultipleConditionOperator;
import pamtram.condition.Or;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Or</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class OrImpl extends MultipleConditionOperatorImpl implements Or {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.OR;
	}
	
	@Override
	public boolean checkCondition(ComplexCondition condition) {
		
		boolean result = false; // Note that is an Or
		EList<ComplexCondition> args = new BasicEList<ComplexCondition>(); 
		args.addAll(((MultipleConditionOperator) condition).getCondParts());
		args.addAll(((MultipleConditionOperator) condition).getCondPartsRef());
		
		for(ComplexCondition arg: args){ // Iterate over all arguments
			
			result = result || arg.checkCondition(arg);
			if (result==true){ // In order to save some time we break the loop after one argument returned true (Or-Operator
				break;
			}
		}
		
		return result;
	}

} //OrImpl
