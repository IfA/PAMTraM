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
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.ModelConnectionHintExternalSourceElement;
import pamtram.mapping.ModelConnectionHintSourceElement;
import pamtram.mapping.ModelConnectionHintSourceInterface;
import pamtram.mapping.ModelConnectionHintTargetAttribute;
import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Connection Hint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.ModelConnectionHintImpl#getTargetAttributes <em>Target Attributes</em>}</li>
 *   <li>{@link pamtram.mapping.impl.ModelConnectionHintImpl#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelConnectionHintImpl extends MappingHintBaseTypeImpl implements ModelConnectionHint {
	/**
	 * The cached value of the '{@link #getTargetAttributes() <em>Target Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelConnectionHintTargetAttribute> targetAttributes;

	/**
	 * The cached value of the '{@link #getSourceElements() <em>Source Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelConnectionHintSourceInterface> sourceElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelConnectionHintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MODEL_CONNECTION_HINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModelConnectionHintTargetAttribute> getTargetAttributes() {
		if (targetAttributes == null) {
			targetAttributes = new EObjectContainmentEList<ModelConnectionHintTargetAttribute>(ModelConnectionHintTargetAttribute.class, this, MappingPackage.MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES);
		}
		return targetAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModelConnectionHintSourceInterface> getSourceElements() {
		if (sourceElements == null) {
			sourceElements = new EObjectContainmentEList<ModelConnectionHintSourceInterface>(ModelConnectionHintSourceInterface.class, this, MappingPackage.MODEL_CONNECTION_HINT__SOURCE_ELEMENTS);
		}
		return sourceElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public EList<SourceSectionAttribute> getSourceAttributes() {
		return this.getSourceAttributes();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModelConnectionHintSourceElement> getLocalSourceElements() {
				EList<ModelConnectionHintSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<ModelConnectionHintSourceElement>();
				
				for(ModelConnectionHintSourceInterface i : this.getSourceElements()){
					if(i instanceof ModelConnectionHintSourceElement){
						elements.add((ModelConnectionHintSourceElement) i);
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
	public EList<ModelConnectionHintExternalSourceElement> getExternalSourceElements() {
		EList<ModelConnectionHintExternalSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<>();
		
		for(ModelConnectionHintSourceInterface i : this.getSourceElements()){
			if(i instanceof ModelConnectionHintExternalSourceElement){
				elements.add((ModelConnectionHintExternalSourceElement) i);
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
			case MappingPackage.MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES:
				return ((InternalEList<?>)getTargetAttributes()).basicRemove(otherEnd, msgs);
			case MappingPackage.MODEL_CONNECTION_HINT__SOURCE_ELEMENTS:
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
			case MappingPackage.MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES:
				return getTargetAttributes();
			case MappingPackage.MODEL_CONNECTION_HINT__SOURCE_ELEMENTS:
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
			case MappingPackage.MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES:
				getTargetAttributes().clear();
				getTargetAttributes().addAll((Collection<? extends ModelConnectionHintTargetAttribute>)newValue);
				return;
			case MappingPackage.MODEL_CONNECTION_HINT__SOURCE_ELEMENTS:
				getSourceElements().clear();
				getSourceElements().addAll((Collection<? extends ModelConnectionHintSourceInterface>)newValue);
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
			case MappingPackage.MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES:
				getTargetAttributes().clear();
				return;
			case MappingPackage.MODEL_CONNECTION_HINT__SOURCE_ELEMENTS:
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
			case MappingPackage.MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES:
				return targetAttributes != null && !targetAttributes.isEmpty();
			case MappingPackage.MODEL_CONNECTION_HINT__SOURCE_ELEMENTS:
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
			case MappingPackage.MODEL_CONNECTION_HINT___GET_SOURCE_ATTRIBUTES:
				return getSourceAttributes();
			case MappingPackage.MODEL_CONNECTION_HINT___GET_LOCAL_SOURCE_ELEMENTS:
				return getLocalSourceElements();
			case MappingPackage.MODEL_CONNECTION_HINT___GET_EXTERNAL_SOURCE_ELEMENTS:
				return getExternalSourceElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ModelConnectionHintImpl
