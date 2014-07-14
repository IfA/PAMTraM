/**
 */
package pamtram.mapping.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import pamtram.mapping.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see pamtram.mapping.MappingPackage
 * @generated
 */
public class MappingValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MappingValidator INSTANCE = new MappingValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "pamtram.mapping";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return MappingPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case MappingPackage.MAPPING:
				return validateMapping((Mapping)value, diagnostics, context);
			case MappingPackage.MAPPING_TYPE:
				return validateMappingType((MappingType)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT:
				return validateMappingHint((MappingHint)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MAPPING:
				return validateAttributeMapping((AttributeMapping)value, diagnostics, context);
			case MappingPackage.CARDINALITY_MAPPING:
				return validateCardinalityMapping((CardinalityMapping)value, diagnostics, context);
			case MappingPackage.MAPPING_INSTANCE_SELECTOR:
				return validateMappingInstanceSelector((MappingInstanceSelector)value, diagnostics, context);
			case MappingPackage.MATCHER:
				return validateMatcher((Matcher)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MATCHER:
				return validateAttributeMatcher((AttributeMatcher)value, diagnostics, context);
			case MappingPackage.CLASS_MATCHER:
				return validateClassMatcher((ClassMatcher)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_VALUE_MODIFIER:
				return validateAttributeValueModifier((AttributeValueModifier)value, diagnostics, context);
			case MappingPackage.SUBSTRING_REPLACER:
				return validateSubstringReplacer((SubstringReplacer)value, diagnostics, context);
			case MappingPackage.STRING_APPENDER:
				return validateStringAppender((StringAppender)value, diagnostics, context);
			case MappingPackage.UNIQUE_NUMBER_APPENDER:
				return validateUniqueNumberAppender((UniqueNumberAppender)value, diagnostics, context);
			case MappingPackage.STRING_PREPENDER:
				return validateStringPrepender((StringPrepender)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_VALUE_MODIFIER_SET:
				return validateAttributeValueModifierSet((AttributeValueModifierSet)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT_GROUP:
				return validateMappingHintGroup((MappingHintGroup)value, diagnostics, context);
			case MappingPackage.MODEL_CONNECTION_HINT:
				return validateModelConnectionHint((ModelConnectionHint)value, diagnostics, context);
			case MappingPackage.CONNECTION_HINT_TARGET_ATTRIBUTE:
				return validateConnectionHintTargetAttribute((ConnectionHintTargetAttribute)value, diagnostics, context);
			case MappingPackage.SIMPLE_ATTRIBUTE_MAPPING:
				return validateSimpleAttributeMapping((SimpleAttributeMapping)value, diagnostics, context);
			case MappingPackage.COMPLEX_ATTRIBUTE_MAPPING:
				return validateComplexAttributeMapping((ComplexAttributeMapping)value, diagnostics, context);
			case MappingPackage.COMPLEX_ATTRIBUE_MAPPING_SOURCE_ELEMENT:
				return validateComplexAttribueMappingSourceElement((ComplexAttribueMappingSourceElement)value, diagnostics, context);
			case MappingPackage.CALCULATOR_MAPPING:
				return validateCalculatorMapping((CalculatorMapping)value, diagnostics, context);
			case MappingPackage.EXPRESSION_VARIABLE:
				return validateExpressionVariable((ExpressionVariable)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE:
				return validateAttributeMappingSourceElementType((AttributeMappingSourceElementType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mapping, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingType(MappingType mappingType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHint(MappingHint mappingHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMapping(AttributeMapping attributeMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(attributeMapping, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateAttributeMapping_sourceAttributeMatchesSection(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateAttributeMapping_targetAttributeMatchesSection(attributeMapping, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the sourceAttributeMatchesSection constraint of '<em>Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MATCHES_SECTION__EEXPRESSION = "";

	/**
	 * Validates the sourceAttributeMatchesSection constraint of '<em>Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMapping_sourceAttributeMatchesSection(AttributeMapping attributeMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.ATTRIBUTE_MAPPING,
				 attributeMapping,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "sourceAttributeMatchesSection",
				 ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MATCHES_SECTION__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the targetAttributeMatchesSection constraint of '<em>Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ATTRIBUTE_MAPPING__TARGET_ATTRIBUTE_MATCHES_SECTION__EEXPRESSION = "\n" +
		"";

	/**
	 * Validates the targetAttributeMatchesSection constraint of '<em>Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMapping_targetAttributeMatchesSection(AttributeMapping attributeMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.ATTRIBUTE_MAPPING,
				 attributeMapping,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "targetAttributeMatchesSection",
				 ATTRIBUTE_MAPPING__TARGET_ATTRIBUTE_MATCHES_SECTION__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(cardinalityMapping, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_sourceClassMatchesSection(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_sourceClassIsVariableCardinality(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_targetClassMatchesSection(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_targetClassIsVariableCardinality(cardinalityMapping, diagnostics, context);
		return result;
	}

	/**
	 * Validates the sourceClassMatchesSection constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_sourceClassMatchesSection(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "sourceClassMatchesSection", getObjectLabel(cardinalityMapping, context) },
						 new Object[] { cardinalityMapping },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the sourceClassIsVariableCardinality constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_sourceClassIsVariableCardinality(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "sourceClassIsVariableCardinality", getObjectLabel(cardinalityMapping, context) },
						 new Object[] { cardinalityMapping },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the targetClassMatchesSection constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_targetClassMatchesSection(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "targetClassMatchesSection", getObjectLabel(cardinalityMapping, context) },
						 new Object[] { cardinalityMapping },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the targetClassIsVariableCardinality constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_targetClassIsVariableCardinality(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "targetClassIsVariableCardinality", getObjectLabel(cardinalityMapping, context) },
						 new Object[] { cardinalityMapping },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingInstanceSelector(MappingInstanceSelector mappingInstanceSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingInstanceSelector, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatcher(Matcher matcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(matcher, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcher(AttributeMatcher attributeMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeMatcher, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassMatcher(ClassMatcher classMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classMatcher, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeValueModifier(AttributeValueModifier attributeValueModifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeValueModifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubstringReplacer(SubstringReplacer substringReplacer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(substringReplacer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringAppender(StringAppender stringAppender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stringAppender, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUniqueNumberAppender(UniqueNumberAppender uniqueNumberAppender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(uniqueNumberAppender, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringPrepender(StringPrepender stringPrepender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stringPrepender, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeValueModifierSet(AttributeValueModifierSet attributeValueModifierSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeValueModifierSet, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintGroup(MappingHintGroup mappingHintGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingHintGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelConnectionHint(ModelConnectionHint modelConnectionHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modelConnectionHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionHintTargetAttribute(ConnectionHintTargetAttribute connectionHintTargetAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(connectionHintTargetAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleAttributeMapping(SimpleAttributeMapping simpleAttributeMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(simpleAttributeMapping, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(simpleAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(simpleAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(simpleAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(simpleAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(simpleAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(simpleAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(simpleAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(simpleAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateAttributeMapping_sourceAttributeMatchesSection(simpleAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateAttributeMapping_targetAttributeMatchesSection(simpleAttributeMapping, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComplexAttributeMapping(ComplexAttributeMapping complexAttributeMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(complexAttributeMapping, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(complexAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(complexAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(complexAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(complexAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(complexAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(complexAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(complexAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(complexAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateAttributeMapping_sourceAttributeMatchesSection(complexAttributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateAttributeMapping_targetAttributeMatchesSection(complexAttributeMapping, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComplexAttribueMappingSourceElement(ComplexAttribueMappingSourceElement complexAttribueMappingSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(complexAttribueMappingSourceElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCalculatorMapping(CalculatorMapping calculatorMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(calculatorMapping, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(calculatorMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(calculatorMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(calculatorMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(calculatorMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(calculatorMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(calculatorMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(calculatorMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(calculatorMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateAttributeMapping_sourceAttributeMatchesSection(calculatorMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateAttributeMapping_targetAttributeMatchesSection(calculatorMapping, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionVariable(ExpressionVariable expressionVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expressionVariable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMappingSourceElementType(AttributeMappingSourceElementType attributeMappingSourceElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeMappingSourceElementType, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //MappingValidator
