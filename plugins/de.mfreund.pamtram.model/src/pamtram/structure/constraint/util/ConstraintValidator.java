/**
 */
package pamtram.structure.constraint.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import pamtram.mapping.util.MappingValidator;

import pamtram.structure.constraint.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see pamtram.structure.constraint.ConstraintPackage
 * @generated
 */
public class ConstraintValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ConstraintValidator INSTANCE = new ConstraintValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "pamtram.structure.constraint";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Fixed Values In Source Sections' of 'Single Reference Value Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Fixed Values Or Global Attributes In Condition Model' of 'Single Reference Value Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Result Modifier In Source Sections' of 'Single Reference Value Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Fixed Values In Source Sections' of 'Range Bound'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RANGE_BOUND__VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Fixed Values Or Global Attributes In Condition Model' of 'Range Bound'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RANGE_BOUND__VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL = 5;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 5;

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
	protected MappingValidator mappingValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintValidator() {
		super();
		mappingValidator = MappingValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return ConstraintPackage.eINSTANCE;
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
			case ConstraintPackage.EQUALITY_MATCHER:
				return validateEqualityMatcher((EqualityConstraint)value, diagnostics, context);
			case ConstraintPackage.VALUE_CONSTRAINT:
				return validateValueConstraint((ValueConstraint)value, diagnostics, context);
			case ConstraintPackage.SUBSTRING_MATCHER:
				return validateSubstringMatcher((SubstringConstraint)value, diagnostics, context);
			case ConstraintPackage.BEGINNING_MATCHER:
				return validateBeginningMatcher((BeginningConstraint)value, diagnostics, context);
			case ConstraintPackage.ENDING_MATCHER:
				return validateEndingMatcher((EndingConstraint)value, diagnostics, context);
			case ConstraintPackage.REG_EX_MATCHER:
				return validateRegExMatcher((RegExConstraint)value, diagnostics, context);
			case ConstraintPackage.CASE_SENSITIVE_CONSTRAINT:
				return validateCaseSensitiveConstraint((CaseSensitiveConstraint)value, diagnostics, context);
			case ConstraintPackage.RANGE_CONSTRAINT:
				return validateRangeConstraint((RangeConstraint)value, diagnostics, context);
			case ConstraintPackage.MULTIPLE_REFERENCES_VALUE_CONSTRAINT:
				return validateMultipleReferencesValueConstraint((MultipleReferencesValueConstraint)value, diagnostics, context);
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT:
				return validateSingleReferenceValueConstraint((SingleReferenceValueConstraint)value, diagnostics, context);
			case ConstraintPackage.VALUE_CONSTRAINT_SOURCE_INTERFACE:
				return validateValueConstraintSourceInterface((ValueConstraintSourceInterface)value, diagnostics, context);
			case ConstraintPackage.VALUE_CONSTRAINT_SOURCE_ELEMENT:
				return validateValueConstraintSourceElement((ValueConstraintSourceElement)value, diagnostics, context);
			case ConstraintPackage.VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT:
				return validateValueConstraintExternalSourceElement((ValueConstraintExternalSourceElement)value, diagnostics, context);
			case ConstraintPackage.RANGE_BOUND:
				return validateRangeBound((RangeBound)value, diagnostics, context);
			case ConstraintPackage.VALUE_CONSTRAINT_TYPE:
				return validateValueConstraintType((ValueConstraintType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEqualityMatcher(EqualityConstraint equalityMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(equalityMatcher, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(equalityMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(equalityMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(equalityMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(equalityMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(equalityMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(equalityMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(equalityMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(equalityMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesInSourceSections(equalityMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesOrGlobalAttributesInConditionModel(equalityMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesInSourceSections(equalityMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(equalityMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateNoResultModifierInSourceSections(equalityMatcher, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueConstraint(ValueConstraint valueConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(valueConstraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubstringMatcher(SubstringConstraint substringMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(substringMatcher, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(substringMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(substringMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(substringMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(substringMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(substringMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(substringMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(substringMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(substringMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesInSourceSections(substringMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesOrGlobalAttributesInConditionModel(substringMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesInSourceSections(substringMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(substringMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateNoResultModifierInSourceSections(substringMatcher, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBeginningMatcher(BeginningConstraint beginningMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(beginningMatcher, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(beginningMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(beginningMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(beginningMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(beginningMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(beginningMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(beginningMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(beginningMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(beginningMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesInSourceSections(beginningMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesOrGlobalAttributesInConditionModel(beginningMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesInSourceSections(beginningMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(beginningMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateNoResultModifierInSourceSections(beginningMatcher, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEndingMatcher(EndingConstraint endingMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(endingMatcher, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(endingMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(endingMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(endingMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(endingMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(endingMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(endingMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(endingMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(endingMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesInSourceSections(endingMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesOrGlobalAttributesInConditionModel(endingMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesInSourceSections(endingMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(endingMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateNoResultModifierInSourceSections(endingMatcher, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegExMatcher(RegExConstraint regExMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(regExMatcher, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(regExMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(regExMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(regExMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(regExMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(regExMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(regExMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(regExMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(regExMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesInSourceSections(regExMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesOrGlobalAttributesInConditionModel(regExMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesInSourceSections(regExMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(regExMatcher, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateNoResultModifierInSourceSections(regExMatcher, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCaseSensitiveConstraint(CaseSensitiveConstraint caseSensitiveConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(caseSensitiveConstraint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(caseSensitiveConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(caseSensitiveConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(caseSensitiveConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(caseSensitiveConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(caseSensitiveConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(caseSensitiveConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(caseSensitiveConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(caseSensitiveConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesInSourceSections(caseSensitiveConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesOrGlobalAttributesInConditionModel(caseSensitiveConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesInSourceSections(caseSensitiveConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(caseSensitiveConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateNoResultModifierInSourceSections(caseSensitiveConstraint, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeConstraint(RangeConstraint rangeConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(rangeConstraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultipleReferencesValueConstraint(MultipleReferencesValueConstraint multipleReferencesValueConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(multipleReferencesValueConstraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSingleReferenceValueConstraint(SingleReferenceValueConstraint singleReferenceValueConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(singleReferenceValueConstraint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(singleReferenceValueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(singleReferenceValueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(singleReferenceValueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(singleReferenceValueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(singleReferenceValueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(singleReferenceValueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(singleReferenceValueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(singleReferenceValueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesInSourceSections(singleReferenceValueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesOrGlobalAttributesInConditionModel(singleReferenceValueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesInSourceSections(singleReferenceValueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(singleReferenceValueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateNoResultModifierInSourceSections(singleReferenceValueConstraint, diagnostics, context);
		return result;
	}

	/**
	 * Validates the onlyFixedValuesInSourceSections constraint of '<em>Single Reference Value Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSingleReferenceValueConstraint_onlyFixedValuesInSourceSections(SingleReferenceValueConstraint singleReferenceValueConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "onlyFixedValuesInSourceSections", getObjectLabel(singleReferenceValueConstraint, context) },
						 new Object[] { singleReferenceValueConstraint },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the onlyFixedValuesOrGlobalAttributesInConditionModel constraint of '<em>Single Reference Value Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSingleReferenceValueConstraint_onlyFixedValuesOrGlobalAttributesInConditionModel(SingleReferenceValueConstraint singleReferenceValueConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "onlyFixedValuesOrGlobalAttributesInConditionModel", getObjectLabel(singleReferenceValueConstraint, context) },
						 new Object[] { singleReferenceValueConstraint },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateOnlyFixedValuesInSourceSections constraint of '<em>Single Reference Value Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSingleReferenceValueConstraint_validateOnlyFixedValuesInSourceSections(SingleReferenceValueConstraint singleReferenceValueConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return singleReferenceValueConstraint.validateOnlyFixedValuesInSourceSections(diagnostics, context);
	}

	/**
	 * Validates the validateOnlyFixedValuesOrGlobalAttributesInConditionModel constraint of '<em>Single Reference Value Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSingleReferenceValueConstraint_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(SingleReferenceValueConstraint singleReferenceValueConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return singleReferenceValueConstraint.validateOnlyFixedValuesOrGlobalAttributesInConditionModel(diagnostics, context);
	}

	/**
	 * Validates the validateNoResultModifierInSourceSections constraint of '<em>Single Reference Value Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSingleReferenceValueConstraint_validateNoResultModifierInSourceSections(SingleReferenceValueConstraint singleReferenceValueConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return singleReferenceValueConstraint.validateNoResultModifierInSourceSections(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueConstraintSourceInterface(ValueConstraintSourceInterface valueConstraintSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(valueConstraintSourceInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueConstraintSourceElement(ValueConstraintSourceElement valueConstraintSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(valueConstraintSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(valueConstraintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(valueConstraintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(valueConstraintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(valueConstraintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(valueConstraintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(valueConstraintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(valueConstraintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(valueConstraintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= mappingValidator.validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(valueConstraintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= mappingValidator.validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(valueConstraintSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueConstraintExternalSourceElement(ValueConstraintExternalSourceElement valueConstraintExternalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(valueConstraintExternalSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(valueConstraintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(valueConstraintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(valueConstraintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(valueConstraintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(valueConstraintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(valueConstraintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(valueConstraintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(valueConstraintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= mappingValidator.validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(valueConstraintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= mappingValidator.validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(valueConstraintExternalSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeBound(RangeBound rangeBound, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(rangeBound, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(rangeBound, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(rangeBound, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(rangeBound, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(rangeBound, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(rangeBound, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(rangeBound, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(rangeBound, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(rangeBound, diagnostics, context);
		if (result || diagnostics != null) result &= validateRangeBound_onlyFixedValuesInSourceSections(rangeBound, diagnostics, context);
		if (result || diagnostics != null) result &= validateRangeBound_onlyFixedValuesOrGlobalAttributesInConditionModel(rangeBound, diagnostics, context);
		if (result || diagnostics != null) result &= validateRangeBound_validateOnlyFixedValuesInSourceSections(rangeBound, diagnostics, context);
		if (result || diagnostics != null) result &= validateRangeBound_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(rangeBound, diagnostics, context);
		return result;
	}

	/**
	 * Validates the onlyFixedValuesInSourceSections constraint of '<em>Range Bound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeBound_onlyFixedValuesInSourceSections(RangeBound rangeBound, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "onlyFixedValuesInSourceSections", getObjectLabel(rangeBound, context) },
						 new Object[] { rangeBound },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the onlyFixedValuesOrGlobalAttributesInConditionModel constraint of '<em>Range Bound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeBound_onlyFixedValuesOrGlobalAttributesInConditionModel(RangeBound rangeBound, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "onlyFixedValuesOrGlobalAttributesInConditionModel", getObjectLabel(rangeBound, context) },
						 new Object[] { rangeBound },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateOnlyFixedValuesInSourceSections constraint of '<em>Range Bound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeBound_validateOnlyFixedValuesInSourceSections(RangeBound rangeBound, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return rangeBound.validateOnlyFixedValuesInSourceSections(diagnostics, context);
	}

	/**
	 * Validates the validateOnlyFixedValuesOrGlobalAttributesInConditionModel constraint of '<em>Range Bound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeBound_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(RangeBound rangeBound, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return rangeBound.validateOnlyFixedValuesOrGlobalAttributesInConditionModel(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueConstraintType(ValueConstraintType valueConstraintType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
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

} //ConstraintValidator
