/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.mapping.AttributeMappingSourceElementType;
import pamtram.mapping.AttributeMappingSourceElementWithModifiers;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.SimpleModelConnectionHint;
import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Model Connection Hint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.mapping.impl.SimpleModelConnectionHintImpl#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.impl.SimpleModelConnectionHintImpl#getModifier <em>Modifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleModelConnectionHintImpl extends ModelConnectionHintImpl implements SimpleModelConnectionHint {
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
	protected SimpleModelConnectionHintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.SIMPLE_MODEL_CONNECTION_HINT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.SIMPLE_MODEL_CONNECTION_HINT__SOURCE, oldSource, source));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.SIMPLE_MODEL_CONNECTION_HINT__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeValueModifierSet> getModifier() {
		if (modifier == null) {
			modifier = new EObjectResolvingEList<AttributeValueModifierSet>(AttributeValueModifierSet.class, this, MappingPackage.SIMPLE_MODEL_CONNECTION_HINT__MODIFIER);
		}
		return modifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceSectionAttribute> getSourceAttributes() {
						EList<SourceSectionAttribute> sources= new org.eclipse.emf.common.util.BasicEList<SourceSectionAttribute>();
						sources.add(this.getSource());
						
						return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.SIMPLE_MODEL_CONNECTION_HINT__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case MappingPackage.SIMPLE_MODEL_CONNECTION_HINT__MODIFIER:
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
			case MappingPackage.SIMPLE_MODEL_CONNECTION_HINT__SOURCE:
				setSource((SourceSectionAttribute)newValue);
				return;
			case MappingPackage.SIMPLE_MODEL_CONNECTION_HINT__MODIFIER:
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
			case MappingPackage.SIMPLE_MODEL_CONNECTION_HINT__SOURCE:
				setSource((SourceSectionAttribute)null);
				return;
			case MappingPackage.SIMPLE_MODEL_CONNECTION_HINT__MODIFIER:
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
			case MappingPackage.SIMPLE_MODEL_CONNECTION_HINT__SOURCE:
				return source != null;
			case MappingPackage.SIMPLE_MODEL_CONNECTION_HINT__MODIFIER:
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
		if (baseClass == AttributeMappingSourceElementType.class) {
			switch (derivedFeatureID) {
				case MappingPackage.SIMPLE_MODEL_CONNECTION_HINT__SOURCE: return MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE;
				default: return -1;
			}
		}
		if (baseClass == AttributeMappingSourceElementWithModifiers.class) {
			switch (derivedFeatureID) {
				case MappingPackage.SIMPLE_MODEL_CONNECTION_HINT__MODIFIER: return MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__MODIFIER;
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
		if (baseClass == AttributeMappingSourceElementType.class) {
			switch (baseFeatureID) {
				case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE: return MappingPackage.SIMPLE_MODEL_CONNECTION_HINT__SOURCE;
				default: return -1;
			}
		}
		if (baseClass == AttributeMappingSourceElementWithModifiers.class) {
			switch (baseFeatureID) {
				case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS__MODIFIER: return MappingPackage.SIMPLE_MODEL_CONNECTION_HINT__MODIFIER;
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MappingPackage.SIMPLE_MODEL_CONNECTION_HINT___GET_SOURCE_ATTRIBUTES:
				return getSourceAttributes();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SimpleModelConnectionHintImpl
