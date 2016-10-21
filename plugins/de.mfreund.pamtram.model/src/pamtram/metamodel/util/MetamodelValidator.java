/**
 */
package pamtram.metamodel.util;

import java.util.Map;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import pamtram.mapping.util.MappingValidator;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.ActualTargetSectionAttribute;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.ValueConstraint;
import pamtram.metamodel.ValueConstraintExternalSourceElement;
import pamtram.metamodel.ValueConstraintSourceElement;
import pamtram.metamodel.ValueConstraintSourceInterface;
import pamtram.metamodel.ValueConstraintType;
import pamtram.metamodel.BeginningMatcher;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.CaseSensitiveConstraint;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.EndingMatcher;
import pamtram.metamodel.EqualityMatcher;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.FileAttribute;
import pamtram.metamodel.FileTypeEnum;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.InstancePointerExternalSourceElement;
import pamtram.metamodel.InstancePointerSourceElement;
import pamtram.metamodel.InstancePointerSourceInterface;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.MultipleReferencesValueConstraint;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.RangeBound;
import pamtram.metamodel.RangeConstraint;
import pamtram.metamodel.Reference;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.ResourceParameter;
import pamtram.metamodel.Section;
import pamtram.metamodel.SingleReferenceValueConstraint;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.ActualSourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SourceSectionReference;
import pamtram.metamodel.SubstringMatcher;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.TargetSectionReference;
import pamtram.metamodel.VirtualAttribute;
import pamtram.metamodel.VirtualTargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see pamtram.metamodel.MetamodelPackage
 * @generated
 */
public class MetamodelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MetamodelValidator INSTANCE = new MetamodelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "pamtram.metamodel";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Container Is Valid' of 'Class'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASS__CONTAINER_IS_VALID = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Cardinality Is Valid' of 'Class'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASS__CARDINALITY_IS_VALID = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'EClass Matches Parent EReference' of 'Class'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASS__ECLASS_MATCHES_PARENT_EREFERENCE = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Container Matches Extend Container' of 'Section'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SECTION__VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Extends Valid Sections' of 'Section'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SECTION__EXTENDS_VALID_SECTIONS = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Referenced By Mapping' of 'Source Section'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SOURCE_SECTION__IS_REFERENCED_BY_MAPPING = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Referenced By Mapping Hint Group' of 'Target Section'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TARGET_SECTION__IS_REFERENCED_BY_MAPPING_HINT_GROUP = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'EReference Matches Parent EClass' of 'Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REFERENCE__EREFERENCE_MATCHES_PARENT_ECLASS = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'EReference Is Containment' of 'Containment Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONTAINMENT_REFERENCE__EREFERENCE_IS_CONTAINMENT = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'EReference Is Non Containment' of 'Non Containment Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NON_CONTAINMENT_REFERENCE__EREFERENCE_IS_NON_CONTAINMENT = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Values Match Reference Type' of 'Meta Model Section Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int META_MODEL_SECTION_REFERENCE__VALUES_MATCH_REFERENCE_TYPE = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Attribute Matches Parent EClass' of 'Actual Attribute'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTUAL_ATTRIBUTE__ATTRIBUTE_MATCHES_PARENT_ECLASS = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No Modified Attribute Element Types In Condition Model Conditions' of 'Instance Pointer'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_POINTER__NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Fixed Values In Source Sections' of 'Range Bound'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RANGE_BOUND__VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS = 14;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Fixed Values Or Global Attributes In Condition Model' of 'Range Bound'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RANGE_BOUND__VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL = 15;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Fixed Values In Source Sections' of 'Single Reference Value Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS = 16;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Fixed Values Or Global Attributes In Condition Model' of 'Single Reference Value Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL = 17;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 17;

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
	public MetamodelValidator() {
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
	  return MetamodelPackage.eINSTANCE;
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
			case MetamodelPackage.META_MODEL_ELEMENT:
				return validateMetaModelElement((MetaModelElement<?, ?, ?, ?>)value, diagnostics, context);
			case MetamodelPackage.CLASS:
				return validateClass((pamtram.metamodel.Class<?, ?, ?, ?>)value, diagnostics, context);
			case MetamodelPackage.SECTION:
				return validateSection((Section<?, ?, ?, ?>)value, diagnostics, context);
			case MetamodelPackage.SOURCE_SECTION:
				return validateSourceSection((SourceSection)value, diagnostics, context);
			case MetamodelPackage.TARGET_SECTION:
				return validateTargetSection((TargetSection)value, diagnostics, context);
			case MetamodelPackage.FILE_ATTRIBUTE:
				return validateFileAttribute((FileAttribute)value, diagnostics, context);
			case MetamodelPackage.SOURCE_SECTION_CLASS:
				return validateSourceSectionClass((SourceSectionClass)value, diagnostics, context);
			case MetamodelPackage.TARGET_SECTION_CLASS:
				return validateTargetSectionClass((TargetSectionClass)value, diagnostics, context);
			case MetamodelPackage.LIBRARY_PARAMETER:
				return validateLibraryParameter((LibraryParameter<?>)value, diagnostics, context);
			case MetamodelPackage.ATTRIBUTE_PARAMETER:
				return validateAttributeParameter((AttributeParameter)value, diagnostics, context);
			case MetamodelPackage.CONTAINER_PARAMETER:
				return validateContainerParameter((ContainerParameter)value, diagnostics, context);
			case MetamodelPackage.EXTERNAL_REFERENCE_PARAMETER:
				return validateExternalReferenceParameter((ExternalReferenceParameter)value, diagnostics, context);
			case MetamodelPackage.RESOURCE_PARAMETER:
				return validateResourceParameter((ResourceParameter)value, diagnostics, context);
			case MetamodelPackage.LIBRARY_ENTRY:
				return validateLibraryEntry((LibraryEntry)value, diagnostics, context);
			case MetamodelPackage.REFERENCE:
				return validateReference((Reference<?, ?, ?, ?>)value, diagnostics, context);
			case MetamodelPackage.CONTAINMENT_REFERENCE:
				return validateContainmentReference((ContainmentReference<?, ?, ?, ?>)value, diagnostics, context);
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE:
				return validateNonContainmentReference((NonContainmentReference<?, ?, ?, ?>)value, diagnostics, context);
			case MetamodelPackage.SOURCE_SECTION_REFERENCE:
				return validateSourceSectionReference((SourceSectionReference)value, diagnostics, context);
			case MetamodelPackage.TARGET_SECTION_REFERENCE:
				return validateTargetSectionReference((TargetSectionReference)value, diagnostics, context);
			case MetamodelPackage.TARGET_SECTION_CONTAINMENT_REFERENCE:
				return validateTargetSectionContainmentReference((TargetSectionContainmentReference)value, diagnostics, context);
			case MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE:
				return validateTargetSectionNonContainmentReference((TargetSectionNonContainmentReference)value, diagnostics, context);
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE:
				return validateSourceSectionContainmentReference((SourceSectionContainmentReference)value, diagnostics, context);
			case MetamodelPackage.META_MODEL_SECTION_REFERENCE:
				return validateMetaModelSectionReference((MetaModelSectionReference)value, diagnostics, context);
			case MetamodelPackage.ATTRIBUTE:
				return validateAttribute((Attribute<?, ?, ?, ?>)value, diagnostics, context);
			case MetamodelPackage.ACTUAL_ATTRIBUTE:
				return validateActualAttribute((ActualAttribute<?, ?, ?, ?>)value, diagnostics, context);
			case MetamodelPackage.VIRTUAL_ATTRIBUTE:
				return validateVirtualAttribute((VirtualAttribute<?, ?, ?, ?>)value, diagnostics, context);
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE:
				return validateSourceSectionAttribute((SourceSectionAttribute)value, diagnostics, context);
			case MetamodelPackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE:
				return validateActualSourceSectionAttribute((ActualSourceSectionAttribute)value, diagnostics, context);
			case MetamodelPackage.TARGET_SECTION_ATTRIBUTE:
				return validateTargetSectionAttribute((TargetSectionAttribute)value, diagnostics, context);
			case MetamodelPackage.ACTUAL_TARGET_SECTION_ATTRIBUTE:
				return validateActualTargetSectionAttribute((ActualTargetSectionAttribute)value, diagnostics, context);
			case MetamodelPackage.VIRTUAL_TARGET_SECTION_ATTRIBUTE:
				return validateVirtualTargetSectionAttribute((VirtualTargetSectionAttribute)value, diagnostics, context);
			case MetamodelPackage.EQUALITY_MATCHER:
				return validateEqualityMatcher((EqualityMatcher)value, diagnostics, context);
			case MetamodelPackage.VALUE_CONSTRAINT:
				return validateValueConstraint((ValueConstraint)value, diagnostics, context);
			case MetamodelPackage.SUBSTRING_MATCHER:
				return validateSubstringMatcher((SubstringMatcher)value, diagnostics, context);
			case MetamodelPackage.BEGINNING_MATCHER:
				return validateBeginningMatcher((BeginningMatcher)value, diagnostics, context);
			case MetamodelPackage.ENDING_MATCHER:
				return validateEndingMatcher((EndingMatcher)value, diagnostics, context);
			case MetamodelPackage.REG_EX_MATCHER:
				return validateRegExMatcher((RegExMatcher)value, diagnostics, context);
			case MetamodelPackage.CASE_SENSITIVE_CONSTRAINT:
				return validateCaseSensitiveConstraint((CaseSensitiveConstraint)value, diagnostics, context);
			case MetamodelPackage.RANGE_CONSTRAINT:
				return validateRangeConstraint((RangeConstraint)value, diagnostics, context);
			case MetamodelPackage.MULTIPLE_REFERENCES_VALUE_CONSTRAINT:
				return validateMultipleReferencesValueConstraint((MultipleReferencesValueConstraint)value, diagnostics, context);
			case MetamodelPackage.INSTANCE_POINTER:
				return validateInstancePointer((InstancePointer)value, diagnostics, context);
			case MetamodelPackage.INSTANCE_POINTER_SOURCE_INTERFACE:
				return validateInstancePointerSourceInterface((InstancePointerSourceInterface)value, diagnostics, context);
			case MetamodelPackage.INSTANCE_POINTER_SOURCE_ELEMENT:
				return validateInstancePointerSourceElement((InstancePointerSourceElement)value, diagnostics, context);
			case MetamodelPackage.INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT:
				return validateInstancePointerExternalSourceElement((InstancePointerExternalSourceElement)value, diagnostics, context);
			case MetamodelPackage.RANGE_BOUND:
				return validateRangeBound((RangeBound)value, diagnostics, context);
			case MetamodelPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT:
				return validateSingleReferenceValueConstraint((SingleReferenceValueConstraint)value, diagnostics, context);
			case MetamodelPackage.VALUE_CONSTRAINT_SOURCE_INTERFACE:
				return validateValueConstraintSourceInterface((ValueConstraintSourceInterface)value, diagnostics, context);
			case MetamodelPackage.VALUE_CONSTRAINT_SOURCE_ELEMENT:
				return validateValueConstraintSourceElement((ValueConstraintSourceElement)value, diagnostics, context);
			case MetamodelPackage.VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT:
				return validateValueConstraintExternalSourceElement((ValueConstraintExternalSourceElement)value, diagnostics, context);
			case MetamodelPackage.FILE_TYPE_ENUM:
				return validateFileTypeEnum((FileTypeEnum)value, diagnostics, context);
			case MetamodelPackage.VALUE_CONSTRAINT_TYPE:
				return validateValueConstraintType((ValueConstraintType)value, diagnostics, context);
			case MetamodelPackage.CARDINALITY_TYPE:
				return validateCardinalityType((CardinalityType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetaModelElement(MetaModelElement<?, ?, ?, ?> metaModelElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(metaModelElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass(pamtram.metamodel.Class<?, ?, ?, ?> class_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(class_, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_eClassMatchesParentEReference(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_variableCardinalityIsValid(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_containerIsValid(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_cardinalityIsValid(class_, diagnostics, context);
		return result;
	}

	/**
	 * Validates the containerIsValid constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_containerIsValid(pamtram.metamodel.Class<?, ?, ?, ?> class_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return class_.containerIsValid(diagnostics, context);
	}

	/**
	 * Validates the cardinalityIsValid constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_cardinalityIsValid(pamtram.metamodel.Class<?, ?, ?, ?> class_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return class_.cardinalityIsValid(diagnostics, context);
	}

	/**
	 * Validates the eClassMatchesParentEReference constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_eClassMatchesParentEReference(pamtram.metamodel.Class<?, ?, ?, ?> class_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return class_.eClassMatchesParentEReference(diagnostics, context);
	}

	/**
	 * Validates the variableCardinalityIsValid constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_variableCardinalityIsValid(pamtram.metamodel.Class<?, ?, ?, ?> class_, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "variableCardinalityIsValid", getObjectLabel(class_, context) },
						 new Object[] { class_ },
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
	public boolean validateSection(Section<?, ?, ?, ?> section, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(section, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(section, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(section, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(section, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(section, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(section, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(section, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(section, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_eClassMatchesParentEReference(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_variableCardinalityIsValid(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_containerIsValid(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_cardinalityIsValid(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateSection_extendsValidSections(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateSection_containerMatchesExtendContainer(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateSection_validateContainerMatchesExtendContainer(section, diagnostics, context);
		return result;
	}

	/**
	 * Validates the extendsValidSections constraint of '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSection_extendsValidSections(Section<?, ?, ?, ?> section, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return section.extendsValidSections(diagnostics, context);
	}

	/**
	 * Validates the containerMatchesExtendContainer constraint of '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSection_containerMatchesExtendContainer(Section<?, ?, ?, ?> section, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "containerMatchesExtendContainer", getObjectLabel(section, context) },
						 new Object[] { section },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateContainerMatchesExtendContainer constraint of '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSection_validateContainerMatchesExtendContainer(Section<?, ?, ?, ?> section, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return section.validateContainerMatchesExtendContainer(diagnostics, context);
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
		if (result || diagnostics != null) result &= validateClass_eClassMatchesParentEReference(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_variableCardinalityIsValid(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_containerIsValid(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_cardinalityIsValid(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateSection_extendsValidSections(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateSection_containerMatchesExtendContainer(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateSection_validateContainerMatchesExtendContainer(sourceSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateSourceSection_isReferencedByMapping(sourceSection, diagnostics, context);
		return result;
	}

	/**
	 * Validates the isReferencedByMapping constraint of '<em>Source Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceSection_isReferencedByMapping(SourceSection sourceSection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sourceSection.isReferencedByMapping(diagnostics, context);
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
		if (result || diagnostics != null) result &= validateClass_eClassMatchesParentEReference(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_variableCardinalityIsValid(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_containerIsValid(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_cardinalityIsValid(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateSection_extendsValidSections(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateSection_containerMatchesExtendContainer(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateSection_validateContainerMatchesExtendContainer(targetSection, diagnostics, context);
		if (result || diagnostics != null) result &= validateTargetSection_isReferencedByMappingHintGroup(targetSection, diagnostics, context);
		return result;
	}

	/**
	 * Validates the isReferencedByMappingHintGroup constraint of '<em>Target Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetSection_isReferencedByMappingHintGroup(TargetSection targetSection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return targetSection.isReferencedByMappingHintGroup(diagnostics, context);
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
		if (result || diagnostics != null) result &= validateClass_eClassMatchesParentEReference(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_variableCardinalityIsValid(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_containerIsValid(sourceSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_cardinalityIsValid(sourceSectionClass, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateClass_eClassMatchesParentEReference(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_variableCardinalityIsValid(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_containerIsValid(targetSectionClass, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_cardinalityIsValid(targetSectionClass, diagnostics, context);
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
	public boolean validateReference(Reference<?, ?, ?, ?> reference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(reference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validateReference_eReferenceMatchesParentEClass(reference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the eReferenceMatchesParentEClass constraint of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReference_eReferenceMatchesParentEClass(Reference<?, ?, ?, ?> reference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return reference.eReferenceMatchesParentEClass(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainmentReference(ContainmentReference<?, ?, ?, ?> containmentReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(containmentReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(containmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(containmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(containmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(containmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(containmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(containmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(containmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(containmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateReference_eReferenceMatchesParentEClass(containmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateContainmentReference_eReferenceIsContainment(containmentReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the eReferenceIsContainment constraint of '<em>Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainmentReference_eReferenceIsContainment(ContainmentReference<?, ?, ?, ?> containmentReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return containmentReference.eReferenceIsContainment(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNonContainmentReference(NonContainmentReference<?, ?, ?, ?> nonContainmentReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(nonContainmentReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(nonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(nonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(nonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(nonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(nonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(nonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(nonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(nonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateReference_eReferenceMatchesParentEClass(nonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateNonContainmentReference_eReferenceIsNonContainment(nonContainmentReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the eReferenceIsNonContainment constraint of '<em>Non Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNonContainmentReference_eReferenceIsNonContainment(NonContainmentReference<?, ?, ?, ?> nonContainmentReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nonContainmentReference.eReferenceIsNonContainment(diagnostics, context);
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
		if (result || diagnostics != null) result &= validateReference_eReferenceMatchesParentEClass(sourceSectionReference, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateReference_eReferenceMatchesParentEClass(targetSectionReference, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateReference_eReferenceMatchesParentEClass(targetSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateContainmentReference_eReferenceIsContainment(targetSectionContainmentReference, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateReference_eReferenceMatchesParentEClass(targetSectionNonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateNonContainmentReference_eReferenceIsNonContainment(targetSectionNonContainmentReference, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateReference_eReferenceMatchesParentEClass(sourceSectionContainmentReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateContainmentReference_eReferenceIsContainment(sourceSectionContainmentReference, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateReference_eReferenceMatchesParentEClass(metaModelSectionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateMetaModelSectionReference_valuesMatchReferenceType(metaModelSectionReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the valuesMatchReferenceType constraint of '<em>Meta Model Section Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetaModelSectionReference_valuesMatchReferenceType(MetaModelSectionReference metaModelSectionReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return metaModelSectionReference.valuesMatchReferenceType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttribute(Attribute<?, ?, ?, ?> attribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActualAttribute(ActualAttribute<?, ?, ?, ?> actualAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(actualAttribute, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(actualAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(actualAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(actualAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(actualAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(actualAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(actualAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(actualAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(actualAttribute, diagnostics, context);
		if (result || diagnostics != null) result &= validateActualAttribute_attributeMatchesParentEClass(actualAttribute, diagnostics, context);
		return result;
	}

	/**
	 * Validates the attributeMatchesParentEClass constraint of '<em>Actual Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActualAttribute_attributeMatchesParentEClass(ActualAttribute<?, ?, ?, ?> actualAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return actualAttribute.attributeMatchesParentEClass(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualAttribute(VirtualAttribute<?, ?, ?, ?> virtualAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualAttribute, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateActualAttribute_attributeMatchesParentEClass(actualSourceSectionAttribute, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateActualAttribute_attributeMatchesParentEClass(actualTargetSectionAttribute, diagnostics, context);
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
		return result;
	}

	/**
	 * Validates the noModifiedAttributeElementTypesInConditionModelConditions constraint of '<em>Instance Pointer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstancePointer_noModifiedAttributeElementTypesInConditionModelConditions(InstancePointer instancePointer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return instancePointer.noModifiedAttributeElementTypesInConditionModelConditions(diagnostics, context);
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityType(CardinalityType cardinalityType, DiagnosticChain diagnostics, Map<Object, Object> context) {
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

} //MetamodelValidator
