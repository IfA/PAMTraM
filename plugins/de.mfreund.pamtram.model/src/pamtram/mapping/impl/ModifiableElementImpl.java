/**
 */
package pamtram.mapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.mapping.MappingPackage;
import pamtram.mapping.ModifiableElement;
import pamtram.mapping.modifier.ValueModifierSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modifiable Hint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.ModifiableElementImpl#getResultModifier <em>Result Modifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ModifiableElementImpl extends MinimalEObjectImpl.Container implements ModifiableElement {
	/**
	 * The cached value of the '{@link #getResultModifier() <em>Result Modifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultModifier()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueModifierSet> resultModifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifiableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MODIFIABLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValueModifierSet> getResultModifier() {
		if (resultModifier == null) {
			resultModifier = new EObjectResolvingEList<ValueModifierSet>(ValueModifierSet.class, this, MappingPackage.MODIFIABLE_ELEMENT__RESULT_MODIFIER);
		}
		return resultModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.MODIFIABLE_ELEMENT__RESULT_MODIFIER:
				return getResultModifier();
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
			case MappingPackage.MODIFIABLE_ELEMENT__RESULT_MODIFIER:
				getResultModifier().clear();
				getResultModifier().addAll((Collection<? extends ValueModifierSet>)newValue);
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
			case MappingPackage.MODIFIABLE_ELEMENT__RESULT_MODIFIER:
				getResultModifier().clear();
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
			case MappingPackage.MODIFIABLE_ELEMENT__RESULT_MODIFIER:
				return resultModifier != null && !resultModifier.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModifiableElementImpl
