/**
 */
package pamtram.structure.source.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import pamtram.structure.generic.util.GenericValidator;

import pamtram.structure.source.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see pamtram.structure.source.SourcePackage
 * @generated
 */
public class SourceValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final SourceValidator INSTANCE = new SourceValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "pamtram.structure.source";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Is Referenced By Mapping' of 'Section'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SOURCE_SECTION__VALIDATE_IS_REFERENCED_BY_MAPPING = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Derivation' of 'Virtual Source Section Attribute'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VIRTUAL_SOURCE_SECTION_ATTRIBUTE__VALIDATE_DERIVATION = 2;

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
	protected GenericValidator genericValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceValidator() {
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
	  return SourcePackage.eINSTANCE;
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
			case SourcePackage.SOURCE_SECTION:
				return validateSourceSection((SourceSection)value, diagnostics, context);
			case SourcePackage.SOURCE_SECTION_CLASS:
				return validateSourceSectionClass((SourceSectionClass)value, diagnostics, context);
			case SourcePackage.SOURCE_SECTION_REFERENCE:
				return validateSourceSectionReference((SourceSectionReference)value, diagnostics, context);
			case SourcePackage.SOURCE_SECTION_COMPOSITE_REFERENCE:
				return validateSourceSectionCompositeReference((SourceSectionCompositeReference)value, diagnostics, context);
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE:
				return validateSourceSectionCrossReference((SourceSectionCrossReference)value, diagnostics, context);
			case SourcePackage.SOURCE_SECTION_ATTRIBUTE:
				return validateSourceSectionAttribute((SourceSectionAttribute)value, diagnostics, context);
			case SourcePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE:
				return validateActualSourceSectionAttribute((ActualSourceSectionAttribute)value, diagnostics, context);
			case SourcePackage.VIRTUAL_SOURCE_SECTION_ATTRIBUTE:
				return validateVirtualSourceSectionAttribute((VirtualSourceSectionAttribute)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSection(SourceSection sourceSection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sourceSection, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_eClassMatchesParentEReference(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_variableCardinalityIsValid(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_containerIsValid(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_validateEClassMatchesParentEReference(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_validateCardinalityIsValid(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_validateContainerIsValid(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateSection_extendsValidSections(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateSection_containerMatchesExtendContainer(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateSection_validateContainerMatchesExtendContainer(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateSection_validateExtendsValidSections(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateSourceSection_isReferencedByMapping(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateSourceSection_validateIsReferencedByMapping(sourceSection, diagnostics, context);
		return result;
	}

	/**
	 * Validates the isReferencedByMapping constraint of '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSection_isReferencedByMapping(SourceSection sourceSection, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "isReferencedByMapping", getObjectLabel(sourceSection, context) },
						 new Object[] { sourceSection },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateIsReferencedByMapping constraint of '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSection_validateIsReferencedByMapping(SourceSection sourceSection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sourceSection.validateIsReferencedByMapping(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSectionClass(SourceSectionClass sourceSectionClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sourceSectionClass, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_eClassMatchesParentEReference(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_variableCardinalityIsValid(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_containerIsValid(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_validateEClassMatchesParentEReference(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_validateCardinalityIsValid(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateClass_validateContainerIsValid(sourceSectionClass, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSectionReference(SourceSectionReference sourceSectionReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sourceSectionReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sourceSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sourceSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sourceSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sourceSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sourceSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sourceSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sourceSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sourceSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_eReferenceMatchesParentEClass(sourceSectionReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSectionCompositeReference(SourceSectionCompositeReference sourceSectionCompositeReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sourceSectionCompositeReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sourceSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sourceSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sourceSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sourceSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sourceSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sourceSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sourceSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sourceSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_eReferenceMatchesParentEClass(sourceSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateCompositeReference_eReferenceIsContainment(sourceSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateCompositeReference_validateEReferenceIsContainment(sourceSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateActualReference_validateEReferenceMatchesParentEClass(sourceSectionCompositeReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSectionCrossReference(SourceSectionCrossReference sourceSectionCrossReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sourceSectionCrossReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sourceSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sourceSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sourceSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sourceSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sourceSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sourceSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sourceSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sourceSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_eReferenceMatchesParentEClass(sourceSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateCrossReference_eReferenceIsNonContainment(sourceSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateCrossReference_validateValuesMatchReferenceType(sourceSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateActualReference_validateEReferenceMatchesParentEClass(sourceSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateSourceSectionCrossReference_valuesMatchReferenceType(sourceSectionCrossReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the valuesMatchReferenceType constraint of '<em>Section Cross Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSectionCrossReference_valuesMatchReferenceType(SourceSectionCrossReference sourceSectionCrossReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "valuesMatchReferenceType", getObjectLabel(sourceSectionCrossReference, context) },
						 new Object[] { sourceSectionCrossReference },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSectionAttribute(SourceSectionAttribute sourceSectionAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sourceSectionAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActualSourceSectionAttribute(ActualSourceSectionAttribute actualSourceSectionAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(actualSourceSectionAttribute, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(actualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(actualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(actualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(actualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(actualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(actualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(actualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(actualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateActualAttribute_attributeMatchesParentEClass(actualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateActualAttribute_validateAttributeMatchesParentEClass(actualSourceSectionAttribute, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualSourceSectionAttribute(VirtualSourceSectionAttribute virtualSourceSectionAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(virtualSourceSectionAttribute, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(virtualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(virtualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(virtualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(virtualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(virtualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(virtualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(virtualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(virtualSourceSectionAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validateVirtualSourceSectionAttribute_validateDerivation(virtualSourceSectionAttribute, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateDerivation constraint of '<em>Virtual Source Section Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualSourceSectionAttribute_validateDerivation(VirtualSourceSectionAttribute virtualSourceSectionAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return virtualSourceSectionAttribute.validateDerivation(diagnostics, context);
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

} //SourceValidator
