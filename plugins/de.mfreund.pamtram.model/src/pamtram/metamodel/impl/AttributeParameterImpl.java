/**
 */
package pamtram.metamodel.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.AttributeParameterImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeParameterImpl extends LibraryParameterImpl<AbstractAttributeParameter<?>> implements AttributeParameter {
	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected ActualAttribute attribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.ATTRIBUTE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setOriginalParameter(AbstractAttributeParameter<?> newOriginalParameter) {
		super.setOriginalParameter(newOriginalParameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualAttribute getAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttribute(ActualAttribute newAttribute, NotificationChain msgs) {
		ActualAttribute oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.ATTRIBUTE_PARAMETER__ATTRIBUTE, oldAttribute, newAttribute);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(ActualAttribute newAttribute) {
		if (newAttribute != attribute) {
			NotificationChain msgs = null;
			if (attribute != null)
				msgs = ((InternalEObject)attribute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.ATTRIBUTE_PARAMETER__ATTRIBUTE, null, msgs);
			if (newAttribute != null)
				msgs = ((InternalEObject)newAttribute).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.ATTRIBUTE_PARAMETER__ATTRIBUTE, null, msgs);
			msgs = basicSetAttribute(newAttribute, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.ATTRIBUTE_PARAMETER__ATTRIBUTE, newAttribute, newAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.ATTRIBUTE_PARAMETER__ATTRIBUTE:
				return basicSetAttribute(null, msgs);
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
			case MetamodelPackage.ATTRIBUTE_PARAMETER__ATTRIBUTE:
				return getAttribute();
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
			case MetamodelPackage.ATTRIBUTE_PARAMETER__ATTRIBUTE:
				setAttribute((ActualAttribute)newValue);
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
			case MetamodelPackage.ATTRIBUTE_PARAMETER__ATTRIBUTE:
				setAttribute((ActualAttribute)null);
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
			case MetamodelPackage.ATTRIBUTE_PARAMETER__ATTRIBUTE:
				return attribute != null;
		}
		return super.eIsSet(featureID);
	}

} //AttributeParameterImpl
