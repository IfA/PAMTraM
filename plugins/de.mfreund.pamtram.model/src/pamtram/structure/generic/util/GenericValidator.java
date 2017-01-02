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
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.CardinalityType;
import pamtram.structure.generic.ContainmentReference;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.generic.VirtualAttribute;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc
 * -->
 *
 * @see pamtram.structure.generic.GenericPackage
 * @generated
 */
public class GenericValidator extends EObjectValidator {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final GenericValidator INSTANCE = new GenericValidator();

	/**
	 * A constant for the
	 * {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of
	 * diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes}
	 * from this package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for
	 * constraint 'Validate Container Is Valid' of 'Class'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int CLASS__VALIDATE_CONTAINER_IS_VALID = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for
	 * constraint 'Validate Container Matches Extend Container' of 'Section'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int SECTION__VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for
	 * constraint 'Validate Extends Valid Sections' of 'Section'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int SECTION__VALIDATE_EXTENDS_VALID_SECTIONS = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for
	 * constraint 'Validate EReference Matches Parent EClass' of 'Reference'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int REFERENCE__VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for
	 * constraint 'Validate EReference Is Containment' of 'Containment
	 * Reference'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int CONTAINMENT_REFERENCE__VALIDATE_EREFERENCE_IS_CONTAINMENT = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for
	 * constraint 'Validate EReference Is Non Containment' of 'Non Containment
	 * Reference'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int NON_CONTAINMENT_REFERENCE__VALIDATE_EREFERENCE_IS_NON_CONTAINMENT = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for
	 * constraint 'Validate Attribute Matches Parent EClass' of 'Actual
	 * Attribute'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int ACTUAL_ATTRIBUTE__VALIDATE_ATTRIBUTE_MATCHES_PARENT_ECLASS = 9;

	/**
	 * A constant with a fixed name that can be used as the base value for
	 * additional hand written constants. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 9;

	/**
	 * A constant with a fixed name that can be used as the base value for
	 * additional hand written constants in a derived class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GenericValidator.GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	public GenericValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return GenericPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the
	 * model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		switch (classifierID) {
		case GenericPackage.META_MODEL_ELEMENT:
			return this.validateMetaModelElement((MetaModelElement<?, ?, ?, ?>) value, diagnostics, context);
		case GenericPackage.CLASS:
			return this.validateClass((pamtram.structure.generic.Class<?, ?, ?, ?>) value, diagnostics, context);
		case GenericPackage.SECTION:
			return this.validateSection((Section<?, ?, ?, ?>) value, diagnostics, context);
		case GenericPackage.REFERENCE:
			return this.validateReference((Reference<?, ?, ?, ?>) value, diagnostics, context);
		case GenericPackage.CONTAINMENT_REFERENCE:
			return this.validateContainmentReference((ContainmentReference<?, ?, ?, ?>) value, diagnostics, context);
		case GenericPackage.CROSS_REFERENCE:
			return this.validateNonContainmentReference((CrossReference<?, ?, ?, ?>) value, diagnostics, context);
		case GenericPackage.ATTRIBUTE:
			return this.validateAttribute((Attribute<?, ?, ?, ?>) value, diagnostics, context);
		case GenericPackage.ACTUAL_ATTRIBUTE:
			return this.validateActualAttribute((ActualAttribute<?, ?, ?, ?>) value, diagnostics, context);
		case GenericPackage.VIRTUAL_ATTRIBUTE:
			return this.validateVirtualAttribute((VirtualAttribute<?, ?, ?, ?>) value, diagnostics, context);
		case GenericPackage.CARDINALITY_TYPE:
			return this.validateCardinalityType((CardinalityType) value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateMetaModelElement(MetaModelElement<?, ?, ?, ?> metaModelElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(metaModelElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateClass(pamtram.structure.generic.Class<?, ?, ?, ?> class_, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(class_, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(class_, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(class_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(class_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(class_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(class_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(class_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(class_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(class_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateClass_eClassMatchesParentEReference(class_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateClass_variableCardinalityIsValid(class_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateClass_containerIsValid(class_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateClass_validateEClassMatchesParentEReference(class_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateClass_validateCardinalityIsValid(class_, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateClass_validateContainerIsValid(class_, diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the eClassMatchesParentEReference constraint of
	 * '<em>Class</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateClass_eClassMatchesParentEReference(pamtram.structure.generic.Class<?, ?, ?, ?> class_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and
		// message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add(this.createDiagnostic(Diagnostic.ERROR,
						GenericValidator.DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", new Object[] {
								"eClassMatchesParentEReference", EObjectValidator.getObjectLabel(class_, context) },
						new Object[] { class_ }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the variableCardinalityIsValid constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateClass_variableCardinalityIsValid(pamtram.structure.generic.Class<?, ?, ?, ?> class_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and
		// message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add(this.createDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE, 0,
						"_UI_GenericConstraint_diagnostic",
						new Object[] { "variableCardinalityIsValid", EObjectValidator.getObjectLabel(class_, context) },
						new Object[] { class_ }, context));
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
		// -> verify the diagnostic details, including severity, code, and
		// message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add(this.createDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE, 0,
						"_UI_GenericConstraint_diagnostic",
						new Object[] { "containerIsValid", EObjectValidator.getObjectLabel(class_, context) },
						new Object[] { class_ }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateEClassMatchesParentEReference constraint of
	 * '<em>Class</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
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
	 *
	 * @generated
	 */
	public boolean validateClass_validateCardinalityIsValid(pamtram.structure.generic.Class<?, ?, ?, ?> class_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return class_.validateCardinalityIsValid(diagnostics, context);
	}

	/**
	 * Validates the validateContainerIsValid constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateClass_validateContainerIsValid(pamtram.structure.generic.Class<?, ?, ?, ?> class_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return class_.validateContainerIsValid(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateSection(Section<?, ?, ?, ?> section, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(section, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(section, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateClass_eClassMatchesParentEReference(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateClass_variableCardinalityIsValid(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateClass_containerIsValid(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateClass_validateEClassMatchesParentEReference(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateClass_validateCardinalityIsValid(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateClass_validateContainerIsValid(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateSection_extendsValidSections(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateSection_containerMatchesExtendContainer(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateSection_validateContainerMatchesExtendContainer(section, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateSection_validateExtendsValidSections(section, diagnostics, context);
		}
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
		// -> verify the diagnostic details, including severity, code, and
		// message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add(this.createDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE, 0,
						"_UI_GenericConstraint_diagnostic",
						new Object[] { "extendsValidSections", EObjectValidator.getObjectLabel(section, context) },
						new Object[] { section }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the containerMatchesExtendContainer constraint of
	 * '<em>Section</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateSection_containerMatchesExtendContainer(Section<?, ?, ?, ?> section,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and
		// message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add(this.createDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE, 0,
						"_UI_GenericConstraint_diagnostic",
						new Object[] { "containerMatchesExtendContainer",
								EObjectValidator.getObjectLabel(section, context) },
						new Object[] { section }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateContainerMatchesExtendContainer constraint of
	 * '<em>Section</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateSection_validateContainerMatchesExtendContainer(Section<?, ?, ?, ?> section,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return section.validateContainerMatchesExtendContainer(diagnostics, context);
	}

	/**
	 * Validates the validateExtendsValidSections constraint of
	 * '<em>Section</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateSection_validateExtendsValidSections(Section<?, ?, ?, ?> section,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return section.validateExtendsValidSections(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateReference(Reference<?, ?, ?, ?> reference, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(reference, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(reference, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(reference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(reference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(reference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(reference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(reference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(reference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(reference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateReference_eReferenceMatchesParentEClass(reference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateReference_validateEReferenceMatchesParentEClass(reference, diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the eReferenceMatchesParentEClass constraint of
	 * '<em>Reference</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateReference_eReferenceMatchesParentEClass(Reference<?, ?, ?, ?> reference,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and
		// message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add(this.createDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE, 0,
						"_UI_GenericConstraint_diagnostic",
						new Object[] { "eReferenceMatchesParentEClass",
								EObjectValidator.getObjectLabel(reference, context) },
						new Object[] { reference }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateEReferenceMatchesParentEClass constraint of
	 * '<em>Reference</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateReference_validateEReferenceMatchesParentEClass(Reference<?, ?, ?, ?> reference,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return reference.validateEReferenceMatchesParentEClass(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateContainmentReference(ContainmentReference<?, ?, ?, ?> containmentReference,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(containmentReference, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(containmentReference, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(containmentReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(containmentReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(containmentReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(containmentReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(containmentReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(containmentReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(containmentReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateReference_eReferenceMatchesParentEClass(containmentReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateReference_validateEReferenceMatchesParentEClass(containmentReference, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= this.validateContainmentReference_eReferenceIsContainment(containmentReference, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= this.validateContainmentReference_validateEReferenceIsContainment(containmentReference,
					diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the eReferenceIsContainment constraint of '<em>Containment
	 * Reference</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateContainmentReference_eReferenceIsContainment(
			ContainmentReference<?, ?, ?, ?> containmentReference, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and
		// message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add(this.createDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE, 0,
						"_UI_GenericConstraint_diagnostic",
						new Object[] { "eReferenceIsContainment",
								EObjectValidator.getObjectLabel(containmentReference, context) },
						new Object[] { containmentReference }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateEReferenceIsContainment constraint of
	 * '<em>Containment Reference</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateContainmentReference_validateEReferenceIsContainment(
			ContainmentReference<?, ?, ?, ?> containmentReference, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return containmentReference.validateEReferenceIsContainment(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateNonContainmentReference(CrossReference<?, ?, ?, ?> nonContainmentReference,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(nonContainmentReference, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(nonContainmentReference, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(nonContainmentReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(nonContainmentReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(nonContainmentReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(nonContainmentReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(nonContainmentReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(nonContainmentReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(nonContainmentReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateReference_eReferenceMatchesParentEClass(nonContainmentReference, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= this.validateReference_validateEReferenceMatchesParentEClass(nonContainmentReference, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= this.validateNonContainmentReference_eReferenceIsNonContainment(nonContainmentReference,
					diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the eReferenceIsNonContainment constraint of '<em>Non
	 * Containment Reference</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	public boolean validateNonContainmentReference_eReferenceIsNonContainment(
			CrossReference<?, ?, ?, ?> nonContainmentReference, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and
		// message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add(this.createDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE, 0,
						"_UI_GenericConstraint_diagnostic",
						new Object[] { "eReferenceIsNonContainment",
								EObjectValidator.getObjectLabel(nonContainmentReference, context) },
						new Object[] { nonContainmentReference }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateAttribute(Attribute<?, ?, ?, ?> attribute, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(attribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateActualAttribute(ActualAttribute<?, ?, ?, ?> actualAttribute, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!this.validate_NoCircularContainment(actualAttribute, diagnostics, context)) {
			return false;
		}
		boolean result = this.validate_EveryMultiplicityConforms(actualAttribute, diagnostics, context);
		if (result || diagnostics != null) {
			result &= this.validate_EveryDataValueConforms(actualAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryReferenceIsContained(actualAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryBidirectionalReferenceIsPaired(actualAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryProxyResolves(actualAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_UniqueID(actualAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryKeyUnique(actualAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validate_EveryMapEntryUnique(actualAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateActualAttribute_attributeMatchesParentEClass(actualAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= this.validateActualAttribute_validateAttributeMatchesParentEClass(actualAttribute, diagnostics,
					context);
		}
		return result;
	}

	/**
	 * Validates the attributeMatchesParentEClass constraint of '<em>Actual
	 * Attribute</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateActualAttribute_attributeMatchesParentEClass(ActualAttribute<?, ?, ?, ?> actualAttribute,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and
		// message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add(this.createDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE, 0,
						"_UI_GenericConstraint_diagnostic",
						new Object[] { "attributeMatchesParentEClass",
								EObjectValidator.getObjectLabel(actualAttribute, context) },
						new Object[] { actualAttribute }, context));
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
	 *
	 * @generated
	 */
	public boolean validateVirtualAttribute(VirtualAttribute<?, ?, ?, ?> virtualAttribute, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return this.validate_EveryDefaultConstraint(virtualAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateCardinalityType(CardinalityType cardinalityType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this
	 * validator's diagnostics. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to
		// this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} // GenericValidator
