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
import pamtram.mapping.MappingPackage;
import pamtram.mapping.modifier.ValueModifier;
import pamtram.mapping.modifier.ValueModifierSet;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Value Modifier Set</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.mapping.modifier.impl.ValueModifierSetImpl#getModifier <em>Modifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValueModifierSetImpl extends NamedElementImpl implements ValueModifierSet {

	/**
	 * The cached value of the '{@link #getModifier() <em>Modifier</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModifier()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueModifier> modifier;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ValueModifierSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return MappingPackage.Literals.VALUE_MODIFIER_SET;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<ValueModifier> getModifier() {

		if (this.modifier == null) {
			this.modifier = new EObjectContainmentEList<>(ValueModifier.class, this,
					MappingPackage.VALUE_MODIFIER_SET__MODIFIER);
		}
		return this.modifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {

		switch (featureID) {
			case MappingPackage.VALUE_MODIFIER_SET__MODIFIER:
				return ((InternalEList<?>) this.getModifier()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case MappingPackage.VALUE_MODIFIER_SET__MODIFIER:
				return this.getModifier();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> TODO update the name of the AttributeValueModifierSet based on the modifiers it contains
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void eSet(int featureID, Object newValue) {

		switch (featureID) {
			case MappingPackage.VALUE_MODIFIER_SET__MODIFIER:
				this.getModifier().clear();
				this.getModifier().addAll((Collection<? extends ValueModifier>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {

		switch (featureID) {
			case MappingPackage.VALUE_MODIFIER_SET__MODIFIER:
				this.getModifier().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {

		switch (featureID) {
			case MappingPackage.VALUE_MODIFIER_SET__MODIFIER:
				return this.modifier != null && !this.modifier.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // AttributeValueModifierSetImpl
