/**
 */
package pamtram.metamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.ReferenceableElement;

import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.RangeBound;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range Bound</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.RangeBoundImpl#getBoundReferenceValue <em>Bound Reference Value</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.RangeBoundImpl#getBoundType <em>Bound Type</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.RangeBoundImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.RangeBoundImpl#getBoundReferenceValueAdditionalSpecification <em>Bound Reference Value Additional Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RangeBoundImpl extends MinimalEObjectImpl.Container implements RangeBound {
	/**
	 * The cached value of the '{@link #getBoundReferenceValue() <em>Bound Reference Value</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundReferenceValue()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceableElement> boundReferenceValue;

	/**
	 * The default value of the '{@link #getBoundType() <em>Bound Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundType()
	 * @generated
	 * @ordered
	 */
	protected static final AttributeValueConstraintType BOUND_TYPE_EDEFAULT = AttributeValueConstraintType.INCLUSION;

	/**
	 * The cached value of the '{@link #getBoundType() <em>Bound Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundType()
	 * @generated
	 * @ordered
	 */
	protected AttributeValueConstraintType boundType = BOUND_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected String expression = EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBoundReferenceValueAdditionalSpecification() <em>Bound Reference Value Additional Specification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundReferenceValueAdditionalSpecification()
	 * @generated
	 * @ordered
	 */
	protected EList<InstancePointer> boundReferenceValueAdditionalSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RangeBoundImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.RANGE_BOUND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReferenceableElement> getBoundReferenceValue() {
		if (boundReferenceValue == null) {
			boundReferenceValue = new EObjectResolvingEList<ReferenceableElement>(ReferenceableElement.class, this, MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE);
		}
		return boundReferenceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueConstraintType getBoundType() {
		return boundType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundType(AttributeValueConstraintType newBoundType) {
		AttributeValueConstraintType oldBoundType = boundType;
		boundType = newBoundType == null ? BOUND_TYPE_EDEFAULT : newBoundType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.RANGE_BOUND__BOUND_TYPE, oldBoundType, boundType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(String newExpression) {
		String oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.RANGE_BOUND__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstancePointer> getBoundReferenceValueAdditionalSpecification() {
		if (boundReferenceValueAdditionalSpecification == null) {
			boundReferenceValueAdditionalSpecification = new EObjectContainmentEList<InstancePointer>(InstancePointer.class, this, MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION);
		}
		return boundReferenceValueAdditionalSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				return ((InternalEList<?>)getBoundReferenceValueAdditionalSpecification()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE:
				return getBoundReferenceValue();
			case MetamodelPackage.RANGE_BOUND__BOUND_TYPE:
				return getBoundType();
			case MetamodelPackage.RANGE_BOUND__EXPRESSION:
				return getExpression();
			case MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				return getBoundReferenceValueAdditionalSpecification();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE:
				getBoundReferenceValue().clear();
				getBoundReferenceValue().addAll((Collection<? extends ReferenceableElement>)newValue);
				return;
			case MetamodelPackage.RANGE_BOUND__BOUND_TYPE:
				setBoundType((AttributeValueConstraintType)newValue);
				return;
			case MetamodelPackage.RANGE_BOUND__EXPRESSION:
				setExpression((String)newValue);
				return;
			case MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				getBoundReferenceValueAdditionalSpecification().clear();
				getBoundReferenceValueAdditionalSpecification().addAll((Collection<? extends InstancePointer>)newValue);
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
			case MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE:
				getBoundReferenceValue().clear();
				return;
			case MetamodelPackage.RANGE_BOUND__BOUND_TYPE:
				setBoundType(BOUND_TYPE_EDEFAULT);
				return;
			case MetamodelPackage.RANGE_BOUND__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				getBoundReferenceValueAdditionalSpecification().clear();
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
			case MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE:
				return boundReferenceValue != null && !boundReferenceValue.isEmpty();
			case MetamodelPackage.RANGE_BOUND__BOUND_TYPE:
				return boundType != BOUND_TYPE_EDEFAULT;
			case MetamodelPackage.RANGE_BOUND__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case MetamodelPackage.RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
				return boundReferenceValueAdditionalSpecification != null && !boundReferenceValueAdditionalSpecification.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (boundType: ");
		result.append(boundType);
		result.append(", expression: ");
		result.append(expression);
		result.append(')');
		return result.toString();
	}

} //RangeBoundImpl
