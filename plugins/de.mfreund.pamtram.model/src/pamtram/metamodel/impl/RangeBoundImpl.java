/**
 */
package pamtram.metamodel.impl;

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
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

import pamtram.condition.AttributeCondition;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.ModifiableHint;
import pamtram.mapping.impl.ExpressionHintImpl;
import pamtram.metamodel.AttributeValueConstraintExternalSourceElement;
import pamtram.metamodel.AttributeValueConstraintSourceElement;
import pamtram.metamodel.AttributeValueConstraintSourceInterface;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.InstancePointerExternalSourceElement;
import pamtram.metamodel.InstancePointerSourceElement;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.RangeBound;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.util.MetamodelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range Bound</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.RangeBoundImpl#getResultModifier <em>Result Modifier</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.RangeBoundImpl#getBoundType <em>Bound Type</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.RangeBoundImpl#getBoundReferenceValueAdditionalSpecification <em>Bound Reference Value Additional Specification</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.RangeBoundImpl#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RangeBoundImpl extends ExpressionHintImpl implements RangeBound {
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
	 * The default value of the '{@link #getBoundType() <em>Bound Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundType()
	 * @generated
	 * @ordered
	 */
	protected static final AttributeValueConstraintType BOUND_TYPE_EDEFAULT = AttributeValueConstraintType.INCLUSION;

	/**
	 * The cached value of the '{@link #getBoundType() <em>Bound Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundType()
	 * @generated
	 * @ordered
	 */
	protected AttributeValueConstraintType boundType = BOUND_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBoundReferenceValueAdditionalSpecification() <em>Bound Reference Value Additional Specification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundReferenceValueAdditionalSpecification()
	 * @generated
	 * @ordered
	 */
	protected EList<InstancePointer> boundReferenceValueAdditionalSpecification;

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
	protected RangeBoundImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.RANGE_BOUND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeValueModifierSet> getResultModifier() {
		if (resultModifier == null) {
			resultModifier = new EObjectResolvingEList<AttributeValueModifierSet>(AttributeValueModifierSet.class, this, MetamodelPackage.RANGE_BOUND__RESULT_MODIFIER);
		}
		return resultModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueConstraintType getBoundType() {
		return boundType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundType(AttributeValueConstraintType newBoundType) {
		AttributeValueConstraintType oldBoundType = boundType;
		boundType = newBoundType == null ? BOUND_TYPE_EDEFAULT : newBoundType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.RANGE_BOUND__BOUND_TYPE, oldBoundType, boundType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstancePointer> getBoundReferenceValueAdditionalSpecification() {
		if (boundReferenceValueAdditionalSpecification == null) {
			boundReferenceValueAdditionalSpecification = new EObjectContainmentEList<InstancePointer>(InstancePointer.class, this, MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION);
		}
		return boundReferenceValueAdditionalSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeValueConstraintSourceInterface> getSourceElements() {
		if (sourceElements == null) {
			sourceElements = new EObjectContainmentEList<AttributeValueConstraintSourceInterface>(AttributeValueConstraintSourceInterface.class, this, MetamodelPackage.RANGE_BOUND__SOURCE_ELEMENTS);
		}
		return sourceElements;
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
		if(this.getSourceElements().isEmpty()
						|| !(((EObject) this).eContainer().eContainer() instanceof AttributeCondition)) {
			return true;
		}
		
		AttributeCondition condition = (AttributeCondition) ((EObject) this).eContainer().eContainer();
		
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
					 MetamodelValidator.RANGE_BOUND__VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL,
					 errorMessage,
					 new Object [] { this,  MetamodelPackage.Literals.RANGE_BOUND__SOURCE_ELEMENTS }));
			}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLocalConstraint() {
		if(this.eContainer().eContainer() instanceof SourceSectionAttribute) {
					return true;
				}
				
				if(!(this.eContainer().eContainer() instanceof AttributeCondition)) {
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
				return getBoundReferenceValueAdditionalSpecification().parallelStream().flatMap(
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
			case MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				return ((InternalEList<?>)getBoundReferenceValueAdditionalSpecification()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.RANGE_BOUND__SOURCE_ELEMENTS:
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
			case MetamodelPackage.RANGE_BOUND__RESULT_MODIFIER:
				return getResultModifier();
			case MetamodelPackage.RANGE_BOUND__BOUND_TYPE:
				return getBoundType();
			case MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				return getBoundReferenceValueAdditionalSpecification();
			case MetamodelPackage.RANGE_BOUND__SOURCE_ELEMENTS:
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
			case MetamodelPackage.RANGE_BOUND__RESULT_MODIFIER:
				getResultModifier().clear();
				getResultModifier().addAll((Collection<? extends AttributeValueModifierSet>)newValue);
				return;
			case MetamodelPackage.RANGE_BOUND__BOUND_TYPE:
				setBoundType((AttributeValueConstraintType)newValue);
				return;
			case MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				getBoundReferenceValueAdditionalSpecification().clear();
				getBoundReferenceValueAdditionalSpecification().addAll((Collection<? extends InstancePointer>)newValue);
				return;
			case MetamodelPackage.RANGE_BOUND__SOURCE_ELEMENTS:
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
			case MetamodelPackage.RANGE_BOUND__RESULT_MODIFIER:
				getResultModifier().clear();
				return;
			case MetamodelPackage.RANGE_BOUND__BOUND_TYPE:
				setBoundType(BOUND_TYPE_EDEFAULT);
				return;
			case MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				getBoundReferenceValueAdditionalSpecification().clear();
				return;
			case MetamodelPackage.RANGE_BOUND__SOURCE_ELEMENTS:
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
			case MetamodelPackage.RANGE_BOUND__RESULT_MODIFIER:
				return resultModifier != null && !resultModifier.isEmpty();
			case MetamodelPackage.RANGE_BOUND__BOUND_TYPE:
				return boundType != BOUND_TYPE_EDEFAULT;
			case MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				return boundReferenceValueAdditionalSpecification != null && !boundReferenceValueAdditionalSpecification.isEmpty();
			case MetamodelPackage.RANGE_BOUND__SOURCE_ELEMENTS:
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
		if (baseClass == ModifiableHint.class) {
			switch (derivedFeatureID) {
				case MetamodelPackage.RANGE_BOUND__RESULT_MODIFIER: return MappingPackage.MODIFIABLE_HINT__RESULT_MODIFIER;
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
		if (baseClass == ModifiableHint.class) {
			switch (baseFeatureID) {
				case MappingPackage.MODIFIABLE_HINT__RESULT_MODIFIER: return MetamodelPackage.RANGE_BOUND__RESULT_MODIFIER;
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
			case MetamodelPackage.RANGE_BOUND___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP:
				return validateOnlyFixedValuesInSourceSections((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MetamodelPackage.RANGE_BOUND___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP:
				return validateOnlyFixedValuesOrGlobalAttributesInConditionModel((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MetamodelPackage.RANGE_BOUND___IS_LOCAL_CONSTRAINT:
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
		result.append(" (boundType: ");
		result.append(boundType);
		result.append(')');
		return result.toString();
	}

} //RangeBoundImpl
