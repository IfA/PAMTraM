/**
 */
package pamtram.condition.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import pamtram.condition.AttributeCondition;
import pamtram.condition.ConditionPackage;
import pamtram.mapping.Mapping;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.impl.AttributeConditionImpl#getValueConstraint <em>Value Constraint</em>}</li>
 *   <li>{@link pamtram.condition.impl.AttributeConditionImpl#getConditionAttributeRef <em>Condition Attribute Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeConditionImpl extends ConditionImpl implements AttributeCondition {
	/**
	 * The cached value of the '{@link #getValueConstraints() <em>Value Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueConstraint> valueConstraint;

	/**
	 * The cached value of the '{@link #getConditionAttributeRef() <em>Condition Attribute Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionAttributeRef()
	 * @generated
	 * @ordered
	 */
	protected ActualSourceSectionAttribute conditionAttributeRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.ATTRIBUTE_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValueConstraint> getValueConstraints() {
		if (valueConstraint == null) {
			valueConstraint = new EObjectContainmentEList<ValueConstraint>(ValueConstraint.class, this, ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS);
		}
		return valueConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualSourceSectionAttribute getConditionAttributeRef() {
		if (conditionAttributeRef != null && conditionAttributeRef.eIsProxy()) {
			InternalEObject oldConditionAttributeRef = (InternalEObject)conditionAttributeRef;
			conditionAttributeRef = (ActualSourceSectionAttribute)eResolveProxy(oldConditionAttributeRef);
			if (conditionAttributeRef != oldConditionAttributeRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConditionPackage.ATTRIBUTE_CONDITION__CONDITION_ATTRIBUTE_REF, oldConditionAttributeRef, conditionAttributeRef));
			}
		}
		return conditionAttributeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualSourceSectionAttribute basicGetConditionAttributeRef() {
		return conditionAttributeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionAttributeRef(ActualSourceSectionAttribute newConditionAttributeRef) {
		ActualSourceSectionAttribute oldConditionAttributeRef = conditionAttributeRef;
		conditionAttributeRef = newConditionAttributeRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.ATTRIBUTE_CONDITION__CONDITION_ATTRIBUTE_REF, oldConditionAttributeRef, conditionAttributeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS:
				return ((InternalEList<?>)getValueConstraints()).basicRemove(otherEnd, msgs);
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
			case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS:
				return getValueConstraints();
			case ConditionPackage.ATTRIBUTE_CONDITION__CONDITION_ATTRIBUTE_REF:
				if (resolve) return getConditionAttributeRef();
				return basicGetConditionAttributeRef();
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
			case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS:
				getValueConstraints().clear();
				getValueConstraints().addAll((Collection<? extends ValueConstraint>)newValue);
				return;
			case ConditionPackage.ATTRIBUTE_CONDITION__CONDITION_ATTRIBUTE_REF:
				setConditionAttributeRef((ActualSourceSectionAttribute)newValue);
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
			case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS:
				getValueConstraints().clear();
				return;
			case ConditionPackage.ATTRIBUTE_CONDITION__CONDITION_ATTRIBUTE_REF:
				setConditionAttributeRef((ActualSourceSectionAttribute)null);
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
			case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS:
				return valueConstraint != null && !valueConstraint.isEmpty();
			case ConditionPackage.ATTRIBUTE_CONDITION__CONDITION_ATTRIBUTE_REF:
				return conditionAttributeRef != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public boolean isLocalCondition() {
		
		if(getConditionAttributeRef() == null) {
			return false;
		}
		
		// The SourceSection that the condition references
		//
		SourceSection referencedSection = getConditionAttributeRef().getContainingSection();
		
		EObject container = this;
		
		while(!(container instanceof Mapping)) {
			if(container == null) {
				return false;
			}
			container = container.eContainer();
		}
		
		// The SourceSection of the Mapping that contains the condition
		//
		SourceSection localSection = ((Mapping) container).getSourceSection();
		
		if(referencedSection.equals(localSection)) {
			return true;
		}
		
		// A condition is also 'local' if an InstancePointer with local or external SourceAttributes exist
		//
		return getAdditionalConditionSpecification().parallelStream().flatMap(
				instancePointer -> instancePointer.getSourceElements().parallelStream().filter(
						s -> s instanceof pamtram.structure.InstancePointerSourceElement || 
						s instanceof pamtram.structure.InstancePointerExternalSourceElement)
				).findAny().isPresent();
	}

} //AttributeConditionImpl
