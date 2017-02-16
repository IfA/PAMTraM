/**
 */
package pamtram.structure.library.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.impl.NamedElementImpl;
import pamtram.structure.StructurePackage;
import pamtram.structure.library.ResourceParameter;
import pamtram.structure.target.VirtualTargetSectionAttribute;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Resource Parameter</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.library.impl.ResourceParameterImpl#getAttribute <em>Attribute</em>}</li>
 * <li>{@link pamtram.structure.library.impl.ResourceParameterImpl#getOriginalParameter <em>Original
 * Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceParameterImpl extends NamedElementImpl implements ResourceParameter {

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected VirtualTargetSectionAttribute attribute;

	/**
	 * The cached value of the '{@link #getOriginalParameter() <em>Original Parameter</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOriginalParameter()
	 * @generated
	 * @ordered
	 */
	protected de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter originalParameter;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ResourceParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return StructurePackage.Literals.RESOURCE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public VirtualTargetSectionAttribute getAttribute() {

		return this.attribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetAttribute(VirtualTargetSectionAttribute newAttribute, NotificationChain msgs) {

		VirtualTargetSectionAttribute oldAttribute = this.attribute;
		this.attribute = newAttribute;
		if (this.eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					StructurePackage.RESOURCE_PARAMETER__ATTRIBUTE, oldAttribute, newAttribute);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setAttribute(VirtualTargetSectionAttribute newAttribute) {

		if (newAttribute != this.attribute) {
			NotificationChain msgs = null;
			if (this.attribute != null) {
				msgs = ((InternalEObject) this.attribute).eInverseRemove(this,
						InternalEObject.EOPPOSITE_FEATURE_BASE - StructurePackage.RESOURCE_PARAMETER__ATTRIBUTE, null,
						msgs);
			}
			if (newAttribute != null) {
				msgs = ((InternalEObject) newAttribute).eInverseAdd(this,
						InternalEObject.EOPPOSITE_FEATURE_BASE - StructurePackage.RESOURCE_PARAMETER__ATTRIBUTE, null,
						msgs);
			}
			msgs = this.basicSetAttribute(newAttribute, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, StructurePackage.RESOURCE_PARAMETER__ATTRIBUTE,
					newAttribute, newAttribute));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter getOriginalParameter() {

		if (this.originalParameter != null && this.originalParameter.eIsProxy()) {
			InternalEObject oldOriginalParameter = (InternalEObject) this.originalParameter;
			this.originalParameter = (de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter) this
					.eResolveProxy(oldOriginalParameter);
			if (this.originalParameter != oldOriginalParameter) {
				if (this.eNotificationRequired()) {
					this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							StructurePackage.RESOURCE_PARAMETER__ORIGINAL_PARAMETER, oldOriginalParameter,
							this.originalParameter));
				}
			}
		}
		return this.originalParameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter basicGetOriginalParameter() {

		return this.originalParameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setOriginalParameter(
			de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter newOriginalParameter) {

		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter oldOriginalParameter = this.originalParameter;
		this.originalParameter = newOriginalParameter;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET,
					StructurePackage.RESOURCE_PARAMETER__ORIGINAL_PARAMETER, oldOriginalParameter,
					this.originalParameter));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {

		switch (featureID) {
			case StructurePackage.RESOURCE_PARAMETER__ATTRIBUTE:
				return this.basicSetAttribute(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case StructurePackage.RESOURCE_PARAMETER__ATTRIBUTE:
				return this.getAttribute();
			case StructurePackage.RESOURCE_PARAMETER__ORIGINAL_PARAMETER:
				if (resolve) {
					return this.getOriginalParameter();
				}
				return this.basicGetOriginalParameter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {

		switch (featureID) {
			case StructurePackage.RESOURCE_PARAMETER__ATTRIBUTE:
				this.setAttribute((VirtualTargetSectionAttribute) newValue);
				return;
			case StructurePackage.RESOURCE_PARAMETER__ORIGINAL_PARAMETER:
				this.setOriginalParameter(
						(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter) newValue);
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
			case StructurePackage.RESOURCE_PARAMETER__ATTRIBUTE:
				this.setAttribute((VirtualTargetSectionAttribute) null);
				return;
			case StructurePackage.RESOURCE_PARAMETER__ORIGINAL_PARAMETER:
				this.setOriginalParameter((de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter) null);
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
			case StructurePackage.RESOURCE_PARAMETER__ATTRIBUTE:
				return this.attribute != null;
			case StructurePackage.RESOURCE_PARAMETER__ORIGINAL_PARAMETER:
				return this.originalParameter != null;
		}
		return super.eIsSet(featureID);
	}

} // ResourceParameterImpl
