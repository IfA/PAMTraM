/**
 */
package pamtram.condition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.condition.ConditionTables;
import pamtram.condition.MultipleConditionOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiple Condition Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.impl.MultipleConditionOperatorImpl#getCondParts <em>Cond Parts</em>}</li>
 *   <li>{@link pamtram.condition.impl.MultipleConditionOperatorImpl#getCondPartsRef <em>Cond Parts Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MultipleConditionOperatorImpl extends ComplexConditionImpl implements MultipleConditionOperator {
	/**
	 * The cached value of the '{@link #getCondParts() <em>Cond Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondParts()
	 * @generated
	 * @ordered
	 */
	protected EList<ComplexCondition> condParts;

	/**
	 * The cached value of the '{@link #getCondPartsRef() <em>Cond Parts Ref</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondPartsRef()
	 * @generated
	 * @ordered
	 */
	protected EList<ComplexCondition> condPartsRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultipleConditionOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.MULTIPLE_CONDITION_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComplexCondition> getCondParts() {
		if (condParts == null) {
			condParts = new EObjectContainmentEList<ComplexCondition>(ComplexCondition.class, this, ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS);
		}
		return condParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComplexCondition> getCondPartsRef() {
		if (condPartsRef == null) {
			condPartsRef = new EObjectResolvingEList<ComplexCondition>(ComplexCondition.class, this, ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS_REF);
		}
		return condPartsRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean minimalCondParts(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv minimalCondParts:
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
		 *         'MultipleConditionOperator::minimalCondParts'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@NonNull*/ /*@Thrown*/ List<ComplexCondition> condParts = this.getCondParts();
		    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_condParts = idResolver.createOrderedSetOfAll(ConditionTables.ORD_CLSSid_ComplexCondition, condParts);
		    final /*@NonNull*/ /*@Thrown*/ IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_condParts));
		    final /*@NonNull*/ /*@Thrown*/ List<ComplexCondition> condPartsRef = this.getCondPartsRef();
		    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_condPartsRef = idResolver.createOrderedSetOfAll(ConditionTables.ORD_CLSSid_ComplexCondition, condPartsRef);
		    final /*@NonNull*/ /*@Thrown*/ IntegerValue size_0 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_condPartsRef));
		    final /*@NonNull*/ /*@Thrown*/ IntegerValue sum = ClassUtil.nonNullState((IntegerValue)NumericPlusOperation.INSTANCE.evaluate(size, size_0));
		    final /*@Thrown*/ boolean status = ClassUtil.nonNullState(OclComparableGreaterThanOperation.INSTANCE.evaluate(evaluator, sum, ConditionTables.INT_1).booleanValue());
		    CAUGHT_status = status;
		}
		catch (Exception e) {
		    CAUGHT_status = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_status instanceof InvalidValueException) {
		    throw (InvalidValueException)CAUGHT_status;
		}
		final /*@Thrown*/ boolean ne = CAUGHT_status == Boolean.FALSE;
		/*@Nullable*/ /*@NonInvalid*/ String message_0;
		if (ne) {
		    message_0 = ConditionTables.STR_The_32_required_32_subparts_32_of_32_this_32_condition_32_are_32_not_32_modeled_32_or_32_not_32_r;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, ConditionTables.STR_MultipleConditionOperator_c_c_minimalCondParts, this, null, diagnostics, context, message_0, ConditionTables.INT_4, CAUGHT_status, ConditionTables.INT_0).booleanValue());
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
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS:
				return ((InternalEList<?>)getCondParts()).basicRemove(otherEnd, msgs);
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
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS:
				return getCondParts();
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS_REF:
				return getCondPartsRef();
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
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS:
				getCondParts().clear();
				getCondParts().addAll((Collection<? extends ComplexCondition>)newValue);
				return;
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS_REF:
				getCondPartsRef().clear();
				getCondPartsRef().addAll((Collection<? extends ComplexCondition>)newValue);
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
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS:
				getCondParts().clear();
				return;
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS_REF:
				getCondPartsRef().clear();
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
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS:
				return condParts != null && !condParts.isEmpty();
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS_REF:
				return condPartsRef != null && !condPartsRef.isEmpty();
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
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR___MINIMAL_COND_PARTS__DIAGNOSTICCHAIN_MAP:
				return minimalCondParts((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //MultipleConditionOperatorImpl
