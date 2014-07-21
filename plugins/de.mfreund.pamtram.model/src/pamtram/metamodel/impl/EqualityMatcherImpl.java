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


	@Override
	public boolean checkConstraint(String attrValue) {
		String specValue;
		String newAttrValue;
		if (this.caseSensitive) {
			specValue = value;
			newAttrValue = attrValue;
		} else {
			specValue = this.value.toLowerCase();
			newAttrValue = attrValue.toLowerCase();
		}

		return (specValue.equals(newAttrValue) && this.type.equals(AttributeValueConstraintType.INCLUSION))
				|| (!specValue.equals(newAttrValue) && this.type.equals(AttributeValueConstraintType.EXCLUSION));
	}
	
	

} // EqualityMatcherImpl
