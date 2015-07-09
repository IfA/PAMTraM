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
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import pamtram.NamedElement;
import pamtram.mapping.LocalModifiedAttributeElementType;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingTables;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.Reference;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class LocalModifiedAttributeElementTypeImpl<C extends pamtram.metamodel.Class<C, R, A>, R extends Reference<C, R, A>, A extends Attribute<C, R, A>> extends ModifiedAttributeElementTypeImpl<C, R, A> implements LocalModifiedAttributeElementType<C, R, A> {
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
		 *         sourceMMSection : metamodel::SourceSectionClass[1] = self.getMappingHintGroup()
		 *         .oclContainer()
		 *         .oclAsType(Mapping).sourceMMSection
		 *       in
		 *         if
		 *           self.source.oclType() = OclVoid or
		 *           sourceMMSection.oclType() = OclVoid
		 *         then true
		 *         else
		 *           self.source.oclAsType(metamodel::MetaModelElement(C, R, A))
		 *           .getContainingSection() = sourceMMSection or
		 *           self.source.oclAsType(metamodel::SourceSectionAttribute)
		 *           .getContainingSection()
		 *           .oclAsType(metamodel::SourceSectionClass)
		 *           .isContainedIn(sourceMMSection)
		 *         endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The source attribute \'' +
		 *           self.source.oclAsType(metamodel::Attribute(C, R, A)).name + '\' is not contained in the source section of the parent hint group \'' +
		 *           self.getMappingHintGroup()
		 *           .oclContainer()
		 *           .oclAsType(Mapping).sourceMMSection.name + '\' or in one of its sub-sections!'
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
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_Mapping_0 = idResolver.getClass(MappingTables.CLSSid_Mapping, null);
		        final /*@NonNull*/ /*@Thrown*/ NamedElement getMappingHintGroup = ((ModifiedAttributeElementType)this).getMappingHintGroup();
		        final /*@Nullable*/ /*@Thrown*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, getMappingHintGroup);
		        final /*@NonNull*/ /*@Thrown*/ Mapping oclAsType = ClassUtil.nonNullState((Mapping)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_Mapping_0));
		        final /*@NonNull*/ /*@Thrown*/ SourceSectionClass sourceMMSection = oclAsType.getSourceMMSection();
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
		        /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq_1;
		        try {
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_MetaModelElement_o_C_44_R_44_A_e = idResolver.getClass(MappingTables.CLSSid_MetaModelElement, null);
		            final /*@NonNull*/ /*@Thrown*/ Object source_0 = this.getSource();
		            final /*@NonNull*/ /*@Thrown*/ MetaModelElement oclAsType_0 = ClassUtil.nonNullState((MetaModelElement)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source_0, TYP_pamtram_c_c_metamodel_c_c_MetaModelElement_o_C_44_R_44_A_e));
		            final /*@NonNull*/ /*@Thrown*/ Object getContainingSection = oclAsType_0.getContainingSection();
		            if (CAUGHT_sourceMMSection instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_sourceMMSection;
		            }
		            final /*@Thrown*/ boolean eq_1 = getContainingSection.equals(CAUGHT_sourceMMSection);
		            CAUGHT_eq_1 = eq_1;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_1 = ValueUtil.createInvalidValue(e);
		        }
		        /*@NonNull*/ /*@Caught*/ Object CAUGHT_isContainedIn;
		        try {
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute = idResolver.getClass(MappingTables.CLSSid_SourceSectionAttribute, null);
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSectionClass = idResolver.getClass(MappingTables.CLSSid_SourceSectionClass, null);
		            final /*@NonNull*/ /*@Thrown*/ Object source_1 = this.getSource();
		            final /*@NonNull*/ /*@Thrown*/ SourceSectionAttribute oclAsType_1 = ClassUtil.nonNullState((SourceSectionAttribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source_1, TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute));
		            final /*@NonNull*/ /*@Thrown*/ Object getContainingSection_0 = ((MetaModelElement)oclAsType_1).getContainingSection();
		            final /*@NonNull*/ /*@Thrown*/ SourceSectionClass oclAsType_2 = ClassUtil.nonNullState((SourceSectionClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, getContainingSection_0, TYP_pamtram_c_c_metamodel_c_c_SourceSectionClass));
		            if (CAUGHT_sourceMMSection instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_sourceMMSection;
		            }
		            final /*@Thrown*/ boolean isContainedIn = ((pamtram.metamodel.Class)oclAsType_2).isContainedIn((pamtram.metamodel.Class)CAUGHT_sourceMMSection);
		            CAUGHT_isContainedIn = isContainedIn;
		        }
		        catch (Exception e) {
		            CAUGHT_isContainedIn = ValueUtil.createInvalidValue(e);
		        }
		        final /*@Nullable*/ /*@Thrown*/ Boolean or_0 = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq_1, CAUGHT_isContainedIn);
		        symbol_0 = or_0;
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
		    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_Mapping_1 = idResolver.getClass(MappingTables.CLSSid_Mapping, null);
		    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Attribute_o_C_44_R_44_A_e = idResolver.getClass(MappingTables.CLSSid_Attribute, null);
		    final /*@NonNull*/ /*@Thrown*/ Object source_2 = this.getSource();
		    final /*@NonNull*/ /*@Thrown*/ Attribute oclAsType_3 = ClassUtil.nonNullState((Attribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source_2, TYP_pamtram_c_c_metamodel_c_c_Attribute_o_C_44_R_44_A_e));
		    final /*@Nullable*/ /*@Thrown*/ String name = oclAsType_3.getName();
		    final /*@NonNull*/ /*@NonInvalid*/ String sum = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(MappingTables.STR_The_32_source_32_attribute_32_39, name));
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_0 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum, MappingTables.STR__39_32_is_32_not_32_contained_32_in_32_the_32_source_32_section_32_of_32_the_32_parent_32_hint_32_grou));
		    final /*@NonNull*/ /*@Thrown*/ NamedElement getMappingHintGroup_0 = ((ModifiedAttributeElementType)this).getMappingHintGroup();
		    final /*@Nullable*/ /*@Thrown*/ Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, getMappingHintGroup_0);
		    final /*@NonNull*/ /*@Thrown*/ Mapping oclAsType_4 = ClassUtil.nonNullState((Mapping)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer_0, TYP_pamtram_c_c_mapping_c_c_Mapping_1));
		    final /*@NonNull*/ /*@Thrown*/ SourceSectionClass sourceMMSection_0 = oclAsType_4.getSourceMMSection();
		    final /*@Nullable*/ /*@Thrown*/ String name_0 = sourceMMSection_0.getName();
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_1 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum_0, name_0));
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_2 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum_1, MappingTables.STR__39_32_or_32_in_32_one_32_of_32_its_32_sub_m_sections_33));
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
			case MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP_14:
				return sourceAttributeMatchesSectionOrContainedSection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //LocalModifiedAttributeElementTypeImpl
