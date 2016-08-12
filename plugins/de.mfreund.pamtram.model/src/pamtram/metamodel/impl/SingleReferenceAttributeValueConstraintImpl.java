/**
 */
package pamtram.metamodel.impl;

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
import pamtram.condition.AttributeCondition;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.impl.NamedElementImpl;

import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.ExpressionHint;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.ModifiableHint;
import pamtram.metamodel.AttributeValueConstraintExternalSourceElement;
import pamtram.metamodel.AttributeValueConstraintSourceElement;
import pamtram.metamodel.AttributeValueConstraintSourceInterface;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.InstancePointerExternalSourceElement;
import pamtram.metamodel.InstancePointerSourceElement;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SingleReferenceAttributeValueConstraint;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.ActualSourceSectionAttribute;
import pamtram.metamodel.util.MetamodelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Reference Attribute Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.SingleReferenceAttributeValueConstraintImpl#getType <em>Type</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SingleReferenceAttributeValueConstraintImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SingleReferenceAttributeValueConstraintImpl#getResultModifier <em>Result Modifier</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SingleReferenceAttributeValueConstraintImpl#getConstraintReferenceValueAdditionalSpecification <em>Constraint Reference Value Additional Specification</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SingleReferenceAttributeValueConstraintImpl#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SingleReferenceAttributeValueConstraintImpl extends NamedElementImpl implements SingleReferenceAttributeValueConstraint {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final AttributeValueConstraintType TYPE_EDEFAULT = AttributeValueConstraintType.INCLUSION;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected AttributeValueConstraintType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected String expression = EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResultModifier() <em>Result Modifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultModifier()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeValueModifierSet> resultModifier;

	/**
	 * The cached value of the '{@link #getConstraintReferenceValueAdditionalSpecification() <em>Constraint Reference Value Additional Specification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintReferenceValueAdditionalSpecification()
	 * @generated
	 * @ordered
	 */
	protected EList<InstancePointer> constraintReferenceValueAdditionalSpecification;

	/**
	 * The cached value of the '{@link #getSourceElements() <em>Source Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeValueConstraintSourceInterface> sourceElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleReferenceAttributeValueConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueConstraintType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(AttributeValueConstraintType newType) {
		AttributeValueConstraintType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(String newExpression) {
		String oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeValueModifierSet> getResultModifier() {
		if (resultModifier == null) {
			resultModifier = new EObjectResolvingEList<AttributeValueModifierSet>(AttributeValueModifierSet.class, this, MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__RESULT_MODIFIER);
		}
		return resultModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstancePointer> getConstraintReferenceValueAdditionalSpecification() {
		if (constraintReferenceValueAdditionalSpecification == null) {
			constraintReferenceValueAdditionalSpecification = new EObjectContainmentEList<InstancePointer>(InstancePointer.class, this, MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION);
		}
		return constraintReferenceValueAdditionalSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeValueConstraintSourceInterface> getSourceElements() {
		if (sourceElements == null) {
			sourceElements = new EObjectContainmentEList<AttributeValueConstraintSourceInterface>(AttributeValueConstraintSourceInterface.class, this, MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__SOURCE_ELEMENTS);
		}
		return sourceElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkConstraint(final String attrValue, final String refValue) {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SingleReferenceAttributeValueConstraint!checkConstraint(String,String)
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOnlyFixedValuesInSourceSections(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		if(this.getSourceElements().isEmpty() || 
				!AgteleEcoreUtil.hasAncestorOfKind(this, MetamodelPackage.eINSTANCE.getSourceSectionAttribute())) {
			return true;
		}
		
		boolean result = this.getSourceElements().parallelStream().allMatch(s -> s instanceof FixedValue);
		
		if (!result && diagnostics != null) {
			
			String errorMessage = "This AttributeValueConstraint must only"
					+ " contain FixedValues as source elements as it is modeled as part of a SourceSection!'";
			
			diagnostics.add
				(new BasicDiagnostic
					(Diagnostic.ERROR,
					 MetamodelValidator.DIAGNOSTIC_SOURCE,
					 MetamodelValidator.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS,
					 errorMessage,
					 new Object [] { this,  MetamodelPackage.Literals.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__SOURCE_ELEMENTS }));
			}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOnlyFixedValuesOrGlobalAttributesInConditionModel(final DiagnosticChain diagnostics, final Map<?, ?> context) {
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
			
			String errorMessage = "This AttributeValueConstraint must only"
					+ " contain FixedValues or GlobalAttributeImporters as source elements as it is modeled as part of a condition inside a ConditionModel!'";
			
			diagnostics.add
				(new BasicDiagnostic
					(Diagnostic.ERROR,
					 MetamodelValidator.DIAGNOSTIC_SOURCE,
					 MetamodelValidator.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL,
					 errorMessage,
					 new Object [] { this,  MetamodelPackage.Literals.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__SOURCE_ELEMENTS }));
			}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLocalConstraint() {
		if(this.eContainer() instanceof ActualSourceSectionAttribute) {
			return true;
		}
		
		if(!(this.eContainer() instanceof AttributeCondition)) {
			throw new UnsupportedOperationException();
		}
		
		EObject container = this;
		
		while(!(container instanceof Mapping)) {
			if(container == null) {
				return false;
			}
			container = container.eContainer();
		}
		
		// The SourceSection of the Mapping that contains the constraint
		//
		SourceSection localSection = ((Mapping) container).getSourceMMSection();
		
		if(getSourceElements().parallelStream().allMatch(s -> s instanceof FixedValue || s instanceof GlobalAttributeImporter ||
				(s instanceof AttributeValueConstraintSourceElement &&
				((AttributeValueConstraintSourceElement) s).getSource().getContainingSection().equals(localSection)) ||
				(s instanceof AttributeValueConstraintExternalSourceElement &&
						((AttributeValueConstraintExternalSourceElement) s).getSource().getContainingSection().isContainerFor(localSection)))) {
			return true;
		}
		
		// A constraint is also 'local' if an InstancePointer with local or external SourceAttributes exist
		//
		return getConstraintReferenceValueAdditionalSpecification().parallelStream().flatMap(
				instancePointer -> instancePointer.getSourceAttributes().parallelStream().filter(
						s -> s instanceof InstancePointerSourceElement || 
						s instanceof InstancePointerExternalSourceElement)
				).findAny().isPresent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				return ((InternalEList<?>)getConstraintReferenceValueAdditionalSpecification()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
				return ((InternalEList<?>)getSourceElements()).basicRemove(otherEnd, msgs);
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
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__TYPE:
				return getType();
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__EXPRESSION:
				return getExpression();
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__RESULT_MODIFIER:
				return getResultModifier();
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				return getConstraintReferenceValueAdditionalSpecification();
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
				return getSourceElements();
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
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__TYPE:
				setType((AttributeValueConstraintType)newValue);
				return;
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__EXPRESSION:
				setExpression((String)newValue);
				return;
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__RESULT_MODIFIER:
				getResultModifier().clear();
				getResultModifier().addAll((Collection<? extends AttributeValueModifierSet>)newValue);
				return;
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				getConstraintReferenceValueAdditionalSpecification().clear();
				getConstraintReferenceValueAdditionalSpecification().addAll((Collection<? extends InstancePointer>)newValue);
				return;
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
				getSourceElements().clear();
				getSourceElements().addAll((Collection<? extends AttributeValueConstraintSourceInterface>)newValue);
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
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__RESULT_MODIFIER:
				getResultModifier().clear();
				return;
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				getConstraintReferenceValueAdditionalSpecification().clear();
				return;
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
				getSourceElements().clear();
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
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__TYPE:
				return type != TYPE_EDEFAULT;
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__RESULT_MODIFIER:
				return resultModifier != null && !resultModifier.isEmpty();
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				return constraintReferenceValueAdditionalSpecification != null && !constraintReferenceValueAdditionalSpecification.isEmpty();
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
				return sourceElements != null && !sourceElements.isEmpty();
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
		if (baseClass == ExpressionHint.class) {
			switch (derivedFeatureID) {
				case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__EXPRESSION: return MappingPackage.EXPRESSION_HINT__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableHint.class) {
			switch (derivedFeatureID) {
				case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__RESULT_MODIFIER: return MappingPackage.MODIFIABLE_HINT__RESULT_MODIFIER;
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
		if (baseClass == ExpressionHint.class) {
			switch (baseFeatureID) {
				case MappingPackage.EXPRESSION_HINT__EXPRESSION: return MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableHint.class) {
			switch (baseFeatureID) {
				case MappingPackage.MODIFIABLE_HINT__RESULT_MODIFIER: return MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__RESULT_MODIFIER;
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING:
				return checkConstraint((String)arguments.get(0), (String)arguments.get(1));
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP:
				return validateOnlyFixedValuesInSourceSections((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP:
				return validateOnlyFixedValuesOrGlobalAttributesInConditionModel((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT:
				return isLocalConstraint();
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
		result.append(" (type: ");
		result.append(type);
		result.append(", expression: ");
		result.append(expression);
		result.append(')');
		return result.toString();
	}

} //SingleReferenceAttributeValueConstraintImpl
