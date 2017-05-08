/**
 */
package pamtram.condition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.ConditionModel;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.condition.VariadicCondition;
import pamtram.condition.util.ConditionValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Multiple Condition Operator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.condition.impl.VariadicConditionImpl#getLocalCondParts
 * <em>Local Cond Parts</em>}</li>
 * <li>{@link pamtram.condition.impl.VariadicConditionImpl#getSharedCondParts
 * <em>Shared Cond Parts</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class VariadicConditionImpl extends ComplexConditionImpl implements VariadicCondition {
	/**
	 * The cached value of the '{@link #getLocalCondParts() <em>Local Cond
	 * Parts</em>}' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getLocalCondParts()
	 * @generated
	 * @ordered
	 */
	protected EList<ComplexCondition> localCondParts;

	/**
	 * The cached value of the '{@link #getSharedCondParts() <em>Shared Cond
	 * Parts</em>}' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getSharedCondParts()
	 * @generated
	 * @ordered
	 */
	protected EList<ComplexCondition> sharedCondParts;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected VariadicConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.VARIADIC_CONDITION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<ComplexCondition> getLocalCondParts() {
		if (this.localCondParts == null) {
			this.localCondParts = new EObjectContainmentEList<>(ComplexCondition.class, this,
					ConditionPackage.VARIADIC_CONDITION__LOCAL_COND_PARTS);
		}
		return this.localCondParts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<ComplexCondition> getSharedCondParts() {
		if (this.sharedCondParts == null) {
			this.sharedCondParts = new EObjectResolvingEList<>(ComplexCondition.class, this,
					ConditionPackage.VARIADIC_CONDITION__SHARED_COND_PARTS);
		}
		return this.sharedCondParts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean referencesOnlyValidConditions() {
		if (this.sharedCondParts == null || this.sharedCondParts.size() == 0) {
			return true;
		}
		EList<ComplexCondition> conditionRefs = new BasicEList<>();
		conditionRefs.add((ComplexCondition) this.sharedCondParts);
		for (ComplexCondition condition : conditionRefs) {
			if (!(condition instanceof ConditionModel)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean validateMinimalNumberOfArgs(final DiagnosticChain diagnostics, final Map<?, ?> context) {

		boolean result = this.getLocalCondParts().size() + this.getSharedCondParts().size() > 1;

		if (!result && diagnostics != null) {

			String errorMessage = "At least two (local or shared) condition parts need to be specified!";

			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ConditionValidator.DIAGNOSTIC_SOURCE,
					ConditionValidator.VARIADIC_CONDITION__VALIDATE_MINIMAL_NUMBER_OF_ARGS, errorMessage,
					new Object[] { this, ConditionPackage.Literals.VARIADIC_CONDITION }));

		}

		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ConditionPackage.VARIADIC_CONDITION__LOCAL_COND_PARTS:
			return ((InternalEList<?>) this.getLocalCondParts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ConditionPackage.VARIADIC_CONDITION__LOCAL_COND_PARTS:
			return this.getLocalCondParts();
		case ConditionPackage.VARIADIC_CONDITION__SHARED_COND_PARTS:
			return this.getSharedCondParts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ConditionPackage.VARIADIC_CONDITION__LOCAL_COND_PARTS:
			this.getLocalCondParts().clear();
			this.getLocalCondParts().addAll((Collection<? extends ComplexCondition>) newValue);
			return;
		case ConditionPackage.VARIADIC_CONDITION__SHARED_COND_PARTS:
			this.getSharedCondParts().clear();
			this.getSharedCondParts().addAll((Collection<? extends ComplexCondition>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ConditionPackage.VARIADIC_CONDITION__LOCAL_COND_PARTS:
			this.getLocalCondParts().clear();
			return;
		case ConditionPackage.VARIADIC_CONDITION__SHARED_COND_PARTS:
			this.getSharedCondParts().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ConditionPackage.VARIADIC_CONDITION__LOCAL_COND_PARTS:
			return this.localCondParts != null && !this.localCondParts.isEmpty();
		case ConditionPackage.VARIADIC_CONDITION__SHARED_COND_PARTS:
			return this.sharedCondParts != null && !this.sharedCondParts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case ConditionPackage.VARIADIC_CONDITION___REFERENCES_ONLY_VALID_CONDITIONS:
			return this.referencesOnlyValidConditions();
		case ConditionPackage.VARIADIC_CONDITION___VALIDATE_MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP:
			return this.validateMinimalNumberOfArgs((DiagnosticChain) arguments.get(0), (Map<?, ?>) arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public boolean isLocalCondition() {

		List<ComplexCondition> subConditions = new ArrayList<>();

		subConditions.addAll(this.getLocalCondParts());
		subConditions.addAll(this.getSharedCondParts());

		return subConditions.parallelStream().filter(c -> c.isLocalCondition()).findAny().isPresent();
	}

	@Override
	public EList<ComplexCondition> getConditionPartsFlat() {
		EList<ComplexCondition> ret = new BasicEList<>();
		ret.add(this);
		ret.addAll(Stream.concat(this.getLocalCondParts().stream(), this.getSharedCondParts().stream())
				.collect(Collectors.toList()));
		return ret;
	}

} // MultipleConditionOperatorImpl
