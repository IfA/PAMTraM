/**
 */
package pamtram.mapping.extended.impl;

import java.lang.reflect.InvocationTargetException;
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
import org.eclipse.emf.ecore.util.EcoreEList;
import pamtram.ConditionModel;
import pamtram.ConditionalElement;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.extended.AttributeMappingSourceInterface;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.GlobalAttributeImporter;
import pamtram.mapping.extended.MappingHintSourceInterface;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.constraint.ValueConstraintSourceInterface;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.util.PamtramValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Variable Importer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.impl.GlobalAttributeImporterImpl#getLocalCondition <em>Local Condition</em>}</li>
 *   <li>{@link pamtram.mapping.extended.impl.GlobalAttributeImporterImpl#getSharedCondition <em>Shared Condition</em>}</li>
 *   <li>{@link pamtram.mapping.extended.impl.GlobalAttributeImporterImpl#getAllConditions <em>All Conditions</em>}</li>
 *   <li>{@link pamtram.mapping.extended.impl.GlobalAttributeImporterImpl#getGlobalAttribute <em>Global Attribute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GlobalAttributeImporterImpl extends NamedElementImpl implements GlobalAttributeImporter {
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
	 * The cached value of the '{@link #getGlobalAttribute() <em>Global Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalAttribute()
	 * @generated
	 * @ordered
	 */
	protected GlobalAttribute globalAttribute;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalAttributeImporterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtendedPackage.Literals.GLOBAL_ATTRIBUTE_IMPORTER;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__LOCAL_CONDITION, oldLocalCondition, newLocalCondition);
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
				msgs = ((InternalEObject)localCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__LOCAL_CONDITION, null, msgs);
			if (newLocalCondition != null)
				msgs = ((InternalEObject)newLocalCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__LOCAL_CONDITION, null, msgs);
			msgs = basicSetLocalCondition(newLocalCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__LOCAL_CONDITION, newLocalCondition, newLocalCondition));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__SHARED_CONDITION, oldSharedCondition, sharedCondition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__SHARED_CONDITION, oldSharedCondition, sharedCondition));
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalAttribute getGlobalAttribute() {
		if (globalAttribute != null && globalAttribute.eIsProxy()) {
			InternalEObject oldGlobalAttribute = (InternalEObject)globalAttribute;
			globalAttribute = (GlobalAttribute)eResolveProxy(oldGlobalAttribute);
			if (globalAttribute != oldGlobalAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE, oldGlobalAttribute, globalAttribute));
			}
		}
		return globalAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalAttribute basicGetGlobalAttribute() {
		return globalAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalAttributeGen(GlobalAttribute newGlobalAttribute) {
		GlobalAttribute oldGlobalAttribute = globalAttribute;
		globalAttribute = newGlobalAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE, oldGlobalAttribute, globalAttribute));
	}
	
	
	/**
	 * Before setting the {@link newGlobalAttribute}, update the name.
	 */
	@Override
	public void setGlobalAttribute(GlobalAttribute newGlobalAttribute) {
		setNameDerived(globalAttribute, newGlobalAttribute, null, null);
		setGlobalAttributeGen(newGlobalAttribute);
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
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__LOCAL_CONDITION:
				return basicSetLocalCondition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public void setValue(String newValue) {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public ActualSourceSectionAttribute getSourceAttribute() {
		if(this.getGlobalAttribute() == null){
			return null;
		} else {
			return this.getGlobalAttribute().getSource();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__LOCAL_CONDITION:
				return getLocalCondition();
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__SHARED_CONDITION:
				if (resolve) return getSharedCondition();
				return basicGetSharedCondition();
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__ALL_CONDITIONS:
				return getAllConditions();
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE:
				if (resolve) return getGlobalAttribute();
				return basicGetGlobalAttribute();
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
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__LOCAL_CONDITION:
				setLocalCondition((ComplexCondition)newValue);
				return;
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__SHARED_CONDITION:
				setSharedCondition((ComplexCondition)newValue);
				return;
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE:
				setGlobalAttribute((GlobalAttribute)newValue);
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
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__LOCAL_CONDITION:
				setLocalCondition((ComplexCondition)null);
				return;
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__SHARED_CONDITION:
				setSharedCondition((ComplexCondition)null);
				return;
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE:
				setGlobalAttribute((GlobalAttribute)null);
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
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__LOCAL_CONDITION:
				return localCondition != null;
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__SHARED_CONDITION:
				return sharedCondition != null;
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__ALL_CONDITIONS:
				return !getAllConditions().isEmpty();
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE:
				return globalAttribute != null;
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
				case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__LOCAL_CONDITION: return PamtramPackage.CONDITIONAL_ELEMENT__LOCAL_CONDITION;
				case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__SHARED_CONDITION: return PamtramPackage.CONDITIONAL_ELEMENT__SHARED_CONDITION;
				case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__ALL_CONDITIONS: return PamtramPackage.CONDITIONAL_ELEMENT__ALL_CONDITIONS;
				default: return -1;
			}
		}
		if (baseClass == MappingHintSourceInterface.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AttributeMappingSourceInterface.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == InstanceSelectorSourceInterface.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ValueConstraintSourceInterface.class) {
			switch (derivedFeatureID) {
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
				case PamtramPackage.CONDITIONAL_ELEMENT__LOCAL_CONDITION: return ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__LOCAL_CONDITION;
				case PamtramPackage.CONDITIONAL_ELEMENT__SHARED_CONDITION: return ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__SHARED_CONDITION;
				case PamtramPackage.CONDITIONAL_ELEMENT__ALL_CONDITIONS: return ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER__ALL_CONDITIONS;
				default: return -1;
			}
		}
		if (baseClass == MappingHintSourceInterface.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AttributeMappingSourceInterface.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == InstanceSelectorSourceInterface.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ValueConstraintSourceInterface.class) {
			switch (baseFeatureID) {
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
				case PamtramPackage.CONDITIONAL_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP: return ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;
				default: return -1;
			}
		}
		if (baseClass == MappingHintSourceInterface.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == AttributeMappingSourceInterface.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == InstanceSelectorSourceInterface.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == ValueConstraintSourceInterface.class) {
			switch (baseOperationID) {
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP:
				return validateReferenceOnlyConditionsFromConditionModel((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //GlobalAttributeImporterImpl
