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
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import pamtram.NamedElement;
import pamtram.mapping.ExternalModifiedAttributeElementType;
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
 * An implementation of the model object '<em><b>External Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ExternalModifiedAttributeElementTypeImpl<C extends pamtram.metamodel.Class<C, R, A>, R extends Reference<C, R, A>, A extends Attribute<C, R, A>> extends ModifiedAttributeElementTypeImpl<C, R, A> implements ExternalModifiedAttributeElementType<C, R, A> {
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
		 *   let
		 *     severity : Integer[1] = 'ExternalModifiedAttributeElementType::sourceAttributeMatchesContainerSection'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[1] = self.source.oclAsType(metamodel::SourceSectionAttribute)
		 *         .getContainingSection()
		 *         .oclAsType(metamodel::SourceSectionClass)
		 *         .isContainerFor(
		 *           self.getMappingHintGroup()
		 *           .oclContainer()
		 *           .oclAsType(Mapping)
		 *           .sourceMMSection.oclAsType(metamodel::SourceSectionClass))
		 *       in
		 *         'ExternalModifiedAttributeElementType::sourceAttributeMatchesContainerSection'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@NonInvalid*/ IntegerValue severity_0 = ClassUtil.nonNullState(CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, MappingTables.STR_ExternalModifiedAttributeElementType_c_c_sourceAttributeMatchesCont));
		final /*@NonInvalid*/ boolean le = ClassUtil.nonNullState(OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, severity_0, MappingTables.INT_0).booleanValue());
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		    try {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_Mapping_0 = idResolver.getClass(MappingTables.CLSSid_Mapping, null);
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_0 = idResolver.getClass(MappingTables.CLSSid_SourceSectionAttribute, null);
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_SourceSectionClass_1 = idResolver.getClass(MappingTables.CLSSid_SourceSectionClass, null);
		        final /*@NonNull*/ /*@Thrown*/ Object source = this.getSource();
		        final /*@NonNull*/ /*@Thrown*/ SourceSectionAttribute oclAsType = ClassUtil.nonNullState((SourceSectionAttribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source, TYP_pamtram_c_c_metamodel_c_c_SourceSectionAttribute_0));
		        final /*@NonNull*/ /*@Thrown*/ Object getContainingSection = ((MetaModelElement)oclAsType).getContainingSection();
		        final /*@NonNull*/ /*@Thrown*/ SourceSectionClass oclAsType_0 = ClassUtil.nonNullState((SourceSectionClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, getContainingSection, TYP_pamtram_c_c_metamodel_c_c_SourceSectionClass_1));
		        final /*@NonNull*/ /*@Thrown*/ NamedElement getMappingHintGroup = ((ModifiedAttributeElementType)this).getMappingHintGroup();
		        final /*@Nullable*/ /*@Thrown*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, getMappingHintGroup);
		        final /*@NonNull*/ /*@Thrown*/ Mapping oclAsType_1 = ClassUtil.nonNullState((Mapping)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_Mapping_0));
		        final /*@NonNull*/ /*@Thrown*/ SourceSectionClass sourceMMSection = oclAsType_1.getSourceMMSection();
		        final /*@NonNull*/ /*@Thrown*/ SourceSectionClass oclAsType_2 = ClassUtil.nonNullState((SourceSectionClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, sourceMMSection, TYP_pamtram_c_c_metamodel_c_c_SourceSectionClass_1));
		        final /*@Thrown*/ boolean status = ((pamtram.metamodel.Class)oclAsType_0).isContainerFor((pamtram.metamodel.Class)oclAsType_2);
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MappingTables.STR_ExternalModifiedAttributeElementType_c_c_sourceAttributeMatchesCont, this, null, diagnostics, context, null, severity_0, CAUGHT_status, MappingTables.INT_0).booleanValue());
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
			case MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP_7:
				return sourceAttributeMatchesContainerSection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ExternalModifiedAttributeElementTypeImpl
