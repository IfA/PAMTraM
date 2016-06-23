/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyToStringOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.MetamodelTables;
import pamtram.metamodel.SourceSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta Model Section Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.MetaModelSectionReferenceImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetaModelSectionReferenceImpl extends SourceSectionReferenceImpl implements MetaModelSectionReference {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceSectionClass> value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaModelSectionReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.META_MODEL_SECTION_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceSectionClass> getValue() {
		if (value == null) {
			value = new EObjectResolvingEList<SourceSectionClass>(SourceSectionClass.class, this, MetamodelPackage.META_MODEL_SECTION_REFERENCE__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean valuesMatchReferenceType(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv valuesMatchReferenceType:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[?] = if self.eReference.oclType() = OclVoid
		 *       then true
		 *       else
		 *         self.value->forAll(c |
		 *           self.eReference.eReferenceType.isSuperTypeOf(c.eClass))
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then
		 *           self.value->select(c |
		 *             not self.eReference.eReferenceType.isSuperTypeOf(c.eClass))
		 *           ->size()
		 *           .toString() + ' of the selected target Classes (Value) are not allowed by the selected eReference \'' + self.eReference.name + '\'!'
		 *         else null
		 *         endif
		 *       in
		 *         'MetaModelSectionReference::valuesMatchReferenceType'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ /*@Nullable*/ Object CAUGHT_status;
		try {
		    final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		    final /*@Thrown*/ EReference eReference = this.getEReference();
		    final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, eReference);
		    final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		    /*@Thrown*/ Boolean status;
		    if (eq) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        final /*@Thrown*/ List<SourceSectionClass> value = this.getValue();
		        final /*@Thrown*/ OrderedSetValue BOXED_value = idResolver.createOrderedSetOfAll(MetamodelTables.ORD_CLSSid_SourceSectionClass, value);
		        /*@Thrown*/ Object accumulator = ValueUtil.TRUE_VALUE;
		        /*@NonNull*/ Iterator<Object> ITERATOR_c = BOXED_value.iterator();
		        /*@Thrown*/ Boolean forAll;
		        while (true) {
		            if (!ITERATOR_c.hasNext()) {
		                if (accumulator == ValueUtil.TRUE_VALUE) {
		                    forAll = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    throw (InvalidValueException)accumulator;
		                }
		                break;
		            }
		            /*@NonInvalid*/ SourceSectionClass c = (SourceSectionClass)ITERATOR_c.next();
		            /**
		             * self.eReference.eReferenceType.isSuperTypeOf(c.eClass)
		             */
		            /*@Caught*/ /*@NonNull*/ Object CAUGHT_isSuperTypeOf;
		            try {
		                final /*@Thrown*/ EClass eReferenceType = eReference.getEReferenceType();
		                final /*@Thrown*/ EClass eClass = c.getEClass();
		                final /*@Thrown*/ boolean isSuperTypeOf = eReferenceType.isSuperTypeOf(eClass);
		                CAUGHT_isSuperTypeOf = isSuperTypeOf;
		            }
		            catch (Exception e) {
		                CAUGHT_isSuperTypeOf = ValueUtil.createInvalidValue(e);
		            }
		            //
		            if (CAUGHT_isSuperTypeOf == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
		                forAll = ValueUtil.FALSE_VALUE;
		                break;														// Stop immediately 
		            }
		            else if (CAUGHT_isSuperTypeOf == ValueUtil.TRUE_VALUE) {				// Normal successful body evaluation result
		                ;															// Carry on
		            }
		            else if (CAUGHT_isSuperTypeOf instanceof InvalidValueException) {		// Abnormal exception evaluation result
		                accumulator = CAUGHT_isSuperTypeOf;									// Cache an exception failure
		            }
		            else {															// Impossible badly typed result
		                accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
		            }
		        }
		        status = forAll;
		    }
		    CAUGHT_status = status;
		}
		catch (Exception e) {
		    CAUGHT_status = ValueUtil.createInvalidValue(e);
		}
		/*@Caught*/ /*@Nullable*/ Object CAUGHT_message_0;
		try {
		    if (CAUGHT_status instanceof InvalidValueException) {
		        throw (InvalidValueException)CAUGHT_status;
		    }
		    final /*@Thrown*/ boolean ne = CAUGHT_status == Boolean.FALSE;
		    /*@Thrown*/ String message_0;
		    if (ne) {
		        final /*@Thrown*/ EReference eReference_2 = this.getEReference();
		        final /*@Thrown*/ List<SourceSectionClass> value_0 = this.getValue();
		        final /*@Thrown*/ OrderedSetValue BOXED_value_0 = idResolver.createOrderedSetOfAll(MetamodelTables.ORD_CLSSid_SourceSectionClass, value_0);
		        /*@Thrown*/ OrderedSetValue.Accumulator accumulator_0 = ValueUtil.createOrderedSetAccumulatorValue(MetamodelTables.ORD_CLSSid_SourceSectionClass);
		        /*@NonNull*/ Iterator<Object> ITERATOR_c_0 = BOXED_value_0.iterator();
		        /*@Thrown*/ OrderedSetValue select;
		        while (true) {
		            if (!ITERATOR_c_0.hasNext()) {
		                select = accumulator_0;
		                break;
		            }
		            /*@NonInvalid*/ SourceSectionClass c_0 = (SourceSectionClass)ITERATOR_c_0.next();
		            /**
		             * not self.eReference.eReferenceType.isSuperTypeOf(c.eClass)
		             */
		            final /*@Thrown*/ EClass eReferenceType_0 = eReference_2.getEReferenceType();
		            final /*@Thrown*/ EClass eClass_0 = c_0.getEClass();
		            final /*@Thrown*/ boolean isSuperTypeOf_0 = eReferenceType_0.isSuperTypeOf(eClass_0);
		            final /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(isSuperTypeOf_0);
		            if (not == null) {
		                throw new InvalidValueException("Null body for \'OrderedSet(T).select(OrderedSet.T[?] | Lambda T() : Boolean[1]) : OrderedSet(T)\'");
		            }
		            //
		            if (not == ValueUtil.TRUE_VALUE) {
		                accumulator_0.add(c_0);
		            }
		        }
		        final /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(select);
		        final /*@Thrown*/ String toString = OclAnyToStringOperation.INSTANCE.evaluate(size);
		        final /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(toString, MetamodelTables.STR__32_of_32_the_32_selected_32_target_32_Classes_32_o_Value_e_32_are_32_not_32_allowed_32_by_32_the_32_s);
		        final /*@Thrown*/ String name = eReference_2.getName();
		        final /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name);
		        final /*@Thrown*/ String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, MetamodelTables.STR__39_33);
		        message_0 = sum_1;
		    }
		    else {
		        message_0 = null;
		    }
		    CAUGHT_message_0 = message_0;
		}
		catch (Exception e) {
		    CAUGHT_message_0 = ValueUtil.createInvalidValue(e);
		}
		final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, MetamodelTables.STR_MetaModelSectionReference_c_c_valuesMatchReferenceType, this, null, diagnostics, context, CAUGHT_message_0, MetamodelTables.INT_4, CAUGHT_status, MetamodelTables.INT_0).booleanValue();
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.META_MODEL_SECTION_REFERENCE__VALUE:
				return getValue();
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
			case MetamodelPackage.META_MODEL_SECTION_REFERENCE__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends SourceSectionClass>)newValue);
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
			case MetamodelPackage.META_MODEL_SECTION_REFERENCE__VALUE:
				getValue().clear();
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
			case MetamodelPackage.META_MODEL_SECTION_REFERENCE__VALUE:
				return value != null && !value.isEmpty();
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
			case MetamodelPackage.META_MODEL_SECTION_REFERENCE___VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP_17:
				return valuesMatchReferenceType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //MetaModelSectionReferenceImpl
