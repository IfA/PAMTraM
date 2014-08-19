/**
 */
package pamtram.mapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.MappedAttributeValueExpanderType;
import pamtram.mapping.MappingPackage;

import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.TargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapped Attribute Value Expander Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.mapping.impl.MappedAttributeValueExpanderTypeImpl#getSourceAttribute <em>Source Attribute</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappedAttributeValueExpanderTypeImpl#getTargetAttribute <em>Target Attribute</em>}</li>
 *   <li>{@link pamtram.mapping.impl.MappedAttributeValueExpanderTypeImpl#getModifiers <em>Modifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MappedAttributeValueExpanderTypeImpl extends HintImporterMappingHintImpl implements MappedAttributeValueExpanderType {
	/**
	 * The cached value of the '{@link #getSourceAttribute() <em>Source Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceAttribute()
	 * @generated
	 * @ordered
	 */
	protected SourceSectionAttribute sourceAttribute;

	/**
	 * The cached value of the '{@link #getTargetAttribute() <em>Target Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetAttribute()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionAttribute targetAttribute;

	/**
	 * The cached value of the '{@link #getModifiers() <em>Modifiers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeValueModifierSet> modifiers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappedAttributeValueExpanderTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionAttribute getSourceAttribute() {
		if (sourceAttribute != null && sourceAttribute.eIsProxy()) {
			InternalEObject oldSourceAttribute = (InternalEObject)sourceAttribute;
			sourceAttribute = (SourceSectionAttribute)eResolveProxy(oldSourceAttribute);
			if (sourceAttribute != oldSourceAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__SOURCE_ATTRIBUTE, oldSourceAttribute, sourceAttribute));
			}
		}
		return sourceAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionAttribute basicGetSourceAttribute() {
		return sourceAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceAttribute(SourceSectionAttribute newSourceAttribute) {
		SourceSectionAttribute oldSourceAttribute = sourceAttribute;
		sourceAttribute = newSourceAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__SOURCE_ATTRIBUTE, oldSourceAttribute, sourceAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionAttribute getTargetAttribute() {
		if (targetAttribute != null && targetAttribute.eIsProxy()) {
			InternalEObject oldTargetAttribute = (InternalEObject)targetAttribute;
			targetAttribute = (TargetSectionAttribute)eResolveProxy(oldTargetAttribute);
			if (targetAttribute != oldTargetAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__TARGET_ATTRIBUTE, oldTargetAttribute, targetAttribute));
			}
		}
		return targetAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionAttribute basicGetTargetAttribute() {
		return targetAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetAttribute(TargetSectionAttribute newTargetAttribute) {
		TargetSectionAttribute oldTargetAttribute = targetAttribute;
		targetAttribute = newTargetAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__TARGET_ATTRIBUTE, oldTargetAttribute, targetAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeValueModifierSet> getModifiers() {
		if (modifiers == null) {
			modifiers = new EObjectResolvingEList.Unsettable<AttributeValueModifierSet>(AttributeValueModifierSet.class, this, MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__MODIFIERS);
		}
		return modifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetModifiers() {
		if (modifiers != null) ((InternalEList.Unsettable<?>)modifiers).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetModifiers() {
		return modifiers != null && ((InternalEList.Unsettable<?>)modifiers).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__SOURCE_ATTRIBUTE:
				if (resolve) return getSourceAttribute();
				return basicGetSourceAttribute();
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__TARGET_ATTRIBUTE:
				if (resolve) return getTargetAttribute();
				return basicGetTargetAttribute();
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__MODIFIERS:
				return getModifiers();
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
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__SOURCE_ATTRIBUTE:
				setSourceAttribute((SourceSectionAttribute)newValue);
				return;
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__TARGET_ATTRIBUTE:
				setTargetAttribute((TargetSectionAttribute)newValue);
				return;
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__MODIFIERS:
				getModifiers().clear();
				getModifiers().addAll((Collection<? extends AttributeValueModifierSet>)newValue);
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
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__SOURCE_ATTRIBUTE:
				setSourceAttribute((SourceSectionAttribute)null);
				return;
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__TARGET_ATTRIBUTE:
				setTargetAttribute((TargetSectionAttribute)null);
				return;
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__MODIFIERS:
				unsetModifiers();
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
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__SOURCE_ATTRIBUTE:
				return sourceAttribute != null;
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__TARGET_ATTRIBUTE:
				return targetAttribute != null;
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__MODIFIERS:
				return isSetModifiers();
		}
		return super.eIsSet(featureID);
	}

} //MappedAttributeValueExpanderTypeImpl
