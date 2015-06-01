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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import pamtram.PamtramPackage;
import pamtram.SectionModel;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Section Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.impl.SectionModelImpl#getMetaModelPackage <em>Meta Model Package</em>}</li>
 *   <li>{@link pamtram.impl.SectionModelImpl#getMetaModelSections <em>Meta Model Sections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SectionModelImpl<C extends pamtram.metamodel.Class<C, R, A>, R extends Reference<C, R, A>, A extends Attribute<C, R, A>> extends MinimalEObjectImpl.Container implements SectionModel<C, R, A> {
	/**
	 * The cached value of the '{@link #getMetaModelPackage() <em>Meta Model Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelPackage()
	 * @generated
	 * @ordered
	 */
	protected EPackage metaModelPackage;

	/**
	 * The cached value of the '{@link #getMetaModelSections() <em>Meta Model Sections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelSections()
	 * @generated
	 * @ordered
	 */
	protected EList<C> metaModelSections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SectionModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PamtramPackage.Literals.SECTION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getMetaModelPackage() {
		if (metaModelPackage != null && metaModelPackage.eIsProxy()) {
			InternalEObject oldMetaModelPackage = (InternalEObject)metaModelPackage;
			metaModelPackage = (EPackage)eResolveProxy(oldMetaModelPackage);
			if (metaModelPackage != oldMetaModelPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PamtramPackage.SECTION_MODEL__META_MODEL_PACKAGE, oldMetaModelPackage, metaModelPackage));
			}
		}
		return metaModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetMetaModelPackage() {
		return metaModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaModelPackage(EPackage newMetaModelPackage) {
		EPackage oldMetaModelPackage = metaModelPackage;
		metaModelPackage = newMetaModelPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.SECTION_MODEL__META_MODEL_PACKAGE, oldMetaModelPackage, metaModelPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<C> getMetaModelSections() {
		if (metaModelSections == null) {
			metaModelSections = new EObjectContainmentEList<C>(pamtram.metamodel.Class.class, this, PamtramPackage.SECTION_MODEL__META_MODEL_SECTIONS);
		}
		return metaModelSections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PamtramPackage.SECTION_MODEL__META_MODEL_SECTIONS:
				return ((InternalEList<?>)getMetaModelSections()).basicRemove(otherEnd, msgs);
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
			case PamtramPackage.SECTION_MODEL__META_MODEL_PACKAGE:
				if (resolve) return getMetaModelPackage();
				return basicGetMetaModelPackage();
			case PamtramPackage.SECTION_MODEL__META_MODEL_SECTIONS:
				return getMetaModelSections();
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
			case PamtramPackage.SECTION_MODEL__META_MODEL_PACKAGE:
				setMetaModelPackage((EPackage)newValue);
				return;
			case PamtramPackage.SECTION_MODEL__META_MODEL_SECTIONS:
				getMetaModelSections().clear();
				getMetaModelSections().addAll((Collection<? extends C>)newValue);
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
			case PamtramPackage.SECTION_MODEL__META_MODEL_PACKAGE:
				setMetaModelPackage((EPackage)null);
				return;
			case PamtramPackage.SECTION_MODEL__META_MODEL_SECTIONS:
				getMetaModelSections().clear();
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
			case PamtramPackage.SECTION_MODEL__META_MODEL_PACKAGE:
				return metaModelPackage != null;
			case PamtramPackage.SECTION_MODEL__META_MODEL_SECTIONS:
				return metaModelSections != null && !metaModelSections.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SectionModelImpl
