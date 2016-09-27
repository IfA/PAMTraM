/**
 */
package pamtram.condition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import pamtram.ConditionModel;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.condition.ConditionTables;
import pamtram.condition.VariadicCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiple Condition Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.impl.VariadicConditionImpl#getCondParts <em>Cond Parts</em>}</li>
 *   <li>{@link pamtram.condition.impl.VariadicConditionImpl#getCondPartsRef <em>Cond Parts Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class VariadicConditionImpl extends ComplexConditionImpl implements VariadicCondition {
	/**
	 * The cached value of the '{@link #getLocalCondParts() <em>Cond Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalCondParts()
	 * @generated
	 * @ordered
	 */
	protected EList<ComplexCondition> localCondParts;

	/**
	 * The cached value of the '{@link #getSharedCondParts() <em>Cond Parts Ref</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedCondParts()
	 * @generated
	 * @ordered
	 */
	protected EList<ComplexCondition> sharedCondParts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariadicConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.VARIADIC_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComplexCondition> getLocalCondParts() {
		if (localCondParts == null) {
			localCondParts = new EObjectContainmentEList<ComplexCondition>(ComplexCondition.class, this, ConditionPackage.VARIADIC_CONDITION__COND_PARTS);
		}
		return localCondParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComplexCondition> getSharedCondParts() {
		if (sharedCondParts == null) {
			sharedCondParts = new EObjectResolvingEList<ComplexCondition>(ComplexCondition.class, this, ConditionPackage.VARIADIC_CONDITION__COND_PARTS_REF);
		}
		return sharedCondParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean referencesOnlyValidConditions() {
		if(this.sharedCondParts == null || this.sharedCondParts.size() == 0) {
			return true;
		}
		EList<ComplexCondition> conditionRefs = new BasicEList<ComplexCondition>();
		conditionRefs.add((ComplexCondition) this.sharedCondParts);
		for(ComplexCondition condition : conditionRefs){
			if(!(condition instanceof ConditionModel)){
				return false;
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean minimalNumberOfArgs(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv minimalNumberOfArgs:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = self.condParts->size() +
		 *       self.condPartsRef->size() > 1
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The required subparts of this condition are not modeled or not referenced !'
		 *         else null
		 *         endif
		 *       in
		 *         'VariadicCondition::minimalNumberOfArgs'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ /*@NonNull*/ Object CAUGHT_status;
		try {
		    final /*@Thrown*/ List<ComplexCondition> condParts = this.getLocalCondParts();
		    final /*@Thrown*/ OrderedSetValue BOXED_condParts = idResolver.createOrderedSetOfAll(ConditionTables.ORD_CLSSid_ComplexCondition, condParts);
		    final /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_condParts);
		    final /*@Thrown*/ List<ComplexCondition> condPartsRef = this.getSharedCondParts();
		    final /*@Thrown*/ OrderedSetValue BOXED_condPartsRef = idResolver.createOrderedSetOfAll(ConditionTables.ORD_CLSSid_ComplexCondition, condPartsRef);
		    final /*@Thrown*/ IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(BOXED_condPartsRef);
		    final /*@Thrown*/ IntegerValue sum = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(size, size_0);
		    final /*@Thrown*/ boolean status = OclComparableGreaterThanOperation.INSTANCE.evaluate(executor, sum, ConditionTables.INT_1).booleanValue();
		    CAUGHT_status = status;
		}
		catch (Exception e) {
		    CAUGHT_status = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_status instanceof InvalidValueException) {
		    throw (InvalidValueException)CAUGHT_status;
		}
		final /*@Thrown*/ boolean ne = CAUGHT_status == Boolean.FALSE;
		/*@NonInvalid*/ String message_0;
		if (ne) {
		    message_0 = ConditionTables.STR_The_32_required_32_subparts_32_of_32_this_32_condition_32_are_32_not_32_modeled_32_or_32_not_32_r;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, ConditionTables.STR_VariadicCondition_c_c_minimalNumberOfArgs, this, null, diagnostics, context, message_0, ConditionTables.INT_4, CAUGHT_status, ConditionTables.INT_0).booleanValue();
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConditionPackage.VARIADIC_CONDITION__COND_PARTS:
				return ((InternalEList<?>)getLocalCondParts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConditionPackage.VARIADIC_CONDITION__COND_PARTS:
				return getLocalCondParts();
			case ConditionPackage.VARIADIC_CONDITION__COND_PARTS_REF:
				return getSharedCondParts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConditionPackage.VARIADIC_CONDITION__COND_PARTS:
				getLocalCondParts().clear();
				getLocalCondParts().addAll((Collection<? extends ComplexCondition>)newValue);
				return;
			case ConditionPackage.VARIADIC_CONDITION__COND_PARTS_REF:
				getSharedCondParts().clear();
				getSharedCondParts().addAll((Collection<? extends ComplexCondition>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConditionPackage.VARIADIC_CONDITION__COND_PARTS:
				getLocalCondParts().clear();
				return;
			case ConditionPackage.VARIADIC_CONDITION__COND_PARTS_REF:
				getSharedCondParts().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConditionPackage.VARIADIC_CONDITION__COND_PARTS:
				return localCondParts != null && !localCondParts.isEmpty();
			case ConditionPackage.VARIADIC_CONDITION__COND_PARTS_REF:
				return sharedCondParts != null && !sharedCondParts.isEmpty();
		}
		return super.eIsSet(featureID);
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
			case ConditionPackage.VARIADIC_CONDITION___REFERENCES_ONLY_VALID_CONDITIONS:
				return referencesOnlyValidConditions();
			case ConditionPackage.VARIADIC_CONDITION___MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP:
				return minimalNumberOfArgs((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}
	
	@Override
	public boolean isLocalCondition() {
		
		List<ComplexCondition> subConditions = new ArrayList<>();
		
		subConditions.addAll(getLocalCondParts());
		subConditions.addAll(getSharedCondParts());
		
		return subConditions.parallelStream().filter(c -> c.isLocalCondition()).findAny().isPresent();
	}

} //MultipleConditionOperatorImpl
