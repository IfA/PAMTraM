/**
 */
package pamtram.condition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsTypeOfOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.condition.ConditionTables;
import pamtram.condition.Not;

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean referenceOnlyConditionsFromConditionModelOrFromConditionalElements(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv referenceOnlyConditionsFromConditionModelOrFromConditionalElements:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[?] = if self.condPartRef->size() = 1
		 *       then
		 *         self.condPartRef.oclContainer()
		 *         .oclIsTypeOf(ConditionModel) or
		 *         self.condPartRef.oclContainer()
		 *         .oclIsKindOf(ConditionalElement)
		 *       else true
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'Reference only Conditions that placed inside ConditionModel or where the Container is Kind of ConditionalElement!'
		 *         else null
		 *         endif
		 *       in
		 *         'Not::referenceOnlyConditionsFromConditionModelOrFromConditionalElements'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@Nullable*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@Nullable*/ /*@Thrown*/ ComplexCondition condPartRef = this.getCondPartRef();
		    final /*@NonNull*/ /*@Thrown*/ SetValue oclAsSet = ClassUtil.nonNullState(OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, ConditionTables.SET_CLSSid_ComplexCondition, condPartRef));
		    final /*@NonNull*/ /*@Thrown*/ IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(oclAsSet));
		    final /*@Thrown*/ boolean eq = size.equals(ConditionTables.INT_1);
		    /*@Nullable*/ /*@Thrown*/ Boolean status;
		    if (eq) {
		        /*@NonNull*/ /*@Caught*/ Object CAUGHT_oclIsTypeOf;
		        try {
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_ConditionModel_0 = idResolver.getClass(ConditionTables.CLSSid_ConditionModel, null);
		            final /*@Nullable*/ /*@Thrown*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, condPartRef);
		            final /*@Thrown*/ boolean oclIsTypeOf = ClassUtil.nonNullState(OclAnyOclIsTypeOfOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_ConditionModel_0).booleanValue());
		            CAUGHT_oclIsTypeOf = oclIsTypeOf;
		        }
		        catch (Exception e) {
		            CAUGHT_oclIsTypeOf = ValueUtil.createInvalidValue(e);
		        }
		        /*@NonNull*/ /*@Caught*/ Object CAUGHT_oclIsKindOf;
		        try {
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_ConditionalElement = idResolver.getClass(ConditionTables.CLSSid_ConditionalElement, null);
		            final /*@Nullable*/ /*@Thrown*/ Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, condPartRef);
		            final /*@Thrown*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, oclContainer_0, TYP_pamtram_c_c_ConditionalElement).booleanValue());
		            CAUGHT_oclIsKindOf = oclIsKindOf;
		        }
		        catch (Exception e) {
		            CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
		        }
		        final /*@Nullable*/ /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_oclIsTypeOf, CAUGHT_oclIsKindOf);
		        status = or;
		    }
		    else {
		        status = ValueUtil.TRUE_VALUE;
		    }
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
		    message_0 = ConditionTables.STR_Reference_32_only_32_Conditions_32_that_32_placed_32_inside_32_ConditionModel_32_or_32_w;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, ConditionTables.STR_Not_c_c_referenceOnlyConditionsFromConditionModelOrFromConditionalE, this, null, diagnostics, context, message_0, ConditionTables.INT_4, CAUGHT_status, ConditionTables.INT_0).booleanValue());
		return Boolean.TRUE == logDiagnostic;
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
			case ConditionPackage.NOT___REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL_OR_FROM_CONDITIONAL_ELEMENTS__DIAGNOSTICCHAIN_MAP:
				return referenceOnlyConditionsFromConditionModelOrFromConditionalElements((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //NotImpl
