/**
 */
package pamtram.structure.library.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter;
import pamtram.structure.StructurePackage;
import pamtram.structure.library.AttributeParameter;
import pamtram.structure.target.ActualTargetSectionAttribute;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Parameter</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.library.impl.AttributeParameterImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeParameterImpl extends LibraryParameterImpl<AbstractAttributeParameter<?>>
		implements AttributeParameter {

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected ActualTargetSectionAttribute attribute;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AttributeParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return StructurePackage.Literals.ATTRIBUTE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific type known in this
	 * context.
	 * 
	 * @generated
	 */
	@Override
	public void setOriginalParameter(AbstractAttributeParameter<?> newOriginalParameter) {

		super.setOriginalParameter(newOriginalParameter);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ActualTargetSectionAttribute getAttribute() {

		return this.attribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetAttribute(ActualTargetSectionAttribute newAttribute, NotificationChain msgs) {

		ActualTargetSectionAttribute oldAttribute = this.attribute;
		this.attribute = newAttribute;
		if (this.eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					StructurePackage.ATTRIBUTE_PARAMETER__ATTRIBUTE, oldAttribute, newAttribute);
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
	public void setAttribute(ActualTargetSectionAttribute newAttribute) {

		if (newAttribute != this.attribute) {
			NotificationChain msgs = null;
			if (this.attribute != null) {
				msgs = ((InternalEObject) this.attribute).eInverseRemove(this,
						InternalEObject.EOPPOSITE_FEATURE_BASE - StructurePackage.ATTRIBUTE_PARAMETER__ATTRIBUTE, null,
						msgs);
			}
			if (newAttribute != null) {
				msgs = ((InternalEObject) newAttribute).eInverseAdd(this,
						InternalEObject.EOPPOSITE_FEATURE_BASE - StructurePackage.ATTRIBUTE_PARAMETER__ATTRIBUTE, null,
						msgs);
			}
			msgs = this.basicSetAttribute(newAttribute, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, StructurePackage.ATTRIBUTE_PARAMETER__ATTRIBUTE,
					newAttribute, newAttribute));
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
			case StructurePackage.ATTRIBUTE_PARAMETER__ATTRIBUTE:
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
			case StructurePackage.ATTRIBUTE_PARAMETER__ATTRIBUTE:
				return this.getAttribute();
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
			case StructurePackage.ATTRIBUTE_PARAMETER__ATTRIBUTE:
				this.setAttribute((ActualTargetSectionAttribute) newValue);
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
			case StructurePackage.ATTRIBUTE_PARAMETER__ATTRIBUTE:
				this.setAttribute((ActualTargetSectionAttribute) null);
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
			case StructurePackage.ATTRIBUTE_PARAMETER__ATTRIBUTE:
				return this.attribute != null;
		}
		return super.eIsSet(featureID);
	}

} // AttributeParameterImpl
