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
import pamtram.mapping.ExpressionHint;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.ModifiableHint;
import pamtram.mapping.ValueModifierSet;
import pamtram.metamodel.ActualSourceSectionAttribute;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.InstancePointerExternalSourceElement;
import pamtram.metamodel.InstancePointerSourceElement;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SingleReferenceValueConstraint;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.ValueConstraintExternalSourceElement;
import pamtram.metamodel.ValueConstraintSourceElement;
import pamtram.metamodel.ValueConstraintSourceInterface;
import pamtram.metamodel.ValueConstraintType;
import pamtram.metamodel.util.MetamodelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Reference Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.SingleReferenceValueConstraintImpl#getType <em>Type</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SingleReferenceValueConstraintImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SingleReferenceValueConstraintImpl#getResultModifier <em>Result Modifier</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SingleReferenceValueConstraintImpl#getConstraintReferenceValueAdditionalSpecification <em>Constraint Reference Value Additional Specification</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SingleReferenceValueConstraintImpl#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SingleReferenceValueConstraintImpl extends NamedElementImpl implements SingleReferenceValueConstraint {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ValueConstraintType TYPE_EDEFAULT = ValueConstraintType.INCLUSION;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ValueConstraintType type = SingleReferenceValueConstraintImpl.TYPE_EDEFAULT;

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
	protected String expression = SingleReferenceValueConstraintImpl.EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResultModifier() <em>Result Modifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultModifier()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueModifierSet> resultModifier;

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
	protected EList<ValueConstraintSourceInterface> sourceElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleReferenceValueConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueConstraintType getType() {
		return this.type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(ValueConstraintType newType) {
		ValueConstraintType oldType = this.type;
		this.type = newType == null ? SingleReferenceValueConstraintImpl.TYPE_EDEFAULT : newType;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE, oldType, this.type));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExpression() {
		return this.expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExpression(String newExpression) {
		String oldExpression = this.expression;
		this.expression = newExpression;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION, oldExpression, this.expression));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValueModifierSet> getResultModifier() {
		if (this.resultModifier == null) {
			this.resultModifier = new EObjectResolvingEList<>(ValueModifierSet.class, this, MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__RESULT_MODIFIER);
		}
		return this.resultModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InstancePointer> getConstraintReferenceValueAdditionalSpecification() {
		if (this.constraintReferenceValueAdditionalSpecification == null) {
			this.constraintReferenceValueAdditionalSpecification = new EObjectContainmentEList<>(InstancePointer.class, this, MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION);
		}
		return this.constraintReferenceValueAdditionalSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValueConstraintSourceInterface> getSourceElements() {
		if (this.sourceElements == null) {
			this.sourceElements = new EObjectContainmentEList<>(ValueConstraintSourceInterface.class, this, MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS);
		}
		return this.sourceElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean checkConstraint(final String attrValue, final String refValue) {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SingleReferenceValueConstraint!checkConstraint(String,String)
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateOnlyFixedValuesInSourceSections(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		if(this.getSourceElements().isEmpty() ||
				!AgteleEcoreUtil.hasAncestorOfKind(this, MetamodelPackage.eINSTANCE.getActualSourceSectionAttribute())) {
			return true;
		}

		boolean result = this.getSourceElements().parallelStream().allMatch(s -> s instanceof FixedValue);

		if (!result && diagnostics != null) {

			String errorMessage = "This ValueConstraint must only"
					+ " contain FixedValues as source elements as it is modeled as part of a SourceSection!'";

			diagnostics.add
			(new BasicDiagnostic
					(Diagnostic.ERROR,
							MetamodelValidator.DIAGNOSTIC_SOURCE,
							MetamodelValidator.SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS,
							errorMessage,
							new Object [] { this,  MetamodelPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS }));
		}

		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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

			String errorMessage = "This ValueConstraint must only"
					+ " contain FixedValues or GlobalAttributeImporters as source elements as it is modeled as part of a condition inside a ConditionModel!'";

			diagnostics.add
			(new BasicDiagnostic
					(Diagnostic.ERROR,
							MetamodelValidator.DIAGNOSTIC_SOURCE,
							MetamodelValidator.SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL,
							errorMessage,
							new Object [] { this,  MetamodelPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS }));
		}

		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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

		if(this.getSourceElements().parallelStream().allMatch(s -> s instanceof FixedValue || s instanceof GlobalAttributeImporter ||
				s instanceof ValueConstraintSourceElement &&
				((ValueConstraintSourceElement) s).getSource().getContainingSection().equals(localSection) ||
				s instanceof ValueConstraintExternalSourceElement &&
				((ValueConstraintExternalSourceElement) s).getSource().getContainingSection().isContainerFor(localSection))) {
			return true;
		}

		// A constraint is also 'local' if an InstancePointer with local or external SourceAttributes exist
		//
		return this.getConstraintReferenceValueAdditionalSpecification().parallelStream().flatMap(
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
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				return ((InternalEList<?>)this.getConstraintReferenceValueAdditionalSpecification()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
				return ((InternalEList<?>)this.getSourceElements()).basicRemove(otherEnd, msgs);
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
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE:
				return this.getType();
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION:
				return this.getExpression();
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__RESULT_MODIFIER:
				return this.getResultModifier();
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				return this.getConstraintReferenceValueAdditionalSpecification();
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
				return this.getSourceElements();
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
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE:
				this.setType((ValueConstraintType)newValue);
				return;
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION:
				this.setExpression((String)newValue);
				return;
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__RESULT_MODIFIER:
				this.getResultModifier().clear();
				this.getResultModifier().addAll((Collection<? extends ValueModifierSet>)newValue);
				return;
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				this.getConstraintReferenceValueAdditionalSpecification().clear();
				this.getConstraintReferenceValueAdditionalSpecification().addAll((Collection<? extends InstancePointer>)newValue);
				return;
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
				this.getSourceElements().clear();
				this.getSourceElements().addAll((Collection<? extends ValueConstraintSourceInterface>)newValue);
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
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE:
				this.setType(SingleReferenceValueConstraintImpl.TYPE_EDEFAULT);
				return;
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION:
				this.setExpression(SingleReferenceValueConstraintImpl.EXPRESSION_EDEFAULT);
				return;
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__RESULT_MODIFIER:
				this.getResultModifier().clear();
				return;
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				this.getConstraintReferenceValueAdditionalSpecification().clear();
				return;
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
				this.getSourceElements().clear();
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
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE:
				return this.type != SingleReferenceValueConstraintImpl.TYPE_EDEFAULT;
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION:
				return SingleReferenceValueConstraintImpl.EXPRESSION_EDEFAULT == null ? this.expression != null : !SingleReferenceValueConstraintImpl.EXPRESSION_EDEFAULT.equals(this.expression);
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__RESULT_MODIFIER:
				return this.resultModifier != null && !this.resultModifier.isEmpty();
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				return this.constraintReferenceValueAdditionalSpecification != null && !this.constraintReferenceValueAdditionalSpecification.isEmpty();
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
				return this.sourceElements != null && !this.sourceElements.isEmpty();
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
				case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION: return MappingPackage.EXPRESSION_HINT__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableHint.class) {
			switch (derivedFeatureID) {
				case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__RESULT_MODIFIER: return MappingPackage.MODIFIABLE_HINT__RESULT_MODIFIER;
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
				case MappingPackage.EXPRESSION_HINT__EXPRESSION: return MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableHint.class) {
			switch (baseFeatureID) {
				case MappingPackage.MODIFIABLE_HINT__RESULT_MODIFIER: return MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__RESULT_MODIFIER;
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
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING:
				return this.checkConstraint((String)arguments.get(0), (String)arguments.get(1));
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP:
				return this.validateOnlyFixedValuesInSourceSections((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP:
				return this.validateOnlyFixedValuesOrGlobalAttributesInConditionModel((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT:
				return this.isLocalConstraint();
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
		if (this.eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(this.type);
		result.append(", expression: ");
		result.append(this.expression);
		result.append(')');
		return result.toString();
	}

} //SingleReferenceValueConstraintImpl
