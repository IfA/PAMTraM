/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
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
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import pamtram.mapping.ExternalModifiedAttributeElementType;
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
 * An implementation of the model object '<em><b>External Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ExternalModifiedAttributeElementTypeImpl<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ModifiedAttributeElementTypeImpl<S, C, R, A> implements ExternalModifiedAttributeElementType<S, C, R, A> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalModifiedAttributeElementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sourceAttributeMatchesContainerSection(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv sourceAttributeMatchesContainerSection:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = if self.getMapping().oclType() = OclVoid
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
		 *             self.source.oclAsType(metamodel::SourceSectionAttribute)
		 *             .getContainingSection()
		 *             .oclAsType(metamodel::SourceSection)
		 *             .isContainerFor(
		 *               sourceMMSection.oclAsType(metamodel::SourceSection))
		 *           endif
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The source attribute \'' +
		 *           self.source.oclAsType(metamodel::Attribute(S, C, R, A)).name + '\' is not part of a container section of the source section of the parent mapping \'' +
		 *           self.getMapping().sourceMMSection.name + '\'!'
		 *         else null
		 *         endif
		 *       in
		 *         'ExternalModifiedAttributeElementType::sourceAttributeMatchesContainerSection'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		    final /*@NonNull*/ /*@Thrown*/ Mapping getMapping = ((ModifiedAttributeElementType)this).getMapping();
		    final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, getMapping));
		    final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		    /*@Thrown*/ boolean status;
		    if (eq) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        /*@NonNull*/ /*@Caught*/ Object CAUGHT_sourceMMSection;
		        try {
		            final /*@NonNull*/ /*@Thrown*/ SourceSection sourceMMSection = getMapping.getSourceMMSection();
		            CAUGHT_sourceMMSection = sourceMMSection;
		        }
		        catch (Exception e) {
		            CAUGHT_sourceMMSection = ValueUtil.createInvalidValue(e);
		        }
		        /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final /*@NonNull*/ /*@Thrown*/ Object source = this.getSource();
		            final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType_0 = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, source));
		            final /*@Thrown*/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_0.getTypeId();
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq_1;
		        try {
		            if (CAUGHT_sourceMMSection instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_sourceMMSection;
		            }
		            final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType_1 = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, CAUGHT_sourceMMSection));
		            final /*@Thrown*/ boolean eq_1 = oclType_1.getTypeId() == TYP_OclVoid_0.getTypeId();
		            CAUGHT_eq_1 = eq_1;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_1 = ValueUtil.createInvalidValue(e);
		        }
		        final /*@Nullable*/ /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq_0, CAUGHT_eq_1);
		        if (or == null) {
		            throw new InvalidValueException("Null if condition");
		        }
		        /*@Thrown*/ boolean symbol_0;
		        if (or) {
		            symbol_0 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSection_1 = idResolver.getClass(MappingTables.CLSSid_SourceSection, null);
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_0 = idResolver.getClass(MappingTables.CLSSid_SourceSectionAttribute, null);
		            final /*@NonNull*/ /*@Thrown*/ Object source_0 = this.getSource();
		            final /*@NonNull*/ /*@Thrown*/ SourceSectionAttribute oclAsType = ClassUtil.nonNullState((SourceSectionAttribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source_0, TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_0));
		            final /*@NonNull*/ /*@Thrown*/ Object getContainingSection = ((MetaModelElement)oclAsType).getContainingSection();
		            final /*@NonNull*/ /*@Thrown*/ SourceSection oclAsType_0 = ClassUtil.nonNullState((SourceSection)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, getContainingSection, TYP_pamtram_c_c_metamodel_c_c_SourceSection_1));
		            if (CAUGHT_sourceMMSection instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_sourceMMSection;
		            }
		            final /*@NonNull*/ /*@Thrown*/ SourceSection oclAsType_1 = ClassUtil.nonNullState((SourceSection)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CAUGHT_sourceMMSection, TYP_pamtram_c_c_metamodel_c_c_SourceSection_1));
		            final /*@Thrown*/ boolean isContainerFor = ((pamtram.metamodel.Class)oclAsType_0).isContainerFor((pamtram.metamodel.Class)oclAsType_1);
		            symbol_0 = isContainerFor;
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
		    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Attribute_o_S_44_C_44_R_44_A_e_0 = idResolver.getClass(MappingTables.CLSSid_Attribute, null);
		    final /*@NonNull*/ /*@Thrown*/ Object source_1 = this.getSource();
		    final /*@NonNull*/ /*@Thrown*/ Attribute oclAsType_2 = ClassUtil.nonNullState((Attribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source_1, TYP_pamtram_c_c_metamodel_c_c_Attribute_o_S_44_C_44_R_44_A_e_0));
		    final /*@Nullable*/ /*@Thrown*/ String name = oclAsType_2.getName();
		    final /*@NonNull*/ /*@NonInvalid*/ String sum = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(MappingTables.STR_The_32_source_32_attribute_32_39, name));
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_0 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum, MappingTables.STR__39_32_is_32_not_32_part_32_of_32_a_32_container_32_section_32_of_32_the_32_source_32_section_32_of_32_th));
		    final /*@NonNull*/ /*@Thrown*/ Mapping getMapping_1 = ((ModifiedAttributeElementType)this).getMapping();
		    final /*@NonNull*/ /*@Thrown*/ SourceSection sourceMMSection_0 = getMapping_1.getSourceMMSection();
		    final /*@Nullable*/ /*@Thrown*/ String name_0 = sourceMMSection_0.getName();
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_1 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum_0, name_0));
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_2 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum_1, MappingTables.STR__39_33));
		    message_0 = sum_2;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MappingTables.STR_ExternalModifiedAttributeElementType_c_c_sourceAttributeMatchesCont, this, null, diagnostics, context, message_0, MappingTables.INT_4, CAUGHT_status, MappingTables.INT_0).booleanValue());
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
			case MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP_7:
				return sourceAttributeMatchesContainerSection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ExternalModifiedAttributeElementTypeImpl
