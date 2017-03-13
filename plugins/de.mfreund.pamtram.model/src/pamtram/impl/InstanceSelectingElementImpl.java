/**
 */
package pamtram.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.InstanceSelectingElement;
import pamtram.PamtramPackage;
import pamtram.structure.SourceInstanceSelector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Selecting Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.impl.InstanceSelectingElementImpl#getInstanceSelectors <em>Instance Selectors</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class InstanceSelectingElementImpl extends MinimalEObjectImpl.Container implements InstanceSelectingElement {
	/**
	 * The cached value of the '{@link #getInstanceSelectors() <em>Instance Selectors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceSelectors()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceInstanceSelector> instanceSelectors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceSelectingElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PamtramPackage.Literals.INSTANCE_SELECTING_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceInstanceSelector> getInstanceSelectors() {
		if (instanceSelectors == null) {
			instanceSelectors = new EObjectContainmentEList<SourceInstanceSelector>(SourceInstanceSelector.class, this, PamtramPackage.INSTANCE_SELECTING_ELEMENT__INSTANCE_SELECTORS);
		}
		return instanceSelectors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PamtramPackage.INSTANCE_SELECTING_ELEMENT__INSTANCE_SELECTORS:
				return ((InternalEList<?>)getInstanceSelectors()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PamtramPackage.INSTANCE_SELECTING_ELEMENT__INSTANCE_SELECTORS:
				return getInstanceSelectors();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PamtramPackage.INSTANCE_SELECTING_ELEMENT__INSTANCE_SELECTORS:
				getInstanceSelectors().clear();
				getInstanceSelectors().addAll((Collection<? extends SourceInstanceSelector>)newValue);
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
			case PamtramPackage.INSTANCE_SELECTING_ELEMENT__INSTANCE_SELECTORS:
				getInstanceSelectors().clear();
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
			case PamtramPackage.INSTANCE_SELECTING_ELEMENT__INSTANCE_SELECTORS:
				return instanceSelectors != null && !instanceSelectors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InstanceSelectingElementImpl
