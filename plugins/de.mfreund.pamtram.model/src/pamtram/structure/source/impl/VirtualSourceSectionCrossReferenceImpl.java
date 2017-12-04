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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.ocl.ParserException;

import pamtram.structure.generic.VirtualReference;
import pamtram.structure.generic.impl.CrossReferenceImpl;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;
import pamtram.structure.source.VirtualSourceSectionCrossReference;
import pamtram.structure.source.util.SourceValidator;
import pamtram.util.OCLUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Virtual
 * Source Section Cross Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.impl.VirtualSourceSectionCrossReferenceImpl#isIgnoreUnmatchedElements <em>Ignore Unmatched Elements</em>}</li>
 *   <li>{@link pamtram.structure.source.impl.VirtualSourceSectionCrossReferenceImpl#getDerivation <em>Derivation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VirtualSourceSectionCrossReferenceImpl
		extends CrossReferenceImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements VirtualSourceSectionCrossReference {
	/**
	 * The default value of the '{@link #isIgnoreUnmatchedElements() <em>Ignore Unmatched Elements</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isIgnoreUnmatchedElements()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IGNORE_UNMATCHED_ELEMENTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIgnoreUnmatchedElements() <em>Ignore Unmatched Elements</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isIgnoreUnmatchedElements()
	 * @generated
	 * @ordered
	 */
	protected boolean ignoreUnmatchedElements = IGNORE_UNMATCHED_ELEMENTS_EDEFAULT;

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
	protected VirtualSourceSectionCrossReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcePackage.Literals.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the
	 * more specific element type known in this context.
	 * 
	 * @generated
	 */
	@Override
	public EList<SourceSectionClass> getValue() {
		if (value == null) {
			value = new EObjectResolvingEList<SourceSectionClass>(SourceSectionClass.class, this, SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIgnoreUnmatchedElements() {
	
		return ignoreUnmatchedElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIgnoreUnmatchedElements(boolean newIgnoreUnmatchedElements) {
	
		boolean oldIgnoreUnmatchedElements = ignoreUnmatchedElements;
		ignoreUnmatchedElements = newIgnoreUnmatchedElements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS, oldIgnoreUnmatchedElements, ignoreUnmatchedElements));
	
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
			eNotify(new ENotificationImpl(this, Notification.SET, SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__DERIVATION, oldDerivation, derivation));
	
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
							SourceValidator.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__VALIDATE_DERIVATION,
							errorMessage,
					new Object[] { this, SourcePackage.Literals.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE }));
		
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
			case SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				return isIgnoreUnmatchedElements();
			case SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__DERIVATION:
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
			case SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				setIgnoreUnmatchedElements((Boolean)newValue);
				return;
			case SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__DERIVATION:
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
			case SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				setIgnoreUnmatchedElements(IGNORE_UNMATCHED_ELEMENTS_EDEFAULT);
				return;
			case SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__DERIVATION:
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
			case SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				return ignoreUnmatchedElements != IGNORE_UNMATCHED_ELEMENTS_EDEFAULT;
			case SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__DERIVATION:
				return DERIVATION_EDEFAULT == null ? derivation != null : !DERIVATION_EDEFAULT.equals(derivation);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == SourceSectionReference.class) {
			switch (derivedFeatureID) {
				case SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS: return SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS;
				default: return -1;
			}
		}
		if (baseClass == VirtualReference.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == SourceSectionReference.class) {
			switch (baseFeatureID) {
				case SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS: return SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS;
				default: return -1;
			}
		}
		if (baseClass == VirtualReference.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE___VALIDATE_DERIVATION__DIAGNOSTICCHAIN_MAP:
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
		result.append(" (ignoreUnmatchedElements: ");
		result.append(ignoreUnmatchedElements);
		result.append(", derivation: ");
		result.append(derivation);
		result.append(')');
		return result.toString();
	}

	@Override
	public EList<SourceSectionClass> getValuesGeneric() {

		return this.getValue();
	}

} // VirtualSourceSectionCrossReferenceImpl
