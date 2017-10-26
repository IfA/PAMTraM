/**
 */
package pamtram.structure.constraint.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.ExpressionElement;
import pamtram.FixedValue;
import pamtram.ModifiableElement;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.Mapping;
import pamtram.mapping.extended.GlobalAttributeImporter;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.InstanceSelectorExternalSourceElement;
import pamtram.structure.InstanceSelectorSourceElement;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.constraint.ChoiceConstraint;
import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.SingleReferenceValueConstraint;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.constraint.ValueConstraintExternalSourceElement;
import pamtram.structure.constraint.ValueConstraintSourceElement;
import pamtram.structure.constraint.ValueConstraintSourceInterface;
import pamtram.structure.constraint.ValueConstraintType;
import pamtram.structure.constraint.util.ConstraintValidator;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Single Reference Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.constraint.impl.SingleReferenceValueConstraintImpl#getType <em>Type</em>}</li>
 *   <li>{@link pamtram.structure.constraint.impl.SingleReferenceValueConstraintImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link pamtram.structure.constraint.impl.SingleReferenceValueConstraintImpl#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link pamtram.structure.constraint.impl.SingleReferenceValueConstraintImpl#getSourceElements <em>Source Elements</em>}</li>
 *   <li>{@link pamtram.structure.constraint.impl.SingleReferenceValueConstraintImpl#getInstanceSelectors <em>Instance Selectors</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SingleReferenceValueConstraintImpl extends NamedElementImpl
		implements SingleReferenceValueConstraint {

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ValueConstraintType TYPE_EDEFAULT = ValueConstraintType.REQUIRED;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ValueConstraintType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected String expression = EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModifiers() <em>Modifiers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	protected EList<ValueConstraintSourceInterface> sourceElements;

	/**
	 * The cached value of the '{@link #getInstanceSelectors() <em>Instance Selectors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceSelectors()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceInstanceSelector> instanceSelectors;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleReferenceValueConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueConstraintType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(ValueConstraintType newType) {
		ValueConstraintType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExpression(String newExpression) {
		String oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValueModifierSet> getModifiers() {
		if (modifiers == null) {
			modifiers = new EObjectResolvingEList<ValueModifierSet>(ValueModifierSet.class, this, ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__MODIFIERS);
		}
		return modifiers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceInstanceSelector> getInstanceSelectors() {
		if (instanceSelectors == null) {
			instanceSelectors = new EObjectContainmentEList<SourceInstanceSelector>(SourceInstanceSelector.class, this, ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__INSTANCE_SELECTORS);
		}
		return instanceSelectors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValueConstraintSourceInterface> getSourceElements() {
		if (sourceElements == null) {
			sourceElements = new EObjectContainmentEList<ValueConstraintSourceInterface>(ValueConstraintSourceInterface.class, this, ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS);
		}
		return sourceElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean checkConstraint(String attrValue, String refValue) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateOnlyFixedValuesInSourceSections(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		if(this.getSourceElements().isEmpty() || 
				!AgteleEcoreUtil.hasAncestorOfKind(this, SourcePackage.eINSTANCE.getActualSourceSectionAttribute())) {
			return true;
		}
		
		boolean result = this.getSourceElements().parallelStream().allMatch(s -> s instanceof FixedValue);
		
		if (!result && diagnostics != null) {
			
			String errorMessage = "This ValueConstraint must only"
					+ " contain FixedValues as source elements as it is modeled as part of a SourceSection!'";
			
			diagnostics.add
				(new BasicDiagnostic
					(Diagnostic.ERROR,
					 ConstraintValidator.DIAGNOSTIC_SOURCE,
					ConstraintValidator.SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS,
					 errorMessage,
					 new Object [] { this,  ConstraintPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS }));
			}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateOnlyFixedValuesOrGlobalAttributesInConditionModel(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		if(this.getSourceElements().isEmpty() || 
				!AgteleEcoreUtil.hasAncestorOfKind(this, ConditionPackage.eINSTANCE.getComplexCondition())) {
			return true;
		}
		
		ComplexCondition condition = (ComplexCondition) AgteleEcoreUtil.getAncestorOfKind(this, ConditionPackage.eINSTANCE.getComplexCondition());
		
		if(!condition.isConditionModelCondition()) {
			return true;
		}
		
		boolean result = this.getSourceElements().parallelStream().allMatch(s -> s instanceof FixedValue || s instanceof GlobalAttributeImporter);
		
		if (!result && diagnostics != null) {
			
			String errorMessage = "This ValueConstraint must only"
					+ " contain FixedValues or GlobalAttributeImporters as source elements as it is modeled as part of a condition inside a ConditionModel!'";
			
			diagnostics.add
				(new BasicDiagnostic
					(Diagnostic.ERROR,
					 ConstraintValidator.DIAGNOSTIC_SOURCE,
					 ConstraintValidator.SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL,
					 errorMessage,
					 new Object [] { this,  ConstraintPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS }));
			}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isLocalConstraint() {
		if (this instanceof ChoiceConstraint) {
			return ((ChoiceConstraint) this).getChoices().stream().allMatch(ValueConstraint::isLocalConstraint);
		}
		
		if (AgteleEcoreUtil.hasAncestorOfKind(this, SourcePackage.Literals.ACTUAL_SOURCE_SECTION_ATTRIBUTE)) {
			return true;
		}
		
		if (!(this instanceof SingleReferenceValueConstraint)
				|| !AgteleEcoreUtil.hasAncestorOfKind(this, ConditionPackage.Literals.ATTRIBUTE_CONDITION)) {
			throw new UnsupportedOperationException();
		}
		
		EObject container = this;
		
		while (!(container instanceof Mapping)) {
			if (container == null) {
				return false;
			}
			container = container.eContainer();
		}
		
		// The SourceSection of the Mapping that contains the constraint
		//
		SourceSection localSection = ((Mapping) container).getSourceSection();
		
		if (((SingleReferenceValueConstraint) this).getSourceElements().parallelStream()
				.allMatch(s -> s instanceof FixedValue || s instanceof GlobalAttributeImporter
						|| s instanceof ValueConstraintSourceElement && ((ValueConstraintSourceElement) s).getSource()
								.getContainingSection().equals(localSection)
						|| s instanceof ValueConstraintExternalSourceElement
								&& ((ValueConstraintExternalSourceElement) s).getSource().getContainingSection()
										.isContainerFor(localSection))) {
			return true;
		}
		
		// A constraint is also 'local' if an InstancePointer with local or external SourceAttributes exist
		//
		return ((SingleReferenceValueConstraint) this).getInstanceSelectors()
				.parallelStream()
				.flatMap(instanceSelector -> instanceSelector.getSourceElements().parallelStream()
						.filter(s -> s instanceof InstanceSelectorSourceElement
								|| s instanceof InstanceSelectorExternalSourceElement))
				.findAny().isPresent();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
				return ((InternalEList<?>)getSourceElements()).basicRemove(otherEnd, msgs);
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__INSTANCE_SELECTORS:
				return ((InternalEList<?>)getInstanceSelectors()).basicRemove(otherEnd, msgs);
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
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE:
				return getType();
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION:
				return getExpression();
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__MODIFIERS:
				return getModifiers();
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
				return getSourceElements();
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__INSTANCE_SELECTORS:
				return getInstanceSelectors();
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
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE:
				setType((ValueConstraintType)newValue);
				return;
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION:
				setExpression((String)newValue);
				return;
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__MODIFIERS:
				getModifiers().clear();
				getModifiers().addAll((Collection<? extends ValueModifierSet>)newValue);
				return;
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
				getSourceElements().clear();
				getSourceElements().addAll((Collection<? extends ValueConstraintSourceInterface>)newValue);
				return;
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__INSTANCE_SELECTORS:
				getInstanceSelectors().clear();
				getInstanceSelectors().addAll((Collection<? extends SourceInstanceSelector>)newValue);
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
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__MODIFIERS:
				getModifiers().clear();
				return;
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
				getSourceElements().clear();
				return;
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__INSTANCE_SELECTORS:
				getInstanceSelectors().clear();
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
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE:
				return type != TYPE_EDEFAULT;
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__MODIFIERS:
				return modifiers != null && !modifiers.isEmpty();
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
				return sourceElements != null && !sourceElements.isEmpty();
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__INSTANCE_SELECTORS:
				return instanceSelectors != null && !instanceSelectors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ExpressionElement.class) {
			switch (derivedFeatureID) {
				case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION: return PamtramPackage.EXPRESSION_ELEMENT__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableElement.class) {
			switch (derivedFeatureID) {
				case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__MODIFIERS: return PamtramPackage.MODIFIABLE_ELEMENT__MODIFIERS;
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
		if (baseClass == ExpressionElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.EXPRESSION_ELEMENT__EXPRESSION: return ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.MODIFIABLE_ELEMENT__MODIFIERS: return ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__MODIFIERS;
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING:
				return checkConstraint((String)arguments.get(0), (String)arguments.get(1));
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP:
				return validateOnlyFixedValuesInSourceSections((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP:
				return validateOnlyFixedValuesOrGlobalAttributesInConditionModel((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT:
				return isLocalConstraint();
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
		result.append(" (type: ");
		result.append(type);
		result.append(", expression: ");
		result.append(expression);
		result.append(')');
		return result.toString();
	}

} // SingleReferenceValueConstraintImpl
