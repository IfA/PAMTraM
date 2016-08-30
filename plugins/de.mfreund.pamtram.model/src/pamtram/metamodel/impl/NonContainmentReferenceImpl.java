/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
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
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.MetamodelTables;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.NonContainmentReferenceImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NonContainmentReferenceImpl<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ReferenceImpl<S, C, R, A> implements NonContainmentReference<S, C, R, A> {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<C> value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonContainmentReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.NON_CONTAINMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<C> getValue() {
		if (value == null) {
			value = new EObjectResolvingEList<C>(pamtram.metamodel.Class.class, this, MetamodelPackage.NON_CONTAINMENT_REFERENCE__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eReferenceIsNonContainment(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv eReferenceIsNonContainment:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = if self.eReference.oclType() = OclVoid
		 *       then true
		 *       else self.eReference.containment = false
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The eReference \'' + self.eReference.name + '\' is no non-containment reference!'
		 *         else null
		 *         endif
		 *       in
		 *         'NonContainmentReference::eReferenceIsNonContainment'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ /*@NonNull*/ Object CAUGHT_status;
		try {
		    final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		    final /*@Thrown*/ EReference eReference_0 = this.getEReference();
		    final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, eReference_0);
		    final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		    /*@Thrown*/ boolean status;
		    if (eq) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        final /*@Thrown*/ Boolean containment = eReference_0.isContainment();
		        final /*@Thrown*/ boolean eq_0 = !containment;
		        status = eq_0;
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
		/*@NonInvalid*/ String message_0;
		if (ne) {
		    final /*@Thrown*/ EReference eReference_1 = this.getEReference();
		    final /*@Thrown*/ String name = eReference_1.getName();
		    final /*@NonInvalid*/ String sum = StringConcatOperation.INSTANCE.evaluate(MetamodelTables.STR_The_32_eReference_32_39, name);
		    final /*@NonInvalid*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, MetamodelTables.STR__39_32_is_32_no_32_non_m_containment_32_reference_33);
		    message_0 = sum_0;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, MetamodelTables.STR_NonContainmentReference_c_c_eReferenceIsNonContainment, this, null, diagnostics, context, message_0, MetamodelTables.INT_4, CAUGHT_status, MetamodelTables.INT_0).booleanValue();
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
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE__VALUE:
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
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends C>)newValue);
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
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE__VALUE:
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
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE__VALUE:
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
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE___EREFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP_4:
				return eReferenceIsNonContainment((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //NonContainmentReferenceImpl
