/**
 */
package pamtram.condition.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import pamtram.condition.ConditionPackage;
import pamtram.condition.CardinalityCondition;
import pamtram.mapping.Mapping;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Section Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.impl.CardinalityConditionImpl#getConditionSectionRef <em>Condition Section Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CardinalityConditionImpl extends ConditionImpl implements CardinalityCondition {
	/**
	 * The cached value of the '{@link #getConditionSectionRef() <em>Condition Section Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionSectionRef()
	 * @generated
	 * @ordered
	 */
	protected SourceSectionClass conditionSectionRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CardinalityConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.CARDINALITY_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass getConditionSectionRef() {
		if (conditionSectionRef != null && conditionSectionRef.eIsProxy()) {
			InternalEObject oldConditionSectionRef = (InternalEObject)conditionSectionRef;
			conditionSectionRef = (SourceSectionClass)eResolveProxy(oldConditionSectionRef);
			if (conditionSectionRef != oldConditionSectionRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConditionPackage.CARDINALITY_CONDITION__CONDITION_SECTION_REF, oldConditionSectionRef, conditionSectionRef));
			}
		}
		return conditionSectionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass basicGetConditionSectionRef() {
		return conditionSectionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionSectionRef(SourceSectionClass newConditionSectionRef) {
		SourceSectionClass oldConditionSectionRef = conditionSectionRef;
		conditionSectionRef = newConditionSectionRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.CARDINALITY_CONDITION__CONDITION_SECTION_REF, oldConditionSectionRef, conditionSectionRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConditionPackage.CARDINALITY_CONDITION__CONDITION_SECTION_REF:
				if (resolve) return getConditionSectionRef();
				return basicGetConditionSectionRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConditionPackage.CARDINALITY_CONDITION__CONDITION_SECTION_REF:
				setConditionSectionRef((SourceSectionClass)newValue);
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
			case ConditionPackage.CARDINALITY_CONDITION__CONDITION_SECTION_REF:
				setConditionSectionRef((SourceSectionClass)null);
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
			case ConditionPackage.CARDINALITY_CONDITION__CONDITION_SECTION_REF:
				return conditionSectionRef != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public boolean isLocalCondition() {
		
		if(getConditionSectionRef() == null) {
			return false;
		}
		
		// The SourceSection that the condition references
		//
		SourceSection referencedSection = getConditionSectionRef().getContainingSection();
		
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

} //SectionConditionImpl
