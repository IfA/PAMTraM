/**
 */
package pamtram.metamodel.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.EqualityMatcher;
import pamtram.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Equality Matcher</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class EqualityMatcherImpl extends CaseSensitiveConstraintImpl implements
		EqualityMatcher {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EqualityMatcherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.EQUALITY_MATCHER;
	}

	/* (non-Javadoc)
	 * @see pamtram.metamodel.impl.AttributeValueSpecificationImpl#check(java.lang.String)
	 */
	@Override
	public boolean check(final String attr) {
		String specValue;
		String attrValue;
		if (this.caseSensitive) {
			specValue = value;
			attrValue = attr;
		} else {
			specValue = this.value.toLowerCase();
			attrValue = attr.toLowerCase();
		}

		return (specValue.equals(attrValue) && this.type.equals(AttributeValueConstraintType.INCLUSION))
				|| (!specValue.equals(attrValue) && this.type.equals(AttributeValueConstraintType.EXCLUSION));
	}

} // EqualityMatcherImpl
