/**
 */
package pamtram.mapping.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.xtext.oclinecore.validation.OCLinEcoreEObjectValidator;

import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingExternalSourceElement;
import pamtram.mapping.AttributeMappingGlobalSourceElement;
import pamtram.mapping.AttributeMappingSourceElement;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherExternalSourceElement;
import pamtram.mapping.AttributeMatcherGlobalSourceElement;
import pamtram.mapping.AttributeMatcherSourceElement;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ClassMatcher;
import pamtram.mapping.ContainerSelector;
import pamtram.mapping.ContainerSelectorExternalSourceElement;
import pamtram.mapping.ContainerSelectorGlobalSourceElement;
import pamtram.mapping.ContainerSelectorSourceElement;
import pamtram.mapping.ContainerSelectorSourceInterface;
import pamtram.mapping.ContainerSelectorTargetAttribute;
import pamtram.mapping.ExpandableHint;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.ExpressionHint;
import pamtram.mapping.ExternalMappedAttributeValueAppender;
import pamtram.mapping.ExternalMappedAttributeValueExpander;
import pamtram.mapping.ExternalMappedAttributeValuePrepender;
import pamtram.mapping.ExternalModifiedAttributeElementType;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.GlobalModifiedAttributeElementType;
import pamtram.mapping.HintImporterMappingHint;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.LocalMappedAttributeValueExpander;
import pamtram.mapping.LocalModifiedAttributeElementType;
import pamtram.mapping.MappedAttributeValueAppender;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.MappedAttributeValuePrepender;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintBaseType;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingType;
import pamtram.mapping.MatchToLowerCaseConverter;
import pamtram.mapping.MatchToUpperCaseConverter;
import pamtram.mapping.Matcher;
import pamtram.mapping.ModifiableHint;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.mapping.ReferenceTargetSelector;
import pamtram.mapping.StringAppender;
import pamtram.mapping.StringPrepender;
import pamtram.mapping.SubstringReplacer;
import pamtram.mapping.UniqueNumberAppender;
import pamtram.mapping.ValueModifier;
import pamtram.mapping.ValueModifierSet;
import pamtram.util.PamtramValidator;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * 
 * @see pamtram.mapping.MappingPackage
 * @generated
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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Contains Hint Groups' of 'Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING__VALIDATE_CONTAINS_HINT_GROUPS = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Contains Deactivated Hint Groups' of 'Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING__VALIDATE_CONTAINS_DEACTIVATED_HINT_GROUPS = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Target Attribute Matches Section' of 'Attribute Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ATTRIBUTE_MAPPING__VALIDATE_TARGET_ATTRIBUTE_MATCHES_SECTION = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Class Matches Section' of 'Cardinality Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CARDINALITY_MAPPING__VALIDATE_SOURCE_CLASS_MATCHES_SECTION = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Target Class Matches Section' of 'Cardinality Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CARDINALITY_MAPPING__VALIDATE_TARGET_CLASS_MATCHES_SECTION = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Class Is Variable Cardinality' of 'Cardinality Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CARDINALITY_MAPPING__VALIDATE_SOURCE_CLASS_IS_VARIABLE_CARDINALITY = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Target Class Is Variable Cardinality' of 'Cardinality Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CARDINALITY_MAPPING__VALIDATE_TARGET_CLASS_IS_VARIABLE_CARDINALITY = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Cardinality Mapping For Source Section Root' of 'Cardinality Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CARDINALITY_MAPPING__VALIDATE_NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Affected Reference Is Non Containment' of 'Reference Target Selector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REFERENCE_TARGET_SELECTOR__VALIDATE_AFFECTED_REFERENCE_IS_NON_CONTAINMENT = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Affected Reference Matches Section' of 'Reference Target Selector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REFERENCE_TARGET_SELECTOR__VALIDATE_AFFECTED_REFERENCE_MATCHES_SECTION = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Target Matches Affected Reference Type' of 'Attribute Matcher'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ATTRIBUTE_MATCHER__VALIDATE_TARGET_MATCHES_AFFECTED_REFERENCE_TYPE = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Attribute Matches Section Or Contained Section' of 'Local Modified Attribute Element Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Matches Possible Container Type' of 'Container Selector Target Attribute'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONTAINER_SELECTOR_TARGET_ATTRIBUTE__VALIDATE_SOURCE_MATCHES_POSSIBLE_CONTAINER_TYPE = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Attribute Has Upper Bound One' of 'Global Attribute'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int GLOBAL_ATTRIBUTE__VALIDATE_SOURCE_ATTRIBUTE_HAS_UPPER_BOUND_ONE = 14;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Attribute Matches Container Section' of 'External Modified Attribute Element Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION = 15;

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
	protected static final int DIAGNOSTIC_CODE_COUNT = MappingValidator.GENERATED_DIAGNOSTIC_CODE_COUNT;

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
		this.pamtramValidator = PamtramValidator.INSTANCE;
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
				return this.validateMappingType((MappingType)value, diagnostics, context);
			case MappingPackage.MAPPING:
				return this.validateMapping((Mapping)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT_GROUP_TYPE:
				return this.validateMappingHintGroupType((MappingHintGroupType)value, diagnostics, context);
			case MappingPackage.INSTANTIABLE_MAPPING_HINT_GROUP:
				return this.validateInstantiableMappingHintGroup((InstantiableMappingHintGroup)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT_GROUP:
				return this.validateMappingHintGroup((MappingHintGroup)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT_BASE_TYPE:
				return this.validateMappingHintBaseType((MappingHintBaseType)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT:
				return this.validateMappingHint((MappingHint)value, diagnostics, context);
			case MappingPackage.EXPRESSION_HINT:
				return this.validateExpressionHint((ExpressionHint)value, diagnostics, context);
			case MappingPackage.MODIFIABLE_HINT:
				return this.validateModifiableHint((ModifiableHint)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MAPPING:
				return this.validateAttributeMapping((AttributeMapping)value, diagnostics, context);
			case MappingPackage.CARDINALITY_MAPPING:
				return this.validateCardinalityMapping((CardinalityMapping)value, diagnostics, context);
			case MappingPackage.REFERENCE_TARGET_SELECTOR:
				return this.validateReferenceTargetSelector((ReferenceTargetSelector)value, diagnostics, context);
			case MappingPackage.MATCHER:
				return this.validateMatcher((Matcher)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MATCHER:
				return this.validateAttributeMatcher((AttributeMatcher)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MATCHER_SOURCE_ELEMENT:
				return this.validateAttributeMatcherSourceElement((AttributeMatcherSourceElement)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MATCHER_SOURCE_INTERFACE:
				return this.validateAttributeMatcherSourceInterface((AttributeMatcherSourceInterface)value, diagnostics, context);
			case MappingPackage.CLASS_MATCHER:
				return this.validateClassMatcher((ClassMatcher)value, diagnostics, context);
			case MappingPackage.VALUE_MODIFIER_SET:
				return this.validateValueModifierSet((ValueModifierSet)value, diagnostics, context);
			case MappingPackage.VALUE_MODIFIER:
				return this.validateValueModifier((ValueModifier)value, diagnostics, context);
			case MappingPackage.SUBSTRING_REPLACER:
				return this.validateSubstringReplacer((SubstringReplacer)value, diagnostics, context);
			case MappingPackage.STRING_APPENDER:
				return this.validateStringAppender((StringAppender)value, diagnostics, context);
			case MappingPackage.UNIQUE_NUMBER_APPENDER:
				return this.validateUniqueNumberAppender((UniqueNumberAppender)value, diagnostics, context);
			case MappingPackage.STRING_PREPENDER:
				return this.validateStringPrepender((StringPrepender)value, diagnostics, context);
			case MappingPackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE:
				return this.validateModifiedAttributeElementType((ModifiedAttributeElementType<?, ?, ?, ?>)value, diagnostics, context);
			case MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE:
				return this.validateLocalModifiedAttributeElementType((LocalModifiedAttributeElementType<?, ?, ?, ?>)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER:
				return this.validateMappingHintGroupImporter((MappingHintGroupImporter)value, diagnostics, context);
			case MappingPackage.EXPORTED_MAPPING_HINT_GROUP:
				return this.validateExportedMappingHintGroup((ExportedMappingHintGroup)value, diagnostics, context);
			case MappingPackage.CONTAINER_SELECTOR:
				return this.validateContainerSelector((ContainerSelector)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT:
				return this.validateAttributeMappingSourceElement((AttributeMappingSourceElement)value, diagnostics, context);
			case MappingPackage.CONTAINER_SELECTOR_SOURCE_ELEMENT:
				return this.validateContainerSelectorSourceElement((ContainerSelectorSourceElement)value, diagnostics, context);
			case MappingPackage.CONTAINER_SELECTOR_TARGET_ATTRIBUTE:
				return this.validateContainerSelectorTargetAttribute((ContainerSelectorTargetAttribute)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT_TYPE:
				return this.validateMappingHintType((MappingHintType)value, diagnostics, context);
			case MappingPackage.HINT_IMPORTER_MAPPING_HINT:
				return this.validateHintImporterMappingHint((HintImporterMappingHint)value, diagnostics, context);
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER:
				return this.validateMappedAttributeValueExpander((MappedAttributeValueExpander)value, diagnostics, context);
			case MappingPackage.LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER:
				return this.validateLocalMappedAttributeValueExpander((LocalMappedAttributeValueExpander)value, diagnostics, context);
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_PREPENDER:
				return this.validateMappedAttributeValuePrepender((MappedAttributeValuePrepender)value, diagnostics, context);
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_APPENDER:
				return this.validateMappedAttributeValueAppender((MappedAttributeValueAppender)value, diagnostics, context);
			case MappingPackage.FIXED_VALUE:
				return this.validateFixedValue((FixedValue)value, diagnostics, context);
			case MappingPackage.GLOBAL_ATTRIBUTE:
				return this.validateGlobalAttribute((GlobalAttribute)value, diagnostics, context);
			case MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER:
				return this.validateGlobalAttributeImporter((GlobalAttributeImporter)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_INTERFACE:
				return this.validateAttributeMappingSourceInterface((AttributeMappingSourceInterface)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT_SOURCE_INTERFACE:
				return this.validateMappingHintSourceInterface((MappingHintSourceInterface)value, diagnostics, context);
			case MappingPackage.CONTAINER_SELECTOR_SOURCE_INTERFACE:
				return this.validateContainerSelectorSourceInterface((ContainerSelectorSourceInterface)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT:
				return this.validateAttributeMappingExternalSourceElement((AttributeMappingExternalSourceElement)value, diagnostics, context);
			case MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE:
				return this.validateExternalModifiedAttributeElementType((ExternalModifiedAttributeElementType<?, ?, ?, ?>)value, diagnostics, context);
			case MappingPackage.CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT:
				return this.validateContainerSelectorExternalSourceElement((ContainerSelectorExternalSourceElement)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT:
				return this.validateAttributeMatcherExternalSourceElement((AttributeMatcherExternalSourceElement)value, diagnostics, context);
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER:
				return this.validateExternalMappedAttributeValueExpander((ExternalMappedAttributeValueExpander)value, diagnostics, context);
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER:
				return this.validateExternalMappedAttributeValuePrepender((ExternalMappedAttributeValuePrepender)value, diagnostics, context);
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER:
				return this.validateExternalMappedAttributeValueAppender((ExternalMappedAttributeValueAppender)value, diagnostics, context);
			case MappingPackage.EXPANDABLE_HINT:
				return this.validateExpandableHint((ExpandableHint)value, diagnostics, context);
			case MappingPackage.MATCH_TO_LOWER_CASE_CONVERTER:
				return this.validateMatchToLowerCaseConverter((MatchToLowerCaseConverter)value, diagnostics, context);
			case MappingPackage.MATCH_TO_UPPER_CASE_CONVERTER:
				return this.validateMatchToUpperCaseConverter((MatchToUpperCaseConverter)value, diagnostics, context);
			case MappingPackage.GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE:
				return this.validateGlobalModifiedAttributeElementType((GlobalModifiedAttributeElementType<?, ?, ?, ?>)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT:
				return this.validateAttributeMatcherGlobalSourceElement((AttributeMatcherGlobalSourceElement)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT:
				return this.validateAttributeMappingGlobalSourceElement((AttributeMappingGlobalSourceElement)value, diagnostics, context);
			case MappingPackage.CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT:
				return this.validateContainerSelectorGlobalSourceElement((ContainerSelectorGlobalSourceElement)value, diagnostics, context);
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
		return this.validate_EveryDefaultConstraint(mappingType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(mapping, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(mapping, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(mapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(mapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(mapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(mapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(mapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(mapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(mapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(mapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(mapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(mapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(mapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateMapping_containsHintGroups(mapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateMapping_containsDeactivatedHintGroups(mapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateMapping_validateContainsHintGroups(mapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateMapping_validateContainsDeactivatedHintGroups(mapping, diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the containsHintGroups constraint of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping_containsHintGroups(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
				(this.createDiagnostic
						(Diagnostic.ERROR,
								MappingValidator.DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "containsHintGroups", EObjectValidator.getObjectLabel(mapping, context) },
								new Object[] { mapping },
								context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the containsDeactivatedHintGroups constraint of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping_containsDeactivatedHintGroups(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
				(this.createDiagnostic
						(Diagnostic.ERROR,
								MappingValidator.DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "containsDeactivatedHintGroups", EObjectValidator.getObjectLabel(mapping, context) },
								new Object[] { mapping },
								context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateContainsHintGroups constraint of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping_validateContainsHintGroups(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mapping.validateContainsHintGroups(diagnostics, context);
	}

	/**
	 * Validates the validateContainsDeactivatedHintGroups constraint of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping_validateContainsDeactivatedHintGroups(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mapping.validateContainsDeactivatedHintGroups(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintGroupType(MappingHintGroupType mappingHintGroupType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(mappingHintGroupType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstantiableMappingHintGroup(InstantiableMappingHintGroup instantiableMappingHintGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(instantiableMappingHintGroup, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(instantiableMappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(instantiableMappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(instantiableMappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(instantiableMappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(instantiableMappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(instantiableMappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(instantiableMappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(instantiableMappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(instantiableMappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(instantiableMappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(instantiableMappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(instantiableMappingHintGroup, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintGroup(MappingHintGroup mappingHintGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(mappingHintGroup, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(mappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(mappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(mappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(mappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(mappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(mappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(mappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(mappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(mappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(mappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(mappingHintGroup, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(mappingHintGroup, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintBaseType(MappingHintBaseType mappingHintBaseType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(mappingHintBaseType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHint(MappingHint mappingHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(mappingHint, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(mappingHint, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(mappingHint, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(mappingHint, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(mappingHint, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(mappingHint, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(mappingHint, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(mappingHint, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(mappingHint, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(mappingHint, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(mappingHint, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(mappingHint, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(mappingHint, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionHint(ExpressionHint expressionHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(expressionHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModifiableHint(ModifiableHint modifiableHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(modifiableHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMapping(AttributeMapping attributeMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(attributeMapping, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateAttributeMapping_targetAttributeMatchesSection(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateAttributeMapping_validateTargetAttributeMatchesSection(attributeMapping, diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the targetAttributeMatchesSection constraint of '<em>Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMapping_targetAttributeMatchesSection(AttributeMapping attributeMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
				(this.createDiagnostic
						(Diagnostic.ERROR,
								MappingValidator.DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "targetAttributeMatchesSection", EObjectValidator.getObjectLabel(attributeMapping, context) },
								new Object[] { attributeMapping },
								context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateTargetAttributeMatchesSection constraint of '<em>Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMapping_validateTargetAttributeMatchesSection(AttributeMapping attributeMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return attributeMapping.validateTargetAttributeMatchesSection(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(cardinalityMapping, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateCardinalityMapping_sourceClassMatchesSection(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateCardinalityMapping_sourceClassIsVariableCardinality(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateCardinalityMapping_targetClassMatchesSection(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateCardinalityMapping_targetClassIsVariableCardinality(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateCardinalityMapping_noCardinalityMappingForSourceSectionRoot(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateCardinalityMapping_validateSourceClassMatchesSection(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateCardinalityMapping_validateTargetClassMatchesSection(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateCardinalityMapping_validateSourceClassIsVariableCardinality(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateCardinalityMapping_validateTargetClassIsVariableCardinality(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateCardinalityMapping_validateNoCardinalityMappingForSourceSectionRoot(cardinalityMapping, diagnostics, context);
		}
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
				(this.createDiagnostic
						(Diagnostic.ERROR,
								MappingValidator.DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "sourceClassMatchesSection", EObjectValidator.getObjectLabel(cardinalityMapping, context) },
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
				(this.createDiagnostic
						(Diagnostic.ERROR,
								MappingValidator.DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "sourceClassIsVariableCardinality", EObjectValidator.getObjectLabel(cardinalityMapping, context) },
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
				(this.createDiagnostic
						(Diagnostic.ERROR,
								MappingValidator.DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "targetClassMatchesSection", EObjectValidator.getObjectLabel(cardinalityMapping, context) },
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
				(this.createDiagnostic
						(Diagnostic.ERROR,
								MappingValidator.DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "targetClassIsVariableCardinality", EObjectValidator.getObjectLabel(cardinalityMapping, context) },
								new Object[] { cardinalityMapping },
								context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the noCardinalityMappingForSourceSectionRoot constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_noCardinalityMappingForSourceSectionRoot(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
				(this.createDiagnostic
						(Diagnostic.ERROR,
								MappingValidator.DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "noCardinalityMappingForSourceSectionRoot", EObjectValidator.getObjectLabel(cardinalityMapping, context) },
								new Object[] { cardinalityMapping },
								context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateSourceClassMatchesSection constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_validateSourceClassMatchesSection(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return cardinalityMapping.validateSourceClassMatchesSection(diagnostics, context);
	}

	/**
	 * Validates the validateTargetClassMatchesSection constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_validateTargetClassMatchesSection(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return cardinalityMapping.validateTargetClassMatchesSection(diagnostics, context);
	}

	/**
	 * Validates the validateSourceClassIsVariableCardinality constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_validateSourceClassIsVariableCardinality(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return cardinalityMapping.validateSourceClassIsVariableCardinality(diagnostics, context);
	}

	/**
	 * Validates the validateTargetClassIsVariableCardinality constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_validateTargetClassIsVariableCardinality(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return cardinalityMapping.validateTargetClassIsVariableCardinality(diagnostics, context);
	}

	/**
	 * Validates the validateNoCardinalityMappingForSourceSectionRoot constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_validateNoCardinalityMappingForSourceSectionRoot(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return cardinalityMapping.validateNoCardinalityMappingForSourceSectionRoot(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceTargetSelector(ReferenceTargetSelector referenceTargetSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(referenceTargetSelector, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(referenceTargetSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(referenceTargetSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(referenceTargetSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(referenceTargetSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(referenceTargetSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(referenceTargetSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(referenceTargetSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(referenceTargetSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(referenceTargetSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(referenceTargetSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(referenceTargetSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateReferenceTargetSelector_affectedReferenceIsNonContainment(referenceTargetSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateReferenceTargetSelector_affectedReferenceMatchesSection(referenceTargetSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateReferenceTargetSelector_validateAffectedReferenceIsNonContainment(referenceTargetSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateReferenceTargetSelector_validateAffectedReferenceMatchesSection(referenceTargetSelector, diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the affectedReferenceIsNonContainment constraint of '<em>Reference Target Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceTargetSelector_affectedReferenceIsNonContainment(ReferenceTargetSelector referenceTargetSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
				(this.createDiagnostic
						(Diagnostic.ERROR,
								MappingValidator.DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "affectedReferenceIsNonContainment", EObjectValidator.getObjectLabel(referenceTargetSelector, context) },
								new Object[] { referenceTargetSelector },
								context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the affectedReferenceMatchesSection constraint of '<em>Reference Target Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceTargetSelector_affectedReferenceMatchesSection(ReferenceTargetSelector referenceTargetSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
				(this.createDiagnostic
						(Diagnostic.ERROR,
								MappingValidator.DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "affectedReferenceMatchesSection", EObjectValidator.getObjectLabel(referenceTargetSelector, context) },
								new Object[] { referenceTargetSelector },
								context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateAffectedReferenceIsNonContainment constraint of '<em>Reference Target Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceTargetSelector_validateAffectedReferenceIsNonContainment(ReferenceTargetSelector referenceTargetSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return referenceTargetSelector.validateAffectedReferenceIsNonContainment(diagnostics, context);
	}

	/**
	 * Validates the validateAffectedReferenceMatchesSection constraint of '<em>Reference Target Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceTargetSelector_validateAffectedReferenceMatchesSection(ReferenceTargetSelector referenceTargetSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return referenceTargetSelector.validateAffectedReferenceMatchesSection(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatcher(Matcher matcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(matcher, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcher(AttributeMatcher attributeMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(attributeMatcher, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(attributeMatcher, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(attributeMatcher, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(attributeMatcher, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(attributeMatcher, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(attributeMatcher, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(attributeMatcher, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(attributeMatcher, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(attributeMatcher, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateAttributeMatcher_targetMatchesAffectedReferenceType(attributeMatcher, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateAttributeMatcher_validateTargetMatchesAffectedReferenceType(attributeMatcher, diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the targetMatchesAffectedReferenceType constraint of '<em>Attribute Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcher_targetMatchesAffectedReferenceType(AttributeMatcher attributeMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
				(this.createDiagnostic
						(Diagnostic.ERROR,
								MappingValidator.DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "targetMatchesAffectedReferenceType", EObjectValidator.getObjectLabel(attributeMatcher, context) },
								new Object[] { attributeMatcher },
								context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateTargetMatchesAffectedReferenceType constraint of '<em>Attribute Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcher_validateTargetMatchesAffectedReferenceType(AttributeMatcher attributeMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return attributeMatcher.validateTargetMatchesAffectedReferenceType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcherSourceElement(AttributeMatcherSourceElement attributeMatcherSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(attributeMatcherSourceElement, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(attributeMatcherSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(attributeMatcherSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(attributeMatcherSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(attributeMatcherSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(attributeMatcherSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(attributeMatcherSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(attributeMatcherSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(attributeMatcherSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(attributeMatcherSourceElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcherSourceInterface(AttributeMatcherSourceInterface attributeMatcherSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(attributeMatcherSourceInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassMatcher(ClassMatcher classMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(classMatcher, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueModifierSet(ValueModifierSet valueModifierSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(valueModifierSet, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueModifier(ValueModifier valueModifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(valueModifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubstringReplacer(SubstringReplacer substringReplacer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(substringReplacer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringAppender(StringAppender stringAppender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(stringAppender, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUniqueNumberAppender(UniqueNumberAppender uniqueNumberAppender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(uniqueNumberAppender, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringPrepender(StringPrepender stringPrepender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(stringPrepender, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModifiedAttributeElementType(ModifiedAttributeElementType<?, ?, ?, ?> modifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(modifiedAttributeElementType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalModifiedAttributeElementType(LocalModifiedAttributeElementType<?, ?, ?, ?> localModifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(localModifiedAttributeElementType, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(localModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(localModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(localModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(localModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(localModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(localModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(localModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(localModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(localModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(localModifiedAttributeElementType, diagnostics, context);
		}
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
				(this.createDiagnostic
						(Diagnostic.ERROR,
								MappingValidator.DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "sourceAttributeMatchesSectionOrContainedSection", EObjectValidator.getObjectLabel(localModifiedAttributeElementType, context) },
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
		if (!this.validate_NoCircularContainment(mappingHintGroupImporter, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(mappingHintGroupImporter, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(mappingHintGroupImporter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(mappingHintGroupImporter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(mappingHintGroupImporter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(mappingHintGroupImporter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(mappingHintGroupImporter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(mappingHintGroupImporter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(mappingHintGroupImporter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(mappingHintGroupImporter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(mappingHintGroupImporter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(mappingHintGroupImporter, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(mappingHintGroupImporter, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExportedMappingHintGroup(ExportedMappingHintGroup exportedMappingHintGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(exportedMappingHintGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerSelector(ContainerSelector containerSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(containerSelector, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMappingSourceElement(AttributeMappingSourceElement attributeMappingSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(attributeMappingSourceElement, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(attributeMappingSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(attributeMappingSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(attributeMappingSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(attributeMappingSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(attributeMappingSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(attributeMappingSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(attributeMappingSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(attributeMappingSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(attributeMappingSourceElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerSelectorSourceElement(ContainerSelectorSourceElement containerSelectorSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(containerSelectorSourceElement, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(containerSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(containerSelectorSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(containerSelectorSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(containerSelectorSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(containerSelectorSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(containerSelectorSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(containerSelectorSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(containerSelectorSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(containerSelectorSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(containerSelectorSourceElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerSelectorTargetAttribute(ContainerSelectorTargetAttribute containerSelectorTargetAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(containerSelectorTargetAttribute, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(containerSelectorTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(containerSelectorTargetAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(containerSelectorTargetAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(containerSelectorTargetAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(containerSelectorTargetAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(containerSelectorTargetAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(containerSelectorTargetAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(containerSelectorTargetAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateContainerSelectorTargetAttribute_sourceMatchesPossibleContainerType(containerSelectorTargetAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateContainerSelectorTargetAttribute_validateSourceMatchesPossibleContainerType(containerSelectorTargetAttribute, diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the sourceMatchesPossibleContainerType constraint of '<em>Container Selector Target Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerSelectorTargetAttribute_sourceMatchesPossibleContainerType(ContainerSelectorTargetAttribute containerSelectorTargetAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
				(this.createDiagnostic
						(Diagnostic.ERROR,
								MappingValidator.DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "sourceMatchesPossibleContainerType", EObjectValidator.getObjectLabel(containerSelectorTargetAttribute, context) },
								new Object[] { containerSelectorTargetAttribute },
								context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateSourceMatchesPossibleContainerType constraint of '<em>Container Selector Target Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerSelectorTargetAttribute_validateSourceMatchesPossibleContainerType(ContainerSelectorTargetAttribute containerSelectorTargetAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return containerSelectorTargetAttribute.validateSourceMatchesPossibleContainerType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintType(MappingHintType mappingHintType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(mappingHintType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHintImporterMappingHint(HintImporterMappingHint hintImporterMappingHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(hintImporterMappingHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappedAttributeValueExpander(MappedAttributeValueExpander mappedAttributeValueExpander, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(mappedAttributeValueExpander, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalMappedAttributeValueExpander(LocalMappedAttributeValueExpander localMappedAttributeValueExpander, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(localMappedAttributeValueExpander, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(localMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(localMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(localMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(localMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(localMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(localMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(localMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(localMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(localMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(localMappedAttributeValueExpander, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappedAttributeValuePrepender(MappedAttributeValuePrepender mappedAttributeValuePrepender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(mappedAttributeValuePrepender, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(mappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(mappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(mappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(mappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(mappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(mappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(mappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(mappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(mappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(mappedAttributeValuePrepender, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappedAttributeValueAppender(MappedAttributeValueAppender mappedAttributeValueAppender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(mappedAttributeValueAppender, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(mappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(mappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(mappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(mappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(mappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(mappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(mappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(mappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(mappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(mappedAttributeValueAppender, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFixedValue(FixedValue fixedValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(fixedValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalAttribute(GlobalAttribute globalAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(globalAttribute, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(globalAttribute, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(globalAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(globalAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(globalAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(globalAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(globalAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(globalAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(globalAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateGlobalAttribute_sourceAttributeHasUpperBoundOne(globalAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateGlobalAttribute_validateSourceAttributeHasUpperBoundOne(globalAttribute, diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the sourceAttributeHasUpperBoundOne constraint of '<em>Global Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalAttribute_sourceAttributeHasUpperBoundOne(GlobalAttribute globalAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
				(this.createDiagnostic
						(Diagnostic.ERROR,
								MappingValidator.DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "sourceAttributeHasUpperBoundOne", EObjectValidator.getObjectLabel(globalAttribute, context) },
								new Object[] { globalAttribute },
								context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateSourceAttributeHasUpperBoundOne constraint of '<em>Global Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalAttribute_validateSourceAttributeHasUpperBoundOne(GlobalAttribute globalAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return globalAttribute.validateSourceAttributeHasUpperBoundOne(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalAttributeImporter(GlobalAttributeImporter globalAttributeImporter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(globalAttributeImporter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMappingSourceInterface(AttributeMappingSourceInterface attributeMappingSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(attributeMappingSourceInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintSourceInterface(MappingHintSourceInterface mappingHintSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(mappingHintSourceInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerSelectorSourceInterface(ContainerSelectorSourceInterface containerSelectorSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(containerSelectorSourceInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMappingExternalSourceElement(AttributeMappingExternalSourceElement attributeMappingExternalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(attributeMappingExternalSourceElement, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(attributeMappingExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(attributeMappingExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(attributeMappingExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(attributeMappingExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(attributeMappingExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(attributeMappingExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(attributeMappingExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(attributeMappingExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(attributeMappingExternalSourceElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalModifiedAttributeElementType(ExternalModifiedAttributeElementType<?, ?, ?, ?> externalModifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(externalModifiedAttributeElementType, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(externalModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(externalModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(externalModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(externalModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(externalModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(externalModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(externalModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(externalModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(externalModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(externalModifiedAttributeElementType, diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the sourceAttributeMatchesContainerSection constraint of '<em>External Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(ExternalModifiedAttributeElementType<?, ?, ?, ?> externalModifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
				(this.createDiagnostic
						(Diagnostic.ERROR,
								MappingValidator.DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "sourceAttributeMatchesContainerSection", EObjectValidator.getObjectLabel(externalModifiedAttributeElementType, context) },
								new Object[] { externalModifiedAttributeElementType },
								context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateSourceAttributeMatchesContainerSection constraint of '<em>External Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(ExternalModifiedAttributeElementType<?, ?, ?, ?> externalModifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return externalModifiedAttributeElementType.validateSourceAttributeMatchesContainerSection(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerSelectorExternalSourceElement(ContainerSelectorExternalSourceElement containerSelectorExternalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(containerSelectorExternalSourceElement, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(containerSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(containerSelectorExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(containerSelectorExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(containerSelectorExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(containerSelectorExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(containerSelectorExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(containerSelectorExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(containerSelectorExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(containerSelectorExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(containerSelectorExternalSourceElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcherExternalSourceElement(AttributeMatcherExternalSourceElement attributeMatcherExternalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(attributeMatcherExternalSourceElement, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(attributeMatcherExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalMappedAttributeValueExpander(ExternalMappedAttributeValueExpander externalMappedAttributeValueExpander, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(externalMappedAttributeValueExpander, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(externalMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(externalMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(externalMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(externalMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(externalMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(externalMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(externalMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(externalMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(externalMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(externalMappedAttributeValueExpander, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalMappedAttributeValuePrepender(ExternalMappedAttributeValuePrepender externalMappedAttributeValuePrepender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(externalMappedAttributeValuePrepender, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(externalMappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalMappedAttributeValueAppender(ExternalMappedAttributeValueAppender externalMappedAttributeValueAppender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(externalMappedAttributeValueAppender, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(externalMappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(externalMappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(externalMappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(externalMappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(externalMappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(externalMappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(externalMappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(externalMappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(externalMappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(externalMappedAttributeValueAppender, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpandableHint(ExpandableHint expandableHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(expandableHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatchToLowerCaseConverter(MatchToLowerCaseConverter matchToLowerCaseConverter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(matchToLowerCaseConverter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatchToUpperCaseConverter(MatchToUpperCaseConverter matchToUpperCaseConverter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(matchToUpperCaseConverter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalModifiedAttributeElementType(GlobalModifiedAttributeElementType<?, ?, ?, ?> globalModifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(globalModifiedAttributeElementType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcherGlobalSourceElement(AttributeMatcherGlobalSourceElement attributeMatcherGlobalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(attributeMatcherGlobalSourceElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMappingGlobalSourceElement(AttributeMappingGlobalSourceElement attributeMappingGlobalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(attributeMappingGlobalSourceElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerSelectorGlobalSourceElement(ContainerSelectorGlobalSourceElement containerSelectorGlobalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(containerSelectorGlobalSourceElement, diagnostics, context);
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
