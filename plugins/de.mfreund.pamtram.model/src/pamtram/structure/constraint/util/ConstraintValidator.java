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
			case ConstraintPackage.VALUE_CONSTRAINT:
				return validateValueConstraint((ValueConstraint)value, diagnostics, context);
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT:
				return validateSingleReferenceValueConstraint((SingleReferenceValueConstraint)value, diagnostics, context);
			case ConstraintPackage.CASE_SENSITIVE_CONSTRAINT:
				return validateCaseSensitiveConstraint((CaseSensitiveConstraint)value, diagnostics, context);
			case ConstraintPackage.EQUALITY_CONSTRAINT:
				return validateEqualityConstraint((EqualityConstraint)value, diagnostics, context);
			case ConstraintPackage.SUBSTRING_CONSTRAINT:
				return validateSubstringConstraint((SubstringConstraint)value, diagnostics, context);
			case ConstraintPackage.BEGINNING_CONSTRAINT:
				return validateBeginningConstraint((BeginningConstraint)value, diagnostics, context);
			case ConstraintPackage.ENDING_CONSTRAINT:
				return validateEndingConstraint((EndingConstraint)value, diagnostics, context);
			case ConstraintPackage.REG_EX_CONSTRAINT:
				return validateRegExConstraint((RegExConstraint)value, diagnostics, context);
			case ConstraintPackage.RANGE_CONSTRAINT:
				return validateRangeConstraint((RangeConstraint)value, diagnostics, context);
			case ConstraintPackage.MULTIPLE_REFERENCES_VALUE_CONSTRAINT:
				return validateMultipleReferencesValueConstraint((MultipleReferencesValueConstraint)value, diagnostics, context);
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
	public boolean validateValueConstraint(ValueConstraint valueConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(valueConstraint, diagnostics, context);
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
	public boolean validateEqualityConstraint(EqualityConstraint equalityConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(equalityConstraint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(equalityConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(equalityConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(equalityConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(equalityConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(equalityConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(equalityConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(equalityConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(equalityConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesInSourceSections(equalityConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesOrGlobalAttributesInConditionModel(equalityConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesInSourceSections(equalityConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(equalityConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateNoResultModifierInSourceSections(equalityConstraint, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubstringConstraint(SubstringConstraint substringConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(substringConstraint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(substringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(substringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(substringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(substringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(substringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(substringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(substringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(substringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesInSourceSections(substringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesOrGlobalAttributesInConditionModel(substringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesInSourceSections(substringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(substringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateNoResultModifierInSourceSections(substringConstraint, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBeginningConstraint(BeginningConstraint beginningConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(beginningConstraint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(beginningConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(beginningConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(beginningConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(beginningConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(beginningConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(beginningConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(beginningConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(beginningConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesInSourceSections(beginningConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesOrGlobalAttributesInConditionModel(beginningConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesInSourceSections(beginningConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(beginningConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateNoResultModifierInSourceSections(beginningConstraint, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEndingConstraint(EndingConstraint endingConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(endingConstraint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(endingConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(endingConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(endingConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(endingConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(endingConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(endingConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(endingConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(endingConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesInSourceSections(endingConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesOrGlobalAttributesInConditionModel(endingConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesInSourceSections(endingConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(endingConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateNoResultModifierInSourceSections(endingConstraint, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegExConstraint(RegExConstraint regExConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(regExConstraint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(regExConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(regExConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(regExConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(regExConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(regExConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(regExConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(regExConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(regExConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesInSourceSections(regExConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesOrGlobalAttributesInConditionModel(regExConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesInSourceSections(regExConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(regExConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateNoResultModifierInSourceSections(regExConstraint, diagnostics, context);
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
