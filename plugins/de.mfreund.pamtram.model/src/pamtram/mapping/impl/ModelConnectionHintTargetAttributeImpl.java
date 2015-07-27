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
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingTables;
import pamtram.mapping.ModelConnectionHintTargetAttribute;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Connection Hint Target Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ModelConnectionHintTargetAttributeImpl extends ModifiedAttributeElementTypeImpl<TargetSectionClass, TargetSectionReference, TargetSectionAttribute> implements ModelConnectionHintTargetAttribute {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelConnectionHintTargetAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setSource(TargetSectionAttribute newSource) {
		super.setSource(newSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sourceMatchesPossibleContainerType(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv sourceMatchesPossibleContainerType:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[?] = let
		 *         targetMMSection : metamodel::TargetSectionClass[1] = self.oclContainer()
		 *         .oclContainer()
		 *         .oclAsType(MappingHintGroupType).targetMMSection
		 *       in
		 *         if
		 *           self.source.oclType() = OclVoid or
		 *           targetMMSection.oclType() = OclVoid
		 *         then true
		 *         else
		 *           self.source.oclAsType(metamodel::TargetSectionAttribute)
		 *           .oclContainer()
		 *           .oclAsType(metamodel::Class(C, R, A))
		 *           .eClass.eAllContainments->exists(r |
		 *             r.eReferenceType.isSuperTypeOf(targetMMSection.eClass))
		 *         endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The type of the parent hint group\'s target section (\'' +
		 *           self.oclContainer()
		 *           .oclContainer()
		 *           .oclAsType(MappingHintGroupType).targetMMSection.eClass.name + '\') cannot be connected to (contained in) the type of the class containing the target attribute (\'' +
		 *           self.source.oclAsType(metamodel::TargetSectionAttribute)
		 *           .oclContainer()
		 *           .oclAsType(metamodel::Class(C, R, A)).name + '\')!'
		 *         else null
		 *         endif
		 *       in
		 *         'ModelConnectionHintTargetAttribute::sourceMatchesPossibleContainerType'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@Nullable*/ /*@Caught*/ Object CAUGHT_symbol_0;
		try {
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_targetMMSection;
		    try {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0 = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupType, null);
		        final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, this);
		        final /*@Nullable*/ /*@Thrown*/ Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, oclContainer);
		        final /*@NonNull*/ /*@Thrown*/ MappingHintGroupType oclAsType = ClassUtil.nonNullState((MappingHintGroupType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer_0, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0));
		        final /*@NonNull*/ /*@Thrown*/ TargetSectionClass targetMMSection = oclAsType.getTargetMMSection();
		        CAUGHT_targetMMSection = targetMMSection;
		    }
		    catch (Exception e) {
		        CAUGHT_targetMMSection = ValueUtil.createInvalidValue(e);
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
		        if (CAUGHT_targetMMSection instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_targetMMSection;
		        }
		        final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType_0 = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, CAUGHT_targetMMSection));
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
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Class_o_C_44_R_44_A_e_0 = idResolver.getClass(MappingTables.CLSSid_Class_0, null);
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_TargetSectionAttribute = idResolver.getClass(MappingTables.CLSSid_TargetSectionAttribute, null);
		        final /*@NonNull*/ /*@Thrown*/ Object source_0 = this.getSource();
		        final /*@NonNull*/ /*@Thrown*/ TargetSectionAttribute oclAsType_0 = ClassUtil.nonNullState((TargetSectionAttribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source_0, TYP_pamtram_c_c_metamodel_c_c_TargetSectionAttribute));
		        final /*@Nullable*/ /*@Thrown*/ Object oclContainer_1 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, oclAsType_0);
		        final /*@NonNull*/ /*@Thrown*/ pamtram.metamodel.Class oclAsType_1 = ClassUtil.nonNullState((pamtram.metamodel.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer_1, TYP_pamtram_c_c_metamodel_c_c_Class_o_C_44_R_44_A_e_0));
		        final /*@NonNull*/ /*@Thrown*/ EClass eClass = oclAsType_1.getEClass();
		        @SuppressWarnings("null")
		        final /*@NonNull*/ /*@Thrown*/ List<EReference> eAllContainments = eClass.getEAllContainments();
		        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_eAllContainments = idResolver.createOrderedSetOfAll(MappingTables.ORD_CLSSid_EReference, eAllContainments);
		        /*@Nullable*/ /*@Thrown*/ Object accumulator = ValueUtil.FALSE_VALUE;
		        /*@Nullable*/ Iterator<?> ITERATOR_r = BOXED_eAllContainments.iterator();
		        /*@Nullable*/ /*@Thrown*/ Boolean exists;
		        while (true) {
		            if (!ITERATOR_r.hasNext()) {
		                if (accumulator == ValueUtil.FALSE_VALUE) {
		                    exists = ValueUtil.FALSE_VALUE;
		                }
		                else {
		                    throw (InvalidValueException)accumulator;
		                }
		                break;
		            }
		            /*@Nullable*/ /*@NonInvalid*/ EReference r = (EReference)ITERATOR_r.next();
		            /**
		             * r.eReferenceType.isSuperTypeOf(targetMMSection.eClass)
		             */
		            /*@NonNull*/ /*@Caught*/ Object CAUGHT_isSuperTypeOf;
		            try {
		                if (r == null) {
		                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/emf/2002/Ecore\'::EReference::eReferenceType\'");
		                }
		                @SuppressWarnings("null")
		                final /*@NonNull*/ /*@Thrown*/ EClass eReferenceType = r.getEReferenceType();
		                if (CAUGHT_targetMMSection instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_targetMMSection;
		                }
		                final /*@NonNull*/ /*@Thrown*/ EClass eClass_0 = ((TargetSectionClass)CAUGHT_targetMMSection).getEClass();
		                final /*@Thrown*/ boolean isSuperTypeOf = eReferenceType.isSuperTypeOf(eClass_0);
		                CAUGHT_isSuperTypeOf = isSuperTypeOf;
		            }
		            catch (Exception e) {
		                CAUGHT_isSuperTypeOf = ValueUtil.createInvalidValue(e);
		            }
		            //
		            if (CAUGHT_isSuperTypeOf == ValueUtil.TRUE_VALUE) {					// Normal successful body evaluation result
		                exists = ValueUtil.TRUE_VALUE;
		                break;														// Stop immediately 
		            }
		            else if (CAUGHT_isSuperTypeOf == ValueUtil.FALSE_VALUE) {				// Normal unsuccessful body evaluation result
		                ;															// Carry on
		            }
		            else if (CAUGHT_isSuperTypeOf instanceof InvalidValueException) {		// Abnormal exception evaluation result
		                accumulator = CAUGHT_isSuperTypeOf;									// Cache an exception failure
		            }
		            else {															// Impossible badly typed result
		                accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "exists");
		            }
		        }
		        symbol_0 = exists;
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
		    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_1 = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupType, null);
		    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Class_o_C_44_R_44_A_e_1 = idResolver.getClass(MappingTables.CLSSid_Class_0, null);
		    final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_TargetSectionAttribute_0 = idResolver.getClass(MappingTables.CLSSid_TargetSectionAttribute, null);
		    final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer_2 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, this);
		    final /*@Nullable*/ /*@Thrown*/ Object oclContainer_3 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, oclContainer_2);
		    final /*@NonNull*/ /*@Thrown*/ MappingHintGroupType oclAsType_2 = ClassUtil.nonNullState((MappingHintGroupType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer_3, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_1));
		    final /*@NonNull*/ /*@Thrown*/ TargetSectionClass targetMMSection_0 = oclAsType_2.getTargetMMSection();
		    final /*@NonNull*/ /*@Thrown*/ EClass eClass_1 = targetMMSection_0.getEClass();
		    final /*@Nullable*/ /*@Thrown*/ String name = eClass_1.getName();
		    final /*@NonNull*/ /*@NonInvalid*/ String sum = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(MappingTables.STR_The_32_type_32_of_32_the_32_parent_32_hint_32_group_39_s_32_target_32_section_32_o_39, name));
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_0 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum, MappingTables.STR__39_e_32_cannot_32_be_32_connected_32_to_32_o_contained_32_in_e_32_the_32_type_32_of_32_the_32_class_32_c));
		    final /*@NonNull*/ /*@Thrown*/ Object source_1 = this.getSource();
		    final /*@NonNull*/ /*@Thrown*/ TargetSectionAttribute oclAsType_3 = ClassUtil.nonNullState((TargetSectionAttribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source_1, TYP_pamtram_c_c_metamodel_c_c_TargetSectionAttribute_0));
		    final /*@Nullable*/ /*@Thrown*/ Object oclContainer_4 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, oclAsType_3);
		    final /*@NonNull*/ /*@Thrown*/ pamtram.metamodel.Class oclAsType_4 = ClassUtil.nonNullState((pamtram.metamodel.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer_4, TYP_pamtram_c_c_metamodel_c_c_Class_o_C_44_R_44_A_e_1));
		    final /*@Nullable*/ /*@Thrown*/ String name_0 = oclAsType_4.getName();
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_1 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum_0, name_0));
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_2 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum_1, MappingTables.STR__39_e_33));
		    message_0 = sum_2;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MappingTables.STR_ModelConnectionHintTargetAttribute_c_c_sourceMatchesPossibleContain, this, null, diagnostics, context, message_0, MappingTables.INT_4, CAUGHT_symbol_0, MappingTables.INT_0).booleanValue());
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
			case MappingPackage.MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE___SOURCE_MATCHES_POSSIBLE_CONTAINER_TYPE__DIAGNOSTICCHAIN_MAP:
				return sourceMatchesPossibleContainerType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ModelConnectionHintTargetAttributeImpl
