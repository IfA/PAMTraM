/**
 */
package pamtram.mapping.modifier.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.impl.NamedElementImpl;
import pamtram.mapping.modifier.ModifierPackage;
import pamtram.mapping.modifier.ValueModifier;
import pamtram.mapping.modifier.ValueModifierSet;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Value Modifier Set</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.modifier.impl.ValueModifierSetImpl#getModifier <em>Modifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValueModifierSetImpl extends NamedElementImpl implements ValueModifierSet {

	/**
	 * The cached value of the '{@link #getModifiers() <em>Modifier</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueModifier> modifier;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueModifierSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.VALUE_MODIFIER_SET;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValueModifier> getModifiers() {
		if (modifier == null) {
			modifier = new EObjectContainmentEList<ValueModifier>(ValueModifier.class, this, ModifierPackage.VALUE_MODIFIER_SET__MODIFIERS);
		}
		return modifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModifierPackage.VALUE_MODIFIER_SET__MODIFIERS:
				return ((InternalEList<?>)getModifiers()).basicRemove(otherEnd, msgs);
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
			case ModifierPackage.VALUE_MODIFIER_SET__MODIFIERS:
				return getModifiers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> TODO update the name of the AttributeValueModifierSet based on the modifiers it contains
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModifierPackage.VALUE_MODIFIER_SET__MODIFIERS:
				getModifiers().clear();
				getModifiers().addAll((Collection<? extends ValueModifier>)newValue);
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
			case ModifierPackage.VALUE_MODIFIER_SET__MODIFIERS:
				getModifiers().clear();
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
			case ModifierPackage.VALUE_MODIFIER_SET__MODIFIERS:
				return modifier != null && !modifier.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // AttributeValueModifierSetImpl
