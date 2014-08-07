/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.Matcher;
import pamtram.metamodel.TargetSectionNonContainmentReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.mapping.impl.MappingInstanceSelectorImpl#getAffectedReference <em>Affected Reference</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingInstanceSelectorImpl#getMatcher <em>Matcher</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingInstanceSelectorImpl extends MappingHintImpl implements MappingInstanceSelector {
	/**
	 * The cached value of the '{@link #getAffectedReference() <em>Affected Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffectedReference()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionNonContainmentReference affectedReference;

	/**
	 * The cached value of the '{@link #getMatcher() <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatcher()
	 * @generated
	 * @ordered
	 */
	protected Matcher matcher;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingInstanceSelectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPING_INSTANCE_SELECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionNonContainmentReference getAffectedReference() {
		if (affectedReference != null && affectedReference.eIsProxy()) {
			InternalEObject oldAffectedReference = (InternalEObject)affectedReference;
			affectedReference = (TargetSectionNonContainmentReference)eResolveProxy(oldAffectedReference);
			if (affectedReference != oldAffectedReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE, oldAffectedReference, affectedReference));
			}
		}
		return affectedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionNonContainmentReference basicGetAffectedReference() {
		return affectedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAffectedReference(TargetSectionNonContainmentReference newAffectedReference) {
		TargetSectionNonContainmentReference oldAffectedReference = affectedReference;
		affectedReference = newAffectedReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE, oldAffectedReference, affectedReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Matcher getMatcher() {
		return matcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatcher(Matcher newMatcher, NotificationChain msgs) {
		Matcher oldMatcher = matcher;
		matcher = newMatcher;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER, oldMatcher, newMatcher);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatcher(Matcher newMatcher) {
		if (newMatcher != matcher) {
			NotificationChain msgs = null;
			if (matcher != null)
				msgs = ((InternalEObject)matcher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER, null, msgs);
			if (newMatcher != null)
				msgs = ((InternalEObject)newMatcher).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER, null, msgs);
			msgs = basicSetMatcher(newMatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER, newMatcher, newMatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER:
				return basicSetMatcher(null, msgs);
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
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE:
				if (resolve) return getAffectedReference();
				return basicGetAffectedReference();
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER:
				return getMatcher();
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
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE:
				setAffectedReference((TargetSectionNonContainmentReference)newValue);
				return;
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER:
				setMatcher((Matcher)newValue);
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
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE:
				setAffectedReference((TargetSectionNonContainmentReference)null);
				return;
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER:
				setMatcher((Matcher)null);
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
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE:
				return affectedReference != null;
			case MappingPackage.MAPPING_INSTANCE_SELECTOR__MATCHER:
				return matcher != null;
		}
		return super.eIsSet(featureID);
	}

} //MappingInstanceSelectorImpl
