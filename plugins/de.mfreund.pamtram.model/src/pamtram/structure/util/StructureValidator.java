/**
 */
package pamtram.structure.util;

import java.util.Map;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import pamtram.mapping.util.MappingValidator;
import pamtram.structure.ActualSourceSectionAttribute;
import pamtram.structure.ActualTargetSectionAttribute;
import pamtram.structure.AttributeParameter;
import pamtram.structure.BeginningMatcher;
import pamtram.structure.CaseSensitiveConstraint;
import pamtram.structure.ContainerParameter;
import pamtram.structure.EndingMatcher;
import pamtram.structure.EqualityMatcher;
import pamtram.structure.ExternalReferenceParameter;
import pamtram.structure.FileAttribute;
import pamtram.structure.FileTypeEnum;
import pamtram.structure.InstancePointer;
import pamtram.structure.InstancePointerExternalSourceElement;
import pamtram.structure.InstancePointerSourceElement;
import pamtram.structure.InstancePointerSourceInterface;
import pamtram.structure.LibraryEntry;
import pamtram.structure.LibraryParameter;
import pamtram.structure.MetaModelSectionReference;
import pamtram.structure.StructurePackage;
import pamtram.structure.MultipleReferencesValueConstraint;
import pamtram.structure.RangeBound;
import pamtram.structure.RangeConstraint;
import pamtram.structure.RegExMatcher;
import pamtram.structure.ResourceParameter;
import pamtram.structure.SingleReferenceValueConstraint;
import pamtram.structure.SourceSection;
import pamtram.structure.SourceSectionAttribute;
import pamtram.structure.SourceSectionClass;
import pamtram.structure.SourceSectionContainmentReference;
import pamtram.structure.SourceSectionReference;
import pamtram.structure.SubstringMatcher;
import pamtram.structure.TargetSection;
import pamtram.structure.TargetSectionAttribute;
import pamtram.structure.TargetSectionClass;
import pamtram.structure.TargetSectionContainmentReference;
import pamtram.structure.TargetSectionNonContainmentReference;
import pamtram.structure.TargetSectionReference;
import pamtram.structure.ValueConstraint;
import pamtram.structure.ValueConstraintExternalSourceElement;
import pamtram.structure.ValueConstraintSourceElement;
import pamtram.structure.ValueConstraintSourceInterface;
import pamtram.structure.ValueConstraintType;
import pamtram.structure.VirtualTargetSectionAttribute;
import pamtram.structure.generic.util.GenericValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see pamtram.structure.StructurePackage
 * @generated
 */
public class StructureValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final StructureValidator INSTANCE = new StructureValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "pamtram.structure";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Is Referenced By Mapping' of 'Source Section'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SOURCE_SECTION__VALIDATE_IS_REFERENCED_BY_MAPPING = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Is Referenced By Mapping Hint Group' of 'Target Section'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TARGET_SECTION__VALIDATE_IS_REFERENCED_BY_MAPPING_HINT_GROUP = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Values Match Reference Type' of 'Meta Model Section Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int META_MODEL_SECTION_REFERENCE__VALIDATE_VALUES_MATCH_REFERENCE_TYPE = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Modified Attribute Element Types In Condition Model Conditions' of 'Instance Pointer'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_POINTER__VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Fixed Values In Source Sections' of 'Range Bound'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RANGE_BOUND__VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Fixed Values Or Global Attributes In Condition Model' of 'Range Bound'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RANGE_BOUND__VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Fixed Values In Source Sections' of 'Single Reference Value Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Fixed Values Or Global Attributes In Condition Model' of 'Single Reference Value Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Result Modifier In Source Sections' of 'Single Reference Value Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS = 9;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 9;

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
	public StructureValidator() {
		super();
		genericValidator = GenericValidator.INSTANCE;
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
	  return StructurePackage.eINSTANCE;
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
			case StructurePackage.SOURCE_SECTION:
				return validateSourceSection((SourceSection)value, diagnostics, context);
			case StructurePackage.TARGET_SECTION:
				return validateTargetSection((TargetSection)value, diagnostics, context);
			case StructurePackage.FILE_ATTRIBUTE:
				return validateFileAttribute((FileAttribute)value, diagnostics, context);
			case StructurePackage.SOURCE_SECTION_CLASS:
				return validateSourceSectionClass((SourceSectionClass)value, diagnostics, context);
			case StructurePackage.TARGET_SECTION_CLASS:
				return validateTargetSectionClass((TargetSectionClass)value, diagnostics, context);
			case StructurePackage.LIBRARY_PARAMETER:
				return validateLibraryParameter((LibraryParameter<?>)value, diagnostics, context);
			case StructurePackage.ATTRIBUTE_PARAMETER:
				return validateAttributeParameter((AttributeParameter)value, diagnostics, context);
			case StructurePackage.CONTAINER_PARAMETER:
				return validateContainerParameter((ContainerParameter)value, diagnostics, context);
			case StructurePackage.EXTERNAL_REFERENCE_PARAMETER:
				return validateExternalReferenceParameter((ExternalReferenceParameter)value, diagnostics, context);
			case StructurePackage.RESOURCE_PARAMETER:
				return validateResourceParameter((ResourceParameter)value, diagnostics, context);
			case StructurePackage.LIBRARY_ENTRY:
				return validateLibraryEntry((LibraryEntry)value, diagnostics, context);
			case StructurePackage.SOURCE_SECTION_REFERENCE:
				return validateSourceSectionReference((SourceSectionReference)value, diagnostics, context);
			case StructurePackage.TARGET_SECTION_REFERENCE:
				return validateTargetSectionReference((TargetSectionReference)value, diagnostics, context);
			case StructurePackage.TARGET_SECTION_CONTAINMENT_REFERENCE:
				return validateTargetSectionContainmentReference((TargetSectionContainmentReference)value, diagnostics, context);
			case StructurePackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE:
				return validateTargetSectionNonContainmentReference((TargetSectionNonContainmentReference)value, diagnostics, context);
			case StructurePackage.SOURCE_SECTION_CONTAINMENT_REFERENCE:
				return validateSourceSectionContainmentReference((SourceSectionContainmentReference)value, diagnostics, context);
			case StructurePackage.META_MODEL_SECTION_REFERENCE:
				return validateMetaModelSectionReference((MetaModelSectionReference)value, diagnostics, context);
			case StructurePackage.SOURCE_SECTION_ATTRIBUTE:
				return validateSourceSectionAttribute((SourceSectionAttribute)value, diagnostics, context);
			case StructurePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE:
				return validateActualSourceSectionAttribute((ActualSourceSectionAttribute)value, diagnostics, context);
			case StructurePackage.TARGET_SECTION_ATTRIBUTE:
				return validateTargetSectionAttribute((TargetSectionAttribute)value, diagnostics, context);
			case StructurePackage.ACTUAL_TARGET_SECTION_ATTRIBUTE:
				return validateActualTargetSectionAttribute((ActualTargetSectionAttribute)value, diagnostics, context);
			case StructurePackage.VIRTUAL_TARGET_SECTION_ATTRIBUTE:
				return validateVirtualTargetSectionAttribute((VirtualTargetSectionAttribute)value, diagnostics, context);
			case StructurePackage.EQUALITY_MATCHER:
				return validateEqualityMatcher((EqualityMatcher)value, diagnostics, context);
			case StructurePackage.VALUE_CONSTRAINT:
				return validateValueConstraint((ValueConstraint)value, diagnostics, context);
			case StructurePackage.SUBSTRING_MATCHER:
				return validateSubstringMatcher((SubstringMatcher)value, diagnostics, context);
			case StructurePackage.BEGINNING_MATCHER:
				return validateBeginningMatcher((BeginningMatcher)value, diagnostics, context);
			case StructurePackage.ENDING_MATCHER:
				return validateEndingMatcher((EndingMatcher)value, diagnostics, context);
			case StructurePackage.REG_EX_MATCHER:
				return validateRegExMatcher((RegExMatcher)value, diagnostics, context);
			case StructurePackage.CASE_SENSITIVE_CONSTRAINT:
				return validateCaseSensitiveConstraint((CaseSensitiveConstraint)value, diagnostics, context);
			case StructurePackage.RANGE_CONSTRAINT:
				return validateRangeConstraint((RangeConstraint)value, diagnostics, context);
			case StructurePackage.MULTIPLE_REFERENCES_VALUE_CONSTRAINT:
				return validateMultipleReferencesValueConstraint((MultipleReferencesValueConstraint)value, diagnostics, context);
			case StructurePackage.INSTANCE_POINTER:
				return validateInstancePointer((InstancePointer)value, diagnostics, context);
			case StructurePackage.INSTANCE_POINTER_SOURCE_INTERFACE:
				return validateInstancePointerSourceInterface((InstancePointerSourceInterface)value, diagnostics, context);
			case StructurePackage.INSTANCE_POINTER_SOURCE_ELEMENT:
				return validateInstancePointerSourceElement((InstancePointerSourceElement)value, diagnostics, context);
			case StructurePackage.INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT:
				return validateInstancePointerExternalSourceElement((InstancePointerExternalSourceElement)value, diagnostics, context);
			case StructurePackage.RANGE_BOUND:
				return validateRangeBound((RangeBound)value, diagnostics, context);
			case StructurePackage.SINGLE_REFERENCE_VALUE_CONSTRAINT:
				return validateSingleReferenceValueConstraint((SingleReferenceValueConstraint)value, diagnostics, context);
			case StructurePackage.VALUE_CONSTRAINT_SOURCE_INTERFACE:
				return validateValueConstraintSourceInterface((ValueConstraintSourceInterface)value, diagnostics, context);
			case StructurePackage.VALUE_CONSTRAINT_SOURCE_ELEMENT:
				return validateValueConstraintSourceElement((ValueConstraintSourceElement)value, diagnostics, context);
			case StructurePackage.VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT:
				return validateValueConstraintExternalSourceElement((ValueConstraintExternalSourceElement)value, diagnostics, context);
			case StructurePackage.FILE_TYPE_ENUM:
				return validateFileTypeEnum((FileTypeEnum)value, diagnostics, context);
			case StructurePackage.VALUE_CONSTRAINT_TYPE:
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
	 * Validates the isReferencedByMapping constraint of '<em>Source Section</em>'.
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
	 * Validates the validateIsReferencedByMapping constraint of '<em>Source Section</em>'.
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
		return result;
	}

	/**
	 * Validates the isReferencedByMappingHintGroup constraint of '<em>Target Section</em>'.
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
	 * Validates the validateIsReferencedByMappingHintGroup constraint of '<em>Target Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSection_validateIsReferencedByMappingHintGroup(TargetSection targetSection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return targetSection.validateIsReferencedByMappingHintGroup(diagnostics, context);
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
	public boolean validateLibraryParameter(LibraryParameter<?> libraryParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(libraryParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeParameter(AttributeParameter attributeParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerParameter(ContainerParameter containerParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(containerParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalReferenceParameter(ExternalReferenceParameter externalReferenceParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(externalReferenceParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceParameter(ResourceParameter resourceParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resourceParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLibraryEntry(LibraryEntry libraryEntry, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(libraryEntry, diagnostics, context);
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
		if (result || diagnostics != null) result &= genericValidator.validateReference_validateEReferenceMatchesParentEClass(sourceSectionReference, diagnostics, context);
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
	public boolean validateTargetSectionContainmentReference(TargetSectionContainmentReference targetSectionContainmentReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(targetSectionContainmentReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(targetSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(targetSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(targetSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(targetSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(targetSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(targetSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(targetSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(targetSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_eReferenceMatchesParentEClass(targetSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_validateEReferenceMatchesParentEClass(targetSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateContainmentReference_eReferenceIsContainment(targetSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateContainmentReference_validateEReferenceIsContainment(targetSectionContainmentReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSectionNonContainmentReference(TargetSectionNonContainmentReference targetSectionNonContainmentReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(targetSectionNonContainmentReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(targetSectionNonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(targetSectionNonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(targetSectionNonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(targetSectionNonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(targetSectionNonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(targetSectionNonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(targetSectionNonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(targetSectionNonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_eReferenceMatchesParentEClass(targetSectionNonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_validateEReferenceMatchesParentEClass(targetSectionNonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateNonContainmentReference_eReferenceIsNonContainment(targetSectionNonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateNonContainmentReference_validateEReferenceIsNonContainment(targetSectionNonContainmentReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSectionContainmentReference(SourceSectionContainmentReference sourceSectionContainmentReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sourceSectionContainmentReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sourceSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sourceSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sourceSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sourceSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sourceSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sourceSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sourceSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sourceSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_eReferenceMatchesParentEClass(sourceSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_validateEReferenceMatchesParentEClass(sourceSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateContainmentReference_eReferenceIsContainment(sourceSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateContainmentReference_validateEReferenceIsContainment(sourceSectionContainmentReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetaModelSectionReference(MetaModelSectionReference metaModelSectionReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(metaModelSectionReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(metaModelSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(metaModelSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(metaModelSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(metaModelSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(metaModelSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(metaModelSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(metaModelSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(metaModelSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_eReferenceMatchesParentEClass(metaModelSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateReference_validateEReferenceMatchesParentEClass(metaModelSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateMetaModelSectionReference_valuesMatchReferenceType(metaModelSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateMetaModelSectionReference_validateValuesMatchReferenceType(metaModelSectionReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the valuesMatchReferenceType constraint of '<em>Meta Model Section Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetaModelSectionReference_valuesMatchReferenceType(MetaModelSectionReference metaModelSectionReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "valuesMatchReferenceType", getObjectLabel(metaModelSectionReference, context) },
						 new Object[] { metaModelSectionReference },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateValuesMatchReferenceType constraint of '<em>Meta Model Section Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetaModelSectionReference_validateValuesMatchReferenceType(MetaModelSectionReference metaModelSectionReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return metaModelSectionReference.validateValuesMatchReferenceType(diagnostics, context);
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
	public boolean validateEqualityMatcher(EqualityMatcher equalityMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	public boolean validateSubstringMatcher(SubstringMatcher substringMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	public boolean validateBeginningMatcher(BeginningMatcher beginningMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	public boolean validateEndingMatcher(EndingMatcher endingMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	public boolean validateRegExMatcher(RegExMatcher regExMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	public boolean validateInstancePointer(InstancePointer instancePointer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(instancePointer, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(instancePointer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(instancePointer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(instancePointer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(instancePointer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(instancePointer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(instancePointer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(instancePointer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(instancePointer, diagnostics, context);
		if (result || diagnostics != null) result &= validateInstancePointer_noModifiedAttributeElementTypesInConditionModelConditions(instancePointer, diagnostics, context);
		if (result || diagnostics != null) result &= validateInstancePointer_validateNoModifiedAttributeElementTypesInConditionModelConditions(instancePointer, diagnostics, context);
		return result;
	}

	/**
	 * Validates the noModifiedAttributeElementTypesInConditionModelConditions constraint of '<em>Instance Pointer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstancePointer_noModifiedAttributeElementTypesInConditionModelConditions(InstancePointer instancePointer, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "noModifiedAttributeElementTypesInConditionModelConditions", getObjectLabel(instancePointer, context) },
						 new Object[] { instancePointer },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateNoModifiedAttributeElementTypesInConditionModelConditions constraint of '<em>Instance Pointer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstancePointer_validateNoModifiedAttributeElementTypesInConditionModelConditions(InstancePointer instancePointer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return instancePointer.validateNoModifiedAttributeElementTypesInConditionModelConditions(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstancePointerSourceInterface(InstancePointerSourceInterface instancePointerSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(instancePointerSourceInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstancePointerSourceElement(InstancePointerSourceElement instancePointerSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(instancePointerSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(instancePointerSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(instancePointerSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(instancePointerSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(instancePointerSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(instancePointerSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(instancePointerSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(instancePointerSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(instancePointerSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= mappingValidator.validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(instancePointerSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= mappingValidator.validateLocalModifiedAttributeElementType_validateSourceAttributeMatchesSectionOrContainedSection(instancePointerSourceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstancePointerExternalSourceElement(InstancePointerExternalSourceElement instancePointerExternalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(instancePointerExternalSourceElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(instancePointerExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(instancePointerExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(instancePointerExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(instancePointerExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(instancePointerExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(instancePointerExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(instancePointerExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(instancePointerExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= mappingValidator.validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(instancePointerExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) result &= mappingValidator.validateExternalModifiedAttributeElementType_validateSourceAttributeMatchesContainerSection(instancePointerExternalSourceElement, diagnostics, context);
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
	public boolean validateFileTypeEnum(FileTypeEnum fileTypeEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
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

} //StructureValidator
