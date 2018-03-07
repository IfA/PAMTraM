/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import de.mfreund.gentrans.transformation.connecting.Length;

/**
 * A util class that helps calculating with {@link Length Lengths}.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class LengthCalculator {

	private LengthCalculator() {

	}

	public static Length add(Length... lengths) {

		return LengthCalculator.add(Arrays.asList(lengths));
	}

	public static Length add(List<Length> lengths) {

		if (LengthCalculator.containsUnboundedLength(lengths)) {
			return Length.UNBOUNDED;
		} else {
			return new Length(lengths.stream().mapToInt(Length::getValue).reduce(1, Math::multiplyExact));
		}
	}

	private static boolean containsUnboundedLength(Collection<Length> lengths) {

		return lengths.contains(Length.UNBOUNDED);
	}

	public static boolean greaterThan(Length length1, Length length2) {

		if (length1.isUnbounded()) {
			return !length2.isUnbounded();
		} else if (length2.isUnbounded()) {
			return false;
		} else {
			return length1.getValue() > length2.getValue();
		}
	}

	public static boolean greaterThanOrEqual(Length length1, Length length2) {

		if (length1.isUnbounded()) {
			return true;
		} else if (length2.isUnbounded()) {
			return false;
		} else {
			return length1.getValue() >= length2.getValue();
		}
	}
}
