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
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.AttributeMappingSourceElementType;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.Attribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Mapping Source Element Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.mapping.impl.AttributeMappingSourceElementTypeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.impl.AttributeMappingSourceElementTypeImpl#getModifier <em>Modifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AttributeMappingSourceElementTypeImpl<AttributeType extends Attribute> extends NamedElementImpl implements AttributeMappingSourceElementType<AttributeType> {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected AttributeType source;

	/**
	 * The cached value of the '{@link #getModifier() <em>Modifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifier()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeValueModifierSet> modifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMappingSourceElementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public AttributeType getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (AttributeType)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeType basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(AttributeType newSource) {
		AttributeType oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeValueModifierSet> getModifier() {
		if (modifier == null) {
			modifier = new EObjectResolvingEList<AttributeValueModifierSet>(AttributeValueModifierSet.class, this, MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__MODIFIER);
		}
		return modifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__MODIFIER:
				return getModifier();
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
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE:
				setSource((AttributeType)newValue);
				return;
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__MODIFIER:
				getModifier().clear();
				getModifier().addAll((Collection<? extends AttributeValueModifierSet>)newValue);
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
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE:
				setSource((AttributeType)null);
				return;
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__MODIFIER:
				getModifier().clear();
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
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE:
				return source != null;
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__MODIFIER:
				return modifier != null && !modifier.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AttributeMappingSourceElementTypeImpl
