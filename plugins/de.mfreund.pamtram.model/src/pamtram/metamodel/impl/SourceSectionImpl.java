/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SetValue;

import pamtram.mapping.MappingType;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.MetamodelTables;
import pamtram.metamodel.SourceSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.SourceSectionImpl#getReferencingMappings <em>Referencing Mappings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SourceSectionImpl extends SourceSectionClassImpl implements SourceSection {
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
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
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
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MetamodelPackage.SOURCE_SECTION___IS_REFERENCED_BY_MAPPING__DIAGNOSTICCHAIN_MAP_5:
				return isReferencedByMapping((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //SourceSectionImpl
