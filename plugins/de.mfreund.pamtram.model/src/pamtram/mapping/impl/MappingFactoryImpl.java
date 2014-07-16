/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pamtram.mapping.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingFactoryImpl extends EFactoryImpl implements MappingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MappingFactory init() {
		try {
			MappingFactory theMappingFactory = (MappingFactory)EPackage.Registry.INSTANCE.getEFactory(MappingPackage.eNS_URI);
			if (theMappingFactory != null) {
				return theMappingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MappingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MappingPackage.MAPPING: return createMapping();
			case MappingPackage.CARDINALITY_MAPPING: return createCardinalityMapping();
			case MappingPackage.MAPPING_INSTANCE_SELECTOR: return createMappingInstanceSelector();
			case MappingPackage.ATTRIBUTE_MATCHER: return createAttributeMatcher();
			case MappingPackage.CLASS_MATCHER: return createClassMatcher();
			case MappingPackage.SUBSTRING_REPLACER: return createSubstringReplacer();
			case MappingPackage.STRING_APPENDER: return createStringAppender();
			case MappingPackage.UNIQUE_NUMBER_APPENDER: return createUniqueNumberAppender();
			case MappingPackage.STRING_PREPENDER: return createStringPrepender();
			case MappingPackage.ATTRIBUTE_VALUE_MODIFIER_SET: return createAttributeValueModifierSet();
			case MappingPackage.MAPPING_HINT_GROUP: return createMappingHintGroup();
			case MappingPackage.MODEL_CONNECTION_HINT: return createModelConnectionHint();
			case MappingPackage.CONNECTION_HINT_TARGET_ATTRIBUTE: return createConnectionHintTargetAttribute();
			case MappingPackage.SIMPLE_ATTRIBUTE_MAPPING: return createSimpleAttributeMapping();
			case MappingPackage.COMPLEX_ATTRIBUTE_MAPPING: return createComplexAttributeMapping();
			case MappingPackage.COMPLEX_ATTRIBUE_MAPPING_SOURCE_ELEMENT: return createComplexAttribueMappingSourceElement();
			case MappingPackage.CALCULATOR_MAPPING: return createCalculatorMapping();
			case MappingPackage.EXPRESSION_VARIABLE: return createExpressionVariable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CardinalityMapping createCardinalityMapping() {
		CardinalityMappingImpl cardinalityMapping = new CardinalityMappingImpl();
		return cardinalityMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingInstanceSelector createMappingInstanceSelector() {
		MappingInstanceSelectorImpl mappingInstanceSelector = new MappingInstanceSelectorImpl();
		return mappingInstanceSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeMatcher createAttributeMatcher() {
		AttributeMatcherImpl attributeMatcher = new AttributeMatcherImpl();
		return attributeMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassMatcher createClassMatcher() {
		ClassMatcherImpl classMatcher = new ClassMatcherImpl();
		return classMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubstringReplacer createSubstringReplacer() {
		SubstringReplacerImpl substringReplacer = new SubstringReplacerImpl();
		return substringReplacer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringAppender createStringAppender() {
		StringAppenderImpl stringAppender = new StringAppenderImpl();
		return stringAppender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UniqueNumberAppender createUniqueNumberAppender() {
		UniqueNumberAppenderImpl uniqueNumberAppender = new UniqueNumberAppenderImpl();
		return uniqueNumberAppender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringPrepender createStringPrepender() {
		StringPrependerImpl stringPrepender = new StringPrependerImpl();
		return stringPrepender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueModifierSet createAttributeValueModifierSet() {
		AttributeValueModifierSetImpl attributeValueModifierSet = new AttributeValueModifierSetImpl();
		return attributeValueModifierSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingHintGroup createMappingHintGroup() {
		MappingHintGroupImpl mappingHintGroup = new MappingHintGroupImpl();
		return mappingHintGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelConnectionHint createModelConnectionHint() {
		ModelConnectionHintImpl modelConnectionHint = new ModelConnectionHintImpl();
		return modelConnectionHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionHintTargetAttribute createConnectionHintTargetAttribute() {
		ConnectionHintTargetAttributeImpl connectionHintTargetAttribute = new ConnectionHintTargetAttributeImpl();
		return connectionHintTargetAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleAttributeMapping createSimpleAttributeMapping() {
		SimpleAttributeMappingImpl simpleAttributeMapping = new SimpleAttributeMappingImpl();
		return simpleAttributeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexAttributeMapping createComplexAttributeMapping() {
		ComplexAttributeMappingImpl complexAttributeMapping = new ComplexAttributeMappingImpl();
		return complexAttributeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexAttribueMappingSourceElement createComplexAttribueMappingSourceElement() {
		ComplexAttribueMappingSourceElementImpl complexAttribueMappingSourceElement = new ComplexAttribueMappingSourceElementImpl();
		return complexAttribueMappingSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalculatorMapping createCalculatorMapping() {
		CalculatorMappingImpl calculatorMapping = new CalculatorMappingImpl();
		return calculatorMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionVariable createExpressionVariable() {
		ExpressionVariableImpl expressionVariable = new ExpressionVariableImpl();
		return expressionVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingPackage getMappingPackage() {
		return (MappingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MappingPackage getPackage() {
		return MappingPackage.eINSTANCE;
	}

} //MappingFactoryImpl