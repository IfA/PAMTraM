/**
 */
package pamtram.condition.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.ConditionalElement;
import pamtram.condition.ApplicationDependency;
import pamtram.condition.ConditionPackage;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.structure.source.SourceSection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Application Dependency</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.condition.impl.ApplicationDependencyImpl#getConditionalElement <em>Conditional Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationDependencyImpl extends ConditionImpl implements ApplicationDependency {

	/**
	 * The cached value of the '{@link #getTarget() <em>Conditional Element</em>}' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected ConditionalElement conditionalElement;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ApplicationDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return ConditionPackage.Literals.APPLICATION_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ConditionalElement getTarget() {

		if (this.conditionalElement != null && this.conditionalElement.eIsProxy()) {
			InternalEObject oldConditionalElement = (InternalEObject) this.conditionalElement;
			this.conditionalElement = (ConditionalElement) this.eResolveProxy(oldConditionalElement);
			if (this.conditionalElement != oldConditionalElement) {
				if (this.eNotificationRequired()) {
					this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ConditionPackage.APPLICATION_DEPENDENCY__TARGET, oldConditionalElement,
							this.conditionalElement));
				}
			}
		}
		return this.conditionalElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ConditionalElement basicGetConditionalElement() {

		return this.conditionalElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setTarget(ConditionalElement newConditionalElement) {

		ConditionalElement oldConditionalElement = this.conditionalElement;
		this.conditionalElement = newConditionalElement;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.APPLICATION_DEPENDENCY__TARGET,
					oldConditionalElement, this.conditionalElement));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case ConditionPackage.APPLICATION_DEPENDENCY__TARGET:
				if (resolve) {
					return this.getTarget();
				}
				return this.basicGetConditionalElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {

		switch (featureID) {
			case ConditionPackage.APPLICATION_DEPENDENCY__TARGET:
				this.setTarget((ConditionalElement) newValue);
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
			case ConditionPackage.APPLICATION_DEPENDENCY__TARGET:
				this.setTarget((ConditionalElement) null);
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
			case ConditionPackage.APPLICATION_DEPENDENCY__TARGET:
				return this.conditionalElement != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean isLocalCondition() {

		Mapping mapping = null;
		if (this.getTarget() instanceof Mapping) {
			mapping = (Mapping) this.getTarget();
		} else if (this.getTarget() instanceof InstantiableMappingHintGroup) {
			mapping = (Mapping) this.getTarget().eContainer();
		} else if (this.getTarget() instanceof MappingHint) {
			mapping = (Mapping) this.getTarget().eContainer().eContainer();
		} else {
			throw new RuntimeException(
					"Unknown type of ConditionalElement '" + this.getTarget().eClass().getName() + "' found!");
		}

		SourceSection sourceSection = mapping.getSourceSection();

		if (sourceSection == null) {
			return false;
		}

		// The SourceSection that the condition references
		//
		SourceSection referencedSection = sourceSection.getContainingSection();

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

		if (referencedSection.equals(localSection)) {
			return true;
		}

		// A condition is also 'local' if an InstanceSelector with local or external SourceAttributes exist
		//
		return this.getInstanceSelectors().parallelStream()
				.flatMap(instancePointer -> instancePointer.getSourceElements().parallelStream()
						.filter(s -> s instanceof pamtram.structure.InstanceSelectorSourceElement
								|| s instanceof pamtram.structure.InstanceSelectorExternalSourceElement))
				.findAny().isPresent();
	}

} // ApplicationDependencyImpl
