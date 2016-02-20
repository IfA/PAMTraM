/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.MetamodelTables;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.ReferenceImpl#getEReference <em>EReference</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.ReferenceImpl#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ReferenceImpl<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends MetaModelElementImpl<S, C, R, A> implements Reference<S, C, R, A> {
	/**
	 * The cached value of the '{@link #getEReference() <em>EReference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReference()
	 * @generated
	 * @ordered
	 */
	protected EReference eReference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEReference() {
		if (eReference != null && eReference.eIsProxy()) {
			InternalEObject oldEReference = (InternalEObject)eReference;
			eReference = (EReference)eResolveProxy(oldEReference);
			if (eReference != oldEReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.REFERENCE__EREFERENCE, oldEReference, eReference));
			}
		}
		return eReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetEReference() {
		return eReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReferenceGen(EReference newEReference) {
		EReference oldEReference = eReference;
		eReference = newEReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.REFERENCE__EREFERENCE, oldEReference, eReference));
	}
	
	/**
	 * Before setting the {@link newEReference}, update the name.
	 */
	@Override
	public void setEReference(EReference newEReference) {
		setNameDerived(eReference, newEReference, null, null);
		setEReferenceGen(newEReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public C getOwningClass() {
		if (eContainerFeatureID() != MetamodelPackage.REFERENCE__OWNING_CLASS) return null;
		return (C)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eReferenceMatchesParentEClass(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv eReferenceMatchesParentEClass:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = if
		 *         self.isLibraryEntry() or
		 *         self.eReference.oclType() = OclVoid
		 *       then true
		 *       else
		 *         let
		 *           parentEClass : ecore::EClass[1] = self.oclContainer()
		 *           .oclAsType(Class(S, C, R, A)).eClass
		 *         in
		 *           if parentEClass.oclType() = OclVoid
		 *           then true
		 *           else
		 *             parentEClass.oclAsType(ecore::EClass)
		 *             .eAllReferences->includes(self.eReference)
		 *           endif
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The eReference \'' + self.eReference.name + '\' is not allowed by the containing Class!'
		 *         else null
		 *         endif
		 *       in
		 *         'Reference::eReferenceMatchesParentEClass'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_isLibraryEntry;
		    try {
		        final /*@Thrown*/ boolean isLibraryEntry = ((MetaModelElement)this).isLibraryEntry();
		        CAUGHT_isLibraryEntry = isLibraryEntry;
		    }
		    catch (Exception e) {
		        CAUGHT_isLibraryEntry = ValueUtil.createInvalidValue(e);
		    }
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		        final /*@NonNull*/ /*@Thrown*/ EReference eReference = this.getEReference();
		        final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, eReference));
		        final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValueUtil.createInvalidValue(e);
		    }
		    final /*@Nullable*/ /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_isLibraryEntry, CAUGHT_eq);
		    if (or == null) {
		        throw new InvalidValueException("Null if condition");
		    }
		    /*@Thrown*/ boolean status;
		    if (or) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e_0 = idResolver.getClass(MetamodelTables.CLSSid_Class, null);
		        final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, this);
		        final /*@NonNull*/ /*@Thrown*/ pamtram.metamodel.Class oclAsType = ClassUtil.nonNullState((pamtram.metamodel.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e_0));
		        final /*@NonNull*/ /*@Thrown*/ EClass parentEClass = oclAsType.getEClass();
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_1 = idResolver.getClass(TypeId.OCL_VOID, null);
		        final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType_0 = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, parentEClass));
		        final /*@Thrown*/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_1.getTypeId();
		        /*@Thrown*/ boolean symbol_0;
		        if (eq_0) {
		            symbol_0 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_ecore_c_c_EClass_0 = idResolver.getClass(MetamodelTables.CLSSid_EClass, null);
		            final /*@NonNull*/ /*@Thrown*/ EClass oclAsType_0 = ClassUtil.nonNullState((EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, parentEClass, TYP_ecore_c_c_EClass_0));
		            @SuppressWarnings("null")
		            final /*@NonNull*/ /*@Thrown*/ List<EReference> eAllReferences = oclAsType_0.getEAllReferences();
		            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_eAllReferences = idResolver.createOrderedSetOfAll(MetamodelTables.ORD_CLSSid_EReference, eAllReferences);
		            final /*@NonNull*/ /*@Thrown*/ EReference eReference_0 = this.getEReference();
		            final /*@Thrown*/ boolean includes = ClassUtil.nonNullState(CollectionIncludesOperation.INSTANCE.evaluate(BOXED_eAllReferences, eReference_0).booleanValue());
		            symbol_0 = includes;
		        }
		        status = symbol_0;
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
		    final /*@NonNull*/ /*@Thrown*/ EReference eReference_1 = this.getEReference();
		    final /*@Nullable*/ /*@Thrown*/ String name = eReference_1.getName();
		    final /*@NonNull*/ /*@NonInvalid*/ String sum = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(MetamodelTables.STR_The_32_eReference_32_39, name));
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_0 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum, MetamodelTables.STR__39_32_is_32_not_32_allowed_32_by_32_the_32_containing_32_Class_33));
		    message_0 = sum_0;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MetamodelTables.STR_Reference_c_c_eReferenceMatchesParentEClass, this, null, diagnostics, context, message_0, MetamodelTables.INT_4, CAUGHT_status, MetamodelTables.INT_0).booleanValue());
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.REFERENCE__OWNING_CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, MetamodelPackage.REFERENCE__OWNING_CLASS, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.REFERENCE__OWNING_CLASS:
				return eBasicSetContainer(null, MetamodelPackage.REFERENCE__OWNING_CLASS, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MetamodelPackage.REFERENCE__OWNING_CLASS:
				return eInternalContainer().eInverseRemove(this, MetamodelPackage.CLASS__REFERENCES, pamtram.metamodel.Class.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.REFERENCE__EREFERENCE:
				if (resolve) return getEReference();
				return basicGetEReference();
			case MetamodelPackage.REFERENCE__OWNING_CLASS:
				return getOwningClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetamodelPackage.REFERENCE__EREFERENCE:
				setEReference((EReference)newValue);
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
			case MetamodelPackage.REFERENCE__EREFERENCE:
				setEReference((EReference)null);
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
			case MetamodelPackage.REFERENCE__EREFERENCE:
				return eReference != null;
			case MetamodelPackage.REFERENCE__OWNING_CLASS:
				return getOwningClass() != null;
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
			case MetamodelPackage.REFERENCE___EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP:
				return eReferenceMatchesParentEClass((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ReferenceImpl
