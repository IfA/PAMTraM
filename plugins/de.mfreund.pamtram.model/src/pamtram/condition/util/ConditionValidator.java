/**
 */
package pamtram.condition.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import pamtram.condition.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see pamtram.condition.ConditionPackage
 * @generated
 */
public class ConditionValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ConditionValidator INSTANCE = new ConditionValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "pamtram.condition";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Minimal Number Of Args' of 'Multiple Condition Operator'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MULTIPLE_CONDITION_OPERATOR__MINIMAL_NUMBER_OF_ARGS = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Reference Only Conditions From Condition Model' of 'Multiple Condition Operator'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MULTIPLE_CONDITION_OPERATOR__REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Minimal Number Of Args' of 'Single Condition Operator'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SINGLE_CONDITION_OPERATOR__MINIMAL_NUMBER_OF_ARGS = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Reference Only Conditions From Condition Model Or From Conditional Elements' of 'Single Condition Operator'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SINGLE_CONDITION_OPERATOR__REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL_OR_FROM_CONDITIONAL_ELEMENTS = 4;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 4;

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
	public ConditionValidator() {
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
	  return ConditionPackage.eINSTANCE;
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
			case ConditionPackage.COMPLEX_CONDITION:
				return validateComplexCondition((ComplexCondition)value, diagnostics, context);
			case ConditionPackage.CONDITION:
				return validateCondition((Condition)value, diagnostics, context);
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR:
				return validateMultipleConditionOperator((MultipleConditionOperator)value, diagnostics, context);
			case ConditionPackage.AND:
				return validateAnd((And)value, diagnostics, context);
			case ConditionPackage.OR:
				return validateOr((Or)value, diagnostics, context);
			case ConditionPackage.SINGLE_CONDITION_OPERATOR:
				return validateSingleConditionOperator((SingleConditionOperator)value, diagnostics, context);
			case ConditionPackage.NOT:
				return validateNot((Not)value, diagnostics, context);
			case ConditionPackage.ATTRIBUTE_CONDITION:
				return validateAttributeCondition((AttributeCondition)value, diagnostics, context);
			case ConditionPackage.SECTION_CONDITION:
				return validateSectionCondition((SectionCondition)value, diagnostics, context);
			case ConditionPackage.COMPARATOR_ENUM:
				return validateComparatorEnum((ComparatorEnum)value, diagnostics, context);
			case ConditionPackage.COND_SETTING_ENUM:
				return validateCondSettingEnum((CondSettingEnum)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComplexCondition(ComplexCondition complexCondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(complexCondition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCondition(Condition condition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(condition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultipleConditionOperator(MultipleConditionOperator multipleConditionOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(multipleConditionOperator, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(multipleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(multipleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(multipleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(multipleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(multipleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(multipleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(multipleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(multipleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultipleConditionOperator_minimalNumberOfArgs(multipleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultipleConditionOperator_referenceOnlyConditionsFromConditionModel(multipleConditionOperator, diagnostics, context);
		return result;
	}

	/**
	 * Validates the minimalNumberOfArgs constraint of '<em>Multiple Condition Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultipleConditionOperator_minimalNumberOfArgs(MultipleConditionOperator multipleConditionOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return multipleConditionOperator.minimalNumberOfArgs(diagnostics, context);
	}

	/**
	 * Validates the referenceOnlyConditionsFromConditionModel constraint of '<em>Multiple Condition Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultipleConditionOperator_referenceOnlyConditionsFromConditionModel(MultipleConditionOperator multipleConditionOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return multipleConditionOperator.referenceOnlyConditionsFromConditionModel(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnd(And and, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(and, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(and, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(and, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(and, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(and, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(and, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(and, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(and, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(and, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultipleConditionOperator_minimalNumberOfArgs(and, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultipleConditionOperator_referenceOnlyConditionsFromConditionModel(and, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOr(Or or, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(or, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(or, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(or, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(or, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(or, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(or, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(or, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(or, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(or, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultipleConditionOperator_minimalNumberOfArgs(or, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultipleConditionOperator_referenceOnlyConditionsFromConditionModel(or, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSingleConditionOperator(SingleConditionOperator singleConditionOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(singleConditionOperator, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(singleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(singleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(singleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(singleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(singleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(singleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(singleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(singleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleConditionOperator_minimalNumberOfArgs(singleConditionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleConditionOperator_referenceOnlyConditionsFromConditionModelOrFromConditionalElements(singleConditionOperator, diagnostics, context);
		return result;
	}

	/**
	 * Validates the minimalNumberOfArgs constraint of '<em>Single Condition Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSingleConditionOperator_minimalNumberOfArgs(SingleConditionOperator singleConditionOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return singleConditionOperator.minimalNumberOfArgs(diagnostics, context);
	}

	/**
	 * Validates the referenceOnlyConditionsFromConditionModelOrFromConditionalElements constraint of '<em>Single Condition Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSingleConditionOperator_referenceOnlyConditionsFromConditionModelOrFromConditionalElements(SingleConditionOperator singleConditionOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return singleConditionOperator.referenceOnlyConditionsFromConditionModelOrFromConditionalElements(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNot(Not not, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(not, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(not, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(not, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(not, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(not, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(not, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(not, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(not, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(not, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleConditionOperator_minimalNumberOfArgs(not, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleConditionOperator_referenceOnlyConditionsFromConditionModelOrFromConditionalElements(not, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeCondition(AttributeCondition attributeCondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeCondition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSectionCondition(SectionCondition sectionCondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sectionCondition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComparatorEnum(ComparatorEnum comparatorEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCondSettingEnum(CondSettingEnum condSettingEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
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

} //ConditionValidator
