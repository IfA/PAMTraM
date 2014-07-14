/**
 */
package pamtram.metamodel.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.EndingMatcher;
import pamtram.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Ending Matcher</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class EndingMatcherImpl extends CaseSensitiveConstraintImpl implements
		EndingMatcher {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EndingMatcherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.ENDING_MATCHER;
	}

	/* (non-Javadoc)
	 * @see pamtram.metamodel.impl.AttributeValueSpecificationImpl#check(java.lang.String)
	 */
	@Override
	public boolean check(final String attr) {
		boolean condition;
		if (this.caseSensitive) {
			condition = attr.endsWith(value);
		} else {
			condition = attr.toLowerCase().endsWith(value.toLowerCase());
		}
		return (condition && type.equals(AttributeValueConstraintType.INCLUSION))
				|| (!condition && type.equals(AttributeValueConstraintType.EXCLUSION));

	}

} // EndingMatcherImpl
