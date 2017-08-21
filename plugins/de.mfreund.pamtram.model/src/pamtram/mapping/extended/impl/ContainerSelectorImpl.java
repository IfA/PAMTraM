/**
 */
package pamtram.mapping.extended.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.ExpressionElement;
import pamtram.ModifiableElement;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.util.ExtendedValidator;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.InstanceSelector;
import pamtram.structure.InstanceSelectorExternalSourceElement;
import pamtram.structure.InstanceSelectorSourceElement;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.StructurePackage;
import pamtram.structure.TargetInstanceSelector;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.util.StructureValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Connection Hint</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.mapping.extended.impl.ContainerSelectorImpl#getExpression <em>Expression</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.ContainerSelectorImpl#getModifiers <em>Modifiers</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.ContainerSelectorImpl#getSourceElements <em>Source Elements</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.ContainerSelectorImpl#getReferenceAttribute <em>Reference
 * Attribute</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.ContainerSelectorImpl#getTargetClass <em>Target Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContainerSelectorImpl extends MappingHintImpl implements ContainerSelector {

	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected String expression = ContainerSelectorImpl.EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModifiers() <em>Modifiers</em>}' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getModifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueModifierSet> modifiers;

	/**
	 * The cached value of the '{@link #getSourceElements() <em>Source Elements</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSourceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceSelectorSourceInterface> sourceElements;

	/**
	 * The cached value of the '{@link #getReferenceAttribute() <em>Reference Attribute</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferenceAttribute()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionAttribute referenceAttribute;

	/**
	 * The cached value of the '{@link #getTargetClass() <em>Target Class</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTargetClass()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionClass targetClass;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ContainerSelectorImpl() {

		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return ExtendedPackage.Literals.CONTAINER_SELECTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getExpression() {

		return this.expression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setExpression(String newExpression) {

		String oldExpression = this.expression;
		this.expression = newExpression;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.CONTAINER_SELECTOR__EXPRESSION,
					oldExpression, this.expression));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<ValueModifierSet> getModifiers() {

		if (this.modifiers == null) {
			this.modifiers = new EObjectResolvingEList<>(ValueModifierSet.class, this,
					ExtendedPackage.CONTAINER_SELECTOR__MODIFIERS);
		}
		return this.modifiers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean validateNoModifiedAttributeElementTypesInConditionModelConditions(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {

		boolean result = this.eContainer() instanceof ComplexCondition
				&& ((ComplexCondition) this.eContainer()).isConditionModelCondition()
						? this.getSourceElements().parallelStream().noneMatch(
								s -> s instanceof pamtram.structure.DynamicSourceElement)
						: true;

		if (!result && diagnostics != null) {

			String errorMessage = "ModifiedAttributeElementTypes are not allowed as part of ConditionModelConditions!";

			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, StructureValidator.DIAGNOSTIC_SOURCE,
					StructureValidator.INSTANCE_SELECTOR__VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS,
					errorMessage, new Object[] { this, StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS }));

		}

		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<InstanceSelectorSourceInterface> getSourceElements() {

		if (this.sourceElements == null) {
			this.sourceElements = new EObjectContainmentEList<>(
					InstanceSelectorSourceInterface.class, this, ExtendedPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS);
		}
		return this.sourceElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public TargetSectionAttribute getReferenceAttribute() {

		if (this.referenceAttribute != null && this.referenceAttribute.eIsProxy()) {
			InternalEObject oldReferenceAttribute = (InternalEObject) this.referenceAttribute;
			this.referenceAttribute = (TargetSectionAttribute) this.eResolveProxy(oldReferenceAttribute);
			if (this.referenceAttribute != oldReferenceAttribute) {
				if (this.eNotificationRequired()) {
					this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExtendedPackage.CONTAINER_SELECTOR__REFERENCE_ATTRIBUTE, oldReferenceAttribute,
							this.referenceAttribute));
				}
			}
		}
		return this.referenceAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TargetSectionAttribute basicGetReferenceAttribute() {

		return this.referenceAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setReferenceAttribute(TargetSectionAttribute newReferenceAttribute) {

		TargetSectionAttribute oldReferenceAttribute = this.referenceAttribute;
		this.referenceAttribute = newReferenceAttribute;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET,
					ExtendedPackage.CONTAINER_SELECTOR__REFERENCE_ATTRIBUTE, oldReferenceAttribute,
					this.referenceAttribute));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public TargetSectionClass getTargetClass() {

		if (this.targetClass != null && this.targetClass.eIsProxy()) {
			InternalEObject oldTargetClass = (InternalEObject) this.targetClass;
			this.targetClass = (TargetSectionClass) this.eResolveProxy(oldTargetClass);
			if (this.targetClass != oldTargetClass) {
				if (this.eNotificationRequired()) {
					this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExtendedPackage.CONTAINER_SELECTOR__TARGET_CLASS, oldTargetClass, this.targetClass));
				}
			}
		}
		return this.targetClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TargetSectionClass basicGetTargetClass() {

		return this.targetClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setTargetClass(TargetSectionClass newTargetClass) {

		TargetSectionClass oldTargetClass = this.targetClass;
		this.targetClass = newTargetClass;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.CONTAINER_SELECTOR__TARGET_CLASS,
					oldTargetClass, this.targetClass));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean validateTargetClassMatchesPossibleContainerType(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {

		if (!(this.eContainer().eContainer() instanceof MappingHintGroupType) || this.getTargetClass() == null) {
			return true;
		}

		TargetSection targetSection = ((MappingHintGroupType) this.eContainer().eContainer()).getTargetSection();

		boolean result = targetSection == null || targetSection.getEClass() == null ? true
				: this.getTargetClass().getEClass().getEAllContainments().parallelStream()
						.anyMatch(r -> r.getEReferenceType().isSuperTypeOf(targetSection.getEClass()));

		if (!result && diagnostics != null) {

			String errorMessage = "The type of the parent hint group's target section ('"
					+ targetSection.getEClass().getName()
					+ "') cannot be connected to (contained in) the specified target class ('"
					+ this.getTargetClass().getName() + "')!";

			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ExtendedValidator.DIAGNOSTIC_SOURCE,
					ExtendedValidator.CONTAINER_SELECTOR__VALIDATE_TARGET_CLASS_MATCHES_POSSIBLE_CONTAINER_TYPE,
					errorMessage,
					new Object[] { this, StructurePackage.Literals.TARGET_INSTANCE_SELECTOR__TARGET_CLASS }));

		}

		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<InstanceSelectorSourceElement> getLocalSourceElements() {

		return new BasicEList<>(
				this.getSourceElements().stream().filter(i -> i instanceof InstanceSelectorSourceElement)
						.map(i -> (InstanceSelectorSourceElement) i).collect(Collectors.toList()));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<InstanceSelectorExternalSourceElement> getExternalSourceElements() {

		return new BasicEList<>(
				this.getSourceElements().stream().filter(i -> i instanceof InstanceSelectorExternalSourceElement)
						.map(i -> (InstanceSelectorExternalSourceElement) i).collect(Collectors.toList()));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {

		switch (featureID) {
			case ExtendedPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS:
				return ((InternalEList<?>) this.getSourceElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case ExtendedPackage.CONTAINER_SELECTOR__EXPRESSION:
				return this.getExpression();
			case ExtendedPackage.CONTAINER_SELECTOR__MODIFIERS:
				return this.getModifiers();
			case ExtendedPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS:
				return this.getSourceElements();
			case ExtendedPackage.CONTAINER_SELECTOR__REFERENCE_ATTRIBUTE:
				if (resolve) {
					return this.getReferenceAttribute();
				}
				return this.basicGetReferenceAttribute();
			case ExtendedPackage.CONTAINER_SELECTOR__TARGET_CLASS:
				if (resolve) {
					return this.getTargetClass();
				}
				return this.basicGetTargetClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {

		switch (featureID) {
			case ExtendedPackage.CONTAINER_SELECTOR__EXPRESSION:
				this.setExpression((String) newValue);
				return;
			case ExtendedPackage.CONTAINER_SELECTOR__MODIFIERS:
				this.getModifiers().clear();
				this.getModifiers().addAll((Collection<? extends ValueModifierSet>) newValue);
				return;
			case ExtendedPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS:
				this.getSourceElements().clear();
				this.getSourceElements().addAll((Collection<? extends InstanceSelectorSourceInterface>) newValue);
				return;
			case ExtendedPackage.CONTAINER_SELECTOR__REFERENCE_ATTRIBUTE:
				this.setReferenceAttribute((TargetSectionAttribute) newValue);
				return;
			case ExtendedPackage.CONTAINER_SELECTOR__TARGET_CLASS:
				this.setTargetClass((TargetSectionClass) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {

		switch (featureID) {
			case ExtendedPackage.CONTAINER_SELECTOR__EXPRESSION:
				this.setExpression(ContainerSelectorImpl.EXPRESSION_EDEFAULT);
				return;
			case ExtendedPackage.CONTAINER_SELECTOR__MODIFIERS:
				this.getModifiers().clear();
				return;
			case ExtendedPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS:
				this.getSourceElements().clear();
				return;
			case ExtendedPackage.CONTAINER_SELECTOR__REFERENCE_ATTRIBUTE:
				this.setReferenceAttribute((TargetSectionAttribute) null);
				return;
			case ExtendedPackage.CONTAINER_SELECTOR__TARGET_CLASS:
				this.setTargetClass((TargetSectionClass) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {

		switch (featureID) {
			case ExtendedPackage.CONTAINER_SELECTOR__EXPRESSION:
				return ContainerSelectorImpl.EXPRESSION_EDEFAULT == null ? this.expression != null
						: !ContainerSelectorImpl.EXPRESSION_EDEFAULT.equals(this.expression);
			case ExtendedPackage.CONTAINER_SELECTOR__MODIFIERS:
				return this.modifiers != null && !this.modifiers.isEmpty();
			case ExtendedPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS:
				return this.sourceElements != null && !this.sourceElements.isEmpty();
			case ExtendedPackage.CONTAINER_SELECTOR__REFERENCE_ATTRIBUTE:
				return this.referenceAttribute != null;
			case ExtendedPackage.CONTAINER_SELECTOR__TARGET_CLASS:
				return this.targetClass != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {

		if (baseClass == ExpressionElement.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.CONTAINER_SELECTOR__EXPRESSION:
					return PamtramPackage.EXPRESSION_ELEMENT__EXPRESSION;
				default:
					return -1;
			}
		}
		if (baseClass == ModifiableElement.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.CONTAINER_SELECTOR__MODIFIERS:
					return PamtramPackage.MODIFIABLE_ELEMENT__MODIFIERS;
				default:
					return -1;
			}
		}
		if (baseClass == InstanceSelector.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS:
					return StructurePackage.INSTANCE_SELECTOR__SOURCE_ELEMENTS;
				default:
					return -1;
			}
		}
		if (baseClass == TargetInstanceSelector.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.CONTAINER_SELECTOR__REFERENCE_ATTRIBUTE:
					return StructurePackage.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE;
				case ExtendedPackage.CONTAINER_SELECTOR__TARGET_CLASS:
					return StructurePackage.TARGET_INSTANCE_SELECTOR__TARGET_CLASS;
				default:
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {

		if (baseClass == ExpressionElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.EXPRESSION_ELEMENT__EXPRESSION:
					return ExtendedPackage.CONTAINER_SELECTOR__EXPRESSION;
				default:
					return -1;
			}
		}
		if (baseClass == ModifiableElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.MODIFIABLE_ELEMENT__MODIFIERS:
					return ExtendedPackage.CONTAINER_SELECTOR__MODIFIERS;
				default:
					return -1;
			}
		}
		if (baseClass == InstanceSelector.class) {
			switch (baseFeatureID) {
				case StructurePackage.INSTANCE_SELECTOR__SOURCE_ELEMENTS:
					return ExtendedPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS;
				default:
					return -1;
			}
		}
		if (baseClass == TargetInstanceSelector.class) {
			switch (baseFeatureID) {
				case StructurePackage.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE:
					return ExtendedPackage.CONTAINER_SELECTOR__REFERENCE_ATTRIBUTE;
				case StructurePackage.TARGET_INSTANCE_SELECTOR__TARGET_CLASS:
					return ExtendedPackage.CONTAINER_SELECTOR__TARGET_CLASS;
				default:
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {

		if (baseClass == ExpressionElement.class) {
			switch (baseOperationID) {
				default:
					return -1;
			}
		}
		if (baseClass == ModifiableElement.class) {
			switch (baseOperationID) {
				default:
					return -1;
			}
		}
		if (baseClass == InstanceSelector.class) {
			switch (baseOperationID) {
				case StructurePackage.INSTANCE_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP:
					return ExtendedPackage.CONTAINER_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP;
				case StructurePackage.INSTANCE_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS:
					return ExtendedPackage.CONTAINER_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS;
				case StructurePackage.INSTANCE_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS:
					return ExtendedPackage.CONTAINER_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS;
				default:
					return -1;
			}
		}
		if (baseClass == TargetInstanceSelector.class) {
			switch (baseOperationID) {
				default:
					return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {

		switch (operationID) {
			case ExtendedPackage.CONTAINER_SELECTOR___VALIDATE_TARGET_CLASS_MATCHES_POSSIBLE_CONTAINER_TYPE__DIAGNOSTICCHAIN_MAP:
				return this.validateTargetClassMatchesPossibleContainerType((DiagnosticChain) arguments.get(0),
						(Map<?, ?>) arguments.get(1));
			case ExtendedPackage.CONTAINER_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP:
				return this.validateNoModifiedAttributeElementTypesInConditionModelConditions(
						(DiagnosticChain) arguments.get(0), (Map<?, ?>) arguments.get(1));
			case ExtendedPackage.CONTAINER_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS:
				return this.getLocalSourceElements();
			case ExtendedPackage.CONTAINER_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS:
				return this.getExternalSourceElements();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {

		if (this.eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (expression: ");
		result.append(this.expression);
		result.append(')');
		return result.toString();
	}

} // ModelConnectionHintImpl
