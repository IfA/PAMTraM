/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SetValue;

import pamtram.mapping.MappingType;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.MetamodelTables;
import pamtram.metamodel.Section;
import pamtram.metamodel.SourceSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.SourceSectionImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SourceSectionImpl#getExtend <em>Extend</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SourceSectionImpl#getReferencingMappings <em>Referencing Mappings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SourceSectionImpl extends SourceSectionClassImpl implements SourceSection {
	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;
	/**
	 * The cached value of the '{@link #getExtend() <em>Extend</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtend()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceSection> extend;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.SOURCE_SECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SOURCE_SECTION__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSection> getExtend() {
		if (extend == null) {
			extend = new EObjectResolvingEList<SourceSection>(SourceSection.class, this, MetamodelPackage.SOURCE_SECTION__EXTEND);
		}
		return extend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<MappingType> getReferencingMappings() {
		/**
		 * mapping::MappingType.allInstances()->select(m | self = m.sourceMMSection)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingType_0 = idResolver.getClass(MetamodelTables.CLSSid_MappingType, null);
		final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, MetamodelTables.SET_CLSSid_MappingType, TYP_pamtram_c_c_mapping_c_c_MappingType_0));
		/*@NonNull*/ /*@Thrown*/ SetValue.Accumulator accumulator = ValueUtil.createSetAccumulatorValue(MetamodelTables.SET_CLSSid_MappingType);
		/*@NonNull*/ Iterator<?> ITERATOR_m = allInstances.iterator();
		/*@NonNull*/ /*@Thrown*/ SetValue select;
		while (true) {
			if (!ITERATOR_m.hasNext()) {
				select = accumulator;
				break;
			}
			/*@NonNull*/ /*@NonInvalid*/ MappingType m = (MappingType)ITERATOR_m.next();
			/**
			 * self = m.sourceMMSection
			 */
			final /*@NonNull*/ /*@Thrown*/ SourceSection sourceMMSection = m.getSourceMMSection();
			final /*@Thrown*/ boolean eq = this.equals(sourceMMSection);
			//
			if (eq == ValueUtil.TRUE_VALUE) {
				accumulator.add(m);
			}
		}
		final List<MappingType> UNBOXED_select = select.asEcoreObjects(idResolver, pamtram.mapping.MappingType.class);
		assert UNBOXED_select != null;
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=474307
		return new EcoreEList.UnmodifiableEList.FastCompare<> 
		(this, MetamodelPackage.Literals.SOURCE_SECTION__REFERENCING_MAPPINGS, UNBOXED_select.size(), UNBOXED_select.toArray()); 
		//		return (EList<MappingType>)UNBOXED_select;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isReferencedByMapping(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv isReferencedByMapping:
		 *   let severity : Integer[1] = 2
		 *   in
		 *     let status : OclAny[1] = self.referencingMappings->size() > 0
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The section is not referenced by any mapping!'
		 *         else null
		 *         endif
		 *       in
		 *         'SourceSection::isReferencedByMapping'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@NonNull*/ /*@Thrown*/ List<MappingType> referencingMappings = this.getReferencingMappings();
		    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_referencingMappings = idResolver.createOrderedSetOfAll(MetamodelTables.ORD_CLSSid_MappingType, referencingMappings);
		    final /*@NonNull*/ /*@Thrown*/ IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_referencingMappings));
		    final /*@Thrown*/ boolean status = ClassUtil.nonNullState(OclComparableGreaterThanOperation.INSTANCE.evaluate(evaluator, size, MetamodelTables.INT_0).booleanValue());
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
		    message_0 = MetamodelTables.STR_The_32_section_32_is_32_not_32_referenced_32_by_32_any_32_mapping_33;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MetamodelTables.STR_SourceSection_c_c_isReferencedByMapping, this, null, diagnostics, context, message_0, MetamodelTables.INT_2, CAUGHT_status, MetamodelTables.INT_0).booleanValue());
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * This method is only necessary as OCL does not seem to get along with generic types (the same logic implemented
	 * in OCL lead to 'UnsupportedOperationException' errors when trying to use 'self.extend->...').
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean extendsOnlyValidSections() {
		if(this.getEClass() == null) {
			return true;
		}

		for (SourceSection extend : this.getExtend()) {
			if(!extend.isAbstract() || extend.getEClass() != null && !(this.getEClass() == extend.getEClass()) && !(this.getEClass().getEAllSuperTypes().contains(extend.getEClass()))) {
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
	@Override
	public boolean extendsValidSections(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv extendsValidSections:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let status : OclAny[?] = self.extendsOnlyValidSections()
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The section extends a section that is either not abstract or that references an EClass of a different (super-)type!'
		 *         else null
		 *         endif
		 *       in
		 *         'Section::extendsValidSections'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@Thrown*/ boolean status = this.extendsOnlyValidSections();
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
		    message_0 = MetamodelTables.STR_The_32_section_32_extends_32_a_32_section_32_that_32_is_32_either_32_not_32_abstract_32_or_32_tha;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MetamodelTables.STR_Section_c_c_extendsValidSections, this, null, diagnostics, context, message_0, MetamodelTables.INT_4, CAUGHT_status, MetamodelTables.INT_0).booleanValue());
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean containerMatchesExtendContainer(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv containerMatchesExtendContainer:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[?] = if
		 *         self.oclAsType(Class(S, C, R, A))
		 *         .container.oclType() = OclVoid
		 *       then true
		 *       else
		 *         self.extend->forAll(e |
		 *           e.oclAsType(Class(S, C, R, A))
		 *           .container.oclType() = OclVoid or
		 *           e.oclAsType(Class(S, C, R, A)).container =
		 *           self.oclAsType(Class(S, C, R, A)).container)
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The section extends a section that specifies a different container!'
		 *         else null
		 *         endif
		 *       in
		 *         'Section::containerMatchesExtendContainer'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@Nullable*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e = idResolver.getClass(MetamodelTables.CLSSid_Class, null);
		    final /*@NonNull*/ /*@Thrown*/ pamtram.metamodel.Class oclAsType = ClassUtil.nonNullState((pamtram.metamodel.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, this, TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e));
		    final /*@Nullable*/ /*@Thrown*/ Object container = oclAsType.getContainer();
		    final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, container));
		    final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		    /*@Nullable*/ /*@Thrown*/ Boolean status;
		    if (eq) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        final /*@NonNull*/ /*@Thrown*/ List<? extends Object> extend = this.getExtend();
		        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_extend = idResolver.createOrderedSetOfAll(MetamodelTables.ORD_TMPLid__1, extend);
		        /*@Nullable*/ /*@Thrown*/ Object accumulator = ValueUtil.TRUE_VALUE;
		        /*@Nullable*/ Iterator<?> ITERATOR_e_0 = BOXED_extend.iterator();
		        /*@Nullable*/ /*@Thrown*/ Boolean forAll;
		        while (true) {
		            if (!ITERATOR_e_0.hasNext()) {
		                if (accumulator == null) {
		                    forAll = null;
		                }
		                else if (accumulator == ValueUtil.TRUE_VALUE) {
		                    forAll = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    throw (InvalidValueException)accumulator;
		                }
		                break;
		            }
		            /*@Nullable*/ /*@NonInvalid*/ Object e_0 = (Object)ITERATOR_e_0.next();
		            /**
		             * 
		             * e.oclAsType(Class(S, C, R, A))
		             * .container.oclType() = OclVoid or
		             * e.oclAsType(Class(S, C, R, A)).container =
		             * self.oclAsType(Class(S, C, R, A)).container
		             */
		            /*@Nullable*/ /*@Caught*/ Object CAUGHT_or;
		            try {
		                /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq_0;
		                try {
		                    final /*@NonNull*/ /*@Thrown*/ pamtram.metamodel.Class oclAsType_0 = ClassUtil.nonNullState((pamtram.metamodel.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, e_0, TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e));
		                    final /*@Nullable*/ /*@Thrown*/ Object container_0 = oclAsType_0.getContainer();
		                    final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType_0 = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, container_0));
		                    final /*@Thrown*/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_0.getTypeId();
		                    CAUGHT_eq_0 = eq_0;
		                }
		                catch (Exception e) {
		                    CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		                }
		                /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq_1;
		                try {
		                    final /*@NonNull*/ /*@Thrown*/ pamtram.metamodel.Class oclAsType_1 = ClassUtil.nonNullState((pamtram.metamodel.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, e_0, TYP_pamtram_c_c_metamodel_c_c_Class_o_S_44_C_44_R_44_A_e));
		                    final /*@Nullable*/ /*@Thrown*/ Object container_1 = oclAsType_1.getContainer();
		                    final /*@Thrown*/ boolean eq_1 = (container_1 != null) ? container_1.equals(container) : (container == null);
		                    CAUGHT_eq_1 = eq_1;
		                }
		                catch (Exception e) {
		                    CAUGHT_eq_1 = ValueUtil.createInvalidValue(e);
		                }
		                final /*@Nullable*/ /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq_0, CAUGHT_eq_1);
		                CAUGHT_or = or;
		            }
		            catch (Exception e) {
		                CAUGHT_or = ValueUtil.createInvalidValue(e);
		            }
		            //
		            if (CAUGHT_or == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
		                forAll = ValueUtil.FALSE_VALUE;
		                break;														// Stop immediately 
		            }
		            else if (CAUGHT_or == ValueUtil.TRUE_VALUE) {				// Normal successful body evaluation result
		                ;															// Carry on
		            }
		            else if (CAUGHT_or == null) {								// Abnormal null body evaluation result
		                if (accumulator == ValueUtil.TRUE_VALUE) {
		                    accumulator = null;										// Cache a null failure
		                }
		            }
		            else if (CAUGHT_or instanceof InvalidValueException) {		// Abnormal exception evaluation result
		                accumulator = CAUGHT_or;									// Cache an exception failure
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
		if (CAUGHT_status instanceof InvalidValueException) {
		    throw (InvalidValueException)CAUGHT_status;
		}
		final /*@Thrown*/ boolean ne = CAUGHT_status == Boolean.FALSE;
		/*@Nullable*/ /*@NonInvalid*/ String message_0;
		if (ne) {
		    message_0 = MetamodelTables.STR_The_32_section_32_extends_32_a_32_section_32_that_32_specifies_32_a_32_different_32_contain;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MetamodelTables.STR_Section_c_c_containerMatchesExtendContainer, this, null, diagnostics, context, message_0, MetamodelTables.INT_4, CAUGHT_status, MetamodelTables.INT_0).booleanValue());
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
			case MetamodelPackage.SOURCE_SECTION__ABSTRACT:
				return isAbstract();
			case MetamodelPackage.SOURCE_SECTION__EXTEND:
				return getExtend();
			case MetamodelPackage.SOURCE_SECTION__REFERENCING_MAPPINGS:
				return getReferencingMappings();
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
			case MetamodelPackage.SOURCE_SECTION__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case MetamodelPackage.SOURCE_SECTION__EXTEND:
				getExtend().clear();
				getExtend().addAll((Collection<? extends SourceSection>)newValue);
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
			case MetamodelPackage.SOURCE_SECTION__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case MetamodelPackage.SOURCE_SECTION__EXTEND:
				getExtend().clear();
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
			case MetamodelPackage.SOURCE_SECTION__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case MetamodelPackage.SOURCE_SECTION__EXTEND:
				return extend != null && !extend.isEmpty();
			case MetamodelPackage.SOURCE_SECTION__REFERENCING_MAPPINGS:
				return !getReferencingMappings().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Section.class) {
			switch (derivedFeatureID) {
				case MetamodelPackage.SOURCE_SECTION__ABSTRACT: return MetamodelPackage.SECTION__ABSTRACT;
				case MetamodelPackage.SOURCE_SECTION__EXTEND: return MetamodelPackage.SECTION__EXTEND;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Section.class) {
			switch (baseFeatureID) {
				case MetamodelPackage.SECTION__ABSTRACT: return MetamodelPackage.SOURCE_SECTION__ABSTRACT;
				case MetamodelPackage.SECTION__EXTEND: return MetamodelPackage.SOURCE_SECTION__EXTEND;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Section.class) {
			switch (baseOperationID) {
				case MetamodelPackage.SECTION___EXTENDS_ONLY_VALID_SECTIONS: return MetamodelPackage.SOURCE_SECTION___EXTENDS_ONLY_VALID_SECTIONS;
				case MetamodelPackage.SECTION___EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP_4: return MetamodelPackage.SOURCE_SECTION___EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP_4;
				case MetamodelPackage.SECTION___CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP_3: return MetamodelPackage.SOURCE_SECTION___CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP_3;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case MetamodelPackage.SOURCE_SECTION___IS_REFERENCED_BY_MAPPING__DIAGNOSTICCHAIN_MAP_4:
				return isReferencedByMapping((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MetamodelPackage.SOURCE_SECTION___EXTENDS_ONLY_VALID_SECTIONS:
				return extendsOnlyValidSections();
			case MetamodelPackage.SOURCE_SECTION___EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP_4:
				return extendsValidSections((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MetamodelPackage.SOURCE_SECTION___CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP_3:
				return containerMatchesExtendContainer((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (abstract: ");
		result.append(abstract_);
		result.append(')');
		return result.toString();
	}

} //SourceSectionImpl
