/**
 */
package pamtram.structure.constraint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.RangeBound;
import pamtram.structure.constraint.RangeConstraint;
import pamtram.structure.constraint.ValueConstraintType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Range Constraint</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.constraint.impl.RangeConstraintImpl#getUpperBound <em>Upper Bound</em>}</li>
 * <li>{@link pamtram.structure.constraint.impl.RangeConstraintImpl#getLowerBound <em>Lower Bound</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RangeConstraintImpl extends MultipleReferencesValueConstraintImpl implements RangeConstraint {

	/**
	 * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected RangeBound upperBound;

	/**
	 * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected RangeBound lowerBound;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RangeConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.RANGE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RangeBound getUpperBound() {
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUpperBound(RangeBound newUpperBound, NotificationChain msgs) {
		RangeBound oldUpperBound = upperBound;
		upperBound = newUpperBound;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConstraintPackage.RANGE_CONSTRAINT__UPPER_BOUND, oldUpperBound, newUpperBound);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUpperBound(RangeBound newUpperBound) {
		if (newUpperBound != upperBound) {
			NotificationChain msgs = null;
			if (upperBound != null)
				msgs = ((InternalEObject)upperBound).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConstraintPackage.RANGE_CONSTRAINT__UPPER_BOUND, null, msgs);
			if (newUpperBound != null)
				msgs = ((InternalEObject)newUpperBound).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConstraintPackage.RANGE_CONSTRAINT__UPPER_BOUND, null, msgs);
			msgs = basicSetUpperBound(newUpperBound, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.RANGE_CONSTRAINT__UPPER_BOUND, newUpperBound, newUpperBound));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RangeBound getLowerBound() {
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLowerBound(RangeBound newLowerBound, NotificationChain msgs) {
		RangeBound oldLowerBound = lowerBound;
		lowerBound = newLowerBound;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConstraintPackage.RANGE_CONSTRAINT__LOWER_BOUND, oldLowerBound, newLowerBound);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLowerBound(RangeBound newLowerBound) {
		if (newLowerBound != lowerBound) {
			NotificationChain msgs = null;
			if (lowerBound != null)
				msgs = ((InternalEObject)lowerBound).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConstraintPackage.RANGE_CONSTRAINT__LOWER_BOUND, null, msgs);
			if (newLowerBound != null)
				msgs = ((InternalEObject)newLowerBound).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConstraintPackage.RANGE_CONSTRAINT__LOWER_BOUND, null, msgs);
			msgs = basicSetLowerBound(newLowerBound, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.RANGE_CONSTRAINT__LOWER_BOUND, newLowerBound, newLowerBound));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConstraintPackage.RANGE_CONSTRAINT__UPPER_BOUND:
				return basicSetUpperBound(null, msgs);
			case ConstraintPackage.RANGE_CONSTRAINT__LOWER_BOUND:
				return basicSetLowerBound(null, msgs);
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
			case ConstraintPackage.RANGE_CONSTRAINT__UPPER_BOUND:
				return getUpperBound();
			case ConstraintPackage.RANGE_CONSTRAINT__LOWER_BOUND:
				return getLowerBound();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConstraintPackage.RANGE_CONSTRAINT__UPPER_BOUND:
				setUpperBound((RangeBound)newValue);
				return;
			case ConstraintPackage.RANGE_CONSTRAINT__LOWER_BOUND:
				setLowerBound((RangeBound)newValue);
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
			case ConstraintPackage.RANGE_CONSTRAINT__UPPER_BOUND:
				setUpperBound((RangeBound)null);
				return;
			case ConstraintPackage.RANGE_CONSTRAINT__LOWER_BOUND:
				setLowerBound((RangeBound)null);
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
			case ConstraintPackage.RANGE_CONSTRAINT__UPPER_BOUND:
				return upperBound != null;
			case ConstraintPackage.RANGE_CONSTRAINT__LOWER_BOUND:
				return lowerBound != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean checkConstraint(String attrValue, EList<String> refValue) {

		boolean lowerBoundResult = true, upperBoundResult = true; // Keep True in case no rangeBound were established
		String lowerBoundRefValue = refValue.get(0);
		String upperBoundRefValue = refValue.get(1);

		// Firstly, check the attrValue corresponding to his lowerBound and secondly, with his upperBound. (Order
		// doesn't matter)
		if (lowerBoundRefValue == "null") {
			lowerBoundResult = true; // Keep True if no rangeBound were modeled
		} else {
			try {
				if (this.getLowerBound().getBoundType().equals(ValueConstraintType.REQUIRED)) {
					lowerBoundResult = Double.valueOf(attrValue) >= Double.valueOf(lowerBoundRefValue);
				} else if (this.getLowerBound().getBoundType().equals(ValueConstraintType.FORBIDDEN)) {
					lowerBoundResult = Double.valueOf(attrValue) > Double.valueOf(lowerBoundRefValue);
				}
			} catch (NumberFormatException e) {
				lowerBoundResult = false;
			}
		}

		if (upperBoundRefValue == "null") {
			upperBoundResult = true; // Keep True if no rangeBound were modeled
		} else {
			try {
				if (refValue.get(1) != null) {
					if (this.getUpperBound().getBoundType().equals(ValueConstraintType.REQUIRED)) {
						upperBoundResult = Double.valueOf(attrValue) <= Double.valueOf(upperBoundRefValue);
					} else if (this.getUpperBound().getBoundType().equals(ValueConstraintType.FORBIDDEN)) {
						upperBoundResult = Double.valueOf(attrValue) < Double.valueOf(upperBoundRefValue);
					}
				}
			} catch (NumberFormatException e) {
				upperBoundResult = false;
			}
		}

		return lowerBoundResult && upperBoundResult; // Combine the results of each rangeBound (And = &&)
	}

} // RangeConstraintImpl
