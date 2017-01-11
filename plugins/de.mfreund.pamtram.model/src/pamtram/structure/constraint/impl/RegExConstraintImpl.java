/**
 */
package pamtram.structure.constraint.impl;

import org.eclipse.emf.ecore.EClass;
import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.RegExConstraint;
import pamtram.structure.constraint.ValueConstraintType;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Reg Ex Matcher</b></em>'. <!-- end-user-doc
 * -->
 *
 * @generated
 */
public class RegExConstraintImpl extends SingleReferenceValueConstraintImpl implements RegExConstraint {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RegExConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.REG_EX_MATCHER;
	}

	@Override
	public boolean checkConstraint(String attrValue, String refValue) {

		boolean condition = attrValue.matches(refValue);
		return condition && this.type.equals(ValueConstraintType.INCLUSION)
				|| !condition && this.type.equals(ValueConstraintType.EXCLUSION);
	}

} // RegExConstraintImpl
