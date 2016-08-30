/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
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
import pamtram.metamodel.ActualSourceSectionAttribute;

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
		 *           sourceSection : metamodel::SourceSection[1] = self.getMapping().sourceSection
		 *         in
		 *           if
		 *             self.source.oclType() = OclVoid or
		 *             sourceSection.oclType() = OclVoid
		 *           then true
		 *           else
		 *             self.source.oclAsType(metamodel::ActualSourceSectionAttribute)
		 *             .getContainingSection()
		 *             .oclAsType(metamodel::SourceSection)
		 *             .isContainerFor(
		 *               sourceSection.oclAsType(metamodel::SourceSection))
		 *           endif
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The source attribute \'' +
		 *           self.source.oclAsType(metamodel::Attribute(S, C, R, A)).name + '\' is not part of a container section of the source section of the parent mapping \'' +
		 *           self.getMapping().sourceSection.name + '\'!'
		 *         else null
		 *         endif
		 *       in
		 *         'ExternalModifiedAttributeElementType::sourceAttributeMatchesContainerSection'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ /*@NonNull*/ Object CAUGHT_status;
		try {
		    final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		    final /*@Thrown*/ Mapping getMapping = ((ModifiedAttributeElementType)this).getMapping();
		    final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, getMapping);
		    final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		    /*@Thrown*/ boolean status;
		    if (eq) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        /*@Caught*/ /*@NonNull*/ Object CAUGHT_sourceSection;
		        try {
		            final /*@Thrown*/ SourceSection sourceSection = getMapping.getSourceSection();
		            CAUGHT_sourceSection = sourceSection;
		        }
		        catch (Exception e) {
		            CAUGHT_sourceSection = ValueUtil.createInvalidValue(e);
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
		            if (CAUGHT_sourceSection instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_sourceSection;
		            }
		            final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType_1 = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, CAUGHT_sourceSection);
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
		        /*@Thrown*/ boolean symbol_0;
		        if (or) {
		            symbol_0 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_ActualSourceSectionAttribute = idResolver.getClass(MappingTables.CLSSid_ActualSourceSectionAttribute, null);
		            final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSection_0 = idResolver.getClass(MappingTables.CLSSid_SourceSection, null);
		            final /*@Thrown*/ Object source_0 = this.getSource();
		            final /*@Thrown*/ ActualSourceSectionAttribute oclAsType = ClassUtil.nonNullState((ActualSourceSectionAttribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, source_0, TYP_pamtram_c_c_metamodel_c_c_ActualSourceSectionAttribute));
		            final /*@Thrown*/ Object getContainingSection = ((MetaModelElement)oclAsType).getContainingSection();
		            final /*@Thrown*/ SourceSection oclAsType_0 = ClassUtil.nonNullState((SourceSection)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, getContainingSection, TYP_pamtram_c_c_metamodel_c_c_SourceSection_0));
		            if (CAUGHT_sourceSection instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_sourceSection;
		            }
		            final /*@Thrown*/ SourceSection oclAsType_1 = ClassUtil.nonNullState((SourceSection)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, CAUGHT_sourceSection, TYP_pamtram_c_c_metamodel_c_c_SourceSection_0));
		            final /*@Thrown*/ boolean isContainerFor = ((pamtram.metamodel.Class)oclAsType_0).isContainerFor(oclAsType_1);
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
		/*@NonInvalid*/ String message_0;
		if (ne) {
		    final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Attribute_o_S_44_C_44_R_44_A_e = idResolver.getClass(MappingTables.CLSSid_Attribute, null);
		    final /*@Thrown*/ Object source_1 = this.getSource();
		    final /*@Thrown*/ Attribute oclAsType_2 = ClassUtil.nonNullState((Attribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, source_1, TYP_pamtram_c_c_metamodel_c_c_Attribute_o_S_44_C_44_R_44_A_e));
		    final /*@Thrown*/ String name = oclAsType_2.getName();
		    final /*@NonInvalid*/ String sum = StringConcatOperation.INSTANCE.evaluate(MappingTables.STR_The_32_source_32_attribute_32_39, name);
		    final /*@NonInvalid*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, MappingTables.STR__39_32_is_32_not_32_part_32_of_32_a_32_container_32_section_32_of_32_the_32_source_32_section_32_of_32_th);
		    final /*@Thrown*/ Mapping getMapping_1 = ((ModifiedAttributeElementType)this).getMapping();
		    final /*@Thrown*/ SourceSection sourceSection_0 = getMapping_1.getSourceSection();
		    final /*@Thrown*/ String name_0 = sourceSection_0.getName();
		    final /*@NonInvalid*/ String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, name_0);
		    final /*@NonInvalid*/ String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, MappingTables.STR__39_33);
		    message_0 = sum_2;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, MappingTables.STR_ExternalModifiedAttributeElementType_c_c_sourceAttributeMatchesCont, this, null, diagnostics, context, message_0, MappingTables.INT_4, CAUGHT_status, MappingTables.INT_0).booleanValue();
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
			case MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP_10:
				return sourceAttributeMatchesContainerSection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ExternalModifiedAttributeElementTypeImpl
