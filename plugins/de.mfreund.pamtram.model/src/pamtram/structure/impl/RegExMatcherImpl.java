/**
 */
package pamtram.structure.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.structure.StructurePackage;
import pamtram.structure.RegExMatcher;
import pamtram.structure.ValueConstraintType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Reg Ex Matcher</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class RegExMatcherImpl extends SingleReferenceValueConstraintImpl implements
		RegExMatcher {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RegExMatcherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.REG_EX_MATCHER;
	}

	@Override
	public boolean checkConstraint(String attrValue, String refValue) {
		boolean condition = attrValue.matches(refValue);
		return (condition && this.type.equals(ValueConstraintType.INCLUSION))
				|| (!condition && this.type.equals(ValueConstraintType.EXCLUSION));
	}
	
	

} // RegExMatcherImpl
