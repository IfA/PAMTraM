/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import pamtram.*;
import pamtram.ConditionModel;
import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;
import pamtram.MappingModel;
import pamtram.NamedElement;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.SectionModel;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * @see pamtram.PamtramPackage
 * @generated
 */
public class PamtramValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final PamtramValidator INSTANCE = new PamtramValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "pamtram";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Reference Only Conditions From Condition Model' of 'Conditional Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONDITIONAL_ELEMENT__VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

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
	public PamtramValidator() {
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
	  return PamtramPackage.eINSTANCE;
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
			case PamtramPackage.NAMED_ELEMENT:
				return validateNamedElement((NamedElement)value, diagnostics, context);
			case PamtramPackage.DEACTIVATABLE_ELEMENT:
				return validateDeactivatableElement((DeactivatableElement)value, diagnostics, context);
			case PamtramPackage.PAM_TRA_M:
				return validatePAMTraM((PAMTraM)value, diagnostics, context);
			case PamtramPackage.SECTION_MODEL:
				return validateSectionModel((SectionModel<?, ?, ?, ?>)value, diagnostics, context);
			case PamtramPackage.SOURCE_SECTION_MODEL:
				return validateSourceSectionModel((SourceSectionModel)value, diagnostics, context);
			case PamtramPackage.TARGET_SECTION_MODEL:
				return validateTargetSectionModel((TargetSectionModel)value, diagnostics, context);
			case PamtramPackage.MAPPING_MODEL:
				return validateMappingModel((MappingModel)value, diagnostics, context);
			case PamtramPackage.CONDITIONAL_ELEMENT:
				return validateConditionalElement((ConditionalElement)value, diagnostics, context);
			case PamtramPackage.CONDITION_MODEL:
				return validateConditionModel((ConditionModel)value, diagnostics, context);
			case PamtramPackage.EXPRESSION_ELEMENT:
				return validateExpressionElement((ExpressionElement)value, diagnostics, context);
			case PamtramPackage.MODIFIABLE_ELEMENT:
				return validateModifiableElement((ModifiableElement)value, diagnostics, context);
			case PamtramPackage.MATCH_SPEC_ELEMENT:
				return validateMatchSpecElement((MatchSpecElement<?, ?, ?, ?>)value, diagnostics, context);
			case PamtramPackage.FIXED_VALUE:
				return validateFixedValue((FixedValue)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeactivatableElement(DeactivatableElement deactivatableElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(deactivatableElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePAMTraM(PAMTraM pamTraM, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(pamTraM, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSectionModel(SectionModel<?, ?, ?, ?> sectionModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sectionModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSectionModel(SourceSectionModel sourceSectionModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sourceSectionModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSectionModel(TargetSectionModel targetSectionModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(targetSectionModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingModel(MappingModel mappingModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mappingModel, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mappingModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappingModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappingModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mappingModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappingModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mappingModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappingModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappingModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalElement_eitherModelOrReferCondition(mappingModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalElement_referenceOnlyConditionsFromConditionModel(mappingModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(mappingModel, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalElement(ConditionalElement conditionalElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(conditionalElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(conditionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(conditionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(conditionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(conditionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(conditionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(conditionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(conditionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(conditionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalElement_eitherModelOrReferCondition(conditionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalElement_referenceOnlyConditionsFromConditionModel(conditionalElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(conditionalElement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the eitherModelOrReferCondition constraint of '<em>Conditional Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalElement_eitherModelOrReferCondition(ConditionalElement conditionalElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "eitherModelOrReferCondition", getObjectLabel(conditionalElement, context) },
						 new Object[] { conditionalElement },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the referenceOnlyConditionsFromConditionModel constraint of '<em>Conditional Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalElement_referenceOnlyConditionsFromConditionModel(ConditionalElement conditionalElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "referenceOnlyConditionsFromConditionModel", getObjectLabel(conditionalElement, context) },
						 new Object[] { conditionalElement },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateReferenceOnlyConditionsFromConditionModel constraint of '<em>Conditional Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(ConditionalElement conditionalElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return conditionalElement.validateReferenceOnlyConditionsFromConditionModel(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionModel(ConditionModel conditionModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(conditionModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionElement(ExpressionElement expressionElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expressionElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModifiableElement(ModifiableElement modifiableElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modifiableElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatchSpecElement(MatchSpecElement<?, ?, ?, ?> matchSpecElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(matchSpecElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFixedValue(FixedValue fixedValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(fixedValue, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(fixedValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(fixedValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(fixedValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(fixedValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(fixedValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(fixedValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(fixedValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(fixedValue, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalElement_eitherModelOrReferCondition(fixedValue, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalElement_referenceOnlyConditionsFromConditionModel(fixedValue, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalElement_validateReferenceOnlyConditionsFromConditionModel(fixedValue, diagnostics, context);
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

} //PamtramValidator
