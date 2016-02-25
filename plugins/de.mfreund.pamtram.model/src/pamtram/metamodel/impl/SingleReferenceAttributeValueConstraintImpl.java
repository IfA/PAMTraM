/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import pamtram.ReferenceableElement;

import pamtram.impl.NamedElementImpl;

import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SingleReferenceAttributeValueConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Reference Attribute Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.SingleReferenceAttributeValueConstraintImpl#getType <em>Type</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SingleReferenceAttributeValueConstraintImpl#getConstraintReferenceValue <em>Constraint Reference Value</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SingleReferenceAttributeValueConstraintImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SingleReferenceAttributeValueConstraintImpl extends NamedElementImpl implements SingleReferenceAttributeValueConstraint {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final AttributeValueConstraintType TYPE_EDEFAULT = AttributeValueConstraintType.INCLUSION;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected AttributeValueConstraintType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConstraintReferenceValue() <em>Constraint Reference Value</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintReferenceValue()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceableElement> constraintReferenceValue;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleReferenceAttributeValueConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueConstraintType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(AttributeValueConstraintType newType) {
		AttributeValueConstraintType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReferenceableElement> getConstraintReferenceValue() {
		if (constraintReferenceValue == null) {
			constraintReferenceValue = new EObjectResolvingEList<ReferenceableElement>(ReferenceableElement.class, this, MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE);
		}
		return constraintReferenceValue;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkConstraint(final String attrValue, final String refValue) {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SingleReferenceAttributeValueConstraint!checkConstraint(String,String)
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__TYPE:
				return getType();
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE:
				return getConstraintReferenceValue();
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__EXPRESSION:
				return getExpression();
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
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__TYPE:
				setType((AttributeValueConstraintType)newValue);
				return;
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE:
				getConstraintReferenceValue().clear();
				getConstraintReferenceValue().addAll((Collection<? extends ReferenceableElement>)newValue);
				return;
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__EXPRESSION:
				setExpression((String)newValue);
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
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE:
				getConstraintReferenceValue().clear();
				return;
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
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
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__TYPE:
				return type != TYPE_EDEFAULT;
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE:
				return constraintReferenceValue != null && !constraintReferenceValue.isEmpty();
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING:
				return checkConstraint((String)arguments.get(0), (String)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (type: ");
		result.append(type);
		result.append(", expression: ");
		result.append(expression);
		result.append(')');
		return result.toString();
	}

} //SingleReferenceAttributeValueConstraintImpl
