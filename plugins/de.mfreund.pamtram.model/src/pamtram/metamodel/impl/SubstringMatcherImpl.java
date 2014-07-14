/**
 */
package pamtram.metamodel.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SubstringMatcher;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Substring Matcher</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SubstringMatcherImpl extends CaseSensitiveConstraintImpl implements
		SubstringMatcher {
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

	/* (non-Javadoc)
	 * @see pamtram.metamodel.impl.AttributeValueSpecificationImpl#check(java.lang.String)
	 */
	@Override
	public boolean check(String attr) {
		boolean condition;
		if (caseSensitive) {
			condition = value.contains(attr);
		} else {
			condition = value.toLowerCase().contains(attr.toLowerCase());
		}

		return (condition && type.equals(AttributeValueConstraintType.INCLUSION))
				|| (!condition && type.equals(AttributeValueConstraintType.EXCLUSION));

	}

} // SubstringMatcherImpl
