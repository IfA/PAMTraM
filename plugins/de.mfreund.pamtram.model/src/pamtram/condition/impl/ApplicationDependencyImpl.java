/**
 */
package pamtram.condition.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.ConditionalElement;

import pamtram.condition.ApplicationDependency;
import pamtram.condition.ConditionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.impl.ApplicationDependencyImpl#getConditionalElement <em>Conditional Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationDependencyImpl extends ConditionImpl implements ApplicationDependency {
	/**
	 * The cached value of the '{@link #getConditionalElement() <em>Conditional Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionalElement()
	 * @generated
	 * @ordered
	 */
	protected ConditionalElement conditionalElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.APPLICATION_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalElement getConditionalElement() {
		if (conditionalElement != null && conditionalElement.eIsProxy()) {
			InternalEObject oldConditionalElement = (InternalEObject)conditionalElement;
			conditionalElement = (ConditionalElement)eResolveProxy(oldConditionalElement);
			if (conditionalElement != oldConditionalElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConditionPackage.APPLICATION_DEPENDENCY__CONDITIONAL_ELEMENT, oldConditionalElement, conditionalElement));
			}
		}
		return conditionalElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalElement basicGetConditionalElement() {
		return conditionalElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionalElement(ConditionalElement newConditionalElement) {
		ConditionalElement oldConditionalElement = conditionalElement;
		conditionalElement = newConditionalElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.APPLICATION_DEPENDENCY__CONDITIONAL_ELEMENT, oldConditionalElement, conditionalElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConditionPackage.APPLICATION_DEPENDENCY__CONDITIONAL_ELEMENT:
				if (resolve) return getConditionalElement();
				return basicGetConditionalElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConditionPackage.APPLICATION_DEPENDENCY__CONDITIONAL_ELEMENT:
				setConditionalElement((ConditionalElement)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConditionPackage.APPLICATION_DEPENDENCY__CONDITIONAL_ELEMENT:
				setConditionalElement((ConditionalElement)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConditionPackage.APPLICATION_DEPENDENCY__CONDITIONAL_ELEMENT:
				return conditionalElement != null;
		}
		return super.eIsSet(featureID);
	}

} //ApplicationDependencyImpl
