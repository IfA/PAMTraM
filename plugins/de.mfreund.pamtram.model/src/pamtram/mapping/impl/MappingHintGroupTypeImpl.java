/**
 */
package pamtram.mapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.impl.NamedElementImpl;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.TargetSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hint Group Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupTypeImpl#getTargetMMSection <em>Target MM Section</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupTypeImpl#getMappingHints <em>Mapping Hints</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupTypeImpl#getExtend <em>Extend</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MappingHintGroupTypeImpl extends NamedElementImpl implements MappingHintGroupType {
	/**
	 * The cached value of the '{@link #getTargetMMSection() <em>Target MM Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetMMSection()
	 * @generated
	 * @ordered
	 */
	protected TargetSection targetMMSection;

	/**
	 * The cached value of the '{@link #getMappingHints() <em>Mapping Hints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingHints()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingHint> mappingHints;

	/**
	 * The cached value of the '{@link #getExtend() <em>Extend</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtend()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingHintGroupType> extend;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingHintGroupTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSection getTargetMMSection() {
		if (targetMMSection != null && targetMMSection.eIsProxy()) {
			InternalEObject oldTargetMMSection = (InternalEObject)targetMMSection;
			targetMMSection = (TargetSection)eResolveProxy(oldTargetMMSection);
			if (targetMMSection != oldTargetMMSection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION, oldTargetMMSection, targetMMSection));
			}
		}
		return targetMMSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSection basicGetTargetMMSection() {
		return targetMMSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetMMSectionGen(TargetSection newTargetMMSection) {
		TargetSection oldTargetMMSection = targetMMSection;
		targetMMSection = newTargetMMSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION, oldTargetMMSection, targetMMSection));
	}

	/**
	 * Before setting the {@link newTargetMMSection}, update the name.
	 */
	@Override
	public void setTargetMMSection(TargetSection newTargetMMSection) {
		setNameDerived(targetMMSection, newTargetMMSection, null, null);
		setTargetMMSectionGen(newTargetMMSection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingHint> getMappingHints() {
		if (mappingHints == null) {
			mappingHints = new EObjectContainmentEList<MappingHint>(MappingHint.class, this, MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS);
		}
		return mappingHints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingHintGroupType> getExtend() {
		if (extend == null) {
			extend = new EObjectResolvingEList<MappingHintGroupType>(MappingHintGroupType.class, this, MappingPackage.MAPPING_HINT_GROUP_TYPE__EXTEND);
		}
		return extend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS:
				return ((InternalEList<?>)getMappingHints()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION:
				if (resolve) return getTargetMMSection();
				return basicGetTargetMMSection();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS:
				return getMappingHints();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__EXTEND:
				return getExtend();
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
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION:
				setTargetMMSection((TargetSection)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS:
				getMappingHints().clear();
				getMappingHints().addAll((Collection<? extends MappingHint>)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__EXTEND:
				getExtend().clear();
				getExtend().addAll((Collection<? extends MappingHintGroupType>)newValue);
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
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION:
				setTargetMMSection((TargetSection)null);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS:
				getMappingHints().clear();
				return;
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__EXTEND:
				getExtend().clear();
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
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION:
				return targetMMSection != null;
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS:
				return mappingHints != null && !mappingHints.isEmpty();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__EXTEND:
				return extend != null && !extend.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MappingHintGroupTypeImpl
