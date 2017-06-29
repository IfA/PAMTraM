/**
 */
package pamtram.mapping.extended.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
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

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.ExpressionElement;
import pamtram.ModifiableElement;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;
import pamtram.mapping.extended.AttributeMatcher;
import pamtram.mapping.extended.ExpandableHint;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.mapping.extended.util.ExtendedValidator;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.InstanceSelector;
import pamtram.structure.InstanceSelectorExternalSourceElement;
import pamtram.structure.InstanceSelectorSourceElement;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.StructurePackage;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.util.StructureValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Attribute Matcher</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.mapping.extended.impl.AttributeMatcherImpl#getExpression
 * <em>Expression</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.AttributeMatcherImpl#getModifiers
 * <em>Modifiers</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.AttributeMatcherImpl#getSourceElements
 * <em>Source Elements</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.AttributeMatcherImpl#getTarget
 * <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeMatcherImpl extends MatcherImpl implements AttributeMatcher {

	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected String expression = AttributeMatcherImpl.EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModifiers() <em>Modifiers</em>}'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getModifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueModifierSet> modifiers;

	/**
	 * The cached value of the '{@link #getSourceElements() <em>Source
	 * Elements</em>}' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #getSourceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceSelectorSourceInterface> sourceElements;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionAttribute target;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected AttributeMatcherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtendedPackage.Literals.ATTRIBUTE_MATCHER;
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
			this.eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.ATTRIBUTE_MATCHER__EXPRESSION,
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
					ExtendedPackage.ATTRIBUTE_MATCHER__MODIFIERS);
		}
		return this.modifiers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public TargetSectionAttribute getTarget() {
		if (this.target != null && this.target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject) this.target;
			this.target = (TargetSectionAttribute) this.eResolveProxy(oldTarget);
			if (this.target != oldTarget) {
				if (this.eNotificationRequired()) {
					this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExtendedPackage.ATTRIBUTE_MATCHER__TARGET, oldTarget, this.target));
				}
			}
		}
		return this.target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public TargetSectionAttribute basicGetTarget() {
		return this.target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setTarget(TargetSectionAttribute newTarget) {
		TargetSectionAttribute oldTarget = this.target;
		this.target = newTarget;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.ATTRIBUTE_MATCHER__TARGET,
					oldTarget, this.target));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<InstanceSelectorSourceInterface> getSourceElements() {
		if (this.sourceElements == null) {
			this.sourceElements = new EObjectContainmentEList<>(InstanceSelectorSourceInterface.class, this,
					ExtendedPackage.ATTRIBUTE_MATCHER__SOURCE_ELEMENTS);
		}
		return this.sourceElements;
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
	public boolean validateTargetMatchesAffectedReferenceType(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {

		if (!(this.eContainer() instanceof ReferenceTargetSelector)
				|| ((ReferenceTargetSelector) this.eContainer()).getAffectedReference() == null
				|| ((ReferenceTargetSelector) this.eContainer()).getAffectedReference().getEReference() == null
				|| this.getTarget() == null
				|| !(this.getTarget().eContainer() instanceof pamtram.structure.generic.Class<?, ?, ?, ?>)) {
			return true;
		}

		boolean result = true;
		String errorMessage = "";

		if (!this.getTarget().getContainingSection().isAbstract()) {
			result = ((ReferenceTargetSelector) this.eContainer()).getAffectedReference().getEReference()
					.getEReferenceType().isSuperTypeOf(
							((pamtram.structure.generic.Class<?, ?, ?, ?>) this.getTarget().eContainer()).getEClass());
			errorMessage = "The type of the class containing the target attribute ('"
					+ ((pamtram.structure.generic.Class<?, ?, ?, ?>) this.getTarget().eContainer()).getEClass()
							.getName()
					+ "') is not allowed by the affected reference of the parent ReferenceTargetSelector that "
					+ "requires a (sub-)type of '"
					+ ((pamtram.mapping.extended.ReferenceTargetSelector) this.eContainer()).getAffectedReference()
							.getEReference().getEReferenceType().getName()
					+ "'!";
		} else {
			PAMTraM pamtram = (PAMTraM) AgteleEcoreUtil.getAncestorOfType(this, PamtramPackage.Literals.PAM_TRA_M);
			List<TargetSection> concreteSections = pamtram.getTargetSections().stream()
					.filter(t -> t.getAllExtend().contains(this.getTarget().getContainingSection()))
					.collect(Collectors.toList());

			if (((pamtram.mapping.extended.ReferenceTargetSelector) this.eContainer()).getAffectedReference().getValue()
					.size() > 1) {
				result = false;
				errorMessage = "If AttributeMatchers are defined based on a target attribute in an abstract TargetSection, only one possible target value for the affected reference of the containing ReferenceTargetSelector must be specified!";
			} else if (((pamtram.mapping.extended.ReferenceTargetSelector) this.eContainer()).getAffectedReference()
					.getValue().isEmpty()) {
				if (!(this.target.eContainer() instanceof TargetSection)) {
					result = false;
					errorMessage = "If AttributeMatchers are defined based on a target attribute in an abstract TargetSection and no target value is specified for the affected reference of the containing ReferenceTargetSelector, the target attribute needs to be a direct child of this TargetSection!";
				} else {
					long possibleRedirectionTargets = concreteSections.stream()
							.filter(c -> ((pamtram.mapping.extended.ReferenceTargetSelector) this.eContainer())
									.getAffectedReference().getEReference().getEReferenceType()
									.isSuperTypeOf(c.getEClass()))
							.count();
					if (possibleRedirectionTargets > 1) {
						result = false;
						errorMessage = "If AttributeMatchers are defined based on a target attribute in an abstract TargetSection and there are multiple possible concrete (extending) TargetSections suitable for the affected reference of the containing ReferenceTargetSelector, a target value for the affected reference needs to be specified!";
					}
				}
			}

		}

		if (!result && diagnostics != null) {

			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ExtendedValidator.DIAGNOSTIC_SOURCE,
					ExtendedValidator.ATTRIBUTE_MATCHER__VALIDATE_TARGET_MATCHES_AFFECTED_REFERENCE_TYPE, errorMessage,
					new Object[] { this, ExtendedPackage.Literals.ATTRIBUTE_MATCHER__TARGET }));

		}

		return result;
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
						? this.getSourceElements().parallelStream()
								.noneMatch(s -> s instanceof pamtram.structure.DynamicSourceElement)
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ExtendedPackage.ATTRIBUTE_MATCHER__SOURCE_ELEMENTS:
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
		case ExtendedPackage.ATTRIBUTE_MATCHER__EXPRESSION:
			return this.getExpression();
		case ExtendedPackage.ATTRIBUTE_MATCHER__MODIFIERS:
			return this.getModifiers();
		case ExtendedPackage.ATTRIBUTE_MATCHER__SOURCE_ELEMENTS:
			return this.getSourceElements();
		case ExtendedPackage.ATTRIBUTE_MATCHER__TARGET:
			if (resolve) {
				return this.getTarget();
			}
			return this.basicGetTarget();
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
		case ExtendedPackage.ATTRIBUTE_MATCHER__EXPRESSION:
			this.setExpression((String) newValue);
			return;
		case ExtendedPackage.ATTRIBUTE_MATCHER__MODIFIERS:
			this.getModifiers().clear();
			this.getModifiers().addAll((Collection<? extends ValueModifierSet>) newValue);
			return;
		case ExtendedPackage.ATTRIBUTE_MATCHER__SOURCE_ELEMENTS:
			this.getSourceElements().clear();
			this.getSourceElements().addAll((Collection<? extends InstanceSelectorSourceInterface>) newValue);
			return;
		case ExtendedPackage.ATTRIBUTE_MATCHER__TARGET:
			this.setTarget((TargetSectionAttribute) newValue);
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
		case ExtendedPackage.ATTRIBUTE_MATCHER__EXPRESSION:
			this.setExpression(AttributeMatcherImpl.EXPRESSION_EDEFAULT);
			return;
		case ExtendedPackage.ATTRIBUTE_MATCHER__MODIFIERS:
			this.getModifiers().clear();
			return;
		case ExtendedPackage.ATTRIBUTE_MATCHER__SOURCE_ELEMENTS:
			this.getSourceElements().clear();
			return;
		case ExtendedPackage.ATTRIBUTE_MATCHER__TARGET:
			this.setTarget((TargetSectionAttribute) null);
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
		case ExtendedPackage.ATTRIBUTE_MATCHER__EXPRESSION:
			return AttributeMatcherImpl.EXPRESSION_EDEFAULT == null ? this.expression != null
					: !AttributeMatcherImpl.EXPRESSION_EDEFAULT.equals(this.expression);
		case ExtendedPackage.ATTRIBUTE_MATCHER__MODIFIERS:
			return this.modifiers != null && !this.modifiers.isEmpty();
		case ExtendedPackage.ATTRIBUTE_MATCHER__SOURCE_ELEMENTS:
			return this.sourceElements != null && !this.sourceElements.isEmpty();
		case ExtendedPackage.ATTRIBUTE_MATCHER__TARGET:
			return this.target != null;
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
		if (baseClass == ExpandableHint.class) {
			switch (derivedFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == ExpressionElement.class) {
			switch (derivedFeatureID) {
			case ExtendedPackage.ATTRIBUTE_MATCHER__EXPRESSION:
				return PamtramPackage.EXPRESSION_ELEMENT__EXPRESSION;
			default:
				return -1;
			}
		}
		if (baseClass == ModifiableElement.class) {
			switch (derivedFeatureID) {
			case ExtendedPackage.ATTRIBUTE_MATCHER__MODIFIERS:
				return PamtramPackage.MODIFIABLE_ELEMENT__MODIFIERS;
			default:
				return -1;
			}
		}
		if (baseClass == InstanceSelector.class) {
			switch (derivedFeatureID) {
			case ExtendedPackage.ATTRIBUTE_MATCHER__SOURCE_ELEMENTS:
				return StructurePackage.INSTANCE_SELECTOR__SOURCE_ELEMENTS;
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
		if (baseClass == ExpandableHint.class) {
			switch (baseFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == ExpressionElement.class) {
			switch (baseFeatureID) {
			case PamtramPackage.EXPRESSION_ELEMENT__EXPRESSION:
				return ExtendedPackage.ATTRIBUTE_MATCHER__EXPRESSION;
			default:
				return -1;
			}
		}
		if (baseClass == ModifiableElement.class) {
			switch (baseFeatureID) {
			case PamtramPackage.MODIFIABLE_ELEMENT__MODIFIERS:
				return ExtendedPackage.ATTRIBUTE_MATCHER__MODIFIERS;
			default:
				return -1;
			}
		}
		if (baseClass == InstanceSelector.class) {
			switch (baseFeatureID) {
			case StructurePackage.INSTANCE_SELECTOR__SOURCE_ELEMENTS:
				return ExtendedPackage.ATTRIBUTE_MATCHER__SOURCE_ELEMENTS;
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
		if (baseClass == ExpandableHint.class) {
			switch (baseOperationID) {
			default:
				return -1;
			}
		}
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
				return ExtendedPackage.ATTRIBUTE_MATCHER___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP;
			case StructurePackage.INSTANCE_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS:
				return ExtendedPackage.ATTRIBUTE_MATCHER___GET_LOCAL_SOURCE_ELEMENTS;
			case StructurePackage.INSTANCE_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS:
				return ExtendedPackage.ATTRIBUTE_MATCHER___GET_EXTERNAL_SOURCE_ELEMENTS;
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case ExtendedPackage.ATTRIBUTE_MATCHER___VALIDATE_TARGET_MATCHES_AFFECTED_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP:
			return this.validateTargetMatchesAffectedReferenceType((DiagnosticChain) arguments.get(0),
					(Map<?, ?>) arguments.get(1));
		case ExtendedPackage.ATTRIBUTE_MATCHER___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP:
			return this.validateNoModifiedAttributeElementTypesInConditionModelConditions(
					(DiagnosticChain) arguments.get(0), (Map<?, ?>) arguments.get(1));
		case ExtendedPackage.ATTRIBUTE_MATCHER___GET_LOCAL_SOURCE_ELEMENTS:
			return this.getLocalSourceElements();
		case ExtendedPackage.ATTRIBUTE_MATCHER___GET_EXTERNAL_SOURCE_ELEMENTS:
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

} // AttributeMatcherImpl
