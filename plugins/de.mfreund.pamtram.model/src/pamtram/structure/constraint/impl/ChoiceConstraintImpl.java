/**
 */
package pamtram.structure.constraint.impl;

import java.lang.reflect.InvocationTargetException;
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

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.FixedValue;
import pamtram.condition.ConditionPackage;
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.Mapping;
import pamtram.mapping.extended.GlobalAttributeImporter;
import pamtram.structure.InstanceSelectorExternalSourceElement;
import pamtram.structure.InstanceSelectorSourceElement;
import pamtram.structure.constraint.ChoiceConstraint;
import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.EqualityConstraint;
import pamtram.structure.constraint.SingleReferenceValueConstraint;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.constraint.ValueConstraintExternalSourceElement;
import pamtram.structure.constraint.ValueConstraintSourceElement;
import pamtram.structure.constraint.ValueConstraintType;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Choice Constraint</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.constraint.impl.ChoiceConstraintImpl#getType <em>Type</em>}</li>
 * <li>{@link pamtram.structure.constraint.impl.ChoiceConstraintImpl#getChoices <em>Choices</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChoiceConstraintImpl extends NamedElementImpl implements ChoiceConstraint {

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ValueConstraintType TYPE_EDEFAULT = ValueConstraintType.REQUIRED;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ValueConstraintType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChoices() <em>Choices</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getChoices()
	 * @generated
	 * @ordered
	 */
	protected EList<EqualityConstraint> choices;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.CHOICE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueConstraintType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(ValueConstraintType newType) {
		ValueConstraintType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.CHOICE_CONSTRAINT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EqualityConstraint> getChoices() {
		if (choices == null) {
			choices = new EObjectContainmentEList<EqualityConstraint>(EqualityConstraint.class, this, ConstraintPackage.CHOICE_CONSTRAINT__CHOICES);
		}
		return choices;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean checkConstraint(final String attrValue, final EList<String> refValue) {
		return refValue.stream().anyMatch(r -> r.equals(attrValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isLocalConstraint() {
		if (this instanceof ChoiceConstraint) {
			return ((ChoiceConstraint) this).getChoices().stream().allMatch(ValueConstraint::isLocalConstraint);
		}
		
		if (AgteleEcoreUtil.hasAncestorOfKind(this, SourcePackage.Literals.ACTUAL_SOURCE_SECTION_ATTRIBUTE)) {
			return true;
		}
		
		if (!(this instanceof SingleReferenceValueConstraint)
				|| !AgteleEcoreUtil.hasAncestorOfKind(this, ConditionPackage.Literals.ATTRIBUTE_CONDITION)) {
			throw new UnsupportedOperationException();
		}
		
		EObject container = this;
		
		while (!(container instanceof Mapping)) {
			if (container == null) {
				return false;
			}
			container = container.eContainer();
		}
		
		// The SourceSection of the Mapping that contains the constraint
		//
		SourceSection localSection = ((Mapping) container).getSourceSection();
		
		if (((SingleReferenceValueConstraint) this).getSourceElements().parallelStream()
				.allMatch(s -> s instanceof FixedValue || s instanceof GlobalAttributeImporter
						|| s instanceof ValueConstraintSourceElement && ((ValueConstraintSourceElement) s).getSource()
								.getContainingSection().equals(localSection)
						|| s instanceof ValueConstraintExternalSourceElement
								&& ((ValueConstraintExternalSourceElement) s).getSource().getContainingSection()
										.isContainerFor(localSection))) {
			return true;
		}
		
		// A constraint is also 'local' if an InstancePointer with local or external SourceAttributes exist
		//
		return ((SingleReferenceValueConstraint) this).getInstanceSelectors()
				.parallelStream()
				.flatMap(instanceSelector -> instanceSelector.getSourceElements().parallelStream()
						.filter(s -> s instanceof InstanceSelectorSourceElement
								|| s instanceof InstanceSelectorExternalSourceElement))
				.findAny().isPresent();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConstraintPackage.CHOICE_CONSTRAINT__CHOICES:
				return ((InternalEList<?>)getChoices()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.CHOICE_CONSTRAINT__TYPE:
				return getType();
			case ConstraintPackage.CHOICE_CONSTRAINT__CHOICES:
				return getChoices();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConstraintPackage.CHOICE_CONSTRAINT__TYPE:
				setType((ValueConstraintType)newValue);
				return;
			case ConstraintPackage.CHOICE_CONSTRAINT__CHOICES:
				getChoices().clear();
				getChoices().addAll((Collection<? extends EqualityConstraint>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConstraintPackage.CHOICE_CONSTRAINT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ConstraintPackage.CHOICE_CONSTRAINT__CHOICES:
				getChoices().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConstraintPackage.CHOICE_CONSTRAINT__TYPE:
				return type != TYPE_EDEFAULT;
			case ConstraintPackage.CHOICE_CONSTRAINT__CHOICES:
				return choices != null && !choices.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ConstraintPackage.CHOICE_CONSTRAINT___CHECK_CONSTRAINT__STRING_ELIST:
				return checkConstraint((String)arguments.get(0), (EList<String>)arguments.get(1));
			case ConstraintPackage.CHOICE_CONSTRAINT___IS_LOCAL_CONSTRAINT:
				return isLocalConstraint();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} // ChoiceConstraintImpl
