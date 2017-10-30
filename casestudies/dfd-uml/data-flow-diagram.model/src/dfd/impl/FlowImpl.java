/**
 */
package dfd.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import dfd.DFDElement;
import dfd.DfdPackage;
import dfd.Flow;
import dfd.util.DfdValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Flow</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dfd.impl.FlowImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link dfd.impl.FlowImpl#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FlowImpl extends NamedElementImpl implements Flow {

	/**
	 * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getIncoming()
	 * @generated
	 * @ordered
	 */
	protected DFDElement incoming;

	/**
	 * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getOutgoing()
	 * @generated
	 * @ordered
	 */
	protected DFDElement outgoing;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DfdPackage.Literals.FLOW;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DFDElement getIncoming() {
		if (incoming != null && incoming.eIsProxy()) {
			InternalEObject oldIncoming = (InternalEObject)incoming;
			incoming = (DFDElement)eResolveProxy(oldIncoming);
			if (incoming != oldIncoming) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.FLOW__INCOMING, oldIncoming, incoming));
			}
		}
		return incoming;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DFDElement basicGetIncoming() {
		return incoming;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIncoming(DFDElement newIncoming) {
		DFDElement oldIncoming = incoming;
		incoming = newIncoming;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.FLOW__INCOMING, oldIncoming, incoming));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DFDElement getOutgoing() {
		if (outgoing != null && outgoing.eIsProxy()) {
			InternalEObject oldOutgoing = (InternalEObject)outgoing;
			outgoing = (DFDElement)eResolveProxy(oldOutgoing);
			if (outgoing != oldOutgoing) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.FLOW__OUTGOING, oldOutgoing, outgoing));
			}
		}
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DFDElement basicGetOutgoing() {
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOutgoing(DFDElement newOutgoing) {
		DFDElement oldOutgoing = outgoing;
		outgoing = newOutgoing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.FLOW__OUTGOING, oldOutgoing, outgoing));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateIncomingPointsToElementOfSameSystem(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		boolean result = this.incoming == null || this.incoming.eContainer().equals(this.eContainer);
				
				if (!result && diagnostics != null) {
					
					String errorMessage = "The 'incoming' element is not part of the same (Sub-)System!";
				
					diagnostics.add(new BasicDiagnostic
							(Diagnostic.ERROR,
							DfdValidator.DIAGNOSTIC_SOURCE,
							DfdValidator.FLOW__VALIDATE_INCOMING_POINTS_TO_ELEMENT_OF_SAME_SYSTEM,
									errorMessage,
							new Object[] { this, DfdPackage.Literals.FLOW__INCOMING}));
				
				}
		
			return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateOutgoingPointsToElementOfSameSystem(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		boolean result = this.outgoing == null || this.outgoing.eContainer().equals(this.eContainer);
		
			if (!result && diagnostics != null) {
		
				String errorMessage = "The 'outgoing' element of this structuredAnalysis.Flow is not part of the same (Sub-)System as this Flow!";
		
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DfdValidator.DIAGNOSTIC_SOURCE,
							DfdValidator.FLOW__VALIDATE_OUTGOING_POINTS_TO_ELEMENT_OF_SAME_SYSTEM, errorMessage,
							new Object[] { this, DfdPackage.Literals.FLOW__OUTGOING }));
		
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
			case DfdPackage.FLOW__INCOMING:
				if (resolve) return getIncoming();
				return basicGetIncoming();
			case DfdPackage.FLOW__OUTGOING:
				if (resolve) return getOutgoing();
				return basicGetOutgoing();
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
			case DfdPackage.FLOW__INCOMING:
				setIncoming((DFDElement)newValue);
				return;
			case DfdPackage.FLOW__OUTGOING:
				setOutgoing((DFDElement)newValue);
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
			case DfdPackage.FLOW__INCOMING:
				setIncoming((DFDElement)null);
				return;
			case DfdPackage.FLOW__OUTGOING:
				setOutgoing((DFDElement)null);
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
			case DfdPackage.FLOW__INCOMING:
				return incoming != null;
			case DfdPackage.FLOW__OUTGOING:
				return outgoing != null;
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
			case DfdPackage.FLOW___VALIDATE_INCOMING_POINTS_TO_ELEMENT_OF_SAME_SYSTEM__DIAGNOSTICCHAIN_MAP:
				return validateIncomingPointsToElementOfSameSystem((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case DfdPackage.FLOW___VALIDATE_OUTGOING_POINTS_TO_ELEMENT_OF_SAME_SYSTEM__DIAGNOSTICCHAIN_MAP:
				return validateOutgoingPointsToElementOfSameSystem((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // FlowImpl
