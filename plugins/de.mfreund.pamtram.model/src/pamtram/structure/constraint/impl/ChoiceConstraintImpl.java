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
import pamtram.condition.ConditionPackage;
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.Mapping;
import pamtram.structure.InstancePointerExternalSourceElement;
import pamtram.structure.InstancePointerSourceElement;
import pamtram.structure.SourceSection;
import pamtram.structure.StructurePackage;
import pamtram.structure.constraint.ChoiceConstraint;
import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.EqualityConstraint;
import pamtram.structure.constraint.SingleReferenceValueConstraint;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.constraint.ValueConstraintExternalSourceElement;
import pamtram.structure.constraint.ValueConstraintSourceElement;
import pamtram.structure.constraint.ValueConstraintType;

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
	protected ValueConstraintType type = ChoiceConstraintImpl.TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChoices() <em>Choices</em>}' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getChoices()
	 * @generated
	 * @ordered
	 */
	protected EList<EqualityConstraint> choices;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ChoiceConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return ConstraintPackage.Literals.CHOICE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ValueConstraintType getType() {

		return this.type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setType(ValueConstraintType newType) {

		ValueConstraintType oldType = this.type;
		this.type = newType == null ? ChoiceConstraintImpl.TYPE_EDEFAULT : newType;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.CHOICE_CONSTRAINT__TYPE,
					oldType, this.type));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<EqualityConstraint> getChoices() {

		if (this.choices == null) {
			this.choices = new EObjectContainmentEList<>(EqualityConstraint.class, this,
					ConstraintPackage.CHOICE_CONSTRAINT__CHOICES);
		}
		return this.choices;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean checkConstraint(String attrValue, EList<String> refValue) {

		boolean condition = refValue.stream().anyMatch(s -> s.equals(attrValue));

		return condition && this.type.equals(ValueConstraintType.REQUIRED)
				|| !condition && this.type.equals(ValueConstraintType.FORBIDDEN);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isLocalConstraint() {

		if (this instanceof ChoiceConstraint) {
			return ((ChoiceConstraint) this).getChoices().stream().allMatch(ValueConstraint::isLocalConstraint);
		}

		if (AgteleEcoreUtil.hasAncestorOfKind(this, StructurePackage.Literals.ACTUAL_SOURCE_SECTION_ATTRIBUTE)) {
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
		return ((SingleReferenceValueConstraint) this).getConstraintReferenceValueAdditionalSpecification()
				.parallelStream()
				.flatMap(instancePointer -> instancePointer.getSourceElements().parallelStream()
						.filter(s -> s instanceof InstancePointerSourceElement
								|| s instanceof InstancePointerExternalSourceElement))
				.findAny().isPresent();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {

		switch (featureID) {
			case ConstraintPackage.CHOICE_CONSTRAINT__CHOICES:
				return ((InternalEList<?>) this.getChoices()).basicRemove(otherEnd, msgs);
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
			case ConstraintPackage.CHOICE_CONSTRAINT__TYPE:
				return this.getType();
			case ConstraintPackage.CHOICE_CONSTRAINT__CHOICES:
				return this.getChoices();
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
			case ConstraintPackage.CHOICE_CONSTRAINT__TYPE:
				this.setType((ValueConstraintType) newValue);
				return;
			case ConstraintPackage.CHOICE_CONSTRAINT__CHOICES:
				this.getChoices().clear();
				this.getChoices().addAll((Collection<? extends EqualityConstraint>) newValue);
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
			case ConstraintPackage.CHOICE_CONSTRAINT__TYPE:
				this.setType(ChoiceConstraintImpl.TYPE_EDEFAULT);
				return;
			case ConstraintPackage.CHOICE_CONSTRAINT__CHOICES:
				this.getChoices().clear();
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
			case ConstraintPackage.CHOICE_CONSTRAINT__TYPE:
				return this.type != ChoiceConstraintImpl.TYPE_EDEFAULT;
			case ConstraintPackage.CHOICE_CONSTRAINT__CHOICES:
				return this.choices != null && !this.choices.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {

		switch (operationID) {
			case ConstraintPackage.CHOICE_CONSTRAINT___CHECK_CONSTRAINT__STRING_ELIST:
				return this.checkConstraint((String) arguments.get(0), (EList<String>) arguments.get(1));
			case ConstraintPackage.CHOICE_CONSTRAINT___IS_LOCAL_CONSTRAINT:
				return this.isLocalConstraint();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {

		if (this.eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(this.type);
		result.append(')');
		return result.toString();
	}

} // ChoiceConstraintImpl
