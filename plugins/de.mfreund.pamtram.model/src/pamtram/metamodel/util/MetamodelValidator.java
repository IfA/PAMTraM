/**
 */
package pamtram.metamodel.util;

import java.util.Map;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.BeginningMatcher;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.CaseSensitiveConstraint;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.EndingMatcher;
import pamtram.metamodel.EqualityMatcher;
import pamtram.metamodel.LibraryElement;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SourceSectionReference;
import pamtram.metamodel.SubstringMatcher;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.TargetSectionReference;
import pamtram.metamodel.VirtualAttribute;

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
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

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
	public MetamodelValidator() {
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
				return validateMetaModelElement((MetaModelElement)value, diagnostics, context);
			case MetamodelPackage.CLASS:
				return validateClass((pamtram.metamodel.Class)value, diagnostics, context);
			case MetamodelPackage.SOURCE_SECTION_CLASS:
				return validateSourceSectionClass((SourceSectionClass)value, diagnostics, context);
			case MetamodelPackage.TARGET_SECTION_CLASS:
				return validateTargetSectionClass((TargetSectionClass)value, diagnostics, context);
			case MetamodelPackage.LIBRARY_ELEMENT:
				return validateLibraryElement((LibraryElement)value, diagnostics, context);
			case MetamodelPackage.REFERENCE:
				return validateReference((Reference)value, diagnostics, context);
			case MetamodelPackage.CONTAINMENT_REFERENCE:
				return validateContainmentReference((ContainmentReference)value, diagnostics, context);
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE:
				return validateNonContainmentReference((NonContainmentReference)value, diagnostics, context);
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
				return validateAttribute((Attribute)value, diagnostics, context);
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE:
				return validateSourceSectionAttribute((SourceSectionAttribute)value, diagnostics, context);
			case MetamodelPackage.TARGET_SECTION_ATTRIBUTE:
				return validateTargetSectionAttribute((TargetSectionAttribute)value, diagnostics, context);
			case MetamodelPackage.ACTUAL_ATTRIBUTE:
				return validateActualAttribute((ActualAttribute)value, diagnostics, context);
			case MetamodelPackage.VIRTUAL_ATTRIBUTE:
				return validateVirtualAttribute((VirtualAttribute)value, diagnostics, context);
			case MetamodelPackage.EQUALITY_MATCHER:
				return validateEqualityMatcher((EqualityMatcher)value, diagnostics, context);
			case MetamodelPackage.ATTRIBUTE_VALUE_CONSTRAINT:
				return validateAttributeValueConstraint((AttributeValueConstraint)value, diagnostics, context);
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
			case MetamodelPackage.ATTRIBUTE_VALUE_CONSTRAINT_TYPE:
				return validateAttributeValueConstraintType((AttributeValueConstraintType)value, diagnostics, context);
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
	public boolean validateMetaModelElement(MetaModelElement metaModelElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(metaModelElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass(pamtram.metamodel.Class class_, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
		return result;
	}

	/**
	 * The cached validation expression for the eClassMatchesParentEReference constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CLASS__ECLASS_MATCHES_PARENT_EREFERENCE__EEXPRESSION = "if metamodel::Reference.oclAsType(ecore::EClass).isSuperTypeOf(self.oclAsType(ecore::EObject).eContainer().eClass()) then self.oclAsType(ecore::EObject).eContainer().oclAsType(metamodel::Reference).eReference.oclAsType(ecore::\r\n" +
		"EReference).eReferenceType.isSuperTypeOf(self.eClass.oclAsType(ecore::EClass)) else true endif";

	/**
	 * Validates the eClassMatchesParentEReference constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_eClassMatchesParentEReference(pamtram.metamodel.Class class_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MetamodelPackage.Literals.CLASS,
				 class_,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "eClassMatchesParentEReference",
				 CLASS__ECLASS_MATCHES_PARENT_EREFERENCE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * Validates the variableCardinalityIsValid constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_variableCardinalityIsValid(pamtram.metamodel.Class class_, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLibraryElement(LibraryElement libraryElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(libraryElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReference(Reference reference, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	 * The cached validation expression for the eReferenceMatchesParentEClass constraint of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String REFERENCE__EREFERENCE_MATCHES_PARENT_ECLASS__EEXPRESSION = "self.oclAsType(ecore::EObject).eContainer().oclAsType(metamodel::Class).eClass.oclAsType(ecore::\r\n" +
		"EClass).eAllReferences->includes(self.eReference)";

	/**
	 * Validates the eReferenceMatchesParentEClass constraint of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReference_eReferenceMatchesParentEClass(Reference reference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MetamodelPackage.Literals.REFERENCE,
				 reference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "eReferenceMatchesParentEClass",
				 REFERENCE__EREFERENCE_MATCHES_PARENT_ECLASS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainmentReference(ContainmentReference containmentReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	 * The cached validation expression for the eReferenceIsContainment constraint of '<em>Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CONTAINMENT_REFERENCE__EREFERENCE_IS_CONTAINMENT__EEXPRESSION = "self.eReference.containment=true";

	/**
	 * Validates the eReferenceIsContainment constraint of '<em>Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainmentReference_eReferenceIsContainment(ContainmentReference containmentReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MetamodelPackage.Literals.CONTAINMENT_REFERENCE,
				 containmentReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "eReferenceIsContainment",
				 CONTAINMENT_REFERENCE__EREFERENCE_IS_CONTAINMENT__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNonContainmentReference(NonContainmentReference nonContainmentReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	 * The cached validation expression for the eReferenceIsNonContainment constraint of '<em>Non Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String NON_CONTAINMENT_REFERENCE__EREFERENCE_IS_NON_CONTAINMENT__EEXPRESSION = "self.eReference.containment=false";

	/**
	 * Validates the eReferenceIsNonContainment constraint of '<em>Non Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNonContainmentReference_eReferenceIsNonContainment(NonContainmentReference nonContainmentReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MetamodelPackage.Literals.NON_CONTAINMENT_REFERENCE,
				 nonContainmentReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "eReferenceIsNonContainment",
				 NON_CONTAINMENT_REFERENCE__EREFERENCE_IS_NON_CONTAINMENT__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
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
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttribute(Attribute attribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attribute, diagnostics, context);
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
	public boolean validateTargetSectionAttribute(TargetSectionAttribute targetSectionAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(targetSectionAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActualAttribute(ActualAttribute actualAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(actualAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualAttribute(VirtualAttribute virtualAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEqualityMatcher(EqualityMatcher equalityMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(equalityMatcher, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeValueConstraint(AttributeValueConstraint attributeValueConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeValueConstraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubstringMatcher(SubstringMatcher substringMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(substringMatcher, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBeginningMatcher(BeginningMatcher beginningMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(beginningMatcher, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEndingMatcher(EndingMatcher endingMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(endingMatcher, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegExMatcher(RegExMatcher regExMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(regExMatcher, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCaseSensitiveConstraint(CaseSensitiveConstraint caseSensitiveConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(caseSensitiveConstraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeValueConstraintType(AttributeValueConstraintType attributeValueConstraintType, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
