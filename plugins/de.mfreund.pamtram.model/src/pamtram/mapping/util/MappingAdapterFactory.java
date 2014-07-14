/**
 */
package pamtram.mapping.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import pamtram.NamedElement;

import pamtram.mapping.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.mapping.MappingPackage
 * @generated
 */
public class MappingAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MappingPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MappingPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingSwitch<Adapter> modelSwitch =
		new MappingSwitch<Adapter>() {
			@Override
			public Adapter caseMapping(Mapping object) {
				return createMappingAdapter();
			}
			@Override
			public Adapter caseMappingType(MappingType object) {
				return createMappingTypeAdapter();
			}
			@Override
			public Adapter caseMappingHint(MappingHint object) {
				return createMappingHintAdapter();
			}
			@Override
			public Adapter caseAttributeMapping(AttributeMapping object) {
				return createAttributeMappingAdapter();
			}
			@Override
			public Adapter caseCardinalityMapping(CardinalityMapping object) {
				return createCardinalityMappingAdapter();
			}
			@Override
			public Adapter caseMappingInstanceSelector(MappingInstanceSelector object) {
				return createMappingInstanceSelectorAdapter();
			}
			@Override
			public Adapter caseMatcher(Matcher object) {
				return createMatcherAdapter();
			}
			@Override
			public Adapter caseAttributeMatcher(AttributeMatcher object) {
				return createAttributeMatcherAdapter();
			}
			@Override
			public Adapter caseClassMatcher(ClassMatcher object) {
				return createClassMatcherAdapter();
			}
			@Override
			public Adapter caseAttributeValueModifier(AttributeValueModifier object) {
				return createAttributeValueModifierAdapter();
			}
			@Override
			public Adapter caseSubstringReplacer(SubstringReplacer object) {
				return createSubstringReplacerAdapter();
			}
			@Override
			public Adapter caseStringAppender(StringAppender object) {
				return createStringAppenderAdapter();
			}
			@Override
			public Adapter caseUniqueNumberAppender(UniqueNumberAppender object) {
				return createUniqueNumberAppenderAdapter();
			}
			@Override
			public Adapter caseStringPrepender(StringPrepender object) {
				return createStringPrependerAdapter();
			}
			@Override
			public Adapter caseAttributeValueModifierSet(AttributeValueModifierSet object) {
				return createAttributeValueModifierSetAdapter();
			}
			@Override
			public Adapter caseMappingHintGroup(MappingHintGroup object) {
				return createMappingHintGroupAdapter();
			}
			@Override
			public Adapter caseModelConnectionHint(ModelConnectionHint object) {
				return createModelConnectionHintAdapter();
			}
			@Override
			public Adapter caseConnectionHintTargetAttribute(ConnectionHintTargetAttribute object) {
				return createConnectionHintTargetAttributeAdapter();
			}
			@Override
			public Adapter caseSimpleAttributeMapping(SimpleAttributeMapping object) {
				return createSimpleAttributeMappingAdapter();
			}
			@Override
			public Adapter caseComplexAttributeMapping(ComplexAttributeMapping object) {
				return createComplexAttributeMappingAdapter();
			}
			@Override
			public Adapter caseComplexAttribueMappingSourceElement(ComplexAttribueMappingSourceElement object) {
				return createComplexAttribueMappingSourceElementAdapter();
			}
			@Override
			public Adapter caseCalculatorMapping(CalculatorMapping object) {
				return createCalculatorMappingAdapter();
			}
			@Override
			public Adapter caseExpressionVariable(ExpressionVariable object) {
				return createExpressionVariableAdapter();
			}
			@Override
			public Adapter caseAttributeMappingSourceElementType(AttributeMappingSourceElementType object) {
				return createAttributeMappingSourceElementTypeAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.Mapping
	 * @generated
	 */
	public Adapter createMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingType
	 * @generated
	 */
	public Adapter createMappingTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingHint <em>Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingHint
	 * @generated
	 */
	public Adapter createMappingHintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.AttributeMapping <em>Attribute Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.AttributeMapping
	 * @generated
	 */
	public Adapter createAttributeMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.CardinalityMapping <em>Cardinality Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.CardinalityMapping
	 * @generated
	 */
	public Adapter createCardinalityMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingInstanceSelector <em>Instance Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingInstanceSelector
	 * @generated
	 */
	public Adapter createMappingInstanceSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.Matcher <em>Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.Matcher
	 * @generated
	 */
	public Adapter createMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.AttributeMatcher <em>Attribute Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.AttributeMatcher
	 * @generated
	 */
	public Adapter createAttributeMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ClassMatcher <em>Class Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ClassMatcher
	 * @generated
	 */
	public Adapter createClassMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.AttributeValueModifier <em>Attribute Value Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.AttributeValueModifier
	 * @generated
	 */
	public Adapter createAttributeValueModifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.SubstringReplacer <em>Substring Replacer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.SubstringReplacer
	 * @generated
	 */
	public Adapter createSubstringReplacerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.StringAppender <em>String Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.StringAppender
	 * @generated
	 */
	public Adapter createStringAppenderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.UniqueNumberAppender <em>Unique Number Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.UniqueNumberAppender
	 * @generated
	 */
	public Adapter createUniqueNumberAppenderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.StringPrepender <em>String Prepender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.StringPrepender
	 * @generated
	 */
	public Adapter createStringPrependerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.AttributeValueModifierSet <em>Attribute Value Modifier Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.AttributeValueModifierSet
	 * @generated
	 */
	public Adapter createAttributeValueModifierSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingHintGroup <em>Hint Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingHintGroup
	 * @generated
	 */
	public Adapter createMappingHintGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ModelConnectionHint <em>Model Connection Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ModelConnectionHint
	 * @generated
	 */
	public Adapter createModelConnectionHintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ConnectionHintTargetAttribute <em>Connection Hint Target Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ConnectionHintTargetAttribute
	 * @generated
	 */
	public Adapter createConnectionHintTargetAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.SimpleAttributeMapping <em>Simple Attribute Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.SimpleAttributeMapping
	 * @generated
	 */
	public Adapter createSimpleAttributeMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ComplexAttributeMapping <em>Complex Attribute Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ComplexAttributeMapping
	 * @generated
	 */
	public Adapter createComplexAttributeMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ComplexAttribueMappingSourceElement <em>Complex Attribue Mapping Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ComplexAttribueMappingSourceElement
	 * @generated
	 */
	public Adapter createComplexAttribueMappingSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.CalculatorMapping <em>Calculator Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.CalculatorMapping
	 * @generated
	 */
	public Adapter createCalculatorMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ExpressionVariable <em>Expression Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ExpressionVariable
	 * @generated
	 */
	public Adapter createExpressionVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.AttributeMappingSourceElementType <em>Attribute Mapping Source Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.AttributeMappingSourceElementType
	 * @generated
	 */
	public Adapter createAttributeMappingSourceElementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MappingAdapterFactory
