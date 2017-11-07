/**
 */
package pamtram.condition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.condition.ComparatorEnum;
import pamtram.condition.ComplexCondition;
import pamtram.condition.Condition;
import pamtram.condition.ConditionPackage;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Condition</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.condition.impl.ConditionImpl#getValue <em>Value</em>}</li>
 * <li>{@link pamtram.condition.impl.ConditionImpl#getComparator <em>Comparator</em>}</li>
 * <li>{@link pamtram.condition.impl.ConditionImpl#getTarget <em>Target</em>}</li>
 * <li>{@link pamtram.condition.impl.ConditionImpl#getInstanceSelectors <em>Instance Selectors</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConditionImpl<TargetType> extends ComplexConditionImpl implements Condition<TargetType> {

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final int VALUE_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected int value = ConditionImpl.VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getComparator() <em>Comparator</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getComparator()
	 * @generated
	 * @ordered
	 */
	protected static final ComparatorEnum COMPARATOR_EDEFAULT = ComparatorEnum.EQ;

	/**
	 * The cached value of the '{@link #getComparator() <em>Comparator</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getComparator()
	 * @generated
	 * @ordered
	 */
	protected ComparatorEnum comparator = ConditionImpl.COMPARATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected TargetType target;

	/**
	 * The cached value of the '{@link #getInstanceSelectors() <em>Instance Selectors</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInstanceSelectors()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceInstanceSelector> instanceSelectors;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ConditionImpl() {

		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return ConditionPackage.Literals.CONDITION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<SourceInstanceSelector> getInstanceSelectors() {

		if (this.instanceSelectors == null) {
			this.instanceSelectors = new EObjectContainmentEList<>(SourceInstanceSelector.class,
					this, ConditionPackage.CONDITION__INSTANCE_SELECTORS);
		}
		return this.instanceSelectors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ComparatorEnum getComparator() {

		return this.comparator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setComparator(ComparatorEnum newComparator) {

		ComparatorEnum oldComparator = this.comparator;
		this.comparator = newComparator == null ? ConditionImpl.COMPARATOR_EDEFAULT : newComparator;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.CONDITION__COMPARATOR,
					oldComparator, this.comparator));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public TargetType getTarget() {

		if (this.target != null && ((EObject) this.target).eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject) this.target;
			this.target = (TargetType) this.eResolveProxy(oldTarget);
			if (this.target != oldTarget) {
				if (this.eNotificationRequired()) {
					this.eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConditionPackage.CONDITION__TARGET,
							oldTarget, this.target));
				}
			}
		}
		return this.target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TargetType basicGetTarget() {

		return this.target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setTarget(TargetType newTarget) {

		TargetType oldTarget = this.target;
		this.target = newTarget;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.CONDITION__TARGET, oldTarget,
					this.target));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean checkCondition(ComplexCondition condition) {

		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {

		switch (featureID) {
			case ConditionPackage.CONDITION__INSTANCE_SELECTORS:
				return ((InternalEList<?>) this.getInstanceSelectors()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getValue() {

		return this.value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setValue(int newValue) {

		int oldValue = this.value;
		this.value = newValue;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.CONDITION__VALUE, oldValue,
					this.value));
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
			case ConditionPackage.CONDITION__VALUE:
				return this.getValue();
			case ConditionPackage.CONDITION__COMPARATOR:
				return this.getComparator();
			case ConditionPackage.CONDITION__TARGET:
				if (resolve) {
					return this.getTarget();
				}
				return this.basicGetTarget();
			case ConditionPackage.CONDITION__INSTANCE_SELECTORS:
				return this.getInstanceSelectors();
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
			case ConditionPackage.CONDITION__VALUE:
				this.setValue((Integer) newValue);
				return;
			case ConditionPackage.CONDITION__COMPARATOR:
				this.setComparator((ComparatorEnum) newValue);
				return;
			case ConditionPackage.CONDITION__TARGET:
				this.setTarget((TargetType) newValue);
				return;
			case ConditionPackage.CONDITION__INSTANCE_SELECTORS:
				this.getInstanceSelectors().clear();
				this.getInstanceSelectors().addAll((Collection<? extends SourceInstanceSelector>) newValue);
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
			case ConditionPackage.CONDITION__VALUE:
				this.setValue(ConditionImpl.VALUE_EDEFAULT);
				return;
			case ConditionPackage.CONDITION__COMPARATOR:
				this.setComparator(ConditionImpl.COMPARATOR_EDEFAULT);
				return;
			case ConditionPackage.CONDITION__TARGET:
				this.setTarget((TargetType) null);
				return;
			case ConditionPackage.CONDITION__INSTANCE_SELECTORS:
				this.getInstanceSelectors().clear();
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
			case ConditionPackage.CONDITION__VALUE:
				return this.value != ConditionImpl.VALUE_EDEFAULT;
			case ConditionPackage.CONDITION__COMPARATOR:
				return this.comparator != ConditionImpl.COMPARATOR_EDEFAULT;
			case ConditionPackage.CONDITION__TARGET:
				return this.target != null;
			case ConditionPackage.CONDITION__INSTANCE_SELECTORS:
				return this.instanceSelectors != null && !this.instanceSelectors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {

		switch (operationID) {
			case ConditionPackage.CONDITION___CHECK_CONDITION__COMPLEXCONDITION:
				return this.checkCondition((ComplexCondition) arguments.get(0));
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
		result.append(" (value: ");
		result.append(this.value);
		result.append(", comparator: ");
		result.append(this.comparator);
		result.append(')');
		return result.toString();
	}

	@Override
	public boolean isLocalCondition() {

		SourceSection localSection = this.getLocalSection();
		SourceSection affectedSection;
		try {
			affectedSection = this.getAffectedSection();
		} catch (ConditionEvaluationException e) {
			e.printStackTrace();
			return false;
		}

		if (localSection == null || affectedSection == null) {
			return false;
		}

		// Based on the 'affectedSection', we collect all other Sections that are indirectly affected (i.e. extended
		// sections)
		//
		Set<SourceSection> affectedSections = new HashSet<>();
		affectedSections.add(affectedSection);
		affectedSections.addAll(affectedSection.getAllExtend());

		// Based on the 'localSection', we collect all other Sections that are indirectly considered as local (e.g.
		// extended or container sections)
		//
		Set<SourceSection> localSections = new HashSet<>();
		localSections.add(localSection);
		localSections.addAll(localSection.getAllExtend());

		// A condition is local if it is based on the same section as the
		// containing mapping or if this section that is a direct or indirect
		// container section of the section referenced by the condition
		if (!Collections.disjoint(localSections, affectedSections)) {
			return true;
		}

		// A condition is also local if any of the local sections reference any of the classes affected by the condition
		//
		try {
			List<SourceSectionClass> affectedClasses = this.getAffectedClasses();
			if (localSections.stream()
					.anyMatch(l -> affectedClasses.stream().anyMatch(r -> r.isReferencedBy(l, null)))) {
				return true;
			}
		} catch (ConditionEvaluationException e) {
			e.printStackTrace();
		}

		// A condition is also 'local' if an InstanceSelector with local SourceAttributes exist
		//
		return this.getInstanceSelectors().parallelStream()
				.flatMap(instancePointer -> instancePointer.getSourceElements().parallelStream()
						.filter(s -> s instanceof pamtram.structure.InstanceSelectorSourceElement))
				.findAny().isPresent();
	}

	@Override
	public boolean isExternalCondition() {

		if (this.isLocalCondition()) {
			return false;
		}

		SourceSection localSection = this.getLocalSection();
		SourceSection affectedSection;
		try {
			affectedSection = this.getAffectedSection();
		} catch (ConditionEvaluationException e) {
			e.printStackTrace();
			return false;
		}

		if (localSection == null || affectedSection == null) {
			return false;
		}

		// Based on the 'localSection', we collect all external sections
		//
		Set<SourceSection> externalSections = new HashSet<>();
		externalSections.addAll(localSection.getAllContainer().stream().map(SourceSectionClass::getContainingSection)
				.collect(Collectors.toSet()));
		externalSections
				.addAll(externalSections.stream().flatMap(e -> e.getAllExtend().stream()).collect(Collectors.toSet()));

		// A condition is external if it is based on a container section of
		// the section referenced by the mapping
		//
		if (externalSections.contains(affectedSection)) {
			return true;
		}

		// A condition is also 'external' if an InstanceSelector with external SourceAttributes exist
		//
		return this.getInstanceSelectors().parallelStream()
				.flatMap(instancePointer -> instancePointer.getSourceElements().parallelStream()
						.filter(s -> s instanceof pamtram.structure.InstanceSelectorExternalSourceElement))
				.findAny().isPresent();
	}

} // ConditionImpl
