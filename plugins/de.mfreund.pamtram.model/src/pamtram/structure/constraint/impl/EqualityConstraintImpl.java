/**
 */
package pamtram.structure.constraint.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	 * @generated
	 */
	protected EqualityConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.EQUALITY_CONSTRAINT;
	}

	@Override
	public boolean checkConstraint(String attrValue, String refValue) {

		boolean condition = false;

		// First, try two compare two boolean values...
		//
		List<String> booleanTrueLiterals = Arrays.asList("true", "True", "1");
		List<String> booleanFalseLiterals = Arrays.asList("false", "False", "0");
		List<String> booleanLiterals = Stream.concat(booleanTrueLiterals.stream(), booleanFalseLiterals.stream())
				.collect(Collectors.toList());
		if (booleanLiterals.parallelStream().anyMatch(s -> s.equals(attrValue))
				&& booleanLiterals.parallelStream().anyMatch(s -> s.equals(refValue))) {

			boolean booleanAttrValue = booleanTrueLiterals.stream().anyMatch(l -> l.equals(attrValue));
			boolean booleanRefValue = booleanTrueLiterals.stream().anyMatch(l -> l.equals(refValue));

			condition = booleanAttrValue == booleanRefValue;
		}

		// If this did not work, try to compare two double values...
		//
		if (!condition) {
			try {
				double doubleAttrValue = Double.parseDouble(attrValue);
				double doubleRefValue = Double.parseDouble(refValue);

				condition = Double.compare(doubleAttrValue, doubleRefValue) == 0;
			} catch (NumberFormatException e) {
				// doesn't work
			}
		}

		// At last, we simply compare two String values...
		//
		if (!condition) {
			condition = refValue.equals(attrValue);
		}

		return condition && this.type.equals(ValueConstraintType.REQUIRED)
				|| !condition && this.type.equals(ValueConstraintType.FORBIDDEN);
	}

} // EqualityConstraintImpl
