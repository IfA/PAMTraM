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
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.ModelConnectionHint;
import pamtram.metamodel.TargetSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hint Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImpl#getMappingHints <em>Mapping Hints</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImpl#getTargetMMSection <em>Target MM Section</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappingHintGroupImpl#getModelConnectionMatcher <em>Model Connection Matcher</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingHintGroupImpl extends NamedElementImpl implements MappingHintGroup {
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
	 * The cached value of the '{@link #getTargetMMSection() <em>Target MM Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetMMSection()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionClass targetMMSection;

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
	public EList<MappingHint> getMappingHints() {
		if (mappingHints == null) {
			mappingHints = new EObjectContainmentEList<MappingHint>(MappingHint.class, this, MappingPackage.MAPPING_HINT_GROUP__MAPPING_HINTS);
		}
		return mappingHints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass getTargetMMSection() {
		if (targetMMSection != null && targetMMSection.eIsProxy()) {
			InternalEObject oldTargetMMSection = (InternalEObject)targetMMSection;
			targetMMSection = (TargetSectionClass)eResolveProxy(oldTargetMMSection);
			if (targetMMSection != oldTargetMMSection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING_HINT_GROUP__TARGET_MM_SECTION, oldTargetMMSection, targetMMSection));
			}
		}
		return targetMMSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass basicGetTargetMMSection() {
		return targetMMSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetMMSection(TargetSectionClass newTargetMMSection) {
		TargetSectionClass oldTargetMMSection = targetMMSection;
		targetMMSection = newTargetMMSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP__TARGET_MM_SECTION, oldTargetMMSection, targetMMSection));
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
			case MappingPackage.MAPPING_HINT_GROUP__MAPPING_HINTS:
				return ((InternalEList<?>)getMappingHints()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.MAPPING_HINT_GROUP__MAPPING_HINTS:
				return getMappingHints();
			case MappingPackage.MAPPING_HINT_GROUP__TARGET_MM_SECTION:
				if (resolve) return getTargetMMSection();
				return basicGetTargetMMSection();
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MappingPackage.MAPPING_HINT_GROUP__MAPPING_HINTS:
				getMappingHints().clear();
				getMappingHints().addAll((Collection<? extends MappingHint>)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP__TARGET_MM_SECTION:
				setTargetMMSection((TargetSectionClass)newValue);
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
			case MappingPackage.MAPPING_HINT_GROUP__MAPPING_HINTS:
				getMappingHints().clear();
				return;
			case MappingPackage.MAPPING_HINT_GROUP__TARGET_MM_SECTION:
				setTargetMMSection((TargetSectionClass)null);
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
			case MappingPackage.MAPPING_HINT_GROUP__MAPPING_HINTS:
				return mappingHints != null && !mappingHints.isEmpty();
			case MappingPackage.MAPPING_HINT_GROUP__TARGET_MM_SECTION:
				return targetMMSection != null;
			case MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER:
				return modelConnectionMatcher != null;
		}
		return super.eIsSet(featureID);
	}

} //MappingHintGroupImpl
