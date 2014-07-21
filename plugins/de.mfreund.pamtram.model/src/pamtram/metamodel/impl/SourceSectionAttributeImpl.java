/**
 */
package pamtram.metamodel.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Section Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.SourceSectionAttributeImpl#getOwningClass <em>Owning Class</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SourceSectionAttributeImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SourceSectionAttributeImpl#getValueConstraint <em>Value Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceSectionAttributeImpl extends AttributeImpl implements SourceSectionAttribute {
	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EAttribute attribute;

	/**
	 * The cached value of the '{@link #getValueConstraint() <em>Value Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeValueConstraint> valueConstraint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass getOwningClass() {
		if (eContainerFeatureID() != MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS) return null;
		return (SourceSectionClass)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute() {
		if (attribute != null && attribute.eIsProxy()) {
			InternalEObject oldAttribute = (InternalEObject)attribute;
			attribute = (EAttribute)eResolveProxy(oldAttribute);
			if (attribute != oldAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE, oldAttribute, attribute));
			}
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(EAttribute newAttribute) {
		EAttribute oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE, oldAttribute, attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeValueConstraint> getValueConstraint() {
		if (valueConstraint == null) {
			valueConstraint = new EObjectContainmentEList<AttributeValueConstraint>(AttributeValueConstraint.class, this, MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT);
		}
		return valueConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS:
				return eBasicSetContainer(null, MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS, msgs);
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT:
				return ((InternalEList<?>)getValueConstraint()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS:
				return eInternalContainer().eInverseRemove(this, MetamodelPackage.SOURCE_SECTION_CLASS__ATTRIBUTES, SourceSectionClass.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS:
				return getOwningClass();
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE:
				if (resolve) return getAttribute();
				return basicGetAttribute();
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT:
				return getValueConstraint();
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
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE:
				setAttribute((EAttribute)newValue);
				return;
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT:
				getValueConstraint().clear();
				getValueConstraint().addAll((Collection<? extends AttributeValueConstraint>)newValue);
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
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE:
				setAttribute((EAttribute)null);
				return;
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT:
				getValueConstraint().clear();
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
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS:
				return getOwningClass() != null;
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE:
				return attribute != null;
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT:
				return valueConstraint != null && !valueConstraint.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SourceSectionAttributeImpl
