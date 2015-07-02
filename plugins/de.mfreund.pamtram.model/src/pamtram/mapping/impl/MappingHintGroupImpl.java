/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.DeactivatableElement;
import pamtram.PamtramPackage;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.ModelConnectionHint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hint Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImpl#isDeactivated <em>Deactivated</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImpl#getModelConnectionMatcher <em>Model Connection Matcher</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingHintGroupImpl extends MappingHintGroupTypeImpl implements MappingHintGroup {
	/**
	 * The default value of the '{@link #isDeactivated() <em>Deactivated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeactivated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEACTIVATED_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isDeactivated() <em>Deactivated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeactivated()
	 * @generated
	 * @ordered
	 */
	protected boolean deactivated = DEACTIVATED_EDEFAULT;
	/**
	 * The cached value of the '{@link #getModelConnectionMatcher() <em>Model Connection Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelConnectionMatcher()
	 * @generated
	 * @ordered
	 */
	protected ModelConnectionHint modelConnectionMatcher;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingHintGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPING_HINT_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeactivated() {
		return deactivated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeactivated(boolean newDeactivated) {
		boolean oldDeactivated = deactivated;
		deactivated = newDeactivated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED, oldDeactivated, deactivated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelConnectionHint getModelConnectionMatcher() {
		return modelConnectionMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelConnectionMatcher(ModelConnectionHint newModelConnectionMatcher, NotificationChain msgs) {
		ModelConnectionHint oldModelConnectionMatcher = modelConnectionMatcher;
		modelConnectionMatcher = newModelConnectionMatcher;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER, oldModelConnectionMatcher, newModelConnectionMatcher);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelConnectionMatcher(ModelConnectionHint newModelConnectionMatcher) {
		if (newModelConnectionMatcher != modelConnectionMatcher) {
			NotificationChain msgs = null;
			if (modelConnectionMatcher != null)
				msgs = ((InternalEObject)modelConnectionMatcher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER, null, msgs);
			if (newModelConnectionMatcher != null)
				msgs = ((InternalEObject)newModelConnectionMatcher).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER, null, msgs);
			msgs = basicSetModelConnectionMatcher(newModelConnectionMatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER, newModelConnectionMatcher, newModelConnectionMatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER:
				return basicSetModelConnectionMatcher(null, msgs);
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
			case MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED:
				return isDeactivated();
			case MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER:
				return getModelConnectionMatcher();
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
			case MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED:
				setDeactivated((Boolean)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER:
				setModelConnectionMatcher((ModelConnectionHint)newValue);
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
			case MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED:
				setDeactivated(DEACTIVATED_EDEFAULT);
				return;
			case MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER:
				setModelConnectionMatcher((ModelConnectionHint)null);
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
			case MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED:
				return deactivated != DEACTIVATED_EDEFAULT;
			case MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER:
				return modelConnectionMatcher != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DeactivatableElement.class) {
			switch (derivedFeatureID) {
				case MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED: return PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED;
				default: return -1;
			}
		}
		if (baseClass == InstantiableMappingHintGroup.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DeactivatableElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED: return MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED;
				default: return -1;
			}
		}
		if (baseClass == InstantiableMappingHintGroup.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (deactivated: ");
		result.append(deactivated);
		result.append(')');
		return result.toString();
	}

} //MappingHintGroupImpl
