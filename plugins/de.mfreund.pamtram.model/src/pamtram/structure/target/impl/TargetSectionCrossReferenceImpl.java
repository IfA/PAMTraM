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

import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.impl.CrossReferenceImpl;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCrossReference;
import pamtram.structure.target.TargetSectionReference;
import pamtram.structure.target.util.TargetValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Target Section Non Containment
 * Reference</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class TargetSectionCrossReferenceImpl
		extends CrossReferenceImpl<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute>
		implements TargetSectionCrossReference {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionCrossReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPackage.Literals.TARGET_SECTION_CROSS_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific element type known in
	 * this context.
	 *
	 * @generated
	 */
	@Override
	public EList<TargetSectionClass> getValue() {
		if (value == null) {
			value = new EObjectResolvingEList<TargetSectionClass>(TargetSectionClass.class, this, TargetPackage.TARGET_SECTION_CROSS_REFERENCE__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateEReferenceIsNonContainment(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = this.getEReference() == null ? true : !this.getEReference().isContainment();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The eReference '" + this.getEReference().getName() + "' is no non-containment reference! CrossReferences based on ContainmentReferences are not yet supported...";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					TargetValidator.DIAGNOSTIC_SOURCE,
							TargetValidator.TARGET_SECTION_CROSS_REFERENCE__VALIDATE_EREFERENCE_IS_NON_CONTAINMENT,
							errorMessage,
					new Object[] { this, GenericPackage.Literals.REFERENCE__EREFERENCE }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TargetPackage.TARGET_SECTION_CROSS_REFERENCE___VALIDATE_EREFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP:
				return validateEReferenceIsNonContainment((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public void addValuesGeneric(EList<TargetSectionClass> values) {

		this.getValue().addAll(values);

	}

	@Override
	public EList<TargetSectionClass> getValuesGeneric() {

		return this.getValue();
	}

} // TargetSectionNonContainmentReferenceImpl
