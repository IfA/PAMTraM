/**
 */
package pamtram.condition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import pamtram.ConditionModel;
import pamtram.ConditionalElement;
import pamtram.condition.ConditionPackage;
import pamtram.condition.Not;
import pamtram.condition.util.ConditionValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NotImpl extends UnaryConditionImpl implements Not {
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceOnlyConditionsFromConditionModelOrFromConditionalElements(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if(this.sharedCondPart == null) {
			return true;
		}
		
		EObject sharedCondPartContainer = this.sharedCondPart.eContainer();
		
		boolean result = sharedCondPartContainer instanceof ConditionModel || sharedCondPartContainer instanceof ConditionalElement;
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "Reference only Conditions that are placed inside ConditionModel or where the Container is a ConditionalElement!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					ConditionValidator.DIAGNOSTIC_SOURCE,
							ConditionValidator.NOT__VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL_OR_FROM_CONDITIONAL_ELEMENTS,
							errorMessage,
					new Object[] { this, ConditionPackage.Literals.UNARY_CONDITION__SHARED_COND_PART }));
		
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ConditionPackage.NOT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL_OR_FROM_CONDITIONAL_ELEMENTS__DIAGNOSTICCHAIN_MAP:
				return validateReferenceOnlyConditionsFromConditionModelOrFromConditionalElements((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //NotImpl
