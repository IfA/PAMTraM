/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
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

import pamtram.mapping.MappingHintGroupType;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.MetamodelTables;
import pamtram.metamodel.Section;
import pamtram.metamodel.TargetSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.TargetSectionImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.TargetSectionImpl#getExtend <em>Extend</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.TargetSectionImpl#getReferencingMappingHintGroups <em>Referencing Mapping Hint Groups</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TargetSectionImpl extends TargetSectionClassImpl implements TargetSection {
	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;
	/**
	 * The cached value of the '{@link #getExtend() <em>Extend</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtend()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetSection> extend;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.TARGET_SECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.TARGET_SECTION__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TargetSection> getExtend() {
		if (extend == null) {
			extend = new EObjectResolvingEList<TargetSection>(TargetSection.class, this, MetamodelPackage.TARGET_SECTION__EXTEND);
		}
		return extend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<MappingHintGroupType> getReferencingMappingHintGroups() {
		/**
		 * 
		 * mapping::MappingHintGroupType.allInstances()
		 * ->select(mhg | self = mhg.targetMMSection)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0 = idResolver.getClass(MetamodelTables.CLSSid_MappingHintGroupType, null);
		final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, MetamodelTables.SET_CLSSid_MappingHintGroupType, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0));
		/*@NonNull*/ /*@Thrown*/ SetValue.Accumulator accumulator = ValueUtil.createSetAccumulatorValue(MetamodelTables.SET_CLSSid_MappingHintGroupType);
		/*@NonNull*/ Iterator<?> ITERATOR_mhg = allInstances.iterator();
		/*@NonNull*/ /*@Thrown*/ SetValue select;
		while (true) {
			if (!ITERATOR_mhg.hasNext()) {
				select = accumulator;
				break;
			}
			/*@NonNull*/ /*@NonInvalid*/ MappingHintGroupType mhg = (MappingHintGroupType)ITERATOR_mhg.next();
			/**
			 * self = mhg.targetMMSection
			 */
			final /*@NonNull*/ /*@Thrown*/ TargetSection targetMMSection = mhg.getTargetMMSection();
			final /*@Thrown*/ boolean eq = this.equals(targetMMSection);
			//
			if (eq == ValueUtil.TRUE_VALUE) {
				accumulator.add(mhg);
			}
		}
		final List<MappingHintGroupType> UNBOXED_select = select.asEcoreObjects(idResolver, pamtram.mapping.MappingHintGroupType.class);
		assert UNBOXED_select != null;
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=474307
		return new EcoreEList.UnmodifiableEList.FastCompare<> 
		(this, MetamodelPackage.Literals.TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS, UNBOXED_select.size(), UNBOXED_select.toArray()); 
		//		return (EList<MappingType>)UNBOXED_select;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isReferencedByMappingHintGroup(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv isReferencedByMappingHintGroup:
		 *   let severity : Integer[1] = 2
		 *   in
		 *     let status : OclAny[1] = self.referencingMappingHintGroups->size() > 0
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The section is not referenced by any hint group and will not be instantiated!'
		 *         else null
		 *         endif
		 *       in
		 *         'TargetSection::isReferencedByMappingHintGroup'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@NonNull*/ /*@Thrown*/ List<MappingHintGroupType> referencingMappingHintGroups = this.getReferencingMappingHintGroups();
		    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_referencingMappingHintGroups = idResolver.createOrderedSetOfAll(MetamodelTables.ORD_CLSSid_MappingHintGroupType, referencingMappingHintGroups);
		    final /*@NonNull*/ /*@Thrown*/ IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_referencingMappingHintGroups));
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
		    message_0 = MetamodelTables.STR_The_32_section_32_is_32_not_32_referenced_32_by_32_any_32_hint_32_group_32_and_32_will_32_not_32_be_32;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MetamodelTables.STR_TargetSection_c_c_isReferencedByMappingHintGroup, this, null, diagnostics, context, message_0, MetamodelTables.INT_2, CAUGHT_status, MetamodelTables.INT_0).booleanValue());
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * This method is only necessary as OCL does not seem to get along with generic types (the same logic implemented
	 * in OCL lead to 'UnsupportedOperationException' errors when trying to use 'self.extend->...').
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean extendsOnlyValidSections() {
		if(this.getEClass() == null) {
			return true;
		}

		for (TargetSection extend : this.getExtend()) {
			if(!extend.isAbstract() || extend.getEClass() != null && !(this.getEClass() == extend.getEClass()) && !(this.getEClass().getESuperTypes().contains(extend.getEClass()))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean extendsValidSections(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv extendsValidSections:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let status : OclAny[?] = self.extendsOnlyValidSections()
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The section extends a section that is either not abstract or that references an EClass of a different (super-)type!'
		 *         else null
		 *         endif
		 *       in
		 *         'Section::extendsValidSections'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@Thrown*/ boolean status = this.extendsOnlyValidSections();
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
		    message_0 = MetamodelTables.STR_The_32_section_32_extends_32_a_32_section_32_that_32_is_32_either_32_not_32_abstract_32_or_32_tha;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MetamodelTables.STR_Section_c_c_extendsValidSections, this, null, diagnostics, context, message_0, MetamodelTables.INT_4, CAUGHT_status, MetamodelTables.INT_0).booleanValue());
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
			case MetamodelPackage.TARGET_SECTION__ABSTRACT:
				return isAbstract();
			case MetamodelPackage.TARGET_SECTION__EXTEND:
				return getExtend();
			case MetamodelPackage.TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS:
				return getReferencingMappingHintGroups();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetamodelPackage.TARGET_SECTION__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case MetamodelPackage.TARGET_SECTION__EXTEND:
				getExtend().clear();
				getExtend().addAll((Collection<? extends TargetSection>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetamodelPackage.TARGET_SECTION__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case MetamodelPackage.TARGET_SECTION__EXTEND:
				getExtend().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetamodelPackage.TARGET_SECTION__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case MetamodelPackage.TARGET_SECTION__EXTEND:
				return extend != null && !extend.isEmpty();
			case MetamodelPackage.TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS:
				return !getReferencingMappingHintGroups().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Section.class) {
			switch (derivedFeatureID) {
				case MetamodelPackage.TARGET_SECTION__ABSTRACT: return MetamodelPackage.SECTION__ABSTRACT;
				case MetamodelPackage.TARGET_SECTION__EXTEND: return MetamodelPackage.SECTION__EXTEND;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Section.class) {
			switch (baseFeatureID) {
				case MetamodelPackage.SECTION__ABSTRACT: return MetamodelPackage.TARGET_SECTION__ABSTRACT;
				case MetamodelPackage.SECTION__EXTEND: return MetamodelPackage.TARGET_SECTION__EXTEND;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Section.class) {
			switch (baseOperationID) {
				case MetamodelPackage.SECTION___EXTENDS_ONLY_VALID_SECTIONS: return MetamodelPackage.TARGET_SECTION___EXTENDS_ONLY_VALID_SECTIONS;
				case MetamodelPackage.SECTION___EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP: return MetamodelPackage.TARGET_SECTION___EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case MetamodelPackage.TARGET_SECTION___IS_REFERENCED_BY_MAPPING_HINT_GROUP__DIAGNOSTICCHAIN_MAP:
				return isReferencedByMappingHintGroup((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MetamodelPackage.TARGET_SECTION___EXTENDS_ONLY_VALID_SECTIONS:
				return extendsOnlyValidSections();
			case MetamodelPackage.TARGET_SECTION___EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP:
				return extendsValidSections((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (abstract: ");
		result.append(abstract_);
		result.append(')');
		return result.toString();
	}

} //TargetSectionImpl
