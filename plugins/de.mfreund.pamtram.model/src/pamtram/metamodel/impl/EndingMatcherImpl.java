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

	@Override
	public boolean checkConstraint(String attrValue) {
		boolean condition;
		if (this.caseSensitive) {
			condition = attrValue.endsWith(value);
		} else {
			condition = attrValue.toLowerCase().endsWith(value.toLowerCase());
		}
		return (condition && type.equals(AttributeValueConstraintType.INCLUSION))
				|| (!condition && type.equals(AttributeValueConstraintType.EXCLUSION));
	}
	

} // EndingMatcherImpl
