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
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
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
		 *   let
		 *     severity : Integer[1] = 'ModelConnectionHintTargetAttribute::sourceMatchesPossibleContainerType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[?] = self.source.oclAsType(metamodel::TargetSectionAttribute)
		 *         .oclContainer()
		 *         .oclAsType(metamodel::Class(C, R, A))
		 *         .eClass.eAllContainments->exists(r |
		 *           r.eReferenceType.isSuperTypeOf(
		 *             self.oclContainer()
		 *             .oclContainer()
		 *             .oclAsType(MappingHintGroupType).targetMMSection.eClass))
		 *       in
		 *         'ModelConnectionHintTargetAttribute::sourceMatchesPossibleContainerType'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@NonInvalid*/ IntegerValue severity_0 = ClassUtil.nonNullState(CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, MappingTables.STR_ModelConnectionHintTargetAttribute_c_c_sourceMatchesPossibleContain));
		final /*@NonInvalid*/ boolean le = ClassUtil.nonNullState(OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, severity_0, MappingTables.INT_0).booleanValue());
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    /*@Nullable*/ /*@Caught*/ Object CAUGHT_status;
		    try {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Class_o_C_44_R_44_A_e_0 = idResolver.getClass(MappingTables.CLSSid_Class, null);
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_TargetSectionAttribute = idResolver.getClass(MappingTables.CLSSid_TargetSectionAttribute, null);
		        final /*@NonNull*/ /*@Thrown*/ Object source = this.getSource();
		        final /*@NonNull*/ /*@Thrown*/ TargetSectionAttribute oclAsType = ClassUtil.nonNullState((TargetSectionAttribute)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, source, TYP_pamtram_c_c_metamodel_c_c_TargetSectionAttribute));
		        final /*@Nullable*/ /*@Thrown*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, oclAsType);
		        final /*@NonNull*/ /*@Thrown*/ pamtram.metamodel.Class oclAsType_0 = ClassUtil.nonNullState((pamtram.metamodel.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_metamodel_c_c_Class_o_C_44_R_44_A_e_0));
		        final /*@NonNull*/ /*@Thrown*/ EClass eClass = oclAsType_0.getEClass();
		        @SuppressWarnings("null")
		        final /*@NonNull*/ /*@Thrown*/ List<EReference> eAllContainments = eClass.getEAllContainments();
		        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_eAllContainments = idResolver.createOrderedSetOfAll(MappingTables.ORD_CLSSid_EReference, eAllContainments);
		        /*@Nullable*/ /*@Thrown*/ Object accumulator = ValueUtil.FALSE_VALUE;
		        /*@Nullable*/ Iterator<?> ITERATOR_r = BOXED_eAllContainments.iterator();
		        /*@Nullable*/ /*@Thrown*/ Boolean status;
		        while (true) {
		            if (!ITERATOR_r.hasNext()) {
		                if (accumulator == ValueUtil.FALSE_VALUE) {
		                    status = ValueUtil.FALSE_VALUE;
		                }
		                else {
		                    throw (InvalidValueException)accumulator;
		                }
		                break;
		            }
		            /*@Nullable*/ /*@NonInvalid*/ EReference r = (EReference)ITERATOR_r.next();
		            /**
		             * 
		             * r.eReferenceType.isSuperTypeOf(
		             *   self.oclContainer()
		             *   .oclContainer()
		             *   .oclAsType(MappingHintGroupType).targetMMSection.eClass)
		             */
		            /*@NonNull*/ /*@Caught*/ Object CAUGHT_isSuperTypeOf;
		            try {
		                final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0 = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupType, null);
		                if (r == null) {
		                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/emf/2002/Ecore\'::EReference::eReferenceType\'");
		                }
		                @SuppressWarnings("null")
		                final /*@NonNull*/ /*@Thrown*/ EClass eReferenceType = r.getEReferenceType();
		                final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, this);
		                final /*@Nullable*/ /*@Thrown*/ Object oclContainer_1 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, oclContainer_0);
		                final /*@NonNull*/ /*@Thrown*/ MappingHintGroupType oclAsType_1 = ClassUtil.nonNullState((MappingHintGroupType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer_1, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0));
		                final /*@NonNull*/ /*@Thrown*/ TargetSectionClass targetMMSection = oclAsType_1.getTargetMMSection();
		                final /*@NonNull*/ /*@Thrown*/ EClass eClass_0 = targetMMSection.getEClass();
		                final /*@Thrown*/ boolean isSuperTypeOf = eReferenceType.isSuperTypeOf(eClass_0);
		                CAUGHT_isSuperTypeOf = isSuperTypeOf;
		            }
		            catch (Exception e) {
		                CAUGHT_isSuperTypeOf = ValueUtil.createInvalidValue(e);
		            }
		            //
		            if (CAUGHT_isSuperTypeOf == ValueUtil.TRUE_VALUE) {					// Normal successful body evaluation result
		                status = ValueUtil.TRUE_VALUE;
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
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MappingTables.STR_ModelConnectionHintTargetAttribute_c_c_sourceMatchesPossibleContain, this, null, diagnostics, context, null, severity_0, CAUGHT_status, MappingTables.INT_0).booleanValue());
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
			case MappingPackage.MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE___SOURCE_MATCHES_POSSIBLE_CONTAINER_TYPE__DIAGNOSTICCHAIN_MAP:
				return sourceMatchesPossibleContainerType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ModelConnectionHintTargetAttributeImpl
