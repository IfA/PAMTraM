/**
 */
package pamtram.metamodel.impl;

import java.lang.Class;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
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
import pamtram.metamodel.Attribute;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.MetamodelTables;
import pamtram.metamodel.Reference;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Section Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.SourceSectionClassImpl#getReferencingMappings <em>Referencing Mappings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SourceSectionClassImpl extends ClassImpl<SourceSectionClass, SourceSectionReference, SourceSectionAttribute> implements SourceSectionClass {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.SOURCE_SECTION_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<SourceSectionReference> getReferences() {
		if (references == null) {
			references = new EObjectContainmentWithInverseEList<SourceSectionReference>(SourceSectionReference.class, this, MetamodelPackage.SOURCE_SECTION_CLASS__REFERENCES, MetamodelPackage.REFERENCE__OWNING_CLASS) { private static final long serialVersionUID = 1L; @Override public Class<?> getInverseFeatureClass() { return Reference.class; } };
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setContainer(SourceSectionClass newContainer) {
		super.setContainer(newContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<SourceSectionAttribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentWithInverseEList<SourceSectionAttribute>(SourceSectionAttribute.class, this, MetamodelPackage.SOURCE_SECTION_CLASS__ATTRIBUTES, MetamodelPackage.ATTRIBUTE__OWNING_CLASS) { private static final long serialVersionUID = 1L; @Override public Class<?> getInverseFeatureClass() { return Attribute.class; } };
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
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
		    final /*@NonNull*/ /*@Thrown*/ SourceSectionClass sourceMMSection = m.getSourceMMSection();
		    final /*@Thrown*/ boolean eq = this.equals(sourceMMSection);
		    //
		    if (eq == ValueUtil.TRUE_VALUE) {
		        accumulator.add(m);
		    }
		}
		final List<MappingType> UNBOXED_select = select.asEcoreObjects(idResolver, pamtram.mapping.MappingType.class);
		assert UNBOXED_select != null;
		return (EList<MappingType>)UNBOXED_select;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReferencedByMapping(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv isReferencedByMapping:
		 *   let severity : Integer[1] = 2
		 *   in
		 *     let
		 *       status : OclAny[1] = if self.isSection()
		 *       then self.referencingMappings->size() > 0
		 *       else true
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The section is not referenced by any mapping!'
		 *         else null
		 *         endif
		 *       in
		 *         'SourceSectionClass::isReferencedByMapping'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@Thrown*/ boolean isSection = ((pamtram.metamodel.Class)this).isSection();
		    /*@Thrown*/ boolean status;
		    if (isSection) {
		        final /*@NonNull*/ /*@Thrown*/ List<MappingType> referencingMappings = this.getReferencingMappings();
		        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_referencingMappings = idResolver.createOrderedSetOfAll(MetamodelTables.ORD_CLSSid_MappingType, referencingMappings);
		        final /*@NonNull*/ /*@Thrown*/ IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_referencingMappings));
		        final /*@Thrown*/ boolean gt = ClassUtil.nonNullState(OclComparableGreaterThanOperation.INSTANCE.evaluate(evaluator, size, MetamodelTables.INT_0).booleanValue());
		        status = gt;
		    }
		    else {
		        status = ValueUtil.TRUE_VALUE;
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
		    message_0 = MetamodelTables.STR_The_32_section_32_is_32_not_32_referenced_32_by_32_any_32_mapping_33;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MetamodelTables.STR_SourceSectionClass_c_c_isReferencedByMapping, this, null, diagnostics, context, message_0, MetamodelTables.INT_2, CAUGHT_status, MetamodelTables.INT_0).booleanValue());
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
			case MetamodelPackage.SOURCE_SECTION_CLASS__REFERENCING_MAPPINGS:
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
			case MetamodelPackage.SOURCE_SECTION_CLASS__REFERENCING_MAPPINGS:
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
			case MetamodelPackage.SOURCE_SECTION_CLASS___IS_REFERENCED_BY_MAPPING__DIAGNOSTICCHAIN_MAP_5:
				return isReferencedByMapping((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //SourceSectionClassImpl
