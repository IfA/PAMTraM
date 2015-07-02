/**
 */
package pamtram.metamodel.impl;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.NonContainmentReferenceImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NonContainmentReferenceImpl<C extends pamtram.metamodel.Class<C, R, A>, R extends Reference<C, R, A>, A extends Attribute<C, R, A>> extends ReferenceImpl<C, R, A> implements NonContainmentReference<C, R, A> {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<C> value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonContainmentReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.NON_CONTAINMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<C> getValue() {
		if (value == null) {
			value = new EObjectResolvingEList<C>(pamtram.metamodel.Class.class, this, MetamodelPackage.NON_CONTAINMENT_REFERENCE__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE__VALUE:
				return getValue();
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
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends C>)newValue);
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
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE__VALUE:
				getValue().clear();
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
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE__VALUE:
				return value != null && !value.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NonContainmentReferenceImpl
