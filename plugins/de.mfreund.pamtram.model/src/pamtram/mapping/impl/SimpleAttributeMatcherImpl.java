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

import pamtram.NamedElement;
import pamtram.PamtramPackage;

import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.ComplexAttributeMatcherSourceElement;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.SimpleAttributeMatcher;

import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Attribute Matcher</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.mapping.impl.SimpleAttributeMatcherImpl#getName <em>Name</em>}</li>
 *   <li>{@link pamtram.mapping.impl.SimpleAttributeMatcherImpl#getSourceAttribute <em>Source Attribute</em>}</li>
 *   <li>{@link pamtram.mapping.impl.SimpleAttributeMatcherImpl#getModifiers <em>Modifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleAttributeMatcherImpl extends AttributeMatcherImpl implements SimpleAttributeMatcher {
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
	 * The cached value of the '{@link #getSourceAttribute() <em>Source Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceAttribute()
	 * @generated
	 * @ordered
	 */
	protected SourceSectionAttribute sourceAttribute;

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
	protected SimpleAttributeMatcherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.SIMPLE_ATTRIBUTE_MATCHER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__NAME, oldName, name));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTE, oldSourceAttribute, sourceAttribute));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTE, oldSourceAttribute, sourceAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeValueModifierSet> getModifiers() {
		if (modifiers == null) {
			modifiers = new EObjectResolvingEList<AttributeValueModifierSet>(AttributeValueModifierSet.class, this, MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__MODIFIERS);
		}
		return modifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__NAME:
				return getName();
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTE:
				if (resolve) return getSourceAttribute();
				return basicGetSourceAttribute();
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__MODIFIERS:
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
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__NAME:
				setName((String)newValue);
				return;
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTE:
				setSourceAttribute((SourceSectionAttribute)newValue);
				return;
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__MODIFIERS:
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
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTE:
				setSourceAttribute((SourceSectionAttribute)null);
				return;
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__MODIFIERS:
				getModifiers().clear();
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
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTE:
				return sourceAttribute != null;
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__MODIFIERS:
				return modifiers != null && !modifiers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__NAME: return PamtramPackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == ComplexAttributeMatcherSourceElement.class) {
			switch (derivedFeatureID) {
				case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTE: return MappingPackage.COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT__SOURCE_ATTRIBUTE;
				case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__MODIFIERS: return MappingPackage.COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT__MODIFIERS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.NAMED_ELEMENT__NAME: return MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__NAME;
				default: return -1;
			}
		}
		if (baseClass == ComplexAttributeMatcherSourceElement.class) {
			switch (baseFeatureID) {
				case MappingPackage.COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT__SOURCE_ATTRIBUTE: return MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTE;
				case MappingPackage.COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT__MODIFIERS: return MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__MODIFIERS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SimpleAttributeMatcherImpl
