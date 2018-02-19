/**
 */
package pamtram.structure.generic.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.CardinalityType;
import pamtram.structure.generic.CompositeReference;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.generic.VirtualAttribute;
import pamtram.structure.generic.VirtualReference;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc
 * -->
 *
 * @see pamtram.structure.generic.GenericPackage
 * @generated
 */
public class GenericValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final GenericValidator INSTANCE = new GenericValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "pamtram.structure.generic";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for
	 * constraint 'Validate EClass Matches Parent EReference' of 'Class'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int CLASS__VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for
	 * constraint 'Validate Cardinality Is Valid' of 'Class'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int CLASS__VALIDATE_CARDINALITY_IS_VALID = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Container Is Valid' of 'Class'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASS__VALIDATE_CONTAINER_IS_VALID = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Self Container' of 'Class'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASS__VALIDATE_NOT_SELF_CONTAINER = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Complementing Actual References' of 'Class'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASS__VALIDATE_ONLY_COMPLEMENTING_ACTUAL_REFERENCES = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Container Matches Extend Container' of 'Section'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SECTION__VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for
	 * constraint 'Validate Extends Valid Sections' of 'Section'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int SECTION__VALIDATE_EXTENDS_VALID_SECTIONS = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Extend Self' of 'Section'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SECTION__VALIDATE_NOT_EXTEND_SELF = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate EReference Matches Parent EClass' of 'Actual Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTUAL_REFERENCE__VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate EReference Is Containment' of 'Composite Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMPOSITE_REFERENCE__VALIDATE_EREFERENCE_IS_CONTAINMENT = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Values Match Reference Type' of 'Cross Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CROSS_REFERENCE__VALIDATE_VALUES_MATCH_REFERENCE_TYPE = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Attribute Matches Parent EClass' of 'Actual Attribute'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTUAL_ATTRIBUTE__VALIDATE_ATTRIBUTE_MATCHES_PARENT_ECLASS = 12;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 12;

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
	public GenericValidator() {
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
	  return GenericPackage.eINSTANCE;
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
			case GenericPackage.META_MODEL_ELEMENT:
				return validateMetaModelElement((MetaModelElement<?, ?, ?, ?>)value, diagnostics, context);
			case GenericPackage.CLASS:
				return validateClass((pamtram.structure.generic.Class<?, ?, ?, ?>)value, diagnostics, context);
			case GenericPackage.SECTION:
				return validateSection((Section<?, ?, ?, ?>)value, diagnostics, context);
			case GenericPackage.REFERENCE:
				return validateReference((Reference<?, ?, ?, ?>)value, diagnostics, context);
			case GenericPackage.ACTUAL_REFERENCE:
				return validateActualReference((ActualReference<?, ?, ?, ?>)value, diagnostics, context);
			case GenericPackage.VIRTUAL_REFERENCE:
				return validateVirtualReference((VirtualReference<?, ?, ?, ?>)value, diagnostics, context);
			case GenericPackage.COMPOSITE_REFERENCE:
				return validateCompositeReference((CompositeReference<?, ?, ?, ?>)value, diagnostics, context);
			case GenericPackage.CROSS_REFERENCE:
				return validateCrossReference((CrossReference<?, ?, ?, ?>)value, diagnostics, context);
			case GenericPackage.ATTRIBUTE:
				return validateAttribute((Attribute<?, ?, ?, ?>)value, diagnostics, context);
			case GenericPackage.ACTUAL_ATTRIBUTE:
				return validateActualAttribute((ActualAttribute<?, ?, ?, ?>)value, diagnostics, context);
			case GenericPackage.VIRTUAL_ATTRIBUTE:
				return validateVirtualAttribute((VirtualAttribute<?, ?, ?, ?>)value, diagnostics, context);
			case GenericPackage.CARDINALITY_TYPE:
				return validateCardinalityType((CardinalityType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetaModelElement(MetaModelElement<?, ?, ?, ?> metaModelElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(metaModelElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass(pamtram.structure.generic.Class<?, ?, ?, ?> class_, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
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
		if (result || diagnostics != null) result &= validateClass_validateEClassMatchesParentEReference(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateCardinalityIsValid(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateContainerIsValid(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNotSelfContainer(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateOnlyComplementingActualReferences(class_, diagnostics, context);
		return result;
	}

	/**
	 * Validates the eClassMatchesParentEReference constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_eClassMatchesParentEReference(pamtram.structure.generic.Class<?, ?, ?, ?> class_,
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
						 new Object[] { "eClassMatchesParentEReference", getObjectLabel(class_, context) },
						 new Object[] { class_ },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the variableCardinalityIsValid constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_variableCardinalityIsValid(pamtram.structure.generic.Class<?, ?, ?, ?> class_,
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
						 new Object[] { "variableCardinalityIsValid", getObjectLabel(class_, context) },
						 new Object[] { class_ },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the containerIsValid constraint of '<em>Class</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateClass_containerIsValid(pamtram.structure.generic.Class<?, ?, ?, ?> class_,
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
						 new Object[] { "containerIsValid", getObjectLabel(class_, context) },
						 new Object[] { class_ },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateEClassMatchesParentEReference constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_validateEClassMatchesParentEReference(
			pamtram.structure.generic.Class<?, ?, ?, ?> class_, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return class_.validateEClassMatchesParentEReference(diagnostics, context);
	}

	/**
	 * Validates the validateCardinalityIsValid constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_validateCardinalityIsValid(pamtram.structure.generic.Class<?, ?, ?, ?> class_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return class_.validateCardinalityIsValid(diagnostics, context);
	}

	/**
	 * Validates the validateContainerIsValid constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_validateContainerIsValid(pamtram.structure.generic.Class<?, ?, ?, ?> class_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return class_.validateContainerIsValid(diagnostics, context);
	}

	/**
	 * Validates the validateNotSelfContainer constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_validateNotSelfContainer(pamtram.structure.generic.Class<?, ?, ?, ?> class_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return class_.validateNotSelfContainer(diagnostics, context);
	}

	/**
	 * Validates the validateOnlyComplementingActualReferences constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_validateOnlyComplementingActualReferences(pamtram.structure.generic.Class<?, ?, ?, ?> class_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return class_.validateOnlyComplementingActualReferences(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSection(Section<?, ?, ?, ?> section, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
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
		if (result || diagnostics != null) result &= validateClass_validateEClassMatchesParentEReference(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateCardinalityIsValid(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateContainerIsValid(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNotSelfContainer(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateOnlyComplementingActualReferences(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateSection_extendsValidSections(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateSection_containerMatchesExtendContainer(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateSection_validateContainerMatchesExtendContainer(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateSection_validateExtendsValidSections(section, diagnostics, context);
		if (result || diagnostics != null) result &= validateSection_validateNotExtendSelf(section, diagnostics, context);
		return result;
	}

	/**
	 * Validates the extendsValidSections constraint of '<em>Section</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateSection_extendsValidSections(Section<?, ?, ?, ?> section, DiagnosticChain diagnostics,
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
						 new Object[] { "extendsValidSections", getObjectLabel(section, context) },
						 new Object[] { section },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the containerMatchesExtendContainer constraint of '<em>Section</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSection_containerMatchesExtendContainer(Section<?, ?, ?, ?> section,
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSection_validateContainerMatchesExtendContainer(Section<?, ?, ?, ?> section,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return section.validateContainerMatchesExtendContainer(diagnostics, context);
	}

	/**
	 * Validates the validateExtendsValidSections constraint of '<em>Section</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSection_validateExtendsValidSections(Section<?, ?, ?, ?> section,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return section.validateExtendsValidSections(diagnostics, context);
	}

	/**
	 * Validates the validateNotExtendSelf constraint of '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSection_validateNotExtendSelf(Section<?, ?, ?, ?> section, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return section.validateNotExtendSelf(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReference(Reference<?, ?, ?, ?> reference, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReference_eReferenceMatchesParentEClass(Reference<?, ?, ?, ?> reference,
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
						 new Object[] { "eReferenceMatchesParentEClass", getObjectLabel(reference, context) },
						 new Object[] { reference },
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
	public boolean validateActualReference(ActualReference<?, ?, ?, ?> actualReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(actualReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(actualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(actualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(actualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(actualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(actualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(actualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(actualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(actualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateReference_eReferenceMatchesParentEClass(actualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateActualReference_validateEReferenceMatchesParentEClass(actualReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateEReferenceMatchesParentEClass constraint of '<em>Actual Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActualReference_validateEReferenceMatchesParentEClass(ActualReference<?, ?, ?, ?> actualReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return actualReference.validateEReferenceMatchesParentEClass(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualReference(VirtualReference<?, ?, ?, ?> virtualReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(virtualReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(virtualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(virtualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(virtualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(virtualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(virtualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(virtualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(virtualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(virtualReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateReference_eReferenceMatchesParentEClass(virtualReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeReference(CompositeReference<?, ?, ?, ?> compositeReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(compositeReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(compositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(compositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(compositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(compositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(compositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(compositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(compositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(compositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateReference_eReferenceMatchesParentEClass(compositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompositeReference_eReferenceIsContainment(compositeReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompositeReference_validateEReferenceIsContainment(compositeReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the eReferenceIsContainment constraint of '<em>Composite Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeReference_eReferenceIsContainment(CompositeReference<?, ?, ?, ?> compositeReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "eReferenceIsContainment", getObjectLabel(compositeReference, context) },
						 new Object[] { compositeReference },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateEReferenceIsContainment constraint of '<em>Composite Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeReference_validateEReferenceIsContainment(CompositeReference<?, ?, ?, ?> compositeReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return compositeReference.validateEReferenceIsContainment(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCrossReference(CrossReference<?, ?, ?, ?> crossReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(crossReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(crossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(crossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(crossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(crossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(crossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(crossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(crossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(crossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateReference_eReferenceMatchesParentEClass(crossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateCrossReference_eReferenceIsNonContainment(crossReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateCrossReference_validateValuesMatchReferenceType(crossReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the eReferenceIsNonContainment constraint of '<em>Cross Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCrossReference_eReferenceIsNonContainment(CrossReference<?, ?, ?, ?> crossReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "eReferenceIsNonContainment", getObjectLabel(crossReference, context) },
						 new Object[] { crossReference },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateValuesMatchReferenceType constraint of '<em>Cross Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCrossReference_validateValuesMatchReferenceType(CrossReference<?, ?, ?, ?> crossReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return crossReference.validateValuesMatchReferenceType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttribute(Attribute<?, ?, ?, ?> attribute, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActualAttribute(ActualAttribute<?, ?, ?, ?> actualAttribute, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
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
		if (result || diagnostics != null) result &= validateActualAttribute_validateAttributeMatchesParentEClass(actualAttribute, diagnostics, context);
		return result;
	}

	/**
	 * Validates the attributeMatchesParentEClass constraint of '<em>Actual Attribute</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActualAttribute_attributeMatchesParentEClass(ActualAttribute<?, ?, ?, ?> actualAttribute,
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
						 new Object[] { "attributeMatchesParentEClass", getObjectLabel(actualAttribute, context) },
						 new Object[] { actualAttribute },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateAttributeMatchesParentEClass constraint of
	 * '<em>Actual Attribute</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	public boolean validateActualAttribute_validateAttributeMatchesParentEClass(
			ActualAttribute<?, ?, ?, ?> actualAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return actualAttribute.validateAttributeMatchesParentEClass(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVirtualAttribute(VirtualAttribute<?, ?, ?, ?> virtualAttribute, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(virtualAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityType(CardinalityType cardinalityType, DiagnosticChain diagnostics,
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

} // GenericValidator
