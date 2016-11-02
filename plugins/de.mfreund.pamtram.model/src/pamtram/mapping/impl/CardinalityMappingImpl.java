/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.EnumerationLiteralId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingTables;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cardinality Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.CardinalityMappingImpl#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.impl.CardinalityMappingImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CardinalityMappingImpl extends MappingHintImpl implements CardinalityMapping {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected SourceSectionClass source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionClass target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CardinalityMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.CARDINALITY_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (SourceSectionClass)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.CARDINALITY_MAPPING__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(SourceSectionClass newSource) {
		SourceSectionClass oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.CARDINALITY_MAPPING__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (TargetSectionClass)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.CARDINALITY_MAPPING__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(TargetSectionClass newTarget) {
		TargetSectionClass oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.CARDINALITY_MAPPING__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean noCardinalityMappingForSourceSectionRoot(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv noCardinalityMappingForSourceSectionRoot:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = if self.source.oclType() = OclVoid
		 *       then true
		 *       else self.source <> self.source.getContainingSection()
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'Cardinality mappings must not be defined for SourceSection root classes!'
		 *         else null
		 *         endif
		 *       in
		 *         'CardinalityMapping::noCardinalityMappingForSourceSectionRoot'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ /*@NonNull*/ Object CAUGHT_status;
		try {
		    final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		    final /*@Thrown*/ SourceSectionClass source_0 = this.getSource();
		    final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, source_0);
		    final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		    /*@Thrown*/ boolean status;
		    if (eq) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        final /*@Thrown*/ Object getContainingSection = ((MetaModelElement)source_0).getContainingSection();
		        final /*@Thrown*/ boolean ne = !source_0.equals(getContainingSection);
		        status = ne;
		    }
		    CAUGHT_status = status;
		}
		catch (Exception e) {
		    CAUGHT_status = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_status instanceof InvalidValueException) {
		    throw (InvalidValueException)CAUGHT_status;
		}
		final /*@Thrown*/ boolean ne_0 = CAUGHT_status == Boolean.FALSE;
		/*@NonInvalid*/ String message_0;
		if (ne_0) {
		    message_0 = MappingTables.STR_Cardinality_32_mappings_32_must_32_not_32_be_32_defined_32_for_32_SourceSection_32_root_32;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, MappingTables.STR_CardinalityMapping_c_c_noCardinalityMappingForSourceSectionRoot, this, null, diagnostics, context, message_0, MappingTables.INT_4, CAUGHT_status, MappingTables.INT_0).booleanValue();
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sourceClassMatchesSection(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv sourceClassMatchesSection:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = if
		 *         self.source.oclType() = OclVoid or
		 *         self.oclContainer()
		 *         .oclContainer()
		 *         .oclAsType(Mapping)
		 *         .sourceSection.oclType() = OclVoid
		 *       then true
		 *       else
		 *         self.source.getContainingSection() =
		 *         self.oclContainer()
		 *         .oclContainer()
		 *         .oclAsType(Mapping).sourceSection
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The source class \'' + self.source.name + '\' is not part of the source section referenced by parent mapping \'' +
		 *           self.oclContainer()
		 *           .oclContainer()
		 *           .oclAsType(Mapping).name + '\'!'
		 *         else null
		 *         endif
		 *       in
		 *         'CardinalityMapping::sourceClassMatchesSection'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ /*@NonNull*/ Object CAUGHT_status;
		try {
		    /*@Caught*/ /*@NonNull*/ Object CAUGHT_eq;
		    try {
		        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		        final /*@Thrown*/ SourceSectionClass source = this.getSource();
		        final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, source);
		        final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValueUtil.createInvalidValue(e);
		    }
		    /*@Caught*/ /*@NonNull*/ Object CAUGHT_eq_0;
		    try {
		        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_1 = idResolver.getClass(TypeId.OCL_VOID, null);
		        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_Mapping = idResolver.getClass(MappingTables.CLSSid_Mapping, null);
		        final /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
		        final /*@Thrown*/ Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, oclContainer);
		        final /*@Thrown*/ Mapping oclAsType = ClassUtil.nonNullState((Mapping)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer_0, TYP_pamtram_c_c_mapping_c_c_Mapping));
		        final /*@Thrown*/ SourceSection sourceSection = oclAsType.getSourceSection();
		        final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType_0 = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, sourceSection);
		        final /*@Thrown*/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_1.getTypeId();
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		    }
		    final /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    if (or == null) {
		        throw new InvalidValueException("Null if condition");
		    }
		    /*@Thrown*/ boolean status;
		    if (or) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_Mapping_0 = idResolver.getClass(MappingTables.CLSSid_Mapping, null);
		        final /*@Thrown*/ SourceSectionClass source_0 = this.getSource();
		        final /*@Thrown*/ Object getContainingSection = ((MetaModelElement)source_0).getContainingSection();
		        final /*@NonInvalid*/ Object oclContainer_1 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
		        final /*@Thrown*/ Object oclContainer_2 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, oclContainer_1);
		        final /*@Thrown*/ Mapping oclAsType_0 = ClassUtil.nonNullState((Mapping)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer_2, TYP_pamtram_c_c_mapping_c_c_Mapping_0));
		        final /*@Thrown*/ SourceSection sourceSection_0 = oclAsType_0.getSourceSection();
		        final /*@Thrown*/ boolean eq_1 = getContainingSection.equals(sourceSection_0);
		        status = eq_1;
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
		    final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_Mapping_1 = idResolver.getClass(MappingTables.CLSSid_Mapping, null);
		    final /*@Thrown*/ SourceSectionClass source_1 = this.getSource();
		    final /*@Thrown*/ String name = source_1.getName();
		    final /*@NonInvalid*/ String sum = StringConcatOperation.INSTANCE.evaluate(MappingTables.STR_The_32_source_32_class_32_39, name);
		    final /*@NonInvalid*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, MappingTables.STR__39_32_is_32_not_32_part_32_of_32_the_32_source_32_section_32_referenced_32_by_32_parent_32_mapping);
		    final /*@NonInvalid*/ Object oclContainer_3 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
		    final /*@Thrown*/ Object oclContainer_4 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, oclContainer_3);
		    final /*@Thrown*/ Mapping oclAsType_1 = ClassUtil.nonNullState((Mapping)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer_4, TYP_pamtram_c_c_mapping_c_c_Mapping_1));
		    final /*@Thrown*/ String name_0 = oclAsType_1.getName();
		    final /*@NonInvalid*/ String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, name_0);
		    final /*@NonInvalid*/ String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, MappingTables.STR__39_33);
		    message_0 = sum_2;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, MappingTables.STR_CardinalityMapping_c_c_sourceClassMatchesSection, this, null, diagnostics, context, message_0, MappingTables.INT_4, CAUGHT_status, MappingTables.INT_0).booleanValue();
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean targetClassMatchesSection(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv targetClassMatchesSection:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = if
		 *         self.target.oclType() = OclVoid or
		 *         self.oclContainer()
		 *         .oclAsType(MappingHintGroupType)
		 *         .targetSection.oclType() = OclVoid
		 *       then true
		 *       else
		 *         self.target.getContainingSection() =
		 *         self.oclContainer()
		 *         .oclAsType(MappingHintGroupType).targetSection
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The target class \'' + self.target.name + '\' is not part of the target section referenced by parent hint group \'' +
		 *           self.oclContainer()
		 *           .oclAsType(MappingHintGroupType).name + '\'!'
		 *         else null
		 *         endif
		 *       in
		 *         'CardinalityMapping::targetClassMatchesSection'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ /*@NonNull*/ Object CAUGHT_status;
		try {
		    /*@Caught*/ /*@NonNull*/ Object CAUGHT_eq;
		    try {
		        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		        final /*@Thrown*/ TargetSectionClass target = this.getTarget();
		        final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, target);
		        final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValueUtil.createInvalidValue(e);
		    }
		    /*@Caught*/ /*@NonNull*/ Object CAUGHT_eq_0;
		    try {
		        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_1 = idResolver.getClass(TypeId.OCL_VOID, null);
		        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0 = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupType, null);
		        final /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
		        final /*@Thrown*/ MappingHintGroupType oclAsType = ClassUtil.nonNullState((MappingHintGroupType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0));
		        final /*@Thrown*/ TargetSection targetSection = oclAsType.getTargetSection();
		        final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType_0 = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, targetSection);
		        final /*@Thrown*/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_1.getTypeId();
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		    }
		    final /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    if (or == null) {
		        throw new InvalidValueException("Null if condition");
		    }
		    /*@Thrown*/ boolean status;
		    if (or) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_1 = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupType, null);
		        final /*@Thrown*/ TargetSectionClass target_0 = this.getTarget();
		        final /*@Thrown*/ Object getContainingSection = ((MetaModelElement)target_0).getContainingSection();
		        final /*@NonInvalid*/ Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
		        final /*@Thrown*/ MappingHintGroupType oclAsType_0 = ClassUtil.nonNullState((MappingHintGroupType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer_0, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_1));
		        final /*@Thrown*/ TargetSection targetSection_0 = oclAsType_0.getTargetSection();
		        final /*@Thrown*/ boolean eq_1 = getContainingSection.equals(targetSection_0);
		        status = eq_1;
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
		    final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_2 = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupType, null);
		    final /*@Thrown*/ TargetSectionClass target_1 = this.getTarget();
		    final /*@Thrown*/ String name = target_1.getName();
		    final /*@NonInvalid*/ String sum = StringConcatOperation.INSTANCE.evaluate(MappingTables.STR_The_32_target_32_class_32_39, name);
		    final /*@NonInvalid*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, MappingTables.STR__39_32_is_32_not_32_part_32_of_32_the_32_target_32_section_32_referenced_32_by_32_parent_32_hint_32_gr_0);
		    final /*@NonInvalid*/ Object oclContainer_1 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
		    final /*@Thrown*/ MappingHintGroupType oclAsType_1 = ClassUtil.nonNullState((MappingHintGroupType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer_1, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_2));
		    final /*@Thrown*/ String name_0 = oclAsType_1.getName();
		    final /*@NonInvalid*/ String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, name_0);
		    final /*@NonInvalid*/ String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, MappingTables.STR__39_33);
		    message_0 = sum_2;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, MappingTables.STR_CardinalityMapping_c_c_targetClassMatchesSection, this, null, diagnostics, context, message_0, MappingTables.INT_4, CAUGHT_status, MappingTables.INT_0).booleanValue();
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean targetClassIsVariableCardinality(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv targetClassIsVariableCardinality:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = if self.target.oclType() = OclVoid
		 *       then true
		 *       else self.target.cardinality <> metamodel::CardinalityType::ONE
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'Cardinality mappings may only be defined for target classes with a specified cardinality distinct from \'CardinalityType::ONE\'!'
		 *         else null
		 *         endif
		 *       in
		 *         'CardinalityMapping::targetClassIsVariableCardinality'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ /*@NonNull*/ Object CAUGHT_status;
		try {
		    final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		    final /*@Thrown*/ TargetSectionClass target = this.getTarget();
		    final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, target);
		    final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		    /*@Thrown*/ boolean status;
		    if (eq) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        final /*@Thrown*/ CardinalityType cardinality = target.getCardinality();
		        final /*@Thrown*/ EnumerationLiteralId BOXED_cardinality = MappingTables.ENUMid_CardinalityType.getEnumerationLiteralId(ClassUtil.nonNullState(cardinality.getName()));
		        final /*@Thrown*/ boolean ne = BOXED_cardinality != MappingTables.ELITid_ONE;
		        status = ne;
		    }
		    CAUGHT_status = status;
		}
		catch (Exception e) {
		    CAUGHT_status = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_status instanceof InvalidValueException) {
		    throw (InvalidValueException)CAUGHT_status;
		}
		final /*@Thrown*/ boolean ne_0 = CAUGHT_status == Boolean.FALSE;
		/*@NonInvalid*/ String message_0;
		if (ne_0) {
		    message_0 = MappingTables.STR_Cardinality_32_mappings_32_may_32_only_32_be_32_defined_32_for_32_target_32_classes_32_with;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, MappingTables.STR_CardinalityMapping_c_c_targetClassIsVariableCardinality, this, null, diagnostics, context, message_0, MappingTables.INT_4, CAUGHT_status, MappingTables.INT_0).booleanValue();
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sourceClassIsVariableCardinality(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv sourceClassIsVariableCardinality:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = if self.source.oclType() = OclVoid
		 *       then true
		 *       else self.source.cardinality <> metamodel::CardinalityType::ONE
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'Cardinality mappings may only be defined for source classes with a specified cardinality distinct from \'CardinalityType::ONE\'!'
		 *         else null
		 *         endif
		 *       in
		 *         'CardinalityMapping::sourceClassIsVariableCardinality'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ /*@NonNull*/ Object CAUGHT_status;
		try {
		    final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		    final /*@Thrown*/ SourceSectionClass source = this.getSource();
		    final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, source);
		    final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		    /*@Thrown*/ boolean status;
		    if (eq) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        final /*@Thrown*/ CardinalityType cardinality = source.getCardinality();
		        final /*@Thrown*/ EnumerationLiteralId BOXED_cardinality = MappingTables.ENUMid_CardinalityType.getEnumerationLiteralId(ClassUtil.nonNullState(cardinality.getName()));
		        final /*@Thrown*/ boolean ne = BOXED_cardinality != MappingTables.ELITid_ONE;
		        status = ne;
		    }
		    CAUGHT_status = status;
		}
		catch (Exception e) {
		    CAUGHT_status = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_status instanceof InvalidValueException) {
		    throw (InvalidValueException)CAUGHT_status;
		}
		final /*@Thrown*/ boolean ne_0 = CAUGHT_status == Boolean.FALSE;
		/*@NonInvalid*/ String message_0;
		if (ne_0) {
		    message_0 = MappingTables.STR_Cardinality_32_mappings_32_may_32_only_32_be_32_defined_32_for_32_source_32_classes_32_with;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, MappingTables.STR_CardinalityMapping_c_c_sourceClassIsVariableCardinality, this, null, diagnostics, context, message_0, MappingTables.INT_4, CAUGHT_status, MappingTables.INT_0).booleanValue();
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
			case MappingPackage.CARDINALITY_MAPPING__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case MappingPackage.CARDINALITY_MAPPING__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case MappingPackage.CARDINALITY_MAPPING__SOURCE:
				setSource((SourceSectionClass)newValue);
				return;
			case MappingPackage.CARDINALITY_MAPPING__TARGET:
				setTarget((TargetSectionClass)newValue);
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
			case MappingPackage.CARDINALITY_MAPPING__SOURCE:
				setSource((SourceSectionClass)null);
				return;
			case MappingPackage.CARDINALITY_MAPPING__TARGET:
				setTarget((TargetSectionClass)null);
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
			case MappingPackage.CARDINALITY_MAPPING__SOURCE:
				return source != null;
			case MappingPackage.CARDINALITY_MAPPING__TARGET:
				return target != null;
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
			case MappingPackage.CARDINALITY_MAPPING___NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT__DIAGNOSTICCHAIN_MAP:
				return noCardinalityMappingForSourceSectionRoot((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MappingPackage.CARDINALITY_MAPPING___SOURCE_CLASS_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP:
				return sourceClassMatchesSection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MappingPackage.CARDINALITY_MAPPING___TARGET_CLASS_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP:
				return targetClassMatchesSection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MappingPackage.CARDINALITY_MAPPING___TARGET_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP:
				return targetClassIsVariableCardinality((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MappingPackage.CARDINALITY_MAPPING___SOURCE_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP:
				return sourceClassIsVariableCardinality((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //CardinalityMappingImpl
