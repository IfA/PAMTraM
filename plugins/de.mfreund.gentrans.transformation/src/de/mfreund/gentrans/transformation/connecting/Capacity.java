/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import java.util.Collection;

import org.eclipse.emf.ecore.EReference;

/**
 * Instances of this class describe the 'capacity' of an {@link EClassConnectionPath} (i.e. how many elements can be
 * connected via the path).
 * <p />
 * This is basically just a wrapper for a simple integer. However, two special static instances {@link #ZERO} and
 * {@link #UNBOUNDED} are provided to simplify handling of special cases.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class Capacity extends UnsignedIntegerWithUnbounded {

	public static final Capacity ZERO = new Capacity(0);

	public static final Capacity UNBOUNDED = new Capacity(-1);

	private Capacity(int value) {

		super(value);
	}

	/**
	 * Returns a {@link Capacity} instance representing the given value.
	 */
	public static Capacity valueOf(int value) {

		if (Capacity.UNBOUNDED.getValue() == value) {
			return Capacity.UNBOUNDED;
		} else if (Capacity.ZERO.getValue() == value) {
			return Capacity.ZERO;
		} else {
			return new Capacity(value);
		}
	}

	/**
	 * Returns a {@link Capacity} instance representing the (upper bound of) the given {@link EReference}.
	 */
	public static Capacity valueOf(EReference reference) {

		return Capacity.valueOf(reference.getUpperBound());
	}

	/**
	 * Returns a {@link Capacity} instance representing the size of the given {@link Collection}.
	 */
	public static Capacity valueOf(Collection<?> collection) {

		return Capacity.valueOf(collection.size());
	}

	public boolean isZero() {

		return Capacity.ZERO.equals(this);
	}

	public boolean isSufficientFor(Capacity requiredCapacity) {

		return this.compareTo(requiredCapacity) >= 0;
	}

}
