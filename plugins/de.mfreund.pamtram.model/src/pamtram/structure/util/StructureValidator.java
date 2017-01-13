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
import pamtram.structure.*;
import pamtram.structure.generic.util.GenericValidator;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionCompositeReference;
import pamtram.structure.source.SourceSectionCrossReference;
import pamtram.structure.source.SourceSectionReference;

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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for
	 * constraint 'Validate Is Referenced By Mapping' of 'Source Section'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int SOURCE_SECTION__VALIDATE_IS_REFERENCED_BY_MAPPING = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Is Referenced By Mapping Hint Group' of 'Target Section'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TARGET_SECTION__VALIDATE_IS_REFERENCED_BY_MAPPING_HINT_GROUP = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate EReference Is Non Containment' of 'Target Section Cross Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TARGET_SECTION_CROSS_REFERENCE__VALIDATE_EREFERENCE_IS_NON_CONTAINMENT = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Modified Attribute Element Types In Condition Model Conditions' of 'Instance Pointer'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_POINTER__VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS = 4;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 4;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected GenericValidator genericValidator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected MappingValidator mappingValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
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
			case StructurePackage.TARGET_SECTION_COMPOSITE_REFERENCE:
				return validateTargetSectionCompositeReference((TargetSectionCompositeReference)value, diagnostics, context);
			case StructurePackage.TARGET_SECTION_CROSS_REFERENCE:
				return validateTargetSectionCrossReference((TargetSectionCrossReference)value, diagnostics, context);
			case StructurePackage.SOURCE_SECTION_COMPOSITE_REFERENCE:
				return validateSourceSectionCompositeReference((SourceSectionCompositeReference)value, diagnostics, context);
			case StructurePackage.SOURCE_SECTION_CROSS_REFERENCE:
				return validateSourceSectionCrossReference((SourceSectionCrossReference)value, diagnostics, context);
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
			case StructurePackage.INSTANCE_POINTER:
				return validateInstancePointer((InstancePointer)value, diagnostics, context);
			case StructurePackage.INSTANCE_POINTER_SOURCE_INTERFACE:
				return validateInstancePointerSourceInterface((InstancePointerSourceInterface)value, diagnostics, context);
			case StructurePackage.INSTANCE_POINTER_SOURCE_ELEMENT:
				return validateInstancePointerSourceElement((InstancePointerSourceElement)value, diagnostics, context);
			case StructurePackage.INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT:
				return validateInstancePointerExternalSourceElement((InstancePointerExternalSourceElement)value, diagnostics, context);
			case StructurePackage.FILE_TYPE_ENUM:
				return validateFileTypeEnum((FileTypeEnum)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSection(SourceSection sourceSection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSection_isReferencedByMapping(SourceSection sourceSection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSection_validateIsReferencedByMapping(SourceSection sourceSection,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sourceSection.validateIsReferencedByMapping(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSection(TargetSection targetSection, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSection_isReferencedByMappingHintGroup(TargetSection targetSection,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSection_validateIsReferencedByMappingHintGroup(TargetSection targetSection,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return targetSection.validateIsReferencedByMappingHintGroup(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFileAttribute(FileAttribute fileAttribute, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fileAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSectionClass(SourceSectionClass sourceSectionClass, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSectionClass(TargetSectionClass targetSectionClass, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLibraryParameter(LibraryParameter<?> libraryParameter, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(libraryParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeParameter(AttributeParameter attributeParameter, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerParameter(ContainerParameter containerParameter, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(containerParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalReferenceParameter(ExternalReferenceParameter externalReferenceParameter,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(externalReferenceParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceParameter(ResourceParameter resourceParameter, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resourceParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLibraryEntry(LibraryEntry libraryEntry, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(libraryEntry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSectionReference(SourceSectionReference sourceSectionReference,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSectionReference(TargetSectionReference targetSectionReference,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	 * Validates the validateEReferenceIsNonContainment constraint of '<em>Target Section Cross Reference</em>'.
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
		if (result || diagnostics != null) result &= genericValidator.validateReference_validateEReferenceMatchesParentEClass(sourceSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateCompositeReference_eReferenceIsContainment(sourceSectionCompositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateCompositeReference_validateEReferenceIsContainment(sourceSectionCompositeReference, diagnostics, context);
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
		if (result || diagnostics != null) result &= genericValidator.validateReference_validateEReferenceMatchesParentEClass(sourceSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateCrossReference_eReferenceIsNonContainment(sourceSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= genericValidator.validateCrossReference_validateValuesMatchReferenceType(sourceSectionCrossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateSourceSectionCrossReference_valuesMatchReferenceType(sourceSectionCrossReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the valuesMatchReferenceType constraint of '<em>Source Section Cross Reference</em>'.
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSectionAttribute(SourceSectionAttribute sourceSectionAttribute,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sourceSectionAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActualSourceSectionAttribute(ActualSourceSectionAttribute actualSourceSectionAttribute,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSectionAttribute(TargetSectionAttribute targetSectionAttribute,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(targetSectionAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActualTargetSectionAttribute(ActualTargetSectionAttribute actualTargetSectionAttribute,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualTargetSectionAttribute(VirtualTargetSectionAttribute virtualTargetSectionAttribute,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualTargetSectionAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstancePointer(InstancePointer instancePointer, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
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
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public boolean validateInstancePointer_noModifiedAttributeElementTypesInConditionModelConditions(
			InstancePointer instancePointer, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public boolean validateInstancePointer_validateNoModifiedAttributeElementTypesInConditionModelConditions(
			InstancePointer instancePointer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return instancePointer.validateNoModifiedAttributeElementTypesInConditionModelConditions(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstancePointerSourceInterface(InstancePointerSourceInterface instancePointerSourceInterface,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(instancePointerSourceInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstancePointerSourceElement(InstancePointerSourceElement instancePointerSourceElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstancePointerExternalSourceElement(
			InstancePointerExternalSourceElement instancePointerExternalSourceElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFileTypeEnum(FileTypeEnum fileTypeEnum, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
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
