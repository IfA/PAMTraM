/**
 */
package pamtram.metamodel.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.RegExMatcher;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Reg Ex Matcher</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RegExMatcherImpl extends AttributeValueConstraintImpl implements
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
		return MetamodelPackage.Literals.REG_EX_MATCHER;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pamtram.metamodel.impl.AttributeValueSpecificationImpl#check(java.lang
	 * .String)
	 */
	@Override
	public boolean check(final String attr) {
		boolean condition = attr.matches(this.value);
		return (condition && this.type.equals(AttributeValueConstraintType.INCLUSION))
				|| (!condition && this.type.equals(AttributeValueConstraintType.EXCLUSION));

	}

} // RegExMatcherImpl
