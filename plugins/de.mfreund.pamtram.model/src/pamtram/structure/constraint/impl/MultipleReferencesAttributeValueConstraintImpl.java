/**
 */
package pamtram.structure.constraint.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.impl.NamedElementImpl;
import pamtram.structure.StructurePackage;
import pamtram.structure.constraint.MultipleReferencesValueConstraint;
import pamtram.structure.constraint.ValueConstraintType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiple References Attribute Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.constraint.impl.MultipleReferencesAttributeValueConstraintImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MultipleReferencesAttributeValueConstraintImpl extends NamedElementImpl implements MultipleReferencesValueConstraint {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ValueConstraintType TYPE_EDEFAULT = ValueConstraintType.INCLUSION;
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ValueConstraintType type = MultipleReferencesAttributeValueConstraintImpl.TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultipleReferencesAttributeValueConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return StructurePackage.Literals.MULTIPLE_REFERENCES_VALUE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueConstraintType getType() {
		return this.type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(ValueConstraintType newType) {
		ValueConstraintType oldType = this.type;
		this.type = newType == null ? MultipleReferencesAttributeValueConstraintImpl.TYPE_EDEFAULT : newType;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, StructurePackage.MULTIPLE_REFERENCES_VALUE_CONSTRAINT__TYPE, oldType, this.type));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean checkConstraint(final String attrValue, final EList<String> refValue) {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!MultipleReferencesAttributeValueConstraint!checkConstraint(String,http://www.eclipse.org/ocl/2015/Library!OrderedSet[String]_1)
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructurePackage.MULTIPLE_REFERENCES_VALUE_CONSTRAINT__TYPE:
				return this.getType();
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
			case StructurePackage.MULTIPLE_REFERENCES_VALUE_CONSTRAINT__TYPE:
				this.setType((ValueConstraintType)newValue);
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
			case StructurePackage.MULTIPLE_REFERENCES_VALUE_CONSTRAINT__TYPE:
				this.setType(MultipleReferencesAttributeValueConstraintImpl.TYPE_EDEFAULT);
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
			case StructurePackage.MULTIPLE_REFERENCES_VALUE_CONSTRAINT__TYPE:
				return this.type != MultipleReferencesAttributeValueConstraintImpl.TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case StructurePackage.MULTIPLE_REFERENCES_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_ELIST:
				return this.checkConstraint((String)arguments.get(0), (EList<String>)arguments.get(1));
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
		if (this.eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(this.type);
		result.append(')');
		return result.toString();
	}

} //MultipleReferencesAttributeValueConstraintImpl
