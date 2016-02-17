/**
 */
package pamtram.mapping.impl;

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
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingTables;
import pamtram.mapping.Matcher;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.Section;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionNonContainmentReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.MappingInstanceSelectorImpl#getAffectedReference <em>Affected Reference</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingInstanceSelectorImpl#getMatcher <em>Matcher</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingInstanceSelectorImpl extends MappingHintImpl implements MappingInstanceSelector {
	/**
	 * The cached value of the '{@link #getAffectedReference() <em>Affected Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffectedReference()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionNonContainmentReference affectedReference;

	/**
	 * The cached value of the '{@link #getMatcher() <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatcher()
	 * @generated
	 * @ordered
	 */
	protected Matcher matcher;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingInstanceSelectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPING_INSTANCE_SELECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSectionNonContainmentReference getAffectedReference() {
		if (affectedReference != null && affectedReference.eIsProxy()) {
			InternalEObject oldAffectedReference = (InternalEObject)affectedReference;
			affectedReference = (TargetSectionNonContainmentReference)eResolveProxy(oldAffectedReference);
			if (affectedReference != oldAffectedReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE, oldAffectedReference, affectedReference));
			}
		}
		return affectedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionNonContainmentReference basicGetAffectedReference() {
		return affectedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAffectedReferenceGen(TargetSectionNonContainmentReference newAffectedReference) {
		TargetSectionNonContainmentReference oldAffectedReference = affectedReference;
		affectedReference = newAffectedReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE, oldAffectedReference, affectedReference));
	}
	
	/**
	 * Before setting the {@link newAffectedReference}, update the name
	 */
	@Override
	public void setAffectedReference(TargetSectionNonContainmentReference newAffectedReference) {
		setNameDerived(affectedReference, newAffectedReference, null, null);
		setAffectedReferenceGen(newAffectedReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Matcher getMatcher() {
		return matcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatcher(Matcher newMatcher, NotificationChain msgs) {
		Matcher oldMatcher = matcher;
		matcher = newMatcher;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER, oldMatcher, newMatcher);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMatcher(Matcher newMatcher) {
		if (newMatcher != matcher) {
			NotificationChain msgs = null;
			if (matcher != null)
				msgs = ((InternalEObject)matcher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER, null, msgs);
			if (newMatcher != null)
				msgs = ((InternalEObject)newMatcher).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER, null, msgs);
			msgs = basicSetMatcher(newMatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER, newMatcher, newMatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean affectedReferenceMatchesSection(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv affectedReferenceMatchesSection:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[?] = if self.affectedReference.oclType() = OclVoid
		 *       then true
		 *       else
		 *         let
		 *           targetMMSection : metamodel::TargetSection[1] = if
		 *             self.oclContainer()
		 *             .oclIsKindOf(MappingHintGroupType)
		 *           then
		 *             self.oclContainer()
		 *             .oclAsType(MappingHintGroupType).targetMMSection
		 *           else
		 *             self.oclContainer()
		 *             .oclAsType(MappingHintGroupImporter).hintGroup.targetMMSection
		 *           endif
		 *         in
		 *           if targetMMSection.oclType() = OclVoid
		 *           then true
		 *           else
		 *             self.affectedReference.getContainingSection() = targetMMSection or
		 *             targetMMSection.oclAsType(metamodel::Section(S, C, R, A))
		 *             .extend->includes(self.affectedReference.getContainingSection())
		 *           endif
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then
		 *           let
		 *             hintGroupName : String[?] = if
		 *               self.oclContainer()
		 *               .oclIsKindOf(MappingHintGroupType)
		 *             then
		 *               self.oclContainer()
		 *               .oclAsType(MappingHintGroupType).name
		 *             else
		 *               self.oclContainer()
		 *               .oclAsType(MappingHintGroupImporter).hintGroup.name
		 *             endif
		 *           in 'The affected reference \'' + self.affectedReference.name + '\' is not part of the target section referenced by parent hint group \'' + hintGroupName + '\'!'
		 *         else null
		 *         endif
		 *       in
		 *         'MappingInstanceSelector::affectedReferenceMatchesSection'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@Nullable*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		    final /*@NonNull*/ /*@Thrown*/ TargetSectionNonContainmentReference affectedReference = this.getAffectedReference();
		    final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, affectedReference));
		    final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		    /*@Nullable*/ /*@Thrown*/ Boolean status;
		    if (eq) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        /*@NonNull*/ /*@Caught*/ Object CAUGHT_targetMMSection_1;
		        try {
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0 = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupType, null);
		            final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, this);
		            final /*@Thrown*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0).booleanValue());
		            /*@NonNull*/ /*@Thrown*/ TargetSection targetMMSection_1;
		            if (oclIsKindOf) {
		                final /*@NonNull*/ /*@Thrown*/ MappingHintGroupType oclAsType = ClassUtil.nonNullState((MappingHintGroupType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0));
		                final /*@NonNull*/ /*@Thrown*/ TargetSection targetMMSection = oclAsType.getTargetMMSection();
		                targetMMSection_1 = targetMMSection;
		            }
		            else {
		                final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupImporter = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupImporter, null);
		                final /*@NonNull*/ /*@Thrown*/ MappingHintGroupImporter oclAsType_0 = ClassUtil.nonNullState((MappingHintGroupImporter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupImporter));
		                final /*@NonNull*/ /*@Thrown*/ ExportedMappingHintGroup hintGroup = oclAsType_0.getHintGroup();
		                final /*@NonNull*/ /*@Thrown*/ TargetSection targetMMSection_0 = hintGroup.getTargetMMSection();
		                targetMMSection_1 = targetMMSection_0;
		            }
		            CAUGHT_targetMMSection_1 = targetMMSection_1;
		        }
		        catch (Exception e) {
		            CAUGHT_targetMMSection_1 = ValueUtil.createInvalidValue(e);
		        }
		        if (CAUGHT_targetMMSection_1 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_targetMMSection_1;
		        }
		        final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType_0 = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, CAUGHT_targetMMSection_1));
		        final /*@Thrown*/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_0.getTypeId();
		        /*@Nullable*/ /*@Thrown*/ Boolean symbol_0;
		        if (eq_0) {
		            symbol_0 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq_1;
		            try {
		                final /*@NonNull*/ /*@Thrown*/ Object getContainingSection = ((MetaModelElement)affectedReference).getContainingSection();
		                final /*@Thrown*/ boolean eq_1 = getContainingSection.equals(CAUGHT_targetMMSection_1);
		                CAUGHT_eq_1 = eq_1;
		            }
		            catch (Exception e) {
		                CAUGHT_eq_1 = ValueUtil.createInvalidValue(e);
		            }
		            /*@NonNull*/ /*@Caught*/ Object CAUGHT_includes;
		            try {
		                final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_0 = idResolver.getClass(MappingTables.CLSSid_Section, null);
		                final /*@NonNull*/ /*@Thrown*/ Section oclAsType_1 = ClassUtil.nonNullState((Section)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CAUGHT_targetMMSection_1, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_0));
		                final /*@NonNull*/ /*@Thrown*/ List<? extends Object> extend = oclAsType_1.getExtend();
		                final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_extend = idResolver.createOrderedSetOfAll(MappingTables.ORD_TMPLid_, extend);
		                final /*@NonNull*/ /*@Thrown*/ Object getContainingSection_0 = ((MetaModelElement)affectedReference).getContainingSection();
		                final /*@Thrown*/ boolean includes = ClassUtil.nonNullState(CollectionIncludesOperation.INSTANCE.evaluate(BOXED_extend, getContainingSection_0).booleanValue());
		                CAUGHT_includes = includes;
		            }
		            catch (Exception e) {
		                CAUGHT_includes = ValueUtil.createInvalidValue(e);
		            }
		            final /*@Nullable*/ /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq_1, CAUGHT_includes);
		            symbol_0 = or;
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
		    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_2 = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupType, null);
		    final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer_2 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, this);
		    final /*@Thrown*/ boolean oclIsKindOf_0 = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, oclContainer_2, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_2).booleanValue());
		    /*@Nullable*/ /*@Thrown*/ String hintGroupName;
		    if (oclIsKindOf_0) {
		        final /*@NonNull*/ /*@Thrown*/ MappingHintGroupType oclAsType_2 = ClassUtil.nonNullState((MappingHintGroupType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer_2, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_2));
		        final /*@Nullable*/ /*@Thrown*/ String name = oclAsType_2.getName();
		        hintGroupName = name;
		    }
		    else {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupImporter_0 = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupImporter, null);
		        final /*@NonNull*/ /*@Thrown*/ MappingHintGroupImporter oclAsType_3 = ClassUtil.nonNullState((MappingHintGroupImporter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer_2, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupImporter_0));
		        final /*@NonNull*/ /*@Thrown*/ ExportedMappingHintGroup hintGroup_0 = oclAsType_3.getHintGroup();
		        final /*@Nullable*/ /*@Thrown*/ String name_0 = hintGroup_0.getName();
		        hintGroupName = name_0;
		    }
		    final /*@NonNull*/ /*@Thrown*/ TargetSectionNonContainmentReference affectedReference_2 = this.getAffectedReference();
		    final /*@Nullable*/ /*@Thrown*/ String name_1 = affectedReference_2.getName();
		    final /*@NonNull*/ /*@NonInvalid*/ String sum = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(MappingTables.STR_The_32_affected_32_reference_32_39, name_1));
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_0 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum, MappingTables.STR__39_32_is_32_not_32_part_32_of_32_the_32_target_32_section_32_referenced_32_by_32_parent_32_hint_32_gr_0));
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_1 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum_0, hintGroupName));
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_2 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum_1, MappingTables.STR__39_33));
		    message_0 = sum_2;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MappingTables.STR_MappingInstanceSelector_c_c_affectedReferenceMatchesSection, this, null, diagnostics, context, message_0, MappingTables.INT_4, CAUGHT_status, MappingTables.INT_0).booleanValue());
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean affectedReferenceIsNonContainment(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv affectedReferenceIsNonContainment:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[?] = if self.affectedReference.oclType() = OclVoid
		 *       then true
		 *       else
		 *         not self.affectedReference.eReference.oclAsType(ecore::EReference).containment
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The affected reference \' + self.affectedReference.name + \' is no non-containment reference!'
		 *         else null
		 *         endif
		 *       in
		 *         'MappingInstanceSelector::affectedReferenceIsNonContainment'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@Nullable*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		    final /*@NonNull*/ /*@Thrown*/ TargetSectionNonContainmentReference affectedReference = this.getAffectedReference();
		    final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, affectedReference));
		    final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		    /*@Nullable*/ /*@Thrown*/ Boolean status;
		    if (eq) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_ecore_c_c_EReference = idResolver.getClass(MappingTables.CLSSid_EReference, null);
		        final /*@NonNull*/ /*@Thrown*/ EReference eReference = affectedReference.getEReference();
		        final /*@NonNull*/ /*@Thrown*/ EReference oclAsType = ClassUtil.nonNullState((EReference)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, eReference, TYP_ecore_c_c_EReference));
		        final /*@Nullable*/ /*@Thrown*/ Boolean containment = oclAsType.isContainment();
		        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(containment);
		        status = not;
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
		    message_0 = MappingTables.STR_The_32_affected_32_reference_32_39_32_p_32_self_affectedReference_name_32_p_32_39_32_is_32_no;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MappingTables.STR_MappingInstanceSelector_c_c_affectedReferenceIsNonContainment, this, null, diagnostics, context, message_0, MappingTables.INT_4, CAUGHT_status, MappingTables.INT_0).booleanValue());
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
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER:
				return basicSetMatcher(null, msgs);
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
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE:
				if (resolve) return getAffectedReference();
				return basicGetAffectedReference();
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER:
				return getMatcher();
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
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE:
				setAffectedReference((TargetSectionNonContainmentReference)newValue);
				return;
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER:
				setMatcher((Matcher)newValue);
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
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE:
				setAffectedReference((TargetSectionNonContainmentReference)null);
				return;
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER:
				setMatcher((Matcher)null);
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
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE:
				return affectedReference != null;
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER:
				return matcher != null;
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
			case MappingPackage.MAPPING_INSTANCE_SELECTOR___AFFECTED_REFERENCE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP_5:
				return affectedReferenceMatchesSection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MappingPackage.MAPPING_INSTANCE_SELECTOR___AFFECTED_REFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP_5:
				return affectedReferenceIsNonContainment((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //MappingInstanceSelectorImpl
