/**
 */
package pamtram.structure.target.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.structure.generic.impl.CrossReferenceImpl;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAnyContentCrossReference;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionReference;
import pamtram.structure.target.util.TargetValidator;
import pamtram.util.ExtendedMetaDataUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Section Any Content Cross Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TargetSectionAnyContentCrossReferenceImpl
		extends CrossReferenceImpl<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute>
		implements TargetSectionAnyContentCrossReference {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected TargetSectionAnyContentCrossReferenceImpl() {

		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return TargetPackage.Literals.TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific element type known in
	 * this context.
	 *
	 * @generated
	 */
	@Override
	public EList<TargetSectionClass> getValue() {

		if (this.value == null) {
			this.value = new EObjectResolvingEList<>(TargetSectionClass.class, this,
					TargetPackage.TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE__VALUE);
		}
		return this.value;
	}

	@Override
	public EList<TargetSectionClass> getValuesGeneric() {

		return this.getValue();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean validateIsAllowed(final DiagnosticChain diagnostics, final Map<?, ?> context) {

		if (!(this.eContainer() instanceof pamtram.structure.generic.Class)) {
			return true;
		}

		EClass parentEClass = ((pamtram.structure.generic.Class<?, ?, ?, ?>) this.eContainer()).getEClass();

		boolean result = parentEClass == null ? true : ExtendedMetaDataUtil.allowsAnyContent(parentEClass);

		if (!result && diagnostics != null) {

			String errorMessage = "The containing Class does not allow 'any' content!";

			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, TargetValidator.DIAGNOSTIC_SOURCE,
					TargetValidator.TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE__VALIDATE_IS_ALLOWED, errorMessage,
					new Object[] { this, TargetPackage.Literals.TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE }));

		}

		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {

		switch (operationID) {
			case TargetPackage.TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE___VALIDATE_IS_ALLOWED__DIAGNOSTICCHAIN_MAP:
				return this.validateIsAllowed((DiagnosticChain) arguments.get(0), (Map<?, ?>) arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // TargetSectionAnyContentCrossReferenceImpl
