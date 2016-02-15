/**
 */
package pamtram.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.RangeBound;
import pamtram.metamodel.RangeConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.RangeConstraintImpl#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.RangeConstraintImpl#getLowerBound <em>Lower Bound</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RangeConstraintImpl extends MultipleReferencesAttributeValueConstraintImpl implements RangeConstraint {
	/**
	 * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected RangeBound upperBound;

	/**
	 * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected RangeBound lowerBound;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RangeConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.RANGE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeBound getUpperBound() {
		if (upperBound != null && upperBound.eIsProxy()) {
			InternalEObject oldUpperBound = (InternalEObject)upperBound;
			upperBound = (RangeBound)eResolveProxy(oldUpperBound);
			if (upperBound != oldUpperBound) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.RANGE_CONSTRAINT__UPPER_BOUND, oldUpperBound, upperBound));
			}
		}
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeBound basicGetUpperBound() {
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBound(RangeBound newUpperBound) {
		RangeBound oldUpperBound = upperBound;
		upperBound = newUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.RANGE_CONSTRAINT__UPPER_BOUND, oldUpperBound, upperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeBound getLowerBound() {
		if (lowerBound != null && lowerBound.eIsProxy()) {
			InternalEObject oldLowerBound = (InternalEObject)lowerBound;
			lowerBound = (RangeBound)eResolveProxy(oldLowerBound);
			if (lowerBound != oldLowerBound) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.RANGE_CONSTRAINT__LOWER_BOUND, oldLowerBound, lowerBound));
			}
		}
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeBound basicGetLowerBound() {
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(RangeBound newLowerBound) {
		RangeBound oldLowerBound = lowerBound;
		lowerBound = newLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.RANGE_CONSTRAINT__LOWER_BOUND, oldLowerBound, lowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.RANGE_CONSTRAINT__UPPER_BOUND:
				if (resolve) return getUpperBound();
				return basicGetUpperBound();
			case MetamodelPackage.RANGE_CONSTRAINT__LOWER_BOUND:
				if (resolve) return getLowerBound();
				return basicGetLowerBound();
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
			case MetamodelPackage.RANGE_CONSTRAINT__UPPER_BOUND:
				setUpperBound((RangeBound)newValue);
				return;
			case MetamodelPackage.RANGE_CONSTRAINT__LOWER_BOUND:
				setLowerBound((RangeBound)newValue);
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
			case MetamodelPackage.RANGE_CONSTRAINT__UPPER_BOUND:
				setUpperBound((RangeBound)null);
				return;
			case MetamodelPackage.RANGE_CONSTRAINT__LOWER_BOUND:
				setLowerBound((RangeBound)null);
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
			case MetamodelPackage.RANGE_CONSTRAINT__UPPER_BOUND:
				return upperBound != null;
			case MetamodelPackage.RANGE_CONSTRAINT__LOWER_BOUND:
				return lowerBound != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public boolean checkConstraint(String attrValue) {
		boolean lowerBoundResult=true,upperBoundResult=true; //Keep True in case no rangeBound were established 
		
		// Firstly, check the attrValue corresponding to his lowerBound and secondly, with his upperBound. (Order doesn't matter)
		if (this.getLowerBound()!=null){
			if(this.getLowerBound().getBoundType().equals(AttributeValueConstraintType.INCLUSION)){
				lowerBoundResult = Double.parseDouble(attrValue) >= Double.parseDouble(this.getLowerBound().getExpression());
			}
			else if (this.getLowerBound().getBoundType().equals(AttributeValueConstraintType.EXCLUSION)){
				lowerBoundResult = Double.parseDouble(attrValue) > Double.parseDouble(this.getLowerBound().getExpression());
			}
		}
		if (this.getUpperBound()!=null){
			if(this.getUpperBound().getBoundType().equals(AttributeValueConstraintType.INCLUSION)){
				upperBoundResult = Double.parseDouble(attrValue) <= Double.parseDouble(this.getUpperBound().getExpression());
			}
			else if (this.getUpperBound().getBoundType().equals(AttributeValueConstraintType.EXCLUSION)){
				upperBoundResult = Double.parseDouble(attrValue) < Double.parseDouble(this.getUpperBound().getExpression());
			}
		}
		return lowerBoundResult && upperBoundResult; //Combine (And) the results of each rangeBounds
	}

} //RangeConstraintImpl
