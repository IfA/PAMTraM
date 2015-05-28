/**
 */
package pamtram.mapping.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import pamtram.DeactivatableElement;
import pamtram.NamedElement;
import pamtram.mapping.*;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.SourceSectionAttribute;

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
			public Adapter caseMappingType(MappingType object) {
				return createMappingTypeAdapter();
			}
			@Override
			public Adapter caseMapping(Mapping object) {
				return createMappingAdapter();
			}
			@Override
			public Adapter caseMappingHintGroupType(MappingHintGroupType object) {
				return createMappingHintGroupTypeAdapter();
			}
			@Override
			public Adapter caseInstantiableMappingHintGroup(InstantiableMappingHintGroup object) {
				return createInstantiableMappingHintGroupAdapter();
			}
			@Override
			public Adapter caseMappingHintGroup(MappingHintGroup object) {
				return createMappingHintGroupAdapter();
			}
			@Override
			public Adapter caseMappingHint(MappingHint object) {
				return createMappingHintAdapter();
			}
			@Override
			public Adapter caseExpressionHint(ExpressionHint object) {
				return createExpressionHintAdapter();
			}
			@Override
			public Adapter caseModifiableHint(ModifiableHint object) {
				return createModifiableHintAdapter();
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
			public Adapter caseAttributeMatcherSourceElement(AttributeMatcherSourceElement object) {
				return createAttributeMatcherSourceElementAdapter();
			}
			@Override
			public Adapter caseAttributeMatcherSourceInterface(AttributeMatcherSourceInterface object) {
				return createAttributeMatcherSourceInterfaceAdapter();
			}
			@Override
			public Adapter caseClassMatcher(ClassMatcher object) {
				return createClassMatcherAdapter();
			}
			@Override
			public Adapter caseAttributeValueModifierSet(AttributeValueModifierSet object) {
				return createAttributeValueModifierSetAdapter();
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
			public <AttributeType extends Attribute<?>> Adapter caseModifiedAttributeElementType(ModifiedAttributeElementType<AttributeType> object) {
				return createModifiedAttributeElementTypeAdapter();
			}
			@Override
			public <AttributeType extends SourceSectionAttribute> Adapter caseLocalModifiedAttributeElementType(LocalModifiedAttributeElementType<AttributeType> object) {
				return createLocalModifiedAttributeElementTypeAdapter();
			}
			@Override
			public Adapter caseMappingHintGroupImporter(MappingHintGroupImporter object) {
				return createMappingHintGroupImporterAdapter();
			}
			@Override
			public Adapter caseExportedMappingHintGroup(ExportedMappingHintGroup object) {
				return createExportedMappingHintGroupAdapter();
			}
			@Override
			public Adapter caseModelConnectionHint(ModelConnectionHint object) {
				return createModelConnectionHintAdapter();
			}
			@Override
			public Adapter caseAttributeMappingSourceElement(AttributeMappingSourceElement object) {
				return createAttributeMappingSourceElementAdapter();
			}
			@Override
			public Adapter caseModelConnectionHintSourceElement(ModelConnectionHintSourceElement object) {
				return createModelConnectionHintSourceElementAdapter();
			}
			@Override
			public Adapter caseModelConnectionHintTargetAttribute(ModelConnectionHintTargetAttribute object) {
				return createModelConnectionHintTargetAttributeAdapter();
			}
			@Override
			public Adapter caseMappingHintType(MappingHintType object) {
				return createMappingHintTypeAdapter();
			}
			@Override
			public Adapter caseHintImporterMappingHint(HintImporterMappingHint object) {
				return createHintImporterMappingHintAdapter();
			}
			@Override
			public Adapter caseMappedAttributeValueExpander(MappedAttributeValueExpander object) {
				return createMappedAttributeValueExpanderAdapter();
			}
			@Override
			public Adapter caseMappedAttributeValueExpanderType(MappedAttributeValueExpanderType object) {
				return createMappedAttributeValueExpanderTypeAdapter();
			}
			@Override
			public Adapter caseMappedAttributeValuePrepender(MappedAttributeValuePrepender object) {
				return createMappedAttributeValuePrependerAdapter();
			}
			@Override
			public Adapter caseMappedAttributeValueAppender(MappedAttributeValueAppender object) {
				return createMappedAttributeValueAppenderAdapter();
			}
			@Override
			public Adapter caseGlobalAttribute(GlobalAttribute object) {
				return createGlobalAttributeAdapter();
			}
			@Override
			public Adapter caseGlobalAttributeImporter(GlobalAttributeImporter object) {
				return createGlobalAttributeImporterAdapter();
			}
			@Override
			public Adapter caseAttributeMappingSourceInterface(AttributeMappingSourceInterface object) {
				return createAttributeMappingSourceInterfaceAdapter();
			}
			@Override
			public Adapter caseMappingHintSourceInterface(MappingHintSourceInterface object) {
				return createMappingHintSourceInterfaceAdapter();
			}
			@Override
			public Adapter caseModelConnectionHintSourceInterface(ModelConnectionHintSourceInterface object) {
				return createModelConnectionHintSourceInterfaceAdapter();
			}
			@Override
			public Adapter caseAttributeMappingExternalSourceElement(AttributeMappingExternalSourceElement object) {
				return createAttributeMappingExternalSourceElementAdapter();
			}
			@Override
			public <AttributeType extends Attribute<?>> Adapter caseExternalModifiedAttributeElementType(ExternalModifiedAttributeElementType<AttributeType> object) {
				return createExternalModifiedAttributeElementTypeAdapter();
			}
			@Override
			public Adapter caseModelConnectionHintExternalSourceElement(ModelConnectionHintExternalSourceElement object) {
				return createModelConnectionHintExternalSourceElementAdapter();
			}
			@Override
			public Adapter caseAttributeMatcherExternalSourceElement(AttributeMatcherExternalSourceElement object) {
				return createAttributeMatcherExternalSourceElementAdapter();
			}
			@Override
			public Adapter caseExternalMappedAttributeValueExpander(ExternalMappedAttributeValueExpander object) {
				return createExternalMappedAttributeValueExpanderAdapter();
			}
			@Override
			public Adapter caseExternalMappedAttributeValuePrepender(ExternalMappedAttributeValuePrepender object) {
				return createExternalMappedAttributeValuePrependerAdapter();
			}
			@Override
			public Adapter caseExternalMappedAttributeValueAppender(ExternalMappedAttributeValueAppender object) {
				return createExternalMappedAttributeValueAppenderAdapter();
			}
			@Override
			public Adapter caseExpandableHint(ExpandableHint object) {
				return createExpandableHintAdapter();
			}
			@Override
			public Adapter caseMatchToLowerCaseConverter(MatchToLowerCaseConverter object) {
				return createMatchToLowerCaseConverterAdapter();
			}
			@Override
			public Adapter caseMatchToUpperCaseConverter(MatchToUpperCaseConverter object) {
				return createMatchToUpperCaseConverterAdapter();
			}
			@Override
			public Adapter caseGlobalValue(GlobalValue object) {
				return createGlobalValueAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseDeactivatableElement(DeactivatableElement object) {
				return createDeactivatableElementAdapter();
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
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ExpressionHint <em>Expression Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ExpressionHint
	 * @generated
	 */
	public Adapter createExpressionHintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ModifiableHint <em>Modifiable Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ModifiableHint
	 * @generated
	 */
	public Adapter createModifiableHintAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.AttributeMatcherSourceElement <em>Attribute Matcher Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.AttributeMatcherSourceElement
	 * @generated
	 */
	public Adapter createAttributeMatcherSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.AttributeMatcherSourceInterface <em>Attribute Matcher Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.AttributeMatcherSourceInterface
	 * @generated
	 */
	public Adapter createAttributeMatcherSourceInterfaceAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ModifiedAttributeElementType <em>Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ModifiedAttributeElementType
	 * @generated
	 */
	public Adapter createModifiedAttributeElementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.LocalModifiedAttributeElementType <em>Local Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.LocalModifiedAttributeElementType
	 * @generated
	 */
	public Adapter createLocalModifiedAttributeElementTypeAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingHintGroupType <em>Hint Group Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingHintGroupType
	 * @generated
	 */
	public Adapter createMappingHintGroupTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.InstantiableMappingHintGroup <em>Instantiable Mapping Hint Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.InstantiableMappingHintGroup
	 * @generated
	 */
	public Adapter createInstantiableMappingHintGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingHintGroupImporter <em>Hint Group Importer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingHintGroupImporter
	 * @generated
	 */
	public Adapter createMappingHintGroupImporterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ExportedMappingHintGroup <em>Exported Mapping Hint Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ExportedMappingHintGroup
	 * @generated
	 */
	public Adapter createExportedMappingHintGroupAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.AttributeMappingSourceElement <em>Attribute Mapping Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.AttributeMappingSourceElement
	 * @generated
	 */
	public Adapter createAttributeMappingSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ModelConnectionHintSourceElement <em>Model Connection Hint Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ModelConnectionHintSourceElement
	 * @generated
	 */
	public Adapter createModelConnectionHintSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ModelConnectionHintTargetAttribute <em>Model Connection Hint Target Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ModelConnectionHintTargetAttribute
	 * @generated
	 */
	public Adapter createModelConnectionHintTargetAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingHintType <em>Hint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingHintType
	 * @generated
	 */
	public Adapter createMappingHintTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.HintImporterMappingHint <em>Hint Importer Mapping Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.HintImporterMappingHint
	 * @generated
	 */
	public Adapter createHintImporterMappingHintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappedAttributeValueExpander <em>Mapped Attribute Value Expander</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappedAttributeValueExpander
	 * @generated
	 */
	public Adapter createMappedAttributeValueExpanderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappedAttributeValueExpanderType <em>Mapped Attribute Value Expander Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappedAttributeValueExpanderType
	 * @generated
	 */
	public Adapter createMappedAttributeValueExpanderTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappedAttributeValuePrepender <em>Mapped Attribute Value Prepender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappedAttributeValuePrepender
	 * @generated
	 */
	public Adapter createMappedAttributeValuePrependerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappedAttributeValueAppender <em>Mapped Attribute Value Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappedAttributeValueAppender
	 * @generated
	 */
	public Adapter createMappedAttributeValueAppenderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.GlobalAttribute <em>Global Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.GlobalAttribute
	 * @generated
	 */
	public Adapter createGlobalAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.GlobalAttributeImporter <em>Global Attribute Importer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.GlobalAttributeImporter
	 * @generated
	 */
	public Adapter createGlobalAttributeImporterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.AttributeMappingSourceInterface <em>Attribute Mapping Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.AttributeMappingSourceInterface
	 * @generated
	 */
	public Adapter createAttributeMappingSourceInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingHintSourceInterface <em>Hint Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingHintSourceInterface
	 * @generated
	 */
	public Adapter createMappingHintSourceInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ModelConnectionHintSourceInterface <em>Model Connection Hint Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ModelConnectionHintSourceInterface
	 * @generated
	 */
	public Adapter createModelConnectionHintSourceInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.AttributeMappingExternalSourceElement <em>Attribute Mapping External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.AttributeMappingExternalSourceElement
	 * @generated
	 */
	public Adapter createAttributeMappingExternalSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ExternalModifiedAttributeElementType <em>External Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ExternalModifiedAttributeElementType
	 * @generated
	 */
	public Adapter createExternalModifiedAttributeElementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ModelConnectionHintExternalSourceElement <em>Model Connection Hint External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ModelConnectionHintExternalSourceElement
	 * @generated
	 */
	public Adapter createModelConnectionHintExternalSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.AttributeMatcherExternalSourceElement <em>Attribute Matcher External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.AttributeMatcherExternalSourceElement
	 * @generated
	 */
	public Adapter createAttributeMatcherExternalSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ExternalMappedAttributeValueExpander <em>External Mapped Attribute Value Expander</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ExternalMappedAttributeValueExpander
	 * @generated
	 */
	public Adapter createExternalMappedAttributeValueExpanderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ExternalMappedAttributeValuePrepender <em>External Mapped Attribute Value Prepender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ExternalMappedAttributeValuePrepender
	 * @generated
	 */
	public Adapter createExternalMappedAttributeValuePrependerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ExternalMappedAttributeValueAppender <em>External Mapped Attribute Value Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ExternalMappedAttributeValueAppender
	 * @generated
	 */
	public Adapter createExternalMappedAttributeValueAppenderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ExpandableHint <em>Expandable Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ExpandableHint
	 * @generated
	 */
	public Adapter createExpandableHintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MatchToLowerCaseConverter <em>Match To Lower Case Converter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MatchToLowerCaseConverter
	 * @generated
	 */
	public Adapter createMatchToLowerCaseConverterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MatchToUpperCaseConverter <em>Match To Upper Case Converter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MatchToUpperCaseConverter
	 * @generated
	 */
	public Adapter createMatchToUpperCaseConverterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.GlobalValue <em>Global Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.GlobalValue
	 * @generated
	 */
	public Adapter createGlobalValueAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.DeactivatableElement <em>Deactivatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.DeactivatableElement
	 * @generated
	 */
	public Adapter createDeactivatableElementAdapter() {
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
