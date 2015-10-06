/**
 */
package pamtram.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.xtext.oclinecore.validation.OCLinEcoreEObjectValidator;

import pamtram.DeactivatableElement;
import pamtram.MappingModel;
import pamtram.NamedElement;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.SectionModel;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.TransformationModel;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see pamtram.PamtramPackage
 * @generated NOT
 */
public class PamtramValidator extends OCLinEcoreEObjectValidator {
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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Source Section Models Have Same EPackage' of 'PAM Tra M'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PAM_TRA_M__SOURCE_SECTION_MODELS_HAVE_SAME_EPACKAGE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Target Section Models Have Same EPackage' of 'PAM Tra M'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PAM_TRA_M__TARGET_SECTION_MODELS_HAVE_SAME_EPACKAGE = 2;

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
		case PamtramPackage.TRANSFORMATION_MODEL:
			return validateTransformationModel((TransformationModel)value, diagnostics, context);
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
		if (!validate_NoCircularContainment(pamTraM, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(pamTraM, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(pamTraM, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(pamTraM, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(pamTraM, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(pamTraM, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(pamTraM, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(pamTraM, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(pamTraM, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePAMTraM_sourceSectionModelsHaveSameEPackage(pamTraM, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validatePAMTraM_targetSectionModelsHaveSameEPackage(pamTraM, diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the sourceSectionModelsHaveSameEPackage constraint of '<em>PAM Tra M</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePAMTraM_sourceSectionModelsHaveSameEPackage(PAMTraM pamTraM, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return pamTraM.sourceSectionModelsHaveSameEPackage(diagnostics, context);
	}

	/**
	 * Validates the targetSectionModelsHaveSameEPackage constraint of '<em>PAM Tra M</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePAMTraM_targetSectionModelsHaveSameEPackage(PAMTraM pamTraM, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return pamTraM.targetSectionModelsHaveSameEPackage(diagnostics, context);
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
		return validate_EveryDefaultConstraint(mappingModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransformationModel(TransformationModel transformationModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(transformationModel, diagnostics, context);
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
