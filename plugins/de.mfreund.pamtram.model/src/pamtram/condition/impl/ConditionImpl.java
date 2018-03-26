/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.condition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.condition.ComparatorEnum;
import pamtram.condition.ComplexCondition;
import pamtram.condition.Condition;
import pamtram.condition.ConditionPackage;
import pamtram.structure.ExternalDynamicSourceElement;
import pamtram.structure.LocalDynamicSourceElement;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Condition</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.impl.ConditionImpl#getValue <em>Value</em>}</li>
 *   <li>{@link pamtram.condition.impl.ConditionImpl#getComparator <em>Comparator</em>}</li>
 *   <li>{@link pamtram.condition.impl.ConditionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link pamtram.condition.impl.ConditionImpl#getInstanceSelectors <em>Instance Selectors</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConditionImpl<TargetType> extends ComplexConditionImpl implements Condition<TargetType> {

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
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
	protected int value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getComparator() <em>Comparator</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getComparator()
	 * @generated
	 * @ordered
	 */
	protected static final ComparatorEnum COMPARATOR_EDEFAULT = ComparatorEnum.EQ;

	/**
	 * The cached value of the '{@link #getComparator() <em>Comparator</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getComparator()
	 * @generated
	 * @ordered
	 */
	protected ComparatorEnum comparator = COMPARATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected TargetType target;

	/**
	 * The cached value of the '{@link #getInstanceSelectors() <em>Instance Selectors</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInstanceSelectors()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceInstanceSelector> instanceSelectors;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.CONDITION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceInstanceSelector> getInstanceSelectors() {
	
		if (instanceSelectors == null) {
			instanceSelectors = new EObjectContainmentEList<SourceInstanceSelector>(SourceInstanceSelector.class, this, ConditionPackage.CONDITION__INSTANCE_SELECTORS);
		}
		return instanceSelectors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComparatorEnum getComparator() {
	
		return comparator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComparator(ComparatorEnum newComparator) {
	
		ComparatorEnum oldComparator = comparator;
		comparator = newComparator == null ? COMPARATOR_EDEFAULT : newComparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.CONDITION__COMPARATOR, oldComparator, comparator));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public TargetType getTarget() {
	
		  if (target != null && ((EObject)target).eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (TargetType)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConditionPackage.CONDITION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TargetType basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(TargetType newTarget) {
	
		TargetType oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.CONDITION__TARGET, oldTarget, target));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConditionPackage.CONDITION__INSTANCE_SELECTORS:
				return ((InternalEList<?>)getInstanceSelectors()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(int newValue) {
	
		int oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.CONDITION__VALUE, oldValue, value));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConditionPackage.CONDITION__VALUE:
				return getValue();
			case ConditionPackage.CONDITION__COMPARATOR:
				return getComparator();
			case ConditionPackage.CONDITION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ConditionPackage.CONDITION__INSTANCE_SELECTORS:
				return getInstanceSelectors();
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
			case ConditionPackage.CONDITION__VALUE:
				setValue((Integer)newValue);
				return;
			case ConditionPackage.CONDITION__COMPARATOR:
				setComparator((ComparatorEnum)newValue);
				return;
			case ConditionPackage.CONDITION__TARGET:
				setTarget((TargetType)newValue);
				return;
			case ConditionPackage.CONDITION__INSTANCE_SELECTORS:
				getInstanceSelectors().clear();
				getInstanceSelectors().addAll((Collection<? extends SourceInstanceSelector>)newValue);
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
			case ConditionPackage.CONDITION__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ConditionPackage.CONDITION__COMPARATOR:
				setComparator(COMPARATOR_EDEFAULT);
				return;
			case ConditionPackage.CONDITION__TARGET:
				setTarget((TargetType)null);
				return;
			case ConditionPackage.CONDITION__INSTANCE_SELECTORS:
				getInstanceSelectors().clear();
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
			case ConditionPackage.CONDITION__VALUE:
				return value != VALUE_EDEFAULT;
			case ConditionPackage.CONDITION__COMPARATOR:
				return comparator != COMPARATOR_EDEFAULT;
			case ConditionPackage.CONDITION__TARGET:
				return target != null;
			case ConditionPackage.CONDITION__INSTANCE_SELECTORS:
				return instanceSelectors != null && !instanceSelectors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ConditionPackage.CONDITION___CHECK_CONDITION__COMPLEXCONDITION:
				return checkCondition((ComplexCondition)arguments.get(0));
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
		result.append(" (value: ");
		result.append(value);
		result.append(", comparator: ");
		result.append(comparator);
		result.append(')');
		return result.toString();
	}

	@Override
	public boolean isLocalCondition() {

		// A condition with InstanceSelectors is always treated as not local
		//
		if (!this.getInstanceSelectors().isEmpty()) {
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

		// Based on the 'localSection', we collect all other Sections that are indirectly considered as local (e.g.
		// extended or container sections)
		//
		Set<SourceSection> localSections = new HashSet<>();
		localSections.add(localSection);
		localSections.addAll(localSection.getAllExtend());

		// A condition is local if it is based on the same section as the
		// containing mapping or any of the super-sections of this section
		if (localSections.contains(affectedSection)) {
			return true;
		}

		// A condition is also local if any of the local sections reference any of the classes affected by the condition
		//
		try {
			Set<SourceSectionClass> affectedClasses = this.getAffectedClasses();
			if (localSections.stream()
					.anyMatch(l -> affectedClasses.stream().anyMatch(r -> r.isReferencedBy(l, null)))) {
				return true;
			}
		} catch (ConditionEvaluationException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean isExternalCondition() {

		if (this.isLocalCondition()) {
			return false;
		}

		// A condition with InstanceSelectors is always treated as not external
		//
		if (!this.getInstanceSelectors().isEmpty()) {
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

		// A condition is also external if any of the external sections reference any of the classes affected by the
		// condition
		//
		try {
			Set<SourceSectionClass> affectedClasses = this.getAffectedClasses();
			if (externalSections.stream()
					.anyMatch(l -> affectedClasses.stream().anyMatch(r -> r.isReferencedBy(l, null)))) {
				return true;
			}
		} catch (ConditionEvaluationException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean isGlobalCondition() {

		if (this.isLocalCondition() || this.isExternalCondition()) {
			return false;
		}

		// A global condition must not be equipped with local or external source elements (e.g. for ValueConstraints or
		// InstanceSelectors)
		//
		TreeIterator<Object> it = EcoreUtil.getAllContents(this, true);
		while (it.hasNext()) {
			Object next = it.next();
			if (next instanceof LocalDynamicSourceElement<?, ?, ?, ?>
					|| next instanceof ExternalDynamicSourceElement<?, ?, ?, ?>) {
				return false;
			}
		}
		return true;
	}

} // ConditionImpl
