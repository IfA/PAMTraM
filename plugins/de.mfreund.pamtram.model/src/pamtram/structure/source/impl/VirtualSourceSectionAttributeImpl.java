/**
 */
package pamtram.structure.source.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.ParserException;

import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.VirtualSourceSectionAttribute;
import pamtram.structure.source.util.SourceValidator;
import pamtram.util.OCLUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Virtual
 * Source Section Attribute</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.impl.VirtualSourceSectionAttributeImpl#getDerivation <em>Derivation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VirtualSourceSectionAttributeImpl extends SourceSectionAttributeImpl
		implements VirtualSourceSectionAttribute {
	/**
	 * The default value of the '{@link #getDerivation() <em>Derivation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDerivation()
	 * @generated
	 * @ordered
	 */
	protected static final String DERIVATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDerivation() <em>Derivation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDerivation()
	 * @generated
	 * @ordered
	 */
	protected String derivation = DERIVATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualSourceSectionAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcePackage.Literals.VIRTUAL_SOURCE_SECTION_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDerivation() {
	
		return derivation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDerivation(String newDerivation) {
	
		String oldDerivation = derivation;
		derivation = newDerivation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SourcePackage.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__DERIVATION, oldDerivation, derivation));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateDerivation(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if (this.getDerivation() == null || this.getDerivation().isEmpty()
				|| !(this.eContainer() instanceof SourceSectionClass)
				|| ((SourceSectionClass) this.eContainer()).getEClass() == null) {
			return true;
		}
		
		boolean result = true;
		String parserException = "";
		
		try {
			OCLUtil.validateQuery(this.getDerivation(), ((SourceSectionClass) this.eContainer()).getEClass());
		} catch (ParserException e) {
			result = false;
			parserException = e.getMessage();
			e.printStackTrace();
		}
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The specified derivation is not valid! The following error was provided: " + parserException;
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					SourceValidator.DIAGNOSTIC_SOURCE,
							SourceValidator.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__VALIDATE_DERIVATION,
							errorMessage,
					new Object[] { this, SourcePackage.Literals.VIRTUAL_SOURCE_SECTION_ATTRIBUTE }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SourcePackage.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__DERIVATION:
				return getDerivation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SourcePackage.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__DERIVATION:
				setDerivation((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SourcePackage.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__DERIVATION:
				setDerivation(DERIVATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SourcePackage.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__DERIVATION:
				return DERIVATION_EDEFAULT == null ? derivation != null : !DERIVATION_EDEFAULT.equals(derivation);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SourcePackage.VIRTUAL_SOURCE_SECTION_ATTRIBUTE___VALIDATE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return validateDerivation((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (derivation: ");
		result.append(derivation);
		result.append(')');
		return result.toString();
	}

} // VirtualSourceSectionAttributeImpl
