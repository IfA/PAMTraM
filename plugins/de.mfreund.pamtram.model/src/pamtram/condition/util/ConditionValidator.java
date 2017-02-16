/**
 */
package pamtram.condition.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Minimal Number Of Args' of 'Variadic Condition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VARIADIC_CONDITION__VALIDATE_MINIMAL_NUMBER_OF_ARGS = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Exactly One Arg' of 'Unary Condition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int UNARY_CONDITION__VALIDATE_EXACTLY_ONE_ARG = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Reference Only Conditions From Condition Model Or From Conditional Elements' of 'Not'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NOT__VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL_OR_FROM_CONDITIONAL_ELEMENTS = 3;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 3;

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
			case ConditionPackage.VARIADIC_CONDITION:
				return validateVariadicCondition((VariadicCondition)value, diagnostics, context);
			case ConditionPackage.AND:
				return validateAnd((And)value, diagnostics, context);
			case ConditionPackage.OR:
				return validateOr((Or)value, diagnostics, context);
			case ConditionPackage.UNARY_CONDITION:
				return validateUnaryCondition((UnaryCondition)value, diagnostics, context);
			case ConditionPackage.NOT:
				return validateNot((Not)value, diagnostics, context);
			case ConditionPackage.CONDITION:
				return validateCondition((Condition<?>)value, diagnostics, context);
			case ConditionPackage.ATTRIBUTE_CONDITION:
				return validateAttributeCondition((AttributeCondition)value, diagnostics, context);
			case ConditionPackage.CARDINALITY_CONDITION:
				return validateCardinalityCondition((CardinalityCondition)value, diagnostics, context);
			case ConditionPackage.APPLICATION_DEPENDENCY:
				return validateApplicationDependency((ApplicationDependency)value, diagnostics, context);
			case ConditionPackage.COMPARATOR_ENUM:
				return validateComparatorEnum((ComparatorEnum)value, diagnostics, context);
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
	public boolean validateCondition(Condition<?> condition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(condition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariadicCondition(VariadicCondition variadicCondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(variadicCondition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(variadicCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variadicCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variadicCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(variadicCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(variadicCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(variadicCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(variadicCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variadicCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariadicCondition_minimalNumberOfArgs(variadicCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariadicCondition_validateMinimalNumberOfArgs(variadicCondition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the minimalNumberOfArgs constraint of '<em>Variadic Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariadicCondition_minimalNumberOfArgs(VariadicCondition variadicCondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "minimalNumberOfArgs", getObjectLabel(variadicCondition, context) },
						 new Object[] { variadicCondition },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateMinimalNumberOfArgs constraint of '<em>Variadic Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariadicCondition_validateMinimalNumberOfArgs(VariadicCondition variadicCondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return variadicCondition.validateMinimalNumberOfArgs(diagnostics, context);
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
		if (result || diagnostics != null) result &= validateVariadicCondition_minimalNumberOfArgs(and, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariadicCondition_validateMinimalNumberOfArgs(and, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateVariadicCondition_minimalNumberOfArgs(or, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariadicCondition_validateMinimalNumberOfArgs(or, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnaryCondition(UnaryCondition unaryCondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(unaryCondition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(unaryCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(unaryCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(unaryCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(unaryCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(unaryCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(unaryCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(unaryCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(unaryCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnaryCondition_exactlyOneArg(unaryCondition, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnaryCondition_validateExactlyOneArg(unaryCondition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the exactlyOneArg constraint of '<em>Unary Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnaryCondition_exactlyOneArg(UnaryCondition unaryCondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "exactlyOneArg", getObjectLabel(unaryCondition, context) },
						 new Object[] { unaryCondition },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateExactlyOneArg constraint of '<em>Unary Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnaryCondition_validateExactlyOneArg(UnaryCondition unaryCondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return unaryCondition.validateExactlyOneArg(diagnostics, context);
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
		if (result || diagnostics != null) result &= validateUnaryCondition_exactlyOneArg(not, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnaryCondition_validateExactlyOneArg(not, diagnostics, context);
		if (result || diagnostics != null) result &= validateNot_referenceOnlyConditionsFromConditionModelOrFromConditionalElements(not, diagnostics, context);
		if (result || diagnostics != null) result &= validateNot_validateReferenceOnlyConditionsFromConditionModelOrFromConditionalElements(not, diagnostics, context);
		return result;
	}

	/**
	 * Validates the referenceOnlyConditionsFromConditionModelOrFromConditionalElements constraint of '<em>Not</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNot_referenceOnlyConditionsFromConditionModelOrFromConditionalElements(Not not, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "referenceOnlyConditionsFromConditionModelOrFromConditionalElements", getObjectLabel(not, context) },
						 new Object[] { not },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateReferenceOnlyConditionsFromConditionModelOrFromConditionalElements constraint of '<em>Not</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNot_validateReferenceOnlyConditionsFromConditionModelOrFromConditionalElements(Not not, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return not.validateReferenceOnlyConditionsFromConditionModelOrFromConditionalElements(diagnostics, context);
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
	public boolean validateCardinalityCondition(CardinalityCondition cardinalityCondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(cardinalityCondition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateApplicationDependency(ApplicationDependency applicationDependency, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(applicationDependency, diagnostics, context);
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
