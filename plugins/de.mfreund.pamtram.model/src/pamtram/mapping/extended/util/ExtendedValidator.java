/**
 */
package pamtram.mapping.extended.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import pamtram.mapping.extended.*;

import pamtram.structure.util.StructureValidator;

import pamtram.util.PamtramValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see pamtram.mapping.extended.ExtendedPackage
 * @generated
 */
public class ExtendedValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ExtendedValidator INSTANCE = new ExtendedValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "pamtram.mapping.extended";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Overwrites Valid Mapping Hint' of 'Mapping Hint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING_HINT__VALIDATE_OVERWRITES_VALID_MAPPING_HINT = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Consider Overwriting Hint' of 'Mapping Hint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING_HINT__VALIDATE_CONSIDER_OVERWRITING_HINT = 2;

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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Source Or Source Elements' of 'Cardinality Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CARDINALITY_MAPPING__VALIDATE_ONLY_SOURCE_OR_SOURCE_ELEMENTS = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Expression Only For Source Elements' of 'Cardinality Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CARDINALITY_MAPPING__VALIDATE_EXPRESSION_ONLY_FOR_SOURCE_ELEMENTS = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Modifiers Only For Source Elements' of 'Cardinality Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CARDINALITY_MAPPING__VALIDATE_MODIFIERS_ONLY_FOR_SOURCE_ELEMENTS = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Affected Reference Is Non Containment' of 'Reference Target Selector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REFERENCE_TARGET_SELECTOR__VALIDATE_AFFECTED_REFERENCE_IS_NON_CONTAINMENT = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Affected Reference Matches Section' of 'Reference Target Selector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REFERENCE_TARGET_SELECTOR__VALIDATE_AFFECTED_REFERENCE_MATCHES_SECTION = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Target Class' of 'Reference Target Selector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REFERENCE_TARGET_SELECTOR__VALIDATE_TARGET_CLASS = 14;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Target Class Matches Possible Container Type' of 'Container Selector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONTAINER_SELECTOR__VALIDATE_TARGET_CLASS_MATCHES_POSSIBLE_CONTAINER_TYPE = 15;

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
	public ExtendedValidator() {
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
	  return ExtendedPackage.eINSTANCE;
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
			case ExtendedPackage.MAPPING_HINT_BASE_TYPE:
				return validateMappingHintBaseType((MappingHintBaseType)value, diagnostics, context);
			case ExtendedPackage.MAPPING_HINT_TYPE:
				return validateMappingHintType((MappingHintType)value, diagnostics, context);
			case ExtendedPackage.MAPPING_HINT:
				return validateMappingHint((MappingHint)value, diagnostics, context);
			case ExtendedPackage.EXPANDABLE_HINT:
				return validateExpandableHint((ExpandableHint)value, diagnostics, context);
			case ExtendedPackage.HINT_IMPORTER_MAPPING_HINT:
				return validateHintImporterMappingHint((HintImporterMappingHint)value, diagnostics, context);
			case ExtendedPackage.MAPPING_HINT_SOURCE_INTERFACE:
				return validateMappingHintSourceInterface((MappingHintSourceInterface)value, diagnostics, context);
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER:
				return validateGlobalAttributeImporter((GlobalAttributeImporter)value, diagnostics, context);
			case ExtendedPackage.ATTRIBUTE_MAPPING:
				return validateAttributeMapping((AttributeMapping)value, diagnostics, context);
			case ExtendedPackage.ATTRIBUTE_MAPPING_SOURCE_INTERFACE:
				return validateAttributeMappingSourceInterface((AttributeMappingSourceInterface)value, diagnostics, context);
			case ExtendedPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT:
				return validateAttributeMappingSourceElement((AttributeMappingSourceElement)value, diagnostics, context);
			case ExtendedPackage.ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT:
				return validateAttributeMappingExternalSourceElement((AttributeMappingExternalSourceElement)value, diagnostics, context);
			case ExtendedPackage.ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT:
				return validateAttributeMappingGlobalSourceElement((AttributeMappingGlobalSourceElement)value, diagnostics, context);
			case ExtendedPackage.CARDINALITY_MAPPING:
				return validateCardinalityMapping((CardinalityMapping)value, diagnostics, context);
			case ExtendedPackage.CARDINALITY_MAPPING_SOURCE_INTERFACE:
				return validateCardinalityMappingSourceInterface((CardinalityMappingSourceInterface)value, diagnostics, context);
			case ExtendedPackage.CARDINALITY_MAPPING_SOURCE_ELEMENT:
				return validateCardinalityMappingSourceElement((CardinalityMappingSourceElement)value, diagnostics, context);
			case ExtendedPackage.CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT:
				return validateCardinalityMappingExternalSourceElement((CardinalityMappingExternalSourceElement)value, diagnostics, context);
			case ExtendedPackage.CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT:
				return validateCardinalityMappingGlobalSourceElement((CardinalityMappingGlobalSourceElement)value, diagnostics, context);
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR:
				return validateReferenceTargetSelector((ReferenceTargetSelector)value, diagnostics, context);
			case ExtendedPackage.CONTAINER_SELECTOR:
				return validateContainerSelector((ContainerSelector)value, diagnostics, context);
			case ExtendedPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER:
				return validateMappedAttributeValueExpander((MappedAttributeValueExpander)value, diagnostics, context);
			case ExtendedPackage.LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER:
				return validateLocalMappedAttributeValueExpander((LocalMappedAttributeValueExpander)value, diagnostics, context);
			case ExtendedPackage.MAPPED_ATTRIBUTE_VALUE_PREPENDER:
				return validateMappedAttributeValuePrepender((MappedAttributeValuePrepender)value, diagnostics, context);
			case ExtendedPackage.MAPPED_ATTRIBUTE_VALUE_APPENDER:
				return validateMappedAttributeValueAppender((MappedAttributeValueAppender)value, diagnostics, context);
			case ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER:
				return validateExternalMappedAttributeValueExpander((ExternalMappedAttributeValueExpander)value, diagnostics, context);
			case ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER:
				return validateExternalMappedAttributeValuePrepender((ExternalMappedAttributeValuePrepender)value, diagnostics, context);
			case ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER:
				return validateExternalMappedAttributeValueAppender((ExternalMappedAttributeValueAppender)value, diagnostics, context);
			default:
				return true;
		}
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
	public boolean validateMappingHintType(MappingHintType mappingHintType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingHintType, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateMappingHint_validateOverwritesValidMappingHint(mappingHint, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingHint_validateConsiderOverwritingHint(mappingHint, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateOverwritesValidMappingHint constraint of '<em>Mapping Hint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHint_validateOverwritesValidMappingHint(MappingHint mappingHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mappingHint.validateOverwritesValidMappingHint(diagnostics, context);
	}

	/**
	 * Validates the validateConsiderOverwritingHint constraint of '<em>Mapping Hint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHint_validateConsiderOverwritingHint(MappingHint mappingHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mappingHint.validateConsiderOverwritingHint(diagnostics, context);
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
	public boolean validateHintImporterMappingHint(HintImporterMappingHint hintImporterMappingHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(hintImporterMappingHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintSourceInterface(MappingHintSourceInterface mappingHintSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mappingHintSourceInterface, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mappingHintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappingHintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappingHintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mappingHintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappingHintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mappingHintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappingHintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappingHintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(mappingHintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(mappingHintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(mappingHintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(mappingHintSourceInterface, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalAttributeImporter(GlobalAttributeImporter globalAttributeImporter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(globalAttributeImporter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(globalAttributeImporter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(globalAttributeImporter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(globalAttributeImporter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(globalAttributeImporter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(globalAttributeImporter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(globalAttributeImporter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(globalAttributeImporter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(globalAttributeImporter, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(globalAttributeImporter, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(globalAttributeImporter, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(globalAttributeImporter, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(globalAttributeImporter, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateMappingHint_validateOverwritesValidMappingHint(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingHint_validateConsiderOverwritingHint(attributeMapping, diagnostics, context);
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
	public boolean validateAttributeMappingSourceInterface(AttributeMappingSourceInterface attributeMappingSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(attributeMappingSourceInterface, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(attributeMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(attributeMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(attributeMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(attributeMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(attributeMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(attributeMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(attributeMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(attributeMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(attributeMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(attributeMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(attributeMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(attributeMappingSourceInterface, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= structureValidator.validateLocalDynamicSourceElement_sourceAttributeMatchesSectionOrContainedSection(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateLocalDynamicSourceElement_validateSourceAttributeMatchesSectionOrContainedSection(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(attributeMappingSourceElement, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= structureValidator.validateExternalDynamicSourceElement_sourceAttributeMatchesContainerSection(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalDynamicSourceElement_validateSourceAttributeMatchesContainerSection(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(attributeMappingExternalSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMappingGlobalSourceElement(AttributeMappingGlobalSourceElement attributeMappingGlobalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(attributeMappingGlobalSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(attributeMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(attributeMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(attributeMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(attributeMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(attributeMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(attributeMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(attributeMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(attributeMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(attributeMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(attributeMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(attributeMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(attributeMappingGlobalSourceElement, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= validateMappingHint_validateOverwritesValidMappingHint(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingHint_validateConsiderOverwritingHint(cardinalityMapping, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateCardinalityMapping_validateOnlySourceOrSourceElements(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_validateExpressionOnlyForSourceElements(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateCardinalityMapping_validateModifiersOnlyForSourceElements(cardinalityMapping, diagnostics, context);
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
	 * Validates the validateOnlySourceOrSourceElements constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_validateOnlySourceOrSourceElements(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return cardinalityMapping.validateOnlySourceOrSourceElements(diagnostics, context);
	}

	/**
	 * Validates the validateExpressionOnlyForSourceElements constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_validateExpressionOnlyForSourceElements(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return cardinalityMapping.validateExpressionOnlyForSourceElements(diagnostics, context);
	}

	/**
	 * Validates the validateModifiersOnlyForSourceElements constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_validateModifiersOnlyForSourceElements(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return cardinalityMapping.validateModifiersOnlyForSourceElements(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMappingSourceInterface(CardinalityMappingSourceInterface cardinalityMappingSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(cardinalityMappingSourceInterface, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(cardinalityMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cardinalityMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cardinalityMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cardinalityMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(cardinalityMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(cardinalityMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(cardinalityMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cardinalityMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(cardinalityMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(cardinalityMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(cardinalityMappingSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(cardinalityMappingSourceInterface, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMappingSourceElement(CardinalityMappingSourceElement cardinalityMappingSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(cardinalityMappingSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(cardinalityMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cardinalityMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cardinalityMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cardinalityMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(cardinalityMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(cardinalityMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(cardinalityMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cardinalityMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateLocalDynamicSourceElement_sourceAttributeMatchesSectionOrContainedSection(cardinalityMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateLocalDynamicSourceElement_validateSourceAttributeMatchesSectionOrContainedSection(cardinalityMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(cardinalityMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(cardinalityMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(cardinalityMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(cardinalityMappingSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMappingExternalSourceElement(CardinalityMappingExternalSourceElement cardinalityMappingExternalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(cardinalityMappingExternalSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(cardinalityMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cardinalityMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cardinalityMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cardinalityMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(cardinalityMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(cardinalityMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(cardinalityMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cardinalityMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalDynamicSourceElement_sourceAttributeMatchesContainerSection(cardinalityMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalDynamicSourceElement_validateSourceAttributeMatchesContainerSection(cardinalityMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(cardinalityMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(cardinalityMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(cardinalityMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(cardinalityMappingExternalSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMappingGlobalSourceElement(CardinalityMappingGlobalSourceElement cardinalityMappingGlobalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(cardinalityMappingGlobalSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(cardinalityMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cardinalityMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cardinalityMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cardinalityMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(cardinalityMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(cardinalityMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(cardinalityMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cardinalityMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(cardinalityMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(cardinalityMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(cardinalityMappingGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(cardinalityMappingGlobalSourceElement, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= validateMappingHint_validateOverwritesValidMappingHint(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingHint_validateConsiderOverwritingHint(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateInstanceSelector_noModifiedAttributeElementTypesInConditionModelConditions(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateInstanceSelector_validateNoModifiedAttributeElementTypesInConditionModelConditions(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateTargetInstanceSelector_validateReferenceAttributeIsValid(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateReferenceTargetSelector_affectedReferenceIsNonContainment(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateReferenceTargetSelector_affectedReferenceMatchesSection(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateReferenceTargetSelector_validateAffectedReferenceIsNonContainment(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateReferenceTargetSelector_validateAffectedReferenceMatchesSection(referenceTargetSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateReferenceTargetSelector_validateTargetClass(referenceTargetSelector, diagnostics, context);
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
	 * Validates the validateTargetClass constraint of '<em>Reference Target Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceTargetSelector_validateTargetClass(ReferenceTargetSelector referenceTargetSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return referenceTargetSelector.validateTargetClass(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerSelector(ContainerSelector containerSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(containerSelector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateEitherModelOrReferCondition(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingHint_validateOverwritesValidMappingHint(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingHint_validateConsiderOverwritingHint(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateInstanceSelector_noModifiedAttributeElementTypesInConditionModelConditions(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateInstanceSelector_validateNoModifiedAttributeElementTypesInConditionModelConditions(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateTargetInstanceSelector_validateReferenceAttributeIsValid(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateContainerSelector_sourceMatchesPossibleContainerType(containerSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateContainerSelector_validateTargetClassMatchesPossibleContainerType(containerSelector, diagnostics, context);
		return result;
	}

	/**
	 * Validates the sourceMatchesPossibleContainerType constraint of '<em>Container Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerSelector_sourceMatchesPossibleContainerType(ContainerSelector containerSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "sourceMatchesPossibleContainerType", getObjectLabel(containerSelector, context) },
						 new Object[] { containerSelector },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateTargetClassMatchesPossibleContainerType constraint of '<em>Container Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerSelector_validateTargetClassMatchesPossibleContainerType(ContainerSelector containerSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return containerSelector.validateTargetClassMatchesPossibleContainerType(diagnostics, context);
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
		if (result || diagnostics != null) result &= structureValidator.validateLocalDynamicSourceElement_sourceAttributeMatchesSectionOrContainedSection(localMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateLocalDynamicSourceElement_validateSourceAttributeMatchesSectionOrContainedSection(localMappedAttributeValueExpander, diagnostics, context);
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
		if (result || diagnostics != null) result &= structureValidator.validateLocalDynamicSourceElement_sourceAttributeMatchesSectionOrContainedSection(mappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateLocalDynamicSourceElement_validateSourceAttributeMatchesSectionOrContainedSection(mappedAttributeValuePrepender, diagnostics, context);
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
		if (result || diagnostics != null) result &= structureValidator.validateLocalDynamicSourceElement_sourceAttributeMatchesSectionOrContainedSection(mappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateLocalDynamicSourceElement_validateSourceAttributeMatchesSectionOrContainedSection(mappedAttributeValueAppender, diagnostics, context);
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
		if (result || diagnostics != null) result &= structureValidator.validateExternalDynamicSourceElement_sourceAttributeMatchesContainerSection(externalMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalDynamicSourceElement_validateSourceAttributeMatchesContainerSection(externalMappedAttributeValueExpander, diagnostics, context);
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
		if (result || diagnostics != null) result &= structureValidator.validateExternalDynamicSourceElement_sourceAttributeMatchesContainerSection(externalMappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalDynamicSourceElement_validateSourceAttributeMatchesContainerSection(externalMappedAttributeValuePrepender, diagnostics, context);
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
		if (result || diagnostics != null) result &= structureValidator.validateExternalDynamicSourceElement_sourceAttributeMatchesContainerSection(externalMappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalDynamicSourceElement_validateSourceAttributeMatchesContainerSection(externalMappedAttributeValueAppender, diagnostics, context);
		return result;
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

} //ExtendedValidator
