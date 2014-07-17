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

import pamtram.mapping.AttributeMappingSourceElementType;
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
 *   <li>{@link pamtram.mapping.impl.SimpleAttributeMatcherImpl#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.impl.SimpleAttributeMatcherImpl#getModifier <em>Modifier</em>}</li>
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
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected SourceSectionAttribute source;

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
	public SourceSectionAttribute getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (SourceSectionAttribute)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionAttribute basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(SourceSectionAttribute newSource) {
		SourceSectionAttribute oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeValueModifierSet> getModifier() {
		if (modifier == null) {
			modifier = new EObjectResolvingEList<AttributeValueModifierSet>(AttributeValueModifierSet.class, this, MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__MODIFIER);
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
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__NAME:
				return getName();
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__MODIFIER:
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
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__NAME:
				setName((String)newValue);
				return;
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE:
				setSource((SourceSectionAttribute)newValue);
				return;
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__MODIFIER:
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
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE:
				setSource((SourceSectionAttribute)null);
				return;
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__MODIFIER:
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
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE:
				return source != null;
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__MODIFIER:
				return modifier != null && !modifier.isEmpty();
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
		if (baseClass == AttributeMappingSourceElementType.class) {
			switch (derivedFeatureID) {
				case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE: return MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE;
				case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__MODIFIER: return MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__MODIFIER;
				default: return -1;
			}
		}
		if (baseClass == ComplexAttributeMatcherSourceElement.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == AttributeMappingSourceElementType.class) {
			switch (baseFeatureID) {
				case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE: return MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__SOURCE;
				case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__MODIFIER: return MappingPackage.SIMPLE_ATTRIBUTE_MATCHER__MODIFIER;
				default: return -1;
			}
		}
		if (baseClass == ComplexAttributeMatcherSourceElement.class) {
			switch (baseFeatureID) {
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
