/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingTables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.MappingImpl#getMappingHintGroups <em>Mapping Hint Groups</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingImpl#getImportedMappingHintGroups <em>Imported Mapping Hint Groups</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingImpl#getGlobalVariables <em>Global Variables</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingImpl#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingImpl extends MappingTypeImpl implements Mapping {
	/**
	 * The cached value of the '{@link #getMappingHintGroups() <em>Mapping Hint Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingHintGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingHintGroupType> mappingHintGroups;

	/**
	 * The cached value of the '{@link #getImportedMappingHintGroups() <em>Imported Mapping Hint Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedMappingHintGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingHintGroupImporter> importedMappingHintGroups;

	/**
	 * The cached value of the '{@link #getGlobalVariables() <em>Global Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<GlobalAttribute> globalVariables;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingHintGroupType> getMappingHintGroups() {
		if (mappingHintGroups == null) {
			mappingHintGroups = new EObjectContainmentEList<MappingHintGroupType>(MappingHintGroupType.class, this, MappingPackage.MAPPING__MAPPING_HINT_GROUPS);
		}
		return mappingHintGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingHintGroupImporter> getImportedMappingHintGroups() {
		if (importedMappingHintGroups == null) {
			importedMappingHintGroups = new EObjectContainmentEList<MappingHintGroupImporter>(MappingHintGroupImporter.class, this, MappingPackage.MAPPING__IMPORTED_MAPPING_HINT_GROUPS);
		}
		return importedMappingHintGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GlobalAttribute> getGlobalVariables() {
		if (globalVariables == null) {
			globalVariables = new EObjectContainmentEList<GlobalAttribute>(GlobalAttribute.class, this, MappingPackage.MAPPING__GLOBAL_VARIABLES);
		}
		return globalVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * This returns the active mappingHintGroups (the subset of the defined {@link #mappingHintGroups} 
	 * for that {@link InstantiableMappingHintGroup#isDeactivated()}) returns '<em>false</em>'.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingHintGroupType> getActiveMappingHintGroups() {
		EList<MappingHintGroupType> hintGroups = getMappingHintGroups();
		EList<MappingHintGroupType> activeHintGroups = new BasicEList<>();
		for (MappingHintGroupType hintGroup : hintGroups) {
			if(hintGroup instanceof InstantiableMappingHintGroup && 
					((InstantiableMappingHintGroup) hintGroup).isDeactivated()) {
				// skip this one
			} else {
				activeHintGroups.add(hintGroup);
			}
		}
		return activeHintGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingHintGroupImporter> getActiveImportedMappingHintGroups() {
		EList<MappingHintGroupImporter> hintGroups = getImportedMappingHintGroups();
		EList<MappingHintGroupImporter> activeHintGroups = new BasicEList<>();
		for (MappingHintGroupImporter hintGroup : hintGroups) {
			if(hintGroup.isDeactivated()) {
				// skip this one
			} else {
				activeHintGroups.add(hintGroup);
			}
		}
		return activeHintGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean containsHintGroups(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv containsHintGroups:
		 *   let severity : Integer[1] = 2
		 *   in
		 *     let status : OclAny[?] = not self.mappingHintGroups->isEmpty()
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The mapping does not contain any hint groups!'
		 *         else null
		 *         endif
		 *       in
		 *         'Mapping::containsHintGroups'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@Nullable*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@NonNull*/ /*@Thrown*/ List<MappingHintGroupType> mappingHintGroups = this.getMappingHintGroups();
		    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_mappingHintGroups = idResolver.createOrderedSetOfAll(MappingTables.ORD_CLSSid_MappingHintGroupType, mappingHintGroups);
		    final /*@Thrown*/ boolean isEmpty = ClassUtil.nonNullState(CollectionIsEmptyOperation.INSTANCE.evaluate(BOXED_mappingHintGroups).booleanValue());
		    final /*@Nullable*/ /*@Thrown*/ Boolean status = BooleanNotOperation.INSTANCE.evaluate(isEmpty);
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
		    message_0 = MappingTables.STR_The_32_mapping_32_does_32_not_32_contain_32_any_32_hint_32_groups_33;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MappingTables.STR_Mapping_c_c_containsHintGroups, this, null, diagnostics, context, message_0, MappingTables.INT_2, CAUGHT_status, MappingTables.INT_0).booleanValue());
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean containsDeactivatedHintGroups(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv containsDeactivatedHintGroups:
		 *   let severity : Integer[1] = 2
		 *   in
		 *     let
		 *       status : OclAny[?] = if self.deactivated = false
		 *       then
		 *         self.mappingHintGroups->size() =
		 *         self.getActiveMappingHintGroups()
		 *         ->size() and
		 *         self.importedMappingHintGroups->size() =
		 *         self.getActiveImportedMappingHintGroups()
		 *         ->size()
		 *       else true
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The mapping contains deactivated hint groups that will not be used in a transformation!'
		 *         else null
		 *         endif
		 *       in
		 *         'Mapping::containsDeactivatedHintGroups'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@Nullable*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    final /*@Thrown*/ boolean deactivated = this.isDeactivated();
		    final /*@Thrown*/ boolean eq = !deactivated;
		    /*@Nullable*/ /*@Thrown*/ Boolean status;
		    if (eq) {
		        /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final /*@NonNull*/ /*@Thrown*/ List<MappingHintGroupType> mappingHintGroups = this.getMappingHintGroups();
		            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_mappingHintGroups = idResolver.createOrderedSetOfAll(MappingTables.ORD_CLSSid_MappingHintGroupType, mappingHintGroups);
		            final /*@NonNull*/ /*@Thrown*/ IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_mappingHintGroups));
		            final /*@NonNull*/ /*@Thrown*/ List<MappingHintGroupType> getActiveMappingHintGroups = this.getActiveMappingHintGroups();
		            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_getActiveMappingHintGroups = idResolver.createOrderedSetOfAll(MappingTables.ORD_CLSSid_MappingHintGroupType, getActiveMappingHintGroups);
		            final /*@NonNull*/ /*@Thrown*/ IntegerValue size_0 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_getActiveMappingHintGroups));
		            final /*@Thrown*/ boolean eq_0 = size.equals(size_0);
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq_1;
		        try {
		            final /*@NonNull*/ /*@Thrown*/ List<MappingHintGroupImporter> importedMappingHintGroups = this.getImportedMappingHintGroups();
		            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_importedMappingHintGroups = idResolver.createOrderedSetOfAll(MappingTables.ORD_CLSSid_MappingHintGroupImporter, importedMappingHintGroups);
		            final /*@NonNull*/ /*@Thrown*/ IntegerValue size_1 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_importedMappingHintGroups));
		            final /*@NonNull*/ /*@Thrown*/ List<MappingHintGroupImporter> getActiveImportedMappingHintGroups = this.getActiveImportedMappingHintGroups();
		            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_getActiveImportedMappingHintGroups = idResolver.createOrderedSetOfAll(MappingTables.ORD_CLSSid_MappingHintGroupImporter, getActiveImportedMappingHintGroups);
		            final /*@NonNull*/ /*@Thrown*/ IntegerValue size_2 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_getActiveImportedMappingHintGroups));
		            final /*@Thrown*/ boolean eq_1 = size_1.equals(size_2);
		            CAUGHT_eq_1 = eq_1;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_1 = ValueUtil.createInvalidValue(e);
		        }
		        final /*@Nullable*/ /*@Thrown*/ Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_0, CAUGHT_eq_1);
		        status = and;
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
		    message_0 = MappingTables.STR_The_32_mapping_32_contains_32_deactivated_32_hint_32_groups_32_that_32_will_32_not_32_be_32_us;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MappingTables.STR_Mapping_c_c_containsDeactivatedHintGroups, this, null, diagnostics, context, message_0, MappingTables.INT_2, CAUGHT_status, MappingTables.INT_0).booleanValue());
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.MAPPING__MAPPING_HINT_GROUPS:
				return ((InternalEList<?>)getMappingHintGroups()).basicRemove(otherEnd, msgs);
			case MappingPackage.MAPPING__IMPORTED_MAPPING_HINT_GROUPS:
				return ((InternalEList<?>)getImportedMappingHintGroups()).basicRemove(otherEnd, msgs);
			case MappingPackage.MAPPING__GLOBAL_VARIABLES:
				return ((InternalEList<?>)getGlobalVariables()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.MAPPING__MAPPING_HINT_GROUPS:
				return getMappingHintGroups();
			case MappingPackage.MAPPING__IMPORTED_MAPPING_HINT_GROUPS:
				return getImportedMappingHintGroups();
			case MappingPackage.MAPPING__GLOBAL_VARIABLES:
				return getGlobalVariables();
			case MappingPackage.MAPPING__ABSTRACT:
				return isAbstract();
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
			case MappingPackage.MAPPING__MAPPING_HINT_GROUPS:
				getMappingHintGroups().clear();
				getMappingHintGroups().addAll((Collection<? extends MappingHintGroupType>)newValue);
				return;
			case MappingPackage.MAPPING__IMPORTED_MAPPING_HINT_GROUPS:
				getImportedMappingHintGroups().clear();
				getImportedMappingHintGroups().addAll((Collection<? extends MappingHintGroupImporter>)newValue);
				return;
			case MappingPackage.MAPPING__GLOBAL_VARIABLES:
				getGlobalVariables().clear();
				getGlobalVariables().addAll((Collection<? extends GlobalAttribute>)newValue);
				return;
			case MappingPackage.MAPPING__ABSTRACT:
				setAbstract((Boolean)newValue);
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
			case MappingPackage.MAPPING__MAPPING_HINT_GROUPS:
				getMappingHintGroups().clear();
				return;
			case MappingPackage.MAPPING__IMPORTED_MAPPING_HINT_GROUPS:
				getImportedMappingHintGroups().clear();
				return;
			case MappingPackage.MAPPING__GLOBAL_VARIABLES:
				getGlobalVariables().clear();
				return;
			case MappingPackage.MAPPING__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
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
			case MappingPackage.MAPPING__MAPPING_HINT_GROUPS:
				return mappingHintGroups != null && !mappingHintGroups.isEmpty();
			case MappingPackage.MAPPING__IMPORTED_MAPPING_HINT_GROUPS:
				return importedMappingHintGroups != null && !importedMappingHintGroups.isEmpty();
			case MappingPackage.MAPPING__GLOBAL_VARIABLES:
				return globalVariables != null && !globalVariables.isEmpty();
			case MappingPackage.MAPPING__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
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
			case MappingPackage.MAPPING___GET_ACTIVE_MAPPING_HINT_GROUPS:
				return getActiveMappingHintGroups();
			case MappingPackage.MAPPING___GET_ACTIVE_IMPORTED_MAPPING_HINT_GROUPS:
				return getActiveImportedMappingHintGroups();
			case MappingPackage.MAPPING___CONTAINS_HINT_GROUPS__DIAGNOSTICCHAIN_MAP_5:
				return containsHintGroups((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MappingPackage.MAPPING___CONTAINS_DEACTIVATED_HINT_GROUPS__DIAGNOSTICCHAIN_MAP_5:
				return containsDeactivatedHintGroups((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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

} //MappingImpl
