/**
 */
package pamtram.structure.generic.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Non
 * Containment Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.generic.impl.CrossReferenceImpl#getValue
 * <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CrossReferenceImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends ReferenceImpl<S, C, R, A> implements CrossReference<S, C, R, A> {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<C> value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected CrossReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericPackage.Literals.NON_CONTAINMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<C> getValue() {
		if (this.value == null) {
			this.value = new EObjectResolvingEList<>(pamtram.structure.generic.Class.class, this,
					GenericPackage.CROSS_REFERENCE__VALUE);
		}
		return this.value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case GenericPackage.CROSS_REFERENCE__VALUE:
			return this.getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case GenericPackage.CROSS_REFERENCE__VALUE:
			this.getValue().clear();
			this.getValue().addAll((Collection<? extends C>) newValue);
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
		case GenericPackage.CROSS_REFERENCE__VALUE:
			this.getValue().clear();
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
		case GenericPackage.CROSS_REFERENCE__VALUE:
			return this.value != null && !this.value.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		return super.eInvoke(operationID, arguments);
	}

} // NonContainmentReferenceImpl
