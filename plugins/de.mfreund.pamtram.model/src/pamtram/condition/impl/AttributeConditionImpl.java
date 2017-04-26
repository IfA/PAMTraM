/**
 */
package pamtram.condition.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.condition.AttributeCondition;
import pamtram.condition.ConditionPackage;
import pamtram.mapping.Mapping;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Attribute Condition</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.condition.impl.AttributeConditionImpl#getValueConstraints
 * <em>Value Constraints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeConditionImpl extends ConditionImpl<ActualSourceSectionAttribute> implements AttributeCondition {
	/**
	 * The cached value of the '{@link #getValueConstraints() <em>Value
	 * Constraints</em>}' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getValueConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueConstraint> valueConstraints;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected AttributeConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.ATTRIBUTE_CONDITION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<ValueConstraint> getValueConstraints() {
		if (this.valueConstraints == null) {
			this.valueConstraints = new EObjectContainmentEList<>(ValueConstraint.class, this,
					ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS);
		}
		return this.valueConstraints;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the
	 * more specific type known in this context.
	 *
	 * @generated
	 */
	@Override
	public void setTarget(ActualSourceSectionAttribute newTarget) {
		super.setTarget(newTarget);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS:
			return ((InternalEList<?>) this.getValueConstraints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS:
			return this.getValueConstraints();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS:
			this.getValueConstraints().clear();
			this.getValueConstraints().addAll((Collection<? extends ValueConstraint>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS:
			this.getValueConstraints().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS:
			return this.valueConstraints != null && !this.valueConstraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean isLocalCondition() {

		if (this.getTarget() == null) {
			return false;
		}

		// The SourceSection that the condition references
		//
		SourceSectionClass referencedSection = this.getTarget().getContainingSection();

		EObject container = this;

		while (!(container instanceof Mapping)) {
			if (container == null) {
				return false;
			}
			container = container.eContainer();
		}

		// The SourceSection of the Mapping that contains the condition
		//
		SourceSection localSection = ((Mapping) container).getSourceSection();

		// A condition is local if it is based on the same section as the
		// containing mapping or if this section that is a direct or indirect
		// container section of the section referenced by the condition
		//
		do {
			if (referencedSection.equals(localSection)) {
				return true;
			}
		} while (referencedSection.getContainer() != null
				&& (referencedSection = referencedSection.getContainer().getContainingSection()) != null);

		// A condition is also 'local' if an InstanceSelector with local or
		// external SourceAttributes exist
		//
		return this.getInstanceSelectors().parallelStream()
				.flatMap(instancePointer -> instancePointer.getSourceElements().parallelStream()
						.filter(s -> s instanceof pamtram.structure.InstanceSelectorSourceElement
								|| s instanceof pamtram.structure.InstanceSelectorExternalSourceElement))
				.findAny().isPresent();
	}

} // AttributeConditionImpl
