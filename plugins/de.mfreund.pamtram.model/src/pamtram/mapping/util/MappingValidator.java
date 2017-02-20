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
import pamtram.structure.util.StructureValidator;
import pamtram.util.PamtramValidator;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Element Matches Section' of 'Cardinality Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CARDINALITY_MAPPING__VALIDATE_SOURCE_ELEMENT_MATCHES_SECTION = 4;

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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Matches Possible Container Type' of 'Container Selector Target Attribute'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONTAINER_SELECTOR_TARGET_ATTRIBUTE__VALIDATE_SOURCE_MATCHES_POSSIBLE_CONTAINER_TYPE = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Attribute Has Upper Bound One' of 'Global Attribute'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int GLOBAL_ATTRIBUTE__VALIDATE_SOURCE_ATTRIBUTE_HAS_UPPER_BOUND_ONE = 13;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 13;

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
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructureValidator structureValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingValidator() {
		super();
		pamtramValidator = PamtramValidator.INSTANCE;
		structureValidator = StructureValidator.INSTANCE;
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
			case MappingPackage.ATTRIBUTE_MAPPING:
				return validateAttributeMapping((AttributeMapping)value, diagnostics, context);
			case MappingPackage.CARDINALITY_MAPPING:
				return validateCardinalityMapping((CardinalityMapping)value, diagnostics, context);
			case MappingPackage.REFERENCE_TARGET_SELECTOR:
				return validateReferenceTargetSelector((ReferenceTargetSelector)value, diagnostics, context);
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
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER:
				return validateMappingHintGroupImporter((MappingHintGroupImporter)value, diagnostics, context);
			case MappingPackage.EXPORTED_MAPPING_HINT_GROUP:
				return validateExportedMappingHintGroup((ExportedMappingHintGroup)value, diagnostics, context);
			case MappingPackage.CONTAINER_SELECTOR:
				return validateContainerSelector((ContainerSelector)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT:
				return validateAttributeMappingSourceElement((AttributeMappingSourceElement)value, diagnostics, context);
			case MappingPackage.CONTAINER_SELECTOR_SOURCE_ELEMENT:
				return validateContainerSelectorSourceElement((ContainerSelectorSourceElement)value, diagnostics, context);
			case MappingPackage.CONTAINER_SELECTOR_TARGET_ATTRIBUTE:
				return validateContainerSelectorTargetAttribute((ContainerSelectorTargetAttribute)value, diagnostics, context);
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
			case MappingPackage.GLOBAL_ATTRIBUTE:
				return validateGlobalAttribute((GlobalAttribute)value, diagnostics, context);
			case MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER:
				return validateGlobalAttributeImporter((GlobalAttributeImporter)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_INTERFACE:
				return validateAttributeMappingSourceInterface((AttributeMappingSourceInterface)value, diagnostics, context);
			case MappingPackage.MAPPING_HINT_SOURCE_INTERFACE:
				return validateMappingHintSourceInterface((MappingHintSourceInterface)value, diagnostics, context);
			case MappingPackage.CONTAINER_SELECTOR_SOURCE_INTERFACE:
				return validateContainerSelectorSourceInterface((ContainerSelectorSourceInterface)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT:
				return validateAttributeMappingExternalSourceElement((AttributeMappingExternalSourceElement)value, diagnostics, context);
			case MappingPackage.CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT:
				return validateContainerSelectorExternalSourceElement((ContainerSelectorExternalSourceElement)value, diagnostics, context);
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
			case MappingPackage.ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT:
				return validateAttributeMatcherGlobalSourceElement((AttributeMatcherGlobalSourceElement)value, diagnostics, context);
			case MappingPackage.ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT:
				return validateAttributeMappingGlobalSourceElement((AttributeMappingGlobalSourceElement)value, diagnostics, context);
			case MappingPackage.CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT:
				return validateContainerSelectorGlobalSourceElement((ContainerSelectorGlobalSourceElement)value, diagnostics, context);
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
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMapping_containsHintGroups(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMapping_containsDeactivatedHintGroups(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMapping_validateContainsHintGroups(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMapping_validateContainsDeactivatedHintGroups(mapping, diagnostics, context);
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
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "containsHintGroups", getObjectLabel(mapping, context) },
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
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "containsDeactivatedHintGroups", getObjectLabel(mapping, context) },
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
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(instantiableMappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(instantiableMappingHintGroup, diagnostics, context);
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
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(mappingHintGroup, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(mappingHintGroup, diagnostics, context);
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
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(mappingHint, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(mappingHint, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateAttributeMapping_targetAttributeMatchesSection(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateAttributeMapping_validateTargetAttributeMatchesSection(attributeMapping, diagnostics, context);
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
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "targetAttributeMatchesSection", getObjectLabel(attributeMapping, context) },
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
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_sourceClassMatchesSection(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_sourceClassIsVariableCardinality(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_targetClassMatchesSection(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_targetClassIsVariableCardinality(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_noCardinalityMappingForSourceSectionRoot(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_validateSourceElementMatchesSection(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_validateTargetClassMatchesSection(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_validateSourceClassIsVariableCardinality(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_validateTargetClassIsVariableCardinality(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_validateNoCardinalityMappingForSourceSectionRoot(cardinalityMapping, diagnostics, context);
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
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "noCardinalityMappingForSourceSectionRoot", getObjectLabel(cardinalityMapping, context) },
						 new Object[] { cardinalityMapping },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateSourceElementMatchesSection constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_validateSourceElementMatchesSection(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return cardinalityMapping.validateSourceElementMatchesSection(diagnostics, context);
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
		if (!validate_NoCircularContainment(referenceTargetSelector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateReferenceTargetSelector_affectedReferenceIsNonContainment(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateReferenceTargetSelector_affectedReferenceMatchesSection(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateReferenceTargetSelector_validateAffectedReferenceIsNonContainment(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateReferenceTargetSelector_validateAffectedReferenceMatchesSection(referenceTargetSelector, diagnostics, context);
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
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "affectedReferenceIsNonContainment", getObjectLabel(referenceTargetSelector, context) },
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
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "affectedReferenceMatchesSection", getObjectLabel(referenceTargetSelector, context) },
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
		if (result || diagnostics != null) result &= validateAttributeMatcher_validateTargetMatchesAffectedReferenceType(attributeMatcher, diagnostics, context);
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
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "targetMatchesAffectedReferenceType", getObjectLabel(attributeMatcher, context) },
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
		if (!validate_NoCircularContainment(attributeMatcherSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(attributeMatcherSourceElement, diagnostics, context);
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
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(mappingHintGroupImporter, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(mappingHintGroupImporter, diagnostics, context);
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
	public boolean validateContainerSelector(ContainerSelector containerSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(containerSelector, diagnostics, context);
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
		if (result || diagnostics != null) result &= structureValidator.validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(attributeMappingSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerSelectorSourceElement(ContainerSelectorSourceElement containerSelectorSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(containerSelectorSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(containerSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(containerSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(containerSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(containerSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(containerSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(containerSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(containerSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(containerSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(containerSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(containerSelectorSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerSelectorTargetAttribute(ContainerSelectorTargetAttribute containerSelectorTargetAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(containerSelectorTargetAttribute, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(containerSelectorTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(containerSelectorTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(containerSelectorTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(containerSelectorTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(containerSelectorTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(containerSelectorTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(containerSelectorTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(containerSelectorTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validateContainerSelectorTargetAttribute_sourceMatchesPossibleContainerType(containerSelectorTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validateContainerSelectorTargetAttribute_validateSourceMatchesPossibleContainerType(containerSelectorTargetAttribute, diagnostics, context);
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
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "sourceMatchesPossibleContainerType", getObjectLabel(containerSelectorTargetAttribute, context) },
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
		if (result || diagnostics != null) result &= structureValidator.validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(localMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(localMappedAttributeValueExpander, diagnostics, context);
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
		if (result || diagnostics != null) result &= structureValidator.validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(mappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(mappedAttributeValuePrepender, diagnostics, context);
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
		if (result || diagnostics != null) result &= structureValidator.validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(mappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(mappedAttributeValueAppender, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= validateGlobalAttribute_validateSourceAttributeHasUpperBoundOne(globalAttribute, diagnostics, context);
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
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "sourceAttributeHasUpperBoundOne", getObjectLabel(globalAttribute, context) },
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
	public boolean validateContainerSelectorSourceInterface(ContainerSelectorSourceInterface containerSelectorSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(containerSelectorSourceInterface, diagnostics, context);
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
		if (result || diagnostics != null) result &= structureValidator.validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(attributeMappingExternalSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerSelectorExternalSourceElement(ContainerSelectorExternalSourceElement containerSelectorExternalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(containerSelectorExternalSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(containerSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(containerSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(containerSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(containerSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(containerSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(containerSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(containerSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(containerSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(containerSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(containerSelectorExternalSourceElement, diagnostics, context);
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
		if (result || diagnostics != null) result &= structureValidator.validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(attributeMatcherExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(attributeMatcherExternalSourceElement, diagnostics, context);
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
		if (result || diagnostics != null) result &= structureValidator.validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(externalMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(externalMappedAttributeValueExpander, diagnostics, context);
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
		if (result || diagnostics != null) result &= structureValidator.validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(externalMappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(externalMappedAttributeValuePrepender, diagnostics, context);
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
		if (result || diagnostics != null) result &= structureValidator.validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(externalMappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(externalMappedAttributeValueAppender, diagnostics, context);
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
	public boolean validateAttributeMatcherGlobalSourceElement(AttributeMatcherGlobalSourceElement attributeMatcherGlobalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeMatcherGlobalSourceElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMappingGlobalSourceElement(AttributeMappingGlobalSourceElement attributeMappingGlobalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeMappingGlobalSourceElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerSelectorGlobalSourceElement(ContainerSelectorGlobalSourceElement containerSelectorGlobalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(containerSelectorGlobalSourceElement, diagnostics, context);
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
