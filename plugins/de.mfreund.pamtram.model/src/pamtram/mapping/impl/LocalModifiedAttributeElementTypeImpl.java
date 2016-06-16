/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import pamtram.mapping.LocalModifiedAttributeElementType;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingTables;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class LocalModifiedAttributeElementTypeImpl<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ModifiedAttributeElementTypeImpl<S, C, R, A> implements LocalModifiedAttributeElementType<S, C, R, A> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalModifiedAttributeElementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sourceAttributeMatchesSectionOrContainedSection(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv sourceAttributeMatchesSectionOrContainedSection:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[?] = let
		 *         sourceMMSection : metamodel::SourceSection[1] = self.getMapping().sourceMMSection
		 *       in
		 *         if
		 *           self.source.oclType() = OclVoid or
		 *           sourceMMSection.oclType() = OclVoid
		 *         then true
		 *         else
		 *           self.source.oclAsType(metamodel::MetaModelElement(S, C, R, A))
		 *           .getContainingSection() = sourceMMSection or
		 *           self.source.oclAsType(metamodel::SourceSectionAttribute)
		 *           .getContainingSection()
		 *           .oclAsType(metamodel::SourceSection)
		 *           .isReferencedBy(sourceMMSection, null) or
		 *           sourceMMSection.oclAsType(metamodel::Section(S, C, R, A))
		 *           .extend->exists(e | e =
		 *             self.source.oclAsType(metamodel::SourceSectionAttribute)
		 *             .getContainingSection()
		 *             .oclAsType(metamodel::Section(S, C, R, A))) or
		 *           sourceMMSection.oclAsType(metamodel::Section(S, C, R, A))
		 *           .extend->exists(e |
		 *             self.source.oclAsType(metamodel::SourceSectionAttribute)
		 *             .getContainingSection()
		 *             .oclAsType(metamodel::Section(S, C, R, A))
		 *             .isReferencedBy(
		 *               e.oclAsType(metamodel::Section(S, C, R, A)), null))
		 *         endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The source attribute \'' +
		 *           self.source.oclAsType(metamodel::Attribute(S, C, R, A)).name + '\' is not referenced by the source section of the parent mapping \'' +
		 *           self.getMapping().sourceMMSection.name + '\' or in one of its extended sections/sub-sections!'
		 *         else null
		 *         endif
		 *       in
		 *         'LocalModifiedAttributeElementType::sourceAttributeMatchesSectionOrContainedSection'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@Nullable*/ /*@Caught*/ Object CAUGHT_symbol_0;
		try {
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_sourceMMSection;
		    try {
		        final /*@NonNull*/ /*@Thrown*/ Mapping getMapping = ((ModifiedAttributeElementType)this).getMapping();
		        final /*@NonNull*/ /*@Thrown*/ SourceSection sourceMMSection = getMapping.getSourceMMSection();
		        CAUGHT_sourceMMSection = sourceMMSection;
		    }
		    catch (Exception e) {
		        CAUGHT_sourceMMSection = ValueUtil.createInvalidValue(e);
		    }
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		        final /*@NonNull*/ /*@Thrown*/ Object source = this.getSource();
		        final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, source));
		        final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValueUtil.createInvalidValue(e);
		    }
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_1 = idResolver.getClass(TypeId.OCL_VOID, null);
		        if (CAUGHT_sourceMMSection instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_sourceMMSection;
		        }
		        final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType_0 = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, CAUGHT_sourceMMSection));
		        final /*@Thrown*/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_1.getTypeId();
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		    }
		    final /*@Nullable*/ /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    if (or == null) {
		        throw new InvalidValueException("Null if condition");
		    }
		    /*@Nullable*/ /*@Thrown*/ Boolean symbol_0;
		    if (or) {
		        symbol_0 = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        /*@Nullable*/ /*@Caught*/ Object CAUGHT_or_1;
		        try {
		            /*@Nullable*/ /*@Caught*/ Object CAUGHT_or_0;
		            try {
		                /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq_1;
		                try {
		                    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_MetaModelElement_o_S_44_C_44_R_44_A_e = idResolver.getClass(MappingTables.CLSSid_MetaModelElement, null);
		                    final /*@NonNull*/ /*@Thrown*/ Object source_0 = this.getSource();
		                    final /*@NonNull*/ /*@Thrown*/ MetaModelElement oclAsType = ClassUtil.nonNullState((MetaModelElement)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source_0, TYP_pamtram_c_c_metamodel_c_c_MetaModelElement_o_S_44_C_44_R_44_A_e));
		                    final /*@NonNull*/ /*@Thrown*/ Object getContainingSection = oclAsType.getContainingSection();
		                    if (CAUGHT_sourceMMSection instanceof InvalidValueException) {
		                        throw (InvalidValueException)CAUGHT_sourceMMSection;
		                    }
		                    final /*@Thrown*/ boolean eq_1 = getContainingSection.equals(CAUGHT_sourceMMSection);
		                    CAUGHT_eq_1 = eq_1;
		                }
		                catch (Exception e) {
		                    CAUGHT_eq_1 = ValueUtil.createInvalidValue(e);
		                }
		                /*@NonNull*/ /*@Caught*/ Object CAUGHT_isReferencedBy;
		                try {
		                    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSection = idResolver.getClass(MappingTables.CLSSid_SourceSection, null);
		                    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute = idResolver.getClass(MappingTables.CLSSid_SourceSectionAttribute, null);
		                    final /*@NonNull*/ /*@Thrown*/ Object source_1 = this.getSource();
		                    final /*@NonNull*/ /*@Thrown*/ SourceSectionAttribute oclAsType_0 = ClassUtil.nonNullState((SourceSectionAttribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source_1, TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute));
		                    final /*@NonNull*/ /*@Thrown*/ Object getContainingSection_0 = ((MetaModelElement)oclAsType_0).getContainingSection();
		                    final /*@NonNull*/ /*@Thrown*/ SourceSection oclAsType_1 = ClassUtil.nonNullState((SourceSection)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, getContainingSection_0, TYP_pamtram_c_c_metamodel_c_c_SourceSection));
		                    if (CAUGHT_sourceMMSection instanceof InvalidValueException) {
		                        throw (InvalidValueException)CAUGHT_sourceMMSection;
		                    }
		                    final /*@Thrown*/ boolean isReferencedBy = ((pamtram.metamodel.Class)oclAsType_1).isReferencedBy((pamtram.metamodel.Class)CAUGHT_sourceMMSection, null);
		                    CAUGHT_isReferencedBy = isReferencedBy;
		                }
		                catch (Exception e) {
		                    CAUGHT_isReferencedBy = ValueUtil.createInvalidValue(e);
		                }
		                final /*@Nullable*/ /*@Thrown*/ Boolean or_0 = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq_1, CAUGHT_isReferencedBy);
		                CAUGHT_or_0 = or_0;
		            }
		            catch (Exception e) {
		                CAUGHT_or_0 = ValueUtil.createInvalidValue(e);
		            }
		            /*@NonNull*/ /*@Caught*/ Object CAUGHT_exists;
		            try {
		                final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_1 = idResolver.getClass(MappingTables.CLSSid_Section, null);
		                if (CAUGHT_sourceMMSection instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_sourceMMSection;
		                }
		                final /*@NonNull*/ /*@Thrown*/ Section oclAsType_2 = ClassUtil.nonNullState((Section)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CAUGHT_sourceMMSection, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_1));
		                final /*@NonNull*/ /*@Thrown*/ List<? extends Object> extend = oclAsType_2.getExtend();
		                final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_extend = idResolver.createOrderedSetOfAll(MappingTables.ORD_TMPLid_, extend);
		                /*@Nullable*/ /*@Thrown*/ Object accumulator = ValueUtil.FALSE_VALUE;
		                /*@Nullable*/ Iterator<?> ITERATOR_e_0 = BOXED_extend.iterator();
		                /*@Thrown*/ boolean exists;
		                while (true) {
		                    if (!ITERATOR_e_0.hasNext()) {
		                        if (accumulator == ValueUtil.FALSE_VALUE) {
		                            exists = ValueUtil.FALSE_VALUE;
		                        }
		                        else {
		                            throw (InvalidValueException)accumulator;
		                        }
		                        break;
		                    }
		                    /*@Nullable*/ /*@NonInvalid*/ Object e_0 = (Object)ITERATOR_e_0.next();
		                    /**
		                     * e =
		                     * self.source.oclAsType(metamodel::SourceSectionAttribute)
		                     * .getContainingSection()
		                     * .oclAsType(metamodel::Section(S, C, R, A))
		                     */
		                    /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq_2;
		                    try {
		                        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_0 = idResolver.getClass(MappingTables.CLSSid_SourceSectionAttribute, null);
		                        final /*@NonNull*/ /*@Thrown*/ Object source_2 = this.getSource();
		                        final /*@NonNull*/ /*@Thrown*/ SourceSectionAttribute oclAsType_3 = ClassUtil.nonNullState((SourceSectionAttribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source_2, TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_0));
		                        final /*@NonNull*/ /*@Thrown*/ Object getContainingSection_1 = ((MetaModelElement)oclAsType_3).getContainingSection();
		                        final /*@NonNull*/ /*@Thrown*/ Section oclAsType_4 = ClassUtil.nonNullState((Section)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, getContainingSection_1, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_1));
		                        final /*@Thrown*/ boolean eq_2 = oclAsType_4.equals(e_0);
		                        CAUGHT_eq_2 = eq_2;
		                    }
		                    catch (Exception e) {
		                        CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
		                    }
		                    //
		                    if (CAUGHT_eq_2 == ValueUtil.TRUE_VALUE) {					// Normal successful body evaluation result
		                        exists = ValueUtil.TRUE_VALUE;
		                        break;														// Stop immediately 
		                    }
		                    else if (CAUGHT_eq_2 == ValueUtil.FALSE_VALUE) {				// Normal unsuccessful body evaluation result
		                        ;															// Carry on
		                    }
		                    else if (CAUGHT_eq_2 instanceof InvalidValueException) {		// Abnormal exception evaluation result
		                        accumulator = CAUGHT_eq_2;									// Cache an exception failure
		                    }
		                    else {															// Impossible badly typed result
		                        accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "exists");
		                    }
		                }
		                CAUGHT_exists = exists;
		            }
		            catch (Exception e) {
		                CAUGHT_exists = ValueUtil.createInvalidValue(e);
		            }
		            final /*@Nullable*/ /*@Thrown*/ Boolean or_1 = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_or_0, CAUGHT_exists);
		            CAUGHT_or_1 = or_1;
		        }
		        catch (Exception e) {
		            CAUGHT_or_1 = ValueUtil.createInvalidValue(e);
		        }
		        /*@NonNull*/ /*@Caught*/ Object CAUGHT_exists_0;
		        try {
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_4 = idResolver.getClass(MappingTables.CLSSid_Section, null);
		            if (CAUGHT_sourceMMSection instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_sourceMMSection;
		            }
		            final /*@NonNull*/ /*@Thrown*/ Section oclAsType_5 = ClassUtil.nonNullState((Section)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CAUGHT_sourceMMSection, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_4));
		            final /*@NonNull*/ /*@Thrown*/ List<? extends Object> extend_0 = oclAsType_5.getExtend();
		            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_extend_0 = idResolver.createOrderedSetOfAll(MappingTables.ORD_TMPLid_, extend_0);
		            /*@Nullable*/ /*@Thrown*/ Object accumulator_0 = ValueUtil.FALSE_VALUE;
		            /*@Nullable*/ Iterator<?> ITERATOR_e_1 = BOXED_extend_0.iterator();
		            /*@Thrown*/ boolean exists_0;
		            while (true) {
		                if (!ITERATOR_e_1.hasNext()) {
		                    if (accumulator_0 == ValueUtil.FALSE_VALUE) {
		                        exists_0 = ValueUtil.FALSE_VALUE;
		                    }
		                    else {
		                        throw (InvalidValueException)accumulator_0;
		                    }
		                    break;
		                }
		                /*@Nullable*/ /*@NonInvalid*/ Object e_1 = (Object)ITERATOR_e_1.next();
		                /**
		                 * 
		                 * self.source.oclAsType(metamodel::SourceSectionAttribute)
		                 * .getContainingSection()
		                 * .oclAsType(metamodel::Section(S, C, R, A))
		                 * .isReferencedBy(
		                 *   e.oclAsType(metamodel::Section(S, C, R, A)), null)
		                 */
		                /*@NonNull*/ /*@Caught*/ Object CAUGHT_isReferencedBy_0;
		                try {
		                    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_1 = idResolver.getClass(MappingTables.CLSSid_SourceSectionAttribute, null);
		                    final /*@NonNull*/ /*@Thrown*/ Object source_3 = this.getSource();
		                    final /*@NonNull*/ /*@Thrown*/ SourceSectionAttribute oclAsType_6 = ClassUtil.nonNullState((SourceSectionAttribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source_3, TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_1));
		                    final /*@NonNull*/ /*@Thrown*/ Object getContainingSection_2 = ((MetaModelElement)oclAsType_6).getContainingSection();
		                    final /*@NonNull*/ /*@Thrown*/ Section oclAsType_7 = ClassUtil.nonNullState((Section)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, getContainingSection_2, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_4));
		                    final /*@NonNull*/ /*@Thrown*/ Section oclAsType_8 = ClassUtil.nonNullState((Section)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, e_1, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_4));
		                    final /*@Thrown*/ boolean isReferencedBy_0 = ((pamtram.metamodel.Class)oclAsType_7).isReferencedBy((pamtram.metamodel.Class)oclAsType_8, null);
		                    CAUGHT_isReferencedBy_0 = isReferencedBy_0;
		                }
		                catch (Exception e) {
		                    CAUGHT_isReferencedBy_0 = ValueUtil.createInvalidValue(e);
		                }
		                //
		                if (CAUGHT_isReferencedBy_0 == ValueUtil.TRUE_VALUE) {					// Normal successful body evaluation result
		                    exists_0 = ValueUtil.TRUE_VALUE;
		                    break;														// Stop immediately 
		                }
		                else if (CAUGHT_isReferencedBy_0 == ValueUtil.FALSE_VALUE) {				// Normal unsuccessful body evaluation result
		                    ;															// Carry on
		                }
		                else if (CAUGHT_isReferencedBy_0 instanceof InvalidValueException) {		// Abnormal exception evaluation result
		                    accumulator_0 = CAUGHT_isReferencedBy_0;									// Cache an exception failure
		                }
		                else {															// Impossible badly typed result
		                    accumulator_0 = new InvalidValueException(PivotMessages.NonBooleanBody, "exists");
		                }
		            }
		            CAUGHT_exists_0 = exists_0;
		        }
		        catch (Exception e) {
		            CAUGHT_exists_0 = ValueUtil.createInvalidValue(e);
		        }
		        final /*@Nullable*/ /*@Thrown*/ Boolean or_2 = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_or_1, CAUGHT_exists_0);
		        symbol_0 = or_2;
		    }
		    CAUGHT_symbol_0 = symbol_0;
		}
		catch (Exception e) {
		    CAUGHT_symbol_0 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_0 instanceof InvalidValueException) {
		    throw (InvalidValueException)CAUGHT_symbol_0;
		}
		final /*@Thrown*/ boolean ne = CAUGHT_symbol_0 == Boolean.FALSE;
		/*@Nullable*/ /*@NonInvalid*/ String message_0;
		if (ne) {
		    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Attribute_o_S_44_C_44_R_44_A_e = idResolver.getClass(MappingTables.CLSSid_Attribute, null);
		    final /*@NonNull*/ /*@Thrown*/ Object source_4 = this.getSource();
		    final /*@NonNull*/ /*@Thrown*/ Attribute oclAsType_9 = ClassUtil.nonNullState((Attribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source_4, TYP_pamtram_c_c_metamodel_c_c_Attribute_o_S_44_C_44_R_44_A_e));
		    final /*@Nullable*/ /*@Thrown*/ String name = oclAsType_9.getName();
		    final /*@NonNull*/ /*@NonInvalid*/ String sum = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(MappingTables.STR_The_32_source_32_attribute_32_39, name));
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_0 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum, MappingTables.STR__39_32_is_32_not_32_referenced_32_by_32_the_32_source_32_section_32_of_32_the_32_parent_32_mapping_32));
		    final /*@NonNull*/ /*@Thrown*/ Mapping getMapping_0 = ((ModifiedAttributeElementType)this).getMapping();
		    final /*@NonNull*/ /*@Thrown*/ SourceSection sourceMMSection_0 = getMapping_0.getSourceMMSection();
		    final /*@Nullable*/ /*@Thrown*/ String name_0 = sourceMMSection_0.getName();
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_1 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum_0, name_0));
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_2 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum_1, MappingTables.STR__39_32_or_32_in_32_one_32_of_32_its_32_extended_32_sections_s_sub_m_sections_33));
		    message_0 = sum_2;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MappingTables.STR_LocalModifiedAttributeElementType_c_c_sourceAttributeMatchesSection, this, null, diagnostics, context, message_0, MappingTables.INT_4, CAUGHT_symbol_0, MappingTables.INT_0).booleanValue());
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
			case MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP_5:
				return sourceAttributeMatchesSectionOrContainedSection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //LocalModifiedAttributeElementTypeImpl
