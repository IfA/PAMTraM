/**
 */
package pamtram.structure.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import pamtram.structure.GlobalModifiedAttributeElementType;
import pamtram.structure.InstanceSelector;
import pamtram.structure.StructurePackage;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.impl.GlobalModifiedAttributeElementTypeImpl#getInstanceSelector <em>Instance Selector</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GlobalModifiedAttributeElementTypeImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ModifiedAttributeElementTypeImpl<S, C, R, A> implements GlobalModifiedAttributeElementType<S, C, R, A> {
	/**
	 * The cached value of the '{@link #getInstanceSelectors() <em>Instance Selector</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceSelectors()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceSelector> instanceSelector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalModifiedAttributeElementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstanceSelector> getInstanceSelectors() {
		if (instanceSelector == null) {
			instanceSelector = new EObjectContainmentEList<InstanceSelector>(InstanceSelector.class, this, StructurePackage.GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__INSTANCE_SELECTORS);
		}
		return instanceSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StructurePackage.GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__INSTANCE_SELECTORS:
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
			case StructurePackage.GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__INSTANCE_SELECTORS:
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
			case StructurePackage.GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__INSTANCE_SELECTORS:
				getInstanceSelectors().clear();
				getInstanceSelectors().addAll((Collection<? extends InstanceSelector>)newValue);
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
			case StructurePackage.GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__INSTANCE_SELECTORS:
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
			case StructurePackage.GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__INSTANCE_SELECTORS:
				return instanceSelector != null && !instanceSelector.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GlobalModifiedAttributeElementTypeImpl
