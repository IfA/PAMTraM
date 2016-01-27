/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import pamtram.impl.NamedElementImpl;

import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.MultipleReferencesAttributeValueConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiple References Attribute Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class MultipleReferencesAttributeValueConstraintImpl extends NamedElementImpl implements MultipleReferencesAttributeValueConstraint {
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
		return MetamodelPackage.Literals.MULTIPLE_REFERENCES_ATTRIBUTE_VALUE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkConstraint(final String attrValue) {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!AttributeValueConstraint!checkConstraint(String)
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MetamodelPackage.MULTIPLE_REFERENCES_ATTRIBUTE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING:
				return checkConstraint((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //MultipleReferencesAttributeValueConstraintImpl
