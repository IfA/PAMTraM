/**
 */
package pamtram.metamodel.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.BeginningMatcher;
import pamtram.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Beginning Matcher</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BeginningMatcherImpl extends CaseSensitiveConstraintImpl implements
		BeginningMatcher {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected BeginningMatcherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.BEGINNING_MATCHER;
	}


	/* (non-Javadoc)
	 * @see pamtram.metamodel.impl.AttributeValueSpecificationImpl#check(java.lang.String)
	 */
	@Override
	public boolean check(final String attr) {
		boolean condition;
		if (caseSensitive) {
			condition = attr.startsWith(value);
		} else {
			condition = attr.toLowerCase().startsWith(value.toLowerCase());
		}

		return (condition && type.equals(AttributeValueConstraintType.INCLUSION))
				|| (!condition && type.equals(AttributeValueConstraintType.EXCLUSION));
	}

} // BeginningMatcherImpl
