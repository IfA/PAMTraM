/**
 */
package de.mfreund.pamtram.transformation.impl;

import de.mfreund.pamtram.transformation.Transformation;
import de.mfreund.pamtram.transformation.TransformationMapping;
import de.mfreund.pamtram.transformation.TransformationMappingHintGroup;
import de.mfreund.pamtram.transformation.TransformationPackage;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.PAMTraM;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.mfreund.pamtram.transformation.impl.TransformationImpl#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.impl.TransformationImpl#getEndDate <em>End Date</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.impl.TransformationImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.impl.TransformationImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.impl.TransformationImpl#getPamtramInstance <em>Pamtram Instance</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.impl.TransformationImpl#getSourceModels <em>Source Models</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.impl.TransformationImpl#getTargetModels <em>Target Models</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.impl.TransformationImpl#getTransformationMappings <em>Transformation Mappings</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.impl.TransformationImpl#getTransformationHintGroups <em>Transformation Hint Groups</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformationImpl extends MinimalEObjectImpl.Container implements Transformation {
	/**
	 * The default value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date START_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected Date startDate = START_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date END_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected Date endDate = END_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPamtramInstance() <em>Pamtram Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPamtramInstance()
	 * @generated
	 * @ordered
	 */
	protected PAMTraM pamtramInstance;

	/**
	 * The cached value of the '{@link #getSourceModels() <em>Source Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceModels()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> sourceModels;

	/**
	 * The cached value of the '{@link #getTargetModels() <em>Target Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetModels()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> targetModels;

	/**
	 * The cached value of the '{@link #getTransformationMappings() <em>Transformation Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformationMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<TransformationMapping> transformationMappings;

	/**
	 * The cached value of the '{@link #getTransformationHintGroups() <em>Transformation Hint Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformationHintGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<TransformationMappingHintGroup> transformationHintGroups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransformationPackage.Literals.TRANSFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartDate(Date newStartDate) {
		Date oldStartDate = startDate;
		startDate = newStartDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.TRANSFORMATION__START_DATE, oldStartDate, startDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndDate(Date newEndDate) {
		Date oldEndDate = endDate;
		endDate = newEndDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.TRANSFORMATION__END_DATE, oldEndDate, endDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.TRANSFORMATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.TRANSFORMATION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PAMTraM getPamtramInstance() {
		return pamtramInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPamtramInstance(PAMTraM newPamtramInstance, NotificationChain msgs) {
		PAMTraM oldPamtramInstance = pamtramInstance;
		pamtramInstance = newPamtramInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransformationPackage.TRANSFORMATION__PAMTRAM_INSTANCE, oldPamtramInstance, newPamtramInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPamtramInstance(PAMTraM newPamtramInstance) {
		if (newPamtramInstance != pamtramInstance) {
			NotificationChain msgs = null;
			if (pamtramInstance != null)
				msgs = ((InternalEObject)pamtramInstance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TransformationPackage.TRANSFORMATION__PAMTRAM_INSTANCE, null, msgs);
			if (newPamtramInstance != null)
				msgs = ((InternalEObject)newPamtramInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TransformationPackage.TRANSFORMATION__PAMTRAM_INSTANCE, null, msgs);
			msgs = basicSetPamtramInstance(newPamtramInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.TRANSFORMATION__PAMTRAM_INSTANCE, newPamtramInstance, newPamtramInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getSourceModels() {
		if (sourceModels == null) {
			sourceModels = new EObjectContainmentEList<EObject>(EObject.class, this, TransformationPackage.TRANSFORMATION__SOURCE_MODELS);
		}
		return sourceModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getTargetModels() {
		if (targetModels == null) {
			targetModels = new EObjectContainmentEList<EObject>(EObject.class, this, TransformationPackage.TRANSFORMATION__TARGET_MODELS);
		}
		return targetModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransformationMapping> getTransformationMappings() {
		if (transformationMappings == null) {
			transformationMappings = new EObjectContainmentEList<TransformationMapping>(TransformationMapping.class, this, TransformationPackage.TRANSFORMATION__TRANSFORMATION_MAPPINGS);
		}
		return transformationMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransformationMappingHintGroup> getTransformationHintGroups() {
		if (transformationHintGroups == null) {
			transformationHintGroups = new EObjectContainmentEList<TransformationMappingHintGroup>(TransformationMappingHintGroup.class, this, TransformationPackage.TRANSFORMATION__TRANSFORMATION_HINT_GROUPS);
		}
		return transformationHintGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TransformationPackage.TRANSFORMATION__PAMTRAM_INSTANCE:
				return basicSetPamtramInstance(null, msgs);
			case TransformationPackage.TRANSFORMATION__SOURCE_MODELS:
				return ((InternalEList<?>)getSourceModels()).basicRemove(otherEnd, msgs);
			case TransformationPackage.TRANSFORMATION__TARGET_MODELS:
				return ((InternalEList<?>)getTargetModels()).basicRemove(otherEnd, msgs);
			case TransformationPackage.TRANSFORMATION__TRANSFORMATION_MAPPINGS:
				return ((InternalEList<?>)getTransformationMappings()).basicRemove(otherEnd, msgs);
			case TransformationPackage.TRANSFORMATION__TRANSFORMATION_HINT_GROUPS:
				return ((InternalEList<?>)getTransformationHintGroups()).basicRemove(otherEnd, msgs);
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
			case TransformationPackage.TRANSFORMATION__START_DATE:
				return getStartDate();
			case TransformationPackage.TRANSFORMATION__END_DATE:
				return getEndDate();
			case TransformationPackage.TRANSFORMATION__NAME:
				return getName();
			case TransformationPackage.TRANSFORMATION__ID:
				return getId();
			case TransformationPackage.TRANSFORMATION__PAMTRAM_INSTANCE:
				return getPamtramInstance();
			case TransformationPackage.TRANSFORMATION__SOURCE_MODELS:
				return getSourceModels();
			case TransformationPackage.TRANSFORMATION__TARGET_MODELS:
				return getTargetModels();
			case TransformationPackage.TRANSFORMATION__TRANSFORMATION_MAPPINGS:
				return getTransformationMappings();
			case TransformationPackage.TRANSFORMATION__TRANSFORMATION_HINT_GROUPS:
				return getTransformationHintGroups();
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
			case TransformationPackage.TRANSFORMATION__START_DATE:
				setStartDate((Date)newValue);
				return;
			case TransformationPackage.TRANSFORMATION__END_DATE:
				setEndDate((Date)newValue);
				return;
			case TransformationPackage.TRANSFORMATION__NAME:
				setName((String)newValue);
				return;
			case TransformationPackage.TRANSFORMATION__ID:
				setId((String)newValue);
				return;
			case TransformationPackage.TRANSFORMATION__PAMTRAM_INSTANCE:
				setPamtramInstance((PAMTraM)newValue);
				return;
			case TransformationPackage.TRANSFORMATION__SOURCE_MODELS:
				getSourceModels().clear();
				getSourceModels().addAll((Collection<? extends EObject>)newValue);
				return;
			case TransformationPackage.TRANSFORMATION__TARGET_MODELS:
				getTargetModels().clear();
				getTargetModels().addAll((Collection<? extends EObject>)newValue);
				return;
			case TransformationPackage.TRANSFORMATION__TRANSFORMATION_MAPPINGS:
				getTransformationMappings().clear();
				getTransformationMappings().addAll((Collection<? extends TransformationMapping>)newValue);
				return;
			case TransformationPackage.TRANSFORMATION__TRANSFORMATION_HINT_GROUPS:
				getTransformationHintGroups().clear();
				getTransformationHintGroups().addAll((Collection<? extends TransformationMappingHintGroup>)newValue);
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
			case TransformationPackage.TRANSFORMATION__START_DATE:
				setStartDate(START_DATE_EDEFAULT);
				return;
			case TransformationPackage.TRANSFORMATION__END_DATE:
				setEndDate(END_DATE_EDEFAULT);
				return;
			case TransformationPackage.TRANSFORMATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TransformationPackage.TRANSFORMATION__ID:
				setId(ID_EDEFAULT);
				return;
			case TransformationPackage.TRANSFORMATION__PAMTRAM_INSTANCE:
				setPamtramInstance((PAMTraM)null);
				return;
			case TransformationPackage.TRANSFORMATION__SOURCE_MODELS:
				getSourceModels().clear();
				return;
			case TransformationPackage.TRANSFORMATION__TARGET_MODELS:
				getTargetModels().clear();
				return;
			case TransformationPackage.TRANSFORMATION__TRANSFORMATION_MAPPINGS:
				getTransformationMappings().clear();
				return;
			case TransformationPackage.TRANSFORMATION__TRANSFORMATION_HINT_GROUPS:
				getTransformationHintGroups().clear();
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
			case TransformationPackage.TRANSFORMATION__START_DATE:
				return START_DATE_EDEFAULT == null ? startDate != null : !START_DATE_EDEFAULT.equals(startDate);
			case TransformationPackage.TRANSFORMATION__END_DATE:
				return END_DATE_EDEFAULT == null ? endDate != null : !END_DATE_EDEFAULT.equals(endDate);
			case TransformationPackage.TRANSFORMATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TransformationPackage.TRANSFORMATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case TransformationPackage.TRANSFORMATION__PAMTRAM_INSTANCE:
				return pamtramInstance != null;
			case TransformationPackage.TRANSFORMATION__SOURCE_MODELS:
				return sourceModels != null && !sourceModels.isEmpty();
			case TransformationPackage.TRANSFORMATION__TARGET_MODELS:
				return targetModels != null && !targetModels.isEmpty();
			case TransformationPackage.TRANSFORMATION__TRANSFORMATION_MAPPINGS:
				return transformationMappings != null && !transformationMappings.isEmpty();
			case TransformationPackage.TRANSFORMATION__TRANSFORMATION_HINT_GROUPS:
				return transformationHintGroups != null && !transformationHintGroups.isEmpty();
		}
		return super.eIsSet(featureID);
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
		result.append(" (startDate: ");
		result.append(startDate);
		result.append(", endDate: ");
		result.append(endDate);
		result.append(", name: ");
		result.append(name);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //TransformationImpl
