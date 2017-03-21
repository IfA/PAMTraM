/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import pamtram.ConditionModel;
import pamtram.ConditionalElement;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.util.MappingValidator;
import pamtram.util.PamtramValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.MappingImpl#getLocalCondition <em>Local Condition</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingImpl#getSharedCondition <em>Shared Condition</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingImpl#getMappingHintGroups <em>Mapping Hint Groups</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingImpl#getImportedMappingHintGroups <em>Imported Mapping Hint Groups</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingImpl#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingImpl extends MappingTypeImpl implements Mapping {
	/**
	 * The cached value of the '{@link #getLocalCondition() <em>Local Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalCondition()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition localCondition;

	/**
	 * The cached value of the '{@link #getSharedCondition() <em>Shared Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedCondition()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition sharedCondition;

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
	public ComplexCondition getLocalCondition() {
		return localCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocalCondition(ComplexCondition newLocalCondition, NotificationChain msgs) {
		ComplexCondition oldLocalCondition = localCondition;
		localCondition = newLocalCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING__LOCAL_CONDITION, oldLocalCondition, newLocalCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalCondition(ComplexCondition newLocalCondition) {
		if (newLocalCondition != localCondition) {
			NotificationChain msgs = null;
			if (localCondition != null)
				msgs = ((InternalEObject)localCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING__LOCAL_CONDITION, null, msgs);
			if (newLocalCondition != null)
				msgs = ((InternalEObject)newLocalCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING__LOCAL_CONDITION, null, msgs);
			msgs = basicSetLocalCondition(newLocalCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING__LOCAL_CONDITION, newLocalCondition, newLocalCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexCondition getSharedCondition() {
		if (sharedCondition != null && sharedCondition.eIsProxy()) {
			InternalEObject oldSharedCondition = (InternalEObject)sharedCondition;
			sharedCondition = (ComplexCondition)eResolveProxy(oldSharedCondition);
			if (sharedCondition != oldSharedCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING__SHARED_CONDITION, oldSharedCondition, sharedCondition));
			}
		}
		return sharedCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexCondition basicGetSharedCondition() {
		return sharedCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSharedCondition(ComplexCondition newSharedCondition) {
		ComplexCondition oldSharedCondition = sharedCondition;
		sharedCondition = newSharedCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING__SHARED_CONDITION, oldSharedCondition, sharedCondition));
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
	public boolean validateContainsHintGroups(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = !this.getMappingHintGroups().isEmpty();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The mapping does not contain any hint groups!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.WARNING,
					MappingValidator.DIAGNOSTIC_SOURCE,
							MappingValidator.MAPPING__VALIDATE_CONTAINS_HINT_GROUPS,
							errorMessage,
					new Object[] { this, MappingPackage.Literals.MAPPING }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainsDeactivatedHintGroups(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = this.isDeactivated() ? this.getMappingHintGroups().size() == this.getActiveMappingHintGroups().size() && this.getImportedMappingHintGroups().size() == this.getActiveImportedMappingHintGroups().size() : true;
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The mapping contains deactivated hint groups that will not be used in a transformation!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.WARNING,
					MappingValidator.DIAGNOSTIC_SOURCE,
							MappingValidator.MAPPING__VALIDATE_CONTAINS_DEACTIVATED_HINT_GROUPS,
							errorMessage,
					new Object[] { this, MappingPackage.Literals.MAPPING }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEitherModelOrReferCondition(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = !(this.getLocalCondition() != null && this.getSharedCondition() != null);
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "Please specify at most one (local or shared) condition!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					PamtramValidator.DIAGNOSTIC_SOURCE,
							PamtramValidator.CONDITIONAL_ELEMENT__VALIDATE_EITHER_MODEL_OR_REFER_CONDITION,
							errorMessage,
					new Object[] { this, PamtramPackage.Literals.CONDITIONAL_ELEMENT }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceOnlyConditionsFromConditionModel(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = this.getSharedCondition() == null || this.getSharedCondition().eContainer() instanceof ConditionModel;
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "It is only allowed to reference shared conditions that are model inside the ConditionModel!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					PamtramValidator.DIAGNOSTIC_SOURCE,
							PamtramValidator.CONDITIONAL_ELEMENT__VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL,
							errorMessage,
					new Object[] { this, PamtramPackage.Literals.CONDITIONAL_ELEMENT__SHARED_CONDITION }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.MAPPING__LOCAL_CONDITION:
				return basicSetLocalCondition(null, msgs);
			case MappingPackage.MAPPING__MAPPING_HINT_GROUPS:
				return ((InternalEList<?>)getMappingHintGroups()).basicRemove(otherEnd, msgs);
			case MappingPackage.MAPPING__IMPORTED_MAPPING_HINT_GROUPS:
				return ((InternalEList<?>)getImportedMappingHintGroups()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.MAPPING__LOCAL_CONDITION:
				return getLocalCondition();
			case MappingPackage.MAPPING__SHARED_CONDITION:
				if (resolve) return getSharedCondition();
				return basicGetSharedCondition();
			case MappingPackage.MAPPING__MAPPING_HINT_GROUPS:
				return getMappingHintGroups();
			case MappingPackage.MAPPING__IMPORTED_MAPPING_HINT_GROUPS:
				return getImportedMappingHintGroups();
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
			case MappingPackage.MAPPING__LOCAL_CONDITION:
				setLocalCondition((ComplexCondition)newValue);
				return;
			case MappingPackage.MAPPING__SHARED_CONDITION:
				setSharedCondition((ComplexCondition)newValue);
				return;
			case MappingPackage.MAPPING__MAPPING_HINT_GROUPS:
				getMappingHintGroups().clear();
				getMappingHintGroups().addAll((Collection<? extends MappingHintGroupType>)newValue);
				return;
			case MappingPackage.MAPPING__IMPORTED_MAPPING_HINT_GROUPS:
				getImportedMappingHintGroups().clear();
				getImportedMappingHintGroups().addAll((Collection<? extends MappingHintGroupImporter>)newValue);
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
			case MappingPackage.MAPPING__LOCAL_CONDITION:
				setLocalCondition((ComplexCondition)null);
				return;
			case MappingPackage.MAPPING__SHARED_CONDITION:
				setSharedCondition((ComplexCondition)null);
				return;
			case MappingPackage.MAPPING__MAPPING_HINT_GROUPS:
				getMappingHintGroups().clear();
				return;
			case MappingPackage.MAPPING__IMPORTED_MAPPING_HINT_GROUPS:
				getImportedMappingHintGroups().clear();
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
			case MappingPackage.MAPPING__LOCAL_CONDITION:
				return localCondition != null;
			case MappingPackage.MAPPING__SHARED_CONDITION:
				return sharedCondition != null;
			case MappingPackage.MAPPING__MAPPING_HINT_GROUPS:
				return mappingHintGroups != null && !mappingHintGroups.isEmpty();
			case MappingPackage.MAPPING__IMPORTED_MAPPING_HINT_GROUPS:
				return importedMappingHintGroups != null && !importedMappingHintGroups.isEmpty();
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ConditionalElement.class) {
			switch (derivedFeatureID) {
				case MappingPackage.MAPPING__LOCAL_CONDITION: return PamtramPackage.CONDITIONAL_ELEMENT__LOCAL_CONDITION;
				case MappingPackage.MAPPING__SHARED_CONDITION: return PamtramPackage.CONDITIONAL_ELEMENT__SHARED_CONDITION;
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
		if (baseClass == ConditionalElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.CONDITIONAL_ELEMENT__LOCAL_CONDITION: return MappingPackage.MAPPING__LOCAL_CONDITION;
				case PamtramPackage.CONDITIONAL_ELEMENT__SHARED_CONDITION: return MappingPackage.MAPPING__SHARED_CONDITION;
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
		if (baseClass == ConditionalElement.class) {
			switch (baseOperationID) {
				case PamtramPackage.CONDITIONAL_ELEMENT___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP: return MappingPackage.MAPPING___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP;
				case PamtramPackage.CONDITIONAL_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP: return MappingPackage.MAPPING___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;
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
			case MappingPackage.MAPPING___GET_ACTIVE_MAPPING_HINT_GROUPS:
				return getActiveMappingHintGroups();
			case MappingPackage.MAPPING___GET_ACTIVE_IMPORTED_MAPPING_HINT_GROUPS:
				return getActiveImportedMappingHintGroups();
			case MappingPackage.MAPPING___VALIDATE_CONTAINS_HINT_GROUPS__DIAGNOSTICCHAIN_MAP:
				return validateContainsHintGroups((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MappingPackage.MAPPING___VALIDATE_CONTAINS_DEACTIVATED_HINT_GROUPS__DIAGNOSTICCHAIN_MAP:
				return validateContainsDeactivatedHintGroups((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MappingPackage.MAPPING___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP:
				return validateEitherModelOrReferCondition((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MappingPackage.MAPPING___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP:
				return validateReferenceOnlyConditionsFromConditionModel((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
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
