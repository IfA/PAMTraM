/**
 */
package pamtram.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.MappingModel;
import pamtram.PamtramPackage;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.GlobalValue;
import pamtram.mapping.Mapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.impl.MappingModelImpl#getMapping <em>Mapping</em>}</li>
 *   <li>{@link pamtram.impl.MappingModelImpl#getModifierSets <em>Modifier Sets</em>}</li>
 *   <li>{@link pamtram.impl.MappingModelImpl#getGlobalValues <em>Global Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingModelImpl extends NamedElementImpl implements MappingModel {
	/**
	 * The cached value of the '{@link #getMapping() <em>Mapping</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> mapping;

	/**
	 * The cached value of the '{@link #getModifierSets() <em>Modifier Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifierSets()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeValueModifierSet> modifierSets;

	/**
	 * The cached value of the '{@link #getGlobalValues() <em>Global Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalValues()
	 * @generated
	 * @ordered
	 */
	protected EList<GlobalValue> globalValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PamtramPackage.Literals.MAPPING_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Mapping> getMapping() {
		if (mapping == null) {
			mapping = new EObjectContainmentEList<Mapping>(Mapping.class, this, PamtramPackage.MAPPING_MODEL__MAPPING);
		}
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeValueModifierSet> getModifierSets() {
		if (modifierSets == null) {
			modifierSets = new EObjectContainmentEList<AttributeValueModifierSet>(AttributeValueModifierSet.class, this, PamtramPackage.MAPPING_MODEL__MODIFIER_SETS);
		}
		return modifierSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GlobalValue> getGlobalValues() {
		if (globalValues == null) {
			globalValues = new EObjectContainmentEList<GlobalValue>(GlobalValue.class, this, PamtramPackage.MAPPING_MODEL__GLOBAL_VALUES);
		}
		return globalValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * This returns the active mappings (the subset of the defined mappings ({@link #mapping}) 
	 * for that {@link Mapping#isDeactivated()} returns '<em>false</em>').
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Mapping> getActiveMappings() {
		EList<Mapping> mappings = getMapping();
		EList<Mapping> activeMappings = new BasicEList<>();
		for (Mapping mapping : mappings) {
			if(!mapping.isDeactivated()) {
				activeMappings.add(mapping);
			}
		}
		return activeMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PamtramPackage.MAPPING_MODEL__MAPPING:
				return ((InternalEList<?>)getMapping()).basicRemove(otherEnd, msgs);
			case PamtramPackage.MAPPING_MODEL__MODIFIER_SETS:
				return ((InternalEList<?>)getModifierSets()).basicRemove(otherEnd, msgs);
			case PamtramPackage.MAPPING_MODEL__GLOBAL_VALUES:
				return ((InternalEList<?>)getGlobalValues()).basicRemove(otherEnd, msgs);
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
			case PamtramPackage.MAPPING_MODEL__MAPPING:
				return getMapping();
			case PamtramPackage.MAPPING_MODEL__MODIFIER_SETS:
				return getModifierSets();
			case PamtramPackage.MAPPING_MODEL__GLOBAL_VALUES:
				return getGlobalValues();
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
			case PamtramPackage.MAPPING_MODEL__MAPPING:
				getMapping().clear();
				getMapping().addAll((Collection<? extends Mapping>)newValue);
				return;
			case PamtramPackage.MAPPING_MODEL__MODIFIER_SETS:
				getModifierSets().clear();
				getModifierSets().addAll((Collection<? extends AttributeValueModifierSet>)newValue);
				return;
			case PamtramPackage.MAPPING_MODEL__GLOBAL_VALUES:
				getGlobalValues().clear();
				getGlobalValues().addAll((Collection<? extends GlobalValue>)newValue);
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
			case PamtramPackage.MAPPING_MODEL__MAPPING:
				getMapping().clear();
				return;
			case PamtramPackage.MAPPING_MODEL__MODIFIER_SETS:
				getModifierSets().clear();
				return;
			case PamtramPackage.MAPPING_MODEL__GLOBAL_VALUES:
				getGlobalValues().clear();
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
			case PamtramPackage.MAPPING_MODEL__MAPPING:
				return mapping != null && !mapping.isEmpty();
			case PamtramPackage.MAPPING_MODEL__MODIFIER_SETS:
				return modifierSets != null && !modifierSets.isEmpty();
			case PamtramPackage.MAPPING_MODEL__GLOBAL_VALUES:
				return globalValues != null && !globalValues.isEmpty();
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
			case PamtramPackage.MAPPING_MODEL___GET_ACTIVE_MAPPINGS:
				return getActiveMappings();
		}
		return super.eInvoke(operationID, arguments);
	}

} //MappingModelImpl
