/**
 */
package pamtram.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.TransformationModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PAM Tra M</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getContextMetaModelPackage <em>Context Meta Model Package</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSourceSectionModel <em>Source Section Model</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getTargetSectionModel <em>Target Section Model</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getMappingModel <em>Mapping Model</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getTransformationModel <em>Transformation Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PAMTraMImpl extends MinimalEObjectImpl.Container implements PAMTraM {
	/**
	 * The cached value of the '{@link #getContextMetaModelPackage() <em>Context Meta Model Package</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextMetaModelPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackage> contextMetaModelPackage;

	/**
	 * The cached value of the '{@link #getSourceSectionModel() <em>Source Section Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceSectionModel()
	 * @generated
	 * @ordered
	 */
	protected SourceSectionModel sourceSectionModel;

	/**
	 * The cached value of the '{@link #getTargetSectionModel() <em>Target Section Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetSectionModel()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionModel targetSectionModel;

	/**
	 * The cached value of the '{@link #getMappingModel() <em>Mapping Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingModel()
	 * @generated
	 * @ordered
	 */
	protected MappingModel mappingModel;

	/**
	 * The cached value of the '{@link #getTransformationModel() <em>Transformation Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformationModel()
	 * @generated
	 * @ordered
	 */
	protected TransformationModel transformationModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PAMTraMImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PamtramPackage.Literals.PAM_TRA_M;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPackage> getContextMetaModelPackage() {
		if (contextMetaModelPackage == null) {
			contextMetaModelPackage = new EObjectResolvingEList<EPackage>(EPackage.class, this, PamtramPackage.PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE);
		}
		return contextMetaModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionModel getSourceSectionModel() {
		return sourceSectionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceSectionModel(SourceSectionModel newSourceSectionModel, NotificationChain msgs) {
		SourceSectionModel oldSourceSectionModel = sourceSectionModel;
		sourceSectionModel = newSourceSectionModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL, oldSourceSectionModel, newSourceSectionModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceSectionModel(SourceSectionModel newSourceSectionModel) {
		if (newSourceSectionModel != sourceSectionModel) {
			NotificationChain msgs = null;
			if (sourceSectionModel != null)
				msgs = ((InternalEObject)sourceSectionModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL, null, msgs);
			if (newSourceSectionModel != null)
				msgs = ((InternalEObject)newSourceSectionModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL, null, msgs);
			msgs = basicSetSourceSectionModel(newSourceSectionModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL, newSourceSectionModel, newSourceSectionModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionModel getTargetSectionModel() {
		return targetSectionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetSectionModel(TargetSectionModel newTargetSectionModel, NotificationChain msgs) {
		TargetSectionModel oldTargetSectionModel = targetSectionModel;
		targetSectionModel = newTargetSectionModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL, oldTargetSectionModel, newTargetSectionModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetSectionModel(TargetSectionModel newTargetSectionModel) {
		if (newTargetSectionModel != targetSectionModel) {
			NotificationChain msgs = null;
			if (targetSectionModel != null)
				msgs = ((InternalEObject)targetSectionModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL, null, msgs);
			if (newTargetSectionModel != null)
				msgs = ((InternalEObject)newTargetSectionModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL, null, msgs);
			msgs = basicSetTargetSectionModel(newTargetSectionModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL, newTargetSectionModel, newTargetSectionModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingModel getMappingModel() {
		return mappingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingModel(MappingModel newMappingModel, NotificationChain msgs) {
		MappingModel oldMappingModel = mappingModel;
		mappingModel = newMappingModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PamtramPackage.PAM_TRA_M__MAPPING_MODEL, oldMappingModel, newMappingModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingModel(MappingModel newMappingModel) {
		if (newMappingModel != mappingModel) {
			NotificationChain msgs = null;
			if (mappingModel != null)
				msgs = ((InternalEObject)mappingModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.PAM_TRA_M__MAPPING_MODEL, null, msgs);
			if (newMappingModel != null)
				msgs = ((InternalEObject)newMappingModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.PAM_TRA_M__MAPPING_MODEL, null, msgs);
			msgs = basicSetMappingModel(newMappingModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.PAM_TRA_M__MAPPING_MODEL, newMappingModel, newMappingModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationModel getTransformationModel() {
		return transformationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformationModel(TransformationModel newTransformationModel, NotificationChain msgs) {
		TransformationModel oldTransformationModel = transformationModel;
		transformationModel = newTransformationModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL, oldTransformationModel, newTransformationModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformationModel(TransformationModel newTransformationModel) {
		if (newTransformationModel != transformationModel) {
			NotificationChain msgs = null;
			if (transformationModel != null)
				msgs = ((InternalEObject)transformationModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL, null, msgs);
			if (newTransformationModel != null)
				msgs = ((InternalEObject)newTransformationModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL, null, msgs);
			msgs = basicSetTransformationModel(newTransformationModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL, newTransformationModel, newTransformationModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL:
				return basicSetSourceSectionModel(null, msgs);
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL:
				return basicSetTargetSectionModel(null, msgs);
			case PamtramPackage.PAM_TRA_M__MAPPING_MODEL:
				return basicSetMappingModel(null, msgs);
			case PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL:
				return basicSetTransformationModel(null, msgs);
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
			case PamtramPackage.PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE:
				return getContextMetaModelPackage();
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL:
				return getSourceSectionModel();
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL:
				return getTargetSectionModel();
			case PamtramPackage.PAM_TRA_M__MAPPING_MODEL:
				return getMappingModel();
			case PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL:
				return getTransformationModel();
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
			case PamtramPackage.PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE:
				getContextMetaModelPackage().clear();
				getContextMetaModelPackage().addAll((Collection<? extends EPackage>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL:
				setSourceSectionModel((SourceSectionModel)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL:
				setTargetSectionModel((TargetSectionModel)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__MAPPING_MODEL:
				setMappingModel((MappingModel)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL:
				setTransformationModel((TransformationModel)newValue);
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
			case PamtramPackage.PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE:
				getContextMetaModelPackage().clear();
				return;
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL:
				setSourceSectionModel((SourceSectionModel)null);
				return;
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL:
				setTargetSectionModel((TargetSectionModel)null);
				return;
			case PamtramPackage.PAM_TRA_M__MAPPING_MODEL:
				setMappingModel((MappingModel)null);
				return;
			case PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL:
				setTransformationModel((TransformationModel)null);
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
			case PamtramPackage.PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE:
				return contextMetaModelPackage != null && !contextMetaModelPackage.isEmpty();
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL:
				return sourceSectionModel != null;
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL:
				return targetSectionModel != null;
			case PamtramPackage.PAM_TRA_M__MAPPING_MODEL:
				return mappingModel != null;
			case PamtramPackage.PAM_TRA_M__TRANSFORMATION_MODEL:
				return transformationModel != null;
		}
		return super.eIsSet(featureID);
	}

} //PAMTraMImpl
