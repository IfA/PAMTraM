/**
 */
package pamtram.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.ConditionModel;
import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;
import pamtram.FixedValue;
import pamtram.MappingModel;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.util.PamtramValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Mapping
 * Model</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.impl.MappingModelImpl#isDeactivated <em>Deactivated</em>}</li>
 *   <li>{@link pamtram.impl.MappingModelImpl#getLocalCondition <em>Local Condition</em>}</li>
 *   <li>{@link pamtram.impl.MappingModelImpl#getSharedCondition <em>Shared Condition</em>}</li>
 *   <li>{@link pamtram.impl.MappingModelImpl#getAllConditions <em>All Conditions</em>}</li>
 *   <li>{@link pamtram.impl.MappingModelImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link pamtram.impl.MappingModelImpl#getModifierSets <em>Modifier Sets</em>}</li>
 *   <li>{@link pamtram.impl.MappingModelImpl#getGlobalValues <em>Global Values</em>}</li>
 *   <li>{@link pamtram.impl.MappingModelImpl#getActiveMappings <em>Active Mappings</em>}</li>
 *   <li>{@link pamtram.impl.MappingModelImpl#getGlobalAttributes <em>Global Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingModelImpl extends NamedElementImpl implements MappingModel {
	/**
	 * The default value of the '{@link #isDeactivated() <em>Deactivated</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDeactivated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEACTIVATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeactivated() <em>Deactivated</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDeactivated()
	 * @generated
	 * @ordered
	 */
	protected boolean deactivated = DEACTIVATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLocalCondition() <em>Local Condition</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getLocalCondition()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition localCondition;

	/**
	 * The cached value of the '{@link #getSharedCondition() <em>Shared Condition</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSharedCondition()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition sharedCondition;

	/**
	 * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> mappings;

	/**
	 * The cached value of the '{@link #getModifierSets() <em>Modifier Sets</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getModifierSets()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueModifierSet> modifierSets;

	/**
	 * The cached value of the '{@link #getGlobalValues() <em>Global Values</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getGlobalValues()
	 * @generated
	 * @ordered
	 */
	protected EList<FixedValue> globalValues;

	/**
	 * The cached value of the '{@link #getGlobalAttributes() <em>Global Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<GlobalAttribute> globalAttributes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PamtramPackage.Literals.MAPPING_MODEL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDeactivated() {
	
		return deactivated;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeactivated(boolean newDeactivated) {
	
		boolean oldDeactivated = deactivated;
		deactivated = newDeactivated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.MAPPING_MODEL__DEACTIVATED, oldDeactivated, deactivated));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComplexCondition getLocalCondition() {
	
		return localCondition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocalCondition(ComplexCondition newLocalCondition, NotificationChain msgs) {
		ComplexCondition oldLocalCondition = localCondition;
		localCondition = newLocalCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PamtramPackage.MAPPING_MODEL__LOCAL_CONDITION, oldLocalCondition, newLocalCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocalCondition(ComplexCondition newLocalCondition) {
	
		if (newLocalCondition != localCondition) {
			NotificationChain msgs = null;
			if (localCondition != null)
				msgs = ((InternalEObject)localCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.MAPPING_MODEL__LOCAL_CONDITION, null, msgs);
			if (newLocalCondition != null)
				msgs = ((InternalEObject)newLocalCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.MAPPING_MODEL__LOCAL_CONDITION, null, msgs);
			msgs = basicSetLocalCondition(newLocalCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.MAPPING_MODEL__LOCAL_CONDITION, newLocalCondition, newLocalCondition));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComplexCondition getSharedCondition() {
	
		  if (sharedCondition != null && sharedCondition.eIsProxy()) {
			InternalEObject oldSharedCondition = (InternalEObject)sharedCondition;
			sharedCondition = (ComplexCondition)eResolveProxy(oldSharedCondition);
			if (sharedCondition != oldSharedCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PamtramPackage.MAPPING_MODEL__SHARED_CONDITION, oldSharedCondition, sharedCondition));
			}
		}
		return sharedCondition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexCondition basicGetSharedCondition() {
		return sharedCondition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSharedCondition(ComplexCondition newSharedCondition) {
	
		ComplexCondition oldSharedCondition = sharedCondition;
		sharedCondition = newSharedCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.MAPPING_MODEL__SHARED_CONDITION, oldSharedCondition, sharedCondition));
	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComplexCondition> getAllConditions() {
	
		java.util.Set<Object> ret = new java.util.LinkedHashSet<>();
		
			if (this.getLocalCondition() != null) {
					ret.add(this.getLocalCondition());
				}
				if (this.getSharedCondition() != null) {
					ret.add(this.getSharedCondition());
				}
		
			if (this instanceof MappingHintGroup) {
					// Add Conditions of the Mappings of extended MappingHintGroups
					//
					ret.addAll(((MappingHintGroup) this).getExtend().stream().filter(hg -> hg.eContainer() instanceof pamtram.mapping.Mapping).flatMap(hg -> ((pamtram.mapping.Mapping) hg.eContainer()).getAllConditions().stream()).collect(Collectors.toSet()));
					// Add Conditions of extended MappingHintGroups
					//
					ret.addAll(((MappingHintGroup) this).getExtend().stream().filter(mhg -> mhg instanceof ConditionalElement)
							.flatMap(mhg -> ((ConditionalElement) mhg).getAllConditions().stream())
							.collect(Collectors.toSet()));
				}
		
			return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.CONDITIONAL_ELEMENT__ALL_CONDITIONS,
						ret.size(), ret.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Mapping> getMappings() {
	
		if (mappings == null) {
			mappings = new EObjectContainmentEList<Mapping>(Mapping.class, this, PamtramPackage.MAPPING_MODEL__MAPPINGS);
		}
		return mappings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValueModifierSet> getModifierSets() {
	
		if (modifierSets == null) {
			modifierSets = new EObjectContainmentEList<ValueModifierSet>(ValueModifierSet.class, this, PamtramPackage.MAPPING_MODEL__MODIFIER_SETS);
		}
		return modifierSets;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FixedValue> getGlobalValues() {
	
		if (globalValues == null) {
			globalValues = new EObjectContainmentEList<FixedValue>(FixedValue.class, this, PamtramPackage.MAPPING_MODEL__GLOBAL_VALUES);
		}
		return globalValues;
	}

	/**
	 * <!-- begin-user-doc --> This returns the active mappings (the subset of
	 * the defined mappings ({@link #mapping}) for that
	 * {@link Mapping#isDeactivated()} and {@link Mapping#isAbstract()} both
	 * return '<em>false</em>'). <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Mapping> getActiveMappings() {
	
		List<Mapping> mappings = this.getMappings().stream().filter(m -> !m.isDeactivated() && !m.isAbstract()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.MAPPING_MODEL__ACTIVE_MAPPINGS,
				mappings.size(), mappings.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GlobalAttribute> getGlobalAttributes() {
	
		if (globalAttributes == null) {
			globalAttributes = new EObjectContainmentEList<GlobalAttribute>(GlobalAttribute.class, this, PamtramPackage.MAPPING_MODEL__GLOBAL_ATTRIBUTES);
		}
		return globalAttributes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateReferenceOnlyConditionsFromConditionModel(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PamtramPackage.MAPPING_MODEL__LOCAL_CONDITION:
				return basicSetLocalCondition(null, msgs);
			case PamtramPackage.MAPPING_MODEL__MAPPINGS:
				return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
			case PamtramPackage.MAPPING_MODEL__MODIFIER_SETS:
				return ((InternalEList<?>)getModifierSets()).basicRemove(otherEnd, msgs);
			case PamtramPackage.MAPPING_MODEL__GLOBAL_VALUES:
				return ((InternalEList<?>)getGlobalValues()).basicRemove(otherEnd, msgs);
			case PamtramPackage.MAPPING_MODEL__GLOBAL_ATTRIBUTES:
				return ((InternalEList<?>)getGlobalAttributes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PamtramPackage.MAPPING_MODEL__DEACTIVATED:
				return isDeactivated();
			case PamtramPackage.MAPPING_MODEL__LOCAL_CONDITION:
				return getLocalCondition();
			case PamtramPackage.MAPPING_MODEL__SHARED_CONDITION:
				if (resolve) return getSharedCondition();
				return basicGetSharedCondition();
			case PamtramPackage.MAPPING_MODEL__ALL_CONDITIONS:
				return getAllConditions();
			case PamtramPackage.MAPPING_MODEL__MAPPINGS:
				return getMappings();
			case PamtramPackage.MAPPING_MODEL__MODIFIER_SETS:
				return getModifierSets();
			case PamtramPackage.MAPPING_MODEL__GLOBAL_VALUES:
				return getGlobalValues();
			case PamtramPackage.MAPPING_MODEL__ACTIVE_MAPPINGS:
				return getActiveMappings();
			case PamtramPackage.MAPPING_MODEL__GLOBAL_ATTRIBUTES:
				return getGlobalAttributes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PamtramPackage.MAPPING_MODEL__DEACTIVATED:
				setDeactivated((Boolean)newValue);
				return;
			case PamtramPackage.MAPPING_MODEL__LOCAL_CONDITION:
				setLocalCondition((ComplexCondition)newValue);
				return;
			case PamtramPackage.MAPPING_MODEL__SHARED_CONDITION:
				setSharedCondition((ComplexCondition)newValue);
				return;
			case PamtramPackage.MAPPING_MODEL__MAPPINGS:
				getMappings().clear();
				getMappings().addAll((Collection<? extends Mapping>)newValue);
				return;
			case PamtramPackage.MAPPING_MODEL__MODIFIER_SETS:
				getModifierSets().clear();
				getModifierSets().addAll((Collection<? extends ValueModifierSet>)newValue);
				return;
			case PamtramPackage.MAPPING_MODEL__GLOBAL_VALUES:
				getGlobalValues().clear();
				getGlobalValues().addAll((Collection<? extends FixedValue>)newValue);
				return;
			case PamtramPackage.MAPPING_MODEL__GLOBAL_ATTRIBUTES:
				getGlobalAttributes().clear();
				getGlobalAttributes().addAll((Collection<? extends GlobalAttribute>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PamtramPackage.MAPPING_MODEL__DEACTIVATED:
				setDeactivated(DEACTIVATED_EDEFAULT);
				return;
			case PamtramPackage.MAPPING_MODEL__LOCAL_CONDITION:
				setLocalCondition((ComplexCondition)null);
				return;
			case PamtramPackage.MAPPING_MODEL__SHARED_CONDITION:
				setSharedCondition((ComplexCondition)null);
				return;
			case PamtramPackage.MAPPING_MODEL__MAPPINGS:
				getMappings().clear();
				return;
			case PamtramPackage.MAPPING_MODEL__MODIFIER_SETS:
				getModifierSets().clear();
				return;
			case PamtramPackage.MAPPING_MODEL__GLOBAL_VALUES:
				getGlobalValues().clear();
				return;
			case PamtramPackage.MAPPING_MODEL__GLOBAL_ATTRIBUTES:
				getGlobalAttributes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PamtramPackage.MAPPING_MODEL__DEACTIVATED:
				return deactivated != DEACTIVATED_EDEFAULT;
			case PamtramPackage.MAPPING_MODEL__LOCAL_CONDITION:
				return localCondition != null;
			case PamtramPackage.MAPPING_MODEL__SHARED_CONDITION:
				return sharedCondition != null;
			case PamtramPackage.MAPPING_MODEL__ALL_CONDITIONS:
				return !getAllConditions().isEmpty();
			case PamtramPackage.MAPPING_MODEL__MAPPINGS:
				return mappings != null && !mappings.isEmpty();
			case PamtramPackage.MAPPING_MODEL__MODIFIER_SETS:
				return modifierSets != null && !modifierSets.isEmpty();
			case PamtramPackage.MAPPING_MODEL__GLOBAL_VALUES:
				return globalValues != null && !globalValues.isEmpty();
			case PamtramPackage.MAPPING_MODEL__ACTIVE_MAPPINGS:
				return !getActiveMappings().isEmpty();
			case PamtramPackage.MAPPING_MODEL__GLOBAL_ATTRIBUTES:
				return globalAttributes != null && !globalAttributes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DeactivatableElement.class) {
			switch (derivedFeatureID) {
				case PamtramPackage.MAPPING_MODEL__DEACTIVATED: return PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED;
				default: return -1;
			}
		}
		if (baseClass == ConditionalElement.class) {
			switch (derivedFeatureID) {
				case PamtramPackage.MAPPING_MODEL__LOCAL_CONDITION: return PamtramPackage.CONDITIONAL_ELEMENT__LOCAL_CONDITION;
				case PamtramPackage.MAPPING_MODEL__SHARED_CONDITION: return PamtramPackage.CONDITIONAL_ELEMENT__SHARED_CONDITION;
				case PamtramPackage.MAPPING_MODEL__ALL_CONDITIONS: return PamtramPackage.CONDITIONAL_ELEMENT__ALL_CONDITIONS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DeactivatableElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED: return PamtramPackage.MAPPING_MODEL__DEACTIVATED;
				default: return -1;
			}
		}
		if (baseClass == ConditionalElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.CONDITIONAL_ELEMENT__LOCAL_CONDITION: return PamtramPackage.MAPPING_MODEL__LOCAL_CONDITION;
				case PamtramPackage.CONDITIONAL_ELEMENT__SHARED_CONDITION: return PamtramPackage.MAPPING_MODEL__SHARED_CONDITION;
				case PamtramPackage.CONDITIONAL_ELEMENT__ALL_CONDITIONS: return PamtramPackage.MAPPING_MODEL__ALL_CONDITIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == DeactivatableElement.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == ConditionalElement.class) {
			switch (baseOperationID) {
				case PamtramPackage.CONDITIONAL_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP: return PamtramPackage.MAPPING_MODEL___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PamtramPackage.MAPPING_MODEL___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP:
				return validateReferenceOnlyConditionsFromConditionModel((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (deactivated: ");
		result.append(deactivated);
		result.append(')');
		return result.toString();
	}

} // MappingModelImpl
