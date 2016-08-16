/**
 */
package pamtram.mapping.util;

import java.util.Map;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.xtext.oclinecore.validation.OCLinEcoreEObjectValidator;

import pamtram.mapping.*;
import pamtram.util.PamtramValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see pamtram.mapping.MappingPackage
 * @generated not
 */
public class MappingValidator extends OCLinEcoreEObjectValidator {
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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Contains Hint Groups' of 'Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING__CONTAINS_HINT_GROUPS = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Contains Deactivated Hint Groups' of 'Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING__CONTAINS_DEACTIVATED_HINT_GROUPS = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Target Attribute Matches Section' of 'Attribute Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ATTRIBUTE_MAPPING__TARGET_ATTRIBUTE_MATCHES_SECTION = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No Cardinality Mapping For Source Section Root' of 'Cardinality Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CARDINALITY_MAPPING__NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Source Class Matches Section' of 'Cardinality Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CARDINALITY_MAPPING__SOURCE_CLASS_MATCHES_SECTION = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Target Class Matches Section' of 'Cardinality Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CARDINALITY_MAPPING__TARGET_CLASS_MATCHES_SECTION = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Target Class Is Variable Cardinality' of 'Cardinality Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CARDINALITY_MAPPING__TARGET_CLASS_IS_VARIABLE_CARDINALITY = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Source Class Is Variable Cardinality' of 'Cardinality Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CARDINALITY_MAPPING__SOURCE_CLASS_IS_VARIABLE_CARDINALITY = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Affected Reference Matches Section' of 'Instance Selector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE_MATCHES_SECTION = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Affected Reference Is Non Containment' of 'Instance Selector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE_IS_NON_CONTAINMENT = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Target Matches Affected Reference Type' of 'Attribute Matcher'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ATTRIBUTE_MATCHER__TARGET_MATCHES_AFFECTED_REFERENCE_TYPE = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Attribute Matches Section Or Contained Section' of 'Local Modified Attribute Element Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Source Matches Possible Container Type' of 'Model Connection Hint Target Attribute'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE__SOURCE_MATCHES_POSSIBLE_CONTAINER_TYPE = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Source Attribute Has Upper Bound One' of 'Global Attribute'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int GLOBAL_ATTRIBUTE__SOURCE_ATTRIBUTE_HAS_UPPER_BOUND_ONE = 14;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Source Attribute Matches Container Section' of 'External Modified Attribute Element Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION = 15;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 15;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PamtramValidator pamtramValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingValidator() {
		super();
		pamtramValidator = PamtramValidator.INSTANCE;
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
			case MappingPackage.MAPPING_TYPE:
				return validateMappingType((MappingType)value, diagnostics, context);
			case MappingPackage.MAPPING:
				return validateMapping((Mapping)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT_GROUP_TYPE:
				return validateMappingHintGroupType((MappingHintGroupType)value, diagnostics, context);
			case MappingPackage.INSTANTIABLE_MAPPING_HINT_GROUP:
				return validateInstantiableMappingHintGroup((InstantiableMappingHintGroup)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT_GROUP:
				return validateMappingHintGroup((MappingHintGroup)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT_BASE_TYPE:
				return validateMappingHintBaseType((MappingHintBaseType)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT:
				return validateMappingHint((MappingHint)value, diagnostics, context);
			case MappingPackage.EXPRESSION_HINT:
				return validateExpressionHint((ExpressionHint)value, diagnostics, context);
			case MappingPackage.MODIFIABLE_HINT:
				return validateModifiableHint((ModifiableHint)value, diagnostics, context);
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
			case MappingPackage.ATTRIBUTE_MATCHER_SOURCE_ELEMENT:
				return validateAttributeMatcherSourceElement((AttributeMatcherSourceElement)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MATCHER_SOURCE_INTERFACE:
				return validateAttributeMatcherSourceInterface((AttributeMatcherSourceInterface)value, diagnostics, context);
			case MappingPackage.CLASS_MATCHER:
				return validateClassMatcher((ClassMatcher)value, diagnostics, context);
			case MappingPackage.VALUE_MODIFIER_SET:
				return validateValueModifierSet((ValueModifierSet)value, diagnostics, context);
			case MappingPackage.VALUE_MODIFIER:
				return validateValueModifier((ValueModifier)value, diagnostics, context);
			case MappingPackage.SUBSTRING_REPLACER:
				return validateSubstringReplacer((SubstringReplacer)value, diagnostics, context);
			case MappingPackage.STRING_APPENDER:
				return validateStringAppender((StringAppender)value, diagnostics, context);
			case MappingPackage.UNIQUE_NUMBER_APPENDER:
				return validateUniqueNumberAppender((UniqueNumberAppender)value, diagnostics, context);
			case MappingPackage.STRING_PREPENDER:
				return validateStringPrepender((StringPrepender)value, diagnostics, context);
			case MappingPackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE:
				return validateModifiedAttributeElementType((ModifiedAttributeElementType<?, ?, ?, ?>)value, diagnostics, context);
			case MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE:
				return validateLocalModifiedAttributeElementType((LocalModifiedAttributeElementType<?, ?, ?, ?>)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER:
				return validateMappingHintGroupImporter((MappingHintGroupImporter)value, diagnostics, context);
			case MappingPackage.EXPORTED_MAPPING_HINT_GROUP:
				return validateExportedMappingHintGroup((ExportedMappingHintGroup)value, diagnostics, context);
			case MappingPackage.MODEL_CONNECTION_HINT:
				return validateModelConnectionHint((ModelConnectionHint)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT:
				return validateAttributeMappingSourceElement((AttributeMappingSourceElement)value, diagnostics, context);
			case MappingPackage.MODEL_CONNECTION_HINT_SOURCE_ELEMENT:
				return validateModelConnectionHintSourceElement((ModelConnectionHintSourceElement)value, diagnostics, context);
			case MappingPackage.MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE:
				return validateModelConnectionHintTargetAttribute((ModelConnectionHintTargetAttribute)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT_TYPE:
				return validateMappingHintType((MappingHintType)value, diagnostics, context);
			case MappingPackage.HINT_IMPORTER_MAPPING_HINT:
				return validateHintImporterMappingHint((HintImporterMappingHint)value, diagnostics, context);
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER:
				return validateMappedAttributeValueExpander((MappedAttributeValueExpander)value, diagnostics, context);
			case MappingPackage.LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER:
				return validateLocalMappedAttributeValueExpander((LocalMappedAttributeValueExpander)value, diagnostics, context);
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_PREPENDER:
				return validateMappedAttributeValuePrepender((MappedAttributeValuePrepender)value, diagnostics, context);
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_APPENDER:
				return validateMappedAttributeValueAppender((MappedAttributeValueAppender)value, diagnostics, context);
			case MappingPackage.FIXED_VALUE:
				return validateFixedValue((FixedValue)value, diagnostics, context);
			case MappingPackage.GLOBAL_ATTRIBUTE:
				return validateGlobalAttribute((GlobalAttribute)value, diagnostics, context);
			case MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER:
				return validateGlobalAttributeImporter((GlobalAttributeImporter)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_INTERFACE:
				return validateAttributeMappingSourceInterface((AttributeMappingSourceInterface)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT_SOURCE_INTERFACE:
				return validateMappingHintSourceInterface((MappingHintSourceInterface)value, diagnostics, context);
			case MappingPackage.MODEL_CONNECTION_HINT_SOURCE_INTERFACE:
				return validateModelConnectionHintSourceInterface((ModelConnectionHintSourceInterface)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT:
				return validateAttributeMappingExternalSourceElement((AttributeMappingExternalSourceElement)value, diagnostics, context);
			case MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE:
				return validateExternalModifiedAttributeElementType((ExternalModifiedAttributeElementType<?, ?, ?, ?>)value, diagnostics, context);
			case MappingPackage.MODEL_CONNECTION_HINT_EXTERNAL_SOURCE_ELEMENT:
				return validateModelConnectionHintExternalSourceElement((ModelConnectionHintExternalSourceElement)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT:
				return validateAttributeMatcherExternalSourceElement((AttributeMatcherExternalSourceElement)value, diagnostics, context);
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER:
				return validateExternalMappedAttributeValueExpander((ExternalMappedAttributeValueExpander)value, diagnostics, context);
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER:
				return validateExternalMappedAttributeValuePrepender((ExternalMappedAttributeValuePrepender)value, diagnostics, context);
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER:
				return validateExternalMappedAttributeValueAppender((ExternalMappedAttributeValueAppender)value, diagnostics, context);
			case MappingPackage.EXPANDABLE_HINT:
				return validateExpandableHint((ExpandableHint)value, diagnostics, context);
			case MappingPackage.MATCH_TO_LOWER_CASE_CONVERTER:
				return validateMatchToLowerCaseConverter((MatchToLowerCaseConverter)value, diagnostics, context);
			case MappingPackage.MATCH_TO_UPPER_CASE_CONVERTER:
				return validateMatchToUpperCaseConverter((MatchToUpperCaseConverter)value, diagnostics, context);
			default:
				return true;
		}
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
	public boolean validateMapping(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mapping, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMapping_containsHintGroups(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMapping_containsDeactivatedHintGroups(mapping, diagnostics, context);
		return result;
	}

	/**
	 * Validates the containsHintGroups constraint of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping_containsHintGroups(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mapping.containsHintGroups(diagnostics, context);
	}

	/**
	 * Validates the containsDeactivatedHintGroups constraint of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping_containsDeactivatedHintGroups(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mapping.containsDeactivatedHintGroups(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintGroupType(MappingHintGroupType mappingHintGroupType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingHintGroupType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstantiableMappingHintGroup(InstantiableMappingHintGroup instantiableMappingHintGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(instantiableMappingHintGroup, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(instantiableMappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(instantiableMappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(instantiableMappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(instantiableMappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(instantiableMappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(instantiableMappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(instantiableMappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(instantiableMappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(instantiableMappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(instantiableMappingHintGroup, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintGroup(MappingHintGroup mappingHintGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mappingHintGroup, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(mappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(mappingHintGroup, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintBaseType(MappingHintBaseType mappingHintBaseType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingHintBaseType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHint(MappingHint mappingHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mappingHint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mappingHint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappingHint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappingHint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mappingHint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappingHint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mappingHint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappingHint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappingHint, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(mappingHint, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(mappingHint, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionHint(ExpressionHint expressionHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expressionHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModifiableHint(ModifiableHint modifiableHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modifiableHint, diagnostics, context);
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
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateAttributeMapping_targetAttributeMatchesSection(attributeMapping, diagnostics, context);
		return result;
	}

	/**
	 * Validates the targetAttributeMatchesSection constraint of '<em>Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMapping_targetAttributeMatchesSection(AttributeMapping attributeMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return attributeMapping.targetAttributeMatchesSection(diagnostics, context);
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
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_sourceClassMatchesSection(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_sourceClassIsVariableCardinality(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_targetClassMatchesSection(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_targetClassIsVariableCardinality(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_noCardinalityMappingForSourceSectionRoot(cardinalityMapping, diagnostics, context);
		return result;
	}

	/**
	 * Validates the sourceClassMatchesSection constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_sourceClassMatchesSection(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return cardinalityMapping.sourceClassMatchesSection(diagnostics, context);
	}

	/**
	 * Validates the sourceClassIsVariableCardinality constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_sourceClassIsVariableCardinality(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return cardinalityMapping.sourceClassIsVariableCardinality(diagnostics, context);
	}

	/**
	 * Validates the targetClassMatchesSection constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_targetClassMatchesSection(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return cardinalityMapping.targetClassMatchesSection(diagnostics, context);
	}

	/**
	 * Validates the targetClassIsVariableCardinality constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_targetClassIsVariableCardinality(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return cardinalityMapping.targetClassIsVariableCardinality(diagnostics, context);
	}

	/**
	 * Validates the noCardinalityMappingForSourceSectionRoot constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_noCardinalityMappingForSourceSectionRoot(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return cardinalityMapping.noCardinalityMappingForSourceSectionRoot(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingInstanceSelector(MappingInstanceSelector mappingInstanceSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mappingInstanceSelector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mappingInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappingInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappingInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mappingInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappingInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mappingInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappingInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappingInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(mappingInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(mappingInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingInstanceSelector_affectedReferenceIsNonContainment(mappingInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingInstanceSelector_affectedReferenceMatchesSection(mappingInstanceSelector, diagnostics, context);
		return result;
	}

	/**
	 * Validates the affectedReferenceIsNonContainment constraint of '<em>Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingInstanceSelector_affectedReferenceIsNonContainment(MappingInstanceSelector mappingInstanceSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mappingInstanceSelector.affectedReferenceIsNonContainment(diagnostics, context);
	}

	/**
	 * Validates the affectedReferenceMatchesSection constraint of '<em>Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingInstanceSelector_affectedReferenceMatchesSection(MappingInstanceSelector mappingInstanceSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mappingInstanceSelector.affectedReferenceMatchesSection(diagnostics, context);
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
		if (!validate_NoCircularContainment(attributeMatcher, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(attributeMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(attributeMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(attributeMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(attributeMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(attributeMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(attributeMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(attributeMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(attributeMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateAttributeMatcher_targetMatchesAffectedReferenceType(attributeMatcher, diagnostics, context);
		return result;
	}

	/**
	 * Validates the targetMatchesAffectedReferenceType constraint of '<em>Attribute Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcher_targetMatchesAffectedReferenceType(AttributeMatcher attributeMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return attributeMatcher.targetMatchesAffectedReferenceType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcherSourceElement(AttributeMatcherSourceElement attributeMatcherSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(attributeMatcherSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(attributeMatcherSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcherSourceInterface(AttributeMatcherSourceInterface attributeMatcherSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeMatcherSourceInterface, diagnostics, context);
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
	public boolean validateValueModifierSet(ValueModifierSet valueModifierSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(valueModifierSet, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueModifier(ValueModifier valueModifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(valueModifier, diagnostics, context);
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
	public boolean validateModifiedAttributeElementType(ModifiedAttributeElementType<?, ?, ?, ?> modifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modifiedAttributeElementType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalModifiedAttributeElementType(LocalModifiedAttributeElementType<?, ?, ?, ?> localModifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(localModifiedAttributeElementType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(localModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(localModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(localModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(localModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(localModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(localModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(localModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(localModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(localModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(localModifiedAttributeElementType, diagnostics, context);
		return result;
	}

	/**
	 * Validates the sourceAttributeMatchesSectionOrContainedSection constraint of '<em>Local Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(LocalModifiedAttributeElementType<?, ?, ?, ?> localModifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "sourceAttributeMatchesSectionOrContainedSection", getObjectLabel(localModifiedAttributeElementType, context) },
						 new Object[] { localModifiedAttributeElementType },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateSourceAttributeMatchesSectionOrContainedSection constraint of '<em>Local Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(LocalModifiedAttributeElementType<?, ?, ?, ?> localModifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return localModifiedAttributeElementType.validateSourceAttributeMatchesSectionOrContainedSection(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintGroupImporter(MappingHintGroupImporter mappingHintGroupImporter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mappingHintGroupImporter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mappingHintGroupImporter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappingHintGroupImporter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappingHintGroupImporter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mappingHintGroupImporter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappingHintGroupImporter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mappingHintGroupImporter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappingHintGroupImporter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappingHintGroupImporter, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(mappingHintGroupImporter, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(mappingHintGroupImporter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExportedMappingHintGroup(ExportedMappingHintGroup exportedMappingHintGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(exportedMappingHintGroup, diagnostics, context);
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
	public boolean validateAttributeMappingSourceElement(AttributeMappingSourceElement attributeMappingSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(attributeMappingSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(attributeMappingSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelConnectionHintSourceElement(ModelConnectionHintSourceElement modelConnectionHintSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelConnectionHintSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(modelConnectionHintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelConnectionHintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelConnectionHintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(modelConnectionHintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelConnectionHintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelConnectionHintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelConnectionHintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelConnectionHintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(modelConnectionHintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(modelConnectionHintSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelConnectionHintTargetAttribute(ModelConnectionHintTargetAttribute modelConnectionHintTargetAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelConnectionHintTargetAttribute, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(modelConnectionHintTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelConnectionHintTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelConnectionHintTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(modelConnectionHintTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelConnectionHintTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelConnectionHintTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelConnectionHintTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelConnectionHintTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelConnectionHintTargetAttribute_sourceMatchesPossibleContainerType(modelConnectionHintTargetAttribute, diagnostics, context);
		return result;
	}

	/**
	 * Validates the sourceMatchesPossibleContainerType constraint of '<em>Model Connection Hint Target Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelConnectionHintTargetAttribute_sourceMatchesPossibleContainerType(ModelConnectionHintTargetAttribute modelConnectionHintTargetAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return modelConnectionHintTargetAttribute.sourceMatchesPossibleContainerType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintType(MappingHintType mappingHintType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingHintType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHintImporterMappingHint(HintImporterMappingHint hintImporterMappingHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(hintImporterMappingHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappedAttributeValueExpander(MappedAttributeValueExpander mappedAttributeValueExpander, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappedAttributeValueExpander, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalMappedAttributeValueExpander(LocalMappedAttributeValueExpander localMappedAttributeValueExpander, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(localMappedAttributeValueExpander, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(localMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(localMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(localMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(localMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(localMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(localMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(localMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(localMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(localMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(localMappedAttributeValueExpander, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappedAttributeValuePrepender(MappedAttributeValuePrepender mappedAttributeValuePrepender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mappedAttributeValuePrepender, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(mappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(mappedAttributeValuePrepender, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappedAttributeValueAppender(MappedAttributeValueAppender mappedAttributeValueAppender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mappedAttributeValueAppender, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(mappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(mappedAttributeValueAppender, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFixedValue(FixedValue fixedValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fixedValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalAttribute(GlobalAttribute globalAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(globalAttribute, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(globalAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(globalAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(globalAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(globalAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(globalAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(globalAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(globalAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(globalAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validateGlobalAttribute_sourceAttributeHasUpperBoundOne(globalAttribute, diagnostics, context);
		return result;
	}

	/**
	 * Validates the sourceAttributeHasUpperBoundOne constraint of '<em>Global Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalAttribute_sourceAttributeHasUpperBoundOne(GlobalAttribute globalAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return globalAttribute.sourceAttributeHasUpperBoundOne(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalAttributeImporter(GlobalAttributeImporter globalAttributeImporter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(globalAttributeImporter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMappingSourceInterface(AttributeMappingSourceInterface attributeMappingSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeMappingSourceInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintSourceInterface(MappingHintSourceInterface mappingHintSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingHintSourceInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelConnectionHintSourceInterface(ModelConnectionHintSourceInterface modelConnectionHintSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modelConnectionHintSourceInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMappingExternalSourceElement(AttributeMappingExternalSourceElement attributeMappingExternalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(attributeMappingExternalSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(attributeMappingExternalSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalModifiedAttributeElementType(ExternalModifiedAttributeElementType<?, ?, ?, ?> externalModifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(externalModifiedAttributeElementType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(externalModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(externalModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(externalModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(externalModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(externalModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(externalModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(externalModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(externalModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(externalModifiedAttributeElementType, diagnostics, context);
		return result;
	}

	/**
	 * Validates the sourceAttributeMatchesContainerSection constraint of '<em>External Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(ExternalModifiedAttributeElementType<?, ?, ?, ?> externalModifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return externalModifiedAttributeElementType.sourceAttributeMatchesContainerSection(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelConnectionHintExternalSourceElement(ModelConnectionHintExternalSourceElement modelConnectionHintExternalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelConnectionHintExternalSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(modelConnectionHintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelConnectionHintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelConnectionHintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(modelConnectionHintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelConnectionHintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelConnectionHintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelConnectionHintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelConnectionHintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(modelConnectionHintExternalSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcherExternalSourceElement(AttributeMatcherExternalSourceElement attributeMatcherExternalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(attributeMatcherExternalSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(attributeMatcherExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(attributeMatcherExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(attributeMatcherExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(attributeMatcherExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(attributeMatcherExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(attributeMatcherExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(attributeMatcherExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(attributeMatcherExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(attributeMatcherExternalSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalMappedAttributeValueExpander(ExternalMappedAttributeValueExpander externalMappedAttributeValueExpander, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(externalMappedAttributeValueExpander, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(externalMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(externalMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(externalMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(externalMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(externalMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(externalMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(externalMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(externalMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(externalMappedAttributeValueExpander, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalMappedAttributeValuePrepender(ExternalMappedAttributeValuePrepender externalMappedAttributeValuePrepender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(externalMappedAttributeValuePrepender, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(externalMappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(externalMappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(externalMappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(externalMappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(externalMappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(externalMappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(externalMappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(externalMappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(externalMappedAttributeValuePrepender, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalMappedAttributeValueAppender(ExternalMappedAttributeValueAppender externalMappedAttributeValueAppender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(externalMappedAttributeValueAppender, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(externalMappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(externalMappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(externalMappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(externalMappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(externalMappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(externalMappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(externalMappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(externalMappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(externalMappedAttributeValueAppender, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpandableHint(ExpandableHint expandableHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expandableHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatchToLowerCaseConverter(MatchToLowerCaseConverter matchToLowerCaseConverter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(matchToLowerCaseConverter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatchToUpperCaseConverter(MatchToUpperCaseConverter matchToUpperCaseConverter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(matchToUpperCaseConverter, diagnostics, context);
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
