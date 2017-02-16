/**
 */
package pamtram.structure.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.NamedElement;
import pamtram.PAMTraM;
import pamtram.impl.NamedElementImpl;
import pamtram.structure.ModifiedAttributeElementType;
import pamtram.structure.StructurePackage;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.modifier.ValueModifierSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.impl.ModifiedAttributeElementTypeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.structure.impl.ModifiedAttributeElementTypeImpl#getModifier <em>Modifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ModifiedAttributeElementTypeImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends NamedElementImpl implements ModifiedAttributeElementType<S, C, R, A> {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected A source;

	/**
	 * The cached value of the '{@link #getModifiers() <em>Modifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueModifierSet> modifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifiedAttributeElementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.MODIFIED_ATTRIBUTE_ELEMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public A getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (A)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StructurePackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceGen(A newSource) {
		A oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructurePackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE, oldSource, source));
	}

	/**
	 * Before setting the {@link newSource}, update the name.
	 */
	@Override
	public void setSource(A newSource) {
		
		setNameDerived(source, newSource, null, null);
		setSourceGen(newSource);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValueModifierSet> getModifiers() {
		if (modifier == null) {
			modifier = new EObjectResolvingEList<ValueModifierSet>(ValueModifierSet.class, this, StructurePackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIERS);
		}
		return modifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * This iterates upward in the containment hierarchy until an element
	 * that is of type {@link MappingHintGroupType} or {@link InstantiableMappingHintGroup}
	 * is found. This element is returned.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedElement getMappingHintGroup() {
		EObject ret = this.eContainer;
		while(!(ret instanceof MappingHintGroupType || ret instanceof InstantiableMappingHintGroup)) {
			ret = ret.eContainer();
			if(ret instanceof PAMTraM) {
				// something went wrong
				return null;
			}
		}
		return (NamedElement) ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping getMapping() {
		EObject ret = this.eContainer;
		while(!(ret instanceof Mapping)) {
			ret = ret.eContainer();
			if(ret instanceof PAMTraM) {
				// something went wrong
				return null;
			}
		}
		return (Mapping) ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * TODO update the name of the ModifiedAttributeElementType based on the modifiers it contains
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructurePackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case StructurePackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIERS:
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
			case StructurePackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE:
				setSource((A)newValue);
				return;
			case StructurePackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIERS:
				getModifiers().clear();
				getModifiers().addAll((Collection<? extends ValueModifierSet>)newValue);
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
			case StructurePackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE:
				setSource((A)null);
				return;
			case StructurePackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIERS:
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
			case StructurePackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE:
				return source != null;
			case StructurePackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIERS:
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case StructurePackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP:
				return getMappingHintGroup();
			case StructurePackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING:
				return getMapping();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ModifiedAttributeElementTypeImpl
