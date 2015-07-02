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
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.GlobalAttributeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.impl.GlobalAttributeImpl#getModifier <em>Modifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GlobalAttributeImpl extends NamedElementImpl implements GlobalAttribute {
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
	protected GlobalAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.GLOBAL_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceSectionAttribute getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (SourceSectionAttribute)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.GLOBAL_ATTRIBUTE__SOURCE, oldSource, source));
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
	public void setSourceGen(SourceSectionAttribute newSource) {
		SourceSectionAttribute oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.GLOBAL_ATTRIBUTE__SOURCE, oldSource, source));
	}
	
	/**
	 * Before setting the {@link newSource}, update the name
	 */
	@Override
	public void setSource(SourceSectionAttribute newSource) {
		setNameDerived(source, newSource, null, null);
		setSourceGen(newSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeValueModifierSet> getModifier() {
		if (modifier == null) {
			modifier = new EObjectResolvingEList<AttributeValueModifierSet>(AttributeValueModifierSet.class, this, MappingPackage.GLOBAL_ATTRIBUTE__MODIFIER);
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
			case MappingPackage.GLOBAL_ATTRIBUTE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case MappingPackage.GLOBAL_ATTRIBUTE__MODIFIER:
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
			case MappingPackage.GLOBAL_ATTRIBUTE__SOURCE:
				setSource((SourceSectionAttribute)newValue);
				return;
			case MappingPackage.GLOBAL_ATTRIBUTE__MODIFIER:
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
			case MappingPackage.GLOBAL_ATTRIBUTE__SOURCE:
				setSource((SourceSectionAttribute)null);
				return;
			case MappingPackage.GLOBAL_ATTRIBUTE__MODIFIER:
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
			case MappingPackage.GLOBAL_ATTRIBUTE__SOURCE:
				return source != null;
			case MappingPackage.GLOBAL_ATTRIBUTE__MODIFIER:
				return modifier != null && !modifier.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GlobalAttributeImpl
