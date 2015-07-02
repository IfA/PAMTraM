/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import pamtram.impl.NamedElementImpl;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SubstringMatcher;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Substring Matcher</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.SubstringMatcherImpl#getType <em>Type</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SubstringMatcherImpl#getValue <em>Value</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SubstringMatcherImpl#isCaseSensitive <em>Case Sensitive</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubstringMatcherImpl extends NamedElementImpl implements
		SubstringMatcher {
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
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;
	/**
	 * The default value of the '{@link #isCaseSensitive() <em>Case Sensitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCaseSensitive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CASE_SENSITIVE_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isCaseSensitive() <em>Case Sensitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCaseSensitive()
	 * @generated
	 * @ordered
	 */
	protected boolean caseSensitive = CASE_SENSITIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SubstringMatcherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.SUBSTRING_MATCHER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SUBSTRING_MATCHER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SUBSTRING_MATCHER__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCaseSensitive(boolean newCaseSensitive) {
		boolean oldCaseSensitive = caseSensitive;
		caseSensitive = newCaseSensitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SUBSTRING_MATCHER__CASE_SENSITIVE, oldCaseSensitive, caseSensitive));
	}

	@Override
	public boolean checkConstraint(String attrValue) {
		boolean condition;
		if (caseSensitive) {
			condition = value.contains(attrValue);
		} else {
			condition = value.toLowerCase().contains(attrValue.toLowerCase());
		}

		return (condition && type.equals(AttributeValueConstraintType.INCLUSION))
				|| (!condition && type.equals(AttributeValueConstraintType.EXCLUSION));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.SUBSTRING_MATCHER__TYPE:
				return getType();
			case MetamodelPackage.SUBSTRING_MATCHER__VALUE:
				return getValue();
			case MetamodelPackage.SUBSTRING_MATCHER__CASE_SENSITIVE:
				return isCaseSensitive();
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
			case MetamodelPackage.SUBSTRING_MATCHER__TYPE:
				setType((AttributeValueConstraintType)newValue);
				return;
			case MetamodelPackage.SUBSTRING_MATCHER__VALUE:
				setValue((String)newValue);
				return;
			case MetamodelPackage.SUBSTRING_MATCHER__CASE_SENSITIVE:
				setCaseSensitive((Boolean)newValue);
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
			case MetamodelPackage.SUBSTRING_MATCHER__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case MetamodelPackage.SUBSTRING_MATCHER__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case MetamodelPackage.SUBSTRING_MATCHER__CASE_SENSITIVE:
				setCaseSensitive(CASE_SENSITIVE_EDEFAULT);
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
			case MetamodelPackage.SUBSTRING_MATCHER__TYPE:
				return type != TYPE_EDEFAULT;
			case MetamodelPackage.SUBSTRING_MATCHER__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case MetamodelPackage.SUBSTRING_MATCHER__CASE_SENSITIVE:
				return caseSensitive != CASE_SENSITIVE_EDEFAULT;
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
			case MetamodelPackage.SUBSTRING_MATCHER___CHECK_CONSTRAINT__STRING:
				return checkConstraint((String)arguments.get(0));
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
		result.append(", value: ");
		result.append(value);
		result.append(", caseSensitive: ");
		result.append(caseSensitive);
		result.append(')');
		return result.toString();
	}
	
	

} // SubstringMatcherImpl
