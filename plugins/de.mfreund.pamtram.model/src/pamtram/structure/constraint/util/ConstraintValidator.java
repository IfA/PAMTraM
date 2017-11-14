/**
 */
package pamtram.structure.constraint.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;
import pamtram.structure.constraint.*;
import pamtram.structure.util.StructureValidator;
import pamtram.util.PamtramValidator;

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
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 2;

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
	public ConstraintValidator() {
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
			case ConstraintPackage.EQUALITY_CONSTRAINT:
				return validateEqualityConstraint((EqualityConstraint)value, diagnostics, context);
			case ConstraintPackage.CHOICE_CONSTRAINT:
				return validateChoiceConstraint((ChoiceConstraint)value, diagnostics, context);
			case ConstraintPackage.NUMERIC_CONSTRAINT:
				return validateNumericConstraint((NumericConstraint)value, diagnostics, context);
			case ConstraintPackage.STRING_CONSTRAINT:
				return validateStringConstraint((StringConstraint)value, diagnostics, context);
			case ConstraintPackage.VALUE_CONSTRAINT_SOURCE_INTERFACE:
				return validateValueConstraintSourceInterface((ValueConstraintSourceInterface)value, diagnostics, context);
			case ConstraintPackage.VALUE_CONSTRAINT_SOURCE_ELEMENT:
				return validateValueConstraintSourceElement((ValueConstraintSourceElement)value, diagnostics, context);
			case ConstraintPackage.VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT:
				return validateValueConstraintExternalSourceElement((ValueConstraintExternalSourceElement)value, diagnostics, context);
			case ConstraintPackage.VALUE_CONSTRAINT_GLOBAL_SOURCE_ELEMENT:
				return validateValueConstraintGlobalSourceElement((ValueConstraintGlobalSourceElement)value, diagnostics, context);
			case ConstraintPackage.VALUE_CONSTRAINT_TYPE:
				return validateValueConstraintType((ValueConstraintType)value, diagnostics, context);
			case ConstraintPackage.NUMERIC_CONSTRAINT_OPERATOR_TYPE:
				return validateNumericConstraintOperatorType((NumericConstraintOperatorType)value, diagnostics, context);
			case ConstraintPackage.STRING_CONSTRAINT_OPERATOR_TYPE:
				return validateStringConstraintOperatorType((StringConstraintOperatorType)value, diagnostics, context);
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
	public boolean validateStringConstraint(StringConstraint stringConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(stringConstraint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(stringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(stringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(stringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(stringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(stringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(stringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(stringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(stringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesInSourceSections(stringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesOrGlobalAttributesInConditionModel(stringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesInSourceSections(stringConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(stringConstraint, diagnostics, context);
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
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChoiceConstraint(ChoiceConstraint choiceConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(choiceConstraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericConstraint(NumericConstraint numericConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(numericConstraint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(numericConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(numericConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(numericConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(numericConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(numericConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(numericConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(numericConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(numericConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesInSourceSections(numericConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_onlyFixedValuesOrGlobalAttributesInConditionModel(numericConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesInSourceSections(numericConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateSingleReferenceValueConstraint_validateOnlyFixedValuesOrGlobalAttributesInConditionModel(numericConstraint, diagnostics, context);
		return result;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueConstraintSourceInterface(ValueConstraintSourceInterface valueConstraintSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(valueConstraintSourceInterface, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(valueConstraintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(valueConstraintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(valueConstraintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(valueConstraintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(valueConstraintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(valueConstraintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(valueConstraintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(valueConstraintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(valueConstraintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(valueConstraintSourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(valueConstraintSourceInterface, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= structureValidator.validateLocalDynamicSourceElement_sourceAttributeMatchesSectionOrContainedSection(valueConstraintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateLocalDynamicSourceElement_validateSourceAttributeMatchesSectionOrContainedSection(valueConstraintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(valueConstraintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(valueConstraintSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(valueConstraintSourceElement, diagnostics, context);
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
		if (result || diagnostics != null) result &= structureValidator.validateExternalDynamicSourceElement_sourceAttributeMatchesContainerSection(valueConstraintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalDynamicSourceElement_validateSourceAttributeMatchesContainerSection(valueConstraintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(valueConstraintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(valueConstraintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(valueConstraintExternalSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueConstraintGlobalSourceElement(ValueConstraintGlobalSourceElement valueConstraintGlobalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(valueConstraintGlobalSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(valueConstraintGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(valueConstraintGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(valueConstraintGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(valueConstraintGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(valueConstraintGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(valueConstraintGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(valueConstraintGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(valueConstraintGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalDynamicSourceElement_sourceAttributeMatchesContainerSection(valueConstraintGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= structureValidator.validateExternalDynamicSourceElement_validateSourceAttributeMatchesContainerSection(valueConstraintGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_eitherModelOrReferCondition(valueConstraintGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_referenceOnlyConditionsFromConditionModel(valueConstraintGlobalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= pamtramValidator.validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(valueConstraintGlobalSourceElement, diagnostics, context);
		return result;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericConstraintOperatorType(NumericConstraintOperatorType numericConstraintOperatorType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringConstraintOperatorType(StringConstraintOperatorType stringConstraintOperatorType, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
