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
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.DeactivatableElement;
import pamtram.PamtramPackage;
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.TargetSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hint Group Importer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImporterImpl#isDeactivated <em>Deactivated</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImporterImpl#getHintGroup <em>Hint Group</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImporterImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImporterImpl#getMappingHints <em>Mapping Hints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingHintGroupImporterImpl extends NamedElementImpl implements MappingHintGroupImporter {
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
	 * The cached value of the '{@link #getHintGroup() <em>Hint Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHintGroup()
	 * @generated
	 * @ordered
	 */
	protected ExportedMappingHintGroup hintGroup;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionClass container;

	/**
	 * This is true if the Container reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean containerESet;

	/**
	 * The cached value of the '{@link #getMappingHints() <em>Mapping Hints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingHints()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingHintType> mappingHints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingHintGroupImporterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED, oldDeactivated, deactivated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportedMappingHintGroup getHintGroup() {
		if (hintGroup != null && hintGroup.eIsProxy()) {
			InternalEObject oldHintGroup = (InternalEObject)hintGroup;
			hintGroup = (ExportedMappingHintGroup)eResolveProxy(oldHintGroup);
			if (hintGroup != oldHintGroup) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP, oldHintGroup, hintGroup));
			}
		}
		return hintGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportedMappingHintGroup basicGetHintGroup() {
		return hintGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHintGroup(ExportedMappingHintGroup newHintGroup) {
		ExportedMappingHintGroup oldHintGroup = hintGroup;
		hintGroup = newHintGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP, oldHintGroup, hintGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass getContainer() {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject)container;
			container = (TargetSectionClass)eResolveProxy(oldContainer);
			if (container != oldContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass basicGetContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(TargetSectionClass newContainer) {
		TargetSectionClass oldContainer = container;
		container = newContainer;
		boolean oldContainerESet = containerESet;
		containerESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONTAINER, oldContainer, container, !oldContainerESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetContainer() {
		TargetSectionClass oldContainer = container;
		boolean oldContainerESet = containerESet;
		container = null;
		containerESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONTAINER, oldContainer, null, oldContainerESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetContainer() {
		return containerESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingHintType> getMappingHints() {
		if (mappingHints == null) {
			mappingHints = new EObjectContainmentEList.Unsettable<MappingHintType>(MappingHintType.class, this, MappingPackage.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS);
		}
		return mappingHints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMappingHints() {
		if (mappingHints != null) ((InternalEList.Unsettable<?>)mappingHints).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMappingHints() {
		return mappingHints != null && ((InternalEList.Unsettable<?>)mappingHints).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS:
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
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED:
				return isDeactivated();
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP:
				if (resolve) return getHintGroup();
				return basicGetHintGroup();
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS:
				return getMappingHints();
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
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED:
				setDeactivated((Boolean)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP:
				setHintGroup((ExportedMappingHintGroup)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONTAINER:
				setContainer((TargetSectionClass)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS:
				getMappingHints().clear();
				getMappingHints().addAll((Collection<? extends MappingHintType>)newValue);
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
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED:
				setDeactivated(DEACTIVATED_EDEFAULT);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP:
				setHintGroup((ExportedMappingHintGroup)null);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONTAINER:
				unsetContainer();
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS:
				unsetMappingHints();
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
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED:
				return deactivated != DEACTIVATED_EDEFAULT;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP:
				return hintGroup != null;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__CONTAINER:
				return isSetContainer();
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS:
				return isSetMappingHints();
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
				case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED: return PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED;
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
				case PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED: return MappingPackage.MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED;
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

} //MappingHintGroupImporterImpl
