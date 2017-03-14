/**
 */
package pamtram.structure.target.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import pamtram.structure.generic.util.GenericValidator;

import pamtram.structure.target.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see pamtram.structure.target.TargetPackage
 * @generated
 */
public class TargetValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final TargetValidator INSTANCE = new TargetValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "pamtram.structure.target";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Is Referenced By Mapping Hint Group' of 'Section'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TARGET_SECTION__VALIDATE_IS_REFERENCED_BY_MAPPING_HINT_GROUP = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Cardinality' of 'Section'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TARGET_SECTION__VALIDATE_CARDINALITY = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate EReference Is Non Containment' of 'Section Cross Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TARGET_SECTION_CROSS_REFERENCE__VALIDATE_EREFERENCE_IS_NON_CONTAINMENT = 3;

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
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericValidator genericValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetValidator() {
		super();
		genericValidator = GenericValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return TargetPackage.eINSTANCE;
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
			case TargetPackage.TARGET_SECTION:
				return validateTargetSection((TargetSection)value, diagnostics, context);
			case TargetPackage.FILE_ATTRIBUTE:
				return validateFileAttribute((FileAttribute)value, diagnostics, context);
			case TargetPackage.TARGET_SECTION_CLASS:
				return validateTargetSectionClass((TargetSectionClass)value, diagnostics, context);
			case TargetPackage.TARGET_SECTION_REFERENCE:
				return validateTargetSectionReference((TargetSectionReference)value, diagnostics, context);
			case TargetPackage.TARGET_SECTION_COMPOSITE_REFERENCE:
				return validateTargetSectionCompositeReference((TargetSectionCompositeReference)value, diagnostics, context);
			case TargetPackage.TARGET_SECTION_CROSS_REFERENCE:
				return validateTargetSectionCrossReference((TargetSectionCrossReference)value, diagnostics, context);
			case TargetPackage.TARGET_SECTION_ATTRIBUTE:
				return validateTargetSectionAttribute((TargetSectionAttribute)value, diagnostics, context);
			case TargetPackage.ACTUAL_TARGET_SECTION_ATTRIBUTE:
				return validateActualTargetSectionAttribute((ActualTargetSectionAttribute)value, diagnostics, context);
			case TargetPackage.VIRTUAL_TARGET_SECTION_ATTRIBUTE:
				return validateVirtualTargetSectionAttribute((VirtualTargetSectionAttribute)value, diagnostics, context);
			case TargetPackage.FILE_TYPE:
				return validateFileType((FileType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSection(TargetSection targetSection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(targetSection, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_eClassMatchesParentEReference(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_variableCardinalityIsValid(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_containerIsValid(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_validateEClassMatchesParentEReference(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_validateCardinalityIsValid(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_validateContainerIsValid(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateSection_extendsValidSections(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateSection_containerMatchesExtendContainer(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateSection_validateContainerMatchesExtendContainer(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateSection_validateExtendsValidSections(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateTargetSection_isReferencedByMappingHintGroup(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateTargetSection_validateIsReferencedByMappingHintGroup(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateTargetSection_validateCardinality(targetSection, diagnostics, context);
		return result;
	}

	/**
	 * Validates the isReferencedByMappingHintGroup constraint of '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSection_isReferencedByMappingHintGroup(TargetSection targetSection, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "isReferencedByMappingHintGroup", getObjectLabel(targetSection, context) },
						 new Object[] { targetSection },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateIsReferencedByMappingHintGroup constraint of '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSection_validateIsReferencedByMappingHintGroup(TargetSection targetSection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return targetSection.validateIsReferencedByMappingHintGroup(diagnostics, context);
	}

	/**
	 * Validates the validateCardinality constraint of '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSection_validateCardinality(TargetSection targetSection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return targetSection.validateCardinality(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFileAttribute(FileAttribute fileAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fileAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSectionClass(TargetSectionClass targetSectionClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(targetSectionClass, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_eClassMatchesParentEReference(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_variableCardinalityIsValid(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_containerIsValid(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_validateEClassMatchesParentEReference(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_validateCardinalityIsValid(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_validateContainerIsValid(targetSectionClass, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSectionReference(TargetSectionReference targetSectionReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(targetSectionReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(targetSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(targetSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(targetSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(targetSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(targetSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(targetSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(targetSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(targetSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_eReferenceMatchesParentEClass(targetSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_validateEReferenceMatchesParentEClass(targetSectionReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSectionCompositeReference(TargetSectionCompositeReference targetSectionCompositeReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(targetSectionCompositeReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(targetSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(targetSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(targetSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(targetSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(targetSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(targetSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(targetSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(targetSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_eReferenceMatchesParentEClass(targetSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_validateEReferenceMatchesParentEClass(targetSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateCompositeReference_eReferenceIsContainment(targetSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateCompositeReference_validateEReferenceIsContainment(targetSectionCompositeReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSectionCrossReference(TargetSectionCrossReference targetSectionCrossReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(targetSectionCrossReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(targetSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(targetSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(targetSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(targetSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(targetSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(targetSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(targetSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(targetSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_eReferenceMatchesParentEClass(targetSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_validateEReferenceMatchesParentEClass(targetSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateCrossReference_eReferenceIsNonContainment(targetSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateCrossReference_validateValuesMatchReferenceType(targetSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateTargetSectionCrossReference_validateEReferenceIsNonContainment(targetSectionCrossReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateEReferenceIsNonContainment constraint of '<em>Section Cross Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSectionCrossReference_validateEReferenceIsNonContainment(TargetSectionCrossReference targetSectionCrossReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return targetSectionCrossReference.validateEReferenceIsNonContainment(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSectionAttribute(TargetSectionAttribute targetSectionAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(targetSectionAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActualTargetSectionAttribute(ActualTargetSectionAttribute actualTargetSectionAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(actualTargetSectionAttribute, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(actualTargetSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(actualTargetSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(actualTargetSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(actualTargetSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(actualTargetSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(actualTargetSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(actualTargetSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(actualTargetSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateActualAttribute_attributeMatchesParentEClass(actualTargetSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateActualAttribute_validateAttributeMatchesParentEClass(actualTargetSectionAttribute, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualTargetSectionAttribute(VirtualTargetSectionAttribute virtualTargetSectionAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualTargetSectionAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFileType(FileType fileType, DiagnosticChain diagnostics, Map<Object, Object> context) {
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

} //TargetValidator
