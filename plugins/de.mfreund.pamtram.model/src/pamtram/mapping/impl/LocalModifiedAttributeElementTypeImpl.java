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
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
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
		 *   let
		 *     severity : Integer[1] = 'LocalModifiedAttributeElementType::sourceAttributeMatchesSectionOrContainedSection'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[?] = self.source.oclAsType(metamodel::MetaModelElement(C, R, A))
		 *         .getContainingSection() =
		 *         self.getMappingHintGroup()
		 *         .oclContainer()
		 *         .oclAsType(Mapping).sourceMMSection or
		 *         self.source.oclAsType(metamodel::SourceSectionAttribute)
		 *         .getContainingSection()
		 *         .oclAsType(metamodel::SourceSectionClass)
		 *         .isContainedIn(
		 *           self.getMappingHintGroup()
		 *           .oclContainer()
		 *           .oclAsType(Mapping).sourceMMSection)
		 *       in
		 *         'LocalModifiedAttributeElementType::sourceAttributeMatchesSectionOrContainedSection'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@NonInvalid*/ IntegerValue severity_0 = ClassUtil.nonNullState(CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, MappingTables.STR_LocalModifiedAttributeElementType_c_c_sourceAttributeMatchesSection));
		final /*@NonInvalid*/ boolean le = ClassUtil.nonNullState(OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, severity_0, MappingTables.INT_0).booleanValue());
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    /*@Nullable*/ /*@Caught*/ Object CAUGHT_status;
		    try {
		        /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_Mapping_0 = idResolver.getClass(MappingTables.CLSSid_Mapping, null);
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_MetaModelElement_o_C_44_R_44_A_e = idResolver.getClass(MappingTables.CLSSid_MetaModelElement, null);
		            final /*@NonNull*/ /*@Thrown*/ Object source = this.getSource();
		            final /*@NonNull*/ /*@Thrown*/ MetaModelElement oclAsType = ClassUtil.nonNullState((MetaModelElement)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source, TYP_pamtram_c_c_metamodel_c_c_MetaModelElement_o_C_44_R_44_A_e));
		            final /*@NonNull*/ /*@Thrown*/ Object getContainingSection = oclAsType.getContainingSection();
		            final /*@NonNull*/ /*@Thrown*/ NamedElement getMappingHintGroup = ((ModifiedAttributeElementType)this).getMappingHintGroup();
		            final /*@Nullable*/ /*@Thrown*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, getMappingHintGroup);
		            final /*@NonNull*/ /*@Thrown*/ Mapping oclAsType_0 = ClassUtil.nonNullState((Mapping)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_Mapping_0));
		            final /*@NonNull*/ /*@Thrown*/ SourceSectionClass sourceMMSection = oclAsType_0.getSourceMMSection();
		            final /*@Thrown*/ boolean eq = getContainingSection.equals(sourceMMSection);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        /*@NonNull*/ /*@Caught*/ Object CAUGHT_isContainedIn;
		        try {
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_Mapping_1 = idResolver.getClass(MappingTables.CLSSid_Mapping, null);
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute = idResolver.getClass(MappingTables.CLSSid_SourceSectionAttribute, null);
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSectionClass = idResolver.getClass(MappingTables.CLSSid_SourceSectionClass, null);
		            final /*@NonNull*/ /*@Thrown*/ Object source_0 = this.getSource();
		            final /*@NonNull*/ /*@Thrown*/ SourceSectionAttribute oclAsType_1 = ClassUtil.nonNullState((SourceSectionAttribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source_0, TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute));
		            final /*@NonNull*/ /*@Thrown*/ Object getContainingSection_0 = ((MetaModelElement)oclAsType_1).getContainingSection();
		            final /*@NonNull*/ /*@Thrown*/ SourceSectionClass oclAsType_2 = ClassUtil.nonNullState((SourceSectionClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, getContainingSection_0, TYP_pamtram_c_c_metamodel_c_c_SourceSectionClass));
		            final /*@NonNull*/ /*@Thrown*/ NamedElement getMappingHintGroup_0 = ((ModifiedAttributeElementType)this).getMappingHintGroup();
		            final /*@Nullable*/ /*@Thrown*/ Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, getMappingHintGroup_0);
		            final /*@NonNull*/ /*@Thrown*/ Mapping oclAsType_3 = ClassUtil.nonNullState((Mapping)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer_0, TYP_pamtram_c_c_mapping_c_c_Mapping_1));
		            final /*@NonNull*/ /*@Thrown*/ SourceSectionClass sourceMMSection_0 = oclAsType_3.getSourceMMSection();
		            final /*@Thrown*/ boolean isContainedIn = ((pamtram.metamodel.Class)oclAsType_2).isContainedIn((pamtram.metamodel.Class)sourceMMSection_0);
		            CAUGHT_isContainedIn = isContainedIn;
		        }
		        catch (Exception e) {
		            CAUGHT_isContainedIn = ValueUtil.createInvalidValue(e);
		        }
		        final /*@Nullable*/ /*@Thrown*/ Boolean status = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_isContainedIn);
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MappingTables.STR_LocalModifiedAttributeElementType_c_c_sourceAttributeMatchesSection, this, null, diagnostics, context, null, severity_0, CAUGHT_status, MappingTables.INT_0).booleanValue());
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
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
			case MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP_3:
				return sourceAttributeMatchesSectionOrContainedSection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //LocalModifiedAttributeElementTypeImpl
