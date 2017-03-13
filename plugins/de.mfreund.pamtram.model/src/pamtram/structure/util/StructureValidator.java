/**
 */
package pamtram.structure.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import pamtram.structure.*;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc
 * -->
 * 
 * @see pamtram.structure.StructurePackage
 * @generated
 */
public class StructureValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final StructureValidator INSTANCE = new StructureValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "pamtram.structure";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Modified Attribute Element Types In Condition Model Conditions' of 'Instance Selector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_SELECTOR__VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Attribute Matches Section Or Contained Section' of 'Local Modified Attribute Element Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Attribute Matches Container Section' of 'External Modified Attribute Element Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION = 3;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 3;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public StructureValidator() {
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
	  return StructurePackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		switch (classifierID) {
			case StructurePackage.INSTANCE_SELECTOR:
				return validateInstanceSelector((InstanceSelector)value, diagnostics, context);
			case StructurePackage.SOURCE_INSTANCE_SELECTOR:
				return validateSourceInstanceSelector((SourceInstanceSelector)value, diagnostics, context);
			case StructurePackage.INSTANCE_SELECTOR_SOURCE_INTERFACE:
				return validateInstanceSelectorSourceInterface((InstanceSelectorSourceInterface)value, diagnostics, context);
			case StructurePackage.INSTANCE_SELECTOR_SOURCE_ELEMENT:
				return validateInstanceSelectorSourceElement((InstanceSelectorSourceElement)value, diagnostics, context);
			case StructurePackage.INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT:
				return validateInstanceSelectorExternalSourceElement((InstanceSelectorExternalSourceElement)value, diagnostics, context);
			case StructurePackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE:
				return validateModifiedAttributeElementType((ModifiedAttributeElementType<?, ?, ?, ?>)value, diagnostics, context);
			case StructurePackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE:
				return validateLocalModifiedAttributeElementType((LocalModifiedAttributeElementType<?, ?, ?, ?>)value, diagnostics, context);
			case StructurePackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE:
				return validateExternalModifiedAttributeElementType((ExternalModifiedAttributeElementType<?, ?, ?, ?>)value, diagnostics, context);
			case StructurePackage.GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE:
				return validateGlobalModifiedAttributeElementType((GlobalModifiedAttributeElementType<?, ?, ?, ?>)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceSelector(InstanceSelector instanceSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(instanceSelector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(instanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(instanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(instanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(instanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(instanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(instanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(instanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(instanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateInstanceSelector_noModifiedAttributeElementTypesInConditionModelConditions(instanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateInstanceSelector_validateNoModifiedAttributeElementTypesInConditionModelConditions(instanceSelector, diagnostics, context);
		return result;
	}

	/**
	 * Validates the noModifiedAttributeElementTypesInConditionModelConditions constraint of '<em>Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceSelector_noModifiedAttributeElementTypesInConditionModelConditions(InstanceSelector instanceSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "noModifiedAttributeElementTypesInConditionModelConditions", getObjectLabel(instanceSelector, context) },
						 new Object[] { instanceSelector },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateNoModifiedAttributeElementTypesInConditionModelConditions constraint of '<em>Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceSelector_validateNoModifiedAttributeElementTypesInConditionModelConditions(InstanceSelector instanceSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return instanceSelector.validateNoModifiedAttributeElementTypesInConditionModelConditions(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceInstanceSelector(SourceInstanceSelector sourceInstanceSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sourceInstanceSelector, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sourceInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sourceInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sourceInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sourceInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sourceInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sourceInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sourceInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sourceInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateInstanceSelector_noModifiedAttributeElementTypesInConditionModelConditions(sourceInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) result &= validateInstanceSelector_validateNoModifiedAttributeElementTypesInConditionModelConditions(sourceInstanceSelector, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceSelectorSourceInterface(InstanceSelectorSourceInterface instanceSelectorSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(instanceSelectorSourceInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceSelectorSourceElement(InstanceSelectorSourceElement instanceSelectorSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(instanceSelectorSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(instanceSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(instanceSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(instanceSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(instanceSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(instanceSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(instanceSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(instanceSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(instanceSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(instanceSelectorSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(instanceSelectorSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceSelectorExternalSourceElement(InstanceSelectorExternalSourceElement instanceSelectorExternalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(instanceSelectorExternalSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(instanceSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(instanceSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(instanceSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(instanceSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(instanceSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(instanceSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(instanceSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(instanceSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(instanceSelectorExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(instanceSelectorExternalSourceElement, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(externalModifiedAttributeElementType, diagnostics, context);
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
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "sourceAttributeMatchesContainerSection", getObjectLabel(externalModifiedAttributeElementType, context) },
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
	public boolean validateGlobalModifiedAttributeElementType(GlobalModifiedAttributeElementType<?, ?, ?, ?> globalModifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(globalModifiedAttributeElementType, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} // StructureValidator
