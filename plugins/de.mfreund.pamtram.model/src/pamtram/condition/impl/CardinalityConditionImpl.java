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
 *   <li>{@link pamtram.condition.impl.CardinalityConditionImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CardinalityConditionImpl extends ConditionImpl implements CardinalityCondition {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected SourceSectionClass target;
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
	public SourceSectionClass getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (SourceSectionClass)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConditionPackage.CARDINALITY_CONDITION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(SourceSectionClass newTarget) {
		SourceSectionClass oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.CARDINALITY_CONDITION__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConditionPackage.CARDINALITY_CONDITION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case ConditionPackage.CARDINALITY_CONDITION__TARGET:
				setTarget((SourceSectionClass)newValue);
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
			case ConditionPackage.CARDINALITY_CONDITION__TARGET:
				setTarget((SourceSectionClass)null);
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
			case ConditionPackage.CARDINALITY_CONDITION__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public boolean isLocalCondition() {
		
		if(getTarget() == null) {
			return false;
		}
		
		// The SourceSection that the condition references
		//
		SourceSection referencedSection = getTarget().getContainingSection();
		
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
		
		// A condition is also 'local' if an InstanceSelector with local or external SourceAttributes exist
		//
		return getInstanceSelectors().parallelStream().flatMap(
				instancePointer -> instancePointer.getSourceElements().parallelStream().filter(
						s -> s instanceof pamtram.structure.InstanceSelectorSourceElement || 
						s instanceof pamtram.structure.InstanceSelectorExternalSourceElement)
				).findAny().isPresent();
	}

} //SectionConditionImpl
