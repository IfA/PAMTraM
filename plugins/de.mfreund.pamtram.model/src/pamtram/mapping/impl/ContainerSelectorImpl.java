/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.mapping.MappingPackage;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.mapping.ContainerSelector;
import pamtram.mapping.ContainerSelectorExternalSourceElement;
import pamtram.mapping.ContainerSelectorSourceElement;
import pamtram.mapping.ContainerSelectorSourceInterface;
import pamtram.mapping.ContainerSelectorTargetAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Connection Hint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.ContainerSelectorImpl#getTargetAttributes <em>Target Attributes</em>}</li>
 *   <li>{@link pamtram.mapping.impl.ContainerSelectorImpl#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContainerSelectorImpl extends MappingHintBaseTypeImpl implements ContainerSelector {
	/**
	 * The cached value of the '{@link #getTargetAttributes() <em>Target Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<ContainerSelectorTargetAttribute> targetAttributes;

	/**
	 * The cached value of the '{@link #getSourceElements() <em>Source Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ContainerSelectorSourceInterface> sourceElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerSelectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.CONTAINER_SELECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ContainerSelectorTargetAttribute> getTargetAttributes() {
		if (targetAttributes == null) {
			targetAttributes = new EObjectContainmentEList<ContainerSelectorTargetAttribute>(ContainerSelectorTargetAttribute.class, this, MappingPackage.CONTAINER_SELECTOR__TARGET_ATTRIBUTES);
		}
		return targetAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ContainerSelectorSourceInterface> getSourceElements() {
		if (sourceElements == null) {
			sourceElements = new EObjectContainmentEList<ContainerSelectorSourceInterface>(ContainerSelectorSourceInterface.class, this, MappingPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS);
		}
		return sourceElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public EList<ActualSourceSectionAttribute> getSourceAttributes() {
		return this.getSourceAttributes();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ContainerSelectorSourceElement> getLocalSourceElements() {
				EList<ContainerSelectorSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<ContainerSelectorSourceElement>();
				
				for(ContainerSelectorSourceInterface i : this.getSourceElements()){
					if(i instanceof ContainerSelectorSourceElement){
						elements.add((ContainerSelectorSourceElement) i);
					}
				}
				
				return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ContainerSelectorExternalSourceElement> getExternalSourceElements() {
		EList<ContainerSelectorExternalSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<>();
		
		for(ContainerSelectorSourceInterface i : this.getSourceElements()){
			if(i instanceof ContainerSelectorExternalSourceElement){
				elements.add((ContainerSelectorExternalSourceElement) i);
			}
		}
		
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.CONTAINER_SELECTOR__TARGET_ATTRIBUTES:
				return ((InternalEList<?>)getTargetAttributes()).basicRemove(otherEnd, msgs);
			case MappingPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS:
				return ((InternalEList<?>)getSourceElements()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.CONTAINER_SELECTOR__TARGET_ATTRIBUTES:
				return getTargetAttributes();
			case MappingPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS:
				return getSourceElements();
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
			case MappingPackage.CONTAINER_SELECTOR__TARGET_ATTRIBUTES:
				getTargetAttributes().clear();
				getTargetAttributes().addAll((Collection<? extends ContainerSelectorTargetAttribute>)newValue);
				return;
			case MappingPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS:
				getSourceElements().clear();
				getSourceElements().addAll((Collection<? extends ContainerSelectorSourceInterface>)newValue);
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
			case MappingPackage.CONTAINER_SELECTOR__TARGET_ATTRIBUTES:
				getTargetAttributes().clear();
				return;
			case MappingPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS:
				getSourceElements().clear();
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
			case MappingPackage.CONTAINER_SELECTOR__TARGET_ATTRIBUTES:
				return targetAttributes != null && !targetAttributes.isEmpty();
			case MappingPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS:
				return sourceElements != null && !sourceElements.isEmpty();
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
			case MappingPackage.CONTAINER_SELECTOR___GET_SOURCE_ATTRIBUTES:
				return getSourceAttributes();
			case MappingPackage.CONTAINER_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS:
				return getLocalSourceElements();
			case MappingPackage.CONTAINER_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS:
				return getExternalSourceElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ModelConnectionHintImpl
