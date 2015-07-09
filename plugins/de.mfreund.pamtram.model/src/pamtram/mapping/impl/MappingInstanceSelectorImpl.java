/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingTables;
import pamtram.mapping.Matcher;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionNonContainmentReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.MappingInstanceSelectorImpl#getAffectedReference <em>Affected Reference</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingInstanceSelectorImpl#getMatcher <em>Matcher</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingInstanceSelectorImpl extends MappingHintImpl implements MappingInstanceSelector {
	/**
	 * The cached value of the '{@link #getAffectedReference() <em>Affected Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffectedReference()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionNonContainmentReference affectedReference;

	/**
	 * The cached value of the '{@link #getMatcher() <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatcher()
	 * @generated
	 * @ordered
	 */
	protected Matcher matcher;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingInstanceSelectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPING_INSTANCE_SELECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSectionNonContainmentReference getAffectedReference() {
		if (affectedReference != null && affectedReference.eIsProxy()) {
			InternalEObject oldAffectedReference = (InternalEObject)affectedReference;
			affectedReference = (TargetSectionNonContainmentReference)eResolveProxy(oldAffectedReference);
			if (affectedReference != oldAffectedReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE, oldAffectedReference, affectedReference));
			}
		}
		return affectedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionNonContainmentReference basicGetAffectedReference() {
		return affectedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAffectedReferenceGen(TargetSectionNonContainmentReference newAffectedReference) {
		TargetSectionNonContainmentReference oldAffectedReference = affectedReference;
		affectedReference = newAffectedReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE, oldAffectedReference, affectedReference));
	}
	
	/**
	 * Before setting the {@link newAffectedReference}, update the name
	 */
	@Override
	public void setAffectedReference(TargetSectionNonContainmentReference newAffectedReference) {
		setNameDerived(affectedReference, newAffectedReference, null, null);
		setAffectedReferenceGen(newAffectedReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Matcher getMatcher() {
		return matcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatcher(Matcher newMatcher, NotificationChain msgs) {
		Matcher oldMatcher = matcher;
		matcher = newMatcher;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER, oldMatcher, newMatcher);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMatcher(Matcher newMatcher) {
		if (newMatcher != matcher) {
			NotificationChain msgs = null;
			if (matcher != null)
				msgs = ((InternalEObject)matcher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER, null, msgs);
			if (newMatcher != null)
				msgs = ((InternalEObject)newMatcher).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER, null, msgs);
			msgs = basicSetMatcher(newMatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER, newMatcher, newMatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean affectedReferenceMatchesSection(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv affectedReferenceMatchesSection:
		 *   let
		 *     severity : Integer[1] = 'MappingInstanceSelector::affectedReferenceMatchesSection'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[1] = if
		 *           self.oclContainer()
		 *           .oclIsKindOf(MappingHintGroupType)
		 *         then
		 *           self.affectedReference.getContainingSection() =
		 *           self.oclContainer()
		 *           .oclAsType(MappingHintGroupType).targetMMSection
		 *         else
		 *           self.affectedReference.getContainingSection() =
		 *           self.oclContainer()
		 *           .oclAsType(MappingHintGroupImporter).hintGroup.targetMMSection
		 *         endif
		 *       in
		 *         'MappingInstanceSelector::affectedReferenceMatchesSection'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@NonInvalid*/ IntegerValue severity_0 = ClassUtil.nonNullState(CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, MappingTables.STR_MappingInstanceSelector_c_c_affectedReferenceMatchesSection));
		final /*@NonInvalid*/ boolean le = ClassUtil.nonNullState(OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, severity_0, MappingTables.INT_0).booleanValue());
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		    try {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0 = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupType, null);
		        final /*@NonNull*/ /*@Thrown*/ TargetSectionNonContainmentReference affectedReference_0 = this.getAffectedReference();
		        final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, this);
		        final /*@NonNull*/ /*@Thrown*/ Object getContainingSection_0 = ((MetaModelElement)affectedReference_0).getContainingSection();
		        final /*@Thrown*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0).booleanValue());
		        /*@Thrown*/ boolean status;
		        if (oclIsKindOf) {
		            final /*@NonNull*/ /*@Thrown*/ MappingHintGroupType oclAsType = ClassUtil.nonNullState((MappingHintGroupType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0));
		            final /*@NonNull*/ /*@Thrown*/ TargetSectionClass targetMMSection = oclAsType.getTargetMMSection();
		            final /*@Thrown*/ boolean eq = getContainingSection_0.equals(targetMMSection);
		            status = eq;
		        }
		        else {
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupImporter = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupImporter, null);
		            final /*@NonNull*/ /*@Thrown*/ MappingHintGroupImporter oclAsType_0 = ClassUtil.nonNullState((MappingHintGroupImporter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupImporter));
		            final /*@NonNull*/ /*@Thrown*/ ExportedMappingHintGroup hintGroup = oclAsType_0.getHintGroup();
		            final /*@NonNull*/ /*@Thrown*/ TargetSectionClass targetMMSection_0 = hintGroup.getTargetMMSection();
		            final /*@Thrown*/ boolean eq_0 = getContainingSection_0.equals(targetMMSection_0);
		            status = eq_0;
		        }
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MappingTables.STR_MappingInstanceSelector_c_c_affectedReferenceMatchesSection, this, null, diagnostics, context, null, severity_0, CAUGHT_status, MappingTables.INT_0).booleanValue());
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean affectedReferenceIsNonContainment(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv affectedReferenceIsNonContainment:
		 *   let
		 *     severity : Integer[1] = 'MappingInstanceSelector::affectedReferenceIsNonContainment'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[?] = not self.affectedReference.eReference.oclAsType(ecore::EReference).containment
		 *       in
		 *         'MappingInstanceSelector::affectedReferenceIsNonContainment'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@NonInvalid*/ IntegerValue severity_0 = ClassUtil.nonNullState(CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, MappingTables.STR_MappingInstanceSelector_c_c_affectedReferenceIsNonContainment));
		final /*@NonInvalid*/ boolean le = ClassUtil.nonNullState(OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, severity_0, MappingTables.INT_0).booleanValue());
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    /*@Nullable*/ /*@Caught*/ Object CAUGHT_status;
		    try {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_ecore_c_c_EReference = idResolver.getClass(MappingTables.CLSSid_EReference, null);
		        final /*@NonNull*/ /*@Thrown*/ TargetSectionNonContainmentReference affectedReference = this.getAffectedReference();
		        final /*@NonNull*/ /*@Thrown*/ EReference eReference = affectedReference.getEReference();
		        final /*@NonNull*/ /*@Thrown*/ EReference oclAsType = ClassUtil.nonNullState((EReference)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, eReference, TYP_ecore_c_c_EReference));
		        final /*@Nullable*/ /*@Thrown*/ Boolean containment = oclAsType.isContainment();
		        final /*@Nullable*/ /*@Thrown*/ Boolean status = BooleanNotOperation.INSTANCE.evaluate(containment);
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MappingTables.STR_MappingInstanceSelector_c_c_affectedReferenceIsNonContainment, this, null, diagnostics, context, null, severity_0, CAUGHT_status, MappingTables.INT_0).booleanValue());
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER:
				return basicSetMatcher(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE:
				if (resolve) return getAffectedReference();
				return basicGetAffectedReference();
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER:
				return getMatcher();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE:
				setAffectedReference((TargetSectionNonContainmentReference)newValue);
				return;
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER:
				setMatcher((Matcher)newValue);
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
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE:
				setAffectedReference((TargetSectionNonContainmentReference)null);
				return;
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER:
				setMatcher((Matcher)null);
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
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE:
				return affectedReference != null;
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER:
				return matcher != null;
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
			case MappingPackage.MAPPING_INSTANCE_SELECTOR___AFFECTED_REFERENCE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP_3:
				return affectedReferenceMatchesSection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MappingPackage.MAPPING_INSTANCE_SELECTOR___AFFECTED_REFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP_3:
				return affectedReferenceIsNonContainment((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //MappingInstanceSelectorImpl
