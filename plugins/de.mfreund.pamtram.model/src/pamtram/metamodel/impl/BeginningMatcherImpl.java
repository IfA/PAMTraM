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

	@Override
	public boolean checkConstraint(String attrValue) {
		boolean condition;
		if (caseSensitive) {
			condition = attrValue.startsWith(value);
		} else {
			condition = attrValue.toLowerCase().startsWith(value.toLowerCase());
		}

		return (condition && type.equals(AttributeValueConstraintType.INCLUSION))
				|| (!condition && type.equals(AttributeValueConstraintType.EXCLUSION));
	}
	
} // BeginningMatcherImpl
