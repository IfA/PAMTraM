/**
 */
package pamtram.structure.constraint.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.EqualityConstraint;
import pamtram.structure.constraint.ValueConstraintType;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Equality Matcher</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.constraint.impl.EqualityConstraintImpl#isCaseSensitive <em>Case Sensitive</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EqualityConstraintImpl extends SingleReferenceValueConstraintImpl implements EqualityConstraint {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EqualityConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return ConstraintPackage.Literals.EQUALITY_CONSTRAINT;
	}

	@Override
	public boolean checkConstraint(String attrValue, String refValue) {

		String newAttrValue;
		String newRefValue;
		// if (this.caseSensitive) {
		newAttrValue = attrValue;
		newRefValue = refValue;
		// } else {
		// newAttrValue = attrValue.toLowerCase();
		// newRefValue = refValue.toLowerCase();
		// }
		// Update: EqualityConstraint useful for integer and doubles. The following example '1' versus. '1.0' represents
		// a
		// problem!
		// Therefore, in case of integer and double, we try to convert twice (to Double and back to String)
		try {
			newAttrValue = String.valueOf(Double.valueOf(newAttrValue));
		} catch (NumberFormatException e) {
			// doesn't work
		}
		try {
			newRefValue = String.valueOf(Double.valueOf(newRefValue));
		} catch (NumberFormatException e) {
			// doesn't work
		}

		return newRefValue.equals(newAttrValue) && this.type.equals(ValueConstraintType.REQUIRED)
				|| !newRefValue.equals(newAttrValue) && this.type.equals(ValueConstraintType.FORBIDDEN);
	}

} // EqualityConstraintImpl
