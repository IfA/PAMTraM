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
import pamtram.metamodel.SourceSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.impl.ApplicationDependencyImpl#getConditionalElement <em>Conditional Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationDependencyImpl extends ConditionImpl implements ApplicationDependency {
	/**
	 * The cached value of the '{@link #getConditionalElement() <em>Conditional Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionalElement()
	 * @generated
	 * @ordered
	 */
	protected ConditionalElement conditionalElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.APPLICATION_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConditionalElement getConditionalElement() {
		if (conditionalElement != null && conditionalElement.eIsProxy()) {
			InternalEObject oldConditionalElement = (InternalEObject)conditionalElement;
			conditionalElement = (ConditionalElement)eResolveProxy(oldConditionalElement);
			if (conditionalElement != oldConditionalElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConditionPackage.APPLICATION_DEPENDENCY__CONDITIONAL_ELEMENT, oldConditionalElement, conditionalElement));
			}
		}
		return conditionalElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalElement basicGetConditionalElement() {
		return conditionalElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConditionalElement(ConditionalElement newConditionalElement) {
		ConditionalElement oldConditionalElement = conditionalElement;
		conditionalElement = newConditionalElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.APPLICATION_DEPENDENCY__CONDITIONAL_ELEMENT, oldConditionalElement, conditionalElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConditionPackage.APPLICATION_DEPENDENCY__CONDITIONAL_ELEMENT:
				if (resolve) return getConditionalElement();
				return basicGetConditionalElement();
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
			case ConditionPackage.APPLICATION_DEPENDENCY__CONDITIONAL_ELEMENT:
				setConditionalElement((ConditionalElement)newValue);
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
			case ConditionPackage.APPLICATION_DEPENDENCY__CONDITIONAL_ELEMENT:
				setConditionalElement((ConditionalElement)null);
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
			case ConditionPackage.APPLICATION_DEPENDENCY__CONDITIONAL_ELEMENT:
				return conditionalElement != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean isLocalCondition() {

		Mapping mapping = null;
		if (this.conditionalElement instanceof Mapping) {
			mapping = (Mapping) this.conditionalElement;
		} else if (this.conditionalElement instanceof InstantiableMappingHintGroup) {
			mapping = (Mapping) this.conditionalElement.eContainer();
		} else if (this.conditionalElement instanceof MappingHint) {
			mapping = (Mapping) this.conditionalElement.eContainer().eContainer();
		} else {
			throw new RuntimeException(
					"Unknown type of ConditionalElement '" + this.conditionalElement.eClass().getName() + "' found!");
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

		// A condition is also 'local' if an InstancePointer with local or external SourceAttributes exist
		//
		return this.getAdditionalConditionSpecification().parallelStream()
				.flatMap(instancePointer -> instancePointer.getSourceElements().parallelStream()
						.filter(s -> s instanceof pamtram.metamodel.InstancePointerSourceElement
								|| s instanceof pamtram.metamodel.InstancePointerExternalSourceElement))
				.findAny().isPresent();
	}

} //ApplicationDependencyImpl
