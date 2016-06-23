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
import org.eclipse.ocl.pivot.evaluation.Executor;
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
		 *       status : OclAny[?] = if self.getMapping().oclType() = OclVoid
		 *       then true
		 *       else
		 *         let
		 *           sourceMMSection : metamodel::SourceSection[1] = self.getMapping().sourceMMSection
		 *         in
		 *           if
		 *             self.source.oclType() = OclVoid or
		 *             sourceMMSection.oclType() = OclVoid
		 *           then true
		 *           else
		 *             self.source.oclAsType(metamodel::MetaModelElement(S, C, R, A))
		 *             .getContainingSection() = sourceMMSection or
		 *             self.source.oclAsType(metamodel::SourceSectionAttribute)
		 *             .getContainingSection()
		 *             .oclAsType(metamodel::SourceSection)
		 *             .isReferencedBy(sourceMMSection, null) or
		 *             sourceMMSection.oclAsType(metamodel::Section(S, C, R, A))
		 *             .extend->exists(e | e =
		 *               self.source.oclAsType(metamodel::SourceSectionAttribute)
		 *               .getContainingSection()
		 *               .oclAsType(metamodel::Section(S, C, R, A))) or
		 *             sourceMMSection.oclAsType(metamodel::Section(S, C, R, A))
		 *             .extend->exists(e |
		 *               self.source.oclAsType(metamodel::SourceSectionAttribute)
		 *               .getContainingSection()
		 *               .oclAsType(metamodel::Section(S, C, R, A))
		 *               .isReferencedBy(
		 *                 e.oclAsType(metamodel::Section(S, C, R, A)), null))
		 *           endif
		 *       endif
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
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ /*@Nullable*/ Object CAUGHT_status;
		try {
		    final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		    final /*@Thrown*/ Mapping getMapping = ((ModifiedAttributeElementType)this).getMapping();
		    final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, getMapping);
		    final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		    /*@Thrown*/ Boolean status;
		    if (eq) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        /*@Caught*/ /*@NonNull*/ Object CAUGHT_sourceMMSection;
		        try {
		            final /*@Thrown*/ SourceSection sourceMMSection = getMapping.getSourceMMSection();
		            CAUGHT_sourceMMSection = sourceMMSection;
		        }
		        catch (Exception e) {
		            CAUGHT_sourceMMSection = ValueUtil.createInvalidValue(e);
		        }
		        /*@Caught*/ /*@NonNull*/ Object CAUGHT_eq_0;
		        try {
		            final /*@Thrown*/ Object source = this.getSource();
		            final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType_0 = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, source);
		            final /*@Thrown*/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_0.getTypeId();
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        /*@Caught*/ /*@NonNull*/ Object CAUGHT_eq_1;
		        try {
		            if (CAUGHT_sourceMMSection instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_sourceMMSection;
		            }
		            final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType_1 = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, CAUGHT_sourceMMSection);
		            final /*@Thrown*/ boolean eq_1 = oclType_1.getTypeId() == TYP_OclVoid_0.getTypeId();
		            CAUGHT_eq_1 = eq_1;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_1 = ValueUtil.createInvalidValue(e);
		        }
		        final /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq_0, CAUGHT_eq_1);
		        if (or == null) {
		            throw new InvalidValueException("Null if condition");
		        }
		        /*@Thrown*/ Boolean symbol_0;
		        if (or) {
		            symbol_0 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            /*@Caught*/ /*@Nullable*/ Object CAUGHT_or_1;
		            try {
		                /*@Caught*/ /*@Nullable*/ Object CAUGHT_or_0;
		                try {
		                    /*@Caught*/ /*@NonNull*/ Object CAUGHT_eq_2;
		                    try {
		                        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_MetaModelElement_o_S_44_C_44_R_44_A_e = idResolver.getClass(MappingTables.CLSSid_MetaModelElement, null);
		                        final /*@Thrown*/ Object source_0 = this.getSource();
		                        final /*@Thrown*/ MetaModelElement oclAsType = ClassUtil.nonNullState((MetaModelElement)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, source_0, TYP_pamtram_c_c_metamodel_c_c_MetaModelElement_o_S_44_C_44_R_44_A_e));
		                        final /*@Thrown*/ Object getContainingSection = oclAsType.getContainingSection();
		                        if (CAUGHT_sourceMMSection instanceof InvalidValueException) {
		                            throw (InvalidValueException)CAUGHT_sourceMMSection;
		                        }
		                        final /*@Thrown*/ boolean eq_2 = getContainingSection.equals(CAUGHT_sourceMMSection);
		                        CAUGHT_eq_2 = eq_2;
		                    }
		                    catch (Exception e) {
		                        CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
		                    }
		                    /*@Caught*/ /*@NonNull*/ Object CAUGHT_isReferencedBy;
		                    try {
		                        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSection = idResolver.getClass(MappingTables.CLSSid_SourceSection, null);
		                        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute = idResolver.getClass(MappingTables.CLSSid_SourceSectionAttribute, null);
		                        final /*@Thrown*/ Object source_1 = this.getSource();
		                        final /*@Thrown*/ SourceSectionAttribute oclAsType_0 = ClassUtil.nonNullState((SourceSectionAttribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, source_1, TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute));
		                        final /*@Thrown*/ Object getContainingSection_0 = ((MetaModelElement)oclAsType_0).getContainingSection();
		                        final /*@Thrown*/ SourceSection oclAsType_1 = ClassUtil.nonNullState((SourceSection)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, getContainingSection_0, TYP_pamtram_c_c_metamodel_c_c_SourceSection));
		                        if (CAUGHT_sourceMMSection instanceof InvalidValueException) {
		                            throw (InvalidValueException)CAUGHT_sourceMMSection;
		                        }
		                        final /*@Thrown*/ boolean isReferencedBy = ((pamtram.metamodel.Class)oclAsType_1).isReferencedBy(CAUGHT_sourceMMSection, null);
		                        CAUGHT_isReferencedBy = isReferencedBy;
		                    }
		                    catch (Exception e) {
		                        CAUGHT_isReferencedBy = ValueUtil.createInvalidValue(e);
		                    }
		                    final /*@Thrown*/ Boolean or_0 = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq_2, CAUGHT_isReferencedBy);
		                    CAUGHT_or_0 = or_0;
		                }
		                catch (Exception e) {
		                    CAUGHT_or_0 = ValueUtil.createInvalidValue(e);
		                }
		                /*@Caught*/ /*@NonNull*/ Object CAUGHT_exists;
		                try {
		                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_1 = idResolver.getClass(MappingTables.CLSSid_Section, null);
		                    if (CAUGHT_sourceMMSection instanceof InvalidValueException) {
		                        throw (InvalidValueException)CAUGHT_sourceMMSection;
		                    }
		                    final /*@Thrown*/ Section oclAsType_2 = ClassUtil.nonNullState((Section)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, CAUGHT_sourceMMSection, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_1));
		                    final /*@Thrown*/ List<Object> extend = oclAsType_2.getExtend();
		                    final /*@Thrown*/ OrderedSetValue BOXED_extend = idResolver.createOrderedSetOfAll(MappingTables.ORD_TMPLid_, extend);
		                    /*@Thrown*/ Object accumulator = ValueUtil.FALSE_VALUE;
		                    /*@NonNull*/ Iterator<Object> ITERATOR_e_0 = BOXED_extend.iterator();
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
		                        /*@NonInvalid*/ Object e_0 = (Object)ITERATOR_e_0.next();
		                        /**
		                         * e =
		                         * self.source.oclAsType(metamodel::SourceSectionAttribute)
		                         * .getContainingSection()
		                         * .oclAsType(metamodel::Section(S, C, R, A))
		                         */
		                        /*@Caught*/ /*@NonNull*/ Object CAUGHT_eq_3;
		                        try {
		                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_0 = idResolver.getClass(MappingTables.CLSSid_SourceSectionAttribute, null);
		                            final /*@Thrown*/ Object source_2 = this.getSource();
		                            final /*@Thrown*/ SourceSectionAttribute oclAsType_3 = ClassUtil.nonNullState((SourceSectionAttribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, source_2, TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_0));
		                            final /*@Thrown*/ Object getContainingSection_1 = ((MetaModelElement)oclAsType_3).getContainingSection();
		                            final /*@Thrown*/ Section oclAsType_4 = ClassUtil.nonNullState((Section)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, getContainingSection_1, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_1));
		                            final /*@Thrown*/ boolean eq_3 = e_0.equals(oclAsType_4);
		                            CAUGHT_eq_3 = eq_3;
		                        }
		                        catch (Exception e) {
		                            CAUGHT_eq_3 = ValueUtil.createInvalidValue(e);
		                        }
		                        //
		                        if (CAUGHT_eq_3 == ValueUtil.TRUE_VALUE) {					// Normal successful body evaluation result
		                            exists = ValueUtil.TRUE_VALUE;
		                            break;														// Stop immediately 
		                        }
		                        else if (CAUGHT_eq_3 == ValueUtil.FALSE_VALUE) {				// Normal unsuccessful body evaluation result
		                            ;															// Carry on
		                        }
		                        else if (CAUGHT_eq_3 instanceof InvalidValueException) {		// Abnormal exception evaluation result
		                            accumulator = CAUGHT_eq_3;									// Cache an exception failure
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
		                final /*@Thrown*/ Boolean or_1 = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_or_0, CAUGHT_exists);
		                CAUGHT_or_1 = or_1;
		            }
		            catch (Exception e) {
		                CAUGHT_or_1 = ValueUtil.createInvalidValue(e);
		            }
		            /*@Caught*/ /*@NonNull*/ Object CAUGHT_exists_0;
		            try {
		                final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_4 = idResolver.getClass(MappingTables.CLSSid_Section, null);
		                if (CAUGHT_sourceMMSection instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_sourceMMSection;
		                }
		                final /*@Thrown*/ Section oclAsType_5 = ClassUtil.nonNullState((Section)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, CAUGHT_sourceMMSection, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_4));
		                final /*@Thrown*/ List<Object> extend_0 = oclAsType_5.getExtend();
		                final /*@Thrown*/ OrderedSetValue BOXED_extend_0 = idResolver.createOrderedSetOfAll(MappingTables.ORD_TMPLid_, extend_0);
		                /*@Thrown*/ Object accumulator_0 = ValueUtil.FALSE_VALUE;
		                /*@NonNull*/ Iterator<Object> ITERATOR_e_1 = BOXED_extend_0.iterator();
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
		                    /*@NonInvalid*/ Object e_1 = (Object)ITERATOR_e_1.next();
		                    /**
		                     * 
		                     * self.source.oclAsType(metamodel::SourceSectionAttribute)
		                     * .getContainingSection()
		                     * .oclAsType(metamodel::Section(S, C, R, A))
		                     * .isReferencedBy(
		                     *   e.oclAsType(metamodel::Section(S, C, R, A)), null)
		                     */
		                    /*@Caught*/ /*@NonNull*/ Object CAUGHT_isReferencedBy_0;
		                    try {
		                        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_1 = idResolver.getClass(MappingTables.CLSSid_SourceSectionAttribute, null);
		                        final /*@Thrown*/ Object source_3 = this.getSource();
		                        final /*@Thrown*/ SourceSectionAttribute oclAsType_6 = ClassUtil.nonNullState((SourceSectionAttribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, source_3, TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_1));
		                        final /*@Thrown*/ Object getContainingSection_2 = ((MetaModelElement)oclAsType_6).getContainingSection();
		                        final /*@Thrown*/ Section oclAsType_7 = ClassUtil.nonNullState((Section)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, getContainingSection_2, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_4));
		                        final /*@Thrown*/ Section oclAsType_8 = ClassUtil.nonNullState((Section)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, e_1, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e_4));
		                        final /*@Thrown*/ boolean isReferencedBy_0 = ((pamtram.metamodel.Class)oclAsType_7).isReferencedBy(oclAsType_8, null);
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
		            final /*@Thrown*/ Boolean or_2 = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_or_1, CAUGHT_exists_0);
		            symbol_0 = or_2;
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
		/*@NonInvalid*/ String message_0;
		if (ne) {
		    final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Attribute_o_S_44_C_44_R_44_A_e = idResolver.getClass(MappingTables.CLSSid_Attribute, null);
		    final /*@Thrown*/ Object source_4 = this.getSource();
		    final /*@Thrown*/ Attribute oclAsType_9 = ClassUtil.nonNullState((Attribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, source_4, TYP_pamtram_c_c_metamodel_c_c_Attribute_o_S_44_C_44_R_44_A_e));
		    final /*@Thrown*/ String name = oclAsType_9.getName();
		    final /*@NonInvalid*/ String sum = StringConcatOperation.INSTANCE.evaluate(MappingTables.STR_The_32_source_32_attribute_32_39, name);
		    final /*@NonInvalid*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, MappingTables.STR__39_32_is_32_not_32_referenced_32_by_32_the_32_source_32_section_32_of_32_the_32_parent_32_mapping_32);
		    final /*@Thrown*/ Mapping getMapping_1 = ((ModifiedAttributeElementType)this).getMapping();
		    final /*@Thrown*/ SourceSection sourceMMSection_0 = getMapping_1.getSourceMMSection();
		    final /*@Thrown*/ String name_0 = sourceMMSection_0.getName();
		    final /*@NonInvalid*/ String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, name_0);
		    final /*@NonInvalid*/ String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, MappingTables.STR__39_32_or_32_in_32_one_32_of_32_its_32_extended_32_sections_s_sub_m_sections_33);
		    message_0 = sum_2;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, MappingTables.STR_LocalModifiedAttributeElementType_c_c_sourceAttributeMatchesSection, this, null, diagnostics, context, message_0, MappingTables.INT_4, CAUGHT_status, MappingTables.INT_0).booleanValue();
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
			case MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP_1:
				return sourceAttributeMatchesSectionOrContainedSection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //LocalModifiedAttributeElementTypeImpl
