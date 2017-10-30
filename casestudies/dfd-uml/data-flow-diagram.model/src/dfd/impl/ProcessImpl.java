/**
 */
package dfd.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import dfd.DFD;
import dfd.DFDElement;
import dfd.DfdPackage;
import dfd.Flow;
import dfd.util.DfdValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Process</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dfd.impl.ProcessImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link dfd.impl.ProcessImpl#getFlows <em>Flows</em>}</li>
 *   <li>{@link dfd.impl.ProcessImpl#getNumber <em>Number</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessImpl extends DFDElementImpl implements dfd.Process {

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<DFDElement> elements;

	/**
	 * The cached value of the '{@link #getFlows() <em>Flows</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<Flow> flows;

	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected String number = NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DfdPackage.Literals.PROCESS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DFDElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<DFDElement>(DFDElement.class, this, DfdPackage.PROCESS__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Flow> getFlows() {
		if (flows == null) {
			flows = new EObjectContainmentEList<Flow>(Flow.class, this, DfdPackage.PROCESS__FLOWS);
		}
		return flows;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumber(String newNumber) {
		String oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.PROCESS__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNumberFormatIsCorrect(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		boolean result = this.number == null || this.number.matches("[0-9]+(\\.[0-9]+)*");
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The number is not formatted correctly! Valid numbers are e.g. '1', '1.10', or '1.10.8'...";
		
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DfdValidator.DIAGNOSTIC_SOURCE,
					DfdValidator.PROCESS__VALIDATE_NUMBER_FORMAT_IS_CORRECT, errorMessage,
					new Object[] { this, DfdPackage.Literals.PROCESS__NUMBER }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DfdPackage.PROCESS__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
			case DfdPackage.PROCESS__FLOWS:
				return ((InternalEList<?>)getFlows()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DfdPackage.PROCESS__ELEMENTS:
				return getElements();
			case DfdPackage.PROCESS__FLOWS:
				return getFlows();
			case DfdPackage.PROCESS__NUMBER:
				return getNumber();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DfdPackage.PROCESS__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends DFDElement>)newValue);
				return;
			case DfdPackage.PROCESS__FLOWS:
				getFlows().clear();
				getFlows().addAll((Collection<? extends Flow>)newValue);
				return;
			case DfdPackage.PROCESS__NUMBER:
				setNumber((String)newValue);
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
			case DfdPackage.PROCESS__ELEMENTS:
				getElements().clear();
				return;
			case DfdPackage.PROCESS__FLOWS:
				getFlows().clear();
				return;
			case DfdPackage.PROCESS__NUMBER:
				setNumber(NUMBER_EDEFAULT);
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
			case DfdPackage.PROCESS__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case DfdPackage.PROCESS__FLOWS:
				return flows != null && !flows.isEmpty();
			case DfdPackage.PROCESS__NUMBER:
				return NUMBER_EDEFAULT == null ? number != null : !NUMBER_EDEFAULT.equals(number);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DFD.class) {
			switch (derivedFeatureID) {
				case DfdPackage.PROCESS__ELEMENTS: return DfdPackage.DFD__ELEMENTS;
				case DfdPackage.PROCESS__FLOWS: return DfdPackage.DFD__FLOWS;
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
		if (baseClass == DFD.class) {
			switch (baseFeatureID) {
				case DfdPackage.DFD__ELEMENTS: return DfdPackage.PROCESS__ELEMENTS;
				case DfdPackage.DFD__FLOWS: return DfdPackage.PROCESS__FLOWS;
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
			case DfdPackage.PROCESS___VALIDATE_NUMBER_FORMAT_IS_CORRECT__DIAGNOSTICCHAIN_MAP:
				return validateNumberFormatIsCorrect((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
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
		result.append(" (number: ");
		result.append(number);
		result.append(')');
		return result.toString();
	}

} // ProcessImpl
