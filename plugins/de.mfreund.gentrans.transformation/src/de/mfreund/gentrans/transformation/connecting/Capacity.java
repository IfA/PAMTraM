/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import java.util.Objects;

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
public class Capacity {

	public static final Capacity ZERO = new Capacity(0);

	public static final Capacity UNBOUNDED = new Capacity(-1);

	private final int value;

	/**
	 * Creates an instance based on a capacity value.
	 *
	 * @param value
	 *            The capacity value.
	 */
	public Capacity(int value) {

		this.value = value;
	}

	/**
	 * Creates an instance based on the upper bound of the given {@link EReference}.
	 *
	 * @param reference
	 *            The EReference.
	 */
	public Capacity(EReference reference) {

		this(reference.getUpperBound());
	}

	/**
	 * @return the {@link #value}
	 */
	public int getValue() {

		return this.value;
	}

	public boolean isUnbounded() {

		return Capacity.UNBOUNDED.equals(this);
	}

	public boolean isZero() {

		return Capacity.ZERO.equals(this);
	}

	@Override
	public boolean equals(Object obj) {

		return obj instanceof Capacity && ((Capacity) obj).value == this.value;
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.value);
	}

	@Override
	public String toString() {

		return String.valueOf(this.value);
	}
}
