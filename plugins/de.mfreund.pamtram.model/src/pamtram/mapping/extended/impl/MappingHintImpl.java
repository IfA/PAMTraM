/**
 */
package pamtram.mapping.extended.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
import org.eclipse.emf.ecore.util.EcoreEList;

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.ConditionModel;
import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.mapping.extended.util.ExtendedValidator;
import pamtram.util.PamtramValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Hint</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.impl.MappingHintImpl#getLocalCondition <em>Local Condition</em>}</li>
 *   <li>{@link pamtram.mapping.extended.impl.MappingHintImpl#getSharedCondition <em>Shared Condition</em>}</li>
 *   <li>{@link pamtram.mapping.extended.impl.MappingHintImpl#getAllConditions <em>All Conditions</em>}</li>
 *   <li>{@link pamtram.mapping.extended.impl.MappingHintImpl#isDeactivated <em>Deactivated</em>}</li>
 *   <li>{@link pamtram.mapping.extended.impl.MappingHintImpl#getOverwrite <em>Overwrite</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MappingHintImpl extends MappingHintTypeImpl implements MappingHint {

	/**
	 * The cached value of the '{@link #getLocalCondition() <em>Local Condition</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getLocalCondition()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition localCondition;

	/**
	 * The cached value of the '{@link #getSharedCondition() <em>Shared Condition</em>}' reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getSharedCondition()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition sharedCondition;

	/**
	 * The default value of the '{@link #isDeactivated() <em>Deactivated</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isDeactivated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEACTIVATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeactivated() <em>Deactivated</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isDeactivated()
	 * @generated
	 * @ordered
	 */
	protected boolean deactivated = DEACTIVATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOverwrite() <em>Overwrite</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getOverwrite()
	 * @generated
	 * @ordered
	 */
	protected MappingHint overwrite;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingHintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtendedPackage.Literals.MAPPING_HINT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION, oldLocalCondition, newLocalCondition);
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
				msgs = ((InternalEObject)localCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION, null, msgs);
			if (newLocalCondition != null)
				msgs = ((InternalEObject)newLocalCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION, null, msgs);
			msgs = basicSetLocalCondition(newLocalCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION, newLocalCondition, newLocalCondition));
	
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtendedPackage.MAPPING_HINT__SHARED_CONDITION, oldSharedCondition, sharedCondition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.MAPPING_HINT__SHARED_CONDITION, oldSharedCondition, sharedCondition));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.MAPPING_HINT__DEACTIVATED, oldDeactivated, deactivated));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingHint getOverwrite() {
	
		  if (overwrite != null && overwrite.eIsProxy()) {
			InternalEObject oldOverwrite = (InternalEObject)overwrite;
			overwrite = (MappingHint)eResolveProxy(oldOverwrite);
			if (overwrite != oldOverwrite) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtendedPackage.MAPPING_HINT__OVERWRITE, oldOverwrite, overwrite));
			}
		}
		return overwrite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MappingHint basicGetOverwrite() {
		return overwrite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverwrite(MappingHint newOverwrite) {
	
		MappingHint oldOverwrite = overwrite;
		overwrite = newOverwrite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.MAPPING_HINT__OVERWRITE, oldOverwrite, overwrite));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateOverwritesValidMappingHint(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		if (this.overwrite == null) {
					return true;
				}
		
			boolean ret = true;
				String message = "";
		
			if (this.eClass() != this.overwrite.eClass()) {
					ret = false;
					message = "MappingHints must only overwrite MappingHints of the same type!";
				}
		
			if (((MappingHintGroupType) this.eContainer()).getExtend().isEmpty()
						|| ((MappingHintGroupType) this.eContainer()).getExtend().stream()
								.noneMatch(hg -> hg.getAllMappingHints().contains(this.overwrite))) {
					ret = false;
					message = "The overwritten MappingHint is not part of a MappingHintGroup that is extended by the HintGroup containing this MappingHint!";
				}
		
			if (this instanceof AttributeMapping
						&& ((AttributeMapping) this).getTarget() != ((AttributeMapping) this.overwrite).getTarget()) {
					ret = false;
					message = "An AttributeMapping must only overwrite another AttributeMapping pointing to the same TargetSectionAttribute!";
				} else if (this instanceof CardinalityMapping
						&& ((CardinalityMapping) this).getTarget() != ((CardinalityMapping) this.overwrite).getTarget()) {
					ret = false;
					message = "A CardinalityMapping must only overwrite another CardinalityMapping pointing to the same TargetSectionClass!";
				} else if (this instanceof ReferenceTargetSelector && ((ReferenceTargetSelector) this)
						.getAffectedReference() != ((ReferenceTargetSelector) this.overwrite).getAffectedReference()) {
					ret = false;
					message = "A ReferenceTargetSelector must only overwrite another ReferenceTargetSelector pointing to the same TargetSectionReference!";
				}
		
			if (!ret && diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ExtendedValidator.DIAGNOSTIC_SOURCE,
							ExtendedValidator.MAPPING_HINT__VALIDATE_OVERWRITES_VALID_MAPPING_HINT, message,
							new Object[] { this, ExtendedPackage.Literals.MAPPING_HINT__OVERWRITE }));
				}
		
			return ret;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateConsiderOverwritingHint(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		if (!(this.eContainer instanceof MappingHintGroupType) || this.overwrite != null) {
					return true;
				}
		
			List<MappingHint> hintsOfExtendedHintGroups = ((MappingHintGroupType) this.eContainer()).getExtend().stream()
						.flatMap(hg -> hg.getMappingHints().stream()).collect(Collectors.toList());
		
			if (hintsOfExtendedHintGroups.isEmpty()) {
					return true;
				}
		
			Optional<MappingHint> hintToConsider = Optional.empty();
		
			if (this instanceof AttributeMapping && ((AttributeMapping) this).getTarget() != null) {
		
				hintToConsider = hintsOfExtendedHintGroups.stream().filter(h -> h instanceof AttributeMapping)
							.filter(h -> ((AttributeMapping) this).getTarget().equals(((AttributeMapping) h).getTarget()))
							.findAny();
		
			} else if (this instanceof CardinalityMapping && ((CardinalityMapping) this).getTarget() != null) {
		
				hintToConsider = hintsOfExtendedHintGroups.stream().filter(h -> h instanceof CardinalityMapping)
							.filter(h -> ((CardinalityMapping) this).getTarget().equals(((CardinalityMapping) h).getTarget()))
							.findAny();
		
			} else if (this instanceof ReferenceTargetSelector
						&& ((ReferenceTargetSelector) this).getAffectedReference() != null) {
		
				hintToConsider = hintsOfExtendedHintGroups.stream().filter(h -> h instanceof ReferenceTargetSelector)
							.filter(h -> ((ReferenceTargetSelector) this).getAffectedReference()
									.equals(((ReferenceTargetSelector) h).getAffectedReference()))
							.findAny();
				}
		
			if (!hintToConsider.isPresent()) {
					return true;
				}
		
			String message = "The hint '" + hintToConsider.get().getName() + "' of the extended MappingHintGroup "
						+ (hintToConsider.get().eContainer() instanceof MappingHintGroupType
								? "'" + ((MappingHintGroupType) hintToConsider.get().eContainer()).getName() + "' "
								: "")
						+ "affects the same target element. Consider overwriting this hint instead of providing additional hint values...";
		
			if (diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, ExtendedValidator.DIAGNOSTIC_SOURCE,
							ExtendedValidator.MAPPING_HINT__VALIDATE_CONSIDER_OVERWRITING_HINT, message,
							new Object[] { this, ExtendedPackage.Literals.MAPPING_HINT__OVERWRITE }));
				}
		
			return false;	
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
			case ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION:
				return basicSetLocalCondition(null, msgs);
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
			case ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION:
				return getLocalCondition();
			case ExtendedPackage.MAPPING_HINT__SHARED_CONDITION:
				if (resolve) return getSharedCondition();
				return basicGetSharedCondition();
			case ExtendedPackage.MAPPING_HINT__ALL_CONDITIONS:
				return getAllConditions();
			case ExtendedPackage.MAPPING_HINT__DEACTIVATED:
				return isDeactivated();
			case ExtendedPackage.MAPPING_HINT__OVERWRITE:
				if (resolve) return getOverwrite();
				return basicGetOverwrite();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION:
				setLocalCondition((ComplexCondition)newValue);
				return;
			case ExtendedPackage.MAPPING_HINT__SHARED_CONDITION:
				setSharedCondition((ComplexCondition)newValue);
				return;
			case ExtendedPackage.MAPPING_HINT__DEACTIVATED:
				setDeactivated((Boolean)newValue);
				return;
			case ExtendedPackage.MAPPING_HINT__OVERWRITE:
				setOverwrite((MappingHint)newValue);
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
			case ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION:
				setLocalCondition((ComplexCondition)null);
				return;
			case ExtendedPackage.MAPPING_HINT__SHARED_CONDITION:
				setSharedCondition((ComplexCondition)null);
				return;
			case ExtendedPackage.MAPPING_HINT__DEACTIVATED:
				setDeactivated(DEACTIVATED_EDEFAULT);
				return;
			case ExtendedPackage.MAPPING_HINT__OVERWRITE:
				setOverwrite((MappingHint)null);
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
			case ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION:
				return localCondition != null;
			case ExtendedPackage.MAPPING_HINT__SHARED_CONDITION:
				return sharedCondition != null;
			case ExtendedPackage.MAPPING_HINT__ALL_CONDITIONS:
				return !getAllConditions().isEmpty();
			case ExtendedPackage.MAPPING_HINT__DEACTIVATED:
				return deactivated != DEACTIVATED_EDEFAULT;
			case ExtendedPackage.MAPPING_HINT__OVERWRITE:
				return overwrite != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ConditionalElement.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION: return PamtramPackage.CONDITIONAL_ELEMENT__LOCAL_CONDITION;
				case ExtendedPackage.MAPPING_HINT__SHARED_CONDITION: return PamtramPackage.CONDITIONAL_ELEMENT__SHARED_CONDITION;
				case ExtendedPackage.MAPPING_HINT__ALL_CONDITIONS: return PamtramPackage.CONDITIONAL_ELEMENT__ALL_CONDITIONS;
				default: return -1;
			}
		}
		if (baseClass == DeactivatableElement.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.MAPPING_HINT__DEACTIVATED: return PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED;
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
		if (baseClass == ConditionalElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.CONDITIONAL_ELEMENT__LOCAL_CONDITION: return ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION;
				case PamtramPackage.CONDITIONAL_ELEMENT__SHARED_CONDITION: return ExtendedPackage.MAPPING_HINT__SHARED_CONDITION;
				case PamtramPackage.CONDITIONAL_ELEMENT__ALL_CONDITIONS: return ExtendedPackage.MAPPING_HINT__ALL_CONDITIONS;
				default: return -1;
			}
		}
		if (baseClass == DeactivatableElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED: return ExtendedPackage.MAPPING_HINT__DEACTIVATED;
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
		if (baseClass == ConditionalElement.class) {
			switch (baseOperationID) {
				case PamtramPackage.CONDITIONAL_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP: return ExtendedPackage.MAPPING_HINT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;
				default: return -1;
			}
		}
		if (baseClass == DeactivatableElement.class) {
			switch (baseOperationID) {
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
			case ExtendedPackage.MAPPING_HINT___VALIDATE_OVERWRITES_VALID_MAPPING_HINT__DIAGNOSTICCHAIN_MAP:
				return validateOverwritesValidMappingHint((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ExtendedPackage.MAPPING_HINT___VALIDATE_CONSIDER_OVERWRITING_HINT__DIAGNOSTICCHAIN_MAP:
				return validateConsiderOverwritingHint((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ExtendedPackage.MAPPING_HINT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP:
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

	@Override
	public String printInfo() {

		String mappingHintName = this.getName();
		MappingHintGroupType hintGroup = (MappingHintGroupType) AgteleEcoreUtil.getAncestorOfKind(this,
				MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE);
		Mapping mapping = (Mapping) AgteleEcoreUtil.getAncestorOfKind(this, MappingPackage.Literals.MAPPING);

		StringBuilder infoBuilder = new StringBuilder();
		infoBuilder.append(this.eClass().getName());
		if (mappingHintName != null) {
			infoBuilder.append(" '").append(mappingHintName).append("'");
		}

		if (hintGroup != null) {
			infoBuilder.append(" (HintGroup '").append(hintGroup.getName()).append("'");
		}
		if (mapping != null) {
			infoBuilder.append(" in Mapping '").append(mapping.getName()).append("')");
		} else {
			infoBuilder.append(")");
		}
		return infoBuilder.toString();
	}

} // MappingHintImpl
